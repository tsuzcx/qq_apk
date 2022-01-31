public class bhph
{
  private byte a = 0;
  
  /* Error */
  public boolean a(java.lang.String paramString1, byte[] paramArrayOfByte, java.lang.String paramString2, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 6
    //   6: aload_3
    //   7: astore 5
    //   9: aload_3
    //   10: ifnonnull +7 -> 17
    //   13: ldc 18
    //   15: astore 5
    //   17: aload 7
    //   19: astore_3
    //   20: new 20	com/tencent/qphone/base/util/Cryptor
    //   23: dup
    //   24: invokespecial 21	com/tencent/qphone/base/util/Cryptor:<init>	()V
    //   27: aload_2
    //   28: aload 5
    //   30: invokevirtual 27	java/lang/String:getBytes	()[B
    //   33: invokevirtual 31	com/tencent/qphone/base/util/Cryptor:encrypt	([B[B)[B
    //   36: astore_2
    //   37: aload_2
    //   38: ifnonnull +33 -> 71
    //   41: aload 7
    //   43: astore_3
    //   44: aload_0
    //   45: bipush 8
    //   47: putfield 12	bhph:a	B
    //   50: iconst_0
    //   51: ifeq +11 -> 62
    //   54: new 33	java/lang/NullPointerException
    //   57: dup
    //   58: invokespecial 34	java/lang/NullPointerException:<init>	()V
    //   61: athrow
    //   62: iconst_0
    //   63: ireturn
    //   64: astore_1
    //   65: aload_1
    //   66: invokevirtual 37	java/io/IOException:printStackTrace	()V
    //   69: iconst_0
    //   70: ireturn
    //   71: aload 7
    //   73: astore_3
    //   74: new 39	java/io/DataOutputStream
    //   77: dup
    //   78: new 41	java/io/FileOutputStream
    //   81: dup
    //   82: aload_1
    //   83: invokespecial 44	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   86: invokespecial 47	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   89: astore_1
    //   90: aload_1
    //   91: ldc 48
    //   93: invokevirtual 52	java/io/DataOutputStream:writeInt	(I)V
    //   96: aload_1
    //   97: iload 4
    //   99: invokevirtual 52	java/io/DataOutputStream:writeInt	(I)V
    //   102: aload_1
    //   103: iconst_1
    //   104: invokevirtual 52	java/io/DataOutputStream:writeInt	(I)V
    //   107: aload_1
    //   108: aload_2
    //   109: invokevirtual 56	java/io/DataOutputStream:write	([B)V
    //   112: aload_1
    //   113: ifnull +7 -> 120
    //   116: aload_1
    //   117: invokevirtual 59	java/io/DataOutputStream:close	()V
    //   120: iconst_1
    //   121: ireturn
    //   122: astore_1
    //   123: aload_1
    //   124: invokevirtual 37	java/io/IOException:printStackTrace	()V
    //   127: goto -7 -> 120
    //   130: astore_2
    //   131: aload 6
    //   133: astore_1
    //   134: aload_1
    //   135: astore_3
    //   136: aload_0
    //   137: bipush 6
    //   139: putfield 12	bhph:a	B
    //   142: aload_1
    //   143: astore_3
    //   144: aload_2
    //   145: invokevirtual 37	java/io/IOException:printStackTrace	()V
    //   148: aload_1
    //   149: ifnull -87 -> 62
    //   152: aload_1
    //   153: invokevirtual 59	java/io/DataOutputStream:close	()V
    //   156: iconst_0
    //   157: ireturn
    //   158: astore_1
    //   159: aload_1
    //   160: invokevirtual 37	java/io/IOException:printStackTrace	()V
    //   163: iconst_0
    //   164: ireturn
    //   165: astore_1
    //   166: aload_3
    //   167: astore_2
    //   168: aload_2
    //   169: ifnull +7 -> 176
    //   172: aload_2
    //   173: invokevirtual 59	java/io/DataOutputStream:close	()V
    //   176: aload_1
    //   177: athrow
    //   178: astore_2
    //   179: aload_2
    //   180: invokevirtual 37	java/io/IOException:printStackTrace	()V
    //   183: goto -7 -> 176
    //   186: astore_3
    //   187: aload_1
    //   188: astore_2
    //   189: aload_3
    //   190: astore_1
    //   191: goto -23 -> 168
    //   194: astore_2
    //   195: goto -61 -> 134
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	198	0	this	bhph
    //   0	198	1	paramString1	java.lang.String
    //   0	198	2	paramArrayOfByte	byte[]
    //   0	198	3	paramString2	java.lang.String
    //   0	198	4	paramInt	int
    //   7	22	5	str	java.lang.String
    //   4	128	6	localObject1	Object
    //   1	71	7	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   54	62	64	java/io/IOException
    //   116	120	122	java/io/IOException
    //   20	37	130	java/io/IOException
    //   44	50	130	java/io/IOException
    //   74	90	130	java/io/IOException
    //   152	156	158	java/io/IOException
    //   20	37	165	finally
    //   44	50	165	finally
    //   74	90	165	finally
    //   136	142	165	finally
    //   144	148	165	finally
    //   172	176	178	java/io/IOException
    //   90	112	186	finally
    //   90	112	194	java/io/IOException
  }
  
  /* Error */
  public byte[] a(java.lang.String paramString1, java.lang.String paramString2, int paramInt)
  {
    // Byte code:
    //   0: new 62	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 63	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_1
    //   9: aload_1
    //   10: invokevirtual 67	java/io/File:exists	()Z
    //   13: ifne +10 -> 23
    //   16: aload_0
    //   17: iconst_1
    //   18: putfield 12	bhph:a	B
    //   21: aconst_null
    //   22: areturn
    //   23: new 69	java/io/DataInputStream
    //   26: dup
    //   27: new 71	java/io/FileInputStream
    //   30: dup
    //   31: aload_1
    //   32: invokespecial 74	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   35: invokespecial 77	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   38: astore 6
    //   40: aload 6
    //   42: astore_1
    //   43: aload 6
    //   45: invokevirtual 81	java/io/DataInputStream:available	()I
    //   48: istore 4
    //   50: iload 4
    //   52: bipush 12
    //   54: if_icmple +10 -> 64
    //   57: iload 4
    //   59: ldc 82
    //   61: if_icmple +30 -> 91
    //   64: aload 6
    //   66: astore_1
    //   67: aload_0
    //   68: iconst_2
    //   69: putfield 12	bhph:a	B
    //   72: aload 6
    //   74: ifnull -53 -> 21
    //   77: aload 6
    //   79: invokevirtual 83	java/io/DataInputStream:close	()V
    //   82: aconst_null
    //   83: areturn
    //   84: astore_1
    //   85: aload_1
    //   86: invokevirtual 37	java/io/IOException:printStackTrace	()V
    //   89: aconst_null
    //   90: areturn
    //   91: aload 6
    //   93: astore_1
    //   94: aload 6
    //   96: invokevirtual 86	java/io/DataInputStream:readInt	()I
    //   99: ldc 48
    //   101: if_icmpeq +30 -> 131
    //   104: aload 6
    //   106: astore_1
    //   107: aload_0
    //   108: iconst_3
    //   109: putfield 12	bhph:a	B
    //   112: aload 6
    //   114: ifnull -93 -> 21
    //   117: aload 6
    //   119: invokevirtual 83	java/io/DataInputStream:close	()V
    //   122: aconst_null
    //   123: areturn
    //   124: astore_1
    //   125: aload_1
    //   126: invokevirtual 37	java/io/IOException:printStackTrace	()V
    //   129: aconst_null
    //   130: areturn
    //   131: aload 6
    //   133: astore_1
    //   134: aload 6
    //   136: invokevirtual 86	java/io/DataInputStream:readInt	()I
    //   139: istore 5
    //   141: iload 5
    //   143: ifle +9 -> 152
    //   146: iload 5
    //   148: iload_3
    //   149: if_icmple +30 -> 179
    //   152: aload 6
    //   154: astore_1
    //   155: aload_0
    //   156: iconst_4
    //   157: putfield 12	bhph:a	B
    //   160: aload 6
    //   162: ifnull -141 -> 21
    //   165: aload 6
    //   167: invokevirtual 83	java/io/DataInputStream:close	()V
    //   170: aconst_null
    //   171: areturn
    //   172: astore_1
    //   173: aload_1
    //   174: invokevirtual 37	java/io/IOException:printStackTrace	()V
    //   177: aconst_null
    //   178: areturn
    //   179: aload 6
    //   181: astore_1
    //   182: aload 6
    //   184: invokevirtual 86	java/io/DataInputStream:readInt	()I
    //   187: iconst_1
    //   188: if_icmpeq +30 -> 218
    //   191: aload 6
    //   193: astore_1
    //   194: aload_0
    //   195: iconst_5
    //   196: putfield 12	bhph:a	B
    //   199: aload 6
    //   201: ifnull -180 -> 21
    //   204: aload 6
    //   206: invokevirtual 83	java/io/DataInputStream:close	()V
    //   209: aconst_null
    //   210: areturn
    //   211: astore_1
    //   212: aload_1
    //   213: invokevirtual 37	java/io/IOException:printStackTrace	()V
    //   216: aconst_null
    //   217: areturn
    //   218: aload 6
    //   220: astore_1
    //   221: iload 4
    //   223: bipush 12
    //   225: isub
    //   226: newarray byte
    //   228: astore 8
    //   230: aload 6
    //   232: astore_1
    //   233: aload 8
    //   235: arraylength
    //   236: aload 6
    //   238: aload 8
    //   240: invokevirtual 90	java/io/DataInputStream:read	([B)I
    //   243: if_icmpeq +31 -> 274
    //   246: aload 6
    //   248: astore_1
    //   249: aload_0
    //   250: bipush 6
    //   252: putfield 12	bhph:a	B
    //   255: aload 6
    //   257: ifnull -236 -> 21
    //   260: aload 6
    //   262: invokevirtual 83	java/io/DataInputStream:close	()V
    //   265: aconst_null
    //   266: areturn
    //   267: astore_1
    //   268: aload_1
    //   269: invokevirtual 37	java/io/IOException:printStackTrace	()V
    //   272: aconst_null
    //   273: areturn
    //   274: aload_2
    //   275: astore 7
    //   277: aload_2
    //   278: ifnonnull +7 -> 285
    //   281: ldc 18
    //   283: astore 7
    //   285: aload 6
    //   287: astore_1
    //   288: new 20	com/tencent/qphone/base/util/Cryptor
    //   291: dup
    //   292: invokespecial 21	com/tencent/qphone/base/util/Cryptor:<init>	()V
    //   295: aload 8
    //   297: iconst_0
    //   298: aload 8
    //   300: arraylength
    //   301: aload 7
    //   303: invokevirtual 27	java/lang/String:getBytes	()[B
    //   306: invokevirtual 94	com/tencent/qphone/base/util/Cryptor:decrypt	([BII[B)[B
    //   309: astore_2
    //   310: aload_2
    //   311: ifnonnull +31 -> 342
    //   314: aload 6
    //   316: astore_1
    //   317: aload_0
    //   318: bipush 7
    //   320: putfield 12	bhph:a	B
    //   323: aload 6
    //   325: ifnull -304 -> 21
    //   328: aload 6
    //   330: invokevirtual 83	java/io/DataInputStream:close	()V
    //   333: aconst_null
    //   334: areturn
    //   335: astore_1
    //   336: aload_1
    //   337: invokevirtual 37	java/io/IOException:printStackTrace	()V
    //   340: aconst_null
    //   341: areturn
    //   342: aload 6
    //   344: ifnull +8 -> 352
    //   347: aload 6
    //   349: invokevirtual 83	java/io/DataInputStream:close	()V
    //   352: aload_2
    //   353: areturn
    //   354: astore_1
    //   355: aload_1
    //   356: invokevirtual 37	java/io/IOException:printStackTrace	()V
    //   359: goto -7 -> 352
    //   362: astore 7
    //   364: aconst_null
    //   365: astore_2
    //   366: aload_2
    //   367: astore_1
    //   368: aload_0
    //   369: bipush 6
    //   371: putfield 12	bhph:a	B
    //   374: aload_2
    //   375: astore_1
    //   376: aload 7
    //   378: invokevirtual 37	java/io/IOException:printStackTrace	()V
    //   381: aload_2
    //   382: ifnull -361 -> 21
    //   385: aload_2
    //   386: invokevirtual 83	java/io/DataInputStream:close	()V
    //   389: aconst_null
    //   390: areturn
    //   391: astore_1
    //   392: aload_1
    //   393: invokevirtual 37	java/io/IOException:printStackTrace	()V
    //   396: aconst_null
    //   397: areturn
    //   398: astore_2
    //   399: aconst_null
    //   400: astore_1
    //   401: aload_1
    //   402: ifnull +7 -> 409
    //   405: aload_1
    //   406: invokevirtual 83	java/io/DataInputStream:close	()V
    //   409: aload_2
    //   410: athrow
    //   411: astore_1
    //   412: aload_1
    //   413: invokevirtual 37	java/io/IOException:printStackTrace	()V
    //   416: goto -7 -> 409
    //   419: astore_2
    //   420: goto -19 -> 401
    //   423: astore 7
    //   425: aload 6
    //   427: astore_2
    //   428: goto -62 -> 366
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	431	0	this	bhph
    //   0	431	1	paramString1	java.lang.String
    //   0	431	2	paramString2	java.lang.String
    //   0	431	3	paramInt	int
    //   48	178	4	i	int
    //   139	11	5	j	int
    //   38	388	6	localDataInputStream	java.io.DataInputStream
    //   275	27	7	str	java.lang.String
    //   362	15	7	localIOException1	java.io.IOException
    //   423	1	7	localIOException2	java.io.IOException
    //   228	71	8	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   77	82	84	java/io/IOException
    //   117	122	124	java/io/IOException
    //   165	170	172	java/io/IOException
    //   204	209	211	java/io/IOException
    //   260	265	267	java/io/IOException
    //   328	333	335	java/io/IOException
    //   347	352	354	java/io/IOException
    //   23	40	362	java/io/IOException
    //   385	389	391	java/io/IOException
    //   23	40	398	finally
    //   405	409	411	java/io/IOException
    //   43	50	419	finally
    //   67	72	419	finally
    //   94	104	419	finally
    //   107	112	419	finally
    //   134	141	419	finally
    //   155	160	419	finally
    //   182	191	419	finally
    //   194	199	419	finally
    //   221	230	419	finally
    //   233	246	419	finally
    //   249	255	419	finally
    //   288	310	419	finally
    //   317	323	419	finally
    //   368	374	419	finally
    //   376	381	419	finally
    //   43	50	423	java/io/IOException
    //   67	72	423	java/io/IOException
    //   94	104	423	java/io/IOException
    //   107	112	423	java/io/IOException
    //   134	141	423	java/io/IOException
    //   155	160	423	java/io/IOException
    //   182	191	423	java/io/IOException
    //   194	199	423	java/io/IOException
    //   221	230	423	java/io/IOException
    //   233	246	423	java/io/IOException
    //   249	255	423	java/io/IOException
    //   288	310	423	java/io/IOException
    //   317	323	423	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhph
 * JD-Core Version:    0.7.0.1
 */