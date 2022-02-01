package com.tencent.mobileqq.app.msgcache;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.MsgPool;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qapmsdk.qqbattery.HighFrequencyStringDetector;
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
import java.util.concurrent.locks.Lock;
import mqq.app.AppRuntime;
import mqq.util.WeakReference;

public class MsgLruCache
  extends ConcurrentHashMap<String, List<MessageRecord>>
  implements Handler.Callback
{
  public static String TAG = "MsgLruCacheLog";
  public static int cacheConfig;
  private ConcurrentHashMap<String, MsgLruCache.MsgCacheInfo> cacheInfoMap = new ConcurrentHashMap();
  private HighFrequencyStringDetector detector = new HighFrequencyStringDetector(CacheConstants.o, CacheConstants.p);
  private long initTime;
  public volatile boolean isDestroyed = false;
  private MsgLruCache.KeyTimeComparator keyTimeComparator = new MsgLruCache.KeyTimeComparator(this, null);
  private WeakReference<QQAppInterface> mApp = null;
  private Handler mHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
  private MsgPool mMsgPool;
  private int monitorLoginInitCount;
  private ConcurrentHashMap<String, Integer> opWeightDiffCache = new ConcurrentHashMap();
  private boolean reportInitCache = false;
  
  public MsgLruCache(MsgPool paramMsgPool)
  {
    this.mMsgPool = paramMsgPool;
    this.initTime = System.currentTimeMillis();
    this.mHandler.sendEmptyMessageDelayed(1, 300000L);
    this.mApp = makeApp();
  }
  
  private int a(Map.Entry paramEntry)
  {
    return ((MsgLruCache.MsgCacheInfo)this.cacheInfoMap.get(paramEntry.getKey())).jdField_a_of_type_Int;
  }
  
  private void a()
  {
    long l1 = System.currentTimeMillis();
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = entrySet().iterator();
    for (;;)
    {
      boolean bool = localIterator.hasNext();
      int i = 0;
      if (bool)
      {
        Object localObject2 = (Map.Entry)localIterator.next();
        String str = (String)((Map.Entry)localObject2).getKey();
        Lock localLock = this.mMsgPool.a(str);
        localLock.lock();
        try
        {
          localObject2 = (List)((Map.Entry)localObject2).getValue();
          if (localObject2 != null) {
            i = ((List)localObject2).size();
          }
          localStringBuilder.append('{');
          localStringBuilder.append("key:");
          localStringBuilder.append(str);
          localStringBuilder.append(",");
          localStringBuilder.append("size:");
          localStringBuilder.append(i);
          localStringBuilder.append(",");
          localStringBuilder.append("info:");
          localStringBuilder.append(this.cacheInfoMap.get(str));
          localStringBuilder.append(",");
          if (this.opWeightDiffCache.containsKey(str))
          {
            localStringBuilder.append("diff:");
            localStringBuilder.append(this.opWeightDiffCache.get(str));
            localStringBuilder.append(",");
          }
          if (i > 0)
          {
            localStringBuilder.append("lastMsgTime:");
            localStringBuilder.append(((MessageRecord)((List)localObject2).get(i - 1)).time);
          }
          localStringBuilder.append("}");
          localLock.unlock();
        }
        finally
        {
          localLock.unlock();
        }
      }
    }
    long l2 = System.currentTimeMillis();
    QLog.d(TAG, 2, new Object[] { "printCacheInfo cost:", Long.valueOf(l2 - l1), ", cacheSize:", Integer.valueOf(size()), ", msgCount:", Integer.valueOf(getMsgCount()), ", ", localObject1.toString() });
  }
  
  private void a(MsgLruCache.MsgCacheInfo paramMsgCacheInfo)
  {
    if (paramMsgCacheInfo.b > CacheConstants.g)
    {
      paramMsgCacheInfo.b = CacheConstants.g;
      return;
    }
    if (paramMsgCacheInfo.b < CacheConstants.h) {
      paramMsgCacheInfo.b = CacheConstants.h;
    }
  }
  
  private boolean a()
  {
    int i = getMsgCount();
    if (i <= CacheConstants.jdField_a_of_type_Int) {
      return false;
    }
    com.tencent.mobileqq.service.message.MessageCache.a = true;
    synchronized (this.cacheInfoMap)
    {
      QLog.d(TAG, 1, new Object[] { "eliminateCache, MsgCount: ", Integer.valueOf(i) });
      i -= CacheConstants.b;
      d();
      if ((this.mApp != null) && (this.mApp.get() != null) && (((QQAppInterface)this.mApp.get()).mAutomator.b()))
      {
        QLog.d(TAG, 1, "eliminateCache, isInRealActionLoginB");
        delList(new ArrayList(keySet()), i, true);
        return true;
      }
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = entrySet().iterator();
      Map.Entry localEntry;
      List localList;
      while (localIterator.hasNext())
      {
        localEntry = (Map.Entry)localIterator.next();
        localList = (List)localEntry.getValue();
        if ((a(localEntry) == CacheConstants.d) && (b(localEntry) == CacheConstants.h) && (localList != null) && (localList.size() > 0)) {
          localArrayList.add(localEntry.getKey());
        }
      }
      i = delList(localArrayList, i, true);
      if (i <= 0) {
        return true;
      }
      localArrayList.clear();
      localIterator = entrySet().iterator();
      while (localIterator.hasNext())
      {
        localEntry = (Map.Entry)localIterator.next();
        localList = (List)localEntry.getValue();
        if ((a(localEntry) == CacheConstants.c) && (b(localEntry) == CacheConstants.h))
        {
          MsgLruCache.MsgCacheInfo localMsgCacheInfo = (MsgLruCache.MsgCacheInfo)this.cacheInfoMap.get(localEntry.getKey());
          if ((localMsgCacheInfo.c == 0) && (UinTypeUtil.a(localMsgCacheInfo.jdField_a_of_type_JavaLangString))) {
            changeCacheType(localEntry.getKey(), CacheConstants.d);
          } else if ((localList != null) && (localList.size() > CacheConstants.f)) {
            localArrayList.add(localEntry.getKey());
          }
        }
      }
      i = delList(localArrayList, i, false);
      if (i > 0) {
        delList(new ArrayList(keySet()), i, true);
      }
      return true;
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  private int b(Map.Entry paramEntry)
  {
    return ((MsgLruCache.MsgCacheInfo)this.cacheInfoMap.get(paramEntry.getKey())).b;
  }
  
  private void b()
  {
    synchronized (this.cacheInfoMap)
    {
      Iterator localIterator = entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = (Map.Entry)localIterator.next();
        localObject2 = (MsgLruCache.MsgCacheInfo)this.cacheInfoMap.get(((Map.Entry)localObject2).getKey());
        d();
        if ((this.mApp != null) && (this.mApp.get() != null) && (((QQAppInterface)this.mApp.get()).getConversationFacade().a(((MsgLruCache.MsgCacheInfo)localObject2).jdField_a_of_type_JavaLangString, ((MsgLruCache.MsgCacheInfo)localObject2).c) > 0))
        {
          if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, new Object[] { "handleRegularScan, conv has unread msg, uin:", ((MsgLruCache.MsgCacheInfo)localObject2).jdField_a_of_type_JavaLangString, " type:", Integer.valueOf(((MsgLruCache.MsgCacheInfo)localObject2).c) });
          }
        }
        else
        {
          ((MsgLruCache.MsgCacheInfo)localObject2).b += CacheConstants.j;
          a((MsgLruCache.MsgCacheInfo)localObject2);
        }
      }
      return;
    }
    for (;;)
    {
      throw localObject1;
    }
  }
  
  private void c()
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
          ((MsgLruCache.MsgCacheInfo)localObject2).b += ((Integer)localEntry.getValue()).intValue();
          a((MsgLruCache.MsgCacheInfo)localObject2);
        }
      }
      this.opWeightDiffCache.clear();
      return;
    }
    for (;;)
    {
      throw localObject1;
    }
  }
  
  private void d()
  {
    if (this.mApp == null)
    {
      AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
      if (((localAppRuntime instanceof QQAppInterface)) && (!TextUtils.isEmpty(localAppRuntime.getAccount()))) {
        setApp((QQAppInterface)localAppRuntime);
      }
    }
  }
  
  public void addCacheOpWeight(Object paramObject, int paramInt)
  {
    if (containsKey(paramObject))
    {
      String str = (String)paramObject;
      Integer localInteger = (Integer)this.opWeightDiffCache.get(paramObject);
      if (localInteger == null) {
        i = 0;
      } else {
        i = localInteger.intValue();
      }
      int i = Math.max(i, paramInt);
      this.opWeightDiffCache.put(str, Integer.valueOf(i));
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, new Object[] { "addCacheOpWeight, key: ", paramObject, " addWeight:", Integer.valueOf(paramInt) });
      }
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
        ((MsgLruCache.MsgCacheInfo)localObject).b = CacheConstants.i;
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
  public int delList(ArrayList<String> paramArrayList, int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iload_2
    //   3: istore 4
    //   5: aload_0
    //   6: invokespecial 268	com/tencent/mobileqq/app/msgcache/MsgLruCache:d	()V
    //   9: iload_2
    //   10: istore 4
    //   12: aload_0
    //   13: getfield 67	com/tencent/mobileqq/app/msgcache/MsgLruCache:mApp	Lmqq/util/WeakReference;
    //   16: ifnull +412 -> 428
    //   19: iload_2
    //   20: istore 4
    //   22: aload_0
    //   23: getfield 67	com/tencent/mobileqq/app/msgcache/MsgLruCache:mApp	Lmqq/util/WeakReference;
    //   26: invokevirtual 272	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   29: checkcast 274	com/tencent/mobileqq/app/QQAppInterface
    //   32: astore 6
    //   34: aload 6
    //   36: ifnull +392 -> 428
    //   39: aload_1
    //   40: ifnull +388 -> 428
    //   43: iload_2
    //   44: istore 4
    //   46: aload_1
    //   47: invokevirtual 411	java/util/ArrayList:isEmpty	()Z
    //   50: ifeq +6 -> 56
    //   53: goto +375 -> 428
    //   56: iload_2
    //   57: istore 4
    //   59: aload_1
    //   60: aload_0
    //   61: getfield 87	com/tencent/mobileqq/app/msgcache/MsgLruCache:keyTimeComparator	Lcom/tencent/mobileqq/app/msgcache/MsgLruCache$KeyTimeComparator;
    //   64: invokestatic 417	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   67: iload_2
    //   68: istore 4
    //   70: aload_1
    //   71: invokevirtual 418	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   74: astore_1
    //   75: iload_2
    //   76: istore 4
    //   78: iload_2
    //   79: istore 5
    //   81: aload_1
    //   82: invokeinterface 142 1 0
    //   87: ifeq +365 -> 452
    //   90: iload_2
    //   91: istore 4
    //   93: aload_1
    //   94: invokeinterface 145 1 0
    //   99: checkcast 147	java/lang/String
    //   102: astore 7
    //   104: iload_2
    //   105: istore 4
    //   107: aload_0
    //   108: getfield 89	com/tencent/mobileqq/app/msgcache/MsgLruCache:mMsgPool	Lcom/tencent/imcore/message/MsgPool;
    //   111: astore 9
    //   113: iload_2
    //   114: istore 4
    //   116: aload 9
    //   118: invokevirtual 421	com/tencent/imcore/message/MsgPool:a	()Ljava/util/Map;
    //   121: invokeinterface 424 1 0
    //   126: aload 7
    //   128: invokeinterface 427 2 0
    //   133: ifeq +6 -> 139
    //   136: goto -61 -> 75
    //   139: iload_2
    //   140: istore 4
    //   142: aload 7
    //   144: invokestatic 429	com/tencent/imcore/message/UinTypeUtil:b	(Ljava/lang/String;)Z
    //   147: ifeq +6 -> 153
    //   150: goto -75 -> 75
    //   153: iload_2
    //   154: istore 4
    //   156: aload_0
    //   157: aload 7
    //   159: invokevirtual 433	com/tencent/mobileqq/app/msgcache/MsgLruCache:getOriginal	(Ljava/lang/Object;)Ljava/util/List;
    //   162: astore 8
    //   164: aload 8
    //   166: ifnull -91 -> 75
    //   169: iload_2
    //   170: istore 4
    //   172: aload 8
    //   174: invokeinterface 434 1 0
    //   179: ifeq +6 -> 185
    //   182: goto -107 -> 75
    //   185: iload_2
    //   186: istore 4
    //   188: aload 8
    //   190: aload 8
    //   192: invokeinterface 166 1 0
    //   197: iconst_1
    //   198: isub
    //   199: invokeinterface 198 2 0
    //   204: checkcast 200	com/tencent/mobileqq/data/MessageRecord
    //   207: astore 10
    //   209: iload_2
    //   210: istore 4
    //   212: aload 6
    //   214: aload 10
    //   216: getfield 437	com/tencent/mobileqq/data/MessageRecord:istroop	I
    //   219: invokevirtual 441	com/tencent/mobileqq/app/QQAppInterface:getMessageProxy	(I)Lcom/tencent/imcore/message/BaseMsgProxy;
    //   222: aload 10
    //   224: getfield 444	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   227: aload 10
    //   229: getfield 437	com/tencent/mobileqq/data/MessageRecord:istroop	I
    //   232: iconst_1
    //   233: invokevirtual 449	com/tencent/imcore/message/BaseMsgProxy:a	(Ljava/lang/String;IZ)Z
    //   236: ifeq +6 -> 242
    //   239: goto -164 -> 75
    //   242: iload_3
    //   243: ifeq +32 -> 275
    //   246: iload_2
    //   247: istore 4
    //   249: aload_0
    //   250: aload 7
    //   252: invokevirtual 451	com/tencent/mobileqq/app/msgcache/MsgLruCache:remove	(Ljava/lang/Object;)Ljava/util/List;
    //   255: pop
    //   256: iload_2
    //   257: istore 4
    //   259: iload_2
    //   260: aload 8
    //   262: invokeinterface 166 1 0
    //   267: isub
    //   268: istore_2
    //   269: iload_2
    //   270: istore 4
    //   272: goto +195 -> 467
    //   275: iload_2
    //   276: istore 4
    //   278: aload 9
    //   280: aload 8
    //   282: iconst_0
    //   283: invokeinterface 198 2 0
    //   288: checkcast 200	com/tencent/mobileqq/data/MessageRecord
    //   291: getfield 444	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   294: aload 8
    //   296: iconst_0
    //   297: invokeinterface 198 2 0
    //   302: checkcast 200	com/tencent/mobileqq/data/MessageRecord
    //   305: getfield 437	com/tencent/mobileqq/data/MessageRecord:istroop	I
    //   308: invokevirtual 454	com/tencent/imcore/message/MsgPool:a	(Ljava/lang/String;I)Ljava/util/concurrent/locks/Lock;
    //   311: astore 9
    //   313: iload_2
    //   314: istore 4
    //   316: aload 9
    //   318: invokeinterface 157 1 0
    //   323: iload_2
    //   324: istore 5
    //   326: iload_2
    //   327: aload 8
    //   329: invokeinterface 166 1 0
    //   334: getstatic 330	com/tencent/mobileqq/app/msgcache/CacheConstants:f	I
    //   337: isub
    //   338: isub
    //   339: istore_2
    //   340: iload_2
    //   341: istore 5
    //   343: aload_0
    //   344: aload 7
    //   346: new 289	java/util/ArrayList
    //   349: dup
    //   350: aload 8
    //   352: aload 8
    //   354: invokeinterface 166 1 0
    //   359: getstatic 330	com/tencent/mobileqq/app/msgcache/CacheConstants:f	I
    //   362: isub
    //   363: aload 8
    //   365: invokeinterface 166 1 0
    //   370: invokeinterface 458 3 0
    //   375: invokespecial 295	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   378: invokespecial 393	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   381: pop
    //   382: iload_2
    //   383: istore 5
    //   385: aload_0
    //   386: aload 7
    //   388: getstatic 304	com/tencent/mobileqq/app/msgcache/CacheConstants:d	I
    //   391: invokevirtual 327	com/tencent/mobileqq/app/msgcache/MsgLruCache:changeCacheType	(Ljava/lang/Object;I)V
    //   394: iload_2
    //   395: istore 4
    //   397: aload 9
    //   399: invokeinterface 211 1 0
    //   404: iload_2
    //   405: istore 4
    //   407: goto +60 -> 467
    //   410: astore_1
    //   411: iload 5
    //   413: istore 4
    //   415: aload 9
    //   417: invokeinterface 211 1 0
    //   422: iload 5
    //   424: istore 4
    //   426: aload_1
    //   427: athrow
    //   428: aload_0
    //   429: monitorexit
    //   430: iload_2
    //   431: ireturn
    //   432: astore_1
    //   433: goto +24 -> 457
    //   436: astore_1
    //   437: getstatic 213	com/tencent/mobileqq/app/msgcache/MsgLruCache:TAG	Ljava/lang/String;
    //   440: iconst_1
    //   441: ldc_w 460
    //   444: aload_1
    //   445: invokestatic 464	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   448: iload 4
    //   450: istore 5
    //   452: aload_0
    //   453: monitorexit
    //   454: iload 5
    //   456: ireturn
    //   457: aload_0
    //   458: monitorexit
    //   459: goto +5 -> 464
    //   462: aload_1
    //   463: athrow
    //   464: goto -2 -> 462
    //   467: iload 4
    //   469: istore_2
    //   470: iload 4
    //   472: ifgt -397 -> 75
    //   475: iload 4
    //   477: istore 5
    //   479: goto -27 -> 452
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	482	0	this	MsgLruCache
    //   0	482	1	paramArrayList	ArrayList<String>
    //   0	482	2	paramInt	int
    //   0	482	3	paramBoolean	boolean
    //   3	473	4	i	int
    //   79	399	5	j	int
    //   32	181	6	localQQAppInterface	QQAppInterface
    //   102	285	7	str	String
    //   162	202	8	localList	List
    //   111	305	9	localObject	Object
    //   207	21	10	localMessageRecord	MessageRecord
    // Exception table:
    //   from	to	target	type
    //   326	340	410	finally
    //   343	382	410	finally
    //   385	394	410	finally
    //   5	9	432	finally
    //   12	19	432	finally
    //   22	34	432	finally
    //   46	53	432	finally
    //   59	67	432	finally
    //   70	75	432	finally
    //   81	90	432	finally
    //   93	104	432	finally
    //   107	113	432	finally
    //   116	136	432	finally
    //   142	150	432	finally
    //   156	164	432	finally
    //   172	182	432	finally
    //   188	209	432	finally
    //   212	239	432	finally
    //   249	256	432	finally
    //   259	269	432	finally
    //   278	313	432	finally
    //   316	323	432	finally
    //   397	404	432	finally
    //   415	422	432	finally
    //   426	428	432	finally
    //   437	448	432	finally
    //   5	9	436	java/lang/Exception
    //   12	19	436	java/lang/Exception
    //   22	34	436	java/lang/Exception
    //   46	53	436	java/lang/Exception
    //   59	67	436	java/lang/Exception
    //   70	75	436	java/lang/Exception
    //   81	90	436	java/lang/Exception
    //   93	104	436	java/lang/Exception
    //   107	113	436	java/lang/Exception
    //   116	136	436	java/lang/Exception
    //   142	150	436	java/lang/Exception
    //   156	164	436	java/lang/Exception
    //   172	182	436	java/lang/Exception
    //   188	209	436	java/lang/Exception
    //   212	239	436	java/lang/Exception
    //   249	256	436	java/lang/Exception
    //   259	269	436	java/lang/Exception
    //   278	313	436	java/lang/Exception
    //   316	323	436	java/lang/Exception
    //   397	404	436	java/lang/Exception
    //   415	422	436	java/lang/Exception
    //   426	428	436	java/lang/Exception
  }
  
  public void destroy()
  {
    this.isDestroyed = true;
    this.mHandler.removeMessages(1);
    QLog.d(TAG, 1, "destroy");
  }
  
  public List<MessageRecord> get(Object paramObject)
  {
    List localList = (List)super.get(paramObject);
    if (localList != null)
    {
      String str = (String)paramObject;
      paramObject = (Integer)this.opWeightDiffCache.get(paramObject);
      if (paramObject == null) {
        i = 0;
      } else {
        i = paramObject.intValue();
      }
      int i = Math.max(i, CacheConstants.l);
      this.opWeightDiffCache.put(str, Integer.valueOf(i));
    }
    return localList;
  }
  
  public int getCacheType(Object paramObject)
  {
    if (containsKey(paramObject))
    {
      paramObject = (String)paramObject;
      return ((MsgLruCache.MsgCacheInfo)this.cacheInfoMap.get(paramObject)).jdField_a_of_type_Int;
    }
    return CacheConstants.c;
  }
  
  public Pair<Integer, Integer> getCacheTypeInfo(int paramInt)
  {
    synchronized (this.cacheInfoMap)
    {
      Iterator localIterator = entrySet().iterator();
      int i = 0;
      int j = 0;
      while (localIterator.hasNext())
      {
        Object localObject2 = (Map.Entry)localIterator.next();
        if (((MsgLruCache.MsgCacheInfo)this.cacheInfoMap.get(((Map.Entry)localObject2).getKey())).jdField_a_of_type_Int == paramInt)
        {
          localObject2 = (List)((Map.Entry)localObject2).getValue();
          int k = i + 1;
          i = k;
          if (localObject2 != null)
          {
            j += ((List)localObject2).size();
            i = k;
          }
        }
      }
      return new Pair(Integer.valueOf(i), Integer.valueOf(j));
    }
    for (;;)
    {
      throw localObject1;
    }
  }
  
  public int getMsgCount()
  {
    Iterator localIterator = entrySet().iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      List localList = (List)((Map.Entry)localIterator.next()).getValue();
      if (localList != null) {
        i += localList.size();
      }
    }
    return i;
  }
  
  public List<MessageRecord> getOriginal(Object paramObject)
  {
    return (List)super.get(paramObject);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 1) {
      return false;
    }
    QLog.d(TAG, 1, "BEFORE_SCAN");
    printMsgLruCache();
    c();
    b();
    boolean bool = a();
    QLog.d(TAG, 1, new Object[] { "AFTER_SCAN, isChanged: ", Boolean.valueOf(bool) });
    if (bool) {
      printMsgLruCache();
    }
    if (!this.isDestroyed) {
      this.mHandler.sendEmptyMessageDelayed(1, 300000L);
    }
    return false;
  }
  
  protected WeakReference<QQAppInterface> makeApp()
  {
    d();
    return null;
  }
  
  public void printMsgLruCache()
  {
    if (QLog.isColorLevel()) {
      try
      {
        a();
        return;
      }
      catch (Throwable localThrowable)
      {
        QLog.d(TAG, 2, localThrowable, new Object[0]);
      }
    }
  }
  
  public List<MessageRecord> put(String paramString, int paramInt, List<MessageRecord> paramList)
  {
    String str = UinTypeUtil.a(paramString, paramInt);
    if (!containsKey(str))
    {
      paramString = new MsgLruCache.MsgCacheInfo(this, paramString, paramInt, CacheConstants.c, CacheConstants.i);
      this.cacheInfoMap.put(str, paramString);
      a();
      paramInt = size();
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, new Object[] { "put, key: ", str, " cacheSize:", Integer.valueOf(paramInt + 1), " msgCount:", Integer.valueOf(getMsgCount()) });
      }
    }
    return (List)super.put(str, paramList);
  }
  
  public List<MessageRecord> put(String paramString, List<MessageRecord> paramList)
  {
    if (!containsKey(paramString))
    {
      MsgLruCache.MsgCacheInfo localMsgCacheInfo = new MsgLruCache.MsgCacheInfo(this, CacheConstants.a(paramString), CacheConstants.a(paramString), CacheConstants.c, CacheConstants.i);
      this.cacheInfoMap.put(paramString, localMsgCacheInfo);
      int i = size();
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, new Object[] { "put, key: ", paramString, " size:", Integer.valueOf(i + 1) });
      }
    }
    return (List)super.put(paramString, paramList);
  }
  
  public List<MessageRecord> remove(Object paramObject)
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
    Object localObject2 = this.detector.getHighFrequencyString();
    this.detector.clear();
    d();
    Object localObject1 = this.mApp;
    if ((localObject1 != null) && (((WeakReference)localObject1).get() != null))
    {
      localObject1 = new HashMap();
      ((HashMap)localObject1).put("count", String.valueOf(this.monitorLoginInitCount));
      boolean bool;
      if ((localObject2 != null) && (!((Map)localObject2).isEmpty())) {
        bool = true;
      } else {
        bool = false;
      }
      ((HashMap)localObject1).put("hasErStack", String.valueOf(bool));
      ((HashMap)localObject1).put("cacheType", String.valueOf(cacheConfig));
      if ((localObject2 != null) && (!((Map)localObject2).isEmpty()))
      {
        localObject2 = new ArrayList(((Map)localObject2).entrySet());
        Collections.sort((List)localObject2, new MsgLruCache.1(this));
        int j = 0;
        int i;
        for (int k = 0; j < ((ArrayList)localObject2).size(); k = i)
        {
          i = k;
          if (!((String)((Map.Entry)((ArrayList)localObject2).get(j)).getKey()).contains("InitBeforeSyncMsg.doStep")) {
            if (((String)((Map.Entry)((ArrayList)localObject2).get(j)).getKey()).contains("MsgProxyContainer.init_lazy"))
            {
              i = k;
            }
            else
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("count_");
              localStringBuilder.append(k);
              ((HashMap)localObject1).put(localStringBuilder.toString(), String.valueOf(((Map.Entry)((ArrayList)localObject2).get(j)).getValue()));
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("stack_");
              localStringBuilder.append(k);
              ((HashMap)localObject1).put(localStringBuilder.toString(), String.valueOf(((Map.Entry)((ArrayList)localObject2).get(j)).getKey()));
              k += 1;
              i = k;
              if (k > 3) {
                break;
              }
            }
          }
          j += 1;
        }
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, new Object[] { "reportCacheLoad, ", localObject1 });
        }
      }
      StatisticCollector.getInstance(((QQAppInterface)this.mApp.get()).getApp()).collectPerformance(null, CacheConstants.e, true, -1L, 0L, (HashMap)localObject1, null, false);
    }
  }
  
  public void setApp(QQAppInterface paramQQAppInterface)
  {
    this.mApp = new WeakReference(paramQQAppInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.msgcache.MsgLruCache
 * JD-Core Version:    0.7.0.1
 */