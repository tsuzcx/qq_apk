import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import cooperation.qlink.QQProxyForQlink;

public class amus
  implements DialogInterface.OnDismissListener
{
  public amus(QQProxyForQlink paramQQProxyForQlink) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    QQProxyForQlink.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amus
 * JD-Core Version:    0.7.0.1
 */