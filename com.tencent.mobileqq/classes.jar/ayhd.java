import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.teamwork.spread.BuddyFileAIOMsgTips.1;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class ayhd
  extends aygz
{
  public ayhd(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage, ayhf paramayhf)
  {
    super(paramQQAppInterface, paramChatMessage, paramayhf);
  }
  
  protected String a()
  {
    return ((MessageForFile)this.a).fileName;
  }
  
  protected void a(ayha paramayha)
  {
    if (QLog.isColorLevel()) {
      QLog.i("BuddyFileAIOMsgTips", 1, "getWordsList by buddyFile[" + System.currentTimeMillis() + "]");
    }
    ThreadManager.getUIHandler().post(new BuddyFileAIOMsgTips.1(this, paramayha));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ayhd
 * JD-Core Version:    0.7.0.1
 */