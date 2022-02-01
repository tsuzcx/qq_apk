import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.upgrade.activity.UpgradeActivity;

public class bgwx
  implements DialogInterface.OnClickListener
{
  public bgwx(UpgradeActivity paramUpgradeActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    bdla.b(this.a.app, "CliOper", "", "", "0X800417E", "0X800417E", 0, 0, "", "", "", "");
    if (UpgradeActivity.a(this.a)) {
      bdla.b(this.a.app, "CliOper", "", "", "0X800714C", "0X800714C", 0, 0, "", "", "", "");
    }
    UpgradeActivity.a(this.a, false);
    bdla.b(this.a.app, "CliOper", "", "", "0X8004DA1", "0X8004DA1", 0, 0, bgvw.b(), String.valueOf(2), bgvx.a(), "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgwx
 * JD-Core Version:    0.7.0.1
 */