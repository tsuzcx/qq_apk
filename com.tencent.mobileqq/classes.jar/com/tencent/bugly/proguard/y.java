package com.tencent.bugly.proguard;

import android.content.Context;
import android.os.Process;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;

public final class y
{
  public static boolean a = true;
  private static boolean b = true;
  private static SimpleDateFormat c;
  private static int d = 30720;
  private static StringBuilder e;
  private static StringBuilder f;
  private static boolean g = false;
  private static y.a h;
  private static String i;
  private static String j;
  private static Context k;
  private static String l;
  private static boolean m = false;
  private static boolean n = false;
  private static ExecutorService o;
  private static int p;
  private static final Object q = new Object();
  
  static
  {
    try
    {
      c = new SimpleDateFormat("MM-dd HH:mm:ss");
      return;
    }
    catch (Throwable localThrowable)
    {
      x.b(localThrowable.getCause());
    }
  }
  
  private static String a(String paramString1, String paramString2, String paramString3, long paramLong)
  {
    e.setLength(0);
    String str = paramString3;
    if (paramString3.length() > 30720) {
      str = paramString3.substring(paramString3.length() - 30720, paramString3.length() - 1);
    }
    paramString3 = new Date();
    Object localObject = c;
    if (localObject != null) {
      paramString3 = ((SimpleDateFormat)localObject).format(paramString3);
    } else {
      paramString3 = paramString3.toString();
    }
    localObject = e;
    ((StringBuilder)localObject).append(paramString3);
    ((StringBuilder)localObject).append(" ");
    ((StringBuilder)localObject).append(p);
    ((StringBuilder)localObject).append(" ");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append(" ");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(" ");
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append(": ");
    ((StringBuilder)localObject).append(str);
    ((StringBuilder)localObject).append("\001\r\n");
    return e.toString();
  }
  
  public static void a(int paramInt)
  {
    synchronized (q)
    {
      d = paramInt;
      if (paramInt < 0) {
        d = 0;
      } else if (paramInt > 30720) {
        d = 30720;
      }
      return;
    }
  }
  
  /* Error */
  public static void a(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 115	com/tencent/bugly/proguard/y:m	Z
    //   6: ifne +152 -> 158
    //   9: aload_0
    //   10: ifnull +148 -> 158
    //   13: getstatic 117	com/tencent/bugly/proguard/y:a	Z
    //   16: istore_1
    //   17: iload_1
    //   18: ifne +6 -> 24
    //   21: goto +137 -> 158
    //   24: invokestatic 123	java/util/concurrent/Executors:newSingleThreadExecutor	()Ljava/util/concurrent/ExecutorService;
    //   27: putstatic 125	com/tencent/bugly/proguard/y:o	Ljava/util/concurrent/ExecutorService;
    //   30: new 66	java/lang/StringBuilder
    //   33: dup
    //   34: iconst_0
    //   35: invokespecial 127	java/lang/StringBuilder:<init>	(I)V
    //   38: putstatic 129	com/tencent/bugly/proguard/y:f	Ljava/lang/StringBuilder;
    //   41: new 66	java/lang/StringBuilder
    //   44: dup
    //   45: iconst_0
    //   46: invokespecial 127	java/lang/StringBuilder:<init>	(I)V
    //   49: putstatic 64	com/tencent/bugly/proguard/y:e	Ljava/lang/StringBuilder;
    //   52: aload_0
    //   53: putstatic 131	com/tencent/bugly/proguard/y:k	Landroid/content/Context;
    //   56: aload_0
    //   57: invokestatic 136	com/tencent/bugly/crashreport/common/info/a:a	(Landroid/content/Context;)Lcom/tencent/bugly/crashreport/common/info/a;
    //   60: astore_0
    //   61: aload_0
    //   62: getfield 138	com/tencent/bugly/crashreport/common/info/a:d	Ljava/lang/String;
    //   65: putstatic 140	com/tencent/bugly/proguard/y:i	Ljava/lang/String;
    //   68: aload_0
    //   69: invokevirtual 144	java/lang/Object:getClass	()Ljava/lang/Class;
    //   72: pop
    //   73: ldc 146
    //   75: putstatic 148	com/tencent/bugly/proguard/y:j	Ljava/lang/String;
    //   78: new 66	java/lang/StringBuilder
    //   81: dup
    //   82: invokespecial 149	java/lang/StringBuilder:<init>	()V
    //   85: astore_0
    //   86: aload_0
    //   87: getstatic 131	com/tencent/bugly/proguard/y:k	Landroid/content/Context;
    //   90: invokevirtual 155	android/content/Context:getFilesDir	()Ljava/io/File;
    //   93: invokevirtual 160	java/io/File:getPath	()Ljava/lang/String;
    //   96: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: pop
    //   100: aload_0
    //   101: ldc 162
    //   103: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: pop
    //   107: aload_0
    //   108: getstatic 140	com/tencent/bugly/proguard/y:i	Ljava/lang/String;
    //   111: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: pop
    //   115: aload_0
    //   116: ldc 164
    //   118: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: pop
    //   122: aload_0
    //   123: getstatic 148	com/tencent/bugly/proguard/y:j	Ljava/lang/String;
    //   126: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: pop
    //   130: aload_0
    //   131: ldc 166
    //   133: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: pop
    //   137: aload_0
    //   138: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   141: putstatic 168	com/tencent/bugly/proguard/y:l	Ljava/lang/String;
    //   144: invokestatic 173	android/os/Process:myPid	()I
    //   147: putstatic 99	com/tencent/bugly/proguard/y:p	I
    //   150: iconst_1
    //   151: putstatic 115	com/tencent/bugly/proguard/y:m	Z
    //   154: ldc 2
    //   156: monitorexit
    //   157: return
    //   158: ldc 2
    //   160: monitorexit
    //   161: return
    //   162: astore_0
    //   163: ldc 2
    //   165: monitorexit
    //   166: aload_0
    //   167: athrow
    //   168: astore_0
    //   169: goto -19 -> 150
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	172	0	paramContext	Context
    //   16	2	1	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   3	9	162	finally
    //   13	17	162	finally
    //   24	150	162	finally
    //   150	154	162	finally
    //   24	150	168	java/lang/Throwable
  }
  
  public static void a(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      if (m)
      {
        boolean bool = a;
        if (bool) {
          try
          {
            o.execute(new y.1(paramString1, paramString2, paramString3));
            return;
          }
          catch (Exception paramString1)
          {
            x.b(paramString1);
            return;
          }
        }
      }
      return;
    }
    finally {}
  }
  
  public static void a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (paramThrowable == null) {
      return;
    }
    Object localObject2 = paramThrowable.getMessage();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append('\n');
    ((StringBuilder)localObject2).append(z.b(paramThrowable));
    a(paramString1, paramString2, ((StringBuilder)localObject2).toString());
  }
  
  public static byte[] a()
  {
    if (b)
    {
      if (!a) {
        return null;
      }
      return z.a(null, f.toString(), "BuglyLog.txt");
    }
    return b();
  }
  
  private static byte[] b()
  {
    if (!a) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    synchronized (q)
    {
      if ((h != null) && (y.a.d(h)) && (y.a.a(h) != null) && (y.a.a(h).length() > 0L)) {
        localStringBuilder.append(z.a(y.a.a(h), 30720, true));
      }
      if ((f != null) && (f.length() > 0)) {
        localStringBuilder.append(f.toString());
      }
      return z.a(null, localStringBuilder.toString(), "BuglyLog.txt");
    }
  }
  
  private static void c(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      if (b)
      {
        d(paramString1, paramString2, paramString3);
        return;
      }
      e(paramString1, paramString2, paramString3);
      return;
    }
    finally {}
  }
  
  private static void d(String arg0, String paramString2, String paramString3)
  {
    try
    {
      paramString2 = a(???, paramString2, paramString3, Process.myTid());
      try
      {
        synchronized (q)
        {
          f.append(paramString2);
          if (f.length() >= d) {
            f = f.delete(0, f.indexOf("\001\r\n") + 1);
          }
        }
      }
      catch (Throwable paramString2)
      {
        if (!x.b(paramString2)) {
          paramString2.printStackTrace();
        }
        return;
      }
      throw paramString2;
    }
    finally {}
  }
  
  private static void e(String arg0, String paramString2, String paramString3)
  {
    int i1;
    int i2;
    boolean bool;
    label170:
    try
    {
      paramString2 = a(???, paramString2, paramString3, Process.myTid());
    }
    finally {}
    try
    {
      synchronized (q)
      {
        f.append(paramString2);
        i1 = f.length();
        i2 = d;
        if (i1 <= i2) {
          return;
        }
        bool = g;
        if (bool) {
          return;
        }
        g = true;
        if (h == null) {
          h = new y.a(l);
        } else if ((y.a.a(h) == null) || (y.a.a(h).length() + f.length() > y.a.b(h))) {
          y.a.c(h);
        }
        if (h.a(f.toString()))
        {
          f.setLength(0);
          g = false;
        }
      }
    }
    catch (Throwable paramString2)
    {
      break label170;
    }
    return;
    throw paramString2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.bugly.proguard.y
 * JD-Core Version:    0.7.0.1
 */