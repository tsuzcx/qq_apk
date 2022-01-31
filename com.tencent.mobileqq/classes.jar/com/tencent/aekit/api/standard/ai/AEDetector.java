package com.tencent.aekit.api.standard.ai;

import android.graphics.Bitmap;
import android.opengl.EGL14;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.plugin.core.AEDetectorType;
import com.tencent.aekit.plugin.core.AIAttr;
import com.tencent.aekit.plugin.core.AIAttrProvider;
import com.tencent.aekit.plugin.core.AIDataSet;
import com.tencent.aekit.plugin.core.AIDataStorage;
import com.tencent.aekit.plugin.core.AIDetectorRecord;
import com.tencent.aekit.plugin.core.AIInput;
import com.tencent.aekit.plugin.core.AIInput.DataSize;
import com.tencent.aekit.plugin.core.AIParam;
import com.tencent.aekit.plugin.core.IDetect;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.baseutils.api.ApiHelper;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.baseutils.report.ReportUtil;
import com.tencent.ttpic.baseutils.thread.HandlerThreadManager;
import com.tencent.ttpic.model.SizeI;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.PTFaceDetector;
import com.tencent.ttpic.openapi.facedetect.FaceDetector;
import com.tencent.ttpic.openapi.facedetect.FaceParams;
import com.tencent.ttpic.openapi.filter.SimpleGLThread;
import com.tencent.ttpic.openapi.model.FaceActionCounter;
import com.tencent.ttpic.openapi.plugin.AICtrl;
import com.tencent.ttpic.openapi.ttpicmodule.AEGlobalBoard;
import com.tencent.ttpic.openapi.ttpicmodule.AEGlobalBoard.PTStatus;
import com.tencent.ttpic.openapi.util.FaceDetectUtil;
import com.tencent.ttpic.openapi.util.RetrieveDataManager;
import com.tencent.ttpic.openapi.util.RetrieveDataManager.DATA_TYPE;
import com.tencent.ttpic.openapi.util.youtu.VideoPreviewFaceOutlineDetector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class AEDetector
{
  private static final String TAG = "AEDetector";
  private AIDataStorage aiDataStorage = new AIDataStorage();
  private SimpleGLThread aiDetectGLThread;
  private BaseFilter copyFilter;
  private Frame[] copyFrames = new Frame[2];
  private AIAttr curAIAttr = null;
  private SizeI curTextureSize = new SizeI(-1, -1);
  private Frame dataFrame;
  private Map<String, String> detectorHandlerNames = new Hashtable();
  private Map<String, Handler> detectorHandlers = new Hashtable();
  private Map<String, Boolean> detectorInitState = new Hashtable();
  private Map<String, Object> detectorLocks = new Hashtable();
  private Map<String, AIDetectorRecord> detectorRecords = new Hashtable();
  private Map<String, Boolean> detectorRunnings = new Hashtable();
  private List<IDetect> detectors = new ArrayList();
  private SimpleGLThread faceDetectGLThread;
  private int frameIdx = 0;
  private boolean isInited = false;
  private AIAttr lastAIAttr = null;
  private SizeI lastTextureSize = new SizeI(-1, -1);
  private int mBufferTextureIdA;
  private int mBufferTextureIdB;
  private int mDetectBeforeId;
  private int mDetectDoneId;
  private PTFaceDetector mFaceDetector;
  private Map<Float, byte[]> scaledBytes = new Hashtable();
  private Map<AIInput.DataSize, byte[]> sizedBytes = new Hashtable();
  
  private void clearActionCounter()
  {
    if (this.mFaceDetector != null)
    {
      this.mFaceDetector.getFaceDetector().clearActionCounter();
      LogUtils.i("AEDetector", "AEDetector clearActionCounter");
    }
  }
  
  public static List<FaceParams> doPicFaceDetect(Bitmap paramBitmap, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    return FaceDetectUtil.doPicFaceDetect(paramBitmap, paramBoolean1, paramBoolean2, paramInt);
  }
  
  private Map<String, Boolean> getModulesOn(AICtrl paramAICtrl)
  {
    HashMap localHashMap = new HashMap();
    if (this.detectors != null)
    {
      Iterator localIterator = this.detectors.iterator();
      while (localIterator.hasNext())
      {
        IDetect localIDetect = (IDetect)localIterator.next();
        localHashMap.put(localIDetect.getModuleType(), Boolean.valueOf(paramAICtrl.isModuleOn(localIDetect.getModuleType())));
      }
    }
    return localHashMap;
  }
  
  private void resetModuleRecord(String paramString)
  {
    AIDetectorRecord localAIDetectorRecord = (AIDetectorRecord)this.detectorRecords.get(paramString);
    if (localAIDetectorRecord != null)
    {
      localAIDetectorRecord.reset();
      this.detectorRecords.put(paramString, localAIDetectorRecord);
    }
  }
  
  private final byte[] scaleBytesInput(Frame paramFrame, Float paramFloat)
  {
    if ((paramFloat != null) && (paramFloat.floatValue() > 0.0F))
    {
      if (this.scaledBytes.get(paramFloat) != null) {
        return (byte[])this.scaledBytes.get(paramFloat);
      }
      paramFrame = RetrieveDataManager.getInstance().retrieveData(RetrieveDataManager.DATA_TYPE.RGBA.value, paramFrame.getTextureId(), (int)(paramFrame.width * paramFloat.floatValue()), (int)(paramFrame.height * paramFloat.floatValue()));
      this.scaledBytes.put(paramFloat, paramFrame);
      return paramFrame;
    }
    return null;
  }
  
  private final byte[] sizedBytesInput(Frame paramFrame, AIInput.DataSize paramDataSize)
  {
    if ((paramFrame != null) && (paramDataSize.width > 0) && (paramDataSize.height > 0))
    {
      if (this.sizedBytes.get(paramDataSize) != null) {
        return (byte[])this.sizedBytes.get(paramDataSize);
      }
      this.copyFilter.RenderProcess(paramFrame.getTextureId(), paramDataSize.width, paramDataSize.height, -1, 0.0D, this.dataFrame);
      paramFrame = RetrieveDataManager.getInstance().retrieveData(RetrieveDataManager.DATA_TYPE.RGBA.value, this.dataFrame.getTextureId(), paramDataSize.width, paramDataSize.height);
      this.sizedBytes.put(paramDataSize, paramFrame);
      return paramFrame;
    }
    return null;
  }
  
  private boolean skipModule(String paramString, Integer paramInteger)
  {
    paramString = (AIDetectorRecord)this.detectorRecords.get(paramString);
    return (paramString != null) && (paramInteger != null) && (paramInteger.intValue() > 1) && (paramString.count % paramInteger.intValue() != 1);
  }
  
  private void updateAIAttr(AICtrl paramAICtrl, AIAttr paramAIAttr)
  {
    Iterator localIterator = this.detectors.iterator();
    while (localIterator.hasNext())
    {
      IDetect localIDetect = (IDetect)localIterator.next();
      String str = localIDetect.getModuleType();
      if ((paramAICtrl.isModuleOn(str)) && (!str.equals(AEDetectorType.FACE.value))) {
        localIDetect.updateAIAttr(paramAIAttr);
      }
    }
  }
  
  private void updateDetectors(AICtrl paramAICtrl)
  {
    if (this.isInited) {}
    label525:
    label527:
    for (;;)
    {
      Object localObject2;
      Object localObject3;
      Object localObject4;
      try
      {
        localObject2 = AIManager.getDetectorSet().iterator();
        if (((Iterator)localObject2).hasNext())
        {
          localObject3 = (Class)((Iterator)localObject2).next();
          localObject1 = (IDetect)((Class)localObject3).newInstance();
          if (!(localObject1 instanceof PTFaceDetector)) {
            break label527;
          }
          localObject1 = this.mFaceDetector;
          localObject4 = ((IDetect)localObject1).getModuleType();
          if ((!paramAICtrl.isModuleOn((String)localObject4)) || ((this.detectorInitState.get(localObject4) != null) && (((Boolean)this.detectorInitState.get(localObject4)).booleanValue()))) {
            continue;
          }
          boolean bool = ((IDetect)localObject1).init();
          this.detectors.add(localObject1);
          LogUtils.d("AEDetector", "Module " + ((Class)localObject3).getSimpleName() + " init =" + bool);
          localObject3 = ((IDetect)localObject1).getModuleType();
          if (!((String)localObject3).equals(AEDetectorType.FACE.value))
          {
            localObject4 = (String)localObject3 + System.currentTimeMillis();
            Object localObject5 = new HandlerThread((String)localObject4, 10);
            ((HandlerThread)localObject5).start();
            localObject5 = new Handler(((HandlerThread)localObject5).getLooper());
            this.detectorHandlers.put(localObject3, localObject5);
            this.detectorHandlerNames.put(localObject3, localObject4);
          }
          this.detectorLocks.put(localObject3, new Object());
          this.detectorRunnings.put(localObject3, Boolean.valueOf(false));
          this.detectorRecords.put(localObject3, new AIDetectorRecord());
          this.detectorInitState.put(localObject3, Boolean.valueOf(true));
          this.aiDataStorage.put((IDetect)localObject1);
          continue;
          return;
        }
      }
      catch (Exception paramAICtrl)
      {
        paramAICtrl.getMessage();
      }
      paramAICtrl = new ArrayList();
      Object localObject1 = this.detectors.iterator();
      for (;;)
      {
        if (((Iterator)localObject1).hasNext())
        {
          localObject2 = (IDetect)((Iterator)localObject1).next();
          localObject3 = AIManager.getDetectorSet().iterator();
          do
          {
            if (!((Iterator)localObject3).hasNext()) {
              break;
            }
            localObject4 = (Class)((Iterator)localObject3).next();
          } while (!localObject2.getClass().getSimpleName().equals(((Class)localObject4).getSimpleName()));
        }
        for (int i = 0;; i = 1)
        {
          if (i == 0) {
            break label525;
          }
          localObject3 = ((IDetect)localObject2).getModuleType();
          paramAICtrl.add(localObject2);
          ((Handler)this.detectorHandlers.get(localObject3)).post(new AEDetector.5(this, (IDetect)localObject2, (String)localObject3));
          break;
          this.detectors.removeAll(paramAICtrl);
          return;
        }
      }
    }
  }
  
  private void updateModuleRecord(String paramString)
  {
    AIDetectorRecord localAIDetectorRecord = (AIDetectorRecord)this.detectorRecords.get(paramString);
    if (localAIDetectorRecord != null)
    {
      localAIDetectorRecord.update();
      this.detectorRecords.put(paramString, localAIDetectorRecord);
    }
  }
  
  private void updateTextureSize(int paramInt1, int paramInt2)
  {
    SizeI localSizeI = this.lastTextureSize;
    if (this.curTextureSize.width > 0)
    {
      i = this.curTextureSize.width;
      localSizeI.width = i;
      localSizeI = this.lastTextureSize;
      if (this.curTextureSize.height <= 0) {
        break label82;
      }
    }
    label82:
    for (int i = this.curTextureSize.height;; i = paramInt2)
    {
      localSizeI.height = i;
      this.curTextureSize.width = paramInt1;
      this.curTextureSize.height = paramInt2;
      return;
      i = paramInt1;
      break;
    }
  }
  
  public int clear()
  {
    if (!this.isInited) {
      return 0;
    }
    int i;
    if (this.detectorHandlers != null) {
      i = this.detectorHandlers.size() + 2;
    }
    for (;;)
    {
      CountDownLatch localCountDownLatch = new CountDownLatch(i);
      if (this.faceDetectGLThread != null) {
        this.faceDetectGLThread.destroy(new AEDetector.1(this, localCountDownLatch));
      }
      if (this.aiDetectGLThread != null) {
        this.aiDetectGLThread.destroy(new AEDetector.2(this, localCountDownLatch));
      }
      int[] arrayOfInt = new int[2];
      arrayOfInt[0] = this.mBufferTextureIdA;
      arrayOfInt[1] = this.mBufferTextureIdB;
      GLES20.glDeleteTextures(arrayOfInt.length, arrayOfInt, 0);
      this.copyFilter.ClearGLSL();
      if (!this.copyFrames[0].unlock()) {
        this.copyFrames[0].clear();
      }
      if (!this.copyFrames[1].unlock()) {
        this.copyFrames[1].clear();
      }
      this.lastTextureSize.width = -1;
      this.lastTextureSize.height = -1;
      this.curTextureSize.width = -1;
      this.curTextureSize.height = -1;
      try
      {
        localCountDownLatch.await(HandlerThreadManager.THREAD_DESTROY_TIME_OUT_MILLS, TimeUnit.MILLISECONDS);
        if (this.detectorHandlers != null) {
          this.detectorHandlers.clear();
        }
        AIManager.clear();
        AEGlobalBoard.writeBoard(AEGlobalBoard.PTStatus.PTAIDETECTOR_CLEAN, 0);
        this.isInited = false;
        return 0;
        i = 2;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          ReportUtil.report("AEDetector destroy time out!");
        }
      }
    }
  }
  
  public AIAttr detectFrame(AIInput paramAIInput, AIParam paramAIParam, AICtrl paramAICtrl)
  {
    if ((!paramAICtrl.hasModuleOn()) || (!ApiHelper.hasJellyBeanMR1()))
    {
      LogUtils.i("AEDetector", "AEDetector detectFrame hasNoModuleOn");
      return null;
    }
    this.lastAIAttr = this.curAIAttr;
    this.lastAIAttr.setNextSurfaceTime(paramAIParam.getSurfaceTime());
    if (this.lastAIAttr.getOutTexture() < 0)
    {
      this.lastAIAttr.setOutTexture(paramAIInput.getInputTexture());
      PTFaceAttr.EmptyFaceAttr.setTimeStamp(System.currentTimeMillis());
      this.lastAIAttr.setFaceAttr(PTFaceAttr.EmptyFaceAttr);
    }
    updateDetectors(paramAICtrl);
    this.curAIAttr = detectFrame(paramAIInput, paramAIParam, paramAICtrl, this.aiDataStorage.genNewAIDataSet(getModulesOn(paramAICtrl)));
    this.curAIAttr.setSurfaceTime(paramAIParam.getSurfaceTime());
    updateAIAttr(paramAICtrl, this.lastAIAttr);
    return this.lastAIAttr;
  }
  
  public AIAttr detectFrame(AIInput paramAIInput, AIParam paramAIParam, AICtrl paramAICtrl, AIDataSet paramAIDataSet)
  {
    if ((!paramAICtrl.hasModuleOn()) || (!ApiHelper.hasJellyBeanMR1()))
    {
      LogUtils.i("AEDetector", "AEDetector detectFrame hasNoModuleOn");
      return null;
    }
    int i = paramAIParam.getWidth();
    int j = paramAIParam.getHeight();
    updateTextureSize(i, j);
    this.copyFilter.RenderProcess(paramAIInput.getInputTexture(), i, j, -1, 0.0D, this.copyFrames[this.frameIdx]);
    GLES20.glFinish();
    AIAttr localAIAttr = new AIAttr(new AIAttrProvider(paramAIDataSet));
    localAIAttr.setOutTexture(this.copyFrames[this.frameIdx].getTextureId());
    paramAIInput.setInput("frame", this.copyFrames[this.frameIdx]);
    paramAIParam.setAIAttr(localAIAttr);
    this.frameIdx = ((this.frameIdx + 1) % 2);
    this.faceDetectGLThread.postJob(new AEDetector.3(this, paramAICtrl, paramAIInput, paramAIParam, paramAIDataSet));
    this.aiDetectGLThread.postJob(new AEDetector.4(this, paramAICtrl, paramAIInput, paramAIParam, paramAIDataSet));
    return localAIAttr;
  }
  
  public AIAttr getAIAttr()
  {
    return this.lastAIAttr;
  }
  
  public Map<Integer, FaceActionCounter> getActionCounter()
  {
    if (this.mFaceDetector != null) {
      return this.mFaceDetector.getFaceDetector().getFaceActionCounter();
    }
    return null;
  }
  
  public PTFaceDetector getFaceDetector()
  {
    if (this.mFaceDetector != null) {
      return this.mFaceDetector;
    }
    return null;
  }
  
  public SizeI getOutTextureSize()
  {
    return this.lastTextureSize;
  }
  
  public float getRotation()
  {
    if (this.mFaceDetector != null) {
      return this.mFaceDetector.getFaceDetector().getPhotoAngle();
    }
    return 0.0F;
  }
  
  public int init()
  {
    if (!this.isInited) {}
    try
    {
      if (ApiHelper.hasJellyBeanMR1())
      {
        this.aiDetectGLThread = new SimpleGLThread(EGL14.eglGetCurrentContext(), "AIDetectGLThread" + System.currentTimeMillis());
        this.faceDetectGLThread = new SimpleGLThread(EGL14.eglGetCurrentContext(), "FaceDetectGLThread" + System.currentTimeMillis());
      }
      this.mFaceDetector = new PTFaceDetector();
      this.mFaceDetector.init();
      clearActionCounter();
      this.detectors.clear();
      localObject = new int[2];
      GLES20.glGenTextures(localObject.length, (int[])localObject, 0);
      this.mBufferTextureIdA = localObject[0];
      this.mBufferTextureIdB = localObject[1];
      this.mDetectDoneId = this.mBufferTextureIdB;
      this.mDetectBeforeId = -1;
      this.copyFilter = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
      this.copyFilter.apply();
      this.copyFrames[0] = new Frame();
      this.copyFrames[1] = new Frame();
      this.dataFrame = new Frame();
      if (AIManager.getDetectClass(AEDetectorType.FACE) == null) {
        AIManager.installDetector(PTFaceDetector.class);
      }
      this.aiDataStorage.clear();
      this.curAIAttr = new AIAttr(new AIAttrProvider(null));
      this.lastAIAttr = new AIAttr(new AIAttrProvider(null));
      this.isInited = true;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject;
        localException.getMessage();
        continue;
        int i = -1;
      }
    }
    this.lastTextureSize.width = -1;
    this.lastTextureSize.height = -1;
    this.curTextureSize.width = -1;
    this.curTextureSize.height = -1;
    localObject = AEGlobalBoard.PTStatus.PTAIDETECTOR_INIT;
    if (this.isInited)
    {
      i = 0;
      AEGlobalBoard.writeBoard((AEGlobalBoard.PTStatus)localObject, i);
      LogUtils.i("AEDetector", "AEDetector init ret = " + this.isInited);
      if (!this.isInited) {
        break label379;
      }
      return 0;
    }
    label379:
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.aekit.api.standard.ai.AEDetector
 * JD-Core Version:    0.7.0.1
 */