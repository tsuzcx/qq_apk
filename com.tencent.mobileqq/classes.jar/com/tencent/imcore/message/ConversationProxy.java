package com.tencent.imcore.message;

import android.os.Bundle;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.commonsdk.cache.QQConcurrentHashMap;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.proxy.BaseProxy;
import com.tencent.mobileqq.app.proxy.BaseProxyManager;
import com.tencent.mobileqq.data.ConversationInfo;
import com.tencent.mobileqq.imcore.proxy.business.TempMsgBoxManagerProxy;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.NoColumnErrorHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.Iterator;
import mqq.app.AppRuntime;

public class ConversationProxy
  extends BaseProxy
{
  protected QQConcurrentHashMap<String, ConversationInfo> a = new QQConcurrentHashMap(1005, 0, 100);
  EntityManager b = null;
  NoColumnErrorHandler c = new ConversationProxy.1(this);
  private Object d = new Object();
  private boolean e = false;
  
  public ConversationProxy(AppRuntime paramAppRuntime, BaseProxyManager paramBaseProxyManager)
  {
    super(paramAppRuntime, paramBaseProxyManager);
  }
  
  private boolean a(int paramInt1, int paramInt2)
  {
    return ((paramInt1 == 10010) && (paramInt2 == 0)) || ((paramInt1 == 0) && (paramInt2 == 10010));
  }
  
  private boolean b(int paramInt1, int paramInt2)
  {
    return ((paramInt1 == 1022) && (paramInt2 == 0)) || ((paramInt1 == 0) && (paramInt2 == 1022));
  }
  
  private boolean c(int paramInt1, int paramInt2)
  {
    return ((paramInt1 == 1004) && (paramInt2 == 0)) || ((paramInt1 == 0) && (paramInt2 == 1004));
  }
  
  private EntityManager d()
  {
    ??? = this.b;
    if ((??? == null) || (!((EntityManager)???).isOpen())) {}
    synchronized (this.d)
    {
      if ((this.b == null) || (!this.b.isOpen())) {
        this.b = this.app.getEntityManagerFactory().createEntityManager();
      }
      return this.b;
    }
  }
  
  private boolean d(int paramInt1, int paramInt2)
  {
    return ((paramInt1 == 1023) && (paramInt2 == 0)) || ((paramInt1 == 0) && (paramInt2 == 1023));
  }
  
  private boolean e(int paramInt1, int paramInt2)
  {
    return ((paramInt1 == 1006) && (paramInt2 == 0)) || ((paramInt1 == 0) && (paramInt2 == 1006));
  }
  
  private boolean f(int paramInt1, int paramInt2)
  {
    return ((paramInt1 == 1000) && (paramInt2 == 0)) || ((paramInt1 == 0) && (paramInt2 == 1000));
  }
  
  /* Error */
  protected void a()
  {
    // Byte code:
    //   0: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +11 -> 14
    //   6: ldc 79
    //   8: iconst_2
    //   9: ldc 81
    //   11: invokestatic 85	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   14: aload_0
    //   15: getfield 44	com/tencent/imcore/message/ConversationProxy:a	Lcom/tencent/commonsdk/cache/QQConcurrentHashMap;
    //   18: invokevirtual 88	com/tencent/commonsdk/cache/QQConcurrentHashMap:clear	()V
    //   21: aload_0
    //   22: invokespecial 90	com/tencent/imcore/message/ConversationProxy:d	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   25: ldc 92
    //   27: invokestatic 96	com/tencent/mobileqq/data/ConversationInfo:getConversationInfoTableName	()Ljava/lang/String;
    //   30: iconst_0
    //   31: aconst_null
    //   32: aconst_null
    //   33: aconst_null
    //   34: aconst_null
    //   35: aconst_null
    //   36: aconst_null
    //   37: aload_0
    //   38: getfield 37	com/tencent/imcore/message/ConversationProxy:c	Lcom/tencent/mobileqq/persistence/NoColumnErrorHandler;
    //   41: invokevirtual 100	com/tencent/mobileqq/persistence/EntityManager:query	(Ljava/lang/Class;Ljava/lang/String;ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/persistence/NoColumnErrorHandler;)Ljava/util/List;
    //   44: astore_2
    //   45: aload_0
    //   46: getfield 30	com/tencent/imcore/message/ConversationProxy:e	Z
    //   49: ifeq +44 -> 93
    //   52: aload_0
    //   53: invokespecial 90	com/tencent/imcore/message/ConversationProxy:d	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   56: ldc 92
    //   58: invokevirtual 104	com/tencent/mobileqq/persistence/EntityManager:drop	(Ljava/lang/Class;)Z
    //   61: pop
    //   62: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   65: ifeq +11 -> 76
    //   68: ldc 79
    //   70: iconst_2
    //   71: ldc 106
    //   73: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   76: invokestatic 114	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   79: invokestatic 120	com/tencent/mobileqq/statistics/StatisticCollector:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   82: aconst_null
    //   83: ldc 122
    //   85: iconst_1
    //   86: lconst_1
    //   87: lconst_0
    //   88: aconst_null
    //   89: aconst_null
    //   90: invokevirtual 126	com/tencent/mobileqq/statistics/StatisticCollector:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   93: aload_2
    //   94: ifnonnull +4 -> 98
    //   97: return
    //   98: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   101: ifeq +39 -> 140
    //   104: new 128	java/lang/StringBuilder
    //   107: dup
    //   108: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   111: astore_3
    //   112: aload_3
    //   113: ldc 131
    //   115: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: pop
    //   119: aload_3
    //   120: aload_2
    //   121: invokeinterface 141 1 0
    //   126: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   129: pop
    //   130: ldc 79
    //   132: iconst_2
    //   133: aload_3
    //   134: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   137: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   140: iconst_0
    //   141: istore_1
    //   142: iload_1
    //   143: aload_2
    //   144: invokeinterface 141 1 0
    //   149: if_icmpge +57 -> 206
    //   152: aload_0
    //   153: getfield 44	com/tencent/imcore/message/ConversationProxy:a	Lcom/tencent/commonsdk/cache/QQConcurrentHashMap;
    //   156: aload_2
    //   157: iload_1
    //   158: invokeinterface 151 2 0
    //   163: checkcast 92	com/tencent/mobileqq/data/ConversationInfo
    //   166: getfield 155	com/tencent/mobileqq/data/ConversationInfo:uin	Ljava/lang/String;
    //   169: aload_2
    //   170: iload_1
    //   171: invokeinterface 151 2 0
    //   176: checkcast 92	com/tencent/mobileqq/data/ConversationInfo
    //   179: getfield 159	com/tencent/mobileqq/data/ConversationInfo:type	I
    //   182: invokestatic 164	com/tencent/imcore/message/UinTypeUtil:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   185: aload_2
    //   186: iload_1
    //   187: invokeinterface 151 2 0
    //   192: invokevirtual 168	com/tencent/commonsdk/cache/QQConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   195: pop
    //   196: iload_1
    //   197: iconst_1
    //   198: iadd
    //   199: istore_1
    //   200: goto -58 -> 142
    //   203: astore_2
    //   204: aload_2
    //   205: athrow
    //   206: return
    //   207: astore_2
    //   208: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	209	0	this	ConversationProxy
    //   141	59	1	i	int
    //   44	142	2	localList	java.util.List
    //   203	2	2	localObject	Object
    //   207	1	2	localException	java.lang.Exception
    //   111	23	3	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   142	196	203	finally
    //   142	196	207	java/lang/Exception
  }
  
  protected void a(String paramString, int paramInt)
  {
    try
    {
      Object localObject = UinTypeUtil.a(paramString, paramInt);
      if ((this.a.containsKey(localObject)) && (this.a.get(localObject) != null))
      {
        localObject = (ConversationInfo)this.a.get(localObject);
        ((ConversationInfo)localObject).extInt3 = (((ConversationInfo)localObject).extInt3 >> 1 << 1);
        a(paramString, paramInt, (ConversationInfo)localObject);
      }
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  protected void a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    try
    {
      Object localObject = UinTypeUtil.a(paramString, paramInt1);
      if ((this.a.containsKey(localObject)) && (this.a.get(localObject) != null))
      {
        localObject = (ConversationInfo)this.a.get(localObject);
        a(paramString, paramInt1, ((ConversationInfo)localObject).lastread, ((ConversationInfo)localObject).unreadCount + paramInt2, ((ConversationInfo)localObject).unreadGiftCount + paramInt3, ((ConversationInfo)localObject).extInt1 + paramInt4);
      }
      else
      {
        a(paramString, paramInt1, 0L, paramInt2, paramInt3, paramInt4);
      }
      return;
    }
    finally {}
  }
  
  protected void a(String paramString, int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4)
  {
    label521:
    for (;;)
    {
      try
      {
        Object localObject1 = UinTypeUtil.a(paramString, paramInt1);
        Object localObject2;
        if ((this.a.containsKey(localObject1)) && (this.a.get(localObject1) != null))
        {
          localObject1 = (ConversationInfo)this.a.get(localObject1);
          if (((((ConversationInfo)localObject1).lastread >= paramLong) || (!ConversationFacade.a(paramInt1))) && ((((ConversationInfo)localObject1).lastread == paramLong) || (ConversationFacade.a(paramInt1))) && (((ConversationInfo)localObject1).unreadCount == paramInt2) && (((ConversationInfo)localObject1).unreadGiftCount == paramInt3) && (((ConversationInfo)localObject1).extInt1 == paramInt4) && (((ConversationInfo)localObject1).type == paramInt1))
          {
            if (QLog.isColorLevel())
            {
              paramString = new StringBuilder();
              paramString.append("insertOrUpdateUnread  nochange=");
              paramString.append(((ConversationInfo)localObject1).toString());
              QLog.d("Q.unread.Proxy", 2, paramString.toString());
            }
          }
          else
          {
            if (!ConversationFacade.a(paramInt1)) {
              break label521;
            }
            paramLong = Math.max(((ConversationInfo)localObject1).lastread, paramLong);
            ((ConversationInfo)localObject1).lastread = paramLong;
            ((ConversationInfo)localObject1).setUnread(Math.max(0, paramInt2));
            ((ConversationInfo)localObject1).setUnreadGiftCount(Math.max(0, paramInt3));
            ((ConversationInfo)localObject1).setExtInt1(Math.max(0, paramInt4));
            if (a(paramString, ((ConversationInfo)localObject1).type, paramInt1))
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("insertOrUpdateUnread() called update type from = [");
              ((StringBuilder)localObject2).append(((ConversationInfo)localObject1).type);
              ((StringBuilder)localObject2).append("], to = [");
              ((StringBuilder)localObject2).append(paramInt1);
              ((StringBuilder)localObject2).append("], uin = [");
              ((StringBuilder)localObject2).append(MsfSdkUtils.getShortUin(paramString));
              ((StringBuilder)localObject2).append("]");
              QLog.i("Q.unread.Proxy", 1, ((StringBuilder)localObject2).toString());
              ((ConversationInfo)localObject1).setType(paramInt1);
            }
            if (paramInt2 == 0) {
              ((ConversationInfo)localObject1).extInt3 = (((ConversationInfo)localObject1).extInt3 >> 1 << 1);
            }
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("insertOrUpdateUnread update=");
            ((StringBuilder)localObject2).append(((ConversationInfo)localObject1).toString());
            QLog.d("Q.unread.Proxy_UnreadMonitor", 1, ((StringBuilder)localObject2).toString());
            a(paramString, paramInt1, (ConversationInfo)localObject1);
          }
        }
        else
        {
          localObject2 = new ConversationInfo(paramString, paramInt1, paramLong, Math.max(0, paramInt2));
          ((ConversationInfo)localObject2).setUnreadGiftCount(Math.max(0, paramInt3));
          ((ConversationInfo)localObject2).setExtInt1(Math.max(0, paramInt4));
          if (paramInt2 == 0) {
            ((ConversationInfo)localObject2).extInt3 = (((ConversationInfo)localObject2).extInt3 >> 1 << 1);
          }
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("insertOrUpdateUnread insert=");
          localStringBuilder.append(((ConversationInfo)localObject2).toString());
          QLog.d("Q.unread.Proxy_UnreadMonitor", 1, localStringBuilder.toString());
          this.a.put(localObject1, localObject2);
          d(paramString, paramInt1, (ConversationInfo)localObject2);
        }
        return;
      }
      finally {}
    }
  }
  
  protected void a(String paramString, int paramInt, ConversationInfo paramConversationInfo)
  {
    b(paramString, paramInt, paramConversationInfo);
    this.proxyManager.addMsgQueue(paramString, paramInt, ConversationInfo.getConversationInfoTableName(), paramConversationInfo, 4, null);
  }
  
  public boolean a(RecentBaseData paramRecentBaseData)
  {
    boolean bool = false;
    if (paramRecentBaseData != null) {
      try
      {
        paramRecentBaseData = UinTypeUtil.a(paramRecentBaseData.getRecentUserUin(), paramRecentBaseData.getRecentUserType());
        paramRecentBaseData = (ConversationInfo)this.a.get(paramRecentBaseData);
        if (paramRecentBaseData != null)
        {
          int i = paramRecentBaseData.extInt1;
          if (i > 0) {
            bool = true;
          }
          return bool;
        }
      }
      finally {}
    }
    return false;
  }
  
  public boolean a(String paramString, int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2) {
      return false;
    }
    boolean bool = f(paramInt1, paramInt2);
    if (c(paramInt1, paramInt2)) {
      bool = true;
    }
    if (e(paramInt1, paramInt2)) {
      bool = true;
    }
    if (d(paramInt1, paramInt2)) {
      bool = true;
    }
    if (b(paramInt1, paramInt2)) {
      bool = true;
    }
    if (a(paramInt1, paramInt2)) {
      bool = true;
    }
    if ((TempMsgBoxManagerProxy.a((BaseQQAppInterface)this.app, paramString, paramInt1) ^ TempMsgBoxManagerProxy.a((BaseQQAppInterface)this.app, paramString, paramInt2))) {
      bool = true;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("canUpdateType() called with: uin = [");
    localStringBuilder.append(MsfSdkUtils.getShortUin(paramString));
    localStringBuilder.append("], from = [");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("], to = [");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("]");
    QLog.i("Q.unread.Proxy", 1, localStringBuilder.toString());
    return bool;
  }
  
  /* Error */
  protected java.util.Set<ConversationInfo> b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 306	java/util/HashSet
    //   5: dup
    //   6: aload_0
    //   7: getfield 44	com/tencent/imcore/message/ConversationProxy:a	Lcom/tencent/commonsdk/cache/QQConcurrentHashMap;
    //   10: invokevirtual 310	com/tencent/commonsdk/cache/QQConcurrentHashMap:values	()Ljava/util/Collection;
    //   13: invokespecial 313	java/util/HashSet:<init>	(Ljava/util/Collection;)V
    //   16: astore_1
    //   17: aload_0
    //   18: monitorexit
    //   19: aload_1
    //   20: areturn
    //   21: astore_1
    //   22: goto +32 -> 54
    //   25: astore_1
    //   26: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   29: ifeq +13 -> 42
    //   32: ldc 79
    //   34: iconst_2
    //   35: ldc_w 315
    //   38: aload_1
    //   39: invokestatic 318	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   42: new 306	java/util/HashSet
    //   45: dup
    //   46: invokespecial 319	java/util/HashSet:<init>	()V
    //   49: astore_1
    //   50: aload_0
    //   51: monitorexit
    //   52: aload_1
    //   53: areturn
    //   54: aload_0
    //   55: monitorexit
    //   56: aload_1
    //   57: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	58	0	this	ConversationProxy
    //   16	4	1	localHashSet1	java.util.HashSet
    //   21	1	1	localObject	Object
    //   25	14	1	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   49	8	1	localHashSet2	java.util.HashSet
    // Exception table:
    //   from	to	target	type
    //   2	17	21	finally
    //   26	42	21	finally
    //   42	50	21	finally
    //   2	17	25	java/lang/OutOfMemoryError
  }
  
  protected void b(String paramString, int paramInt)
  {
    try
    {
      Object localObject = UinTypeUtil.a(paramString, paramInt);
      ConversationInfo localConversationInfo;
      if ((this.a.containsKey(localObject)) && (this.a.get(localObject) != null))
      {
        localConversationInfo = (ConversationInfo)this.a.get(localObject);
        if ((((ConversationInfo)this.a.get(localObject)).unreadCount > 0) && (!AppConstants.KANDIAN_SUBSCRIBE_UIN.equals(paramString)) && (!AppConstants.KANDIAN_DAILY_UIN.equals(paramString)))
        {
          if (QLog.isColorLevel())
          {
            paramString = new StringBuilder();
            paramString.append("insertOrUpdatePublicAccountRed return , updateinfo= ");
            paramString.append(localConversationInfo.toString());
            QLog.d("Q.unread.Proxy", 2, paramString.toString());
          }
          return;
        }
        localConversationInfo.setUnread(localConversationInfo.unreadCount + 1);
        localConversationInfo.extInt3 = (((ConversationInfo)this.a.get(localObject)).extInt3 | 0x1);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("insertOrUpdatePublicAccountRed update=");
          ((StringBuilder)localObject).append(localConversationInfo.toString());
          QLog.d("Q.unread.Proxy", 2, ((StringBuilder)localObject).toString());
        }
        a(paramString, paramInt, localConversationInfo);
      }
      else
      {
        localConversationInfo = new ConversationInfo(paramString, paramInt, 0L, 0);
        localConversationInfo.extInt3 = 1;
        localConversationInfo.setUnread(localConversationInfo.unreadCount + 1);
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("insertOrUpdatePublicAccountRed insert=");
          localStringBuilder.append(localConversationInfo.toString());
          QLog.d("Q.unread.Proxy", 2, localStringBuilder.toString());
        }
        this.a.put(localObject, localConversationInfo);
        d(paramString, paramInt, localConversationInfo);
      }
      return;
    }
    finally {}
  }
  
  public void b(String paramString, int paramInt1, int paramInt2)
  {
    int i = paramInt2;
    if (paramInt2 > 0) {
      i = 1;
    }
    try
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("setUnreadForImax uin=");
        ((StringBuilder)localObject1).append(paramString);
        QLog.d("Q.unread.Proxy", 2, ((StringBuilder)localObject1).toString());
      }
      Object localObject1 = UinTypeUtil.a(paramString, paramInt1);
      Object localObject2;
      if ((this.a.containsKey(localObject1)) && (this.a.get(localObject1) != null))
      {
        localObject1 = (ConversationInfo)this.a.get(localObject1);
        if (((ConversationInfo)localObject1).unreadCount != i)
        {
          ((ConversationInfo)localObject1).setUnread(i);
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("setUnreadForImax update=");
          ((StringBuilder)localObject2).append(((ConversationInfo)localObject1).toString());
          QLog.d("Q.unread.Proxy", 1, ((StringBuilder)localObject2).toString());
          a(paramString, paramInt1, (ConversationInfo)localObject1);
        }
        else if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("setUnreadForImax nochange=");
          paramString.append(((ConversationInfo)localObject1).toString());
          QLog.d("Q.unread.Proxy", 2, paramString.toString());
        }
      }
      else
      {
        localObject2 = new ConversationInfo(paramString, paramInt1, 0L, 0);
        ((ConversationInfo)localObject2).setUnread(i);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setUnreadForImax insert=");
        localStringBuilder.append(((ConversationInfo)localObject2).toString());
        QLog.d("Q.unread.Proxy", 1, localStringBuilder.toString());
        this.a.put(localObject1, localObject2);
        d(paramString, paramInt1, (ConversationInfo)localObject2);
      }
      return;
    }
    finally {}
  }
  
  protected void b(String paramString, int paramInt, ConversationInfo paramConversationInfo)
  {
    c(paramString, paramInt, paramConversationInfo);
  }
  
  protected int c(String paramString, int paramInt)
  {
    try
    {
      String str = UinTypeUtil.a(paramString, paramInt);
      if ((str != null) && (this.a.containsKey(str)) && (this.a.get(str) != null))
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("getPublicAccountConversationRedMask uin=");
          localStringBuilder.append(paramString);
          localStringBuilder.append(" unreadexstr=");
          localStringBuilder.append(String.valueOf(((ConversationInfo)this.a.get(str)).extInt3 & 0x1));
          QLog.d("Q.unread.Proxy", 2, localStringBuilder.toString());
        }
        paramInt = ((ConversationInfo)this.a.get(str)).extInt3;
        return paramInt & 0x1;
      }
      return 0;
    }
    finally {}
  }
  
  protected void c()
  {
    try
    {
      if (!this.a.isEmpty())
      {
        Iterator localIterator = this.a.values().iterator();
        while (localIterator.hasNext())
        {
          ConversationInfo localConversationInfo = (ConversationInfo)localIterator.next();
          if ((localConversationInfo.unreadCount > 0) || (localConversationInfo.unreadMark > 0))
          {
            localConversationInfo.setUnread(0);
            localConversationInfo.setUnreadGiftCount(0);
            localConversationInfo.setUnreadMark(0);
            localConversationInfo.setExtInt1(0);
            localConversationInfo.extInt3 = (localConversationInfo.extInt3 >> 1 << 1);
            a(localConversationInfo.uin, localConversationInfo.type, localConversationInfo);
          }
          if (localConversationInfo.extInt2 > 0) {
            localConversationInfo.setExtInt2(0);
          }
        }
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  protected void c(String paramString, int paramInt1, int paramInt2)
  {
    try
    {
      Object localObject1 = UinTypeUtil.a(paramString, paramInt1);
      Object localObject2;
      if ((this.a.containsKey(localObject1)) && (this.a.get(localObject1) != null))
      {
        localObject1 = (ConversationInfo)this.a.get(localObject1);
        if (((ConversationInfo)localObject1).unreadMark != paramInt2)
        {
          ((ConversationInfo)localObject1).setUnreadMark(paramInt2);
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("insertOrUpdateUnreadMark update=");
          ((StringBuilder)localObject2).append(((ConversationInfo)localObject1).toString());
          QLog.d("Q.unread.Proxy", 1, ((StringBuilder)localObject2).toString());
          a(paramString, paramInt1, (ConversationInfo)localObject1);
        }
        else if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("insertOrUpdateUnreadMark nochange=");
          paramString.append(((ConversationInfo)localObject1).toString());
          QLog.d("Q.unread.Proxy", 2, paramString.toString());
        }
      }
      else
      {
        localObject2 = new ConversationInfo(paramString, paramInt1, 0L, 0);
        ((ConversationInfo)localObject2).setUnreadMark(paramInt2);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("insertOrUpdateUnreadMark insert=");
        localStringBuilder.append(((ConversationInfo)localObject2).toString());
        QLog.d("Q.unread.Proxy", 1, localStringBuilder.toString());
        this.a.put(localObject1, localObject2);
        d(paramString, paramInt1, (ConversationInfo)localObject2);
      }
      return;
    }
    finally {}
  }
  
  protected void c(String paramString, int paramInt, ConversationInfo paramConversationInfo)
  {
    this.app.notifyObservers(ConversationProxyObserver.class, 0, true, new Bundle());
  }
  
  protected void d(String paramString, int paramInt)
  {
    try
    {
      String str = UinTypeUtil.a(paramString, paramInt);
      if (this.a.containsKey(str))
      {
        e(paramString, paramInt, (ConversationInfo)this.a.get(str));
        this.a.remove(str);
      }
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  protected void d(String paramString, int paramInt1, int paramInt2)
  {
    try
    {
      Object localObject1 = UinTypeUtil.a(paramString, paramInt1);
      Object localObject2;
      if ((this.a.containsKey(localObject1)) && (this.a.get(localObject1) != null))
      {
        localObject1 = (ConversationInfo)this.a.get(localObject1);
        if (((ConversationInfo)localObject1).extInt2 != paramInt2)
        {
          ((ConversationInfo)localObject1).setExtInt2(paramInt2);
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("insertOrUpdateSubAccountTroopUnRead update=");
          ((StringBuilder)localObject2).append(((ConversationInfo)localObject1).toString());
          QLog.d("Q.unread.Proxy", 1, ((StringBuilder)localObject2).toString());
          a(paramString, paramInt1, (ConversationInfo)localObject1);
        }
        else if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("insertOrUpdateSubAccountTroopUnRead nochange=");
          paramString.append(((ConversationInfo)localObject1).toString());
          QLog.d("Q.unread.Proxy", 2, paramString.toString());
        }
      }
      else
      {
        localObject2 = new ConversationInfo(paramString, paramInt1, 0L, 0);
        ((ConversationInfo)localObject2).setExtInt2(paramInt2);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("insertOrUpdateSubAccountTroopUnRead insert=");
        localStringBuilder.append(((ConversationInfo)localObject2).toString());
        QLog.d("Q.unread.Proxy", 1, localStringBuilder.toString());
        this.a.put(localObject1, localObject2);
        d(paramString, paramInt1, (ConversationInfo)localObject2);
      }
      return;
    }
    finally {}
  }
  
  protected void d(String paramString, int paramInt, ConversationInfo paramConversationInfo)
  {
    this.proxyManager.addMsgQueue(paramString, paramInt, ConversationInfo.getConversationInfoTableName(), paramConversationInfo, 3, null);
  }
  
  public void destroy()
  {
    try
    {
      this.a.clear();
      if ((this.b != null) && (this.b.isOpen())) {
        this.b.close();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected ConversationInfo e(String paramString, int paramInt)
  {
    try
    {
      paramString = UinTypeUtil.a(paramString, paramInt);
      if ((paramString != null) && (this.a.containsKey(paramString)))
      {
        paramString = (ConversationInfo)this.a.get(paramString);
        return paramString;
      }
      return null;
    }
    finally {}
  }
  
  protected void e(String paramString, int paramInt1, int paramInt2)
  {
    try
    {
      Object localObject = UinTypeUtil.a(paramString, paramInt1);
      if ((this.a.containsKey(localObject)) && (this.a.get(localObject) != null))
      {
        localObject = (ConversationInfo)this.a.get(localObject);
        a(paramString, paramInt1, ((ConversationInfo)localObject).lastread, paramInt2, ((ConversationInfo)localObject).unreadGiftCount, ((ConversationInfo)localObject).extInt1);
      }
      else
      {
        a(paramString, paramInt1, 0L, paramInt2, 0, 0);
      }
      return;
    }
    finally {}
  }
  
  protected void e(String paramString, int paramInt, ConversationInfo paramConversationInfo)
  {
    this.proxyManager.addMsgQueue(paramString, paramInt, ConversationInfo.getConversationInfoTableName(), paramConversationInfo, 5, null);
  }
  
  protected int f(String paramString, int paramInt)
  {
    try
    {
      paramString = UinTypeUtil.a(paramString, paramInt);
      if ((paramString != null) && (this.a.containsKey(paramString)))
      {
        paramInt = ((ConversationInfo)this.a.get(paramString)).unreadCount;
        return paramInt;
      }
      return 0;
    }
    finally {}
  }
  
  protected void f(String paramString, int paramInt1, int paramInt2)
  {
    try
    {
      Object localObject = UinTypeUtil.a(paramString, paramInt1);
      if ((this.a.containsKey(localObject)) && (this.a.get(localObject) != null))
      {
        localObject = (ConversationInfo)this.a.get(localObject);
        a(paramString, paramInt1, ((ConversationInfo)localObject).lastread, ((ConversationInfo)localObject).unreadCount + paramInt2, ((ConversationInfo)localObject).unreadGiftCount, ((ConversationInfo)localObject).extInt1);
      }
      else
      {
        a(paramString, paramInt1, 0L, paramInt2, 0, 0);
      }
      return;
    }
    finally {}
  }
  
  protected long g(String paramString, int paramInt)
  {
    try
    {
      paramString = UinTypeUtil.a(paramString, paramInt);
      if ((paramString != null) && (this.a.containsKey(paramString)))
      {
        long l = ((ConversationInfo)this.a.get(paramString)).lastread;
        return l;
      }
      return 0L;
    }
    finally {}
  }
  
  protected int h(String paramString, int paramInt)
  {
    try
    {
      paramString = UinTypeUtil.a(paramString, paramInt);
      if (this.a.containsKey(paramString))
      {
        paramInt = ((ConversationInfo)this.a.get(paramString)).unreadGiftCount;
        return paramInt;
      }
      return 0;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  protected int i(String paramString, int paramInt)
  {
    try
    {
      paramString = UinTypeUtil.a(paramString, paramInt);
      if (this.a.containsKey(paramString))
      {
        paramInt = ((ConversationInfo)this.a.get(paramString)).extInt1;
        return paramInt;
      }
      return 0;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void init() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.ConversationProxy
 * JD-Core Version:    0.7.0.1
 */