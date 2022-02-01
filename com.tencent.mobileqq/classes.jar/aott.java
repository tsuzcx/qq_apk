import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class aott
  extends aczu
{
  public aott(QQAppInterface paramQQAppInterface, QQMessageFacade paramQQMessageFacade, adah paramadah)
  {
    super(paramQQAppInterface, paramQQMessageFacade, paramadah);
    if (QLog.isColorLevel()) {
      QLog.d("TinyIdMsgMessageManager", 2, "TinyIdMsgMessageManager() called with: app = [" + paramQQAppInterface + "], msgFacade = [" + paramQQMessageFacade + "], msgPool = [" + paramadah + "]");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aott
 * JD-Core Version:    0.7.0.1
 */