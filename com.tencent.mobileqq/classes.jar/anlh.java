import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.datareportviewer.DataReportSettingFragment;

public class anlh
  implements View.OnLongClickListener, CompoundButton.OnCheckedChangeListener
{
  public ankz a;
  
  protected anlh(DataReportSettingFragment paramDataReportSettingFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Ankz != null)
    {
      this.jdField_a_of_type_Ankz.a = paramBoolean;
      anlx.a().e();
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    bbdj.a(this.jdField_a_of_type_ComTencentMobileqqDatareportviewerDataReportSettingFragment.getActivity(), 230, null, ajya.a(2131702782), new anli(this), new anlj(this)).show();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     anlh
 * JD-Core Version:    0.7.0.1
 */