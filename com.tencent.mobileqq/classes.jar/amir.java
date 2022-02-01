import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.data.ApolloActionRecentData;
import com.tencent.mobileqq.apollo.data.ApolloGameRedDot;
import com.tencent.mobileqq.apollo.data.ApolloPreDownloadData;
import com.tencent.mobileqq.apollo.data.ApolloWhiteFaceID;
import com.tencent.mobileqq.apollo.utils.ApolloDaoManager.1;
import com.tencent.mobileqq.apollo.utils.ApolloDaoManager.3;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.AioPushData;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.data.ApolloActionPackage;
import com.tencent.mobileqq.data.ApolloActionPackageData;
import com.tencent.mobileqq.data.ApolloActionPush;
import com.tencent.mobileqq.data.ApolloFavActionData;
import com.tencent.mobileqq.data.ApolloGameData;
import com.tencent.mobileqq.data.ApolloGameRankData;
import com.tencent.mobileqq.data.ApolloGameRoamData;
import com.tencent.mobileqq.data.ApolloGameScoreData;
import com.tencent.mobileqq.data.ApolloKapuEntranceTips;
import com.tencent.mobileqq.data.ApolloObtainedActionData;
import com.tencent.mobileqq.data.ApolloRecommendAction;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;

public class amir
  implements Manager
{
  private volatile int jdField_a_of_type_Int = 1;
  public QQAppInterface a;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private Runnable jdField_a_of_type_JavaLangRunnable = new ApolloDaoManager.1(this);
  public List<ApolloActionData> a;
  public ConcurrentHashMap<Integer, String> a;
  public boolean a;
  public List<ApolloActionPackage> b;
  public ConcurrentHashMap<Integer, ApolloActionData> b;
  private boolean b;
  public List<ApolloActionPackageData> c;
  public ConcurrentHashMap<Integer, ApolloActionData> c;
  private boolean c;
  public List<ApolloFavActionData> d;
  public ConcurrentHashMap<Integer, ApolloGameRoamData> d;
  public List<ApolloGameData> e;
  public ConcurrentHashMap<String, ApolloPreDownloadData> e;
  public List<ApolloGameRoamData> f;
  public ConcurrentHashMap<Integer, ApolloWhiteFaceID> f;
  public List<ApolloActionPush> g;
  private ConcurrentHashMap<String, Integer> g;
  public List<ApolloObtainedActionData> h = Collections.synchronizedList(new ArrayList());
  public List<ApolloGameRedDot> i = Collections.synchronizedList(new ArrayList());
  public List<ApolloGameScoreData> j = Collections.synchronizedList(new ArrayList());
  public List<ApolloGameRankData> k = Collections.synchronizedList(new ArrayList());
  public List<ApolloRecommendAction> l = Collections.synchronizedList(new ArrayList());
  private List<AioPushData> m = Collections.synchronizedList(new ArrayList());
  private List<ApolloKapuEntranceTips> n = Collections.synchronizedList(new ArrayList());
  private List<ApolloKapuEntranceTips> o = Collections.synchronizedList(new ArrayList());
  
  public amir(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
    this.jdField_b_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
    this.jdField_c_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
    this.jdField_d_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
    this.jdField_e_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
    this.jdField_f_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_g_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_g_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_f_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    amgj.a().a(paramQQAppInterface);
    ThreadManager.getFileThreadHandler().post(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public static List<ApolloActionRecentData> a(QQAppInterface paramQQAppInterface, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramQQAppInterface == null) {
      return localArrayList;
    }
    String str = paramQQAppInterface.getCurrentUin();
    paramQQAppInterface = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    if (paramQQAppInterface != null) {}
    for (paramQQAppInterface = paramQQAppInterface.query(ApolloActionRecentData.class, false, "uin=? and sessionType=?", new String[] { str, paramString }, null, null, null, null);; paramQQAppInterface = localArrayList) {
      return paramQQAppInterface;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, ApolloActionRecentData paramApolloActionRecentData)
  {
    if ((paramQQAppInterface == null) || (paramApolloActionRecentData == null)) {}
    do
    {
      return;
      paramQQAppInterface = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    } while (paramQQAppInterface == null);
    paramQQAppInterface.persist(paramApolloActionRecentData);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, ApolloActionRecentData paramApolloActionRecentData1, ApolloActionRecentData paramApolloActionRecentData2)
  {
    if ((paramQQAppInterface == null) || (paramApolloActionRecentData1 == null) || (paramApolloActionRecentData2 == null)) {}
    do
    {
      return;
      paramQQAppInterface = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    } while (paramQQAppInterface == null);
    paramQQAppInterface.remove(paramApolloActionRecentData2);
    paramQQAppInterface.persist(paramApolloActionRecentData1);
  }
  
  private void c(ApolloActionData paramApolloActionData)
  {
    Object localObject = paramApolloActionData.keywords;
    if (TextUtils.isEmpty((CharSequence)localObject)) {}
    for (;;)
    {
      return;
      if ((TextUtils.isEmpty(paramApolloActionData.minVer)) || (TextUtils.isEmpty(paramApolloActionData.maxVer)) || (amio.a(AppSetting.f(), paramApolloActionData.minVer, paramApolloActionData.maxVer)))
      {
        localObject = ((String)localObject).split(",");
        int i2 = localObject.length;
        int i1 = 0;
        while (i1 < i2)
        {
          CharSequence localCharSequence = localObject[i1];
          if (!TextUtils.isEmpty(localCharSequence))
          {
            this.jdField_g_of_type_JavaUtilConcurrentConcurrentHashMap.put(localCharSequence, Integer.valueOf(paramApolloActionData.actionId));
            if (localCharSequence.length() > this.jdField_a_of_type_Int) {
              this.jdField_a_of_type_Int = localCharSequence.length();
            }
          }
          i1 += 1;
        }
      }
    }
  }
  
  private void g()
  {
    if (this.m != null)
    {
      Iterator localIterator;
      synchronized (this.m)
      {
        int i1 = (int)(System.currentTimeMillis() / 1000L);
        ArrayList localArrayList = new ArrayList();
        localIterator = this.m.iterator();
        while (localIterator.hasNext())
        {
          AioPushData localAioPushData = (AioPushData)localIterator.next();
          if ((localAioPushData != null) && ((localAioPushData.endTs <= i1) || (localAioPushData.begTs >= localAioPushData.endTs))) {
            localArrayList.add(localAioPushData);
          }
        }
      }
      if (localCollection.size() > 0)
      {
        localIterator = localCollection.iterator();
        while (localIterator.hasNext()) {
          a((AioPushData)localIterator.next());
        }
        this.m.removeAll(localCollection);
      }
    }
  }
  
  private void j(List<ApolloActionPackage> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      break label13;
    }
    label13:
    while ((paramList.get(0) == null) || (((ApolloActionPackage)paramList.get(0)).packageId == 100)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ApolloDaoManager", 2, "[makesureGameFirst]");
    }
    Iterator localIterator = paramList.iterator();
    int i1 = -1;
    ApolloActionPackage localApolloActionPackage;
    while (localIterator.hasNext())
    {
      localApolloActionPackage = (ApolloActionPackage)localIterator.next();
      int i2 = i1 + 1;
      i1 = i2;
      if (localApolloActionPackage.packageId == 100) {
        i1 = i2;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloDaoManager", 2, "index:" + i1);
      }
      if ((i1 <= 0) || (localApolloActionPackage == null)) {
        break;
      }
      paramList.remove(i1);
      paramList.add(0, localApolloActionPackage);
      return;
      localApolloActionPackage = null;
    }
  }
  
  /* Error */
  private void k(List<ApolloObtainedActionData> paramList)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +19 -> 20
    //   4: aload_1
    //   5: invokeinterface 281 1 0
    //   10: ifeq +10 -> 20
    //   13: aload_0
    //   14: getfield 124	amir:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   17: ifnonnull +4 -> 21
    //   20: return
    //   21: aload_0
    //   22: getfield 124	amir:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   25: invokevirtual 158	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/data/QQEntityManagerFactory;
    //   28: invokevirtual 164	com/tencent/mobileqq/data/QQEntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   31: astore_3
    //   32: aload_3
    //   33: ifnull +148 -> 181
    //   36: aload_3
    //   37: invokevirtual 337	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   40: astore_2
    //   41: aload_2
    //   42: invokevirtual 342	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   45: new 312	java/lang/StringBuilder
    //   48: dup
    //   49: sipush 500
    //   52: invokespecial 345	java/lang/StringBuilder:<init>	(I)V
    //   55: astore 4
    //   57: aload 4
    //   59: ldc_w 347
    //   62: invokevirtual 319	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: pop
    //   66: aload_1
    //   67: invokeinterface 256 1 0
    //   72: astore 5
    //   74: aload 5
    //   76: invokeinterface 262 1 0
    //   81: ifeq +165 -> 246
    //   84: aload 5
    //   86: invokeinterface 266 1 0
    //   91: checkcast 349	com/tencent/mobileqq/data/ApolloObtainedActionData
    //   94: astore 6
    //   96: aload_0
    //   97: aload_3
    //   98: aload 6
    //   100: invokevirtual 352	amir:a	(Lcom/tencent/mobileqq/persistence/EntityManager;Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   103: pop
    //   104: invokestatic 303	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   107: ifeq -33 -> 74
    //   110: aload 4
    //   112: ldc_w 354
    //   115: invokevirtual 319	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: aload 6
    //   120: getfield 357	com/tencent/mobileqq/data/ApolloObtainedActionData:id	I
    //   123: invokevirtual 322	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   126: pop
    //   127: aload 4
    //   129: invokevirtual 358	java/lang/StringBuilder:length	()I
    //   132: sipush 500
    //   135: if_icmplt -61 -> 74
    //   138: ldc_w 305
    //   141: iconst_2
    //   142: aload 4
    //   144: invokevirtual 325	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   147: invokestatic 310	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   150: aload 4
    //   152: iconst_0
    //   153: aload 4
    //   155: invokevirtual 358	java/lang/StringBuilder:length	()I
    //   158: invokevirtual 362	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   161: pop
    //   162: goto -88 -> 74
    //   165: astore_3
    //   166: ldc_w 305
    //   169: iconst_2
    //   170: ldc_w 364
    //   173: aload_3
    //   174: invokestatic 367	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   177: aload_2
    //   178: invokevirtual 370	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   181: aload_0
    //   182: getfield 83	amir:h	Ljava/util/List;
    //   185: ifnull +32 -> 217
    //   188: aload_0
    //   189: getfield 83	amir:h	Ljava/util/List;
    //   192: astore_2
    //   193: aload_2
    //   194: monitorenter
    //   195: aload_0
    //   196: getfield 83	amir:h	Ljava/util/List;
    //   199: invokeinterface 373 1 0
    //   204: aload_0
    //   205: getfield 83	amir:h	Ljava/util/List;
    //   208: aload_1
    //   209: invokeinterface 376 2 0
    //   214: pop
    //   215: aload_2
    //   216: monitorexit
    //   217: aload_0
    //   218: getfield 87	amir:jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   221: ifnull +10 -> 231
    //   224: aload_0
    //   225: getfield 87	amir:jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   228: invokevirtual 377	java/util/concurrent/ConcurrentHashMap:clear	()V
    //   231: aload_0
    //   232: getfield 85	amir:jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   235: ifnull -215 -> 20
    //   238: aload_0
    //   239: getfield 85	amir:jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   242: invokevirtual 377	java/util/concurrent/ConcurrentHashMap:clear	()V
    //   245: return
    //   246: aload 4
    //   248: invokevirtual 358	java/lang/StringBuilder:length	()I
    //   251: sipush 500
    //   254: if_icmpge +35 -> 289
    //   257: aload 4
    //   259: invokevirtual 358	java/lang/StringBuilder:length	()I
    //   262: ifle +27 -> 289
    //   265: invokestatic 303	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   268: ifeq +21 -> 289
    //   271: invokestatic 303	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   274: ifeq +15 -> 289
    //   277: ldc_w 305
    //   280: iconst_2
    //   281: aload 4
    //   283: invokevirtual 325	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   286: invokestatic 310	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   289: aload_2
    //   290: invokevirtual 380	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   293: aload_2
    //   294: invokevirtual 370	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   297: goto -116 -> 181
    //   300: astore_1
    //   301: aload_2
    //   302: invokevirtual 370	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   305: aload_1
    //   306: athrow
    //   307: astore_1
    //   308: aload_2
    //   309: monitorexit
    //   310: aload_1
    //   311: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	312	0	this	amir
    //   0	312	1	paramList	List<ApolloObtainedActionData>
    //   31	67	3	localEntityManager	EntityManager
    //   165	9	3	localException	Exception
    //   55	227	4	localStringBuilder	StringBuilder
    //   72	13	5	localIterator	Iterator
    //   94	25	6	localApolloObtainedActionData	ApolloObtainedActionData
    // Exception table:
    //   from	to	target	type
    //   45	74	165	java/lang/Exception
    //   74	162	165	java/lang/Exception
    //   246	289	165	java/lang/Exception
    //   289	293	165	java/lang/Exception
    //   45	74	300	finally
    //   74	162	300	finally
    //   166	177	300	finally
    //   246	289	300	finally
    //   289	293	300	finally
    //   195	217	307	finally
    //   308	310	307	finally
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public int a(int paramInt)
  {
    if (this.jdField_c_of_type_JavaUtilList != null) {
      synchronized (this.jdField_c_of_type_JavaUtilList)
      {
        Iterator localIterator = this.jdField_c_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext())
        {
          ApolloActionPackageData localApolloActionPackageData = (ApolloActionPackageData)localIterator.next();
          if (localApolloActionPackageData.acitonId == paramInt)
          {
            paramInt = localApolloActionPackageData.packageId;
            return paramInt;
          }
        }
      }
    }
    return -1;
  }
  
  public int a(int paramInt1, int paramInt2)
  {
    if (this.jdField_f_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
      return 0;
    }
    ApolloWhiteFaceID localApolloWhiteFaceID = (ApolloWhiteFaceID)this.jdField_f_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt1));
    if (localApolloWhiteFaceID != null)
    {
      if (paramInt2 == 1) {
        return localApolloWhiteFaceID.action2d;
      }
      return localApolloWhiteFaceID.action3d;
    }
    return 0;
  }
  
  public AioPushData a(String paramString, int paramInt)
  {
    Object localObject1 = null;
    if ((!TextUtils.isEmpty(paramString)) && (paramInt > 0) && (this.m != null))
    {
      Object localObject2;
      synchronized (this.m)
      {
        int i1 = (int)(System.currentTimeMillis() / 1000L);
        Iterator localIterator = this.m.iterator();
        if (localIterator.hasNext())
        {
          AioPushData localAioPushData = (AioPushData)localIterator.next();
          if ((localAioPushData == null) || (!localAioPushData.them.equals(paramString)) || (paramInt != localAioPushData.busId) || (localAioPushData.isShow) || (localAioPushData.endTs <= i1)) {
            break label166;
          }
          if (localObject1 == null)
          {
            localObject2 = localAioPushData;
          }
          else
          {
            localObject2 = localAioPushData;
            if (localAioPushData.begTs <= ((AioPushData)localObject1).begTs) {
              break label166;
            }
          }
        }
        else
        {
          return localObject1;
        }
      }
      for (;;)
      {
        localObject1 = localObject2;
        break;
        label166:
        localObject2 = localObject1;
      }
    }
    return null;
  }
  
  public ApolloActionData a(int paramInt)
  {
    Object localObject1 = null;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    Object localObject2;
    do
    {
      do
      {
        return localObject1;
        localObject2 = b(paramInt);
        if (localObject2 != null) {
          return localObject2;
        }
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
      } while (localObject2 == null);
      localObject2 = (ApolloActionData)((EntityManager)localObject2).find(ApolloActionData.class, paramInt + "");
      localObject1 = localObject2;
    } while (!QLog.isColorLevel());
    QLog.d("ApolloDaoManager", 2, new Object[] { "findActionById from db:", Integer.valueOf(paramInt) });
    return localObject2;
  }
  
  public ApolloActionPackage a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return null;
    }
    if (this.jdField_b_of_type_JavaUtilList != null) {
      for (;;)
      {
        int i1;
        synchronized (this.jdField_b_of_type_JavaUtilList)
        {
          i1 = this.jdField_b_of_type_JavaUtilList.size() - 1;
          if (i1 < 0) {
            break;
          }
          if (((ApolloActionPackage)this.jdField_b_of_type_JavaUtilList.get(i1)).packageId == paramInt)
          {
            ApolloActionPackage localApolloActionPackage = (ApolloActionPackage)this.jdField_b_of_type_JavaUtilList.get(i1);
            return localApolloActionPackage;
          }
        }
        i1 -= 1;
      }
    }
    ??? = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    if (??? != null) {
      return (ApolloActionPackage)((EntityManager)???).find(ApolloActionPackage.class, paramInt + "");
    }
    return null;
  }
  
  public ApolloActionPush a(SessionInfo paramSessionInfo)
  {
    if (paramSessionInfo == null) {
      return null;
    }
    Object localObject = k();
    if ((localObject == null) || (((List)localObject).size() == 0)) {
      return null;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ApolloActionPush localApolloActionPush = (ApolloActionPush)((Iterator)localObject).next();
      if ((localApolloActionPush != null) && (localApolloActionPush.mAioType == paramSessionInfo.curType) && (!TextUtils.isEmpty(paramSessionInfo.curFriendUin)) && (paramSessionInfo.curFriendUin.equals(localApolloActionPush.mSessionId + ""))) {
        return localApolloActionPush;
      }
    }
    return null;
  }
  
  public ApolloFavActionData a(long paramLong)
  {
    Object localObject4 = null;
    List localList;
    int i1;
    if (this.jdField_d_of_type_JavaUtilList != null)
    {
      localList = this.jdField_d_of_type_JavaUtilList;
      i1 = 0;
    }
    for (;;)
    {
      Object localObject1 = localObject4;
      try
      {
        if (i1 < this.jdField_d_of_type_JavaUtilList.size())
        {
          if (((ApolloFavActionData)this.jdField_d_of_type_JavaUtilList.get(i1)).favId != paramLong) {
            break label170;
          }
          localObject1 = (ApolloFavActionData)this.jdField_d_of_type_JavaUtilList.get(i1);
        }
        return localObject1;
      }
      finally {}
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
      {
        Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
        if (localObject3 != null) {
          if (QLog.isColorLevel()) {
            QLog.d("ApolloDaoManager", 2, "find ApolloFavActionData favid=" + paramLong);
          }
        }
        for (localObject3 = (ApolloFavActionData)((EntityManager)localObject3).find(ApolloFavActionData.class, paramLong);; localObject3 = null) {
          return localObject3;
        }
      }
      return null;
      label170:
      i1 += 1;
    }
  }
  
  public ApolloGameData a(int paramInt)
  {
    Object localObject1;
    if (paramInt <= 0) {
      localObject1 = null;
    }
    ApolloGameData localApolloGameData2;
    do
    {
      return localObject1;
      if (this.jdField_e_of_type_JavaUtilList != null)
      {
        localObject1 = this.jdField_e_of_type_JavaUtilList;
        int i1 = 0;
        for (;;)
        {
          try
          {
            if (i1 >= this.jdField_e_of_type_JavaUtilList.size()) {
              break;
            }
            if (((ApolloGameData)this.jdField_e_of_type_JavaUtilList.get(i1)).gameId == paramInt)
            {
              ApolloGameData localApolloGameData1 = (ApolloGameData)this.jdField_e_of_type_JavaUtilList.get(i1);
              return localApolloGameData1;
            }
          }
          finally {}
          i1 += 1;
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
        return null;
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
      if (localObject1 == null) {
        break;
      }
      localApolloGameData2 = (ApolloGameData)((EntityManager)localObject1).find(ApolloGameData.class, paramInt + "");
      localObject1 = localApolloGameData2;
    } while (!QLog.isColorLevel());
    QLog.d("ApolloDaoManager", 2, "findGameById from db");
    return localApolloGameData2;
    return null;
  }
  
  @Deprecated
  public ApolloGameData a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    return null;
  }
  
  public ApolloKapuEntranceTips a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (;;)
    {
      int i1;
      synchronized (this.n)
      {
        if (this.n.size() <= 0) {
          break label183;
        }
        i1 = this.n.size() - 1;
        if (i1 < 0) {
          break label183;
        }
        ApolloKapuEntranceTips localApolloKapuEntranceTips1 = (ApolloKapuEntranceTips)this.n.get(i1);
        if (localApolloKapuEntranceTips1.isValid()) {
          return localApolloKapuEntranceTips1;
        }
        this.n.remove(i1);
        i1 -= 1;
      }
      for (;;)
      {
        synchronized (this.o)
        {
          if (this.o.size() <= 0) {
            break label178;
          }
          i1 = this.o.size() - 1;
          if (i1 < 0) {
            break label178;
          }
          ApolloKapuEntranceTips localApolloKapuEntranceTips2 = (ApolloKapuEntranceTips)this.o.get(i1);
          if (localApolloKapuEntranceTips2.isValid()) {
            return localApolloKapuEntranceTips2;
          }
        }
        this.o.remove(i1);
        i1 -= 1;
        continue;
        label178:
        localObject3 = null;
      }
      label183:
      Object localObject3 = null;
    }
  }
  
  public Pair<List<ApolloFavActionData>, List<ApolloActionData>> a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloDaoManager", 2, "getFavPanelActionPairInfo");
    }
    List localList = d();
    Collections.sort(localList, new amis(this));
    ArrayList localArrayList = new ArrayList(localList.size());
    int i3 = localList.size();
    int i2 = 0;
    int i1 = 1;
    if (i2 < i3)
    {
      Object localObject = (ApolloFavActionData)localList.get(i2);
      if (localObject == null) {
        break label190;
      }
      localObject = a(((ApolloFavActionData)localObject).acitonId);
      if (localObject != null) {
        localArrayList.add(localObject);
      }
    }
    label190:
    for (;;)
    {
      i2 += 1;
      break;
      i1 = 0;
      continue;
      if (i1 == 0)
      {
        QLog.e("ApolloDaoManager", 1, "[getFavPanelActionPairInfo] has some action not exit and check action json");
        if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_b_of_type_Boolean))
        {
          this.jdField_b_of_type_Boolean = false;
          ((alnr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153)).a(false, "getFavPanelActionPairInfo action not exit", 1);
        }
      }
      return new Pair(localList, localArrayList);
    }
  }
  
  public HashMap<String, Integer> a()
  {
    HashMap localHashMap = new HashMap();
    if (this.jdField_g_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
      localHashMap.putAll(this.jdField_g_of_type_JavaUtilConcurrentConcurrentHashMap);
    }
    return localHashMap;
  }
  
  public List<ApolloActionData> a()
  {
    Integer localInteger = null;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    do
    {
      return null;
      if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0)) {
        return this.jdField_a_of_type_JavaUtilList;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    } while (localObject == null);
    Object localObject = ((EntityManager)localObject).query(ApolloActionData.class);
    if (QLog.isColorLevel()) {
      if (localObject != null) {
        break label90;
      }
    }
    for (;;)
    {
      QLog.d("ApolloDaoManager", 2, new Object[] { "[getActionList] db list size:", localInteger });
      return localObject;
      label90:
      localInteger = Integer.valueOf(((List)localObject).size());
    }
  }
  
  public List<ApolloActionData> a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return null;
    }
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0)) {}
    for (;;)
    {
      int i1;
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        ArrayList localArrayList = new ArrayList();
        i1 = 0;
        if (i1 < this.jdField_a_of_type_JavaUtilList.size())
        {
          if (((ApolloActionData)this.jdField_a_of_type_JavaUtilList.get(i1)).feeType == paramInt) {
            break label178;
          }
          localArrayList.add(this.jdField_a_of_type_JavaUtilList.get(i1));
          break label178;
        }
        if ((localArrayList != null) && (localArrayList.size() > 0)) {
          return localArrayList;
        }
        ??? = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
        if (??? != null) {
          return ((EntityManager)???).query(ApolloActionData.class, false, "feeType!=?", new String[] { String.valueOf(paramInt) }, null, null, null, null);
        }
      }
      return new ArrayList();
      label178:
      i1 += 1;
    }
  }
  
  public List<ApolloGameRankData> a(int paramInt, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if ((this.k != null) && (this.k.size() > 0))
    {
      Object localObject = new ArrayList(this.k);
      if ((paramInt > 0) && (!TextUtils.isEmpty(paramString)))
      {
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          ApolloGameRankData localApolloGameRankData = (ApolloGameRankData)((Iterator)localObject).next();
          if ((localApolloGameRankData != null) && (paramInt >= 0) && (paramString.equals(localApolloGameRankData.mFriendUin)))
          {
            localArrayList.add(localApolloGameRankData);
            paramInt -= 1;
          }
        }
      }
    }
    return localArrayList;
  }
  
  public List<ApolloActionPackage> a(SessionInfo paramSessionInfo)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (paramSessionInfo == null)) {
      return null;
    }
    return c(paramSessionInfo.curType);
  }
  
  public List<ApolloGameScoreData> a(String paramString, int paramInt, List<ApolloGameData> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if ((this.j != null) && (paramList != null) && (!TextUtils.isEmpty(paramString))) {}
    for (;;)
    {
      synchronized (this.j)
      {
        paramList = new ArrayList(paramList).iterator();
        i1 = paramInt;
        ApolloGameData localApolloGameData;
        if (paramList.hasNext())
        {
          localApolloGameData = (ApolloGameData)paramList.next();
          if (i1 >= -1) {}
        }
        else
        {
          return localArrayList;
        }
        Object localObject = a(localApolloGameData.gameId);
        if ((localObject == null) || (((ApolloGameData)localObject).isShow == 0)) {
          continue;
        }
        Iterator localIterator = new ArrayList(this.j).iterator();
        i2 = 0;
        paramInt = i1;
        if (localIterator.hasNext())
        {
          ApolloGameScoreData localApolloGameScoreData = (ApolloGameScoreData)localIterator.next();
          if ((paramString.equals(localApolloGameScoreData.mUin)) && (localApolloGameData.gameId == localApolloGameScoreData.mGameId))
          {
            localArrayList.add(localApolloGameScoreData);
            i1 = paramInt - 1;
            paramInt = 1;
            break label306;
          }
        }
        else
        {
          i1 = paramInt;
          if (i2 != 0) {
            continue;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ApolloDaoManager", 2, "[getScoreDataByUin] append " + ((ApolloGameData)localObject).gameId);
          }
          localObject = new ApolloGameScoreData();
          ((ApolloGameScoreData)localObject).mUin = paramString;
          ((ApolloGameScoreData)localObject).mGameId = localApolloGameData.gameId;
          ((ApolloGameScoreData)localObject).mFromDb = false;
          localArrayList.add(localObject);
          i1 = paramInt - 1;
        }
      }
      int i1 = paramInt;
      paramInt = i2;
      break label306;
      return localArrayList;
      label306:
      int i2 = paramInt;
      paramInt = i1;
    }
  }
  
  public List<ApolloGameScoreData> a(String arg1, String paramString2, int paramInt, List<ApolloGameData> paramList)
  {
    Object localObject1 = a(???, paramInt, paramList);
    paramList = new ArrayList();
    if ((localObject1 != null) && (this.j != null)) {}
    for (;;)
    {
      synchronized (this.j)
      {
        localObject1 = ((List)localObject1).iterator();
        i1 = paramInt;
        ApolloGameScoreData localApolloGameScoreData1;
        if (((Iterator)localObject1).hasNext())
        {
          localApolloGameScoreData1 = (ApolloGameScoreData)((Iterator)localObject1).next();
          if (i1 >= -1) {}
        }
        else
        {
          return paramList;
        }
        Object localObject2 = a(localApolloGameScoreData1.mGameId);
        if ((localObject2 == null) || (((ApolloGameData)localObject2).isShow == 0)) {
          continue;
        }
        localObject2 = this.j.iterator();
        i2 = 0;
        paramInt = i1;
        if (((Iterator)localObject2).hasNext())
        {
          ApolloGameScoreData localApolloGameScoreData2 = (ApolloGameScoreData)((Iterator)localObject2).next();
          if ((paramString2.equals(localApolloGameScoreData2.mUin)) && (localApolloGameScoreData1.mGameId == localApolloGameScoreData2.mGameId))
          {
            paramList.add(localApolloGameScoreData2);
            i1 = paramInt - 1;
            paramInt = 1;
            break label261;
          }
        }
        else
        {
          i1 = paramInt;
          if (i2 != 0) {
            continue;
          }
          localObject2 = new ApolloGameScoreData();
          ((ApolloGameScoreData)localObject2).mUin = paramString2;
          ((ApolloGameScoreData)localObject2).mGameId = localApolloGameScoreData1.mGameId;
          ((ApolloGameScoreData)localObject2).mFromDb = false;
          paramList.add(localObject2);
          i1 = paramInt - 1;
        }
      }
      int i1 = paramInt;
      paramInt = i2;
      break label261;
      return paramList;
      label261:
      int i2 = paramInt;
      paramInt = i1;
    }
  }
  
  public Map<String, ApolloPreDownloadData> a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return new HashMap();
    }
    if (this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap.size() > 0) {
      return this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap;
    }
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    Object localObject3 = new ArrayList();
    Object localObject1 = localObject3;
    EntityTransaction localEntityTransaction;
    if (localEntityManager != null)
    {
      localEntityTransaction = localEntityManager.getTransaction();
      localEntityTransaction.begin();
    }
    try
    {
      localObject1 = (ArrayList)localEntityManager.query(ApolloPreDownloadData.class);
      return this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap;
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        QLog.e("ApolloDaoManager", 1, "getPreDownloadRes exception: ", (Throwable)localObject3);
        localEntityTransaction.end();
      }
    }
    finally
    {
      localEntityTransaction.end();
    }
  }
  
  public ConcurrentHashMap<Integer, ApolloActionData> a()
  {
    if ((this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.size() > 0)) {
      return this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap;
    }
    Object localObject = g(0);
    if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
      this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    }
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ApolloObtainedActionData localApolloObtainedActionData = (ApolloObtainedActionData)((Iterator)localObject).next();
        ApolloActionData localApolloActionData = new ApolloActionData();
        localApolloActionData.actionId = localApolloObtainedActionData.id;
        localApolloActionData.obtainedTime = localApolloObtainedActionData.beginTs;
        this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(localApolloActionData.actionId), localApolloActionData);
      }
    }
    return this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloDaoManager", 2, "[readApolloGameVerFromFile]");
    }
    Object localObject1 = h();
    if ((localObject1 == null) || (((List)localObject1).size() == 0))
    {
      QLog.i("ApolloDaoManager", 1, "errInfo->gameList is null.");
      return;
    }
    StringBuilder localStringBuilder2;
    for (;;)
    {
      ApolloGameData localApolloGameData;
      Object localObject2;
      try
      {
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder2 = new StringBuilder();
        localStringBuilder1.append("readGameVersion:");
        localStringBuilder2.append("\nerrInfo(config.json not exists):");
        localObject1 = ((List)localObject1).iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localApolloGameData = (ApolloGameData)((Iterator)localObject1).next();
        localObject2 = new StringBuilder(100);
        ((StringBuilder)localObject2).append(amip.s).append(localApolloGameData.gameId).append(File.separator).append("config.json");
        localObject2 = new File(((StringBuilder)localObject2).toString());
        if (!((File)localObject2).exists())
        {
          localStringBuilder2.append(localApolloGameData.gameId).append(", ");
          continue;
        }
        localObject2 = new JSONObject(FileUtils.readFileToString((File)localObject2)).optString("version");
      }
      catch (Exception localException)
      {
        QLog.e("ApolloDaoManager", 1, "catch errInfo:" + localException.getMessage());
        return;
      }
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(localApolloGameData.gameId), localObject2);
      }
      localException.append("gId:").append(localApolloGameData.gameId).append(",ver:").append((String)localObject2).append("|");
    }
    QLog.i("ApolloDaoManager", 1, localException.toString() + localStringBuilder2.toString());
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloDaoManager", 2, "[readApolloGameVerFromFile]");
    }
    Object localObject1 = h();
    if ((localObject1 == null) || (((List)localObject1).size() == 0))
    {
      QLog.i("ApolloDaoManager", 1, "errInfo->gameList is null.");
      return;
    }
    for (;;)
    {
      ApolloGameData localApolloGameData;
      Object localObject2;
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localObject1 = ((List)localObject1).iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localApolloGameData = (ApolloGameData)((Iterator)localObject1).next();
        if (paramInt != localApolloGameData.gameId) {
          continue;
        }
        localObject2 = new StringBuilder(100);
        ((StringBuilder)localObject2).append(amip.s).append(localApolloGameData.gameId).append(File.separator).append("config.json");
        localObject2 = new File(((StringBuilder)localObject2).toString());
        if (!((File)localObject2).exists())
        {
          localStringBuilder.append("errInfo->game version file not exists, gameId: ").append(localApolloGameData.gameId);
          continue;
        }
        localObject2 = new JSONObject(FileUtils.readFileToString((File)localObject2)).optString("version");
      }
      catch (Exception localException)
      {
        QLog.e("ApolloDaoManager", 1, "catch errInfo:" + localException.getMessage());
        return;
      }
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(localApolloGameData.gameId), localObject2);
      }
      localException.append("gId:").append(localApolloGameData.gameId).append(",ver: ").append((String)localObject2).append("===");
    }
    QLog.i("ApolloDaoManager", 1, localException.toString());
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_g_of_type_JavaUtilList != null) {}
    EntityManager localEntityManager;
    do
    {
      synchronized (this.jdField_g_of_type_JavaUtilList)
      {
        Iterator localIterator = this.jdField_g_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext())
        {
          ApolloActionPush localApolloActionPush = (ApolloActionPush)localIterator.next();
          if ((localApolloActionPush != null) && (localApolloActionPush.mId == paramLong)) {
            this.jdField_g_of_type_JavaUtilList.remove(localApolloActionPush);
          }
        }
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
          return;
        }
      }
      localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    } while (localEntityManager == null);
    ??? = localEntityManager.getTransaction();
    try
    {
      ((EntityTransaction)???).begin();
      localEntityManager.execSQL(" DELETE FROM ApolloActionPush WHERE mId = " + paramLong);
      ((EntityTransaction)???).commit();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return;
    }
    finally
    {
      ((EntityTransaction)???).end();
    }
  }
  
  public void a(BaseChatPie paramBaseChatPie, List<ApolloActionData> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0) || (paramBaseChatPie == null) || (paramBaseChatPie.getApp() == null)) {
      return;
    }
    Object localObject = (alnr)paramBaseChatPie.getApp().getManager(153);
    boolean bool = ((alnr)localObject).a(paramBaseChatPie.getApp().getCurrentAccountUin());
    int i2 = ((alnr)localObject).a(paramBaseChatPie.getApp().getCurrentAccountUin());
    paramBaseChatPie = new ArrayList();
    localObject = new ArrayList();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    int i1 = 0;
    if (i1 < paramList.size())
    {
      ApolloActionData localApolloActionData = (ApolloActionData)paramList.get(i1);
      if (c(localApolloActionData.actionId)) {
        paramBaseChatPie.add(localApolloActionData);
      }
      for (;;)
      {
        i1 += 1;
        break;
        if (!TextUtils.isEmpty(localApolloActionData.iconUrl)) {
          localArrayList1.add(localApolloActionData);
        } else if (b(localApolloActionData.actionId)) {
          ((List)localObject).add(localApolloActionData);
        } else if (localApolloActionData.feeType == 1) {
          localArrayList2.add(localApolloActionData);
        } else if (localApolloActionData.feeType == 9)
        {
          if ((bool) && (localApolloActionData.vipLevel <= i2))
          {
            localApolloActionData.obtainedTime = (localApolloActionData.version / 1000L);
            ((List)localObject).add(localApolloActionData);
          }
          else
          {
            localArrayList3.add(localApolloActionData);
          }
        }
        else {
          localArrayList3.add(localApolloActionData);
        }
      }
    }
    Collections.sort(paramBaseChatPie, new amit(this));
    Collections.sort(localArrayList1, new amiu(this));
    Collections.sort((List)localObject, new amiv(this));
    Collections.sort(localArrayList2, new amiw(this));
    Collections.sort(localArrayList3, new amix(this));
    paramList.clear();
    paramList.addAll(paramBaseChatPie);
    paramList.addAll(localArrayList1);
    paramList.addAll((Collection)localObject);
    paramList.addAll(localArrayList2);
    paramList.addAll(localArrayList3);
  }
  
  public void a(ApolloPreDownloadData paramApolloPreDownloadData)
  {
    this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramApolloPreDownloadData.resId);
    this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramApolloPreDownloadData.resId, paramApolloPreDownloadData);
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    EntityTransaction localEntityTransaction;
    if (localEntityManager != null)
    {
      localEntityTransaction = localEntityManager.getTransaction();
      localEntityTransaction.begin();
    }
    try
    {
      localEntityManager.update(paramApolloPreDownloadData);
      localEntityTransaction.commit();
      return;
    }
    catch (Exception paramApolloPreDownloadData)
    {
      QLog.e("ApolloDaoManager", 1, "updatePreDownloadRes exception: ", paramApolloPreDownloadData);
      return;
    }
    finally
    {
      localEntityTransaction.end();
    }
  }
  
  public void a(AioPushData paramAioPushData)
  {
    if (paramAioPushData == null) {}
    for (;;)
    {
      return;
      if (this.m != null) {}
      boolean bool;
      EntityManager localEntityManager;
      synchronized (this.m)
      {
        bool = this.m.remove(paramAioPushData);
        if (QLog.isColorLevel()) {
          QLog.d("ApolloDaoManager", 2, "[realDelAioPushData] from cache " + String.valueOf(bool));
        }
        localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
        if (localEntityManager == null) {
          continue;
        }
        ??? = localEntityManager.getTransaction();
        ((EntityTransaction)???).begin();
      }
    }
  }
  
  public void a(ApolloActionData paramApolloActionData)
  {
    if ((paramApolloActionData == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {}
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_JavaUtilList != null) {}
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        int i1 = this.jdField_a_of_type_JavaUtilList.size() - 1;
        if (i1 >= 0)
        {
          if ((this.jdField_a_of_type_JavaUtilList.get(i1) != null) && (((ApolloActionData)this.jdField_a_of_type_JavaUtilList.get(i1)).actionId == paramApolloActionData.actionId))
          {
            this.jdField_a_of_type_JavaUtilList.remove(i1);
            this.jdField_a_of_type_JavaUtilList.add(i1, paramApolloActionData);
          }
        }
        else
        {
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
            continue;
          }
          ??? = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
          if (??? == null) {
            continue;
          }
          ((EntityManager)???).update(paramApolloActionData);
          return;
        }
        i1 -= 1;
      }
    }
  }
  
  public void a(ApolloActionPackage paramApolloActionPackage)
  {
    if ((paramApolloActionPackage == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {}
    for (;;)
    {
      return;
      if (this.jdField_b_of_type_JavaUtilList != null) {}
      synchronized (this.jdField_b_of_type_JavaUtilList)
      {
        int i1 = this.jdField_b_of_type_JavaUtilList.size() - 1;
        if (i1 >= 0)
        {
          if ((this.jdField_b_of_type_JavaUtilList.get(i1) != null) && (((ApolloActionPackage)this.jdField_b_of_type_JavaUtilList.get(i1)).packageId == paramApolloActionPackage.packageId))
          {
            this.jdField_b_of_type_JavaUtilList.remove(i1);
            this.jdField_b_of_type_JavaUtilList.add(i1, paramApolloActionPackage);
          }
        }
        else
        {
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
            continue;
          }
          ??? = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
          if (??? == null) {
            continue;
          }
          ((EntityManager)???).update(paramApolloActionPackage);
          return;
        }
        i1 -= 1;
      }
    }
  }
  
  public void a(ApolloActionPush paramApolloActionPush)
  {
    if ((paramApolloActionPush == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      return;
    }
    if (this.jdField_g_of_type_JavaUtilList != null) {}
    for (;;)
    {
      int i1;
      Object localObject2;
      synchronized (this.jdField_g_of_type_JavaUtilList)
      {
        i1 = this.jdField_g_of_type_JavaUtilList.size() - 1;
        if (i1 >= 0)
        {
          localObject2 = (ApolloActionPush)this.jdField_g_of_type_JavaUtilList.get(i1);
          if ((localObject2 != null) && (((ApolloActionPush)localObject2).mAioType == paramApolloActionPush.mAioType) && (((ApolloActionPush)localObject2).mSessionId == paramApolloActionPush.mSessionId)) {
            this.jdField_g_of_type_JavaUtilList.remove(localObject2);
          }
        }
        else
        {
          this.jdField_g_of_type_JavaUtilList.add(paramApolloActionPush);
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
          if (localObject2 == null) {
            break;
          }
          ??? = ((EntityManager)localObject2).getTransaction();
          ((EntityTransaction)???).begin();
        }
      }
      i1 -= 1;
    }
  }
  
  public void a(ApolloFavActionData paramApolloFavActionData)
  {
    if (paramApolloFavActionData == null) {}
    for (;;)
    {
      return;
      if (this.jdField_d_of_type_JavaUtilList != null) {}
      synchronized (this.jdField_d_of_type_JavaUtilList)
      {
        this.jdField_d_of_type_JavaUtilList.add(paramApolloFavActionData);
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
          continue;
        }
        ??? = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
        if (??? == null) {
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ApolloDaoManager", 2, "insert ApolloFavActionData id=" + paramApolloFavActionData.acitonId + " text=" + paramApolloFavActionData.text);
        }
        ((EntityManager)???).persist(paramApolloFavActionData);
        return;
      }
    }
  }
  
  public void a(ApolloGameRoamData paramApolloGameRoamData)
  {
    if (this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
      this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Integer.valueOf(paramApolloGameRoamData.gameId));
    }
  }
  
  public void a(ApolloKapuEntranceTips paramApolloKapuEntranceTips)
  {
    if ((paramApolloKapuEntranceTips == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      return;
    }
    QLog.d("ApolloDaoManager", 1, new Object[] { "updateKapuEntranceTips, tips=", paramApolloKapuEntranceTips });
    int i1;
    if (paramApolloKapuEntranceTips.isInstall) {
      synchronized (this.n)
      {
        if (paramApolloKapuEntranceTips.isValid())
        {
          i1 = this.n.size() - 1;
          for (;;)
          {
            if (i1 >= 0)
            {
              if (((ApolloKapuEntranceTips)this.n.get(i1)).adId == paramApolloKapuEntranceTips.adId) {
                this.n.set(i1, paramApolloKapuEntranceTips);
              }
            }
            else
            {
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager().update(paramApolloKapuEntranceTips);
              return;
            }
            i1 -= 1;
          }
        }
        this.n.remove(paramApolloKapuEntranceTips);
      }
    }
    for (;;)
    {
      synchronized (this.o)
      {
        if (!paramApolloKapuEntranceTips.isValid()) {
          break label231;
        }
        i1 = this.o.size() - 1;
        if (i1 >= 0)
        {
          if (((ApolloKapuEntranceTips)this.o.get(i1)).adId != paramApolloKapuEntranceTips.adId) {
            break label224;
          }
          this.o.set(i1, paramApolloKapuEntranceTips);
        }
      }
      label224:
      i1 -= 1;
      continue;
      label231:
      this.o.remove(paramApolloKapuEntranceTips);
    }
  }
  
  public void a(ApolloObtainedActionData paramApolloObtainedActionData)
  {
    if (paramApolloObtainedActionData == null) {}
    for (;;)
    {
      return;
      if (this.h != null) {}
      synchronized (this.h)
      {
        this.h.add(paramApolloObtainedActionData);
        if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
          this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
        }
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
          continue;
        }
        ??? = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
        if (??? == null) {
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ApolloDaoManager", 2, "insert ApolloObtainedActionData:" + paramApolloObtainedActionData.toString());
        }
        ((EntityManager)???).persist(paramApolloObtainedActionData);
        return;
      }
    }
  }
  
  public void a(EntityManager paramEntityManager, List<ApolloGameScoreData> paramList)
  {
    if ((paramEntityManager != null) && (paramList != null) && (paramList.size() > 0))
    {
      if (this.j != null)
      {
        this.j.removeAll(paramList);
        this.j.addAll(paramList);
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ApolloGameScoreData localApolloGameScoreData = (ApolloGameScoreData)paramList.next();
        paramEntityManager.persistOrReplace(localApolloGameScoreData);
        if (QLog.isColorLevel()) {
          QLog.d("ApolloDaoManager", 2, new Object[] { "[updateGameScore] ", localApolloGameScoreData });
        }
      }
    }
  }
  
  /* Error */
  public void a(ArrayList<ApolloGameRoamData> paramArrayList)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +17 -> 18
    //   4: aload_1
    //   5: invokevirtual 789	java/util/ArrayList:size	()I
    //   8: ifeq +10 -> 18
    //   11: aload_0
    //   12: getfield 124	amir:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   15: ifnonnull +4 -> 19
    //   18: return
    //   19: aload_0
    //   20: getfield 74	amir:jdField_f_of_type_JavaUtilList	Ljava/util/List;
    //   23: ifnull +130 -> 153
    //   26: aload_0
    //   27: getfield 74	amir:jdField_f_of_type_JavaUtilList	Ljava/util/List;
    //   30: astore_2
    //   31: aload_2
    //   32: monitorenter
    //   33: aload_1
    //   34: invokevirtual 547	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   37: astore_3
    //   38: aload_3
    //   39: invokeinterface 262 1 0
    //   44: ifeq +107 -> 151
    //   47: aload_3
    //   48: invokeinterface 266 1 0
    //   53: checkcast 762	com/tencent/mobileqq/data/ApolloGameRoamData
    //   56: astore 4
    //   58: aload_0
    //   59: getfield 74	amir:jdField_f_of_type_JavaUtilList	Ljava/util/List;
    //   62: invokeinterface 256 1 0
    //   67: astore 5
    //   69: aload 5
    //   71: invokeinterface 262 1 0
    //   76: ifeq -38 -> 38
    //   79: aload 5
    //   81: invokeinterface 266 1 0
    //   86: checkcast 762	com/tencent/mobileqq/data/ApolloGameRoamData
    //   89: astore 6
    //   91: aload 4
    //   93: ifnull -24 -> 69
    //   96: aload 6
    //   98: ifnull -29 -> 69
    //   101: aload 6
    //   103: getfield 763	com/tencent/mobileqq/data/ApolloGameRoamData:gameId	I
    //   106: aload 4
    //   108: getfield 763	com/tencent/mobileqq/data/ApolloGameRoamData:gameId	I
    //   111: if_icmpne -42 -> 69
    //   114: aload_0
    //   115: getfield 74	amir:jdField_f_of_type_JavaUtilList	Ljava/util/List;
    //   118: aload 6
    //   120: invokeinterface 673 2 0
    //   125: pop
    //   126: aload 6
    //   128: getfield 792	com/tencent/mobileqq/data/ApolloGameRoamData:tagUrl	Ljava/lang/String;
    //   131: invokestatic 204	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   134: ifeq -96 -> 38
    //   137: aload_0
    //   138: aload 6
    //   140: invokevirtual 794	amir:a	(Lcom/tencent/mobileqq/data/ApolloGameRoamData;)V
    //   143: goto -105 -> 38
    //   146: astore_1
    //   147: aload_2
    //   148: monitorexit
    //   149: aload_1
    //   150: athrow
    //   151: aload_2
    //   152: monitorexit
    //   153: aload_0
    //   154: getfield 124	amir:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   157: invokevirtual 158	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/data/QQEntityManagerFactory;
    //   160: invokevirtual 164	com/tencent/mobileqq/data/QQEntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   163: astore_3
    //   164: aload_3
    //   165: ifnull -147 -> 18
    //   168: aload_3
    //   169: invokevirtual 337	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   172: astore_2
    //   173: aload_2
    //   174: invokevirtual 342	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   177: aload_1
    //   178: invokevirtual 547	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   181: astore_1
    //   182: aload_1
    //   183: invokeinterface 262 1 0
    //   188: ifeq +61 -> 249
    //   191: aload_1
    //   192: invokeinterface 266 1 0
    //   197: checkcast 762	com/tencent/mobileqq/data/ApolloGameRoamData
    //   200: astore 4
    //   202: aload 4
    //   204: ifnull -22 -> 182
    //   207: aload_3
    //   208: new 312	java/lang/StringBuilder
    //   211: dup
    //   212: invokespecial 313	java/lang/StringBuilder:<init>	()V
    //   215: ldc_w 796
    //   218: invokevirtual 319	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: aload 4
    //   223: getfield 763	com/tencent/mobileqq/data/ApolloGameRoamData:gameId	I
    //   226: invokevirtual 322	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   229: invokevirtual 325	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   232: invokevirtual 679	com/tencent/mobileqq/persistence/EntityManager:execSQL	(Ljava/lang/String;)Z
    //   235: pop
    //   236: goto -54 -> 182
    //   239: astore_1
    //   240: aload_1
    //   241: invokevirtual 682	java/lang/Exception:printStackTrace	()V
    //   244: aload_2
    //   245: invokevirtual 370	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   248: return
    //   249: aload_2
    //   250: invokevirtual 380	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   253: aload_2
    //   254: invokevirtual 370	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   257: return
    //   258: astore_1
    //   259: aload_2
    //   260: invokevirtual 370	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   263: aload_1
    //   264: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	265	0	this	amir
    //   0	265	1	paramArrayList	ArrayList<ApolloGameRoamData>
    //   30	230	2	localObject1	Object
    //   37	171	3	localObject2	Object
    //   56	166	4	localApolloGameRoamData1	ApolloGameRoamData
    //   67	13	5	localIterator	Iterator
    //   89	50	6	localApolloGameRoamData2	ApolloGameRoamData
    // Exception table:
    //   from	to	target	type
    //   33	38	146	finally
    //   38	69	146	finally
    //   69	91	146	finally
    //   101	143	146	finally
    //   147	149	146	finally
    //   151	153	146	finally
    //   173	182	239	java/lang/Exception
    //   182	202	239	java/lang/Exception
    //   207	236	239	java/lang/Exception
    //   249	253	239	java/lang/Exception
    //   173	182	258	finally
    //   182	202	258	finally
    //   207	236	258	finally
    //   240	244	258	finally
    //   249	253	258	finally
  }
  
  public void a(List<ApolloActionData> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {}
    for (;;)
    {
      return;
      EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
      if (localEntityManager != null)
      {
        ??? = localEntityManager.getTransaction();
        ((EntityTransaction)???).begin();
      }
      try
      {
        localStringBuilder = new StringBuilder(500);
        Iterator localIterator = paramList.iterator();
        while (localIterator.hasNext())
        {
          ApolloActionData localApolloActionData = (ApolloActionData)localIterator.next();
          c(localApolloActionData);
          a(localEntityManager, localApolloActionData);
          if (QLog.isColorLevel())
          {
            localStringBuilder.append(" saveAction ID:").append(localApolloActionData.actionId);
            if (localStringBuilder.length() >= 500)
            {
              QLog.d("ApolloDaoManager", 2, localStringBuilder.toString());
              localStringBuilder.delete(0, localStringBuilder.length());
            }
          }
        }
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder;
        if (QLog.isColorLevel()) {
          QLog.d("ApolloDaoManager", 2, "saveAction exception: ", localException);
        }
        ((EntityTransaction)???).end();
        while (this.jdField_a_of_type_JavaUtilList != null)
        {
          synchronized (this.jdField_a_of_type_JavaUtilList)
          {
            this.jdField_a_of_type_JavaUtilList.addAll(paramList);
            return;
          }
          if ((localStringBuilder.length() < 500) && (localStringBuilder.length() > 0) && (QLog.isColorLevel())) {
            QLog.d("ApolloDaoManager", 2, localStringBuilder.toString());
          }
          ((EntityTransaction)???).commit();
          ((EntityTransaction)???).end();
        }
      }
      finally
      {
        ((EntityTransaction)???).end();
      }
    }
  }
  
  /* Error */
  public void a(List<AioPushData> paramList, int paramInt)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +19 -> 20
    //   4: aload_1
    //   5: invokeinterface 281 1 0
    //   10: ifeq +10 -> 20
    //   13: aload_0
    //   14: getfield 124	amir:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   17: ifnonnull +4 -> 21
    //   20: return
    //   21: new 55	java/util/ArrayList
    //   24: dup
    //   25: invokespecial 56	java/util/ArrayList:<init>	()V
    //   28: astore 5
    //   30: aload_0
    //   31: getfield 89	amir:m	Ljava/util/List;
    //   34: ifnull +277 -> 311
    //   37: aload_0
    //   38: getfield 89	amir:m	Ljava/util/List;
    //   41: astore 6
    //   43: aload 6
    //   45: monitorenter
    //   46: aload_1
    //   47: invokestatic 805	java/util/Collections:sort	(Ljava/util/List;)V
    //   50: invokestatic 248	java/lang/System:currentTimeMillis	()J
    //   53: ldc2_w 249
    //   56: ldiv
    //   57: l2i
    //   58: istore_3
    //   59: aload_1
    //   60: invokeinterface 256 1 0
    //   65: astore 7
    //   67: aload 7
    //   69: invokeinterface 262 1 0
    //   74: ifeq +234 -> 308
    //   77: aload 7
    //   79: invokeinterface 266 1 0
    //   84: checkcast 268	com/tencent/mobileqq/data/AioPushData
    //   87: astore 8
    //   89: aload 8
    //   91: ifnull -24 -> 67
    //   94: aload 8
    //   96: getfield 274	com/tencent/mobileqq/data/AioPushData:begTs	I
    //   99: aload 8
    //   101: getfield 271	com/tencent/mobileqq/data/AioPushData:endTs	I
    //   104: if_icmpgt -37 -> 67
    //   107: aload 8
    //   109: getfield 271	com/tencent/mobileqq/data/AioPushData:endTs	I
    //   112: iload_3
    //   113: if_icmple -46 -> 67
    //   116: aload 8
    //   118: getfield 413	com/tencent/mobileqq/data/AioPushData:isShow	Z
    //   121: ifne -54 -> 67
    //   124: aload_0
    //   125: getfield 89	amir:m	Ljava/util/List;
    //   128: aload 8
    //   130: invokeinterface 809 2 0
    //   135: istore 4
    //   137: iload 4
    //   139: iflt +67 -> 206
    //   142: aload_0
    //   143: getfield 89	amir:m	Ljava/util/List;
    //   146: iload 4
    //   148: invokeinterface 293 2 0
    //   153: checkcast 268	com/tencent/mobileqq/data/AioPushData
    //   156: astore 9
    //   158: aload 9
    //   160: ifnull +27 -> 187
    //   163: aload 9
    //   165: getfield 413	com/tencent/mobileqq/data/AioPushData:isShow	Z
    //   168: ifeq +19 -> 187
    //   171: invokestatic 303	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   174: ifeq +13 -> 187
    //   177: ldc_w 305
    //   180: iconst_2
    //   181: ldc_w 811
    //   184: invokestatic 310	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   187: aload 5
    //   189: aload 8
    //   191: invokeinterface 278 2 0
    //   196: pop
    //   197: goto -130 -> 67
    //   200: astore_1
    //   201: aload 6
    //   203: monitorexit
    //   204: aload_1
    //   205: athrow
    //   206: invokestatic 303	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   209: ifeq +31 -> 240
    //   212: ldc_w 305
    //   215: iconst_2
    //   216: new 312	java/lang/StringBuilder
    //   219: dup
    //   220: invokespecial 313	java/lang/StringBuilder:<init>	()V
    //   223: ldc_w 813
    //   226: invokevirtual 319	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: aload 8
    //   231: invokevirtual 816	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   234: invokevirtual 325	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   237: invokestatic 310	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   240: iload_2
    //   241: iconst_1
    //   242: if_icmpne +38 -> 280
    //   245: aload_0
    //   246: getfield 124	amir:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   249: sipush 255
    //   252: invokevirtual 504	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   255: checkcast 818	amtm
    //   258: astore 9
    //   260: aload 9
    //   262: ifnull +33 -> 295
    //   265: aload 9
    //   267: aload 8
    //   269: getfield 404	com/tencent/mobileqq/data/AioPushData:them	Ljava/lang/String;
    //   272: aload 8
    //   274: getfield 821	com/tencent/mobileqq/data/AioPushData:wording	Ljava/lang/String;
    //   277: invokevirtual 824	amtm:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   280: aload_0
    //   281: getfield 89	amir:m	Ljava/util/List;
    //   284: aload 8
    //   286: invokeinterface 278 2 0
    //   291: pop
    //   292: goto -225 -> 67
    //   295: ldc_w 305
    //   298: iconst_1
    //   299: ldc_w 826
    //   302: invokestatic 500	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   305: goto -25 -> 280
    //   308: aload 6
    //   310: monitorexit
    //   311: aload_0
    //   312: getfield 124	amir:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   315: invokevirtual 158	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/data/QQEntityManagerFactory;
    //   318: invokevirtual 164	com/tencent/mobileqq/data/QQEntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   321: astore 7
    //   323: aload 7
    //   325: ifnull +105 -> 430
    //   328: aload 7
    //   330: invokevirtual 337	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   333: astore 6
    //   335: aload 6
    //   337: invokevirtual 342	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   340: aload 5
    //   342: invokeinterface 281 1 0
    //   347: ifle +12 -> 359
    //   350: aload_1
    //   351: aload 5
    //   353: invokeinterface 288 2 0
    //   358: pop
    //   359: aload_1
    //   360: invokeinterface 256 1 0
    //   365: astore_1
    //   366: aload_1
    //   367: invokeinterface 262 1 0
    //   372: ifeq +63 -> 435
    //   375: aload_0
    //   376: aload 7
    //   378: aload_1
    //   379: invokeinterface 266 1 0
    //   384: checkcast 268	com/tencent/mobileqq/data/AioPushData
    //   387: invokevirtual 352	amir:a	(Lcom/tencent/mobileqq/persistence/EntityManager;Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   390: pop
    //   391: goto -25 -> 366
    //   394: astore_1
    //   395: ldc_w 305
    //   398: iconst_1
    //   399: new 312	java/lang/StringBuilder
    //   402: dup
    //   403: invokespecial 313	java/lang/StringBuilder:<init>	()V
    //   406: ldc_w 828
    //   409: invokevirtual 319	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   412: aload_1
    //   413: invokevirtual 640	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   416: invokevirtual 319	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   419: invokevirtual 325	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   422: invokestatic 500	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   425: aload 6
    //   427: invokevirtual 370	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   430: aload_0
    //   431: invokespecial 830	amir:g	()V
    //   434: return
    //   435: aload 6
    //   437: invokevirtual 380	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   440: aload 6
    //   442: invokevirtual 370	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   445: goto -15 -> 430
    //   448: astore_1
    //   449: aload 6
    //   451: invokevirtual 370	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   454: aload_1
    //   455: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	456	0	this	amir
    //   0	456	1	paramList	List<AioPushData>
    //   0	456	2	paramInt	int
    //   58	56	3	i1	int
    //   135	12	4	i2	int
    //   28	324	5	localArrayList	ArrayList
    //   41	409	6	localObject1	Object
    //   65	312	7	localObject2	Object
    //   87	198	8	localAioPushData	AioPushData
    //   156	110	9	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   46	67	200	finally
    //   67	89	200	finally
    //   94	137	200	finally
    //   142	158	200	finally
    //   163	187	200	finally
    //   187	197	200	finally
    //   201	204	200	finally
    //   206	240	200	finally
    //   245	260	200	finally
    //   265	280	200	finally
    //   280	292	200	finally
    //   295	305	200	finally
    //   308	311	200	finally
    //   340	359	394	java/lang/Exception
    //   359	366	394	java/lang/Exception
    //   366	391	394	java/lang/Exception
    //   435	440	394	java/lang/Exception
    //   340	359	448	finally
    //   359	366	448	finally
    //   366	391	448	finally
    //   395	425	448	finally
    //   435	440	448	finally
  }
  
  public void a(List<ApolloGameRoamData> paramList1, List<ApolloGameRoamData> paramList2)
  {
    if ((paramList1 == null) || (paramList2 == null)) {
      return;
    }
    Object localObject = paramList1.iterator();
    int i1 = 0;
    int i2;
    if ((!((Iterator)localObject).hasNext()) || (TextUtils.isEmpty(((ApolloGameRoamData)((Iterator)localObject).next()).tagUrl)))
    {
      i2 = 0;
      label51:
      if (i2 >= paramList2.size()) {
        break label123;
      }
      localObject = (ApolloGameRoamData)paramList2.get(i2);
      if (!TextUtils.isEmpty(((ApolloGameRoamData)localObject).tagUrl)) {
        break label111;
      }
      paramList1.add(i1, localObject);
    }
    for (;;)
    {
      i2 += 1;
      break label51;
      i1 += 1;
      break;
      label111:
      paramList1.add(0, localObject);
    }
    label123:
    paramList1.addAll(i1, paramList2);
  }
  
  /* Error */
  public void a(Map<String, ApolloPreDownloadData> paramMap, boolean paramBoolean)
  {
    // Byte code:
    //   0: iload_2
    //   1: ifeq +10 -> 11
    //   4: aload_0
    //   5: getfield 101	amir:jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   8: invokevirtual 377	java/util/concurrent/ConcurrentHashMap:clear	()V
    //   11: aload_0
    //   12: getfield 101	amir:jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   15: aload_1
    //   16: invokevirtual 838	java/util/concurrent/ConcurrentHashMap:putAll	(Ljava/util/Map;)V
    //   19: aload_0
    //   20: getfield 124	amir:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   23: invokevirtual 158	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/data/QQEntityManagerFactory;
    //   26: invokevirtual 164	com/tencent/mobileqq/data/QQEntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   29: astore 4
    //   31: aload 4
    //   33: ifnull +80 -> 113
    //   36: aload 4
    //   38: invokevirtual 337	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   41: astore_3
    //   42: aload_3
    //   43: invokevirtual 342	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   46: iload_2
    //   47: ifeq +12 -> 59
    //   50: aload 4
    //   52: ldc_w 840
    //   55: invokevirtual 679	com/tencent/mobileqq/persistence/EntityManager:execSQL	(Ljava/lang/String;)Z
    //   58: pop
    //   59: aload_1
    //   60: invokeinterface 846 1 0
    //   65: invokeinterface 849 1 0
    //   70: astore_1
    //   71: aload_1
    //   72: invokeinterface 262 1 0
    //   77: ifeq +37 -> 114
    //   80: aload 4
    //   82: aload_1
    //   83: invokeinterface 266 1 0
    //   88: checkcast 586	com/tencent/mobileqq/apollo/data/ApolloPreDownloadData
    //   91: invokevirtual 187	com/tencent/mobileqq/persistence/EntityManager:persist	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   94: goto -23 -> 71
    //   97: astore_1
    //   98: ldc_w 305
    //   101: iconst_1
    //   102: ldc_w 851
    //   105: aload_1
    //   106: invokestatic 367	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   109: aload_3
    //   110: invokevirtual 370	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   113: return
    //   114: aload_3
    //   115: invokevirtual 380	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   118: aload_3
    //   119: invokevirtual 370	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   122: return
    //   123: astore_1
    //   124: aload_3
    //   125: invokevirtual 370	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   128: aload_1
    //   129: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	130	0	this	amir
    //   0	130	1	paramMap	Map<String, ApolloPreDownloadData>
    //   0	130	2	paramBoolean	boolean
    //   41	84	3	localEntityTransaction	EntityTransaction
    //   29	52	4	localEntityManager	EntityManager
    // Exception table:
    //   from	to	target	type
    //   50	59	97	java/lang/Exception
    //   59	71	97	java/lang/Exception
    //   71	94	97	java/lang/Exception
    //   114	118	97	java/lang/Exception
    //   50	59	123	finally
    //   59	71	123	finally
    //   71	94	123	finally
    //   98	109	123	finally
    //   114	118	123	finally
  }
  
  public void a(JSONArray paramJSONArray)
  {
    if (paramJSONArray == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    int i1 = 0;
    for (;;)
    {
      try
      {
        if (i1 < paramJSONArray.length())
        {
          JSONObject localJSONObject = paramJSONArray.getJSONObject(i1);
          if (localJSONObject != null)
          {
            ApolloObtainedActionData localApolloObtainedActionData = new ApolloObtainedActionData();
            localApolloObtainedActionData.id = localJSONObject.optInt("id");
            localApolloObtainedActionData.beginTs = localJSONObject.optLong("beginTs");
            localApolloObtainedActionData.endts = localJSONObject.optLong("endts");
            localApolloObtainedActionData.way = localJSONObject.optInt("way");
            localApolloObtainedActionData.type = localJSONObject.optInt("type");
            localArrayList.add(localApolloObtainedActionData);
          }
        }
        else
        {
          f();
          k(localArrayList);
          return;
        }
      }
      catch (Exception paramJSONArray)
      {
        QLog.e("ApolloDaoManager", 1, "[saveApolloObtainedActionList] Exception =", paramJSONArray);
        return;
      }
      i1 += 1;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    ApolloActionPackage localApolloActionPackage = new ApolloActionPackage();
    localApolloActionPackage.packageId = 100;
    localApolloActionPackage.type = 100;
    localApolloActionPackage.isUpdate = paramBoolean;
    if (amio.c != null)
    {
      localApolloActionPackage.mIconUnselectedUrl = amio.c.optString("apImg");
      localApolloActionPackage.mIconSelectedUrl = amio.c.optString("apcImg");
      b(2);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(localApolloActionPackage);
      c(localArrayList);
      return;
    }
    QLog.e("ApolloDaoManager", 1, "updateGamePackageInfo sAioGameTabContent is not ready");
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void a(boolean paramBoolean, List<ApolloWhiteFaceID> paramList)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    if (localObject == null)
    {
      QLog.e("ApolloDaoManager", 1, "saveWhiteFaceIdMapping err em");
      return;
    }
    EntityTransaction localEntityTransaction = ((EntityManager)localObject).getTransaction();
    localEntityTransaction.begin();
    if (paramBoolean) {}
    try
    {
      paramList = ((EntityManager)localObject).query(ApolloWhiteFaceID.class);
      if (paramList != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloDaoManager", 2, new Object[] { "saveWhiteFaceIdMapping init size:", Integer.valueOf(paramList.size()) });
        }
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          localObject = (ApolloWhiteFaceID)paramList.next();
          this.jdField_f_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(((ApolloWhiteFaceID)localObject).terminalId), localObject);
        }
      }
    }
    catch (Exception paramList)
    {
      QLog.e("ApolloDaoManager", 1, "saveWhiteFaceIdMapping exception: ", paramList);
      return;
      if (paramList != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloDaoManager", 2, new Object[] { "saveWhiteFaceIdMapping save size:", Integer.valueOf(paramList.size()) });
        }
        ((EntityManager)localObject).execSQL(" DELETE FROM ApolloWhiteFaceID ");
        this.jdField_f_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          ApolloWhiteFaceID localApolloWhiteFaceID = (ApolloWhiteFaceID)paramList.next();
          this.jdField_f_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(localApolloWhiteFaceID.terminalId), localApolloWhiteFaceID);
          ((EntityManager)localObject).persist(localApolloWhiteFaceID);
        }
      }
    }
    finally
    {
      localEntityTransaction.end();
    }
    localEntityTransaction.end();
  }
  
  public boolean a(int paramInt)
  {
    if (this.jdField_f_of_type_JavaUtilList == null) {
      return false;
    }
    List localList = this.jdField_f_of_type_JavaUtilList;
    int i1 = 0;
    for (;;)
    {
      try
      {
        if (i1 >= this.jdField_f_of_type_JavaUtilList.size()) {
          break;
        }
        if (((ApolloGameRoamData)this.jdField_f_of_type_JavaUtilList.get(i1)).gameId == paramInt) {
          return true;
        }
      }
      finally {}
      i1 += 1;
    }
    return false;
  }
  
  public boolean a(AioPushData paramAioPushData)
  {
    boolean bool = false;
    if ((paramAioPushData != null) && (this.m != null)) {
      synchronized (this.m)
      {
        if (this.m.indexOf(paramAioPushData) >= 0) {
          bool = true;
        }
        return bool;
      }
    }
    return false;
  }
  
  public boolean a(ApolloGameRoamData paramApolloGameRoamData)
  {
    if (paramApolloGameRoamData == null) {
      return false;
    }
    Object localObject = h();
    if (localObject == null) {
      return false;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ApolloGameData localApolloGameData = (ApolloGameData)((Iterator)localObject).next();
      if ((localApolloGameData != null) && (localApolloGameData.gameId == paramApolloGameRoamData.gameId)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean a(EntityManager paramEntityManager, Entity paramEntity)
  {
    boolean bool = false;
    if (paramEntityManager.isOpen()) {
      if (paramEntity.getStatus() == 1000)
      {
        paramEntityManager.persistOrReplace(paramEntity);
        if (paramEntity.getStatus() == 1001) {
          bool = true;
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      return bool;
      if ((paramEntity.getStatus() == 1001) || (paramEntity.getStatus() == 1002)) {
        return paramEntityManager.update(paramEntity);
      }
    }
    QLog.d("ApolloDaoManager", 2, "updateEntity em closed e=" + paramEntity.getTableName());
    return false;
  }
  
  public boolean a(ArrayList<ApolloGameRoamData> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloDaoManager", 2, new Object[] { "[saveUserPlayedGameRoamData] userPlayedList=", paramArrayList });
    }
    if ((paramArrayList == null) || (paramArrayList.size() == 0) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      return false;
    }
    int i2 = paramArrayList.size();
    int i1 = 0;
    while (i1 < i2)
    {
      localObject1 = (ApolloGameRoamData)paramArrayList.get(i1);
      ((ApolloGameRoamData)localObject1).type = 2;
      if (QLog.isColorLevel()) {
        QLog.d("ApolloDaoManager", 2, new Object[] { "[saveUserPlayedGameRoamData] userPlayedList[", Integer.valueOf(i1), "], gameId=", Integer.valueOf(((ApolloGameRoamData)localObject1).gameId) });
      }
      i1 += 1;
    }
    ??? = new ArrayList();
    Object localObject1 = null;
    if (this.jdField_f_of_type_JavaUtilList != null) {}
    label694:
    label753:
    label884:
    label893:
    for (;;)
    {
      Object localObject4;
      int i3;
      ApolloGameRoamData localApolloGameRoamData1;
      synchronized (this.jdField_f_of_type_JavaUtilList)
      {
        if (this.jdField_f_of_type_JavaUtilList.size() > 0)
        {
          localObject1 = new ArrayList();
          int i4 = paramArrayList.size();
          i2 = 0;
          i1 = 0;
          if (i2 < i4)
          {
            localObject4 = (ApolloGameRoamData)paramArrayList.get(i2);
            int i5 = this.jdField_f_of_type_JavaUtilList.size();
            i3 = 0;
            i1 = 0;
            if (i3 >= i5) {
              break label877;
            }
            localApolloGameRoamData1 = (ApolloGameRoamData)this.jdField_f_of_type_JavaUtilList.get(i3);
            if (((ApolloGameRoamData)localObject4).gameId == localApolloGameRoamData1.gameId)
            {
              localApolloGameRoamData1.type = 2;
              ((ArrayList)???).add(localApolloGameRoamData1);
              break label877;
            }
            if (i3 == i5 - 1) {
              ((ArrayList)localObject1).add(localObject4);
            }
            if (TextUtils.isEmpty(localApolloGameRoamData1.tagUrl)) {
              break label868;
            }
            i1 += 1;
            break label884;
          }
          if ((localObject1 == null) || (((ArrayList)localObject1).size() <= 0)) {
            break label893;
          }
          i3 = ((ArrayList)localObject1).size();
          i2 = 0;
          if (i2 >= i3) {
            break label893;
          }
          localObject4 = (ApolloGameRoamData)((ArrayList)localObject1).get(i2);
          this.jdField_f_of_type_JavaUtilList.add(i2 + i1, localObject4);
          i2 += 1;
          continue;
          localObject4 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
          if (localObject4 == null) {
            break label694;
          }
          ??? = ((EntityManager)localObject4).getTransaction();
          ((EntityTransaction)???).begin();
          if (localObject1 == null) {
            break label753;
          }
        }
      }
      try
      {
        if (((ArrayList)localObject1).size() > 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ApolloDaoManager", 2, "[saveUserPlayedGameRoamData] clear and rewrite game list");
          }
          ((EntityManager)localObject4).execSQL(" DELETE FROM ApolloGameRoamData ");
          if (this.jdField_f_of_type_JavaUtilList != null) {}
          synchronized (this.jdField_f_of_type_JavaUtilList)
          {
            paramArrayList = new ArrayList(this.jdField_f_of_type_JavaUtilList.size());
            paramArrayList.addAll(this.jdField_f_of_type_JavaUtilList);
            ??? = new StringBuilder();
            i2 = paramArrayList.size();
            i1 = 0;
            for (;;)
            {
              if (i1 < i2)
              {
                localApolloGameRoamData1 = (ApolloGameRoamData)paramArrayList.get(i1);
                ApolloGameRoamData localApolloGameRoamData2 = new ApolloGameRoamData();
                localApolloGameRoamData2.gameId = localApolloGameRoamData1.gameId;
                localApolloGameRoamData2.type = localApolloGameRoamData1.type;
                localApolloGameRoamData2.tagUrl = localApolloGameRoamData1.tagUrl;
                localApolloGameRoamData2.tagType = localApolloGameRoamData1.tagType;
                localApolloGameRoamData2.tagBegTs = localApolloGameRoamData1.tagBegTs;
                localApolloGameRoamData2.tagEndTs = localApolloGameRoamData1.tagEndTs;
                a((EntityManager)localObject4, localApolloGameRoamData2);
                ((StringBuilder)???).append("gameId:").append(localApolloGameRoamData2.gameId).append(",type:").append(localApolloGameRoamData2.type).append(",");
                i1 += 1;
                continue;
                a(this.jdField_f_of_type_JavaUtilList, paramArrayList);
                ((ArrayList)???).addAll(paramArrayList);
                h(paramArrayList);
                break;
                paramArrayList = finally;
                throw paramArrayList;
              }
            }
          }
        }
        return false;
      }
      catch (Exception paramArrayList)
      {
        QLog.e("ApolloDaoManager", 1, "[saveUserPlayedGameRoamData] update db error=", paramArrayList);
        ((EntityTransaction)???).end();
        if ((localObject1 != null) && (((ArrayList)localObject1).size() != 0))
        {
          return true;
          if (QLog.isColorLevel()) {
            QLog.d("ApolloDaoManager", 2, new Object[] { "[saveUserPlayedGameRoamData] add game ", ((StringBuilder)???).toString() });
          }
          for (;;)
          {
            ((EntityTransaction)???).commit();
            ((EntityTransaction)???).end();
            break;
            if (QLog.isColorLevel()) {
              QLog.d("ApolloDaoManager", 2, "[saveUserPlayedGameRoamData] just update type");
            }
            paramArrayList = ((ArrayList)???).iterator();
            while (paramArrayList.hasNext())
            {
              ??? = (ApolloGameRoamData)paramArrayList.next();
              a((EntityManager)localObject4, (Entity)???);
              if (QLog.isColorLevel()) {
                QLog.d("ApolloDaoManager", 2, new Object[] { "[saveUserPlayedGameRoamData] update game, id=", Integer.valueOf(((ApolloGameRoamData)???).gameId), ", type=", Integer.valueOf(((ApolloGameRoamData)???).type) });
              }
            }
          }
        }
      }
      finally
      {
        ((EntityTransaction)???).end();
      }
      break label884;
      localObject1 = null;
      continue;
      i2 += 1;
      continue;
      i3 += 1;
    }
  }
  
  public ApolloActionData b(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return null;
    }
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0)) {
      for (;;)
      {
        int i1;
        synchronized (this.jdField_a_of_type_JavaUtilList)
        {
          i1 = this.jdField_a_of_type_JavaUtilList.size() - 1;
          if (i1 < 0) {
            break;
          }
          ApolloActionData localApolloActionData = (ApolloActionData)this.jdField_a_of_type_JavaUtilList.get(i1);
          if ((localApolloActionData != null) && (localApolloActionData.actionId == paramInt)) {
            return localApolloActionData;
          }
        }
        i1 -= 1;
      }
    }
    for (;;)
    {
      return null;
      if (QLog.isColorLevel()) {
        QLog.e("ApolloDaoManager", 2, new Object[] { "[findActionInCache] actionList no action:", Integer.valueOf(paramInt) });
      }
    }
  }
  
  public ApolloGameData b(int paramInt)
  {
    if (paramInt <= 0) {
      return null;
    }
    List localList;
    if (this.jdField_e_of_type_JavaUtilList != null)
    {
      localList = this.jdField_e_of_type_JavaUtilList;
      int i1 = 0;
      for (;;)
      {
        try
        {
          if (i1 >= this.jdField_e_of_type_JavaUtilList.size()) {
            break;
          }
          if (((ApolloGameData)this.jdField_e_of_type_JavaUtilList.get(i1)).gameId == paramInt)
          {
            ApolloGameData localApolloGameData = (ApolloGameData)this.jdField_e_of_type_JavaUtilList.get(i1);
            return localApolloGameData;
          }
        }
        finally {}
        i1 += 1;
      }
    }
    return null;
  }
  
  public Pair<List<ApolloActionPackageData>, List<ApolloActionData>> b()
  {
    QLog.d("ApolloDaoManager", 1, "getRecommendActionList");
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ApolloRecommendAction localApolloRecommendAction;
    ApolloActionData localApolloActionData;
    List localList2;
    synchronized (this.l)
    {
      Iterator localIterator = this.l.iterator();
      if (!localIterator.hasNext()) {
        break label219;
      }
      localApolloRecommendAction = (ApolloRecommendAction)localIterator.next();
      localApolloActionData = c(localApolloRecommendAction.id);
      localList2 = f(localApolloRecommendAction.id);
      if ((localApolloActionData != null) && (localList2 != null) && (localList2.size() > 0))
      {
        localArrayList2.add(localApolloActionData);
        localArrayList1.add(localList2.get(0));
      }
    }
    Object localObject2 = "";
    if (localApolloActionData == null) {
      localObject2 = " actionData null";
    }
    if ((localList2 != null) && (localList2.size() != 0)) {}
    for (;;)
    {
      QLog.d("ApolloDaoManager", 1, new Object[] { "getRecommendActionList, invalid, actionId=", Integer.valueOf(localApolloRecommendAction.id), ", reason=", localObject2 });
      break;
      label219:
      localObject2 = new StringBuilder();
      int i2 = localArrayList2.size();
      int i1 = 0;
      while (i1 < i2)
      {
        ((StringBuilder)localObject2).append(((ApolloActionData)localArrayList2.get(i1)).actionId);
        if (i1 != i2 - 1) {
          ((StringBuilder)localObject2).append(",");
        }
        i1 += 1;
      }
      QLog.d("ApolloDaoManager", 1, new Object[] { "getRecommendActionList, actionIdList=", ((StringBuilder)localObject2).toString() });
      return new Pair(localArrayList1, localArrayList2);
      localObject2 = " no actionset data";
    }
  }
  
  public List<ApolloActionData> b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return null;
    }
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0)) {}
    for (;;)
    {
      int i1;
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        ArrayList localArrayList = new ArrayList();
        i1 = 0;
        if (i1 < this.jdField_a_of_type_JavaUtilList.size())
        {
          if (((ApolloActionData)this.jdField_a_of_type_JavaUtilList.get(i1)).isShow != 0) {
            break label170;
          }
          localArrayList.add(this.jdField_a_of_type_JavaUtilList.get(i1));
          break label170;
        }
        if ((localArrayList != null) && (localArrayList.size() > 0)) {
          return localArrayList;
        }
        ??? = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
        if (??? != null) {
          return ((EntityManager)???).query(ApolloActionData.class, false, "isShow=?", new String[] { String.valueOf(0) }, null, null, null, null);
        }
      }
      return new ArrayList();
      label170:
      i1 += 1;
    }
  }
  
  public List<ApolloActionData> b(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return null;
    }
    List localList = d(paramInt);
    if ((localList != null) && (localList.size() > 0))
    {
      ArrayList localArrayList = new ArrayList();
      paramInt = 0;
      while (paramInt < localList.size())
      {
        if ((((ApolloActionData)localList.get(paramInt)).status == 0) && (((ApolloActionData)localList.get(paramInt)).isShow == 1)) {
          localArrayList.add(localList.get(paramInt));
        }
        paramInt += 1;
      }
      if ((localArrayList != null) && (localArrayList.size() > 0)) {
        return localArrayList;
      }
    }
    return null;
  }
  
  public ConcurrentHashMap<Integer, ApolloActionData> b()
  {
    if ((this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.size() > 0)) {
      return this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap;
    }
    Object localObject = g(6);
    if (this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
      this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    }
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ApolloObtainedActionData localApolloObtainedActionData = (ApolloObtainedActionData)((Iterator)localObject).next();
        if ((!b(localApolloObtainedActionData.id)) && (localApolloObtainedActionData.endts >= NetConnInfoCenter.getServerTime()))
        {
          ApolloActionData localApolloActionData = new ApolloActionData();
          localApolloActionData.actionId = localApolloObtainedActionData.id;
          localApolloActionData.limitStart = localApolloObtainedActionData.beginTs;
          localApolloActionData.limitEnd = localApolloObtainedActionData.endts;
          this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(localApolloActionData.actionId), localApolloActionData);
        }
      }
    }
    return this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    EntityManager localEntityManager;
    List localList;
    for (;;)
    {
      return;
      QLog.i("ApolloDaoManager", 1, "removeAllAction");
      if (this.jdField_a_of_type_JavaUtilList != null) {}
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        this.jdField_a_of_type_JavaUtilList.clear();
        if (this.jdField_g_of_type_JavaUtilConcurrentConcurrentHashMap != null)
        {
          this.jdField_g_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
          this.jdField_a_of_type_Int = 1;
        }
        localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
        if (localEntityManager != null)
        {
          localList = localEntityManager.query(ApolloActionData.class);
          if (localList != null) {
            ??? = localEntityManager.getTransaction();
          }
        }
      }
    }
    try
    {
      ((EntityTransaction)???).begin();
      int i1 = 0;
      while (i1 < localList.size())
      {
        ApolloActionData localApolloActionData = (ApolloActionData)localList.get(i1);
        if (localApolloActionData != null) {
          localEntityManager.remove(localApolloActionData);
        }
        i1 += 1;
        continue;
        localObject2 = finally;
        throw localObject2;
      }
      ((EntityTransaction)???).commit();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return;
    }
    finally
    {
      ((EntityTransaction)???).end();
    }
  }
  
  /* Error */
  public void b(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 124	amir:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4: ifnonnull +4 -> 8
    //   7: return
    //   8: aload_0
    //   9: getfield 66	amir:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   12: ifnull +125 -> 137
    //   15: aload_0
    //   16: getfield 66	amir:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   19: astore 7
    //   21: aload 7
    //   23: monitorenter
    //   24: iconst_1
    //   25: iload_1
    //   26: if_icmpne +165 -> 191
    //   29: aload_0
    //   30: getfield 66	amir:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   33: invokeinterface 256 1 0
    //   38: astore 5
    //   40: aload 5
    //   42: invokeinterface 262 1 0
    //   47: ifeq +339 -> 386
    //   50: aload 5
    //   52: invokeinterface 266 1 0
    //   57: checkcast 295	com/tencent/mobileqq/data/ApolloActionPackage
    //   60: astore 6
    //   62: aload 6
    //   64: ifnull -24 -> 40
    //   67: aload 6
    //   69: getfield 298	com/tencent/mobileqq/data/ApolloActionPackage:packageId	I
    //   72: bipush 100
    //   74: if_icmpne -34 -> 40
    //   77: aload 6
    //   79: invokevirtual 1037	com/tencent/mobileqq/data/ApolloActionPackage:getCopy	()Lcom/tencent/mobileqq/data/ApolloActionPackage;
    //   82: astore 6
    //   84: aload 6
    //   86: astore 5
    //   88: invokestatic 303	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   91: ifeq +17 -> 108
    //   94: ldc_w 305
    //   97: iconst_2
    //   98: ldc_w 1039
    //   101: invokestatic 310	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   104: aload 6
    //   106: astore 5
    //   108: aload_0
    //   109: getfield 66	amir:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   112: invokeinterface 373 1 0
    //   117: aload 5
    //   119: ifnull +15 -> 134
    //   122: aload_0
    //   123: getfield 66	amir:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   126: aload 5
    //   128: invokeinterface 278 2 0
    //   133: pop
    //   134: aload 7
    //   136: monitorexit
    //   137: aload_0
    //   138: getfield 124	amir:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   141: invokevirtual 158	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/data/QQEntityManagerFactory;
    //   144: invokevirtual 164	com/tencent/mobileqq/data/QQEntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   147: astore 6
    //   149: aload 6
    //   151: ifnull -144 -> 7
    //   154: aload 6
    //   156: invokevirtual 337	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   159: astore 5
    //   161: aload 5
    //   163: invokevirtual 342	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   166: iconst_1
    //   167: iload_1
    //   168: if_icmpne +178 -> 346
    //   171: aload 6
    //   173: ldc_w 1041
    //   176: invokevirtual 679	com/tencent/mobileqq/persistence/EntityManager:execSQL	(Ljava/lang/String;)Z
    //   179: pop
    //   180: aload 5
    //   182: invokevirtual 380	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   185: aload 5
    //   187: invokevirtual 370	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   190: return
    //   191: iconst_2
    //   192: iload_1
    //   193: if_icmpne -59 -> 134
    //   196: iconst_m1
    //   197: istore_2
    //   198: aload_0
    //   199: getfield 66	amir:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   202: invokeinterface 256 1 0
    //   207: astore 5
    //   209: iload_2
    //   210: istore 4
    //   212: aload 5
    //   214: invokeinterface 262 1 0
    //   219: ifeq +77 -> 296
    //   222: aload 5
    //   224: invokeinterface 266 1 0
    //   229: checkcast 295	com/tencent/mobileqq/data/ApolloActionPackage
    //   232: astore 6
    //   234: iload_2
    //   235: iconst_1
    //   236: iadd
    //   237: istore_3
    //   238: iload_3
    //   239: istore_2
    //   240: aload 6
    //   242: ifnull -33 -> 209
    //   245: iload_3
    //   246: istore_2
    //   247: aload 6
    //   249: getfield 298	com/tencent/mobileqq/data/ApolloActionPackage:packageId	I
    //   252: bipush 100
    //   254: if_icmpne -45 -> 209
    //   257: iload_3
    //   258: istore 4
    //   260: invokestatic 303	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   263: ifeq +33 -> 296
    //   266: ldc_w 305
    //   269: iconst_2
    //   270: new 312	java/lang/StringBuilder
    //   273: dup
    //   274: invokespecial 313	java/lang/StringBuilder:<init>	()V
    //   277: ldc_w 1043
    //   280: invokevirtual 319	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: iload_3
    //   284: invokevirtual 322	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   287: invokevirtual 325	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   290: invokestatic 310	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   293: iload_3
    //   294: istore 4
    //   296: iload 4
    //   298: ifle -164 -> 134
    //   301: aload_0
    //   302: getfield 66	amir:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   305: iload 4
    //   307: invokeinterface 293 2 0
    //   312: checkcast 295	com/tencent/mobileqq/data/ApolloActionPackage
    //   315: getfield 298	com/tencent/mobileqq/data/ApolloActionPackage:packageId	I
    //   318: bipush 100
    //   320: if_icmpne -186 -> 134
    //   323: aload_0
    //   324: getfield 66	amir:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   327: iload 4
    //   329: invokeinterface 327 2 0
    //   334: pop
    //   335: goto -201 -> 134
    //   338: astore 5
    //   340: aload 7
    //   342: monitorexit
    //   343: aload 5
    //   345: athrow
    //   346: iconst_2
    //   347: iload_1
    //   348: if_icmpne -168 -> 180
    //   351: aload 6
    //   353: ldc_w 1045
    //   356: invokevirtual 679	com/tencent/mobileqq/persistence/EntityManager:execSQL	(Ljava/lang/String;)Z
    //   359: pop
    //   360: goto -180 -> 180
    //   363: astore 6
    //   365: aload 6
    //   367: invokevirtual 682	java/lang/Exception:printStackTrace	()V
    //   370: aload 5
    //   372: invokevirtual 370	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   375: return
    //   376: astore 6
    //   378: aload 5
    //   380: invokevirtual 370	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   383: aload 6
    //   385: athrow
    //   386: aconst_null
    //   387: astore 5
    //   389: goto -281 -> 108
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	392	0	this	amir
    //   0	392	1	paramInt	int
    //   197	50	2	i1	int
    //   237	57	3	i2	int
    //   210	118	4	i3	int
    //   38	185	5	localObject1	Object
    //   338	41	5	localObject2	Object
    //   387	1	5	localObject3	Object
    //   60	292	6	localObject4	Object
    //   363	3	6	localException	Exception
    //   376	8	6	localObject5	Object
    //   19	322	7	localList	List
    // Exception table:
    //   from	to	target	type
    //   29	40	338	finally
    //   40	62	338	finally
    //   67	84	338	finally
    //   88	104	338	finally
    //   108	117	338	finally
    //   122	134	338	finally
    //   134	137	338	finally
    //   198	209	338	finally
    //   212	234	338	finally
    //   247	257	338	finally
    //   260	293	338	finally
    //   301	335	338	finally
    //   340	343	338	finally
    //   161	166	363	java/lang/Exception
    //   171	180	363	java/lang/Exception
    //   180	185	363	java/lang/Exception
    //   351	360	363	java/lang/Exception
    //   161	166	376	finally
    //   171	180	376	finally
    //   180	185	376	finally
    //   351	360	376	finally
    //   365	370	376	finally
  }
  
  public void b(AioPushData paramAioPushData)
  {
    if ((paramAioPushData == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      QLog.e("ApolloDaoManager", 1, "[removeAioPushData] app or data is null");
    }
    Object localObject2;
    do
    {
      return;
      if (this.m != null) {
        synchronized (this.m)
        {
          localObject2 = this.m.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            AioPushData localAioPushData = (AioPushData)((Iterator)localObject2).next();
            if (localAioPushData.equals(paramAioPushData)) {
              localAioPushData.isShow = true;
            }
          }
        }
      }
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    } while (localObject2 == null);
    ??? = ((EntityManager)localObject2).getTransaction();
    ((EntityTransaction)???).begin();
    try
    {
      paramAioPushData.isShow = true;
      boolean bool = ((EntityManager)localObject2).update(paramAioPushData);
      if (QLog.isColorLevel()) {
        QLog.d("ApolloDaoManager", 2, "[removeAioPushData] " + String.valueOf(bool) + " # " + paramAioPushData);
      }
      ((EntityTransaction)???).commit();
      return;
    }
    catch (Exception paramAioPushData)
    {
      QLog.e("ApolloDaoManager", 1, "removeAioPushData errInfo-> " + paramAioPushData.getMessage());
      return;
    }
    finally
    {
      ((EntityTransaction)???).end();
    }
  }
  
  public void b(ApolloActionData paramApolloActionData)
  {
    if ((paramApolloActionData == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {}
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_JavaUtilList != null) {}
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        int i1 = this.jdField_a_of_type_JavaUtilList.size() - 1;
        if (i1 >= 0)
        {
          if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.get(i1) != null) && (((ApolloActionData)this.jdField_a_of_type_JavaUtilList.get(i1)).actionId == paramApolloActionData.actionId))
          {
            this.jdField_a_of_type_JavaUtilList.remove(i1);
            this.jdField_a_of_type_JavaUtilList.add(i1, paramApolloActionData);
          }
        }
        else
        {
          ??? = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
          if (??? == null) {
            continue;
          }
          ((EntityManager)???).update(paramApolloActionData);
          return;
        }
        i1 -= 1;
      }
    }
  }
  
  public void b(ApolloFavActionData paramApolloFavActionData)
  {
    if (paramApolloFavActionData == null) {}
    for (;;)
    {
      return;
      if (this.jdField_d_of_type_JavaUtilList != null) {}
      synchronized (this.jdField_d_of_type_JavaUtilList)
      {
        int i1 = this.jdField_d_of_type_JavaUtilList.size() - 1;
        if (i1 >= 0)
        {
          if (((ApolloFavActionData)this.jdField_d_of_type_JavaUtilList.get(i1)).favId == paramApolloFavActionData.favId) {
            this.jdField_d_of_type_JavaUtilList.remove(i1);
          }
        }
        else
        {
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
            continue;
          }
          ??? = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
          if (??? == null) {
            continue;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ApolloDaoManager", 2, "insert ApolloFavActionData id=" + paramApolloFavActionData.toString());
          }
          ((EntityManager)???).remove(paramApolloFavActionData);
          return;
        }
        i1 -= 1;
      }
    }
  }
  
  /* Error */
  public void b(EntityManager paramEntityManager, List<ApolloGameRankData> paramList)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +134 -> 135
    //   4: aload_2
    //   5: ifnull +130 -> 135
    //   8: aload_2
    //   9: invokeinterface 281 1 0
    //   14: ifle +121 -> 135
    //   17: aload_0
    //   18: getfield 97	amir:k	Ljava/util/List;
    //   21: ifnull +114 -> 135
    //   24: aload_0
    //   25: getfield 97	amir:k	Ljava/util/List;
    //   28: astore_3
    //   29: aload_3
    //   30: monitorenter
    //   31: aload_0
    //   32: getfield 97	amir:k	Ljava/util/List;
    //   35: aload_2
    //   36: invokeinterface 288 2 0
    //   41: pop
    //   42: aload_0
    //   43: getfield 97	amir:k	Ljava/util/List;
    //   46: aload_2
    //   47: invokeinterface 376 2 0
    //   52: pop
    //   53: aload_3
    //   54: monitorexit
    //   55: aload_2
    //   56: invokeinterface 256 1 0
    //   61: astore_2
    //   62: aload_2
    //   63: invokeinterface 262 1 0
    //   68: ifeq +67 -> 135
    //   71: aload_2
    //   72: invokeinterface 266 1 0
    //   77: checkcast 549	com/tencent/mobileqq/data/ApolloGameRankData
    //   80: astore_3
    //   81: aload_1
    //   82: aload_3
    //   83: invokevirtual 784	com/tencent/mobileqq/persistence/EntityManager:persistOrReplace	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   86: invokestatic 303	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   89: ifeq -27 -> 62
    //   92: ldc_w 305
    //   95: iconst_2
    //   96: iconst_2
    //   97: anewarray 4	java/lang/Object
    //   100: dup
    //   101: iconst_0
    //   102: ldc_w 1059
    //   105: aastore
    //   106: dup
    //   107: iconst_1
    //   108: aload_3
    //   109: aastore
    //   110: invokestatic 427	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   113: goto -51 -> 62
    //   116: astore_1
    //   117: ldc_w 305
    //   120: iconst_1
    //   121: aload_1
    //   122: iconst_1
    //   123: anewarray 4	java/lang/Object
    //   126: dup
    //   127: iconst_0
    //   128: ldc_w 1061
    //   131: aastore
    //   132: invokestatic 1064	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   135: return
    //   136: astore_1
    //   137: aload_3
    //   138: monitorexit
    //   139: aload_1
    //   140: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	141	0	this	amir
    //   0	141	1	paramEntityManager	EntityManager
    //   0	141	2	paramList	List<ApolloGameRankData>
    // Exception table:
    //   from	to	target	type
    //   24	31	116	java/lang/Throwable
    //   55	62	116	java/lang/Throwable
    //   62	113	116	java/lang/Throwable
    //   139	141	116	java/lang/Throwable
    //   31	55	136	finally
    //   137	139	136	finally
  }
  
  /* Error */
  public void b(ArrayList<ApolloGameRoamData> paramArrayList)
  {
    // Byte code:
    //   0: invokestatic 303	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +13 -> 16
    //   6: ldc_w 305
    //   9: iconst_2
    //   10: ldc_w 1067
    //   13: invokestatic 310	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   16: aload_1
    //   17: ifnull +10 -> 27
    //   20: aload_1
    //   21: invokevirtual 789	java/util/ArrayList:size	()I
    //   24: ifne +14 -> 38
    //   27: ldc_w 305
    //   30: iconst_1
    //   31: ldc_w 1069
    //   34: invokestatic 1072	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   37: return
    //   38: ldc_w 305
    //   41: iconst_1
    //   42: new 312	java/lang/StringBuilder
    //   45: dup
    //   46: invokespecial 313	java/lang/StringBuilder:<init>	()V
    //   49: ldc_w 1074
    //   52: invokevirtual 319	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: aload_1
    //   56: invokevirtual 789	java/util/ArrayList:size	()I
    //   59: invokevirtual 322	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   62: invokevirtual 325	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   65: invokestatic 611	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   68: aload_0
    //   69: getfield 74	amir:jdField_f_of_type_JavaUtilList	Ljava/util/List;
    //   72: ifnull +29 -> 101
    //   75: aload_0
    //   76: getfield 74	amir:jdField_f_of_type_JavaUtilList	Ljava/util/List;
    //   79: astore_2
    //   80: aload_2
    //   81: monitorenter
    //   82: aload_0
    //   83: getfield 74	amir:jdField_f_of_type_JavaUtilList	Ljava/util/List;
    //   86: iconst_0
    //   87: aload_1
    //   88: invokeinterface 835 3 0
    //   93: pop
    //   94: aload_0
    //   95: aload_1
    //   96: invokevirtual 977	amir:h	(Ljava/util/List;)V
    //   99: aload_2
    //   100: monitorexit
    //   101: aload_0
    //   102: getfield 124	amir:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   105: ifnull -68 -> 37
    //   108: aload_0
    //   109: getfield 124	amir:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   112: invokevirtual 158	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/data/QQEntityManagerFactory;
    //   115: invokevirtual 164	com/tencent/mobileqq/data/QQEntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   118: astore_3
    //   119: aload_3
    //   120: ifnull -83 -> 37
    //   123: aload_3
    //   124: invokevirtual 337	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   127: astore_2
    //   128: aload_2
    //   129: invokevirtual 342	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   132: new 312	java/lang/StringBuilder
    //   135: dup
    //   136: sipush 500
    //   139: invokespecial 345	java/lang/StringBuilder:<init>	(I)V
    //   142: astore 4
    //   144: aload_1
    //   145: invokevirtual 547	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   148: astore_1
    //   149: aload_1
    //   150: invokeinterface 262 1 0
    //   155: ifeq +76 -> 231
    //   158: aload_1
    //   159: invokeinterface 266 1 0
    //   164: checkcast 762	com/tencent/mobileqq/data/ApolloGameRoamData
    //   167: astore 5
    //   169: aload_0
    //   170: aload_3
    //   171: aload 5
    //   173: invokevirtual 352	amir:a	(Lcom/tencent/mobileqq/persistence/EntityManager;Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   176: pop
    //   177: invokestatic 303	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   180: ifeq -31 -> 149
    //   183: aload 4
    //   185: ldc_w 1076
    //   188: invokevirtual 319	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: aload 5
    //   193: getfield 763	com/tencent/mobileqq/data/ApolloGameRoamData:gameId	I
    //   196: invokevirtual 322	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   199: pop
    //   200: goto -51 -> 149
    //   203: astore_1
    //   204: invokestatic 303	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   207: ifeq +14 -> 221
    //   210: ldc_w 305
    //   213: iconst_2
    //   214: ldc_w 1078
    //   217: aload_1
    //   218: invokestatic 801	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   221: aload_2
    //   222: invokevirtual 370	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   225: return
    //   226: astore_1
    //   227: aload_2
    //   228: monitorexit
    //   229: aload_1
    //   230: athrow
    //   231: aload 4
    //   233: invokevirtual 358	java/lang/StringBuilder:length	()I
    //   236: sipush 500
    //   239: if_icmpge +21 -> 260
    //   242: invokestatic 303	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   245: ifeq +15 -> 260
    //   248: ldc_w 305
    //   251: iconst_2
    //   252: aload 4
    //   254: invokevirtual 325	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   257: invokestatic 310	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   260: aload_2
    //   261: invokevirtual 380	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   264: aload_2
    //   265: invokevirtual 370	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   268: return
    //   269: astore_1
    //   270: aload_2
    //   271: invokevirtual 370	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   274: aload_1
    //   275: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	276	0	this	amir
    //   0	276	1	paramArrayList	ArrayList<ApolloGameRoamData>
    //   79	192	2	localObject	Object
    //   118	53	3	localEntityManager	EntityManager
    //   142	111	4	localStringBuilder	StringBuilder
    //   167	25	5	localApolloGameRoamData	ApolloGameRoamData
    // Exception table:
    //   from	to	target	type
    //   132	149	203	java/lang/Exception
    //   149	200	203	java/lang/Exception
    //   231	260	203	java/lang/Exception
    //   260	264	203	java/lang/Exception
    //   82	101	226	finally
    //   227	229	226	finally
    //   132	149	269	finally
    //   149	200	269	finally
    //   204	221	269	finally
    //   231	260	269	finally
    //   260	264	269	finally
  }
  
  public void b(List<ApolloActionData> paramList)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (paramList == null)) {
      return;
    }
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramList != null)) {}
    for (;;)
    {
      int i1;
      int i2;
      EntityManager localEntityManager;
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        i1 = this.jdField_a_of_type_JavaUtilList.size() - 1;
        if (i1 >= 0)
        {
          i2 = paramList.size() - 1;
          if (i2 <= 0) {
            break label230;
          }
          if (((ApolloActionData)paramList.get(i2)).actionId != ((ApolloActionData)this.jdField_a_of_type_JavaUtilList.get(i1)).actionId) {
            break label223;
          }
          this.jdField_a_of_type_JavaUtilList.remove(i1);
          this.jdField_a_of_type_JavaUtilList.add(i1, paramList.get(i2));
          break label223;
        }
        localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
        ??? = localEntityManager.getTransaction();
      }
      try
      {
        ((EntityTransaction)???).begin();
        i1 = 0;
        while (i1 < paramList.size())
        {
          a(localEntityManager, (Entity)paramList.get(i1));
          i1 += 1;
          continue;
          paramList = finally;
          throw paramList;
        }
        ((EntityTransaction)???).commit();
        return;
      }
      catch (Exception paramList)
      {
        paramList.printStackTrace();
        return;
      }
      finally
      {
        ((EntityTransaction)???).end();
      }
      label223:
      i2 -= 1;
      continue;
      label230:
      i1 -= 1;
    }
  }
  
  public boolean b(int paramInt)
  {
    return a().containsKey(Integer.valueOf(paramInt));
  }
  
  public ApolloActionData c(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return null;
    }
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0)) {
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext())
        {
          ApolloActionData localApolloActionData = (ApolloActionData)localIterator.next();
          if (localApolloActionData.actionId == paramInt) {
            return localApolloActionData;
          }
        }
      }
    }
    return null;
  }
  
  public List<ApolloActionData> c()
  {
    label122:
    for (;;)
    {
      try
      {
        Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        if (localObject1 == null)
        {
          localObject1 = null;
          return localObject1;
        }
        List localList = (List)a().second;
        int i1;
        if ((localList != null) && (localList.size() > 0))
        {
          localObject1 = new ArrayList();
          i1 = 0;
          if (i1 < localList.size())
          {
            if (((ApolloActionData)localList.get(i1)).status != 0) {
              break label122;
            }
            ((List)localObject1).add(localList.get(i1));
            break label122;
          }
          if (localObject1 != null)
          {
            i1 = ((List)localObject1).size();
            if (i1 > 0) {
              continue;
            }
          }
        }
        localObject1 = null;
        continue;
        i1 += 1;
      }
      finally {}
    }
  }
  
  public List<ApolloActionPackage> c(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    Object localObject2;
    do
    {
      return null;
      if ((paramInt == 0) || (paramInt == 1)) {
        localObject1 = String.valueOf(paramInt);
      }
      while ((this.jdField_b_of_type_JavaUtilList != null) && (this.jdField_b_of_type_JavaUtilList.size() > 0))
      {
        localObject2 = new ArrayList();
        paramInt = 0;
        for (;;)
        {
          if (paramInt < this.jdField_b_of_type_JavaUtilList.size())
          {
            if ((((ApolloActionPackage)this.jdField_b_of_type_JavaUtilList.get(paramInt)).sessionType == Integer.parseInt((String)localObject1)) || (((ApolloActionPackage)this.jdField_b_of_type_JavaUtilList.get(paramInt)).sessionType == 0)) {
              ((List)localObject2).add(this.jdField_b_of_type_JavaUtilList.get(paramInt));
            }
            paramInt += 1;
            continue;
            if (paramInt == 3000)
            {
              localObject1 = String.valueOf(1);
              break;
            }
            QLog.e("ApolloDaoManager", 1, "[getPackageInfoBySession], error type:" + paramInt);
            return null;
          }
        }
        if ((localObject2 != null) && (((List)localObject2).size() > 0))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ApolloDaoManager", 2, "return packageInfoBySession from cache");
          }
          j((List)localObject2);
          return localObject2;
        }
      }
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    } while (localObject2 == null);
    Object localObject1 = ((EntityManager)localObject2).query(ApolloActionPackage.class, false, "sessionType=? or sessionType=?", new String[] { "0", localObject1 }, null, null, null, null);
    j((List)localObject1);
    return localObject1;
  }
  
  public ConcurrentHashMap<Integer, ApolloGameRoamData> c()
  {
    if (this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
      return new ConcurrentHashMap();
    }
    return this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap;
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloDaoManager", 2, "[removeGameRoamData]");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    for (;;)
    {
      return;
      if (this.jdField_f_of_type_JavaUtilList != null) {}
      EntityManager localEntityManager;
      synchronized (this.jdField_f_of_type_JavaUtilList)
      {
        this.jdField_f_of_type_JavaUtilList.clear();
        if (this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
          this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
        }
        localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
        if (localEntityManager == null) {
          continue;
        }
        ??? = localEntityManager.getTransaction();
      }
    }
  }
  
  /* Error */
  public void c(EntityManager paramEntityManager, List<ApolloGameRankData> paramList)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +124 -> 125
    //   4: aload_2
    //   5: ifnull +120 -> 125
    //   8: aload_2
    //   9: invokeinterface 281 1 0
    //   14: ifle +111 -> 125
    //   17: aload_0
    //   18: getfield 97	amir:k	Ljava/util/List;
    //   21: ifnull +104 -> 125
    //   24: aload_0
    //   25: getfield 97	amir:k	Ljava/util/List;
    //   28: astore_3
    //   29: aload_3
    //   30: monitorenter
    //   31: aload_0
    //   32: getfield 97	amir:k	Ljava/util/List;
    //   35: aload_2
    //   36: invokeinterface 288 2 0
    //   41: pop
    //   42: aload_3
    //   43: monitorexit
    //   44: aload_2
    //   45: invokeinterface 256 1 0
    //   50: astore_2
    //   51: aload_2
    //   52: invokeinterface 262 1 0
    //   57: ifeq +68 -> 125
    //   60: aload_2
    //   61: invokeinterface 266 1 0
    //   66: checkcast 549	com/tencent/mobileqq/data/ApolloGameRankData
    //   69: astore_3
    //   70: aload_1
    //   71: aload_3
    //   72: invokevirtual 192	com/tencent/mobileqq/persistence/EntityManager:remove	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   75: pop
    //   76: invokestatic 303	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   79: ifeq -28 -> 51
    //   82: ldc_w 305
    //   85: iconst_2
    //   86: iconst_2
    //   87: anewarray 4	java/lang/Object
    //   90: dup
    //   91: iconst_0
    //   92: ldc_w 1059
    //   95: aastore
    //   96: dup
    //   97: iconst_1
    //   98: aload_3
    //   99: aastore
    //   100: invokestatic 427	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   103: goto -52 -> 51
    //   106: astore_1
    //   107: ldc_w 305
    //   110: iconst_1
    //   111: aload_1
    //   112: iconst_1
    //   113: anewarray 4	java/lang/Object
    //   116: dup
    //   117: iconst_0
    //   118: ldc_w 1110
    //   121: aastore
    //   122: invokestatic 1064	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   125: return
    //   126: astore_1
    //   127: aload_3
    //   128: monitorexit
    //   129: aload_1
    //   130: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	131	0	this	amir
    //   0	131	1	paramEntityManager	EntityManager
    //   0	131	2	paramList	List<ApolloGameRankData>
    // Exception table:
    //   from	to	target	type
    //   24	31	106	java/lang/Throwable
    //   44	51	106	java/lang/Throwable
    //   51	103	106	java/lang/Throwable
    //   129	131	106	java/lang/Throwable
    //   31	44	126	finally
    //   127	129	126	finally
  }
  
  public void c(List<ApolloActionPackage> paramList)
  {
    int i1 = 0;
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    if (this.jdField_b_of_type_JavaUtilList != null) {}
    for (;;)
    {
      EntityManager localEntityManager;
      synchronized (this.jdField_b_of_type_JavaUtilList)
      {
        if ((paramList.size() == 1) && (paramList.get(0) != null) && (((ApolloActionPackage)paramList.get(0)).packageId == 100)) {
          if (i1 < this.jdField_b_of_type_JavaUtilList.size())
          {
            if (((ApolloActionPackage)this.jdField_b_of_type_JavaUtilList.get(i1)).packageId == 100)
            {
              this.jdField_b_of_type_JavaUtilList.remove(i1);
              QLog.i("ApolloDaoManager", 1, "repeat game package.");
            }
          }
          else
          {
            this.jdField_b_of_type_JavaUtilList.add(0, paramList.get(0));
            if (QLog.isColorLevel()) {
              QLog.d("ApolloDaoManager", 2, "add game package.");
            }
            if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
              break;
            }
            localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
            if (localEntityManager == null) {
              break;
            }
            ??? = localEntityManager.getTransaction();
            ((EntityTransaction)???).begin();
          }
        }
      }
      try
      {
        localStringBuilder = new StringBuilder(200);
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          ApolloActionPackage localApolloActionPackage = (ApolloActionPackage)paramList.next();
          a(localEntityManager, localApolloActionPackage);
          localStringBuilder.append(" savePackage ID:").append(localApolloActionPackage.packageId);
          if (localStringBuilder.length() >= 200)
          {
            if (QLog.isColorLevel()) {
              QLog.d("ApolloDaoManager", 2, localStringBuilder.toString());
            }
            localStringBuilder.delete(0, localStringBuilder.length());
          }
        }
      }
      catch (Exception paramList)
      {
        StringBuilder localStringBuilder;
        if (QLog.isColorLevel()) {
          QLog.d("ApolloDaoManager", 2, "saveAction exception: ", paramList);
        }
        return;
        i1 += 1;
        continue;
        this.jdField_b_of_type_JavaUtilList.addAll(paramList);
        continue;
        paramList = finally;
        throw paramList;
        if ((localStringBuilder.length() < 200) && (QLog.isColorLevel())) {
          QLog.d("ApolloDaoManager", 2, localStringBuilder.toString());
        }
        ((EntityTransaction)???).commit();
        return;
      }
      finally
      {
        ((EntityTransaction)???).end();
      }
    }
  }
  
  public boolean c(int paramInt)
  {
    ConcurrentHashMap localConcurrentHashMap = b();
    if (localConcurrentHashMap.containsKey(Integer.valueOf(paramInt)))
    {
      if (((ApolloActionData)localConcurrentHashMap.get(Integer.valueOf(paramInt))).limitEnd >= NetConnInfoCenter.getServerTime()) {
        return true;
      }
      localConcurrentHashMap.remove(Integer.valueOf(paramInt));
      ThreadManager.post(new ApolloDaoManager.3(this, paramInt), 5, null, true);
    }
    return false;
  }
  
  public ApolloActionData d(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    for (;;)
    {
      return null;
      if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0)) {}
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext())
        {
          ApolloActionData localApolloActionData = (ApolloActionData)localIterator.next();
          if (localApolloActionData.actionId == paramInt) {
            return localApolloActionData;
          }
        }
        ??? = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
        if (??? == null) {
          continue;
        }
        ??? = ((EntityManager)???).query(ApolloActionData.class, false, "actionId=?", new String[] { String.valueOf(paramInt) }, null, null, null, null);
        if ((??? == null) || (((List)???).size() <= 0)) {
          continue;
        }
        return (ApolloActionData)((List)???).get(0);
      }
    }
  }
  
  public List<ApolloFavActionData> d()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject;
    if (this.jdField_d_of_type_JavaUtilList != null) {
      localObject = this.jdField_d_of_type_JavaUtilList;
    }
    EntityManager localEntityManager;
    do
    {
      do
      {
        return localObject;
        localObject = localArrayList;
      } while (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null);
      localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
      localObject = localArrayList;
    } while (localEntityManager == null);
    return localEntityManager.query(ApolloFavActionData.class);
  }
  
  public List<ApolloActionData> d(int paramInt)
  {
    ??? = null;
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList1 = new ArrayList();
    int i1;
    if ((this.jdField_c_of_type_JavaUtilList != null) && (this.jdField_c_of_type_JavaUtilList.size() > 0))
    {
      ??? = this.jdField_c_of_type_JavaUtilList;
      i1 = 0;
    }
    for (;;)
    {
      try
      {
        if (i1 < this.jdField_c_of_type_JavaUtilList.size())
        {
          if (((ApolloActionPackageData)this.jdField_c_of_type_JavaUtilList.get(i1)).packageId != paramInt) {
            break label459;
          }
          localArrayList1.add(this.jdField_c_of_type_JavaUtilList.get(i1));
          break label459;
        }
        if (localArrayList1 == null) {
          break label453;
        }
        paramInt = 0;
        i1 = 1;
        if (paramInt >= localArrayList1.size()) {
          break label399;
        }
        ??? = a(((ApolloActionPackageData)localArrayList1.get(paramInt)).acitonId);
        if (??? == null) {
          break label297;
        }
        localArrayList2.add(???);
        paramInt += 1;
        continue;
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
          break label180;
        }
      }
      finally {}
      return null;
      label180:
      Object localObject5 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
      if (localObject5 != null)
      {
        localObject5 = ((EntityManager)localObject5).query(ApolloActionPackageData.class, false, "packageId=?", new String[] { paramInt + "" }, null, null, null, null);
        if (QLog.isColorLevel()) {
          if (localObject5 != null) {
            break label283;
          }
        }
        label283:
        for (Object localObject2 = ???;; localObject2 = Integer.valueOf(((List)localObject5).size()))
        {
          QLog.d("ApolloDaoManager", 2, new Object[] { "getActionByPackageId from db, size:", localObject2 });
          localObject2 = localObject5;
          break;
        }
        label297:
        if ((this.jdField_c_of_type_JavaUtilList != null) && (this.jdField_c_of_type_JavaUtilList.size() > 0))
        {
          synchronized (this.jdField_c_of_type_JavaUtilList)
          {
            this.jdField_c_of_type_JavaUtilList.remove(((List)localObject2).get(paramInt));
            if (QLog.isColorLevel()) {
              QLog.d("ApolloDaoManager", 2, "remove paciton id=" + ((ApolloActionPackageData)((List)localObject2).get(paramInt)).acitonId);
            }
          }
          if (i1 == 0)
          {
            QLog.e("ApolloDaoManager", 1, "[getActionByPackageId] has some action not exit and check action json");
            if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_b_of_type_Boolean))
            {
              this.jdField_b_of_type_Boolean = false;
              ((alnr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153)).a(false, "getActionByPackageId action not exit", 1);
            }
          }
          label453:
          return localArrayList2;
        }
      }
      else
      {
        label399:
        continue;
        label459:
        i1 += 1;
        continue;
      }
      i1 = 0;
    }
  }
  
  public void d()
  {
    if (this.jdField_c_of_type_JavaUtilList != null) {}
    EntityManager localEntityManager;
    do
    {
      synchronized (this.jdField_c_of_type_JavaUtilList)
      {
        this.jdField_c_of_type_JavaUtilList.clear();
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
          return;
        }
      }
      localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    } while (localEntityManager == null);
    ??? = localEntityManager.getTransaction();
    try
    {
      ((EntityTransaction)???).begin();
      localEntityManager.execSQL(" DELETE FROM ApolloActionPackageData ");
      ((EntityTransaction)???).commit();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return;
    }
    finally
    {
      ((EntityTransaction)???).end();
    }
  }
  
  /* Error */
  public void d(List<ApolloActionPackageData> paramList)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +12 -> 13
    //   4: aload_1
    //   5: invokeinterface 281 1 0
    //   10: ifne +4 -> 14
    //   13: return
    //   14: aload_0
    //   15: getfield 68	amir:jdField_c_of_type_JavaUtilList	Ljava/util/List;
    //   18: ifnull +23 -> 41
    //   21: aload_0
    //   22: getfield 68	amir:jdField_c_of_type_JavaUtilList	Ljava/util/List;
    //   25: astore_2
    //   26: aload_2
    //   27: monitorenter
    //   28: aload_0
    //   29: getfield 68	amir:jdField_c_of_type_JavaUtilList	Ljava/util/List;
    //   32: aload_1
    //   33: invokeinterface 376 2 0
    //   38: pop
    //   39: aload_2
    //   40: monitorexit
    //   41: aload_0
    //   42: getfield 124	amir:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   45: ifnull -32 -> 13
    //   48: aload_0
    //   49: getfield 124	amir:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   52: invokevirtual 158	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/data/QQEntityManagerFactory;
    //   55: invokevirtual 164	com/tencent/mobileqq/data/QQEntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   58: astore_3
    //   59: aload_3
    //   60: ifnull -47 -> 13
    //   63: aload_3
    //   64: invokevirtual 337	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   67: astore_2
    //   68: aload_2
    //   69: invokevirtual 342	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   72: new 312	java/lang/StringBuilder
    //   75: dup
    //   76: sipush 500
    //   79: invokespecial 345	java/lang/StringBuilder:<init>	(I)V
    //   82: astore 4
    //   84: aload_1
    //   85: invokeinterface 256 1 0
    //   90: astore_1
    //   91: aload_1
    //   92: invokeinterface 262 1 0
    //   97: ifeq +117 -> 214
    //   100: aload_1
    //   101: invokeinterface 266 1 0
    //   106: checkcast 384	com/tencent/mobileqq/data/ApolloActionPackageData
    //   109: astore 5
    //   111: aload_0
    //   112: aload_3
    //   113: aload 5
    //   115: invokevirtual 352	amir:a	(Lcom/tencent/mobileqq/persistence/EntityManager;Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   118: pop
    //   119: invokestatic 303	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   122: ifeq +20 -> 142
    //   125: aload 4
    //   127: ldc_w 1143
    //   130: invokevirtual 319	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: aload 5
    //   135: getfield 387	com/tencent/mobileqq/data/ApolloActionPackageData:acitonId	I
    //   138: invokevirtual 322	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   141: pop
    //   142: aload 4
    //   144: invokevirtual 358	java/lang/StringBuilder:length	()I
    //   147: sipush 500
    //   150: if_icmplt -59 -> 91
    //   153: invokestatic 303	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   156: ifeq -65 -> 91
    //   159: ldc_w 305
    //   162: iconst_2
    //   163: aload 4
    //   165: invokevirtual 325	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   168: invokestatic 310	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   171: aload 4
    //   173: iconst_0
    //   174: aload 4
    //   176: invokevirtual 358	java/lang/StringBuilder:length	()I
    //   179: invokevirtual 362	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   182: pop
    //   183: goto -92 -> 91
    //   186: astore_1
    //   187: invokestatic 303	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   190: ifeq +14 -> 204
    //   193: ldc_w 305
    //   196: iconst_2
    //   197: ldc_w 799
    //   200: aload_1
    //   201: invokestatic 801	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   204: aload_2
    //   205: invokevirtual 370	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   208: return
    //   209: astore_1
    //   210: aload_2
    //   211: monitorexit
    //   212: aload_1
    //   213: athrow
    //   214: aload 4
    //   216: invokevirtual 358	java/lang/StringBuilder:length	()I
    //   219: sipush 500
    //   222: if_icmpge +21 -> 243
    //   225: invokestatic 303	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   228: ifeq +15 -> 243
    //   231: ldc_w 305
    //   234: iconst_2
    //   235: aload 4
    //   237: invokevirtual 325	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   240: invokestatic 310	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   243: aload_2
    //   244: invokevirtual 380	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   247: aload_2
    //   248: invokevirtual 370	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   251: return
    //   252: astore_1
    //   253: aload_2
    //   254: invokevirtual 370	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   257: aload_1
    //   258: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	259	0	this	amir
    //   0	259	1	paramList	List<ApolloActionPackageData>
    //   25	229	2	localObject	Object
    //   58	55	3	localEntityManager	EntityManager
    //   82	154	4	localStringBuilder	StringBuilder
    //   109	25	5	localApolloActionPackageData	ApolloActionPackageData
    // Exception table:
    //   from	to	target	type
    //   72	91	186	java/lang/Exception
    //   91	142	186	java/lang/Exception
    //   142	183	186	java/lang/Exception
    //   214	243	186	java/lang/Exception
    //   243	247	186	java/lang/Exception
    //   28	41	209	finally
    //   210	212	209	finally
    //   72	91	252	finally
    //   91	142	252	finally
    //   142	183	252	finally
    //   187	204	252	finally
    //   214	243	252	finally
    //   243	247	252	finally
  }
  
  public List<ApolloActionData> e()
  {
    ArrayList localArrayList = new ArrayList();
    List localList;
    int i1;
    if (this.jdField_d_of_type_JavaUtilList != null)
    {
      localList = this.jdField_d_of_type_JavaUtilList;
      i1 = 0;
    }
    for (;;)
    {
      try
      {
        if (i1 < this.jdField_d_of_type_JavaUtilList.size())
        {
          ApolloActionData localApolloActionData = a(((ApolloFavActionData)this.jdField_d_of_type_JavaUtilList.get(i1)).acitonId);
          if (localApolloActionData == null) {
            break label103;
          }
          localArrayList.add(localApolloActionData);
          break label103;
        }
        return localArrayList;
      }
      finally {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ApolloDaoManager", 2, "favActionList is null");
      return localList1;
      label103:
      i1 += 1;
    }
    return localList1;
  }
  
  public List<ApolloActionPackageData> e(int paramInt)
  {
    ??? = null;
    int i1 = 0;
    ArrayList localArrayList = new ArrayList();
    if ((this.jdField_c_of_type_JavaUtilList != null) && (this.jdField_c_of_type_JavaUtilList.size() > 0)) {}
    List localList;
    for (;;)
    {
      synchronized (this.jdField_c_of_type_JavaUtilList)
      {
        if (i1 < this.jdField_c_of_type_JavaUtilList.size())
        {
          if (((ApolloActionPackageData)this.jdField_c_of_type_JavaUtilList.get(i1)).packageId != paramInt) {
            break label259;
          }
          localArrayList.add(this.jdField_c_of_type_JavaUtilList.get(i1));
          break label259;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ApolloDaoManager", 2, new Object[] { "return getPackageActionDataById from cache, size:", Integer.valueOf(localArrayList.size()) });
        }
        return localArrayList;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
        break;
      }
      EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
      if (localEntityManager != null) {
        localList = localEntityManager.query(ApolloActionPackageData.class, false, "packageId=?", new String[] { paramInt + "" }, null, null, null, null);
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          if (localList != null) {
            break label242;
          }
        }
        for (;;)
        {
          QLog.d("ApolloDaoManager", 2, new Object[] { "return getPackageActionDataById from db, size:", ??? });
          return localList;
          label242:
          ??? = Integer.valueOf(localList.size());
        }
      }
      label259:
      i1 += 1;
    }
    return localList;
  }
  
  public void e()
  {
    QLog.d("ApolloDaoManager", 1, "removeAllRecommendActionList");
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    for (;;)
    {
      return;
      EntityManager localEntityManager;
      synchronized (this.l)
      {
        this.l.clear();
        localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
        if (localEntityManager == null) {
          continue;
        }
        ??? = localEntityManager.getTransaction();
        ((EntityTransaction)???).begin();
      }
    }
  }
  
  public void e(List<ApolloGameData> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    Object localObject2;
    StringBuilder localStringBuilder;
    Object localObject3;
    for (;;)
    {
      return;
      localObject2 = new StringBuilder();
      localStringBuilder = new StringBuilder();
      localObject3 = new ArrayList();
      if (this.jdField_e_of_type_JavaUtilList != null) {}
      synchronized (this.jdField_e_of_type_JavaUtilList)
      {
        if (this.jdField_e_of_type_JavaUtilList.size() == 0)
        {
          this.jdField_e_of_type_JavaUtilList.addAll(paramList);
          ((StringBuilder)localObject2).append("add All");
          if (QLog.isColorLevel()) {
            QLog.d("ApolloDaoManager", 2, new Object[] { "updateGameInfoList cache:", ((StringBuilder)localObject2).toString(), ", insert:", localStringBuilder.toString() });
          }
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
            continue;
          }
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
          if (localObject2 == null) {
            continue;
          }
          ??? = ((EntityManager)localObject2).getTransaction();
          ((EntityTransaction)???).begin();
        }
      }
    }
    for (;;)
    {
      int i2;
      int i3;
      try
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("delete gameId:");
        localObject3 = ((List)localObject3).iterator();
        if (((Iterator)localObject3).hasNext())
        {
          ApolloGameData localApolloGameData = (ApolloGameData)((Iterator)localObject3).next();
          ((EntityManager)localObject2).execSQL(" DELETE FROM ApolloGameData WHERE gameId = " + localApolloGameData.gameId);
          localStringBuilder.append(localApolloGameData.gameId).append(",");
          continue;
        }
      }
      catch (Exception paramList)
      {
        QLog.e("ApolloDaoManager", 1, "updateGameInfoList exception: ", paramList);
        return;
        ((StringBuilder)localObject2).append("repeat gameId:");
        i2 = 0;
        if (i2 >= paramList.size()) {
          break;
        }
        i3 = 0;
        int i1 = 0;
        if (i3 < this.jdField_e_of_type_JavaUtilList.size())
        {
          if (((ApolloGameData)paramList.get(i2)).gameId != ((ApolloGameData)this.jdField_e_of_type_JavaUtilList.get(i3)).gameId) {
            break label604;
          }
          ((List)localObject3).add(paramList.get(i2));
          this.jdField_e_of_type_JavaUtilList.remove(i3);
          this.jdField_e_of_type_JavaUtilList.add(i3, paramList.get(i2));
          ((StringBuilder)localObject2).append(((ApolloGameData)paramList.get(i2)).gameId).append(",");
          i1 = 1;
          break label604;
        }
        if (i1 != 0) {
          break label613;
        }
        this.jdField_e_of_type_JavaUtilList.add(paramList.get(i2));
        localStringBuilder.append(((ApolloGameData)paramList.get(i2)).gameId).append(",");
        break label613;
        paramList = finally;
        throw paramList;
        localStringBuilder.append("; insert gameId:");
        paramList = paramList.iterator();
        if (paramList.hasNext())
        {
          localObject3 = (ApolloGameData)paramList.next();
          a((EntityManager)localObject2, (Entity)localObject3);
          localStringBuilder.append(((ApolloGameData)localObject3).gameId).append(",");
          continue;
        }
      }
      finally
      {
        ((EntityTransaction)???).end();
      }
      if (QLog.isColorLevel()) {
        QLog.d("ApolloDaoManager", 2, new Object[] { "updateGameInfoList db:", localStringBuilder.toString() });
      }
      ((EntityTransaction)???).commit();
      ((EntityTransaction)???).end();
      return;
      label604:
      i3 += 1;
      continue;
      label613:
      i2 += 1;
    }
  }
  
  public List<ApolloActionData> f()
  {
    ArrayList localArrayList = new ArrayList();
    synchronized (this.l)
    {
      Iterator localIterator = this.l.iterator();
      while (localIterator.hasNext())
      {
        ApolloActionData localApolloActionData = c(((ApolloRecommendAction)localIterator.next()).id);
        if (localApolloActionData != null) {
          localArrayList.add(localApolloActionData);
        }
      }
    }
    return localList1;
  }
  
  public List<ApolloActionPackageData> f(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if ((this.jdField_c_of_type_JavaUtilList != null) && (this.jdField_c_of_type_JavaUtilList.size() > 0))
    {
      List localList = this.jdField_c_of_type_JavaUtilList;
      int i1 = 0;
      for (;;)
      {
        try
        {
          if (i1 < this.jdField_c_of_type_JavaUtilList.size())
          {
            ApolloActionPackageData localApolloActionPackageData = (ApolloActionPackageData)this.jdField_c_of_type_JavaUtilList.get(i1);
            if (localApolloActionPackageData.acitonId == paramInt) {
              localArrayList.add(localApolloActionPackageData);
            }
          }
          else
          {
            return localArrayList;
          }
        }
        finally {}
        i1 += 1;
      }
    }
    return localList1;
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    EntityManager localEntityManager;
    List localList;
    for (;;)
    {
      return;
      if (this.h != null) {}
      synchronized (this.h)
      {
        this.h.clear();
        localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
        if (localEntityManager != null)
        {
          localList = localEntityManager.query(ApolloObtainedActionData.class);
          if (localList != null) {
            ??? = localEntityManager.getTransaction();
          }
        }
      }
    }
    try
    {
      ((EntityTransaction)???).begin();
      int i1 = 0;
      while (i1 < localList.size())
      {
        ApolloObtainedActionData localApolloObtainedActionData = (ApolloObtainedActionData)localList.get(i1);
        if (localApolloObtainedActionData != null) {
          localEntityManager.remove(localApolloObtainedActionData);
        }
        i1 += 1;
        continue;
        localObject2 = finally;
        throw localObject2;
      }
      ((EntityTransaction)???).commit();
      return;
    }
    catch (Exception localException)
    {
      QLog.e("ApolloDaoManager", 1, "[removeAllObtainedAction] exception: ", localException);
      return;
    }
    finally
    {
      ((EntityTransaction)???).end();
    }
  }
  
  /* Error */
  public void f(List<ApolloFavActionData> paramList)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: aload_1
    //   4: ifnonnull +4 -> 8
    //   7: return
    //   8: aload_0
    //   9: getfield 70	amir:jdField_d_of_type_JavaUtilList	Ljava/util/List;
    //   12: ifnull +90 -> 102
    //   15: aload_0
    //   16: getfield 70	amir:jdField_d_of_type_JavaUtilList	Ljava/util/List;
    //   19: astore 5
    //   21: aload 5
    //   23: monitorenter
    //   24: iconst_0
    //   25: istore_2
    //   26: iload_2
    //   27: aload_1
    //   28: invokeinterface 281 1 0
    //   33: if_icmpge +66 -> 99
    //   36: aload_0
    //   37: getfield 70	amir:jdField_d_of_type_JavaUtilList	Ljava/util/List;
    //   40: invokeinterface 281 1 0
    //   45: iconst_1
    //   46: isub
    //   47: istore_3
    //   48: iload_3
    //   49: iflt +163 -> 212
    //   52: aload_0
    //   53: getfield 70	amir:jdField_d_of_type_JavaUtilList	Ljava/util/List;
    //   56: iload_3
    //   57: invokeinterface 293 2 0
    //   62: checkcast 455	com/tencent/mobileqq/data/ApolloFavActionData
    //   65: getfield 458	com/tencent/mobileqq/data/ApolloFavActionData:favId	J
    //   68: aload_1
    //   69: iload_2
    //   70: invokeinterface 293 2 0
    //   75: checkcast 455	com/tencent/mobileqq/data/ApolloFavActionData
    //   78: getfield 458	com/tencent/mobileqq/data/ApolloFavActionData:favId	J
    //   81: lcmp
    //   82: ifne +123 -> 205
    //   85: aload_0
    //   86: getfield 70	amir:jdField_d_of_type_JavaUtilList	Ljava/util/List;
    //   89: iload_3
    //   90: invokeinterface 327 2 0
    //   95: pop
    //   96: goto +109 -> 205
    //   99: aload 5
    //   101: monitorexit
    //   102: aload_0
    //   103: getfield 124	amir:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   106: ifnull -99 -> 7
    //   109: aload_0
    //   110: getfield 124	amir:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   113: invokevirtual 158	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/data/QQEntityManagerFactory;
    //   116: invokevirtual 164	com/tencent/mobileqq/data/QQEntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   119: astore 6
    //   121: aload 6
    //   123: invokevirtual 337	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   126: astore 5
    //   128: aload 5
    //   130: invokevirtual 342	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   133: iload 4
    //   135: istore_2
    //   136: iload_2
    //   137: aload_1
    //   138: invokeinterface 281 1 0
    //   143: if_icmpge +32 -> 175
    //   146: aload 6
    //   148: aload_1
    //   149: iload_2
    //   150: invokeinterface 293 2 0
    //   155: checkcast 937	com/tencent/mobileqq/persistence/Entity
    //   158: invokevirtual 192	com/tencent/mobileqq/persistence/EntityManager:remove	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   161: pop
    //   162: iload_2
    //   163: iconst_1
    //   164: iadd
    //   165: istore_2
    //   166: goto -30 -> 136
    //   169: astore_1
    //   170: aload 5
    //   172: monitorexit
    //   173: aload_1
    //   174: athrow
    //   175: aload 5
    //   177: invokevirtual 380	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   180: aload 5
    //   182: invokevirtual 370	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   185: return
    //   186: astore_1
    //   187: aload_1
    //   188: invokevirtual 682	java/lang/Exception:printStackTrace	()V
    //   191: aload 5
    //   193: invokevirtual 370	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   196: return
    //   197: astore_1
    //   198: aload 5
    //   200: invokevirtual 370	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   203: aload_1
    //   204: athrow
    //   205: iload_3
    //   206: iconst_1
    //   207: isub
    //   208: istore_3
    //   209: goto -161 -> 48
    //   212: iload_2
    //   213: iconst_1
    //   214: iadd
    //   215: istore_2
    //   216: goto -190 -> 26
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	219	0	this	amir
    //   0	219	1	paramList	List<ApolloFavActionData>
    //   25	191	2	i1	int
    //   47	162	3	i2	int
    //   1	133	4	i3	int
    //   19	180	5	localObject	Object
    //   119	28	6	localEntityManager	EntityManager
    // Exception table:
    //   from	to	target	type
    //   26	48	169	finally
    //   52	96	169	finally
    //   99	102	169	finally
    //   170	173	169	finally
    //   128	133	186	java/lang/Exception
    //   136	162	186	java/lang/Exception
    //   175	180	186	java/lang/Exception
    //   128	133	197	finally
    //   136	162	197	finally
    //   175	180	197	finally
    //   187	191	197	finally
  }
  
  public List<ApolloRecommendAction> g()
  {
    ArrayList localArrayList = new ArrayList();
    synchronized (this.l)
    {
      Iterator localIterator = this.l.iterator();
      if (localIterator.hasNext()) {
        localArrayList.add((ApolloRecommendAction)localIterator.next());
      }
    }
    return localList1;
  }
  
  public List<ApolloObtainedActionData> g(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    if ((this.h != null) && (this.h.size() > 0))
    {
      List localList = this.h;
      int i1 = 0;
      for (;;)
      {
        try
        {
          if (i1 < this.h.size())
          {
            if (((ApolloObtainedActionData)this.h.get(i1)).type != paramInt) {
              break label112;
            }
            localArrayList.add(this.h.get(i1));
          }
        }
        finally {}
        label112:
        i1 += 1;
      }
    }
    return localList1;
  }
  
  /* Error */
  public void g(List<ApolloRecommendAction> paramList)
  {
    // Byte code:
    //   0: ldc_w 305
    //   3: iconst_1
    //   4: ldc_w 1183
    //   7: invokestatic 310	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   10: aload_0
    //   11: getfield 124	amir:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   14: ifnull +16 -> 30
    //   17: aload_1
    //   18: ifnull +12 -> 30
    //   21: aload_1
    //   22: invokeinterface 281 1 0
    //   27: ifne +4 -> 31
    //   30: return
    //   31: aload_0
    //   32: getfield 105	amir:l	Ljava/util/List;
    //   35: astore_2
    //   36: aload_2
    //   37: monitorenter
    //   38: aload_0
    //   39: getfield 105	amir:l	Ljava/util/List;
    //   42: invokeinterface 373 1 0
    //   47: aload_0
    //   48: getfield 105	amir:l	Ljava/util/List;
    //   51: aload_1
    //   52: invokeinterface 376 2 0
    //   57: pop
    //   58: aload_2
    //   59: monitorexit
    //   60: aload_0
    //   61: getfield 124	amir:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   64: invokevirtual 158	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/data/QQEntityManagerFactory;
    //   67: invokevirtual 164	com/tencent/mobileqq/data/QQEntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   70: astore_3
    //   71: aload_3
    //   72: ifnull -42 -> 30
    //   75: aload_3
    //   76: invokevirtual 337	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   79: astore_2
    //   80: aload_2
    //   81: invokevirtual 342	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   84: aload_1
    //   85: invokeinterface 256 1 0
    //   90: astore_1
    //   91: aload_1
    //   92: invokeinterface 262 1 0
    //   97: ifeq +43 -> 140
    //   100: aload_0
    //   101: aload_3
    //   102: aload_1
    //   103: invokeinterface 266 1 0
    //   108: checkcast 996	com/tencent/mobileqq/data/ApolloRecommendAction
    //   111: invokevirtual 352	amir:a	(Lcom/tencent/mobileqq/persistence/EntityManager;Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   114: pop
    //   115: goto -24 -> 91
    //   118: astore_1
    //   119: ldc_w 305
    //   122: iconst_1
    //   123: ldc_w 1185
    //   126: aload_1
    //   127: invokestatic 367	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   130: aload_2
    //   131: invokevirtual 370	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   134: return
    //   135: astore_1
    //   136: aload_2
    //   137: monitorexit
    //   138: aload_1
    //   139: athrow
    //   140: aload_2
    //   141: invokevirtual 380	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   144: aload_2
    //   145: invokevirtual 370	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   148: return
    //   149: astore_1
    //   150: aload_2
    //   151: invokevirtual 370	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   154: aload_1
    //   155: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	156	0	this	amir
    //   0	156	1	paramList	List<ApolloRecommendAction>
    //   35	116	2	localObject	Object
    //   70	32	3	localEntityManager	EntityManager
    // Exception table:
    //   from	to	target	type
    //   84	91	118	java/lang/Exception
    //   91	115	118	java/lang/Exception
    //   140	144	118	java/lang/Exception
    //   38	60	135	finally
    //   136	138	135	finally
    //   84	91	149	finally
    //   91	115	149	finally
    //   119	130	149	finally
    //   140	144	149	finally
  }
  
  public List<ApolloGameData> h()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    do
    {
      return null;
      if ((this.jdField_e_of_type_JavaUtilList != null) && (this.jdField_e_of_type_JavaUtilList.size() > 0)) {
        synchronized (this.jdField_e_of_type_JavaUtilList)
        {
          ArrayList localArrayList = new ArrayList(this.jdField_e_of_type_JavaUtilList.size());
          localArrayList.addAll(this.jdField_e_of_type_JavaUtilList);
          return localArrayList;
        }
      }
      ??? = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    } while (??? == null);
    return ((EntityManager)???).query(ApolloGameData.class);
  }
  
  public List<ApolloGameRankData> h(int paramInt)
  {
    if ((this.k != null) && (paramInt >= 0))
    {
      if (paramInt >= this.k.size()) {
        return new ArrayList(this.k);
      }
      return new ArrayList(this.k.subList(0, paramInt));
    }
    return null;
  }
  
  public void h(List<ApolloGameRoamData> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ApolloGameRoamData localApolloGameRoamData = (ApolloGameRoamData)paramList.next();
        if ((!TextUtils.isEmpty(localApolloGameRoamData.tagUrl)) && (this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap != null)) {
          this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(localApolloGameRoamData.gameId), localApolloGameRoamData);
        }
      }
    }
  }
  
  public List<ApolloGameRoamData> i()
  {
    ??? = null;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    Object localObject3;
    do
    {
      do
      {
        do
        {
          return ???;
          if ((this.jdField_f_of_type_JavaUtilList != null) && (this.jdField_f_of_type_JavaUtilList.size() > 0)) {
            synchronized (this.jdField_f_of_type_JavaUtilList)
            {
              ArrayList localArrayList = new ArrayList(this.jdField_f_of_type_JavaUtilList.size());
              localArrayList.addAll(this.jdField_f_of_type_JavaUtilList);
              return localArrayList;
            }
          }
          localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
        } while (localObject3 == null);
        localObject3 = ((EntityManager)localObject3).query(ApolloGameRoamData.class);
        ??? = localObject3;
      } while (this.jdField_f_of_type_JavaUtilList == null);
      ??? = localObject3;
    } while (localObject3 == null);
    synchronized (this.jdField_f_of_type_JavaUtilList)
    {
      this.jdField_f_of_type_JavaUtilList.addAll((Collection)localObject3);
      return localObject3;
    }
  }
  
  /* Error */
  public void i(List<ApolloKapuEntranceTips> paramList)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 303	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +13 -> 18
    //   8: ldc_w 305
    //   11: iconst_2
    //   12: ldc_w 1196
    //   15: invokestatic 310	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   18: aload_0
    //   19: getfield 124	amir:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   22: astore_3
    //   23: aload_3
    //   24: ifnonnull +6 -> 30
    //   27: aload_0
    //   28: monitorexit
    //   29: return
    //   30: aload_0
    //   31: getfield 124	amir:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   34: invokevirtual 158	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/data/QQEntityManagerFactory;
    //   37: invokevirtual 164	com/tencent/mobileqq/data/QQEntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   40: astore 4
    //   42: new 55	java/util/ArrayList
    //   45: dup
    //   46: invokespecial 56	java/util/ArrayList:<init>	()V
    //   49: astore_3
    //   50: aload 4
    //   52: ifnull +67 -> 119
    //   55: aload 4
    //   57: ldc_w 477
    //   60: invokevirtual 529	com/tencent/mobileqq/persistence/EntityManager:query	(Ljava/lang/Class;)Ljava/util/List;
    //   63: astore 5
    //   65: aload 5
    //   67: ifnull +52 -> 119
    //   70: aload 5
    //   72: invokeinterface 281 1 0
    //   77: ifle +42 -> 119
    //   80: ldc_w 305
    //   83: iconst_1
    //   84: iconst_2
    //   85: anewarray 4	java/lang/Object
    //   88: dup
    //   89: iconst_0
    //   90: ldc_w 1198
    //   93: aastore
    //   94: dup
    //   95: iconst_1
    //   96: aload 5
    //   98: invokeinterface 281 1 0
    //   103: invokestatic 234	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   106: aastore
    //   107: invokestatic 427	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   110: aload_3
    //   111: aload 5
    //   113: invokeinterface 376 2 0
    //   118: pop
    //   119: new 55	java/util/ArrayList
    //   122: dup
    //   123: invokespecial 56	java/util/ArrayList:<init>	()V
    //   126: astore 5
    //   128: aload_1
    //   129: ifnull +171 -> 300
    //   132: aload_1
    //   133: invokeinterface 281 1 0
    //   138: ifle +162 -> 300
    //   141: ldc_w 305
    //   144: iconst_1
    //   145: iconst_2
    //   146: anewarray 4	java/lang/Object
    //   149: dup
    //   150: iconst_0
    //   151: ldc_w 1200
    //   154: aastore
    //   155: dup
    //   156: iconst_1
    //   157: aload_1
    //   158: invokeinterface 281 1 0
    //   163: invokestatic 234	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   166: aastore
    //   167: invokestatic 427	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   170: aload_1
    //   171: invokeinterface 256 1 0
    //   176: astore_1
    //   177: aload_1
    //   178: invokeinterface 262 1 0
    //   183: ifeq +117 -> 300
    //   186: aload_1
    //   187: invokeinterface 266 1 0
    //   192: checkcast 477	com/tencent/mobileqq/data/ApolloKapuEntranceTips
    //   195: astore 6
    //   197: aload_3
    //   198: invokeinterface 256 1 0
    //   203: astore 7
    //   205: aload 7
    //   207: invokeinterface 262 1 0
    //   212: ifeq +361 -> 573
    //   215: aload 7
    //   217: invokeinterface 266 1 0
    //   222: checkcast 477	com/tencent/mobileqq/data/ApolloKapuEntranceTips
    //   225: astore 8
    //   227: aload 6
    //   229: getfield 772	com/tencent/mobileqq/data/ApolloKapuEntranceTips:adId	I
    //   232: aload 8
    //   234: getfield 772	com/tencent/mobileqq/data/ApolloKapuEntranceTips:adId	I
    //   237: if_icmpne -32 -> 205
    //   240: iconst_1
    //   241: istore_2
    //   242: iload_2
    //   243: ifne -66 -> 177
    //   246: aload 6
    //   248: invokevirtual 480	com/tencent/mobileqq/data/ApolloKapuEntranceTips:isValid	()Z
    //   251: ifeq -74 -> 177
    //   254: aload 5
    //   256: aload 6
    //   258: invokeinterface 278 2 0
    //   263: pop
    //   264: invokestatic 303	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   267: ifeq -90 -> 177
    //   270: ldc_w 305
    //   273: iconst_1
    //   274: iconst_2
    //   275: anewarray 4	java/lang/Object
    //   278: dup
    //   279: iconst_0
    //   280: ldc_w 1202
    //   283: aastore
    //   284: dup
    //   285: iconst_1
    //   286: aload 6
    //   288: aastore
    //   289: invokestatic 427	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   292: goto -115 -> 177
    //   295: astore_1
    //   296: aload_0
    //   297: monitorexit
    //   298: aload_1
    //   299: athrow
    //   300: ldc_w 305
    //   303: iconst_1
    //   304: iconst_2
    //   305: anewarray 4	java/lang/Object
    //   308: dup
    //   309: iconst_0
    //   310: ldc_w 1204
    //   313: aastore
    //   314: dup
    //   315: iconst_1
    //   316: aload 5
    //   318: invokeinterface 281 1 0
    //   323: invokestatic 234	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   326: aastore
    //   327: invokestatic 427	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   330: aload 5
    //   332: ifnull +91 -> 423
    //   335: aload 5
    //   337: invokeinterface 281 1 0
    //   342: ifle +81 -> 423
    //   345: aload 4
    //   347: invokevirtual 337	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   350: astore_1
    //   351: aload_1
    //   352: invokevirtual 342	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   355: aload 5
    //   357: invokeinterface 256 1 0
    //   362: astore 5
    //   364: aload 5
    //   366: invokeinterface 262 1 0
    //   371: ifeq +124 -> 495
    //   374: aload 5
    //   376: invokeinterface 266 1 0
    //   381: checkcast 477	com/tencent/mobileqq/data/ApolloKapuEntranceTips
    //   384: astore 6
    //   386: aload 4
    //   388: aload 6
    //   390: invokevirtual 784	com/tencent/mobileqq/persistence/EntityManager:persistOrReplace	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   393: aload_3
    //   394: aload 6
    //   396: invokeinterface 278 2 0
    //   401: pop
    //   402: goto -38 -> 364
    //   405: astore 4
    //   407: ldc_w 305
    //   410: iconst_1
    //   411: ldc_w 1206
    //   414: aload 4
    //   416: invokestatic 367	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   419: aload_1
    //   420: invokevirtual 370	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   423: aload_3
    //   424: invokeinterface 256 1 0
    //   429: astore_1
    //   430: aload_1
    //   431: invokeinterface 262 1 0
    //   436: ifeq +109 -> 545
    //   439: aload_1
    //   440: invokeinterface 266 1 0
    //   445: checkcast 477	com/tencent/mobileqq/data/ApolloKapuEntranceTips
    //   448: astore_3
    //   449: aload_3
    //   450: invokevirtual 480	com/tencent/mobileqq/data/ApolloKapuEntranceTips:isValid	()Z
    //   453: ifeq -23 -> 430
    //   456: aload_3
    //   457: getfield 769	com/tencent/mobileqq/data/ApolloKapuEntranceTips:isInstall	Z
    //   460: ifeq +53 -> 513
    //   463: aload_0
    //   464: getfield 107	amir:n	Ljava/util/List;
    //   467: astore 4
    //   469: aload 4
    //   471: monitorenter
    //   472: aload_0
    //   473: getfield 107	amir:n	Ljava/util/List;
    //   476: aload_3
    //   477: invokeinterface 278 2 0
    //   482: pop
    //   483: aload 4
    //   485: monitorexit
    //   486: goto -56 -> 430
    //   489: astore_1
    //   490: aload 4
    //   492: monitorexit
    //   493: aload_1
    //   494: athrow
    //   495: aload_1
    //   496: invokevirtual 380	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   499: aload_1
    //   500: invokevirtual 370	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   503: goto -80 -> 423
    //   506: astore_3
    //   507: aload_1
    //   508: invokevirtual 370	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   511: aload_3
    //   512: athrow
    //   513: aload_0
    //   514: getfield 109	amir:o	Ljava/util/List;
    //   517: astore 4
    //   519: aload 4
    //   521: monitorenter
    //   522: aload_0
    //   523: getfield 109	amir:o	Ljava/util/List;
    //   526: aload_3
    //   527: invokeinterface 278 2 0
    //   532: pop
    //   533: aload 4
    //   535: monitorexit
    //   536: goto -106 -> 430
    //   539: astore_1
    //   540: aload 4
    //   542: monitorexit
    //   543: aload_1
    //   544: athrow
    //   545: new 1208	amiy
    //   548: dup
    //   549: aload_0
    //   550: invokespecial 1209	amiy:<init>	(Lamir;)V
    //   553: astore_1
    //   554: aload_0
    //   555: getfield 107	amir:n	Ljava/util/List;
    //   558: aload_1
    //   559: invokestatic 492	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   562: aload_0
    //   563: getfield 109	amir:o	Ljava/util/List;
    //   566: aload_1
    //   567: invokestatic 492	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   570: goto -543 -> 27
    //   573: iconst_0
    //   574: istore_2
    //   575: goto -333 -> 242
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	578	0	this	amir
    //   0	578	1	paramList	List<ApolloKapuEntranceTips>
    //   241	334	2	i1	int
    //   22	455	3	localObject1	Object
    //   506	21	3	localObject2	Object
    //   40	347	4	localEntityManager	EntityManager
    //   405	10	4	localException	Exception
    //   63	312	5	localObject3	Object
    //   195	200	6	localApolloKapuEntranceTips1	ApolloKapuEntranceTips
    //   203	13	7	localIterator	Iterator
    //   225	8	8	localApolloKapuEntranceTips2	ApolloKapuEntranceTips
    // Exception table:
    //   from	to	target	type
    //   2	18	295	finally
    //   18	23	295	finally
    //   30	50	295	finally
    //   55	65	295	finally
    //   70	119	295	finally
    //   119	128	295	finally
    //   132	177	295	finally
    //   177	205	295	finally
    //   205	240	295	finally
    //   246	292	295	finally
    //   300	330	295	finally
    //   335	351	295	finally
    //   419	423	295	finally
    //   423	430	295	finally
    //   430	472	295	finally
    //   493	495	295	finally
    //   499	503	295	finally
    //   507	513	295	finally
    //   513	522	295	finally
    //   543	545	295	finally
    //   545	570	295	finally
    //   351	364	405	java/lang/Exception
    //   364	402	405	java/lang/Exception
    //   495	499	405	java/lang/Exception
    //   472	486	489	finally
    //   490	493	489	finally
    //   351	364	506	finally
    //   364	402	506	finally
    //   407	419	506	finally
    //   495	499	506	finally
    //   522	536	539	finally
    //   540	543	539	finally
  }
  
  public List<ApolloGameData> j()
  {
    List localList = h();
    if (localList == null)
    {
      QLog.i("ApolloDaoManager", 1, "[getPanelGameList] no game data info");
      return null;
    }
    Object localObject = i();
    if (localObject == null)
    {
      QLog.i("ApolloDaoManager", 1, "[getPanelGameList] no user game list");
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    localObject = ((List)localObject).iterator();
    int i1 = 0;
    if (((Iterator)localObject).hasNext())
    {
      ApolloGameRoamData localApolloGameRoamData = (ApolloGameRoamData)((Iterator)localObject).next();
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        ApolloGameData localApolloGameData = (ApolloGameData)localIterator.next();
        if ((localApolloGameData != null) && (localApolloGameRoamData != null) && (localApolloGameData.gameId == localApolloGameRoamData.gameId) && (localApolloGameData.isShow != 0) && (localApolloGameData.gameId != 1) && (localApolloGameData.gameId != 2) && (!localApolloGameData.isGameApp) && (amio.a("8.4.8", localApolloGameData.minVer, localApolloGameData.maxVer)))
        {
          localApolloGameData.type = localApolloGameRoamData.type;
          localApolloGameData.tagUrl = localApolloGameRoamData.tagUrl;
          localApolloGameData.tagType = localApolloGameRoamData.tagType;
          localArrayList.add(localApolloGameData);
        }
      }
      if ((localApolloGameRoamData == null) || (TextUtils.isEmpty(localApolloGameRoamData.tagUrl)) || (localApolloGameRoamData.tagEndTs >= NetConnInfoCenter.getServerTime())) {
        break label349;
      }
      i1 = 1;
    }
    label349:
    for (;;)
    {
      break;
      if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (i1 != 0) && (!this.jdField_c_of_type_Boolean))
      {
        QLog.w("ApolloDaoManager", 1, "getPanelGameList, tab game is out of data");
        ((alnn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(211)).e();
        this.jdField_c_of_type_Boolean = true;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ApolloDaoManager", 2, new Object[] { "[getPanelGameList] panelGameList size:", Integer.valueOf(localArrayList.size()) });
      }
      return localArrayList;
    }
  }
  
  public List<ApolloActionPush> k()
  {
    ArrayList localArrayList = null;
    if ((this.jdField_g_of_type_JavaUtilList != null) && (this.jdField_g_of_type_JavaUtilList.size() > 0)) {
      synchronized (this.jdField_g_of_type_JavaUtilList)
      {
        localArrayList = new ArrayList(this.jdField_g_of_type_JavaUtilList.size());
        localArrayList.addAll(this.jdField_g_of_type_JavaUtilList);
        return localArrayList;
      }
    }
    ??? = localObject2;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
      ??? = localObject2;
      if (localEntityManager != null)
      {
        List localList = localEntityManager.query(ApolloActionPush.class);
        ??? = localList;
        if (this.jdField_g_of_type_JavaUtilList != null)
        {
          ??? = localList;
          if (localList != null)
          {
            ??? = localList;
            if (localList.size() > 0) {
              synchronized (this.jdField_g_of_type_JavaUtilList)
              {
                this.jdField_g_of_type_JavaUtilList.addAll(localList);
                return localList;
              }
            }
          }
        }
      }
    }
    return ???;
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList = null;
    }
    if (this.jdField_b_of_type_JavaUtilList != null)
    {
      this.jdField_b_of_type_JavaUtilList.clear();
      this.jdField_b_of_type_JavaUtilList = null;
    }
    if (this.jdField_c_of_type_JavaUtilList != null)
    {
      this.jdField_c_of_type_JavaUtilList.clear();
      this.jdField_c_of_type_JavaUtilList = null;
    }
    if (this.jdField_d_of_type_JavaUtilList != null)
    {
      this.jdField_d_of_type_JavaUtilList.clear();
      this.jdField_d_of_type_JavaUtilList = null;
    }
    if (this.jdField_e_of_type_JavaUtilList != null)
    {
      this.jdField_e_of_type_JavaUtilList.clear();
      this.jdField_e_of_type_JavaUtilList = null;
    }
    if (this.jdField_g_of_type_JavaUtilList != null)
    {
      this.jdField_g_of_type_JavaUtilList.clear();
      this.jdField_g_of_type_JavaUtilList = null;
    }
    if (this.h != null)
    {
      this.h.clear();
      this.h = null;
    }
    if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap != null)
    {
      this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = null;
    }
    if (this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap != null)
    {
      this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap = null;
    }
    if (this.jdField_g_of_type_JavaUtilConcurrentConcurrentHashMap != null)
    {
      this.jdField_g_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      this.jdField_g_of_type_JavaUtilConcurrentConcurrentHashMap = null;
    }
    if (this.k != null)
    {
      this.k.clear();
      this.k = null;
    }
    if (this.j != null)
    {
      this.j.clear();
      this.j = null;
    }
    if (this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
      this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    }
    if (this.jdField_f_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
      this.jdField_f_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    }
    ApolloGameUtil.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amir
 * JD-Core Version:    0.7.0.1
 */