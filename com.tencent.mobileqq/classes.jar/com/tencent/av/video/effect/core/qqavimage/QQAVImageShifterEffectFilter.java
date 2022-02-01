package com.tencent.av.video.effect.core.qqavimage;

import android.content.Context;
import android.opengl.GLES20;

public class QQAVImageShifterEffectFilter
  extends QQAVImageColorFilter
{
  private int mHeightLocation;
  private int mWidthLocation;
  
  public QQAVImageShifterEffectFilter()
  {
    super(String.valueOf(35), 1);
    super.setQQAVEffectType(12);
  }
  
  public QQAVImageShifterEffectFilter(int paramInt)
  {
    super(String.valueOf(35), paramInt);
    super.setQQAVEffectType(12);
  }
  
  public QQAVImageShifterEffectFilter(Context paramContext)
  {
    super(String.valueOf(35), 1);
    super.setQQAVEffectType(12);
  }
  
  public QQAVImageShifterEffectFilter(Context paramContext, int paramInt)
  {
    super(String.valueOf(35), paramInt);
    super.setQQAVEffectType(12);
  }
  
  public void onInit()
  {
    super.onInit();
    this.mWidthLocation = GLES20.glGetUniformLocation(getProgram(), "imageWidth");
    this.mHeightLocation = GLES20.glGetUniformLocation(getProgram(), "imageHeight");
  }
  
  public void onOutputSizeChanged(int paramInt1, int paramInt2)
  {
    super.onOutputSizeChanged(paramInt1, paramInt2);
    setFloat(this.mWidthLocation, paramInt1);
    setFloat(this.mHeightLocation, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.video.effect.core.qqavimage.QQAVImageShifterEffectFilter
 * JD-Core Version:    0.7.0.1
 */