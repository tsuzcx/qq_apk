package com.tencent.mobileqq.ar;

import android.annotation.TargetApi;
import android.content.Context;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.Renderer;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import com.tencent.qphone.base.util.QLog;
import zty;

@TargetApi(14)
public class ARGLSurfaceView
  extends GLSurfaceView
{
  private ARGLSurfaceView.ARGLSurfaceViewCallback a;
  
  public ARGLSurfaceView(Context paramContext, SurfaceHolder.Callback paramCallback, ARGLSurfaceView.ARGLSurfaceViewCallback paramARGLSurfaceViewCallback)
  {
    super(paramContext);
    QLog.i("AREngine_ARGLSurfaceView", 1, "create ARGLSurfaceView. context = " + paramContext + ", holderCallback = " + paramCallback + ", surfaceViewCallback = " + paramARGLSurfaceViewCallback);
    setEGLContextFactory(new zty(this));
    setEGLContextClientVersion(2);
    setEGLConfigChooser(8, 8, 8, 8, 16, 0);
    getHolder().addCallback(paramCallback);
    this.a = paramARGLSurfaceViewCallback;
  }
  
  public void onPause()
  {
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.a != null) {
      this.a.a(paramMotionEvent, paramMotionEvent.getRawX(), paramMotionEvent.getRawY(), getWidth(), getHeight());
    }
    super.onTouchEvent(paramMotionEvent);
    return true;
  }
  
  @Deprecated
  public void setRenderer(GLSurfaceView.Renderer paramRenderer)
  {
    super.setRenderer(paramRenderer);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARGLSurfaceView
 * JD-Core Version:    0.7.0.1
 */