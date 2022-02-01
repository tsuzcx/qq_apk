package com.tencent.imcore.message;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.ConversationInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.utils.SecurityUtile;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Set;
import java.util.Set<Ljava.lang.String;>;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.manager.Manager;

public class ConversationFacade
  extends Observable
  implements Manager
{
  public static ConversationFacade.Callback a;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private Set<String> jdField_a_of_type_JavaUtilSet;
  private final AppRuntime jdField_a_of_type_MqqAppAppRuntime;
  private Set<String> b;
  
  static
  {
    InitMsgModule.a();
    jdField_a_of_type_ComTencentImcoreMessageConversationFacade$Callback = new ConversationFacade.2();
  }
  
  public ConversationFacade(AppRuntime paramAppRuntime)
  {
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
  }
  
  public static int a(ConversationInfo paramConversationInfo)
  {
    if (paramConversationInfo == null) {
      return 0;
    }
    paramConversationInfo = jdField_a_of_type_ComTencentImcoreMessageConversationFacade$Callback.a(paramConversationInfo);
    return Math.max(paramConversationInfo.unreadCount, paramConversationInfo.unreadMark);
  }
  
  private int a(MessageRecord paramMessageRecord, long paramLong)
  {
    if (paramMessageRecord.time <= paramLong) {}
    do
    {
      return 0;
      paramMessageRecord = a(paramMessageRecord.istroop).b(paramMessageRecord.senderuin, paramMessageRecord.istroop);
    } while (paramMessageRecord == null);
    paramMessageRecord = paramMessageRecord.iterator();
    int i = 0;
    if (paramMessageRecord.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)paramMessageRecord.next();
      if ((localMessageRecord.time <= paramLong) || (localMessageRecord.isread)) {
        break label95;
      }
      i += 1;
    }
    label95:
    for (;;)
    {
      break;
      return i;
    }
  }
  
  private static SharedPreferences a(AppRuntime paramAppRuntime, int paramInt)
  {
    if (paramInt == 1001) {}
    for (String str = "sp_nearby_summary_" + paramAppRuntime.getAccount(); !TextUtils.isEmpty(str); str = "") {
      return SharedPreferencesProxyManager.getInstance().getProxy("sp_nearby_summary_" + paramAppRuntime.getAccount(), 0);
    }
    return null;
  }
  
  private BaseMsgProxy a(int paramInt)
  {
    return jdField_a_of_type_ComTencentImcoreMessageConversationFacade$Callback.a(this.jdField_a_of_type_MqqAppAppRuntime, paramInt);
  }
  
  private ConversationProxy a()
  {
    return jdField_a_of_type_ComTencentImcoreMessageConversationFacade$Callback.a(this.jdField_a_of_type_MqqAppAppRuntime);
  }
  
  private RecentUserProxy a()
  {
    return jdField_a_of_type_ComTencentImcoreMessageConversationFacade$Callback.a(this.jdField_a_of_type_MqqAppAppRuntime);
  }
  
  private static String a(String paramString, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (String str = "lastuin";; str = "sm") {
      return String.format("%s_%s_%s", new Object[] { str, paramString, Integer.valueOf(paramInt) });
    }
  }
  
  private Set<String> a(int paramInt)
  {
    if (paramInt == 1010)
    {
      if (this.jdField_a_of_type_JavaUtilSet == null) {
        this.jdField_a_of_type_JavaUtilSet = a(AppConstants.DATE_SAY_HELLO_LIST_UIN, paramInt, "date_box_last_read_time");
      }
      return this.jdField_a_of_type_JavaUtilSet;
    }
    if (paramInt == 1001)
    {
      if (this.b == null) {
        this.b = a(AppConstants.LBS_SAY_HELLO_LIST_UIN, paramInt, "lbs_box_last_read_time");
      }
      return this.b;
    }
    return null;
  }
  
  private Set<String> a(String paramString1, int paramInt, String paramString2)
  {
    long l1 = 0L;
    if (QLog.isColorLevel())
    {
      l1 = System.currentTimeMillis();
      QLog.d("Q.msg_box", 2, "initSayHelloSet,boxType:" + paramInt + ",startTime:" + l1);
    }
    SharedPreferences localSharedPreferences = jdField_a_of_type_ComTencentImcoreMessageConversationFacade$Callback.a(this.jdField_a_of_type_MqqAppAppRuntime).getSharedPreferences(this.jdField_a_of_type_MqqAppAppRuntime.getAccount(), 0);
    HashSet localHashSet = new HashSet();
    paramString1 = a(paramInt).a(paramString1, paramInt);
    long l2 = localSharedPreferences.getLong(paramString2, 0L);
    paramString1 = paramString1.iterator();
    while (paramString1.hasNext())
    {
      paramString2 = (MessageRecord)paramString1.next();
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.msg_box", 4, "lastTime:" + l2 + ",mr.time:" + paramString2.time + ",uin:" + paramString2.senderuin + ",istroop:" + paramString2.istroop);
      }
      if ((a(paramString2.senderuin, paramInt) > 0) && (paramString2.time > l2)) {
        localHashSet.add(paramString2.senderuin);
      }
    }
    if (QLog.isColorLevel())
    {
      l2 = System.currentTimeMillis();
      QLog.d("Q.msg_box", 2, "initSayHelloSet,endTime:" + l2 + ",costTime:" + (l2 - l1));
    }
    return localHashSet;
  }
  
  public static void a(ConversationFacade.Callback paramCallback)
  {
    jdField_a_of_type_ComTencentImcoreMessageConversationFacade$Callback = paramCallback;
  }
  
  private void a(ConversationInfo paramConversationInfo)
  {
    jdField_a_of_type_ComTencentImcoreMessageConversationFacade$Callback.a(this.jdField_a_of_type_MqqAppAppRuntime, paramConversationInfo, 0);
  }
  
  private void a(MessageRecord paramMessageRecord)
  {
    if (jdField_a_of_type_ComTencentImcoreMessageConversationFacade$Callback.a(paramMessageRecord))
    {
      a().b(paramMessageRecord.frienduin, paramMessageRecord.istroop);
      return;
    }
    if ((AppConstants.KANDIAN_SUBSCRIBE_UIN.equals(paramMessageRecord.frienduin)) || (AppConstants.KANDIAN_DAILY_UIN.equals(paramMessageRecord.frienduin))) {
      a().a(paramMessageRecord.frienduin, paramMessageRecord.istroop);
    }
    a().a(paramMessageRecord.frienduin, paramMessageRecord.istroop, 1, a(paramMessageRecord), b(paramMessageRecord));
  }
  
  private void a(MessageRecord paramMessageRecord, ConversationInfo paramConversationInfo)
  {
    a(paramMessageRecord, paramConversationInfo, 1037);
    a(paramMessageRecord, paramConversationInfo, 1044);
    a(paramMessageRecord, paramConversationInfo, 10008);
    a(paramMessageRecord, paramConversationInfo, 1045);
  }
  
  private void a(MessageRecord paramMessageRecord, ConversationInfo paramConversationInfo, int paramInt)
  {
    if ((paramConversationInfo != null) && (paramConversationInfo.type == paramInt) && (paramMessageRecord.istroop != paramInt))
    {
      a(paramMessageRecord.frienduin, paramInt);
      if (QLog.isColorLevel()) {
        QLog.d("Q.unread.Facade", 2, "addUnread, remove old ConversationInfo,  uin=" + paramMessageRecord.frienduin + ",new type" + paramMessageRecord.istroop);
      }
    }
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt == 3000) || (paramInt == 1);
  }
  
  private boolean a(MessageRecord paramMessageRecord)
  {
    boolean bool2 = true;
    if (paramMessageRecord.msgtype == -2055) {
      jdField_a_of_type_ComTencentImcoreMessageConversationFacade$Callback.a(paramMessageRecord, this);
    }
    for (;;)
    {
      boolean bool1 = false;
      do
      {
        do
        {
          return bool1;
          if (paramMessageRecord.msgtype != -2053) {
            break;
          }
          bool1 = bool2;
        } while (!jdField_a_of_type_ComTencentImcoreMessageConversationFacade$Callback.d(paramMessageRecord));
        bool1 = bool2;
      } while (a(paramMessageRecord.frienduin, paramMessageRecord.msgtype) > 0);
      if (AppConstants.LBS_HELLO_UIN.equals(paramMessageRecord.frienduin)) {
        a().a(paramMessageRecord.senderuin, 1001, 1, a(paramMessageRecord), b(paramMessageRecord));
      } else {
        a().a(paramMessageRecord.frienduin, 1001, 1, a(paramMessageRecord), b(paramMessageRecord));
      }
    }
  }
  
  private boolean a(MessageRecord paramMessageRecord, Set<MessageRecord> paramSet)
  {
    if ((paramSet == null) || (paramSet.isEmpty())) {
      return false;
    }
    paramSet = paramSet.iterator();
    while (paramSet.hasNext()) {
      if (UinTypeUtil.a(paramMessageRecord, (MessageRecord)paramSet.next())) {
        return true;
      }
    }
    return false;
  }
  
  private boolean a(String paramString, int paramInt, long paramLong, List<MessageRecord> paramList)
  {
    if (((a(paramInt)) && (((MessageRecord)paramList.get(paramList.size() - 1)).shmsgseq <= paramLong)) || ((a(paramInt)) || (((MessageRecord)paramList.get(paramList.size() - 1)).time > paramLong) || (UinTypeUtil.e(paramInt)) || (UinTypeUtil.i(paramInt)) || (jdField_a_of_type_ComTencentImcoreMessageConversationFacade$Callback.a(paramString)))) {
      return false;
    }
    if ((a().b(paramString, paramInt) > 0) || (a().c(paramString, paramInt) > 0) || (a().d(paramString, paramInt) > 0))
    {
      a(paramString, paramInt, paramLong, false);
      return true;
    }
    if ((paramLong > 0L) && (a(paramString, paramInt) < paramLong)) {
      a(paramString, paramInt, paramLong, false);
    }
    return true;
  }
  
  private boolean a(List<MessageRecord> paramList, MessageRecord paramMessageRecord)
  {
    if ((1001 == paramMessageRecord.istroop) || (10002 == paramMessageRecord.istroop))
    {
      if (a(paramMessageRecord)) {
        return true;
      }
    }
    else
    {
      if (1009 != paramMessageRecord.istroop) {
        break label67;
      }
      a().a(paramMessageRecord.frienduin, 1009, 1, a(paramMessageRecord), b(paramMessageRecord));
    }
    label303:
    for (;;)
    {
      return false;
      label67:
      if ((1033 == paramMessageRecord.istroop) || (1034 == paramMessageRecord.istroop))
      {
        jdField_a_of_type_ComTencentImcoreMessageConversationFacade$Callback.a(this.jdField_a_of_type_MqqAppAppRuntime, 1033, paramMessageRecord, paramList);
      }
      else if (1008 == paramMessageRecord.istroop)
      {
        a(paramMessageRecord);
      }
      else if (1044 == UinTypeUtil.a(paramMessageRecord.istroop))
      {
        a().a(paramMessageRecord.frienduin, paramMessageRecord.istroop, 1, a(paramMessageRecord), b(paramMessageRecord));
        jdField_a_of_type_ComTencentImcoreMessageConversationFacade$Callback.a(this.jdField_a_of_type_MqqAppAppRuntime, 1044, paramMessageRecord, paramList);
      }
      else if (10008 == UinTypeUtil.a(paramMessageRecord.istroop))
      {
        a().a(paramMessageRecord.frienduin, paramMessageRecord.istroop, 1, a(paramMessageRecord), b(paramMessageRecord));
        jdField_a_of_type_ComTencentImcoreMessageConversationFacade$Callback.a(this.jdField_a_of_type_MqqAppAppRuntime, 10008, paramMessageRecord, paramList);
      }
      else
      {
        a(paramMessageRecord, a().a(paramMessageRecord.frienduin, paramMessageRecord.istroop));
        if (paramMessageRecord.istroop == 10005) {}
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            break label303;
          }
          a().a(paramMessageRecord.frienduin, paramMessageRecord.istroop, 1);
          break;
        }
        if (1038 == paramMessageRecord.istroop) {
          jdField_a_of_type_ComTencentImcoreMessageConversationFacade$Callback.a(this.jdField_a_of_type_MqqAppAppRuntime, 1038, paramMessageRecord, paramList);
        }
        a().a(paramMessageRecord.frienduin, paramMessageRecord.istroop, 1, a(paramMessageRecord), b(paramMessageRecord));
      }
    }
  }
  
  private boolean a(List<MessageRecord> paramList, Set<String> paramSet, boolean paramBoolean)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
      if ((!localMessageRecord.isSendFromLocal()) && (!localMessageRecord.isread) && ((localMessageRecord.msgtype != -2006) || (!jdField_a_of_type_ComTencentImcoreMessageConversationFacade$Callback.c(localMessageRecord))))
      {
        Object localObject2 = paramSet;
        String str;
        Object localObject1;
        if (localMessageRecord.isLongMsg())
        {
          str = UinTypeUtil.a(localMessageRecord);
          localObject1 = paramSet;
          if (paramSet == null) {
            localObject1 = new HashSet();
          }
          if (!jdField_a_of_type_ComTencentImcoreMessageConversationFacade$Callback.f(localMessageRecord)) {
            break label201;
          }
          paramSet = (Set<String>)localObject1;
          if (jdField_a_of_type_ComTencentImcoreMessageConversationFacade$Callback.a(this.jdField_a_of_type_MqqAppAppRuntime, localMessageRecord)) {
            continue;
          }
          paramSet = (Set<String>)localObject1;
          if (((Set)localObject1).contains(str)) {
            continue;
          }
          ((Set)localObject1).add(str);
          localObject2 = localObject1;
        }
        for (;;)
        {
          paramSet = (Set<String>)localObject2;
          if (a(paramList, localMessageRecord)) {
            break;
          }
          paramSet = (Set<String>)localObject2;
          if (!UinTypeUtil.b(localMessageRecord.istroop)) {
            break;
          }
          paramBoolean = true;
          paramSet = (Set<String>)localObject2;
          break;
          label201:
          localObject2 = localObject1;
          if (((Set)localObject1).contains(str))
          {
            ((Set)localObject1).remove(str);
            localObject2 = localObject1;
          }
        }
      }
    }
    return paramBoolean;
  }
  
  public static int b(ConversationInfo paramConversationInfo)
  {
    if (paramConversationInfo == null) {
      return 0;
    }
    return paramConversationInfo.extInt2;
  }
  
  public static int c(ConversationInfo paramConversationInfo)
  {
    if (paramConversationInfo == null) {
      return 0;
    }
    return paramConversationInfo.unreadCount;
  }
  
  public static int d(ConversationInfo paramConversationInfo)
  {
    if (paramConversationInfo == null) {
      return 0;
    }
    return paramConversationInfo.unreadMark;
  }
  
  private void d()
  {
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      ConcurrentHashMap localConcurrentHashMap = a(0).a().b();
      if ((localConcurrentHashMap.get(UinTypeUtil.a(AppConstants.LBS_HELLO_UIN, 1001)) != null) || (localConcurrentHashMap.get(UinTypeUtil.a(AppConstants.SAME_STATE_BOX_UIN, 1009)) != null) || (localConcurrentHashMap.get(UinTypeUtil.a(AppConstants.DATE_UIN, 1010)) != null) || (localConcurrentHashMap.get(UinTypeUtil.a(AppConstants.CONFESS_UIN, 1032)) != null) || (localConcurrentHashMap.get(UinTypeUtil.a(AppConstants.NEARBY_LBS_HELLO_UIN, 1001)) != null) || (localConcurrentHashMap.get(UinTypeUtil.a(AppConstants.MATCH_CHAT_UIN, 1044)) != null) || (localConcurrentHashMap.get(UinTypeUtil.a(AppConstants.QCIRCLE_CHAT_UIN, 10008)) != null)) {
        ThreadManager.post(new ConversationFacade.1(this), 8, null, false);
      }
      return;
    }
    e();
  }
  
  private void e()
  {
    b(AppConstants.NEARBY_LBS_HELLO_UIN, 1001);
    b(AppConstants.LBS_HELLO_UIN, 1001);
    b(AppConstants.SAME_STATE_BOX_UIN, 1009);
    b(AppConstants.DATE_UIN, 1010);
    b(AppConstants.CONFESS_UIN, 1032);
    b(AppConstants.MATCH_CHAT_UIN, 1044);
    b(AppConstants.QCIRCLE_CHAT_UIN, 10008);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_MqqAppAppRuntime.getPreferences().getInt("sp_key_sayhello_box_unread_count", 0);
  }
  
  public int a(int paramInt)
  {
    Set localSet = a(paramInt);
    int i = 0;
    if (localSet != null) {}
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      i = localSet.size();
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg_box", 2, "getUnreadSayHelloNum,boxType:" + paramInt + ",num:" + i);
      }
      return i;
    }
  }
  
  public int a(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord != null) && (!paramMessageRecord.isSend()) && (!paramMessageRecord.isread) && (paramMessageRecord.msgtype == -2038)) {
      return 1;
    }
    return 0;
  }
  
  public int a(String paramString, int paramInt)
  {
    return a(a().a(paramString, paramInt));
  }
  
  public int a(String paramString, int paramInt1, int paramInt2)
  {
    return jdField_a_of_type_ComTencentImcoreMessageConversationFacade$Callback.a(this.jdField_a_of_type_MqqAppAppRuntime, paramString, paramInt1, paramInt2);
  }
  
  public long a(String paramString, int paramInt)
  {
    return a().a(paramString, paramInt);
  }
  
  public ConversationInfo a(String paramString, int paramInt)
  {
    try
    {
      paramString = a().a(paramString, paramInt);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public String a(String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (!UinTypeUtil.j(paramInt1))) {}
    for (;;)
    {
      return paramString2;
      SharedPreferences localSharedPreferences = a(this.jdField_a_of_type_MqqAppAppRuntime, paramInt1);
      String str;
      if ((paramInt1 == 1001) || (paramInt1 == 10002))
      {
        if ((paramInt2 < 0) || (paramInt2 > 0)) {
          continue;
        }
        if (AppConstants.LBS_HELLO_UIN.equals(paramString1))
        {
          paramString1 = localSharedPreferences.getString(a(AppConstants.LBS_HELLO_UIN, paramInt2, true), "");
          str = paramString1;
          if (AppConstants.LBS_SAY_HELLO_LIST_UIN.equals(paramString1)) {
            str = localSharedPreferences.getString(a(AppConstants.LBS_SAY_HELLO_LIST_UIN, paramInt2, true), "");
          }
        }
      }
      while (!TextUtils.isEmpty(str))
      {
        return SecurityUtile.decode(localSharedPreferences.getString(a(str, paramInt2, false), paramString2));
        str = paramString1;
        if (AppConstants.LBS_SAY_HELLO_LIST_UIN.equals(paramString1))
        {
          str = localSharedPreferences.getString(a(AppConstants.LBS_SAY_HELLO_LIST_UIN, paramInt2, true), "");
          continue;
          str = null;
        }
      }
    }
  }
  
  public Set<ConversationInfo> a()
  {
    return a().a();
  }
  
  public void a()
  {
    a().a();
    jdField_a_of_type_ComTencentImcoreMessageConversationFacade$Callback.b(this.jdField_a_of_type_MqqAppAppRuntime);
    Object localObject2 = a().a();
    Object localObject1 = new HashSet();
    localObject2 = ((Set)localObject2).iterator();
    label304:
    while (((Iterator)localObject2).hasNext())
    {
      ConversationInfo localConversationInfo = (ConversationInfo)((Iterator)localObject2).next();
      if (b(localConversationInfo.uin, localConversationInfo.type))
      {
        if (UinTypeUtil.a(localConversationInfo.uin, localConversationInfo.type)) {
          b(localConversationInfo.uin, localConversationInfo.type);
        }
        if ((QLog.isColorLevel()) && ((a(localConversationInfo) != 0) || (localConversationInfo.unreadGiftCount != 0) || (localConversationInfo.extInt1 != 0))) {
          QLog.d("Q.unread.Facade", 2, "initCache info=" + localConversationInfo.toString());
        }
      }
      for (;;)
      {
        if ((a(localConversationInfo) != 0) || ((localConversationInfo.unreadGiftCount == 0) && (localConversationInfo.extInt1 == 0))) {
          break label304;
        }
        a(localConversationInfo.uin, localConversationInfo.unreadGiftCount, false);
        break;
        if ((UinTypeUtil.h(localConversationInfo.type)) && (!UinTypeUtil.a(localConversationInfo.uin, localConversationInfo.type)) && (!a(localConversationInfo.uin, UinTypeUtil.a(localConversationInfo.type)))) {
          ((Set)localObject1).add(localConversationInfo);
        }
        if ((QLog.isColorLevel()) && ((a(localConversationInfo) != 0) || (localConversationInfo.unreadGiftCount != 0) || (localConversationInfo.extInt1 != 0))) {
          QLog.d("Q.unread.Facade", 2, "initCache [not in recent] info=" + localConversationInfo.toString());
        }
      }
    }
    if (!((Set)localObject1).isEmpty())
    {
      localObject1 = ((Set)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ConversationInfo)((Iterator)localObject1).next();
        if (QLog.isColorLevel()) {
          QLog.d("Q.unread.Facade", 2, "initCache remove info=" + ((ConversationInfo)localObject2).toString());
        }
        a().c(((ConversationInfo)localObject2).uin, ((ConversationInfo)localObject2).type);
      }
    }
  }
  
  public void a(int paramInt, long paramLong)
  {
    Set localSet = a(paramInt);
    if (localSet == null) {
      return;
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        localSet.clear();
        ??? = jdField_a_of_type_ComTencentImcoreMessageConversationFacade$Callback.a(this.jdField_a_of_type_MqqAppAppRuntime).getSharedPreferences(this.jdField_a_of_type_MqqAppAppRuntime.getAccount(), 0);
        if (paramInt == 1010)
        {
          ((SharedPreferences)???).edit().putLong("date_box_last_read_time", paramLong).commit();
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("Q.msg_box", 2, "clearNewSayHelloSet,boxType:" + paramInt + ",time:" + paramLong);
          return;
        }
      }
      if (paramInt == 1001) {
        ((SharedPreferences)???).edit().putLong("lbs_box_last_read_time", paramLong).commit();
      }
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    Set localSet = a(paramInt);
    if ((localSet == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (!localSet.contains(paramString)) {
        localSet.add(paramString);
      }
      return;
    }
  }
  
  public void a(ConversationInfo paramConversationInfo, String paramString)
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.i("Q.msg_box", 2, "updateSummaryLastUin info = " + paramConversationInfo + ", lbsHongbaoLastUin = " + paramString);
    }
    if ((paramConversationInfo == null) || (!UinTypeUtil.j(paramConversationInfo.type)) || (TextUtils.isEmpty(paramConversationInfo.uin))) {}
    SharedPreferences.Editor localEditor;
    do
    {
      return;
      localEditor = a(this.jdField_a_of_type_MqqAppAppRuntime, paramConversationInfo.type).edit();
      if ((paramConversationInfo.type != 1001) && (paramConversationInfo.type != 10002)) {
        break;
      }
    } while ((!AppConstants.LBS_SAY_HELLO_LIST_UIN.equals(paramConversationInfo.uin)) && (!AppConstants.LBS_HELLO_UIN.equals(paramConversationInfo.uin)));
    if ((paramConversationInfo.extInt1 <= 0) || (TextUtils.isEmpty(paramString))) {
      localEditor.remove(a(paramConversationInfo.uin, 0, true));
    }
    for (;;)
    {
      i = 1;
      if (i == 0) {
        break;
      }
      localEditor.commit();
      return;
      localEditor.putString(a(paramConversationInfo.uin, 0, true), paramString);
    }
  }
  
  protected void a(String paramString, int paramInt)
  {
    a(paramString, paramInt, true);
    a().c(paramString, paramInt);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    a().b(paramString, paramInt1, paramInt2);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if ((paramInt1 != 1033) && (paramInt1 != 1034))
    {
      a(paramString, paramInt1, a().a(paramString, paramInt1), paramBoolean);
      return;
    }
    a(paramString, paramInt1, jdField_a_of_type_ComTencentImcoreMessageConversationFacade$Callback.a(this.jdField_a_of_type_MqqAppAppRuntime, paramString, paramInt1, paramInt2), true, paramBoolean, paramInt2);
  }
  
  protected void a(String paramString, int paramInt, long paramLong)
  {
    boolean bool2 = false;
    if (QLog.isColorLevel()) {
      QLog.d("Q.unread.Facade", 2, "cleanUnreadFrom uin=" + paramString + ",type=" + paramInt + ",lastread=" + paramLong);
    }
    if (paramInt == 1008) {}
    for (boolean bool1 = jdField_a_of_type_ComTencentImcoreMessageConversationFacade$Callback.a(this.jdField_a_of_type_MqqAppAppRuntime, paramString);; bool1 = false)
    {
      if ((paramInt == 1008) && (jdField_a_of_type_ComTencentImcoreMessageConversationFacade$Callback.b(this.jdField_a_of_type_MqqAppAppRuntime, paramString)) && (!bool1)) {
        if (QLog.isColorLevel()) {
          QLog.d("Q.unread.Facade", 2, "isTroopBarAccount");
        }
      }
      do
      {
        return;
        if ((paramInt != 1008) || (!TextUtils.equals(paramString, AppConstants.NEW_KANDIAN_UIN))) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("Q.unread.Facade", 2, "NEW_KANDIAN_UIN not unread");
      return;
      b(paramString, paramInt, paramLong);
      a(paramInt).a(paramString, paramInt, paramLong);
      if ((paramInt == 1008) && (bool1))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.unread.Facade", 2, "inServiceAccountFolder uin=" + paramString);
        }
        jdField_a_of_type_ComTencentImcoreMessageConversationFacade$Callback.a(this.jdField_a_of_type_MqqAppAppRuntime, paramString);
      }
      jdField_a_of_type_ComTencentImcoreMessageConversationFacade$Callback.a(this.jdField_a_of_type_MqqAppAppRuntime);
      bool1 = bool2;
      if (a(paramString, paramInt) == 0) {
        bool1 = true;
      }
      jdField_a_of_type_ComTencentImcoreMessageConversationFacade$Callback.a(paramString, paramInt, bool1, paramLong);
      return;
    }
  }
  
  protected void a(String paramString, int paramInt, long paramLong, boolean paramBoolean)
  {
    a(paramString, paramInt, paramLong, true, paramBoolean);
  }
  
  public void a(String paramString, int paramInt, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    long l = SystemClock.elapsedRealtime();
    a(paramString, paramInt, paramLong, paramBoolean1, paramBoolean2, 0);
    if (QLog.isColorLevel()) {
      QLog.d("Q.unread.Facade", 2, "cleanUnread() called with: uin = [" + paramString + "], type = [" + paramInt + "], lastread = [" + paramLong + "], needUpdateBox = [" + paramBoolean1 + "], needDelMark = [" + paramBoolean2 + "], costTime = [" + (SystemClock.elapsedRealtime() - l) + "]ms");
    }
  }
  
  protected void a(String paramString, int paramInt1, long paramLong, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
  {
    long l;
    if ((paramInt1 != 1033) && (paramInt1 != 1034))
    {
      l = a().b(paramString, paramInt1);
      if (QLog.isColorLevel()) {
        QLog.d("Q.unread.Facade", 2, "cleanUnread uin=" + paramString + ",type" + paramInt1 + ",unread" + l + " ,lastread" + paramLong + ",needDelMark" + paramBoolean2);
      }
      if (paramBoolean2) {
        a().b(paramString, paramInt1, 0);
      }
      a().a(paramString, paramInt1, paramLong, 0, 0, 0);
    }
    for (paramLong = l;; paramLong = 0L)
    {
      if (paramLong > 0L)
      {
        if ((UinTypeUtil.b(paramInt1)) && (paramBoolean1)) {
          d();
        }
        Message localMessage = jdField_a_of_type_ComTencentImcoreMessageConversationFacade$Callback.a(this.jdField_a_of_type_MqqAppAppRuntime, paramString, paramInt1, paramInt2);
        if (localMessage != null) {
          a(paramInt1).a(paramString, paramInt1, localMessage, paramInt2);
        }
      }
      jdField_a_of_type_ComTencentImcoreMessageConversationFacade$Callback.a(paramString, paramInt1, true, 0L);
      return;
      jdField_a_of_type_ComTencentImcoreMessageConversationFacade$Callback.a(this.jdField_a_of_type_MqqAppAppRuntime, paramString, paramInt1, paramInt2, paramLong);
    }
  }
  
  protected void a(String paramString, int paramInt, MessageRecord paramMessageRecord)
  {
    int j = 0;
    int i;
    if (paramMessageRecord != null)
    {
      i = a(paramMessageRecord) * -1;
      j = b(paramMessageRecord) * -1;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.unread.Facade", 2, "increaseUnread uin=" + paramString + ",type" + paramInt + ",unreadDiff" + -1 + ",unreadGiftDiff=" + i + ",unreadRedPacketDiff=" + j + ",mr=" + paramMessageRecord);
      }
      a().a(paramString, paramInt, -1, i, j);
      if (UinTypeUtil.b(paramInt)) {
        d();
      }
      return;
      i = 0;
    }
  }
  
  @Deprecated
  public void a(String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    paramInt2 = a().b(paramString2, paramInt2);
    int i = a().b(paramString1, paramInt1);
    if (QLog.isColorLevel()) {
      QLog.d("Q.unread.Facade", 2, "moveBoxToMessageTab innerItemUnread=" + paramInt2 + ", convsItemUnread=" + i);
    }
    b(paramString1, paramInt1);
  }
  
  protected void a(String paramString, int paramInt, List<MessageRecord> paramList)
  {
    int i = 0;
    Iterator localIterator = paramList.iterator();
    int j = 0;
    while (localIterator.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
      int n = a(localMessageRecord) * -1;
      int i1 = b(localMessageRecord) * -1;
      if (localMessageRecord != null)
      {
        int k = j + n;
        int m = i + i1;
        j = k;
        i = m;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.unread.Facade", 2, "increaseUnread uin=" + paramString + ",type" + paramInt + ",unreadDiff" + -1 + ",unreadGiftDiff=" + n + ",unreadRedPacketDiff=" + i1 + ",mr=" + localMessageRecord);
          j = k;
          i = m;
        }
      }
    }
    a().a(paramString, paramInt, paramList.size(), j, i);
    if (UinTypeUtil.b(paramInt)) {
      d();
    }
  }
  
  public void a(String paramString, int paramInt, boolean paramBoolean)
  {
    a(paramString, paramInt, 0, paramBoolean);
  }
  
  public void a(List<MessageRecord> paramList)
  {
    if (paramList != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.unread.Facade", 2, "addUnread msg size=" + paramList.size());
      }
      if (a(paramList, null, false)) {
        d();
      }
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.unread.Facade", 2, "cleanAllUnread needUpdateMsgtable=" + paramBoolean1 + ",needDelMark=" + paramBoolean2);
    }
    if (paramBoolean1)
    {
      Iterator localIterator = a().a().iterator();
      while (localIterator.hasNext())
      {
        ConversationInfo localConversationInfo = (ConversationInfo)localIterator.next();
        if ((a(localConversationInfo) > 0) && (!AppConstants.FRIEND_SYSTEM_MSG_UIN.equals(localConversationInfo.uin)) && ((!AppConstants.ACTIVATE_FRIENDS_UIN.equals(localConversationInfo.uin)) || (AppConstants.ACTIVATE_FRIENDS_UIN.equals(localConversationInfo.uin)))) {
          a(localConversationInfo.uin, localConversationInfo.type, paramBoolean2);
        }
        a(localConversationInfo);
      }
      jdField_a_of_type_ComTencentImcoreMessageConversationFacade$Callback.a(this.jdField_a_of_type_MqqAppAppRuntime, true, paramBoolean2, this);
      return;
    }
    a().b();
    jdField_a_of_type_ComTencentImcoreMessageConversationFacade$Callback.a(this.jdField_a_of_type_MqqAppAppRuntime, false, paramBoolean2, this);
  }
  
  public boolean a(String paramString)
  {
    return a().c(paramString);
  }
  
  public boolean a(String paramString, int paramInt)
  {
    if (paramString == null) {}
    label329:
    label330:
    label332:
    label339:
    for (;;)
    {
      return false;
      Object localObject;
      String str;
      if (paramInt == 1009)
      {
        localObject = a(paramInt).a(AppConstants.SAME_STATE_BOX_UIN, 1009);
        str = null;
      }
      for (;;)
      {
        if ((localObject == null) || (((List)localObject).isEmpty())) {
          break label339;
        }
        localObject = ((List)localObject).iterator();
        int i = 0;
        if (((Iterator)localObject).hasNext())
        {
          MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
          if (paramString.equals(localMessageRecord.senderuin))
          {
            return true;
            if (paramInt == 1001)
            {
              localObject = a(paramInt).a(AppConstants.LBS_HELLO_UIN, 1001);
              if (localObject != null) {
                ((List)localObject).addAll(a(paramInt).a(AppConstants.NEARBY_LBS_HELLO_UIN, 1001));
              }
              for (;;)
              {
                str = AppConstants.LBS_SAY_HELLO_LIST_UIN;
                break;
                localObject = a(paramInt).a(AppConstants.NEARBY_LBS_HELLO_UIN, 1001);
              }
            }
            if (paramInt == 1010)
            {
              localObject = a(paramInt).a(AppConstants.DATE_UIN, 1010);
              str = AppConstants.DATE_SAY_HELLO_LIST_UIN;
              continue;
            }
            if (paramInt == 1032)
            {
              localObject = a(paramInt).a(AppConstants.CONFESS_UIN, 1032);
              str = null;
              continue;
            }
            if (paramInt == 1044)
            {
              localObject = a(paramInt).a(AppConstants.MATCH_CHAT_UIN, 1044);
              str = null;
              continue;
            }
            if (paramInt != 10008) {
              break label332;
            }
            localObject = a(paramInt).a(AppConstants.QCIRCLE_CHAT_UIN, 10008);
            str = null;
            continue;
          }
          if ((str == null) || (i != 0) || (!str.equals(localMessageRecord.senderuin))) {
            break label329;
          }
          i = 1;
        }
        for (;;)
        {
          break;
          if (i == 0) {
            break label330;
          }
          return a(paramString, paramInt, str);
        }
        break;
        str = null;
        localObject = null;
      }
    }
  }
  
  public boolean a(String paramString1, int paramInt, String paramString2)
  {
    if ((paramString1 == null) || (TextUtils.isEmpty(paramString2))) {
      return false;
    }
    paramString2 = a(paramInt).a(paramString2, paramInt);
    if ((paramString2 != null) && (!paramString2.isEmpty()))
    {
      paramString2 = paramString2.iterator();
      while (paramString2.hasNext()) {
        if (paramString1.equals(((MessageRecord)paramString2.next()).senderuin)) {
          return true;
        }
      }
    }
    return false;
  }
  
  public int b()
  {
    return a() + jdField_a_of_type_ComTencentImcoreMessageConversationFacade$Callback.a(this.jdField_a_of_type_MqqAppAppRuntime);
  }
  
  public int b(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {}
    while ((paramMessageRecord.isSend()) || (paramMessageRecord.isread) || (!jdField_a_of_type_ComTencentImcoreMessageConversationFacade$Callback.e(paramMessageRecord))) {
      return 0;
    }
    return 1;
  }
  
  public int b(String paramString, int paramInt)
  {
    return b(a().a(paramString, paramInt));
  }
  
  public ConversationInfo b(String paramString, int paramInt)
  {
    return a().a(paramString, paramInt);
  }
  
  public void b()
  {
    jdField_a_of_type_ComTencentImcoreMessageConversationFacade$Callback.a(this.jdField_a_of_type_MqqAppAppRuntime, true, true, this);
  }
  
  public void b(String paramString, int paramInt)
  {
    if (AppConstants.CONFESS_UIN.equals(paramString)) {
      d(paramString, paramInt);
    }
    do
    {
      return;
      localObject1 = a(paramInt).a(paramString, paramInt);
    } while ((localObject1 == null) || (((List)localObject1).isEmpty()));
    if (UinTypeUtil.c(paramString))
    {
      c(paramString, paramInt);
      return;
    }
    if (AppConstants.LBS_HELLO_UIN.equals(paramString))
    {
      e(paramString, paramInt);
      return;
    }
    if (AppConstants.NEARBY_LBS_HELLO_UIN.equals(paramString))
    {
      e(paramString, paramInt);
      jdField_a_of_type_ComTencentImcoreMessageConversationFacade$Callback.a(this.jdField_a_of_type_MqqAppAppRuntime, 0);
      return;
    }
    String str = "";
    Object localObject1 = ((List)localObject1).iterator();
    int i = 0;
    int j = 0;
    int k = 0;
    label126:
    Object localObject2;
    int m;
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (MessageRecord)((Iterator)localObject1).next();
      if (UinTypeUtil.c(((MessageRecord)localObject2).senderuin))
      {
        c(((MessageRecord)localObject2).senderuin, ((MessageRecord)localObject2).istroop);
        m = k;
        label177:
        j += e(((MessageRecord)localObject2).senderuin, ((MessageRecord)localObject2).istroop);
        i += f(((MessageRecord)localObject2).senderuin, ((MessageRecord)localObject2).istroop);
        if ((!TextUtils.isEmpty(str)) || (i <= 0)) {
          break label461;
        }
        str = ((MessageRecord)localObject2).senderuin;
      }
    }
    label286:
    label451:
    label461:
    for (;;)
    {
      k = m;
      break label126;
      m = k;
      if (UinTypeUtil.a((MessageRecord)localObject2)) {
        break label177;
      }
      m = k + a(((MessageRecord)localObject2).senderuin, ((MessageRecord)localObject2).istroop);
      break label177;
      if (f(paramString, paramInt) != i)
      {
        m = 1;
        if ((a(paramString, paramInt) != k) || (e(paramString, paramInt) != j) || (m != 0))
        {
          localObject1 = a().a(paramString, paramInt);
          localObject2 = a();
          if (localObject1 != null) {
            break label451;
          }
        }
      }
      for (long l = 0L;; l = ((ConversationInfo)localObject1).lastread)
      {
        ((ConversationProxy)localObject2).a(paramString, paramInt, l, k, j, i);
        if ((UinTypeUtil.j(paramInt)) && (m != 0)) {
          a(a().a(paramString, paramInt), str);
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Q.unread.Facade", 2, "calculateMsgBoxUnreadCount boxUin=" + paramString + ", unread=" + k + ", giftCount=" + j + ", redPacketCount=" + i);
        return;
        m = 0;
        break label286;
      }
    }
  }
  
  public void b(String paramString, int paramInt1, int paramInt2)
  {
    a().c(paramString, paramInt1, paramInt2);
  }
  
  protected void b(String paramString, int paramInt, long paramLong)
  {
    Object localObject2 = a(paramInt).b(paramString, paramInt);
    if ((localObject2 == null) || (((List)localObject2).isEmpty())) {
      if (a().b(paramString, paramInt) > 0) {
        a(paramString, paramInt, paramLong, true);
      }
    }
    while (a(paramString, paramInt, paramLong, (List)localObject2)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.unread.Facade", 2, "updateLastReadSeq uin=" + paramString + ",type=" + paramInt + ",lastread=" + paramLong);
    }
    Object localObject1 = a().a(paramString, paramInt);
    long l;
    label147:
    int i;
    if (localObject1 != null) {
      if (a(paramInt))
      {
        l = Math.max(paramLong, ((ConversationInfo)localObject1).lastread);
        i = ((ConversationInfo)localObject1).unreadCount;
      }
    }
    for (;;)
    {
      label187:
      int j;
      int k;
      int m;
      if (a(paramInt))
      {
        paramLong = ((MessageRecord)((List)localObject2).get(((List)localObject2).size() - 1)).shmsgseq - l;
        j = (int)paramLong;
        if (QLog.isColorLevel()) {
          QLog.d("Q.unread.Facade", 2, "updateLastReadSeq unread =" + j);
        }
        localObject2 = new ConversationFacade.UnreadCounter(this, paramInt, (List)localObject2, l, j, 0, 0, null, null).a();
        j = ((ConversationFacade.UnreadCounter)localObject2).a();
        k = ((ConversationFacade.UnreadCounter)localObject2).b();
        m = ((ConversationFacade.UnreadCounter)localObject2).c();
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder().append("updateLastReadSeq before=");
          if (localObject1 == null) {
            break label416;
          }
        }
      }
      label416:
      for (localObject1 = ((ConversationInfo)localObject1).toString();; localObject1 = null)
      {
        QLog.d("Q.unread.Facade", 2, (String)localObject1 + " , end unread=" + j + ", lastread=" + l + ",unreadGift=" + k + ",unreadRedPacket=" + m);
        a().a(paramString, paramInt, l, j, k, m);
        if ((j == i) || (!UinTypeUtil.b(paramInt))) {
          break;
        }
        d();
        return;
        paramLong = a(paramInt).a(paramString, paramInt, paramLong);
        break label187;
      }
      l = paramLong;
      break label147;
      i = 0;
      l = paramLong;
    }
  }
  
  public boolean b(String paramString, int paramInt)
  {
    RecentUser localRecentUser = a().b(paramString, paramInt);
    if (localRecentUser != null) {
      if (!jdField_a_of_type_ComTencentImcoreMessageConversationFacade$Callback.a(this.jdField_a_of_type_MqqAppAppRuntime, localRecentUser)) {}
    }
    do
    {
      do
      {
        return false;
        return true;
      } while (7000 == paramInt);
      if (!a(paramInt)) {
        return a(paramString);
      }
    } while (!jdField_a_of_type_ComTencentImcoreMessageConversationFacade$Callback.c(this.jdField_a_of_type_MqqAppAppRuntime, paramString));
    return true;
  }
  
  public int c(String paramString, int paramInt)
  {
    return c(a().a(paramString, paramInt));
  }
  
  public void c()
  {
    SharedPreferences localSharedPreferences = a(this.jdField_a_of_type_MqqAppAppRuntime, 1001);
    SharedPreferences.Editor localEditor = localSharedPreferences.edit();
    ConversationFacade localConversationFacade = jdField_a_of_type_ComTencentImcoreMessageConversationFacade$Callback.a(this.jdField_a_of_type_MqqAppAppRuntime);
    Iterator localIterator = a(1001).a(AppConstants.LBS_HELLO_UIN, 1001).iterator();
    int i = 0;
    int j = 0;
    Object localObject;
    if (localIterator.hasNext())
    {
      localObject = (MessageRecord)localIterator.next();
      if (localConversationFacade.f(((MessageRecord)localObject).senderuin, 1001) > 0) {
        break label288;
      }
      localObject = a(((MessageRecord)localObject).senderuin, 0, false);
      if (!localSharedPreferences.contains((String)localObject)) {
        break label288;
      }
      localEditor.remove((String)localObject);
      i += 1;
      j = 1;
    }
    label288:
    for (;;)
    {
      break;
      localIterator = a(1001).a(AppConstants.LBS_SAY_HELLO_LIST_UIN, 1001).iterator();
      while (localIterator.hasNext())
      {
        localObject = (MessageRecord)localIterator.next();
        if (localConversationFacade.f(((MessageRecord)localObject).senderuin, 1001) <= 0)
        {
          localObject = a(((MessageRecord)localObject).senderuin, 0, false);
          if (localSharedPreferences.contains((String)localObject))
          {
            localEditor.remove((String)localObject);
            i += 1;
            j = 1;
          }
        }
      }
      if (j != 0) {
        localEditor.commit();
      }
      if (QLog.isColorLevel()) {
        QLog.i("Q.msg_box", 2, "clearMrSummary2, count=" + i);
      }
      return;
    }
  }
  
  public void c(String paramString, int paramInt)
  {
    Object localObject1 = a(paramInt).a(paramString, paramInt);
    if ((localObject1 == null) || (((List)localObject1).isEmpty())) {
      return;
    }
    int m = 0;
    int i = 0;
    int j = 0;
    String str = "";
    long l1 = this.jdField_a_of_type_MqqAppAppRuntime.getPreferences().getLong(jdField_a_of_type_ComTencentImcoreMessageConversationFacade$Callback.b(), 0L);
    long l2 = this.jdField_a_of_type_MqqAppAppRuntime.getPreferences().getLong(jdField_a_of_type_ComTencentImcoreMessageConversationFacade$Callback.a(), 0L);
    localObject1 = ((List)localObject1).iterator();
    int k = 0;
    label98:
    Object localObject2;
    int n;
    int i1;
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (MessageRecord)((Iterator)localObject1).next();
      Iterator localIterator = a(((MessageRecord)localObject2).istroop).b(((MessageRecord)localObject2).senderuin, ((MessageRecord)localObject2).istroop).iterator();
      MessageRecord localMessageRecord;
      while (localIterator.hasNext())
      {
        localMessageRecord = (MessageRecord)localIterator.next();
        n = k;
        if (localMessageRecord.time > l1)
        {
          n = k;
          if (!localMessageRecord.isread) {
            n = k + 1;
          }
        }
        k = n;
        if (localMessageRecord.time > l2)
        {
          k = n;
          if (!localMessageRecord.isread)
          {
            m += 1;
            k = n;
          }
        }
      }
      if (e(((MessageRecord)localObject2).senderuin, ((MessageRecord)localObject2).istroop) <= 0)
      {
        n = i;
        i1 = j;
        if (f(((MessageRecord)localObject2).senderuin, ((MessageRecord)localObject2).istroop) <= 0) {}
      }
      else
      {
        n = a(((MessageRecord)localObject2).senderuin, ((MessageRecord)localObject2).istroop);
        localIterator = jdField_a_of_type_ComTencentImcoreMessageConversationFacade$Callback.a(this.jdField_a_of_type_MqqAppAppRuntime, (MessageRecord)localObject2, n * 2).iterator();
        for (;;)
        {
          n = i;
          i1 = j;
          if (!localIterator.hasNext()) {
            break;
          }
          localMessageRecord = (MessageRecord)localIterator.next();
          if (localMessageRecord.time > l2)
          {
            i += a(localMessageRecord);
            j += b(localMessageRecord);
          }
        }
      }
      if ((i1 <= 0) || (!TextUtils.isEmpty(str))) {
        break label635;
      }
      str = ((MessageRecord)localObject2).senderuin;
    }
    label461:
    label625:
    label635:
    for (;;)
    {
      i = n;
      j = i1;
      break label98;
      this.jdField_a_of_type_MqqAppAppRuntime.getPreferences().edit().putInt("sp_key_sayhello_box_unread_count", k).commit();
      if (f(paramString, paramInt) != j)
      {
        k = 1;
        if ((a(paramString, paramInt) != m) || (e(paramString, paramInt) != i) || (k != 0))
        {
          localObject1 = a().a(paramString, paramInt);
          localObject2 = a();
          if (localObject1 != null) {
            break label625;
          }
        }
      }
      for (l1 = 0L;; l1 = ((ConversationInfo)localObject1).lastread)
      {
        ((ConversationProxy)localObject2).a(paramString, paramInt, l1, m, i, j);
        if ((UinTypeUtil.j(paramInt)) && (k != 0)) {
          a(a().a(paramString, paramInt), str);
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Q.unread.Facade", 2, "calculateSayHelloBoxUnreadCount boxUin=" + paramString + ", unread=" + m + ", giftCount=" + i + ", redPacketCount=" + j);
        return;
        k = 0;
        break label461;
      }
    }
  }
  
  public void c(String paramString, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.unread.Facade", 2, "rewriteUnreadCount uin=" + paramString + ",type" + paramInt1 + ",unread" + paramInt2);
    }
    a().d(paramString, paramInt1, paramInt2);
  }
  
  public int d(String paramString, int paramInt)
  {
    return d(a().a(paramString, paramInt));
  }
  
  public void d(String paramString, int paramInt)
  {
    jdField_a_of_type_ComTencentImcoreMessageConversationFacade$Callback.a(this.jdField_a_of_type_MqqAppAppRuntime, this, paramString, paramInt);
  }
  
  public void d(String paramString, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.unread.Facade", 2, "increaseUnread uin=" + paramString + ",type" + paramInt1 + ",count" + paramInt2);
    }
    a().e(paramString, paramInt1, paramInt2);
    if (UinTypeUtil.b(paramInt1)) {
      d();
    }
  }
  
  public int e(String paramString, int paramInt)
  {
    return a().c(paramString, paramInt);
  }
  
  public void e(String paramString, int paramInt)
  {
    Object localObject1 = a(paramInt).a(paramString, paramInt);
    if ((localObject1 == null) || (((List)localObject1).isEmpty())) {
      return;
    }
    int m = 0;
    int i = 0;
    int j = 0;
    String str = "";
    long l = this.jdField_a_of_type_MqqAppAppRuntime.getPreferences().getLong(jdField_a_of_type_ComTencentImcoreMessageConversationFacade$Callback.b(), 0L);
    localObject1 = ((List)localObject1).iterator();
    label72:
    Object localObject2;
    int k;
    int n;
    int i1;
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (MessageRecord)((Iterator)localObject1).next();
      if (UinTypeUtil.c(((MessageRecord)localObject2).senderuin))
      {
        c(((MessageRecord)localObject2).senderuin, ((MessageRecord)localObject2).istroop);
        k = m;
      }
      for (;;)
      {
        if (e(((MessageRecord)localObject2).senderuin, ((MessageRecord)localObject2).istroop) <= 0)
        {
          n = i;
          i1 = j;
          if (f(((MessageRecord)localObject2).senderuin, ((MessageRecord)localObject2).istroop) <= 0) {
            break label318;
          }
        }
        m = a(((MessageRecord)localObject2).senderuin, ((MessageRecord)localObject2).istroop);
        Iterator localIterator = jdField_a_of_type_ComTencentImcoreMessageConversationFacade$Callback.a(this.jdField_a_of_type_MqqAppAppRuntime, (MessageRecord)localObject2, m * 2).iterator();
        for (;;)
        {
          n = i;
          i1 = j;
          if (!localIterator.hasNext()) {
            break;
          }
          MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
          if (localMessageRecord.time > l)
          {
            i += a(localMessageRecord);
            j += b(localMessageRecord);
          }
        }
        if ((UinTypeUtil.d(((MessageRecord)localObject2).senderuin)) || (UinTypeUtil.e(((MessageRecord)localObject2).senderuin))) {
          break;
        }
        k = m;
        if (!UinTypeUtil.a((MessageRecord)localObject2)) {
          k = m + a((MessageRecord)localObject2, l);
        }
      }
      label318:
      if ((!TextUtils.isEmpty(str)) || (i1 <= 0)) {
        break label540;
      }
      str = ((MessageRecord)localObject2).senderuin;
    }
    label530:
    label540:
    for (;;)
    {
      m = k;
      i = n;
      j = i1;
      break label72;
      if (f(paramString, paramInt) != j)
      {
        k = 1;
        label366:
        if ((a(paramString, paramInt) != m) || (e(paramString, paramInt) != i) || (k != 0))
        {
          localObject1 = a().a(paramString, paramInt);
          localObject2 = a();
          if (localObject1 != null) {
            break label530;
          }
        }
      }
      for (l = 0L;; l = ((ConversationInfo)localObject1).lastread)
      {
        ((ConversationProxy)localObject2).a(paramString, paramInt, l, m, i, j);
        if ((UinTypeUtil.j(paramInt)) && (k != 0)) {
          a(a().a(paramString, paramInt), str);
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Q.unread.Facade", 2, "calculateMsgBoxUnreadCount boxUin=" + paramString + ", unread=" + m + ", giftCount=" + i + ", redPacketCount=" + j);
        return;
        k = 0;
        break label366;
      }
    }
  }
  
  public int f(String paramString, int paramInt)
  {
    return a().d(paramString, paramInt);
  }
  
  public int g(String paramString, int paramInt)
  {
    return a().a(paramString, paramInt);
  }
  
  public void onDestroy()
  {
    deleteObservers();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.imcore.message.ConversationFacade
 * JD-Core Version:    0.7.0.1
 */