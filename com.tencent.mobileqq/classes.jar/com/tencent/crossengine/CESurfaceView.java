package com.tencent.crossengine;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback2;
import android.view.SurfaceView;

public class CESurfaceView
  extends SurfaceView
  implements SurfaceHolder.Callback2
{
  private static final String TAG = "CESurfaceView";
  private GestureDetector mGestureDetector;
  private RenderContext mRenderContext;
  private TouchProcessor mTouchProcessor;
  
  public CESurfaceView(Context paramContext)
  {
    super(paramContext);
  }
  
  public CESurfaceView(Context paramContext, RenderContext paramRenderContext, TouchProcessor paramTouchProcessor)
  {
    super(paramContext);
    this.mTouchProcessor = paramTouchProcessor;
    this.mRenderContext = paramRenderContext;
    getHolder().addCallback(this);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    GestureDetector localGestureDetector = this.mGestureDetector;
    if (localGestureDetector != null) {
      return localGestureDetector.onTouchEvent(paramMotionEvent);
    }
    return this.mTouchProcessor.onTouchEvent(paramMotionEvent);
  }
  
  public void setGestureDetector(GestureDetector paramGestureDetector)
  {
    this.mGestureDetector = paramGestureDetector;
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    this.mRenderContext.surfaceChanged(paramSurfaceHolder.getSurface(), paramInt2, paramInt3);
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    int i = getMeasuredWidth();
    int j = getMeasuredHeight();
    this.mRenderContext.initRenderContext(paramSurfaceHolder.getSurface(), i, j);
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    this.mRenderContext.destroyRenderContext();
  }
  
  public void surfaceRedrawNeeded(SurfaceHolder paramSurfaceHolder) {}
  
  public void surfaceRedrawNeededAsync(SurfaceHolder paramSurfaceHolder, Runnable paramRunnable)
  {
    surfaceRedrawNeeded(paramSurfaceHolder);
    paramRunnable.run();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.crossengine.CESurfaceView
 * JD-Core Version:    0.7.0.1
 */