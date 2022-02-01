import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.forward.ForwardStructingMsgOption;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class atqd
  implements View.OnClickListener
{
  public atqd(ForwardStructingMsgOption paramForwardStructingMsgOption, boolean paramBoolean, String paramString, long paramLong) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqForwardForwardStructingMsgOption.a == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.jdField_a_of_type_ComTencentMobileqqForwardForwardStructingMsgOption.a.hideSoftInputFromWindow();
      ForwardStructingMsgOption.a(this.jdField_a_of_type_ComTencentMobileqqForwardForwardStructingMsgOption, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long);
      this.jdField_a_of_type_ComTencentMobileqqForwardForwardStructingMsgOption.F();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atqd
 * JD-Core Version:    0.7.0.1
 */