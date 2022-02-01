import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.studymode.KidModeAdvanceSettingFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class bduk
  implements CompoundButton.OnCheckedChangeListener
{
  public bduk(KidModeAdvanceSettingFragment paramKidModeAdvanceSettingFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    KidModeAdvanceSettingFragment.b(this.a, 32, paramBoolean);
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bduk
 * JD-Core Version:    0.7.0.1
 */