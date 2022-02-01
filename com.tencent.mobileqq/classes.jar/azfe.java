import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.onlinestatus.AccountOnlineStateActivity;

public class azfe
  implements DialogInterface.OnClickListener
{
  public azfe(AccountOnlineStateActivity paramAccountOnlineStateActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    azir.a("0X800AF9C", 2);
    paramDialogInterface.dismiss();
    AccountOnlineStateActivity.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azfe
 * JD-Core Version:    0.7.0.1
 */