import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.QQBroadcastReceiver;

public class awcf
  extends QQBroadcastReceiver
{
  public awcf(ScanTorchActivity paramScanTorchActivity) {}
  
  public void onReceive(AppRuntime paramAppRuntime, Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {}
    do
    {
      return;
      paramAppRuntime = paramIntent.getAction();
      if (QLog.isColorLevel()) {
        QLog.d("ScanTorchActivity", 2, new Object[] { "onReceive, action=", paramAppRuntime });
      }
    } while (!"com.tencent.mobileqq__alive".equals(paramAppRuntime));
    ScanTorchActivity.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awcf
 * JD-Core Version:    0.7.0.1
 */