package com.tencent.mm.plugin.appbrand.appstorage;

class x$12
  implements x.a
{
  x$12(x paramx) {}
  
  /* Error */
  @androidx.annotation.NonNull
  public j a(@androidx.annotation.NonNull com.tencent.luggage.wxa.rt.i parami, Object... paramVarArgs)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 26	com/tencent/mm/plugin/appbrand/appstorage/k:d	(Lcom/tencent/luggage/wxa/rt/i;)Z
    //   4: ifeq +7 -> 11
    //   7: getstatic 32	com/tencent/mm/plugin/appbrand/appstorage/j:k	Lcom/tencent/mm/plugin/appbrand/appstorage/j;
    //   10: areturn
    //   11: aload_2
    //   12: iconst_0
    //   13: aaload
    //   14: checkcast 34	java/io/InputStream
    //   17: astore 8
    //   19: aload_2
    //   20: iconst_1
    //   21: aaload
    //   22: checkcast 36	java/lang/Boolean
    //   25: invokevirtual 40	java/lang/Boolean:booleanValue	()Z
    //   28: istore 4
    //   30: aload 8
    //   32: instanceof 42
    //   35: ifeq +65 -> 100
    //   38: aload 8
    //   40: checkcast 42	java/util/zip/ZipInputStream
    //   43: aload_1
    //   44: invokevirtual 48	com/tencent/luggage/wxa/rt/i:l	()Ljava/lang/String;
    //   47: invokestatic 51	com/tencent/mm/plugin/appbrand/appstorage/k:a	(Ljava/util/zip/ZipInputStream;Ljava/lang/String;)I
    //   50: ifne +46 -> 96
    //   53: aload_0
    //   54: getfield 12	com/tencent/mm/plugin/appbrand/appstorage/x$12:a	Lcom/tencent/mm/plugin/appbrand/appstorage/x;
    //   57: invokestatic 57	com/tencent/mm/plugin/appbrand/appstorage/x:b	(Lcom/tencent/mm/plugin/appbrand/appstorage/x;)J
    //   60: lconst_0
    //   61: lcmp
    //   62: ifle +30 -> 92
    //   65: aload_0
    //   66: getfield 12	com/tencent/mm/plugin/appbrand/appstorage/x$12:a	Lcom/tencent/mm/plugin/appbrand/appstorage/x;
    //   69: invokestatic 60	com/tencent/mm/plugin/appbrand/appstorage/x:c	(Lcom/tencent/mm/plugin/appbrand/appstorage/x;)J
    //   72: aload_0
    //   73: getfield 12	com/tencent/mm/plugin/appbrand/appstorage/x$12:a	Lcom/tencent/mm/plugin/appbrand/appstorage/x;
    //   76: invokestatic 57	com/tencent/mm/plugin/appbrand/appstorage/x:b	(Lcom/tencent/mm/plugin/appbrand/appstorage/x;)J
    //   79: lcmp
    //   80: ifle +12 -> 92
    //   83: aload_1
    //   84: invokevirtual 63	com/tencent/luggage/wxa/rt/i:w	()Z
    //   87: pop
    //   88: getstatic 66	com/tencent/mm/plugin/appbrand/appstorage/j:p	Lcom/tencent/mm/plugin/appbrand/appstorage/j;
    //   91: areturn
    //   92: getstatic 68	com/tencent/mm/plugin/appbrand/appstorage/j:a	Lcom/tencent/mm/plugin/appbrand/appstorage/j;
    //   95: areturn
    //   96: getstatic 70	com/tencent/mm/plugin/appbrand/appstorage/j:b	Lcom/tencent/mm/plugin/appbrand/appstorage/j;
    //   99: areturn
    //   100: aload_1
    //   101: invokevirtual 73	com/tencent/luggage/wxa/rt/i:n	()Z
    //   104: ifeq +7 -> 111
    //   107: getstatic 76	com/tencent/mm/plugin/appbrand/appstorage/j:f	Lcom/tencent/mm/plugin/appbrand/appstorage/j;
    //   110: areturn
    //   111: aload_0
    //   112: getfield 12	com/tencent/mm/plugin/appbrand/appstorage/x$12:a	Lcom/tencent/mm/plugin/appbrand/appstorage/x;
    //   115: invokestatic 57	com/tencent/mm/plugin/appbrand/appstorage/x:b	(Lcom/tencent/mm/plugin/appbrand/appstorage/x;)J
    //   118: lconst_0
    //   119: lcmp
    //   120: ifle +58 -> 178
    //   123: aload 8
    //   125: invokevirtual 80	java/io/InputStream:available	()I
    //   128: istore_3
    //   129: iload_3
    //   130: i2l
    //   131: lstore 5
    //   133: aload_0
    //   134: getfield 12	com/tencent/mm/plugin/appbrand/appstorage/x$12:a	Lcom/tencent/mm/plugin/appbrand/appstorage/x;
    //   137: invokestatic 60	com/tencent/mm/plugin/appbrand/appstorage/x:c	(Lcom/tencent/mm/plugin/appbrand/appstorage/x;)J
    //   140: lload 5
    //   142: ladd
    //   143: aload_0
    //   144: getfield 12	com/tencent/mm/plugin/appbrand/appstorage/x$12:a	Lcom/tencent/mm/plugin/appbrand/appstorage/x;
    //   147: invokestatic 57	com/tencent/mm/plugin/appbrand/appstorage/x:b	(Lcom/tencent/mm/plugin/appbrand/appstorage/x;)J
    //   150: lcmp
    //   151: ifle +27 -> 178
    //   154: getstatic 66	com/tencent/mm/plugin/appbrand/appstorage/j:p	Lcom/tencent/mm/plugin/appbrand/appstorage/j;
    //   157: areturn
    //   158: astore_1
    //   159: ldc 82
    //   161: ldc 84
    //   163: iconst_1
    //   164: anewarray 4	java/lang/Object
    //   167: dup
    //   168: iconst_0
    //   169: aload_1
    //   170: aastore
    //   171: invokestatic 89	com/tencent/luggage/wxa/qz/o:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   174: getstatic 70	com/tencent/mm/plugin/appbrand/appstorage/j:b	Lcom/tencent/mm/plugin/appbrand/appstorage/j;
    //   177: areturn
    //   178: aload_1
    //   179: invokevirtual 92	com/tencent/luggage/wxa/rt/i:j	()Z
    //   182: ifne +12 -> 194
    //   185: iload 4
    //   187: ifeq +7 -> 194
    //   190: getstatic 95	com/tencent/mm/plugin/appbrand/appstorage/j:g	Lcom/tencent/mm/plugin/appbrand/appstorage/j;
    //   193: areturn
    //   194: aconst_null
    //   195: astore 7
    //   197: aconst_null
    //   198: astore_2
    //   199: aload_1
    //   200: invokevirtual 48	com/tencent/luggage/wxa/rt/i:l	()Ljava/lang/String;
    //   203: iload 4
    //   205: invokestatic 100	com/tencent/luggage/wxa/rt/k:a	(Ljava/lang/String;Z)Ljava/io/OutputStream;
    //   208: astore_1
    //   209: aload_1
    //   210: astore_2
    //   211: aload_1
    //   212: astore 7
    //   214: sipush 4096
    //   217: newarray byte
    //   219: astore 9
    //   221: aload_1
    //   222: astore_2
    //   223: aload_1
    //   224: astore 7
    //   226: aload 8
    //   228: aload 9
    //   230: iconst_0
    //   231: aload 9
    //   233: arraylength
    //   234: invokevirtual 104	java/io/InputStream:read	([BII)I
    //   237: istore_3
    //   238: iload_3
    //   239: iconst_m1
    //   240: if_icmpeq +19 -> 259
    //   243: aload_1
    //   244: astore_2
    //   245: aload_1
    //   246: astore 7
    //   248: aload_1
    //   249: aload 9
    //   251: iconst_0
    //   252: iload_3
    //   253: invokevirtual 110	java/io/OutputStream:write	([BII)V
    //   256: goto -35 -> 221
    //   259: aload_1
    //   260: astore_2
    //   261: aload_1
    //   262: astore 7
    //   264: aload_1
    //   265: invokevirtual 113	java/io/OutputStream:flush	()V
    //   268: aload_1
    //   269: astore_2
    //   270: aload_1
    //   271: astore 7
    //   273: getstatic 68	com/tencent/mm/plugin/appbrand/appstorage/j:a	Lcom/tencent/mm/plugin/appbrand/appstorage/j;
    //   276: astore 9
    //   278: aload_1
    //   279: invokestatic 118	com/tencent/luggage/wxa/qz/af:a	(Ljava/io/Closeable;)V
    //   282: aload 8
    //   284: invokestatic 118	com/tencent/luggage/wxa/qz/af:a	(Ljava/io/Closeable;)V
    //   287: aload 9
    //   289: areturn
    //   290: astore_1
    //   291: goto +41 -> 332
    //   294: astore_1
    //   295: aload 7
    //   297: astore_2
    //   298: ldc 82
    //   300: ldc 120
    //   302: iconst_1
    //   303: anewarray 4	java/lang/Object
    //   306: dup
    //   307: iconst_0
    //   308: aload_1
    //   309: aastore
    //   310: invokestatic 122	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   313: aload 7
    //   315: astore_2
    //   316: getstatic 70	com/tencent/mm/plugin/appbrand/appstorage/j:b	Lcom/tencent/mm/plugin/appbrand/appstorage/j;
    //   319: astore_1
    //   320: aload 7
    //   322: invokestatic 118	com/tencent/luggage/wxa/qz/af:a	(Ljava/io/Closeable;)V
    //   325: aload 8
    //   327: invokestatic 118	com/tencent/luggage/wxa/qz/af:a	(Ljava/io/Closeable;)V
    //   330: aload_1
    //   331: areturn
    //   332: aload_2
    //   333: invokestatic 118	com/tencent/luggage/wxa/qz/af:a	(Ljava/io/Closeable;)V
    //   336: aload 8
    //   338: invokestatic 118	com/tencent/luggage/wxa/qz/af:a	(Ljava/io/Closeable;)V
    //   341: goto +5 -> 346
    //   344: aload_1
    //   345: athrow
    //   346: goto -2 -> 344
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	349	0	this	12
    //   0	349	1	parami	com.tencent.luggage.wxa.rt.i
    //   0	349	2	paramVarArgs	Object[]
    //   128	125	3	i	int
    //   28	176	4	bool	boolean
    //   131	10	5	l	long
    //   195	126	7	locali	com.tencent.luggage.wxa.rt.i
    //   17	320	8	localInputStream	java.io.InputStream
    //   219	69	9	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   123	129	158	java/lang/Exception
    //   199	209	290	finally
    //   214	221	290	finally
    //   226	238	290	finally
    //   248	256	290	finally
    //   264	268	290	finally
    //   273	278	290	finally
    //   298	313	290	finally
    //   316	320	290	finally
    //   199	209	294	java/lang/Exception
    //   214	221	294	java/lang/Exception
    //   226	238	294	java/lang/Exception
    //   248	256	294	java/lang/Exception
    //   264	268	294	java/lang/Exception
    //   273	278	294	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.x.12
 * JD-Core Version:    0.7.0.1
 */