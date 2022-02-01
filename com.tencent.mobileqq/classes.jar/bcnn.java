import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.studymode.KidModeAdvanceSettingFragment;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.FormMultiLineSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class bcnn
  implements CompoundButton.OnCheckedChangeListener
{
  public bcnn(KidModeAdvanceSettingFragment paramKidModeAdvanceSettingFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    boolean bool = true;
    if (!NetworkUtil.isNetSupport(this.a.getActivity()))
    {
      QQToast.a(this.a.getActivity(), 1, 2131694108, 1).a();
      KidModeAdvanceSettingFragment localKidModeAdvanceSettingFragment = this.a;
      FormMultiLineSwitchItem localFormMultiLineSwitchItem = KidModeAdvanceSettingFragment.a(this.a);
      if (!paramBoolean) {
        KidModeAdvanceSettingFragment.a(localKidModeAdvanceSettingFragment, localFormMultiLineSwitchItem, bool, KidModeAdvanceSettingFragment.a(this.a));
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      bool = false;
      break;
      paramCompoundButton.setEnabled(false);
      KidModeAdvanceSettingFragment.a(this.a, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcnn
 * JD-Core Version:    0.7.0.1
 */