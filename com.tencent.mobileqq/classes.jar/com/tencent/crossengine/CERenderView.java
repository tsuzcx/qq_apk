package com.tencent.crossengine;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.crossengine.log.Logger;

public class CERenderView
  extends TextureView
  implements TextureView.SurfaceTextureListener
{
  public static final String TAG = "CERenderView";
  private GestureDetector mGestureDetector;
  private RenderContext mRenderContext;
  private TouchProcessor mTouchProcessor;
  
  public CERenderView(Context paramContext, RenderContext paramRenderContext, TouchProcessor paramTouchProcessor)
  {
    super(paramContext);
    setSurfaceTextureListener(this);
    this.mTouchProcessor = paramTouchProcessor;
    this.mRenderContext = paramRenderContext;
    setOpaque(false);
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onSurfaceTextureAvailable width : ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("; height : ");
    localStringBuilder.append(paramInt2);
    Logger.a("CERenderView", localStringBuilder.toString());
    this.mRenderContext.initRenderContext(new Surface(paramSurfaceTexture), paramInt1, paramInt2);
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    Logger.a("CERenderView", "onSurfaceTextureDestroyed");
    this.mRenderContext.destroyRenderContext();
    return true;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onSurfaceTextureSizeChanged width : ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("; height : ");
    localStringBuilder.append(paramInt2);
    Logger.a("CERenderView", localStringBuilder.toString());
    this.mRenderContext.surfaceChanged(new Surface(paramSurfaceTexture), paramInt1, paramInt2);
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
  
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.crossengine.CERenderView
 * JD-Core Version:    0.7.0.1
 */