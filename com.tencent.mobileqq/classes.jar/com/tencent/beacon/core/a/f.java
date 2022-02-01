package com.tencent.beacon.core.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Base64;
import com.tencent.beacon.core.e.d;
import java.nio.charset.Charset;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class f
{
  private static f a;
  private static byte[] b = { 33, 94, 120, 74, 111, 43, 35 };
  private SharedPreferences c;
  private SharedPreferences.Editor d;
  private Lock e = new ReentrantLock();
  private Runnable f = new e(this);
  
  public f(Context paramContext)
  {
    if (paramContext != null) {
      this.c = paramContext.getSharedPreferences("DENGTA_META", 0);
    }
  }
  
  public static f a(Context paramContext)
  {
    try
    {
      if (a == null) {
        a = new f(paramContext);
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
  
  private static String a(String paramString)
  {
    int i = 0;
    paramString = Base64.decode(paramString, 2);
    int j = 0;
    while (i < paramString.length)
    {
      int k = paramString[i];
      byte[] arrayOfByte = b;
      paramString[i] = ((byte)(k ^ arrayOfByte[j]));
      j = (j + 1) % arrayOfByte.length;
      i += 1;
    }
    return new String(paramString, Charset.defaultCharset());
  }
  
  private static String b(String paramString)
  {
    int i = 0;
    paramString = paramString.getBytes(Charset.defaultCharset());
    int j = 0;
    while (i < paramString.length)
    {
      int k = paramString[i];
      byte[] arrayOfByte = b;
      paramString[i] = ((byte)(k ^ arrayOfByte[j]));
      j = (j + 1) % arrayOfByte.length;
      i += 1;
    }
    return Base64.encodeToString(paramString, 2);
  }
  
  private void d()
  {
    try
    {
      if (this.e.tryLock())
      {
        this.d.commit();
        this.e.unlock();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int a(String paramString, int paramInt)
  {
    try
    {
      paramInt = this.c.getInt(paramString, paramInt);
      return paramInt;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public long a(String paramString, long paramLong)
  {
    try
    {
      paramLong = this.c.getLong(paramString, paramLong);
      return paramLong;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public f a(String paramString, Object paramObject)
  {
    for (;;)
    {
      SharedPreferences.Editor localEditor;
      try
      {
        if (this.c != null)
        {
          localEditor = this.d;
          if (localEditor != null) {}
        }
        else
        {
          d.b("[sp] create failed or edit() has not called.", new Object[0]);
          return this;
        }
        if ((paramObject instanceof String)) {
          localEditor.putString(paramString, (String)paramObject);
        } else if ((paramObject instanceof Boolean)) {
          localEditor.putBoolean(paramString, ((Boolean)paramObject).booleanValue());
        }
      }
      finally {}
      if ((paramObject instanceof Integer)) {
        localEditor.putInt(paramString, ((Integer)paramObject).intValue());
      } else if ((paramObject instanceof Long)) {
        localEditor.putLong(paramString, ((Long)paramObject).longValue());
      }
    }
  }
  
  public String a(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = this.c.getString(paramString1, paramString2);
      return paramString1;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  /* Error */
  public String a(String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 47	com/tencent/beacon/core/a/f:c	Landroid/content/SharedPreferences;
    //   6: astore 5
    //   8: aload 5
    //   10: aload_1
    //   11: ldc 154
    //   13: invokeinterface 151 3 0
    //   18: astore 4
    //   20: aload 4
    //   22: ifnull +55 -> 77
    //   25: aload 4
    //   27: invokevirtual 158	java/lang/String:trim	()Ljava/lang/String;
    //   30: ldc 154
    //   32: invokevirtual 162	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   35: ifne +42 -> 77
    //   38: aload 4
    //   40: invokestatic 164	com/tencent/beacon/core/a/f:b	(Ljava/lang/String;)Ljava/lang/String;
    //   43: astore_3
    //   44: aload 5
    //   46: invokeinterface 168 1 0
    //   51: aload_1
    //   52: invokeinterface 172 2 0
    //   57: aload_2
    //   58: aload_3
    //   59: invokeinterface 118 3 0
    //   64: invokeinterface 93 1 0
    //   69: pop
    //   70: aload 4
    //   72: astore_1
    //   73: aload_0
    //   74: monitorexit
    //   75: aload_1
    //   76: areturn
    //   77: aload 5
    //   79: aload_2
    //   80: ldc 154
    //   82: invokeinterface 151 3 0
    //   87: astore_2
    //   88: aload_3
    //   89: astore_1
    //   90: aload_2
    //   91: ifnull -18 -> 73
    //   94: aload_3
    //   95: astore_1
    //   96: aload_2
    //   97: invokevirtual 158	java/lang/String:trim	()Ljava/lang/String;
    //   100: ldc 154
    //   102: invokevirtual 162	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   105: ifne -32 -> 73
    //   108: aload_2
    //   109: invokestatic 174	com/tencent/beacon/core/a/f:a	(Ljava/lang/String;)Ljava/lang/String;
    //   112: astore_1
    //   113: goto -40 -> 73
    //   116: astore_1
    //   117: aload_0
    //   118: monitorexit
    //   119: aload_1
    //   120: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	121	0	this	f
    //   0	121	1	paramString1	String
    //   0	121	2	paramString2	String
    //   0	121	3	paramString3	String
    //   18	53	4	str	String
    //   6	72	5	localSharedPreferences	SharedPreferences
    // Exception table:
    //   from	to	target	type
    //   2	20	116	finally
    //   25	70	116	finally
    //   77	88	116	finally
    //   96	113	116	finally
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 47	com/tencent/beacon/core/a/f:c	Landroid/content/SharedPreferences;
    //   6: ifnull +29 -> 35
    //   9: aload_0
    //   10: getfield 88	com/tencent/beacon/core/a/f:d	Landroid/content/SharedPreferences$Editor;
    //   13: ifnull +22 -> 35
    //   16: invokestatic 180	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   19: invokestatic 183	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   22: if_acmpne +16 -> 38
    //   25: invokestatic 188	com/tencent/beacon/core/a/d:a	()Lcom/tencent/beacon/core/a/d;
    //   28: aload_0
    //   29: getfield 37	com/tencent/beacon/core/a/f:f	Ljava/lang/Runnable;
    //   32: invokevirtual 191	com/tencent/beacon/core/a/d:a	(Ljava/lang/Runnable;)V
    //   35: aload_0
    //   36: monitorexit
    //   37: return
    //   38: aload_0
    //   39: invokespecial 72	com/tencent/beacon/core/a/f:d	()V
    //   42: goto -7 -> 35
    //   45: astore_1
    //   46: aload_0
    //   47: monitorexit
    //   48: aload_1
    //   49: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	50	0	this	f
    //   45	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	35	45	finally
    //   38	42	45	finally
  }
  
  public f b()
  {
    try
    {
      SharedPreferences localSharedPreferences = this.c;
      if ((localSharedPreferences != null) && (this.d == null)) {
        this.d = localSharedPreferences.edit();
      }
      return this;
    }
    finally {}
  }
  
  /* Error */
  public f b(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 47	com/tencent/beacon/core/a/f:c	Landroid/content/SharedPreferences;
    //   6: ifnull +10 -> 16
    //   9: aload_0
    //   10: getfield 88	com/tencent/beacon/core/a/f:d	Landroid/content/SharedPreferences$Editor;
    //   13: ifnonnull +16 -> 29
    //   16: ldc 109
    //   18: iconst_0
    //   19: anewarray 4	java/lang/Object
    //   22: invokestatic 114	com/tencent/beacon/core/e/d:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   25: aload_0
    //   26: monitorexit
    //   27: aload_0
    //   28: areturn
    //   29: aload_2
    //   30: invokestatic 164	com/tencent/beacon/core/a/f:b	(Ljava/lang/String;)Ljava/lang/String;
    //   33: astore_2
    //   34: aload_0
    //   35: getfield 88	com/tencent/beacon/core/a/f:d	Landroid/content/SharedPreferences$Editor;
    //   38: aload_1
    //   39: aload_2
    //   40: invokeinterface 118 3 0
    //   45: pop
    //   46: goto -21 -> 25
    //   49: astore_1
    //   50: aload_0
    //   51: monitorexit
    //   52: aload_1
    //   53: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	54	0	this	f
    //   0	54	1	paramString1	String
    //   0	54	2	paramString2	String
    // Exception table:
    //   from	to	target	type
    //   2	16	49	finally
    //   16	25	49	finally
    //   29	46	49	finally
  }
  
  public SharedPreferences c()
  {
    try
    {
      SharedPreferences localSharedPreferences = this.c;
      return localSharedPreferences;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.a.f
 * JD-Core Version:    0.7.0.1
 */