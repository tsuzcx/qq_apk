package com.peterlmeng.animate_image.renderer;

import android.graphics.SurfaceTexture;

public abstract interface OpenGLRenderer$Worker
{
  public abstract void onCreate(SurfaceTexture paramSurfaceTexture);
  
  public abstract void onDispose();
  
  public abstract boolean onDraw();
  
  public abstract boolean onResourceGet();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.peterlmeng.animate_image.renderer.OpenGLRenderer.Worker
 * JD-Core Version:    0.7.0.1
 */