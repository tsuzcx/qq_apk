package com.tencent.mobileqq.ar;

import android.annotation.TargetApi;
import android.content.Context;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.Renderer;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import com.tencent.qphone.base.util.QLog;

@TargetApi(14)
public class ARGLSurfaceView
  extends GLSurfaceView
{
  private ARGLSurfaceView.ARGLSurfaceViewCallback jdField_a_of_type_ComTencentMobileqqArARGLSurfaceView$ARGLSurfaceViewCallback = null;
  private ARGLSurfaceView.OnEglContextDestoryListener jdField_a_of_type_ComTencentMobileqqArARGLSurfaceView$OnEglContextDestoryListener;
  
  public ARGLSurfaceView(Context paramContext, SurfaceHolder.Callback paramCallback, ARGLSurfaceView.ARGLSurfaceViewCallback paramARGLSurfaceViewCallback)
  {
    super(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("create ARGLSurfaceView. context = ");
    localStringBuilder.append(paramContext);
    localStringBuilder.append(", holderCallback = ");
    localStringBuilder.append(paramCallback);
    localStringBuilder.append(", surfaceViewCallback = ");
    localStringBuilder.append(paramARGLSurfaceViewCallback);
    QLog.i("AREngine_ARGLSurfaceView", 1, localStringBuilder.toString());
    setEGLContextFactory(new ARGLSurfaceView.1(this));
    setEGLContextClientVersion(2);
    setEGLConfigChooser(8, 8, 8, 8, 16, 0);
    if (paramCallback != null) {
      getHolder().addCallback(paramCallback);
    }
    this.jdField_a_of_type_ComTencentMobileqqArARGLSurfaceView$ARGLSurfaceViewCallback = paramARGLSurfaceViewCallback;
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
    ARGLSurfaceView.ARGLSurfaceViewCallback localARGLSurfaceViewCallback = this.jdField_a_of_type_ComTencentMobileqqArARGLSurfaceView$ARGLSurfaceViewCallback;
    if (localARGLSurfaceViewCallback != null) {
      localARGLSurfaceViewCallback.a(paramMotionEvent, paramMotionEvent.getRawX(), paramMotionEvent.getRawY(), getWidth(), getHeight());
    }
    super.onTouchEvent(paramMotionEvent);
    return false;
  }
  
  public void setOnEglContextDestoryListener(ARGLSurfaceView.OnEglContextDestoryListener paramOnEglContextDestoryListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqArARGLSurfaceView$OnEglContextDestoryListener = paramOnEglContextDestoryListener;
  }
  
  @Deprecated
  public void setRenderer(GLSurfaceView.Renderer paramRenderer)
  {
    super.setRenderer(paramRenderer);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARGLSurfaceView
 * JD-Core Version:    0.7.0.1
 */