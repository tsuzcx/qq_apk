import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForMixedMsg;

class awyi
  extends anyz
{
  awyi(awyg paramawyg, QQAppInterface paramQQAppInterface, MessageForMixedMsg paramMessageForMixedMsg, String paramString, int paramInt) {}
  
  public void onNotifyResultAfterSendRich(boolean paramBoolean, long paramLong, anza paramanza)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg.istroop, this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg.uniseq);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().notifyUI(6003, true, new Object[] { this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg.uniseq + "" });
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().updateMsgContentByUniseq(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg.uniseq, this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg.msgData);
    if (paramBoolean)
    {
      awyg.a(this.jdField_a_of_type_Awyg, this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg, true);
      return;
    }
    awyg localawyg = this.jdField_a_of_type_Awyg;
    MessageForMixedMsg localMessageForMixedMsg = this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg;
    StringBuilder localStringBuilder = new StringBuilder().append("sendStructLongMsg fail : errCode = ");
    if (paramanza != null) {}
    for (paramanza = Integer.valueOf(paramanza.b);; paramanza = "")
    {
      awyg.a(localawyg, localMessageForMixedMsg, true, paramanza);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awyi
 * JD-Core Version:    0.7.0.1
 */