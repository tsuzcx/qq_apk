import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.studymode.KidModeAdvanceSettingFragment;
import com.tencent.mobileqq.widget.FormMultiLineSwitchItem;

public class bcnr
  implements DialogInterface.OnClickListener
{
  public bcnr(KidModeAdvanceSettingFragment paramKidModeAdvanceSettingFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    KidModeAdvanceSettingFragment.b(this.a, true);
    KidModeAdvanceSettingFragment.a(this.a).setEnabled(true);
    KidModeAdvanceSettingFragment.a(this.a, KidModeAdvanceSettingFragment.a(this.a), false, KidModeAdvanceSettingFragment.a(this.a));
    aihp.a(this.a.getActivity(), KidModeAdvanceSettingFragment.a(this.a), bcoo.b(), 2002);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcnr
 * JD-Core Version:    0.7.0.1
 */