import android.content.Context;
import com.tencent.shadow.core.common.LoggerFactory;
import com.tencent.shadow.dynamic.host.DynamicPluginManager;

public final class bddf
{
  private static boolean a;
  
  static {}
  
  public static bddd a(Context paramContext, String paramString1, String paramString2)
  {
    return new bdde(paramString1, new DynamicPluginManager(a(paramContext, paramString1, paramString2)));
  }
  
  /* Error */
  public static com.tencent.shadow.dynamic.host.PluginManagerUpdater a(Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: new 32	bddn
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 35	bddn:<init>	(Ljava/lang/String;)V
    //   8: astore 4
    //   10: aload 4
    //   12: invokeinterface 40 1 0
    //   17: ifeq +14 -> 31
    //   20: ldc 42
    //   22: iconst_1
    //   23: ldc 44
    //   25: invokestatic 50	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   28: aload 4
    //   30: areturn
    //   31: new 52	bddi
    //   34: dup
    //   35: aload_0
    //   36: aload_1
    //   37: invokespecial 55	bddi:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   40: astore 4
    //   42: aload 4
    //   44: invokeinterface 40 1 0
    //   49: ifeq +14 -> 63
    //   52: ldc 42
    //   54: iconst_1
    //   55: ldc 57
    //   57: invokestatic 50	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   60: aload 4
    //   62: areturn
    //   63: invokestatic 60	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   66: ifeq +11 -> 77
    //   69: ldc 42
    //   71: iconst_2
    //   72: ldc 62
    //   74: invokestatic 50	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   77: new 64	bddk
    //   80: dup
    //   81: aload_0
    //   82: aload_1
    //   83: aload_2
    //   84: ldc 66
    //   86: invokespecial 69	bddk:<init>	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   89: astore 5
    //   91: invokestatic 60	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   94: ifeq +45 -> 139
    //   97: ldc 42
    //   99: iconst_2
    //   100: new 71	java/lang/StringBuilder
    //   103: dup
    //   104: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   107: ldc 75
    //   109: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: aload 5
    //   114: invokevirtual 82	bddk:wasUpdating	()Z
    //   117: invokevirtual 85	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   120: ldc 87
    //   122: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: aload 5
    //   127: invokevirtual 91	bddk:getLatest	()Ljava/io/File;
    //   130: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   133: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   136: invokestatic 50	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   139: aload 5
    //   141: invokevirtual 82	bddk:wasUpdating	()Z
    //   144: ifne +11 -> 155
    //   147: aload 5
    //   149: invokevirtual 91	bddk:getLatest	()Ljava/io/File;
    //   152: ifnonnull +176 -> 328
    //   155: iconst_1
    //   156: istore_3
    //   157: invokestatic 60	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   160: ifeq +28 -> 188
    //   163: ldc 42
    //   165: iconst_2
    //   166: new 71	java/lang/StringBuilder
    //   169: dup
    //   170: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   173: ldc 100
    //   175: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: iload_3
    //   179: invokevirtual 85	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   182: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   185: invokestatic 50	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   188: aload 5
    //   190: invokevirtual 104	bddk:update	()Ljava/util/concurrent/Future;
    //   193: astore_1
    //   194: iload_3
    //   195: ifeq +10 -> 205
    //   198: aload_1
    //   199: invokeinterface 110 1 0
    //   204: pop
    //   205: aload_0
    //   206: invokevirtual 116	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   209: astore_1
    //   210: aload 5
    //   212: invokevirtual 91	bddk:getLatest	()Ljava/io/File;
    //   215: ifnull +118 -> 333
    //   218: aload 5
    //   220: invokevirtual 91	bddk:getLatest	()Ljava/io/File;
    //   223: invokevirtual 121	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   226: astore_2
    //   227: aconst_null
    //   228: astore_0
    //   229: aload_1
    //   230: aload_2
    //   231: sipush 128
    //   234: invokevirtual 127	android/content/pm/PackageManager:getPackageArchiveInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   237: astore_1
    //   238: aload_1
    //   239: ifnonnull +100 -> 339
    //   242: aload_1
    //   243: astore_0
    //   244: new 129	java/lang/RuntimeException
    //   247: dup
    //   248: ldc 131
    //   250: invokespecial 132	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   253: athrow
    //   254: astore 4
    //   256: aload_0
    //   257: astore_1
    //   258: ldc 42
    //   260: iconst_1
    //   261: ldc 134
    //   263: aload 4
    //   265: invokestatic 138	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   268: aload_0
    //   269: ifnonnull +56 -> 325
    //   272: ldc 140
    //   274: astore_0
    //   275: aload 5
    //   277: invokevirtual 91	bddk:getLatest	()Ljava/io/File;
    //   280: invokestatic 145	bkcx:a	(Ljava/io/File;)Ljava/lang/String;
    //   283: astore_1
    //   284: aload_1
    //   285: astore_0
    //   286: ldc 42
    //   288: iconst_1
    //   289: new 71	java/lang/StringBuilder
    //   292: dup
    //   293: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   296: ldc 147
    //   298: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   301: aload_2
    //   302: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: ldc 149
    //   307: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: aload_0
    //   311: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   317: invokestatic 50	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   320: aload 5
    //   322: invokevirtual 150	bddk:a	()V
    //   325: aload 5
    //   327: areturn
    //   328: iconst_0
    //   329: istore_3
    //   330: goto -173 -> 157
    //   333: ldc 140
    //   335: astore_2
    //   336: goto -109 -> 227
    //   339: aload_1
    //   340: ifnonnull -15 -> 325
    //   343: ldc 140
    //   345: astore_0
    //   346: aload 5
    //   348: invokevirtual 91	bddk:getLatest	()Ljava/io/File;
    //   351: invokestatic 145	bkcx:a	(Ljava/io/File;)Ljava/lang/String;
    //   354: astore_1
    //   355: aload_1
    //   356: astore_0
    //   357: ldc 42
    //   359: iconst_1
    //   360: new 71	java/lang/StringBuilder
    //   363: dup
    //   364: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   367: ldc 147
    //   369: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   372: aload_2
    //   373: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   376: ldc 149
    //   378: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   381: aload_0
    //   382: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   385: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   388: invokestatic 50	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   391: aload 5
    //   393: invokevirtual 150	bddk:a	()V
    //   396: goto -71 -> 325
    //   399: astore_0
    //   400: aconst_null
    //   401: astore_1
    //   402: aload_1
    //   403: ifnonnull +58 -> 461
    //   406: ldc 140
    //   408: astore_1
    //   409: aload 5
    //   411: invokevirtual 91	bddk:getLatest	()Ljava/io/File;
    //   414: invokestatic 145	bkcx:a	(Ljava/io/File;)Ljava/lang/String;
    //   417: astore 4
    //   419: aload 4
    //   421: astore_1
    //   422: ldc 42
    //   424: iconst_1
    //   425: new 71	java/lang/StringBuilder
    //   428: dup
    //   429: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   432: ldc 147
    //   434: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   437: aload_2
    //   438: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   441: ldc 149
    //   443: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   446: aload_1
    //   447: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   450: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   453: invokestatic 50	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   456: aload 5
    //   458: invokevirtual 150	bddk:a	()V
    //   461: aload_0
    //   462: athrow
    //   463: astore 4
    //   465: goto -43 -> 422
    //   468: astore_0
    //   469: goto -67 -> 402
    //   472: astore_1
    //   473: goto -187 -> 286
    //   476: astore_1
    //   477: goto -120 -> 357
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	480	0	paramContext	Context
    //   0	480	1	paramString1	String
    //   0	480	2	paramString2	String
    //   156	174	3	bool	boolean
    //   8	53	4	localObject	Object
    //   254	10	4	localException	java.lang.Exception
    //   417	3	4	str	String
    //   463	1	4	localIOException	java.io.IOException
    //   89	368	5	localbddk	bddk
    // Exception table:
    //   from	to	target	type
    //   229	238	254	java/lang/Exception
    //   244	254	254	java/lang/Exception
    //   229	238	399	finally
    //   409	419	463	java/io/IOException
    //   244	254	468	finally
    //   258	268	468	finally
    //   275	284	472	java/io/IOException
    //   346	355	476	java/io/IOException
  }
  
  public static void a()
  {
    if (!a) {}
    try
    {
      LoggerFactory.setILoggerFactory(avgw.a());
      label12:
      a = true;
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      break label12;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bddf
 * JD-Core Version:    0.7.0.1
 */