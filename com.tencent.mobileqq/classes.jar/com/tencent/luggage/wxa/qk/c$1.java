package com.tencent.luggage.wxa.qk;

class c$1
  implements Runnable
{
  c$1(c paramc) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: ldc 21
    //   2: ldc 23
    //   4: invokestatic 29	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   7: bipush 237
    //   9: invokestatic 35	android/os/Process:setThreadPriority	(I)V
    //   12: aload_0
    //   13: getfield 12	com/tencent/luggage/wxa/qk/c$1:a	Lcom/tencent/luggage/wxa/qk/c;
    //   16: invokestatic 40	com/tencent/luggage/wxa/qk/c:a	(Lcom/tencent/luggage/wxa/qk/c;)Ljava/lang/String;
    //   19: invokestatic 46	com/tencent/luggage/wxa/qz/af:c	(Ljava/lang/String;)Z
    //   22: ifeq +19 -> 41
    //   25: ldc 21
    //   27: ldc 48
    //   29: invokestatic 51	com/tencent/luggage/wxa/qz/o:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   32: aload_0
    //   33: getfield 12	com/tencent/luggage/wxa/qk/c$1:a	Lcom/tencent/luggage/wxa/qk/c;
    //   36: iconst_0
    //   37: invokevirtual 54	com/tencent/luggage/wxa/qk/c:a	(Z)V
    //   40: return
    //   41: aload_0
    //   42: getfield 12	com/tencent/luggage/wxa/qk/c$1:a	Lcom/tencent/luggage/wxa/qk/c;
    //   45: new 56	com/tencent/luggage/wxa/hh/a
    //   48: dup
    //   49: invokespecial 57	com/tencent/luggage/wxa/hh/a:<init>	()V
    //   52: invokestatic 60	com/tencent/luggage/wxa/qk/c:a	(Lcom/tencent/luggage/wxa/qk/c;Lcom/tencent/luggage/wxa/hh/a;)Lcom/tencent/luggage/wxa/hh/a;
    //   55: pop
    //   56: aload_0
    //   57: getfield 12	com/tencent/luggage/wxa/qk/c$1:a	Lcom/tencent/luggage/wxa/qk/c;
    //   60: invokestatic 63	com/tencent/luggage/wxa/qk/c:b	(Lcom/tencent/luggage/wxa/qk/c;)Lcom/tencent/luggage/wxa/hh/a;
    //   63: aload_0
    //   64: getfield 12	com/tencent/luggage/wxa/qk/c$1:a	Lcom/tencent/luggage/wxa/qk/c;
    //   67: invokestatic 40	com/tencent/luggage/wxa/qk/c:a	(Lcom/tencent/luggage/wxa/qk/c;)Ljava/lang/String;
    //   70: invokevirtual 66	com/tencent/luggage/wxa/hh/a:a	(Ljava/lang/String;)V
    //   73: aload_0
    //   74: getfield 12	com/tencent/luggage/wxa/qk/c$1:a	Lcom/tencent/luggage/wxa/qk/c;
    //   77: invokestatic 63	com/tencent/luggage/wxa/qk/c:b	(Lcom/tencent/luggage/wxa/qk/c;)Lcom/tencent/luggage/wxa/hh/a;
    //   80: invokevirtual 69	com/tencent/luggage/wxa/hh/a:b	()I
    //   83: istore_2
    //   84: ldc 21
    //   86: ldc 71
    //   88: iconst_1
    //   89: anewarray 4	java/lang/Object
    //   92: dup
    //   93: iconst_0
    //   94: iload_2
    //   95: invokestatic 77	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   98: aastore
    //   99: invokestatic 80	com/tencent/luggage/wxa/qz/o:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   102: iconst_0
    //   103: istore_1
    //   104: iload_1
    //   105: iload_2
    //   106: if_icmpge +73 -> 179
    //   109: aload_0
    //   110: getfield 12	com/tencent/luggage/wxa/qk/c$1:a	Lcom/tencent/luggage/wxa/qk/c;
    //   113: invokestatic 63	com/tencent/luggage/wxa/qk/c:b	(Lcom/tencent/luggage/wxa/qk/c;)Lcom/tencent/luggage/wxa/hh/a;
    //   116: iload_1
    //   117: invokevirtual 83	com/tencent/luggage/wxa/hh/a:a	(I)Landroid/media/MediaFormat;
    //   120: astore 10
    //   122: aload_0
    //   123: getfield 12	com/tencent/luggage/wxa/qk/c$1:a	Lcom/tencent/luggage/wxa/qk/c;
    //   126: aload 10
    //   128: ldc 85
    //   130: invokevirtual 91	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   133: invokestatic 94	com/tencent/luggage/wxa/qk/c:a	(Lcom/tencent/luggage/wxa/qk/c;Ljava/lang/String;)Ljava/lang/String;
    //   136: pop
    //   137: aload_0
    //   138: getfield 12	com/tencent/luggage/wxa/qk/c$1:a	Lcom/tencent/luggage/wxa/qk/c;
    //   141: invokestatic 96	com/tencent/luggage/wxa/qk/c:c	(Lcom/tencent/luggage/wxa/qk/c;)Ljava/lang/String;
    //   144: invokestatic 46	com/tencent/luggage/wxa/qz/af:c	(Ljava/lang/String;)Z
    //   147: ifne +25 -> 172
    //   150: aload_0
    //   151: getfield 12	com/tencent/luggage/wxa/qk/c$1:a	Lcom/tencent/luggage/wxa/qk/c;
    //   154: invokestatic 96	com/tencent/luggage/wxa/qk/c:c	(Lcom/tencent/luggage/wxa/qk/c;)Ljava/lang/String;
    //   157: ldc 98
    //   159: invokevirtual 103	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   162: istore 7
    //   164: iload 7
    //   166: ifeq +6 -> 172
    //   169: goto +13 -> 182
    //   172: iload_1
    //   173: iconst_1
    //   174: iadd
    //   175: istore_1
    //   176: goto -72 -> 104
    //   179: aconst_null
    //   180: astore 10
    //   182: aload 10
    //   184: ifnonnull +37 -> 221
    //   187: ldc 21
    //   189: ldc 105
    //   191: invokestatic 51	com/tencent/luggage/wxa/qz/o:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   194: aload_0
    //   195: getfield 12	com/tencent/luggage/wxa/qk/c$1:a	Lcom/tencent/luggage/wxa/qk/c;
    //   198: sipush 703
    //   201: invokestatic 108	com/tencent/luggage/wxa/qk/c:a	(Lcom/tencent/luggage/wxa/qk/c;I)I
    //   204: pop
    //   205: aload_0
    //   206: getfield 12	com/tencent/luggage/wxa/qk/c$1:a	Lcom/tencent/luggage/wxa/qk/c;
    //   209: iconst_1
    //   210: invokevirtual 54	com/tencent/luggage/wxa/qk/c:a	(Z)V
    //   213: aload_0
    //   214: getfield 12	com/tencent/luggage/wxa/qk/c$1:a	Lcom/tencent/luggage/wxa/qk/c;
    //   217: invokestatic 110	com/tencent/luggage/wxa/qk/c:d	(Lcom/tencent/luggage/wxa/qk/c;)V
    //   220: return
    //   221: ldc 21
    //   223: ldc 112
    //   225: iconst_1
    //   226: anewarray 4	java/lang/Object
    //   229: dup
    //   230: iconst_0
    //   231: aload 10
    //   233: aastore
    //   234: invokestatic 114	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   237: aload_0
    //   238: getfield 12	com/tencent/luggage/wxa/qk/c$1:a	Lcom/tencent/luggage/wxa/qk/c;
    //   241: aload 10
    //   243: ldc 116
    //   245: invokevirtual 120	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   248: invokestatic 122	com/tencent/luggage/wxa/qk/c:b	(Lcom/tencent/luggage/wxa/qk/c;I)I
    //   251: pop
    //   252: aload_0
    //   253: getfield 12	com/tencent/luggage/wxa/qk/c$1:a	Lcom/tencent/luggage/wxa/qk/c;
    //   256: aload 10
    //   258: ldc 124
    //   260: invokevirtual 120	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   263: invokestatic 126	com/tencent/luggage/wxa/qk/c:c	(Lcom/tencent/luggage/wxa/qk/c;I)I
    //   266: pop
    //   267: aload_0
    //   268: getfield 12	com/tencent/luggage/wxa/qk/c$1:a	Lcom/tencent/luggage/wxa/qk/c;
    //   271: aload 10
    //   273: ldc 128
    //   275: invokevirtual 132	android/media/MediaFormat:getLong	(Ljava/lang/String;)J
    //   278: invokestatic 135	com/tencent/luggage/wxa/qk/c:a	(Lcom/tencent/luggage/wxa/qk/c;J)J
    //   281: pop2
    //   282: goto +37 -> 319
    //   285: astore 11
    //   287: goto +8 -> 295
    //   290: astore 11
    //   292: aconst_null
    //   293: astore 10
    //   295: ldc 21
    //   297: aload 11
    //   299: ldc 137
    //   301: iconst_0
    //   302: anewarray 4	java/lang/Object
    //   305: invokestatic 140	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   308: aload_0
    //   309: getfield 12	com/tencent/luggage/wxa/qk/c$1:a	Lcom/tencent/luggage/wxa/qk/c;
    //   312: sipush 705
    //   315: invokestatic 108	com/tencent/luggage/wxa/qk/c:a	(Lcom/tencent/luggage/wxa/qk/c;I)I
    //   318: pop
    //   319: aload_0
    //   320: getfield 12	com/tencent/luggage/wxa/qk/c$1:a	Lcom/tencent/luggage/wxa/qk/c;
    //   323: aload_0
    //   324: getfield 12	com/tencent/luggage/wxa/qk/c$1:a	Lcom/tencent/luggage/wxa/qk/c;
    //   327: invokestatic 96	com/tencent/luggage/wxa/qk/c:c	(Lcom/tencent/luggage/wxa/qk/c;)Ljava/lang/String;
    //   330: invokestatic 145	com/tencent/luggage/wxa/hd/e:a	(Ljava/lang/String;)Lcom/tencent/luggage/wxa/hd/e;
    //   333: invokestatic 148	com/tencent/luggage/wxa/qk/c:a	(Lcom/tencent/luggage/wxa/qk/c;Lcom/tencent/luggage/wxa/hd/e;)Lcom/tencent/luggage/wxa/hd/e;
    //   336: pop
    //   337: aload_0
    //   338: getfield 12	com/tencent/luggage/wxa/qk/c$1:a	Lcom/tencent/luggage/wxa/qk/c;
    //   341: invokestatic 152	com/tencent/luggage/wxa/qk/c:e	(Lcom/tencent/luggage/wxa/qk/c;)Lcom/tencent/luggage/wxa/hd/e;
    //   344: aload 10
    //   346: aconst_null
    //   347: aconst_null
    //   348: iconst_0
    //   349: invokevirtual 155	com/tencent/luggage/wxa/hd/e:a	(Landroid/media/MediaFormat;Landroid/view/Surface;Landroid/media/MediaCrypto;I)V
    //   352: aload_0
    //   353: getfield 12	com/tencent/luggage/wxa/qk/c$1:a	Lcom/tencent/luggage/wxa/qk/c;
    //   356: invokestatic 152	com/tencent/luggage/wxa/qk/c:e	(Lcom/tencent/luggage/wxa/qk/c;)Lcom/tencent/luggage/wxa/hd/e;
    //   359: invokevirtual 157	com/tencent/luggage/wxa/hd/e:b	()V
    //   362: aload_0
    //   363: getfield 12	com/tencent/luggage/wxa/qk/c$1:a	Lcom/tencent/luggage/wxa/qk/c;
    //   366: invokestatic 152	com/tencent/luggage/wxa/qk/c:e	(Lcom/tencent/luggage/wxa/qk/c;)Lcom/tencent/luggage/wxa/hd/e;
    //   369: invokevirtual 160	com/tencent/luggage/wxa/hd/e:e	()[Ljava/nio/ByteBuffer;
    //   372: astore 12
    //   374: aload_0
    //   375: getfield 12	com/tencent/luggage/wxa/qk/c$1:a	Lcom/tencent/luggage/wxa/qk/c;
    //   378: invokestatic 152	com/tencent/luggage/wxa/qk/c:e	(Lcom/tencent/luggage/wxa/qk/c;)Lcom/tencent/luggage/wxa/hd/e;
    //   381: invokevirtual 163	com/tencent/luggage/wxa/hd/e:f	()[Ljava/nio/ByteBuffer;
    //   384: astore 11
    //   386: ldc 21
    //   388: ldc 165
    //   390: iconst_5
    //   391: anewarray 4	java/lang/Object
    //   394: dup
    //   395: iconst_0
    //   396: aload 10
    //   398: aastore
    //   399: dup
    //   400: iconst_1
    //   401: aload_0
    //   402: getfield 12	com/tencent/luggage/wxa/qk/c$1:a	Lcom/tencent/luggage/wxa/qk/c;
    //   405: invokestatic 96	com/tencent/luggage/wxa/qk/c:c	(Lcom/tencent/luggage/wxa/qk/c;)Ljava/lang/String;
    //   408: aastore
    //   409: dup
    //   410: iconst_2
    //   411: aload_0
    //   412: getfield 12	com/tencent/luggage/wxa/qk/c$1:a	Lcom/tencent/luggage/wxa/qk/c;
    //   415: invokestatic 169	com/tencent/luggage/wxa/qk/c:g	(Lcom/tencent/luggage/wxa/qk/c;)I
    //   418: invokestatic 77	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   421: aastore
    //   422: dup
    //   423: iconst_3
    //   424: aload_0
    //   425: getfield 12	com/tencent/luggage/wxa/qk/c$1:a	Lcom/tencent/luggage/wxa/qk/c;
    //   428: invokestatic 172	com/tencent/luggage/wxa/qk/c:h	(Lcom/tencent/luggage/wxa/qk/c;)I
    //   431: invokestatic 77	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   434: aastore
    //   435: dup
    //   436: iconst_4
    //   437: aload_0
    //   438: getfield 12	com/tencent/luggage/wxa/qk/c$1:a	Lcom/tencent/luggage/wxa/qk/c;
    //   441: invokestatic 176	com/tencent/luggage/wxa/qk/c:i	(Lcom/tencent/luggage/wxa/qk/c;)J
    //   444: invokestatic 181	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   447: aastore
    //   448: invokestatic 114	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   451: aload_0
    //   452: getfield 12	com/tencent/luggage/wxa/qk/c$1:a	Lcom/tencent/luggage/wxa/qk/c;
    //   455: invokestatic 63	com/tencent/luggage/wxa/qk/c:b	(Lcom/tencent/luggage/wxa/qk/c;)Lcom/tencent/luggage/wxa/hh/a;
    //   458: iconst_0
    //   459: invokevirtual 183	com/tencent/luggage/wxa/hh/a:b	(I)V
    //   462: new 185	android/media/MediaCodec$BufferInfo
    //   465: dup
    //   466: invokespecial 186	android/media/MediaCodec$BufferInfo:<init>	()V
    //   469: astore 13
    //   471: aload_0
    //   472: getfield 12	com/tencent/luggage/wxa/qk/c$1:a	Lcom/tencent/luggage/wxa/qk/c;
    //   475: invokestatic 190	com/tencent/luggage/wxa/qk/c:j	(Lcom/tencent/luggage/wxa/qk/c;)Lcom/tencent/luggage/wxa/ql/g;
    //   478: iconst_3
    //   479: invokevirtual 194	com/tencent/luggage/wxa/ql/g:a	(I)V
    //   482: aload_0
    //   483: getfield 12	com/tencent/luggage/wxa/qk/c$1:a	Lcom/tencent/luggage/wxa/qk/c;
    //   486: invokestatic 197	com/tencent/luggage/wxa/qk/c:k	(Lcom/tencent/luggage/wxa/qk/c;)V
    //   489: aload 11
    //   491: astore 10
    //   493: iconst_0
    //   494: istore_3
    //   495: iconst_0
    //   496: istore_2
    //   497: iconst_0
    //   498: istore_1
    //   499: iload_3
    //   500: ifne +716 -> 1216
    //   503: iload_2
    //   504: bipush 50
    //   506: if_icmpge +710 -> 1216
    //   509: aload_0
    //   510: getfield 12	com/tencent/luggage/wxa/qk/c$1:a	Lcom/tencent/luggage/wxa/qk/c;
    //   513: invokevirtual 199	com/tencent/luggage/wxa/qk/c:j	()V
    //   516: aload_0
    //   517: getfield 12	com/tencent/luggage/wxa/qk/c$1:a	Lcom/tencent/luggage/wxa/qk/c;
    //   520: invokevirtual 202	com/tencent/luggage/wxa/qk/c:b	()Z
    //   523: ifne +6 -> 529
    //   526: goto +690 -> 1216
    //   529: iload_2
    //   530: iconst_1
    //   531: iadd
    //   532: istore 4
    //   534: iload_1
    //   535: ifne +1089 -> 1624
    //   538: aload_0
    //   539: getfield 12	com/tencent/luggage/wxa/qk/c$1:a	Lcom/tencent/luggage/wxa/qk/c;
    //   542: invokestatic 152	com/tencent/luggage/wxa/qk/c:e	(Lcom/tencent/luggage/wxa/qk/c;)Lcom/tencent/luggage/wxa/hd/e;
    //   545: astore 11
    //   547: aload 11
    //   549: ldc2_w 203
    //   552: invokevirtual 207	com/tencent/luggage/wxa/hd/e:a	(J)I
    //   555: istore 6
    //   557: iload 6
    //   559: iflt +173 -> 732
    //   562: aload 12
    //   564: iload 6
    //   566: aaload
    //   567: astore 11
    //   569: aload_0
    //   570: getfield 12	com/tencent/luggage/wxa/qk/c$1:a	Lcom/tencent/luggage/wxa/qk/c;
    //   573: invokestatic 63	com/tencent/luggage/wxa/qk/c:b	(Lcom/tencent/luggage/wxa/qk/c;)Lcom/tencent/luggage/wxa/hh/a;
    //   576: aload 11
    //   578: iconst_0
    //   579: invokevirtual 210	com/tencent/luggage/wxa/hh/a:a	(Ljava/nio/ByteBuffer;I)I
    //   582: istore 5
    //   584: iload 5
    //   586: ifge +18 -> 604
    //   589: ldc 21
    //   591: ldc 212
    //   593: invokestatic 51	com/tencent/luggage/wxa/qz/o:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   596: iconst_1
    //   597: istore_2
    //   598: iconst_0
    //   599: istore 5
    //   601: goto +69 -> 670
    //   604: aload_0
    //   605: getfield 12	com/tencent/luggage/wxa/qk/c$1:a	Lcom/tencent/luggage/wxa/qk/c;
    //   608: aload_0
    //   609: getfield 12	com/tencent/luggage/wxa/qk/c$1:a	Lcom/tencent/luggage/wxa/qk/c;
    //   612: invokestatic 63	com/tencent/luggage/wxa/qk/c:b	(Lcom/tencent/luggage/wxa/qk/c;)Lcom/tencent/luggage/wxa/hh/a;
    //   615: invokevirtual 215	com/tencent/luggage/wxa/hh/a:d	()J
    //   618: invokestatic 217	com/tencent/luggage/wxa/qk/c:b	(Lcom/tencent/luggage/wxa/qk/c;J)J
    //   621: pop2
    //   622: aload_0
    //   623: getfield 12	com/tencent/luggage/wxa/qk/c$1:a	Lcom/tencent/luggage/wxa/qk/c;
    //   626: invokestatic 176	com/tencent/luggage/wxa/qk/c:i	(Lcom/tencent/luggage/wxa/qk/c;)J
    //   629: lconst_0
    //   630: lcmp
    //   631: ifne +8 -> 639
    //   634: iconst_0
    //   635: istore_2
    //   636: goto +24 -> 660
    //   639: aload_0
    //   640: getfield 12	com/tencent/luggage/wxa/qk/c$1:a	Lcom/tencent/luggage/wxa/qk/c;
    //   643: invokestatic 220	com/tencent/luggage/wxa/qk/c:l	(Lcom/tencent/luggage/wxa/qk/c;)J
    //   646: ldc2_w 221
    //   649: lmul
    //   650: aload_0
    //   651: getfield 12	com/tencent/luggage/wxa/qk/c$1:a	Lcom/tencent/luggage/wxa/qk/c;
    //   654: invokestatic 176	com/tencent/luggage/wxa/qk/c:i	(Lcom/tencent/luggage/wxa/qk/c;)J
    //   657: ldiv
    //   658: l2i
    //   659: istore_2
    //   660: aload_0
    //   661: getfield 12	com/tencent/luggage/wxa/qk/c$1:a	Lcom/tencent/luggage/wxa/qk/c;
    //   664: iload_2
    //   665: invokestatic 225	com/tencent/luggage/wxa/qk/c:d	(Lcom/tencent/luggage/wxa/qk/c;I)V
    //   668: iload_1
    //   669: istore_2
    //   670: aload_0
    //   671: getfield 12	com/tencent/luggage/wxa/qk/c$1:a	Lcom/tencent/luggage/wxa/qk/c;
    //   674: invokestatic 152	com/tencent/luggage/wxa/qk/c:e	(Lcom/tencent/luggage/wxa/qk/c;)Lcom/tencent/luggage/wxa/hd/e;
    //   677: astore 11
    //   679: aload_0
    //   680: getfield 12	com/tencent/luggage/wxa/qk/c$1:a	Lcom/tencent/luggage/wxa/qk/c;
    //   683: invokestatic 220	com/tencent/luggage/wxa/qk/c:l	(Lcom/tencent/luggage/wxa/qk/c;)J
    //   686: lstore 8
    //   688: iload_2
    //   689: ifeq +930 -> 1619
    //   692: iconst_4
    //   693: istore_1
    //   694: goto +3 -> 697
    //   697: aload 11
    //   699: iload 6
    //   701: iconst_0
    //   702: iload 5
    //   704: lload 8
    //   706: iload_1
    //   707: invokevirtual 228	com/tencent/luggage/wxa/hd/e:a	(IIIJI)V
    //   710: iload_2
    //   711: istore_1
    //   712: iload_2
    //   713: ifne +57 -> 770
    //   716: aload_0
    //   717: getfield 12	com/tencent/luggage/wxa/qk/c$1:a	Lcom/tencent/luggage/wxa/qk/c;
    //   720: invokestatic 63	com/tencent/luggage/wxa/qk/c:b	(Lcom/tencent/luggage/wxa/qk/c;)Lcom/tencent/luggage/wxa/hh/a;
    //   723: invokevirtual 230	com/tencent/luggage/wxa/hh/a:c	()Z
    //   726: pop
    //   727: iload_2
    //   728: istore_1
    //   729: goto +41 -> 770
    //   732: new 232	java/lang/StringBuilder
    //   735: dup
    //   736: invokespecial 233	java/lang/StringBuilder:<init>	()V
    //   739: astore 11
    //   741: aload 11
    //   743: ldc 235
    //   745: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   748: pop
    //   749: aload 11
    //   751: iload 6
    //   753: invokevirtual 242	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   756: pop
    //   757: ldc 21
    //   759: aload 11
    //   761: invokevirtual 246	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   764: invokestatic 51	com/tencent/luggage/wxa/qz/o:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   767: goto +3 -> 770
    //   770: iload_1
    //   771: istore 5
    //   773: aload_0
    //   774: getfield 12	com/tencent/luggage/wxa/qk/c$1:a	Lcom/tencent/luggage/wxa/qk/c;
    //   777: invokestatic 152	com/tencent/luggage/wxa/qk/c:e	(Lcom/tencent/luggage/wxa/qk/c;)Lcom/tencent/luggage/wxa/hd/e;
    //   780: aload 13
    //   782: ldc2_w 203
    //   785: invokevirtual 249	com/tencent/luggage/wxa/hd/e:a	(Landroid/media/MediaCodec$BufferInfo;J)I
    //   788: istore_2
    //   789: iload_2
    //   790: iflt +248 -> 1038
    //   793: iload 4
    //   795: istore_1
    //   796: aload 13
    //   798: getfield 253	android/media/MediaCodec$BufferInfo:size	I
    //   801: ifle +5 -> 806
    //   804: iconst_0
    //   805: istore_1
    //   806: aload 10
    //   808: iload_2
    //   809: aaload
    //   810: astore 11
    //   812: aload 13
    //   814: getfield 253	android/media/MediaCodec$BufferInfo:size	I
    //   817: newarray byte
    //   819: astore 14
    //   821: aload 11
    //   823: aload 14
    //   825: invokevirtual 259	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   828: pop
    //   829: aload 11
    //   831: invokevirtual 263	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   834: pop
    //   835: aload 14
    //   837: arraylength
    //   838: ifle +153 -> 991
    //   841: aload_0
    //   842: getfield 12	com/tencent/luggage/wxa/qk/c$1:a	Lcom/tencent/luggage/wxa/qk/c;
    //   845: invokestatic 267	com/tencent/luggage/wxa/qk/c:m	(Lcom/tencent/luggage/wxa/qk/c;)Landroid/media/AudioTrack;
    //   848: ifnonnull +126 -> 974
    //   851: aload_0
    //   852: getfield 12	com/tencent/luggage/wxa/qk/c$1:a	Lcom/tencent/luggage/wxa/qk/c;
    //   855: invokestatic 271	com/tencent/luggage/wxa/qk/c:n	(Lcom/tencent/luggage/wxa/qk/c;)Z
    //   858: ifne +106 -> 964
    //   861: ldc 21
    //   863: ldc_w 273
    //   866: invokestatic 51	com/tencent/luggage/wxa/qz/o:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   869: aload_0
    //   870: getfield 12	com/tencent/luggage/wxa/qk/c$1:a	Lcom/tencent/luggage/wxa/qk/c;
    //   873: sipush 707
    //   876: invokestatic 108	com/tencent/luggage/wxa/qk/c:a	(Lcom/tencent/luggage/wxa/qk/c;I)I
    //   879: pop
    //   880: aload_0
    //   881: getfield 12	com/tencent/luggage/wxa/qk/c$1:a	Lcom/tencent/luggage/wxa/qk/c;
    //   884: iconst_1
    //   885: invokevirtual 54	com/tencent/luggage/wxa/qk/c:a	(Z)V
    //   888: aload_0
    //   889: getfield 12	com/tencent/luggage/wxa/qk/c$1:a	Lcom/tencent/luggage/wxa/qk/c;
    //   892: invokestatic 110	com/tencent/luggage/wxa/qk/c:d	(Lcom/tencent/luggage/wxa/qk/c;)V
    //   895: aload_0
    //   896: getfield 12	com/tencent/luggage/wxa/qk/c$1:a	Lcom/tencent/luggage/wxa/qk/c;
    //   899: invokestatic 275	com/tencent/luggage/wxa/qk/c:f	(Lcom/tencent/luggage/wxa/qk/c;)V
    //   902: aload_0
    //   903: getfield 12	com/tencent/luggage/wxa/qk/c$1:a	Lcom/tencent/luggage/wxa/qk/c;
    //   906: invokestatic 278	com/tencent/luggage/wxa/qk/c:o	(Lcom/tencent/luggage/wxa/qk/c;)V
    //   909: aload_0
    //   910: getfield 12	com/tencent/luggage/wxa/qk/c$1:a	Lcom/tencent/luggage/wxa/qk/c;
    //   913: aconst_null
    //   914: invokestatic 280	com/tencent/luggage/wxa/qk/c:b	(Lcom/tencent/luggage/wxa/qk/c;Ljava/lang/String;)Ljava/lang/String;
    //   917: pop
    //   918: aload_0
    //   919: getfield 12	com/tencent/luggage/wxa/qk/c$1:a	Lcom/tencent/luggage/wxa/qk/c;
    //   922: aconst_null
    //   923: invokestatic 94	com/tencent/luggage/wxa/qk/c:a	(Lcom/tencent/luggage/wxa/qk/c;Ljava/lang/String;)Ljava/lang/String;
    //   926: pop
    //   927: aload_0
    //   928: getfield 12	com/tencent/luggage/wxa/qk/c$1:a	Lcom/tencent/luggage/wxa/qk/c;
    //   931: iconst_0
    //   932: invokestatic 122	com/tencent/luggage/wxa/qk/c:b	(Lcom/tencent/luggage/wxa/qk/c;I)I
    //   935: pop
    //   936: aload_0
    //   937: getfield 12	com/tencent/luggage/wxa/qk/c$1:a	Lcom/tencent/luggage/wxa/qk/c;
    //   940: iconst_0
    //   941: invokestatic 126	com/tencent/luggage/wxa/qk/c:c	(Lcom/tencent/luggage/wxa/qk/c;I)I
    //   944: pop
    //   945: aload_0
    //   946: getfield 12	com/tencent/luggage/wxa/qk/c$1:a	Lcom/tencent/luggage/wxa/qk/c;
    //   949: lconst_0
    //   950: invokestatic 217	com/tencent/luggage/wxa/qk/c:b	(Lcom/tencent/luggage/wxa/qk/c;J)J
    //   953: pop2
    //   954: aload_0
    //   955: getfield 12	com/tencent/luggage/wxa/qk/c$1:a	Lcom/tencent/luggage/wxa/qk/c;
    //   958: lconst_0
    //   959: invokestatic 135	com/tencent/luggage/wxa/qk/c:a	(Lcom/tencent/luggage/wxa/qk/c;J)J
    //   962: pop2
    //   963: return
    //   964: aload_0
    //   965: getfield 12	com/tencent/luggage/wxa/qk/c$1:a	Lcom/tencent/luggage/wxa/qk/c;
    //   968: invokestatic 267	com/tencent/luggage/wxa/qk/c:m	(Lcom/tencent/luggage/wxa/qk/c;)Landroid/media/AudioTrack;
    //   971: invokevirtual 285	android/media/AudioTrack:play	()V
    //   974: aload_0
    //   975: getfield 12	com/tencent/luggage/wxa/qk/c$1:a	Lcom/tencent/luggage/wxa/qk/c;
    //   978: invokestatic 267	com/tencent/luggage/wxa/qk/c:m	(Lcom/tencent/luggage/wxa/qk/c;)Landroid/media/AudioTrack;
    //   981: aload 14
    //   983: iconst_0
    //   984: aload 14
    //   986: arraylength
    //   987: invokevirtual 289	android/media/AudioTrack:write	([BII)I
    //   990: pop
    //   991: aload_0
    //   992: getfield 12	com/tencent/luggage/wxa/qk/c$1:a	Lcom/tencent/luggage/wxa/qk/c;
    //   995: invokestatic 152	com/tencent/luggage/wxa/qk/c:e	(Lcom/tencent/luggage/wxa/qk/c;)Lcom/tencent/luggage/wxa/hd/e;
    //   998: iload_2
    //   999: iconst_0
    //   1000: invokevirtual 292	com/tencent/luggage/wxa/hd/e:a	(IZ)V
    //   1003: iload_1
    //   1004: istore_2
    //   1005: aload 10
    //   1007: astore 11
    //   1009: aload 13
    //   1011: getfield 295	android/media/MediaCodec$BufferInfo:flags	I
    //   1014: iconst_4
    //   1015: iand
    //   1016: ifeq +611 -> 1627
    //   1019: ldc 21
    //   1021: ldc_w 297
    //   1024: invokestatic 51	com/tencent/luggage/wxa/qz/o:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   1027: iconst_1
    //   1028: istore_3
    //   1029: iload_1
    //   1030: istore_2
    //   1031: aload 10
    //   1033: astore 11
    //   1035: goto +592 -> 1627
    //   1038: iload_2
    //   1039: bipush 253
    //   1041: if_icmpne +29 -> 1070
    //   1044: aload_0
    //   1045: getfield 12	com/tencent/luggage/wxa/qk/c$1:a	Lcom/tencent/luggage/wxa/qk/c;
    //   1048: invokestatic 152	com/tencent/luggage/wxa/qk/c:e	(Lcom/tencent/luggage/wxa/qk/c;)Lcom/tencent/luggage/wxa/hd/e;
    //   1051: invokevirtual 163	com/tencent/luggage/wxa/hd/e:f	()[Ljava/nio/ByteBuffer;
    //   1054: astore 11
    //   1056: ldc 21
    //   1058: ldc_w 299
    //   1061: invokestatic 29	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1064: iload 4
    //   1066: istore_2
    //   1067: goto +560 -> 1627
    //   1070: iload_2
    //   1071: bipush 254
    //   1073: if_icmpne +98 -> 1171
    //   1076: aload_0
    //   1077: getfield 12	com/tencent/luggage/wxa/qk/c$1:a	Lcom/tencent/luggage/wxa/qk/c;
    //   1080: invokestatic 152	com/tencent/luggage/wxa/qk/c:e	(Lcom/tencent/luggage/wxa/qk/c;)Lcom/tencent/luggage/wxa/hd/e;
    //   1083: invokevirtual 302	com/tencent/luggage/wxa/hd/e:d	()Landroid/media/MediaFormat;
    //   1086: astore 11
    //   1088: new 232	java/lang/StringBuilder
    //   1091: dup
    //   1092: invokespecial 233	java/lang/StringBuilder:<init>	()V
    //   1095: astore 14
    //   1097: aload 14
    //   1099: ldc_w 304
    //   1102: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1105: pop
    //   1106: aload 14
    //   1108: aload 11
    //   1110: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1113: pop
    //   1114: ldc 21
    //   1116: aload 14
    //   1118: invokevirtual 246	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1121: invokestatic 29	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1124: aload_0
    //   1125: getfield 12	com/tencent/luggage/wxa/qk/c$1:a	Lcom/tencent/luggage/wxa/qk/c;
    //   1128: aload 11
    //   1130: ldc 116
    //   1132: invokevirtual 120	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   1135: invokestatic 122	com/tencent/luggage/wxa/qk/c:b	(Lcom/tencent/luggage/wxa/qk/c;I)I
    //   1138: pop
    //   1139: aload_0
    //   1140: getfield 12	com/tencent/luggage/wxa/qk/c$1:a	Lcom/tencent/luggage/wxa/qk/c;
    //   1143: aload 11
    //   1145: ldc 124
    //   1147: invokevirtual 120	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   1150: invokestatic 126	com/tencent/luggage/wxa/qk/c:c	(Lcom/tencent/luggage/wxa/qk/c;I)I
    //   1153: pop
    //   1154: aload_0
    //   1155: getfield 12	com/tencent/luggage/wxa/qk/c$1:a	Lcom/tencent/luggage/wxa/qk/c;
    //   1158: invokestatic 278	com/tencent/luggage/wxa/qk/c:o	(Lcom/tencent/luggage/wxa/qk/c;)V
    //   1161: iload 4
    //   1163: istore_2
    //   1164: aload 10
    //   1166: astore 11
    //   1168: goto +459 -> 1627
    //   1171: new 232	java/lang/StringBuilder
    //   1174: dup
    //   1175: invokespecial 233	java/lang/StringBuilder:<init>	()V
    //   1178: astore 11
    //   1180: aload 11
    //   1182: ldc_w 309
    //   1185: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1188: pop
    //   1189: aload 11
    //   1191: iload_2
    //   1192: invokevirtual 242	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1195: pop
    //   1196: ldc 21
    //   1198: aload 11
    //   1200: invokevirtual 246	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1203: invokestatic 29	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1206: iload 4
    //   1208: istore_2
    //   1209: aload 10
    //   1211: astore 11
    //   1213: goto +414 -> 1627
    //   1216: aload_0
    //   1217: getfield 12	com/tencent/luggage/wxa/qk/c$1:a	Lcom/tencent/luggage/wxa/qk/c;
    //   1220: invokestatic 176	com/tencent/luggage/wxa/qk/c:i	(Lcom/tencent/luggage/wxa/qk/c;)J
    //   1223: ldc2_w 203
    //   1226: ldiv
    //   1227: aload_0
    //   1228: getfield 12	com/tencent/luggage/wxa/qk/c$1:a	Lcom/tencent/luggage/wxa/qk/c;
    //   1231: invokestatic 220	com/tencent/luggage/wxa/qk/c:l	(Lcom/tencent/luggage/wxa/qk/c;)J
    //   1234: ldc2_w 203
    //   1237: ldiv
    //   1238: lsub
    //   1239: ldc2_w 310
    //   1242: lcmp
    //   1243: ifge +394 -> 1637
    //   1246: iconst_1
    //   1247: istore 7
    //   1249: goto +3 -> 1252
    //   1252: iload_2
    //   1253: bipush 50
    //   1255: if_icmplt +44 -> 1299
    //   1258: ldc 21
    //   1260: ldc_w 313
    //   1263: iconst_1
    //   1264: anewarray 4	java/lang/Object
    //   1267: dup
    //   1268: iconst_0
    //   1269: iload_2
    //   1270: invokestatic 77	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1273: aastore
    //   1274: invokestatic 80	com/tencent/luggage/wxa/qz/o:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1277: aload_0
    //   1278: getfield 12	com/tencent/luggage/wxa/qk/c$1:a	Lcom/tencent/luggage/wxa/qk/c;
    //   1281: sipush 706
    //   1284: invokestatic 108	com/tencent/luggage/wxa/qk/c:a	(Lcom/tencent/luggage/wxa/qk/c;I)I
    //   1287: pop
    //   1288: aload_0
    //   1289: getfield 12	com/tencent/luggage/wxa/qk/c$1:a	Lcom/tencent/luggage/wxa/qk/c;
    //   1292: iconst_1
    //   1293: invokevirtual 54	com/tencent/luggage/wxa/qk/c:a	(Z)V
    //   1296: goto +75 -> 1371
    //   1299: ldc 21
    //   1301: ldc_w 315
    //   1304: iconst_1
    //   1305: anewarray 4	java/lang/Object
    //   1308: dup
    //   1309: iconst_0
    //   1310: iload 7
    //   1312: invokestatic 320	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1315: aastore
    //   1316: invokestatic 114	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1319: aload_0
    //   1320: getfield 12	com/tencent/luggage/wxa/qk/c$1:a	Lcom/tencent/luggage/wxa/qk/c;
    //   1323: iload 7
    //   1325: invokevirtual 322	com/tencent/luggage/wxa/qk/c:b	(Z)V
    //   1328: goto +43 -> 1371
    //   1331: astore 10
    //   1333: goto +122 -> 1455
    //   1336: astore 10
    //   1338: ldc 21
    //   1340: aload 10
    //   1342: ldc_w 324
    //   1345: iconst_0
    //   1346: anewarray 4	java/lang/Object
    //   1349: invokestatic 140	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1352: aload_0
    //   1353: getfield 12	com/tencent/luggage/wxa/qk/c$1:a	Lcom/tencent/luggage/wxa/qk/c;
    //   1356: sipush 706
    //   1359: invokestatic 108	com/tencent/luggage/wxa/qk/c:a	(Lcom/tencent/luggage/wxa/qk/c;I)I
    //   1362: pop
    //   1363: aload_0
    //   1364: getfield 12	com/tencent/luggage/wxa/qk/c$1:a	Lcom/tencent/luggage/wxa/qk/c;
    //   1367: iconst_1
    //   1368: invokevirtual 54	com/tencent/luggage/wxa/qk/c:a	(Z)V
    //   1371: aload_0
    //   1372: getfield 12	com/tencent/luggage/wxa/qk/c$1:a	Lcom/tencent/luggage/wxa/qk/c;
    //   1375: invokestatic 110	com/tencent/luggage/wxa/qk/c:d	(Lcom/tencent/luggage/wxa/qk/c;)V
    //   1378: aload_0
    //   1379: getfield 12	com/tencent/luggage/wxa/qk/c$1:a	Lcom/tencent/luggage/wxa/qk/c;
    //   1382: invokestatic 275	com/tencent/luggage/wxa/qk/c:f	(Lcom/tencent/luggage/wxa/qk/c;)V
    //   1385: aload_0
    //   1386: getfield 12	com/tencent/luggage/wxa/qk/c$1:a	Lcom/tencent/luggage/wxa/qk/c;
    //   1389: invokestatic 278	com/tencent/luggage/wxa/qk/c:o	(Lcom/tencent/luggage/wxa/qk/c;)V
    //   1392: aload_0
    //   1393: getfield 12	com/tencent/luggage/wxa/qk/c$1:a	Lcom/tencent/luggage/wxa/qk/c;
    //   1396: aconst_null
    //   1397: invokestatic 280	com/tencent/luggage/wxa/qk/c:b	(Lcom/tencent/luggage/wxa/qk/c;Ljava/lang/String;)Ljava/lang/String;
    //   1400: pop
    //   1401: aload_0
    //   1402: getfield 12	com/tencent/luggage/wxa/qk/c$1:a	Lcom/tencent/luggage/wxa/qk/c;
    //   1405: aconst_null
    //   1406: invokestatic 94	com/tencent/luggage/wxa/qk/c:a	(Lcom/tencent/luggage/wxa/qk/c;Ljava/lang/String;)Ljava/lang/String;
    //   1409: pop
    //   1410: aload_0
    //   1411: getfield 12	com/tencent/luggage/wxa/qk/c$1:a	Lcom/tencent/luggage/wxa/qk/c;
    //   1414: iconst_0
    //   1415: invokestatic 122	com/tencent/luggage/wxa/qk/c:b	(Lcom/tencent/luggage/wxa/qk/c;I)I
    //   1418: pop
    //   1419: aload_0
    //   1420: getfield 12	com/tencent/luggage/wxa/qk/c$1:a	Lcom/tencent/luggage/wxa/qk/c;
    //   1423: iconst_0
    //   1424: invokestatic 126	com/tencent/luggage/wxa/qk/c:c	(Lcom/tencent/luggage/wxa/qk/c;I)I
    //   1427: pop
    //   1428: aload_0
    //   1429: getfield 12	com/tencent/luggage/wxa/qk/c$1:a	Lcom/tencent/luggage/wxa/qk/c;
    //   1432: lconst_0
    //   1433: invokestatic 217	com/tencent/luggage/wxa/qk/c:b	(Lcom/tencent/luggage/wxa/qk/c;J)J
    //   1436: pop2
    //   1437: aload_0
    //   1438: getfield 12	com/tencent/luggage/wxa/qk/c$1:a	Lcom/tencent/luggage/wxa/qk/c;
    //   1441: lconst_0
    //   1442: invokestatic 135	com/tencent/luggage/wxa/qk/c:a	(Lcom/tencent/luggage/wxa/qk/c;J)J
    //   1445: pop2
    //   1446: ldc 21
    //   1448: ldc_w 326
    //   1451: invokestatic 29	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1454: return
    //   1455: aload_0
    //   1456: getfield 12	com/tencent/luggage/wxa/qk/c$1:a	Lcom/tencent/luggage/wxa/qk/c;
    //   1459: invokestatic 110	com/tencent/luggage/wxa/qk/c:d	(Lcom/tencent/luggage/wxa/qk/c;)V
    //   1462: aload_0
    //   1463: getfield 12	com/tencent/luggage/wxa/qk/c$1:a	Lcom/tencent/luggage/wxa/qk/c;
    //   1466: invokestatic 275	com/tencent/luggage/wxa/qk/c:f	(Lcom/tencent/luggage/wxa/qk/c;)V
    //   1469: aload_0
    //   1470: getfield 12	com/tencent/luggage/wxa/qk/c$1:a	Lcom/tencent/luggage/wxa/qk/c;
    //   1473: invokestatic 278	com/tencent/luggage/wxa/qk/c:o	(Lcom/tencent/luggage/wxa/qk/c;)V
    //   1476: aload_0
    //   1477: getfield 12	com/tencent/luggage/wxa/qk/c$1:a	Lcom/tencent/luggage/wxa/qk/c;
    //   1480: aconst_null
    //   1481: invokestatic 280	com/tencent/luggage/wxa/qk/c:b	(Lcom/tencent/luggage/wxa/qk/c;Ljava/lang/String;)Ljava/lang/String;
    //   1484: pop
    //   1485: aload_0
    //   1486: getfield 12	com/tencent/luggage/wxa/qk/c$1:a	Lcom/tencent/luggage/wxa/qk/c;
    //   1489: aconst_null
    //   1490: invokestatic 94	com/tencent/luggage/wxa/qk/c:a	(Lcom/tencent/luggage/wxa/qk/c;Ljava/lang/String;)Ljava/lang/String;
    //   1493: pop
    //   1494: aload_0
    //   1495: getfield 12	com/tencent/luggage/wxa/qk/c$1:a	Lcom/tencent/luggage/wxa/qk/c;
    //   1498: iconst_0
    //   1499: invokestatic 122	com/tencent/luggage/wxa/qk/c:b	(Lcom/tencent/luggage/wxa/qk/c;I)I
    //   1502: pop
    //   1503: aload_0
    //   1504: getfield 12	com/tencent/luggage/wxa/qk/c$1:a	Lcom/tencent/luggage/wxa/qk/c;
    //   1507: iconst_0
    //   1508: invokestatic 126	com/tencent/luggage/wxa/qk/c:c	(Lcom/tencent/luggage/wxa/qk/c;I)I
    //   1511: pop
    //   1512: aload_0
    //   1513: getfield 12	com/tencent/luggage/wxa/qk/c$1:a	Lcom/tencent/luggage/wxa/qk/c;
    //   1516: lconst_0
    //   1517: invokestatic 217	com/tencent/luggage/wxa/qk/c:b	(Lcom/tencent/luggage/wxa/qk/c;J)J
    //   1520: pop2
    //   1521: aload_0
    //   1522: getfield 12	com/tencent/luggage/wxa/qk/c$1:a	Lcom/tencent/luggage/wxa/qk/c;
    //   1525: lconst_0
    //   1526: invokestatic 135	com/tencent/luggage/wxa/qk/c:a	(Lcom/tencent/luggage/wxa/qk/c;J)J
    //   1529: pop2
    //   1530: aload 10
    //   1532: athrow
    //   1533: astore 10
    //   1535: ldc 21
    //   1537: aload 10
    //   1539: ldc_w 328
    //   1542: iconst_0
    //   1543: anewarray 4	java/lang/Object
    //   1546: invokestatic 140	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1549: aload_0
    //   1550: getfield 12	com/tencent/luggage/wxa/qk/c$1:a	Lcom/tencent/luggage/wxa/qk/c;
    //   1553: sipush 704
    //   1556: invokestatic 108	com/tencent/luggage/wxa/qk/c:a	(Lcom/tencent/luggage/wxa/qk/c;I)I
    //   1559: pop
    //   1560: aload_0
    //   1561: getfield 12	com/tencent/luggage/wxa/qk/c$1:a	Lcom/tencent/luggage/wxa/qk/c;
    //   1564: iconst_1
    //   1565: invokevirtual 54	com/tencent/luggage/wxa/qk/c:a	(Z)V
    //   1568: aload_0
    //   1569: getfield 12	com/tencent/luggage/wxa/qk/c$1:a	Lcom/tencent/luggage/wxa/qk/c;
    //   1572: invokestatic 110	com/tencent/luggage/wxa/qk/c:d	(Lcom/tencent/luggage/wxa/qk/c;)V
    //   1575: aload_0
    //   1576: getfield 12	com/tencent/luggage/wxa/qk/c$1:a	Lcom/tencent/luggage/wxa/qk/c;
    //   1579: invokestatic 275	com/tencent/luggage/wxa/qk/c:f	(Lcom/tencent/luggage/wxa/qk/c;)V
    //   1582: return
    //   1583: astore 10
    //   1585: ldc 21
    //   1587: aload 10
    //   1589: ldc_w 330
    //   1592: iconst_0
    //   1593: anewarray 4	java/lang/Object
    //   1596: invokestatic 140	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1599: aload_0
    //   1600: getfield 12	com/tencent/luggage/wxa/qk/c$1:a	Lcom/tencent/luggage/wxa/qk/c;
    //   1603: sipush 702
    //   1606: invokestatic 108	com/tencent/luggage/wxa/qk/c:a	(Lcom/tencent/luggage/wxa/qk/c;I)I
    //   1609: pop
    //   1610: aload_0
    //   1611: getfield 12	com/tencent/luggage/wxa/qk/c$1:a	Lcom/tencent/luggage/wxa/qk/c;
    //   1614: iconst_1
    //   1615: invokevirtual 54	com/tencent/luggage/wxa/qk/c:a	(Z)V
    //   1618: return
    //   1619: iconst_0
    //   1620: istore_1
    //   1621: goto -924 -> 697
    //   1624: goto -854 -> 770
    //   1627: iload 5
    //   1629: istore_1
    //   1630: aload 11
    //   1632: astore 10
    //   1634: goto -1135 -> 499
    //   1637: iconst_0
    //   1638: istore 7
    //   1640: goto -388 -> 1252
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1643	0	this	1
    //   103	1527	1	i	int
    //   83	1187	2	j	int
    //   494	535	3	k	int
    //   532	675	4	m	int
    //   582	1046	5	n	int
    //   555	197	6	i1	int
    //   162	1477	7	bool	boolean
    //   686	19	8	l	long
    //   120	1090	10	localObject1	Object
    //   1331	1	10	localObject2	Object
    //   1336	195	10	localException1	java.lang.Exception
    //   1533	5	10	localException2	java.lang.Exception
    //   1583	5	10	localException3	java.lang.Exception
    //   1632	1	10	localObject3	Object
    //   285	1	11	localException4	java.lang.Exception
    //   290	8	11	localException5	java.lang.Exception
    //   384	1247	11	localObject4	Object
    //   372	191	12	arrayOfByteBuffer	java.nio.ByteBuffer[]
    //   469	541	13	localBufferInfo	android.media.MediaCodec.BufferInfo
    //   819	298	14	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   187	220	285	java/lang/Exception
    //   221	282	285	java/lang/Exception
    //   73	102	290	java/lang/Exception
    //   109	164	290	java/lang/Exception
    //   509	526	1331	finally
    //   538	547	1331	finally
    //   547	557	1331	finally
    //   569	584	1331	finally
    //   589	596	1331	finally
    //   604	634	1331	finally
    //   639	660	1331	finally
    //   660	668	1331	finally
    //   670	688	1331	finally
    //   697	710	1331	finally
    //   716	727	1331	finally
    //   732	767	1331	finally
    //   773	789	1331	finally
    //   796	804	1331	finally
    //   812	888	1331	finally
    //   964	974	1331	finally
    //   974	991	1331	finally
    //   991	1003	1331	finally
    //   1009	1027	1331	finally
    //   1044	1064	1331	finally
    //   1076	1161	1331	finally
    //   1171	1206	1331	finally
    //   1216	1246	1331	finally
    //   1258	1296	1331	finally
    //   1299	1328	1331	finally
    //   1338	1371	1331	finally
    //   509	526	1336	java/lang/Exception
    //   538	547	1336	java/lang/Exception
    //   547	557	1336	java/lang/Exception
    //   569	584	1336	java/lang/Exception
    //   589	596	1336	java/lang/Exception
    //   604	634	1336	java/lang/Exception
    //   639	660	1336	java/lang/Exception
    //   660	668	1336	java/lang/Exception
    //   670	688	1336	java/lang/Exception
    //   697	710	1336	java/lang/Exception
    //   716	727	1336	java/lang/Exception
    //   732	767	1336	java/lang/Exception
    //   773	789	1336	java/lang/Exception
    //   796	804	1336	java/lang/Exception
    //   812	888	1336	java/lang/Exception
    //   964	974	1336	java/lang/Exception
    //   974	991	1336	java/lang/Exception
    //   991	1003	1336	java/lang/Exception
    //   1009	1027	1336	java/lang/Exception
    //   1044	1064	1336	java/lang/Exception
    //   1076	1161	1336	java/lang/Exception
    //   1171	1206	1336	java/lang/Exception
    //   1216	1246	1336	java/lang/Exception
    //   1258	1296	1336	java/lang/Exception
    //   1299	1328	1336	java/lang/Exception
    //   319	362	1533	java/lang/Exception
    //   56	73	1583	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qk.c.1
 * JD-Core Version:    0.7.0.1
 */