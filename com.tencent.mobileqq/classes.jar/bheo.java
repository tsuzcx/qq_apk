import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.upgrade.activity.UpgradeActivity;

public class bheo
  implements DialogInterface.OnClickListener
{
  public bheo(UpgradeActivity paramUpgradeActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    bdll.b(this.a.app, "CliOper", "", "", "0X8004DA2", "0X8004DA2", 0, 0, bhdt.b(), String.valueOf(0), bhdu.a(), "0");
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bheo
 * JD-Core Version:    0.7.0.1
 */