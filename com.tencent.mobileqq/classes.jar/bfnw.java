import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.upgrade.activity.UpgradeActivity;
import com.tencent.mobileqq.upgrade.activity.UpgradeActivity.15.1;
import mqq.os.MqqHandler;

public class bfnw
  implements DialogInterface.OnClickListener
{
  public bfnw(UpgradeActivity paramUpgradeActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    bhzm.b("qqBaseActivity", bhwn.a(10010, 1, 3, 200));
    bhwl.a().a(17, bhwn.a(10010, 1, 3, 200));
    if (!bicl.a().b()) {
      bhzt.a().a(amtj.a(2131714925));
    }
    for (;;)
    {
      ThreadManager.getSubThreadHandler().postDelayed(new UpgradeActivity.15.1(this), 500L);
      return;
      bfmy.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfnw
 * JD-Core Version:    0.7.0.1
 */