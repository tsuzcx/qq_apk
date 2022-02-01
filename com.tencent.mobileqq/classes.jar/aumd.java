import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.fragment.LangSettingFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aumd
  implements View.OnClickListener
{
  public aumd(LangSettingFragment paramLangSettingFragment) {}
  
  public void onClick(View paramView)
  {
    LangSettingFragment.a(this.a).dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aumd
 * JD-Core Version:    0.7.0.1
 */