import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.qphone.base.util.QLog;

public abstract class apsl
{
  protected apsm a;
  protected QQAppInterface a;
  protected ChatMessage a;
  
  public apsl(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramChatMessage;
  }
  
  public static apsl a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    if (paramChatMessage == null)
    {
      QLog.e("QFileSaveModel<QFile>", 1, "buildFileSaveModel: message is null");
      return null;
    }
    if ((paramChatMessage instanceof MessageForFile)) {
      return new apsf(paramQQAppInterface, paramChatMessage);
    }
    if ((paramChatMessage instanceof MessageForTroopFile)) {
      return new apso(paramQQAppInterface, paramChatMessage);
    }
    QLog.e("QFileSaveModel<QFile>", 1, "buildFileSaveModel: message is not support. messageType[" + paramChatMessage.getClass().getName() + "]");
    return null;
  }
  
  public abstract long a();
  
  public abstract apsi a();
  
  public abstract String a();
  
  public void a(apsm paramapsm)
  {
    this.jdField_a_of_type_Apsm = paramapsm;
  }
  
  public abstract boolean a();
  
  public abstract String b();
  
  public abstract boolean b();
  
  public abstract boolean c();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apsl
 * JD-Core Version:    0.7.0.1
 */