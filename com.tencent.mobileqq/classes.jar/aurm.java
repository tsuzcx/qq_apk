import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.forward.ForwardMixedMsgOption;
import com.tencent.mobileqq.forward.ForwardReplyMsgOption;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aurm
  implements View.OnClickListener
{
  public aurm(ForwardMixedMsgOption paramForwardMixedMsgOption) {}
  
  public void onClick(View paramView)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg != null) {
      if (this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) {}
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.hideSoftInputFromWindow();
      if (this.a.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg.hasReplyText())
      {
        ((bben)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FORWARD_MSG_MANAGER)).a(this.a.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg);
        ForwardReplyMsgOption.a(this.a, this.a.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg.uniseq);
      }
      for (;;)
      {
        this.a.F();
        break;
        ausm localausm = new ausm(this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        localausm.a(this.a.jdField_a_of_type_AndroidAppActivity.getString(2131692554), this.a.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg);
        this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.addPreviewView(localausm.b());
      }
      if (QLog.isColorLevel()) {
        QLog.e("ForwardOption.ForwardMixedMsgOption", 2, "no msg not enter preview");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aurm
 * JD-Core Version:    0.7.0.1
 */