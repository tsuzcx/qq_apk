import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.upgrade.activity.UpgradeActivity;

public class bgww
  implements DialogInterface.OnClickListener
{
  public bgww(UpgradeActivity paramUpgradeActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    bdla.b(this.a.app, "CliOper", "", "", "0X800417F", "0X800417F", 0, 0, "", "", "", "");
    if (UpgradeActivity.a(this.a)) {
      bdla.b(this.a.app, "CliOper", "", "", "0X800714D", "0X800714D", 0, 0, "", "", "", "");
    }
    bdla.b(this.a.app, "CliOper", "", "", "0X8004DA2", "0X8004DA2", 0, 0, bgvw.b(), String.valueOf(2), bgvx.a(), "0");
    bgvx.a().a(this.a.app);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgww
 * JD-Core Version:    0.7.0.1
 */