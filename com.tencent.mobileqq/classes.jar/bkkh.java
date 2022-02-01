import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.Login;

public class bkkh
  extends BroadcastReceiver
{
  public bkkh(Login paramLogin) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null)
    {
      QLog.d("Login", 1, "mPuzzleVerifyCodeReceiver onReceive null == oldIntent");
      return;
    }
    QLog.d("Login", 1, "mPuzzleVerifyCodeReceiver onReceive");
    bjhh.a(paramIntent, paramContext);
    this.a.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkkh
 * JD-Core Version:    0.7.0.1
 */