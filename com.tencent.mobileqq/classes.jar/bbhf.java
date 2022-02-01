import android.opengl.GLSurfaceView;
import android.view.MotionEvent;
import com.tencent.ttpic.openapi.filter.GLGestureListener;
import dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView;

public class bbhf
  implements GLGestureListener
{
  GLSurfaceView a;
  
  public bbhf(GLSurfaceView paramGLSurfaceView)
  {
    this.a = paramGLSurfaceView;
  }
  
  public int onGetPriority()
  {
    return 1020;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent, boolean paramBoolean)
  {
    if (paramMotionEvent.getPointerCount() > 2) {
      return false;
    }
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    do
    {
      do
      {
        return false;
      } while ((!(this.a instanceof AECameraGLSurfaceView)) || (!((AECameraGLSurfaceView)this.a).hasTapEffect()));
      ((AECameraGLSurfaceView)this.a).setTapEvent(100, paramMotionEvent.getX(), paramMotionEvent.getY());
      return true;
    } while ((!(this.a instanceof AECameraGLSurfaceView)) || (!((AECameraGLSurfaceView)this.a).hasTapEffect()));
    ((AECameraGLSurfaceView)this.a).setTapEvent(100, paramMotionEvent.getX(1) + paramMotionEvent.getRawX() - paramMotionEvent.getX(0), paramMotionEvent.getY(1) + paramMotionEvent.getRawY() - paramMotionEvent.getY(0));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbhf
 * JD-Core Version:    0.7.0.1
 */