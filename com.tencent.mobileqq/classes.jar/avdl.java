import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.fragment.AppletsSettingFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class avdl
  implements View.OnClickListener
{
  public avdl(AppletsSettingFragment paramAppletsSettingFragment) {}
  
  public void onClick(View paramView)
  {
    if (AppletsSettingFragment.a(this.a))
    {
      this.a.a();
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    AppletsSettingFragment localAppletsSettingFragment = this.a;
    if (!AppletsSettingFragment.a(this.a)) {}
    for (boolean bool = true;; bool = false)
    {
      AppletsSettingFragment.a(localAppletsSettingFragment, bool);
      AppletsSettingFragment.a(this.a, AppletsSettingFragment.a(this.a));
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avdl
 * JD-Core Version:    0.7.0.1
 */