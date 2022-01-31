import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.datareportviewer.DataReportSettingFragment;

public class apgx
  implements View.OnLongClickListener, CompoundButton.OnCheckedChangeListener
{
  public apgp a;
  
  protected apgx(DataReportSettingFragment paramDataReportSettingFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Apgp != null)
    {
      this.jdField_a_of_type_Apgp.a = paramBoolean;
      aphn.a().e();
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    bdgm.a(this.jdField_a_of_type_ComTencentMobileqqDatareportviewerDataReportSettingFragment.getActivity(), 230, null, alud.a(2131703166), new apgy(this), new apgz(this)).show();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apgx
 * JD-Core Version:    0.7.0.1
 */