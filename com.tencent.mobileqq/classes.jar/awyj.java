import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageForLongTextMsg;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import tencent.im.msg.im_msg_body.RichText;

class awyj
  implements azla
{
  MessageForLongTextMsg jdField_a_of_type_ComTencentMobileqqDataMessageForLongTextMsg;
  
  awyj(awyg paramawyg, QQAppInterface paramQQAppInterface, MessageForMixedMsg paramMessageForMixedMsg, anyz paramanyz) {}
  
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
          QLog.d("MixedMsgManager", 2, "step3: sendLongTextMsg pack upload cost: " + (System.currentTimeMillis() - awyg.a(this.jdField_a_of_type_Awyg)) + ",mResid:" + paramazlb.c);
        }
        StructMsgForGeneralShare localStructMsgForGeneralShare = admh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentNickname());
        localStructMsgForGeneralShare.mResid = paramazlb.c;
        localStructMsgForGeneralShare.mFileName = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg.uniseq);
        localStructMsgForGeneralShare.multiMsgFlag = 1;
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForLongTextMsg = ((MessageForLongTextMsg)bcsa.a(-1051));
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForLongTextMsg.structingMsg = localStructMsgForGeneralShare;
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
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForLongTextMsg.saveExtInfoToExtStr("long_text_msg_resid", paramazlb.c);
        nty.a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForLongTextMsg);
        ((bbob)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MEDIA_MSG_ORDER_SEND_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForLongTextMsg, this.jdField_a_of_type_Anyz);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MixedMsgManager", 2, "upload multi msg pack failed, result.errStr=" + paramazlb.b + ",result.errStr=" + paramazlb.jdField_a_of_type_JavaLangString);
      }
      awyg.a(this.jdField_a_of_type_Awyg, this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg, true, "upload longMsg pack fail: errCode = " + paramazlb.b);
      return;
    }
    catch (Exception paramazlb)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MixedMsgManager", 2, "upload multi msg pack failed, catch exception", paramazlb);
      }
      awyg.a(this.jdField_a_of_type_Awyg, this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg, true, "sendStructLongMsg fail: exception" + paramazlb.getMessage());
    }
  }
  
  public void updateMsg(azlb paramazlb) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awyj
 * JD-Core Version:    0.7.0.1
 */