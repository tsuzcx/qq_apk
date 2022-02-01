import android.opengl.GLSurfaceView;
import android.view.MotionEvent;
import com.tencent.ttpic.openapi.filter.GLGestureListener;
import com.tencent.ttpic.openapi.filter.GLGestureProxy;
import dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView;

public class bane
  implements GLGestureListener
{
  public int onGetPriority()
  {
    return 1020;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent, boolean paramBoolean)
  {
    if (paramMotionEvent.getPointerCount() > 2) {
      return false;
    }
    int i = paramMotionEvent.getAction();
    GLSurfaceView localGLSurfaceView = GLGestureProxy.getInstance().getGLSurfaceView();
    switch (i & 0xFF)
    {
    }
    do
    {
      do
      {
        return false;
      } while ((!(localGLSurfaceView instanceof AECameraGLSurfaceView)) || (!((AECameraGLSurfaceView)localGLSurfaceView).c()));
      ((AECameraGLSurfaceView)localGLSurfaceView).setTapEvent(100, paramMotionEvent.getX(), paramMotionEvent.getY());
      return true;
    } while ((!(localGLSurfaceView instanceof AECameraGLSurfaceView)) || (!((AECameraGLSurfaceView)localGLSurfaceView).c()));
    ((AECameraGLSurfaceView)localGLSurfaceView).setTapEvent(100, paramMotionEvent.getX(1) + paramMotionEvent.getRawX() - paramMotionEvent.getX(0), paramMotionEvent.getY(1) + paramMotionEvent.getRawY() - paramMotionEvent.getY(0));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bane
 * JD-Core Version:    0.7.0.1
 */