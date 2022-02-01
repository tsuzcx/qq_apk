package com.tencent.av.video.effect.core.qqavimage;

import android.opengl.GLES20;

class QQAVImageFilter$2
  implements Runnable
{
  QQAVImageFilter$2(QQAVImageFilter paramQQAVImageFilter, int paramInt, float paramFloat) {}
  
  public void run()
  {
    GLES20.glUniform1f(this.val$location, this.val$floatValue);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter.2
 * JD-Core Version:    0.7.0.1
 */