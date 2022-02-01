package com.tencent.imcore.message;

import android.content.ContentValues;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.commonsdk.util.LargerInteger;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.app.proxy.BaseProxyManager;
import com.tencent.mobileqq.app.proxy.MsgQueueItem;
import com.tencent.mobileqq.app.proxy.ProxyListener;
import com.tencent.mobileqq.data.ChatHistorySearchData;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.qroute.annotation.Metadata;
import com.tencent.mobileqq.service.message.remote.MessageRecordInfo;
import com.tencent.mobileqq.utils.MessageDBUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import mqq.app.AppRuntime;

public class MsgProxy
  extends BaseMsgProxy
{
  public static BaseMsgProxy.Callback a;
  protected EntityManager a;
  private Object a;
  
  static
  {
    jdField_a_of_type_ComTencentImcoreMessageBaseMsgProxy$Callback = new MsgProxyDummyCallback();
    InitMsgModule.a();
  }
  
  @Metadata
  public MsgProxy(AppRuntime paramAppRuntime, BaseProxyManager paramBaseProxyManager, MsgPool paramMsgPool)
  {
    super(paramAppRuntime, paramBaseProxyManager, paramMsgPool);
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = null;
    this.jdField_a_of_type_JavaLangObject = new Object();
  }
  
  private int a(int paramInt1, Message paramMessage, String paramString, int paramInt2, int paramInt3)
  {
    Object localObject = h(paramString, paramInt2);
    if ((localObject == null) || (((List)localObject).isEmpty())) {
      return paramInt3;
    }
    localObject = ((List)localObject).iterator();
    MessageRecord localMessageRecord;
    while (((Iterator)localObject).hasNext())
    {
      localMessageRecord = (MessageRecord)((Iterator)localObject).next();
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MsgProxy", 2, "setRecommendMsgReaded " + localMessageRecord.getBaseInfoString());
      }
      if ((localMessageRecord.msgtype == paramInt1) && (!localMessageRecord.isread))
      {
        paramInt3 += 1;
        localMessageRecord.isread = true;
      }
    }
    localObject = e(paramString, paramInt2);
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        localMessageRecord = (MessageRecord)((Iterator)localObject).next();
        if ((localMessageRecord.msgtype == paramInt1) && (!localMessageRecord.isread)) {
          localMessageRecord.isread = true;
        }
      }
    }
    localObject = new ContentValues();
    ((ContentValues)localObject).put("isread", Boolean.valueOf(true));
    a(paramString, paramInt2, paramMessage.versionCode, (ContentValues)localObject, "msgtype=? and isread=?", new String[] { String.valueOf(paramInt1), "0" }, null);
    return paramInt3;
  }
  
  private int a(int paramInt, MessageRecord paramMessageRecord)
  {
    int i = paramInt;
    if (paramMessageRecord.versionCode < paramInt) {
      i = paramMessageRecord.versionCode;
    }
    return i;
  }
  
  private long a(int paramInt, List<MessageRecord> paramList, long paramLong)
  {
    long l = paramLong;
    if (UinTypeUtil.g(paramInt))
    {
      paramList = paramList.iterator();
      for (;;)
      {
        l = paramLong;
        if (!paramList.hasNext()) {
          break;
        }
        MessageRecord localMessageRecord = (MessageRecord)paramList.next();
        if (localMessageRecord.shmsgseq < paramLong) {
          paramLong = localMessageRecord.shmsgseq;
        }
      }
    }
    return l;
  }
  
  private long a(long paramLong, MessageRecord paramMessageRecord)
  {
    long l = paramLong;
    if (paramMessageRecord.time < paramLong) {
      l = paramMessageRecord.time;
    }
    return l;
  }
  
  private Pair<Long, Long> a(String paramString)
  {
    return jdField_a_of_type_ComTencentImcoreMessageBaseMsgProxy$Callback.a(paramString, this.app);
  }
  
  private Message a(String paramString, EntityManager paramEntityManager, int paramInt1, int paramInt2)
  {
    if (a(paramString, true)) {
      this.proxyManager.transSaveToDatabase(paramEntityManager);
    }
    int i;
    String str;
    if ((paramString.startsWith("mr_discusssion")) || (paramString.startsWith("mr_troop")))
    {
      i = 1;
      boolean bool = paramString.endsWith("_New");
      str = "select * from (select count() as unReadNum from %s mr where mr.isread=0),(select count() as hasReply from %s mr where mr.issend=0),%s m where m.isValid=1 and m.msgtype " + UinTypeUtil.b() + " and m.longMsgId='%d' and m.issend='%d' order by %s limit 1";
      if (!bool) {
        break label177;
      }
      if (i == 0) {
        break label171;
      }
      paramEntityManager = "longMsgIndex asc , shmsgseq desc , _id desc";
    }
    for (;;)
    {
      paramString = String.format(str, new Object[] { paramString, paramString, paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramEntityManager });
      paramString = a().rawQuery(Message.class, paramString, null);
      if ((paramString == null) || (paramString.isEmpty())) {
        break label183;
      }
      return (Message)paramString.get(0);
      i = 0;
      break;
      label171:
      paramEntityManager = "longMsgIndex asc , time desc , _id desc";
      continue;
      label177:
      paramEntityManager = "_id desc";
    }
    label183:
    return null;
  }
  
  private MessageRecord a(MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2, boolean paramBoolean)
  {
    if (paramMessageRecord1 == null) {}
    do
    {
      do
      {
        do
        {
          return paramMessageRecord2;
          if (!UinTypeUtil.a(paramMessageRecord1, paramMessageRecord2)) {
            break;
          }
        } while (paramMessageRecord1.longMsgIndex > paramMessageRecord2.longMsgIndex);
        return paramMessageRecord1;
        if (!paramBoolean) {
          break;
        }
      } while (paramMessageRecord2.shmsgseq > paramMessageRecord1.shmsgseq);
      return paramMessageRecord1;
    } while (paramMessageRecord2.time > paramMessageRecord1.time);
    return paramMessageRecord1;
  }
  
  private List<MessageRecord> a(String paramString1, int paramInt, String paramString2)
  {
    List localList2 = a(paramString2);
    List localList1 = localList2;
    if (localList2 == null)
    {
      long l = System.nanoTime();
      localList1 = f(paramString1, paramInt);
      c(paramString1, paramInt, localList1);
      jdField_a_of_type_ComTencentImcoreMessageBaseMsgProxy$Callback.a(paramString1, paramInt, paramString2, localList1, l, this);
    }
    return localList1;
  }
  
  private List<MessageRecord> a(String paramString, int paramInt, List<MessageRecord> paramList1, List<MessageRecord> paramList2)
  {
    if (paramList1.size() > 15)
    {
      paramList2.addAll(paramList1.subList(paramList1.size() - 15, paramList1.size()));
      if ((!UinTypeUtil.a(paramString, paramInt, paramList2)) && (!UinTypeUtil.a(paramList2))) {
        break label201;
      }
      paramInt = 1;
      label60:
      if ((paramList1.size() > 15) && (paramInt != 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MsgProxy", 2, "getAIOMsgList : pull more long msg");
        }
        paramList2.clear();
        if (paramList1.size() <= 30) {
          break label206;
        }
        paramList2.addAll(paramList1.subList(paramList1.size() - 30, paramList1.size()));
      }
    }
    for (;;)
    {
      paramList1 = a(paramString);
      paramString = paramList2;
      if (paramList1 != null)
      {
        paramList1 = a(paramList2, ((Long)paramList1.first).longValue());
        paramString = paramList2;
        if (paramList1 != null)
        {
          paramString = paramList2;
          if (!paramList1.isEmpty()) {
            paramString = paramList1;
          }
        }
      }
      return paramString;
      paramList2.addAll(paramList1);
      break;
      label201:
      paramInt = 0;
      break label60;
      label206:
      paramList2.addAll(paramList1);
    }
  }
  
  @Nullable
  private List<MessageRecord> a(String paramString, int paramInt, boolean paramBoolean)
  {
    List localList = b(a(paramString, paramInt));
    if ((localList == null) || (localList.isEmpty()))
    {
      if (b(paramString, paramInt, paramBoolean)) {
        return null;
      }
    }
    else if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "getAIOMsgList from aioPool size = " + localList.size());
    }
    return b(a(paramString, paramInt));
  }
  
  public static List<MessageRecord> a(List<MessageRecord> paramList, long paramLong)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      MessageRecord localMessageRecord = (MessageRecord)paramList.get(i);
      if (localMessageRecord.time >= paramLong) {
        localArrayList.add(localMessageRecord);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public static void a(BaseMsgProxy.Callback paramCallback)
  {
    jdField_a_of_type_ComTencentImcoreMessageBaseMsgProxy$Callback = paramCallback;
  }
  
  /* Error */
  private void a(EntityTransaction paramEntityTransaction, SQLiteDatabase paramSQLiteDatabase, String[] paramArrayOfString, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 10
    //   3: aload_3
    //   4: iload 4
    //   6: aaload
    //   7: astore 12
    //   9: aload 12
    //   11: ldc_w 320
    //   14: invokevirtual 179	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   17: ifeq +363 -> 380
    //   20: new 69	java/lang/StringBuilder
    //   23: dup
    //   24: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   27: ldc_w 322
    //   30: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: aload 12
    //   35: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: ldc_w 324
    //   41: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: aload 12
    //   46: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: ldc_w 326
    //   52: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   58: astore_3
    //   59: aload_3
    //   60: ifnonnull +4 -> 64
    //   63: return
    //   64: invokestatic 65	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   67: ifeq +30 -> 97
    //   70: ldc_w 328
    //   73: iconst_2
    //   74: new 69	java/lang/StringBuilder
    //   77: dup
    //   78: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   81: ldc_w 330
    //   84: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: aload_3
    //   88: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   94: invokestatic 87	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   97: aload_2
    //   98: aload_3
    //   99: aconst_null
    //   100: invokevirtual 335	com/tencent/mobileqq/app/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   103: astore_3
    //   104: aload_3
    //   105: ifnull +135 -> 240
    //   108: aload_3
    //   109: invokeinterface 340 1 0
    //   114: ifle +126 -> 240
    //   117: aload_3
    //   118: invokeinterface 343 1 0
    //   123: pop
    //   124: aload_3
    //   125: aload_3
    //   126: ldc_w 345
    //   129: invokeinterface 349 2 0
    //   134: invokeinterface 353 2 0
    //   139: lstore 8
    //   141: aload_3
    //   142: aload_3
    //   143: ldc_w 355
    //   146: invokeinterface 349 2 0
    //   151: invokeinterface 358 2 0
    //   156: astore 10
    //   158: aload_3
    //   159: aload_3
    //   160: ldc_w 360
    //   163: invokeinterface 349 2 0
    //   168: invokeinterface 364 2 0
    //   173: istore 4
    //   175: aload_3
    //   176: aload_3
    //   177: ldc_w 366
    //   180: invokeinterface 349 2 0
    //   185: invokeinterface 364 2 0
    //   190: istore 5
    //   192: lload 8
    //   194: lstore 6
    //   196: iload 4
    //   198: invokestatic 138	com/tencent/imcore/message/UinTypeUtil:g	(I)Z
    //   201: ifne +21 -> 222
    //   204: lload 8
    //   206: lstore 6
    //   208: iload 5
    //   210: iconst_1
    //   211: if_icmpne +11 -> 222
    //   214: lload 8
    //   216: ldc2_w 367
    //   219: ladd
    //   220: lstore 6
    //   222: getstatic 17	com/tencent/imcore/message/MsgProxy:jdField_a_of_type_ComTencentImcoreMessageBaseMsgProxy$Callback	Lcom/tencent/imcore/message/BaseMsgProxy$Callback;
    //   225: aload 10
    //   227: iload 4
    //   229: lload 6
    //   231: aload_0
    //   232: getfield 153	com/tencent/imcore/message/MsgProxy:app	Lmqq/app/AppRuntime;
    //   235: invokeinterface 371 6 0
    //   240: aload_3
    //   241: ifnull +9 -> 250
    //   244: aload_3
    //   245: invokeinterface 374 1 0
    //   250: aload_1
    //   251: ifnull +7 -> 258
    //   254: aload_1
    //   255: invokevirtual 379	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   258: aload_2
    //   259: aload 12
    //   261: aconst_null
    //   262: aconst_null
    //   263: invokevirtual 383	com/tencent/mobileqq/app/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   266: pop
    //   267: aload_1
    //   268: ifnull +7 -> 275
    //   271: aload_1
    //   272: invokevirtual 386	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   275: aload_1
    //   276: ifnull -213 -> 63
    //   279: aload_1
    //   280: invokevirtual 389	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   283: return
    //   284: astore 11
    //   286: aload 10
    //   288: astore_3
    //   289: aload 11
    //   291: astore 10
    //   293: aload 10
    //   295: invokevirtual 392	java/lang/Exception:printStackTrace	()V
    //   298: aload_3
    //   299: ifnull -49 -> 250
    //   302: aload_3
    //   303: invokeinterface 374 1 0
    //   308: goto -58 -> 250
    //   311: astore_1
    //   312: aconst_null
    //   313: astore_3
    //   314: aload_3
    //   315: ifnull +9 -> 324
    //   318: aload_3
    //   319: invokeinterface 374 1 0
    //   324: aload_1
    //   325: athrow
    //   326: astore_2
    //   327: aload_2
    //   328: invokevirtual 392	java/lang/Exception:printStackTrace	()V
    //   331: invokestatic 65	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   334: ifeq +13 -> 347
    //   337: ldc 67
    //   339: iconst_2
    //   340: ldc_w 394
    //   343: aload_2
    //   344: invokestatic 397	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   347: aload_1
    //   348: ifnull -285 -> 63
    //   351: aload_1
    //   352: invokevirtual 389	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   355: return
    //   356: astore_2
    //   357: aload_1
    //   358: ifnull +7 -> 365
    //   361: aload_1
    //   362: invokevirtual 389	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   365: aload_2
    //   366: athrow
    //   367: astore_1
    //   368: goto -54 -> 314
    //   371: astore_1
    //   372: goto -58 -> 314
    //   375: astore 10
    //   377: goto -84 -> 293
    //   380: aconst_null
    //   381: astore_3
    //   382: goto -323 -> 59
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	385	0	this	MsgProxy
    //   0	385	1	paramEntityTransaction	EntityTransaction
    //   0	385	2	paramSQLiteDatabase	SQLiteDatabase
    //   0	385	3	paramArrayOfString	String[]
    //   0	385	4	paramInt	int
    //   190	22	5	i	int
    //   194	36	6	l1	long
    //   139	76	8	l2	long
    //   1	293	10	localObject	Object
    //   375	1	10	localException1	Exception
    //   284	6	11	localException2	Exception
    //   7	253	12	str	String
    // Exception table:
    //   from	to	target	type
    //   97	104	284	java/lang/Exception
    //   97	104	311	finally
    //   254	258	326	java/lang/Exception
    //   258	267	326	java/lang/Exception
    //   271	275	326	java/lang/Exception
    //   254	258	356	finally
    //   258	267	356	finally
    //   271	275	356	finally
    //   327	347	356	finally
    //   108	192	367	finally
    //   196	204	367	finally
    //   222	240	367	finally
    //   293	298	371	finally
    //   108	192	375	java/lang/Exception
    //   196	204	375	java/lang/Exception
    //   222	240	375	java/lang/Exception
  }
  
  private void a(String paramString, int paramInt1, int paramInt2)
  {
    Lock localLock = a(paramString, paramInt1);
    localLock.lock();
    try
    {
      b(paramString, paramInt1, paramInt2);
      return;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  private void a(String paramString1, MessageRecord paramMessageRecord, boolean paramBoolean, String paramString2)
  {
    if ((a().containsKey(paramString2)) && (paramBoolean))
    {
      List localList = b(paramString2);
      paramString2 = localList;
      if (localList == null) {
        paramString2 = new ArrayList();
      }
      jdField_a_of_type_ComTencentImcoreMessageBaseMsgProxy$Callback.a(paramString1, paramMessageRecord, paramString2, this);
    }
  }
  
  private void a(List<MessageRecord> paramList, long paramLong)
  {
    if (paramList == null) {}
    MessageRecord localMessageRecord;
    label51:
    do
    {
      return;
      for (;;)
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          localMessageRecord = (MessageRecord)paramList.next();
          if (localMessageRecord.time != paramLong) {
            break label51;
          }
          paramList.remove();
        }
      }
    } while (localMessageRecord.time <= paramLong);
  }
  
  private void a(int[] paramArrayOfInt, HashSet<Integer> paramHashSet)
  {
    if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0))
    {
      int i = 0;
      while (i < paramArrayOfInt.length)
      {
        paramHashSet.add(Integer.valueOf(paramArrayOfInt[i]));
        i += 1;
      }
    }
  }
  
  private boolean a(String paramString1, int paramInt, String paramString2)
  {
    return jdField_a_of_type_ComTencentImcoreMessageBaseMsgProxy$Callback.a(paramString1, paramInt, paramString2, this);
  }
  
  private int b(int paramInt)
  {
    List localList = h(AppConstants.RECOMMEND_TROOP_UIN, 4001);
    int i;
    if (localList != null)
    {
      int j = localList.size() - 1;
      i = 0;
      while (j >= 0)
      {
        if (((MessageRecord)localList.get(j)).msgtype != paramInt) {
          break label129;
        }
        localList.remove(j);
        i += 1;
        j -= 1;
      }
      a(String.valueOf(AppConstants.RECOMMEND_TROOP_UIN), 4001, b(String.valueOf(AppConstants.RECOMMEND_TROOP_UIN), 4001), "msgtype=?", new String[] { String.valueOf(paramInt) }, null);
    }
    for (;;)
    {
      jdField_a_of_type_ComTencentImcoreMessageBaseMsgProxy$Callback.a(paramInt, localList, this.app);
      return i;
      label129:
      break;
      i = 0;
    }
  }
  
  private long b(long paramLong, MessageRecord paramMessageRecord)
  {
    long l = paramLong;
    if (paramMessageRecord.getId() > 0L)
    {
      l = paramLong;
      if (paramMessageRecord.getId() < paramLong) {
        l = paramMessageRecord.getId();
      }
    }
    return l;
  }
  
  @Nullable
  private MessageRecord b(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    paramString = a(a(paramString, paramInt1));
    if (paramString != null)
    {
      paramString = paramString.iterator();
      while (paramString.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)paramString.next();
        if ((localMessageRecord.shmsgseq == paramLong) && (localMessageRecord.msgtype == paramInt2)) {
          return localMessageRecord;
        }
      }
    }
    return null;
  }
  
  private void b(String paramString, int paramInt)
  {
    List localList = h(paramString, paramInt);
    if ((localList != null) && (!localList.isEmpty())) {
      jdField_a_of_type_ComTencentImcoreMessageBaseMsgProxy$Callback.a(localList, this);
    }
    for (localList = c(paramString, paramInt, localList);; localList = j(paramString, paramInt))
    {
      Object localObject = localList;
      if (localList == null) {
        localObject = new ArrayList();
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MsgProxy", 2, "continuedList :" + ((List)localObject).size());
      }
      b(paramString, paramInt, (List)localObject);
      return;
    }
  }
  
  private void b(String paramString, int paramInt1, int paramInt2)
  {
    Object localObject = h(paramString, paramInt1);
    if ((localObject == null) || (((List)localObject).isEmpty())) {}
    for (;;)
    {
      return;
      Iterator localIterator = ((List)localObject).iterator();
      while (localIterator.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
        if ((!localMessageRecord.isread) && (localMessageRecord.getConfessTopicId() == paramInt2)) {
          localMessageRecord.isread = true;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MsgProxy", 2, "setMsgRead " + ((MessageRecord)((List)localObject).get(((List)localObject).size() - 1)).getBaseInfoString());
      }
      paramString = e(paramString, paramInt1);
      if ((paramString != null) && (!paramString.isEmpty()))
      {
        paramString = paramString.iterator();
        while (paramString.hasNext())
        {
          localObject = (MessageRecord)paramString.next();
          if ((!((MessageRecord)localObject).isread) && (((MessageRecord)localObject).getConfessTopicId() == paramInt2)) {
            ((MessageRecord)localObject).isread = true;
          }
        }
      }
    }
  }
  
  private void b(String paramString, int paramInt, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    List localList = h(paramString, paramInt);
    String str = a(paramString, paramInt);
    a(paramString, paramInt, str, localList);
    jdField_a_of_type_ComTencentImcoreMessageBaseMsgProxy$Callback.a(localList, paramMessageRecord, true);
    if ((localList != null) && (localList.size() > 40) && (!UinTypeUtil.a(paramString))) {
      localList.remove(0);
    }
    a(paramString, paramMessageRecord, paramBoolean, str);
  }
  
  private void b(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2)
  {
    List localList = h(paramString1, paramInt1);
    ArrayList localArrayList = new ArrayList();
    if (localList != null)
    {
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
        if ((localMessageRecord.senderuin != null) && (localMessageRecord.selfuin != null) && (localMessageRecord.senderuin.equals(paramString2)) && (localMessageRecord.selfuin.equals(paramString3)) && (((paramInt2 != 0) && (paramInt2 == localMessageRecord.getExtraKey())) || (paramInt2 == 0))) {
          localArrayList.add(localMessageRecord);
        }
      }
      localList.removeAll(localArrayList);
    }
    if (paramInt2 == 0L) {
      a(paramString1, paramInt1, b(paramString1, paramInt1), "senderuin=? and selfuin=?", new String[] { paramString2, paramString3 }, null);
    }
    for (;;)
    {
      localArrayList.clear();
      return;
      if (paramInt1 == 1032)
      {
        paramString1 = localArrayList.iterator();
        while (paramString1.hasNext()) {
          a((MessageRecord)paramString1.next(), false);
        }
      }
    }
  }
  
  private void b(List<MessageRecord> paramList, ProxyListener paramProxyListener)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)paramList.next();
      if (localMessageRecord.versionCode > 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("vip", 2, "proxy addSync id=" + localMessageRecord.vipBubbleID);
        }
        this.proxyManager.addMsgQueueDonotNotify(localMessageRecord.frienduin, localMessageRecord.istroop, b(localMessageRecord.frienduin, localMessageRecord.istroop), localMessageRecord, 0, paramProxyListener);
      }
    }
    this.proxyManager.transSaveToDatabase();
  }
  
  private boolean b(String paramString, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      b(paramString, paramInt);
      return false;
    }
    a().remove(a(paramString, paramInt));
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "getAioMsgPool().remove");
    }
    return true;
  }
  
  private int c(String paramString, int paramInt)
  {
    List localList = h(paramString, paramInt);
    int i = 0;
    if (localList != null)
    {
      i = localList.size();
      localList.clear();
    }
    if (a().containsKey(a(paramString, paramInt))) {
      a().remove(a(paramString, paramInt));
    }
    return i;
  }
  
  private MessageRecord c(String paramString, int paramInt1, int paramInt2)
  {
    Object localObject1 = c(paramString, paramInt1);
    int i;
    if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
    {
      i = ((List)localObject1).size() - 1;
      if (i >= 0) {
        if ((paramInt2 == 0) || (((MessageRecord)((List)localObject1).get(i)).getConfessTopicId() == paramInt2))
        {
          localObject1 = (MessageRecord)((List)localObject1).get(i);
          label76:
          localObject2 = localObject1;
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder().append("getLastMsgFromList mr = ");
            if (localObject1 != null) {
              break label222;
            }
            localObject2 = "null";
            label111:
            QLog.d("Q.msg.MsgProxy", 2, (String)localObject2);
          }
        }
      }
    }
    for (Object localObject2 = localObject1;; localObject2 = null)
    {
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        QLog.e("Q.msg.MsgProxy", 1, new Object[] { "getLastMsgFromList no cache", paramString, ",", Integer.valueOf(paramInt1), ",", Integer.valueOf(paramInt2) });
        jdField_a_of_type_ComTencentImcoreMessageBaseMsgProxy$Callback.a(this.app, paramString, paramInt1);
        localObject1 = b(paramString, paramInt1, paramInt2);
      }
      return localObject1;
      i -= 1;
      break;
      label222:
      localObject2 = ((MessageRecord)localObject1).getBaseInfoString();
      break label111;
      localObject1 = null;
      break label76;
    }
  }
  
  private void c(String paramString, int paramInt, long paramLong)
  {
    Object localObject = h(paramString, paramInt);
    if ((localObject == null) || (((List)localObject).isEmpty())) {}
    for (;;)
    {
      return;
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
        if ((!localMessageRecord.isread) && (a(paramInt, paramLong, localMessageRecord)) && ((!UinTypeUtil.e(paramInt)) || (!UinTypeUtil.f(localMessageRecord.msgtype)))) {
          localMessageRecord.isread = true;
        }
      }
      paramString = e(paramString, paramInt);
      if ((paramString != null) && (!paramString.isEmpty()))
      {
        paramString = paramString.iterator();
        while (paramString.hasNext())
        {
          localObject = (MessageRecord)paramString.next();
          if ((!((MessageRecord)localObject).isread) && (a(paramInt, paramLong, (MessageRecord)localObject)) && ((!UinTypeUtil.e(paramInt)) || (!UinTypeUtil.f(((MessageRecord)localObject).msgtype)))) {
            ((MessageRecord)localObject).isread = true;
          }
        }
      }
    }
  }
  
  private void c(String paramString, int paramInt, MessageRecord paramMessageRecord)
  {
    List localList = a(a(paramString, paramInt));
    if (localList != null)
    {
      jdField_a_of_type_ComTencentImcoreMessageBaseMsgProxy$Callback.a(localList, paramMessageRecord, true);
      if (localList.size() > 40) {
        localList.remove(0);
      }
      c(paramString, paramInt, localList);
    }
  }
  
  private List<MessageRecord> f(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    ArrayList localArrayList = new ArrayList();
    paramString = a(a(paramString, paramInt1));
    if (paramString != null)
    {
      paramString = paramString.iterator();
      while (paramString.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)paramString.next();
        if ((localMessageRecord.shmsgseq == paramLong) && (localMessageRecord.msgtype == paramInt2)) {
          localArrayList.add(localMessageRecord);
        }
      }
    }
    return localArrayList;
  }
  
  private List<MessageRecord> j(String paramString, int paramInt)
  {
    return d(paramString, paramInt, 15);
  }
  
  @Nullable
  private MessageRecord k(String paramString, int paramInt, long paramLong)
  {
    List localList = null;
    Object localObject2 = h(paramString, paramInt);
    Object localObject1 = localList;
    if (localObject2 != null)
    {
      Iterator localIterator = ((List)localObject2).iterator();
      do
      {
        localObject1 = localList;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject1 = (MessageRecord)localIterator.next();
      } while (((MessageRecord)localObject1).uniseq != paramLong);
      ((List)localObject2).remove(localObject1);
    }
    localList = e(paramString, paramInt);
    paramString = (String)localObject1;
    if (localList != null)
    {
      localObject2 = localList.iterator();
      do
      {
        paramString = (String)localObject1;
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        paramString = (MessageRecord)((Iterator)localObject2).next();
      } while (paramString.uniseq != paramLong);
      localList.remove(paramString);
    }
    return paramString;
  }
  
  private List<MessageRecord> k(String paramString, int paramInt)
  {
    Object localObject1 = a(a(paramString, paramInt));
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = localObject1;
      if (QLog.isColorLevel())
      {
        QLog.d("Q.msg.MsgProxy", 2, "init from cache, uin=" + paramString);
        localObject2 = localObject1;
      }
    }
    long l;
    String str;
    boolean bool;
    do
    {
      return localObject2;
      l = System.currentTimeMillis();
      str = c(paramString, paramInt);
      bool = a(paramString, paramInt, false);
      if (bool) {
        this.proxyManager.transSaveToDatabase();
      }
      localObject2 = i(paramString, paramInt);
      localObject1 = jdField_a_of_type_ComTencentImcoreMessageBaseMsgProxy$Callback.a(str, null, this);
      MessageRecord localMessageRecord;
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        paramInt = 0;
        while (paramInt < ((List)localObject1).size())
        {
          localMessageRecord = (MessageRecord)((List)localObject1).get(paramInt);
          if ((localMessageRecord != null) && (localMessageRecord.isSendFromLocal()) && (localMessageRecord.extraflag == 32772) && (!jdField_a_of_type_ComTencentImcoreMessageBaseMsgProxy$Callback.a(this.app, localMessageRecord)))
          {
            QLog.e("Q.msg.MsgProxy", 1, new Object[] { "set sending message FAILED: ", localMessageRecord });
            localMessageRecord.setExtraFlag(32768);
          }
          paramInt += 1;
        }
      }
      if (localObject1 != null)
      {
        int j = ((List)localObject1).size() / 2;
        paramInt = ((List)localObject1).size();
        int i = 0;
        paramInt -= 1;
        while (i < j)
        {
          localMessageRecord = (MessageRecord)((List)localObject1).get(i);
          ((List)localObject1).set(i, ((List)localObject1).get(paramInt));
          ((List)localObject1).set(paramInt, localMessageRecord);
          i += 1;
          paramInt -= 1;
        }
      }
      for (;;)
      {
        localObject2 = UinTypeUtil.a((List)localObject1, (List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localMessageRecord = (MessageRecord)((Iterator)localObject2).next();
          jdField_a_of_type_ComTencentImcoreMessageBaseMsgProxy$Callback.a((List)localObject1, localMessageRecord, true);
        }
        localObject1 = new ArrayList();
      }
      localObject2 = localObject1;
    } while (!QLog.isColorLevel());
    QLog.d("Q.msg.MsgProxy", 2, new Object[] { "init from db, uin=", paramString, ", isSaveToDatabase=", Boolean.valueOf(bool), ", cost=", Long.valueOf(System.currentTimeMillis() - l), " sqlStr = ", str, " size =", Integer.valueOf(((List)localObject1).size()) });
    return localObject1;
  }
  
  @Nullable
  private MessageRecord l(String paramString, int paramInt, long paramLong)
  {
    List localList = null;
    Object localObject2 = h(paramString, paramInt);
    Object localObject1 = localList;
    if (localObject2 != null)
    {
      Iterator localIterator = ((List)localObject2).iterator();
      do
      {
        localObject1 = localList;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject1 = (MessageRecord)localIterator.next();
      } while (((MessageRecord)localObject1).getId() != paramLong);
      ((List)localObject2).remove(localObject1);
    }
    localList = e(paramString, paramInt);
    paramString = (String)localObject1;
    if (localList != null)
    {
      localObject2 = localList.iterator();
      do
      {
        paramString = (String)localObject1;
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        paramString = (MessageRecord)((Iterator)localObject2).next();
      } while (paramString.getId() != paramLong);
      localList.remove(paramString);
    }
    return paramString;
  }
  
  @Nullable
  private MessageRecord m(String paramString, int paramInt, long paramLong)
  {
    paramString = a(a(paramString, paramInt));
    if (paramString != null)
    {
      Iterator localIterator = paramString.iterator();
      while (localIterator.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
        if (localMessageRecord.uniseq == paramLong)
        {
          paramString.remove(localMessageRecord);
          return localMessageRecord;
        }
      }
    }
    return null;
  }
  
  public int a(int paramInt)
  {
    Lock localLock = a(AppConstants.RECOMMEND_TROOP_UIN, paramInt);
    localLock.lock();
    try
    {
      paramInt = b(paramInt);
      return paramInt;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  public int a(int paramInt1, int paramInt2)
  {
    return 0;
  }
  
  public int a(int paramInt, Message paramMessage)
  {
    String str = String.valueOf(AppConstants.RECOMMEND_TROOP_UIN);
    Lock localLock = a(str, 4001);
    localLock.lock();
    try
    {
      paramInt = a(paramInt, paramMessage, str, 4001, 0);
      return paramInt;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  public int a(MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    if (paramMessageRecord == null) {
      return -1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "--->deleteC2CMsgByMessageRecord : peerUin:" + paramMessageRecord.frienduin + " type:" + paramMessageRecord.istroop + " uniseq:" + paramMessageRecord.uniseq + " mr:" + paramMessageRecord + " dbid:" + paramMessageRecord.getId());
    }
    if (paramBoolean)
    {
      h(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.getId());
      label111:
      long l = paramMessageRecord.getId();
      if (l <= 0L) {
        break label190;
      }
      a(paramMessageRecord.frienduin, paramMessageRecord.istroop, b(paramMessageRecord.frienduin, paramMessageRecord.istroop), "_id=?", new String[] { String.valueOf(l) }, null);
    }
    for (;;)
    {
      if (paramMessageRecord.isread) {
        break label244;
      }
      return 2;
      e(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.uniseq);
      break label111;
      label190:
      if (paramMessageRecord.uniseq == 0L) {
        break;
      }
      a(paramMessageRecord.frienduin, paramMessageRecord.istroop, b(paramMessageRecord.frienduin, paramMessageRecord.istroop), "uniseq=?", new String[] { String.valueOf(paramMessageRecord.uniseq) }, null);
    }
    label244:
    a(paramMessageRecord.frienduin, paramMessageRecord.istroop);
    return 1;
  }
  
  public int a(String paramString, int paramInt)
  {
    paramString = e(paramString, paramInt);
    if (paramString == null) {
      return 0;
    }
    return paramString.size();
  }
  
  public int a(String paramString, int paramInt, long paramLong)
  {
    String str = b(paramString, paramInt);
    boolean bool = UinTypeUtil.g(paramInt);
    Object localObject2;
    if (bool)
    {
      ??? = "shmsgseq desc , _id desc";
      if (!bool) {
        break label213;
      }
      localObject2 = "shmsgseq";
      localObject2 = String.format("select * from (select count() as unReadNum from %s mr where mr.isread=0 and mr.issend='0' and mr.%s>'%d'),%s m where m.%s>'%d' order by %s limit 1", new Object[] { str, localObject2, Long.valueOf(paramLong), str, localObject2, Long.valueOf(paramLong), ??? });
    }
    for (;;)
    {
      synchronized (jdField_a_of_type_ComTencentImcoreMessageBaseMsgProxy$Callback.a(this.app))
      {
        if (a(paramString, paramInt, false)) {
          this.proxyManager.transSaveToDatabase(a());
        }
        localObject2 = a().rawQuery(Message.class, (String)localObject2, null);
        if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
        {
          i = ((Message)((List)localObject2).get(0)).unReadNum;
          int j = c(paramString, paramInt, paramLong);
          paramInt = jdField_a_of_type_ComTencentImcoreMessageBaseMsgProxy$Callback.a(paramString, paramInt, paramLong, i + j, this.app);
          return paramInt;
          ??? = "time desc , _id desc";
          break;
          label213:
          localObject2 = "time";
        }
      }
      int i = 0;
    }
  }
  
  public int a(String paramString, int paramInt, MessageRecord paramMessageRecord)
  {
    int i = 0;
    Object localObject = null;
    String str = b(paramString, paramInt);
    paramString = localObject;
    if (UinTypeUtil.b(paramInt))
    {
      paramString = "( msgtype " + UinTypeUtil.a() + " and isValid=1 ) and ( time < ? or (time = ? and longMsgIndex <= ? and _id <= ?))";
      long l1 = paramMessageRecord.time;
      long l2 = paramMessageRecord.time;
      paramInt = paramMessageRecord.longMsgIndex;
      long l3 = paramMessageRecord.getId();
      paramString = a().query(false, str, new String[] { "_id" }, paramString, new String[] { String.valueOf(l1), String.valueOf(l2), String.valueOf(paramInt), String.valueOf(l3) }, null, null, null, null);
    }
    paramInt = i;
    if (paramString != null)
    {
      paramInt = paramString.getCount();
      paramString.close();
    }
    return paramInt;
  }
  
  public int a(String paramString, int paramInt, boolean paramBoolean)
  {
    int i = b(paramString, paramInt);
    if (paramBoolean)
    {
      a(paramString, paramInt, b(paramString, paramInt), null, null, null);
      a(paramString, paramInt, d(paramString, paramInt), null, null, null);
    }
    jdField_a_of_type_ComTencentImcoreMessageBaseMsgProxy$Callback.a(paramString, paramInt, paramBoolean, this, this.app);
    return i;
  }
  
  public int a(List<MessageRecord> paramList, boolean paramBoolean)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return -1;
    }
    int i = paramList.size();
    Object localObject1 = (MessageRecord)paramList.get(paramList.size() - 1);
    String str = ((MessageRecord)localObject1).frienduin;
    int j = ((MessageRecord)localObject1).istroop;
    Object localObject2 = new ArrayList();
    localObject1 = new ArrayList();
    paramList = paramList.iterator();
    if (paramList.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)paramList.next();
      if (paramBoolean)
      {
        h(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.getId());
        label124:
        if (localMessageRecord.getId() <= 0L) {
          break label176;
        }
        ((List)localObject2).add(String.valueOf(localMessageRecord.getId()));
      }
      for (;;)
      {
        break;
        e(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.uniseq);
        break label124;
        label176:
        if (localMessageRecord.uniseq != 0L) {
          ((List)localObject1).add(String.valueOf(localMessageRecord.uniseq));
        } else {
          i -= 1;
        }
      }
    }
    if (((List)localObject2).size() > 100)
    {
      paramList = ((List)localObject2).iterator();
      while (paramList.hasNext())
      {
        localObject2 = (String)paramList.next();
        a(str, j, b(str, j), "_id=?", new String[] { localObject2 }, null);
      }
    }
    int k;
    if (((List)localObject2).size() != 0)
    {
      k = ((List)localObject2).size();
      paramList = new String[k];
      Arrays.fill(paramList, "?");
      paramList = Arrays.toString(paramList);
      paramList = "_id IN (" + paramList.substring(1, paramList.length() - 1) + ")";
      a(str, j, b(str, j), paramList, (String[])((List)localObject2).toArray(new String[k]), null);
    }
    if (((List)localObject1).size() > 100)
    {
      paramList = ((List)localObject1).iterator();
      while (paramList.hasNext())
      {
        localObject1 = (String)paramList.next();
        a(str, j, b(str, j), "uniseq=?", new String[] { localObject1 }, null);
      }
    }
    if (((List)localObject1).size() != 0)
    {
      k = ((List)localObject1).size();
      paramList = new String[k];
      Arrays.fill(paramList, "?");
      paramList = Arrays.toString(paramList);
      paramList = "uniseq IN (" + paramList.substring(1, paramList.length() - 1) + ")";
      a(str, j, b(str, j), paramList, (String[])((List)localObject1).toArray(new String[k]), null);
    }
    a(str, j);
    return i;
  }
  
  @Deprecated
  public Cursor a(String paramString, int paramInt)
  {
    int j = 0;
    List localList = b(paramString, paramInt);
    if (paramString.equals(String.valueOf(AppConstants.SYSTEM_MSG_UIN)))
    {
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < localList.size())
      {
        localArrayList.add(localList.get(localList.size() - i - 1));
        i += 1;
      }
      new ArrayList();
      paramString = d(paramString, paramInt, 2147483647);
      if (paramString != null)
      {
        paramInt = j;
        while (paramInt < paramString.size())
        {
          localArrayList.add(paramString.get(paramString.size() - paramInt - 1));
          paramInt += 1;
        }
      }
      return new MessageRecordCursor(this, localArrayList);
    }
    return new MessageRecordCursor(this, (List)((ArrayList)localList).clone());
  }
  
  public Message a(String paramString, EntityManager paramEntityManager)
  {
    return a(paramString, paramEntityManager, 0);
  }
  
  public Message a(String paramString, EntityManager paramEntityManager, int paramInt)
  {
    for (;;)
    {
      synchronized (jdField_a_of_type_ComTencentImcoreMessageBaseMsgProxy$Callback.a(this.app))
      {
        if (a(paramString, false)) {
          this.proxyManager.transSaveToDatabase(paramEntityManager);
        }
        if (paramString.startsWith("mr_discusssion")) {
          break label491;
        }
        if (!paramString.startsWith("mr_troop")) {
          break label506;
        }
        break label491;
        boolean bool2 = paramString.endsWith("_New");
        Object localObject2 = "select * from (select count() as unReadNum from %s mr where mr.isread=0),(select count() as hasReply from %s mr where mr.issend=0),%s m where m.isValid=1 and m.msgtype " + UinTypeUtil.b() + " order by %s limit 1";
        if (!bool2) {
          break label520;
        }
        if (!bool1) {
          break label512;
        }
        localObject1 = "shmsgseq desc , _id desc";
        localObject1 = String.format((String)localObject2, new Object[] { paramString, paramString, paramString, localObject1 });
        localObject2 = null;
        Object localObject3 = null;
        List localList = a().rawQuery(Message.class, (String)localObject1, new String[0]);
        localObject1 = localObject2;
        if (localList != null)
        {
          localObject1 = localObject2;
          if (!localList.isEmpty())
          {
            i = localList.size() - 1;
            localObject2 = localObject3;
            if (i >= 0)
            {
              if ((paramInt != 0) && (((Message)localList.get(i)).getConfessTopicId() != paramInt)) {
                break label527;
              }
              localObject2 = (Message)localList.get(i);
            }
            localObject1 = localObject2;
            if (localObject2 != null)
            {
              localObject1 = localObject2;
              if (((Message)localObject2).isLongMsg())
              {
                localObject1 = localObject2;
                if (((Message)localObject2).longMsgIndex > 0) {
                  localObject1 = a(paramString, paramEntityManager, ((Message)localObject2).longMsgId, ((Message)localObject2).issend);
                }
              }
            }
          }
        }
        paramString = c(paramString);
        if ((paramString != null) && (paramString.size() > 0))
        {
          i = paramString.size() - 1;
          if (i >= 0)
          {
            if ((paramInt <= 0) || (((MessageRecord)paramString.get(i)).getConfessTopicId() == paramInt)) {
              break label497;
            }
            paramString.remove(i);
            break label497;
          }
        }
        if ((paramString == null) || (paramString.size() <= 0)) {
          break label485;
        }
        if (localObject1 == null)
        {
          paramInt = 0;
          paramString = paramString.iterator();
          paramEntityManager = (EntityManager)localObject1;
          if (paramString.hasNext())
          {
            localObject2 = (MessageRecord)paramString.next();
            if (!((MessageRecord)localObject2).isread) {
              break label536;
            }
            i = 0;
            paramEntityManager = a(paramEntityManager, (MessageRecord)localObject2, bool1);
            paramInt = i + paramInt;
            continue;
          }
        }
        else
        {
          paramInt = ((Message)localObject1).unReadNum;
          continue;
        }
        if (localObject1 == null)
        {
          paramString = new Message();
          MessageRecord.copyMessageRecordBaseField(paramString, paramEntityManager);
          paramString.unReadNum = paramInt;
          return paramString;
        }
      }
      paramString = (String)localObject1;
      continue;
      label485:
      paramString = (String)localObject1;
      continue;
      label491:
      boolean bool1 = true;
      continue;
      label497:
      i -= 1;
      continue;
      label506:
      bool1 = false;
      continue;
      label512:
      Object localObject1 = "time desc , _id desc";
      continue;
      label520:
      localObject1 = "_id desc";
      continue;
      label527:
      i -= 1;
      continue;
      label536:
      int i = 1;
    }
  }
  
  public MsgPool a()
  {
    return this.jdField_a_of_type_ComTencentImcoreMessageMsgPool;
  }
  
  protected SQLiteDatabase a()
  {
    return jdField_a_of_type_ComTencentImcoreMessageBaseMsgProxy$Callback.a(this.app);
  }
  
  protected ChatHistorySearchData a(Cursor paramCursor, String paramString1, String paramString2, int paramInt, String paramString3)
  {
    if ((paramCursor == null) || (paramCursor.getCount() == 0) || (TextUtils.isEmpty(paramString1))) {
      return null;
    }
    String str1 = paramString1.toLowerCase(Locale.US);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    paramString1 = new HashSet();
    a(paramString2, paramInt, paramString1);
    HashSet localHashSet = new HashSet();
    paramString1 = paramString1.iterator();
    Object localObject;
    while (paramString1.hasNext())
    {
      localObject = (String)paramString1.next();
      if (localObject != null)
      {
        String str2 = jdField_a_of_type_ComTencentImcoreMessageBaseMsgProxy$Callback.a(this.app, (String)localObject, paramString2, paramInt, paramString3);
        if ((!TextUtils.isEmpty(str2)) && (str2.toLowerCase(Locale.US).contains(str1))) {
          localHashSet.add(localObject);
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "getSearchResult, key uin = " + localHashSet.toString());
    }
    if (paramCursor.isBeforeFirst()) {
      paramCursor.moveToFirst();
    }
    int i;
    if (!paramCursor.isAfterLast())
    {
      int j = 0;
      paramString1 = a(paramCursor, paramInt, paramString2);
      i = j;
      if (!TextUtils.isEmpty(paramString1))
      {
        i = j;
        if (localHashSet.contains(paramString1)) {
          i = 1;
        }
      }
      if (i != 0) {
        break label461;
      }
      localObject = paramCursor.getBlob(paramCursor.getColumnIndex("msgData"));
      paramString3 = "";
      paramString1 = paramString3;
      if (localObject != null) {
        paramString1 = paramString3;
      }
    }
    label461:
    for (;;)
    {
      try
      {
        if (localObject.length > 0) {
          paramString1 = new String((byte[])localObject, "utf-8");
        }
        if (!paramString1.toLowerCase(Locale.US).contains(str1)) {
          break label461;
        }
        i = 1;
        if (i != 0)
        {
          if (localArrayList1.size() >= 50) {
            continue;
          }
          paramString1 = (MessageRecord)a().cursor2Entity(MessageRecord.class, null, paramCursor, new MsgProxy.1(this));
          if (paramString1 != null) {
            localArrayList1.add(paramString1);
          }
        }
        paramCursor.moveToNext();
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        paramString1 = "";
        continue;
        localArrayList2.add(Integer.valueOf(paramCursor.getInt(0)));
        continue;
      }
      if (localArrayList1.size() <= 0) {
        break;
      }
      paramCursor = new ChatHistorySearchData();
      paramCursor.mSearchData1 = localArrayList1;
      paramCursor.mSearchData2 = localArrayList2;
      return paramCursor;
    }
  }
  
  public ChatHistorySearchData a(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (!TextUtils.isEmpty(paramString2))
    {
      if (!TextUtils.isEmpty(paramString1)) {
        break label28;
      }
      localObject1 = localObject2;
    }
    for (;;)
    {
      return localObject1;
      label28:
      localObject1 = b(paramString2, paramInt);
      Cursor localCursor = a().query(false, (String)localObject1, null, "msgtype = ?", new String[] { String.valueOf(-1000) }, null, null, "time desc, longMsgIndex desc", null);
      try
      {
        paramString1 = a(localCursor, paramString1, paramString2, paramInt, paramString3);
        localObject1 = paramString1;
        return paramString1;
      }
      catch (Exception paramString1)
      {
        QLog.e("Q.msg.MsgProxy", 1, paramString1, new Object[0]);
        localObject1 = localObject2;
        return null;
      }
      finally
      {
        if (localCursor != null) {
          localCursor.close();
        }
      }
    }
  }
  
  public MessageRecord a(MessageRecord paramMessageRecord, int paramInt)
  {
    if (paramMessageRecord == null) {
      return null;
    }
    MessageRecord localMessageRecord = a(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.uniseq);
    paramMessageRecord.msgtype = paramInt;
    ContentValues localContentValues;
    if (localMessageRecord != null)
    {
      localMessageRecord.msgtype = paramInt;
      localContentValues = new ContentValues();
      localContentValues.put("msgtype", Integer.valueOf(paramInt));
      if (localMessageRecord == null) {
        break label166;
      }
      if (localMessageRecord.getId() <= 0L) {
        break label127;
      }
      a(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.versionCode, localContentValues, "_id=?", new String[] { String.valueOf(localMessageRecord.getId()) }, null);
    }
    for (;;)
    {
      return localMessageRecord;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.w("Q.msg.MsgProxy", 2, "update : updateMessageType : set fail !");
      break;
      label127:
      a(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.versionCode, localContentValues, "uniseq=?", new String[] { String.valueOf(localMessageRecord.uniseq) }, null);
      continue;
      label166:
      if (paramMessageRecord.getId() > 0L) {
        a(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.versionCode, localContentValues, "_id=?", new String[] { String.valueOf(paramMessageRecord.getId()) }, null);
      }
    }
  }
  
  public MessageRecord a(MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    if (paramMessageRecord == null) {
      return null;
    }
    MessageRecord localMessageRecord = a(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.uniseq);
    paramMessageRecord.isValid = paramBoolean;
    ContentValues localContentValues;
    if (localMessageRecord != null)
    {
      localMessageRecord.isValid = paramBoolean;
      localContentValues = new ContentValues();
      localContentValues.put("isValid", Boolean.valueOf(paramBoolean));
      if (localMessageRecord == null) {
        break label166;
      }
      if (localMessageRecord.getId() <= 0L) {
        break label127;
      }
      a(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.versionCode, localContentValues, "_id=?", new String[] { String.valueOf(localMessageRecord.getId()) }, null);
    }
    for (;;)
    {
      return localMessageRecord;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.w("Q.msg.MsgProxy", 2, "update : setMessageIsValidFlag : set fail !");
      break;
      label127:
      a(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.versionCode, localContentValues, "uniseq=?", new String[] { String.valueOf(localMessageRecord.uniseq) }, null);
      continue;
      label166:
      if (paramMessageRecord.getId() > 0L) {
        a(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.versionCode, localContentValues, "_id=?", new String[] { String.valueOf(paramMessageRecord.getId()) }, null);
      }
    }
  }
  
  public MessageRecord a(String paramString, int paramInt)
  {
    return a(paramString, paramInt, 0);
  }
  
  public MessageRecord a(String paramString, int paramInt1, int paramInt2)
  {
    Lock localLock = a(paramString, paramInt1);
    localLock.lock();
    try
    {
      paramString = c(paramString, paramInt1, paramInt2);
      return paramString;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  public MessageRecord a(String paramString, int paramInt, long paramLong)
  {
    MessageRecord localMessageRecord2 = null;
    if ((paramLong == 0L) || (paramString == null) || (paramString.length() == 0)) {
      return null;
    }
    Object localObject = b(paramString, paramInt);
    MessageRecord localMessageRecord1 = localMessageRecord2;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      do
      {
        localMessageRecord1 = localMessageRecord2;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localMessageRecord1 = (MessageRecord)((Iterator)localObject).next();
      } while (localMessageRecord1.uniseq != paramLong);
    }
    if (localMessageRecord1 == null)
    {
      paramString = d(paramString, paramInt);
      if (paramString != null)
      {
        paramString = paramString.iterator();
        while (paramString.hasNext())
        {
          localMessageRecord2 = (MessageRecord)paramString.next();
          if (localMessageRecord2.uniseq == paramLong) {
            return localMessageRecord2;
          }
        }
      }
    }
    return localMessageRecord1;
  }
  
  public MessageRecord a(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    Lock localLock = a(paramString, paramInt1);
    localLock.lock();
    try
    {
      paramString = b(paramString, paramInt1, paramLong, paramInt2);
      return paramString;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  public MessageRecord a(String paramString, int paramInt1, long paramLong, int paramInt2, int paramInt3)
  {
    MessageRecord localMessageRecord = a(paramString, paramInt1, paramLong);
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("extraflag", Integer.valueOf(paramInt2));
    localContentValues.put("sendFailCode", Integer.valueOf(paramInt3));
    if (localMessageRecord != null)
    {
      localMessageRecord.setExtraFlag(paramInt2);
      localMessageRecord.setSendFailCode(paramInt3);
      if (localMessageRecord.getId() > 0L)
      {
        a(paramString, paramInt1, localMessageRecord.versionCode, localContentValues, "_id=?", new String[] { String.valueOf(localMessageRecord.getId()) }, null);
        return localMessageRecord;
      }
      a(paramString, paramInt1, localMessageRecord.versionCode, localContentValues, "uniseq=?", new String[] { String.valueOf(localMessageRecord.uniseq) }, null);
      return localMessageRecord;
    }
    a(paramString, paramInt1, 3, localContentValues, "uniseq=?", new String[] { String.valueOf(paramLong) }, null);
    return localMessageRecord;
  }
  
  public MessageRecord a(String paramString, int paramInt, long paramLong1, long paramLong2, long paramLong3)
  {
    return null;
  }
  
  public MessageRecord a(String paramString1, int paramInt, long paramLong1, long paramLong2, String paramString2)
  {
    Object localObject = a(paramString1, paramInt, paramLong1);
    if ((localObject == null) && (paramString2 != null)) {}
    for (;;)
    {
      try
      {
        long l = Long.valueOf(paramString2).longValue();
        paramLong1 = l;
        if (QLog.isColorLevel())
        {
          paramLong1 = l;
          QLog.i("Q.msg.MsgProxy", 2, "can't find message by uniseq, try filename");
        }
        paramLong1 = l;
        paramString2 = a(paramString1, paramInt, l);
        paramLong1 = l;
      }
      catch (NumberFormatException paramString2)
      {
        paramString2 = (String)localObject;
        continue;
        a(paramString1, paramInt, paramString2.versionCode, (ContentValues)localObject, "uniseq=?", new String[] { String.valueOf(paramLong1) }, null);
        return paramString2;
      }
      if (paramString2 != null)
      {
        paramString2.time = paramLong2;
        if ((paramString2.extraflag == 32772) || (paramString2.extraflag == 32768))
        {
          paramString2.setExtraFlag(0);
          paramString2.setSendFailCode(0);
        }
        f(paramString1, paramInt, paramLong1);
        a(paramString1, paramInt, paramString2);
        jdField_a_of_type_ComTencentImcoreMessageBaseMsgProxy$Callback.a(paramString1, paramInt, paramLong1, paramLong2, paramString2, this.app);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MsgProxy", 2, "update msgTime set msg =" + paramString2.getBaseInfoString());
        }
      }
      localObject = new ContentValues();
      ((ContentValues)localObject).put("time", Long.valueOf(paramLong2));
      if ((paramString2 != null) && (paramString2.extraflag == 0))
      {
        ((ContentValues)localObject).put("extraflag", Integer.valueOf(0));
        ((ContentValues)localObject).put("sendFailCode", Integer.valueOf(0));
      }
      if (paramString2 != null) {
        if (paramString2.getId() > 0L)
        {
          a(paramString1, paramInt, paramString2.versionCode, (ContentValues)localObject, "_id=?", new String[] { String.valueOf(paramString2.getId()) }, null);
          return paramString2;
        }
      }
      a(paramString1, paramInt, 3, (ContentValues)localObject, "uniseq=?", new String[] { String.valueOf(paramLong1) }, null);
      return paramString2;
      paramString2 = (String)localObject;
    }
  }
  
  public MessageRecord a(String paramString1, int paramInt, long paramLong, String paramString2)
  {
    if (paramString2 == null) {
      return null;
    }
    MessageRecord localMessageRecord = a(paramString1, paramInt, paramLong);
    ContentValues localContentValues = new ContentValues();
    if ((localMessageRecord == null) || (localMessageRecord.versionCode > 0)) {}
    try
    {
      localContentValues.put("msgData", paramString2.getBytes("UTF-8"));
      label54:
      localMessageRecord.msg = paramString2;
      localMessageRecord.msgData = paramString2.getBytes();
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MsgProxy", 2, "updateMsgContentByUniseq: set msg =" + localMessageRecord.getBaseInfoString());
      }
      if (localMessageRecord.getId() > 0L) {
        a(paramString1, paramInt, localMessageRecord.versionCode, localContentValues, "_id=?", new String[] { String.valueOf(localMessageRecord.getId()) }, null);
      }
      for (;;)
      {
        return localMessageRecord;
        localContentValues.put("msg", paramString2);
        break;
        a(paramString1, paramInt, localMessageRecord.versionCode, localContentValues, "uniseq=?", new String[] { String.valueOf(paramLong) }, null);
        continue;
        try
        {
          localContentValues.put("msgData", paramString2.getBytes("UTF-8"));
          a(paramString1, paramInt, 3, localContentValues, "uniseq=?", new String[] { String.valueOf(paramLong) }, null);
        }
        catch (UnsupportedEncodingException paramString2)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.MsgProxy", 2, "updateMsgContentByUniseq fail!" + paramString2);
            }
          }
        }
      }
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      break label54;
    }
  }
  
  public MessageRecord a(String paramString1, int paramInt, long paramLong, String paramString2, Object paramObject)
  {
    MessageRecord localMessageRecord = a(paramString1, paramInt, paramLong);
    for (;;)
    {
      try
      {
        localObject = MessageRecord.class.getDeclaredField(paramString2);
        if (localObject == null)
        {
          QLog.e("Q.msg.MsgProxy", 1, "updateMsgFieldByUniseq: field == null");
          return localMessageRecord;
        }
        localClass = ((Field)localObject).getType();
        ((Field)localObject).setAccessible(true);
        ((Field)localObject).set(localMessageRecord, paramObject);
        if ((Modifier.isStatic(((Field)localObject).getModifiers())) || (((Field)localObject).isAnnotationPresent(notColumn.class))) {
          continue;
        }
        localObject = new ContentValues();
        if (localClass != Long.TYPE) {
          continue;
        }
        ((ContentValues)localObject).put(paramString2, (Long)paramObject);
      }
      catch (Exception paramString1)
      {
        Object localObject;
        Class localClass;
        paramString1.printStackTrace();
        if (!QLog.isColorLevel()) {
          break label446;
        }
        QLog.e("Q.msg.MsgProxy", 2, "updateMsgFieldByUniseq error! ", paramString1);
        break label446;
        if (localClass != String.class) {
          continue;
        }
        ((ContentValues)localObject).put(paramString2, (String)paramObject);
        continue;
        if (localClass != Byte.TYPE) {
          continue;
        }
        ((ContentValues)localObject).put(paramString2, (Byte)paramObject);
        continue;
        if (localClass != [B.class) {
          continue;
        }
        ((ContentValues)localObject).put(paramString2, (byte[])paramObject);
        continue;
        if (localClass != Short.TYPE) {
          continue;
        }
        ((ContentValues)localObject).put(paramString2, (Short)paramObject);
        continue;
        if (localClass != Boolean.TYPE) {
          continue;
        }
        ((ContentValues)localObject).put(paramString2, (Boolean)paramObject);
        continue;
        if (localClass != Float.TYPE) {
          continue;
        }
        ((ContentValues)localObject).put(paramString2, (Float)paramObject);
        continue;
        if (localClass != Double.TYPE) {
          continue;
        }
        ((ContentValues)localObject).put(paramString2, (Double)paramObject);
        continue;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("Q.msg.MsgProxy", 2, "updateMsgFieldByUniseq fieldType error! " + localClass.getClass().getSimpleName());
        continue;
        a(paramString1, paramInt, localMessageRecord.versionCode, (ContentValues)localObject, "uniseq=?", new String[] { String.valueOf(localMessageRecord.uniseq) }, null);
        break label446;
        return localMessageRecord;
      }
      if (localMessageRecord.getId() <= 0L) {
        continue;
      }
      a(paramString1, paramInt, localMessageRecord.versionCode, (ContentValues)localObject, "_id=?", new String[] { String.valueOf(localMessageRecord.getId()) }, null);
      break label446;
      if (localClass != Integer.TYPE) {
        continue;
      }
      ((ContentValues)localObject).put(paramString2, (Integer)paramObject);
    }
    label446:
    return localMessageRecord;
  }
  
  public MessageRecord a(String paramString1, int paramInt, long paramLong, String paramString2, String paramString3)
  {
    if (a(paramString1, paramInt, true)) {
      this.proxyManager.transSaveToDatabase(a());
    }
    paramString2 = String.format("select * from " + b(paramString1, paramInt) + " where time=%d and senderuin=%s", new Object[] { Long.valueOf(paramLong), paramString2 });
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "queryMsgByConstraints: sql=" + paramString2 + ", peeruin = " + paramString1 + ", type = " + paramInt);
    }
    paramString1 = jdField_a_of_type_ComTencentImcoreMessageBaseMsgProxy$Callback.a(paramString2, null, this);
    if (paramString1 != null)
    {
      paramString1 = paramString1.iterator();
      while (paramString1.hasNext())
      {
        paramString2 = (MessageRecord)paramString1.next();
        if (paramString2.msg.equals(paramString3)) {
          return paramString2;
        }
      }
    }
    return null;
  }
  
  public MessageRecord a(String paramString, int paramInt, long paramLong, byte[] paramArrayOfByte)
  {
    MessageRecord localMessageRecord = a(paramString, paramInt, paramLong);
    ContentValues localContentValues = new ContentValues();
    if (paramArrayOfByte != null) {
      localContentValues.put("msgData", paramArrayOfByte);
    }
    if (localMessageRecord != null)
    {
      localMessageRecord.msgData = paramArrayOfByte;
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MsgProxy", 2, "updateMsgContent: set msg = " + localMessageRecord.getBaseInfoString());
      }
      if (localMessageRecord.getId() > 0L)
      {
        a(paramString, paramInt, localMessageRecord.versionCode, localContentValues, "_id=?", new String[] { String.valueOf(localMessageRecord.getId()) }, null);
        return localMessageRecord;
      }
      a(paramString, paramInt, localMessageRecord.versionCode, localContentValues, "uniseq=?", new String[] { String.valueOf(paramLong) }, null);
      return localMessageRecord;
    }
    a(paramString, paramInt, 3, localContentValues, "uniseq=?", new String[] { String.valueOf(paramLong) }, null);
    return localMessageRecord;
  }
  
  public MessageRecord a(String paramString, int paramInt, MessageRecord paramMessageRecord)
  {
    return null;
  }
  
  public MessageRecord a(String paramString, int paramInt, MessageRecord paramMessageRecord, List<MessageRecord> paramList)
  {
    return null;
  }
  
  public MessageRecord a(String paramString1, int paramInt, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "queryLastMsgForMessageTabFromDB, peerUin = " + paramString1 + ", type " + paramInt);
    }
    if (a(paramString1, paramInt, true)) {
      this.proxyManager.transSaveToDatabase(a());
    }
    if (UinTypeUtil.g(paramInt))
    {
      localStringBuilder = new StringBuilder().append("select * from ").append(b(paramString1, paramInt)).append(" where isValid=1 and msgtype ").append(UinTypeUtil.b()).append(" ");
      if (paramString2 != null) {}
      for (paramString1 = "and " + paramString2;; paramString1 = "")
      {
        paramString1 = paramString1 + " order by shmsgseq desc , _id desc limit 1";
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MsgProxy", 2, "queryLastTABSupportMessageFromDB : sqlStr:" + paramString1);
        }
        paramString1 = jdField_a_of_type_ComTencentImcoreMessageBaseMsgProxy$Callback.a(paramString1, null, this);
        if ((paramString1 != null) && (paramString1.size() >= 1)) {
          break;
        }
        return null;
      }
    }
    StringBuilder localStringBuilder = new StringBuilder().append("select * from ").append(b(paramString1, paramInt)).append(" where isValid=1 and msgtype ").append(UinTypeUtil.b()).append(" ");
    if (paramString2 != null) {}
    for (paramString1 = "and " + paramString2;; paramString1 = "")
    {
      paramString1 = paramString1 + " order by time desc , _id desc limit 1";
      break;
    }
    return (MessageRecord)paramString1.get(0);
  }
  
  public EntityManager a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager == null) || (!this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.isOpen())) {}
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager == null) || (!this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.isOpen())) {
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = jdField_a_of_type_ComTencentImcoreMessageBaseMsgProxy$Callback.a(this.app);
      }
      return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
    }
  }
  
  protected String a(Cursor paramCursor, int paramInt, String paramString)
  {
    if (MessageRecordInfo.a(paramCursor.getInt(paramCursor.getColumnIndex("issend")))) {
      paramString = this.app.getAccount();
    }
    return paramString;
  }
  
  public String a(String paramString, int paramInt)
  {
    return UinTypeUtil.a(paramString, paramInt);
  }
  
  protected List<MessageRecord> a(String paramString)
  {
    return (List)a().get(paramString);
  }
  
  public List<MessageRecord> a(String paramString, int paramInt)
  {
    return b(b(paramString, paramInt));
  }
  
  public List<MessageRecord> a(String paramString, int paramInt1, int paramInt2)
  {
    Lock localLock = a(paramString, paramInt1);
    localLock.lock();
    try
    {
      paramString = c(paramString, paramInt1, paramInt2);
      return paramString;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  public List<MessageRecord> a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy_", 2, "getAIOMsgList peerUin: " + paramString + " type: " + paramInt1 + " , autoInit = " + paramBoolean);
    }
    Lock localLock = a(paramString, paramInt1);
    localLock.lock();
    try
    {
      paramString = a(paramString, paramInt1, paramBoolean);
      return paramString;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  public List<MessageRecord> a(String paramString, int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "getAllMessages uin " + paramString + " , type = " + paramInt1 + " , customTypes = " + Arrays.toString(paramArrayOfInt));
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = d(paramString, paramInt1);
    Object localObject1;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (!((List)localObject2).isEmpty()) {}
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MsgProxy", 2, "getAllMessages from AIO CACHE FAIL！ ");
      }
      localObject1 = b(paramString, paramInt1);
    }
    long l2 = 9223372036854775807L;
    long l6 = 9223372036854775807L;
    int i = 3;
    long l1 = 9223372036854775807L;
    localObject2 = new HashSet();
    a(paramArrayOfInt, (HashSet)localObject2);
    int j = i;
    long l3 = l1;
    long l4 = l2;
    long l5 = l6;
    if (localObject1 != null)
    {
      j = i;
      l3 = l1;
      l4 = l2;
      l5 = l6;
      if (!((List)localObject1).isEmpty())
      {
        if ((((List)localObject1).size() >= paramInt2) && (((HashSet)localObject2).isEmpty()))
        {
          localArrayList.addAll(((List)localObject1).subList(((List)localObject1).size() - paramInt2, ((List)localObject1).size()));
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MsgProxy", 2, "getAllMessages size = " + localArrayList.size());
          }
          return localArrayList;
        }
        l5 = a(paramInt1, (List)localObject1, 9223372036854775807L);
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject1).next();
          if ((!UinTypeUtil.g(paramInt1)) || (localMessageRecord.versionCode != 3) || (localMessageRecord.shmsgseq != l5) || (l5 == 0L)) {
            for (;;)
            {
              if (!((HashSet)localObject2).contains(Integer.valueOf(localMessageRecord.msgtype)))
              {
                j = i;
                l4 = l1;
                l3 = l2;
                if (!((HashSet)localObject2).isEmpty()) {}
              }
              else
              {
                j = a(i, localMessageRecord);
                l3 = b(l2, localMessageRecord);
                l4 = a(l1, localMessageRecord);
                localArrayList.add(localMessageRecord);
              }
              i = j;
              l1 = l4;
              l2 = l3;
            }
          }
        }
        j = i;
        l3 = l1;
        l4 = l2;
        if (localArrayList.size() >= paramInt2) {
          return localArrayList.subList(localArrayList.size() - paramInt2, localArrayList.size());
        }
      }
    }
    if (UinTypeUtil.g(paramInt1)) {
      localArrayList.addAll(0, a(paramString, paramInt1, l4, j, l5, paramInt2 - localArrayList.size(), paramArrayOfInt));
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MsgProxy", 2, "getAllMessages size = " + localArrayList.size());
      }
      return localArrayList;
      localArrayList.addAll(0, a(paramString, paramInt1, l4, j, l3, paramInt2 - localArrayList.size(), paramArrayOfInt));
    }
  }
  
  protected List<MessageRecord> a(String paramString, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "queryMessagesByMsgUniseqFromDB, peerUin[" + MsfSdkUtils.getShortUin(paramString) + "] type[" + paramInt + "] uniseq[" + paramLong + "]");
    }
    if (paramLong == 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.msg.MsgProxy", 2, "queryMessagesByMsgUniseqFromDB Warning! uniseq==0");
      }
      paramString = new ArrayList();
    }
    List localList;
    do
    {
      return paramString;
      if (a(paramString, paramInt, true)) {
        this.proxyManager.transSaveToDatabase(a());
      }
      paramString = "select * from " + b(paramString, paramInt) + " where uniseq=?";
      localList = jdField_a_of_type_ComTencentImcoreMessageBaseMsgProxy$Callback.a(paramString, new String[] { String.valueOf(paramLong) }, this);
      paramString = localList;
    } while (localList != null);
    return new ArrayList();
  }
  
  public List<MessageRecord> a(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "getAIOMsgList, jump to peerUin: " + paramString + " type: " + paramInt1 + " , from = " + paramLong);
    }
    Lock localLock = a(paramString, paramInt1);
    localLock.lock();
    try
    {
      paramString = e(paramString, paramInt1, paramLong, paramInt2);
      return paramString;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  public List<MessageRecord> a(String paramString1, int paramInt1, long paramLong1, int paramInt2, long paramLong2, int paramInt3, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "queryTimedMessageDBUnion, peerUin = " + paramString1 + ", type " + paramInt1 + ",_id = " + paramLong1 + ",versionCode = " + paramInt2 + ", from " + paramLong2 + ",count = " + paramInt3 + ",whrere = " + paramString2);
    }
    paramString2 = MessageDBUtils.a(d(paramString1, paramInt1), b(paramString1, paramInt1), paramLong1, paramInt2, paramLong2, paramInt3, b(), paramString2);
    if (paramString2 != null)
    {
      if (a(paramString1, paramInt1, true)) {
        this.proxyManager.transSaveToDatabase(a());
      }
      paramString1 = jdField_a_of_type_ComTencentImcoreMessageBaseMsgProxy$Callback.a(paramString2.toString(), null, this);
      if (QLog.isColorLevel()) {
        QLog.i("QQMessageFacade", 2, paramString2.toString());
      }
      if (paramString1 != null)
      {
        Collections.reverse(paramString1);
        if (QLog.isColorLevel())
        {
          paramString2 = paramString1.iterator();
          while (paramString2.hasNext())
          {
            MessageRecord localMessageRecord = (MessageRecord)paramString2.next();
            QLog.i("QQMessageFacade", 2, "queryTimedMessageDBUnion " + localMessageRecord.time + ", " + localMessageRecord.getId() + ", " + localMessageRecord.getLogColorContent());
          }
        }
        return paramString1;
      }
    }
    return new ArrayList();
  }
  
  public List<MessageRecord> a(String paramString, int paramInt1, long paramLong1, int paramInt2, long paramLong2, int paramInt3, int[] paramArrayOfInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "queryC2CMessageFromDB_UnionTables, peerUin = " + paramString + ", type " + paramInt1 + ",_id = " + paramLong1 + ",versionCode = " + paramInt2 + ", from " + paramLong2 + ",count = " + paramInt3 + ",customTypes = " + Arrays.toString(paramArrayOfInt));
    }
    Object localObject2 = null;
    if (a(paramString, paramInt1, true)) {
      this.proxyManager.transSaveToDatabase(paramString, paramInt1);
    }
    Object localObject1 = localObject2;
    if (paramArrayOfInt != null)
    {
      localObject1 = localObject2;
      if (paramArrayOfInt.length > 0)
      {
        localObject1 = new StringBuilder(" and msgtype in ( ");
        int i = 0;
        while (i < paramArrayOfInt.length)
        {
          ((StringBuilder)localObject1).append(paramArrayOfInt[i]);
          if (i < paramArrayOfInt.length - 1) {
            ((StringBuilder)localObject1).append(" , ");
          }
          i += 1;
        }
        ((StringBuilder)localObject1).append(") ");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
    }
    paramArrayOfInt = a(paramString, paramInt1, paramLong1, paramInt2, paramLong2, paramInt3, (String)localObject1);
    paramString = paramArrayOfInt;
    if (paramArrayOfInt == null) {
      paramString = new ArrayList();
    }
    return paramString;
  }
  
  public List<MessageRecord> a(String paramString1, int paramInt1, long paramLong, int paramInt2, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "queryMessageByTimeOrSeq() called with: peerUin = [" + paramString1 + "], type = [" + paramInt1 + "], seq = [" + paramLong + "], count = [" + paramInt2 + "], whereClause = [" + paramString2 + "]");
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "queryMessageByTimeOrSeq:uin=" + paramString1 + ",type=" + paramInt1 + ",seq=" + paramLong + ",count=" + paramInt2);
    }
    if (a(paramString1, paramInt1, true)) {
      this.proxyManager.transSaveToDatabase();
    }
    boolean bool = UinTypeUtil.g(paramInt1);
    if (a(paramString1, paramInt1))
    {
      if (bool) {}
      for (paramString1 = c(paramString1, paramInt1, paramLong, paramInt2, paramString2); paramString1 != null; paramString1 = b(paramString1, paramInt1, paramLong, paramInt2, paramString2)) {
        return paramString1;
      }
    }
    return new ArrayList();
  }
  
  public List<MessageRecord> a(String paramString, int paramInt, long paramLong1, long paramLong2)
  {
    if ((paramLong1 == 0L) || (paramLong2 == 0L) || (paramString == null) || (paramString.length() == 0)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject = c(paramString, paramInt);
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
        if ((localMessageRecord.shmsgseq == paramLong1) && (localMessageRecord.msgUid == paramLong2)) {
          localArrayList.add(localMessageRecord);
        }
      }
    }
    if (localArrayList.isEmpty())
    {
      paramString = f(paramString, paramInt, paramLong1, paramLong2);
      if ((paramString != null) && (!paramString.isEmpty())) {
        localArrayList.addAll(paramString);
      }
    }
    return localArrayList;
  }
  
  public List<MessageRecord> a(String paramString, int paramInt1, long paramLong1, long paramLong2, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "queryMessageFromTimeRange, peerUin = " + paramString + ", type " + paramInt1 + ",beginTime = " + paramLong1 + ",endTime = " + paramLong2 + ",topicId=" + paramInt2);
    }
    Object localObject = b(paramString, paramInt1);
    ArrayList localArrayList = new ArrayList();
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
        if ((localMessageRecord.time >= paramLong1) && (localMessageRecord.time <= paramLong2) && ((paramInt2 <= 0) || (localMessageRecord.getConfessTopicId() == paramInt2))) {
          localArrayList.add(localMessageRecord);
        }
      }
    }
    if ((localArrayList.size() > 0) && (((MessageRecord)localArrayList.get(0)).time == paramLong1)) {
      return localArrayList;
    }
    if (a(paramString, paramInt1, true)) {
      this.proxyManager.transSaveToDatabase(a());
    }
    int i = a(paramInt1, paramInt2);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("select * from ");
    ((StringBuilder)localObject).append(b(paramString, paramInt1));
    ((StringBuilder)localObject).append(" where time>=? and time<=?");
    if (i != 0) {
      ((StringBuilder)localObject).append(" and (extLong & 4194296)=?");
    }
    ((StringBuilder)localObject).append(" order by time asc");
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "queryMessageFromTimeRange " + ((StringBuilder)localObject).toString());
    }
    if (localArrayList.size() > 0) {
      paramLong2 = ((MessageRecord)localArrayList.get(0)).time;
    }
    paramLong1 = Math.min(paramLong1, paramLong2);
    a(localArrayList, paramLong2);
    if (i == 0)
    {
      localObject = jdField_a_of_type_ComTencentImcoreMessageBaseMsgProxy$Callback.a(((StringBuilder)localObject).toString(), new String[] { String.valueOf(paramLong1), String.valueOf(paramLong2) }, this);
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder().append("queryMessageFromTimeRange, peerUin = ").append(paramString).append(", type ").append(paramInt1).append(",queryBeginTime = ").append(paramLong1).append(",queryEndTime = ").append(paramLong2).append(",resultSize=");
        if (localObject != null) {
          break label585;
        }
      }
    }
    label585:
    for (paramInt1 = 0;; paramInt1 = ((List)localObject).size())
    {
      QLog.d("Q.msg.MsgProxy", 2, paramInt1 + ",topicId=" + paramInt2);
      if (localObject != null) {
        localArrayList.addAll(0, (Collection)localObject);
      }
      return localArrayList;
      localObject = jdField_a_of_type_ComTencentImcoreMessageBaseMsgProxy$Callback.a(((StringBuilder)localObject).toString(), new String[] { String.valueOf(paramLong1), String.valueOf(paramLong2), String.valueOf(i) }, this);
      break;
    }
  }
  
  public List<MessageRecord> a(String paramString, int paramInt, long paramLong, @NonNull Map<String, MessageRecord> paramMap)
  {
    Object localObject = paramMap;
    if (paramMap == null) {
      localObject = new HashMap();
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "querySameSeqMessageWithFilter,  peerUin = " + paramString + ", type " + paramInt + ", seq = " + paramLong + ", filterMsgSet.size = " + ((Map)localObject).size() + ",filterMsgSet = " + ((Map)localObject).keySet());
    }
    if (a(paramString, paramInt, true)) {
      this.proxyManager.transSaveToDatabase(a());
    }
    paramString = "select * from " + b(paramString, paramInt) + " where shmsgseq=?";
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "querySameSeqMessageWithFilter " + paramString);
    }
    paramMap = jdField_a_of_type_ComTencentImcoreMessageBaseMsgProxy$Callback.a(paramString, new String[] { String.valueOf(paramLong) }, this);
    if (paramMap == null) {
      return new ArrayList();
    }
    paramString = new ArrayList();
    paramMap = paramMap.iterator();
    while (paramMap.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)paramMap.next();
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MsgProxy", 2, "filter msg , seq = " + localMessageRecord.shmsgseq + " ,id = " + localMessageRecord.getId() + ",uniseq=" + localMessageRecord.uniseq);
      }
      if ((!((Map)localObject).containsKey("id&" + localMessageRecord.getId() + "&" + localMessageRecord.shmsgseq)) && (!((Map)localObject).containsKey("uniseq&" + localMessageRecord.uniseq + "&" + localMessageRecord.shmsgseq))) {
        paramString.add(localMessageRecord);
      }
    }
    return paramString;
  }
  
  public List<MessageRecord> a(String paramString, int paramInt, List<Long> paramList)
  {
    if ((paramList == null) || (paramString == null) || (paramString.length() == 0) || (paramList.size() == 0)) {
      return new ArrayList();
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    for (;;)
    {
      MessageRecord localMessageRecord;
      if (i < paramList.size())
      {
        localMessageRecord = a(paramString, paramInt, ((Long)paramList.get(i)).longValue());
        if (localMessageRecord != null) {}
      }
      else
      {
        if (i < paramList.size() - 1) {
          localArrayList.addAll(d(paramString, paramInt, paramList.subList(i, paramList.size())));
        }
        return localArrayList;
      }
      localArrayList.add(localMessageRecord);
      i += 1;
    }
  }
  
  public List<MessageRecord> a(String paramString, int paramInt, int[] paramArrayOfInt)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = d(paramString, paramInt);
    paramString = new HashSet();
    a(paramArrayOfInt, paramString);
    long l;
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      if (paramString.isEmpty())
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MsgProxy", 2, "getAllMessages size = " + localArrayList.size());
        }
        return localArrayList;
      }
      paramArrayOfInt = ((List)localObject).iterator();
      l = 9223372036854775807L;
      if (paramArrayOfInt.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)paramArrayOfInt.next();
        if (localMessageRecord.shmsgseq >= l) {
          break label248;
        }
        l = localMessageRecord.shmsgseq;
      }
    }
    label248:
    for (;;)
    {
      break;
      paramArrayOfInt = ((List)localObject).iterator();
      while (paramArrayOfInt.hasNext())
      {
        localObject = (MessageRecord)paramArrayOfInt.next();
        if (((!UinTypeUtil.g(paramInt)) || (((MessageRecord)localObject).versionCode != 3) || (((MessageRecord)localObject).shmsgseq != l) || (l == 0L)) && ((paramString.contains(Integer.valueOf(((MessageRecord)localObject).msgtype))) || (paramString.isEmpty()))) {
          localArrayList.add(localObject);
        }
      }
      return localArrayList;
    }
  }
  
  @Nullable
  protected List<MessageRecord> a(List<MessageRecord> paramList)
  {
    if (paramList != null) {
      return (List)((ArrayList)paramList).clone();
    }
    return null;
  }
  
  protected Map<String, List<MessageRecord>> a()
  {
    return this.jdField_a_of_type_ComTencentImcoreMessageMsgPool.a();
  }
  
  protected ConcurrentHashMap<String, List<MessageRecord>> a()
  {
    return this.jdField_a_of_type_ComTencentImcoreMessageMsgPool.b();
  }
  
  protected Lock a(String paramString, int paramInt)
  {
    return this.jdField_a_of_type_ComTencentImcoreMessageMsgPool.a(paramString, paramInt);
  }
  
  public void a()
  {
    try
    {
      a().clear();
      jdField_a_of_type_ComTencentImcoreMessageBaseMsgProxy$Callback.a(this.app);
      if (QLog.isColorLevel()) {
        QLog.d("msgFold", 2, "delAIOMsg ");
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    try
    {
      paramString = UinTypeUtil.a(paramString, paramInt);
      a().remove(paramString);
      jdField_a_of_type_ComTencentImcoreMessageBaseMsgProxy$Callback.a(this.app);
      if (QLog.isColorLevel()) {
        QLog.d("msgFold", 2, "delAIOMsg ");
      }
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void a(QueryHistoryParam paramQueryHistoryParam)
  {
    if (TextUtils.isEmpty(paramQueryHistoryParam.a())) {}
    for (;;)
    {
      return;
      if (a(paramQueryHistoryParam.a(), paramQueryHistoryParam.a(), true)) {
        this.proxyManager.transSaveToDatabase();
      }
      long l = NetConnInfoCenter.getServerTime();
      Object localObject = b(paramQueryHistoryParam.a(), paramQueryHistoryParam.a());
      EntityManager localEntityManager = a();
      int i = paramQueryHistoryParam.b();
      localObject = localEntityManager.query(false, (String)localObject, null, "msgtype in (?,?,?) AND time>=?", new String[] { String.valueOf(-1000), String.valueOf(-1035), String.valueOf(-2011), String.valueOf(l - 863913600L) }, null, null, "time desc, longMsgIndex desc", String.valueOf(i));
      try
      {
        paramQueryHistoryParam.a((Cursor)localObject);
        b(paramQueryHistoryParam);
        return;
      }
      catch (Exception paramQueryHistoryParam)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.msg.MsgProxy", 2, paramQueryHistoryParam, new Object[0]);
        }
        return;
      }
      finally
      {
        if (localObject != null) {
          ((Cursor)localObject).close();
        }
      }
    }
  }
  
  protected void a(String paramString, int paramInt)
  {
    List localList = h(paramString, paramInt);
    if ((localList != null) && (localList.size() == 0))
    {
      if (a(paramString, paramInt, true)) {
        this.proxyManager.transSaveToDatabase(a());
      }
      a().remove(a(paramString, paramInt));
      c(paramString, paramInt, f(paramString, paramInt));
    }
  }
  
  public void a(String paramString1, int paramInt1, int paramInt2, ContentValues paramContentValues, String paramString2, String[] paramArrayOfString, ProxyListener paramProxyListener)
  {
    if (paramInt2 > 0)
    {
      this.proxyManager.addMsgQueue(paramString1, paramInt1, b(paramString1, paramInt1), paramContentValues, paramString2, paramArrayOfString, 1, paramProxyListener);
      return;
    }
    this.proxyManager.addMsgQueue(paramString1, paramInt1, d(paramString1, paramInt1), paramContentValues, paramString2, paramArrayOfString, 1, paramProxyListener);
  }
  
  public void a(String paramString, int paramInt, long paramLong)
  {
    b(paramString, paramInt, paramLong);
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("isread", Boolean.valueOf(true));
    if (UinTypeUtil.g(paramInt)) {}
    String str2;
    String str3;
    for (String str1 = "shmsgseq";; str1 = "time")
    {
      str2 = String.valueOf(paramLong);
      str3 = b(paramString, paramInt);
      if ((!UinTypeUtil.e(paramInt)) || (UinTypeUtil.d() == null)) {
        break;
      }
      a(paramString, paramInt, str3, localContentValues, String.format("isread=? and %s<=? and " + UinTypeUtil.d(), new Object[] { str1 }), new String[] { "0", str2 }, null);
      return;
    }
    a(paramString, paramInt, str3, localContentValues, String.format("isread=? and %s<=?", new Object[] { str1 }), new String[] { "0", str2 }, null);
  }
  
  public void a(String paramString, int paramInt, long paramLong, ContentValues paramContentValues)
  {
    MessageRecord localMessageRecord = a(paramString, paramInt, paramLong);
    if (localMessageRecord != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MsgProxy", 2, "updateMsgContent: set msg = " + localMessageRecord.getBaseInfoString());
      }
      if (localMessageRecord.getId() > 0L)
      {
        a(paramString, paramInt, localMessageRecord.versionCode, paramContentValues, "_id=?", new String[] { String.valueOf(localMessageRecord.getId()) }, null);
        return;
      }
      a(paramString, paramInt, localMessageRecord.versionCode, paramContentValues, "uniseq=?", new String[] { String.valueOf(paramLong) }, null);
      return;
    }
    a(paramString, paramInt, 3, paramContentValues, "uniseq=?", new String[] { String.valueOf(paramLong) }, null);
  }
  
  public void a(String paramString, int paramInt, long paramLong, List<MessageRecord> paramList)
  {
    Lock localLock = a(paramString, paramInt);
    localLock.lock();
    try
    {
      b(paramString, paramInt, paramLong, paramList);
      return;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  public void a(String paramString, int paramInt, MessageRecord paramMessageRecord)
  {
    Lock localLock = a(paramString, paramInt);
    localLock.lock();
    try
    {
      c(paramString, paramInt, paramMessageRecord);
      return;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  public void a(String paramString, int paramInt1, MessageRecord paramMessageRecord, int paramInt2)
  {
    a(paramString, paramInt1, paramInt2);
    b(paramString, paramInt1, paramMessageRecord, paramInt2);
  }
  
  protected void a(String paramString, int paramInt, MessageRecord paramMessageRecord, ProxyListener paramProxyListener)
  {
    if (paramMessageRecord.versionCode > 0) {
      this.proxyManager.addMsgQueueDonotNotify(paramString, paramInt, b(paramString, paramInt), paramMessageRecord, 0, paramProxyListener);
    }
    this.proxyManager.transSaveToDatabase();
  }
  
  protected void a(String paramString, int paramInt, MessageRecord paramMessageRecord, ProxyListener paramProxyListener, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((UinTypeUtil.d(paramMessageRecord.msgtype)) && (!UinTypeUtil.a(paramMessageRecord.frienduin, paramMessageRecord.istroop))) {}
    while (!paramBoolean2) {
      return;
    }
    if (paramBoolean1)
    {
      a(paramString, paramInt, paramMessageRecord, paramProxyListener);
      return;
    }
    a(paramString, paramInt, paramMessageRecord, paramProxyListener);
  }
  
  public void a(String paramString, int paramInt, MessageRecord paramMessageRecord, ProxyListener paramProxyListener, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    a(paramString, paramInt, paramMessageRecord, paramBoolean3);
    a(paramString, paramInt, paramMessageRecord, paramProxyListener, paramBoolean1, paramBoolean2);
  }
  
  protected void a(String paramString, int paramInt, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "insertToList " + paramMessageRecord.getBaseInfoString());
    }
    for (;;)
    {
      localLock = a(paramString, paramInt);
      localLock.lock();
      try
      {
        b(paramString, paramInt, paramMessageRecord, paramBoolean);
        return;
      }
      finally
      {
        localLock.unlock();
      }
      QLog.d("Q.msg.MsgProxy", 1, "insertToList " + paramMessageRecord.getUserLogString());
    }
  }
  
  protected void a(String paramString, int paramInt, Entity paramEntity, ProxyListener paramProxyListener)
  {
    if (((paramEntity instanceof MessageRecord)) && (((MessageRecord)paramEntity).versionCode > 0)) {
      this.proxyManager.addMsgQueue(paramString, paramInt, b(paramString, paramInt), paramEntity, 0, paramProxyListener);
    }
  }
  
  protected void a(String paramString1, int paramInt, String paramString2, ContentValues paramContentValues, String paramString3, String[] paramArrayOfString, ProxyListener paramProxyListener)
  {
    this.proxyManager.addMsgQueue(paramString1, paramInt, paramString2, paramContentValues, paramString3, paramArrayOfString, 1, paramProxyListener);
  }
  
  public void a(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2)
  {
    Lock localLock = a(paramString1, paramInt1);
    localLock.lock();
    try
    {
      b(paramString1, paramInt1, paramString2, paramString3, paramInt2);
      return;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  public void a(String paramString1, int paramInt, String paramString2, String paramString3, String[] paramArrayOfString, ProxyListener paramProxyListener)
  {
    this.proxyManager.addMsgQueue(paramString1, paramInt, paramString2, paramString3, paramArrayOfString, 2, paramProxyListener);
  }
  
  public void a(String paramString, int paramInt, List<MessageRecord> paramList)
  {
    e(paramString, paramInt, paramList);
    Lock localLock = a(paramString, paramInt);
    localLock.lock();
    try
    {
      f(paramString, paramInt, paramList);
      localLock.unlock();
      d(paramString, paramInt, paramList);
      return;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  protected void a(String paramString, int paramInt, Set<String> paramSet)
  {
    paramSet.add(this.app.getAccount());
    paramSet.add(paramString);
  }
  
  public void a(List<MessageRecord> paramList, ProxyListener paramProxyListener)
  {
    b(UinTypeUtil.a(paramList), paramProxyListener);
  }
  
  protected boolean a(int paramInt, long paramLong, MessageRecord paramMessageRecord)
  {
    if (UinTypeUtil.g(paramInt)) {
      if (paramLong < paramMessageRecord.shmsgseq) {}
    }
    while (paramLong >= paramMessageRecord.time)
    {
      return true;
      return false;
    }
    return false;
  }
  
  protected boolean a(String paramString, int paramInt)
  {
    return MessageDBUtils.a(b(paramString, paramInt), b());
  }
  
  protected boolean a(String paramString1, int paramInt, String paramString2, List<MessageRecord> paramList)
  {
    boolean bool = false;
    if (a(paramString1, paramInt, paramString2))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MsgProxy", 2, "insertToAioMsgPool because of orderMediaMsgSending " + paramString1);
      }
      paramString2 = new ArrayList();
      if (paramList.size() <= 15) {
        break label109;
      }
      paramString2.addAll(paramList.subList(paramList.size() - 15, paramList.size()));
    }
    for (;;)
    {
      b(paramString1, paramInt, paramString2);
      bool = true;
      return bool;
      label109:
      paramString2.addAll(paramList);
    }
  }
  
  public boolean a(String paramString, int paramInt, boolean paramBoolean)
  {
    if (paramString == null) {
      return false;
    }
    for (;;)
    {
      int i;
      synchronized (this.proxyManager.getMsgQueueLock())
      {
        Vector localVector = this.proxyManager.getQueue();
        i = 0;
        if (i < localVector.size())
        {
          MsgQueueItem localMsgQueueItem = (MsgQueueItem)localVector.get(i);
          if ((UinTypeUtil.a(localMsgQueueItem.frindUin, paramString, localMsgQueueItem.type, paramInt)) && ((localMsgQueueItem.action == 1) || (localMsgQueueItem.action == 2) || ((paramBoolean) && (localMsgQueueItem.action == 0))))
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.MsgProxy", 2, new Object[] { "needTransSaveToDatabase uin=", paramString, ", type=", LargerInteger.valueOf(paramInt), ", hasInsertAction=", Boolean.valueOf(paramBoolean), ",result=true" });
            }
            return true;
          }
        }
        else
        {
          return false;
        }
      }
      i += 1;
    }
  }
  
  protected boolean a(String paramString, boolean paramBoolean)
  {
    if (paramString == null) {
      return false;
    }
    synchronized (this.proxyManager.getMsgQueueLock())
    {
      Iterator localIterator = this.proxyManager.getQueue().iterator();
      while (localIterator.hasNext())
      {
        MsgQueueItem localMsgQueueItem = (MsgQueueItem)localIterator.next();
        if (TextUtils.isEmpty(localMsgQueueItem.tableName)) {
          return true;
        }
        if ((paramString.equals(localMsgQueueItem.tableName)) && ((localMsgQueueItem.action == 1) || (localMsgQueueItem.action == 2) || ((paramBoolean) && (localMsgQueueItem.action == 0))))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MsgProxy", 2, new Object[] { "needTransSaveToDatabase tableName=", paramString, ", hasInsertAction=", Boolean.valueOf(paramBoolean), ",result=true" });
          }
          return true;
        }
      }
      return false;
    }
  }
  
  protected int b(String paramString, int paramInt)
  {
    Lock localLock = a(paramString, paramInt);
    localLock.lock();
    try
    {
      paramInt = c(paramString, paramInt);
      return paramInt;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  public int b(String paramString, int paramInt, long paramLong)
  {
    MessageRecord localMessageRecord = e(paramString, paramInt, paramLong);
    Object localObject;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("--->removeSingleMsg : peerUin:").append(paramString).append(" type:").append(paramInt).append(" uniseq:").append(paramLong).append(" mr:").append(localMessageRecord).append(" dbid:");
      if (localMessageRecord != null)
      {
        localObject = Long.valueOf(localMessageRecord.getId());
        QLog.d("Q.msg.MsgProxy", 2, localObject);
      }
    }
    else
    {
      if (localMessageRecord == null) {
        break label215;
      }
      long l = localMessageRecord.getId();
      if (l == -1L) {
        break label183;
      }
      a(paramString, paramInt, b(paramString, paramInt), "_id=?", new String[] { String.valueOf(l) }, null);
    }
    for (;;)
    {
      a(localMessageRecord.frienduin, localMessageRecord.istroop);
      if (!localMessageRecord.isread) {
        break label213;
      }
      return 1;
      localObject = "mr is null.";
      break;
      label183:
      a(paramString, paramInt, b(paramString, paramInt), "uniseq=?", new String[] { String.valueOf(paramLong) }, null);
    }
    label213:
    return 2;
    label215:
    a(paramString, paramInt, b(paramString, paramInt), "uniseq=?", new String[] { String.valueOf(paramLong) }, null);
    return 1;
  }
  
  protected SQLiteDatabase b()
  {
    return jdField_a_of_type_ComTencentImcoreMessageBaseMsgProxy$Callback.b(this.app);
  }
  
  public MessageRecord b(String paramString, int paramInt)
  {
    String str1 = b(paramString, paramInt);
    if (a(str1, false)) {
      this.proxyManager.transSaveToDatabase(this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager);
    }
    String str2 = UinTypeUtil.a();
    if (UinTypeUtil.g(paramInt)) {}
    for (paramString = "shmsgseq asc , _id desc";; paramString = "time asc , _id desc")
    {
      paramString = String.format("select * from %s m where m.isValid=1 and m.msgtype %s order by %s limit 1", new Object[] { str1, str2, paramString });
      paramString = a().rawQuery(MessageRecord.class, paramString, null);
      if ((paramString == null) || (paramString.isEmpty())) {
        break;
      }
      return (MessageRecord)paramString.get(0);
    }
    return null;
  }
  
  protected MessageRecord b(String paramString, int paramInt1, int paramInt2)
  {
    String str1 = b(paramString, paramInt1);
    if (a(str1, false)) {
      this.proxyManager.transSaveToDatabase(this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager);
    }
    paramString = new StringBuilder(512);
    paramString.append("select * from %s m where m.isValid=1");
    paramString.append(" order by %s limit 1");
    String str2 = paramString.toString();
    if (UinTypeUtil.g(paramInt1))
    {
      paramString = "shmsgseq desc , _id desc";
      paramString = String.format(str2, new Object[] { str1, paramString });
      paramString = a().rawQuery(MessageRecord.class, paramString, null);
      if ((paramString != null) && (!paramString.isEmpty())) {
        paramInt1 = paramString.size() - 1;
      }
    }
    else
    {
      for (;;)
      {
        if (paramInt1 < 0) {
          break label172;
        }
        if (((MessageRecord)paramString.get(paramInt1)).getConfessTopicId() == paramInt2)
        {
          return (MessageRecord)paramString.get(paramInt1);
          paramString = "time desc , _id desc";
          break;
        }
        paramInt1 -= 1;
      }
    }
    label172:
    return null;
  }
  
  public MessageRecord b(String paramString, int paramInt, long paramLong)
  {
    Object localObject2;
    if ((paramLong == 0L) || (paramString == null) || (paramString.length() == 0))
    {
      localObject2 = null;
      return localObject2;
    }
    Object localObject1 = c(paramString, paramInt);
    if (localObject1 != null)
    {
      localObject2 = ((List)localObject1).iterator();
      do
      {
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localObject1 = (MessageRecord)((Iterator)localObject2).next();
      } while (((MessageRecord)localObject1).uniseq != paramLong);
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (localObject1 != null) {
        break;
      }
      paramString = a(paramString, paramInt, paramLong);
      localObject2 = localObject1;
      if (paramString == null) {
        break;
      }
      localObject2 = localObject1;
      if (paramString.isEmpty()) {
        break;
      }
      return (MessageRecord)paramString.get(0);
      localObject1 = null;
    }
  }
  
  public MessageRecord b(String paramString, int paramInt, long paramLong1, long paramLong2, long paramLong3)
  {
    MessageRecord localMessageRecord = a(paramString, paramInt, paramLong1);
    if (localMessageRecord != null)
    {
      localMessageRecord.time = paramLong2;
      localMessageRecord.shmsgseq = paramLong3;
      f(paramString, paramInt, paramLong1);
      a(paramString, paramInt, localMessageRecord);
    }
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("time", Long.valueOf(paramLong2));
    localContentValues.put("shmsgseq", Long.valueOf(paramLong3));
    if (localMessageRecord != null)
    {
      if (localMessageRecord.getId() > 0L)
      {
        a(paramString, paramInt, localMessageRecord.versionCode, localContentValues, "_id=?", new String[] { String.valueOf(localMessageRecord.getId()) }, null);
        return localMessageRecord;
      }
      a(paramString, paramInt, localMessageRecord.versionCode, localContentValues, "uniseq=?", new String[] { String.valueOf(paramLong1) }, null);
      return localMessageRecord;
    }
    a(paramString, paramInt, 3, localContentValues, "uniseq=?", new String[] { String.valueOf(paramLong1) }, null);
    return localMessageRecord;
  }
  
  @NonNull
  public String b(String paramString, int paramInt)
  {
    return MessageRecord.getTableName(paramString, paramInt);
  }
  
  protected List<MessageRecord> b(String paramString)
  {
    return (List)a().get(paramString);
  }
  
  public List<MessageRecord> b(String paramString, int paramInt)
  {
    Lock localLock = a(paramString, paramInt);
    localLock.lock();
    try
    {
      paramString = a(h(paramString, paramInt));
      return paramString;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  public List<MessageRecord> b(String paramString, int paramInt1, int paramInt2)
  {
    ArrayList localArrayList;
    synchronized (this.proxyManager.getMsgQueueLock())
    {
      Object localObject2 = this.proxyManager.getQueue();
      localArrayList = new ArrayList();
      localObject2 = ((Vector)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        MsgQueueItem localMsgQueueItem = (MsgQueueItem)((Iterator)localObject2).next();
        if ((localMsgQueueItem.item instanceof MessageRecord))
        {
          MessageRecord localMessageRecord = (MessageRecord)localMsgQueueItem.item;
          if ((UinTypeUtil.a(localMessageRecord.frienduin, paramString, localMessageRecord.istroop, paramInt1)) && (localMsgQueueItem.action == 0) && ((paramInt2 <= 0) || (localMessageRecord.getConfessTopicId() == paramInt2))) {
            localArrayList.add(localMessageRecord);
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, new Object[] { "getMsgListFromQueue uin=", paramString, ", type=", Integer.valueOf(paramInt1), ", size=", Integer.valueOf(localArrayList.size()) });
    }
    return localArrayList;
  }
  
  public List<MessageRecord> b(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    Lock localLock = a(paramString, paramInt1);
    localLock.lock();
    try
    {
      paramString = f(paramString, paramInt1, paramLong, paramInt2);
      return paramString;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  protected List<MessageRecord> b(String paramString1, int paramInt1, long paramLong, int paramInt2, String paramString2)
  {
    if (a(paramString1, paramInt1, true)) {
      this.proxyManager.transSaveToDatabase(a());
    }
    String str1;
    String str2;
    if (paramInt2 > 0)
    {
      str1 = "limit " + paramInt2;
      str2 = "select * from " + b(paramString1, paramInt1) + " where time<%d %s order by time desc, _id desc %s";
      if (paramString2 != null) {
        break label271;
      }
    }
    label271:
    for (paramString2 = "";; paramString2 = "and " + paramString2)
    {
      paramString2 = String.format(str2, new Object[] { Long.valueOf(paramLong), paramString2, str1 });
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MsgProxy", 2, "queryMessageByTime: sql=" + paramString2 + ", peeruin = " + paramString1 + ", type = " + paramInt1);
      }
      paramString2 = jdField_a_of_type_ComTencentImcoreMessageBaseMsgProxy$Callback.a(paramString2, null, this);
      if (paramString2 != null) {
        Collections.reverse(paramString2);
      }
      if (paramString2 == null) {
        break label297;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MsgProxy", 2, "queryMessageByTime: list size =" + paramString2.size() + ", peeruin = " + paramString1 + ", type = " + paramInt1);
      }
      return paramString2;
      str1 = "";
      break;
    }
    label297:
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "queryMessageByTime: null list , peeruin = " + paramString1 + ", type = " + paramInt1);
    }
    return new ArrayList();
  }
  
  public List<MessageRecord> b(String paramString, int paramInt, long paramLong1, long paramLong2)
  {
    if ((paramLong1 == 0L) || (paramLong2 == 0L) || (paramString == null) || (paramString.length() == 0)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject = c(paramString, paramInt);
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
        if ((localMessageRecord.time == paramLong1) && (localMessageRecord.msgUid == paramLong2)) {
          localArrayList.add(localMessageRecord);
        }
      }
    }
    if (localArrayList.isEmpty())
    {
      paramString = e(paramString, paramInt, paramLong1, paramLong2);
      if ((paramString != null) && (!paramString.isEmpty())) {
        localArrayList.addAll(paramString);
      }
    }
    return localArrayList;
  }
  
  public List<MessageRecord> b(String paramString, int paramInt, List<Integer> paramList)
  {
    Object localObject = paramList;
    if (paramList.size() > 50) {
      localObject = paramList.subList(0, 50);
    }
    paramString = b(paramString, paramInt);
    paramList = new String[1];
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = ((List)localObject).iterator();
    while (localIterator.hasNext())
    {
      paramList[0] = String.valueOf(((Integer)localIterator.next()).intValue());
      localObject = a().query(false, paramString, null, "_id = ?", paramList, null, null, null, null);
      if (localObject != null) {}
      try
      {
        localArrayList.add((MessageRecord)a().cursor2Entity(MessageRecord.class, null, (Cursor)localObject));
        if (localObject != null) {
          ((Cursor)localObject).close();
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.msg.MsgProxy", 2, localException, new Object[0]);
        }
        if (localObject != null) {
          ((Cursor)localObject).close();
        }
      }
      finally
      {
        if (localObject != null) {
          ((Cursor)localObject).close();
        }
      }
    }
    return localArrayList;
  }
  
  protected List<MessageRecord> b(List<MessageRecord> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = new ArrayList(paramList);
    HashSet localHashSet = new HashSet();
    int i = paramList.size() - 1;
    if (i >= 0)
    {
      if (localHashSet.contains(UinTypeUtil.b((MessageRecord)paramList.get(i)))) {
        localArrayList.add(paramList.get(i));
      }
      for (;;)
      {
        i -= 1;
        break;
        localHashSet.add(UinTypeUtil.b((MessageRecord)paramList.get(i)));
      }
    }
    paramList.removeAll(localArrayList);
    Collections.reverse(paramList);
    return paramList;
  }
  
  @Deprecated
  protected AppRuntime b()
  {
    return this.app;
  }
  
  public void b()
  {
    a().clear();
    a().clear();
  }
  
  protected void b(QueryHistoryParam paramQueryHistoryParam)
  {
    jdField_a_of_type_ComTencentImcoreMessageBaseMsgProxy$Callback.a(this.app, this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager, paramQueryHistoryParam);
  }
  
  protected void b(String paramString, int paramInt, long paramLong)
  {
    Lock localLock = a(paramString, paramInt);
    localLock.lock();
    try
    {
      c(paramString, paramInt, paramLong);
      return;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  protected void b(String paramString, int paramInt, long paramLong, List<MessageRecord> paramList)
  {
    Object localObject1 = a(paramString, paramInt);
    int i;
    Object localObject2;
    if (a().containsKey(localObject1))
    {
      localObject1 = a((String)localObject1);
      i = 0;
      if (i >= ((List)localObject1).size()) {
        break label320;
      }
      localObject2 = (MessageRecord)((List)localObject1).get(i);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MsgProxy", 2, "find cache " + ((MessageRecord)localObject2).getBaseInfoString());
      }
      if (((MessageRecord)localObject2).uniseq != paramLong) {}
    }
    for (;;)
    {
      if ((i > 0) && (i < ((List)localObject1).size()))
      {
        localObject2 = new ArrayList();
        int j = 0;
        for (;;)
        {
          if (j < i)
          {
            MessageRecord localMessageRecord = (MessageRecord)((List)localObject1).get(j);
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.MsgProxy", 2, "removeList " + localMessageRecord.getBaseInfoString());
            }
            ((List)localObject2).add(localMessageRecord);
            j += 1;
            continue;
            i += 1;
            break;
          }
        }
        ((List)localObject1).removeAll((Collection)localObject2);
        ((List)localObject2).clear();
        ((List)localObject1).addAll(0, paramList);
      }
      while (((List)localObject1).size() > 40)
      {
        i = ((List)localObject1).size() - 40;
        while (i > 0)
        {
          ((List)localObject1).remove(0);
          i -= 1;
        }
        if (i == 0) {
          ((List)localObject1).addAll(0, paramList);
        }
      }
      c(paramString, paramInt, (List)localObject1);
      return;
      label320:
      i = 0;
    }
  }
  
  public void b(String paramString, int paramInt, MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord == null) || (paramMessageRecord.uniseq != 0L)) {}
    do
    {
      return;
      if (paramMessageRecord.getId() > 0L)
      {
        paramMessageRecord.createMessageUniseq();
        ContentValues localContentValues = new ContentValues();
        localContentValues.put("uniseq", Long.valueOf(paramMessageRecord.uniseq));
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MsgProxy", 2, "updateUniseqByID: set msg =" + paramMessageRecord.getBaseInfoString());
        }
        a(paramString, paramInt, paramMessageRecord.versionCode, localContentValues, "_id=?", new String[] { String.valueOf(paramMessageRecord.getId()) }, null);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.w("Q.msg.MsgProxy", 2, "updateUniseqByID ERROR: _id<0 !");
  }
  
  public void b(String paramString, int paramInt1, MessageRecord paramMessageRecord, int paramInt2)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("isread", Boolean.valueOf(true));
    String str;
    if (((paramInt1 == 1001) || (paramInt1 == 10002)) && (paramMessageRecord.msgtype != -1003) && (paramMessageRecord.msgtype != -1031) && (paramMessageRecord.msgtype != -1032) && (paramMessageRecord.msgtype != 201)) {
      if (paramMessageRecord.versionCode > 0)
      {
        str = b(String.valueOf(AppConstants.LBS_HELLO_UIN), 1001);
        a(paramString, paramInt1, str, localContentValues, "senderuin=? and isread=?", new String[] { paramString, "0" }, null);
        a(paramString, paramInt1, paramMessageRecord.versionCode, localContentValues, "isread=?", new String[] { "0" }, null);
      }
    }
    do
    {
      return;
      str = d(String.valueOf(AppConstants.LBS_HELLO_UIN), 1001);
      break;
      if (paramInt1 == 1009)
      {
        a(paramString, paramInt1, b(AppConstants.SAME_STATE_BOX_UIN, 1009), localContentValues, "senderuin=? and isread=?", new String[] { paramString, "0" }, null);
        a(paramString, paramInt1, paramMessageRecord.versionCode, localContentValues, "isread=?", new String[] { "0" }, null);
        return;
      }
      if (paramInt1 == 1010)
      {
        a(paramString, paramInt1, b(AppConstants.DATE_UIN, 1010), localContentValues, "senderuin=? and isread=?", new String[] { paramString, "0" }, null);
        a(paramString, paramInt1, paramMessageRecord.versionCode, localContentValues, "isread=?", new String[] { "0" }, null);
        return;
      }
      if ((paramInt1 == 0) && (TextUtils.equals(paramString, AppConstants.FRIEND_SYSTEM_MSG_UIN)))
      {
        a(paramString, paramInt1, b(AppConstants.FRIEND_SYSTEM_MSG_UIN, 0), localContentValues, "senderuin=? and isread=?", new String[] { paramString, "0" }, null);
        a(paramString, paramInt1, paramMessageRecord.versionCode, localContentValues, "isread=?", new String[] { "0" }, null);
        return;
      }
    } while ((paramInt1 != 1032) || (!TextUtils.equals(paramString, AppConstants.CONFESS_UIN)));
    a(paramString, paramInt1, b(paramString, paramInt1), localContentValues, "isread=?", new String[] { "0" }, null);
  }
  
  protected void b(String paramString, int paramInt, List<MessageRecord> paramList)
  {
    a().put(a(paramString, paramInt), paramList);
  }
  
  protected int c(String paramString, int paramInt, long paramLong)
  {
    int i = 0;
    if (paramString == null) {
      return 0;
    }
    for (;;)
    {
      synchronized (this.proxyManager.getMsgQueueLock())
      {
        Iterator localIterator = this.proxyManager.getQueue().iterator();
        if (localIterator.hasNext())
        {
          MsgQueueItem localMsgQueueItem = (MsgQueueItem)localIterator.next();
          if ((localMsgQueueItem.item instanceof MessageRecord))
          {
            MessageRecord localMessageRecord = (MessageRecord)localMsgQueueItem.item;
            if ((UinTypeUtil.a(localMessageRecord.frienduin, paramString, localMessageRecord.istroop, paramInt)) && (localMsgQueueItem.action == 0) && (localMessageRecord.time > paramLong) && (!localMessageRecord.isread) && (!localMessageRecord.isSend())) {
              i += 1;
            }
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MsgProxy", 2, new Object[] { "getUnreadCountFromQueue uin=", paramString, ", type=", Integer.valueOf(paramInt), ", lastRead=", Integer.valueOf(i) });
          }
          return i;
        }
      }
    }
  }
  
  public MessageRecord c(String paramString, int paramInt, long paramLong)
  {
    if ((paramLong == 0L) || (paramString == null) || (paramString.length() == 0)) {
      return null;
    }
    Object localObject = c(paramString, paramInt);
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
        if (localMessageRecord.shmsgseq == paramLong) {
          return localMessageRecord;
        }
      }
    }
    return i(paramString, paramInt, paramLong);
  }
  
  protected String c(String paramString, int paramInt)
  {
    if (UinTypeUtil.a(paramString)) {
      return "select * from " + b(paramString, paramInt) + " order by time desc , _id desc";
    }
    if (UinTypeUtil.b(paramInt)) {
      return "select * from " + b(paramString, paramInt) + " where _id in (select _id from " + b(paramString, paramInt) + " order by time desc limit " + 40 + ") order by time desc, _id desc";
    }
    return "select * from " + b(paramString, paramInt) + " order by _id desc limit " + 40;
  }
  
  protected List<MessageRecord> c(String paramString)
  {
    ArrayList localArrayList;
    synchronized (this.proxyManager.getMsgQueueLock())
    {
      Object localObject2 = this.proxyManager.getQueue();
      localArrayList = new ArrayList();
      localObject2 = ((Vector)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        MsgQueueItem localMsgQueueItem = (MsgQueueItem)((Iterator)localObject2).next();
        if ((localMsgQueueItem.item instanceof MessageRecord))
        {
          MessageRecord localMessageRecord = (MessageRecord)localMsgQueueItem.item;
          if ((TextUtils.equals(paramString, localMsgQueueItem.tableName)) && (localMsgQueueItem.action == 0)) {
            localArrayList.add(localMessageRecord);
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, new Object[] { "getMsgListFromQueue tableName=", paramString, ", size=", Integer.valueOf(localArrayList.size()) });
    }
    return localArrayList;
  }
  
  public List<MessageRecord> c(String paramString, int paramInt)
  {
    Lock localLock = a(paramString, paramInt);
    localLock.lock();
    try
    {
      paramString = g(paramString, paramInt);
      return paramString;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  @Nullable
  protected List<MessageRecord> c(String paramString, int paramInt1, int paramInt2)
  {
    paramString = h(paramString, paramInt1);
    if (paramString != null) {
      return (List)((ArrayList)paramString).clone();
    }
    return null;
  }
  
  public List<MessageRecord> c(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "queryBeforeHistoryByShmsgseq uin=" + paramString + ", type=" + paramInt1 + ", seq=" + paramLong + ", count=" + paramInt2);
    }
    if (a(paramString, paramInt1, true)) {
      this.proxyManager.transSaveToDatabase();
    }
    Object localObject1 = b(paramString, paramInt1);
    Object localObject2 = "select * from " + (String)localObject1 + " where (shmsgseq < ? and msgtype " + UinTypeUtil.a() + " and isValid=1) order by shmsgseq desc limit ";
    String[] arrayOfString = new String[1];
    arrayOfString[0] = String.valueOf(paramLong);
    localObject1 = jdField_a_of_type_ComTencentImcoreMessageBaseMsgProxy$Callback.a((String)localObject2 + paramInt2, arrayOfString, this);
    if (localObject1 == null) {
      localObject1 = new ArrayList();
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MsgProxy", 2, "queryBeforeHistoryByShmsgseq list.size=" + ((List)localObject1).size());
      }
      if (((List)localObject1).size() < paramInt2)
      {
        paramString = jdField_a_of_type_ComTencentImcoreMessageBaseMsgProxy$Callback.a(paramString, paramInt1, paramLong, paramInt2 - ((List)localObject1).size(), (String)localObject2, arrayOfString, this, this.app);
        if (paramString != null) {
          ((List)localObject1).addAll(paramString);
        }
      }
      Collections.reverse((List)localObject1);
      if (QLog.isColorLevel())
      {
        paramString = ((List)localObject1).iterator();
        while (paramString.hasNext())
        {
          localObject2 = (MessageRecord)paramString.next();
          QLog.d("Q.msg.MsgProxy", 2, "queryBeforeHistoryByShmsgseq " + ((MessageRecord)localObject2).time + ", " + ((MessageRecord)localObject2).getId() + ", " + ((MessageRecord)localObject2).getLogColorContent());
        }
        QLog.d("Q.msg.MsgProxy", 2, "queryBeforeHistoryByShmsgseq return size=" + ((List)localObject1).size());
      }
      return localObject1;
    }
  }
  
  protected List<MessageRecord> c(String paramString1, int paramInt1, long paramLong, int paramInt2, String paramString2)
  {
    if (a(paramString1, paramInt1, true)) {
      this.proxyManager.transSaveToDatabase(a());
    }
    String str = "select * from " + b(paramString1, paramInt1) + " where shmsgseq<=? and shmsgseq>? %s order by shmsgseq asc";
    long l;
    if (paramString2 == null)
    {
      paramString2 = "";
      paramString2 = String.format(str, new Object[] { paramString2 });
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MsgProxy", 2, "queryMessageBySeq: sql=" + paramString2 + ", peeruin = " + paramString1 + ", type = " + paramInt1);
      }
      if (paramInt2 > 0) {
        break label265;
      }
      l = 0L;
    }
    for (;;)
    {
      paramString2 = jdField_a_of_type_ComTencentImcoreMessageBaseMsgProxy$Callback.a(paramString2, new String[] { String.valueOf(paramLong), String.valueOf(l) }, this);
      if (paramString2 == null) {
        break label289;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MsgProxy", 2, "queryMessageBySeq: list size =" + paramString2.size() + ", peeruin = " + paramString1 + ", type = " + paramInt1);
      }
      return paramString2;
      paramString2 = "and " + paramString2;
      break;
      label265:
      if (paramLong > paramInt2) {
        l = paramLong - paramInt2;
      } else {
        l = 0L;
      }
    }
    label289:
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "queryMessageBySeq: null list , peeruin = " + paramString1 + ", type = " + paramInt1);
    }
    return new ArrayList();
  }
  
  public List<MessageRecord> c(String paramString, int paramInt, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "queryMessageFromBySeq, peerUin = " + paramString + ", type " + paramInt + ",beginSeq = " + paramLong1 + ",endSeq = " + paramLong2);
    }
    if (a(paramString, paramInt, true)) {
      this.proxyManager.transSaveToDatabase(a());
    }
    paramString = "select * from " + b(paramString, paramInt) + " where shmsgseq>=? and shmsgseq<=? order by shmsgseq asc";
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "queryMessageFromBySeq " + paramString);
    }
    List localList = jdField_a_of_type_ComTencentImcoreMessageBaseMsgProxy$Callback.a(paramString, new String[] { String.valueOf(paramLong1), String.valueOf(paramLong2) }, this);
    paramString = localList;
    if (localList == null) {
      paramString = new ArrayList();
    }
    return paramString;
  }
  
  public List<MessageRecord> c(String paramString, int paramInt, List<MessageRecord> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramInt == 0) || (paramInt == 1000) || (paramInt == 1004) || (paramInt == 1044) || (paramInt == 1045)) {
      return a(paramString, paramInt, paramList, localArrayList);
    }
    localArrayList.addAll(paramList);
    return localArrayList;
  }
  
  public void c()
  {
    e();
    EntityTransaction localEntityTransaction = a().getTransaction();
    SQLiteDatabase localSQLiteDatabase = a();
    String[] arrayOfString = localSQLiteDatabase.getAllTableNameFromCache();
    if (arrayOfString == null) {
      return;
    }
    int i = 0;
    while (i < arrayOfString.length)
    {
      a(localEntityTransaction, localSQLiteDatabase, arrayOfString, i);
      i += 1;
    }
    jdField_a_of_type_ComTencentImcoreMessageBaseMsgProxy$Callback.a(this, this.app);
  }
  
  protected void c(String paramString, int paramInt, List<MessageRecord> paramList)
  {
    try
    {
      paramString = UinTypeUtil.a(paramString, paramInt);
      a().put(paramString, paramList);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public MessageRecord d(String paramString, int paramInt, long paramLong)
  {
    if ((paramLong == 0L) || (paramString == null) || (paramString.length() == 0)) {
      return null;
    }
    Object localObject = c(paramString, paramInt);
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
        if ((localMessageRecord.shmsgseq == paramLong) && (!jdField_a_of_type_ComTencentImcoreMessageBaseMsgProxy$Callback.a(localMessageRecord))) {
          return localMessageRecord;
        }
      }
    }
    return j(paramString, paramInt, paramLong);
  }
  
  @NonNull
  protected String d(String paramString, int paramInt)
  {
    return MessageRecord.getOldTableName(paramString, paramInt);
  }
  
  public List<MessageRecord> d(String paramString, int paramInt)
  {
    Lock localLock = a(paramString, paramInt);
    localLock.lock();
    try
    {
      paramString = a(e(paramString, paramInt));
      return paramString;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  protected List<MessageRecord> d(String paramString, int paramInt1, int paramInt2)
  {
    if (a(paramString, paramInt1, true)) {
      this.proxyManager.transSaveToDatabase(a());
    }
    Object localObject = String.format("select _id, extraflag, frienduin, isread, issend, istroop, msg, NULL as msgData, msgId, msgseq, msgtype, selfuin, senderuin, shmsgseq, time, 0 as versionCode, NULL as longMsgIndex, NULL as longMsgId, NULL as longMsgCount, 1 as isValid, NULL as msgUid, NULL as vipBubbleID, 0 as uniseq, 0 as sendFailCode, NULL as extStr, 0 as extInt, 0 as extLong from ( select _id, extraflag, frienduin, isread, issend, istroop, msg, NULL as msgData, msgId, msgseq, msgtype, selfuin, senderuin, shmsgseq, time, 0 as versionCode, NULL as longMsgIndex, NULL as longMsgId, NULL as longMsgCount, 1 as isValid, NULL as msgUid, NULL as vipBubbleID, 0 as uniseq, 0 as sendFailCode, NULL as extStr, 0 as extInt, 0 as extLong from " + d(paramString, paramInt1) + " order by _id desc limit " + paramInt2 + " ) order by _id asc", new Object[0]);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "queryMessageFromOldDB: sqlStr=" + (String)localObject + ", peeruin = " + paramString + ", type = " + paramInt1);
    }
    localObject = jdField_a_of_type_ComTencentImcoreMessageBaseMsgProxy$Callback.a((String)localObject, null, this);
    if (localObject != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MsgProxy", 2, "queryMessageFromOldDB: list size =" + ((List)localObject).size() + ", peeruin = " + paramString + ", type = " + paramInt1);
      }
      return localObject;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "queryMessageFromOldDB: null list , peeruin = " + paramString + ", type = " + paramInt1);
    }
    return new ArrayList();
  }
  
  public List<MessageRecord> d(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "queryLaterHistoryByShmsgseq uin=" + paramString + ", type=" + paramInt1 + ", seq=" + paramLong + ", count=" + paramInt2);
    }
    if (a(paramString, paramInt1, true)) {
      this.proxyManager.transSaveToDatabase();
    }
    Object localObject2 = b(paramString, paramInt1);
    Object localObject1 = "select * from " + (String)localObject2 + " where (shmsgseq >= ? and msgtype " + UinTypeUtil.a() + " and isValid=1) order by shmsgseq asc limit " + (paramInt2 + 1);
    String[] arrayOfString = new String[1];
    arrayOfString[0] = String.valueOf(paramLong);
    localObject1 = jdField_a_of_type_ComTencentImcoreMessageBaseMsgProxy$Callback.a((String)localObject1, arrayOfString, this);
    if (localObject1 == null)
    {
      localObject1 = new ArrayList();
      return localObject1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "queryLaterHistoryByShmsgseq list.size=" + ((List)localObject1).size());
    }
    if ((((List)localObject1).size() > 0) && (((MessageRecord)((List)localObject1).get(0)).shmsgseq == paramLong))
    {
      ((List)localObject1).remove(0);
      paramString = (String)localObject1;
    }
    for (;;)
    {
      localObject1 = paramString;
      if (!QLog.isColorLevel()) {
        break;
      }
      localObject1 = paramString.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (MessageRecord)((Iterator)localObject1).next();
        QLog.d("Q.msg.MsgProxy", 2, "queryLaterHistoryByShmsgseq " + ((MessageRecord)localObject2).time + ", " + ((MessageRecord)localObject2).getId() + ", " + ((MessageRecord)localObject2).getLogColorContent());
      }
      paramString = jdField_a_of_type_ComTencentImcoreMessageBaseMsgProxy$Callback.b(paramString, paramInt1, paramLong, paramInt2, (String)localObject2, arrayOfString, this, this.app);
      if (paramString != null)
      {
        if (paramString.size() == paramInt2) {
          continue;
        }
        ((List)localObject1).addAll(0, paramString);
        if (((List)localObject1).size() > paramInt2) {
          ((List)localObject1).subList(paramInt2, ((List)localObject1).size()).clear();
        }
      }
      paramString = (String)localObject1;
    }
    QLog.d("Q.msg.MsgProxy", 2, "queryLaterHistoryByShmsgseq return size=" + paramString.size());
    return paramString;
  }
  
  public List<MessageRecord> d(String paramString, int paramInt, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "queryMessageFromSeqRange, peerUin = " + paramString + ", type " + paramInt + ",beginSeq = " + paramLong1 + ",endSeq = " + paramLong2);
    }
    Object localObject1 = b(paramString, paramInt);
    ArrayList localArrayList = new ArrayList();
    Object localObject2;
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (MessageRecord)((Iterator)localObject1).next();
        if ((((MessageRecord)localObject2).shmsgseq >= paramLong1) && (((MessageRecord)localObject2).shmsgseq <= paramLong2)) {
          localArrayList.add(localObject2);
        }
      }
    }
    if ((localArrayList.size() > 0) && (((MessageRecord)localArrayList.get(0)).shmsgseq == paramLong1)) {
      return localArrayList;
    }
    if (a(paramString, paramInt, true)) {
      this.proxyManager.transSaveToDatabase(a());
    }
    localObject1 = "select * from " + b(paramString, paramInt) + " where shmsgseq>=? and shmsgseq<=? order by shmsgseq asc";
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "queryMessageFromBySeq " + (String)localObject1);
    }
    if (localArrayList.size() > 0) {
      paramLong2 = ((MessageRecord)localArrayList.get(0)).shmsgseq;
    }
    paramLong1 = Math.min(paramLong1, paramLong2);
    if (localArrayList != null)
    {
      localObject2 = localArrayList.iterator();
      MessageRecord localMessageRecord;
      do
      {
        for (;;)
        {
          if (!((Iterator)localObject2).hasNext()) {
            break label380;
          }
          localMessageRecord = (MessageRecord)((Iterator)localObject2).next();
          if (localMessageRecord.shmsgseq != paramLong2) {
            break;
          }
          ((Iterator)localObject2).remove();
        }
      } while (localMessageRecord.shmsgseq <= paramLong2);
    }
    label380:
    localObject1 = jdField_a_of_type_ComTencentImcoreMessageBaseMsgProxy$Callback.a((String)localObject1, new String[] { String.valueOf(paramLong1), String.valueOf(paramLong2) }, this);
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder().append("queryMessageFromTimeRange, peerUin = ").append(paramString).append(", type ").append(paramInt).append(",queryBeginSeq = ").append(paramLong1).append(",queryEndSeq = ").append(paramLong2).append(",resultSize=");
      if (localObject1 != null) {
        break label513;
      }
    }
    label513:
    for (paramInt = 0;; paramInt = ((List)localObject1).size())
    {
      QLog.d("Q.msg.MsgProxy", 2, paramInt);
      if (localObject1 != null) {
        localArrayList.addAll(0, (Collection)localObject1);
      }
      return localArrayList;
    }
  }
  
  protected List<MessageRecord> d(String paramString, int paramInt, List<Long> paramList)
  {
    int j = 0;
    Object localObject;
    int i;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("queryMessagesByMsgUniseqFromDB, peerUin[").append(MsfSdkUtils.getShortUin(paramString)).append("] type[").append(paramInt).append("] uniseqList[");
      if (paramList == null)
      {
        i = 0;
        QLog.d("Q.msg.MsgProxy", 2, i + "]");
      }
    }
    else
    {
      if ((paramList != null) && (paramList.size() != 0)) {
        break label125;
      }
      if (QLog.isColorLevel()) {
        QLog.e("Q.msg.MsgProxy", 2, "queryMessagesByMsgUniseqFromDB Warning! uniseq==0");
      }
      paramString = new ArrayList();
    }
    label125:
    do
    {
      return paramString;
      i = paramList.size();
      break;
      if (a(paramString, paramInt, true)) {
        this.proxyManager.transSaveToDatabase(a());
      }
      localObject = new String[paramList.size()];
      StringBuilder localStringBuilder = new StringBuilder("(");
      i = j;
      while (i < paramList.size())
      {
        localObject[i] = String.valueOf(((Long)paramList.get(i)).longValue());
        localStringBuilder.append("?");
        if (i < paramList.size() - 1) {
          localStringBuilder.append(",");
        }
        i += 1;
      }
      localStringBuilder.append(")");
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MsgProxy", 2, "queryMessagesByMsgUniseqFromDB, uniseq list=" + localStringBuilder.toString());
      }
      paramString = "select * from " + b(paramString, paramInt) + " where uniseq in " + localStringBuilder.toString();
      paramList = jdField_a_of_type_ComTencentImcoreMessageBaseMsgProxy$Callback.a(paramString, (String[])localObject, this);
      paramString = paramList;
    } while (paramList != null);
    return new ArrayList();
  }
  
  public void d()
  {
    if ((this.proxyManager.getQueue() != null) && (this.proxyManager.getQueue().size() > 0)) {
      this.proxyManager.transSaveToDatabase(this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager);
    }
  }
  
  protected void d(String paramString, int paramInt, List<MessageRecord> paramList)
  {
    jdField_a_of_type_ComTencentImcoreMessageBaseMsgProxy$Callback.b(paramString, paramInt, paramList);
  }
  
  public void destroy()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager != null) && (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.isOpen())) {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.close();
    }
  }
  
  public MessageRecord e(String paramString, int paramInt, long paramLong)
  {
    Lock localLock = a(paramString, paramInt);
    localLock.lock();
    try
    {
      paramString = k(paramString, paramInt, paramLong);
      return paramString;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  public List<MessageRecord> e(String paramString, int paramInt)
  {
    return a(paramString, paramInt, 0, false);
  }
  
  protected List<MessageRecord> e(String paramString, int paramInt1, int paramInt2)
  {
    if (a(paramString, paramInt1, true)) {
      this.proxyManager.transSaveToDatabase(a());
    }
    Object localObject = String.format("select * from " + b(paramString, paramInt1) + " where isValid=1 and msgtype != ? order by shmsgseq desc , _id desc limit ?", new Object[0]);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "queryValidMessageBySeq: sql=" + (String)localObject + ", peeruin = " + paramString + ", type = " + paramInt1);
    }
    localObject = jdField_a_of_type_ComTencentImcoreMessageBaseMsgProxy$Callback.a((String)localObject, new String[] { String.valueOf(-2006), String.valueOf(paramInt2) }, this);
    if (localObject != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MsgProxy", 2, "queryValidMessageBySeq: list size =" + ((List)localObject).size() + ", peeruin = " + paramString + ", type = " + paramInt1);
      }
      return localObject;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "queryValidMessageBySeq: null list , peeruin = " + paramString + ", type = " + paramInt1);
    }
    return new ArrayList();
  }
  
  protected List<MessageRecord> e(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    if (UinTypeUtil.g(paramInt1)) {}
    for (List localList = d(paramString, paramInt1, paramLong, 2147483647L);; localList = a(paramString, paramInt1, paramLong, 2147483647L, paramInt2))
    {
      Object localObject = localList;
      if (localList == null) {
        localObject = new ArrayList();
      }
      b(paramString, paramInt1, (List)localObject);
      return localObject;
    }
  }
  
  protected List<MessageRecord> e(String paramString, int paramInt, long paramLong1, long paramLong2)
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "queryMessagesByTimeFromDB, peerUin[" + MsfSdkUtils.getShortUin(paramString) + "] type[" + paramInt + "] time[" + paramLong1 + "] uid[" + paramLong2 + "]");
    }
    if ((paramLong2 == 0L) && (QLog.isColorLevel())) {
      QLog.e("Q.msg.MsgProxy", 2, "queryMessagesByTimeFromDB Warning! msgseq == 0 || msgUid == 0");
    }
    if (a(paramString, paramInt, true)) {
      this.proxyManager.transSaveToDatabase(a());
    }
    Object localObject = "select * from " + b(paramString, paramInt) + " where time=? and msgUid=?";
    localObject = jdField_a_of_type_ComTencentImcoreMessageBaseMsgProxy$Callback.a((String)localObject, new String[] { String.valueOf(paramLong1), String.valueOf(paramLong2) }, this);
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder().append("queryMessagesByTimeFromDB, peerUin[").append(MsfSdkUtils.getShortUin(paramString)).append("] type[").append(paramInt).append("] time[").append(paramLong1).append("] uid[").append(paramLong2).append("], list.size():");
      if (localObject != null) {
        break label277;
      }
    }
    label277:
    for (paramInt = i;; paramInt = ((List)localObject).size())
    {
      QLog.d("Q.msg.MsgProxy", 2, paramInt);
      if (localObject == null) {
        break;
      }
      return localObject;
    }
    return new ArrayList();
  }
  
  void e()
  {
    this.proxyManager.transSaveToDatabase();
    this.proxyManager.clearMsgQueue();
  }
  
  protected void e(String paramString, int paramInt, List<MessageRecord> paramList)
  {
    jdField_a_of_type_ComTencentImcoreMessageBaseMsgProxy$Callback.a(paramString, paramInt, paramList);
  }
  
  public MessageRecord f(String paramString, int paramInt, long paramLong)
  {
    Lock localLock = a(paramString, paramInt);
    localLock.lock();
    try
    {
      paramString = m(paramString, paramInt, paramLong);
      return paramString;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  public List<MessageRecord> f(String paramString, int paramInt)
  {
    Lock localLock = a(paramString, paramInt);
    localLock.lock();
    try
    {
      paramString = k(paramString, paramInt);
      return paramString;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  protected List<MessageRecord> f(String paramString, int paramInt, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "queryMessagesByShmsgseqFromDB, peerUin[" + MsfSdkUtils.getShortUin(paramString) + "] type[" + paramInt + "] shmsgseq[" + paramLong1 + "] msgUid[" + paramLong2 + "]");
    }
    if (((paramLong1 == 0L) || (paramLong2 == 0L)) && (QLog.isColorLevel())) {
      QLog.e("Q.msg.MsgProxy", 2, "queryMessagesByShmsgseqFromDB Warning! shmsgseq == 0 || msgUid == 0");
    }
    if (a(paramString, paramInt, true)) {
      this.proxyManager.transSaveToDatabase(a());
    }
    paramString = "select * from " + b(paramString, paramInt) + " where shmsgseq=? and msgUid=?";
    paramString = jdField_a_of_type_ComTencentImcoreMessageBaseMsgProxy$Callback.a(paramString, new String[] { String.valueOf(paramLong1), String.valueOf(paramLong2) }, this);
    if (paramString != null) {
      return paramString;
    }
    return new ArrayList();
  }
  
  protected void f(String paramString, int paramInt, List<MessageRecord> paramList)
  {
    if (a().containsKey(a(paramString, paramInt)))
    {
      List localList = b(a(paramString, paramInt));
      Object localObject = localList;
      if (localList == null) {
        localObject = new ArrayList();
      }
      localList = UinTypeUtil.a((List)localObject, paramList);
      jdField_a_of_type_ComTencentImcoreMessageBaseMsgProxy$Callback.a(paramString, paramInt, localList, (List)localObject, this.app);
      paramList.clear();
      paramList.addAll(localList);
    }
  }
  
  public MessageRecord g(String paramString, int paramInt, long paramLong)
  {
    MessageRecord localMessageRecord = c(paramString, paramInt, paramLong);
    if (localMessageRecord != null) {
      return localMessageRecord;
    }
    return jdField_a_of_type_ComTencentImcoreMessageBaseMsgProxy$Callback.a(paramString, paramInt, paramLong, this, this.app);
  }
  
  @Nullable
  protected List<MessageRecord> g(String paramString, int paramInt)
  {
    paramString = a(a(paramString, paramInt));
    if (paramString != null) {
      return (List)((ArrayList)paramString).clone();
    }
    return null;
  }
  
  protected MessageRecord h(String paramString, int paramInt, long paramLong)
  {
    Lock localLock = a(paramString, paramInt);
    localLock.lock();
    try
    {
      paramString = l(paramString, paramInt, paramLong);
      return paramString;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  public List<MessageRecord> h(String paramString, int paramInt)
  {
    String str = a(paramString, paramInt);
    Lock localLock = a(paramString, paramInt);
    localLock.lock();
    try
    {
      paramString = a(paramString, paramInt, str);
      return paramString;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  protected MessageRecord i(String paramString, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "queryMessagesByShmsgseqFromDB, peerUin[" + MsfSdkUtils.getShortUin(paramString) + "] type[" + paramInt + "] shmsgseq[" + paramLong + "]");
    }
    if ((paramLong == 0L) && (QLog.isColorLevel())) {
      QLog.e("Q.msg.MsgProxy", 2, "queryMessagesByShmsgseqFromDB Warning! shmsgseq == 0 || msgUid == 0");
    }
    if (a(paramString, paramInt, true)) {
      this.proxyManager.transSaveToDatabase(a());
    }
    Object localObject = "select * from " + b(paramString, paramInt) + " where shmsgseq=?";
    localObject = jdField_a_of_type_ComTencentImcoreMessageBaseMsgProxy$Callback.a((String)localObject, new String[] { String.valueOf(paramLong) }, this);
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder().append("queryMessagesByShmsgseqFromDB, peerUin[").append(MsfSdkUtils.getShortUin(paramString)).append("] type[").append(paramInt).append("] shmsgseq[").append(paramLong).append("], list.size():");
      if (localObject != null) {
        break label251;
      }
    }
    label251:
    for (paramInt = 0;; paramInt = ((List)localObject).size())
    {
      QLog.d("Q.msg.MsgProxy", 2, paramInt);
      if (localObject == null) {
        break;
      }
      return (MessageRecord)((List)localObject).get(0);
    }
    return null;
  }
  
  protected List<MessageRecord> i(String paramString, int paramInt)
  {
    return b(paramString, paramInt, 0);
  }
  
  public void init() {}
  
  protected MessageRecord j(String paramString, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "queryMessagesByShmsgseqFromDB4Troop, peerUin[" + MsfSdkUtils.getShortUin(paramString) + "] type[" + paramInt + "] shmsgseq[" + paramLong + "]");
    }
    if ((paramLong == 0L) && (QLog.isColorLevel())) {
      QLog.e("Q.msg.MsgProxy", 2, "queryMessagesByShmsgseqFromDB4Troop Warning! shmsgseq == 0");
    }
    if (a(paramString, paramInt, true)) {
      this.proxyManager.transSaveToDatabase(a());
    }
    paramString = "select * from " + b(paramString, paramInt) + " where shmsgseq=? and msgtype " + UinTypeUtil.c();
    paramString = jdField_a_of_type_ComTencentImcoreMessageBaseMsgProxy$Callback.a(paramString, new String[] { String.valueOf(paramLong) }, this);
    if ((paramString != null) && (paramString.size() > 0)) {
      return (MessageRecord)paramString.get(0);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.imcore.message.MsgProxy
 * JD-Core Version:    0.7.0.1
 */