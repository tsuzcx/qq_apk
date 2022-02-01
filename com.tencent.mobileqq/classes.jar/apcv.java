import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.soload.SoLoadUtilNew;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;

public abstract class apcv
{
  /* Error */
  public static byte a(int paramInt, String arg1)
  {
    // Byte code:
    //   0: iconst_4
    //   1: istore_3
    //   2: iload_0
    //   3: iconst_1
    //   4: invokestatic 11	apcv:a	(IZ)V
    //   7: aload_1
    //   8: iload_0
    //   9: invokestatic 14	apcv:a	(I)Ljava/lang/String;
    //   12: invokestatic 17	apcv:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   15: new 19	java/util/HashMap
    //   18: dup
    //   19: invokespecial 23	java/util/HashMap:<init>	()V
    //   22: astore 6
    //   24: getstatic 29	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   27: ldc 31
    //   29: iconst_4
    //   30: invokevirtual 35	com/tencent/common/app/BaseApplicationImpl:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   33: invokeinterface 41 1 0
    //   38: astore 5
    //   40: new 43	java/io/File
    //   43: dup
    //   44: new 45	java/lang/StringBuilder
    //   47: dup
    //   48: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   51: iload_0
    //   52: invokestatic 14	apcv:a	(I)Ljava/lang/String;
    //   55: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: ldc 52
    //   60: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   66: invokespecial 59	java/io/File:<init>	(Ljava/lang/String;)V
    //   69: astore 4
    //   71: aload 4
    //   73: invokevirtual 63	java/io/File:exists	()Z
    //   76: ifeq +369 -> 445
    //   79: aconst_null
    //   80: astore_1
    //   81: aload 4
    //   83: invokestatic 69	bgmg:b	(Ljava/io/File;)Ljava/lang/String;
    //   86: astore 4
    //   88: aload 4
    //   90: astore_1
    //   91: aload_1
    //   92: ifnull +332 -> 424
    //   95: iload_0
    //   96: aload_1
    //   97: aload 6
    //   99: invokestatic 72	apcv:a	(ILjava/lang/String;Ljava/util/HashMap;)Z
    //   102: ifeq +322 -> 424
    //   105: iload_0
    //   106: invokestatic 75	apcv:a	(I)Ljava/lang/Object;
    //   109: astore_1
    //   110: aload_1
    //   111: monitorenter
    //   112: aload 6
    //   114: invokevirtual 79	java/util/HashMap:entrySet	()Ljava/util/Set;
    //   117: invokeinterface 85 1 0
    //   122: astore 4
    //   124: aload 4
    //   126: invokeinterface 90 1 0
    //   131: ifeq +333 -> 464
    //   134: aload 4
    //   136: invokeinterface 94 1 0
    //   141: checkcast 96	java/util/Map$Entry
    //   144: astore 6
    //   146: iload_0
    //   147: aload 6
    //   149: invokeinterface 99 1 0
    //   154: checkcast 101	java/lang/String
    //   157: invokestatic 105	apcv:c	(ILjava/lang/String;)Ljava/lang/String;
    //   160: astore 7
    //   162: new 45	java/lang/StringBuilder
    //   165: dup
    //   166: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   169: iload_0
    //   170: invokestatic 14	apcv:a	(I)Ljava/lang/String;
    //   173: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: getstatic 109	java/io/File:separator	Ljava/lang/String;
    //   179: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: aload 7
    //   184: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   190: astore 9
    //   192: new 43	java/io/File
    //   195: dup
    //   196: aload 9
    //   198: invokespecial 59	java/io/File:<init>	(Ljava/lang/String;)V
    //   201: astore 8
    //   203: aload 8
    //   205: invokevirtual 63	java/io/File:exists	()Z
    //   208: ifeq +211 -> 419
    //   211: aload 9
    //   213: invokestatic 114	azby:a	(Ljava/lang/String;)Ljava/lang/String;
    //   216: astore 9
    //   218: aload 6
    //   220: invokeinterface 117 1 0
    //   225: checkcast 101	java/lang/String
    //   228: aload 9
    //   230: invokevirtual 121	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   233: ifne +88 -> 321
    //   236: aload 8
    //   238: invokevirtual 124	java/io/File:delete	()Z
    //   241: pop
    //   242: iconst_2
    //   243: istore_2
    //   244: aload 5
    //   246: invokeinterface 129 1 0
    //   251: pop
    //   252: aload_1
    //   253: monitorexit
    //   254: iload_0
    //   255: iconst_0
    //   256: invokestatic 11	apcv:a	(IZ)V
    //   259: iload_2
    //   260: ireturn
    //   261: astore_1
    //   262: iload_0
    //   263: iconst_0
    //   264: invokestatic 11	apcv:a	(IZ)V
    //   267: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   270: ifeq +31 -> 301
    //   273: ldc 136
    //   275: iconst_2
    //   276: new 45	java/lang/StringBuilder
    //   279: dup
    //   280: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   283: ldc 138
    //   285: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: aload_1
    //   289: invokevirtual 141	java/io/IOException:getMessage	()Ljava/lang/String;
    //   292: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   298: invokestatic 145	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   301: iload_0
    //   302: invokestatic 14	apcv:a	(I)Ljava/lang/String;
    //   305: iconst_0
    //   306: invokestatic 148	bgmg:a	(Ljava/lang/String;Z)V
    //   309: iconst_m1
    //   310: ireturn
    //   311: astore 4
    //   313: aload 4
    //   315: invokevirtual 151	java/io/IOException:printStackTrace	()V
    //   318: goto -227 -> 91
    //   321: aload 5
    //   323: new 45	java/lang/StringBuilder
    //   326: dup
    //   327: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   330: ldc 153
    //   332: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: aload 7
    //   337: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   343: aload 6
    //   345: invokeinterface 117 1 0
    //   350: checkcast 101	java/lang/String
    //   353: invokeinterface 157 3 0
    //   358: pop
    //   359: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   362: ifeq -238 -> 124
    //   365: ldc 136
    //   367: iconst_2
    //   368: new 45	java/lang/StringBuilder
    //   371: dup
    //   372: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   375: ldc 159
    //   377: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   380: aload 7
    //   382: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   385: ldc 161
    //   387: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   390: aload 6
    //   392: invokeinterface 117 1 0
    //   397: checkcast 101	java/lang/String
    //   400: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   403: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   406: invokestatic 145	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   409: goto -285 -> 124
    //   412: astore 4
    //   414: aload_1
    //   415: monitorexit
    //   416: aload 4
    //   418: athrow
    //   419: iconst_3
    //   420: istore_2
    //   421: goto -177 -> 244
    //   424: iload_3
    //   425: istore_2
    //   426: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   429: ifeq -175 -> 254
    //   432: ldc 136
    //   434: iconst_2
    //   435: ldc 163
    //   437: invokestatic 145	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   440: iload_3
    //   441: istore_2
    //   442: goto -188 -> 254
    //   445: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   448: ifeq +11 -> 459
    //   451: ldc 136
    //   453: iconst_2
    //   454: ldc 165
    //   456: invokestatic 145	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   459: iconst_0
    //   460: istore_2
    //   461: goto -207 -> 254
    //   464: iconst_0
    //   465: istore_2
    //   466: goto -222 -> 244
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	469	0	paramInt	int
    //   243	223	2	b1	byte
    //   1	440	3	b2	byte
    //   69	66	4	localObject1	Object
    //   311	3	4	localIOException	java.io.IOException
    //   412	5	4	localObject2	Object
    //   38	284	5	localEditor	android.content.SharedPreferences.Editor
    //   22	369	6	localObject3	Object
    //   160	221	7	str1	String
    //   201	36	8	localFile	File
    //   190	39	9	str2	String
    // Exception table:
    //   from	to	target	type
    //   7	15	261	java/io/IOException
    //   81	88	311	java/io/IOException
    //   112	124	412	finally
    //   124	242	412	finally
    //   244	254	412	finally
    //   321	409	412	finally
    //   414	416	412	finally
  }
  
  public static byte a(int paramInt, boolean paramBoolean, String paramString)
  {
    byte b2 = 0;
    byte b1 = 0;
    if (paramString == null) {
      b1 = -1;
    }
    File localFile;
    for (;;)
    {
      return b1;
      String str = a(paramInt) + File.separator + b(paramInt, paramString);
      if (QLog.isColorLevel()) {
        QLog.i("MiniRecog.BaseMiniSoLoader", 2, "start loadMiniNativeSo: " + str);
      }
      localFile = new File(str);
      if ((!paramBoolean) && (localFile.exists())) {
        try
        {
          SoLoadUtilNew.loadSoByName(BaseApplicationImpl.getContext(), "c++_shared");
          System.load(str);
          if (QLog.isColorLevel())
          {
            QLog.i("MiniRecog.BaseMiniSoLoader", 2, "load " + str + " success!");
            return 0;
          }
        }
        catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
        {
          QLog.d("MiniRecog.BaseMiniSoLoader", 1, "load from mini dir failed, libName = " + paramString + "," + localUnsatisfiedLinkError.getMessage());
          return -2;
        }
      }
    }
    b1 = b2;
    if (paramBoolean)
    {
      b1 = b2;
      if (!localFile.exists()) {
        b1 = -3;
      }
    }
    b2 = b1;
    if (paramBoolean)
    {
      b2 = b1;
      if (localFile.exists()) {
        b2 = -4;
      }
    }
    b1 = b2;
    if (!paramBoolean)
    {
      b1 = b2;
      if (!localFile.exists()) {
        b1 = -5;
      }
    }
    QLog.d("MiniRecog.BaseMiniSoLoader", 1, "no mini so in mini dir,libName = " + paramString);
    return b1;
  }
  
  public static Object a(int paramInt)
  {
    if (paramInt == 0) {
      return apdh.a();
    }
    if (paramInt == 1) {
      return apdj.a();
    }
    if (paramInt == 2) {
      return apdi.a();
    }
    return null;
  }
  
  protected static String a(int paramInt)
  {
    if (paramInt == 0) {
      return apdh.a();
    }
    if (paramInt == 1) {
      return apdj.a();
    }
    if (paramInt == 2) {
      return apdi.a();
    }
    return "";
  }
  
  public static String a(int paramInt, String paramString)
  {
    paramString = b(paramInt, paramString);
    String str = BaseApplicationImpl.sApplication.getSharedPreferences("mobileQQ", 4).getString("mini_native_" + paramString, null);
    if (QLog.isColorLevel()) {
      QLog.i("MiniRecog.BaseMiniSoLoader", 2, "getFileMd5BySP ,resName = " + paramString + ",md5 = " + str);
    }
    return str;
  }
  
  protected static void a(int paramInt, boolean paramBoolean)
  {
    if (paramInt == 0) {
      apdh.a(paramBoolean);
    }
    do
    {
      return;
      if (paramInt == 1)
      {
        apdj.a(paramBoolean);
        return;
      }
    } while (paramInt != 2);
    apdi.a(paramBoolean);
  }
  
  /* Error */
  public static void a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +28 -> 33
    //   8: ldc 136
    //   10: iconst_2
    //   11: new 45	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   18: ldc 235
    //   20: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: aload_0
    //   24: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: invokestatic 145	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   33: new 237	com/tencent/commonsdk/zip/QZipFile
    //   36: dup
    //   37: aload_0
    //   38: invokespecial 238	com/tencent/commonsdk/zip/QZipFile:<init>	(Ljava/lang/String;)V
    //   41: astore 4
    //   43: aload 4
    //   45: invokevirtual 242	com/tencent/commonsdk/zip/QZipFile:entries	()Ljava/util/Enumeration;
    //   48: astore 6
    //   50: sipush 8192
    //   53: newarray byte
    //   55: astore 7
    //   57: aload 6
    //   59: invokeinterface 247 1 0
    //   64: ifeq +333 -> 397
    //   67: aload 6
    //   69: invokeinterface 250 1 0
    //   74: checkcast 252	java/util/zip/ZipEntry
    //   77: astore 5
    //   79: aload 5
    //   81: invokevirtual 255	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   84: astore_0
    //   85: aload_0
    //   86: ifnull +413 -> 499
    //   89: aload_0
    //   90: ldc_w 257
    //   93: invokevirtual 261	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   96: ifeq +6 -> 102
    //   99: goto -42 -> 57
    //   102: new 45	java/lang/StringBuilder
    //   105: dup
    //   106: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   109: aload_1
    //   110: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: getstatic 109	java/io/File:separator	Ljava/lang/String;
    //   116: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: aload_0
    //   120: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   126: astore_0
    //   127: aload 5
    //   129: invokevirtual 264	java/util/zip/ZipEntry:isDirectory	()Z
    //   132: ifeq +27 -> 159
    //   135: new 43	java/io/File
    //   138: dup
    //   139: aload_0
    //   140: invokespecial 59	java/io/File:<init>	(Ljava/lang/String;)V
    //   143: astore_0
    //   144: aload_0
    //   145: invokevirtual 63	java/io/File:exists	()Z
    //   148: ifne +354 -> 502
    //   151: aload_0
    //   152: invokevirtual 267	java/io/File:mkdir	()Z
    //   155: pop
    //   156: goto +346 -> 502
    //   159: aload_0
    //   160: getstatic 109	java/io/File:separator	Ljava/lang/String;
    //   163: invokevirtual 271	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   166: istore_2
    //   167: aload_0
    //   168: iconst_0
    //   169: iload_2
    //   170: invokevirtual 275	java/lang/String:substring	(II)Ljava/lang/String;
    //   173: astore 8
    //   175: aload_0
    //   176: iload_2
    //   177: iconst_1
    //   178: iadd
    //   179: invokevirtual 277	java/lang/String:substring	(I)Ljava/lang/String;
    //   182: ldc_w 279
    //   185: invokevirtual 282	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   188: ifeq +6 -> 194
    //   191: goto -134 -> 57
    //   194: new 43	java/io/File
    //   197: dup
    //   198: aload 8
    //   200: invokespecial 59	java/io/File:<init>	(Ljava/lang/String;)V
    //   203: astore 8
    //   205: aload 8
    //   207: invokevirtual 63	java/io/File:exists	()Z
    //   210: ifne +9 -> 219
    //   213: aload 8
    //   215: invokevirtual 267	java/io/File:mkdir	()Z
    //   218: pop
    //   219: new 43	java/io/File
    //   222: dup
    //   223: new 45	java/lang/StringBuilder
    //   226: dup
    //   227: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   230: aload_0
    //   231: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: ldc_w 284
    //   237: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   243: invokespecial 59	java/io/File:<init>	(Ljava/lang/String;)V
    //   246: astore 8
    //   248: new 43	java/io/File
    //   251: dup
    //   252: aload_0
    //   253: invokespecial 59	java/io/File:<init>	(Ljava/lang/String;)V
    //   256: astore 9
    //   258: aload 8
    //   260: invokevirtual 63	java/io/File:exists	()Z
    //   263: ifeq +9 -> 272
    //   266: aload 8
    //   268: invokevirtual 124	java/io/File:delete	()Z
    //   271: pop
    //   272: new 286	java/io/FileOutputStream
    //   275: dup
    //   276: aload 8
    //   278: invokespecial 289	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   281: astore_0
    //   282: aload 4
    //   284: aload 5
    //   286: invokevirtual 293	com/tencent/commonsdk/zip/QZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   289: astore 5
    //   291: aload 5
    //   293: aload 7
    //   295: iconst_0
    //   296: aload 7
    //   298: arraylength
    //   299: invokevirtual 299	java/io/InputStream:read	([BII)I
    //   302: istore_2
    //   303: iload_2
    //   304: iconst_m1
    //   305: if_icmpeq +52 -> 357
    //   308: aload_0
    //   309: aload 7
    //   311: iconst_0
    //   312: iload_2
    //   313: invokevirtual 303	java/io/FileOutputStream:write	([BII)V
    //   316: goto -25 -> 291
    //   319: astore 6
    //   321: aload 5
    //   323: astore_1
    //   324: aload_0
    //   325: astore_3
    //   326: aload 6
    //   328: astore_0
    //   329: aload_3
    //   330: ifnull +7 -> 337
    //   333: aload_3
    //   334: invokevirtual 306	java/io/FileOutputStream:close	()V
    //   337: aload_1
    //   338: ifnull +7 -> 345
    //   341: aload_1
    //   342: invokevirtual 307	java/io/InputStream:close	()V
    //   345: aload 4
    //   347: ifnull +8 -> 355
    //   350: aload 4
    //   352: invokevirtual 308	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   355: aload_0
    //   356: athrow
    //   357: aload_0
    //   358: invokevirtual 311	java/io/FileOutputStream:flush	()V
    //   361: aload_0
    //   362: invokevirtual 306	java/io/FileOutputStream:close	()V
    //   365: aload 5
    //   367: invokevirtual 307	java/io/InputStream:close	()V
    //   370: aload 8
    //   372: aload 9
    //   374: invokestatic 314	bgmg:b	(Ljava/io/File;Ljava/io/File;)Z
    //   377: ifne +125 -> 502
    //   380: aload 8
    //   382: aload 9
    //   384: invokestatic 316	bgmg:a	(Ljava/io/File;Ljava/io/File;)Z
    //   387: pop
    //   388: goto +114 -> 502
    //   391: astore_0
    //   392: aconst_null
    //   393: astore_1
    //   394: goto -65 -> 329
    //   397: iconst_0
    //   398: ifeq +11 -> 409
    //   401: new 318	java/lang/NullPointerException
    //   404: dup
    //   405: invokespecial 319	java/lang/NullPointerException:<init>	()V
    //   408: athrow
    //   409: iconst_0
    //   410: ifeq +11 -> 421
    //   413: new 318	java/lang/NullPointerException
    //   416: dup
    //   417: invokespecial 319	java/lang/NullPointerException:<init>	()V
    //   420: athrow
    //   421: aload 4
    //   423: ifnull +8 -> 431
    //   426: aload 4
    //   428: invokevirtual 308	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   431: return
    //   432: astore_0
    //   433: aload_0
    //   434: invokevirtual 151	java/io/IOException:printStackTrace	()V
    //   437: goto -28 -> 409
    //   440: astore_0
    //   441: aload_0
    //   442: invokevirtual 151	java/io/IOException:printStackTrace	()V
    //   445: goto -24 -> 421
    //   448: astore_0
    //   449: aload_0
    //   450: invokevirtual 151	java/io/IOException:printStackTrace	()V
    //   453: return
    //   454: astore_3
    //   455: aload_3
    //   456: invokevirtual 151	java/io/IOException:printStackTrace	()V
    //   459: goto -122 -> 337
    //   462: astore_1
    //   463: aload_1
    //   464: invokevirtual 151	java/io/IOException:printStackTrace	()V
    //   467: goto -122 -> 345
    //   470: astore_1
    //   471: aload_1
    //   472: invokevirtual 151	java/io/IOException:printStackTrace	()V
    //   475: goto -120 -> 355
    //   478: astore_0
    //   479: aconst_null
    //   480: astore 4
    //   482: aconst_null
    //   483: astore_1
    //   484: goto -155 -> 329
    //   487: astore 5
    //   489: aconst_null
    //   490: astore_1
    //   491: aload_0
    //   492: astore_3
    //   493: aload 5
    //   495: astore_0
    //   496: goto -167 -> 329
    //   499: goto -442 -> 57
    //   502: goto -445 -> 57
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	505	0	paramString1	String
    //   0	505	1	paramString2	String
    //   166	147	2	i	int
    //   1	333	3	str1	String
    //   454	2	3	localIOException	java.io.IOException
    //   492	1	3	str2	String
    //   41	440	4	localQZipFile	com.tencent.commonsdk.zip.QZipFile
    //   77	289	5	localObject1	Object
    //   487	7	5	localObject2	Object
    //   48	20	6	localEnumeration	java.util.Enumeration
    //   319	8	6	localObject3	Object
    //   55	255	7	arrayOfByte	byte[]
    //   173	208	8	localObject4	Object
    //   256	127	9	localFile	File
    // Exception table:
    //   from	to	target	type
    //   291	303	319	finally
    //   308	316	319	finally
    //   357	370	319	finally
    //   43	57	391	finally
    //   57	85	391	finally
    //   89	99	391	finally
    //   102	156	391	finally
    //   159	191	391	finally
    //   194	219	391	finally
    //   219	272	391	finally
    //   272	282	391	finally
    //   370	388	391	finally
    //   401	409	432	java/io/IOException
    //   413	421	440	java/io/IOException
    //   426	431	448	java/io/IOException
    //   333	337	454	java/io/IOException
    //   341	345	462	java/io/IOException
    //   350	355	470	java/io/IOException
    //   33	43	478	finally
    //   282	291	487	finally
  }
  
  public static boolean a(int paramInt, String paramString, HashMap<String, String> paramHashMap)
  {
    if (paramInt == 0) {
      return apdh.a(paramString, paramHashMap);
    }
    if (paramInt == 1) {
      return apdj.a(paramString, paramHashMap);
    }
    if (paramInt == 2) {
      return apdi.a(paramString, paramHashMap);
    }
    return false;
  }
  
  public static boolean a(int paramInt, boolean paramBoolean, String paramString)
  {
    boolean bool3 = false;
    boolean bool2 = false;
    String str1 = a(paramInt) + File.separator + b(paramInt, paramString);
    Object localObject = new File(str1);
    boolean bool1 = bool3;
    if (!paramBoolean)
    {
      bool1 = bool3;
      if (((File)localObject).exists())
      {
        localObject = a(paramInt);
        bool1 = bool3;
        if (localObject == null) {}
      }
    }
    label281:
    for (;;)
    {
      try
      {
        String str2 = a(paramInt, paramString);
        str1 = azby.a(str1);
        if (QLog.isColorLevel()) {
          QLog.d("MiniRecog.BaseMiniSoLoader", 2, "isSoFileExist: soName= " + paramString + " ,spmd5 = " + str2 + ",fileMD5 = " + str1);
        }
        if (str2 != null) {
          if (str2.equalsIgnoreCase(str1))
          {
            break label281;
            if (QLog.isColorLevel()) {
              QLog.d("MiniRecog.BaseMiniSoLoader", 2, "isSoFileExist: soName= " + paramString + " ,result = " + bool1 + ",isUncompressZip = " + paramBoolean);
            }
            return bool1;
          }
          else
          {
            bool1 = bool2;
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("MiniRecog.BaseMiniSoLoader", 2, "isSoFileExist: soName= " + paramString + " check md5 false!");
            bool1 = bool2;
            continue;
          }
        }
        bool1 = true;
      }
      finally {}
    }
  }
  
  public static String b(int paramInt, String paramString)
  {
    if (paramInt == 0) {
      return apdh.a(paramString);
    }
    if (paramInt == 1) {
      return apdj.a(paramString);
    }
    if (paramInt == 2) {
      return apdi.a(paramString);
    }
    return "";
  }
  
  public static String c(int paramInt, String paramString)
  {
    if (paramInt == 0) {
      return apdh.b(paramString);
    }
    if (paramInt == 1) {
      return apdj.b(paramString);
    }
    if (paramInt == 2) {
      return apdi.b(paramString);
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apcv
 * JD-Core Version:    0.7.0.1
 */