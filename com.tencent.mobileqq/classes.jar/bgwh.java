import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;
import com.tencent.mobileqq.upgrade.activity.UpgradeActivity;

public class bgwh
  implements DialogInterface.OnKeyListener
{
  public bgwh(UpgradeActivity paramUpgradeActivity) {}
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4) {
      this.a.a();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgwh
 * JD-Core Version:    0.7.0.1
 */