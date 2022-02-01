import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.upgrade.activity.UpgradeActivity;

public class bgws
  implements DialogInterface.OnClickListener
{
  public bgws(UpgradeActivity paramUpgradeActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    UpgradeActivity.a(this.a, true);
    bdla.b(this.a.app, "CliOper", "", "", "0X8004DA1", "0X8004DA1", 0, 0, bgvw.b(), String.valueOf(0), bgvx.a(), "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgws
 * JD-Core Version:    0.7.0.1
 */