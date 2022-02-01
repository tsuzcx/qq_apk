import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.upgrade.activity.UpgradeActivity;

public class bhep
  implements DialogInterface.OnClickListener
{
  public bhep(UpgradeActivity paramUpgradeActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    UpgradeActivity.a(this.a, true);
    bdll.b(this.a.app, "CliOper", "", "", "0X8004DA1", "0X8004DA1", 0, 0, bhdt.b(), String.valueOf(0), bhdu.a(), "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhep
 * JD-Core Version:    0.7.0.1
 */