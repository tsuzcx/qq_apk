import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;

class bihy
  extends BroadcastReceiver
{
  bihy(bihx parambihx) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (QLog.isColorLevel()) {
      QLog.d("QIMStoryEffectCameraCaptureUnit", 2, new Object[] { "onReceive action=", paramContext });
    }
    if ("dov.com.qq.im.finish_capture_action".equals(paramContext)) {
      bihx.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bihy
 * JD-Core Version:    0.7.0.1
 */