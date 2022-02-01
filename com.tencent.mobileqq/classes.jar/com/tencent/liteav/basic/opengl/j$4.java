package com.tencent.liteav.basic.opengl;

import android.opengl.GLES20;
import java.nio.FloatBuffer;

class j$4
  implements Runnable
{
  j$4(j paramj, int paramInt, float[] paramArrayOfFloat) {}
  
  public void run()
  {
    GLES20.glUniform3fv(this.a, 1, FloatBuffer.wrap(this.b));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.basic.opengl.j.4
 * JD-Core Version:    0.7.0.1
 */