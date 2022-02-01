import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForMixedMsg;

class axfa
  extends aocj
{
  axfa(axey paramaxey, QQAppInterface paramQQAppInterface, MessageForMixedMsg paramMessageForMixedMsg, String paramString, int paramInt) {}
  
  public void a(boolean paramBoolean, long paramLong, aock paramaock)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg.istroop, this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg.uniseq);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().notifyUI(6003, true, new Object[] { this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg.uniseq + "" });
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg.uniseq, this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg.msgData);
    if (paramBoolean)
    {
      axey.a(this.jdField_a_of_type_Axey, this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg, true);
      return;
    }
    axey localaxey = this.jdField_a_of_type_Axey;
    MessageForMixedMsg localMessageForMixedMsg = this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg;
    StringBuilder localStringBuilder = new StringBuilder().append("sendStructLongMsg fail : errCode = ");
    if (paramaock != null) {}
    for (paramaock = Integer.valueOf(paramaock.b);; paramaock = "")
    {
      axey.a(localaxey, localMessageForMixedMsg, true, paramaock);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axfa
 * JD-Core Version:    0.7.0.1
 */