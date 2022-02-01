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

public class bfbb
  extends Observable<bece>
{
  public static Map<Long, bfbb> a;
  public int a;
  public long a;
  public amop a;
  public Handler a;
  public ArrayMap<Integer, List<bech>> a;
  public bfbi a;
  public QQAppInterface a;
  public TroopFileTransferManager a;
  public String a;
  private zrq jdField_a_of_type_Zrq = new bfbe(this);
  private zrt jdField_a_of_type_Zrt = new bfbg(this);
  private zsd jdField_a_of_type_Zsd = new bfbf(this);
  public int b;
  public bfbi b;
  public Map<UUID, bebc> b;
  public Map<String, bebc> c = new HashMap();
  public Map<String, bfbh> d = new HashMap();
  
  static
  {
    if (!bfbb.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      jdField_a_of_type_Boolean = bool;
      jdField_a_of_type_JavaUtilMap = new HashMap();
      return;
    }
  }
  
  public bfbb(QQAppInterface paramQQAppInterface, long paramLong)
  {
    this.jdField_b_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_AndroidSupportV4UtilArrayMap = new ArrayMap();
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Bfbi = new bfbj();
    this.jdField_b_of_type_Bfbi = new bfbk();
    this.jdField_a_of_type_Amop = new bfbd(this);
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager = TroopFileTransferManager.a(paramQQAppInterface, paramLong);
    Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager.a().iterator();
    while (localIterator.hasNext())
    {
      becp localbecp = (becp)localIterator.next();
      bebc localbebc = new bebc();
      localbebc.jdField_a_of_type_JavaUtilUUID = localbecp.jdField_a_of_type_JavaUtilUUID;
      localbebc.a(localbecp, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_b_of_type_JavaUtilMap.put(localbebc.jdField_a_of_type_JavaUtilUUID, localbebc);
      if ((localbebc.b != null) && (!"/".equals(localbebc.b))) {
        this.c.put(localbebc.b, localbebc);
      }
    }
    this.jdField_a_of_type_AndroidOsHandler = new bfbc(this, paramQQAppInterface.getApplication().getMainLooper());
    paramQQAppInterface.addObserver(this.jdField_a_of_type_Amop);
  }
  
  public static bfbb a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    try
    {
      bfbb localbfbb2 = (bfbb)jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramLong));
      bfbb localbfbb1;
      if (localbfbb2 != null)
      {
        localbfbb1 = localbfbb2;
        if (localbfbb2.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == paramQQAppInterface) {}
      }
      else
      {
        localbfbb1 = new bfbb(paramQQAppInterface, paramLong);
        jdField_a_of_type_JavaUtilMap.put(Long.valueOf(paramLong), localbfbb1);
      }
      return localbfbb1;
    }
    finally {}
  }
  
  public static List<bebc> a(Collection<bebc> paramCollection, bfbi parambfbi)
  {
    ArrayList localArrayList = new ArrayList();
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      bebc localbebc = (bebc)paramCollection.next();
      if (parambfbi.a(localbebc)) {
        localArrayList.add(localbebc);
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
        ((bfbb)localIterator.next()).c();
      }
      jdField_a_of_type_JavaUtilMap.clear();
    }
    finally {}
  }
  
  private void c()
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Amop);
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
  public bebc a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 52	bfbb:c	Ljava/util/Map;
    //   6: ifnull +21 -> 27
    //   9: aload_0
    //   10: getfield 52	bfbb:c	Ljava/util/Map;
    //   13: aload_1
    //   14: invokeinterface 186 2 0
    //   19: checkcast 128	bebc
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
    //   0	37	0	this	bfbb
    //   0	37	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   2	23	32	finally
  }
  
  public bebc a(String paramString, long paramLong, int paramInt)
  {
    try
    {
      bebc localbebc = new bebc();
      localbebc.jdField_a_of_type_JavaUtilUUID = UUID.randomUUID();
      localbebc.c = paramString;
      localbebc.jdField_a_of_type_Long = paramLong;
      localbebc.jdField_a_of_type_Int = paramInt;
      localbebc.a((int)NetConnInfoCenter.getServerTime());
      this.jdField_b_of_type_JavaUtilMap.put(localbebc.jdField_a_of_type_JavaUtilUUID, localbebc);
      return localbebc;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public bebc a(String paramString1, String paramString2, long paramLong, int paramInt)
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
        localObject1 = befa.a(paramString1);
        if (localObject1 == null) {
          break label271;
        }
        if (((String)localObject1).length() != 0) {
          break label268;
        }
      }
      finally {}
      Object localObject2 = (bebc)this.c.get(paramString1);
      if (localObject2 != null)
      {
        this.jdField_b_of_type_JavaUtilMap.put(((bebc)localObject2).jdField_a_of_type_JavaUtilUUID, localObject2);
        paramString1 = (String)localObject2;
      }
      else
      {
        localObject1 = (bebc)this.c.get(localObject1);
        if (localObject1 != null)
        {
          this.jdField_b_of_type_JavaUtilMap.put(((bebc)localObject1).jdField_a_of_type_JavaUtilUUID, localObject1);
          paramString1 = (String)localObject1;
        }
        else
        {
          label268:
          label271:
          while (paramInt != 0)
          {
            localObject1 = new bebc();
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager.a(paramString1);
            if (localObject2 != null) {
              ((bebc)localObject1).jdField_a_of_type_JavaUtilUUID = ((becp)localObject2).jdField_a_of_type_JavaUtilUUID;
            }
            if (((bebc)localObject1).jdField_a_of_type_JavaUtilUUID == null) {
              ((bebc)localObject1).jdField_a_of_type_JavaUtilUUID = UUID.nameUUIDFromBytes(paramString1.getBytes());
            }
            ((bebc)localObject1).b = paramString1;
            ((bebc)localObject1).c = paramString2;
            ((bebc)localObject1).jdField_a_of_type_Long = paramLong;
            ((bebc)localObject1).jdField_a_of_type_Int = paramInt;
            if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {}
            for (paramString2 = "/";; paramString2 = this.jdField_a_of_type_JavaLangString)
            {
              ((bebc)localObject1).f = paramString2;
              this.jdField_b_of_type_JavaUtilMap.put(((bebc)localObject1).jdField_a_of_type_JavaUtilUUID, localObject1);
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
  
  public bebc a(UUID paramUUID)
  {
    try
    {
      paramUUID = (bebc)this.jdField_b_of_type_JavaUtilMap.get(paramUUID);
      return paramUUID;
    }
    finally
    {
      paramUUID = finally;
      throw paramUUID;
    }
  }
  
  public final List<bebc> a()
  {
    try
    {
      List localList = a(this.jdField_b_of_type_JavaUtilMap.values(), this.jdField_b_of_type_Bfbi);
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
      ((bece)localIterator.next()).a(paramInt);
    }
  }
  
  /* Error */
  public final void a(bebc parambebc)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull +92 -> 95
    //   6: getstatic 288	befc:jdField_a_of_type_Int	I
    //   9: istore_2
    //   10: new 290	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 291	java/lang/StringBuilder:<init>	()V
    //   17: ldc_w 293
    //   20: invokevirtual 297	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: astore 4
    //   25: aload_1
    //   26: getfield 133	bebc:jdField_a_of_type_JavaUtilUUID	Ljava/util/UUID;
    //   29: ifnull +69 -> 98
    //   32: aload_1
    //   33: getfield 133	bebc:jdField_a_of_type_JavaUtilUUID	Ljava/util/UUID;
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
    //   59: invokestatic 309	befc:c	(Ljava/lang/String;ILjava/lang/String;)V
    //   62: aload_0
    //   63: getfield 52	bfbb:c	Ljava/util/Map;
    //   66: aload_1
    //   67: getfield 144	bebc:b	Ljava/lang/String;
    //   70: invokeinterface 312 2 0
    //   75: pop
    //   76: aload_0
    //   77: getfield 50	bfbb:jdField_b_of_type_JavaUtilMap	Ljava/util/Map;
    //   80: aload_1
    //   81: getfield 133	bebc:jdField_a_of_type_JavaUtilUUID	Ljava/util/UUID;
    //   84: invokeinterface 312 2 0
    //   89: pop
    //   90: aload_0
    //   91: aload_1
    //   92: invokevirtual 314	bfbb:c	(Lbebc;)V
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
    //   0	110	0	this	bfbb
    //   0	110	1	parambebc	bebc
    //   9	35	2	i	int
    //   39	63	3	str	String
    //   23	22	4	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   6	40	105	finally
    //   40	95	105	finally
  }
  
  public void a(bebc parambebc, int paramInt)
  {
    bfaw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long, parambebc.c, parambebc.e, paramInt);
  }
  
  public final void a(bebc parambebc, int paramInt1, int paramInt2)
  {
    if (parambebc != null) {}
    for (;;)
    {
      try
      {
        UUID localUUID = parambebc.jdField_a_of_type_JavaUtilUUID;
        if (localUUID == null) {
          return;
        }
        befc.c("TroopFileManager", befc.jdField_a_of_type_Int, "[" + parambebc.jdField_a_of_type_JavaUtilUUID.toString() + "] delete. mFileId:" + parambebc.b + " mParentId:" + parambebc.f + " uint32_bus_id:" + parambebc.jdField_a_of_type_Int);
        if ((parambebc.b == null) || (parambebc.f == null) || ("".equals(parambebc.b)) || ("".equals(parambebc.f)))
        {
          b(parambebc.jdField_a_of_type_JavaUtilUUID);
          continue;
        }
        if (parambebc.jdField_a_of_type_Int == 0) {
          continue;
        }
      }
      finally {}
      zrj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long, parambebc.jdField_a_of_type_Int, parambebc.b, parambebc.f, paramInt1, paramInt2, this.jdField_a_of_type_Zrq);
    }
  }
  
  public void a(bebc parambebc, String paramString)
  {
    Iterator localIterator = this.mObservers.iterator();
    while (localIterator.hasNext()) {
      ((bece)localIterator.next()).a(parambebc, paramString);
    }
  }
  
  public final void a(String paramString)
  {
    try
    {
      befc.c("TroopFileManager", befc.jdField_a_of_type_Int, "doUploadDelete: filePath:" + paramString);
      paramString = (bebc)this.c.remove(paramString);
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
  
  public void a(String paramString, bebc parambebc)
  {
    try
    {
      this.c.put(paramString, parambebc);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void a(Collection<bebc> paramCollection, boolean paramBoolean, String paramString, long paramLong)
  {
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1, new Object[] { paramCollection, Boolean.valueOf(paramBoolean), paramString, Long.valueOf(paramLong) }).sendToTarget();
  }
  
  public void a(List<bebc> paramList, boolean paramBoolean, String paramString, long paramLong)
  {
    Iterator localIterator = this.mObservers.iterator();
    while (localIterator.hasNext()) {
      ((bece)localIterator.next()).a(paramList, paramBoolean, paramString, paramLong);
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
        paramUUID = (bebc)this.jdField_b_of_type_JavaUtilMap.get(paramUUID);
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
      bfbh localbfbh = (bfbh)this.d.get(paramString + paramLong);
      if (localbfbh == null)
      {
        localbfbh = new bfbh(this, paramLong);
        this.d.put(paramString + paramLong, localbfbh);
      }
      for (;;)
      {
        long l1 = System.currentTimeMillis();
        long l2 = localbfbh.jdField_a_of_type_Long;
        l1 -= l2;
        if ((0L < l1) && (l1 < paramInt * 1000L)) {}
        for (boolean bool = false;; bool = true)
        {
          return bool;
          localbfbh.jdField_a_of_type_Long = System.currentTimeMillis();
          zrj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long, localbfbh.jdField_a_of_type_Int, 1, 20, 3, 1, paramString, localbfbh.c, paramLong, 0, localbfbh.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro, this.jdField_a_of_type_Zrt);
        }
      }
    }
    finally {}
  }
  
  /* Error */
  public final boolean a(bebc parambebc)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: getfield 232	bebc:jdField_a_of_type_Int	I
    //   6: ifeq +14 -> 20
    //   9: aload_1
    //   10: getfield 144	bebc:b	Ljava/lang/String;
    //   13: astore 4
    //   15: aload 4
    //   17: ifnonnull +9 -> 26
    //   20: iconst_0
    //   21: istore_3
    //   22: aload_0
    //   23: monitorexit
    //   24: iload_3
    //   25: ireturn
    //   26: getstatic 288	befc:jdField_a_of_type_Int	I
    //   29: istore_2
    //   30: new 290	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 291	java/lang/StringBuilder:<init>	()V
    //   37: ldc_w 293
    //   40: invokevirtual 297	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: astore 5
    //   45: aload_1
    //   46: getfield 133	bebc:jdField_a_of_type_JavaUtilUUID	Ljava/util/UUID;
    //   49: ifnull +73 -> 122
    //   52: aload_1
    //   53: getfield 133	bebc:jdField_a_of_type_JavaUtilUUID	Ljava/util/UUID;
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
    //   79: getfield 144	bebc:b	Ljava/lang/String;
    //   82: invokevirtual 297	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: invokevirtual 306	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   88: invokestatic 309	befc:c	(Ljava/lang/String;ILjava/lang/String;)V
    //   91: aload_0
    //   92: getfield 99	bfbb:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   95: aload_0
    //   96: getfield 97	bfbb:jdField_a_of_type_Long	J
    //   99: aload_1
    //   100: aload_0
    //   101: getfield 90	bfbb:jdField_a_of_type_Zsd	Lzsd;
    //   104: invokestatic 411	zrj:a	(Lcom/tencent/mobileqq/app/QQAppInterface;JLbebc;Lzsd;)V
    //   107: aload_0
    //   108: aload_0
    //   109: getfield 412	bfbb:jdField_a_of_type_Int	I
    //   112: iconst_1
    //   113: iadd
    //   114: putfield 412	bfbb:jdField_a_of_type_Int	I
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
    //   0	135	0	this	bfbb
    //   0	135	1	parambebc	bebc
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
  
  public boolean a(bece parambece)
  {
    return this.mObservers.contains(parambece);
  }
  
  public final boolean a(String paramString, long paramLong)
  {
    try
    {
      bfbh localbfbh = (bfbh)this.d.get(paramString + paramLong);
      paramString = localbfbh;
      if (localbfbh == null) {
        paramString = new bfbh(this, paramLong);
      }
      boolean bool = paramString.jdField_a_of_type_Boolean;
      return bool;
    }
    finally {}
  }
  
  public bebc b(String paramString)
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
        bebc localbebc = new bebc();
        localbebc.jdField_a_of_type_JavaUtilUUID = UUID.randomUUID();
        localbebc.h = paramString;
        paramString = new File(paramString);
        localbebc.jdField_a_of_type_Long = paramString.length();
        localbebc.c = paramString.getName();
        if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
        {
          paramString = "/";
          localbebc.f = paramString;
          this.jdField_b_of_type_JavaUtilMap.put(localbebc.jdField_a_of_type_JavaUtilUUID, localbebc);
          paramString = localbebc;
          break;
        }
      }
      finally {}
      paramString = this.jdField_a_of_type_JavaLangString;
    }
  }
  
  public bebc b(String paramString1, String paramString2, long paramLong, int paramInt)
  {
    try
    {
      bebc localbebc = new bebc();
      localbebc.jdField_a_of_type_JavaUtilUUID = UUID.nameUUIDFromBytes(paramString1.getBytes());
      localbebc.b = paramString1;
      localbebc.c = paramString2;
      localbebc.jdField_a_of_type_Long = paramLong;
      localbebc.jdField_a_of_type_Int = paramInt;
      localbebc.f = "/";
      this.jdField_b_of_type_JavaUtilMap.put(localbebc.jdField_a_of_type_JavaUtilUUID, localbebc);
      this.c.put(paramString1, localbebc);
      return localbebc;
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
        ((bebc)localIterator.next()).jdField_a_of_type_Boolean = false;
      }
    }
    finally {}
  }
  
  public final void b(bebc parambebc)
  {
    try
    {
      a(parambebc, 0, 0);
      return;
    }
    finally
    {
      parambebc = finally;
      throw parambebc;
    }
  }
  
  public final void b(String paramString)
  {
    try
    {
      befc.c("TroopFileManager", befc.jdField_a_of_type_Int, "doTroopFileDelete: filePath:" + paramString);
      paramString = (bebc)this.c.remove(paramString);
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
    //   2: getstatic 288	befc:jdField_a_of_type_Int	I
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
    //   49: invokestatic 309	befc:c	(Ljava/lang/String;ILjava/lang/String;)V
    //   52: aload_0
    //   53: getfield 50	bfbb:jdField_b_of_type_JavaUtilMap	Ljava/util/Map;
    //   56: aload_1
    //   57: invokeinterface 312 2 0
    //   62: checkcast 128	bebc
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
    //   82: invokevirtual 314	bfbb:c	(Lbebc;)V
    //   85: aload_0
    //   86: getfield 52	bfbb:c	Ljava/util/Map;
    //   89: aload_1
    //   90: getfield 144	bebc:b	Ljava/lang/String;
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
    //   0	107	0	this	bfbb
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
      bfbh localbfbh = (bfbh)this.d.get(paramString + paramLong);
      if (localbfbh == null)
      {
        localbfbh = new bfbh(this, paramLong);
        this.d.put(paramString + paramLong, localbfbh);
      }
      for (;;)
      {
        if (!localbfbh.jdField_a_of_type_Boolean)
        {
          bool = localbfbh.jdField_b_of_type_Boolean;
          if (!bool) {
            break label108;
          }
        }
        for (boolean bool = false;; bool = true)
        {
          return bool;
          label108:
          zrj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long, localbfbh.jdField_a_of_type_Int, 3, 20, 3, 1, paramString, localbfbh.c, paramLong, localbfbh.jdField_b_of_type_Int, localbfbh.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro, this.jdField_a_of_type_Zrt);
          localbfbh.jdField_b_of_type_Boolean = true;
        }
      }
    }
    finally {}
  }
  
  public bebc c(String paramString1, String paramString2, long paramLong, int paramInt)
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
  
  public void c(bebc parambebc)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager.f(parambebc.jdField_a_of_type_JavaUtilUUID);
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(2, new Object[] { parambebc }).sendToTarget();
  }
  
  public void d(bebc parambebc)
  {
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(3, new Object[] { parambebc }).sendToTarget();
  }
  
  public void e(bebc parambebc)
  {
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(6, new Object[] { parambebc }).sendToTarget();
  }
  
  public void f(bebc parambebc)
  {
    Iterator localIterator = this.mObservers.iterator();
    while (localIterator.hasNext()) {
      ((bece)localIterator.next()).a(parambebc);
    }
  }
  
  public void g(bebc parambebc)
  {
    Iterator localIterator = this.mObservers.iterator();
    while (localIterator.hasNext()) {
      ((bece)localIterator.next()).b(parambebc);
    }
  }
  
  public void h(bebc parambebc)
  {
    Iterator localIterator = this.mObservers.iterator();
    while (localIterator.hasNext()) {
      ((bece)localIterator.next()).c(parambebc);
    }
  }
  
  public void i(bebc parambebc)
  {
    Iterator localIterator = this.mObservers.iterator();
    while (localIterator.hasNext()) {
      ((bece)localIterator.next()).e(parambebc);
    }
  }
  
  public void j(bebc parambebc)
  {
    Iterator localIterator = this.mObservers.iterator();
    while (localIterator.hasNext()) {
      ((bece)localIterator.next()).d(parambebc);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfbb
 * JD-Core Version:    0.7.0.1
 */