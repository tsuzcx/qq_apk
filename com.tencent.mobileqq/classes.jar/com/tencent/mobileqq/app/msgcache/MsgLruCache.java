package com.tencent.mobileqq.app.msgcache;

import abta;
import abtf;
import abti;
import amms;
import ammt;
import ammu;
import ammv;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import azri;
import aztb;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.data.MessageRecord;
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
import mqq.util.WeakReference;

public class MsgLruCache
  extends ConcurrentHashMap<String, List<MessageRecord>>
  implements Handler.Callback
{
  public static String TAG = "MsgLruCacheLog";
  public static int cacheConfig;
  private ConcurrentHashMap<String, ammv> cacheInfoMap = new ConcurrentHashMap();
  private aztb detector = new aztb(amms.n, amms.o);
  private long initTime;
  public volatile boolean isDestroyed;
  private ammu keyTimeComparator = new ammu(this, null);
  private WeakReference<QQAppInterface> mApp;
  private Handler mHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
  private abtf mMsgPool;
  private int monitorLoginInitCount;
  private ConcurrentHashMap<String, Integer> opWeightDiffCache = new ConcurrentHashMap();
  private boolean reportInitCache;
  
  public MsgLruCache(abtf paramabtf)
  {
    this.mMsgPool = paramabtf;
    this.initTime = System.currentTimeMillis();
    this.mHandler.sendEmptyMessageDelayed(1, 300000L);
  }
  
  private int a(Map.Entry paramEntry)
  {
    return ((ammv)this.cacheInfoMap.get(paramEntry.getKey())).jdField_a_of_type_Int;
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
        localObject2 = (ammv)this.cacheInfoMap.get(((Map.Entry)localObject2).getKey());
        c();
        if ((this.mApp != null) && (this.mApp.get() != null) && (((QQAppInterface)this.mApp.get()).a().a(((ammv)localObject2).jdField_a_of_type_JavaLangString, ((ammv)localObject2).c) > 0))
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d(TAG, 2, new Object[] { "handleRegularScan, conv has unread msg, uin:", ((ammv)localObject2).jdField_a_of_type_JavaLangString, " type:", Integer.valueOf(((ammv)localObject2).c) });
        }
      }
      ((ammv)localObject2).b += amms.j;
      a((ammv)localObject2);
    }
  }
  
  private void a(ammv paramammv)
  {
    if (paramammv.b > amms.g) {
      paramammv.b = amms.g;
    }
    while (paramammv.b >= amms.h) {
      return;
    }
    paramammv.b = amms.h;
  }
  
  private boolean a()
  {
    int i = getMsgCount();
    if (i <= amms.jdField_a_of_type_Int) {
      return false;
    }
    ayzl.a = true;
    Map.Entry localEntry;
    List localList;
    synchronized (this.cacheInfoMap)
    {
      QLog.d(TAG, 1, new Object[] { "eliminateCache, MsgCount: ", Integer.valueOf(i) });
      i -= amms.b;
      c();
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
        if ((a(localEntry) == amms.d) && (b(localEntry) == amms.h) && (localList != null) && (localList.size() > 0)) {
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
      if ((a(localEntry) == amms.c) && (b(localEntry) == amms.h))
      {
        ammv localammv = (ammv)this.cacheInfoMap.get(localEntry.getKey());
        if ((localammv.c == 0) && (abti.a(localammv.jdField_a_of_type_JavaLangString))) {
          changeCacheType(localEntry.getKey(), amms.d);
        } else if ((localList != null) && (localList.size() > amms.f)) {
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
    return ((ammv)this.cacheInfoMap.get(paramEntry.getKey())).b;
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
        localObject2 = (ammv)this.cacheInfoMap.get(localObject2);
        if (localObject2 != null)
        {
          int i = ((ammv)localObject2).b;
          ((ammv)localObject2).b = (((Integer)localEntry.getValue()).intValue() + i);
          a((ammv)localObject2);
        }
      }
    }
    this.opWeightDiffCache.clear();
  }
  
  private void c()
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
      localObject = (ammv)this.cacheInfoMap.get(localObject);
      if (((ammv)localObject).jdField_a_of_type_Int != paramInt)
      {
        ((ammv)localObject).jdField_a_of_type_Int = paramInt;
        ((ammv)localObject).b = amms.i;
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
    //   2: aload_0
    //   3: invokespecial 137	com/tencent/mobileqq/app/msgcache/MsgLruCache:c	()V
    //   6: iload_2
    //   7: istore 4
    //   9: aload_0
    //   10: getfield 139	com/tencent/mobileqq/app/msgcache/MsgLruCache:mApp	Lmqq/util/WeakReference;
    //   13: ifnull +44 -> 57
    //   16: aload_0
    //   17: getfield 139	com/tencent/mobileqq/app/msgcache/MsgLruCache:mApp	Lmqq/util/WeakReference;
    //   20: invokevirtual 143	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   23: checkcast 145	com/tencent/mobileqq/app/QQAppInterface
    //   26: astore 7
    //   28: iload_2
    //   29: istore 4
    //   31: aload 7
    //   33: ifnull +24 -> 57
    //   36: iload_2
    //   37: istore 4
    //   39: aload_1
    //   40: ifnull +17 -> 57
    //   43: aload_1
    //   44: invokevirtual 329	java/util/ArrayList:isEmpty	()Z
    //   47: istore 6
    //   49: iload 6
    //   51: ifeq +11 -> 62
    //   54: iload_2
    //   55: istore 4
    //   57: aload_0
    //   58: monitorexit
    //   59: iload 4
    //   61: ireturn
    //   62: aload_1
    //   63: aload_0
    //   64: getfield 83	com/tencent/mobileqq/app/msgcache/MsgLruCache:keyTimeComparator	Lammu;
    //   67: invokestatic 335	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   70: aload_1
    //   71: invokevirtual 336	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   74: astore_1
    //   75: iload_2
    //   76: istore 4
    //   78: aload_1
    //   79: invokeinterface 131 1 0
    //   84: ifeq +353 -> 437
    //   87: iload_2
    //   88: istore 4
    //   90: aload_1
    //   91: invokeinterface 134 1 0
    //   96: checkcast 267	java/lang/String
    //   99: astore 8
    //   101: iload_2
    //   102: istore 4
    //   104: aload_0
    //   105: getfield 85	com/tencent/mobileqq/app/msgcache/MsgLruCache:mMsgPool	Labtf;
    //   108: astore 10
    //   110: iload_2
    //   111: istore 4
    //   113: aload 10
    //   115: invokevirtual 341	abtf:a	()Ljava/util/Map;
    //   118: invokeinterface 344 1 0
    //   123: aload 8
    //   125: invokeinterface 347 2 0
    //   130: ifne -55 -> 75
    //   133: iload_2
    //   134: istore 4
    //   136: aload 8
    //   138: invokestatic 349	abti:b	(Ljava/lang/String;)Z
    //   141: ifne -66 -> 75
    //   144: iload_2
    //   145: istore 4
    //   147: aload_0
    //   148: aload 8
    //   150: invokevirtual 353	com/tencent/mobileqq/app/msgcache/MsgLruCache:getOriginal	(Ljava/lang/Object;)Ljava/util/List;
    //   153: astore 9
    //   155: aload 9
    //   157: ifnull -82 -> 75
    //   160: iload_2
    //   161: istore 4
    //   163: aload 9
    //   165: invokeinterface 354 1 0
    //   170: ifne -95 -> 75
    //   173: iload_2
    //   174: istore 4
    //   176: aload 9
    //   178: aload 9
    //   180: invokeinterface 244 1 0
    //   185: iconst_1
    //   186: isub
    //   187: invokeinterface 357 2 0
    //   192: checkcast 359	com/tencent/mobileqq/data/MessageRecord
    //   195: astore 11
    //   197: iload_2
    //   198: istore 4
    //   200: aload 7
    //   202: aload 11
    //   204: getfield 362	com/tencent/mobileqq/data/MessageRecord:istroop	I
    //   207: invokevirtual 365	com/tencent/mobileqq/app/QQAppInterface:a	(I)Labtg;
    //   210: aload 11
    //   212: getfield 368	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   215: aload 11
    //   217: getfield 362	com/tencent/mobileqq/data/MessageRecord:istroop	I
    //   220: iconst_1
    //   221: invokevirtual 373	abtg:a	(Ljava/lang/String;IZ)Z
    //   224: ifne -149 -> 75
    //   227: iload_3
    //   228: ifeq +29 -> 257
    //   231: iload_2
    //   232: istore 4
    //   234: aload_0
    //   235: aload 8
    //   237: invokevirtual 375	com/tencent/mobileqq/app/msgcache/MsgLruCache:remove	(Ljava/lang/Object;)Ljava/util/List;
    //   240: pop
    //   241: iload_2
    //   242: istore 4
    //   244: iload_2
    //   245: aload 9
    //   247: invokeinterface 244 1 0
    //   252: isub
    //   253: istore_2
    //   254: goto +186 -> 440
    //   257: iload_2
    //   258: istore 4
    //   260: aload 10
    //   262: aload 9
    //   264: iconst_0
    //   265: invokeinterface 357 2 0
    //   270: checkcast 359	com/tencent/mobileqq/data/MessageRecord
    //   273: getfield 368	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   276: aload 9
    //   278: iconst_0
    //   279: invokeinterface 357 2 0
    //   284: checkcast 359	com/tencent/mobileqq/data/MessageRecord
    //   287: getfield 362	com/tencent/mobileqq/data/MessageRecord:istroop	I
    //   290: invokevirtual 378	abtf:a	(Ljava/lang/String;I)Ljava/util/concurrent/locks/Lock;
    //   293: astore 10
    //   295: iload_2
    //   296: istore 4
    //   298: aload 10
    //   300: invokeinterface 383 1 0
    //   305: iload_2
    //   306: istore 5
    //   308: iload_2
    //   309: aload 9
    //   311: invokeinterface 244 1 0
    //   316: getstatic 264	amms:f	I
    //   319: isub
    //   320: isub
    //   321: istore_2
    //   322: iload_2
    //   323: istore 5
    //   325: aload_0
    //   326: aload 8
    //   328: new 219	java/util/ArrayList
    //   331: dup
    //   332: aload 9
    //   334: aload 9
    //   336: invokeinterface 244 1 0
    //   341: getstatic 264	amms:f	I
    //   344: isub
    //   345: aload 9
    //   347: invokeinterface 244 1 0
    //   352: invokeinterface 387 3 0
    //   357: invokespecial 225	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   360: invokespecial 311	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   363: pop
    //   364: iload_2
    //   365: istore 5
    //   367: aload_0
    //   368: aload 8
    //   370: getstatic 239	amms:d	I
    //   373: invokevirtual 261	com/tencent/mobileqq/app/msgcache/MsgLruCache:changeCacheType	(Ljava/lang/Object;I)V
    //   376: iload_2
    //   377: istore 4
    //   379: aload 10
    //   381: invokeinterface 390 1 0
    //   386: goto +54 -> 440
    //   389: astore_1
    //   390: iload 5
    //   392: istore 4
    //   394: aload 10
    //   396: invokeinterface 390 1 0
    //   401: iload 5
    //   403: istore 4
    //   405: aload_1
    //   406: athrow
    //   407: astore_1
    //   408: iload 4
    //   410: istore_2
    //   411: getstatic 39	com/tencent/mobileqq/app/msgcache/MsgLruCache:TAG	Ljava/lang/String;
    //   414: iconst_1
    //   415: ldc_w 392
    //   418: aload_1
    //   419: invokestatic 396	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   422: goto +22 -> 444
    //   425: astore_1
    //   426: aload_0
    //   427: monitorexit
    //   428: aload_1
    //   429: athrow
    //   430: goto -355 -> 75
    //   433: astore_1
    //   434: goto -23 -> 411
    //   437: goto +7 -> 444
    //   440: iload_2
    //   441: ifgt -11 -> 430
    //   444: iload_2
    //   445: istore 4
    //   447: goto -390 -> 57
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	450	0	this	MsgLruCache
    //   0	450	1	paramArrayList	ArrayList<String>
    //   0	450	2	paramInt	int
    //   0	450	3	paramBoolean	boolean
    //   7	439	4	i	int
    //   306	96	5	j	int
    //   47	3	6	bool	boolean
    //   26	175	7	localQQAppInterface	QQAppInterface
    //   99	270	8	str	String
    //   153	193	9	localList	List
    //   108	287	10	localObject	Object
    //   195	21	11	localMessageRecord	MessageRecord
    // Exception table:
    //   from	to	target	type
    //   308	322	389	finally
    //   325	364	389	finally
    //   367	376	389	finally
    //   78	87	407	java/lang/Exception
    //   90	101	407	java/lang/Exception
    //   104	110	407	java/lang/Exception
    //   113	133	407	java/lang/Exception
    //   136	144	407	java/lang/Exception
    //   147	155	407	java/lang/Exception
    //   163	173	407	java/lang/Exception
    //   176	197	407	java/lang/Exception
    //   200	227	407	java/lang/Exception
    //   234	241	407	java/lang/Exception
    //   244	254	407	java/lang/Exception
    //   260	295	407	java/lang/Exception
    //   298	305	407	java/lang/Exception
    //   379	386	407	java/lang/Exception
    //   394	401	407	java/lang/Exception
    //   405	407	407	java/lang/Exception
    //   2	6	425	finally
    //   9	28	425	finally
    //   43	49	425	finally
    //   62	75	425	finally
    //   78	87	425	finally
    //   90	101	425	finally
    //   104	110	425	finally
    //   113	133	425	finally
    //   136	144	425	finally
    //   147	155	425	finally
    //   163	173	425	finally
    //   176	197	425	finally
    //   200	227	425	finally
    //   234	241	425	finally
    //   244	254	425	finally
    //   260	295	425	finally
    //   298	305	425	finally
    //   379	386	425	finally
    //   394	401	425	finally
    //   405	407	425	finally
    //   411	422	425	finally
    //   2	6	433	java/lang/Exception
    //   9	28	433	java/lang/Exception
    //   43	49	433	java/lang/Exception
    //   62	75	433	java/lang/Exception
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
      i = Math.max(i, amms.l);
      this.opWeightDiffCache.put(str, Integer.valueOf(i));
      return localList;
    }
  }
  
  public int getCacheType(Object paramObject)
  {
    if (containsKey(paramObject))
    {
      paramObject = (String)paramObject;
      return ((ammv)this.cacheInfoMap.get(paramObject)).jdField_a_of_type_Int;
    }
    return amms.c;
  }
  
  public Pair<Integer, Integer> getCacheTypeInfo(int paramInt)
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
          if (((ammv)this.cacheInfoMap.get(((Map.Entry)localObject2).getKey())).jdField_a_of_type_Int != paramInt) {
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
  
  public List<MessageRecord> getOriginal(Object paramObject)
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
    } while (this.isDestroyed);
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
  
  public List<MessageRecord> put(String paramString, int paramInt, List<MessageRecord> paramList)
  {
    String str = abti.a(paramString, paramInt);
    if (!containsKey(str))
    {
      paramString = new ammv(this, paramString, paramInt, amms.c, amms.i);
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
      ammv localammv = new ammv(this, amms.a(paramString), amms.a(paramString), amms.c, amms.i);
      this.cacheInfoMap.put(paramString, localammv);
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
    Object localObject = this.detector.a();
    this.detector.a();
    c();
    if ((this.mApp != null) && (this.mApp.get() != null))
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("count", String.valueOf(this.monitorLoginInitCount));
      boolean bool;
      int j;
      int k;
      label157:
      int i;
      if ((localObject != null) && (!((Map)localObject).isEmpty()))
      {
        bool = true;
        localHashMap.put("hasErStack", String.valueOf(bool));
        localHashMap.put("cacheType", String.valueOf(cacheConfig));
        if ((localObject == null) || (((Map)localObject).isEmpty())) {
          break label362;
        }
        localObject = new ArrayList(((Map)localObject).entrySet());
        Collections.sort((List)localObject, new ammt(this));
        j = 0;
        k = 0;
        if (j >= ((ArrayList)localObject).size()) {
          break label334;
        }
        i = k;
        if (!((String)((Map.Entry)((ArrayList)localObject).get(j)).getKey()).contains("InitBeforeSyncMsg.doStep"))
        {
          if (!((String)((Map.Entry)((ArrayList)localObject).get(j)).getKey()).contains("MsgProxyContainer.init_lazy")) {
            break label237;
          }
          i = k;
        }
      }
      label237:
      do
      {
        j += 1;
        k = i;
        break label157;
        bool = false;
        break;
        localHashMap.put("count_" + k, String.valueOf(((Map.Entry)((ArrayList)localObject).get(j)).getValue()));
        localHashMap.put("stack_" + k, String.valueOf(((Map.Entry)((ArrayList)localObject).get(j)).getKey()));
        k += 1;
        i = k;
      } while (k <= 3);
      label334:
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, new Object[] { "reportCacheLoad, ", localHashMap });
      }
      label362:
      azri.a(((QQAppInterface)this.mApp.get()).getApp()).a(null, amms.e, true, -1L, 0L, localHashMap, null, false);
    }
  }
  
  public void setApp(QQAppInterface paramQQAppInterface)
  {
    this.mApp = new WeakReference(paramQQAppInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.msgcache.MsgLruCache
 * JD-Core Version:    0.7.0.1
 */