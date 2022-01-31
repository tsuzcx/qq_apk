import android.util.Base64;
import java.io.DataInputStream;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;

public class bfkw
{
  public static bfky a(DataInputStream paramDataInputStream)
  {
    bfky localbfky = new bfky(null);
    try
    {
      localbfky.jdField_a_of_type_Int = paramDataInputStream.readInt();
      localbfky.b = paramDataInputStream.readInt();
      localbfky.c = paramDataInputStream.readInt();
      if ((localbfky.c > 0) && (localbfky.c <= 256))
      {
        localbfky.jdField_a_of_type_ArrayOfByte = new byte[localbfky.c];
        paramDataInputStream.read(localbfky.jdField_a_of_type_ArrayOfByte);
        return localbfky;
      }
    }
    catch (IOException paramDataInputStream)
    {
      paramDataInputStream.printStackTrace();
      return null;
    }
    return null;
  }
  
  private static PublicKey a(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDMz0GiKqUQnpnsCh5sqYlVDmKi1yjICNkkFbzAeTaWf/pENkUTT19LE8FWn48C63UOCHQuUf67qygCFUApW5+20WD5SacBfdzmufohcCAzfH7J5zeN0AqOMgo7+k7I+oIpZqnHMrb1vBlvHb+79ct7PP+DqSPbjr+dQUcO6rNkjwIDAQAB";
    }
    paramString = new X509EncodedKeySpec(Base64.decode(str, 0));
    try
    {
      paramString = KeyFactory.getInstance("RSA").generatePublic(paramString);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  private static boolean a(DataInputStream paramDataInputStream, int paramInt, byte[] paramArrayOfByte, PublicKey paramPublicKey)
  {
    for (;;)
    {
      int i;
      try
      {
        localSignature = Signature.getInstance("MD5withRSA");
        localSignature.initVerify(paramPublicKey);
        paramPublicKey = new byte[8192];
        if (paramInt < 8192)
        {
          i = paramDataInputStream.read(paramPublicKey, 0, paramInt);
          break label79;
          return localSignature.verify(paramArrayOfByte);
        }
        else
        {
          i = paramDataInputStream.read(paramPublicKey);
        }
      }
      catch (Exception paramDataInputStream)
      {
        Signature localSignature;
        paramDataInputStream.printStackTrace();
        return false;
      }
      localSignature.update(paramPublicKey, 0, i);
      paramInt -= i;
      continue;
      label79:
      if (i != 0) {
        if (i != -1) {}
      }
    }
  }
  
  /* Error */
  public static boolean a(java.io.File paramFile, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 8
    //   6: iconst_0
    //   7: istore 5
    //   9: aload_0
    //   10: invokevirtual 100	java/io/File:exists	()Z
    //   13: ifne +6 -> 19
    //   16: iload 5
    //   18: ireturn
    //   19: new 16	java/io/DataInputStream
    //   22: dup
    //   23: new 102	java/io/FileInputStream
    //   26: dup
    //   27: aload_0
    //   28: invokespecial 105	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   31: invokespecial 108	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   34: astore 6
    //   36: aload 6
    //   38: invokevirtual 111	java/io/DataInputStream:available	()I
    //   41: istore_2
    //   42: iload_2
    //   43: sipush 140
    //   46: if_icmpgt +40 -> 86
    //   49: aload 6
    //   51: ifnull +8 -> 59
    //   54: aload 6
    //   56: invokevirtual 114	java/io/DataInputStream:close	()V
    //   59: iconst_0
    //   60: ifeq -44 -> 16
    //   63: new 116	java/lang/NullPointerException
    //   66: dup
    //   67: invokespecial 118	java/lang/NullPointerException:<init>	()V
    //   70: athrow
    //   71: astore_0
    //   72: aload_0
    //   73: invokevirtual 40	java/io/IOException:printStackTrace	()V
    //   76: iconst_0
    //   77: ireturn
    //   78: astore_0
    //   79: aload_0
    //   80: invokevirtual 40	java/io/IOException:printStackTrace	()V
    //   83: goto -24 -> 59
    //   86: iload_2
    //   87: sipush 140
    //   90: isub
    //   91: istore_2
    //   92: aload 6
    //   94: iload_2
    //   95: invokevirtual 122	java/io/DataInputStream:skipBytes	(I)I
    //   98: pop
    //   99: aload 6
    //   101: invokestatic 124	bfkw:a	(Ljava/io/DataInputStream;)Lbfky;
    //   104: astore 8
    //   106: aload 8
    //   108: ifnonnull +40 -> 148
    //   111: aload 6
    //   113: ifnull +8 -> 121
    //   116: aload 6
    //   118: invokevirtual 114	java/io/DataInputStream:close	()V
    //   121: iconst_0
    //   122: ifeq -106 -> 16
    //   125: new 116	java/lang/NullPointerException
    //   128: dup
    //   129: invokespecial 118	java/lang/NullPointerException:<init>	()V
    //   132: athrow
    //   133: astore_0
    //   134: aload_0
    //   135: invokevirtual 40	java/io/IOException:printStackTrace	()V
    //   138: iconst_0
    //   139: ireturn
    //   140: astore_0
    //   141: aload_0
    //   142: invokevirtual 40	java/io/IOException:printStackTrace	()V
    //   145: goto -24 -> 121
    //   148: aload 8
    //   150: getfield 23	bfky:jdField_a_of_type_Int	I
    //   153: istore_3
    //   154: iload_3
    //   155: ldc 125
    //   157: if_icmpeq +40 -> 197
    //   160: aload 6
    //   162: ifnull +8 -> 170
    //   165: aload 6
    //   167: invokevirtual 114	java/io/DataInputStream:close	()V
    //   170: iconst_0
    //   171: ifeq -155 -> 16
    //   174: new 116	java/lang/NullPointerException
    //   177: dup
    //   178: invokespecial 118	java/lang/NullPointerException:<init>	()V
    //   181: athrow
    //   182: astore_0
    //   183: aload_0
    //   184: invokevirtual 40	java/io/IOException:printStackTrace	()V
    //   187: iconst_0
    //   188: ireturn
    //   189: astore_0
    //   190: aload_0
    //   191: invokevirtual 40	java/io/IOException:printStackTrace	()V
    //   194: goto -24 -> 170
    //   197: aload 8
    //   199: getfield 26	bfky:b	I
    //   202: ifle +15 -> 217
    //   205: aload 8
    //   207: getfield 26	bfky:b	I
    //   210: istore_3
    //   211: iload_3
    //   212: ldc 126
    //   214: if_icmple +40 -> 254
    //   217: aload 6
    //   219: ifnull +8 -> 227
    //   222: aload 6
    //   224: invokevirtual 114	java/io/DataInputStream:close	()V
    //   227: iconst_0
    //   228: ifeq -212 -> 16
    //   231: new 116	java/lang/NullPointerException
    //   234: dup
    //   235: invokespecial 118	java/lang/NullPointerException:<init>	()V
    //   238: athrow
    //   239: astore_0
    //   240: aload_0
    //   241: invokevirtual 40	java/io/IOException:printStackTrace	()V
    //   244: iconst_0
    //   245: ireturn
    //   246: astore_0
    //   247: aload_0
    //   248: invokevirtual 40	java/io/IOException:printStackTrace	()V
    //   251: goto -24 -> 227
    //   254: aload 8
    //   256: getfield 26	bfky:b	I
    //   259: istore_3
    //   260: iload_2
    //   261: iload_3
    //   262: if_icmpeq +40 -> 302
    //   265: aload 6
    //   267: ifnull +8 -> 275
    //   270: aload 6
    //   272: invokevirtual 114	java/io/DataInputStream:close	()V
    //   275: iconst_0
    //   276: ifeq -260 -> 16
    //   279: new 116	java/lang/NullPointerException
    //   282: dup
    //   283: invokespecial 118	java/lang/NullPointerException:<init>	()V
    //   286: athrow
    //   287: astore_0
    //   288: aload_0
    //   289: invokevirtual 40	java/io/IOException:printStackTrace	()V
    //   292: iconst_0
    //   293: ireturn
    //   294: astore_0
    //   295: aload_0
    //   296: invokevirtual 40	java/io/IOException:printStackTrace	()V
    //   299: goto -24 -> 275
    //   302: aload_1
    //   303: invokestatic 128	bfkw:a	(Ljava/lang/String;)Ljava/security/PublicKey;
    //   306: astore_1
    //   307: aload_1
    //   308: ifnonnull +40 -> 348
    //   311: aload 6
    //   313: ifnull +8 -> 321
    //   316: aload 6
    //   318: invokevirtual 114	java/io/DataInputStream:close	()V
    //   321: iconst_0
    //   322: ifeq -306 -> 16
    //   325: new 116	java/lang/NullPointerException
    //   328: dup
    //   329: invokespecial 118	java/lang/NullPointerException:<init>	()V
    //   332: athrow
    //   333: astore_0
    //   334: aload_0
    //   335: invokevirtual 40	java/io/IOException:printStackTrace	()V
    //   338: iconst_0
    //   339: ireturn
    //   340: astore_0
    //   341: aload_0
    //   342: invokevirtual 40	java/io/IOException:printStackTrace	()V
    //   345: goto -24 -> 321
    //   348: new 16	java/io/DataInputStream
    //   351: dup
    //   352: new 102	java/io/FileInputStream
    //   355: dup
    //   356: aload_0
    //   357: invokespecial 105	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   360: invokespecial 108	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   363: astore_0
    //   364: aload_0
    //   365: aload 8
    //   367: getfield 26	bfky:b	I
    //   370: aload 8
    //   372: getfield 32	bfky:jdField_a_of_type_ArrayOfByte	[B
    //   375: aload_1
    //   376: invokestatic 130	bfkw:a	(Ljava/io/DataInputStream;I[BLjava/security/PublicKey;)Z
    //   379: istore 4
    //   381: aload 6
    //   383: ifnull +8 -> 391
    //   386: aload 6
    //   388: invokevirtual 114	java/io/DataInputStream:close	()V
    //   391: iload 4
    //   393: istore 5
    //   395: aload_0
    //   396: ifnull -380 -> 16
    //   399: aload_0
    //   400: invokevirtual 114	java/io/DataInputStream:close	()V
    //   403: iload 4
    //   405: ireturn
    //   406: astore_0
    //   407: aload_0
    //   408: invokevirtual 40	java/io/IOException:printStackTrace	()V
    //   411: iload 4
    //   413: ireturn
    //   414: astore_1
    //   415: aload_1
    //   416: invokevirtual 40	java/io/IOException:printStackTrace	()V
    //   419: goto -28 -> 391
    //   422: astore 6
    //   424: aconst_null
    //   425: astore_0
    //   426: aload 8
    //   428: astore_1
    //   429: aload 6
    //   431: invokevirtual 40	java/io/IOException:printStackTrace	()V
    //   434: aload_1
    //   435: ifnull +7 -> 442
    //   438: aload_1
    //   439: invokevirtual 114	java/io/DataInputStream:close	()V
    //   442: aload_0
    //   443: ifnull -427 -> 16
    //   446: aload_0
    //   447: invokevirtual 114	java/io/DataInputStream:close	()V
    //   450: iconst_0
    //   451: ireturn
    //   452: astore_0
    //   453: aload_0
    //   454: invokevirtual 40	java/io/IOException:printStackTrace	()V
    //   457: iconst_0
    //   458: ireturn
    //   459: astore_1
    //   460: aload_1
    //   461: invokevirtual 40	java/io/IOException:printStackTrace	()V
    //   464: goto -22 -> 442
    //   467: astore_0
    //   468: aconst_null
    //   469: astore 6
    //   471: aload 7
    //   473: astore_1
    //   474: aload 6
    //   476: ifnull +8 -> 484
    //   479: aload 6
    //   481: invokevirtual 114	java/io/DataInputStream:close	()V
    //   484: aload_1
    //   485: ifnull +7 -> 492
    //   488: aload_1
    //   489: invokevirtual 114	java/io/DataInputStream:close	()V
    //   492: aload_0
    //   493: athrow
    //   494: astore 6
    //   496: aload 6
    //   498: invokevirtual 40	java/io/IOException:printStackTrace	()V
    //   501: goto -17 -> 484
    //   504: astore_1
    //   505: aload_1
    //   506: invokevirtual 40	java/io/IOException:printStackTrace	()V
    //   509: goto -17 -> 492
    //   512: astore_0
    //   513: aload 7
    //   515: astore_1
    //   516: goto -42 -> 474
    //   519: astore 7
    //   521: aload_0
    //   522: astore_1
    //   523: aload 7
    //   525: astore_0
    //   526: goto -52 -> 474
    //   529: astore 7
    //   531: aload_1
    //   532: astore 6
    //   534: aload_0
    //   535: astore_1
    //   536: aload 7
    //   538: astore_0
    //   539: goto -65 -> 474
    //   542: astore 7
    //   544: aconst_null
    //   545: astore_0
    //   546: aload 6
    //   548: astore_1
    //   549: aload 7
    //   551: astore 6
    //   553: goto -124 -> 429
    //   556: astore 7
    //   558: aload 6
    //   560: astore_1
    //   561: aload 7
    //   563: astore 6
    //   565: goto -136 -> 429
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	568	0	paramFile	java.io.File
    //   0	568	1	paramString	String
    //   41	222	2	i	int
    //   153	110	3	j	int
    //   379	33	4	bool1	boolean
    //   7	387	5	bool2	boolean
    //   34	353	6	localDataInputStream	DataInputStream
    //   422	8	6	localIOException1	IOException
    //   469	11	6	localObject1	Object
    //   494	3	6	localIOException2	IOException
    //   532	32	6	localObject2	Object
    //   1	513	7	localObject3	Object
    //   519	5	7	localObject4	Object
    //   529	8	7	localObject5	Object
    //   542	8	7	localIOException3	IOException
    //   556	6	7	localIOException4	IOException
    //   4	423	8	localbfky	bfky
    // Exception table:
    //   from	to	target	type
    //   63	71	71	java/io/IOException
    //   54	59	78	java/io/IOException
    //   125	133	133	java/io/IOException
    //   116	121	140	java/io/IOException
    //   174	182	182	java/io/IOException
    //   165	170	189	java/io/IOException
    //   231	239	239	java/io/IOException
    //   222	227	246	java/io/IOException
    //   279	287	287	java/io/IOException
    //   270	275	294	java/io/IOException
    //   325	333	333	java/io/IOException
    //   316	321	340	java/io/IOException
    //   399	403	406	java/io/IOException
    //   386	391	414	java/io/IOException
    //   19	36	422	java/io/IOException
    //   446	450	452	java/io/IOException
    //   438	442	459	java/io/IOException
    //   19	36	467	finally
    //   479	484	494	java/io/IOException
    //   488	492	504	java/io/IOException
    //   36	42	512	finally
    //   92	106	512	finally
    //   148	154	512	finally
    //   197	211	512	finally
    //   254	260	512	finally
    //   302	307	512	finally
    //   348	364	512	finally
    //   364	381	519	finally
    //   429	434	529	finally
    //   36	42	542	java/io/IOException
    //   92	106	542	java/io/IOException
    //   148	154	542	java/io/IOException
    //   197	211	542	java/io/IOException
    //   254	260	542	java/io/IOException
    //   302	307	542	java/io/IOException
    //   348	364	542	java/io/IOException
    //   364	381	556	java/io/IOException
  }
  
  private static boolean a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, PublicKey paramPublicKey)
  {
    try
    {
      Signature localSignature = Signature.getInstance("MD5withRSA");
      localSignature.initVerify(paramPublicKey);
      localSignature.update(paramArrayOfByte1);
      boolean bool = localSignature.verify(paramArrayOfByte2);
      return bool;
    }
    catch (Exception paramArrayOfByte1)
    {
      paramArrayOfByte1.printStackTrace();
    }
    return false;
  }
  
  /* Error */
  public static byte[] a(java.io.File paramFile, String paramString)
  {
    // Byte code:
    //   0: new 16	java/io/DataInputStream
    //   3: dup
    //   4: new 102	java/io/FileInputStream
    //   7: dup
    //   8: aload_0
    //   9: invokespecial 105	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   12: invokespecial 108	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   15: astore 5
    //   17: aload 5
    //   19: astore_0
    //   20: aload 5
    //   22: invokevirtual 111	java/io/DataInputStream:available	()I
    //   25: istore_2
    //   26: iload_2
    //   27: bipush 8
    //   29: if_icmplt +9 -> 38
    //   32: iload_2
    //   33: ldc 126
    //   35: if_icmple +22 -> 57
    //   38: aload 5
    //   40: ifnull +8 -> 48
    //   43: aload 5
    //   45: invokevirtual 114	java/io/DataInputStream:close	()V
    //   48: aconst_null
    //   49: areturn
    //   50: astore_0
    //   51: aload_0
    //   52: invokevirtual 40	java/io/IOException:printStackTrace	()V
    //   55: aconst_null
    //   56: areturn
    //   57: aload 5
    //   59: astore_0
    //   60: aload 5
    //   62: invokevirtual 20	java/io/DataInputStream:readInt	()I
    //   65: istore_3
    //   66: iload_3
    //   67: ldc 125
    //   69: if_icmpeq +22 -> 91
    //   72: aload 5
    //   74: ifnull -26 -> 48
    //   77: aload 5
    //   79: invokevirtual 114	java/io/DataInputStream:close	()V
    //   82: aconst_null
    //   83: areturn
    //   84: astore_0
    //   85: aload_0
    //   86: invokevirtual 40	java/io/IOException:printStackTrace	()V
    //   89: aconst_null
    //   90: areturn
    //   91: aload 5
    //   93: astore_0
    //   94: aload 5
    //   96: invokevirtual 20	java/io/DataInputStream:readInt	()I
    //   99: istore_3
    //   100: iload_3
    //   101: ifle +18 -> 119
    //   104: iload_3
    //   105: sipush 256
    //   108: if_icmpgt +11 -> 119
    //   111: iload_3
    //   112: iload_2
    //   113: bipush 8
    //   115: isub
    //   116: if_icmplt +22 -> 138
    //   119: aload 5
    //   121: ifnull -73 -> 48
    //   124: aload 5
    //   126: invokevirtual 114	java/io/DataInputStream:close	()V
    //   129: aconst_null
    //   130: areturn
    //   131: astore_0
    //   132: aload_0
    //   133: invokevirtual 40	java/io/IOException:printStackTrace	()V
    //   136: aconst_null
    //   137: areturn
    //   138: aload 5
    //   140: astore_0
    //   141: aload_1
    //   142: invokestatic 128	bfkw:a	(Ljava/lang/String;)Ljava/security/PublicKey;
    //   145: astore 6
    //   147: aload 6
    //   149: ifnonnull +22 -> 171
    //   152: aload 5
    //   154: ifnull -106 -> 48
    //   157: aload 5
    //   159: invokevirtual 114	java/io/DataInputStream:close	()V
    //   162: aconst_null
    //   163: areturn
    //   164: astore_0
    //   165: aload_0
    //   166: invokevirtual 40	java/io/IOException:printStackTrace	()V
    //   169: aconst_null
    //   170: areturn
    //   171: aload 5
    //   173: astore_0
    //   174: iload_3
    //   175: newarray byte
    //   177: astore 7
    //   179: aload 5
    //   181: astore_0
    //   182: iload_2
    //   183: bipush 8
    //   185: isub
    //   186: iload_3
    //   187: isub
    //   188: newarray byte
    //   190: astore_1
    //   191: aload 5
    //   193: astore_0
    //   194: aload 5
    //   196: aload 7
    //   198: invokevirtual 36	java/io/DataInputStream:read	([B)I
    //   201: pop
    //   202: aload 5
    //   204: astore_0
    //   205: aload 5
    //   207: aload_1
    //   208: invokevirtual 36	java/io/DataInputStream:read	([B)I
    //   211: pop
    //   212: aload 5
    //   214: astore_0
    //   215: aload_1
    //   216: aload 7
    //   218: aload 6
    //   220: invokestatic 136	bfkw:a	([B[BLjava/security/PublicKey;)Z
    //   223: istore 4
    //   225: iload 4
    //   227: ifeq +23 -> 250
    //   230: aload 5
    //   232: ifnull +8 -> 240
    //   235: aload 5
    //   237: invokevirtual 114	java/io/DataInputStream:close	()V
    //   240: aload_1
    //   241: areturn
    //   242: astore_0
    //   243: aload_0
    //   244: invokevirtual 40	java/io/IOException:printStackTrace	()V
    //   247: goto -7 -> 240
    //   250: aload 5
    //   252: ifnull -204 -> 48
    //   255: aload 5
    //   257: invokevirtual 114	java/io/DataInputStream:close	()V
    //   260: aconst_null
    //   261: areturn
    //   262: astore_0
    //   263: aload_0
    //   264: invokevirtual 40	java/io/IOException:printStackTrace	()V
    //   267: aconst_null
    //   268: areturn
    //   269: astore 6
    //   271: aconst_null
    //   272: astore_1
    //   273: aload_1
    //   274: astore_0
    //   275: aload 6
    //   277: invokevirtual 40	java/io/IOException:printStackTrace	()V
    //   280: aload_1
    //   281: ifnull -233 -> 48
    //   284: aload_1
    //   285: invokevirtual 114	java/io/DataInputStream:close	()V
    //   288: aconst_null
    //   289: areturn
    //   290: astore_0
    //   291: aload_0
    //   292: invokevirtual 40	java/io/IOException:printStackTrace	()V
    //   295: aconst_null
    //   296: areturn
    //   297: astore_1
    //   298: aconst_null
    //   299: astore_0
    //   300: aload_0
    //   301: ifnull +7 -> 308
    //   304: aload_0
    //   305: invokevirtual 114	java/io/DataInputStream:close	()V
    //   308: aload_1
    //   309: athrow
    //   310: astore_0
    //   311: aload_0
    //   312: invokevirtual 40	java/io/IOException:printStackTrace	()V
    //   315: goto -7 -> 308
    //   318: astore_1
    //   319: goto -19 -> 300
    //   322: astore 6
    //   324: aload 5
    //   326: astore_1
    //   327: goto -54 -> 273
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	330	0	paramFile	java.io.File
    //   0	330	1	paramString	String
    //   25	161	2	i	int
    //   65	123	3	j	int
    //   223	3	4	bool	boolean
    //   15	310	5	localDataInputStream	DataInputStream
    //   145	74	6	localPublicKey	PublicKey
    //   269	7	6	localIOException1	IOException
    //   322	1	6	localIOException2	IOException
    //   177	40	7	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   43	48	50	java/io/IOException
    //   77	82	84	java/io/IOException
    //   124	129	131	java/io/IOException
    //   157	162	164	java/io/IOException
    //   235	240	242	java/io/IOException
    //   255	260	262	java/io/IOException
    //   0	17	269	java/io/IOException
    //   284	288	290	java/io/IOException
    //   0	17	297	finally
    //   304	308	310	java/io/IOException
    //   20	26	318	finally
    //   60	66	318	finally
    //   94	100	318	finally
    //   141	147	318	finally
    //   174	179	318	finally
    //   182	191	318	finally
    //   194	202	318	finally
    //   205	212	318	finally
    //   215	225	318	finally
    //   275	280	318	finally
    //   20	26	322	java/io/IOException
    //   60	66	322	java/io/IOException
    //   94	100	322	java/io/IOException
    //   141	147	322	java/io/IOException
    //   174	179	322	java/io/IOException
    //   182	191	322	java/io/IOException
    //   194	202	322	java/io/IOException
    //   205	212	322	java/io/IOException
    //   215	225	322	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bfkw
 * JD-Core Version:    0.7.0.1
 */