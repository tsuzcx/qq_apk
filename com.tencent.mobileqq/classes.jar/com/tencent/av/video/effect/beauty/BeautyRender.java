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
    paramContext = new StringBuilder();
    paramContext.append("new BeautyRender resPath = ");
    paramContext.append(paramString);
    Log.d("BeautyRender", paramContext.toString());
    addTaskBeforeProcess(new BeautyRender.1(this, paramString));
  }
  
  public void destroy()
  {
    super.destroy();
    QQAVImageBeautyFilter localQQAVImageBeautyFilter = this.mBeautyFilter;
    if (localQQAVImageBeautyFilter != null)
    {
      localQQAVImageBeautyFilter.destroy();
      this.mBeautyFilter = null;
    }
  }
  
  public void preProcess(int paramInt1, int paramInt2)
  {
    baseProcess(paramInt1, paramInt2);
    QQAVImageBeautyFilter localQQAVImageBeautyFilter = this.mBeautyFilter;
    if (localQQAVImageBeautyFilter != null) {
      localQQAVImageBeautyFilter.onOutputSizeChanged(paramInt1, paramInt2);
    }
  }
  
  public EffectTexture process(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    EffectTexture localEffectTexture = super.process(paramInt1, paramInt2, paramInt3, paramInt4);
    QQAVImageBeautyFilter localQQAVImageBeautyFilter = this.mBeautyFilter;
    if ((localQQAVImageBeautyFilter != null) && ((localQQAVImageBeautyFilter.isUseMultiParams()) || (this.mBeautyFilter.getAmount() != 0.0F)) && ((!this.mBeautyFilter.isUseMultiParams()) || (this.mBeautyFilter.getMixPercent() != 0.0F) || (this.mBeautyFilter.getSharpness() != 0.0F) || (this.mBeautyFilter.getExposure() != 0.0F)))
    {
      this.mBeautyFilter.onOutputSizeChanged(this.mWidth, this.mHeight);
      this.mBeautyFilter.onDraw2(localEffectTexture.getTextureId(), this.mOutFbo);
      CommonUtils.glCheckError();
      return new EffectTexture(this.mOutTextureId, this.mOutFbo, this.mWidth, this.mHeight);
    }
    Log.d("BeautyRender", "need not process beauty.");
    CommonUtils.glCheckError();
    return localEffectTexture;
  }
  
  public void setBeautyLevel(float paramFloat)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setBeautyLevel level = ");
    localStringBuilder.append(paramFloat);
    Log.d("BeautyRender", localStringBuilder.toString());
    addTaskBeforeProcess(new BeautyRender.2(this, paramFloat));
  }
  
  public void setBeautyLevel(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setBeautyLevel mixPercent = ");
    localStringBuilder.append(paramFloat1);
    localStringBuilder.append(" | sharpen =");
    localStringBuilder.append(paramFloat2);
    localStringBuilder.append(" | exposure = ");
    localStringBuilder.append(paramFloat3);
    Log.d("BeautyRender", localStringBuilder.toString());
    addTaskBeforeProcess(new BeautyRender.3(this, paramFloat1, paramFloat2, paramFloat3));
  }
  
  public void setNeedSkinColor(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setNeedSkinColor isNeed = ");
    localStringBuilder.append(paramBoolean);
    Log.d("BeautyRender", localStringBuilder.toString());
    addTaskBeforeProcess(new BeautyRender.4(this, paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.video.effect.beauty.BeautyRender
 * JD-Core Version:    0.7.0.1
 */