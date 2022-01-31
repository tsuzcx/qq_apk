import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

class axbs
  extends BroadcastReceiver
{
  axbs(axbr paramaxbr) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (axbr.jdField_a_of_type_Boolean != true)
    {
      QLog.e("CliNotifyPush", 1, "receiver broadcast late");
      axbr.a(this.a, 2013);
      return;
    }
    axbr.jdField_a_of_type_Boolean = false;
    if (paramIntent != null)
    {
      axbr.a(this.a, paramIntent.getIntExtra("param_ret", 0));
      long l = paramIntent.getLongExtra("param_uin", 10000L);
      QLog.e("CliNotifyPush", 1, "receive broadcast from qzone, uin=" + l + " param_ret=" + axbr.a(this.a));
      if ((axbr.a(this.a) != 0) && (axbr.a(this.a) != 10000)) {
        break label216;
      }
      if (l != this.a.getAppRuntime().getLongAccountUin()) {
        break label194;
      }
      axbr.jdField_a_of_type_Int = 0;
      axbr.b = 0;
    }
    for (;;)
    {
      paramContext = (QQAppInterface)this.a.getAppRuntime();
      if (paramContext == null) {
        break;
      }
      paramContext.getHandler(axbr.class).removeCallbacks(axbr.a(this.a));
      paramContext.getHandler(axbr.class).post(axbr.a(this.a));
      return;
      label194:
      axbr.a(this.a, 3001);
      axbr.jdField_a_of_type_Int += 1;
      continue;
      label216:
      axbr.jdField_a_of_type_Int += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     axbs
 * JD-Core Version:    0.7.0.1
 */