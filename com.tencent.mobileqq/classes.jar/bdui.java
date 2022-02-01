import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mobileqq.studymode.KidModeAdvanceSettingFragment;
import com.tencent.mobileqq.widget.FormMultiLineSwitchItem;

public class bdui
  implements DialogInterface.OnCancelListener
{
  public bdui(KidModeAdvanceSettingFragment paramKidModeAdvanceSettingFragment) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    paramDialogInterface.dismiss();
    KidModeAdvanceSettingFragment.a(this.a).setEnabled(true);
    KidModeAdvanceSettingFragment.a(this.a, KidModeAdvanceSettingFragment.a(this.a), false, KidModeAdvanceSettingFragment.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdui
 * JD-Core Version:    0.7.0.1
 */