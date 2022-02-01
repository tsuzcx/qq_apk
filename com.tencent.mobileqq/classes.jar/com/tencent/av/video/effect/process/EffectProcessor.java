package com.tencent.av.video.effect.process;

import com.tencent.av.video.effect.beauty.Beauty20Render;
import com.tencent.av.video.effect.beauty.Beauty25Render;
import com.tencent.av.video.effect.beauty.BeautyRender;
import com.tencent.av.video.effect.core.EffectFrame;
import com.tencent.av.video.effect.denoise.DenoiseRender;
import com.tencent.av.video.effect.filter.FilterRender;
import com.tencent.av.video.effect.lowlight.LowLightRender;
import com.tencent.av.video.effect.utils.TextureDataLoader;

public class EffectProcessor
{
  public static final int PROCESS_ERR_FAIL = 1;
  private static final String TAG = "EffectProcessor";
  private int[] lowlightinfo = new int[2];
  private Beauty20Render mBeauty20Render;
  private Beauty25Render mBeauty25Render;
  private BeautyRender mBeautyRender;
  private int mDataLoaderTextureId = -1;
  private DenoiseRender mDenoiseRender;
  private FilterRender mFilterRender;
  private LowLightRender mLowLightRender;
  private OffscreenGLContext mOffscreenGLContext = new OffscreenGLContext();
  private int mPicTextureId = -1;
  private EffectProcessor.ProcessCallback mProcessCallback;
  private BeautyRender mTempBeautyRender;
  private TextureDataLoader mTextureDataLoader;
  
  public EffectProcessor()
  {
    this.mOffscreenGLContext.post(new EffectProcessor.1(this));
  }
  
  public void destroy()
  {
    this.mOffscreenGLContext.post(new EffectProcessor.5(this));
  }
  
  public void process(EffectFrame paramEffectFrame)
  {
    EffectProcessor.ProcessCallback localProcessCallback;
    if (this.mOffscreenGLContext == null)
    {
      localProcessCallback = this.mProcessCallback;
      if (localProcessCallback != null)
      {
        localProcessCallback.onComplete(paramEffectFrame);
        this.mProcessCallback.onError(paramEffectFrame, 1, "no opengl context!");
      }
    }
    else
    {
      if ((paramEffectFrame != null) && (paramEffectFrame.frameData != null) && (paramEffectFrame.frameData.length != 0) && (paramEffectFrame.frameWidth != 0) && (paramEffectFrame.frameHeight != 0) && (paramEffectFrame.frameFormat != null))
      {
        this.mOffscreenGLContext.post(new EffectProcessor.4(this, paramEffectFrame));
        return;
      }
      localProcessCallback = this.mProcessCallback;
      if (localProcessCallback != null)
      {
        localProcessCallback.onComplete(paramEffectFrame);
        this.mProcessCallback.onError(paramEffectFrame, 1, "invalid input frame!");
      }
    }
  }
  
  public void setBeauty20Render(Beauty20Render paramBeauty20Render)
  {
    this.mBeauty20Render = paramBeauty20Render;
    this.mBeauty25Render = null;
    this.mTempBeautyRender = this.mBeautyRender;
    this.mOffscreenGLContext.post(new EffectProcessor.3(this));
    this.mBeautyRender = null;
  }
  
  public void setBeauty25Render(Beauty25Render paramBeauty25Render)
  {
    this.mBeauty25Render = paramBeauty25Render;
    this.mBeauty20Render = null;
    this.mTempBeautyRender = this.mBeautyRender;
    this.mOffscreenGLContext.post(new EffectProcessor.2(this));
    this.mBeautyRender = null;
  }
  
  public void setBeautyRender(BeautyRender paramBeautyRender)
  {
    this.mBeautyRender = paramBeautyRender;
    this.mBeauty20Render = null;
    this.mBeauty25Render = null;
  }
  
  public void setDenoiseRender(DenoiseRender paramDenoiseRender)
  {
    this.mDenoiseRender = paramDenoiseRender;
  }
  
  public void setFilterRender(FilterRender paramFilterRender)
  {
    this.mFilterRender = paramFilterRender;
  }
  
  public void setLowLightRender(LowLightRender paramLowLightRender)
  {
    this.mLowLightRender = paramLowLightRender;
  }
  
  public void setProcessCallback(EffectProcessor.ProcessCallback paramProcessCallback)
  {
    this.mProcessCallback = paramProcessCallback;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.video.effect.process.EffectProcessor
 * JD-Core Version:    0.7.0.1
 */