package com.tencent.beacon.core.info;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.tencent.beacon.core.a.f;
import com.tencent.beacon.core.e.c;
import com.tencent.beacon.core.e.d;
import com.tencent.beacon.core.e.j;

public class b
{
  private static volatile b a;
  public static String b;
  public static String c;
  public static String d;
  private Context e;
  private String f = "";
  private String g = "";
  private byte h = -1;
  private String i = "";
  private String j = "";
  private String k = "";
  private String l = "";
  private String m = "";
  private long n;
  private String o = "";
  private String p = "";
  
  public b(Context paramContext)
  {
    this.e = paramContext;
    e locale = e.d(paramContext);
    this.f = locale.h();
    this.g = locale.n();
    this.h = 1;
    this.j = a.a(paramContext);
    this.k = "beacon";
    this.l = "3.2.2.30";
    this.m = "unknown";
    this.o = a(paramContext);
    this.p = c.a(e(paramContext));
  }
  
  protected static String a(Context paramContext)
  {
    if (paramContext == null) {
      return "";
    }
    try
    {
      paramContext = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128).metaData;
      paramContext = paramContext.get("APPKEY_DENGTA");
      if (paramContext != null)
      {
        paramContext = paramContext.toString().trim();
        return paramContext;
      }
    }
    catch (Throwable paramContext)
    {
      d.b("[core] not set 'APPKEY_DENGTA' in manifest", new Object[0]);
    }
    return "";
  }
  
  public static b b(Context paramContext)
  {
    try
    {
      if (a == null) {
        a = new b(paramContext);
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
  
  /* Error */
  protected static String c(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 143	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   4: astore 6
    //   6: aconst_null
    //   7: astore 5
    //   9: aconst_null
    //   10: astore_3
    //   11: aconst_null
    //   12: astore_2
    //   13: aload_0
    //   14: invokestatic 148	com/tencent/beacon/core/a/f:a	(Landroid/content/Context;)Lcom/tencent/beacon/core/a/f;
    //   17: astore 4
    //   19: aload 4
    //   21: ldc 150
    //   23: ldc 32
    //   25: invokevirtual 153	com/tencent/beacon/core/a/f:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   28: astore_0
    //   29: aload_0
    //   30: invokestatic 158	com/tencent/beacon/core/e/j:b	(Ljava/lang/String;)Z
    //   33: istore_1
    //   34: iload_1
    //   35: ifeq +25 -> 60
    //   38: ldc 160
    //   40: astore_0
    //   41: aload 4
    //   43: invokevirtual 163	com/tencent/beacon/core/a/f:b	()Lcom/tencent/beacon/core/a/f;
    //   46: astore 7
    //   48: aload 7
    //   50: ldc 150
    //   52: ldc 160
    //   54: invokevirtual 166	com/tencent/beacon/core/a/f:a	(Ljava/lang/String;Ljava/lang/Object;)Lcom/tencent/beacon/core/a/f;
    //   57: invokevirtual 168	com/tencent/beacon/core/a/f:a	()V
    //   60: ldc 170
    //   62: iconst_1
    //   63: anewarray 4	java/lang/Object
    //   66: dup
    //   67: iconst_0
    //   68: aload_0
    //   69: aastore
    //   70: invokestatic 172	com/tencent/beacon/core/e/d:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   73: aload_0
    //   74: ldc 32
    //   76: invokevirtual 176	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   79: ifne +176 -> 255
    //   82: aload 6
    //   84: aload_0
    //   85: invokevirtual 182	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   88: astore_0
    //   89: aload_0
    //   90: astore_2
    //   91: aload_2
    //   92: astore_3
    //   93: new 184	java/util/Properties
    //   96: dup
    //   97: invokespecial 185	java/util/Properties:<init>	()V
    //   100: astore_0
    //   101: aload_2
    //   102: astore_3
    //   103: aload_0
    //   104: aload_2
    //   105: invokevirtual 189	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   108: aload_2
    //   109: astore_3
    //   110: aload_0
    //   111: ldc 191
    //   113: ldc 32
    //   115: invokevirtual 194	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   118: astore_0
    //   119: aload_2
    //   120: astore_3
    //   121: new 196	java/lang/StringBuilder
    //   124: dup
    //   125: invokespecial 197	java/lang/StringBuilder:<init>	()V
    //   128: astore 5
    //   130: aload_2
    //   131: astore_3
    //   132: aload 5
    //   134: ldc 199
    //   136: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: aload_0
    //   140: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   146: iconst_0
    //   147: anewarray 4	java/lang/Object
    //   150: invokestatic 206	com/tencent/beacon/core/e/d:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   153: aload_2
    //   154: astore_3
    //   155: aload_0
    //   156: invokestatic 158	com/tencent/beacon/core/e/j:b	(Ljava/lang/String;)Z
    //   159: istore_1
    //   160: aload_0
    //   161: astore_3
    //   162: aload_2
    //   163: astore 5
    //   165: iload_1
    //   166: ifne +92 -> 258
    //   169: aload_0
    //   170: astore 4
    //   172: aload_2
    //   173: ifnull +10 -> 183
    //   176: aload_2
    //   177: invokevirtual 211	java/io/InputStream:close	()V
    //   180: aload_0
    //   181: astore 4
    //   183: aload 4
    //   185: areturn
    //   186: astore_2
    //   187: aload_2
    //   188: invokestatic 214	com/tencent/beacon/core/e/d:a	(Ljava/lang/Throwable;)V
    //   191: aload_0
    //   192: areturn
    //   193: astore_0
    //   194: ldc 32
    //   196: astore_0
    //   197: aload_2
    //   198: astore_3
    //   199: aload 4
    //   201: invokevirtual 163	com/tencent/beacon/core/a/f:b	()Lcom/tencent/beacon/core/a/f;
    //   204: astore 4
    //   206: aload_2
    //   207: astore_3
    //   208: aload 4
    //   210: ldc 150
    //   212: ldc 32
    //   214: invokevirtual 166	com/tencent/beacon/core/a/f:a	(Ljava/lang/String;Ljava/lang/Object;)Lcom/tencent/beacon/core/a/f;
    //   217: invokevirtual 168	com/tencent/beacon/core/a/f:a	()V
    //   220: aload_2
    //   221: astore_3
    //   222: ldc 216
    //   224: iconst_0
    //   225: anewarray 4	java/lang/Object
    //   228: invokestatic 218	com/tencent/beacon/core/e/d:i	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   231: aload_0
    //   232: astore 4
    //   234: aload_2
    //   235: ifnull -52 -> 183
    //   238: aload_0
    //   239: astore 4
    //   241: aload_2
    //   242: invokevirtual 211	java/io/InputStream:close	()V
    //   245: aload_0
    //   246: areturn
    //   247: astore_0
    //   248: aload_0
    //   249: invokestatic 214	com/tencent/beacon/core/e/d:a	(Ljava/lang/Throwable;)V
    //   252: aload 4
    //   254: areturn
    //   255: ldc 32
    //   257: astore_3
    //   258: aload_3
    //   259: astore 4
    //   261: aload 5
    //   263: ifnull -80 -> 183
    //   266: aload_3
    //   267: astore 4
    //   269: aload 5
    //   271: invokevirtual 211	java/io/InputStream:close	()V
    //   274: aload_3
    //   275: areturn
    //   276: astore_0
    //   277: ldc 32
    //   279: astore_0
    //   280: goto -83 -> 197
    //   283: astore_0
    //   284: aload_3
    //   285: ifnull +7 -> 292
    //   288: aload_3
    //   289: invokevirtual 211	java/io/InputStream:close	()V
    //   292: aload_0
    //   293: athrow
    //   294: astore_2
    //   295: aload_2
    //   296: invokestatic 214	com/tencent/beacon/core/e/d:a	(Ljava/lang/Throwable;)V
    //   299: goto -7 -> 292
    //   302: astore_0
    //   303: goto -19 -> 284
    //   306: astore_3
    //   307: goto -110 -> 197
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	310	0	paramContext	Context
    //   33	133	1	bool	boolean
    //   12	165	2	localContext	Context
    //   186	56	2	localIOException1	java.io.IOException
    //   294	2	2	localIOException2	java.io.IOException
    //   10	279	3	localObject1	Object
    //   306	1	3	localException	Exception
    //   17	251	4	localObject2	Object
    //   7	263	5	localObject3	Object
    //   4	79	6	localAssetManager	android.content.res.AssetManager
    //   46	3	7	localf	f
    // Exception table:
    //   from	to	target	type
    //   176	180	186	java/io/IOException
    //   93	101	193	java/lang/Exception
    //   103	108	193	java/lang/Exception
    //   110	119	193	java/lang/Exception
    //   241	245	247	java/io/IOException
    //   269	274	247	java/io/IOException
    //   19	34	276	java/lang/Exception
    //   41	48	276	java/lang/Exception
    //   48	60	276	java/lang/Exception
    //   60	73	276	java/lang/Exception
    //   73	89	276	java/lang/Exception
    //   93	101	283	finally
    //   103	108	283	finally
    //   110	119	283	finally
    //   121	130	283	finally
    //   132	153	283	finally
    //   155	160	283	finally
    //   199	206	283	finally
    //   208	220	283	finally
    //   222	231	283	finally
    //   288	292	294	java/io/IOException
    //   19	34	302	finally
    //   41	48	302	finally
    //   48	60	302	finally
    //   60	73	302	finally
    //   73	89	302	finally
    //   121	130	306	java/lang/Exception
    //   132	153	306	java/lang/Exception
    //   155	160	306	java/lang/Exception
  }
  
  protected static String d(Context paramContext)
  {
    String str = "";
    try
    {
      paramContext = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128).metaData;
      Object localObject = paramContext.get("CHANNEL_DENGTA");
      paramContext = str;
      if (localObject != null) {
        paramContext = localObject.toString();
      }
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      d.b("[core] not set 'CHANNEL_DENGTA' in manifest", new Object[0]);
    }
    return "";
  }
  
  private static String e(Context paramContext)
  {
    Object localObject;
    if (paramContext == null) {
      localObject = "";
    }
    String str;
    do
    {
      return localObject;
      str = c(paramContext);
      localObject = str;
    } while (!j.b(str));
    return d(paramContext);
  }
  
  public static String i()
  {
    return "3.2.2.30";
  }
  
  /* Error */
  public String a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 228	com/tencent/beacon/core/info/b:b	Ljava/lang/String;
    //   5: invokestatic 158	com/tencent/beacon/core/e/j:b	(Ljava/lang/String;)Z
    //   8: ifne +11 -> 19
    //   11: getstatic 228	com/tencent/beacon/core/info/b:b	Ljava/lang/String;
    //   14: astore_1
    //   15: aload_0
    //   16: monitorexit
    //   17: aload_1
    //   18: areturn
    //   19: aload_0
    //   20: getfield 50	com/tencent/beacon/core/info/b:o	Ljava/lang/String;
    //   23: invokestatic 158	com/tencent/beacon/core/e/j:b	(Ljava/lang/String;)Z
    //   26: ifne +11 -> 37
    //   29: aload_0
    //   30: getfield 50	com/tencent/beacon/core/info/b:o	Ljava/lang/String;
    //   33: astore_1
    //   34: goto -19 -> 15
    //   37: aload_0
    //   38: invokevirtual 230	com/tencent/beacon/core/info/b:b	()Ljava/lang/String;
    //   41: astore_1
    //   42: goto -27 -> 15
    //   45: astore_1
    //   46: aload_0
    //   47: monitorexit
    //   48: aload_1
    //   49: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	50	0	this	b
    //   14	28	1	str	String
    //   45	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	15	45	finally
    //   19	34	45	finally
    //   37	42	45	finally
  }
  
  /* Error */
  public String a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 232	com/tencent/beacon/core/info/b:c	Ljava/lang/String;
    //   5: invokestatic 158	com/tencent/beacon/core/e/j:b	(Ljava/lang/String;)Z
    //   8: ifne +11 -> 19
    //   11: getstatic 232	com/tencent/beacon/core/info/b:c	Ljava/lang/String;
    //   14: astore_1
    //   15: aload_0
    //   16: monitorexit
    //   17: aload_1
    //   18: areturn
    //   19: aload_0
    //   20: getfield 42	com/tencent/beacon/core/info/b:j	Ljava/lang/String;
    //   23: astore_1
    //   24: goto -9 -> 15
    //   27: astore_1
    //   28: aload_0
    //   29: monitorexit
    //   30: aload_1
    //   31: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	32	0	this	b
    //   0	32	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   2	15	27	finally
    //   19	24	27	finally
  }
  
  public void a(long paramLong)
  {
    try
    {
      this.n = paramLong;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public String b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 54	com/tencent/beacon/core/info/b:e	Landroid/content/Context;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnonnull +10 -> 18
    //   11: ldc 32
    //   13: astore_1
    //   14: aload_0
    //   15: monitorexit
    //   16: aload_1
    //   17: areturn
    //   18: aload_0
    //   19: aload_1
    //   20: invokevirtual 95	android/content/Context:getPackageName	()Ljava/lang/String;
    //   23: putfield 40	com/tencent/beacon/core/info/b:i	Ljava/lang/String;
    //   26: aload_0
    //   27: getfield 40	com/tencent/beacon/core/info/b:i	Ljava/lang/String;
    //   30: astore_1
    //   31: goto -17 -> 14
    //   34: astore_1
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_1
    //   38: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	39	0	this	b
    //   6	25	1	localObject1	Object
    //   34	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	34	finally
    //   18	31	34	finally
  }
  
  /* Error */
  public String b(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 237	com/tencent/beacon/core/info/b:d	Ljava/lang/String;
    //   5: invokestatic 158	com/tencent/beacon/core/e/j:b	(Ljava/lang/String;)Z
    //   8: ifne +11 -> 19
    //   11: getstatic 237	com/tencent/beacon/core/info/b:d	Ljava/lang/String;
    //   14: astore_1
    //   15: aload_0
    //   16: monitorexit
    //   17: aload_1
    //   18: areturn
    //   19: aload_0
    //   20: getfield 52	com/tencent/beacon/core/info/b:p	Ljava/lang/String;
    //   23: astore_1
    //   24: goto -9 -> 15
    //   27: astore_1
    //   28: aload_0
    //   29: monitorexit
    //   30: aload_1
    //   31: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	32	0	this	b
    //   0	32	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   2	15	27	finally
    //   19	24	27	finally
  }
  
  public Context c()
  {
    try
    {
      Context localContext = this.e;
      return localContext;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void c(String paramString)
  {
    this.m = paramString;
  }
  
  public String d()
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
  
  public String e()
  {
    return this.f;
  }
  
  public String f()
  {
    return this.g;
  }
  
  public byte g()
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
  
  public String h()
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
  
  public long j()
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
  
  public boolean k()
  {
    bool2 = true;
    bool1 = false;
    boolean bool3 = false;
    try
    {
      localObject1 = this.e;
      if (localObject1 != null) {
        break label25;
      }
      bool1 = bool3;
    }
    finally
    {
      for (;;)
      {
        try
        {
          localObject1 = f.a((Context)localObject1).c();
          localObject3 = new StringBuilder().append(a.c(this.e));
          localObject3 = ((StringBuilder)localObject3).append("_");
          localObject3 = "SDKVER_DENGTA";
          str = ((SharedPreferences)localObject1).getString((String)localObject3, null);
          if (str != null)
          {
            bool3 = str.equals(this.l);
            if (bool3) {
              continue;
            }
          }
        }
        catch (Exception localException1)
        {
          Object localObject1;
          bool1 = false;
        }
        try
        {
          ((SharedPreferences)localObject1).edit().putString((String)localObject3, this.l).apply();
          bool1 = true;
          d.a("[core] isNewSDKVersion: %s", new Object[] { Boolean.valueOf(bool1) });
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            bool1 = bool2;
          }
        }
      }
      localObject2 = finally;
    }
    return bool1;
    for (;;)
    {
      label25:
      Object localObject3;
      String str;
      d.b("[core] updateLocalSDKVER fail!", new Object[0]);
      d.a(localException1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.info.b
 * JD-Core Version:    0.7.0.1
 */