package com.tencent.aelight.camera.ae.gesture;

import android.opengl.GLSurfaceView;
import android.view.MotionEvent;
import com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.ttpic.openapi.filter.GLGestureListener;

public class CameraTriggerGesture
  implements GLGestureListener
{
  GLSurfaceView a;
  private int b = 0;
  
  public CameraTriggerGesture(GLSurfaceView paramGLSurfaceView, int paramInt)
  {
    this.b = paramInt;
    this.a = paramGLSurfaceView;
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
    if (!(this.a instanceof AECameraGLSurfaceView)) {
      return false;
    }
    AEQLog.a("GLGestureListener", "[gestureFix][CameraTriggerGesture]:onTouchEvent");
    int i = paramMotionEvent.getAction() & 0xFF;
    AECameraGLSurfaceView localAECameraGLSurfaceView = (AECameraGLSurfaceView)this.a;
    paramBoolean = localAECameraGLSurfaceView.hasTouchEffect();
    boolean bool = localAECameraGLSurfaceView.hasTapEffect();
    if (paramBoolean)
    {
      localAECameraGLSurfaceView.updateTouchEvent(paramMotionEvent);
      paramBoolean = true;
    }
    else
    {
      paramBoolean = false;
    }
    if (bool) {
      if (i != 1)
      {
        if (i == 6)
        {
          localAECameraGLSurfaceView.setTapEvent(100, paramMotionEvent.getX(1) + paramMotionEvent.getRawX() - paramMotionEvent.getX(0), paramMotionEvent.getY(1) + paramMotionEvent.getRawY() - paramMotionEvent.getY(0));
          return true;
        }
      }
      else
      {
        localAECameraGLSurfaceView.setTapEvent(100, paramMotionEvent.getX(), paramMotionEvent.getY() - this.b);
        return true;
      }
    }
    return paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gesture.CameraTriggerGesture
 * JD-Core Version:    0.7.0.1
 */