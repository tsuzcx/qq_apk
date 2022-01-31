import android.content.Context;
import android.text.TextUtils;
import android.util.LruCache;
import com.tencent.qqmini.sdk.core.cache.Storage.2;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class beix
{
  public static final Object a;
  private static final ConcurrentHashMap<String, beix> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private LruCache<String, String> jdField_a_of_type_AndroidUtilLruCache;
  private beip jdField_a_of_type_Beip;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<Context> jdField_a_of_type_JavaLangRefWeakReference;
  private String b;
  
  static
  {
    jdField_a_of_type_JavaLangObject = new Object();
  }
  
  private beix(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      String str = a(paramContext.getCacheDir().getAbsolutePath(), paramString1, paramString2);
      if (!TextUtils.isEmpty(str))
      {
        this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
        this.jdField_a_of_type_JavaLangString = paramString1;
        this.b = paramString2;
        this.jdField_a_of_type_Beip = beip.a(new File(str), 1, 1, 10485760L);
        this.jdField_a_of_type_AndroidUtilLruCache = new beiy(this, 10485760);
        return;
      }
      betc.d("Storage", "[Storage] can not create dir");
      return;
    }
    catch (Throwable paramContext)
    {
      betc.d("Storage", paramContext.getMessage(), paramContext);
    }
  }
  
  public static long a(String paramString)
  {
    try
    {
      paramString = a(String.valueOf(((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getAccount()), paramString);
      paramString = (beix)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      if (paramString == null) {
        return -1L;
      }
      long l = paramString.b();
      return l;
    }
    catch (Exception paramString)
    {
      betc.d("Storage", "getCurrentStorageSize failed:", paramString);
    }
    return -1L;
  }
  
  /* Error */
  public static beix a(Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: getstatic 24	beix:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   5: astore 5
    //   7: aload 5
    //   9: monitorenter
    //   10: aload_0
    //   11: ifnull +87 -> 98
    //   14: aload_1
    //   15: aload_2
    //   16: invokestatic 122	beix:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   19: astore 6
    //   21: getstatic 24	beix:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   24: aload 6
    //   26: invokevirtual 125	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   29: checkcast 2	beix
    //   32: astore 4
    //   34: aload 4
    //   36: astore_3
    //   37: aload 4
    //   39: ifnonnull +59 -> 98
    //   42: getstatic 27	beix:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   45: astore 7
    //   47: aload 7
    //   49: monitorenter
    //   50: getstatic 24	beix:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   53: aload_1
    //   54: aload_2
    //   55: invokestatic 122	beix:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   58: invokevirtual 125	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   61: checkcast 2	beix
    //   64: astore 4
    //   66: aload 4
    //   68: astore_3
    //   69: aload 4
    //   71: ifnonnull +24 -> 95
    //   74: new 2	beix
    //   77: dup
    //   78: aload_0
    //   79: aload_1
    //   80: aload_2
    //   81: invokespecial 137	beix:<init>	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   84: astore_3
    //   85: getstatic 24	beix:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   88: aload 6
    //   90: aload_3
    //   91: invokevirtual 141	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   94: pop
    //   95: aload 7
    //   97: monitorexit
    //   98: aload 5
    //   100: monitorexit
    //   101: aload_3
    //   102: areturn
    //   103: astore_0
    //   104: aload 7
    //   106: monitorexit
    //   107: aload_0
    //   108: athrow
    //   109: astore_0
    //   110: aload 5
    //   112: monitorexit
    //   113: aload_0
    //   114: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	115	0	paramContext	Context
    //   0	115	1	paramString1	String
    //   0	115	2	paramString2	String
    //   1	101	3	localObject1	Object
    //   32	38	4	localbeix	beix
    //   5	106	5	localConcurrentHashMap	ConcurrentHashMap
    //   19	70	6	str	String
    // Exception table:
    //   from	to	target	type
    //   50	66	103	finally
    //   74	95	103	finally
    //   95	98	103	finally
    //   104	107	103	finally
    //   14	34	109	finally
    //   42	50	109	finally
    //   98	101	109	finally
    //   107	109	109	finally
    //   110	113	109	finally
  }
  
  private static String a(String paramString1, String paramString2)
  {
    return paramString1 + "_" + paramString2;
  }
  
  public static String a(String paramString1, String paramString2, String paramString3)
  {
    if (!TextUtils.isEmpty(paramString3))
    {
      paramString1 = paramString1 + "/mini";
      StringBuilder localStringBuilder = new StringBuilder().append(paramString1).append("/");
      paramString1 = paramString2;
      if (TextUtils.isEmpty(paramString2)) {
        paramString1 = "default";
      }
      paramString1 = paramString1;
      paramString1 = paramString1 + "/" + paramString3;
      paramString2 = new File(paramString1);
      if ((paramString2.exists()) || (paramString2.mkdirs())) {}
    }
    else
    {
      return null;
    }
    betc.b("Storage", "[Storage] getCacheDir: " + paramString1);
    return paramString1;
  }
  
  private void b()
  {
    String str;
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null))
    {
      str = a(((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getCacheDir().getAbsolutePath(), this.jdField_a_of_type_JavaLangString, this.b);
      if (!TextUtils.isEmpty(str)) {
        this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(this.jdField_a_of_type_JavaLangRefWeakReference.get());
      }
    }
    try
    {
      this.jdField_a_of_type_Beip = beip.a(new File(str), 1, 1, 10485760L);
      return;
    }
    catch (Throwable localThrowable)
    {
      betc.d("Storage", localThrowable.getMessage(), localThrowable);
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Beip != null) {
      return (int)Math.ceil(this.jdField_a_of_type_Beip.a() / 1000L);
    }
    return -1;
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_Beip != null) {
      return (int)Math.ceil(this.jdField_a_of_type_Beip.b() / 1000.0D);
    }
    return -1L;
  }
  
  public Set<String> a()
  {
    if ((this.jdField_a_of_type_Beip != null) && (!this.jdField_a_of_type_Beip.a())) {
      return this.jdField_a_of_type_Beip.a();
    }
    return null;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Beip != null) {}
    try
    {
      betc.d("Storage", "------mDiskCache.closed-----");
      this.jdField_a_of_type_Beip.close();
      if (this.jdField_a_of_type_AndroidUtilLruCache != null) {
        this.jdField_a_of_type_AndroidUtilLruCache.evictAll();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        betc.d("Storage", localThrowable.getMessage(), localThrowable);
      }
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, beiz parambeiz)
  {
    bejn.a(new Storage.2(this, paramString2, paramString3, parambeiz, paramString1), 16, null, true);
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_AndroidUtilLruCache != null) {
      this.jdField_a_of_type_AndroidUtilLruCache.trimToSize(0);
    }
    if (this.jdField_a_of_type_Beip != null) {}
    try
    {
      this.jdField_a_of_type_Beip.b();
      return true;
    }
    catch (Throwable localThrowable)
    {
      betc.d("Storage", localThrowable.getMessage(), localThrowable);
    }
    return false;
  }
  
  public boolean a(String paramString)
  {
    boolean bool = false;
    if (!TextUtils.isEmpty(paramString))
    {
      if (this.jdField_a_of_type_AndroidUtilLruCache != null) {
        this.jdField_a_of_type_AndroidUtilLruCache.remove(paramString);
      }
      if (this.jdField_a_of_type_Beip == null) {}
    }
    try
    {
      this.jdField_a_of_type_Beip.a(paramString);
      bool = true;
      return bool;
    }
    catch (Throwable paramString)
    {
      betc.d("Storage", paramString.getMessage(), paramString);
    }
    return false;
  }
  
  /* Error */
  public boolean a(String arg1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: aload_3
    //   1: aload_2
    //   2: invokestatic 236	beiw:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   5: astore_2
    //   6: aload_2
    //   7: ifnull +32 -> 39
    //   10: aload_2
    //   11: invokevirtual 239	java/lang/String:length	()I
    //   14: ldc 240
    //   16: if_icmplt +23 -> 39
    //   19: ldc 85
    //   21: ldc 242
    //   23: invokestatic 93	betc:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   26: iconst_0
    //   27: ireturn
    //   28: astore_1
    //   29: ldc 85
    //   31: ldc 244
    //   33: aload_1
    //   34: invokestatic 99	betc:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   37: iconst_0
    //   38: ireturn
    //   39: aload_0
    //   40: getfield 75	beix:jdField_a_of_type_Beip	Lbeip;
    //   43: ifnull +158 -> 201
    //   46: aload_0
    //   47: getfield 75	beix:jdField_a_of_type_Beip	Lbeip;
    //   50: invokevirtual 194	beip:a	()Z
    //   53: ifeq +7 -> 60
    //   56: aload_0
    //   57: invokespecial 174	beix:b	()V
    //   60: aload_2
    //   61: invokestatic 52	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   64: ifne +123 -> 187
    //   67: aload_0
    //   68: invokevirtual 245	beix:a	()J
    //   71: ldc2_w 181
    //   74: lmul
    //   75: aload_2
    //   76: invokevirtual 239	java/lang/String:length	()I
    //   79: i2l
    //   80: ladd
    //   81: ldc2_w 67
    //   84: lcmp
    //   85: ifle +33 -> 118
    //   88: ldc 85
    //   90: ldc 242
    //   92: invokestatic 93	betc:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   95: aload_0
    //   96: getfield 75	beix:jdField_a_of_type_Beip	Lbeip;
    //   99: ifnull -73 -> 26
    //   102: aload_0
    //   103: getfield 75	beix:jdField_a_of_type_Beip	Lbeip;
    //   106: invokevirtual 247	beip:a	()V
    //   109: iconst_0
    //   110: ireturn
    //   111: astore_1
    //   112: aload_1
    //   113: invokevirtual 250	java/io/IOException:printStackTrace	()V
    //   116: iconst_0
    //   117: ireturn
    //   118: aload_0
    //   119: getfield 75	beix:jdField_a_of_type_Beip	Lbeip;
    //   122: aload_1
    //   123: invokevirtual 253	beip:a	(Ljava/lang/String;)Lbeis;
    //   126: astore_3
    //   127: aload_3
    //   128: ifnull +13 -> 141
    //   131: aload_3
    //   132: iconst_0
    //   133: aload_2
    //   134: invokevirtual 258	beis:a	(ILjava/lang/String;)V
    //   137: aload_3
    //   138: invokevirtual 259	beis:a	()V
    //   141: aload_0
    //   142: getfield 83	beix:jdField_a_of_type_AndroidUtilLruCache	Landroid/util/LruCache;
    //   145: ifnull +42 -> 187
    //   148: aload_0
    //   149: getfield 83	beix:jdField_a_of_type_AndroidUtilLruCache	Landroid/util/LruCache;
    //   152: aload_1
    //   153: aload_2
    //   154: invokevirtual 260	android/util/LruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   157: pop
    //   158: getstatic 24	beix:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   161: astore_1
    //   162: aload_1
    //   163: monitorenter
    //   164: aload_0
    //   165: getfield 83	beix:jdField_a_of_type_AndroidUtilLruCache	Landroid/util/LruCache;
    //   168: ldc 78
    //   170: getstatic 24	beix:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   173: invokevirtual 263	java/util/concurrent/ConcurrentHashMap:keySet	()Ljava/util/Set;
    //   176: invokeinterface 268 1 0
    //   181: idiv
    //   182: invokevirtual 223	android/util/LruCache:trimToSize	(I)V
    //   185: aload_1
    //   186: monitorexit
    //   187: aload_0
    //   188: getfield 75	beix:jdField_a_of_type_Beip	Lbeip;
    //   191: ifnull +10 -> 201
    //   194: aload_0
    //   195: getfield 75	beix:jdField_a_of_type_Beip	Lbeip;
    //   198: invokevirtual 247	beip:a	()V
    //   201: iconst_1
    //   202: ireturn
    //   203: astore_2
    //   204: aload_1
    //   205: monitorexit
    //   206: aload_2
    //   207: athrow
    //   208: astore_1
    //   209: ldc 85
    //   211: aload_1
    //   212: invokevirtual 96	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   215: aload_1
    //   216: invokestatic 99	betc:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   219: aload_0
    //   220: getfield 75	beix:jdField_a_of_type_Beip	Lbeip;
    //   223: ifnull -197 -> 26
    //   226: aload_0
    //   227: getfield 75	beix:jdField_a_of_type_Beip	Lbeip;
    //   230: invokevirtual 247	beip:a	()V
    //   233: iconst_0
    //   234: ireturn
    //   235: astore_1
    //   236: aload_1
    //   237: invokevirtual 250	java/io/IOException:printStackTrace	()V
    //   240: iconst_0
    //   241: ireturn
    //   242: astore_1
    //   243: aload_1
    //   244: invokevirtual 250	java/io/IOException:printStackTrace	()V
    //   247: goto -46 -> 201
    //   250: astore_1
    //   251: aload_0
    //   252: getfield 75	beix:jdField_a_of_type_Beip	Lbeip;
    //   255: ifnull +10 -> 265
    //   258: aload_0
    //   259: getfield 75	beix:jdField_a_of_type_Beip	Lbeip;
    //   262: invokevirtual 247	beip:a	()V
    //   265: aload_1
    //   266: athrow
    //   267: astore_2
    //   268: aload_2
    //   269: invokevirtual 250	java/io/IOException:printStackTrace	()V
    //   272: goto -7 -> 265
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	275	0	this	beix
    //   0	275	2	paramString2	String
    //   0	275	3	paramString3	String
    // Exception table:
    //   from	to	target	type
    //   0	6	28	java/lang/Throwable
    //   102	109	111	java/io/IOException
    //   164	187	203	finally
    //   204	206	203	finally
    //   60	95	208	java/lang/Throwable
    //   118	127	208	java/lang/Throwable
    //   131	141	208	java/lang/Throwable
    //   141	164	208	java/lang/Throwable
    //   206	208	208	java/lang/Throwable
    //   226	233	235	java/io/IOException
    //   194	201	242	java/io/IOException
    //   60	95	250	finally
    //   118	127	250	finally
    //   131	141	250	finally
    //   141	164	250	finally
    //   206	208	250	finally
    //   209	219	250	finally
    //   258	265	267	java/io/IOException
  }
  
  /* Error */
  public String[] a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 83	beix:jdField_a_of_type_AndroidUtilLruCache	Landroid/util/LruCache;
    //   4: ifnull +237 -> 241
    //   7: aload_0
    //   8: getfield 83	beix:jdField_a_of_type_AndroidUtilLruCache	Landroid/util/LruCache;
    //   11: aload_1
    //   12: invokevirtual 270	android/util/LruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   15: checkcast 115	java/lang/String
    //   18: astore 4
    //   20: aload 4
    //   22: astore_3
    //   23: aload 4
    //   25: invokestatic 52	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   28: ifeq +113 -> 141
    //   31: aload 4
    //   33: astore_3
    //   34: aload_0
    //   35: getfield 75	beix:jdField_a_of_type_Beip	Lbeip;
    //   38: ifnull +103 -> 141
    //   41: aload_0
    //   42: getfield 75	beix:jdField_a_of_type_Beip	Lbeip;
    //   45: invokevirtual 194	beip:a	()Z
    //   48: ifeq +7 -> 55
    //   51: aload_0
    //   52: invokespecial 174	beix:b	()V
    //   55: aload_0
    //   56: getfield 75	beix:jdField_a_of_type_Beip	Lbeip;
    //   59: aload_1
    //   60: invokevirtual 273	beip:a	(Ljava/lang/String;)Lbeiv;
    //   63: astore_2
    //   64: aload 4
    //   66: astore 5
    //   68: aload_2
    //   69: ifnull +58 -> 127
    //   72: aload_2
    //   73: astore_3
    //   74: aload_2
    //   75: iconst_0
    //   76: invokevirtual 278	beiv:a	(I)Ljava/lang/String;
    //   79: astore 5
    //   81: aload_2
    //   82: astore_3
    //   83: aload_0
    //   84: getfield 83	beix:jdField_a_of_type_AndroidUtilLruCache	Landroid/util/LruCache;
    //   87: aload_1
    //   88: aload 5
    //   90: invokevirtual 260	android/util/LruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   93: pop
    //   94: aload_2
    //   95: astore_3
    //   96: getstatic 24	beix:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   99: astore_1
    //   100: aload_2
    //   101: astore_3
    //   102: aload_1
    //   103: monitorenter
    //   104: aload_0
    //   105: getfield 83	beix:jdField_a_of_type_AndroidUtilLruCache	Landroid/util/LruCache;
    //   108: ldc 78
    //   110: getstatic 24	beix:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   113: invokevirtual 263	java/util/concurrent/ConcurrentHashMap:keySet	()Ljava/util/Set;
    //   116: invokeinterface 268 1 0
    //   121: idiv
    //   122: invokevirtual 223	android/util/LruCache:trimToSize	(I)V
    //   125: aload_1
    //   126: monitorexit
    //   127: aload 5
    //   129: astore_3
    //   130: aload_2
    //   131: ifnull +10 -> 141
    //   134: aload_2
    //   135: invokevirtual 279	beiv:close	()V
    //   138: aload 5
    //   140: astore_3
    //   141: aload_3
    //   142: invokestatic 52	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   145: ifne +96 -> 241
    //   148: aload_3
    //   149: invokestatic 281	beiw:a	(Ljava/lang/String;)[Ljava/lang/String;
    //   152: areturn
    //   153: astore 4
    //   155: aload_1
    //   156: monitorexit
    //   157: aload_2
    //   158: astore_3
    //   159: aload 4
    //   161: athrow
    //   162: astore_1
    //   163: aload 5
    //   165: astore 4
    //   167: aload_2
    //   168: astore_3
    //   169: ldc 85
    //   171: aload_1
    //   172: invokevirtual 96	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   175: aload_1
    //   176: invokestatic 99	betc:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   179: aload 4
    //   181: astore_3
    //   182: aload_2
    //   183: ifnull -42 -> 141
    //   186: aload_2
    //   187: invokevirtual 279	beiv:close	()V
    //   190: aload 4
    //   192: astore_3
    //   193: goto -52 -> 141
    //   196: astore_1
    //   197: aload 4
    //   199: astore_3
    //   200: goto -59 -> 141
    //   203: astore_1
    //   204: aconst_null
    //   205: astore_3
    //   206: aload_3
    //   207: ifnull +7 -> 214
    //   210: aload_3
    //   211: invokevirtual 279	beiv:close	()V
    //   214: aload_1
    //   215: athrow
    //   216: astore_1
    //   217: aload 5
    //   219: astore_3
    //   220: goto -79 -> 141
    //   223: astore_2
    //   224: goto -10 -> 214
    //   227: astore_1
    //   228: goto -22 -> 206
    //   231: astore_1
    //   232: aconst_null
    //   233: astore_2
    //   234: goto -67 -> 167
    //   237: astore_1
    //   238: goto -71 -> 167
    //   241: aconst_null
    //   242: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	243	0	this	beix
    //   0	243	1	paramString	String
    //   63	124	2	localbeiv	beiv
    //   223	1	2	localThrowable	Throwable
    //   233	1	2	localObject1	Object
    //   22	198	3	localObject2	Object
    //   18	47	4	str1	String
    //   153	7	4	localObject3	Object
    //   165	33	4	localObject4	Object
    //   66	152	5	str2	String
    // Exception table:
    //   from	to	target	type
    //   104	127	153	finally
    //   155	157	153	finally
    //   83	94	162	java/lang/Throwable
    //   96	100	162	java/lang/Throwable
    //   102	104	162	java/lang/Throwable
    //   159	162	162	java/lang/Throwable
    //   186	190	196	java/lang/Throwable
    //   41	55	203	finally
    //   55	64	203	finally
    //   134	138	216	java/lang/Throwable
    //   210	214	223	java/lang/Throwable
    //   74	81	227	finally
    //   83	94	227	finally
    //   96	100	227	finally
    //   102	104	227	finally
    //   159	162	227	finally
    //   169	179	227	finally
    //   41	55	231	java/lang/Throwable
    //   55	64	231	java/lang/Throwable
    //   74	81	237	java/lang/Throwable
  }
  
  public long b()
  {
    if (this.jdField_a_of_type_Beip != null) {
      return this.jdField_a_of_type_Beip.b();
    }
    return -1L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     beix
 * JD-Core Version:    0.7.0.1
 */