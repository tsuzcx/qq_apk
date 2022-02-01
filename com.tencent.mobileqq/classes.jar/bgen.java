import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.upgrade.activity.UpgradeActivity;

public class bgen
  implements DialogInterface.OnClickListener
{
  public bgen(UpgradeActivity paramUpgradeActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    bcst.b(this.a.app, "CliOper", "", "", "0X8004DA2", "0X8004DA2", 0, 0, bgds.b(), String.valueOf(0), bgdt.a(), "0");
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgen
 * JD-Core Version:    0.7.0.1
 */