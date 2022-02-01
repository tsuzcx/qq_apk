package com.tencent.ad.tangram.util;

public final class b
{
  private static final String TAG = "AdFileUtils";
  
  /* Error */
  public static String read(java.io.File paramFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +181 -> 182
    //   4: aload_0
    //   5: invokevirtual 25	java/io/File:exists	()Z
    //   8: ifeq +174 -> 182
    //   11: new 27	java/io/FileInputStream
    //   14: dup
    //   15: aload_0
    //   16: invokespecial 30	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   19: astore_1
    //   20: aload_1
    //   21: astore_0
    //   22: aload_1
    //   23: invokevirtual 34	java/io/FileInputStream:available	()I
    //   26: newarray byte
    //   28: astore_2
    //   29: aload_1
    //   30: astore_0
    //   31: aload_1
    //   32: aload_2
    //   33: invokevirtual 37	java/io/FileInputStream:read	([B)I
    //   36: pop
    //   37: aload_1
    //   38: astore_0
    //   39: aload_1
    //   40: invokevirtual 40	java/io/FileInputStream:close	()V
    //   43: aload_1
    //   44: astore_0
    //   45: new 42	java/lang/String
    //   48: dup
    //   49: aload_2
    //   50: ldc 44
    //   52: invokespecial 47	java/lang/String:<init>	([BLjava/lang/String;)V
    //   55: astore_2
    //   56: aload_1
    //   57: ifnull +7 -> 64
    //   60: aload_1
    //   61: invokevirtual 40	java/io/FileInputStream:close	()V
    //   64: aload_2
    //   65: areturn
    //   66: astore_0
    //   67: ldc 8
    //   69: ldc 49
    //   71: aload_0
    //   72: invokestatic 55	com/tencent/ad/tangram/log/AdLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   75: aload_2
    //   76: areturn
    //   77: astore_2
    //   78: aconst_null
    //   79: astore_1
    //   80: aload_1
    //   81: astore_0
    //   82: ldc 8
    //   84: ldc 49
    //   86: aload_2
    //   87: invokestatic 55	com/tencent/ad/tangram/log/AdLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   90: aload_1
    //   91: ifnull +91 -> 182
    //   94: aload_1
    //   95: invokevirtual 40	java/io/FileInputStream:close	()V
    //   98: aconst_null
    //   99: areturn
    //   100: astore_0
    //   101: ldc 8
    //   103: ldc 49
    //   105: aload_0
    //   106: invokestatic 55	com/tencent/ad/tangram/log/AdLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   109: aconst_null
    //   110: areturn
    //   111: astore_2
    //   112: aconst_null
    //   113: astore_1
    //   114: aload_1
    //   115: astore_0
    //   116: ldc 8
    //   118: ldc 49
    //   120: aload_2
    //   121: invokestatic 55	com/tencent/ad/tangram/log/AdLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   124: aload_1
    //   125: ifnull +57 -> 182
    //   128: aload_1
    //   129: invokevirtual 40	java/io/FileInputStream:close	()V
    //   132: aconst_null
    //   133: areturn
    //   134: astore_0
    //   135: ldc 8
    //   137: ldc 49
    //   139: aload_0
    //   140: invokestatic 55	com/tencent/ad/tangram/log/AdLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   143: aconst_null
    //   144: areturn
    //   145: astore_1
    //   146: aconst_null
    //   147: astore_0
    //   148: aload_0
    //   149: ifnull +7 -> 156
    //   152: aload_0
    //   153: invokevirtual 40	java/io/FileInputStream:close	()V
    //   156: aload_1
    //   157: athrow
    //   158: astore_0
    //   159: ldc 8
    //   161: ldc 49
    //   163: aload_0
    //   164: invokestatic 55	com/tencent/ad/tangram/log/AdLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   167: goto -11 -> 156
    //   170: astore_1
    //   171: goto -23 -> 148
    //   174: astore_2
    //   175: goto -61 -> 114
    //   178: astore_2
    //   179: goto -99 -> 80
    //   182: aconst_null
    //   183: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	184	0	paramFile	java.io.File
    //   19	110	1	localFileInputStream	java.io.FileInputStream
    //   145	12	1	localObject1	Object
    //   170	1	1	localObject2	Object
    //   28	48	2	localObject3	Object
    //   77	10	2	localFileNotFoundException1	java.io.FileNotFoundException
    //   111	10	2	localIOException1	java.io.IOException
    //   174	1	2	localIOException2	java.io.IOException
    //   178	1	2	localFileNotFoundException2	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   60	64	66	java/io/IOException
    //   11	20	77	java/io/FileNotFoundException
    //   94	98	100	java/io/IOException
    //   11	20	111	java/io/IOException
    //   128	132	134	java/io/IOException
    //   11	20	145	finally
    //   152	156	158	java/io/IOException
    //   22	29	170	finally
    //   31	37	170	finally
    //   39	43	170	finally
    //   45	56	170	finally
    //   82	90	170	finally
    //   116	124	170	finally
    //   22	29	174	java/io/IOException
    //   31	37	174	java/io/IOException
    //   39	43	174	java/io/IOException
    //   45	56	174	java/io/IOException
    //   22	29	178	java/io/FileNotFoundException
    //   31	37	178	java/io/FileNotFoundException
    //   39	43	178	java/io/FileNotFoundException
    //   45	56	178	java/io/FileNotFoundException
  }
  
  /* Error */
  public static void write(java.io.File paramFile, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +51 -> 52
    //   4: aload_1
    //   5: invokestatic 63	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8: ifne +44 -> 52
    //   11: new 65	java/io/FileOutputStream
    //   14: dup
    //   15: aload_0
    //   16: invokespecial 66	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   19: astore_2
    //   20: aload_2
    //   21: astore_0
    //   22: aload_2
    //   23: aload_1
    //   24: ldc 68
    //   26: invokevirtual 72	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   29: invokevirtual 75	java/io/FileOutputStream:write	([B)V
    //   32: aload_2
    //   33: astore_0
    //   34: aload_2
    //   35: invokevirtual 78	java/io/FileOutputStream:flush	()V
    //   38: aload_2
    //   39: astore_0
    //   40: aload_2
    //   41: invokevirtual 79	java/io/FileOutputStream:close	()V
    //   44: aload_2
    //   45: ifnull +7 -> 52
    //   48: aload_2
    //   49: invokevirtual 79	java/io/FileOutputStream:close	()V
    //   52: return
    //   53: astore_0
    //   54: ldc 8
    //   56: ldc 81
    //   58: aload_0
    //   59: invokestatic 55	com/tencent/ad/tangram/log/AdLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   62: return
    //   63: astore_1
    //   64: aconst_null
    //   65: astore_2
    //   66: aload_2
    //   67: astore_0
    //   68: ldc 8
    //   70: ldc 81
    //   72: aload_1
    //   73: invokestatic 55	com/tencent/ad/tangram/log/AdLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   76: aload_2
    //   77: ifnull -25 -> 52
    //   80: aload_2
    //   81: invokevirtual 79	java/io/FileOutputStream:close	()V
    //   84: return
    //   85: astore_0
    //   86: ldc 8
    //   88: ldc 81
    //   90: aload_0
    //   91: invokestatic 55	com/tencent/ad/tangram/log/AdLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   94: return
    //   95: astore_1
    //   96: aconst_null
    //   97: astore_2
    //   98: aload_2
    //   99: astore_0
    //   100: ldc 8
    //   102: ldc 81
    //   104: aload_1
    //   105: invokestatic 55	com/tencent/ad/tangram/log/AdLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   108: aload_2
    //   109: ifnull -57 -> 52
    //   112: aload_2
    //   113: invokevirtual 79	java/io/FileOutputStream:close	()V
    //   116: return
    //   117: astore_0
    //   118: ldc 8
    //   120: ldc 81
    //   122: aload_0
    //   123: invokestatic 55	com/tencent/ad/tangram/log/AdLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   126: return
    //   127: astore_1
    //   128: aconst_null
    //   129: astore_0
    //   130: aload_0
    //   131: ifnull +7 -> 138
    //   134: aload_0
    //   135: invokevirtual 79	java/io/FileOutputStream:close	()V
    //   138: aload_1
    //   139: athrow
    //   140: astore_0
    //   141: ldc 8
    //   143: ldc 81
    //   145: aload_0
    //   146: invokestatic 55	com/tencent/ad/tangram/log/AdLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   149: goto -11 -> 138
    //   152: astore_1
    //   153: goto -23 -> 130
    //   156: astore_1
    //   157: goto -59 -> 98
    //   160: astore_1
    //   161: goto -95 -> 66
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	164	0	paramFile	java.io.File
    //   0	164	1	paramString	String
    //   19	94	2	localFileOutputStream	java.io.FileOutputStream
    // Exception table:
    //   from	to	target	type
    //   48	52	53	java/io/IOException
    //   11	20	63	java/io/FileNotFoundException
    //   80	84	85	java/io/IOException
    //   11	20	95	java/io/IOException
    //   112	116	117	java/io/IOException
    //   11	20	127	finally
    //   134	138	140	java/io/IOException
    //   22	32	152	finally
    //   34	38	152	finally
    //   40	44	152	finally
    //   68	76	152	finally
    //   100	108	152	finally
    //   22	32	156	java/io/IOException
    //   34	38	156	java/io/IOException
    //   40	44	156	java/io/IOException
    //   22	32	160	java/io/FileNotFoundException
    //   34	38	160	java/io/FileNotFoundException
    //   40	44	160	java/io/FileNotFoundException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ad.tangram.util.b
 * JD-Core Version:    0.7.0.1
 */