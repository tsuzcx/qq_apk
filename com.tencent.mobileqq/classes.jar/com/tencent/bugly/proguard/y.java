package com.tencent.bugly.proguard;

import android.content.Context;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.concurrent.ExecutorService;

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
  private static ExecutorService n;
  private static int o;
  private static final Object p;
  
  static
  {
    a = true;
    c = 5120;
    m = false;
    p = new Object();
    try
    {
      b = new SimpleDateFormat("MM-dd HH:mm:ss");
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public static void a(int paramInt)
  {
    synchronized (p)
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
    //   3: getstatic 58	com/tencent/bugly/proguard/y:l	Z
    //   6: ifne +15 -> 21
    //   9: aload_0
    //   10: ifnull +11 -> 21
    //   13: getstatic 37	com/tencent/bugly/proguard/y:a	Z
    //   16: istore_1
    //   17: iload_1
    //   18: ifne +7 -> 25
    //   21: ldc 2
    //   23: monitorexit
    //   24: return
    //   25: invokestatic 64	java/util/concurrent/Executors:newSingleThreadExecutor	()Ljava/util/concurrent/ExecutorService;
    //   28: putstatic 66	com/tencent/bugly/proguard/y:n	Ljava/util/concurrent/ExecutorService;
    //   31: new 68	java/lang/StringBuilder
    //   34: dup
    //   35: iconst_0
    //   36: invokespecial 70	java/lang/StringBuilder:<init>	(I)V
    //   39: putstatic 72	com/tencent/bugly/proguard/y:e	Ljava/lang/StringBuilder;
    //   42: new 68	java/lang/StringBuilder
    //   45: dup
    //   46: iconst_0
    //   47: invokespecial 70	java/lang/StringBuilder:<init>	(I)V
    //   50: putstatic 74	com/tencent/bugly/proguard/y:d	Ljava/lang/StringBuilder;
    //   53: aload_0
    //   54: putstatic 76	com/tencent/bugly/proguard/y:j	Landroid/content/Context;
    //   57: aload_0
    //   58: invokestatic 81	com/tencent/bugly/crashreport/common/info/a:a	(Landroid/content/Context;)Lcom/tencent/bugly/crashreport/common/info/a;
    //   61: astore_0
    //   62: aload_0
    //   63: getfield 83	com/tencent/bugly/crashreport/common/info/a:d	Ljava/lang/String;
    //   66: putstatic 85	com/tencent/bugly/proguard/y:h	Ljava/lang/String;
    //   69: aload_0
    //   70: invokevirtual 89	java/lang/Object:getClass	()Ljava/lang/Class;
    //   73: pop
    //   74: ldc 91
    //   76: putstatic 93	com/tencent/bugly/proguard/y:i	Ljava/lang/String;
    //   79: new 68	java/lang/StringBuilder
    //   82: dup
    //   83: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   86: getstatic 76	com/tencent/bugly/proguard/y:j	Landroid/content/Context;
    //   89: invokevirtual 100	android/content/Context:getFilesDir	()Ljava/io/File;
    //   92: invokevirtual 106	java/io/File:getPath	()Ljava/lang/String;
    //   95: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: ldc 112
    //   100: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: getstatic 85	com/tencent/bugly/proguard/y:h	Ljava/lang/String;
    //   106: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: ldc 114
    //   111: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: getstatic 93	com/tencent/bugly/proguard/y:i	Ljava/lang/String;
    //   117: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: ldc 116
    //   122: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   128: putstatic 121	com/tencent/bugly/proguard/y:k	Ljava/lang/String;
    //   131: invokestatic 127	android/os/Process:myPid	()I
    //   134: putstatic 129	com/tencent/bugly/proguard/y:o	I
    //   137: iconst_1
    //   138: putstatic 58	com/tencent/bugly/proguard/y:l	Z
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
  
  public static void a(String paramString1, String paramString2, String paramString3)
  {
    label63:
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
        try
        {
          if (!m) {
            break label63;
          }
          n.execute(new y.1(paramString1, paramString2, paramString3));
        }
        catch (Exception paramString1)
        {
          x.b(paramString1);
        }
        continue;
        n.execute(new y.2(paramString1, paramString2, paramString3));
      }
      finally {}
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
      ??? = b();
      if (??? != null)
      {
        x.a("[LogUtil] Got user log from native: %d bytes", new Object[] { Integer.valueOf(((String)???).length()) });
        return z.a(null, (String)???, "BuglyNativeLog.txt");
      }
    }
    StringBuilder localStringBuilder = new StringBuilder();
    synchronized (p)
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
  
  private static String b()
  {
    try
    {
      Object localObject = com.tencent.bugly.crashreport.common.info.a.b();
      if ((localObject != null) && (((com.tencent.bugly.crashreport.common.info.a)localObject).G != null))
      {
        localObject = ((com.tencent.bugly.crashreport.common.info.a)localObject).G.getLogFromNative();
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
  
  private static boolean d(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      com.tencent.bugly.crashreport.common.info.a locala = com.tencent.bugly.crashreport.common.info.a.b();
      if ((locala != null) && (locala.G != null))
      {
        boolean bool = locala.G.appendLogToNative(paramString1, paramString2, paramString3);
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
  
  /* Error */
  private static void e(String arg0, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 244	android/os/Process:myTid	()I
    //   6: i2l
    //   7: lstore 5
    //   9: getstatic 74	com/tencent/bugly/proguard/y:d	Ljava/lang/StringBuilder;
    //   12: iconst_0
    //   13: invokevirtual 247	java/lang/StringBuilder:setLength	(I)V
    //   16: aload_2
    //   17: astore 8
    //   19: aload_2
    //   20: invokevirtual 186	java/lang/String:length	()I
    //   23: sipush 30720
    //   26: if_icmple +23 -> 49
    //   29: aload_2
    //   30: aload_2
    //   31: invokevirtual 186	java/lang/String:length	()I
    //   34: sipush 30720
    //   37: isub
    //   38: aload_2
    //   39: invokevirtual 186	java/lang/String:length	()I
    //   42: iconst_1
    //   43: isub
    //   44: invokevirtual 251	java/lang/String:substring	(II)Ljava/lang/String;
    //   47: astore 8
    //   49: new 253	java/util/Date
    //   52: dup
    //   53: invokespecial 254	java/util/Date:<init>	()V
    //   56: astore_2
    //   57: getstatic 35	com/tencent/bugly/proguard/y:b	Ljava/text/SimpleDateFormat;
    //   60: ifnull +124 -> 184
    //   63: getstatic 35	com/tencent/bugly/proguard/y:b	Ljava/text/SimpleDateFormat;
    //   66: aload_2
    //   67: invokevirtual 258	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   70: astore_2
    //   71: getstatic 74	com/tencent/bugly/proguard/y:d	Ljava/lang/StringBuilder;
    //   74: aload_2
    //   75: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: ldc_w 260
    //   81: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: getstatic 129	com/tencent/bugly/proguard/y:o	I
    //   87: invokevirtual 263	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   90: ldc_w 260
    //   93: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: lload 5
    //   98: invokevirtual 266	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   101: ldc_w 260
    //   104: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: aload_0
    //   108: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: ldc_w 260
    //   114: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: aload_1
    //   118: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: ldc_w 268
    //   124: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: aload 8
    //   129: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: ldc_w 270
    //   135: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: pop
    //   139: getstatic 74	com/tencent/bugly/proguard/y:d	Ljava/lang/StringBuilder;
    //   142: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   145: astore_1
    //   146: getstatic 46	com/tencent/bugly/proguard/y:p	Ljava/lang/Object;
    //   149: astore_0
    //   150: aload_0
    //   151: monitorenter
    //   152: getstatic 72	com/tencent/bugly/proguard/y:e	Ljava/lang/StringBuilder;
    //   155: aload_1
    //   156: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: pop
    //   160: getstatic 72	com/tencent/bugly/proguard/y:e	Ljava/lang/StringBuilder;
    //   163: invokevirtual 214	java/lang/StringBuilder:length	()I
    //   166: istore_3
    //   167: getstatic 39	com/tencent/bugly/proguard/y:c	I
    //   170: istore 4
    //   172: iload_3
    //   173: iload 4
    //   175: if_icmpgt +17 -> 192
    //   178: aload_0
    //   179: monitorexit
    //   180: ldc 2
    //   182: monitorexit
    //   183: return
    //   184: aload_2
    //   185: invokevirtual 271	java/util/Date:toString	()Ljava/lang/String;
    //   188: astore_2
    //   189: goto -118 -> 71
    //   192: getstatic 273	com/tencent/bugly/proguard/y:f	Z
    //   195: istore 7
    //   197: iload 7
    //   199: ifeq +19 -> 218
    //   202: aload_0
    //   203: monitorexit
    //   204: goto -24 -> 180
    //   207: astore_1
    //   208: aload_0
    //   209: monitorexit
    //   210: aload_1
    //   211: athrow
    //   212: astore_0
    //   213: ldc 2
    //   215: monitorexit
    //   216: aload_0
    //   217: athrow
    //   218: iconst_1
    //   219: putstatic 273	com/tencent/bugly/proguard/y:f	Z
    //   222: getstatic 199	com/tencent/bugly/proguard/y:g	Lcom/tencent/bugly/proguard/y$a;
    //   225: ifnonnull +47 -> 272
    //   228: new 201	com/tencent/bugly/proguard/y$a
    //   231: dup
    //   232: getstatic 121	com/tencent/bugly/proguard/y:k	Ljava/lang/String;
    //   235: invokespecial 274	com/tencent/bugly/proguard/y$a:<init>	(Ljava/lang/String;)V
    //   238: putstatic 199	com/tencent/bugly/proguard/y:g	Lcom/tencent/bugly/proguard/y$a;
    //   241: getstatic 199	com/tencent/bugly/proguard/y:g	Lcom/tencent/bugly/proguard/y$a;
    //   244: getstatic 72	com/tencent/bugly/proguard/y:e	Ljava/lang/StringBuilder;
    //   247: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   250: invokevirtual 277	com/tencent/bugly/proguard/y$a:a	(Ljava/lang/String;)Z
    //   253: ifeq +14 -> 267
    //   256: getstatic 72	com/tencent/bugly/proguard/y:e	Ljava/lang/StringBuilder;
    //   259: iconst_0
    //   260: invokevirtual 247	java/lang/StringBuilder:setLength	(I)V
    //   263: iconst_0
    //   264: putstatic 273	com/tencent/bugly/proguard/y:f	Z
    //   267: aload_0
    //   268: monitorexit
    //   269: goto -89 -> 180
    //   272: getstatic 199	com/tencent/bugly/proguard/y:g	Lcom/tencent/bugly/proguard/y$a;
    //   275: invokestatic 207	com/tencent/bugly/proguard/y$a:a	(Lcom/tencent/bugly/proguard/y$a;)Ljava/io/File;
    //   278: ifnull +30 -> 308
    //   281: getstatic 199	com/tencent/bugly/proguard/y:g	Lcom/tencent/bugly/proguard/y$a;
    //   284: invokestatic 207	com/tencent/bugly/proguard/y$a:a	(Lcom/tencent/bugly/proguard/y$a;)Ljava/io/File;
    //   287: invokevirtual 210	java/io/File:length	()J
    //   290: getstatic 72	com/tencent/bugly/proguard/y:e	Ljava/lang/StringBuilder;
    //   293: invokevirtual 214	java/lang/StringBuilder:length	()I
    //   296: i2l
    //   297: ladd
    //   298: getstatic 199	com/tencent/bugly/proguard/y:g	Lcom/tencent/bugly/proguard/y$a;
    //   301: invokestatic 280	com/tencent/bugly/proguard/y$a:b	(Lcom/tencent/bugly/proguard/y$a;)J
    //   304: lcmp
    //   305: ifle -64 -> 241
    //   308: getstatic 199	com/tencent/bugly/proguard/y:g	Lcom/tencent/bugly/proguard/y$a;
    //   311: invokestatic 282	com/tencent/bugly/proguard/y$a:c	(Lcom/tencent/bugly/proguard/y$a;)Z
    //   314: pop
    //   315: goto -74 -> 241
    //   318: astore_1
    //   319: goto -52 -> 267
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	322	1	paramString2	String
    //   0	322	2	paramString3	String
    //   166	10	3	i1	int
    //   170	6	4	i2	int
    //   7	90	5	l1	long
    //   195	3	7	bool	boolean
    //   17	111	8	str	String
    // Exception table:
    //   from	to	target	type
    //   152	172	207	finally
    //   178	180	207	finally
    //   192	197	207	finally
    //   202	204	207	finally
    //   218	241	207	finally
    //   241	267	207	finally
    //   267	269	207	finally
    //   272	308	207	finally
    //   308	315	207	finally
    //   3	16	212	finally
    //   19	49	212	finally
    //   49	71	212	finally
    //   71	152	212	finally
    //   184	189	212	finally
    //   208	212	212	finally
    //   152	172	318	java/lang/Throwable
    //   192	197	318	java/lang/Throwable
    //   218	241	318	java/lang/Throwable
    //   241	267	318	java/lang/Throwable
    //   272	308	318	java/lang/Throwable
    //   308	315	318	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.bugly.proguard.y
 * JD-Core Version:    0.7.0.1
 */