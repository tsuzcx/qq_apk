import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;
import cooperation.qlink.QlAndQQInterface.WorkState;

class bisr
  extends BroadcastReceiver
{
  bisr(bisq parambisq) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext == null) {}
    while ((!paramContext.equals("mqq.intent.action.ACCOUNT_CHANGED")) && (!paramContext.equals("mqq.intent.action.ACCOUNT_KICKED")) && (!paramContext.equals("mqq.intent.action.ACCOUNT_EXPIRED")) && (!paramContext.equals("mqq.intent.action.LOGOUT"))) {
      return;
    }
    QLog.w("QQProxyForQlink", 1, "receive qqAccountbroacast action=" + paramContext);
    bisq.a(this.a, new QlAndQQInterface.WorkState(false, 1, null, null, 0, 0, false));
    bisq.c(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bisr
 * JD-Core Version:    0.7.0.1
 */