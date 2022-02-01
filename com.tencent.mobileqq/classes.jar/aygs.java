import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;

public class aygs
  extends aygp
{
  protected void b(BaseChatPie paramBaseChatPie)
  {
    try
    {
      l = Long.parseLong(paramBaseChatPie.sessionInfo.curFriendUin);
      aara localaara = (aara)paramBaseChatPie.app.getBusinessHandler(51);
      if ((localaara != null) && (localaara.c(l))) {
        a(paramBaseChatPie.sessionInfo.curType, 206);
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        long l = 0L;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aygs
 * JD-Core Version:    0.7.0.1
 */