package com.tencent.image;

class NativeVideoImage$PlayAudioThread
  extends Thread
{
  static final int LIMIT_TIME_USED = 1;
  
  public NativeVideoImage$PlayAudioThread(NativeVideoImage paramNativeVideoImage, String paramString)
  {
    paramNativeVideoImage = new StringBuilder();
    paramNativeVideoImage.append(paramString);
    paramNativeVideoImage.append("-");
    paramNativeVideoImage.append(getId());
    setName(paramNativeVideoImage.toString());
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 13	com/tencent/image/NativeVideoImage$PlayAudioThread:this$0	Lcom/tencent/image/NativeVideoImage;
    //   4: iconst_0
    //   5: invokestatic 56	com/tencent/image/NativeVideoImage:access$302	(Lcom/tencent/image/NativeVideoImage;Z)Z
    //   8: pop
    //   9: aload_0
    //   10: getfield 13	com/tencent/image/NativeVideoImage$PlayAudioThread:this$0	Lcom/tencent/image/NativeVideoImage;
    //   13: getfield 60	com/tencent/image/NativeVideoImage:mAudioTrack	Landroid/media/AudioTrack;
    //   16: ifnonnull +10 -> 26
    //   19: aload_0
    //   20: getfield 13	com/tencent/image/NativeVideoImage$PlayAudioThread:this$0	Lcom/tencent/image/NativeVideoImage;
    //   23: invokevirtual 63	com/tencent/image/NativeVideoImage:initAudioTrack	()V
    //   26: invokestatic 68	java/lang/System:currentTimeMillis	()J
    //   29: lstore_2
    //   30: aload_0
    //   31: getfield 13	com/tencent/image/NativeVideoImage$PlayAudioThread:this$0	Lcom/tencent/image/NativeVideoImage;
    //   34: getfield 60	com/tencent/image/NativeVideoImage:mAudioTrack	Landroid/media/AudioTrack;
    //   37: ifnonnull +255 -> 292
    //   40: getstatic 74	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   43: getfield 80	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   46: invokeinterface 86 1 0
    //   51: ifeq +66 -> 117
    //   54: getstatic 74	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   57: getfield 80	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   60: astore 11
    //   62: getstatic 90	com/tencent/image/NativeVideoImage:TAG_AUDIO	Ljava/lang/String;
    //   65: astore 12
    //   67: new 18	java/lang/StringBuilder
    //   70: dup
    //   71: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   74: astore 13
    //   76: aload 13
    //   78: ldc 92
    //   80: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: pop
    //   84: aload 13
    //   86: aload_0
    //   87: invokevirtual 29	com/tencent/image/NativeVideoImage$PlayAudioThread:getId	()J
    //   90: invokevirtual 32	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   93: pop
    //   94: aload 13
    //   96: ldc 94
    //   98: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: pop
    //   102: aload 11
    //   104: aload 12
    //   106: iconst_2
    //   107: aload 13
    //   109: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: invokeinterface 98 4 0
    //   117: aload_0
    //   118: getfield 13	com/tencent/image/NativeVideoImage$PlayAudioThread:this$0	Lcom/tencent/image/NativeVideoImage;
    //   121: getfield 60	com/tencent/image/NativeVideoImage:mAudioTrack	Landroid/media/AudioTrack;
    //   124: ifnull +114 -> 238
    //   127: aload_0
    //   128: getfield 13	com/tencent/image/NativeVideoImage$PlayAudioThread:this$0	Lcom/tencent/image/NativeVideoImage;
    //   131: getfield 60	com/tencent/image/NativeVideoImage:mAudioTrack	Landroid/media/AudioTrack;
    //   134: invokevirtual 103	android/media/AudioTrack:stop	()V
    //   137: aload_0
    //   138: getfield 13	com/tencent/image/NativeVideoImage$PlayAudioThread:this$0	Lcom/tencent/image/NativeVideoImage;
    //   141: getfield 60	com/tencent/image/NativeVideoImage:mAudioTrack	Landroid/media/AudioTrack;
    //   144: ifnull +94 -> 238
    //   147: aload_0
    //   148: getfield 13	com/tencent/image/NativeVideoImage$PlayAudioThread:this$0	Lcom/tencent/image/NativeVideoImage;
    //   151: getfield 60	com/tencent/image/NativeVideoImage:mAudioTrack	Landroid/media/AudioTrack;
    //   154: invokevirtual 106	android/media/AudioTrack:release	()V
    //   157: aload_0
    //   158: getfield 13	com/tencent/image/NativeVideoImage$PlayAudioThread:this$0	Lcom/tencent/image/NativeVideoImage;
    //   161: aconst_null
    //   162: putfield 60	com/tencent/image/NativeVideoImage:mAudioTrack	Landroid/media/AudioTrack;
    //   165: goto +73 -> 238
    //   168: astore 11
    //   170: goto +37 -> 207
    //   173: astore 11
    //   175: getstatic 74	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   178: getfield 80	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   181: getstatic 90	com/tencent/image/NativeVideoImage:TAG_AUDIO	Ljava/lang/String;
    //   184: iconst_1
    //   185: ldc 108
    //   187: aload 11
    //   189: invokeinterface 111 5 0
    //   194: aload_0
    //   195: getfield 13	com/tencent/image/NativeVideoImage$PlayAudioThread:this$0	Lcom/tencent/image/NativeVideoImage;
    //   198: getfield 60	com/tencent/image/NativeVideoImage:mAudioTrack	Landroid/media/AudioTrack;
    //   201: ifnull +37 -> 238
    //   204: goto -57 -> 147
    //   207: aload_0
    //   208: getfield 13	com/tencent/image/NativeVideoImage$PlayAudioThread:this$0	Lcom/tencent/image/NativeVideoImage;
    //   211: getfield 60	com/tencent/image/NativeVideoImage:mAudioTrack	Landroid/media/AudioTrack;
    //   214: ifnull +21 -> 235
    //   217: aload_0
    //   218: getfield 13	com/tencent/image/NativeVideoImage$PlayAudioThread:this$0	Lcom/tencent/image/NativeVideoImage;
    //   221: getfield 60	com/tencent/image/NativeVideoImage:mAudioTrack	Landroid/media/AudioTrack;
    //   224: invokevirtual 106	android/media/AudioTrack:release	()V
    //   227: aload_0
    //   228: getfield 13	com/tencent/image/NativeVideoImage$PlayAudioThread:this$0	Lcom/tencent/image/NativeVideoImage;
    //   231: aconst_null
    //   232: putfield 60	com/tencent/image/NativeVideoImage:mAudioTrack	Landroid/media/AudioTrack;
    //   235: aload 11
    //   237: athrow
    //   238: aload_0
    //   239: getfield 13	com/tencent/image/NativeVideoImage$PlayAudioThread:this$0	Lcom/tencent/image/NativeVideoImage;
    //   242: getfield 115	com/tencent/image/NativeVideoImage:mRequireAudioFocus	Z
    //   245: ifeq +6 -> 251
    //   248: invokestatic 120	com/tencent/image/AudioUtils:abandonAudioFoucus	()V
    //   251: aload_0
    //   252: getfield 13	com/tencent/image/NativeVideoImage$PlayAudioThread:this$0	Lcom/tencent/image/NativeVideoImage;
    //   255: iconst_1
    //   256: invokestatic 56	com/tencent/image/NativeVideoImage:access$302	(Lcom/tencent/image/NativeVideoImage;Z)Z
    //   259: pop
    //   260: getstatic 74	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   263: getfield 80	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   266: invokeinterface 86 1 0
    //   271: ifeq +20 -> 291
    //   274: getstatic 74	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   277: getfield 80	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   280: getstatic 90	com/tencent/image/NativeVideoImage:TAG_AUDIO	Ljava/lang/String;
    //   283: iconst_2
    //   284: ldc 122
    //   286: invokeinterface 125 4 0
    //   291: return
    //   292: aload_0
    //   293: getfield 13	com/tencent/image/NativeVideoImage$PlayAudioThread:this$0	Lcom/tencent/image/NativeVideoImage;
    //   296: getfield 60	com/tencent/image/NativeVideoImage:mAudioTrack	Landroid/media/AudioTrack;
    //   299: invokevirtual 128	android/media/AudioTrack:play	()V
    //   302: getstatic 134	com/tencent/image/AbstractVideoImage:sPauseLock	Ljava/lang/Object;
    //   305: astore 11
    //   307: aload 11
    //   309: monitorenter
    //   310: getstatic 137	com/tencent/image/AbstractVideoImage:sPaused	Z
    //   313: ifeq +206 -> 519
    //   316: aload_0
    //   317: getfield 13	com/tencent/image/NativeVideoImage$PlayAudioThread:this$0	Lcom/tencent/image/NativeVideoImage;
    //   320: getfield 140	com/tencent/image/NativeVideoImage:mSupportGlobalPause	Z
    //   323: istore 10
    //   325: iload 10
    //   327: ifeq +192 -> 519
    //   330: getstatic 74	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   333: getfield 80	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   336: invokeinterface 86 1 0
    //   341: ifeq +66 -> 407
    //   344: getstatic 74	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   347: getfield 80	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   350: astore 12
    //   352: getstatic 90	com/tencent/image/NativeVideoImage:TAG_AUDIO	Ljava/lang/String;
    //   355: astore 13
    //   357: new 18	java/lang/StringBuilder
    //   360: dup
    //   361: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   364: astore 14
    //   366: aload 14
    //   368: ldc 92
    //   370: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   373: pop
    //   374: aload 14
    //   376: aload_0
    //   377: invokevirtual 29	com/tencent/image/NativeVideoImage$PlayAudioThread:getId	()J
    //   380: invokevirtual 32	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   383: pop
    //   384: aload 14
    //   386: ldc 142
    //   388: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   391: pop
    //   392: aload 12
    //   394: aload 13
    //   396: iconst_2
    //   397: aload 14
    //   399: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   402: invokeinterface 125 4 0
    //   407: aload_0
    //   408: getfield 13	com/tencent/image/NativeVideoImage$PlayAudioThread:this$0	Lcom/tencent/image/NativeVideoImage;
    //   411: getfield 115	com/tencent/image/NativeVideoImage:mRequireAudioFocus	Z
    //   414: ifeq +6 -> 420
    //   417: invokestatic 120	com/tencent/image/AudioUtils:abandonAudioFoucus	()V
    //   420: getstatic 134	com/tencent/image/AbstractVideoImage:sPauseLock	Ljava/lang/Object;
    //   423: invokevirtual 147	java/lang/Object:wait	()V
    //   426: getstatic 74	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   429: getfield 80	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   432: invokeinterface 86 1 0
    //   437: ifeq +66 -> 503
    //   440: getstatic 74	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   443: getfield 80	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   446: astore 12
    //   448: getstatic 90	com/tencent/image/NativeVideoImage:TAG_AUDIO	Ljava/lang/String;
    //   451: astore 13
    //   453: new 18	java/lang/StringBuilder
    //   456: dup
    //   457: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   460: astore 14
    //   462: aload 14
    //   464: ldc 92
    //   466: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   469: pop
    //   470: aload 14
    //   472: aload_0
    //   473: invokevirtual 29	com/tencent/image/NativeVideoImage$PlayAudioThread:getId	()J
    //   476: invokevirtual 32	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   479: pop
    //   480: aload 14
    //   482: ldc 149
    //   484: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   487: pop
    //   488: aload 12
    //   490: aload 13
    //   492: iconst_2
    //   493: aload 14
    //   495: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   498: invokeinterface 125 4 0
    //   503: aload_0
    //   504: getfield 13	com/tencent/image/NativeVideoImage$PlayAudioThread:this$0	Lcom/tencent/image/NativeVideoImage;
    //   507: getfield 115	com/tencent/image/NativeVideoImage:mRequireAudioFocus	Z
    //   510: ifeq -200 -> 310
    //   513: invokestatic 152	com/tencent/image/AudioUtils:requesetAudioFoucus	()V
    //   516: goto -206 -> 310
    //   519: aload 11
    //   521: monitorexit
    //   522: aload_0
    //   523: getfield 13	com/tencent/image/NativeVideoImage$PlayAudioThread:this$0	Lcom/tencent/image/NativeVideoImage;
    //   526: getfield 155	com/tencent/image/NativeVideoImage:mPlayAudioFrame	Z
    //   529: ifne +194 -> 723
    //   532: getstatic 74	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   535: getfield 80	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   538: invokeinterface 86 1 0
    //   543: ifeq +20 -> 563
    //   546: getstatic 74	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   549: getfield 80	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   552: getstatic 90	com/tencent/image/NativeVideoImage:TAG_AUDIO	Ljava/lang/String;
    //   555: iconst_2
    //   556: ldc 157
    //   558: invokeinterface 160 4 0
    //   563: aload_0
    //   564: getfield 13	com/tencent/image/NativeVideoImage$PlayAudioThread:this$0	Lcom/tencent/image/NativeVideoImage;
    //   567: getfield 60	com/tencent/image/NativeVideoImage:mAudioTrack	Landroid/media/AudioTrack;
    //   570: ifnull +114 -> 684
    //   573: aload_0
    //   574: getfield 13	com/tencent/image/NativeVideoImage$PlayAudioThread:this$0	Lcom/tencent/image/NativeVideoImage;
    //   577: getfield 60	com/tencent/image/NativeVideoImage:mAudioTrack	Landroid/media/AudioTrack;
    //   580: invokevirtual 103	android/media/AudioTrack:stop	()V
    //   583: aload_0
    //   584: getfield 13	com/tencent/image/NativeVideoImage$PlayAudioThread:this$0	Lcom/tencent/image/NativeVideoImage;
    //   587: getfield 60	com/tencent/image/NativeVideoImage:mAudioTrack	Landroid/media/AudioTrack;
    //   590: ifnull +94 -> 684
    //   593: aload_0
    //   594: getfield 13	com/tencent/image/NativeVideoImage$PlayAudioThread:this$0	Lcom/tencent/image/NativeVideoImage;
    //   597: getfield 60	com/tencent/image/NativeVideoImage:mAudioTrack	Landroid/media/AudioTrack;
    //   600: invokevirtual 106	android/media/AudioTrack:release	()V
    //   603: aload_0
    //   604: getfield 13	com/tencent/image/NativeVideoImage$PlayAudioThread:this$0	Lcom/tencent/image/NativeVideoImage;
    //   607: aconst_null
    //   608: putfield 60	com/tencent/image/NativeVideoImage:mAudioTrack	Landroid/media/AudioTrack;
    //   611: goto +73 -> 684
    //   614: astore 11
    //   616: goto +37 -> 653
    //   619: astore 11
    //   621: getstatic 74	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   624: getfield 80	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   627: getstatic 90	com/tencent/image/NativeVideoImage:TAG_AUDIO	Ljava/lang/String;
    //   630: iconst_1
    //   631: ldc 108
    //   633: aload 11
    //   635: invokeinterface 111 5 0
    //   640: aload_0
    //   641: getfield 13	com/tencent/image/NativeVideoImage$PlayAudioThread:this$0	Lcom/tencent/image/NativeVideoImage;
    //   644: getfield 60	com/tencent/image/NativeVideoImage:mAudioTrack	Landroid/media/AudioTrack;
    //   647: ifnull +37 -> 684
    //   650: goto -57 -> 593
    //   653: aload_0
    //   654: getfield 13	com/tencent/image/NativeVideoImage$PlayAudioThread:this$0	Lcom/tencent/image/NativeVideoImage;
    //   657: getfield 60	com/tencent/image/NativeVideoImage:mAudioTrack	Landroid/media/AudioTrack;
    //   660: ifnull +21 -> 681
    //   663: aload_0
    //   664: getfield 13	com/tencent/image/NativeVideoImage$PlayAudioThread:this$0	Lcom/tencent/image/NativeVideoImage;
    //   667: getfield 60	com/tencent/image/NativeVideoImage:mAudioTrack	Landroid/media/AudioTrack;
    //   670: invokevirtual 106	android/media/AudioTrack:release	()V
    //   673: aload_0
    //   674: getfield 13	com/tencent/image/NativeVideoImage$PlayAudioThread:this$0	Lcom/tencent/image/NativeVideoImage;
    //   677: aconst_null
    //   678: putfield 60	com/tencent/image/NativeVideoImage:mAudioTrack	Landroid/media/AudioTrack;
    //   681: aload 11
    //   683: athrow
    //   684: aload_0
    //   685: getfield 13	com/tencent/image/NativeVideoImage$PlayAudioThread:this$0	Lcom/tencent/image/NativeVideoImage;
    //   688: getfield 115	com/tencent/image/NativeVideoImage:mRequireAudioFocus	Z
    //   691: ifeq +6 -> 697
    //   694: invokestatic 120	com/tencent/image/AudioUtils:abandonAudioFoucus	()V
    //   697: aload_0
    //   698: getfield 13	com/tencent/image/NativeVideoImage$PlayAudioThread:this$0	Lcom/tencent/image/NativeVideoImage;
    //   701: iconst_1
    //   702: invokestatic 56	com/tencent/image/NativeVideoImage:access$302	(Lcom/tencent/image/NativeVideoImage;Z)Z
    //   705: pop
    //   706: getstatic 74	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   709: getfield 80	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   712: invokeinterface 86 1 0
    //   717: ifeq +1056 -> 1773
    //   720: goto +1036 -> 1756
    //   723: getstatic 74	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   726: getfield 80	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   729: invokeinterface 86 1 0
    //   734: ifeq +20 -> 754
    //   737: getstatic 74	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   740: getfield 80	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   743: getstatic 90	com/tencent/image/NativeVideoImage:TAG_AUDIO	Ljava/lang/String;
    //   746: iconst_2
    //   747: ldc 162
    //   749: invokeinterface 160 4 0
    //   754: invokestatic 68	java/lang/System:currentTimeMillis	()J
    //   757: lstore 8
    //   759: aload_0
    //   760: getfield 13	com/tencent/image/NativeVideoImage$PlayAudioThread:this$0	Lcom/tencent/image/NativeVideoImage;
    //   763: invokestatic 166	com/tencent/image/NativeVideoImage:access$400	(Lcom/tencent/image/NativeVideoImage;)Ljava/lang/Object;
    //   766: astore 11
    //   768: aload 11
    //   770: monitorenter
    //   771: aload_0
    //   772: getfield 13	com/tencent/image/NativeVideoImage$PlayAudioThread:this$0	Lcom/tencent/image/NativeVideoImage;
    //   775: getfield 170	com/tencent/image/NativeVideoImage:mAVDecode	Lcom/tencent/video/decode/AbstractAVDecode;
    //   778: astore 12
    //   780: aload 11
    //   782: monitorexit
    //   783: aload 12
    //   785: invokevirtual 176	com/tencent/video/decode/AbstractAVDecode:seekToNextAudioShortFrame	()[S
    //   788: astore 11
    //   790: invokestatic 68	java/lang/System:currentTimeMillis	()J
    //   793: lstore 4
    //   795: aload_0
    //   796: getfield 13	com/tencent/image/NativeVideoImage$PlayAudioThread:this$0	Lcom/tencent/image/NativeVideoImage;
    //   799: getfield 60	com/tencent/image/NativeVideoImage:mAudioTrack	Landroid/media/AudioTrack;
    //   802: aload 11
    //   804: iconst_0
    //   805: aload 11
    //   807: arraylength
    //   808: invokevirtual 180	android/media/AudioTrack:write	([SII)I
    //   811: pop
    //   812: invokestatic 68	java/lang/System:currentTimeMillis	()J
    //   815: lstore 6
    //   817: aload 12
    //   819: getfield 184	com/tencent/video/decode/AbstractAVDecode:audioParam	Lcom/tencent/video/decode/AVAudioParam;
    //   822: getfield 189	com/tencent/video/decode/AVAudioParam:duration	I
    //   825: istore_1
    //   826: iload_1
    //   827: ifgt +24 -> 851
    //   830: aload_0
    //   831: getfield 13	com/tencent/image/NativeVideoImage$PlayAudioThread:this$0	Lcom/tencent/image/NativeVideoImage;
    //   834: invokestatic 193	com/tencent/image/NativeVideoImage:access$500	(Lcom/tencent/image/NativeVideoImage;)I
    //   837: ifle +1125 -> 1962
    //   840: aload_0
    //   841: getfield 13	com/tencent/image/NativeVideoImage$PlayAudioThread:this$0	Lcom/tencent/image/NativeVideoImage;
    //   844: invokestatic 196	com/tencent/image/NativeVideoImage:access$600	(Lcom/tencent/image/NativeVideoImage;)I
    //   847: istore_1
    //   848: goto +1116 -> 1964
    //   851: aload_0
    //   852: getfield 13	com/tencent/image/NativeVideoImage$PlayAudioThread:this$0	Lcom/tencent/image/NativeVideoImage;
    //   855: iload_1
    //   856: invokestatic 200	com/tencent/image/NativeVideoImage:access$602	(Lcom/tencent/image/NativeVideoImage;I)I
    //   859: pop
    //   860: goto +1104 -> 1964
    //   863: getstatic 74	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   866: getfield 80	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   869: invokeinterface 86 1 0
    //   874: ifeq +110 -> 984
    //   877: getstatic 74	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   880: getfield 80	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   883: astore 11
    //   885: getstatic 90	com/tencent/image/NativeVideoImage:TAG_AUDIO	Ljava/lang/String;
    //   888: astore 12
    //   890: new 18	java/lang/StringBuilder
    //   893: dup
    //   894: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   897: astore 13
    //   899: aload 13
    //   901: ldc 202
    //   903: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   906: pop
    //   907: aload 13
    //   909: lload 8
    //   911: invokevirtual 32	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   914: pop
    //   915: aload 13
    //   917: ldc 204
    //   919: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   922: pop
    //   923: aload 13
    //   925: lload 4
    //   927: invokevirtual 32	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   930: pop
    //   931: aload 13
    //   933: ldc 206
    //   935: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   938: pop
    //   939: aload 13
    //   941: iload_1
    //   942: invokevirtual 209	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   945: pop
    //   946: aload 13
    //   948: ldc 211
    //   950: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   953: pop
    //   954: aload 13
    //   956: iconst_1
    //   957: invokevirtual 209	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   960: pop
    //   961: aload 13
    //   963: ldc 213
    //   965: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   968: pop
    //   969: aload 11
    //   971: aload 12
    //   973: iconst_2
    //   974: aload 13
    //   976: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   979: invokeinterface 160 4 0
    //   984: iload_1
    //   985: i2l
    //   986: lload 4
    //   988: lsub
    //   989: l2i
    //   990: istore_1
    //   991: iload_1
    //   992: ifgt +66 -> 1058
    //   995: getstatic 74	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   998: getfield 80	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   1001: astore 11
    //   1003: getstatic 90	com/tencent/image/NativeVideoImage:TAG_AUDIO	Ljava/lang/String;
    //   1006: astore 12
    //   1008: new 18	java/lang/StringBuilder
    //   1011: dup
    //   1012: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   1015: astore 13
    //   1017: aload 13
    //   1019: ldc 215
    //   1021: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1024: pop
    //   1025: aload 13
    //   1027: iload_1
    //   1028: invokevirtual 209	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1031: pop
    //   1032: aload 13
    //   1034: ldc 217
    //   1036: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1039: pop
    //   1040: aload 11
    //   1042: aload 12
    //   1044: iconst_1
    //   1045: aload 13
    //   1047: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1050: invokeinterface 98 4 0
    //   1055: goto -753 -> 302
    //   1058: iload_1
    //   1059: i2l
    //   1060: lstore 4
    //   1062: lload 4
    //   1064: invokestatic 221	java/lang/Thread:sleep	(J)V
    //   1067: goto -765 -> 302
    //   1070: astore 11
    //   1072: aload 11
    //   1074: invokevirtual 224	java/lang/InterruptedException:printStackTrace	()V
    //   1077: goto -775 -> 302
    //   1080: astore 12
    //   1082: aload 11
    //   1084: monitorexit
    //   1085: aload 12
    //   1087: athrow
    //   1088: astore 12
    //   1090: aload 11
    //   1092: monitorexit
    //   1093: aload 12
    //   1095: athrow
    //   1096: astore 11
    //   1098: invokestatic 68	java/lang/System:currentTimeMillis	()J
    //   1101: lstore 6
    //   1103: lload_2
    //   1104: lstore 4
    //   1106: lload_2
    //   1107: lload 6
    //   1109: lsub
    //   1110: ldc2_w 225
    //   1113: lcmp
    //   1114: ifle +49 -> 1163
    //   1117: getstatic 74	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   1120: getfield 80	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   1123: invokeinterface 86 1 0
    //   1128: ifeq +867 -> 1995
    //   1131: aload_0
    //   1132: getfield 13	com/tencent/image/NativeVideoImage$PlayAudioThread:this$0	Lcom/tencent/image/NativeVideoImage;
    //   1135: getfield 229	com/tencent/image/NativeVideoImage:debug	Z
    //   1138: ifeq +857 -> 1995
    //   1141: getstatic 74	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   1144: getfield 80	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   1147: getstatic 90	com/tencent/image/NativeVideoImage:TAG_AUDIO	Ljava/lang/String;
    //   1150: iconst_2
    //   1151: ldc 231
    //   1153: aload 11
    //   1155: invokeinterface 233 5 0
    //   1160: goto +835 -> 1995
    //   1163: aload 11
    //   1165: getfield 236	com/tencent/video/decode/AVideoException:mErrCode	I
    //   1168: istore_1
    //   1169: iload_1
    //   1170: bipush 140
    //   1172: if_icmpeq +12 -> 1184
    //   1175: lload 4
    //   1177: lstore_2
    //   1178: iload_1
    //   1179: bipush 146
    //   1181: if_icmpne -879 -> 302
    //   1184: getstatic 74	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   1187: getfield 80	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   1190: invokeinterface 86 1 0
    //   1195: ifeq +20 -> 1215
    //   1198: getstatic 74	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   1201: getfield 80	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   1204: getstatic 90	com/tencent/image/NativeVideoImage:TAG_AUDIO	Ljava/lang/String;
    //   1207: iconst_2
    //   1208: ldc 238
    //   1210: invokeinterface 125 4 0
    //   1215: aload_0
    //   1216: getfield 13	com/tencent/image/NativeVideoImage$PlayAudioThread:this$0	Lcom/tencent/image/NativeVideoImage;
    //   1219: getfield 241	com/tencent/image/NativeVideoImage:mPlayAudioOnceFinished	Z
    //   1222: ifne +235 -> 1457
    //   1225: aload_0
    //   1226: getfield 13	com/tencent/image/NativeVideoImage$PlayAudioThread:this$0	Lcom/tencent/image/NativeVideoImage;
    //   1229: iconst_1
    //   1230: putfield 241	com/tencent/image/NativeVideoImage:mPlayAudioOnceFinished	Z
    //   1233: aload_0
    //   1234: getfield 13	com/tencent/image/NativeVideoImage$PlayAudioThread:this$0	Lcom/tencent/image/NativeVideoImage;
    //   1237: getfield 245	com/tencent/image/NativeVideoImage:mVideoParams	Lcom/tencent/image/VideoDrawable$VideoDrawableParams;
    //   1240: astore 11
    //   1242: aload_0
    //   1243: getfield 13	com/tencent/image/NativeVideoImage$PlayAudioThread:this$0	Lcom/tencent/image/NativeVideoImage;
    //   1246: iconst_0
    //   1247: putfield 155	com/tencent/image/NativeVideoImage:mPlayAudioFrame	Z
    //   1250: aload 11
    //   1252: iconst_0
    //   1253: putfield 248	com/tencent/image/VideoDrawable$VideoDrawableParams:mPlayAudioFrame	Z
    //   1256: aload_0
    //   1257: getfield 13	com/tencent/image/NativeVideoImage$PlayAudioThread:this$0	Lcom/tencent/image/NativeVideoImage;
    //   1260: getfield 252	com/tencent/image/NativeVideoImage:mOption	Lcom/tencent/video/decode/AVDecodeOption;
    //   1263: iconst_1
    //   1264: putfield 257	com/tencent/video/decode/AVDecodeOption:ignore_audio	Z
    //   1267: getstatic 261	com/tencent/image/NativeVideoImage:sUIHandler	Landroid/os/Handler;
    //   1270: new 263	com/tencent/image/NativeVideoImage$PlayAudioThread$1
    //   1273: dup
    //   1274: aload_0
    //   1275: invokespecial 266	com/tencent/image/NativeVideoImage$PlayAudioThread$1:<init>	(Lcom/tencent/image/NativeVideoImage$PlayAudioThread;)V
    //   1278: invokevirtual 272	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   1281: pop
    //   1282: aload_0
    //   1283: getfield 13	com/tencent/image/NativeVideoImage$PlayAudioThread:this$0	Lcom/tencent/image/NativeVideoImage;
    //   1286: getfield 60	com/tencent/image/NativeVideoImage:mAudioTrack	Landroid/media/AudioTrack;
    //   1289: ifnull +114 -> 1403
    //   1292: aload_0
    //   1293: getfield 13	com/tencent/image/NativeVideoImage$PlayAudioThread:this$0	Lcom/tencent/image/NativeVideoImage;
    //   1296: getfield 60	com/tencent/image/NativeVideoImage:mAudioTrack	Landroid/media/AudioTrack;
    //   1299: invokevirtual 103	android/media/AudioTrack:stop	()V
    //   1302: aload_0
    //   1303: getfield 13	com/tencent/image/NativeVideoImage$PlayAudioThread:this$0	Lcom/tencent/image/NativeVideoImage;
    //   1306: getfield 60	com/tencent/image/NativeVideoImage:mAudioTrack	Landroid/media/AudioTrack;
    //   1309: ifnull +94 -> 1403
    //   1312: aload_0
    //   1313: getfield 13	com/tencent/image/NativeVideoImage$PlayAudioThread:this$0	Lcom/tencent/image/NativeVideoImage;
    //   1316: getfield 60	com/tencent/image/NativeVideoImage:mAudioTrack	Landroid/media/AudioTrack;
    //   1319: invokevirtual 106	android/media/AudioTrack:release	()V
    //   1322: aload_0
    //   1323: getfield 13	com/tencent/image/NativeVideoImage$PlayAudioThread:this$0	Lcom/tencent/image/NativeVideoImage;
    //   1326: aconst_null
    //   1327: putfield 60	com/tencent/image/NativeVideoImage:mAudioTrack	Landroid/media/AudioTrack;
    //   1330: goto +73 -> 1403
    //   1333: astore 11
    //   1335: goto +37 -> 1372
    //   1338: astore 11
    //   1340: getstatic 74	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   1343: getfield 80	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   1346: getstatic 90	com/tencent/image/NativeVideoImage:TAG_AUDIO	Ljava/lang/String;
    //   1349: iconst_1
    //   1350: ldc 108
    //   1352: aload 11
    //   1354: invokeinterface 111 5 0
    //   1359: aload_0
    //   1360: getfield 13	com/tencent/image/NativeVideoImage$PlayAudioThread:this$0	Lcom/tencent/image/NativeVideoImage;
    //   1363: getfield 60	com/tencent/image/NativeVideoImage:mAudioTrack	Landroid/media/AudioTrack;
    //   1366: ifnull +37 -> 1403
    //   1369: goto -57 -> 1312
    //   1372: aload_0
    //   1373: getfield 13	com/tencent/image/NativeVideoImage$PlayAudioThread:this$0	Lcom/tencent/image/NativeVideoImage;
    //   1376: getfield 60	com/tencent/image/NativeVideoImage:mAudioTrack	Landroid/media/AudioTrack;
    //   1379: ifnull +21 -> 1400
    //   1382: aload_0
    //   1383: getfield 13	com/tencent/image/NativeVideoImage$PlayAudioThread:this$0	Lcom/tencent/image/NativeVideoImage;
    //   1386: getfield 60	com/tencent/image/NativeVideoImage:mAudioTrack	Landroid/media/AudioTrack;
    //   1389: invokevirtual 106	android/media/AudioTrack:release	()V
    //   1392: aload_0
    //   1393: getfield 13	com/tencent/image/NativeVideoImage$PlayAudioThread:this$0	Lcom/tencent/image/NativeVideoImage;
    //   1396: aconst_null
    //   1397: putfield 60	com/tencent/image/NativeVideoImage:mAudioTrack	Landroid/media/AudioTrack;
    //   1400: aload 11
    //   1402: athrow
    //   1403: aload_0
    //   1404: getfield 13	com/tencent/image/NativeVideoImage$PlayAudioThread:this$0	Lcom/tencent/image/NativeVideoImage;
    //   1407: getfield 115	com/tencent/image/NativeVideoImage:mRequireAudioFocus	Z
    //   1410: ifeq +6 -> 1416
    //   1413: invokestatic 120	com/tencent/image/AudioUtils:abandonAudioFoucus	()V
    //   1416: aload_0
    //   1417: getfield 13	com/tencent/image/NativeVideoImage$PlayAudioThread:this$0	Lcom/tencent/image/NativeVideoImage;
    //   1420: iconst_1
    //   1421: invokestatic 56	com/tencent/image/NativeVideoImage:access$302	(Lcom/tencent/image/NativeVideoImage;Z)Z
    //   1424: pop
    //   1425: getstatic 74	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   1428: getfield 80	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   1431: invokeinterface 86 1 0
    //   1436: ifeq +20 -> 1456
    //   1439: getstatic 74	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   1442: getfield 80	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   1445: getstatic 90	com/tencent/image/NativeVideoImage:TAG_AUDIO	Ljava/lang/String;
    //   1448: iconst_2
    //   1449: ldc 122
    //   1451: invokeinterface 125 4 0
    //   1456: return
    //   1457: aload_0
    //   1458: getfield 13	com/tencent/image/NativeVideoImage$PlayAudioThread:this$0	Lcom/tencent/image/NativeVideoImage;
    //   1461: invokestatic 275	com/tencent/image/NativeVideoImage:access$700	(Lcom/tencent/image/NativeVideoImage;)Ljava/lang/Object;
    //   1464: astore 11
    //   1466: aload 11
    //   1468: monitorenter
    //   1469: aload_0
    //   1470: getfield 13	com/tencent/image/NativeVideoImage$PlayAudioThread:this$0	Lcom/tencent/image/NativeVideoImage;
    //   1473: invokestatic 279	com/tencent/image/NativeVideoImage:access$800	(Lcom/tencent/image/NativeVideoImage;)Z
    //   1476: ifne +80 -> 1556
    //   1479: getstatic 74	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   1482: getfield 80	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   1485: invokeinterface 86 1 0
    //   1490: ifeq +21 -> 1511
    //   1493: getstatic 74	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   1496: getfield 80	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   1499: getstatic 90	com/tencent/image/NativeVideoImage:TAG_AUDIO	Ljava/lang/String;
    //   1502: iconst_2
    //   1503: ldc_w 281
    //   1506: invokeinterface 98 4 0
    //   1511: aload_0
    //   1512: getfield 13	com/tencent/image/NativeVideoImage$PlayAudioThread:this$0	Lcom/tencent/image/NativeVideoImage;
    //   1515: invokestatic 275	com/tencent/image/NativeVideoImage:access$700	(Lcom/tencent/image/NativeVideoImage;)Ljava/lang/Object;
    //   1518: invokevirtual 147	java/lang/Object:wait	()V
    //   1521: getstatic 74	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   1524: getfield 80	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   1527: invokeinterface 86 1 0
    //   1532: ifeq -63 -> 1469
    //   1535: getstatic 74	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   1538: getfield 80	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   1541: getstatic 90	com/tencent/image/NativeVideoImage:TAG_AUDIO	Ljava/lang/String;
    //   1544: iconst_2
    //   1545: ldc_w 283
    //   1548: invokeinterface 98 4 0
    //   1553: goto -84 -> 1469
    //   1556: aload 11
    //   1558: monitorexit
    //   1559: lload 4
    //   1561: lstore_2
    //   1562: goto -1260 -> 302
    //   1565: astore 12
    //   1567: aload 11
    //   1569: monitorexit
    //   1570: aload 12
    //   1572: athrow
    //   1573: astore 11
    //   1575: goto +199 -> 1774
    //   1578: astore 11
    //   1580: getstatic 74	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   1583: getfield 80	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   1586: getstatic 90	com/tencent/image/NativeVideoImage:TAG_AUDIO	Ljava/lang/String;
    //   1589: iconst_1
    //   1590: ldc 108
    //   1592: aload 11
    //   1594: invokeinterface 111 5 0
    //   1599: aload_0
    //   1600: getfield 13	com/tencent/image/NativeVideoImage$PlayAudioThread:this$0	Lcom/tencent/image/NativeVideoImage;
    //   1603: getfield 60	com/tencent/image/NativeVideoImage:mAudioTrack	Landroid/media/AudioTrack;
    //   1606: ifnull +114 -> 1720
    //   1609: aload_0
    //   1610: getfield 13	com/tencent/image/NativeVideoImage$PlayAudioThread:this$0	Lcom/tencent/image/NativeVideoImage;
    //   1613: getfield 60	com/tencent/image/NativeVideoImage:mAudioTrack	Landroid/media/AudioTrack;
    //   1616: invokevirtual 103	android/media/AudioTrack:stop	()V
    //   1619: aload_0
    //   1620: getfield 13	com/tencent/image/NativeVideoImage$PlayAudioThread:this$0	Lcom/tencent/image/NativeVideoImage;
    //   1623: getfield 60	com/tencent/image/NativeVideoImage:mAudioTrack	Landroid/media/AudioTrack;
    //   1626: ifnull +94 -> 1720
    //   1629: aload_0
    //   1630: getfield 13	com/tencent/image/NativeVideoImage$PlayAudioThread:this$0	Lcom/tencent/image/NativeVideoImage;
    //   1633: getfield 60	com/tencent/image/NativeVideoImage:mAudioTrack	Landroid/media/AudioTrack;
    //   1636: invokevirtual 106	android/media/AudioTrack:release	()V
    //   1639: aload_0
    //   1640: getfield 13	com/tencent/image/NativeVideoImage$PlayAudioThread:this$0	Lcom/tencent/image/NativeVideoImage;
    //   1643: aconst_null
    //   1644: putfield 60	com/tencent/image/NativeVideoImage:mAudioTrack	Landroid/media/AudioTrack;
    //   1647: goto +73 -> 1720
    //   1650: astore 11
    //   1652: goto +37 -> 1689
    //   1655: astore 11
    //   1657: getstatic 74	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   1660: getfield 80	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   1663: getstatic 90	com/tencent/image/NativeVideoImage:TAG_AUDIO	Ljava/lang/String;
    //   1666: iconst_1
    //   1667: ldc 108
    //   1669: aload 11
    //   1671: invokeinterface 111 5 0
    //   1676: aload_0
    //   1677: getfield 13	com/tencent/image/NativeVideoImage$PlayAudioThread:this$0	Lcom/tencent/image/NativeVideoImage;
    //   1680: getfield 60	com/tencent/image/NativeVideoImage:mAudioTrack	Landroid/media/AudioTrack;
    //   1683: ifnull +37 -> 1720
    //   1686: goto -57 -> 1629
    //   1689: aload_0
    //   1690: getfield 13	com/tencent/image/NativeVideoImage$PlayAudioThread:this$0	Lcom/tencent/image/NativeVideoImage;
    //   1693: getfield 60	com/tencent/image/NativeVideoImage:mAudioTrack	Landroid/media/AudioTrack;
    //   1696: ifnull +21 -> 1717
    //   1699: aload_0
    //   1700: getfield 13	com/tencent/image/NativeVideoImage$PlayAudioThread:this$0	Lcom/tencent/image/NativeVideoImage;
    //   1703: getfield 60	com/tencent/image/NativeVideoImage:mAudioTrack	Landroid/media/AudioTrack;
    //   1706: invokevirtual 106	android/media/AudioTrack:release	()V
    //   1709: aload_0
    //   1710: getfield 13	com/tencent/image/NativeVideoImage$PlayAudioThread:this$0	Lcom/tencent/image/NativeVideoImage;
    //   1713: aconst_null
    //   1714: putfield 60	com/tencent/image/NativeVideoImage:mAudioTrack	Landroid/media/AudioTrack;
    //   1717: aload 11
    //   1719: athrow
    //   1720: aload_0
    //   1721: getfield 13	com/tencent/image/NativeVideoImage$PlayAudioThread:this$0	Lcom/tencent/image/NativeVideoImage;
    //   1724: getfield 115	com/tencent/image/NativeVideoImage:mRequireAudioFocus	Z
    //   1727: ifeq +6 -> 1733
    //   1730: invokestatic 120	com/tencent/image/AudioUtils:abandonAudioFoucus	()V
    //   1733: aload_0
    //   1734: getfield 13	com/tencent/image/NativeVideoImage$PlayAudioThread:this$0	Lcom/tencent/image/NativeVideoImage;
    //   1737: iconst_1
    //   1738: invokestatic 56	com/tencent/image/NativeVideoImage:access$302	(Lcom/tencent/image/NativeVideoImage;Z)Z
    //   1741: pop
    //   1742: getstatic 74	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   1745: getfield 80	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   1748: invokeinterface 86 1 0
    //   1753: ifeq +20 -> 1773
    //   1756: getstatic 74	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   1759: getfield 80	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   1762: getstatic 90	com/tencent/image/NativeVideoImage:TAG_AUDIO	Ljava/lang/String;
    //   1765: iconst_2
    //   1766: ldc 122
    //   1768: invokeinterface 125 4 0
    //   1773: return
    //   1774: aload_0
    //   1775: getfield 13	com/tencent/image/NativeVideoImage$PlayAudioThread:this$0	Lcom/tencent/image/NativeVideoImage;
    //   1778: getfield 60	com/tencent/image/NativeVideoImage:mAudioTrack	Landroid/media/AudioTrack;
    //   1781: ifnull +114 -> 1895
    //   1784: aload_0
    //   1785: getfield 13	com/tencent/image/NativeVideoImage$PlayAudioThread:this$0	Lcom/tencent/image/NativeVideoImage;
    //   1788: getfield 60	com/tencent/image/NativeVideoImage:mAudioTrack	Landroid/media/AudioTrack;
    //   1791: invokevirtual 103	android/media/AudioTrack:stop	()V
    //   1794: aload_0
    //   1795: getfield 13	com/tencent/image/NativeVideoImage$PlayAudioThread:this$0	Lcom/tencent/image/NativeVideoImage;
    //   1798: getfield 60	com/tencent/image/NativeVideoImage:mAudioTrack	Landroid/media/AudioTrack;
    //   1801: ifnull +94 -> 1895
    //   1804: aload_0
    //   1805: getfield 13	com/tencent/image/NativeVideoImage$PlayAudioThread:this$0	Lcom/tencent/image/NativeVideoImage;
    //   1808: getfield 60	com/tencent/image/NativeVideoImage:mAudioTrack	Landroid/media/AudioTrack;
    //   1811: invokevirtual 106	android/media/AudioTrack:release	()V
    //   1814: aload_0
    //   1815: getfield 13	com/tencent/image/NativeVideoImage$PlayAudioThread:this$0	Lcom/tencent/image/NativeVideoImage;
    //   1818: aconst_null
    //   1819: putfield 60	com/tencent/image/NativeVideoImage:mAudioTrack	Landroid/media/AudioTrack;
    //   1822: goto +73 -> 1895
    //   1825: astore 11
    //   1827: goto +37 -> 1864
    //   1830: astore 12
    //   1832: getstatic 74	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   1835: getfield 80	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   1838: getstatic 90	com/tencent/image/NativeVideoImage:TAG_AUDIO	Ljava/lang/String;
    //   1841: iconst_1
    //   1842: ldc 108
    //   1844: aload 12
    //   1846: invokeinterface 111 5 0
    //   1851: aload_0
    //   1852: getfield 13	com/tencent/image/NativeVideoImage$PlayAudioThread:this$0	Lcom/tencent/image/NativeVideoImage;
    //   1855: getfield 60	com/tencent/image/NativeVideoImage:mAudioTrack	Landroid/media/AudioTrack;
    //   1858: ifnull +37 -> 1895
    //   1861: goto -57 -> 1804
    //   1864: aload_0
    //   1865: getfield 13	com/tencent/image/NativeVideoImage$PlayAudioThread:this$0	Lcom/tencent/image/NativeVideoImage;
    //   1868: getfield 60	com/tencent/image/NativeVideoImage:mAudioTrack	Landroid/media/AudioTrack;
    //   1871: ifnull +21 -> 1892
    //   1874: aload_0
    //   1875: getfield 13	com/tencent/image/NativeVideoImage$PlayAudioThread:this$0	Lcom/tencent/image/NativeVideoImage;
    //   1878: getfield 60	com/tencent/image/NativeVideoImage:mAudioTrack	Landroid/media/AudioTrack;
    //   1881: invokevirtual 106	android/media/AudioTrack:release	()V
    //   1884: aload_0
    //   1885: getfield 13	com/tencent/image/NativeVideoImage$PlayAudioThread:this$0	Lcom/tencent/image/NativeVideoImage;
    //   1888: aconst_null
    //   1889: putfield 60	com/tencent/image/NativeVideoImage:mAudioTrack	Landroid/media/AudioTrack;
    //   1892: aload 11
    //   1894: athrow
    //   1895: aload_0
    //   1896: getfield 13	com/tencent/image/NativeVideoImage$PlayAudioThread:this$0	Lcom/tencent/image/NativeVideoImage;
    //   1899: getfield 115	com/tencent/image/NativeVideoImage:mRequireAudioFocus	Z
    //   1902: ifeq +6 -> 1908
    //   1905: invokestatic 120	com/tencent/image/AudioUtils:abandonAudioFoucus	()V
    //   1908: aload_0
    //   1909: getfield 13	com/tencent/image/NativeVideoImage$PlayAudioThread:this$0	Lcom/tencent/image/NativeVideoImage;
    //   1912: iconst_1
    //   1913: invokestatic 56	com/tencent/image/NativeVideoImage:access$302	(Lcom/tencent/image/NativeVideoImage;Z)Z
    //   1916: pop
    //   1917: getstatic 74	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   1920: getfield 80	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   1923: invokeinterface 86 1 0
    //   1928: ifeq +20 -> 1948
    //   1931: getstatic 74	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   1934: getfield 80	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   1937: getstatic 90	com/tencent/image/NativeVideoImage:TAG_AUDIO	Ljava/lang/String;
    //   1940: iconst_2
    //   1941: ldc 122
    //   1943: invokeinterface 125 4 0
    //   1948: goto +6 -> 1954
    //   1951: aload 11
    //   1953: athrow
    //   1954: goto -3 -> 1951
    //   1957: astore 12
    //   1959: goto -1649 -> 310
    //   1962: iconst_0
    //   1963: istore_1
    //   1964: lload 4
    //   1966: lload 8
    //   1968: lsub
    //   1969: lstore 8
    //   1971: lload 6
    //   1973: lload 4
    //   1975: lsub
    //   1976: lstore 4
    //   1978: lload 8
    //   1980: lconst_1
    //   1981: lcmp
    //   1982: ifge -1119 -> 863
    //   1985: lload 4
    //   1987: lconst_1
    //   1988: lcmp
    //   1989: iflt -1005 -> 984
    //   1992: goto -1129 -> 863
    //   1995: lload 6
    //   1997: lstore 4
    //   1999: goto -836 -> 1163
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2002	0	this	PlayAudioThread
    //   825	1139	1	i	int
    //   29	1533	2	l1	long
    //   793	1205	4	l2	long
    //   815	1181	6	l3	long
    //   757	1222	8	l4	long
    //   323	3	10	bool	boolean
    //   60	43	11	localILog	com.tencent.image.api.ILog
    //   168	1	11	localObject1	java.lang.Object
    //   173	63	11	localIllegalStateException1	java.lang.IllegalStateException
    //   305	215	11	localObject2	java.lang.Object
    //   614	1	11	localObject3	java.lang.Object
    //   619	63	11	localIllegalStateException2	java.lang.IllegalStateException
    //   766	275	11	localObject4	java.lang.Object
    //   1070	21	11	localInterruptedException	java.lang.InterruptedException
    //   1096	68	11	localAVideoException	com.tencent.video.decode.AVideoException
    //   1240	11	11	localVideoDrawableParams	VideoDrawable.VideoDrawableParams
    //   1333	1	11	localObject5	java.lang.Object
    //   1338	63	11	localIllegalStateException3	java.lang.IllegalStateException
    //   1464	104	11	localObject6	java.lang.Object
    //   1573	1	11	localObject7	java.lang.Object
    //   1578	15	11	localException1	java.lang.Exception
    //   1650	1	11	localObject8	java.lang.Object
    //   1655	63	11	localIllegalStateException4	java.lang.IllegalStateException
    //   1825	127	11	localObject9	java.lang.Object
    //   65	978	12	localObject10	java.lang.Object
    //   1080	6	12	localObject11	java.lang.Object
    //   1088	6	12	localObject12	java.lang.Object
    //   1565	6	12	localObject13	java.lang.Object
    //   1830	15	12	localIllegalStateException5	java.lang.IllegalStateException
    //   1957	1	12	localException2	java.lang.Exception
    //   74	972	13	localObject14	java.lang.Object
    //   364	130	14	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   127	137	168	finally
    //   175	194	168	finally
    //   127	137	173	java/lang/IllegalStateException
    //   573	583	614	finally
    //   621	640	614	finally
    //   573	583	619	java/lang/IllegalStateException
    //   1062	1067	1070	java/lang/InterruptedException
    //   771	783	1080	finally
    //   1082	1085	1080	finally
    //   310	325	1088	finally
    //   330	407	1088	finally
    //   407	420	1088	finally
    //   420	503	1088	finally
    //   503	516	1088	finally
    //   519	522	1088	finally
    //   1090	1093	1088	finally
    //   302	310	1096	com/tencent/video/decode/AVideoException
    //   522	563	1096	com/tencent/video/decode/AVideoException
    //   723	754	1096	com/tencent/video/decode/AVideoException
    //   754	771	1096	com/tencent/video/decode/AVideoException
    //   783	826	1096	com/tencent/video/decode/AVideoException
    //   830	848	1096	com/tencent/video/decode/AVideoException
    //   851	860	1096	com/tencent/video/decode/AVideoException
    //   863	984	1096	com/tencent/video/decode/AVideoException
    //   995	1055	1096	com/tencent/video/decode/AVideoException
    //   1062	1067	1096	com/tencent/video/decode/AVideoException
    //   1072	1077	1096	com/tencent/video/decode/AVideoException
    //   1085	1088	1096	com/tencent/video/decode/AVideoException
    //   1093	1096	1096	com/tencent/video/decode/AVideoException
    //   1292	1302	1333	finally
    //   1340	1359	1333	finally
    //   1292	1302	1338	java/lang/IllegalStateException
    //   1469	1511	1565	finally
    //   1511	1553	1565	finally
    //   1556	1559	1565	finally
    //   1567	1570	1565	finally
    //   0	26	1573	finally
    //   26	117	1573	finally
    //   292	302	1573	finally
    //   302	310	1573	finally
    //   522	563	1573	finally
    //   723	754	1573	finally
    //   754	771	1573	finally
    //   783	826	1573	finally
    //   830	848	1573	finally
    //   851	860	1573	finally
    //   863	984	1573	finally
    //   995	1055	1573	finally
    //   1062	1067	1573	finally
    //   1072	1077	1573	finally
    //   1085	1088	1573	finally
    //   1093	1096	1573	finally
    //   1098	1103	1573	finally
    //   1117	1160	1573	finally
    //   1163	1169	1573	finally
    //   1184	1215	1573	finally
    //   1215	1282	1573	finally
    //   1457	1469	1573	finally
    //   1570	1573	1573	finally
    //   1580	1599	1573	finally
    //   0	26	1578	java/lang/Exception
    //   26	117	1578	java/lang/Exception
    //   292	302	1578	java/lang/Exception
    //   302	310	1578	java/lang/Exception
    //   522	563	1578	java/lang/Exception
    //   723	754	1578	java/lang/Exception
    //   754	771	1578	java/lang/Exception
    //   783	826	1578	java/lang/Exception
    //   830	848	1578	java/lang/Exception
    //   851	860	1578	java/lang/Exception
    //   863	984	1578	java/lang/Exception
    //   995	1055	1578	java/lang/Exception
    //   1062	1067	1578	java/lang/Exception
    //   1072	1077	1578	java/lang/Exception
    //   1085	1088	1578	java/lang/Exception
    //   1093	1096	1578	java/lang/Exception
    //   1098	1103	1578	java/lang/Exception
    //   1117	1160	1578	java/lang/Exception
    //   1163	1169	1578	java/lang/Exception
    //   1184	1215	1578	java/lang/Exception
    //   1215	1282	1578	java/lang/Exception
    //   1457	1469	1578	java/lang/Exception
    //   1570	1573	1578	java/lang/Exception
    //   1609	1619	1650	finally
    //   1657	1676	1650	finally
    //   1609	1619	1655	java/lang/IllegalStateException
    //   1784	1794	1825	finally
    //   1832	1851	1825	finally
    //   1784	1794	1830	java/lang/IllegalStateException
    //   330	407	1957	java/lang/Exception
    //   407	420	1957	java/lang/Exception
    //   420	503	1957	java/lang/Exception
    //   503	516	1957	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.image.NativeVideoImage.PlayAudioThread
 * JD-Core Version:    0.7.0.1
 */