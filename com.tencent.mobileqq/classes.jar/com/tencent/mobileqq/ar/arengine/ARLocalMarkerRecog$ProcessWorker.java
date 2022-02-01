package com.tencent.mobileqq.ar.arengine;

import com.tencent.mobileqq.ar.ScanEntranceDPC;

class ARLocalMarkerRecog$ProcessWorker
  extends Thread
{
  private long jdField_a_of_type_Long;
  private boolean jdField_a_of_type_Boolean = false;
  byte[] jdField_a_of_type_ArrayOfByte = new byte[ARLocalMarkerRecog.a(this.this$0) * ARLocalMarkerRecog.b(this.this$0) * 3 / 2];
  private long jdField_b_of_type_Long = ScanEntranceDPC.a().jdField_b_of_type_Int;
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
    if (getState() == Thread.State.WAITING)
    {
      if (ARLocalMarkerRecog.c(this.this$0) == 2)
      {
        long l = System.currentTimeMillis();
        if (((!this.jdField_c_of_type_Boolean) || (l - this.d >= 1500L)) && ((ARLocalMarkerRecog.e(this.this$0) == 0L) || (l - ARLocalMarkerRecog.e(this.this$0) >= 5000L)) && (ARLocalMarkerRecog.f(this.this$0) >= 2))
        {
          if (l - this.jdField_c_of_type_Long < this.jdField_b_of_type_Long) {
            return;
          }
          if (ARLocalMarkerRecog.e(this.this$0) != 0L) {
            ARLocalMarkerRecog.d(this.this$0, 0L);
          }
        }
        if (l - this.jdField_c_of_type_Long >= this.jdField_b_of_type_Long) {
          ARLocalMarkerRecog.b(this.this$0, 0);
        }
      }
      byte[] arrayOfByte = this.jdField_a_of_type_ArrayOfByte;
      System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, arrayOfByte.length);
      this.jdField_c_of_type_Long = System.currentTimeMillis();
      this.jdField_a_of_type_Long = paramLong;
      this.jdField_a_of_type_Boolean = true;
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
    //   3: ldc 111
    //   5: invokevirtual 115	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:setName	(Ljava/lang/String;)V
    //   8: bipush 12
    //   10: newarray float
    //   12: astore 13
    //   14: iconst_1
    //   15: invokestatic 121	com/youtu/arsdk/ARTargetInfo:allocateInitialized	(I)[Lcom/youtu/arsdk/ARTargetInfo;
    //   18: astore 17
    //   20: ldc 123
    //   22: astore 15
    //   24: aload_0
    //   25: getfield 43	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:jdField_b_of_type_Boolean	Z
    //   28: ifeq +1799 -> 1827
    //   31: aload_0
    //   32: getfield 22	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:jdField_a_of_type_Boolean	Z
    //   35: ifne +47 -> 82
    //   38: aload_0
    //   39: getfield 43	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:jdField_b_of_type_Boolean	Z
    //   42: istore 6
    //   44: iload 6
    //   46: ifeq +36 -> 82
    //   49: aload_0
    //   50: invokevirtual 126	java/lang/Object:wait	()V
    //   53: goto -22 -> 31
    //   56: astore 13
    //   58: aload 13
    //   60: invokevirtual 129	java/lang/InterruptedException:printStackTrace	()V
    //   63: invokestatic 135	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   66: ifeq -35 -> 31
    //   69: ldc 137
    //   71: iconst_2
    //   72: ldc 139
    //   74: aload 13
    //   76: invokestatic 143	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   79: goto -48 -> 31
    //   82: aload_0
    //   83: getfield 43	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:jdField_b_of_type_Boolean	Z
    //   86: istore 6
    //   88: iload 6
    //   90: ifne +6 -> 96
    //   93: aload_0
    //   94: monitorexit
    //   95: return
    //   96: aload_0
    //   97: iconst_0
    //   98: putfield 22	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:jdField_a_of_type_Boolean	Z
    //   101: invokestatic 75	java/lang/System:currentTimeMillis	()J
    //   104: pop2
    //   105: aload_0
    //   106: getfield 17	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   109: invokestatic 146	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:a	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)Ljava/lang/Object;
    //   112: astore 14
    //   114: aload 14
    //   116: monitorenter
    //   117: aload_0
    //   118: getfield 17	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   121: iconst_1
    //   122: invokestatic 149	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:a	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;Z)Z
    //   125: pop
    //   126: aload_0
    //   127: getfield 17	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   130: invokestatic 69	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:c	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)I
    //   133: iconst_2
    //   134: if_icmpne +147 -> 281
    //   137: aload_0
    //   138: getfield 17	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   141: invokestatic 151	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:b	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)Ljava/lang/Object;
    //   144: astore 13
    //   146: aload 13
    //   148: monitorenter
    //   149: iconst_0
    //   150: istore_2
    //   151: iload_2
    //   152: aload_0
    //   153: getfield 17	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   156: invokestatic 154	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:a	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)Ljava/util/ArrayList;
    //   159: invokevirtual 160	java/util/ArrayList:size	()I
    //   162: if_icmpge +105 -> 267
    //   165: aload_0
    //   166: getfield 17	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   169: invokestatic 154	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:a	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)Ljava/util/ArrayList;
    //   172: iload_2
    //   173: invokevirtual 164	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   176: checkcast 166	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$MarkerState
    //   179: getfield 167	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$MarkerState:jdField_a_of_type_Boolean	Z
    //   182: ifne +1661 -> 1843
    //   185: aload_0
    //   186: getfield 17	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   189: aload_0
    //   190: getfield 17	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   193: invokestatic 154	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:a	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)Ljava/util/ArrayList;
    //   196: iload_2
    //   197: invokevirtual 164	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   200: checkcast 166	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$MarkerState
    //   203: getfield 170	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$MarkerState:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   206: aload_0
    //   207: getfield 17	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   210: invokestatic 154	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:a	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)Ljava/util/ArrayList;
    //   213: iload_2
    //   214: invokevirtual 164	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   217: checkcast 166	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$MarkerState
    //   220: getfield 172	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$MarkerState:b	Ljava/lang/String;
    //   223: aload_0
    //   224: getfield 17	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   227: invokestatic 154	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:a	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)Ljava/util/ArrayList;
    //   230: iload_2
    //   231: invokevirtual 164	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   234: checkcast 166	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$MarkerState
    //   237: getfield 175	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$MarkerState:jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo	Lcom/tencent/mobileqq/ar/aidl/ArCloudConfigInfo;
    //   240: invokestatic 178	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:a	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/ar/aidl/ArCloudConfigInfo;)Z
    //   243: ifeq +1600 -> 1843
    //   246: aload_0
    //   247: getfield 17	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   250: invokestatic 154	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:a	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)Ljava/util/ArrayList;
    //   253: iload_2
    //   254: invokevirtual 164	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   257: checkcast 166	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$MarkerState
    //   260: iconst_1
    //   261: putfield 167	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$MarkerState:jdField_a_of_type_Boolean	Z
    //   264: goto +1579 -> 1843
    //   267: aload 13
    //   269: monitorexit
    //   270: goto +11 -> 281
    //   273: astore 16
    //   275: aload 13
    //   277: monitorexit
    //   278: aload 16
    //   280: athrow
    //   281: aload_0
    //   282: getfield 17	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   285: invokestatic 69	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:c	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)I
    //   288: istore_2
    //   289: invokestatic 75	java/lang/System:currentTimeMillis	()J
    //   292: lstore 7
    //   294: aload_0
    //   295: getfield 17	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   298: invokestatic 180	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:c	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)Ljava/lang/Object;
    //   301: astore 16
    //   303: aload 16
    //   305: monitorenter
    //   306: iload_2
    //   307: iconst_2
    //   308: if_icmpne +239 -> 547
    //   311: invokestatic 75	java/lang/System:currentTimeMillis	()J
    //   314: lstore 9
    //   316: aload_0
    //   317: getfield 31	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:jdField_a_of_type_ArrayOfByte	[B
    //   320: aload 17
    //   322: invokestatic 186	com/youtu/arsdk/ARShell:nativeRecognize	([B[Lcom/youtu/arsdk/ARTargetInfo;)I
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
    //   340: getfield 190	com/youtu/arsdk/ARTargetInfo:pose	[F
    //   343: bipush 14
    //   345: faload
    //   346: fstore_1
    //   347: fload_1
    //   348: ldc 191
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
    //   372: putfield 194	com/youtu/arsdk/ARTargetInfo:state	I
    //   375: invokestatic 75	java/lang/System:currentTimeMillis	()J
    //   378: lstore 11
    //   380: aload_0
    //   381: getfield 17	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   384: invokestatic 196	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:d	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)I
    //   387: pop
    //   388: aload_0
    //   389: getfield 17	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   392: aload_0
    //   393: getfield 17	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   396: invokestatic 198	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:a	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)J
    //   399: lload 11
    //   401: lload 7
    //   403: lsub
    //   404: ladd
    //   405: invokestatic 200	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:a	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;J)J
    //   408: pop2
    //   409: invokestatic 75	java/lang/System:currentTimeMillis	()J
    //   412: lstore 11
    //   414: aload 17
    //   416: iconst_0
    //   417: aaload
    //   418: getfield 194	com/youtu/arsdk/ARTargetInfo:state	I
    //   421: istore 4
    //   423: iload_2
    //   424: iload 4
    //   426: if_icmpeq +108 -> 534
    //   429: new 202	java/lang/StringBuilder
    //   432: dup
    //   433: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   436: astore 13
    //   438: aload 13
    //   440: ldc 205
    //   442: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   445: pop
    //   446: aload 13
    //   448: lload 11
    //   450: lload 9
    //   452: lsub
    //   453: invokevirtual 212	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   456: pop
    //   457: aload 13
    //   459: ldc 214
    //   461: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   464: pop
    //   465: aload 13
    //   467: lload 9
    //   469: invokevirtual 212	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   472: pop
    //   473: aload 13
    //   475: ldc 216
    //   477: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   480: pop
    //   481: aload 13
    //   483: lload 11
    //   485: invokevirtual 212	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   488: pop
    //   489: aload 13
    //   491: ldc 218
    //   493: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   496: pop
    //   497: aload 13
    //   499: aload 17
    //   501: iconst_0
    //   502: aaload
    //   503: getfield 194	com/youtu/arsdk/ARTargetInfo:state	I
    //   506: invokevirtual 221	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   509: pop
    //   510: ldc 137
    //   512: iconst_1
    //   513: aload 13
    //   515: invokevirtual 225	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   518: invokestatic 228	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
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
    //   547: invokestatic 75	java/lang/System:currentTimeMillis	()J
    //   550: lstore 9
    //   552: aload_0
    //   553: getfield 31	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:jdField_a_of_type_ArrayOfByte	[B
    //   556: aload 17
    //   558: invokestatic 231	com/youtu/arsdk/ARShell:nativeTrack	([B[Lcom/youtu/arsdk/ARTargetInfo;)I
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
    //   576: getfield 190	com/youtu/arsdk/ARTargetInfo:pose	[F
    //   579: bipush 14
    //   581: faload
    //   582: fstore_1
    //   583: fload_1
    //   584: ldc 191
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
    //   608: putfield 194	com/youtu/arsdk/ARTargetInfo:state	I
    //   611: invokestatic 75	java/lang/System:currentTimeMillis	()J
    //   614: lstore 11
    //   616: aload 17
    //   618: iconst_0
    //   619: aaload
    //   620: getfield 194	com/youtu/arsdk/ARTargetInfo:state	I
    //   623: istore 4
    //   625: iload_2
    //   626: iload 4
    //   628: if_icmpeq +108 -> 736
    //   631: new 202	java/lang/StringBuilder
    //   634: dup
    //   635: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   638: astore 13
    //   640: aload 13
    //   642: ldc 233
    //   644: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   647: pop
    //   648: aload 13
    //   650: lload 11
    //   652: lload 9
    //   654: lsub
    //   655: invokevirtual 212	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   658: pop
    //   659: aload 13
    //   661: ldc 214
    //   663: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   666: pop
    //   667: aload 13
    //   669: lload 9
    //   671: invokevirtual 212	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   674: pop
    //   675: aload 13
    //   677: ldc 216
    //   679: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   682: pop
    //   683: aload 13
    //   685: lload 11
    //   687: invokevirtual 212	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   690: pop
    //   691: aload 13
    //   693: ldc 218
    //   695: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   698: pop
    //   699: aload 13
    //   701: aload 17
    //   703: iconst_0
    //   704: aaload
    //   705: getfield 194	com/youtu/arsdk/ARTargetInfo:state	I
    //   708: invokevirtual 221	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   711: pop
    //   712: ldc 137
    //   714: iconst_1
    //   715: aload 13
    //   717: invokevirtual 225	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   720: invokestatic 228	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   723: goto +13 -> 736
    //   726: astore 13
    //   728: goto +115 -> 843
    //   731: astore 13
    //   733: goto -135 -> 598
    //   736: invokestatic 75	java/lang/System:currentTimeMillis	()J
    //   739: lstore 9
    //   741: aload_0
    //   742: getfield 17	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   745: invokestatic 235	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:e	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)I
    //   748: pop
    //   749: aload_0
    //   750: getfield 17	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   753: aload_0
    //   754: getfield 17	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   757: invokestatic 237	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:b	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)J
    //   760: lload 9
    //   762: lload 7
    //   764: lsub
    //   765: ladd
    //   766: invokestatic 239	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:b	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;J)J
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
    //   788: invokestatic 244	com/tencent/mobileqq/ar/ARDebugReport:a	()Lcom/tencent/mobileqq/ar/ARDebugReport;
    //   791: invokestatic 75	java/lang/System:currentTimeMillis	()J
    //   794: lload 7
    //   796: lsub
    //   797: invokevirtual 247	com/tencent/mobileqq/ar/ARDebugReport:b	(J)V
    //   800: goto +100 -> 900
    //   803: iload 5
    //   805: istore_2
    //   806: iload_3
    //   807: istore 4
    //   809: invokestatic 244	com/tencent/mobileqq/ar/ARDebugReport:a	()Lcom/tencent/mobileqq/ar/ARDebugReport;
    //   812: invokestatic 75	java/lang/System:currentTimeMillis	()J
    //   815: lload 7
    //   817: lsub
    //   818: invokevirtual 249	com/tencent/mobileqq/ar/ARDebugReport:c	(J)V
    //   821: goto +79 -> 900
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
    //   869: invokevirtual 250	java/lang/Exception:printStackTrace	()V
    //   872: iload_2
    //   873: istore 5
    //   875: iload 4
    //   877: istore_3
    //   878: invokestatic 135	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   881: ifeq +19 -> 900
    //   884: ldc 137
    //   886: iconst_2
    //   887: ldc 252
    //   889: aload 13
    //   891: invokestatic 254	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   894: iload 4
    //   896: istore_3
    //   897: iload_2
    //   898: istore 5
    //   900: aload 14
    //   902: astore 16
    //   904: aload 15
    //   906: astore 13
    //   908: aload_0
    //   909: getfield 17	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   912: astore 18
    //   914: iload_3
    //   915: ifne +935 -> 1850
    //   918: aload 17
    //   920: iconst_0
    //   921: aaload
    //   922: getfield 190	com/youtu/arsdk/ARTargetInfo:pose	[F
    //   925: bipush 14
    //   927: faload
    //   928: ldc 191
    //   930: fcmpl
    //   931: iflt +919 -> 1850
    //   934: aload 17
    //   936: iconst_0
    //   937: aaload
    //   938: getfield 194	com/youtu/arsdk/ARTargetInfo:state	I
    //   941: istore_2
    //   942: goto +3 -> 945
    //   945: aload 18
    //   947: iload_2
    //   948: invokestatic 256	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:a	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;I)I
    //   951: pop
    //   952: aload_0
    //   953: getfield 17	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   956: astore 18
    //   958: aload_0
    //   959: getfield 17	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   962: invokestatic 69	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:c	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)I
    //   965: iconst_2
    //   966: if_icmpne +889 -> 1855
    //   969: aload_0
    //   970: getfield 17	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   973: invokestatic 90	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:f	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)I
    //   976: iconst_1
    //   977: iadd
    //   978: istore_2
    //   979: goto +3 -> 982
    //   982: aload 18
    //   984: iload_2
    //   985: invokestatic 98	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:b	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;I)I
    //   988: pop
    //   989: iload 5
    //   991: iconst_2
    //   992: if_icmpeq +29 -> 1021
    //   995: aload_0
    //   996: getfield 17	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   999: invokestatic 69	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:c	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)I
    //   1002: iconst_2
    //   1003: if_icmpne +18 -> 1021
    //   1006: aload_0
    //   1007: iconst_1
    //   1008: putfield 77	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:jdField_c_of_type_Boolean	Z
    //   1011: aload_0
    //   1012: invokestatic 75	java/lang/System:currentTimeMillis	()J
    //   1015: putfield 79	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:d	J
    //   1018: goto +24 -> 1042
    //   1021: aload_0
    //   1022: getfield 17	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   1025: invokestatic 69	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:c	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)I
    //   1028: iconst_2
    //   1029: if_icmpeq +13 -> 1042
    //   1032: aload_0
    //   1033: iconst_0
    //   1034: putfield 77	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:jdField_c_of_type_Boolean	Z
    //   1037: aload_0
    //   1038: lconst_0
    //   1039: putfield 79	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:d	J
    //   1042: aload_0
    //   1043: getfield 17	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   1046: invokestatic 259	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:g	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)I
    //   1049: ifne +11 -> 1060
    //   1052: aload_0
    //   1053: getfield 17	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   1056: invokestatic 262	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:h	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)I
    //   1059: pop
    //   1060: aload_0
    //   1061: getfield 17	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   1064: invokestatic 69	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:c	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)I
    //   1067: ifne +793 -> 1860
    //   1070: aload_0
    //   1071: getfield 17	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   1074: invokestatic 259	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:g	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)I
    //   1077: ifne +783 -> 1860
    //   1080: aload_0
    //   1081: getfield 17	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   1084: invokestatic 75	java/lang/System:currentTimeMillis	()J
    //   1087: invokestatic 264	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:c	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;J)J
    //   1090: pop2
    //   1091: aload_0
    //   1092: getfield 17	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   1095: aload_0
    //   1096: getfield 17	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   1099: invokestatic 266	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:c	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)J
    //   1102: aload_0
    //   1103: getfield 17	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   1106: invokestatic 268	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:d	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)J
    //   1109: lsub
    //   1110: l2i
    //   1111: invokestatic 270	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:c	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;I)I
    //   1114: pop
    //   1115: aload_0
    //   1116: getfield 17	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   1119: astore 18
    //   1121: aload 18
    //   1123: aload 13
    //   1125: invokestatic 273	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:a	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;Ljava/lang/String;)Ljava/lang/String;
    //   1128: pop
    //   1129: goto +3 -> 1132
    //   1132: aload 13
    //   1134: astore 15
    //   1136: aload_0
    //   1137: getfield 17	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   1140: invokestatic 69	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:c	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)I
    //   1143: iconst_2
    //   1144: if_icmpne +15 -> 1159
    //   1147: aload_0
    //   1148: getfield 17	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   1151: iconst_0
    //   1152: invokestatic 275	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:d	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;I)I
    //   1155: pop
    //   1156: goto +707 -> 1863
    //   1159: aload_0
    //   1160: getfield 17	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   1163: invokestatic 69	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:c	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)I
    //   1166: ifne +15 -> 1181
    //   1169: aload_0
    //   1170: getfield 17	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   1173: iconst_0
    //   1174: invokestatic 275	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:d	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;I)I
    //   1177: pop
    //   1178: goto +685 -> 1863
    //   1181: aload_0
    //   1182: getfield 17	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   1185: invokestatic 69	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:c	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)I
    //   1188: iconst_1
    //   1189: if_icmpne +674 -> 1863
    //   1192: aload_0
    //   1193: getfield 17	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   1196: invokestatic 277	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:i	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)I
    //   1199: pop
    //   1200: aload_0
    //   1201: getfield 17	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   1204: invokestatic 280	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:j	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)I
    //   1207: istore_3
    //   1208: iconst_2
    //   1209: istore_2
    //   1210: iload_3
    //   1211: iconst_2
    //   1212: if_icmpge +6 -> 1218
    //   1215: goto +19 -> 1234
    //   1218: aload_0
    //   1219: getfield 17	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   1222: invokestatic 280	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:j	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)I
    //   1225: iconst_2
    //   1226: if_icmpne +642 -> 1868
    //   1229: iconst_0
    //   1230: istore_2
    //   1231: goto +3 -> 1234
    //   1234: new 282	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult
    //   1237: dup
    //   1238: invokespecial 283	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult:<init>	()V
    //   1241: astore 18
    //   1243: aload 18
    //   1245: iload_2
    //   1246: putfield 285	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult:jdField_a_of_type_Int	I
    //   1249: iload_2
    //   1250: iconst_2
    //   1251: if_icmpeq +627 -> 1878
    //   1254: new 287	com/youtu/arsdk/ARPatternInfo
    //   1257: dup
    //   1258: invokespecial 288	com/youtu/arsdk/ARPatternInfo:<init>	()V
    //   1261: astore 19
    //   1263: aload 17
    //   1265: iconst_0
    //   1266: aaload
    //   1267: getfield 291	com/youtu/arsdk/ARTargetInfo:markerIndex	I
    //   1270: i2l
    //   1271: aload 19
    //   1273: invokestatic 295	com/youtu/arsdk/ARShell:getMarkerInfo	(JLcom/youtu/arsdk/ARPatternInfo;)I
    //   1276: pop
    //   1277: iload_2
    //   1278: ifne +183 -> 1461
    //   1281: new 202	java/lang/StringBuilder
    //   1284: dup
    //   1285: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   1288: astore 20
    //   1290: aload 20
    //   1292: ldc_w 297
    //   1295: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1298: pop
    //   1299: aload 20
    //   1301: aload 19
    //   1303: getfield 300	com/youtu/arsdk/ARPatternInfo:name	Ljava/lang/String;
    //   1306: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1309: pop
    //   1310: aload 20
    //   1312: ldc_w 302
    //   1315: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1318: pop
    //   1319: aload 20
    //   1321: aload 19
    //   1323: getfield 305	com/youtu/arsdk/ARPatternInfo:markerType	I
    //   1326: invokevirtual 221	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1329: pop
    //   1330: aload 20
    //   1332: ldc_w 307
    //   1335: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1338: pop
    //   1339: aload 20
    //   1341: aload 19
    //   1343: getfield 310	com/youtu/arsdk/ARPatternInfo:index	J
    //   1346: invokevirtual 212	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1349: pop
    //   1350: aload 20
    //   1352: ldc_w 312
    //   1355: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1358: pop
    //   1359: aload 20
    //   1361: aload 19
    //   1363: getfield 316	com/youtu/arsdk/ARPatternInfo:xSize	F
    //   1366: invokevirtual 319	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   1369: pop
    //   1370: aload 20
    //   1372: ldc_w 321
    //   1375: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1378: pop
    //   1379: aload 20
    //   1381: aload 19
    //   1383: getfield 324	com/youtu/arsdk/ARPatternInfo:ySize	F
    //   1386: invokevirtual 319	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   1389: pop
    //   1390: aload 20
    //   1392: ldc_w 326
    //   1395: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1398: pop
    //   1399: aload 20
    //   1401: aload 19
    //   1403: getfield 329	com/youtu/arsdk/ARPatternInfo:param1	F
    //   1406: invokevirtual 319	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   1409: pop
    //   1410: aload 20
    //   1412: ldc_w 331
    //   1415: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1418: pop
    //   1419: aload 20
    //   1421: aload 19
    //   1423: getfield 334	com/youtu/arsdk/ARPatternInfo:param2	F
    //   1426: invokevirtual 319	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   1429: pop
    //   1430: aload 20
    //   1432: ldc_w 336
    //   1435: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1438: pop
    //   1439: aload 20
    //   1441: aload 19
    //   1443: getfield 339	com/youtu/arsdk/ARPatternInfo:param3	F
    //   1446: invokevirtual 319	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   1449: pop
    //   1450: ldc 137
    //   1452: iconst_1
    //   1453: aload 20
    //   1455: invokevirtual 225	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1458: invokestatic 228	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1461: aload 18
    //   1463: aload 19
    //   1465: getfield 300	com/youtu/arsdk/ARPatternInfo:name	Ljava/lang/String;
    //   1468: putfield 340	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1471: aload 18
    //   1473: aload 19
    //   1475: getfield 305	com/youtu/arsdk/ARPatternInfo:markerType	I
    //   1478: putfield 341	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult:jdField_b_of_type_Int	I
    //   1481: aload 19
    //   1483: getfield 305	com/youtu/arsdk/ARPatternInfo:markerType	I
    //   1486: iconst_1
    //   1487: if_icmpne +12 -> 1499
    //   1490: aload 19
    //   1492: getfield 329	com/youtu/arsdk/ARPatternInfo:param1	F
    //   1495: fstore_1
    //   1496: goto +9 -> 1505
    //   1499: aload 19
    //   1501: getfield 316	com/youtu/arsdk/ARPatternInfo:xSize	F
    //   1504: fstore_1
    //   1505: aload 18
    //   1507: fload_1
    //   1508: putfield 343	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult:jdField_a_of_type_Float	F
    //   1511: aload 19
    //   1513: getfield 305	com/youtu/arsdk/ARPatternInfo:markerType	I
    //   1516: iconst_1
    //   1517: if_icmpne +12 -> 1529
    //   1520: aload 19
    //   1522: getfield 334	com/youtu/arsdk/ARPatternInfo:param2	F
    //   1525: fstore_1
    //   1526: goto +9 -> 1535
    //   1529: aload 19
    //   1531: getfield 324	com/youtu/arsdk/ARPatternInfo:ySize	F
    //   1534: fstore_1
    //   1535: aload 18
    //   1537: fload_1
    //   1538: putfield 345	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult:jdField_b_of_type_Float	F
    //   1541: aload 19
    //   1543: getfield 305	com/youtu/arsdk/ARPatternInfo:markerType	I
    //   1546: istore_2
    //   1547: iload_2
    //   1548: iconst_1
    //   1549: if_icmpne +324 -> 1873
    //   1552: aload 19
    //   1554: getfield 339	com/youtu/arsdk/ARPatternInfo:param3	F
    //   1557: fstore_1
    //   1558: goto +3 -> 1561
    //   1561: aload 18
    //   1563: fload_1
    //   1564: putfield 347	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult:c	F
    //   1567: aload 18
    //   1569: bipush 16
    //   1571: newarray float
    //   1573: putfield 349	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult:jdField_a_of_type_ArrayOfFloat	[F
    //   1576: aload 17
    //   1578: iconst_0
    //   1579: aaload
    //   1580: getfield 190	com/youtu/arsdk/ARTargetInfo:pose	[F
    //   1583: iconst_0
    //   1584: aload 18
    //   1586: getfield 349	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult:jdField_a_of_type_ArrayOfFloat	[F
    //   1589: iconst_0
    //   1590: aload 17
    //   1592: iconst_0
    //   1593: aaload
    //   1594: getfield 190	com/youtu/arsdk/ARTargetInfo:pose	[F
    //   1597: arraylength
    //   1598: invokestatic 102	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   1601: aload 18
    //   1603: aload_0
    //   1604: getfield 17	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   1607: invokestatic 352	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:a	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)Ljava/util/Map;
    //   1610: aload 19
    //   1612: getfield 300	com/youtu/arsdk/ARPatternInfo:name	Ljava/lang/String;
    //   1615: invokeinterface 357 2 0
    //   1620: checkcast 359	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo
    //   1623: putfield 360	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult:jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo	Lcom/tencent/mobileqq/ar/aidl/ArCloudConfigInfo;
    //   1626: aload 18
    //   1628: aload_0
    //   1629: getfield 104	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:jdField_a_of_type_Long	J
    //   1632: putfield 361	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult:jdField_a_of_type_Long	J
    //   1635: goto +3 -> 1638
    //   1638: aload_0
    //   1639: getfield 17	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   1642: invokestatic 364	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:a	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)Z
    //   1645: ifeq +37 -> 1682
    //   1648: aload_0
    //   1649: getfield 17	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   1652: invokestatic 366	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:b	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)Z
    //   1655: ifne +27 -> 1682
    //   1658: aload_0
    //   1659: getfield 17	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   1662: invokestatic 369	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:a	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ARLocalMarkerRecogCallback;
    //   1665: ifnull +17 -> 1682
    //   1668: aload_0
    //   1669: getfield 17	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   1672: invokestatic 369	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:a	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ARLocalMarkerRecogCallback;
    //   1675: aload 18
    //   1677: invokeinterface 374 2 0
    //   1682: aload 16
    //   1684: astore 13
    //   1686: aload_0
    //   1687: getfield 17	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   1690: astore 16
    //   1692: aload 14
    //   1694: astore 13
    //   1696: aload 16
    //   1698: iconst_0
    //   1699: invokestatic 149	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:a	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;Z)Z
    //   1702: pop
    //   1703: goto +68 -> 1771
    //   1706: astore 13
    //   1708: goto +24 -> 1732
    //   1711: aload 13
    //   1713: astore 15
    //   1715: astore 13
    //   1717: goto +15 -> 1732
    //   1720: astore 13
    //   1722: goto +10 -> 1732
    //   1725: astore 15
    //   1727: goto +61 -> 1788
    //   1730: astore 13
    //   1732: aload 14
    //   1734: astore 16
    //   1736: aload 13
    //   1738: invokevirtual 250	java/lang/Exception:printStackTrace	()V
    //   1741: invokestatic 135	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1744: ifeq +14 -> 1758
    //   1747: ldc 137
    //   1749: iconst_2
    //   1750: ldc_w 376
    //   1753: aload 13
    //   1755: invokestatic 254	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1758: aload 16
    //   1760: astore 13
    //   1762: aload_0
    //   1763: getfield 17	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   1766: astore 16
    //   1768: goto -76 -> 1692
    //   1771: aload 14
    //   1773: astore 13
    //   1775: invokestatic 379	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:yield	()V
    //   1778: aload 14
    //   1780: astore 13
    //   1782: aload 14
    //   1784: monitorexit
    //   1785: goto -1761 -> 24
    //   1788: aload 14
    //   1790: astore 13
    //   1792: aload_0
    //   1793: getfield 17	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
    //   1796: iconst_0
    //   1797: invokestatic 149	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:a	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;Z)Z
    //   1800: pop
    //   1801: aload 14
    //   1803: astore 13
    //   1805: aload 15
    //   1807: athrow
    //   1808: aload 15
    //   1810: astore 13
    //   1812: aload 15
    //   1814: monitorexit
    //   1815: aload 14
    //   1817: athrow
    //   1818: astore 14
    //   1820: aload 13
    //   1822: astore 15
    //   1824: goto -16 -> 1808
    //   1827: aload_0
    //   1828: monitorexit
    //   1829: return
    //   1830: astore 13
    //   1832: aload_0
    //   1833: monitorexit
    //   1834: goto +6 -> 1840
    //   1837: aload 13
    //   1839: athrow
    //   1840: goto -3 -> 1837
    //   1843: iload_2
    //   1844: iconst_1
    //   1845: iadd
    //   1846: istore_2
    //   1847: goto -1696 -> 151
    //   1850: iconst_2
    //   1851: istore_2
    //   1852: goto -907 -> 945
    //   1855: iconst_0
    //   1856: istore_2
    //   1857: goto -875 -> 982
    //   1860: goto -728 -> 1132
    //   1863: iconst_2
    //   1864: istore_2
    //   1865: goto -631 -> 1234
    //   1868: iconst_1
    //   1869: istore_2
    //   1870: goto -636 -> 1234
    //   1873: fconst_0
    //   1874: fstore_1
    //   1875: goto -314 -> 1561
    //   1878: goto -240 -> 1638
    //   1881: astore 15
    //   1883: goto -95 -> 1788
    //   1886: astore 13
    //   1888: aload 14
    //   1890: astore 15
    //   1892: aload 13
    //   1894: astore 14
    //   1896: goto -88 -> 1808
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1899	0	this	ProcessWorker
    //   346	1529	1	f	float
    //   150	1720	2	i	int
    //   325	888	3	j	int
    //   355	540	4	k	int
    //   774	219	5	m	int
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
    //   862	28	13	localException2	java.lang.Exception
    //   906	789	13	localObject16	Object
    //   1706	6	13	localException3	java.lang.Exception
    //   1715	1	13	localException4	java.lang.Exception
    //   1720	1	13	localException5	java.lang.Exception
    //   1730	24	13	localException6	java.lang.Exception
    //   1760	61	13	localObject17	Object
    //   1830	8	13	localObject18	Object
    //   1886	7	13	localObject19	Object
    //   112	1704	14	localObject20	Object
    //   1818	71	14	localObject21	Object
    //   1894	1	14	localObject22	Object
    //   22	1692	15	localObject23	Object
    //   1725	88	15	localObject24	Object
    //   1822	1	15	localObject25	Object
    //   1881	1	15	localObject26	Object
    //   1890	1	15	localObject27	Object
    //   273	6	16	localObject28	Object
    //   301	1466	16	localObject29	Object
    //   18	1573	17	arrayOfARTargetInfo	com.youtu.arsdk.ARTargetInfo[]
    //   912	764	18	localObject30	Object
    //   1261	350	19	localARPatternInfo	com.youtu.arsdk.ARPatternInfo
    //   1288	166	20	localStringBuilder3	java.lang.StringBuilder
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
    //   1552	1558	1706	java/lang/Exception
    //   1561	1635	1706	java/lang/Exception
    //   1638	1682	1706	java/lang/Exception
    //   1121	1129	1711	java/lang/Exception
    //   1136	1156	1711	java/lang/Exception
    //   1159	1178	1711	java/lang/Exception
    //   1181	1208	1711	java/lang/Exception
    //   1218	1229	1711	java/lang/Exception
    //   1234	1249	1711	java/lang/Exception
    //   1254	1277	1711	java/lang/Exception
    //   1281	1461	1711	java/lang/Exception
    //   1461	1496	1711	java/lang/Exception
    //   1499	1505	1711	java/lang/Exception
    //   1505	1526	1711	java/lang/Exception
    //   1529	1535	1711	java/lang/Exception
    //   1535	1547	1711	java/lang/Exception
    //   867	872	1720	java/lang/Exception
    //   878	894	1720	java/lang/Exception
    //   908	914	1720	java/lang/Exception
    //   918	942	1720	java/lang/Exception
    //   945	979	1720	java/lang/Exception
    //   982	989	1720	java/lang/Exception
    //   995	1018	1720	java/lang/Exception
    //   1021	1042	1720	java/lang/Exception
    //   1042	1060	1720	java/lang/Exception
    //   1060	1121	1720	java/lang/Exception
    //   126	149	1725	finally
    //   278	281	1725	finally
    //   281	289	1725	finally
    //   289	306	1725	finally
    //   126	149	1730	java/lang/Exception
    //   278	281	1730	java/lang/Exception
    //   281	289	1730	java/lang/Exception
    //   1686	1692	1818	finally
    //   1696	1703	1818	finally
    //   1762	1768	1818	finally
    //   1775	1778	1818	finally
    //   1782	1785	1818	finally
    //   1792	1801	1818	finally
    //   1805	1808	1818	finally
    //   1812	1815	1818	finally
    //   2	20	1830	finally
    //   24	31	1830	finally
    //   31	44	1830	finally
    //   49	53	1830	finally
    //   58	79	1830	finally
    //   82	88	1830	finally
    //   96	117	1830	finally
    //   1815	1818	1830	finally
    //   788	800	1881	finally
    //   809	821	1881	finally
    //   849	852	1881	finally
    //   867	872	1881	finally
    //   878	894	1881	finally
    //   908	914	1881	finally
    //   918	942	1881	finally
    //   945	979	1881	finally
    //   982	989	1881	finally
    //   995	1018	1881	finally
    //   1021	1042	1881	finally
    //   1042	1060	1881	finally
    //   1060	1121	1881	finally
    //   1121	1129	1881	finally
    //   1136	1156	1881	finally
    //   1159	1178	1881	finally
    //   1181	1208	1881	finally
    //   1218	1229	1881	finally
    //   1234	1249	1881	finally
    //   1254	1277	1881	finally
    //   1281	1461	1881	finally
    //   1461	1496	1881	finally
    //   1499	1505	1881	finally
    //   1505	1526	1881	finally
    //   1529	1535	1881	finally
    //   1535	1547	1881	finally
    //   1552	1558	1881	finally
    //   1561	1635	1881	finally
    //   1638	1682	1881	finally
    //   1736	1758	1881	finally
    //   117	126	1886	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARLocalMarkerRecog.ProcessWorker
 * JD-Core Version:    0.7.0.1
 */