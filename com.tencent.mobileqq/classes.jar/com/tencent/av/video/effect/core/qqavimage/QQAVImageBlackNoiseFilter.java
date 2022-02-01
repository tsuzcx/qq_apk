package com.tencent.av.video.effect.core.qqavimage;

import android.content.Context;
import android.opengl.GLES20;

public class QQAVImageBlackNoiseFilter
  extends QQAVImageColorFilter
{
  private float fRandomIndex = 0.0F;
  private int mRandomIndex;
  
  public QQAVImageBlackNoiseFilter()
  {
    super(String.valueOf(36), 1);
    super.setQQAVEffectType(13);
  }
  
  public QQAVImageBlackNoiseFilter(int paramInt)
  {
    super(String.valueOf(36), paramInt);
    super.setQQAVEffectType(13);
  }
  
  public QQAVImageBlackNoiseFilter(Context paramContext)
  {
    super(String.valueOf(36), 1);
    super.setQQAVEffectType(13);
  }
  
  public QQAVImageBlackNoiseFilter(Context paramContext, int paramInt)
  {
    super(String.valueOf(36), paramInt);
    super.setQQAVEffectType(13);
  }
  
  public void onDraw2(int paramInt1, int paramInt2)
  {
    super.onDraw2(paramInt1, paramInt2);
    this.fRandomIndex += 1.0F;
    if (this.fRandomIndex > 10000.0F) {
      this.fRandomIndex = 0.0F;
    }
    setFloat(this.mRandomIndex, this.fRandomIndex);
  }
  
  public void onInit()
  {
    super.onInit();
    this.mRandomIndex = GLES20.glGetUniformLocation(getProgram(), "u_time");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.video.effect.core.qqavimage.QQAVImageBlackNoiseFilter
 * JD-Core Version:    0.7.0.1
 */