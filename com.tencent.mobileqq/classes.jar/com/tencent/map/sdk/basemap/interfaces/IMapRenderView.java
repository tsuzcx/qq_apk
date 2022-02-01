package com.tencent.map.sdk.basemap.interfaces;

import android.view.MotionEvent;
import com.tencent.map.sdk.a.lf;

public abstract interface IMapRenderView
{
  public static final int MAP_VIEW_TYPE_GLSURFACEVIEW = 0;
  public static final int MAP_VIEW_TYPE_SURFACERENDER_LAYER = 2;
  public static final int MAP_VIEW_TYPE_TEXTUREVIEW = 1;
  
  public abstract int getHeight();
  
  public abstract lf getVectorMapDelegate();
  
  public abstract int getWidth();
  
  public abstract void onDestroy();
  
  public abstract void onPause();
  
  public abstract void onRedraw();
  
  public abstract void onResume();
  
  public abstract void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract void onSurfaceChanged(Object paramObject, int paramInt1, int paramInt2);
  
  public abstract boolean onTouchEvent(MotionEvent paramMotionEvent);
  
  public abstract void setZOrderMediaOverlay(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.basemap.interfaces.IMapRenderView
 * JD-Core Version:    0.7.0.1
 */