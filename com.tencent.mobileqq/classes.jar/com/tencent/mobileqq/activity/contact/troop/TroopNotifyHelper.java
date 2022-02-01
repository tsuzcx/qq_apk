package com.tencent.mobileqq.activity.contact.troop;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.message.SystemMessageProcessor;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.config.TroopNotificationConfig;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.systemmsg.GroupSystemMsgController;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsgActionInfo;

public class TroopNotifyHelper
{
  private static HashSet<Integer> jdField_a_of_type_JavaUtilHashSet;
  private static boolean jdField_a_of_type_Boolean = false;
  private static HashSet<Integer> jdField_b_of_type_JavaUtilHashSet;
  private static boolean jdField_b_of_type_Boolean = false;
  
  static
  {
    jdField_a_of_type_JavaUtilHashSet = new HashSet();
    jdField_a_of_type_JavaUtilHashSet.add(Integer.valueOf(1));
    jdField_a_of_type_JavaUtilHashSet.add(Integer.valueOf(2));
    jdField_a_of_type_JavaUtilHashSet.add(Integer.valueOf(10));
    jdField_a_of_type_JavaUtilHashSet.add(Integer.valueOf(12));
    jdField_a_of_type_JavaUtilHashSet.add(Integer.valueOf(22));
    jdField_a_of_type_JavaUtilHashSet.add(Integer.valueOf(13));
    jdField_b_of_type_JavaUtilHashSet = new HashSet();
    jdField_b_of_type_JavaUtilHashSet.add(Integer.valueOf(91));
  }
  
  public static int a()
  {
    SharedPreferences localSharedPreferences = a();
    if (localSharedPreferences == null) {
      return 0;
    }
    return localSharedPreferences.getInt("lastshowtime_weak", 0);
  }
  
  public static long a()
  {
    SharedPreferences localSharedPreferences = a();
    if (localSharedPreferences == null) {
      return 0L;
    }
    return localSharedPreferences.getLong("lastundealmsgseq", 0L);
  }
  
  private static SharedPreferences a()
  {
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    str = "notify_redpoint" + str;
    return BaseApplicationImpl.getApplication().getSharedPreferences(str, 0);
  }
  
  public static List<Integer> a()
  {
    SharedPreferences localSharedPreferences = a();
    ArrayList localArrayList = new ArrayList();
    if (localSharedPreferences == null) {}
    int i;
    int j;
    int k;
    do
    {
      return localArrayList;
      i = localSharedPreferences.getInt("lastshowtime_year", 0);
      localArrayList.add(0, Integer.valueOf(i));
      j = localSharedPreferences.getInt("lastshowtime_day", 0);
      localArrayList.add(1, Integer.valueOf(j));
      k = localSharedPreferences.getInt("lastshowtime_weak", 0);
      localArrayList.add(2, Integer.valueOf(k));
    } while (!QLog.isColorLevel());
    QLog.d("TroopNotifyHelper", 2, "getLastShowTimeyear = " + i + " day" + j + "week" + k);
    return localArrayList;
  }
  
  public static void a()
  {
    new ArrayList();
    Object localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (localObject1 == null) {}
    do
    {
      return;
      localObject1 = ((QQAppInterface)localObject1).getMessageFacade().a(AppConstants.TROOP_SYSTEM_MSG_UIN, 0, null);
    } while ((localObject1 == null) || (((List)localObject1).isEmpty()));
    long l1 = a();
    localObject1 = ((List)localObject1).iterator();
    label68:
    if (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (MessageRecord)((Iterator)localObject1).next();
      if (!(localObject2 instanceof MessageForSystemMsg)) {
        break label201;
      }
      localObject2 = ((MessageForSystemMsg)localObject2).getSystemMsg();
      if ((localObject2 == null) || (!((structmsg.StructMsg)localObject2).msg.has()) || (((structmsg.SystemMsg)((structmsg.StructMsg)localObject2).msg.get()).sub_type.get() != 1)) {
        break label201;
      }
      long l2 = ((structmsg.StructMsg)localObject2).msg_seq.get();
      if (l2 <= l1) {
        break label201;
      }
      l1 = l2;
    }
    label201:
    for (;;)
    {
      break label68;
      a(l1);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("TroopNotifyHelper", 2, "updateLastUndealMsgSeqnewLastSeq = " + l1);
      return;
    }
  }
  
  public static void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotifyHelper", 2, new Object[] { "updateRemindCntOfOneWeak", "count =", Integer.valueOf(paramInt) });
    }
    SharedPreferences localSharedPreferences = a();
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putInt("remindcntofoneweak", paramInt).apply();
    }
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotifyHelper", 2, new Object[] { "updateLastShowTime:", "year =", paramInt1 + " day" + paramInt2 + "week" + paramInt3 });
    }
    SharedPreferences localSharedPreferences = a();
    if (localSharedPreferences != null)
    {
      localSharedPreferences.edit().putInt("lastshowtime_year", paramInt1).apply();
      localSharedPreferences.edit().putInt("lastshowtime_day", paramInt2).apply();
      localSharedPreferences.edit().putInt("lastshowtime_weak", paramInt3).apply();
    }
  }
  
  public static void a(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotifyHelper", 2, "updateLastUndealMsgSeqseq = " + paramLong);
    }
    SharedPreferences localSharedPreferences = a();
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putLong("lastundealmsgseq", paramLong).apply();
    }
  }
  
  public static void a(Context paramContext, TroopNotifyHelper.OnTroopSafeDialogClickConfirm paramOnTroopSafeDialogClickConfirm, Object... paramVarArgs)
  {
    if (paramContext == null) {
      return;
    }
    DialogUtil.a(paramContext, paramContext.getString(2131720269), paramContext.getString(2131720268), null, 2131690800, 2131694852, new TroopNotifyHelper.1(paramOnTroopSafeDialogClickConfirm, paramVarArgs), new TroopNotifyHelper.2()).show();
  }
  
  public static void a(structmsg.StructMsg paramStructMsg, long paramLong, String paramString)
  {
    if (paramStructMsg != null)
    {
      String str = ((structmsg.StructMsg)paramStructMsg.get()).msg_seq.get() + "_" + ((structmsg.StructMsg)paramStructMsg.get()).msg_type.get();
      GroupSystemMsgController.a().a(str, (structmsg.StructMsg)paramStructMsg.get());
      GroupSystemMsgController.a().b(str);
      GroupSystemMsgController.a().a(paramLong);
      GroupSystemMsgController.a().a(paramString);
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public static boolean a()
  {
    return jdField_a_of_type_Boolean;
  }
  
  public static boolean a(int paramInt)
  {
    TroopNotificationConfig localTroopNotificationConfig = (TroopNotificationConfig)QConfigManager.a().a(634);
    if (localTroopNotificationConfig == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopNotifyHelper", 2, new Object[] { "isShowUndealTipsInTabRecent", "troopNotificationConfig is null" });
      }
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotifyHelper", 2, new Object[] { "isShowUndealTipsInTabRecent", "troopNotificationConfig = " + localTroopNotificationConfig.toString() });
    }
    if (!localTroopNotificationConfig.jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopNotifyHelper", 2, "isGlobalOpen is false");
      }
      return false;
    }
    if ((paramInt < localTroopNotificationConfig.c) || (localTroopNotificationConfig.c == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopNotifyHelper", 2, new Object[] { "isShowUndealTipsInTabRecent", "undealMsgCount =", Integer.valueOf(paramInt), "todoGroupVerifyMsgLevel =", Integer.valueOf(localTroopNotificationConfig.c) });
      }
      return false;
    }
    if (a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopNotifyHelper", 2, "isShowUndealTipsInTabRecent: undealRedPoint is Showing!");
      }
      return true;
    }
    Calendar.getInstance();
    List localList = a();
    int j;
    int i;
    if (localList != null)
    {
      j = ((Integer)localList.get(0)).intValue();
      i = ((Integer)localList.get(1)).intValue();
      paramInt = ((Integer)localList.get(2)).intValue();
    }
    for (;;)
    {
      if ((1 != j) || (3 != paramInt))
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopNotifyHelper", 2, new Object[] { "isShowUndealTipsInTabRecent", "Year is changed, The time update" });
        }
        a(0);
        b(0);
        a(1, 6, 3);
      }
      while ((System.currentTimeMillis() - b()) / 1000L < localTroopNotificationConfig.jdField_a_of_type_Long)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopNotifyHelper", 2, new Object[] { "isShowUndealTipsInTabRecent", "The TimeIntervel is  little" });
        }
        return false;
        if (6 != i)
        {
          if (QLog.isColorLevel()) {
            QLog.d("TroopNotifyHelper", 2, new Object[] { "isShowUndealTipsInTabRecent", "Day is changed, The day update" });
          }
          b(0);
          a(1, 6, 3);
        }
      }
      if ((1 == j) && (6 == i) && (b() >= localTroopNotificationConfig.b))
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopNotifyHelper", 2, new Object[] { "isShowUndealTipsInTabRecent", "RemindCntOfOneDay =", Integer.valueOf(b()), "totalRemindCntOfOneDay =", Integer.valueOf(localTroopNotificationConfig.b) });
        }
        return false;
      }
      if ((1 == j) && (3 == paramInt) && (a() >= localTroopNotificationConfig.jdField_a_of_type_Int))
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopNotifyHelper", 2, new Object[] { "isShowUndealTipsInTabRecent", "RemindCntOfOneWeak =", Integer.valueOf(b()), "totalRemindCntOfOneWeak =", Integer.valueOf(localTroopNotificationConfig.jdField_a_of_type_Int) });
        }
        return false;
      }
      return true;
      paramInt = 0;
      i = 0;
      j = 0;
    }
  }
  
  public static boolean a(structmsg.StructMsg paramStructMsg, QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramStructMsg != null)
    {
      bool1 = bool2;
      if (paramQQAppInterface != null)
      {
        int i = paramStructMsg.msg_type.get();
        long l1 = paramStructMsg.msg_seq.get();
        long l2 = paramStructMsg.req_uin.get();
        int j = paramStructMsg.msg.sub_type.get();
        int k = paramStructMsg.msg.src_id.get();
        int m = paramStructMsg.msg.sub_src_id.get();
        int n = paramStructMsg.msg.group_msg_type.get();
        structmsg.SystemMsgActionInfo localSystemMsgActionInfo = new structmsg.SystemMsgActionInfo();
        localSystemMsgActionInfo.group_code.set(paramStructMsg.msg.group_code.get());
        localSystemMsgActionInfo.sig.set(ByteStringMicro.EMPTY);
        localSystemMsgActionInfo.type.set(15);
        if (paramBoolean) {
          localSystemMsgActionInfo.uint32_req_msg_type.set(2);
        }
        paramQQAppInterface.getMsgHandler().a().a(i, l1, l2, j, k, m, n, (structmsg.SystemMsgActionInfo)localSystemMsgActionInfo.get(), 3);
        GroupSystemMsgController.a().a(paramQQAppInterface, 0);
        ReportController.b(null, "dc00898", "", "", "0x800B47E", "0x800B47E", 0, 0, "", "", "", "");
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static int b()
  {
    SharedPreferences localSharedPreferences = a();
    if (localSharedPreferences == null) {
      return 0;
    }
    return localSharedPreferences.getInt("remindcntofoneday", 0);
  }
  
  public static long b()
  {
    SharedPreferences localSharedPreferences = a();
    if (localSharedPreferences == null) {
      return 0L;
    }
    return localSharedPreferences.getLong("intervelshowtime", 0L);
  }
  
  public static void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotifyHelper", 2, "updateRemindCntOfOneDaycount = " + paramInt);
    }
    SharedPreferences localSharedPreferences = a();
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putInt("remindcntofoneday", paramInt).apply();
    }
  }
  
  public static void b(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotifyHelper", 2, "updateLastShowTimeInterveltime = " + paramLong);
    }
    SharedPreferences localSharedPreferences = a();
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putLong("intervelshowtime", paramLong).apply();
    }
  }
  
  public static void b(boolean paramBoolean)
  {
    jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public static boolean b()
  {
    return jdField_b_of_type_Boolean;
  }
  
  public static boolean b(int paramInt)
  {
    return jdField_a_of_type_JavaUtilHashSet.contains(Integer.valueOf(paramInt));
  }
  
  public static int c()
  {
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (localObject == null) {
      return 0;
    }
    ArrayList localArrayList = new ArrayList();
    localObject = (TroopNotificationManager)((QQAppInterface)localObject).getManager(QQManagerFactory.TROOP_NOTIFICATION_MANAGER);
    if (localObject != null) {}
    for (localObject = ((TroopNotificationManager)localObject).a();; localObject = null)
    {
      long l = a();
      if ((localObject != null) && (!((List)localObject).isEmpty()))
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
          if ((localMessageRecord instanceof MessageForSystemMsg))
          {
            structmsg.StructMsg localStructMsg = ((MessageForSystemMsg)localMessageRecord).getSystemMsg();
            if ((localStructMsg != null) && (localStructMsg.msg.has()) && (((structmsg.SystemMsg)localStructMsg.msg.get()).sub_type.get() == 1) && (localStructMsg.msg_seq.get() > l)) {
              localArrayList.add(localMessageRecord);
            }
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("TroopNotifyHelper", 2, "getUnReadUndealMsgresult size = " + localArrayList.size());
      }
      return localArrayList.size();
    }
  }
  
  public static boolean c(int paramInt)
  {
    return jdField_b_of_type_JavaUtilHashSet.contains(Integer.valueOf(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopNotifyHelper
 * JD-Core Version:    0.7.0.1
 */