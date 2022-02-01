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

public class bgjh
  extends Observable<bfjh>
{
  public static Map<Long, bgjh> a;
  public int a;
  public long a;
  private aahc jdField_a_of_type_Aahc = new bgjk(this);
  private aahf jdField_a_of_type_Aahf = new bgjm(this);
  private aahp jdField_a_of_type_Aahp = new bgjl(this);
  public Handler a;
  public ArrayMap<Integer, List<bfjk>> a;
  public anrc a;
  public bgjo a;
  public QQAppInterface a;
  public TroopFileTransferManager a;
  public String a;
  public int b;
  public bgjo b;
  public Map<UUID, bfif> b;
  public Map<String, bfif> c = new HashMap();
  public Map<String, bgjn> d = new HashMap();
  
  static
  {
    if (!bgjh.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      jdField_a_of_type_Boolean = bool;
      jdField_a_of_type_JavaUtilMap = new HashMap();
      return;
    }
  }
  
  public bgjh(QQAppInterface paramQQAppInterface, long paramLong)
  {
    this.jdField_b_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_AndroidSupportV4UtilArrayMap = new ArrayMap();
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Bgjo = new bgjp();
    this.jdField_b_of_type_Bgjo = new bgjq();
    this.jdField_a_of_type_Anrc = new bgjj(this);
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager = TroopFileTransferManager.a(paramQQAppInterface, paramLong);
    Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager.a().iterator();
    while (localIterator.hasNext())
    {
      bfjs localbfjs = (bfjs)localIterator.next();
      bfif localbfif = new bfif();
      localbfif.jdField_a_of_type_JavaUtilUUID = localbfjs.jdField_a_of_type_JavaUtilUUID;
      localbfif.a(localbfjs, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_b_of_type_JavaUtilMap.put(localbfif.jdField_a_of_type_JavaUtilUUID, localbfif);
      if ((localbfif.b != null) && (!"/".equals(localbfif.b))) {
        this.c.put(localbfif.b, localbfif);
      }
    }
    this.jdField_a_of_type_AndroidOsHandler = new bgji(this, paramQQAppInterface.getApplication().getMainLooper());
    paramQQAppInterface.addObserver(this.jdField_a_of_type_Anrc);
  }
  
  public static bgjh a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    try
    {
      bgjh localbgjh2 = (bgjh)jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramLong));
      bgjh localbgjh1;
      if (localbgjh2 != null)
      {
        localbgjh1 = localbgjh2;
        if (localbgjh2.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == paramQQAppInterface) {}
      }
      else
      {
        localbgjh1 = new bgjh(paramQQAppInterface, paramLong);
        jdField_a_of_type_JavaUtilMap.put(Long.valueOf(paramLong), localbgjh1);
      }
      return localbgjh1;
    }
    finally {}
  }
  
  public static List<bfif> a(Collection<bfif> paramCollection, bgjo parambgjo)
  {
    ArrayList localArrayList = new ArrayList();
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      bfif localbfif = (bfif)paramCollection.next();
      if (parambgjo.a(localbfif)) {
        localArrayList.add(localbfif);
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
        ((bgjh)localIterator.next()).c();
      }
      jdField_a_of_type_JavaUtilMap.clear();
    }
    finally {}
  }
  
  private void c()
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anrc);
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
  public bfif a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 52	bgjh:c	Ljava/util/Map;
    //   6: ifnull +21 -> 27
    //   9: aload_0
    //   10: getfield 52	bgjh:c	Ljava/util/Map;
    //   13: aload_1
    //   14: invokeinterface 186 2 0
    //   19: checkcast 128	bfif
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
    //   0	37	0	this	bgjh
    //   0	37	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   2	23	32	finally
  }
  
  public bfif a(String paramString, long paramLong, int paramInt)
  {
    try
    {
      bfif localbfif = new bfif();
      localbfif.jdField_a_of_type_JavaUtilUUID = UUID.randomUUID();
      localbfif.c = paramString;
      localbfif.jdField_a_of_type_Long = paramLong;
      localbfif.jdField_a_of_type_Int = paramInt;
      localbfif.a((int)NetConnInfoCenter.getServerTime());
      this.jdField_b_of_type_JavaUtilMap.put(localbfif.jdField_a_of_type_JavaUtilUUID, localbfif);
      return localbfif;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public bfif a(String paramString1, String paramString2, long paramLong, int paramInt)
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
        localObject1 = bfmd.a(paramString1);
        if (localObject1 == null) {
          break label271;
        }
        if (((String)localObject1).length() != 0) {
          break label268;
        }
      }
      finally {}
      Object localObject2 = (bfif)this.c.get(paramString1);
      if (localObject2 != null)
      {
        this.jdField_b_of_type_JavaUtilMap.put(((bfif)localObject2).jdField_a_of_type_JavaUtilUUID, localObject2);
        paramString1 = (String)localObject2;
      }
      else
      {
        localObject1 = (bfif)this.c.get(localObject1);
        if (localObject1 != null)
        {
          this.jdField_b_of_type_JavaUtilMap.put(((bfif)localObject1).jdField_a_of_type_JavaUtilUUID, localObject1);
          paramString1 = (String)localObject1;
        }
        else
        {
          label268:
          label271:
          while (paramInt != 0)
          {
            localObject1 = new bfif();
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager.a(paramString1);
            if (localObject2 != null) {
              ((bfif)localObject1).jdField_a_of_type_JavaUtilUUID = ((bfjs)localObject2).jdField_a_of_type_JavaUtilUUID;
            }
            if (((bfif)localObject1).jdField_a_of_type_JavaUtilUUID == null) {
              ((bfif)localObject1).jdField_a_of_type_JavaUtilUUID = UUID.nameUUIDFromBytes(paramString1.getBytes());
            }
            ((bfif)localObject1).b = paramString1;
            ((bfif)localObject1).c = paramString2;
            ((bfif)localObject1).jdField_a_of_type_Long = paramLong;
            ((bfif)localObject1).jdField_a_of_type_Int = paramInt;
            if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {}
            for (paramString2 = "/";; paramString2 = this.jdField_a_of_type_JavaLangString)
            {
              ((bfif)localObject1).g = paramString2;
              this.jdField_b_of_type_JavaUtilMap.put(((bfif)localObject1).jdField_a_of_type_JavaUtilUUID, localObject1);
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
  
  public bfif a(UUID paramUUID)
  {
    try
    {
      paramUUID = (bfif)this.jdField_b_of_type_JavaUtilMap.get(paramUUID);
      return paramUUID;
    }
    finally
    {
      paramUUID = finally;
      throw paramUUID;
    }
  }
  
  public final List<bfif> a()
  {
    try
    {
      List localList = a(this.jdField_b_of_type_JavaUtilMap.values(), this.jdField_b_of_type_Bgjo);
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
      ((bfjh)localIterator.next()).a(paramInt);
    }
  }
  
  /* Error */
  public final void a(bfif parambfif)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull +92 -> 95
    //   6: getstatic 289	bfmf:jdField_a_of_type_Int	I
    //   9: istore_2
    //   10: new 291	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 292	java/lang/StringBuilder:<init>	()V
    //   17: ldc_w 294
    //   20: invokevirtual 298	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: astore 4
    //   25: aload_1
    //   26: getfield 133	bfif:jdField_a_of_type_JavaUtilUUID	Ljava/util/UUID;
    //   29: ifnull +69 -> 98
    //   32: aload_1
    //   33: getfield 133	bfif:jdField_a_of_type_JavaUtilUUID	Ljava/util/UUID;
    //   36: invokevirtual 302	java/util/UUID:toString	()Ljava/lang/String;
    //   39: astore_3
    //   40: ldc_w 304
    //   43: iload_2
    //   44: aload 4
    //   46: aload_3
    //   47: invokevirtual 298	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: ldc_w 306
    //   53: invokevirtual 298	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: invokevirtual 307	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   59: invokestatic 310	bfmf:c	(Ljava/lang/String;ILjava/lang/String;)V
    //   62: aload_0
    //   63: getfield 52	bgjh:c	Ljava/util/Map;
    //   66: aload_1
    //   67: getfield 144	bfif:b	Ljava/lang/String;
    //   70: invokeinterface 313 2 0
    //   75: pop
    //   76: aload_0
    //   77: getfield 50	bgjh:jdField_b_of_type_JavaUtilMap	Ljava/util/Map;
    //   80: aload_1
    //   81: getfield 133	bfif:jdField_a_of_type_JavaUtilUUID	Ljava/util/UUID;
    //   84: invokeinterface 313 2 0
    //   89: pop
    //   90: aload_0
    //   91: aload_1
    //   92: invokevirtual 315	bgjh:c	(Lbfif;)V
    //   95: aload_0
    //   96: monitorexit
    //   97: return
    //   98: ldc_w 317
    //   101: astore_3
    //   102: goto -62 -> 40
    //   105: astore_1
    //   106: aload_0
    //   107: monitorexit
    //   108: aload_1
    //   109: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	110	0	this	bgjh
    //   0	110	1	parambfif	bfif
    //   9	35	2	i	int
    //   39	63	3	str	String
    //   23	22	4	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   6	40	105	finally
    //   40	95	105	finally
  }
  
  public void a(bfif parambfif, int paramInt)
  {
    bgjc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long, parambfif.c, parambfif.e, paramInt);
  }
  
  public final void a(bfif parambfif, int paramInt1, int paramInt2)
  {
    if (parambfif != null) {}
    for (;;)
    {
      try
      {
        UUID localUUID = parambfif.jdField_a_of_type_JavaUtilUUID;
        if (localUUID == null) {
          return;
        }
        bfmf.c("TroopFileManager", bfmf.jdField_a_of_type_Int, "[" + parambfif.jdField_a_of_type_JavaUtilUUID.toString() + "] delete. mFileId:" + parambfif.b + " mParentId:" + parambfif.g + " uint32_bus_id:" + parambfif.jdField_a_of_type_Int);
        if ((parambfif.b == null) || (parambfif.g == null) || ("".equals(parambfif.b)) || ("".equals(parambfif.g)))
        {
          b(parambfif.jdField_a_of_type_JavaUtilUUID);
          continue;
        }
        if (parambfif.jdField_a_of_type_Int == 0) {
          continue;
        }
      }
      finally {}
      aagu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long, parambfif.jdField_a_of_type_Int, parambfif.b, parambfif.g, paramInt1, paramInt2, this.jdField_a_of_type_Aahc);
    }
  }
  
  public void a(bfif parambfif, String paramString)
  {
    Iterator localIterator = this.mObservers.iterator();
    while (localIterator.hasNext()) {
      ((bfjh)localIterator.next()).a(parambfif, paramString);
    }
  }
  
  public final void a(String paramString)
  {
    try
    {
      bfmf.c("TroopFileManager", bfmf.jdField_a_of_type_Int, "doUploadDelete: filePath:" + paramString);
      paramString = (bfif)this.c.remove(paramString);
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
  
  public void a(String paramString, bfif parambfif)
  {
    try
    {
      this.c.put(paramString, parambfif);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void a(Collection<bfif> paramCollection, boolean paramBoolean, String paramString, long paramLong)
  {
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1, new Object[] { paramCollection, Boolean.valueOf(paramBoolean), paramString, Long.valueOf(paramLong) }).sendToTarget();
  }
  
  public void a(List<bfif> paramList, boolean paramBoolean, String paramString, long paramLong)
  {
    Iterator localIterator = this.mObservers.iterator();
    while (localIterator.hasNext()) {
      ((bfjh)localIterator.next()).a(paramList, paramBoolean, paramString, paramLong);
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
        paramUUID = (bfif)this.jdField_b_of_type_JavaUtilMap.get(paramUUID);
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
      bgjn localbgjn = (bgjn)this.d.get(paramString + paramLong);
      if (localbgjn == null)
      {
        localbgjn = new bgjn(this, paramLong);
        this.d.put(paramString + paramLong, localbgjn);
      }
      for (;;)
      {
        long l1 = System.currentTimeMillis();
        long l2 = localbgjn.jdField_a_of_type_Long;
        l1 -= l2;
        if ((0L < l1) && (l1 < paramInt * 1000L)) {}
        for (boolean bool = false;; bool = true)
        {
          return bool;
          localbgjn.jdField_a_of_type_Long = System.currentTimeMillis();
          aagu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long, localbgjn.jdField_a_of_type_Int, 1, 20, 3, 1, paramString, localbgjn.c, paramLong, 0, localbgjn.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro, this.jdField_a_of_type_Aahf);
        }
      }
    }
    finally {}
  }
  
  /* Error */
  public final boolean a(bfif parambfif)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: getfield 232	bfif:jdField_a_of_type_Int	I
    //   6: ifeq +14 -> 20
    //   9: aload_1
    //   10: getfield 144	bfif:b	Ljava/lang/String;
    //   13: astore 4
    //   15: aload 4
    //   17: ifnonnull +9 -> 26
    //   20: iconst_0
    //   21: istore_3
    //   22: aload_0
    //   23: monitorexit
    //   24: iload_3
    //   25: ireturn
    //   26: getstatic 289	bfmf:jdField_a_of_type_Int	I
    //   29: istore_2
    //   30: new 291	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 292	java/lang/StringBuilder:<init>	()V
    //   37: ldc_w 294
    //   40: invokevirtual 298	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: astore 5
    //   45: aload_1
    //   46: getfield 133	bfif:jdField_a_of_type_JavaUtilUUID	Ljava/util/UUID;
    //   49: ifnull +73 -> 122
    //   52: aload_1
    //   53: getfield 133	bfif:jdField_a_of_type_JavaUtilUUID	Ljava/util/UUID;
    //   56: invokevirtual 302	java/util/UUID:toString	()Ljava/lang/String;
    //   59: astore 4
    //   61: ldc_w 304
    //   64: iload_2
    //   65: aload 5
    //   67: aload 4
    //   69: invokevirtual 298	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: ldc_w 409
    //   75: invokevirtual 298	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: aload_1
    //   79: getfield 144	bfif:b	Ljava/lang/String;
    //   82: invokevirtual 298	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: invokevirtual 307	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   88: invokestatic 310	bfmf:c	(Ljava/lang/String;ILjava/lang/String;)V
    //   91: aload_0
    //   92: getfield 99	bgjh:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   95: aload_0
    //   96: getfield 97	bgjh:jdField_a_of_type_Long	J
    //   99: aload_1
    //   100: aload_0
    //   101: getfield 90	bgjh:jdField_a_of_type_Aahp	Laahp;
    //   104: invokestatic 412	aagu:a	(Lcom/tencent/mobileqq/app/QQAppInterface;JLbfif;Laahp;)V
    //   107: aload_0
    //   108: aload_0
    //   109: getfield 413	bgjh:jdField_a_of_type_Int	I
    //   112: iconst_1
    //   113: iadd
    //   114: putfield 413	bgjh:jdField_a_of_type_Int	I
    //   117: iconst_1
    //   118: istore_3
    //   119: goto -97 -> 22
    //   122: ldc_w 317
    //   125: astore 4
    //   127: goto -66 -> 61
    //   130: astore_1
    //   131: aload_0
    //   132: monitorexit
    //   133: aload_1
    //   134: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	135	0	this	bgjh
    //   0	135	1	parambfif	bfif
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
  
  public boolean a(bfjh parambfjh)
  {
    return this.mObservers.contains(parambfjh);
  }
  
  public final boolean a(String paramString, long paramLong)
  {
    try
    {
      bgjn localbgjn = (bgjn)this.d.get(paramString + paramLong);
      paramString = localbgjn;
      if (localbgjn == null) {
        paramString = new bgjn(this, paramLong);
      }
      boolean bool = paramString.jdField_a_of_type_Boolean;
      return bool;
    }
    finally {}
  }
  
  public bfif b(String paramString)
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
        bfif localbfif = new bfif();
        localbfif.jdField_a_of_type_JavaUtilUUID = UUID.randomUUID();
        localbfif.i = paramString;
        paramString = new File(paramString);
        localbfif.jdField_a_of_type_Long = paramString.length();
        localbfif.c = paramString.getName();
        if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
        {
          paramString = "/";
          localbfif.g = paramString;
          this.jdField_b_of_type_JavaUtilMap.put(localbfif.jdField_a_of_type_JavaUtilUUID, localbfif);
          paramString = localbfif;
          break;
        }
      }
      finally {}
      paramString = this.jdField_a_of_type_JavaLangString;
    }
  }
  
  public bfif b(String paramString1, String paramString2, long paramLong, int paramInt)
  {
    try
    {
      bfif localbfif = new bfif();
      localbfif.jdField_a_of_type_JavaUtilUUID = UUID.nameUUIDFromBytes(paramString1.getBytes());
      localbfif.b = paramString1;
      localbfif.c = paramString2;
      localbfif.jdField_a_of_type_Long = paramLong;
      localbfif.jdField_a_of_type_Int = paramInt;
      localbfif.g = "/";
      this.jdField_b_of_type_JavaUtilMap.put(localbfif.jdField_a_of_type_JavaUtilUUID, localbfif);
      this.c.put(paramString1, localbfif);
      return localbfif;
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
        ((bfif)localIterator.next()).jdField_a_of_type_Boolean = false;
      }
    }
    finally {}
  }
  
  public final void b(bfif parambfif)
  {
    try
    {
      a(parambfif, 0, 0);
      return;
    }
    finally
    {
      parambfif = finally;
      throw parambfif;
    }
  }
  
  public final void b(String paramString)
  {
    try
    {
      bfmf.c("TroopFileManager", bfmf.jdField_a_of_type_Int, "doTroopFileDelete: filePath:" + paramString);
      paramString = (bfif)this.c.remove(paramString);
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
    //   2: getstatic 289	bfmf:jdField_a_of_type_Int	I
    //   5: istore_2
    //   6: new 291	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 292	java/lang/StringBuilder:<init>	()V
    //   13: ldc_w 294
    //   16: invokevirtual 298	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: astore 4
    //   21: aload_1
    //   22: ifnull +51 -> 73
    //   25: aload_1
    //   26: invokevirtual 302	java/util/UUID:toString	()Ljava/lang/String;
    //   29: astore_3
    //   30: ldc_w 304
    //   33: iload_2
    //   34: aload 4
    //   36: aload_3
    //   37: invokevirtual 298	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: ldc_w 437
    //   43: invokevirtual 298	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: invokevirtual 307	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: invokestatic 310	bfmf:c	(Ljava/lang/String;ILjava/lang/String;)V
    //   52: aload_0
    //   53: getfield 50	bgjh:jdField_b_of_type_JavaUtilMap	Ljava/util/Map;
    //   56: aload_1
    //   57: invokeinterface 313 2 0
    //   62: checkcast 128	bfif
    //   65: astore_1
    //   66: aload_1
    //   67: ifnonnull +13 -> 80
    //   70: aload_0
    //   71: monitorexit
    //   72: return
    //   73: ldc_w 317
    //   76: astore_3
    //   77: goto -47 -> 30
    //   80: aload_0
    //   81: aload_1
    //   82: invokevirtual 315	bgjh:c	(Lbfif;)V
    //   85: aload_0
    //   86: getfield 52	bgjh:c	Ljava/util/Map;
    //   89: aload_1
    //   90: getfield 144	bfif:b	Ljava/lang/String;
    //   93: invokeinterface 313 2 0
    //   98: pop
    //   99: goto -29 -> 70
    //   102: astore_1
    //   103: aload_0
    //   104: monitorexit
    //   105: aload_1
    //   106: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	107	0	this	bgjh
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
      bgjn localbgjn = (bgjn)this.d.get(paramString + paramLong);
      if (localbgjn == null)
      {
        localbgjn = new bgjn(this, paramLong);
        this.d.put(paramString + paramLong, localbgjn);
      }
      for (;;)
      {
        if (!localbgjn.jdField_a_of_type_Boolean)
        {
          bool = localbgjn.jdField_b_of_type_Boolean;
          if (!bool) {
            break label108;
          }
        }
        for (boolean bool = false;; bool = true)
        {
          return bool;
          label108:
          aagu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long, localbgjn.jdField_a_of_type_Int, 3, 20, 3, 1, paramString, localbgjn.c, paramLong, localbgjn.jdField_b_of_type_Int, localbgjn.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro, this.jdField_a_of_type_Aahf);
          localbgjn.jdField_b_of_type_Boolean = true;
        }
      }
    }
    finally {}
  }
  
  public bfif c(String paramString1, String paramString2, long paramLong, int paramInt)
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
  
  public void c(bfif parambfif)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager.f(parambfif.jdField_a_of_type_JavaUtilUUID);
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(2, new Object[] { parambfif }).sendToTarget();
  }
  
  public void d(bfif parambfif)
  {
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(3, new Object[] { parambfif }).sendToTarget();
  }
  
  public void e(bfif parambfif)
  {
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(6, new Object[] { parambfif }).sendToTarget();
  }
  
  public void f(bfif parambfif)
  {
    Iterator localIterator = this.mObservers.iterator();
    while (localIterator.hasNext()) {
      ((bfjh)localIterator.next()).a(parambfif);
    }
  }
  
  public void g(bfif parambfif)
  {
    Iterator localIterator = this.mObservers.iterator();
    while (localIterator.hasNext()) {
      ((bfjh)localIterator.next()).b(parambfif);
    }
  }
  
  public void h(bfif parambfif)
  {
    Iterator localIterator = this.mObservers.iterator();
    while (localIterator.hasNext()) {
      ((bfjh)localIterator.next()).c(parambfif);
    }
  }
  
  public void i(bfif parambfif)
  {
    Iterator localIterator = this.mObservers.iterator();
    while (localIterator.hasNext()) {
      ((bfjh)localIterator.next()).e(parambfif);
    }
  }
  
  public void j(bfif parambfif)
  {
    Iterator localIterator = this.mObservers.iterator();
    while (localIterator.hasNext()) {
      ((bfjh)localIterator.next()).d(parambfif);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgjh
 * JD-Core Version:    0.7.0.1
 */