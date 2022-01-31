import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.TroopAssistantData;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.managers.TroopAssistantManager.1;
import com.tencent.mobileqq.managers.TroopAssistantManager.2;
import com.tencent.mobileqq.managers.TroopAssistantManager.3;
import com.tencent.mobileqq.managers.TroopAssistantManager.4;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
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

public class asfd
{
  public static asfd a;
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
  
  private asfd()
  {
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.jdField_b_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_JavaUtilHashSet = new HashSet();
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
  }
  
  public static asfd a()
  {
    try
    {
      if (jdField_a_of_type_Asfd == null) {
        jdField_a_of_type_Asfd = new asfd();
      }
      asfd localasfd = jdField_a_of_type_Asfd;
      return localasfd;
    }
    finally {}
  }
  
  private TroopAssistantData a(aukp paramaukp, QQAppInterface paramQQAppInterface, String paramString)
  {
    a(paramQQAppInterface);
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      TroopAssistantData localTroopAssistantData = (TroopAssistantData)this.jdField_a_of_type_JavaUtilMap.get(paramString);
      paramaukp = localTroopAssistantData;
      if (localTroopAssistantData == null)
      {
        localTroopAssistantData = new TroopAssistantData();
        localTroopAssistantData.troopUin = paramString;
        paramQQAppInterface = paramQQAppInterface.a();
        paramaukp = localTroopAssistantData;
        if (paramQQAppInterface != null)
        {
          paramQQAppInterface = paramQQAppInterface.a(paramString, 1);
          paramaukp = localTroopAssistantData;
          if (paramQQAppInterface != null)
          {
            localTroopAssistantData.lastdrafttime = paramQQAppInterface.getTime();
            paramaukp = localTroopAssistantData;
          }
        }
      }
      return paramaukp;
    }
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
  
  public static void a()
  {
    jdField_a_of_type_Asfd = null;
  }
  
  /* Error */
  private void a(aukp arg1)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 64
    //   3: iconst_0
    //   4: aconst_null
    //   5: aconst_null
    //   6: aconst_null
    //   7: aconst_null
    //   8: ldc 93
    //   10: aconst_null
    //   11: invokevirtual 98	aukp:a	(Ljava/lang/Class;ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    //   14: astore_2
    //   15: aload_2
    //   16: ifnull +198 -> 214
    //   19: aload_2
    //   20: invokeinterface 104 1 0
    //   25: ifle +189 -> 214
    //   28: aload_2
    //   29: new 106	asfe
    //   32: dup
    //   33: aload_0
    //   34: invokespecial 109	asfe:<init>	(Lasfd;)V
    //   37: invokestatic 115	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   40: invokestatic 121	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   43: ifeq +33 -> 76
    //   46: ldc 123
    //   48: iconst_2
    //   49: new 125	java/lang/StringBuilder
    //   52: dup
    //   53: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   56: ldc 128
    //   58: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: aload_2
    //   62: invokeinterface 104 1 0
    //   67: invokevirtual 135	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   70: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   73: invokestatic 143	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   76: aload_0
    //   77: getfield 38	asfd:jdField_b_of_type_JavaLangObject	Ljava/lang/Object;
    //   80: astore_1
    //   81: aload_1
    //   82: monitorenter
    //   83: aload_0
    //   84: aload_2
    //   85: putfield 145	asfd:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   88: aload_0
    //   89: getfield 145	asfd:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   92: ifnonnull +16 -> 108
    //   95: aload_0
    //   96: new 147	java/util/ArrayList
    //   99: dup
    //   100: bipush 15
    //   102: invokespecial 150	java/util/ArrayList:<init>	(I)V
    //   105: putfield 145	asfd:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   108: aload_1
    //   109: monitorexit
    //   110: aload_0
    //   111: getfield 47	asfd:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   114: astore_1
    //   115: aload_1
    //   116: monitorenter
    //   117: aload_0
    //   118: getfield 47	asfd:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   121: invokeinterface 153 1 0
    //   126: aload_0
    //   127: getfield 145	asfd:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   130: invokeinterface 157 1 0
    //   135: astore_2
    //   136: aload_2
    //   137: invokeinterface 162 1 0
    //   142: ifeq +97 -> 239
    //   145: aload_2
    //   146: invokeinterface 166 1 0
    //   151: checkcast 64	com/tencent/mobileqq/data/TroopAssistantData
    //   154: astore_3
    //   155: aload_0
    //   156: getfield 47	asfd:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   159: aload_3
    //   160: getfield 68	com/tencent/mobileqq/data/TroopAssistantData:troopUin	Ljava/lang/String;
    //   163: aload_3
    //   164: invokeinterface 170 3 0
    //   169: pop
    //   170: goto -34 -> 136
    //   173: astore_2
    //   174: aload_1
    //   175: monitorexit
    //   176: aload_2
    //   177: athrow
    //   178: astore_1
    //   179: invokestatic 121	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   182: ifeq +31 -> 213
    //   185: ldc 123
    //   187: iconst_2
    //   188: new 125	java/lang/StringBuilder
    //   191: dup
    //   192: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   195: ldc 172
    //   197: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: aload_1
    //   201: invokevirtual 175	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   204: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   210: invokestatic 177	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   213: return
    //   214: invokestatic 121	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   217: ifeq -141 -> 76
    //   220: ldc 123
    //   222: iconst_2
    //   223: ldc 179
    //   225: invokestatic 143	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
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
    //   0	242	0	this	asfd
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
  
  private void a(aukp paramaukp, TroopAssistantData paramTroopAssistantData)
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
        ThreadManager.post(new TroopAssistantManager.4(this, paramTroopAssistantData, paramaukp), 8, null, false);
        return;
        paramaukp = finally;
        throw paramaukp;
        i += 1;
      }
      label207:
      int i = 0;
    }
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
  
  private boolean a(aukp paramaukp, String paramString)
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
        ThreadManager.post(new TroopAssistantManager.3(this, paramaukp, paramString), 8, null, false);
        return true;
        paramaukp = finally;
        throw paramaukp;
      }
    }
    return false;
  }
  
  private boolean a(QQAppInterface paramQQAppInterface, int paramInt, long paramLong)
  {
    boolean bool = false;
    Object localObject = (TroopManager)paramQQAppInterface.getManager(52);
    aktf localaktf = paramQQAppInterface.a().a();
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
        localObject = localaktf.a(ajsd.C, 5000);
        ((RecentUser)localObject).uin = ajsd.C;
        ((RecentUser)localObject).setType(5000);
        if (((RecentUser)localObject).lastmsgtime < paramLong) {
          ((RecentUser)localObject).lastmsgtime = paramLong;
        }
        if (b())
        {
          ((RecentUser)localObject).showUpTime = (System.currentTimeMillis() / 1000L);
          label150:
          localaktf.a((RecentUser)localObject);
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
      break label150;
      if (paramInt != 3)
      {
        paramQQAppInterface = localaktf.b(ajsd.C, 5000);
        if (paramQQAppInterface != null) {
          localaktf.b(paramQQAppInterface);
        }
      }
    }
  }
  
  private void d(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = paramQQAppInterface.a().a();
    paramString = paramQQAppInterface.b(paramString, 1);
    if ((paramString != null) && (!paramString.shouldShowInRecentList())) {
      paramQQAppInterface.b(paramString);
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
  
  public int a(QQAppInterface paramQQAppInterface, String paramString)
  {
    return paramQQAppInterface.b(paramString);
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
            if ((!TextUtils.isEmpty(str)) && (!adic.a(str, 1, paramQQAppInterface))) {
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
            if (adic.a(localTroopAssistantData.troopUin, 1, paramQQAppInterface)) {
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
    ArrayList localArrayList1 = ((TroopManager)paramQQAppInterface.getManager(52)).a();
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
  
  public void a(aukp paramaukp, QQAppInterface paramQQAppInterface)
  {
    try
    {
      a(paramQQAppInterface);
      aktf localaktf = paramQQAppInterface.a().a();
      Object localObject2 = localaktf.a(false);
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
          localObject3 = a(paramaukp, paramQQAppInterface, ((RecentUser)localObject2).uin);
          ((TroopAssistantData)localObject3).lastdrafttime = ((RecentUser)localObject2).lastmsgdrafttime;
          QQMessageFacade.Message localMessage;
          if (((RecentUser)localObject2).lastmsgtime == 0L)
          {
            localMessage = paramQQAppInterface.a().a(((TroopAssistantData)localObject3).troopUin, 1);
            if (localMessage == null) {}
          }
          for (((TroopAssistantData)localObject3).lastmsgtime = localMessage.time;; ((TroopAssistantData)localObject3).lastmsgtime = ((RecentUser)localObject2).lastmsgtime)
          {
            a(paramaukp, (TroopAssistantData)localObject3);
            localaktf.b((RecentUser)localObject2);
            e(((TroopAssistantData)localObject3).troopUin, paramQQAppInterface);
            break;
          }
        }
      }
      a(paramQQAppInterface, 0, l1);
      paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0).edit().putBoolean("init_troop_assistant", false).commit();
      return;
    }
    catch (Exception paramaukp) {}
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
          paramQQAppInterface = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
          a(paramQQAppInterface);
          paramQQAppInterface.a();
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
  
  public void a(QQAppInterface paramQQAppInterface, mxj parammxj)
  {
    ThreadManager.post(new TroopAssistantManager.2(this, paramQQAppInterface, parammxj), 8, null, true);
  }
  
  public void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0).edit().putBoolean("troop_assistant_be_del", paramBoolean).commit();
    this.e = paramBoolean;
  }
  
  public void a(MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    aukp localaukp = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    a(paramMessageRecord, paramMessageRecord.frienduin, paramMessageRecord.time, localaukp, paramQQAppInterface);
    localaukp.a();
  }
  
  public void a(MessageRecord paramMessageRecord, String paramString, long paramLong, aukp paramaukp, QQAppInterface paramQQAppInterface)
  {
    TroopAssistantData localTroopAssistantData = a(paramaukp, paramQQAppInterface, paramString);
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
      a(paramaukp, localTroopAssistantData);
      a(paramMessageRecord, paramString, paramQQAppInterface);
      if (this.e) {
        a(paramQQAppInterface, false);
      }
      d(paramQQAppInterface, paramString);
      a(paramQQAppInterface, 0, paramLong);
      return;
    }
  }
  
  public void a(String paramString, long paramLong, aukp paramaukp, QQAppInterface paramQQAppInterface)
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
      localTroopAssistantData = a(paramaukp, paramQQAppInterface, paramString);
      break;
      label94:
      a(paramaukp, localTroopAssistantData);
    }
  }
  
  public void a(String paramString, QQAppInterface paramQQAppInterface)
  {
    aukp localaukp = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    aktf localaktf = paramQQAppInterface.a().a();
    RecentUser localRecentUser = localaktf.b(paramString, 1);
    QQMessageFacade.Message localMessage;
    if (localRecentUser != null)
    {
      paramString = a(localaukp, paramQQAppInterface, paramString);
      if (localRecentUser.lastmsgtime != 0L) {
        break label271;
      }
      localMessage = paramQQAppInterface.a().a(paramString.troopUin, 1);
      if (localMessage == null) {}
    }
    label271:
    for (paramString.lastmsgtime = localMessage.time;; paramString.lastmsgtime = localRecentUser.lastmsgtime)
    {
      paramString.lastdrafttime = localRecentUser.lastmsgdrafttime;
      a(localaukp, paramString);
      e(paramString.troopUin, paramQQAppInterface);
      ahnl.a().a(localRecentUser.uin + "-" + localRecentUser.getType());
      if ((!(localRecentUser.msg instanceof ahpy)) && (!(localRecentUser.msg instanceof ahqp)) && (!(localRecentUser.msg instanceof ahqb)) && (!(localRecentUser.msg instanceof ahqh)) && (!(localRecentUser.msg instanceof ahpx)) && (!(localRecentUser.msg instanceof bhya)) && (!(localRecentUser.msg instanceof ahqm)) && (!(localRecentUser.msg instanceof ahqg)) && (!(localRecentUser.msg instanceof ahqj))) {
        localaktf.b(localRecentUser);
      }
      paramString = a(paramQQAppInterface);
      if (paramString != null) {
        a(paramQQAppInterface, 0, paramString.lastmsgtime);
      }
      localaukp.a();
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
          if (adic.a(localTroopAssistantData.troopUin, 1, paramQQAppInterface)) {
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
      this.jdField_a_of_type_JavaUtilSet = bbkc.a((SharedPreferences)localObject2, "troop_assis_new_unread_list", null);
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
    aukp localaukp = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    if (a(localaukp, paramString)) {
      d(paramString, paramQQAppInterface);
    }
    localaukp.a();
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
          if (adic.a(localTroopAssistantData.troopUin, 1, paramQQAppInterface))
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
      aukp localaukp = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
      localObject = localaukp;
      TroopAssistantData localTroopAssistantData = a(paramQQAppInterface, paramString);
      localObject = localaukp;
      aktf localaktf = paramQQAppInterface.a().a();
      if (localTroopAssistantData != null)
      {
        localObject = localaukp;
        RecentUser localRecentUser = localaktf.a(String.valueOf(localTroopAssistantData.troopUin), 1);
        localObject = localaukp;
        localRecentUser.uin = localTroopAssistantData.troopUin;
        localObject = localaukp;
        localRecentUser.setType(1);
        localObject = localaukp;
        localRecentUser.lastmsgtime = localTroopAssistantData.lastmsgtime;
        localObject = localaukp;
        localRecentUser.lastmsgdrafttime = localTroopAssistantData.lastdrafttime;
        localObject = localaukp;
        if (a(localaukp, paramString))
        {
          localObject = localaukp;
          localaktf.a(localRecentUser);
          localObject = localaukp;
          d(paramString, paramQQAppInterface);
        }
      }
      localObject = localaukp;
      paramString = a(paramQQAppInterface);
      if (paramString != null)
      {
        localObject = localaukp;
        a(paramQQAppInterface, 0, paramString.lastmsgtime);
      }
      return;
    }
    finally
    {
      if (localObject != null) {
        localObject.a();
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
    aukp localaukp = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    Object localObject3 = new ArrayList();
    Object localObject2 = new ArrayList();
    ??? = ((aktf)localObject1).a(false);
    Object localObject5;
    if ((??? != null) && (((List)???).size() > 0))
    {
      ??? = ((List)???).iterator();
      while (((Iterator)???).hasNext())
      {
        localObject5 = (RecentUser)((Iterator)???).next();
        if ((((RecentUser)localObject5).getType() == 1) && (a(paramQQAppInterface, ((RecentUser)localObject5).uin)) && (!((RecentUser)localObject5).shouldShowInRecentList())) {
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
        localObject5 = a(localaukp, paramQQAppInterface, ((RecentUser)???).uin);
        if (((RecentUser)???).lastmsgtime == 0L)
        {
          localObject6 = paramQQAppInterface.a().a(((TroopAssistantData)localObject5).troopUin, 1);
          if (localObject6 == null) {}
        }
        for (((TroopAssistantData)localObject5).lastmsgtime = ((QQMessageFacade.Message)localObject6).time;; ((TroopAssistantData)localObject5).lastmsgtime = ((RecentUser)???).lastmsgtime)
        {
          a(localaukp, (TroopAssistantData)localObject5);
          ((aktf)localObject1).b((RecentUser)???);
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
        ??? = ((aktf)localObject1).a(((TroopAssistantData)localObject3).troopUin, 1);
        ((RecentUser)???).uin = ((TroopAssistantData)localObject3).troopUin;
        ((RecentUser)???).setType(1);
        ((RecentUser)???).lastmsgtime = ((TroopAssistantData)localObject3).lastmsgtime;
        ((RecentUser)???).lastmsgdrafttime = ((TroopAssistantData)localObject3).lastdrafttime;
        if (a(localaukp, ((TroopAssistantData)localObject3).troopUin))
        {
          ((aktf)localObject1).a((RecentUser)???);
          d(((TroopAssistantData)localObject3).troopUin, paramQQAppInterface);
        }
      }
    }
    localObject1 = a(paramQQAppInterface);
    if (localObject1 != null) {
      a(paramQQAppInterface, 0, ((TroopAssistantData)localObject1).lastmsgtime);
    }
    if (localaukp != null) {
      localaukp.a();
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
          if (adic.a(localTroopAssistantData.troopUin, 1, paramQQAppInterface)) {
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
      aukp localaukp;
      if (a(paramQQAppInterface) == true)
      {
        localaukp = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
        a().a(localaukp, paramQQAppInterface);
        localaukp.a();
      }
      c(paramQQAppInterface);
      if (asff.a().a(paramQQAppInterface) == true)
      {
        localaukp = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
        asff.a().a(localaukp, paramQQAppInterface);
        localaukp.a();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     asfd
 * JD-Core Version:    0.7.0.1
 */