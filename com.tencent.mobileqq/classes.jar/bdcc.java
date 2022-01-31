import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qqconnect.wtlogin.Login;

public class bdcc
  implements DialogInterface.OnClickListener
{
  public bdcc(Login paramLogin) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bdcc
 * JD-Core Version:    0.7.0.1
 */