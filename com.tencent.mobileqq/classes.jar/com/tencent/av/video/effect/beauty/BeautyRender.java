package com.tencent.av.video.effect.beauty;

import android.content.Context;
import com.tencent.av.video.effect.core.BaseRender;
import com.tencent.av.video.effect.core.EffectTexture;
import com.tencent.av.video.effect.core.qqavimage.beauty.QQAVImageBeautyFilter;
import com.tencent.av.video.effect.filter.FilterFactory;
import com.tencent.av.video.effect.utils.CommonUtils;
import com.tencent.av.video.effect.utils.Log;
import java.io.File;
import java.lang.ref.WeakReference;

public class BeautyRender
  extends BaseRender
{
  private static final String SKIN_COLOR_FOLDER = "SKINCOLOR";
  private static final String TAG = "BeautyRender";
  private QQAVImageBeautyFilter mBeautyFilter;
  private WeakReference<Context> mContextReference;
  private FilterFactory mFilterFactory;
  
  public BeautyRender(Context paramContext, final String paramString)
  {
    this.mContextReference = new WeakReference(paramContext);
    this.mFilterFactory = new FilterFactory(paramContext);
    Log.d("BeautyRender", "new BeautyRender resPath = " + paramString);
    addTaskBeforeProcess(new Runnable()
    {
      public void run()
      {
        BeautyRender.access$002(BeautyRender.this, new QQAVImageBeautyFilter());
        BeautyRender.this.mBeautyFilter.setSkinColorFilter(BeautyRender.this.mFilterFactory.getFilter(paramString + File.separator + "SKINCOLOR"));
        BeautyRender.this.mBeautyFilter.init();
      }
    });
  }
  
  public void destroy()
  {
    super.destroy();
    if (this.mBeautyFilter != null)
    {
      this.mBeautyFilter.destroy();
      this.mBeautyFilter = null;
    }
  }
  
  public void preProcess(int paramInt1, int paramInt2)
  {
    baseProcess(paramInt1, paramInt2);
    if (this.mBeautyFilter != null) {
      this.mBeautyFilter.onOutputSizeChanged(paramInt1, paramInt2);
    }
  }
  
  public EffectTexture process(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    EffectTexture localEffectTexture = super.process(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this.mBeautyFilter == null) || ((!this.mBeautyFilter.isUseMultiParams()) && (this.mBeautyFilter.getAmount() == 0.0F)) || ((this.mBeautyFilter.isUseMultiParams()) && (this.mBeautyFilter.getMixPercent() == 0.0F) && (this.mBeautyFilter.getSharpness() == 0.0F) && (this.mBeautyFilter.getExposure() == 0.0F)))
    {
      Log.d("BeautyRender", "need not process beauty.");
      CommonUtils.glCheckError();
      return localEffectTexture;
    }
    this.mBeautyFilter.onOutputSizeChanged(this.mWidth, this.mHeight);
    this.mBeautyFilter.onDraw2(localEffectTexture.getTextureId(), this.mOutFbo);
    CommonUtils.glCheckError();
    return new EffectTexture(this.mOutTextureId, this.mOutFbo, this.mWidth, this.mHeight);
  }
  
  public void setBeautyLevel(final float paramFloat)
  {
    Log.d("BeautyRender", "setBeautyLevel level = " + paramFloat);
    addTaskBeforeProcess(new Runnable()
    {
      public void run()
      {
        if (BeautyRender.this.mBeautyFilter != null) {
          BeautyRender.this.mBeautyFilter.setAmount(paramFloat);
        }
      }
    });
  }
  
  public void setBeautyLevel(final float paramFloat1, final float paramFloat2, final float paramFloat3)
  {
    Log.d("BeautyRender", "setBeautyLevel mixPercent = " + paramFloat1 + " | sharpen =" + paramFloat2 + " | exposure = " + paramFloat3);
    addTaskBeforeProcess(new Runnable()
    {
      public void run()
      {
        if (BeautyRender.this.mBeautyFilter != null) {
          BeautyRender.this.mBeautyFilter.setBeauty(paramFloat1, paramFloat2, paramFloat3);
        }
      }
    });
  }
  
  public void setNeedSkinColor(final boolean paramBoolean)
  {
    Log.d("BeautyRender", "setNeedSkinColor isNeed = " + paramBoolean);
    addTaskBeforeProcess(new Runnable()
    {
      public void run()
      {
        if (BeautyRender.this.mBeautyFilter != null) {
          BeautyRender.this.mBeautyFilter.setNeedSkinColor(paramBoolean);
        }
      }
    });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.video.effect.beauty.BeautyRender
 * JD-Core Version:    0.7.0.1
 */