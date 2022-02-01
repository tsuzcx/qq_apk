import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.upgrade.activity.UpgradeActivity;
import com.tencent.mobileqq.upgrade.activity.UpgradeActivity.15.1;
import mqq.os.MqqHandler;

public class bhek
  implements DialogInterface.OnClickListener
{
  public bhek(UpgradeActivity paramUpgradeActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    bjtx.b("qqBaseActivity", bjqy.a(10010, 1, 3, 200));
    bjqw.a().a(17, bjqy.a(10010, 1, 3, 200));
    if (!bjxd.a().b()) {
      bjuh.a().a(anzj.a(2131714691));
    }
    for (;;)
    {
      ThreadManager.getSubThreadHandler().postDelayed(new UpgradeActivity.15.1(this), 500L);
      return;
      bhdm.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhek
 * JD-Core Version:    0.7.0.1
 */