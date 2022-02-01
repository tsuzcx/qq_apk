import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.upgrade.activity.UpgradeActivity;

public class bhes
  implements DialogInterface.OnClickListener
{
  public bhes(UpgradeActivity paramUpgradeActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    UpgradeActivity.a(this.a, false);
    bdll.b(this.a.app, "CliOper", "", "", "0X8004DA1", "0X8004DA1", 0, 0, bhdt.b(), String.valueOf(0), bhdu.a(), "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhes
 * JD-Core Version:    0.7.0.1
 */