import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForLongTextMsg;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import tencent.im.msg.im_msg_body.RichText;

class auaw
  implements awfy
{
  MessageForLongTextMsg jdField_a_of_type_ComTencentMobileqqDataMessageForLongTextMsg;
  
  auaw(auat paramauat, QQAppInterface paramQQAppInterface, MessageForMixedMsg paramMessageForMixedMsg, alsi paramalsi) {}
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void a(awfz paramawfz) {}
  
  public void b(awfz paramawfz)
  {
    try
    {
      if (paramawfz.jdField_a_of_type_Int == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MixedMsgManager", 2, "step3: sendLongTextMsg pack upload cost: " + (System.currentTimeMillis() - auat.a(this.jdField_a_of_type_Auat)) + ",mResid:" + paramawfz.c);
        }
        AbsShareMsg localAbsShareMsg = acex.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentNickname());
        localAbsShareMsg.mResid = paramawfz.c;
        localAbsShareMsg.mFileName = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg.uniseq);
        localAbsShareMsg.multiMsgFlag = 1;
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForLongTextMsg = ((MessageForLongTextMsg)ayvw.a(-1051));
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForLongTextMsg.structingMsg = localAbsShareMsg;
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForLongTextMsg.frienduin = this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg.frienduin;
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForLongTextMsg.istroop = this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg.istroop;
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForLongTextMsg.selfuin = this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg.selfuin;
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForLongTextMsg.senderuin = this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg.senderuin;
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForLongTextMsg.isread = this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg.isread;
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForLongTextMsg.time = this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg.time;
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForLongTextMsg.msgseq = this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg.msgseq;
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForLongTextMsg.msgUid = this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg.msgUid;
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForLongTextMsg.shmsgseq = this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg.shmsgseq;
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForLongTextMsg.issend = this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg.issend;
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForLongTextMsg.uniseq = this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg.uniseq;
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForLongTextMsg.mAnimFlag = true;
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForLongTextMsg.longMsgCount = 1;
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForLongTextMsg.longMsgIndex = 0;
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForLongTextMsg.longMsgId = ((short)(int)this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg.shmsgseq);
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForLongTextMsg.saveExtInfoToExtStr("long_text_msg_resid", paramawfz.c);
        nav.a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForLongTextMsg);
        ((axso)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(326)).a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForLongTextMsg, this.jdField_a_of_type_Alsi);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MixedMsgManager", 2, "upload multi msg pack failed, result.errStr=" + paramawfz.b + ",result.errStr=" + paramawfz.jdField_a_of_type_JavaLangString);
      }
      auat.a(this.jdField_a_of_type_Auat, this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg, true, "upload longMsg pack fail: errCode = " + paramawfz.b);
      return;
    }
    catch (Exception paramawfz)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MixedMsgManager", 2, "upload multi msg pack failed, catch exception", paramawfz);
      }
      auat.a(this.jdField_a_of_type_Auat, this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg, true, "sendStructLongMsg fail: exception" + paramawfz.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     auaw
 * JD-Core Version:    0.7.0.1
 */