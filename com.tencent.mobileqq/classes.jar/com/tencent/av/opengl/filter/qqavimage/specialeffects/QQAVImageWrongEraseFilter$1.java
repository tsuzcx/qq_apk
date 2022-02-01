package com.tencent.av.opengl.filter.qqavimage.specialeffects;

import android.opengl.GLES20;
import java.nio.FloatBuffer;

class QQAVImageWrongEraseFilter$1
  implements Runnable
{
  QQAVImageWrongEraseFilter$1(QQAVImageWrongEraseFilter paramQQAVImageWrongEraseFilter, int paramInt1, int paramInt2, float[] paramArrayOfFloat) {}
  
  public void run()
  {
    GLES20.glUniform4fv(this.val$location, this.val$arrayCount, FloatBuffer.wrap(this.val$arrayValue));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.opengl.filter.qqavimage.specialeffects.QQAVImageWrongEraseFilter.1
 * JD-Core Version:    0.7.0.1
 */