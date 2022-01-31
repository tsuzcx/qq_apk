import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.datareportviewer.DataReportSettingFragment;

public class anlc
  implements View.OnLongClickListener, CompoundButton.OnCheckedChangeListener
{
  public anku a;
  
  protected anlc(DataReportSettingFragment paramDataReportSettingFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Anku != null)
    {
      this.jdField_a_of_type_Anku.a = paramBoolean;
      anls.a().e();
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    bbcv.a(this.jdField_a_of_type_ComTencentMobileqqDatareportviewerDataReportSettingFragment.getActivity(), 230, null, ajyc.a(2131702771), new anld(this), new anle(this)).show();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     anlc
 * JD-Core Version:    0.7.0.1
 */