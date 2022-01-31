import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForMixedMsg;

class auav
  extends alsi
{
  auav(auat paramauat, QQAppInterface paramQQAppInterface, MessageForMixedMsg paramMessageForMixedMsg, String paramString, int paramInt) {}
  
  public void a(boolean paramBoolean, long paramLong, alsj paramalsj)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg.istroop, this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg.uniseq);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().notifyUI(6003, true, new Object[] { this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg.uniseq + "" });
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg.uniseq, this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg.msgData);
    if (paramBoolean)
    {
      auat.a(this.jdField_a_of_type_Auat, this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg, true);
      return;
    }
    auat localauat = this.jdField_a_of_type_Auat;
    MessageForMixedMsg localMessageForMixedMsg = this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg;
    StringBuilder localStringBuilder = new StringBuilder().append("sendStructLongMsg fail : errCode = ");
    if (paramalsj != null) {}
    for (paramalsj = Integer.valueOf(paramalsj.b);; paramalsj = "")
    {
      auat.a(localauat, localMessageForMixedMsg, true, paramalsj);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     auav
 * JD-Core Version:    0.7.0.1
 */