import dov.com.tencent.mobileqq.richmedia.capture.data.CaptureRedDotConfig;

public final class anvh
  implements Runnable
{
  public anvh(String paramString1, CaptureRedDotConfig paramCaptureRedDotConfig, String paramString2) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 29	java/io/File
    //   5: dup
    //   6: aload_0
    //   7: getfield 14	anvh:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   10: ldc 31
    //   12: invokespecial 34	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   15: astore 4
    //   17: aload 4
    //   19: invokevirtual 38	java/io/File:exists	()Z
    //   22: ifeq +9 -> 31
    //   25: aload 4
    //   27: invokevirtual 41	java/io/File:delete	()Z
    //   30: pop
    //   31: new 43	java/io/ObjectOutputStream
    //   34: dup
    //   35: new 45	java/io/BufferedOutputStream
    //   38: dup
    //   39: new 47	java/io/FileOutputStream
    //   42: dup
    //   43: aload 4
    //   45: invokespecial 50	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   48: invokespecial 53	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   51: invokespecial 54	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   54: astore_2
    //   55: aload_2
    //   56: astore_1
    //   57: aload_2
    //   58: aload_0
    //   59: getfield 16	anvh:jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig	Ldov/com/tencent/mobileqq/richmedia/capture/data/CaptureRedDotConfig;
    //   62: invokevirtual 58	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   65: aload_2
    //   66: astore_1
    //   67: invokestatic 63	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   70: ifeq +33 -> 103
    //   73: aload_2
    //   74: astore_1
    //   75: new 65	java/lang/StringBuilder
    //   78: dup
    //   79: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   82: ldc 68
    //   84: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: aload_0
    //   88: getfield 18	anvh:b	Ljava/lang/String;
    //   91: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   97: iconst_2
    //   98: ldc 78
    //   100: invokestatic 82	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   103: aload_2
    //   104: ifnull +7 -> 111
    //   107: aload_2
    //   108: invokevirtual 85	java/io/ObjectOutputStream:close	()V
    //   111: aload_0
    //   112: monitorexit
    //   113: return
    //   114: astore_3
    //   115: aconst_null
    //   116: astore_2
    //   117: aload_2
    //   118: astore_1
    //   119: aload_3
    //   120: invokevirtual 88	java/lang/Exception:printStackTrace	()V
    //   123: aload_2
    //   124: astore_1
    //   125: ldc 68
    //   127: iconst_2
    //   128: new 65	java/lang/StringBuilder
    //   131: dup
    //   132: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   135: ldc 90
    //   137: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: aload_3
    //   141: invokevirtual 93	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   144: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   150: invokestatic 96	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   153: aload_2
    //   154: astore_1
    //   155: aload 4
    //   157: invokevirtual 38	java/io/File:exists	()Z
    //   160: ifeq +11 -> 171
    //   163: aload_2
    //   164: astore_1
    //   165: aload 4
    //   167: invokevirtual 41	java/io/File:delete	()Z
    //   170: pop
    //   171: aload_2
    //   172: ifnull -61 -> 111
    //   175: aload_2
    //   176: invokevirtual 85	java/io/ObjectOutputStream:close	()V
    //   179: goto -68 -> 111
    //   182: astore_1
    //   183: goto -72 -> 111
    //   186: astore_2
    //   187: aconst_null
    //   188: astore_1
    //   189: aload_1
    //   190: ifnull +7 -> 197
    //   193: aload_1
    //   194: invokevirtual 85	java/io/ObjectOutputStream:close	()V
    //   197: aload_2
    //   198: athrow
    //   199: astore_1
    //   200: aload_0
    //   201: monitorexit
    //   202: aload_1
    //   203: athrow
    //   204: astore_1
    //   205: goto -94 -> 111
    //   208: astore_1
    //   209: goto -12 -> 197
    //   212: astore_2
    //   213: goto -24 -> 189
    //   216: astore_3
    //   217: goto -100 -> 117
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	220	0	this	anvh
    //   56	109	1	localObjectOutputStream1	java.io.ObjectOutputStream
    //   182	1	1	localIOException1	java.io.IOException
    //   188	6	1	localObject1	Object
    //   199	4	1	localObject2	Object
    //   204	1	1	localIOException2	java.io.IOException
    //   208	1	1	localIOException3	java.io.IOException
    //   54	122	2	localObjectOutputStream2	java.io.ObjectOutputStream
    //   186	12	2	localObject3	Object
    //   212	1	2	localObject4	Object
    //   114	27	3	localException1	java.lang.Exception
    //   216	1	3	localException2	java.lang.Exception
    //   15	151	4	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   31	55	114	java/lang/Exception
    //   175	179	182	java/io/IOException
    //   31	55	186	finally
    //   2	31	199	finally
    //   107	111	199	finally
    //   111	113	199	finally
    //   175	179	199	finally
    //   193	197	199	finally
    //   197	199	199	finally
    //   200	202	199	finally
    //   107	111	204	java/io/IOException
    //   193	197	208	java/io/IOException
    //   57	65	212	finally
    //   67	73	212	finally
    //   75	103	212	finally
    //   119	123	212	finally
    //   125	153	212	finally
    //   155	163	212	finally
    //   165	171	212	finally
    //   57	65	216	java/lang/Exception
    //   67	73	216	java/lang/Exception
    //   75	103	216	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anvh
 * JD-Core Version:    0.7.0.1
 */