import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.qqconnect.wtlogin.Login;

public class bktp
  implements DialogInterface.OnDismissListener
{
  public bktp(Login paramLogin) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    Login.b(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bktp
 * JD-Core Version:    0.7.0.1
 */