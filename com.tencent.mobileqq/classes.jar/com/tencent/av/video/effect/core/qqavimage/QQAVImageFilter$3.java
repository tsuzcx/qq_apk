package com.tencent.av.video.effect.core.qqavimage;

import android.graphics.PointF;
import android.opengl.GLES20;

class QQAVImageFilter$3
  implements Runnable
{
  QQAVImageFilter$3(QQAVImageFilter paramQQAVImageFilter, PointF paramPointF, int paramInt) {}
  
  public void run()
  {
    float f1 = this.val$point.x;
    float f2 = this.val$point.y;
    GLES20.glUniform2fv(this.val$location, 1, new float[] { f1, f2 }, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter.3
 * JD-Core Version:    0.7.0.1
 */