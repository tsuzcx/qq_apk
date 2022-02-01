import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForLongTextMsg;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import tencent.im.msg.im_msg_body.RichText;

class axik
  implements azla
{
  axik(axii paramaxii, QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, boolean paramBoolean) {}
  
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
        MessageForLongTextMsg localMessageForLongTextMsg = (MessageForLongTextMsg)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
        localMessageForLongTextMsg.structingMsg = localStructMsgForGeneralShare;
        localMessageForLongTextMsg.saveExtInfoToExtStr("long_text_msg_resid", paramazlb.c);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().sendMessage(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, null, this.jdField_a_of_type_Boolean);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("StructLongTextMsg", 2, "upload multi msg pack failed, result.errStr=" + paramazlb.b + ",result.errStr=" + paramazlb.jdField_a_of_type_JavaLangString);
      }
      axii.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
      return;
    }
    catch (Exception paramazlb)
    {
      if (QLog.isColorLevel()) {
        QLog.d("StructLongTextMsg", 2, "upload multi msg pack failed, catch exception", paramazlb);
      }
      axii.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
    }
  }
  
  public void updateMsg(azlb paramazlb) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axik
 * JD-Core Version:    0.7.0.1
 */