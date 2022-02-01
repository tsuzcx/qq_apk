package com.tencent.av.video.call;

import java.io.Serializable;

class ClientLogReport$ReportRecord
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  byte[] mLog;
  long mTimestamp;
  String mTopicId;
  long mUin;
  
  /* Error */
  public static ReportRecord readFromFile(java.io.File paramFile)
  {
    // Byte code:
    //   0: new 27	java/io/FileInputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 30	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   8: astore_0
    //   9: new 32	java/io/ObjectInputStream
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 35	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   17: astore 5
    //   19: aload_0
    //   20: astore_1
    //   21: aload 5
    //   23: astore_3
    //   24: aload 5
    //   26: invokevirtual 39	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   29: checkcast 2	com/tencent/av/video/call/ClientLogReport$ReportRecord
    //   32: astore_2
    //   33: aload_0
    //   34: invokevirtual 42	java/io/FileInputStream:close	()V
    //   37: aload 5
    //   39: invokevirtual 43	java/io/ObjectInputStream:close	()V
    //   42: aload_2
    //   43: areturn
    //   44: astore 4
    //   46: aload_0
    //   47: astore_2
    //   48: aload 5
    //   50: astore_0
    //   51: goto +34 -> 85
    //   54: astore_1
    //   55: aconst_null
    //   56: astore_3
    //   57: goto +67 -> 124
    //   60: astore 4
    //   62: aconst_null
    //   63: astore_1
    //   64: aload_0
    //   65: astore_2
    //   66: aload_1
    //   67: astore_0
    //   68: goto +17 -> 85
    //   71: astore_1
    //   72: aconst_null
    //   73: astore_0
    //   74: aload_0
    //   75: astore_3
    //   76: goto +48 -> 124
    //   79: astore 4
    //   81: aconst_null
    //   82: astore_0
    //   83: aload_0
    //   84: astore_2
    //   85: aload_2
    //   86: astore_1
    //   87: aload_0
    //   88: astore_3
    //   89: ldc 45
    //   91: ldc 47
    //   93: aload 4
    //   95: invokestatic 53	com/tencent/avcore/util/AVCoreLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   98: aload_2
    //   99: ifnull +10 -> 109
    //   102: aload_2
    //   103: invokevirtual 42	java/io/FileInputStream:close	()V
    //   106: goto +3 -> 109
    //   109: aload_0
    //   110: ifnull +7 -> 117
    //   113: aload_0
    //   114: invokevirtual 43	java/io/ObjectInputStream:close	()V
    //   117: aconst_null
    //   118: areturn
    //   119: astore_2
    //   120: aload_1
    //   121: astore_0
    //   122: aload_2
    //   123: astore_1
    //   124: aload_0
    //   125: ifnull +10 -> 135
    //   128: aload_0
    //   129: invokevirtual 42	java/io/FileInputStream:close	()V
    //   132: goto +3 -> 135
    //   135: aload_3
    //   136: ifnull +7 -> 143
    //   139: aload_3
    //   140: invokevirtual 43	java/io/ObjectInputStream:close	()V
    //   143: aload_1
    //   144: athrow
    //   145: astore_0
    //   146: goto -109 -> 37
    //   149: astore_0
    //   150: goto -108 -> 42
    //   153: astore_1
    //   154: goto -45 -> 109
    //   157: astore_0
    //   158: aconst_null
    //   159: areturn
    //   160: astore_0
    //   161: goto -26 -> 135
    //   164: astore_0
    //   165: goto -22 -> 143
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	168	0	paramFile	java.io.File
    //   20	1	1	localFile	java.io.File
    //   54	1	1	localObject1	Object
    //   63	4	1	localObject2	Object
    //   71	1	1	localObject3	Object
    //   86	58	1	localObject4	Object
    //   153	1	1	localThrowable1	java.lang.Throwable
    //   32	71	2	localObject5	Object
    //   119	4	2	localObject6	Object
    //   23	117	3	localObject7	Object
    //   44	1	4	localThrowable2	java.lang.Throwable
    //   60	1	4	localThrowable3	java.lang.Throwable
    //   79	15	4	localThrowable4	java.lang.Throwable
    //   17	32	5	localObjectInputStream	java.io.ObjectInputStream
    // Exception table:
    //   from	to	target	type
    //   24	33	44	java/lang/Throwable
    //   9	19	54	finally
    //   9	19	60	java/lang/Throwable
    //   0	9	71	finally
    //   0	9	79	java/lang/Throwable
    //   24	33	119	finally
    //   89	98	119	finally
    //   33	37	145	java/lang/Throwable
    //   37	42	149	java/lang/Throwable
    //   102	106	153	java/lang/Throwable
    //   113	117	157	java/lang/Throwable
    //   128	132	160	java/lang/Throwable
    //   139	143	164	java/lang/Throwable
  }
  
  public String toString()
  {
    return String.format("ReportRecord{mUin=%s mTopicId=%s mLog=%s mTimestamp=%s}", new Object[] { Long.valueOf(this.mUin), this.mTopicId, this.mLog, Long.valueOf(this.mTimestamp) });
  }
  
  /* Error */
  public void writeToFile(java.io.File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore 5
    //   5: new 80	java/io/FileOutputStream
    //   8: dup
    //   9: aload_1
    //   10: invokespecial 81	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   13: astore 4
    //   15: new 83	java/io/ObjectOutputStream
    //   18: dup
    //   19: aload 4
    //   21: invokespecial 86	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   24: astore_1
    //   25: aload_1
    //   26: aload_0
    //   27: invokevirtual 90	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   30: aload_1
    //   31: invokevirtual 93	java/io/ObjectOutputStream:flush	()V
    //   34: aload 4
    //   36: invokevirtual 94	java/io/FileOutputStream:close	()V
    //   39: aload_1
    //   40: invokevirtual 95	java/io/ObjectOutputStream:close	()V
    //   43: return
    //   44: astore_2
    //   45: aload_1
    //   46: astore_3
    //   47: aload_2
    //   48: astore_1
    //   49: goto +12 -> 61
    //   52: astore_3
    //   53: aload_1
    //   54: astore_2
    //   55: goto +18 -> 73
    //   58: astore_1
    //   59: aconst_null
    //   60: astore_3
    //   61: aload 4
    //   63: astore_2
    //   64: aload_1
    //   65: astore 4
    //   67: goto +59 -> 126
    //   70: astore_3
    //   71: aconst_null
    //   72: astore_2
    //   73: aload 4
    //   75: astore_1
    //   76: goto +16 -> 92
    //   79: astore 4
    //   81: aconst_null
    //   82: astore_3
    //   83: goto +43 -> 126
    //   86: astore_3
    //   87: aconst_null
    //   88: astore_2
    //   89: aload 5
    //   91: astore_1
    //   92: ldc 45
    //   94: ldc 97
    //   96: aload_3
    //   97: invokestatic 53	com/tencent/avcore/util/AVCoreLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   100: aload_1
    //   101: ifnull +10 -> 111
    //   104: aload_1
    //   105: invokevirtual 94	java/io/FileOutputStream:close	()V
    //   108: goto +3 -> 111
    //   111: aload_2
    //   112: ifnull +7 -> 119
    //   115: aload_2
    //   116: invokevirtual 95	java/io/ObjectOutputStream:close	()V
    //   119: return
    //   120: astore 4
    //   122: aload_2
    //   123: astore_3
    //   124: aload_1
    //   125: astore_2
    //   126: aload_2
    //   127: ifnull +10 -> 137
    //   130: aload_2
    //   131: invokevirtual 94	java/io/FileOutputStream:close	()V
    //   134: goto +3 -> 137
    //   137: aload_3
    //   138: ifnull +7 -> 145
    //   141: aload_3
    //   142: invokevirtual 95	java/io/ObjectOutputStream:close	()V
    //   145: aload 4
    //   147: athrow
    //   148: astore_2
    //   149: goto -110 -> 39
    //   152: astore_1
    //   153: return
    //   154: astore_1
    //   155: goto -44 -> 111
    //   158: astore_1
    //   159: goto -22 -> 137
    //   162: astore_1
    //   163: goto -18 -> 145
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	166	0	this	ReportRecord
    //   0	166	1	paramFile	java.io.File
    //   1	1	2	localObject1	Object
    //   44	4	2	localObject2	Object
    //   54	77	2	localObject3	Object
    //   148	1	2	localThrowable1	java.lang.Throwable
    //   46	1	3	localFile	java.io.File
    //   52	1	3	localThrowable2	java.lang.Throwable
    //   60	1	3	localObject4	Object
    //   70	1	3	localThrowable3	java.lang.Throwable
    //   82	1	3	localObject5	Object
    //   86	11	3	localThrowable4	java.lang.Throwable
    //   123	19	3	localObject6	Object
    //   13	61	4	localObject7	Object
    //   79	1	4	localObject8	Object
    //   120	26	4	localObject9	Object
    //   3	87	5	localObject10	Object
    // Exception table:
    //   from	to	target	type
    //   25	34	44	finally
    //   25	34	52	java/lang/Throwable
    //   15	25	58	finally
    //   15	25	70	java/lang/Throwable
    //   5	15	79	finally
    //   5	15	86	java/lang/Throwable
    //   92	100	120	finally
    //   34	39	148	java/lang/Throwable
    //   39	43	152	java/lang/Throwable
    //   115	119	152	java/lang/Throwable
    //   104	108	154	java/lang/Throwable
    //   130	134	158	java/lang/Throwable
    //   141	145	162	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.video.call.ClientLogReport.ReportRecord
 * JD-Core Version:    0.7.0.1
 */