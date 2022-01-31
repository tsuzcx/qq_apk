import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForLongTextMsg;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import tencent.im.msg.im_msg_body.RichText;

class asjx
  implements auoq
{
  MessageForLongTextMsg jdField_a_of_type_ComTencentMobileqqDataMessageForLongTextMsg;
  
  asjx(asju paramasju, QQAppInterface paramQQAppInterface, MessageForMixedMsg paramMessageForMixedMsg, akat paramakat) {}
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void a(auor paramauor) {}
  
  public void b(auor paramauor)
  {
    try
    {
      if (paramauor.jdField_a_of_type_Int == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MixedMsgManager", 2, "step3: sendLongTextMsg pack upload cost: " + (System.currentTimeMillis() - asju.a(this.jdField_a_of_type_Asju)) + ",mResid:" + paramauor.c);
        }
        AbsShareMsg localAbsShareMsg = aanz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentNickname());
        localAbsShareMsg.mResid = paramauor.c;
        localAbsShareMsg.mFileName = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg.uniseq);
        localAbsShareMsg.multiMsgFlag = 1;
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForLongTextMsg = ((MessageForLongTextMsg)axas.a(-1051));
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
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForLongTextMsg.saveExtInfoToExtStr("long_text_msg_resid", paramauor.c);
        myb.a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForLongTextMsg);
        ((awap)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(326)).a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForLongTextMsg, this.jdField_a_of_type_Akat);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MixedMsgManager", 2, "upload multi msg pack failed, result.errStr=" + paramauor.b + ",result.errStr=" + paramauor.jdField_a_of_type_JavaLangString);
      }
      asju.a(this.jdField_a_of_type_Asju, this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg, true, "upload longMsg pack fail: errCode = " + paramauor.b);
      return;
    }
    catch (Exception paramauor)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MixedMsgManager", 2, "upload multi msg pack failed, catch exception", paramauor);
      }
      asju.a(this.jdField_a_of_type_Asju, this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg, true, "sendStructLongMsg fail: exception" + paramauor.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     asjx
 * JD-Core Version:    0.7.0.1
 */