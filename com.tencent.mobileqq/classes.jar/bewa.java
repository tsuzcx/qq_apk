import java.util.Map;
import java.util.jar.Attributes;

public class bewa
{
  static String a = "";
  static String b;
  static String c = bevz.a(bevz.r);
  
  static
  {
    a = bevz.a(bevz.p);
    b = "";
    b = bevz.a(bevz.q);
    c = "";
  }
  
  /* Error */
  public static int a(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 9
    //   3: aconst_null
    //   4: astore 8
    //   6: aconst_null
    //   7: astore 5
    //   9: aconst_null
    //   10: astore 7
    //   12: aconst_null
    //   13: astore 13
    //   15: aconst_null
    //   16: astore 10
    //   18: aconst_null
    //   19: astore 11
    //   21: aconst_null
    //   22: astore 12
    //   24: iconst_0
    //   25: istore_3
    //   26: new 43	java/util/jar/JarFile
    //   29: dup
    //   30: aload_0
    //   31: invokespecial 47	java/util/jar/JarFile:<init>	(Ljava/lang/String;)V
    //   34: astore 6
    //   36: aload 12
    //   38: astore 9
    //   40: aload 13
    //   42: astore_0
    //   43: aload 6
    //   45: astore 5
    //   47: aload 10
    //   49: astore 7
    //   51: aload 11
    //   53: astore 8
    //   55: aload 6
    //   57: aload_1
    //   58: invokevirtual 51	java/util/jar/JarFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   61: astore_1
    //   62: aload_1
    //   63: ifnonnull +36 -> 99
    //   66: iconst_2
    //   67: istore 4
    //   69: iconst_0
    //   70: ifeq +11 -> 81
    //   73: new 53	java/lang/NullPointerException
    //   76: dup
    //   77: invokespecial 55	java/lang/NullPointerException:<init>	()V
    //   80: athrow
    //   81: iload 4
    //   83: istore_3
    //   84: aload 6
    //   86: ifnull +11 -> 97
    //   89: aload 6
    //   91: invokevirtual 58	java/util/jar/JarFile:close	()V
    //   94: iload 4
    //   96: istore_3
    //   97: iload_3
    //   98: ireturn
    //   99: aload 12
    //   101: astore 9
    //   103: aload 13
    //   105: astore_0
    //   106: aload 6
    //   108: astore 5
    //   110: aload 10
    //   112: astore 7
    //   114: aload 11
    //   116: astore 8
    //   118: aload 6
    //   120: aload_1
    //   121: invokevirtual 62	java/util/jar/JarFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   124: astore_1
    //   125: aload_1
    //   126: astore 9
    //   128: aload_1
    //   129: astore_0
    //   130: aload 6
    //   132: astore 5
    //   134: aload_1
    //   135: astore 7
    //   137: aload_1
    //   138: astore 8
    //   140: getstatic 65	bevz:m	[B
    //   143: invokestatic 23	bevz:a	([B)Ljava/lang/String;
    //   146: invokestatic 71	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   149: astore 11
    //   151: aload_1
    //   152: astore 9
    //   154: aload_1
    //   155: astore_0
    //   156: aload 6
    //   158: astore 5
    //   160: aload_1
    //   161: astore 7
    //   163: aload_1
    //   164: astore 8
    //   166: sipush 8192
    //   169: newarray byte
    //   171: astore 10
    //   173: aload_1
    //   174: astore 9
    //   176: aload_1
    //   177: astore_0
    //   178: aload 6
    //   180: astore 5
    //   182: aload_1
    //   183: astore 7
    //   185: aload_1
    //   186: astore 8
    //   188: aload_1
    //   189: aload 10
    //   191: invokevirtual 77	java/io/InputStream:read	([B)I
    //   194: istore 4
    //   196: iload 4
    //   198: iconst_m1
    //   199: if_icmpeq +70 -> 269
    //   202: aload_1
    //   203: astore 9
    //   205: aload_1
    //   206: astore_0
    //   207: aload 6
    //   209: astore 5
    //   211: aload_1
    //   212: astore 7
    //   214: aload_1
    //   215: astore 8
    //   217: aload 11
    //   219: aload 10
    //   221: iconst_0
    //   222: iload 4
    //   224: invokevirtual 81	java/security/MessageDigest:update	([BII)V
    //   227: goto -54 -> 173
    //   230: astore_1
    //   231: aload 9
    //   233: astore_0
    //   234: aload 6
    //   236: astore 5
    //   238: aload_1
    //   239: invokevirtual 84	java/io/IOException:printStackTrace	()V
    //   242: iconst_3
    //   243: istore_3
    //   244: aload 9
    //   246: ifnull +8 -> 254
    //   249: aload 9
    //   251: invokevirtual 85	java/io/InputStream:close	()V
    //   254: aload 6
    //   256: ifnull -159 -> 97
    //   259: aload 6
    //   261: invokevirtual 58	java/util/jar/JarFile:close	()V
    //   264: iconst_3
    //   265: ireturn
    //   266: astore_0
    //   267: iconst_3
    //   268: ireturn
    //   269: aload_1
    //   270: astore 9
    //   272: aload_1
    //   273: astore_0
    //   274: aload 6
    //   276: astore 5
    //   278: aload_1
    //   279: astore 7
    //   281: aload_1
    //   282: astore 8
    //   284: aload 11
    //   286: invokevirtual 89	java/security/MessageDigest:digest	()[B
    //   289: astore 10
    //   291: aload_1
    //   292: astore 9
    //   294: aload_1
    //   295: astore_0
    //   296: aload 6
    //   298: astore 5
    //   300: aload_1
    //   301: astore 7
    //   303: aload_1
    //   304: astore 8
    //   306: aload 10
    //   308: iconst_0
    //   309: aload_2
    //   310: iconst_0
    //   311: aload 10
    //   313: arraylength
    //   314: invokestatic 95	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   317: aload_1
    //   318: ifnull +7 -> 325
    //   321: aload_1
    //   322: invokevirtual 85	java/io/InputStream:close	()V
    //   325: aload 6
    //   327: ifnull -230 -> 97
    //   330: aload 6
    //   332: invokevirtual 58	java/util/jar/JarFile:close	()V
    //   335: iconst_0
    //   336: ireturn
    //   337: astore_0
    //   338: iconst_0
    //   339: ireturn
    //   340: astore_1
    //   341: aconst_null
    //   342: astore 6
    //   344: aload 8
    //   346: astore_0
    //   347: aload 6
    //   349: astore 5
    //   351: aload_1
    //   352: invokevirtual 96	java/lang/OutOfMemoryError:printStackTrace	()V
    //   355: sipush 144
    //   358: istore_3
    //   359: aload 8
    //   361: ifnull +8 -> 369
    //   364: aload 8
    //   366: invokevirtual 85	java/io/InputStream:close	()V
    //   369: aload 6
    //   371: ifnull -274 -> 97
    //   374: aload 6
    //   376: invokevirtual 58	java/util/jar/JarFile:close	()V
    //   379: sipush 144
    //   382: ireturn
    //   383: astore_0
    //   384: sipush 144
    //   387: ireturn
    //   388: astore_1
    //   389: aconst_null
    //   390: astore 6
    //   392: aload 5
    //   394: astore 7
    //   396: aload 7
    //   398: astore_0
    //   399: aload 6
    //   401: astore 5
    //   403: aload_1
    //   404: invokevirtual 97	java/security/NoSuchAlgorithmException:printStackTrace	()V
    //   407: sipush 139
    //   410: istore_3
    //   411: aload 7
    //   413: ifnull +8 -> 421
    //   416: aload 7
    //   418: invokevirtual 85	java/io/InputStream:close	()V
    //   421: aload 6
    //   423: ifnull -326 -> 97
    //   426: aload 6
    //   428: invokevirtual 58	java/util/jar/JarFile:close	()V
    //   431: sipush 139
    //   434: ireturn
    //   435: astore_0
    //   436: sipush 139
    //   439: ireturn
    //   440: astore_1
    //   441: aconst_null
    //   442: astore 5
    //   444: aload 7
    //   446: astore_0
    //   447: aload_0
    //   448: ifnull +7 -> 455
    //   451: aload_0
    //   452: invokevirtual 85	java/io/InputStream:close	()V
    //   455: aload 5
    //   457: ifnull +8 -> 465
    //   460: aload 5
    //   462: invokevirtual 58	java/util/jar/JarFile:close	()V
    //   465: aload_1
    //   466: athrow
    //   467: astore_0
    //   468: goto -387 -> 81
    //   471: astore_0
    //   472: iconst_2
    //   473: ireturn
    //   474: astore_0
    //   475: goto -150 -> 325
    //   478: astore_0
    //   479: goto -225 -> 254
    //   482: astore_0
    //   483: goto -114 -> 369
    //   486: astore_0
    //   487: goto -66 -> 421
    //   490: astore_0
    //   491: goto -36 -> 455
    //   494: astore_0
    //   495: goto -30 -> 465
    //   498: astore_1
    //   499: goto -52 -> 447
    //   502: astore_1
    //   503: goto -107 -> 396
    //   506: astore_1
    //   507: goto -163 -> 344
    //   510: astore_1
    //   511: aconst_null
    //   512: astore 6
    //   514: goto -283 -> 231
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	517	0	paramString1	String
    //   0	517	1	paramString2	String
    //   0	517	2	paramArrayOfByte	byte[]
    //   25	386	3	i	int
    //   67	156	4	j	int
    //   7	454	5	localObject1	Object
    //   34	479	6	localJarFile	java.util.jar.JarFile
    //   10	435	7	localObject2	Object
    //   4	361	8	localObject3	Object
    //   1	292	9	localObject4	Object
    //   16	296	10	arrayOfByte	byte[]
    //   19	266	11	localMessageDigest	java.security.MessageDigest
    //   22	78	12	localObject5	Object
    //   13	91	13	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   55	62	230	java/io/IOException
    //   118	125	230	java/io/IOException
    //   140	151	230	java/io/IOException
    //   166	173	230	java/io/IOException
    //   188	196	230	java/io/IOException
    //   217	227	230	java/io/IOException
    //   284	291	230	java/io/IOException
    //   306	317	230	java/io/IOException
    //   259	264	266	java/io/IOException
    //   330	335	337	java/io/IOException
    //   26	36	340	java/lang/OutOfMemoryError
    //   374	379	383	java/io/IOException
    //   26	36	388	java/security/NoSuchAlgorithmException
    //   426	431	435	java/io/IOException
    //   26	36	440	finally
    //   73	81	467	java/io/IOException
    //   89	94	471	java/io/IOException
    //   321	325	474	java/io/IOException
    //   249	254	478	java/io/IOException
    //   364	369	482	java/io/IOException
    //   416	421	486	java/io/IOException
    //   451	455	490	java/io/IOException
    //   460	465	494	java/io/IOException
    //   55	62	498	finally
    //   118	125	498	finally
    //   140	151	498	finally
    //   166	173	498	finally
    //   188	196	498	finally
    //   217	227	498	finally
    //   238	242	498	finally
    //   284	291	498	finally
    //   306	317	498	finally
    //   351	355	498	finally
    //   403	407	498	finally
    //   55	62	502	java/security/NoSuchAlgorithmException
    //   118	125	502	java/security/NoSuchAlgorithmException
    //   140	151	502	java/security/NoSuchAlgorithmException
    //   166	173	502	java/security/NoSuchAlgorithmException
    //   188	196	502	java/security/NoSuchAlgorithmException
    //   217	227	502	java/security/NoSuchAlgorithmException
    //   284	291	502	java/security/NoSuchAlgorithmException
    //   306	317	502	java/security/NoSuchAlgorithmException
    //   55	62	506	java/lang/OutOfMemoryError
    //   118	125	506	java/lang/OutOfMemoryError
    //   140	151	506	java/lang/OutOfMemoryError
    //   166	173	506	java/lang/OutOfMemoryError
    //   188	196	506	java/lang/OutOfMemoryError
    //   217	227	506	java/lang/OutOfMemoryError
    //   284	291	506	java/lang/OutOfMemoryError
    //   306	317	506	java/lang/OutOfMemoryError
    //   26	36	510	java/io/IOException
  }
  
  public static int a(Map<String, Attributes> paramMap, String paramString1, String paramString2)
  {
    if (paramMap == null) {
      return 17;
    }
    paramMap = (Attributes)paramMap.get(paramString1);
    if (paramMap == null) {
      return 7;
    }
    if (true == paramString2.equals(paramMap.getValue(bevz.a(bevz.t)))) {
      return 0;
    }
    return 143;
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    char[] arrayOfChar1 = new char[16];
    char[] tmp6_5 = arrayOfChar1;
    tmp6_5[0] = 48;
    char[] tmp11_6 = tmp6_5;
    tmp11_6[1] = 49;
    char[] tmp16_11 = tmp11_6;
    tmp16_11[2] = 50;
    char[] tmp21_16 = tmp16_11;
    tmp21_16[3] = 51;
    char[] tmp26_21 = tmp21_16;
    tmp26_21[4] = 52;
    char[] tmp31_26 = tmp26_21;
    tmp31_26[5] = 53;
    char[] tmp36_31 = tmp31_26;
    tmp36_31[6] = 54;
    char[] tmp42_36 = tmp36_31;
    tmp42_36[7] = 55;
    char[] tmp48_42 = tmp42_36;
    tmp48_42[8] = 56;
    char[] tmp54_48 = tmp48_42;
    tmp54_48[9] = 57;
    char[] tmp60_54 = tmp54_48;
    tmp60_54[10] = 97;
    char[] tmp66_60 = tmp60_54;
    tmp66_60[11] = 98;
    char[] tmp72_66 = tmp66_60;
    tmp72_66[12] = 99;
    char[] tmp78_72 = tmp72_66;
    tmp78_72[13] = 100;
    char[] tmp84_78 = tmp78_72;
    tmp84_78[14] = 101;
    char[] tmp90_84 = tmp84_78;
    tmp90_84[15] = 102;
    tmp90_84;
    char[] arrayOfChar2 = new char[paramArrayOfByte.length * 2];
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      int j = paramArrayOfByte[i];
      arrayOfChar2[(i * 2)] = arrayOfChar1[(j >>> 4 & 0xF)];
      arrayOfChar2[(i * 2 + 1)] = arrayOfChar1[(j & 0xF)];
      i += 1;
    }
    return new String(arrayOfChar2);
  }
  
  /* Error */
  public static Map<String, Attributes> a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 43	java/util/jar/JarFile
    //   5: dup
    //   6: aload_0
    //   7: invokespecial 47	java/util/jar/JarFile:<init>	(Ljava/lang/String;)V
    //   10: astore_1
    //   11: aload_1
    //   12: astore_0
    //   13: aload_1
    //   14: invokevirtual 145	java/util/jar/JarFile:getManifest	()Ljava/util/jar/Manifest;
    //   17: astore_2
    //   18: aload_2
    //   19: ifnonnull +17 -> 36
    //   22: aload_3
    //   23: astore_0
    //   24: aload_1
    //   25: ifnull +9 -> 34
    //   28: aload_1
    //   29: invokevirtual 58	java/util/jar/JarFile:close	()V
    //   32: aload_3
    //   33: astore_0
    //   34: aload_0
    //   35: areturn
    //   36: aload_1
    //   37: astore_0
    //   38: aload_2
    //   39: invokevirtual 151	java/util/jar/Manifest:getEntries	()Ljava/util/Map;
    //   42: astore_2
    //   43: aload_2
    //   44: astore_0
    //   45: aload_1
    //   46: ifnull -12 -> 34
    //   49: aload_1
    //   50: invokevirtual 58	java/util/jar/JarFile:close	()V
    //   53: aload_2
    //   54: areturn
    //   55: astore_0
    //   56: aload_2
    //   57: areturn
    //   58: astore_2
    //   59: aconst_null
    //   60: astore_1
    //   61: aload_1
    //   62: astore_0
    //   63: aload_2
    //   64: invokevirtual 96	java/lang/OutOfMemoryError:printStackTrace	()V
    //   67: aload_3
    //   68: astore_0
    //   69: aload_1
    //   70: ifnull -36 -> 34
    //   73: aload_1
    //   74: invokevirtual 58	java/util/jar/JarFile:close	()V
    //   77: aconst_null
    //   78: areturn
    //   79: astore_0
    //   80: aconst_null
    //   81: areturn
    //   82: astore_2
    //   83: aconst_null
    //   84: astore_1
    //   85: aload_1
    //   86: astore_0
    //   87: aload_2
    //   88: invokevirtual 84	java/io/IOException:printStackTrace	()V
    //   91: aload_3
    //   92: astore_0
    //   93: aload_1
    //   94: ifnull -60 -> 34
    //   97: aload_1
    //   98: invokevirtual 58	java/util/jar/JarFile:close	()V
    //   101: aconst_null
    //   102: areturn
    //   103: astore_0
    //   104: aconst_null
    //   105: areturn
    //   106: astore_1
    //   107: aconst_null
    //   108: astore_0
    //   109: aload_0
    //   110: ifnull +7 -> 117
    //   113: aload_0
    //   114: invokevirtual 58	java/util/jar/JarFile:close	()V
    //   117: aload_1
    //   118: athrow
    //   119: astore_0
    //   120: aconst_null
    //   121: areturn
    //   122: astore_0
    //   123: goto -6 -> 117
    //   126: astore_1
    //   127: goto -18 -> 109
    //   130: astore_2
    //   131: goto -46 -> 85
    //   134: astore_2
    //   135: goto -74 -> 61
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	138	0	paramString	String
    //   10	88	1	localJarFile	java.util.jar.JarFile
    //   106	12	1	localObject1	Object
    //   126	1	1	localObject2	Object
    //   17	40	2	localObject3	Object
    //   58	6	2	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   82	6	2	localIOException1	java.io.IOException
    //   130	1	2	localIOException2	java.io.IOException
    //   134	1	2	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   1	91	3	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   49	53	55	java/io/IOException
    //   2	11	58	java/lang/OutOfMemoryError
    //   73	77	79	java/io/IOException
    //   2	11	82	java/io/IOException
    //   97	101	103	java/io/IOException
    //   2	11	106	finally
    //   28	32	119	java/io/IOException
    //   113	117	122	java/io/IOException
    //   13	18	126	finally
    //   38	43	126	finally
    //   63	67	126	finally
    //   87	91	126	finally
    //   13	18	130	java/io/IOException
    //   38	43	130	java/io/IOException
    //   13	18	134	java/lang/OutOfMemoryError
    //   38	43	134	java/lang/OutOfMemoryError
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bewa
 * JD-Core Version:    0.7.0.1
 */