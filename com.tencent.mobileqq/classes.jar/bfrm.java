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

public class bfrm
  extends Observable<betn>
{
  public static Map<Long, bfrm> a;
  public int a;
  public long a;
  private aara jdField_a_of_type_Aara = new bfrp(this);
  private aard jdField_a_of_type_Aard = new bfrr(this);
  private aarn jdField_a_of_type_Aarn = new bfrq(this);
  public Handler a;
  public ArrayMap<Integer, List<betq>> a;
  public anif a;
  public bfrt a;
  public QQAppInterface a;
  public TroopFileTransferManager a;
  public String a;
  public int b;
  public bfrt b;
  public Map<UUID, besl> b;
  public Map<String, besl> c = new HashMap();
  public Map<String, bfrs> d = new HashMap();
  
  static
  {
    if (!bfrm.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      jdField_a_of_type_Boolean = bool;
      jdField_a_of_type_JavaUtilMap = new HashMap();
      return;
    }
  }
  
  public bfrm(QQAppInterface paramQQAppInterface, long paramLong)
  {
    this.jdField_b_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_AndroidSupportV4UtilArrayMap = new ArrayMap();
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Bfrt = new bfru();
    this.jdField_b_of_type_Bfrt = new bfrv();
    this.jdField_a_of_type_Anif = new bfro(this);
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager = TroopFileTransferManager.a(paramQQAppInterface, paramLong);
    Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager.a().iterator();
    while (localIterator.hasNext())
    {
      bety localbety = (bety)localIterator.next();
      besl localbesl = new besl();
      localbesl.jdField_a_of_type_JavaUtilUUID = localbety.jdField_a_of_type_JavaUtilUUID;
      localbesl.a(localbety, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_b_of_type_JavaUtilMap.put(localbesl.jdField_a_of_type_JavaUtilUUID, localbesl);
      if ((localbesl.b != null) && (!"/".equals(localbesl.b))) {
        this.c.put(localbesl.b, localbesl);
      }
    }
    this.jdField_a_of_type_AndroidOsHandler = new bfrn(this, paramQQAppInterface.getApplication().getMainLooper());
    paramQQAppInterface.addObserver(this.jdField_a_of_type_Anif);
  }
  
  public static bfrm a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    try
    {
      bfrm localbfrm2 = (bfrm)jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramLong));
      bfrm localbfrm1;
      if (localbfrm2 != null)
      {
        localbfrm1 = localbfrm2;
        if (localbfrm2.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == paramQQAppInterface) {}
      }
      else
      {
        localbfrm1 = new bfrm(paramQQAppInterface, paramLong);
        jdField_a_of_type_JavaUtilMap.put(Long.valueOf(paramLong), localbfrm1);
      }
      return localbfrm1;
    }
    finally {}
  }
  
  public static List<besl> a(Collection<besl> paramCollection, bfrt parambfrt)
  {
    ArrayList localArrayList = new ArrayList();
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      besl localbesl = (besl)paramCollection.next();
      if (parambfrt.a(localbesl)) {
        localArrayList.add(localbesl);
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
        ((bfrm)localIterator.next()).c();
      }
      jdField_a_of_type_JavaUtilMap.clear();
    }
    finally {}
  }
  
  private void c()
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anif);
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
  public besl a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 52	bfrm:c	Ljava/util/Map;
    //   6: ifnull +21 -> 27
    //   9: aload_0
    //   10: getfield 52	bfrm:c	Ljava/util/Map;
    //   13: aload_1
    //   14: invokeinterface 186 2 0
    //   19: checkcast 128	besl
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
    //   0	37	0	this	bfrm
    //   0	37	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   2	23	32	finally
  }
  
  public besl a(String paramString, long paramLong, int paramInt)
  {
    try
    {
      besl localbesl = new besl();
      localbesl.jdField_a_of_type_JavaUtilUUID = UUID.randomUUID();
      localbesl.c = paramString;
      localbesl.jdField_a_of_type_Long = paramLong;
      localbesl.jdField_a_of_type_Int = paramInt;
      localbesl.a((int)NetConnInfoCenter.getServerTime());
      this.jdField_b_of_type_JavaUtilMap.put(localbesl.jdField_a_of_type_JavaUtilUUID, localbesl);
      return localbesl;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public besl a(String paramString1, String paramString2, long paramLong, int paramInt)
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
        localObject1 = bevv.a(paramString1);
        if (localObject1 == null) {
          break label271;
        }
        if (((String)localObject1).length() != 0) {
          break label268;
        }
      }
      finally {}
      Object localObject2 = (besl)this.c.get(paramString1);
      if (localObject2 != null)
      {
        this.jdField_b_of_type_JavaUtilMap.put(((besl)localObject2).jdField_a_of_type_JavaUtilUUID, localObject2);
        paramString1 = (String)localObject2;
      }
      else
      {
        localObject1 = (besl)this.c.get(localObject1);
        if (localObject1 != null)
        {
          this.jdField_b_of_type_JavaUtilMap.put(((besl)localObject1).jdField_a_of_type_JavaUtilUUID, localObject1);
          paramString1 = (String)localObject1;
        }
        else
        {
          label268:
          label271:
          while (paramInt != 0)
          {
            localObject1 = new besl();
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager.a(paramString1);
            if (localObject2 != null) {
              ((besl)localObject1).jdField_a_of_type_JavaUtilUUID = ((bety)localObject2).jdField_a_of_type_JavaUtilUUID;
            }
            if (((besl)localObject1).jdField_a_of_type_JavaUtilUUID == null) {
              ((besl)localObject1).jdField_a_of_type_JavaUtilUUID = UUID.nameUUIDFromBytes(paramString1.getBytes());
            }
            ((besl)localObject1).b = paramString1;
            ((besl)localObject1).c = paramString2;
            ((besl)localObject1).jdField_a_of_type_Long = paramLong;
            ((besl)localObject1).jdField_a_of_type_Int = paramInt;
            if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {}
            for (paramString2 = "/";; paramString2 = this.jdField_a_of_type_JavaLangString)
            {
              ((besl)localObject1).f = paramString2;
              this.jdField_b_of_type_JavaUtilMap.put(((besl)localObject1).jdField_a_of_type_JavaUtilUUID, localObject1);
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
  
  public besl a(UUID paramUUID)
  {
    try
    {
      paramUUID = (besl)this.jdField_b_of_type_JavaUtilMap.get(paramUUID);
      return paramUUID;
    }
    finally
    {
      paramUUID = finally;
      throw paramUUID;
    }
  }
  
  public final List<besl> a()
  {
    try
    {
      List localList = a(this.jdField_b_of_type_JavaUtilMap.values(), this.jdField_b_of_type_Bfrt);
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
      ((betn)localIterator.next()).a(paramInt);
    }
  }
  
  /* Error */
  public final void a(besl parambesl)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull +92 -> 95
    //   6: getstatic 288	bevx:jdField_a_of_type_Int	I
    //   9: istore_2
    //   10: new 290	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 291	java/lang/StringBuilder:<init>	()V
    //   17: ldc_w 293
    //   20: invokevirtual 297	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: astore 4
    //   25: aload_1
    //   26: getfield 133	besl:jdField_a_of_type_JavaUtilUUID	Ljava/util/UUID;
    //   29: ifnull +69 -> 98
    //   32: aload_1
    //   33: getfield 133	besl:jdField_a_of_type_JavaUtilUUID	Ljava/util/UUID;
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
    //   59: invokestatic 309	bevx:c	(Ljava/lang/String;ILjava/lang/String;)V
    //   62: aload_0
    //   63: getfield 52	bfrm:c	Ljava/util/Map;
    //   66: aload_1
    //   67: getfield 144	besl:b	Ljava/lang/String;
    //   70: invokeinterface 312 2 0
    //   75: pop
    //   76: aload_0
    //   77: getfield 50	bfrm:jdField_b_of_type_JavaUtilMap	Ljava/util/Map;
    //   80: aload_1
    //   81: getfield 133	besl:jdField_a_of_type_JavaUtilUUID	Ljava/util/UUID;
    //   84: invokeinterface 312 2 0
    //   89: pop
    //   90: aload_0
    //   91: aload_1
    //   92: invokevirtual 314	bfrm:c	(Lbesl;)V
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
    //   0	110	0	this	bfrm
    //   0	110	1	parambesl	besl
    //   9	35	2	i	int
    //   39	63	3	str	String
    //   23	22	4	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   6	40	105	finally
    //   40	95	105	finally
  }
  
  public void a(besl parambesl, int paramInt)
  {
    bfrh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long, parambesl.c, parambesl.e, paramInt);
  }
  
  public final void a(besl parambesl, int paramInt1, int paramInt2)
  {
    if (parambesl != null) {}
    for (;;)
    {
      try
      {
        UUID localUUID = parambesl.jdField_a_of_type_JavaUtilUUID;
        if (localUUID == null) {
          return;
        }
        bevx.c("TroopFileManager", bevx.jdField_a_of_type_Int, "[" + parambesl.jdField_a_of_type_JavaUtilUUID.toString() + "] delete. mFileId:" + parambesl.b + " mParentId:" + parambesl.f + " uint32_bus_id:" + parambesl.jdField_a_of_type_Int);
        if ((parambesl.b == null) || (parambesl.f == null) || ("".equals(parambesl.b)) || ("".equals(parambesl.f)))
        {
          b(parambesl.jdField_a_of_type_JavaUtilUUID);
          continue;
        }
        if (parambesl.jdField_a_of_type_Int == 0) {
          continue;
        }
      }
      finally {}
      aaqt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long, parambesl.jdField_a_of_type_Int, parambesl.b, parambesl.f, paramInt1, paramInt2, this.jdField_a_of_type_Aara);
    }
  }
  
  public void a(besl parambesl, String paramString)
  {
    Iterator localIterator = this.mObservers.iterator();
    while (localIterator.hasNext()) {
      ((betn)localIterator.next()).a(parambesl, paramString);
    }
  }
  
  public final void a(String paramString)
  {
    try
    {
      bevx.c("TroopFileManager", bevx.jdField_a_of_type_Int, "doUploadDelete: filePath:" + paramString);
      paramString = (besl)this.c.remove(paramString);
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
  
  public void a(String paramString, besl parambesl)
  {
    try
    {
      this.c.put(paramString, parambesl);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void a(Collection<besl> paramCollection, boolean paramBoolean, String paramString, long paramLong)
  {
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1, new Object[] { paramCollection, Boolean.valueOf(paramBoolean), paramString, Long.valueOf(paramLong) }).sendToTarget();
  }
  
  public void a(List<besl> paramList, boolean paramBoolean, String paramString, long paramLong)
  {
    Iterator localIterator = this.mObservers.iterator();
    while (localIterator.hasNext()) {
      ((betn)localIterator.next()).a(paramList, paramBoolean, paramString, paramLong);
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
        paramUUID = (besl)this.jdField_b_of_type_JavaUtilMap.get(paramUUID);
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
      bfrs localbfrs = (bfrs)this.d.get(paramString + paramLong);
      if (localbfrs == null)
      {
        localbfrs = new bfrs(this, paramLong);
        this.d.put(paramString + paramLong, localbfrs);
      }
      for (;;)
      {
        long l1 = System.currentTimeMillis();
        long l2 = localbfrs.jdField_a_of_type_Long;
        l1 -= l2;
        if ((0L < l1) && (l1 < paramInt * 1000L)) {}
        for (boolean bool = false;; bool = true)
        {
          return bool;
          localbfrs.jdField_a_of_type_Long = System.currentTimeMillis();
          aaqt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long, localbfrs.jdField_a_of_type_Int, 1, 20, 3, 1, paramString, localbfrs.c, paramLong, 0, localbfrs.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro, this.jdField_a_of_type_Aard);
        }
      }
    }
    finally {}
  }
  
  /* Error */
  public final boolean a(besl parambesl)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: getfield 232	besl:jdField_a_of_type_Int	I
    //   6: ifeq +14 -> 20
    //   9: aload_1
    //   10: getfield 144	besl:b	Ljava/lang/String;
    //   13: astore 4
    //   15: aload 4
    //   17: ifnonnull +9 -> 26
    //   20: iconst_0
    //   21: istore_3
    //   22: aload_0
    //   23: monitorexit
    //   24: iload_3
    //   25: ireturn
    //   26: getstatic 288	bevx:jdField_a_of_type_Int	I
    //   29: istore_2
    //   30: new 290	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 291	java/lang/StringBuilder:<init>	()V
    //   37: ldc_w 293
    //   40: invokevirtual 297	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: astore 5
    //   45: aload_1
    //   46: getfield 133	besl:jdField_a_of_type_JavaUtilUUID	Ljava/util/UUID;
    //   49: ifnull +73 -> 122
    //   52: aload_1
    //   53: getfield 133	besl:jdField_a_of_type_JavaUtilUUID	Ljava/util/UUID;
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
    //   79: getfield 144	besl:b	Ljava/lang/String;
    //   82: invokevirtual 297	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: invokevirtual 306	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   88: invokestatic 309	bevx:c	(Ljava/lang/String;ILjava/lang/String;)V
    //   91: aload_0
    //   92: getfield 99	bfrm:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   95: aload_0
    //   96: getfield 97	bfrm:jdField_a_of_type_Long	J
    //   99: aload_1
    //   100: aload_0
    //   101: getfield 90	bfrm:jdField_a_of_type_Aarn	Laarn;
    //   104: invokestatic 411	aaqt:a	(Lcom/tencent/mobileqq/app/QQAppInterface;JLbesl;Laarn;)V
    //   107: aload_0
    //   108: aload_0
    //   109: getfield 412	bfrm:jdField_a_of_type_Int	I
    //   112: iconst_1
    //   113: iadd
    //   114: putfield 412	bfrm:jdField_a_of_type_Int	I
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
    //   0	135	0	this	bfrm
    //   0	135	1	parambesl	besl
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
  
  public boolean a(betn parambetn)
  {
    return this.mObservers.contains(parambetn);
  }
  
  public final boolean a(String paramString, long paramLong)
  {
    try
    {
      bfrs localbfrs = (bfrs)this.d.get(paramString + paramLong);
      paramString = localbfrs;
      if (localbfrs == null) {
        paramString = new bfrs(this, paramLong);
      }
      boolean bool = paramString.jdField_a_of_type_Boolean;
      return bool;
    }
    finally {}
  }
  
  public besl b(String paramString)
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
        besl localbesl = new besl();
        localbesl.jdField_a_of_type_JavaUtilUUID = UUID.randomUUID();
        localbesl.h = paramString;
        paramString = new File(paramString);
        localbesl.jdField_a_of_type_Long = paramString.length();
        localbesl.c = paramString.getName();
        if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
        {
          paramString = "/";
          localbesl.f = paramString;
          this.jdField_b_of_type_JavaUtilMap.put(localbesl.jdField_a_of_type_JavaUtilUUID, localbesl);
          paramString = localbesl;
          break;
        }
      }
      finally {}
      paramString = this.jdField_a_of_type_JavaLangString;
    }
  }
  
  public besl b(String paramString1, String paramString2, long paramLong, int paramInt)
  {
    try
    {
      besl localbesl = new besl();
      localbesl.jdField_a_of_type_JavaUtilUUID = UUID.nameUUIDFromBytes(paramString1.getBytes());
      localbesl.b = paramString1;
      localbesl.c = paramString2;
      localbesl.jdField_a_of_type_Long = paramLong;
      localbesl.jdField_a_of_type_Int = paramInt;
      localbesl.f = "/";
      this.jdField_b_of_type_JavaUtilMap.put(localbesl.jdField_a_of_type_JavaUtilUUID, localbesl);
      this.c.put(paramString1, localbesl);
      return localbesl;
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
        ((besl)localIterator.next()).jdField_a_of_type_Boolean = false;
      }
    }
    finally {}
  }
  
  public final void b(besl parambesl)
  {
    try
    {
      a(parambesl, 0, 0);
      return;
    }
    finally
    {
      parambesl = finally;
      throw parambesl;
    }
  }
  
  public final void b(String paramString)
  {
    try
    {
      bevx.c("TroopFileManager", bevx.jdField_a_of_type_Int, "doTroopFileDelete: filePath:" + paramString);
      paramString = (besl)this.c.remove(paramString);
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
    //   2: getstatic 288	bevx:jdField_a_of_type_Int	I
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
    //   49: invokestatic 309	bevx:c	(Ljava/lang/String;ILjava/lang/String;)V
    //   52: aload_0
    //   53: getfield 50	bfrm:jdField_b_of_type_JavaUtilMap	Ljava/util/Map;
    //   56: aload_1
    //   57: invokeinterface 312 2 0
    //   62: checkcast 128	besl
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
    //   82: invokevirtual 314	bfrm:c	(Lbesl;)V
    //   85: aload_0
    //   86: getfield 52	bfrm:c	Ljava/util/Map;
    //   89: aload_1
    //   90: getfield 144	besl:b	Ljava/lang/String;
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
    //   0	107	0	this	bfrm
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
      bfrs localbfrs = (bfrs)this.d.get(paramString + paramLong);
      if (localbfrs == null)
      {
        localbfrs = new bfrs(this, paramLong);
        this.d.put(paramString + paramLong, localbfrs);
      }
      for (;;)
      {
        if (!localbfrs.jdField_a_of_type_Boolean)
        {
          bool = localbfrs.jdField_b_of_type_Boolean;
          if (!bool) {
            break label108;
          }
        }
        for (boolean bool = false;; bool = true)
        {
          return bool;
          label108:
          aaqt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long, localbfrs.jdField_a_of_type_Int, 3, 20, 3, 1, paramString, localbfrs.c, paramLong, localbfrs.jdField_b_of_type_Int, localbfrs.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro, this.jdField_a_of_type_Aard);
          localbfrs.jdField_b_of_type_Boolean = true;
        }
      }
    }
    finally {}
  }
  
  public besl c(String paramString1, String paramString2, long paramLong, int paramInt)
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
  
  public void c(besl parambesl)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager.f(parambesl.jdField_a_of_type_JavaUtilUUID);
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(2, new Object[] { parambesl }).sendToTarget();
  }
  
  public void d(besl parambesl)
  {
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(3, new Object[] { parambesl }).sendToTarget();
  }
  
  public void e(besl parambesl)
  {
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(6, new Object[] { parambesl }).sendToTarget();
  }
  
  public void f(besl parambesl)
  {
    Iterator localIterator = this.mObservers.iterator();
    while (localIterator.hasNext()) {
      ((betn)localIterator.next()).a(parambesl);
    }
  }
  
  public void g(besl parambesl)
  {
    Iterator localIterator = this.mObservers.iterator();
    while (localIterator.hasNext()) {
      ((betn)localIterator.next()).b(parambesl);
    }
  }
  
  public void h(besl parambesl)
  {
    Iterator localIterator = this.mObservers.iterator();
    while (localIterator.hasNext()) {
      ((betn)localIterator.next()).c(parambesl);
    }
  }
  
  public void i(besl parambesl)
  {
    Iterator localIterator = this.mObservers.iterator();
    while (localIterator.hasNext()) {
      ((betn)localIterator.next()).e(parambesl);
    }
  }
  
  public void j(besl parambesl)
  {
    Iterator localIterator = this.mObservers.iterator();
    while (localIterator.hasNext()) {
      ((betn)localIterator.next()).d(parambesl);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfrm
 * JD-Core Version:    0.7.0.1
 */