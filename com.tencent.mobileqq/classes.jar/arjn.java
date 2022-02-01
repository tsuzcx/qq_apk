import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.datareportviewer.DataReportSettingFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class arjn
  implements View.OnClickListener
{
  public arjn(DataReportSettingFragment paramDataReportSettingFragment) {}
  
  public void onClick(View paramView)
  {
    bglp.a(this.a.getActivity(), 0, 2131559603, anni.a(2131701571), "", anni.a(2131701566), anni.a(2131701572), new arjo(this), new arjp(this)).show();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arjn
 * JD-Core Version:    0.7.0.1
 */