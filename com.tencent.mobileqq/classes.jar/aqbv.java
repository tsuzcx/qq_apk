import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aqbv
  implements View.OnClickListener
{
  aqbv(aqbt paramaqbt, BaseActivity paramBaseActivity) {}
  
  public void onClick(View paramView)
  {
    aqbt.a(this.jdField_a_of_type_Aqbt, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    bcst.a(this.jdField_a_of_type_Aqbt.a, "dc00898", "", "", "0X8009EE2", "0X8009EE2", 23, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqbv
 * JD-Core Version:    0.7.0.1
 */