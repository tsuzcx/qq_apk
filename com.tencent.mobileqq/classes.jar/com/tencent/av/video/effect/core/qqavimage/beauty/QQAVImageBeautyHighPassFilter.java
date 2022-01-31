package com.tencent.av.video.effect.core.qqavimage.beauty;

import android.opengl.GLES20;
import com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter;
import com.tencent.av.video.effect.core.qqavimage.QQAVImageTwoInputFilter;

public class QQAVImageBeautyHighPassFilter
  extends QQAVImageFilter
{
  private int[] mFrameBufferTextures = new int[1];
  private int[] mFrameBuffers = new int[1];
  private QQAVImageBeautyGaussianBlurFilter mGaussianBlurFilter = new QQAVImageBeautyGaussianBlurFilter();
  private QQAVImageTwoInputFilter mTwoInputFilter = new QQAVImageTwoInputFilter(String.valueOf(2));
  
  public void onDestroy()
  {
    if (this.mFrameBuffers != null)
    {
      GLES20.glDeleteFramebuffers(this.mFrameBuffers.length, this.mFrameBuffers, 0);
      GLES20.glDeleteTextures(this.mFrameBufferTextures.length, this.mFrameBufferTextures, 0);
    }
    this.mGaussianBlurFilter.destroy();
    this.mTwoInputFilter.destroy();
    super.onDestroy();
  }
  
  public void onDraw2(int paramInt1, int paramInt2)
  {
    runPendingOnDrawTasks();
    if ((!isInitialized()) || (this.mFrameBuffers == null) || (this.mFrameBufferTextures == null)) {
      return;
    }
    this.mGaussianBlurFilter.onDraw2(paramInt1, this.mFrameBuffers[0]);
    this.mTwoInputFilter.mFilterSourceTexture2 = this.mFrameBufferTextures[0];
    this.mTwoInputFilter.onDraw2(paramInt1, paramInt2);
  }
  
  public void onInit()
  {
    super.onInit();
    this.mGaussianBlurFilter.onInit();
    this.mTwoInputFilter.onInit();
  }
  
  public void onInitialized()
  {
    super.onInitialized();
    this.mGaussianBlurFilter.onInitialized();
    this.mTwoInputFilter.onInitialized();
  }
  
  public void onOutputSizeChanged(int paramInt1, int paramInt2)
  {
    if ((this.mOutputWidth != paramInt1) || (this.mOutputHeight != paramInt2)) {}
    for (int i = 1;; i = 0)
    {
      super.onOutputSizeChanged(paramInt1, paramInt2);
      if (i == 0) {
        break;
      }
      if (this.mFrameBuffers != null)
      {
        GLES20.glDeleteFramebuffers(this.mFrameBuffers.length, this.mFrameBuffers, 0);
        GLES20.glDeleteTextures(this.mFrameBufferTextures.length, this.mFrameBufferTextures, 0);
      }
      this.mGaussianBlurFilter.onOutputSizeChanged(paramInt1, paramInt2);
      this.mTwoInputFilter.onOutputSizeChanged(paramInt1, paramInt2);
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
  
  public void setRadiusInPixels(float paramFloat)
  {
    this.mGaussianBlurFilter.setRadiusInPixels(paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.video.effect.core.qqavimage.beauty.QQAVImageBeautyHighPassFilter
 * JD-Core Version:    0.7.0.1
 */