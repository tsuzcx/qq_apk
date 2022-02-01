package com.tencent.liteav.basic.c;

import android.opengl.GLES20;
import java.nio.FloatBuffer;

class h$5
  implements Runnable
{
  h$5(h paramh, int paramInt, float[] paramArrayOfFloat) {}
  
  public void run()
  {
    GLES20.glUniform4fv(this.a, 1, FloatBuffer.wrap(this.b));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.basic.c.h.5
 * JD-Core Version:    0.7.0.1
 */