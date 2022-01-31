package com.tencent.biz.pubaccount.readinjoy.logic;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import loq;
import mqq.app.AppRuntime;

public class SMRM
{
  public static SMRM a;
  public long a;
  SQLiteDatabase jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase = null;
  private final String jdField_a_of_type_JavaLangString = "readinjoy_smrm_last_u";
  private boolean jdField_a_of_type_Boolean;
  long b;
  
  public static SMRM a()
  {
    if (jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicSMRM == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicSMRM == null) {
        jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicSMRM = new SMRM();
      }
      return jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicSMRM;
    }
    finally {}
  }
  
  private Map a(QQAppInterface paramQQAppInterface)
  {
    Object localObject = (TroopManager)paramQQAppInterface.getManager(51);
    paramQQAppInterface = new HashMap();
    localObject = ((TroopManager)localObject).a();
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        TroopInfo localTroopInfo = (TroopInfo)((Iterator)localObject).next();
        paramQQAppInterface.put(localTroopInfo.troopuin, localTroopInfo);
      }
    }
    if (a()) {
      QLog.d("SMRM", 2, "getGMap " + paramQQAppInterface);
    }
    return paramQQAppInterface;
  }
  
  private void a()
  {
    try
    {
      if (this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase != null) {
        this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.close();
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("SMRM", 2, "run", localException);
    }
  }
  
  public static void a(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    paramAppRuntime = ReadInJoyHelper.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null) {
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putBoolean("readinjoy_smrm_switch", paramBoolean);
    ReadInJoyHelper.a(paramAppRuntime, true);
  }
  
  public static boolean a(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = ReadInJoyHelper.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null) {
      return false;
    }
    return paramAppRuntime.getBoolean("readinjoy_smrm_switch", false);
  }
  
  private long b()
  {
    return this.jdField_b_of_type_Long;
  }
  
  private Map b(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = (DiscussionManager)paramQQAppInterface.getManager(52);
    HashMap localHashMap = new HashMap();
    Object localObject = paramQQAppInterface.a();
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        DiscussionInfo localDiscussionInfo = (DiscussionInfo)((Iterator)localObject).next();
        localHashMap.put(localDiscussionInfo.uin, Long.valueOf(paramQQAppInterface.a(localDiscussionInfo.uin)));
      }
    }
    if (a()) {
      QLog.d("SMRM", 2, "getDMapL " + localHashMap);
    }
    return localHashMap;
  }
  
  private void b(long paramLong)
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if (localObject == null) {}
    do
    {
      return;
      localObject = ReadInJoyHelper.a((AppRuntime)localObject, true, true);
    } while (localObject == null);
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putLong("readinjoy_smrm_last_u", paramLong);
    ReadInJoyHelper.a((SharedPreferences.Editor)localObject, true);
  }
  
  private void b(QQAppInterface paramQQAppInterface)
  {
    String str = paramQQAppInterface.getCurrentAccountUin() + ".db";
    this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase = SQLiteDatabase.openDatabase(paramQQAppInterface.getApp().getDatabasePath(str).getPath(), null, 1);
  }
  
  private long c()
  {
    return NetConnInfoCenter.getServerTime();
  }
  
  private void c(QQAppInterface paramQQAppInterface)
  {
    LinkedList localLinkedList = new LinkedList();
    if (TextUtils.isEmpty(paramQQAppInterface.getCurrentAccountUin())) {}
    do
    {
      return;
      localObject = paramQQAppInterface.a().a();
    } while (localObject == null);
    Object localObject = ((RecentUserProxy)localObject).a(false);
    if ((localObject == null) || (((List)localObject).size() <= 0))
    {
      SMRMH.a(1, Long.parseLong(paramQQAppInterface.c()), b(), localLinkedList);
      return;
    }
    SQLiteDatabase localSQLiteDatabase = this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase;
    Iterator localIterator = ((List)localObject).iterator();
    RecentUser localRecentUser;
    int n;
    int i1;
    int j;
    int i2;
    int m;
    loq localloq;
    Cursor localCursor2;
    Cursor localCursor1;
    while (localIterator.hasNext())
    {
      localRecentUser = (RecentUser)localIterator.next();
      if ((localRecentUser != null) && (localRecentUser.type == 0)) {
        if (localRecentUser.lastmsgtime <= b())
        {
          if (a()) {
            QLog.d("SMRM", 2, "runC ru.lastmsgtime < getTs() ru:" + localRecentUser.lastmsgtime + " ts:" + b());
          }
        }
        else
        {
          if (a()) {
            QLog.d("SMRM", 2, "start c " + localRecentUser.uin);
          }
          n = -1;
          i1 = 0;
          j = 0;
          i2 = 0;
          m = 0;
          localloq = null;
          localCursor2 = null;
          localCursor1 = localCursor2;
          localObject = localloq;
        }
      }
    }
    for (;;)
    {
      int k;
      try
      {
        String str = MessageRecord.getTableName(localRecentUser.uin, localRecentUser.type);
        localCursor1 = localCursor2;
        localObject = localloq;
        long l = b();
        localCursor1 = localCursor2;
        localObject = localloq;
        localCursor2 = localSQLiteDatabase.query(str, new String[] { "issend" }, "time>?", new String[] { String.valueOf(l) }, null, null, "time");
        k = i2;
        i = i1;
        if (localCursor2 != null)
        {
          k = i2;
          i = i1;
          localCursor1 = localCursor2;
          localObject = localCursor2;
          if (localCursor2.moveToFirst())
          {
            i = n;
            k = m;
            localCursor1 = localCursor2;
            localObject = localCursor2;
            m = localCursor2.getInt(localCursor2.getColumnIndex("issend"));
            localCursor1 = localCursor2;
            localObject = localCursor2;
            if (!a()) {
              break label719;
            }
            localCursor1 = localCursor2;
            localObject = localCursor2;
            QLog.d("SMRM", 2, localRecentUser.uin + " c_t:" + m);
            break label719;
            localCursor1 = localCursor2;
            localObject = localCursor2;
            if (localCursor2.moveToNext()) {
              break label697;
            }
          }
        }
        localCursor1 = localCursor2;
        localObject = localCursor2;
        localloq = new loq();
        localCursor1 = localCursor2;
        localObject = localCursor2;
        localloq.jdField_a_of_type_Int = k;
        localCursor1 = localCursor2;
        localObject = localCursor2;
        localloq.jdField_b_of_type_Int = i;
        localCursor1 = localCursor2;
        localObject = localCursor2;
        localloq.jdField_a_of_type_Long = Long.parseLong(localRecentUser.uin);
        localCursor1 = localCursor2;
        localObject = localCursor2;
        localLinkedList.add(localloq);
        localCursor1 = localCursor2;
        localObject = localCursor2;
        if (a())
        {
          localCursor1 = localCursor2;
          localObject = localCursor2;
          QLog.d("SMRM", 2, localloq.toString());
        }
        if (localCursor2 == null) {
          break;
        }
        localCursor2.close();
        break;
        if (m == i) {
          break label708;
        }
        i = j + 1;
        j = m;
        continue;
      }
      catch (Exception localException)
      {
        localObject = localCursor1;
        QLog.e("SMRM", 2, "runC", localException);
        if (localCursor1 == null) {
          break;
        }
        localCursor1.close();
        break;
      }
      finally
      {
        if (localObject != null) {
          ((Cursor)localObject).close();
        }
      }
      SMRMH.a(1, Long.parseLong(paramQQAppInterface.c()), b(), localLinkedList);
      return;
      label697:
      m = j;
      j = i;
      int i = m;
      continue;
      label708:
      m = i;
      i = j;
      j = m;
      continue;
      label719:
      k += 1;
      if (i == -1)
      {
        i = j + 1;
        j = m;
      }
    }
  }
  
  private void d(QQAppInterface paramQQAppInterface)
  {
    LinkedList localLinkedList = new LinkedList();
    FriendsManager localFriendsManager = (FriendsManager)paramQQAppInterface.getManager(50);
    Iterator localIterator = localFriendsManager.c().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Entity)localIterator.next();
      if (localObject != null)
      {
        localObject = (Friends)localObject;
        if (localFriendsManager.a(((Friends)localObject).uin) != null)
        {
          loq localloq = new loq();
          localloq.jdField_a_of_type_Long = Long.parseLong(((Friends)localObject).uin);
          localLinkedList.add(localloq);
          if (a()) {
            QLog.d("SMRM", 2, localloq.toString());
          }
        }
      }
    }
    SMRMH.a(4, Long.parseLong(paramQQAppInterface.c()), b(), localLinkedList);
  }
  
  /* Error */
  private void e(QQAppInterface paramQQAppInterface)
  {
    // Byte code:
    //   0: new 226	java/util/LinkedList
    //   3: dup
    //   4: invokespecial 227	java/util/LinkedList:<init>	()V
    //   7: astore 15
    //   9: new 226	java/util/LinkedList
    //   12: dup
    //   13: invokespecial 227	java/util/LinkedList:<init>	()V
    //   16: astore 16
    //   18: aload_1
    //   19: invokevirtual 196	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   22: astore 17
    //   24: aload 17
    //   26: invokestatic 233	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   29: ifeq +4 -> 33
    //   32: return
    //   33: aload_1
    //   34: invokevirtual 236	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/proxy/ProxyManager;
    //   37: invokevirtual 241	com/tencent/mobileqq/app/proxy/ProxyManager:a	()Lcom/tencent/mobileqq/app/proxy/RecentUserProxy;
    //   40: astore 6
    //   42: aload 6
    //   44: ifnull -12 -> 32
    //   47: aload 6
    //   49: iconst_0
    //   50: invokevirtual 246	com/tencent/mobileqq/app/proxy/RecentUserProxy:a	(Z)Ljava/util/List;
    //   53: astore 6
    //   55: aload 6
    //   57: ifnull +13 -> 70
    //   60: aload 6
    //   62: invokeinterface 252 1 0
    //   67: ifgt +21 -> 88
    //   70: iconst_1
    //   71: aload_1
    //   72: invokevirtual 254	com/tencent/mobileqq/app/QQAppInterface:c	()Ljava/lang/String;
    //   75: invokestatic 258	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   78: aload_0
    //   79: invokespecial 260	com/tencent/biz/pubaccount/readinjoy/logic/SMRM:b	()J
    //   82: aload 15
    //   84: invokestatic 265	com/tencent/biz/pubaccount/readinjoy/logic/SMRMH:a	(IJJLjava/util/List;)V
    //   87: return
    //   88: aload_0
    //   89: aload_1
    //   90: invokespecial 357	com/tencent/biz/pubaccount/readinjoy/logic/SMRM:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Ljava/util/Map;
    //   93: astore 18
    //   95: aload_0
    //   96: aload_1
    //   97: invokespecial 359	com/tencent/biz/pubaccount/readinjoy/logic/SMRM:b	(Lcom/tencent/mobileqq/app/QQAppInterface;)Ljava/util/Map;
    //   100: astore 19
    //   102: aload_0
    //   103: getfield 17	com/tencent/biz/pubaccount/readinjoy/logic/SMRM:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   106: astore 20
    //   108: aload 6
    //   110: invokeinterface 266 1 0
    //   115: astore 21
    //   117: aload 21
    //   119: invokeinterface 58 1 0
    //   124: ifeq +1276 -> 1400
    //   127: aload 21
    //   129: invokeinterface 62 1 0
    //   134: checkcast 268	com/tencent/mobileqq/data/RecentUser
    //   137: astore 22
    //   139: aload 22
    //   141: ifnull -24 -> 117
    //   144: aload 22
    //   146: getfield 272	com/tencent/mobileqq/data/RecentUser:type	I
    //   149: iconst_1
    //   150: if_icmpeq +14 -> 164
    //   153: aload 22
    //   155: getfield 272	com/tencent/mobileqq/data/RecentUser:type	I
    //   158: sipush 3000
    //   161: if_icmpne -44 -> 117
    //   164: aload 22
    //   166: getfield 272	com/tencent/mobileqq/data/RecentUser:type	I
    //   169: iconst_1
    //   170: if_icmpne +131 -> 301
    //   173: ldc_w 361
    //   176: astore 11
    //   178: aload_0
    //   179: invokevirtual 77	com/tencent/biz/pubaccount/readinjoy/logic/SMRM:a	()Z
    //   182: ifeq +38 -> 220
    //   185: ldc 79
    //   187: iconst_2
    //   188: new 81	java/lang/StringBuilder
    //   191: dup
    //   192: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   195: ldc_w 363
    //   198: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: aload 11
    //   203: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: aload 22
    //   208: getfield 285	com/tencent/mobileqq/data/RecentUser:uin	Ljava/lang/String;
    //   211: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   217: invokestatic 101	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   220: aload 22
    //   222: getfield 272	com/tencent/mobileqq/data/RecentUser:type	I
    //   225: iconst_1
    //   226: if_icmpne +83 -> 309
    //   229: aload 18
    //   231: aload 22
    //   233: getfield 285	com/tencent/mobileqq/data/RecentUser:uin	Ljava/lang/String;
    //   236: invokeinterface 367 2 0
    //   241: checkcast 66	com/tencent/mobileqq/data/TroopInfo
    //   244: astore 6
    //   246: aload 6
    //   248: ifnull +135 -> 383
    //   251: aload 6
    //   253: getfield 370	com/tencent/mobileqq/data/TroopInfo:wMemberNum	I
    //   256: bipush 100
    //   258: if_icmple +125 -> 383
    //   261: aload_0
    //   262: invokevirtual 77	com/tencent/biz/pubaccount/readinjoy/logic/SMRM:a	()Z
    //   265: ifeq -148 -> 117
    //   268: ldc 79
    //   270: iconst_2
    //   271: new 81	java/lang/StringBuilder
    //   274: dup
    //   275: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   278: ldc_w 372
    //   281: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: aload 22
    //   286: getfield 285	com/tencent/mobileqq/data/RecentUser:uin	Ljava/lang/String;
    //   289: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   295: invokestatic 101	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   298: goto -181 -> 117
    //   301: ldc_w 374
    //   304: astore 11
    //   306: goto -128 -> 178
    //   309: aload 19
    //   311: aload 22
    //   313: getfield 285	com/tencent/mobileqq/data/RecentUser:uin	Ljava/lang/String;
    //   316: invokeinterface 367 2 0
    //   321: checkcast 171	java/lang/Long
    //   324: astore 6
    //   326: aload 6
    //   328: ifnull +55 -> 383
    //   331: aload 6
    //   333: invokevirtual 377	java/lang/Long:longValue	()J
    //   336: ldc2_w 378
    //   339: lcmp
    //   340: ifle +43 -> 383
    //   343: aload_0
    //   344: invokevirtual 77	com/tencent/biz/pubaccount/readinjoy/logic/SMRM:a	()Z
    //   347: ifeq -230 -> 117
    //   350: ldc 79
    //   352: iconst_2
    //   353: new 81	java/lang/StringBuilder
    //   356: dup
    //   357: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   360: ldc_w 381
    //   363: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   366: aload 22
    //   368: getfield 285	com/tencent/mobileqq/data/RecentUser:uin	Ljava/lang/String;
    //   371: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   374: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   377: invokestatic 101	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   380: goto -263 -> 117
    //   383: aload 22
    //   385: getfield 275	com/tencent/mobileqq/data/RecentUser:lastmsgtime	J
    //   388: aload_0
    //   389: invokespecial 260	com/tencent/biz/pubaccount/readinjoy/logic/SMRM:b	()J
    //   392: lcmp
    //   393: ifgt +70 -> 463
    //   396: aload_0
    //   397: invokevirtual 77	com/tencent/biz/pubaccount/readinjoy/logic/SMRM:a	()Z
    //   400: ifeq -283 -> 117
    //   403: ldc 79
    //   405: iconst_2
    //   406: new 81	java/lang/StringBuilder
    //   409: dup
    //   410: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   413: ldc_w 383
    //   416: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   419: aload 22
    //   421: getfield 275	com/tencent/mobileqq/data/RecentUser:lastmsgtime	J
    //   424: invokevirtual 280	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   427: ldc_w 282
    //   430: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   433: aload_0
    //   434: invokespecial 260	com/tencent/biz/pubaccount/readinjoy/logic/SMRM:b	()J
    //   437: invokevirtual 280	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   440: ldc_w 385
    //   443: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   446: aload 22
    //   448: getfield 285	com/tencent/mobileqq/data/RecentUser:uin	Ljava/lang/String;
    //   451: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   454: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   457: invokestatic 101	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   460: goto -343 -> 117
    //   463: aconst_null
    //   464: astore 13
    //   466: new 42	java/util/HashMap
    //   469: dup
    //   470: invokespecial 43	java/util/HashMap:<init>	()V
    //   473: astore 23
    //   475: aconst_null
    //   476: astore 6
    //   478: aload 22
    //   480: getfield 285	com/tencent/mobileqq/data/RecentUser:uin	Ljava/lang/String;
    //   483: aload 22
    //   485: getfield 272	com/tencent/mobileqq/data/RecentUser:type	I
    //   488: invokestatic 291	com/tencent/mobileqq/data/MessageRecord:getTableName	(Ljava/lang/String;I)Ljava/lang/String;
    //   491: astore 7
    //   493: aload_0
    //   494: invokespecial 260	com/tencent/biz/pubaccount/readinjoy/logic/SMRM:b	()J
    //   497: lstore 4
    //   499: aload 20
    //   501: aload 7
    //   503: iconst_1
    //   504: anewarray 293	java/lang/String
    //   507: dup
    //   508: iconst_0
    //   509: ldc_w 387
    //   512: aastore
    //   513: ldc_w 297
    //   516: iconst_1
    //   517: anewarray 293	java/lang/String
    //   520: dup
    //   521: iconst_0
    //   522: lload 4
    //   524: invokestatic 300	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   527: aastore
    //   528: aconst_null
    //   529: aconst_null
    //   530: ldc_w 302
    //   533: invokevirtual 306	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   536: astore 8
    //   538: aload 8
    //   540: ifnull +213 -> 753
    //   543: aload 8
    //   545: invokeinterface 311 1 0
    //   550: ifeq +203 -> 753
    //   553: aconst_null
    //   554: astore 14
    //   556: iconst_0
    //   557: istore_3
    //   558: aconst_null
    //   559: astore 12
    //   561: aload 8
    //   563: aload 8
    //   565: ldc_w 387
    //   568: invokeinterface 314 2 0
    //   573: invokeinterface 391 2 0
    //   578: invokestatic 396	com/tencent/mobileqq/utils/SecurityUtile:b	(Ljava/lang/String;)Ljava/lang/String;
    //   581: astore 7
    //   583: aload_0
    //   584: invokevirtual 77	com/tencent/biz/pubaccount/readinjoy/logic/SMRM:a	()Z
    //   587: ifeq +43 -> 630
    //   590: ldc 79
    //   592: iconst_2
    //   593: new 81	java/lang/StringBuilder
    //   596: dup
    //   597: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   600: aload 11
    //   602: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   605: aload 22
    //   607: getfield 285	com/tencent/mobileqq/data/RecentUser:uin	Ljava/lang/String;
    //   610: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   613: ldc_w 398
    //   616: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   619: aload 7
    //   621: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   624: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   627: invokestatic 101	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   630: iload_3
    //   631: ifne +424 -> 1055
    //   634: aload 14
    //   636: astore 6
    //   638: aload 13
    //   640: astore 9
    //   642: aload 12
    //   644: astore 10
    //   646: iload_3
    //   647: istore_2
    //   648: aload 17
    //   650: aload 7
    //   652: invokevirtual 401	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   655: ifeq +40 -> 695
    //   658: new 328	loq
    //   661: dup
    //   662: invokespecial 329	loq:<init>	()V
    //   665: astore 9
    //   667: aload 9
    //   669: aload 9
    //   671: getfield 331	loq:jdField_a_of_type_Int	I
    //   674: iconst_1
    //   675: iadd
    //   676: putfield 331	loq:jdField_a_of_type_Int	I
    //   679: aload 9
    //   681: iconst_1
    //   682: putfield 333	loq:jdField_b_of_type_Int	I
    //   685: iconst_1
    //   686: istore_2
    //   687: aload 7
    //   689: astore 6
    //   691: aload 12
    //   693: astore 10
    //   695: aload 6
    //   697: astore 14
    //   699: aload 9
    //   701: astore 13
    //   703: aload 10
    //   705: astore 12
    //   707: iload_2
    //   708: istore_3
    //   709: aload 8
    //   711: invokeinterface 326 1 0
    //   716: ifne -155 -> 561
    //   719: aload 9
    //   721: ifnull +32 -> 753
    //   724: aload 9
    //   726: getfield 333	loq:jdField_b_of_type_Int	I
    //   729: iconst_3
    //   730: if_icmplt +23 -> 753
    //   733: aload 23
    //   735: aload 10
    //   737: invokeinterface 367 2 0
    //   742: checkcast 248	java/util/List
    //   745: aload 9
    //   747: invokeinterface 339 2 0
    //   752: pop
    //   753: aload 23
    //   755: invokeinterface 405 1 0
    //   760: invokeinterface 408 1 0
    //   765: astore 6
    //   767: aload 6
    //   769: invokeinterface 58 1 0
    //   774: ifeq +611 -> 1385
    //   777: aload 6
    //   779: invokeinterface 62 1 0
    //   784: checkcast 410	java/util/Map$Entry
    //   787: astore 9
    //   789: aload 9
    //   791: invokeinterface 413 1 0
    //   796: checkcast 293	java/lang/String
    //   799: astore 7
    //   801: aload 9
    //   803: invokeinterface 416 1 0
    //   808: checkcast 248	java/util/List
    //   811: astore 10
    //   813: aload_0
    //   814: invokevirtual 77	com/tencent/biz/pubaccount/readinjoy/logic/SMRM:a	()Z
    //   817: ifeq +63 -> 880
    //   820: ldc 79
    //   822: iconst_2
    //   823: new 81	java/lang/StringBuilder
    //   826: dup
    //   827: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   830: ldc_w 418
    //   833: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   836: aload 11
    //   838: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   841: aload 22
    //   843: getfield 285	com/tencent/mobileqq/data/RecentUser:uin	Ljava/lang/String;
    //   846: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   849: ldc_w 398
    //   852: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   855: aload 7
    //   857: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   860: ldc_w 385
    //   863: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   866: aload 10
    //   868: invokevirtual 419	java/lang/Object:toString	()Ljava/lang/String;
    //   871: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   874: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   877: invokestatic 101	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   880: aload 10
    //   882: invokeinterface 252 1 0
    //   887: ifle -120 -> 767
    //   890: new 328	loq
    //   893: dup
    //   894: invokespecial 329	loq:<init>	()V
    //   897: astore 9
    //   899: aload 9
    //   901: aload 7
    //   903: invokestatic 258	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   906: putfield 335	loq:jdField_a_of_type_Long	J
    //   909: aload 9
    //   911: aload 22
    //   913: getfield 285	com/tencent/mobileqq/data/RecentUser:uin	Ljava/lang/String;
    //   916: invokestatic 258	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   919: putfield 420	loq:jdField_b_of_type_Long	J
    //   922: aload 10
    //   924: invokeinterface 266 1 0
    //   929: astore 10
    //   931: aload 10
    //   933: invokeinterface 58 1 0
    //   938: ifeq +333 -> 1271
    //   941: aload 10
    //   943: invokeinterface 62 1 0
    //   948: checkcast 328	loq
    //   951: astore 12
    //   953: aload 9
    //   955: aload 9
    //   957: getfield 331	loq:jdField_a_of_type_Int	I
    //   960: aload 12
    //   962: getfield 331	loq:jdField_a_of_type_Int	I
    //   965: iadd
    //   966: putfield 331	loq:jdField_a_of_type_Int	I
    //   969: aload 9
    //   971: aload 9
    //   973: getfield 333	loq:jdField_b_of_type_Int	I
    //   976: aload 12
    //   978: getfield 333	loq:jdField_b_of_type_Int	I
    //   981: iadd
    //   982: putfield 333	loq:jdField_b_of_type_Int	I
    //   985: aload 9
    //   987: aload 9
    //   989: getfield 422	loq:d	I
    //   992: iconst_1
    //   993: iadd
    //   994: putfield 422	loq:d	I
    //   997: aload 9
    //   999: getfield 424	loq:c	I
    //   1002: aload 12
    //   1004: getfield 333	loq:jdField_b_of_type_Int	I
    //   1007: if_icmpge -76 -> 931
    //   1010: aload 9
    //   1012: aload 12
    //   1014: getfield 333	loq:jdField_b_of_type_Int	I
    //   1017: putfield 424	loq:c	I
    //   1020: goto -89 -> 931
    //   1023: astore 7
    //   1025: aload 8
    //   1027: astore 6
    //   1029: ldc 79
    //   1031: iconst_2
    //   1032: ldc_w 426
    //   1035: aload 7
    //   1037: invokestatic 114	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1040: aload 6
    //   1042: ifnull -925 -> 117
    //   1045: aload 6
    //   1047: invokeinterface 341 1 0
    //   1052: goto -935 -> 117
    //   1055: aload 12
    //   1057: ifnonnull +97 -> 1154
    //   1060: aload 13
    //   1062: aload 13
    //   1064: getfield 331	loq:jdField_a_of_type_Int	I
    //   1067: iconst_1
    //   1068: iadd
    //   1069: putfield 331	loq:jdField_a_of_type_Int	I
    //   1072: aload 14
    //   1074: astore 6
    //   1076: aload 13
    //   1078: astore 9
    //   1080: aload 12
    //   1082: astore 10
    //   1084: iload_3
    //   1085: istore_2
    //   1086: aload 17
    //   1088: aload 7
    //   1090: invokevirtual 401	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1093: ifne -398 -> 695
    //   1096: aload 23
    //   1098: aload 7
    //   1100: invokeinterface 429 2 0
    //   1105: ifne +20 -> 1125
    //   1108: aload 23
    //   1110: aload 7
    //   1112: new 48	java/util/ArrayList
    //   1115: dup
    //   1116: invokespecial 430	java/util/ArrayList:<init>	()V
    //   1119: invokeinterface 75 3 0
    //   1124: pop
    //   1125: aload 13
    //   1127: aload 13
    //   1129: getfield 333	loq:jdField_b_of_type_Int	I
    //   1132: iconst_1
    //   1133: iadd
    //   1134: putfield 333	loq:jdField_b_of_type_Int	I
    //   1137: aload 7
    //   1139: astore 6
    //   1141: aload 13
    //   1143: astore 9
    //   1145: aload 7
    //   1147: astore 10
    //   1149: iload_3
    //   1150: istore_2
    //   1151: goto -456 -> 695
    //   1154: aload 17
    //   1156: aload 7
    //   1158: invokevirtual 401	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1161: ifne +45 -> 1206
    //   1164: aload 12
    //   1166: aload 7
    //   1168: invokevirtual 401	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1171: ifne +35 -> 1206
    //   1174: aload 13
    //   1176: getfield 333	loq:jdField_b_of_type_Int	I
    //   1179: iconst_3
    //   1180: if_icmplt +336 -> 1516
    //   1183: aload 23
    //   1185: aload 12
    //   1187: invokeinterface 367 2 0
    //   1192: checkcast 248	java/util/List
    //   1195: aload 13
    //   1197: invokeinterface 339 2 0
    //   1202: pop
    //   1203: goto +313 -> 1516
    //   1206: aload 13
    //   1208: aload 13
    //   1210: getfield 331	loq:jdField_a_of_type_Int	I
    //   1213: iconst_1
    //   1214: iadd
    //   1215: putfield 331	loq:jdField_a_of_type_Int	I
    //   1218: aload 14
    //   1220: astore 6
    //   1222: aload 13
    //   1224: astore 9
    //   1226: aload 12
    //   1228: astore 10
    //   1230: iload_3
    //   1231: istore_2
    //   1232: aload 14
    //   1234: aload 7
    //   1236: invokevirtual 401	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1239: ifne -544 -> 695
    //   1242: aload 13
    //   1244: aload 13
    //   1246: getfield 333	loq:jdField_b_of_type_Int	I
    //   1249: iconst_1
    //   1250: iadd
    //   1251: putfield 333	loq:jdField_b_of_type_Int	I
    //   1254: aload 7
    //   1256: astore 6
    //   1258: aload 13
    //   1260: astore 9
    //   1262: aload 12
    //   1264: astore 10
    //   1266: iload_3
    //   1267: istore_2
    //   1268: goto -573 -> 695
    //   1271: aload 22
    //   1273: getfield 272	com/tencent/mobileqq/data/RecentUser:type	I
    //   1276: iconst_1
    //   1277: if_icmpne +95 -> 1372
    //   1280: aload 15
    //   1282: aload 9
    //   1284: invokeinterface 339 2 0
    //   1289: pop
    //   1290: aload_0
    //   1291: invokevirtual 77	com/tencent/biz/pubaccount/readinjoy/logic/SMRM:a	()Z
    //   1294: ifeq -527 -> 767
    //   1297: ldc 79
    //   1299: iconst_2
    //   1300: new 81	java/lang/StringBuilder
    //   1303: dup
    //   1304: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   1307: ldc_w 418
    //   1310: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1313: aload 11
    //   1315: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1318: aload 22
    //   1320: getfield 285	com/tencent/mobileqq/data/RecentUser:uin	Ljava/lang/String;
    //   1323: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1326: ldc_w 398
    //   1329: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1332: aload 7
    //   1334: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1337: ldc_w 432
    //   1340: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1343: aload 9
    //   1345: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1348: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1351: invokestatic 101	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1354: goto -587 -> 767
    //   1357: astore_1
    //   1358: aload 8
    //   1360: ifnull +10 -> 1370
    //   1363: aload 8
    //   1365: invokeinterface 341 1 0
    //   1370: aload_1
    //   1371: athrow
    //   1372: aload 16
    //   1374: aload 9
    //   1376: invokeinterface 339 2 0
    //   1381: pop
    //   1382: goto -92 -> 1290
    //   1385: aload 8
    //   1387: ifnull -1270 -> 117
    //   1390: aload 8
    //   1392: invokeinterface 341 1 0
    //   1397: goto -1280 -> 117
    //   1400: aload_0
    //   1401: invokevirtual 77	com/tencent/biz/pubaccount/readinjoy/logic/SMRM:a	()Z
    //   1404: ifeq +57 -> 1461
    //   1407: ldc 79
    //   1409: iconst_2
    //   1410: new 81	java/lang/StringBuilder
    //   1413: dup
    //   1414: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   1417: ldc_w 434
    //   1420: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1423: aload 15
    //   1425: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1428: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1431: invokestatic 101	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1434: ldc 79
    //   1436: iconst_2
    //   1437: new 81	java/lang/StringBuilder
    //   1440: dup
    //   1441: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   1444: ldc_w 436
    //   1447: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1450: aload 16
    //   1452: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1455: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1458: invokestatic 101	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1461: iconst_2
    //   1462: aload_1
    //   1463: invokevirtual 254	com/tencent/mobileqq/app/QQAppInterface:c	()Ljava/lang/String;
    //   1466: invokestatic 258	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   1469: aload_0
    //   1470: invokespecial 260	com/tencent/biz/pubaccount/readinjoy/logic/SMRM:b	()J
    //   1473: aload 15
    //   1475: invokestatic 265	com/tencent/biz/pubaccount/readinjoy/logic/SMRMH:a	(IJJLjava/util/List;)V
    //   1478: iconst_3
    //   1479: aload_1
    //   1480: invokevirtual 254	com/tencent/mobileqq/app/QQAppInterface:c	()Ljava/lang/String;
    //   1483: invokestatic 258	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   1486: aload_0
    //   1487: invokespecial 260	com/tencent/biz/pubaccount/readinjoy/logic/SMRM:b	()J
    //   1490: aload 16
    //   1492: invokestatic 265	com/tencent/biz/pubaccount/readinjoy/logic/SMRMH:a	(IJJLjava/util/List;)V
    //   1495: return
    //   1496: astore_1
    //   1497: aconst_null
    //   1498: astore 8
    //   1500: goto -142 -> 1358
    //   1503: astore_1
    //   1504: aload 6
    //   1506: astore 8
    //   1508: goto -150 -> 1358
    //   1511: astore 7
    //   1513: goto -484 -> 1029
    //   1516: iconst_0
    //   1517: istore_2
    //   1518: aconst_null
    //   1519: astore 10
    //   1521: aconst_null
    //   1522: astore 6
    //   1524: aconst_null
    //   1525: astore 9
    //   1527: goto -832 -> 695
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1530	0	this	SMRM
    //   0	1530	1	paramQQAppInterface	QQAppInterface
    //   647	871	2	i	int
    //   557	710	3	j	int
    //   497	26	4	l	long
    //   40	1483	6	localObject1	Object
    //   491	411	7	str1	String
    //   1023	310	7	localException1	Exception
    //   1511	1	7	localException2	Exception
    //   536	971	8	localObject2	Object
    //   640	886	9	localObject3	Object
    //   644	876	10	localObject4	Object
    //   176	1138	11	str2	String
    //   559	704	12	localObject5	Object
    //   464	795	13	localObject6	Object
    //   554	679	14	localObject7	Object
    //   7	1467	15	localLinkedList1	LinkedList
    //   16	1475	16	localLinkedList2	LinkedList
    //   22	1133	17	str3	String
    //   93	137	18	localMap1	Map
    //   100	210	19	localMap2	Map
    //   106	394	20	localSQLiteDatabase	SQLiteDatabase
    //   115	13	21	localIterator	Iterator
    //   137	1182	22	localRecentUser	RecentUser
    //   473	711	23	localHashMap	HashMap
    // Exception table:
    //   from	to	target	type
    //   543	553	1023	java/lang/Exception
    //   561	630	1023	java/lang/Exception
    //   648	685	1023	java/lang/Exception
    //   709	719	1023	java/lang/Exception
    //   724	753	1023	java/lang/Exception
    //   753	767	1023	java/lang/Exception
    //   767	880	1023	java/lang/Exception
    //   880	931	1023	java/lang/Exception
    //   931	1020	1023	java/lang/Exception
    //   1060	1072	1023	java/lang/Exception
    //   1086	1125	1023	java/lang/Exception
    //   1125	1137	1023	java/lang/Exception
    //   1154	1203	1023	java/lang/Exception
    //   1206	1218	1023	java/lang/Exception
    //   1232	1254	1023	java/lang/Exception
    //   1271	1290	1023	java/lang/Exception
    //   1290	1354	1023	java/lang/Exception
    //   1372	1382	1023	java/lang/Exception
    //   543	553	1357	finally
    //   561	630	1357	finally
    //   648	685	1357	finally
    //   709	719	1357	finally
    //   724	753	1357	finally
    //   753	767	1357	finally
    //   767	880	1357	finally
    //   880	931	1357	finally
    //   931	1020	1357	finally
    //   1060	1072	1357	finally
    //   1086	1125	1357	finally
    //   1125	1137	1357	finally
    //   1154	1203	1357	finally
    //   1206	1218	1357	finally
    //   1232	1254	1357	finally
    //   1271	1290	1357	finally
    //   1290	1354	1357	finally
    //   1372	1382	1357	finally
    //   478	538	1496	finally
    //   1029	1040	1503	finally
    //   478	538	1511	java/lang/Exception
  }
  
  public long a()
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if (localObject == null) {}
    do
    {
      return 0L;
      localObject = ReadInJoyHelper.a((AppRuntime)localObject, true, true);
    } while (localObject == null);
    return ((SharedPreferences)localObject).getLong("readinjoy_smrm_last_u", 0L);
  }
  
  public void a(long paramLong)
  {
    if (a()) {
      QLog.d("SMRM", 2, "set ts:" + paramLong + " uiTestTs:" + this.jdField_a_of_type_Long);
    }
    if (this.jdField_a_of_type_Long != 0L)
    {
      this.jdField_b_of_type_Long = this.jdField_a_of_type_Long;
      return;
    }
    long l = paramLong;
    if (paramLong == 0L) {
      l = c() - 86400L;
    }
    this.jdField_b_of_type_Long = l;
  }
  
  /* Error */
  public void a(QQAppInterface paramQQAppInterface)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnonnull +12 -> 15
    //   6: ldc 79
    //   8: iconst_2
    //   9: ldc_w 451
    //   12: invokestatic 453	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   15: aload_0
    //   16: getfield 151	com/tencent/biz/pubaccount/readinjoy/logic/SMRM:jdField_a_of_type_Boolean	Z
    //   19: ifeq +34 -> 53
    //   22: aload_0
    //   23: invokevirtual 77	com/tencent/biz/pubaccount/readinjoy/logic/SMRM:a	()Z
    //   26: ifeq +12 -> 38
    //   29: ldc 79
    //   31: iconst_2
    //   32: ldc_w 455
    //   35: invokestatic 101	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   38: new 457	lop
    //   41: dup
    //   42: aload_0
    //   43: aload_1
    //   44: invokespecial 459	lop:<init>	(Lcom/tencent/biz/pubaccount/readinjoy/logic/SMRM;Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   47: invokestatic 465	com/tencent/mobileqq/app/ThreadManager:executeOnSubThread	(Ljava/lang/Runnable;)V
    //   50: aload_0
    //   51: monitorexit
    //   52: return
    //   53: aload_0
    //   54: iconst_1
    //   55: putfield 151	com/tencent/biz/pubaccount/readinjoy/logic/SMRM:jdField_a_of_type_Boolean	Z
    //   58: goto -20 -> 38
    //   61: astore_1
    //   62: aload_0
    //   63: monitorexit
    //   64: aload_1
    //   65: athrow
    //   66: astore_1
    //   67: aload_1
    //   68: invokevirtual 468	java/lang/Throwable:printStackTrace	()V
    //   71: goto -21 -> 50
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	SMRM
    //   0	74	1	paramQQAppInterface	QQAppInterface
    // Exception table:
    //   from	to	target	type
    //   6	15	61	finally
    //   15	38	61	finally
    //   38	50	61	finally
    //   53	58	61	finally
    //   67	71	61	finally
    //   38	50	66	java/lang/Throwable
  }
  
  public boolean a()
  {
    return AppSetting.j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.logic.SMRM
 * JD-Core Version:    0.7.0.1
 */