import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;

public class bdco
  implements DialogInterface.OnClickListener
{
  public bdco(OpenSDKAppInterface paramOpenSDKAppInterface) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bdco
 * JD-Core Version:    0.7.0.1
 */