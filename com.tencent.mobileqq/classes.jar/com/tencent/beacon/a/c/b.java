package com.tencent.beacon.a.c;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.tencent.beacon.a.g.a;

public final class b
{
  public static String a;
  public static String b;
  public static String c;
  private static b d = null;
  private Context e = null;
  private String f = "";
  private String g = "";
  private byte h = -1;
  private String i = "";
  private String j = "";
  private String k = "";
  private String l = "";
  private String m = "";
  private long n = 0L;
  private String o = "";
  private String p = "";
  
  /* Error */
  public static b a(Context paramContext)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: ldc 2
    //   4: monitorenter
    //   5: aload_0
    //   6: ifnonnull +10 -> 16
    //   9: aconst_null
    //   10: astore_0
    //   11: ldc 2
    //   13: monitorexit
    //   14: aload_0
    //   15: areturn
    //   16: getstatic 29	com/tencent/beacon/a/c/b:d	Lcom/tencent/beacon/a/c/b;
    //   19: ifnonnull +125 -> 144
    //   22: new 2	com/tencent/beacon/a/c/b
    //   25: dup
    //   26: invokespecial 61	com/tencent/beacon/a/c/b:<init>	()V
    //   29: astore_3
    //   30: aload_3
    //   31: putstatic 29	com/tencent/beacon/a/c/b:d	Lcom/tencent/beacon/a/c/b;
    //   34: aload_3
    //   35: aload_0
    //   36: putfield 35	com/tencent/beacon/a/c/b:e	Landroid/content/Context;
    //   39: aload_0
    //   40: invokestatic 66	com/tencent/beacon/a/c/e:a	(Landroid/content/Context;)Lcom/tencent/beacon/a/c/e;
    //   43: pop
    //   44: getstatic 29	com/tencent/beacon/a/c/b:d	Lcom/tencent/beacon/a/c/b;
    //   47: invokestatic 69	com/tencent/beacon/a/c/e:b	()Ljava/lang/String;
    //   50: putfield 39	com/tencent/beacon/a/c/b:f	Ljava/lang/String;
    //   53: getstatic 29	com/tencent/beacon/a/c/b:d	Lcom/tencent/beacon/a/c/b;
    //   56: invokestatic 71	com/tencent/beacon/a/c/e:a	()Ljava/lang/String;
    //   59: putfield 41	com/tencent/beacon/a/c/b:g	Ljava/lang/String;
    //   62: getstatic 29	com/tencent/beacon/a/c/b:d	Lcom/tencent/beacon/a/c/b;
    //   65: iconst_1
    //   66: putfield 43	com/tencent/beacon/a/c/b:h	B
    //   69: getstatic 29	com/tencent/beacon/a/c/b:d	Lcom/tencent/beacon/a/c/b;
    //   72: aload_0
    //   73: invokestatic 76	com/tencent/beacon/a/c/a:c	(Landroid/content/Context;)Ljava/lang/String;
    //   76: putfield 45	com/tencent/beacon/a/c/b:i	Ljava/lang/String;
    //   79: getstatic 29	com/tencent/beacon/a/c/b:d	Lcom/tencent/beacon/a/c/b;
    //   82: aload_0
    //   83: invokestatic 78	com/tencent/beacon/a/c/a:e	(Landroid/content/Context;)Ljava/lang/String;
    //   86: putfield 47	com/tencent/beacon/a/c/b:j	Ljava/lang/String;
    //   89: getstatic 29	com/tencent/beacon/a/c/b:d	Lcom/tencent/beacon/a/c/b;
    //   92: ldc 80
    //   94: putfield 49	com/tencent/beacon/a/c/b:k	Ljava/lang/String;
    //   97: getstatic 29	com/tencent/beacon/a/c/b:d	Lcom/tencent/beacon/a/c/b;
    //   100: ldc 82
    //   102: putfield 51	com/tencent/beacon/a/c/b:l	Ljava/lang/String;
    //   105: getstatic 29	com/tencent/beacon/a/c/b:d	Lcom/tencent/beacon/a/c/b;
    //   108: ldc 84
    //   110: putfield 53	com/tencent/beacon/a/c/b:m	Ljava/lang/String;
    //   113: getstatic 29	com/tencent/beacon/a/c/b:d	Lcom/tencent/beacon/a/c/b;
    //   116: aload_0
    //   117: invokestatic 86	com/tencent/beacon/a/c/b:b	(Landroid/content/Context;)Ljava/lang/String;
    //   120: putfield 57	com/tencent/beacon/a/c/b:o	Ljava/lang/String;
    //   123: getstatic 29	com/tencent/beacon/a/c/b:d	Lcom/tencent/beacon/a/c/b;
    //   126: astore 4
    //   128: aload_0
    //   129: ifnonnull +22 -> 151
    //   132: ldc 37
    //   134: astore_3
    //   135: aload 4
    //   137: aload_3
    //   138: invokestatic 91	com/tencent/beacon/a/a:c	(Ljava/lang/String;)Ljava/lang/String;
    //   141: putfield 59	com/tencent/beacon/a/c/b:p	Ljava/lang/String;
    //   144: getstatic 29	com/tencent/beacon/a/c/b:d	Lcom/tencent/beacon/a/c/b;
    //   147: astore_0
    //   148: goto -137 -> 11
    //   151: aload_0
    //   152: invokestatic 92	com/tencent/beacon/a/c/b:c	(Landroid/content/Context;)Ljava/lang/String;
    //   155: astore_3
    //   156: iload_2
    //   157: istore_1
    //   158: aload_3
    //   159: ifnull +14 -> 173
    //   162: aload_3
    //   163: ldc 37
    //   165: invokevirtual 98	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   168: ifeq +17 -> 185
    //   171: iload_2
    //   172: istore_1
    //   173: iload_1
    //   174: ifeq -39 -> 135
    //   177: aload_0
    //   178: invokestatic 100	com/tencent/beacon/a/c/b:d	(Landroid/content/Context;)Ljava/lang/String;
    //   181: astore_3
    //   182: goto -47 -> 135
    //   185: iconst_0
    //   186: istore_1
    //   187: goto -14 -> 173
    //   190: astore_0
    //   191: ldc 2
    //   193: monitorexit
    //   194: aload_0
    //   195: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	196	0	paramContext	Context
    //   157	30	1	i1	int
    //   1	171	2	i2	int
    //   29	153	3	localObject	Object
    //   126	10	4	localb	b
    // Exception table:
    //   from	to	target	type
    //   16	128	190	finally
    //   135	144	190	finally
    //   144	148	190	finally
    //   151	156	190	finally
    //   162	171	190	finally
    //   177	182	190	finally
  }
  
  private static String b(Context paramContext)
  {
    if (paramContext == null) {
      return "";
    }
    try
    {
      paramContext = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128).metaData.get("APPKEY_DENGTA");
      if (paramContext != null)
      {
        paramContext = paramContext.toString().trim();
        return paramContext;
      }
    }
    catch (Throwable paramContext)
    {
      a.d("[core] not set 'APPKEY_DENGTA' in manifest", new Object[0]);
    }
    return "";
  }
  
  /* Error */
  private static String c(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 152	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   4: astore_3
    //   5: aload_0
    //   6: invokestatic 157	com/tencent/beacon/a/a/c:a	(Landroid/content/Context;)Lcom/tencent/beacon/a/a/c;
    //   9: astore 5
    //   11: aload 5
    //   13: ldc 159
    //   15: ldc 37
    //   17: invokevirtual 162	com/tencent/beacon/a/a/c:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   20: astore_0
    //   21: aload_0
    //   22: ifnull +301 -> 323
    //   25: aload_0
    //   26: ldc 37
    //   28: invokevirtual 98	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   31: ifeq +147 -> 178
    //   34: goto +289 -> 323
    //   37: iload_1
    //   38: ifeq +21 -> 59
    //   41: ldc 164
    //   43: astore_0
    //   44: aload 5
    //   46: invokevirtual 167	com/tencent/beacon/a/a/c:a	()Lcom/tencent/beacon/a/a/c;
    //   49: ldc 159
    //   51: ldc 164
    //   53: invokevirtual 170	com/tencent/beacon/a/a/c:a	(Ljava/lang/String;Ljava/lang/Object;)Lcom/tencent/beacon/a/a/c;
    //   56: invokevirtual 172	com/tencent/beacon/a/a/c:b	()V
    //   59: aload_0
    //   60: ldc 37
    //   62: invokevirtual 98	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   65: ifne +130 -> 195
    //   68: aload_3
    //   69: aload_0
    //   70: invokevirtual 178	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   73: astore_0
    //   74: aload_0
    //   75: astore 4
    //   77: new 180	java/util/Properties
    //   80: dup
    //   81: invokespecial 181	java/util/Properties:<init>	()V
    //   84: astore_3
    //   85: aload_0
    //   86: astore 4
    //   88: aload_3
    //   89: aload_0
    //   90: invokevirtual 185	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   93: aload_0
    //   94: astore 4
    //   96: aload_3
    //   97: ldc 187
    //   99: ldc 37
    //   101: invokevirtual 190	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   104: astore_3
    //   105: aload_0
    //   106: astore 4
    //   108: new 192	java/lang/StringBuilder
    //   111: dup
    //   112: ldc 194
    //   114: invokespecial 197	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   117: aload_3
    //   118: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   124: iconst_0
    //   125: anewarray 4	java/lang/Object
    //   128: invokestatic 204	com/tencent/beacon/a/g/a:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   131: aload_3
    //   132: ifnull +17 -> 149
    //   135: aload_0
    //   136: astore 4
    //   138: aload_3
    //   139: ldc 37
    //   141: invokevirtual 98	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   144: istore_2
    //   145: iload_2
    //   146: ifeq +37 -> 183
    //   149: iconst_1
    //   150: istore_1
    //   151: aload_3
    //   152: astore 5
    //   154: aload_0
    //   155: astore 6
    //   157: iload_1
    //   158: ifne +44 -> 202
    //   161: aload_3
    //   162: astore 4
    //   164: aload_0
    //   165: ifnull +10 -> 175
    //   168: aload_0
    //   169: invokevirtual 209	java/io/InputStream:close	()V
    //   172: aload_3
    //   173: astore 4
    //   175: aload 4
    //   177: areturn
    //   178: iconst_0
    //   179: istore_1
    //   180: goto -143 -> 37
    //   183: iconst_0
    //   184: istore_1
    //   185: goto -34 -> 151
    //   188: astore_0
    //   189: aload_0
    //   190: invokestatic 212	com/tencent/beacon/a/g/a:a	(Ljava/lang/Throwable;)V
    //   193: aload_3
    //   194: areturn
    //   195: aconst_null
    //   196: astore 6
    //   198: ldc 37
    //   200: astore 5
    //   202: aload 5
    //   204: astore 4
    //   206: aload 6
    //   208: ifnull -33 -> 175
    //   211: aload 6
    //   213: invokevirtual 209	java/io/InputStream:close	()V
    //   216: aload 5
    //   218: areturn
    //   219: astore_0
    //   220: aload_0
    //   221: invokestatic 212	com/tencent/beacon/a/g/a:a	(Ljava/lang/Throwable;)V
    //   224: aload 5
    //   226: areturn
    //   227: astore_0
    //   228: aconst_null
    //   229: astore_0
    //   230: ldc 37
    //   232: astore_3
    //   233: aload_0
    //   234: astore 4
    //   236: aload 5
    //   238: invokevirtual 167	com/tencent/beacon/a/a/c:a	()Lcom/tencent/beacon/a/a/c;
    //   241: ldc 159
    //   243: ldc 37
    //   245: invokevirtual 170	com/tencent/beacon/a/a/c:a	(Ljava/lang/String;Ljava/lang/Object;)Lcom/tencent/beacon/a/a/c;
    //   248: invokevirtual 172	com/tencent/beacon/a/a/c:b	()V
    //   251: aload_0
    //   252: astore 4
    //   254: ldc 214
    //   256: iconst_0
    //   257: anewarray 4	java/lang/Object
    //   260: invokestatic 216	com/tencent/beacon/a/g/a:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   263: aload_3
    //   264: astore 4
    //   266: aload_0
    //   267: ifnull -92 -> 175
    //   270: aload_0
    //   271: invokevirtual 209	java/io/InputStream:close	()V
    //   274: aload_3
    //   275: areturn
    //   276: astore_0
    //   277: aload_0
    //   278: invokestatic 212	com/tencent/beacon/a/g/a:a	(Ljava/lang/Throwable;)V
    //   281: aload_3
    //   282: areturn
    //   283: astore_0
    //   284: aconst_null
    //   285: astore 4
    //   287: aload 4
    //   289: ifnull +8 -> 297
    //   292: aload 4
    //   294: invokevirtual 209	java/io/InputStream:close	()V
    //   297: aload_0
    //   298: athrow
    //   299: astore_3
    //   300: aload_3
    //   301: invokestatic 212	com/tencent/beacon/a/g/a:a	(Ljava/lang/Throwable;)V
    //   304: goto -7 -> 297
    //   307: astore_0
    //   308: goto -21 -> 287
    //   311: astore_3
    //   312: ldc 37
    //   314: astore_3
    //   315: goto -82 -> 233
    //   318: astore 4
    //   320: goto -87 -> 233
    //   323: iconst_1
    //   324: istore_1
    //   325: goto -288 -> 37
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	328	0	paramContext	Context
    //   37	288	1	i1	int
    //   144	2	2	bool	boolean
    //   4	278	3	localObject1	Object
    //   299	2	3	localIOException	java.io.IOException
    //   311	1	3	localException1	java.lang.Exception
    //   314	1	3	str	String
    //   75	218	4	localObject2	Object
    //   318	1	4	localException2	java.lang.Exception
    //   9	228	5	localObject3	Object
    //   155	57	6	localContext	Context
    // Exception table:
    //   from	to	target	type
    //   168	172	188	java/io/IOException
    //   211	216	219	java/io/IOException
    //   11	21	227	java/lang/Exception
    //   25	34	227	java/lang/Exception
    //   44	59	227	java/lang/Exception
    //   59	74	227	java/lang/Exception
    //   270	274	276	java/io/IOException
    //   11	21	283	finally
    //   25	34	283	finally
    //   44	59	283	finally
    //   59	74	283	finally
    //   292	297	299	java/io/IOException
    //   77	85	307	finally
    //   88	93	307	finally
    //   96	105	307	finally
    //   108	131	307	finally
    //   138	145	307	finally
    //   236	251	307	finally
    //   254	263	307	finally
    //   77	85	311	java/lang/Exception
    //   88	93	311	java/lang/Exception
    //   96	105	311	java/lang/Exception
    //   108	131	318	java/lang/Exception
    //   138	145	318	java/lang/Exception
  }
  
  private static String d(Context paramContext)
  {
    String str = "";
    try
    {
      Object localObject = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128).metaData.get("CHANNEL_DENGTA");
      paramContext = str;
      if (localObject != null) {
        paramContext = localObject.toString();
      }
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      a.d("[core] not set 'CHANNEL_DENGTA' in manifest", new Object[0]);
    }
    return "";
  }
  
  public final String a()
  {
    int i2 = 0;
    for (;;)
    {
      try
      {
        String str = a;
        if (str != null)
        {
          if (str.equals(""))
          {
            break label89;
            if (i1 == 0)
            {
              str = a;
              return str;
            }
          }
          else
          {
            i1 = 0;
            continue;
          }
          str = this.o;
          if (str == null) {
            break label94;
          }
          i1 = i2;
          if (str.equals("")) {
            break label94;
          }
          if (i1 == 0)
          {
            str = this.o;
            continue;
          }
          str = this.i;
          continue;
        }
        i1 = 1;
      }
      finally {}
      label89:
      continue;
      label94:
      int i1 = 1;
    }
  }
  
  public final void a(long paramLong)
  {
    this.n = paramLong;
  }
  
  public final void a(String paramString)
  {
    this.m = paramString;
  }
  
  public final String b()
  {
    label52:
    for (;;)
    {
      try
      {
        String str = c;
        if (str != null)
        {
          if (str.equals(""))
          {
            break label52;
            if (i1 == 0)
            {
              str = c;
              return str;
            }
          }
          else
          {
            i1 = 0;
            continue;
          }
          str = this.p;
          continue;
        }
        int i1 = 1;
      }
      finally {}
    }
  }
  
  public final String c()
  {
    label52:
    for (;;)
    {
      try
      {
        String str = b;
        if (str != null)
        {
          if (str.equals(""))
          {
            break label52;
            if (i1 == 0)
            {
              str = b;
              return str;
            }
          }
          else
          {
            i1 = 0;
            continue;
          }
          str = this.j;
          continue;
        }
        int i1 = 1;
      }
      finally {}
    }
  }
  
  public final String d()
  {
    try
    {
      String str = this.k;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final String e()
  {
    try
    {
      String str = this.l;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final String f()
  {
    return this.f;
  }
  
  public final String g()
  {
    return this.g;
  }
  
  public final byte h()
  {
    try
    {
      byte b1 = this.h;
      return b1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final String i()
  {
    try
    {
      String str = this.m;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final long j()
  {
    try
    {
      long l1 = this.n;
      return l1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final Context k()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.a.c.b
 * JD-Core Version:    0.7.0.1
 */