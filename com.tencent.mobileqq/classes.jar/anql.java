import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.QIMCameraCaptureUnit;
import dov.com.qq.im.setting.ICameraEntrance;
import dov.com.qq.im.setting.IQIMCameraContainer;

public class anql
  extends BroadcastReceiver
{
  public anql(QIMCameraCaptureUnit paramQIMCameraCaptureUnit) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = this.a.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a();
    if ((paramContext == null) || (paramContext.isFinishing()) || (QIMCameraCaptureUnit.a(this.a))) {}
    while (!"tencent.av.v2q.StartVideoChat".equals(paramIntent.getAction())) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("VERSION_CODES", 2, "receive ACTION_START_VIDEO_CHAT.");
    }
    this.a.h();
    this.a.jdField_a_of_type_DovComQqImSettingICameraEntrance.a(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anql
 * JD-Core Version:    0.7.0.1
 */