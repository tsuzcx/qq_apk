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
    //   1: ifnull +32 -> 33
    //   4: aload_1
    //   5: invokeinterface 34 1 0
    //   10: ifle +23 -> 33
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
    //   62: ifeq +61 -> 123
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
    //   123: aload_0
    //   124: getfield 14	com/tencent/hlyyb/downloader/e/d/e:b	Lcom/tencent/hlyyb/downloader/e/d/c;
    //   127: invokestatic 93	com/tencent/hlyyb/downloader/e/d/c:a	(Lcom/tencent/hlyyb/downloader/e/d/c;)Z
    //   130: ifne -97 -> 33
    //   133: aload_0
    //   134: getfield 14	com/tencent/hlyyb/downloader/e/d/e:b	Lcom/tencent/hlyyb/downloader/e/d/c;
    //   137: invokestatic 99	android/os/SystemClock:elapsedRealtime	()J
    //   140: aload_0
    //   141: getfield 14	com/tencent/hlyyb/downloader/e/d/e:b	Lcom/tencent/hlyyb/downloader/e/d/c;
    //   144: invokestatic 102	com/tencent/hlyyb/downloader/e/d/c:b	(Lcom/tencent/hlyyb/downloader/e/d/c;)J
    //   147: lsub
    //   148: l2i
    //   149: putfield 105	com/tencent/hlyyb/downloader/e/d/c:c	I
    //   152: aload_0
    //   153: getfield 14	com/tencent/hlyyb/downloader/e/d/e:b	Lcom/tencent/hlyyb/downloader/e/d/c;
    //   156: astore_1
    //   157: aload_0
    //   158: getfield 14	com/tencent/hlyyb/downloader/e/d/e:b	Lcom/tencent/hlyyb/downloader/e/d/c;
    //   161: invokestatic 107	com/tencent/hlyyb/downloader/e/d/c:c	(Lcom/tencent/hlyyb/downloader/e/d/c;)J
    //   164: ldc2_w 108
    //   167: lcmp
    //   168: ifne +106 -> 274
    //   171: lload_2
    //   172: lconst_0
    //   173: lcmp
    //   174: ifle +100 -> 274
    //   177: goto +3 -> 180
    //   180: aload_1
    //   181: lload_2
    //   182: invokestatic 112	com/tencent/hlyyb/downloader/e/d/c:a	(Lcom/tencent/hlyyb/downloader/e/d/c;J)J
    //   185: pop2
    //   186: aload_0
    //   187: getfield 14	com/tencent/hlyyb/downloader/e/d/e:b	Lcom/tencent/hlyyb/downloader/e/d/c;
    //   190: astore_1
    //   191: aload_0
    //   192: getfield 14	com/tencent/hlyyb/downloader/e/d/e:b	Lcom/tencent/hlyyb/downloader/e/d/c;
    //   195: invokestatic 115	com/tencent/hlyyb/downloader/e/d/c:d	(Lcom/tencent/hlyyb/downloader/e/d/c;)Ljava/lang/String;
    //   198: invokestatic 48	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   201: ifeq +80 -> 281
    //   204: aload 4
    //   206: invokestatic 48	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   209: ifne +72 -> 281
    //   212: goto +3 -> 215
    //   215: aload_1
    //   216: aload 4
    //   218: invokestatic 118	com/tencent/hlyyb/downloader/e/d/c:a	(Lcom/tencent/hlyyb/downloader/e/d/c;Ljava/lang/String;)Ljava/lang/String;
    //   221: pop
    //   222: aload_0
    //   223: getfield 14	com/tencent/hlyyb/downloader/e/d/e:b	Lcom/tencent/hlyyb/downloader/e/d/c;
    //   226: aload 5
    //   228: invokestatic 121	com/tencent/hlyyb/downloader/e/d/c:a	(Lcom/tencent/hlyyb/downloader/e/d/c;Ljava/util/List;)Ljava/util/List;
    //   231: pop
    //   232: aload_0
    //   233: getfield 14	com/tencent/hlyyb/downloader/e/d/e:b	Lcom/tencent/hlyyb/downloader/e/d/c;
    //   236: aload 6
    //   238: invokestatic 123	com/tencent/hlyyb/downloader/e/d/c:b	(Lcom/tencent/hlyyb/downloader/e/d/c;Ljava/lang/String;)Ljava/lang/String;
    //   241: pop
    //   242: aload_0
    //   243: getfield 14	com/tencent/hlyyb/downloader/e/d/e:b	Lcom/tencent/hlyyb/downloader/e/d/c;
    //   246: iconst_1
    //   247: invokestatic 126	com/tencent/hlyyb/downloader/e/d/c:a	(Lcom/tencent/hlyyb/downloader/e/d/c;Z)Z
    //   250: pop
    //   251: goto -218 -> 33
    //   254: astore_1
    //   255: aload_0
    //   256: getfield 16	com/tencent/hlyyb/downloader/e/d/e:a	Ljava/util/concurrent/CountDownLatch;
    //   259: invokevirtual 25	java/util/concurrent/CountDownLatch:countDown	()V
    //   262: goto +5 -> 267
    //   265: aload_1
    //   266: athrow
    //   267: goto -2 -> 265
    //   270: astore_1
    //   271: goto -238 -> 33
    //   274: ldc2_w 108
    //   277: lstore_2
    //   278: goto -98 -> 180
    //   281: ldc 128
    //   283: astore 4
    //   285: goto -70 -> 215
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	288	0	this	e
    //   0	288	1	paramList	java.util.List<java.lang.String>
    //   0	288	2	paramLong	long
    //   0	288	4	paramString1	java.lang.String
    //   0	288	5	paramList1	java.util.List<com.tencent.hlyyb.downloader.d.a>
    //   0	288	6	paramString2	java.lang.String
    //   87	29	7	i	int
    //   26	3	8	bool	boolean
    //   19	93	9	str1	java.lang.String
    //   74	40	10	str2	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   4	28	254	finally
    //   41	56	254	finally
    //   56	89	254	finally
    //   89	107	254	finally
    //   107	120	254	finally
    //   123	171	254	finally
    //   180	212	254	finally
    //   215	251	254	finally
    //   4	28	270	java/lang/Throwable
    //   41	56	270	java/lang/Throwable
    //   56	89	270	java/lang/Throwable
    //   89	107	270	java/lang/Throwable
    //   107	120	270	java/lang/Throwable
    //   123	171	270	java/lang/Throwable
    //   180	212	270	java/lang/Throwable
    //   215	251	270	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hlyyb.downloader.e.d.e
 * JD-Core Version:    0.7.0.1
 */