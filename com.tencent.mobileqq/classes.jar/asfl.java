import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.message.QQMessageFacade;
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

public class asfl
{
  public static int a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {}
    do
    {
      do
      {
        return 0;
        if (a(paramQQAppInterface)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("MatchChatMsgUtil", 2, "isMatchChatRedPointSwitchOn false");
      return 0;
      if (a(paramQQAppInterface, "matchchat_redpoint_show")) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("MatchChatMsgUtil", 2, "isRedPointShow false");
    return 0;
    Object localObject = paramQQAppInterface.a(1044).a(ajsd.aT, 1044);
    if (localObject == null)
    {
      QLog.i("MatchChatMsgUtil", 1, "getMatchChatRedPointNum null");
      return 0;
    }
    localObject = ((List)localObject).iterator();
    String str;
    for (int i = 0; ((Iterator)localObject).hasNext(); i = paramQQAppInterface.a().a(str, 1044) + i) {
      str = ((MessageRecord)((Iterator)localObject).next()).senderuin;
    }
    return i;
  }
  
  public static Intent a(Context paramContext)
  {
    paramContext = new Intent(paramContext, PublicFragmentActivity.class);
    paramContext.putExtra("uintype", 1044);
    paramContext.putExtra("uin", ajsd.aT);
    paramContext.putExtra("public_fragment_class", MatchChatMsgListFragment.class.getName());
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
      Object localObject1 = paramQQAppInterface.a(1044).a(ajsd.aT, 1044);
      if (localObject1 == null)
      {
        QLog.i("MatchChatMsgUtil", 1, "clearMatchChatMessageBox null");
        return;
      }
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (MessageRecord)((Iterator)localObject1).next();
        if (QLog.isColorLevel()) {
          QLog.i("MatchChatMsgUtil", 1, "clearMatchChatMessageBox, delete uin = " + ((MessageRecord)localObject2).senderuin);
        }
        localObject2 = ((MessageRecord)localObject2).senderuin;
        paramQQAppInterface.a().a((String)localObject2, 1044);
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
      i = paramQQAppInterface.a().a(paramRecentMatchChatListItem.a(), paramRecentMatchChatListItem.a());
      if (paramBoolean) {
        paramQQAppInterface.a().a(ajsd.aT, 1044, paramRecentMatchChatListItem.a(), paramQQAppInterface.getCurrentAccountUin());
      }
    } while (i <= 0);
    paramQQAppInterface.a().a(paramRecentMatchChatListItem.a(), paramRecentMatchChatListItem.a(), true, false);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("MatchChatMsgUtil", 2, "saveRedPointShow key =" + paramString + " value =" + paramString);
    }
    bbkb.a(paramQQAppInterface.getAccount(), "match_chat_config_sp").edit().putBoolean(paramString, paramBoolean).apply();
  }
  
  public static void a(RedTouch paramRedTouch, QQAppInterface paramQQAppInterface)
  {
    ThreadManagerV2.excute(new MatchChatMsgUtil.1(paramQQAppInterface, paramRedTouch), 16, null, false);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    return true;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramQQAppInterface == null) {
      return false;
    }
    return bbkb.a(paramQQAppInterface.getAccount(), "match_chat_config_sp").getBoolean(paramString, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     asfl
 * JD-Core Version:    0.7.0.1
 */