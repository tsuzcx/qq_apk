import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForScribble;
import com.tencent.mobileqq.scribble.ScribbleBaseOperator.1;
import com.tencent.qphone.base.util.QLog;

public class awgs
{
  public QQAppInterface a;
  
  public awgs(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  public MessageForScribble a(MessageForScribble paramMessageForScribble)
  {
    MessageForScribble localMessageForScribble = (MessageForScribble)axaq.a(paramMessageForScribble);
    if (localMessageForScribble == null) {
      QLog.e("CreateResendScribbleMsg", 2, "null msg");
    }
    if (localMessageForScribble != null)
    {
      localMessageForScribble.offSet = paramMessageForScribble.offSet;
      localMessageForScribble.gifId = paramMessageForScribble.gifId;
      localMessageForScribble.localFildPath = paramMessageForScribble.localFildPath;
      localMessageForScribble.combineFileMd5 = paramMessageForScribble.combineFileMd5;
      localMessageForScribble.isread = true;
      localMessageForScribble.fileUploadStatus = 0;
    }
    return localMessageForScribble;
  }
  
  public MessageForScribble a(String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2, int paramInt3)
  {
    MessageForScribble localMessageForScribble = (MessageForScribble)axaq.a(-7001);
    axaq.a(this.a, localMessageForScribble, paramString3, paramString3, paramInt2);
    localMessageForScribble.msgtype = -7001;
    localMessageForScribble.offSet = paramInt1;
    localMessageForScribble.gifId = paramInt3;
    localMessageForScribble.localFildPath = paramString1;
    localMessageForScribble.combineFileMd5 = paramString2;
    localMessageForScribble.selfuin = this.a.getCurrentAccountUin();
    localMessageForScribble.senderuin = localMessageForScribble.selfuin;
    localMessageForScribble.issend = 1;
    localMessageForScribble.fileUploadStatus = 0;
    return localMessageForScribble;
  }
  
  public boolean a(MessageForScribble paramMessageForScribble)
  {
    ThreadManager.post(new ScribbleBaseOperator.1(this, paramMessageForScribble), 8, null, false);
    return true;
  }
  
  public boolean a(MessageForScribble paramMessageForScribble, aumy paramaumy)
  {
    aywa localaywa = new aywa();
    localaywa.jdField_a_of_type_Boolean = false;
    localaywa.jdField_b_of_type_Int = 262153;
    localaywa.jdField_b_of_type_JavaLangString = paramMessageForScribble.selfuin;
    localaywa.c = paramMessageForScribble.frienduin;
    localaywa.jdField_a_of_type_Int = paramMessageForScribble.istroop;
    localaywa.jdField_a_of_type_Long = paramMessageForScribble.uniseq;
    localaywa.jdField_a_of_type_Aumy = paramaumy;
    localaywa.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramMessageForScribble;
    this.a.a().a(localaywa);
    return true;
  }
  
  public boolean a(MessageForScribble paramMessageForScribble, String paramString, auoo paramauoo)
  {
    aywa localaywa = new aywa();
    localaywa.jdField_a_of_type_Boolean = true;
    localaywa.jdField_b_of_type_Int = 262153;
    localaywa.jdField_b_of_type_JavaLangString = paramMessageForScribble.selfuin;
    localaywa.c = paramMessageForScribble.frienduin;
    localaywa.jdField_a_of_type_Int = paramMessageForScribble.istroop;
    localaywa.jdField_a_of_type_Long = paramMessageForScribble.uniseq;
    localaywa.jdField_a_of_type_Auoo = paramauoo;
    localaywa.i = paramString;
    localaywa.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramMessageForScribble;
    paramMessageForScribble.fileUploadStatus = 3;
    this.a.a().a(localaywa);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     awgs
 * JD-Core Version:    0.7.0.1
 */