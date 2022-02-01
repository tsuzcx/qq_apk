package com.tencent.av.opengl.texture;

import com.tencent.av.opengl.glrenderer.GLCanvas;

public class ColorTexture
  implements Texture
{
  private final int a;
  private int b;
  private int c;
  
  public ColorTexture(int paramInt)
  {
    this.a = paramInt;
    this.b = 1;
    this.c = 1;
  }
  
  public void a(GLCanvas paramGLCanvas, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramGLCanvas.a(paramInt1, paramInt2, paramInt3, paramInt4, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.opengl.texture.ColorTexture
 * JD-Core Version:    0.7.0.1
 */