import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;

class bihh
  extends BroadcastReceiver
{
  bihh(bihg parambihg) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (QLog.isColorLevel()) {
      QLog.d("QIMStoryEffectCameraCaptureUnit", 2, new Object[] { "onReceive action=", paramContext });
    }
    if ("dov.com.qq.im.finish_capture_action".equals(paramContext)) {
      bihg.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bihh
 * JD-Core Version:    0.7.0.1
 */