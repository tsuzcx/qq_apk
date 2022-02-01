package com.tencent.mobileqq.ar.arengine;

class ARLocalGestureCircleRecog$ProcessWorker
  extends Thread
{
  byte[] a = new byte[ARLocalGestureCircleRecog.a(this.this$0) * ARLocalGestureCircleRecog.b(this.this$0) * 3 / 2];
  private long b;
  private boolean c = false;
  private boolean d = true;
  
  public ARLocalGestureCircleRecog$ProcessWorker(ARLocalGestureCircleRecog paramARLocalGestureCircleRecog)
  {
    setDaemon(true);
    start();
  }
  
  public void a()
  {
    this.d = false;
    if (getState() == Thread.State.WAITING) {
      try
      {
        notify();
        return;
      }
      finally {}
    }
  }
  
  void a(long paramLong, byte[] paramArrayOfByte)
  {
    if (getState() == Thread.State.WAITING)
    {
      byte[] arrayOfByte = this.a;
      System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, arrayOfByte.length);
      this.b = paramLong;
      this.c = true;
      try
      {
        notify();
        return;
      }
      finally {}
    }
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: ldc 72
    //   5: invokevirtual 76	com/tencent/mobileqq/ar/arengine/ARLocalGestureCircleRecog$ProcessWorker:setName	(Ljava/lang/String;)V
    //   8: aload_0
    //   9: getfield 33	com/tencent/mobileqq/ar/arengine/ARLocalGestureCircleRecog$ProcessWorker:d	Z
    //   12: ifeq +289 -> 301
    //   15: aload_0
    //   16: getfield 22	com/tencent/mobileqq/ar/arengine/ARLocalGestureCircleRecog$ProcessWorker:c	Z
    //   19: ifne +27 -> 46
    //   22: aload_0
    //   23: getfield 33	com/tencent/mobileqq/ar/arengine/ARLocalGestureCircleRecog$ProcessWorker:d	Z
    //   26: istore_1
    //   27: iload_1
    //   28: ifeq +18 -> 46
    //   31: aload_0
    //   32: invokevirtual 79	java/lang/Object:wait	()V
    //   35: goto -20 -> 15
    //   38: astore_2
    //   39: aload_2
    //   40: invokevirtual 82	java/lang/InterruptedException:printStackTrace	()V
    //   43: goto -28 -> 15
    //   46: aload_0
    //   47: getfield 33	com/tencent/mobileqq/ar/arengine/ARLocalGestureCircleRecog$ProcessWorker:d	Z
    //   50: istore_1
    //   51: iload_1
    //   52: ifne +6 -> 58
    //   55: aload_0
    //   56: monitorexit
    //   57: return
    //   58: aload_0
    //   59: iconst_0
    //   60: putfield 22	com/tencent/mobileqq/ar/arengine/ARLocalGestureCircleRecog$ProcessWorker:c	Z
    //   63: aload_0
    //   64: getfield 17	com/tencent/mobileqq/ar/arengine/ARLocalGestureCircleRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalGestureCircleRecog;
    //   67: invokestatic 85	com/tencent/mobileqq/ar/arengine/ARLocalGestureCircleRecog:c	(Lcom/tencent/mobileqq/ar/arengine/ARLocalGestureCircleRecog;)Ljava/lang/Object;
    //   70: astore_3
    //   71: aload_3
    //   72: monitorenter
    //   73: aload_0
    //   74: getfield 17	com/tencent/mobileqq/ar/arengine/ARLocalGestureCircleRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalGestureCircleRecog;
    //   77: iconst_1
    //   78: invokestatic 88	com/tencent/mobileqq/ar/arengine/ARLocalGestureCircleRecog:a	(Lcom/tencent/mobileqq/ar/arengine/ARLocalGestureCircleRecog;Z)Z
    //   81: pop
    //   82: aload_0
    //   83: getfield 17	com/tencent/mobileqq/ar/arengine/ARLocalGestureCircleRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalGestureCircleRecog;
    //   86: aload_0
    //   87: getfield 31	com/tencent/mobileqq/ar/arengine/ARLocalGestureCircleRecog$ProcessWorker:a	[B
    //   90: aload_0
    //   91: getfield 17	com/tencent/mobileqq/ar/arengine/ARLocalGestureCircleRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalGestureCircleRecog;
    //   94: invokestatic 27	com/tencent/mobileqq/ar/arengine/ARLocalGestureCircleRecog:a	(Lcom/tencent/mobileqq/ar/arengine/ARLocalGestureCircleRecog;)I
    //   97: aload_0
    //   98: getfield 17	com/tencent/mobileqq/ar/arengine/ARLocalGestureCircleRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalGestureCircleRecog;
    //   101: invokestatic 29	com/tencent/mobileqq/ar/arengine/ARLocalGestureCircleRecog:b	(Lcom/tencent/mobileqq/ar/arengine/ARLocalGestureCircleRecog;)I
    //   104: bipush 17
    //   106: invokevirtual 91	com/tencent/mobileqq/ar/arengine/ARLocalGestureCircleRecog:a	([BIII)Lcom/tencent/mobileqq/ar/arengine/ARLocalGestureCircleRecogResult;
    //   109: astore_2
    //   110: new 93	java/lang/StringBuilder
    //   113: dup
    //   114: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   117: astore 4
    //   119: aload 4
    //   121: ldc 96
    //   123: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: pop
    //   127: aload 4
    //   129: aload_2
    //   130: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   133: pop
    //   134: aload 4
    //   136: ldc 105
    //   138: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: pop
    //   142: aload 4
    //   144: aload_0
    //   145: getfield 17	com/tencent/mobileqq/ar/arengine/ARLocalGestureCircleRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalGestureCircleRecog;
    //   148: invokestatic 108	com/tencent/mobileqq/ar/arengine/ARLocalGestureCircleRecog:d	(Lcom/tencent/mobileqq/ar/arengine/ARLocalGestureCircleRecog;)Lcom/tencent/mobileqq/ar/arengine/ARLocalGestureCircleRecogResult;
    //   151: getfield 113	com/tencent/mobileqq/ar/arengine/ARLocalGestureCircleRecogResult:b	Lcom/tencent/mobileqq/ar/arengine/ARLocalGestureCircleRecogResult$ARGestureResult;
    //   154: getfield 119	com/tencent/mobileqq/ar/arengine/ARLocalGestureCircleRecogResult$ARGestureResult:g	I
    //   157: invokevirtual 122	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   160: pop
    //   161: ldc 124
    //   163: iconst_1
    //   164: aload 4
    //   166: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   169: invokestatic 134	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   172: aload_0
    //   173: getfield 17	com/tencent/mobileqq/ar/arengine/ARLocalGestureCircleRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalGestureCircleRecog;
    //   176: invokestatic 138	com/tencent/mobileqq/ar/arengine/ARLocalGestureCircleRecog:e	(Lcom/tencent/mobileqq/ar/arengine/ARLocalGestureCircleRecog;)Z
    //   179: ifeq +52 -> 231
    //   182: aload_0
    //   183: getfield 17	com/tencent/mobileqq/ar/arengine/ARLocalGestureCircleRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalGestureCircleRecog;
    //   186: invokestatic 141	com/tencent/mobileqq/ar/arengine/ARLocalGestureCircleRecog:f	(Lcom/tencent/mobileqq/ar/arengine/ARLocalGestureCircleRecog;)Z
    //   189: ifne +42 -> 231
    //   192: aload_0
    //   193: getfield 17	com/tencent/mobileqq/ar/arengine/ARLocalGestureCircleRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalGestureCircleRecog;
    //   196: invokestatic 144	com/tencent/mobileqq/ar/arengine/ARLocalGestureCircleRecog:g	(Lcom/tencent/mobileqq/ar/arengine/ARLocalGestureCircleRecog;)Lcom/tencent/mobileqq/ar/arengine/ARLocalGestureCircleRecog$ARLocalGestureCircleRecogCallback;
    //   199: ifnull +32 -> 231
    //   202: aload_0
    //   203: getfield 17	com/tencent/mobileqq/ar/arengine/ARLocalGestureCircleRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalGestureCircleRecog;
    //   206: invokestatic 108	com/tencent/mobileqq/ar/arengine/ARLocalGestureCircleRecog:d	(Lcom/tencent/mobileqq/ar/arengine/ARLocalGestureCircleRecog;)Lcom/tencent/mobileqq/ar/arengine/ARLocalGestureCircleRecogResult;
    //   209: getfield 113	com/tencent/mobileqq/ar/arengine/ARLocalGestureCircleRecogResult:b	Lcom/tencent/mobileqq/ar/arengine/ARLocalGestureCircleRecogResult$ARGestureResult;
    //   212: getfield 119	com/tencent/mobileqq/ar/arengine/ARLocalGestureCircleRecogResult$ARGestureResult:g	I
    //   215: ifne +16 -> 231
    //   218: aload_0
    //   219: getfield 17	com/tencent/mobileqq/ar/arengine/ARLocalGestureCircleRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalGestureCircleRecog;
    //   222: invokestatic 144	com/tencent/mobileqq/ar/arengine/ARLocalGestureCircleRecog:g	(Lcom/tencent/mobileqq/ar/arengine/ARLocalGestureCircleRecog;)Lcom/tencent/mobileqq/ar/arengine/ARLocalGestureCircleRecog$ARLocalGestureCircleRecogCallback;
    //   225: aload_2
    //   226: invokeinterface 149 2 0
    //   231: aload_0
    //   232: getfield 17	com/tencent/mobileqq/ar/arengine/ARLocalGestureCircleRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalGestureCircleRecog;
    //   235: astore_2
    //   236: aload_2
    //   237: iconst_0
    //   238: invokestatic 88	com/tencent/mobileqq/ar/arengine/ARLocalGestureCircleRecog:a	(Lcom/tencent/mobileqq/ar/arengine/ARLocalGestureCircleRecog;Z)Z
    //   241: pop
    //   242: goto +35 -> 277
    //   245: astore_2
    //   246: goto +39 -> 285
    //   249: astore_2
    //   250: aload_2
    //   251: invokevirtual 150	java/lang/Exception:printStackTrace	()V
    //   254: invokestatic 154	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   257: ifeq +12 -> 269
    //   260: ldc 124
    //   262: iconst_2
    //   263: ldc 156
    //   265: aload_2
    //   266: invokestatic 159	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   269: aload_0
    //   270: getfield 17	com/tencent/mobileqq/ar/arengine/ARLocalGestureCircleRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalGestureCircleRecog;
    //   273: astore_2
    //   274: goto -38 -> 236
    //   277: invokestatic 162	com/tencent/mobileqq/ar/arengine/ARLocalGestureCircleRecog$ProcessWorker:yield	()V
    //   280: aload_3
    //   281: monitorexit
    //   282: goto -274 -> 8
    //   285: aload_0
    //   286: getfield 17	com/tencent/mobileqq/ar/arengine/ARLocalGestureCircleRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalGestureCircleRecog;
    //   289: iconst_0
    //   290: invokestatic 88	com/tencent/mobileqq/ar/arengine/ARLocalGestureCircleRecog:a	(Lcom/tencent/mobileqq/ar/arengine/ARLocalGestureCircleRecog;Z)Z
    //   293: pop
    //   294: aload_2
    //   295: athrow
    //   296: astore_2
    //   297: aload_3
    //   298: monitorexit
    //   299: aload_2
    //   300: athrow
    //   301: aload_0
    //   302: monitorexit
    //   303: return
    //   304: astore_2
    //   305: aload_0
    //   306: monitorexit
    //   307: goto +5 -> 312
    //   310: aload_2
    //   311: athrow
    //   312: goto -2 -> 310
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	315	0	this	ProcessWorker
    //   26	26	1	bool	boolean
    //   38	2	2	localInterruptedException	java.lang.InterruptedException
    //   109	128	2	localObject1	Object
    //   245	1	2	localObject2	Object
    //   249	17	2	localException	java.lang.Exception
    //   273	22	2	localARLocalGestureCircleRecog	ARLocalGestureCircleRecog
    //   296	4	2	localObject3	Object
    //   304	7	2	localObject4	Object
    //   70	228	3	localObject5	Object
    //   117	48	4	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   31	35	38	java/lang/InterruptedException
    //   82	231	245	finally
    //   250	269	245	finally
    //   82	231	249	java/lang/Exception
    //   73	82	296	finally
    //   231	236	296	finally
    //   236	242	296	finally
    //   269	274	296	finally
    //   277	282	296	finally
    //   285	296	296	finally
    //   297	299	296	finally
    //   2	8	304	finally
    //   8	15	304	finally
    //   15	27	304	finally
    //   31	35	304	finally
    //   39	43	304	finally
    //   46	51	304	finally
    //   58	73	304	finally
    //   299	301	304	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARLocalGestureCircleRecog.ProcessWorker
 * JD-Core Version:    0.7.0.1
 */