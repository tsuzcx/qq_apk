import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.teamwork.spread.TroopFileAIOMsgTips.1;
import com.tencent.qphone.base.util.QLog;

public class axhf
  extends axgt
{
  public axhf(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage, axgz paramaxgz)
  {
    super(paramQQAppInterface, paramChatMessage, paramaxgz);
  }
  
  protected String a()
  {
    return ((MessageForTroopFile)this.a).fileName;
  }
  
  protected void a(axgu paramaxgu)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopFileAIOMsgTips", 1, "getWordsList by TroopFile[" + System.currentTimeMillis() + "]");
    }
    ThreadManager.post(new TroopFileAIOMsgTips.1(this, paramaxgu), 8, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     axhf
 * JD-Core Version:    0.7.0.1
 */