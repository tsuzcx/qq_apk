import android.opengl.GLSurfaceView;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.tencent.biz.qqstory.takevideo.CameraFocusView;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.GLGestureListener;
import com.tencent.ttpic.openapi.filter.GLGestureProxy;
import dov.com.qq.im.AECamera.View.AECameraGLSurfaceView;

public class auth
  implements GLGestureListener
{
  private float jdField_a_of_type_Float;
  int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  public CameraFocusView a;
  private float jdField_b_of_type_Float;
  int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private float jdField_c_of_type_Float;
  private final int jdField_c_of_type_Int;
  private float jdField_d_of_type_Float;
  private final int jdField_d_of_type_Int;
  
  public auth(CameraFocusView paramCameraFocusView)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoCameraFocusView = paramCameraFocusView;
    paramCameraFocusView = ViewConfiguration.get(paramCameraFocusView.getContext());
    this.jdField_c_of_type_Int = 300;
    this.jdField_d_of_type_Int = paramCameraFocusView.getScaledTouchSlop();
    this.jdField_a_of_type_Int = paramCameraFocusView.getScaledDoubleTapSlop();
    this.jdField_b_of_type_Int = (this.jdField_a_of_type_Int * this.jdField_a_of_type_Int);
  }
  
  private boolean a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    int i = (int)paramFloat3 - (int)paramFloat1;
    int j = (int)paramFloat4 - (int)paramFloat2;
    return i * i + j * j > this.jdField_d_of_type_Int * this.jdField_d_of_type_Int;
  }
  
  private boolean a(long paramLong1, long paramLong2)
  {
    return paramLong2 - paramLong1 < this.jdField_c_of_type_Int;
  }
  
  protected void a(CameraCaptureView paramCameraCaptureView, float paramFloat1, float paramFloat2)
  {
    paramCameraCaptureView.a(paramFloat1, paramFloat2);
  }
  
  protected void a(AECameraGLSurfaceView paramAECameraGLSurfaceView, float paramFloat1, float paramFloat2)
  {
    paramAECameraGLSurfaceView.a(paramFloat1, paramFloat2);
  }
  
  public int onGetPriority()
  {
    return 0;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent, boolean paramBoolean)
  {
    int i = paramMotionEvent.getPointerCount();
    int j = paramMotionEvent.getAction() & 0xFF;
    GLSurfaceView localGLSurfaceView = GLGestureProxy.getInstance().getGLSurfaceView();
    if ((!paramBoolean) && (i == 1)) {}
    switch (j)
    {
    default: 
      if ((paramBoolean) && (i == 2)) {
        switch (j)
        {
        }
      }
      break;
    }
    do
    {
      return false;
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      this.jdField_a_of_type_Float = paramMotionEvent.getX();
      this.jdField_b_of_type_Float = paramMotionEvent.getY();
      break;
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      this.jdField_c_of_type_Float = paramMotionEvent.getX();
      this.jdField_d_of_type_Float = paramMotionEvent.getY();
      if ((a(this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, this.jdField_c_of_type_Float, this.jdField_d_of_type_Float)) || (!a(this.jdField_a_of_type_Long, this.jdField_b_of_type_Long))) {
        break;
      }
      if ((localGLSurfaceView != null) && ((localGLSurfaceView instanceof CameraCaptureView)) && (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoCameraFocusView != null))
      {
        if (((CameraCaptureView)localGLSurfaceView).a() == 1) {
          break;
        }
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoCameraFocusView.a(paramMotionEvent);
        a((CameraCaptureView)localGLSurfaceView, paramMotionEvent.getX(), paramMotionEvent.getY());
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("GLGestureListener", 2, new Object[] { "", "CameraFocusGesture isRecording == false" });
        break;
      }
      if ((localGLSurfaceView == null) || (!(localGLSurfaceView instanceof AECameraGLSurfaceView)) || (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoCameraFocusView == null) || (((AECameraGLSurfaceView)localGLSurfaceView).b() == 1)) {
        break;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoCameraFocusView.a(paramMotionEvent);
      a((AECameraGLSurfaceView)localGLSurfaceView, paramMotionEvent.getX(), paramMotionEvent.getY());
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("GLGestureListener", 2, new Object[] { "", "CameraFocusGesture isRecording == false" });
      break;
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      this.jdField_a_of_type_Float = paramMotionEvent.getX(1);
      this.jdField_b_of_type_Float = paramMotionEvent.getY(1);
      return false;
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      this.jdField_c_of_type_Float = paramMotionEvent.getX(1);
      this.jdField_d_of_type_Float = paramMotionEvent.getY(1);
    } while ((a(this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, this.jdField_c_of_type_Float, this.jdField_d_of_type_Float)) || (!a(this.jdField_a_of_type_Long, this.jdField_b_of_type_Long)));
    paramMotionEvent = GLGestureProxy.getInstance().getSecendFingerMotionEvent(paramMotionEvent);
    if ((localGLSurfaceView != null) && ((localGLSurfaceView instanceof CameraCaptureView)) && (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoCameraFocusView != null) && (((CameraCaptureView)localGLSurfaceView).a() != 1))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoCameraFocusView.a(paramMotionEvent);
      a((CameraCaptureView)localGLSurfaceView, paramMotionEvent.getX(), paramMotionEvent.getY());
      if (QLog.isColorLevel()) {
        QLog.d("GLGestureListener", 2, new Object[] { "", "CameraFocusGesture isRecording == true" });
      }
    }
    paramMotionEvent.recycle();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     auth
 * JD-Core Version:    0.7.0.1
 */