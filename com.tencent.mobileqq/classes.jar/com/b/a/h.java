package com.b.a;

import java.util.concurrent.BlockingQueue;

public final class h
  extends Thread
{
  private final BlockingQueue<m<?>> a;
  private final g b;
  private final b c;
  private final p d;
  private volatile boolean e = false;
  
  public h(BlockingQueue<m<?>> paramBlockingQueue, g paramg, b paramb, p paramp)
  {
    this.a = paramBlockingQueue;
    this.b = paramg;
    this.c = paramb;
    this.d = paramp;
  }
  
  public final void a()
  {
    this.e = true;
    interrupt();
  }
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: bipush 10
    //   2: invokestatic 49	android/os/Process:setThreadPriority	(I)V
    //   5: aload_0
    //   6: getfield 24	com/b/a/h:a	Ljava/util/concurrent/BlockingQueue;
    //   9: invokeinterface 55 1 0
    //   14: checkcast 57	com/b/a/m
    //   17: astore_1
    //   18: invokestatic 63	android/os/SystemClock:elapsedRealtime	()J
    //   21: pop2
    //   22: aload_1
    //   23: ldc 65
    //   25: invokevirtual 68	com/b/a/m:a	(Ljava/lang/String;)V
    //   28: aload_1
    //   29: invokevirtual 72	com/b/a/m:f	()Z
    //   32: ifeq +56 -> 88
    //   35: aload_1
    //   36: ldc 74
    //   38: invokevirtual 76	com/b/a/m:b	(Ljava/lang/String;)V
    //   41: aload_1
    //   42: invokevirtual 79	com/b/a/m:r	()V
    //   45: goto -40 -> 5
    //   48: astore_2
    //   49: invokestatic 63	android/os/SystemClock:elapsedRealtime	()J
    //   52: pop2
    //   53: aload_2
    //   54: invokestatic 82	com/b/a/m:a	(Lcom/b/a/t;)Lcom/b/a/t;
    //   57: astore_3
    //   58: aload_0
    //   59: getfield 30	com/b/a/h:d	Lcom/b/a/p;
    //   62: aload_1
    //   63: aload_3
    //   64: invokevirtual 87	com/b/a/p:a	(Lcom/b/a/m;Lcom/b/a/t;)V
    //   67: aload_1
    //   68: invokevirtual 79	com/b/a/m:r	()V
    //   71: aload_1
    //   72: aload_2
    //   73: invokestatic 90	com/b/a/b$a:a	(Lcom/b/a/m;Lcom/b/a/t;)V
    //   76: goto -71 -> 5
    //   79: astore_1
    //   80: aload_0
    //   81: getfield 22	com/b/a/h:e	Z
    //   84: ifeq -79 -> 5
    //   87: return
    //   88: getstatic 96	android/os/Build$VERSION:SDK_INT	I
    //   91: bipush 14
    //   93: if_icmplt +10 -> 103
    //   96: aload_1
    //   97: invokevirtual 99	com/b/a/m:b	()I
    //   100: invokestatic 104	android/net/TrafficStats:setThreadStatsTag	(I)V
    //   103: aload_1
    //   104: invokestatic 107	com/b/a/b$a:a	(Lcom/b/a/m;)V
    //   107: aload_0
    //   108: getfield 26	com/b/a/h:b	Lcom/b/a/g;
    //   111: aload_1
    //   112: invokeinterface 112 2 0
    //   117: astore_2
    //   118: aload_1
    //   119: ldc 114
    //   121: invokevirtual 68	com/b/a/m:a	(Ljava/lang/String;)V
    //   124: aload_2
    //   125: getfield 118	com/b/a/j:c	Z
    //   128: ifeq +75 -> 203
    //   131: aload_1
    //   132: invokevirtual 121	com/b/a/m:q	()Z
    //   135: ifeq +68 -> 203
    //   138: aload_1
    //   139: ldc 123
    //   141: invokevirtual 76	com/b/a/m:b	(Ljava/lang/String;)V
    //   144: aload_1
    //   145: invokevirtual 79	com/b/a/m:r	()V
    //   148: goto -143 -> 5
    //   151: astore_2
    //   152: aload_2
    //   153: ldc 125
    //   155: iconst_1
    //   156: anewarray 127	java/lang/Object
    //   159: dup
    //   160: iconst_0
    //   161: aload_2
    //   162: invokevirtual 131	java/lang/Exception:toString	()Ljava/lang/String;
    //   165: aastore
    //   166: invokestatic 136	com/b/a/u:a	(Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   169: new 41	com/b/a/t
    //   172: dup
    //   173: aload_2
    //   174: invokespecial 139	com/b/a/t:<init>	(Ljava/lang/Throwable;)V
    //   177: astore_2
    //   178: invokestatic 63	android/os/SystemClock:elapsedRealtime	()J
    //   181: pop2
    //   182: aload_0
    //   183: getfield 30	com/b/a/h:d	Lcom/b/a/p;
    //   186: aload_1
    //   187: aload_2
    //   188: invokevirtual 87	com/b/a/p:a	(Lcom/b/a/m;Lcom/b/a/t;)V
    //   191: aload_1
    //   192: invokevirtual 79	com/b/a/m:r	()V
    //   195: aload_1
    //   196: aload_2
    //   197: invokestatic 90	com/b/a/b$a:a	(Lcom/b/a/m;Lcom/b/a/t;)V
    //   200: goto -195 -> 5
    //   203: aload_1
    //   204: aload_2
    //   205: invokevirtual 142	com/b/a/m:a	(Lcom/b/a/j;)Lcom/b/a/o;
    //   208: astore_2
    //   209: aload_1
    //   210: ldc 144
    //   212: invokevirtual 68	com/b/a/m:a	(Ljava/lang/String;)V
    //   215: aload_1
    //   216: invokevirtual 147	com/b/a/m:l	()Z
    //   219: ifeq +33 -> 252
    //   222: aload_2
    //   223: getfield 152	com/b/a/o:b	Lcom/b/a/b$a;
    //   226: ifnull +26 -> 252
    //   229: aload_0
    //   230: getfield 28	com/b/a/h:c	Lcom/b/a/b;
    //   233: aload_1
    //   234: invokevirtual 154	com/b/a/m:d	()Ljava/lang/String;
    //   237: aload_2
    //   238: getfield 152	com/b/a/o:b	Lcom/b/a/b$a;
    //   241: invokeinterface 159 3 0
    //   246: aload_1
    //   247: ldc 161
    //   249: invokevirtual 68	com/b/a/m:a	(Ljava/lang/String;)V
    //   252: aload_1
    //   253: invokevirtual 164	com/b/a/m:p	()V
    //   256: aload_0
    //   257: getfield 30	com/b/a/h:d	Lcom/b/a/p;
    //   260: aload_1
    //   261: aload_2
    //   262: invokevirtual 167	com/b/a/p:a	(Lcom/b/a/m;Lcom/b/a/o;)V
    //   265: aload_1
    //   266: aload_2
    //   267: invokevirtual 170	com/b/a/m:a	(Lcom/b/a/o;)V
    //   270: aload_1
    //   271: aload_2
    //   272: invokestatic 171	com/b/a/b$a:a	(Lcom/b/a/m;Lcom/b/a/o;)V
    //   275: goto -270 -> 5
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	278	0	this	h
    //   17	55	1	localm	m
    //   79	192	1	localInterruptedException	java.lang.InterruptedException
    //   48	25	2	localt1	t
    //   117	8	2	localj	j
    //   151	23	2	localException	java.lang.Exception
    //   177	95	2	localObject	java.lang.Object
    //   57	7	3	localt2	t
    // Exception table:
    //   from	to	target	type
    //   22	45	48	com/b/a/t
    //   88	103	48	com/b/a/t
    //   103	148	48	com/b/a/t
    //   203	252	48	com/b/a/t
    //   252	275	48	com/b/a/t
    //   5	18	79	java/lang/InterruptedException
    //   22	45	151	java/lang/Exception
    //   88	103	151	java/lang/Exception
    //   103	148	151	java/lang/Exception
    //   203	252	151	java/lang/Exception
    //   252	275	151	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.b.a.h
 * JD-Core Version:    0.7.0.1
 */