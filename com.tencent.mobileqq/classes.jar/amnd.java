import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.utils.QQCustomDialog;
import cooperation.qlink.QQProxyForQlink;

public class amnd
  extends BroadcastReceiver
{
  public amnd(QQProxyForQlink paramQQProxyForQlink) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (("com.tencent.qlink.finishworkingdlg".equalsIgnoreCase(paramIntent.getAction())) && (QQProxyForQlink.a(this.a) != null))
    {
      QQProxyForQlink.a(this.a).dismiss();
      QQProxyForQlink.a(this.a, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amnd
 * JD-Core Version:    0.7.0.1
 */