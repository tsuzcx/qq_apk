package com.tencent.av.video.effect.core.qqavimage.lowlight;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter;
import com.tencent.av.video.effect.core.qqavimage.util.OpenGlUtils;

public class QQAVImageLowLightCoreFilter
  extends QQAVImageFilter
{
  protected int mGLUniformLowLightImageTexture;
  protected int mGLUniformTexelHeight;
  protected int mGLUniformTexelWidth;
  public int mLowLightImageTexture = -1;
  
  public QQAVImageLowLightCoreFilter()
  {
    super(String.valueOf(6), String.valueOf(7));
  }
  
  private void initTexelOffsets()
  {
    if (this.mOutputWidth != 0) {
      setFloat(this.mGLUniformTexelWidth, 1.0F / this.mOutputWidth);
    }
    if (this.mOutputHeight != 0) {
      setFloat(this.mGLUniformTexelHeight, 1.0F / this.mOutputHeight);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  protected void onDrawArraysAfter()
  {
    GLES20.glActiveTexture(33985);
    GLES20.glBindTexture(3553, 0);
    GLES20.glActiveTexture(33984);
  }
  
  protected void onDrawArraysPre()
  {
    GLES20.glActiveTexture(33985);
    GLES20.glBindTexture(3553, this.mLowLightImageTexture);
    GLES20.glUniform1i(this.mGLUniformLowLightImageTexture, 1);
  }
  
  public void onInit()
  {
    super.onInit();
    this.mGLUniformTexelWidth = GLES20.glGetUniformLocation(this.mGLProgId, "texelWidth");
    this.mGLUniformTexelHeight = GLES20.glGetUniformLocation(this.mGLProgId, "texelHeight");
    this.mGLUniformLowLightImageTexture = GLES20.glGetUniformLocation(this.mGLProgId, "inputImageTexture2");
    initTexelOffsets();
  }
  
  public void onOutputSizeChanged(int paramInt1, int paramInt2)
  {
    super.onOutputSizeChanged(paramInt1, paramInt2);
    initTexelOffsets();
  }
  
  public void setLowLightImage(Bitmap paramBitmap)
  {
    GLES20.glActiveTexture(33985);
    this.mLowLightImageTexture = OpenGlUtils.loadTexture(paramBitmap, this.mLowLightImageTexture, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.video.effect.core.qqavimage.lowlight.QQAVImageLowLightCoreFilter
 * JD-Core Version:    0.7.0.1
 */