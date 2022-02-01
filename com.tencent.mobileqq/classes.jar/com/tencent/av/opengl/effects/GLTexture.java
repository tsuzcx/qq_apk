package com.tencent.av.opengl.effects;

public class GLTexture
{
  private static final Object d = new Object();
  private static GLTexture e;
  private static int f = 0;
  public int a;
  public int b;
  private GLTexture c;
  
  private GLTexture(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
  }
  
  public static GLTexture a(int paramInt1, int paramInt2)
  {
    synchronized (d)
    {
      if (e != null)
      {
        GLTexture localGLTexture = e;
        e = localGLTexture.c;
        localGLTexture.c = null;
        localGLTexture.a = paramInt1;
        localGLTexture.b = paramInt2;
        f -= 1;
        return localGLTexture;
      }
      return new GLTexture(paramInt1, paramInt2);
    }
  }
  
  public void a()
  {
    this.a = -1;
    this.b = -1;
    synchronized (d)
    {
      if (f < 4)
      {
        this.c = e;
        e = this;
        f += 1;
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.opengl.effects.GLTexture
 * JD-Core Version:    0.7.0.1
 */