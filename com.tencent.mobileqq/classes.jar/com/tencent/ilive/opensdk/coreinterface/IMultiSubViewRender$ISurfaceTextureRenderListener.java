package com.tencent.ilive.opensdk.coreinterface;

import android.graphics.SurfaceTexture;
import android.view.Surface;

public abstract interface IMultiSubViewRender$ISurfaceTextureRenderListener
{
  public abstract void onCreate(Surface paramSurface, SurfaceTexture paramSurfaceTexture);
  
  public abstract void onDestroy();
  
  public abstract void onUpdate(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.opensdk.coreinterface.IMultiSubViewRender.ISurfaceTextureRenderListener
 * JD-Core Version:    0.7.0.1
 */