package com.tencent.aelight.camera.ae.play;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.FrameBufferCache;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.aelight.camera.ae.download.AEResUtil;
import com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem.Pair;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.device.DeviceUtils;
import com.tencent.ttpic.filter.CFFaceOffFilter;
import com.tencent.ttpic.filter.CFSkinCropFilter;
import com.tencent.ttpic.filter.CFSkinCropFilterV2;
import com.tencent.ttpic.model.SizeI;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.filter.SimpleGLThread;
import com.tencent.ttpic.openapi.initializer.LightSdkInitializer;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import com.tencent.ttpic.openapi.model.CosFunParam;
import com.tencent.ttpic.openapi.model.CrazyFaceDataTemplate;
import com.tencent.ttpic.openapi.model.FaceImageLayer;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.util.AEStaticDetector;
import com.tencent.ttpic.openapi.util.CfTemplateParser;
import com.tencent.ttpic.util.AlgoUtils;
import com.tencent.ttpic.util.CosFunUtil;
import com.tencent.ttpic.util.FaceOffUtil;
import com.tencent.view.RendererUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class FaceChangeUtils
{
  private static final String TAG = "FaceChangeUtils";
  
  public static void change(Bitmap paramBitmap, String paramString, FaceChangeUtils.ChangeFaceSingleCallback paramChangeFaceSingleCallback)
  {
    if ((paramBitmap != null) && (paramString != null))
    {
      runInGLThread(new FaceChangeUtils.1(paramChangeFaceSingleCallback, paramBitmap, paramString), false, "GLThread-changeFaceSingle");
      return;
    }
    LogUtils.e("FaceChangeUtils", "change---null parameters: userFace, materialDir");
    paramBitmap = new StringBuilder();
    paramBitmap.append("null parameters, material=");
    paramBitmap.append(paramString);
    paramChangeFaceSingleCallback.onResult(FaceChangeUtils.ChangeFaceResult.access$000(-1, paramBitmap.toString()));
  }
  
  public static void change(Bitmap paramBitmap, List<String> paramList, FaceChangeUtils.ChangeFaceBatchCallback paramChangeFaceBatchCallback)
  {
    if ((paramBitmap != null) && (paramList != null) && (!paramList.isEmpty()))
    {
      runInGLThread(new FaceChangeUtils.2(paramList, paramBitmap, paramChangeFaceBatchCallback), false, "GLThread-changeFaceBatch");
      return;
    }
    LogUtils.e("FaceChangeUtils", "change---null parameters: userFace, materialDir");
    paramChangeFaceBatchCallback.onResult(new ArrayList());
  }
  
  private static FaceChangeUtils.ChangeFaceResult changeFaceInternal(Bitmap paramBitmap, String paramString)
  {
    if ((paramBitmap != null) && (paramString != null))
    {
      Object localObject1 = paramString.split("/");
      localObject1 = localObject1[(localObject1.length - 1)];
      Object localObject2 = CfTemplateParser.parseCrazyFace(FileUtils.getRealPath(paramString), (String)localObject1);
      if (localObject2 == null)
      {
        paramBitmap = new StringBuilder();
        paramBitmap.append("changeFaceInternal---failed to parse CrazyFace: ");
        paramBitmap.append(paramString);
        AEQLog.d("FaceChangeUtils", paramBitmap.toString());
        paramBitmap = new StringBuilder();
        paramBitmap.append("failed to parse material, material=");
        paramBitmap.append(paramString);
        return FaceChangeUtils.ChangeFaceResult.access$000(-2, paramBitmap.toString());
      }
      localObject1 = detectFace(paramBitmap);
      if ((localObject1 != null) && (((PTFaceAttr)localObject1).getAllFacePoints() != null) && (!((PTFaceAttr)localObject1).getAllFacePoints().isEmpty()))
      {
        Object localObject3 = getMaxFacePoints(((PTFaceAttr)localObject1).getAllFacePoints(), ((PTFaceAttr)localObject1).getFaceDetectScale());
        if (((List)localObject3).isEmpty())
        {
          AEQLog.d("FaceChangeUtils", "changeFaceInternal---userFacePointsList is empty");
          return FaceChangeUtils.ChangeFaceResult.access$000(-4, "no face points");
        }
        localObject1 = ((CrazyFaceDataTemplate)localObject2).faceLayers;
        int j = RendererUtils.createTexture(paramBitmap);
        ArrayList localArrayList = new ArrayList();
        int i = 0;
        Object localObject4;
        while (i < ((List)localObject1).size())
        {
          localObject4 = (FaceImageLayer)((List)localObject1).get(i);
          localArrayList.add(processUserBitmap(j, paramBitmap.getWidth(), paramBitmap.getHeight(), VideoMaterial.copyList((List)localObject3), (FaceImageLayer)localObject4, (CrazyFaceDataTemplate)localObject2));
          i += 1;
        }
        paramBitmap = initMaxLength();
        localObject3 = ((CrazyFaceDataTemplate)localObject2).getFaceLayer(0);
        i = (int)Math.min(((FaceImageLayer)localObject3).width, paramBitmap.width);
        int k = (int)Math.min(((FaceImageLayer)localObject3).height, paramBitmap.height);
        double d1 = i;
        double d2 = ((FaceImageLayer)localObject3).width;
        Double.isNaN(d1);
        d1 /= d2;
        d2 = k;
        double d3 = ((FaceImageLayer)localObject3).height;
        Double.isNaN(d2);
        d1 = Math.min(d1, d2 / d3);
        k = (int)(((FaceImageLayer)localObject3).width * d1);
        int m = (int)(((FaceImageLayer)localObject3).height * d1);
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(((CrazyFaceDataTemplate)localObject2).folderPath);
        ((StringBuilder)localObject3).append(File.separator);
        ((StringBuilder)localObject3).append(((CrazyFaceDataTemplate)localObject2).getFaceLayer(0).imagePath);
        paramBitmap = FaceOffUtil.getFaceBitmap(((StringBuilder)localObject3).toString(), paramBitmap.width, paramBitmap.height);
        int n = RendererUtils.createTexture(paramBitmap);
        BitmapUtils.recycle(paramBitmap);
        paramBitmap = new Frame(0, n, paramBitmap.getWidth(), paramBitmap.getHeight());
        localObject2 = new CFFaceOffFilter(paramString);
        ((CFFaceOffFilter)localObject2).updateVideoSize(k, m, d1);
        ((CFFaceOffFilter)localObject2).ApplyGLSLFilter();
        localObject3 = new VideoFilterBase("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
        ((VideoFilterBase)localObject3).ApplyGLSLFilter();
        i = 0;
        while (i < ((List)localObject1).size())
        {
          paramString = FrameBufferCache.getInstance().get(k, m);
          ((VideoFilterBase)localObject3).RenderProcess(paramBitmap.getTextureId(), k, m, -1, 0.0D, paramString);
          localObject4 = (CosFunParam)localArrayList.get(i);
          FaceImageLayer localFaceImageLayer = (FaceImageLayer)((List)localObject1).get(i);
          ((CFFaceOffFilter)localObject2).setFaceLayer(localFaceImageLayer);
          ((CFFaceOffFilter)localObject2).setUserFaceTex(((CosFunParam)localObject4).mFaceTexture);
          ((CFFaceOffFilter)localObject2).setSkinColorParams((CosFunParam)localObject4);
          ((CFFaceOffFilter)localObject2).setFacePointsInfo(((CosFunParam)localObject4).mUserFacePointsList, ((CosFunParam)localObject4).mWidth, ((CosFunParam)localObject4).mHeight, localFaceImageLayer.faceTriangleID);
          ((CFFaceOffFilter)localObject2).RenderProcess(paramBitmap.getTextureId(), paramString.width, paramString.height, -1, 0.0D, paramString);
          if (!paramBitmap.unlock()) {
            paramBitmap.clear();
          }
          i += 1;
          paramBitmap = paramString;
        }
        ((CFFaceOffFilter)localObject2).clearGLSLSelf();
        ((VideoFilterBase)localObject3).clearGLSLSelf();
        paramString = RendererUtils.saveTexture(paramBitmap);
        if (!paramBitmap.unlock()) {
          paramBitmap.clear();
        }
        RendererUtils.clearTexture(j);
        RendererUtils.clearTexture(n);
        i = 0;
        while (i < ((List)localObject1).size())
        {
          RendererUtils.clearTexture(((CosFunParam)localArrayList.get(i)).mFaceTexture);
          i += 1;
        }
        AEQLog.b("FaceChangeUtils", "success : + result");
        return FaceChangeUtils.ChangeFaceResult.access$200(paramString);
      }
      AEQLog.d("FaceChangeUtils", "changeFaceInternal---failed to detect face");
      return FaceChangeUtils.ChangeFaceResult.access$000(-3, "failed to detect face");
    }
    AEQLog.d("FaceChangeUtils", "changeFaceInternal---null parameters: userFace, materialDir");
    paramBitmap = new StringBuilder();
    paramBitmap.append("null parameters, material=");
    paramBitmap.append(paramString);
    return FaceChangeUtils.ChangeFaceResult.access$000(-1, paramBitmap.toString());
  }
  
  public static void cropFace(Bitmap paramBitmap, FaceChangeUtils.CropFaceCallback paramCropFaceCallback)
  {
    cropFace(paramBitmap, paramCropFaceCallback, false);
  }
  
  public static void cropFace(Bitmap paramBitmap, FaceChangeUtils.CropFaceCallback paramCropFaceCallback, boolean paramBoolean)
  {
    if (paramCropFaceCallback == null) {
      return;
    }
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      runInGLThread(new FaceChangeUtils.6(paramBitmap, paramCropFaceCallback), paramBoolean, "GLThread-cropFace");
      return;
    }
    paramCropFaceCallback.onFail(-3);
  }
  
  private static void cropFaceInternal(Bitmap paramBitmap, FaceChangeUtils.CropFaceCallback paramCropFaceCallback)
  {
    Object localObject1 = detectFace(paramBitmap);
    if ((localObject1 != null) && (((PTFaceAttr)localObject1).getAllFacePoints() != null) && (!((PTFaceAttr)localObject1).getAllFacePoints().isEmpty()))
    {
      Object localObject3 = getMaxFacePoints(((PTFaceAttr)localObject1).getAllFacePoints(), ((PTFaceAttr)localObject1).getFaceDetectScale());
      localObject1 = (PointF)((List)localObject3).get(101);
      Object localObject2 = (PointF)((List)localObject3).get(99);
      PointF localPointF = (PointF)((List)localObject3).get(105);
      localObject3 = (PointF)((List)localObject3).get(103);
      int i = (int)AlgoUtils.getDistance((PointF)localObject2, localPointF);
      int j = (int)AlgoUtils.getDistance((PointF)localObject2, (PointF)localObject1);
      int k = paramBitmap.getWidth();
      int m = paramBitmap.getHeight();
      float f1 = ((PointF)localObject2).x;
      float f2 = k;
      f1 /= f2;
      float f4 = ((PointF)localObject2).y;
      float f3 = m;
      f4 /= f3;
      float f5 = ((PointF)localObject1).x / f2;
      float f6 = ((PointF)localObject1).y / f3;
      float f7 = ((PointF)localObject3).x / f2;
      float f8 = ((PointF)localObject3).y / f3;
      f2 = localPointF.x / f2;
      f3 = localPointF.y / f3;
      localObject1 = new VideoFilterBase("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
      ((VideoFilterBase)localObject1).ApplyGLSLFilter();
      ((VideoFilterBase)localObject1).setTexCords(new float[] { f1, f4, f5, f6, f7, f8, f2, f3 });
      k = RendererUtils.createTexture(paramBitmap);
      m = RendererUtils.createTexture();
      paramBitmap = FrameBufferCache.getInstance().get(i, j);
      ((VideoFilterBase)localObject1).RenderProcess(k, i, j, m, 0.0D, paramBitmap);
      localObject2 = RendererUtils.saveTexture(m, i, j);
      paramBitmap.unlock();
      ((VideoFilterBase)localObject1).clearGLSLSelf();
      RendererUtils.clearTexture(k);
      RendererUtils.clearTexture(m);
      paramCropFaceCallback.onSuccess((Bitmap)localObject2);
      return;
    }
    paramCropFaceCallback.onFail(-2);
  }
  
  public static DynamicTextItem.Pair<Integer, List<PointF>> detectBiggestFaceInGLThread(Bitmap paramBitmap)
  {
    PTFaceAttr[] arrayOfPTFaceAttr = new PTFaceAttr[1];
    DynamicTextItem.Pair localPair = new DynamicTextItem.Pair(Integer.valueOf(0), null);
    runInGLThread(new FaceChangeUtils.4(arrayOfPTFaceAttr, paramBitmap, localPair), true, "GLThread-checkHasFaceInPic");
    return localPair;
  }
  
  public static PTFaceAttr detectFace(Bitmap paramBitmap)
  {
    return detectFace(paramBitmap, 0.1666666666666667D);
  }
  
  public static PTFaceAttr detectFace(Bitmap paramBitmap, double paramDouble)
  {
    if (!FeatureManager.Features.LIGHT_SDK.isFunctionReady())
    {
      AEQLog.d("FaceChangeUtils", "light sdk so not ready.");
      boolean bool = FeatureManager.Features.LIGHT_SDK.init();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("load result: ");
      localStringBuilder.append(bool);
      AEQLog.b("FaceChangeUtils", localStringBuilder.toString());
    }
    AEStaticDetector.initDetector(AEResUtil.n());
    return AEStaticDetector.detectFace(paramBitmap);
  }
  
  public static PTFaceAttr detectFaceOrigin(Bitmap paramBitmap)
  {
    return detectFace(paramBitmap, 1.0D);
  }
  
  public static List<PointF> getMaxFacePoints(List<List<PointF>> paramList, double paramDouble)
  {
    int j = paramList.size();
    int i = 0;
    if (j == 1)
    {
      paramList = (List)paramList.get(0);
      CosFunUtil.scale(paramList, 1.0D / paramDouble);
      FaceOffUtil.getFullCoords(paramList, 2.0F);
      return paramList;
    }
    long l1 = -1L;
    int m = 0;
    j = -1;
    while (i < paramList.size())
    {
      List localList = (List)paramList.get(i);
      CosFunUtil.scale(localList, 1.0D / paramDouble);
      FaceOffUtil.getFullCoords(localList, 2.0F);
      PointF localPointF1 = (PointF)localList.get(101);
      PointF localPointF2 = (PointF)localList.get(99);
      int i1 = (int)AlgoUtils.getDistance(localPointF2, (PointF)localList.get(105));
      long l3 = (int)AlgoUtils.getDistance(localPointF2, localPointF1) * i1;
      int n;
      int k;
      long l2;
      if (l3 <= l1)
      {
        n = m;
        k = j;
        l2 = l1;
        if (l3 == l1)
        {
          n = m;
          k = j;
          l2 = l1;
          if (i1 <= j) {}
        }
      }
      else
      {
        n = i;
        k = i1;
        l2 = l3;
      }
      i += 1;
      m = n;
      j = k;
      l1 = l2;
    }
    return (List)paramList.get(m);
  }
  
  public static boolean hasFaceInPic(Bitmap paramBitmap)
  {
    PTFaceAttr[] arrayOfPTFaceAttr = new PTFaceAttr[1];
    runInGLThread(new FaceChangeUtils.3(arrayOfPTFaceAttr, paramBitmap), true, "GLThread-checkHasFaceInPic");
    return hasValidFace(arrayOfPTFaceAttr[0]);
  }
  
  public static boolean hasValidFace(PTFaceAttr paramPTFaceAttr)
  {
    return (paramPTFaceAttr != null) && (paramPTFaceAttr.getAllFacePoints() != null) && (paramPTFaceAttr.getAllFacePoints().size() > 0);
  }
  
  private static SizeI initMaxLength()
  {
    if (DeviceUtils.hasDeviceHigh(AEModule.getContext())) {
      return new SizeI(1080, 1920);
    }
    if (DeviceUtils.hasDeviceNormal(AEModule.getContext())) {
      return new SizeI(720, 1280);
    }
    return new SizeI(720, 1280);
  }
  
  private static CosFunParam processUserBitmap(int paramInt1, int paramInt2, int paramInt3, List<PointF> paramList, FaceImageLayer paramFaceImageLayer, CrazyFaceDataTemplate paramCrazyFaceDataTemplate)
  {
    CosFunParam localCosFunParam = new CosFunParam();
    Object localObject1 = (PointF)paramList.get(101);
    Object localObject2 = (PointF)paramList.get(99);
    PointF localPointF1 = (PointF)paramList.get(105);
    PointF localPointF2 = (PointF)paramList.get(103);
    int i = (int)AlgoUtils.getDistance((PointF)localObject2, localPointF1);
    int j = (int)AlgoUtils.getDistance((PointF)localObject2, (PointF)localObject1);
    float f1 = ((PointF)localObject2).x;
    float f2 = paramInt2;
    f1 /= f2;
    float f4 = ((PointF)localObject2).y;
    float f3 = paramInt3;
    f4 /= f3;
    float f5 = ((PointF)localObject1).x / f2;
    float f6 = ((PointF)localObject1).y / f3;
    float f7 = localPointF2.x / f2;
    float f8 = localPointF2.y / f3;
    f2 = localPointF1.x / f2;
    f3 = localPointF1.y / f3;
    localObject1 = new VideoFilterBase("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
    ((VideoFilterBase)localObject1).ApplyGLSLFilter();
    ((VideoFilterBase)localObject1).setTexCords(new float[] { f1, f4, f5, f6, f7, f8, f2, f3 });
    localCosFunParam.mFaceTexture = RendererUtils.createTexture();
    localObject2 = FrameBufferCache.getInstance().get(i, j);
    ((VideoFilterBase)localObject1).RenderProcess(paramInt1, i, j, localCosFunParam.mFaceTexture, 0.0D, (Frame)localObject2);
    ((Frame)localObject2).unlock();
    ((VideoFilterBase)localObject1).clearGLSLSelf();
    CosFunUtil.updateFacePoints(paramList);
    localObject1 = FrameBufferCache.getInstance().get(100, 100);
    if (paramFaceImageLayer.getVersion() == 1)
    {
      paramCrazyFaceDataTemplate = new CFSkinCropFilter();
      paramCrazyFaceDataTemplate.setFacePoints(paramList);
      paramCrazyFaceDataTemplate.applyFilterChain(false, i, j);
      paramCrazyFaceDataTemplate.RenderProcess(localCosFunParam.mFaceTexture, 100, 100, -1, 0.0D, (Frame)localObject1);
      localCosFunParam.calSkinParams((Frame)localObject1, paramFaceImageLayer.imageFaceColor);
      paramCrazyFaceDataTemplate.clearGLSLSelf();
    }
    else
    {
      paramCrazyFaceDataTemplate = new CFSkinCropFilterV2(paramCrazyFaceDataTemplate.folderPath);
      paramCrazyFaceDataTemplate.setFacePointsInfo(paramList, i, j, paramFaceImageLayer.faceTriangleID);
      paramCrazyFaceDataTemplate.ApplyGLSLFilter();
      paramCrazyFaceDataTemplate.RenderProcess(localCosFunParam.mFaceTexture, 100, 100, -1, 0.0D, (Frame)localObject1);
      localCosFunParam.calSkinParams((Frame)localObject1, paramFaceImageLayer.imageFaceColor2, paramFaceImageLayer.faceColorRange);
      paramCrazyFaceDataTemplate.clearGLSLSelf();
    }
    ((Frame)localObject1).unlock();
    localCosFunParam.mWidth = i;
    localCosFunParam.mHeight = j;
    localCosFunParam.mUserFacePointsList = paramList;
    return localCosFunParam;
  }
  
  public static void runInGLThread(Runnable paramRunnable, boolean paramBoolean, String paramString)
  {
    if (paramRunnable == null) {
      return;
    }
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "GLThread-default";
    }
    paramString = new SimpleGLThread(null, str);
    paramRunnable = new FaceChangeUtils.5(paramRunnable, paramString);
    if (paramBoolean)
    {
      paramString.postJobSync(paramRunnable);
      return;
    }
    paramString.postJob(paramRunnable);
  }
  
  public static List<PointF> transFromImageSpace2ContainerSpace(int paramInt1, int paramInt2, int paramInt3, int paramInt4, @NonNull List<PointF> paramList)
  {
    float f1 = paramInt1;
    float f2 = paramInt2;
    float f5 = f1 * 1.0F / f2;
    float f3 = paramInt3;
    float f6 = f3 * 1.0F;
    float f4 = paramInt4;
    float f7 = f6 / f4;
    paramList = new LinkedList(paramList);
    LinkedList localLinkedList = new LinkedList();
    paramInt2 = 0;
    paramInt1 = 0;
    PointF localPointF;
    if (f5 <= f7)
    {
      f2 = f4 * 1.0F / f2;
      f1 = (f3 - f1 * f2) / 2.0F;
      while (paramInt1 < paramList.size())
      {
        localPointF = (PointF)paramList.get(paramInt1);
        localLinkedList.add(new PointF(localPointF.x * f2 + f1, localPointF.y * f2));
        paramInt1 += 1;
      }
    }
    f1 = f6 / f1;
    f2 = (f4 - f2 * f1) / 2.0F;
    paramInt1 = paramInt2;
    while (paramInt1 < paramList.size())
    {
      localPointF = (PointF)paramList.get(paramInt1);
      localLinkedList.add(new PointF(localPointF.x * f1, localPointF.y * f1 + f2));
      paramInt1 += 1;
    }
    return localLinkedList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.play.FaceChangeUtils
 * JD-Core Version:    0.7.0.1
 */