import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.upgrade.activity.UpgradeActivity;

public class bhet
  implements DialogInterface.OnClickListener
{
  public bhet(UpgradeActivity paramUpgradeActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    bdll.b(this.a.app, "CliOper", "", "", "0X800417F", "0X800417F", 0, 0, "", "", "", "");
    if (UpgradeActivity.a(this.a)) {
      bdll.b(this.a.app, "CliOper", "", "", "0X800714D", "0X800714D", 0, 0, "", "", "", "");
    }
    bdll.b(this.a.app, "CliOper", "", "", "0X8004DA2", "0X8004DA2", 0, 0, bhdt.b(), String.valueOf(2), bhdu.a(), "0");
    bhdu.a().a(this.a.app);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhet
 * JD-Core Version:    0.7.0.1
 */