package com.tencent.bugly.proguard;

import android.content.Context;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;

public final class y
{
  public static boolean a;
  private static boolean b = true;
  private static SimpleDateFormat c = null;
  private static int d;
  private static StringBuilder e;
  private static StringBuilder f;
  private static boolean g;
  private static y.a h;
  private static String i;
  private static String j;
  private static Context k;
  private static String l;
  private static boolean m;
  private static boolean n;
  private static ExecutorService o;
  private static int p;
  private static final Object q;
  
  static
  {
    a = true;
    d = 30720;
    n = false;
    q = new Object();
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
    if (c != null) {}
    for (paramString3 = c.format(paramString3);; paramString3 = paramString3.toString())
    {
      e.append(paramString3).append(" ").append(p).append(" ").append(paramLong).append(" ").append(paramString1).append(" ").append(paramString2).append(": ").append(str).append("\001\r\n");
      return e.toString();
    }
  }
  
  public static void a(int paramInt)
  {
    synchronized (q)
    {
      d = paramInt;
      if (paramInt < 0) {
        d = 0;
      }
      while (paramInt <= 30720) {
        return;
      }
      d = 30720;
    }
  }
  
  /* Error */
  public static void a(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 118	com/tencent/bugly/proguard/y:m	Z
    //   6: ifne +15 -> 21
    //   9: aload_0
    //   10: ifnull +11 -> 21
    //   13: getstatic 40	com/tencent/bugly/proguard/y:a	Z
    //   16: istore_1
    //   17: iload_1
    //   18: ifne +7 -> 25
    //   21: ldc 2
    //   23: monitorexit
    //   24: return
    //   25: invokestatic 124	java/util/concurrent/Executors:newSingleThreadExecutor	()Ljava/util/concurrent/ExecutorService;
    //   28: putstatic 126	com/tencent/bugly/proguard/y:o	Ljava/util/concurrent/ExecutorService;
    //   31: new 71	java/lang/StringBuilder
    //   34: dup
    //   35: iconst_0
    //   36: invokespecial 128	java/lang/StringBuilder:<init>	(I)V
    //   39: putstatic 130	com/tencent/bugly/proguard/y:f	Ljava/lang/StringBuilder;
    //   42: new 71	java/lang/StringBuilder
    //   45: dup
    //   46: iconst_0
    //   47: invokespecial 128	java/lang/StringBuilder:<init>	(I)V
    //   50: putstatic 69	com/tencent/bugly/proguard/y:e	Ljava/lang/StringBuilder;
    //   53: aload_0
    //   54: putstatic 132	com/tencent/bugly/proguard/y:k	Landroid/content/Context;
    //   57: aload_0
    //   58: invokestatic 137	com/tencent/bugly/crashreport/common/info/a:a	(Landroid/content/Context;)Lcom/tencent/bugly/crashreport/common/info/a;
    //   61: astore_0
    //   62: aload_0
    //   63: getfield 139	com/tencent/bugly/crashreport/common/info/a:d	Ljava/lang/String;
    //   66: putstatic 141	com/tencent/bugly/proguard/y:i	Ljava/lang/String;
    //   69: aload_0
    //   70: invokevirtual 145	java/lang/Object:getClass	()Ljava/lang/Class;
    //   73: pop
    //   74: ldc 147
    //   76: putstatic 149	com/tencent/bugly/proguard/y:j	Ljava/lang/String;
    //   79: new 71	java/lang/StringBuilder
    //   82: dup
    //   83: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   86: getstatic 132	com/tencent/bugly/proguard/y:k	Landroid/content/Context;
    //   89: invokevirtual 156	android/content/Context:getFilesDir	()Ljava/io/File;
    //   92: invokevirtual 161	java/io/File:getPath	()Ljava/lang/String;
    //   95: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: ldc 163
    //   100: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: getstatic 141	com/tencent/bugly/proguard/y:i	Ljava/lang/String;
    //   106: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: ldc 165
    //   111: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: getstatic 149	com/tencent/bugly/proguard/y:j	Ljava/lang/String;
    //   117: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: ldc 167
    //   122: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   128: putstatic 169	com/tencent/bugly/proguard/y:l	Ljava/lang/String;
    //   131: invokestatic 174	android/os/Process:myPid	()I
    //   134: putstatic 100	com/tencent/bugly/proguard/y:p	I
    //   137: iconst_1
    //   138: putstatic 118	com/tencent/bugly/proguard/y:m	Z
    //   141: goto -120 -> 21
    //   144: astore_0
    //   145: ldc 2
    //   147: monitorexit
    //   148: aload_0
    //   149: athrow
    //   150: astore_0
    //   151: goto -14 -> 137
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	154	0	paramContext	Context
    //   16	2	1	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   3	9	144	finally
    //   13	17	144	finally
    //   25	137	144	finally
    //   137	141	144	finally
    //   25	137	150	java/lang/Throwable
  }
  
  /* Error */
  public static void a(String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 118	com/tencent/bugly/proguard/y:m	Z
    //   6: ifeq +11 -> 17
    //   9: getstatic 40	com/tencent/bugly/proguard/y:a	Z
    //   12: istore_3
    //   13: iload_3
    //   14: ifne +7 -> 21
    //   17: ldc 2
    //   19: monitorexit
    //   20: return
    //   21: getstatic 126	com/tencent/bugly/proguard/y:o	Ljava/util/concurrent/ExecutorService;
    //   24: new 179	com/tencent/bugly/proguard/y$1
    //   27: dup
    //   28: aload_0
    //   29: aload_1
    //   30: aload_2
    //   31: invokespecial 181	com/tencent/bugly/proguard/y$1:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   34: invokeinterface 187 2 0
    //   39: goto -22 -> 17
    //   42: astore_0
    //   43: aload_0
    //   44: invokestatic 65	com/tencent/bugly/proguard/x:b	(Ljava/lang/Throwable;)Z
    //   47: pop
    //   48: goto -31 -> 17
    //   51: astore_0
    //   52: ldc 2
    //   54: monitorexit
    //   55: aload_0
    //   56: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	57	0	paramString1	String
    //   0	57	1	paramString2	String
    //   0	57	2	paramString3	String
    //   12	2	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   21	39	42	java/lang/Exception
    //   3	13	51	finally
    //   21	39	51	finally
    //   43	48	51	finally
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
  
  /* Error */
  private static void c(String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 36	com/tencent/bugly/proguard/y:b	Z
    //   6: ifeq +13 -> 19
    //   9: aload_0
    //   10: aload_1
    //   11: aload_2
    //   12: invokestatic 230	com/tencent/bugly/proguard/y:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   15: ldc 2
    //   17: monitorexit
    //   18: return
    //   19: aload_0
    //   20: aload_1
    //   21: aload_2
    //   22: invokestatic 232	com/tencent/bugly/proguard/y:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   25: goto -10 -> 15
    //   28: astore_0
    //   29: ldc 2
    //   31: monitorexit
    //   32: aload_0
    //   33: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	34	0	paramString1	String
    //   0	34	1	paramString2	String
    //   0	34	2	paramString3	String
    // Exception table:
    //   from	to	target	type
    //   3	15	28	finally
    //   19	25	28	finally
  }
  
  /* Error */
  private static void d(String arg0, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: aload_1
    //   5: aload_2
    //   6: invokestatic 235	android/os/Process:myTid	()I
    //   9: i2l
    //   10: invokestatic 237	com/tencent/bugly/proguard/y:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)Ljava/lang/String;
    //   13: astore_1
    //   14: getstatic 49	com/tencent/bugly/proguard/y:q	Ljava/lang/Object;
    //   17: astore_0
    //   18: aload_0
    //   19: monitorenter
    //   20: getstatic 130	com/tencent/bugly/proguard/y:f	Ljava/lang/StringBuilder;
    //   23: aload_1
    //   24: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: pop
    //   28: getstatic 130	com/tencent/bugly/proguard/y:f	Ljava/lang/StringBuilder;
    //   31: invokevirtual 228	java/lang/StringBuilder:length	()I
    //   34: getstatic 42	com/tencent/bugly/proguard/y:d	I
    //   37: if_icmplt +23 -> 60
    //   40: getstatic 130	com/tencent/bugly/proguard/y:f	Ljava/lang/StringBuilder;
    //   43: iconst_0
    //   44: getstatic 130	com/tencent/bugly/proguard/y:f	Ljava/lang/StringBuilder;
    //   47: ldc 110
    //   49: invokevirtual 241	java/lang/StringBuilder:indexOf	(Ljava/lang/String;)I
    //   52: iconst_1
    //   53: iadd
    //   54: invokevirtual 245	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   57: putstatic 130	com/tencent/bugly/proguard/y:f	Ljava/lang/StringBuilder;
    //   60: aload_0
    //   61: monitorexit
    //   62: ldc 2
    //   64: monitorexit
    //   65: return
    //   66: astore_1
    //   67: aload_1
    //   68: invokestatic 65	com/tencent/bugly/proguard/x:b	(Ljava/lang/Throwable;)Z
    //   71: ifne -11 -> 60
    //   74: aload_1
    //   75: invokevirtual 248	java/lang/Throwable:printStackTrace	()V
    //   78: goto -18 -> 60
    //   81: astore_1
    //   82: aload_0
    //   83: monitorexit
    //   84: aload_1
    //   85: athrow
    //   86: astore_0
    //   87: ldc 2
    //   89: monitorexit
    //   90: aload_0
    //   91: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	92	1	paramString2	String
    //   0	92	2	paramString3	String
    // Exception table:
    //   from	to	target	type
    //   20	60	66	java/lang/Throwable
    //   20	60	81	finally
    //   60	62	81	finally
    //   67	78	81	finally
    //   3	20	86	finally
    //   82	86	86	finally
  }
  
  /* Error */
  private static void e(String arg0, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: aload_1
    //   5: aload_2
    //   6: invokestatic 235	android/os/Process:myTid	()I
    //   9: i2l
    //   10: invokestatic 237	com/tencent/bugly/proguard/y:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)Ljava/lang/String;
    //   13: astore_1
    //   14: getstatic 49	com/tencent/bugly/proguard/y:q	Ljava/lang/Object;
    //   17: astore_0
    //   18: aload_0
    //   19: monitorenter
    //   20: getstatic 130	com/tencent/bugly/proguard/y:f	Ljava/lang/StringBuilder;
    //   23: aload_1
    //   24: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: pop
    //   28: getstatic 130	com/tencent/bugly/proguard/y:f	Ljava/lang/StringBuilder;
    //   31: invokevirtual 228	java/lang/StringBuilder:length	()I
    //   34: istore_3
    //   35: getstatic 42	com/tencent/bugly/proguard/y:d	I
    //   38: istore 4
    //   40: iload_3
    //   41: iload 4
    //   43: if_icmpgt +9 -> 52
    //   46: aload_0
    //   47: monitorexit
    //   48: ldc 2
    //   50: monitorexit
    //   51: return
    //   52: getstatic 250	com/tencent/bugly/proguard/y:g	Z
    //   55: istore 5
    //   57: iload 5
    //   59: ifeq +19 -> 78
    //   62: aload_0
    //   63: monitorexit
    //   64: goto -16 -> 48
    //   67: astore_1
    //   68: aload_0
    //   69: monitorexit
    //   70: aload_1
    //   71: athrow
    //   72: astore_0
    //   73: ldc 2
    //   75: monitorexit
    //   76: aload_0
    //   77: athrow
    //   78: iconst_1
    //   79: putstatic 250	com/tencent/bugly/proguard/y:g	Z
    //   82: getstatic 213	com/tencent/bugly/proguard/y:h	Lcom/tencent/bugly/proguard/y$a;
    //   85: ifnonnull +47 -> 132
    //   88: new 215	com/tencent/bugly/proguard/y$a
    //   91: dup
    //   92: getstatic 169	com/tencent/bugly/proguard/y:l	Ljava/lang/String;
    //   95: invokespecial 251	com/tencent/bugly/proguard/y$a:<init>	(Ljava/lang/String;)V
    //   98: putstatic 213	com/tencent/bugly/proguard/y:h	Lcom/tencent/bugly/proguard/y$a;
    //   101: getstatic 213	com/tencent/bugly/proguard/y:h	Lcom/tencent/bugly/proguard/y$a;
    //   104: getstatic 130	com/tencent/bugly/proguard/y:f	Ljava/lang/StringBuilder;
    //   107: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   110: invokevirtual 254	com/tencent/bugly/proguard/y$a:a	(Ljava/lang/String;)Z
    //   113: ifeq +14 -> 127
    //   116: getstatic 130	com/tencent/bugly/proguard/y:f	Ljava/lang/StringBuilder;
    //   119: iconst_0
    //   120: invokevirtual 75	java/lang/StringBuilder:setLength	(I)V
    //   123: iconst_0
    //   124: putstatic 250	com/tencent/bugly/proguard/y:g	Z
    //   127: aload_0
    //   128: monitorexit
    //   129: goto -81 -> 48
    //   132: getstatic 213	com/tencent/bugly/proguard/y:h	Lcom/tencent/bugly/proguard/y$a;
    //   135: invokestatic 221	com/tencent/bugly/proguard/y$a:a	(Lcom/tencent/bugly/proguard/y$a;)Ljava/io/File;
    //   138: ifnull +30 -> 168
    //   141: getstatic 213	com/tencent/bugly/proguard/y:h	Lcom/tencent/bugly/proguard/y$a;
    //   144: invokestatic 221	com/tencent/bugly/proguard/y$a:a	(Lcom/tencent/bugly/proguard/y$a;)Ljava/io/File;
    //   147: invokevirtual 224	java/io/File:length	()J
    //   150: getstatic 130	com/tencent/bugly/proguard/y:f	Ljava/lang/StringBuilder;
    //   153: invokevirtual 228	java/lang/StringBuilder:length	()I
    //   156: i2l
    //   157: ladd
    //   158: getstatic 213	com/tencent/bugly/proguard/y:h	Lcom/tencent/bugly/proguard/y$a;
    //   161: invokestatic 257	com/tencent/bugly/proguard/y$a:b	(Lcom/tencent/bugly/proguard/y$a;)J
    //   164: lcmp
    //   165: ifle -64 -> 101
    //   168: getstatic 213	com/tencent/bugly/proguard/y:h	Lcom/tencent/bugly/proguard/y$a;
    //   171: invokestatic 259	com/tencent/bugly/proguard/y$a:c	(Lcom/tencent/bugly/proguard/y$a;)Z
    //   174: pop
    //   175: goto -74 -> 101
    //   178: astore_1
    //   179: goto -52 -> 127
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	182	1	paramString2	String
    //   0	182	2	paramString3	String
    //   34	10	3	i1	int
    //   38	6	4	i2	int
    //   55	3	5	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   20	40	67	finally
    //   46	48	67	finally
    //   52	57	67	finally
    //   62	64	67	finally
    //   78	101	67	finally
    //   101	127	67	finally
    //   127	129	67	finally
    //   132	168	67	finally
    //   168	175	67	finally
    //   3	20	72	finally
    //   68	72	72	finally
    //   20	40	178	java/lang/Throwable
    //   52	57	178	java/lang/Throwable
    //   78	101	178	java/lang/Throwable
    //   101	127	178	java/lang/Throwable
    //   132	168	178	java/lang/Throwable
    //   168	175	178	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.bugly.proguard.y
 * JD-Core Version:    0.7.0.1
 */