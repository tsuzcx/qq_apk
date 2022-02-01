package com.tencent.mobileqq.activity.aio;

import android.content.Context;
import android.support.annotation.NonNull;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.confess.ConfessMsgUtil;
import com.tencent.mobileqq.config.business.GeneralDataBean;
import com.tencent.mobileqq.config.business.TroopAnonyRevokeConfProcessor;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.troop.api.essence.data.TroopEssenceMsgItem.TroopEssenceMsgItemKey;
import com.tencent.mobileqq.troop.essencemsg.TroopEssenceUtil;
import com.tencent.mobileqq.troop.utils.RobotUtils;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.AppRuntime;

public class BaseBubbleBuilderMenuHelper
{
  public static int a;
  public static HashMap<Integer, QQCustomMenuItem> a;
  public static int b;
  public static int c;
  public static int d;
  public static int e;
  public static int f;
  public static int g;
  public static int h;
  public static int i;
  public static int j;
  public static int k;
  public static int l;
  public static int m;
  public static int n;
  public static int o;
  public static int p;
  
  static
  {
    jdField_a_of_type_Int = 1;
    b = 2;
    c = 4;
    d = 8;
    e = 16;
    f = 32;
    g = 64;
    h = 128;
    i = 256;
    j = 512;
    k = 1024;
    l = 2048;
    m = 4096;
    n = 4096;
    o = 4096;
    p = 4096;
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(jdField_a_of_type_Int), new QQCustomMenuItem(2131365448, localBaseApplication.getString(2131691371), 2130839051));
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(b), new QQCustomMenuItem(2131367398, localBaseApplication.getString(2131692687), 2130839059));
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(c), new QQCustomMenuItem(2131371954, localBaseApplication.getString(2131694357), 2130839067));
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(d), new QQCustomMenuItem(2131371997, localBaseApplication.getString(2131694391), 2130839069));
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(e), new QQCustomMenuItem(2131365636, localBaseApplication.getString(2131690860), 2130839054));
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(f), new QQCustomMenuItem(2131366427, localBaseApplication.getString(2131720114), 0));
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(g), new QQCustomMenuItem(2131366428, localBaseApplication.getString(2131720115), 0));
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(h), new QQCustomMenuItem(2131366625, localBaseApplication.getString(2131692258), 2130839058));
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(i), new QQCustomMenuItem(2131380949, localBaseApplication.getString(2131691001), 0));
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(j), new QQCustomMenuItem(2131376927, localBaseApplication.getString(2131697689), 2130839065));
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(k), new QQCustomMenuItem(2131376940, localBaseApplication.getString(2131697695), 2130839065));
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(l), new QQCustomMenuItem(2131362524, localBaseApplication.getString(2131690021), 2130839069));
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(o), new QQCustomMenuItem(2131362524, localBaseApplication.getString(2131690021), 2130839069));
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(m), new QQCustomMenuItem(2131376982, localBaseApplication.getString(2131718489), 2130839066));
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(n), new QQCustomMenuItem(2131364373, localBaseApplication.getString(2131690859), 2130839048));
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(p), new QQCustomMenuItem(2131367420, localBaseApplication.getString(2131692687), 2130839059));
  }
  
  public static QQCustomMenuItem a(int paramInt)
  {
    return (QQCustomMenuItem)jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
  }
  
  public static void a(int paramInt, QQCustomMenu paramQQCustomMenu)
  {
    QQCustomMenuItem localQQCustomMenuItem = a(paramInt);
    paramQQCustomMenu.a(localQQCustomMenuItem.a(), localQQCustomMenuItem.a(), localQQCustomMenuItem.b());
  }
  
  public static void a(@NonNull ChatMessage paramChatMessage, @NonNull QQCustomMenu paramQQCustomMenu)
  {
    if ((!AppSetting.j) && (paramChatMessage.istroop == 0)) {}
    while (UinTypeUtil.a(paramChatMessage.istroop) == 1032) {
      return;
    }
    a(e, paramQQCustomMenu);
  }
  
  public static void a(MessageRecord paramMessageRecord, QQCustomMenu paramQQCustomMenu)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (BaseApplicationImpl.sProcessId == 1)
    {
      AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().peekAppRuntime();
      localObject1 = localObject2;
      if (localAppRuntime != null)
      {
        localObject1 = localObject2;
        if ((localAppRuntime instanceof QQAppInterface)) {
          localObject1 = (QQAppInterface)localAppRuntime;
        }
      }
    }
    if (localObject1 == null) {}
    label46:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              break label46;
              break label46;
              break label46;
              do
              {
                return;
              } while ((!a(paramMessageRecord, (QQAppInterface)localObject1)) || ((!paramMessageRecord.isSend()) && (!TroopUtils.a((QQAppInterface)localObject1, paramMessageRecord, ((QQAppInterface)localObject1).getCurrentAccountUin()))) || ((AnonymousChatHelper.a(paramMessageRecord)) && (!TroopAnonyRevokeConfProcessor.a().a)) || (UinTypeUtil.a(paramMessageRecord.istroop) == 1032));
              localObject2 = (FriendsManager)((QQAppInterface)localObject1).getManager(QQManagerFactory.FRIENDS_MANAGER);
            } while ((paramMessageRecord.istroop == 0) && (!((FriendsManager)localObject2).b(paramMessageRecord.frienduin)));
            if (paramMessageRecord.istroop != 1) {
              break;
            }
            localObject2 = (HotChatManager)((QQAppInterface)localObject1).getManager(QQManagerFactory.HOT_CHAT_MANAGER);
          } while ((localObject2 != null) && (((HotChatManager)localObject2).b(paramMessageRecord.frienduin)));
          if ((paramMessageRecord.msgtype != -5008) || (!(paramMessageRecord instanceof MessageForArkApp))) {
            break;
          }
          localObject2 = (MessageForArkApp)paramMessageRecord;
        } while ((((MessageForArkApp)localObject2).ark_app_message != null) && (((MessageForArkApp)localObject2).ark_app_message.appName.equals("com.tencent.mannounce")));
      } while (!a(paramMessageRecord));
      a(c, paramQQCustomMenu);
    } while (!TroopUtils.a((QQAppInterface)localObject1, paramMessageRecord, ((QQAppInterface)localObject1).getCurrentAccountUin()));
    paramQQCustomMenu = new ReportTask((QQAppInterface)localObject1).a("dc00899").b("Grp_manage").c("recall_msg").d("exp_recallMsg");
    localObject2 = paramMessageRecord.frienduin;
    if (TroopUtils.a((QQAppInterface)localObject1, paramMessageRecord.frienduin, ((QQAppInterface)localObject1).getCurrentAccountUin())) {}
    for (paramMessageRecord = "1";; paramMessageRecord = "2")
    {
      paramQQCustomMenu.a(new String[] { localObject2, paramMessageRecord }).a();
      return;
    }
  }
  
  private static boolean a(MessageRecord paramMessageRecord)
  {
    int i1 = paramMessageRecord.istroop;
    return (i1 == 0) || (i1 == 1) || (i1 == 3000) || (i1 == 1000) || (i1 == 1004);
  }
  
  public static boolean a(MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    long l1 = NetConnInfoCenter.getServerTimeMillis();
    boolean bool = TroopUtils.c(paramQQAppInterface, paramMessageRecord, paramQQAppInterface.getCurrentAccountUin());
    return ((l1 - paramMessageRecord.time * 1000L < 120000L) && (!bool)) || ((bool) && (paramMessageRecord.isSend())) || (paramMessageRecord.msgtype == -2005) || (TroopUtils.a(paramQQAppInterface, paramMessageRecord, paramQQAppInterface.getCurrentAccountUin()));
  }
  
  public static void b(@NonNull ChatMessage paramChatMessage, @NonNull QQCustomMenu paramQQCustomMenu)
  {
    if ((paramChatMessage.istroop == 1) || (paramChatMessage.istroop == 3000) || (paramChatMessage.istroop == 0))
    {
      if (BaseApplicationImpl.sProcessId != 1) {
        break label164;
      }
      localObject = BaseApplicationImpl.getApplication().peekAppRuntime();
      if ((localObject == null) || (!(localObject instanceof QQAppInterface))) {
        break label164;
      }
    }
    label164:
    for (Object localObject = (QQAppInterface)localObject;; localObject = null)
    {
      if (localObject == null) {}
      do
      {
        return;
        if ((!paramChatMessage.isSend()) && (paramChatMessage.isSupportReply()))
        {
          a(j, paramQQCustomMenu);
          MessageForReplyText.reportReplyMsg((QQAppInterface)localObject, "Msg_menu", "exp_replyMsg", paramChatMessage.frienduin, paramChatMessage);
          return;
        }
      } while ((!paramChatMessage.isSend()) || (!paramChatMessage.isSupportReply()) || (paramChatMessage.extraflag == 32772) || (paramChatMessage.extraflag == 32768) || (paramChatMessage.istroop == 3000));
      a(j, paramQQCustomMenu);
      MessageForReplyText.reportReplyMsg((QQAppInterface)localObject, "Msg_menu", "exp_replyMsg", paramChatMessage.frienduin, paramChatMessage);
      return;
    }
  }
  
  public static void c(ChatMessage paramChatMessage, QQCustomMenu paramQQCustomMenu)
  {
    boolean bool;
    if (BaseApplicationImpl.sProcessId == 1)
    {
      Object localObject = BaseApplicationImpl.getApplication().peekAppRuntime();
      if ((localObject != null) && ((localObject instanceof QQAppInterface)))
      {
        localObject = (QQAppInterface)localObject;
        if (paramChatMessage.istroop == 1)
        {
          if ((!RobotUtils.b((QQAppInterface)localObject, paramChatMessage.senderuin)) && (!AnonymousChatHelper.a(paramChatMessage)) && (!ConfessMsgUtil.a(paramChatMessage)) && (!"1000000".equals(paramChatMessage.senderuin)) && (paramChatMessage.isSupportReply())) {
            break label173;
          }
          if (QLog.isColorLevel())
          {
            paramQQCustomMenu = new StringBuilder("addReplyOnlyMenu isRobot=").append(RobotUtils.b((QQAppInterface)localObject, paramChatMessage.senderuin)).append(" isAnonymousMsg=").append(AnonymousChatHelper.a(paramChatMessage)).append(" isConfessMsg=").append(ConfessMsgUtil.a(paramChatMessage)).append(" isNotSupport=");
            if (paramChatMessage.isSupportReply()) {
              break label168;
            }
            bool = true;
            QLog.d("BaseBubbleBuilderMenuHelper", 2, bool);
          }
        }
      }
    }
    label168:
    label173:
    do
    {
      return;
      bool = false;
      break;
      if (!paramChatMessage.isSend())
      {
        a(k, paramQQCustomMenu);
        return;
      }
    } while ((!paramChatMessage.isSend()) || (paramChatMessage.extraflag == 32772) || (paramChatMessage.extraflag == 32768));
    a(k, paramQQCustomMenu);
  }
  
  public static void d(ChatMessage paramChatMessage, QQCustomMenu paramQQCustomMenu)
  {
    if (BaseApplicationImpl.sProcessId == 1)
    {
      localObject = BaseApplicationImpl.getApplication().peekAppRuntime();
      if ((localObject == null) || (!(localObject instanceof QQAppInterface))) {}
    }
    for (Object localObject = (QQAppInterface)localObject;; localObject = null)
    {
      if (localObject == null) {}
      int i1;
      do
      {
        do
        {
          return;
        } while (paramChatMessage.istroop != 1);
        long l1 = 0L;
        try
        {
          long l2 = Long.parseLong(paramChatMessage.frienduin);
          l1 = l2;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
          }
        }
        i1 = TroopEssenceUtil.a((QQAppInterface)localObject, new TroopEssenceMsgItem.TroopEssenceMsgItemKey(l1, paramChatMessage.shmsgseq, MessageUtils.b(paramChatMessage.msgUid)), paramChatMessage);
        if (i1 == 2)
        {
          a(g, paramQQCustomMenu);
          return;
        }
      } while (i1 != 1);
      a(f, paramQQCustomMenu);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.BaseBubbleBuilderMenuHelper
 * JD-Core Version:    0.7.0.1
 */