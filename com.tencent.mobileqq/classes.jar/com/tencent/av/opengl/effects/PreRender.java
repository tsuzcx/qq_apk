package com.tencent.av.opengl.effects;

public abstract interface PreRender
  extends FilterRender
{
  public abstract GLTexture a(FilterProcessRender paramFilterProcessRender, CameraFrame paramCameraFrame, GLTexture paramGLTexture);
  
  public abstract boolean a(CameraFrame paramCameraFrame);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.opengl.effects.PreRender
 * JD-Core Version:    0.7.0.1
 */