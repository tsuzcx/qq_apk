package com.tencent.aelight.camera.aioeditor.richmedia.capture.data;

final class CaptureRedDotConfig$1
  implements Runnable
{
  CaptureRedDotConfig$1(String paramString1, CaptureRedDotConfig paramCaptureRedDotConfig, String paramString2) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 30	java/io/File
    //   5: dup
    //   6: aload_0
    //   7: getfield 15	com/tencent/aelight/camera/aioeditor/richmedia/capture/data/CaptureRedDotConfig$1:a	Ljava/lang/String;
    //   10: ldc 32
    //   12: invokespecial 35	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   15: astore 4
    //   17: aload 4
    //   19: invokevirtual 39	java/io/File:exists	()Z
    //   22: ifeq +9 -> 31
    //   25: aload 4
    //   27: invokevirtual 42	java/io/File:delete	()Z
    //   30: pop
    //   31: new 44	java/io/ObjectOutputStream
    //   34: dup
    //   35: new 46	java/io/BufferedOutputStream
    //   38: dup
    //   39: new 48	java/io/FileOutputStream
    //   42: dup
    //   43: aload 4
    //   45: invokespecial 51	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   48: invokespecial 54	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   51: invokespecial 55	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   54: astore_1
    //   55: aload_1
    //   56: astore_2
    //   57: aload_1
    //   58: aload_0
    //   59: getfield 17	com/tencent/aelight/camera/aioeditor/richmedia/capture/data/CaptureRedDotConfig$1:b	Lcom/tencent/aelight/camera/aioeditor/richmedia/capture/data/CaptureRedDotConfig;
    //   62: invokevirtual 59	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   65: aload_1
    //   66: astore_3
    //   67: aload_1
    //   68: astore_2
    //   69: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   72: ifeq +47 -> 119
    //   75: aload_1
    //   76: astore_2
    //   77: new 66	java/lang/StringBuilder
    //   80: dup
    //   81: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   84: astore_3
    //   85: aload_1
    //   86: astore_2
    //   87: aload_3
    //   88: ldc 69
    //   90: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: pop
    //   94: aload_1
    //   95: astore_2
    //   96: aload_3
    //   97: aload_0
    //   98: getfield 19	com/tencent/aelight/camera/aioeditor/richmedia/capture/data/CaptureRedDotConfig$1:c	Ljava/lang/String;
    //   101: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: pop
    //   105: aload_1
    //   106: astore_2
    //   107: aload_3
    //   108: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   111: iconst_2
    //   112: ldc 79
    //   114: invokestatic 83	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   117: aload_1
    //   118: astore_3
    //   119: aload_3
    //   120: invokevirtual 86	java/io/ObjectOutputStream:close	()V
    //   123: goto +95 -> 218
    //   126: astore_3
    //   127: goto +12 -> 139
    //   130: astore_1
    //   131: aconst_null
    //   132: astore_2
    //   133: goto +89 -> 222
    //   136: astore_3
    //   137: aconst_null
    //   138: astore_1
    //   139: aload_1
    //   140: astore_2
    //   141: aload_3
    //   142: invokevirtual 89	java/lang/Exception:printStackTrace	()V
    //   145: aload_1
    //   146: astore_2
    //   147: new 66	java/lang/StringBuilder
    //   150: dup
    //   151: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   154: astore 5
    //   156: aload_1
    //   157: astore_2
    //   158: aload 5
    //   160: ldc 91
    //   162: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: pop
    //   166: aload_1
    //   167: astore_2
    //   168: aload 5
    //   170: aload_3
    //   171: invokevirtual 94	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   174: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: pop
    //   178: aload_1
    //   179: astore_2
    //   180: ldc 69
    //   182: iconst_2
    //   183: aload 5
    //   185: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   188: invokestatic 97	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   191: aload_1
    //   192: astore_2
    //   193: aload 4
    //   195: invokevirtual 39	java/io/File:exists	()Z
    //   198: ifeq +11 -> 209
    //   201: aload_1
    //   202: astore_2
    //   203: aload 4
    //   205: invokevirtual 42	java/io/File:delete	()Z
    //   208: pop
    //   209: aload_1
    //   210: ifnull +8 -> 218
    //   213: aload_1
    //   214: astore_3
    //   215: goto -96 -> 119
    //   218: aload_0
    //   219: monitorexit
    //   220: return
    //   221: astore_1
    //   222: aload_2
    //   223: ifnull +7 -> 230
    //   226: aload_2
    //   227: invokevirtual 86	java/io/ObjectOutputStream:close	()V
    //   230: aload_1
    //   231: athrow
    //   232: astore_1
    //   233: aload_0
    //   234: monitorexit
    //   235: goto +5 -> 240
    //   238: aload_1
    //   239: athrow
    //   240: goto -2 -> 238
    //   243: astore_1
    //   244: goto -26 -> 218
    //   247: astore_2
    //   248: goto -18 -> 230
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	251	0	this	1
    //   54	64	1	localObjectOutputStream	java.io.ObjectOutputStream
    //   130	1	1	localObject1	Object
    //   138	76	1	localObject2	Object
    //   221	10	1	localObject3	Object
    //   232	7	1	localObject4	Object
    //   243	1	1	localIOException1	java.io.IOException
    //   56	171	2	localObject5	Object
    //   247	1	2	localIOException2	java.io.IOException
    //   66	54	3	localObject6	Object
    //   126	1	3	localException1	java.lang.Exception
    //   136	35	3	localException2	java.lang.Exception
    //   214	1	3	localObject7	Object
    //   15	189	4	localFile	java.io.File
    //   154	30	5	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   57	65	126	java/lang/Exception
    //   69	75	126	java/lang/Exception
    //   77	85	126	java/lang/Exception
    //   87	94	126	java/lang/Exception
    //   96	105	126	java/lang/Exception
    //   107	117	126	java/lang/Exception
    //   31	55	130	finally
    //   31	55	136	java/lang/Exception
    //   57	65	221	finally
    //   69	75	221	finally
    //   77	85	221	finally
    //   87	94	221	finally
    //   96	105	221	finally
    //   107	117	221	finally
    //   141	145	221	finally
    //   147	156	221	finally
    //   158	166	221	finally
    //   168	178	221	finally
    //   180	191	221	finally
    //   193	201	221	finally
    //   203	209	221	finally
    //   2	31	232	finally
    //   119	123	232	finally
    //   218	220	232	finally
    //   226	230	232	finally
    //   230	232	232	finally
    //   233	235	232	finally
    //   119	123	243	java/io/IOException
    //   226	230	247	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.richmedia.capture.data.CaptureRedDotConfig.1
 * JD-Core Version:    0.7.0.1
 */