package com.tencent.beacon.a.e;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Base64;
import android.util.SparseArray;
import com.tencent.beacon.a.a.a.c;
import com.tencent.beacon.a.a.b;
import java.util.Date;
import java.util.Map;
import java.util.Set;

public class a
{
  private static a a = null;
  private boolean b = false;
  private String c = "http://oth.str.mdt.qq.com:8080/analytics/upload";
  private int d = 360;
  private int e = 100;
  private SparseArray<a> f = null;
  private Map<String, String> g = null;
  private byte h = 3;
  private byte i = 2;
  private String j = "";
  private String k = "";
  private String l = "";
  private boolean m = true;
  
  private a()
  {
    this.f.put(1, new a(1));
    this.f.put(2, new a(2));
    this.f.put(3, new a(3));
  }
  
  public static a a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new a();
      }
      return a;
    }
    finally {}
  }
  
  private void c(String paramString)
  {
    try
    {
      this.k = paramString;
      this.j = Base64.encodeToString(com.tencent.beacon.a.a.a(paramString), 2);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  private void d(String paramString)
  {
    try
    {
      this.l = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final void a(int paramInt)
  {
    this.d = paramInt;
  }
  
  /* Error */
  public final void a(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ldc 96
    //   5: invokestatic 99	com/tencent/beacon/a/a:a	(Landroid/content/Context;Ljava/lang/String;)[Ljava/lang/Object;
    //   8: astore 6
    //   10: aload 6
    //   12: ifnull +55 -> 67
    //   15: aload 6
    //   17: arraylength
    //   18: iconst_3
    //   19: if_icmpne +48 -> 67
    //   22: new 101	java/util/Date
    //   25: dup
    //   26: invokespecial 102	java/util/Date:<init>	()V
    //   29: invokevirtual 106	java/util/Date:getTime	()J
    //   32: ldc2_w 107
    //   35: ldiv
    //   36: lstore 4
    //   38: aload 6
    //   40: iconst_2
    //   41: aaload
    //   42: checkcast 110	java/lang/Long
    //   45: invokevirtual 113	java/lang/Long:longValue	()J
    //   48: lstore_2
    //   49: lload_2
    //   50: lload 4
    //   52: lcmp
    //   53: ifle +14 -> 67
    //   56: aload_0
    //   57: aload 6
    //   59: iconst_1
    //   60: aaload
    //   61: checkcast 115	java/lang/String
    //   64: invokespecial 117	com/tencent/beacon/a/e/a:d	(Ljava/lang/String;)V
    //   67: aload_0
    //   68: aload_1
    //   69: invokestatic 120	com/tencent/beacon/a/a:d	(Landroid/content/Context;)Ljava/lang/String;
    //   72: invokespecial 122	com/tencent/beacon/a/e/a:c	(Ljava/lang/String;)V
    //   75: aload_0
    //   76: monitorexit
    //   77: return
    //   78: astore 7
    //   80: lconst_0
    //   81: lstore_2
    //   82: goto -33 -> 49
    //   85: astore_1
    //   86: aload_0
    //   87: monitorexit
    //   88: aload_1
    //   89: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	this	a
    //   0	90	1	paramContext	Context
    //   48	34	2	l1	long
    //   36	15	4	l2	long
    //   8	50	6	arrayOfObject	Object[]
    //   78	1	7	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   38	49	78	java/lang/Exception
    //   2	10	85	finally
    //   15	38	85	finally
    //   38	49	85	finally
    //   56	67	85	finally
    //   67	75	85	finally
  }
  
  public final void a(final Context paramContext, String paramString1, final String paramString2)
  {
    try
    {
      this.l = paramString1;
      paramContext = new Runnable()
      {
        public final void run()
        {
          String str = a.this;
          try
          {
            l1 = com.tencent.beacon.a.a.e(paramString2).getTime() / 1000L;
            long l2 = l1;
            if (l1 == 0L) {
              l2 = new Date().getTime() / 1000L + 86400L;
            }
            com.tencent.beacon.a.a.a(paramContext, "sid", new Object[] { str, Long.valueOf(l2) });
            return;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              long l1 = 0L;
            }
          }
        }
      };
      b.a().a(paramContext);
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public final void a(String paramString)
  {
    if (this.b)
    {
      com.tencent.beacon.a.g.a.c("[strategy] url has defined by api, don't change.", new Object[0]);
      return;
    }
    this.c = paramString;
  }
  
  public final void a(String paramString1, String paramString2)
  {
    try
    {
      this.b = true;
      this.c = ("http://" + paramString1 + "/analytics/upload");
      paramString1 = (a)this.f.get(1);
      if (paramString1 != null) {
        a.a(paramString1, "http://" + paramString2 + "/analytics/upload");
      }
      return;
    }
    finally {}
  }
  
  public final void a(Map<String, String> paramMap)
  {
    this.g = paramMap;
  }
  
  /* Error */
  public final a b(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 50	com/tencent/beacon/a/e/a:f	Landroid/util/SparseArray;
    //   6: ifnull +19 -> 25
    //   9: aload_0
    //   10: getfield 50	com/tencent/beacon/a/e/a:f	Landroid/util/SparseArray;
    //   13: iload_1
    //   14: invokevirtual 162	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   17: checkcast 8	com/tencent/beacon/a/e/a$a
    //   20: astore_2
    //   21: aload_0
    //   22: monitorexit
    //   23: aload_2
    //   24: areturn
    //   25: aconst_null
    //   26: astore_2
    //   27: goto -6 -> 21
    //   30: astore_2
    //   31: aload_0
    //   32: monitorexit
    //   33: aload_2
    //   34: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	35	0	this	a
    //   0	35	1	paramInt	int
    //   20	7	2	locala	a
    //   30	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	21	30	finally
  }
  
  public final String b()
  {
    if (!a().m) {}
    for (boolean bool = true;; bool = false) {
      return com.tencent.beacon.a.a.a(bool, false, false, this.c);
    }
  }
  
  public final String b(String paramString)
  {
    Object localObject = (a)this.f.get(1);
    if (localObject != null)
    {
      localObject = ((a)localObject).c();
      if (localObject != null) {
        return (String)((Map)localObject).get(paramString);
      }
    }
    return null;
  }
  
  public final int c()
  {
    return this.d;
  }
  
  public final Map<String, String> d()
  {
    return this.g;
  }
  
  /* Error */
  public final SparseArray<a> e()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 50	com/tencent/beacon/a/e/a:f	Landroid/util/SparseArray;
    //   6: ifnull +23 -> 29
    //   9: new 188	com/tencent/beacon/a/g/c
    //   12: dup
    //   13: invokespecial 189	com/tencent/beacon/a/g/c:<init>	()V
    //   16: pop
    //   17: aload_0
    //   18: getfield 50	com/tencent/beacon/a/e/a:f	Landroid/util/SparseArray;
    //   21: invokestatic 192	com/tencent/beacon/a/g/c:a	(Landroid/util/SparseArray;)Landroid/util/SparseArray;
    //   24: astore_1
    //   25: aload_0
    //   26: monitorexit
    //   27: aload_1
    //   28: areturn
    //   29: aconst_null
    //   30: astore_1
    //   31: goto -6 -> 25
    //   34: astore_1
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_1
    //   38: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	39	0	this	a
    //   24	7	1	localSparseArray	SparseArray
    //   34	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	25	34	finally
  }
  
  public final int f()
  {
    if (this.g != null)
    {
      String str = (String)this.g.get("maxStrategyQueryOneDay");
      if ((str != null) && (!str.trim().equals("")))
      {
        int n = this.e;
        try
        {
          int i1 = Integer.valueOf(str).intValue();
          return i1;
        }
        catch (Exception localException)
        {
          return n;
        }
      }
    }
    return this.e;
  }
  
  /* Error */
  public final boolean g()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 52	com/tencent/beacon/a/e/a:g	Ljava/util/Map;
    //   6: ifnull +50 -> 56
    //   9: aload_0
    //   10: getfield 52	com/tencent/beacon/a/e/a:g	Ljava/util/Map;
    //   13: ldc 214
    //   15: invokeinterface 183 2 0
    //   20: checkcast 115	java/lang/String
    //   23: astore_3
    //   24: aload_3
    //   25: ifnull +31 -> 56
    //   28: ldc 216
    //   30: aload_3
    //   31: invokevirtual 220	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   34: ifeq +22 -> 56
    //   37: invokestatic 226	java/util/Calendar:getInstance	()Ljava/util/Calendar;
    //   40: bipush 11
    //   42: invokevirtual 229	java/util/Calendar:get	(I)I
    //   45: istore_1
    //   46: iload_1
    //   47: ifne +9 -> 56
    //   50: iconst_1
    //   51: istore_2
    //   52: aload_0
    //   53: monitorexit
    //   54: iload_2
    //   55: ireturn
    //   56: iconst_0
    //   57: istore_2
    //   58: goto -6 -> 52
    //   61: astore_3
    //   62: aload_0
    //   63: monitorexit
    //   64: aload_3
    //   65: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	66	0	this	a
    //   45	2	1	n	int
    //   51	7	2	bool	boolean
    //   23	8	3	str	String
    //   61	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	24	61	finally
    //   28	46	61	finally
  }
  
  public final boolean h()
  {
    return this.m;
  }
  
  public final void i()
  {
    this.m = false;
  }
  
  public final void j()
  {
    String str = b("isSocketOnOff");
    if ((str != null) && ("n".equals(str))) {
      this.m = false;
    }
  }
  
  public final int k()
  {
    Object localObject = (a)this.f.get(1);
    if (localObject != null)
    {
      localObject = ((a)localObject).c();
      if (localObject != null)
      {
        localObject = (String)((Map)localObject).get("socketPort");
        if (localObject != null) {
          return Integer.valueOf((String)localObject).intValue();
        }
      }
    }
    return 8081;
  }
  
  public final byte l()
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
  
  public final byte m()
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
  
  public final String n()
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
  
  public final String o()
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
  
  public final String p()
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
  
  public static final class a
  {
    private final int a;
    private boolean b = false;
    private String c = "http://oth.eve.mdt.qq.com:8080/analytics/upload";
    private Map<String, String> d = null;
    private Set<String> e = null;
    private Set<String> f = null;
    
    public a(int paramInt)
    {
      this.a = paramInt;
    }
    
    /* Error */
    public static d a(Context paramContext)
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore_2
      //   2: aconst_null
      //   3: astore_3
      //   4: ldc 2
      //   6: monitorenter
      //   7: aload_0
      //   8: ifnonnull +19 -> 27
      //   11: ldc 44
      //   13: iconst_0
      //   14: anewarray 4	java/lang/Object
      //   17: invokestatic 49	com/tencent/beacon/a/g/a:c	(Ljava/lang/String;[Ljava/lang/Object;)V
      //   20: aconst_null
      //   21: astore_3
      //   22: ldc 2
      //   24: monitorexit
      //   25: aload_3
      //   26: areturn
      //   27: aload_0
      //   28: invokestatic 54	com/tencent/beacon/a/a/a/c:a	(Landroid/content/Context;)Lcom/tencent/beacon/a/a/a/c;
      //   31: invokevirtual 58	com/tencent/beacon/a/a/a/c:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
      //   34: astore_0
      //   35: aload_0
      //   36: ifnonnull +17 -> 53
      //   39: ldc 60
      //   41: iconst_0
      //   42: anewarray 4	java/lang/Object
      //   45: invokestatic 49	com/tencent/beacon/a/g/a:c	(Ljava/lang/String;[Ljava/lang/Object;)V
      //   48: aconst_null
      //   49: astore_3
      //   50: goto -28 -> 22
      //   53: aload_0
      //   54: ldc 62
      //   56: aconst_null
      //   57: getstatic 68	java/util/Locale:US	Ljava/util/Locale;
      //   60: ldc 70
      //   62: iconst_2
      //   63: anewarray 4	java/lang/Object
      //   66: dup
      //   67: iconst_0
      //   68: ldc 72
      //   70: aastore
      //   71: dup
      //   72: iconst_1
      //   73: bipush 101
      //   75: invokestatic 78	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   78: aastore
      //   79: invokestatic 84	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      //   82: aconst_null
      //   83: aconst_null
      //   84: aconst_null
      //   85: aconst_null
      //   86: invokevirtual 90	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
      //   89: astore_0
      //   90: aload_0
      //   91: ifnull +258 -> 349
      //   94: aload_0
      //   95: invokeinterface 96 1 0
      //   100: ifeq +249 -> 349
      //   103: aload_3
      //   104: astore_2
      //   105: aload_0
      //   106: ifnull +27 -> 133
      //   109: aload_3
      //   110: astore_2
      //   111: aload_0
      //   112: invokeinterface 99 1 0
      //   117: ifne +16 -> 133
      //   120: aload_0
      //   121: invokeinterface 102 1 0
      //   126: istore_1
      //   127: iload_1
      //   128: ifeq +62 -> 190
      //   131: aload_3
      //   132: astore_2
      //   133: aload_2
      //   134: ifnull +22 -> 156
      //   137: ldc 104
      //   139: iconst_1
      //   140: anewarray 4	java/lang/Object
      //   143: dup
      //   144: iconst_0
      //   145: aload_2
      //   146: getfield 108	com/tencent/beacon/a/e/d:b	I
      //   149: invokestatic 78	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   152: aastore
      //   153: invokestatic 111	com/tencent/beacon/a/g/a:g	(Ljava/lang/String;[Ljava/lang/Object;)V
      //   156: aload_2
      //   157: astore_3
      //   158: aload_0
      //   159: ifnull -137 -> 22
      //   162: aload_2
      //   163: astore_3
      //   164: aload_0
      //   165: invokeinterface 114 1 0
      //   170: ifne -148 -> 22
      //   173: aload_0
      //   174: invokeinterface 117 1 0
      //   179: aload_2
      //   180: astore_3
      //   181: goto -159 -> 22
      //   184: astore_0
      //   185: ldc 2
      //   187: monitorexit
      //   188: aload_0
      //   189: athrow
      //   190: new 106	com/tencent/beacon/a/e/d
      //   193: dup
      //   194: invokespecial 118	com/tencent/beacon/a/e/d:<init>	()V
      //   197: astore_2
      //   198: aload_2
      //   199: aload_0
      //   200: aload_0
      //   201: ldc 120
      //   203: invokeinterface 124 2 0
      //   208: invokeinterface 128 2 0
      //   213: putfield 131	com/tencent/beacon/a/e/d:a	J
      //   216: aload_2
      //   217: aload_0
      //   218: aload_0
      //   219: ldc 72
      //   221: invokeinterface 124 2 0
      //   226: invokeinterface 135 2 0
      //   231: putfield 108	com/tencent/beacon/a/e/d:b	I
      //   234: aload_2
      //   235: aload_0
      //   236: aload_0
      //   237: ldc 137
      //   239: invokeinterface 124 2 0
      //   244: invokeinterface 141 2 0
      //   249: putfield 144	com/tencent/beacon/a/e/d:c	[B
      //   252: goto -119 -> 133
      //   255: astore_3
      //   256: aconst_null
      //   257: astore_0
      //   258: aload_3
      //   259: invokestatic 147	com/tencent/beacon/a/g/a:a	(Ljava/lang/Throwable;)V
      //   262: aload_0
      //   263: astore_3
      //   264: aload_2
      //   265: ifnull -243 -> 22
      //   268: aload_0
      //   269: astore_3
      //   270: aload_2
      //   271: invokeinterface 114 1 0
      //   276: ifne -254 -> 22
      //   279: aload_2
      //   280: invokeinterface 117 1 0
      //   285: aload_0
      //   286: astore_3
      //   287: goto -265 -> 22
      //   290: aload_0
      //   291: ifnull +18 -> 309
      //   294: aload_0
      //   295: invokeinterface 114 1 0
      //   300: ifne +9 -> 309
      //   303: aload_0
      //   304: invokeinterface 117 1 0
      //   309: aload_2
      //   310: athrow
      //   311: astore_2
      //   312: goto -22 -> 290
      //   315: astore_3
      //   316: aload_2
      //   317: astore_0
      //   318: aload_3
      //   319: astore_2
      //   320: goto -30 -> 290
      //   323: astore_3
      //   324: aconst_null
      //   325: astore 4
      //   327: aload_0
      //   328: astore_2
      //   329: aload 4
      //   331: astore_0
      //   332: goto -74 -> 258
      //   335: astore 4
      //   337: aload_2
      //   338: astore_3
      //   339: aload_0
      //   340: astore_2
      //   341: aload_3
      //   342: astore_0
      //   343: aload 4
      //   345: astore_3
      //   346: goto -88 -> 258
      //   349: aconst_null
      //   350: astore_2
      //   351: goto -195 -> 156
      //   354: astore_2
      //   355: aconst_null
      //   356: astore_0
      //   357: goto -67 -> 290
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	360	0	paramContext	Context
      //   126	2	1	bool	boolean
      //   1	309	2	localObject1	Object
      //   311	6	2	localObject2	Object
      //   319	32	2	localObject3	Object
      //   354	1	2	localObject4	Object
      //   3	178	3	localObject5	Object
      //   255	4	3	localThrowable1	Throwable
      //   263	24	3	localContext	Context
      //   315	4	3	localObject6	Object
      //   323	1	3	localThrowable2	Throwable
      //   338	8	3	localObject7	Object
      //   325	5	4	localObject8	Object
      //   335	9	4	localThrowable3	Throwable
      // Exception table:
      //   from	to	target	type
      //   11	20	184	finally
      //   164	179	184	finally
      //   270	285	184	finally
      //   294	309	184	finally
      //   309	311	184	finally
      //   27	35	255	java/lang/Throwable
      //   39	48	255	java/lang/Throwable
      //   53	90	255	java/lang/Throwable
      //   94	103	311	finally
      //   111	127	311	finally
      //   137	156	311	finally
      //   190	252	311	finally
      //   258	262	315	finally
      //   94	103	323	java/lang/Throwable
      //   111	127	323	java/lang/Throwable
      //   190	252	323	java/lang/Throwable
      //   137	156	335	java/lang/Throwable
      //   27	35	354	finally
      //   39	48	354	finally
      //   53	90	354	finally
    }
    
    public static void a(Context paramContext, int paramInt, byte[] paramArrayOfByte)
    {
      if (paramArrayOfByte == null) {
        return;
      }
      d locald = new d();
      locald.b = paramInt;
      locald.c = paramArrayOfByte;
      a(paramContext, locald);
    }
    
    private static boolean a(Context paramContext, d paramd)
    {
      boolean bool = false;
      if (paramContext == null) {}
      for (;;)
      {
        try
        {
          com.tencent.beacon.a.g.a.c("[db] context or bean is null}", new Object[0]);
          return bool;
        }
        finally {}
        try
        {
          paramContext = c.a(paramContext).getWritableDatabase();
          if (paramContext != null) {
            break label73;
          }
          com.tencent.beacon.a.g.a.d("[db] get db fail!,return false ", new Object[0]);
        }
        catch (Throwable paramContext)
        {
          com.tencent.beacon.a.g.a.d("[db] error: %s", new Object[] { paramContext.toString() });
        }
        continue;
        label73:
        ContentValues localContentValues = new ContentValues();
        if (paramd.a >= 0L) {
          localContentValues.put("_id", Long.valueOf(paramd.a));
        }
        localContentValues.put("_key", Integer.valueOf(paramd.b));
        localContentValues.put("_datas", paramd.c);
        long l = paramContext.replace("t_strategy", "_id", localContentValues);
        if (l < 0L)
        {
          com.tencent.beacon.a.g.a.c("[db] insert failure! return false ", new Object[0]);
        }
        else
        {
          paramd.a = l;
          com.tencent.beacon.a.g.a.e("[db] update strategy %d true ", new Object[] { Integer.valueOf(paramd.b) });
          bool = true;
        }
      }
    }
    
    public static int b(Context paramContext)
    {
      int k = 0;
      int j = 0;
      if (paramContext == null) {}
      for (;;)
      {
        try
        {
          com.tencent.beacon.a.g.a.c("[db] params error.", new Object[0]);
          i = j;
          return i;
        }
        finally {}
        int i = k;
        try
        {
          paramContext = c.a(paramContext).getWritableDatabase();
          if (paramContext != null) {
            break label71;
          }
          i = k;
          com.tencent.beacon.a.g.a.d("get db fail!,return ", new Object[0]);
          i = j;
        }
        catch (Throwable paramContext)
        {
          com.tencent.beacon.a.g.a.a(paramContext);
        }
        continue;
        label71:
        i = k;
        j = paramContext.delete("t_strategy", String.format("%s = %d", new Object[] { "_key", Integer.valueOf(101) }), null);
        i = j;
        com.tencent.beacon.a.g.a.g("[db] key:%d , num: %d", new Object[] { Integer.valueOf(101), Integer.valueOf(j) });
        i = j;
      }
    }
    
    public final void a(String paramString)
    {
      if ((this.a == 1) && (a.a(a.a())))
      {
        com.tencent.beacon.a.g.a.c("[strategy] user event url has defined by api, don't change.", new Object[0]);
        return;
      }
      this.c = paramString;
    }
    
    public final void a(Map<String, String> paramMap)
    {
      this.d = paramMap;
    }
    
    public final void a(Set<String> paramSet)
    {
      this.e = paramSet;
    }
    
    public final void a(boolean paramBoolean)
    {
      this.b = paramBoolean;
    }
    
    public final boolean a()
    {
      return this.b;
    }
    
    public final String b()
    {
      boolean bool1 = false;
      boolean bool2;
      String str;
      if (!a.a().h())
      {
        bool2 = true;
        str = a.a().b("stopTest");
        if (str == null) {
          break label66;
        }
      }
      label66:
      for (boolean bool3 = "y".equals(str);; bool3 = false)
      {
        boolean bool4 = com.tencent.beacon.a.g.a.b;
        if (!bool3) {
          bool1 = true;
        }
        return com.tencent.beacon.a.a.a(bool2, true, bool1 & bool4, this.c);
        bool2 = false;
        break;
      }
    }
    
    public final void b(Set<String> paramSet)
    {
      this.f = paramSet;
    }
    
    public final Map<String, String> c()
    {
      return this.d;
    }
    
    public final Set<String> d()
    {
      return this.e;
    }
    
    public final int e()
    {
      return this.a;
    }
    
    public final Set<String> f()
    {
      return this.f;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.a.e.a
 * JD-Core Version:    0.7.0.1
 */