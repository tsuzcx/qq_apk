package com.tencent.liteav.basic.c;

import android.opengl.GLES20;
import java.nio.FloatBuffer;

class h$4
  implements Runnable
{
  h$4(h paramh, int paramInt, float[] paramArrayOfFloat) {}
  
  public void run()
  {
    GLES20.glUniform3fv(this.a, 1, FloatBuffer.wrap(this.b));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.basic.c.h.4
 * JD-Core Version:    0.7.0.1
 */