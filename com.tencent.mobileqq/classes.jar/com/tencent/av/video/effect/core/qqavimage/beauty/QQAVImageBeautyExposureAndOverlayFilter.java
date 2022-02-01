package com.tencent.av.video.effect.core.qqavimage.beauty;

import android.opengl.GLES20;
import com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter;

public class QQAVImageBeautyExposureAndOverlayFilter
  extends QQAVImageFilter
{
  private float mExposure;
  private int mExposureLocation;
  
  public QQAVImageBeautyExposureAndOverlayFilter()
  {
    this(0.5F);
  }
  
  public QQAVImageBeautyExposureAndOverlayFilter(float paramFloat)
  {
    super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", String.valueOf(1));
    this.mExposure = paramFloat;
  }
  
  public void onInit()
  {
    super.onInit();
    this.mExposureLocation = GLES20.glGetUniformLocation(getProgram(), "exposure");
    setExposure(this.mExposure);
  }
  
  public void setExposure(float paramFloat)
  {
    this.mExposure = paramFloat;
    setFloat(this.mExposureLocation, paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.video.effect.core.qqavimage.beauty.QQAVImageBeautyExposureAndOverlayFilter
 * JD-Core Version:    0.7.0.1
 */