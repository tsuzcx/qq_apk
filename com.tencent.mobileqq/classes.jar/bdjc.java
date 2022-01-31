import android.os.Bundle;
import android.text.TextUtils;

public class bdjc
{
  protected static String a = "";
  
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 1: 
      return "ANDROIDQQ.FREEGIFT.APPAIO";
    case 50: 
      return "ANDROIDQQ.REQUEST.APPAIO";
    case 100: 
      return "ANDROIDQQ.INVITE.APPAIO";
    case 52: 
      return "ANDROIDQQ.BRAG.APPAIO";
    }
    return "ANDROIDQQ.PK.APPAIO";
  }
  
  public static String a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 == 352) {}
    switch (paramInt2)
    {
    case 4: 
    case 5: 
    case 6: 
    default: 
      return "";
    case 1: 
    case 3: 
      return "ANDROIDQQ.INSTALL.FEED";
    case 7: 
    case 8: 
      if ((paramInt3 == 0) || (paramInt3 == 2)) {
        return "ANDROIDQQ.SENDSTORY.FEED1";
      }
      if (paramInt3 == 1) {
        return "ANDROIDQQ.SENDSTORY.FEED2";
      }
      break;
    }
    return "";
  }
  
  public static String a(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && ((paramString1.startsWith("ANDROIDQQ.YYB")) || (paramString1.startsWith("ANDROIDQQ.NEWYYB")))) {
      return paramString1;
    }
    str = "";
    for (localObject = str;; localObject = str)
    {
      try
      {
        if (!TextUtils.isEmpty(paramString1))
        {
          localObject = str;
          if (!TextUtils.isEmpty(paramString2))
          {
            int i = paramString1.indexOf("ANDROIDQQ");
            if (i == -1) {
              break label111;
            }
            i += "ANDROIDQQ".length();
            localObject = new StringBuilder(paramString1);
            ((StringBuilder)localObject).insert(i, ".");
            ((StringBuilder)localObject).insert(i + 1, paramString2);
            localObject = ((StringBuilder)localObject).toString();
          }
        }
      }
      catch (Exception paramString2)
      {
        for (;;)
        {
          label111:
          bdht.c("VIA", "jointYybVia>>>", paramString2);
          localObject = str;
        }
      }
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break;
      }
      return localObject;
      bdht.c("VIA", "jointYybVia via dont contain ANDROIDQQ");
    }
  }
  
  /* Error */
  public static void a(android.content.Context paramContext, String paramString)
  {
    // Byte code:
    //   0: new 62	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   7: aload_0
    //   8: invokevirtual 104	android/content/Context:getFilesDir	()Ljava/io/File;
    //   11: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   14: getstatic 113	java/io/File:separator	Ljava/lang/String;
    //   17: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: ldc 118
    //   22: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: astore 4
    //   30: new 120	java/io/BufferedReader
    //   33: dup
    //   34: new 122	java/io/FileReader
    //   37: dup
    //   38: aload 4
    //   40: invokespecial 123	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   43: invokespecial 126	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   46: astore_3
    //   47: aload_3
    //   48: astore_2
    //   49: aload_3
    //   50: invokevirtual 129	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   53: astore 5
    //   55: aload_3
    //   56: astore_2
    //   57: aload_3
    //   58: invokevirtual 129	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   61: astore 6
    //   63: aload_3
    //   64: astore_2
    //   65: aload_3
    //   66: invokevirtual 129	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   69: astore 7
    //   71: aload_3
    //   72: astore_2
    //   73: aload 5
    //   75: invokestatic 40	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   78: ifne +117 -> 195
    //   81: aload_3
    //   82: astore_2
    //   83: aload 6
    //   85: invokestatic 40	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   88: ifne +107 -> 195
    //   91: aload_3
    //   92: astore_2
    //   93: aload 7
    //   95: invokestatic 40	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   98: ifne +97 -> 195
    //   101: aload_3
    //   102: astore_2
    //   103: ldc 78
    //   105: new 62	java/lang/StringBuilder
    //   108: dup
    //   109: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   112: ldc 131
    //   114: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: aload 5
    //   119: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: ldc 133
    //   124: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: aload 6
    //   129: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: ldc 135
    //   134: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: aload 7
    //   139: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   145: invokestatic 86	bdht:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   148: aload_3
    //   149: astore_2
    //   150: aload 5
    //   152: aload 6
    //   154: aload_1
    //   155: aload 7
    //   157: invokestatic 139	bdjc:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   160: aload_3
    //   161: astore_2
    //   162: new 110	java/io/File
    //   165: dup
    //   166: aload 4
    //   168: invokespecial 140	java/io/File:<init>	(Ljava/lang/String;)V
    //   171: invokevirtual 144	java/io/File:exists	()Z
    //   174: ifeq +12 -> 186
    //   177: aload_3
    //   178: astore_2
    //   179: aload_0
    //   180: ldc 118
    //   182: invokevirtual 147	android/content/Context:deleteFile	(Ljava/lang/String;)Z
    //   185: pop
    //   186: aload_3
    //   187: ifnull +7 -> 194
    //   190: aload_3
    //   191: invokevirtual 150	java/io/BufferedReader:close	()V
    //   194: return
    //   195: aload_3
    //   196: astore_2
    //   197: ldc 78
    //   199: new 62	java/lang/StringBuilder
    //   202: dup
    //   203: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   206: ldc 152
    //   208: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: aload 5
    //   213: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: ldc 133
    //   218: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: aload 6
    //   223: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: ldc 135
    //   228: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: aload 7
    //   233: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   239: invokestatic 155	bdht:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   242: goto -56 -> 186
    //   245: astore_0
    //   246: aload_3
    //   247: astore_2
    //   248: aload_0
    //   249: invokevirtual 158	java/io/FileNotFoundException:printStackTrace	()V
    //   252: aload_3
    //   253: ifnull -59 -> 194
    //   256: aload_3
    //   257: invokevirtual 150	java/io/BufferedReader:close	()V
    //   260: return
    //   261: astore_0
    //   262: aload_0
    //   263: invokevirtual 159	java/io/IOException:printStackTrace	()V
    //   266: return
    //   267: astore_0
    //   268: aload_0
    //   269: invokevirtual 159	java/io/IOException:printStackTrace	()V
    //   272: return
    //   273: astore_0
    //   274: aconst_null
    //   275: astore_3
    //   276: aload_3
    //   277: astore_2
    //   278: aload_0
    //   279: invokevirtual 159	java/io/IOException:printStackTrace	()V
    //   282: aload_3
    //   283: ifnull -89 -> 194
    //   286: aload_3
    //   287: invokevirtual 150	java/io/BufferedReader:close	()V
    //   290: return
    //   291: astore_0
    //   292: aload_0
    //   293: invokevirtual 159	java/io/IOException:printStackTrace	()V
    //   296: return
    //   297: astore_0
    //   298: aconst_null
    //   299: astore_2
    //   300: aload_2
    //   301: ifnull +7 -> 308
    //   304: aload_2
    //   305: invokevirtual 150	java/io/BufferedReader:close	()V
    //   308: aload_0
    //   309: athrow
    //   310: astore_1
    //   311: aload_1
    //   312: invokevirtual 159	java/io/IOException:printStackTrace	()V
    //   315: goto -7 -> 308
    //   318: astore_0
    //   319: goto -19 -> 300
    //   322: astore_0
    //   323: goto -47 -> 276
    //   326: astore_0
    //   327: aconst_null
    //   328: astore_3
    //   329: goto -83 -> 246
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	332	0	paramContext	android.content.Context
    //   0	332	1	paramString	String
    //   48	257	2	localBufferedReader1	java.io.BufferedReader
    //   46	283	3	localBufferedReader2	java.io.BufferedReader
    //   28	139	4	str1	String
    //   53	159	5	str2	String
    //   61	161	6	str3	String
    //   69	163	7	str4	String
    // Exception table:
    //   from	to	target	type
    //   49	55	245	java/io/FileNotFoundException
    //   57	63	245	java/io/FileNotFoundException
    //   65	71	245	java/io/FileNotFoundException
    //   73	81	245	java/io/FileNotFoundException
    //   83	91	245	java/io/FileNotFoundException
    //   93	101	245	java/io/FileNotFoundException
    //   103	148	245	java/io/FileNotFoundException
    //   150	160	245	java/io/FileNotFoundException
    //   162	177	245	java/io/FileNotFoundException
    //   179	186	245	java/io/FileNotFoundException
    //   197	242	245	java/io/FileNotFoundException
    //   256	260	261	java/io/IOException
    //   190	194	267	java/io/IOException
    //   0	47	273	java/io/IOException
    //   286	290	291	java/io/IOException
    //   0	47	297	finally
    //   304	308	310	java/io/IOException
    //   49	55	318	finally
    //   57	63	318	finally
    //   65	71	318	finally
    //   73	81	318	finally
    //   83	91	318	finally
    //   93	101	318	finally
    //   103	148	318	finally
    //   150	160	318	finally
    //   162	177	318	finally
    //   179	186	318	finally
    //   197	242	318	finally
    //   248	252	318	finally
    //   278	282	318	finally
    //   49	55	322	java/io/IOException
    //   57	63	322	java/io/IOException
    //   65	71	322	java/io/IOException
    //   73	81	322	java/io/IOException
    //   83	91	322	java/io/IOException
    //   93	101	322	java/io/IOException
    //   103	148	322	java/io/IOException
    //   150	160	322	java/io/IOException
    //   162	177	322	java/io/IOException
    //   179	186	322	java/io/IOException
    //   197	242	322	java/io/IOException
    //   0	47	326	java/io/FileNotFoundException
  }
  
  /* Error */
  public static void a(android.content.Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 40	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifne +17 -> 21
    //   7: aload_2
    //   8: invokestatic 40	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11: ifne +10 -> 21
    //   14: aload_3
    //   15: invokestatic 40	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   18: ifeq +46 -> 64
    //   21: ldc 78
    //   23: new 62	java/lang/StringBuilder
    //   26: dup
    //   27: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   30: ldc 162
    //   32: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: aload_1
    //   36: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: ldc 133
    //   41: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: aload_2
    //   45: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: ldc 135
    //   50: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: aload_3
    //   54: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   60: invokestatic 155	bdht:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   63: return
    //   64: aconst_null
    //   65: astore 4
    //   67: new 62	java/lang/StringBuilder
    //   70: dup
    //   71: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   74: aload_0
    //   75: invokevirtual 104	android/content/Context:getFilesDir	()Ljava/io/File;
    //   78: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   81: getstatic 113	java/io/File:separator	Ljava/lang/String;
    //   84: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: ldc 118
    //   89: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   95: astore 5
    //   97: new 110	java/io/File
    //   100: dup
    //   101: aload 5
    //   103: invokespecial 140	java/io/File:<init>	(Ljava/lang/String;)V
    //   106: invokevirtual 144	java/io/File:exists	()Z
    //   109: ifeq +10 -> 119
    //   112: aload_0
    //   113: ldc 118
    //   115: invokevirtual 147	android/content/Context:deleteFile	(Ljava/lang/String;)Z
    //   118: pop
    //   119: new 164	java/io/BufferedWriter
    //   122: dup
    //   123: new 166	java/io/FileWriter
    //   126: dup
    //   127: aload 5
    //   129: invokespecial 167	java/io/FileWriter:<init>	(Ljava/lang/String;)V
    //   132: invokespecial 170	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   135: astore_0
    //   136: aload_0
    //   137: astore 4
    //   139: aload_0
    //   140: aload_1
    //   141: invokevirtual 173	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   144: aload_0
    //   145: astore 4
    //   147: aload_0
    //   148: invokevirtual 176	java/io/BufferedWriter:newLine	()V
    //   151: aload_0
    //   152: astore 4
    //   154: aload_0
    //   155: aload_2
    //   156: invokevirtual 173	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   159: aload_0
    //   160: astore 4
    //   162: aload_0
    //   163: invokevirtual 176	java/io/BufferedWriter:newLine	()V
    //   166: aload_0
    //   167: astore 4
    //   169: aload_0
    //   170: aload_3
    //   171: invokevirtual 173	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   174: aload_0
    //   175: astore 4
    //   177: aload_0
    //   178: invokevirtual 179	java/io/BufferedWriter:flush	()V
    //   181: aload_0
    //   182: astore 4
    //   184: ldc 78
    //   186: new 62	java/lang/StringBuilder
    //   189: dup
    //   190: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   193: ldc 181
    //   195: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: aload_1
    //   199: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: ldc 133
    //   204: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: aload_2
    //   208: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: ldc 135
    //   213: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: aload_3
    //   217: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   223: invokestatic 86	bdht:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   226: aload_0
    //   227: ifnull -164 -> 63
    //   230: aload_0
    //   231: invokevirtual 182	java/io/BufferedWriter:close	()V
    //   234: return
    //   235: astore_0
    //   236: aload_0
    //   237: invokevirtual 159	java/io/IOException:printStackTrace	()V
    //   240: return
    //   241: astore_1
    //   242: aload 4
    //   244: astore_0
    //   245: aload_1
    //   246: invokevirtual 158	java/io/FileNotFoundException:printStackTrace	()V
    //   249: aload_0
    //   250: ifnull -187 -> 63
    //   253: aload_0
    //   254: invokevirtual 182	java/io/BufferedWriter:close	()V
    //   257: return
    //   258: astore_0
    //   259: aload_0
    //   260: invokevirtual 159	java/io/IOException:printStackTrace	()V
    //   263: return
    //   264: astore_1
    //   265: aconst_null
    //   266: astore_0
    //   267: aload_0
    //   268: astore 4
    //   270: aload_1
    //   271: invokevirtual 159	java/io/IOException:printStackTrace	()V
    //   274: aload_0
    //   275: ifnull -212 -> 63
    //   278: aload_0
    //   279: invokevirtual 182	java/io/BufferedWriter:close	()V
    //   282: return
    //   283: astore_0
    //   284: aload_0
    //   285: invokevirtual 159	java/io/IOException:printStackTrace	()V
    //   288: return
    //   289: astore_0
    //   290: aconst_null
    //   291: astore 4
    //   293: aload 4
    //   295: ifnull +8 -> 303
    //   298: aload 4
    //   300: invokevirtual 182	java/io/BufferedWriter:close	()V
    //   303: aload_0
    //   304: athrow
    //   305: astore_1
    //   306: aload_1
    //   307: invokevirtual 159	java/io/IOException:printStackTrace	()V
    //   310: goto -7 -> 303
    //   313: astore_0
    //   314: goto -21 -> 293
    //   317: astore_1
    //   318: aload_0
    //   319: astore 4
    //   321: aload_1
    //   322: astore_0
    //   323: goto -30 -> 293
    //   326: astore_1
    //   327: goto -60 -> 267
    //   330: astore_1
    //   331: goto -86 -> 245
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	334	0	paramContext	android.content.Context
    //   0	334	1	paramString1	String
    //   0	334	2	paramString2	String
    //   0	334	3	paramString3	String
    //   65	255	4	localContext	android.content.Context
    //   95	33	5	str	String
    // Exception table:
    //   from	to	target	type
    //   230	234	235	java/io/IOException
    //   67	119	241	java/io/FileNotFoundException
    //   119	136	241	java/io/FileNotFoundException
    //   253	257	258	java/io/IOException
    //   67	119	264	java/io/IOException
    //   119	136	264	java/io/IOException
    //   278	282	283	java/io/IOException
    //   67	119	289	finally
    //   119	136	289	finally
    //   298	303	305	java/io/IOException
    //   139	144	313	finally
    //   147	151	313	finally
    //   154	159	313	finally
    //   162	166	313	finally
    //   169	174	313	finally
    //   177	181	313	finally
    //   184	226	313	finally
    //   270	274	313	finally
    //   245	249	317	finally
    //   139	144	326	java/io/IOException
    //   147	151	326	java/io/IOException
    //   154	159	326	java/io/IOException
    //   162	166	326	java/io/IOException
    //   169	174	326	java/io/IOException
    //   177	181	326	java/io/IOException
    //   184	226	326	java/io/IOException
    //   139	144	330	java/io/FileNotFoundException
    //   147	151	330	java/io/FileNotFoundException
    //   154	159	330	java/io/FileNotFoundException
    //   162	166	330	java/io/FileNotFoundException
    //   169	174	330	java/io/FileNotFoundException
    //   177	181	330	java/io/FileNotFoundException
    //   184	226	330	java/io/FileNotFoundException
  }
  
  public static void a(String paramString1, String paramString2, String paramString3)
  {
    if ((paramString1 == null) || (paramString2 == null) || (paramString3 == null)) {
      return;
    }
    bdht.b("reportForVia", "reportForVia actionType=" + paramString1 + " via=" + paramString2 + ", appid=" + paramString3);
    bdjo.a().a(String.valueOf(bcxm.a().a()), paramString3, paramString2, paramString1, "", false);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if ((paramString1 == null) || (paramString2 == null) || (paramString3 == null)) {
      return;
    }
    bdht.b("reportForVia", "reportForVia actionType=" + paramString1 + " via=" + paramString2 + ", appid=" + paramString3);
    bdjo.a().a(String.valueOf(bcxm.a().a()), paramString3, paramString2, paramString1, paramString4, false);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, Bundle paramBundle)
  {
    if ((paramString1 == null) || (paramString2 == null) || (paramString3 == null)) {
      return;
    }
    bdht.b("reportForVia", "reportForVia actionType=" + paramString1 + " via=" + paramString2 + ", appid=" + paramString3);
    long l = bcxm.a().a();
    bdjo.a().a(String.valueOf(l), paramString3, paramString2, paramString1, bcxm.a().f(), paramBundle, paramString4, false);
  }
  
  public static void b(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if ((paramString1 == null) || (paramString2 == null) || (paramString4 == null)) {
      return;
    }
    bdht.b("reportForVia", "reportForVia actionType=" + paramString1 + " via=" + paramString2 + ", appid=" + paramString4);
    bdjo.a().a(paramString3, paramString4, paramString2, paramString1, "", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bdjc
 * JD-Core Version:    0.7.0.1
 */