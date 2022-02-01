import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class anmq
  extends abwe
{
  public anmq(QQAppInterface paramQQAppInterface, QQMessageFacade paramQQMessageFacade, abww paramabww)
  {
    super(paramQQAppInterface, paramQQMessageFacade, paramabww);
    if (QLog.isColorLevel()) {
      QLog.d("TinyIdMsgMessageManager", 2, "TinyIdMsgMessageManager() called with: app = [" + paramQQAppInterface + "], msgFacade = [" + paramQQMessageFacade + "], msgPool = [" + paramabww + "]");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anmq
 * JD-Core Version:    0.7.0.1
 */