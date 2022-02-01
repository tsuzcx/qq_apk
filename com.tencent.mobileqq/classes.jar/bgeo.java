import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.upgrade.activity.UpgradeActivity;

public class bgeo
  implements DialogInterface.OnClickListener
{
  public bgeo(UpgradeActivity paramUpgradeActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    UpgradeActivity.a(this.a, true);
    bcst.b(this.a.app, "CliOper", "", "", "0X8004DA1", "0X8004DA1", 0, 0, bgds.b(), String.valueOf(0), bgdt.a(), "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgeo
 * JD-Core Version:    0.7.0.1
 */