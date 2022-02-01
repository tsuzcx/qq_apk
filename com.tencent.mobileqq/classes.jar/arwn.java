import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.datareportviewer.DataReportSettingFragment;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class arwn
  implements View.OnClickListener
{
  public arwn(DataReportSettingFragment paramDataReportSettingFragment) {}
  
  public void onClick(View paramView)
  {
    bhdj.a(this.a.getActivity(), 0, 2131559645, anvx.a(2131702264), "", anvx.a(2131702259), anvx.a(2131702265), new arwo(this), new arwp(this)).show();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arwn
 * JD-Core Version:    0.7.0.1
 */