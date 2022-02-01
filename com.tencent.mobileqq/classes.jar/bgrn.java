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

public class bgrn
  extends Observable<bfsu>
{
  public static Map<Long, bgrn> a;
  public int a;
  public long a;
  private aavd jdField_a_of_type_Aavd = new bgrq(this);
  private aavg jdField_a_of_type_Aavg = new bgrs(this);
  private aavq jdField_a_of_type_Aavq = new bgrr(this);
  public Handler a;
  public ArrayMap<Integer, List<bfsx>> a;
  public anua a;
  public bgru a;
  public QQAppInterface a;
  public TroopFileTransferManager a;
  public String a;
  public int b;
  public bgru b;
  public Map<UUID, bfrs> b;
  public Map<String, bfrs> c = new HashMap();
  public Map<String, bgrt> d = new HashMap();
  
  static
  {
    if (!bgrn.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      jdField_a_of_type_Boolean = bool;
      jdField_a_of_type_JavaUtilMap = new HashMap();
      return;
    }
  }
  
  public bgrn(QQAppInterface paramQQAppInterface, long paramLong)
  {
    this.jdField_b_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_AndroidSupportV4UtilArrayMap = new ArrayMap();
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Bgru = new bgrv();
    this.jdField_b_of_type_Bgru = new bgrw();
    this.jdField_a_of_type_Anua = new bgrp(this);
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager = TroopFileTransferManager.a(paramQQAppInterface, paramLong);
    Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager.a().iterator();
    while (localIterator.hasNext())
    {
      bftf localbftf = (bftf)localIterator.next();
      bfrs localbfrs = new bfrs();
      localbfrs.jdField_a_of_type_JavaUtilUUID = localbftf.jdField_a_of_type_JavaUtilUUID;
      localbfrs.a(localbftf, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_b_of_type_JavaUtilMap.put(localbfrs.jdField_a_of_type_JavaUtilUUID, localbfrs);
      if ((localbfrs.b != null) && (!"/".equals(localbfrs.b))) {
        this.c.put(localbfrs.b, localbfrs);
      }
    }
    this.jdField_a_of_type_AndroidOsHandler = new bgro(this, paramQQAppInterface.getApplication().getMainLooper());
    paramQQAppInterface.addObserver(this.jdField_a_of_type_Anua);
  }
  
  public static bgrn a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    try
    {
      bgrn localbgrn2 = (bgrn)jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramLong));
      bgrn localbgrn1;
      if (localbgrn2 != null)
      {
        localbgrn1 = localbgrn2;
        if (localbgrn2.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == paramQQAppInterface) {}
      }
      else
      {
        localbgrn1 = new bgrn(paramQQAppInterface, paramLong);
        jdField_a_of_type_JavaUtilMap.put(Long.valueOf(paramLong), localbgrn1);
      }
      return localbgrn1;
    }
    finally {}
  }
  
  public static List<bfrs> a(Collection<bfrs> paramCollection, bgru parambgru)
  {
    ArrayList localArrayList = new ArrayList();
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      bfrs localbfrs = (bfrs)paramCollection.next();
      if (parambgru.a(localbfrs)) {
        localArrayList.add(localbfrs);
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
        ((bgrn)localIterator.next()).c();
      }
      jdField_a_of_type_JavaUtilMap.clear();
    }
    finally {}
  }
  
  private void c()
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anua);
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
  public bfrs a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 52	bgrn:c	Ljava/util/Map;
    //   6: ifnull +21 -> 27
    //   9: aload_0
    //   10: getfield 52	bgrn:c	Ljava/util/Map;
    //   13: aload_1
    //   14: invokeinterface 186 2 0
    //   19: checkcast 128	bfrs
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
    //   0	37	0	this	bgrn
    //   0	37	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   2	23	32	finally
  }
  
  public bfrs a(String paramString, long paramLong, int paramInt)
  {
    try
    {
      bfrs localbfrs = new bfrs();
      localbfrs.jdField_a_of_type_JavaUtilUUID = UUID.randomUUID();
      localbfrs.c = paramString;
      localbfrs.jdField_a_of_type_Long = paramLong;
      localbfrs.jdField_a_of_type_Int = paramInt;
      localbfrs.a((int)NetConnInfoCenter.getServerTime());
      this.jdField_b_of_type_JavaUtilMap.put(localbfrs.jdField_a_of_type_JavaUtilUUID, localbfrs);
      return localbfrs;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public bfrs a(String paramString1, String paramString2, long paramLong, int paramInt)
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
        localObject1 = bfvp.a(paramString1);
        if (localObject1 == null) {
          break label271;
        }
        if (((String)localObject1).length() != 0) {
          break label268;
        }
      }
      finally {}
      Object localObject2 = (bfrs)this.c.get(paramString1);
      if (localObject2 != null)
      {
        this.jdField_b_of_type_JavaUtilMap.put(((bfrs)localObject2).jdField_a_of_type_JavaUtilUUID, localObject2);
        paramString1 = (String)localObject2;
      }
      else
      {
        localObject1 = (bfrs)this.c.get(localObject1);
        if (localObject1 != null)
        {
          this.jdField_b_of_type_JavaUtilMap.put(((bfrs)localObject1).jdField_a_of_type_JavaUtilUUID, localObject1);
          paramString1 = (String)localObject1;
        }
        else
        {
          label268:
          label271:
          while (paramInt != 0)
          {
            localObject1 = new bfrs();
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager.a(paramString1);
            if (localObject2 != null) {
              ((bfrs)localObject1).jdField_a_of_type_JavaUtilUUID = ((bftf)localObject2).jdField_a_of_type_JavaUtilUUID;
            }
            if (((bfrs)localObject1).jdField_a_of_type_JavaUtilUUID == null) {
              ((bfrs)localObject1).jdField_a_of_type_JavaUtilUUID = UUID.nameUUIDFromBytes(paramString1.getBytes());
            }
            ((bfrs)localObject1).b = paramString1;
            ((bfrs)localObject1).c = paramString2;
            ((bfrs)localObject1).jdField_a_of_type_Long = paramLong;
            ((bfrs)localObject1).jdField_a_of_type_Int = paramInt;
            if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {}
            for (paramString2 = "/";; paramString2 = this.jdField_a_of_type_JavaLangString)
            {
              ((bfrs)localObject1).f = paramString2;
              this.jdField_b_of_type_JavaUtilMap.put(((bfrs)localObject1).jdField_a_of_type_JavaUtilUUID, localObject1);
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
  
  public bfrs a(UUID paramUUID)
  {
    try
    {
      paramUUID = (bfrs)this.jdField_b_of_type_JavaUtilMap.get(paramUUID);
      return paramUUID;
    }
    finally
    {
      paramUUID = finally;
      throw paramUUID;
    }
  }
  
  public final List<bfrs> a()
  {
    try
    {
      List localList = a(this.jdField_b_of_type_JavaUtilMap.values(), this.jdField_b_of_type_Bgru);
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
      ((bfsu)localIterator.next()).a(paramInt);
    }
  }
  
  /* Error */
  public final void a(bfrs parambfrs)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull +92 -> 95
    //   6: getstatic 288	bfvr:jdField_a_of_type_Int	I
    //   9: istore_2
    //   10: new 290	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 291	java/lang/StringBuilder:<init>	()V
    //   17: ldc_w 293
    //   20: invokevirtual 297	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: astore 4
    //   25: aload_1
    //   26: getfield 133	bfrs:jdField_a_of_type_JavaUtilUUID	Ljava/util/UUID;
    //   29: ifnull +69 -> 98
    //   32: aload_1
    //   33: getfield 133	bfrs:jdField_a_of_type_JavaUtilUUID	Ljava/util/UUID;
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
    //   59: invokestatic 309	bfvr:c	(Ljava/lang/String;ILjava/lang/String;)V
    //   62: aload_0
    //   63: getfield 52	bgrn:c	Ljava/util/Map;
    //   66: aload_1
    //   67: getfield 144	bfrs:b	Ljava/lang/String;
    //   70: invokeinterface 312 2 0
    //   75: pop
    //   76: aload_0
    //   77: getfield 50	bgrn:jdField_b_of_type_JavaUtilMap	Ljava/util/Map;
    //   80: aload_1
    //   81: getfield 133	bfrs:jdField_a_of_type_JavaUtilUUID	Ljava/util/UUID;
    //   84: invokeinterface 312 2 0
    //   89: pop
    //   90: aload_0
    //   91: aload_1
    //   92: invokevirtual 314	bgrn:c	(Lbfrs;)V
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
    //   0	110	0	this	bgrn
    //   0	110	1	parambfrs	bfrs
    //   9	35	2	i	int
    //   39	63	3	str	String
    //   23	22	4	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   6	40	105	finally
    //   40	95	105	finally
  }
  
  public void a(bfrs parambfrs, int paramInt)
  {
    bgri.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long, parambfrs.c, parambfrs.e, paramInt);
  }
  
  public final void a(bfrs parambfrs, int paramInt1, int paramInt2)
  {
    if (parambfrs != null) {}
    for (;;)
    {
      try
      {
        UUID localUUID = parambfrs.jdField_a_of_type_JavaUtilUUID;
        if (localUUID == null) {
          return;
        }
        bfvr.c("TroopFileManager", bfvr.jdField_a_of_type_Int, "[" + parambfrs.jdField_a_of_type_JavaUtilUUID.toString() + "] delete. mFileId:" + parambfrs.b + " mParentId:" + parambfrs.f + " uint32_bus_id:" + parambfrs.jdField_a_of_type_Int);
        if ((parambfrs.b == null) || (parambfrs.f == null) || ("".equals(parambfrs.b)) || ("".equals(parambfrs.f)))
        {
          b(parambfrs.jdField_a_of_type_JavaUtilUUID);
          continue;
        }
        if (parambfrs.jdField_a_of_type_Int == 0) {
          continue;
        }
      }
      finally {}
      aauw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long, parambfrs.jdField_a_of_type_Int, parambfrs.b, parambfrs.f, paramInt1, paramInt2, this.jdField_a_of_type_Aavd);
    }
  }
  
  public void a(bfrs parambfrs, String paramString)
  {
    Iterator localIterator = this.mObservers.iterator();
    while (localIterator.hasNext()) {
      ((bfsu)localIterator.next()).a(parambfrs, paramString);
    }
  }
  
  public final void a(String paramString)
  {
    try
    {
      bfvr.c("TroopFileManager", bfvr.jdField_a_of_type_Int, "doUploadDelete: filePath:" + paramString);
      paramString = (bfrs)this.c.remove(paramString);
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
  
  public void a(String paramString, bfrs parambfrs)
  {
    try
    {
      this.c.put(paramString, parambfrs);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void a(Collection<bfrs> paramCollection, boolean paramBoolean, String paramString, long paramLong)
  {
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1, new Object[] { paramCollection, Boolean.valueOf(paramBoolean), paramString, Long.valueOf(paramLong) }).sendToTarget();
  }
  
  public void a(List<bfrs> paramList, boolean paramBoolean, String paramString, long paramLong)
  {
    Iterator localIterator = this.mObservers.iterator();
    while (localIterator.hasNext()) {
      ((bfsu)localIterator.next()).a(paramList, paramBoolean, paramString, paramLong);
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
        paramUUID = (bfrs)this.jdField_b_of_type_JavaUtilMap.get(paramUUID);
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
      bgrt localbgrt = (bgrt)this.d.get(paramString + paramLong);
      if (localbgrt == null)
      {
        localbgrt = new bgrt(this, paramLong);
        this.d.put(paramString + paramLong, localbgrt);
      }
      for (;;)
      {
        long l1 = System.currentTimeMillis();
        long l2 = localbgrt.jdField_a_of_type_Long;
        l1 -= l2;
        if ((0L < l1) && (l1 < paramInt * 1000L)) {}
        for (boolean bool = false;; bool = true)
        {
          return bool;
          localbgrt.jdField_a_of_type_Long = System.currentTimeMillis();
          aauw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long, localbgrt.jdField_a_of_type_Int, 1, 20, 3, 1, paramString, localbgrt.c, paramLong, 0, localbgrt.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro, this.jdField_a_of_type_Aavg);
        }
      }
    }
    finally {}
  }
  
  /* Error */
  public final boolean a(bfrs parambfrs)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: getfield 232	bfrs:jdField_a_of_type_Int	I
    //   6: ifeq +14 -> 20
    //   9: aload_1
    //   10: getfield 144	bfrs:b	Ljava/lang/String;
    //   13: astore 4
    //   15: aload 4
    //   17: ifnonnull +9 -> 26
    //   20: iconst_0
    //   21: istore_3
    //   22: aload_0
    //   23: monitorexit
    //   24: iload_3
    //   25: ireturn
    //   26: getstatic 288	bfvr:jdField_a_of_type_Int	I
    //   29: istore_2
    //   30: new 290	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 291	java/lang/StringBuilder:<init>	()V
    //   37: ldc_w 293
    //   40: invokevirtual 297	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: astore 5
    //   45: aload_1
    //   46: getfield 133	bfrs:jdField_a_of_type_JavaUtilUUID	Ljava/util/UUID;
    //   49: ifnull +73 -> 122
    //   52: aload_1
    //   53: getfield 133	bfrs:jdField_a_of_type_JavaUtilUUID	Ljava/util/UUID;
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
    //   79: getfield 144	bfrs:b	Ljava/lang/String;
    //   82: invokevirtual 297	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: invokevirtual 306	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   88: invokestatic 309	bfvr:c	(Ljava/lang/String;ILjava/lang/String;)V
    //   91: aload_0
    //   92: getfield 99	bgrn:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   95: aload_0
    //   96: getfield 97	bgrn:jdField_a_of_type_Long	J
    //   99: aload_1
    //   100: aload_0
    //   101: getfield 90	bgrn:jdField_a_of_type_Aavq	Laavq;
    //   104: invokestatic 411	aauw:a	(Lcom/tencent/mobileqq/app/QQAppInterface;JLbfrs;Laavq;)V
    //   107: aload_0
    //   108: aload_0
    //   109: getfield 412	bgrn:jdField_a_of_type_Int	I
    //   112: iconst_1
    //   113: iadd
    //   114: putfield 412	bgrn:jdField_a_of_type_Int	I
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
    //   0	135	0	this	bgrn
    //   0	135	1	parambfrs	bfrs
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
  
  public boolean a(bfsu parambfsu)
  {
    return this.mObservers.contains(parambfsu);
  }
  
  public final boolean a(String paramString, long paramLong)
  {
    try
    {
      bgrt localbgrt = (bgrt)this.d.get(paramString + paramLong);
      paramString = localbgrt;
      if (localbgrt == null) {
        paramString = new bgrt(this, paramLong);
      }
      boolean bool = paramString.jdField_a_of_type_Boolean;
      return bool;
    }
    finally {}
  }
  
  public bfrs b(String paramString)
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
        bfrs localbfrs = new bfrs();
        localbfrs.jdField_a_of_type_JavaUtilUUID = UUID.randomUUID();
        localbfrs.h = paramString;
        paramString = new File(paramString);
        localbfrs.jdField_a_of_type_Long = paramString.length();
        localbfrs.c = paramString.getName();
        if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
        {
          paramString = "/";
          localbfrs.f = paramString;
          this.jdField_b_of_type_JavaUtilMap.put(localbfrs.jdField_a_of_type_JavaUtilUUID, localbfrs);
          paramString = localbfrs;
          break;
        }
      }
      finally {}
      paramString = this.jdField_a_of_type_JavaLangString;
    }
  }
  
  public bfrs b(String paramString1, String paramString2, long paramLong, int paramInt)
  {
    try
    {
      bfrs localbfrs = new bfrs();
      localbfrs.jdField_a_of_type_JavaUtilUUID = UUID.nameUUIDFromBytes(paramString1.getBytes());
      localbfrs.b = paramString1;
      localbfrs.c = paramString2;
      localbfrs.jdField_a_of_type_Long = paramLong;
      localbfrs.jdField_a_of_type_Int = paramInt;
      localbfrs.f = "/";
      this.jdField_b_of_type_JavaUtilMap.put(localbfrs.jdField_a_of_type_JavaUtilUUID, localbfrs);
      this.c.put(paramString1, localbfrs);
      return localbfrs;
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
        ((bfrs)localIterator.next()).jdField_a_of_type_Boolean = false;
      }
    }
    finally {}
  }
  
  public final void b(bfrs parambfrs)
  {
    try
    {
      a(parambfrs, 0, 0);
      return;
    }
    finally
    {
      parambfrs = finally;
      throw parambfrs;
    }
  }
  
  public final void b(String paramString)
  {
    try
    {
      bfvr.c("TroopFileManager", bfvr.jdField_a_of_type_Int, "doTroopFileDelete: filePath:" + paramString);
      paramString = (bfrs)this.c.remove(paramString);
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
    //   2: getstatic 288	bfvr:jdField_a_of_type_Int	I
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
    //   49: invokestatic 309	bfvr:c	(Ljava/lang/String;ILjava/lang/String;)V
    //   52: aload_0
    //   53: getfield 50	bgrn:jdField_b_of_type_JavaUtilMap	Ljava/util/Map;
    //   56: aload_1
    //   57: invokeinterface 312 2 0
    //   62: checkcast 128	bfrs
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
    //   82: invokevirtual 314	bgrn:c	(Lbfrs;)V
    //   85: aload_0
    //   86: getfield 52	bgrn:c	Ljava/util/Map;
    //   89: aload_1
    //   90: getfield 144	bfrs:b	Ljava/lang/String;
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
    //   0	107	0	this	bgrn
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
      bgrt localbgrt = (bgrt)this.d.get(paramString + paramLong);
      if (localbgrt == null)
      {
        localbgrt = new bgrt(this, paramLong);
        this.d.put(paramString + paramLong, localbgrt);
      }
      for (;;)
      {
        if (!localbgrt.jdField_a_of_type_Boolean)
        {
          bool = localbgrt.jdField_b_of_type_Boolean;
          if (!bool) {
            break label108;
          }
        }
        for (boolean bool = false;; bool = true)
        {
          return bool;
          label108:
          aauw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long, localbgrt.jdField_a_of_type_Int, 3, 20, 3, 1, paramString, localbgrt.c, paramLong, localbgrt.jdField_b_of_type_Int, localbgrt.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro, this.jdField_a_of_type_Aavg);
          localbgrt.jdField_b_of_type_Boolean = true;
        }
      }
    }
    finally {}
  }
  
  public bfrs c(String paramString1, String paramString2, long paramLong, int paramInt)
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
  
  public void c(bfrs parambfrs)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager.f(parambfrs.jdField_a_of_type_JavaUtilUUID);
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(2, new Object[] { parambfrs }).sendToTarget();
  }
  
  public void d(bfrs parambfrs)
  {
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(3, new Object[] { parambfrs }).sendToTarget();
  }
  
  public void e(bfrs parambfrs)
  {
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(6, new Object[] { parambfrs }).sendToTarget();
  }
  
  public void f(bfrs parambfrs)
  {
    Iterator localIterator = this.mObservers.iterator();
    while (localIterator.hasNext()) {
      ((bfsu)localIterator.next()).a(parambfrs);
    }
  }
  
  public void g(bfrs parambfrs)
  {
    Iterator localIterator = this.mObservers.iterator();
    while (localIterator.hasNext()) {
      ((bfsu)localIterator.next()).b(parambfrs);
    }
  }
  
  public void h(bfrs parambfrs)
  {
    Iterator localIterator = this.mObservers.iterator();
    while (localIterator.hasNext()) {
      ((bfsu)localIterator.next()).c(parambfrs);
    }
  }
  
  public void i(bfrs parambfrs)
  {
    Iterator localIterator = this.mObservers.iterator();
    while (localIterator.hasNext()) {
      ((bfsu)localIterator.next()).e(parambfrs);
    }
  }
  
  public void j(bfrs parambfrs)
  {
    Iterator localIterator = this.mObservers.iterator();
    while (localIterator.hasNext()) {
      ((bfsu)localIterator.next()).d(parambfrs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgrn
 * JD-Core Version:    0.7.0.1
 */