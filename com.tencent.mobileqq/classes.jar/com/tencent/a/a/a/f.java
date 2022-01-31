package com.tencent.a.a.a;

import android.content.Context;
import android.provider.Settings.System;

public class f
  extends g
{
  public f(Context paramContext)
  {
    super(paramContext);
  }
  
  /* Error */
  protected void a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 15
    //   4: invokestatic 19	com/tencent/a/a/a/i:a	(Ljava/lang/String;)V
    //   7: aload_0
    //   8: getfield 22	com/tencent/a/a/a/f:a	Landroid/content/Context;
    //   11: invokevirtual 28	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   14: aload_0
    //   15: invokevirtual 32	com/tencent/a/a/a/f:f	()Ljava/lang/String;
    //   18: aload_1
    //   19: invokestatic 38	android/provider/Settings$System:putString	(Landroid/content/ContentResolver;Ljava/lang/String;Ljava/lang/String;)Z
    //   22: pop
    //   23: aload_0
    //   24: monitorexit
    //   25: return
    //   26: astore_1
    //   27: aload_1
    //   28: invokestatic 41	com/tencent/a/a/a/i:a	(Ljava/lang/Throwable;)V
    //   31: goto -8 -> 23
    //   34: astore_1
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_1
    //   38: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	39	0	this	f
    //   0	39	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   7	23	26	java/lang/Throwable
    //   2	7	34	finally
    //   7	23	34	finally
    //   23	25	34	finally
    //   27	31	34	finally
    //   35	37	34	finally
  }
  
  protected boolean a()
  {
    return i.a(this.a, "android.permission.WRITE_SETTINGS");
  }
  
  protected String b()
  {
    try
    {
      i.a("read mid from Settings.System");
      String str = Settings.System.getString(this.a.getContentResolver(), f());
      return str;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.a.a.a.f
 * JD-Core Version:    0.7.0.1
 */