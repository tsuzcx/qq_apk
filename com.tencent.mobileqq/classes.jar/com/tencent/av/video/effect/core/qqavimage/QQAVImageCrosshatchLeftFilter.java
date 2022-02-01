package com.tencent.av.video.effect.core.qqavimage;

import android.opengl.GLES20;

public class QQAVImageCrosshatchLeftFilter
  extends QQAVImageFilter
{
  private float mCrossHatchSpacing;
  private int mCrossHatchSpacingLocation;
  private float mLineWidth;
  private int mLineWidthLocation;
  
  public QQAVImageCrosshatchLeftFilter()
  {
    this(0.018F, 0.0025F);
  }
  
  public QQAVImageCrosshatchLeftFilter(float paramFloat1, float paramFloat2)
  {
    super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", String.valueOf(11));
    this.mCrossHatchSpacing = paramFloat1;
    this.mLineWidth = paramFloat2;
  }
  
  public void onInit()
  {
    super.onInit();
    this.mCrossHatchSpacingLocation = GLES20.glGetUniformLocation(getProgram(), "crossHatchSpacing");
    this.mLineWidthLocation = GLES20.glGetUniformLocation(getProgram(), "lineWidth");
  }
  
  public void onInitialized()
  {
    super.onInitialized();
    setCrossHatchSpacing(this.mCrossHatchSpacing);
    setLineWidth(this.mLineWidth);
  }
  
  public void setCrossHatchSpacing(float paramFloat)
  {
    float f;
    if (getOutputWidth() != 0)
    {
      f = 1.0F / getOutputWidth();
      if (paramFloat >= f) {
        break label45;
      }
    }
    label45:
    for (this.mCrossHatchSpacing = f;; this.mCrossHatchSpacing = paramFloat)
    {
      setFloat(this.mCrossHatchSpacingLocation, this.mCrossHatchSpacing);
      return;
      f = 0.0004882813F;
      break;
    }
  }
  
  public void setLineWidth(float paramFloat)
  {
    this.mLineWidth = paramFloat;
    setFloat(this.mLineWidthLocation, this.mLineWidth);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.video.effect.core.qqavimage.QQAVImageCrosshatchLeftFilter
 * JD-Core Version:    0.7.0.1
 */