import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class bpso
{
  private int jdField_a_of_type_Int;
  private bpsp jdField_a_of_type_Bpsp;
  private ArrayList<Float> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public boolean a;
  private int b = 0;
  private int c = 1024;
  
  private int a(int paramInt)
  {
    return (int)(paramInt * 1.0D * this.jdField_a_of_type_Int / (1000.0D * a()) + 0.5D);
  }
  
  private void a(bpsp parambpsp)
  {
    this.jdField_a_of_type_Bpsp = parambpsp;
  }
  
  /* Error */
  private boolean a(File paramFile, int paramInt, MusicItemInfo paramMusicItemInfo)
  {
    // Byte code:
    //   0: new 48	android/media/MediaExtractor
    //   3: dup
    //   4: invokespecial 49	android/media/MediaExtractor:<init>	()V
    //   7: astore 24
    //   9: aload_1
    //   10: invokevirtual 55	java/io/File:length	()J
    //   13: l2i
    //   14: istore 15
    //   16: aload 24
    //   18: aload_1
    //   19: invokevirtual 59	java/io/File:getPath	()Ljava/lang/String;
    //   22: invokevirtual 63	android/media/MediaExtractor:setDataSource	(Ljava/lang/String;)V
    //   25: aload 24
    //   27: invokevirtual 66	android/media/MediaExtractor:getTrackCount	()I
    //   30: istore 9
    //   32: aconst_null
    //   33: astore 18
    //   35: iconst_0
    //   36: istore 8
    //   38: iload 8
    //   40: iload 9
    //   42: if_icmpge +2119 -> 2161
    //   45: aload 24
    //   47: iload 8
    //   49: invokevirtual 70	android/media/MediaExtractor:getTrackFormat	(I)Landroid/media/MediaFormat;
    //   52: astore 18
    //   54: aload 18
    //   56: ifnull +71 -> 127
    //   59: aload 18
    //   61: ldc 72
    //   63: invokevirtual 78	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   66: ldc 80
    //   68: invokevirtual 86	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   71: ifeq +56 -> 127
    //   74: aload 24
    //   76: iload 8
    //   78: invokevirtual 90	android/media/MediaExtractor:selectTrack	(I)V
    //   81: aload 18
    //   83: astore 23
    //   85: iload 8
    //   87: iload 9
    //   89: if_icmpne +47 -> 136
    //   92: new 92	java/lang/RuntimeException
    //   95: dup
    //   96: new 94	java/lang/StringBuilder
    //   99: dup
    //   100: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   103: ldc 97
    //   105: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: aload_1
    //   109: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   112: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   115: invokespecial 109	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   118: athrow
    //   119: astore_1
    //   120: aload 24
    //   122: invokevirtual 112	android/media/MediaExtractor:release	()V
    //   125: aload_1
    //   126: athrow
    //   127: iload 8
    //   129: iconst_1
    //   130: iadd
    //   131: istore 8
    //   133: goto -95 -> 38
    //   136: aload 23
    //   138: ifnonnull +10 -> 148
    //   141: aload 24
    //   143: invokevirtual 112	android/media/MediaExtractor:release	()V
    //   146: iconst_0
    //   147: ireturn
    //   148: aload_3
    //   149: getfield 117	com/tencent/mobileqq/richmedia/capture/data/MusicItemInfo:musicStart	I
    //   152: iload_2
    //   153: iadd
    //   154: istore 8
    //   156: iload 8
    //   158: ifle +16 -> 174
    //   161: aload 24
    //   163: iload 8
    //   165: i2l
    //   166: ldc2_w 118
    //   169: lmul
    //   170: iconst_2
    //   171: invokevirtual 123	android/media/MediaExtractor:seekTo	(JI)V
    //   174: aload 23
    //   176: ldc 125
    //   178: invokevirtual 129	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   181: istore 14
    //   183: aload_0
    //   184: aload 23
    //   186: ldc 131
    //   188: invokevirtual 129	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   191: putfield 29	bpso:jdField_a_of_type_Int	I
    //   194: aload_3
    //   195: invokevirtual 135	com/tencent/mobileqq/richmedia/capture/data/MusicItemInfo:isMyMusicInfo	()Z
    //   198: ifeq +81 -> 279
    //   201: aload_3
    //   202: getfield 138	com/tencent/mobileqq/richmedia/capture/data/MusicItemInfo:musicEnd	I
    //   205: aload_3
    //   206: getfield 117	com/tencent/mobileqq/richmedia/capture/data/MusicItemInfo:musicStart	I
    //   209: iload_2
    //   210: iadd
    //   211: isub
    //   212: istore_2
    //   213: iload_2
    //   214: i2f
    //   215: ldc 139
    //   217: fdiv
    //   218: aload_0
    //   219: getfield 29	bpso:jdField_a_of_type_Int	I
    //   222: i2f
    //   223: fmul
    //   224: ldc 140
    //   226: fadd
    //   227: f2i
    //   228: istore 16
    //   230: aload_0
    //   231: sipush 1024
    //   234: putfield 18	bpso:c	I
    //   237: fconst_1
    //   238: aload_0
    //   239: getfield 29	bpso:jdField_a_of_type_Int	I
    //   242: i2f
    //   243: fmul
    //   244: aload_0
    //   245: getfield 18	bpso:c	I
    //   248: i2f
    //   249: fdiv
    //   250: ldc 141
    //   252: fcmpg
    //   253: ifge +52 -> 305
    //   256: aload_0
    //   257: getfield 18	bpso:c	I
    //   260: sipush 128
    //   263: if_icmple +42 -> 305
    //   266: aload_0
    //   267: aload_0
    //   268: getfield 18	bpso:c	I
    //   271: iconst_2
    //   272: idiv
    //   273: putfield 18	bpso:c	I
    //   276: goto -39 -> 237
    //   279: aload 23
    //   281: ldc 143
    //   283: invokevirtual 147	android/media/MediaFormat:getLong	(Ljava/lang/String;)J
    //   286: l2f
    //   287: ldc 139
    //   289: fdiv
    //   290: ldc 140
    //   292: fadd
    //   293: f2i
    //   294: aload_3
    //   295: getfield 117	com/tencent/mobileqq/richmedia/capture/data/MusicItemInfo:musicStart	I
    //   298: iload_2
    //   299: iadd
    //   300: isub
    //   301: istore_2
    //   302: goto -89 -> 213
    //   305: aload 23
    //   307: ldc 72
    //   309: invokevirtual 78	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   312: invokestatic 153	android/media/MediaCodec:createDecoderByType	(Ljava/lang/String;)Landroid/media/MediaCodec;
    //   315: astore 25
    //   317: aload 25
    //   319: aload 23
    //   321: aconst_null
    //   322: aconst_null
    //   323: iconst_0
    //   324: invokevirtual 157	android/media/MediaCodec:configure	(Landroid/media/MediaFormat;Landroid/view/Surface;Landroid/media/MediaCrypto;I)V
    //   327: aload 25
    //   329: invokevirtual 160	android/media/MediaCodec:start	()V
    //   332: aload 25
    //   334: invokevirtual 164	android/media/MediaCodec:getInputBuffers	()[Ljava/nio/ByteBuffer;
    //   337: astore 26
    //   339: aload 25
    //   341: invokevirtual 167	android/media/MediaCodec:getOutputBuffers	()[Ljava/nio/ByteBuffer;
    //   344: astore 19
    //   346: new 169	android/media/MediaCodec$BufferInfo
    //   349: dup
    //   350: invokespecial 170	android/media/MediaCodec$BufferInfo:<init>	()V
    //   353: astore 27
    //   355: iconst_0
    //   356: istore 9
    //   358: iconst_0
    //   359: istore 8
    //   361: ldc 171
    //   363: invokestatic 177	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   366: astore_1
    //   367: aload_0
    //   368: monitorenter
    //   369: aload_0
    //   370: getfield 25	bpso:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   373: invokevirtual 180	java/util/ArrayList:clear	()V
    //   376: aload_0
    //   377: monitorexit
    //   378: aload_0
    //   379: iconst_0
    //   380: putfield 20	bpso:b	I
    //   383: aload_0
    //   384: invokevirtual 34	bpso:a	()I
    //   387: iload 14
    //   389: imul
    //   390: newarray short
    //   392: astore 28
    //   394: aload_0
    //   395: iconst_1
    //   396: putfield 182	bpso:jdField_a_of_type_Boolean	Z
    //   399: ldc 183
    //   401: fstore 5
    //   403: ldc 183
    //   405: fstore 4
    //   407: aconst_null
    //   408: astore_3
    //   409: iconst_0
    //   410: istore_2
    //   411: iconst_1
    //   412: invokestatic 189	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   415: astore 18
    //   417: ldc 183
    //   419: fstore 6
    //   421: aload 25
    //   423: ldc2_w 190
    //   426: invokevirtual 195	android/media/MediaCodec:dequeueInputBuffer	(J)I
    //   429: istore 10
    //   431: iload 8
    //   433: ifne +1671 -> 2104
    //   436: iload 10
    //   438: iflt +1666 -> 2104
    //   441: aload 24
    //   443: aload 26
    //   445: iload 10
    //   447: aaload
    //   448: iconst_0
    //   449: invokevirtual 199	android/media/MediaExtractor:readSampleData	(Ljava/nio/ByteBuffer;I)I
    //   452: istore 11
    //   454: aload 18
    //   456: invokevirtual 202	java/lang/Boolean:booleanValue	()Z
    //   459: ifeq +257 -> 716
    //   462: aload 23
    //   464: ldc 72
    //   466: invokevirtual 78	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   469: ldc 204
    //   471: invokevirtual 208	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   474: ifeq +242 -> 716
    //   477: iload 11
    //   479: iconst_2
    //   480: if_icmpne +236 -> 716
    //   483: aload 24
    //   485: invokevirtual 211	android/media/MediaExtractor:advance	()Z
    //   488: pop
    //   489: iload 11
    //   491: iload 9
    //   493: iadd
    //   494: istore 9
    //   496: iconst_0
    //   497: invokestatic 189	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   500: astore 21
    //   502: iload 8
    //   504: istore 10
    //   506: iload 9
    //   508: istore 8
    //   510: iload 10
    //   512: istore 9
    //   514: aload 25
    //   516: aload 27
    //   518: ldc2_w 190
    //   521: invokevirtual 215	android/media/MediaCodec:dequeueOutputBuffer	(Landroid/media/MediaCodec$BufferInfo;J)I
    //   524: istore 12
    //   526: iload 12
    //   528: iflt +735 -> 1263
    //   531: aload 27
    //   533: getfield 218	android/media/MediaCodec$BufferInfo:size	I
    //   536: ifle +727 -> 1263
    //   539: aload_3
    //   540: astore 22
    //   542: iload_2
    //   543: istore 10
    //   545: iload_2
    //   546: aload 27
    //   548: getfield 218	android/media/MediaCodec$BufferInfo:size	I
    //   551: if_icmpge +16 -> 567
    //   554: aload 27
    //   556: getfield 218	android/media/MediaCodec$BufferInfo:size	I
    //   559: istore 10
    //   561: iload 10
    //   563: newarray byte
    //   565: astore 22
    //   567: aload 19
    //   569: iload 12
    //   571: aaload
    //   572: aload 22
    //   574: iconst_0
    //   575: aload 27
    //   577: getfield 218	android/media/MediaCodec$BufferInfo:size	I
    //   580: invokevirtual 222	java/nio/ByteBuffer:get	([BII)Ljava/nio/ByteBuffer;
    //   583: pop
    //   584: aload 19
    //   586: iload 12
    //   588: aaload
    //   589: invokevirtual 225	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   592: pop
    //   593: aload_1
    //   594: invokevirtual 228	java/nio/ByteBuffer:remaining	()I
    //   597: aload 27
    //   599: getfield 218	android/media/MediaCodec$BufferInfo:size	I
    //   602: if_icmpge +1556 -> 2158
    //   605: aload_1
    //   606: invokevirtual 231	java/nio/ByteBuffer:position	()I
    //   609: istore 13
    //   611: iload 13
    //   613: i2d
    //   614: dconst_1
    //   615: iload 15
    //   617: i2d
    //   618: dmul
    //   619: iload 8
    //   621: i2d
    //   622: ddiv
    //   623: dmul
    //   624: ldc2_w 232
    //   627: dmul
    //   628: d2i
    //   629: istore 11
    //   631: iload 11
    //   633: istore_2
    //   634: iload 11
    //   636: iload 13
    //   638: isub
    //   639: aload 27
    //   641: getfield 218	android/media/MediaCodec$BufferInfo:size	I
    //   644: ldc 234
    //   646: iadd
    //   647: if_icmpge +17 -> 664
    //   650: aload 27
    //   652: getfield 218	android/media/MediaCodec$BufferInfo:size	I
    //   655: istore_2
    //   656: iload_2
    //   657: iload 13
    //   659: iadd
    //   660: ldc 234
    //   662: iadd
    //   663: istore_2
    //   664: aconst_null
    //   665: astore_3
    //   666: bipush 10
    //   668: istore 11
    //   670: aload_3
    //   671: astore 18
    //   673: iload 11
    //   675: ifle +9 -> 684
    //   678: iload_2
    //   679: invokestatic 177	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   682: astore 18
    //   684: iload 11
    //   686: ifne +163 -> 849
    //   689: aload_1
    //   690: invokevirtual 225	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   693: pop
    //   694: aload 24
    //   696: invokevirtual 112	android/media/MediaExtractor:release	()V
    //   699: aload 25
    //   701: invokevirtual 237	android/media/MediaCodec:stop	()V
    //   704: aload 25
    //   706: invokevirtual 238	android/media/MediaCodec:release	()V
    //   709: iconst_1
    //   710: ireturn
    //   711: astore_1
    //   712: aload_0
    //   713: monitorexit
    //   714: aload_1
    //   715: athrow
    //   716: iload 11
    //   718: ifge +22 -> 740
    //   721: aload 25
    //   723: iload 10
    //   725: iconst_0
    //   726: iconst_0
    //   727: ldc2_w 239
    //   730: iconst_4
    //   731: invokevirtual 244	android/media/MediaCodec:queueInputBuffer	(IIIJI)V
    //   734: iconst_1
    //   735: istore 8
    //   737: goto -241 -> 496
    //   740: aload 25
    //   742: iload 10
    //   744: iconst_0
    //   745: iload 11
    //   747: aload 24
    //   749: invokevirtual 247	android/media/MediaExtractor:getSampleTime	()J
    //   752: iconst_0
    //   753: invokevirtual 244	android/media/MediaCodec:queueInputBuffer	(IIIJI)V
    //   756: aload 24
    //   758: invokevirtual 211	android/media/MediaExtractor:advance	()Z
    //   761: pop
    //   762: iload 11
    //   764: iload 9
    //   766: iadd
    //   767: istore 9
    //   769: aload_0
    //   770: getfield 39	bpso:jdField_a_of_type_Bpsp	Lbpsp;
    //   773: ifnull +1328 -> 2101
    //   776: aload_0
    //   777: getfield 39	bpso:jdField_a_of_type_Bpsp	Lbpsp;
    //   780: iload 9
    //   782: i2f
    //   783: iload 15
    //   785: i2f
    //   786: fdiv
    //   787: f2d
    //   788: invokeinterface 252 3 0
    //   793: ifne +1308 -> 2101
    //   796: aload_1
    //   797: invokevirtual 225	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   800: pop
    //   801: aload 24
    //   803: invokevirtual 112	android/media/MediaExtractor:release	()V
    //   806: aload 25
    //   808: invokevirtual 237	android/media/MediaCodec:stop	()V
    //   811: aload 25
    //   813: invokevirtual 238	android/media/MediaCodec:release	()V
    //   816: aload_1
    //   817: invokevirtual 225	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   820: pop
    //   821: aload 24
    //   823: invokevirtual 112	android/media/MediaExtractor:release	()V
    //   826: aload 25
    //   828: invokevirtual 237	android/media/MediaCodec:stop	()V
    //   831: aload 25
    //   833: invokevirtual 238	android/media/MediaCodec:release	()V
    //   836: iconst_1
    //   837: ireturn
    //   838: astore 18
    //   840: iload 11
    //   842: iconst_1
    //   843: isub
    //   844: istore 11
    //   846: goto -176 -> 670
    //   849: aload_1
    //   850: invokevirtual 255	java/nio/ByteBuffer:rewind	()Ljava/nio/Buffer;
    //   853: pop
    //   854: aload 18
    //   856: aload_1
    //   857: invokevirtual 259	java/nio/ByteBuffer:put	(Ljava/nio/ByteBuffer;)Ljava/nio/ByteBuffer;
    //   860: pop
    //   861: aload 18
    //   863: astore 20
    //   865: aload 18
    //   867: astore_3
    //   868: aload 18
    //   870: iload 13
    //   872: invokevirtual 262	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   875: pop
    //   876: aload 18
    //   878: astore_1
    //   879: aload_1
    //   880: astore 20
    //   882: aload_1
    //   883: astore_3
    //   884: aload_1
    //   885: aload 22
    //   887: iconst_0
    //   888: aload 27
    //   890: getfield 218	android/media/MediaCodec$BufferInfo:size	I
    //   893: invokevirtual 264	java/nio/ByteBuffer:put	([BII)Ljava/nio/ByteBuffer;
    //   896: pop
    //   897: aload_1
    //   898: astore 20
    //   900: aload_1
    //   901: astore_3
    //   902: aload 25
    //   904: iload 12
    //   906: iconst_0
    //   907: invokevirtual 268	android/media/MediaCodec:releaseOutputBuffer	(IZ)V
    //   910: aload_1
    //   911: astore 20
    //   913: aload_1
    //   914: astore_3
    //   915: aload_1
    //   916: invokevirtual 231	java/nio/ByteBuffer:position	()I
    //   919: istore 17
    //   921: aload_1
    //   922: astore 20
    //   924: aload_1
    //   925: astore_3
    //   926: iload 17
    //   928: aload_0
    //   929: getfield 20	bpso:b	I
    //   932: isub
    //   933: aload_0
    //   934: invokevirtual 34	bpso:a	()I
    //   937: iconst_2
    //   938: imul
    //   939: iload 14
    //   941: imul
    //   942: if_icmple +1190 -> 2132
    //   945: aload_1
    //   946: astore 20
    //   948: aload_1
    //   949: astore_3
    //   950: aload_1
    //   951: aload_0
    //   952: getfield 20	bpso:b	I
    //   955: invokevirtual 262	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   958: pop
    //   959: aload_1
    //   960: astore 20
    //   962: aload_1
    //   963: astore_3
    //   964: aload_1
    //   965: getstatic 274	java/nio/ByteOrder:LITTLE_ENDIAN	Ljava/nio/ByteOrder;
    //   968: invokevirtual 278	java/nio/ByteBuffer:order	(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    //   971: invokevirtual 282	java/nio/ByteBuffer:asShortBuffer	()Ljava/nio/ShortBuffer;
    //   974: aload 28
    //   976: invokevirtual 287	java/nio/ShortBuffer:get	([S)Ljava/nio/ShortBuffer;
    //   979: pop
    //   980: aload_1
    //   981: astore 20
    //   983: aload_1
    //   984: astore_3
    //   985: aload_1
    //   986: iload 17
    //   988: invokevirtual 262	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   991: pop
    //   992: aload_1
    //   993: astore 20
    //   995: aload_1
    //   996: astore_3
    //   997: aload_0
    //   998: aload_0
    //   999: getfield 20	bpso:b	I
    //   1002: aload_0
    //   1003: invokevirtual 34	bpso:a	()I
    //   1006: iconst_2
    //   1007: imul
    //   1008: iload 14
    //   1010: imul
    //   1011: iadd
    //   1012: putfield 20	bpso:b	I
    //   1015: iconst_m1
    //   1016: istore_2
    //   1017: iconst_0
    //   1018: istore 11
    //   1020: aload_1
    //   1021: astore 20
    //   1023: aload_1
    //   1024: astore_3
    //   1025: iload 11
    //   1027: aload 28
    //   1029: arraylength
    //   1030: iload 14
    //   1032: idiv
    //   1033: if_icmpge +73 -> 1106
    //   1036: iconst_0
    //   1037: istore 13
    //   1039: iconst_0
    //   1040: istore 12
    //   1042: iload 12
    //   1044: iload 14
    //   1046: if_icmpge +36 -> 1082
    //   1049: aload_1
    //   1050: astore 20
    //   1052: aload_1
    //   1053: astore_3
    //   1054: iload 13
    //   1056: aload 28
    //   1058: iload 11
    //   1060: iload 14
    //   1062: imul
    //   1063: iload 12
    //   1065: iadd
    //   1066: saload
    //   1067: invokestatic 292	java/lang/Math:abs	(I)I
    //   1070: iadd
    //   1071: istore 13
    //   1073: iload 12
    //   1075: iconst_1
    //   1076: iadd
    //   1077: istore 12
    //   1079: goto -37 -> 1042
    //   1082: aload_1
    //   1083: astore 20
    //   1085: aload_1
    //   1086: astore_3
    //   1087: iload 13
    //   1089: iload 14
    //   1091: idiv
    //   1092: istore 12
    //   1094: iload_2
    //   1095: iload 12
    //   1097: if_icmpge +1032 -> 2129
    //   1100: iload 12
    //   1102: istore_2
    //   1103: goto +1065 -> 2168
    //   1106: aload_1
    //   1107: astore 20
    //   1109: aload_1
    //   1110: astore_3
    //   1111: iload_2
    //   1112: i2d
    //   1113: invokestatic 296	java/lang/Math:sqrt	(D)D
    //   1116: d2f
    //   1117: fstore 6
    //   1119: aload_1
    //   1120: astore 20
    //   1122: aload_1
    //   1123: astore_3
    //   1124: aload_0
    //   1125: monitorenter
    //   1126: fload 5
    //   1128: fconst_0
    //   1129: fcmpg
    //   1130: ifge +28 -> 1158
    //   1133: fload 4
    //   1135: fstore 5
    //   1137: aload_0
    //   1138: monitorexit
    //   1139: fload 6
    //   1141: fstore 7
    //   1143: fload 5
    //   1145: fstore 4
    //   1147: fload 6
    //   1149: fstore 5
    //   1151: fload 7
    //   1153: fstore 6
    //   1155: goto -234 -> 921
    //   1158: fload 4
    //   1160: fconst_0
    //   1161: fcmpg
    //   1162: ifge +24 -> 1186
    //   1165: aload_0
    //   1166: getfield 25	bpso:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1169: fload 5
    //   1171: fload 6
    //   1173: fadd
    //   1174: fconst_2
    //   1175: fdiv
    //   1176: invokestatic 301	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   1179: invokevirtual 304	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1182: pop
    //   1183: goto -46 -> 1137
    //   1186: aload_0
    //   1187: getfield 25	bpso:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1190: fload 4
    //   1192: fload 5
    //   1194: fadd
    //   1195: fload 6
    //   1197: fadd
    //   1198: ldc_w 305
    //   1201: fdiv
    //   1202: invokestatic 301	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   1205: invokevirtual 304	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1208: pop
    //   1209: goto -72 -> 1137
    //   1212: astore 18
    //   1214: aload_0
    //   1215: monitorexit
    //   1216: aload_1
    //   1217: astore 20
    //   1219: aload_1
    //   1220: astore_3
    //   1221: aload 18
    //   1223: athrow
    //   1224: astore_1
    //   1225: aload 20
    //   1227: astore_3
    //   1228: ldc_w 307
    //   1231: iconst_1
    //   1232: ldc_w 309
    //   1235: aload_1
    //   1236: invokestatic 315	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1239: aload 20
    //   1241: invokevirtual 225	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   1244: pop
    //   1245: aload 24
    //   1247: invokevirtual 112	android/media/MediaExtractor:release	()V
    //   1250: aload 25
    //   1252: invokevirtual 237	android/media/MediaCodec:stop	()V
    //   1255: aload 25
    //   1257: invokevirtual 238	android/media/MediaCodec:release	()V
    //   1260: goto -551 -> 709
    //   1263: iload 12
    //   1265: bipush 253
    //   1267: if_icmpne +910 -> 2177
    //   1270: aload 25
    //   1272: invokevirtual 167	android/media/MediaCodec:getOutputBuffers	()[Ljava/nio/ByteBuffer;
    //   1275: astore 18
    //   1277: fload 6
    //   1279: fstore 7
    //   1281: aload_3
    //   1282: astore 19
    //   1284: fload 4
    //   1286: fstore 6
    //   1288: fload 7
    //   1290: fstore 4
    //   1292: aload_1
    //   1293: astore 20
    //   1295: aload_1
    //   1296: astore_3
    //   1297: aload 27
    //   1299: getfield 318	android/media/MediaCodec$BufferInfo:flags	I
    //   1302: iconst_4
    //   1303: iand
    //   1304: ifne +22 -> 1326
    //   1307: aload_1
    //   1308: astore 20
    //   1310: aload_1
    //   1311: astore_3
    //   1312: aload_1
    //   1313: invokevirtual 231	java/nio/ByteBuffer:position	()I
    //   1316: iload 14
    //   1318: iconst_2
    //   1319: imul
    //   1320: idiv
    //   1321: iload 16
    //   1323: if_icmplt +715 -> 2038
    //   1326: aload_1
    //   1327: astore 20
    //   1329: aload_1
    //   1330: astore_3
    //   1331: aload_1
    //   1332: invokevirtual 231	java/nio/ByteBuffer:position	()I
    //   1335: istore 11
    //   1337: aload_1
    //   1338: astore 20
    //   1340: aload_1
    //   1341: astore_3
    //   1342: iload 11
    //   1344: aload_0
    //   1345: getfield 20	bpso:b	I
    //   1348: isub
    //   1349: aload_0
    //   1350: invokevirtual 34	bpso:a	()I
    //   1353: iconst_2
    //   1354: imul
    //   1355: iload 14
    //   1357: imul
    //   1358: if_icmple +310 -> 1668
    //   1361: aload_1
    //   1362: astore 20
    //   1364: aload_1
    //   1365: astore_3
    //   1366: aload_1
    //   1367: aload_0
    //   1368: getfield 20	bpso:b	I
    //   1371: invokevirtual 262	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   1374: pop
    //   1375: aload_1
    //   1376: astore 20
    //   1378: aload_1
    //   1379: astore_3
    //   1380: aload_1
    //   1381: getstatic 274	java/nio/ByteOrder:LITTLE_ENDIAN	Ljava/nio/ByteOrder;
    //   1384: invokevirtual 278	java/nio/ByteBuffer:order	(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    //   1387: invokevirtual 282	java/nio/ByteBuffer:asShortBuffer	()Ljava/nio/ShortBuffer;
    //   1390: aload 28
    //   1392: invokevirtual 287	java/nio/ShortBuffer:get	([S)Ljava/nio/ShortBuffer;
    //   1395: pop
    //   1396: aload_1
    //   1397: astore 20
    //   1399: aload_1
    //   1400: astore_3
    //   1401: aload_1
    //   1402: iload 11
    //   1404: invokevirtual 262	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   1407: pop
    //   1408: aload_1
    //   1409: astore 20
    //   1411: aload_1
    //   1412: astore_3
    //   1413: aload_0
    //   1414: aload_0
    //   1415: getfield 20	bpso:b	I
    //   1418: aload_0
    //   1419: invokevirtual 34	bpso:a	()I
    //   1422: iconst_2
    //   1423: imul
    //   1424: iload 14
    //   1426: imul
    //   1427: iadd
    //   1428: putfield 20	bpso:b	I
    //   1431: iconst_m1
    //   1432: istore_2
    //   1433: iconst_0
    //   1434: istore 8
    //   1436: aload_1
    //   1437: astore 20
    //   1439: aload_1
    //   1440: astore_3
    //   1441: iload 8
    //   1443: aload 28
    //   1445: arraylength
    //   1446: iload 14
    //   1448: idiv
    //   1449: if_icmpge +73 -> 1522
    //   1452: iconst_0
    //   1453: istore 10
    //   1455: iconst_0
    //   1456: istore 9
    //   1458: iload 9
    //   1460: iload 14
    //   1462: if_icmpge +36 -> 1498
    //   1465: aload_1
    //   1466: astore 20
    //   1468: aload_1
    //   1469: astore_3
    //   1470: iload 10
    //   1472: aload 28
    //   1474: iload 8
    //   1476: iload 14
    //   1478: imul
    //   1479: iload 9
    //   1481: iadd
    //   1482: saload
    //   1483: invokestatic 292	java/lang/Math:abs	(I)I
    //   1486: iadd
    //   1487: istore 10
    //   1489: iload 9
    //   1491: iconst_1
    //   1492: iadd
    //   1493: istore 9
    //   1495: goto -37 -> 1458
    //   1498: aload_1
    //   1499: astore 20
    //   1501: aload_1
    //   1502: astore_3
    //   1503: iload 10
    //   1505: iload 14
    //   1507: idiv
    //   1508: istore 9
    //   1510: iload_2
    //   1511: iload 9
    //   1513: if_icmpge +613 -> 2126
    //   1516: iload 9
    //   1518: istore_2
    //   1519: goto +687 -> 2206
    //   1522: aload_1
    //   1523: astore 20
    //   1525: aload_1
    //   1526: astore_3
    //   1527: iload_2
    //   1528: i2d
    //   1529: invokestatic 296	java/lang/Math:sqrt	(D)D
    //   1532: d2i
    //   1533: i2f
    //   1534: fstore 7
    //   1536: aload_1
    //   1537: astore 20
    //   1539: aload_1
    //   1540: astore_3
    //   1541: aload_0
    //   1542: monitorenter
    //   1543: fload 5
    //   1545: fconst_0
    //   1546: fcmpg
    //   1547: ifge +24 -> 1571
    //   1550: fload 6
    //   1552: fstore 4
    //   1554: aload_0
    //   1555: monitorexit
    //   1556: fload 7
    //   1558: fstore 5
    //   1560: fload 4
    //   1562: fstore 6
    //   1564: fload 7
    //   1566: fstore 4
    //   1568: goto -231 -> 1337
    //   1571: fload 6
    //   1573: fconst_0
    //   1574: fcmpg
    //   1575: ifge +28 -> 1603
    //   1578: aload_0
    //   1579: getfield 25	bpso:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1582: fload 5
    //   1584: fload 7
    //   1586: fadd
    //   1587: fconst_2
    //   1588: fdiv
    //   1589: invokestatic 301	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   1592: invokevirtual 304	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1595: pop
    //   1596: fload 5
    //   1598: fstore 4
    //   1600: goto -46 -> 1554
    //   1603: aload_0
    //   1604: getfield 25	bpso:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1607: fload 6
    //   1609: fload 5
    //   1611: fadd
    //   1612: fload 7
    //   1614: fadd
    //   1615: ldc_w 305
    //   1618: fdiv
    //   1619: invokestatic 301	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   1622: invokevirtual 304	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1625: pop
    //   1626: fload 5
    //   1628: fstore 4
    //   1630: goto -76 -> 1554
    //   1633: astore 18
    //   1635: aload_0
    //   1636: monitorexit
    //   1637: aload_1
    //   1638: astore 20
    //   1640: aload_1
    //   1641: astore_3
    //   1642: aload 18
    //   1644: athrow
    //   1645: astore_1
    //   1646: aload_3
    //   1647: invokevirtual 225	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   1650: pop
    //   1651: aload 24
    //   1653: invokevirtual 112	android/media/MediaExtractor:release	()V
    //   1656: aload 25
    //   1658: invokevirtual 237	android/media/MediaCodec:stop	()V
    //   1661: aload 25
    //   1663: invokevirtual 238	android/media/MediaCodec:release	()V
    //   1666: aload_1
    //   1667: athrow
    //   1668: aload_1
    //   1669: astore 20
    //   1671: aload_1
    //   1672: astore_3
    //   1673: iload 11
    //   1675: aload_0
    //   1676: getfield 20	bpso:b	I
    //   1679: if_icmple +317 -> 1996
    //   1682: aload_1
    //   1683: astore 20
    //   1685: aload_1
    //   1686: astore_3
    //   1687: iload 11
    //   1689: aload_0
    //   1690: getfield 20	bpso:b	I
    //   1693: isub
    //   1694: iconst_2
    //   1695: idiv
    //   1696: newarray short
    //   1698: astore 18
    //   1700: aload_1
    //   1701: astore 20
    //   1703: aload_1
    //   1704: astore_3
    //   1705: aload_1
    //   1706: aload_0
    //   1707: getfield 20	bpso:b	I
    //   1710: invokevirtual 262	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   1713: pop
    //   1714: aload_1
    //   1715: astore 20
    //   1717: aload_1
    //   1718: astore_3
    //   1719: aload_1
    //   1720: getstatic 274	java/nio/ByteOrder:LITTLE_ENDIAN	Ljava/nio/ByteOrder;
    //   1723: invokevirtual 278	java/nio/ByteBuffer:order	(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    //   1726: invokevirtual 282	java/nio/ByteBuffer:asShortBuffer	()Ljava/nio/ShortBuffer;
    //   1729: aload 18
    //   1731: invokevirtual 287	java/nio/ShortBuffer:get	([S)Ljava/nio/ShortBuffer;
    //   1734: pop
    //   1735: aload_1
    //   1736: astore 20
    //   1738: aload_1
    //   1739: astore_3
    //   1740: aload_1
    //   1741: iload 11
    //   1743: invokevirtual 262	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   1746: pop
    //   1747: aload_1
    //   1748: astore 20
    //   1750: aload_1
    //   1751: astore_3
    //   1752: aload_0
    //   1753: iload 11
    //   1755: putfield 20	bpso:b	I
    //   1758: iconst_m1
    //   1759: istore_2
    //   1760: iconst_0
    //   1761: istore 8
    //   1763: aload_1
    //   1764: astore 20
    //   1766: aload_1
    //   1767: astore_3
    //   1768: iload 8
    //   1770: aload 18
    //   1772: arraylength
    //   1773: iload 14
    //   1775: idiv
    //   1776: if_icmpge +73 -> 1849
    //   1779: iconst_0
    //   1780: istore 10
    //   1782: iconst_0
    //   1783: istore 9
    //   1785: iload 9
    //   1787: iload 14
    //   1789: if_icmpge +36 -> 1825
    //   1792: aload_1
    //   1793: astore 20
    //   1795: aload_1
    //   1796: astore_3
    //   1797: iload 10
    //   1799: aload 18
    //   1801: iload 8
    //   1803: iload 14
    //   1805: imul
    //   1806: iload 9
    //   1808: iadd
    //   1809: saload
    //   1810: invokestatic 292	java/lang/Math:abs	(I)I
    //   1813: iadd
    //   1814: istore 10
    //   1816: iload 9
    //   1818: iconst_1
    //   1819: iadd
    //   1820: istore 9
    //   1822: goto -37 -> 1785
    //   1825: aload_1
    //   1826: astore 20
    //   1828: aload_1
    //   1829: astore_3
    //   1830: iload 10
    //   1832: iload 14
    //   1834: idiv
    //   1835: istore 9
    //   1837: iload_2
    //   1838: iload 9
    //   1840: if_icmpge +283 -> 2123
    //   1843: iload 9
    //   1845: istore_2
    //   1846: goto +369 -> 2215
    //   1849: aload_1
    //   1850: astore 20
    //   1852: aload_1
    //   1853: astore_3
    //   1854: iload_2
    //   1855: i2d
    //   1856: invokestatic 296	java/lang/Math:sqrt	(D)D
    //   1859: d2f
    //   1860: fstore 4
    //   1862: aload_1
    //   1863: astore 20
    //   1865: aload_1
    //   1866: astore_3
    //   1867: aload_0
    //   1868: monitorenter
    //   1869: fload 5
    //   1871: fconst_0
    //   1872: fcmpg
    //   1873: ifge +21 -> 1894
    //   1876: aload_0
    //   1877: getfield 25	bpso:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1880: fload 4
    //   1882: invokestatic 301	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   1885: invokevirtual 304	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1888: pop
    //   1889: aload_0
    //   1890: monitorexit
    //   1891: goto -1202 -> 689
    //   1894: fload 6
    //   1896: fconst_0
    //   1897: fcmpg
    //   1898: ifge +54 -> 1952
    //   1901: aload_0
    //   1902: getfield 25	bpso:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1905: fload 5
    //   1907: fload 4
    //   1909: fadd
    //   1910: fconst_2
    //   1911: fdiv
    //   1912: invokestatic 301	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   1915: invokevirtual 304	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1918: pop
    //   1919: aload_0
    //   1920: getfield 25	bpso:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1923: fload 4
    //   1925: fload 5
    //   1927: fadd
    //   1928: fconst_2
    //   1929: fdiv
    //   1930: invokestatic 301	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   1933: invokevirtual 304	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1936: pop
    //   1937: goto -48 -> 1889
    //   1940: astore 18
    //   1942: aload_0
    //   1943: monitorexit
    //   1944: aload_1
    //   1945: astore 20
    //   1947: aload_1
    //   1948: astore_3
    //   1949: aload 18
    //   1951: athrow
    //   1952: aload_0
    //   1953: getfield 25	bpso:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1956: fload 6
    //   1958: fload 5
    //   1960: fadd
    //   1961: fload 4
    //   1963: fadd
    //   1964: ldc_w 305
    //   1967: fdiv
    //   1968: invokestatic 301	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   1971: invokevirtual 304	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1974: pop
    //   1975: aload_0
    //   1976: getfield 25	bpso:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1979: fload 4
    //   1981: fload 5
    //   1983: fadd
    //   1984: fconst_2
    //   1985: fdiv
    //   1986: invokestatic 301	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   1989: invokevirtual 304	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1992: pop
    //   1993: goto -104 -> 1889
    //   1996: aload_1
    //   1997: astore 20
    //   1999: aload_1
    //   2000: astore_3
    //   2001: aload_0
    //   2002: monitorenter
    //   2003: aload_0
    //   2004: getfield 25	bpso:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   2007: fload 4
    //   2009: fload 5
    //   2011: fadd
    //   2012: fconst_2
    //   2013: fdiv
    //   2014: invokestatic 301	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   2017: invokevirtual 304	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2020: pop
    //   2021: aload_0
    //   2022: monitorexit
    //   2023: goto -1334 -> 689
    //   2026: astore 18
    //   2028: aload_0
    //   2029: monitorexit
    //   2030: aload_1
    //   2031: astore 20
    //   2033: aload_1
    //   2034: astore_3
    //   2035: aload 18
    //   2037: athrow
    //   2038: fload 6
    //   2040: fstore 7
    //   2042: aload 18
    //   2044: astore_3
    //   2045: aload 19
    //   2047: astore 20
    //   2049: iload 8
    //   2051: istore 10
    //   2053: aload 21
    //   2055: astore 18
    //   2057: iload 9
    //   2059: istore 8
    //   2061: iload 10
    //   2063: istore 9
    //   2065: fload 4
    //   2067: fstore 6
    //   2069: fload 7
    //   2071: fstore 4
    //   2073: aload_3
    //   2074: astore 19
    //   2076: aload 20
    //   2078: astore_3
    //   2079: goto -1658 -> 421
    //   2082: astore 18
    //   2084: aload_1
    //   2085: astore_3
    //   2086: aload 18
    //   2088: astore_1
    //   2089: goto -443 -> 1646
    //   2092: astore_3
    //   2093: aload_1
    //   2094: astore 20
    //   2096: aload_3
    //   2097: astore_1
    //   2098: goto -873 -> 1225
    //   2101: goto -1605 -> 496
    //   2104: iload 9
    //   2106: istore 10
    //   2108: aload 18
    //   2110: astore 21
    //   2112: iload 8
    //   2114: istore 9
    //   2116: iload 10
    //   2118: istore 8
    //   2120: goto -1606 -> 514
    //   2123: goto +92 -> 2215
    //   2126: goto +80 -> 2206
    //   2129: goto +39 -> 2168
    //   2132: fload 4
    //   2134: fstore 7
    //   2136: aload 19
    //   2138: astore 18
    //   2140: aload 22
    //   2142: astore 19
    //   2144: iload 10
    //   2146: istore_2
    //   2147: fload 6
    //   2149: fstore 4
    //   2151: fload 7
    //   2153: fstore 6
    //   2155: goto -863 -> 1292
    //   2158: goto -1279 -> 879
    //   2161: aload 18
    //   2163: astore 23
    //   2165: goto -2080 -> 85
    //   2168: iload 11
    //   2170: iconst_1
    //   2171: iadd
    //   2172: istore 11
    //   2174: goto -1154 -> 1020
    //   2177: iload 12
    //   2179: bipush 254
    //   2181: if_icmpne +3 -> 2184
    //   2184: aload 19
    //   2186: astore 18
    //   2188: fload 4
    //   2190: fstore 7
    //   2192: fload 6
    //   2194: fstore 4
    //   2196: fload 7
    //   2198: fstore 6
    //   2200: aload_3
    //   2201: astore 19
    //   2203: goto -911 -> 1292
    //   2206: iload 8
    //   2208: iconst_1
    //   2209: iadd
    //   2210: istore 8
    //   2212: goto -776 -> 1436
    //   2215: iload 8
    //   2217: iconst_1
    //   2218: iadd
    //   2219: istore 8
    //   2221: goto -458 -> 1763
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2224	0	this	bpso
    //   0	2224	1	paramFile	File
    //   0	2224	2	paramInt	int
    //   0	2224	3	paramMusicItemInfo	MusicItemInfo
    //   405	1790	4	f1	float
    //   401	1609	5	f2	float
    //   419	1780	6	f3	float
    //   1141	1056	7	f4	float
    //   36	2184	8	i	int
    //   30	2085	9	j	int
    //   429	1716	10	k	int
    //   452	1721	11	m	int
    //   524	1658	12	n	int
    //   609	483	13	i1	int
    //   181	1654	14	i2	int
    //   14	770	15	i3	int
    //   228	1096	16	i4	int
    //   919	68	17	i5	int
    //   33	650	18	localObject1	Object
    //   838	39	18	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   1212	10	18	localObject2	Object
    //   1275	1	18	arrayOfByteBuffer1	java.nio.ByteBuffer[]
    //   1633	10	18	localObject3	Object
    //   1698	102	18	arrayOfShort1	short[]
    //   1940	10	18	localObject4	Object
    //   2026	17	18	localObject5	Object
    //   2055	1	18	localObject6	Object
    //   2082	27	18	localObject7	Object
    //   2138	49	18	localObject8	Object
    //   344	1858	19	localObject9	Object
    //   863	1232	20	localObject10	Object
    //   500	1611	21	localObject11	Object
    //   540	1601	22	localObject12	Object
    //   83	2081	23	localObject13	Object
    //   7	1645	24	localMediaExtractor	android.media.MediaExtractor
    //   315	1347	25	localMediaCodec	android.media.MediaCodec
    //   337	107	26	arrayOfByteBuffer2	java.nio.ByteBuffer[]
    //   353	945	27	localBufferInfo	android.media.MediaCodec.BufferInfo
    //   392	1081	28	arrayOfShort2	short[]
    // Exception table:
    //   from	to	target	type
    //   16	25	119	java/io/IOException
    //   369	378	711	finally
    //   712	714	711	finally
    //   678	684	838	java/lang/OutOfMemoryError
    //   1137	1139	1212	finally
    //   1165	1183	1212	finally
    //   1186	1209	1212	finally
    //   1214	1216	1212	finally
    //   868	876	1224	android/media/MediaCodec$CryptoException
    //   884	897	1224	android/media/MediaCodec$CryptoException
    //   902	910	1224	android/media/MediaCodec$CryptoException
    //   915	921	1224	android/media/MediaCodec$CryptoException
    //   926	945	1224	android/media/MediaCodec$CryptoException
    //   950	959	1224	android/media/MediaCodec$CryptoException
    //   964	980	1224	android/media/MediaCodec$CryptoException
    //   985	992	1224	android/media/MediaCodec$CryptoException
    //   997	1015	1224	android/media/MediaCodec$CryptoException
    //   1025	1036	1224	android/media/MediaCodec$CryptoException
    //   1054	1073	1224	android/media/MediaCodec$CryptoException
    //   1087	1094	1224	android/media/MediaCodec$CryptoException
    //   1111	1119	1224	android/media/MediaCodec$CryptoException
    //   1124	1126	1224	android/media/MediaCodec$CryptoException
    //   1221	1224	1224	android/media/MediaCodec$CryptoException
    //   1297	1307	1224	android/media/MediaCodec$CryptoException
    //   1312	1326	1224	android/media/MediaCodec$CryptoException
    //   1331	1337	1224	android/media/MediaCodec$CryptoException
    //   1342	1361	1224	android/media/MediaCodec$CryptoException
    //   1366	1375	1224	android/media/MediaCodec$CryptoException
    //   1380	1396	1224	android/media/MediaCodec$CryptoException
    //   1401	1408	1224	android/media/MediaCodec$CryptoException
    //   1413	1431	1224	android/media/MediaCodec$CryptoException
    //   1441	1452	1224	android/media/MediaCodec$CryptoException
    //   1470	1489	1224	android/media/MediaCodec$CryptoException
    //   1503	1510	1224	android/media/MediaCodec$CryptoException
    //   1527	1536	1224	android/media/MediaCodec$CryptoException
    //   1541	1543	1224	android/media/MediaCodec$CryptoException
    //   1642	1645	1224	android/media/MediaCodec$CryptoException
    //   1673	1682	1224	android/media/MediaCodec$CryptoException
    //   1687	1700	1224	android/media/MediaCodec$CryptoException
    //   1705	1714	1224	android/media/MediaCodec$CryptoException
    //   1719	1735	1224	android/media/MediaCodec$CryptoException
    //   1740	1747	1224	android/media/MediaCodec$CryptoException
    //   1752	1758	1224	android/media/MediaCodec$CryptoException
    //   1768	1779	1224	android/media/MediaCodec$CryptoException
    //   1797	1816	1224	android/media/MediaCodec$CryptoException
    //   1830	1837	1224	android/media/MediaCodec$CryptoException
    //   1854	1862	1224	android/media/MediaCodec$CryptoException
    //   1867	1869	1224	android/media/MediaCodec$CryptoException
    //   1949	1952	1224	android/media/MediaCodec$CryptoException
    //   2001	2003	1224	android/media/MediaCodec$CryptoException
    //   2035	2038	1224	android/media/MediaCodec$CryptoException
    //   1554	1556	1633	finally
    //   1578	1596	1633	finally
    //   1603	1626	1633	finally
    //   1635	1637	1633	finally
    //   868	876	1645	finally
    //   884	897	1645	finally
    //   902	910	1645	finally
    //   915	921	1645	finally
    //   926	945	1645	finally
    //   950	959	1645	finally
    //   964	980	1645	finally
    //   985	992	1645	finally
    //   997	1015	1645	finally
    //   1025	1036	1645	finally
    //   1054	1073	1645	finally
    //   1087	1094	1645	finally
    //   1111	1119	1645	finally
    //   1124	1126	1645	finally
    //   1221	1224	1645	finally
    //   1228	1239	1645	finally
    //   1297	1307	1645	finally
    //   1312	1326	1645	finally
    //   1331	1337	1645	finally
    //   1342	1361	1645	finally
    //   1366	1375	1645	finally
    //   1380	1396	1645	finally
    //   1401	1408	1645	finally
    //   1413	1431	1645	finally
    //   1441	1452	1645	finally
    //   1470	1489	1645	finally
    //   1503	1510	1645	finally
    //   1527	1536	1645	finally
    //   1541	1543	1645	finally
    //   1642	1645	1645	finally
    //   1673	1682	1645	finally
    //   1687	1700	1645	finally
    //   1705	1714	1645	finally
    //   1719	1735	1645	finally
    //   1740	1747	1645	finally
    //   1752	1758	1645	finally
    //   1768	1779	1645	finally
    //   1797	1816	1645	finally
    //   1830	1837	1645	finally
    //   1854	1862	1645	finally
    //   1867	1869	1645	finally
    //   1949	1952	1645	finally
    //   2001	2003	1645	finally
    //   2035	2038	1645	finally
    //   1876	1889	1940	finally
    //   1889	1891	1940	finally
    //   1901	1937	1940	finally
    //   1942	1944	1940	finally
    //   1952	1993	1940	finally
    //   2003	2023	2026	finally
    //   2028	2030	2026	finally
    //   421	431	2082	finally
    //   441	477	2082	finally
    //   483	489	2082	finally
    //   496	502	2082	finally
    //   514	526	2082	finally
    //   531	539	2082	finally
    //   545	567	2082	finally
    //   567	631	2082	finally
    //   634	656	2082	finally
    //   678	684	2082	finally
    //   721	734	2082	finally
    //   740	762	2082	finally
    //   769	816	2082	finally
    //   849	861	2082	finally
    //   1270	1277	2082	finally
    //   421	431	2092	android/media/MediaCodec$CryptoException
    //   441	477	2092	android/media/MediaCodec$CryptoException
    //   483	489	2092	android/media/MediaCodec$CryptoException
    //   496	502	2092	android/media/MediaCodec$CryptoException
    //   514	526	2092	android/media/MediaCodec$CryptoException
    //   531	539	2092	android/media/MediaCodec$CryptoException
    //   545	567	2092	android/media/MediaCodec$CryptoException
    //   567	631	2092	android/media/MediaCodec$CryptoException
    //   634	656	2092	android/media/MediaCodec$CryptoException
    //   678	684	2092	android/media/MediaCodec$CryptoException
    //   721	734	2092	android/media/MediaCodec$CryptoException
    //   740	762	2092	android/media/MediaCodec$CryptoException
    //   769	816	2092	android/media/MediaCodec$CryptoException
    //   849	861	2092	android/media/MediaCodec$CryptoException
    //   1270	1277	2092	android/media/MediaCodec$CryptoException
  }
  
  public static String[] a()
  {
    return new String[] { "mp3", "wav", "3gpp", "3gp", "amr", "aac", "m4a", "ogg" };
  }
  
  public float a(int paramInt)
  {
    int j;
    float f2;
    float f4;
    int k;
    float f1;
    label277:
    float f3;
    for (;;)
    {
      try
      {
        int n = a(paramInt);
        if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() <= n)) {
          return -1.0F;
        }
        j = a(2000);
        int i;
        Object localObject3;
        if (this.jdField_a_of_type_JavaUtilArrayList.size() < j)
        {
          i = this.jdField_a_of_type_JavaUtilArrayList.size();
          paramInt = 0;
          break label277;
          if (j < i)
          {
            f2 = ((Float)this.jdField_a_of_type_JavaUtilArrayList.get(j)).floatValue();
            f4 = localObject3;
            if (f2 >= localObject3) {
              break;
            }
            f4 = localObject3;
            if (f2 <= 0.0F) {
              break;
            }
            f4 = f2;
            break;
          }
        }
        else
        {
          paramInt = n - j / 2;
          if (paramInt < 0)
          {
            i = j;
            paramInt = 0;
            break label277;
          }
          k = j / 2 + n;
          i = k;
          if (k <= this.jdField_a_of_type_JavaUtilArrayList.size()) {
            break label277;
          }
          paramInt = this.jdField_a_of_type_JavaUtilArrayList.size();
          i = this.jdField_a_of_type_JavaUtilArrayList.size();
          paramInt -= j;
          break label277;
        }
        Object localObject1;
        if ((localObject3 >= localObject1) || (((Float)this.jdField_a_of_type_JavaUtilArrayList.get(n)).floatValue() <= 0.0F)) {
          return -1.0F;
        }
        Object localObject2;
        f2 = localObject2 / (i - paramInt - k);
        f2 = (((Float)this.jdField_a_of_type_JavaUtilArrayList.get(n)).floatValue() - f2) / (localObject1 - f2);
        f1 = f2;
        if (f2 < 0.0F) {
          f1 = -1.0F;
        }
        return f1;
      }
      finally {}
      f5 = 65535.0F;
      j = paramInt;
      k = 0;
      f3 = 0.0F;
      f1 = 0.0F;
    }
    float f5 = f1;
    if (f2 > f1) {
      f5 = f2;
    }
    f3 += f2;
    if (f2 > 0.0F) {}
    for (int m = 0;; m = 1)
    {
      k += m;
      j += 1;
      f1 = f5;
      f5 = f4;
      break;
    }
  }
  
  public int a()
  {
    return this.c;
  }
  
  public boolean a(MusicItemInfo paramMusicItemInfo, bpsp parambpsp, int paramInt)
  {
    if (paramMusicItemInfo == null) {}
    File localFile;
    String[] arrayOfString;
    do
    {
      return false;
      localFile = new File(paramMusicItemInfo.getLocalPath());
      if (!localFile.exists()) {
        throw new FileNotFoundException(paramMusicItemInfo.getLocalPath());
      }
      arrayOfString = localFile.getName().toLowerCase().split("\\.");
    } while ((arrayOfString.length < 2) || (!Arrays.asList(a()).contains(arrayOfString[(arrayOfString.length - 1)])));
    a(parambpsp);
    return a(localFile, paramInt, paramMusicItemInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpso
 * JD-Core Version:    0.7.0.1
 */