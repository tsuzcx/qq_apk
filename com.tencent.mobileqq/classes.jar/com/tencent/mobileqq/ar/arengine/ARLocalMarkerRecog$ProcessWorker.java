package com.tencent.mobileqq.ar.arengine;

import com.tencent.mobileqq.ar.ScanEntranceDPC;

class ARLocalMarkerRecog$ProcessWorker
  extends Thread
{
  byte[] a = new byte[ARLocalMarkerRecog.a(this.this$0) * ARLocalMarkerRecog.b(this.this$0) * 3 / 2];
  private long b;
  private boolean c = false;
  private boolean d = true;
  private long e = ScanEntranceDPC.a().e;
  private long f;
  private boolean g;
  private long h;
  
  public ARLocalMarkerRecog$ProcessWorker(ARLocalMarkerRecog paramARLocalMarkerRecog)
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
      if (ARLocalMarkerRecog.d(this.this$0) == 2)
      {
        long l = System.currentTimeMillis();
        if (((!this.g) || (l - this.h >= 1500L)) && ((ARLocalMarkerRecog.w(this.this$0) == 0L) || (l - ARLocalMarkerRecog.w(this.this$0) >= 5000L)) && (ARLocalMarkerRecog.l(this.this$0) >= 2))
        {
          if (l - this.f < this.e) {
            return;
          }
          if (ARLocalMarkerRecog.w(this.this$0) != 0L) {
            ARLocalMarkerRecog.d(this.this$0, 0L);
          }
        }
        if (l - this.f >= this.e) {
          ARLocalMarkerRecog.b(this.this$0, 0);
        }
      }
      byte[] arrayOfByte = this.a;
      System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, arrayOfByte.length);
      this.f = System.currentTimeMillis();
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
    //   3: ldc 115
    //   5: invokevirtual 119	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:setName	(Ljava/lang/String;)V
    //   8: bipush 12
    //   10: newarray float
    //   12: astore 13
    //   14: iconst_1
    //   15: invokestatic 125	com/youtu/arsdk/ARTargetInfo:allocateInitialized	(I)[Lcom/youtu/arsdk/ARTargetInfo;
    //   18: astore 17
    //   20: ldc 127
    //   22: astore 15
    //   24: aload_0
    //   25: getfield 47	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:d	Z
    //   28: ifeq +1800 -> 1828
    //   31: aload_0
    //   32: getfield 26	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:c	Z
    //   35: ifne +47 -> 82
    //   38: aload_0
    //   39: getfield 47	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:d	Z
    //   42: istore 6
    //   44: iload 6
    //   46: ifeq +36 -> 82
    //   49: aload_0
    //   50: invokevirtual 130	java/lang/Object:wait	()V
    //   53: goto -22 -> 31
    //   56: astore 13
    //   58: aload 13
    //   60: invokevirtual 133	java/lang/InterruptedException:printStackTrace	()V
    //   63: invokestatic 139	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   66: ifeq -35 -> 31
    //   69: ldc 141
    //   71: iconst_2
    //   72: ldc 143
    //   74: aload 13
    //   76: invokestatic 147	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   79: goto -48 -> 31
    //   82: aload_0
    //   83: getfield 47	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:d	Z
    //   86: istore 6
    //   88: iload 6
    //   90: ifne +6 -> 96
    //   93: aload_0
    //   94: monitorexit
    //   95: return
    //   96: aload_0
    //   97: iconst_0
    //   98: putfield 26	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:c	Z
    //   101: invokestatic 79	java/lang/System:currentTimeMillis	()J
    //   104: pop2
    //   105: aload_0
    //   106: getfield 21	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   109: invokestatic 150	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:c	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)Ljava/lang/Object;
    //   112: astore 14
    //   114: aload 14
    //   116: monitorenter
    //   117: aload_0
    //   118: getfield 21	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   121: iconst_1
    //   122: invokestatic 153	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:a	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;Z)Z
    //   125: pop
    //   126: aload_0
    //   127: getfield 21	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   130: invokestatic 73	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:d	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)I
    //   133: iconst_2
    //   134: if_icmpne +147 -> 281
    //   137: aload_0
    //   138: getfield 21	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   141: invokestatic 155	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:e	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)Ljava/lang/Object;
    //   144: astore 13
    //   146: aload 13
    //   148: monitorenter
    //   149: iconst_0
    //   150: istore_2
    //   151: iload_2
    //   152: aload_0
    //   153: getfield 21	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   156: invokestatic 158	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:f	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)Ljava/util/ArrayList;
    //   159: invokevirtual 164	java/util/ArrayList:size	()I
    //   162: if_icmpge +105 -> 267
    //   165: aload_0
    //   166: getfield 21	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   169: invokestatic 158	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:f	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)Ljava/util/ArrayList;
    //   172: iload_2
    //   173: invokevirtual 168	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   176: checkcast 170	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$MarkerState
    //   179: getfield 171	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$MarkerState:d	Z
    //   182: ifne +1662 -> 1844
    //   185: aload_0
    //   186: getfield 21	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   189: aload_0
    //   190: getfield 21	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   193: invokestatic 158	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:f	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)Ljava/util/ArrayList;
    //   196: iload_2
    //   197: invokevirtual 168	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   200: checkcast 170	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$MarkerState
    //   203: getfield 174	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$MarkerState:a	Ljava/lang/String;
    //   206: aload_0
    //   207: getfield 21	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   210: invokestatic 158	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:f	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)Ljava/util/ArrayList;
    //   213: iload_2
    //   214: invokevirtual 168	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   217: checkcast 170	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$MarkerState
    //   220: getfield 176	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$MarkerState:b	Ljava/lang/String;
    //   223: aload_0
    //   224: getfield 21	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   227: invokestatic 158	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:f	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)Ljava/util/ArrayList;
    //   230: iload_2
    //   231: invokevirtual 168	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   234: checkcast 170	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$MarkerState
    //   237: getfield 179	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$MarkerState:c	Lcom/tencent/mobileqq/ar/aidl/ArCloudConfigInfo;
    //   240: invokestatic 182	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:a	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/ar/aidl/ArCloudConfigInfo;)Z
    //   243: ifeq +1601 -> 1844
    //   246: aload_0
    //   247: getfield 21	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   250: invokestatic 158	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:f	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)Ljava/util/ArrayList;
    //   253: iload_2
    //   254: invokevirtual 168	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   257: checkcast 170	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$MarkerState
    //   260: iconst_1
    //   261: putfield 171	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$MarkerState:d	Z
    //   264: goto +1580 -> 1844
    //   267: aload 13
    //   269: monitorexit
    //   270: goto +11 -> 281
    //   273: astore 16
    //   275: aload 13
    //   277: monitorexit
    //   278: aload 16
    //   280: athrow
    //   281: aload_0
    //   282: getfield 21	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   285: invokestatic 73	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:d	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)I
    //   288: istore_2
    //   289: invokestatic 79	java/lang/System:currentTimeMillis	()J
    //   292: lstore 7
    //   294: aload_0
    //   295: getfield 21	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   298: invokestatic 184	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:g	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)Ljava/lang/Object;
    //   301: astore 16
    //   303: aload 16
    //   305: monitorenter
    //   306: iload_2
    //   307: iconst_2
    //   308: if_icmpne +239 -> 547
    //   311: invokestatic 79	java/lang/System:currentTimeMillis	()J
    //   314: lstore 9
    //   316: aload_0
    //   317: getfield 35	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:a	[B
    //   320: aload 17
    //   322: invokestatic 190	com/youtu/arsdk/ARShell:nativeRecognize	([B[Lcom/youtu/arsdk/ARTargetInfo;)I
    //   325: istore_3
    //   326: aload 17
    //   328: iconst_0
    //   329: aaload
    //   330: astore 13
    //   332: iload_3
    //   333: ifne +32 -> 365
    //   336: aload 17
    //   338: iconst_0
    //   339: aaload
    //   340: getfield 194	com/youtu/arsdk/ARTargetInfo:pose	[F
    //   343: bipush 14
    //   345: faload
    //   346: fstore_1
    //   347: fload_1
    //   348: ldc 195
    //   350: fcmpl
    //   351: iflt +14 -> 365
    //   354: iconst_0
    //   355: istore 4
    //   357: goto +11 -> 368
    //   360: astore 13
    //   362: goto +177 -> 539
    //   365: iconst_2
    //   366: istore 4
    //   368: aload 13
    //   370: iload 4
    //   372: putfield 198	com/youtu/arsdk/ARTargetInfo:state	I
    //   375: invokestatic 79	java/lang/System:currentTimeMillis	()J
    //   378: lstore 11
    //   380: aload_0
    //   381: getfield 21	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   384: invokestatic 200	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:h	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)I
    //   387: pop
    //   388: aload_0
    //   389: getfield 21	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   392: aload_0
    //   393: getfield 21	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   396: invokestatic 202	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:i	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)J
    //   399: lload 11
    //   401: lload 7
    //   403: lsub
    //   404: ladd
    //   405: invokestatic 204	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:a	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;J)J
    //   408: pop2
    //   409: invokestatic 79	java/lang/System:currentTimeMillis	()J
    //   412: lstore 11
    //   414: aload 17
    //   416: iconst_0
    //   417: aaload
    //   418: getfield 198	com/youtu/arsdk/ARTargetInfo:state	I
    //   421: istore 4
    //   423: iload_2
    //   424: iload 4
    //   426: if_icmpeq +108 -> 534
    //   429: new 206	java/lang/StringBuilder
    //   432: dup
    //   433: invokespecial 207	java/lang/StringBuilder:<init>	()V
    //   436: astore 13
    //   438: aload 13
    //   440: ldc 209
    //   442: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   445: pop
    //   446: aload 13
    //   448: lload 11
    //   450: lload 9
    //   452: lsub
    //   453: invokevirtual 216	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   456: pop
    //   457: aload 13
    //   459: ldc 218
    //   461: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   464: pop
    //   465: aload 13
    //   467: lload 9
    //   469: invokevirtual 216	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   472: pop
    //   473: aload 13
    //   475: ldc 220
    //   477: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   480: pop
    //   481: aload 13
    //   483: lload 11
    //   485: invokevirtual 216	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   488: pop
    //   489: aload 13
    //   491: ldc 222
    //   493: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   496: pop
    //   497: aload 13
    //   499: aload 17
    //   501: iconst_0
    //   502: aaload
    //   503: getfield 198	com/youtu/arsdk/ARTargetInfo:state	I
    //   506: invokevirtual 225	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   509: pop
    //   510: ldc 141
    //   512: iconst_1
    //   513: aload 13
    //   515: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   518: invokestatic 232	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   521: goto +13 -> 534
    //   524: astore 13
    //   526: goto +5 -> 531
    //   529: astore 13
    //   531: goto +312 -> 843
    //   534: goto +236 -> 770
    //   537: astore 13
    //   539: goto +304 -> 843
    //   542: astore 13
    //   544: goto +297 -> 841
    //   547: invokestatic 79	java/lang/System:currentTimeMillis	()J
    //   550: lstore 9
    //   552: aload_0
    //   553: getfield 35	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:a	[B
    //   556: aload 17
    //   558: invokestatic 235	com/youtu/arsdk/ARShell:nativeTrack	([B[Lcom/youtu/arsdk/ARTargetInfo;)I
    //   561: istore_3
    //   562: aload 17
    //   564: iconst_0
    //   565: aaload
    //   566: astore 13
    //   568: iload_3
    //   569: ifne +32 -> 601
    //   572: aload 17
    //   574: iconst_0
    //   575: aaload
    //   576: getfield 194	com/youtu/arsdk/ARTargetInfo:pose	[F
    //   579: bipush 14
    //   581: faload
    //   582: fstore_1
    //   583: fload_1
    //   584: ldc 195
    //   586: fcmpl
    //   587: iflt +14 -> 601
    //   590: iconst_1
    //   591: istore 4
    //   593: goto +11 -> 604
    //   596: astore 13
    //   598: goto +245 -> 843
    //   601: iconst_2
    //   602: istore 4
    //   604: aload 13
    //   606: iload 4
    //   608: putfield 198	com/youtu/arsdk/ARTargetInfo:state	I
    //   611: invokestatic 79	java/lang/System:currentTimeMillis	()J
    //   614: lstore 11
    //   616: aload 17
    //   618: iconst_0
    //   619: aaload
    //   620: getfield 198	com/youtu/arsdk/ARTargetInfo:state	I
    //   623: istore 4
    //   625: iload_2
    //   626: iload 4
    //   628: if_icmpeq +108 -> 736
    //   631: new 206	java/lang/StringBuilder
    //   634: dup
    //   635: invokespecial 207	java/lang/StringBuilder:<init>	()V
    //   638: astore 13
    //   640: aload 13
    //   642: ldc 237
    //   644: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   647: pop
    //   648: aload 13
    //   650: lload 11
    //   652: lload 9
    //   654: lsub
    //   655: invokevirtual 216	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   658: pop
    //   659: aload 13
    //   661: ldc 218
    //   663: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   666: pop
    //   667: aload 13
    //   669: lload 9
    //   671: invokevirtual 216	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   674: pop
    //   675: aload 13
    //   677: ldc 220
    //   679: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   682: pop
    //   683: aload 13
    //   685: lload 11
    //   687: invokevirtual 216	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   690: pop
    //   691: aload 13
    //   693: ldc 222
    //   695: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   698: pop
    //   699: aload 13
    //   701: aload 17
    //   703: iconst_0
    //   704: aaload
    //   705: getfield 198	com/youtu/arsdk/ARTargetInfo:state	I
    //   708: invokevirtual 225	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   711: pop
    //   712: ldc 141
    //   714: iconst_1
    //   715: aload 13
    //   717: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   720: invokestatic 232	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   723: goto +13 -> 736
    //   726: astore 13
    //   728: goto +115 -> 843
    //   731: astore 13
    //   733: goto -135 -> 598
    //   736: invokestatic 79	java/lang/System:currentTimeMillis	()J
    //   739: lstore 9
    //   741: aload_0
    //   742: getfield 21	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   745: invokestatic 240	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:j	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)I
    //   748: pop
    //   749: aload_0
    //   750: getfield 21	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   753: aload_0
    //   754: getfield 21	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   757: invokestatic 243	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:k	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)J
    //   760: lload 9
    //   762: lload 7
    //   764: lsub
    //   765: ladd
    //   766: invokestatic 245	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:b	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;J)J
    //   769: pop2
    //   770: aload 16
    //   772: monitorexit
    //   773: iload_2
    //   774: istore 5
    //   776: iload 5
    //   778: iconst_2
    //   779: if_icmpne +24 -> 803
    //   782: iload 5
    //   784: istore_2
    //   785: iload_3
    //   786: istore 4
    //   788: invokestatic 250	com/tencent/mobileqq/ar/ARDebugReport:a	()Lcom/tencent/mobileqq/ar/ARDebugReport;
    //   791: invokestatic 79	java/lang/System:currentTimeMillis	()J
    //   794: lload 7
    //   796: lsub
    //   797: invokevirtual 253	com/tencent/mobileqq/ar/ARDebugReport:b	(J)V
    //   800: goto +101 -> 901
    //   803: iload 5
    //   805: istore_2
    //   806: iload_3
    //   807: istore 4
    //   809: invokestatic 250	com/tencent/mobileqq/ar/ARDebugReport:a	()Lcom/tencent/mobileqq/ar/ARDebugReport;
    //   812: invokestatic 79	java/lang/System:currentTimeMillis	()J
    //   815: lload 7
    //   817: lsub
    //   818: invokevirtual 255	com/tencent/mobileqq/ar/ARDebugReport:c	(J)V
    //   821: goto +80 -> 901
    //   824: astore 13
    //   826: goto -98 -> 728
    //   829: astore 13
    //   831: goto +5 -> 836
    //   834: astore 13
    //   836: goto +7 -> 843
    //   839: astore 13
    //   841: iconst_m1
    //   842: istore_3
    //   843: aload 16
    //   845: monitorexit
    //   846: iload_3
    //   847: istore 4
    //   849: aload 13
    //   851: athrow
    //   852: astore 13
    //   854: goto +13 -> 867
    //   857: astore 13
    //   859: goto -16 -> 843
    //   862: astore 13
    //   864: iconst_m1
    //   865: istore 4
    //   867: aload 13
    //   869: invokevirtual 256	java/lang/Exception:printStackTrace	()V
    //   872: iload_2
    //   873: istore 5
    //   875: iload 4
    //   877: istore_3
    //   878: invokestatic 139	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   881: ifeq +20 -> 901
    //   884: ldc 141
    //   886: iconst_2
    //   887: ldc_w 258
    //   890: aload 13
    //   892: invokestatic 260	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   895: iload 4
    //   897: istore_3
    //   898: iload_2
    //   899: istore 5
    //   901: aload 14
    //   903: astore 16
    //   905: aload 15
    //   907: astore 13
    //   909: aload_0
    //   910: getfield 21	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   913: astore 18
    //   915: iload_3
    //   916: ifne +935 -> 1851
    //   919: aload 17
    //   921: iconst_0
    //   922: aaload
    //   923: getfield 194	com/youtu/arsdk/ARTargetInfo:pose	[F
    //   926: bipush 14
    //   928: faload
    //   929: ldc 195
    //   931: fcmpl
    //   932: iflt +919 -> 1851
    //   935: aload 17
    //   937: iconst_0
    //   938: aaload
    //   939: getfield 198	com/youtu/arsdk/ARTargetInfo:state	I
    //   942: istore_2
    //   943: goto +3 -> 946
    //   946: aload 18
    //   948: iload_2
    //   949: invokestatic 262	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:a	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;I)I
    //   952: pop
    //   953: aload_0
    //   954: getfield 21	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   957: astore 18
    //   959: aload_0
    //   960: getfield 21	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   963: invokestatic 73	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:d	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)I
    //   966: iconst_2
    //   967: if_icmpne +889 -> 1856
    //   970: aload_0
    //   971: getfield 21	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   974: invokestatic 94	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:l	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)I
    //   977: iconst_1
    //   978: iadd
    //   979: istore_2
    //   980: goto +3 -> 983
    //   983: aload 18
    //   985: iload_2
    //   986: invokestatic 102	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:b	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;I)I
    //   989: pop
    //   990: iload 5
    //   992: iconst_2
    //   993: if_icmpeq +29 -> 1022
    //   996: aload_0
    //   997: getfield 21	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   1000: invokestatic 73	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:d	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)I
    //   1003: iconst_2
    //   1004: if_icmpne +18 -> 1022
    //   1007: aload_0
    //   1008: iconst_1
    //   1009: putfield 81	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:g	Z
    //   1012: aload_0
    //   1013: invokestatic 79	java/lang/System:currentTimeMillis	()J
    //   1016: putfield 83	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:h	J
    //   1019: goto +24 -> 1043
    //   1022: aload_0
    //   1023: getfield 21	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   1026: invokestatic 73	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:d	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)I
    //   1029: iconst_2
    //   1030: if_icmpeq +13 -> 1043
    //   1033: aload_0
    //   1034: iconst_0
    //   1035: putfield 81	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:g	Z
    //   1038: aload_0
    //   1039: lconst_0
    //   1040: putfield 83	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:h	J
    //   1043: aload_0
    //   1044: getfield 21	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   1047: invokestatic 265	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:m	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)I
    //   1050: ifne +11 -> 1061
    //   1053: aload_0
    //   1054: getfield 21	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   1057: invokestatic 268	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:n	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)I
    //   1060: pop
    //   1061: aload_0
    //   1062: getfield 21	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   1065: invokestatic 73	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:d	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)I
    //   1068: ifne +793 -> 1861
    //   1071: aload_0
    //   1072: getfield 21	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   1075: invokestatic 265	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:m	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)I
    //   1078: ifne +783 -> 1861
    //   1081: aload_0
    //   1082: getfield 21	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   1085: invokestatic 79	java/lang/System:currentTimeMillis	()J
    //   1088: invokestatic 270	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:c	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;J)J
    //   1091: pop2
    //   1092: aload_0
    //   1093: getfield 21	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   1096: aload_0
    //   1097: getfield 21	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   1100: invokestatic 273	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:o	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)J
    //   1103: aload_0
    //   1104: getfield 21	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   1107: invokestatic 276	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:p	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)J
    //   1110: lsub
    //   1111: l2i
    //   1112: invokestatic 278	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:c	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;I)I
    //   1115: pop
    //   1116: aload_0
    //   1117: getfield 21	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   1120: astore 18
    //   1122: aload 18
    //   1124: aload 13
    //   1126: invokestatic 281	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:a	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;Ljava/lang/String;)Ljava/lang/String;
    //   1129: pop
    //   1130: goto +3 -> 1133
    //   1133: aload 13
    //   1135: astore 15
    //   1137: aload_0
    //   1138: getfield 21	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   1141: invokestatic 73	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:d	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)I
    //   1144: iconst_2
    //   1145: if_icmpne +15 -> 1160
    //   1148: aload_0
    //   1149: getfield 21	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   1152: iconst_0
    //   1153: invokestatic 283	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:d	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;I)I
    //   1156: pop
    //   1157: goto +707 -> 1864
    //   1160: aload_0
    //   1161: getfield 21	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   1164: invokestatic 73	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:d	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)I
    //   1167: ifne +15 -> 1182
    //   1170: aload_0
    //   1171: getfield 21	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   1174: iconst_0
    //   1175: invokestatic 283	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:d	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;I)I
    //   1178: pop
    //   1179: goto +685 -> 1864
    //   1182: aload_0
    //   1183: getfield 21	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   1186: invokestatic 73	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:d	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)I
    //   1189: iconst_1
    //   1190: if_icmpne +674 -> 1864
    //   1193: aload_0
    //   1194: getfield 21	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   1197: invokestatic 286	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:q	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)I
    //   1200: pop
    //   1201: aload_0
    //   1202: getfield 21	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   1205: invokestatic 289	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:r	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)I
    //   1208: istore_3
    //   1209: iconst_2
    //   1210: istore_2
    //   1211: iload_3
    //   1212: iconst_2
    //   1213: if_icmpge +6 -> 1219
    //   1216: goto +19 -> 1235
    //   1219: aload_0
    //   1220: getfield 21	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   1223: invokestatic 289	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:r	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)I
    //   1226: iconst_2
    //   1227: if_icmpne +642 -> 1869
    //   1230: iconst_0
    //   1231: istore_2
    //   1232: goto +3 -> 1235
    //   1235: new 291	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult
    //   1238: dup
    //   1239: invokespecial 292	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult:<init>	()V
    //   1242: astore 18
    //   1244: aload 18
    //   1246: iload_2
    //   1247: putfield 294	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult:b	I
    //   1250: iload_2
    //   1251: iconst_2
    //   1252: if_icmpeq +627 -> 1879
    //   1255: new 296	com/youtu/arsdk/ARPatternInfo
    //   1258: dup
    //   1259: invokespecial 297	com/youtu/arsdk/ARPatternInfo:<init>	()V
    //   1262: astore 19
    //   1264: aload 17
    //   1266: iconst_0
    //   1267: aaload
    //   1268: getfield 300	com/youtu/arsdk/ARTargetInfo:markerIndex	I
    //   1271: i2l
    //   1272: aload 19
    //   1274: invokestatic 304	com/youtu/arsdk/ARShell:getMarkerInfo	(JLcom/youtu/arsdk/ARPatternInfo;)I
    //   1277: pop
    //   1278: iload_2
    //   1279: ifne +183 -> 1462
    //   1282: new 206	java/lang/StringBuilder
    //   1285: dup
    //   1286: invokespecial 207	java/lang/StringBuilder:<init>	()V
    //   1289: astore 20
    //   1291: aload 20
    //   1293: ldc_w 306
    //   1296: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1299: pop
    //   1300: aload 20
    //   1302: aload 19
    //   1304: getfield 309	com/youtu/arsdk/ARPatternInfo:name	Ljava/lang/String;
    //   1307: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1310: pop
    //   1311: aload 20
    //   1313: ldc_w 311
    //   1316: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1319: pop
    //   1320: aload 20
    //   1322: aload 19
    //   1324: getfield 314	com/youtu/arsdk/ARPatternInfo:markerType	I
    //   1327: invokevirtual 225	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1330: pop
    //   1331: aload 20
    //   1333: ldc_w 316
    //   1336: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1339: pop
    //   1340: aload 20
    //   1342: aload 19
    //   1344: getfield 319	com/youtu/arsdk/ARPatternInfo:index	J
    //   1347: invokevirtual 216	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1350: pop
    //   1351: aload 20
    //   1353: ldc_w 321
    //   1356: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1359: pop
    //   1360: aload 20
    //   1362: aload 19
    //   1364: getfield 325	com/youtu/arsdk/ARPatternInfo:xSize	F
    //   1367: invokevirtual 328	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   1370: pop
    //   1371: aload 20
    //   1373: ldc_w 330
    //   1376: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1379: pop
    //   1380: aload 20
    //   1382: aload 19
    //   1384: getfield 333	com/youtu/arsdk/ARPatternInfo:ySize	F
    //   1387: invokevirtual 328	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   1390: pop
    //   1391: aload 20
    //   1393: ldc_w 335
    //   1396: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1399: pop
    //   1400: aload 20
    //   1402: aload 19
    //   1404: getfield 338	com/youtu/arsdk/ARPatternInfo:param1	F
    //   1407: invokevirtual 328	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   1410: pop
    //   1411: aload 20
    //   1413: ldc_w 340
    //   1416: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1419: pop
    //   1420: aload 20
    //   1422: aload 19
    //   1424: getfield 343	com/youtu/arsdk/ARPatternInfo:param2	F
    //   1427: invokevirtual 328	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   1430: pop
    //   1431: aload 20
    //   1433: ldc_w 345
    //   1436: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1439: pop
    //   1440: aload 20
    //   1442: aload 19
    //   1444: getfield 348	com/youtu/arsdk/ARPatternInfo:param3	F
    //   1447: invokevirtual 328	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   1450: pop
    //   1451: ldc 141
    //   1453: iconst_1
    //   1454: aload 20
    //   1456: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1459: invokestatic 232	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1462: aload 18
    //   1464: aload 19
    //   1466: getfield 309	com/youtu/arsdk/ARPatternInfo:name	Ljava/lang/String;
    //   1469: putfield 350	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult:c	Ljava/lang/String;
    //   1472: aload 18
    //   1474: aload 19
    //   1476: getfield 314	com/youtu/arsdk/ARPatternInfo:markerType	I
    //   1479: putfield 352	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult:d	I
    //   1482: aload 19
    //   1484: getfield 314	com/youtu/arsdk/ARPatternInfo:markerType	I
    //   1487: iconst_1
    //   1488: if_icmpne +12 -> 1500
    //   1491: aload 19
    //   1493: getfield 338	com/youtu/arsdk/ARPatternInfo:param1	F
    //   1496: fstore_1
    //   1497: goto +9 -> 1506
    //   1500: aload 19
    //   1502: getfield 325	com/youtu/arsdk/ARPatternInfo:xSize	F
    //   1505: fstore_1
    //   1506: aload 18
    //   1508: fload_1
    //   1509: putfield 354	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult:e	F
    //   1512: aload 19
    //   1514: getfield 314	com/youtu/arsdk/ARPatternInfo:markerType	I
    //   1517: iconst_1
    //   1518: if_icmpne +12 -> 1530
    //   1521: aload 19
    //   1523: getfield 343	com/youtu/arsdk/ARPatternInfo:param2	F
    //   1526: fstore_1
    //   1527: goto +9 -> 1536
    //   1530: aload 19
    //   1532: getfield 333	com/youtu/arsdk/ARPatternInfo:ySize	F
    //   1535: fstore_1
    //   1536: aload 18
    //   1538: fload_1
    //   1539: putfield 356	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult:f	F
    //   1542: aload 19
    //   1544: getfield 314	com/youtu/arsdk/ARPatternInfo:markerType	I
    //   1547: istore_2
    //   1548: iload_2
    //   1549: iconst_1
    //   1550: if_icmpne +324 -> 1874
    //   1553: aload 19
    //   1555: getfield 348	com/youtu/arsdk/ARPatternInfo:param3	F
    //   1558: fstore_1
    //   1559: goto +3 -> 1562
    //   1562: aload 18
    //   1564: fload_1
    //   1565: putfield 358	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult:g	F
    //   1568: aload 18
    //   1570: bipush 16
    //   1572: newarray float
    //   1574: putfield 360	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult:h	[F
    //   1577: aload 17
    //   1579: iconst_0
    //   1580: aaload
    //   1581: getfield 194	com/youtu/arsdk/ARTargetInfo:pose	[F
    //   1584: iconst_0
    //   1585: aload 18
    //   1587: getfield 360	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult:h	[F
    //   1590: iconst_0
    //   1591: aload 17
    //   1593: iconst_0
    //   1594: aaload
    //   1595: getfield 194	com/youtu/arsdk/ARTargetInfo:pose	[F
    //   1598: arraylength
    //   1599: invokestatic 106	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   1602: aload 18
    //   1604: aload_0
    //   1605: getfield 21	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   1608: invokestatic 364	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:s	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)Ljava/util/Map;
    //   1611: aload 19
    //   1613: getfield 309	com/youtu/arsdk/ARPatternInfo:name	Ljava/lang/String;
    //   1616: invokeinterface 369 2 0
    //   1621: checkcast 371	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo
    //   1624: putfield 373	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult:i	Lcom/tencent/mobileqq/ar/aidl/ArCloudConfigInfo;
    //   1627: aload 18
    //   1629: aload_0
    //   1630: getfield 108	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:b	J
    //   1633: putfield 375	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult:a	J
    //   1636: goto +3 -> 1639
    //   1639: aload_0
    //   1640: getfield 21	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   1643: invokestatic 379	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:t	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)Z
    //   1646: ifeq +37 -> 1683
    //   1649: aload_0
    //   1650: getfield 21	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   1653: invokestatic 382	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:u	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)Z
    //   1656: ifne +27 -> 1683
    //   1659: aload_0
    //   1660: getfield 21	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   1663: invokestatic 386	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:v	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ARLocalMarkerRecogCallback;
    //   1666: ifnull +17 -> 1683
    //   1669: aload_0
    //   1670: getfield 21	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   1673: invokestatic 386	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:v	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ARLocalMarkerRecogCallback;
    //   1676: aload 18
    //   1678: invokeinterface 391 2 0
    //   1683: aload 16
    //   1685: astore 13
    //   1687: aload_0
    //   1688: getfield 21	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   1691: astore 16
    //   1693: aload 14
    //   1695: astore 13
    //   1697: aload 16
    //   1699: iconst_0
    //   1700: invokestatic 153	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:a	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;Z)Z
    //   1703: pop
    //   1704: goto +68 -> 1772
    //   1707: astore 13
    //   1709: goto +24 -> 1733
    //   1712: aload 13
    //   1714: astore 15
    //   1716: astore 13
    //   1718: goto +15 -> 1733
    //   1721: astore 13
    //   1723: goto +10 -> 1733
    //   1726: astore 15
    //   1728: goto +61 -> 1789
    //   1731: astore 13
    //   1733: aload 14
    //   1735: astore 16
    //   1737: aload 13
    //   1739: invokevirtual 256	java/lang/Exception:printStackTrace	()V
    //   1742: invokestatic 139	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1745: ifeq +14 -> 1759
    //   1748: ldc 141
    //   1750: iconst_2
    //   1751: ldc_w 393
    //   1754: aload 13
    //   1756: invokestatic 260	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1759: aload 16
    //   1761: astore 13
    //   1763: aload_0
    //   1764: getfield 21	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   1767: astore 16
    //   1769: goto -76 -> 1693
    //   1772: aload 14
    //   1774: astore 13
    //   1776: invokestatic 396	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:yield	()V
    //   1779: aload 14
    //   1781: astore 13
    //   1783: aload 14
    //   1785: monitorexit
    //   1786: goto -1762 -> 24
    //   1789: aload 14
    //   1791: astore 13
    //   1793: aload_0
    //   1794: getfield 21	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   1797: iconst_0
    //   1798: invokestatic 153	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:a	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;Z)Z
    //   1801: pop
    //   1802: aload 14
    //   1804: astore 13
    //   1806: aload 15
    //   1808: athrow
    //   1809: aload 15
    //   1811: astore 13
    //   1813: aload 15
    //   1815: monitorexit
    //   1816: aload 14
    //   1818: athrow
    //   1819: astore 14
    //   1821: aload 13
    //   1823: astore 15
    //   1825: goto -16 -> 1809
    //   1828: aload_0
    //   1829: monitorexit
    //   1830: return
    //   1831: astore 13
    //   1833: aload_0
    //   1834: monitorexit
    //   1835: goto +6 -> 1841
    //   1838: aload 13
    //   1840: athrow
    //   1841: goto -3 -> 1838
    //   1844: iload_2
    //   1845: iconst_1
    //   1846: iadd
    //   1847: istore_2
    //   1848: goto -1697 -> 151
    //   1851: iconst_2
    //   1852: istore_2
    //   1853: goto -907 -> 946
    //   1856: iconst_0
    //   1857: istore_2
    //   1858: goto -875 -> 983
    //   1861: goto -728 -> 1133
    //   1864: iconst_2
    //   1865: istore_2
    //   1866: goto -631 -> 1235
    //   1869: iconst_1
    //   1870: istore_2
    //   1871: goto -636 -> 1235
    //   1874: fconst_0
    //   1875: fstore_1
    //   1876: goto -314 -> 1562
    //   1879: goto -240 -> 1639
    //   1882: astore 15
    //   1884: goto -95 -> 1789
    //   1887: astore 13
    //   1889: aload 14
    //   1891: astore 15
    //   1893: aload 13
    //   1895: astore 14
    //   1897: goto -88 -> 1809
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1900	0	this	ProcessWorker
    //   346	1530	1	f1	float
    //   150	1721	2	i	int
    //   325	889	3	j	int
    //   355	541	4	k	int
    //   774	220	5	m	int
    //   42	47	6	bool	boolean
    //   292	524	7	l1	long
    //   314	447	9	l2	long
    //   378	308	11	l3	long
    //   12	1	13	arrayOfFloat	float[]
    //   56	19	13	localInterruptedException	java.lang.InterruptedException
    //   144	187	13	localObject1	Object
    //   360	9	13	localObject2	Object
    //   436	78	13	localStringBuilder1	java.lang.StringBuilder
    //   524	1	13	localObject3	Object
    //   529	1	13	localObject4	Object
    //   537	1	13	localObject5	Object
    //   542	1	13	localObject6	Object
    //   566	1	13	localObject7	Object
    //   596	9	13	localObject8	Object
    //   638	78	13	localStringBuilder2	java.lang.StringBuilder
    //   726	1	13	localObject9	Object
    //   731	1	13	localObject10	Object
    //   824	1	13	localObject11	Object
    //   829	1	13	localObject12	Object
    //   834	1	13	localObject13	Object
    //   839	11	13	localObject14	Object
    //   852	1	13	localException1	java.lang.Exception
    //   857	1	13	localObject15	Object
    //   862	29	13	localException2	java.lang.Exception
    //   907	789	13	localObject16	Object
    //   1707	6	13	localException3	java.lang.Exception
    //   1716	1	13	localException4	java.lang.Exception
    //   1721	1	13	localException5	java.lang.Exception
    //   1731	24	13	localException6	java.lang.Exception
    //   1761	61	13	localObject17	Object
    //   1831	8	13	localObject18	Object
    //   1887	7	13	localObject19	Object
    //   112	1705	14	localObject20	Object
    //   1819	71	14	localObject21	Object
    //   1895	1	14	localObject22	Object
    //   22	1693	15	localObject23	Object
    //   1726	88	15	localObject24	Object
    //   1823	1	15	localObject25	Object
    //   1882	1	15	localObject26	Object
    //   1891	1	15	localObject27	Object
    //   273	6	16	localObject28	Object
    //   301	1467	16	localObject29	Object
    //   18	1574	17	arrayOfARTargetInfo	com.youtu.arsdk.ARTargetInfo[]
    //   913	764	18	localObject30	Object
    //   1262	350	19	localARPatternInfo	com.youtu.arsdk.ARPatternInfo
    //   1289	166	20	localStringBuilder3	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   49	53	56	java/lang/InterruptedException
    //   151	264	273	finally
    //   267	270	273	finally
    //   275	278	273	finally
    //   336	347	360	finally
    //   446	521	524	finally
    //   429	446	529	finally
    //   368	423	537	finally
    //   311	326	542	finally
    //   572	583	596	finally
    //   648	723	726	finally
    //   631	648	731	finally
    //   770	773	824	finally
    //   736	770	829	finally
    //   604	625	834	finally
    //   547	562	839	finally
    //   788	800	852	java/lang/Exception
    //   809	821	852	java/lang/Exception
    //   849	852	852	java/lang/Exception
    //   843	846	857	finally
    //   289	306	862	java/lang/Exception
    //   1553	1559	1707	java/lang/Exception
    //   1562	1636	1707	java/lang/Exception
    //   1639	1683	1707	java/lang/Exception
    //   1122	1130	1712	java/lang/Exception
    //   1137	1157	1712	java/lang/Exception
    //   1160	1179	1712	java/lang/Exception
    //   1182	1209	1712	java/lang/Exception
    //   1219	1230	1712	java/lang/Exception
    //   1235	1250	1712	java/lang/Exception
    //   1255	1278	1712	java/lang/Exception
    //   1282	1462	1712	java/lang/Exception
    //   1462	1497	1712	java/lang/Exception
    //   1500	1506	1712	java/lang/Exception
    //   1506	1527	1712	java/lang/Exception
    //   1530	1536	1712	java/lang/Exception
    //   1536	1548	1712	java/lang/Exception
    //   867	872	1721	java/lang/Exception
    //   878	895	1721	java/lang/Exception
    //   909	915	1721	java/lang/Exception
    //   919	943	1721	java/lang/Exception
    //   946	980	1721	java/lang/Exception
    //   983	990	1721	java/lang/Exception
    //   996	1019	1721	java/lang/Exception
    //   1022	1043	1721	java/lang/Exception
    //   1043	1061	1721	java/lang/Exception
    //   1061	1122	1721	java/lang/Exception
    //   126	149	1726	finally
    //   278	281	1726	finally
    //   281	289	1726	finally
    //   289	306	1726	finally
    //   126	149	1731	java/lang/Exception
    //   278	281	1731	java/lang/Exception
    //   281	289	1731	java/lang/Exception
    //   1687	1693	1819	finally
    //   1697	1704	1819	finally
    //   1763	1769	1819	finally
    //   1776	1779	1819	finally
    //   1783	1786	1819	finally
    //   1793	1802	1819	finally
    //   1806	1809	1819	finally
    //   1813	1816	1819	finally
    //   2	20	1831	finally
    //   24	31	1831	finally
    //   31	44	1831	finally
    //   49	53	1831	finally
    //   58	79	1831	finally
    //   82	88	1831	finally
    //   96	117	1831	finally
    //   1816	1819	1831	finally
    //   788	800	1882	finally
    //   809	821	1882	finally
    //   849	852	1882	finally
    //   867	872	1882	finally
    //   878	895	1882	finally
    //   909	915	1882	finally
    //   919	943	1882	finally
    //   946	980	1882	finally
    //   983	990	1882	finally
    //   996	1019	1882	finally
    //   1022	1043	1882	finally
    //   1043	1061	1882	finally
    //   1061	1122	1882	finally
    //   1122	1130	1882	finally
    //   1137	1157	1882	finally
    //   1160	1179	1882	finally
    //   1182	1209	1882	finally
    //   1219	1230	1882	finally
    //   1235	1250	1882	finally
    //   1255	1278	1882	finally
    //   1282	1462	1882	finally
    //   1462	1497	1882	finally
    //   1500	1506	1882	finally
    //   1506	1527	1882	finally
    //   1530	1536	1882	finally
    //   1536	1548	1882	finally
    //   1553	1559	1882	finally
    //   1562	1636	1882	finally
    //   1639	1683	1882	finally
    //   1737	1759	1882	finally
    //   117	126	1887	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARLocalMarkerRecog.ProcessWorker
 * JD-Core Version:    0.7.0.1
 */