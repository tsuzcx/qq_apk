import android.os.MessageQueue.IdleHandler;
import android.widget.Button;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraCompatibleList;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.activity.richmedia.FlowCameraActivity2;
import dov.com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import dov.com.tencent.mobileqq.activity.richmedia.view.CameraGLSurfaceView;

public class anpu
  implements MessageQueue.IdleHandler
{
  public anpu(FlowCameraActivity2 paramFlowCameraActivity2) {}
  
  public boolean queueIdle()
  {
    if (CameraCompatibleList.d(CameraCompatibleList.b)) {
      this.a.b(true);
    }
    for (;;)
    {
      if ((this.a.g) && (this.a.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView != null)) {
        this.a.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView.onResume();
      }
      this.a.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a();
      this.a.c.setEnabled(false);
      if (QLog.isColorLevel()) {
        QLog.i("PEAK_CAMERA", 2, "Added camera view.");
      }
      return false;
      this.a.g();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anpu
 * JD-Core Version:    0.7.0.1
 */