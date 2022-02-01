package c.t.m.sapp.c;

import android.content.Context;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class c
  implements Runnable
{
  public static int a;
  public final int b = 30000;
  public final int c = 20000;
  public Context d;
  public List<a> e = null;
  public String f = null;
  public boolean g = false;
  
  public c(Context paramContext)
  {
    this.d = paramContext;
    paramContext = new StringBuilder();
    paramContext.append(this.d.getFilesDir().getAbsolutePath());
    paramContext.append(File.separator);
    paramContext.append("TencentLocation_sapp/UpCp");
    this.f = paramContext.toString();
    paramContext = new File(this.d.getFilesDir().getAbsolutePath(), "TencentLocation_sapp/UpCp");
    if (!paramContext.exists()) {
      paramContext.mkdirs();
    }
  }
  
  public final void a()
  {
    for (;;)
    {
      try
      {
        localObject1 = this.e;
        if ((localObject1 == null) || (((List)localObject1).size() <= 0)) {
          continue;
        }
        a = 1;
        q.j(this.d);
        if (q.d() < 10485760L)
        {
          a = 2;
          return;
        }
        localObject1 = new ArrayList();
        localObject3 = this.e.iterator();
        int j = 0;
        i = 1;
        if (((Iterator)localObject3).hasNext())
        {
          localObject4 = (a)((Iterator)localObject3).next();
          if (!a((a)localObject4))
          {
            i = 0;
            continue;
          }
          ((List)localObject1).add(localObject4);
          continue;
        }
        if (i == 0)
        {
          a = 2;
          a((List)localObject1);
          return;
        }
        if (((List)localObject1).size() != this.e.size()) {
          continue;
        }
        q.a(this.d, "__SP_UPDATE_TencentLoc_COMP_INFO__sapp_", "");
        if (!q.a(this.d, this.e)) {
          continue;
        }
        q.b(this.d, "__SP_UPDATE_TencentLoc_COMP_SDK_VER__sapp_", h.a);
        localObject1 = ((List)localObject1).iterator();
        i = j;
        if (!((Iterator)localObject1).hasNext()) {
          continue;
        }
        localObject3 = (a)((Iterator)localObject1).next();
        if (!((a)localObject3).c.contains(".dex"))
        {
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append(((a)localObject3).c);
          ((StringBuilder)localObject4).append(".dex");
          ((a)localObject3).c = ((StringBuilder)localObject4).toString();
        }
        localObject4 = new File(this.f, ((a)localObject3).c);
        if (!((File)localObject4).exists()) {
          continue;
        }
        bool1 = ((File)localObject4).delete();
      }
      finally
      {
        Object localObject1;
        Object localObject3;
        int i;
        Object localObject4;
        String str;
        StringBuilder localStringBuilder;
        boolean bool2;
        boolean bool3;
        continue;
        throw localObject2;
        continue;
        boolean bool1 = true;
        continue;
      }
      localObject4 = new File(this.f, ((a)localObject3).c);
      str = this.f;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("tmp__sapp");
      localStringBuilder.append(((a)localObject3).c);
      bool2 = new File(str, localStringBuilder.toString()).renameTo((File)localObject4);
      bool3 = a((a)localObject3, (File)localObject4);
      if ((bool1) && (bool2) && (bool3)) {
        i = 1;
      }
    }
    if (i == 0)
    {
      q.b(this.d, "__SP_UPDATE_TencentLoc_COMP_INFO__sapp_", "");
      q.a(this.f);
      a = 2;
      return;
    }
    a = 1;
    e.a(this.d).a("CPU", "down suc");
    break label515;
    a((List)localObject1);
    a = 2;
    return;
    j.a("down load failed");
    e.a(this.d).a("CPU", "down failed");
    a((List)localObject1);
    a = 2;
    label515:
  }
  
  public final void a(List<a> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (a)paramList.next();
      String str = this.f;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("tmp__sapp");
      localStringBuilder.append(((a)localObject).c);
      localObject = new File(str, localStringBuilder.toString());
      if ((((File)localObject).exists()) && (((File)localObject).isFile())) {
        ((File)localObject).delete();
      }
    }
  }
  
  /* Error */
  public final boolean a(a parama)
  {
    // Byte code:
    //   0: new 38	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   7: astore_3
    //   8: aload_3
    //   9: ldc 196
    //   11: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14: pop
    //   15: aload_3
    //   16: aload_1
    //   17: getfield 198	c/t/m/sapp/c/a:e	Ljava/lang/String;
    //   20: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: pop
    //   24: aload_3
    //   25: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: astore 6
    //   30: new 38	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   37: astore_3
    //   38: aload_3
    //   39: ldc 200
    //   41: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: pop
    //   45: aload_3
    //   46: aload_1
    //   47: getfield 198	c/t/m/sapp/c/a:e	Ljava/lang/String;
    //   50: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: pop
    //   54: aload_3
    //   55: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   58: invokestatic 183	c/t/m/sapp/c/j:a	(Ljava/lang/String;)V
    //   61: aconst_null
    //   62: astore 4
    //   64: iconst_0
    //   65: istore_2
    //   66: iload_2
    //   67: iconst_3
    //   68: if_icmpge +546 -> 614
    //   71: aload 6
    //   73: invokestatic 205	c/t/m/sapp/c/p:a	(Ljava/lang/String;)[B
    //   76: astore 5
    //   78: aload 4
    //   80: astore_3
    //   81: aload 5
    //   83: ifnull +515 -> 598
    //   86: aload 5
    //   88: ldc 207
    //   90: invokestatic 212	c/t/m/sapp/c/m:a	([BLjava/lang/String;)[B
    //   93: invokestatic 215	c/t/m/sapp/c/q:c	([B)[B
    //   96: astore 5
    //   98: aload 4
    //   100: astore_3
    //   101: aload 5
    //   103: ifnull +495 -> 598
    //   106: aload_0
    //   107: getfield 32	c/t/m/sapp/c/c:f	Ljava/lang/String;
    //   110: astore_3
    //   111: new 38	java/lang/StringBuilder
    //   114: dup
    //   115: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   118: astore 7
    //   120: aload 7
    //   122: ldc 155
    //   124: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: pop
    //   128: aload 7
    //   130: aload_1
    //   131: getfield 142	c/t/m/sapp/c/a:c	Ljava/lang/String;
    //   134: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: pop
    //   138: new 47	java/io/File
    //   141: dup
    //   142: aload_3
    //   143: aload 7
    //   145: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   148: invokespecial 66	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   151: astore 7
    //   153: new 217	java/io/BufferedOutputStream
    //   156: dup
    //   157: new 219	java/io/FileOutputStream
    //   160: dup
    //   161: aload 7
    //   163: iconst_0
    //   164: invokespecial 222	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   167: sipush 1024
    //   170: invokespecial 225	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   173: astore_3
    //   174: aload_3
    //   175: astore 4
    //   177: aload_3
    //   178: aload 5
    //   180: invokevirtual 229	java/io/BufferedOutputStream:write	([B)V
    //   183: aload_3
    //   184: astore 4
    //   186: aload_0
    //   187: aload_1
    //   188: aload 7
    //   190: invokevirtual 162	c/t/m/sapp/c/c:a	(Lc/t/m/sapp/c/a;Ljava/io/File;)Z
    //   193: ifeq +119 -> 312
    //   196: aload_3
    //   197: astore 4
    //   199: new 38	java/lang/StringBuilder
    //   202: dup
    //   203: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   206: astore 5
    //   208: aload_3
    //   209: astore 4
    //   211: aload 5
    //   213: ldc 231
    //   215: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: pop
    //   219: aload_3
    //   220: astore 4
    //   222: aload 5
    //   224: aload_1
    //   225: getfield 198	c/t/m/sapp/c/a:e	Ljava/lang/String;
    //   228: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: pop
    //   232: aload_3
    //   233: astore 4
    //   235: aload 5
    //   237: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   240: invokestatic 183	c/t/m/sapp/c/j:a	(Ljava/lang/String;)V
    //   243: aload_3
    //   244: astore 4
    //   246: aload_0
    //   247: getfield 36	c/t/m/sapp/c/c:d	Landroid/content/Context;
    //   250: invokestatic 170	c/t/m/sapp/c/e:a	(Landroid/content/Context;)Lc/t/m/sapp/c/e;
    //   253: astore 5
    //   255: aload_3
    //   256: astore 4
    //   258: new 38	java/lang/StringBuilder
    //   261: dup
    //   262: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   265: astore 8
    //   267: aload_3
    //   268: astore 4
    //   270: aload 8
    //   272: ldc 233
    //   274: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: pop
    //   278: aload_3
    //   279: astore 4
    //   281: aload 8
    //   283: aload_1
    //   284: getfield 198	c/t/m/sapp/c/a:e	Ljava/lang/String;
    //   287: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: pop
    //   291: aload_3
    //   292: astore 4
    //   294: aload 5
    //   296: ldc 172
    //   298: aload 8
    //   300: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   303: invokevirtual 176	c/t/m/sapp/c/e:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   306: aload_3
    //   307: invokevirtual 236	java/io/BufferedOutputStream:close	()V
    //   310: iconst_1
    //   311: ireturn
    //   312: aload_3
    //   313: astore 4
    //   315: new 38	java/lang/StringBuilder
    //   318: dup
    //   319: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   322: astore 5
    //   324: aload_3
    //   325: astore 4
    //   327: aload 5
    //   329: ldc 238
    //   331: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   334: pop
    //   335: aload_3
    //   336: astore 4
    //   338: aload 5
    //   340: aload_1
    //   341: getfield 198	c/t/m/sapp/c/a:e	Ljava/lang/String;
    //   344: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   347: pop
    //   348: aload_3
    //   349: astore 4
    //   351: aload 5
    //   353: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   356: invokestatic 183	c/t/m/sapp/c/j:a	(Ljava/lang/String;)V
    //   359: aload_3
    //   360: astore 4
    //   362: aload_0
    //   363: getfield 36	c/t/m/sapp/c/c:d	Landroid/content/Context;
    //   366: invokestatic 170	c/t/m/sapp/c/e:a	(Landroid/content/Context;)Lc/t/m/sapp/c/e;
    //   369: astore 5
    //   371: aload_3
    //   372: astore 4
    //   374: new 38	java/lang/StringBuilder
    //   377: dup
    //   378: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   381: astore 8
    //   383: aload_3
    //   384: astore 4
    //   386: aload 8
    //   388: ldc 240
    //   390: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   393: pop
    //   394: aload_3
    //   395: astore 4
    //   397: aload 8
    //   399: aload_1
    //   400: getfield 198	c/t/m/sapp/c/a:e	Ljava/lang/String;
    //   403: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   406: pop
    //   407: aload_3
    //   408: astore 4
    //   410: aload 5
    //   412: ldc 172
    //   414: aload 8
    //   416: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   419: invokevirtual 176	c/t/m/sapp/c/e:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   422: aload_3
    //   423: astore 4
    //   425: aload 7
    //   427: invokevirtual 70	java/io/File:exists	()Z
    //   430: ifeq +23 -> 453
    //   433: aload_3
    //   434: astore 4
    //   436: aload 7
    //   438: invokevirtual 188	java/io/File:isFile	()Z
    //   441: ifeq +12 -> 453
    //   444: aload_3
    //   445: astore 4
    //   447: aload 7
    //   449: invokevirtual 153	java/io/File:delete	()Z
    //   452: pop
    //   453: aload_3
    //   454: astore 4
    //   456: aload_3
    //   457: invokevirtual 236	java/io/BufferedOutputStream:close	()V
    //   460: goto +127 -> 587
    //   463: astore 5
    //   465: goto +12 -> 477
    //   468: astore_1
    //   469: goto +122 -> 591
    //   472: astore 5
    //   474: aload 4
    //   476: astore_3
    //   477: aload_3
    //   478: astore 4
    //   480: aload 5
    //   482: invokevirtual 243	java/lang/Exception:printStackTrace	()V
    //   485: aload_3
    //   486: astore 4
    //   488: aload 7
    //   490: invokevirtual 70	java/io/File:exists	()Z
    //   493: ifeq +23 -> 516
    //   496: aload_3
    //   497: astore 4
    //   499: aload 7
    //   501: invokevirtual 188	java/io/File:isFile	()Z
    //   504: ifeq +12 -> 516
    //   507: aload_3
    //   508: astore 4
    //   510: aload 7
    //   512: invokevirtual 153	java/io/File:delete	()Z
    //   515: pop
    //   516: aload_3
    //   517: astore 4
    //   519: aload_0
    //   520: getfield 36	c/t/m/sapp/c/c:d	Landroid/content/Context;
    //   523: invokestatic 170	c/t/m/sapp/c/e:a	(Landroid/content/Context;)Lc/t/m/sapp/c/e;
    //   526: astore 7
    //   528: aload_3
    //   529: astore 4
    //   531: new 38	java/lang/StringBuilder
    //   534: dup
    //   535: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   538: astore 8
    //   540: aload_3
    //   541: astore 4
    //   543: aload 8
    //   545: ldc 240
    //   547: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   550: pop
    //   551: aload_3
    //   552: astore 4
    //   554: aload 8
    //   556: aload 5
    //   558: invokevirtual 244	java/lang/Exception:toString	()Ljava/lang/String;
    //   561: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   564: pop
    //   565: aload_3
    //   566: astore 4
    //   568: aload 7
    //   570: ldc 172
    //   572: aload 8
    //   574: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   577: invokevirtual 176	c/t/m/sapp/c/e:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   580: aload_3
    //   581: astore 4
    //   583: aload_3
    //   584: invokevirtual 236	java/io/BufferedOutputStream:close	()V
    //   587: goto +11 -> 598
    //   590: astore_1
    //   591: aload 4
    //   593: invokevirtual 236	java/io/BufferedOutputStream:close	()V
    //   596: aload_1
    //   597: athrow
    //   598: ldc2_w 245
    //   601: invokestatic 249	c/t/m/sapp/c/q:a	(J)V
    //   604: iload_2
    //   605: iconst_1
    //   606: iadd
    //   607: istore_2
    //   608: aload_3
    //   609: astore 4
    //   611: goto -545 -> 66
    //   614: iconst_0
    //   615: ireturn
    //   616: astore_1
    //   617: iconst_0
    //   618: ireturn
    //   619: astore_1
    //   620: goto -310 -> 310
    //   623: astore_3
    //   624: aload 4
    //   626: astore_3
    //   627: goto -40 -> 587
    //   630: astore_3
    //   631: goto -35 -> 596
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	634	0	this	c
    //   0	634	1	parama	a
    //   65	543	2	i	int
    //   7	602	3	localObject1	Object
    //   623	1	3	localException1	java.lang.Exception
    //   626	1	3	localObject2	Object
    //   630	1	3	localException2	java.lang.Exception
    //   62	563	4	localObject3	Object
    //   76	335	5	localObject4	Object
    //   463	1	5	localException3	java.lang.Exception
    //   472	85	5	localException4	java.lang.Exception
    //   28	44	6	str	String
    //   118	451	7	localObject5	Object
    //   265	308	8	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   177	183	463	java/lang/Exception
    //   186	196	463	java/lang/Exception
    //   199	208	463	java/lang/Exception
    //   211	219	463	java/lang/Exception
    //   222	232	463	java/lang/Exception
    //   235	243	463	java/lang/Exception
    //   246	255	463	java/lang/Exception
    //   258	267	463	java/lang/Exception
    //   270	278	463	java/lang/Exception
    //   281	291	463	java/lang/Exception
    //   294	306	463	java/lang/Exception
    //   315	324	463	java/lang/Exception
    //   327	335	463	java/lang/Exception
    //   338	348	463	java/lang/Exception
    //   351	359	463	java/lang/Exception
    //   362	371	463	java/lang/Exception
    //   374	383	463	java/lang/Exception
    //   386	394	463	java/lang/Exception
    //   397	407	463	java/lang/Exception
    //   410	422	463	java/lang/Exception
    //   425	433	463	java/lang/Exception
    //   436	444	463	java/lang/Exception
    //   447	453	463	java/lang/Exception
    //   153	174	468	finally
    //   153	174	472	java/lang/Exception
    //   177	183	590	finally
    //   186	196	590	finally
    //   199	208	590	finally
    //   211	219	590	finally
    //   222	232	590	finally
    //   235	243	590	finally
    //   246	255	590	finally
    //   258	267	590	finally
    //   270	278	590	finally
    //   281	291	590	finally
    //   294	306	590	finally
    //   315	324	590	finally
    //   327	335	590	finally
    //   338	348	590	finally
    //   351	359	590	finally
    //   362	371	590	finally
    //   374	383	590	finally
    //   386	394	590	finally
    //   397	407	590	finally
    //   410	422	590	finally
    //   425	433	590	finally
    //   436	444	590	finally
    //   447	453	590	finally
    //   480	485	590	finally
    //   488	496	590	finally
    //   499	507	590	finally
    //   510	516	590	finally
    //   519	528	590	finally
    //   531	540	590	finally
    //   543	551	590	finally
    //   554	565	590	finally
    //   568	580	590	finally
    //   0	8	616	java/lang/Throwable
    //   8	38	616	java/lang/Throwable
    //   38	61	616	java/lang/Throwable
    //   71	78	616	java/lang/Throwable
    //   86	98	616	java/lang/Throwable
    //   106	120	616	java/lang/Throwable
    //   120	153	616	java/lang/Throwable
    //   306	310	616	java/lang/Throwable
    //   456	460	616	java/lang/Throwable
    //   583	587	616	java/lang/Throwable
    //   591	596	616	java/lang/Throwable
    //   596	598	616	java/lang/Throwable
    //   598	604	616	java/lang/Throwable
    //   306	310	619	java/lang/Exception
    //   456	460	623	java/lang/Exception
    //   583	587	623	java/lang/Exception
    //   591	596	630	java/lang/Exception
  }
  
  public final boolean a(a parama, File paramFile)
  {
    if ((paramFile != null) && (paramFile.exists()))
    {
      int i = (int)paramFile.length();
      paramFile = q.a(paramFile);
      if ((parama.d == i) && (parama.e.equals(paramFile))) {
        return true;
      }
    }
    return false;
  }
  
  public void b(List<a> paramList)
  {
    this.e = paramList;
    if (a != 1) {
      new Thread(this).start();
    }
  }
  
  public void run()
  {
    d.a(this.d).b("updatelock_sapp");
    a();
    e.a(this.d).d();
    d.a(this.d).c("updatelock_sapp");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     c.t.m.sapp.c.c
 * JD-Core Version:    0.7.0.1
 */