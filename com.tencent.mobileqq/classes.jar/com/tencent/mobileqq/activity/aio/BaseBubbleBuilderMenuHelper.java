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
import com.tencent.mobileqq.troop.essence.data.TroopEssenceMsgItem.TroopEssenceMsgItemKey;
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
  public static int a = 1;
  public static HashMap<Integer, QQCustomMenuItem> a;
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
  
  static
  {
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(jdField_a_of_type_Int), new QQCustomMenuItem(2131365311, localBaseApplication.getString(2131691293), 2130838904));
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(b), new QQCustomMenuItem(2131367180, localBaseApplication.getString(2131692644), 2130838912));
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(c), new QQCustomMenuItem(2131371562, localBaseApplication.getString(2131694322), 2130838920));
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(d), new QQCustomMenuItem(2131371603, localBaseApplication.getString(2131694356), 2130838922));
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(e), new QQCustomMenuItem(2131365480, localBaseApplication.getString(2131690788), 2130838907));
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(f), new QQCustomMenuItem(2131366308, localBaseApplication.getString(2131719846), 0));
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(g), new QQCustomMenuItem(2131366309, localBaseApplication.getString(2131719847), 0));
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(h), new QQCustomMenuItem(2131366494, localBaseApplication.getString(2131692184), 2130838911));
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(i), new QQCustomMenuItem(2131380215, localBaseApplication.getString(2131690921), 0));
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(j), new QQCustomMenuItem(2131376417, localBaseApplication.getString(2131697695), 2130838918));
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(k), new QQCustomMenuItem(2131376430, localBaseApplication.getString(2131697701), 2130838918));
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(l), new QQCustomMenuItem(2131362480, localBaseApplication.getString(2131689936), 2130838922));
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(o), new QQCustomMenuItem(2131362480, localBaseApplication.getString(2131689936), 2130838922));
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(m), new QQCustomMenuItem(2131376471, localBaseApplication.getString(2131718154), 2130838919));
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(n), new QQCustomMenuItem(2131364271, localBaseApplication.getString(2131690787), 2130838901));
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(p), new QQCustomMenuItem(2131367202, localBaseApplication.getString(2131692644), 2130838912));
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
    if ((!AppSetting.j) && (paramChatMessage.istroop == 0)) {
      return;
    }
    if (UinTypeUtil.a(paramChatMessage.istroop) == 1032) {
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
    if ((AnonymousChatHelper.a(paramMessageRecord)) && (!TroopAnonyRevokeConfProcessor.a().a)) {
      return;
    }
    if (UinTypeUtil.a(paramMessageRecord.istroop) == 1032) {
      return;
    }
    Object localObject2 = (FriendsManager)((QQAppInterface)localObject1).getManager(QQManagerFactory.FRIENDS_MANAGER);
    if ((paramMessageRecord.istroop == 0) && (!((FriendsManager)localObject2).b(paramMessageRecord.frienduin))) {
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
          if ((!RobotUtils.a((QQAppInterface)localObject, paramChatMessage.senderuin)) && (!AnonymousChatHelper.a(paramChatMessage)) && (!ConfessMsgUtil.a(paramChatMessage)) && (!"1000000".equals(paramChatMessage.senderuin)) && (paramChatMessage.isSupportReply()))
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
            paramQQCustomMenu.append(AnonymousChatHelper.a(paramChatMessage));
            paramQQCustomMenu.append(" isConfessMsg=");
            paramQQCustomMenu.append(ConfessMsgUtil.a(paramChatMessage));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.BaseBubbleBuilderMenuHelper
 * JD-Core Version:    0.7.0.1
 */