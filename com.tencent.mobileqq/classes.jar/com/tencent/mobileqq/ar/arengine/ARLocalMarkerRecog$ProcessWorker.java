package com.tencent.mobileqq.ar.arengine;

import aoel;

class ARLocalMarkerRecog$ProcessWorker
  extends Thread
{
  private long jdField_a_of_type_Long;
  private boolean jdField_a_of_type_Boolean;
  byte[] jdField_a_of_type_ArrayOfByte = new byte[ARLocalMarkerRecog.a(this.this$0) * ARLocalMarkerRecog.b(this.this$0) * 3 / 2];
  private long jdField_b_of_type_Long = aoel.a().jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean = true;
  private long jdField_c_of_type_Long;
  private boolean jdField_c_of_type_Boolean;
  private long d;
  
  public ARLocalMarkerRecog$ProcessWorker(ARLocalMarkerRecog paramARLocalMarkerRecog)
  {
    setDaemon(true);
    start();
  }
  
  public void a()
  {
    this.jdField_b_of_type_Boolean = false;
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
    long l;
    if (getState() == Thread.State.WAITING) {
      if (ARLocalMarkerRecog.c(this.this$0) == 2)
      {
        l = System.currentTimeMillis();
        if (((!this.jdField_c_of_type_Boolean) || (l - this.d >= 1500L)) && ((ARLocalMarkerRecog.e(this.this$0) == 0L) || (l - ARLocalMarkerRecog.e(this.this$0) >= 5000L)) && (ARLocalMarkerRecog.f(this.this$0) >= 2)) {
          break label152;
        }
      }
    }
    for (;;)
    {
      if (l - this.jdField_c_of_type_Long >= this.jdField_b_of_type_Long) {
        ARLocalMarkerRecog.b(this.this$0, 0);
      }
      System.arraycopy(paramArrayOfByte, 0, this.jdField_a_of_type_ArrayOfByte, 0, this.jdField_a_of_type_ArrayOfByte.length);
      this.jdField_c_of_type_Long = System.currentTimeMillis();
      this.jdField_a_of_type_Long = paramLong;
      this.jdField_a_of_type_Boolean = true;
      label152:
      do
      {
        try
        {
          notify();
          return;
        }
        finally {}
      } while (l - this.jdField_c_of_type_Long < this.jdField_b_of_type_Long);
      if (ARLocalMarkerRecog.e(this.this$0) != 0L) {
        ARLocalMarkerRecog.d(this.this$0, 0L);
      }
    }
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: ldc 111
    //   5: invokevirtual 115	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:setName	(Ljava/lang/String;)V
    //   8: bipush 12
    //   10: newarray float
    //   12: astore 13
    //   14: iconst_1
    //   15: invokestatic 121	com/youtu/arsdk/ARTargetInfo:allocateInitialized	(I)[Lcom/youtu/arsdk/ARTargetInfo;
    //   18: astore 14
    //   20: aload_0
    //   21: getfield 41	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:jdField_b_of_type_Boolean	Z
    //   24: ifeq +72 -> 96
    //   27: aload_0
    //   28: getfield 101	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:jdField_a_of_type_Boolean	Z
    //   31: ifne +54 -> 85
    //   34: aload_0
    //   35: getfield 41	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:jdField_b_of_type_Boolean	Z
    //   38: istore 6
    //   40: iload 6
    //   42: ifeq +43 -> 85
    //   45: aload_0
    //   46: invokevirtual 124	java/lang/Object:wait	()V
    //   49: goto -22 -> 27
    //   52: astore 13
    //   54: aload 13
    //   56: invokevirtual 127	java/lang/InterruptedException:printStackTrace	()V
    //   59: invokestatic 133	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   62: ifeq -35 -> 27
    //   65: ldc 135
    //   67: iconst_2
    //   68: ldc 137
    //   70: aload 13
    //   72: invokestatic 141	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   75: goto -48 -> 27
    //   78: astore 13
    //   80: aload_0
    //   81: monitorexit
    //   82: aload 13
    //   84: athrow
    //   85: aload_0
    //   86: getfield 41	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:jdField_b_of_type_Boolean	Z
    //   89: istore 6
    //   91: iload 6
    //   93: ifne +6 -> 99
    //   96: aload_0
    //   97: monitorexit
    //   98: return
    //   99: aload_0
    //   100: iconst_0
    //   101: putfield 101	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:jdField_a_of_type_Boolean	Z
    //   104: invokestatic 73	java/lang/System:currentTimeMillis	()J
    //   107: pop2
    //   108: aload_0
    //   109: getfield 17	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   112: invokestatic 144	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:a	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)Ljava/lang/Object;
    //   115: astore 13
    //   117: aload 13
    //   119: monitorenter
    //   120: aload_0
    //   121: getfield 17	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   124: iconst_1
    //   125: invokestatic 147	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:a	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;Z)Z
    //   128: pop
    //   129: aload_0
    //   130: getfield 17	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   133: invokestatic 67	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:c	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)I
    //   136: iconst_2
    //   137: if_icmpne +136 -> 273
    //   140: aload_0
    //   141: getfield 17	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   144: invokestatic 149	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:b	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)Ljava/lang/Object;
    //   147: astore 15
    //   149: aload 15
    //   151: monitorenter
    //   152: iconst_0
    //   153: istore_2
    //   154: iload_2
    //   155: aload_0
    //   156: getfield 17	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   159: invokestatic 152	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:a	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)Ljava/util/ArrayList;
    //   162: invokevirtual 158	java/util/ArrayList:size	()I
    //   165: if_icmpge +105 -> 270
    //   168: aload_0
    //   169: getfield 17	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   172: invokestatic 152	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:a	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)Ljava/util/ArrayList;
    //   175: iload_2
    //   176: invokevirtual 162	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   179: checkcast 164	aoij
    //   182: getfield 165	aoij:jdField_a_of_type_Boolean	Z
    //   185: ifne +1407 -> 1592
    //   188: aload_0
    //   189: getfield 17	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   192: aload_0
    //   193: getfield 17	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   196: invokestatic 152	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:a	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)Ljava/util/ArrayList;
    //   199: iload_2
    //   200: invokevirtual 162	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   203: checkcast 164	aoij
    //   206: getfield 168	aoij:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   209: aload_0
    //   210: getfield 17	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   213: invokestatic 152	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:a	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)Ljava/util/ArrayList;
    //   216: iload_2
    //   217: invokevirtual 162	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   220: checkcast 164	aoij
    //   223: getfield 170	aoij:b	Ljava/lang/String;
    //   226: aload_0
    //   227: getfield 17	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   230: invokestatic 152	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:a	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)Ljava/util/ArrayList;
    //   233: iload_2
    //   234: invokevirtual 162	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   237: checkcast 164	aoij
    //   240: getfield 173	aoij:jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo	Lcom/tencent/mobileqq/ar/aidl/ArCloudConfigInfo;
    //   243: invokestatic 176	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:a	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/ar/aidl/ArCloudConfigInfo;)Z
    //   246: ifeq +1346 -> 1592
    //   249: aload_0
    //   250: getfield 17	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   253: invokestatic 152	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:a	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)Ljava/util/ArrayList;
    //   256: iload_2
    //   257: invokevirtual 162	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   260: checkcast 164	aoij
    //   263: iconst_1
    //   264: putfield 165	aoij:jdField_a_of_type_Boolean	Z
    //   267: goto +1325 -> 1592
    //   270: aload 15
    //   272: monitorexit
    //   273: iconst_m1
    //   274: istore_3
    //   275: aload_0
    //   276: getfield 17	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   279: invokestatic 67	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:c	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)I
    //   282: istore 5
    //   284: iload_3
    //   285: istore_2
    //   286: invokestatic 73	java/lang/System:currentTimeMillis	()J
    //   289: lstore 7
    //   291: iload_3
    //   292: istore_2
    //   293: aload_0
    //   294: getfield 17	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   297: invokestatic 178	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:c	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)Ljava/lang/Object;
    //   300: astore 15
    //   302: iload_3
    //   303: istore_2
    //   304: aload 15
    //   306: monitorenter
    //   307: iload 5
    //   309: iconst_2
    //   310: if_icmpne +884 -> 1194
    //   313: iload_3
    //   314: istore_2
    //   315: invokestatic 73	java/lang/System:currentTimeMillis	()J
    //   318: lstore 9
    //   320: iload_3
    //   321: istore_2
    //   322: aload_0
    //   323: getfield 29	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:jdField_a_of_type_ArrayOfByte	[B
    //   326: aload 14
    //   328: invokestatic 184	com/youtu/arsdk/ARShell:nativeRecognize	([B[Lcom/youtu/arsdk/ARTargetInfo;)I
    //   331: istore 4
    //   333: aload 14
    //   335: iconst_0
    //   336: aaload
    //   337: astore 16
    //   339: iload 4
    //   341: ifne +848 -> 1189
    //   344: iload 4
    //   346: istore_2
    //   347: aload 14
    //   349: iconst_0
    //   350: aaload
    //   351: getfield 188	com/youtu/arsdk/ARTargetInfo:pose	[F
    //   354: bipush 14
    //   356: faload
    //   357: ldc 189
    //   359: fcmpl
    //   360: iflt +829 -> 1189
    //   363: iconst_0
    //   364: istore_3
    //   365: iload 4
    //   367: istore_2
    //   368: aload 16
    //   370: iload_3
    //   371: putfield 192	com/youtu/arsdk/ARTargetInfo:state	I
    //   374: iload 4
    //   376: istore_2
    //   377: invokestatic 73	java/lang/System:currentTimeMillis	()J
    //   380: lstore 11
    //   382: iload 4
    //   384: istore_2
    //   385: aload_0
    //   386: getfield 17	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   389: invokestatic 194	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:d	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)I
    //   392: pop
    //   393: iload 4
    //   395: istore_2
    //   396: aload_0
    //   397: getfield 17	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   400: lload 11
    //   402: lload 7
    //   404: lsub
    //   405: aload_0
    //   406: getfield 17	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   409: invokestatic 196	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:a	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)J
    //   412: ladd
    //   413: invokestatic 198	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:a	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;J)J
    //   416: pop2
    //   417: iload 4
    //   419: istore_2
    //   420: invokestatic 73	java/lang/System:currentTimeMillis	()J
    //   423: lstore 11
    //   425: iload 4
    //   427: istore_3
    //   428: iload 4
    //   430: istore_2
    //   431: iload 5
    //   433: aload 14
    //   435: iconst_0
    //   436: aaload
    //   437: getfield 192	com/youtu/arsdk/ARTargetInfo:state	I
    //   440: if_icmpeq +73 -> 513
    //   443: iload 4
    //   445: istore_2
    //   446: ldc 135
    //   448: iconst_1
    //   449: new 200	java/lang/StringBuilder
    //   452: dup
    //   453: invokespecial 201	java/lang/StringBuilder:<init>	()V
    //   456: ldc 203
    //   458: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   461: lload 11
    //   463: lload 9
    //   465: lsub
    //   466: invokevirtual 210	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   469: ldc 212
    //   471: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   474: lload 9
    //   476: invokevirtual 210	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   479: ldc 214
    //   481: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   484: lload 11
    //   486: invokevirtual 210	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   489: ldc 216
    //   491: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   494: aload 14
    //   496: iconst_0
    //   497: aaload
    //   498: getfield 192	com/youtu/arsdk/ARTargetInfo:state	I
    //   501: invokevirtual 219	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   504: invokevirtual 223	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   507: invokestatic 226	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   510: iload 4
    //   512: istore_3
    //   513: iload_3
    //   514: istore_2
    //   515: aload 15
    //   517: monitorexit
    //   518: iload 5
    //   520: iconst_2
    //   521: if_icmpne +922 -> 1443
    //   524: iload_3
    //   525: istore_2
    //   526: invokestatic 231	anxy:a	()Lanxy;
    //   529: invokestatic 73	java/lang/System:currentTimeMillis	()J
    //   532: lload 7
    //   534: lsub
    //   535: invokevirtual 234	anxy:b	(J)V
    //   538: aload_0
    //   539: getfield 17	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   542: astore 15
    //   544: iload_3
    //   545: ifne +915 -> 1460
    //   548: aload 14
    //   550: iconst_0
    //   551: aaload
    //   552: getfield 188	com/youtu/arsdk/ARTargetInfo:pose	[F
    //   555: bipush 14
    //   557: faload
    //   558: ldc 189
    //   560: fcmpl
    //   561: iflt +899 -> 1460
    //   564: aload 14
    //   566: iconst_0
    //   567: aaload
    //   568: getfield 192	com/youtu/arsdk/ARTargetInfo:state	I
    //   571: istore_2
    //   572: aload 15
    //   574: iload_2
    //   575: invokestatic 236	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:a	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;I)I
    //   578: pop
    //   579: aload_0
    //   580: getfield 17	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   583: astore 15
    //   585: aload_0
    //   586: getfield 17	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   589: invokestatic 67	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:c	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)I
    //   592: iconst_2
    //   593: if_icmpne +872 -> 1465
    //   596: aload_0
    //   597: getfield 17	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   600: invokestatic 88	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:f	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)I
    //   603: iconst_1
    //   604: iadd
    //   605: istore_2
    //   606: aload 15
    //   608: iload_2
    //   609: invokestatic 93	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:b	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;I)I
    //   612: pop
    //   613: iload 5
    //   615: iconst_2
    //   616: if_icmpeq +854 -> 1470
    //   619: aload_0
    //   620: getfield 17	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   623: invokestatic 67	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:c	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)I
    //   626: iconst_2
    //   627: if_icmpne +843 -> 1470
    //   630: aload_0
    //   631: iconst_1
    //   632: putfield 75	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:jdField_c_of_type_Boolean	Z
    //   635: aload_0
    //   636: invokestatic 73	java/lang/System:currentTimeMillis	()J
    //   639: putfield 77	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:d	J
    //   642: aload_0
    //   643: getfield 17	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   646: invokestatic 239	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:g	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)I
    //   649: ifne +11 -> 660
    //   652: aload_0
    //   653: getfield 17	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   656: invokestatic 242	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:h	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)I
    //   659: pop
    //   660: aload_0
    //   661: getfield 17	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   664: invokestatic 67	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:c	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)I
    //   667: ifne +58 -> 725
    //   670: aload_0
    //   671: getfield 17	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   674: invokestatic 239	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:g	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)I
    //   677: ifne +48 -> 725
    //   680: aload_0
    //   681: getfield 17	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   684: invokestatic 73	java/lang/System:currentTimeMillis	()J
    //   687: invokestatic 244	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:c	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;J)J
    //   690: pop2
    //   691: aload_0
    //   692: getfield 17	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   695: aload_0
    //   696: getfield 17	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   699: invokestatic 246	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:c	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)J
    //   702: aload_0
    //   703: getfield 17	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   706: invokestatic 248	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:d	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)J
    //   709: lsub
    //   710: l2i
    //   711: invokestatic 250	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:c	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;I)I
    //   714: pop
    //   715: aload_0
    //   716: getfield 17	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   719: ldc 252
    //   721: invokestatic 255	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:a	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;Ljava/lang/String;)Ljava/lang/String;
    //   724: pop
    //   725: iconst_2
    //   726: istore_2
    //   727: aload_0
    //   728: getfield 17	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   731: invokestatic 67	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:c	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)I
    //   734: iconst_2
    //   735: if_icmpne +759 -> 1494
    //   738: aload_0
    //   739: getfield 17	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   742: iconst_0
    //   743: invokestatic 257	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:d	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;I)I
    //   746: pop
    //   747: iconst_2
    //   748: istore_2
    //   749: new 259	aoik
    //   752: dup
    //   753: invokespecial 260	aoik:<init>	()V
    //   756: astore 15
    //   758: aload 15
    //   760: iload_2
    //   761: putfield 262	aoik:jdField_a_of_type_Int	I
    //   764: iload_2
    //   765: iconst_2
    //   766: if_icmpeq +309 -> 1075
    //   769: new 264	com/youtu/arsdk/ARPatternInfo
    //   772: dup
    //   773: invokespecial 265	com/youtu/arsdk/ARPatternInfo:<init>	()V
    //   776: astore 16
    //   778: aload 14
    //   780: iconst_0
    //   781: aaload
    //   782: getfield 268	com/youtu/arsdk/ARTargetInfo:markerIndex	I
    //   785: i2l
    //   786: aload 16
    //   788: invokestatic 272	com/youtu/arsdk/ARShell:getMarkerInfo	(JLcom/youtu/arsdk/ARPatternInfo;)I
    //   791: pop
    //   792: iload_2
    //   793: ifne +131 -> 924
    //   796: ldc 135
    //   798: iconst_1
    //   799: new 200	java/lang/StringBuilder
    //   802: dup
    //   803: invokespecial 201	java/lang/StringBuilder:<init>	()V
    //   806: ldc_w 274
    //   809: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   812: aload 16
    //   814: getfield 277	com/youtu/arsdk/ARPatternInfo:name	Ljava/lang/String;
    //   817: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   820: ldc_w 279
    //   823: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   826: aload 16
    //   828: getfield 282	com/youtu/arsdk/ARPatternInfo:markerType	I
    //   831: invokevirtual 219	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   834: ldc_w 284
    //   837: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   840: aload 16
    //   842: getfield 287	com/youtu/arsdk/ARPatternInfo:index	J
    //   845: invokevirtual 210	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   848: ldc_w 289
    //   851: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   854: aload 16
    //   856: getfield 293	com/youtu/arsdk/ARPatternInfo:xSize	F
    //   859: invokevirtual 296	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   862: ldc_w 298
    //   865: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   868: aload 16
    //   870: getfield 301	com/youtu/arsdk/ARPatternInfo:ySize	F
    //   873: invokevirtual 296	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   876: ldc_w 303
    //   879: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   882: aload 16
    //   884: getfield 306	com/youtu/arsdk/ARPatternInfo:param1	F
    //   887: invokevirtual 296	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   890: ldc_w 308
    //   893: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   896: aload 16
    //   898: getfield 311	com/youtu/arsdk/ARPatternInfo:param2	F
    //   901: invokevirtual 296	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   904: ldc_w 313
    //   907: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   910: aload 16
    //   912: getfield 316	com/youtu/arsdk/ARPatternInfo:param3	F
    //   915: invokevirtual 296	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   918: invokevirtual 223	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   921: invokestatic 226	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   924: aload 15
    //   926: aload 16
    //   928: getfield 277	com/youtu/arsdk/ARPatternInfo:name	Ljava/lang/String;
    //   931: putfield 317	aoik:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   934: aload 15
    //   936: aload 16
    //   938: getfield 282	com/youtu/arsdk/ARPatternInfo:markerType	I
    //   941: putfield 318	aoik:jdField_b_of_type_Int	I
    //   944: aload 16
    //   946: getfield 282	com/youtu/arsdk/ARPatternInfo:markerType	I
    //   949: iconst_1
    //   950: if_icmpne +619 -> 1569
    //   953: aload 16
    //   955: getfield 306	com/youtu/arsdk/ARPatternInfo:param1	F
    //   958: fstore_1
    //   959: aload 15
    //   961: fload_1
    //   962: putfield 320	aoik:jdField_a_of_type_Float	F
    //   965: aload 16
    //   967: getfield 282	com/youtu/arsdk/ARPatternInfo:markerType	I
    //   970: iconst_1
    //   971: if_icmpne +607 -> 1578
    //   974: aload 16
    //   976: getfield 311	com/youtu/arsdk/ARPatternInfo:param2	F
    //   979: fstore_1
    //   980: aload 15
    //   982: fload_1
    //   983: putfield 322	aoik:jdField_b_of_type_Float	F
    //   986: aload 16
    //   988: getfield 282	com/youtu/arsdk/ARPatternInfo:markerType	I
    //   991: iconst_1
    //   992: if_icmpne +595 -> 1587
    //   995: aload 16
    //   997: getfield 316	com/youtu/arsdk/ARPatternInfo:param3	F
    //   1000: fstore_1
    //   1001: aload 15
    //   1003: fload_1
    //   1004: putfield 324	aoik:c	F
    //   1007: aload 15
    //   1009: bipush 16
    //   1011: newarray float
    //   1013: putfield 326	aoik:jdField_a_of_type_ArrayOfFloat	[F
    //   1016: aload 14
    //   1018: iconst_0
    //   1019: aaload
    //   1020: getfield 188	com/youtu/arsdk/ARTargetInfo:pose	[F
    //   1023: iconst_0
    //   1024: aload 15
    //   1026: getfield 326	aoik:jdField_a_of_type_ArrayOfFloat	[F
    //   1029: iconst_0
    //   1030: aload 14
    //   1032: iconst_0
    //   1033: aaload
    //   1034: getfield 188	com/youtu/arsdk/ARTargetInfo:pose	[F
    //   1037: arraylength
    //   1038: invokestatic 97	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   1041: aload 15
    //   1043: aload_0
    //   1044: getfield 17	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   1047: invokestatic 329	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:a	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)Ljava/util/Map;
    //   1050: aload 16
    //   1052: getfield 277	com/youtu/arsdk/ARPatternInfo:name	Ljava/lang/String;
    //   1055: invokeinterface 334 2 0
    //   1060: checkcast 336	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo
    //   1063: putfield 337	aoik:jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo	Lcom/tencent/mobileqq/ar/aidl/ArCloudConfigInfo;
    //   1066: aload 15
    //   1068: aload_0
    //   1069: getfield 99	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:jdField_a_of_type_Long	J
    //   1072: putfield 338	aoik:jdField_a_of_type_Long	J
    //   1075: aload_0
    //   1076: getfield 17	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   1079: invokestatic 341	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:a	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)Z
    //   1082: ifeq +37 -> 1119
    //   1085: aload_0
    //   1086: getfield 17	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   1089: invokestatic 343	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:b	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)Z
    //   1092: ifne +27 -> 1119
    //   1095: aload_0
    //   1096: getfield 17	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   1099: invokestatic 346	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:a	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)Laoii;
    //   1102: ifnull +17 -> 1119
    //   1105: aload_0
    //   1106: getfield 17	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   1109: invokestatic 346	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:a	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)Laoii;
    //   1112: aload 15
    //   1114: invokeinterface 351 2 0
    //   1119: aload_0
    //   1120: getfield 17	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   1123: iconst_0
    //   1124: invokestatic 147	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:a	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;Z)Z
    //   1127: pop
    //   1128: invokestatic 354	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:yield	()V
    //   1131: aload 13
    //   1133: monitorexit
    //   1134: goto -1114 -> 20
    //   1137: astore 14
    //   1139: aload 13
    //   1141: monitorexit
    //   1142: aload 14
    //   1144: athrow
    //   1145: astore 16
    //   1147: aload 15
    //   1149: monitorexit
    //   1150: aload 16
    //   1152: athrow
    //   1153: astore 15
    //   1155: aload 15
    //   1157: invokevirtual 355	java/lang/Exception:printStackTrace	()V
    //   1160: invokestatic 133	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1163: ifeq +14 -> 1177
    //   1166: ldc 135
    //   1168: iconst_2
    //   1169: ldc_w 357
    //   1172: aload 15
    //   1174: invokestatic 359	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1177: aload_0
    //   1178: getfield 17	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   1181: iconst_0
    //   1182: invokestatic 147	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:a	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;Z)Z
    //   1185: pop
    //   1186: goto -58 -> 1128
    //   1189: iconst_2
    //   1190: istore_3
    //   1191: goto -826 -> 365
    //   1194: iload_3
    //   1195: istore_2
    //   1196: invokestatic 73	java/lang/System:currentTimeMillis	()J
    //   1199: lstore 9
    //   1201: iload_3
    //   1202: istore_2
    //   1203: aload_0
    //   1204: getfield 29	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:jdField_a_of_type_ArrayOfByte	[B
    //   1207: aload 14
    //   1209: invokestatic 362	com/youtu/arsdk/ARShell:nativeTrack	([B[Lcom/youtu/arsdk/ARTargetInfo;)I
    //   1212: istore_3
    //   1213: aload 14
    //   1215: iconst_0
    //   1216: aaload
    //   1217: astore 16
    //   1219: iload_3
    //   1220: ifne +217 -> 1437
    //   1223: iload_3
    //   1224: istore_2
    //   1225: aload 14
    //   1227: iconst_0
    //   1228: aaload
    //   1229: getfield 188	com/youtu/arsdk/ARTargetInfo:pose	[F
    //   1232: bipush 14
    //   1234: faload
    //   1235: ldc 189
    //   1237: fcmpl
    //   1238: iflt +199 -> 1437
    //   1241: iconst_1
    //   1242: istore 4
    //   1244: iload_3
    //   1245: istore_2
    //   1246: aload 16
    //   1248: iload 4
    //   1250: putfield 192	com/youtu/arsdk/ARTargetInfo:state	I
    //   1253: iload_3
    //   1254: istore_2
    //   1255: invokestatic 73	java/lang/System:currentTimeMillis	()J
    //   1258: lstore 11
    //   1260: iload_3
    //   1261: istore_2
    //   1262: iload 5
    //   1264: aload 14
    //   1266: iconst_0
    //   1267: aaload
    //   1268: getfield 192	com/youtu/arsdk/ARTargetInfo:state	I
    //   1271: if_icmpeq +70 -> 1341
    //   1274: iload_3
    //   1275: istore_2
    //   1276: ldc 135
    //   1278: iconst_1
    //   1279: new 200	java/lang/StringBuilder
    //   1282: dup
    //   1283: invokespecial 201	java/lang/StringBuilder:<init>	()V
    //   1286: ldc_w 364
    //   1289: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1292: lload 11
    //   1294: lload 9
    //   1296: lsub
    //   1297: invokevirtual 210	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1300: ldc 212
    //   1302: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1305: lload 9
    //   1307: invokevirtual 210	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1310: ldc 214
    //   1312: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1315: lload 11
    //   1317: invokevirtual 210	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1320: ldc 216
    //   1322: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1325: aload 14
    //   1327: iconst_0
    //   1328: aaload
    //   1329: getfield 192	com/youtu/arsdk/ARTargetInfo:state	I
    //   1332: invokevirtual 219	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1335: invokevirtual 223	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1338: invokestatic 226	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1341: iload_3
    //   1342: istore_2
    //   1343: invokestatic 73	java/lang/System:currentTimeMillis	()J
    //   1346: lstore 9
    //   1348: iload_3
    //   1349: istore_2
    //   1350: aload_0
    //   1351: getfield 17	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   1354: invokestatic 366	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:e	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)I
    //   1357: pop
    //   1358: iload_3
    //   1359: istore_2
    //   1360: aload_0
    //   1361: getfield 17	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   1364: lload 9
    //   1366: lload 7
    //   1368: lsub
    //   1369: aload_0
    //   1370: getfield 17	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   1373: invokestatic 368	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:b	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)J
    //   1376: ladd
    //   1377: invokestatic 370	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:b	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;J)J
    //   1380: pop2
    //   1381: goto -868 -> 513
    //   1384: astore 16
    //   1386: aload 15
    //   1388: monitorexit
    //   1389: aload 16
    //   1391: athrow
    //   1392: astore 15
    //   1394: aload 15
    //   1396: invokevirtual 355	java/lang/Exception:printStackTrace	()V
    //   1399: iload_2
    //   1400: istore_3
    //   1401: invokestatic 133	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1404: ifeq -866 -> 538
    //   1407: ldc 135
    //   1409: iconst_2
    //   1410: ldc_w 372
    //   1413: aload 15
    //   1415: invokestatic 359	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1418: iload_2
    //   1419: istore_3
    //   1420: goto -882 -> 538
    //   1423: astore 14
    //   1425: aload_0
    //   1426: getfield 17	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   1429: iconst_0
    //   1430: invokestatic 147	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:a	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;Z)Z
    //   1433: pop
    //   1434: aload 14
    //   1436: athrow
    //   1437: iconst_2
    //   1438: istore 4
    //   1440: goto -196 -> 1244
    //   1443: iload_3
    //   1444: istore_2
    //   1445: invokestatic 231	anxy:a	()Lanxy;
    //   1448: invokestatic 73	java/lang/System:currentTimeMillis	()J
    //   1451: lload 7
    //   1453: lsub
    //   1454: invokevirtual 374	anxy:c	(J)V
    //   1457: goto -919 -> 538
    //   1460: iconst_2
    //   1461: istore_2
    //   1462: goto -890 -> 572
    //   1465: iconst_0
    //   1466: istore_2
    //   1467: goto -861 -> 606
    //   1470: aload_0
    //   1471: getfield 17	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   1474: invokestatic 67	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:c	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)I
    //   1477: iconst_2
    //   1478: if_icmpeq -836 -> 642
    //   1481: aload_0
    //   1482: iconst_0
    //   1483: putfield 75	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:jdField_c_of_type_Boolean	Z
    //   1486: aload_0
    //   1487: lconst_0
    //   1488: putfield 77	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:d	J
    //   1491: goto -849 -> 642
    //   1494: aload_0
    //   1495: getfield 17	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   1498: invokestatic 67	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:c	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)I
    //   1501: ifne +17 -> 1518
    //   1504: aload_0
    //   1505: getfield 17	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   1508: iconst_0
    //   1509: invokestatic 257	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:d	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;I)I
    //   1512: pop
    //   1513: iconst_2
    //   1514: istore_2
    //   1515: goto -766 -> 749
    //   1518: aload_0
    //   1519: getfield 17	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   1522: invokestatic 67	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:c	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)I
    //   1525: iconst_1
    //   1526: if_icmpne -777 -> 749
    //   1529: aload_0
    //   1530: getfield 17	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   1533: invokestatic 376	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:i	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)I
    //   1536: pop
    //   1537: aload_0
    //   1538: getfield 17	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   1541: invokestatic 379	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:j	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)I
    //   1544: iconst_2
    //   1545: if_icmpge +8 -> 1553
    //   1548: iconst_2
    //   1549: istore_2
    //   1550: goto -801 -> 749
    //   1553: aload_0
    //   1554: getfield 17	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   1557: invokestatic 379	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:j	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)I
    //   1560: iconst_2
    //   1561: if_icmpne +38 -> 1599
    //   1564: iconst_0
    //   1565: istore_2
    //   1566: goto -817 -> 749
    //   1569: aload 16
    //   1571: getfield 293	com/youtu/arsdk/ARPatternInfo:xSize	F
    //   1574: fstore_1
    //   1575: goto -616 -> 959
    //   1578: aload 16
    //   1580: getfield 301	com/youtu/arsdk/ARPatternInfo:ySize	F
    //   1583: fstore_1
    //   1584: goto -604 -> 980
    //   1587: fconst_0
    //   1588: fstore_1
    //   1589: goto -588 -> 1001
    //   1592: iload_2
    //   1593: iconst_1
    //   1594: iadd
    //   1595: istore_2
    //   1596: goto -1442 -> 154
    //   1599: iconst_1
    //   1600: istore_2
    //   1601: goto -852 -> 749
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1604	0	this	ProcessWorker
    //   958	631	1	f	float
    //   153	1448	2	i	int
    //   274	1170	3	j	int
    //   331	1108	4	k	int
    //   282	990	5	m	int
    //   38	54	6	bool	boolean
    //   289	1163	7	l1	long
    //   318	1047	9	l2	long
    //   380	936	11	l3	long
    //   12	1	13	arrayOfFloat	float[]
    //   52	19	13	localInterruptedException	java.lang.InterruptedException
    //   78	5	13	localObject1	Object
    //   115	1025	13	localObject2	Object
    //   18	1013	14	arrayOfARTargetInfo1	com.youtu.arsdk.ARTargetInfo[]
    //   1137	189	14	arrayOfARTargetInfo2	com.youtu.arsdk.ARTargetInfo[]
    //   1423	12	14	localObject3	Object
    //   147	1001	15	localObject4	Object
    //   1153	234	15	localException1	java.lang.Exception
    //   1392	22	15	localException2	java.lang.Exception
    //   337	714	16	localObject5	Object
    //   1145	6	16	localObject6	Object
    //   1217	30	16	localARTargetInfo	com.youtu.arsdk.ARTargetInfo
    //   1384	195	16	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   45	49	52	java/lang/InterruptedException
    //   2	20	78	finally
    //   20	27	78	finally
    //   27	40	78	finally
    //   45	49	78	finally
    //   54	75	78	finally
    //   85	91	78	finally
    //   99	120	78	finally
    //   1142	1145	78	finally
    //   120	129	1137	finally
    //   1119	1128	1137	finally
    //   1128	1134	1137	finally
    //   1139	1142	1137	finally
    //   1177	1186	1137	finally
    //   1425	1437	1137	finally
    //   154	267	1145	finally
    //   270	273	1145	finally
    //   1147	1150	1145	finally
    //   129	152	1153	java/lang/Exception
    //   275	284	1153	java/lang/Exception
    //   538	544	1153	java/lang/Exception
    //   548	572	1153	java/lang/Exception
    //   572	606	1153	java/lang/Exception
    //   606	613	1153	java/lang/Exception
    //   619	642	1153	java/lang/Exception
    //   642	660	1153	java/lang/Exception
    //   660	725	1153	java/lang/Exception
    //   727	747	1153	java/lang/Exception
    //   749	764	1153	java/lang/Exception
    //   769	792	1153	java/lang/Exception
    //   796	924	1153	java/lang/Exception
    //   924	959	1153	java/lang/Exception
    //   959	980	1153	java/lang/Exception
    //   980	1001	1153	java/lang/Exception
    //   1001	1075	1153	java/lang/Exception
    //   1075	1119	1153	java/lang/Exception
    //   1150	1153	1153	java/lang/Exception
    //   1394	1399	1153	java/lang/Exception
    //   1401	1418	1153	java/lang/Exception
    //   1470	1491	1153	java/lang/Exception
    //   1494	1513	1153	java/lang/Exception
    //   1518	1548	1153	java/lang/Exception
    //   1553	1564	1153	java/lang/Exception
    //   1569	1575	1153	java/lang/Exception
    //   1578	1584	1153	java/lang/Exception
    //   315	320	1384	finally
    //   322	333	1384	finally
    //   347	363	1384	finally
    //   368	374	1384	finally
    //   377	382	1384	finally
    //   385	393	1384	finally
    //   396	417	1384	finally
    //   420	425	1384	finally
    //   431	443	1384	finally
    //   446	510	1384	finally
    //   515	518	1384	finally
    //   1196	1201	1384	finally
    //   1203	1213	1384	finally
    //   1225	1241	1384	finally
    //   1246	1253	1384	finally
    //   1255	1260	1384	finally
    //   1262	1274	1384	finally
    //   1276	1341	1384	finally
    //   1343	1348	1384	finally
    //   1350	1358	1384	finally
    //   1360	1381	1384	finally
    //   1386	1389	1384	finally
    //   286	291	1392	java/lang/Exception
    //   293	302	1392	java/lang/Exception
    //   304	307	1392	java/lang/Exception
    //   526	538	1392	java/lang/Exception
    //   1389	1392	1392	java/lang/Exception
    //   1445	1457	1392	java/lang/Exception
    //   129	152	1423	finally
    //   275	284	1423	finally
    //   286	291	1423	finally
    //   293	302	1423	finally
    //   304	307	1423	finally
    //   526	538	1423	finally
    //   538	544	1423	finally
    //   548	572	1423	finally
    //   572	606	1423	finally
    //   606	613	1423	finally
    //   619	642	1423	finally
    //   642	660	1423	finally
    //   660	725	1423	finally
    //   727	747	1423	finally
    //   749	764	1423	finally
    //   769	792	1423	finally
    //   796	924	1423	finally
    //   924	959	1423	finally
    //   959	980	1423	finally
    //   980	1001	1423	finally
    //   1001	1075	1423	finally
    //   1075	1119	1423	finally
    //   1150	1153	1423	finally
    //   1155	1177	1423	finally
    //   1389	1392	1423	finally
    //   1394	1399	1423	finally
    //   1401	1418	1423	finally
    //   1445	1457	1423	finally
    //   1470	1491	1423	finally
    //   1494	1513	1423	finally
    //   1518	1548	1423	finally
    //   1553	1564	1423	finally
    //   1569	1575	1423	finally
    //   1578	1584	1423	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARLocalMarkerRecog.ProcessWorker
 * JD-Core Version:    0.7.0.1
 */