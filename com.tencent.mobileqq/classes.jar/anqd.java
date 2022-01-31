import android.os.Build.VERSION;
import android.os.MessageQueue.IdleHandler;
import android.view.WindowManager.BadTokenException;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.mobileqq.activity.richmedia.view.CameraGLSurfaceView;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarRecordActivity;
import com.tencent.qphone.base.util.QLog;

public class anqd
  implements MessageQueue.IdleHandler
{
  public anqd(DynamicAvatarRecordActivity paramDynamicAvatarRecordActivity) {}
  
  public boolean queueIdle()
  {
    if (azcw.d(azcw.b)) {
      this.a.a(true);
    }
    for (;;)
    {
      if (this.a.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView.onResume();
      }
      this.a.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a();
      DynamicAvatarRecordActivity.a(this.a);
      if (Build.VERSION.SDK_INT < 14) {
        this.a.jdField_a_of_type_Bdfq = bdcd.a(this.a, 230).setMessage(alpo.a(2131703948)).setPositiveButton(this.a.getString(2131694205), new anqe(this));
      }
      try
      {
        this.a.jdField_a_of_type_Bdfq.setCancelable(false);
        this.a.jdField_a_of_type_Bdfq.show();
        if (QLog.isColorLevel()) {
          QLog.i("PEAK_CAMERA", 2, "Added camera view.");
        }
        return false;
        this.a.a(false);
      }
      catch (WindowManager.BadTokenException localBadTokenException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.i("DynamicAvatarRecordActivity", 2, "", localBadTokenException);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anqd
 * JD-Core Version:    0.7.0.1
 */