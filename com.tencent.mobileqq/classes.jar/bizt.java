import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;

class bizt
  extends BroadcastReceiver
{
  bizt(bizq parambizq) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null)
    {
      QLog.d("Q.quicklogin.OpenSdkQIPCClient", 1, "mPuzzleVerifyCodeReceiver onReceive null == oldIntent");
      return;
    }
    QLog.d("Q.quicklogin.OpenSdkQIPCClient", 1, "mPuzzleVerifyCodeReceiver onReceive");
    bjhh.a(paramIntent, paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bizt
 * JD-Core Version:    0.7.0.1
 */