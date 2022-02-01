package com.tencent.av.avsdkconfig;

public class QavSdkConfigHelper
{
  private static String a = "QavSdkConfigHelper";
  
  /* Error */
  public static String a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: invokestatic 25	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +50 -> 53
    //   6: getstatic 27	com/tencent/av/avsdkconfig/QavSdkConfigHelper:a	Ljava/lang/String;
    //   9: astore_2
    //   10: new 29	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   17: astore_3
    //   18: aload_3
    //   19: ldc 32
    //   21: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: pop
    //   25: aload_3
    //   26: aload_0
    //   27: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: pop
    //   31: aload_3
    //   32: ldc 38
    //   34: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: pop
    //   38: aload_3
    //   39: aload_1
    //   40: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: pop
    //   44: aload_2
    //   45: iconst_2
    //   46: aload_3
    //   47: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: invokestatic 46	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   53: aconst_null
    //   54: astore 5
    //   56: aload_0
    //   57: ifnull +297 -> 354
    //   60: aload_0
    //   61: ldc 48
    //   63: invokevirtual 54	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   66: ifne +288 -> 354
    //   69: aload_1
    //   70: ifnull +284 -> 354
    //   73: aload_1
    //   74: ldc 48
    //   76: invokevirtual 54	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   79: ifeq +5 -> 84
    //   82: aconst_null
    //   83: areturn
    //   84: new 56	java/io/File
    //   87: dup
    //   88: aload_0
    //   89: aload_1
    //   90: invokespecial 59	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   93: astore 6
    //   95: aload 6
    //   97: invokevirtual 62	java/io/File:exists	()Z
    //   100: ifne +5 -> 105
    //   103: aconst_null
    //   104: areturn
    //   105: new 64	java/io/FileInputStream
    //   108: dup
    //   109: aload 6
    //   111: invokespecial 67	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   114: astore_0
    //   115: new 69	java/io/BufferedInputStream
    //   118: dup
    //   119: aload_0
    //   120: invokespecial 72	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   123: astore 4
    //   125: aload_0
    //   126: astore_1
    //   127: aload 4
    //   129: astore_2
    //   130: aload_0
    //   131: invokevirtual 76	java/io/FileInputStream:available	()I
    //   134: newarray byte
    //   136: astore_3
    //   137: aload_0
    //   138: astore_1
    //   139: aload 4
    //   141: astore_2
    //   142: aload 4
    //   144: aload_3
    //   145: invokevirtual 80	java/io/BufferedInputStream:read	([B)I
    //   148: pop
    //   149: aload_0
    //   150: astore_1
    //   151: aload 4
    //   153: astore_2
    //   154: new 50	java/lang/String
    //   157: dup
    //   158: aload_3
    //   159: ldc 82
    //   161: invokespecial 85	java/lang/String:<init>	([BLjava/lang/String;)V
    //   164: astore_3
    //   165: aload 4
    //   167: invokevirtual 88	java/io/BufferedInputStream:close	()V
    //   170: goto +8 -> 178
    //   173: astore_1
    //   174: aload_1
    //   175: invokevirtual 91	java/io/IOException:printStackTrace	()V
    //   178: aload_0
    //   179: invokevirtual 92	java/io/FileInputStream:close	()V
    //   182: goto +8 -> 190
    //   185: astore_0
    //   186: aload_0
    //   187: invokevirtual 91	java/io/IOException:printStackTrace	()V
    //   190: aload_3
    //   191: astore_0
    //   192: goto +81 -> 273
    //   195: astore_1
    //   196: aconst_null
    //   197: astore_2
    //   198: goto +122 -> 320
    //   201: aconst_null
    //   202: astore_1
    //   203: aload_0
    //   204: astore_3
    //   205: aload_1
    //   206: astore_0
    //   207: goto +15 -> 222
    //   210: astore_1
    //   211: aconst_null
    //   212: astore_2
    //   213: aload_2
    //   214: astore_0
    //   215: goto +105 -> 320
    //   218: aconst_null
    //   219: astore_3
    //   220: aload_3
    //   221: astore_0
    //   222: aload_3
    //   223: astore_1
    //   224: aload_0
    //   225: astore_2
    //   226: aload 6
    //   228: invokevirtual 95	java/io/File:delete	()Z
    //   231: pop
    //   232: aload_0
    //   233: ifnull +15 -> 248
    //   236: aload_0
    //   237: invokevirtual 88	java/io/BufferedInputStream:close	()V
    //   240: goto +8 -> 248
    //   243: astore_0
    //   244: aload_0
    //   245: invokevirtual 91	java/io/IOException:printStackTrace	()V
    //   248: aload 5
    //   250: astore_0
    //   251: aload_3
    //   252: ifnull +21 -> 273
    //   255: aload_3
    //   256: invokevirtual 92	java/io/FileInputStream:close	()V
    //   259: aload 5
    //   261: astore_0
    //   262: goto +11 -> 273
    //   265: astore_0
    //   266: aload_0
    //   267: invokevirtual 91	java/io/IOException:printStackTrace	()V
    //   270: aload 5
    //   272: astore_0
    //   273: invokestatic 25	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   276: ifeq +37 -> 313
    //   279: getstatic 27	com/tencent/av/avsdkconfig/QavSdkConfigHelper:a	Ljava/lang/String;
    //   282: astore_1
    //   283: new 29	java/lang/StringBuilder
    //   286: dup
    //   287: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   290: astore_2
    //   291: aload_2
    //   292: ldc 97
    //   294: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: pop
    //   298: aload_2
    //   299: aload_0
    //   300: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: pop
    //   304: aload_1
    //   305: iconst_2
    //   306: aload_2
    //   307: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   310: invokestatic 46	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   313: aload_0
    //   314: areturn
    //   315: astore_3
    //   316: aload_1
    //   317: astore_0
    //   318: aload_3
    //   319: astore_1
    //   320: aload_2
    //   321: ifnull +15 -> 336
    //   324: aload_2
    //   325: invokevirtual 88	java/io/BufferedInputStream:close	()V
    //   328: goto +8 -> 336
    //   331: astore_2
    //   332: aload_2
    //   333: invokevirtual 91	java/io/IOException:printStackTrace	()V
    //   336: aload_0
    //   337: ifnull +15 -> 352
    //   340: aload_0
    //   341: invokevirtual 92	java/io/FileInputStream:close	()V
    //   344: goto +8 -> 352
    //   347: astore_0
    //   348: aload_0
    //   349: invokevirtual 91	java/io/IOException:printStackTrace	()V
    //   352: aload_1
    //   353: athrow
    //   354: aconst_null
    //   355: areturn
    //   356: astore_0
    //   357: goto -139 -> 218
    //   360: astore_1
    //   361: goto -160 -> 201
    //   364: astore_1
    //   365: aload_0
    //   366: astore_3
    //   367: aload 4
    //   369: astore_0
    //   370: goto -148 -> 222
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	373	0	paramString1	String
    //   0	373	1	paramString2	String
    //   9	316	2	localObject1	Object
    //   331	2	2	localIOException	java.io.IOException
    //   17	239	3	localObject2	Object
    //   315	4	3	localObject3	Object
    //   366	1	3	str	String
    //   123	245	4	localBufferedInputStream	java.io.BufferedInputStream
    //   54	217	5	localObject4	Object
    //   93	134	6	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   165	170	173	java/io/IOException
    //   178	182	185	java/io/IOException
    //   115	125	195	finally
    //   105	115	210	finally
    //   236	240	243	java/io/IOException
    //   255	259	265	java/io/IOException
    //   130	137	315	finally
    //   142	149	315	finally
    //   154	165	315	finally
    //   226	232	315	finally
    //   324	328	331	java/io/IOException
    //   340	344	347	java/io/IOException
    //   105	115	356	java/lang/Throwable
    //   115	125	360	java/lang/Throwable
    //   130	137	364	java/lang/Throwable
    //   142	149	364	java/lang/Throwable
    //   154	165	364	java/lang/Throwable
  }
  
  public static boolean a()
  {
    return false;
  }
  
  public static String b()
  {
    if (!a()) {
      return "";
    }
    return QavSdkConfigManager.a().b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.avsdkconfig.QavSdkConfigHelper
 * JD-Core Version:    0.7.0.1
 */