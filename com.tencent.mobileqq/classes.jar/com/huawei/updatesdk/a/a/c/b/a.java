package com.huawei.updatesdk.a.a.c.b;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.huawei.updatesdk.a.a.c.b.a.b;

public class a
{
  private static final Uri a = Uri.parse("content://telephony/carriers/preferapn");
  private static final Uri b = Uri.parse("content://telephony/carriers/preferapn/0");
  private static final Uri c = Uri.parse("content://telephony/carriers/preferapn/1");
  
  /* Error */
  public static a.a a(Context paramContext)
  {
    // Byte code:
    //   0: new 36	com/huawei/updatesdk/a/a/c/b/a$a
    //   3: dup
    //   4: invokespecial 39	com/huawei/updatesdk/a/a/c/b/a$a:<init>	()V
    //   7: astore_2
    //   8: invokestatic 44	com/huawei/updatesdk/a/a/c/b/a/b:b	()Z
    //   11: ifeq +24 -> 35
    //   14: aload_0
    //   15: invokestatic 48	com/huawei/updatesdk/a/a/c/b/a:d	(Landroid/content/Context;)Landroid/database/Cursor;
    //   18: astore_0
    //   19: aload_0
    //   20: ifnonnull +23 -> 43
    //   23: aload_0
    //   24: ifnull +9 -> 33
    //   27: aload_0
    //   28: invokeinterface 53 1 0
    //   33: aconst_null
    //   34: areturn
    //   35: aload_0
    //   36: invokestatic 55	com/huawei/updatesdk/a/a/c/b/a:c	(Landroid/content/Context;)Landroid/database/Cursor;
    //   39: astore_0
    //   40: goto -21 -> 19
    //   43: aload_0
    //   44: invokeinterface 58 1 0
    //   49: ifeq +90 -> 139
    //   52: aload_2
    //   53: aload_0
    //   54: aload_0
    //   55: ldc 60
    //   57: invokeinterface 64 2 0
    //   62: invokeinterface 68 2 0
    //   67: invokevirtual 71	com/huawei/updatesdk/a/a/c/b/a$a:a	(Ljava/lang/String;)V
    //   70: aload_2
    //   71: aload_0
    //   72: aload_0
    //   73: ldc 73
    //   75: invokeinterface 64 2 0
    //   80: invokeinterface 68 2 0
    //   85: invokevirtual 75	com/huawei/updatesdk/a/a/c/b/a$a:c	(Ljava/lang/String;)V
    //   88: aload_2
    //   89: aload_0
    //   90: aload_0
    //   91: ldc 77
    //   93: invokeinterface 64 2 0
    //   98: invokeinterface 68 2 0
    //   103: invokestatic 83	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   106: invokevirtual 89	java/lang/String:toLowerCase	(Ljava/util/Locale;)Ljava/lang/String;
    //   109: invokevirtual 91	com/huawei/updatesdk/a/a/c/b/a$a:b	(Ljava/lang/String;)V
    //   112: goto -69 -> 43
    //   115: astore_1
    //   116: ldc 93
    //   118: ldc 95
    //   120: aload_1
    //   121: invokestatic 100	com/huawei/updatesdk/a/a/b/a/a/a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   124: aload_1
    //   125: athrow
    //   126: astore_1
    //   127: aload_0
    //   128: ifnull +9 -> 137
    //   131: aload_0
    //   132: invokeinterface 53 1 0
    //   137: aload_1
    //   138: athrow
    //   139: aload_0
    //   140: ifnull +9 -> 149
    //   143: aload_0
    //   144: invokeinterface 53 1 0
    //   149: aload_2
    //   150: invokevirtual 103	com/huawei/updatesdk/a/a/c/b/a$a:a	()Ljava/lang/String;
    //   153: ifnull -120 -> 33
    //   156: aload_2
    //   157: areturn
    //   158: astore_1
    //   159: aconst_null
    //   160: astore_0
    //   161: ldc 93
    //   163: ldc 105
    //   165: aload_1
    //   166: invokestatic 100	com/huawei/updatesdk/a/a/b/a/a/a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   169: aload_0
    //   170: ifnull -21 -> 149
    //   173: aload_0
    //   174: invokeinterface 53 1 0
    //   179: goto -30 -> 149
    //   182: astore_1
    //   183: aconst_null
    //   184: astore_0
    //   185: goto -58 -> 127
    //   188: astore_1
    //   189: goto -62 -> 127
    //   192: astore_1
    //   193: goto -66 -> 127
    //   196: astore_1
    //   197: goto -36 -> 161
    //   200: astore_1
    //   201: aconst_null
    //   202: astore_0
    //   203: goto -87 -> 116
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	206	0	paramContext	Context
    //   115	10	1	localSecurityException1	SecurityException
    //   126	12	1	localObject1	Object
    //   158	8	1	localException1	java.lang.Exception
    //   182	1	1	localObject2	Object
    //   188	1	1	localObject3	Object
    //   192	1	1	localObject4	Object
    //   196	1	1	localException2	java.lang.Exception
    //   200	1	1	localSecurityException2	SecurityException
    //   7	150	2	locala	a.a
    // Exception table:
    //   from	to	target	type
    //   43	112	115	java/lang/SecurityException
    //   116	126	126	finally
    //   8	19	158	java/lang/Exception
    //   35	40	158	java/lang/Exception
    //   8	19	182	finally
    //   35	40	182	finally
    //   43	112	188	finally
    //   161	169	192	finally
    //   43	112	196	java/lang/Exception
    //   8	19	200	java/lang/SecurityException
    //   35	40	200	java/lang/SecurityException
  }
  
  public static boolean b(Context paramContext)
  {
    boolean bool2 = false;
    try
    {
      paramContext = a(paramContext);
      boolean bool1;
      if (paramContext != null)
      {
        bool1 = bool2;
        if (paramContext.b() != null)
        {
          boolean bool3 = paramContext.b().contains("wap");
          bool1 = bool2;
          if (!bool3) {}
        }
      }
      else
      {
        bool1 = true;
      }
      return bool1;
    }
    catch (SecurityException paramContext)
    {
      com.huawei.updatesdk.a.a.b.a.a.a.a("ApnUtil", "isWap(), SecurityException: ", paramContext);
    }
    return false;
  }
  
  private static Cursor c(Context paramContext)
  {
    return paramContext.getContentResolver().query(a, null, null, null, null);
  }
  
  private static Cursor d(Context paramContext)
  {
    Object localObject2;
    Object localObject1;
    if (b.a().a() == 0)
    {
      localObject2 = f(paramContext);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = e(paramContext);
      }
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = c(paramContext);
      }
      return localObject2;
      localObject2 = e(paramContext);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = f(paramContext);
      }
    }
  }
  
  private static Cursor e(Context paramContext)
  {
    return paramContext.getContentResolver().query(c, null, null, null, null);
  }
  
  private static Cursor f(Context paramContext)
  {
    return paramContext.getContentResolver().query(b, null, null, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.updatesdk.a.a.c.b.a
 * JD-Core Version:    0.7.0.1
 */