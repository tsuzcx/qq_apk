import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.RecentUser;
import mqq.os.MqqHandler;

public class anwq
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
    paramQQAppInterface = paramQQAppInterface.getProxyManager().a();
    paramString = (RecentUser)paramQQAppInterface.findRecentUser(paramString, 1);
    if (paramString != null) {
      paramQQAppInterface.delRecentUser(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anwq
 * JD-Core Version:    0.7.0.1
 */