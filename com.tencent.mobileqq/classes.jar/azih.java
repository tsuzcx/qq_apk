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

public class azih
  extends Observable<ayps>
{
  public static Map<Long, azih> a;
  public int a;
  public long a;
  public ajey a;
  public Handler a;
  public ArrayMap<Integer, List<aypv>> a;
  public azio a;
  public QQAppInterface a;
  public TroopFileTransferManager a;
  public String a;
  private wlq jdField_a_of_type_Wlq = new azik(this);
  private wlt jdField_a_of_type_Wlt = new azim(this);
  private wmd jdField_a_of_type_Wmd = new azil(this);
  public int b;
  public azio b;
  public Map<UUID, ayoq> b;
  public Map<String, ayoq> c = new HashMap();
  public Map<String, azin> d = new HashMap();
  
  static
  {
    if (!azih.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      jdField_a_of_type_Boolean = bool;
      jdField_a_of_type_JavaUtilMap = new HashMap();
      return;
    }
  }
  
  public azih(QQAppInterface paramQQAppInterface, long paramLong)
  {
    this.jdField_b_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_AndroidSupportV4UtilArrayMap = new ArrayMap();
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Azio = new azip();
    this.jdField_b_of_type_Azio = new aziq();
    this.jdField_a_of_type_Ajey = new azij(this);
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager = TroopFileTransferManager.a(paramQQAppInterface, paramLong);
    Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager.a().iterator();
    while (localIterator.hasNext())
    {
      ayqd localayqd = (ayqd)localIterator.next();
      ayoq localayoq = new ayoq();
      localayoq.jdField_a_of_type_JavaUtilUUID = localayqd.jdField_a_of_type_JavaUtilUUID;
      localayoq.a(localayqd, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_b_of_type_JavaUtilMap.put(localayoq.jdField_a_of_type_JavaUtilUUID, localayoq);
      if ((localayoq.b != null) && (!"/".equals(localayoq.b))) {
        this.c.put(localayoq.b, localayoq);
      }
    }
    this.jdField_a_of_type_AndroidOsHandler = new azii(this, paramQQAppInterface.getApplication().getMainLooper());
    paramQQAppInterface.addObserver(this.jdField_a_of_type_Ajey);
  }
  
  public static azih a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    try
    {
      azih localazih2 = (azih)jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramLong));
      azih localazih1;
      if (localazih2 != null)
      {
        localazih1 = localazih2;
        if (localazih2.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == paramQQAppInterface) {}
      }
      else
      {
        localazih1 = new azih(paramQQAppInterface, paramLong);
        jdField_a_of_type_JavaUtilMap.put(Long.valueOf(paramLong), localazih1);
      }
      return localazih1;
    }
    finally {}
  }
  
  public static List<ayoq> a(Collection<ayoq> paramCollection, azio paramazio)
  {
    ArrayList localArrayList = new ArrayList();
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      ayoq localayoq = (ayoq)paramCollection.next();
      if (paramazio.a(localayoq)) {
        localArrayList.add(localayoq);
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
        ((azih)localIterator.next()).c();
      }
      jdField_a_of_type_JavaUtilMap.clear();
    }
    finally {}
  }
  
  private void c()
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajey);
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
  public ayoq a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 52	azih:c	Ljava/util/Map;
    //   6: ifnull +21 -> 27
    //   9: aload_0
    //   10: getfield 52	azih:c	Ljava/util/Map;
    //   13: aload_1
    //   14: invokeinterface 186 2 0
    //   19: checkcast 128	ayoq
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
    //   0	37	0	this	azih
    //   0	37	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   2	23	32	finally
  }
  
  public ayoq a(String paramString, long paramLong, int paramInt)
  {
    try
    {
      ayoq localayoq = new ayoq();
      localayoq.jdField_a_of_type_JavaUtilUUID = UUID.randomUUID();
      localayoq.c = paramString;
      localayoq.jdField_a_of_type_Long = paramLong;
      localayoq.jdField_a_of_type_Int = paramInt;
      localayoq.a((int)NetConnInfoCenter.getServerTime());
      this.jdField_b_of_type_JavaUtilMap.put(localayoq.jdField_a_of_type_JavaUtilUUID, localayoq);
      return localayoq;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public ayoq a(String paramString1, String paramString2, long paramLong, int paramInt)
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
        localObject1 = ayrz.a(paramString1);
        if (localObject1 == null) {
          break label271;
        }
        if (((String)localObject1).length() != 0) {
          break label268;
        }
      }
      finally {}
      Object localObject2 = (ayoq)this.c.get(paramString1);
      if (localObject2 != null)
      {
        this.jdField_b_of_type_JavaUtilMap.put(((ayoq)localObject2).jdField_a_of_type_JavaUtilUUID, localObject2);
        paramString1 = (String)localObject2;
      }
      else
      {
        localObject1 = (ayoq)this.c.get(localObject1);
        if (localObject1 != null)
        {
          this.jdField_b_of_type_JavaUtilMap.put(((ayoq)localObject1).jdField_a_of_type_JavaUtilUUID, localObject1);
          paramString1 = (String)localObject1;
        }
        else
        {
          label268:
          label271:
          while (paramInt != 0)
          {
            localObject1 = new ayoq();
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager.a(paramString1);
            if (localObject2 != null) {
              ((ayoq)localObject1).jdField_a_of_type_JavaUtilUUID = ((ayqd)localObject2).jdField_a_of_type_JavaUtilUUID;
            }
            if (((ayoq)localObject1).jdField_a_of_type_JavaUtilUUID == null) {
              ((ayoq)localObject1).jdField_a_of_type_JavaUtilUUID = UUID.nameUUIDFromBytes(paramString1.getBytes());
            }
            ((ayoq)localObject1).b = paramString1;
            ((ayoq)localObject1).c = paramString2;
            ((ayoq)localObject1).jdField_a_of_type_Long = paramLong;
            ((ayoq)localObject1).jdField_a_of_type_Int = paramInt;
            if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {}
            for (paramString2 = "/";; paramString2 = this.jdField_a_of_type_JavaLangString)
            {
              ((ayoq)localObject1).f = paramString2;
              this.jdField_b_of_type_JavaUtilMap.put(((ayoq)localObject1).jdField_a_of_type_JavaUtilUUID, localObject1);
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
  
  public ayoq a(UUID paramUUID)
  {
    try
    {
      paramUUID = (ayoq)this.jdField_b_of_type_JavaUtilMap.get(paramUUID);
      return paramUUID;
    }
    finally
    {
      paramUUID = finally;
      throw paramUUID;
    }
  }
  
  public final List<ayoq> a()
  {
    try
    {
      List localList = a(this.jdField_b_of_type_JavaUtilMap.values(), this.jdField_b_of_type_Azio);
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
      ((ayps)localIterator.next()).a(paramInt);
    }
  }
  
  /* Error */
  public final void a(ayoq paramayoq)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull +92 -> 95
    //   6: getstatic 288	aysb:jdField_a_of_type_Int	I
    //   9: istore_2
    //   10: new 290	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 291	java/lang/StringBuilder:<init>	()V
    //   17: ldc_w 293
    //   20: invokevirtual 297	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: astore 4
    //   25: aload_1
    //   26: getfield 133	ayoq:jdField_a_of_type_JavaUtilUUID	Ljava/util/UUID;
    //   29: ifnull +69 -> 98
    //   32: aload_1
    //   33: getfield 133	ayoq:jdField_a_of_type_JavaUtilUUID	Ljava/util/UUID;
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
    //   59: invokestatic 309	aysb:c	(Ljava/lang/String;ILjava/lang/String;)V
    //   62: aload_0
    //   63: getfield 52	azih:c	Ljava/util/Map;
    //   66: aload_1
    //   67: getfield 144	ayoq:b	Ljava/lang/String;
    //   70: invokeinterface 312 2 0
    //   75: pop
    //   76: aload_0
    //   77: getfield 50	azih:jdField_b_of_type_JavaUtilMap	Ljava/util/Map;
    //   80: aload_1
    //   81: getfield 133	ayoq:jdField_a_of_type_JavaUtilUUID	Ljava/util/UUID;
    //   84: invokeinterface 312 2 0
    //   89: pop
    //   90: aload_0
    //   91: aload_1
    //   92: invokevirtual 314	azih:c	(Layoq;)V
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
    //   0	110	0	this	azih
    //   0	110	1	paramayoq	ayoq
    //   9	35	2	i	int
    //   39	63	3	str	String
    //   23	22	4	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   6	40	105	finally
    //   40	95	105	finally
  }
  
  public void a(ayoq paramayoq, int paramInt)
  {
    azic.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long, paramayoq.c, paramayoq.e, paramInt);
  }
  
  public final void a(ayoq paramayoq, int paramInt1, int paramInt2)
  {
    if (paramayoq != null) {}
    for (;;)
    {
      try
      {
        UUID localUUID = paramayoq.jdField_a_of_type_JavaUtilUUID;
        if (localUUID == null) {
          return;
        }
        aysb.c("TroopFileManager", aysb.jdField_a_of_type_Int, "[" + paramayoq.jdField_a_of_type_JavaUtilUUID.toString() + "] delete. mFileId:" + paramayoq.b + " mParentId:" + paramayoq.f + " uint32_bus_id:" + paramayoq.jdField_a_of_type_Int);
        if ((paramayoq.b == null) || (paramayoq.f == null) || ("".equals(paramayoq.b)) || ("".equals(paramayoq.f)))
        {
          b(paramayoq.jdField_a_of_type_JavaUtilUUID);
          continue;
        }
        if (paramayoq.jdField_a_of_type_Int == 0) {
          continue;
        }
      }
      finally {}
      wln.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long, paramayoq.jdField_a_of_type_Int, paramayoq.b, paramayoq.f, paramInt1, paramInt2, this.jdField_a_of_type_Wlq);
    }
  }
  
  public void a(ayoq paramayoq, String paramString)
  {
    Iterator localIterator = this.mObservers.iterator();
    while (localIterator.hasNext()) {
      ((ayps)localIterator.next()).a(paramayoq, paramString);
    }
  }
  
  public final void a(String paramString)
  {
    try
    {
      aysb.c("TroopFileManager", aysb.jdField_a_of_type_Int, "doUploadDelete: filePath:" + paramString);
      paramString = (ayoq)this.c.remove(paramString);
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
  
  public void a(String paramString, ayoq paramayoq)
  {
    try
    {
      this.c.put(paramString, paramayoq);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void a(Collection<ayoq> paramCollection, boolean paramBoolean, String paramString, long paramLong)
  {
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1, new Object[] { paramCollection, Boolean.valueOf(paramBoolean), paramString, Long.valueOf(paramLong) }).sendToTarget();
  }
  
  public void a(List<ayoq> paramList, boolean paramBoolean, String paramString, long paramLong)
  {
    Iterator localIterator = this.mObservers.iterator();
    while (localIterator.hasNext()) {
      ((ayps)localIterator.next()).a(paramList, paramBoolean, paramString, paramLong);
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
        paramUUID = (ayoq)this.jdField_b_of_type_JavaUtilMap.get(paramUUID);
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
      azin localazin = (azin)this.d.get(paramString + paramLong);
      if (localazin == null)
      {
        localazin = new azin(this, paramLong);
        this.d.put(paramString + paramLong, localazin);
      }
      for (;;)
      {
        long l1 = System.currentTimeMillis();
        long l2 = localazin.jdField_a_of_type_Long;
        l1 -= l2;
        if ((0L < l1) && (l1 < paramInt * 1000L)) {}
        for (boolean bool = false;; bool = true)
        {
          return bool;
          localazin.jdField_a_of_type_Long = System.currentTimeMillis();
          wln.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long, localazin.jdField_a_of_type_Int, 1, 20, 3, 1, paramString, localazin.c, paramLong, 0, localazin.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro, this.jdField_a_of_type_Wlt);
        }
      }
    }
    finally {}
  }
  
  /* Error */
  public final boolean a(ayoq paramayoq)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: getfield 232	ayoq:jdField_a_of_type_Int	I
    //   6: ifeq +14 -> 20
    //   9: aload_1
    //   10: getfield 144	ayoq:b	Ljava/lang/String;
    //   13: astore 4
    //   15: aload 4
    //   17: ifnonnull +9 -> 26
    //   20: iconst_0
    //   21: istore_3
    //   22: aload_0
    //   23: monitorexit
    //   24: iload_3
    //   25: ireturn
    //   26: getstatic 288	aysb:jdField_a_of_type_Int	I
    //   29: istore_2
    //   30: new 290	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 291	java/lang/StringBuilder:<init>	()V
    //   37: ldc_w 293
    //   40: invokevirtual 297	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: astore 5
    //   45: aload_1
    //   46: getfield 133	ayoq:jdField_a_of_type_JavaUtilUUID	Ljava/util/UUID;
    //   49: ifnull +73 -> 122
    //   52: aload_1
    //   53: getfield 133	ayoq:jdField_a_of_type_JavaUtilUUID	Ljava/util/UUID;
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
    //   79: getfield 144	ayoq:b	Ljava/lang/String;
    //   82: invokevirtual 297	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: invokevirtual 306	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   88: invokestatic 309	aysb:c	(Ljava/lang/String;ILjava/lang/String;)V
    //   91: aload_0
    //   92: getfield 99	azih:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   95: aload_0
    //   96: getfield 97	azih:jdField_a_of_type_Long	J
    //   99: aload_1
    //   100: aload_0
    //   101: getfield 90	azih:jdField_a_of_type_Wmd	Lwmd;
    //   104: invokestatic 411	wln:a	(Lcom/tencent/mobileqq/app/QQAppInterface;JLayoq;Lwmd;)V
    //   107: aload_0
    //   108: aload_0
    //   109: getfield 412	azih:jdField_a_of_type_Int	I
    //   112: iconst_1
    //   113: iadd
    //   114: putfield 412	azih:jdField_a_of_type_Int	I
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
    //   0	135	0	this	azih
    //   0	135	1	paramayoq	ayoq
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
  
  public boolean a(ayps paramayps)
  {
    return this.mObservers.contains(paramayps);
  }
  
  public final boolean a(String paramString, long paramLong)
  {
    try
    {
      azin localazin = (azin)this.d.get(paramString + paramLong);
      paramString = localazin;
      if (localazin == null) {
        paramString = new azin(this, paramLong);
      }
      boolean bool = paramString.jdField_a_of_type_Boolean;
      return bool;
    }
    finally {}
  }
  
  public ayoq b(String paramString)
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
        ayoq localayoq = new ayoq();
        localayoq.jdField_a_of_type_JavaUtilUUID = UUID.randomUUID();
        localayoq.h = paramString;
        paramString = new File(paramString);
        localayoq.jdField_a_of_type_Long = paramString.length();
        localayoq.c = paramString.getName();
        if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
        {
          paramString = "/";
          localayoq.f = paramString;
          this.jdField_b_of_type_JavaUtilMap.put(localayoq.jdField_a_of_type_JavaUtilUUID, localayoq);
          paramString = localayoq;
          break;
        }
      }
      finally {}
      paramString = this.jdField_a_of_type_JavaLangString;
    }
  }
  
  public ayoq b(String paramString1, String paramString2, long paramLong, int paramInt)
  {
    try
    {
      ayoq localayoq = new ayoq();
      localayoq.jdField_a_of_type_JavaUtilUUID = UUID.nameUUIDFromBytes(paramString1.getBytes());
      localayoq.b = paramString1;
      localayoq.c = paramString2;
      localayoq.jdField_a_of_type_Long = paramLong;
      localayoq.jdField_a_of_type_Int = paramInt;
      localayoq.f = "/";
      this.jdField_b_of_type_JavaUtilMap.put(localayoq.jdField_a_of_type_JavaUtilUUID, localayoq);
      this.c.put(paramString1, localayoq);
      return localayoq;
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
        ((ayoq)localIterator.next()).jdField_a_of_type_Boolean = false;
      }
    }
    finally {}
  }
  
  public final void b(ayoq paramayoq)
  {
    try
    {
      a(paramayoq, 0, 0);
      return;
    }
    finally
    {
      paramayoq = finally;
      throw paramayoq;
    }
  }
  
  public final void b(String paramString)
  {
    try
    {
      aysb.c("TroopFileManager", aysb.jdField_a_of_type_Int, "doTroopFileDelete: filePath:" + paramString);
      paramString = (ayoq)this.c.remove(paramString);
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
    //   2: getstatic 288	aysb:jdField_a_of_type_Int	I
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
    //   49: invokestatic 309	aysb:c	(Ljava/lang/String;ILjava/lang/String;)V
    //   52: aload_0
    //   53: getfield 50	azih:jdField_b_of_type_JavaUtilMap	Ljava/util/Map;
    //   56: aload_1
    //   57: invokeinterface 312 2 0
    //   62: checkcast 128	ayoq
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
    //   82: invokevirtual 314	azih:c	(Layoq;)V
    //   85: aload_0
    //   86: getfield 52	azih:c	Ljava/util/Map;
    //   89: aload_1
    //   90: getfield 144	ayoq:b	Ljava/lang/String;
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
    //   0	107	0	this	azih
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
      azin localazin = (azin)this.d.get(paramString + paramLong);
      if (localazin == null)
      {
        localazin = new azin(this, paramLong);
        this.d.put(paramString + paramLong, localazin);
      }
      for (;;)
      {
        if (!localazin.jdField_a_of_type_Boolean)
        {
          bool = localazin.jdField_b_of_type_Boolean;
          if (!bool) {
            break label108;
          }
        }
        for (boolean bool = false;; bool = true)
        {
          return bool;
          label108:
          wln.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long, localazin.jdField_a_of_type_Int, 3, 20, 3, 1, paramString, localazin.c, paramLong, localazin.jdField_b_of_type_Int, localazin.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro, this.jdField_a_of_type_Wlt);
          localazin.jdField_b_of_type_Boolean = true;
        }
      }
    }
    finally {}
  }
  
  public ayoq c(String paramString1, String paramString2, long paramLong, int paramInt)
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
  
  public void c(ayoq paramayoq)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager.f(paramayoq.jdField_a_of_type_JavaUtilUUID);
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(2, new Object[] { paramayoq }).sendToTarget();
  }
  
  public void d(ayoq paramayoq)
  {
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(3, new Object[] { paramayoq }).sendToTarget();
  }
  
  public void e(ayoq paramayoq)
  {
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(6, new Object[] { paramayoq }).sendToTarget();
  }
  
  public void f(ayoq paramayoq)
  {
    Iterator localIterator = this.mObservers.iterator();
    while (localIterator.hasNext()) {
      ((ayps)localIterator.next()).a(paramayoq);
    }
  }
  
  public void g(ayoq paramayoq)
  {
    Iterator localIterator = this.mObservers.iterator();
    while (localIterator.hasNext()) {
      ((ayps)localIterator.next()).b(paramayoq);
    }
  }
  
  public void h(ayoq paramayoq)
  {
    Iterator localIterator = this.mObservers.iterator();
    while (localIterator.hasNext()) {
      ((ayps)localIterator.next()).c(paramayoq);
    }
  }
  
  public void i(ayoq paramayoq)
  {
    Iterator localIterator = this.mObservers.iterator();
    while (localIterator.hasNext()) {
      ((ayps)localIterator.next()).e(paramayoq);
    }
  }
  
  public void j(ayoq paramayoq)
  {
    Iterator localIterator = this.mObservers.iterator();
    while (localIterator.hasNext()) {
      ((ayps)localIterator.next()).d(paramayoq);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azih
 * JD-Core Version:    0.7.0.1
 */