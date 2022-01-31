package com.tencent.mobileqq.app.msgcache;

import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.util.Pair;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.statistics.battery.HighFrequencyStringDetector;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;
import zun;
import zuo;

public class MsgLruCache
  extends ConcurrentHashMap
  implements Handler.Callback
{
  public static String TAG = "MsgLruCacheLog";
  public static int cacheConfig;
  private ConcurrentHashMap cacheInfoMap = new ConcurrentHashMap();
  private HighFrequencyStringDetector detector = new HighFrequencyStringDetector(CacheConstants.n, CacheConstants.o);
  private long initTime = System.currentTimeMillis();
  public volatile boolean isDestroyed;
  private zuo keyTimeComparator = new zuo(this, null);
  private WeakReference mApp;
  private Handler mHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
  private int monitorLoginInitCount;
  private ConcurrentHashMap opWeightDiffCache = new ConcurrentHashMap();
  private boolean reportInitCache;
  
  public MsgLruCache()
  {
    this.mHandler.sendEmptyMessageDelayed(1, 300000L);
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    int i;
    int k;
    if ((localObject instanceof QQAppInterface))
    {
      this.mApp = new WeakReference((QQAppInterface)localObject);
      localObject = ((AppRuntime)localObject).getApplication().getSharedPreferences(CacheConstants.jdField_a_of_type_JavaLangString, 0);
      if (((SharedPreferences)localObject).contains(CacheConstants.jdField_b_of_type_JavaLangString))
      {
        CacheConstants.jdField_a_of_type_Boolean = ((SharedPreferences)localObject).getBoolean(CacheConstants.jdField_b_of_type_JavaLangString, true);
        CacheConstants.jdField_b_of_type_Boolean = ((SharedPreferences)localObject).getBoolean(CacheConstants.jdField_c_of_type_JavaLangString, true);
        if (!CacheConstants.jdField_b_of_type_Boolean) {
          break label245;
        }
        i = 1;
        k = CacheConstants.m;
        if (!CacheConstants.jdField_a_of_type_Boolean) {
          break label250;
        }
      }
    }
    label245:
    label250:
    for (int j = 1;; j = 0)
    {
      cacheConfig = i << j + k;
      QLog.d(TAG, 1, new Object[] { "init, lru cache switch: ", Boolean.valueOf(CacheConstants.jdField_a_of_type_Boolean), ", init adjust switch: ", Boolean.valueOf(CacheConstants.jdField_b_of_type_Boolean) });
      return;
      i = 0;
      break;
    }
  }
  
  private int a(Map.Entry paramEntry)
  {
    return ((MsgLruCache.MsgCacheInfo)this.cacheInfoMap.get(paramEntry.getKey())).jdField_a_of_type_Int;
  }
  
  private void a()
  {
    for (;;)
    {
      Object localObject2;
      synchronized (this.cacheInfoMap)
      {
        Iterator localIterator = entrySet().iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localObject2 = (Map.Entry)localIterator.next();
        localObject2 = (MsgLruCache.MsgCacheInfo)this.cacheInfoMap.get(((Map.Entry)localObject2).getKey());
        if ((this.mApp != null) && (this.mApp.get() != null) && (((QQAppInterface)this.mApp.get()).a().a(((MsgLruCache.MsgCacheInfo)localObject2).jdField_a_of_type_JavaLangString, ((MsgLruCache.MsgCacheInfo)localObject2).jdField_c_of_type_Int) > 0))
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d(TAG, 2, new Object[] { "handleRegularScan, conv has unread msg, uin:", ((MsgLruCache.MsgCacheInfo)localObject2).jdField_a_of_type_JavaLangString, " type:", Integer.valueOf(((MsgLruCache.MsgCacheInfo)localObject2).jdField_c_of_type_Int) });
        }
      }
      ((MsgLruCache.MsgCacheInfo)localObject2).jdField_b_of_type_Int += CacheConstants.j;
      a((MsgLruCache.MsgCacheInfo)localObject2);
    }
  }
  
  private void a(MsgLruCache.MsgCacheInfo paramMsgCacheInfo)
  {
    if (paramMsgCacheInfo.jdField_b_of_type_Int > CacheConstants.g) {
      paramMsgCacheInfo.jdField_b_of_type_Int = CacheConstants.g;
    }
    while (paramMsgCacheInfo.jdField_b_of_type_Int >= CacheConstants.h) {
      return;
    }
    paramMsgCacheInfo.jdField_b_of_type_Int = CacheConstants.h;
  }
  
  private boolean a()
  {
    int i = getMsgCount();
    if (i <= CacheConstants.jdField_a_of_type_Int) {
      return false;
    }
    com.tencent.mobileqq.service.message.MessageCache.jdField_a_of_type_Boolean = true;
    Map.Entry localEntry;
    List localList;
    synchronized (this.cacheInfoMap)
    {
      QLog.d(TAG, 1, new Object[] { "eliminateCache, MsgCount: ", Integer.valueOf(i) });
      i -= CacheConstants.jdField_b_of_type_Int;
      if ((this.mApp != null) && (this.mApp.get() != null) && (((QQAppInterface)this.mApp.get()).a.b()))
      {
        QLog.d(TAG, 1, "eliminateCache, isInRealActionLoginB");
        delList(new ArrayList(keySet()), i, true);
        return true;
      }
      ArrayList localArrayList1 = new ArrayList();
      localIterator = entrySet().iterator();
      while (localIterator.hasNext())
      {
        localEntry = (Map.Entry)localIterator.next();
        localList = (List)localEntry.getValue();
        if ((a(localEntry) == CacheConstants.d) && (b(localEntry) == CacheConstants.h) && (localList != null) && (localList.size() > 0)) {
          localArrayList1.add(localEntry.getKey());
        }
      }
    }
    i = delList(localArrayList2, i, true);
    if (i <= 0) {
      return true;
    }
    localArrayList2.clear();
    Iterator localIterator = entrySet().iterator();
    while (localIterator.hasNext())
    {
      localEntry = (Map.Entry)localIterator.next();
      localList = (List)localEntry.getValue();
      if ((a(localEntry) == CacheConstants.jdField_c_of_type_Int) && (b(localEntry) == CacheConstants.h))
      {
        MsgLruCache.MsgCacheInfo localMsgCacheInfo = (MsgLruCache.MsgCacheInfo)this.cacheInfoMap.get(localEntry.getKey());
        if ((localMsgCacheInfo.jdField_c_of_type_Int == 0) && (MsgProxyUtils.a(localMsgCacheInfo.jdField_a_of_type_JavaLangString))) {
          changeCacheType(localEntry.getKey(), CacheConstants.d);
        } else if ((localList != null) && (localList.size() > CacheConstants.f)) {
          localArrayList2.add(localEntry.getKey());
        }
      }
    }
    i = delList(localArrayList2, i, false);
    if (i > 0) {
      delList(new ArrayList(keySet()), i, true);
    }
    return true;
  }
  
  private int b(Map.Entry paramEntry)
  {
    return ((MsgLruCache.MsgCacheInfo)this.cacheInfoMap.get(paramEntry.getKey())).jdField_b_of_type_Int;
  }
  
  private void b()
  {
    synchronized (this.cacheInfoMap)
    {
      Iterator localIterator = this.opWeightDiffCache.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        Object localObject2 = (String)localEntry.getKey();
        localObject2 = (MsgLruCache.MsgCacheInfo)this.cacheInfoMap.get(localObject2);
        if (localObject2 != null)
        {
          int i = ((MsgLruCache.MsgCacheInfo)localObject2).jdField_b_of_type_Int;
          ((MsgLruCache.MsgCacheInfo)localObject2).jdField_b_of_type_Int = (((Integer)localEntry.getValue()).intValue() + i);
          a((MsgLruCache.MsgCacheInfo)localObject2);
        }
      }
    }
    this.opWeightDiffCache.clear();
  }
  
  public void addCacheOpWeight(Object paramObject, int paramInt)
  {
    String str;
    Integer localInteger;
    if (containsKey(paramObject))
    {
      str = (String)paramObject;
      localInteger = (Integer)this.opWeightDiffCache.get(paramObject);
      if (localInteger != null) {
        break label95;
      }
    }
    label95:
    for (int i = 0;; i = localInteger.intValue())
    {
      i = Math.max(i, paramInt);
      this.opWeightDiffCache.put(str, Integer.valueOf(i));
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, new Object[] { "addCacheOpWeight, key: ", paramObject, " addWeight:", Integer.valueOf(paramInt) });
      }
      return;
    }
  }
  
  public void changeCacheType(Object paramObject, int paramInt)
  {
    if (containsKey(paramObject))
    {
      Object localObject = (String)paramObject;
      localObject = (MsgLruCache.MsgCacheInfo)this.cacheInfoMap.get(localObject);
      if (((MsgLruCache.MsgCacheInfo)localObject).jdField_a_of_type_Int != paramInt)
      {
        ((MsgLruCache.MsgCacheInfo)localObject).jdField_a_of_type_Int = paramInt;
        ((MsgLruCache.MsgCacheInfo)localObject).jdField_b_of_type_Int = CacheConstants.i;
      }
      this.opWeightDiffCache.remove(paramObject);
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, new Object[] { "changeCacheType, key: ", paramObject, " cacheTypeModified:", Integer.valueOf(paramInt) });
      }
    }
  }
  
  public void clear()
  {
    synchronized (this.cacheInfoMap)
    {
      super.clear();
      this.cacheInfoMap.clear();
      this.opWeightDiffCache.clear();
      return;
    }
  }
  
  /* Error */
  public int delList(ArrayList paramArrayList, int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iload_2
    //   3: istore 4
    //   5: aload_0
    //   6: getfield 109	com/tencent/mobileqq/app/msgcache/MsgLruCache:mApp	Lmqq/util/WeakReference;
    //   9: ifnull +37 -> 46
    //   12: iload_2
    //   13: istore 4
    //   15: aload_0
    //   16: getfield 109	com/tencent/mobileqq/app/msgcache/MsgLruCache:mApp	Lmqq/util/WeakReference;
    //   19: invokevirtual 202	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   22: ifnull +24 -> 46
    //   25: iload_2
    //   26: istore 4
    //   28: aload_1
    //   29: ifnull +17 -> 46
    //   32: aload_1
    //   33: invokevirtual 348	java/util/ArrayList:isEmpty	()Z
    //   36: istore 5
    //   38: iload 5
    //   40: ifeq +11 -> 51
    //   43: iload_2
    //   44: istore 4
    //   46: aload_0
    //   47: monitorexit
    //   48: iload 4
    //   50: ireturn
    //   51: aload_1
    //   52: aload_0
    //   53: getfield 76	com/tencent/mobileqq/app/msgcache/MsgLruCache:keyTimeComparator	Lzuo;
    //   56: invokestatic 354	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   59: aload_1
    //   60: invokevirtual 355	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   63: astore_1
    //   64: iload_2
    //   65: istore 4
    //   67: aload_1
    //   68: invokeinterface 197 1 0
    //   73: ifeq +358 -> 431
    //   76: iload_2
    //   77: istore 4
    //   79: aload_1
    //   80: invokeinterface 200 1 0
    //   85: checkcast 311	java/lang/String
    //   88: astore 6
    //   90: iload_2
    //   91: istore 4
    //   93: aload_0
    //   94: getfield 109	com/tencent/mobileqq/app/msgcache/MsgLruCache:mApp	Lmqq/util/WeakReference;
    //   97: invokevirtual 202	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   100: checkcast 102	com/tencent/mobileqq/app/QQAppInterface
    //   103: invokevirtual 359	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   106: invokestatic 364	com/tencent/mobileqq/app/message/MsgPool:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/app/message/MsgPool;
    //   109: invokevirtual 367	com/tencent/mobileqq/app/message/MsgPool:b	()Ljava/util/concurrent/ConcurrentHashMap;
    //   112: invokevirtual 368	java/util/concurrent/ConcurrentHashMap:keySet	()Ljava/util/Set;
    //   115: aload 6
    //   117: invokeinterface 370 2 0
    //   122: ifne -58 -> 64
    //   125: iload_2
    //   126: istore 4
    //   128: aload 6
    //   130: invokestatic 372	com/tencent/mobileqq/app/message/MsgProxyUtils:b	(Ljava/lang/String;)Z
    //   133: ifne -69 -> 64
    //   136: iload_2
    //   137: istore 4
    //   139: aload_0
    //   140: aload 6
    //   142: invokevirtual 376	com/tencent/mobileqq/app/msgcache/MsgLruCache:getOriginal	(Ljava/lang/Object;)Ljava/util/List;
    //   145: astore 7
    //   147: aload 7
    //   149: ifnull -85 -> 64
    //   152: iload_2
    //   153: istore 4
    //   155: aload 7
    //   157: invokeinterface 377 1 0
    //   162: ifne -98 -> 64
    //   165: iload_2
    //   166: istore 4
    //   168: aload 7
    //   170: aload 7
    //   172: invokeinterface 289 1 0
    //   177: iconst_1
    //   178: isub
    //   179: invokeinterface 380 2 0
    //   184: checkcast 382	com/tencent/mobileqq/data/MessageRecord
    //   187: astore 8
    //   189: iload_2
    //   190: istore 4
    //   192: aload_0
    //   193: getfield 109	com/tencent/mobileqq/app/msgcache/MsgLruCache:mApp	Lmqq/util/WeakReference;
    //   196: invokevirtual 202	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   199: checkcast 102	com/tencent/mobileqq/app/QQAppInterface
    //   202: aload 8
    //   204: getfield 385	com/tencent/mobileqq/data/MessageRecord:istroop	I
    //   207: invokevirtual 388	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/message/MsgProxy;
    //   210: aload 8
    //   212: getfield 391	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   215: aload 8
    //   217: getfield 385	com/tencent/mobileqq/data/MessageRecord:istroop	I
    //   220: iconst_1
    //   221: invokevirtual 396	com/tencent/mobileqq/app/message/MsgProxy:a	(Ljava/lang/String;IZ)Z
    //   224: ifne -160 -> 64
    //   227: iload_3
    //   228: ifeq +29 -> 257
    //   231: iload_2
    //   232: istore 4
    //   234: aload_0
    //   235: aload 6
    //   237: invokevirtual 398	com/tencent/mobileqq/app/msgcache/MsgLruCache:remove	(Ljava/lang/Object;)Ljava/util/List;
    //   240: pop
    //   241: iload_2
    //   242: istore 4
    //   244: iload_2
    //   245: aload 7
    //   247: invokeinterface 289 1 0
    //   252: isub
    //   253: istore_2
    //   254: goto +180 -> 434
    //   257: iload_2
    //   258: istore 4
    //   260: aload_0
    //   261: getfield 109	com/tencent/mobileqq/app/msgcache/MsgLruCache:mApp	Lmqq/util/WeakReference;
    //   264: invokevirtual 202	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   267: checkcast 102	com/tencent/mobileqq/app/QQAppInterface
    //   270: invokevirtual 359	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   273: invokestatic 364	com/tencent/mobileqq/app/message/MsgPool:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/app/message/MsgPool;
    //   276: aload 7
    //   278: iconst_0
    //   279: invokeinterface 380 2 0
    //   284: checkcast 382	com/tencent/mobileqq/data/MessageRecord
    //   287: getfield 391	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   290: aload 7
    //   292: iconst_0
    //   293: invokeinterface 380 2 0
    //   298: checkcast 382	com/tencent/mobileqq/data/MessageRecord
    //   301: getfield 385	com/tencent/mobileqq/data/MessageRecord:istroop	I
    //   304: invokevirtual 401	com/tencent/mobileqq/app/message/MsgPool:a	(Ljava/lang/String;I)Ljava/lang/Object;
    //   307: astore 8
    //   309: iload_2
    //   310: istore 4
    //   312: aload 8
    //   314: monitorenter
    //   315: iload_2
    //   316: istore 4
    //   318: iload_2
    //   319: aload 7
    //   321: invokeinterface 289 1 0
    //   326: getstatic 308	com/tencent/mobileqq/app/msgcache/CacheConstants:f	I
    //   329: isub
    //   330: isub
    //   331: istore_2
    //   332: iload_2
    //   333: istore 4
    //   335: aload_0
    //   336: aload 6
    //   338: new 264	java/util/ArrayList
    //   341: dup
    //   342: aload 7
    //   344: aload 7
    //   346: invokeinterface 289 1 0
    //   351: getstatic 308	com/tencent/mobileqq/app/msgcache/CacheConstants:f	I
    //   354: isub
    //   355: aload 7
    //   357: invokeinterface 289 1 0
    //   362: invokeinterface 405 3 0
    //   367: invokespecial 270	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   370: invokespecial 329	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   373: pop
    //   374: iload_2
    //   375: istore 4
    //   377: aload_0
    //   378: aload 6
    //   380: getstatic 284	com/tencent/mobileqq/app/msgcache/CacheConstants:d	I
    //   383: invokevirtual 305	com/tencent/mobileqq/app/msgcache/MsgLruCache:changeCacheType	(Ljava/lang/Object;I)V
    //   386: iload_2
    //   387: istore 4
    //   389: aload 8
    //   391: monitorexit
    //   392: goto +42 -> 434
    //   395: astore_1
    //   396: aload 8
    //   398: monitorexit
    //   399: aload_1
    //   400: athrow
    //   401: astore_1
    //   402: iload 4
    //   404: istore_2
    //   405: getstatic 33	com/tencent/mobileqq/app/msgcache/MsgLruCache:TAG	Ljava/lang/String;
    //   408: iconst_1
    //   409: ldc_w 407
    //   412: aload_1
    //   413: invokestatic 411	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   416: goto +22 -> 438
    //   419: astore_1
    //   420: aload_0
    //   421: monitorexit
    //   422: aload_1
    //   423: athrow
    //   424: goto -360 -> 64
    //   427: astore_1
    //   428: goto -23 -> 405
    //   431: goto +7 -> 438
    //   434: iload_2
    //   435: ifgt -11 -> 424
    //   438: iload_2
    //   439: istore 4
    //   441: goto -395 -> 46
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	444	0	this	MsgLruCache
    //   0	444	1	paramArrayList	ArrayList
    //   0	444	2	paramInt	int
    //   0	444	3	paramBoolean	boolean
    //   3	437	4	i	int
    //   36	3	5	bool	boolean
    //   88	291	6	str	String
    //   145	211	7	localList	List
    //   187	210	8	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   318	332	395	finally
    //   335	374	395	finally
    //   377	386	395	finally
    //   389	392	395	finally
    //   396	399	395	finally
    //   67	76	401	java/lang/Exception
    //   79	90	401	java/lang/Exception
    //   93	125	401	java/lang/Exception
    //   128	136	401	java/lang/Exception
    //   139	147	401	java/lang/Exception
    //   155	165	401	java/lang/Exception
    //   168	189	401	java/lang/Exception
    //   192	227	401	java/lang/Exception
    //   234	241	401	java/lang/Exception
    //   244	254	401	java/lang/Exception
    //   260	309	401	java/lang/Exception
    //   312	315	401	java/lang/Exception
    //   399	401	401	java/lang/Exception
    //   5	12	419	finally
    //   15	25	419	finally
    //   32	38	419	finally
    //   51	64	419	finally
    //   67	76	419	finally
    //   79	90	419	finally
    //   93	125	419	finally
    //   128	136	419	finally
    //   139	147	419	finally
    //   155	165	419	finally
    //   168	189	419	finally
    //   192	227	419	finally
    //   234	241	419	finally
    //   244	254	419	finally
    //   260	309	419	finally
    //   312	315	419	finally
    //   399	401	419	finally
    //   405	416	419	finally
    //   5	12	427	java/lang/Exception
    //   15	25	427	java/lang/Exception
    //   32	38	427	java/lang/Exception
    //   51	64	427	java/lang/Exception
  }
  
  public void destroy()
  {
    this.isDestroyed = true;
    this.mHandler.removeMessages(1);
    QLog.d(TAG, 1, "destroy");
  }
  
  public List get(Object paramObject)
  {
    List localList = (List)super.get(paramObject);
    String str;
    if (localList != null)
    {
      str = (String)paramObject;
      paramObject = (Integer)this.opWeightDiffCache.get(paramObject);
      if (paramObject != null) {
        break label61;
      }
    }
    label61:
    for (int i = 0;; i = paramObject.intValue())
    {
      i = Math.max(i, CacheConstants.l);
      this.opWeightDiffCache.put(str, Integer.valueOf(i));
      return localList;
    }
  }
  
  public int getCacheType(Object paramObject)
  {
    if (containsKey(paramObject))
    {
      paramObject = (String)paramObject;
      return ((MsgLruCache.MsgCacheInfo)this.cacheInfoMap.get(paramObject)).jdField_a_of_type_Int;
    }
    return CacheConstants.jdField_c_of_type_Int;
  }
  
  public Pair getCacheTypeInfo(int paramInt)
  {
    int j = 0;
    for (;;)
    {
      synchronized (this.cacheInfoMap)
      {
        Iterator localIterator = entrySet().iterator();
        i = 0;
        if (localIterator.hasNext())
        {
          Object localObject2 = (Map.Entry)localIterator.next();
          if (((MsgLruCache.MsgCacheInfo)this.cacheInfoMap.get(((Map.Entry)localObject2).getKey())).jdField_a_of_type_Int != paramInt) {
            break label148;
          }
          localObject2 = (List)((Map.Entry)localObject2).getValue();
          j += 1;
          if (localObject2 != null)
          {
            k = ((List)localObject2).size() + i;
            i = j;
            j = k;
            break label156;
          }
        }
        else
        {
          return new Pair(Integer.valueOf(j), Integer.valueOf(i));
        }
      }
      int k = i;
      int i = j;
      j = k;
      break label156;
      label148:
      k = j;
      j = i;
      i = k;
      label156:
      k = j;
      j = i;
      i = k;
    }
  }
  
  public int getMsgCount()
  {
    Iterator localIterator = entrySet().iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      List localList = (List)((Map.Entry)localIterator.next()).getValue();
      if (localList == null) {
        break label57;
      }
      i = localList.size() + i;
    }
    label57:
    for (;;)
    {
      break;
      return i;
    }
  }
  
  public List getOriginal(Object paramObject)
  {
    return (List)super.get(paramObject);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return false;
      QLog.d(TAG, 1, "BEFORE_SCAN");
      printMsgLruCache();
      b();
      a();
      boolean bool = a();
      QLog.d(TAG, 1, new Object[] { "AFTER_SCAN, isChanged: ", Boolean.valueOf(bool) });
      if (bool) {
        printMsgLruCache();
      }
    } while ((!CacheConstants.jdField_a_of_type_Boolean) || (this.isDestroyed));
    this.mHandler.sendEmptyMessageDelayed(1, 300000L);
    return false;
  }
  
  public void printMsgLruCache()
  {
    if (QLog.isColorLevel())
    {
      long l1 = System.currentTimeMillis();
      StringBuilder localStringBuilder = new StringBuilder();
      Iterator localIterator = entrySet().iterator();
      if (localIterator.hasNext())
      {
        Object localObject = (Map.Entry)localIterator.next();
        String str = (String)((Map.Entry)localObject).getKey();
        if (((Map.Entry)localObject).getValue() != null) {}
        for (int i = ((List)((Map.Entry)localObject).getValue()).size();; i = 0)
        {
          localStringBuilder.append('{');
          localStringBuilder.append("key:").append(str).append(",");
          localStringBuilder.append("size:").append(i).append(",");
          localStringBuilder.append("info:").append(this.cacheInfoMap.get(str)).append(",");
          if (this.opWeightDiffCache.containsKey(str)) {
            localStringBuilder.append("diff:").append(this.opWeightDiffCache.get(str)).append(",");
          }
          if (i > 0)
          {
            localObject = (List)((Map.Entry)localObject).getValue();
            localStringBuilder.append("lastMsgTime:").append(((MessageRecord)((List)localObject).get(i - 1)).time);
          }
          localStringBuilder.append("}");
          break;
        }
      }
      long l2 = System.currentTimeMillis();
      QLog.d(TAG, 2, new Object[] { "printCacheInfo cost:", Long.valueOf(l2 - l1), ", cacheSize:", Integer.valueOf(size()), ", msgCount:", Integer.valueOf(getMsgCount()), ", ", localStringBuilder.toString() });
    }
  }
  
  public List put(String paramString, int paramInt, List paramList)
  {
    String str = MsgProxyUtils.a(paramString, paramInt);
    if (!containsKey(str))
    {
      paramString = new MsgLruCache.MsgCacheInfo(this, paramString, paramInt, CacheConstants.jdField_c_of_type_Int, CacheConstants.i);
      this.cacheInfoMap.put(str, paramString);
      a();
      paramInt = size();
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, new Object[] { "put, key: ", str, " cacheSize:", Integer.valueOf(paramInt + 1), " msgCount:", Integer.valueOf(getMsgCount()) });
      }
    }
    return (List)super.put(str, paramList);
  }
  
  public List put(String paramString, List paramList)
  {
    if (!containsKey(paramString))
    {
      MsgLruCache.MsgCacheInfo localMsgCacheInfo = new MsgLruCache.MsgCacheInfo(this, CacheConstants.a(paramString), CacheConstants.a(paramString), CacheConstants.jdField_c_of_type_Int, CacheConstants.i);
      this.cacheInfoMap.put(paramString, localMsgCacheInfo);
      int i = size();
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, new Object[] { "put, key: ", paramString, " size:", Integer.valueOf(i + 1) });
      }
    }
    return (List)super.put(paramString, paramList);
  }
  
  public List remove(Object paramObject)
  {
    synchronized (this.cacheInfoMap)
    {
      List localList = (List)super.remove(paramObject);
      this.cacheInfoMap.remove(paramObject);
      this.opWeightDiffCache.remove(paramObject);
      return localList;
    }
  }
  
  public void reportCacheLoad()
  {
    Object localObject = this.detector.a();
    this.detector.a();
    if ((this.mApp != null) && (this.mApp.get() != null))
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("count", String.valueOf(this.monitorLoginInitCount));
      boolean bool;
      int j;
      int k;
      label153:
      int i;
      if ((localObject != null) && (!((Map)localObject).isEmpty()))
      {
        bool = true;
        localHashMap.put("hasErStack", String.valueOf(bool));
        localHashMap.put("cacheType", String.valueOf(cacheConfig));
        if ((localObject == null) || (((Map)localObject).isEmpty())) {
          break label358;
        }
        localObject = new ArrayList(((Map)localObject).entrySet());
        Collections.sort((List)localObject, new zun(this));
        j = 0;
        k = 0;
        if (j >= ((ArrayList)localObject).size()) {
          break label330;
        }
        i = k;
        if (!((String)((Map.Entry)((ArrayList)localObject).get(j)).getKey()).contains("InitBeforeSyncMsg.doStep"))
        {
          if (!((String)((Map.Entry)((ArrayList)localObject).get(j)).getKey()).contains("MsgProxyContainer.init_lazy")) {
            break label233;
          }
          i = k;
        }
      }
      label233:
      do
      {
        j += 1;
        k = i;
        break label153;
        bool = false;
        break;
        localHashMap.put("count_" + k, String.valueOf(((Map.Entry)((ArrayList)localObject).get(j)).getValue()));
        localHashMap.put("stack_" + k, String.valueOf(((Map.Entry)((ArrayList)localObject).get(j)).getKey()));
        k += 1;
        i = k;
      } while (k <= 3);
      label330:
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, new Object[] { "reportCacheLoad, ", localHashMap });
      }
      label358:
      StatisticCollector.a(((QQAppInterface)this.mApp.get()).getApp()).a(null, CacheConstants.e, true, -1L, 0L, localHashMap, null, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.msgcache.MsgLruCache
 * JD-Core Version:    0.7.0.1
 */