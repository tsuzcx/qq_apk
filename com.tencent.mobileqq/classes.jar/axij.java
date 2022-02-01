import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForLongTextMsg;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import tencent.im.msg.im_msg_body.RichText;

class axij
  implements azla
{
  axij(axii paramaxii, QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, boolean paramBoolean) {}
  
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
        if (QLog.isColorLevel()) {
          QLog.d("StructLongTextMsg", 2, "step3: sendLongTextMsg pack upload cost: " + (System.currentTimeMillis() - axii.a(this.jdField_a_of_type_Axii)) + ",mResid:" + paramazlb.c);
        }
        StructMsgForGeneralShare localStructMsgForGeneralShare = admh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentNickname());
        localStructMsgForGeneralShare.mResid = paramazlb.c;
        localStructMsgForGeneralShare.mFileName = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq);
        localStructMsgForGeneralShare.multiMsgFlag = 1;
        MessageForLongTextMsg localMessageForLongTextMsg = (MessageForLongTextMsg)bcsa.a(-1051);
        localMessageForLongTextMsg.structingMsg = localStructMsgForGeneralShare;
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
        localMessageForLongTextMsg.saveExtInfoToExtStr("long_text_msg_resid", paramazlb.c);
        if (nty.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord)) {
          nty.a().a(localMessageForLongTextMsg);
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().sendMessage(localMessageForLongTextMsg, null, this.jdField_a_of_type_Boolean);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("StructLongTextMsg", 2, "MessageForReplyText upload multi msg pack failed, result.errStr=" + paramazlb.b + ",result.errStr=" + paramazlb.jdField_a_of_type_JavaLangString);
      }
      axii.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
      return;
    }
    catch (Exception paramazlb)
    {
      if (QLog.isColorLevel()) {
        QLog.d("StructLongTextMsg", 2, "MessageForReplyText upload multi msg pack failed, catch exception", paramazlb);
      }
      axii.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
    }
  }
  
  public void updateMsg(azlb paramazlb) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axij
 * JD-Core Version:    0.7.0.1
 */