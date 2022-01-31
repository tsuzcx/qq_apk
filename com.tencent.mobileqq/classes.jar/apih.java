import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.util.WeakReference;

public class apih
{
  private Map<Long, aphd> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  private WeakReference<apij> jdField_a_of_type_MqqUtilWeakReference;
  
  public static void a(String paramString1, long paramLong, String paramString2)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    QLog.d("ForwardD55Manager", 1, new Object[] { "fetchAppInfoByD55 openId=", paramString1, ", appId=", Long.valueOf(paramLong), ", pkgName=", paramString2 });
    apmt.a("KEY_STAGE_1_D55");
    MessageHandler localMessageHandler = localQQAppInterface.a();
    if (paramString1 == null) {
      paramString1 = "";
    }
    for (;;)
    {
      localMessageHandler.a(false, paramString1, false, 0L, paramLong, 1, 2, paramString2, true, apmf.a(), new apii(paramString2, localQQAppInterface, paramLong));
      return;
    }
  }
  
  public aphd a(long paramLong)
  {
    try
    {
      QLog.d("ForwardD55Manager", 1, new Object[] { "--> getAppInfo appId=", Long.valueOf(paramLong) });
      aphd localaphd = (aphd)this.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramLong));
      return localaphd;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public String a(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 34
    //   4: iconst_1
    //   5: iconst_2
    //   6: anewarray 4	java/lang/Object
    //   9: dup
    //   10: iconst_0
    //   11: ldc 93
    //   13: aastore
    //   14: dup
    //   15: iconst_1
    //   16: lload_1
    //   17: invokestatic 44	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   20: aastore
    //   21: invokestatic 52	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   24: aload_0
    //   25: getfield 18	apih:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   28: lload_1
    //   29: invokestatic 44	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   32: invokeinterface 88 2 0
    //   37: checkcast 90	aphd
    //   40: astore_3
    //   41: aload_3
    //   42: ifnull +12 -> 54
    //   45: aload_3
    //   46: invokevirtual 97	aphd:f	()Ljava/lang/String;
    //   49: astore_3
    //   50: aload_0
    //   51: monitorexit
    //   52: aload_3
    //   53: areturn
    //   54: ldc 64
    //   56: astore_3
    //   57: goto -7 -> 50
    //   60: astore_3
    //   61: aload_0
    //   62: monitorexit
    //   63: aload_3
    //   64: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	65	0	this	apih
    //   0	65	1	paramLong	long
    //   40	17	3	localObject1	Object
    //   60	4	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	41	60	finally
    //   45	50	60	finally
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
  
  public void a(long paramLong, aphd paramaphd)
  {
    for (;;)
    {
      try
      {
        QLog.d("ForwardD55Manager", 1, new Object[] { "--> onResult appId=", Long.valueOf(paramLong), ", appInfo=", paramaphd.toString() });
        this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(paramLong), paramaphd);
        if (this.jdField_a_of_type_MqqUtilWeakReference != null)
        {
          QLog.d("ForwardD55Manager", 1, "--> onResult null != mListener");
          if (this.jdField_a_of_type_MqqUtilWeakReference.get() != null)
          {
            QLog.d("ForwardD55Manager", 1, "--> onResult null != mListener.get()");
            ((apij)this.jdField_a_of_type_MqqUtilWeakReference.get()).a();
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
  public void a(apij paramapij)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 34
    //   4: iconst_1
    //   5: iconst_2
    //   6: anewarray 4	java/lang/Object
    //   9: dup
    //   10: iconst_0
    //   11: ldc 137
    //   13: aastore
    //   14: dup
    //   15: iconst_1
    //   16: aload_1
    //   17: aastore
    //   18: invokestatic 52	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   21: aload_1
    //   22: ifnonnull +13 -> 35
    //   25: aconst_null
    //   26: astore_1
    //   27: aload_0
    //   28: aload_1
    //   29: putfield 114	apih:jdField_a_of_type_MqqUtilWeakReference	Lmqq/util/WeakReference;
    //   32: aload_0
    //   33: monitorexit
    //   34: return
    //   35: new 121	mqq/util/WeakReference
    //   38: dup
    //   39: aload_1
    //   40: invokespecial 140	mqq/util/WeakReference:<init>	(Ljava/lang/Object;)V
    //   43: astore_1
    //   44: goto -17 -> 27
    //   47: astore_1
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_1
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	52	0	this	apih
    //   0	52	1	paramapij	apij
    // Exception table:
    //   from	to	target	type
    //   2	21	47	finally
    //   27	32	47	finally
    //   35	44	47	finally
  }
  
  /* Error */
  public boolean a(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 34
    //   4: iconst_1
    //   5: iconst_2
    //   6: anewarray 4	java/lang/Object
    //   9: dup
    //   10: iconst_0
    //   11: ldc 143
    //   13: aastore
    //   14: dup
    //   15: iconst_1
    //   16: lload_1
    //   17: invokestatic 44	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   20: aastore
    //   21: invokestatic 52	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   24: aload_0
    //   25: getfield 18	apih:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   28: lload_1
    //   29: invokestatic 44	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   32: invokeinterface 88 2 0
    //   37: checkcast 90	aphd
    //   40: astore 5
    //   42: aload 5
    //   44: ifnull +21 -> 65
    //   47: aload 5
    //   49: invokevirtual 147	aphd:b	()I
    //   52: istore_3
    //   53: iload_3
    //   54: ifne +11 -> 65
    //   57: iconst_1
    //   58: istore 4
    //   60: aload_0
    //   61: monitorexit
    //   62: iload 4
    //   64: ireturn
    //   65: iconst_0
    //   66: istore 4
    //   68: goto -8 -> 60
    //   71: astore 5
    //   73: aload_0
    //   74: monitorexit
    //   75: aload 5
    //   77: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	this	apih
    //   0	78	1	paramLong	long
    //   52	2	3	i	int
    //   58	9	4	bool	boolean
    //   40	8	5	localaphd	aphd
    //   71	5	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	42	71	finally
    //   47	53	71	finally
  }
  
  /* Error */
  public boolean b(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 34
    //   4: iconst_1
    //   5: iconst_2
    //   6: anewarray 4	java/lang/Object
    //   9: dup
    //   10: iconst_0
    //   11: ldc 149
    //   13: aastore
    //   14: dup
    //   15: iconst_1
    //   16: lload_1
    //   17: invokestatic 44	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   20: aastore
    //   21: invokestatic 52	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   24: aload_0
    //   25: getfield 18	apih:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   28: lload_1
    //   29: invokestatic 44	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   32: invokeinterface 88 2 0
    //   37: checkcast 90	aphd
    //   40: astore 5
    //   42: aload 5
    //   44: ifnull +21 -> 65
    //   47: aload 5
    //   49: invokevirtual 147	aphd:b	()I
    //   52: istore_3
    //   53: iload_3
    //   54: ifle +11 -> 65
    //   57: iconst_1
    //   58: istore 4
    //   60: aload_0
    //   61: monitorexit
    //   62: iload 4
    //   64: ireturn
    //   65: iconst_0
    //   66: istore 4
    //   68: goto -8 -> 60
    //   71: astore 5
    //   73: aload_0
    //   74: monitorexit
    //   75: aload 5
    //   77: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	this	apih
    //   0	78	1	paramLong	long
    //   52	2	3	i	int
    //   58	9	4	bool	boolean
    //   40	8	5	localaphd	aphd
    //   71	5	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	42	71	finally
    //   47	53	71	finally
  }
  
  /* Error */
  public boolean c(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 34
    //   4: iconst_1
    //   5: iconst_2
    //   6: anewarray 4	java/lang/Object
    //   9: dup
    //   10: iconst_0
    //   11: ldc 152
    //   13: aastore
    //   14: dup
    //   15: iconst_1
    //   16: lload_1
    //   17: invokestatic 44	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   20: aastore
    //   21: invokestatic 52	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   24: aload_0
    //   25: getfield 18	apih:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   28: lload_1
    //   29: invokestatic 44	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   32: invokeinterface 88 2 0
    //   37: checkcast 90	aphd
    //   40: astore 5
    //   42: aload 5
    //   44: ifnull +22 -> 66
    //   47: aload 5
    //   49: invokevirtual 147	aphd:b	()I
    //   52: istore_3
    //   53: iload_3
    //   54: iconst_m1
    //   55: if_icmpgt +11 -> 66
    //   58: iconst_1
    //   59: istore 4
    //   61: aload_0
    //   62: monitorexit
    //   63: iload 4
    //   65: ireturn
    //   66: iconst_0
    //   67: istore 4
    //   69: goto -8 -> 61
    //   72: astore 5
    //   74: aload_0
    //   75: monitorexit
    //   76: aload 5
    //   78: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	79	0	this	apih
    //   0	79	1	paramLong	long
    //   52	4	3	i	int
    //   59	9	4	bool	boolean
    //   40	8	5	localaphd	aphd
    //   72	5	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	42	72	finally
    //   47	53	72	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apih
 * JD-Core Version:    0.7.0.1
 */