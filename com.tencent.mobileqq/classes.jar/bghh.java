import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;

public class bghh
  extends BroadcastReceiver
{
  public bghh(OpenSDKAppInterface paramOpenSDKAppInterface) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (QLog.isColorLevel()) {
      QLog.i("OpenSDKAppInterface", 2, "onReceive: invoked.  intent: " + paramIntent + " action: " + paramContext);
    }
    if ((paramContext != null) && (paramContext.equals("mqq.intent.action.ACCOUNT_KICKED"))) {
      OpenSDKAppInterface.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bghh
 * JD-Core Version:    0.7.0.1
 */