import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.upgrade.activity.UpgradeActivity;

public class bheu
  implements DialogInterface.OnClickListener
{
  public bheu(UpgradeActivity paramUpgradeActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    bdll.b(this.a.app, "CliOper", "", "", "0X800417E", "0X800417E", 0, 0, "", "", "", "");
    if (UpgradeActivity.a(this.a)) {
      bdll.b(this.a.app, "CliOper", "", "", "0X800714C", "0X800714C", 0, 0, "", "", "", "");
    }
    UpgradeActivity.a(this.a, false);
    bdll.b(this.a.app, "CliOper", "", "", "0X8004DA1", "0X8004DA1", 0, 0, bhdt.b(), String.valueOf(2), bhdu.a(), "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bheu
 * JD-Core Version:    0.7.0.1
 */