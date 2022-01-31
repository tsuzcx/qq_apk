import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.teamwork.spread.BuddyFileAIOMsgTips.1;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class baez
  extends baev
{
  public baez(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage, bafb parambafb)
  {
    super(paramQQAppInterface, paramChatMessage, parambafb);
  }
  
  protected String a()
  {
    return ((MessageForFile)this.a).fileName;
  }
  
  protected void a(baew parambaew)
  {
    if (QLog.isColorLevel()) {
      QLog.i("BuddyFileAIOMsgTips", 1, "getWordsList by buddyFile[" + System.currentTimeMillis() + "]");
    }
    ThreadManager.getUIHandler().post(new BuddyFileAIOMsgTips.1(this, parambaew));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baez
 * JD-Core Version:    0.7.0.1
 */