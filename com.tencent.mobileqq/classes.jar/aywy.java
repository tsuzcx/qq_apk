import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

class aywy
  extends BroadcastReceiver
{
  aywy(aywx paramaywx) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (aywx.jdField_a_of_type_Boolean != true)
    {
      QLog.e("CliNotifyPush", 1, "receiver broadcast late");
      aywx.a(this.a, 2013);
      return;
    }
    aywx.jdField_a_of_type_Boolean = false;
    if (paramIntent != null)
    {
      aywx.a(this.a, paramIntent.getIntExtra("param_ret", 0));
      long l = paramIntent.getLongExtra("param_uin", 10000L);
      QLog.e("CliNotifyPush", 1, "receive broadcast from qzone, uin=" + l + " param_ret=" + aywx.a(this.a));
      if ((aywx.a(this.a) != 0) && (aywx.a(this.a) != 10000)) {
        break label216;
      }
      if (l != this.a.getAppRuntime().getLongAccountUin()) {
        break label194;
      }
      aywx.jdField_a_of_type_Int = 0;
      aywx.b = 0;
    }
    for (;;)
    {
      paramContext = (QQAppInterface)this.a.getAppRuntime();
      if (paramContext == null) {
        break;
      }
      paramContext.getHandler(aywx.class).removeCallbacks(aywx.a(this.a));
      paramContext.getHandler(aywx.class).post(aywx.a(this.a));
      return;
      label194:
      aywx.a(this.a, 3001);
      aywx.jdField_a_of_type_Int += 1;
      continue;
      label216:
      aywx.jdField_a_of_type_Int += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aywy
 * JD-Core Version:    0.7.0.1
 */