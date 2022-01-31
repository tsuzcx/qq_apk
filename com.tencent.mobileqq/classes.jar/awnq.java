import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.PrecoverConfig;
import com.tencent.mobileqq.data.PrecoverResource;
import com.tencent.mobileqq.data.PrecoverResourceBusiness;
import com.tencent.mobileqq.data.PrecoverRetryInfo;
import com.tencent.mobileqq.precover.PrecoverManager.1;
import com.tencent.mobileqq.precover.PrecoverManager.2;
import com.tencent.mobileqq.precover.PrecoverManager.4;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.manager.Manager;

public class awnq
  implements awnp, Manager
{
  private static Set<Integer> jdField_a_of_type_JavaUtilSet = new HashSet();
  private awgf jdField_a_of_type_Awgf;
  private awno jdField_a_of_type_Awno;
  private awnr jdField_a_of_type_Awnr;
  private awns jdField_a_of_type_Awns;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private final HashMap<String, List<PrecoverResource>> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private HashSet<PrecoverResource> jdField_a_of_type_JavaUtilHashSet;
  private boolean jdField_a_of_type_Boolean;
  private final byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  private awnm[] jdField_a_of_type_ArrayOfAwnm = new awnm[jdField_a_of_type_JavaUtilSet.size()];
  private final HashMap<String, PrecoverResource> b = new HashMap();
  
  static
  {
    jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(0));
  }
  
  public awnq(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Awgf = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    this.jdField_a_of_type_Awns = new awns(paramQQAppInterface, this);
    this.jdField_a_of_type_Awno = awno.a();
    this.jdField_a_of_type_Awnr = new awnr(this);
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      ThreadManager.post(new PrecoverManager.1(this), 10, null, false);
      return;
    }
    b();
  }
  
  private PrecoverRetryInfo a(PrecoverResource paramPrecoverResource)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PrecoverManager", 2, "getRetryInfo, res=" + paramPrecoverResource);
    }
    if (paramPrecoverResource == null) {
      return null;
    }
    try
    {
      paramPrecoverResource = this.jdField_a_of_type_Awgf.a(PrecoverRetryInfo.class, false, "pk = ?", new String[] { paramPrecoverResource.businessId + "_" + paramPrecoverResource.md5 }, null, null, null, null);
      if ((paramPrecoverResource != null) && (paramPrecoverResource.size() > 0))
      {
        paramPrecoverResource = (PrecoverRetryInfo)paramPrecoverResource.get(0);
        return paramPrecoverResource;
      }
    }
    catch (Exception paramPrecoverResource)
    {
      for (;;)
      {
        if (QLog.isColorLevel())
        {
          QLog.d("PrecoverManager", 2, new Object[] { "getRetryInfo, exception=", paramPrecoverResource.getMessage() });
          paramPrecoverResource.printStackTrace();
        }
        paramPrecoverResource = null;
        continue;
        paramPrecoverResource = null;
      }
    }
  }
  
  private <T extends PrecoverResource> List<T> a(String paramString, Class<T> paramClass)
  {
    return a("businessId = ?", new String[] { paramString }, paramClass);
  }
  
  private void a(awge paramawge)
  {
    if (QLog.isColorLevel()) {
      if (paramawge != null) {
        break label37;
      }
    }
    label37:
    for (Object localObject = "null";; localObject = paramawge)
    {
      QLog.d("PrecoverManager", 2, new Object[] { "insertEntity, entity=", localObject });
      if (paramawge != null) {
        break;
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PrecoverManager", 2, new Object[] { "insertEntity, entity.Name=", paramawge.getClass().getSimpleName() });
    }
    localObject = this.jdField_a_of_type_Awgf.a();
    try
    {
      ((awgh)localObject).a();
      this.jdField_a_of_type_Awgf.b(paramawge);
      ((awgh)localObject).c();
      return;
    }
    catch (Exception paramawge)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("PrecoverManager", 2, new Object[] { "insertEntity, exception=", paramawge.getMessage() });
        paramawge.printStackTrace();
      }
      return;
    }
    finally
    {
      ((awgh)localObject).b();
    }
  }
  
  private void a(PrecoverRetryInfo paramPrecoverRetryInfo)
  {
    if (QLog.isColorLevel()) {
      if (paramPrecoverRetryInfo != null) {
        break label38;
      }
    }
    label38:
    for (Object localObject = "null";; localObject = paramPrecoverRetryInfo)
    {
      QLog.d("PrecoverManager", 2, new Object[] { "updateRetryInfo, retryInfo=", localObject });
      if (paramPrecoverRetryInfo != null) {
        break;
      }
      return;
    }
    a(paramPrecoverRetryInfo);
  }
  
  private boolean a(Class<? extends awge> paramClass)
  {
    return a("delete_all", paramClass);
  }
  
  /* Error */
  private boolean a(String paramString, Class<? extends awge> paramClass)
  {
    // Byte code:
    //   0: invokestatic 141	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +43 -> 46
    //   6: aload_1
    //   7: ifnonnull +74 -> 81
    //   10: ldc 225
    //   12: astore_3
    //   13: ldc 143
    //   15: iconst_2
    //   16: iconst_4
    //   17: anewarray 4	java/lang/Object
    //   20: dup
    //   21: iconst_0
    //   22: ldc_w 272
    //   25: aastore
    //   26: dup
    //   27: iconst_1
    //   28: aload_3
    //   29: aastore
    //   30: dup
    //   31: iconst_2
    //   32: ldc_w 274
    //   35: aastore
    //   36: dup
    //   37: iconst_3
    //   38: aload_2
    //   39: invokevirtual 238	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   42: aastore
    //   43: invokestatic 200	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   46: aload_1
    //   47: invokestatic 280	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   50: ifne +29 -> 79
    //   53: aload_2
    //   54: ldc 171
    //   56: if_acmpeq +30 -> 86
    //   59: aload_2
    //   60: ldc_w 282
    //   63: if_acmpeq +23 -> 86
    //   66: aload_2
    //   67: ldc 165
    //   69: if_acmpeq +17 -> 86
    //   72: aload_2
    //   73: ldc_w 284
    //   76: if_acmpeq +10 -> 86
    //   79: iconst_0
    //   80: ireturn
    //   81: aload_1
    //   82: astore_3
    //   83: goto -70 -> 13
    //   86: aload_0
    //   87: getfield 82	awnq:jdField_a_of_type_Awgf	Lawgf;
    //   90: invokevirtual 241	awgf:a	()Lawgh;
    //   93: astore_3
    //   94: aload_3
    //   95: invokevirtual 245	awgh:a	()V
    //   98: aload_2
    //   99: invokevirtual 238	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   102: astore_2
    //   103: aload_1
    //   104: ldc_w 269
    //   107: invokevirtual 287	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   110: ifeq +63 -> 173
    //   113: ldc_w 289
    //   116: iconst_1
    //   117: anewarray 4	java/lang/Object
    //   120: dup
    //   121: iconst_0
    //   122: aload_2
    //   123: aastore
    //   124: invokestatic 293	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   127: astore_1
    //   128: invokestatic 141	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   131: ifeq +23 -> 154
    //   134: ldc 143
    //   136: iconst_2
    //   137: iconst_2
    //   138: anewarray 4	java/lang/Object
    //   141: dup
    //   142: iconst_0
    //   143: ldc_w 295
    //   146: aastore
    //   147: dup
    //   148: iconst_1
    //   149: aload_1
    //   150: aastore
    //   151: invokestatic 200	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   154: aload_0
    //   155: getfield 82	awnq:jdField_a_of_type_Awgf	Lawgf;
    //   158: aload_1
    //   159: invokevirtual 298	awgf:b	(Ljava/lang/String;)Z
    //   162: pop
    //   163: aload_3
    //   164: invokevirtual 250	awgh:c	()V
    //   167: aload_3
    //   168: invokevirtual 251	awgh:b	()V
    //   171: iconst_1
    //   172: ireturn
    //   173: ldc_w 300
    //   176: iconst_2
    //   177: anewarray 4	java/lang/Object
    //   180: dup
    //   181: iconst_0
    //   182: aload_2
    //   183: aastore
    //   184: dup
    //   185: iconst_1
    //   186: aload_1
    //   187: aastore
    //   188: invokestatic 293	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   191: astore_1
    //   192: goto -64 -> 128
    //   195: astore_1
    //   196: invokestatic 141	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   199: ifeq +30 -> 229
    //   202: ldc 143
    //   204: iconst_2
    //   205: iconst_2
    //   206: anewarray 4	java/lang/Object
    //   209: dup
    //   210: iconst_0
    //   211: ldc_w 302
    //   214: aastore
    //   215: dup
    //   216: iconst_1
    //   217: aload_1
    //   218: invokevirtual 197	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   221: aastore
    //   222: invokestatic 200	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   225: aload_1
    //   226: invokevirtual 203	java/lang/Exception:printStackTrace	()V
    //   229: aload_3
    //   230: invokevirtual 251	awgh:b	()V
    //   233: iconst_0
    //   234: ireturn
    //   235: astore_1
    //   236: aload_3
    //   237: invokevirtual 251	awgh:b	()V
    //   240: aload_1
    //   241: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	242	0	this	awnq
    //   0	242	1	paramString	String
    //   0	242	2	paramClass	Class<? extends awge>
    //   12	225	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   94	128	195	java/lang/Exception
    //   128	154	195	java/lang/Exception
    //   154	167	195	java/lang/Exception
    //   173	192	195	java/lang/Exception
    //   94	128	235	finally
    //   128	154	235	finally
    //   154	167	235	finally
    //   173	192	235	finally
    //   196	229	235	finally
  }
  
  private static String b(PrecoverResource paramPrecoverResource)
  {
    return paramPrecoverResource.businessId + "_" + paramPrecoverResource.md5;
  }
  
  private void b()
  {
    Object localObject5;
    Object localObject6;
    List localList;
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("PrecoverManager", 2, "initCache");
      }
      Object localObject1 = a(null, null, PrecoverResource.class);
      localObject5 = a(null, null, PrecoverResourceBusiness.class);
      synchronized (this.jdField_a_of_type_ArrayOfByte)
      {
        this.jdField_a_of_type_JavaUtilHashMap.clear();
        this.b.clear();
        if ((localObject1 != null) && (((List)localObject1).size() > 0))
        {
          localObject6 = ((List)localObject1).iterator();
          while (((Iterator)localObject6).hasNext())
          {
            PrecoverResource localPrecoverResource = (PrecoverResource)((Iterator)localObject6).next();
            if (localPrecoverResource.isValid())
            {
              localList = (List)this.jdField_a_of_type_JavaUtilHashMap.get(localPrecoverResource.businessId);
              localObject1 = localList;
              if (localList == null) {
                localObject1 = new ArrayList();
              }
              ((List)localObject1).add(localPrecoverResource);
              this.jdField_a_of_type_JavaUtilHashMap.put(localPrecoverResource.businessId, localObject1);
              this.b.put(b(localPrecoverResource), localPrecoverResource);
            }
          }
        }
      }
      if (localObject5 == null) {
        break label315;
      }
    }
    finally {}
    if (((List)localObject5).size() > 0)
    {
      localObject5 = ((List)localObject5).iterator();
      while (((Iterator)localObject5).hasNext())
      {
        localObject6 = (PrecoverResource)((Iterator)localObject5).next();
        if (((PrecoverResource)localObject6).isValid())
        {
          localList = (List)this.jdField_a_of_type_JavaUtilHashMap.get(((PrecoverResource)localObject6).businessId);
          Object localObject4 = localList;
          if (localList == null) {
            localObject4 = new ArrayList();
          }
          ((List)localObject4).add(localObject6);
          this.jdField_a_of_type_JavaUtilHashMap.put(((PrecoverResource)localObject6).businessId, localObject4);
          this.b.put(b((PrecoverResource)localObject6), localObject6);
        }
      }
    }
    label315:
  }
  
  private boolean b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PrecoverManager", 2, "isNetworkCanDown");
    }
    int i = this.jdField_a_of_type_Awno.a;
    if (i == 2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PrecoverManager", 2, "isNetworkCanDown, return true, param == 2");
      }
      return true;
    }
    int j = bdin.a(BaseApplicationImpl.getContext());
    boolean bool;
    if (i == 0) {
      if (j == 1) {
        bool = true;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PrecoverManager", 2, new Object[] { "isNetworkCanDown, param=", Integer.valueOf(i), ", netType=", Integer.valueOf(j), ", result=", Boolean.valueOf(bool) });
      }
      return bool;
      bool = false;
      continue;
      if (i == 1)
      {
        if ((j == 1) || (j == 4) || (j == 3)) {
          bool = true;
        } else {
          bool = false;
        }
      }
      else if (i == 3)
      {
        if ((j == 1) || (j == 4)) {
          bool = true;
        } else {
          bool = false;
        }
      }
      else {
        bool = false;
      }
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Awno != null) {
      return this.jdField_a_of_type_Awno.a;
    }
    return 0;
  }
  
  public awno a()
  {
    return this.jdField_a_of_type_Awno;
  }
  
  public awnr a()
  {
    return this.jdField_a_of_type_Awnr;
  }
  
  public awns a()
  {
    return this.jdField_a_of_type_Awns;
  }
  
  public QQAppInterface a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  }
  
  public PrecoverResource a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return null;
    }
    return (PrecoverResource)this.b.get(paramString1 + "_" + paramString2);
  }
  
  protected HashMap<String, List<PrecoverResource>> a()
  {
    return this.jdField_a_of_type_JavaUtilHashMap;
  }
  
  protected <T extends awge> List<T> a(String paramString, String[] paramArrayOfString, Class<T> paramClass)
  {
    String str;
    if (QLog.isColorLevel())
    {
      if (paramString != null) {
        break label111;
      }
      str = "null";
      if (paramArrayOfString != null) {
        break label117;
      }
    }
    label111:
    label117:
    for (Object localObject = "null";; localObject = paramArrayOfString)
    {
      QLog.d("PrecoverManager", 2, new Object[] { "queryAll, selction=", str, ", selectionArgs=", localObject, ", clz=", paramClass.getSimpleName() });
      if ((paramClass == PrecoverResource.class) || (paramClass == PrecoverResourceBusiness.class) || (paramClass == PrecoverRetryInfo.class) || (paramClass == PrecoverConfig.class)) {
        break label123;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PrecoverManager", 2, "queryAll, clz not valid");
      }
      return null;
      str = paramString;
      break;
    }
    try
    {
      label123:
      paramString = this.jdField_a_of_type_Awgf.a(paramClass, false, paramString, paramArrayOfString, null, null, null, null);
      return paramString;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("PrecoverManager", 2, new Object[] { "queryAll, exception=", paramString.getMessage() });
        paramString.printStackTrace();
      }
    }
    return null;
  }
  
  public void a()
  {
    try
    {
      a(null);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(int paramInt, String paramString, PrecoverResource paramPrecoverResource, Object paramObject)
  {
    if ((!this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_JavaUtilHashSet == null)) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("PrecoverManager", 2, new Object[] { "onDownloadFinish, needReport, mReportSet.size=", Integer.valueOf(this.jdField_a_of_type_JavaUtilHashSet.size()), ", res=", paramPrecoverResource });
      }
      this.jdField_a_of_type_JavaUtilHashSet.remove(paramPrecoverResource);
    } while (this.jdField_a_of_type_JavaUtilHashSet.size() != 0);
    if (QLog.isColorLevel()) {
      QLog.d("PrecoverManager", 2, "onDownloadFinish, download finish, doing report");
    }
    this.jdField_a_of_type_Awns.b(this);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilHashSet = null;
    ThreadManager.post(new PrecoverManager.4(this), 5, null, false);
  }
  
  protected void a(PrecoverResource paramPrecoverResource)
  {
    if (paramPrecoverResource == null) {}
    PrecoverRetryInfo localPrecoverRetryInfo;
    do
    {
      return;
      localPrecoverRetryInfo = a(paramPrecoverResource);
      if (QLog.isColorLevel()) {
        QLog.d("PrecoverManager", 2, "deleteRertyInfo, info=" + localPrecoverRetryInfo);
      }
    } while (localPrecoverRetryInfo == null);
    paramPrecoverResource = this.jdField_a_of_type_Awgf.a();
    try
    {
      paramPrecoverResource.a();
      this.jdField_a_of_type_Awgf.b(localPrecoverRetryInfo);
      paramPrecoverResource.c();
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("PrecoverManager", 2, new Object[] { "deleteRertyInfo, exception=", localException.getMessage() });
        localException.printStackTrace();
      }
      return;
    }
    finally
    {
      paramPrecoverResource.b();
    }
  }
  
  public void a(PrecoverResource paramPrecoverResource, Object paramObject, long paramLong1, long paramLong2) {}
  
  protected void a(String paramString)
  {
    if (paramString == null) {}
    for (String str = "null";; str = paramString)
    {
      QLog.d("PrecoverManager", 1, new Object[] { "startDownload, businessId=", str });
      ThreadManager.post(new PrecoverManager.2(this, paramString), 5, null, false);
      return;
    }
  }
  
  public void a(List<Pair<Integer, String>> arg1)
  {
    Object localObject1;
    if (??? == null) {
      localObject1 = "null";
    }
    for (;;)
    {
      Object localObject3;
      Object localObject5;
      try
      {
        QLog.d("PrecoverManager", 1, new Object[] { "onHandleConfigs, configList.size=", localObject1 });
        if ((??? == null) || (???.size() == 0))
        {
          a(PrecoverConfig.class);
          a(PrecoverResource.class);
          return;
          localObject1 = Integer.valueOf(???.size());
          continue;
        }
        a(PrecoverConfig.class);
        localObject3 = new HashMap();
        localObject1 = new HashMap();
        ??? = ???.iterator();
        Object localObject4;
        if (???.hasNext())
        {
          localObject4 = (Pair)???.next();
          if ((localObject4 == null) || (TextUtils.isEmpty((CharSequence)((Pair)localObject4).second))) {
            continue;
          }
          int i = ((Integer)((Pair)localObject4).first).intValue();
          localObject5 = awnw.a((String)((Pair)localObject4).second);
          if ((localObject5 == null) || (((Pair)localObject5).first == null) || (((Pair)localObject5).second == null)) {
            continue;
          }
          if (QLog.isColorLevel()) {
            QLog.d("PrecoverManager", 2, new Object[] { "onHandleConfigs, businessid=", ((awnn)((Pair)localObject5).first).a, ", name=", ((awnn)((Pair)localObject5).first).b, ", list.size=", Integer.valueOf(((List)((Pair)localObject5).second).size()) });
          }
          if (TextUtils.isEmpty(((awnn)((Pair)localObject5).first).a)) {
            continue;
          }
          String str = ((awnn)((Pair)localObject5).first).a;
          if ((((HashMap)localObject3).containsKey(str)) && (((Integer)((HashMap)localObject3).get(str)).intValue() >= i)) {
            continue;
          }
          ((HashMap)localObject3).put(str, Integer.valueOf(i));
          ((HashMap)localObject1).put(str, ((Pair)localObject5).second);
          a(new PrecoverConfig(str, (String)((Pair)localObject4).second, i));
          continue;
        }
        synchronized (this.jdField_a_of_type_ArrayOfByte)
        {
          a(PrecoverResource.class);
          localObject3 = ((HashMap)localObject1).keySet().iterator();
          do
          {
            while (!((Iterator)localObject4).hasNext())
            {
              do
              {
                if (!((Iterator)localObject3).hasNext()) {
                  break;
                }
                localObject4 = (List)((HashMap)localObject1).get((String)((Iterator)localObject3).next());
              } while ((localObject4 == null) || (((List)localObject4).size() <= 0));
              localObject4 = ((List)localObject4).iterator();
            }
            localObject5 = (PrecoverResource)((Iterator)localObject4).next();
            if (!((PrecoverResource)localObject5).isValid()) {
              break;
            }
            a((awge)localObject5);
          } while (!QLog.isColorLevel());
          QLog.d("PrecoverManager", 2, "onHandleConfigs, insert res:" + localObject5);
        }
      }
      finally {}
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PrecoverManager", 2, "onHandleConfigs, res invalid:" + localObject5);
        }
      }
      ??? = new StringBuilder();
      if (localObject2.size() > 0)
      {
        ???.append(" WHERE businessId NOT IN (");
        Iterator localIterator = localObject2.keySet().iterator();
        while (localIterator.hasNext())
        {
          localObject3 = (String)localIterator.next();
          ???.append("'").append((String)localObject3).append("',");
        }
        ???.setCharAt(???.length() - 1, ')');
      }
      if (QLog.isColorLevel()) {
        QLog.d("PrecoverManager", 2, "onHandleConfigs, selection of sql=" + ???.toString());
      }
      a("DELETE FROM " + PrecoverResourceBusiness.class.getSimpleName() + ???.toString());
      a("DELETE FROM " + PrecoverRetryInfo.class.getSimpleName() + ???.toString());
      b();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    boolean bool = awnw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "_config_cover");
    if (QLog.isColorLevel()) {
      QLog.d("PrecoverManager", 2, new Object[] { "checkReportConfigCover, succ=", Boolean.valueOf(paramBoolean), ", need=", Boolean.valueOf(bool) });
    }
    if (bool)
    {
      awnw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "_config_cover");
      this.jdField_a_of_type_Awnr.a(paramBoolean);
    }
  }
  
  public boolean a()
  {
    boolean bool = awnw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), "get_config_time");
    int j = awnw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "get_config_count", 0);
    if (bool)
    {
      awnw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), "get_config_time");
      awnw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "get_config_count", 1);
      return true;
    }
    if (a() != null) {}
    for (int i = a().f; j >= i; i = 5) {
      return false;
    }
    awnw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "get_config_count", j + 1);
    return true;
  }
  
  protected boolean a(PrecoverResource paramPrecoverResource)
  {
    if ((paramPrecoverResource == null) || (!paramPrecoverResource.isValid())) {}
    do
    {
      PrecoverRetryInfo localPrecoverRetryInfo;
      long l;
      do
      {
        do
        {
          return false;
          if (b()) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("PrecoverManager", 2, "canDownload, networkRight, return false");
        return false;
        localPrecoverRetryInfo = a(paramPrecoverResource);
        l = System.currentTimeMillis();
        if (localPrecoverRetryInfo == null)
        {
          localPrecoverRetryInfo = new PrecoverRetryInfo();
          localPrecoverRetryInfo.businessId = paramPrecoverResource.businessId;
          localPrecoverRetryInfo.md5 = paramPrecoverResource.md5;
          localPrecoverRetryInfo.itemRetryCount = 1;
          localPrecoverRetryInfo.totalRetryCount = 1;
          localPrecoverRetryInfo.retryUpdateTime = l;
          a(localPrecoverRetryInfo);
          if (QLog.isColorLevel()) {
            QLog.d("PrecoverManager", 2, "canDownload, info == null, return true");
          }
          return true;
        }
        if (localPrecoverRetryInfo.totalRetryCount <= this.jdField_a_of_type_Awno.c) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("PrecoverManager", 2, "canDownload, info.totalRetryCount > mControl.totalRetry, return false");
      return false;
      if (Math.abs(l - localPrecoverRetryInfo.retryUpdateTime) > 86400000L)
      {
        localPrecoverRetryInfo.itemRetryCount = 1;
        localPrecoverRetryInfo.totalRetryCount += 1;
        localPrecoverRetryInfo.retryUpdateTime = l;
        a(localPrecoverRetryInfo);
        if (QLog.isColorLevel()) {
          QLog.d("PrecoverManager", 2, "canDownload, daily count expire, return true");
        }
        return true;
      }
      if (localPrecoverRetryInfo.itemRetryCount < this.jdField_a_of_type_Awno.b)
      {
        localPrecoverRetryInfo.itemRetryCount += 1;
        localPrecoverRetryInfo.totalRetryCount += 1;
        localPrecoverRetryInfo.retryUpdateTime = l;
        a(localPrecoverRetryInfo);
        if (QLog.isColorLevel()) {
          QLog.d("PrecoverManager", 2, "canDownload, info.itemRetryCount < mControl.itemRetry, return true");
        }
        return true;
      }
    } while (!QLog.isColorLevel());
    QLog.d("PrecoverManager", 2, "canDownload, return false");
    return false;
  }
  
  protected boolean a(String paramString)
  {
    if (QLog.isColorLevel()) {
      if (paramString != null) {
        break label64;
      }
    }
    for (localObject = "null";; localObject = paramString)
    {
      QLog.d("PrecoverManager", 2, new Object[] { "execSql, businessId=", localObject });
      localObject = this.jdField_a_of_type_Awgf.a();
      try
      {
        ((awgh)localObject).a();
        this.jdField_a_of_type_Awgf.b(paramString);
        ((awgh)localObject).c();
        return true;
      }
      catch (Exception paramString)
      {
        label64:
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("PrecoverManager", 2, new Object[] { "execSql, exception=", paramString.getMessage() });
        paramString.printStackTrace();
        return false;
      }
      finally
      {
        ((awgh)localObject).b();
      }
    }
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awnq
 * JD-Core Version:    0.7.0.1
 */