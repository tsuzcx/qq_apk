package com.tencent.av.opengl.effects;

public abstract interface PostRender
  extends FilterRender
{
  public abstract void a(FilterProcessRender paramFilterProcessRender, CameraFrame paramCameraFrame, GLTexture paramGLTexture, FaceData paramFaceData, RenderResult paramRenderResult);
  
  public abstract byte[] d();
  
  public abstract int e();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.opengl.effects.PostRender
 * JD-Core Version:    0.7.0.1
 */