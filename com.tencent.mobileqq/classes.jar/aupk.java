import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import tencent.im.msg.im_msg_body.RichText;

class aupk
  implements awkh
{
  int jdField_a_of_type_Int;
  MessageRecord jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
  String jdField_a_of_type_JavaLangString;
  WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  
  public aupk(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, String paramString, int paramInt)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramMessageRecord;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void a(awki paramawki) {}
  
  public void b(awki paramawki)
  {
    if (paramawki.jdField_a_of_type_Int == 0)
    {
      MessageForStructing localMessageForStructing = (MessageForStructing)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      localMessageForStructing.structingMsg.mResid = paramawki.c;
      localMessageForStructing.structingMsg.mFileName = String.valueOf(localMessageForStructing.uniseq);
      ((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, localMessageForStructing.uniseq, localMessageForStructing.structingMsg.getBytes());
      ((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a().b(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, null);
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg_TAG", 2, "send real struct msg done, cost : " + (System.currentTimeMillis() - aupg.b()));
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MultiMsg_TAG", 2, "upload multi msg pack failed, result.errStr=" + paramawki.b + ",result.errStr=" + paramawki.jdField_a_of_type_JavaLangString);
    }
    this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.extraflag = 32768;
    ((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq);
    paramawki = ((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
    if ((paramawki != null) && (paramawki.uniseq == this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq)) {
      paramawki.extraflag = 32768;
    }
    paramawki = this.jdField_a_of_type_JavaLangString;
    int i = this.jdField_a_of_type_Int;
    long l = this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq;
    ((MessageHandler)((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(0)).notifyUI(MessageHandler.a(this.jdField_a_of_type_Int), false, new Object[] { paramawki, Integer.valueOf(i), Integer.valueOf(-1), null, Long.valueOf(0L), Long.valueOf(l) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aupk
 * JD-Core Version:    0.7.0.1
 */