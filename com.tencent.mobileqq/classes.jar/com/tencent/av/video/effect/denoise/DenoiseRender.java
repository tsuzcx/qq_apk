package com.tencent.av.video.effect.denoise;

import android.content.Context;
import com.tencent.av.video.effect.core.BaseRender;
import com.tencent.av.video.effect.core.EffectTexture;
import com.tencent.av.video.effect.core.qqavimage.denoise.QQAVImageDenoiseFilter;
import com.tencent.av.video.effect.utils.CommonUtils;
import com.tencent.av.video.effect.utils.Log;
import java.lang.ref.WeakReference;

public class DenoiseRender
  extends BaseRender
{
  private static final String TAG = "DenoiseRender";
  private WeakReference<Context> mContextReference;
  private QQAVImageDenoiseFilter mDenoiseFilter = null;
  
  public DenoiseRender(Context paramContext)
  {
    this.mContextReference = new WeakReference(paramContext);
    Log.d("DenoiseRender", "new DenoiseRender");
    addTaskBeforeProcess(new DenoiseRender.1(this));
  }
  
  public void destroy()
  {
    super.destroy();
    QQAVImageDenoiseFilter localQQAVImageDenoiseFilter = this.mDenoiseFilter;
    if (localQQAVImageDenoiseFilter != null)
    {
      localQQAVImageDenoiseFilter.destroy();
      this.mDenoiseFilter = null;
    }
  }
  
  public void preProcess(int paramInt1, int paramInt2)
  {
    baseProcess(paramInt1, paramInt2);
    QQAVImageDenoiseFilter localQQAVImageDenoiseFilter = this.mDenoiseFilter;
    if (localQQAVImageDenoiseFilter != null) {
      localQQAVImageDenoiseFilter.onOutputSizeChanged(paramInt1, paramInt2);
    }
  }
  
  public EffectTexture process(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    EffectTexture localEffectTexture = super.process(paramInt1, paramInt2, paramInt3, paramInt4);
    QQAVImageDenoiseFilter localQQAVImageDenoiseFilter = this.mDenoiseFilter;
    if (localQQAVImageDenoiseFilter == null)
    {
      Log.d("DenoiseRender", "mDenoiseFilter = null");
      CommonUtils.glCheckError();
      return localEffectTexture;
    }
    localQQAVImageDenoiseFilter.onOutputSizeChanged(this.mWidth, this.mHeight);
    this.mDenoiseFilter.onDraw2(localEffectTexture.getTextureId(), this.mOutFbo);
    CommonUtils.glCheckError();
    return new EffectTexture(this.mOutTextureId, this.mOutFbo, this.mWidth, this.mHeight);
  }
  
  public void setUpdateRate(float paramFloat)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setUpdateRate updateRate = ");
    localStringBuilder.append(paramFloat);
    Log.d("DenoiseRender", localStringBuilder.toString());
    addTaskBeforeProcess(new DenoiseRender.2(this, paramFloat));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.video.effect.denoise.DenoiseRender
 * JD-Core Version:    0.7.0.1
 */