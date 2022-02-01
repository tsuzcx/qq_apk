import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ConversationInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.gamecenter.message.TinyInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;

public class avdw
{
  public static avdw a()
  {
    return avdy.a;
  }
  
  private boolean a(ConversationInfo paramConversationInfo)
  {
    if (TextUtils.isEmpty(paramConversationInfo.extString))
    {
      QLog.d("Q.tiny_msg.unread.TinyConvProxy", 2, "isValid() called, info is invalid!" + paramConversationInfo);
      return false;
    }
    if ((paramConversationInfo.tinyInfo == null) || (TextUtils.isEmpty(paramConversationInfo.tinyInfo.fromRoleId)) || (TextUtils.isEmpty(paramConversationInfo.tinyInfo.toRoleId)))
    {
      QLog.d("Q.tiny_msg.unread.TinyConvProxy", 2, "isValid() called, info is invalid!" + paramConversationInfo);
      return false;
    }
    return true;
  }
  
  @Nullable
  public ConversationInfo a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    if (paramQQAppInterface == null)
    {
      paramQQAppInterface = null;
      return paramQQAppInterface;
    }
    ConversationInfo localConversationInfo = paramQQAppInterface.getConversationFacade().a(paramString, paramInt);
    if (localConversationInfo != null)
    {
      paramQQAppInterface = paramQQAppInterface.getMessageProxy(10007).a(paramString, paramInt);
      if (paramQQAppInterface == null) {
        break label116;
      }
      paramString = paramQQAppInterface.getExtInfoFromExtStr("ext_key_game_msg_info");
      if (!TextUtils.isEmpty(paramString))
      {
        localConversationInfo.tinyInfo = new TinyInfo(paramString, paramQQAppInterface.isSend());
        localConversationInfo.extString = paramString;
      }
    }
    for (;;)
    {
      paramQQAppInterface = localConversationInfo;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.tiny_msg.unread.TinyConvProxy", 2, "getTinyConvInfo info = " + localConversationInfo);
      return localConversationInfo;
      label116:
      if (!TextUtils.isEmpty(localConversationInfo.extString)) {
        localConversationInfo.tinyInfo = new TinyInfo(localConversationInfo.extString);
      }
    }
  }
  
  public List<ConversationInfo> a(QQAppInterface paramQQAppInterface)
  {
    Object localObject = paramQQAppInterface.getConversationFacade().a();
    ArrayList localArrayList = new ArrayList();
    localObject = ((Set)localObject).iterator();
    label241:
    while (((Iterator)localObject).hasNext())
    {
      ConversationInfo localConversationInfo = (ConversationInfo)((Iterator)localObject).next();
      if (localConversationInfo.type == 10007)
      {
        MessageRecord localMessageRecord = paramQQAppInterface.getMessageProxy(10007).a(localConversationInfo.uin, localConversationInfo.type);
        if (localMessageRecord != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.tiny_msg.unread.TinyConvProxy", 2, "getTinyConvInfoList item = " + localMessageRecord.getBaseInfoString());
          }
          String str = localMessageRecord.getExtInfoFromExtStr("ext_key_game_msg_info");
          if (!TextUtils.isEmpty(str))
          {
            localConversationInfo.extString = str;
            localConversationInfo.tinyInfo = new TinyInfo(str, localMessageRecord.isSend());
          }
        }
        for (;;)
        {
          if (!a(localConversationInfo)) {
            break label241;
          }
          localArrayList.add(localConversationInfo);
          break;
          if (!TextUtils.isEmpty(localConversationInfo.extString))
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.tiny_msg.unread.TinyConvProxy", 2, "getTinyConvInfoList info = " + localConversationInfo);
            }
            localConversationInfo.tinyInfo = new TinyInfo(localConversationInfo.extString);
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.tiny_msg.unread.TinyConvProxy", 2, "getTinyConvInfoList mock before = " + localArrayList);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.tiny_msg.unread.TinyConvProxy", 2, "getTinyConvInfoList size = " + localArrayList.size());
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avdw
 * JD-Core Version:    0.7.0.1
 */