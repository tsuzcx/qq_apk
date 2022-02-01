import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.datareportviewer.DataReportSettingFragment;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aqsz
  implements View.OnClickListener
{
  public aqsz(DataReportSettingFragment paramDataReportSettingFragment) {}
  
  public void onClick(View paramView)
  {
    bfur.a(this.a.getActivity(), 0, 2131559610, amtj.a(2131701913), "", amtj.a(2131701908), amtj.a(2131701914), new aqta(this), new aqtb(this)).show();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqsz
 * JD-Core Version:    0.7.0.1
 */