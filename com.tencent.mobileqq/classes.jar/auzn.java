import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.forward.ForwardMixedMsgOption;
import com.tencent.mobileqq.forward.ForwardReplyMsgOption;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class auzn
  implements View.OnClickListener
{
  public auzn(ForwardMixedMsgOption paramForwardMixedMsgOption) {}
  
  public void onClick(View paramView)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg != null) {
      if (this.a.jdField_a_of_type_Bhpc != null) {}
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.a.jdField_a_of_type_Bhpc.hideSoftInputFromWindow();
      if (this.a.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg.hasReplyText())
      {
        ((bbdj)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(340)).a(this.a.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg);
        ForwardReplyMsgOption.a(this.a, this.a.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg.uniseq);
      }
      for (;;)
      {
        this.a.F();
        break;
        avan localavan = new avan(this.a.jdField_a_of_type_Bhpc, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        localavan.a(this.a.jdField_a_of_type_AndroidAppActivity.getString(2131692404), this.a.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg);
        this.a.jdField_a_of_type_Bhpc.addPreviewView(localavan.b());
      }
      if (QLog.isColorLevel()) {
        QLog.e("ForwardOption.ForwardMixedMsgOption", 2, "no msg not enter preview");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auzn
 * JD-Core Version:    0.7.0.1
 */