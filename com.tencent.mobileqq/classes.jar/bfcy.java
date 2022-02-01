import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.ConversationInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.QLog;

public class bfcy
  implements acoi
{
  public int a(String paramString, StringBuilder paramStringBuilder)
  {
    return 0;
  }
  
  public boolean a(ConversationInfo paramConversationInfo)
  {
    return false;
  }
  
  public boolean a(ConversationInfo paramConversationInfo, boolean[] paramArrayOfBoolean)
  {
    if (paramConversationInfo.type == 1)
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (localQQAppInterface == null) {
        return false;
      }
      Object localObject = (RecentUser)localQQAppInterface.getProxyManager().a().findRecentUser(paramConversationInfo.uin, paramConversationInfo.type);
      if ((localObject != null) && ((((RecentUser)localObject).lFlag & 1L) != 0L))
      {
        localObject = localQQAppInterface.getHotChatMng(true);
        if ((localObject != null) && (!((HotChatManager)localObject).b(paramConversationInfo.uin)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("TroopBlockUnreadMsgNumCallback", 2, "getUnreadMsgsNum invalide hotchat!");
          }
          paramArrayOfBoolean[0] = true;
          return true;
        }
      }
      if (bfcs.a(localQQAppInterface, paramConversationInfo.uin))
      {
        paramArrayOfBoolean[0] = true;
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfcy
 * JD-Core Version:    0.7.0.1
 */