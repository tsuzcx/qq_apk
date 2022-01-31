import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.proxy.fts.FTSTroopOperator.1;
import com.tencent.mobileqq.app.proxy.fts.FTSTroopOperator.2;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.data.fts.FTSTroop;
import com.tencent.mobileqq.data.fts.FTSTroopSync;
import com.tencent.mobileqq.data.fts.FTSTroopTime;
import com.tencent.mobileqq.data.fts.TroopIndex;
import com.tencent.mobileqq.fts.FTSDatabase;
import com.tencent.mobileqq.persistence.fts.FTSDatatbase;
import com.tencent.mobileqq.persistence.fts.FTSOptSync;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;

public class amog
  extends amob
  implements ameo
{
  public static boolean c;
  private alto jdField_a_of_type_Alto;
  private TroopManager jdField_a_of_type_ComTencentMobileqqAppTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private int d;
  protected boolean d;
  private int jdField_e_of_type_Int;
  private boolean jdField_e_of_type_Boolean;
  private boolean f;
  
  static
  {
    jdField_c_of_type_Boolean = true;
  }
  
  public amog(QQAppInterface paramQQAppInterface, amof paramamof)
  {
    super(paramQQAppInterface, paramamof);
    this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.a(this);
    this.jdField_a_of_type_Alto = ((alto)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51));
  }
  
  private long a(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApplication().getSharedPreferences("fts_sp_file", 0).getLong("key_last_troop_time_" + paramQQAppInterface.getAccount(), 0L);
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
  
  private void a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    paramQQAppInterface.getApp().getSharedPreferences("fts_sp_file", 0).edit().putLong("key_last_troop_time_" + paramQQAppInterface.getAccount(), paramLong).commit();
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
    int i = 0;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    List localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager().a(FTSTroopSync.class, FTSTroopSync.class.getSimpleName(), false, "_id>?", new String[] { String.valueOf(this.jdField_a_of_type_Int) }, null, null, null, null);
    if (localList != null) {
      i = localList.size();
    }
    return i;
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
  
  protected List<FTSOptSync> a(SQLiteDatabase paramSQLiteDatabase, awgf paramawgf)
  {
    try
    {
      if (this.jdField_a_of_type_Int > 0)
      {
        int i = paramSQLiteDatabase.a(FTSTroopSync.class.getSimpleName(), "_id<=?", new String[] { String.valueOf(this.jdField_a_of_type_Int) });
        if ((QLog.isColorLevel()) && (i > 0)) {
          QLog.d("Q.fts.troop.operator", 2, "delete " + FTSTroopSync.class.getSimpleName() + " row=" + i);
        }
      }
      paramSQLiteDatabase = paramawgf.a(FTSTroopSync.class, FTSTroopSync.class.getSimpleName(), false, "_id>?", new String[] { String.valueOf(this.jdField_a_of_type_Int) }, null, null, null, "300");
      return paramSQLiteDatabase;
    }
    catch (Throwable paramSQLiteDatabase)
    {
      QLog.e("Q.fts.troop.operator", 1, paramSQLiteDatabase, new Object[0]);
      paramSQLiteDatabase = new HashMap();
      paramSQLiteDatabase.put("type", "1");
      azri.a(BaseApplicationImpl.getApplication().getApplicationContext()).a(null, "actGetOptFailed", true, 0L, 0L, paramSQLiteDatabase, null);
    }
    return null;
  }
  
  public List<com.tencent.mobileqq.fts.entity.FTSEntity> a(String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqFtsFTSDatabase == null) || (!this.jdField_a_of_type_ComTencentMobileqqFtsFTSDatabase.d()) || (paramString == null) || (TextUtils.isEmpty(paramString))) {
      return null;
    }
    asiw localasiw = new asiw().a(TroopIndex.class).a(new asix[] { new asix("TroopIndex", paramString, true) }).a(true);
    if (((ayvm.a(paramString)) || (ayvm.b(paramString))) && (!ayvm.c(paramString))) {
      localasiw.a(200);
    }
    return this.jdField_a_of_type_ComTencentMobileqqFtsFTSDatabase.a(localasiw.a());
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
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.c(paramString1);
    if (QLog.isColorLevel()) {
      QLog.d("Q.fts.troop.operator", 2, "onChangeTroopMember troopUin=" + paramString1 + " memberUin=" + paramString2);
    }
    if (((((TroopInfo)localObject).isNewTroop()) && (this.jdField_d_of_type_Boolean)) || ((!((TroopInfo)localObject).isNewTroop()) && (!this.jdField_d_of_type_Boolean)))
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
      if (((localTroopInfo.isNewTroop()) && (this.jdField_d_of_type_Boolean)) || ((!localTroopInfo.isNewTroop()) && (!this.jdField_d_of_type_Boolean)))
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
    this.jdField_a_of_type_Amoi = new amoh(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
    this.jdField_e_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.d("Q.fts.troop.operator", 2, "init success");
    }
    this.jdField_e_of_type_Int = asiu.b(this.jdField_a_of_type_ComTencentMobileqqFtsFTSDatabase, "TroopIndex");
    return true;
  }
  
  /* Error */
  public boolean a(ArrayList<FTSOptSync> paramArrayList)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 28	amog:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4: invokevirtual 152	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lawgg;
    //   7: invokevirtual 158	awgg:createEntityManager	()Lawgf;
    //   10: astore 5
    //   12: aconst_null
    //   13: astore_3
    //   14: aconst_null
    //   15: astore_2
    //   16: aload 5
    //   18: invokevirtual 403	awgf:a	()Lawgh;
    //   21: astore 4
    //   23: aload 4
    //   25: astore_2
    //   26: aload 4
    //   28: astore_3
    //   29: aload 4
    //   31: invokevirtual 407	awgh:a	()V
    //   34: aload 4
    //   36: astore_2
    //   37: aload 4
    //   39: astore_3
    //   40: aload_1
    //   41: invokevirtual 411	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   44: astore_1
    //   45: aload 4
    //   47: astore_2
    //   48: aload 4
    //   50: astore_3
    //   51: aload_1
    //   52: invokeinterface 416 1 0
    //   57: ifeq +76 -> 133
    //   60: aload 4
    //   62: astore_2
    //   63: aload 4
    //   65: astore_3
    //   66: aload 5
    //   68: aload_1
    //   69: invokeinterface 420 1 0
    //   74: checkcast 422	com/tencent/mobileqq/persistence/fts/FTSOptSync
    //   77: invokevirtual 425	awgf:b	(Lawge;)V
    //   80: goto -35 -> 45
    //   83: astore_1
    //   84: aload_2
    //   85: astore_3
    //   86: invokestatic 220	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   89: ifeq +34 -> 123
    //   92: aload_2
    //   93: astore_3
    //   94: ldc 222
    //   96: iconst_2
    //   97: new 63	java/lang/StringBuilder
    //   100: dup
    //   101: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   104: ldc_w 427
    //   107: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: aload_1
    //   111: invokevirtual 430	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   114: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: invokestatic 433	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   123: aload_2
    //   124: ifnull +7 -> 131
    //   127: aload_2
    //   128: invokevirtual 435	awgh:b	()V
    //   131: iconst_0
    //   132: ireturn
    //   133: aload 4
    //   135: astore_2
    //   136: aload 4
    //   138: astore_3
    //   139: aload 4
    //   141: invokevirtual 437	awgh:c	()V
    //   144: aload 4
    //   146: ifnull +8 -> 154
    //   149: aload 4
    //   151: invokevirtual 435	awgh:b	()V
    //   154: iconst_1
    //   155: ireturn
    //   156: astore_1
    //   157: aload_3
    //   158: ifnull +7 -> 165
    //   161: aload_3
    //   162: invokevirtual 435	awgh:b	()V
    //   165: aload_1
    //   166: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	167	0	this	amog
    //   0	167	1	paramArrayList	ArrayList<FTSOptSync>
    //   15	121	2	localObject1	Object
    //   13	149	3	localObject2	Object
    //   21	129	4	localawgh	awgh
    //   10	57	5	localawgf	awgf
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
  
  public int b()
  {
    return a(false);
  }
  
  protected String b()
  {
    return "TroopCursor";
  }
  
  public List<com.tencent.mobileqq.fts.entity.FTSEntity> b(String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqFtsFTSDatabase == null) || (!this.jdField_a_of_type_ComTencentMobileqqFtsFTSDatabase.d()) || (paramString == null) || (TextUtils.isEmpty(paramString))) {
      return null;
    }
    paramString = new asiw().a(TroopIndex.class).a(new asix[] { new asix("ext1", paramString, true) }).a(true);
    return this.jdField_a_of_type_ComTencentMobileqqFtsFTSDatabase.a(paramString.a());
  }
  
  public void b(String paramString)
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
  
  public void b(String paramString1, String paramString2)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.c(paramString1);
    if (QLog.isColorLevel()) {
      QLog.d("Q.fts.troop.operator", 2, "onKickoutTroopMember troopUin=" + paramString1 + " memberUin=" + paramString2);
    }
    if (((((TroopInfo)localObject).isNewTroop()) && (this.jdField_d_of_type_Boolean)) || ((!((TroopInfo)localObject).isNewTroop()) && (!this.jdField_d_of_type_Boolean)))
    {
      localObject = new ArrayList();
      ((ArrayList)localObject).add(a(2, Long.parseLong(paramString1), Long.parseLong(paramString2)));
      b((ArrayList)localObject);
    }
  }
  
  public void b(ArrayList<FTSOptSync> paramArrayList)
  {
    if (paramArrayList == null) {
      return;
    }
    this.jdField_a_of_type_Amof.post(new FTSTroopOperator.2(this, paramArrayList));
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
            bool1 = asiu.a(this.jdField_a_of_type_ComTencentMobileqqFtsFTSDatabase, b());
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
              bool1 = asiu.b(this.jdField_a_of_type_ComTencentMobileqqFtsFTSDatabase, b());
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
        i = asiu.a(this.jdField_a_of_type_ComTencentMobileqqFtsFTSDatabase, b());
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
    awgf localawgf;
    Object localObject3;
    int i;
    int m;
    int j;
    int k;
    long l2;
    FTSTroopSync localFTSTroopSync;
    label216:
    ArrayList localArrayList;
    Object localObject4;
    label348:
    int n;
    label384:
    label391:
    Object localObject5;
    label704:
    label714:
    int i3;
    label822:
    int i1;
    if ((this.jdField_a_of_type_ComTencentMobileqqFtsFTSDatabase != null) && (this.jdField_a_of_type_ComTencentMobileqqFtsFTSDatabase.d()))
    {
      l1 = System.currentTimeMillis();
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      localawgf = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
      localObject1 = a((SQLiteDatabase)localObject1, localawgf);
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder().append("transToDatabase list.size=");
        if (localObject1 == null) {
          break label216;
        }
      }
      for (i = ((List)localObject1).size();; i = 0)
      {
        QLog.d("Q.fts.troop.operator", 2, i);
        if (localObject1 == null) {
          break label1650;
        }
        Iterator localIterator = ((List)localObject1).iterator();
        m = 0;
        i = 0;
        j = 0;
        k = 0;
        for (;;)
        {
          if (!localIterator.hasNext()) {
            break label1693;
          }
          localObject1 = (FTSOptSync)localIterator.next();
          l2 = System.currentTimeMillis();
          localFTSTroopSync = (FTSTroopSync)localObject1;
          if (!TroopInfo.isQidianPrivateTroop(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(localFTSTroopSync.mTroopUin))) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.fts.troop.operator", 2, "transToDatabase, ignore troopSync , it's a QidianPrivateTroop, troopSync = " + localFTSTroopSync.toString());
          }
        }
      }
      localArrayList = new ArrayList();
      if (localFTSTroopSync.mOpt == 3)
      {
        localArrayList.add(a(2, String.valueOf(localFTSTroopSync.mTroopUin), String.valueOf(localFTSTroopSync.mMemberUin), "", "", "", 16));
        localObject4 = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.b(String.valueOf(localFTSTroopSync.mTroopUin), String.valueOf(localFTSTroopSync.mMemberUin));
        localObject3 = this.jdField_a_of_type_Alto.b(String.valueOf(localFTSTroopSync.mMemberUin));
        if (localObject3 != null)
        {
          localObject1 = ((Friends)localObject3).remark;
          if (localObject4 == null) {
            break label714;
          }
          if (localObject3 == null) {
            break label704;
          }
          localObject3 = ((Friends)localObject3).name;
          localArrayList.add(a(2, ((TroopMemberInfo)localObject4).troopuin, ((TroopMemberInfo)localObject4).memberuin, (String)localObject3, ((TroopMemberInfo)localObject4).troopnick, (String)localObject1, 1));
          n = i + 1;
          i = n;
          j += 1;
        }
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.fts.troop.operator", 2, "transToDatabase start troopUin:" + localFTSTroopSync.mTroopUin + " entityList size:" + localArrayList.size() + " opt:" + localFTSTroopSync.mOpt);
        }
        n = asiu.a(this.jdField_a_of_type_ComTencentMobileqqFtsFTSDatabase, localArrayList, b(), 1);
        if (n != -1) {
          this.jdField_a_of_type_Int = n;
        }
        localObject4 = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.c(String.valueOf(localFTSTroopSync.mTroopUin));
        if (localObject4 != null)
        {
          localObject5 = localawgf.a(FTSTroopTime.class, FTSTroopTime.class.getSimpleName(), false, "mTroopUin=? ", new String[] { String.valueOf(localFTSTroopSync.mTroopUin) }, null, null, null, null);
          localObject3 = new FTSTroopTime();
          localObject1 = localObject3;
          if (localObject5 != null)
          {
            localObject1 = localObject3;
            if (((List)localObject5).size() > 0) {
              localObject1 = (FTSTroopTime)((List)localObject5).get(0);
            }
          }
          ((FTSTroopTime)localObject1).mTroopUin = String.valueOf(localFTSTroopSync.mTroopUin);
          ((FTSTroopTime)localObject1).mTimeStamp = ((TroopInfo)localObject4).mMemberNumSeq;
          localawgf.b((awge)localObject1);
          if (QLog.isColorLevel()) {
            QLog.d("Q.fts.troop.operator", 2, "FTSTroopTime  " + ((FTSTroopTime)localObject1).toString());
          }
        }
        localObject1 = localArrayList.iterator();
        for (n = 0; ((Iterator)localObject1).hasNext(); n = ((com.tencent.mobileqq.persistence.fts.FTSEntity)((Iterator)localObject1).next()).mSegmentCount + n) {}
        localObject1 = "";
        break;
        localObject3 = ((TroopMemberInfo)localObject4).friendnick;
        break label348;
        n = i;
        if (!QLog.isColorLevel()) {
          break label384;
        }
        QLog.d("Q.fts.troop.operator", 2, "transToDatabase modify member can't find memberuin:" + localFTSTroopSync.mMemberUin + " troopuin:" + localFTSTroopSync.mTroopUin);
        n = i;
        break label384;
        if (localFTSTroopSync.mOpt != 4) {
          break label822;
        }
        localArrayList.add(a(2, String.valueOf(localFTSTroopSync.mTroopUin), "", "", "", "", 16));
        j += 1;
      }
      if ((localFTSTroopSync.mOpt == 1) || (localFTSTroopSync.mOpt == 5))
      {
        i3 = i;
        i1 = j;
      }
    }
    for (;;)
    {
      try
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.b(String.valueOf(localFTSTroopSync.mTroopUin));
        int i2;
        if (localObject1 != null)
        {
          i3 = i;
          i1 = j;
          localArrayList.add(a(2, String.valueOf(localFTSTroopSync.mTroopUin), "", "", "", "", 16));
          j += 1;
          i3 = i;
          i1 = j;
          localObject4 = ((List)localObject1).iterator();
          i2 = i;
          n = j;
          i3 = i;
          i1 = j;
          if (((Iterator)localObject4).hasNext())
          {
            i3 = i;
            i1 = j;
            localObject5 = (TroopMemberInfo)((Iterator)localObject4).next();
            i3 = i;
            i1 = j;
            if (!bdeu.d(((TroopMemberInfo)localObject5).memberuin)) {
              break label1690;
            }
            i3 = i;
            i1 = j;
            localObject3 = this.jdField_a_of_type_Alto.b(String.valueOf(((TroopMemberInfo)localObject5).memberuin));
            if (localObject3 == null) {
              break label1702;
            }
            i3 = i;
            i1 = j;
            localObject1 = ((Friends)localObject3).remark;
            if (localObject3 != null)
            {
              i3 = i;
              i1 = j;
              localObject3 = ((Friends)localObject3).name;
              i3 = i;
              i1 = j;
              localArrayList.add(a(2, ((TroopMemberInfo)localObject5).troopuin, ((TroopMemberInfo)localObject5).memberuin, (String)localObject3, ((TroopMemberInfo)localObject5).troopnick, (String)localObject1, 1));
              i += 1;
              break label1699;
            }
            i3 = i;
            i1 = j;
            localObject3 = ((TroopMemberInfo)localObject5).friendnick;
            continue;
          }
        }
        else
        {
          i2 = i;
          n = j;
          i3 = i;
          i1 = j;
          if (QLog.isColorLevel())
          {
            i3 = i;
            i1 = j;
            QLog.d("Q.fts.troop.operator", 2, "transToDatabase memberList is null");
            n = j;
            i2 = i;
          }
        }
        i = i2;
        j = n;
      }
      catch (Throwable localThrowable)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.fts.troop.operator", 2, "transToDatabase failure: ", localThrowable);
        }
        i = i3;
        j = i1;
      }
      break label391;
      if (localFTSTroopSync.mOpt == 2)
      {
        localArrayList.add(a(2, String.valueOf(localFTSTroopSync.mTroopUin), String.valueOf(localFTSTroopSync.mMemberUin), "", "", "", 16));
        j += 1;
        break label391;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.fts.troop.operator", 2, "transToDatabase unknown opt:" + localFTSTroopSync.toString());
      }
      break label391;
      m += n;
      long l3 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("Q.fts.troop.operator", 2, new Object[] { "transToDatabase end troopUin=%s totalTime=%s curSegmentTotal:%s", String.valueOf(localFTSTroopSync.mTroopUin), String.valueOf(l3 - l2), String.valueOf(n) });
      }
      k = localArrayList.size() + k;
      if ((k > 300) || (!d()))
      {
        n = k;
        if (k <= 300) {}
      }
      for (;;)
      {
        l1 = System.currentTimeMillis() - l1;
        this.jdField_c_of_type_Int += n;
        this.jdField_a_of_type_Long += l1;
        if ((QLog.isColorLevel()) || (l1 > 60000L))
        {
          l2 = this.jdField_e_of_type_Int;
          if (this.jdField_e_of_type_Int == 0) {
            break label1659;
          }
          label1426:
          localObject2 = new StringBuilder(100);
          ((StringBuilder)localObject2).append(getClass().getSimpleName()).append(" count:").append(n).append(" cost:").append(l1).append(" indexCnt:").append(this.jdField_e_of_type_Int).append(" preIndexCnt:").append(l2).append(" segmentTotal:").append(m);
          l2 = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          if ((l1 <= 30000L) || (System.currentTimeMillis() - l2 <= 86400000L)) {
            break label1675;
          }
          QLog.e("Q.fts.BgCpu", 1, ((StringBuilder)localObject2).toString());
          localObject2 = new HashMap();
          ((HashMap)localObject2).put("param_count", String.valueOf(n));
          ((HashMap)localObject2).put("param_del", String.valueOf(j));
          ((HashMap)localObject2).put("param_insert", String.valueOf(i));
          ((HashMap)localObject2).put("param_stotal", String.valueOf(m));
          azri.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()).a(null, "actFTSTroopCost", true, l1, 0L, (HashMap)localObject2, null, false);
          a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, System.currentTimeMillis());
        }
        for (;;)
        {
          label1650:
          localawgf.a();
          return;
          break;
          label1659:
          this.jdField_e_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase.b("TroopIndex");
          break label1426;
          label1675:
          QLog.d("Q.fts.BgCpu", 1, ((StringBuilder)localObject2).toString());
        }
        label1690:
        break label1699;
        label1693:
        n = k;
      }
      label1699:
      continue;
      label1702:
      Object localObject2 = "";
    }
  }
  
  protected boolean e()
  {
    return true;
  }
  
  public void f()
  {
    this.jdField_a_of_type_Amof.post(new FTSTroopOperator.1(this));
  }
  
  public boolean f()
  {
    return this.f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amog
 * JD-Core Version:    0.7.0.1
 */