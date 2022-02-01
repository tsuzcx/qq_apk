import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.RecentUser;
import mqq.os.MqqHandler;

public class aoac
{
  public static void a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = paramQQAppInterface.getHandler(Conversation.class);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.sendMessage(paramQQAppInterface.obtainMessage(1009));
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    paramQQAppInterface = paramQQAppInterface.a().a();
    paramString = (RecentUser)paramQQAppInterface.findRecentUser(paramString, 1);
    if (paramString != null) {
      paramQQAppInterface.delRecentUser(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoac
 * JD-Core Version:    0.7.0.1
 */