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
    if (localObject != null)
    {
      if (((List)localObject).isEmpty()) {
        return paramInt3;
      }
      localObject = ((List)localObject).iterator();
      MessageRecord localMessageRecord;
      while (((Iterator)localObject).hasNext())
      {
        localMessageRecord = (MessageRecord)((Iterator)localObject).next();
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("setRecommendMsgReaded ");
          localStringBuilder.append(localMessageRecord.getBaseInfoString());
          QLog.d("Q.msg.MsgProxy", 2, localStringBuilder.toString());
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
    if ((!paramString.startsWith("mr_discusssion")) && (!paramString.startsWith("mr_troop"))) {
      i = 0;
    } else {
      i = 1;
    }
    boolean bool = paramString.endsWith("_New");
    paramEntityManager = new StringBuilder();
    paramEntityManager.append("select * from (select count() as unReadNum from %s mr where mr.isread=0),(select count() as hasReply from %s mr where mr.issend=0),%s m where m.isValid=1 and m.msgtype ");
    paramEntityManager.append(UinTypeUtil.b());
    paramEntityManager.append(" and m.longMsgId='%d' and m.issend='%d' order by %s limit 1");
    String str = paramEntityManager.toString();
    if (bool)
    {
      if (i != 0) {
        paramEntityManager = "longMsgIndex asc , shmsgseq desc , _id desc";
      } else {
        paramEntityManager = "longMsgIndex asc , time desc , _id desc";
      }
    }
    else {
      paramEntityManager = "_id desc";
    }
    paramString = String.format(str, new Object[] { paramString, paramString, paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramEntityManager });
    paramString = a().rawQuery(Message.class, paramString, null);
    if ((paramString != null) && (!paramString.isEmpty())) {
      return (Message)paramString.get(0);
    }
    return null;
  }
  
  private MessageRecord a(MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2, boolean paramBoolean)
  {
    if (paramMessageRecord1 == null) {
      return paramMessageRecord2;
    }
    if (UinTypeUtil.a(paramMessageRecord1, paramMessageRecord2))
    {
      localMessageRecord = paramMessageRecord1;
      if (paramMessageRecord1.longMsgIndex > paramMessageRecord2.longMsgIndex) {
        localMessageRecord = paramMessageRecord2;
      }
      return localMessageRecord;
    }
    if (paramBoolean)
    {
      localMessageRecord = paramMessageRecord1;
      if (paramMessageRecord2.shmsgseq > paramMessageRecord1.shmsgseq) {
        localMessageRecord = paramMessageRecord2;
      }
      return localMessageRecord;
    }
    MessageRecord localMessageRecord = paramMessageRecord1;
    if (paramMessageRecord2.time > paramMessageRecord1.time) {
      localMessageRecord = paramMessageRecord2;
    }
    return localMessageRecord;
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
    if (paramList1.size() > 15) {
      paramList2.addAll(paramList1.subList(paramList1.size() - 15, paramList1.size()));
    } else {
      paramList2.addAll(paramList1);
    }
    if ((!UinTypeUtil.a(paramString, paramInt, paramList2)) && (!UinTypeUtil.a(paramList2))) {
      paramInt = 0;
    } else {
      paramInt = 1;
    }
    if ((paramList1.size() > 15) && (paramInt != 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MsgProxy", 2, "getAIOMsgList : pull more long msg");
      }
      paramList2.clear();
      if (paramList1.size() > 30) {
        paramList2.addAll(paramList1.subList(paramList1.size() - 30, paramList1.size()));
      } else {
        paramList2.addAll(paramList1);
      }
    }
    paramString = a(paramString);
    if (paramString != null)
    {
      paramString = a(paramList2, ((Long)paramString.first).longValue());
      if ((paramString != null) && (!paramString.isEmpty())) {
        return paramString;
      }
    }
    return paramList2;
  }
  
  @Nullable
  private List<MessageRecord> a(String paramString, int paramInt, boolean paramBoolean)
  {
    List localList = b(a(paramString, paramInt));
    if ((localList != null) && (!localList.isEmpty()))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getAIOMsgList from aioPool size = ");
        localStringBuilder.append(localList.size());
        QLog.d("Q.msg.MsgProxy", 2, localStringBuilder.toString());
      }
    }
    else if (b(paramString, paramInt, paramBoolean)) {
      return null;
    }
    return b(a(paramString, paramInt));
  }
  
  public static List<MessageRecord> a(List<MessageRecord> paramList, long paramLong)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
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
    return null;
  }
  
  public static void a(BaseMsgProxy.Callback paramCallback)
  {
    jdField_a_of_type_ComTencentImcoreMessageBaseMsgProxy$Callback = paramCallback;
  }
  
  /* Error */
  private void a(EntityTransaction paramEntityTransaction, SQLiteDatabase paramSQLiteDatabase, String[] paramArrayOfString, int paramInt)
  {
    // Byte code:
    //   0: aload_3
    //   1: iload 4
    //   3: aaload
    //   4: astore 12
    //   6: aload 12
    //   8: ldc_w 320
    //   11: invokevirtual 179	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   14: ifeq +57 -> 71
    //   17: new 67	java/lang/StringBuilder
    //   20: dup
    //   21: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   24: astore_3
    //   25: aload_3
    //   26: ldc_w 322
    //   29: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: pop
    //   33: aload_3
    //   34: aload 12
    //   36: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: pop
    //   40: aload_3
    //   41: ldc_w 324
    //   44: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: pop
    //   48: aload_3
    //   49: aload 12
    //   51: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: pop
    //   55: aload_3
    //   56: ldc_w 326
    //   59: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: pop
    //   63: aload_3
    //   64: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   67: astore_3
    //   68: goto +5 -> 73
    //   71: aconst_null
    //   72: astore_3
    //   73: aload_3
    //   74: ifnonnull +4 -> 78
    //   77: return
    //   78: invokestatic 65	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   81: ifeq +40 -> 121
    //   84: new 67	java/lang/StringBuilder
    //   87: dup
    //   88: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   91: astore 10
    //   93: aload 10
    //   95: ldc_w 328
    //   98: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: pop
    //   102: aload 10
    //   104: aload_3
    //   105: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: pop
    //   109: ldc_w 330
    //   112: iconst_2
    //   113: aload 10
    //   115: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: invokestatic 87	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   121: aload_2
    //   122: aload_3
    //   123: aconst_null
    //   124: invokevirtual 335	com/tencent/mobileqq/app/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   127: astore_3
    //   128: aload_3
    //   129: ifnull +167 -> 296
    //   132: aload_3
    //   133: astore 10
    //   135: aload_3
    //   136: invokeinterface 340 1 0
    //   141: ifle +155 -> 296
    //   144: aload_3
    //   145: astore 10
    //   147: aload_3
    //   148: invokeinterface 343 1 0
    //   153: pop
    //   154: aload_3
    //   155: astore 10
    //   157: aload_3
    //   158: aload_3
    //   159: ldc_w 345
    //   162: invokeinterface 349 2 0
    //   167: invokeinterface 353 2 0
    //   172: lstore 8
    //   174: aload_3
    //   175: astore 10
    //   177: aload_3
    //   178: aload_3
    //   179: ldc_w 355
    //   182: invokeinterface 349 2 0
    //   187: invokeinterface 358 2 0
    //   192: astore 11
    //   194: aload_3
    //   195: astore 10
    //   197: aload_3
    //   198: aload_3
    //   199: ldc_w 360
    //   202: invokeinterface 349 2 0
    //   207: invokeinterface 364 2 0
    //   212: istore 4
    //   214: aload_3
    //   215: astore 10
    //   217: aload_3
    //   218: aload_3
    //   219: ldc_w 366
    //   222: invokeinterface 349 2 0
    //   227: invokeinterface 364 2 0
    //   232: istore 5
    //   234: lload 8
    //   236: lstore 6
    //   238: aload_3
    //   239: astore 10
    //   241: iload 4
    //   243: invokestatic 138	com/tencent/imcore/message/UinTypeUtil:g	(I)Z
    //   246: ifne +21 -> 267
    //   249: lload 8
    //   251: lstore 6
    //   253: iload 5
    //   255: iconst_1
    //   256: if_icmpne +11 -> 267
    //   259: lload 8
    //   261: ldc2_w 367
    //   264: ladd
    //   265: lstore 6
    //   267: aload_3
    //   268: astore 10
    //   270: getstatic 17	com/tencent/imcore/message/MsgProxy:jdField_a_of_type_ComTencentImcoreMessageBaseMsgProxy$Callback	Lcom/tencent/imcore/message/BaseMsgProxy$Callback;
    //   273: aload 11
    //   275: iload 4
    //   277: lload 6
    //   279: aload_0
    //   280: getfield 153	com/tencent/imcore/message/MsgProxy:app	Lmqq/app/AppRuntime;
    //   283: invokeinterface 371 6 0
    //   288: goto +8 -> 296
    //   291: astore 11
    //   293: goto +27 -> 320
    //   296: aload_3
    //   297: ifnull +38 -> 335
    //   300: aload_3
    //   301: invokeinterface 374 1 0
    //   306: goto +29 -> 335
    //   309: astore_1
    //   310: aconst_null
    //   311: astore 10
    //   313: goto +100 -> 413
    //   316: astore 11
    //   318: aconst_null
    //   319: astore_3
    //   320: aload_3
    //   321: astore 10
    //   323: aload 11
    //   325: invokevirtual 377	java/lang/Exception:printStackTrace	()V
    //   328: aload_3
    //   329: ifnull +6 -> 335
    //   332: goto -32 -> 300
    //   335: aload_1
    //   336: ifnull +7 -> 343
    //   339: aload_1
    //   340: invokevirtual 382	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   343: aload_2
    //   344: aload 12
    //   346: aconst_null
    //   347: aconst_null
    //   348: invokevirtual 386	com/tencent/mobileqq/app/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   351: pop
    //   352: aload_1
    //   353: ifnull +7 -> 360
    //   356: aload_1
    //   357: invokevirtual 389	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   360: aload_1
    //   361: ifnull +40 -> 401
    //   364: aload_1
    //   365: invokevirtual 392	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   368: return
    //   369: astore_2
    //   370: goto +32 -> 402
    //   373: astore_2
    //   374: aload_2
    //   375: invokevirtual 377	java/lang/Exception:printStackTrace	()V
    //   378: invokestatic 65	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   381: ifeq +13 -> 394
    //   384: ldc 80
    //   386: iconst_2
    //   387: ldc_w 394
    //   390: aload_2
    //   391: invokestatic 397	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   394: aload_1
    //   395: ifnull +6 -> 401
    //   398: goto -34 -> 364
    //   401: return
    //   402: aload_1
    //   403: ifnull +7 -> 410
    //   406: aload_1
    //   407: invokevirtual 392	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   410: aload_2
    //   411: athrow
    //   412: astore_1
    //   413: aload 10
    //   415: ifnull +10 -> 425
    //   418: aload 10
    //   420: invokeinterface 374 1 0
    //   425: goto +5 -> 430
    //   428: aload_1
    //   429: athrow
    //   430: goto -2 -> 428
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	433	0	this	MsgProxy
    //   0	433	1	paramEntityTransaction	EntityTransaction
    //   0	433	2	paramSQLiteDatabase	SQLiteDatabase
    //   0	433	3	paramArrayOfString	String[]
    //   0	433	4	paramInt	int
    //   232	25	5	i	int
    //   236	42	6	l1	long
    //   172	88	8	l2	long
    //   91	328	10	localObject	Object
    //   192	82	11	str1	String
    //   291	1	11	localException1	Exception
    //   316	8	11	localException2	Exception
    //   4	341	12	str2	String
    // Exception table:
    //   from	to	target	type
    //   135	144	291	java/lang/Exception
    //   147	154	291	java/lang/Exception
    //   157	174	291	java/lang/Exception
    //   177	194	291	java/lang/Exception
    //   197	214	291	java/lang/Exception
    //   217	234	291	java/lang/Exception
    //   241	249	291	java/lang/Exception
    //   270	288	291	java/lang/Exception
    //   121	128	309	finally
    //   121	128	316	java/lang/Exception
    //   339	343	369	finally
    //   343	352	369	finally
    //   356	360	369	finally
    //   374	394	369	finally
    //   339	343	373	java/lang/Exception
    //   343	352	373	java/lang/Exception
    //   356	360	373	java/lang/Exception
    //   135	144	412	finally
    //   147	154	412	finally
    //   157	174	412	finally
    //   177	194	412	finally
    //   197	214	412	finally
    //   217	234	412	finally
    //   241	249	412	finally
    //   270	288	412	finally
    //   323	328	412	finally
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
    if (paramList == null) {
      return;
    }
    paramList = paramList.iterator();
    MessageRecord localMessageRecord;
    do
    {
      for (;;)
      {
        if (!paramList.hasNext()) {
          return;
        }
        localMessageRecord = (MessageRecord)paramList.next();
        if (localMessageRecord.time != paramLong) {
          break;
        }
        paramList.remove();
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
    int i = 0;
    if (localList != null)
    {
      int j = localList.size() - 1;
      int k;
      for (i = 0; j >= 0; i = k)
      {
        k = i;
        if (((MessageRecord)localList.get(j)).msgtype == paramInt)
        {
          localList.remove(j);
          k = i + 1;
        }
        j -= 1;
      }
      a(String.valueOf(AppConstants.RECOMMEND_TROOP_UIN), 4001, b(String.valueOf(AppConstants.RECOMMEND_TROOP_UIN), 4001), "msgtype=?", new String[] { String.valueOf(paramInt) }, null);
    }
    jdField_a_of_type_ComTencentImcoreMessageBaseMsgProxy$Callback.a(paramInt, localList, this.app);
    return i;
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
    Object localObject1 = h(paramString, paramInt);
    if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
    {
      jdField_a_of_type_ComTencentImcoreMessageBaseMsgProxy$Callback.a((List)localObject1, this);
      localObject1 = c(paramString, paramInt, (List)localObject1);
    }
    else
    {
      localObject1 = j(paramString, paramInt);
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = new ArrayList();
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("continuedList :");
      ((StringBuilder)localObject1).append(((List)localObject2).size());
      QLog.d("Q.msg.MsgProxy", 2, ((StringBuilder)localObject1).toString());
    }
    b(paramString, paramInt, (List)localObject2);
  }
  
  private void b(String paramString, int paramInt1, int paramInt2)
  {
    Object localObject1 = h(paramString, paramInt1);
    if (localObject1 != null)
    {
      if (((List)localObject1).isEmpty()) {
        return;
      }
      Object localObject2 = ((List)localObject1).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject2).next();
        if ((!localMessageRecord.isread) && (localMessageRecord.getConfessTopicId() == paramInt2)) {
          localMessageRecord.isread = true;
        }
      }
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("setMsgRead ");
        ((StringBuilder)localObject2).append(((MessageRecord)((List)localObject1).get(((List)localObject1).size() - 1)).getBaseInfoString());
        QLog.d("Q.msg.MsgProxy", 2, ((StringBuilder)localObject2).toString());
      }
      paramString = e(paramString, paramInt1);
      if (paramString != null)
      {
        if (paramString.isEmpty()) {
          return;
        }
        paramString = paramString.iterator();
        while (paramString.hasNext())
        {
          localObject1 = (MessageRecord)paramString.next();
          if ((!((MessageRecord)localObject1).isread) && (((MessageRecord)localObject1).getConfessTopicId() == paramInt2)) {
            ((MessageRecord)localObject1).isread = true;
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
    if (paramInt2 == 0L)
    {
      a(paramString1, paramInt1, b(paramString1, paramInt1), "senderuin=? and selfuin=?", new String[] { paramString2, paramString3 }, null);
    }
    else if (paramInt1 == 1032)
    {
      paramString1 = localArrayList.iterator();
      while (paramString1.hasNext()) {
        a((MessageRecord)paramString1.next(), false);
      }
    }
    localArrayList.clear();
  }
  
  private void b(List<MessageRecord> paramList, ProxyListener paramProxyListener)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)paramList.next();
      if (localMessageRecord.versionCode > 0)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("proxy addSync id=");
          localStringBuilder.append(localMessageRecord.vipBubbleID);
          QLog.d("vip", 2, localStringBuilder.toString());
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
    int i;
    if (localList != null)
    {
      i = localList.size();
      localList.clear();
    }
    else
    {
      i = 0;
    }
    if (a().containsKey(a(paramString, paramInt))) {
      a().remove(a(paramString, paramInt));
    }
    return i;
  }
  
  private MessageRecord c(String paramString, int paramInt1, int paramInt2)
  {
    List localList = c(paramString, paramInt1);
    Object localObject1 = null;
    StringBuilder localStringBuilder = null;
    Object localObject2 = localObject1;
    if (localList != null)
    {
      localObject2 = localObject1;
      if (!localList.isEmpty())
      {
        int i = localList.size() - 1;
        for (;;)
        {
          localObject1 = localStringBuilder;
          if (i < 0) {
            break label106;
          }
          if ((paramInt2 == 0) || (((MessageRecord)localList.get(i)).getConfessTopicId() == paramInt2)) {
            break;
          }
          i -= 1;
        }
        localObject1 = (MessageRecord)localList.get(i);
        label106:
        localObject2 = localObject1;
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("getLastMsgFromList mr = ");
          if (localObject1 == null) {
            localObject2 = "null";
          } else {
            localObject2 = ((MessageRecord)localObject1).getBaseInfoString();
          }
          localStringBuilder.append((String)localObject2);
          QLog.d("Q.msg.MsgProxy", 2, localStringBuilder.toString());
          localObject2 = localObject1;
        }
      }
    }
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      QLog.e("Q.msg.MsgProxy", 1, new Object[] { "getLastMsgFromList no cache", paramString, ",", Integer.valueOf(paramInt1), ",", Integer.valueOf(paramInt2) });
      jdField_a_of_type_ComTencentImcoreMessageBaseMsgProxy$Callback.a(this.app, paramString, paramInt1);
      localObject1 = b(paramString, paramInt1, paramInt2);
    }
    return localObject1;
  }
  
  private void c(String paramString, int paramInt, long paramLong)
  {
    Object localObject = h(paramString, paramInt);
    if (localObject != null)
    {
      if (((List)localObject).isEmpty()) {
        return;
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
        if ((!localMessageRecord.isread) && (a(paramInt, paramLong, localMessageRecord)) && ((!UinTypeUtil.e(paramInt)) || (!UinTypeUtil.f(localMessageRecord.msgtype)))) {
          localMessageRecord.isread = true;
        }
      }
      paramString = e(paramString, paramInt);
      if (paramString != null)
      {
        if (paramString.isEmpty()) {
          return;
        }
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
    Object localObject1 = h(paramString, paramInt);
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = ((List)localObject1).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localMessageRecord = (MessageRecord)((Iterator)localObject2).next();
        if (localMessageRecord.uniseq == paramLong)
        {
          ((List)localObject1).remove(localMessageRecord);
          break label70;
        }
      }
    }
    MessageRecord localMessageRecord = null;
    label70:
    paramString = e(paramString, paramInt);
    if (paramString != null)
    {
      localObject1 = paramString.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (MessageRecord)((Iterator)localObject1).next();
        if (((MessageRecord)localObject2).uniseq == paramLong)
        {
          paramString.remove(localObject2);
          return localObject2;
        }
      }
    }
    return localMessageRecord;
  }
  
  private List<MessageRecord> k(String paramString, int paramInt)
  {
    Object localObject1 = a(a(paramString, paramInt));
    if (localObject1 != null)
    {
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("init from cache, uin=");
        ((StringBuilder)localObject2).append(paramString);
        QLog.d("Q.msg.MsgProxy", 2, ((StringBuilder)localObject2).toString());
      }
      return localObject1;
    }
    long l = System.currentTimeMillis();
    String str = c(paramString, paramInt);
    boolean bool = a(paramString, paramInt, false);
    if (bool) {
      this.proxyManager.transSaveToDatabase();
    }
    Object localObject3 = i(paramString, paramInt);
    Object localObject2 = jdField_a_of_type_ComTencentImcoreMessageBaseMsgProxy$Callback.a(str, null, this);
    if ((localObject2 != null) && (((List)localObject2).size() > 0))
    {
      paramInt = 0;
      while (paramInt < ((List)localObject2).size())
      {
        localObject1 = (MessageRecord)((List)localObject2).get(paramInt);
        if ((localObject1 != null) && (((MessageRecord)localObject1).isSendFromLocal()) && (((MessageRecord)localObject1).extraflag == 32772) && (!jdField_a_of_type_ComTencentImcoreMessageBaseMsgProxy$Callback.a(this.app, (MessageRecord)localObject1)))
        {
          QLog.e("Q.msg.MsgProxy", 1, new Object[] { "set sending message FAILED: ", localObject1 });
          ((MessageRecord)localObject1).setExtraFlag(32768);
        }
        paramInt += 1;
      }
    }
    if (localObject2 != null)
    {
      int j = ((List)localObject2).size() / 2;
      paramInt = ((List)localObject2).size() - 1;
      int i = 0;
      for (;;)
      {
        localObject1 = localObject2;
        if (i >= j) {
          break;
        }
        localObject1 = (MessageRecord)((List)localObject2).get(i);
        ((List)localObject2).set(i, ((List)localObject2).get(paramInt));
        ((List)localObject2).set(paramInt, localObject1);
        i += 1;
        paramInt -= 1;
      }
    }
    localObject1 = new ArrayList();
    localObject2 = UinTypeUtil.a((List)localObject1, (List)localObject3).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (MessageRecord)((Iterator)localObject2).next();
      jdField_a_of_type_ComTencentImcoreMessageBaseMsgProxy$Callback.a((List)localObject1, (MessageRecord)localObject3, true);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, new Object[] { "init from db, uin=", paramString, ", isSaveToDatabase=", Boolean.valueOf(bool), ", cost=", Long.valueOf(System.currentTimeMillis() - l), " sqlStr = ", str, " size =", Integer.valueOf(((List)localObject1).size()) });
    }
    return localObject1;
  }
  
  @Nullable
  private MessageRecord l(String paramString, int paramInt, long paramLong)
  {
    Object localObject1 = h(paramString, paramInt);
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = ((List)localObject1).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localMessageRecord = (MessageRecord)((Iterator)localObject2).next();
        if (localMessageRecord.getId() == paramLong)
        {
          ((List)localObject1).remove(localMessageRecord);
          break label70;
        }
      }
    }
    MessageRecord localMessageRecord = null;
    label70:
    paramString = e(paramString, paramInt);
    if (paramString != null)
    {
      localObject1 = paramString.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (MessageRecord)((Iterator)localObject1).next();
        if (((MessageRecord)localObject2).getId() == paramLong)
        {
          paramString.remove(localObject2);
          return localObject2;
        }
      }
    }
    return localMessageRecord;
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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("--->deleteC2CMsgByMessageRecord : peerUin:");
      localStringBuilder.append(paramMessageRecord.frienduin);
      localStringBuilder.append(" type:");
      localStringBuilder.append(paramMessageRecord.istroop);
      localStringBuilder.append(" uniseq:");
      localStringBuilder.append(paramMessageRecord.uniseq);
      localStringBuilder.append(" mr:");
      localStringBuilder.append(paramMessageRecord);
      localStringBuilder.append(" dbid:");
      localStringBuilder.append(paramMessageRecord.getId());
      QLog.d("Q.msg.MsgProxy", 2, localStringBuilder.toString());
    }
    if (paramBoolean) {
      h(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.getId());
    } else {
      e(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.uniseq);
    }
    long l = paramMessageRecord.getId();
    if (l > 0L)
    {
      a(paramMessageRecord.frienduin, paramMessageRecord.istroop, b(paramMessageRecord.frienduin, paramMessageRecord.istroop), "_id=?", new String[] { String.valueOf(l) }, null);
    }
    else
    {
      if (paramMessageRecord.uniseq == 0L) {
        break label292;
      }
      a(paramMessageRecord.frienduin, paramMessageRecord.istroop, b(paramMessageRecord.frienduin, paramMessageRecord.istroop), "uniseq=?", new String[] { String.valueOf(paramMessageRecord.uniseq) }, null);
    }
    if (!paramMessageRecord.isread) {
      return 2;
    }
    a(paramMessageRecord.frienduin, paramMessageRecord.istroop);
    return 1;
    label292:
    return -1;
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
    if (bool) {
      ??? = "shmsgseq desc , _id desc";
    } else {
      ??? = "time desc , _id desc";
    }
    if (bool) {
      localObject2 = "shmsgseq";
    } else {
      localObject2 = "time";
    }
    int j = 0;
    Object localObject2 = String.format("select * from (select count() as unReadNum from %s mr where mr.isread=0 and mr.issend='0' and mr.%s>'%d'),%s m where m.%s>'%d' order by %s limit 1", new Object[] { str, localObject2, Long.valueOf(paramLong), str, localObject2, Long.valueOf(paramLong), ??? });
    synchronized (jdField_a_of_type_ComTencentImcoreMessageBaseMsgProxy$Callback.a(this.app))
    {
      if (a(paramString, paramInt, false)) {
        this.proxyManager.transSaveToDatabase(a());
      }
      localObject2 = a().rawQuery(Message.class, (String)localObject2, null);
      int i = j;
      if (localObject2 != null)
      {
        i = j;
        if (!((List)localObject2).isEmpty()) {
          i = ((Message)((List)localObject2).get(0)).unReadNum;
        }
      }
      j = c(paramString, paramInt, paramLong);
      paramInt = jdField_a_of_type_ComTencentImcoreMessageBaseMsgProxy$Callback.a(paramString, paramInt, paramLong, i + j, this.app);
      return paramInt;
    }
  }
  
  public int a(String paramString, int paramInt, MessageRecord paramMessageRecord)
  {
    paramString = b(paramString, paramInt);
    boolean bool = UinTypeUtil.b(paramInt);
    paramInt = 0;
    if (bool)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("( msgtype ");
      ((StringBuilder)localObject).append(UinTypeUtil.a());
      ((StringBuilder)localObject).append(" and isValid=1 ) and ( time < ? or (time = ? and longMsgIndex <= ? and _id <= ?))");
      localObject = ((StringBuilder)localObject).toString();
      long l1 = paramMessageRecord.time;
      long l2 = paramMessageRecord.time;
      int i = paramMessageRecord.longMsgIndex;
      long l3 = paramMessageRecord.getId();
      paramString = a().query(false, paramString, new String[] { "_id" }, (String)localObject, new String[] { String.valueOf(l1), String.valueOf(l2), String.valueOf(i), String.valueOf(l3) }, null, null, null, null);
    }
    else
    {
      paramString = null;
    }
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
    if ((paramList != null) && (paramList.size() != 0))
    {
      int i = paramList.size();
      Object localObject1 = (MessageRecord)paramList.get(paramList.size() - 1);
      String str = ((MessageRecord)localObject1).frienduin;
      int j = ((MessageRecord)localObject1).istroop;
      Object localObject2 = new ArrayList();
      localObject1 = new ArrayList();
      paramList = paramList.iterator();
      Object localObject3;
      while (paramList.hasNext())
      {
        localObject3 = (MessageRecord)paramList.next();
        if (paramBoolean) {
          h(((MessageRecord)localObject3).frienduin, ((MessageRecord)localObject3).istroop, ((MessageRecord)localObject3).getId());
        } else {
          e(((MessageRecord)localObject3).frienduin, ((MessageRecord)localObject3).istroop, ((MessageRecord)localObject3).uniseq);
        }
        if (((MessageRecord)localObject3).getId() > 0L) {
          ((List)localObject2).add(String.valueOf(((MessageRecord)localObject3).getId()));
        } else if (((MessageRecord)localObject3).uniseq != 0L) {
          ((List)localObject1).add(String.valueOf(((MessageRecord)localObject3).uniseq));
        } else {
          i -= 1;
        }
      }
      int k;
      if (((List)localObject2).size() > 100)
      {
        paramList = ((List)localObject2).iterator();
        while (paramList.hasNext())
        {
          localObject2 = (String)paramList.next();
          a(str, j, b(str, j), "_id=?", new String[] { localObject2 }, null);
        }
      }
      else if (((List)localObject2).size() != 0)
      {
        k = ((List)localObject2).size();
        paramList = new String[k];
        Arrays.fill(paramList, "?");
        paramList = Arrays.toString(paramList);
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("_id IN (");
        ((StringBuilder)localObject3).append(paramList.substring(1, paramList.length() - 1));
        ((StringBuilder)localObject3).append(")");
        paramList = ((StringBuilder)localObject3).toString();
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
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("uniseq IN (");
        ((StringBuilder)localObject2).append(paramList.substring(1, paramList.length() - 1));
        ((StringBuilder)localObject2).append(")");
        paramList = ((StringBuilder)localObject2).toString();
        a(str, j, b(str, j), paramList, (String[])((List)localObject1).toArray(new String[k]), null);
      }
      a(str, j);
      return i;
    }
    return -1;
  }
  
  @Deprecated
  public Cursor a(String paramString, int paramInt)
  {
    List localList = b(paramString, paramInt);
    if (paramString.equals(String.valueOf(AppConstants.SYSTEM_MSG_UIN)))
    {
      ArrayList localArrayList = new ArrayList();
      int j = 0;
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
    Object localObject1;
    boolean bool1;
    int i;
    label522:
    label528:
    label536:
    label543:
    label552:
    label561:
    synchronized (jdField_a_of_type_ComTencentImcoreMessageBaseMsgProxy$Callback.a(this.app))
    {
      if (a(paramString, false)) {
        this.proxyManager.transSaveToDatabase(paramEntityManager);
      }
      if (!paramString.startsWith("mr_discusssion")) {
        if (paramString.startsWith("mr_troop"))
        {
          break label522;
          boolean bool2 = paramString.endsWith("_New");
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("select * from (select count() as unReadNum from %s mr where mr.isread=0),(select count() as hasReply from %s mr where mr.issend=0),%s m where m.isValid=1 and m.msgtype ");
          ((StringBuilder)localObject1).append(UinTypeUtil.b());
          ((StringBuilder)localObject1).append(" order by %s limit 1");
          Object localObject2 = ((StringBuilder)localObject1).toString();
          if (!bool2) {
            break label536;
          }
          if (!bool1) {
            break label528;
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
                if (paramInt != 0) {
                  if (((Message)localList.get(i)).getConfessTopicId() != paramInt) {
                    break label543;
                  }
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
          paramEntityManager = c(paramString);
          if ((paramEntityManager != null) && (paramEntityManager.size() > 0))
          {
            i = paramEntityManager.size() - 1;
            if (i >= 0)
            {
              if ((paramInt <= 0) || (((MessageRecord)paramEntityManager.get(i)).getConfessTopicId() == paramInt)) {
                break label552;
              }
              paramEntityManager.remove(i);
              break label552;
            }
          }
          paramString = (String)localObject1;
          if (paramEntityManager != null)
          {
            paramString = (String)localObject1;
            if (paramEntityManager.size() > 0)
            {
              if (localObject1 == null) {
                paramInt = 0;
              } else {
                paramInt = ((Message)localObject1).unReadNum;
              }
              paramString = paramEntityManager.iterator();
              for (paramEntityManager = (EntityManager)localObject1; paramString.hasNext(); paramEntityManager = a(paramEntityManager, (MessageRecord)localObject2, bool1))
              {
                localObject2 = (MessageRecord)paramString.next();
                if (!((MessageRecord)localObject2).isread) {
                  break label561;
                }
                i = 0;
                paramInt += i;
              }
              paramString = (String)localObject1;
              if (localObject1 == null) {
                paramString = new Message();
              }
              MessageRecord.copyMessageRecordBaseField(paramString, paramEntityManager);
              paramString.unReadNum = paramInt;
            }
          }
          return paramString;
        }
      }
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
    if ((paramCursor != null) && (paramCursor.getCount() != 0) && (!TextUtils.isEmpty(paramString1)))
    {
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
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("getSearchResult, key uin = ");
        paramString1.append(localHashSet.toString());
        QLog.d("Q.msg.MsgProxy", 2, paramString1.toString());
      }
      if (paramCursor.isBeforeFirst()) {
        paramCursor.moveToFirst();
      }
      while (!paramCursor.isAfterLast())
      {
        paramString1 = a(paramCursor, paramInt, paramString2);
        int i;
        if ((!TextUtils.isEmpty(paramString1)) && (localHashSet.contains(paramString1))) {
          i = 1;
        } else {
          i = 0;
        }
        int j = i;
        if (i == 0)
        {
          localObject = paramCursor.getBlob(paramCursor.getColumnIndex("msgData"));
          paramString3 = "";
          paramString1 = paramString3;
          if (localObject != null)
          {
            paramString1 = paramString3;
            try
            {
              if (localObject.length > 0) {
                paramString1 = new String((byte[])localObject, "utf-8");
              }
            }
            catch (Exception paramString1)
            {
              paramString1.printStackTrace();
              paramString1 = paramString3;
            }
          }
          j = i;
          if (paramString1.toLowerCase(Locale.US).contains(str1)) {
            j = 1;
          }
        }
        if (j != 0) {
          if (localArrayList1.size() < 50)
          {
            paramString1 = (MessageRecord)a().cursor2Entity(MessageRecord.class, null, paramCursor, new MsgProxy.1(this));
            if (paramString1 != null) {
              localArrayList1.add(paramString1);
            }
          }
          else
          {
            localArrayList2.add(Integer.valueOf(paramCursor.getInt(0)));
          }
        }
        paramCursor.moveToNext();
      }
      if (localArrayList1.size() > 0)
      {
        paramCursor = new ChatHistorySearchData();
        paramCursor.mSearchData1 = localArrayList1;
        paramCursor.mSearchData2 = localArrayList2;
        return paramCursor;
      }
      return null;
    }
    return null;
  }
  
  /* Error */
  public ChatHistorySearchData a(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokestatic 802	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: istore 5
    //   6: aconst_null
    //   7: astore 7
    //   9: aconst_null
    //   10: astore 6
    //   12: iload 5
    //   14: ifne +129 -> 143
    //   17: aload_1
    //   18: invokestatic 802	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   21: ifeq +5 -> 26
    //   24: aconst_null
    //   25: areturn
    //   26: aload_0
    //   27: aload_2
    //   28: iload_3
    //   29: invokevirtual 450	com/tencent/imcore/message/MsgProxy:b	(Ljava/lang/String;I)Ljava/lang/String;
    //   32: astore 8
    //   34: aload_0
    //   35: invokevirtual 211	com/tencent/imcore/message/MsgProxy:a	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   38: iconst_0
    //   39: aload 8
    //   41: aconst_null
    //   42: ldc_w 881
    //   45: iconst_1
    //   46: anewarray 121	java/lang/String
    //   49: dup
    //   50: iconst_0
    //   51: sipush -1000
    //   54: invokestatic 124	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   57: aastore
    //   58: aconst_null
    //   59: aconst_null
    //   60: ldc_w 883
    //   63: aconst_null
    //   64: invokevirtual 707	com/tencent/mobileqq/persistence/EntityManager:query	(ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   67: astore 8
    //   69: aload_0
    //   70: aload 8
    //   72: aload_1
    //   73: aload_2
    //   74: iload_3
    //   75: aload 4
    //   77: invokevirtual 885	com/tencent/imcore/message/MsgProxy:a	(Landroid/database/Cursor;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)Lcom/tencent/mobileqq/data/ChatHistorySearchData;
    //   80: astore_1
    //   81: aload_1
    //   82: astore_2
    //   83: aload 8
    //   85: ifnull +42 -> 127
    //   88: aload 8
    //   90: invokeinterface 374 1 0
    //   95: aload_1
    //   96: areturn
    //   97: astore_1
    //   98: goto +31 -> 129
    //   101: astore_1
    //   102: ldc 80
    //   104: iconst_1
    //   105: aload_1
    //   106: iconst_0
    //   107: anewarray 30	java/lang/Object
    //   110: invokestatic 888	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   113: aload 7
    //   115: astore_2
    //   116: aload 8
    //   118: ifnull +9 -> 127
    //   121: aload 6
    //   123: astore_1
    //   124: goto -36 -> 88
    //   127: aload_2
    //   128: areturn
    //   129: aload 8
    //   131: ifnull +10 -> 141
    //   134: aload 8
    //   136: invokeinterface 374 1 0
    //   141: aload_1
    //   142: athrow
    //   143: aconst_null
    //   144: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	145	0	this	MsgProxy
    //   0	145	1	paramString1	String
    //   0	145	2	paramString2	String
    //   0	145	3	paramInt	int
    //   0	145	4	paramString3	String
    //   4	9	5	bool	boolean
    //   10	112	6	localObject1	Object
    //   7	107	7	localObject2	Object
    //   32	103	8	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   69	81	97	finally
    //   102	113	97	finally
    //   69	81	101	java/lang/Exception
  }
  
  public MessageRecord a(MessageRecord paramMessageRecord, int paramInt)
  {
    if (paramMessageRecord == null) {
      return null;
    }
    MessageRecord localMessageRecord = a(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.uniseq);
    paramMessageRecord.msgtype = paramInt;
    if (localMessageRecord != null) {
      localMessageRecord.msgtype = paramInt;
    } else if (QLog.isColorLevel()) {
      QLog.w("Q.msg.MsgProxy", 2, "update : updateMessageType : set fail !");
    }
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("msgtype", Integer.valueOf(paramInt));
    if (localMessageRecord != null)
    {
      if (localMessageRecord.getId() > 0L)
      {
        a(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.versionCode, localContentValues, "_id=?", new String[] { String.valueOf(localMessageRecord.getId()) }, null);
        return localMessageRecord;
      }
      a(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.versionCode, localContentValues, "uniseq=?", new String[] { String.valueOf(localMessageRecord.uniseq) }, null);
      return localMessageRecord;
    }
    if (paramMessageRecord.getId() > 0L) {
      a(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.versionCode, localContentValues, "_id=?", new String[] { String.valueOf(paramMessageRecord.getId()) }, null);
    }
    return localMessageRecord;
  }
  
  public MessageRecord a(MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    if (paramMessageRecord == null) {
      return null;
    }
    MessageRecord localMessageRecord = a(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.uniseq);
    paramMessageRecord.isValid = paramBoolean;
    if (localMessageRecord != null) {
      localMessageRecord.isValid = paramBoolean;
    } else if (QLog.isColorLevel()) {
      QLog.w("Q.msg.MsgProxy", 2, "update : setMessageIsValidFlag : set fail !");
    }
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("isValid", Boolean.valueOf(paramBoolean));
    if (localMessageRecord != null)
    {
      if (localMessageRecord.getId() > 0L)
      {
        a(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.versionCode, localContentValues, "_id=?", new String[] { String.valueOf(localMessageRecord.getId()) }, null);
        return localMessageRecord;
      }
      a(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.versionCode, localContentValues, "uniseq=?", new String[] { String.valueOf(localMessageRecord.uniseq) }, null);
      return localMessageRecord;
    }
    if (paramMessageRecord.getId() > 0L) {
      a(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.versionCode, localContentValues, "_id=?", new String[] { String.valueOf(paramMessageRecord.getId()) }, null);
    }
    return localMessageRecord;
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
    if ((paramLong != 0L) && (paramString != null))
    {
      if (paramString.length() == 0) {
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
    return null;
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
    localObject = a(paramString1, paramInt, paramLong1);
    if ((localObject == null) && (paramString2 != null)) {}
    try
    {
      l = Long.valueOf(paramString2).longValue();
    }
    catch (NumberFormatException paramString2)
    {
      label60:
      break label60;
    }
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.msg.MsgProxy", 2, "can't find message by uniseq, try filename");
      }
      paramString2 = a(paramString1, paramInt, l);
      paramLong1 = l;
    }
    catch (NumberFormatException paramString2)
    {
      paramString2 = (String)localObject;
      paramLong1 = l;
      break label64;
    }
    paramString2 = (String)localObject;
    label64:
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
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("update msgTime set msg =");
        ((StringBuilder)localObject).append(paramString2.getBaseInfoString());
        QLog.d("Q.msg.MsgProxy", 2, ((StringBuilder)localObject).toString());
      }
    }
    localObject = new ContentValues();
    ((ContentValues)localObject).put("time", Long.valueOf(paramLong2));
    if ((paramString2 != null) && (paramString2.extraflag == 0))
    {
      ((ContentValues)localObject).put("extraflag", Integer.valueOf(0));
      ((ContentValues)localObject).put("sendFailCode", Integer.valueOf(0));
    }
    if (paramString2 != null)
    {
      if (paramString2.getId() > 0L)
      {
        a(paramString1, paramInt, paramString2.versionCode, (ContentValues)localObject, "_id=?", new String[] { String.valueOf(paramString2.getId()) }, null);
        return paramString2;
      }
      a(paramString1, paramInt, paramString2.versionCode, (ContentValues)localObject, "uniseq=?", new String[] { String.valueOf(paramLong1) }, null);
      return paramString2;
    }
    a(paramString1, paramInt, 3, (ContentValues)localObject, "uniseq=?", new String[] { String.valueOf(paramLong1) }, null);
    return paramString2;
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
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      label57:
      break label57;
    }
    break label70;
    localContentValues.put("msg", paramString2);
    label70:
    localMessageRecord.msg = paramString2;
    localMessageRecord.msgData = paramString2.getBytes();
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append("updateMsgContentByUniseq: set msg =");
      paramString2.append(localMessageRecord.getBaseInfoString());
      QLog.d("Q.msg.MsgProxy", 2, paramString2.toString());
    }
    if (localMessageRecord.getId() > 0L)
    {
      a(paramString1, paramInt, localMessageRecord.versionCode, localContentValues, "_id=?", new String[] { String.valueOf(localMessageRecord.getId()) }, null);
      return localMessageRecord;
    }
    a(paramString1, paramInt, localMessageRecord.versionCode, localContentValues, "uniseq=?", new String[] { String.valueOf(paramLong) }, null);
    return localMessageRecord;
    try
    {
      localContentValues.put("msgData", paramString2.getBytes("UTF-8"));
    }
    catch (UnsupportedEncodingException paramString2)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("updateMsgContentByUniseq fail!");
        localStringBuilder.append(paramString2);
        QLog.d("Q.msg.MsgProxy", 2, localStringBuilder.toString());
      }
    }
    a(paramString1, paramInt, 3, localContentValues, "uniseq=?", new String[] { String.valueOf(paramLong) }, null);
    return localMessageRecord;
  }
  
  public MessageRecord a(String paramString1, int paramInt, long paramLong, String paramString2, Object paramObject)
  {
    MessageRecord localMessageRecord = a(paramString1, paramInt, paramLong);
    try
    {
      Object localObject = MessageRecord.class.getDeclaredField(paramString2);
      if (localObject == null)
      {
        QLog.e("Q.msg.MsgProxy", 1, "updateMsgFieldByUniseq: field == null");
        return localMessageRecord;
      }
      Class localClass = ((Field)localObject).getType();
      ((Field)localObject).setAccessible(true);
      ((Field)localObject).set(localMessageRecord, paramObject);
      if (!Modifier.isStatic(((Field)localObject).getModifiers()))
      {
        if (((Field)localObject).isAnnotationPresent(notColumn.class)) {
          return localMessageRecord;
        }
        localObject = new ContentValues();
        if (localClass == Long.TYPE)
        {
          ((ContentValues)localObject).put(paramString2, (Long)paramObject);
        }
        else if (localClass == Integer.TYPE)
        {
          ((ContentValues)localObject).put(paramString2, (Integer)paramObject);
        }
        else if (localClass == String.class)
        {
          ((ContentValues)localObject).put(paramString2, (String)paramObject);
        }
        else if (localClass == Byte.TYPE)
        {
          ((ContentValues)localObject).put(paramString2, (Byte)paramObject);
        }
        else if (localClass == [B.class)
        {
          ((ContentValues)localObject).put(paramString2, (byte[])paramObject);
        }
        else if (localClass == Short.TYPE)
        {
          ((ContentValues)localObject).put(paramString2, (Short)paramObject);
        }
        else if (localClass == Boolean.TYPE)
        {
          ((ContentValues)localObject).put(paramString2, (Boolean)paramObject);
        }
        else if (localClass == Float.TYPE)
        {
          ((ContentValues)localObject).put(paramString2, (Float)paramObject);
        }
        else if (localClass == Double.TYPE)
        {
          ((ContentValues)localObject).put(paramString2, (Double)paramObject);
        }
        else if (QLog.isColorLevel())
        {
          paramString2 = new StringBuilder();
          paramString2.append("updateMsgFieldByUniseq fieldType error! ");
          paramString2.append(localClass.getClass().getSimpleName());
          QLog.e("Q.msg.MsgProxy", 2, paramString2.toString());
        }
        if (localMessageRecord.getId() > 0L)
        {
          a(paramString1, paramInt, localMessageRecord.versionCode, (ContentValues)localObject, "_id=?", new String[] { String.valueOf(localMessageRecord.getId()) }, null);
          return localMessageRecord;
        }
        a(paramString1, paramInt, localMessageRecord.versionCode, (ContentValues)localObject, "uniseq=?", new String[] { String.valueOf(localMessageRecord.uniseq) }, null);
        return localMessageRecord;
      }
      return localMessageRecord;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.e("Q.msg.MsgProxy", 2, "updateMsgFieldByUniseq error! ", paramString1);
      }
    }
    return localMessageRecord;
  }
  
  public MessageRecord a(String paramString1, int paramInt, long paramLong, String paramString2, String paramString3)
  {
    if (a(paramString1, paramInt, true)) {
      this.proxyManager.transSaveToDatabase(a());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("select * from ");
    localStringBuilder.append(b(paramString1, paramInt));
    localStringBuilder.append(" where time=%d and senderuin=%s");
    paramString2 = String.format(localStringBuilder.toString(), new Object[] { Long.valueOf(paramLong), paramString2 });
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("queryMsgByConstraints: sql=");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(", peeruin = ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(", type = ");
      localStringBuilder.append(paramInt);
      QLog.d("Q.msg.MsgProxy", 2, localStringBuilder.toString());
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
      if (QLog.isColorLevel())
      {
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("updateMsgContent: set msg = ");
        paramArrayOfByte.append(localMessageRecord.getBaseInfoString());
        QLog.d("Q.msg.MsgProxy", 2, paramArrayOfByte.toString());
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
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("queryLastMsgForMessageTabFromDB, peerUin = ");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(", type ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("Q.msg.MsgProxy", 2, ((StringBuilder)localObject).toString());
    }
    if (a(paramString1, paramInt, true)) {
      this.proxyManager.transSaveToDatabase(a());
    }
    boolean bool = UinTypeUtil.g(paramInt);
    Object localObject = "";
    StringBuilder localStringBuilder;
    if (bool)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("select * from ");
      localStringBuilder.append(b(paramString1, paramInt));
      localStringBuilder.append(" where isValid=1 and msgtype ");
      localStringBuilder.append(UinTypeUtil.b());
      localStringBuilder.append(" ");
      if (paramString2 != null)
      {
        paramString1 = new StringBuilder();
        paramString1.append("and ");
        paramString1.append(paramString2);
        localObject = paramString1.toString();
      }
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(" order by shmsgseq desc , _id desc limit 1");
      paramString1 = localStringBuilder.toString();
    }
    else
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("select * from ");
      localStringBuilder.append(b(paramString1, paramInt));
      localStringBuilder.append(" where isValid=1 and msgtype ");
      localStringBuilder.append(UinTypeUtil.b());
      localStringBuilder.append(" ");
      if (paramString2 != null)
      {
        paramString1 = new StringBuilder();
        paramString1.append("and ");
        paramString1.append(paramString2);
        localObject = paramString1.toString();
      }
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(" order by time desc , _id desc limit 1");
      paramString1 = localStringBuilder.toString();
    }
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append("queryLastTABSupportMessageFromDB : sqlStr:");
      paramString2.append(paramString1);
      QLog.d("Q.msg.MsgProxy", 2, paramString2.toString());
    }
    paramString1 = jdField_a_of_type_ComTencentImcoreMessageBaseMsgProxy$Callback.a(paramString1, null, this);
    if (paramString1 != null)
    {
      if (paramString1.size() < 1) {
        return null;
      }
      return (MessageRecord)paramString1.get(0);
    }
    return null;
  }
  
  public EntityManager a()
  {
    ??? = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
    if ((??? == null) || (!((EntityManager)???).isOpen())) {}
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
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getAIOMsgList peerUin: ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" type: ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(" , autoInit = ");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("Q.msg.MsgProxy_", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = a(paramString, paramInt1);
    ((Lock)localObject).lock();
    try
    {
      paramString = a(paramString, paramInt1, paramBoolean);
      return paramString;
    }
    finally
    {
      ((Lock)localObject).unlock();
    }
  }
  
  public List<MessageRecord> a(String paramString, int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getAllMessages uin ");
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append(" , type = ");
      ((StringBuilder)localObject1).append(paramInt1);
      ((StringBuilder)localObject1).append(" , customTypes = ");
      ((StringBuilder)localObject1).append(Arrays.toString(paramArrayOfInt));
      QLog.d("Q.msg.MsgProxy", 2, ((StringBuilder)localObject1).toString());
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = d(paramString, paramInt1);
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
    localObject2 = new HashSet();
    a(paramArrayOfInt, (HashSet)localObject2);
    long l2 = 9223372036854775807L;
    int i;
    long l1;
    long l3;
    if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
    {
      if ((((List)localObject1).size() >= paramInt2) && (((HashSet)localObject2).isEmpty()))
      {
        localArrayList.addAll(((List)localObject1).subList(((List)localObject1).size() - paramInt2, ((List)localObject1).size()));
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("getAllMessages size = ");
          paramString.append(localArrayList.size());
          QLog.d("Q.msg.MsgProxy", 2, paramString.toString());
        }
        return localArrayList;
      }
      long l5 = a(paramInt1, (List)localObject1, 9223372036854775807L);
      localObject1 = ((List)localObject1).iterator();
      i = 3;
      for (l1 = 9223372036854775807L; ((Iterator)localObject1).hasNext(); l1 = l3)
      {
        MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject1).next();
        long l4;
        int j;
        if ((UinTypeUtil.g(paramInt1)) && (localMessageRecord.versionCode == 3) && (localMessageRecord.shmsgseq == l5) && (l5 != 0L))
        {
          l4 = l2;
          j = i;
          l3 = l1;
        }
        else if (!((HashSet)localObject2).contains(Integer.valueOf(localMessageRecord.msgtype)))
        {
          l4 = l2;
          j = i;
          l3 = l1;
          if (!((HashSet)localObject2).isEmpty()) {}
        }
        else
        {
          j = a(i, localMessageRecord);
          l4 = b(l2, localMessageRecord);
          l3 = a(l1, localMessageRecord);
          localArrayList.add(localMessageRecord);
        }
        l2 = l4;
        i = j;
      }
      if (localArrayList.size() >= paramInt2) {
        return localArrayList.subList(localArrayList.size() - paramInt2, localArrayList.size());
      }
      l3 = l1;
      l1 = l2;
      l2 = l3;
      l3 = l5;
    }
    else
    {
      l1 = 9223372036854775807L;
      l3 = l1;
      i = 3;
    }
    if (UinTypeUtil.g(paramInt1)) {
      localArrayList.addAll(0, a(paramString, paramInt1, l1, i, l3, paramInt2 - localArrayList.size(), paramArrayOfInt));
    } else {
      localArrayList.addAll(0, a(paramString, paramInt1, l1, i, l2, paramInt2 - localArrayList.size(), paramArrayOfInt));
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("getAllMessages size = ");
      paramString.append(localArrayList.size());
      QLog.d("Q.msg.MsgProxy", 2, paramString.toString());
    }
    return localArrayList;
  }
  
  protected List<MessageRecord> a(String paramString, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("queryMessagesByMsgUniseqFromDB, peerUin[");
      localStringBuilder.append(MsfSdkUtils.getShortUin(paramString));
      localStringBuilder.append("] type[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("] uniseq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.d("Q.msg.MsgProxy", 2, localStringBuilder.toString());
    }
    if (paramLong == 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.msg.MsgProxy", 2, "queryMessagesByMsgUniseqFromDB Warning! uniseq==0");
      }
      return new ArrayList();
    }
    if (a(paramString, paramInt, true)) {
      this.proxyManager.transSaveToDatabase(a());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("select * from ");
    localStringBuilder.append(b(paramString, paramInt));
    localStringBuilder.append(" where uniseq=?");
    paramString = localStringBuilder.toString();
    paramString = jdField_a_of_type_ComTencentImcoreMessageBaseMsgProxy$Callback.a(paramString, new String[] { String.valueOf(paramLong) }, this);
    if (paramString != null) {
      return paramString;
    }
    return new ArrayList();
  }
  
  public List<MessageRecord> a(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getAIOMsgList, jump to peerUin: ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" type: ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(" , from = ");
      ((StringBuilder)localObject).append(paramLong);
      QLog.d("Q.msg.MsgProxy", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = a(paramString, paramInt1);
    ((Lock)localObject).lock();
    try
    {
      paramString = e(paramString, paramInt1, paramLong, paramInt2);
      return paramString;
    }
    finally
    {
      ((Lock)localObject).unlock();
    }
  }
  
  public List<MessageRecord> a(String paramString1, int paramInt1, long paramLong1, int paramInt2, long paramLong2, int paramInt3, String paramString2)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("queryTimedMessageDBUnion, peerUin = ");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(", type ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(",_id = ");
      ((StringBuilder)localObject).append(paramLong1);
      ((StringBuilder)localObject).append(",versionCode = ");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(", from ");
      ((StringBuilder)localObject).append(paramLong2);
      ((StringBuilder)localObject).append(",count = ");
      ((StringBuilder)localObject).append(paramInt3);
      ((StringBuilder)localObject).append(",whrere = ");
      ((StringBuilder)localObject).append(paramString2);
      QLog.d("Q.msg.MsgProxy", 2, ((StringBuilder)localObject).toString());
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
            localObject = (MessageRecord)paramString2.next();
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("queryTimedMessageDBUnion ");
            localStringBuilder.append(((MessageRecord)localObject).time);
            localStringBuilder.append(", ");
            localStringBuilder.append(((MessageRecord)localObject).getId());
            localStringBuilder.append(", ");
            localStringBuilder.append(((MessageRecord)localObject).getLogColorContent());
            QLog.i("QQMessageFacade", 2, localStringBuilder.toString());
          }
        }
        return paramString1;
      }
    }
    return new ArrayList();
  }
  
  public List<MessageRecord> a(String paramString, int paramInt1, long paramLong1, int paramInt2, long paramLong2, int paramInt3, int[] paramArrayOfInt)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("queryC2CMessageFromDB_UnionTables, peerUin = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", type ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(",_id = ");
      localStringBuilder.append(paramLong1);
      localStringBuilder.append(",versionCode = ");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(", from ");
      localStringBuilder.append(paramLong2);
      localStringBuilder.append(",count = ");
      localStringBuilder.append(paramInt3);
      localStringBuilder.append(",customTypes = ");
      localStringBuilder.append(Arrays.toString(paramArrayOfInt));
      QLog.d("Q.msg.MsgProxy", 2, localStringBuilder.toString());
    }
    if (a(paramString, paramInt1, true)) {
      this.proxyManager.transSaveToDatabase(paramString, paramInt1);
    }
    if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0))
    {
      localStringBuilder = new StringBuilder(" and msgtype in ( ");
      int i = 0;
      while (i < paramArrayOfInt.length)
      {
        localStringBuilder.append(paramArrayOfInt[i]);
        if (i < paramArrayOfInt.length - 1) {
          localStringBuilder.append(" , ");
        }
        i += 1;
      }
      localStringBuilder.append(") ");
      paramArrayOfInt = localStringBuilder.toString();
    }
    else
    {
      paramArrayOfInt = null;
    }
    paramArrayOfInt = a(paramString, paramInt1, paramLong1, paramInt2, paramLong2, paramInt3, paramArrayOfInt);
    paramString = paramArrayOfInt;
    if (paramArrayOfInt == null) {
      paramString = new ArrayList();
    }
    return paramString;
  }
  
  public List<MessageRecord> a(String paramString1, int paramInt1, long paramLong, int paramInt2, String paramString2)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("queryMessageByTimeOrSeq() called with: peerUin = [");
      localStringBuilder.append(paramString1);
      localStringBuilder.append("], type = [");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("], seq = [");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("], count = [");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append("], whereClause = [");
      localStringBuilder.append(paramString2);
      localStringBuilder.append("]");
      QLog.d("Q.msg.MsgProxy", 2, localStringBuilder.toString());
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("queryMessageByTimeOrSeq:uin=");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(",type=");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(",seq=");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(",count=");
      localStringBuilder.append(paramInt2);
      QLog.d("Q.msg.MsgProxy", 2, localStringBuilder.toString());
    }
    if (a(paramString1, paramInt1, true)) {
      this.proxyManager.transSaveToDatabase();
    }
    boolean bool = UinTypeUtil.g(paramInt1);
    if (a(paramString1, paramInt1))
    {
      if (bool) {
        paramString1 = c(paramString1, paramInt1, paramLong, paramInt2, paramString2);
      } else {
        paramString1 = b(paramString1, paramInt1, paramLong, paramInt2, paramString2);
      }
      if (paramString1 != null) {
        return paramString1;
      }
    }
    return new ArrayList();
  }
  
  public List<MessageRecord> a(String paramString, int paramInt, long paramLong1, long paramLong2)
  {
    if ((paramLong1 != 0L) && (paramLong2 != 0L) && (paramString != null) && (paramString.length() != 0))
    {
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
    return null;
  }
  
  public List<MessageRecord> a(String paramString, int paramInt1, long paramLong1, long paramLong2, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("queryMessageFromTimeRange, peerUin = ");
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append(", type ");
      ((StringBuilder)localObject1).append(paramInt1);
      ((StringBuilder)localObject1).append(",beginTime = ");
      ((StringBuilder)localObject1).append(paramLong1);
      ((StringBuilder)localObject1).append(",endTime = ");
      ((StringBuilder)localObject1).append(paramLong2);
      ((StringBuilder)localObject1).append(",topicId=");
      ((StringBuilder)localObject1).append(paramInt2);
      QLog.d("Q.msg.MsgProxy", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject3 = b(paramString, paramInt1);
    Object localObject2 = new ArrayList();
    Object localObject1 = localObject2;
    if (localObject3 != null)
    {
      localObject1 = localObject2;
      if (((List)localObject3).size() > 0)
      {
        localObject3 = ((List)localObject3).iterator();
        for (;;)
        {
          localObject1 = localObject2;
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
          localObject1 = (MessageRecord)((Iterator)localObject3).next();
          if ((((MessageRecord)localObject1).time >= paramLong1) && (((MessageRecord)localObject1).time <= paramLong2) && ((paramInt2 <= 0) || (((MessageRecord)localObject1).getConfessTopicId() == paramInt2))) {
            ((List)localObject2).add(localObject1);
          }
        }
      }
    }
    if ((((List)localObject1).size() > 0) && (((MessageRecord)((List)localObject1).get(0)).time == paramLong1)) {
      return localObject1;
    }
    if (a(paramString, paramInt1, true)) {
      this.proxyManager.transSaveToDatabase(a());
    }
    int i = a(paramInt1, paramInt2);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("select * from ");
    ((StringBuilder)localObject2).append(b(paramString, paramInt1));
    ((StringBuilder)localObject2).append(" where time>=? and time<=?");
    if (i != 0) {
      ((StringBuilder)localObject2).append(" and (extLong & 4194296)=?");
    }
    ((StringBuilder)localObject2).append(" order by time asc");
    if (QLog.isColorLevel())
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("queryMessageFromTimeRange ");
      ((StringBuilder)localObject3).append(((StringBuilder)localObject2).toString());
      QLog.d("Q.msg.MsgProxy", 2, ((StringBuilder)localObject3).toString());
    }
    if (((List)localObject1).size() > 0) {
      paramLong2 = ((MessageRecord)((List)localObject1).get(0)).time;
    }
    paramLong1 = Math.min(paramLong1, paramLong2);
    a((List)localObject1, paramLong2);
    if (i == 0) {
      localObject2 = jdField_a_of_type_ComTencentImcoreMessageBaseMsgProxy$Callback.a(((StringBuilder)localObject2).toString(), new String[] { String.valueOf(paramLong1), String.valueOf(paramLong2) }, this);
    } else {
      localObject2 = jdField_a_of_type_ComTencentImcoreMessageBaseMsgProxy$Callback.a(((StringBuilder)localObject2).toString(), new String[] { String.valueOf(paramLong1), String.valueOf(paramLong2), String.valueOf(i) }, this);
    }
    if (QLog.isColorLevel())
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("queryMessageFromTimeRange, peerUin = ");
      ((StringBuilder)localObject3).append(paramString);
      ((StringBuilder)localObject3).append(", type ");
      ((StringBuilder)localObject3).append(paramInt1);
      ((StringBuilder)localObject3).append(",queryBeginTime = ");
      ((StringBuilder)localObject3).append(paramLong1);
      ((StringBuilder)localObject3).append(",queryEndTime = ");
      ((StringBuilder)localObject3).append(paramLong2);
      ((StringBuilder)localObject3).append(",resultSize=");
      if (localObject2 == null) {
        paramInt1 = 0;
      } else {
        paramInt1 = ((List)localObject2).size();
      }
      ((StringBuilder)localObject3).append(paramInt1);
      ((StringBuilder)localObject3).append(",topicId=");
      ((StringBuilder)localObject3).append(paramInt2);
      QLog.d("Q.msg.MsgProxy", 2, ((StringBuilder)localObject3).toString());
    }
    if (localObject2 != null)
    {
      ((List)localObject1).addAll(0, (Collection)localObject2);
      return localObject1;
    }
    return localObject1;
  }
  
  public List<MessageRecord> a(String paramString, int paramInt, long paramLong, @NonNull Map<String, MessageRecord> paramMap)
  {
    Object localObject = paramMap;
    if (paramMap == null) {
      localObject = new HashMap();
    }
    if (QLog.isColorLevel())
    {
      paramMap = new StringBuilder();
      paramMap.append("querySameSeqMessageWithFilter,  peerUin = ");
      paramMap.append(paramString);
      paramMap.append(", type ");
      paramMap.append(paramInt);
      paramMap.append(", seq = ");
      paramMap.append(paramLong);
      paramMap.append(", filterMsgSet.size = ");
      paramMap.append(((Map)localObject).size());
      paramMap.append(",filterMsgSet = ");
      paramMap.append(((Map)localObject).keySet());
      QLog.d("Q.msg.MsgProxy", 2, paramMap.toString());
    }
    if (a(paramString, paramInt, true)) {
      this.proxyManager.transSaveToDatabase(a());
    }
    paramMap = new StringBuilder();
    paramMap.append("select * from ");
    paramMap.append(b(paramString, paramInt));
    paramMap.append(" where shmsgseq=?");
    paramString = paramMap.toString();
    if (QLog.isColorLevel())
    {
      paramMap = new StringBuilder();
      paramMap.append("querySameSeqMessageWithFilter ");
      paramMap.append(paramString);
      QLog.d("Q.msg.MsgProxy", 2, paramMap.toString());
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
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("filter msg , seq = ");
        localStringBuilder.append(localMessageRecord.shmsgseq);
        localStringBuilder.append(" ,id = ");
        localStringBuilder.append(localMessageRecord.getId());
        localStringBuilder.append(",uniseq=");
        localStringBuilder.append(localMessageRecord.uniseq);
        QLog.d("Q.msg.MsgProxy", 2, localStringBuilder.toString());
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("id&");
      localStringBuilder.append(localMessageRecord.getId());
      localStringBuilder.append("&");
      localStringBuilder.append(localMessageRecord.shmsgseq);
      if (!((Map)localObject).containsKey(localStringBuilder.toString()))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("uniseq&");
        localStringBuilder.append(localMessageRecord.uniseq);
        localStringBuilder.append("&");
        localStringBuilder.append(localMessageRecord.shmsgseq);
        if (!((Map)localObject).containsKey(localStringBuilder.toString())) {
          paramString.add(localMessageRecord);
        }
      }
    }
    return paramString;
  }
  
  public List<MessageRecord> a(String paramString, int paramInt, List<Long> paramList)
  {
    if ((paramList != null) && (paramString != null) && (paramString.length() != 0) && (paramList.size() != 0))
    {
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < paramList.size())
      {
        MessageRecord localMessageRecord = a(paramString, paramInt, ((Long)paramList.get(i)).longValue());
        if (localMessageRecord == null) {
          break;
        }
        localArrayList.add(localMessageRecord);
        i += 1;
      }
      if (i < paramList.size() - 1) {
        localArrayList.addAll(d(paramString, paramInt, paramList.subList(i, paramList.size())));
      }
      return localArrayList;
    }
    return new ArrayList();
  }
  
  public List<MessageRecord> a(String paramString, int paramInt, int[] paramArrayOfInt)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = d(paramString, paramInt);
    paramString = new HashSet();
    a(paramArrayOfInt, paramString);
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      if (paramString.isEmpty())
      {
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("getAllMessages size = ");
          paramString.append(localArrayList.size());
          QLog.d("Q.msg.MsgProxy", 2, paramString.toString());
        }
        return localArrayList;
      }
      paramArrayOfInt = ((List)localObject).iterator();
      long l = 9223372036854775807L;
      while (paramArrayOfInt.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)paramArrayOfInt.next();
        if (localMessageRecord.shmsgseq < l) {
          l = localMessageRecord.shmsgseq;
        }
      }
      paramArrayOfInt = ((List)localObject).iterator();
      while (paramArrayOfInt.hasNext())
      {
        localObject = (MessageRecord)paramArrayOfInt.next();
        if (((!UinTypeUtil.g(paramInt)) || (((MessageRecord)localObject).versionCode != 3) || (((MessageRecord)localObject).shmsgseq != l) || (l == 0L)) && ((paramString.contains(Integer.valueOf(((MessageRecord)localObject).msgtype))) || (paramString.isEmpty()))) {
          localArrayList.add(localObject);
        }
      }
    }
    return localArrayList;
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
  
  /* Error */
  public void a(QueryHistoryParam paramQueryHistoryParam)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 1379	com/tencent/imcore/message/QueryHistoryParam:a	()Ljava/lang/String;
    //   4: invokestatic 802	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7: ifeq +4 -> 11
    //   10: return
    //   11: aload_0
    //   12: aload_1
    //   13: invokevirtual 1379	com/tencent/imcore/message/QueryHistoryParam:a	()Ljava/lang/String;
    //   16: aload_1
    //   17: invokevirtual 1381	com/tencent/imcore/message/QueryHistoryParam:a	()I
    //   20: iconst_1
    //   21: invokevirtual 593	com/tencent/imcore/message/MsgProxy:a	(Ljava/lang/String;IZ)Z
    //   24: ifeq +10 -> 34
    //   27: aload_0
    //   28: getfield 167	com/tencent/imcore/message/MsgProxy:proxyManager	Lcom/tencent/mobileqq/app/proxy/BaseProxyManager;
    //   31: invokevirtual 534	com/tencent/mobileqq/app/proxy/BaseProxyManager:transSaveToDatabase	()V
    //   34: invokestatic 1386	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getServerTime	()J
    //   37: lstore_3
    //   38: aload_0
    //   39: aload_1
    //   40: invokevirtual 1379	com/tencent/imcore/message/QueryHistoryParam:a	()Ljava/lang/String;
    //   43: aload_1
    //   44: invokevirtual 1381	com/tencent/imcore/message/QueryHistoryParam:a	()I
    //   47: invokevirtual 450	com/tencent/imcore/message/MsgProxy:b	(Ljava/lang/String;I)Ljava/lang/String;
    //   50: astore 5
    //   52: aload_0
    //   53: invokevirtual 211	com/tencent/imcore/message/MsgProxy:a	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   56: astore 6
    //   58: aload_1
    //   59: invokevirtual 1388	com/tencent/imcore/message/QueryHistoryParam:b	()I
    //   62: istore_2
    //   63: aload 6
    //   65: iconst_0
    //   66: aload 5
    //   68: aconst_null
    //   69: ldc_w 1390
    //   72: iconst_4
    //   73: anewarray 121	java/lang/String
    //   76: dup
    //   77: iconst_0
    //   78: sipush -1000
    //   81: invokestatic 124	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   84: aastore
    //   85: dup
    //   86: iconst_1
    //   87: sipush -1035
    //   90: invokestatic 124	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   93: aastore
    //   94: dup
    //   95: iconst_2
    //   96: sipush -2011
    //   99: invokestatic 124	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   102: aastore
    //   103: dup
    //   104: iconst_3
    //   105: lload_3
    //   106: ldc2_w 1391
    //   109: lsub
    //   110: invokestatic 668	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   113: aastore
    //   114: aconst_null
    //   115: aconst_null
    //   116: ldc_w 883
    //   119: iload_2
    //   120: invokestatic 124	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   123: invokevirtual 707	com/tencent/mobileqq/persistence/EntityManager:query	(ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   126: astore 5
    //   128: aload_1
    //   129: aload 5
    //   131: invokevirtual 1395	com/tencent/imcore/message/QueryHistoryParam:a	(Landroid/database/Cursor;)V
    //   134: aload_0
    //   135: aload_1
    //   136: invokevirtual 1397	com/tencent/imcore/message/MsgProxy:b	(Lcom/tencent/imcore/message/QueryHistoryParam;)V
    //   139: aload 5
    //   141: ifnull +41 -> 182
    //   144: aload 5
    //   146: invokeinterface 374 1 0
    //   151: return
    //   152: astore_1
    //   153: goto +30 -> 183
    //   156: astore_1
    //   157: invokestatic 65	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   160: ifeq +14 -> 174
    //   163: ldc 80
    //   165: iconst_2
    //   166: aload_1
    //   167: iconst_0
    //   168: anewarray 30	java/lang/Object
    //   171: invokestatic 888	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   174: aload 5
    //   176: ifnull +6 -> 182
    //   179: goto -35 -> 144
    //   182: return
    //   183: aload 5
    //   185: ifnull +10 -> 195
    //   188: aload 5
    //   190: invokeinterface 374 1 0
    //   195: goto +5 -> 200
    //   198: aload_1
    //   199: athrow
    //   200: goto -2 -> 198
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	203	0	this	MsgProxy
    //   0	203	1	paramQueryHistoryParam	QueryHistoryParam
    //   62	58	2	i	int
    //   37	69	3	l	long
    //   50	139	5	localObject	Object
    //   56	8	6	localEntityManager	EntityManager
    // Exception table:
    //   from	to	target	type
    //   128	139	152	finally
    //   157	174	152	finally
    //   128	139	156	java/lang/Exception
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
    String str1;
    if (UinTypeUtil.g(paramInt)) {
      str1 = "shmsgseq";
    } else {
      str1 = "time";
    }
    String str2 = String.valueOf(paramLong);
    String str3 = b(paramString, paramInt);
    if ((UinTypeUtil.e(paramInt)) && (UinTypeUtil.d() != null))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isread=? and %s<=? and ");
      localStringBuilder.append(UinTypeUtil.d());
      a(paramString, paramInt, str3, localContentValues, String.format(localStringBuilder.toString(), new Object[] { str1 }), new String[] { "0", str2 }, null);
      return;
    }
    a(paramString, paramInt, str3, localContentValues, String.format("isread=? and %s<=?", new Object[] { str1 }), new String[] { "0", str2 }, null);
  }
  
  public void a(String paramString, int paramInt, long paramLong, ContentValues paramContentValues)
  {
    MessageRecord localMessageRecord = a(paramString, paramInt, paramLong);
    if (localMessageRecord != null)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("updateMsgContent: set msg = ");
        localStringBuilder.append(localMessageRecord.getBaseInfoString());
        QLog.d("Q.msg.MsgProxy", 2, localStringBuilder.toString());
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
    if ((UinTypeUtil.d(paramMessageRecord.msgtype)) && (!UinTypeUtil.a(paramMessageRecord.frienduin, paramMessageRecord.istroop))) {
      return;
    }
    if (!paramBoolean2) {
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
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("insertToList ");
      ((StringBuilder)localObject).append(paramMessageRecord.getBaseInfoString());
      QLog.d("Q.msg.MsgProxy", 2, ((StringBuilder)localObject).toString());
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("insertToList ");
      ((StringBuilder)localObject).append(paramMessageRecord.getUserLogString());
      QLog.d("Q.msg.MsgProxy", 1, ((StringBuilder)localObject).toString());
    }
    Object localObject = a(paramString, paramInt);
    ((Lock)localObject).lock();
    try
    {
      b(paramString, paramInt, paramMessageRecord, paramBoolean);
      return;
    }
    finally
    {
      ((Lock)localObject).unlock();
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
      return paramLong >= paramMessageRecord.shmsgseq;
    }
    return paramLong >= paramMessageRecord.time;
  }
  
  protected boolean a(String paramString, int paramInt)
  {
    return MessageDBUtils.a(b(paramString, paramInt), b());
  }
  
  protected boolean a(String paramString1, int paramInt, String paramString2, List<MessageRecord> paramList)
  {
    if (a(paramString1, paramInt, paramString2))
    {
      if (QLog.isColorLevel())
      {
        paramString2 = new StringBuilder();
        paramString2.append("insertToAioMsgPool because of orderMediaMsgSending ");
        paramString2.append(paramString1);
        QLog.d("Q.msg.MsgProxy", 2, paramString2.toString());
      }
      paramString2 = new ArrayList();
      if (paramList.size() > 15) {
        paramString2.addAll(paramList.subList(paramList.size() - 15, paramList.size()));
      } else {
        paramString2.addAll(paramList);
      }
      b(paramString1, paramInt, paramString2);
      return true;
    }
    return false;
  }
  
  public boolean a(String paramString, int paramInt, boolean paramBoolean)
  {
    if (paramString == null) {
      return false;
    }
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
    for (;;)
    {
      throw paramString;
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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("--->removeSingleMsg : peerUin:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" type:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" uniseq:");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(" mr:");
      localStringBuilder.append(localMessageRecord);
      localStringBuilder.append(" dbid:");
      Object localObject;
      if (localMessageRecord != null) {
        localObject = Long.valueOf(localMessageRecord.getId());
      } else {
        localObject = "mr is null.";
      }
      localStringBuilder.append(localObject);
      QLog.d("Q.msg.MsgProxy", 2, localStringBuilder.toString());
    }
    if (localMessageRecord != null)
    {
      long l = localMessageRecord.getId();
      if (l != -1L) {
        a(paramString, paramInt, b(paramString, paramInt), "_id=?", new String[] { String.valueOf(l) }, null);
      } else {
        a(paramString, paramInt, b(paramString, paramInt), "uniseq=?", new String[] { String.valueOf(paramLong) }, null);
      }
      a(localMessageRecord.frienduin, localMessageRecord.istroop);
      if (localMessageRecord.isread) {
        return 1;
      }
      return 2;
    }
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
    if (UinTypeUtil.g(paramInt)) {
      paramString = "shmsgseq asc , _id desc";
    } else {
      paramString = "time asc , _id desc";
    }
    paramString = String.format("select * from %s m where m.isValid=1 and m.msgtype %s order by %s limit 1", new Object[] { str1, str2, paramString });
    paramString = a().rawQuery(MessageRecord.class, paramString, null);
    if ((paramString != null) && (!paramString.isEmpty())) {
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
    if (UinTypeUtil.g(paramInt1)) {
      paramString = "shmsgseq desc , _id desc";
    } else {
      paramString = "time desc , _id desc";
    }
    paramString = String.format(str2, new Object[] { str1, paramString });
    paramString = a().rawQuery(MessageRecord.class, paramString, null);
    if ((paramString != null) && (!paramString.isEmpty()))
    {
      paramInt1 = paramString.size() - 1;
      while (paramInt1 >= 0)
      {
        if (((MessageRecord)paramString.get(paramInt1)).getConfessTopicId() == paramInt2) {
          return (MessageRecord)paramString.get(paramInt1);
        }
        paramInt1 -= 1;
      }
    }
    return null;
  }
  
  public MessageRecord b(String paramString, int paramInt, long paramLong)
  {
    Object localObject1 = null;
    Object localObject3 = null;
    Object localObject2 = localObject1;
    if (paramLong != 0L)
    {
      localObject2 = localObject1;
      if (paramString != null)
      {
        if (paramString.length() == 0) {
          return null;
        }
        localObject2 = c(paramString, paramInt);
        localObject1 = localObject3;
        if (localObject2 != null)
        {
          localObject2 = ((List)localObject2).iterator();
          do
          {
            localObject1 = localObject3;
            if (!((Iterator)localObject2).hasNext()) {
              break;
            }
            localObject1 = (MessageRecord)((Iterator)localObject2).next();
          } while (((MessageRecord)localObject1).uniseq != paramLong);
        }
        localObject2 = localObject1;
        if (localObject1 == null)
        {
          paramString = a(paramString, paramInt, paramLong);
          localObject2 = localObject1;
          if (paramString != null)
          {
            localObject2 = localObject1;
            if (!paramString.isEmpty()) {
              localObject2 = (MessageRecord)paramString.get(0);
            }
          }
        }
      }
    }
    return localObject2;
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
    synchronized (this.proxyManager.getMsgQueueLock())
    {
      Object localObject2 = this.proxyManager.getQueue();
      ArrayList localArrayList = new ArrayList();
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
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MsgProxy", 2, new Object[] { "getMsgListFromQueue uin=", paramString, ", type=", Integer.valueOf(paramInt1), ", size=", Integer.valueOf(localArrayList.size()) });
      }
      return localArrayList;
    }
    for (;;)
    {
      throw paramString;
    }
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
    Object localObject2 = "";
    Object localObject1;
    if (paramInt2 > 0)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("limit ");
      ((StringBuilder)localObject1).append(paramInt2);
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    else
    {
      localObject1 = "";
    }
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("select * from ");
    ((StringBuilder)localObject3).append(b(paramString1, paramInt1));
    ((StringBuilder)localObject3).append(" where time<%d %s order by time desc, _id desc %s");
    localObject3 = ((StringBuilder)localObject3).toString();
    if (paramString2 == null)
    {
      paramString2 = (String)localObject2;
    }
    else
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("and ");
      ((StringBuilder)localObject2).append(paramString2);
      paramString2 = ((StringBuilder)localObject2).toString();
    }
    paramString2 = String.format((String)localObject3, new Object[] { Long.valueOf(paramLong), paramString2, localObject1 });
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("queryMessageByTime: sql=");
      ((StringBuilder)localObject1).append(paramString2);
      ((StringBuilder)localObject1).append(", peeruin = ");
      ((StringBuilder)localObject1).append(paramString1);
      ((StringBuilder)localObject1).append(", type = ");
      ((StringBuilder)localObject1).append(paramInt1);
      QLog.d("Q.msg.MsgProxy", 2, ((StringBuilder)localObject1).toString());
    }
    paramString2 = jdField_a_of_type_ComTencentImcoreMessageBaseMsgProxy$Callback.a(paramString2, null, this);
    if (paramString2 != null) {
      Collections.reverse(paramString2);
    }
    if (paramString2 != null)
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("queryMessageByTime: list size =");
        ((StringBuilder)localObject1).append(paramString2.size());
        ((StringBuilder)localObject1).append(", peeruin = ");
        ((StringBuilder)localObject1).append(paramString1);
        ((StringBuilder)localObject1).append(", type = ");
        ((StringBuilder)localObject1).append(paramInt1);
        QLog.d("Q.msg.MsgProxy", 2, ((StringBuilder)localObject1).toString());
      }
      return paramString2;
    }
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append("queryMessageByTime: null list , peeruin = ");
      paramString2.append(paramString1);
      paramString2.append(", type = ");
      paramString2.append(paramInt1);
      QLog.d("Q.msg.MsgProxy", 2, paramString2.toString());
    }
    return new ArrayList();
  }
  
  public List<MessageRecord> b(String paramString, int paramInt, long paramLong1, long paramLong2)
  {
    if ((paramLong1 != 0L) && (paramLong2 != 0L) && (paramString != null) && (paramString.length() != 0))
    {
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
    return null;
  }
  
  /* Error */
  public List<MessageRecord> b(String paramString, int paramInt, List<Integer> paramList)
  {
    // Byte code:
    //   0: aload_3
    //   1: invokeinterface 254 1 0
    //   6: bipush 50
    //   8: if_icmple +16 -> 24
    //   11: aload_3
    //   12: iconst_0
    //   13: bipush 50
    //   15: invokeinterface 258 3 0
    //   20: astore_3
    //   21: goto +3 -> 24
    //   24: aload_0
    //   25: aload_1
    //   26: iload_2
    //   27: invokevirtual 450	com/tencent/imcore/message/MsgProxy:b	(Ljava/lang/String;I)Ljava/lang/String;
    //   30: astore_1
    //   31: iconst_1
    //   32: anewarray 121	java/lang/String
    //   35: astore 4
    //   37: new 308	java/util/ArrayList
    //   40: dup
    //   41: invokespecial 309	java/util/ArrayList:<init>	()V
    //   44: astore 5
    //   46: aload_3
    //   47: invokeinterface 49 1 0
    //   52: astore 6
    //   54: aload 6
    //   56: invokeinterface 54 1 0
    //   61: ifeq +126 -> 187
    //   64: aload 4
    //   66: iconst_0
    //   67: aload 6
    //   69: invokeinterface 58 1 0
    //   74: checkcast 201	java/lang/Integer
    //   77: invokevirtual 1568	java/lang/Integer:intValue	()I
    //   80: invokestatic 124	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   83: aastore
    //   84: aload_0
    //   85: invokevirtual 211	com/tencent/imcore/message/MsgProxy:a	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   88: iconst_0
    //   89: aload_1
    //   90: aconst_null
    //   91: ldc_w 1570
    //   94: aload 4
    //   96: aconst_null
    //   97: aconst_null
    //   98: aconst_null
    //   99: aconst_null
    //   100: invokevirtual 707	com/tencent/mobileqq/persistence/EntityManager:query	(ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   103: astore_3
    //   104: aload_3
    //   105: ifnull +75 -> 180
    //   108: aload 5
    //   110: aload_0
    //   111: invokevirtual 211	com/tencent/imcore/message/MsgProxy:a	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   114: ldc 60
    //   116: aconst_null
    //   117: aload_3
    //   118: invokevirtual 1573	com/tencent/mobileqq/persistence/EntityManager:cursor2Entity	(Ljava/lang/Class;Ljava/lang/String;Landroid/database/Cursor;)Lcom/tencent/mobileqq/persistence/Entity;
    //   121: checkcast 60	com/tencent/mobileqq/data/MessageRecord
    //   124: invokevirtual 865	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   127: pop
    //   128: goto +52 -> 180
    //   131: astore_1
    //   132: goto +36 -> 168
    //   135: astore 7
    //   137: invokestatic 65	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   140: ifeq +15 -> 155
    //   143: ldc 80
    //   145: iconst_2
    //   146: aload 7
    //   148: iconst_0
    //   149: anewarray 30	java/lang/Object
    //   152: invokestatic 888	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   155: aload_3
    //   156: ifnull -102 -> 54
    //   159: aload_3
    //   160: invokeinterface 374 1 0
    //   165: goto -111 -> 54
    //   168: aload_3
    //   169: ifnull +9 -> 178
    //   172: aload_3
    //   173: invokeinterface 374 1 0
    //   178: aload_1
    //   179: athrow
    //   180: aload_3
    //   181: ifnull -127 -> 54
    //   184: goto -25 -> 159
    //   187: aload 5
    //   189: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	190	0	this	MsgProxy
    //   0	190	1	paramString	String
    //   0	190	2	paramInt	int
    //   0	190	3	paramList	List<Integer>
    //   35	60	4	arrayOfString	String[]
    //   44	144	5	localArrayList	ArrayList
    //   52	16	6	localIterator	Iterator
    //   135	12	7	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   108	128	131	finally
    //   137	155	131	finally
    //   108	128	135	java/lang/Exception
  }
  
  protected List<MessageRecord> b(List<MessageRecord> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = new ArrayList(paramList);
    HashSet localHashSet = new HashSet();
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      if (localHashSet.contains(UinTypeUtil.b((MessageRecord)paramList.get(i)))) {
        localArrayList.add(paramList.get(i));
      } else {
        localHashSet.add(UinTypeUtil.b((MessageRecord)paramList.get(i)));
      }
      i -= 1;
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
    if (a().containsKey(localObject1))
    {
      localObject1 = a((String)localObject1);
      int i = 0;
      Object localObject2;
      Object localObject3;
      while (i < ((List)localObject1).size())
      {
        localObject2 = (MessageRecord)((List)localObject1).get(i);
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("find cache ");
          ((StringBuilder)localObject3).append(((MessageRecord)localObject2).getBaseInfoString());
          QLog.d("Q.msg.MsgProxy", 2, ((StringBuilder)localObject3).toString());
        }
        if (((MessageRecord)localObject2).uniseq == paramLong) {
          break label128;
        }
        i += 1;
      }
      i = 0;
      label128:
      if ((i > 0) && (i < ((List)localObject1).size()))
      {
        localObject2 = new ArrayList();
        int j = 0;
        while (j < i)
        {
          localObject3 = (MessageRecord)((List)localObject1).get(j);
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("removeList ");
            localStringBuilder.append(((MessageRecord)localObject3).getBaseInfoString());
            QLog.d("Q.msg.MsgProxy", 2, localStringBuilder.toString());
          }
          ((List)localObject2).add(localObject3);
          j += 1;
        }
        ((List)localObject1).removeAll((Collection)localObject2);
        ((List)localObject2).clear();
        ((List)localObject1).addAll(0, paramList);
      }
      else if (i == 0)
      {
        ((List)localObject1).addAll(0, paramList);
      }
      if (((List)localObject1).size() > 40)
      {
        i = ((List)localObject1).size() - 40;
        while (i > 0)
        {
          ((List)localObject1).remove(0);
          i -= 1;
        }
      }
      c(paramString, paramInt, (List)localObject1);
    }
  }
  
  public void b(String paramString, int paramInt, MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord != null)
    {
      if (paramMessageRecord.uniseq != 0L) {
        return;
      }
      if (paramMessageRecord.getId() > 0L)
      {
        paramMessageRecord.createMessageUniseq();
        ContentValues localContentValues = new ContentValues();
        localContentValues.put("uniseq", Long.valueOf(paramMessageRecord.uniseq));
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("updateUniseqByID: set msg =");
          localStringBuilder.append(paramMessageRecord.getBaseInfoString());
          QLog.d("Q.msg.MsgProxy", 2, localStringBuilder.toString());
        }
        a(paramString, paramInt, paramMessageRecord.versionCode, localContentValues, "_id=?", new String[] { String.valueOf(paramMessageRecord.getId()) }, null);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.w("Q.msg.MsgProxy", 2, "updateUniseqByID ERROR: _id<0 !");
      }
    }
  }
  
  public void b(String paramString, int paramInt1, MessageRecord paramMessageRecord, int paramInt2)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("isread", Boolean.valueOf(true));
    if (((paramInt1 == 1001) || (paramInt1 == 10002)) && (paramMessageRecord.msgtype != -1003) && (paramMessageRecord.msgtype != -1031) && (paramMessageRecord.msgtype != -1032) && (paramMessageRecord.msgtype != 201))
    {
      String str;
      if (paramMessageRecord.versionCode > 0) {
        str = b(String.valueOf(AppConstants.LBS_HELLO_UIN), 1001);
      } else {
        str = d(String.valueOf(AppConstants.LBS_HELLO_UIN), 1001);
      }
      a(paramString, paramInt1, str, localContentValues, "senderuin=? and isread=?", new String[] { paramString, "0" }, null);
      a(paramString, paramInt1, paramMessageRecord.versionCode, localContentValues, "isread=?", new String[] { "0" }, null);
      return;
    }
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
    if ((paramInt1 == 1032) && (TextUtils.equals(paramString, AppConstants.CONFESS_UIN))) {
      a(paramString, paramInt1, b(paramString, paramInt1), localContentValues, "isread=?", new String[] { "0" }, null);
    }
  }
  
  protected void b(String paramString, int paramInt, List<MessageRecord> paramList)
  {
    a().put(a(paramString, paramInt), paramList);
  }
  
  protected int c(String paramString, int paramInt, long paramLong)
  {
    if (paramString == null) {
      return 0;
    }
    synchronized (this.proxyManager.getMsgQueueLock())
    {
      Iterator localIterator = this.proxyManager.getQueue().iterator();
      int i = 0;
      while (localIterator.hasNext())
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
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MsgProxy", 2, new Object[] { "getUnreadCountFromQueue uin=", paramString, ", type=", Integer.valueOf(paramInt), ", lastRead=", Integer.valueOf(i) });
      }
      return i;
    }
    for (;;)
    {
      throw paramString;
    }
  }
  
  public MessageRecord c(String paramString, int paramInt, long paramLong)
  {
    if ((paramLong != 0L) && (paramString != null) && (paramString.length() != 0))
    {
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
    return null;
  }
  
  protected String c(String paramString, int paramInt)
  {
    if (UinTypeUtil.a(paramString))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("select * from ");
      localStringBuilder.append(b(paramString, paramInt));
      localStringBuilder.append(" order by time desc , _id desc");
      return localStringBuilder.toString();
    }
    if (UinTypeUtil.b(paramInt))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("select * from ");
      localStringBuilder.append(b(paramString, paramInt));
      localStringBuilder.append(" where _id in (select _id from ");
      localStringBuilder.append(b(paramString, paramInt));
      localStringBuilder.append(" order by time desc limit ");
      localStringBuilder.append(40);
      localStringBuilder.append(") order by time desc, _id desc");
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("select * from ");
    localStringBuilder.append(b(paramString, paramInt));
    localStringBuilder.append(" order by _id desc limit ");
    localStringBuilder.append(40);
    return localStringBuilder.toString();
  }
  
  protected List<MessageRecord> c(String paramString)
  {
    synchronized (this.proxyManager.getMsgQueueLock())
    {
      Object localObject2 = this.proxyManager.getQueue();
      ArrayList localArrayList = new ArrayList();
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
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MsgProxy", 2, new Object[] { "getMsgListFromQueue tableName=", paramString, ", size=", Integer.valueOf(localArrayList.size()) });
      }
      return localArrayList;
    }
    for (;;)
    {
      throw paramString;
    }
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
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("queryBeforeHistoryByShmsgseq uin=");
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append(", type=");
      ((StringBuilder)localObject1).append(paramInt1);
      ((StringBuilder)localObject1).append(", seq=");
      ((StringBuilder)localObject1).append(paramLong);
      ((StringBuilder)localObject1).append(", count=");
      ((StringBuilder)localObject1).append(paramInt2);
      QLog.d("Q.msg.MsgProxy", 2, ((StringBuilder)localObject1).toString());
    }
    if (a(paramString, paramInt1, true)) {
      this.proxyManager.transSaveToDatabase();
    }
    Object localObject1 = b(paramString, paramInt1);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("select * from ");
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(" where (shmsgseq < ? and msgtype ");
    ((StringBuilder)localObject2).append(UinTypeUtil.a());
    ((StringBuilder)localObject2).append(" and isValid=1) order by shmsgseq desc limit ");
    Object localObject3 = ((StringBuilder)localObject2).toString();
    String[] arrayOfString = new String[1];
    arrayOfString[0] = String.valueOf(paramLong);
    localObject1 = jdField_a_of_type_ComTencentImcoreMessageBaseMsgProxy$Callback;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject3);
    ((StringBuilder)localObject2).append(paramInt2);
    localObject2 = ((BaseMsgProxy.Callback)localObject1).a(((StringBuilder)localObject2).toString(), arrayOfString, this);
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new ArrayList();
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("queryBeforeHistoryByShmsgseq list.size=");
      ((StringBuilder)localObject2).append(((List)localObject1).size());
      QLog.d("Q.msg.MsgProxy", 2, ((StringBuilder)localObject2).toString());
    }
    if (((List)localObject1).size() < paramInt2)
    {
      paramString = jdField_a_of_type_ComTencentImcoreMessageBaseMsgProxy$Callback.a(paramString, paramInt1, paramLong, paramInt2 - ((List)localObject1).size(), (String)localObject3, arrayOfString, this, this.app);
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
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("queryBeforeHistoryByShmsgseq ");
        ((StringBuilder)localObject3).append(((MessageRecord)localObject2).time);
        ((StringBuilder)localObject3).append(", ");
        ((StringBuilder)localObject3).append(((MessageRecord)localObject2).getId());
        ((StringBuilder)localObject3).append(", ");
        ((StringBuilder)localObject3).append(((MessageRecord)localObject2).getLogColorContent());
        QLog.d("Q.msg.MsgProxy", 2, ((StringBuilder)localObject3).toString());
      }
      paramString = new StringBuilder();
      paramString.append("queryBeforeHistoryByShmsgseq return size=");
      paramString.append(((List)localObject1).size());
      QLog.d("Q.msg.MsgProxy", 2, paramString.toString());
    }
    return localObject1;
  }
  
  protected List<MessageRecord> c(String paramString1, int paramInt1, long paramLong, int paramInt2, String paramString2)
  {
    if (a(paramString1, paramInt1, true)) {
      this.proxyManager.transSaveToDatabase(a());
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("select * from ");
    ((StringBuilder)localObject).append(b(paramString1, paramInt1));
    ((StringBuilder)localObject).append(" where shmsgseq<=? and shmsgseq>? %s order by shmsgseq asc");
    localObject = ((StringBuilder)localObject).toString();
    if (paramString2 == null)
    {
      paramString2 = "";
    }
    else
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("and ");
      localStringBuilder.append(paramString2);
      paramString2 = localStringBuilder.toString();
    }
    paramString2 = String.format((String)localObject, new Object[] { paramString2 });
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("queryMessageBySeq: sql=");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(", peeruin = ");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(", type = ");
      ((StringBuilder)localObject).append(paramInt1);
      QLog.d("Q.msg.MsgProxy", 2, ((StringBuilder)localObject).toString());
    }
    long l1 = 0L;
    if (paramInt2 > 0)
    {
      long l2 = paramInt2;
      if (paramLong > l2) {
        l1 = paramLong - l2;
      }
    }
    paramString2 = jdField_a_of_type_ComTencentImcoreMessageBaseMsgProxy$Callback.a(paramString2, new String[] { String.valueOf(paramLong), String.valueOf(l1) }, this);
    if (paramString2 != null)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("queryMessageBySeq: list size =");
        ((StringBuilder)localObject).append(paramString2.size());
        ((StringBuilder)localObject).append(", peeruin = ");
        ((StringBuilder)localObject).append(paramString1);
        ((StringBuilder)localObject).append(", type = ");
        ((StringBuilder)localObject).append(paramInt1);
        QLog.d("Q.msg.MsgProxy", 2, ((StringBuilder)localObject).toString());
      }
      return paramString2;
    }
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append("queryMessageBySeq: null list , peeruin = ");
      paramString2.append(paramString1);
      paramString2.append(", type = ");
      paramString2.append(paramInt1);
      QLog.d("Q.msg.MsgProxy", 2, paramString2.toString());
    }
    return new ArrayList();
  }
  
  public List<MessageRecord> c(String paramString, int paramInt, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("queryMessageFromBySeq, peerUin = ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", type ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(",beginSeq = ");
      ((StringBuilder)localObject).append(paramLong1);
      ((StringBuilder)localObject).append(",endSeq = ");
      ((StringBuilder)localObject).append(paramLong2);
      QLog.d("Q.msg.MsgProxy", 2, ((StringBuilder)localObject).toString());
    }
    if (a(paramString, paramInt, true)) {
      this.proxyManager.transSaveToDatabase(a());
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("select * from ");
    ((StringBuilder)localObject).append(b(paramString, paramInt));
    ((StringBuilder)localObject).append(" where shmsgseq>=? and shmsgseq<=? order by shmsgseq asc");
    paramString = ((StringBuilder)localObject).toString();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("queryMessageFromBySeq ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("Q.msg.MsgProxy", 2, ((StringBuilder)localObject).toString());
    }
    localObject = jdField_a_of_type_ComTencentImcoreMessageBaseMsgProxy$Callback.a(paramString, new String[] { String.valueOf(paramLong1), String.valueOf(paramLong2) }, this);
    paramString = (String)localObject;
    if (localObject == null) {
      paramString = new ArrayList();
    }
    return paramString;
  }
  
  public List<MessageRecord> c(String paramString, int paramInt, List<MessageRecord> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramInt != 0) && (paramInt != 1000) && (paramInt != 1004) && (paramInt != 1044) && (paramInt != 1045))
    {
      localArrayList.addAll(paramList);
      return localArrayList;
    }
    return a(paramString, paramInt, paramList, localArrayList);
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
    if ((paramLong != 0L) && (paramString != null) && (paramString.length() != 0))
    {
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
    return null;
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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("select _id, extraflag, frienduin, isread, issend, istroop, msg, NULL as msgData, msgId, msgseq, msgtype, selfuin, senderuin, shmsgseq, time, 0 as versionCode, NULL as longMsgIndex, NULL as longMsgId, NULL as longMsgCount, 1 as isValid, NULL as msgUid, NULL as vipBubbleID, 0 as uniseq, 0 as sendFailCode, NULL as extStr, 0 as extInt, 0 as extLong from ( select _id, extraflag, frienduin, isread, issend, istroop, msg, NULL as msgData, msgId, msgseq, msgtype, selfuin, senderuin, shmsgseq, time, 0 as versionCode, NULL as longMsgIndex, NULL as longMsgId, NULL as longMsgCount, 1 as isValid, NULL as msgUid, NULL as vipBubbleID, 0 as uniseq, 0 as sendFailCode, NULL as extStr, 0 as extInt, 0 as extLong from ");
    ((StringBuilder)localObject).append(d(paramString, paramInt1));
    ((StringBuilder)localObject).append(" order by _id desc limit ");
    ((StringBuilder)localObject).append(paramInt2);
    ((StringBuilder)localObject).append(" ) order by _id asc");
    localObject = String.format(((StringBuilder)localObject).toString(), new Object[0]);
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("queryMessageFromOldDB: sqlStr=");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(", peeruin = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", type = ");
      localStringBuilder.append(paramInt1);
      QLog.d("Q.msg.MsgProxy", 2, localStringBuilder.toString());
    }
    localObject = jdField_a_of_type_ComTencentImcoreMessageBaseMsgProxy$Callback.a((String)localObject, null, this);
    if (localObject != null)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("queryMessageFromOldDB: list size =");
        localStringBuilder.append(((List)localObject).size());
        localStringBuilder.append(", peeruin = ");
        localStringBuilder.append(paramString);
        localStringBuilder.append(", type = ");
        localStringBuilder.append(paramInt1);
        QLog.d("Q.msg.MsgProxy", 2, localStringBuilder.toString());
      }
      return localObject;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("queryMessageFromOldDB: null list , peeruin = ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", type = ");
      ((StringBuilder)localObject).append(paramInt1);
      QLog.d("Q.msg.MsgProxy", 2, ((StringBuilder)localObject).toString());
    }
    return new ArrayList();
  }
  
  public List<MessageRecord> d(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("queryLaterHistoryByShmsgseq uin=");
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append(", type=");
      ((StringBuilder)localObject1).append(paramInt1);
      ((StringBuilder)localObject1).append(", seq=");
      ((StringBuilder)localObject1).append(paramLong);
      ((StringBuilder)localObject1).append(", count=");
      ((StringBuilder)localObject1).append(paramInt2);
      QLog.d("Q.msg.MsgProxy", 2, ((StringBuilder)localObject1).toString());
    }
    if (a(paramString, paramInt1, true)) {
      this.proxyManager.transSaveToDatabase();
    }
    Object localObject2 = b(paramString, paramInt1);
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("select * from ");
    ((StringBuilder)localObject1).append((String)localObject2);
    ((StringBuilder)localObject1).append(" where (shmsgseq >= ? and msgtype ");
    ((StringBuilder)localObject1).append(UinTypeUtil.a());
    ((StringBuilder)localObject1).append(" and isValid=1) order by shmsgseq asc limit ");
    ((StringBuilder)localObject1).append(paramInt2 + 1);
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject3 = new String[1];
    localObject3[0] = String.valueOf(paramLong);
    localObject1 = jdField_a_of_type_ComTencentImcoreMessageBaseMsgProxy$Callback.a((String)localObject1, (String[])localObject3, this);
    if (localObject1 == null) {
      return new ArrayList();
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("queryLaterHistoryByShmsgseq list.size=");
      localStringBuilder.append(((List)localObject1).size());
      QLog.d("Q.msg.MsgProxy", 2, localStringBuilder.toString());
    }
    if ((((List)localObject1).size() > 0) && (((MessageRecord)((List)localObject1).get(0)).shmsgseq == paramLong))
    {
      ((List)localObject1).remove(0);
      paramString = (String)localObject1;
    }
    else
    {
      localObject2 = jdField_a_of_type_ComTencentImcoreMessageBaseMsgProxy$Callback.b(paramString, paramInt1, paramLong, paramInt2, (String)localObject2, (String[])localObject3, this, this.app);
      paramString = (String)localObject1;
      if (localObject2 != null) {
        if (((List)localObject2).size() == paramInt2)
        {
          paramString = (String)localObject2;
        }
        else
        {
          ((List)localObject1).addAll(0, (Collection)localObject2);
          paramString = (String)localObject1;
          if (((List)localObject1).size() > paramInt2)
          {
            ((List)localObject1).subList(paramInt2, ((List)localObject1).size()).clear();
            paramString = (String)localObject1;
          }
        }
      }
    }
    if (QLog.isColorLevel())
    {
      localObject1 = paramString.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (MessageRecord)((Iterator)localObject1).next();
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("queryLaterHistoryByShmsgseq ");
        ((StringBuilder)localObject3).append(((MessageRecord)localObject2).time);
        ((StringBuilder)localObject3).append(", ");
        ((StringBuilder)localObject3).append(((MessageRecord)localObject2).getId());
        ((StringBuilder)localObject3).append(", ");
        ((StringBuilder)localObject3).append(((MessageRecord)localObject2).getLogColorContent());
        QLog.d("Q.msg.MsgProxy", 2, ((StringBuilder)localObject3).toString());
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("queryLaterHistoryByShmsgseq return size=");
      ((StringBuilder)localObject1).append(paramString.size());
      QLog.d("Q.msg.MsgProxy", 2, ((StringBuilder)localObject1).toString());
    }
    return paramString;
  }
  
  public List<MessageRecord> d(String paramString, int paramInt, long paramLong1, long paramLong2)
  {
    boolean bool = QLog.isColorLevel();
    String str = ", type ";
    if (bool)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("queryMessageFromSeqRange, peerUin = ");
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append(", type ");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append(",beginSeq = ");
      ((StringBuilder)localObject1).append(paramLong1);
      ((StringBuilder)localObject1).append(",endSeq = ");
      ((StringBuilder)localObject1).append(paramLong2);
      QLog.d("Q.msg.MsgProxy", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject2 = b(paramString, paramInt);
    Object localObject1 = new ArrayList();
    if ((localObject2 != null) && (((List)localObject2).size() > 0))
    {
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (MessageRecord)((Iterator)localObject2).next();
        if ((((MessageRecord)localObject3).shmsgseq >= paramLong1) && (((MessageRecord)localObject3).shmsgseq <= paramLong2)) {
          ((List)localObject1).add(localObject3);
        }
      }
    }
    if ((((List)localObject1).size() > 0) && (((MessageRecord)((List)localObject1).get(0)).shmsgseq == paramLong1)) {
      return localObject1;
    }
    if (a(paramString, paramInt, true)) {
      this.proxyManager.transSaveToDatabase(a());
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("select * from ");
    ((StringBuilder)localObject2).append(b(paramString, paramInt));
    ((StringBuilder)localObject2).append(" where shmsgseq>=? and shmsgseq<=? order by shmsgseq asc");
    localObject2 = ((StringBuilder)localObject2).toString();
    if (QLog.isColorLevel())
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("queryMessageFromBySeq ");
      ((StringBuilder)localObject3).append((String)localObject2);
      QLog.d("Q.msg.MsgProxy", 2, ((StringBuilder)localObject3).toString());
    }
    if (((List)localObject1).size() > 0) {
      paramLong2 = ((MessageRecord)((List)localObject1).get(0)).shmsgseq;
    }
    paramLong1 = Math.min(paramLong1, paramLong2);
    Object localObject3 = ((List)localObject1).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject3).next();
      if (localMessageRecord.shmsgseq == paramLong2) {
        ((Iterator)localObject3).remove();
      } else {
        if (localMessageRecord.shmsgseq > paramLong2) {
          break;
        }
      }
    }
    localObject2 = jdField_a_of_type_ComTencentImcoreMessageBaseMsgProxy$Callback.a((String)localObject2, new String[] { String.valueOf(paramLong1), String.valueOf(paramLong2) }, this);
    if (QLog.isColorLevel())
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("queryMessageFromTimeRange, peerUin = ");
      ((StringBuilder)localObject3).append(paramString);
      ((StringBuilder)localObject3).append(str);
      ((StringBuilder)localObject3).append(paramInt);
      ((StringBuilder)localObject3).append(",queryBeginSeq = ");
      ((StringBuilder)localObject3).append(paramLong1);
      ((StringBuilder)localObject3).append(",queryEndSeq = ");
      ((StringBuilder)localObject3).append(paramLong2);
      ((StringBuilder)localObject3).append(",resultSize=");
      if (localObject2 == null) {
        paramInt = 0;
      } else {
        paramInt = ((List)localObject2).size();
      }
      ((StringBuilder)localObject3).append(paramInt);
      QLog.d("Q.msg.MsgProxy", 2, ((StringBuilder)localObject3).toString());
    }
    if (localObject2 != null) {
      ((List)localObject1).addAll(0, (Collection)localObject2);
    }
    return localObject1;
  }
  
  protected List<MessageRecord> d(String paramString, int paramInt, List<Long> paramList)
  {
    boolean bool = QLog.isColorLevel();
    int j = 0;
    Object localObject;
    int i;
    if (bool)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("queryMessagesByMsgUniseqFromDB, peerUin[");
      ((StringBuilder)localObject).append(MsfSdkUtils.getShortUin(paramString));
      ((StringBuilder)localObject).append("] type[");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("] uniseqList[");
      if (paramList == null) {
        i = 0;
      } else {
        i = paramList.size();
      }
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append("]");
      QLog.d("Q.msg.MsgProxy", 2, ((StringBuilder)localObject).toString());
    }
    if ((paramList != null) && (paramList.size() != 0))
    {
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
      if (QLog.isColorLevel())
      {
        paramList = new StringBuilder();
        paramList.append("queryMessagesByMsgUniseqFromDB, uniseq list=");
        paramList.append(localStringBuilder.toString());
        QLog.d("Q.msg.MsgProxy", 2, paramList.toString());
      }
      paramList = new StringBuilder();
      paramList.append("select * from ");
      paramList.append(b(paramString, paramInt));
      paramList.append(" where uniseq in ");
      paramList.append(localStringBuilder.toString());
      paramString = paramList.toString();
      paramString = jdField_a_of_type_ComTencentImcoreMessageBaseMsgProxy$Callback.a(paramString, (String[])localObject, this);
      if (paramString != null) {
        return paramString;
      }
      return new ArrayList();
    }
    if (QLog.isColorLevel()) {
      QLog.e("Q.msg.MsgProxy", 2, "queryMessagesByMsgUniseqFromDB Warning! uniseq==0");
    }
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
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
    if ((localEntityManager != null) && (localEntityManager.isOpen())) {
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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("select * from ");
    ((StringBuilder)localObject).append(b(paramString, paramInt1));
    ((StringBuilder)localObject).append(" where isValid=1 and msgtype != ? order by shmsgseq desc , _id desc limit ?");
    localObject = String.format(((StringBuilder)localObject).toString(), new Object[0]);
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("queryValidMessageBySeq: sql=");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(", peeruin = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", type = ");
      localStringBuilder.append(paramInt1);
      QLog.d("Q.msg.MsgProxy", 2, localStringBuilder.toString());
    }
    localObject = jdField_a_of_type_ComTencentImcoreMessageBaseMsgProxy$Callback.a((String)localObject, new String[] { String.valueOf(-2006), String.valueOf(paramInt2) }, this);
    if (localObject != null)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("queryValidMessageBySeq: list size =");
        localStringBuilder.append(((List)localObject).size());
        localStringBuilder.append(", peeruin = ");
        localStringBuilder.append(paramString);
        localStringBuilder.append(", type = ");
        localStringBuilder.append(paramInt1);
        QLog.d("Q.msg.MsgProxy", 2, localStringBuilder.toString());
      }
      return localObject;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("queryValidMessageBySeq: null list , peeruin = ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", type = ");
      ((StringBuilder)localObject).append(paramInt1);
      QLog.d("Q.msg.MsgProxy", 2, ((StringBuilder)localObject).toString());
    }
    return new ArrayList();
  }
  
  protected List<MessageRecord> e(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    List localList;
    if (UinTypeUtil.g(paramInt1)) {
      localList = d(paramString, paramInt1, paramLong, 2147483647L);
    } else {
      localList = a(paramString, paramInt1, paramLong, 2147483647L, paramInt2);
    }
    Object localObject = localList;
    if (localList == null) {
      localObject = new ArrayList();
    }
    b(paramString, paramInt1, (List)localObject);
    return localObject;
  }
  
  protected List<MessageRecord> e(String paramString, int paramInt, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("queryMessagesByTimeFromDB, peerUin[");
      ((StringBuilder)localObject).append(MsfSdkUtils.getShortUin(paramString));
      ((StringBuilder)localObject).append("] type[");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("] time[");
      ((StringBuilder)localObject).append(paramLong1);
      ((StringBuilder)localObject).append("] uid[");
      ((StringBuilder)localObject).append(paramLong2);
      ((StringBuilder)localObject).append("]");
      QLog.d("Q.msg.MsgProxy", 2, ((StringBuilder)localObject).toString());
    }
    if ((paramLong2 == 0L) && (QLog.isColorLevel())) {
      QLog.e("Q.msg.MsgProxy", 2, "queryMessagesByTimeFromDB Warning! msgseq == 0 || msgUid == 0");
    }
    if (a(paramString, paramInt, true)) {
      this.proxyManager.transSaveToDatabase(a());
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("select * from ");
    ((StringBuilder)localObject).append(b(paramString, paramInt));
    ((StringBuilder)localObject).append(" where time=? and msgUid=?");
    localObject = ((StringBuilder)localObject).toString();
    localObject = jdField_a_of_type_ComTencentImcoreMessageBaseMsgProxy$Callback.a((String)localObject, new String[] { String.valueOf(paramLong1), String.valueOf(paramLong2) }, this);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("queryMessagesByTimeFromDB, peerUin[");
      localStringBuilder.append(MsfSdkUtils.getShortUin(paramString));
      localStringBuilder.append("] type[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("] time[");
      localStringBuilder.append(paramLong1);
      localStringBuilder.append("] uid[");
      localStringBuilder.append(paramLong2);
      localStringBuilder.append("], list.size():");
      if (localObject == null) {
        paramInt = 0;
      } else {
        paramInt = ((List)localObject).size();
      }
      localStringBuilder.append(paramInt);
      QLog.d("Q.msg.MsgProxy", 2, localStringBuilder.toString());
    }
    if (localObject != null) {
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
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("queryMessagesByShmsgseqFromDB, peerUin[");
      localStringBuilder.append(MsfSdkUtils.getShortUin(paramString));
      localStringBuilder.append("] type[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("] shmsgseq[");
      localStringBuilder.append(paramLong1);
      localStringBuilder.append("] msgUid[");
      localStringBuilder.append(paramLong2);
      localStringBuilder.append("]");
      QLog.d("Q.msg.MsgProxy", 2, localStringBuilder.toString());
    }
    if (((paramLong1 == 0L) || (paramLong2 == 0L)) && (QLog.isColorLevel())) {
      QLog.e("Q.msg.MsgProxy", 2, "queryMessagesByShmsgseqFromDB Warning! shmsgseq == 0 || msgUid == 0");
    }
    if (a(paramString, paramInt, true)) {
      this.proxyManager.transSaveToDatabase(a());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("select * from ");
    localStringBuilder.append(b(paramString, paramInt));
    localStringBuilder.append(" where shmsgseq=? and msgUid=?");
    paramString = localStringBuilder.toString();
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
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("queryMessagesByShmsgseqFromDB, peerUin[");
      ((StringBuilder)localObject).append(MsfSdkUtils.getShortUin(paramString));
      ((StringBuilder)localObject).append("] type[");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("] shmsgseq[");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append("]");
      QLog.d("Q.msg.MsgProxy", 2, ((StringBuilder)localObject).toString());
    }
    if ((paramLong == 0L) && (QLog.isColorLevel())) {
      QLog.e("Q.msg.MsgProxy", 2, "queryMessagesByShmsgseqFromDB Warning! shmsgseq == 0 || msgUid == 0");
    }
    if (a(paramString, paramInt, true)) {
      this.proxyManager.transSaveToDatabase(a());
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("select * from ");
    ((StringBuilder)localObject).append(b(paramString, paramInt));
    ((StringBuilder)localObject).append(" where shmsgseq=?");
    localObject = ((StringBuilder)localObject).toString();
    localObject = jdField_a_of_type_ComTencentImcoreMessageBaseMsgProxy$Callback.a((String)localObject, new String[] { String.valueOf(paramLong) }, this);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("queryMessagesByShmsgseqFromDB, peerUin[");
      localStringBuilder.append(MsfSdkUtils.getShortUin(paramString));
      localStringBuilder.append("] type[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("] shmsgseq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("], list.size():");
      if (localObject == null) {
        paramInt = 0;
      } else {
        paramInt = ((List)localObject).size();
      }
      localStringBuilder.append(paramInt);
      QLog.d("Q.msg.MsgProxy", 2, localStringBuilder.toString());
    }
    if (localObject != null) {
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
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("queryMessagesByShmsgseqFromDB4Troop, peerUin[");
      localStringBuilder.append(MsfSdkUtils.getShortUin(paramString));
      localStringBuilder.append("] type[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("] shmsgseq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.d("Q.msg.MsgProxy", 2, localStringBuilder.toString());
    }
    if ((paramLong == 0L) && (QLog.isColorLevel())) {
      QLog.e("Q.msg.MsgProxy", 2, "queryMessagesByShmsgseqFromDB4Troop Warning! shmsgseq == 0");
    }
    if (a(paramString, paramInt, true)) {
      this.proxyManager.transSaveToDatabase(a());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("select * from ");
    localStringBuilder.append(b(paramString, paramInt));
    localStringBuilder.append(" where shmsgseq=? and msgtype ");
    localStringBuilder.append(UinTypeUtil.c());
    paramString = localStringBuilder.toString();
    paramString = jdField_a_of_type_ComTencentImcoreMessageBaseMsgProxy$Callback.a(paramString, new String[] { String.valueOf(paramLong) }, this);
    if ((paramString != null) && (paramString.size() > 0)) {
      return (MessageRecord)paramString.get(0);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.MsgProxy
 * JD-Core Version:    0.7.0.1
 */