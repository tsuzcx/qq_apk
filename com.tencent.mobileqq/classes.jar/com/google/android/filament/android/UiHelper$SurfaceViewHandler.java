package com.google.android.filament.android;

import android.view.SurfaceHolder;
import android.view.SurfaceView;

class UiHelper$SurfaceViewHandler
  implements UiHelper.RenderSurface
{
  private SurfaceView mSurfaceView;
  
  UiHelper$SurfaceViewHandler(SurfaceView paramSurfaceView)
  {
    this.mSurfaceView = paramSurfaceView;
  }
  
  public void detach() {}
  
  public void resize(int paramInt1, int paramInt2)
  {
    this.mSurfaceView.getHolder().setFixedSize(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.google.android.filament.android.UiHelper.SurfaceViewHandler
 * JD-Core Version:    0.7.0.1
 */