import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.studymode.KidModeAdvanceSettingFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class bdup
  implements View.OnClickListener
{
  public bdup(KidModeAdvanceSettingFragment paramKidModeAdvanceSettingFragment) {}
  
  public void onClick(View paramView)
  {
    anxo.a(this.a.getActivity(), KidModeAdvanceSettingFragment.a(this.a));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdup
 * JD-Core Version:    0.7.0.1
 */