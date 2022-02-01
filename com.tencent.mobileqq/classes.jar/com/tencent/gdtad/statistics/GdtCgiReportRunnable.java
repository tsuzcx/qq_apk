package com.tencent.gdtad.statistics;

class GdtCgiReportRunnable
  implements Runnable
{
  protected boolean a = false;
  private String b;
  private GdtCgiReportRunnable.GdtCgiReportRunnableCallback c;
  
  GdtCgiReportRunnable(String paramString)
  {
    this.b = paramString;
  }
  
  public void a(GdtCgiReportRunnable.GdtCgiReportRunnableCallback paramGdtCgiReportRunnableCallback)
  {
    this.c = paramGdtCgiReportRunnableCallback;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: iconst_m1
    //   1: istore_2
    //   2: new 30	java/net/URL
    //   5: dup
    //   6: aload_0
    //   7: getfield 21	com/tencent/gdtad/statistics/GdtCgiReportRunnable:b	Ljava/lang/String;
    //   10: invokespecial 32	java/net/URL:<init>	(Ljava/lang/String;)V
    //   13: invokevirtual 36	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   16: checkcast 38	java/net/HttpURLConnection
    //   19: astore 5
    //   21: iload_2
    //   22: istore_3
    //   23: iload_2
    //   24: istore_1
    //   25: aload 5
    //   27: astore 4
    //   29: aload 5
    //   31: ldc 40
    //   33: ldc 42
    //   35: invokevirtual 46	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   38: iload_2
    //   39: istore_3
    //   40: iload_2
    //   41: istore_1
    //   42: aload 5
    //   44: astore 4
    //   46: aload 5
    //   48: invokevirtual 49	java/net/HttpURLConnection:connect	()V
    //   51: iload_2
    //   52: istore_3
    //   53: iload_2
    //   54: istore_1
    //   55: aload 5
    //   57: astore 4
    //   59: aload 5
    //   61: invokevirtual 53	java/net/HttpURLConnection:getResponseCode	()I
    //   64: istore_2
    //   65: iload_2
    //   66: sipush 200
    //   69: if_icmpne +16 -> 85
    //   72: iload_2
    //   73: istore_3
    //   74: iload_2
    //   75: istore_1
    //   76: aload 5
    //   78: astore 4
    //   80: aload_0
    //   81: iconst_1
    //   82: putfield 19	com/tencent/gdtad/statistics/GdtCgiReportRunnable:a	Z
    //   85: aload 5
    //   87: ifnull +8 -> 95
    //   90: aload 5
    //   92: invokevirtual 56	java/net/HttpURLConnection:disconnect	()V
    //   95: aload_0
    //   96: getfield 25	com/tencent/gdtad/statistics/GdtCgiReportRunnable:c	Lcom/tencent/gdtad/statistics/GdtCgiReportRunnable$GdtCgiReportRunnableCallback;
    //   99: astore 4
    //   101: aload 4
    //   103: ifnull +86 -> 189
    //   106: goto +75 -> 181
    //   109: astore 6
    //   111: iload_3
    //   112: istore_2
    //   113: goto +18 -> 131
    //   116: astore 4
    //   118: aconst_null
    //   119: astore 5
    //   121: iload_2
    //   122: istore_1
    //   123: goto +77 -> 200
    //   126: astore 6
    //   128: aconst_null
    //   129: astore 5
    //   131: iload_2
    //   132: istore_1
    //   133: aload 5
    //   135: astore 4
    //   137: ldc 58
    //   139: ldc 60
    //   141: iconst_1
    //   142: anewarray 4	java/lang/Object
    //   145: dup
    //   146: iconst_0
    //   147: aload_0
    //   148: getfield 21	com/tencent/gdtad/statistics/GdtCgiReportRunnable:b	Ljava/lang/String;
    //   151: aastore
    //   152: invokestatic 66	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   155: aload 6
    //   157: invokestatic 72	com/tencent/gdtad/log/GdtLog:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   160: aload 5
    //   162: ifnull +8 -> 170
    //   165: aload 5
    //   167: invokevirtual 56	java/net/HttpURLConnection:disconnect	()V
    //   170: aload_0
    //   171: getfield 25	com/tencent/gdtad/statistics/GdtCgiReportRunnable:c	Lcom/tencent/gdtad/statistics/GdtCgiReportRunnable$GdtCgiReportRunnableCallback;
    //   174: astore 4
    //   176: aload 4
    //   178: ifnull +11 -> 189
    //   181: aload 4
    //   183: iload_2
    //   184: invokeinterface 77 2 0
    //   189: return
    //   190: astore 6
    //   192: aload 4
    //   194: astore 5
    //   196: aload 6
    //   198: astore 4
    //   200: aload 5
    //   202: ifnull +8 -> 210
    //   205: aload 5
    //   207: invokevirtual 56	java/net/HttpURLConnection:disconnect	()V
    //   210: aload_0
    //   211: getfield 25	com/tencent/gdtad/statistics/GdtCgiReportRunnable:c	Lcom/tencent/gdtad/statistics/GdtCgiReportRunnable$GdtCgiReportRunnableCallback;
    //   214: astore 5
    //   216: aload 5
    //   218: ifnull +11 -> 229
    //   221: aload 5
    //   223: iload_1
    //   224: invokeinterface 77 2 0
    //   229: aload 4
    //   231: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	232	0	this	GdtCgiReportRunnable
    //   24	200	1	i	int
    //   1	183	2	j	int
    //   22	90	3	k	int
    //   27	75	4	localObject1	Object
    //   116	1	4	localObject2	Object
    //   135	95	4	localObject3	Object
    //   19	203	5	localObject4	Object
    //   109	1	6	localThrowable1	java.lang.Throwable
    //   126	30	6	localThrowable2	java.lang.Throwable
    //   190	7	6	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   29	38	109	java/lang/Throwable
    //   46	51	109	java/lang/Throwable
    //   59	65	109	java/lang/Throwable
    //   80	85	109	java/lang/Throwable
    //   2	21	116	finally
    //   2	21	126	java/lang/Throwable
    //   29	38	190	finally
    //   46	51	190	finally
    //   59	65	190	finally
    //   80	85	190	finally
    //   137	160	190	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.statistics.GdtCgiReportRunnable
 * JD-Core Version:    0.7.0.1
 */