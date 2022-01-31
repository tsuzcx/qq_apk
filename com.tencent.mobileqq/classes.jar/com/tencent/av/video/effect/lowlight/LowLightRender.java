package com.tencent.av.video.effect.lowlight;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.av.video.effect.core.BaseRender;
import com.tencent.av.video.effect.core.EffectTexture;
import com.tencent.av.video.effect.core.qqavimage.lowlight.QQAVImageLowLightFilter;
import com.tencent.av.video.effect.utils.CommonUtils;
import com.tencent.av.video.effect.utils.Log;
import java.lang.ref.WeakReference;

public class LowLightRender
  extends BaseRender
{
  private static final String TAG = "LowLightRender";
  private WeakReference<Context> mContextReference;
  private QQAVImageLowLightFilter mLowLightFilter = null;
  private Bitmap mLowLightImage = null;
  
  public LowLightRender(Context paramContext)
  {
    this.mContextReference = new WeakReference(paramContext);
    this.mLowLightImage = LowLightTools.getLowLightImage(3.0F, 0.88F, 0.96F, 1.22F, false);
    Log.d("LowLightRender", "new LowLightRender");
    addTaskBeforeProcess(new Runnable()
    {
      public void run()
      {
        LowLightRender.access$002(LowLightRender.this, new QQAVImageLowLightFilter());
        LowLightRender.this.mLowLightFilter.setLowLightImage(LowLightRender.this.mLowLightImage);
        LowLightRender.this.mLowLightFilter.init();
      }
    });
  }
  
  public LowLightRender(Context paramContext, String paramString)
  {
    this.mContextReference = new WeakReference(paramContext);
    this.mLowLightImage = LowLightTools.getLowLightImage(paramContext, paramString);
    Log.d("LowLightRender", "new LowLightRender resPath = " + paramString);
    addTaskBeforeProcess(new Runnable()
    {
      public void run()
      {
        LowLightRender.access$002(LowLightRender.this, new QQAVImageLowLightFilter());
        LowLightRender.this.mLowLightFilter.setLowLightImage(LowLightRender.this.mLowLightImage);
        LowLightRender.this.mLowLightFilter.init();
      }
    });
  }
  
  public void destroy()
  {
    super.destroy();
    if (this.mLowLightFilter != null)
    {
      this.mLowLightFilter.destroy();
      this.mLowLightFilter = null;
    }
  }
  
  public void preProcess(int paramInt1, int paramInt2)
  {
    baseProcess(paramInt1, paramInt2);
    if (this.mLowLightFilter != null) {
      this.mLowLightFilter.onOutputSizeChanged(paramInt1, paramInt2);
    }
  }
  
  public EffectTexture process(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    EffectTexture localEffectTexture = super.process(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.mLowLightFilter == null)
    {
      Log.d("LowLightRender", "mLowLightFilter = null");
      CommonUtils.glCheckError();
      return localEffectTexture;
    }
    this.mLowLightFilter.onOutputSizeChanged(this.mWidth, this.mHeight);
    this.mLowLightFilter.onDraw2(localEffectTexture.getTextureId(), this.mOutFbo);
    CommonUtils.glCheckError();
    return new EffectTexture(this.mOutTextureId, this.mOutFbo, this.mWidth, this.mHeight);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.video.effect.lowlight.LowLightRender
 * JD-Core Version:    0.7.0.1
 */