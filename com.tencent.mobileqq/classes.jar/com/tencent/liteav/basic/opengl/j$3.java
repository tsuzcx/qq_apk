package com.tencent.liteav.basic.opengl;

import android.opengl.GLES20;
import java.nio.FloatBuffer;

class j$3
  implements Runnable
{
  j$3(j paramj, int paramInt, float[] paramArrayOfFloat) {}
  
  public void run()
  {
    GLES20.glUniform2fv(this.a, 1, FloatBuffer.wrap(this.b));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.basic.opengl.j.3
 * JD-Core Version:    0.7.0.1
 */