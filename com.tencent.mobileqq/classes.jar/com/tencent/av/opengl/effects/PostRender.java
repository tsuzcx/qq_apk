package com.tencent.av.opengl.effects;

public abstract interface PostRender
  extends FilterRender
{
  public abstract int a();
  
  public abstract void a(FilterProcessRender paramFilterProcessRender, CameraFrame paramCameraFrame, GLTexture paramGLTexture, FaceData paramFaceData, RenderResult paramRenderResult);
  
  public abstract byte[] a();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.opengl.effects.PostRender
 * JD-Core Version:    0.7.0.1
 */