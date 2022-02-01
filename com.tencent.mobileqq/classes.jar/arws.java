import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.datareportviewer.DataReportSettingFragment;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class arws
  implements View.OnLongClickListener, CompoundButton.OnCheckedChangeListener
{
  public arwk a;
  
  protected arws(DataReportSettingFragment paramDataReportSettingFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Arwk != null)
    {
      this.jdField_a_of_type_Arwk.a = paramBoolean;
      arxi.a().e();
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
  
  public boolean onLongClick(View paramView)
  {
    bhdj.a(this.jdField_a_of_type_ComTencentMobileqqDatareportviewerDataReportSettingFragment.getActivity(), 230, null, anvx.a(2131702266), new arwt(this), new arwu(this)).show();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arws
 * JD-Core Version:    0.7.0.1
 */