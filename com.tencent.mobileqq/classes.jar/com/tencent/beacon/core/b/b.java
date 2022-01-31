package com.tencent.beacon.core.b;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.tencent.beacon.upload.TunnelInfo;
import java.util.HashMap;
import java.util.Map;

public final class b
{
  public static String a;
  public static String b;
  public static String c;
  private static b d = null;
  private Context e = null;
  private Map<String, TunnelInfo> f = new HashMap();
  private String g = "";
  private String h = "";
  private byte i = -1;
  private String j = "";
  private String k = "";
  private String l = "";
  private String m = "";
  private String n = "";
  private long o = 0L;
  private String p = "";
  private String q = "";
  private String r = "";
  
  /* Error */
  public static b a(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: ifnonnull +10 -> 14
    //   7: aconst_null
    //   8: astore_0
    //   9: ldc 2
    //   11: monitorexit
    //   12: aload_0
    //   13: areturn
    //   14: getstatic 33	com/tencent/beacon/core/b/b:d	Lcom/tencent/beacon/core/b/b;
    //   17: ifnonnull +123 -> 140
    //   20: new 2	com/tencent/beacon/core/b/b
    //   23: dup
    //   24: invokespecial 72	com/tencent/beacon/core/b/b:<init>	()V
    //   27: astore_1
    //   28: aload_1
    //   29: putstatic 33	com/tencent/beacon/core/b/b:d	Lcom/tencent/beacon/core/b/b;
    //   32: aload_1
    //   33: aload_0
    //   34: putfield 39	com/tencent/beacon/core/b/b:e	Landroid/content/Context;
    //   37: aload_0
    //   38: invokestatic 77	com/tencent/beacon/core/b/d:a	(Landroid/content/Context;)Lcom/tencent/beacon/core/b/d;
    //   41: pop
    //   42: getstatic 33	com/tencent/beacon/core/b/b:d	Lcom/tencent/beacon/core/b/b;
    //   45: invokestatic 80	com/tencent/beacon/core/b/d:b	()Ljava/lang/String;
    //   48: putfield 48	com/tencent/beacon/core/b/b:g	Ljava/lang/String;
    //   51: getstatic 33	com/tencent/beacon/core/b/b:d	Lcom/tencent/beacon/core/b/b;
    //   54: invokestatic 82	com/tencent/beacon/core/b/d:a	()Ljava/lang/String;
    //   57: putfield 50	com/tencent/beacon/core/b/b:h	Ljava/lang/String;
    //   60: getstatic 33	com/tencent/beacon/core/b/b:d	Lcom/tencent/beacon/core/b/b;
    //   63: iconst_1
    //   64: putfield 52	com/tencent/beacon/core/b/b:i	B
    //   67: getstatic 33	com/tencent/beacon/core/b/b:d	Lcom/tencent/beacon/core/b/b;
    //   70: aload_0
    //   71: invokestatic 87	com/tencent/beacon/core/b/a:c	(Landroid/content/Context;)Ljava/lang/String;
    //   74: putfield 54	com/tencent/beacon/core/b/b:j	Ljava/lang/String;
    //   77: getstatic 33	com/tencent/beacon/core/b/b:d	Lcom/tencent/beacon/core/b/b;
    //   80: aload_0
    //   81: invokestatic 89	com/tencent/beacon/core/b/a:e	(Landroid/content/Context;)Ljava/lang/String;
    //   84: putfield 56	com/tencent/beacon/core/b/b:k	Ljava/lang/String;
    //   87: getstatic 33	com/tencent/beacon/core/b/b:d	Lcom/tencent/beacon/core/b/b;
    //   90: ldc 91
    //   92: putfield 58	com/tencent/beacon/core/b/b:l	Ljava/lang/String;
    //   95: getstatic 33	com/tencent/beacon/core/b/b:d	Lcom/tencent/beacon/core/b/b;
    //   98: ldc 93
    //   100: putfield 60	com/tencent/beacon/core/b/b:m	Ljava/lang/String;
    //   103: getstatic 33	com/tencent/beacon/core/b/b:d	Lcom/tencent/beacon/core/b/b;
    //   106: ldc 95
    //   108: putfield 62	com/tencent/beacon/core/b/b:n	Ljava/lang/String;
    //   111: getstatic 33	com/tencent/beacon/core/b/b:d	Lcom/tencent/beacon/core/b/b;
    //   114: aload_0
    //   115: invokestatic 97	com/tencent/beacon/core/b/b:b	(Landroid/content/Context;)Ljava/lang/String;
    //   118: putfield 66	com/tencent/beacon/core/b/b:p	Ljava/lang/String;
    //   121: getstatic 33	com/tencent/beacon/core/b/b:d	Lcom/tencent/beacon/core/b/b;
    //   124: astore_3
    //   125: aload_0
    //   126: ifnonnull +21 -> 147
    //   129: ldc 46
    //   131: astore_1
    //   132: aload_3
    //   133: aload_1
    //   134: invokestatic 102	com/tencent/beacon/core/d/a:a	(Ljava/lang/String;)Ljava/lang/String;
    //   137: putfield 68	com/tencent/beacon/core/b/b:q	Ljava/lang/String;
    //   140: getstatic 33	com/tencent/beacon/core/b/b:d	Lcom/tencent/beacon/core/b/b;
    //   143: astore_0
    //   144: goto -135 -> 9
    //   147: aload_0
    //   148: invokestatic 103	com/tencent/beacon/core/b/b:c	(Landroid/content/Context;)Ljava/lang/String;
    //   151: astore_2
    //   152: aload_2
    //   153: astore_1
    //   154: aload_2
    //   155: invokestatic 108	com/tencent/beacon/core/d/h:a	(Ljava/lang/String;)Z
    //   158: ifeq -26 -> 132
    //   161: aload_0
    //   162: invokestatic 110	com/tencent/beacon/core/b/b:d	(Landroid/content/Context;)Ljava/lang/String;
    //   165: astore_1
    //   166: goto -34 -> 132
    //   169: astore_0
    //   170: ldc 2
    //   172: monitorexit
    //   173: aload_0
    //   174: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	175	0	paramContext	Context
    //   27	139	1	localObject	Object
    //   151	4	2	str	String
    //   124	9	3	localb	b
    // Exception table:
    //   from	to	target	type
    //   14	125	169	finally
    //   132	140	169	finally
    //   140	144	169	finally
    //   147	152	169	finally
    //   154	166	169	finally
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
      com.tencent.beacon.core.d.b.d("[core] not set 'APPKEY_DENGTA' in manifest", new Object[0]);
    }
    return "";
  }
  
  /* Error */
  private static String c(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 164	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   4: astore_3
    //   5: aload_0
    //   6: invokestatic 169	com/tencent/beacon/core/a/c:a	(Landroid/content/Context;)Lcom/tencent/beacon/core/a/c;
    //   9: astore 4
    //   11: aload 4
    //   13: ldc 171
    //   15: ldc 46
    //   17: invokevirtual 174	com/tencent/beacon/core/a/c:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   20: astore_2
    //   21: aload_2
    //   22: astore_0
    //   23: aload_2
    //   24: invokestatic 108	com/tencent/beacon/core/d/h:a	(Ljava/lang/String;)Z
    //   27: ifeq +21 -> 48
    //   30: ldc 176
    //   32: astore_0
    //   33: aload 4
    //   35: invokevirtual 179	com/tencent/beacon/core/a/c:a	()Lcom/tencent/beacon/core/a/c;
    //   38: ldc 171
    //   40: ldc 176
    //   42: invokevirtual 182	com/tencent/beacon/core/a/c:a	(Ljava/lang/String;Ljava/lang/Object;)Lcom/tencent/beacon/core/a/c;
    //   45: invokevirtual 184	com/tencent/beacon/core/a/c:b	()V
    //   48: ldc 186
    //   50: iconst_1
    //   51: anewarray 4	java/lang/Object
    //   54: dup
    //   55: iconst_0
    //   56: aload_0
    //   57: aastore
    //   58: invokestatic 188	com/tencent/beacon/core/d/b:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   61: aload_0
    //   62: ldc 46
    //   64: invokevirtual 192	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   67: ifne +100 -> 167
    //   70: aload_3
    //   71: aload_0
    //   72: invokevirtual 198	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   75: astore_0
    //   76: aload_0
    //   77: astore_3
    //   78: new 200	java/util/Properties
    //   81: dup
    //   82: invokespecial 201	java/util/Properties:<init>	()V
    //   85: astore_2
    //   86: aload_0
    //   87: astore_3
    //   88: aload_2
    //   89: aload_0
    //   90: invokevirtual 205	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   93: aload_0
    //   94: astore_3
    //   95: aload_2
    //   96: ldc 207
    //   98: ldc 46
    //   100: invokevirtual 210	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   103: astore_2
    //   104: aload_0
    //   105: astore_3
    //   106: new 212	java/lang/StringBuilder
    //   109: dup
    //   110: ldc 214
    //   112: invokespecial 217	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   115: aload_2
    //   116: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: invokevirtual 222	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   122: iconst_0
    //   123: anewarray 4	java/lang/Object
    //   126: invokestatic 224	com/tencent/beacon/core/d/b:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   129: aload_0
    //   130: astore_3
    //   131: aload_2
    //   132: invokestatic 108	com/tencent/beacon/core/d/h:a	(Ljava/lang/String;)Z
    //   135: istore_1
    //   136: aload_2
    //   137: astore 4
    //   139: aload_0
    //   140: astore 5
    //   142: iload_1
    //   143: ifne +31 -> 174
    //   146: aload_2
    //   147: astore_3
    //   148: aload_0
    //   149: ifnull +9 -> 158
    //   152: aload_0
    //   153: invokevirtual 229	java/io/InputStream:close	()V
    //   156: aload_2
    //   157: astore_3
    //   158: aload_3
    //   159: areturn
    //   160: astore_0
    //   161: aload_0
    //   162: invokestatic 232	com/tencent/beacon/core/d/b:a	(Ljava/lang/Throwable;)V
    //   165: aload_2
    //   166: areturn
    //   167: aconst_null
    //   168: astore 5
    //   170: ldc 46
    //   172: astore 4
    //   174: aload 4
    //   176: astore_3
    //   177: aload 5
    //   179: ifnull -21 -> 158
    //   182: aload 5
    //   184: invokevirtual 229	java/io/InputStream:close	()V
    //   187: aload 4
    //   189: areturn
    //   190: astore_0
    //   191: aload_0
    //   192: invokestatic 232	com/tencent/beacon/core/d/b:a	(Ljava/lang/Throwable;)V
    //   195: aload 4
    //   197: areturn
    //   198: astore_0
    //   199: aconst_null
    //   200: astore_0
    //   201: ldc 46
    //   203: astore_2
    //   204: aload_0
    //   205: astore_3
    //   206: aload 4
    //   208: invokevirtual 179	com/tencent/beacon/core/a/c:a	()Lcom/tencent/beacon/core/a/c;
    //   211: ldc 171
    //   213: ldc 46
    //   215: invokevirtual 182	com/tencent/beacon/core/a/c:a	(Ljava/lang/String;Ljava/lang/Object;)Lcom/tencent/beacon/core/a/c;
    //   218: invokevirtual 184	com/tencent/beacon/core/a/c:b	()V
    //   221: aload_0
    //   222: astore_3
    //   223: ldc 234
    //   225: iconst_0
    //   226: anewarray 4	java/lang/Object
    //   229: invokestatic 236	com/tencent/beacon/core/d/b:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   232: aload_2
    //   233: astore_3
    //   234: aload_0
    //   235: ifnull -77 -> 158
    //   238: aload_0
    //   239: invokevirtual 229	java/io/InputStream:close	()V
    //   242: aload_2
    //   243: areturn
    //   244: astore_0
    //   245: aload_0
    //   246: invokestatic 232	com/tencent/beacon/core/d/b:a	(Ljava/lang/Throwable;)V
    //   249: aload_2
    //   250: areturn
    //   251: astore_0
    //   252: aconst_null
    //   253: astore_3
    //   254: aload_3
    //   255: ifnull +7 -> 262
    //   258: aload_3
    //   259: invokevirtual 229	java/io/InputStream:close	()V
    //   262: aload_0
    //   263: athrow
    //   264: astore_2
    //   265: aload_2
    //   266: invokestatic 232	com/tencent/beacon/core/d/b:a	(Ljava/lang/Throwable;)V
    //   269: goto -7 -> 262
    //   272: astore_0
    //   273: goto -19 -> 254
    //   276: astore_2
    //   277: ldc 46
    //   279: astore_2
    //   280: goto -76 -> 204
    //   283: astore_3
    //   284: goto -80 -> 204
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	287	0	paramContext	Context
    //   135	8	1	bool	boolean
    //   20	230	2	localObject1	Object
    //   264	2	2	localIOException	java.io.IOException
    //   276	1	2	localException1	java.lang.Exception
    //   279	1	2	str	String
    //   4	255	3	localObject2	Object
    //   283	1	3	localException2	java.lang.Exception
    //   9	198	4	localObject3	Object
    //   140	43	5	localContext	Context
    // Exception table:
    //   from	to	target	type
    //   152	156	160	java/io/IOException
    //   182	187	190	java/io/IOException
    //   11	21	198	java/lang/Exception
    //   23	30	198	java/lang/Exception
    //   33	48	198	java/lang/Exception
    //   48	76	198	java/lang/Exception
    //   238	242	244	java/io/IOException
    //   11	21	251	finally
    //   23	30	251	finally
    //   33	48	251	finally
    //   48	76	251	finally
    //   258	262	264	java/io/IOException
    //   78	86	272	finally
    //   88	93	272	finally
    //   95	104	272	finally
    //   106	129	272	finally
    //   131	136	272	finally
    //   206	221	272	finally
    //   223	232	272	finally
    //   78	86	276	java/lang/Exception
    //   88	93	276	java/lang/Exception
    //   95	104	276	java/lang/Exception
    //   106	129	283	java/lang/Exception
    //   131	136	283	java/lang/Exception
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
      com.tencent.beacon.core.d.b.d("[core] not set 'CHANNEL_DENGTA' in manifest", new Object[0]);
    }
    return "";
  }
  
  public final String a()
  {
    try
    {
      String str = this.j;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public final String a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic 108	com/tencent/beacon/core/d/h:a	(Ljava/lang/String;)Z
    //   6: ifne +40 -> 46
    //   9: aload_0
    //   10: getfield 44	com/tencent/beacon/core/b/b:f	Ljava/util/Map;
    //   13: aload_1
    //   14: invokeinterface 245 2 0
    //   19: checkcast 247	com/tencent/beacon/upload/TunnelInfo
    //   22: astore_1
    //   23: aload_1
    //   24: ifnull +22 -> 46
    //   27: aload_1
    //   28: getfield 250	com/tencent/beacon/upload/TunnelInfo:channel	Ljava/lang/String;
    //   31: invokestatic 108	com/tencent/beacon/core/d/h:a	(Ljava/lang/String;)Z
    //   34: ifne +12 -> 46
    //   37: aload_1
    //   38: getfield 250	com/tencent/beacon/upload/TunnelInfo:channel	Ljava/lang/String;
    //   41: astore_1
    //   42: aload_0
    //   43: monitorexit
    //   44: aload_1
    //   45: areturn
    //   46: getstatic 252	com/tencent/beacon/core/b/b:c	Ljava/lang/String;
    //   49: invokestatic 108	com/tencent/beacon/core/d/h:a	(Ljava/lang/String;)Z
    //   52: ifne +10 -> 62
    //   55: getstatic 252	com/tencent/beacon/core/b/b:c	Ljava/lang/String;
    //   58: astore_1
    //   59: goto -17 -> 42
    //   62: aload_0
    //   63: getfield 68	com/tencent/beacon/core/b/b:q	Ljava/lang/String;
    //   66: astore_1
    //   67: goto -25 -> 42
    //   70: astore_1
    //   71: aload_0
    //   72: monitorexit
    //   73: aload_1
    //   74: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	75	0	this	b
    //   0	75	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   2	23	70	finally
    //   27	42	70	finally
    //   46	59	70	finally
    //   62	67	70	finally
  }
  
  public final void a(long paramLong)
  {
    this.o = paramLong;
  }
  
  public final void a(String paramString, TunnelInfo paramTunnelInfo)
  {
    this.f.put(paramString, paramTunnelInfo);
  }
  
  /* Error */
  public final String b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 260	com/tencent/beacon/core/b/b:a	Ljava/lang/String;
    //   5: invokestatic 108	com/tencent/beacon/core/d/h:a	(Ljava/lang/String;)Z
    //   8: ifne +11 -> 19
    //   11: getstatic 260	com/tencent/beacon/core/b/b:a	Ljava/lang/String;
    //   14: astore_1
    //   15: aload_0
    //   16: monitorexit
    //   17: aload_1
    //   18: areturn
    //   19: aload_0
    //   20: getfield 66	com/tencent/beacon/core/b/b:p	Ljava/lang/String;
    //   23: invokestatic 108	com/tencent/beacon/core/d/h:a	(Ljava/lang/String;)Z
    //   26: ifne +11 -> 37
    //   29: aload_0
    //   30: getfield 66	com/tencent/beacon/core/b/b:p	Ljava/lang/String;
    //   33: astore_1
    //   34: goto -19 -> 15
    //   37: aload_0
    //   38: getfield 54	com/tencent/beacon/core/b/b:j	Ljava/lang/String;
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
  public final String b(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic 108	com/tencent/beacon/core/d/h:a	(Ljava/lang/String;)Z
    //   6: ifne +40 -> 46
    //   9: aload_0
    //   10: getfield 44	com/tencent/beacon/core/b/b:f	Ljava/util/Map;
    //   13: aload_1
    //   14: invokeinterface 245 2 0
    //   19: checkcast 247	com/tencent/beacon/upload/TunnelInfo
    //   22: astore_1
    //   23: aload_1
    //   24: ifnull +22 -> 46
    //   27: aload_1
    //   28: getfield 263	com/tencent/beacon/upload/TunnelInfo:version	Ljava/lang/String;
    //   31: invokestatic 108	com/tencent/beacon/core/d/h:a	(Ljava/lang/String;)Z
    //   34: ifne +12 -> 46
    //   37: aload_1
    //   38: getfield 263	com/tencent/beacon/upload/TunnelInfo:version	Ljava/lang/String;
    //   41: astore_1
    //   42: aload_0
    //   43: monitorexit
    //   44: aload_1
    //   45: areturn
    //   46: getstatic 265	com/tencent/beacon/core/b/b:b	Ljava/lang/String;
    //   49: invokestatic 108	com/tencent/beacon/core/d/h:a	(Ljava/lang/String;)Z
    //   52: ifne +10 -> 62
    //   55: getstatic 265	com/tencent/beacon/core/b/b:b	Ljava/lang/String;
    //   58: astore_1
    //   59: goto -17 -> 42
    //   62: aload_0
    //   63: getfield 56	com/tencent/beacon/core/b/b:k	Ljava/lang/String;
    //   66: astore_1
    //   67: goto -25 -> 42
    //   70: astore_1
    //   71: aload_0
    //   72: monitorexit
    //   73: aload_1
    //   74: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	75	0	this	b
    //   0	75	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   2	23	70	finally
    //   27	42	70	finally
    //   46	59	70	finally
    //   62	67	70	finally
  }
  
  public final String c()
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
  
  public final void c(String paramString)
  {
    this.n = paramString;
  }
  
  public final String d()
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
  
  public final void d(String paramString)
  {
    if (paramString != null)
    {
      this.r = paramString;
      com.tencent.beacon.core.d.b.b("[core] -> JavaScript clientID:" + this.r, new Object[0]);
    }
  }
  
  public final String e()
  {
    return this.g;
  }
  
  public final String f()
  {
    return this.h;
  }
  
  public final byte g()
  {
    try
    {
      byte b1 = this.i;
      return b1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final String h()
  {
    try
    {
      String str = this.n;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final long i()
  {
    try
    {
      long l1 = this.o;
      return l1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final Context j()
  {
    return this.e;
  }
  
  public final String k()
  {
    return this.r;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.beacon.core.b.b
 * JD-Core Version:    0.7.0.1
 */