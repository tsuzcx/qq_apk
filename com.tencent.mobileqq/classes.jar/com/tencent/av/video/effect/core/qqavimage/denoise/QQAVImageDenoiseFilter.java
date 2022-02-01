package com.tencent.av.video.effect.core.qqavimage.denoise;

import android.opengl.GLES20;
import com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter;
import com.tencent.av.video.effect.utils.CommonUtils;
import com.tencent.av.video.effect.utils.Log;

public class QQAVImageDenoiseFilter
  extends QQAVImageFilter
{
  public static final String INIT_FRAGMENT_SHADER = " varying highp vec2 textureCoordinate;\n void main()\n {\n      gl_FragColor = vec4(0.0, 0.0, 0.0, 1.0);\n }";
  private static final String TAG = "QQAVImageDenoiseFilter";
  private QQAVImageFilter mEmptyFilter = new QQAVImageFilter();
  private boolean mFirstFrameFlag = true;
  private int[] mFrameBufferTextures = new int[3];
  private int[] mFrameBuffers = new int[3];
  private QQAVImageDenoiseGaussianBlurFilter mGaussianBlurFilter = new QQAVImageDenoiseGaussianBlurFilter(1.0F);
  private QQAVImageFilter mInitFilter = new QQAVImageFilter(" varying highp vec2 textureCoordinate;\n void main()\n {\n      gl_FragColor = vec4(0.0, 0.0, 0.0, 1.0);\n }");
  private int mLastStoreBlurFbo = -1;
  private int mLastStoreBlurTexture = -1;
  private int mLastStoreFbo = -1;
  private int mLastStoreTexture = -1;
  private QQAVImageDenoiseRGB2YUVFilter mRGB2YUVFilter = new QQAVImageDenoiseRGB2YUVFilter();
  private float mUpdateRate = 0.0F;
  private QQAVImageDenoiseVDCalAndPredFilter mVDCalAndPredFilter = new QQAVImageDenoiseVDCalAndPredFilter();
  private QQAVImageDenoiseYUV2RGBFilter mYUV2RGBFilter = new QQAVImageDenoiseYUV2RGBFilter();
  
  public void onDestroy()
  {
    if (this.mFrameBuffers != null)
    {
      GLES20.glDeleteFramebuffers(this.mFrameBuffers.length, this.mFrameBuffers, 0);
      GLES20.glDeleteTextures(this.mFrameBufferTextures.length, this.mFrameBufferTextures, 0);
    }
    if (this.mLastStoreTexture != -1)
    {
      GLES20.glDeleteTextures(2, new int[] { this.mLastStoreTexture, this.mLastStoreBlurTexture }, 0);
      GLES20.glDeleteFramebuffers(2, new int[] { this.mLastStoreFbo, this.mLastStoreBlurFbo }, 0);
      this.mLastStoreTexture = -1;
      this.mLastStoreFbo = -1;
      this.mLastStoreBlurTexture = -1;
      this.mLastStoreBlurFbo = -1;
    }
    this.mRGB2YUVFilter.destroy();
    this.mGaussianBlurFilter.destroy();
    this.mVDCalAndPredFilter.destroy();
    this.mYUV2RGBFilter.destroy();
    this.mInitFilter.destroy();
    this.mEmptyFilter.destroy();
    super.onDestroy();
  }
  
  public void onDraw2(int paramInt1, int paramInt2)
  {
    runPendingOnDrawTasks();
    if ((!isInitialized()) || (this.mFrameBuffers == null) || (this.mFrameBufferTextures == null)) {
      return;
    }
    if (this.mFirstFrameFlag)
    {
      this.mFirstFrameFlag = false;
      this.mInitFilter.onDraw2(this.mFrameBufferTextures[0], this.mLastStoreFbo);
      this.mInitFilter.onDraw2(this.mFrameBufferTextures[0], this.mLastStoreBlurFbo);
      Log.d("QQAVImageDenoiseFilter", "init last store");
    }
    this.mRGB2YUVFilter.onDraw2(paramInt1, this.mFrameBuffers[0]);
    this.mGaussianBlurFilter.onDraw2(this.mFrameBufferTextures[0], this.mFrameBuffers[1]);
    this.mVDCalAndPredFilter.mFilterSourceTexture2 = this.mFrameBufferTextures[1];
    this.mVDCalAndPredFilter.mFilterSourceTexture3 = this.mFrameBufferTextures[0];
    this.mVDCalAndPredFilter.mFilterSourceTexture4 = this.mLastStoreBlurTexture;
    this.mVDCalAndPredFilter.onDraw2(this.mLastStoreTexture, this.mFrameBuffers[2]);
    this.mEmptyFilter.onDraw2(this.mFrameBufferTextures[2], this.mLastStoreFbo);
    this.mEmptyFilter.onDraw2(this.mFrameBufferTextures[1], this.mLastStoreBlurFbo);
    this.mYUV2RGBFilter.mFilterSourceTexture2 = this.mFrameBufferTextures[0];
    this.mYUV2RGBFilter.onDraw2(this.mFrameBufferTextures[2], paramInt2);
  }
  
  public void onInit()
  {
    super.onInit();
    this.mRGB2YUVFilter.onInit();
    this.mGaussianBlurFilter.onInit();
    this.mVDCalAndPredFilter.onInit();
    this.mYUV2RGBFilter.onInit();
    this.mInitFilter.onInit();
    this.mEmptyFilter.onInit();
  }
  
  public void onInitialized()
  {
    super.onInitialized();
    this.mRGB2YUVFilter.onInitialized();
    this.mGaussianBlurFilter.onInitialized();
    this.mVDCalAndPredFilter.onInitialized();
    this.mYUV2RGBFilter.onInitialized();
    this.mInitFilter.onInitialized();
    this.mEmptyFilter.onInitialized();
  }
  
  public void onOutputSizeChanged(int paramInt1, int paramInt2)
  {
    if ((this.mOutputWidth != paramInt1) || (this.mOutputHeight != paramInt2)) {}
    for (int i = 1;; i = 0)
    {
      super.onOutputSizeChanged(paramInt1, paramInt2);
      if (i == 0) {
        return;
      }
      if (this.mFrameBuffers != null)
      {
        GLES20.glDeleteFramebuffers(this.mFrameBuffers.length, this.mFrameBuffers, 0);
        GLES20.glDeleteTextures(this.mFrameBufferTextures.length, this.mFrameBufferTextures, 0);
      }
      this.mRGB2YUVFilter.onOutputSizeChanged(paramInt1, paramInt2);
      this.mGaussianBlurFilter.onOutputSizeChanged(paramInt1, paramInt2);
      this.mVDCalAndPredFilter.onOutputSizeChanged(paramInt1, paramInt2);
      this.mYUV2RGBFilter.onOutputSizeChanged(paramInt1, paramInt2);
      this.mInitFilter.onOutputSizeChanged(paramInt1, paramInt2);
      this.mEmptyFilter.onOutputSizeChanged(paramInt1, paramInt2);
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
    if (this.mLastStoreTexture != -1)
    {
      GLES20.glDeleteTextures(2, new int[] { this.mLastStoreTexture, this.mLastStoreBlurTexture }, 0);
      GLES20.glDeleteFramebuffers(2, new int[] { this.mLastStoreFbo, this.mLastStoreBlurFbo }, 0);
      this.mLastStoreTexture = -1;
      this.mLastStoreFbo = -1;
      this.mLastStoreBlurTexture = -1;
      this.mLastStoreBlurFbo = -1;
    }
    int[] arrayOfInt = new int[2];
    GLES20.glGenTextures(2, arrayOfInt, 0);
    this.mLastStoreTexture = arrayOfInt[0];
    this.mLastStoreFbo = CommonUtils.initFrameBuffer(paramInt1, paramInt2, this.mLastStoreTexture);
    this.mLastStoreBlurTexture = arrayOfInt[1];
    this.mLastStoreBlurFbo = CommonUtils.initFrameBuffer(paramInt1, paramInt2, this.mLastStoreBlurTexture);
    this.mFirstFrameFlag = true;
  }
  
  public void setUpdateRate(float paramFloat)
  {
    float f;
    if (paramFloat > 40.0F) {
      f = 40.0F;
    }
    for (;;)
    {
      this.mUpdateRate = f;
      this.mVDCalAndPredFilter.setUpdateRateLocal(f);
      return;
      f = paramFloat;
      if (paramFloat < 0.0F) {
        f = 0.0F;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.video.effect.core.qqavimage.denoise.QQAVImageDenoiseFilter
 * JD-Core Version:    0.7.0.1
 */