import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.qphone.base.util.QLog;

class arwf
  implements View.OnClickListener
{
  arwf(arwe paramarwe) {}
  
  public void onClick(View paramView)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg != null) {
      if (this.a.jdField_a_of_type_Bdfq != null) {}
    }
    while (!QLog.isColorLevel())
    {
      return;
      this.a.jdField_a_of_type_Bdfq.hideSoftInputFromWindow();
      if (this.a.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg.hasReplyText())
      {
        ((axis)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(340)).a(this.a.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg);
        arxx.a(this.a, this.a.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg.uniseq);
      }
      for (;;)
      {
        this.a.D();
        return;
        paramView = new arxf(this.a.jdField_a_of_type_Bdfq, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        paramView.a(this.a.jdField_a_of_type_AndroidAppActivity.getString(2131692843), this.a.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg);
        this.a.jdField_a_of_type_Bdfq.addPreviewView(paramView.b());
      }
    }
    QLog.e("ForwardOption.ForwardMixedMsgOption", 2, "no msg not enter preview");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arwf
 * JD-Core Version:    0.7.0.1
 */