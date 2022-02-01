import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForLongTextMsg;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import tencent.im.msg.im_msg_body.RichText;

class awwh
  implements ayyt
{
  awwh(awwg paramawwg, QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, boolean paramBoolean) {}
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void a(ayyu paramayyu) {}
  
  public void b(ayyu paramayyu)
  {
    try
    {
      if (paramayyu.jdField_a_of_type_Int == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("StructLongTextMsg", 2, "step3: sendLongTextMsg pack upload cost: " + (System.currentTimeMillis() - awwg.a(this.jdField_a_of_type_Awwg)) + ",mResid:" + paramayyu.c);
        }
        AbsShareMsg localAbsShareMsg = adrm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentNickname());
        localAbsShareMsg.mResid = paramayyu.c;
        localAbsShareMsg.mFileName = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq);
        localAbsShareMsg.multiMsgFlag = 1;
        MessageForLongTextMsg localMessageForLongTextMsg = (MessageForLongTextMsg)bbzh.a(-1051);
        localMessageForLongTextMsg.structingMsg = localAbsShareMsg;
        localMessageForLongTextMsg.frienduin = this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin;
        localMessageForLongTextMsg.istroop = this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop;
        localMessageForLongTextMsg.selfuin = this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.selfuin;
        localMessageForLongTextMsg.senderuin = this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.senderuin;
        localMessageForLongTextMsg.isread = this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.isread;
        localMessageForLongTextMsg.time = this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.time;
        localMessageForLongTextMsg.msgseq = this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msgseq;
        localMessageForLongTextMsg.msgUid = this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msgUid;
        localMessageForLongTextMsg.shmsgseq = this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.shmsgseq;
        localMessageForLongTextMsg.issend = this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.issend;
        localMessageForLongTextMsg.uniseq = this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq;
        localMessageForLongTextMsg.mAnimFlag = true;
        localMessageForLongTextMsg.longMsgCount = 1;
        localMessageForLongTextMsg.longMsgIndex = 0;
        localMessageForLongTextMsg.longMsgId = ((short)(int)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.shmsgseq);
        localMessageForLongTextMsg.saveExtInfoToExtStr("long_text_msg_resid", paramayyu.c);
        if (njo.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord)) {
          njo.a().a(localMessageForLongTextMsg);
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(localMessageForLongTextMsg, null, this.jdField_a_of_type_Boolean);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("StructLongTextMsg", 2, "MessageForReplyText upload multi msg pack failed, result.errStr=" + paramayyu.b + ",result.errStr=" + paramayyu.jdField_a_of_type_JavaLangString);
      }
      awwg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
      return;
    }
    catch (Exception paramayyu)
    {
      if (QLog.isColorLevel()) {
        QLog.d("StructLongTextMsg", 2, "MessageForReplyText upload multi msg pack failed, catch exception", paramayyu);
      }
      awwg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awwh
 * JD-Core Version:    0.7.0.1
 */