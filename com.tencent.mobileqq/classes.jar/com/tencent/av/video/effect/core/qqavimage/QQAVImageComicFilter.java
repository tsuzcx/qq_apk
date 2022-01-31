package com.tencent.av.video.effect.core.qqavimage;

import android.opengl.GLES20;

public class QQAVImageComicFilter
  extends QQAVImageFilter
{
  private QQAVImageCrosshatchLeftFilter mCrossFilter = new QQAVImageCrosshatchLeftFilter();
  private float mCrosshatchSspacing = 0.018F;
  private QQAVImageThresholdSketchFilter mEdgeFilter = new QQAVImageThresholdSketchFilter();
  private float mEdgeStrenght = 1.0F;
  private int[] mFrameBufferTextures = new int[2];
  private int[] mFrameBuffers = new int[2];
  private float mLineWidth = 0.0025F;
  private float mThreshold = 0.5F;
  private QQAVImageComicBlendFilter mTwoFilter = new QQAVImageComicBlendFilter();
  
  public QQAVImageComicFilter()
  {
    super.setQQAVEffectType(3);
  }
  
  public QQAVImageComicFilter(float paramFloat)
  {
    super.setQQAVEffectType(3);
  }
  
  public void onDestroy()
  {
    if (this.mFrameBuffers != null)
    {
      GLES20.glDeleteFramebuffers(this.mFrameBuffers.length, this.mFrameBuffers, 0);
      GLES20.glDeleteTextures(this.mFrameBufferTextures.length, this.mFrameBufferTextures, 0);
    }
    this.mEdgeFilter.onDestroy();
    this.mCrossFilter.onDestroy();
    this.mTwoFilter.onDestroy();
    super.onDestroy();
  }
  
  public void onDraw2(int paramInt1, int paramInt2)
  {
    runPendingOnDrawTasks();
    if ((!isInitialized()) || (this.mFrameBuffers == null) || (this.mFrameBufferTextures == null)) {
      return;
    }
    this.mEdgeFilter.onDraw2(paramInt1, this.mFrameBuffers[0]);
    this.mCrossFilter.onDraw2(paramInt1, this.mFrameBuffers[1]);
    this.mTwoFilter.mFilterSourceTexture2 = this.mFrameBufferTextures[1];
    this.mTwoFilter.onDraw2(this.mFrameBufferTextures[0], paramInt2);
  }
  
  public void onInit()
  {
    super.onInit();
    this.mEdgeFilter.onInit();
    this.mCrossFilter.onInit();
    this.mTwoFilter.onInit();
  }
  
  public void onInitialized()
  {
    super.onInitialized();
    this.mEdgeFilter.onInitialized();
    this.mCrossFilter.onInitialized();
    this.mTwoFilter.onInitialized();
    this.mCrossFilter.setCrossHatchSpacing(this.mCrosshatchSspacing);
    this.mCrossFilter.setLineWidth(this.mLineWidth);
  }
  
  public void onOutputSizeChanged(int paramInt1, int paramInt2)
  {
    super.onOutputSizeChanged(paramInt1, paramInt2);
    if (this.mFrameBuffers != null)
    {
      GLES20.glDeleteFramebuffers(this.mFrameBuffers.length, this.mFrameBuffers, 0);
      GLES20.glDeleteTextures(this.mFrameBufferTextures.length, this.mFrameBufferTextures, 0);
    }
    this.mEdgeFilter.onOutputSizeChanged(paramInt1, paramInt2);
    this.mCrossFilter.onOutputSizeChanged(paramInt1, paramInt2);
    this.mTwoFilter.onOutputSizeChanged(paramInt1, paramInt2);
    int i = 0;
    while (i < 2)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.video.effect.core.qqavimage.QQAVImageComicFilter
 * JD-Core Version:    0.7.0.1
 */