import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.QIMStoryEffectCameraCaptureUnit;
import dov.com.qq.im.setting.IQIMCameraContainer;

public class ankg
  extends BroadcastReceiver
{
  public ankg(QIMStoryEffectCameraCaptureUnit paramQIMStoryEffectCameraCaptureUnit) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (QLog.isColorLevel()) {
      QLog.d("QIMStoryEffectCameraCaptureUnit", 2, new Object[] { "onReceive action=", paramContext });
    }
    if ("dov.com.qq.im.finish_capture_action".equals(paramContext)) {
      this.a.a.a().finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ankg
 * JD-Core Version:    0.7.0.1
 */