import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.Login;

public class bglk
  extends BroadcastReceiver
{
  public bglk(Login paramLogin) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    QLog.d("Login", 1, "AutoLoginReceiver onReceive");
    Login.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bglk
 * JD-Core Version:    0.7.0.1
 */