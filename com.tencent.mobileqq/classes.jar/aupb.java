import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForLongTextMsg;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import tencent.im.msg.im_msg_body.RichText;

class aupb
  implements awkh
{
  aupb(aupa paramaupa, QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, boolean paramBoolean) {}
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void a(awki paramawki) {}
  
  public void b(awki paramawki)
  {
    try
    {
      if (paramawki.jdField_a_of_type_Int == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("StructLongTextMsg", 2, "step3: sendLongTextMsg pack upload cost: " + (System.currentTimeMillis() - aupa.a(this.jdField_a_of_type_Aupa)) + ",mResid:" + paramawki.c);
        }
        AbsShareMsg localAbsShareMsg = acjm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentNickname());
        localAbsShareMsg.mResid = paramawki.c;
        localAbsShareMsg.mFileName = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq);
        localAbsShareMsg.multiMsgFlag = 1;
        MessageForLongTextMsg localMessageForLongTextMsg = (MessageForLongTextMsg)azaf.a(-1051);
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
        localMessageForLongTextMsg.saveExtInfoToExtStr("long_text_msg_resid", paramawki.c);
        if (nav.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord)) {
          nav.a().a(localMessageForLongTextMsg);
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(localMessageForLongTextMsg, null, this.jdField_a_of_type_Boolean);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("StructLongTextMsg", 2, "MessageForReplyText upload multi msg pack failed, result.errStr=" + paramawki.b + ",result.errStr=" + paramawki.jdField_a_of_type_JavaLangString);
      }
      aupa.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
      return;
    }
    catch (Exception paramawki)
    {
      if (QLog.isColorLevel()) {
        QLog.d("StructLongTextMsg", 2, "MessageForReplyText upload multi msg pack failed, catch exception", paramawki);
      }
      aupa.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aupb
 * JD-Core Version:    0.7.0.1
 */