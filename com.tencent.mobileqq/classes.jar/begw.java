import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.qqconnect.wtlogin.Login;

public class begw
  implements DialogInterface.OnDismissListener
{
  public begw(Login paramLogin) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    Login.a(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     begw
 * JD-Core Version:    0.7.0.1
 */