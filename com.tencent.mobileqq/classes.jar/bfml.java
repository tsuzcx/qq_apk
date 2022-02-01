import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.ConversationInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.QLog;

public class bfml
  implements adbl
{
  public int a(StringBuilder paramStringBuilder)
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
      Object localObject = (RecentUser)localQQAppInterface.a().a().findRecentUser(paramConversationInfo.uin, paramConversationInfo.type);
      if ((localObject != null) && ((((RecentUser)localObject).lFlag & 1L) != 0L))
      {
        localObject = localQQAppInterface.a(true);
        if ((localObject != null) && (!((HotChatManager)localObject).b(paramConversationInfo.uin)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("TroopBlockUnreadMsgNumCallback", 2, "getUnreadMsgsNum invalide hotchat!");
          }
          paramArrayOfBoolean[0] = true;
          return true;
        }
      }
      if (bfmf.a(localQQAppInterface, paramConversationInfo.uin))
      {
        paramArrayOfBoolean[0] = true;
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfml
 * JD-Core Version:    0.7.0.1
 */