import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.datareportviewer.DataReportSettingFragment;

public class amuu
  implements View.OnLongClickListener, CompoundButton.OnCheckedChangeListener
{
  public amum a;
  
  protected amuu(DataReportSettingFragment paramDataReportSettingFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Amum != null)
    {
      this.jdField_a_of_type_Amum.a = paramBoolean;
      amvk.a().e();
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    babr.a(this.jdField_a_of_type_ComTencentMobileqqDatareportviewerDataReportSettingFragment.getActivity(), 230, null, ajjy.a(2131636987), new amuv(this), new amuw(this)).show();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amuu
 * JD-Core Version:    0.7.0.1
 */