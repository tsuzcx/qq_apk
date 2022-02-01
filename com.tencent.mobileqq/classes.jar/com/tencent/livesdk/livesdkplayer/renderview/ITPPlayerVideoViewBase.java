package com.tencent.livesdk.livesdkplayer.renderview;

import android.graphics.Rect;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;

public abstract interface ITPPlayerVideoViewBase
{
  public static final int EXT_RENDER_TYPE_NORMAL = 0;
  public static final int EXT_RENDER_TYPE_VIDEO_FILTER = 2;
  public static final int EXT_RENDER_TYPE_VR = 1;
  
  public abstract void addSurfaceCallback(ITPPlayerVideoViewBase.IVideoSurfaceCallback paramIVideoSurfaceCallback);
  
  public abstract void addVideoViewCallback(ITPPlayerVideoViewBase.IVideoViewCallback paramIVideoViewCallback);
  
  public abstract View getCurrentDisplayView();
  
  public abstract Rect getDisplayViewRect();
  
  public abstract ViewGroup getMidLayout();
  
  public abstract Object getRenderObject();
  
  public abstract String getSerialNO();
  
  public abstract int getViewRenderMode();
  
  public abstract Surface getViewSurface();
  
  public abstract boolean isSurfaceReady();
  
  public abstract void readyRender();
  
  public abstract void release();
  
  public abstract void removeSurfaceCallback(ITPPlayerVideoViewBase.IVideoSurfaceCallback paramIVideoSurfaceCallback);
  
  public abstract void removeVideoViewCallback(ITPPlayerVideoViewBase.IVideoViewCallback paramIVideoViewCallback);
  
  public abstract void requestRenderLayout();
  
  public abstract void resetView(boolean paramBoolean);
  
  public abstract boolean setDegree(int paramInt);
  
  public abstract void setFixedSize(int paramInt1, int paramInt2);
  
  public abstract void setMidLayout(View paramView);
  
  public abstract void setRadio(int paramInt1, int paramInt2);
  
  public abstract void setRenderGravity(int paramInt);
  
  public abstract void setScaleParam(float paramFloat);
  
  public abstract void setXYAxis(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.livesdk.livesdkplayer.renderview.ITPPlayerVideoViewBase
 * JD-Core Version:    0.7.0.1
 */