package com.tencent.luggage.wxa.hd;

import java.util.Map;

public final class a
{
  private static a e;
  private Map<Integer, Object> a;
  private boolean b = false;
  private String c = "";
  private boolean d = false;
  
  private a(String paramString)
  {
    this.c = paramString;
    c();
    this.b = false;
  }
  
  public static a a()
  {
    try
    {
      if (e == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(com.tencent.luggage.wxa.hz.a.i());
        ((StringBuilder)localObject1).append("CompatibleInfo.cfg");
        e = new a(((StringBuilder)localObject1).toString());
      }
      Object localObject1 = e;
      return localObject1;
    }
    finally {}
  }
  
  /* Error */
  private void c()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore 4
    //   5: new 60	com/tencent/luggage/wxa/rt/i
    //   8: dup
    //   9: aload_0
    //   10: getfield 27	com/tencent/luggage/wxa/hd/a:c	Ljava/lang/String;
    //   13: invokespecial 61	com/tencent/luggage/wxa/rt/i:<init>	(Ljava/lang/String;)V
    //   16: astore_1
    //   17: aload_1
    //   18: invokevirtual 65	com/tencent/luggage/wxa/rt/i:j	()Z
    //   21: ifne +21 -> 42
    //   24: aload_0
    //   25: iconst_1
    //   26: putfield 29	com/tencent/luggage/wxa/hd/a:d	Z
    //   29: aload_1
    //   30: invokevirtual 68	com/tencent/luggage/wxa/rt/i:f	()Ljava/lang/String;
    //   33: invokestatic 74	com/tencent/luggage/wxa/rt/k:g	(Ljava/lang/String;)Z
    //   36: pop
    //   37: aload_1
    //   38: invokevirtual 77	com/tencent/luggage/wxa/rt/i:v	()Z
    //   41: pop
    //   42: aload_1
    //   43: invokevirtual 81	com/tencent/luggage/wxa/rt/i:q	()J
    //   46: lconst_0
    //   47: lcmp
    //   48: ifne +20 -> 68
    //   51: aload_0
    //   52: iconst_1
    //   53: putfield 29	com/tencent/luggage/wxa/hd/a:d	Z
    //   56: aload_0
    //   57: new 83	java/util/HashMap
    //   60: dup
    //   61: invokespecial 84	java/util/HashMap:<init>	()V
    //   64: putfield 86	com/tencent/luggage/wxa/hd/a:a	Ljava/util/Map;
    //   67: return
    //   68: aload_1
    //   69: invokestatic 89	com/tencent/luggage/wxa/rt/k:a	(Lcom/tencent/luggage/wxa/rt/i;)Ljava/io/InputStream;
    //   72: astore_1
    //   73: new 91	java/io/ObjectInputStream
    //   76: dup
    //   77: aload_1
    //   78: invokespecial 94	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   81: astore 4
    //   83: aload_0
    //   84: aload 4
    //   86: invokevirtual 98	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   89: checkcast 100	java/util/Map
    //   92: putfield 86	com/tencent/luggage/wxa/hd/a:a	Ljava/util/Map;
    //   95: aload 4
    //   97: invokevirtual 103	java/io/ObjectInputStream:close	()V
    //   100: aload_1
    //   101: invokevirtual 106	java/io/InputStream:close	()V
    //   104: aload_1
    //   105: ifnull +23 -> 128
    //   108: aload_1
    //   109: invokevirtual 106	java/io/InputStream:close	()V
    //   112: goto +16 -> 128
    //   115: astore_1
    //   116: ldc 108
    //   118: aload_1
    //   119: ldc 25
    //   121: iconst_0
    //   122: anewarray 4	java/lang/Object
    //   125: invokestatic 113	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   128: aload 4
    //   130: invokevirtual 103	java/io/ObjectInputStream:close	()V
    //   133: return
    //   134: astore_1
    //   135: ldc 108
    //   137: aload_1
    //   138: ldc 25
    //   140: iconst_0
    //   141: anewarray 4	java/lang/Object
    //   144: invokestatic 113	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   147: return
    //   148: astore_2
    //   149: aload 4
    //   151: astore_3
    //   152: goto +117 -> 269
    //   155: astore_3
    //   156: aload 4
    //   158: astore_2
    //   159: goto +33 -> 192
    //   162: astore_2
    //   163: aconst_null
    //   164: astore_3
    //   165: goto +104 -> 269
    //   168: astore_3
    //   169: aconst_null
    //   170: astore_2
    //   171: goto +21 -> 192
    //   174: astore 4
    //   176: aconst_null
    //   177: astore_3
    //   178: aload_2
    //   179: astore_1
    //   180: aload 4
    //   182: astore_2
    //   183: goto +86 -> 269
    //   186: astore_3
    //   187: aconst_null
    //   188: astore_2
    //   189: aload 4
    //   191: astore_1
    //   192: aload_0
    //   193: new 83	java/util/HashMap
    //   196: dup
    //   197: invokespecial 84	java/util/HashMap:<init>	()V
    //   200: putfield 86	com/tencent/luggage/wxa/hd/a:a	Ljava/util/Map;
    //   203: ldc 108
    //   205: aload_3
    //   206: ldc 25
    //   208: iconst_0
    //   209: anewarray 4	java/lang/Object
    //   212: invokestatic 113	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   215: aload_1
    //   216: ifnull +23 -> 239
    //   219: aload_1
    //   220: invokevirtual 106	java/io/InputStream:close	()V
    //   223: goto +16 -> 239
    //   226: astore_1
    //   227: ldc 108
    //   229: aload_1
    //   230: ldc 25
    //   232: iconst_0
    //   233: anewarray 4	java/lang/Object
    //   236: invokestatic 113	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   239: aload_2
    //   240: ifnull +21 -> 261
    //   243: aload_2
    //   244: invokevirtual 103	java/io/ObjectInputStream:close	()V
    //   247: return
    //   248: astore_1
    //   249: ldc 108
    //   251: aload_1
    //   252: ldc 25
    //   254: iconst_0
    //   255: anewarray 4	java/lang/Object
    //   258: invokestatic 113	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   261: return
    //   262: astore 4
    //   264: aload_2
    //   265: astore_3
    //   266: aload 4
    //   268: astore_2
    //   269: aload_1
    //   270: ifnull +23 -> 293
    //   273: aload_1
    //   274: invokevirtual 106	java/io/InputStream:close	()V
    //   277: goto +16 -> 293
    //   280: astore_1
    //   281: ldc 108
    //   283: aload_1
    //   284: ldc 25
    //   286: iconst_0
    //   287: anewarray 4	java/lang/Object
    //   290: invokestatic 113	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   293: aload_3
    //   294: ifnull +23 -> 317
    //   297: aload_3
    //   298: invokevirtual 103	java/io/ObjectInputStream:close	()V
    //   301: goto +16 -> 317
    //   304: astore_1
    //   305: ldc 108
    //   307: aload_1
    //   308: ldc 25
    //   310: iconst_0
    //   311: anewarray 4	java/lang/Object
    //   314: invokestatic 113	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   317: aload_2
    //   318: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	319	0	this	a
    //   16	93	1	localObject1	Object
    //   115	4	1	localIOException1	java.io.IOException
    //   134	4	1	localIOException2	java.io.IOException
    //   179	41	1	localObject2	Object
    //   226	4	1	localIOException3	java.io.IOException
    //   248	26	1	localIOException4	java.io.IOException
    //   280	4	1	localIOException5	java.io.IOException
    //   304	4	1	localIOException6	java.io.IOException
    //   1	1	2	localObject3	Object
    //   148	1	2	localObject4	Object
    //   158	1	2	localObject5	Object
    //   162	1	2	localObject6	Object
    //   170	148	2	localObject7	Object
    //   151	1	3	localObjectInputStream1	java.io.ObjectInputStream
    //   155	1	3	localException1	java.lang.Exception
    //   164	1	3	localObject8	Object
    //   168	1	3	localException2	java.lang.Exception
    //   177	1	3	localObject9	Object
    //   186	20	3	localException3	java.lang.Exception
    //   265	33	3	localObject10	Object
    //   3	154	4	localObjectInputStream2	java.io.ObjectInputStream
    //   174	16	4	localObject11	Object
    //   262	5	4	localObject12	Object
    // Exception table:
    //   from	to	target	type
    //   108	112	115	java/io/IOException
    //   128	133	134	java/io/IOException
    //   83	104	148	finally
    //   83	104	155	java/lang/Exception
    //   73	83	162	finally
    //   73	83	168	java/lang/Exception
    //   5	42	174	finally
    //   42	67	174	finally
    //   68	73	174	finally
    //   5	42	186	java/lang/Exception
    //   42	67	186	java/lang/Exception
    //   68	73	186	java/lang/Exception
    //   219	223	226	java/io/IOException
    //   243	247	248	java/io/IOException
    //   192	215	262	finally
    //   273	277	280	java/io/IOException
    //   297	301	304	java/io/IOException
  }
  
  /* Error */
  private void d()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 115	java/io/FileOutputStream
    //   5: dup
    //   6: aload_0
    //   7: getfield 27	com/tencent/luggage/wxa/hd/a:c	Ljava/lang/String;
    //   10: invokespecial 116	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   13: astore_1
    //   14: new 118	java/io/ObjectOutputStream
    //   17: dup
    //   18: aload_1
    //   19: invokespecial 121	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   22: astore 6
    //   24: aload_1
    //   25: astore_2
    //   26: aload 6
    //   28: astore 5
    //   30: aload 6
    //   32: aload_0
    //   33: getfield 86	com/tencent/luggage/wxa/hd/a:a	Ljava/util/Map;
    //   36: invokevirtual 125	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   39: aload_1
    //   40: astore_2
    //   41: aload 6
    //   43: astore 5
    //   45: aload 6
    //   47: invokevirtual 126	java/io/ObjectOutputStream:close	()V
    //   50: aload_1
    //   51: astore_2
    //   52: aload 6
    //   54: astore 5
    //   56: aload_1
    //   57: invokevirtual 129	java/io/FileOutputStream:flush	()V
    //   60: aload_1
    //   61: astore_2
    //   62: aload 6
    //   64: astore 5
    //   66: aload_1
    //   67: invokevirtual 130	java/io/FileOutputStream:close	()V
    //   70: aload_1
    //   71: invokevirtual 130	java/io/FileOutputStream:close	()V
    //   74: goto +16 -> 90
    //   77: astore_1
    //   78: ldc 108
    //   80: aload_1
    //   81: ldc 25
    //   83: iconst_0
    //   84: anewarray 4	java/lang/Object
    //   87: invokestatic 113	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   90: aload 6
    //   92: invokevirtual 126	java/io/ObjectOutputStream:close	()V
    //   95: goto +131 -> 226
    //   98: astore_1
    //   99: ldc 108
    //   101: aload_1
    //   102: ldc 25
    //   104: iconst_0
    //   105: anewarray 4	java/lang/Object
    //   108: invokestatic 113	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   111: goto +115 -> 226
    //   114: astore_3
    //   115: aload_1
    //   116: astore 4
    //   118: aload 6
    //   120: astore_1
    //   121: goto +37 -> 158
    //   124: astore_2
    //   125: aconst_null
    //   126: astore 5
    //   128: goto +106 -> 234
    //   131: astore_3
    //   132: aconst_null
    //   133: astore_2
    //   134: aload_1
    //   135: astore 4
    //   137: aload_2
    //   138: astore_1
    //   139: goto +19 -> 158
    //   142: astore_2
    //   143: aconst_null
    //   144: astore 5
    //   146: aload 5
    //   148: astore_1
    //   149: goto +85 -> 234
    //   152: astore_3
    //   153: aconst_null
    //   154: astore_1
    //   155: aload_1
    //   156: astore 4
    //   158: aload 4
    //   160: astore_2
    //   161: aload_1
    //   162: astore 5
    //   164: ldc 108
    //   166: aload_3
    //   167: ldc 25
    //   169: iconst_0
    //   170: anewarray 4	java/lang/Object
    //   173: invokestatic 113	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   176: aload 4
    //   178: ifnull +24 -> 202
    //   181: aload 4
    //   183: invokevirtual 130	java/io/FileOutputStream:close	()V
    //   186: goto +16 -> 202
    //   189: astore_2
    //   190: ldc 108
    //   192: aload_2
    //   193: ldc 25
    //   195: iconst_0
    //   196: anewarray 4	java/lang/Object
    //   199: invokestatic 113	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   202: aload_1
    //   203: ifnull +23 -> 226
    //   206: aload_1
    //   207: invokevirtual 126	java/io/ObjectOutputStream:close	()V
    //   210: goto +16 -> 226
    //   213: astore_1
    //   214: ldc 108
    //   216: aload_1
    //   217: ldc 25
    //   219: iconst_0
    //   220: anewarray 4	java/lang/Object
    //   223: invokestatic 113	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   226: aload_0
    //   227: monitorexit
    //   228: return
    //   229: astore_3
    //   230: aload_2
    //   231: astore_1
    //   232: aload_3
    //   233: astore_2
    //   234: aload_1
    //   235: ifnull +27 -> 262
    //   238: aload_1
    //   239: invokevirtual 130	java/io/FileOutputStream:close	()V
    //   242: goto +20 -> 262
    //   245: astore_1
    //   246: goto +44 -> 290
    //   249: astore_1
    //   250: ldc 108
    //   252: aload_1
    //   253: ldc 25
    //   255: iconst_0
    //   256: anewarray 4	java/lang/Object
    //   259: invokestatic 113	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   262: aload 5
    //   264: ifnull +24 -> 288
    //   267: aload 5
    //   269: invokevirtual 126	java/io/ObjectOutputStream:close	()V
    //   272: goto +16 -> 288
    //   275: astore_1
    //   276: ldc 108
    //   278: aload_1
    //   279: ldc 25
    //   281: iconst_0
    //   282: anewarray 4	java/lang/Object
    //   285: invokestatic 113	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   288: aload_2
    //   289: athrow
    //   290: aload_0
    //   291: monitorexit
    //   292: aload_1
    //   293: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	294	0	this	a
    //   13	58	1	localFileOutputStream1	java.io.FileOutputStream
    //   77	4	1	localIOException1	java.io.IOException
    //   98	18	1	localIOException2	java.io.IOException
    //   120	87	1	localObject1	Object
    //   213	4	1	localIOException3	java.io.IOException
    //   231	8	1	localObject2	Object
    //   245	1	1	localObject3	Object
    //   249	4	1	localIOException4	java.io.IOException
    //   275	18	1	localIOException5	java.io.IOException
    //   25	37	2	localFileOutputStream2	java.io.FileOutputStream
    //   124	1	2	localObject4	Object
    //   133	5	2	localObject5	Object
    //   142	1	2	localObject6	Object
    //   160	1	2	localObject7	Object
    //   189	42	2	localIOException6	java.io.IOException
    //   233	56	2	localObject8	Object
    //   114	1	3	localIOException7	java.io.IOException
    //   131	1	3	localIOException8	java.io.IOException
    //   152	15	3	localIOException9	java.io.IOException
    //   229	4	3	localObject9	Object
    //   116	66	4	localObject10	Object
    //   28	240	5	localObject11	Object
    //   22	97	6	localObjectOutputStream	java.io.ObjectOutputStream
    // Exception table:
    //   from	to	target	type
    //   70	74	77	java/io/IOException
    //   90	95	98	java/io/IOException
    //   30	39	114	java/io/IOException
    //   45	50	114	java/io/IOException
    //   56	60	114	java/io/IOException
    //   66	70	114	java/io/IOException
    //   14	24	124	finally
    //   14	24	131	java/io/IOException
    //   2	14	142	finally
    //   2	14	152	java/io/IOException
    //   181	186	189	java/io/IOException
    //   206	210	213	java/io/IOException
    //   30	39	229	finally
    //   45	50	229	finally
    //   56	60	229	finally
    //   66	70	229	finally
    //   164	176	229	finally
    //   70	74	245	finally
    //   78	90	245	finally
    //   90	95	245	finally
    //   99	111	245	finally
    //   181	186	245	finally
    //   190	202	245	finally
    //   206	210	245	finally
    //   214	226	245	finally
    //   238	242	245	finally
    //   250	262	245	finally
    //   267	272	245	finally
    //   276	288	245	finally
    //   288	290	245	finally
    //   238	242	249	java/io/IOException
    //   267	272	275	java/io/IOException
  }
  
  public Object a(int paramInt)
  {
    return this.a.get(Integer.valueOf(paramInt));
  }
  
  public void a(int paramInt, Object paramObject)
  {
    try
    {
      this.a.put(Integer.valueOf(paramInt), paramObject);
      if (!this.b) {
        d();
      }
      return;
    }
    finally
    {
      paramObject = finally;
      throw paramObject;
    }
  }
  
  public boolean b()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.hd.a
 * JD-Core Version:    0.7.0.1
 */