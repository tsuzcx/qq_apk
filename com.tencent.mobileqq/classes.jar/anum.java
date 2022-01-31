import android.os.Build.VERSION;
import android.os.MessageQueue.IdleHandler;
import android.view.WindowManager.BadTokenException;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.mobileqq.activity.richmedia.view.CameraGLSurfaceView;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarRecordActivity;
import com.tencent.qphone.base.util.QLog;

public class anum
  implements MessageQueue.IdleHandler
{
  public anum(DynamicAvatarRecordActivity paramDynamicAvatarRecordActivity) {}
  
  public boolean queueIdle()
  {
    if (azhf.d(azhf.b)) {
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
        this.a.jdField_a_of_type_Bdjz = bdgm.a(this.a, 230).setMessage(alud.a(2131703960)).setPositiveButton(this.a.getString(2131694207), new anun(this));
      }
      try
      {
        this.a.jdField_a_of_type_Bdjz.setCancelable(false);
        this.a.jdField_a_of_type_Bdjz.show();
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
 * Qualified Name:     anum
 * JD-Core Version:    0.7.0.1
 */