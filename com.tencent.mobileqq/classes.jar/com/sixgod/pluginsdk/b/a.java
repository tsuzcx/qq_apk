package com.sixgod.pluginsdk.b;

import android.util.Log;
import java.io.File;

public final class a
{
  /* Error */
  public static String a(File paramFile)
  {
    // Byte code:
    //   0: new 12	java/io/FileInputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 16	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   8: astore_1
    //   9: aload_1
    //   10: astore_0
    //   11: iconst_4
    //   12: newarray byte
    //   14: astore_2
    //   15: aload_1
    //   16: astore_0
    //   17: aload_1
    //   18: aload_2
    //   19: iconst_0
    //   20: iconst_4
    //   21: invokevirtual 20	java/io/FileInputStream:read	([BII)I
    //   24: pop
    //   25: aload_1
    //   26: astore_0
    //   27: aload_2
    //   28: invokestatic 23	com/sixgod/pluginsdk/b/a:a	([B)Ljava/lang/String;
    //   31: astore_2
    //   32: aload_2
    //   33: astore_0
    //   34: aload_1
    //   35: invokevirtual 27	java/io/FileInputStream:close	()V
    //   38: aload_0
    //   39: astore_2
    //   40: aload_2
    //   41: areturn
    //   42: astore_1
    //   43: aload_1
    //   44: invokevirtual 30	java/io/IOException:printStackTrace	()V
    //   47: aload_0
    //   48: areturn
    //   49: astore_2
    //   50: aconst_null
    //   51: astore_1
    //   52: aload_1
    //   53: astore_0
    //   54: aload_2
    //   55: invokevirtual 31	java/lang/Exception:printStackTrace	()V
    //   58: aload_1
    //   59: astore_0
    //   60: new 33	java/lang/StringBuilder
    //   63: dup
    //   64: ldc 35
    //   66: invokespecial 38	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   69: aload_2
    //   70: invokevirtual 42	java/lang/Object:getClass	()Ljava/lang/Class;
    //   73: invokevirtual 48	java/lang/Class:getName	()Ljava/lang/String;
    //   76: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   82: astore_2
    //   83: aload_2
    //   84: astore_0
    //   85: aload_0
    //   86: astore_2
    //   87: aload_1
    //   88: ifnull -48 -> 40
    //   91: aload_1
    //   92: invokevirtual 27	java/io/FileInputStream:close	()V
    //   95: aload_0
    //   96: areturn
    //   97: astore_1
    //   98: aload_1
    //   99: invokevirtual 30	java/io/IOException:printStackTrace	()V
    //   102: aload_0
    //   103: areturn
    //   104: astore_1
    //   105: aconst_null
    //   106: astore_0
    //   107: aload_0
    //   108: ifnull +7 -> 115
    //   111: aload_0
    //   112: invokevirtual 27	java/io/FileInputStream:close	()V
    //   115: aload_1
    //   116: athrow
    //   117: astore_0
    //   118: aload_0
    //   119: invokevirtual 30	java/io/IOException:printStackTrace	()V
    //   122: goto -7 -> 115
    //   125: astore_1
    //   126: goto -19 -> 107
    //   129: astore_2
    //   130: goto -78 -> 52
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	133	0	paramFile	File
    //   8	27	1	localFileInputStream	java.io.FileInputStream
    //   42	2	1	localIOException1	java.io.IOException
    //   51	41	1	localObject1	Object
    //   97	2	1	localIOException2	java.io.IOException
    //   104	12	1	localObject2	Object
    //   125	1	1	localObject3	Object
    //   14	27	2	localObject4	Object
    //   49	21	2	localException1	Exception
    //   82	5	2	localObject5	Object
    //   129	1	2	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   34	38	42	java/io/IOException
    //   0	9	49	java/lang/Exception
    //   91	95	97	java/io/IOException
    //   0	9	104	finally
    //   111	115	117	java/io/IOException
    //   11	15	125	finally
    //   17	25	125	finally
    //   27	32	125	finally
    //   54	58	125	finally
    //   60	83	125	finally
    //   11	15	129	java/lang/Exception
    //   17	25	129	java/lang/Exception
    //   27	32	129	java/lang/Exception
  }
  
  private static String a(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0)) {
      return null;
    }
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      String str = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
      if (str.length() < 2) {
        localStringBuilder.append(0);
      }
      localStringBuilder.append(str);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  /* Error */
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 6
    //   6: aconst_null
    //   7: astore 7
    //   9: aload_1
    //   10: ldc 76
    //   12: invokevirtual 80	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   15: ifeq +285 -> 300
    //   18: aload_1
    //   19: astore 8
    //   21: sipush 8192
    //   24: newarray byte
    //   26: astore 9
    //   28: new 82	java/util/zip/ZipFile
    //   31: dup
    //   32: new 84	java/io/File
    //   35: dup
    //   36: aload_0
    //   37: invokespecial 85	java/io/File:<init>	(Ljava/lang/String;)V
    //   40: invokespecial 86	java/util/zip/ZipFile:<init>	(Ljava/io/File;)V
    //   43: astore 10
    //   45: aload 10
    //   47: invokevirtual 90	java/util/zip/ZipFile:entries	()Ljava/util/Enumeration;
    //   50: astore 11
    //   52: aconst_null
    //   53: astore 5
    //   55: aload 7
    //   57: astore_0
    //   58: aload_0
    //   59: astore 7
    //   61: aload 5
    //   63: astore 6
    //   65: aload 11
    //   67: invokeinterface 96 1 0
    //   72: ifeq +266 -> 338
    //   75: aload_0
    //   76: astore 7
    //   78: aload 5
    //   80: astore 6
    //   82: aload 11
    //   84: invokeinterface 100 1 0
    //   89: checkcast 102	java/util/zip/ZipEntry
    //   92: astore 12
    //   94: aload_0
    //   95: astore 7
    //   97: aload 5
    //   99: astore 6
    //   101: aload 12
    //   103: invokevirtual 103	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   106: aload_2
    //   107: invokevirtual 106	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   110: ifeq -52 -> 58
    //   113: aload_0
    //   114: astore 7
    //   116: aload 5
    //   118: astore 6
    //   120: aload 12
    //   122: invokevirtual 103	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   125: aload_3
    //   126: invokevirtual 80	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   129: ifeq -71 -> 58
    //   132: aload_0
    //   133: astore 7
    //   135: aload 5
    //   137: astore 6
    //   139: new 84	java/io/File
    //   142: dup
    //   143: new 33	java/lang/StringBuilder
    //   146: dup
    //   147: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   150: aload 8
    //   152: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: aload 12
    //   157: invokevirtual 103	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   160: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   166: invokespecial 85	java/io/File:<init>	(Ljava/lang/String;)V
    //   169: astore_1
    //   170: aload_0
    //   171: astore 7
    //   173: aload 5
    //   175: astore 6
    //   177: aload_1
    //   178: invokevirtual 110	java/io/File:getParentFile	()Ljava/io/File;
    //   181: invokevirtual 113	java/io/File:exists	()Z
    //   184: ifne +18 -> 202
    //   187: aload_0
    //   188: astore 7
    //   190: aload 5
    //   192: astore 6
    //   194: aload_1
    //   195: invokevirtual 110	java/io/File:getParentFile	()Ljava/io/File;
    //   198: invokevirtual 116	java/io/File:mkdirs	()Z
    //   201: pop
    //   202: aload_0
    //   203: astore 7
    //   205: aload 5
    //   207: astore 6
    //   209: new 118	java/io/FileOutputStream
    //   212: dup
    //   213: aload_1
    //   214: invokespecial 119	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   217: astore_1
    //   218: new 121	java/io/BufferedOutputStream
    //   221: dup
    //   222: aload_1
    //   223: sipush 8192
    //   226: invokespecial 124	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   229: astore 5
    //   231: aload 10
    //   233: aload 12
    //   235: invokevirtual 128	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   238: astore_0
    //   239: aload_0
    //   240: aload 9
    //   242: invokevirtual 133	java/io/InputStream:read	([B)I
    //   245: istore 4
    //   247: iload 4
    //   249: ifle +75 -> 324
    //   252: aload 5
    //   254: aload 9
    //   256: iconst_0
    //   257: iload 4
    //   259: invokevirtual 137	java/io/BufferedOutputStream:write	([BII)V
    //   262: goto -23 -> 239
    //   265: astore_3
    //   266: aload 5
    //   268: astore_2
    //   269: aload_1
    //   270: astore_0
    //   271: aload_3
    //   272: astore_1
    //   273: aload_2
    //   274: astore 7
    //   276: aload_0
    //   277: astore 6
    //   279: aload_1
    //   280: invokevirtual 30	java/io/IOException:printStackTrace	()V
    //   283: aload_0
    //   284: ifnull +7 -> 291
    //   287: aload_0
    //   288: invokevirtual 140	java/io/OutputStream:close	()V
    //   291: aload_2
    //   292: ifnull +7 -> 299
    //   295: aload_2
    //   296: invokevirtual 141	java/io/BufferedOutputStream:close	()V
    //   299: return
    //   300: new 33	java/lang/StringBuilder
    //   303: dup
    //   304: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   307: aload_1
    //   308: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: ldc 76
    //   313: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   319: astore 8
    //   321: goto -300 -> 21
    //   324: aload 5
    //   326: invokevirtual 144	java/io/BufferedOutputStream:flush	()V
    //   329: aload 5
    //   331: astore_0
    //   332: aload_1
    //   333: astore 5
    //   335: goto -277 -> 58
    //   338: aload 5
    //   340: ifnull +8 -> 348
    //   343: aload 5
    //   345: invokevirtual 140	java/io/OutputStream:close	()V
    //   348: aload_0
    //   349: ifnull -50 -> 299
    //   352: aload_0
    //   353: invokevirtual 141	java/io/BufferedOutputStream:close	()V
    //   356: return
    //   357: astore_0
    //   358: return
    //   359: astore_1
    //   360: aload_1
    //   361: invokevirtual 30	java/io/IOException:printStackTrace	()V
    //   364: goto -16 -> 348
    //   367: astore_0
    //   368: aload_0
    //   369: invokevirtual 30	java/io/IOException:printStackTrace	()V
    //   372: goto -81 -> 291
    //   375: astore_1
    //   376: aconst_null
    //   377: astore_2
    //   378: aload 6
    //   380: astore_0
    //   381: aload_2
    //   382: ifnull +7 -> 389
    //   385: aload_2
    //   386: invokevirtual 140	java/io/OutputStream:close	()V
    //   389: aload_0
    //   390: ifnull +7 -> 397
    //   393: aload_0
    //   394: invokevirtual 141	java/io/BufferedOutputStream:close	()V
    //   397: aload_1
    //   398: athrow
    //   399: astore_2
    //   400: aload_2
    //   401: invokevirtual 30	java/io/IOException:printStackTrace	()V
    //   404: goto -15 -> 389
    //   407: astore_0
    //   408: return
    //   409: astore_0
    //   410: goto -13 -> 397
    //   413: astore_3
    //   414: aload 5
    //   416: astore_0
    //   417: aload_1
    //   418: astore_2
    //   419: aload_3
    //   420: astore_1
    //   421: goto -40 -> 381
    //   424: astore_1
    //   425: aload 7
    //   427: astore_0
    //   428: aload 6
    //   430: astore_2
    //   431: goto -50 -> 381
    //   434: astore_3
    //   435: aload_1
    //   436: astore_2
    //   437: aload_3
    //   438: astore_1
    //   439: goto -58 -> 381
    //   442: astore_1
    //   443: aconst_null
    //   444: astore_0
    //   445: aload 5
    //   447: astore_2
    //   448: goto -175 -> 273
    //   451: astore_1
    //   452: aload_0
    //   453: astore_2
    //   454: aload 5
    //   456: astore_0
    //   457: goto -184 -> 273
    //   460: astore_2
    //   461: aload_1
    //   462: astore_3
    //   463: aload_2
    //   464: astore_1
    //   465: aload_0
    //   466: astore_2
    //   467: aload_3
    //   468: astore_0
    //   469: goto -196 -> 273
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	472	0	paramString1	String
    //   0	472	1	paramString2	String
    //   0	472	2	paramString3	String
    //   0	472	3	paramString4	String
    //   245	13	4	i	int
    //   1	454	5	localObject1	Object
    //   4	425	6	localObject2	Object
    //   7	419	7	str1	String
    //   19	301	8	str2	String
    //   26	229	9	arrayOfByte	byte[]
    //   43	189	10	localZipFile	java.util.zip.ZipFile
    //   50	33	11	localEnumeration	java.util.Enumeration
    //   92	142	12	localZipEntry	java.util.zip.ZipEntry
    // Exception table:
    //   from	to	target	type
    //   231	239	265	java/io/IOException
    //   239	247	265	java/io/IOException
    //   252	262	265	java/io/IOException
    //   324	329	265	java/io/IOException
    //   352	356	357	java/io/IOException
    //   343	348	359	java/io/IOException
    //   287	291	367	java/io/IOException
    //   28	52	375	finally
    //   385	389	399	java/io/IOException
    //   295	299	407	java/io/IOException
    //   393	397	409	java/io/IOException
    //   231	239	413	finally
    //   239	247	413	finally
    //   252	262	413	finally
    //   324	329	413	finally
    //   65	75	424	finally
    //   82	94	424	finally
    //   101	113	424	finally
    //   120	132	424	finally
    //   139	170	424	finally
    //   177	187	424	finally
    //   194	202	424	finally
    //   209	218	424	finally
    //   279	283	424	finally
    //   218	231	434	finally
    //   28	52	442	java/io/IOException
    //   65	75	451	java/io/IOException
    //   82	94	451	java/io/IOException
    //   101	113	451	java/io/IOException
    //   120	132	451	java/io/IOException
    //   139	170	451	java/io/IOException
    //   177	187	451	java/io/IOException
    //   194	202	451	java/io/IOException
    //   209	218	451	java/io/IOException
    //   218	231	460	java/io/IOException
  }
  
  public static boolean a(String paramString)
  {
    Object localObject = paramString;
    if (!paramString.endsWith(File.separator)) {
      localObject = paramString + File.separator;
    }
    paramString = new File((String)localObject);
    if (paramString.isFile())
    {
      localObject = new File(paramString.getAbsolutePath() + System.currentTimeMillis());
      paramString.renameTo((File)localObject);
      ((File)localObject).delete();
    }
    for (;;)
    {
      return true;
      String[] arrayOfString = paramString.list();
      if (arrayOfString != null)
      {
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          String str = arrayOfString[i];
          a((String)localObject + str);
          i += 1;
        }
      }
      localObject = new File(paramString.getAbsolutePath() + System.currentTimeMillis());
      paramString.renameTo((File)localObject);
      ((File)localObject).delete();
    }
  }
  
  public static boolean a(String paramString1, String paramString2, boolean paramBoolean)
  {
    File localFile = new File(paramString1);
    if (!localFile.exists())
    {
      Log.d("SixGod_PluginSdk", "sourceDir: " + paramString1 + " does not exit！");
      return false;
    }
    if (!localFile.isDirectory())
    {
      Log.d("SixGod_PluginSdk", paramString1 + " is not a directory！");
      return false;
    }
    String str = paramString2;
    if (!paramString2.endsWith(File.separator)) {
      str = paramString2 + File.separator;
    }
    paramString2 = new File(str);
    if (!paramString2.exists()) {
      paramString2.mkdirs();
    }
    paramString2 = localFile.listFiles();
    int i = 0;
    boolean bool2 = true;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < paramString2.length)
      {
        if (!paramString2[i].isFile()) {
          break label258;
        }
        bool1 = b(paramString2[i].getAbsolutePath(), str + paramString2[i].getName(), paramBoolean);
        bool2 = bool1;
        if (bool1) {
          break label312;
        }
      }
      label258:
      do
      {
        if (bool1) {
          break label319;
        }
        Log.d("SixGod_PluginSdk", "dir:" + paramString1 + " moved to " + str + " failed！");
        return false;
        if (!paramString2[i].isDirectory()) {
          break;
        }
        bool2 = a(paramString2[i].getAbsolutePath(), str + paramString2[i].getName(), paramBoolean);
        bool1 = bool2;
      } while (!bool2);
      label312:
      i += 1;
    }
    label319:
    a(paramString1);
    Log.d("SixGod_PluginSdk", "dir: " + paramString1 + " moved to" + str + " success！");
    return true;
  }
  
  /* Error */
  public static String b(File paramFile)
  {
    // Byte code:
    //   0: ldc 220
    //   2: invokestatic 226	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   5: astore_1
    //   6: new 12	java/io/FileInputStream
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 16	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   14: astore_2
    //   15: new 228	java/security/DigestInputStream
    //   18: dup
    //   19: aload_2
    //   20: aload_1
    //   21: invokespecial 231	java/security/DigestInputStream:<init>	(Ljava/io/InputStream;Ljava/security/MessageDigest;)V
    //   24: astore_1
    //   25: ldc 232
    //   27: newarray byte
    //   29: astore_0
    //   30: aload_1
    //   31: aload_0
    //   32: invokevirtual 233	java/security/DigestInputStream:read	([B)I
    //   35: ifgt -5 -> 30
    //   38: aload_1
    //   39: invokevirtual 237	java/security/DigestInputStream:getMessageDigest	()Ljava/security/MessageDigest;
    //   42: invokevirtual 241	java/security/MessageDigest:digest	()[B
    //   45: invokestatic 23	com/sixgod/pluginsdk/b/a:a	([B)Ljava/lang/String;
    //   48: astore_0
    //   49: aload_1
    //   50: invokevirtual 242	java/security/DigestInputStream:close	()V
    //   53: aload_2
    //   54: invokevirtual 27	java/io/FileInputStream:close	()V
    //   57: aload_0
    //   58: areturn
    //   59: astore_0
    //   60: aconst_null
    //   61: astore_0
    //   62: aconst_null
    //   63: astore_2
    //   64: aload_0
    //   65: invokevirtual 242	java/security/DigestInputStream:close	()V
    //   68: aload_2
    //   69: invokevirtual 27	java/io/FileInputStream:close	()V
    //   72: aconst_null
    //   73: areturn
    //   74: astore_0
    //   75: aconst_null
    //   76: areturn
    //   77: astore_0
    //   78: aconst_null
    //   79: astore_2
    //   80: aconst_null
    //   81: astore_1
    //   82: aload_1
    //   83: invokevirtual 242	java/security/DigestInputStream:close	()V
    //   86: aload_2
    //   87: invokevirtual 27	java/io/FileInputStream:close	()V
    //   90: aload_0
    //   91: athrow
    //   92: astore_1
    //   93: goto -40 -> 53
    //   96: astore_1
    //   97: aload_0
    //   98: areturn
    //   99: astore_0
    //   100: goto -32 -> 68
    //   103: astore_1
    //   104: goto -18 -> 86
    //   107: astore_1
    //   108: goto -18 -> 90
    //   111: astore_0
    //   112: aconst_null
    //   113: astore_1
    //   114: goto -32 -> 82
    //   117: astore_0
    //   118: goto -36 -> 82
    //   121: astore_0
    //   122: aconst_null
    //   123: astore_0
    //   124: goto -60 -> 64
    //   127: astore_0
    //   128: aload_1
    //   129: astore_0
    //   130: goto -66 -> 64
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	133	0	paramFile	File
    //   5	78	1	localObject1	Object
    //   92	1	1	localException1	Exception
    //   96	1	1	localException2	Exception
    //   103	1	1	localException3	Exception
    //   107	1	1	localException4	Exception
    //   113	16	1	localObject2	Object
    //   14	73	2	localFileInputStream	java.io.FileInputStream
    // Exception table:
    //   from	to	target	type
    //   0	15	59	java/security/NoSuchAlgorithmException
    //   68	72	74	java/lang/Exception
    //   0	15	77	finally
    //   49	53	92	java/lang/Exception
    //   53	57	96	java/lang/Exception
    //   64	68	99	java/lang/Exception
    //   82	86	103	java/lang/Exception
    //   86	90	107	java/lang/Exception
    //   15	25	111	finally
    //   25	30	117	finally
    //   30	49	117	finally
    //   15	25	121	java/security/NoSuchAlgorithmException
    //   25	30	127	java/security/NoSuchAlgorithmException
    //   30	49	127	java/security/NoSuchAlgorithmException
  }
  
  public static boolean b(String paramString)
  {
    boolean bool2 = false;
    paramString = new File(paramString);
    boolean bool1 = bool2;
    if (paramString.isFile())
    {
      bool1 = bool2;
      if (!paramString.exists()) {}
    }
    try
    {
      paramString.delete();
      bool1 = true;
      return bool1;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return false;
  }
  
  /* Error */
  private static boolean b(String paramString1, String paramString2, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: new 33	java/lang/StringBuilder
    //   6: dup
    //   7: ldc 246
    //   9: invokespecial 38	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   12: aload_0
    //   13: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: ldc 248
    //   18: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: aload_1
    //   22: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: invokestatic 252	com/sixgod/pluginsdk/log/SGLog:a	(Ljava/lang/String;)V
    //   31: new 84	java/io/File
    //   34: dup
    //   35: aload_0
    //   36: invokespecial 85	java/io/File:<init>	(Ljava/lang/String;)V
    //   39: astore 4
    //   41: aload 4
    //   43: invokevirtual 113	java/io/File:exists	()Z
    //   46: ifne +10 -> 56
    //   49: ldc 254
    //   51: invokestatic 252	com/sixgod/pluginsdk/log/SGLog:a	(Ljava/lang/String;)V
    //   54: iconst_0
    //   55: ireturn
    //   56: aload 4
    //   58: invokevirtual 151	java/io/File:isFile	()Z
    //   61: ifne +11 -> 72
    //   64: ldc_w 256
    //   67: invokestatic 252	com/sixgod/pluginsdk/log/SGLog:a	(Ljava/lang/String;)V
    //   70: iconst_0
    //   71: ireturn
    //   72: new 84	java/io/File
    //   75: dup
    //   76: aload_1
    //   77: invokespecial 85	java/io/File:<init>	(Ljava/lang/String;)V
    //   80: astore 6
    //   82: aload 6
    //   84: invokevirtual 113	java/io/File:exists	()Z
    //   87: ifeq +213 -> 300
    //   90: iload_2
    //   91: ifeq +181 -> 272
    //   94: ldc_w 258
    //   97: invokestatic 252	com/sixgod/pluginsdk/log/SGLog:a	(Ljava/lang/String;)V
    //   100: aload_1
    //   101: invokestatic 176	com/sixgod/pluginsdk/b/a:a	(Ljava/lang/String;)Z
    //   104: pop
    //   105: new 12	java/io/FileInputStream
    //   108: dup
    //   109: aload 4
    //   111: invokespecial 16	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   114: astore 4
    //   116: new 118	java/io/FileOutputStream
    //   119: dup
    //   120: aload 6
    //   122: invokespecial 119	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   125: astore 6
    //   127: aload 6
    //   129: astore 8
    //   131: aload 4
    //   133: astore 7
    //   135: sipush 1024
    //   138: newarray byte
    //   140: astore 5
    //   142: aload 6
    //   144: astore 8
    //   146: aload 4
    //   148: astore 7
    //   150: aload 4
    //   152: aload 5
    //   154: invokevirtual 259	java/io/FileInputStream:read	([B)I
    //   157: istore_3
    //   158: iload_3
    //   159: iconst_m1
    //   160: if_icmpeq +176 -> 336
    //   163: aload 6
    //   165: astore 8
    //   167: aload 4
    //   169: astore 7
    //   171: aload 6
    //   173: aload 5
    //   175: iconst_0
    //   176: iload_3
    //   177: invokevirtual 260	java/io/FileOutputStream:write	([BII)V
    //   180: goto -38 -> 142
    //   183: astore 7
    //   185: aload 4
    //   187: astore 5
    //   189: aload 6
    //   191: astore 4
    //   193: aload 7
    //   195: astore 6
    //   197: aload 6
    //   199: invokevirtual 261	java/io/FileNotFoundException:printStackTrace	()V
    //   202: aload 5
    //   204: ifnull +8 -> 212
    //   207: aload 5
    //   209: invokevirtual 27	java/io/FileInputStream:close	()V
    //   212: aload 4
    //   214: ifnull +13 -> 227
    //   217: aload 4
    //   219: invokevirtual 262	java/io/FileOutputStream:flush	()V
    //   222: aload 4
    //   224: invokevirtual 263	java/io/FileOutputStream:close	()V
    //   227: aload_0
    //   228: invokestatic 265	com/sixgod/pluginsdk/b/a:b	(Ljava/lang/String;)Z
    //   231: pop
    //   232: ldc 179
    //   234: new 33	java/lang/StringBuilder
    //   237: dup
    //   238: ldc_w 267
    //   241: invokespecial 38	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   244: aload_0
    //   245: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: ldc_w 269
    //   251: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: aload_1
    //   255: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: ldc 208
    //   260: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   266: invokestatic 189	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   269: pop
    //   270: iconst_0
    //   271: ireturn
    //   272: new 33	java/lang/StringBuilder
    //   275: dup
    //   276: ldc_w 271
    //   279: invokespecial 38	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   282: aload_1
    //   283: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: ldc_w 273
    //   289: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   295: invokestatic 252	com/sixgod/pluginsdk/log/SGLog:a	(Ljava/lang/String;)V
    //   298: iconst_0
    //   299: ireturn
    //   300: aload 6
    //   302: invokevirtual 110	java/io/File:getParentFile	()Ljava/io/File;
    //   305: invokevirtual 113	java/io/File:exists	()Z
    //   308: ifne -203 -> 105
    //   311: ldc_w 275
    //   314: invokestatic 252	com/sixgod/pluginsdk/log/SGLog:a	(Ljava/lang/String;)V
    //   317: aload 6
    //   319: invokevirtual 110	java/io/File:getParentFile	()Ljava/io/File;
    //   322: invokevirtual 116	java/io/File:mkdirs	()Z
    //   325: ifne -220 -> 105
    //   328: ldc_w 277
    //   331: invokestatic 252	com/sixgod/pluginsdk/log/SGLog:a	(Ljava/lang/String;)V
    //   334: iconst_0
    //   335: ireturn
    //   336: aload 6
    //   338: astore 8
    //   340: aload 4
    //   342: astore 7
    //   344: new 33	java/lang/StringBuilder
    //   347: dup
    //   348: ldc_w 279
    //   351: invokespecial 38	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   354: aload_0
    //   355: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   358: ldc 206
    //   360: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   363: aload_1
    //   364: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: ldc 216
    //   369: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   372: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   375: invokestatic 252	com/sixgod/pluginsdk/log/SGLog:a	(Ljava/lang/String;)V
    //   378: aload 4
    //   380: invokevirtual 27	java/io/FileInputStream:close	()V
    //   383: aload 6
    //   385: invokevirtual 262	java/io/FileOutputStream:flush	()V
    //   388: aload 6
    //   390: invokevirtual 263	java/io/FileOutputStream:close	()V
    //   393: aload_0
    //   394: invokestatic 265	com/sixgod/pluginsdk/b/a:b	(Ljava/lang/String;)Z
    //   397: pop
    //   398: iconst_1
    //   399: ireturn
    //   400: astore_1
    //   401: aload_1
    //   402: invokevirtual 30	java/io/IOException:printStackTrace	()V
    //   405: goto -22 -> 383
    //   408: astore_1
    //   409: aload_1
    //   410: invokevirtual 30	java/io/IOException:printStackTrace	()V
    //   413: goto -20 -> 393
    //   416: astore 5
    //   418: aload 5
    //   420: invokevirtual 30	java/io/IOException:printStackTrace	()V
    //   423: goto -211 -> 212
    //   426: astore 4
    //   428: aload 4
    //   430: invokevirtual 30	java/io/IOException:printStackTrace	()V
    //   433: goto -206 -> 227
    //   436: astore 9
    //   438: aconst_null
    //   439: astore 5
    //   441: aconst_null
    //   442: astore 4
    //   444: aload 5
    //   446: astore 8
    //   448: aload 4
    //   450: astore 7
    //   452: aload 9
    //   454: invokevirtual 30	java/io/IOException:printStackTrace	()V
    //   457: aload 4
    //   459: ifnull +8 -> 467
    //   462: aload 4
    //   464: invokevirtual 27	java/io/FileInputStream:close	()V
    //   467: aload 5
    //   469: ifnull +13 -> 482
    //   472: aload 5
    //   474: invokevirtual 262	java/io/FileOutputStream:flush	()V
    //   477: aload 5
    //   479: invokevirtual 263	java/io/FileOutputStream:close	()V
    //   482: aload_0
    //   483: invokestatic 265	com/sixgod/pluginsdk/b/a:b	(Ljava/lang/String;)Z
    //   486: pop
    //   487: goto -255 -> 232
    //   490: astore 4
    //   492: aload 4
    //   494: invokevirtual 30	java/io/IOException:printStackTrace	()V
    //   497: goto -30 -> 467
    //   500: astore 4
    //   502: aload 4
    //   504: invokevirtual 30	java/io/IOException:printStackTrace	()V
    //   507: goto -25 -> 482
    //   510: astore_1
    //   511: aconst_null
    //   512: astore 5
    //   514: aconst_null
    //   515: astore 4
    //   517: aload 4
    //   519: ifnull +8 -> 527
    //   522: aload 4
    //   524: invokevirtual 27	java/io/FileInputStream:close	()V
    //   527: aload 5
    //   529: ifnull +13 -> 542
    //   532: aload 5
    //   534: invokevirtual 262	java/io/FileOutputStream:flush	()V
    //   537: aload 5
    //   539: invokevirtual 263	java/io/FileOutputStream:close	()V
    //   542: aload_0
    //   543: invokestatic 265	com/sixgod/pluginsdk/b/a:b	(Ljava/lang/String;)Z
    //   546: pop
    //   547: aload_1
    //   548: athrow
    //   549: astore 4
    //   551: aload 4
    //   553: invokevirtual 30	java/io/IOException:printStackTrace	()V
    //   556: goto -29 -> 527
    //   559: astore 4
    //   561: aload 4
    //   563: invokevirtual 30	java/io/IOException:printStackTrace	()V
    //   566: goto -24 -> 542
    //   569: astore_1
    //   570: aconst_null
    //   571: astore 5
    //   573: goto -56 -> 517
    //   576: astore_1
    //   577: aload 8
    //   579: astore 5
    //   581: aload 7
    //   583: astore 4
    //   585: goto -68 -> 517
    //   588: astore_1
    //   589: aload 5
    //   591: astore 6
    //   593: aload 4
    //   595: astore 5
    //   597: aload 6
    //   599: astore 4
    //   601: goto -84 -> 517
    //   604: astore 9
    //   606: aconst_null
    //   607: astore 5
    //   609: goto -165 -> 444
    //   612: astore 9
    //   614: aload 6
    //   616: astore 5
    //   618: goto -174 -> 444
    //   621: astore 6
    //   623: aconst_null
    //   624: astore 4
    //   626: goto -429 -> 197
    //   629: astore 6
    //   631: aconst_null
    //   632: astore 7
    //   634: aload 4
    //   636: astore 5
    //   638: aload 7
    //   640: astore 4
    //   642: goto -445 -> 197
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	645	0	paramString1	String
    //   0	645	1	paramString2	String
    //   0	645	2	paramBoolean	boolean
    //   157	20	3	i	int
    //   39	340	4	localObject1	Object
    //   426	3	4	localIOException1	java.io.IOException
    //   442	21	4	localObject2	Object
    //   490	3	4	localIOException2	java.io.IOException
    //   500	3	4	localIOException3	java.io.IOException
    //   515	8	4	localObject3	Object
    //   549	3	4	localIOException4	java.io.IOException
    //   559	3	4	localIOException5	java.io.IOException
    //   583	58	4	localObject4	Object
    //   1	207	5	localObject5	Object
    //   416	3	5	localIOException6	java.io.IOException
    //   439	198	5	localObject6	Object
    //   80	535	6	localObject7	Object
    //   621	1	6	localFileNotFoundException1	java.io.FileNotFoundException
    //   629	1	6	localFileNotFoundException2	java.io.FileNotFoundException
    //   133	37	7	localObject8	Object
    //   183	11	7	localFileNotFoundException3	java.io.FileNotFoundException
    //   342	297	7	localObject9	Object
    //   129	449	8	localObject10	Object
    //   436	17	9	localIOException7	java.io.IOException
    //   604	1	9	localIOException8	java.io.IOException
    //   612	1	9	localIOException9	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   135	142	183	java/io/FileNotFoundException
    //   150	158	183	java/io/FileNotFoundException
    //   171	180	183	java/io/FileNotFoundException
    //   344	378	183	java/io/FileNotFoundException
    //   378	383	400	java/io/IOException
    //   383	393	408	java/io/IOException
    //   207	212	416	java/io/IOException
    //   217	227	426	java/io/IOException
    //   105	116	436	java/io/IOException
    //   462	467	490	java/io/IOException
    //   472	482	500	java/io/IOException
    //   105	116	510	finally
    //   522	527	549	java/io/IOException
    //   532	542	559	java/io/IOException
    //   116	127	569	finally
    //   135	142	576	finally
    //   150	158	576	finally
    //   171	180	576	finally
    //   344	378	576	finally
    //   452	457	576	finally
    //   197	202	588	finally
    //   116	127	604	java/io/IOException
    //   135	142	612	java/io/IOException
    //   150	158	612	java/io/IOException
    //   171	180	612	java/io/IOException
    //   344	378	612	java/io/IOException
    //   105	116	621	java/io/FileNotFoundException
    //   116	127	629	java/io/FileNotFoundException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.sixgod.pluginsdk.b.a
 * JD-Core Version:    0.7.0.1
 */