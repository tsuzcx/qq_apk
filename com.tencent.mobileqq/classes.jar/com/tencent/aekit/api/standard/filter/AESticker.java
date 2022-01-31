package com.tencent.aekit.api.standard.filter;

import android.graphics.PointF;
import android.opengl.GLES20;
import android.util.Log;
import com.tencent.aekit.openrender.AEFilterBase;
import com.tencent.aekit.openrender.internal.AEChainI;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.aekit.plugin.core.AEDetectorType;
import com.tencent.aekit.plugin.core.AIActionCounter;
import com.tencent.aekit.plugin.core.AIAttr;
import com.tencent.aekit.plugin.core.AISegAttr;
import com.tencent.aekit.plugin.core.HotAreaActionCounter;
import com.tencent.aekit.plugin.core.PTHandAttr;
import com.tencent.camerasdk.avreport.AEKitBean;
import com.tencent.camerasdk.avreport.AEKitReportEvent;
import com.tencent.camerasdk.avreport.AVReportCenter;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.audio.AudioDataManager;
import com.tencent.ttpic.audio.LocalAudioDataManager;
import com.tencent.ttpic.baseutils.fps.BenchUtil;
import com.tencent.ttpic.facedetect.FaceStatus;
import com.tencent.ttpic.filter.SplitFilter;
import com.tencent.ttpic.manager.RandomGroupManager;
import com.tencent.ttpic.openapi.PTDetectInfo;
import com.tencent.ttpic.openapi.PTDetectInfo.Builder;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.PTHairAttr;
import com.tencent.ttpic.openapi.PTSegAttr;
import com.tencent.ttpic.openapi.PTSkyAttr;
import com.tencent.ttpic.openapi.cache.VideoMemoryManager;
import com.tencent.ttpic.openapi.filter.BuckleFaceFilter;
import com.tencent.ttpic.openapi.filter.MaterialLoadFinishListener;
import com.tencent.ttpic.openapi.filter.RenderItem;
import com.tencent.ttpic.openapi.filter.StickerFilters;
import com.tencent.ttpic.openapi.filter.TransformFilter;
import com.tencent.ttpic.openapi.filter.VideoFilterList;
import com.tencent.ttpic.openapi.manager.TouchTriggerManager;
import com.tencent.ttpic.openapi.model.RedPacketPosition;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.util.VideoFilterUtil;
import com.tencent.ttpic.openapi.util.VideoMaterialUtil;
import com.tencent.ttpic.openapi.util.VideoPrefsUtil;
import com.tencent.ttpic.openapi.util.VideoSDKMaterialParser;
import com.tencent.ttpic.openapi.util.youtu.VideoPreviewFaceOutlineDetector;
import com.tencent.ttpic.util.AudioUtil;
import com.tencent.ttpic.util.youtu.bodydetector.BodyDetectResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AESticker
  extends AEChainI
{
  public static final String PERF_LOG = "[showPreview]";
  private boolean doStrokeShake;
  private boolean enableBGTransparent = true;
  private boolean enableStrokeShakeGauss;
  private PTFaceAttr faceAttr;
  private VideoPreviewFaceOutlineDetector faceDetector;
  private AEFaceTransform faceTransform;
  private PTHairAttr hairAttr;
  private boolean isUseStickerPlugin = false;
  private AIAttr mAIAttr;
  private StickerFilters mAfterTransFilter = new StickerFilters(this, false);
  private StickerFilters mBeforeTransFilter = new StickerFilters(this, true);
  private BaseFilter mCopyFilter = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  private Frame mCopyFrame = new Frame();
  private Frame[] mInputFrame = new Frame[2];
  private int[] mInputTex = new int[1];
  private long mLastTimeStamp;
  private boolean mPause;
  private long mPauseTimeDiff;
  private SplitFilter mSplitFilter = new SplitFilter();
  private VideoFilterList mVideoFilters;
  private VideoMaterial mVideoMaterial;
  private PTSkyAttr skyAttr;
  private float splitScreen;
  
  public AESticker(VideoMaterial paramVideoMaterial, VideoPreviewFaceOutlineDetector paramVideoPreviewFaceOutlineDetector)
  {
    this.mVideoMaterial = paramVideoMaterial;
    if ((this.mVideoMaterial == null) || (paramVideoPreviewFaceOutlineDetector == null)) {
      throw new RuntimeException("AESticker init fail!");
    }
    construct(this.mVideoMaterial, paramVideoPreviewFaceOutlineDetector);
  }
  
  public AESticker(VideoMaterial paramVideoMaterial, boolean paramBoolean)
  {
    this.mVideoMaterial = paramVideoMaterial;
    if (!paramBoolean) {
      throw new RuntimeException("AESticker init fail!");
    }
    construct(this.mVideoMaterial, null);
  }
  
  public AESticker(String paramString, VideoPreviewFaceOutlineDetector paramVideoPreviewFaceOutlineDetector)
  {
    this.mVideoMaterial = VideoSDKMaterialParser.parseVideoMaterial(paramString, "params");
    if ((this.mVideoMaterial == null) || (paramVideoPreviewFaceOutlineDetector == null)) {
      throw new RuntimeException("AESticker init fail!");
    }
    construct(this.mVideoMaterial, paramVideoPreviewFaceOutlineDetector);
  }
  
  private boolean allBusinessPrivateProcess(List<RenderItem> paramList)
  {
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        RenderItem localRenderItem = (RenderItem)paramList.next();
        if ((localRenderItem.filter instanceof BuckleFaceFilter)) {
          return ((BuckleFaceFilter)localRenderItem.filter).isNeedRender();
        }
      }
    }
    return true;
  }
  
  private void construct(VideoMaterial paramVideoMaterial, VideoPreviewFaceOutlineDetector paramVideoPreviewFaceOutlineDetector)
  {
    boolean bool2 = true;
    AEKitBean localAEKitBean = new AEKitBean(AEKitReportEvent.SELECT_STICKER.value);
    localAEKitBean.ext_str1 = paramVideoMaterial.getId();
    AVReportCenter.getInstance().commit(localAEKitBean, Boolean.valueOf(true));
    VideoMemoryManager.getInstance().loadAllImages(paramVideoMaterial);
    this.mVideoFilters = VideoFilterUtil.createFilters(paramVideoMaterial);
    if (this.mVideoFilters != null) {
      VideoFilterList.sIsUseFreezeFrame = this.mVideoFilters.hasFreezeSetting();
    }
    if (paramVideoPreviewFaceOutlineDetector != null)
    {
      paramVideoPreviewFaceOutlineDetector.nativeSetRefine(VideoMaterialUtil.needOpenRefine(paramVideoMaterial));
      paramVideoPreviewFaceOutlineDetector.setFaceValueDetectType(paramVideoMaterial.getFaceValueDetectType());
      paramVideoPreviewFaceOutlineDetector.clearActionCounter();
      bool1 = bool2;
      if (!VideoMaterialUtil.is3DMaterial(paramVideoMaterial)) {
        if (!VideoMaterialUtil.isFilamentMaterial(paramVideoMaterial)) {
          break label198;
        }
      }
    }
    label198:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramVideoPreviewFaceOutlineDetector.setNeedDetect3D(bool1);
      paramVideoPreviewFaceOutlineDetector.setNeedFaceKit(VideoMaterialUtil.is3DCosMaterial(paramVideoMaterial));
      paramVideoPreviewFaceOutlineDetector.setNeedExpressionWeights(VideoMaterialUtil.isAnimojiMaterial(paramVideoMaterial));
      VideoPreviewFaceOutlineDetector.setFov(paramVideoMaterial.getFov());
      AIActionCounter.clearAction(AEDetectorType.HAND);
      AIActionCounter.clearAction(AEDetectorType.VOICE_RECOGNIZE);
      HotAreaActionCounter.reset();
      AudioDataManager.getInstance().setNeedDecible(paramVideoMaterial.isDBTriggered());
      RandomGroupManager.getInstance().clearAll();
      this.splitScreen = paramVideoMaterial.getSplitScreen();
      this.faceDetector = paramVideoPreviewFaceOutlineDetector;
      this.mPause = false;
      this.mPauseTimeDiff = 0L;
      return;
    }
  }
  
  private boolean isSupportPause()
  {
    return this.mVideoFilters.isSupportPause();
  }
  
  public Frame RenderEffectFilter(Frame paramFrame)
  {
    Frame localFrame = paramFrame;
    if (this.mVideoFilters != null) {
      localFrame = this.mVideoFilters.RenderEffectFilter(paramFrame);
    }
    return localFrame;
  }
  
  public void addFilter(VideoFilterBase paramVideoFilterBase)
  {
    if (paramVideoFilterBase != null) {
      this.mVideoFilters.addRenderItem(new RenderItem(paramVideoFilterBase, null));
    }
  }
  
  public void addMaskTouchPoint(PointF paramPointF)
  {
    this.mVideoFilters.addMaskTouchPoint(paramPointF);
  }
  
  public void addTouchPoint(PointF paramPointF)
  {
    this.mVideoFilters.addTouchPoint(paramPointF);
  }
  
  public void addTransformFilter(VideoFilterBase paramVideoFilterBase)
  {
    if ((paramVideoFilterBase != null) && ((paramVideoFilterBase instanceof TransformFilter))) {
      this.mVideoFilters.addTransformRenderItem(new RenderItem(paramVideoFilterBase, null));
    }
  }
  
  public void apply()
  {
    if (this.mIsApplied) {}
    do
    {
      return;
      this.mCopyFilter.apply();
      this.mVideoFilters.ApplyGLSLFilter();
      this.mSplitFilter.apply();
      int i = 0;
      while (i < this.mInputFrame.length)
      {
        this.mInputFrame[i] = new Frame();
        i += 1;
      }
      GLES20.glGenTextures(this.mInputTex.length, this.mInputTex, 0);
      this.mIsApplied = true;
    } while ((this.mVideoMaterial == null) || (this.mVideoMaterial.getRenderOrderList() == null) || (this.mVideoMaterial.getRenderOrderList().size() <= 0));
    setUseStickerPlugin(true);
  }
  
  public void checkNeedARGesture()
  {
    this.mVideoFilters.checkNeedARGesture();
  }
  
  public boolean checkStickerType(AESticker.STICKER_TYPE paramSTICKER_TYPE)
  {
    boolean bool = true;
    switch (AESticker.1.$SwitchMap$com$tencent$aekit$api$standard$filter$AESticker$STICKER_TYPE[paramSTICKER_TYPE.ordinal()])
    {
    default: 
      bool = false;
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 9: 
    case 10: 
      do
      {
        do
        {
          do
          {
            return bool;
            return VideoMaterialUtil.isHairSegMaterial(this.mVideoFilters.getMaterial());
            return VideoMaterialUtil.isSkySegMaterial(this.mVideoFilters.getMaterial());
            return this.mVideoFilters.isSegmentRequired();
          } while ((this.mVideoFilters != null) && (this.mVideoFilters.hasVoiceTextFilter()));
          return false;
        } while ((this.mVideoFilters != null) && (this.mVideoFilters.hasParticleFilter()));
        return false;
        return this.mVideoFilters.needDetectGesture();
        return VideoMaterialUtil.is3DMaterial(this.mVideoFilters.getMaterial());
        return VideoMaterialUtil.isBodyDetectMaterial(this.mVideoFilters.getMaterial());
        return VideoFilterUtil.needRecordTouchPoint(this.mVideoFilters);
      } while (this.mVideoFilters.getVideoEffectOrder() == 100);
      return false;
    case 11: 
      return VideoMaterialUtil.isGenderDetect(this.mVideoFilters.getMaterial());
    }
    return VideoMaterialUtil.isEmotionDectectMaterial(this.mVideoFilters.getMaterial());
  }
  
  public void clear()
  {
    clear(true);
  }
  
  public void clear(boolean paramBoolean)
  {
    Log.i("VideoMemoryManager", "AESticker clear! isClearMemory = " + paramBoolean);
    this.mVideoMaterial = null;
    this.mCopyFilter.ClearGLSL();
    this.mSplitFilter.ClearGLSL();
    if (this.mVideoFilters != null)
    {
      this.mVideoFilters.destroy();
      VideoFilterList.sIsUseFreezeFrame = false;
    }
    Frame[] arrayOfFrame = this.mInputFrame;
    int j = arrayOfFrame.length;
    int i = 0;
    while (i < j)
    {
      Frame localFrame = arrayOfFrame[i];
      if (localFrame != null) {
        localFrame.clear();
      }
      i += 1;
    }
    this.mCopyFrame.clear();
    GLES20.glDeleteTextures(this.mInputTex.length, this.mInputTex, 0);
    if (this.faceDetector != null)
    {
      this.faceDetector.nativeSetRefine(false);
      this.faceDetector.setNeedDetect3D(false);
      this.faceDetector.setNeedFaceKit(false);
      this.faceDetector.setNeedExpressionWeights(false);
      this.faceDetector = null;
    }
    this.mBeforeTransFilter.clear();
    this.mAfterTransFilter.clear();
    if (paramBoolean) {
      VideoMemoryManager.getInstance().clear();
    }
    LocalAudioDataManager.getInstance().destroy();
    AudioDataManager.getInstance().destroy();
    this.mIsApplied = false;
  }
  
  public void clearFilters()
  {
    this.mVideoFilters.clearRenderItems();
  }
  
  public void clearTouchPoint()
  {
    if (this.mVideoFilters != null) {
      this.mVideoFilters.clearTouchPoint();
    }
  }
  
  public void clearTransformFilters()
  {
    this.mVideoFilters.clearTransformRenderItems();
  }
  
  public void destroyAudio()
  {
    this.mVideoFilters.destroyAudio();
  }
  
  public boolean exportFilamentParams()
  {
    return this.mVideoFilters.exportFilamentParams();
  }
  
  public AIAttr getAIAttr()
  {
    return this.mAIAttr;
  }
  
  public AEFilterBase getAfterTransFilter()
  {
    return this.mAfterTransFilter;
  }
  
  public boolean getBackgroundTransparent()
  {
    return this.enableBGTransparent;
  }
  
  public AEFilterBase getBeforeTransFilter()
  {
    return this.mBeforeTransFilter;
  }
  
  public VideoFilterBase getEffectFilter()
  {
    return this.mVideoFilters.getEffectFilter();
  }
  
  public String getFilamentDirectionColor()
  {
    return this.mVideoFilters.getFilamentDirectionColor();
  }
  
  public int getFilamentDirectionIntensity()
  {
    return this.mVideoFilters.getFilamentDirectionIntensity();
  }
  
  public int getFilamentIblIntensity()
  {
    return this.mVideoFilters.getFilamentIblIntensity();
  }
  
  public int getFilamentIblRotation()
  {
    return this.mVideoFilters.getFilamentIblRotation();
  }
  
  public float[] getFilamentLightDirection()
  {
    return this.mVideoFilters.getFilamentLightDirection();
  }
  
  public float[] getFilamentPosition()
  {
    return this.mVideoFilters.getFilamentPosition();
  }
  
  public float[] getFilamentRotation()
  {
    return this.mVideoFilters.getFilamentRotation();
  }
  
  public float[] getFilamentScale()
  {
    return this.mVideoFilters.getFilamentScale();
  }
  
  public List<VideoFilterBase> getFilters()
  {
    return this.mVideoFilters.getFilters();
  }
  
  public PTFaceAttr getFreezeFaceInfo()
  {
    if (this.mVideoFilters == null) {
      return null;
    }
    return this.mVideoFilters.getFreezeFaceInfo();
  }
  
  public int getMaxFaceCount()
  {
    if ((this.mVideoFilters != null) && (this.mVideoFilters.getMaterial() != null)) {
      return this.mVideoFilters.getMaterial().getMaxFaceCount();
    }
    return 1;
  }
  
  public int getOnlyDetectOneGesture()
  {
    return this.mVideoFilters.getOnlyDetectOneGesture();
  }
  
  public List<RenderItem> getRenderItems()
  {
    return this.mVideoFilters.getRenderItems();
  }
  
  public int getShookHeadCount()
  {
    return this.mVideoFilters.shookHeadCount;
  }
  
  public List<VideoFilterBase> getTransformFilters()
  {
    return this.mVideoFilters.getTransformFilters();
  }
  
  public long getUpdateTimeStamp(long paramLong)
  {
    if (this.mPause) {
      this.mPauseTimeDiff = (paramLong - this.mLastTimeStamp);
    }
    for (paramLong = this.mLastTimeStamp;; paramLong -= this.mPauseTimeDiff)
    {
      this.mLastTimeStamp = paramLong;
      return this.mLastTimeStamp;
    }
  }
  
  public VideoMaterial getVideoMateral()
  {
    return this.mVideoMaterial;
  }
  
  public boolean hasParticleFilter()
  {
    return (this.mVideoFilters != null) && (this.mVideoFilters.hasParticleFilter());
  }
  
  public boolean hasVoiceTextFilter()
  {
    return (this.mVideoFilters != null) && (this.mVideoFilters.hasVoiceTextFilter());
  }
  
  public boolean is3DCosMaterial()
  {
    return VideoMaterialUtil.is3DCosMaterial(this.mVideoFilters.getMaterial());
  }
  
  public boolean is3DMaterial()
  {
    return VideoMaterialUtil.is3DMaterial(this.mVideoFilters.getMaterial());
  }
  
  public boolean isAfterOrderSpecificFilter()
  {
    return this.mVideoFilters.getVideoEffectOrder() == 101;
  }
  
  public boolean isAnimojiMaterial()
  {
    return VideoMaterialUtil.isAnimojiMaterial(this.mVideoFilters.getMaterial());
  }
  
  public boolean isCosFunMaterial()
  {
    return VideoMaterialUtil.isCosFunMaterial(this.mVideoFilters.getMaterial());
  }
  
  public boolean isExcludeOuterEffectFilterMaterial()
  {
    return (this.mVideoFilters.getVideoEffectOrder() == 100) || (this.mVideoFilters.getVideoEffectOrder() == 101);
  }
  
  public boolean isFilamentModelReady()
  {
    return this.mVideoFilters.isFilamentModelReady();
  }
  
  public boolean isMultiViewMaterial()
  {
    return VideoMaterialUtil.isMultiViewerMaterial(this.mVideoFilters.getMaterial());
  }
  
  public boolean isPreOrderSpecificFilter()
  {
    return this.mVideoFilters.getVideoEffectOrder() == 100;
  }
  
  public boolean isSegmentRequired()
  {
    return this.mVideoFilters.isSegmentRequired();
  }
  
  public boolean isSpecificFilter()
  {
    return (this.mVideoFilters.getVideoEffectOrder() == 100) || (this.mVideoFilters.getVideoEffectOrder() == 101);
  }
  
  public boolean isUseMesh()
  {
    if (this.mVideoFilters == null) {
      return false;
    }
    return this.mVideoFilters.isUseMesh();
  }
  
  public boolean isUseStickerPlugin()
  {
    return this.isUseStickerPlugin;
  }
  
  public boolean isValid()
  {
    return true;
  }
  
  public boolean needDetectBody()
  {
    return VideoMaterialUtil.isBodyDetectMaterial(this.mVideoFilters.getMaterial());
  }
  
  public boolean needDetectEmotion()
  {
    return this.mVideoFilters.needDetectEmotion();
  }
  
  public boolean needDetectFace(int paramInt)
  {
    return this.mVideoFilters.needFaceInfo(paramInt);
  }
  
  public boolean needDetectGender()
  {
    return this.mVideoFilters.needDetectGender();
  }
  
  public boolean needDetectGesture()
  {
    return this.mVideoFilters.needDetectGesture();
  }
  
  public boolean needDetectGestureBonePoint()
  {
    return this.mVideoFilters.isNeedDetectGestureBonePoint();
  }
  
  public boolean needHairSegment()
  {
    return this.mVideoFilters.isHairSegmentRequired();
  }
  
  public boolean needMaskRecordTouchPoint()
  {
    return VideoFilterUtil.needMaskRecordTouchPoint(this.mVideoFilters);
  }
  
  public boolean needRecordTouchPoint()
  {
    return VideoFilterUtil.needRecordTouchPoint(this.mVideoFilters);
  }
  
  public boolean needTouchTriggerEvent()
  {
    return VideoFilterUtil.needTouchTriggerEvent(this.mVideoFilters);
  }
  
  public void onPause()
  {
    this.mVideoFilters.onPause();
    if (isSupportPause())
    {
      this.mPause = true;
      this.mVideoFilters.setAudioPause(this.mPause);
    }
  }
  
  public void onResume()
  {
    this.mVideoFilters.onResume();
    if (isSupportPause())
    {
      this.mPause = false;
      this.mVideoFilters.setAudioPause(false);
    }
  }
  
  public void onStickerPause()
  {
    if (isSupportPause())
    {
      this.mPause = true;
      this.mVideoFilters.setAudioPause(this.mPause);
    }
    this.mVideoFilters.setBlurMaskPause(true);
  }
  
  public void onStickerResume()
  {
    if (isSupportPause())
    {
      this.mPause = false;
      this.mVideoFilters.setAudioPause(this.mPause);
    }
    this.mVideoFilters.setBlurMaskPause(false);
  }
  
  public Frame processSplitFilters(Frame paramFrame1, Frame paramFrame2)
  {
    if (this.splitScreen <= 0.0F) {
      return paramFrame2;
    }
    paramFrame1 = this.mCopyFilter.RenderProcess(paramFrame1.getTextureId(), paramFrame1.width, paramFrame1.height, paramFrame2.width, paramFrame2.height);
    this.mSplitFilter.setxPos(this.splitScreen);
    this.mSplitFilter.RenderProcess(paramFrame2.getTextureId(), paramFrame2.width, paramFrame2.height, -1, 0.0D, paramFrame1);
    paramFrame2.unlock();
    return paramFrame1;
  }
  
  public Frame processStickerFilters(Frame paramFrame, PTFaceAttr paramPTFaceAttr, PTSegAttr paramPTSegAttr, AIAttr paramAIAttr)
  {
    List localList1 = paramPTFaceAttr.getAllFacePoints();
    List localList2 = paramPTFaceAttr.getAllFaceAngles();
    int i = paramPTFaceAttr.getRotation();
    Set localSet = paramPTFaceAttr.getTriggeredExpression();
    Object localObject1;
    if (paramAIAttr != null)
    {
      localObject1 = (PTHandAttr)paramAIAttr.getAvailableData(AEDetectorType.HAND.value);
      if (localObject1 != null) {
        localSet.add(Integer.valueOf(((PTHandAttr)localObject1).getHandType()));
      }
    }
    HashMap localHashMap = new HashMap();
    if ((paramPTSegAttr != null) && (this.mVideoFilters.isMaterialSegmentRequired())) {
      if (this.doStrokeShake) {
        localObject1 = this.mVideoFilters.doFabbyStrokeShake(paramFrame, paramPTSegAttr.getMaskFrame(), paramFrame, this.enableStrokeShakeGauss);
      }
    }
    for (;;)
    {
      this.mVideoFilters.renderARFilterIfNeeded((Frame)localObject1);
      Object localObject2 = this.mVideoFilters.updateAndRenderHeadCropItemFilters((Frame)localObject1, paramPTFaceAttr);
      localObject1 = localObject2;
      if (this.mVideoFilters.isMaterialSegmentRequired()) {
        localObject1 = this.mVideoFilters.updateAndRenderBgFilters((Frame)localObject2, paramPTFaceAttr);
      }
      localObject2 = this.mVideoFilters.renderEffectFilter((Frame)localObject1, new int[] { 1, 100 });
      localObject1 = localObject2;
      if (paramAIAttr != null)
      {
        localObject1 = localObject2;
        if (checkStickerType(AESticker.STICKER_TYPE.SEGMENT_HAIR_STICKER))
        {
          this.hairAttr = ((PTHairAttr)paramAIAttr.getRealtimeData(AEDetectorType.HAIR_SEGMENT.value));
          localObject1 = this.mVideoFilters.updateAndRenderHairCos((Frame)localObject2, paramPTFaceAttr, this.hairAttr);
        }
      }
      if ((paramAIAttr != null) && (checkStickerType(AESticker.STICKER_TYPE.SEGMENT_SKY_STICKER))) {
        this.skyAttr = ((PTSkyAttr)paramAIAttr.getRealtimeData(AEDetectorType.SKY_SEGMENT.value));
      }
      if (this.skyAttr != null) {
        localObject1 = this.mVideoFilters.updateAndRenderLut((Frame)localObject1, paramPTFaceAttr, this.skyAttr.getMaskBitmap());
      }
      for (;;)
      {
        localObject2 = this.mVideoFilters.updateAndRenderSkybox((Frame)localObject1, paramPTFaceAttr);
        localObject1 = localObject2;
        if (this.mVideoFilters.renderStaticStickerFirst())
        {
          localObject1 = localObject2;
          if (allBusinessPrivateProcess(this.mVideoFilters.getRenderItems())) {
            localObject1 = this.mVideoFilters.updateAndRenderStaticStickers((Frame)localObject2, paramPTFaceAttr);
          }
        }
        localObject2 = localObject1;
        if (this.mVideoFilters.render3DFirst())
        {
          localObject2 = localObject1;
          if (this.mVideoFilters.renderOder() == 0)
          {
            BenchUtil.benchStart("[showPreview]updateAndRender3DFilter");
            localObject2 = this.mVideoFilters.updateAndRenderFilamentFilter((Frame)localObject1, paramPTFaceAttr);
            BenchUtil.benchEnd("[showPreview]updateAndRender3DFilter");
          }
        }
        localObject1 = this.mVideoFilters.updateAndRenderRapidNet((Frame)localObject2, paramPTFaceAttr);
        BenchUtil.benchStart("[showPreview]updateAndRender - DO_NOT_RENDER_FACE_OFF_FILTER");
        localObject2 = this.mVideoFilters.updateAndRenderDynamicStickers((Frame)localObject1, paramPTFaceAttr, paramAIAttr);
        BenchUtil.benchEnd("[showPreview]updateAndRender - DO_NOT_RENDER_FACE_OFF_FILTER");
        localObject1 = localObject2;
        if (!this.mVideoFilters.render3DFirst())
        {
          localObject1 = localObject2;
          if (this.mVideoFilters.renderOder() == 0)
          {
            BenchUtil.benchStart("[showPreview]updateAndRender_gameplay");
            localObject1 = this.mVideoFilters.updateAndRenderFilamentFilter((Frame)localObject2, paramPTFaceAttr);
            BenchUtil.benchEnd("[showPreview]updateAndRender_gameplay");
          }
        }
        this.mVideoFilters.updateAndRenderMultiViewerMaterial(localHashMap, (Frame)localObject1, paramAIAttr, paramPTFaceAttr, paramPTSegAttr, this.hairAttr);
        localObject2 = this.mVideoFilters.updateAndRenderFilamentParticleFilter((Frame)localObject1, paramPTFaceAttr);
        localObject1 = localObject2;
        if (!this.mVideoFilters.renderStaticStickerFirst())
        {
          localObject1 = localObject2;
          if (allBusinessPrivateProcess(this.mVideoFilters.getRenderItems())) {
            localObject1 = this.mVideoFilters.updateAndRenderStaticStickers((Frame)localObject2, paramPTFaceAttr);
          }
        }
        localObject1 = this.mVideoFilters.renderEffectFilter((Frame)localObject1, new int[] { 2, 101 });
        BenchUtil.benchStart("updateAndRenderActMaterial");
        localObject1 = this.mVideoFilters.updateAndRenderActMaterial((Frame)localObject1, localList1, localList2, i, paramPTFaceAttr.getTimeStamp());
        BenchUtil.benchEnd("updateAndRenderActMaterial");
        if (localHashMap.isEmpty()) {
          localHashMap.put(Integer.valueOf(0), this.mVideoFilters.zoomFrame((Frame)localObject1));
        }
        localObject1 = this.mVideoFilters.updateAndRenderFabbyMVRenderItem(paramFrame, paramAIAttr, localHashMap, paramPTFaceAttr.getFaceActionCounter(), localSet, paramPTFaceAttr.getTimeStamp());
        paramFrame = (Frame)localObject1;
        if (this.mVideoFilters.renderOder() == 1)
        {
          if (!this.mVideoFilters.render3DFirst()) {
            break label916;
          }
          BenchUtil.benchStart("[showPreview]updateAndRender3DFilter");
          paramFrame = this.mVideoFilters.updateAndRenderFilamentFilter((Frame)localObject1, paramPTFaceAttr);
          BenchUtil.benchEnd("[showPreview]updateAndRender3DFilter");
        }
        for (;;)
        {
          paramFrame = this.mVideoFilters.blurAfterRender(paramFrame, paramPTFaceAttr, paramPTSegAttr);
          paramFrame = this.mVideoFilters.cosFunFilterGroupRender(paramFrame, paramPTFaceAttr, paramPTSegAttr, paramAIAttr);
          this.mVideoFilters.clearTouchPoint();
          if ((this.hairAttr != null) && (this.hairAttr.getMaskFrame() != null))
          {
            this.hairAttr.getMaskFrame().setCanUnlock(true);
            this.hairAttr.getMaskFrame().unlock();
          }
          return paramFrame;
          if ((paramPTSegAttr.getMaskFrame() == null) && (!AISegAttr.isRotate())) {
            reset();
          }
          localObject1 = this.mVideoFilters.doFabbyStroke(paramFrame, paramPTSegAttr.getMaskFrame(), paramPTFaceAttr);
          if (this.enableBGTransparent) {
            break label946;
          }
          GlUtil.setBlendMode(true);
          localObject2 = this.mCopyFilter.RenderProcess(paramFrame.getTextureId(), paramFrame.width, paramFrame.height);
          this.mCopyFilter.RenderProcess(((Frame)localObject1).getTextureId(), ((Frame)localObject1).width, ((Frame)localObject1).height, -1, 0.0D, (Frame)localObject2);
          ((Frame)localObject2).unlock();
          GlUtil.setBlendMode(false);
          localObject1 = localObject2;
          break;
          label916:
          BenchUtil.benchStart("[showPreview]updateAndRender3DFilter");
          paramFrame = this.mVideoFilters.updateAndRenderFilamentFilter((Frame)localObject1, paramPTFaceAttr);
          BenchUtil.benchEnd("[showPreview]updateAndRender3DFilter");
        }
      }
      label946:
      continue;
      localObject1 = paramFrame;
    }
  }
  
  public Frame processTransformRelatedFilters(Frame paramFrame, PTFaceAttr paramPTFaceAttr, PTSegAttr paramPTSegAttr, AIAttr paramAIAttr)
  {
    setAIAttr(paramAIAttr);
    Set localSet = paramPTFaceAttr.getTriggeredExpression();
    List localList = null;
    Object localObject1 = localList;
    Object localObject2;
    if (paramAIAttr != null)
    {
      localObject2 = (PTHandAttr)paramAIAttr.getAvailableData(AEDetectorType.HAND.value);
      localObject1 = localList;
      if (localObject2 != null)
      {
        localObject1 = ((PTHandAttr)localObject2).getHandPointList();
        localSet.add(Integer.valueOf(((PTHandAttr)localObject2).getHandType()));
      }
    }
    long l = getUpdateTimeStamp(paramPTFaceAttr.getTimeStamp());
    paramPTFaceAttr.setTimeStamp(l);
    Map localMap = paramPTFaceAttr.getFaceActionCounter();
    int i = paramPTFaceAttr.getRotation();
    localList = paramPTFaceAttr.getAllFacePoints();
    if ((localList != null) && (localList.size() > 0)) {}
    for (localList = (List)localList.get(0);; localList = null)
    {
      Object localObject3 = new ArrayList();
      localObject2 = localObject3;
      Object localObject4;
      if (needDetectBody())
      {
        localObject2 = localObject3;
        if (paramAIAttr != null)
        {
          localObject4 = (List)paramAIAttr.getAvailableData(AEDetectorType.BODY.value);
          localObject2 = localObject3;
          if (localObject4 != null)
          {
            localObject2 = localObject3;
            if (((List)localObject4).size() > 0) {
              localObject2 = ((BodyDetectResult)((List)localObject4).get(0)).bodyPoints;
            }
          }
        }
      }
      localObject3 = paramPTFaceAttr.getAllFaceAngles();
      if ((localObject3 != null) && (((List)localObject3).size() > 0)) {}
      for (localObject3 = (float[])((List)localObject3).get(0);; localObject3 = null)
      {
        if ((paramPTFaceAttr.getFaceStatusList() != null) && (paramPTFaceAttr.getFaceStatusList().size() > 0)) {}
        for (localObject4 = (FaceStatus)paramPTFaceAttr.getFaceStatusList().get(0);; localObject4 = null)
        {
          localObject1 = new PTDetectInfo.Builder().facePoints(localList).faceAngles((float[])localObject3).phoneAngle((i + 360) % 360).faceActionCounter(localMap).aiAttr(paramAIAttr).bodyPoints((List)localObject2).handActionCounter(AIActionCounter.getActions(AEDetectorType.HAND)).triggeredExpression(localSet).handPoints((List)localObject1).faceStatus((FaceStatus)localObject4).timestamp(l).faceDetector(paramPTFaceAttr.getFaceDetector()).build();
          TouchTriggerManager.getInstance().updateTouchTriggerState((PTDetectInfo)localObject1);
          this.mVideoFilters.updateTriggerManager((PTDetectInfo)localObject1);
          paramPTSegAttr = this.mVideoFilters.blurBeforeRender(paramFrame, paramPTFaceAttr, paramPTSegAttr, paramAIAttr);
          this.mVideoFilters.updateFaceParams(paramAIAttr, paramPTFaceAttr, paramFrame.width);
          BenchUtil.benchStart("updateTextureParam2");
          this.mVideoFilters.updateTextureParam(paramPTFaceAttr.getFaceActionCounter(), localSet, paramPTFaceAttr.getTimeStamp(), paramAIAttr);
          BenchUtil.benchEnd("updateTextureParam2");
          return this.mVideoFilters.processTransformRelatedFilters(paramPTSegAttr, paramPTFaceAttr);
        }
      }
    }
  }
  
  public Frame processTransformRelatedFiltersPluggable(Frame paramFrame, PTFaceAttr paramPTFaceAttr, AIAttr paramAIAttr, Set<Integer> paramSet)
  {
    this.mVideoFilters.updateFaceParams(paramAIAttr, paramPTFaceAttr, paramFrame.width);
    BenchUtil.benchStart("updateTextureParam2");
    this.mVideoFilters.updateTextureParam(this.faceDetector.getFaceActionCounter(), paramSet, paramPTFaceAttr.getTimeStamp(), paramAIAttr);
    BenchUtil.benchEnd("updateTextureParam2");
    return this.mVideoFilters.processTransformRelatedFilters(paramFrame, paramPTFaceAttr);
  }
  
  public Frame render(Frame paramFrame)
  {
    Frame localFrame = this.mBeforeTransFilter.render(paramFrame);
    if (paramFrame != localFrame) {
      paramFrame.unlock();
    }
    paramFrame = this.mAfterTransFilter.render(localFrame);
    if (localFrame != paramFrame) {
      localFrame.unlock();
    }
    return paramFrame;
  }
  
  public void renderARFilter(Frame paramFrame)
  {
    this.mVideoFilters.renderARFilterIfNeeded(paramFrame);
  }
  
  public Frame renderActFilter(Frame paramFrame, List<List<PointF>> paramList, List<float[]> paramList1, int paramInt, PTFaceAttr paramPTFaceAttr)
  {
    Frame localFrame = paramFrame;
    if (this.mVideoFilters != null) {
      localFrame = this.mVideoFilters.updateAndRenderActMaterial(paramFrame, paramList, paramList1, paramInt, paramPTFaceAttr.getTimeStamp());
    }
    return localFrame;
  }
  
  public Frame renderAfterBlur(Frame paramFrame, PTFaceAttr paramPTFaceAttr, PTSegAttr paramPTSegAttr)
  {
    Frame localFrame = paramFrame;
    if (this.mVideoFilters != null) {
      localFrame = this.mVideoFilters.blurAfterRender(paramFrame, paramPTFaceAttr, paramPTSegAttr);
    }
    return localFrame;
  }
  
  public Frame renderBgFilter(Frame paramFrame, PTFaceAttr paramPTFaceAttr)
  {
    Frame localFrame = paramFrame;
    if (this.mVideoFilters.isMaterialSegmentRequired()) {
      localFrame = this.mVideoFilters.updateAndRenderBgFilters(paramFrame, paramPTFaceAttr);
    }
    return localFrame;
  }
  
  public Frame renderBlingFilter(Frame paramFrame, PTFaceAttr paramPTFaceAttr, PTDetectInfo paramPTDetectInfo, List<PointF> paramList)
  {
    Frame localFrame = paramFrame;
    if (this.mVideoFilters != null) {
      localFrame = this.mVideoFilters.updateAndRenderBlingFilter(paramFrame, paramPTFaceAttr, paramPTDetectInfo, paramList);
    }
    return localFrame;
  }
  
  public Frame renderBlurBefore(Frame paramFrame, PTFaceAttr paramPTFaceAttr, PTSegAttr paramPTSegAttr, AIAttr paramAIAttr)
  {
    Frame localFrame = paramFrame;
    if (this.mVideoFilters != null) {
      localFrame = this.mVideoFilters.blurBeforeRender(paramFrame, paramPTFaceAttr, paramPTSegAttr, paramAIAttr);
    }
    return localFrame;
  }
  
  public Frame renderComicEffectAfter(Frame paramFrame, PTFaceAttr paramPTFaceAttr)
  {
    Frame localFrame = paramFrame;
    if (this.mVideoFilters != null) {
      localFrame = this.mVideoFilters.updateAndRenderComicEffectFilters(2, paramFrame, paramPTFaceAttr);
    }
    return localFrame;
  }
  
  public Frame renderComicEffectBefore(Frame paramFrame, PTFaceAttr paramPTFaceAttr)
  {
    Frame localFrame = paramFrame;
    if (this.mVideoFilters != null) {
      localFrame = this.mVideoFilters.updateAndRenderComicEffectFilters(1, paramFrame, paramPTFaceAttr);
    }
    return localFrame;
  }
  
  public Frame renderCosFun(Frame paramFrame, PTFaceAttr paramPTFaceAttr, PTSegAttr paramPTSegAttr, AIAttr paramAIAttr)
  {
    Frame localFrame = paramFrame;
    if (this.mVideoFilters != null) {
      localFrame = this.mVideoFilters.cosFunFilterGroupRender(paramFrame, paramPTFaceAttr, paramPTSegAttr, paramAIAttr);
    }
    return localFrame;
  }
  
  public Frame renderCrazyFaceFilter(Frame paramFrame, List<List<PointF>> paramList, List<float[]> paramList1)
  {
    Frame localFrame = paramFrame;
    if (this.mVideoFilters != null) {
      localFrame = this.mVideoFilters.updateAndRenderCrazyFace(paramFrame, paramList, paramList1);
    }
    return localFrame;
  }
  
  public Frame renderDynamicFilter(Frame paramFrame, PTFaceAttr paramPTFaceAttr, AIAttr paramAIAttr)
  {
    Frame localFrame = paramFrame;
    if (this.mVideoFilters != null) {
      localFrame = this.mVideoFilters.updateAndRenderDynamicStickersPluggable(paramFrame, paramPTFaceAttr, paramAIAttr);
    }
    return localFrame;
  }
  
  public Frame renderEffectFilterAfter(Frame paramFrame)
  {
    Frame localFrame = paramFrame;
    if (this.mVideoFilters != null) {
      localFrame = this.mVideoFilters.renderEffectFilter(paramFrame, new int[] { 2, 101 });
    }
    return localFrame;
  }
  
  public Frame renderEffectFilterBefore(Frame paramFrame)
  {
    Frame localFrame = paramFrame;
    if (this.mVideoFilters != null) {
      localFrame = this.mVideoFilters.renderEffectFilter(paramFrame, new int[] { 1, 100 });
    }
    return localFrame;
  }
  
  public Frame renderEffectTriggerAfter(Frame paramFrame, PTFaceAttr paramPTFaceAttr)
  {
    Frame localFrame = paramFrame;
    if (this.mVideoFilters != null) {
      localFrame = this.mVideoFilters.updateAndRenderEffectTriggerFilters(2, paramFrame, paramPTFaceAttr);
    }
    return localFrame;
  }
  
  public Frame renderEffectTriggerBefore(Frame paramFrame, PTFaceAttr paramPTFaceAttr)
  {
    Frame localFrame = paramFrame;
    if (this.mVideoFilters != null) {
      localFrame = this.mVideoFilters.updateAndRenderEffectTriggerFilters(1, paramFrame, paramPTFaceAttr);
    }
    return localFrame;
  }
  
  public Frame renderFabbyMVFilter(Frame paramFrame, AIAttr paramAIAttr, Map<Integer, Frame> paramMap, Set<Integer> paramSet, PTFaceAttr paramPTFaceAttr)
  {
    Frame localFrame = paramFrame;
    if (this.mVideoFilters != null) {
      localFrame = this.mVideoFilters.updateAndRenderFabbyMVRenderItem(paramFrame, paramAIAttr, paramMap, paramPTFaceAttr.getFaceActionCounter(), paramSet, paramPTFaceAttr.getTimeStamp());
    }
    return localFrame;
  }
  
  public Frame renderFabbyStrokeShake(Frame paramFrame, PTFaceAttr paramPTFaceAttr, PTSegAttr paramPTSegAttr)
  {
    Frame localFrame = paramFrame;
    if (paramPTSegAttr != null)
    {
      localFrame = paramFrame;
      if (this.mVideoFilters.isMaterialSegmentRequired())
      {
        if (!this.doStrokeShake) {
          break label49;
        }
        localFrame = this.mVideoFilters.doFabbyStrokeShake(paramFrame, paramPTSegAttr.getMaskFrame(), paramFrame, this.enableStrokeShakeGauss);
      }
    }
    return localFrame;
    label49:
    if ((paramPTSegAttr.getMaskFrame() == null) && (!AISegAttr.isRotate())) {
      reset();
    }
    paramPTFaceAttr = this.mVideoFilters.doFabbyStroke(paramFrame, paramPTSegAttr.getMaskFrame(), paramPTFaceAttr);
    if (!this.enableBGTransparent)
    {
      GlUtil.setBlendMode(true);
      paramFrame = this.mCopyFilter.RenderProcess(paramFrame.getTextureId(), paramFrame.width, paramFrame.height);
      this.mCopyFilter.RenderProcess(paramPTFaceAttr.getTextureId(), paramPTFaceAttr.width, paramPTFaceAttr.height, -1, 0.0D, paramFrame);
      paramFrame.unlock();
      GlUtil.setBlendMode(false);
      return paramFrame;
    }
    return paramPTFaceAttr;
  }
  
  public Frame renderFaceSwitchFilter(Frame paramFrame, List<List<PointF>> paramList, Set<Integer> paramSet)
  {
    Frame localFrame = paramFrame;
    if (this.mVideoFilters != null) {
      localFrame = this.mVideoFilters.updateAndRenderFaceSwitch(paramFrame, paramList, paramSet);
    }
    return localFrame;
  }
  
  public Frame renderFaceTransform(Frame paramFrame)
  {
    Frame localFrame = paramFrame;
    if (this.faceTransform != null) {
      localFrame = this.faceTransform.render(paramFrame);
    }
    return localFrame;
  }
  
  public Frame renderFilament(Frame paramFrame, PTFaceAttr paramPTFaceAttr)
  {
    Frame localFrame = paramFrame;
    if (this.mVideoFilters != null) {
      localFrame = this.mVideoFilters.updateAndRenderFilamentFilter(paramFrame, paramPTFaceAttr);
    }
    return localFrame;
  }
  
  public Frame renderFilamentParticle(Frame paramFrame, PTFaceAttr paramPTFaceAttr)
  {
    Frame localFrame = paramFrame;
    if (this.mVideoFilters != null) {
      localFrame = this.mVideoFilters.updateAndRenderFilamentParticleFilter(paramFrame, paramPTFaceAttr);
    }
    return localFrame;
  }
  
  public Frame renderHairCos(Frame paramFrame, PTFaceAttr paramPTFaceAttr, AIAttr paramAIAttr)
  {
    Frame localFrame = paramFrame;
    if (paramAIAttr != null)
    {
      localFrame = paramFrame;
      if (checkStickerType(AESticker.STICKER_TYPE.SEGMENT_HAIR_STICKER))
      {
        this.hairAttr = ((PTHairAttr)paramAIAttr.getRealtimeData(AEDetectorType.HAIR_SEGMENT.value));
        localFrame = this.mVideoFilters.updateAndRenderHairCos(paramFrame, paramPTFaceAttr, this.hairAttr);
      }
    }
    return localFrame;
  }
  
  public Frame renderHeadCropFilter(Frame paramFrame, PTFaceAttr paramPTFaceAttr)
  {
    return this.mVideoFilters.updateAndRenderHeadCropItemFilters(paramFrame, paramPTFaceAttr);
  }
  
  public void renderMultiViewer(Frame paramFrame, PTFaceAttr paramPTFaceAttr, AIAttr paramAIAttr, PTSegAttr paramPTSegAttr, Map<Integer, Frame> paramMap)
  {
    if (this.mVideoFilters != null) {
      this.mVideoFilters.updateAndRenderMultiViewerMaterial(paramMap, paramFrame, paramAIAttr, paramPTFaceAttr, paramPTSegAttr, this.hairAttr);
    }
  }
  
  public Frame renderParticleStatic(Frame paramFrame, PTDetectInfo paramPTDetectInfo, List<PointF> paramList)
  {
    Frame localFrame = paramFrame;
    if (this.mVideoFilters != null) {
      localFrame = this.mVideoFilters.updateParticleStatic(paramFrame, paramPTDetectInfo, paramList);
    }
    return localFrame;
  }
  
  public Frame renderPhantomFilter(Frame paramFrame, PTFaceAttr paramPTFaceAttr)
  {
    Frame localFrame = paramFrame;
    if (this.mVideoFilters != null) {
      localFrame = this.mVideoFilters.updateAndRenderPhantomFilter(paramFrame, paramPTFaceAttr);
    }
    return localFrame;
  }
  
  public Frame renderRapidNet(Frame paramFrame, PTFaceAttr paramPTFaceAttr)
  {
    Frame localFrame = paramFrame;
    if (this.mVideoFilters != null) {
      localFrame = this.mVideoFilters.updateAndRenderRapidNet(paramFrame, paramPTFaceAttr);
    }
    return localFrame;
  }
  
  public Frame renderSkyFilter(Frame paramFrame, PTFaceAttr paramPTFaceAttr, AIAttr paramAIAttr)
  {
    if ((paramAIAttr != null) && (checkStickerType(AESticker.STICKER_TYPE.SEGMENT_SKY_STICKER))) {
      this.skyAttr = ((PTSkyAttr)paramAIAttr.getRealtimeData(AEDetectorType.SKY_SEGMENT.value));
    }
    if (this.skyAttr != null) {
      this.mVideoFilters.updateAndRenderLut(paramFrame, paramPTFaceAttr, this.skyAttr.getMaskBitmap());
    }
    return this.mVideoFilters.updateAndRenderSkybox(paramFrame, paramPTFaceAttr);
  }
  
  public Frame renderStickerAfter(Frame paramFrame, PTFaceAttr paramPTFaceAttr)
  {
    Frame localFrame = paramFrame;
    if (this.mVideoFilters != null)
    {
      localFrame = paramFrame;
      if (!this.mVideoFilters.renderStaticStickerFirst())
      {
        localFrame = paramFrame;
        if (allBusinessPrivateProcess(this.mVideoFilters.getRenderItems())) {
          localFrame = this.mVideoFilters.updateAndRenderStaticStickersPluggable(paramFrame, paramPTFaceAttr);
        }
      }
    }
    return localFrame;
  }
  
  public Frame renderStickerBefore(Frame paramFrame, PTFaceAttr paramPTFaceAttr)
  {
    Frame localFrame = paramFrame;
    if (this.mVideoFilters != null)
    {
      localFrame = paramFrame;
      if (this.mVideoFilters.renderStaticStickerFirst())
      {
        localFrame = paramFrame;
        if (allBusinessPrivateProcess(this.mVideoFilters.getRenderItems())) {
          localFrame = this.mVideoFilters.updateAndRenderStaticStickersPluggable(paramFrame, paramPTFaceAttr);
        }
      }
    }
    return localFrame;
  }
  
  public Frame renderZoomFilter(Frame paramFrame, Map<Integer, Frame> paramMap)
  {
    Frame localFrame = paramFrame;
    if (paramMap.isEmpty())
    {
      localFrame = paramFrame;
      if (this.mVideoFilters != null) {
        localFrame = this.mVideoFilters.zoomFrame(paramFrame);
      }
      paramMap.put(Integer.valueOf(0), localFrame);
    }
    return localFrame;
  }
  
  public void reset()
  {
    this.faceDetector.clearActionCounter();
    this.mVideoFilters.reset();
    this.mLastTimeStamp = 0L;
    this.mPauseTimeDiff = 0L;
    this.mPause = false;
  }
  
  public void setAIAttr(AIAttr paramAIAttr)
  {
    this.mAIAttr = paramAIAttr;
    this.mBeforeTransFilter.setAIAttr(paramAIAttr);
    this.mAfterTransFilter.setAIAttr(paramAIAttr);
    this.mVideoFilters.setAiAttr(paramAIAttr);
  }
  
  public void setBackgroundTransparent(boolean paramBoolean)
  {
    this.enableBGTransparent = paramBoolean;
  }
  
  public void setDoStrokeShake(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.doStrokeShake = paramBoolean1;
    this.enableStrokeShakeGauss = paramBoolean2;
  }
  
  public void setFaceAttr(PTFaceAttr paramPTFaceAttr)
  {
    this.faceAttr = paramPTFaceAttr;
    this.mBeforeTransFilter.setFaceAttr(paramPTFaceAttr);
    this.mAfterTransFilter.setFaceAttr(paramPTFaceAttr);
  }
  
  public void setFilamentDirectionColor(String paramString)
  {
    this.mVideoFilters.setFilamentDirectionColor(paramString);
  }
  
  public void setFilamentDirectionIntensity(int paramInt)
  {
    this.mVideoFilters.setFilamentDirectionIntensity(paramInt);
  }
  
  public void setFilamentIblIntensity(int paramInt)
  {
    this.mVideoFilters.setFilamentIblIntensity(paramInt);
  }
  
  public void setFilamentIblIntensityKey(float paramFloat1, float paramFloat2)
  {
    this.mVideoFilters.updateIntensity(paramFloat1, 0, 0);
    this.mVideoFilters.updateIntensity(paramFloat2, 1, 0);
  }
  
  public void setFilamentIblIntensityValue(float paramFloat1, float paramFloat2)
  {
    this.mVideoFilters.updateIntensity(paramFloat1, 0, 1);
    this.mVideoFilters.updateIntensity(paramFloat2, 1, 1);
  }
  
  public void setFilamentIblRotation(int paramInt)
  {
    this.mVideoFilters.setFilamentIblRotation(paramInt);
  }
  
  public void setFilamentLightDirection(float paramFloat1, float paramFloat2)
  {
    this.mVideoFilters.setFilamentLightDirection(paramFloat1, paramFloat2);
  }
  
  public void setFilamentLightIntensity(int paramInt)
  {
    this.mVideoFilters.setFilamentLightIntensity(paramInt);
  }
  
  public void setFilamentPosition(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.mVideoFilters.setFilamentPosition(paramFloat1, paramFloat2, paramFloat3);
  }
  
  public void setFilamentRotation(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.mVideoFilters.setFilamentRotation(paramFloat1, paramFloat2, paramFloat3);
  }
  
  public void setFilamentScale(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.mVideoFilters.setFilamentScale(paramFloat1, paramFloat2, paramFloat3);
  }
  
  public void setHotAreaPositions(ArrayList<RedPacketPosition> paramArrayList)
  {
    if (this.mVideoFilters != null) {
      this.mVideoFilters.setHotAreaPositions(paramArrayList);
    }
  }
  
  public void setMuteState(boolean paramBoolean)
  {
    VideoPrefsUtil.setMaterialMute(paramBoolean);
  }
  
  public void setOnLoadFinishListener(MaterialLoadFinishListener paramMaterialLoadFinishListener)
  {
    this.mVideoFilters.setOnLoadFinishListener(paramMaterialLoadFinishListener);
  }
  
  public void setPTFaceTransform(AEFaceTransform paramAEFaceTransform)
  {
    this.faceTransform = paramAEFaceTransform;
  }
  
  public void setRatio(float paramFloat)
  {
    this.mVideoFilters.setRatio(paramFloat);
  }
  
  public void setRenderMode(int paramInt)
  {
    this.mVideoFilters.setRenderMode(paramInt);
  }
  
  public void setSegAttr(PTSegAttr paramPTSegAttr)
  {
    this.mBeforeTransFilter.setSegAttr(paramPTSegAttr);
    this.mAfterTransFilter.setSegAttr(paramPTSegAttr);
  }
  
  public void setShookHeadCount(int paramInt)
  {
    this.mVideoFilters.shookHeadCount = paramInt;
  }
  
  public void setTouchTriggerEvent(int paramInt)
  {
    TouchTriggerManager.getInstance().setTouchState(paramInt);
  }
  
  public void setTouchTriggerEvent(int paramInt, float paramFloat1, float paramFloat2)
  {
    TouchTriggerManager.getInstance().setTouchState(paramInt, paramFloat1, paramFloat2);
  }
  
  public void setUseStickerPlugin(boolean paramBoolean)
  {
    this.isUseStickerPlugin = paramBoolean;
  }
  
  public void stopInnerEffectFilter()
  {
    if (isExcludeOuterEffectFilterMaterial()) {
      this.mVideoFilters.setVideoEffectOrder(-1);
    }
  }
  
  public void unclockHairMaskFrame()
  {
    if ((this.hairAttr != null) && (this.hairAttr.getMaskFrame() != null))
    {
      this.hairAttr.getMaskFrame().setCanUnlock(true);
      this.hairAttr.getMaskFrame().unlock();
    }
  }
  
  public void updateCosAlpha(int paramInt)
  {
    this.mVideoFilters.updateCosAlpha(paramInt);
  }
  
  public Frame updateInputFrame(Frame paramFrame)
  {
    Frame localFrame = paramFrame;
    if (this.mVideoFilters != null)
    {
      localFrame = paramFrame;
      if (this.mVideoFilters.isFreezeFrame()) {
        localFrame = this.mVideoFilters.updateInputFrame(paramFrame);
      }
    }
    return localFrame;
  }
  
  public void updateIntensity(float paramFloat, int paramInt1, int paramInt2)
  {
    this.mVideoFilters.updateIntensity(paramFloat, paramInt1, paramInt2);
  }
  
  public PTFaceAttr updatePTFaceAttr(PTFaceAttr paramPTFaceAttr)
  {
    PTFaceAttr localPTFaceAttr = paramPTFaceAttr;
    if (this.mVideoFilters != null)
    {
      localPTFaceAttr = paramPTFaceAttr;
      if (this.mVideoFilters.isFreezeFrame()) {
        localPTFaceAttr = this.mVideoFilters.updatePTFaceAttr(paramPTFaceAttr);
      }
    }
    return localPTFaceAttr;
  }
  
  public PTSegAttr updatePTSegAttr(PTSegAttr paramPTSegAttr)
  {
    PTSegAttr localPTSegAttr = paramPTSegAttr;
    if (this.mVideoFilters != null)
    {
      localPTSegAttr = paramPTSegAttr;
      if (this.mVideoFilters.isFreezeFrame()) {
        localPTSegAttr = this.mVideoFilters.updatePTSegAttr(paramPTSegAttr);
      }
    }
    return localPTSegAttr;
  }
  
  public void updatePcmBuffer8Bit(byte[] paramArrayOfByte, int paramInt)
  {
    paramInt = AudioUtil.getPcmDB8Bit(paramArrayOfByte, paramInt);
    AudioDataManager.getInstance().setPcmDecibel(paramInt);
  }
  
  public void updateTriggerManager()
  {
    Set localSet = this.faceAttr.getTriggeredExpression();
    Object localObject2;
    Object localObject1;
    if (this.mAIAttr != null)
    {
      localObject2 = (PTHandAttr)this.mAIAttr.getAvailableData(AEDetectorType.HAND.value);
      if (localObject2 != null)
      {
        localObject1 = ((PTHandAttr)localObject2).getHandPointList();
        localSet.add(Integer.valueOf(((PTHandAttr)localObject2).getHandType()));
      }
    }
    for (;;)
    {
      long l = getUpdateTimeStamp(this.faceAttr.getTimeStamp());
      this.faceAttr.setTimeStamp(l);
      Map localMap = this.faceAttr.getFaceActionCounter();
      int i = this.faceAttr.getRotation();
      localObject2 = this.faceAttr.getAllFacePoints();
      if ((localObject2 != null) && (((List)localObject2).size() > 0)) {}
      for (localObject2 = (List)((List)localObject2).get(0);; localObject2 = null)
      {
        Object localObject4 = new ArrayList();
        Object localObject3 = localObject4;
        Object localObject5;
        if (needDetectBody())
        {
          localObject3 = localObject4;
          if (this.mAIAttr != null)
          {
            localObject5 = (List)this.mAIAttr.getAvailableData(AEDetectorType.BODY.value);
            localObject3 = localObject4;
            if (localObject5 != null)
            {
              localObject3 = localObject4;
              if (((List)localObject5).size() > 0) {
                localObject3 = ((BodyDetectResult)((List)localObject5).get(0)).bodyPoints;
              }
            }
          }
        }
        localObject4 = this.faceAttr.getAllFaceAngles();
        if ((localObject4 != null) && (((List)localObject4).size() > 0)) {}
        for (localObject4 = (float[])((List)localObject4).get(0);; localObject4 = null)
        {
          if ((this.faceAttr.getFaceStatusList() != null) && (this.faceAttr.getFaceStatusList().size() > 0)) {}
          for (localObject5 = (FaceStatus)this.faceAttr.getFaceStatusList().get(0);; localObject5 = null)
          {
            localObject1 = new PTDetectInfo.Builder().facePoints((List)localObject2).faceAngles((float[])localObject4).phoneAngle((i + 360) % 360).faceActionCounter(localMap).aiAttr(this.mAIAttr).bodyPoints((List)localObject3).handActionCounter(AIActionCounter.getActions(AEDetectorType.HAND)).triggeredExpression(localSet).handPoints((List)localObject1).faceStatus((FaceStatus)localObject5).timestamp(l).faceDetector(this.faceAttr.getFaceDetector()).build();
            this.mVideoFilters.updateTriggerManager((PTDetectInfo)localObject1);
            return;
          }
        }
      }
      localObject1 = null;
    }
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    if (this.mVideoFilters != null)
    {
      this.mVideoFilters.updateVideoSize(paramInt1, paramInt2, paramDouble);
      this.mVideoFilters.setRatio(paramInt1 / paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.aekit.api.standard.filter.AESticker
 * JD-Core Version:    0.7.0.1
 */