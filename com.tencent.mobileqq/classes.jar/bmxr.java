import android.view.MotionEvent;
import com.tencent.biz.qqstory.takevideo.CameraFocusView;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView;
import dov.com.qq.im.ae.camera.core.AECameraManager;

class bmxr
  implements bbha
{
  bmxr(bmxa parambmxa) {}
  
  public void a(MotionEvent paramMotionEvent)
  {
    bmxa.a(this.a);
    if ((this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoCameraFocusView != null) && (!this.a.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager.isFrontCamera()))
    {
      this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoCameraFocusView.a(paramMotionEvent);
      this.a.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager.requestCameraFocus(paramMotionEvent.getX(), paramMotionEvent.getY(), this.a.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.getSurfaceWidth(), this.a.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.getSurfaceHeight());
      if (QLog.isColorLevel()) {
        QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, new Object[] { "", "CameraFocusGesture isRecording == false" });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmxr
 * JD-Core Version:    0.7.0.1
 */