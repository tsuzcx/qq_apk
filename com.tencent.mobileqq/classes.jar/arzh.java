import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.datareportviewer.DataReportSettingFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class arzh
  implements View.OnLongClickListener, CompoundButton.OnCheckedChangeListener
{
  public aryz a;
  
  protected arzh(DataReportSettingFragment paramDataReportSettingFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Aryz != null)
    {
      this.jdField_a_of_type_Aryz.a = paramBoolean;
      arzx.a().e();
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
  
  public boolean onLongClick(View paramView)
  {
    bhlq.a(this.jdField_a_of_type_ComTencentMobileqqDatareportviewerDataReportSettingFragment.getActivity(), 230, null, anzj.a(2131701680), new arzi(this), new arzj(this)).show();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arzh
 * JD-Core Version:    0.7.0.1
 */