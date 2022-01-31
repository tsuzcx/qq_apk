import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.util.WeakReference;

public class arzn
{
  private int jdField_a_of_type_Int;
  private aryj jdField_a_of_type_Aryj;
  private Map<Long, aryj> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  private WeakReference<arzp> jdField_a_of_type_MqqUtilWeakReference;
  
  public aryj a()
  {
    try
    {
      aryj localaryj = this.jdField_a_of_type_Aryj;
      return localaryj;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public aryj a(long paramLong)
  {
    try
    {
      aryj localaryj = (aryj)this.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramLong));
      return localaryj;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public String a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 27	arzn:jdField_a_of_type_Aryj	Laryj;
    //   6: ifnull +15 -> 21
    //   9: aload_0
    //   10: getfield 27	arzn:jdField_a_of_type_Aryj	Laryj;
    //   13: invokevirtual 47	aryj:f	()Ljava/lang/String;
    //   16: astore_1
    //   17: aload_0
    //   18: monitorexit
    //   19: aload_1
    //   20: areturn
    //   21: ldc 49
    //   23: astore_1
    //   24: goto -7 -> 17
    //   27: astore_1
    //   28: aload_0
    //   29: monitorexit
    //   30: aload_1
    //   31: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	32	0	this	arzn
    //   16	8	1	str	String
    //   27	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	17	27	finally
  }
  
  public void a()
  {
    try
    {
      this.jdField_a_of_type_JavaUtilMap.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(long paramLong, aryj paramaryj)
  {
    for (;;)
    {
      try
      {
        QLog.d("ForwardD55Manager", 1, new Object[] { "--> onResult appId=", Long.valueOf(paramLong), ", appInfo=", paramaryj.toString() });
        this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(paramLong), paramaryj);
        if (this.jdField_a_of_type_MqqUtilWeakReference != null)
        {
          QLog.d("ForwardD55Manager", 1, "--> onResult null != mListener");
          if (this.jdField_a_of_type_MqqUtilWeakReference.get() != null)
          {
            QLog.d("ForwardD55Manager", 1, "--> onResult null != mListener.get()");
            ((arzp)this.jdField_a_of_type_MqqUtilWeakReference.get()).a();
            return;
          }
          QLog.d("ForwardD55Manager", 1, "--> onResult null == mListener.get()");
          continue;
        }
        QLog.d("ForwardD55Manager", 1, "--> onResult null == mListener");
      }
      finally {}
    }
  }
  
  /* Error */
  public void a(arzp paramarzp)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 55
    //   4: iconst_1
    //   5: iconst_2
    //   6: anewarray 4	java/lang/Object
    //   9: dup
    //   10: iconst_0
    //   11: ldc 97
    //   13: aastore
    //   14: dup
    //   15: iconst_1
    //   16: aload_1
    //   17: aastore
    //   18: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   21: aload_1
    //   22: ifnonnull +13 -> 35
    //   25: aconst_null
    //   26: astore_1
    //   27: aload_0
    //   28: aload_1
    //   29: putfield 74	arzn:jdField_a_of_type_MqqUtilWeakReference	Lmqq/util/WeakReference;
    //   32: aload_0
    //   33: monitorexit
    //   34: return
    //   35: new 81	mqq/util/WeakReference
    //   38: dup
    //   39: aload_1
    //   40: invokespecial 100	mqq/util/WeakReference:<init>	(Ljava/lang/Object;)V
    //   43: astore_1
    //   44: goto -17 -> 27
    //   47: astore_1
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_1
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	52	0	this	arzn
    //   0	52	1	paramarzp	arzp
    // Exception table:
    //   from	to	target	type
    //   2	21	47	finally
    //   27	32	47	finally
    //   35	44	47	finally
  }
  
  public void a(String paramString1, long paramLong, String paramString2)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Aryj = null;
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    QLog.d("ForwardD55Manager", 1, new Object[] { "fetchAppInfoByD55 openId=", paramString1, ", appId=", Long.valueOf(paramLong), ", pkgName=", paramString2 });
    aseh.a("KEY_STAGE_1_D55");
    localObject = ((QQAppInterface)localObject).a();
    if (paramString1 == null) {
      paramString1 = "";
    }
    for (;;)
    {
      ((MessageHandler)localObject).a(false, paramString1, false, 0L, paramLong, 1, 2, paramString2, true, asdt.a(), new arzo(this, paramString2, paramLong));
      return;
    }
  }
  
  /* Error */
  public boolean a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 27	arzn:jdField_a_of_type_Aryj	Laryj;
    //   6: ifnull +18 -> 24
    //   9: aload_0
    //   10: getfield 24	arzn:jdField_a_of_type_Int	I
    //   13: istore_1
    //   14: iload_1
    //   15: ifne +9 -> 24
    //   18: iconst_1
    //   19: istore_2
    //   20: aload_0
    //   21: monitorexit
    //   22: iload_2
    //   23: ireturn
    //   24: iconst_0
    //   25: istore_2
    //   26: goto -6 -> 20
    //   29: astore_3
    //   30: aload_0
    //   31: monitorexit
    //   32: aload_3
    //   33: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	34	0	this	arzn
    //   13	2	1	i	int
    //   19	7	2	bool	boolean
    //   29	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	14	29	finally
  }
  
  /* Error */
  public boolean b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 27	arzn:jdField_a_of_type_Aryj	Laryj;
    //   6: ifnull +18 -> 24
    //   9: aload_0
    //   10: getfield 24	arzn:jdField_a_of_type_Int	I
    //   13: istore_1
    //   14: iload_1
    //   15: ifle +9 -> 24
    //   18: iconst_1
    //   19: istore_2
    //   20: aload_0
    //   21: monitorexit
    //   22: iload_2
    //   23: ireturn
    //   24: iconst_0
    //   25: istore_2
    //   26: goto -6 -> 20
    //   29: astore_3
    //   30: aload_0
    //   31: monitorexit
    //   32: aload_3
    //   33: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	34	0	this	arzn
    //   13	2	1	i	int
    //   19	7	2	bool	boolean
    //   29	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	14	29	finally
  }
  
  /* Error */
  public boolean c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 27	arzn:jdField_a_of_type_Aryj	Laryj;
    //   6: ifnull +19 -> 25
    //   9: aload_0
    //   10: getfield 24	arzn:jdField_a_of_type_Int	I
    //   13: istore_1
    //   14: iload_1
    //   15: iconst_m1
    //   16: if_icmpgt +9 -> 25
    //   19: iconst_1
    //   20: istore_2
    //   21: aload_0
    //   22: monitorexit
    //   23: iload_2
    //   24: ireturn
    //   25: iconst_0
    //   26: istore_2
    //   27: goto -6 -> 21
    //   30: astore_3
    //   31: aload_0
    //   32: monitorexit
    //   33: aload_3
    //   34: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	35	0	this	arzn
    //   13	4	1	i	int
    //   20	7	2	bool	boolean
    //   30	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	14	30	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arzn
 * JD-Core Version:    0.7.0.1
 */