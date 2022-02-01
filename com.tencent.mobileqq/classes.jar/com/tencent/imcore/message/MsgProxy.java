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
import mqq.util.LogUtil;

public class MsgProxy
  extends BaseMsgProxy
{
  public static BaseMsgProxy.Callback c = new MsgProxyDummyCallback();
  protected EntityManager b = null;
  private Object d = new Object();
  
  static
  {
    InitMsgModule.a();
  }
  
  @Metadata
  public MsgProxy(AppRuntime paramAppRuntime, BaseProxyManager paramBaseProxyManager, MsgPool paramMsgPool)
  {
    super(paramAppRuntime, paramBaseProxyManager, paramMsgPool);
  }
  
  private int a(int paramInt1, Message paramMessage, String paramString, int paramInt2, int paramInt3)
  {
    Object localObject = n(paramString, paramInt2);
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
      localObject = i(paramString, paramInt2);
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
    long l;
    if (!UinTypeUtil.h(paramInt))
    {
      l = paramLong;
      if (!UinTypeUtil.i(paramInt)) {}
    }
    else
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
    paramString = d().rawQuery(Message.class, paramString, null);
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
    paramString = d(paramString);
    if (paramString != null)
    {
      paramString = a(paramList2, ((Long)paramString.first).longValue());
      if ((paramString != null) && (!paramString.isEmpty())) {
        return paramString;
      }
    }
    return paramList2;
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
    c = paramCallback;
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
    //   8: ldc_w 276
    //   11: invokevirtual 172	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   14: ifeq +57 -> 71
    //   17: new 70	java/lang/StringBuilder
    //   20: dup
    //   21: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   24: astore_3
    //   25: aload_3
    //   26: ldc_w 278
    //   29: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: pop
    //   33: aload_3
    //   34: aload 12
    //   36: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: pop
    //   40: aload_3
    //   41: ldc_w 280
    //   44: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: pop
    //   48: aload_3
    //   49: aload 12
    //   51: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: pop
    //   55: aload_3
    //   56: ldc_w 282
    //   59: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: pop
    //   63: aload_3
    //   64: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   67: astore_3
    //   68: goto +5 -> 73
    //   71: aconst_null
    //   72: astore_3
    //   73: aload_3
    //   74: ifnonnull +4 -> 78
    //   77: return
    //   78: invokestatic 68	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   81: ifeq +40 -> 121
    //   84: new 70	java/lang/StringBuilder
    //   87: dup
    //   88: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   91: astore 10
    //   93: aload 10
    //   95: ldc_w 284
    //   98: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: pop
    //   102: aload 10
    //   104: aload_3
    //   105: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: pop
    //   109: ldc_w 286
    //   112: iconst_2
    //   113: aload 10
    //   115: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: invokestatic 89	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   121: aload_2
    //   122: aload_3
    //   123: aconst_null
    //   124: invokevirtual 291	com/tencent/mobileqq/app/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   127: astore_3
    //   128: aload_3
    //   129: ifnull +182 -> 311
    //   132: aload_3
    //   133: astore 10
    //   135: aload_3
    //   136: invokeinterface 296 1 0
    //   141: ifle +170 -> 311
    //   144: aload_3
    //   145: astore 10
    //   147: aload_3
    //   148: invokeinterface 299 1 0
    //   153: pop
    //   154: aload_3
    //   155: astore 10
    //   157: aload_3
    //   158: aload_3
    //   159: ldc_w 301
    //   162: invokeinterface 305 2 0
    //   167: invokeinterface 309 2 0
    //   172: lstore 8
    //   174: aload_3
    //   175: astore 10
    //   177: aload_3
    //   178: aload_3
    //   179: ldc_w 311
    //   182: invokeinterface 305 2 0
    //   187: invokeinterface 314 2 0
    //   192: astore 11
    //   194: aload_3
    //   195: astore 10
    //   197: aload_3
    //   198: aload_3
    //   199: ldc_w 316
    //   202: invokeinterface 305 2 0
    //   207: invokeinterface 320 2 0
    //   212: istore 4
    //   214: aload_3
    //   215: astore 10
    //   217: aload_3
    //   218: aload_3
    //   219: ldc_w 322
    //   222: invokeinterface 305 2 0
    //   227: invokeinterface 320 2 0
    //   232: istore 5
    //   234: lload 8
    //   236: lstore 6
    //   238: aload_3
    //   239: astore 10
    //   241: iload 4
    //   243: invokestatic 140	com/tencent/imcore/message/UinTypeUtil:h	(I)Z
    //   246: ifne +36 -> 282
    //   249: lload 8
    //   251: lstore 6
    //   253: aload_3
    //   254: astore 10
    //   256: iload 4
    //   258: invokestatic 142	com/tencent/imcore/message/UinTypeUtil:i	(I)Z
    //   261: ifne +21 -> 282
    //   264: lload 8
    //   266: lstore 6
    //   268: iload 5
    //   270: iconst_1
    //   271: if_icmpne +11 -> 282
    //   274: lload 8
    //   276: ldc2_w 323
    //   279: ladd
    //   280: lstore 6
    //   282: aload_3
    //   283: astore 10
    //   285: getstatic 19	com/tencent/imcore/message/MsgProxy:c	Lcom/tencent/imcore/message/BaseMsgProxy$Callback;
    //   288: aload 11
    //   290: iload 4
    //   292: lload 6
    //   294: aload_0
    //   295: getfield 328	com/tencent/imcore/message/MsgProxy:app	Lmqq/app/AppRuntime;
    //   298: invokeinterface 333 6 0
    //   303: goto +8 -> 311
    //   306: astore 11
    //   308: goto +27 -> 335
    //   311: aload_3
    //   312: ifnull +38 -> 350
    //   315: aload_3
    //   316: invokeinterface 336 1 0
    //   321: goto +29 -> 350
    //   324: astore_1
    //   325: aconst_null
    //   326: astore 10
    //   328: goto +100 -> 428
    //   331: astore 11
    //   333: aconst_null
    //   334: astore_3
    //   335: aload_3
    //   336: astore 10
    //   338: aload 11
    //   340: invokevirtual 339	java/lang/Exception:printStackTrace	()V
    //   343: aload_3
    //   344: ifnull +6 -> 350
    //   347: goto -32 -> 315
    //   350: aload_1
    //   351: ifnull +7 -> 358
    //   354: aload_1
    //   355: invokevirtual 344	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   358: aload_2
    //   359: aload 12
    //   361: aconst_null
    //   362: aconst_null
    //   363: invokevirtual 348	com/tencent/mobileqq/app/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   366: pop
    //   367: aload_1
    //   368: ifnull +7 -> 375
    //   371: aload_1
    //   372: invokevirtual 351	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   375: aload_1
    //   376: ifnull +40 -> 416
    //   379: aload_1
    //   380: invokevirtual 354	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   383: return
    //   384: astore_2
    //   385: goto +32 -> 417
    //   388: astore_2
    //   389: aload_2
    //   390: invokevirtual 339	java/lang/Exception:printStackTrace	()V
    //   393: invokestatic 68	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   396: ifeq +13 -> 409
    //   399: ldc 83
    //   401: iconst_2
    //   402: ldc_w 356
    //   405: aload_2
    //   406: invokestatic 360	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   409: aload_1
    //   410: ifnull +6 -> 416
    //   413: goto -34 -> 379
    //   416: return
    //   417: aload_1
    //   418: ifnull +7 -> 425
    //   421: aload_1
    //   422: invokevirtual 354	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   425: aload_2
    //   426: athrow
    //   427: astore_1
    //   428: aload 10
    //   430: ifnull +10 -> 440
    //   433: aload 10
    //   435: invokeinterface 336 1 0
    //   440: goto +5 -> 445
    //   443: aload_1
    //   444: athrow
    //   445: goto -2 -> 443
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	448	0	this	MsgProxy
    //   0	448	1	paramEntityTransaction	EntityTransaction
    //   0	448	2	paramSQLiteDatabase	SQLiteDatabase
    //   0	448	3	paramArrayOfString	String[]
    //   0	448	4	paramInt	int
    //   232	40	5	i	int
    //   236	57	6	l1	long
    //   172	103	8	l2	long
    //   91	343	10	localObject	Object
    //   192	97	11	str1	String
    //   306	1	11	localException1	Exception
    //   331	8	11	localException2	Exception
    //   4	356	12	str2	String
    // Exception table:
    //   from	to	target	type
    //   135	144	306	java/lang/Exception
    //   147	154	306	java/lang/Exception
    //   157	174	306	java/lang/Exception
    //   177	194	306	java/lang/Exception
    //   197	214	306	java/lang/Exception
    //   217	234	306	java/lang/Exception
    //   241	249	306	java/lang/Exception
    //   256	264	306	java/lang/Exception
    //   285	303	306	java/lang/Exception
    //   121	128	324	finally
    //   121	128	331	java/lang/Exception
    //   354	358	384	finally
    //   358	367	384	finally
    //   371	375	384	finally
    //   389	409	384	finally
    //   354	358	388	java/lang/Exception
    //   358	367	388	java/lang/Exception
    //   371	375	388	java/lang/Exception
    //   135	144	427	finally
    //   147	154	427	finally
    //   157	174	427	finally
    //   177	194	427	finally
    //   197	214	427	finally
    //   217	234	427	finally
    //   241	249	427	finally
    //   256	264	427	finally
    //   285	303	427	finally
    //   338	343	427	finally
  }
  
  private void a(String paramString1, MessageRecord paramMessageRecord, boolean paramBoolean, String paramString2)
  {
    if ((j().containsKey(paramString2)) && (paramBoolean))
    {
      List localList = b(paramString2);
      paramString2 = localList;
      if (localList == null) {
        paramString2 = new ArrayList();
      }
      c.a(paramString1, paramMessageRecord, paramString2, this);
    }
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
  
  private int b(int paramInt)
  {
    List localList = n(AppConstants.RECOMMEND_TROOP_UIN, 4001);
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
      a(String.valueOf(AppConstants.RECOMMEND_TROOP_UIN), 4001, l(String.valueOf(AppConstants.RECOMMEND_TROOP_UIN), 4001), "msgtype=?", new String[] { String.valueOf(paramInt) }, null);
    }
    c.a(paramInt, localList, this.app);
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
  
  private List<MessageRecord> b(String paramString1, int paramInt, String paramString2)
  {
    List localList2 = a(paramString2);
    List localList1 = localList2;
    if (localList2 == null)
    {
      long l = System.nanoTime();
      localList1 = k(paramString1, paramInt);
      g(paramString1, paramInt, localList1);
      c.a(paramString1, paramInt, paramString2, localList1, l, this);
    }
    return localList1;
  }
  
  private void b(String paramString, int paramInt, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    List localList = n(paramString, paramInt);
    String str = j(paramString, paramInt);
    a(paramString, paramInt, str, localList);
    c.a(localList, paramMessageRecord, true);
    if ((localList != null) && (localList.size() > 40) && (!UinTypeUtil.a(paramString))) {
      localList.remove(0);
    }
    a(paramString, paramMessageRecord, paramBoolean, str);
  }
  
  private void b(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2)
  {
    List localList = n(paramString1, paramInt1);
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
      a(paramString1, paramInt1, l(paramString1, paramInt1), "senderuin=? and selfuin=?", new String[] { paramString2, paramString3 }, null);
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
  
  private void b(List<MessageRecord> paramList, long paramLong)
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
        this.proxyManager.addMsgQueueDonotNotify(localMessageRecord.frienduin, localMessageRecord.istroop, l(localMessageRecord.frienduin, localMessageRecord.istroop), localMessageRecord, 0, paramProxyListener);
      }
    }
    this.proxyManager.transSaveToDatabase();
  }
  
  @Nullable
  private List<MessageRecord> c(String paramString, int paramInt, boolean paramBoolean)
  {
    List localList = b(j(paramString, paramInt));
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
    else if (d(paramString, paramInt, paramBoolean)) {
      return null;
    }
    return b(j(paramString, paramInt));
  }
  
  private boolean c(String paramString1, int paramInt, String paramString2)
  {
    return c.a(paramString1, paramInt, paramString2, this);
  }
  
  private Pair<Long, Long> d(String paramString)
  {
    return c.a(paramString, this.app);
  }
  
  private boolean d(String paramString, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      v(paramString, paramInt);
      return false;
    }
    j().remove(j(paramString, paramInt));
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "getAioMsgPool().remove");
    }
    return true;
  }
  
  private void e(String paramString, int paramInt, MessageRecord paramMessageRecord)
  {
    List localList = a(j(paramString, paramInt));
    if (localList != null)
    {
      c.a(localList, paramMessageRecord, true);
      if (localList.size() > 40) {
        localList.remove(0);
      }
      g(paramString, paramInt, localList);
    }
  }
  
  @Nullable
  private MessageRecord g(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    paramString = a(j(paramString, paramInt1));
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
  
  private MessageRecord h(String paramString, int paramInt1, int paramInt2)
  {
    List localList = d(paramString, paramInt1);
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
      c.a(this.app, paramString, paramInt1);
      localObject1 = e(paramString, paramInt1, paramInt2);
    }
    return localObject1;
  }
  
  private List<MessageRecord> h(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    ArrayList localArrayList = new ArrayList();
    paramString = a(j(paramString, paramInt1));
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
  
  private void i(String paramString, int paramInt1, int paramInt2)
  {
    Lock localLock = q(paramString, paramInt1);
    localLock.lock();
    try
    {
      j(paramString, paramInt1, paramInt2);
      return;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  private void j(String paramString, int paramInt1, int paramInt2)
  {
    Object localObject1 = n(paramString, paramInt1);
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
      paramString = i(paramString, paramInt1);
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
  
  @Nullable
  private MessageRecord r(String paramString, int paramInt, long paramLong)
  {
    Object localObject1 = n(paramString, paramInt);
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
    paramString = i(paramString, paramInt);
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
  
  @Nullable
  private MessageRecord s(String paramString, int paramInt, long paramLong)
  {
    Object localObject1 = n(paramString, paramInt);
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
    paramString = i(paramString, paramInt);
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
  private MessageRecord t(String paramString, int paramInt, long paramLong)
  {
    paramString = a(j(paramString, paramInt));
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
  
  private void u(String paramString, int paramInt, long paramLong)
  {
    Object localObject = n(paramString, paramInt);
    if (localObject != null)
    {
      if (((List)localObject).isEmpty()) {
        return;
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
        if ((!localMessageRecord.isread) && (a(paramInt, paramLong, localMessageRecord)) && ((!UinTypeUtil.f(paramInt)) || (!UinTypeUtil.g(localMessageRecord.msgtype)))) {
          localMessageRecord.isread = true;
        }
      }
      paramString = i(paramString, paramInt);
      if (paramString != null)
      {
        if (paramString.isEmpty()) {
          return;
        }
        paramString = paramString.iterator();
        while (paramString.hasNext())
        {
          localObject = (MessageRecord)paramString.next();
          if ((!((MessageRecord)localObject).isread) && (a(paramInt, paramLong, (MessageRecord)localObject)) && ((!UinTypeUtil.f(paramInt)) || (!UinTypeUtil.g(((MessageRecord)localObject).msgtype)))) {
            ((MessageRecord)localObject).isread = true;
          }
        }
      }
    }
  }
  
  private void v(String paramString, int paramInt)
  {
    Object localObject1 = n(paramString, paramInt);
    if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
    {
      c.a((List)localObject1, this);
      localObject1 = f(paramString, paramInt, (List)localObject1);
    }
    else
    {
      localObject1 = w(paramString, paramInt);
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
    e(paramString, paramInt, (List)localObject2);
  }
  
  private List<MessageRecord> w(String paramString, int paramInt)
  {
    return f(paramString, paramInt, 15);
  }
  
  private List<MessageRecord> x(String paramString, int paramInt)
  {
    Object localObject1 = a(j(paramString, paramInt));
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
    String str = o(paramString, paramInt);
    boolean bool = a(paramString, paramInt, false);
    if (bool) {
      this.proxyManager.transSaveToDatabase();
    }
    Object localObject3 = p(paramString, paramInt);
    Object localObject2 = c.a(str, null, this);
    if ((localObject2 != null) && (((List)localObject2).size() > 0))
    {
      paramInt = 0;
      while (paramInt < ((List)localObject2).size())
      {
        localObject1 = (MessageRecord)((List)localObject2).get(paramInt);
        if ((localObject1 != null) && (((MessageRecord)localObject1).isSendFromLocal()) && (((MessageRecord)localObject1).extraflag == 32772) && (!c.a(this.app, (MessageRecord)localObject1)))
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
      c.a((List)localObject1, (MessageRecord)localObject3, true);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, new Object[] { "init from db, uin=", paramString, ", isSaveToDatabase=", Boolean.valueOf(bool), ", cost=", Long.valueOf(System.currentTimeMillis() - l), " sqlStr = ", str, " size =", Integer.valueOf(((List)localObject1).size()) });
    }
    return localObject1;
  }
  
  private int y(String paramString, int paramInt)
  {
    List localList = n(paramString, paramInt);
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
    if (j().containsKey(j(paramString, paramInt)))
    {
      j().remove(j(paramString, paramInt));
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MsgProxy", 2, new Object[] { "deleteMsgListLocked uin: ", LogUtil.wrapLogUin(paramString), ", type: ", Integer.valueOf(paramInt) });
      }
    }
    return i;
  }
  
  public int a(int paramInt)
  {
    Lock localLock = q(AppConstants.RECOMMEND_TROOP_UIN, paramInt);
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
    Lock localLock = q(str, 4001);
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
      m(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.getId());
    } else {
      g(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.uniseq);
    }
    long l = paramMessageRecord.getId();
    if (l > 0L)
    {
      a(paramMessageRecord.frienduin, paramMessageRecord.istroop, l(paramMessageRecord.frienduin, paramMessageRecord.istroop), "_id=?", new String[] { String.valueOf(l) }, null);
    }
    else
    {
      if (paramMessageRecord.uniseq == 0L) {
        break label292;
      }
      a(paramMessageRecord.frienduin, paramMessageRecord.istroop, l(paramMessageRecord.frienduin, paramMessageRecord.istroop), "uniseq=?", new String[] { String.valueOf(paramMessageRecord.uniseq) }, null);
    }
    if (!paramMessageRecord.isread) {
      return 2;
    }
    s(paramMessageRecord.frienduin, paramMessageRecord.istroop);
    return 1;
    label292:
    return -1;
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
          m(((MessageRecord)localObject3).frienduin, ((MessageRecord)localObject3).istroop, ((MessageRecord)localObject3).getId());
        } else {
          g(((MessageRecord)localObject3).frienduin, ((MessageRecord)localObject3).istroop, ((MessageRecord)localObject3).uniseq);
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
          a(str, j, l(str, j), "_id=?", new String[] { localObject2 }, null);
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
        a(str, j, l(str, j), paramList, (String[])((List)localObject2).toArray(new String[k]), null);
      }
      if (((List)localObject1).size() > 100)
      {
        paramList = ((List)localObject1).iterator();
        while (paramList.hasNext())
        {
          localObject1 = (String)paramList.next();
          a(str, j, l(str, j), "uniseq=?", new String[] { localObject1 }, null);
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
        a(str, j, l(str, j), paramList, (String[])((List)localObject1).toArray(new String[k]), null);
      }
      s(str, j);
      return i;
    }
    return -1;
  }
  
  @Deprecated
  public Cursor a(String paramString, int paramInt)
  {
    List localList = c(paramString, paramInt);
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
      paramString = f(paramString, paramInt, 2147483647);
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
    synchronized (c.b(this.app))
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
          List localList = d().rawQuery(Message.class, (String)localObject1, new String[0]);
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
    return this.a;
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
          String str2 = c.a(this.app, (String)localObject, paramString2, paramInt, paramString3);
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
            paramString1 = (MessageRecord)d().cursor2Entity(MessageRecord.class, null, paramCursor, new MsgProxy.1(this));
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
    //   1: invokestatic 789	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: istore 5
    //   6: aconst_null
    //   7: astore 7
    //   9: aconst_null
    //   10: astore 6
    //   12: iload 5
    //   14: ifne +129 -> 143
    //   17: aload_1
    //   18: invokestatic 789	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   21: ifeq +5 -> 26
    //   24: aconst_null
    //   25: areturn
    //   26: aload_0
    //   27: aload_2
    //   28: iload_3
    //   29: invokevirtual 397	com/tencent/imcore/message/MsgProxy:l	(Ljava/lang/String;I)Ljava/lang/String;
    //   32: astore 8
    //   34: aload_0
    //   35: invokevirtual 203	com/tencent/imcore/message/MsgProxy:d	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   38: iconst_0
    //   39: aload 8
    //   41: aconst_null
    //   42: ldc_w 868
    //   45: iconst_1
    //   46: anewarray 123	java/lang/String
    //   49: dup
    //   50: iconst_0
    //   51: sipush -1000
    //   54: invokestatic 126	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   57: aastore
    //   58: aconst_null
    //   59: aconst_null
    //   60: ldc_w 870
    //   63: aconst_null
    //   64: invokevirtual 874	com/tencent/mobileqq/persistence/EntityManager:query	(ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   67: astore 8
    //   69: aload_0
    //   70: aload 8
    //   72: aload_1
    //   73: aload_2
    //   74: iload_3
    //   75: aload 4
    //   77: invokevirtual 876	com/tencent/imcore/message/MsgProxy:a	(Landroid/database/Cursor;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)Lcom/tencent/mobileqq/data/ChatHistorySearchData;
    //   80: astore_1
    //   81: aload_1
    //   82: astore_2
    //   83: aload 8
    //   85: ifnull +42 -> 127
    //   88: aload 8
    //   90: invokeinterface 336 1 0
    //   95: aload_1
    //   96: areturn
    //   97: astore_1
    //   98: goto +31 -> 129
    //   101: astore_1
    //   102: ldc 83
    //   104: iconst_1
    //   105: aload_1
    //   106: iconst_0
    //   107: anewarray 33	java/lang/Object
    //   110: invokestatic 879	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
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
    //   136: invokeinterface 336 1 0
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
    MessageRecord localMessageRecord = b(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.uniseq);
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
  
  public MessageRecord a(String paramString, int paramInt1, long paramLong, int paramInt2, int paramInt3)
  {
    MessageRecord localMessageRecord = b(paramString, paramInt1, paramLong);
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
    localObject = b(paramString1, paramInt, paramLong1);
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
      paramString2 = b(paramString1, paramInt, l);
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
      h(paramString1, paramInt, paramLong1);
      a(paramString1, paramInt, paramString2);
      c.a(paramString1, paramInt, paramLong1, paramLong2, paramString2, this.app);
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
    MessageRecord localMessageRecord = b(paramString1, paramInt, paramLong);
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
    MessageRecord localMessageRecord = b(paramString1, paramInt, paramLong);
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
      this.proxyManager.transSaveToDatabase(d());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("select * from ");
    localStringBuilder.append(l(paramString1, paramInt));
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
    paramString1 = c.a(paramString2, null, this);
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
    MessageRecord localMessageRecord = b(paramString, paramInt, paramLong);
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
      this.proxyManager.transSaveToDatabase(d());
    }
    boolean bool = UinTypeUtil.h(paramInt);
    Object localObject = "";
    StringBuilder localStringBuilder;
    if ((!bool) && (!UinTypeUtil.i(paramInt)))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("select * from ");
      localStringBuilder.append(l(paramString1, paramInt));
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
    else
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("select * from ");
      localStringBuilder.append(l(paramString1, paramInt));
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
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append("queryLastTABSupportMessageFromDB : sqlStr:");
      paramString2.append(paramString1);
      QLog.d("Q.msg.MsgProxy", 2, paramString2.toString());
    }
    paramString1 = c.a(paramString1, null, this);
    if (paramString1 != null)
    {
      if (paramString1.size() < 1) {
        return null;
      }
      return (MessageRecord)paramString1.get(0);
    }
    return null;
  }
  
  public MessageRecord a(List<MessageRecord> paramList, MessageRecord paramMessageRecord)
  {
    return null;
  }
  
  protected String a(Cursor paramCursor, int paramInt, String paramString)
  {
    if (MessageRecordInfo.b(paramCursor.getInt(paramCursor.getColumnIndex("issend")))) {
      paramString = this.app.getAccount();
    }
    return paramString;
  }
  
  protected List<MessageRecord> a(String paramString)
  {
    return (List)i().get(paramString);
  }
  
  public List<MessageRecord> a(String paramString, int paramInt1, int paramInt2)
  {
    Lock localLock = q(paramString, paramInt1);
    localLock.lock();
    try
    {
      paramString = d(paramString, paramInt1, paramInt2);
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
    Object localObject = q(paramString, paramInt1);
    ((Lock)localObject).lock();
    try
    {
      paramString = c(paramString, paramInt1, paramBoolean);
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
    Object localObject2 = g(paramString, paramInt1);
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
      localObject1 = c(paramString, paramInt1);
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
        if ((!UinTypeUtil.h(paramInt1)) && (!UinTypeUtil.i(paramInt1))) {
          break label387;
        }
        long l4;
        int j;
        if ((localMessageRecord.versionCode == 3) && (localMessageRecord.shmsgseq == l5) && (l5 != 0L))
        {
          l4 = l2;
          j = i;
          l3 = l1;
        }
        else
        {
          label387:
          if (!((HashSet)localObject2).contains(Integer.valueOf(localMessageRecord.msgtype)))
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
    if ((!UinTypeUtil.h(paramInt1)) && (!UinTypeUtil.i(paramInt1))) {
      localArrayList.addAll(0, a(paramString, paramInt1, l1, i, l2, paramInt2 - localArrayList.size(), paramArrayOfInt));
    } else {
      localArrayList.addAll(0, a(paramString, paramInt1, l1, i, l3, paramInt2 - localArrayList.size(), paramArrayOfInt));
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
    Object localObject = q(paramString, paramInt1);
    ((Lock)localObject).lock();
    try
    {
      paramString = f(paramString, paramInt1, paramLong, paramInt2);
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
    paramString2 = MessageDBUtils.a(t(paramString1, paramInt1), l(paramString1, paramInt1), paramLong1, paramInt2, paramLong2, paramInt3, m(), paramString2);
    if (paramString2 != null)
    {
      if (a(paramString1, paramInt1, true)) {
        this.proxyManager.transSaveToDatabase(d());
      }
      paramString1 = c.a(paramString2.toString(), null, this);
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
    int j = 1;
    if (a(paramString1, paramInt1, true)) {
      this.proxyManager.transSaveToDatabase();
    }
    int i = j;
    if (!UinTypeUtil.h(paramInt1)) {
      if (UinTypeUtil.i(paramInt1)) {
        i = j;
      } else {
        i = 0;
      }
    }
    if (u(paramString1, paramInt1))
    {
      if (i != 0) {
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
      Object localObject = d(paramString, paramInt);
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
    Object localObject3 = c(paramString, paramInt1);
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
      this.proxyManager.transSaveToDatabase(d());
    }
    int i = a(paramInt1, paramInt2);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("select * from ");
    ((StringBuilder)localObject2).append(l(paramString, paramInt1));
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
    b((List)localObject1, paramLong2);
    if (i == 0) {
      localObject2 = c.a(((StringBuilder)localObject2).toString(), new String[] { String.valueOf(paramLong1), String.valueOf(paramLong2) }, this);
    } else {
      localObject2 = c.a(((StringBuilder)localObject2).toString(), new String[] { String.valueOf(paramLong1), String.valueOf(paramLong2), String.valueOf(i) }, this);
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
      this.proxyManager.transSaveToDatabase(d());
    }
    paramMap = new StringBuilder();
    paramMap.append("select * from ");
    paramMap.append(l(paramString, paramInt));
    paramMap.append(" where shmsgseq=?");
    paramString = paramMap.toString();
    if (QLog.isColorLevel())
    {
      paramMap = new StringBuilder();
      paramMap.append("querySameSeqMessageWithFilter ");
      paramMap.append(paramString);
      QLog.d("Q.msg.MsgProxy", 2, paramMap.toString());
    }
    paramMap = c.a(paramString, new String[] { String.valueOf(paramLong) }, this);
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
        MessageRecord localMessageRecord = b(paramString, paramInt, ((Long)paramList.get(i)).longValue());
        if (localMessageRecord == null) {
          break;
        }
        localArrayList.add(localMessageRecord);
        i += 1;
      }
      if (i < paramList.size() - 1) {
        localArrayList.addAll(l(paramString, paramInt, paramList.subList(i, paramList.size())));
      }
      return localArrayList;
    }
    return new ArrayList();
  }
  
  public List<MessageRecord> a(String paramString, int paramInt, int[] paramArrayOfInt)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = g(paramString, paramInt);
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
        if (((!UinTypeUtil.h(paramInt)) && (!UinTypeUtil.i(paramInt))) || (((((MessageRecord)localObject).versionCode != 3) || (((MessageRecord)localObject).shmsgseq != l) || (l == 0L)) && ((paramString.contains(Integer.valueOf(((MessageRecord)localObject).msgtype))) || (paramString.isEmpty())))) {
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
  
  public void a(int paramInt, String paramString)
  {
    try
    {
      paramString = UinTypeUtil.a(paramString, paramInt);
      j().remove(paramString);
      c.e(this.app);
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
    //   1: invokevirtual 1327	com/tencent/imcore/message/QueryHistoryParam:a	()Ljava/lang/String;
    //   4: invokestatic 789	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7: ifeq +4 -> 11
    //   10: return
    //   11: aload_0
    //   12: aload_1
    //   13: invokevirtual 1327	com/tencent/imcore/message/QueryHistoryParam:a	()Ljava/lang/String;
    //   16: aload_1
    //   17: invokevirtual 1329	com/tencent/imcore/message/QueryHistoryParam:b	()I
    //   20: iconst_1
    //   21: invokevirtual 606	com/tencent/imcore/message/MsgProxy:a	(Ljava/lang/String;IZ)Z
    //   24: ifeq +10 -> 34
    //   27: aload_0
    //   28: getfield 160	com/tencent/imcore/message/MsgProxy:proxyManager	Lcom/tencent/mobileqq/app/proxy/BaseProxyManager;
    //   31: invokevirtual 486	com/tencent/mobileqq/app/proxy/BaseProxyManager:transSaveToDatabase	()V
    //   34: invokestatic 1334	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getServerTime	()J
    //   37: lstore_3
    //   38: aload_0
    //   39: aload_1
    //   40: invokevirtual 1327	com/tencent/imcore/message/QueryHistoryParam:a	()Ljava/lang/String;
    //   43: aload_1
    //   44: invokevirtual 1329	com/tencent/imcore/message/QueryHistoryParam:b	()I
    //   47: invokevirtual 397	com/tencent/imcore/message/MsgProxy:l	(Ljava/lang/String;I)Ljava/lang/String;
    //   50: astore 5
    //   52: aload_0
    //   53: invokevirtual 203	com/tencent/imcore/message/MsgProxy:d	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   56: astore 6
    //   58: aload_1
    //   59: invokevirtual 1336	com/tencent/imcore/message/QueryHistoryParam:c	()I
    //   62: istore_2
    //   63: aload 6
    //   65: iconst_0
    //   66: aload 5
    //   68: aconst_null
    //   69: ldc_w 1338
    //   72: iconst_4
    //   73: anewarray 123	java/lang/String
    //   76: dup
    //   77: iconst_0
    //   78: sipush -1000
    //   81: invokestatic 126	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   84: aastore
    //   85: dup
    //   86: iconst_1
    //   87: sipush -1035
    //   90: invokestatic 126	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   93: aastore
    //   94: dup
    //   95: iconst_2
    //   96: sipush -2011
    //   99: invokestatic 126	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   102: aastore
    //   103: dup
    //   104: iconst_3
    //   105: lload_3
    //   106: ldc2_w 1339
    //   109: lsub
    //   110: invokestatic 692	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   113: aastore
    //   114: aconst_null
    //   115: aconst_null
    //   116: ldc_w 870
    //   119: iload_2
    //   120: invokestatic 126	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   123: invokevirtual 874	com/tencent/mobileqq/persistence/EntityManager:query	(ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   126: astore 5
    //   128: aload_1
    //   129: aload 5
    //   131: invokevirtual 1343	com/tencent/imcore/message/QueryHistoryParam:a	(Landroid/database/Cursor;)V
    //   134: aload_0
    //   135: aload_1
    //   136: invokevirtual 1345	com/tencent/imcore/message/MsgProxy:b	(Lcom/tencent/imcore/message/QueryHistoryParam;)V
    //   139: aload 5
    //   141: ifnull +41 -> 182
    //   144: aload 5
    //   146: invokeinterface 336 1 0
    //   151: return
    //   152: astore_1
    //   153: goto +30 -> 183
    //   156: astore_1
    //   157: invokestatic 68	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   160: ifeq +14 -> 174
    //   163: ldc 83
    //   165: iconst_2
    //   166: aload_1
    //   167: iconst_0
    //   168: anewarray 33	java/lang/Object
    //   171: invokestatic 879	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   174: aload 5
    //   176: ifnull +6 -> 182
    //   179: goto -35 -> 144
    //   182: return
    //   183: aload 5
    //   185: ifnull +10 -> 195
    //   188: aload 5
    //   190: invokeinterface 336 1 0
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
  
  public void a(String paramString1, int paramInt1, int paramInt2, ContentValues paramContentValues, String paramString2, String[] paramArrayOfString, ProxyListener paramProxyListener)
  {
    if (paramInt2 > 0)
    {
      this.proxyManager.addMsgQueue(paramString1, paramInt1, l(paramString1, paramInt1), paramContentValues, paramString2, paramArrayOfString, 1, paramProxyListener);
      return;
    }
    this.proxyManager.addMsgQueue(paramString1, paramInt1, t(paramString1, paramInt1), paramContentValues, paramString2, paramArrayOfString, 1, paramProxyListener);
  }
  
  public void a(String paramString, int paramInt, long paramLong)
  {
    Lock localLock = a().a(paramString, paramInt);
    localLock.lock();
    try
    {
      ArrayList localArrayList = new ArrayList();
      Object localObject = (List)a().c().get(j(paramString, paramInt));
      if ((localObject != null) && (!((List)localObject).isEmpty()))
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
          if ((localMessageRecord != null) && (localMessageRecord.shmsgseq >= paramLong))
          {
            localArrayList.add(localMessageRecord);
            QLog.d("Q.msg.MsgProxy", 1, new Object[] { "removeBreakMsgFromMsgPool left msg shmsgseq:", Long.valueOf(localMessageRecord.shmsgseq) });
          }
        }
        a().c().put(j(paramString, paramInt), localArrayList);
        localLock.unlock();
        return;
      }
      localLock.unlock();
      return;
    }
    finally
    {
      localLock.unlock();
    }
    for (;;)
    {
      throw paramString;
    }
  }
  
  public void a(String paramString, int paramInt, long paramLong1, long paramLong2, List<MessageRecord> paramList)
  {
    Lock localLock = q(paramString, paramInt);
    localLock.lock();
    try
    {
      b(paramString, paramInt, paramLong1, paramLong2, paramList);
      return;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  public void a(String paramString, int paramInt, long paramLong, ContentValues paramContentValues)
  {
    MessageRecord localMessageRecord = b(paramString, paramInt, paramLong);
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
    Lock localLock = q(paramString, paramInt);
    localLock.lock();
    try
    {
      c(paramString, paramInt, paramLong, paramList);
      return;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  public void a(String paramString, int paramInt, MessageRecord paramMessageRecord)
  {
    Lock localLock = q(paramString, paramInt);
    localLock.lock();
    try
    {
      e(paramString, paramInt, paramMessageRecord);
      return;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  public void a(String paramString, int paramInt1, MessageRecord paramMessageRecord, int paramInt2)
  {
    i(paramString, paramInt1, paramInt2);
    b(paramString, paramInt1, paramMessageRecord, paramInt2);
  }
  
  protected void a(String paramString, int paramInt, MessageRecord paramMessageRecord, ProxyListener paramProxyListener)
  {
    if (paramMessageRecord.versionCode > 0) {
      this.proxyManager.addMsgQueueDonotNotify(paramString, paramInt, l(paramString, paramInt), paramMessageRecord, 0, paramProxyListener);
    }
    this.proxyManager.transSaveToDatabase();
  }
  
  protected void a(String paramString, int paramInt, MessageRecord paramMessageRecord, ProxyListener paramProxyListener, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((UinTypeUtil.d(paramMessageRecord.msgtype)) && (!UinTypeUtil.c(paramMessageRecord.frienduin, paramMessageRecord.istroop))) {
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
    Object localObject = q(paramString, paramInt);
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
      this.proxyManager.addMsgQueue(paramString, paramInt, l(paramString, paramInt), paramEntity, 0, paramProxyListener);
    }
  }
  
  protected void a(String paramString1, int paramInt, String paramString2, ContentValues paramContentValues, String paramString3, String[] paramArrayOfString, ProxyListener paramProxyListener)
  {
    this.proxyManager.addMsgQueue(paramString1, paramInt, paramString2, paramContentValues, paramString3, paramArrayOfString, 1, paramProxyListener);
  }
  
  public void a(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2)
  {
    Lock localLock = q(paramString1, paramInt1);
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
  
  protected void a(String paramString, int paramInt, Set<String> paramSet)
  {
    paramSet.add(this.app.getAccount());
    paramSet.add(paramString);
  }
  
  public void a(List<MessageRecord> paramList, ProxyListener paramProxyListener)
  {
    b(UinTypeUtil.b(paramList), paramProxyListener);
  }
  
  protected boolean a(int paramInt, long paramLong, MessageRecord paramMessageRecord)
  {
    if ((!UinTypeUtil.h(paramInt)) && (!UinTypeUtil.i(paramInt))) {
      return paramLong >= paramMessageRecord.time;
    }
    return paramLong >= paramMessageRecord.shmsgseq;
  }
  
  protected boolean a(String paramString1, int paramInt, String paramString2, List<MessageRecord> paramList)
  {
    if (c(paramString1, paramInt, paramString2))
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
      e(paramString1, paramInt, paramString2);
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
  
  public int b(String paramString, int paramInt, boolean paramBoolean)
  {
    int i = r(paramString, paramInt);
    if (paramBoolean)
    {
      a(paramString, paramInt, l(paramString, paramInt), null, null, null);
      a(paramString, paramInt, t(paramString, paramInt), null, null, null);
    }
    c.a(paramString, paramInt, paramBoolean, this, this.app);
    return i;
  }
  
  public MessageRecord b(MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    if (paramMessageRecord == null) {
      return null;
    }
    MessageRecord localMessageRecord = b(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.uniseq);
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
  
  public MessageRecord b(String paramString, int paramInt1, int paramInt2)
  {
    Lock localLock = q(paramString, paramInt1);
    localLock.lock();
    try
    {
      paramString = h(paramString, paramInt1, paramInt2);
      return paramString;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  public MessageRecord b(String paramString, int paramInt, long paramLong)
  {
    MessageRecord localMessageRecord2 = null;
    if ((paramLong != 0L) && (paramString != null))
    {
      if (paramString.length() == 0) {
        return null;
      }
      Object localObject = c(paramString, paramInt);
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
        paramString = g(paramString, paramInt);
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
  
  public MessageRecord b(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    Lock localLock = q(paramString, paramInt1);
    localLock.lock();
    try
    {
      paramString = g(paramString, paramInt1, paramLong, paramInt2);
      return paramString;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  public MessageRecord b(String paramString, int paramInt, long paramLong1, long paramLong2, long paramLong3)
  {
    MessageRecord localMessageRecord = b(paramString, paramInt, paramLong1);
    if (localMessageRecord != null)
    {
      localMessageRecord.time = paramLong2;
      localMessageRecord.shmsgseq = paramLong3;
      h(paramString, paramInt, paramLong1);
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
  
  protected List<MessageRecord> b(String paramString)
  {
    return (List)j().get(paramString);
  }
  
  public List<MessageRecord> b(String paramString, int paramInt)
  {
    return b(c(paramString, paramInt));
  }
  
  public List<MessageRecord> b(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    return null;
  }
  
  public List<MessageRecord> b(String paramString, int paramInt1, long paramLong1, int paramInt2, long paramLong2, int paramInt3, int[] paramArrayOfInt)
  {
    return null;
  }
  
  protected List<MessageRecord> b(String paramString1, int paramInt1, long paramLong, int paramInt2, String paramString2)
  {
    if (a(paramString1, paramInt1, true)) {
      this.proxyManager.transSaveToDatabase(d());
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
    ((StringBuilder)localObject3).append(l(paramString1, paramInt1));
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
    paramString2 = c.a(paramString2, null, this);
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
      Object localObject = d(paramString, paramInt);
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
  
  protected void b(QueryHistoryParam paramQueryHistoryParam)
  {
    c.a(this.app, this.b, paramQueryHistoryParam);
  }
  
  protected void b(String paramString, int paramInt, long paramLong1, long paramLong2, List<MessageRecord> paramList)
  {
    Object localObject = j(paramString, paramInt);
    if (i().containsKey(localObject))
    {
      localObject = a((String)localObject);
      ArrayList localArrayList = new ArrayList();
      int j = 0;
      int k;
      for (int i = 0;; i = k)
      {
        k = i;
        if (j >= ((List)localObject).size()) {
          break;
        }
        MessageRecord localMessageRecord = (MessageRecord)((List)localObject).get(j);
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("find cache ");
          localStringBuilder.append(localMessageRecord.getBaseInfoString());
          QLog.d("Q.msg.MsgProxy", 2, localStringBuilder.toString());
        }
        k = i;
        if (localMessageRecord.uniseq >= paramLong1)
        {
          k = i;
          if (localMessageRecord.uniseq <= paramLong2)
          {
            if (localArrayList.size() == 0) {
              i = j;
            }
            localArrayList.add(localMessageRecord);
            k = i;
          }
        }
        if (localMessageRecord.uniseq > paramLong2) {
          break;
        }
        j += 1;
      }
      ((List)localObject).removeAll(localArrayList);
      ((List)localObject).addAll(k, paramList);
      if (((List)localObject).size() > 40)
      {
        i = ((List)localObject).size() - 40;
        while (i > 0)
        {
          ((List)localObject).remove(0);
          i -= 1;
        }
      }
      g(paramString, paramInt, (List)localObject);
    }
  }
  
  public void b(String paramString, int paramInt, long paramLong, List<MessageRecord> paramList) {}
  
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
        str = l(String.valueOf(AppConstants.LBS_HELLO_UIN), 1001);
      } else {
        str = t(String.valueOf(AppConstants.LBS_HELLO_UIN), 1001);
      }
      a(paramString, paramInt1, str, localContentValues, "senderuin=? and isread=?", new String[] { paramString, "0" }, null);
      a(paramString, paramInt1, paramMessageRecord.versionCode, localContentValues, "isread=?", new String[] { "0" }, null);
      return;
    }
    if (paramInt1 == 1009)
    {
      a(paramString, paramInt1, l(AppConstants.SAME_STATE_BOX_UIN, 1009), localContentValues, "senderuin=? and isread=?", new String[] { paramString, "0" }, null);
      a(paramString, paramInt1, paramMessageRecord.versionCode, localContentValues, "isread=?", new String[] { "0" }, null);
      return;
    }
    if (paramInt1 == 1010)
    {
      a(paramString, paramInt1, l(AppConstants.DATE_UIN, 1010), localContentValues, "senderuin=? and isread=?", new String[] { paramString, "0" }, null);
      a(paramString, paramInt1, paramMessageRecord.versionCode, localContentValues, "isread=?", new String[] { "0" }, null);
      return;
    }
    if ((paramInt1 == 0) && (TextUtils.equals(paramString, AppConstants.FRIEND_SYSTEM_MSG_UIN)))
    {
      a(paramString, paramInt1, l(AppConstants.FRIEND_SYSTEM_MSG_UIN, 0), localContentValues, "senderuin=? and isread=?", new String[] { paramString, "0" }, null);
      a(paramString, paramInt1, paramMessageRecord.versionCode, localContentValues, "isread=?", new String[] { "0" }, null);
      return;
    }
    if ((paramInt1 == 1032) && (TextUtils.equals(paramString, AppConstants.CONFESS_UIN))) {
      a(paramString, paramInt1, l(paramString, paramInt1), localContentValues, "isread=?", new String[] { "0" }, null);
    }
  }
  
  public void b(String paramString, int paramInt, List<MessageRecord> paramList)
  {
    i(paramString, paramInt, paramList);
    Lock localLock = q(paramString, paramInt);
    localLock.lock();
    try
    {
      j(paramString, paramInt, paramList);
      localLock.unlock();
      h(paramString, paramInt, paramList);
      return;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  public int c(String paramString, int paramInt, MessageRecord paramMessageRecord)
  {
    paramString = l(paramString, paramInt);
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
      paramString = d().query(false, paramString, new String[] { "_id" }, (String)localObject, new String[] { String.valueOf(l1), String.valueOf(l2), String.valueOf(i), String.valueOf(l3) }, null, null, null, null);
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
  
  public MessageRecord c(String paramString, int paramInt, long paramLong)
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
        localObject2 = d(paramString, paramInt);
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
          paramString = n(paramString, paramInt, paramLong);
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
    Lock localLock = q(paramString, paramInt);
    localLock.lock();
    try
    {
      paramString = a(n(paramString, paramInt));
      return paramString;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  public List<MessageRecord> c(String paramString, int paramInt1, int paramInt2)
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
  
  public List<MessageRecord> c(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    Lock localLock = q(paramString, paramInt1);
    localLock.lock();
    try
    {
      paramString = h(paramString, paramInt1, paramLong, paramInt2);
      return paramString;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  protected List<MessageRecord> c(String paramString1, int paramInt1, long paramLong, int paramInt2, String paramString2)
  {
    if (a(paramString1, paramInt1, true)) {
      this.proxyManager.transSaveToDatabase(d());
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("select * from ");
    ((StringBuilder)localObject).append(l(paramString1, paramInt1));
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
    paramString2 = c.a(paramString2, new String[] { String.valueOf(paramLong), String.valueOf(l1) }, this);
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
      this.proxyManager.transSaveToDatabase(d());
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("select * from ");
    ((StringBuilder)localObject).append(l(paramString, paramInt));
    ((StringBuilder)localObject).append(" where shmsgseq>=? and shmsgseq<=? order by shmsgseq asc");
    paramString = ((StringBuilder)localObject).toString();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("queryMessageFromBySeq ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("Q.msg.MsgProxy", 2, ((StringBuilder)localObject).toString());
    }
    localObject = c.a(paramString, new String[] { String.valueOf(paramLong1), String.valueOf(paramLong2) }, this);
    paramString = (String)localObject;
    if (localObject == null) {
      paramString = new ArrayList();
    }
    return paramString;
  }
  
  protected void c(String paramString, int paramInt, long paramLong, List<MessageRecord> paramList)
  {
    Object localObject1 = j(paramString, paramInt);
    if (i().containsKey(localObject1))
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
      g(paramString, paramInt, (List)localObject1);
    }
  }
  
  public void c(String paramString, int paramInt, List<MessageRecord> paramList)
  {
    i(paramString, paramInt, paramList);
    Lock localLock = q(paramString, paramInt);
    localLock.lock();
    try
    {
      k(paramString, paramInt, paramList);
      localLock.unlock();
      h(paramString, paramInt, paramList);
      return;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  public MessageRecord d(String paramString, int paramInt, long paramLong)
  {
    if ((paramLong != 0L) && (paramString != null) && (paramString.length() != 0))
    {
      Object localObject = d(paramString, paramInt);
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
      return o(paramString, paramInt, paramLong);
    }
    return null;
  }
  
  public MessageRecord d(String paramString, int paramInt, MessageRecord paramMessageRecord)
  {
    return null;
  }
  
  public EntityManager d()
  {
    ??? = this.b;
    if ((??? == null) || (!((EntityManager)???).isOpen())) {}
    synchronized (this.d)
    {
      if ((this.b == null) || (!this.b.isOpen())) {
        this.b = c.a(this.app);
      }
      return this.b;
    }
  }
  
  public List<MessageRecord> d(String paramString, int paramInt)
  {
    Lock localLock = q(paramString, paramInt);
    localLock.lock();
    try
    {
      paramString = m(paramString, paramInt);
      return paramString;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  @Nullable
  protected List<MessageRecord> d(String paramString, int paramInt1, int paramInt2)
  {
    paramString = n(paramString, paramInt1);
    if (paramString != null) {
      return (List)((ArrayList)paramString).clone();
    }
    return null;
  }
  
  public List<MessageRecord> d(String paramString, int paramInt1, long paramLong, int paramInt2)
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
    Object localObject1 = l(paramString, paramInt1);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("select * from ");
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(" where (shmsgseq < ? and msgtype ");
    ((StringBuilder)localObject2).append(UinTypeUtil.a());
    ((StringBuilder)localObject2).append(" and isValid=1) order by shmsgseq desc limit ");
    Object localObject3 = ((StringBuilder)localObject2).toString();
    String[] arrayOfString = new String[1];
    arrayOfString[0] = String.valueOf(paramLong);
    localObject1 = c;
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
      paramString = c.a(paramString, paramInt1, paramLong, paramInt2 - ((List)localObject1).size(), (String)localObject3, arrayOfString, this, this.app);
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
    Object localObject2 = c(paramString, paramInt);
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
      this.proxyManager.transSaveToDatabase(d());
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("select * from ");
    ((StringBuilder)localObject2).append(l(paramString, paramInt));
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
    localObject2 = c.a((String)localObject2, new String[] { String.valueOf(paramLong1), String.valueOf(paramLong2) }, this);
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
  
  /* Error */
  public List<MessageRecord> d(String paramString, int paramInt, List<Integer> paramList)
  {
    // Byte code:
    //   0: aload_3
    //   1: invokeinterface 225 1 0
    //   6: bipush 50
    //   8: if_icmple +16 -> 24
    //   11: aload_3
    //   12: iconst_0
    //   13: bipush 50
    //   15: invokeinterface 229 3 0
    //   20: astore_3
    //   21: goto +3 -> 24
    //   24: aload_0
    //   25: aload_1
    //   26: iload_2
    //   27: invokevirtual 397	com/tencent/imcore/message/MsgProxy:l	(Ljava/lang/String;I)Ljava/lang/String;
    //   30: astore_1
    //   31: iconst_1
    //   32: anewarray 123	java/lang/String
    //   35: astore 4
    //   37: new 264	java/util/ArrayList
    //   40: dup
    //   41: invokespecial 265	java/util/ArrayList:<init>	()V
    //   44: astore 5
    //   46: aload_3
    //   47: invokeinterface 52 1 0
    //   52: astore 6
    //   54: aload 6
    //   56: invokeinterface 57 1 0
    //   61: ifeq +126 -> 187
    //   64: aload 4
    //   66: iconst_0
    //   67: aload 6
    //   69: invokeinterface 61 1 0
    //   74: checkcast 193	java/lang/Integer
    //   77: invokevirtual 1631	java/lang/Integer:intValue	()I
    //   80: invokestatic 126	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   83: aastore
    //   84: aload_0
    //   85: invokevirtual 203	com/tencent/imcore/message/MsgProxy:d	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   88: iconst_0
    //   89: aload_1
    //   90: aconst_null
    //   91: ldc_w 1633
    //   94: aload 4
    //   96: aconst_null
    //   97: aconst_null
    //   98: aconst_null
    //   99: aconst_null
    //   100: invokevirtual 874	com/tencent/mobileqq/persistence/EntityManager:query	(ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   103: astore_3
    //   104: aload_3
    //   105: ifnull +75 -> 180
    //   108: aload 5
    //   110: aload_0
    //   111: invokevirtual 203	com/tencent/imcore/message/MsgProxy:d	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   114: ldc 63
    //   116: aconst_null
    //   117: aload_3
    //   118: invokevirtual 1636	com/tencent/mobileqq/persistence/EntityManager:cursor2Entity	(Ljava/lang/Class;Ljava/lang/String;Landroid/database/Cursor;)Lcom/tencent/mobileqq/persistence/Entity;
    //   121: checkcast 63	com/tencent/mobileqq/data/MessageRecord
    //   124: invokevirtual 852	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   127: pop
    //   128: goto +52 -> 180
    //   131: astore_1
    //   132: goto +36 -> 168
    //   135: astore 7
    //   137: invokestatic 68	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   140: ifeq +15 -> 155
    //   143: ldc 83
    //   145: iconst_2
    //   146: aload 7
    //   148: iconst_0
    //   149: anewarray 33	java/lang/Object
    //   152: invokestatic 879	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   155: aload_3
    //   156: ifnull -102 -> 54
    //   159: aload_3
    //   160: invokeinterface 336 1 0
    //   165: goto -111 -> 54
    //   168: aload_3
    //   169: ifnull +9 -> 178
    //   172: aload_3
    //   173: invokeinterface 336 1 0
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
  
  public void destroy()
  {
    EntityManager localEntityManager = this.b;
    if ((localEntityManager != null) && (localEntityManager.isOpen())) {
      this.b.close();
    }
  }
  
  public MessageRecord e(String paramString, int paramInt)
  {
    return b(paramString, paramInt, 0);
  }
  
  protected MessageRecord e(String paramString, int paramInt1, int paramInt2)
  {
    String str1 = l(paramString, paramInt1);
    if (a(str1, false)) {
      this.proxyManager.transSaveToDatabase(this.b);
    }
    paramString = new StringBuilder(512);
    paramString.append("select * from %s m where m.isValid=1");
    paramString.append(" order by %s limit 1");
    String str2 = paramString.toString();
    if ((!UinTypeUtil.h(paramInt1)) && (!UinTypeUtil.i(paramInt1))) {
      paramString = "time desc , _id desc";
    } else {
      paramString = "shmsgseq desc , _id desc";
    }
    paramString = String.format(str2, new Object[] { str1, paramString });
    paramString = d().rawQuery(MessageRecord.class, paramString, null);
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
  
  public MessageRecord e(String paramString, int paramInt, long paramLong)
  {
    if ((paramLong != 0L) && (paramString != null) && (paramString.length() != 0))
    {
      Object localObject = d(paramString, paramInt);
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
          if ((localMessageRecord.shmsgseq == paramLong) && (!c.a(localMessageRecord))) {
            return localMessageRecord;
          }
        }
      }
      return p(paramString, paramInt, paramLong);
    }
    return null;
  }
  
  public List<MessageRecord> e(String paramString, int paramInt1, long paramLong, int paramInt2)
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
    Object localObject2 = l(paramString, paramInt1);
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
    localObject1 = c.a((String)localObject1, (String[])localObject3, this);
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
      localObject2 = c.b(paramString, paramInt1, paramLong, paramInt2, (String)localObject2, (String[])localObject3, this, this.app);
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
      this.proxyManager.transSaveToDatabase(d());
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("select * from ");
    ((StringBuilder)localObject).append(l(paramString, paramInt));
    ((StringBuilder)localObject).append(" where time=? and msgUid=?");
    localObject = ((StringBuilder)localObject).toString();
    localObject = c.a((String)localObject, new String[] { String.valueOf(paramLong1), String.valueOf(paramLong2) }, this);
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
  
  public void e()
  {
    try
    {
      j().clear();
      c.e(this.app);
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
  
  protected void e(String paramString, int paramInt, List<MessageRecord> paramList)
  {
    j().put(j(paramString, paramInt), paramList);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, new Object[] { "putAioMsgList list size:", Integer.valueOf(paramList.size()) });
    }
  }
  
  public int f(String paramString, int paramInt, long paramLong)
  {
    String str = l(paramString, paramInt);
    boolean bool = UinTypeUtil.h(paramInt);
    int j = 0;
    int i;
    if ((!bool) && (!UinTypeUtil.i(paramInt))) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0) {
      ??? = "shmsgseq desc , _id desc";
    } else {
      ??? = "time desc , _id desc";
    }
    if (i != 0) {
      localObject2 = "shmsgseq";
    } else {
      localObject2 = "time";
    }
    Object localObject2 = String.format("select * from (select count() as unReadNum from %s mr where mr.isread=0 and mr.issend='0' and mr.%s>'%d'),%s m where m.%s>'%d' order by %s limit 1", new Object[] { str, localObject2, Long.valueOf(paramLong), str, localObject2, Long.valueOf(paramLong), ??? });
    synchronized (c.b(this.app))
    {
      if (a(paramString, paramInt, false)) {
        this.proxyManager.transSaveToDatabase(d());
      }
      localObject2 = d().rawQuery(Message.class, (String)localObject2, null);
      i = j;
      if (localObject2 != null)
      {
        i = j;
        if (!((List)localObject2).isEmpty()) {
          i = ((Message)((List)localObject2).get(0)).unReadNum;
        }
      }
      j = l(paramString, paramInt, paramLong);
      paramInt = c.a(paramString, paramInt, paramLong, i + j, this.app);
      return paramInt;
    }
  }
  
  public MessageRecord f(String paramString, int paramInt)
  {
    String str1 = l(paramString, paramInt);
    if (a(str1, false)) {
      this.proxyManager.transSaveToDatabase(this.b);
    }
    String str2 = UinTypeUtil.a();
    if ((!UinTypeUtil.h(paramInt)) && (!UinTypeUtil.i(paramInt))) {
      paramString = "time asc , _id desc";
    } else {
      paramString = "shmsgseq asc , _id desc";
    }
    paramString = String.format("select * from %s m where m.isValid=1 and m.msgtype %s order by %s limit 1", new Object[] { str1, str2, paramString });
    paramString = d().rawQuery(MessageRecord.class, paramString, null);
    if ((paramString != null) && (!paramString.isEmpty())) {
      return (MessageRecord)paramString.get(0);
    }
    return null;
  }
  
  protected List<MessageRecord> f(String paramString, int paramInt1, int paramInt2)
  {
    if (a(paramString, paramInt1, true)) {
      this.proxyManager.transSaveToDatabase(d());
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("select _id, extraflag, frienduin, isread, issend, istroop, msg, NULL as msgData, msgId, msgseq, msgtype, selfuin, senderuin, shmsgseq, time, 0 as versionCode, NULL as longMsgIndex, NULL as longMsgId, NULL as longMsgCount, 1 as isValid, NULL as msgUid, NULL as vipBubbleID, 0 as uniseq, 0 as sendFailCode, NULL as extStr, 0 as extInt, 0 as extLong from ( select _id, extraflag, frienduin, isread, issend, istroop, msg, NULL as msgData, msgId, msgseq, msgtype, selfuin, senderuin, shmsgseq, time, 0 as versionCode, NULL as longMsgIndex, NULL as longMsgId, NULL as longMsgCount, 1 as isValid, NULL as msgUid, NULL as vipBubbleID, 0 as uniseq, 0 as sendFailCode, NULL as extStr, 0 as extInt, 0 as extLong from ");
    ((StringBuilder)localObject).append(t(paramString, paramInt1));
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
    localObject = c.a((String)localObject, null, this);
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
  
  protected List<MessageRecord> f(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    List localList;
    if ((!UinTypeUtil.h(paramInt1)) && (!UinTypeUtil.i(paramInt1))) {
      localList = a(paramString, paramInt1, paramLong, 2147483647L, paramInt2);
    } else {
      localList = d(paramString, paramInt1, paramLong, 2147483647L);
    }
    Object localObject = localList;
    if (localList == null) {
      localObject = new ArrayList();
    }
    e(paramString, paramInt1, (List)localObject);
    return localObject;
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
      this.proxyManager.transSaveToDatabase(d());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("select * from ");
    localStringBuilder.append(l(paramString, paramInt));
    localStringBuilder.append(" where shmsgseq=? and msgUid=?");
    paramString = localStringBuilder.toString();
    paramString = c.a(paramString, new String[] { String.valueOf(paramLong1), String.valueOf(paramLong2) }, this);
    if (paramString != null) {
      return paramString;
    }
    return new ArrayList();
  }
  
  public List<MessageRecord> f(String paramString, int paramInt, List<MessageRecord> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramInt != 0) && (paramInt != 1000) && (paramInt != 1004) && (paramInt != 1044) && (paramInt != 1045))
    {
      localArrayList.addAll(paramList);
      return localArrayList;
    }
    return a(paramString, paramInt, paramList, localArrayList);
  }
  
  public void f()
  {
    i().clear();
    j().clear();
    QLog.d("Q.msg.MsgProxy", 1, "clearAllHistoryFromCache");
  }
  
  public MessageRecord g(String paramString, int paramInt, long paramLong)
  {
    Lock localLock = q(paramString, paramInt);
    localLock.lock();
    try
    {
      paramString = r(paramString, paramInt, paramLong);
      return paramString;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  public List<MessageRecord> g(String paramString, int paramInt)
  {
    Lock localLock = q(paramString, paramInt);
    localLock.lock();
    try
    {
      paramString = a(i(paramString, paramInt));
      return paramString;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  protected List<MessageRecord> g(String paramString, int paramInt1, int paramInt2)
  {
    if (a(paramString, paramInt1, true)) {
      this.proxyManager.transSaveToDatabase(d());
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("select * from ");
    ((StringBuilder)localObject).append(l(paramString, paramInt1));
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
    localObject = c.a((String)localObject, new String[] { String.valueOf(-2006), String.valueOf(paramInt2) }, this);
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
  
  public void g()
  {
    k();
    EntityTransaction localEntityTransaction = d().getTransaction();
    SQLiteDatabase localSQLiteDatabase = l();
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
    c.a(this, this.app);
  }
  
  protected void g(String paramString, int paramInt, List<MessageRecord> paramList)
  {
    try
    {
      paramString = UinTypeUtil.a(paramString, paramInt);
      i().put(paramString, paramList);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public int h(String paramString, int paramInt)
  {
    paramString = i(paramString, paramInt);
    if (paramString == null) {
      return 0;
    }
    return paramString.size();
  }
  
  public MessageRecord h(String paramString, int paramInt, long paramLong)
  {
    Lock localLock = q(paramString, paramInt);
    localLock.lock();
    try
    {
      paramString = t(paramString, paramInt, paramLong);
      return paramString;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  public void h()
  {
    if ((this.proxyManager.getQueue() != null) && (this.proxyManager.getQueue().size() > 0)) {
      this.proxyManager.transSaveToDatabase(this.b);
    }
  }
  
  protected void h(String paramString, int paramInt, List<MessageRecord> paramList)
  {
    c.b(paramString, paramInt, paramList);
  }
  
  public int i(String paramString, int paramInt, long paramLong)
  {
    MessageRecord localMessageRecord = g(paramString, paramInt, paramLong);
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
        a(paramString, paramInt, l(paramString, paramInt), "_id=?", new String[] { String.valueOf(l) }, null);
      } else {
        a(paramString, paramInt, l(paramString, paramInt), "uniseq=?", new String[] { String.valueOf(paramLong) }, null);
      }
      s(localMessageRecord.frienduin, localMessageRecord.istroop);
      if (localMessageRecord.isread) {
        return 1;
      }
      return 2;
    }
    a(paramString, paramInt, l(paramString, paramInt), "uniseq=?", new String[] { String.valueOf(paramLong) }, null);
    return 1;
  }
  
  public List<MessageRecord> i(String paramString, int paramInt)
  {
    return a(paramString, paramInt, 0, false);
  }
  
  protected ConcurrentHashMap<String, List<MessageRecord>> i()
  {
    return this.a.b();
  }
  
  protected void i(String paramString, int paramInt, List<MessageRecord> paramList)
  {
    c.a(paramString, paramInt, paramList);
  }
  
  public void init() {}
  
  public String j(String paramString, int paramInt)
  {
    return UinTypeUtil.a(paramString, paramInt);
  }
  
  protected Map<String, List<MessageRecord>> j()
  {
    return this.a.c();
  }
  
  public void j(String paramString, int paramInt, long paramLong)
  {
    q(paramString, paramInt, paramLong);
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("isread", Boolean.valueOf(true));
    int i;
    if ((!UinTypeUtil.h(paramInt)) && (!UinTypeUtil.i(paramInt))) {
      i = 0;
    } else {
      i = 1;
    }
    String str1;
    if (i != 0) {
      str1 = "shmsgseq";
    } else {
      str1 = "time";
    }
    String str2 = String.valueOf(paramLong);
    String str3 = l(paramString, paramInt);
    if ((UinTypeUtil.f(paramInt)) && (UinTypeUtil.d() != null))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isread=? and %s<=? and ");
      localStringBuilder.append(UinTypeUtil.d());
      a(paramString, paramInt, str3, localContentValues, String.format(localStringBuilder.toString(), new Object[] { str1 }), new String[] { "0", str2 }, null);
      return;
    }
    a(paramString, paramInt, str3, localContentValues, String.format("isread=? and %s<=?", new Object[] { str1 }), new String[] { "0", str2 }, null);
  }
  
  protected void j(String paramString, int paramInt, List<MessageRecord> paramList)
  {
    if (j().containsKey(j(paramString, paramInt)))
    {
      List localList = b(j(paramString, paramInt));
      Object localObject = localList;
      if (localList == null) {
        localObject = new ArrayList();
      }
      localList = UinTypeUtil.a((List)localObject, paramList);
      c.a(paramString, paramInt, localList, (List)localObject, this.app);
      paramList.clear();
      paramList.addAll(localList);
    }
  }
  
  public MessageRecord k(String paramString, int paramInt, long paramLong)
  {
    MessageRecord localMessageRecord = d(paramString, paramInt, paramLong);
    if (localMessageRecord != null) {
      return localMessageRecord;
    }
    return c.a(paramString, paramInt, paramLong, this, this.app);
  }
  
  public List<MessageRecord> k(String paramString, int paramInt)
  {
    Lock localLock = q(paramString, paramInt);
    localLock.lock();
    try
    {
      paramString = x(paramString, paramInt);
      return paramString;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  void k()
  {
    this.proxyManager.transSaveToDatabase();
    this.proxyManager.clearMsgQueue();
  }
  
  protected void k(String paramString, int paramInt, List<MessageRecord> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "addAIOMessageLocked");
    }
    if (j().containsKey(j(paramString, paramInt)))
    {
      List localList = b(j(paramString, paramInt));
      Object localObject = localList;
      if (localList == null) {
        localObject = new ArrayList();
      }
      localList = UinTypeUtil.a((List)localObject, paramList);
      c.b(paramString, paramInt, localList, (List)localObject, this.app);
      paramList.clear();
      paramList.addAll(localList);
    }
  }
  
  protected int l(String paramString, int paramInt, long paramLong)
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
  
  protected SQLiteDatabase l()
  {
    return c.c(this.app);
  }
  
  @NonNull
  public String l(String paramString, int paramInt)
  {
    return MessageRecord.getTableName(paramString, paramInt);
  }
  
  protected List<MessageRecord> l(String paramString, int paramInt, List<Long> paramList)
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
        this.proxyManager.transSaveToDatabase(d());
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
      paramList.append(l(paramString, paramInt));
      paramList.append(" where uniseq in ");
      paramList.append(localStringBuilder.toString());
      paramString = paramList.toString();
      paramString = c.a(paramString, (String[])localObject, this);
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
  
  protected SQLiteDatabase m()
  {
    return c.d(this.app);
  }
  
  protected MessageRecord m(String paramString, int paramInt, long paramLong)
  {
    Lock localLock = q(paramString, paramInt);
    localLock.lock();
    try
    {
      paramString = s(paramString, paramInt, paramLong);
      return paramString;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  @Nullable
  protected List<MessageRecord> m(String paramString, int paramInt)
  {
    paramString = a(j(paramString, paramInt));
    if (paramString != null) {
      return (List)((ArrayList)paramString).clone();
    }
    return null;
  }
  
  public List<MessageRecord> n(String paramString, int paramInt)
  {
    String str = j(paramString, paramInt);
    Lock localLock = q(paramString, paramInt);
    localLock.lock();
    try
    {
      paramString = b(paramString, paramInt, str);
      return paramString;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  protected List<MessageRecord> n(String paramString, int paramInt, long paramLong)
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
      this.proxyManager.transSaveToDatabase(d());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("select * from ");
    localStringBuilder.append(l(paramString, paramInt));
    localStringBuilder.append(" where uniseq=?");
    paramString = localStringBuilder.toString();
    paramString = c.a(paramString, new String[] { String.valueOf(paramLong) }, this);
    if (paramString != null) {
      return paramString;
    }
    return new ArrayList();
  }
  
  @Deprecated
  protected AppRuntime n()
  {
    return this.app;
  }
  
  protected MessageRecord o(String paramString, int paramInt, long paramLong)
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
      this.proxyManager.transSaveToDatabase(d());
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("select * from ");
    ((StringBuilder)localObject).append(l(paramString, paramInt));
    ((StringBuilder)localObject).append(" where shmsgseq=?");
    localObject = ((StringBuilder)localObject).toString();
    localObject = c.a((String)localObject, new String[] { String.valueOf(paramLong) }, this);
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
  
  protected String o(String paramString, int paramInt)
  {
    if (UinTypeUtil.a(paramString))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("select * from ");
      localStringBuilder.append(l(paramString, paramInt));
      localStringBuilder.append(" order by time desc , _id desc");
      return localStringBuilder.toString();
    }
    if (UinTypeUtil.b(paramInt))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("select * from ");
      localStringBuilder.append(l(paramString, paramInt));
      localStringBuilder.append(" where _id in (select _id from ");
      localStringBuilder.append(l(paramString, paramInt));
      localStringBuilder.append(" order by time desc limit ");
      localStringBuilder.append(40);
      localStringBuilder.append(") order by time desc, _id desc");
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("select * from ");
    localStringBuilder.append(l(paramString, paramInt));
    localStringBuilder.append(" order by _id desc limit ");
    localStringBuilder.append(40);
    return localStringBuilder.toString();
  }
  
  protected MessageRecord p(String paramString, int paramInt, long paramLong)
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
      this.proxyManager.transSaveToDatabase(d());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("select * from ");
    localStringBuilder.append(l(paramString, paramInt));
    localStringBuilder.append(" where shmsgseq=? and msgtype ");
    localStringBuilder.append(UinTypeUtil.c());
    paramString = localStringBuilder.toString();
    paramString = c.a(paramString, new String[] { String.valueOf(paramLong) }, this);
    if ((paramString != null) && (paramString.size() > 0)) {
      return (MessageRecord)paramString.get(0);
    }
    return null;
  }
  
  protected List<MessageRecord> p(String paramString, int paramInt)
  {
    return c(paramString, paramInt, 0);
  }
  
  protected Lock q(String paramString, int paramInt)
  {
    return this.a.a(paramString, paramInt);
  }
  
  protected void q(String paramString, int paramInt, long paramLong)
  {
    Lock localLock = q(paramString, paramInt);
    localLock.lock();
    try
    {
      u(paramString, paramInt, paramLong);
      return;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  protected int r(String paramString, int paramInt)
  {
    Lock localLock = q(paramString, paramInt);
    localLock.lock();
    try
    {
      paramInt = y(paramString, paramInt);
      return paramInt;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  protected void s(String paramString, int paramInt)
  {
    List localList = n(paramString, paramInt);
    if ((localList != null) && (localList.size() == 0))
    {
      if (a(paramString, paramInt, true)) {
        this.proxyManager.transSaveToDatabase(d());
      }
      i().remove(j(paramString, paramInt));
      g(paramString, paramInt, k(paramString, paramInt));
    }
  }
  
  @NonNull
  protected String t(String paramString, int paramInt)
  {
    return MessageRecord.getOldTableName(paramString, paramInt);
  }
  
  protected boolean u(String paramString, int paramInt)
  {
    return MessageDBUtils.a(l(paramString, paramInt), m());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.MsgProxy
 * JD-Core Version:    0.7.0.1
 */