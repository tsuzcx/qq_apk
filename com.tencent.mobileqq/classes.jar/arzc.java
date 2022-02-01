import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.datareportviewer.DataReportSettingFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class arzc
  implements View.OnClickListener
{
  public arzc(DataReportSettingFragment paramDataReportSettingFragment) {}
  
  public void onClick(View paramView)
  {
    bhlq.a(this.a.getActivity(), 0, 2131559608, anzj.a(2131701678), "", anzj.a(2131701673), anzj.a(2131701679), new arzd(this), new arze(this)).show();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arzc
 * JD-Core Version:    0.7.0.1
 */