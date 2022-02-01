package com.tencent.aelight.camera.aioeditor.capture.data;

final class QIMRedDotConfig$1
  implements Runnable
{
  QIMRedDotConfig$1(String paramString, QIMRedDotConfig paramQIMRedDotConfig) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 26	java/io/File
    //   5: dup
    //   6: aload_0
    //   7: getfield 13	com/tencent/aelight/camera/aioeditor/capture/data/QIMRedDotConfig$1:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   10: ldc 28
    //   12: invokespecial 31	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   15: astore 4
    //   17: aload 4
    //   19: invokevirtual 35	java/io/File:exists	()Z
    //   22: ifeq +9 -> 31
    //   25: aload 4
    //   27: invokevirtual 38	java/io/File:delete	()Z
    //   30: pop
    //   31: new 40	java/io/ObjectOutputStream
    //   34: dup
    //   35: new 42	java/io/BufferedOutputStream
    //   38: dup
    //   39: new 44	java/io/FileOutputStream
    //   42: dup
    //   43: aload 4
    //   45: invokespecial 47	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   48: invokespecial 50	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   51: invokespecial 51	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   54: astore_1
    //   55: aload_1
    //   56: astore_2
    //   57: aload_1
    //   58: aload_0
    //   59: getfield 15	com/tencent/aelight/camera/aioeditor/capture/data/QIMRedDotConfig$1:jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureDataQIMRedDotConfig	Lcom/tencent/aelight/camera/aioeditor/capture/data/QIMRedDotConfig;
    //   62: invokevirtual 55	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   65: aload_1
    //   66: astore_3
    //   67: aload_1
    //   68: astore_2
    //   69: invokestatic 60	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   72: ifeq +15 -> 87
    //   75: aload_1
    //   76: astore_2
    //   77: ldc 62
    //   79: iconst_2
    //   80: ldc 64
    //   82: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   85: aload_1
    //   86: astore_3
    //   87: aload_3
    //   88: invokevirtual 71	java/io/ObjectOutputStream:close	()V
    //   91: goto +95 -> 186
    //   94: astore_3
    //   95: goto +12 -> 107
    //   98: astore_1
    //   99: aconst_null
    //   100: astore_2
    //   101: goto +89 -> 190
    //   104: astore_3
    //   105: aconst_null
    //   106: astore_1
    //   107: aload_1
    //   108: astore_2
    //   109: aload_3
    //   110: invokevirtual 74	java/lang/Exception:printStackTrace	()V
    //   113: aload_1
    //   114: astore_2
    //   115: new 76	java/lang/StringBuilder
    //   118: dup
    //   119: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   122: astore 5
    //   124: aload_1
    //   125: astore_2
    //   126: aload 5
    //   128: ldc 79
    //   130: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: pop
    //   134: aload_1
    //   135: astore_2
    //   136: aload 5
    //   138: aload_3
    //   139: invokevirtual 87	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   142: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: pop
    //   146: aload_1
    //   147: astore_2
    //   148: ldc 62
    //   150: iconst_2
    //   151: aload 5
    //   153: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   156: invokestatic 93	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   159: aload_1
    //   160: astore_2
    //   161: aload 4
    //   163: invokevirtual 35	java/io/File:exists	()Z
    //   166: ifeq +11 -> 177
    //   169: aload_1
    //   170: astore_2
    //   171: aload 4
    //   173: invokevirtual 38	java/io/File:delete	()Z
    //   176: pop
    //   177: aload_1
    //   178: ifnull +8 -> 186
    //   181: aload_1
    //   182: astore_3
    //   183: goto -96 -> 87
    //   186: aload_0
    //   187: monitorexit
    //   188: return
    //   189: astore_1
    //   190: aload_2
    //   191: ifnull +7 -> 198
    //   194: aload_2
    //   195: invokevirtual 71	java/io/ObjectOutputStream:close	()V
    //   198: aload_1
    //   199: athrow
    //   200: astore_1
    //   201: aload_0
    //   202: monitorexit
    //   203: goto +5 -> 208
    //   206: aload_1
    //   207: athrow
    //   208: goto -2 -> 206
    //   211: astore_1
    //   212: goto -26 -> 186
    //   215: astore_2
    //   216: goto -18 -> 198
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	219	0	this	1
    //   54	32	1	localObjectOutputStream1	java.io.ObjectOutputStream
    //   98	1	1	localObject1	Object
    //   106	76	1	localObject2	Object
    //   189	10	1	localObject3	Object
    //   200	7	1	localObject4	Object
    //   211	1	1	localIOException1	java.io.IOException
    //   56	139	2	localObject5	Object
    //   215	1	2	localIOException2	java.io.IOException
    //   66	22	3	localObjectOutputStream2	java.io.ObjectOutputStream
    //   94	1	3	localException1	java.lang.Exception
    //   104	35	3	localException2	java.lang.Exception
    //   182	1	3	localObject6	Object
    //   15	157	4	localFile	java.io.File
    //   122	30	5	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   57	65	94	java/lang/Exception
    //   69	75	94	java/lang/Exception
    //   77	85	94	java/lang/Exception
    //   31	55	98	finally
    //   31	55	104	java/lang/Exception
    //   57	65	189	finally
    //   69	75	189	finally
    //   77	85	189	finally
    //   109	113	189	finally
    //   115	124	189	finally
    //   126	134	189	finally
    //   136	146	189	finally
    //   148	159	189	finally
    //   161	169	189	finally
    //   171	177	189	finally
    //   2	31	200	finally
    //   87	91	200	finally
    //   186	188	200	finally
    //   194	198	200	finally
    //   198	200	200	finally
    //   201	203	200	finally
    //   87	91	211	java/io/IOException
    //   194	198	215	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.data.QIMRedDotConfig.1
 * JD-Core Version:    0.7.0.1
 */