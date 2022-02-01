import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.upgrade.activity.UpgradeActivity;
import com.tencent.mobileqq.upgrade.activity.UpgradeActivity.15.1;
import mqq.os.MqqHandler;

public class bgej
  implements DialogInterface.OnClickListener
{
  public bgej(UpgradeActivity paramUpgradeActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    bisy.b("qqBaseActivity", bipz.a(10010, 1, 3, 200));
    bipx.a().a(17, bipz.a(10010, 1, 3, 200));
    if (!biwe.a().b()) {
      biti.a().a(anni.a(2131714582));
    }
    for (;;)
    {
      ThreadManager.getSubThreadHandler().postDelayed(new UpgradeActivity.15.1(this), 500L);
      return;
      bgdl.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgej
 * JD-Core Version:    0.7.0.1
 */