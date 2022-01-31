import android.database.Observable;
import android.os.Handler;
import android.os.Message;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import mqq.app.MobileQQ;

public class bcmu
  extends Observable<bbtc>
{
  public static Map<Long, bcmu> a;
  public int a;
  public long a;
  public alpa a;
  public Handler a;
  public ArrayMap<Integer, List<bbtf>> a;
  public bcnb a;
  public QQAppInterface a;
  public TroopFileTransferManager a;
  public String a;
  private ytx jdField_a_of_type_Ytx = new bcmx(this);
  private yua jdField_a_of_type_Yua = new bcmz(this);
  private yul jdField_a_of_type_Yul = new bcmy(this);
  public int b;
  public bcnb b;
  public Map<UUID, bbsa> b;
  public Map<String, bbsa> c = new HashMap();
  public Map<String, bcna> d = new HashMap();
  
  static
  {
    if (!bcmu.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      jdField_a_of_type_Boolean = bool;
      jdField_a_of_type_JavaUtilMap = new HashMap();
      return;
    }
  }
  
  public bcmu(QQAppInterface paramQQAppInterface, long paramLong)
  {
    this.jdField_b_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_AndroidSupportV4UtilArrayMap = new ArrayMap();
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Bcnb = new bcnc();
    this.jdField_b_of_type_Bcnb = new bcnd();
    this.jdField_a_of_type_Alpa = new bcmw(this);
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager = TroopFileTransferManager.a(paramQQAppInterface, paramLong);
    Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager.a().iterator();
    while (localIterator.hasNext())
    {
      bbtn localbbtn = (bbtn)localIterator.next();
      bbsa localbbsa = new bbsa();
      localbbsa.jdField_a_of_type_JavaUtilUUID = localbbtn.jdField_a_of_type_JavaUtilUUID;
      localbbsa.a(localbbtn, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_b_of_type_JavaUtilMap.put(localbbsa.jdField_a_of_type_JavaUtilUUID, localbbsa);
      if ((localbbsa.b != null) && (!"/".equals(localbbsa.b))) {
        this.c.put(localbbsa.b, localbbsa);
      }
    }
    this.jdField_a_of_type_AndroidOsHandler = new bcmv(this, paramQQAppInterface.getApplication().getMainLooper());
    paramQQAppInterface.addObserver(this.jdField_a_of_type_Alpa);
  }
  
  public static bcmu a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    try
    {
      bcmu localbcmu2 = (bcmu)jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramLong));
      bcmu localbcmu1;
      if (localbcmu2 != null)
      {
        localbcmu1 = localbcmu2;
        if (localbcmu2.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == paramQQAppInterface) {}
      }
      else
      {
        localbcmu1 = new bcmu(paramQQAppInterface, paramLong);
        jdField_a_of_type_JavaUtilMap.put(Long.valueOf(paramLong), localbcmu1);
      }
      return localbcmu1;
    }
    finally {}
  }
  
  public static List<bbsa> a(Collection<bbsa> paramCollection, bcnb parambcnb)
  {
    ArrayList localArrayList = new ArrayList();
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      bbsa localbbsa = (bbsa)paramCollection.next();
      if (parambcnb.a(localbbsa)) {
        localArrayList.add(localbbsa);
      }
    }
    return localArrayList;
  }
  
  public static void a()
  {
    
    try
    {
      Iterator localIterator = jdField_a_of_type_JavaUtilMap.values().iterator();
      while (localIterator.hasNext()) {
        ((bcmu)localIterator.next()).c();
      }
      jdField_a_of_type_JavaUtilMap.clear();
    }
    finally {}
  }
  
  private void c()
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Alpa);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  /* Error */
  public bbsa a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 52	bcmu:c	Ljava/util/Map;
    //   6: ifnull +21 -> 27
    //   9: aload_0
    //   10: getfield 52	bcmu:c	Ljava/util/Map;
    //   13: aload_1
    //   14: invokeinterface 186 2 0
    //   19: checkcast 128	bbsa
    //   22: astore_1
    //   23: aload_0
    //   24: monitorexit
    //   25: aload_1
    //   26: areturn
    //   27: aconst_null
    //   28: astore_1
    //   29: goto -6 -> 23
    //   32: astore_1
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_1
    //   36: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	37	0	this	bcmu
    //   0	37	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   2	23	32	finally
  }
  
  public bbsa a(String paramString, long paramLong, int paramInt)
  {
    try
    {
      bbsa localbbsa = new bbsa();
      localbbsa.jdField_a_of_type_JavaUtilUUID = UUID.randomUUID();
      localbbsa.c = paramString;
      localbbsa.jdField_a_of_type_Long = paramLong;
      localbbsa.jdField_a_of_type_Int = paramInt;
      localbbsa.a((int)NetConnInfoCenter.getServerTime());
      this.jdField_b_of_type_JavaUtilMap.put(localbbsa.jdField_a_of_type_JavaUtilUUID, localbbsa);
      return localbbsa;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public bbsa a(String paramString1, String paramString2, long paramLong, int paramInt)
  {
    if (paramString1 == null) {
      paramString1 = null;
    }
    for (;;)
    {
      return paramString1;
      Object localObject1;
      label34:
      try
      {
        localObject1 = bbvj.a(paramString1);
        if (localObject1 == null) {
          break label271;
        }
        if (((String)localObject1).length() != 0) {
          break label268;
        }
      }
      finally {}
      Object localObject2 = (bbsa)this.c.get(paramString1);
      if (localObject2 != null)
      {
        this.jdField_b_of_type_JavaUtilMap.put(((bbsa)localObject2).jdField_a_of_type_JavaUtilUUID, localObject2);
        paramString1 = (String)localObject2;
      }
      else
      {
        localObject1 = (bbsa)this.c.get(localObject1);
        if (localObject1 != null)
        {
          this.jdField_b_of_type_JavaUtilMap.put(((bbsa)localObject1).jdField_a_of_type_JavaUtilUUID, localObject1);
          paramString1 = (String)localObject1;
        }
        else
        {
          label268:
          label271:
          while (paramInt != 0)
          {
            localObject1 = new bbsa();
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager.a(paramString1);
            if (localObject2 != null) {
              ((bbsa)localObject1).jdField_a_of_type_JavaUtilUUID = ((bbtn)localObject2).jdField_a_of_type_JavaUtilUUID;
            }
            if (((bbsa)localObject1).jdField_a_of_type_JavaUtilUUID == null) {
              ((bbsa)localObject1).jdField_a_of_type_JavaUtilUUID = UUID.nameUUIDFromBytes(paramString1.getBytes());
            }
            ((bbsa)localObject1).b = paramString1;
            ((bbsa)localObject1).c = paramString2;
            ((bbsa)localObject1).jdField_a_of_type_Long = paramLong;
            ((bbsa)localObject1).jdField_a_of_type_Int = paramInt;
            if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {}
            for (paramString2 = "/";; paramString2 = this.jdField_a_of_type_JavaLangString)
            {
              ((bbsa)localObject1).f = paramString2;
              this.jdField_b_of_type_JavaUtilMap.put(((bbsa)localObject1).jdField_a_of_type_JavaUtilUUID, localObject1);
              this.c.put(paramString1, localObject1);
              paramString1 = (String)localObject1;
              break;
            }
            break label34;
            localObject1 = "0";
            break label34;
          }
          paramString1 = null;
        }
      }
    }
  }
  
  public bbsa a(UUID paramUUID)
  {
    try
    {
      paramUUID = (bbsa)this.jdField_b_of_type_JavaUtilMap.get(paramUUID);
      return paramUUID;
    }
    finally
    {
      paramUUID = finally;
      throw paramUUID;
    }
  }
  
  public final List<bbsa> a()
  {
    try
    {
      List localList = a(this.jdField_b_of_type_JavaUtilMap.values(), this.jdField_b_of_type_Bcnb);
      return localList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(int paramInt)
  {
    Iterator localIterator = this.mObservers.iterator();
    while (localIterator.hasNext()) {
      ((bbtc)localIterator.next()).a(paramInt);
    }
  }
  
  /* Error */
  public final void a(bbsa parambbsa)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull +92 -> 95
    //   6: getstatic 288	bbvl:jdField_a_of_type_Int	I
    //   9: istore_2
    //   10: new 290	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 291	java/lang/StringBuilder:<init>	()V
    //   17: ldc_w 293
    //   20: invokevirtual 297	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: astore 4
    //   25: aload_1
    //   26: getfield 133	bbsa:jdField_a_of_type_JavaUtilUUID	Ljava/util/UUID;
    //   29: ifnull +69 -> 98
    //   32: aload_1
    //   33: getfield 133	bbsa:jdField_a_of_type_JavaUtilUUID	Ljava/util/UUID;
    //   36: invokevirtual 301	java/util/UUID:toString	()Ljava/lang/String;
    //   39: astore_3
    //   40: ldc_w 303
    //   43: iload_2
    //   44: aload 4
    //   46: aload_3
    //   47: invokevirtual 297	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: ldc_w 305
    //   53: invokevirtual 297	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: invokevirtual 306	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   59: invokestatic 309	bbvl:c	(Ljava/lang/String;ILjava/lang/String;)V
    //   62: aload_0
    //   63: getfield 52	bcmu:c	Ljava/util/Map;
    //   66: aload_1
    //   67: getfield 144	bbsa:b	Ljava/lang/String;
    //   70: invokeinterface 312 2 0
    //   75: pop
    //   76: aload_0
    //   77: getfield 50	bcmu:jdField_b_of_type_JavaUtilMap	Ljava/util/Map;
    //   80: aload_1
    //   81: getfield 133	bbsa:jdField_a_of_type_JavaUtilUUID	Ljava/util/UUID;
    //   84: invokeinterface 312 2 0
    //   89: pop
    //   90: aload_0
    //   91: aload_1
    //   92: invokevirtual 314	bcmu:c	(Lbbsa;)V
    //   95: aload_0
    //   96: monitorexit
    //   97: return
    //   98: ldc_w 316
    //   101: astore_3
    //   102: goto -62 -> 40
    //   105: astore_1
    //   106: aload_0
    //   107: monitorexit
    //   108: aload_1
    //   109: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	110	0	this	bcmu
    //   0	110	1	parambbsa	bbsa
    //   9	35	2	i	int
    //   39	63	3	str	String
    //   23	22	4	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   6	40	105	finally
    //   40	95	105	finally
  }
  
  public void a(bbsa parambbsa, int paramInt)
  {
    bcmp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long, parambbsa.c, parambbsa.e, paramInt);
  }
  
  public final void a(bbsa parambbsa, int paramInt1, int paramInt2)
  {
    if (parambbsa != null) {}
    for (;;)
    {
      try
      {
        UUID localUUID = parambbsa.jdField_a_of_type_JavaUtilUUID;
        if (localUUID == null) {
          return;
        }
        bbvl.c("TroopFileManager", bbvl.jdField_a_of_type_Int, "[" + parambbsa.jdField_a_of_type_JavaUtilUUID.toString() + "] delete. mFileId:" + parambbsa.b + " mParentId:" + parambbsa.f + " uint32_bus_id:" + parambbsa.jdField_a_of_type_Int);
        if ((parambbsa.b == null) || (parambbsa.f == null) || ("".equals(parambbsa.b)) || ("".equals(parambbsa.f)))
        {
          b(parambbsa.jdField_a_of_type_JavaUtilUUID);
          continue;
        }
        if (parambbsa.jdField_a_of_type_Int == 0) {
          continue;
        }
      }
      finally {}
      ytu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long, parambbsa.jdField_a_of_type_Int, parambbsa.b, parambbsa.f, paramInt1, paramInt2, this.jdField_a_of_type_Ytx);
    }
  }
  
  public void a(bbsa parambbsa, String paramString)
  {
    Iterator localIterator = this.mObservers.iterator();
    while (localIterator.hasNext()) {
      ((bbtc)localIterator.next()).a(parambbsa, paramString);
    }
  }
  
  public final void a(String paramString)
  {
    try
    {
      bbvl.c("TroopFileManager", bbvl.jdField_a_of_type_Int, "doUploadDelete: filePath:" + paramString);
      paramString = (bbsa)this.c.remove(paramString);
      if ((!jdField_a_of_type_Boolean) && (paramString == null)) {
        throw new AssertionError();
      }
    }
    finally {}
    if (paramString != null)
    {
      this.jdField_b_of_type_JavaUtilMap.remove(paramString.jdField_a_of_type_JavaUtilUUID);
      c(paramString);
    }
  }
  
  public void a(String paramString, bbsa parambbsa)
  {
    try
    {
      this.c.put(paramString, parambbsa);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void a(Collection<bbsa> paramCollection, boolean paramBoolean, String paramString, long paramLong)
  {
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1, new Object[] { paramCollection, Boolean.valueOf(paramBoolean), paramString, Long.valueOf(paramLong) }).sendToTarget();
  }
  
  public void a(List<bbsa> paramList, boolean paramBoolean, String paramString, long paramLong)
  {
    Iterator localIterator = this.mObservers.iterator();
    while (localIterator.hasNext()) {
      ((bbtc)localIterator.next()).a(paramList, paramBoolean, paramString, paramLong);
    }
  }
  
  public final void a(UUID paramUUID)
  {
    if (paramUUID == null) {}
    for (;;)
    {
      return;
      try
      {
        paramUUID = (bbsa)this.jdField_b_of_type_JavaUtilMap.get(paramUUID);
        if ((paramUUID == null) || (!paramUUID.jdField_a_of_type_Boolean)) {
          continue;
        }
        paramUUID.jdField_a_of_type_Boolean = false;
        d(paramUUID);
      }
      finally {}
    }
  }
  
  public final boolean a(int paramInt, String paramString, long paramLong)
  {
    try
    {
      bcna localbcna = (bcna)this.d.get(paramString + paramLong);
      if (localbcna == null)
      {
        localbcna = new bcna(this, paramLong);
        this.d.put(paramString + paramLong, localbcna);
      }
      for (;;)
      {
        long l1 = System.currentTimeMillis();
        long l2 = localbcna.jdField_a_of_type_Long;
        l1 -= l2;
        if ((0L < l1) && (l1 < paramInt * 1000L)) {}
        for (boolean bool = false;; bool = true)
        {
          return bool;
          localbcna.jdField_a_of_type_Long = System.currentTimeMillis();
          ytu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long, localbcna.jdField_a_of_type_Int, 1, 20, 3, 1, paramString, localbcna.c, paramLong, 0, localbcna.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro, this.jdField_a_of_type_Yua);
        }
      }
    }
    finally {}
  }
  
  /* Error */
  public final boolean a(bbsa parambbsa)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: getfield 232	bbsa:jdField_a_of_type_Int	I
    //   6: ifeq +14 -> 20
    //   9: aload_1
    //   10: getfield 144	bbsa:b	Ljava/lang/String;
    //   13: astore 4
    //   15: aload 4
    //   17: ifnonnull +9 -> 26
    //   20: iconst_0
    //   21: istore_3
    //   22: aload_0
    //   23: monitorexit
    //   24: iload_3
    //   25: ireturn
    //   26: getstatic 288	bbvl:jdField_a_of_type_Int	I
    //   29: istore_2
    //   30: new 290	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 291	java/lang/StringBuilder:<init>	()V
    //   37: ldc_w 293
    //   40: invokevirtual 297	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: astore 5
    //   45: aload_1
    //   46: getfield 133	bbsa:jdField_a_of_type_JavaUtilUUID	Ljava/util/UUID;
    //   49: ifnull +73 -> 122
    //   52: aload_1
    //   53: getfield 133	bbsa:jdField_a_of_type_JavaUtilUUID	Ljava/util/UUID;
    //   56: invokevirtual 301	java/util/UUID:toString	()Ljava/lang/String;
    //   59: astore 4
    //   61: ldc_w 303
    //   64: iload_2
    //   65: aload 5
    //   67: aload 4
    //   69: invokevirtual 297	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: ldc_w 408
    //   75: invokevirtual 297	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: aload_1
    //   79: getfield 144	bbsa:b	Ljava/lang/String;
    //   82: invokevirtual 297	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: invokevirtual 306	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   88: invokestatic 309	bbvl:c	(Ljava/lang/String;ILjava/lang/String;)V
    //   91: aload_0
    //   92: getfield 99	bcmu:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   95: aload_0
    //   96: getfield 97	bcmu:jdField_a_of_type_Long	J
    //   99: aload_1
    //   100: aload_0
    //   101: getfield 90	bcmu:jdField_a_of_type_Yul	Lyul;
    //   104: invokestatic 411	ytu:a	(Lcom/tencent/mobileqq/app/QQAppInterface;JLbbsa;Lyul;)V
    //   107: aload_0
    //   108: aload_0
    //   109: getfield 412	bcmu:jdField_a_of_type_Int	I
    //   112: iconst_1
    //   113: iadd
    //   114: putfield 412	bcmu:jdField_a_of_type_Int	I
    //   117: iconst_1
    //   118: istore_3
    //   119: goto -97 -> 22
    //   122: ldc_w 316
    //   125: astore 4
    //   127: goto -66 -> 61
    //   130: astore_1
    //   131: aload_0
    //   132: monitorexit
    //   133: aload_1
    //   134: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	135	0	this	bcmu
    //   0	135	1	parambbsa	bbsa
    //   29	36	2	i	int
    //   21	98	3	bool	boolean
    //   13	113	4	str	String
    //   43	23	5	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   2	15	130	finally
    //   26	61	130	finally
    //   61	117	130	finally
  }
  
  public boolean a(bbtc parambbtc)
  {
    return this.mObservers.contains(parambbtc);
  }
  
  public final boolean a(String paramString, long paramLong)
  {
    try
    {
      bcna localbcna = (bcna)this.d.get(paramString + paramLong);
      paramString = localbcna;
      if (localbcna == null) {
        paramString = new bcna(this, paramLong);
      }
      boolean bool = paramString.jdField_a_of_type_Boolean;
      return bool;
    }
    finally {}
  }
  
  public bbsa b(String paramString)
  {
    if (paramString == null)
    {
      paramString = null;
      return paramString;
    }
    for (;;)
    {
      try
      {
        bbsa localbbsa = new bbsa();
        localbbsa.jdField_a_of_type_JavaUtilUUID = UUID.randomUUID();
        localbbsa.h = paramString;
        paramString = new File(paramString);
        localbbsa.jdField_a_of_type_Long = paramString.length();
        localbbsa.c = paramString.getName();
        if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
        {
          paramString = "/";
          localbbsa.f = paramString;
          this.jdField_b_of_type_JavaUtilMap.put(localbbsa.jdField_a_of_type_JavaUtilUUID, localbbsa);
          paramString = localbbsa;
          break;
        }
      }
      finally {}
      paramString = this.jdField_a_of_type_JavaLangString;
    }
  }
  
  public bbsa b(String paramString1, String paramString2, long paramLong, int paramInt)
  {
    try
    {
      bbsa localbbsa = new bbsa();
      localbbsa.jdField_a_of_type_JavaUtilUUID = UUID.nameUUIDFromBytes(paramString1.getBytes());
      localbbsa.b = paramString1;
      localbbsa.c = paramString2;
      localbbsa.jdField_a_of_type_Long = paramLong;
      localbbsa.jdField_a_of_type_Int = paramInt;
      localbbsa.f = "/";
      this.jdField_b_of_type_JavaUtilMap.put(localbbsa.jdField_a_of_type_JavaUtilUUID, localbbsa);
      this.c.put(paramString1, localbbsa);
      return localbbsa;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public final void b()
  {
    try
    {
      Iterator localIterator = this.jdField_b_of_type_JavaUtilMap.values().iterator();
      while (localIterator.hasNext()) {
        ((bbsa)localIterator.next()).jdField_a_of_type_Boolean = false;
      }
    }
    finally {}
  }
  
  public final void b(bbsa parambbsa)
  {
    try
    {
      a(parambbsa, 0, 0);
      return;
    }
    finally
    {
      parambbsa = finally;
      throw parambbsa;
    }
  }
  
  public final void b(String paramString)
  {
    try
    {
      bbvl.c("TroopFileManager", bbvl.jdField_a_of_type_Int, "doTroopFileDelete: filePath:" + paramString);
      paramString = (bbsa)this.c.remove(paramString);
      if ((!jdField_a_of_type_Boolean) && (paramString == null)) {
        throw new AssertionError();
      }
    }
    finally {}
    if (paramString != null)
    {
      this.jdField_b_of_type_JavaUtilMap.remove(paramString.jdField_a_of_type_JavaUtilUUID);
      c(paramString);
    }
  }
  
  /* Error */
  public final void b(UUID paramUUID)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 288	bbvl:jdField_a_of_type_Int	I
    //   5: istore_2
    //   6: new 290	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 291	java/lang/StringBuilder:<init>	()V
    //   13: ldc_w 293
    //   16: invokevirtual 297	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: astore 4
    //   21: aload_1
    //   22: ifnull +51 -> 73
    //   25: aload_1
    //   26: invokevirtual 301	java/util/UUID:toString	()Ljava/lang/String;
    //   29: astore_3
    //   30: ldc_w 303
    //   33: iload_2
    //   34: aload 4
    //   36: aload_3
    //   37: invokevirtual 297	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: ldc_w 436
    //   43: invokevirtual 297	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: invokevirtual 306	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: invokestatic 309	bbvl:c	(Ljava/lang/String;ILjava/lang/String;)V
    //   52: aload_0
    //   53: getfield 50	bcmu:jdField_b_of_type_JavaUtilMap	Ljava/util/Map;
    //   56: aload_1
    //   57: invokeinterface 312 2 0
    //   62: checkcast 128	bbsa
    //   65: astore_1
    //   66: aload_1
    //   67: ifnonnull +13 -> 80
    //   70: aload_0
    //   71: monitorexit
    //   72: return
    //   73: ldc_w 316
    //   76: astore_3
    //   77: goto -47 -> 30
    //   80: aload_0
    //   81: aload_1
    //   82: invokevirtual 314	bcmu:c	(Lbbsa;)V
    //   85: aload_0
    //   86: getfield 52	bcmu:c	Ljava/util/Map;
    //   89: aload_1
    //   90: getfield 144	bbsa:b	Ljava/lang/String;
    //   93: invokeinterface 312 2 0
    //   98: pop
    //   99: goto -29 -> 70
    //   102: astore_1
    //   103: aload_0
    //   104: monitorexit
    //   105: aload_1
    //   106: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	107	0	this	bcmu
    //   0	107	1	paramUUID	UUID
    //   5	29	2	i	int
    //   29	48	3	str	String
    //   19	16	4	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   2	21	102	finally
    //   25	30	102	finally
    //   30	66	102	finally
    //   80	99	102	finally
  }
  
  public final boolean b(String paramString, long paramLong)
  {
    try
    {
      bcna localbcna = (bcna)this.d.get(paramString + paramLong);
      if (localbcna == null)
      {
        localbcna = new bcna(this, paramLong);
        this.d.put(paramString + paramLong, localbcna);
      }
      for (;;)
      {
        if (!localbcna.jdField_a_of_type_Boolean)
        {
          bool = localbcna.jdField_b_of_type_Boolean;
          if (!bool) {
            break label108;
          }
        }
        for (boolean bool = false;; bool = true)
        {
          return bool;
          label108:
          ytu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long, localbcna.jdField_a_of_type_Int, 3, 20, 3, 1, paramString, localbcna.c, paramLong, localbcna.jdField_b_of_type_Int, localbcna.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro, this.jdField_a_of_type_Yua);
          localbcna.jdField_b_of_type_Boolean = true;
        }
      }
    }
    finally {}
  }
  
  public bbsa c(String paramString1, String paramString2, long paramLong, int paramInt)
  {
    try
    {
      paramString1 = a(paramString1, paramString2, paramLong, paramInt);
      return paramString1;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public void c(bbsa parambbsa)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager.f(parambbsa.jdField_a_of_type_JavaUtilUUID);
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(2, new Object[] { parambbsa }).sendToTarget();
  }
  
  public void d(bbsa parambbsa)
  {
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(3, new Object[] { parambbsa }).sendToTarget();
  }
  
  public void e(bbsa parambbsa)
  {
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(6, new Object[] { parambbsa }).sendToTarget();
  }
  
  public void f(bbsa parambbsa)
  {
    Iterator localIterator = this.mObservers.iterator();
    while (localIterator.hasNext()) {
      ((bbtc)localIterator.next()).a(parambbsa);
    }
  }
  
  public void g(bbsa parambbsa)
  {
    Iterator localIterator = this.mObservers.iterator();
    while (localIterator.hasNext()) {
      ((bbtc)localIterator.next()).b(parambbsa);
    }
  }
  
  public void h(bbsa parambbsa)
  {
    Iterator localIterator = this.mObservers.iterator();
    while (localIterator.hasNext()) {
      ((bbtc)localIterator.next()).c(parambbsa);
    }
  }
  
  public void i(bbsa parambbsa)
  {
    Iterator localIterator = this.mObservers.iterator();
    while (localIterator.hasNext()) {
      ((bbtc)localIterator.next()).e(parambbsa);
    }
  }
  
  public void j(bbsa parambbsa)
  {
    Iterator localIterator = this.mObservers.iterator();
    while (localIterator.hasNext()) {
      ((bbtc)localIterator.next()).d(parambbsa);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcmu
 * JD-Core Version:    0.7.0.1
 */