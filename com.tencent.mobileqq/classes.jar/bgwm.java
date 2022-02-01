import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.upgrade.activity.UpgradeActivity;

public class bgwm
  implements DialogInterface.OnClickListener
{
  public bgwm(UpgradeActivity paramUpgradeActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    bjko.b("qqBaseActivity", bjhp.a(10010, 1, 2, 200));
    bjhn.a().a(17, bjhp.a(10010, 1, 2, 200));
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgwm
 * JD-Core Version:    0.7.0.1
 */