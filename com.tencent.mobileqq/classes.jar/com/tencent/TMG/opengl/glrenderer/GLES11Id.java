package com.tencent.TMG.opengl.glrenderer;

import javax.microedition.khronos.opengles.GL11;
import javax.microedition.khronos.opengles.GL11ExtensionPack;

public class GLES11Id
  implements GLId
{
  private static Object sLock = new Object();
  private static int sNextId = 1;
  
  public int generateTexture()
  {
    synchronized (sLock)
    {
      int i = sNextId;
      sNextId = i + 1;
      return i;
    }
  }
  
  public int[] generateTexture(int paramInt)
  {
    return null;
  }
  
  public void glDeleteBuffers(GL11 paramGL11, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    synchronized (sLock)
    {
      paramGL11.glDeleteBuffers(paramInt1, paramArrayOfInt, paramInt2);
      return;
    }
  }
  
  public void glDeleteFramebuffers(GL11ExtensionPack paramGL11ExtensionPack, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    synchronized (sLock)
    {
      paramGL11ExtensionPack.glDeleteFramebuffersOES(paramInt1, paramArrayOfInt, paramInt2);
      return;
    }
  }
  
  public void glDeleteTextures(GL11 paramGL11, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    synchronized (sLock)
    {
      paramGL11.glDeleteTextures(paramInt1, paramArrayOfInt, paramInt2);
      return;
    }
  }
  
  public void glGenBuffers(int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    localObject = sLock;
    for (;;)
    {
      int i = paramInt1 - 1;
      if (paramInt1 > 0) {}
      try
      {
        paramInt1 = sNextId;
        sNextId = paramInt1 + 1;
        paramArrayOfInt[(paramInt2 + i)] = paramInt1;
        paramInt1 = i;
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.TMG.opengl.glrenderer.GLES11Id
 * JD-Core Version:    0.7.0.1
 */