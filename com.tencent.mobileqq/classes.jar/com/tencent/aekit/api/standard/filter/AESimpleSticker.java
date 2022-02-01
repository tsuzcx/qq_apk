package com.tencent.aekit.api.standard.filter;

import android.opengl.GLES20;
import android.util.Log;
import com.tencent.aekit.openrender.internal.AEChainI;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.plugin.core.AEDetectorType;
import com.tencent.aekit.plugin.core.AIActionCounter;
import com.tencent.aekit.plugin.core.AIAttr;
import com.tencent.aekit.plugin.core.PTHandAttr;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.audio.AudioDataManager;
import com.tencent.ttpic.audio.LocalAudioDataManager;
import com.tencent.ttpic.baseutils.fps.BenchUtil;
import com.tencent.ttpic.facedetect.FaceStatus;
import com.tencent.ttpic.filter.SplitFilter;
import com.tencent.ttpic.openapi.PTDetectInfo;
import com.tencent.ttpic.openapi.PTDetectInfo.Builder;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.PTSegAttr;
import com.tencent.ttpic.openapi.cache.VideoMemoryManager;
import com.tencent.ttpic.openapi.filter.BuckleFaceFilter;
import com.tencent.ttpic.openapi.filter.RenderItem;
import com.tencent.ttpic.openapi.filter.VideoFilterList;
import com.tencent.ttpic.openapi.manager.TouchTriggerManager;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.util.VideoFilterUtil;
import com.tencent.ttpic.openapi.util.VideoSDKMaterialParser;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AESimpleSticker
  extends AEChainI
{
  private AIAttr aiAttr;
  private BaseFilter mCopyFilter = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  private Frame mCopyFrame = new Frame();
  private PTFaceAttr mFaceAttr;
  private Frame[] mInputFrame = new Frame[2];
  private int[] mInputTex = new int[1];
  private SplitFilter mSplitFilter = new SplitFilter();
  private VideoFilterList mVideoFilters;
  
  public AESimpleSticker(VideoMaterial paramVideoMaterial)
  {
    construct(paramVideoMaterial);
  }
  
  public AESimpleSticker(String paramString)
  {
    construct(VideoSDKMaterialParser.parseVideoMaterial(paramString, "params"));
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
  
  private void construct(VideoMaterial paramVideoMaterial)
  {
    if (paramVideoMaterial == null) {
      throw new RuntimeException("AESticker init fail!");
    }
    VideoMemoryManager.getInstance().loadAllImages(paramVideoMaterial);
    this.mVideoFilters = VideoFilterUtil.createFilters(paramVideoMaterial);
  }
  
  private boolean isAfterOrderSpecificFilter()
  {
    if (this.mVideoFilters == null) {}
    while (this.mVideoFilters.getVideoEffectOrder() != 101) {
      return false;
    }
    return true;
  }
  
  public void apply()
  {
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
  }
  
  public void clear()
  {
    clear(true);
  }
  
  public void clear(boolean paramBoolean)
  {
    Log.i("VideoMemoryManager", "AESticker clear! isClearMemory = " + paramBoolean);
    this.mCopyFilter.clearGLSL();
    this.mSplitFilter.clearGLSL();
    if (this.mVideoFilters != null)
    {
      this.mVideoFilters.destroy();
      localObject1 = this.mVideoFilters;
      VideoFilterList.sIsUseFreezeFrame = false;
    }
    Object localObject1 = this.mInputFrame;
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      Object localObject2 = localObject1[i];
      if (localObject2 != null) {
        localObject2.clear();
      }
      i += 1;
    }
    this.mCopyFrame.clear();
    GLES20.glDeleteTextures(this.mInputTex.length, this.mInputTex, 0);
    if (paramBoolean) {
      VideoMemoryManager.getInstance().clear();
    }
    LocalAudioDataManager.getInstance().destroy();
    AudioDataManager.getInstance().destroy();
  }
  
  public List<RenderItem> getRenderItems()
  {
    return this.mVideoFilters.getRenderItems();
  }
  
  public Frame processStickerFilters(Frame paramFrame, PTFaceAttr paramPTFaceAttr, PTSegAttr paramPTSegAttr, AIAttr paramAIAttr)
  {
    paramPTFaceAttr.getAllFacePoints();
    paramPTFaceAttr.getAllFaceAngles();
    paramPTFaceAttr.getRotation();
    paramPTSegAttr = paramPTFaceAttr.getTriggeredExpression();
    if (paramAIAttr != null)
    {
      PTHandAttr localPTHandAttr = (PTHandAttr)paramAIAttr.getAvailableData(AEDetectorType.HAND.value);
      if (localPTHandAttr != null) {
        paramPTSegAttr.add(Integer.valueOf(localPTHandAttr.getHandType()));
      }
    }
    this.mVideoFilters.renderARFilterIfNeeded(paramFrame);
    paramPTSegAttr = this.mVideoFilters.updateAndRenderHeadCropItemFilters(paramFrame, paramPTFaceAttr);
    paramFrame = paramPTSegAttr;
    if (this.mVideoFilters.isMaterialSegmentRequired()) {
      paramFrame = this.mVideoFilters.updateAndRenderBgFilters(paramPTSegAttr, paramPTFaceAttr);
    }
    paramPTSegAttr = this.mVideoFilters.renderEffectFilter(paramFrame, new int[] { 1 });
    paramFrame = paramPTSegAttr;
    if (this.mVideoFilters.renderStaticStickerFirst())
    {
      paramFrame = paramPTSegAttr;
      if (allBusinessPrivateProcess(this.mVideoFilters.getRenderItems())) {
        paramFrame = this.mVideoFilters.updateAndRenderStaticStickers(paramPTSegAttr, paramPTFaceAttr);
      }
    }
    BenchUtil.benchStart(BenchUtil.SHOWPREVIEW_BENCH_TAG + "updateAndRender - DO_NOT_RENDER_FACE_OFF_FILTER");
    paramFrame = this.mVideoFilters.updateAndRenderDynamicStickers(paramFrame, paramPTFaceAttr, paramAIAttr);
    BenchUtil.benchEnd(BenchUtil.SHOWPREVIEW_BENCH_TAG + "updateAndRender - DO_NOT_RENDER_FACE_OFF_FILTER");
    paramPTSegAttr = this.mVideoFilters.UKYOGameRender(paramFrame);
    paramFrame = paramPTSegAttr;
    if (!this.mVideoFilters.renderStaticStickerFirst())
    {
      paramFrame = paramPTSegAttr;
      if (allBusinessPrivateProcess(this.mVideoFilters.getRenderItems())) {
        paramFrame = this.mVideoFilters.updateAndRenderStaticStickers(paramPTSegAttr, paramPTFaceAttr);
      }
    }
    if (isAfterOrderSpecificFilter()) {
      return this.mVideoFilters.renderEffectFilter(paramFrame, new int[] { 101 });
    }
    return this.mVideoFilters.renderEffectFilter(paramFrame, new int[] { 2 });
  }
  
  public Frame render(Frame paramFrame)
  {
    Set localSet = this.mFaceAttr.getTriggeredExpression();
    Object localObject2;
    Object localObject1;
    if (this.aiAttr != null)
    {
      localObject2 = (PTHandAttr)this.aiAttr.getAvailableData(AEDetectorType.HAND.value);
      if (localObject2 != null)
      {
        localObject1 = ((PTHandAttr)localObject2).getHandPointList();
        localSet.add(Integer.valueOf(((PTHandAttr)localObject2).getHandType()));
      }
    }
    for (;;)
    {
      Map localMap = this.mFaceAttr.getFaceActionCounter();
      int i = this.mFaceAttr.getRotation();
      localObject2 = this.mFaceAttr.getAllFacePoints();
      if ((localObject2 != null) && (((List)localObject2).size() > 0)) {}
      for (localObject2 = (List)((List)localObject2).get(0);; localObject2 = null)
      {
        Object localObject3 = this.mFaceAttr.getAllFaceAngles();
        if ((localObject3 != null) && (((List)localObject3).size() > 0)) {}
        for (localObject3 = (float[])((List)localObject3).get(0);; localObject3 = null)
        {
          if ((this.mFaceAttr.getFaceStatusList() != null) && (this.mFaceAttr.getFaceStatusList().size() > 0)) {}
          for (FaceStatus localFaceStatus = (FaceStatus)this.mFaceAttr.getFaceStatusList().get(0);; localFaceStatus = null)
          {
            localObject1 = new PTDetectInfo.Builder().facePoints((List)localObject2).faceAngles((float[])localObject3).phoneAngle((i + 360) % 360).faceActionCounter(localMap).aiAttr(this.aiAttr).handActionCounter(AIActionCounter.getActions(AEDetectorType.HAND)).triggeredExpression(localSet).handPoints((List)localObject1).faceStatus(localFaceStatus).timestamp(this.mFaceAttr.getTimeStamp()).faceDetector(this.mFaceAttr.getFaceDetector()).build();
            TouchTriggerManager.getInstance().updateTouchTriggerState((PTDetectInfo)localObject1);
            this.mVideoFilters.updateTriggerManager((PTDetectInfo)localObject1);
            paramFrame = this.mVideoFilters.updateInputFrame(paramFrame);
            this.mVideoFilters.updateFaceParams(this.aiAttr, this.mFaceAttr, paramFrame.width);
            localObject1 = processStickerFilters(this.mVideoFilters.processTransformRelatedFilters(paramFrame, this.mFaceAttr), this.mFaceAttr, null, null);
            if (paramFrame != localObject1) {
              paramFrame.unlock();
            }
            return localObject1;
          }
        }
      }
      localObject1 = null;
    }
  }
  
  public void reset()
  {
    this.mVideoFilters.reset();
  }
  
  public void setAIAttr(AIAttr paramAIAttr)
  {
    this.aiAttr = paramAIAttr;
    this.mVideoFilters.setAiAttr(paramAIAttr);
  }
  
  public void setFaceAttr(PTFaceAttr paramPTFaceAttr)
  {
    PTFaceAttr localPTFaceAttr = paramPTFaceAttr;
    if (this.mVideoFilters != null) {
      localPTFaceAttr = this.mVideoFilters.updatePTFaceAttr(paramPTFaceAttr);
    }
    this.mFaceAttr = localPTFaceAttr;
  }
  
  public void setRatio(float paramFloat)
  {
    this.mVideoFilters.setRatio(paramFloat);
  }
  
  public void setRenderMode(int paramInt)
  {
    this.mVideoFilters.setRenderMode(paramInt);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.aekit.api.standard.filter.AESimpleSticker
 * JD-Core Version:    0.7.0.1
 */