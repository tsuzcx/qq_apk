import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.upgrade.activity.UpgradeActivity;

public class bgwu
  implements DialogInterface.OnClickListener
{
  public bgwu(UpgradeActivity paramUpgradeActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    bdla.b(this.a.app, "CliOper", "", "", "0X8004DA2", "0X8004DA2", 0, 0, bgvw.b(), String.valueOf(0), bgvx.a(), "0");
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgwu
 * JD-Core Version:    0.7.0.1
 */