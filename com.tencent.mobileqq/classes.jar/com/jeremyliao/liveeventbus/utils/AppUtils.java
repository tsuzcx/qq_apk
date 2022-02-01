package com.jeremyliao.liveeventbus.utils;

import android.annotation.SuppressLint;
import android.app.Application;

public final class AppUtils
{
  @SuppressLint({"StaticFieldLeak"})
  private static volatile Application sApplication;
  
  /* Error */
  public static Application getApplicationContext()
  {
    // Byte code:
    //   0: getstatic 20	com/jeremyliao/liveeventbus/utils/AppUtils:sApplication	Landroid/app/Application;
    //   3: ifnonnull +45 -> 48
    //   6: ldc 2
    //   8: monitorenter
    //   9: getstatic 20	com/jeremyliao/liveeventbus/utils/AppUtils:sApplication	Landroid/app/Application;
    //   12: astore_0
    //   13: aload_0
    //   14: ifnonnull +31 -> 45
    //   17: ldc 22
    //   19: invokestatic 28	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   22: ldc 30
    //   24: iconst_0
    //   25: anewarray 24	java/lang/Class
    //   28: invokevirtual 34	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   31: aconst_null
    //   32: aconst_null
    //   33: checkcast 36	[Ljava/lang/Object;
    //   36: invokevirtual 42	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   39: checkcast 44	android/app/Application
    //   42: putstatic 20	com/jeremyliao/liveeventbus/utils/AppUtils:sApplication	Landroid/app/Application;
    //   45: ldc 2
    //   47: monitorexit
    //   48: getstatic 20	com/jeremyliao/liveeventbus/utils/AppUtils:sApplication	Landroid/app/Application;
    //   51: areturn
    //   52: astore_0
    //   53: aload_0
    //   54: invokevirtual 47	java/lang/Exception:printStackTrace	()V
    //   57: goto -12 -> 45
    //   60: astore_0
    //   61: ldc 2
    //   63: monitorexit
    //   64: aload_0
    //   65: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   12	2	0	localApplication	Application
    //   52	2	0	localException	java.lang.Exception
    //   60	5	0	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   17	45	52	java/lang/Exception
    //   9	13	60	finally
    //   17	45	60	finally
    //   45	48	60	finally
    //   53	57	60	finally
    //   61	64	60	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.jeremyliao.liveeventbus.utils.AppUtils
 * JD-Core Version:    0.7.0.1
 */