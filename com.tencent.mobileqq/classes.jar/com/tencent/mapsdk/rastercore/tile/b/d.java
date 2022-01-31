package com.tencent.mapsdk.rastercore.tile.b;

public final class d
  extends a
{
  private String[] a = { "https://m0.map.gtimg.com/hwap", "https://m1.map.gtimg.com/hwap", "https://m2.map.gtimg.com/hwap", "https://m3.map.gtimg.com/hwap" };
  
  public d(int paramInt)
  {
    super(paramInt);
  }
  
  /* Error */
  public final java.net.URL getTileUrl(int paramInt1, int paramInt2, int paramInt3, java.lang.Object... paramVarArgs)
  {
    // Byte code:
    //   0: getstatic 34	com/tencent/mapsdk/rastercore/b:a	I
    //   3: istore 5
    //   5: iconst_0
    //   6: istore 9
    //   8: iload 9
    //   10: istore 6
    //   12: iload 5
    //   14: istore 7
    //   16: aload 4
    //   18: ifnull +331 -> 349
    //   21: iload 9
    //   23: istore 6
    //   25: iload 5
    //   27: istore 7
    //   29: iload 5
    //   31: istore 8
    //   33: aload 4
    //   35: arraylength
    //   36: ifle +313 -> 349
    //   39: iload 5
    //   41: istore 8
    //   43: aload 4
    //   45: iconst_0
    //   46: aaload
    //   47: invokevirtual 40	java/lang/Object:toString	()Ljava/lang/String;
    //   50: invokestatic 46	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   53: istore 5
    //   55: iload 5
    //   57: istore 8
    //   59: aload 4
    //   61: arraylength
    //   62: iconst_3
    //   63: if_icmpne +237 -> 300
    //   66: iload 5
    //   68: istore 8
    //   70: aload 4
    //   72: iconst_1
    //   73: aaload
    //   74: invokevirtual 40	java/lang/Object:toString	()Ljava/lang/String;
    //   77: astore 11
    //   79: aload 4
    //   81: iconst_2
    //   82: aaload
    //   83: invokevirtual 40	java/lang/Object:toString	()Ljava/lang/String;
    //   86: invokestatic 52	java/lang/Boolean:parseBoolean	(Ljava/lang/String;)Z
    //   89: istore 10
    //   91: iconst_0
    //   92: istore 7
    //   94: aload 11
    //   96: astore 4
    //   98: iload 5
    //   100: istore 6
    //   102: iload 7
    //   104: istore 5
    //   106: iload_1
    //   107: iload_2
    //   108: iadd
    //   109: aload_0
    //   110: getfield 22	com/tencent/mapsdk/rastercore/tile/b/d:a	[Ljava/lang/String;
    //   113: arraylength
    //   114: invokestatic 55	com/tencent/mapsdk/rastercore/tile/b/d:a	(II)I
    //   117: istore 7
    //   119: ldc2_w 56
    //   122: iload_3
    //   123: i2d
    //   124: invokestatic 63	java/lang/Math:pow	(DD)D
    //   127: iload_2
    //   128: i2d
    //   129: dsub
    //   130: dconst_1
    //   131: dsub
    //   132: d2i
    //   133: istore_2
    //   134: new 65	java/lang/StringBuilder
    //   137: dup
    //   138: sipush 128
    //   141: invokespecial 66	java/lang/StringBuilder:<init>	(I)V
    //   144: astore 11
    //   146: aload 11
    //   148: aload_0
    //   149: getfield 22	com/tencent/mapsdk/rastercore/tile/b/d:a	[Ljava/lang/String;
    //   152: iload 7
    //   154: aaload
    //   155: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: pop
    //   159: aload 11
    //   161: ldc 72
    //   163: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: pop
    //   167: aload 11
    //   169: ldc 74
    //   171: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: pop
    //   175: aload 11
    //   177: iload_3
    //   178: iconst_1
    //   179: isub
    //   180: invokevirtual 77	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   183: pop
    //   184: aload 11
    //   186: ldc 79
    //   188: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: pop
    //   192: aload 11
    //   194: iload_1
    //   195: invokevirtual 77	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   198: pop
    //   199: aload 11
    //   201: ldc 81
    //   203: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: pop
    //   207: aload 11
    //   209: iload_2
    //   210: invokevirtual 77	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   213: pop
    //   214: aload 11
    //   216: ldc 83
    //   218: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: pop
    //   222: iload 5
    //   224: ifeq +178 -> 402
    //   227: aload 11
    //   229: bipush 7
    //   231: invokevirtual 77	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   234: pop
    //   235: aload 11
    //   237: ldc 85
    //   239: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: pop
    //   243: aload 11
    //   245: iload 6
    //   247: invokevirtual 77	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   250: pop
    //   251: new 87	java/lang/StringBuffer
    //   254: dup
    //   255: aload 11
    //   257: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   260: invokespecial 91	java/lang/StringBuffer:<init>	(Ljava/lang/String;)V
    //   263: astore 11
    //   265: iload 10
    //   267: ifeq +16 -> 283
    //   270: aload 11
    //   272: ldc 93
    //   274: invokevirtual 96	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   277: aload 4
    //   279: invokevirtual 96	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   282: pop
    //   283: new 98	java/net/URL
    //   286: dup
    //   287: aload 11
    //   289: invokevirtual 99	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   292: invokespecial 100	java/net/URL:<init>	(Ljava/lang/String;)V
    //   295: astore 4
    //   297: aload 4
    //   299: areturn
    //   300: iload 9
    //   302: istore 6
    //   304: iload 5
    //   306: istore 7
    //   308: iload 5
    //   310: istore 8
    //   312: aload 4
    //   314: arraylength
    //   315: iconst_2
    //   316: if_icmpne +33 -> 349
    //   319: iload 5
    //   321: istore 8
    //   323: aload 4
    //   325: iconst_1
    //   326: aaload
    //   327: invokevirtual 40	java/lang/Object:toString	()Ljava/lang/String;
    //   330: invokestatic 46	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   333: istore 6
    //   335: bipush 7
    //   337: iload 6
    //   339: if_icmpne +27 -> 366
    //   342: iconst_1
    //   343: istore 6
    //   345: iload 5
    //   347: istore 7
    //   349: iconst_0
    //   350: istore 10
    //   352: iload 6
    //   354: istore 5
    //   356: aconst_null
    //   357: astore 4
    //   359: iload 7
    //   361: istore 6
    //   363: goto -257 -> 106
    //   366: iconst_0
    //   367: istore 6
    //   369: iload 5
    //   371: istore 7
    //   373: goto -24 -> 349
    //   376: astore 4
    //   378: iload 8
    //   380: istore 5
    //   382: aconst_null
    //   383: astore 4
    //   385: iconst_0
    //   386: istore 7
    //   388: iload 5
    //   390: istore 6
    //   392: iconst_0
    //   393: istore 10
    //   395: iload 7
    //   397: istore 5
    //   399: goto -293 -> 106
    //   402: aload 11
    //   404: invokestatic 105	com/tencent/mapsdk/rastercore/d/h:a	()I
    //   407: invokevirtual 77	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   410: pop
    //   411: goto -176 -> 235
    //   414: astore 4
    //   416: new 65	java/lang/StringBuilder
    //   419: dup
    //   420: ldc 107
    //   422: invokespecial 108	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   425: aconst_null
    //   426: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   429: pop
    //   430: aconst_null
    //   431: areturn
    //   432: astore 4
    //   434: aload 11
    //   436: astore 4
    //   438: goto -53 -> 385
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	441	0	this	d
    //   0	441	1	paramInt1	int
    //   0	441	2	paramInt2	int
    //   0	441	3	paramInt3	int
    //   0	441	4	paramVarArgs	java.lang.Object[]
    //   3	395	5	i	int
    //   10	381	6	j	int
    //   14	382	7	k	int
    //   31	348	8	m	int
    //   6	295	9	n	int
    //   89	305	10	bool	boolean
    //   77	358	11	localObject	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   33	39	376	java/lang/Exception
    //   43	55	376	java/lang/Exception
    //   59	66	376	java/lang/Exception
    //   70	79	376	java/lang/Exception
    //   312	319	376	java/lang/Exception
    //   323	335	376	java/lang/Exception
    //   106	222	414	java/net/MalformedURLException
    //   227	235	414	java/net/MalformedURLException
    //   235	265	414	java/net/MalformedURLException
    //   270	283	414	java/net/MalformedURLException
    //   283	297	414	java/net/MalformedURLException
    //   402	411	414	java/net/MalformedURLException
    //   79	91	432	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mapsdk.rastercore.tile.b.d
 * JD-Core Version:    0.7.0.1
 */