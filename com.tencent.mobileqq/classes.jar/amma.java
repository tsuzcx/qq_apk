import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class amma
  extends abss
{
  public amma(QQAppInterface paramQQAppInterface, QQMessageFacade paramQQMessageFacade, abtf paramabtf)
  {
    super(paramQQAppInterface, paramQQMessageFacade, paramabtf);
    if (QLog.isColorLevel()) {
      QLog.d("TinyIdMsgMessageManager", 2, "TinyIdMsgMessageManager() called with: app = [" + paramQQAppInterface + "], msgFacade = [" + paramQQMessageFacade + "], msgPool = [" + paramabtf + "]");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amma
 * JD-Core Version:    0.7.0.1
 */