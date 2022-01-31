import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.conditionsearch.LocationSelectActivity;
import com.tencent.mobileqq.conditionsearch.data.BaseAddress;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.widget.MultiImageTextView;

public class ammq
  implements DialogInterface.OnDismissListener
{
  public ammq(LocationSelectActivity paramLocationSelectActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    LocationSelectActivity.a(this.a).setRightTextColor(2);
    if (AppSetting.d)
    {
      LocationSelectActivity.b(this.a).setContentDescription(ajya.a(2131706309) + LocationSelectActivity.a(this.a).name);
      LocationSelectActivity.a(this.a).setContentDescription(ajya.a(2131706307) + LocationSelectActivity.a(this.a).a().getText());
    }
    paramDialogInterface = LocationSelectActivity.a(this.a);
    if (LocationSelectActivity.a(this.a) == 0)
    {
      axqy.b(this.a.app, "CliOper", "", "", "0X8004248", "0X8004248", 0, 0, paramDialogInterface[0], paramDialogInterface[1], paramDialogInterface[2], "");
      return;
    }
    axqy.b(this.a.app, "CliOper", "", "", "0X800424A", "0X800424A", 0, 0, paramDialogInterface[0], paramDialogInterface[1], paramDialogInterface[2], "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ammq
 * JD-Core Version:    0.7.0.1
 */