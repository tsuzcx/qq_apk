package com.tencent.aelight.camera.aioeditor.shortvideo;

import java.io.InputStream;
import mqq.os.MqqHandler;

public class ShortVideoUtils$VideoFileSaveRunnable
  implements Runnable
{
  InputStream jdField_a_of_type_JavaIoInputStream;
  String jdField_a_of_type_JavaLangString;
  MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  boolean jdField_a_of_type_Boolean;
  String b;
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 20	com/tencent/aelight/camera/aioeditor/shortvideo/ShortVideoUtils$VideoFileSaveRunnable:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4: invokestatic 26	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7: ifne +13 -> 20
    //   10: aload_0
    //   11: getfield 20	com/tencent/aelight/camera/aioeditor/shortvideo/ShortVideoUtils$VideoFileSaveRunnable:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   14: invokestatic 32	com/tencent/mobileqq/utils/FileUtils:fileExists	(Ljava/lang/String;)Z
    //   17: ifne +60 -> 77
    //   20: aload_0
    //   21: getfield 34	com/tencent/aelight/camera/aioeditor/shortvideo/ShortVideoUtils$VideoFileSaveRunnable:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   24: ifnonnull +53 -> 77
    //   27: invokestatic 40	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   30: ifeq +37 -> 67
    //   33: new 42	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   40: astore_2
    //   41: aload_2
    //   42: ldc 47
    //   44: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: pop
    //   48: aload_2
    //   49: aload_0
    //   50: getfield 20	com/tencent/aelight/camera/aioeditor/shortvideo/ShortVideoUtils$VideoFileSaveRunnable:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   53: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: pop
    //   57: ldc 53
    //   59: iconst_2
    //   60: aload_2
    //   61: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   64: invokestatic 61	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   67: aload_0
    //   68: getfield 63	com/tencent/aelight/camera/aioeditor/shortvideo/ShortVideoUtils$VideoFileSaveRunnable:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   71: iconst_1
    //   72: invokevirtual 69	mqq/os/MqqHandler:sendEmptyMessage	(I)Z
    //   75: pop
    //   76: return
    //   77: aload_0
    //   78: getfield 34	com/tencent/aelight/camera/aioeditor/shortvideo/ShortVideoUtils$VideoFileSaveRunnable:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   81: astore_2
    //   82: aconst_null
    //   83: astore 8
    //   85: aconst_null
    //   86: astore 4
    //   88: aconst_null
    //   89: astore 6
    //   91: aconst_null
    //   92: astore 7
    //   94: aload_2
    //   95: ifnonnull +18 -> 113
    //   98: new 71	java/io/File
    //   101: dup
    //   102: aload_0
    //   103: getfield 20	com/tencent/aelight/camera/aioeditor/shortvideo/ShortVideoUtils$VideoFileSaveRunnable:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   106: invokespecial 74	java/io/File:<init>	(Ljava/lang/String;)V
    //   109: astore_2
    //   110: goto +5 -> 115
    //   113: aconst_null
    //   114: astore_2
    //   115: invokestatic 78	com/tencent/util/VersionUtils:b	()Z
    //   118: ifeq +13 -> 131
    //   121: getstatic 83	android/os/Environment:DIRECTORY_MOVIES	Ljava/lang/String;
    //   124: invokestatic 87	android/os/Environment:getExternalStoragePublicDirectory	(Ljava/lang/String;)Ljava/io/File;
    //   127: astore_3
    //   128: goto +14 -> 142
    //   131: new 71	java/io/File
    //   134: dup
    //   135: getstatic 92	com/tencent/mobileqq/activity/richmedia/PathUtils:f	Ljava/lang/String;
    //   138: invokespecial 74	java/io/File:<init>	(Ljava/lang/String;)V
    //   141: astore_3
    //   142: aload_3
    //   143: invokevirtual 95	java/io/File:mkdirs	()Z
    //   146: pop
    //   147: new 71	java/io/File
    //   150: dup
    //   151: aload_3
    //   152: aload_0
    //   153: getfield 97	com/tencent/aelight/camera/aioeditor/shortvideo/ShortVideoUtils$VideoFileSaveRunnable:b	Ljava/lang/String;
    //   156: invokestatic 102	com/tencent/aelight/camera/aioeditor/shortvideo/ShortVideoUtils:a	(Ljava/lang/String;)Ljava/lang/String;
    //   159: invokespecial 105	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   162: astore 9
    //   164: aload_0
    //   165: getfield 107	com/tencent/aelight/camera/aioeditor/shortvideo/ShortVideoUtils$VideoFileSaveRunnable:jdField_a_of_type_Boolean	Z
    //   168: ifne +34 -> 202
    //   171: aload 9
    //   173: invokevirtual 110	java/io/File:exists	()Z
    //   176: ifeq +26 -> 202
    //   179: aload_0
    //   180: getfield 63	com/tencent/aelight/camera/aioeditor/shortvideo/ShortVideoUtils$VideoFileSaveRunnable:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   183: iconst_3
    //   184: aload_0
    //   185: getfield 20	com/tencent/aelight/camera/aioeditor/shortvideo/ShortVideoUtils$VideoFileSaveRunnable:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   188: invokevirtual 114	mqq/os/MqqHandler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   191: astore_2
    //   192: aload_0
    //   193: getfield 63	com/tencent/aelight/camera/aioeditor/shortvideo/ShortVideoUtils$VideoFileSaveRunnable:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   196: aload_2
    //   197: invokevirtual 118	mqq/os/MqqHandler:sendMessage	(Landroid/os/Message;)Z
    //   200: pop
    //   201: return
    //   202: new 120	java/io/FileOutputStream
    //   205: dup
    //   206: aload 9
    //   208: invokespecial 123	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   211: astore 5
    //   213: aload 7
    //   215: astore_3
    //   216: aload 8
    //   218: astore 4
    //   220: aload_0
    //   221: getfield 34	com/tencent/aelight/camera/aioeditor/shortvideo/ShortVideoUtils$VideoFileSaveRunnable:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   224: ifnull +18 -> 242
    //   227: aload 7
    //   229: astore_3
    //   230: aload 8
    //   232: astore 4
    //   234: aload_0
    //   235: getfield 34	com/tencent/aelight/camera/aioeditor/shortvideo/ShortVideoUtils$VideoFileSaveRunnable:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   238: astore_2
    //   239: goto +19 -> 258
    //   242: aload 7
    //   244: astore_3
    //   245: aload 8
    //   247: astore 4
    //   249: new 125	java/io/FileInputStream
    //   252: dup
    //   253: aload_2
    //   254: invokespecial 126	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   257: astore_2
    //   258: aload_2
    //   259: astore_3
    //   260: aload_2
    //   261: astore 4
    //   263: ldc 127
    //   265: newarray byte
    //   267: astore 6
    //   269: aload_2
    //   270: astore_3
    //   271: aload_2
    //   272: astore 4
    //   274: aload_2
    //   275: aload 6
    //   277: invokevirtual 133	java/io/InputStream:read	([B)I
    //   280: istore_1
    //   281: iload_1
    //   282: iconst_m1
    //   283: if_icmpeq +30 -> 313
    //   286: aload_2
    //   287: astore_3
    //   288: aload_2
    //   289: astore 4
    //   291: aload 5
    //   293: aload 6
    //   295: iconst_0
    //   296: iload_1
    //   297: invokevirtual 137	java/io/FileOutputStream:write	([BII)V
    //   300: aload_2
    //   301: astore_3
    //   302: aload_2
    //   303: astore 4
    //   305: aload 5
    //   307: invokevirtual 140	java/io/FileOutputStream:flush	()V
    //   310: goto -41 -> 269
    //   313: aload_2
    //   314: astore_3
    //   315: aload_2
    //   316: astore 4
    //   318: aload_0
    //   319: getfield 63	com/tencent/aelight/camera/aioeditor/shortvideo/ShortVideoUtils$VideoFileSaveRunnable:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   322: iconst_2
    //   323: aload 9
    //   325: invokevirtual 143	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   328: invokevirtual 114	mqq/os/MqqHandler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   331: astore 6
    //   333: aload_2
    //   334: astore_3
    //   335: aload_2
    //   336: astore 4
    //   338: aload_0
    //   339: getfield 63	com/tencent/aelight/camera/aioeditor/shortvideo/ShortVideoUtils$VideoFileSaveRunnable:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   342: aload 6
    //   344: invokevirtual 118	mqq/os/MqqHandler:sendMessage	(Landroid/os/Message;)Z
    //   347: pop
    //   348: aload 5
    //   350: invokevirtual 146	java/io/FileOutputStream:close	()V
    //   353: aload_2
    //   354: ifnull +96 -> 450
    //   357: aload_2
    //   358: invokevirtual 147	java/io/InputStream:close	()V
    //   361: return
    //   362: astore_2
    //   363: aload 5
    //   365: astore 4
    //   367: goto +94 -> 461
    //   370: astore 6
    //   372: aload 4
    //   374: astore_2
    //   375: aload 5
    //   377: astore_3
    //   378: aload 6
    //   380: astore 4
    //   382: goto +24 -> 406
    //   385: astore_2
    //   386: aconst_null
    //   387: astore 4
    //   389: aload 6
    //   391: astore_3
    //   392: goto +69 -> 461
    //   395: astore 5
    //   397: aconst_null
    //   398: astore_2
    //   399: aload 4
    //   401: astore_3
    //   402: aload 5
    //   404: astore 4
    //   406: invokestatic 40	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   409: ifeq +13 -> 422
    //   412: ldc 53
    //   414: iconst_2
    //   415: ldc 149
    //   417: aload 4
    //   419: invokestatic 152	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   422: aload_0
    //   423: getfield 63	com/tencent/aelight/camera/aioeditor/shortvideo/ShortVideoUtils$VideoFileSaveRunnable:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   426: iconst_1
    //   427: invokevirtual 69	mqq/os/MqqHandler:sendEmptyMessage	(I)Z
    //   430: pop
    //   431: aload_3
    //   432: ifnull +10 -> 442
    //   435: aload_3
    //   436: invokevirtual 146	java/io/FileOutputStream:close	()V
    //   439: goto +3 -> 442
    //   442: aload_2
    //   443: ifnull +7 -> 450
    //   446: aload_2
    //   447: invokevirtual 147	java/io/InputStream:close	()V
    //   450: return
    //   451: astore 5
    //   453: aload_3
    //   454: astore 4
    //   456: aload_2
    //   457: astore_3
    //   458: aload 5
    //   460: astore_2
    //   461: aload 4
    //   463: ifnull +11 -> 474
    //   466: aload 4
    //   468: invokevirtual 146	java/io/FileOutputStream:close	()V
    //   471: goto +3 -> 474
    //   474: aload_3
    //   475: ifnull +7 -> 482
    //   478: aload_3
    //   479: invokevirtual 147	java/io/InputStream:close	()V
    //   482: goto +5 -> 487
    //   485: aload_2
    //   486: athrow
    //   487: goto -2 -> 485
    //   490: astore_3
    //   491: goto -138 -> 353
    //   494: astore_2
    //   495: return
    //   496: astore_3
    //   497: goto -55 -> 442
    //   500: astore 4
    //   502: goto -28 -> 474
    //   505: astore_3
    //   506: goto -24 -> 482
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	509	0	this	VideoFileSaveRunnable
    //   280	17	1	i	int
    //   40	318	2	localObject1	Object
    //   362	1	2	localObject2	Object
    //   374	1	2	localObject3	Object
    //   385	1	2	localObject4	Object
    //   398	88	2	localObject5	Object
    //   494	1	2	localIOException1	java.io.IOException
    //   127	352	3	localObject6	Object
    //   490	1	3	localIOException2	java.io.IOException
    //   496	1	3	localIOException3	java.io.IOException
    //   505	1	3	localIOException4	java.io.IOException
    //   86	381	4	localObject7	Object
    //   500	1	4	localIOException5	java.io.IOException
    //   211	165	5	localFileOutputStream	java.io.FileOutputStream
    //   395	8	5	localException1	java.lang.Exception
    //   451	8	5	localObject8	Object
    //   89	254	6	localObject9	Object
    //   370	20	6	localException2	java.lang.Exception
    //   92	151	7	localObject10	Object
    //   83	163	8	localObject11	Object
    //   162	162	9	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   220	227	362	finally
    //   234	239	362	finally
    //   249	258	362	finally
    //   263	269	362	finally
    //   274	281	362	finally
    //   291	300	362	finally
    //   305	310	362	finally
    //   318	333	362	finally
    //   338	348	362	finally
    //   220	227	370	java/lang/Exception
    //   234	239	370	java/lang/Exception
    //   249	258	370	java/lang/Exception
    //   263	269	370	java/lang/Exception
    //   274	281	370	java/lang/Exception
    //   291	300	370	java/lang/Exception
    //   305	310	370	java/lang/Exception
    //   318	333	370	java/lang/Exception
    //   338	348	370	java/lang/Exception
    //   202	213	385	finally
    //   202	213	395	java/lang/Exception
    //   406	422	451	finally
    //   422	431	451	finally
    //   348	353	490	java/io/IOException
    //   357	361	494	java/io/IOException
    //   446	450	494	java/io/IOException
    //   435	439	496	java/io/IOException
    //   466	471	500	java/io/IOException
    //   478	482	505	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.shortvideo.ShortVideoUtils.VideoFileSaveRunnable
 * JD-Core Version:    0.7.0.1
 */