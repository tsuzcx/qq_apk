import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.datareportviewer.DataReportSettingFragment;

public class apco
  implements View.OnLongClickListener, CompoundButton.OnCheckedChangeListener
{
  public apcg a;
  
  protected apco(DataReportSettingFragment paramDataReportSettingFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Apcg != null)
    {
      this.jdField_a_of_type_Apcg.a = paramBoolean;
      apde.a().e();
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    bdcd.a(this.jdField_a_of_type_ComTencentMobileqqDatareportviewerDataReportSettingFragment.getActivity(), 230, null, alpo.a(2131703154), new apcp(this), new apcq(this)).show();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apco
 * JD-Core Version:    0.7.0.1
 */