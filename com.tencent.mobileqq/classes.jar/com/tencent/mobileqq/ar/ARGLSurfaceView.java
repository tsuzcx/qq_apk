package com.tencent.mobileqq.ar;

import akxc;
import akxd;
import akxe;
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
  private akxd jdField_a_of_type_Akxd;
  private akxe jdField_a_of_type_Akxe;
  
  public ARGLSurfaceView(Context paramContext, SurfaceHolder.Callback paramCallback, akxd paramakxd)
  {
    super(paramContext);
    QLog.i("AREngine_ARGLSurfaceView", 1, "create ARGLSurfaceView. context = " + paramContext + ", holderCallback = " + paramCallback + ", surfaceViewCallback = " + paramakxd);
    setEGLContextFactory(new akxc(this));
    setEGLContextClientVersion(2);
    setEGLConfigChooser(8, 8, 8, 8, 16, 0);
    if (paramCallback != null) {
      getHolder().addCallback(paramCallback);
    }
    this.jdField_a_of_type_Akxd = paramakxd;
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
    if (this.jdField_a_of_type_Akxd != null) {
      this.jdField_a_of_type_Akxd.a(paramMotionEvent, paramMotionEvent.getRawX(), paramMotionEvent.getRawY(), getWidth(), getHeight());
    }
    super.onTouchEvent(paramMotionEvent);
    return false;
  }
  
  public void setOnEglContextDestoryListener(akxe paramakxe)
  {
    this.jdField_a_of_type_Akxe = paramakxe;
  }
  
  @Deprecated
  public void setRenderer(GLSurfaceView.Renderer paramRenderer)
  {
    super.setRenderer(paramRenderer);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARGLSurfaceView
 * JD-Core Version:    0.7.0.1
 */