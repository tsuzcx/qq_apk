import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.conditionsearch.LocationSelectActivity;
import com.tencent.mobileqq.conditionsearch.data.BaseAddress;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.widget.MultiImageTextView;

public class aohx
  implements DialogInterface.OnDismissListener
{
  public aohx(LocationSelectActivity paramLocationSelectActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    LocationSelectActivity.a(this.a).setRightTextColor(2);
    if (AppSetting.c)
    {
      LocationSelectActivity.b(this.a).setContentDescription(alud.a(2131706693) + LocationSelectActivity.a(this.a).name);
      LocationSelectActivity.a(this.a).setContentDescription(alud.a(2131706691) + LocationSelectActivity.a(this.a).a().getText());
    }
    paramDialogInterface = LocationSelectActivity.a(this.a);
    if (LocationSelectActivity.a(this.a) == 0)
    {
      azqs.b(this.a.app, "CliOper", "", "", "0X8004248", "0X8004248", 0, 0, paramDialogInterface[0], paramDialogInterface[1], paramDialogInterface[2], "");
      return;
    }
    azqs.b(this.a.app, "CliOper", "", "", "0X800424A", "0X800424A", 0, 0, paramDialogInterface[0], paramDialogInterface[1], paramDialogInterface[2], "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aohx
 * JD-Core Version:    0.7.0.1
 */