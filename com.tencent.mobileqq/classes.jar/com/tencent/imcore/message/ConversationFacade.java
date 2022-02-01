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
import com.tencent.mobileqq.persistence.service.ICommonFunctionPublishConfigService;
import com.tencent.mobileqq.qroute.QRoute;
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
  public static ConversationFacade.Callback a = new ConversationFacade.2();
  private final AppRuntime b;
  private Set<String> c;
  private Set<String> d;
  private Object e = new Object();
  
  static {}
  
  public ConversationFacade(AppRuntime paramAppRuntime)
  {
    this.b = paramAppRuntime;
  }
  
  public static int a(ConversationInfo paramConversationInfo)
  {
    if (paramConversationInfo == null) {
      return 0;
    }
    paramConversationInfo = a.a(paramConversationInfo);
    int i = ConversationFacadeUtil.a();
    if ((paramConversationInfo.unreadMark > i) && (((ICommonFunctionPublishConfigService)QRoute.api(ICommonFunctionPublishConfigService.class)).isIgnoreInvalidUnreadMark()))
    {
      QLog.e("Q.unread.Facade", 1, new Object[] { "ignore Invalid UnreadMark. info: ", paramConversationInfo });
      return Math.max(paramConversationInfo.unreadCount, 0);
    }
    return Math.max(paramConversationInfo.unreadCount, paramConversationInfo.unreadMark);
  }
  
  private int a(MessageRecord paramMessageRecord, long paramLong)
  {
    long l = paramMessageRecord.time;
    int i = 0;
    if (l <= paramLong) {
      return 0;
    }
    paramMessageRecord = c(paramMessageRecord.istroop).c(paramMessageRecord.senderuin, paramMessageRecord.istroop);
    if (paramMessageRecord == null) {
      return 0;
    }
    paramMessageRecord = paramMessageRecord.iterator();
    while (paramMessageRecord.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)paramMessageRecord.next();
      if ((localMessageRecord.time > paramLong) && (!localMessageRecord.isread)) {
        i += 1;
      }
    }
    return i;
  }
  
  private static SharedPreferences a(AppRuntime paramAppRuntime, int paramInt)
  {
    Object localObject;
    if (paramInt == 1001)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("sp_nearby_summary_");
      ((StringBuilder)localObject).append(paramAppRuntime.getAccount());
      localObject = ((StringBuilder)localObject).toString();
    }
    else
    {
      localObject = "";
    }
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = SharedPreferencesProxyManager.getInstance();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sp_nearby_summary_");
      localStringBuilder.append(paramAppRuntime.getAccount());
      return ((SharedPreferencesProxyManager)localObject).getProxy(localStringBuilder.toString(), 0);
    }
    return null;
  }
  
  public static void a(ConversationFacade.Callback paramCallback)
  {
    a = paramCallback;
  }
  
  private void a(MessageRecord paramMessageRecord, ConversationInfo paramConversationInfo)
  {
    a(paramMessageRecord, paramConversationInfo, 1044);
    a(paramMessageRecord, paramConversationInfo, 10008);
    a(paramMessageRecord, paramConversationInfo, 1045);
  }
  
  private void a(MessageRecord paramMessageRecord, ConversationInfo paramConversationInfo, int paramInt)
  {
    if ((paramConversationInfo != null) && (paramConversationInfo.type == paramInt) && (paramMessageRecord.istroop != paramInt))
    {
      i(paramMessageRecord.frienduin, paramInt);
      if (QLog.isColorLevel())
      {
        paramConversationInfo = new StringBuilder();
        paramConversationInfo.append("addUnread, remove old ConversationInfo,  uin=");
        paramConversationInfo.append(paramMessageRecord.frienduin);
        paramConversationInfo.append(",new type");
        paramConversationInfo.append(paramMessageRecord.istroop);
        QLog.d("Q.unread.Facade", 2, paramConversationInfo.toString());
      }
    }
  }
  
  public static boolean a(int paramInt)
  {
    boolean bool = true;
    if (paramInt != 3000)
    {
      if (paramInt == 1) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  private boolean a(MessageRecord paramMessageRecord, Set<MessageRecord> paramSet)
  {
    if (paramSet != null)
    {
      if (paramSet.isEmpty()) {
        return false;
      }
      paramSet = paramSet.iterator();
      while (paramSet.hasNext()) {
        if (UinTypeUtil.a(paramMessageRecord, (MessageRecord)paramSet.next())) {
          return true;
        }
      }
    }
    return false;
  }
  
  private boolean a(String paramString, int paramInt, long paramLong, List<MessageRecord> paramList)
  {
    if (((a(paramInt)) && (((MessageRecord)paramList.get(paramList.size() - 1)).shmsgseq <= paramLong)) || ((!a(paramInt)) && (((MessageRecord)paramList.get(paramList.size() - 1)).time <= paramLong) && (!UinTypeUtil.f(paramInt)) && (!UinTypeUtil.k(paramInt)) && (!a.a(paramString))))
    {
      if ((i().f(paramString, paramInt) <= 0) && (i().h(paramString, paramInt) <= 0) && (i().i(paramString, paramInt) <= 0))
      {
        if ((paramLong > 0L) && (e(paramString, paramInt) < paramLong)) {
          a(paramString, paramInt, paramLong, false);
        }
        return true;
      }
      a(paramString, paramInt, paramLong, false);
      return true;
    }
    return false;
  }
  
  private boolean a(List<MessageRecord> paramList, MessageRecord paramMessageRecord)
  {
    if ((1001 != paramMessageRecord.istroop) && (10002 != paramMessageRecord.istroop))
    {
      if (1009 == paramMessageRecord.istroop)
      {
        i().a(paramMessageRecord.frienduin, 1009, 1, a(paramMessageRecord), b(paramMessageRecord));
        return false;
      }
      if ((1033 != paramMessageRecord.istroop) && (1034 != paramMessageRecord.istroop))
      {
        if (1008 == paramMessageRecord.istroop)
        {
          c(paramMessageRecord);
          return false;
        }
        if (1044 == UinTypeUtil.e(paramMessageRecord.istroop))
        {
          i().a(paramMessageRecord.frienduin, paramMessageRecord.istroop, 1, a(paramMessageRecord), b(paramMessageRecord));
          a.a(this.b, 1044, paramMessageRecord, paramList);
          return false;
        }
        if (10008 == UinTypeUtil.e(paramMessageRecord.istroop))
        {
          i().a(paramMessageRecord.frienduin, paramMessageRecord.istroop, 1, a(paramMessageRecord), b(paramMessageRecord));
          a.a(this.b, 10008, paramMessageRecord, paramList);
          return false;
        }
        a(paramMessageRecord, i().e(paramMessageRecord.frienduin, paramMessageRecord.istroop));
        int i;
        if (paramMessageRecord.istroop == 10005) {
          i = 1;
        } else {
          i = 0;
        }
        if (i != 0)
        {
          i().b(paramMessageRecord.frienduin, paramMessageRecord.istroop, 1);
          return false;
        }
        if (1038 == paramMessageRecord.istroop) {
          a.a(this.b, 1038, paramMessageRecord, paramList);
        }
        i().a(paramMessageRecord.frienduin, paramMessageRecord.istroop, 1, a(paramMessageRecord), b(paramMessageRecord));
        return false;
      }
      a.a(this.b, 1033, paramMessageRecord, paramList);
      return false;
    }
    return d(paramMessageRecord);
  }
  
  private boolean a(List<MessageRecord> paramList, Set<String> paramSet, boolean paramBoolean)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
      if ((!localMessageRecord.isSendFromLocal()) && (!localMessageRecord.isread) && ((localMessageRecord.msgtype != -2006) || (!a.c(localMessageRecord))))
      {
        Object localObject2 = paramSet;
        if (localMessageRecord.isLongMsg())
        {
          String str = UinTypeUtil.a(localMessageRecord);
          Object localObject1 = paramSet;
          if (paramSet == null) {
            localObject1 = new HashSet();
          }
          if (a.f(localMessageRecord))
          {
            if (a.a(this.b, localMessageRecord))
            {
              paramSet = (Set<String>)localObject1;
              continue;
            }
            if (((Set)localObject1).contains(str))
            {
              paramSet = (Set<String>)localObject1;
              continue;
            }
            ((Set)localObject1).add(str);
            localObject2 = localObject1;
          }
          else
          {
            localObject2 = localObject1;
            if (((Set)localObject1).contains(str))
            {
              ((Set)localObject1).remove(str);
              localObject2 = localObject1;
            }
          }
        }
        if (a(paramList, localMessageRecord))
        {
          paramSet = (Set<String>)localObject2;
        }
        else
        {
          paramSet = (Set<String>)localObject2;
          if (UinTypeUtil.b(localMessageRecord.istroop))
          {
            paramBoolean = true;
            paramSet = (Set<String>)localObject2;
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
  
  private static String b(String paramString, int paramInt, boolean paramBoolean)
  {
    String str;
    if (paramBoolean) {
      str = "lastuin";
    } else {
      str = "sm";
    }
    return String.format("%s_%s_%s", new Object[] { str, paramString, Integer.valueOf(paramInt) });
  }
  
  private Set<String> b(String paramString1, int paramInt, String paramString2)
  {
    long l1;
    if (QLog.isColorLevel())
    {
      l1 = System.currentTimeMillis();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("initSayHelloSet,boxType:");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append(",startTime:");
      ((StringBuilder)localObject1).append(l1);
      QLog.d("Q.msg_box", 2, ((StringBuilder)localObject1).toString());
    }
    else
    {
      l1 = 0L;
    }
    Object localObject2 = a.f(this.b).getSharedPreferences(this.b.getAccount(), 0);
    Object localObject1 = new HashSet();
    paramString1 = c(paramInt).b(paramString1, paramInt);
    long l2 = ((SharedPreferences)localObject2).getLong(paramString2, 0L);
    paramString1 = paramString1.iterator();
    while (paramString1.hasNext())
    {
      paramString2 = (MessageRecord)paramString1.next();
      if (QLog.isDevelopLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("lastTime:");
        ((StringBuilder)localObject2).append(l2);
        ((StringBuilder)localObject2).append(",mr.time:");
        ((StringBuilder)localObject2).append(paramString2.time);
        ((StringBuilder)localObject2).append(",uin:");
        ((StringBuilder)localObject2).append(paramString2.senderuin);
        ((StringBuilder)localObject2).append(",istroop:");
        ((StringBuilder)localObject2).append(paramString2.istroop);
        QLog.d("Q.msg_box", 4, ((StringBuilder)localObject2).toString());
      }
      if ((a(paramString2.senderuin, paramInt) > 0) && (paramString2.time > l2)) {
        ((Set)localObject1).add(paramString2.senderuin);
      }
    }
    if (QLog.isColorLevel())
    {
      l2 = System.currentTimeMillis();
      paramString1 = new StringBuilder();
      paramString1.append("initSayHelloSet,endTime:");
      paramString1.append(l2);
      paramString1.append(",costTime:");
      paramString1.append(l2 - l1);
      QLog.d("Q.msg_box", 2, paramString1.toString());
    }
    return localObject1;
  }
  
  public static int c(ConversationInfo paramConversationInfo)
  {
    if (paramConversationInfo == null) {
      return 0;
    }
    return paramConversationInfo.unreadCount;
  }
  
  private BaseMsgProxy c(int paramInt)
  {
    return a.a(this.b, paramInt);
  }
  
  private void c(MessageRecord paramMessageRecord)
  {
    if (a.a(paramMessageRecord))
    {
      i().b(paramMessageRecord.frienduin, paramMessageRecord.istroop);
      return;
    }
    if ((AppConstants.KANDIAN_SUBSCRIBE_UIN.equals(paramMessageRecord.frienduin)) || (AppConstants.KANDIAN_DAILY_UIN.equals(paramMessageRecord.frienduin))) {
      i().a(paramMessageRecord.frienduin, paramMessageRecord.istroop);
    }
    i().a(paramMessageRecord.frienduin, paramMessageRecord.istroop, 1, a(paramMessageRecord), b(paramMessageRecord));
  }
  
  public static int d(ConversationInfo paramConversationInfo)
  {
    if (paramConversationInfo == null) {
      return 0;
    }
    return paramConversationInfo.unreadMark;
  }
  
  private Set<String> d(int paramInt)
  {
    if (paramInt == 1010)
    {
      if (this.c == null) {
        this.c = b(AppConstants.DATE_SAY_HELLO_LIST_UIN, paramInt, "date_box_last_read_time");
      }
      return this.c;
    }
    if (paramInt == 1001)
    {
      if (this.d == null) {
        this.d = b(AppConstants.LBS_SAY_HELLO_LIST_UIN, paramInt, "lbs_box_last_read_time");
      }
      return this.d;
    }
    return null;
  }
  
  private boolean d(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord.msgtype == -2055)
    {
      a.a(paramMessageRecord, this);
    }
    else
    {
      if ((paramMessageRecord.msgtype == -2053) && ((!a.d(paramMessageRecord)) || (a(paramMessageRecord.frienduin, paramMessageRecord.msgtype) > 0))) {
        return true;
      }
      if (AppConstants.LBS_HELLO_UIN.equals(paramMessageRecord.frienduin)) {
        i().a(paramMessageRecord.senderuin, 1001, 1, a(paramMessageRecord), b(paramMessageRecord));
      } else {
        i().a(paramMessageRecord.frienduin, 1001, 1, a(paramMessageRecord), b(paramMessageRecord));
      }
    }
    return false;
  }
  
  private void e(ConversationInfo paramConversationInfo)
  {
    a.a(this.b, paramConversationInfo, 0);
  }
  
  private void g()
  {
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      ConcurrentHashMap localConcurrentHashMap = c(0).a().b();
      if ((localConcurrentHashMap.get(UinTypeUtil.a(AppConstants.LBS_HELLO_UIN, 1001)) != null) || (localConcurrentHashMap.get(UinTypeUtil.a(AppConstants.SAME_STATE_BOX_UIN, 1009)) != null) || (localConcurrentHashMap.get(UinTypeUtil.a(AppConstants.DATE_UIN, 1010)) != null) || (localConcurrentHashMap.get(UinTypeUtil.a(AppConstants.CONFESS_UIN, 1032)) != null) || (localConcurrentHashMap.get(UinTypeUtil.a(AppConstants.NEARBY_LBS_HELLO_UIN, 1001)) != null) || (localConcurrentHashMap.get(UinTypeUtil.a(AppConstants.MATCH_CHAT_UIN, 1044)) != null) || (localConcurrentHashMap.get(UinTypeUtil.a(AppConstants.QCIRCLE_CHAT_UIN, 10008)) != null)) {
        ThreadManager.post(new ConversationFacade.1(this), 8, null, false);
      }
    }
    else
    {
      h();
    }
  }
  
  private void h()
  {
    k(AppConstants.NEARBY_LBS_HELLO_UIN, 1001);
    k(AppConstants.LBS_HELLO_UIN, 1001);
    k(AppConstants.SAME_STATE_BOX_UIN, 1009);
    k(AppConstants.DATE_UIN, 1010);
    k(AppConstants.CONFESS_UIN, 1032);
    k(AppConstants.MATCH_CHAT_UIN, 1044);
    k(AppConstants.QCIRCLE_CHAT_UIN, 10008);
  }
  
  private ConversationProxy i()
  {
    return a.b(this.b);
  }
  
  private RecentUserProxy j()
  {
    return a.c(this.b);
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
    return a(i().e(paramString, paramInt));
  }
  
  public int a(String paramString, int paramInt1, int paramInt2)
  {
    return a.b(this.b, paramString, paramInt1, paramInt2);
  }
  
  public Set<ConversationInfo> a()
  {
    return i().b();
  }
  
  public void a(int paramInt, long paramLong)
  {
    Set localSet = d(paramInt);
    if (localSet == null) {
      return;
    }
    synchronized (this.e)
    {
      localSet.clear();
      ??? = a.f(this.b).getSharedPreferences(this.b.getAccount(), 0);
      if (paramInt == 1010) {
        ((SharedPreferences)???).edit().putLong("date_box_last_read_time", paramLong).commit();
      } else if (paramInt == 1001) {
        ((SharedPreferences)???).edit().putLong("lbs_box_last_read_time", paramLong).commit();
      }
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append("clearNewSayHelloSet,boxType:");
        ((StringBuilder)???).append(paramInt);
        ((StringBuilder)???).append(",time:");
        ((StringBuilder)???).append(paramLong);
        QLog.d("Q.msg_box", 2, ((StringBuilder)???).toString());
      }
      return;
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    Set localSet = d(paramInt);
    if (localSet != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      synchronized (this.e)
      {
        if (!localSet.contains(paramString)) {
          localSet.add(paramString);
        }
        return;
      }
    }
  }
  
  public void a(ConversationInfo paramConversationInfo, String paramString)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateSummaryLastUin info = ");
      ((StringBuilder)localObject).append(paramConversationInfo);
      ((StringBuilder)localObject).append(", lbsHongbaoLastUin = ");
      ((StringBuilder)localObject).append(paramString);
      QLog.i("Q.msg_box", 2, ((StringBuilder)localObject).toString());
    }
    if ((paramConversationInfo != null) && (UinTypeUtil.l(paramConversationInfo.type)))
    {
      if (TextUtils.isEmpty(paramConversationInfo.uin)) {
        return;
      }
      localObject = a(this.b, paramConversationInfo.type).edit();
      int j = paramConversationInfo.type;
      int i = 1;
      if ((j != 1001) && (paramConversationInfo.type != 10002))
      {
        i = 0;
      }
      else
      {
        if ((!AppConstants.LBS_SAY_HELLO_LIST_UIN.equals(paramConversationInfo.uin)) && (!AppConstants.LBS_HELLO_UIN.equals(paramConversationInfo.uin))) {
          return;
        }
        if ((paramConversationInfo.extInt1 > 0) && (!TextUtils.isEmpty(paramString))) {
          ((SharedPreferences.Editor)localObject).putString(b(paramConversationInfo.uin, 0, true), paramString);
        } else {
          ((SharedPreferences.Editor)localObject).remove(b(paramConversationInfo.uin, 0, true));
        }
      }
      if (i != 0) {
        ((SharedPreferences.Editor)localObject).commit();
      }
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if ((paramInt1 != 1033) && (paramInt1 != 1034))
    {
      a(paramString, paramInt1, i().g(paramString, paramInt1), paramBoolean);
      return;
    }
    a(paramString, paramInt1, a.c(this.b, paramString, paramInt1, paramInt2), true, paramBoolean, paramInt2);
  }
  
  public void a(String paramString, int paramInt, long paramLong)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("cleanUnreadFrom uin=");
      localStringBuilder.append(paramString);
      localStringBuilder.append(",type=");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(",lastread=");
      localStringBuilder.append(paramLong);
      QLog.d("Q.unread.Facade", 2, localStringBuilder.toString());
    }
    boolean bool;
    if (paramInt == 1008) {
      bool = a.a(this.b, paramString);
    } else {
      bool = false;
    }
    if ((paramInt == 1008) && (a.c(this.b, paramString)) && (!bool))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.unread.Facade", 2, "isTroopBarAccount");
      }
      return;
    }
    if ((paramInt == 1008) && (TextUtils.equals(paramString, AppConstants.NEW_KANDIAN_UIN)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.unread.Facade", 2, "NEW_KANDIAN_UIN not unread");
      }
      return;
    }
    b(paramString, paramInt, paramLong);
    c(paramInt).j(paramString, paramInt, paramLong);
    if ((paramInt == 1008) && (bool))
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("inServiceAccountFolder uin=");
        localStringBuilder.append(paramString);
        QLog.d("Q.unread.Facade", 2, localStringBuilder.toString());
      }
      a.b(this.b, paramString);
    }
    a.a(this.b);
    if (a(paramString, paramInt) == 0) {
      bool = true;
    } else {
      bool = false;
    }
    a.a(paramString, paramInt, bool, paramLong);
  }
  
  public void a(String paramString, int paramInt, long paramLong, boolean paramBoolean)
  {
    a(paramString, paramInt, paramLong, true, paramBoolean);
  }
  
  public void a(String paramString, int paramInt, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    long l = SystemClock.elapsedRealtime();
    a(paramString, paramInt, paramLong, paramBoolean1, paramBoolean2, 0);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("cleanUnread() called with: uin = [");
      localStringBuilder.append(paramString);
      localStringBuilder.append("], type = [");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("], lastread = [");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("], needUpdateBox = [");
      localStringBuilder.append(paramBoolean1);
      localStringBuilder.append("], needDelMark = [");
      localStringBuilder.append(paramBoolean2);
      localStringBuilder.append("], costTime = [");
      localStringBuilder.append(SystemClock.elapsedRealtime() - l);
      localStringBuilder.append("]ms");
      QLog.d("Q.unread.Facade", 2, localStringBuilder.toString());
    }
  }
  
  public void a(String paramString, int paramInt1, long paramLong, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
  {
    Object localObject;
    if ((paramInt1 != 1033) && (paramInt1 != 1034))
    {
      long l = i().f(paramString, paramInt1);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("cleanUnread uin=");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(",type");
        ((StringBuilder)localObject).append(paramInt1);
        ((StringBuilder)localObject).append(",unread");
        ((StringBuilder)localObject).append(l);
        ((StringBuilder)localObject).append(" ,lastread");
        ((StringBuilder)localObject).append(paramLong);
        ((StringBuilder)localObject).append(",needDelMark");
        ((StringBuilder)localObject).append(paramBoolean2);
        QLog.d("Q.unread.Facade", 2, ((StringBuilder)localObject).toString());
      }
      if (paramBoolean2) {
        i().c(paramString, paramInt1, 0);
      }
      i().a(paramString, paramInt1, paramLong, 0, 0, 0);
      paramLong = l;
    }
    else
    {
      a.a(this.b, paramString, paramInt1, paramInt2, paramLong);
      paramLong = 0L;
    }
    if (paramLong > 0L)
    {
      if ((UinTypeUtil.b(paramInt1)) && (paramBoolean1)) {
        g();
      }
      localObject = a.a(this.b, paramString, paramInt1, paramInt2);
      if (localObject != null) {
        c(paramInt1).a(paramString, paramInt1, (MessageRecord)localObject, paramInt2);
      }
    }
    a.a(paramString, paramInt1, true, 0L);
  }
  
  public void a(String paramString, int paramInt, MessageRecord paramMessageRecord)
  {
    int i;
    int j;
    if (paramMessageRecord != null)
    {
      i = a(paramMessageRecord);
      j = b(paramMessageRecord);
      i *= -1;
      j *= -1;
    }
    else
    {
      i = 0;
      j = 0;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("increaseUnread uin=");
      localStringBuilder.append(paramString);
      localStringBuilder.append(",type");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(",unreadDiff");
      localStringBuilder.append(-1);
      localStringBuilder.append(",unreadGiftDiff=");
      localStringBuilder.append(i);
      localStringBuilder.append(",unreadRedPacketDiff=");
      localStringBuilder.append(j);
      localStringBuilder.append(",mr=");
      localStringBuilder.append(paramMessageRecord);
      QLog.d("Q.unread.Facade", 2, localStringBuilder.toString());
    }
    i().a(paramString, paramInt, -1, i, j);
    if (UinTypeUtil.b(paramInt)) {
      g();
    }
  }
  
  @Deprecated
  public void a(String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    paramInt2 = i().f(paramString2, paramInt2);
    int i = i().f(paramString1, paramInt1);
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append("moveBoxToMessageTab innerItemUnread=");
      paramString2.append(paramInt2);
      paramString2.append(", convsItemUnread=");
      paramString2.append(i);
      QLog.d("Q.unread.Facade", 2, paramString2.toString());
    }
    k(paramString1, paramInt1);
  }
  
  public void a(String paramString, int paramInt, List<MessageRecord> paramList)
  {
    Iterator localIterator = paramList.iterator();
    int j = 0;
    int i = 0;
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
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("increaseUnread uin=");
          localStringBuilder.append(paramString);
          localStringBuilder.append(",type");
          localStringBuilder.append(paramInt);
          localStringBuilder.append(",unreadDiff");
          localStringBuilder.append(-1);
          localStringBuilder.append(",unreadGiftDiff=");
          localStringBuilder.append(n);
          localStringBuilder.append(",unreadRedPacketDiff=");
          localStringBuilder.append(i1);
          localStringBuilder.append(",mr=");
          localStringBuilder.append(localMessageRecord);
          QLog.d("Q.unread.Facade", 2, localStringBuilder.toString());
          j = k;
          i = m;
        }
      }
    }
    i().a(paramString, paramInt, paramList.size(), j, i);
    if (UinTypeUtil.b(paramInt)) {
      g();
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
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("addUnread msg size=");
        localStringBuilder.append(paramList.size());
        QLog.d("Q.unread.Facade", 2, localStringBuilder.toString());
      }
      if (a(paramList, null, false)) {
        g();
      }
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("cleanAllUnread needUpdateMsgtable=");
      ((StringBuilder)localObject).append(paramBoolean1);
      ((StringBuilder)localObject).append(",needDelMark=");
      ((StringBuilder)localObject).append(paramBoolean2);
      QLog.d("Q.unread.Facade", 2, ((StringBuilder)localObject).toString());
    }
    if (paramBoolean1)
    {
      localObject = i().b().iterator();
      while (((Iterator)localObject).hasNext())
      {
        ConversationInfo localConversationInfo = (ConversationInfo)((Iterator)localObject).next();
        if ((a(localConversationInfo) > 0) && (!AppConstants.FRIEND_SYSTEM_MSG_UIN.equals(localConversationInfo.uin)) && ((!AppConstants.ACTIVATE_FRIENDS_UIN.equals(localConversationInfo.uin)) || (AppConstants.ACTIVATE_FRIENDS_UIN.equals(localConversationInfo.uin)))) {
          a(localConversationInfo.uin, localConversationInfo.type, paramBoolean2);
        }
        e(localConversationInfo);
      }
      a.a(this.b, true, paramBoolean2, this);
      return;
    }
    i().c();
    a.a(this.b, false, paramBoolean2, this);
  }
  
  public boolean a(String paramString)
  {
    return j().e(paramString);
  }
  
  public boolean a(String paramString1, int paramInt, String paramString2)
  {
    if (paramString1 != null)
    {
      if (TextUtils.isEmpty(paramString2)) {
        return false;
      }
      paramString2 = c(paramInt).b(paramString2, paramInt);
      if ((paramString2 != null) && (!paramString2.isEmpty()))
      {
        paramString2 = paramString2.iterator();
        while (paramString2.hasNext()) {
          if (paramString1.equals(((MessageRecord)paramString2.next()).senderuin)) {
            return true;
          }
        }
      }
    }
    return false;
  }
  
  public int b(int paramInt)
  {
    Set localSet = d(paramInt);
    if (localSet != null) {
      synchronized (this.e)
      {
        i = localSet.size();
      }
    }
    int i = 0;
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("getUnreadSayHelloNum,boxType:");
      ((StringBuilder)???).append(paramInt);
      ((StringBuilder)???).append(",num:");
      ((StringBuilder)???).append(i);
      QLog.d("Q.msg_box", 2, ((StringBuilder)???).toString());
    }
    return i;
  }
  
  public int b(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return 0;
    }
    if ((!paramMessageRecord.isSend()) && (!paramMessageRecord.isread) && (a.e(paramMessageRecord))) {
      return 1;
    }
    return 0;
  }
  
  public int b(String paramString, int paramInt)
  {
    return b(i().e(paramString, paramInt));
  }
  
  public String b(String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    String str = paramString2;
    if (!TextUtils.isEmpty(paramString1))
    {
      if (!UinTypeUtil.l(paramInt1)) {
        return paramString2;
      }
      SharedPreferences localSharedPreferences = a(this.b, paramInt1);
      if ((paramInt1 != 1001) && (paramInt1 != 10002))
      {
        str = null;
      }
      else
      {
        str = paramString2;
        if (paramInt2 < 0) {
          break label196;
        }
        if (paramInt2 > 0) {
          return paramString2;
        }
        if (AppConstants.LBS_HELLO_UIN.equals(paramString1))
        {
          paramString1 = localSharedPreferences.getString(b(AppConstants.LBS_HELLO_UIN, paramInt2, true), "");
          str = paramString1;
          if (AppConstants.LBS_SAY_HELLO_LIST_UIN.equals(paramString1)) {
            str = localSharedPreferences.getString(b(AppConstants.LBS_SAY_HELLO_LIST_UIN, paramInt2, true), "");
          }
        }
        else
        {
          str = paramString1;
          if (AppConstants.LBS_SAY_HELLO_LIST_UIN.equals(paramString1)) {
            str = localSharedPreferences.getString(b(AppConstants.LBS_SAY_HELLO_LIST_UIN, paramInt2, true), "");
          }
        }
      }
      if (TextUtils.isEmpty(str)) {
        return paramString2;
      }
      str = SecurityUtile.decode(localSharedPreferences.getString(b(str, paramInt2, false), paramString2));
    }
    label196:
    return str;
  }
  
  public void b()
  {
    i().a();
    a.g(this.b);
    Object localObject2 = i().b();
    Object localObject1 = new HashSet();
    localObject2 = ((Set)localObject2).iterator();
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (ConversationInfo)((Iterator)localObject2).next();
      StringBuilder localStringBuilder;
      if (o(((ConversationInfo)localObject3).uin, ((ConversationInfo)localObject3).type))
      {
        if (UinTypeUtil.c(((ConversationInfo)localObject3).uin, ((ConversationInfo)localObject3).type)) {
          k(((ConversationInfo)localObject3).uin, ((ConversationInfo)localObject3).type);
        }
        if ((QLog.isColorLevel()) && ((a((ConversationInfo)localObject3) != 0) || (((ConversationInfo)localObject3).unreadGiftCount != 0) || (((ConversationInfo)localObject3).extInt1 != 0)))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("initCache info=");
          localStringBuilder.append(((ConversationInfo)localObject3).toString());
          QLog.d("Q.unread.Facade", 2, localStringBuilder.toString());
        }
      }
      else
      {
        if ((UinTypeUtil.j(((ConversationInfo)localObject3).type)) && (!UinTypeUtil.c(((ConversationInfo)localObject3).uin, ((ConversationInfo)localObject3).type)) && (!j(((ConversationInfo)localObject3).uin, UinTypeUtil.e(((ConversationInfo)localObject3).type)))) {
          ((Set)localObject1).add(localObject3);
        }
        if ((QLog.isColorLevel()) && ((a((ConversationInfo)localObject3) != 0) || (((ConversationInfo)localObject3).unreadGiftCount != 0) || (((ConversationInfo)localObject3).extInt1 != 0)))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("initCache [not in recent] info=");
          localStringBuilder.append(((ConversationInfo)localObject3).toString());
          QLog.d("Q.unread.Facade", 2, localStringBuilder.toString());
        }
      }
      if ((a((ConversationInfo)localObject3) == 0) && ((((ConversationInfo)localObject3).unreadGiftCount != 0) || (((ConversationInfo)localObject3).extInt1 != 0))) {
        a(((ConversationInfo)localObject3).uin, ((ConversationInfo)localObject3).unreadGiftCount, false);
      }
    }
    if (!((Set)localObject1).isEmpty())
    {
      localObject1 = ((Set)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ConversationInfo)((Iterator)localObject1).next();
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("initCache remove info=");
          ((StringBuilder)localObject3).append(((ConversationInfo)localObject2).toString());
          QLog.d("Q.unread.Facade", 2, ((StringBuilder)localObject3).toString());
        }
        i().d(((ConversationInfo)localObject2).uin, ((ConversationInfo)localObject2).type);
      }
    }
  }
  
  public void b(String paramString, int paramInt1, int paramInt2)
  {
    i().c(paramString, paramInt1, paramInt2);
  }
  
  public void b(String paramString, int paramInt, long paramLong)
  {
    Object localObject2 = c(paramInt).c(paramString, paramInt);
    if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
    {
      if (a(paramString, paramInt, paramLong, (List)localObject2)) {
        return;
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("updateLastReadSeq uin=");
        ((StringBuilder)localObject1).append(paramString);
        ((StringBuilder)localObject1).append(",type=");
        ((StringBuilder)localObject1).append(paramInt);
        ((StringBuilder)localObject1).append(",lastread=");
        ((StringBuilder)localObject1).append(paramLong);
        QLog.d("Q.unread.Facade", 2, ((StringBuilder)localObject1).toString());
      }
      Object localObject1 = i().e(paramString, paramInt);
      long l;
      int i;
      if (localObject1 != null)
      {
        if (a(paramInt)) {
          l = Math.max(paramLong, ((ConversationInfo)localObject1).lastread);
        } else {
          l = paramLong;
        }
        i = ((ConversationInfo)localObject1).unreadCount;
      }
      else
      {
        l = paramLong;
        i = 0;
      }
      if (a(paramInt)) {
        paramLong = ((MessageRecord)((List)localObject2).get(((List)localObject2).size() - 1)).shmsgseq - l;
      } else {
        paramLong = c(paramInt).f(paramString, paramInt, paramLong);
      }
      int j = (int)paramLong;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("updateLastReadSeq unread =");
        localStringBuilder.append(j);
        QLog.d("Q.unread.Facade", 2, localStringBuilder.toString());
      }
      localObject2 = new ConversationFacade.UnreadCounter(this, paramInt, (List)localObject2, l, j, 0, 0, null, null).d();
      j = ((ConversationFacade.UnreadCounter)localObject2).a();
      int k = ((ConversationFacade.UnreadCounter)localObject2).b();
      int m = ((ConversationFacade.UnreadCounter)localObject2).c();
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("updateLastReadSeq before=");
        if (localObject1 != null) {
          localObject1 = ((ConversationInfo)localObject1).toString();
        } else {
          localObject1 = null;
        }
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(" , end unread=");
        ((StringBuilder)localObject2).append(j);
        ((StringBuilder)localObject2).append(", lastread=");
        ((StringBuilder)localObject2).append(l);
        ((StringBuilder)localObject2).append(",unreadGift=");
        ((StringBuilder)localObject2).append(k);
        ((StringBuilder)localObject2).append(",unreadRedPacket=");
        ((StringBuilder)localObject2).append(m);
        QLog.d("Q.unread.Facade", 2, ((StringBuilder)localObject2).toString());
      }
      i().a(paramString, paramInt, l, j, k, m);
      if ((j != i) && (UinTypeUtil.b(paramInt))) {
        g();
      }
      return;
    }
    if (i().f(paramString, paramInt) > 0) {
      a(paramString, paramInt, paramLong, true);
    }
  }
  
  public int c()
  {
    return this.b.getPreferences().getInt("sp_key_sayhello_box_unread_count", 0);
  }
  
  public int c(String paramString, int paramInt)
  {
    return c(i().e(paramString, paramInt));
  }
  
  public void c(String paramString, int paramInt1, int paramInt2)
  {
    i().d(paramString, paramInt1, paramInt2);
  }
  
  public int d()
  {
    return c() + a.e(this.b);
  }
  
  public int d(String paramString, int paramInt)
  {
    return d(i().e(paramString, paramInt));
  }
  
  public void d(String paramString, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("rewriteUnreadCount uin=");
      localStringBuilder.append(paramString);
      localStringBuilder.append(",type");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(",unread");
      localStringBuilder.append(paramInt2);
      QLog.d("Q.unread.Facade", 2, localStringBuilder.toString());
    }
    i().e(paramString, paramInt1, paramInt2);
  }
  
  public long e(String paramString, int paramInt)
  {
    return i().g(paramString, paramInt);
  }
  
  public void e()
  {
    a.a(this.b, true, true, this);
  }
  
  public void e(String paramString, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("increaseUnread uin=");
      localStringBuilder.append(paramString);
      localStringBuilder.append(",type");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(",count");
      localStringBuilder.append(paramInt2);
      QLog.d("Q.unread.Facade", 2, localStringBuilder.toString());
    }
    i().f(paramString, paramInt1, paramInt2);
    if (UinTypeUtil.b(paramInt1)) {
      g();
    }
  }
  
  public int f(String paramString, int paramInt)
  {
    return i().h(paramString, paramInt);
  }
  
  public void f()
  {
    Object localObject1 = a(this.b, 1001);
    SharedPreferences.Editor localEditor = ((SharedPreferences)localObject1).edit();
    ConversationFacade localConversationFacade = a.d(this.b);
    Iterator localIterator = c(1001).b(AppConstants.LBS_HELLO_UIN, 1001).iterator();
    int i = 0;
    int j = 0;
    Object localObject2;
    while (localIterator.hasNext())
    {
      localObject2 = (MessageRecord)localIterator.next();
      if (localConversationFacade.g(((MessageRecord)localObject2).senderuin, 1001) <= 0)
      {
        localObject2 = b(((MessageRecord)localObject2).senderuin, 0, false);
        if (((SharedPreferences)localObject1).contains((String)localObject2))
        {
          localEditor.remove((String)localObject2);
          i += 1;
          j = 1;
        }
      }
    }
    localIterator = c(1001).b(AppConstants.LBS_SAY_HELLO_LIST_UIN, 1001).iterator();
    while (localIterator.hasNext())
    {
      localObject2 = (MessageRecord)localIterator.next();
      if (localConversationFacade.g(((MessageRecord)localObject2).senderuin, 1001) <= 0)
      {
        localObject2 = b(((MessageRecord)localObject2).senderuin, 0, false);
        if (((SharedPreferences)localObject1).contains((String)localObject2))
        {
          localEditor.remove((String)localObject2);
          i += 1;
          j = 1;
        }
      }
    }
    if (j != 0) {
      localEditor.commit();
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("clearMrSummary2, count=");
      ((StringBuilder)localObject1).append(i);
      QLog.i("Q.msg_box", 2, ((StringBuilder)localObject1).toString());
    }
  }
  
  public int g(String paramString, int paramInt)
  {
    return i().i(paramString, paramInt);
  }
  
  public int h(String paramString, int paramInt)
  {
    return i().c(paramString, paramInt);
  }
  
  public void i(String paramString, int paramInt)
  {
    a(paramString, paramInt, true);
    i().d(paramString, paramInt);
  }
  
  public boolean j(String paramString, int paramInt)
  {
    if (paramString == null) {
      return false;
    }
    String str = null;
    Object localObject;
    if (paramInt == 1009)
    {
      localObject = c(paramInt).b(AppConstants.SAME_STATE_BOX_UIN, 1009);
    }
    else
    {
      if (paramInt == 1001)
      {
        localObject = c(paramInt).b(AppConstants.LBS_HELLO_UIN, 1001);
        if (localObject != null) {
          ((List)localObject).addAll(c(paramInt).b(AppConstants.NEARBY_LBS_HELLO_UIN, 1001));
        } else {
          localObject = c(paramInt).b(AppConstants.NEARBY_LBS_HELLO_UIN, 1001);
        }
        str = AppConstants.LBS_SAY_HELLO_LIST_UIN;
      }
      else
      {
        if (paramInt != 1010) {
          break label143;
        }
        localObject = c(paramInt).b(AppConstants.DATE_UIN, 1010);
        str = AppConstants.DATE_SAY_HELLO_LIST_UIN;
      }
      break label224;
      label143:
      if (paramInt == 1032) {
        localObject = c(paramInt).b(AppConstants.CONFESS_UIN, 1032);
      } else if (paramInt == 1044) {
        localObject = c(paramInt).b(AppConstants.MATCH_CHAT_UIN, 1044);
      } else if (paramInt == 10008) {
        localObject = c(paramInt).b(AppConstants.QCIRCLE_CHAT_UIN, 10008);
      } else {
        localObject = null;
      }
    }
    label224:
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localObject = ((List)localObject).iterator();
      for (int i = 0; ((Iterator)localObject).hasNext(); i = 1)
      {
        label250:
        MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
        if (paramString.equals(localMessageRecord.senderuin)) {
          return true;
        }
        if ((str == null) || (i != 0) || (!str.equals(localMessageRecord.senderuin))) {
          break label250;
        }
      }
      if (i != 0) {
        return a(paramString, paramInt, str);
      }
    }
    return false;
  }
  
  public void k(String paramString, int paramInt)
  {
    if (AppConstants.CONFESS_UIN.equals(paramString))
    {
      m(paramString, paramInt);
      return;
    }
    Object localObject1 = c(paramInt).b(paramString, paramInt);
    if (localObject1 != null)
    {
      if (((List)localObject1).isEmpty()) {
        return;
      }
      if (UinTypeUtil.c(paramString))
      {
        l(paramString, paramInt);
        return;
      }
      if (AppConstants.LBS_HELLO_UIN.equals(paramString))
      {
        n(paramString, paramInt);
        return;
      }
      if (AppConstants.NEARBY_LBS_HELLO_UIN.equals(paramString))
      {
        n(paramString, paramInt);
        a.b(this.b, 0);
        return;
      }
      Object localObject2 = ((List)localObject1).iterator();
      localObject1 = "";
      int j = 0;
      int k = 0;
      int i = 0;
      Object localObject3;
      int m;
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (MessageRecord)((Iterator)localObject2).next();
        if (UinTypeUtil.c(((MessageRecord)localObject3).senderuin))
        {
          l(((MessageRecord)localObject3).senderuin, ((MessageRecord)localObject3).istroop);
          m = k;
        }
        else
        {
          m = k;
          if (!UinTypeUtil.c((MessageRecord)localObject3)) {
            m = k + a(((MessageRecord)localObject3).senderuin, ((MessageRecord)localObject3).istroop);
          }
        }
        int n = i + f(((MessageRecord)localObject3).senderuin, ((MessageRecord)localObject3).istroop);
        int i1 = j + g(((MessageRecord)localObject3).senderuin, ((MessageRecord)localObject3).istroop);
        j = i1;
        k = m;
        i = n;
        if (TextUtils.isEmpty((CharSequence)localObject1))
        {
          j = i1;
          k = m;
          i = n;
          if (i1 > 0)
          {
            localObject1 = ((MessageRecord)localObject3).senderuin;
            j = i1;
            k = m;
            i = n;
          }
        }
      }
      if (g(paramString, paramInt) != j) {
        m = 1;
      } else {
        m = 0;
      }
      if ((a(paramString, paramInt) != k) || (f(paramString, paramInt) != i) || (m != 0))
      {
        localObject2 = i().e(paramString, paramInt);
        localObject3 = i();
        long l;
        if (localObject2 == null) {
          l = 0L;
        } else {
          l = ((ConversationInfo)localObject2).lastread;
        }
        ((ConversationProxy)localObject3).a(paramString, paramInt, l, k, i, j);
        if ((UinTypeUtil.l(paramInt)) && (m != 0)) {
          a(i().e(paramString, paramInt), (String)localObject1);
        }
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("calculateMsgBoxUnreadCount boxUin=");
        ((StringBuilder)localObject1).append(paramString);
        ((StringBuilder)localObject1).append(", unread=");
        ((StringBuilder)localObject1).append(k);
        ((StringBuilder)localObject1).append(", giftCount=");
        ((StringBuilder)localObject1).append(i);
        ((StringBuilder)localObject1).append(", redPacketCount=");
        ((StringBuilder)localObject1).append(j);
        QLog.d("Q.unread.Facade", 2, ((StringBuilder)localObject1).toString());
      }
    }
  }
  
  public void l(String paramString, int paramInt)
  {
    Object localObject1 = c(paramInt).b(paramString, paramInt);
    if (localObject1 != null)
    {
      if (((List)localObject1).isEmpty()) {
        return;
      }
      long l1 = this.b.getPreferences().getLong(a.b(), 0L);
      long l2 = this.b.getPreferences().getLong(a.a(), 0L);
      Object localObject2 = ((List)localObject1).iterator();
      localObject1 = "";
      int m = 0;
      int j = 0;
      int k = 0;
      int i = 0;
      while (((Iterator)localObject2).hasNext())
      {
        localObject4 = (MessageRecord)((Iterator)localObject2).next();
        localObject3 = c(((MessageRecord)localObject4).istroop).c(((MessageRecord)localObject4).senderuin, ((MessageRecord)localObject4).istroop).iterator();
        MessageRecord localMessageRecord;
        int n;
        int i1;
        while (((Iterator)localObject3).hasNext())
        {
          localMessageRecord = (MessageRecord)((Iterator)localObject3).next();
          n = m;
          if (localMessageRecord.time > l1)
          {
            n = m;
            if (!localMessageRecord.isread) {
              n = m + 1;
            }
          }
          i1 = k;
          if (localMessageRecord.time > l2)
          {
            i1 = k;
            if (!localMessageRecord.isread) {
              i1 = k + 1;
            }
          }
          m = n;
          k = i1;
        }
        if (f(((MessageRecord)localObject4).senderuin, ((MessageRecord)localObject4).istroop) <= 0)
        {
          i1 = j;
          n = i;
          if (g(((MessageRecord)localObject4).senderuin, ((MessageRecord)localObject4).istroop) <= 0) {}
        }
        else
        {
          n = a(((MessageRecord)localObject4).senderuin, ((MessageRecord)localObject4).istroop);
          localObject3 = a.a(this.b, (MessageRecord)localObject4, n * 2).iterator();
          for (;;)
          {
            i1 = j;
            n = i;
            if (!((Iterator)localObject3).hasNext()) {
              break;
            }
            localMessageRecord = (MessageRecord)((Iterator)localObject3).next();
            if (localMessageRecord.time > l2)
            {
              i += a(localMessageRecord);
              j += b(localMessageRecord);
            }
          }
        }
        localObject3 = localObject1;
        if (i1 > 0)
        {
          localObject3 = localObject1;
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            localObject3 = ((MessageRecord)localObject4).senderuin;
          }
        }
        j = i1;
        i = n;
        localObject1 = localObject3;
      }
      this.b.getPreferences().edit().putInt("sp_key_sayhello_box_unread_count", m).commit();
      if (g(paramString, paramInt) != j) {
        m = 1;
      } else {
        m = 0;
      }
      if ((a(paramString, paramInt) == k) && (f(paramString, paramInt) == i) && (m == 0)) {
        break label600;
      }
      Object localObject3 = i();
      localObject2 = paramString;
      localObject3 = ((ConversationProxy)localObject3).e((String)localObject2, paramInt);
      Object localObject4 = i();
      if (localObject3 == null) {
        l1 = 0L;
      } else {
        l1 = ((ConversationInfo)localObject3).lastread;
      }
      ((ConversationProxy)localObject4).a(paramString, paramInt, l1, k, i, j);
      if ((UinTypeUtil.l(paramInt)) && (m != 0)) {
        a(i().e((String)localObject2, paramInt), (String)localObject1);
      }
      label600:
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("calculateSayHelloBoxUnreadCount boxUin=");
        ((StringBuilder)localObject1).append(paramString);
        ((StringBuilder)localObject1).append(", unread=");
        ((StringBuilder)localObject1).append(k);
        ((StringBuilder)localObject1).append(", giftCount=");
        ((StringBuilder)localObject1).append(i);
        ((StringBuilder)localObject1).append(", redPacketCount=");
        ((StringBuilder)localObject1).append(j);
        QLog.d("Q.unread.Facade", 2, ((StringBuilder)localObject1).toString());
      }
    }
  }
  
  public void m(String paramString, int paramInt)
  {
    a.a(this.b, this, paramString, paramInt);
  }
  
  public void n(String paramString, int paramInt)
  {
    Object localObject1 = c(paramInt).b(paramString, paramInt);
    if (localObject1 != null)
    {
      if (((List)localObject1).isEmpty()) {
        return;
      }
      long l = this.b.getPreferences().getLong(a.b(), 0L);
      Iterator localIterator = ((List)localObject1).iterator();
      Object localObject2 = "";
      int j = 0;
      int m = 0;
      int i = 0;
      int k;
      Object localObject3;
      while (localIterator.hasNext())
      {
        localObject1 = (MessageRecord)localIterator.next();
        if (UinTypeUtil.c(((MessageRecord)localObject1).senderuin))
        {
          l(((MessageRecord)localObject1).senderuin, ((MessageRecord)localObject1).istroop);
          k = m;
        }
        else
        {
          i1 = j;
          i2 = m;
          i3 = i;
          localObject4 = localObject2;
          if (UinTypeUtil.d(((MessageRecord)localObject1).senderuin)) {
            break label444;
          }
          if (UinTypeUtil.e(((MessageRecord)localObject1).senderuin))
          {
            i1 = j;
            i2 = m;
            i3 = i;
            localObject4 = localObject2;
            break label444;
          }
          k = m;
          if (!UinTypeUtil.c((MessageRecord)localObject1)) {
            k = m + a((MessageRecord)localObject1, l);
          }
        }
        int n;
        if (f(((MessageRecord)localObject1).senderuin, ((MessageRecord)localObject1).istroop) <= 0)
        {
          localObject3 = localObject1;
          m = j;
          n = i;
          if (g(((MessageRecord)localObject1).senderuin, ((MessageRecord)localObject1).istroop) <= 0) {
            break label380;
          }
        }
        m = a(((MessageRecord)localObject1).senderuin, ((MessageRecord)localObject1).istroop);
        Object localObject4 = a.a(this.b, (MessageRecord)localObject1, m * 2).iterator();
        for (;;)
        {
          localObject3 = localObject1;
          m = j;
          n = i;
          if (!((Iterator)localObject4).hasNext()) {
            break;
          }
          localObject3 = (MessageRecord)((Iterator)localObject4).next();
          n = j;
          m = i;
          if (((MessageRecord)localObject3).time > l)
          {
            m = i + a((MessageRecord)localObject3);
            n = j + b((MessageRecord)localObject3);
          }
          j = n;
          i = m;
        }
        label380:
        int i1 = m;
        int i2 = k;
        int i3 = n;
        localObject4 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2))
        {
          i1 = m;
          i2 = k;
          i3 = n;
          localObject4 = localObject2;
          if (m > 0)
          {
            localObject4 = ((MessageRecord)localObject3).senderuin;
            i3 = n;
            i2 = k;
            i1 = m;
          }
        }
        label444:
        j = i1;
        m = i2;
        i = i3;
        localObject2 = localObject4;
      }
      if (g(paramString, paramInt) != j) {
        k = 1;
      } else {
        k = 0;
      }
      if ((a(paramString, paramInt) != m) || (f(paramString, paramInt) != i) || (k != 0))
      {
        localObject1 = i().e(paramString, paramInt);
        localObject3 = i();
        if (localObject1 == null) {
          l = 0L;
        } else {
          l = ((ConversationInfo)localObject1).lastread;
        }
        ((ConversationProxy)localObject3).a(paramString, paramInt, l, m, i, j);
        if ((UinTypeUtil.l(paramInt)) && (k != 0)) {
          a(i().e(paramString, paramInt), (String)localObject2);
        }
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("calculateMsgBoxUnreadCount boxUin=");
        ((StringBuilder)localObject1).append(paramString);
        ((StringBuilder)localObject1).append(", unread=");
        ((StringBuilder)localObject1).append(m);
        ((StringBuilder)localObject1).append(", giftCount=");
        ((StringBuilder)localObject1).append(i);
        ((StringBuilder)localObject1).append(", redPacketCount=");
        ((StringBuilder)localObject1).append(j);
        QLog.d("Q.unread.Facade", 2, ((StringBuilder)localObject1).toString());
      }
    }
  }
  
  public boolean o(String paramString, int paramInt)
  {
    RecentUser localRecentUser = j().c(paramString, paramInt);
    if (localRecentUser != null) {
      return !a.a(this.b, localRecentUser);
    }
    if (7000 == paramInt) {
      return false;
    }
    if (!a(paramInt)) {
      return a(paramString);
    }
    return a.d(this.b, paramString);
  }
  
  public void onDestroy()
  {
    deleteObservers();
  }
  
  public ConversationInfo p(String paramString, int paramInt)
  {
    try
    {
      paramString = i().e(paramString, paramInt);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public ConversationInfo q(String paramString, int paramInt)
  {
    return i().e(paramString, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.ConversationFacade
 * JD-Core Version:    0.7.0.1
 */