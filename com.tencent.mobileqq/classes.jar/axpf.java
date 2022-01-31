import android.opengl.GLSurfaceView;
import android.view.MotionEvent;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView;
import com.tencent.ttpic.openapi.filter.GLGestureListener;
import dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView;
import java.math.BigDecimal;

public class axpf
  implements GLGestureListener
{
  public float a;
  public GLSurfaceView a;
  private float b;
  private float c;
  
  public axpf(GLSurfaceView paramGLSurfaceView)
  {
    this.jdField_a_of_type_AndroidOpenglGLSurfaceView = paramGLSurfaceView;
  }
  
  public int onGetPriority()
  {
    return 0;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent, boolean paramBoolean)
  {
    int i = paramMotionEvent.getPointerCount();
    int j = paramMotionEvent.getAction() & 0xFF;
    if ((j != 3) || ((i == 1) && (paramBoolean))) {
      switch (j)
      {
      }
    }
    float f4;
    float f2;
    float f3;
    for (;;)
    {
      return false;
      this.c = this.jdField_a_of_type_Float;
      continue;
      if (paramMotionEvent.getY() >= this.jdField_a_of_type_Float)
      {
        this.c = this.jdField_a_of_type_Float;
      }
      else
      {
        i = new BigDecimal((this.c - paramMotionEvent.getY()) / 20.0F).setScale(0, 4).intValue();
        if ((i != 0) && (this.jdField_a_of_type_AndroidOpenglGLSurfaceView != null))
        {
          if ((this.jdField_a_of_type_AndroidOpenglGLSurfaceView instanceof CameraCaptureView)) {
            ((CameraCaptureView)this.jdField_a_of_type_AndroidOpenglGLSurfaceView).setZoom(i);
          }
          for (;;)
          {
            this.c = paramMotionEvent.getY();
            break;
            if ((this.jdField_a_of_type_AndroidOpenglGLSurfaceView instanceof AECameraGLSurfaceView)) {
              ((AECameraGLSurfaceView)this.jdField_a_of_type_AndroidOpenglGLSurfaceView).setZoom(i);
            }
          }
          if ((i == 2) && (!paramBoolean))
          {
            wxe.a("CameraZoomGesture", "onTouchEvent %s", new Object[] { paramMotionEvent });
            if (i != 2) {
              break;
            }
            f4 = paramMotionEvent.getX(0);
            f2 = paramMotionEvent.getY(0);
            f3 = paramMotionEvent.getX(1);
            f1 = paramMotionEvent.getY(1);
            label254:
            switch (j)
            {
            }
          }
        }
      }
    }
    float f1 = xcp.a(f4, f2, f3, f1);
    i = new BigDecimal((f1 - this.b) / 20.0F).setScale(0, 4).intValue();
    if ((i != 0) && (this.jdField_a_of_type_AndroidOpenglGLSurfaceView != null))
    {
      if (!(this.jdField_a_of_type_AndroidOpenglGLSurfaceView instanceof CameraCaptureView)) {
        break label421;
      }
      ((CameraCaptureView)this.jdField_a_of_type_AndroidOpenglGLSurfaceView).setZoom(i);
    }
    for (;;)
    {
      this.b = f1;
      return true;
      f4 = paramMotionEvent.getX(1);
      f2 = paramMotionEvent.getY(1);
      f3 = paramMotionEvent.getX(2);
      f1 = paramMotionEvent.getY(2);
      break label254;
      this.b = xcp.a(f4, f2, f3, f1);
      break;
      label421:
      if ((this.jdField_a_of_type_AndroidOpenglGLSurfaceView instanceof AECameraGLSurfaceView)) {
        ((AECameraGLSurfaceView)this.jdField_a_of_type_AndroidOpenglGLSurfaceView).setZoom(i);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     axpf
 * JD-Core Version:    0.7.0.1
 */