package com.tencent.imcore.message;

import android.os.Bundle;
import com.tencent.commonsdk.cache.QQConcurrentHashMap;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.proxy.BaseProxy;
import com.tencent.mobileqq.app.proxy.BaseProxyManager;
import com.tencent.mobileqq.data.ConversationInfo;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.NoColumnErrorHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import mqq.app.AppRuntime;

public class ConversationProxy
  extends BaseProxy
{
  protected QQConcurrentHashMap<String, ConversationInfo> a;
  EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = null;
  NoColumnErrorHandler jdField_a_of_type_ComTencentMobileqqPersistenceNoColumnErrorHandler = new ConversationProxy.1(this);
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private boolean jdField_a_of_type_Boolean = false;
  
  public ConversationProxy(AppRuntime paramAppRuntime, BaseProxyManager paramBaseProxyManager)
  {
    super(paramAppRuntime, paramBaseProxyManager);
    this.jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap = new QQConcurrentHashMap(1005, 0, 100);
  }
  
  private EntityManager a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager == null) || (!this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.isOpen())) {}
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager == null) || (!this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.isOpen())) {
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = this.app.getEntityManagerFactory().createEntityManager();
      }
      return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
    }
  }
  
  private boolean a(int paramInt1, int paramInt2)
  {
    boolean bool = false;
    if (g(paramInt1, paramInt2)) {
      bool = true;
    }
    if (d(paramInt1, paramInt2)) {
      bool = true;
    }
    if (f(paramInt1, paramInt2)) {
      bool = true;
    }
    if (e(paramInt1, paramInt2)) {
      bool = true;
    }
    if (c(paramInt1, paramInt2)) {
      bool = true;
    }
    if (b(paramInt1, paramInt2)) {
      bool = true;
    }
    if (paramInt1 != paramInt2) {
      QLog.i("Q.unread.Proxy", 1, "canUpdateType() called with: from = [" + paramInt1 + "], to = [" + paramInt2 + "]");
    }
    return bool;
  }
  
  private boolean b(int paramInt1, int paramInt2)
  {
    return ((paramInt1 == 10010) && (paramInt2 == 0)) || ((paramInt1 == 0) && (paramInt2 == 10010));
  }
  
  private boolean c(int paramInt1, int paramInt2)
  {
    return ((paramInt1 == 1022) && (paramInt2 == 0)) || ((paramInt1 == 0) && (paramInt2 == 1022));
  }
  
  private boolean d(int paramInt1, int paramInt2)
  {
    return ((paramInt1 == 1004) && (paramInt2 == 0)) || ((paramInt1 == 0) && (paramInt2 == 1004));
  }
  
  private boolean e(int paramInt1, int paramInt2)
  {
    return ((paramInt1 == 1023) && (paramInt2 == 0)) || ((paramInt1 == 0) && (paramInt2 == 1023));
  }
  
  private boolean f(int paramInt1, int paramInt2)
  {
    return ((paramInt1 == 1006) && (paramInt2 == 0)) || ((paramInt1 == 0) && (paramInt2 == 1006));
  }
  
  private boolean g(int paramInt1, int paramInt2)
  {
    return ((paramInt1 == 1000) && (paramInt2 == 0)) || ((paramInt1 == 0) && (paramInt2 == 1000));
  }
  
  /* Error */
  protected int a(String paramString, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: iload_2
    //   4: invokestatic 117	com/tencent/imcore/message/UinTypeUtil:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   7: astore_3
    //   8: aload_3
    //   9: ifnull +106 -> 115
    //   12: aload_0
    //   13: getfield 40	com/tencent/imcore/message/ConversationProxy:jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap	Lcom/tencent/commonsdk/cache/QQConcurrentHashMap;
    //   16: aload_3
    //   17: invokevirtual 121	com/tencent/commonsdk/cache/QQConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   20: ifeq +95 -> 115
    //   23: aload_0
    //   24: getfield 40	com/tencent/imcore/message/ConversationProxy:jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap	Lcom/tencent/commonsdk/cache/QQConcurrentHashMap;
    //   27: aload_3
    //   28: invokevirtual 125	com/tencent/commonsdk/cache/QQConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   31: ifnull +84 -> 115
    //   34: invokestatic 128	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   37: ifeq +55 -> 92
    //   40: ldc 84
    //   42: iconst_2
    //   43: new 86	java/lang/StringBuilder
    //   46: dup
    //   47: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   50: ldc 130
    //   52: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: aload_1
    //   56: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: ldc 132
    //   61: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: aload_0
    //   65: getfield 40	com/tencent/imcore/message/ConversationProxy:jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap	Lcom/tencent/commonsdk/cache/QQConcurrentHashMap;
    //   68: aload_3
    //   69: invokevirtual 125	com/tencent/commonsdk/cache/QQConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   72: checkcast 134	com/tencent/mobileqq/data/ConversationInfo
    //   75: getfield 138	com/tencent/mobileqq/data/ConversationInfo:extInt3	I
    //   78: iconst_1
    //   79: iand
    //   80: invokestatic 144	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   83: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   89: invokestatic 146	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   92: aload_0
    //   93: getfield 40	com/tencent/imcore/message/ConversationProxy:jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap	Lcom/tencent/commonsdk/cache/QQConcurrentHashMap;
    //   96: aload_3
    //   97: invokevirtual 125	com/tencent/commonsdk/cache/QQConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   100: checkcast 134	com/tencent/mobileqq/data/ConversationInfo
    //   103: getfield 138	com/tencent/mobileqq/data/ConversationInfo:extInt3	I
    //   106: istore_2
    //   107: iload_2
    //   108: iconst_1
    //   109: iand
    //   110: istore_2
    //   111: aload_0
    //   112: monitorexit
    //   113: iload_2
    //   114: ireturn
    //   115: iconst_0
    //   116: istore_2
    //   117: goto -6 -> 111
    //   120: astore_1
    //   121: aload_0
    //   122: monitorexit
    //   123: aload_1
    //   124: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	125	0	this	ConversationProxy
    //   0	125	1	paramString	String
    //   0	125	2	paramInt	int
    //   7	90	3	str	String
    // Exception table:
    //   from	to	target	type
    //   2	8	120	finally
    //   12	92	120	finally
    //   92	107	120	finally
  }
  
  /* Error */
  protected long a(String paramString, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: iload_2
    //   4: invokestatic 117	com/tencent/imcore/message/UinTypeUtil:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   7: astore_1
    //   8: aload_1
    //   9: ifnull +33 -> 42
    //   12: aload_0
    //   13: getfield 40	com/tencent/imcore/message/ConversationProxy:jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap	Lcom/tencent/commonsdk/cache/QQConcurrentHashMap;
    //   16: aload_1
    //   17: invokevirtual 121	com/tencent/commonsdk/cache/QQConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   20: ifeq +22 -> 42
    //   23: aload_0
    //   24: getfield 40	com/tencent/imcore/message/ConversationProxy:jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap	Lcom/tencent/commonsdk/cache/QQConcurrentHashMap;
    //   27: aload_1
    //   28: invokevirtual 125	com/tencent/commonsdk/cache/QQConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   31: checkcast 134	com/tencent/mobileqq/data/ConversationInfo
    //   34: getfield 151	com/tencent/mobileqq/data/ConversationInfo:lastread	J
    //   37: lstore_3
    //   38: aload_0
    //   39: monitorexit
    //   40: lload_3
    //   41: lreturn
    //   42: lconst_0
    //   43: lstore_3
    //   44: goto -6 -> 38
    //   47: astore_1
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_1
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	52	0	this	ConversationProxy
    //   0	52	1	paramString	String
    //   0	52	2	paramInt	int
    //   37	7	3	l	long
    // Exception table:
    //   from	to	target	type
    //   2	8	47	finally
    //   12	38	47	finally
  }
  
  /* Error */
  protected ConversationInfo a(String paramString, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: iload_2
    //   4: invokestatic 117	com/tencent/imcore/message/UinTypeUtil:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   7: astore_1
    //   8: aload_1
    //   9: ifnull +30 -> 39
    //   12: aload_0
    //   13: getfield 40	com/tencent/imcore/message/ConversationProxy:jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap	Lcom/tencent/commonsdk/cache/QQConcurrentHashMap;
    //   16: aload_1
    //   17: invokevirtual 121	com/tencent/commonsdk/cache/QQConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   20: ifeq +19 -> 39
    //   23: aload_0
    //   24: getfield 40	com/tencent/imcore/message/ConversationProxy:jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap	Lcom/tencent/commonsdk/cache/QQConcurrentHashMap;
    //   27: aload_1
    //   28: invokevirtual 125	com/tencent/commonsdk/cache/QQConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   31: checkcast 134	com/tencent/mobileqq/data/ConversationInfo
    //   34: astore_1
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_1
    //   38: areturn
    //   39: aconst_null
    //   40: astore_1
    //   41: goto -6 -> 35
    //   44: astore_1
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_1
    //   48: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	this	ConversationProxy
    //   0	49	1	paramString	String
    //   0	49	2	paramInt	int
    // Exception table:
    //   from	to	target	type
    //   2	8	44	finally
    //   12	35	44	finally
  }
  
  protected Set<ConversationInfo> a()
  {
    try
    {
      HashSet localHashSet1 = new HashSet(this.jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap.values());
      return localHashSet1;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.unread.Proxy", 2, "cloneConversationInfoSet OOM!", localOutOfMemoryError);
        }
        HashSet localHashSet2 = new HashSet();
      }
    }
    finally {}
  }
  
  /* Error */
  protected void a()
  {
    // Byte code:
    //   0: invokestatic 128	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +11 -> 14
    //   6: ldc 84
    //   8: iconst_2
    //   9: ldc 176
    //   11: invokestatic 110	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   14: aload_0
    //   15: getfield 40	com/tencent/imcore/message/ConversationProxy:jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap	Lcom/tencent/commonsdk/cache/QQConcurrentHashMap;
    //   18: invokevirtual 179	com/tencent/commonsdk/cache/QQConcurrentHashMap:clear	()V
    //   21: aload_0
    //   22: invokespecial 181	com/tencent/imcore/message/ConversationProxy:a	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   25: ldc 134
    //   27: invokestatic 184	com/tencent/mobileqq/data/ConversationInfo:getConversationInfoTableName	()Ljava/lang/String;
    //   30: iconst_0
    //   31: aconst_null
    //   32: aconst_null
    //   33: aconst_null
    //   34: aconst_null
    //   35: aconst_null
    //   36: aconst_null
    //   37: aload_0
    //   38: getfield 33	com/tencent/imcore/message/ConversationProxy:jdField_a_of_type_ComTencentMobileqqPersistenceNoColumnErrorHandler	Lcom/tencent/mobileqq/persistence/NoColumnErrorHandler;
    //   41: invokevirtual 188	com/tencent/mobileqq/persistence/EntityManager:query	(Ljava/lang/Class;Ljava/lang/String;ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/persistence/NoColumnErrorHandler;)Ljava/util/List;
    //   44: astore_2
    //   45: aload_0
    //   46: getfield 26	com/tencent/imcore/message/ConversationProxy:jdField_a_of_type_Boolean	Z
    //   49: ifeq +44 -> 93
    //   52: aload_0
    //   53: invokespecial 181	com/tencent/imcore/message/ConversationProxy:a	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   56: ldc 134
    //   58: invokevirtual 192	com/tencent/mobileqq/persistence/EntityManager:drop	(Ljava/lang/Class;)Z
    //   61: pop
    //   62: invokestatic 128	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   65: ifeq +11 -> 76
    //   68: ldc 84
    //   70: iconst_2
    //   71: ldc 194
    //   73: invokestatic 146	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   76: invokestatic 200	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   79: invokestatic 206	com/tencent/mobileqq/statistics/StatisticCollector:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   82: aconst_null
    //   83: ldc 208
    //   85: iconst_1
    //   86: lconst_1
    //   87: lconst_0
    //   88: aconst_null
    //   89: aconst_null
    //   90: invokevirtual 212	com/tencent/mobileqq/statistics/StatisticCollector:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   93: aload_2
    //   94: ifnonnull +4 -> 98
    //   97: return
    //   98: invokestatic 128	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   101: ifeq +33 -> 134
    //   104: ldc 84
    //   106: iconst_2
    //   107: new 86	java/lang/StringBuilder
    //   110: dup
    //   111: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   114: ldc 214
    //   116: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: aload_2
    //   120: invokeinterface 220 1 0
    //   125: invokevirtual 96	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   128: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   131: invokestatic 146	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   134: iconst_0
    //   135: istore_1
    //   136: iload_1
    //   137: aload_2
    //   138: invokeinterface 220 1 0
    //   143: if_icmpge -46 -> 97
    //   146: aload_0
    //   147: getfield 40	com/tencent/imcore/message/ConversationProxy:jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap	Lcom/tencent/commonsdk/cache/QQConcurrentHashMap;
    //   150: aload_2
    //   151: iload_1
    //   152: invokeinterface 223 2 0
    //   157: checkcast 134	com/tencent/mobileqq/data/ConversationInfo
    //   160: getfield 227	com/tencent/mobileqq/data/ConversationInfo:uin	Ljava/lang/String;
    //   163: aload_2
    //   164: iload_1
    //   165: invokeinterface 223 2 0
    //   170: checkcast 134	com/tencent/mobileqq/data/ConversationInfo
    //   173: getfield 230	com/tencent/mobileqq/data/ConversationInfo:type	I
    //   176: invokestatic 117	com/tencent/imcore/message/UinTypeUtil:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   179: aload_2
    //   180: iload_1
    //   181: invokeinterface 223 2 0
    //   186: invokevirtual 234	com/tencent/commonsdk/cache/QQConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   189: pop
    //   190: iload_1
    //   191: iconst_1
    //   192: iadd
    //   193: istore_1
    //   194: goto -58 -> 136
    //   197: astore_2
    //   198: aload_2
    //   199: athrow
    //   200: astore_2
    //   201: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	202	0	this	ConversationProxy
    //   135	59	1	i	int
    //   44	136	2	localList	java.util.List
    //   197	2	2	localObject	Object
    //   200	1	2	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   136	190	197	finally
    //   136	190	200	java/lang/Exception
  }
  
  protected void a(String paramString, int paramInt)
  {
    try
    {
      Object localObject = UinTypeUtil.a(paramString, paramInt);
      if ((this.jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap.containsKey(localObject)) && (this.jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap.get(localObject) != null))
      {
        localObject = (ConversationInfo)this.jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap.get(localObject);
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
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    int i = paramInt2;
    if (paramInt2 > 0) {
      i = 1;
    }
    for (;;)
    {
      Object localObject;
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.unread.Proxy", 2, "setUnreadForImax uin=" + paramString);
        }
        localObject = UinTypeUtil.a(paramString, paramInt1);
        if ((this.jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap.containsKey(localObject)) && (this.jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap.get(localObject) != null))
        {
          localObject = (ConversationInfo)this.jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap.get(localObject);
          if (((ConversationInfo)localObject).unreadCount != i)
          {
            ((ConversationInfo)localObject).setUnread(i);
            QLog.d("Q.unread.Proxy", 1, "setUnreadForImax update=" + ((ConversationInfo)localObject).toString());
            a(paramString, paramInt1, (ConversationInfo)localObject);
            return;
          }
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("Q.unread.Proxy", 2, "setUnreadForImax nochange=" + ((ConversationInfo)localObject).toString());
          continue;
        }
        localConversationInfo = new ConversationInfo(paramString, paramInt1, 0L, 0);
      }
      finally {}
      ConversationInfo localConversationInfo;
      localConversationInfo.setUnread(i);
      QLog.d("Q.unread.Proxy", 1, "setUnreadForImax insert=" + localConversationInfo.toString());
      this.jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap.put(localObject, localConversationInfo);
      d(paramString, paramInt1, localConversationInfo);
    }
  }
  
  /* Error */
  protected void a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: iload_2
    //   4: invokestatic 117	com/tencent/imcore/message/UinTypeUtil:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   7: astore 6
    //   9: aload_0
    //   10: getfield 40	com/tencent/imcore/message/ConversationProxy:jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap	Lcom/tencent/commonsdk/cache/QQConcurrentHashMap;
    //   13: aload 6
    //   15: invokevirtual 121	com/tencent/commonsdk/cache/QQConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   18: ifeq +66 -> 84
    //   21: aload_0
    //   22: getfield 40	com/tencent/imcore/message/ConversationProxy:jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap	Lcom/tencent/commonsdk/cache/QQConcurrentHashMap;
    //   25: aload 6
    //   27: invokevirtual 125	com/tencent/commonsdk/cache/QQConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   30: ifnull +54 -> 84
    //   33: aload_0
    //   34: getfield 40	com/tencent/imcore/message/ConversationProxy:jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap	Lcom/tencent/commonsdk/cache/QQConcurrentHashMap;
    //   37: aload 6
    //   39: invokevirtual 125	com/tencent/commonsdk/cache/QQConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   42: checkcast 134	com/tencent/mobileqq/data/ConversationInfo
    //   45: astore 6
    //   47: aload_0
    //   48: aload_1
    //   49: iload_2
    //   50: aload 6
    //   52: getfield 151	com/tencent/mobileqq/data/ConversationInfo:lastread	J
    //   55: aload 6
    //   57: getfield 244	com/tencent/mobileqq/data/ConversationInfo:unreadCount	I
    //   60: iload_3
    //   61: iadd
    //   62: aload 6
    //   64: getfield 264	com/tencent/mobileqq/data/ConversationInfo:unreadGiftCount	I
    //   67: iload 4
    //   69: iadd
    //   70: aload 6
    //   72: getfield 267	com/tencent/mobileqq/data/ConversationInfo:extInt1	I
    //   75: iload 5
    //   77: iadd
    //   78: invokevirtual 270	com/tencent/imcore/message/ConversationProxy:a	(Ljava/lang/String;IJIII)V
    //   81: aload_0
    //   82: monitorexit
    //   83: return
    //   84: aload_0
    //   85: aload_1
    //   86: iload_2
    //   87: lconst_0
    //   88: iload_3
    //   89: iload 4
    //   91: iload 5
    //   93: invokevirtual 270	com/tencent/imcore/message/ConversationProxy:a	(Ljava/lang/String;IJIII)V
    //   96: goto -15 -> 81
    //   99: astore_1
    //   100: aload_0
    //   101: monitorexit
    //   102: aload_1
    //   103: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	104	0	this	ConversationProxy
    //   0	104	1	paramString	String
    //   0	104	2	paramInt1	int
    //   0	104	3	paramInt2	int
    //   0	104	4	paramInt3	int
    //   0	104	5	paramInt4	int
    //   7	64	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	81	99	finally
    //   84	96	99	finally
  }
  
  protected void a(String paramString, int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4)
  {
    for (;;)
    {
      Object localObject;
      try
      {
        localObject = UinTypeUtil.a(paramString, paramInt1);
        if ((this.jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap.containsKey(localObject)) && (this.jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap.get(localObject) != null))
        {
          localObject = (ConversationInfo)this.jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap.get(localObject);
          if (((((ConversationInfo)localObject).lastread < paramLong) && (ConversationFacade.a(paramInt1))) || ((((ConversationInfo)localObject).lastread != paramLong) && (!ConversationFacade.a(paramInt1))) || (((ConversationInfo)localObject).unreadCount != paramInt2) || (((ConversationInfo)localObject).unreadGiftCount != paramInt3) || (((ConversationInfo)localObject).extInt1 != paramInt4) || (((ConversationInfo)localObject).type != paramInt1))
          {
            long l = paramLong;
            if (ConversationFacade.a(paramInt1)) {
              l = Math.max(((ConversationInfo)localObject).lastread, paramLong);
            }
            ((ConversationInfo)localObject).lastread = l;
            ((ConversationInfo)localObject).setUnread(Math.max(0, paramInt2));
            ((ConversationInfo)localObject).setUnreadGiftCount(Math.max(0, paramInt3));
            ((ConversationInfo)localObject).setExtInt1(Math.max(0, paramInt4));
            if (a(((ConversationInfo)localObject).type, paramInt1))
            {
              QLog.i("Q.unread.Proxy", 1, "insertOrUpdateUnread() called update type from = [" + ((ConversationInfo)localObject).type + "], to = [" + paramInt1 + "], uin = [" + MsfSdkUtils.getShortUin(paramString) + "]");
              ((ConversationInfo)localObject).setType(paramInt1);
            }
            if (paramInt2 == 0) {
              ((ConversationInfo)localObject).extInt3 = (((ConversationInfo)localObject).extInt3 >> 1 << 1);
            }
            QLog.d("Q.unread.Proxy_UnreadMonitor", 1, "insertOrUpdateUnread update=" + ((ConversationInfo)localObject).toString());
            a(paramString, paramInt1, (ConversationInfo)localObject);
            return;
          }
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("Q.unread.Proxy", 2, "insertOrUpdateUnread  nochange=" + ((ConversationInfo)localObject).toString());
          continue;
        }
        localConversationInfo = new ConversationInfo(paramString, paramInt1, paramLong, Math.max(0, paramInt2));
      }
      finally {}
      ConversationInfo localConversationInfo;
      localConversationInfo.setUnreadGiftCount(Math.max(0, paramInt3));
      localConversationInfo.setExtInt1(Math.max(0, paramInt4));
      if (paramInt2 == 0) {
        localConversationInfo.extInt3 = (localConversationInfo.extInt3 >> 1 << 1);
      }
      QLog.d("Q.unread.Proxy_UnreadMonitor", 1, "insertOrUpdateUnread insert=" + localConversationInfo.toString());
      this.jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap.put(localObject, localConversationInfo);
      d(paramString, paramInt1, localConversationInfo);
    }
  }
  
  protected void a(String paramString, int paramInt, ConversationInfo paramConversationInfo)
  {
    b(paramString, paramInt, paramConversationInfo);
    this.proxyManager.addMsgQueue(paramString, paramInt, ConversationInfo.getConversationInfoTableName(), paramConversationInfo, 4, null);
  }
  
  /* Error */
  public boolean a(com.tencent.mobileqq.activity.recent.RecentBaseData paramRecentBaseData)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull +51 -> 54
    //   6: aload_1
    //   7: invokevirtual 331	com/tencent/mobileqq/activity/recent/RecentBaseData:getRecentUserUin	()Ljava/lang/String;
    //   10: aload_1
    //   11: invokevirtual 334	com/tencent/mobileqq/activity/recent/RecentBaseData:getRecentUserType	()I
    //   14: invokestatic 117	com/tencent/imcore/message/UinTypeUtil:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   17: astore_1
    //   18: aload_0
    //   19: getfield 40	com/tencent/imcore/message/ConversationProxy:jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap	Lcom/tencent/commonsdk/cache/QQConcurrentHashMap;
    //   22: aload_1
    //   23: invokevirtual 125	com/tencent/commonsdk/cache/QQConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   26: checkcast 134	com/tencent/mobileqq/data/ConversationInfo
    //   29: astore_1
    //   30: aload_1
    //   31: ifnull +23 -> 54
    //   34: aload_1
    //   35: getfield 267	com/tencent/mobileqq/data/ConversationInfo:extInt1	I
    //   38: istore_2
    //   39: iload_2
    //   40: ifle +9 -> 49
    //   43: iconst_1
    //   44: istore_3
    //   45: aload_0
    //   46: monitorexit
    //   47: iload_3
    //   48: ireturn
    //   49: iconst_0
    //   50: istore_3
    //   51: goto -6 -> 45
    //   54: iconst_0
    //   55: istore_3
    //   56: goto -11 -> 45
    //   59: astore_1
    //   60: aload_0
    //   61: monitorexit
    //   62: aload_1
    //   63: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	64	0	this	ConversationProxy
    //   0	64	1	paramRecentBaseData	com.tencent.mobileqq.activity.recent.RecentBaseData
    //   38	2	2	i	int
    //   44	12	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   6	30	59	finally
    //   34	39	59	finally
  }
  
  /* Error */
  protected int b(String paramString, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: iload_2
    //   4: invokestatic 117	com/tencent/imcore/message/UinTypeUtil:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   7: astore_1
    //   8: aload_1
    //   9: ifnull +33 -> 42
    //   12: aload_0
    //   13: getfield 40	com/tencent/imcore/message/ConversationProxy:jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap	Lcom/tencent/commonsdk/cache/QQConcurrentHashMap;
    //   16: aload_1
    //   17: invokevirtual 121	com/tencent/commonsdk/cache/QQConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   20: ifeq +22 -> 42
    //   23: aload_0
    //   24: getfield 40	com/tencent/imcore/message/ConversationProxy:jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap	Lcom/tencent/commonsdk/cache/QQConcurrentHashMap;
    //   27: aload_1
    //   28: invokevirtual 125	com/tencent/commonsdk/cache/QQConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   31: checkcast 134	com/tencent/mobileqq/data/ConversationInfo
    //   34: getfield 244	com/tencent/mobileqq/data/ConversationInfo:unreadCount	I
    //   37: istore_2
    //   38: aload_0
    //   39: monitorexit
    //   40: iload_2
    //   41: ireturn
    //   42: iconst_0
    //   43: istore_2
    //   44: goto -6 -> 38
    //   47: astore_1
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_1
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	52	0	this	ConversationProxy
    //   0	52	1	paramString	String
    //   0	52	2	paramInt	int
    // Exception table:
    //   from	to	target	type
    //   2	8	47	finally
    //   12	38	47	finally
  }
  
  protected void b()
  {
    try
    {
      if (!this.jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap.isEmpty())
      {
        Iterator localIterator = this.jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap.values().iterator();
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
    }
    finally {}
  }
  
  protected void b(String paramString, int paramInt)
  {
    for (;;)
    {
      String str;
      ConversationInfo localConversationInfo;
      try
      {
        str = UinTypeUtil.a(paramString, paramInt);
        if ((this.jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap.containsKey(str)) && (this.jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap.get(str) != null))
        {
          localConversationInfo = (ConversationInfo)this.jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap.get(str);
          if ((((ConversationInfo)this.jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap.get(str)).unreadCount > 0) && (!AppConstants.KANDIAN_SUBSCRIBE_UIN.equals(paramString)) && (!AppConstants.KANDIAN_DAILY_UIN.equals(paramString)))
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.unread.Proxy", 2, "insertOrUpdatePublicAccountRed return , updateinfo= " + localConversationInfo.toString());
            }
            return;
          }
          localConversationInfo.setUnread(localConversationInfo.unreadCount + 1);
          localConversationInfo.extInt3 = (((ConversationInfo)this.jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap.get(str)).extInt3 | 0x1);
          if (QLog.isColorLevel()) {
            QLog.d("Q.unread.Proxy", 2, "insertOrUpdatePublicAccountRed update=" + localConversationInfo.toString());
          }
          a(paramString, paramInt, localConversationInfo);
          continue;
        }
        localConversationInfo = new ConversationInfo(paramString, paramInt, 0L, 0);
      }
      finally {}
      localConversationInfo.extInt3 = 1;
      localConversationInfo.setUnread(localConversationInfo.unreadCount + 1);
      if (QLog.isColorLevel()) {
        QLog.d("Q.unread.Proxy", 2, "insertOrUpdatePublicAccountRed insert=" + localConversationInfo.toString());
      }
      this.jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap.put(str, localConversationInfo);
      d(paramString, paramInt, localConversationInfo);
    }
  }
  
  protected void b(String paramString, int paramInt1, int paramInt2)
  {
    for (;;)
    {
      Object localObject;
      try
      {
        localObject = UinTypeUtil.a(paramString, paramInt1);
        if ((this.jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap.containsKey(localObject)) && (this.jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap.get(localObject) != null))
        {
          localObject = (ConversationInfo)this.jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap.get(localObject);
          if (((ConversationInfo)localObject).unreadMark != paramInt2)
          {
            ((ConversationInfo)localObject).setUnreadMark(paramInt2);
            QLog.d("Q.unread.Proxy", 1, "insertOrUpdateUnreadMark update=" + ((ConversationInfo)localObject).toString());
            a(paramString, paramInt1, (ConversationInfo)localObject);
            return;
          }
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("Q.unread.Proxy", 2, "insertOrUpdateUnreadMark nochange=" + ((ConversationInfo)localObject).toString());
          continue;
        }
        localConversationInfo = new ConversationInfo(paramString, paramInt1, 0L, 0);
      }
      finally {}
      ConversationInfo localConversationInfo;
      localConversationInfo.setUnreadMark(paramInt2);
      QLog.d("Q.unread.Proxy", 1, "insertOrUpdateUnreadMark insert=" + localConversationInfo.toString());
      this.jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap.put(localObject, localConversationInfo);
      d(paramString, paramInt1, localConversationInfo);
    }
  }
  
  protected void b(String paramString, int paramInt, ConversationInfo paramConversationInfo)
  {
    c(paramString, paramInt, paramConversationInfo);
  }
  
  /* Error */
  protected int c(String paramString, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: iload_2
    //   4: invokestatic 117	com/tencent/imcore/message/UinTypeUtil:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   7: astore_1
    //   8: aload_0
    //   9: getfield 40	com/tencent/imcore/message/ConversationProxy:jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap	Lcom/tencent/commonsdk/cache/QQConcurrentHashMap;
    //   12: aload_1
    //   13: invokevirtual 121	com/tencent/commonsdk/cache/QQConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   16: ifeq +22 -> 38
    //   19: aload_0
    //   20: getfield 40	com/tencent/imcore/message/ConversationProxy:jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap	Lcom/tencent/commonsdk/cache/QQConcurrentHashMap;
    //   23: aload_1
    //   24: invokevirtual 125	com/tencent/commonsdk/cache/QQConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   27: checkcast 134	com/tencent/mobileqq/data/ConversationInfo
    //   30: getfield 264	com/tencent/mobileqq/data/ConversationInfo:unreadGiftCount	I
    //   33: istore_2
    //   34: aload_0
    //   35: monitorexit
    //   36: iload_2
    //   37: ireturn
    //   38: iconst_0
    //   39: istore_2
    //   40: goto -6 -> 34
    //   43: astore_1
    //   44: aload_0
    //   45: monitorexit
    //   46: aload_1
    //   47: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	48	0	this	ConversationProxy
    //   0	48	1	paramString	String
    //   0	48	2	paramInt	int
    // Exception table:
    //   from	to	target	type
    //   2	34	43	finally
  }
  
  protected void c(String paramString, int paramInt)
  {
    try
    {
      String str = UinTypeUtil.a(paramString, paramInt);
      if (this.jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap.containsKey(str))
      {
        e(paramString, paramInt, (ConversationInfo)this.jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap.get(str));
        this.jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap.remove(str);
      }
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  protected void c(String paramString, int paramInt1, int paramInt2)
  {
    for (;;)
    {
      Object localObject;
      try
      {
        localObject = UinTypeUtil.a(paramString, paramInt1);
        if ((this.jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap.containsKey(localObject)) && (this.jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap.get(localObject) != null))
        {
          localObject = (ConversationInfo)this.jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap.get(localObject);
          if (((ConversationInfo)localObject).extInt2 != paramInt2)
          {
            ((ConversationInfo)localObject).setExtInt2(paramInt2);
            QLog.d("Q.unread.Proxy", 1, "insertOrUpdateSubAccountTroopUnRead update=" + ((ConversationInfo)localObject).toString());
            a(paramString, paramInt1, (ConversationInfo)localObject);
            return;
          }
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("Q.unread.Proxy", 2, "insertOrUpdateSubAccountTroopUnRead nochange=" + ((ConversationInfo)localObject).toString());
          continue;
        }
        localConversationInfo = new ConversationInfo(paramString, paramInt1, 0L, 0);
      }
      finally {}
      ConversationInfo localConversationInfo;
      localConversationInfo.setExtInt2(paramInt2);
      QLog.d("Q.unread.Proxy", 1, "insertOrUpdateSubAccountTroopUnRead insert=" + localConversationInfo.toString());
      this.jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap.put(localObject, localConversationInfo);
      d(paramString, paramInt1, localConversationInfo);
    }
  }
  
  protected void c(String paramString, int paramInt, ConversationInfo paramConversationInfo)
  {
    this.app.notifyObservers(ConversationProxyObserver.class, 0, true, new Bundle());
  }
  
  /* Error */
  protected int d(String paramString, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: iload_2
    //   4: invokestatic 117	com/tencent/imcore/message/UinTypeUtil:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   7: astore_1
    //   8: aload_0
    //   9: getfield 40	com/tencent/imcore/message/ConversationProxy:jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap	Lcom/tencent/commonsdk/cache/QQConcurrentHashMap;
    //   12: aload_1
    //   13: invokevirtual 121	com/tencent/commonsdk/cache/QQConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   16: ifeq +22 -> 38
    //   19: aload_0
    //   20: getfield 40	com/tencent/imcore/message/ConversationProxy:jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap	Lcom/tencent/commonsdk/cache/QQConcurrentHashMap;
    //   23: aload_1
    //   24: invokevirtual 125	com/tencent/commonsdk/cache/QQConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   27: checkcast 134	com/tencent/mobileqq/data/ConversationInfo
    //   30: getfield 267	com/tencent/mobileqq/data/ConversationInfo:extInt1	I
    //   33: istore_2
    //   34: aload_0
    //   35: monitorexit
    //   36: iload_2
    //   37: ireturn
    //   38: iconst_0
    //   39: istore_2
    //   40: goto -6 -> 34
    //   43: astore_1
    //   44: aload_0
    //   45: monitorexit
    //   46: aload_1
    //   47: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	48	0	this	ConversationProxy
    //   0	48	1	paramString	String
    //   0	48	2	paramInt	int
    // Exception table:
    //   from	to	target	type
    //   2	34	43	finally
  }
  
  /* Error */
  protected void d(String paramString, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: iload_2
    //   4: invokestatic 117	com/tencent/imcore/message/UinTypeUtil:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   7: astore 4
    //   9: aload_0
    //   10: getfield 40	com/tencent/imcore/message/ConversationProxy:jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap	Lcom/tencent/commonsdk/cache/QQConcurrentHashMap;
    //   13: aload 4
    //   15: invokevirtual 121	com/tencent/commonsdk/cache/QQConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   18: ifeq +54 -> 72
    //   21: aload_0
    //   22: getfield 40	com/tencent/imcore/message/ConversationProxy:jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap	Lcom/tencent/commonsdk/cache/QQConcurrentHashMap;
    //   25: aload 4
    //   27: invokevirtual 125	com/tencent/commonsdk/cache/QQConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   30: ifnull +42 -> 72
    //   33: aload_0
    //   34: getfield 40	com/tencent/imcore/message/ConversationProxy:jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap	Lcom/tencent/commonsdk/cache/QQConcurrentHashMap;
    //   37: aload 4
    //   39: invokevirtual 125	com/tencent/commonsdk/cache/QQConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   42: checkcast 134	com/tencent/mobileqq/data/ConversationInfo
    //   45: astore 4
    //   47: aload_0
    //   48: aload_1
    //   49: iload_2
    //   50: aload 4
    //   52: getfield 151	com/tencent/mobileqq/data/ConversationInfo:lastread	J
    //   55: iload_3
    //   56: aload 4
    //   58: getfield 264	com/tencent/mobileqq/data/ConversationInfo:unreadGiftCount	I
    //   61: aload 4
    //   63: getfield 267	com/tencent/mobileqq/data/ConversationInfo:extInt1	I
    //   66: invokevirtual 270	com/tencent/imcore/message/ConversationProxy:a	(Ljava/lang/String;IJIII)V
    //   69: aload_0
    //   70: monitorexit
    //   71: return
    //   72: aload_0
    //   73: aload_1
    //   74: iload_2
    //   75: lconst_0
    //   76: iload_3
    //   77: iconst_0
    //   78: iconst_0
    //   79: invokevirtual 270	com/tencent/imcore/message/ConversationProxy:a	(Ljava/lang/String;IJIII)V
    //   82: goto -13 -> 69
    //   85: astore_1
    //   86: aload_0
    //   87: monitorexit
    //   88: aload_1
    //   89: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	this	ConversationProxy
    //   0	90	1	paramString	String
    //   0	90	2	paramInt1	int
    //   0	90	3	paramInt2	int
    //   7	55	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	69	85	finally
    //   72	82	85	finally
  }
  
  protected void d(String paramString, int paramInt, ConversationInfo paramConversationInfo)
  {
    this.proxyManager.addMsgQueue(paramString, paramInt, ConversationInfo.getConversationInfoTableName(), paramConversationInfo, 3, null);
  }
  
  public void destroy()
  {
    try
    {
      this.jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap.clear();
      if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager != null) && (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.isOpen())) {
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.close();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  protected void e(String paramString, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: iload_2
    //   4: invokestatic 117	com/tencent/imcore/message/UinTypeUtil:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   7: astore 4
    //   9: aload_0
    //   10: getfield 40	com/tencent/imcore/message/ConversationProxy:jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap	Lcom/tencent/commonsdk/cache/QQConcurrentHashMap;
    //   13: aload 4
    //   15: invokevirtual 121	com/tencent/commonsdk/cache/QQConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   18: ifeq +60 -> 78
    //   21: aload_0
    //   22: getfield 40	com/tencent/imcore/message/ConversationProxy:jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap	Lcom/tencent/commonsdk/cache/QQConcurrentHashMap;
    //   25: aload 4
    //   27: invokevirtual 125	com/tencent/commonsdk/cache/QQConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   30: ifnull +48 -> 78
    //   33: aload_0
    //   34: getfield 40	com/tencent/imcore/message/ConversationProxy:jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap	Lcom/tencent/commonsdk/cache/QQConcurrentHashMap;
    //   37: aload 4
    //   39: invokevirtual 125	com/tencent/commonsdk/cache/QQConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   42: checkcast 134	com/tencent/mobileqq/data/ConversationInfo
    //   45: astore 4
    //   47: aload_0
    //   48: aload_1
    //   49: iload_2
    //   50: aload 4
    //   52: getfield 151	com/tencent/mobileqq/data/ConversationInfo:lastread	J
    //   55: aload 4
    //   57: getfield 244	com/tencent/mobileqq/data/ConversationInfo:unreadCount	I
    //   60: iload_3
    //   61: iadd
    //   62: aload 4
    //   64: getfield 264	com/tencent/mobileqq/data/ConversationInfo:unreadGiftCount	I
    //   67: aload 4
    //   69: getfield 267	com/tencent/mobileqq/data/ConversationInfo:extInt1	I
    //   72: invokevirtual 270	com/tencent/imcore/message/ConversationProxy:a	(Ljava/lang/String;IJIII)V
    //   75: aload_0
    //   76: monitorexit
    //   77: return
    //   78: aload_0
    //   79: aload_1
    //   80: iload_2
    //   81: lconst_0
    //   82: iload_3
    //   83: iconst_0
    //   84: iconst_0
    //   85: invokevirtual 270	com/tencent/imcore/message/ConversationProxy:a	(Ljava/lang/String;IJIII)V
    //   88: goto -13 -> 75
    //   91: astore_1
    //   92: aload_0
    //   93: monitorexit
    //   94: aload_1
    //   95: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	96	0	this	ConversationProxy
    //   0	96	1	paramString	String
    //   0	96	2	paramInt1	int
    //   0	96	3	paramInt2	int
    //   7	61	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	75	91	finally
    //   78	88	91	finally
  }
  
  protected void e(String paramString, int paramInt, ConversationInfo paramConversationInfo)
  {
    this.proxyManager.addMsgQueue(paramString, paramInt, ConversationInfo.getConversationInfoTableName(), paramConversationInfo, 5, null);
  }
  
  public void init() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.imcore.message.ConversationProxy
 * JD-Core Version:    0.7.0.1
 */