package com.tencent.bugly.proguard;

import android.content.Context;
import android.os.Process;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class y
{
  public static boolean a;
  private static SimpleDateFormat b = null;
  private static int c;
  private static StringBuilder d;
  private static StringBuilder e;
  private static boolean f;
  private static y.a g;
  private static String h;
  private static String i;
  private static Context j;
  private static String k;
  private static boolean l;
  private static boolean m;
  private static int n;
  private static final Object o;
  
  static
  {
    a = true;
    c = 5120;
    m = false;
    o = new Object();
    try
    {
      b = new SimpleDateFormat("MM-dd HH:mm:ss");
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public static void a(int paramInt)
  {
    synchronized (o)
    {
      c = paramInt;
      if (paramInt < 0) {
        c = 0;
      }
      while (paramInt <= 10240) {
        return;
      }
      c = 10240;
    }
  }
  
  /* Error */
  public static void a(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 59	com/tencent/bugly/proguard/y:l	Z
    //   6: ifne +15 -> 21
    //   9: aload_0
    //   10: ifnull +11 -> 21
    //   13: getstatic 35	com/tencent/bugly/proguard/y:a	Z
    //   16: istore_1
    //   17: iload_1
    //   18: ifne +7 -> 25
    //   21: ldc 2
    //   23: monitorexit
    //   24: return
    //   25: new 61	java/lang/StringBuilder
    //   28: dup
    //   29: iconst_0
    //   30: invokespecial 63	java/lang/StringBuilder:<init>	(I)V
    //   33: putstatic 65	com/tencent/bugly/proguard/y:e	Ljava/lang/StringBuilder;
    //   36: new 61	java/lang/StringBuilder
    //   39: dup
    //   40: iconst_0
    //   41: invokespecial 63	java/lang/StringBuilder:<init>	(I)V
    //   44: putstatic 67	com/tencent/bugly/proguard/y:d	Ljava/lang/StringBuilder;
    //   47: aload_0
    //   48: putstatic 69	com/tencent/bugly/proguard/y:j	Landroid/content/Context;
    //   51: aload_0
    //   52: invokestatic 74	com/tencent/bugly/crashreport/common/info/a:a	(Landroid/content/Context;)Lcom/tencent/bugly/crashreport/common/info/a;
    //   55: astore_0
    //   56: aload_0
    //   57: getfield 76	com/tencent/bugly/crashreport/common/info/a:d	Ljava/lang/String;
    //   60: putstatic 78	com/tencent/bugly/proguard/y:h	Ljava/lang/String;
    //   63: aload_0
    //   64: invokevirtual 82	java/lang/Object:getClass	()Ljava/lang/Class;
    //   67: pop
    //   68: ldc 84
    //   70: putstatic 86	com/tencent/bugly/proguard/y:i	Ljava/lang/String;
    //   73: new 61	java/lang/StringBuilder
    //   76: dup
    //   77: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   80: getstatic 69	com/tencent/bugly/proguard/y:j	Landroid/content/Context;
    //   83: invokevirtual 93	android/content/Context:getFilesDir	()Ljava/io/File;
    //   86: invokevirtual 99	java/io/File:getPath	()Ljava/lang/String;
    //   89: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: ldc 105
    //   94: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: getstatic 78	com/tencent/bugly/proguard/y:h	Ljava/lang/String;
    //   100: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: ldc 107
    //   105: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: getstatic 86	com/tencent/bugly/proguard/y:i	Ljava/lang/String;
    //   111: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: ldc 109
    //   116: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   122: putstatic 114	com/tencent/bugly/proguard/y:k	Ljava/lang/String;
    //   125: invokestatic 120	android/os/Process:myPid	()I
    //   128: putstatic 122	com/tencent/bugly/proguard/y:n	I
    //   131: iconst_1
    //   132: putstatic 59	com/tencent/bugly/proguard/y:l	Z
    //   135: goto -114 -> 21
    //   138: astore_0
    //   139: ldc 2
    //   141: monitorexit
    //   142: aload_0
    //   143: athrow
    //   144: astore_0
    //   145: goto -14 -> 131
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	148	0	paramContext	Context
    //   16	2	1	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   3	9	138	finally
    //   13	17	138	finally
    //   25	131	138	finally
    //   131	135	138	finally
    //   25	131	144	java/lang/Throwable
  }
  
  public static void a(String arg0, String paramString2, String paramString3)
  {
    for (;;)
    {
      try
      {
        if (l)
        {
          boolean bool = a;
          if (bool) {}
        }
        else
        {
          return;
        }
        if ((m) && (b(???, paramString2, paramString3))) {
          continue;
        }
        long l1 = Process.myTid();
        d.setLength(0);
        String str = paramString3;
        if (paramString3.length() > 30720) {
          str = paramString3.substring(paramString3.length() - 30720, paramString3.length() - 1);
        }
        paramString3 = new Date();
        if (b != null)
        {
          paramString3 = b.format(paramString3);
          d.append(paramString3).append(" ").append(n).append(" ").append(l1).append(" ").append(???).append(" ").append(paramString2).append(": ").append(str).append("\001\r\n");
          paramString2 = d.toString();
          synchronized (o)
          {
            e.append(paramString2);
            if (e.length() > c) {
              break label223;
            }
          }
        }
        paramString3 = paramString3.toString();
      }
      finally {}
      continue;
      label223:
      if (f) {}
      f = true;
      w.a().a(new y.1());
    }
  }
  
  public static void a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (paramThrowable == null) {
      return;
    }
    String str2 = paramThrowable.getMessage();
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    a(paramString1, paramString2, str1 + '\n' + z.b(paramThrowable));
  }
  
  public static void a(boolean paramBoolean)
  {
    x.a("[LogUtil] Whether can record user log into native: " + paramBoolean, new Object[0]);
    m = paramBoolean;
  }
  
  public static byte[] a()
  {
    if (!a) {
      return null;
    }
    if (m)
    {
      x.a("[LogUtil] Get user log from native.", new Object[0]);
      ??? = f();
      if (??? != null)
      {
        x.a("[LogUtil] Got user log from native: %d bytes", new Object[] { Integer.valueOf(((String)???).length()) });
        return z.a(null, (String)???, "BuglyNativeLog.txt");
      }
    }
    StringBuilder localStringBuilder = new StringBuilder();
    synchronized (o)
    {
      if ((g != null) && (y.a.d(g)) && (y.a.a(g) != null) && (y.a.a(g).length() > 0L)) {
        localStringBuilder.append(z.a(y.a.a(g), 30720, true));
      }
      if ((e != null) && (e.length() > 0)) {
        localStringBuilder.append(e.toString());
      }
      return z.a(null, localStringBuilder.toString(), "BuglyLog.txt");
    }
  }
  
  private static boolean b(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      com.tencent.bugly.crashreport.common.info.a locala = com.tencent.bugly.crashreport.common.info.a.b();
      if ((locala != null) && (locala.E != null))
      {
        boolean bool = locala.E.appendLogToNative(paramString1, paramString2, paramString3);
        return bool;
      }
    }
    catch (Throwable paramString1)
    {
      if (!x.a(paramString1)) {
        paramString1.printStackTrace();
      }
    }
    return false;
  }
  
  private static String f()
  {
    try
    {
      Object localObject = com.tencent.bugly.crashreport.common.info.a.b();
      if ((localObject != null) && (((com.tencent.bugly.crashreport.common.info.a)localObject).E != null))
      {
        localObject = ((com.tencent.bugly.crashreport.common.info.a)localObject).E.getLogFromNative();
        return localObject;
      }
    }
    catch (Throwable localThrowable)
    {
      if (!x.a(localThrowable)) {
        localThrowable.printStackTrace();
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.bugly.proguard.y
 * JD-Core Version:    0.7.0.1
 */