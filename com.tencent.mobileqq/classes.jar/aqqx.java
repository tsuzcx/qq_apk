import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aqqx
  implements View.OnClickListener
{
  aqqx(aqqv paramaqqv, BaseActivity paramBaseActivity) {}
  
  public void onClick(View paramView)
  {
    aqqv.a(this.jdField_a_of_type_Aqqv, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    bdll.a(this.jdField_a_of_type_Aqqv.a, "dc00898", "", "", "0X8009EE2", "0X8009EE2", 23, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqqx
 * JD-Core Version:    0.7.0.1
 */