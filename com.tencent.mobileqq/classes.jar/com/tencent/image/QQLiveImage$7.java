package com.tencent.image;

import android.content.Context;

class QQLiveImage$7
  implements Runnable
{
  QQLiveImage$7(QQLiveImage paramQQLiveImage, Context paramContext, int paramInt) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: invokestatic 33	com/tencent/image/QQLiveImage:access$200	()Z
    //   3: ifne +42 -> 45
    //   6: getstatic 37	com/tencent/image/QQLiveImage:mIsDebugEnable	Z
    //   9: invokestatic 43	com/tencent/qqlive/mediaplayer/api/TVK_SDKMgr:setDebugEnable	(Z)V
    //   12: aload_0
    //   13: getfield 18	com/tencent/image/QQLiveImage$7:val$context	Landroid/content/Context;
    //   16: ldc 45
    //   18: ldc 47
    //   20: invokestatic 51	com/tencent/qqlive/mediaplayer/api/TVK_SDKMgr:initSdk	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   23: ldc2_w 52
    //   26: invokestatic 57	com/tencent/qqlive/mediaplayer/api/TVK_SDKMgr:setPreloadMaxStorageSize	(J)V
    //   29: new 59	com/tencent/image/QQLiveImage$OnLogListener
    //   32: dup
    //   33: aconst_null
    //   34: invokespecial 62	com/tencent/image/QQLiveImage$OnLogListener:<init>	(Lcom/tencent/image/QQLiveImage$1;)V
    //   37: invokestatic 66	com/tencent/qqlive/mediaplayer/api/TVK_SDKMgr:setOnLogListener	(Lcom/tencent/qqlive/mediaplayer/api/TVK_SDKMgr$OnLogListener;)V
    //   40: iconst_1
    //   41: invokestatic 70	com/tencent/image/QQLiveImage:access$202	(Z)Z
    //   44: pop
    //   45: aload_0
    //   46: getfield 18	com/tencent/image/QQLiveImage$7:val$context	Landroid/content/Context;
    //   49: invokestatic 74	com/tencent/qqlive/mediaplayer/api/TVK_SDKMgr:isInstalled	(Landroid/content/Context;)Z
    //   52: ifne +202 -> 254
    //   55: getstatic 80	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   58: getfield 86	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   61: invokeinterface 91 1 0
    //   66: ifeq +90 -> 156
    //   69: getstatic 80	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   72: getfield 86	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   75: astore 4
    //   77: new 93	java/lang/StringBuilder
    //   80: dup
    //   81: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   84: astore 5
    //   86: aload 5
    //   88: getstatic 98	com/tencent/image/QQLiveImage:TAG	Ljava/lang/String;
    //   91: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: pop
    //   95: aload 5
    //   97: aload_0
    //   98: getfield 16	com/tencent/image/QQLiveImage$7:this$0	Lcom/tencent/image/QQLiveImage;
    //   101: getfield 105	com/tencent/image/QQLiveImage:ID	I
    //   104: invokevirtual 108	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   107: pop
    //   108: aload 5
    //   110: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   113: astore 5
    //   115: new 93	java/lang/StringBuilder
    //   118: dup
    //   119: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   122: astore 6
    //   124: aload 6
    //   126: ldc 114
    //   128: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: pop
    //   132: aload 6
    //   134: invokestatic 118	com/tencent/image/QQLiveImage:access$400	()Ljava/util/concurrent/atomic/AtomicBoolean;
    //   137: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   140: pop
    //   141: aload 4
    //   143: aload 5
    //   145: iconst_2
    //   146: aload 6
    //   148: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   151: invokeinterface 125 4 0
    //   156: invokestatic 118	com/tencent/image/QQLiveImage:access$400	()Ljava/util/concurrent/atomic/AtomicBoolean;
    //   159: invokevirtual 130	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   162: ifne +91 -> 253
    //   165: aload_0
    //   166: getfield 18	com/tencent/image/QQLiveImage$7:val$context	Landroid/content/Context;
    //   169: new 132	com/tencent/image/QQLiveImage$SDKInstallListener
    //   172: dup
    //   173: aconst_null
    //   174: invokespecial 133	com/tencent/image/QQLiveImage$SDKInstallListener:<init>	(Lcom/tencent/image/QQLiveImage$1;)V
    //   177: invokestatic 137	com/tencent/qqlive/mediaplayer/api/TVK_SDKMgr:installPlugin	(Landroid/content/Context;Lcom/tencent/qqlive/mediaplayer/api/TVK_SDKMgr$InstallListener;)V
    //   180: return
    //   181: astore 4
    //   183: getstatic 80	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   186: getfield 86	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   189: invokeinterface 91 1 0
    //   194: ifeq +59 -> 253
    //   197: getstatic 80	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   200: getfield 86	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   203: astore 5
    //   205: new 93	java/lang/StringBuilder
    //   208: dup
    //   209: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   212: astore 6
    //   214: aload 6
    //   216: getstatic 98	com/tencent/image/QQLiveImage:TAG	Ljava/lang/String;
    //   219: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: pop
    //   223: aload 6
    //   225: aload_0
    //   226: getfield 16	com/tencent/image/QQLiveImage$7:this$0	Lcom/tencent/image/QQLiveImage;
    //   229: getfield 105	com/tencent/image/QQLiveImage:ID	I
    //   232: invokevirtual 108	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   235: pop
    //   236: aload 5
    //   238: aload 6
    //   240: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   243: iconst_2
    //   244: ldc 139
    //   246: aload 4
    //   248: invokeinterface 142 5 0
    //   253: return
    //   254: aload_0
    //   255: getfield 16	com/tencent/image/QQLiveImage$7:this$0	Lcom/tencent/image/QQLiveImage;
    //   258: getfield 146	com/tencent/image/QQLiveImage:mParams	Lcom/tencent/image/QQLiveDrawable$QQLiveDrawableParams;
    //   261: astore 4
    //   263: aload 4
    //   265: ifnonnull +4 -> 269
    //   268: return
    //   269: aload 4
    //   271: getfield 151	com/tencent/image/QQLiveDrawable$QQLiveDrawableParams:mDataSourceType	I
    //   274: iconst_2
    //   275: if_icmpne +331 -> 606
    //   278: aload 4
    //   280: getfield 155	com/tencent/image/QQLiveDrawable$QQLiveDrawableParams:mDataSourceAdapter	Lcom/tencent/image/AbsThirdDataSourceAdapter;
    //   283: ifnull +254 -> 537
    //   286: aload_0
    //   287: getfield 16	com/tencent/image/QQLiveImage$7:this$0	Lcom/tencent/image/QQLiveImage;
    //   290: astore 5
    //   292: aload 5
    //   294: monitorenter
    //   295: aload 4
    //   297: getfield 155	com/tencent/image/QQLiveDrawable$QQLiveDrawableParams:mDataSourceAdapter	Lcom/tencent/image/AbsThirdDataSourceAdapter;
    //   300: ifnull +157 -> 457
    //   303: aload 4
    //   305: getfield 155	com/tencent/image/QQLiveDrawable$QQLiveDrawableParams:mDataSourceAdapter	Lcom/tencent/image/AbsThirdDataSourceAdapter;
    //   308: invokevirtual 161	com/tencent/image/AbsThirdDataSourceAdapter:getStaus	()I
    //   311: istore_1
    //   312: getstatic 80	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   315: getfield 86	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   318: invokeinterface 91 1 0
    //   323: ifeq +88 -> 411
    //   326: getstatic 80	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   329: getfield 86	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   332: astore 6
    //   334: new 93	java/lang/StringBuilder
    //   337: dup
    //   338: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   341: astore 7
    //   343: aload 7
    //   345: getstatic 98	com/tencent/image/QQLiveImage:TAG	Ljava/lang/String;
    //   348: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   351: pop
    //   352: aload 7
    //   354: aload_0
    //   355: getfield 16	com/tencent/image/QQLiveImage$7:this$0	Lcom/tencent/image/QQLiveImage;
    //   358: getfield 105	com/tencent/image/QQLiveImage:ID	I
    //   361: invokevirtual 108	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   364: pop
    //   365: aload 7
    //   367: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   370: astore 7
    //   372: new 93	java/lang/StringBuilder
    //   375: dup
    //   376: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   379: astore 8
    //   381: aload 8
    //   383: ldc 163
    //   385: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   388: pop
    //   389: aload 8
    //   391: iload_1
    //   392: invokevirtual 108	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   395: pop
    //   396: aload 6
    //   398: aload 7
    //   400: iconst_2
    //   401: aload 8
    //   403: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   406: invokeinterface 166 4 0
    //   411: iload_1
    //   412: ifne +30 -> 442
    //   415: aload 4
    //   417: getfield 155	com/tencent/image/QQLiveDrawable$QQLiveDrawableParams:mDataSourceAdapter	Lcom/tencent/image/AbsThirdDataSourceAdapter;
    //   420: aload 4
    //   422: getfield 169	com/tencent/image/QQLiveDrawable$QQLiveDrawableParams:mDataSource	Ljava/lang/String;
    //   425: new 171	com/tencent/image/QQLiveImage$7$1
    //   428: dup
    //   429: aload_0
    //   430: aload 4
    //   432: invokespecial 174	com/tencent/image/QQLiveImage$7$1:<init>	(Lcom/tencent/image/QQLiveImage$7;Lcom/tencent/image/QQLiveDrawable$QQLiveDrawableParams;)V
    //   435: invokevirtual 178	com/tencent/image/AbsThirdDataSourceAdapter:requestPrepare	(Ljava/lang/String;Lcom/tencent/image/AbsThirdDataSourceAdapter$OnPreparedCallback;)V
    //   438: aload 5
    //   440: monitorexit
    //   441: return
    //   442: iload_1
    //   443: iconst_1
    //   444: if_icmpne +7 -> 451
    //   447: aload 5
    //   449: monitorexit
    //   450: return
    //   451: aload 5
    //   453: monitorexit
    //   454: goto +152 -> 606
    //   457: getstatic 80	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   460: getfield 86	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   463: invokeinterface 91 1 0
    //   468: ifeq +57 -> 525
    //   471: getstatic 80	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   474: getfield 86	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   477: astore 4
    //   479: new 93	java/lang/StringBuilder
    //   482: dup
    //   483: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   486: astore 6
    //   488: aload 6
    //   490: getstatic 98	com/tencent/image/QQLiveImage:TAG	Ljava/lang/String;
    //   493: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   496: pop
    //   497: aload 6
    //   499: aload_0
    //   500: getfield 16	com/tencent/image/QQLiveImage$7:this$0	Lcom/tencent/image/QQLiveImage;
    //   503: getfield 105	com/tencent/image/QQLiveImage:ID	I
    //   506: invokevirtual 108	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   509: pop
    //   510: aload 4
    //   512: aload 6
    //   514: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   517: iconst_2
    //   518: ldc 180
    //   520: invokeinterface 125 4 0
    //   525: aload 5
    //   527: monitorexit
    //   528: return
    //   529: astore 4
    //   531: aload 5
    //   533: monitorexit
    //   534: aload 4
    //   536: athrow
    //   537: getstatic 80	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   540: getfield 86	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   543: invokeinterface 91 1 0
    //   548: ifeq +57 -> 605
    //   551: getstatic 80	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   554: getfield 86	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   557: astore 4
    //   559: new 93	java/lang/StringBuilder
    //   562: dup
    //   563: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   566: astore 5
    //   568: aload 5
    //   570: getstatic 98	com/tencent/image/QQLiveImage:TAG	Ljava/lang/String;
    //   573: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   576: pop
    //   577: aload 5
    //   579: aload_0
    //   580: getfield 16	com/tencent/image/QQLiveImage$7:this$0	Lcom/tencent/image/QQLiveImage;
    //   583: getfield 105	com/tencent/image/QQLiveImage:ID	I
    //   586: invokevirtual 108	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   589: pop
    //   590: aload 4
    //   592: aload 5
    //   594: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   597: iconst_2
    //   598: ldc 182
    //   600: invokeinterface 125 4 0
    //   605: return
    //   606: aload_0
    //   607: getfield 16	com/tencent/image/QQLiveImage$7:this$0	Lcom/tencent/image/QQLiveImage;
    //   610: invokestatic 186	com/tencent/image/QQLiveImage:access$600	(Lcom/tencent/image/QQLiveImage;)Lcom/tencent/qqlive/mediaplayer/api/TVK_IProxyFactory;
    //   613: ifnonnull +14 -> 627
    //   616: aload_0
    //   617: getfield 16	com/tencent/image/QQLiveImage$7:this$0	Lcom/tencent/image/QQLiveImage;
    //   620: invokestatic 190	com/tencent/qqlive/mediaplayer/api/TVK_SDKMgr:getProxyFactory	()Lcom/tencent/qqlive/mediaplayer/api/TVK_IProxyFactory;
    //   623: invokestatic 194	com/tencent/image/QQLiveImage:access$602	(Lcom/tencent/image/QQLiveImage;Lcom/tencent/qqlive/mediaplayer/api/TVK_IProxyFactory;)Lcom/tencent/qqlive/mediaplayer/api/TVK_IProxyFactory;
    //   626: pop
    //   627: aload_0
    //   628: getfield 16	com/tencent/image/QQLiveImage$7:this$0	Lcom/tencent/image/QQLiveImage;
    //   631: invokestatic 198	com/tencent/image/QQLiveImage:access$700	(Lcom/tencent/image/QQLiveImage;)Lcom/tencent/qqlive/mediaplayer/api/TVK_IMediaPlayer;
    //   634: ifnonnull +1562 -> 2196
    //   637: aload_0
    //   638: getfield 16	com/tencent/image/QQLiveImage$7:this$0	Lcom/tencent/image/QQLiveImage;
    //   641: astore 5
    //   643: aload 5
    //   645: monitorenter
    //   646: aload_0
    //   647: getfield 16	com/tencent/image/QQLiveImage$7:this$0	Lcom/tencent/image/QQLiveImage;
    //   650: invokestatic 198	com/tencent/image/QQLiveImage:access$700	(Lcom/tencent/image/QQLiveImage;)Lcom/tencent/qqlive/mediaplayer/api/TVK_IMediaPlayer;
    //   653: ifnonnull +1462 -> 2115
    //   656: aload_0
    //   657: getfield 16	com/tencent/image/QQLiveImage$7:this$0	Lcom/tencent/image/QQLiveImage;
    //   660: aload_0
    //   661: getfield 16	com/tencent/image/QQLiveImage$7:this$0	Lcom/tencent/image/QQLiveImage;
    //   664: invokestatic 186	com/tencent/image/QQLiveImage:access$600	(Lcom/tencent/image/QQLiveImage;)Lcom/tencent/qqlive/mediaplayer/api/TVK_IProxyFactory;
    //   667: aload_0
    //   668: getfield 18	com/tencent/image/QQLiveImage$7:val$context	Landroid/content/Context;
    //   671: aconst_null
    //   672: invokeinterface 204 3 0
    //   677: invokestatic 208	com/tencent/image/QQLiveImage:access$702	(Lcom/tencent/image/QQLiveImage;Lcom/tencent/qqlive/mediaplayer/api/TVK_IMediaPlayer;)Lcom/tencent/qqlive/mediaplayer/api/TVK_IMediaPlayer;
    //   680: pop
    //   681: aload 5
    //   683: monitorexit
    //   684: getstatic 80	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   687: getfield 86	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   690: invokeinterface 91 1 0
    //   695: ifeq +91 -> 786
    //   698: getstatic 80	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   701: getfield 86	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   704: astore 5
    //   706: new 93	java/lang/StringBuilder
    //   709: dup
    //   710: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   713: astore 6
    //   715: aload 6
    //   717: getstatic 98	com/tencent/image/QQLiveImage:TAG	Ljava/lang/String;
    //   720: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   723: pop
    //   724: aload 6
    //   726: aload_0
    //   727: getfield 16	com/tencent/image/QQLiveImage$7:this$0	Lcom/tencent/image/QQLiveImage;
    //   730: getfield 105	com/tencent/image/QQLiveImage:ID	I
    //   733: invokevirtual 108	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   736: pop
    //   737: aload 6
    //   739: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   742: astore 6
    //   744: new 93	java/lang/StringBuilder
    //   747: dup
    //   748: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   751: astore 7
    //   753: aload 7
    //   755: ldc 210
    //   757: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   760: pop
    //   761: aload 7
    //   763: aload_0
    //   764: getfield 20	com/tencent/image/QQLiveImage$7:val$startPosi	I
    //   767: invokevirtual 108	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   770: pop
    //   771: aload 5
    //   773: aload 6
    //   775: iconst_2
    //   776: aload 7
    //   778: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   781: invokeinterface 166 4 0
    //   786: aload_0
    //   787: getfield 16	com/tencent/image/QQLiveImage$7:this$0	Lcom/tencent/image/QQLiveImage;
    //   790: invokestatic 216	android/os/SystemClock:uptimeMillis	()J
    //   793: invokestatic 220	com/tencent/image/QQLiveImage:access$802	(Lcom/tencent/image/QQLiveImage;J)J
    //   796: pop2
    //   797: aload_0
    //   798: getfield 16	com/tencent/image/QQLiveImage$7:this$0	Lcom/tencent/image/QQLiveImage;
    //   801: invokestatic 224	com/tencent/image/QQLiveImage:access$900	(Lcom/tencent/image/QQLiveImage;)J
    //   804: lconst_0
    //   805: lcmp
    //   806: ifle +18 -> 824
    //   809: invokestatic 216	android/os/SystemClock:uptimeMillis	()J
    //   812: aload_0
    //   813: getfield 16	com/tencent/image/QQLiveImage$7:this$0	Lcom/tencent/image/QQLiveImage;
    //   816: invokestatic 224	com/tencent/image/QQLiveImage:access$900	(Lcom/tencent/image/QQLiveImage;)J
    //   819: lsub
    //   820: lstore_2
    //   821: goto +7 -> 828
    //   824: ldc2_w 225
    //   827: lstore_2
    //   828: aload_0
    //   829: getfield 16	com/tencent/image/QQLiveImage$7:this$0	Lcom/tencent/image/QQLiveImage;
    //   832: bipush 8
    //   834: lload_2
    //   835: invokestatic 232	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   838: invokestatic 236	com/tencent/image/QQLiveImage:access$1000	(Lcom/tencent/image/QQLiveImage;ILjava/lang/Object;)V
    //   841: aload_0
    //   842: getfield 16	com/tencent/image/QQLiveImage$7:this$0	Lcom/tencent/image/QQLiveImage;
    //   845: new 238	com/tencent/qqlive/mediaplayer/api/TVK_UserInfo
    //   848: dup
    //   849: ldc 47
    //   851: ldc 47
    //   853: invokespecial 241	com/tencent/qqlive/mediaplayer/api/TVK_UserInfo:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   856: invokestatic 245	com/tencent/image/QQLiveImage:access$1102	(Lcom/tencent/image/QQLiveImage;Lcom/tencent/qqlive/mediaplayer/api/TVK_UserInfo;)Lcom/tencent/qqlive/mediaplayer/api/TVK_UserInfo;
    //   859: pop
    //   860: aload 4
    //   862: getfield 151	com/tencent/image/QQLiveDrawable$QQLiveDrawableParams:mDataSourceType	I
    //   865: ifne +30 -> 895
    //   868: aload_0
    //   869: getfield 16	com/tencent/image/QQLiveImage$7:this$0	Lcom/tencent/image/QQLiveImage;
    //   872: new 247	com/tencent/qqlive/mediaplayer/api/TVK_PlayerVideoInfo
    //   875: dup
    //   876: bipush 8
    //   878: aload 4
    //   880: getfield 169	com/tencent/image/QQLiveDrawable$QQLiveDrawableParams:mDataSource	Ljava/lang/String;
    //   883: ldc 47
    //   885: invokespecial 250	com/tencent/qqlive/mediaplayer/api/TVK_PlayerVideoInfo:<init>	(ILjava/lang/String;Ljava/lang/String;)V
    //   888: invokestatic 254	com/tencent/image/QQLiveImage:access$1202	(Lcom/tencent/image/QQLiveImage;Lcom/tencent/qqlive/mediaplayer/api/TVK_PlayerVideoInfo;)Lcom/tencent/qqlive/mediaplayer/api/TVK_PlayerVideoInfo;
    //   891: pop
    //   892: goto +18 -> 910
    //   895: aload_0
    //   896: getfield 16	com/tencent/image/QQLiveImage$7:this$0	Lcom/tencent/image/QQLiveImage;
    //   899: new 247	com/tencent/qqlive/mediaplayer/api/TVK_PlayerVideoInfo
    //   902: dup
    //   903: invokespecial 255	com/tencent/qqlive/mediaplayer/api/TVK_PlayerVideoInfo:<init>	()V
    //   906: invokestatic 254	com/tencent/image/QQLiveImage:access$1202	(Lcom/tencent/image/QQLiveImage;Lcom/tencent/qqlive/mediaplayer/api/TVK_PlayerVideoInfo;)Lcom/tencent/qqlive/mediaplayer/api/TVK_PlayerVideoInfo;
    //   909: pop
    //   910: aload 4
    //   912: getfield 258	com/tencent/image/QQLiveDrawable$QQLiveDrawableParams:mPlayType	I
    //   915: iconst_1
    //   916: if_icmpne +17 -> 933
    //   919: aload_0
    //   920: getfield 16	com/tencent/image/QQLiveImage$7:this$0	Lcom/tencent/image/QQLiveImage;
    //   923: invokestatic 262	com/tencent/image/QQLiveImage:access$1200	(Lcom/tencent/image/QQLiveImage;)Lcom/tencent/qqlive/mediaplayer/api/TVK_PlayerVideoInfo;
    //   926: iconst_1
    //   927: invokevirtual 266	com/tencent/qqlive/mediaplayer/api/TVK_PlayerVideoInfo:setPlayType	(I)V
    //   930: goto +138 -> 1068
    //   933: aload 4
    //   935: getfield 258	com/tencent/image/QQLiveDrawable$QQLiveDrawableParams:mPlayType	I
    //   938: iconst_2
    //   939: if_icmpne +17 -> 956
    //   942: aload_0
    //   943: getfield 16	com/tencent/image/QQLiveImage$7:this$0	Lcom/tencent/image/QQLiveImage;
    //   946: invokestatic 262	com/tencent/image/QQLiveImage:access$1200	(Lcom/tencent/image/QQLiveImage;)Lcom/tencent/qqlive/mediaplayer/api/TVK_PlayerVideoInfo;
    //   949: iconst_4
    //   950: invokevirtual 266	com/tencent/qqlive/mediaplayer/api/TVK_PlayerVideoInfo:setPlayType	(I)V
    //   953: goto +115 -> 1068
    //   956: aload 4
    //   958: getfield 258	com/tencent/image/QQLiveDrawable$QQLiveDrawableParams:mPlayType	I
    //   961: iconst_3
    //   962: if_icmpne +95 -> 1057
    //   965: aload 4
    //   967: getfield 155	com/tencent/image/QQLiveDrawable$QQLiveDrawableParams:mDataSourceAdapter	Lcom/tencent/image/AbsThirdDataSourceAdapter;
    //   970: ifnull +87 -> 1057
    //   973: aload_0
    //   974: getfield 16	com/tencent/image/QQLiveImage$7:this$0	Lcom/tencent/image/QQLiveImage;
    //   977: getfield 146	com/tencent/image/QQLiveImage:mParams	Lcom/tencent/image/QQLiveDrawable$QQLiveDrawableParams;
    //   980: getfield 155	com/tencent/image/QQLiveDrawable$QQLiveDrawableParams:mDataSourceAdapter	Lcom/tencent/image/AbsThirdDataSourceAdapter;
    //   983: invokevirtual 269	com/tencent/image/AbsThirdDataSourceAdapter:getPlayType	()I
    //   986: istore_1
    //   987: iload_1
    //   988: iconst_2
    //   989: if_icmpne +17 -> 1006
    //   992: aload_0
    //   993: getfield 16	com/tencent/image/QQLiveImage$7:this$0	Lcom/tencent/image/QQLiveImage;
    //   996: invokestatic 262	com/tencent/image/QQLiveImage:access$1200	(Lcom/tencent/image/QQLiveImage;)Lcom/tencent/qqlive/mediaplayer/api/TVK_PlayerVideoInfo;
    //   999: iconst_4
    //   1000: invokevirtual 266	com/tencent/qqlive/mediaplayer/api/TVK_PlayerVideoInfo:setPlayType	(I)V
    //   1003: goto +65 -> 1068
    //   1006: iload_1
    //   1007: iconst_1
    //   1008: if_icmpne +17 -> 1025
    //   1011: aload_0
    //   1012: getfield 16	com/tencent/image/QQLiveImage$7:this$0	Lcom/tencent/image/QQLiveImage;
    //   1015: invokestatic 262	com/tencent/image/QQLiveImage:access$1200	(Lcom/tencent/image/QQLiveImage;)Lcom/tencent/qqlive/mediaplayer/api/TVK_PlayerVideoInfo;
    //   1018: iconst_1
    //   1019: invokevirtual 266	com/tencent/qqlive/mediaplayer/api/TVK_PlayerVideoInfo:setPlayType	(I)V
    //   1022: goto +46 -> 1068
    //   1025: iload_1
    //   1026: ifne +17 -> 1043
    //   1029: aload_0
    //   1030: getfield 16	com/tencent/image/QQLiveImage$7:this$0	Lcom/tencent/image/QQLiveImage;
    //   1033: invokestatic 262	com/tencent/image/QQLiveImage:access$1200	(Lcom/tencent/image/QQLiveImage;)Lcom/tencent/qqlive/mediaplayer/api/TVK_PlayerVideoInfo;
    //   1036: iconst_2
    //   1037: invokevirtual 266	com/tencent/qqlive/mediaplayer/api/TVK_PlayerVideoInfo:setPlayType	(I)V
    //   1040: goto +28 -> 1068
    //   1043: aload_0
    //   1044: getfield 16	com/tencent/image/QQLiveImage$7:this$0	Lcom/tencent/image/QQLiveImage;
    //   1047: invokestatic 262	com/tencent/image/QQLiveImage:access$1200	(Lcom/tencent/image/QQLiveImage;)Lcom/tencent/qqlive/mediaplayer/api/TVK_PlayerVideoInfo;
    //   1050: iconst_2
    //   1051: invokevirtual 266	com/tencent/qqlive/mediaplayer/api/TVK_PlayerVideoInfo:setPlayType	(I)V
    //   1054: goto +14 -> 1068
    //   1057: aload_0
    //   1058: getfield 16	com/tencent/image/QQLiveImage$7:this$0	Lcom/tencent/image/QQLiveImage;
    //   1061: invokestatic 262	com/tencent/image/QQLiveImage:access$1200	(Lcom/tencent/image/QQLiveImage;)Lcom/tencent/qqlive/mediaplayer/api/TVK_PlayerVideoInfo;
    //   1064: iconst_2
    //   1065: invokevirtual 266	com/tencent/qqlive/mediaplayer/api/TVK_PlayerVideoInfo:setPlayType	(I)V
    //   1068: aload_0
    //   1069: getfield 16	com/tencent/image/QQLiveImage$7:this$0	Lcom/tencent/image/QQLiveImage;
    //   1072: invokestatic 262	com/tencent/image/QQLiveImage:access$1200	(Lcom/tencent/image/QQLiveImage;)Lcom/tencent/qqlive/mediaplayer/api/TVK_PlayerVideoInfo;
    //   1075: ldc_w 271
    //   1078: invokevirtual 275	com/tencent/qqlive/mediaplayer/api/TVK_PlayerVideoInfo:setPlayMode	(Ljava/lang/String;)V
    //   1081: new 277	java/util/HashMap
    //   1084: dup
    //   1085: invokespecial 278	java/util/HashMap:<init>	()V
    //   1088: astore 5
    //   1090: aload 4
    //   1092: getfield 281	com/tencent/image/QQLiveDrawable$QQLiveDrawableParams:mReportTag	Ljava/lang/String;
    //   1095: invokestatic 287	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1098: ifne +22 -> 1120
    //   1101: aload 5
    //   1103: ldc_w 289
    //   1106: aload 4
    //   1108: getfield 281	com/tencent/image/QQLiveDrawable$QQLiveDrawableParams:mReportTag	Ljava/lang/String;
    //   1111: invokeinterface 295 3 0
    //   1116: pop
    //   1117: goto +17 -> 1134
    //   1120: aload 5
    //   1122: ldc_w 289
    //   1125: ldc_w 297
    //   1128: invokeinterface 295 3 0
    //   1133: pop
    //   1134: getstatic 80	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   1137: getfield 86	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   1140: invokeinterface 91 1 0
    //   1145: ifeq +60 -> 1205
    //   1148: getstatic 80	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   1151: getfield 86	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   1154: astore 6
    //   1156: getstatic 98	com/tencent/image/QQLiveImage:TAG	Ljava/lang/String;
    //   1159: astore 7
    //   1161: new 93	java/lang/StringBuilder
    //   1164: dup
    //   1165: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   1168: astore 8
    //   1170: aload 8
    //   1172: ldc_w 299
    //   1175: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1178: pop
    //   1179: aload 8
    //   1181: aload 4
    //   1183: getfield 281	com/tencent/image/QQLiveDrawable$QQLiveDrawableParams:mReportTag	Ljava/lang/String;
    //   1186: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1189: pop
    //   1190: aload 6
    //   1192: aload 7
    //   1194: iconst_2
    //   1195: aload 8
    //   1197: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1200: invokeinterface 166 4 0
    //   1205: aload_0
    //   1206: getfield 16	com/tencent/image/QQLiveImage$7:this$0	Lcom/tencent/image/QQLiveImage;
    //   1209: invokestatic 262	com/tencent/image/QQLiveImage:access$1200	(Lcom/tencent/image/QQLiveImage;)Lcom/tencent/qqlive/mediaplayer/api/TVK_PlayerVideoInfo;
    //   1212: aload 5
    //   1214: invokevirtual 303	com/tencent/qqlive/mediaplayer/api/TVK_PlayerVideoInfo:setReportInfoMap	(Ljava/util/Map;)V
    //   1217: aload 4
    //   1219: getfield 306	com/tencent/image/QQLiveDrawable$QQLiveDrawableParams:mServerType	Ljava/lang/String;
    //   1222: invokestatic 287	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1225: ifne +21 -> 1246
    //   1228: aload_0
    //   1229: getfield 16	com/tencent/image/QQLiveImage$7:this$0	Lcom/tencent/image/QQLiveImage;
    //   1232: invokestatic 262	com/tencent/image/QQLiveImage:access$1200	(Lcom/tencent/image/QQLiveImage;)Lcom/tencent/qqlive/mediaplayer/api/TVK_PlayerVideoInfo;
    //   1235: ldc_w 308
    //   1238: aload 4
    //   1240: getfield 306	com/tencent/image/QQLiveDrawable$QQLiveDrawableParams:mServerType	Ljava/lang/String;
    //   1243: invokevirtual 311	com/tencent/qqlive/mediaplayer/api/TVK_PlayerVideoInfo:setConfigMap	(Ljava/lang/String;Ljava/lang/String;)V
    //   1246: aload 4
    //   1248: getfield 314	com/tencent/image/QQLiveDrawable$QQLiveDrawableParams:mSavePath	Ljava/lang/String;
    //   1251: invokestatic 287	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1254: ifne +21 -> 1275
    //   1257: aload_0
    //   1258: getfield 16	com/tencent/image/QQLiveImage$7:this$0	Lcom/tencent/image/QQLiveImage;
    //   1261: invokestatic 262	com/tencent/image/QQLiveImage:access$1200	(Lcom/tencent/image/QQLiveImage;)Lcom/tencent/qqlive/mediaplayer/api/TVK_PlayerVideoInfo;
    //   1264: ldc_w 316
    //   1267: aload 4
    //   1269: getfield 314	com/tencent/image/QQLiveDrawable$QQLiveDrawableParams:mSavePath	Ljava/lang/String;
    //   1272: invokevirtual 311	com/tencent/qqlive/mediaplayer/api/TVK_PlayerVideoInfo:setConfigMap	(Ljava/lang/String;Ljava/lang/String;)V
    //   1275: aload 4
    //   1277: getfield 319	com/tencent/image/QQLiveDrawable$QQLiveDrawableParams:mDuraion	I
    //   1280: ifle +24 -> 1304
    //   1283: aload_0
    //   1284: getfield 16	com/tencent/image/QQLiveImage$7:this$0	Lcom/tencent/image/QQLiveImage;
    //   1287: invokestatic 262	com/tencent/image/QQLiveImage:access$1200	(Lcom/tencent/image/QQLiveImage;)Lcom/tencent/qqlive/mediaplayer/api/TVK_PlayerVideoInfo;
    //   1290: ldc_w 321
    //   1293: aload 4
    //   1295: getfield 319	com/tencent/image/QQLiveDrawable$QQLiveDrawableParams:mDuraion	I
    //   1298: invokestatic 326	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1301: invokevirtual 311	com/tencent/qqlive/mediaplayer/api/TVK_PlayerVideoInfo:setConfigMap	(Ljava/lang/String;Ljava/lang/String;)V
    //   1304: aload 4
    //   1306: getfield 329	com/tencent/image/QQLiveDrawable$QQLiveDrawableParams:mVid	Ljava/lang/String;
    //   1309: invokestatic 287	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1312: ifne +18 -> 1330
    //   1315: aload_0
    //   1316: getfield 16	com/tencent/image/QQLiveImage$7:this$0	Lcom/tencent/image/QQLiveImage;
    //   1319: invokestatic 262	com/tencent/image/QQLiveImage:access$1200	(Lcom/tencent/image/QQLiveImage;)Lcom/tencent/qqlive/mediaplayer/api/TVK_PlayerVideoInfo;
    //   1322: aload 4
    //   1324: getfield 329	com/tencent/image/QQLiveDrawable$QQLiveDrawableParams:mVid	Ljava/lang/String;
    //   1327: invokevirtual 332	com/tencent/qqlive/mediaplayer/api/TVK_PlayerVideoInfo:setVid	(Ljava/lang/String;)V
    //   1330: aload_0
    //   1331: getfield 16	com/tencent/image/QQLiveImage$7:this$0	Lcom/tencent/image/QQLiveImage;
    //   1334: invokestatic 262	com/tencent/image/QQLiveImage:access$1200	(Lcom/tencent/image/QQLiveImage;)Lcom/tencent/qqlive/mediaplayer/api/TVK_PlayerVideoInfo;
    //   1337: ldc_w 289
    //   1340: ldc_w 334
    //   1343: invokevirtual 337	com/tencent/qqlive/mediaplayer/api/TVK_PlayerVideoInfo:addExtraParamsMap	(Ljava/lang/String;Ljava/lang/String;)V
    //   1346: aload_0
    //   1347: monitorenter
    //   1348: aload_0
    //   1349: getfield 16	com/tencent/image/QQLiveImage$7:this$0	Lcom/tencent/image/QQLiveImage;
    //   1352: astore 5
    //   1354: aload 5
    //   1356: ifnull +484 -> 1840
    //   1359: aload_0
    //   1360: getfield 16	com/tencent/image/QQLiveImage$7:this$0	Lcom/tencent/image/QQLiveImage;
    //   1363: invokestatic 198	com/tencent/image/QQLiveImage:access$700	(Lcom/tencent/image/QQLiveImage;)Lcom/tencent/qqlive/mediaplayer/api/TVK_IMediaPlayer;
    //   1366: ifnonnull +6 -> 1372
    //   1369: goto +471 -> 1840
    //   1372: aload_0
    //   1373: getfield 16	com/tencent/image/QQLiveImage$7:this$0	Lcom/tencent/image/QQLiveImage;
    //   1376: invokestatic 198	com/tencent/image/QQLiveImage:access$700	(Lcom/tencent/image/QQLiveImage;)Lcom/tencent/qqlive/mediaplayer/api/TVK_IMediaPlayer;
    //   1379: aload 5
    //   1381: invokeinterface 343 2 0
    //   1386: aload_0
    //   1387: getfield 16	com/tencent/image/QQLiveImage$7:this$0	Lcom/tencent/image/QQLiveImage;
    //   1390: invokestatic 198	com/tencent/image/QQLiveImage:access$700	(Lcom/tencent/image/QQLiveImage;)Lcom/tencent/qqlive/mediaplayer/api/TVK_IMediaPlayer;
    //   1393: aload 5
    //   1395: invokeinterface 347 2 0
    //   1400: aload_0
    //   1401: getfield 16	com/tencent/image/QQLiveImage$7:this$0	Lcom/tencent/image/QQLiveImage;
    //   1404: invokestatic 198	com/tencent/image/QQLiveImage:access$700	(Lcom/tencent/image/QQLiveImage;)Lcom/tencent/qqlive/mediaplayer/api/TVK_IMediaPlayer;
    //   1407: aload 5
    //   1409: invokeinterface 351 2 0
    //   1414: aload_0
    //   1415: getfield 16	com/tencent/image/QQLiveImage$7:this$0	Lcom/tencent/image/QQLiveImage;
    //   1418: invokestatic 198	com/tencent/image/QQLiveImage:access$700	(Lcom/tencent/image/QQLiveImage;)Lcom/tencent/qqlive/mediaplayer/api/TVK_IMediaPlayer;
    //   1421: aload 5
    //   1423: invokeinterface 355 2 0
    //   1428: aload_0
    //   1429: getfield 16	com/tencent/image/QQLiveImage$7:this$0	Lcom/tencent/image/QQLiveImage;
    //   1432: invokestatic 198	com/tencent/image/QQLiveImage:access$700	(Lcom/tencent/image/QQLiveImage;)Lcom/tencent/qqlive/mediaplayer/api/TVK_IMediaPlayer;
    //   1435: aload 5
    //   1437: invokeinterface 359 2 0
    //   1442: aload_0
    //   1443: getfield 16	com/tencent/image/QQLiveImage$7:this$0	Lcom/tencent/image/QQLiveImage;
    //   1446: invokestatic 198	com/tencent/image/QQLiveImage:access$700	(Lcom/tencent/image/QQLiveImage;)Lcom/tencent/qqlive/mediaplayer/api/TVK_IMediaPlayer;
    //   1449: aload 5
    //   1451: invokeinterface 363 2 0
    //   1456: aload_0
    //   1457: getfield 16	com/tencent/image/QQLiveImage$7:this$0	Lcom/tencent/image/QQLiveImage;
    //   1460: invokestatic 198	com/tencent/image/QQLiveImage:access$700	(Lcom/tencent/image/QQLiveImage;)Lcom/tencent/qqlive/mediaplayer/api/TVK_IMediaPlayer;
    //   1463: aload 5
    //   1465: invokeinterface 367 2 0
    //   1470: aload_0
    //   1471: getfield 16	com/tencent/image/QQLiveImage$7:this$0	Lcom/tencent/image/QQLiveImage;
    //   1474: invokestatic 198	com/tencent/image/QQLiveImage:access$700	(Lcom/tencent/image/QQLiveImage;)Lcom/tencent/qqlive/mediaplayer/api/TVK_IMediaPlayer;
    //   1477: aload 5
    //   1479: invokeinterface 371 2 0
    //   1484: aload_0
    //   1485: getfield 16	com/tencent/image/QQLiveImage$7:this$0	Lcom/tencent/image/QQLiveImage;
    //   1488: invokestatic 198	com/tencent/image/QQLiveImage:access$700	(Lcom/tencent/image/QQLiveImage;)Lcom/tencent/qqlive/mediaplayer/api/TVK_IMediaPlayer;
    //   1491: aload 4
    //   1493: getfield 374	com/tencent/image/QQLiveDrawable$QQLiveDrawableParams:mLoopback	Z
    //   1496: invokeinterface 377 2 0
    //   1501: aload_0
    //   1502: getfield 16	com/tencent/image/QQLiveImage$7:this$0	Lcom/tencent/image/QQLiveImage;
    //   1505: invokestatic 198	com/tencent/image/QQLiveImage:access$700	(Lcom/tencent/image/QQLiveImage;)Lcom/tencent/qqlive/mediaplayer/api/TVK_IMediaPlayer;
    //   1508: aload 4
    //   1510: getfield 380	com/tencent/image/QQLiveDrawable$QQLiveDrawableParams:mMute	Z
    //   1513: invokeinterface 383 2 0
    //   1518: pop
    //   1519: aload 4
    //   1521: getfield 151	com/tencent/image/QQLiveDrawable$QQLiveDrawableParams:mDataSourceType	I
    //   1524: ifne +43 -> 1567
    //   1527: aload_0
    //   1528: getfield 16	com/tencent/image/QQLiveImage$7:this$0	Lcom/tencent/image/QQLiveImage;
    //   1531: invokestatic 198	com/tencent/image/QQLiveImage:access$700	(Lcom/tencent/image/QQLiveImage;)Lcom/tencent/qqlive/mediaplayer/api/TVK_IMediaPlayer;
    //   1534: invokestatic 387	com/tencent/image/QQLiveImage:getApplicationContext	()Landroid/content/Context;
    //   1537: aload_0
    //   1538: getfield 16	com/tencent/image/QQLiveImage$7:this$0	Lcom/tencent/image/QQLiveImage;
    //   1541: invokestatic 391	com/tencent/image/QQLiveImage:access$1100	(Lcom/tencent/image/QQLiveImage;)Lcom/tencent/qqlive/mediaplayer/api/TVK_UserInfo;
    //   1544: aload_0
    //   1545: getfield 16	com/tencent/image/QQLiveImage$7:this$0	Lcom/tencent/image/QQLiveImage;
    //   1548: invokestatic 262	com/tencent/image/QQLiveImage:access$1200	(Lcom/tencent/image/QQLiveImage;)Lcom/tencent/qqlive/mediaplayer/api/TVK_PlayerVideoInfo;
    //   1551: ldc 47
    //   1553: aload_0
    //   1554: getfield 20	com/tencent/image/QQLiveImage$7:val$startPosi	I
    //   1557: i2l
    //   1558: lconst_0
    //   1559: invokeinterface 395 9 0
    //   1564: goto +204 -> 1768
    //   1567: aload 4
    //   1569: getfield 151	com/tencent/image/QQLiveDrawable$QQLiveDrawableParams:mDataSourceType	I
    //   1572: iconst_1
    //   1573: if_icmpne +39 -> 1612
    //   1576: aload_0
    //   1577: getfield 16	com/tencent/image/QQLiveImage$7:this$0	Lcom/tencent/image/QQLiveImage;
    //   1580: invokestatic 198	com/tencent/image/QQLiveImage:access$700	(Lcom/tencent/image/QQLiveImage;)Lcom/tencent/qqlive/mediaplayer/api/TVK_IMediaPlayer;
    //   1583: invokestatic 387	com/tencent/image/QQLiveImage:getApplicationContext	()Landroid/content/Context;
    //   1586: aload 4
    //   1588: getfield 169	com/tencent/image/QQLiveDrawable$QQLiveDrawableParams:mDataSource	Ljava/lang/String;
    //   1591: aload_0
    //   1592: getfield 20	com/tencent/image/QQLiveImage$7:val$startPosi	I
    //   1595: i2l
    //   1596: lconst_0
    //   1597: aload_0
    //   1598: getfield 16	com/tencent/image/QQLiveImage$7:this$0	Lcom/tencent/image/QQLiveImage;
    //   1601: invokestatic 262	com/tencent/image/QQLiveImage:access$1200	(Lcom/tencent/image/QQLiveImage;)Lcom/tencent/qqlive/mediaplayer/api/TVK_PlayerVideoInfo;
    //   1604: invokeinterface 399 8 0
    //   1609: goto +159 -> 1768
    //   1612: aload 4
    //   1614: getfield 151	com/tencent/image/QQLiveDrawable$QQLiveDrawableParams:mDataSourceType	I
    //   1617: iconst_2
    //   1618: if_icmpne +62 -> 1680
    //   1621: aload 4
    //   1623: getfield 155	com/tencent/image/QQLiveDrawable$QQLiveDrawableParams:mDataSourceAdapter	Lcom/tencent/image/AbsThirdDataSourceAdapter;
    //   1626: ifnull +142 -> 1768
    //   1629: aload 4
    //   1631: getfield 155	com/tencent/image/QQLiveDrawable$QQLiveDrawableParams:mDataSourceAdapter	Lcom/tencent/image/AbsThirdDataSourceAdapter;
    //   1634: invokevirtual 161	com/tencent/image/AbsThirdDataSourceAdapter:getStaus	()I
    //   1637: iconst_2
    //   1638: if_icmpne +130 -> 1768
    //   1641: aload_0
    //   1642: getfield 16	com/tencent/image/QQLiveImage$7:this$0	Lcom/tencent/image/QQLiveImage;
    //   1645: invokestatic 198	com/tencent/image/QQLiveImage:access$700	(Lcom/tencent/image/QQLiveImage;)Lcom/tencent/qqlive/mediaplayer/api/TVK_IMediaPlayer;
    //   1648: invokestatic 387	com/tencent/image/QQLiveImage:getApplicationContext	()Landroid/content/Context;
    //   1651: aload 4
    //   1653: getfield 155	com/tencent/image/QQLiveDrawable$QQLiveDrawableParams:mDataSourceAdapter	Lcom/tencent/image/AbsThirdDataSourceAdapter;
    //   1656: invokevirtual 402	com/tencent/image/AbsThirdDataSourceAdapter:getURL	()Ljava/lang/String;
    //   1659: aload_0
    //   1660: getfield 20	com/tencent/image/QQLiveImage$7:val$startPosi	I
    //   1663: i2l
    //   1664: lconst_0
    //   1665: aload_0
    //   1666: getfield 16	com/tencent/image/QQLiveImage$7:this$0	Lcom/tencent/image/QQLiveImage;
    //   1669: invokestatic 262	com/tencent/image/QQLiveImage:access$1200	(Lcom/tencent/image/QQLiveImage;)Lcom/tencent/qqlive/mediaplayer/api/TVK_PlayerVideoInfo;
    //   1672: invokeinterface 399 8 0
    //   1677: goto +91 -> 1768
    //   1680: aload 4
    //   1682: getfield 151	com/tencent/image/QQLiveDrawable$QQLiveDrawableParams:mDataSourceType	I
    //   1685: iconst_3
    //   1686: if_icmpne +39 -> 1725
    //   1689: aload_0
    //   1690: getfield 16	com/tencent/image/QQLiveImage$7:this$0	Lcom/tencent/image/QQLiveImage;
    //   1693: invokestatic 198	com/tencent/image/QQLiveImage:access$700	(Lcom/tencent/image/QQLiveImage;)Lcom/tencent/qqlive/mediaplayer/api/TVK_IMediaPlayer;
    //   1696: invokestatic 387	com/tencent/image/QQLiveImage:getApplicationContext	()Landroid/content/Context;
    //   1699: aload 4
    //   1701: getfield 169	com/tencent/image/QQLiveDrawable$QQLiveDrawableParams:mDataSource	Ljava/lang/String;
    //   1704: aload_0
    //   1705: getfield 20	com/tencent/image/QQLiveImage$7:val$startPosi	I
    //   1708: i2l
    //   1709: lconst_0
    //   1710: aload_0
    //   1711: getfield 16	com/tencent/image/QQLiveImage$7:this$0	Lcom/tencent/image/QQLiveImage;
    //   1714: invokestatic 262	com/tencent/image/QQLiveImage:access$1200	(Lcom/tencent/image/QQLiveImage;)Lcom/tencent/qqlive/mediaplayer/api/TVK_PlayerVideoInfo;
    //   1717: invokeinterface 399 8 0
    //   1722: goto +46 -> 1768
    //   1725: aload 4
    //   1727: getfield 151	com/tencent/image/QQLiveDrawable$QQLiveDrawableParams:mDataSourceType	I
    //   1730: iconst_4
    //   1731: if_icmpne +37 -> 1768
    //   1734: aload_0
    //   1735: getfield 16	com/tencent/image/QQLiveImage$7:this$0	Lcom/tencent/image/QQLiveImage;
    //   1738: invokestatic 198	com/tencent/image/QQLiveImage:access$700	(Lcom/tencent/image/QQLiveImage;)Lcom/tencent/qqlive/mediaplayer/api/TVK_IMediaPlayer;
    //   1741: invokestatic 387	com/tencent/image/QQLiveImage:getApplicationContext	()Landroid/content/Context;
    //   1744: aload 4
    //   1746: getfield 406	com/tencent/image/QQLiveDrawable$QQLiveDrawableParams:mUrls	[Ljava/lang/String;
    //   1749: aload_0
    //   1750: getfield 20	com/tencent/image/QQLiveImage$7:val$startPosi	I
    //   1753: i2l
    //   1754: lconst_0
    //   1755: aload_0
    //   1756: getfield 16	com/tencent/image/QQLiveImage$7:this$0	Lcom/tencent/image/QQLiveImage;
    //   1759: invokestatic 262	com/tencent/image/QQLiveImage:access$1200	(Lcom/tencent/image/QQLiveImage;)Lcom/tencent/qqlive/mediaplayer/api/TVK_PlayerVideoInfo;
    //   1762: aconst_null
    //   1763: invokeinterface 409 9 0
    //   1768: aload_0
    //   1769: getfield 16	com/tencent/image/QQLiveImage$7:this$0	Lcom/tencent/image/QQLiveImage;
    //   1772: bipush 9
    //   1774: aconst_null
    //   1775: invokestatic 236	com/tencent/image/QQLiveImage:access$1000	(Lcom/tencent/image/QQLiveImage;ILjava/lang/Object;)V
    //   1778: getstatic 80	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   1781: getfield 86	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   1784: astore 4
    //   1786: new 93	java/lang/StringBuilder
    //   1789: dup
    //   1790: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   1793: astore 5
    //   1795: aload 5
    //   1797: getstatic 98	com/tencent/image/QQLiveImage:TAG	Ljava/lang/String;
    //   1800: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1803: pop
    //   1804: aload 5
    //   1806: aload_0
    //   1807: getfield 16	com/tencent/image/QQLiveImage$7:this$0	Lcom/tencent/image/QQLiveImage;
    //   1810: getfield 105	com/tencent/image/QQLiveImage:ID	I
    //   1813: invokevirtual 108	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1816: pop
    //   1817: aload 5
    //   1819: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1822: astore 5
    //   1824: aload 4
    //   1826: aload 5
    //   1828: iconst_1
    //   1829: ldc_w 411
    //   1832: invokeinterface 166 4 0
    //   1837: goto +210 -> 2047
    //   1840: getstatic 80	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   1843: getfield 86	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   1846: astore 4
    //   1848: new 93	java/lang/StringBuilder
    //   1851: dup
    //   1852: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   1855: astore 5
    //   1857: aload 5
    //   1859: getstatic 98	com/tencent/image/QQLiveImage:TAG	Ljava/lang/String;
    //   1862: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1865: pop
    //   1866: aload 5
    //   1868: aload_0
    //   1869: getfield 16	com/tencent/image/QQLiveImage$7:this$0	Lcom/tencent/image/QQLiveImage;
    //   1872: getfield 105	com/tencent/image/QQLiveImage:ID	I
    //   1875: invokevirtual 108	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1878: pop
    //   1879: aload 4
    //   1881: aload 5
    //   1883: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1886: iconst_1
    //   1887: ldc_w 411
    //   1890: invokeinterface 166 4 0
    //   1895: aload_0
    //   1896: monitorexit
    //   1897: return
    //   1898: astore 4
    //   1900: goto +150 -> 2050
    //   1903: astore 4
    //   1905: getstatic 80	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   1908: getfield 86	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   1911: invokeinterface 91 1 0
    //   1916: ifeq +60 -> 1976
    //   1919: getstatic 80	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   1922: getfield 86	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   1925: astore 5
    //   1927: new 93	java/lang/StringBuilder
    //   1930: dup
    //   1931: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   1934: astore 6
    //   1936: aload 6
    //   1938: getstatic 98	com/tencent/image/QQLiveImage:TAG	Ljava/lang/String;
    //   1941: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1944: pop
    //   1945: aload 6
    //   1947: aload_0
    //   1948: getfield 16	com/tencent/image/QQLiveImage$7:this$0	Lcom/tencent/image/QQLiveImage;
    //   1951: getfield 105	com/tencent/image/QQLiveImage:ID	I
    //   1954: invokevirtual 108	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1957: pop
    //   1958: aload 5
    //   1960: aload 6
    //   1962: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1965: iconst_2
    //   1966: ldc_w 413
    //   1969: aload 4
    //   1971: invokeinterface 142 5 0
    //   1976: aload_0
    //   1977: getfield 16	com/tencent/image/QQLiveImage$7:this$0	Lcom/tencent/image/QQLiveImage;
    //   1980: aload_0
    //   1981: getfield 16	com/tencent/image/QQLiveImage$7:this$0	Lcom/tencent/image/QQLiveImage;
    //   1984: invokestatic 198	com/tencent/image/QQLiveImage:access$700	(Lcom/tencent/image/QQLiveImage;)Lcom/tencent/qqlive/mediaplayer/api/TVK_IMediaPlayer;
    //   1987: iconst_0
    //   1988: iconst_0
    //   1989: iconst_0
    //   1990: ldc_w 415
    //   1993: aconst_null
    //   1994: invokevirtual 419	com/tencent/image/QQLiveImage:onError	(Lcom/tencent/qqlive/mediaplayer/api/TVK_IMediaPlayer;IIILjava/lang/String;Ljava/lang/Object;)Z
    //   1997: pop
    //   1998: getstatic 80	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   2001: getfield 86	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   2004: astore 4
    //   2006: new 93	java/lang/StringBuilder
    //   2009: dup
    //   2010: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   2013: astore 5
    //   2015: aload 5
    //   2017: getstatic 98	com/tencent/image/QQLiveImage:TAG	Ljava/lang/String;
    //   2020: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2023: pop
    //   2024: aload 5
    //   2026: aload_0
    //   2027: getfield 16	com/tencent/image/QQLiveImage$7:this$0	Lcom/tencent/image/QQLiveImage;
    //   2030: getfield 105	com/tencent/image/QQLiveImage:ID	I
    //   2033: invokevirtual 108	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2036: pop
    //   2037: aload 5
    //   2039: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2042: astore 5
    //   2044: goto -220 -> 1824
    //   2047: aload_0
    //   2048: monitorexit
    //   2049: return
    //   2050: getstatic 80	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   2053: getfield 86	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   2056: astore 5
    //   2058: new 93	java/lang/StringBuilder
    //   2061: dup
    //   2062: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   2065: astore 6
    //   2067: aload 6
    //   2069: getstatic 98	com/tencent/image/QQLiveImage:TAG	Ljava/lang/String;
    //   2072: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2075: pop
    //   2076: aload 6
    //   2078: aload_0
    //   2079: getfield 16	com/tencent/image/QQLiveImage$7:this$0	Lcom/tencent/image/QQLiveImage;
    //   2082: getfield 105	com/tencent/image/QQLiveImage:ID	I
    //   2085: invokevirtual 108	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2088: pop
    //   2089: aload 5
    //   2091: aload 6
    //   2093: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2096: iconst_1
    //   2097: ldc_w 411
    //   2100: invokeinterface 166 4 0
    //   2105: aload 4
    //   2107: athrow
    //   2108: astore 4
    //   2110: aload_0
    //   2111: monitorexit
    //   2112: aload 4
    //   2114: athrow
    //   2115: getstatic 80	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   2118: getfield 86	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   2121: invokeinterface 91 1 0
    //   2126: ifeq +58 -> 2184
    //   2129: getstatic 80	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   2132: getfield 86	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   2135: astore 4
    //   2137: new 93	java/lang/StringBuilder
    //   2140: dup
    //   2141: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   2144: astore 6
    //   2146: aload 6
    //   2148: getstatic 98	com/tencent/image/QQLiveImage:TAG	Ljava/lang/String;
    //   2151: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2154: pop
    //   2155: aload 6
    //   2157: aload_0
    //   2158: getfield 16	com/tencent/image/QQLiveImage$7:this$0	Lcom/tencent/image/QQLiveImage;
    //   2161: getfield 105	com/tencent/image/QQLiveImage:ID	I
    //   2164: invokevirtual 108	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2167: pop
    //   2168: aload 4
    //   2170: aload 6
    //   2172: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2175: iconst_2
    //   2176: ldc_w 421
    //   2179: invokeinterface 424 4 0
    //   2184: aload 5
    //   2186: monitorexit
    //   2187: return
    //   2188: astore 4
    //   2190: aload 5
    //   2192: monitorexit
    //   2193: aload 4
    //   2195: athrow
    //   2196: getstatic 80	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   2199: getfield 86	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   2202: invokeinterface 91 1 0
    //   2207: ifeq +58 -> 2265
    //   2210: getstatic 80	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   2213: getfield 86	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   2216: astore 4
    //   2218: new 93	java/lang/StringBuilder
    //   2221: dup
    //   2222: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   2225: astore 5
    //   2227: aload 5
    //   2229: getstatic 98	com/tencent/image/QQLiveImage:TAG	Ljava/lang/String;
    //   2232: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2235: pop
    //   2236: aload 5
    //   2238: aload_0
    //   2239: getfield 16	com/tencent/image/QQLiveImage$7:this$0	Lcom/tencent/image/QQLiveImage;
    //   2242: getfield 105	com/tencent/image/QQLiveImage:ID	I
    //   2245: invokevirtual 108	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2248: pop
    //   2249: aload 4
    //   2251: aload 5
    //   2253: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2256: iconst_2
    //   2257: ldc_w 426
    //   2260: invokeinterface 424 4 0
    //   2265: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2266	0	this	7
    //   311	715	1	i	int
    //   820	15	2	l	long
    //   75	67	4	localILog1	com.tencent.image.api.ILog
    //   181	66	4	localException1	java.lang.Exception
    //   261	250	4	localObject1	Object
    //   529	6	4	localObject2	Object
    //   557	1323	4	localILog2	com.tencent.image.api.ILog
    //   1898	1	4	localObject3	Object
    //   1903	67	4	localException2	java.lang.Exception
    //   2004	102	4	localILog3	com.tencent.image.api.ILog
    //   2108	5	4	localObject4	Object
    //   2135	34	4	localILog4	com.tencent.image.api.ILog
    //   2188	6	4	localObject5	Object
    //   2216	34	4	localILog5	com.tencent.image.api.ILog
    //   84	2168	5	localObject6	Object
    //   122	2049	6	localObject7	Object
    //   341	852	7	localObject8	Object
    //   379	817	8	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   165	180	181	java/lang/Exception
    //   295	411	529	finally
    //   415	441	529	finally
    //   447	450	529	finally
    //   451	454	529	finally
    //   457	525	529	finally
    //   525	528	529	finally
    //   531	534	529	finally
    //   1348	1354	1898	finally
    //   1359	1369	1898	finally
    //   1372	1564	1898	finally
    //   1567	1609	1898	finally
    //   1612	1677	1898	finally
    //   1680	1722	1898	finally
    //   1725	1768	1898	finally
    //   1768	1778	1898	finally
    //   1905	1976	1898	finally
    //   1976	1998	1898	finally
    //   1348	1354	1903	java/lang/Exception
    //   1359	1369	1903	java/lang/Exception
    //   1372	1564	1903	java/lang/Exception
    //   1567	1609	1903	java/lang/Exception
    //   1612	1677	1903	java/lang/Exception
    //   1680	1722	1903	java/lang/Exception
    //   1725	1768	1903	java/lang/Exception
    //   1768	1778	1903	java/lang/Exception
    //   1778	1824	2108	finally
    //   1824	1837	2108	finally
    //   1840	1897	2108	finally
    //   1998	2044	2108	finally
    //   2047	2049	2108	finally
    //   2050	2108	2108	finally
    //   2110	2112	2108	finally
    //   646	684	2188	finally
    //   2115	2184	2188	finally
    //   2184	2187	2188	finally
    //   2190	2193	2188	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.image.QQLiveImage.7
 * JD-Core Version:    0.7.0.1
 */