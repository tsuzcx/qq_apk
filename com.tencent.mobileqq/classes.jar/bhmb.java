import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.text.TextUtils;

public class bhmb
{
  /* Error */
  public static boolean a(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: invokestatic 13	bdcb:a	()Ljava/lang/String;
    //   6: astore 4
    //   8: aload 4
    //   10: astore_3
    //   11: aload 4
    //   13: ifnonnull +6 -> 19
    //   16: ldc 15
    //   18: astore_3
    //   19: new 17	MAAccessClient/AcCode
    //   22: dup
    //   23: aload_3
    //   24: invokestatic 22	com/tencent/common/config/AppSetting:a	()I
    //   27: invokestatic 28	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   30: invokestatic 34	android/os/SystemClock:uptimeMillis	()J
    //   33: invokestatic 37	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   36: getstatic 43	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   39: invokestatic 48	aowf:a	(Landroid/content/Context;)I
    //   42: invokespecial 52	MAAccessClient/AcCode:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
    //   45: invokevirtual 56	MAAccessClient/AcCode:toByteArray	()[B
    //   48: astore 6
    //   50: aload_0
    //   51: invokevirtual 61	android/content/Context:getPackageName	()Ljava/lang/String;
    //   54: astore 7
    //   56: aload 7
    //   58: invokevirtual 64	java/lang/String:length	()I
    //   61: istore_2
    //   62: bipush 16
    //   64: iload_2
    //   65: idiv
    //   66: istore_1
    //   67: bipush 16
    //   69: iload_2
    //   70: irem
    //   71: istore_2
    //   72: ldc 15
    //   74: astore_3
    //   75: iload_1
    //   76: ifle +30 -> 106
    //   79: new 66	java/lang/StringBuilder
    //   82: dup
    //   83: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   86: aload_3
    //   87: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: aload 7
    //   92: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   98: astore_3
    //   99: iload_1
    //   100: iconst_1
    //   101: isub
    //   102: istore_1
    //   103: goto -28 -> 75
    //   106: aload_3
    //   107: astore 4
    //   109: iload_2
    //   110: ifle +29 -> 139
    //   113: new 66	java/lang/StringBuilder
    //   116: dup
    //   117: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   120: aload_3
    //   121: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: aload 7
    //   126: iconst_0
    //   127: iload_2
    //   128: invokevirtual 80	java/lang/String:substring	(II)Ljava/lang/String;
    //   131: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   137: astore 4
    //   139: aload 4
    //   141: invokevirtual 83	java/lang/String:getBytes	()[B
    //   144: astore_3
    //   145: new 85	com/tencent/qphone/base/util/Cryptor
    //   148: dup
    //   149: invokespecial 86	com/tencent/qphone/base/util/Cryptor:<init>	()V
    //   152: aload 6
    //   154: aload_3
    //   155: invokevirtual 90	com/tencent/qphone/base/util/Cryptor:encrypt	([B[B)[B
    //   158: astore_3
    //   159: aload_3
    //   160: ifnull +161 -> 321
    //   163: aload_0
    //   164: invokestatic 96	com/tencent/commonsdk/soload/SoLoadCore:getAppWorkPath	(Landroid/content/Context;)Ljava/lang/String;
    //   167: astore_0
    //   168: new 98	java/io/File
    //   171: dup
    //   172: new 66	java/lang/StringBuilder
    //   175: dup
    //   176: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   179: aload_0
    //   180: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: ldc 100
    //   185: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   191: invokespecial 103	java/io/File:<init>	(Ljava/lang/String;)V
    //   194: astore_0
    //   195: aload_0
    //   196: invokevirtual 107	java/io/File:getParentFile	()Ljava/io/File;
    //   199: astore 4
    //   201: aload 4
    //   203: invokevirtual 111	java/io/File:exists	()Z
    //   206: ifeq +11 -> 217
    //   209: aload 4
    //   211: invokevirtual 114	java/io/File:isDirectory	()Z
    //   214: ifne +9 -> 223
    //   217: aload 4
    //   219: invokevirtual 117	java/io/File:mkdirs	()Z
    //   222: pop
    //   223: aload_0
    //   224: invokevirtual 111	java/io/File:exists	()Z
    //   227: ifeq +8 -> 235
    //   230: aload_0
    //   231: invokevirtual 120	java/io/File:delete	()Z
    //   234: pop
    //   235: aload_0
    //   236: invokevirtual 123	java/io/File:createNewFile	()Z
    //   239: pop
    //   240: new 125	java/io/FileOutputStream
    //   243: dup
    //   244: aload_0
    //   245: invokespecial 128	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   248: astore_0
    //   249: aload_0
    //   250: aload_3
    //   251: invokevirtual 132	java/io/FileOutputStream:write	([B)V
    //   254: aload_0
    //   255: ifnull +7 -> 262
    //   258: aload_0
    //   259: invokevirtual 135	java/io/FileOutputStream:close	()V
    //   262: iconst_1
    //   263: ireturn
    //   264: astore_3
    //   265: aconst_null
    //   266: astore_3
    //   267: goto -108 -> 159
    //   270: astore_0
    //   271: aconst_null
    //   272: astore_0
    //   273: aload_0
    //   274: ifnull +47 -> 321
    //   277: aload_0
    //   278: invokevirtual 135	java/io/FileOutputStream:close	()V
    //   281: iconst_0
    //   282: ireturn
    //   283: astore_0
    //   284: iconst_0
    //   285: ireturn
    //   286: astore_0
    //   287: aload 5
    //   289: astore_3
    //   290: aload_3
    //   291: ifnull +7 -> 298
    //   294: aload_3
    //   295: invokevirtual 135	java/io/FileOutputStream:close	()V
    //   298: aload_0
    //   299: athrow
    //   300: astore_0
    //   301: iconst_1
    //   302: ireturn
    //   303: astore_3
    //   304: goto -6 -> 298
    //   307: astore 4
    //   309: aload_0
    //   310: astore_3
    //   311: aload 4
    //   313: astore_0
    //   314: goto -24 -> 290
    //   317: astore_3
    //   318: goto -45 -> 273
    //   321: iconst_0
    //   322: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	323	0	paramContext	Context
    //   66	37	1	i	int
    //   61	67	2	j	int
    //   10	241	3	localObject1	Object
    //   264	1	3	localException1	Exception
    //   266	29	3	localObject2	Object
    //   303	1	3	localException2	Exception
    //   310	1	3	localContext	Context
    //   317	1	3	localException3	Exception
    //   6	212	4	localObject3	Object
    //   307	5	4	localObject4	Object
    //   1	287	5	localObject5	Object
    //   48	105	6	arrayOfByte	byte[]
    //   54	71	7	str	String
    // Exception table:
    //   from	to	target	type
    //   145	159	264	java/lang/Exception
    //   235	249	270	java/lang/Exception
    //   277	281	283	java/lang/Exception
    //   235	249	286	finally
    //   258	262	300	java/lang/Exception
    //   294	298	303	java/lang/Exception
    //   249	254	307	finally
    //   249	254	317	java/lang/Exception
  }
  
  public static boolean a(Context paramContext, String paramString1, int paramInt, String paramString2)
  {
    String str = "";
    try
    {
      PackageInfo localPackageInfo = paramContext.getPackageManager().getPackageInfo(paramString1, 64);
      if (localPackageInfo.signatures.length >= 1) {
        str = bhma.a(localPackageInfo.signatures[(localPackageInfo.signatures.length - 1)].toCharsString());
      }
      if ((!TextUtils.isEmpty(str)) && (str.equals(paramString2)))
      {
        int i = bhlz.a(paramContext, paramString1);
        if (i < paramInt) {
          return true;
        }
      }
    }
    catch (Exception paramContext)
    {
      return false;
    }
    return false;
  }
  
  /* Error */
  public static boolean b(Context paramContext)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: aconst_null
    //   4: astore 8
    //   6: aload_0
    //   7: invokestatic 96	com/tencent/commonsdk/soload/SoLoadCore:getAppWorkPath	(Landroid/content/Context;)Ljava/lang/String;
    //   10: astore 5
    //   12: new 98	java/io/File
    //   15: dup
    //   16: new 66	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   23: aload 5
    //   25: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: ldc 100
    //   30: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: invokespecial 103	java/io/File:<init>	(Ljava/lang/String;)V
    //   39: astore 5
    //   41: iload 4
    //   43: istore_3
    //   44: aload 5
    //   46: invokevirtual 111	java/io/File:exists	()Z
    //   49: ifeq +388 -> 437
    //   52: iload 4
    //   54: istore_3
    //   55: aload 5
    //   57: invokevirtual 182	java/io/File:isFile	()Z
    //   60: ifeq +377 -> 437
    //   63: new 184	java/io/FileInputStream
    //   66: dup
    //   67: aload 5
    //   69: invokespecial 185	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   72: astore 6
    //   74: new 187	java/io/ByteArrayOutputStream
    //   77: dup
    //   78: sipush 128
    //   81: invokespecial 190	java/io/ByteArrayOutputStream:<init>	(I)V
    //   84: astore 5
    //   86: sipush 128
    //   89: newarray byte
    //   91: astore 7
    //   93: aload 6
    //   95: aload 7
    //   97: invokevirtual 194	java/io/FileInputStream:read	([B)I
    //   100: istore_1
    //   101: iload_1
    //   102: ifle +23 -> 125
    //   105: aload 5
    //   107: aload 7
    //   109: iconst_0
    //   110: iload_1
    //   111: invokevirtual 197	java/io/ByteArrayOutputStream:write	([BII)V
    //   114: aload 6
    //   116: aload 7
    //   118: invokevirtual 194	java/io/FileInputStream:read	([B)I
    //   121: istore_1
    //   122: goto -21 -> 101
    //   125: aload 5
    //   127: invokevirtual 198	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   130: astore 7
    //   132: aload 5
    //   134: ifnull +8 -> 142
    //   137: aload 5
    //   139: invokevirtual 199	java/io/ByteArrayOutputStream:close	()V
    //   142: aload 7
    //   144: astore 5
    //   146: aload 6
    //   148: ifnull +12 -> 160
    //   151: aload 6
    //   153: invokevirtual 200	java/io/FileInputStream:close	()V
    //   156: aload 7
    //   158: astore 5
    //   160: aload_0
    //   161: invokevirtual 61	android/content/Context:getPackageName	()Ljava/lang/String;
    //   164: astore 7
    //   166: aload 7
    //   168: invokevirtual 64	java/lang/String:length	()I
    //   171: istore_2
    //   172: bipush 16
    //   174: iload_2
    //   175: idiv
    //   176: istore_1
    //   177: bipush 16
    //   179: iload_2
    //   180: irem
    //   181: istore_2
    //   182: ldc 15
    //   184: astore_0
    //   185: iload_1
    //   186: ifle +101 -> 287
    //   189: new 66	java/lang/StringBuilder
    //   192: dup
    //   193: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   196: aload_0
    //   197: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: aload 7
    //   202: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   208: astore_0
    //   209: iload_1
    //   210: iconst_1
    //   211: isub
    //   212: istore_1
    //   213: goto -28 -> 185
    //   216: astore 5
    //   218: aconst_null
    //   219: astore 5
    //   221: aconst_null
    //   222: astore 6
    //   224: aload 5
    //   226: ifnull +8 -> 234
    //   229: aload 5
    //   231: invokevirtual 199	java/io/ByteArrayOutputStream:close	()V
    //   234: aload 6
    //   236: ifnull +275 -> 511
    //   239: aload 6
    //   241: invokevirtual 200	java/io/FileInputStream:close	()V
    //   244: aconst_null
    //   245: astore 5
    //   247: goto -87 -> 160
    //   250: astore 5
    //   252: aconst_null
    //   253: astore 5
    //   255: goto -95 -> 160
    //   258: astore_0
    //   259: aconst_null
    //   260: astore 5
    //   262: aconst_null
    //   263: astore 6
    //   265: aload 5
    //   267: ifnull +8 -> 275
    //   270: aload 5
    //   272: invokevirtual 199	java/io/ByteArrayOutputStream:close	()V
    //   275: aload 6
    //   277: ifnull +8 -> 285
    //   280: aload 6
    //   282: invokevirtual 200	java/io/FileInputStream:close	()V
    //   285: aload_0
    //   286: athrow
    //   287: aload_0
    //   288: astore 6
    //   290: iload_2
    //   291: ifle +29 -> 320
    //   294: new 66	java/lang/StringBuilder
    //   297: dup
    //   298: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   301: aload_0
    //   302: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: aload 7
    //   307: iconst_0
    //   308: iload_2
    //   309: invokevirtual 80	java/lang/String:substring	(II)Ljava/lang/String;
    //   312: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   318: astore 6
    //   320: aload 6
    //   322: invokevirtual 83	java/lang/String:getBytes	()[B
    //   325: astore_0
    //   326: new 85	com/tencent/qphone/base/util/Cryptor
    //   329: dup
    //   330: invokespecial 86	com/tencent/qphone/base/util/Cryptor:<init>	()V
    //   333: aload 5
    //   335: aload_0
    //   336: invokevirtual 203	com/tencent/qphone/base/util/Cryptor:decrypt	([B[B)[B
    //   339: astore_0
    //   340: aload 8
    //   342: astore 5
    //   344: aload_0
    //   345: ifnull +27 -> 372
    //   348: new 205	com/qq/taf/jce/JceInputStream
    //   351: dup
    //   352: aload_0
    //   353: invokespecial 207	com/qq/taf/jce/JceInputStream:<init>	([B)V
    //   356: astore_0
    //   357: new 17	MAAccessClient/AcCode
    //   360: dup
    //   361: invokespecial 208	MAAccessClient/AcCode:<init>	()V
    //   364: astore 5
    //   366: aload 5
    //   368: aload_0
    //   369: invokevirtual 212	MAAccessClient/AcCode:readFrom	(Lcom/qq/taf/jce/JceInputStream;)V
    //   372: getstatic 43	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   375: invokestatic 48	aowf:a	(Landroid/content/Context;)I
    //   378: istore_1
    //   379: iload 4
    //   381: istore_3
    //   382: aload 5
    //   384: ifnull +53 -> 437
    //   387: aload 5
    //   389: getfield 216	MAAccessClient/AcCode:imei	Ljava/lang/String;
    //   392: ifnull +17 -> 409
    //   395: aload 5
    //   397: getfield 216	MAAccessClient/AcCode:imei	Ljava/lang/String;
    //   400: invokestatic 13	bdcb:a	()Ljava/lang/String;
    //   403: invokevirtual 173	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   406: ifeq +39 -> 445
    //   409: invokestatic 22	com/tencent/common/config/AppSetting:a	()I
    //   412: invokestatic 28	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   415: aload 5
    //   417: getfield 219	MAAccessClient/AcCode:appid	Ljava/lang/String;
    //   420: invokevirtual 173	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   423: ifeq +22 -> 445
    //   426: iload_1
    //   427: aload 5
    //   429: getfield 223	MAAccessClient/AcCode:versionCode	I
    //   432: if_icmpne +13 -> 445
    //   435: iconst_1
    //   436: istore_3
    //   437: iload_3
    //   438: ireturn
    //   439: astore_0
    //   440: aconst_null
    //   441: astore_0
    //   442: goto -102 -> 340
    //   445: iconst_0
    //   446: istore_3
    //   447: goto -10 -> 437
    //   450: astore 5
    //   452: goto -310 -> 142
    //   455: astore 5
    //   457: aload 7
    //   459: astore 5
    //   461: goto -301 -> 160
    //   464: astore 5
    //   466: goto -232 -> 234
    //   469: astore 5
    //   471: goto -196 -> 275
    //   474: astore 5
    //   476: goto -191 -> 285
    //   479: astore_0
    //   480: aload 8
    //   482: astore 5
    //   484: goto -112 -> 372
    //   487: astore_0
    //   488: aconst_null
    //   489: astore 5
    //   491: goto -226 -> 265
    //   494: astore_0
    //   495: goto -230 -> 265
    //   498: astore 5
    //   500: aconst_null
    //   501: astore 5
    //   503: goto -279 -> 224
    //   506: astore 7
    //   508: goto -284 -> 224
    //   511: aconst_null
    //   512: astore 5
    //   514: goto -354 -> 160
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	517	0	paramContext	Context
    //   100	333	1	i	int
    //   171	138	2	j	int
    //   43	404	3	bool1	boolean
    //   1	379	4	bool2	boolean
    //   10	149	5	localObject1	Object
    //   216	1	5	localException1	Exception
    //   219	27	5	localObject2	Object
    //   250	1	5	localException2	Exception
    //   253	175	5	localObject3	Object
    //   450	1	5	localException3	Exception
    //   455	1	5	localException4	Exception
    //   459	1	5	localObject4	Object
    //   464	1	5	localException5	Exception
    //   469	1	5	localException6	Exception
    //   474	1	5	localException7	Exception
    //   482	8	5	localObject5	Object
    //   498	1	5	localException8	Exception
    //   501	12	5	localObject6	Object
    //   72	249	6	localObject7	Object
    //   91	367	7	localObject8	Object
    //   506	1	7	localException9	Exception
    //   4	477	8	localObject9	Object
    // Exception table:
    //   from	to	target	type
    //   63	74	216	java/lang/Exception
    //   239	244	250	java/lang/Exception
    //   63	74	258	finally
    //   326	340	439	java/lang/Exception
    //   137	142	450	java/lang/Exception
    //   151	156	455	java/lang/Exception
    //   229	234	464	java/lang/Exception
    //   270	275	469	java/lang/Exception
    //   280	285	474	java/lang/Exception
    //   348	372	479	java/lang/Exception
    //   74	86	487	finally
    //   86	101	494	finally
    //   105	122	494	finally
    //   125	132	494	finally
    //   74	86	498	java/lang/Exception
    //   86	101	506	java/lang/Exception
    //   105	122	506	java/lang/Exception
    //   125	132	506	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhmb
 * JD-Core Version:    0.7.0.1
 */