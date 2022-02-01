import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.upgrade.activity.UpgradeActivity;

public class bfob
  implements DialogInterface.OnClickListener
{
  public bfob(UpgradeActivity paramUpgradeActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    UpgradeActivity.a(this.a, true);
    bcef.b(this.a.app, "CliOper", "", "", "0X8004DA1", "0X8004DA1", 0, 0, bfnf.b(), String.valueOf(0), bfng.a(), "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfob
 * JD-Core Version:    0.7.0.1
 */