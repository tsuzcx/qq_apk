import com.qq.taf.jce.HexUtil;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

public class aygu
{
  /* Error */
  public static java.lang.Boolean a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aconst_null
    //   3: astore 5
    //   5: aconst_null
    //   6: astore 4
    //   8: aload_1
    //   9: invokestatic 13	arso:a	(Ljava/lang/String;)Z
    //   12: ifeq +8 -> 20
    //   15: aload_1
    //   16: invokestatic 16	arso:c	(Ljava/lang/String;)Z
    //   19: pop
    //   20: new 18	java/io/File
    //   23: dup
    //   24: aload_0
    //   25: invokespecial 22	java/io/File:<init>	(Ljava/lang/String;)V
    //   28: invokevirtual 26	java/io/File:exists	()Z
    //   31: ifeq +148 -> 179
    //   34: new 28	java/io/FileInputStream
    //   37: dup
    //   38: aload_0
    //   39: invokespecial 29	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   42: astore_0
    //   43: new 31	java/io/FileOutputStream
    //   46: dup
    //   47: aload_1
    //   48: invokespecial 32	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   51: astore_1
    //   52: sipush 1444
    //   55: newarray byte
    //   57: astore 4
    //   59: aload_0
    //   60: aload 4
    //   62: invokevirtual 38	java/io/InputStream:read	([B)I
    //   65: istore_3
    //   66: iload_3
    //   67: iconst_m1
    //   68: if_icmpeq +70 -> 138
    //   71: iload_2
    //   72: iload_3
    //   73: iadd
    //   74: istore_2
    //   75: getstatic 44	java/lang/System:out	Ljava/io/PrintStream;
    //   78: iload_2
    //   79: invokevirtual 50	java/io/PrintStream:println	(I)V
    //   82: aload_1
    //   83: aload 4
    //   85: iconst_0
    //   86: iload_3
    //   87: invokevirtual 54	java/io/FileOutputStream:write	([BII)V
    //   90: goto -31 -> 59
    //   93: astore 5
    //   95: aload_0
    //   96: astore 4
    //   98: aload 5
    //   100: astore_0
    //   101: ldc 56
    //   103: iconst_1
    //   104: ldc 58
    //   106: invokestatic 64	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   109: aload_0
    //   110: invokevirtual 68	java/lang/Exception:printStackTrace	()V
    //   113: iconst_0
    //   114: invokestatic 74	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   117: astore_0
    //   118: aload 4
    //   120: ifnull +8 -> 128
    //   123: aload 4
    //   125: invokevirtual 77	java/io/InputStream:close	()V
    //   128: aload_1
    //   129: ifnull +7 -> 136
    //   132: aload_1
    //   133: invokevirtual 78	java/io/FileOutputStream:close	()V
    //   136: aload_0
    //   137: areturn
    //   138: aload_0
    //   139: invokevirtual 77	java/io/InputStream:close	()V
    //   142: aload_1
    //   143: invokevirtual 81	java/io/FileOutputStream:flush	()V
    //   146: aload_1
    //   147: invokevirtual 78	java/io/FileOutputStream:close	()V
    //   150: iconst_0
    //   151: ifeq +11 -> 162
    //   154: new 83	java/lang/NullPointerException
    //   157: dup
    //   158: invokespecial 85	java/lang/NullPointerException:<init>	()V
    //   161: athrow
    //   162: iconst_0
    //   163: ifeq +11 -> 174
    //   166: new 83	java/lang/NullPointerException
    //   169: dup
    //   170: invokespecial 85	java/lang/NullPointerException:<init>	()V
    //   173: athrow
    //   174: iconst_1
    //   175: invokestatic 74	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   178: areturn
    //   179: ldc 56
    //   181: iconst_1
    //   182: ldc 87
    //   184: invokestatic 64	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   187: goto -37 -> 150
    //   190: astore_0
    //   191: aconst_null
    //   192: astore_1
    //   193: aload 5
    //   195: astore 4
    //   197: aload 4
    //   199: ifnull +8 -> 207
    //   202: aload 4
    //   204: invokevirtual 77	java/io/InputStream:close	()V
    //   207: aload_1
    //   208: ifnull +7 -> 215
    //   211: aload_1
    //   212: invokevirtual 78	java/io/FileOutputStream:close	()V
    //   215: aload_0
    //   216: athrow
    //   217: astore_1
    //   218: goto -3 -> 215
    //   221: astore 5
    //   223: aconst_null
    //   224: astore_1
    //   225: aload_0
    //   226: astore 4
    //   228: aload 5
    //   230: astore_0
    //   231: goto -34 -> 197
    //   234: astore 5
    //   236: aload_0
    //   237: astore 4
    //   239: aload 5
    //   241: astore_0
    //   242: goto -45 -> 197
    //   245: astore_0
    //   246: goto -49 -> 197
    //   249: astore_1
    //   250: aload_0
    //   251: areturn
    //   252: astore_0
    //   253: aconst_null
    //   254: astore_1
    //   255: goto -154 -> 101
    //   258: astore 5
    //   260: aconst_null
    //   261: astore_1
    //   262: aload_0
    //   263: astore 4
    //   265: aload 5
    //   267: astore_0
    //   268: goto -167 -> 101
    //   271: astore_0
    //   272: goto -98 -> 174
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	275	0	paramString1	String
    //   0	275	1	paramString2	String
    //   1	78	2	i	int
    //   65	22	3	j	int
    //   6	258	4	localObject1	Object
    //   3	1	5	localObject2	Object
    //   93	101	5	localException1	java.lang.Exception
    //   221	8	5	localObject3	Object
    //   234	6	5	localObject4	Object
    //   258	8	5	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   52	59	93	java/lang/Exception
    //   59	66	93	java/lang/Exception
    //   75	90	93	java/lang/Exception
    //   138	150	93	java/lang/Exception
    //   20	43	190	finally
    //   179	187	190	finally
    //   202	207	217	java/lang/Exception
    //   211	215	217	java/lang/Exception
    //   43	52	221	finally
    //   52	59	234	finally
    //   59	66	234	finally
    //   75	90	234	finally
    //   138	150	234	finally
    //   101	118	245	finally
    //   123	128	249	java/lang/Exception
    //   132	136	249	java/lang/Exception
    //   20	43	252	java/lang/Exception
    //   179	187	252	java/lang/Exception
    //   43	52	258	java/lang/Exception
    //   154	162	271	java/lang/Exception
    //   166	174	271	java/lang/Exception
  }
  
  public static String a(String paramString)
  {
    try
    {
      String str1 = HexUtil.bytes2HexStr(MD5.getFileMd5(paramString));
      paramString = str1;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        paramString = new File(paramString);
        if (!paramString.exists()) {
          break;
        }
        try
        {
          String str2 = bhpp.a(paramString);
          paramString = str2;
          if (str2 == null) {
            paramString = "";
          }
        }
        catch (IOException paramString)
        {
          paramString = "";
        }
      }
    }
    catch (OutOfMemoryError paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        paramString = "";
      }
    }
    QLog.i("ScribbleUtils", 1, "calcMD5 md5:" + paramString);
    return paramString;
  }
  
  /* Error */
  public static boolean a(String paramString1, int paramInt, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 8
    //   6: iconst_1
    //   7: istore 5
    //   9: new 18	java/io/File
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 22	java/io/File:<init>	(Ljava/lang/String;)V
    //   17: astore_0
    //   18: aload_0
    //   19: invokevirtual 26	java/io/File:exists	()Z
    //   22: ifeq +418 -> 440
    //   25: new 28	java/io/FileInputStream
    //   28: dup
    //   29: aload_0
    //   30: invokespecial 135	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   33: astore 6
    //   35: sipush 1024
    //   38: newarray byte
    //   40: astore_0
    //   41: iconst_0
    //   42: istore_3
    //   43: iload_3
    //   44: sipush 1024
    //   47: iadd
    //   48: iload_1
    //   49: if_icmpge +19 -> 68
    //   52: aload 6
    //   54: aload_0
    //   55: invokevirtual 136	java/io/FileInputStream:read	([B)I
    //   58: pop
    //   59: iload_3
    //   60: sipush 1024
    //   63: iadd
    //   64: istore_3
    //   65: goto -22 -> 43
    //   68: iload_1
    //   69: iload_3
    //   70: isub
    //   71: istore_1
    //   72: iload_1
    //   73: ifgt +64 -> 137
    //   76: aload 6
    //   78: ifnull +8 -> 86
    //   81: aload 6
    //   83: invokevirtual 137	java/io/FileInputStream:close	()V
    //   86: iconst_0
    //   87: ifeq +11 -> 98
    //   90: new 83	java/lang/NullPointerException
    //   93: dup
    //   94: invokespecial 85	java/lang/NullPointerException:<init>	()V
    //   97: athrow
    //   98: iconst_0
    //   99: ireturn
    //   100: astore_0
    //   101: aload_0
    //   102: invokevirtual 138	java/io/IOException:printStackTrace	()V
    //   105: ldc 56
    //   107: iconst_1
    //   108: aload_0
    //   109: iconst_0
    //   110: anewarray 4	java/lang/Object
    //   113: invokestatic 141	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   116: goto -30 -> 86
    //   119: astore_0
    //   120: aload_0
    //   121: invokevirtual 138	java/io/IOException:printStackTrace	()V
    //   124: ldc 56
    //   126: iconst_1
    //   127: aload_0
    //   128: iconst_0
    //   129: anewarray 4	java/lang/Object
    //   132: invokestatic 141	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   135: iconst_0
    //   136: ireturn
    //   137: aload 6
    //   139: iload_1
    //   140: newarray byte
    //   142: invokevirtual 136	java/io/FileInputStream:read	([B)I
    //   145: pop
    //   146: new 18	java/io/File
    //   149: dup
    //   150: aload_2
    //   151: invokespecial 22	java/io/File:<init>	(Ljava/lang/String;)V
    //   154: astore_0
    //   155: aload_0
    //   156: invokevirtual 145	java/io/File:getParentFile	()Ljava/io/File;
    //   159: invokevirtual 26	java/io/File:exists	()Z
    //   162: ifne +11 -> 173
    //   165: aload_0
    //   166: invokevirtual 145	java/io/File:getParentFile	()Ljava/io/File;
    //   169: invokevirtual 148	java/io/File:mkdirs	()Z
    //   172: pop
    //   173: new 31	java/io/FileOutputStream
    //   176: dup
    //   177: aload_0
    //   178: invokespecial 149	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   181: astore_0
    //   182: sipush 4096
    //   185: newarray byte
    //   187: astore_2
    //   188: aload 6
    //   190: aload_2
    //   191: invokevirtual 136	java/io/FileInputStream:read	([B)I
    //   194: istore_1
    //   195: iload_1
    //   196: iconst_m1
    //   197: if_icmpeq +59 -> 256
    //   200: aload_0
    //   201: aload_2
    //   202: iconst_0
    //   203: iload_1
    //   204: invokevirtual 54	java/io/FileOutputStream:write	([BII)V
    //   207: goto -19 -> 188
    //   210: astore 7
    //   212: aload_0
    //   213: astore_2
    //   214: aload 6
    //   216: astore_0
    //   217: aload 7
    //   219: astore 6
    //   221: ldc 56
    //   223: iconst_1
    //   224: ldc 151
    //   226: invokestatic 64	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   229: aload 6
    //   231: invokevirtual 68	java/lang/Exception:printStackTrace	()V
    //   234: aload_0
    //   235: ifnull +7 -> 242
    //   238: aload_0
    //   239: invokevirtual 137	java/io/FileInputStream:close	()V
    //   242: aload_2
    //   243: ifnull +205 -> 448
    //   246: aload_2
    //   247: invokevirtual 78	java/io/FileOutputStream:close	()V
    //   250: iconst_0
    //   251: istore 4
    //   253: iload 4
    //   255: ireturn
    //   256: aload_0
    //   257: invokevirtual 81	java/io/FileOutputStream:flush	()V
    //   260: aload 6
    //   262: ifnull +8 -> 270
    //   265: aload 6
    //   267: invokevirtual 137	java/io/FileInputStream:close	()V
    //   270: iload 5
    //   272: istore 4
    //   274: aload_0
    //   275: ifnull -22 -> 253
    //   278: aload_0
    //   279: invokevirtual 78	java/io/FileOutputStream:close	()V
    //   282: iload 5
    //   284: istore 4
    //   286: goto -33 -> 253
    //   289: astore_0
    //   290: aload_0
    //   291: invokevirtual 138	java/io/IOException:printStackTrace	()V
    //   294: ldc 56
    //   296: iconst_1
    //   297: aload_0
    //   298: iconst_0
    //   299: anewarray 4	java/lang/Object
    //   302: invokestatic 141	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   305: iload 5
    //   307: istore 4
    //   309: goto -56 -> 253
    //   312: astore_2
    //   313: aload_2
    //   314: invokevirtual 138	java/io/IOException:printStackTrace	()V
    //   317: ldc 56
    //   319: iconst_1
    //   320: aload_2
    //   321: iconst_0
    //   322: anewarray 4	java/lang/Object
    //   325: invokestatic 141	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   328: goto -58 -> 270
    //   331: astore_0
    //   332: aload_0
    //   333: invokevirtual 138	java/io/IOException:printStackTrace	()V
    //   336: ldc 56
    //   338: iconst_1
    //   339: aload_0
    //   340: iconst_0
    //   341: anewarray 4	java/lang/Object
    //   344: invokestatic 141	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   347: goto -105 -> 242
    //   350: astore_0
    //   351: aload_0
    //   352: invokevirtual 138	java/io/IOException:printStackTrace	()V
    //   355: ldc 56
    //   357: iconst_1
    //   358: aload_0
    //   359: iconst_0
    //   360: anewarray 4	java/lang/Object
    //   363: invokestatic 141	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   366: iconst_0
    //   367: istore 4
    //   369: goto -116 -> 253
    //   372: astore_0
    //   373: aconst_null
    //   374: astore 6
    //   376: aload 7
    //   378: astore_2
    //   379: aload 6
    //   381: ifnull +8 -> 389
    //   384: aload 6
    //   386: invokevirtual 137	java/io/FileInputStream:close	()V
    //   389: aload_2
    //   390: ifnull +7 -> 397
    //   393: aload_2
    //   394: invokevirtual 78	java/io/FileOutputStream:close	()V
    //   397: aload_0
    //   398: athrow
    //   399: astore 6
    //   401: aload 6
    //   403: invokevirtual 138	java/io/IOException:printStackTrace	()V
    //   406: ldc 56
    //   408: iconst_1
    //   409: aload 6
    //   411: iconst_0
    //   412: anewarray 4	java/lang/Object
    //   415: invokestatic 141	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   418: goto -29 -> 389
    //   421: astore_2
    //   422: aload_2
    //   423: invokevirtual 138	java/io/IOException:printStackTrace	()V
    //   426: ldc 56
    //   428: iconst_1
    //   429: aload_2
    //   430: iconst_0
    //   431: anewarray 4	java/lang/Object
    //   434: invokestatic 141	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   437: goto -40 -> 397
    //   440: ldc 56
    //   442: iconst_1
    //   443: ldc 153
    //   445: invokestatic 64	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   448: iconst_0
    //   449: istore 4
    //   451: goto -198 -> 253
    //   454: astore_0
    //   455: aload 7
    //   457: astore_2
    //   458: goto -79 -> 379
    //   461: astore 7
    //   463: aload_0
    //   464: astore_2
    //   465: aload 7
    //   467: astore_0
    //   468: goto -89 -> 379
    //   471: astore 7
    //   473: aload_0
    //   474: astore 6
    //   476: aload 7
    //   478: astore_0
    //   479: goto -100 -> 379
    //   482: astore 6
    //   484: aconst_null
    //   485: astore_0
    //   486: aload 8
    //   488: astore_2
    //   489: goto -268 -> 221
    //   492: astore_2
    //   493: aload 6
    //   495: astore_0
    //   496: aload_2
    //   497: astore 6
    //   499: aload 8
    //   501: astore_2
    //   502: goto -281 -> 221
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	505	0	paramString1	String
    //   0	505	1	paramInt	int
    //   0	505	2	paramString2	String
    //   42	29	3	i	int
    //   251	199	4	bool1	boolean
    //   7	299	5	bool2	boolean
    //   33	352	6	localObject1	Object
    //   399	11	6	localIOException	IOException
    //   474	1	6	str1	String
    //   482	12	6	localException1	java.lang.Exception
    //   497	1	6	str2	String
    //   1	1	7	localObject2	Object
    //   210	246	7	localException2	java.lang.Exception
    //   461	5	7	localObject3	Object
    //   471	6	7	localObject4	Object
    //   4	496	8	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   81	86	100	java/io/IOException
    //   90	98	119	java/io/IOException
    //   182	188	210	java/lang/Exception
    //   188	195	210	java/lang/Exception
    //   200	207	210	java/lang/Exception
    //   256	260	210	java/lang/Exception
    //   278	282	289	java/io/IOException
    //   265	270	312	java/io/IOException
    //   238	242	331	java/io/IOException
    //   246	250	350	java/io/IOException
    //   25	35	372	finally
    //   384	389	399	java/io/IOException
    //   393	397	421	java/io/IOException
    //   35	41	454	finally
    //   52	59	454	finally
    //   137	173	454	finally
    //   173	182	454	finally
    //   182	188	461	finally
    //   188	195	461	finally
    //   200	207	461	finally
    //   256	260	461	finally
    //   221	234	471	finally
    //   25	35	482	java/lang/Exception
    //   35	41	492	java/lang/Exception
    //   52	59	492	java/lang/Exception
    //   137	173	492	java/lang/Exception
    //   173	182	492	java/lang/Exception
  }
  
  /* Error */
  public static boolean a(byte[] paramArrayOfByte, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 5
    //   6: aconst_null
    //   7: astore 7
    //   9: aconst_null
    //   10: astore 4
    //   12: new 31	java/io/FileOutputStream
    //   15: dup
    //   16: aload_2
    //   17: invokespecial 32	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   20: astore_2
    //   21: aload 7
    //   23: astore 5
    //   25: aload_2
    //   26: astore 4
    //   28: aload_2
    //   29: aload_0
    //   30: iconst_0
    //   31: aload_0
    //   32: arraylength
    //   33: invokevirtual 54	java/io/FileOutputStream:write	([BII)V
    //   36: aload 7
    //   38: astore 5
    //   40: aload_2
    //   41: astore 4
    //   43: new 28	java/io/FileInputStream
    //   46: dup
    //   47: aload_1
    //   48: invokespecial 29	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   51: astore_0
    //   52: sipush 4096
    //   55: newarray byte
    //   57: astore_1
    //   58: aload_0
    //   59: aload_1
    //   60: invokevirtual 136	java/io/FileInputStream:read	([B)I
    //   63: istore_3
    //   64: iload_3
    //   65: iconst_m1
    //   66: if_icmpeq +53 -> 119
    //   69: aload_2
    //   70: aload_1
    //   71: iconst_0
    //   72: iload_3
    //   73: invokevirtual 54	java/io/FileOutputStream:write	([BII)V
    //   76: goto -18 -> 58
    //   79: astore 4
    //   81: aload_2
    //   82: astore_1
    //   83: aload 4
    //   85: astore_2
    //   86: aload_2
    //   87: invokevirtual 157	java/io/FileNotFoundException:printStackTrace	()V
    //   90: ldc 56
    //   92: iconst_1
    //   93: aload_2
    //   94: iconst_0
    //   95: anewarray 4	java/lang/Object
    //   98: invokestatic 141	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   101: aload_0
    //   102: ifnull +7 -> 109
    //   105: aload_0
    //   106: invokevirtual 137	java/io/FileInputStream:close	()V
    //   109: aload_1
    //   110: ifnull +55 -> 165
    //   113: aload_1
    //   114: invokevirtual 78	java/io/FileOutputStream:close	()V
    //   117: iconst_1
    //   118: ireturn
    //   119: aload_0
    //   120: ifnull +7 -> 127
    //   123: aload_0
    //   124: invokevirtual 137	java/io/FileInputStream:close	()V
    //   127: aload_2
    //   128: ifnull +9 -> 137
    //   131: aload_2
    //   132: invokevirtual 78	java/io/FileOutputStream:close	()V
    //   135: iconst_1
    //   136: ireturn
    //   137: ldc 56
    //   139: iconst_1
    //   140: ldc 159
    //   142: invokestatic 64	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   145: iconst_0
    //   146: ireturn
    //   147: astore_0
    //   148: aload_0
    //   149: invokevirtual 138	java/io/IOException:printStackTrace	()V
    //   152: ldc 56
    //   154: iconst_1
    //   155: aload_0
    //   156: iconst_0
    //   157: anewarray 4	java/lang/Object
    //   160: invokestatic 141	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   163: iconst_0
    //   164: ireturn
    //   165: ldc 56
    //   167: iconst_1
    //   168: ldc 159
    //   170: invokestatic 64	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   173: iconst_0
    //   174: ireturn
    //   175: astore_0
    //   176: aload_0
    //   177: invokevirtual 138	java/io/IOException:printStackTrace	()V
    //   180: ldc 56
    //   182: iconst_1
    //   183: aload_0
    //   184: iconst_0
    //   185: anewarray 4	java/lang/Object
    //   188: invokestatic 141	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   191: iconst_0
    //   192: ireturn
    //   193: astore_0
    //   194: aconst_null
    //   195: astore_2
    //   196: aload 6
    //   198: astore_1
    //   199: aload_1
    //   200: astore 5
    //   202: aload_2
    //   203: astore 4
    //   205: aload_0
    //   206: invokevirtual 138	java/io/IOException:printStackTrace	()V
    //   209: aload_1
    //   210: astore 5
    //   212: aload_2
    //   213: astore 4
    //   215: ldc 56
    //   217: iconst_1
    //   218: aload_0
    //   219: iconst_0
    //   220: anewarray 4	java/lang/Object
    //   223: invokestatic 141	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   226: aload_1
    //   227: ifnull +7 -> 234
    //   230: aload_1
    //   231: invokevirtual 137	java/io/FileInputStream:close	()V
    //   234: aload_2
    //   235: ifnull +9 -> 244
    //   238: aload_2
    //   239: invokevirtual 78	java/io/FileOutputStream:close	()V
    //   242: iconst_1
    //   243: ireturn
    //   244: ldc 56
    //   246: iconst_1
    //   247: ldc 159
    //   249: invokestatic 64	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   252: iconst_0
    //   253: ireturn
    //   254: astore_0
    //   255: aload_0
    //   256: invokevirtual 138	java/io/IOException:printStackTrace	()V
    //   259: ldc 56
    //   261: iconst_1
    //   262: aload_0
    //   263: iconst_0
    //   264: anewarray 4	java/lang/Object
    //   267: invokestatic 141	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   270: iconst_0
    //   271: ireturn
    //   272: astore_0
    //   273: aconst_null
    //   274: astore_2
    //   275: aload 5
    //   277: astore_0
    //   278: aload_0
    //   279: ifnull +7 -> 286
    //   282: aload_0
    //   283: invokevirtual 137	java/io/FileInputStream:close	()V
    //   286: aload_2
    //   287: ifnull +9 -> 296
    //   290: aload_2
    //   291: invokevirtual 78	java/io/FileOutputStream:close	()V
    //   294: iconst_1
    //   295: ireturn
    //   296: ldc 56
    //   298: iconst_1
    //   299: ldc 159
    //   301: invokestatic 64	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   304: iconst_0
    //   305: ireturn
    //   306: astore_0
    //   307: aload_0
    //   308: invokevirtual 138	java/io/IOException:printStackTrace	()V
    //   311: ldc 56
    //   313: iconst_1
    //   314: aload_0
    //   315: iconst_0
    //   316: anewarray 4	java/lang/Object
    //   319: invokestatic 141	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   322: iconst_0
    //   323: ireturn
    //   324: astore_0
    //   325: aload 5
    //   327: astore_0
    //   328: aload 4
    //   330: astore_2
    //   331: goto -53 -> 278
    //   334: astore_1
    //   335: goto -57 -> 278
    //   338: astore_2
    //   339: aload_1
    //   340: astore_2
    //   341: goto -63 -> 278
    //   344: astore_0
    //   345: aload 6
    //   347: astore_1
    //   348: goto -149 -> 199
    //   351: astore 4
    //   353: aload_0
    //   354: astore_1
    //   355: aload 4
    //   357: astore_0
    //   358: goto -159 -> 199
    //   361: astore_2
    //   362: aconst_null
    //   363: astore_0
    //   364: aload 4
    //   366: astore_1
    //   367: goto -281 -> 86
    //   370: astore 4
    //   372: aconst_null
    //   373: astore_0
    //   374: aload_2
    //   375: astore_1
    //   376: aload 4
    //   378: astore_2
    //   379: goto -293 -> 86
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	382	0	paramArrayOfByte	byte[]
    //   0	382	1	paramString1	String
    //   0	382	2	paramString2	String
    //   63	10	3	i	int
    //   10	32	4	str1	String
    //   79	5	4	localFileNotFoundException1	java.io.FileNotFoundException
    //   203	126	4	str2	String
    //   351	14	4	localIOException	IOException
    //   370	7	4	localFileNotFoundException2	java.io.FileNotFoundException
    //   4	322	5	localObject1	Object
    //   1	345	6	localObject2	Object
    //   7	30	7	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   52	58	79	java/io/FileNotFoundException
    //   58	64	79	java/io/FileNotFoundException
    //   69	76	79	java/io/FileNotFoundException
    //   123	127	147	java/io/IOException
    //   131	135	147	java/io/IOException
    //   137	145	147	java/io/IOException
    //   105	109	175	java/io/IOException
    //   113	117	175	java/io/IOException
    //   165	173	175	java/io/IOException
    //   12	21	193	java/io/IOException
    //   230	234	254	java/io/IOException
    //   238	242	254	java/io/IOException
    //   244	252	254	java/io/IOException
    //   12	21	272	finally
    //   282	286	306	java/io/IOException
    //   290	294	306	java/io/IOException
    //   296	304	306	java/io/IOException
    //   28	36	324	finally
    //   43	52	324	finally
    //   205	209	324	finally
    //   215	226	324	finally
    //   52	58	334	finally
    //   58	64	334	finally
    //   69	76	334	finally
    //   86	101	338	finally
    //   28	36	344	java/io/IOException
    //   43	52	344	java/io/IOException
    //   52	58	351	java/io/IOException
    //   58	64	351	java/io/IOException
    //   69	76	351	java/io/IOException
    //   12	21	361	java/io/FileNotFoundException
    //   28	36	370	java/io/FileNotFoundException
    //   43	52	370	java/io/FileNotFoundException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aygu
 * JD-Core Version:    0.7.0.1
 */