import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bhaw
  implements View.OnClickListener
{
  bhaw(bhav parambhav, QQAppInterface paramQQAppInterface, Context paramContext) {}
  
  public void onClick(View paramView)
  {
    Dialog localDialog = bhav.a(this.jdField_a_of_type_Bhav, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext);
    localDialog.show();
    bhav.a(this.jdField_a_of_type_Bhav, this.jdField_a_of_type_AndroidContentContext, localDialog);
    bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800B0C4", "0X800B0C4", 0, 0, "", "", "", "");
    bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800B0C5", "0X800B0C5", 0, 0, "", "", "", "");
    bdla.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009EE2", "0X8009EE2", 24, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhaw
 * JD-Core Version:    0.7.0.1
 */