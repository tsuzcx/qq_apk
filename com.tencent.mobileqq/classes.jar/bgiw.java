import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bgiw
  implements View.OnClickListener
{
  bgiw(bgit parambgit, QQAppInterface paramQQAppInterface, Context paramContext, Dialog paramDialog) {}
  
  public void onClick(View paramView)
  {
    bgit.a(this.jdField_a_of_type_Bgit, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, 1);
    bgit.b(this.jdField_a_of_type_Bgit, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidAppDialog);
    bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800B0C7", "0X800B0C7", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgiw
 * JD-Core Version:    0.7.0.1
 */