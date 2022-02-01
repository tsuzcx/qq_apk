import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.Login;

public class bktr
  extends BroadcastReceiver
{
  public bktr(Login paramLogin) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null)
    {
      QLog.d("Login", 1, "mPuzzleVerifyCodeReceiver onReceive null == oldIntent");
      return;
    }
    QLog.d("Login", 1, "mPuzzleVerifyCodeReceiver onReceive");
    paramContext = new Intent(paramIntent);
    paramContext.setClass(this.a, QQBrowserActivity.class);
    paramContext.setAction("android.intent.action.VIEW");
    paramContext.putExtra("process", "com.tencent.mobileqq:openSdk");
    paramContext.setData(Uri.parse("mqqverifycode://puzzle_verify_code/PUZZLEVERIFYCODE?"));
    this.a.startActivity(paramContext);
    this.a.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bktr
 * JD-Core Version:    0.7.0.1
 */