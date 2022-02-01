import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.qqconnect.wtlogin.Login;

public class bkjy
  implements DialogInterface.OnDismissListener
{
  public bkjy(Login paramLogin) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    Login.b(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkjy
 * JD-Core Version:    0.7.0.1
 */