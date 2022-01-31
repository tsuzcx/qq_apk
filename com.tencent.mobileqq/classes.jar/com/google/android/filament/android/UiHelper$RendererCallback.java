package com.google.android.filament.android;

import android.view.Surface;

public abstract interface UiHelper$RendererCallback
{
  public abstract void onDetachedFromSurface();
  
  public abstract void onNativeWindowChanged(Surface paramSurface);
  
  public abstract void onResized(int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.google.android.filament.android.UiHelper.RendererCallback
 * JD-Core Version:    0.7.0.1
 */