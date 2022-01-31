package com.tencent.mobileqq.ar;

import akxd;
import akxe;
import akxf;
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
  private akxe jdField_a_of_type_Akxe;
  private akxf jdField_a_of_type_Akxf;
  
  public ARGLSurfaceView(Context paramContext, SurfaceHolder.Callback paramCallback, akxe paramakxe)
  {
    super(paramContext);
    QLog.i("AREngine_ARGLSurfaceView", 1, "create ARGLSurfaceView. context = " + paramContext + ", holderCallback = " + paramCallback + ", surfaceViewCallback = " + paramakxe);
    setEGLContextFactory(new akxd(this));
    setEGLContextClientVersion(2);
    setEGLConfigChooser(8, 8, 8, 8, 16, 0);
    if (paramCallback != null) {
      getHolder().addCallback(paramCallback);
    }
    this.jdField_a_of_type_Akxe = paramakxe;
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
    if (this.jdField_a_of_type_Akxe != null) {
      this.jdField_a_of_type_Akxe.a(paramMotionEvent, paramMotionEvent.getRawX(), paramMotionEvent.getRawY(), getWidth(), getHeight());
    }
    super.onTouchEvent(paramMotionEvent);
    return false;
  }
  
  public void setOnEglContextDestoryListener(akxf paramakxf)
  {
    this.jdField_a_of_type_Akxf = paramakxf;
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