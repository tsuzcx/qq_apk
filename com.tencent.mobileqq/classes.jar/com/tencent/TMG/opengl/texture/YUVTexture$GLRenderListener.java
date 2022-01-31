package com.tencent.TMG.opengl.texture;

public abstract interface YUVTexture$GLRenderListener
{
  public abstract void onRenderFlush();
  
  public abstract void onRenderFrame();
  
  public abstract void onRenderInfoNotify(int paramInt1, int paramInt2, int paramInt3);
  
  public abstract void onRenderReset();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.TMG.opengl.texture.YUVTexture.GLRenderListener
 * JD-Core Version:    0.7.0.1
 */