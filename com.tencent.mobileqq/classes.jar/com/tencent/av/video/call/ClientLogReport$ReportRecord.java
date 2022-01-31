package com.tencent.av.video.call;

import java.io.Serializable;

class ClientLogReport$ReportRecord
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  byte[] mLog;
  long mTimestamp;
  int mTopicId;
  long mUin;
  
  /* Error */
  public static ReportRecord readFromFile(java.io.File paramFile)
  {
    // Byte code:
    //   0: new 29	java/io/FileInputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 32	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   8: astore_1
    //   9: new 34	java/io/ObjectInputStream
    //   12: dup
    //   13: aload_1
    //   14: invokespecial 37	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   17: astore_0
    //   18: aload_0
    //   19: astore_3
    //   20: aload_1
    //   21: astore_2
    //   22: aload_0
    //   23: invokevirtual 41	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   26: checkcast 2	com/tencent/av/video/call/ClientLogReport$ReportRecord
    //   29: astore 4
    //   31: aload_1
    //   32: ifnull +7 -> 39
    //   35: aload_1
    //   36: invokevirtual 44	java/io/FileInputStream:close	()V
    //   39: aload_0
    //   40: ifnull +7 -> 47
    //   43: aload_0
    //   44: invokevirtual 45	java/io/ObjectInputStream:close	()V
    //   47: aload 4
    //   49: areturn
    //   50: astore 4
    //   52: aconst_null
    //   53: astore_0
    //   54: aconst_null
    //   55: astore_1
    //   56: aload_0
    //   57: astore_3
    //   58: aload_1
    //   59: astore_2
    //   60: ldc 47
    //   62: iconst_1
    //   63: ldc 49
    //   65: aload 4
    //   67: invokestatic 55	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   70: aload_1
    //   71: ifnull +7 -> 78
    //   74: aload_1
    //   75: invokevirtual 44	java/io/FileInputStream:close	()V
    //   78: aload_0
    //   79: ifnull +79 -> 158
    //   82: aload_0
    //   83: invokevirtual 45	java/io/ObjectInputStream:close	()V
    //   86: aconst_null
    //   87: areturn
    //   88: astore_0
    //   89: aconst_null
    //   90: areturn
    //   91: astore_0
    //   92: aconst_null
    //   93: astore_3
    //   94: aconst_null
    //   95: astore_1
    //   96: aload_1
    //   97: ifnull +7 -> 104
    //   100: aload_1
    //   101: invokevirtual 44	java/io/FileInputStream:close	()V
    //   104: aload_3
    //   105: ifnull +7 -> 112
    //   108: aload_3
    //   109: invokevirtual 45	java/io/ObjectInputStream:close	()V
    //   112: aload_0
    //   113: athrow
    //   114: astore_1
    //   115: goto -76 -> 39
    //   118: astore_0
    //   119: aload 4
    //   121: areturn
    //   122: astore_1
    //   123: goto -45 -> 78
    //   126: astore_1
    //   127: goto -23 -> 104
    //   130: astore_1
    //   131: goto -19 -> 112
    //   134: astore_0
    //   135: aconst_null
    //   136: astore_3
    //   137: goto -41 -> 96
    //   140: astore_0
    //   141: aload_2
    //   142: astore_1
    //   143: goto -47 -> 96
    //   146: astore 4
    //   148: aconst_null
    //   149: astore_0
    //   150: goto -94 -> 56
    //   153: astore 4
    //   155: goto -99 -> 56
    //   158: aconst_null
    //   159: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	160	0	paramFile	java.io.File
    //   8	93	1	localFileInputStream1	java.io.FileInputStream
    //   114	1	1	localThrowable1	java.lang.Throwable
    //   122	1	1	localThrowable2	java.lang.Throwable
    //   126	1	1	localThrowable3	java.lang.Throwable
    //   130	1	1	localThrowable4	java.lang.Throwable
    //   142	1	1	localObject	Object
    //   21	121	2	localFileInputStream2	java.io.FileInputStream
    //   19	118	3	localFile	java.io.File
    //   29	19	4	localReportRecord	ReportRecord
    //   50	70	4	localThrowable5	java.lang.Throwable
    //   146	1	4	localThrowable6	java.lang.Throwable
    //   153	1	4	localThrowable7	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   0	9	50	java/lang/Throwable
    //   82	86	88	java/lang/Throwable
    //   0	9	91	finally
    //   35	39	114	java/lang/Throwable
    //   43	47	118	java/lang/Throwable
    //   74	78	122	java/lang/Throwable
    //   100	104	126	java/lang/Throwable
    //   108	112	130	java/lang/Throwable
    //   9	18	134	finally
    //   22	31	140	finally
    //   60	70	140	finally
    //   9	18	146	java/lang/Throwable
    //   22	31	153	java/lang/Throwable
  }
  
  public String toString()
  {
    return String.format("ReportRecord{mUin=%s mTopicId=%s mLog=%s mTimestamp=%s}", new Object[] { Long.valueOf(this.mUin), Integer.valueOf(this.mTopicId), this.mLog, Long.valueOf(this.mTimestamp) });
  }
  
  /* Error */
  public void writeToFile(java.io.File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore_3
    //   4: new 87	java/io/FileOutputStream
    //   7: dup
    //   8: aload_1
    //   9: invokespecial 88	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   12: astore_1
    //   13: new 90	java/io/ObjectOutputStream
    //   16: dup
    //   17: aload_1
    //   18: invokespecial 93	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   21: astore_2
    //   22: aload_2
    //   23: aload_0
    //   24: invokevirtual 97	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   27: aload_2
    //   28: invokevirtual 100	java/io/ObjectOutputStream:flush	()V
    //   31: aload_1
    //   32: ifnull +7 -> 39
    //   35: aload_1
    //   36: invokevirtual 101	java/io/FileOutputStream:close	()V
    //   39: aload_2
    //   40: ifnull +7 -> 47
    //   43: aload_2
    //   44: invokevirtual 102	java/io/ObjectOutputStream:close	()V
    //   47: return
    //   48: astore_1
    //   49: aconst_null
    //   50: astore_2
    //   51: ldc 47
    //   53: iconst_1
    //   54: ldc 104
    //   56: aload_1
    //   57: invokestatic 55	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   60: aload_3
    //   61: ifnull +7 -> 68
    //   64: aload_3
    //   65: invokevirtual 101	java/io/FileOutputStream:close	()V
    //   68: aload_2
    //   69: ifnull -22 -> 47
    //   72: aload_2
    //   73: invokevirtual 102	java/io/ObjectOutputStream:close	()V
    //   76: return
    //   77: astore_1
    //   78: return
    //   79: astore_1
    //   80: aconst_null
    //   81: astore 4
    //   83: aload_2
    //   84: astore_3
    //   85: aload 4
    //   87: astore_2
    //   88: aload_3
    //   89: ifnull +7 -> 96
    //   92: aload_3
    //   93: invokevirtual 101	java/io/FileOutputStream:close	()V
    //   96: aload_2
    //   97: ifnull +7 -> 104
    //   100: aload_2
    //   101: invokevirtual 102	java/io/ObjectOutputStream:close	()V
    //   104: aload_1
    //   105: athrow
    //   106: astore_1
    //   107: goto -68 -> 39
    //   110: astore_1
    //   111: return
    //   112: astore_1
    //   113: goto -45 -> 68
    //   116: astore_3
    //   117: goto -21 -> 96
    //   120: astore_2
    //   121: goto -17 -> 104
    //   124: astore 4
    //   126: aconst_null
    //   127: astore_2
    //   128: aload_1
    //   129: astore_3
    //   130: aload 4
    //   132: astore_1
    //   133: goto -45 -> 88
    //   136: astore 4
    //   138: aload_1
    //   139: astore_3
    //   140: aload 4
    //   142: astore_1
    //   143: goto -55 -> 88
    //   146: astore_1
    //   147: goto -59 -> 88
    //   150: astore 4
    //   152: aconst_null
    //   153: astore_2
    //   154: aload_1
    //   155: astore_3
    //   156: aload 4
    //   158: astore_1
    //   159: goto -108 -> 51
    //   162: astore 4
    //   164: aload_1
    //   165: astore_3
    //   166: aload 4
    //   168: astore_1
    //   169: goto -118 -> 51
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	172	0	this	ReportRecord
    //   0	172	1	paramFile	java.io.File
    //   1	100	2	localObject1	Object
    //   120	1	2	localThrowable1	java.lang.Throwable
    //   127	27	2	localObject2	Object
    //   3	90	3	localObject3	Object
    //   116	1	3	localThrowable2	java.lang.Throwable
    //   129	37	3	localFile	java.io.File
    //   81	5	4	localObject4	Object
    //   124	7	4	localObject5	Object
    //   136	5	4	localObject6	Object
    //   150	7	4	localThrowable3	java.lang.Throwable
    //   162	5	4	localThrowable4	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   4	13	48	java/lang/Throwable
    //   72	76	77	java/lang/Throwable
    //   4	13	79	finally
    //   35	39	106	java/lang/Throwable
    //   43	47	110	java/lang/Throwable
    //   64	68	112	java/lang/Throwable
    //   92	96	116	java/lang/Throwable
    //   100	104	120	java/lang/Throwable
    //   13	22	124	finally
    //   22	31	136	finally
    //   51	60	146	finally
    //   13	22	150	java/lang/Throwable
    //   22	31	162	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.video.call.ClientLogReport.ReportRecord
 * JD-Core Version:    0.7.0.1
 */