import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.studymode.KidModeAdvanceSettingFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class bcnq
  implements View.OnClickListener
{
  public bcnq(KidModeAdvanceSettingFragment paramKidModeAdvanceSettingFragment) {}
  
  public void onClick(View paramView)
  {
    amvb.a(this.a.getActivity(), KidModeAdvanceSettingFragment.a(this.a));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcnq
 * JD-Core Version:    0.7.0.1
 */