import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import cooperation.qlink.QQProxyForQlink;

public class amnh
  implements DialogInterface.OnDismissListener
{
  public amnh(QQProxyForQlink paramQQProxyForQlink) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    QQProxyForQlink.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amnh
 * JD-Core Version:    0.7.0.1
 */