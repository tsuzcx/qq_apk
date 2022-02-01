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
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.troop.essence.data.TroopEssenceMsgItem.TroopEssenceMsgItemKey;
import com.tencent.mobileqq.troop.essencemsg.TroopEssenceUtil;
import com.tencent.mobileqq.troop.todo.TroopTodoReportUtils;
import com.tencent.mobileqq.troop.todo.TroopTodoUtils;
import com.tencent.mobileqq.troop.todo.TroopTodoUtils.TroopTodoMsgItemKey;
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
  public static int a = 1;
  public static int b = 2;
  public static int c = 4;
  public static int d = 8;
  public static int e = 16;
  public static int f = 32;
  public static int g = 64;
  public static int h = 128;
  public static int i = 256;
  public static int j = 512;
  public static int k = 1024;
  public static int l = 2048;
  public static int m = 4096;
  public static int n = 8192;
  public static int o = 16384;
  public static int p = 32768;
  public static int q = 65536;
  public static int r = 131072;
  public static HashMap<Integer, QQCustomMenuItem> s = new HashMap();
  
  static
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    s.put(Integer.valueOf(a), new QQCustomMenuItem(2131431492, localBaseApplication.getString(2131888243), 2130839058));
    s.put(Integer.valueOf(b), new QQCustomMenuItem(2131433636, localBaseApplication.getString(2131889668), 2130839066));
    s.put(Integer.valueOf(c), new QQCustomMenuItem(2131438943, localBaseApplication.getString(2131891960), 2130839074));
    s.put(Integer.valueOf(d), new QQCustomMenuItem(2131439015, localBaseApplication.getString(2131892030), 2130839076));
    s.put(Integer.valueOf(e), new QQCustomMenuItem(2131431695, localBaseApplication.getString(2131887718), 2130839061));
    s.put(Integer.valueOf(f), new QQCustomMenuItem(2131432607, localBaseApplication.getString(2131917451), 0));
    s.put(Integer.valueOf(g), new QQCustomMenuItem(2131432608, localBaseApplication.getString(2131917452), 0));
    s.put(Integer.valueOf(h), new QQCustomMenuItem(2131432813, localBaseApplication.getString(2131889171), 2130839065));
    s.put(Integer.valueOf(i), new QQCustomMenuItem(2131449133, localBaseApplication.getString(2131887860), 0));
    s.put(Integer.valueOf(j), new QQCustomMenuItem(2131444634, localBaseApplication.getString(2131895468), 2130839072));
    s.put(Integer.valueOf(k), new QQCustomMenuItem(2131444651, localBaseApplication.getString(2131895474), 2130839072));
    s.put(Integer.valueOf(l), new QQCustomMenuItem(2131428089, localBaseApplication.getString(2131886577), 2130839076));
    s.put(Integer.valueOf(o), new QQCustomMenuItem(2131428089, localBaseApplication.getString(2131886577), 2130839076));
    s.put(Integer.valueOf(m), new QQCustomMenuItem(2131444710, localBaseApplication.getString(2131915632), 2130839073));
    s.put(Integer.valueOf(n), new QQCustomMenuItem(2131430288, localBaseApplication.getString(2131887713), 2130839055));
    s.put(Integer.valueOf(p), new QQCustomMenuItem(2131433658, localBaseApplication.getString(2131889668), 2130839066));
    s.put(Integer.valueOf(q), new QQCustomMenuItem(2131430651, localBaseApplication.getString(2131887753), 0));
    s.put(Integer.valueOf(r), new QQCustomMenuItem(2131430283, localBaseApplication.getString(2131887714), 0));
  }
  
  public static QQCustomMenuItem a(int paramInt)
  {
    return (QQCustomMenuItem)s.get(Integer.valueOf(paramInt));
  }
  
  public static void a(int paramInt, QQCustomMenu paramQQCustomMenu)
  {
    QQCustomMenuItem localQQCustomMenuItem = a(paramInt);
    paramQQCustomMenu.a(localQQCustomMenuItem.b(), localQQCustomMenuItem.a(), localQQCustomMenuItem.c());
  }
  
  public static void a(@NonNull ChatMessage paramChatMessage, @NonNull QQCustomMenu paramQQCustomMenu)
  {
    if ((!AppSetting.o) && (paramChatMessage.istroop == 0)) {
      return;
    }
    if (UinTypeUtil.e(paramChatMessage.istroop) == 1032) {
      return;
    }
    a(e, paramQQCustomMenu);
  }
  
  public static void a(MessageRecord paramMessageRecord, QQCustomMenu paramQQCustomMenu)
  {
    if (BaseApplicationImpl.sProcessId == 1)
    {
      localObject1 = BaseApplicationImpl.getApplication().peekAppRuntime();
      if ((localObject1 != null) && ((localObject1 instanceof QQAppInterface)))
      {
        localObject1 = (QQAppInterface)localObject1;
        break label35;
      }
    }
    Object localObject1 = null;
    label35:
    if (localObject1 == null) {
      return;
    }
    if (!a(paramMessageRecord, (QQAppInterface)localObject1)) {
      return;
    }
    if ((!paramMessageRecord.isSend()) && (!TroopUtils.a((QQAppInterface)localObject1, paramMessageRecord, ((QQAppInterface)localObject1).getCurrentAccountUin()))) {
      return;
    }
    if ((AnonymousChatHelper.c(paramMessageRecord)) && (!TroopAnonyRevokeConfProcessor.a().a)) {
      return;
    }
    if (UinTypeUtil.e(paramMessageRecord.istroop) == 1032) {
      return;
    }
    Object localObject2 = (FriendsManager)((QQAppInterface)localObject1).getManager(QQManagerFactory.FRIENDS_MANAGER);
    if ((paramMessageRecord.istroop == 0) && (!((FriendsManager)localObject2).n(paramMessageRecord.frienduin))) {
      return;
    }
    if (paramMessageRecord.istroop == 1)
    {
      localObject2 = (HotChatManager)((QQAppInterface)localObject1).getManager(QQManagerFactory.HOT_CHAT_MANAGER);
      if ((localObject2 != null) && (((HotChatManager)localObject2).b(paramMessageRecord.frienduin))) {
        return;
      }
    }
    if ((paramMessageRecord.msgtype == -5008) && ((paramMessageRecord instanceof MessageForArkApp)))
    {
      localObject2 = (MessageForArkApp)paramMessageRecord;
      if ((((MessageForArkApp)localObject2).ark_app_message != null) && (((MessageForArkApp)localObject2).ark_app_message.appName.equals("com.tencent.mannounce"))) {
        return;
      }
    }
    if (a(paramMessageRecord))
    {
      a(c, paramQQCustomMenu);
      if (TroopUtils.a((QQAppInterface)localObject1, paramMessageRecord, ((QQAppInterface)localObject1).getCurrentAccountUin()))
      {
        paramQQCustomMenu = new ReportTask((AppRuntime)localObject1).a("dc00899").b("Grp_manage").c("recall_msg").d("exp_recallMsg");
        localObject2 = paramMessageRecord.frienduin;
        if (TroopUtils.a((QQAppInterface)localObject1, paramMessageRecord.frienduin, ((QQAppInterface)localObject1).getCurrentAccountUin())) {
          paramMessageRecord = "1";
        } else {
          paramMessageRecord = "2";
        }
        paramQQCustomMenu.a(new String[] { localObject2, paramMessageRecord }).a();
      }
    }
  }
  
  private static void a(String paramString, QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage, Long paramLong)
  {
    ReportController.b(paramQQAppInterface, "dc00898", "", "", paramString, paramString, 0, 0, String.valueOf(TroopTodoReportUtils.a(paramQQAppInterface, paramLong.longValue())), String.valueOf(TroopTodoReportUtils.a(paramChatMessage)), TroopTodoReportUtils.b(paramChatMessage), "");
  }
  
  private static boolean a(MessageRecord paramMessageRecord)
  {
    int i1 = paramMessageRecord.istroop;
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (i1 != 0)
    {
      bool1 = bool2;
      if (i1 != 1)
      {
        bool1 = bool2;
        if (i1 != 3000)
        {
          bool1 = bool2;
          if (i1 != 1000)
          {
            if (i1 == 1004) {
              return true;
            }
            bool1 = false;
          }
        }
      }
    }
    return bool1;
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
      if (localObject1 == null) {
        return;
      }
      if ((!paramChatMessage.isSend()) && (paramChatMessage.isSupportReply()))
      {
        a(j, paramQQCustomMenu);
        MessageForReplyText.reportReplyMsg((QQAppInterface)localObject1, "Msg_menu", "exp_replyMsg", paramChatMessage.frienduin, paramChatMessage);
        return;
      }
      if ((paramChatMessage.isSend()) && (paramChatMessage.isSupportReply()) && (paramChatMessage.extraflag != 32772) && (paramChatMessage.extraflag != 32768) && (paramChatMessage.istroop != 3000))
      {
        a(j, paramQQCustomMenu);
        MessageForReplyText.reportReplyMsg((QQAppInterface)localObject1, "Msg_menu", "exp_replyMsg", paramChatMessage.frienduin, paramChatMessage);
      }
    }
  }
  
  public static void c(ChatMessage paramChatMessage, QQCustomMenu paramQQCustomMenu)
  {
    if (BaseApplicationImpl.sProcessId == 1)
    {
      Object localObject = BaseApplicationImpl.getApplication().peekAppRuntime();
      if ((localObject != null) && ((localObject instanceof QQAppInterface)))
      {
        localObject = (QQAppInterface)localObject;
        if (paramChatMessage.istroop == 1) {
          if ((!RobotUtils.a((QQAppInterface)localObject, paramChatMessage.senderuin)) && (!AnonymousChatHelper.c(paramChatMessage)) && (!ConfessMsgUtil.b(paramChatMessage)) && (!"1000000".equals(paramChatMessage.senderuin)) && (paramChatMessage.isSupportReply()))
          {
            if (!paramChatMessage.isSend())
            {
              a(k, paramQQCustomMenu);
              return;
            }
            if ((paramChatMessage.isSend()) && (paramChatMessage.extraflag != 32772) && (paramChatMessage.extraflag != 32768)) {
              a(k, paramQQCustomMenu);
            }
          }
          else if (QLog.isColorLevel())
          {
            paramQQCustomMenu = new StringBuilder("addReplyOnlyMenu isRobot=");
            paramQQCustomMenu.append(RobotUtils.a((QQAppInterface)localObject, paramChatMessage.senderuin));
            paramQQCustomMenu.append(" isAnonymousMsg=");
            paramQQCustomMenu.append(AnonymousChatHelper.c(paramChatMessage));
            paramQQCustomMenu.append(" isConfessMsg=");
            paramQQCustomMenu.append(ConfessMsgUtil.b(paramChatMessage));
            paramQQCustomMenu.append(" isNotSupport=");
            paramQQCustomMenu.append(paramChatMessage.isSupportReply() ^ true);
            QLog.d("BaseBubbleBuilderMenuHelper", 2, paramQQCustomMenu.toString());
          }
        }
      }
    }
  }
  
  public static void d(ChatMessage paramChatMessage, QQCustomMenu paramQQCustomMenu)
  {
    if (BaseApplicationImpl.sProcessId == 1)
    {
      localObject = BaseApplicationImpl.getApplication().peekAppRuntime();
      if ((localObject instanceof QQAppInterface))
      {
        localObject = (QQAppInterface)localObject;
        break label36;
      }
    }
    Object localObject = null;
    label36:
    if (localObject == null) {
      return;
    }
    if (paramChatMessage.istroop == 1)
    {
      long l1 = 0L;
      try
      {
        long l2 = Long.parseLong(paramChatMessage.frienduin);
        l1 = l2;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      int i1 = TroopTodoUtils.a((QQAppInterface)localObject, new TroopTodoUtils.TroopTodoMsgItemKey(l1, paramChatMessage.shmsgseq, MessageUtils.b(paramChatMessage.msgUid)), paramChatMessage, l1);
      if (i1 == 2)
      {
        a(r, paramQQCustomMenu);
        a("0X800BC6E", (QQAppInterface)localObject, paramChatMessage, Long.valueOf(l1));
        return;
      }
      if (i1 == 1)
      {
        a(q, paramQQCustomMenu);
        a("0X800BC6C", (QQAppInterface)localObject, paramChatMessage, Long.valueOf(l1));
      }
    }
  }
  
  public static void e(ChatMessage paramChatMessage, QQCustomMenu paramQQCustomMenu)
  {
    if (BaseApplicationImpl.sProcessId == 1)
    {
      localObject = BaseApplicationImpl.getApplication().peekAppRuntime();
      if ((localObject != null) && ((localObject instanceof QQAppInterface)))
      {
        localObject = (QQAppInterface)localObject;
        break label41;
      }
    }
    Object localObject = null;
    label41:
    if (localObject == null) {
      return;
    }
    if (paramChatMessage.istroop == 1)
    {
      long l1 = 0L;
      try
      {
        long l2 = Long.parseLong(paramChatMessage.frienduin);
        l1 = l2;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      int i1 = TroopEssenceUtil.a((QQAppInterface)localObject, new TroopEssenceMsgItem.TroopEssenceMsgItemKey(l1, paramChatMessage.shmsgseq, MessageUtils.b(paramChatMessage.msgUid)), paramChatMessage);
      if (i1 == 2)
      {
        a(g, paramQQCustomMenu);
        return;
      }
      if (i1 == 1) {
        a(f, paramQQCustomMenu);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.BaseBubbleBuilderMenuHelper
 * JD-Core Version:    0.7.0.1
 */