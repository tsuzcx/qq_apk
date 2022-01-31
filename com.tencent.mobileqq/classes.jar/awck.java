import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

class awck
  extends BroadcastReceiver
{
  awck(awcj paramawcj) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (awcj.jdField_a_of_type_Boolean != true)
    {
      QLog.e("CliNotifyPush", 1, "receiver broadcast late");
      awcj.a(this.a, 2013);
      return;
    }
    awcj.jdField_a_of_type_Boolean = false;
    if (paramIntent != null)
    {
      awcj.a(this.a, paramIntent.getIntExtra("param_ret", 0));
      long l = paramIntent.getLongExtra("param_uin", 10000L);
      QLog.e("CliNotifyPush", 1, "receive broadcast from qzone, uin=" + l + " param_ret=" + awcj.a(this.a));
      if ((awcj.a(this.a) != 0) && (awcj.a(this.a) != 10000)) {
        break label216;
      }
      if (l != this.a.getAppRuntime().getLongAccountUin()) {
        break label194;
      }
      awcj.jdField_a_of_type_Int = 0;
      awcj.b = 0;
    }
    for (;;)
    {
      paramContext = (QQAppInterface)this.a.getAppRuntime();
      if (paramContext == null) {
        break;
      }
      paramContext.getHandler(awcj.class).removeCallbacks(awcj.a(this.a));
      paramContext.getHandler(awcj.class).post(awcj.a(this.a));
      return;
      label194:
      awcj.a(this.a, 3001);
      awcj.jdField_a_of_type_Int += 1;
      continue;
      label216:
      awcj.jdField_a_of_type_Int += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     awck
 * JD-Core Version:    0.7.0.1
 */