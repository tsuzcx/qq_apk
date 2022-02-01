import android.content.Context;
import android.content.Intent;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.matchchat.MatchChatMsgListFragment;
import com.tencent.mobileqq.matchchat.MatchChatMsgUtil.1;
import com.tencent.mobileqq.matchchat.RecentMatchChatListItem;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class awui
{
  public static int a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {}
    do
    {
      return 0;
      if (a(paramQQAppInterface)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("MatchChatMsgUtil", 2, "isMatchChatRedPointSwitchOn false");
    return 0;
    Object localObject = paramQQAppInterface.getMessageProxy(1044).a(AppConstants.MATCH_CHAT_UIN, 1044);
    if (localObject == null)
    {
      QLog.i("MatchChatMsgUtil", 1, "getMatchChatRedPointNum null");
      return 0;
    }
    localObject = ((List)localObject).iterator();
    String str;
    int j;
    for (int i = 0; ((Iterator)localObject).hasNext(); i = paramQQAppInterface.getConversationFacade().a(str, j) + i)
    {
      MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
      str = localMessageRecord.senderuin;
      j = localMessageRecord.istroop;
    }
    return i;
  }
  
  public static Intent a(Context paramContext)
  {
    paramContext = new Intent(paramContext, PublicFragmentActivity.class);
    paramContext.putExtra("uintype", 1044);
    paramContext.putExtra("uin", AppConstants.MATCH_CHAT_UIN);
    paramContext.putExtra("public_fragment_class", MatchChatMsgListFragment.class.getName());
    paramContext.addFlags(268435456);
    return paramContext;
  }
  
  public static Intent a(Context paramContext, String paramString)
  {
    paramContext = a(paramContext);
    paramContext.putExtra("key_matchchat_from_notification", true);
    paramContext.putExtra("key_matchchat_from_notification_uin", paramString);
    paramContext.putExtra("key_matchchat_from_notification_type", 1044);
    return paramContext;
  }
  
  public static Intent a(Context paramContext, String paramString, int paramInt)
  {
    paramContext = new Intent(paramContext, ChatActivity.class);
    paramContext.putExtra("uin", paramString);
    paramContext.putExtra("uintype", 1044);
    paramContext.putExtra("entrance", paramInt);
    paramContext.addFlags(268435456);
    return paramContext;
  }
  
  public static BusinessInfoCheckUpdate.AppInfo a(QQAppInterface paramQQAppInterface, String paramString)
  {
    int i = a(paramQQAppInterface);
    QLog.i("MatchChatMsgUtil", 1, "getMatchChatRedPointAppInfo num = " + i);
    paramQQAppInterface = new BusinessInfoCheckUpdate.AppInfo();
    paramQQAppInterface.path.set(paramString);
    paramQQAppInterface.num.set(i);
    paramQQAppInterface.type.set(2);
    paramQQAppInterface.iNewFlag.set(1);
    return paramQQAppInterface;
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {}
    for (;;)
    {
      return;
      Object localObject = paramQQAppInterface.getMessageProxy(1044).a(AppConstants.MATCH_CHAT_UIN, 1044);
      if (localObject == null)
      {
        QLog.i("MatchChatMsgUtil", 1, "clearMatchChatMessageBox null");
        return;
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
        if (QLog.isColorLevel()) {
          QLog.i("MatchChatMsgUtil", 1, "clearMatchChatMessageBox, delete uin = " + localMessageRecord.senderuin);
        }
        String str = localMessageRecord.senderuin;
        int i = localMessageRecord.istroop;
        paramQQAppInterface.getMessageFacade().clearHistory(str, i);
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, RecentMatchChatListItem paramRecentMatchChatListItem, boolean paramBoolean)
  {
    if ((paramQQAppInterface == null) || (paramRecentMatchChatListItem == null)) {}
    int i;
    do
    {
      return;
      i = paramQQAppInterface.getConversationFacade().a(paramRecentMatchChatListItem.getRecentUserUin(), paramRecentMatchChatListItem.getRecentUserType());
      if (paramBoolean) {
        paramQQAppInterface.getMessageFacade().removeMsgFromMsgBox(AppConstants.MATCH_CHAT_UIN, 1044, paramRecentMatchChatListItem.getRecentUserUin(), paramQQAppInterface.getCurrentAccountUin());
      }
    } while (i <= 0);
    paramQQAppInterface.getMessageFacade().setReaded(paramRecentMatchChatListItem.getRecentUserUin(), paramRecentMatchChatListItem.getRecentUserType(), true, false);
  }
  
  public static void a(RedTouch paramRedTouch, QQAppInterface paramQQAppInterface)
  {
    ThreadManagerV2.excute(new MatchChatMsgUtil.1(paramQQAppInterface, paramRedTouch), 16, null, false);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awui
 * JD-Core Version:    0.7.0.1
 */