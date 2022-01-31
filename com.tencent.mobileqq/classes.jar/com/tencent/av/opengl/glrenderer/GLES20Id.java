package com.tencent.av.opengl.glrenderer;

import android.opengl.GLES20;
import com.tencent.av.opengl.utils.Utils;
import javax.microedition.khronos.opengles.GL11;

public class GLES20Id
  implements GLId
{
  public int a()
  {
    int[] arrayOfInt = new int[1];
    arrayOfInt[0] = 0;
    GLES20.glGenTextures(1, arrayOfInt, 0);
    Utils.a();
    return arrayOfInt[0];
  }
  
  public void a(int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    GLES20.glGenBuffers(paramInt1, paramArrayOfInt, paramInt2);
    Utils.a();
  }
  
  public void a(GL11 paramGL11, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    GLES20.glDeleteTextures(paramInt1, paramArrayOfInt, paramInt2);
    Utils.a();
  }
  
  public void b(GL11 paramGL11, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    GLES20.glDeleteBuffers(paramInt1, paramArrayOfInt, paramInt2);
    Utils.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.opengl.glrenderer.GLES20Id
 * JD-Core Version:    0.7.0.1
 */