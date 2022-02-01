package com.tencent.av.video.effect.core.qqavimage;

import android.opengl.GLES20;

public class QQAVImage3x3TextureSamplingFilter
  extends QQAVImageFilter
{
  private boolean mHasOverriddenImageSizeFactor = false;
  private float mLineSize = 1.0F;
  private float mTexelHeight;
  private float mTexelWidth;
  private int mUniformTexelHeightLocation;
  private int mUniformTexelWidthLocation;
  
  public QQAVImage3x3TextureSamplingFilter()
  {
    this("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}");
  }
  
  public QQAVImage3x3TextureSamplingFilter(String paramString)
  {
    super(String.valueOf(14), paramString);
  }
  
  private void updateTexelValues()
  {
    setFloat(this.mUniformTexelWidthLocation, this.mTexelWidth);
    setFloat(this.mUniformTexelHeightLocation, this.mTexelHeight);
  }
  
  public void onInit()
  {
    super.onInit();
    this.mUniformTexelWidthLocation = GLES20.glGetUniformLocation(getProgram(), "texelWidth");
    this.mUniformTexelHeightLocation = GLES20.glGetUniformLocation(getProgram(), "texelHeight");
    if (this.mTexelWidth != 0.0F) {
      updateTexelValues();
    }
  }
  
  public void onOutputSizeChanged(int paramInt1, int paramInt2)
  {
    super.onOutputSizeChanged(paramInt1, paramInt2);
    if (!this.mHasOverriddenImageSizeFactor) {
      setLineSize(this.mLineSize);
    }
  }
  
  public void setLineSize(float paramFloat)
  {
    this.mLineSize = paramFloat;
    this.mTexelWidth = (paramFloat / getOutputWidth());
    this.mTexelHeight = (paramFloat / getOutputHeight());
    updateTexelValues();
  }
  
  public void setTexelHeight(float paramFloat)
  {
    this.mHasOverriddenImageSizeFactor = true;
    this.mTexelHeight = paramFloat;
    setFloat(this.mUniformTexelHeightLocation, paramFloat);
  }
  
  public void setTexelWidth(float paramFloat)
  {
    this.mHasOverriddenImageSizeFactor = true;
    this.mTexelWidth = paramFloat;
    setFloat(this.mUniformTexelWidthLocation, paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.video.effect.core.qqavimage.QQAVImage3x3TextureSamplingFilter
 * JD-Core Version:    0.7.0.1
 */