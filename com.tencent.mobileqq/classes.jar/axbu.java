import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

class axbu
  extends BroadcastReceiver
{
  axbu(axbt paramaxbt) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (axbt.jdField_a_of_type_Boolean != true)
    {
      QLog.e("CliNotifyPush", 1, "receiver broadcast late");
      axbt.a(this.a, 2013);
      return;
    }
    axbt.jdField_a_of_type_Boolean = false;
    if (paramIntent != null)
    {
      axbt.a(this.a, paramIntent.getIntExtra("param_ret", 0));
      long l = paramIntent.getLongExtra("param_uin", 10000L);
      QLog.e("CliNotifyPush", 1, "receive broadcast from qzone, uin=" + l + " param_ret=" + axbt.a(this.a));
      if ((axbt.a(this.a) != 0) && (axbt.a(this.a) != 10000)) {
        break label216;
      }
      if (l != this.a.getAppRuntime().getLongAccountUin()) {
        break label194;
      }
      axbt.jdField_a_of_type_Int = 0;
      axbt.b = 0;
    }
    for (;;)
    {
      paramContext = (QQAppInterface)this.a.getAppRuntime();
      if (paramContext == null) {
        break;
      }
      paramContext.getHandler(axbt.class).removeCallbacks(axbt.a(this.a));
      paramContext.getHandler(axbt.class).post(axbt.a(this.a));
      return;
      label194:
      axbt.a(this.a, 3001);
      axbt.jdField_a_of_type_Int += 1;
      continue;
      label216:
      axbt.jdField_a_of_type_Int += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     axbu
 * JD-Core Version:    0.7.0.1
 */