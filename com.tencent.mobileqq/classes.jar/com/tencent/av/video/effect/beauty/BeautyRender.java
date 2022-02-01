package com.tencent.av.video.effect.beauty;

import android.content.Context;
import com.tencent.av.video.effect.core.BaseRender;
import com.tencent.av.video.effect.core.EffectTexture;
import com.tencent.av.video.effect.core.qqavimage.beauty.QQAVImageBeautyFilter;
import com.tencent.av.video.effect.filter.FilterFactory;
import com.tencent.av.video.effect.utils.CommonUtils;
import com.tencent.av.video.effect.utils.Log;
import java.lang.ref.WeakReference;

public class BeautyRender
  extends BaseRender
{
  private static final String SKIN_COLOR_FOLDER = "SKINCOLOR";
  private static final String TAG = "BeautyRender";
  private QQAVImageBeautyFilter mBeautyFilter;
  private WeakReference<Context> mContextReference;
  private FilterFactory mFilterFactory;
  
  public BeautyRender(Context paramContext, String paramString)
  {
    this.mContextReference = new WeakReference(paramContext);
    this.mFilterFactory = new FilterFactory(paramContext);
    Log.d("BeautyRender", "new BeautyRender resPath = " + paramString);
    addTaskBeforeProcess(new BeautyRender.1(this, paramString));
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
  
  public void setBeautyLevel(float paramFloat)
  {
    Log.d("BeautyRender", "setBeautyLevel level = " + paramFloat);
    addTaskBeforeProcess(new BeautyRender.2(this, paramFloat));
  }
  
  public void setBeautyLevel(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    Log.d("BeautyRender", "setBeautyLevel mixPercent = " + paramFloat1 + " | sharpen =" + paramFloat2 + " | exposure = " + paramFloat3);
    addTaskBeforeProcess(new BeautyRender.3(this, paramFloat1, paramFloat2, paramFloat3));
  }
  
  public void setNeedSkinColor(boolean paramBoolean)
  {
    Log.d("BeautyRender", "setNeedSkinColor isNeed = " + paramBoolean);
    addTaskBeforeProcess(new BeautyRender.4(this, paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.video.effect.beauty.BeautyRender
 * JD-Core Version:    0.7.0.1
 */