import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.teamwork.spread.TroopFileAIOMsgTips.1;
import com.tencent.qphone.base.util.QLog;

public class bafh
  extends baev
{
  public bafh(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage, bafb parambafb)
  {
    super(paramQQAppInterface, paramChatMessage, parambafb);
  }
  
  protected String a()
  {
    return ((MessageForTroopFile)this.a).fileName;
  }
  
  protected void a(baew parambaew)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopFileAIOMsgTips", 1, "getWordsList by TroopFile[" + System.currentTimeMillis() + "]");
    }
    ThreadManager.post(new TroopFileAIOMsgTips.1(this, parambaew), 8, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bafh
 * JD-Core Version:    0.7.0.1
 */