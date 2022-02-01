package com.tencent.aelight.camera.ae.gesture;

import android.opengl.GLSurfaceView;
import android.view.MotionEvent;
import com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.ttpic.openapi.filter.GLGestureListener;

public class CameraTriggerGesture
  implements GLGestureListener
{
  private int jdField_a_of_type_Int = 0;
  GLSurfaceView jdField_a_of_type_AndroidOpenglGLSurfaceView;
  
  public CameraTriggerGesture(GLSurfaceView paramGLSurfaceView, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidOpenglGLSurfaceView = paramGLSurfaceView;
  }
  
  public int onGetPriority()
  {
    return 1010;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent, boolean paramBoolean)
  {
    if (paramMotionEvent.getPointerCount() > 2) {
      return false;
    }
    AEQLog.a("GLGestureListener", "[gestureFix][CameraTriggerGesture]:onTouchEvent");
    int i = paramMotionEvent.getAction() & 0xFF;
    GLSurfaceView localGLSurfaceView;
    if (i != 1)
    {
      if (i != 6) {
        return false;
      }
      localGLSurfaceView = this.jdField_a_of_type_AndroidOpenglGLSurfaceView;
      if (((localGLSurfaceView instanceof AECameraGLSurfaceView)) && (((AECameraGLSurfaceView)localGLSurfaceView).hasTapEffect()))
      {
        ((AECameraGLSurfaceView)this.jdField_a_of_type_AndroidOpenglGLSurfaceView).setTapEvent(100, paramMotionEvent.getX(1) + paramMotionEvent.getRawX() - paramMotionEvent.getX(0), paramMotionEvent.getY(1) + paramMotionEvent.getRawY() - paramMotionEvent.getY(0));
        return true;
      }
    }
    else
    {
      localGLSurfaceView = this.jdField_a_of_type_AndroidOpenglGLSurfaceView;
      if (((localGLSurfaceView instanceof AECameraGLSurfaceView)) && (((AECameraGLSurfaceView)localGLSurfaceView).hasTapEffect()))
      {
        ((AECameraGLSurfaceView)this.jdField_a_of_type_AndroidOpenglGLSurfaceView).setTapEvent(100, paramMotionEvent.getX(), paramMotionEvent.getY() - this.jdField_a_of_type_Int);
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gesture.CameraTriggerGesture
 * JD-Core Version:    0.7.0.1
 */