import dov.com.qq.im.capture.data.QIMRedDotConfig;

public final class amvn
  implements Runnable
{
  public amvn(String paramString, QIMRedDotConfig paramQIMRedDotConfig) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 26	java/io/File
    //   5: dup
    //   6: aload_0
    //   7: getfield 13	amvn:jdField_a_of_type_JavaLangString	Ljava/lang/String;
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
    //   54: astore_2
    //   55: aload_2
    //   56: astore_1
    //   57: aload_2
    //   58: aload_0
    //   59: getfield 15	amvn:jdField_a_of_type_DovComQqImCaptureDataQIMRedDotConfig	Ldov/com/qq/im/capture/data/QIMRedDotConfig;
    //   62: invokevirtual 55	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   65: aload_2
    //   66: astore_1
    //   67: invokestatic 60	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   70: ifeq +13 -> 83
    //   73: aload_2
    //   74: astore_1
    //   75: ldc 62
    //   77: iconst_2
    //   78: ldc 64
    //   80: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   83: aload_2
    //   84: ifnull +7 -> 91
    //   87: aload_2
    //   88: invokevirtual 71	java/io/ObjectOutputStream:close	()V
    //   91: aload_0
    //   92: monitorexit
    //   93: return
    //   94: astore_3
    //   95: aconst_null
    //   96: astore_2
    //   97: aload_2
    //   98: astore_1
    //   99: aload_3
    //   100: invokevirtual 74	java/lang/Exception:printStackTrace	()V
    //   103: aload_2
    //   104: astore_1
    //   105: ldc 62
    //   107: iconst_2
    //   108: new 76	java/lang/StringBuilder
    //   111: dup
    //   112: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   115: ldc 79
    //   117: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: aload_3
    //   121: invokevirtual 87	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   124: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   130: invokestatic 93	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   133: aload_2
    //   134: astore_1
    //   135: aload 4
    //   137: invokevirtual 35	java/io/File:exists	()Z
    //   140: ifeq +11 -> 151
    //   143: aload_2
    //   144: astore_1
    //   145: aload 4
    //   147: invokevirtual 38	java/io/File:delete	()Z
    //   150: pop
    //   151: aload_2
    //   152: ifnull -61 -> 91
    //   155: aload_2
    //   156: invokevirtual 71	java/io/ObjectOutputStream:close	()V
    //   159: goto -68 -> 91
    //   162: astore_1
    //   163: goto -72 -> 91
    //   166: astore_2
    //   167: aconst_null
    //   168: astore_1
    //   169: aload_1
    //   170: ifnull +7 -> 177
    //   173: aload_1
    //   174: invokevirtual 71	java/io/ObjectOutputStream:close	()V
    //   177: aload_2
    //   178: athrow
    //   179: astore_1
    //   180: aload_0
    //   181: monitorexit
    //   182: aload_1
    //   183: athrow
    //   184: astore_1
    //   185: goto -94 -> 91
    //   188: astore_1
    //   189: goto -12 -> 177
    //   192: astore_2
    //   193: goto -24 -> 169
    //   196: astore_3
    //   197: goto -100 -> 97
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	200	0	this	amvn
    //   56	89	1	localObjectOutputStream1	java.io.ObjectOutputStream
    //   162	1	1	localIOException1	java.io.IOException
    //   168	6	1	localObject1	Object
    //   179	4	1	localObject2	Object
    //   184	1	1	localIOException2	java.io.IOException
    //   188	1	1	localIOException3	java.io.IOException
    //   54	102	2	localObjectOutputStream2	java.io.ObjectOutputStream
    //   166	12	2	localObject3	Object
    //   192	1	2	localObject4	Object
    //   94	27	3	localException1	java.lang.Exception
    //   196	1	3	localException2	java.lang.Exception
    //   15	131	4	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   31	55	94	java/lang/Exception
    //   155	159	162	java/io/IOException
    //   31	55	166	finally
    //   2	31	179	finally
    //   87	91	179	finally
    //   91	93	179	finally
    //   155	159	179	finally
    //   173	177	179	finally
    //   177	179	179	finally
    //   180	182	179	finally
    //   87	91	184	java/io/IOException
    //   173	177	188	java/io/IOException
    //   57	65	192	finally
    //   67	73	192	finally
    //   75	83	192	finally
    //   99	103	192	finally
    //   105	133	192	finally
    //   135	143	192	finally
    //   145	151	192	finally
    //   57	65	196	java/lang/Exception
    //   67	73	196	java/lang/Exception
    //   75	83	196	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     amvn
 * JD-Core Version:    0.7.0.1
 */