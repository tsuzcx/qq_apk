import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.qphone.base.util.QLog;

class aqcx
  implements View.OnClickListener
{
  aqcx(aqcw paramaqcw) {}
  
  public void onClick(View paramView)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg != null) {
      if (this.a.jdField_a_of_type_Bbgu != null) {}
    }
    while (!QLog.isColorLevel())
    {
      return;
      this.a.jdField_a_of_type_Bbgu.hideSoftInputFromWindow();
      if (this.a.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg.hasReplyText())
      {
        ((avqu)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(340)).a(this.a.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg);
        aqep.a(this.a, this.a.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg.uniseq);
      }
      for (;;)
      {
        this.a.D();
        return;
        paramView = new aqdx(this.a.jdField_a_of_type_Bbgu, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        paramView.a(this.a.jdField_a_of_type_AndroidAppActivity.getString(2131692761), this.a.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg);
        this.a.jdField_a_of_type_Bbgu.addPreviewView(paramView.b());
      }
    }
    QLog.e("ForwardOption.ForwardMixedMsgOption", 2, "no msg not enter preview");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aqcx
 * JD-Core Version:    0.7.0.1
 */