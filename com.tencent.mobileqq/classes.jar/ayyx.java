import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.onlinestatus.AccountOnlineStateActivity;

public class ayyx
  implements DialogInterface.OnClickListener
{
  public ayyx(AccountOnlineStateActivity paramAccountOnlineStateActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    azcl.a("0X800AF9C", 2);
    paramDialogInterface.dismiss();
    AccountOnlineStateActivity.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayyx
 * JD-Core Version:    0.7.0.1
 */