import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;

public class bgln
  implements DialogInterface.OnClickListener
{
  public bgln(OpenSDKAppInterface paramOpenSDKAppInterface) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bgln
 * JD-Core Version:    0.7.0.1
 */