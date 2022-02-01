package com.tencent.mobileqq.app.proxy.fts;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.fts.FTSTroop;
import com.tencent.mobileqq.data.fts.FTSTroopSync;
import com.tencent.mobileqq.data.fts.FTSTroopTime;
import com.tencent.mobileqq.data.fts.TroopIndex;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.fts.FTSDatabase;
import com.tencent.mobileqq.fts.FTSDatabaseHelper;
import com.tencent.mobileqq.fts.FTSQueryArgs.Builder;
import com.tencent.mobileqq.fts.FTSQueryArgs.MatchKey;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.persistence.fts.FTSDatatbase;
import com.tencent.mobileqq.persistence.fts.FTSOptSync;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageCache.RegPrxyCache;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.troop.api.ITroopMemberInfoService;
import com.tencent.mobileqq.troop.api.ITroopMemberInfoService.TroopMemberUpdateObserver;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;

public class FTSTroopOperator
  extends FTSIndexOperator
  implements ITroopMemberInfoService.TroopMemberUpdateObserver
{
  public static boolean d;
  private FriendsManager jdField_a_of_type_ComTencentMobileqqAppFriendsManager;
  private TroopManager jdField_a_of_type_ComTencentMobileqqAppTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
  private Runnable jdField_a_of_type_JavaLangRunnable = null;
  private int d;
  private int e;
  protected boolean e;
  private boolean f = false;
  private boolean g = false;
  
  static
  {
    jdField_d_of_type_Boolean = true;
  }
  
  public FTSTroopOperator(QQAppInterface paramQQAppInterface, FTSSyncHandler paramFTSSyncHandler)
  {
    super(paramQQAppInterface, paramFTSSyncHandler);
    this.jdField_d_of_type_Int = 0;
    this.jdField_e_of_type_Int = 0;
    this.jdField_e_of_type_Boolean = false;
    paramQQAppInterface = (ITroopMemberInfoService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITroopMemberInfoService.class, "");
    if (paramQQAppInterface != null) {
      paramQQAppInterface.addTroopMemberUpdateObserver(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER));
  }
  
  private int a(ArrayList<com.tencent.mobileqq.persistence.fts.FTSEntity> paramArrayList)
  {
    paramArrayList = paramArrayList.iterator();
    for (int i = 0; paramArrayList.hasNext(); i = ((com.tencent.mobileqq.persistence.fts.FTSEntity)paramArrayList.next()).mSegmentCount + i) {}
    return i;
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
  
  private void a(int paramInt, long paramLong1, long paramLong2)
  {
    if (paramInt > 300) {}
  }
  
  private void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3)
  {
    long l;
    if ((QLog.isColorLevel()) || (paramLong1 > 60000L))
    {
      l = this.jdField_e_of_type_Int;
      if (this.jdField_e_of_type_Int == 0) {
        break label239;
      }
    }
    Object localObject;
    for (;;)
    {
      localObject = new StringBuilder(100);
      ((StringBuilder)localObject).append(getClass().getSimpleName()).append(" count:").append(paramLong2).append(" cost:").append(paramLong1).append(" indexCnt:").append(this.jdField_e_of_type_Int).append(" preIndexCnt:").append(l).append(" segmentTotal:").append(paramInt1);
      l = b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if ((paramLong1 <= 30000L) || (System.currentTimeMillis() - l <= 86400000L)) {
        break;
      }
      QLog.e("Q.fts.BgCpu", 1, ((StringBuilder)localObject).toString());
      localObject = new HashMap();
      ((HashMap)localObject).put("param_count", String.valueOf(paramLong2));
      ((HashMap)localObject).put("param_del", String.valueOf(paramInt2));
      ((HashMap)localObject).put("param_insert", String.valueOf(paramInt3));
      ((HashMap)localObject).put("param_stotal", String.valueOf(paramInt1));
      StatisticCollector.getInstance(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()).collectPerformance(null, "actFTSTroopCost", true, paramLong1, 0L, (HashMap)localObject, null, false);
      b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, System.currentTimeMillis());
      return;
      label239:
      this.jdField_e_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase.b("TroopIndex");
    }
    QLog.d("Q.fts.BgCpu", 1, ((StringBuilder)localObject).toString());
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface.getApp().getSharedPreferences("fts_sp_file", 0).edit().remove("key_check_stamp" + paramQQAppInterface.getAccount() + "_" + paramString).commit();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, long paramLong)
  {
    paramQQAppInterface.getApp().getSharedPreferences("fts_sp_file", 0).edit().putLong("key_check_stamp" + paramQQAppInterface.getAccount() + "_" + paramString, paramLong).commit();
  }
  
  private void a(FTSTroopSync paramFTSTroopSync)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.fts.troop.operator", 2, "transToDatabase unknown opt:" + paramFTSTroopSync.toString());
    }
  }
  
  private void a(EntityManager paramEntityManager, FTSTroopSync paramFTSTroopSync)
  {
    TroopInfo localTroopInfo = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.c(String.valueOf(paramFTSTroopSync.mTroopUin));
    if (localTroopInfo != null)
    {
      List localList = paramEntityManager.query(FTSTroopTime.class, FTSTroopTime.class.getSimpleName(), false, "mTroopUin=? ", new String[] { String.valueOf(paramFTSTroopSync.mTroopUin) }, null, null, null, null);
      FTSTroopTime localFTSTroopTime2 = new FTSTroopTime();
      FTSTroopTime localFTSTroopTime1 = localFTSTroopTime2;
      if (localList != null)
      {
        localFTSTroopTime1 = localFTSTroopTime2;
        if (localList.size() > 0) {
          localFTSTroopTime1 = (FTSTroopTime)localList.get(0);
        }
      }
      localFTSTroopTime1.mTroopUin = String.valueOf(paramFTSTroopSync.mTroopUin);
      localFTSTroopTime1.mTimeStamp = localTroopInfo.mMemberNumSeq;
      paramEntityManager.persistOrReplace(localFTSTroopTime1);
      if (QLog.isColorLevel()) {
        QLog.d("Q.fts.troop.operator", 2, "FTSTroopTime  " + localFTSTroopTime1.toString());
      }
    }
  }
  
  private void a(ArrayList<FTSOptSync> paramArrayList, List<FTSTroopTime> paramList, HashMap<String, TroopInfo> paramHashMap)
  {
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        FTSTroopTime localFTSTroopTime = (FTSTroopTime)paramList.next();
        String str = localFTSTroopTime.mTroopUin;
        if (paramHashMap.containsKey(str))
        {
          TroopInfo localTroopInfo = (TroopInfo)paramHashMap.get(str);
          if ((localTroopInfo.wMemberNum == 0) || (localTroopInfo.mMemberNumSeq == 0L))
          {
            Utils.a("Q.fts.troop.operator", new Object[] { "checkTroopTimeStamp troop ignore troopuin:" + str + " wMemberNum:" + localTroopInfo.wMemberNum + " mMemberNumSeq:" + localTroopInfo.mMemberNumSeq });
            paramHashMap.remove(str);
          }
          else
          {
            if (localFTSTroopTime.mTimeStamp < localTroopInfo.mMemberNumSeq) {}
            try
            {
              paramArrayList.add(new FTSTroopSync(5, Long.parseLong(localTroopInfo.troopuin)));
              Utils.a("Q.fts.troop.operator", new Object[] { "checkTroopTimeStamp add troop:" + localTroopInfo.troopname + " mMemberNumSeq:" + localTroopInfo.mMemberNumSeq + " troopTime:" + localFTSTroopTime.toString() });
              paramHashMap.remove(str);
            }
            catch (Exception localException2)
            {
              for (;;)
              {
                if (QLog.isColorLevel()) {
                  QLog.e("Q.fts.troop.operator", 2, "checkTroopTimeStamp e:" + localException2.toString());
                }
              }
            }
          }
        }
        else
        {
          try
          {
            paramArrayList.add(new FTSTroopSync(4, Long.parseLong(str)));
            Utils.a("Q.fts.troop.operator", new Object[] { "checkTroopTimeStamp delete troop=" + str });
          }
          catch (Exception localException1) {}
          if (QLog.isColorLevel()) {
            QLog.e("Q.fts.troop.operator", 2, "checkTroopTimeStamp e:" + localException1.toString());
          }
        }
      }
    }
  }
  
  private void a(List<Entity> paramList, List<FTSTroopTime> paramList1)
  {
    if (paramList != null)
    {
      HashMap localHashMap = new HashMap();
      paramList = paramList.iterator();
      Object localObject;
      while (paramList.hasNext())
      {
        localObject = (TroopInfo)paramList.next();
        localHashMap.put(((TroopInfo)localObject).troopuin, localObject);
      }
      paramList = new ArrayList();
      a(paramList, paramList1, localHashMap);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache();
      if (MessageCache.a != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache();
        if (MessageCache.a.a != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache();
          if (MessageCache.a.a.size() > 0)
          {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache();
            paramList1 = MessageCache.a.a.entrySet().iterator();
            if (paramList1.hasNext())
            {
              localObject = (Map.Entry)paramList1.next();
              String str1 = (String)((Map.Entry)localObject).getKey();
              i = 0;
              while (i < ((ArrayList)((Map.Entry)localObject).getValue()).size()) {
                try
                {
                  String str2 = (String)((ArrayList)((Map.Entry)localObject).getValue()).get(i);
                  paramList.add(new FTSTroopSync(3, Long.parseLong(str1), Long.parseLong(str2)));
                  Utils.a("Q.fts.troop.operator", new Object[] { "checkTroopMemberCache modify troop=" + str1 + " member=" + str2 });
                  i += 1;
                }
                catch (Exception localException2)
                {
                  for (;;)
                  {
                    if (QLog.isColorLevel()) {
                      QLog.e("Q.fts.troop.operator", 2, "checkTroopMemberCache e:" + localException2.toString());
                    }
                  }
                }
              }
            }
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache();
            MessageCache.a.a.clear();
          }
        }
      }
      int i = FTSDatabaseHelper.b(this.jdField_a_of_type_ComTencentMobileqqFtsFTSDatabase, "TroopIndex");
      Utils.a("Q.fts.troop.operator", new Object[] { "FTSDatabaseHelper.queryItemCount = " + i });
      if (i > 0)
      {
        paramList1 = localHashMap.entrySet().iterator();
        i = 0;
        while (paramList1.hasNext()) {
          try
          {
            paramList.add(new FTSTroopSync(5, Long.parseLong((String)((Map.Entry)paramList1.next()).getKey())));
          }
          catch (Exception localException1)
          {
            i += 1;
          }
        }
        if ((QLog.isColorLevel()) && (i > 0)) {
          QLog.e("Q.fts.troop.operator", 2, "checkTroopTimeStamp add syncData fail " + i);
        }
      }
      b(paramList);
      if (QLog.isColorLevel()) {
        QLog.d("Q.fts.troop.operator", 2, "checkTroopTimeStamp optList.size:" + paramList.size());
      }
    }
  }
  
  private long b(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApplication().getSharedPreferences("fts_sp_file", 0).getLong("key_last_troop_time_" + paramQQAppInterface.getAccount(), 0L);
  }
  
  private void b(QQAppInterface paramQQAppInterface, long paramLong)
  {
    paramQQAppInterface.getApp().getSharedPreferences("fts_sp_file", 0).edit().putLong("key_last_troop_time_" + paramQQAppInterface.getAccount(), paramLong).commit();
  }
  
  public int a()
  {
    return a(false);
  }
  
  public int a(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.jdField_e_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase.b("TroopIndex");
    }
    return this.jdField_e_of_type_Int;
  }
  
  protected FTSOptSync a(int paramInt, long paramLong1, long paramLong2)
  {
    return new FTSTroopSync(paramInt, paramLong1, paramLong2);
  }
  
  public ArrayList<com.tencent.mobileqq.persistence.fts.FTSEntity> a(String paramString, Class<? extends com.tencent.mobileqq.persistence.fts.FTSEntity> paramClass, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    return null;
  }
  
  protected List<FTSOptSync> a(SQLiteDatabase paramSQLiteDatabase, EntityManager paramEntityManager)
  {
    try
    {
      if (this.jdField_a_of_type_Int > 0)
      {
        int i = paramSQLiteDatabase.delete(FTSTroopSync.class.getSimpleName(), "_id<=?", new String[] { String.valueOf(this.jdField_a_of_type_Int) });
        if ((QLog.isColorLevel()) && (i > 0)) {
          QLog.d("Q.fts.troop.operator", 2, "delete " + FTSTroopSync.class.getSimpleName() + " row=" + i);
        }
      }
      paramSQLiteDatabase = paramEntityManager.query(FTSTroopSync.class, FTSTroopSync.class.getSimpleName(), false, "_id>?", new String[] { String.valueOf(this.jdField_a_of_type_Int) }, null, null, null, "300");
      return paramSQLiteDatabase;
    }
    catch (Throwable paramSQLiteDatabase)
    {
      QLog.e("Q.fts.troop.operator", 1, paramSQLiteDatabase, new Object[0]);
      paramSQLiteDatabase = new HashMap();
      paramSQLiteDatabase.put("type", "1");
      StatisticCollector.getInstance(BaseApplicationImpl.getApplication().getApplicationContext()).collectPerformance(null, "actGetOptFailed", true, 0L, 0L, paramSQLiteDatabase, null);
    }
    return null;
  }
  
  public List<com.tencent.mobileqq.fts.entity.FTSEntity> a(String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqFtsFTSDatabase == null) || (!this.jdField_a_of_type_ComTencentMobileqqFtsFTSDatabase.d()) || (paramString == null) || (TextUtils.isEmpty(paramString))) {
      return null;
    }
    FTSQueryArgs.Builder localBuilder = new FTSQueryArgs.Builder().a(TroopIndex.class).a(new FTSQueryArgs.MatchKey[] { new FTSQueryArgs.MatchKey("TroopIndex", paramString, true) }).a(true);
    if (((SearchUtils.a(paramString)) || (SearchUtils.b(paramString))) && (!SearchUtils.c(paramString))) {
      localBuilder.a(200);
    }
    return this.jdField_a_of_type_ComTencentMobileqqFtsFTSDatabase.a(localBuilder.a());
  }
  
  public void a()
  {
    ITroopMemberInfoService localITroopMemberInfoService = (ITroopMemberInfoService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITroopMemberInfoService.class, "");
    if (localITroopMemberInfoService != null) {
      localITroopMemberInfoService.removeTroopMemberUpdateObserver(this);
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.c(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("Q.fts.troop.operator", 2, "onQuitTroop troopUin=" + paramString);
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(a(4, Long.parseLong(paramString), 0L));
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString);
    b(localArrayList);
  }
  
  public void a(String paramString1, String paramString2)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.c(paramString1);
    if (QLog.isColorLevel()) {
      QLog.d("Q.fts.troop.operator", 2, "onChangeTroopMember troopUin=" + paramString1 + " memberUin=" + paramString2);
    }
    if (((((TroopInfo)localObject).isNewTroop()) && (this.jdField_e_of_type_Boolean)) || ((!((TroopInfo)localObject).isNewTroop()) && (!this.jdField_e_of_type_Boolean)))
    {
      localObject = new ArrayList();
      ((ArrayList)localObject).add(a(3, Long.parseLong(paramString1), Long.parseLong(paramString2)));
      b((ArrayList)localObject);
    }
  }
  
  public void a(ArrayList<String> paramArrayList)
  {
    if (paramArrayList == null) {
      return;
    }
    long l = System.currentTimeMillis();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramArrayList.size())
    {
      TroopInfo localTroopInfo = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.c((String)paramArrayList.get(i));
      if (((localTroopInfo.isNewTroop()) && (this.jdField_e_of_type_Boolean)) || ((!localTroopInfo.isNewTroop()) && (!this.jdField_e_of_type_Boolean)))
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
    this.f = true;
    if (QLog.isColorLevel()) {
      QLog.d("Q.fts.troop.operator", 2, "init success");
    }
    this.jdField_e_of_type_Int = FTSDatabaseHelper.b(this.jdField_a_of_type_ComTencentMobileqqFtsFTSDatabase, "TroopIndex");
    return true;
  }
  
  /* Error */
  protected boolean a(ArrayList<FTSOptSync> paramArrayList)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 40	com/tencent/mobileqq/app/proxy/fts/FTSTroopOperator:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4: invokevirtual 622	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy;
    //   7: invokevirtual 628	com/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   10: astore 5
    //   12: aconst_null
    //   13: astore_3
    //   14: aconst_null
    //   15: astore_2
    //   16: aload 5
    //   18: invokevirtual 632	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   21: astore 4
    //   23: aload 4
    //   25: astore_2
    //   26: aload 4
    //   28: astore_3
    //   29: aload 4
    //   31: invokevirtual 637	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   34: aload 4
    //   36: astore_2
    //   37: aload 4
    //   39: astore_3
    //   40: aload_1
    //   41: invokevirtual 82	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   44: astore_1
    //   45: aload 4
    //   47: astore_2
    //   48: aload 4
    //   50: astore_3
    //   51: aload_1
    //   52: invokeinterface 88 1 0
    //   57: ifeq +77 -> 134
    //   60: aload 4
    //   62: astore_2
    //   63: aload 4
    //   65: astore_3
    //   66: aload 5
    //   68: aload_1
    //   69: invokeinterface 92 1 0
    //   74: checkcast 639	com/tencent/mobileqq/persistence/fts/FTSOptSync
    //   77: invokevirtual 350	com/tencent/mobileqq/persistence/EntityManager:persistOrReplace	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   80: goto -35 -> 45
    //   83: astore_1
    //   84: aload_2
    //   85: astore_3
    //   86: invokestatic 165	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   89: ifeq +35 -> 124
    //   92: aload_2
    //   93: astore_3
    //   94: ldc_w 300
    //   97: iconst_2
    //   98: new 114	java/lang/StringBuilder
    //   101: dup
    //   102: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   105: ldc_w 641
    //   108: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: aload_1
    //   112: invokevirtual 644	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   115: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   121: invokestatic 647	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   124: aload_2
    //   125: ifnull +7 -> 132
    //   128: aload_2
    //   129: invokevirtual 650	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   132: iconst_0
    //   133: ireturn
    //   134: aload 4
    //   136: astore_2
    //   137: aload 4
    //   139: astore_3
    //   140: aload 4
    //   142: invokevirtual 652	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   145: aload 4
    //   147: ifnull +8 -> 155
    //   150: aload 4
    //   152: invokevirtual 650	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   155: iconst_1
    //   156: ireturn
    //   157: astore_1
    //   158: aload_3
    //   159: ifnull +7 -> 166
    //   162: aload_3
    //   163: invokevirtual 650	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   166: aload_1
    //   167: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	168	0	this	FTSTroopOperator
    //   0	168	1	paramArrayList	ArrayList<FTSOptSync>
    //   15	122	2	localObject1	Object
    //   13	150	3	localObject2	Object
    //   21	130	4	localEntityTransaction	com.tencent.mobileqq.persistence.EntityTransaction
    //   10	57	5	localEntityManager	EntityManager
    // Exception table:
    //   from	to	target	type
    //   16	23	83	java/lang/Exception
    //   29	34	83	java/lang/Exception
    //   40	45	83	java/lang/Exception
    //   51	60	83	java/lang/Exception
    //   66	80	83	java/lang/Exception
    //   140	145	83	java/lang/Exception
    //   16	23	157	finally
    //   29	34	157	finally
    //   40	45	157	finally
    //   51	60	157	finally
    //   66	80	157	finally
    //   86	92	157	finally
    //   94	124	157	finally
    //   140	145	157	finally
  }
  
  public String b()
  {
    return "TroopIndex";
  }
  
  public List<com.tencent.mobileqq.fts.entity.FTSEntity> b(String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqFtsFTSDatabase == null) || (!this.jdField_a_of_type_ComTencentMobileqqFtsFTSDatabase.d()) || (paramString == null) || (TextUtils.isEmpty(paramString))) {
      return null;
    }
    paramString = new FTSQueryArgs.Builder().a(TroopIndex.class).a(new FTSQueryArgs.MatchKey[] { new FTSQueryArgs.MatchKey("ext1", paramString, true) }).a(true);
    return this.jdField_a_of_type_ComTencentMobileqqFtsFTSDatabase.a(paramString.a());
  }
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.fts.troop.operator", 2, "onGetTroopMembersFailed troopUin:" + paramString);
    }
  }
  
  public void b(String paramString1, String paramString2)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.c(paramString1);
    if (QLog.isColorLevel()) {
      QLog.d("Q.fts.troop.operator", 2, "onKickoutTroopMember troopUin=" + paramString1 + " memberUin=" + paramString2);
    }
    if (((((TroopInfo)localObject).isNewTroop()) && (this.jdField_e_of_type_Boolean)) || ((!((TroopInfo)localObject).isNewTroop()) && (!this.jdField_e_of_type_Boolean)))
    {
      localObject = new ArrayList();
      ((ArrayList)localObject).add(a(2, Long.parseLong(paramString1), Long.parseLong(paramString2)));
      b((ArrayList)localObject);
    }
  }
  
  protected void b(ArrayList<FTSOptSync> paramArrayList)
  {
    if (paramArrayList == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppProxyFtsFTSSyncHandler.post(new FTSTroopOperator.2(this, paramArrayList));
  }
  
  protected String c()
  {
    return "TroopCursor";
  }
  
  public boolean c()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      label115:
      do
      {
        for (;;)
        {
          try
          {
            bool1 = FTSDatabaseHelper.a(this.jdField_a_of_type_ComTencentMobileqqFtsFTSDatabase, c());
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
              bool1 = FTSDatabaseHelper.b(this.jdField_a_of_type_ComTencentMobileqqFtsFTSDatabase, c());
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
              break label115;
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
        i = FTSDatabaseHelper.a(this.jdField_a_of_type_ComTencentMobileqqFtsFTSDatabase, c());
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
    long l1;
    Object localObject1;
    EntityManager localEntityManager;
    Object localObject2;
    int i;
    int m;
    int j;
    int k;
    long l2;
    FTSTroopSync localFTSTroopSync;
    ArrayList localArrayList;
    if ((this.jdField_a_of_type_ComTencentMobileqqFtsFTSDatabase != null) && (this.jdField_a_of_type_ComTencentMobileqqFtsFTSDatabase.d()))
    {
      l1 = System.currentTimeMillis();
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getWritableDatabase();
      localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
      localObject1 = a((SQLiteDatabase)localObject1, localEntityManager);
      localObject2 = new StringBuilder().append("transToDatabase list.size=");
      if (localObject1 != null) {}
      for (i = ((List)localObject1).size();; i = 0)
      {
        Utils.a("Q.fts.troop.operator", new Object[] { i });
        if (localObject1 == null) {
          break label634;
        }
        Iterator localIterator = ((List)localObject1).iterator();
        m = 0;
        i = 0;
        j = 0;
        k = 0;
        for (;;)
        {
          if (!localIterator.hasNext()) {
            break label1149;
          }
          localObject1 = (FTSOptSync)localIterator.next();
          l2 = System.currentTimeMillis();
          localFTSTroopSync = (FTSTroopSync)localObject1;
          if (!((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).n(String.valueOf(localFTSTroopSync.mTroopUin))) {
            break;
          }
          Utils.a("Q.fts.troop.operator", new Object[] { "transToDatabase, ignore troopSync , it's a QidianPrivateTroop, troopSync = " + localFTSTroopSync.toString() });
        }
      }
      localArrayList = new ArrayList();
      if (localFTSTroopSync.mOpt != 3) {
        break label711;
      }
      localArrayList.add(a(2, String.valueOf(localFTSTroopSync.mTroopUin), String.valueOf(localFTSTroopSync.mMemberUin), "", "", "", 16));
      localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.b(String.valueOf(localFTSTroopSync.mTroopUin), String.valueOf(localFTSTroopSync.mMemberUin));
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.b(String.valueOf(localFTSTroopSync.mMemberUin));
      if (localObject2 == null) {
        break label640;
      }
      localObject1 = ((Friends)localObject2).remark;
      if (localObject3 == null) {
        break label657;
      }
      if (localObject2 == null) {
        break label647;
      }
      localObject2 = ((Friends)localObject2).name;
      label356:
      localArrayList.add(a(2, ((TroopMemberInfo)localObject3).troopuin, ((TroopMemberInfo)localObject3).memberuin, (String)localObject2, ((TroopMemberInfo)localObject3).troopnick, (String)localObject1, 1));
      i += 1;
      label391:
      j += 1;
    }
    for (;;)
    {
      for (;;)
      {
        label395:
        Utils.a("Q.fts.troop.operator", new Object[] { "transToDatabase start troopUin:" + localFTSTroopSync.mTroopUin + " entityList size:" + localArrayList.size() + " opt:" + localFTSTroopSync.mOpt });
        n = FTSDatabaseHelper.a(this.jdField_a_of_type_ComTencentMobileqqFtsFTSDatabase, localArrayList, c(), 1);
        if (n != -1) {
          this.jdField_a_of_type_Int = n;
        }
        a(localEntityManager, localFTSTroopSync);
        n = a(localArrayList);
        m += n;
        long l3 = System.currentTimeMillis();
        Utils.a("Q.fts.troop.operator", new Object[] { "transToDatabase end troopUin=%s totalTime=%s curSegmentTotal:%s", String.valueOf(localFTSTroopSync.mTroopUin), String.valueOf(l3 - l2), String.valueOf(n) });
        k += localArrayList.size();
        if ((k <= 300) && (d())) {
          break label1143;
        }
        a(k, l3, l1);
        label593:
        l1 = System.currentTimeMillis() - l1;
        this.c += k;
        this.jdField_a_of_type_Long += l1;
        a(l1, k, m, j, i);
        label634:
        localEntityManager.close();
        return;
        label640:
        localObject1 = "";
        break;
        label647:
        localObject2 = ((TroopMemberInfo)localObject3).friendnick;
        break label356;
        label657:
        Utils.a("Q.fts.troop.operator", new Object[] { "transToDatabase modify member can't find memberuin:" + localFTSTroopSync.mMemberUin + " troopuin:" + localFTSTroopSync.mTroopUin });
        break label391;
        label711:
        if (localFTSTroopSync.mOpt == 4)
        {
          localArrayList.add(a(2, String.valueOf(localFTSTroopSync.mTroopUin), "", "", "", "", 16));
          j += 1;
        }
        else
        {
          if ((localFTSTroopSync.mOpt != 1) && (localFTSTroopSync.mOpt != 5)) {
            break label1083;
          }
          i1 = i;
          n = j;
          try
          {
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.b(String.valueOf(localFTSTroopSync.mTroopUin));
            if (localObject1 != null) {
              break label856;
            }
            i1 = i;
            n = j;
            Utils.a("Q.fts.troop.operator", new Object[] { "transToDatabase memberList is null" });
          }
          catch (Throwable localThrowable)
          {
            if (QLog.isColorLevel()) {
              QLog.e("Q.fts.troop.operator", 2, "transToDatabase failure: ", localThrowable);
            }
            i = i1;
            j = n;
          }
        }
      }
    }
    label856:
    int i1 = i;
    int n = j;
    localArrayList.add(a(2, String.valueOf(localFTSTroopSync.mTroopUin), "", "", "", "", 16));
    j += 1;
    i1 = i;
    n = j;
    Object localObject3 = localThrowable.iterator();
    label910:
    i1 = i;
    n = j;
    TroopMemberInfo localTroopMemberInfo;
    if (((Iterator)localObject3).hasNext())
    {
      i1 = i;
      n = j;
      localTroopMemberInfo = (TroopMemberInfo)((Iterator)localObject3).next();
      i1 = i;
      n = j;
      if (!Utils.d(localTroopMemberInfo.memberuin)) {
        break label1146;
      }
      i1 = i;
      n = j;
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.b(String.valueOf(localTroopMemberInfo.memberuin));
      if (localObject2 == null) {
        break label1155;
      }
      i1 = i;
      n = j;
    }
    label1152:
    label1155:
    for (String str = ((Friends)localObject2).remark;; str = "")
    {
      if (localObject2 != null)
      {
        i1 = i;
        n = j;
      }
      for (localObject2 = ((Friends)localObject2).name;; localObject2 = localTroopMemberInfo.friendnick)
      {
        i1 = i;
        n = j;
        localArrayList.add(a(2, localTroopMemberInfo.troopuin, localTroopMemberInfo.memberuin, (String)localObject2, localTroopMemberInfo.troopnick, str, 1));
        i += 1;
        break;
        i1 = i;
        n = j;
      }
      break label395;
      label1083:
      if (localFTSTroopSync.mOpt == 2)
      {
        localArrayList.add(a(2, String.valueOf(localFTSTroopSync.mTroopUin), String.valueOf(localFTSTroopSync.mMemberUin), "", "", "", 16));
        j += 1;
        break label395;
      }
      a(localFTSTroopSync);
      break label395;
      label1143:
      break;
      label1146:
      break label1152;
      label1149:
      break label593;
      break label910;
    }
  }
  
  protected boolean e()
  {
    return true;
  }
  
  public boolean f()
  {
    return this.g;
  }
  
  public void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppProxyFtsFTSSyncHandler.post(new FTSTroopOperator.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.proxy.fts.FTSTroopOperator
 * JD-Core Version:    0.7.0.1
 */