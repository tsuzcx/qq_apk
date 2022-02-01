package com.tencent.liteav.network;

class TXCRTMPDownloader$a
  extends Thread
{
  private long b = 0L;
  private String c;
  private boolean d;
  
  TXCRTMPDownloader$a(TXCRTMPDownloader paramTXCRTMPDownloader, String paramString, boolean paramBoolean)
  {
    super("RTMPDownLoad");
    this.c = paramString;
    this.d = paramBoolean;
  }
  
  public void a()
  {
    try
    {
      if (this.b != 0L) {
        TXCRTMPDownloader.access$300(this.a, this.b);
      }
      return;
    }
    finally {}
  }
  
  public void a(String paramString)
  {
    try
    {
      if (this.b != 0L) {
        TXCRTMPDownloader.access$500(this.a, this.b, paramString);
      }
      return;
    }
    finally {}
  }
  
  public TXCStreamDownloader.DownloadStats b()
  {
    for (;;)
    {
      try
      {
        if (this.b != 0L)
        {
          TXCStreamDownloader.DownloadStats localDownloadStats = TXCRTMPDownloader.access$400(this.a, this.b);
          return localDownloadStats;
        }
      }
      finally {}
      Object localObject2 = null;
    }
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_0
    //   4: getfield 16	com/tencent/liteav/network/TXCRTMPDownloader$a:a	Lcom/tencent/liteav/network/TXCRTMPDownloader;
    //   7: aload_0
    //   8: getfield 16	com/tencent/liteav/network/TXCRTMPDownloader$a:a	Lcom/tencent/liteav/network/TXCRTMPDownloader;
    //   11: getfield 48	com/tencent/liteav/network/TXCRTMPDownloader:mUserID	Ljava/lang/String;
    //   14: aload_0
    //   15: getfield 16	com/tencent/liteav/network/TXCRTMPDownloader$a:a	Lcom/tencent/liteav/network/TXCRTMPDownloader;
    //   18: getfield 51	com/tencent/liteav/network/TXCRTMPDownloader:mOriginUrl	Ljava/lang/String;
    //   21: aload_0
    //   22: getfield 25	com/tencent/liteav/network/TXCRTMPDownloader$a:c	Ljava/lang/String;
    //   25: aload_0
    //   26: getfield 27	com/tencent/liteav/network/TXCRTMPDownloader$a:d	Z
    //   29: aload_0
    //   30: getfield 16	com/tencent/liteav/network/TXCRTMPDownloader$a:a	Lcom/tencent/liteav/network/TXCRTMPDownloader;
    //   33: getfield 54	com/tencent/liteav/network/TXCRTMPDownloader:mEnableMessage	Z
    //   36: aload_0
    //   37: getfield 16	com/tencent/liteav/network/TXCRTMPDownloader$a:a	Lcom/tencent/liteav/network/TXCRTMPDownloader;
    //   40: getfield 57	com/tencent/liteav/network/TXCRTMPDownloader:mEnableMetaData	Z
    //   43: invokestatic 61	com/tencent/liteav/network/TXCRTMPDownloader:access$000	(Lcom/tencent/liteav/network/TXCRTMPDownloader;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZZ)J
    //   46: putfield 23	com/tencent/liteav/network/TXCRTMPDownloader$a:b	J
    //   49: aload_0
    //   50: monitorexit
    //   51: aload_0
    //   52: getfield 16	com/tencent/liteav/network/TXCRTMPDownloader$a:a	Lcom/tencent/liteav/network/TXCRTMPDownloader;
    //   55: aload_0
    //   56: getfield 23	com/tencent/liteav/network/TXCRTMPDownloader$a:b	J
    //   59: invokestatic 64	com/tencent/liteav/network/TXCRTMPDownloader:access$100	(Lcom/tencent/liteav/network/TXCRTMPDownloader;J)V
    //   62: aload_0
    //   63: monitorenter
    //   64: aload_0
    //   65: getfield 16	com/tencent/liteav/network/TXCRTMPDownloader$a:a	Lcom/tencent/liteav/network/TXCRTMPDownloader;
    //   68: aload_0
    //   69: getfield 23	com/tencent/liteav/network/TXCRTMPDownloader$a:b	J
    //   72: invokestatic 67	com/tencent/liteav/network/TXCRTMPDownloader:access$200	(Lcom/tencent/liteav/network/TXCRTMPDownloader;J)V
    //   75: aload_0
    //   76: lconst_0
    //   77: putfield 23	com/tencent/liteav/network/TXCRTMPDownloader$a:b	J
    //   80: aload_0
    //   81: monitorexit
    //   82: return
    //   83: astore_1
    //   84: aload_0
    //   85: monitorexit
    //   86: aload_1
    //   87: athrow
    //   88: astore_1
    //   89: aload_0
    //   90: monitorexit
    //   91: aload_1
    //   92: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	93	0	this	a
    //   83	4	1	localObject1	Object
    //   88	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   64	82	83	finally
    //   84	86	83	finally
    //   2	51	88	finally
    //   89	91	88	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.network.TXCRTMPDownloader.a
 * JD-Core Version:    0.7.0.1
 */