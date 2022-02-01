import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.teamwork.spread.TroopFileAIOMsgTips.1;
import com.tencent.qphone.base.util.QLog;

public class beef
  extends bedt
{
  public beef(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage, bedz parambedz)
  {
    super(paramQQAppInterface, paramChatMessage, parambedz);
  }
  
  protected String a()
  {
    return ((MessageForTroopFile)this.a).fileName;
  }
  
  protected void a(bedu parambedu)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopFileAIOMsgTips", 1, "getWordsList by TroopFile[" + System.currentTimeMillis() + "]");
    }
    ThreadManager.post(new TroopFileAIOMsgTips.1(this, parambedu), 8, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beef
 * JD-Core Version:    0.7.0.1
 */