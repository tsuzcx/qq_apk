import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.onlinestatus.AccountOnlineStateActivity;

public class azfm
  implements DialogInterface.OnClickListener
{
  public azfm(AccountOnlineStateActivity paramAccountOnlineStateActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    azir.a("0X800AF9C", 1);
    paramDialogInterface.dismiss();
    AccountOnlineStateActivity.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azfm
 * JD-Core Version:    0.7.0.1
 */