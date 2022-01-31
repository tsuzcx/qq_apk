package com.tencent.mobileqq.app.proxy.fts;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.TroopManager.TroopMemberUpdateObserver;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.data.fts.FTSTroop;
import com.tencent.mobileqq.data.fts.FTSTroopSync;
import com.tencent.mobileqq.data.fts.FTSTroopTime;
import com.tencent.mobileqq.data.fts.TroopIndex;
import com.tencent.mobileqq.fts.FTSDatabase;
import com.tencent.mobileqq.fts.FTSDatabaseHelper;
import com.tencent.mobileqq.fts.FTSQueryArgs.Builder;
import com.tencent.mobileqq.fts.FTSQueryArgs.MatchKey;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.fts.FTSDatatbase;
import com.tencent.mobileqq.persistence.fts.FTSOptSync;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;
import zvq;
import zvs;

public class FTSTroopOperator
  extends FTSIndexOperator
  implements TroopManager.TroopMemberUpdateObserver
{
  public static boolean c;
  private FriendsManager jdField_a_of_type_ComTencentMobileqqAppFriendsManager;
  private TroopManager jdField_a_of_type_ComTencentMobileqqAppTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private int b;
  private int c;
  protected boolean d;
  private boolean e;
  private boolean f;
  
  static
  {
    jdField_c_of_type_Boolean = true;
  }
  
  public FTSTroopOperator(QQAppInterface paramQQAppInterface, FTSSyncHandler paramFTSSyncHandler)
  {
    super(paramQQAppInterface, paramFTSSyncHandler);
    this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.a(this);
    this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50));
  }
  
  public static long a(QQAppInterface paramQQAppInterface, String paramString)
  {
    return paramQQAppInterface.getApplication().getSharedPreferences("fts_sp_file", 0).getLong("key_check_stamp" + paramQQAppInterface.getAccount() + "_" + paramString, 0L);
  }
  
  private FTSTroop a(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2)
  {
    paramString1 = new FTSTroop(paramInt1, paramString1, paramString2, paramString3, paramString4, paramString5);
    paramString1.preWrite();
    if (paramInt2 == 1) {
      paramString1.insertOpt();
    }
    do
    {
      return paramString1;
      if (paramInt2 == 16)
      {
        paramString1.deleteOpt();
        return paramString1;
      }
    } while (paramInt2 != 17);
    paramString1.upgradeOpt();
    return paramString1;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface.getApp().getSharedPreferences("fts_sp_file", 0).edit().remove("key_check_stamp" + paramQQAppInterface.getAccount() + "_" + paramString).commit();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, long paramLong)
  {
    paramQQAppInterface.getApp().getSharedPreferences("fts_sp_file", 0).edit().putLong("key_check_stamp" + paramQQAppInterface.getAccount() + "_" + paramString, paramLong).commit();
  }
  
  public int a()
  {
    return this.jdField_c_of_type_Int;
  }
  
  protected FTSOptSync a(int paramInt, long paramLong1, long paramLong2)
  {
    return new FTSTroopSync(paramInt, paramLong1, paramLong2);
  }
  
  protected String a()
  {
    return "TroopCursor";
  }
  
  public ArrayList a(String paramString, Class paramClass, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    return null;
  }
  
  protected List a(SQLiteDatabase paramSQLiteDatabase, EntityManager paramEntityManager)
  {
    if (this.jdField_a_of_type_Int > 0)
    {
      int i = paramSQLiteDatabase.a(FTSTroopSync.class.getSimpleName(), "_id<=?", new String[] { String.valueOf(this.jdField_a_of_type_Int) });
      if ((QLog.isColorLevel()) && (i > 0)) {
        QLog.d("Q.fts.troop.operator", 2, "delete " + FTSTroopSync.class.getSimpleName() + " row=" + i);
      }
    }
    return paramEntityManager.a(FTSTroopSync.class, FTSTroopSync.class.getSimpleName(), false, "_id>?", new String[] { String.valueOf(this.jdField_a_of_type_Int) }, null, null, null, "300");
  }
  
  public List a(String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqFtsFTSDatabase == null) || (!this.jdField_a_of_type_ComTencentMobileqqFtsFTSDatabase.d()) || (paramString == null) || (TextUtils.isEmpty(paramString))) {
      return null;
    }
    FTSQueryArgs.Builder localBuilder = new FTSQueryArgs.Builder().a(TroopIndex.class).a(new FTSQueryArgs.MatchKey[] { new FTSQueryArgs.MatchKey("TroopIndex", paramString, true) }).a(true);
    if (((SearchUtils.b(paramString)) || (SearchUtils.c(paramString))) && (!SearchUtils.d(paramString))) {
      localBuilder.a(200);
    }
    return this.jdField_a_of_type_ComTencentMobileqqFtsFTSDatabase.a(localBuilder.a());
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.b(this);
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.fts.troop.operator", 2, "onGetTroopMembersFailed troopUin:" + paramString);
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.b(paramString1);
    if (QLog.isColorLevel()) {
      QLog.d("Q.fts.troop.operator", 2, "onChangeTroopMember troopUin=" + paramString1 + " memberUin=" + paramString2);
    }
    if (((((TroopInfo)localObject).isNewTroop()) && (this.d)) || ((!((TroopInfo)localObject).isNewTroop()) && (!this.d)))
    {
      localObject = new ArrayList();
      ((ArrayList)localObject).add(a(3, Long.parseLong(paramString1), Long.parseLong(paramString2)));
      b((ArrayList)localObject);
    }
  }
  
  public void a(ArrayList paramArrayList)
  {
    if (paramArrayList == null) {
      return;
    }
    long l = System.currentTimeMillis();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramArrayList.size())
    {
      TroopInfo localTroopInfo = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.b((String)paramArrayList.get(i));
      if (((localTroopInfo.isNewTroop()) && (this.d)) || ((!localTroopInfo.isNewTroop()) && (!this.d)))
      {
        localArrayList.add(a(1, Long.parseLong((String)paramArrayList.get(i)), 0L));
        a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)paramArrayList.get(i), l);
        if (QLog.isColorLevel()) {
          QLog.d("Q.fts.troop.operator", 2, "onTroopMembersUpdate troopuin = " + (String)paramArrayList.get(i));
        }
      }
      i += 1;
    }
    b(localArrayList);
  }
  
  public boolean a(FTSDatatbase paramFTSDatatbase, FTSDatabase paramFTSDatabase)
  {
    super.a(paramFTSDatatbase, paramFTSDatabase);
    if (!this.jdField_a_of_type_ComTencentMobileqqFtsFTSDatabase.a(TroopIndex.class)) {
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppProxyFtsFTSUpgrader = new FTSTroopUpgrader(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
    this.e = true;
    if (QLog.isColorLevel()) {
      QLog.d("Q.fts.troop.operator", 2, "init success");
    }
    this.jdField_c_of_type_Int = FTSDatabaseHelper.b(this.jdField_a_of_type_ComTencentMobileqqFtsFTSDatabase, "TroopIndex");
    return true;
  }
  
  /* Error */
  public boolean a(ArrayList paramArrayList)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 29	com/tencent/mobileqq/app/proxy/fts/FTSTroopOperator:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4: invokevirtual 335	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   7: invokevirtual 341	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   10: astore 5
    //   12: aconst_null
    //   13: astore_3
    //   14: aconst_null
    //   15: astore_2
    //   16: aload 5
    //   18: invokevirtual 344	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   21: astore 4
    //   23: aload 4
    //   25: astore_2
    //   26: aload 4
    //   28: astore_3
    //   29: aload 4
    //   31: invokevirtual 348	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   34: aload 4
    //   36: astore_2
    //   37: aload 4
    //   39: astore_3
    //   40: aload_1
    //   41: invokevirtual 352	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   44: astore_1
    //   45: aload 4
    //   47: astore_2
    //   48: aload 4
    //   50: astore_3
    //   51: aload_1
    //   52: invokeinterface 357 1 0
    //   57: ifeq +76 -> 133
    //   60: aload 4
    //   62: astore_2
    //   63: aload 4
    //   65: astore_3
    //   66: aload 5
    //   68: aload_1
    //   69: invokeinterface 361 1 0
    //   74: checkcast 363	com/tencent/mobileqq/persistence/fts/FTSOptSync
    //   77: invokevirtual 366	com/tencent/mobileqq/persistence/EntityManager:b	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   80: goto -35 -> 45
    //   83: astore_1
    //   84: aload_2
    //   85: astore_3
    //   86: invokestatic 178	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   89: ifeq +34 -> 123
    //   92: aload_2
    //   93: astore_3
    //   94: ldc 180
    //   96: iconst_2
    //   97: new 64	java/lang/StringBuilder
    //   100: dup
    //   101: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   104: ldc_w 368
    //   107: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: aload_1
    //   111: invokevirtual 371	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   114: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: invokestatic 374	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   123: aload_2
    //   124: ifnull +7 -> 131
    //   127: aload_2
    //   128: invokevirtual 376	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   131: iconst_0
    //   132: ireturn
    //   133: aload 4
    //   135: astore_2
    //   136: aload 4
    //   138: astore_3
    //   139: aload 4
    //   141: invokevirtual 378	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   144: aload 4
    //   146: ifnull +8 -> 154
    //   149: aload 4
    //   151: invokevirtual 376	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   154: iconst_1
    //   155: ireturn
    //   156: astore_1
    //   157: aload_3
    //   158: ifnull +7 -> 165
    //   161: aload_3
    //   162: invokevirtual 376	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   165: aload_1
    //   166: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	167	0	this	FTSTroopOperator
    //   0	167	1	paramArrayList	ArrayList
    //   15	121	2	localObject1	Object
    //   13	149	3	localObject2	Object
    //   21	129	4	localEntityTransaction	com.tencent.mobileqq.persistence.EntityTransaction
    //   10	57	5	localEntityManager	EntityManager
    // Exception table:
    //   from	to	target	type
    //   16	23	83	java/lang/Exception
    //   29	34	83	java/lang/Exception
    //   40	45	83	java/lang/Exception
    //   51	60	83	java/lang/Exception
    //   66	80	83	java/lang/Exception
    //   139	144	83	java/lang/Exception
    //   16	23	156	finally
    //   29	34	156	finally
    //   40	45	156	finally
    //   51	60	156	finally
    //   66	80	156	finally
    //   86	92	156	finally
    //   94	123	156	finally
    //   139	144	156	finally
  }
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.b(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("Q.fts.troop.operator", 2, "onQuitTroop troopUin=" + paramString);
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(a(4, Long.parseLong(paramString), 0L));
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString);
    b(localArrayList);
  }
  
  public void b(String paramString1, String paramString2)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.b(paramString1);
    if (QLog.isColorLevel()) {
      QLog.d("Q.fts.troop.operator", 2, "onKickoutTroopMember troopUin=" + paramString1 + " memberUin=" + paramString2);
    }
    if (((((TroopInfo)localObject).isNewTroop()) && (this.d)) || ((!((TroopInfo)localObject).isNewTroop()) && (!this.d)))
    {
      localObject = new ArrayList();
      ((ArrayList)localObject).add(a(2, Long.parseLong(paramString1), Long.parseLong(paramString2)));
      b((ArrayList)localObject);
    }
  }
  
  public void b(ArrayList paramArrayList)
  {
    if (paramArrayList == null) {
      return;
    }
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() == localLooper.getThread())
    {
      ThreadManager.post(new zvs(this, paramArrayList), 8, null, true);
      return;
    }
    a(paramArrayList);
  }
  
  public boolean c()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      label113:
      do
      {
        for (;;)
        {
          try
          {
            bool1 = FTSDatabaseHelper.a(this.jdField_a_of_type_ComTencentMobileqqFtsFTSDatabase, a());
            bool2 = bool1;
            bool2 = bool1;
          }
          catch (Throwable localThrowable1)
          {
            try
            {
              if (QLog.isColorLevel())
              {
                QLog.d("Q.fts.troop.operator", 2, "FTSDatabaseHelper.isTableExist = " + bool1);
                bool2 = bool1;
              }
              if (bool2) {
                break;
              }
              bool1 = FTSDatabaseHelper.b(this.jdField_a_of_type_ComTencentMobileqqFtsFTSDatabase, a());
              if (QLog.isColorLevel()) {
                QLog.d("Q.fts.troop.operator", 2, "FTSDatabaseHelper.createCursorTable = " + bool1);
              }
              if (bool1) {
                break;
              }
              return false;
            }
            catch (Throwable localThrowable2)
            {
              boolean bool1;
              boolean bool2;
              int i;
              break label113;
            }
            localThrowable1 = localThrowable1;
            bool1 = false;
          }
          if (QLog.isColorLevel())
          {
            QLog.e("Q.fts.troop.operator", 2, "isCursorTableExist: failure ", localThrowable1);
            bool2 = bool1;
          }
        }
        i = FTSDatabaseHelper.a(this.jdField_a_of_type_ComTencentMobileqqFtsFTSDatabase, a());
        if (QLog.isColorLevel()) {
          QLog.d("Q.fts.troop.operator", 2, "FTSDatabaseHelper.queryCursorTable = " + i);
        }
      } while (i == -1);
      this.jdField_a_of_type_Int = i;
      this.jdField_a_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        QLog.d("Q.fts.troop.operator", 2, "readSyncedCursor: syncCursor = " + i);
      }
    }
    return true;
  }
  
  public void e()
  {
    System.currentTimeMillis();
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    localObject1 = a((SQLiteDatabase)localObject1, localEntityManager);
    Object localObject2;
    int i;
    Iterator localIterator;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder().append("transToDatabase list.size=");
      if (localObject1 != null)
      {
        i = ((List)localObject1).size();
        QLog.d("Q.fts.troop.operator", 2, i);
      }
    }
    else
    {
      if (localObject1 == null) {
        break label710;
      }
      localIterator = ((List)localObject1).iterator();
      i = 0;
    }
    label1169:
    for (;;)
    {
      long l1;
      FTSTroopSync localFTSTroopSync;
      ArrayList localArrayList;
      Object localObject3;
      if (localIterator.hasNext())
      {
        localObject1 = (FTSOptSync)localIterator.next();
        l1 = System.currentTimeMillis();
        localFTSTroopSync = (FTSTroopSync)localObject1;
        if (TroopInfo.isQidianPrivateTroop(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(localFTSTroopSync.mTroopUin)))
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("Q.fts.troop.operator", 2, "transToDatabase, ignore troopSync , it's a QidianPrivateTroop, troopSync = " + localFTSTroopSync.toString());
          continue;
          i = 0;
          break;
        }
        localArrayList = new ArrayList();
        if (localFTSTroopSync.mOpt != 3) {
          break label787;
        }
        localArrayList.add(a(2, String.valueOf(localFTSTroopSync.mTroopUin), String.valueOf(localFTSTroopSync.mMemberUin), "", "", "", 16));
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.b(String.valueOf(localFTSTroopSync.mTroopUin), String.valueOf(localFTSTroopSync.mMemberUin));
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a(String.valueOf(localFTSTroopSync.mMemberUin));
        if (localObject2 == null) {
          break label716;
        }
        localObject1 = ((Friends)localObject2).remark;
        if (localObject3 == null) {
          break label734;
        }
        if (localObject2 == null) {
          break label724;
        }
        localObject2 = ((Friends)localObject2).name;
        label322:
        localArrayList.add(a(2, ((TroopMemberInfo)localObject3).troopuin, ((TroopMemberInfo)localObject3).memberuin, (String)localObject2, ((TroopMemberInfo)localObject3).troopnick, (String)localObject1, 1));
      }
      label787:
      label1044:
      label1052:
      label1062:
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.fts.troop.operator", 2, "transToDatabase start troopUin:" + localFTSTroopSync.mTroopUin + " entityList size:" + localArrayList.size() + " opt:" + localFTSTroopSync.mOpt);
        }
        int j = FTSDatabaseHelper.a(this.jdField_a_of_type_ComTencentMobileqqFtsFTSDatabase, localArrayList, a(), 1);
        if (j != -1) {
          this.jdField_a_of_type_Int = j;
        }
        this.jdField_c_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase.b("TroopIndex");
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.b(String.valueOf(localFTSTroopSync.mTroopUin));
        Object localObject4;
        if (localObject3 != null)
        {
          localObject4 = localEntityManager.a(FTSTroopTime.class, FTSTroopTime.class.getSimpleName(), false, "mTroopUin=? ", new String[] { String.valueOf(localFTSTroopSync.mTroopUin) }, null, null, null, null);
          localObject2 = new FTSTroopTime();
          localObject1 = localObject2;
          if (localObject4 != null)
          {
            localObject1 = localObject2;
            if (((List)localObject4).size() > 0) {
              localObject1 = (FTSTroopTime)((List)localObject4).get(0);
            }
          }
          ((FTSTroopTime)localObject1).mTroopUin = String.valueOf(localFTSTroopSync.mTroopUin);
          ((FTSTroopTime)localObject1).mTimeStamp = ((TroopInfo)localObject3).mMemberNumSeq;
          localEntityManager.b((Entity)localObject1);
          if (QLog.isColorLevel()) {
            QLog.d("Q.fts.troop.operator", 2, "FTSTroopTime  " + ((FTSTroopTime)localObject1).toString());
          }
        }
        long l2 = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d("Q.fts.troop.operator", 2, "transToDatabase end troopUin=" + localFTSTroopSync.mTroopUin + " totalTime=" + (l2 - l1));
        }
        i = localArrayList.size() + i;
        if ((i <= 300) && (d())) {
          break label1169;
        }
        if (i > 300) {}
        label710:
        localEntityManager.a();
        return;
        label716:
        localObject1 = "";
        break;
        label724:
        localObject2 = ((TroopMemberInfo)localObject3).friendnick;
        break label322;
        label734:
        if (QLog.isColorLevel())
        {
          QLog.d("Q.fts.troop.operator", 2, "transToDatabase modify member can't find memberuin:" + localFTSTroopSync.mMemberUin + " troopuin:" + localFTSTroopSync.mTroopUin);
          continue;
          if (localFTSTroopSync.mOpt == 4)
          {
            localArrayList.add(a(2, String.valueOf(localFTSTroopSync.mTroopUin), "", "", "", "", 16));
          }
          else if ((localFTSTroopSync.mOpt == 1) || (localFTSTroopSync.mOpt == 5))
          {
            for (;;)
            {
              try
              {
                localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.b(String.valueOf(localFTSTroopSync.mTroopUin));
                if (localObject1 == null) {
                  break label1062;
                }
                localArrayList.add(a(2, String.valueOf(localFTSTroopSync.mTroopUin), "", "", "", "", 16));
                localObject3 = ((List)localObject1).iterator();
                if (!((Iterator)localObject3).hasNext()) {
                  break;
                }
                localObject4 = (TroopMemberInfo)((Iterator)localObject3).next();
                if (!Utils.d(((TroopMemberInfo)localObject4).memberuin)) {
                  continue;
                }
                localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a(String.valueOf(((TroopMemberInfo)localObject4).memberuin));
                if (localObject2 == null) {
                  break label1044;
                }
                localObject1 = ((Friends)localObject2).remark;
                if (localObject2 == null) {
                  break label1052;
                }
                localObject2 = ((Friends)localObject2).name;
                localArrayList.add(a(2, ((TroopMemberInfo)localObject4).troopuin, ((TroopMemberInfo)localObject4).memberuin, (String)localObject2, ((TroopMemberInfo)localObject4).troopnick, (String)localObject1, 1));
                continue;
                if (!QLog.isColorLevel()) {
                  break;
                }
              }
              catch (Throwable localThrowable) {}
              QLog.e("Q.fts.troop.operator", 2, "transToDatabase failure: ", localThrowable);
              break;
              String str = "";
              continue;
              localObject2 = ((TroopMemberInfo)localObject4).friendnick;
            }
            if (QLog.isColorLevel()) {
              QLog.d("Q.fts.troop.operator", 2, "transToDatabase memberList is null");
            }
          }
          else if (localFTSTroopSync.mOpt == 2)
          {
            localArrayList.add(a(2, String.valueOf(localFTSTroopSync.mTroopUin), String.valueOf(localFTSTroopSync.mMemberUin), "", "", "", 16));
          }
          else if (QLog.isColorLevel())
          {
            QLog.d("Q.fts.troop.operator", 2, "transToDatabase unknown opt:" + localFTSTroopSync.toString());
          }
        }
      }
    }
  }
  
  public boolean e()
  {
    return this.f;
  }
  
  public void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppProxyFtsFTSSyncHandler.post(new zvq(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.proxy.fts.FTSTroopOperator
 * JD-Core Version:    0.7.0.1
 */