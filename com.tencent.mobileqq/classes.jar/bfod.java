import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.upgrade.activity.UpgradeActivity;

public class bfod
  implements DialogInterface.OnClickListener
{
  public bfod(UpgradeActivity paramUpgradeActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    bcef.b(this.a.app, "CliOper", "", "", "0X8004DA2", "0X8004DA2", 0, 0, bfnf.b(), String.valueOf(0), bfng.a(), "0");
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfod
 * JD-Core Version:    0.7.0.1
 */