import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.upgrade.activity.UpgradeActivity;
import com.tencent.mobileqq.upgrade.activity.UpgradeActivity.15.1;
import mqq.os.MqqHandler;

public class bgwn
  implements DialogInterface.OnClickListener
{
  public bgwn(UpgradeActivity paramUpgradeActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    bjko.b("qqBaseActivity", bjhp.a(10010, 1, 3, 200));
    bjhn.a().a(17, bjhp.a(10010, 1, 3, 200));
    if (!bjnn.a().b()) {
      bjkv.a().a(anvx.a(2131715273));
    }
    for (;;)
    {
      ThreadManager.getSubThreadHandler().postDelayed(new UpgradeActivity.15.1(this), 500L);
      return;
      bgvp.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgwn
 * JD-Core Version:    0.7.0.1
 */