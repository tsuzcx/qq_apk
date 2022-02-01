import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.profile.VipProfileCardBaseActivity;

public class azsc
  implements DialogInterface.OnClickListener
{
  public azsc(VipProfileCardBaseActivity paramVipProfileCardBaseActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.e();
    this.a.g();
    bdla.b(this.a.app, "P_CliOper", "Vip_SummaryCard", "", "SummaryCard", "CLICK_VIPOPENSERVICE", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azsc
 * JD-Core Version:    0.7.0.1
 */