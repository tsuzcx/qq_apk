import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.BaseRecentUser;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.TroopAssistantData;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.managers.TroopAssistantManager.1;
import com.tencent.mobileqq.managers.TroopAssistantManager.2;
import com.tencent.mobileqq.managers.TroopAssistantManager.3;
import com.tencent.mobileqq.managers.TroopAssistantManager.4;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.os.MqqHandler;

public class axan
{
  public static axan a;
  protected int a;
  protected long a;
  public Object a;
  protected String a;
  HashSet<String> a;
  protected List<TroopAssistantData> a;
  protected final Map<String, TroopAssistantData> a;
  public Set<String> a;
  protected boolean a;
  protected int b;
  protected Object b;
  protected boolean b;
  protected boolean c;
  protected boolean d;
  protected boolean e;
  
  private axan()
  {
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.jdField_b_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_JavaUtilHashSet = new HashSet();
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
  }
  
  public static axan a()
  {
    try
    {
      if (jdField_a_of_type_Axan == null) {
        jdField_a_of_type_Axan = new axan();
      }
      axan localaxan = jdField_a_of_type_Axan;
      return localaxan;
    }
    finally {}
  }
  
  private TroopAssistantData a(QQAppInterface arg1, String paramString)
  {
    a(???);
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      paramString = (TroopAssistantData)this.jdField_a_of_type_JavaUtilMap.get(paramString);
      return paramString;
    }
  }
  
  private TroopAssistantData a(EntityManager paramEntityManager, QQAppInterface paramQQAppInterface, String paramString)
  {
    a(paramQQAppInterface);
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      TroopAssistantData localTroopAssistantData = (TroopAssistantData)this.jdField_a_of_type_JavaUtilMap.get(paramString);
      paramEntityManager = localTroopAssistantData;
      if (localTroopAssistantData == null)
      {
        localTroopAssistantData = new TroopAssistantData();
        localTroopAssistantData.troopUin = paramString;
        paramQQAppInterface = paramQQAppInterface.a();
        paramEntityManager = localTroopAssistantData;
        if (paramQQAppInterface != null)
        {
          paramQQAppInterface = paramQQAppInterface.getDraftSummaryInfo(paramString, 1);
          paramEntityManager = localTroopAssistantData;
          if (paramQQAppInterface != null)
          {
            localTroopAssistantData.lastdrafttime = paramQQAppInterface.getTime();
            paramEntityManager = localTroopAssistantData;
          }
        }
      }
      return paramEntityManager;
    }
  }
  
  public static void a()
  {
    jdField_a_of_type_Axan = null;
  }
  
  private void a(MessageRecord paramMessageRecord, String paramString, QQAppInterface paramQQAppInterface)
  {
    Object localObject = this.jdField_a_of_type_JavaLangObject;
    if (paramMessageRecord != null) {}
    try
    {
      if ((!paramMessageRecord.isread) && (!this.jdField_a_of_type_JavaUtilSet.contains(paramString))) {
        this.jdField_a_of_type_JavaUtilSet.add(paramString);
      }
      l(paramQQAppInterface);
      return;
    }
    finally {}
  }
  
  /* Error */
  private void a(EntityManager arg1)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 64
    //   3: iconst_0
    //   4: aconst_null
    //   5: aconst_null
    //   6: aconst_null
    //   7: aconst_null
    //   8: ldc 112
    //   10: aconst_null
    //   11: invokevirtual 118	com/tencent/mobileqq/persistence/EntityManager:query	(Ljava/lang/Class;ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    //   14: astore_2
    //   15: aload_2
    //   16: ifnull +198 -> 214
    //   19: aload_2
    //   20: invokeinterface 124 1 0
    //   25: ifle +189 -> 214
    //   28: aload_2
    //   29: new 126	axao
    //   32: dup
    //   33: aload_0
    //   34: invokespecial 129	axao:<init>	(Laxan;)V
    //   37: invokestatic 135	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   40: invokestatic 141	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   43: ifeq +33 -> 76
    //   46: ldc 143
    //   48: iconst_2
    //   49: new 145	java/lang/StringBuilder
    //   52: dup
    //   53: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   56: ldc 148
    //   58: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: aload_2
    //   62: invokeinterface 124 1 0
    //   67: invokevirtual 155	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   70: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   73: invokestatic 163	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   76: aload_0
    //   77: getfield 38	axan:jdField_b_of_type_JavaLangObject	Ljava/lang/Object;
    //   80: astore_1
    //   81: aload_1
    //   82: monitorenter
    //   83: aload_0
    //   84: aload_2
    //   85: putfield 165	axan:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   88: aload_0
    //   89: getfield 165	axan:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   92: ifnonnull +16 -> 108
    //   95: aload_0
    //   96: new 167	java/util/ArrayList
    //   99: dup
    //   100: bipush 15
    //   102: invokespecial 170	java/util/ArrayList:<init>	(I)V
    //   105: putfield 165	axan:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   108: aload_1
    //   109: monitorexit
    //   110: aload_0
    //   111: getfield 47	axan:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   114: astore_1
    //   115: aload_1
    //   116: monitorenter
    //   117: aload_0
    //   118: getfield 47	axan:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   121: invokeinterface 173 1 0
    //   126: aload_0
    //   127: getfield 165	axan:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   130: invokeinterface 177 1 0
    //   135: astore_2
    //   136: aload_2
    //   137: invokeinterface 182 1 0
    //   142: ifeq +97 -> 239
    //   145: aload_2
    //   146: invokeinterface 186 1 0
    //   151: checkcast 64	com/tencent/mobileqq/data/TroopAssistantData
    //   154: astore_3
    //   155: aload_0
    //   156: getfield 47	axan:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   159: aload_3
    //   160: getfield 69	com/tencent/mobileqq/data/TroopAssistantData:troopUin	Ljava/lang/String;
    //   163: aload_3
    //   164: invokeinterface 190 3 0
    //   169: pop
    //   170: goto -34 -> 136
    //   173: astore_2
    //   174: aload_1
    //   175: monitorexit
    //   176: aload_2
    //   177: athrow
    //   178: astore_1
    //   179: invokestatic 141	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   182: ifeq +31 -> 213
    //   185: ldc 143
    //   187: iconst_2
    //   188: new 145	java/lang/StringBuilder
    //   191: dup
    //   192: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   195: ldc 192
    //   197: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: aload_1
    //   201: invokevirtual 195	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   204: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   210: invokestatic 197	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   213: return
    //   214: invokestatic 141	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   217: ifeq -141 -> 76
    //   220: ldc 143
    //   222: iconst_2
    //   223: ldc 199
    //   225: invokestatic 163	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   228: goto -152 -> 76
    //   231: astore_1
    //   232: aload_1
    //   233: athrow
    //   234: astore_2
    //   235: aload_1
    //   236: monitorexit
    //   237: aload_2
    //   238: athrow
    //   239: aload_1
    //   240: monitorexit
    //   241: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	242	0	this	axan
    //   14	132	2	localObject1	Object
    //   173	4	2	localObject2	Object
    //   234	4	2	localObject3	Object
    //   154	10	3	localTroopAssistantData	TroopAssistantData
    // Exception table:
    //   from	to	target	type
    //   117	136	173	finally
    //   136	170	173	finally
    //   174	176	173	finally
    //   239	241	173	finally
    //   0	15	178	java/lang/Exception
    //   19	76	178	java/lang/Exception
    //   76	83	178	java/lang/Exception
    //   110	117	178	java/lang/Exception
    //   176	178	178	java/lang/Exception
    //   214	228	178	java/lang/Exception
    //   237	239	178	java/lang/Exception
    //   0	15	231	finally
    //   19	76	231	finally
    //   76	83	231	finally
    //   110	117	231	finally
    //   176	178	231	finally
    //   179	213	231	finally
    //   214	228	231	finally
    //   237	239	231	finally
    //   83	108	234	finally
    //   108	110	234	finally
    //   235	237	234	finally
  }
  
  private void a(EntityManager paramEntityManager, TroopAssistantData paramTroopAssistantData)
  {
    if ((paramTroopAssistantData == null) || (TextUtils.isEmpty(paramTroopAssistantData.troopUin))) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      this.jdField_a_of_type_JavaUtilMap.put(paramTroopAssistantData.troopUin, paramTroopAssistantData);
    }
    for (;;)
    {
      synchronized (this.jdField_b_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_JavaUtilList != null)
        {
          this.jdField_a_of_type_JavaUtilList.remove(paramTroopAssistantData);
          int j = this.jdField_a_of_type_JavaUtilList.size();
          i = 0;
          if (i >= j) {
            break label207;
          }
          TroopAssistantData localTroopAssistantData = (TroopAssistantData)this.jdField_a_of_type_JavaUtilList.get(i);
          if (Math.max(paramTroopAssistantData.lastmsgtime, paramTroopAssistantData.lastdrafttime) <= Math.max(localTroopAssistantData.lastmsgtime, localTroopAssistantData.lastdrafttime)) {
            continue;
          }
          this.jdField_a_of_type_JavaUtilList.add(i, paramTroopAssistantData);
          i = 1;
          if (i == 0) {
            this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_JavaUtilList.size(), paramTroopAssistantData);
          }
        }
        ThreadManager.post(new TroopAssistantManager.4(this, paramTroopAssistantData, paramEntityManager), 8, null, false);
        return;
        paramEntityManager = finally;
        throw paramEntityManager;
        i += 1;
      }
      label207:
      int i = 0;
    }
  }
  
  private boolean a(QQAppInterface paramQQAppInterface, int paramInt, long paramLong)
  {
    boolean bool = false;
    Object localObject = (TroopManager)paramQQAppInterface.getManager(52);
    apaw localapaw = paramQQAppInterface.a().a();
    if (localObject == null) {
      return false;
    }
    switch (paramInt)
    {
    default: 
      if ((this.jdField_b_of_type_Boolean) && (!this.e) && (!((TroopManager)localObject).a())) {
        bool = true;
      }
      break;
    case 2: 
      if (bool)
      {
        localObject = (RecentUser)localapaw.findRecentUserByUin(antf.C, 5000);
        ((RecentUser)localObject).uin = antf.C;
        ((RecentUser)localObject).setType(5000);
        if (((RecentUser)localObject).lastmsgtime < paramLong) {
          ((RecentUser)localObject).lastmsgtime = paramLong;
        }
        if (b())
        {
          ((RecentUser)localObject).showUpTime = (System.currentTimeMillis() / 1000L);
          label153:
          localapaw.saveRecentUser((BaseRecentUser)localObject);
        }
      }
      break;
    }
    for (;;)
    {
      return true;
      bool = true;
      break;
      bool = this.jdField_b_of_type_Boolean;
      break;
      bool = false;
      break;
      paramQQAppInterface = a(paramQQAppInterface);
      if (paramQQAppInterface != null)
      {
        ((RecentUser)localObject).lastmsgtime = paramQQAppInterface.lastmsgtime;
        ((RecentUser)localObject).lastmsgdrafttime = paramQQAppInterface.lastdrafttime;
      }
      ((RecentUser)localObject).showUpTime = 0L;
      break label153;
      if (paramInt != 3)
      {
        paramQQAppInterface = (RecentUser)localapaw.findRecentUser(antf.C, 5000);
        if (paramQQAppInterface != null) {
          localapaw.delRecentUser(paramQQAppInterface);
        }
      }
    }
  }
  
  private boolean a(EntityManager paramEntityManager, String paramString)
  {
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      paramString = (TroopAssistantData)this.jdField_a_of_type_JavaUtilMap.remove(paramString);
    }
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_JavaUtilList != null) {
        this.jdField_a_of_type_JavaUtilList.remove(paramString);
      }
      if (paramString != null)
      {
        ThreadManager.post(new TroopAssistantManager.3(this, paramEntityManager, paramString), 8, null, false);
        return true;
        paramEntityManager = finally;
        throw paramEntityManager;
      }
    }
    return false;
  }
  
  private void d(QQAppInterface paramQQAppInterface, String paramString)
  {
    apaw localapaw = paramQQAppInterface.a().a();
    paramString = (RecentUser)localapaw.findRecentUser(paramString, 1);
    if ((paramString != null) && (!paramString.shouldShowInRecentList(paramQQAppInterface))) {
      localapaw.delRecentUser(paramString);
    }
  }
  
  private void d(String paramString, QQAppInterface paramQQAppInterface)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if ((paramQQAppInterface.a().a(paramString, 1) > 0) && (this.jdField_a_of_type_JavaUtilSet.contains(paramString))) {
        this.jdField_a_of_type_JavaUtilSet.remove(paramString);
      }
      l(paramQQAppInterface);
      return;
    }
  }
  
  private void e(String paramString, QQAppInterface paramQQAppInterface)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if ((paramQQAppInterface.a().a(paramString, 1) > 0) && (!this.jdField_a_of_type_JavaUtilSet.contains(paramString))) {
        this.jdField_a_of_type_JavaUtilSet.add(paramString);
      }
      l(paramQQAppInterface);
      return;
    }
  }
  
  private boolean e(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0).getBoolean("should_update_troop_assistant", true);
  }
  
  private void l(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    ThreadManager.post(new TroopAssistantManager.1(this, paramQQAppInterface), 5, null, false);
  }
  
  private void m(QQAppInterface paramQQAppInterface)
  {
    if ((paramQQAppInterface == null) || (paramQQAppInterface.getApp() == null)) {
      return;
    }
    paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0).edit().putBoolean("should_update_troop_assistant", false).commit();
  }
  
  public int a(QQMessageFacade arg1, QQAppInterface paramQQAppInterface)
  {
    int i = 0;
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_JavaUtilSet != null)
        {
          Iterator localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
          if (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            if ((!TextUtils.isEmpty(str)) && (!aguy.a(str, 1, paramQQAppInterface))) {
              i += 1;
            }
          }
          else
          {
            this.jdField_a_of_type_Int = i;
            return i;
          }
        }
        else
        {
          this.jdField_a_of_type_Int = 0;
          return 0;
        }
      }
    }
  }
  
  public int a(QQAppInterface paramQQAppInterface, String paramString)
  {
    return paramQQAppInterface.b(paramString);
  }
  
  public TroopAssistantData a(QQAppInterface paramQQAppInterface)
  {
    a(paramQQAppInterface);
    for (;;)
    {
      synchronized (this.jdField_b_of_type_JavaLangObject)
      {
        if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
        {
          Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
          if (localIterator.hasNext())
          {
            TroopAssistantData localTroopAssistantData = (TroopAssistantData)localIterator.next();
            if (aguy.a(localTroopAssistantData.troopUin, 1, paramQQAppInterface)) {
              continue;
            }
            paramQQAppInterface = localTroopAssistantData;
            return paramQQAppInterface;
          }
        }
      }
      paramQQAppInterface = null;
    }
  }
  
  public List<Long> a(QQAppInterface paramQQAppInterface)
  {
    ArrayList localArrayList1 = ((TroopManager)paramQQAppInterface.getManager(52)).b();
    ArrayList localArrayList2 = new ArrayList();
    int i = 0;
    TroopInfo localTroopInfo;
    if (i < localArrayList1.size())
    {
      if (localArrayList1.get(i) == null) {
        break label114;
      }
      localTroopInfo = (TroopInfo)localArrayList1.get(i);
      if (localTroopInfo != null) {}
    }
    else
    {
      return localArrayList2;
    }
    Map localMap = a(paramQQAppInterface, new String[] { localTroopInfo.troopuin });
    Integer localInteger = null;
    if (localMap != null) {
      localInteger = (Integer)localMap.get(localTroopInfo.troopuin);
    }
    if (localInteger == null) {}
    for (;;)
    {
      label114:
      i += 1;
      break;
      if (localInteger.intValue() == 2) {
        localArrayList2.add(Long.valueOf(localTroopInfo.troopuin));
      }
    }
  }
  
  public Map<String, Integer> a(QQAppInterface paramQQAppInterface, List<String> paramList)
  {
    return paramQQAppInterface.a(paramList);
  }
  
  public Map<String, Integer> a(QQAppInterface paramQQAppInterface, String... paramVarArgs)
  {
    return a(paramQQAppInterface, Arrays.asList(paramVarArgs));
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_JavaUtilList == null)
      {
        i = 1;
        if (i != 0)
        {
          paramQQAppInterface = paramQQAppInterface.a().createEntityManager();
          a(paramQQAppInterface);
          paramQQAppInterface.close();
        }
        return;
      }
      int i = 0;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    if (!paramQQAppInterface.getAccount().equals(this.jdField_a_of_type_JavaLangString)) {
      b(paramQQAppInterface);
    }
    paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0).edit().putLong("troop_assis_last_read_time", paramLong).commit();
    this.jdField_a_of_type_Long = paramLong;
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_JavaUtilSet != null) {
        this.jdField_a_of_type_JavaUtilSet.clear();
      }
      l(paramQQAppInterface);
      return;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramString)))
    {
      paramQQAppInterface = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0);
      if (paramQQAppInterface != null)
      {
        paramQQAppInterface.edit().putBoolean("tag_troop_ignore_tip_v2_" + paramString, true).commit();
        if (QLog.isColorLevel()) {
          QLog.d("troopassist_guide", 2, "setTroopIgnoreTip key=tag_troop_ignore_tip_v2_" + paramString);
        }
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    paramQQAppInterface.a(paramString, Integer.valueOf(paramInt));
  }
  
  public void a(QQAppInterface paramQQAppInterface, nkq paramnkq)
  {
    ThreadManager.post(new TroopAssistantManager.2(this, paramQQAppInterface, paramnkq), 8, null, true);
  }
  
  public void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0).edit().putBoolean("troop_assistant_be_del", paramBoolean).commit();
    this.e = paramBoolean;
  }
  
  public void a(MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    EntityManager localEntityManager = paramQQAppInterface.a().createEntityManager();
    a(paramMessageRecord, paramMessageRecord.frienduin, paramMessageRecord.time, localEntityManager, paramQQAppInterface);
    localEntityManager.close();
  }
  
  public void a(MessageRecord paramMessageRecord, String paramString, long paramLong, EntityManager paramEntityManager, QQAppInterface paramQQAppInterface)
  {
    TroopAssistantData localTroopAssistantData = a(paramEntityManager, paramQQAppInterface, paramString);
    if ((paramMessageRecord != null) && (paramMessageRecord.time > paramLong)) {}
    for (localTroopAssistantData.lastmsgtime = paramMessageRecord.time;; localTroopAssistantData.lastmsgtime = paramLong)
    {
      QQMessageFacade.Message localMessage = paramQQAppInterface.a().a(localTroopAssistantData.troopUin, 1);
      if (localMessage != null)
      {
        long l = localMessage.time;
        if (l > localTroopAssistantData.lastmsgtime) {
          localTroopAssistantData.lastmsgtime = l;
        }
      }
      a(paramEntityManager, localTroopAssistantData);
      a(paramMessageRecord, paramString, paramQQAppInterface);
      if (this.e) {
        a(paramQQAppInterface, false);
      }
      d(paramQQAppInterface, paramString);
      a(paramQQAppInterface, 0, paramLong);
      return;
    }
  }
  
  public void a(EntityManager paramEntityManager, QQAppInterface paramQQAppInterface)
  {
    try
    {
      a(paramQQAppInterface);
      apaw localapaw = paramQQAppInterface.a().a();
      Object localObject2 = localapaw.getRecentList(false);
      long l1 = System.currentTimeMillis() / 1000L;
      this.jdField_a_of_type_Boolean = b(paramQQAppInterface);
      Object localObject1 = new ArrayList();
      Object localObject3;
      if ((localObject2 != null) && (((List)localObject2).size() > 0))
      {
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (RecentUser)((Iterator)localObject2).next();
          if ((((RecentUser)localObject3).getType() == 1) && (a(paramQQAppInterface, ((RecentUser)localObject3).uin))) {
            ((List)localObject1).add(localObject3);
          }
        }
      }
      if (((List)localObject1).size() > 0)
      {
        long l2 = ((RecentUser)((List)localObject1).get(0)).lastmsgtime;
        localObject1 = ((List)localObject1).iterator();
        l1 = l2;
        if (((Iterator)localObject1).hasNext())
        {
          localObject2 = (RecentUser)((Iterator)localObject1).next();
          localObject3 = a(paramEntityManager, paramQQAppInterface, ((RecentUser)localObject2).uin);
          ((TroopAssistantData)localObject3).lastdrafttime = ((RecentUser)localObject2).lastmsgdrafttime;
          QQMessageFacade.Message localMessage;
          if (((RecentUser)localObject2).lastmsgtime == 0L)
          {
            localMessage = paramQQAppInterface.a().a(((TroopAssistantData)localObject3).troopUin, 1);
            if (localMessage == null) {}
          }
          for (((TroopAssistantData)localObject3).lastmsgtime = localMessage.time;; ((TroopAssistantData)localObject3).lastmsgtime = ((RecentUser)localObject2).lastmsgtime)
          {
            a(paramEntityManager, (TroopAssistantData)localObject3);
            localapaw.delRecentUser((BaseRecentUser)localObject2);
            e(((TroopAssistantData)localObject3).troopUin, paramQQAppInterface);
            break;
          }
        }
      }
      a(paramQQAppInterface, 0, l1);
      paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0).edit().putBoolean("init_troop_assistant", false).commit();
      return;
    }
    catch (Exception paramEntityManager) {}
  }
  
  public void a(String paramString, long paramLong, EntityManager paramEntityManager, QQAppInterface paramQQAppInterface)
  {
    TroopAssistantData localTroopAssistantData;
    if (paramLong == 0L)
    {
      localTroopAssistantData = a(paramQQAppInterface, paramString);
      if (localTroopAssistantData != null)
      {
        localTroopAssistantData.lastdrafttime = paramLong;
        if ((paramLong != 0L) || (localTroopAssistantData.lastmsgtime != 0L)) {
          break label94;
        }
        d(paramQQAppInterface, paramString);
      }
    }
    for (;;)
    {
      if (this.e) {
        a(paramQQAppInterface, false);
      }
      d(paramQQAppInterface, paramString);
      a(paramQQAppInterface, 0, paramLong);
      return;
      localTroopAssistantData = a(paramEntityManager, paramQQAppInterface, paramString);
      break;
      label94:
      a(paramEntityManager, localTroopAssistantData);
    }
  }
  
  public void a(String paramString, QQAppInterface paramQQAppInterface)
  {
    EntityManager localEntityManager = paramQQAppInterface.a().createEntityManager();
    apaw localapaw = paramQQAppInterface.a().a();
    RecentUser localRecentUser = (RecentUser)localapaw.findRecentUser(paramString, 1);
    QQMessageFacade.Message localMessage;
    if (localRecentUser != null)
    {
      paramString = a(localEntityManager, paramQQAppInterface, paramString);
      if (localRecentUser.lastmsgtime != 0L) {
        break label274;
      }
      localMessage = paramQQAppInterface.a().a(paramString.troopUin, 1);
      if (localMessage == null) {}
    }
    label274:
    for (paramString.lastmsgtime = localMessage.time;; paramString.lastmsgtime = localRecentUser.lastmsgtime)
    {
      paramString.lastdrafttime = localRecentUser.lastmsgdrafttime;
      a(localEntityManager, paramString);
      e(paramString.troopUin, paramQQAppInterface);
      alni.a().a(localRecentUser.uin + "-" + localRecentUser.getType());
      if ((!(localRecentUser.msg instanceof alqh)) && (!(localRecentUser.msg instanceof alqx)) && (!(localRecentUser.msg instanceof alqk)) && (!(localRecentUser.msg instanceof alqp)) && (!(localRecentUser.msg instanceof alqg)) && (!(localRecentUser.msg instanceof bnth)) && (!(localRecentUser.msg instanceof alqu)) && (!(localRecentUser.msg instanceof alqo)) && (!(localRecentUser.msg instanceof alqr))) {
        localapaw.delRecentUser(localRecentUser);
      }
      paramString = a(paramQQAppInterface);
      if (paramString != null) {
        a(paramQQAppInterface, 0, paramString.lastmsgtime);
      }
      localEntityManager.close();
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public boolean a(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0).getBoolean("init_troop_assistant", true);
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    return paramQQAppInterface.b(paramString) == 2;
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    boolean bool = true;
    if (paramQQAppInterface == null) {
      return false;
    }
    if (!paramQQAppInterface.getAccount().equals(this.jdField_a_of_type_JavaLangString)) {
      b(paramQQAppInterface);
    }
    this.jdField_b_of_type_Boolean = paramBoolean;
    paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0).edit().putBoolean("troop_assis_show_in_msg", paramBoolean).commit();
    int i;
    if (paramBoolean)
    {
      i = 1;
      paramBoolean = a(paramQQAppInterface, i, 0L);
      if ((!this.jdField_b_of_type_Boolean) || (!paramBoolean)) {
        break label100;
      }
    }
    label100:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      return paramBoolean;
      i = 2;
      break;
    }
  }
  
  public boolean a(String paramString)
  {
    return this.jdField_a_of_type_JavaUtilHashSet.contains(paramString);
  }
  
  public List<TroopAssistantData> b(QQAppInterface paramQQAppInterface)
  {
    a(paramQQAppInterface);
    ArrayList localArrayList;
    for (;;)
    {
      synchronized (this.jdField_b_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_JavaUtilList != null)
        {
          i = this.jdField_a_of_type_JavaUtilList.size();
          localArrayList = new ArrayList(i);
          if (this.jdField_a_of_type_JavaUtilList == null) {
            break;
          }
          Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
          if (!localIterator.hasNext()) {
            break;
          }
          TroopAssistantData localTroopAssistantData = (TroopAssistantData)localIterator.next();
          if ((aguy.a(localTroopAssistantData.troopUin, 1, paramQQAppInterface)) || (bfmf.b(paramQQAppInterface, localTroopAssistantData.troopUin))) {
            continue;
          }
          localArrayList.add(localTroopAssistantData);
        }
      }
      int i = 0;
    }
    return localArrayList;
  }
  
  public void b(QQAppInterface paramQQAppInterface)
  {
    Object localObject2;
    Object localObject3;
    if (paramQQAppInterface != null)
    {
      this.jdField_a_of_type_JavaLangString = paramQQAppInterface.getAccount();
      localObject2 = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0);
      this.jdField_b_of_type_Boolean = ((SharedPreferences)localObject2).getBoolean("troop_assis_show_in_msg", true);
      this.c = ((SharedPreferences)localObject2).getBoolean("troop_assis_show_on_top", false);
      this.jdField_a_of_type_Long = ((SharedPreferences)localObject2).getLong("troop_assis_last_read_time", 0L);
      this.jdField_a_of_type_Boolean = b(paramQQAppInterface);
      this.e = ((SharedPreferences)localObject2).getBoolean("troop_assistant_be_del", false);
      synchronized (this.jdField_b_of_type_JavaLangObject)
      {
        this.jdField_a_of_type_JavaUtilList = null;
        localObject3 = b(paramQQAppInterface);
      }
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilSet = bhsj.a((SharedPreferences)localObject2, "troop_assis_new_unread_list", null);
      if (this.jdField_a_of_type_JavaUtilSet == null)
      {
        this.jdField_a_of_type_JavaUtilSet = new HashSet();
        if (e(paramQQAppInterface))
        {
          m(paramQQAppInterface);
          localObject2 = paramQQAppInterface.a();
          if (localObject2 == null)
          {
            return;
            paramQQAppInterface = finally;
            throw paramQQAppInterface;
          }
          localObject3 = ((List)localObject3).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            TroopAssistantData localTroopAssistantData = (TroopAssistantData)((Iterator)localObject3).next();
            QQMessageFacade.Message localMessage = ((QQMessageFacade)localObject2).a(localTroopAssistantData.troopUin, 1);
            if ((paramQQAppInterface.a().a(localTroopAssistantData.troopUin, 1) > 0) && (localMessage.time > this.jdField_a_of_type_Long)) {
              e(localMessage.frienduin, paramQQAppInterface);
            }
          }
        }
      }
    }
  }
  
  public void b(QQAppInterface paramQQAppInterface, long paramLong)
  {
    if ((paramQQAppInterface == null) || (paramQQAppInterface.getApp() == null)) {
      return;
    }
    long l = paramLong;
    if (paramLong == 0L) {
      l = new Date().getTime() + 86400L;
    }
    paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0).edit().putLong("troop_batch_setting_time", l).commit();
  }
  
  public void b(QQAppInterface paramQQAppInterface, String paramString)
  {
    Object localObject;
    if (paramQQAppInterface != null)
    {
      localObject = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0);
      if ((localObject != null) && (!((SharedPreferences)localObject).getBoolean("tag_troop_ignore_tip_v2_" + paramString, false))) {
        break label52;
      }
    }
    label52:
    label217:
    label225:
    for (;;)
    {
      return;
      paramQQAppInterface = ((SharedPreferences)localObject).getString("tag_troop_aio_enter_times_" + paramString, "");
      if (!TextUtils.isEmpty(paramQQAppInterface))
      {
        paramQQAppInterface = paramQQAppInterface + ";" + NetConnInfoCenter.getServerTimeMillis() / 1000L;
        localObject = ((SharedPreferences)localObject).edit();
        ((SharedPreferences.Editor)localObject).putString("tag_troop_aio_enter_times_" + paramString, paramQQAppInterface);
        if (Build.VERSION.SDK_INT <= 8) {
          break label217;
        }
        ((SharedPreferences.Editor)localObject).apply();
      }
      for (;;)
      {
        if (!QLog.isColorLevel()) {
          break label225;
        }
        QLog.d("troopassist_guide", 2, "addTroopAssistTipTime time=" + paramQQAppInterface);
        return;
        paramQQAppInterface = String.valueOf(NetConnInfoCenter.getServerTimeMillis() / 1000L);
        break;
        ((SharedPreferences.Editor)localObject).commit();
      }
    }
  }
  
  public void b(String paramString, QQAppInterface paramQQAppInterface)
  {
    EntityManager localEntityManager = paramQQAppInterface.a().createEntityManager();
    if (a(localEntityManager, paramString)) {
      d(paramString, paramQQAppInterface);
    }
    localEntityManager.close();
  }
  
  public boolean b()
  {
    return this.c;
  }
  
  public boolean b(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0).getBoolean("show_troop_assistant_list_notity", true);
  }
  
  public boolean b(QQAppInterface paramQQAppInterface, String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramQQAppInterface != null)
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(paramString))
      {
        paramQQAppInterface = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0);
        bool1 = bool2;
        if (paramQQAppInterface != null) {
          bool1 = paramQQAppInterface.getBoolean("tag_troop_ignore_tip_v2_" + paramString, false);
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("troopassist_guide", 2, "checkTroopIgnoreTip ignore=" + bool1);
    }
    return bool1;
  }
  
  public boolean b(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if (!paramQQAppInterface.getAccount().equals(this.jdField_a_of_type_JavaLangString)) {
      b(paramQQAppInterface);
    }
    this.c = paramBoolean;
    paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0).edit().putBoolean("troop_assis_show_on_top", paramBoolean).commit();
    a(paramQQAppInterface, 3, 0L);
    paramQQAppInterface = paramQQAppInterface.getHandler(Conversation.class);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.sendEmptyMessage(1009);
    }
    return this.c;
  }
  
  public List<RecentUser> c(QQAppInterface paramQQAppInterface)
  {
    ArrayList localArrayList;
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      localArrayList = new ArrayList(0);
      a(paramQQAppInterface);
      if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext())
        {
          TroopAssistantData localTroopAssistantData = (TroopAssistantData)localIterator.next();
          if (aguy.a(localTroopAssistantData.troopUin, 1, paramQQAppInterface))
          {
            RecentUser localRecentUser = new RecentUser(localTroopAssistantData.troopUin, 1);
            localRecentUser.isHiddenChat = 1;
            localRecentUser.lastmsgtime = localTroopAssistantData.lastmsgtime;
            localRecentUser.lastmsgdrafttime = localTroopAssistantData.lastdrafttime;
            localArrayList.add(localRecentUser);
          }
        }
      }
    }
    return localArrayList;
  }
  
  public void c(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TroopAssistantManager", 2, "app == null; what happen.");
      }
      return;
    }
    if (!paramQQAppInterface.getAccount().equals(this.jdField_a_of_type_JavaLangString)) {
      b(paramQQAppInterface);
    }
    a(paramQQAppInterface, 0, 0L);
  }
  
  public void c(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0);
      if (paramQQAppInterface != null) {
        paramQQAppInterface.edit().remove("tag_troop_aio_enter_times_" + paramString).commit();
      }
    }
  }
  
  public void c(String paramString, QQAppInterface paramQQAppInterface)
  {
    Object localObject = null;
    try
    {
      EntityManager localEntityManager = paramQQAppInterface.a().createEntityManager();
      localObject = localEntityManager;
      TroopAssistantData localTroopAssistantData = a(paramQQAppInterface, paramString);
      localObject = localEntityManager;
      apaw localapaw = paramQQAppInterface.a().a();
      if (localTroopAssistantData != null)
      {
        localObject = localEntityManager;
        RecentUser localRecentUser = (RecentUser)localapaw.findRecentUserByUin(String.valueOf(localTroopAssistantData.troopUin), 1);
        localObject = localEntityManager;
        localRecentUser.uin = localTroopAssistantData.troopUin;
        localObject = localEntityManager;
        localRecentUser.setType(1);
        localObject = localEntityManager;
        localRecentUser.lastmsgtime = localTroopAssistantData.lastmsgtime;
        localObject = localEntityManager;
        localRecentUser.lastmsgdrafttime = localTroopAssistantData.lastdrafttime;
        localObject = localEntityManager;
        if (a(localEntityManager, paramString))
        {
          localObject = localEntityManager;
          localapaw.saveRecentUser(localRecentUser);
          localObject = localEntityManager;
          d(paramString, paramQQAppInterface);
        }
      }
      localObject = localEntityManager;
      paramString = a(paramQQAppInterface);
      if (paramString != null)
      {
        localObject = localEntityManager;
        a(paramQQAppInterface, 0, paramString.lastmsgtime);
      }
      return;
    }
    finally
    {
      if (localObject != null) {
        localObject.close();
      }
    }
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean c(QQAppInterface paramQQAppInterface)
  {
    boolean bool = false;
    if ((paramQQAppInterface == null) || (paramQQAppInterface.getApp() == null)) {
      bool = true;
    }
    long l;
    do
    {
      return bool;
      l = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0).getLong("troop_batch_setting_time", 0L);
    } while ((new Date().getTime() / 1000L < l) && (l != 0L));
    return true;
  }
  
  public boolean c(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramQQAppInterface == null) {}
    do
    {
      for (;;)
      {
        return false;
        paramQQAppInterface = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0);
        if ((paramQQAppInterface != null) && (!paramQQAppInterface.getBoolean("tag_troop_ignore_tip_v2_" + paramString, false)))
        {
          paramQQAppInterface = paramQQAppInterface.getString("tag_troop_aio_enter_times_" + paramString, "");
          if (!TextUtils.isEmpty(paramQQAppInterface))
          {
            paramQQAppInterface = paramQQAppInterface.split(";");
            int i = paramQQAppInterface.length;
            if (i >= 2)
            {
              paramQQAppInterface = paramQQAppInterface[(i - 2)];
              try
              {
                long l1 = Long.parseLong(paramQQAppInterface);
                long l2 = NetConnInfoCenter.getServerTimeMillis() / 1000L;
                if (l2 - l1 < 7200L) {
                  return true;
                }
              }
              catch (NumberFormatException paramQQAppInterface) {}
            }
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("TroopAssistantManager", 2, QLog.getStackTraceString(paramQQAppInterface));
    return false;
  }
  
  public void d(QQAppInterface paramQQAppInterface)
  {
    l(paramQQAppInterface);
  }
  
  public boolean d()
  {
    return this.d;
  }
  
  public boolean d(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {}
    BaseApplication localBaseApplication;
    do
    {
      return true;
      localBaseApplication = paramQQAppInterface.getApp();
    } while (localBaseApplication == null);
    return localBaseApplication.getSharedPreferences(paramQQAppInterface.getAccount(), 0).getBoolean("troop_message_setting_first", true);
  }
  
  public void e(QQAppInterface paramQQAppInterface)
  {
    int m = 0;
    int k = 0;
    int i = 0;
    Object localObject = this.jdField_a_of_type_JavaLangObject;
    int j = m;
    try
    {
      if (this.jdField_a_of_type_JavaUtilSet != null)
      {
        j = m;
        Iterator localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
        j = i;
        k = i;
        if (localIterator.hasNext())
        {
          j = i;
          String str = (String)localIterator.next();
          j = i;
          if (paramQQAppInterface.a().a(str, 1) > 0) {
            break label129;
          }
          j = i;
          localIterator.remove();
          i = 1;
        }
      }
      for (;;)
      {
        break;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      k = j;
      if (k != 0) {
        l(paramQQAppInterface);
      }
      return;
    }
    finally {}
  }
  
  public void f(QQAppInterface paramQQAppInterface)
  {
    if ((paramQQAppInterface == null) || (paramQQAppInterface.getApp() == null)) {
      return;
    }
    paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0).edit().putBoolean("show_troop_assistant_list_notity", false).commit();
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void g(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {}
    while (paramQQAppInterface.getApp() == null) {
      return;
    }
    paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0).edit().putBoolean("troop_message_setting_first", false).commit();
  }
  
  public void h(QQAppInterface arg1)
  {
    this.jdField_a_of_type_JavaUtilHashSet.clear();
    a(???);
    for (;;)
    {
      synchronized (this.jdField_b_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_JavaUtilList == null) {
          break label117;
        }
        i = this.jdField_a_of_type_JavaUtilList.size();
        ArrayList localArrayList = new ArrayList(i);
        if (this.jdField_a_of_type_JavaUtilList != null)
        {
          localArrayList.addAll(this.jdField_a_of_type_JavaUtilList);
          break label112;
          if (i < localArrayList.size())
          {
            this.jdField_a_of_type_JavaUtilHashSet.add(((TroopAssistantData)localArrayList.get(i)).troopUin);
            i += 1;
            continue;
          }
          return;
        }
      }
      label112:
      int i = 0;
      continue;
      label117:
      i = 0;
    }
  }
  
  public void i(QQAppInterface paramQQAppInterface)
  {
    Object localObject1 = paramQQAppInterface.a().a();
    EntityManager localEntityManager = paramQQAppInterface.a().createEntityManager();
    Object localObject3 = new ArrayList();
    Object localObject2 = new ArrayList();
    ??? = ((apaw)localObject1).getRecentList(false);
    Object localObject5;
    if ((??? != null) && (((List)???).size() > 0))
    {
      ??? = ((List)???).iterator();
      while (((Iterator)???).hasNext())
      {
        localObject5 = (RecentUser)((Iterator)???).next();
        if ((((RecentUser)localObject5).getType() == 1) && (a(paramQQAppInterface, ((RecentUser)localObject5).uin)) && (!((RecentUser)localObject5).shouldShowInRecentList(paramQQAppInterface))) {
          ((ArrayList)localObject3).add(localObject5);
        }
      }
    }
    a(paramQQAppInterface);
    Object localObject6;
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
      {
        localObject5 = this.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject5).hasNext())
        {
          localObject6 = (TroopAssistantData)((Iterator)localObject5).next();
          if (!a(paramQQAppInterface, ((TroopAssistantData)localObject6).troopUin)) {
            ((ArrayList)localObject2).add(localObject6);
          }
        }
      }
    }
    if (((ArrayList)localObject3).size() > 0)
    {
      localObject3 = ((ArrayList)localObject3).iterator();
      if (((Iterator)localObject3).hasNext())
      {
        ??? = (RecentUser)((Iterator)localObject3).next();
        localObject5 = a(localEntityManager, paramQQAppInterface, ((RecentUser)???).uin);
        if (((RecentUser)???).lastmsgtime == 0L)
        {
          localObject6 = paramQQAppInterface.a().a(((TroopAssistantData)localObject5).troopUin, 1);
          if (localObject6 == null) {}
        }
        for (((TroopAssistantData)localObject5).lastmsgtime = ((QQMessageFacade.Message)localObject6).time;; ((TroopAssistantData)localObject5).lastmsgtime = ((RecentUser)???).lastmsgtime)
        {
          a(localEntityManager, (TroopAssistantData)localObject5);
          ((apaw)localObject1).delRecentUser((BaseRecentUser)???);
          e(((RecentUser)???).uin, paramQQAppInterface);
          break;
        }
      }
    }
    if (((ArrayList)localObject2).size() > 0)
    {
      localObject2 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (TroopAssistantData)((Iterator)localObject2).next();
        ??? = (RecentUser)((apaw)localObject1).findRecentUserByUin(((TroopAssistantData)localObject3).troopUin, 1);
        ((RecentUser)???).uin = ((TroopAssistantData)localObject3).troopUin;
        ((RecentUser)???).setType(1);
        ((RecentUser)???).lastmsgtime = ((TroopAssistantData)localObject3).lastmsgtime;
        ((RecentUser)???).lastmsgdrafttime = ((TroopAssistantData)localObject3).lastdrafttime;
        if (a(localEntityManager, ((TroopAssistantData)localObject3).troopUin))
        {
          ((apaw)localObject1).saveRecentUser((BaseRecentUser)???);
          d(((TroopAssistantData)localObject3).troopUin, paramQQAppInterface);
        }
      }
    }
    localObject1 = a(paramQQAppInterface);
    if (localObject1 != null) {
      a(paramQQAppInterface, 0, ((TroopAssistantData)localObject1).lastmsgtime);
    }
    if (localEntityManager != null) {
      localEntityManager.close();
    }
  }
  
  public void j(QQAppInterface paramQQAppInterface)
  {
    a(paramQQAppInterface);
    for (;;)
    {
      int i;
      synchronized (this.jdField_b_of_type_JavaLangObject)
      {
        if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() <= 0)) {
          return;
        }
        i = this.jdField_a_of_type_JavaUtilList.size() - 1;
        if (i >= 0)
        {
          TroopAssistantData localTroopAssistantData = (TroopAssistantData)this.jdField_a_of_type_JavaUtilList.get(i);
          if (aguy.a(localTroopAssistantData.troopUin, 1, paramQQAppInterface)) {
            b(localTroopAssistantData.troopUin, paramQQAppInterface);
          }
        }
        else
        {
          return;
        }
      }
      i -= 1;
    }
  }
  
  public void k(QQAppInterface paramQQAppInterface)
  {
    try
    {
      b(paramQQAppInterface);
      EntityManager localEntityManager;
      if (a(paramQQAppInterface) == true)
      {
        localEntityManager = paramQQAppInterface.a().createEntityManager();
        a().a(localEntityManager, paramQQAppInterface);
        localEntityManager.close();
      }
      c(paramQQAppInterface);
      if (axap.a().a(paramQQAppInterface) == true)
      {
        localEntityManager = paramQQAppInterface.a().createEntityManager();
        axap.a().a(localEntityManager, paramQQAppInterface);
        localEntityManager.close();
      }
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("Q.recent", 2, "initTroopManager error");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axan
 * JD-Core Version:    0.7.0.1
 */