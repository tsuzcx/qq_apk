import android.opengl.GLSurfaceView;
import android.view.MotionEvent;
import com.tencent.ttpic.openapi.filter.GLGestureListener;
import com.tencent.ttpic.openapi.filter.GLGestureProxy;
import dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView;

public class axku
  implements GLGestureListener
{
  public int onGetPriority()
  {
    return 1020;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent, boolean paramBoolean)
  {
    if (paramMotionEvent.getPointerCount() != 1) {
      return false;
    }
    int i = paramMotionEvent.getAction();
    GLSurfaceView localGLSurfaceView = GLGestureProxy.getInstance().getGLSurfaceView();
    switch (i & 0xFF)
    {
    }
    do
    {
      return false;
    } while ((!(localGLSurfaceView instanceof AECameraGLSurfaceView)) || (!((AECameraGLSurfaceView)localGLSurfaceView).c()));
    ((AECameraGLSurfaceView)localGLSurfaceView).setTapEvent(100, paramMotionEvent.getX(), paramMotionEvent.getY());
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     axku
 * JD-Core Version:    0.7.0.1
 */