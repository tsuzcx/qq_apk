import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import tencent.im.msg.im_msg_body.RichText;

class axih
  implements azla
{
  axih(axig paramaxig, MessageForArkApp paramMessageForArkApp, QQAppInterface paramQQAppInterface) {}
  
  public MessageRecord attachRichText2Msg(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void onSend(azlb paramazlb)
  {
    try
    {
      if (paramazlb.jdField_a_of_type_Int == 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp.resIDForLongMsg = paramazlb.c;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().sendMessage(this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp, null, false);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("StructLongTextMsg", 2, "upload multi msg pack failed, result.errStr=" + paramazlb.b + ",result.errStr=" + paramazlb.jdField_a_of_type_JavaLangString);
      }
      axii.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp);
      return;
    }
    catch (Exception paramazlb)
    {
      if (QLog.isColorLevel()) {
        QLog.d("StructLongTextMsg", 2, "upload multi msg pack failed, catch exception", paramazlb);
      }
      axii.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp);
    }
  }
  
  public void updateMsg(azlb paramazlb) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axih
 * JD-Core Version:    0.7.0.1
 */