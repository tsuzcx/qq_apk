package com.tencent.beacon.qimei;

import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.beacon.core.BeaconIdJNI;
import com.tencent.beacon.core.e.j;
import com.tencent.beacon.core.info.b;

public class QimeiSDK
{
  private static volatile QimeiSDK instance;
  private String beaconId = "";
  private Context mContext;
  private IAsyncQimeiListener mListener;
  
  public static QimeiSDK getInstance()
  {
    if (instance == null) {}
    try
    {
      if (instance == null) {
        instance = new QimeiSDK();
      }
      return instance;
    }
    finally {}
  }
  
  /* Error */
  private boolean isInit()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 25	com/tencent/beacon/qimei/QimeiSDK:mContext	Landroid/content/Context;
    //   8: astore_2
    //   9: aload_2
    //   10: ifnull +9 -> 19
    //   13: iconst_1
    //   14: istore_1
    //   15: aload_0
    //   16: monitorexit
    //   17: iload_1
    //   18: ireturn
    //   19: ldc 42
    //   21: iconst_0
    //   22: anewarray 4	java/lang/Object
    //   25: invokestatic 48	com/tencent/beacon/core/e/d:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   28: goto -13 -> 15
    //   31: astore_2
    //   32: aload_0
    //   33: monitorexit
    //   34: aload_2
    //   35: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	36	0	this	QimeiSDK
    //   1	17	1	bool	boolean
    //   8	2	2	localContext	Context
    //   31	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	9	31	finally
    //   19	28	31	finally
  }
  
  public String getAppKey()
  {
    try
    {
      String str = b.b(this.mContext).a();
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  @Deprecated
  public String getBeaconIdInfo(Context paramContext)
  {
    try
    {
      if (j.c(this.beaconId)) {
        this.beaconId = BeaconIdJNI.a(paramContext, Build.VERSION.SDK_INT);
      }
      paramContext = this.beaconId;
      return paramContext;
    }
    finally {}
  }
  
  /* Error */
  public Qimei getQimei(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 31	com/tencent/beacon/qimei/QimeiSDK:isInit	()Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifne +13 -> 21
    //   11: aload_1
    //   12: ifnonnull +9 -> 21
    //   15: aconst_null
    //   16: astore_1
    //   17: aload_0
    //   18: monitorexit
    //   19: aload_1
    //   20: areturn
    //   21: aload_1
    //   22: invokestatic 87	com/tencent/beacon/qimei/a:a	(Landroid/content/Context;)Lcom/tencent/beacon/qimei/a;
    //   25: invokevirtual 90	com/tencent/beacon/qimei/a:b	()Lcom/tencent/beacon/qimei/Qimei;
    //   28: astore_1
    //   29: goto -12 -> 17
    //   32: astore_1
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_1
    //   36: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	37	0	this	QimeiSDK
    //   0	37	1	paramContext	Context
    //   6	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	7	32	finally
    //   21	29	32	finally
  }
  
  public void getQimei(IAsyncQimeiListener paramIAsyncQimeiListener)
  {
    try
    {
      com.tencent.beacon.core.a.d.a().a(new f(this, paramIAsyncQimeiListener));
      return;
    }
    finally
    {
      paramIAsyncQimeiListener = finally;
      throw paramIAsyncQimeiListener;
    }
  }
  
  /* Error */
  public String getQimeiByKey(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 31	com/tencent/beacon/qimei/QimeiSDK:isInit	()Z
    //   6: ifne +14 -> 20
    //   9: aload_1
    //   10: ifnonnull +10 -> 20
    //   13: ldc 18
    //   15: astore_1
    //   16: aload_0
    //   17: monitorexit
    //   18: aload_1
    //   19: areturn
    //   20: aload_2
    //   21: invokestatic 68	com/tencent/beacon/core/e/j:c	(Ljava/lang/String;)Z
    //   24: ifeq +9 -> 33
    //   27: ldc 18
    //   29: astore_1
    //   30: goto -14 -> 16
    //   33: aload_1
    //   34: invokestatic 87	com/tencent/beacon/qimei/a:a	(Landroid/content/Context;)Lcom/tencent/beacon/qimei/a;
    //   37: invokevirtual 90	com/tencent/beacon/qimei/a:b	()Lcom/tencent/beacon/qimei/Qimei;
    //   40: invokevirtual 112	com/tencent/beacon/qimei/Qimei:getQimeiMap	()Ljava/util/Map;
    //   43: astore_1
    //   44: aload_1
    //   45: ifnull +17 -> 62
    //   48: aload_1
    //   49: aload_2
    //   50: invokeinterface 118 2 0
    //   55: checkcast 120	java/lang/String
    //   58: astore_1
    //   59: goto -43 -> 16
    //   62: ldc 18
    //   64: astore_1
    //   65: goto -49 -> 16
    //   68: astore_1
    //   69: aload_0
    //   70: monitorexit
    //   71: aload_1
    //   72: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	this	QimeiSDK
    //   0	73	1	paramContext	Context
    //   0	73	2	paramString	String
    // Exception table:
    //   from	to	target	type
    //   2	9	68	finally
    //   20	27	68	finally
    //   33	44	68	finally
    //   48	59	68	finally
  }
  
  /* Error */
  @Deprecated
  public String getQimeiInternal(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 31	com/tencent/beacon/qimei/QimeiSDK:isInit	()Z
    //   6: ifne +14 -> 20
    //   9: aload_1
    //   10: ifnonnull +10 -> 20
    //   13: ldc 18
    //   15: astore_1
    //   16: aload_0
    //   17: monitorexit
    //   18: aload_1
    //   19: areturn
    //   20: aload_1
    //   21: invokestatic 87	com/tencent/beacon/qimei/a:a	(Landroid/content/Context;)Lcom/tencent/beacon/qimei/a;
    //   24: invokevirtual 90	com/tencent/beacon/qimei/a:b	()Lcom/tencent/beacon/qimei/Qimei;
    //   27: astore_1
    //   28: aload_1
    //   29: invokevirtual 124	com/tencent/beacon/qimei/Qimei:getQimeiOld	()Ljava/lang/String;
    //   32: invokestatic 68	com/tencent/beacon/core/e/j:c	(Ljava/lang/String;)Z
    //   35: ifne +11 -> 46
    //   38: aload_1
    //   39: invokevirtual 124	com/tencent/beacon/qimei/Qimei:getQimeiOld	()Ljava/lang/String;
    //   42: astore_1
    //   43: goto -27 -> 16
    //   46: ldc 18
    //   48: astore_1
    //   49: goto -33 -> 16
    //   52: astore_1
    //   53: aload_0
    //   54: monitorexit
    //   55: aload_1
    //   56: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	57	0	this	QimeiSDK
    //   0	57	1	paramContext	Context
    // Exception table:
    //   from	to	target	type
    //   2	9	52	finally
    //   20	43	52	finally
  }
  
  /* Error */
  public String getQimeiNew(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 31	com/tencent/beacon/qimei/QimeiSDK:isInit	()Z
    //   6: ifne +14 -> 20
    //   9: aload_1
    //   10: ifnonnull +10 -> 20
    //   13: ldc 18
    //   15: astore_1
    //   16: aload_0
    //   17: monitorexit
    //   18: aload_1
    //   19: areturn
    //   20: aload_1
    //   21: invokestatic 87	com/tencent/beacon/qimei/a:a	(Landroid/content/Context;)Lcom/tencent/beacon/qimei/a;
    //   24: invokevirtual 90	com/tencent/beacon/qimei/a:b	()Lcom/tencent/beacon/qimei/Qimei;
    //   27: invokevirtual 127	com/tencent/beacon/qimei/Qimei:getQimeiNew	()Ljava/lang/String;
    //   30: astore_2
    //   31: aload_2
    //   32: astore_1
    //   33: aload_2
    //   34: invokestatic 68	com/tencent/beacon/core/e/j:c	(Ljava/lang/String;)Z
    //   37: ifeq -21 -> 16
    //   40: ldc 18
    //   42: astore_1
    //   43: goto -27 -> 16
    //   46: astore_1
    //   47: aload_0
    //   48: monitorexit
    //   49: aload_1
    //   50: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	51	0	this	QimeiSDK
    //   0	51	1	paramContext	Context
    //   30	4	2	str	String
    // Exception table:
    //   from	to	target	type
    //   2	9	46	finally
    //   20	31	46	finally
    //   33	40	46	finally
  }
  
  public QimeiSDK init(Context paramContext)
  {
    try
    {
      if (!isInit())
      {
        this.mContext = paramContext;
        e.a(this.mContext).d();
        paramContext = this.mListener;
        if (paramContext != null) {
          getQimei(paramContext);
        }
      }
      return this;
    }
    finally {}
  }
  
  public QimeiSDK setAppKey(String paramString)
  {
    if (!j.c(paramString)) {
      b.b = paramString;
    }
    return this;
  }
  
  public QimeiSDK setLogAble(boolean paramBoolean)
  {
    try
    {
      com.tencent.beacon.core.e.d.b(paramBoolean);
      com.tencent.beacon.core.e.d.c(paramBoolean);
      return this;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public QimeiSDK setOmgId(String paramString)
  {
    if (!j.c(paramString)) {
      com.tencent.beacon.core.info.c.c = paramString;
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.qimei.QimeiSDK
 * JD-Core Version:    0.7.0.1
 */