package com.tencent.falco.utils;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.io.PrintStream;

public final class FileUtil
{
  private static final int BUFFER = 8192;
  
  public static String convertHashToString(byte[] paramArrayOfByte)
  {
    String str = "";
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(Integer.toString((paramArrayOfByte[i] & 0xFF) + 256, 16).substring(1));
      str = localStringBuilder.toString();
      i += 1;
    }
    return str.toLowerCase();
  }
  
  /* Error */
  public static boolean copyDir(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: new 47	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 50	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: invokevirtual 54	java/io/File:mkdirs	()Z
    //   11: pop
    //   12: new 47	java/io/File
    //   15: dup
    //   16: aload_0
    //   17: invokespecial 50	java/io/File:<init>	(Ljava/lang/String;)V
    //   20: invokevirtual 58	java/io/File:list	()[Ljava/lang/String;
    //   23: astore 9
    //   25: iconst_0
    //   26: istore_2
    //   27: iload_2
    //   28: aload 9
    //   30: arraylength
    //   31: if_icmpge +345 -> 376
    //   34: aload_0
    //   35: getstatic 62	java/io/File:separator	Ljava/lang/String;
    //   38: invokevirtual 66	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   41: ifeq +46 -> 87
    //   44: new 18	java/lang/StringBuilder
    //   47: dup
    //   48: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   51: astore 5
    //   53: aload 5
    //   55: aload_0
    //   56: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: pop
    //   60: aload 5
    //   62: aload 9
    //   64: iload_2
    //   65: aaload
    //   66: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: pop
    //   70: new 47	java/io/File
    //   73: dup
    //   74: aload 5
    //   76: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   79: invokespecial 50	java/io/File:<init>	(Ljava/lang/String;)V
    //   82: astore 5
    //   84: goto +52 -> 136
    //   87: new 18	java/lang/StringBuilder
    //   90: dup
    //   91: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   94: astore 5
    //   96: aload 5
    //   98: aload_0
    //   99: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: pop
    //   103: aload 5
    //   105: getstatic 62	java/io/File:separator	Ljava/lang/String;
    //   108: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: pop
    //   112: aload 5
    //   114: aload 9
    //   116: iload_2
    //   117: aaload
    //   118: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: pop
    //   122: new 47	java/io/File
    //   125: dup
    //   126: aload 5
    //   128: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   131: invokespecial 50	java/io/File:<init>	(Ljava/lang/String;)V
    //   134: astore 5
    //   136: aload 5
    //   138: invokevirtual 69	java/io/File:isFile	()Z
    //   141: istore 4
    //   143: iload 4
    //   145: ifeq +130 -> 275
    //   148: aconst_null
    //   149: astore 7
    //   151: new 71	java/io/FileInputStream
    //   154: dup
    //   155: aload 5
    //   157: invokespecial 74	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   160: astore 6
    //   162: new 18	java/lang/StringBuilder
    //   165: dup
    //   166: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   169: astore 8
    //   171: aload 8
    //   173: aload_1
    //   174: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: pop
    //   178: aload 8
    //   180: ldc 76
    //   182: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: pop
    //   186: aload 8
    //   188: aload 5
    //   190: invokevirtual 79	java/io/File:getName	()Ljava/lang/String;
    //   193: invokevirtual 80	java/lang/String:toString	()Ljava/lang/String;
    //   196: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: pop
    //   200: new 82	java/io/FileOutputStream
    //   203: dup
    //   204: aload 8
    //   206: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   209: invokespecial 83	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   212: astore 8
    //   214: sipush 5120
    //   217: newarray byte
    //   219: astore 7
    //   221: aload 6
    //   223: aload 7
    //   225: invokevirtual 87	java/io/FileInputStream:read	([B)I
    //   228: istore_3
    //   229: iload_3
    //   230: iconst_m1
    //   231: if_icmpeq +15 -> 246
    //   234: aload 8
    //   236: aload 7
    //   238: iconst_0
    //   239: iload_3
    //   240: invokevirtual 91	java/io/FileOutputStream:write	([BII)V
    //   243: goto -22 -> 221
    //   246: aload 8
    //   248: invokevirtual 94	java/io/FileOutputStream:flush	()V
    //   251: aload 6
    //   253: invokestatic 100	com/tencent/falco/utils/IOUtil:close	(Ljava/io/Closeable;)V
    //   256: aload 8
    //   258: invokestatic 100	com/tencent/falco/utils/IOUtil:close	(Ljava/io/Closeable;)V
    //   261: goto +14 -> 275
    //   264: aload 5
    //   266: invokestatic 100	com/tencent/falco/utils/IOUtil:close	(Ljava/io/Closeable;)V
    //   269: aload_1
    //   270: invokestatic 100	com/tencent/falco/utils/IOUtil:close	(Ljava/io/Closeable;)V
    //   273: aload_0
    //   274: athrow
    //   275: aload 5
    //   277: invokevirtual 103	java/io/File:isDirectory	()Z
    //   280: ifeq +89 -> 369
    //   283: new 18	java/lang/StringBuilder
    //   286: dup
    //   287: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   290: astore 5
    //   292: aload 5
    //   294: aload_0
    //   295: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: pop
    //   299: aload 5
    //   301: ldc 76
    //   303: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: pop
    //   307: aload 5
    //   309: aload 9
    //   311: iload_2
    //   312: aaload
    //   313: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: pop
    //   317: aload 5
    //   319: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   322: astore 5
    //   324: new 18	java/lang/StringBuilder
    //   327: dup
    //   328: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   331: astore 6
    //   333: aload 6
    //   335: aload_1
    //   336: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   339: pop
    //   340: aload 6
    //   342: ldc 76
    //   344: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   347: pop
    //   348: aload 6
    //   350: aload 9
    //   352: iload_2
    //   353: aaload
    //   354: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   357: pop
    //   358: aload 5
    //   360: aload 6
    //   362: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   365: invokestatic 105	com/tencent/falco/utils/FileUtil:copyDir	(Ljava/lang/String;Ljava/lang/String;)Z
    //   368: pop
    //   369: iload_2
    //   370: iconst_1
    //   371: iadd
    //   372: istore_2
    //   373: goto -346 -> 27
    //   376: iconst_1
    //   377: ireturn
    //   378: astore_0
    //   379: iconst_0
    //   380: ireturn
    //   381: astore_0
    //   382: aload 8
    //   384: astore_1
    //   385: aload 6
    //   387: astore 5
    //   389: goto -125 -> 264
    //   392: astore_0
    //   393: aload 7
    //   395: astore_1
    //   396: aload 6
    //   398: astore 5
    //   400: goto -136 -> 264
    //   403: astore_0
    //   404: aconst_null
    //   405: astore 5
    //   407: aload 7
    //   409: astore_1
    //   410: goto -146 -> 264
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	413	0	paramString1	String
    //   0	413	1	paramString2	String
    //   26	347	2	i	int
    //   228	12	3	j	int
    //   141	3	4	bool	boolean
    //   51	355	5	localObject1	Object
    //   160	237	6	localObject2	Object
    //   149	259	7	arrayOfByte	byte[]
    //   169	214	8	localObject3	Object
    //   23	328	9	arrayOfString	String[]
    // Exception table:
    //   from	to	target	type
    //   0	25	378	java/lang/Exception
    //   27	84	378	java/lang/Exception
    //   87	136	378	java/lang/Exception
    //   136	143	378	java/lang/Exception
    //   251	261	378	java/lang/Exception
    //   264	275	378	java/lang/Exception
    //   275	369	378	java/lang/Exception
    //   214	221	381	finally
    //   221	229	381	finally
    //   234	243	381	finally
    //   246	251	381	finally
    //   162	214	392	finally
    //   151	162	403	finally
  }
  
  /* Error */
  public static boolean copyFile(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: new 47	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 50	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore 5
    //   10: aload 5
    //   12: invokevirtual 110	java/io/File:getParentFile	()Ljava/io/File;
    //   15: invokevirtual 113	java/io/File:exists	()Z
    //   18: ifne +26 -> 44
    //   21: aload 5
    //   23: invokevirtual 110	java/io/File:getParentFile	()Ljava/io/File;
    //   26: invokevirtual 54	java/io/File:mkdirs	()Z
    //   29: pop
    //   30: aload 5
    //   32: invokevirtual 113	java/io/File:exists	()Z
    //   35: ifeq +9 -> 44
    //   38: aload 5
    //   40: invokevirtual 116	java/io/File:delete	()Z
    //   43: pop
    //   44: new 47	java/io/File
    //   47: dup
    //   48: aload_0
    //   49: invokespecial 50	java/io/File:<init>	(Ljava/lang/String;)V
    //   52: invokevirtual 113	java/io/File:exists	()Z
    //   55: istore_3
    //   56: iload_3
    //   57: ifeq +85 -> 142
    //   60: aconst_null
    //   61: astore 4
    //   63: new 71	java/io/FileInputStream
    //   66: dup
    //   67: aload_0
    //   68: invokespecial 117	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   71: astore_1
    //   72: new 82	java/io/FileOutputStream
    //   75: dup
    //   76: aload 5
    //   78: invokespecial 118	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   81: astore_0
    //   82: sipush 1024
    //   85: newarray byte
    //   87: astore 4
    //   89: aload_1
    //   90: aload 4
    //   92: invokevirtual 121	java/io/InputStream:read	([B)I
    //   95: istore_2
    //   96: iload_2
    //   97: iconst_m1
    //   98: if_icmpeq +14 -> 112
    //   101: aload_0
    //   102: aload 4
    //   104: iconst_0
    //   105: iload_2
    //   106: invokevirtual 91	java/io/FileOutputStream:write	([BII)V
    //   109: goto -20 -> 89
    //   112: aload_0
    //   113: invokevirtual 94	java/io/FileOutputStream:flush	()V
    //   116: aload_1
    //   117: invokestatic 100	com/tencent/falco/utils/IOUtil:close	(Ljava/io/Closeable;)V
    //   120: aload_0
    //   121: invokestatic 100	com/tencent/falco/utils/IOUtil:close	(Ljava/io/Closeable;)V
    //   124: iconst_1
    //   125: ireturn
    //   126: aload_1
    //   127: invokestatic 100	com/tencent/falco/utils/IOUtil:close	(Ljava/io/Closeable;)V
    //   130: aload 4
    //   132: invokestatic 100	com/tencent/falco/utils/IOUtil:close	(Ljava/io/Closeable;)V
    //   135: aload_0
    //   136: athrow
    //   137: astore_0
    //   138: aload_0
    //   139: invokevirtual 124	java/lang/Exception:printStackTrace	()V
    //   142: iconst_0
    //   143: ireturn
    //   144: astore 5
    //   146: aload_0
    //   147: astore 4
    //   149: aload 5
    //   151: astore_0
    //   152: goto -26 -> 126
    //   155: astore_0
    //   156: goto -30 -> 126
    //   159: astore_0
    //   160: aconst_null
    //   161: astore_1
    //   162: goto -36 -> 126
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	165	0	paramString1	String
    //   0	165	1	paramString2	String
    //   95	11	2	i	int
    //   55	2	3	bool	boolean
    //   61	87	4	localObject1	Object
    //   8	69	5	localFile	File
    //   144	6	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   0	44	137	java/lang/Exception
    //   44	56	137	java/lang/Exception
    //   116	124	137	java/lang/Exception
    //   126	137	137	java/lang/Exception
    //   82	89	144	finally
    //   89	96	144	finally
    //   101	109	144	finally
    //   112	116	144	finally
    //   72	82	155	finally
    //   63	72	159	finally
  }
  
  public static boolean createDir(String paramString)
  {
    return new File(paramString).mkdirs();
  }
  
  public static void createFile(String paramString)
  {
    paramString = new File(paramString);
    if (!paramString.exists())
    {
      File localFile = paramString.getParentFile();
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
      paramString.createNewFile();
    }
  }
  
  public static boolean deleteDirectory(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    int i = 0;
    if (bool) {
      return false;
    }
    Object localObject = paramString;
    if (!paramString.endsWith(File.separator))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(File.separator);
      localObject = ((StringBuilder)localObject).toString();
    }
    paramString = new File((String)localObject);
    if (paramString.exists())
    {
      if (!paramString.isDirectory()) {
        return false;
      }
      localObject = paramString.listFiles();
      if (localObject == null) {
        return false;
      }
      while (i < localObject.length)
      {
        if (localObject[i] != null) {
          if (localObject[i].isFile())
          {
            deleteFile(localObject[i].getAbsolutePath());
            PrintStream localPrintStream = System.out;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(localObject[i].getAbsolutePath());
            localStringBuilder.append(" delete suc");
            localPrintStream.println(localStringBuilder.toString());
          }
          else
          {
            deleteDirectory(localObject[i].getAbsolutePath());
          }
        }
        i += 1;
      }
      paramString.delete();
      return true;
    }
    return false;
  }
  
  public static boolean deleteFile(String paramString)
  {
    paramString = new File(paramString);
    if ((paramString.isFile()) && (paramString.exists())) {
      try
      {
        paramString.delete();
        return true;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
    }
    return false;
  }
  
  public static boolean exists(String paramString)
  {
    return new File(paramString).exists();
  }
  
  public static String getCacheDir(Context paramContext)
  {
    return paramContext.getCacheDir().getAbsolutePath();
  }
  
  public static String getDir(Context paramContext)
  {
    return paramContext.getDir(null, 0).getAbsolutePath();
  }
  
  public static String getExternalCacheDir(Context paramContext)
  {
    return paramContext.getExternalCacheDir().getAbsolutePath();
  }
  
  /* Error */
  public static String getFileSHA1(String paramString)
  {
    // Byte code:
    //   0: new 71	java/io/FileInputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 117	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   8: astore_0
    //   9: sipush 1024
    //   12: newarray byte
    //   14: astore_3
    //   15: ldc 178
    //   17: invokestatic 184	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   20: astore 4
    //   22: iconst_0
    //   23: istore_1
    //   24: iload_1
    //   25: iconst_m1
    //   26: if_icmpeq +28 -> 54
    //   29: aload_0
    //   30: aload_3
    //   31: invokevirtual 121	java/io/InputStream:read	([B)I
    //   34: istore_2
    //   35: iload_2
    //   36: istore_1
    //   37: iload_2
    //   38: ifle -14 -> 24
    //   41: aload 4
    //   43: aload_3
    //   44: iconst_0
    //   45: iload_2
    //   46: invokevirtual 187	java/security/MessageDigest:update	([BII)V
    //   49: iload_2
    //   50: istore_1
    //   51: goto -27 -> 24
    //   54: aload 4
    //   56: invokevirtual 191	java/security/MessageDigest:digest	()[B
    //   59: invokestatic 193	com/tencent/falco/utils/FileUtil:convertHashToString	([B)Ljava/lang/String;
    //   62: astore_3
    //   63: aload_0
    //   64: invokevirtual 195	java/io/InputStream:close	()V
    //   67: aload_3
    //   68: areturn
    //   69: astore 4
    //   71: aload_0
    //   72: astore_3
    //   73: aload 4
    //   75: astore_0
    //   76: goto +9 -> 85
    //   79: goto +18 -> 97
    //   82: astore_0
    //   83: aconst_null
    //   84: astore_3
    //   85: aload_3
    //   86: ifnull +7 -> 93
    //   89: aload_3
    //   90: invokevirtual 195	java/io/InputStream:close	()V
    //   93: aload_0
    //   94: athrow
    //   95: aconst_null
    //   96: astore_0
    //   97: aload_0
    //   98: ifnull +7 -> 105
    //   101: aload_0
    //   102: invokevirtual 195	java/io/InputStream:close	()V
    //   105: aconst_null
    //   106: areturn
    //   107: astore_0
    //   108: goto -13 -> 95
    //   111: astore_3
    //   112: goto -33 -> 79
    //   115: astore_0
    //   116: aload_3
    //   117: areturn
    //   118: astore_3
    //   119: goto -26 -> 93
    //   122: astore_0
    //   123: aconst_null
    //   124: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	125	0	paramString	String
    //   23	28	1	i	int
    //   34	16	2	j	int
    //   14	76	3	localObject1	Object
    //   111	6	3	localException1	Exception
    //   118	1	3	localException2	Exception
    //   20	35	4	localMessageDigest	java.security.MessageDigest
    //   69	5	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   9	22	69	finally
    //   29	35	69	finally
    //   41	49	69	finally
    //   54	63	69	finally
    //   0	9	82	finally
    //   0	9	107	java/lang/Exception
    //   9	22	111	java/lang/Exception
    //   29	35	111	java/lang/Exception
    //   41	49	111	java/lang/Exception
    //   54	63	111	java/lang/Exception
    //   63	67	115	java/lang/Exception
    //   89	93	118	java/lang/Exception
    //   101	105	122	java/lang/Exception
  }
  
  public static String getFilesDir(Context paramContext)
  {
    return paramContext.getFilesDir().getAbsolutePath();
  }
  
  public static boolean moveFile(String paramString1, String paramString2)
  {
    paramString1 = new File(paramString1);
    if ((paramString1.exists()) && (paramString1.isFile())) {
      return paramString1.renameTo(new File(paramString2));
    }
    return false;
  }
  
  /* Error */
  public static String readString(String paramString)
  {
    // Byte code:
    //   0: new 18	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   7: astore_1
    //   8: aconst_null
    //   9: astore_2
    //   10: aconst_null
    //   11: astore_3
    //   12: new 71	java/io/FileInputStream
    //   15: dup
    //   16: aload_0
    //   17: invokespecial 117	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   20: astore_0
    //   21: new 206	java/io/BufferedReader
    //   24: dup
    //   25: new 208	java/io/InputStreamReader
    //   28: dup
    //   29: aload_0
    //   30: invokespecial 211	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   33: invokespecial 214	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   36: astore_3
    //   37: aload_3
    //   38: invokevirtual 217	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   41: astore_2
    //   42: aload_2
    //   43: ifnull +12 -> 55
    //   46: aload_1
    //   47: aload_2
    //   48: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: pop
    //   52: goto -15 -> 37
    //   55: aload_1
    //   56: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   59: astore_1
    //   60: aload_0
    //   61: invokestatic 100	com/tencent/falco/utils/IOUtil:close	(Ljava/io/Closeable;)V
    //   64: aload_3
    //   65: invokestatic 100	com/tencent/falco/utils/IOUtil:close	(Ljava/io/Closeable;)V
    //   68: aload_1
    //   69: areturn
    //   70: astore_1
    //   71: aload_3
    //   72: astore_2
    //   73: goto +50 -> 123
    //   76: astore_2
    //   77: aload_3
    //   78: astore_1
    //   79: goto +10 -> 89
    //   82: astore_1
    //   83: goto +40 -> 123
    //   86: astore_2
    //   87: aconst_null
    //   88: astore_1
    //   89: goto +14 -> 103
    //   92: astore_1
    //   93: aconst_null
    //   94: astore_0
    //   95: goto +28 -> 123
    //   98: astore_2
    //   99: aconst_null
    //   100: astore_1
    //   101: aload_3
    //   102: astore_0
    //   103: aload_2
    //   104: invokevirtual 124	java/lang/Exception:printStackTrace	()V
    //   107: aload_0
    //   108: invokestatic 100	com/tencent/falco/utils/IOUtil:close	(Ljava/io/Closeable;)V
    //   111: aload_1
    //   112: invokestatic 100	com/tencent/falco/utils/IOUtil:close	(Ljava/io/Closeable;)V
    //   115: ldc 16
    //   117: areturn
    //   118: astore_3
    //   119: aload_1
    //   120: astore_2
    //   121: aload_3
    //   122: astore_1
    //   123: aload_0
    //   124: invokestatic 100	com/tencent/falco/utils/IOUtil:close	(Ljava/io/Closeable;)V
    //   127: aload_2
    //   128: invokestatic 100	com/tencent/falco/utils/IOUtil:close	(Ljava/io/Closeable;)V
    //   131: goto +5 -> 136
    //   134: aload_1
    //   135: athrow
    //   136: goto -2 -> 134
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	139	0	paramString	String
    //   7	62	1	localObject1	Object
    //   70	1	1	localObject2	Object
    //   78	1	1	localObject3	Object
    //   82	1	1	localObject4	Object
    //   88	1	1	localObject5	Object
    //   92	1	1	localObject6	Object
    //   100	35	1	localObject7	Object
    //   9	64	2	localObject8	Object
    //   76	1	2	localException1	Exception
    //   86	1	2	localException2	Exception
    //   98	6	2	localException3	Exception
    //   120	8	2	localObject9	Object
    //   11	91	3	localBufferedReader	java.io.BufferedReader
    //   118	4	3	localObject10	Object
    // Exception table:
    //   from	to	target	type
    //   37	42	70	finally
    //   46	52	70	finally
    //   55	60	70	finally
    //   37	42	76	java/lang/Exception
    //   46	52	76	java/lang/Exception
    //   55	60	76	java/lang/Exception
    //   21	37	82	finally
    //   21	37	86	java/lang/Exception
    //   12	21	92	finally
    //   12	21	98	java/lang/Exception
    //   103	107	118	finally
  }
  
  /* Error */
  public static void writeString(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore_3
    //   4: new 47	java/io/File
    //   7: dup
    //   8: aload_0
    //   9: invokespecial 50	java/io/File:<init>	(Ljava/lang/String;)V
    //   12: astore 4
    //   14: new 47	java/io/File
    //   17: dup
    //   18: aload 4
    //   20: invokevirtual 222	java/io/File:getParent	()Ljava/lang/String;
    //   23: invokespecial 50	java/io/File:<init>	(Ljava/lang/String;)V
    //   26: invokevirtual 113	java/io/File:exists	()Z
    //   29: ifne +19 -> 48
    //   32: new 47	java/io/File
    //   35: dup
    //   36: aload 4
    //   38: invokevirtual 222	java/io/File:getParent	()Ljava/lang/String;
    //   41: invokespecial 50	java/io/File:<init>	(Ljava/lang/String;)V
    //   44: invokevirtual 54	java/io/File:mkdirs	()Z
    //   47: pop
    //   48: aload 4
    //   50: invokevirtual 113	java/io/File:exists	()Z
    //   53: ifne +9 -> 62
    //   56: aload 4
    //   58: invokevirtual 129	java/io/File:createNewFile	()Z
    //   61: pop
    //   62: new 82	java/io/FileOutputStream
    //   65: dup
    //   66: aload_0
    //   67: invokespecial 83	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   70: astore_0
    //   71: new 224	java/io/BufferedWriter
    //   74: dup
    //   75: new 226	java/io/OutputStreamWriter
    //   78: dup
    //   79: aload_0
    //   80: invokespecial 229	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;)V
    //   83: invokespecial 232	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   86: astore_2
    //   87: aload_2
    //   88: aload_1
    //   89: iconst_0
    //   90: aload_1
    //   91: invokevirtual 236	java/lang/String:length	()I
    //   94: invokevirtual 239	java/io/BufferedWriter:write	(Ljava/lang/String;II)V
    //   97: aload_2
    //   98: invokevirtual 240	java/io/BufferedWriter:flush	()V
    //   101: aload_0
    //   102: invokestatic 100	com/tencent/falco/utils/IOUtil:close	(Ljava/io/Closeable;)V
    //   105: aload_2
    //   106: invokestatic 100	com/tencent/falco/utils/IOUtil:close	(Ljava/io/Closeable;)V
    //   109: return
    //   110: astore_1
    //   111: goto +56 -> 167
    //   114: astore_3
    //   115: aload_2
    //   116: astore_1
    //   117: aload_3
    //   118: astore_2
    //   119: goto +30 -> 149
    //   122: astore_1
    //   123: aconst_null
    //   124: astore_2
    //   125: goto +42 -> 167
    //   128: astore_2
    //   129: aconst_null
    //   130: astore_1
    //   131: goto +18 -> 149
    //   134: astore_1
    //   135: aconst_null
    //   136: astore_3
    //   137: aload_2
    //   138: astore_0
    //   139: aload_3
    //   140: astore_2
    //   141: goto +26 -> 167
    //   144: astore_2
    //   145: aconst_null
    //   146: astore_1
    //   147: aload_3
    //   148: astore_0
    //   149: aload_2
    //   150: invokevirtual 124	java/lang/Exception:printStackTrace	()V
    //   153: aload_0
    //   154: invokestatic 100	com/tencent/falco/utils/IOUtil:close	(Ljava/io/Closeable;)V
    //   157: aload_1
    //   158: invokestatic 100	com/tencent/falco/utils/IOUtil:close	(Ljava/io/Closeable;)V
    //   161: return
    //   162: astore_3
    //   163: aload_1
    //   164: astore_2
    //   165: aload_3
    //   166: astore_1
    //   167: aload_0
    //   168: invokestatic 100	com/tencent/falco/utils/IOUtil:close	(Ljava/io/Closeable;)V
    //   171: aload_2
    //   172: invokestatic 100	com/tencent/falco/utils/IOUtil:close	(Ljava/io/Closeable;)V
    //   175: aload_1
    //   176: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	177	0	paramString1	String
    //   0	177	1	paramString2	String
    //   1	124	2	localObject1	Object
    //   128	10	2	localException1	Exception
    //   140	1	2	localObject2	Object
    //   144	6	2	localException2	Exception
    //   164	8	2	str	String
    //   3	1	3	localObject3	Object
    //   114	4	3	localException3	Exception
    //   136	12	3	localObject4	Object
    //   162	4	3	localObject5	Object
    //   12	45	4	localFile	File
    // Exception table:
    //   from	to	target	type
    //   87	101	110	finally
    //   87	101	114	java/lang/Exception
    //   71	87	122	finally
    //   71	87	128	java/lang/Exception
    //   4	48	134	finally
    //   48	62	134	finally
    //   62	71	134	finally
    //   4	48	144	java/lang/Exception
    //   48	62	144	java/lang/Exception
    //   62	71	144	java/lang/Exception
    //   149	153	162	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.falco.utils.FileUtil
 * JD-Core Version:    0.7.0.1
 */