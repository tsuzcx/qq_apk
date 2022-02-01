import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import tencent.im.msg.im_msg_body.RichText;

class awcf
  implements ayeo
{
  awcf(awce paramawce, MessageForArkApp paramMessageForArkApp, QQAppInterface paramQQAppInterface) {}
  
  public MessageRecord attachRichText2Msg(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void onSend(ayep paramayep)
  {
    try
    {
      if (paramayep.jdField_a_of_type_Int == 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp.resIDForLongMsg = paramayep.c;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().sendMessage(this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp, null, false);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("StructLongTextMsg", 2, "upload multi msg pack failed, result.errStr=" + paramayep.b + ",result.errStr=" + paramayep.jdField_a_of_type_JavaLangString);
      }
      awcg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp);
      return;
    }
    catch (Exception paramayep)
    {
      if (QLog.isColorLevel()) {
        QLog.d("StructLongTextMsg", 2, "upload multi msg pack failed, catch exception", paramayep);
      }
      awcg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp);
    }
  }
  
  public void updateMsg(ayep paramayep) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awcf
 * JD-Core Version:    0.7.0.1
 */