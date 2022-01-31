import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForLongTextMsg;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import tencent.im.msg.im_msg_body.RichText;

class astw
  implements auoq
{
  astw(astu paramastu, QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, boolean paramBoolean) {}
  
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
          QLog.d("StructLongTextMsg", 2, "step3: sendLongTextMsg pack upload cost: " + (System.currentTimeMillis() - astu.a(this.jdField_a_of_type_Astu)) + ",mResid:" + paramauor.c);
        }
        AbsShareMsg localAbsShareMsg = aanz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentNickname());
        localAbsShareMsg.mResid = paramauor.c;
        localAbsShareMsg.mFileName = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq);
        localAbsShareMsg.multiMsgFlag = 1;
        MessageForLongTextMsg localMessageForLongTextMsg = (MessageForLongTextMsg)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
        localMessageForLongTextMsg.structingMsg = localAbsShareMsg;
        localMessageForLongTextMsg.saveExtInfoToExtStr("long_text_msg_resid", paramauor.c);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, null, this.jdField_a_of_type_Boolean);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("StructLongTextMsg", 2, "upload multi msg pack failed, result.errStr=" + paramauor.b + ",result.errStr=" + paramauor.jdField_a_of_type_JavaLangString);
      }
      astu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
      return;
    }
    catch (Exception paramauor)
    {
      if (QLog.isColorLevel()) {
        QLog.d("StructLongTextMsg", 2, "upload multi msg pack failed, catch exception", paramauor);
      }
      astu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     astw
 * JD-Core Version:    0.7.0.1
 */