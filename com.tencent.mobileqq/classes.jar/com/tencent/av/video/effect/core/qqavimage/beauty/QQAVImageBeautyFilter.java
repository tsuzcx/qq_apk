package com.tencent.av.video.effect.core.qqavimage.beauty;

import android.opengl.GLES20;
import com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter;
import com.tencent.av.video.effect.utils.Log;

public class QQAVImageBeautyFilter
  extends QQAVImageFilter
{
  private static final String TAG = "QQAVImageBeautyFilter";
  private float mAmount = 0.3F;
  private float mExposure = 0.0F;
  private QQAVImageBeautyExposureAndOverlayFilter mExposureAndOverlayFilter = new QQAVImageBeautyExposureAndOverlayFilter();
  private int[] mFrameBufferTextures = new int[4];
  private int[] mFrameBuffers = new int[4];
  private QQAVImageBeautyHighPassFilter mHighPassFilter = new QQAVImageBeautyHighPassFilter();
  private boolean mIsNeedSkinColor = true;
  private boolean mIsUseMultiParams = false;
  private float mMixPercent = 0.0F;
  private QQAVImageBeautySharpenAndExposureFilter mSharpenAndExposureFilter = new QQAVImageBeautySharpenAndExposureFilter();
  private float mSharpness = 0.0F;
  private QQAVImageFilter mSkinColorFilter;
  private QQAVImageBeautySkinCurveAndComposeFilter mSkinCurveAndComposeFilter = new QQAVImageBeautySkinCurveAndComposeFilter();
  
  public QQAVImageBeautyFilter()
  {
    this(0.3F);
  }
  
  public QQAVImageBeautyFilter(float paramFloat)
  {
    this(paramFloat, null);
  }
  
  public QQAVImageBeautyFilter(float paramFloat, QQAVImageFilter paramQQAVImageFilter)
  {
    this.mSkinColorFilter = paramQQAVImageFilter;
    this.mIsNeedSkinColor = true;
    super.setQQAVEffectType(5);
    setAmount(paramFloat);
  }
  
  public float getAmount()
  {
    return this.mAmount;
  }
  
  public float getExposure()
  {
    return this.mExposure;
  }
  
  public float getMixPercent()
  {
    return this.mMixPercent;
  }
  
  public float getSharpness()
  {
    return this.mSharpness;
  }
  
  public boolean isUseMultiParams()
  {
    return this.mIsUseMultiParams;
  }
  
  public void onDestroy()
  {
    Object localObject = this.mFrameBuffers;
    if (localObject != null)
    {
      GLES20.glDeleteFramebuffers(localObject.length, (int[])localObject, 0);
      localObject = this.mFrameBufferTextures;
      GLES20.glDeleteTextures(localObject.length, (int[])localObject, 0);
    }
    this.mExposureAndOverlayFilter.destroy();
    this.mHighPassFilter.destroy();
    this.mSkinCurveAndComposeFilter.destroy();
    this.mSharpenAndExposureFilter.destroy();
    localObject = this.mSkinColorFilter;
    if (localObject != null) {
      ((QQAVImageFilter)localObject).destroy();
    }
    super.onDestroy();
  }
  
  public void onDraw2(int paramInt1, int paramInt2)
  {
    runPendingOnDrawTasks();
    if ((isInitialized()) && (this.mFrameBuffers != null))
    {
      if (this.mFrameBufferTextures == null) {
        return;
      }
      if (this.mIsUseMultiParams)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("BeautyFilter onDraw current mixPercent:");
        ((StringBuilder)localObject).append(this.mMixPercent);
        ((StringBuilder)localObject).append(",sharpness:");
        ((StringBuilder)localObject).append(this.mSharpness);
        ((StringBuilder)localObject).append(",exposure:");
        ((StringBuilder)localObject).append(this.mExposure);
        ((StringBuilder)localObject).append(",mIsNeedSkinColor:");
        ((StringBuilder)localObject).append(this.mIsNeedSkinColor);
        Log.d("QQAVImageBeautyFilter", ((StringBuilder)localObject).toString());
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("BeautyFilter onDraw current amount:");
        ((StringBuilder)localObject).append(this.mAmount);
        ((StringBuilder)localObject).append(",mIsNeedSkinColor:");
        ((StringBuilder)localObject).append(this.mIsNeedSkinColor);
        Log.d("QQAVImageBeautyFilter", ((StringBuilder)localObject).toString());
      }
      this.mExposureAndOverlayFilter.onDraw2(paramInt1, this.mFrameBuffers[0]);
      this.mHighPassFilter.onDraw2(this.mFrameBufferTextures[0], this.mFrameBuffers[1]);
      Object localObject = this.mSkinCurveAndComposeFilter;
      ((QQAVImageBeautySkinCurveAndComposeFilter)localObject).mFilterSourceTexture2 = this.mFrameBufferTextures[1];
      ((QQAVImageBeautySkinCurveAndComposeFilter)localObject).onDraw2(paramInt1, this.mFrameBuffers[2]);
      if ((this.mIsNeedSkinColor) && (this.mSkinColorFilter != null))
      {
        this.mSharpenAndExposureFilter.onDraw2(this.mFrameBufferTextures[2], this.mFrameBuffers[3]);
        this.mSkinColorFilter.onDraw2(this.mFrameBufferTextures[3], paramInt2);
        return;
      }
      this.mSharpenAndExposureFilter.onDraw2(this.mFrameBufferTextures[2], paramInt2);
    }
  }
  
  public void onInit()
  {
    super.onInit();
    this.mExposureAndOverlayFilter.onInit();
    this.mExposureAndOverlayFilter.setExposure(-1.0F);
    this.mHighPassFilter.onInit();
    this.mSkinCurveAndComposeFilter.onInit();
    this.mSharpenAndExposureFilter.onInit();
    QQAVImageFilter localQQAVImageFilter = this.mSkinColorFilter;
    if (localQQAVImageFilter != null) {
      localQQAVImageFilter.onInit();
    }
  }
  
  public void onInitialized()
  {
    super.onInitialized();
    this.mExposureAndOverlayFilter.onInitialized();
    this.mHighPassFilter.onInitialized();
    this.mSkinCurveAndComposeFilter.onInitialized();
    this.mSharpenAndExposureFilter.onInitialized();
    QQAVImageFilter localQQAVImageFilter = this.mSkinColorFilter;
    if (localQQAVImageFilter != null) {
      localQQAVImageFilter.onInitialized();
    }
  }
  
  public void onOutputSizeChanged(int paramInt1, int paramInt2)
  {
    int i;
    if ((this.mOutputWidth == paramInt1) && (this.mOutputHeight == paramInt2)) {
      i = 0;
    } else {
      i = 1;
    }
    super.onOutputSizeChanged(paramInt1, paramInt2);
    if (i != 0)
    {
      Object localObject = this.mFrameBuffers;
      if (localObject != null)
      {
        GLES20.glDeleteFramebuffers(localObject.length, (int[])localObject, 0);
        localObject = this.mFrameBufferTextures;
        GLES20.glDeleteTextures(localObject.length, (int[])localObject, 0);
      }
      this.mExposureAndOverlayFilter.onOutputSizeChanged(paramInt1, paramInt2);
      this.mHighPassFilter.onOutputSizeChanged(paramInt1, paramInt2);
      this.mSkinCurveAndComposeFilter.onOutputSizeChanged(paramInt1, paramInt2);
      this.mSharpenAndExposureFilter.onOutputSizeChanged(paramInt1, paramInt2);
      localObject = this.mSkinColorFilter;
      if (localObject != null) {
        ((QQAVImageFilter)localObject).onOutputSizeChanged(paramInt1, paramInt2);
      }
      float f = 2.0F;
      if (paramInt1 > 720) {
        f = 5.0F;
      } else if ((paramInt1 >= 540) && (paramInt1 <= 720)) {
        f = 3.0F;
      } else if (((paramInt1 < 480) || (paramInt1 >= 540)) && (paramInt1 < 480)) {
        f = 1.0F;
      }
      this.mHighPassFilter.setRadiusInPixels(f);
      int j = this.mFrameBufferTextures.length;
      i = 0;
      while (i < j)
      {
        GLES20.glGenFramebuffers(1, this.mFrameBuffers, i);
        GLES20.glGenTextures(1, this.mFrameBufferTextures, i);
        GLES20.glBindTexture(3553, this.mFrameBufferTextures[i]);
        GLES20.glTexImage2D(3553, 0, 6408, paramInt1, paramInt2, 0, 6408, 5121, null);
        GLES20.glTexParameterf(3553, 10240, 9729.0F);
        GLES20.glTexParameterf(3553, 10241, 9729.0F);
        GLES20.glTexParameterf(3553, 10242, 33071.0F);
        GLES20.glTexParameterf(3553, 10243, 33071.0F);
        GLES20.glBindFramebuffer(36160, this.mFrameBuffers[i]);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.mFrameBufferTextures[i], 0);
        GLES20.glBindTexture(3553, 0);
        GLES20.glBindFramebuffer(36160, 0);
        i += 1;
      }
    }
  }
  
  public void setAmount(float paramFloat)
  {
    double d = paramFloat;
    if (d < 0.0D) {
      this.mAmount = 0.0F;
    } else if (d > 1.0D) {
      this.mAmount = 1.0F;
    } else {
      this.mAmount = paramFloat;
    }
    paramFloat = this.mAmount * 1.25F;
    Object localObject = this.mSkinCurveAndComposeFilter;
    if (localObject != null) {
      ((QQAVImageBeautySkinCurveAndComposeFilter)localObject).setMixPercent(paramFloat * 10.0F * 0.14F);
    }
    localObject = this.mSharpenAndExposureFilter;
    if (localObject != null)
    {
      ((QQAVImageBeautySharpenAndExposureFilter)localObject).setSharpness(paramFloat * 10.0F * 0.03F);
      this.mSharpenAndExposureFilter.setExposure(0.0F);
    }
    this.mIsUseMultiParams = false;
  }
  
  public void setBeauty(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    double d = paramFloat1;
    if (d < 0.0D) {
      this.mMixPercent = 0.0F;
    } else if (d > 1.75D) {
      this.mMixPercent = 1.75F;
    } else {
      this.mMixPercent = paramFloat1;
    }
    d = paramFloat2;
    if (d < -1.0D) {
      this.mSharpness = -1.0F;
    } else if (d > 1.5D) {
      this.mSharpness = 1.5F;
    } else {
      this.mSharpness = paramFloat2;
    }
    d = paramFloat3;
    if (d < -1.0D) {
      this.mExposure = -1.0F;
    } else if (d > 1.0D) {
      this.mExposure = 1.0F;
    } else {
      this.mExposure = paramFloat3;
    }
    Object localObject = this.mSkinCurveAndComposeFilter;
    if (localObject != null) {
      ((QQAVImageBeautySkinCurveAndComposeFilter)localObject).setMixPercent(this.mMixPercent);
    }
    localObject = this.mSharpenAndExposureFilter;
    if (localObject != null)
    {
      ((QQAVImageBeautySharpenAndExposureFilter)localObject).setSharpness(this.mSharpness);
      this.mSharpenAndExposureFilter.setExposure(this.mExposure);
    }
    this.mIsUseMultiParams = true;
  }
  
  public void setNeedSkinColor(boolean paramBoolean)
  {
    this.mIsNeedSkinColor = paramBoolean;
  }
  
  public void setSkinColorFilter(QQAVImageFilter paramQQAVImageFilter)
  {
    this.mSkinColorFilter = paramQQAVImageFilter;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.video.effect.core.qqavimage.beauty.QQAVImageBeautyFilter
 * JD-Core Version:    0.7.0.1
 */