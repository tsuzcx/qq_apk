package com.tencent.aekit.api.standard.filter;

import android.opengl.GLES20;
import android.util.Log;
import com.tencent.aekit.openrender.internal.AEChainI;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.aekit.plugin.core.AEDetectorType;
import com.tencent.aekit.plugin.core.AIAttr;
import com.tencent.aekit.plugin.core.PTHandAttr;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.audio.AudioDataManager;
import com.tencent.ttpic.audio.LocalAudioDataManager;
import com.tencent.ttpic.baseutils.fps.BenchUtil;
import com.tencent.ttpic.filter.SplitFilter;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.PTSegAttr;
import com.tencent.ttpic.openapi.cache.VideoMemoryManager;
import com.tencent.ttpic.openapi.filter.BuckleFaceFilter;
import com.tencent.ttpic.openapi.filter.VideoFilterList;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.util.VideoFilterUtil;
import com.tencent.ttpic.openapi.util.VideoSDKMaterialParser;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class AESimpleSticker
  extends AEChainI
{
  public static final String PERF_LOG = "[showPreview]";
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
  
  private boolean allBusinessPrivateProcess(List<VideoFilterBase> paramList)
  {
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        VideoFilterBase localVideoFilterBase = (VideoFilterBase)paramList.next();
        if ((localVideoFilterBase instanceof BuckleFaceFilter)) {
          return ((BuckleFaceFilter)localVideoFilterBase).isNeedRender();
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
    this.mCopyFilter.ClearGLSL();
    this.mSplitFilter.ClearGLSL();
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
  
  public List<VideoFilterBase> getFilters()
  {
    return this.mVideoFilters.getFilters();
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
      if (allBusinessPrivateProcess(this.mVideoFilters.getFilters())) {
        paramFrame = this.mVideoFilters.updateAndRenderStaticStickers(paramPTSegAttr, paramPTFaceAttr);
      }
    }
    BenchUtil.benchStart("[showPreview]updateAndRender - DO_NOT_RENDER_FACE_OFF_FILTER");
    paramPTSegAttr = this.mVideoFilters.updateAndRenderDynamicStickers(paramFrame, paramPTFaceAttr, paramAIAttr);
    BenchUtil.benchEnd("[showPreview]updateAndRender - DO_NOT_RENDER_FACE_OFF_FILTER");
    paramFrame = paramPTSegAttr;
    if (!this.mVideoFilters.renderStaticStickerFirst())
    {
      paramFrame = paramPTSegAttr;
      if (allBusinessPrivateProcess(this.mVideoFilters.getFilters())) {
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
    this.mVideoFilters.updateFaceParams(this.aiAttr, this.mFaceAttr, paramFrame.width);
    Frame localFrame = processStickerFilters(this.mVideoFilters.processTransformRelatedFilters(paramFrame, this.mFaceAttr), this.mFaceAttr, null, null);
    if (paramFrame != localFrame) {
      paramFrame.unlock();
    }
    return localFrame;
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
    this.mFaceAttr = paramPTFaceAttr;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.aekit.api.standard.filter.AESimpleSticker
 * JD-Core Version:    0.7.0.1
 */