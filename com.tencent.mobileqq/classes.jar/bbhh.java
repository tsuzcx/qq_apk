import android.opengl.GLSurfaceView;
import android.view.MotionEvent;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView;
import com.tencent.ttpic.openapi.filter.GLGestureListener;
import java.math.BigDecimal;

public class bbhh
  implements GLGestureListener
{
  public float a;
  public GLSurfaceView a;
  bbhi a;
  private float b;
  private float c;
  
  public bbhh(GLSurfaceView paramGLSurfaceView)
  {
    this.jdField_a_of_type_AndroidOpenglGLSurfaceView = paramGLSurfaceView;
  }
  
  public bbhh(bbhi parambbhi)
  {
    this.jdField_a_of_type_Bbhi = parambbhi;
  }
  
  protected void a(int paramInt)
  {
    if ((this.jdField_a_of_type_AndroidOpenglGLSurfaceView instanceof CameraCaptureView)) {
      ((CameraCaptureView)this.jdField_a_of_type_AndroidOpenglGLSurfaceView).setZoom(paramInt);
    }
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
    while ((i != 2) || (paramBoolean))
    {
      return false;
      this.c = this.jdField_a_of_type_Float;
      return false;
      if (paramMotionEvent.getY() >= this.jdField_a_of_type_Float)
      {
        this.c = this.jdField_a_of_type_Float;
        return false;
      }
      i = new BigDecimal((this.c - paramMotionEvent.getY()) / 20.0F).setScale(0, 4).intValue();
      if (this.jdField_a_of_type_Bbhi != null) {
        this.jdField_a_of_type_Bbhi.a(i);
      }
      for (;;)
      {
        this.c = paramMotionEvent.getY();
        return false;
        if ((i != 0) && (this.jdField_a_of_type_AndroidOpenglGLSurfaceView != null)) {
          a(i);
        }
      }
    }
    ykq.a("CameraZoomGesture", "onTouchEvent %s", new Object[] { paramMotionEvent });
    float f4;
    float f2;
    float f3;
    float f1;
    if (i == 2)
    {
      f4 = paramMotionEvent.getX(0);
      f2 = paramMotionEvent.getY(0);
      f3 = paramMotionEvent.getX(1);
      f1 = paramMotionEvent.getY(1);
      switch (j)
      {
      case 6: 
      case 3: 
      case 4: 
      default: 
        return false;
      case 2: 
        f1 = ypx.a(f4, f2, f3, f1);
        i = new BigDecimal((f1 - this.b) / 20.0F).setScale(0, 4).intValue();
        if (this.jdField_a_of_type_Bbhi != null) {
          this.jdField_a_of_type_Bbhi.a(i);
        }
        break;
      }
    }
    for (;;)
    {
      return true;
      f4 = paramMotionEvent.getX(1);
      f2 = paramMotionEvent.getY(1);
      f3 = paramMotionEvent.getX(2);
      f1 = paramMotionEvent.getY(2);
      break;
      this.b = ypx.a(f4, f2, f3, f1);
      return false;
      if ((i != 0) && (this.jdField_a_of_type_AndroidOpenglGLSurfaceView != null))
      {
        a(i);
        this.b = f1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbhh
 * JD-Core Version:    0.7.0.1
 */