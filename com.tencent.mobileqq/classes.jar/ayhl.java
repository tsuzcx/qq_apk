import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.teamwork.spread.TroopFileAIOMsgTips.1;
import com.tencent.qphone.base.util.QLog;

public class ayhl
  extends aygz
{
  public ayhl(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage, ayhf paramayhf)
  {
    super(paramQQAppInterface, paramChatMessage, paramayhf);
  }
  
  protected String a()
  {
    return ((MessageForTroopFile)this.a).fileName;
  }
  
  protected void a(ayha paramayha)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopFileAIOMsgTips", 1, "getWordsList by TroopFile[" + System.currentTimeMillis() + "]");
    }
    ThreadManager.post(new TroopFileAIOMsgTips.1(this, paramayha), 8, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ayhl
 * JD-Core Version:    0.7.0.1
 */