package com.tencent.mobileqq.app;

import java.io.InputStream;
import java.io.OutputStream;

public class InjectUtils
{
  public static final String SUCCESS = "Success";
  private static final String TAG = "DexLoadOat";
  
  public static long copy(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    long l = 0L;
    byte[] arrayOfByte = new byte[8192];
    for (;;)
    {
      int i = paramInputStream.read(arrayOfByte, 0, arrayOfByte.length);
      if (i == -1) {
        break;
      }
      paramOutputStream.write(arrayOfByte, 0, i);
      l += i;
    }
    return l;
  }
  
  /* Error */
  private static String extractMd5File(android.app.Application paramApplication, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: aload_0
    //   6: invokevirtual 42	android/app/Application:getFilesDir	()Ljava/io/File;
    //   9: astore_2
    //   10: aload_2
    //   11: ifnull +74 -> 85
    //   14: aload_2
    //   15: invokevirtual 48	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   18: astore_2
    //   19: new 44	java/io/File
    //   22: dup
    //   23: aload_2
    //   24: aload_1
    //   25: invokespecial 51	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   28: astore 5
    //   30: ldc 8
    //   32: ldc 8
    //   34: invokevirtual 57	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   37: ifeq +199 -> 236
    //   40: aload_0
    //   41: invokevirtual 61	android/app/Application:getAssets	()Landroid/content/res/AssetManager;
    //   44: aload_1
    //   45: invokevirtual 67	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   48: astore_0
    //   49: new 69	java/io/FileOutputStream
    //   52: dup
    //   53: aload 5
    //   55: iconst_0
    //   56: invokespecial 72	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   59: astore_1
    //   60: aload_0
    //   61: aload_1
    //   62: invokestatic 74	com/tencent/mobileqq/app/InjectUtils:copy	(Ljava/io/InputStream;Ljava/io/OutputStream;)J
    //   65: pop2
    //   66: aload_0
    //   67: ifnull +7 -> 74
    //   70: aload_0
    //   71: invokevirtual 77	java/io/InputStream:close	()V
    //   74: aload_1
    //   75: ifnull +7 -> 82
    //   78: aload_1
    //   79: invokevirtual 78	java/io/OutputStream:close	()V
    //   82: ldc 8
    //   84: areturn
    //   85: ldc 80
    //   87: astore_2
    //   88: goto -69 -> 19
    //   91: astore_0
    //   92: aconst_null
    //   93: astore_1
    //   94: aload_3
    //   95: astore_2
    //   96: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   99: ifeq +30 -> 129
    //   102: ldc 88
    //   104: iconst_2
    //   105: new 90	java/lang/StringBuilder
    //   108: dup
    //   109: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   112: aload 5
    //   114: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   117: ldc 97
    //   119: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   125: aload_0
    //   126: invokestatic 107	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   129: aload_2
    //   130: ifnull +7 -> 137
    //   133: aload_2
    //   134: invokevirtual 77	java/io/InputStream:close	()V
    //   137: aload_1
    //   138: ifnull -56 -> 82
    //   141: aload_1
    //   142: invokevirtual 78	java/io/OutputStream:close	()V
    //   145: ldc 8
    //   147: areturn
    //   148: astore_0
    //   149: ldc 8
    //   151: areturn
    //   152: astore_0
    //   153: aconst_null
    //   154: astore_1
    //   155: aload 4
    //   157: astore_2
    //   158: aload_2
    //   159: ifnull +7 -> 166
    //   162: aload_2
    //   163: invokevirtual 77	java/io/InputStream:close	()V
    //   166: aload_1
    //   167: ifnull +7 -> 174
    //   170: aload_1
    //   171: invokevirtual 78	java/io/OutputStream:close	()V
    //   174: aload_0
    //   175: athrow
    //   176: astore_0
    //   177: goto -103 -> 74
    //   180: astore_0
    //   181: ldc 8
    //   183: areturn
    //   184: astore_0
    //   185: goto -48 -> 137
    //   188: astore_2
    //   189: goto -23 -> 166
    //   192: astore_1
    //   193: goto -19 -> 174
    //   196: astore_3
    //   197: aconst_null
    //   198: astore_1
    //   199: aload_0
    //   200: astore_2
    //   201: aload_3
    //   202: astore_0
    //   203: goto -45 -> 158
    //   206: astore_3
    //   207: aload_0
    //   208: astore_2
    //   209: aload_3
    //   210: astore_0
    //   211: goto -53 -> 158
    //   214: astore_0
    //   215: goto -57 -> 158
    //   218: astore_3
    //   219: aconst_null
    //   220: astore_1
    //   221: aload_0
    //   222: astore_2
    //   223: aload_3
    //   224: astore_0
    //   225: goto -129 -> 96
    //   228: astore_3
    //   229: aload_0
    //   230: astore_2
    //   231: aload_3
    //   232: astore_0
    //   233: goto -137 -> 96
    //   236: aconst_null
    //   237: astore_1
    //   238: aconst_null
    //   239: astore_0
    //   240: goto -174 -> 66
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	243	0	paramApplication	android.app.Application
    //   0	243	1	paramString	String
    //   9	154	2	localObject1	Object
    //   188	1	2	localIOException	java.io.IOException
    //   200	31	2	localApplication	android.app.Application
    //   4	91	3	localObject2	Object
    //   196	6	3	localObject3	Object
    //   206	4	3	localObject4	Object
    //   218	6	3	localThrowable1	java.lang.Throwable
    //   228	4	3	localThrowable2	java.lang.Throwable
    //   1	155	4	localObject5	Object
    //   28	85	5	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   30	49	91	java/lang/Throwable
    //   141	145	148	java/io/IOException
    //   30	49	152	finally
    //   70	74	176	java/io/IOException
    //   78	82	180	java/io/IOException
    //   133	137	184	java/io/IOException
    //   162	166	188	java/io/IOException
    //   170	174	192	java/io/IOException
    //   49	60	196	finally
    //   60	66	206	finally
    //   96	129	214	finally
    //   49	60	218	java/lang/Throwable
    //   60	66	228	java/lang/Throwable
  }
  
  public static String getStartupClassName(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("Foo");
    if (paramInt == 0) {}
    for (String str = "";; str = String.valueOf(paramInt + 1)) {
      return str;
    }
  }
  
  /* Error */
  private static String injectExtraDexManual(android.app.Application paramApplication, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: ldc 2
    //   5: monitorenter
    //   6: ldc 8
    //   8: astore 5
    //   10: getstatic 126	com/tencent/commonsdk/soload/DexReleasor:sExtraDexes	[Ljava/lang/String;
    //   13: astore 8
    //   15: iconst_0
    //   16: istore_2
    //   17: iload_2
    //   18: aload 8
    //   20: arraylength
    //   21: if_icmpge +265 -> 286
    //   24: aload 8
    //   26: iload_2
    //   27: aaload
    //   28: astore 11
    //   30: iload_2
    //   31: invokestatic 128	com/tencent/mobileqq/app/InjectUtils:getStartupClassName	(I)Ljava/lang/String;
    //   34: astore 10
    //   36: new 90	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   43: aload 8
    //   45: iload_2
    //   46: aaload
    //   47: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: ldc 130
    //   52: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   58: astore 9
    //   60: aload_0
    //   61: invokevirtual 134	android/app/Application:getApplicationContext	()Landroid/content/Context;
    //   64: getstatic 137	com/tencent/commonsdk/soload/DexReleasor:sExtraJarDexes	[Ljava/lang/String;
    //   67: iload_2
    //   68: aaload
    //   69: aload 9
    //   71: invokestatic 143	com/tencent/commonsdk/soload/SoLoadCore:isLibExtracted	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Z
    //   74: istore 4
    //   76: iload 4
    //   78: ifne +25 -> 103
    //   81: iconst_1
    //   82: istore_3
    //   83: aload 5
    //   85: astore 6
    //   87: iload_3
    //   88: ifeq +35 -> 123
    //   91: iload_1
    //   92: ifeq +16 -> 108
    //   95: aload 7
    //   97: astore_0
    //   98: ldc 2
    //   100: monitorexit
    //   101: aload_0
    //   102: areturn
    //   103: iconst_0
    //   104: istore_3
    //   105: goto -22 -> 83
    //   108: aload_0
    //   109: invokevirtual 134	android/app/Application:getApplicationContext	()Landroid/content/Context;
    //   112: aload 11
    //   114: invokestatic 147	com/tencent/commonsdk/soload/SoLoadCore:releaseDexFromApk	(Landroid/content/Context;Ljava/lang/String;)Z
    //   117: ifne +126 -> 243
    //   120: aconst_null
    //   121: astore 6
    //   123: aload 6
    //   125: astore 5
    //   127: ldc 8
    //   129: aload 6
    //   131: invokevirtual 57	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   134: ifeq +47 -> 181
    //   137: aload_0
    //   138: invokevirtual 42	android/app/Application:getFilesDir	()Ljava/io/File;
    //   141: astore 5
    //   143: aload 5
    //   145: ifnull +109 -> 254
    //   148: aload 5
    //   150: invokevirtual 48	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   153: astore 5
    //   155: aload_0
    //   156: new 44	java/io/File
    //   159: dup
    //   160: aload 5
    //   162: getstatic 137	com/tencent/commonsdk/soload/DexReleasor:sExtraJarDexes	[Ljava/lang/String;
    //   165: iload_2
    //   166: aaload
    //   167: invokespecial 51	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   170: invokevirtual 48	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   173: aload 10
    //   175: iconst_1
    //   176: invokestatic 153	com/tencent/mobileqq/app/SystemClassLoaderInjector:a	(Landroid/app/Application;Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;
    //   179: astore 5
    //   181: ldc 11
    //   183: iconst_1
    //   184: aload 5
    //   186: invokestatic 156	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   189: ldc 8
    //   191: aload 5
    //   193: invokevirtual 57	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   196: istore 4
    //   198: iload 4
    //   200: ifne +68 -> 268
    //   203: new 44	java/io/File
    //   206: dup
    //   207: aload_0
    //   208: invokevirtual 42	android/app/Application:getFilesDir	()Ljava/io/File;
    //   211: aload 9
    //   213: invokespecial 159	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   216: invokevirtual 162	java/io/File:delete	()Z
    //   219: pop
    //   220: new 44	java/io/File
    //   223: dup
    //   224: aload_0
    //   225: invokevirtual 42	android/app/Application:getFilesDir	()Ljava/io/File;
    //   228: aload 9
    //   230: invokespecial 159	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   233: invokevirtual 162	java/io/File:delete	()Z
    //   236: pop
    //   237: aload 5
    //   239: astore_0
    //   240: goto -142 -> 98
    //   243: aload_0
    //   244: aload 9
    //   246: invokestatic 164	com/tencent/mobileqq/app/InjectUtils:extractMd5File	(Landroid/app/Application;Ljava/lang/String;)Ljava/lang/String;
    //   249: astore 6
    //   251: goto -128 -> 123
    //   254: ldc 80
    //   256: astore 5
    //   258: goto -103 -> 155
    //   261: astore_0
    //   262: aload 5
    //   264: astore_0
    //   265: goto -167 -> 98
    //   268: iload_2
    //   269: iconst_1
    //   270: iadd
    //   271: istore_2
    //   272: goto -255 -> 17
    //   275: astore_0
    //   276: ldc 2
    //   278: monitorexit
    //   279: aload_0
    //   280: athrow
    //   281: astore 6
    //   283: goto -63 -> 220
    //   286: aload 5
    //   288: astore_0
    //   289: goto -191 -> 98
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	292	0	paramApplication	android.app.Application
    //   0	292	1	paramBoolean	boolean
    //   16	256	2	i	int
    //   82	23	3	j	int
    //   74	125	4	bool	boolean
    //   8	279	5	localObject1	Object
    //   85	165	6	localObject2	Object
    //   281	1	6	localException	java.lang.Exception
    //   1	95	7	localObject3	Object
    //   13	31	8	arrayOfString	String[]
    //   58	187	9	str1	String
    //   34	140	10	str2	String
    //   28	85	11	str3	String
    // Exception table:
    //   from	to	target	type
    //   220	237	261	java/lang/Exception
    //   10	15	275	finally
    //   17	24	275	finally
    //   30	76	275	finally
    //   108	120	275	finally
    //   127	143	275	finally
    //   148	155	275	finally
    //   155	181	275	finally
    //   181	198	275	finally
    //   203	220	275	finally
    //   220	237	275	finally
    //   243	251	275	finally
    //   203	220	281	java/lang/Exception
  }
  
  /* Error */
  public static String injectExtraDexes(android.app.Application paramApplication, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 171	android/os/Build$VERSION:SDK_INT	I
    //   6: istore_2
    //   7: iload_2
    //   8: bipush 21
    //   10: if_icmpge +33 -> 43
    //   13: aload_0
    //   14: invokestatic 175	com/tencent/commonsdk/soload/DexReleasor:initDexCount	(Landroid/content/Context;)V
    //   17: aload_0
    //   18: iload_1
    //   19: invokestatic 177	com/tencent/mobileqq/app/InjectUtils:injectExtraDexManual	(Landroid/app/Application;Z)Ljava/lang/String;
    //   22: astore_0
    //   23: ldc 2
    //   25: monitorexit
    //   26: aload_0
    //   27: areturn
    //   28: astore_0
    //   29: ldc 11
    //   31: iconst_1
    //   32: ldc 113
    //   34: aload_0
    //   35: invokestatic 107	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   38: aconst_null
    //   39: astore_0
    //   40: goto -17 -> 23
    //   43: ldc 8
    //   45: astore_0
    //   46: goto -23 -> 23
    //   49: astore_0
    //   50: ldc 2
    //   52: monitorexit
    //   53: aload_0
    //   54: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	55	0	paramApplication	android.app.Application
    //   0	55	1	paramBoolean	boolean
    //   6	5	2	i	int
    // Exception table:
    //   from	to	target	type
    //   13	23	28	java/lang/Throwable
    //   3	7	49	finally
    //   13	23	49	finally
    //   29	38	49	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.InjectUtils
 * JD-Core Version:    0.7.0.1
 */