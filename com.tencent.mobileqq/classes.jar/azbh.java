import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

class azbh
  extends BroadcastReceiver
{
  azbh(azbg paramazbg) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (azbg.jdField_a_of_type_Boolean != true)
    {
      QLog.e("CliNotifyPush", 1, "receiver broadcast late");
      azbg.a(this.a, 2013);
      return;
    }
    azbg.jdField_a_of_type_Boolean = false;
    if (paramIntent != null)
    {
      azbg.a(this.a, paramIntent.getIntExtra("param_ret", 0));
      long l = paramIntent.getLongExtra("param_uin", 10000L);
      QLog.e("CliNotifyPush", 1, "receive broadcast from qzone, uin=" + l + " param_ret=" + azbg.a(this.a));
      if ((azbg.a(this.a) != 0) && (azbg.a(this.a) != 10000)) {
        break label216;
      }
      if (l != this.a.getAppRuntime().getLongAccountUin()) {
        break label194;
      }
      azbg.jdField_a_of_type_Int = 0;
      azbg.b = 0;
    }
    for (;;)
    {
      paramContext = (QQAppInterface)this.a.getAppRuntime();
      if (paramContext == null) {
        break;
      }
      paramContext.getHandler(azbg.class).removeCallbacks(azbg.a(this.a));
      paramContext.getHandler(azbg.class).post(azbg.a(this.a));
      return;
      label194:
      azbg.a(this.a, 3001);
      azbg.jdField_a_of_type_Int += 1;
      continue;
      label216:
      azbg.jdField_a_of_type_Int += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azbh
 * JD-Core Version:    0.7.0.1
 */