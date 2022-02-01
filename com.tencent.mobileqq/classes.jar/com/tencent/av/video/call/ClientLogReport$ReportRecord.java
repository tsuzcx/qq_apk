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
    //   0: new 27	java/io/FileInputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 30	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   8: astore_1
    //   9: new 32	java/io/ObjectInputStream
    //   12: dup
    //   13: aload_1
    //   14: invokespecial 35	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   17: astore_0
    //   18: aload_0
    //   19: astore_3
    //   20: aload_1
    //   21: astore_2
    //   22: aload_0
    //   23: invokevirtual 39	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   26: checkcast 2	com/tencent/av/video/call/ClientLogReport$ReportRecord
    //   29: astore 4
    //   31: aload_1
    //   32: ifnull +7 -> 39
    //   35: aload_1
    //   36: invokevirtual 42	java/io/FileInputStream:close	()V
    //   39: aload_0
    //   40: ifnull +7 -> 47
    //   43: aload_0
    //   44: invokevirtual 43	java/io/ObjectInputStream:close	()V
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
    //   60: ldc 45
    //   62: ldc 47
    //   64: aload 4
    //   66: invokestatic 53	com/tencent/avcore/util/AVCoreLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   69: aload_1
    //   70: ifnull +7 -> 77
    //   73: aload_1
    //   74: invokevirtual 42	java/io/FileInputStream:close	()V
    //   77: aload_0
    //   78: ifnull +79 -> 157
    //   81: aload_0
    //   82: invokevirtual 43	java/io/ObjectInputStream:close	()V
    //   85: aconst_null
    //   86: areturn
    //   87: astore_0
    //   88: aconst_null
    //   89: areturn
    //   90: astore_0
    //   91: aconst_null
    //   92: astore_3
    //   93: aconst_null
    //   94: astore_1
    //   95: aload_1
    //   96: ifnull +7 -> 103
    //   99: aload_1
    //   100: invokevirtual 42	java/io/FileInputStream:close	()V
    //   103: aload_3
    //   104: ifnull +7 -> 111
    //   107: aload_3
    //   108: invokevirtual 43	java/io/ObjectInputStream:close	()V
    //   111: aload_0
    //   112: athrow
    //   113: astore_1
    //   114: goto -75 -> 39
    //   117: astore_0
    //   118: aload 4
    //   120: areturn
    //   121: astore_1
    //   122: goto -45 -> 77
    //   125: astore_1
    //   126: goto -23 -> 103
    //   129: astore_1
    //   130: goto -19 -> 111
    //   133: astore_0
    //   134: aconst_null
    //   135: astore_3
    //   136: goto -41 -> 95
    //   139: astore_0
    //   140: aload_2
    //   141: astore_1
    //   142: goto -47 -> 95
    //   145: astore 4
    //   147: aconst_null
    //   148: astore_0
    //   149: goto -93 -> 56
    //   152: astore 4
    //   154: goto -98 -> 56
    //   157: aconst_null
    //   158: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	159	0	paramFile	java.io.File
    //   8	92	1	localFileInputStream1	java.io.FileInputStream
    //   113	1	1	localThrowable1	java.lang.Throwable
    //   121	1	1	localThrowable2	java.lang.Throwable
    //   125	1	1	localThrowable3	java.lang.Throwable
    //   129	1	1	localThrowable4	java.lang.Throwable
    //   141	1	1	localObject	Object
    //   21	120	2	localFileInputStream2	java.io.FileInputStream
    //   19	117	3	localFile	java.io.File
    //   29	19	4	localReportRecord	ReportRecord
    //   50	69	4	localThrowable5	java.lang.Throwable
    //   145	1	4	localThrowable6	java.lang.Throwable
    //   152	1	4	localThrowable7	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   0	9	50	java/lang/Throwable
    //   81	85	87	java/lang/Throwable
    //   0	9	90	finally
    //   35	39	113	java/lang/Throwable
    //   43	47	117	java/lang/Throwable
    //   73	77	121	java/lang/Throwable
    //   99	103	125	java/lang/Throwable
    //   107	111	129	java/lang/Throwable
    //   9	18	133	finally
    //   22	31	139	finally
    //   60	69	139	finally
    //   9	18	145	java/lang/Throwable
    //   22	31	152	java/lang/Throwable
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
    //   4: new 85	java/io/FileOutputStream
    //   7: dup
    //   8: aload_1
    //   9: invokespecial 86	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   12: astore_1
    //   13: new 88	java/io/ObjectOutputStream
    //   16: dup
    //   17: aload_1
    //   18: invokespecial 91	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   21: astore_2
    //   22: aload_2
    //   23: aload_0
    //   24: invokevirtual 95	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   27: aload_2
    //   28: invokevirtual 98	java/io/ObjectOutputStream:flush	()V
    //   31: aload_1
    //   32: ifnull +7 -> 39
    //   35: aload_1
    //   36: invokevirtual 99	java/io/FileOutputStream:close	()V
    //   39: aload_2
    //   40: ifnull +7 -> 47
    //   43: aload_2
    //   44: invokevirtual 100	java/io/ObjectOutputStream:close	()V
    //   47: return
    //   48: astore_1
    //   49: aconst_null
    //   50: astore_2
    //   51: ldc 45
    //   53: ldc 102
    //   55: aload_1
    //   56: invokestatic 53	com/tencent/avcore/util/AVCoreLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   59: aload_3
    //   60: ifnull +7 -> 67
    //   63: aload_3
    //   64: invokevirtual 99	java/io/FileOutputStream:close	()V
    //   67: aload_2
    //   68: ifnull -21 -> 47
    //   71: aload_2
    //   72: invokevirtual 100	java/io/ObjectOutputStream:close	()V
    //   75: return
    //   76: astore_1
    //   77: return
    //   78: astore_1
    //   79: aconst_null
    //   80: astore 4
    //   82: aload_2
    //   83: astore_3
    //   84: aload 4
    //   86: astore_2
    //   87: aload_3
    //   88: ifnull +7 -> 95
    //   91: aload_3
    //   92: invokevirtual 99	java/io/FileOutputStream:close	()V
    //   95: aload_2
    //   96: ifnull +7 -> 103
    //   99: aload_2
    //   100: invokevirtual 100	java/io/ObjectOutputStream:close	()V
    //   103: aload_1
    //   104: athrow
    //   105: astore_1
    //   106: goto -67 -> 39
    //   109: astore_1
    //   110: return
    //   111: astore_1
    //   112: goto -45 -> 67
    //   115: astore_3
    //   116: goto -21 -> 95
    //   119: astore_2
    //   120: goto -17 -> 103
    //   123: astore 4
    //   125: aconst_null
    //   126: astore_2
    //   127: aload_1
    //   128: astore_3
    //   129: aload 4
    //   131: astore_1
    //   132: goto -45 -> 87
    //   135: astore 4
    //   137: aload_1
    //   138: astore_3
    //   139: aload 4
    //   141: astore_1
    //   142: goto -55 -> 87
    //   145: astore_1
    //   146: goto -59 -> 87
    //   149: astore 4
    //   151: aconst_null
    //   152: astore_2
    //   153: aload_1
    //   154: astore_3
    //   155: aload 4
    //   157: astore_1
    //   158: goto -107 -> 51
    //   161: astore 4
    //   163: aload_1
    //   164: astore_3
    //   165: aload 4
    //   167: astore_1
    //   168: goto -117 -> 51
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	171	0	this	ReportRecord
    //   0	171	1	paramFile	java.io.File
    //   1	99	2	localObject1	Object
    //   119	1	2	localThrowable1	java.lang.Throwable
    //   126	27	2	localObject2	Object
    //   3	89	3	localObject3	Object
    //   115	1	3	localThrowable2	java.lang.Throwable
    //   128	37	3	localFile	java.io.File
    //   80	5	4	localObject4	Object
    //   123	7	4	localObject5	Object
    //   135	5	4	localObject6	Object
    //   149	7	4	localThrowable3	java.lang.Throwable
    //   161	5	4	localThrowable4	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   4	13	48	java/lang/Throwable
    //   71	75	76	java/lang/Throwable
    //   4	13	78	finally
    //   35	39	105	java/lang/Throwable
    //   43	47	109	java/lang/Throwable
    //   63	67	111	java/lang/Throwable
    //   91	95	115	java/lang/Throwable
    //   99	103	119	java/lang/Throwable
    //   13	22	123	finally
    //   22	31	135	finally
    //   51	59	145	finally
    //   13	22	149	java/lang/Throwable
    //   22	31	161	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.video.call.ClientLogReport.ReportRecord
 * JD-Core Version:    0.7.0.1
 */