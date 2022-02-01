import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.upgrade.activity.UpgradeActivity;

public class bheg
  implements DialogInterface.OnClickListener
{
  public bheg(UpgradeActivity paramUpgradeActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    UpgradeActivity.a(this.a);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bheg
 * JD-Core Version:    0.7.0.1
 */