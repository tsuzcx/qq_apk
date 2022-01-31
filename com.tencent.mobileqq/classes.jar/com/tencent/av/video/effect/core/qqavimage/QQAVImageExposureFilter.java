package com.tencent.av.video.effect.core.qqavimage;

import android.opengl.GLES20;

public class QQAVImageExposureFilter
  extends QQAVImageFilter
{
  private float mExposure;
  private int mExposureLocation;
  
  public QQAVImageExposureFilter()
  {
    this(1.0F);
  }
  
  public QQAVImageExposureFilter(float paramFloat)
  {
    super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", String.valueOf(17));
    this.mExposure = paramFloat;
  }
  
  public void onInit()
  {
    super.onInit();
    this.mExposureLocation = GLES20.glGetUniformLocation(getProgram(), "exposure");
  }
  
  public void onInitialized()
  {
    super.onInitialized();
    setExposure(this.mExposure);
  }
  
  public void setExposure(float paramFloat)
  {
    this.mExposure = paramFloat;
    setFloat(this.mExposureLocation, this.mExposure);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.video.effect.core.qqavimage.QQAVImageExposureFilter
 * JD-Core Version:    0.7.0.1
 */