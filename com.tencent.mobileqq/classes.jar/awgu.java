import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForScribble;
import com.tencent.mobileqq.scribble.ScribbleBaseOperator.1;
import com.tencent.qphone.base.util.QLog;

public class awgu
{
  public QQAppInterface a;
  
  public awgu(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  public MessageForScribble a(MessageForScribble paramMessageForScribble)
  {
    MessageForScribble localMessageForScribble = (MessageForScribble)axas.a(paramMessageForScribble);
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
    MessageForScribble localMessageForScribble = (MessageForScribble)axas.a(-7001);
    axas.a(this.a, localMessageForScribble, paramString3, paramString3, paramInt2);
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
  
  public boolean a(MessageForScribble paramMessageForScribble, auna paramauna)
  {
    aywc localaywc = new aywc();
    localaywc.jdField_a_of_type_Boolean = false;
    localaywc.jdField_b_of_type_Int = 262153;
    localaywc.jdField_b_of_type_JavaLangString = paramMessageForScribble.selfuin;
    localaywc.c = paramMessageForScribble.frienduin;
    localaywc.jdField_a_of_type_Int = paramMessageForScribble.istroop;
    localaywc.jdField_a_of_type_Long = paramMessageForScribble.uniseq;
    localaywc.jdField_a_of_type_Auna = paramauna;
    localaywc.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramMessageForScribble;
    this.a.a().a(localaywc);
    return true;
  }
  
  public boolean a(MessageForScribble paramMessageForScribble, String paramString, auoq paramauoq)
  {
    aywc localaywc = new aywc();
    localaywc.jdField_a_of_type_Boolean = true;
    localaywc.jdField_b_of_type_Int = 262153;
    localaywc.jdField_b_of_type_JavaLangString = paramMessageForScribble.selfuin;
    localaywc.c = paramMessageForScribble.frienduin;
    localaywc.jdField_a_of_type_Int = paramMessageForScribble.istroop;
    localaywc.jdField_a_of_type_Long = paramMessageForScribble.uniseq;
    localaywc.jdField_a_of_type_Auoq = paramauoq;
    localaywc.i = paramString;
    localaywc.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramMessageForScribble;
    paramMessageForScribble.fileUploadStatus = 3;
    this.a.a().a(localaywc);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     awgu
 * JD-Core Version:    0.7.0.1
 */