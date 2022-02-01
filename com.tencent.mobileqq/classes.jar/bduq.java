import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.studymode.KidModeAdvanceSettingFragment;
import com.tencent.mobileqq.widget.FormMultiLineSwitchItem;

public class bduq
  implements DialogInterface.OnClickListener
{
  public bduq(KidModeAdvanceSettingFragment paramKidModeAdvanceSettingFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    KidModeAdvanceSettingFragment.b(this.a, true);
    KidModeAdvanceSettingFragment.a(this.a).setEnabled(true);
    KidModeAdvanceSettingFragment.a(this.a, KidModeAdvanceSettingFragment.a(this.a), false, KidModeAdvanceSettingFragment.a(this.a));
    ajco.a(this.a.getActivity(), KidModeAdvanceSettingFragment.a(this.a), bdvn.b(), 2002);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bduq
 * JD-Core Version:    0.7.0.1
 */