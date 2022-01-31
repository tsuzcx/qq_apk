package com.tencent.hlyyb.downloader.e.d;

import com.tencent.hlyyb.downloader.d.b;
import java.util.concurrent.CountDownLatch;

final class e
  implements b
{
  e(c paramc, CountDownLatch paramCountDownLatch) {}
  
  public final void a()
  {
    this.a.countDown();
  }
  
  /* Error */
  public final void a(java.util.List<java.lang.String> paramList, long paramLong, java.lang.String paramString1, java.util.List<com.tencent.hlyyb.downloader.d.a> paramList1, java.lang.String paramString2)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +253 -> 254
    //   4: aload_1
    //   5: invokeinterface 34 1 0
    //   10: ifle +244 -> 254
    //   13: invokestatic 39	com/tencent/hlyyb/common/a/a:d	()V
    //   16: invokestatic 42	com/tencent/hlyyb/common/a/a:b	()Ljava/lang/String;
    //   19: astore 9
    //   21: aload 9
    //   23: invokestatic 48	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   26: istore 8
    //   28: iload 8
    //   30: ifeq +11 -> 41
    //   33: aload_0
    //   34: getfield 16	com/tencent/hlyyb/downloader/e/d/e:a	Ljava/util/concurrent/CountDownLatch;
    //   37: invokevirtual 25	java/util/concurrent/CountDownLatch:countDown	()V
    //   40: return
    //   41: aload_0
    //   42: getfield 14	com/tencent/hlyyb/downloader/e/d/e:b	Lcom/tencent/hlyyb/downloader/e/d/c;
    //   45: iconst_1
    //   46: invokevirtual 53	com/tencent/hlyyb/downloader/e/d/c:b	(Z)V
    //   49: aload_1
    //   50: invokeinterface 57 1 0
    //   55: astore_1
    //   56: aload_1
    //   57: invokeinterface 63 1 0
    //   62: ifeq +70 -> 132
    //   65: aload_1
    //   66: invokeinterface 67 1 0
    //   71: checkcast 69	java/lang/String
    //   74: astore 10
    //   76: aload 10
    //   78: invokestatic 48	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   81: ifne -25 -> 56
    //   84: getstatic 75	com/tencent/hlyyb/downloader/e/d/b:f	I
    //   87: istore 7
    //   89: aload 10
    //   91: invokevirtual 78	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   94: ldc 80
    //   96: invokevirtual 84	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   99: ifeq +8 -> 107
    //   102: getstatic 87	com/tencent/hlyyb/downloader/e/d/b:j	I
    //   105: istore 7
    //   107: aload_0
    //   108: getfield 14	com/tencent/hlyyb/downloader/e/d/e:b	Lcom/tencent/hlyyb/downloader/e/d/c;
    //   111: aload 9
    //   113: aload 10
    //   115: iload 7
    //   117: invokevirtual 90	com/tencent/hlyyb/downloader/e/d/c:a	(Ljava/lang/String;Ljava/lang/String;I)V
    //   120: goto -64 -> 56
    //   123: astore_1
    //   124: aload_0
    //   125: getfield 16	com/tencent/hlyyb/downloader/e/d/e:a	Ljava/util/concurrent/CountDownLatch;
    //   128: invokevirtual 25	java/util/concurrent/CountDownLatch:countDown	()V
    //   131: return
    //   132: aload_0
    //   133: getfield 14	com/tencent/hlyyb/downloader/e/d/e:b	Lcom/tencent/hlyyb/downloader/e/d/c;
    //   136: invokestatic 93	com/tencent/hlyyb/downloader/e/d/c:a	(Lcom/tencent/hlyyb/downloader/e/d/c;)Z
    //   139: ifne +115 -> 254
    //   142: aload_0
    //   143: getfield 14	com/tencent/hlyyb/downloader/e/d/e:b	Lcom/tencent/hlyyb/downloader/e/d/c;
    //   146: invokestatic 99	android/os/SystemClock:elapsedRealtime	()J
    //   149: aload_0
    //   150: getfield 14	com/tencent/hlyyb/downloader/e/d/e:b	Lcom/tencent/hlyyb/downloader/e/d/c;
    //   153: invokestatic 102	com/tencent/hlyyb/downloader/e/d/c:b	(Lcom/tencent/hlyyb/downloader/e/d/c;)J
    //   156: lsub
    //   157: l2i
    //   158: putfield 105	com/tencent/hlyyb/downloader/e/d/c:c	I
    //   161: aload_0
    //   162: getfield 14	com/tencent/hlyyb/downloader/e/d/e:b	Lcom/tencent/hlyyb/downloader/e/d/c;
    //   165: astore_1
    //   166: aload_0
    //   167: getfield 14	com/tencent/hlyyb/downloader/e/d/e:b	Lcom/tencent/hlyyb/downloader/e/d/c;
    //   170: invokestatic 107	com/tencent/hlyyb/downloader/e/d/c:c	(Lcom/tencent/hlyyb/downloader/e/d/c;)J
    //   173: ldc2_w 108
    //   176: lcmp
    //   177: ifne +85 -> 262
    //   180: lload_2
    //   181: lconst_0
    //   182: lcmp
    //   183: ifle +79 -> 262
    //   186: aload_1
    //   187: lload_2
    //   188: invokestatic 112	com/tencent/hlyyb/downloader/e/d/c:a	(Lcom/tencent/hlyyb/downloader/e/d/c;J)J
    //   191: pop2
    //   192: aload_0
    //   193: getfield 14	com/tencent/hlyyb/downloader/e/d/e:b	Lcom/tencent/hlyyb/downloader/e/d/c;
    //   196: astore_1
    //   197: aload_0
    //   198: getfield 14	com/tencent/hlyyb/downloader/e/d/e:b	Lcom/tencent/hlyyb/downloader/e/d/c;
    //   201: invokestatic 115	com/tencent/hlyyb/downloader/e/d/c:d	(Lcom/tencent/hlyyb/downloader/e/d/c;)Ljava/lang/String;
    //   204: invokestatic 48	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   207: ifeq +62 -> 269
    //   210: aload 4
    //   212: invokestatic 48	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   215: ifne +54 -> 269
    //   218: aload_1
    //   219: aload 4
    //   221: invokestatic 118	com/tencent/hlyyb/downloader/e/d/c:a	(Lcom/tencent/hlyyb/downloader/e/d/c;Ljava/lang/String;)Ljava/lang/String;
    //   224: pop
    //   225: aload_0
    //   226: getfield 14	com/tencent/hlyyb/downloader/e/d/e:b	Lcom/tencent/hlyyb/downloader/e/d/c;
    //   229: aload 5
    //   231: invokestatic 121	com/tencent/hlyyb/downloader/e/d/c:a	(Lcom/tencent/hlyyb/downloader/e/d/c;Ljava/util/List;)Ljava/util/List;
    //   234: pop
    //   235: aload_0
    //   236: getfield 14	com/tencent/hlyyb/downloader/e/d/e:b	Lcom/tencent/hlyyb/downloader/e/d/c;
    //   239: aload 6
    //   241: invokestatic 123	com/tencent/hlyyb/downloader/e/d/c:b	(Lcom/tencent/hlyyb/downloader/e/d/c;Ljava/lang/String;)Ljava/lang/String;
    //   244: pop
    //   245: aload_0
    //   246: getfield 14	com/tencent/hlyyb/downloader/e/d/e:b	Lcom/tencent/hlyyb/downloader/e/d/c;
    //   249: iconst_1
    //   250: invokestatic 126	com/tencent/hlyyb/downloader/e/d/c:a	(Lcom/tencent/hlyyb/downloader/e/d/c;Z)Z
    //   253: pop
    //   254: aload_0
    //   255: getfield 16	com/tencent/hlyyb/downloader/e/d/e:a	Ljava/util/concurrent/CountDownLatch;
    //   258: invokevirtual 25	java/util/concurrent/CountDownLatch:countDown	()V
    //   261: return
    //   262: ldc2_w 108
    //   265: lstore_2
    //   266: goto -80 -> 186
    //   269: ldc 128
    //   271: astore 4
    //   273: goto -55 -> 218
    //   276: astore_1
    //   277: aload_0
    //   278: getfield 16	com/tencent/hlyyb/downloader/e/d/e:a	Ljava/util/concurrent/CountDownLatch;
    //   281: invokevirtual 25	java/util/concurrent/CountDownLatch:countDown	()V
    //   284: aload_1
    //   285: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	286	0	this	e
    //   0	286	1	paramList	java.util.List<java.lang.String>
    //   0	286	2	paramLong	long
    //   0	286	4	paramString1	java.lang.String
    //   0	286	5	paramList1	java.util.List<com.tencent.hlyyb.downloader.d.a>
    //   0	286	6	paramString2	java.lang.String
    //   87	29	7	i	int
    //   26	3	8	bool	boolean
    //   19	93	9	str1	java.lang.String
    //   74	40	10	str2	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   4	28	123	java/lang/Throwable
    //   41	56	123	java/lang/Throwable
    //   56	89	123	java/lang/Throwable
    //   89	107	123	java/lang/Throwable
    //   107	120	123	java/lang/Throwable
    //   132	180	123	java/lang/Throwable
    //   186	218	123	java/lang/Throwable
    //   218	254	123	java/lang/Throwable
    //   4	28	276	finally
    //   41	56	276	finally
    //   56	89	276	finally
    //   89	107	276	finally
    //   107	120	276	finally
    //   132	180	276	finally
    //   186	218	276	finally
    //   218	254	276	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.hlyyb.downloader.e.d.e
 * JD-Core Version:    0.7.0.1
 */