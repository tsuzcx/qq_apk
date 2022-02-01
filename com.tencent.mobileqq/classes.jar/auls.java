import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.qphone.base.util.QLog;

public abstract class auls
{
  protected ault a;
  protected QQAppInterface a;
  protected ChatMessage a;
  
  public auls(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramChatMessage;
  }
  
  public static auls a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    if (paramChatMessage == null)
    {
      QLog.e("QFileSaveModel<QFile>", 1, "buildFileSaveModel: message is null");
      return null;
    }
    if ((paramChatMessage instanceof MessageForFile)) {
      return new aulm(paramQQAppInterface, paramChatMessage);
    }
    if ((paramChatMessage instanceof MessageForTroopFile)) {
      return new aulv(paramQQAppInterface, paramChatMessage);
    }
    QLog.e("QFileSaveModel<QFile>", 1, "buildFileSaveModel: message is not support. messageType[" + paramChatMessage.getClass().getName() + "]");
    return null;
  }
  
  public abstract long a();
  
  public abstract aulp a();
  
  public abstract String a();
  
  public void a(ault paramault)
  {
    this.jdField_a_of_type_Ault = paramault;
  }
  
  public abstract boolean a();
  
  public abstract String b();
  
  public abstract boolean b();
  
  public abstract boolean c();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auls
 * JD-Core Version:    0.7.0.1
 */