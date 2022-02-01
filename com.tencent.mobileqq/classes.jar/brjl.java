import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class brjl
{
  private int jdField_a_of_type_Int;
  private brjm jdField_a_of_type_Brjm;
  private ArrayList<Float> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public boolean a;
  private int b = 0;
  private int c = 1024;
  
  private int a(int paramInt)
  {
    return (int)(paramInt * 1.0D * this.jdField_a_of_type_Int / (1000.0D * a()) + 0.5D);
  }
  
  private void a(brjm parambrjm)
  {
    this.jdField_a_of_type_Brjm = parambrjm;
  }
  
  /* Error */
  private void a(File paramFile, int paramInt, MusicItemInfo paramMusicItemInfo)
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
    //   42: if_icmpge +2103 -> 2145
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
    //   136: aload_3
    //   137: getfield 117	com/tencent/mobileqq/richmedia/capture/data/MusicItemInfo:musicStart	I
    //   140: iload_2
    //   141: iadd
    //   142: istore 8
    //   144: iload 8
    //   146: ifle +16 -> 162
    //   149: aload 24
    //   151: iload 8
    //   153: i2l
    //   154: ldc2_w 118
    //   157: lmul
    //   158: iconst_2
    //   159: invokevirtual 123	android/media/MediaExtractor:seekTo	(JI)V
    //   162: aload 23
    //   164: ldc 125
    //   166: invokevirtual 129	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   169: istore 14
    //   171: aload_0
    //   172: aload 23
    //   174: ldc 131
    //   176: invokevirtual 129	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   179: putfield 29	brjl:jdField_a_of_type_Int	I
    //   182: aload_3
    //   183: invokevirtual 135	com/tencent/mobileqq/richmedia/capture/data/MusicItemInfo:isMyMusicInfo	()Z
    //   186: ifeq +81 -> 267
    //   189: aload_3
    //   190: getfield 138	com/tencent/mobileqq/richmedia/capture/data/MusicItemInfo:musicEnd	I
    //   193: aload_3
    //   194: getfield 117	com/tencent/mobileqq/richmedia/capture/data/MusicItemInfo:musicStart	I
    //   197: iload_2
    //   198: iadd
    //   199: isub
    //   200: istore_2
    //   201: iload_2
    //   202: i2f
    //   203: ldc 139
    //   205: fdiv
    //   206: aload_0
    //   207: getfield 29	brjl:jdField_a_of_type_Int	I
    //   210: i2f
    //   211: fmul
    //   212: ldc 140
    //   214: fadd
    //   215: f2i
    //   216: istore 16
    //   218: aload_0
    //   219: sipush 1024
    //   222: putfield 18	brjl:c	I
    //   225: fconst_1
    //   226: aload_0
    //   227: getfield 29	brjl:jdField_a_of_type_Int	I
    //   230: i2f
    //   231: fmul
    //   232: aload_0
    //   233: getfield 18	brjl:c	I
    //   236: i2f
    //   237: fdiv
    //   238: ldc 141
    //   240: fcmpg
    //   241: ifge +52 -> 293
    //   244: aload_0
    //   245: getfield 18	brjl:c	I
    //   248: sipush 128
    //   251: if_icmple +42 -> 293
    //   254: aload_0
    //   255: aload_0
    //   256: getfield 18	brjl:c	I
    //   259: iconst_2
    //   260: idiv
    //   261: putfield 18	brjl:c	I
    //   264: goto -39 -> 225
    //   267: aload 23
    //   269: ldc 143
    //   271: invokevirtual 147	android/media/MediaFormat:getLong	(Ljava/lang/String;)J
    //   274: l2f
    //   275: ldc 139
    //   277: fdiv
    //   278: ldc 140
    //   280: fadd
    //   281: f2i
    //   282: aload_3
    //   283: getfield 117	com/tencent/mobileqq/richmedia/capture/data/MusicItemInfo:musicStart	I
    //   286: iload_2
    //   287: iadd
    //   288: isub
    //   289: istore_2
    //   290: goto -89 -> 201
    //   293: aload 23
    //   295: ldc 72
    //   297: invokevirtual 78	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   300: invokestatic 153	android/media/MediaCodec:createDecoderByType	(Ljava/lang/String;)Landroid/media/MediaCodec;
    //   303: astore 25
    //   305: aload 25
    //   307: aload 23
    //   309: aconst_null
    //   310: aconst_null
    //   311: iconst_0
    //   312: invokevirtual 157	android/media/MediaCodec:configure	(Landroid/media/MediaFormat;Landroid/view/Surface;Landroid/media/MediaCrypto;I)V
    //   315: aload 25
    //   317: invokevirtual 160	android/media/MediaCodec:start	()V
    //   320: aload 25
    //   322: invokevirtual 164	android/media/MediaCodec:getInputBuffers	()[Ljava/nio/ByteBuffer;
    //   325: astore 26
    //   327: aload 25
    //   329: invokevirtual 167	android/media/MediaCodec:getOutputBuffers	()[Ljava/nio/ByteBuffer;
    //   332: astore 19
    //   334: new 169	android/media/MediaCodec$BufferInfo
    //   337: dup
    //   338: invokespecial 170	android/media/MediaCodec$BufferInfo:<init>	()V
    //   341: astore 27
    //   343: iconst_0
    //   344: istore 9
    //   346: iconst_0
    //   347: istore 8
    //   349: ldc 171
    //   351: invokestatic 177	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   354: astore_1
    //   355: aload_0
    //   356: monitorenter
    //   357: aload_0
    //   358: getfield 25	brjl:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   361: invokevirtual 180	java/util/ArrayList:clear	()V
    //   364: aload_0
    //   365: monitorexit
    //   366: aload_0
    //   367: iconst_0
    //   368: putfield 20	brjl:b	I
    //   371: aload_0
    //   372: invokevirtual 34	brjl:a	()I
    //   375: iload 14
    //   377: imul
    //   378: newarray short
    //   380: astore 28
    //   382: aload_0
    //   383: iconst_1
    //   384: putfield 182	brjl:jdField_a_of_type_Boolean	Z
    //   387: ldc 183
    //   389: fstore 5
    //   391: ldc 183
    //   393: fstore 4
    //   395: aconst_null
    //   396: astore_3
    //   397: iconst_0
    //   398: istore_2
    //   399: iconst_1
    //   400: invokestatic 189	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   403: astore 18
    //   405: ldc 183
    //   407: fstore 6
    //   409: aload 25
    //   411: ldc2_w 190
    //   414: invokevirtual 195	android/media/MediaCodec:dequeueInputBuffer	(J)I
    //   417: istore 10
    //   419: iload 8
    //   421: ifne +1667 -> 2088
    //   424: iload 10
    //   426: iflt +1662 -> 2088
    //   429: aload 24
    //   431: aload 26
    //   433: iload 10
    //   435: aaload
    //   436: iconst_0
    //   437: invokevirtual 199	android/media/MediaExtractor:readSampleData	(Ljava/nio/ByteBuffer;I)I
    //   440: istore 11
    //   442: aload 18
    //   444: invokevirtual 202	java/lang/Boolean:booleanValue	()Z
    //   447: ifeq +256 -> 703
    //   450: aload 23
    //   452: ldc 72
    //   454: invokevirtual 78	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   457: ldc 204
    //   459: invokevirtual 208	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   462: ifeq +241 -> 703
    //   465: iload 11
    //   467: iconst_2
    //   468: if_icmpne +235 -> 703
    //   471: aload 24
    //   473: invokevirtual 211	android/media/MediaExtractor:advance	()Z
    //   476: pop
    //   477: iload 11
    //   479: iload 9
    //   481: iadd
    //   482: istore 9
    //   484: iconst_0
    //   485: invokestatic 189	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   488: astore 21
    //   490: iload 8
    //   492: istore 10
    //   494: iload 9
    //   496: istore 8
    //   498: iload 10
    //   500: istore 9
    //   502: aload 25
    //   504: aload 27
    //   506: ldc2_w 190
    //   509: invokevirtual 215	android/media/MediaCodec:dequeueOutputBuffer	(Landroid/media/MediaCodec$BufferInfo;J)I
    //   512: istore 12
    //   514: iload 12
    //   516: iflt +731 -> 1247
    //   519: aload 27
    //   521: getfield 218	android/media/MediaCodec$BufferInfo:size	I
    //   524: ifle +723 -> 1247
    //   527: aload_3
    //   528: astore 22
    //   530: iload_2
    //   531: istore 10
    //   533: iload_2
    //   534: aload 27
    //   536: getfield 218	android/media/MediaCodec$BufferInfo:size	I
    //   539: if_icmpge +16 -> 555
    //   542: aload 27
    //   544: getfield 218	android/media/MediaCodec$BufferInfo:size	I
    //   547: istore 10
    //   549: iload 10
    //   551: newarray byte
    //   553: astore 22
    //   555: aload 19
    //   557: iload 12
    //   559: aaload
    //   560: aload 22
    //   562: iconst_0
    //   563: aload 27
    //   565: getfield 218	android/media/MediaCodec$BufferInfo:size	I
    //   568: invokevirtual 222	java/nio/ByteBuffer:get	([BII)Ljava/nio/ByteBuffer;
    //   571: pop
    //   572: aload 19
    //   574: iload 12
    //   576: aaload
    //   577: invokevirtual 225	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   580: pop
    //   581: aload_1
    //   582: invokevirtual 228	java/nio/ByteBuffer:remaining	()I
    //   585: aload 27
    //   587: getfield 218	android/media/MediaCodec$BufferInfo:size	I
    //   590: if_icmpge +1552 -> 2142
    //   593: aload_1
    //   594: invokevirtual 231	java/nio/ByteBuffer:position	()I
    //   597: istore 13
    //   599: iload 13
    //   601: i2d
    //   602: dconst_1
    //   603: iload 15
    //   605: i2d
    //   606: dmul
    //   607: iload 8
    //   609: i2d
    //   610: ddiv
    //   611: dmul
    //   612: ldc2_w 232
    //   615: dmul
    //   616: d2i
    //   617: istore 11
    //   619: iload 11
    //   621: istore_2
    //   622: iload 11
    //   624: iload 13
    //   626: isub
    //   627: aload 27
    //   629: getfield 218	android/media/MediaCodec$BufferInfo:size	I
    //   632: ldc 234
    //   634: iadd
    //   635: if_icmpge +17 -> 652
    //   638: aload 27
    //   640: getfield 218	android/media/MediaCodec$BufferInfo:size	I
    //   643: istore_2
    //   644: iload_2
    //   645: iload 13
    //   647: iadd
    //   648: ldc 234
    //   650: iadd
    //   651: istore_2
    //   652: aconst_null
    //   653: astore_3
    //   654: bipush 10
    //   656: istore 11
    //   658: aload_3
    //   659: astore 18
    //   661: iload 11
    //   663: ifle +9 -> 672
    //   666: iload_2
    //   667: invokestatic 177	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   670: astore 18
    //   672: iload 11
    //   674: ifne +161 -> 835
    //   677: aload_1
    //   678: invokevirtual 225	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   681: pop
    //   682: aload 24
    //   684: invokevirtual 112	android/media/MediaExtractor:release	()V
    //   687: aload 25
    //   689: invokevirtual 237	android/media/MediaCodec:stop	()V
    //   692: aload 25
    //   694: invokevirtual 238	android/media/MediaCodec:release	()V
    //   697: return
    //   698: astore_1
    //   699: aload_0
    //   700: monitorexit
    //   701: aload_1
    //   702: athrow
    //   703: iload 11
    //   705: ifge +22 -> 727
    //   708: aload 25
    //   710: iload 10
    //   712: iconst_0
    //   713: iconst_0
    //   714: ldc2_w 239
    //   717: iconst_4
    //   718: invokevirtual 244	android/media/MediaCodec:queueInputBuffer	(IIIJI)V
    //   721: iconst_1
    //   722: istore 8
    //   724: goto -240 -> 484
    //   727: aload 25
    //   729: iload 10
    //   731: iconst_0
    //   732: iload 11
    //   734: aload 24
    //   736: invokevirtual 247	android/media/MediaExtractor:getSampleTime	()J
    //   739: iconst_0
    //   740: invokevirtual 244	android/media/MediaCodec:queueInputBuffer	(IIIJI)V
    //   743: aload 24
    //   745: invokevirtual 211	android/media/MediaExtractor:advance	()Z
    //   748: pop
    //   749: iload 11
    //   751: iload 9
    //   753: iadd
    //   754: istore 9
    //   756: aload_0
    //   757: getfield 39	brjl:jdField_a_of_type_Brjm	Lbrjm;
    //   760: ifnull +1325 -> 2085
    //   763: aload_0
    //   764: getfield 39	brjl:jdField_a_of_type_Brjm	Lbrjm;
    //   767: iload 9
    //   769: i2f
    //   770: iload 15
    //   772: i2f
    //   773: fdiv
    //   774: f2d
    //   775: invokeinterface 252 3 0
    //   780: ifne +1305 -> 2085
    //   783: aload_1
    //   784: invokevirtual 225	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   787: pop
    //   788: aload 24
    //   790: invokevirtual 112	android/media/MediaExtractor:release	()V
    //   793: aload 25
    //   795: invokevirtual 237	android/media/MediaCodec:stop	()V
    //   798: aload 25
    //   800: invokevirtual 238	android/media/MediaCodec:release	()V
    //   803: aload_1
    //   804: invokevirtual 225	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   807: pop
    //   808: aload 24
    //   810: invokevirtual 112	android/media/MediaExtractor:release	()V
    //   813: aload 25
    //   815: invokevirtual 237	android/media/MediaCodec:stop	()V
    //   818: aload 25
    //   820: invokevirtual 238	android/media/MediaCodec:release	()V
    //   823: return
    //   824: astore 18
    //   826: iload 11
    //   828: iconst_1
    //   829: isub
    //   830: istore 11
    //   832: goto -174 -> 658
    //   835: aload_1
    //   836: invokevirtual 255	java/nio/ByteBuffer:rewind	()Ljava/nio/Buffer;
    //   839: pop
    //   840: aload 18
    //   842: aload_1
    //   843: invokevirtual 259	java/nio/ByteBuffer:put	(Ljava/nio/ByteBuffer;)Ljava/nio/ByteBuffer;
    //   846: pop
    //   847: aload 18
    //   849: astore 20
    //   851: aload 18
    //   853: astore_3
    //   854: aload 18
    //   856: iload 13
    //   858: invokevirtual 262	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   861: pop
    //   862: aload 18
    //   864: astore_1
    //   865: aload_1
    //   866: astore 20
    //   868: aload_1
    //   869: astore_3
    //   870: aload_1
    //   871: aload 22
    //   873: iconst_0
    //   874: aload 27
    //   876: getfield 218	android/media/MediaCodec$BufferInfo:size	I
    //   879: invokevirtual 264	java/nio/ByteBuffer:put	([BII)Ljava/nio/ByteBuffer;
    //   882: pop
    //   883: aload_1
    //   884: astore 20
    //   886: aload_1
    //   887: astore_3
    //   888: aload 25
    //   890: iload 12
    //   892: iconst_0
    //   893: invokevirtual 268	android/media/MediaCodec:releaseOutputBuffer	(IZ)V
    //   896: aload_1
    //   897: astore 20
    //   899: aload_1
    //   900: astore_3
    //   901: aload_1
    //   902: invokevirtual 231	java/nio/ByteBuffer:position	()I
    //   905: istore 17
    //   907: aload_1
    //   908: astore 20
    //   910: aload_1
    //   911: astore_3
    //   912: iload 17
    //   914: aload_0
    //   915: getfield 20	brjl:b	I
    //   918: isub
    //   919: aload_0
    //   920: invokevirtual 34	brjl:a	()I
    //   923: iconst_2
    //   924: imul
    //   925: iload 14
    //   927: imul
    //   928: if_icmple +1188 -> 2116
    //   931: aload_1
    //   932: astore 20
    //   934: aload_1
    //   935: astore_3
    //   936: aload_1
    //   937: aload_0
    //   938: getfield 20	brjl:b	I
    //   941: invokevirtual 262	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   944: pop
    //   945: aload_1
    //   946: astore 20
    //   948: aload_1
    //   949: astore_3
    //   950: aload_1
    //   951: getstatic 274	java/nio/ByteOrder:LITTLE_ENDIAN	Ljava/nio/ByteOrder;
    //   954: invokevirtual 278	java/nio/ByteBuffer:order	(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    //   957: invokevirtual 282	java/nio/ByteBuffer:asShortBuffer	()Ljava/nio/ShortBuffer;
    //   960: aload 28
    //   962: invokevirtual 287	java/nio/ShortBuffer:get	([S)Ljava/nio/ShortBuffer;
    //   965: pop
    //   966: aload_1
    //   967: astore 20
    //   969: aload_1
    //   970: astore_3
    //   971: aload_1
    //   972: iload 17
    //   974: invokevirtual 262	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   977: pop
    //   978: aload_1
    //   979: astore 20
    //   981: aload_1
    //   982: astore_3
    //   983: aload_0
    //   984: aload_0
    //   985: getfield 20	brjl:b	I
    //   988: aload_0
    //   989: invokevirtual 34	brjl:a	()I
    //   992: iconst_2
    //   993: imul
    //   994: iload 14
    //   996: imul
    //   997: iadd
    //   998: putfield 20	brjl:b	I
    //   1001: iconst_m1
    //   1002: istore_2
    //   1003: iconst_0
    //   1004: istore 11
    //   1006: aload_1
    //   1007: astore 20
    //   1009: aload_1
    //   1010: astore_3
    //   1011: iload 11
    //   1013: aload 28
    //   1015: arraylength
    //   1016: iload 14
    //   1018: idiv
    //   1019: if_icmpge +73 -> 1092
    //   1022: iconst_0
    //   1023: istore 13
    //   1025: iconst_0
    //   1026: istore 12
    //   1028: iload 12
    //   1030: iload 14
    //   1032: if_icmpge +36 -> 1068
    //   1035: aload_1
    //   1036: astore 20
    //   1038: aload_1
    //   1039: astore_3
    //   1040: iload 13
    //   1042: aload 28
    //   1044: iload 11
    //   1046: iload 14
    //   1048: imul
    //   1049: iload 12
    //   1051: iadd
    //   1052: saload
    //   1053: invokestatic 292	java/lang/Math:abs	(I)I
    //   1056: iadd
    //   1057: istore 13
    //   1059: iload 12
    //   1061: iconst_1
    //   1062: iadd
    //   1063: istore 12
    //   1065: goto -37 -> 1028
    //   1068: aload_1
    //   1069: astore 20
    //   1071: aload_1
    //   1072: astore_3
    //   1073: iload 13
    //   1075: iload 14
    //   1077: idiv
    //   1078: istore 12
    //   1080: iload_2
    //   1081: iload 12
    //   1083: if_icmpge +1030 -> 2113
    //   1086: iload 12
    //   1088: istore_2
    //   1089: goto +1063 -> 2152
    //   1092: aload_1
    //   1093: astore 20
    //   1095: aload_1
    //   1096: astore_3
    //   1097: iload_2
    //   1098: i2d
    //   1099: invokestatic 296	java/lang/Math:sqrt	(D)D
    //   1102: d2f
    //   1103: fstore 6
    //   1105: aload_1
    //   1106: astore 20
    //   1108: aload_1
    //   1109: astore_3
    //   1110: aload_0
    //   1111: monitorenter
    //   1112: fload 5
    //   1114: fconst_0
    //   1115: fcmpg
    //   1116: ifge +28 -> 1144
    //   1119: fload 4
    //   1121: fstore 5
    //   1123: aload_0
    //   1124: monitorexit
    //   1125: fload 6
    //   1127: fstore 7
    //   1129: fload 5
    //   1131: fstore 4
    //   1133: fload 6
    //   1135: fstore 5
    //   1137: fload 7
    //   1139: fstore 6
    //   1141: goto -234 -> 907
    //   1144: fload 4
    //   1146: fconst_0
    //   1147: fcmpg
    //   1148: ifge +24 -> 1172
    //   1151: aload_0
    //   1152: getfield 25	brjl:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1155: fload 5
    //   1157: fload 6
    //   1159: fadd
    //   1160: fconst_2
    //   1161: fdiv
    //   1162: invokestatic 301	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   1165: invokevirtual 304	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1168: pop
    //   1169: goto -46 -> 1123
    //   1172: aload_0
    //   1173: getfield 25	brjl:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1176: fload 4
    //   1178: fload 5
    //   1180: fadd
    //   1181: fload 6
    //   1183: fadd
    //   1184: ldc_w 305
    //   1187: fdiv
    //   1188: invokestatic 301	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   1191: invokevirtual 304	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1194: pop
    //   1195: goto -72 -> 1123
    //   1198: astore 18
    //   1200: aload_0
    //   1201: monitorexit
    //   1202: aload_1
    //   1203: astore 20
    //   1205: aload_1
    //   1206: astore_3
    //   1207: aload 18
    //   1209: athrow
    //   1210: astore_1
    //   1211: aload 20
    //   1213: astore_3
    //   1214: ldc_w 307
    //   1217: iconst_1
    //   1218: ldc_w 309
    //   1221: aload_1
    //   1222: invokestatic 315	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1225: aload 20
    //   1227: invokevirtual 225	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   1230: pop
    //   1231: aload 24
    //   1233: invokevirtual 112	android/media/MediaExtractor:release	()V
    //   1236: aload 25
    //   1238: invokevirtual 237	android/media/MediaCodec:stop	()V
    //   1241: aload 25
    //   1243: invokevirtual 238	android/media/MediaCodec:release	()V
    //   1246: return
    //   1247: iload 12
    //   1249: bipush 253
    //   1251: if_icmpne +910 -> 2161
    //   1254: aload 25
    //   1256: invokevirtual 167	android/media/MediaCodec:getOutputBuffers	()[Ljava/nio/ByteBuffer;
    //   1259: astore 18
    //   1261: fload 6
    //   1263: fstore 7
    //   1265: aload_3
    //   1266: astore 19
    //   1268: fload 4
    //   1270: fstore 6
    //   1272: fload 7
    //   1274: fstore 4
    //   1276: aload_1
    //   1277: astore 20
    //   1279: aload_1
    //   1280: astore_3
    //   1281: aload 27
    //   1283: getfield 318	android/media/MediaCodec$BufferInfo:flags	I
    //   1286: iconst_4
    //   1287: iand
    //   1288: ifne +22 -> 1310
    //   1291: aload_1
    //   1292: astore 20
    //   1294: aload_1
    //   1295: astore_3
    //   1296: aload_1
    //   1297: invokevirtual 231	java/nio/ByteBuffer:position	()I
    //   1300: iload 14
    //   1302: iconst_2
    //   1303: imul
    //   1304: idiv
    //   1305: iload 16
    //   1307: if_icmplt +715 -> 2022
    //   1310: aload_1
    //   1311: astore 20
    //   1313: aload_1
    //   1314: astore_3
    //   1315: aload_1
    //   1316: invokevirtual 231	java/nio/ByteBuffer:position	()I
    //   1319: istore 11
    //   1321: aload_1
    //   1322: astore 20
    //   1324: aload_1
    //   1325: astore_3
    //   1326: iload 11
    //   1328: aload_0
    //   1329: getfield 20	brjl:b	I
    //   1332: isub
    //   1333: aload_0
    //   1334: invokevirtual 34	brjl:a	()I
    //   1337: iconst_2
    //   1338: imul
    //   1339: iload 14
    //   1341: imul
    //   1342: if_icmple +310 -> 1652
    //   1345: aload_1
    //   1346: astore 20
    //   1348: aload_1
    //   1349: astore_3
    //   1350: aload_1
    //   1351: aload_0
    //   1352: getfield 20	brjl:b	I
    //   1355: invokevirtual 262	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   1358: pop
    //   1359: aload_1
    //   1360: astore 20
    //   1362: aload_1
    //   1363: astore_3
    //   1364: aload_1
    //   1365: getstatic 274	java/nio/ByteOrder:LITTLE_ENDIAN	Ljava/nio/ByteOrder;
    //   1368: invokevirtual 278	java/nio/ByteBuffer:order	(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    //   1371: invokevirtual 282	java/nio/ByteBuffer:asShortBuffer	()Ljava/nio/ShortBuffer;
    //   1374: aload 28
    //   1376: invokevirtual 287	java/nio/ShortBuffer:get	([S)Ljava/nio/ShortBuffer;
    //   1379: pop
    //   1380: aload_1
    //   1381: astore 20
    //   1383: aload_1
    //   1384: astore_3
    //   1385: aload_1
    //   1386: iload 11
    //   1388: invokevirtual 262	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   1391: pop
    //   1392: aload_1
    //   1393: astore 20
    //   1395: aload_1
    //   1396: astore_3
    //   1397: aload_0
    //   1398: aload_0
    //   1399: getfield 20	brjl:b	I
    //   1402: aload_0
    //   1403: invokevirtual 34	brjl:a	()I
    //   1406: iconst_2
    //   1407: imul
    //   1408: iload 14
    //   1410: imul
    //   1411: iadd
    //   1412: putfield 20	brjl:b	I
    //   1415: iconst_m1
    //   1416: istore_2
    //   1417: iconst_0
    //   1418: istore 8
    //   1420: aload_1
    //   1421: astore 20
    //   1423: aload_1
    //   1424: astore_3
    //   1425: iload 8
    //   1427: aload 28
    //   1429: arraylength
    //   1430: iload 14
    //   1432: idiv
    //   1433: if_icmpge +73 -> 1506
    //   1436: iconst_0
    //   1437: istore 10
    //   1439: iconst_0
    //   1440: istore 9
    //   1442: iload 9
    //   1444: iload 14
    //   1446: if_icmpge +36 -> 1482
    //   1449: aload_1
    //   1450: astore 20
    //   1452: aload_1
    //   1453: astore_3
    //   1454: iload 10
    //   1456: aload 28
    //   1458: iload 8
    //   1460: iload 14
    //   1462: imul
    //   1463: iload 9
    //   1465: iadd
    //   1466: saload
    //   1467: invokestatic 292	java/lang/Math:abs	(I)I
    //   1470: iadd
    //   1471: istore 10
    //   1473: iload 9
    //   1475: iconst_1
    //   1476: iadd
    //   1477: istore 9
    //   1479: goto -37 -> 1442
    //   1482: aload_1
    //   1483: astore 20
    //   1485: aload_1
    //   1486: astore_3
    //   1487: iload 10
    //   1489: iload 14
    //   1491: idiv
    //   1492: istore 9
    //   1494: iload_2
    //   1495: iload 9
    //   1497: if_icmpge +613 -> 2110
    //   1500: iload 9
    //   1502: istore_2
    //   1503: goto +687 -> 2190
    //   1506: aload_1
    //   1507: astore 20
    //   1509: aload_1
    //   1510: astore_3
    //   1511: iload_2
    //   1512: i2d
    //   1513: invokestatic 296	java/lang/Math:sqrt	(D)D
    //   1516: d2i
    //   1517: i2f
    //   1518: fstore 7
    //   1520: aload_1
    //   1521: astore 20
    //   1523: aload_1
    //   1524: astore_3
    //   1525: aload_0
    //   1526: monitorenter
    //   1527: fload 5
    //   1529: fconst_0
    //   1530: fcmpg
    //   1531: ifge +24 -> 1555
    //   1534: fload 6
    //   1536: fstore 4
    //   1538: aload_0
    //   1539: monitorexit
    //   1540: fload 7
    //   1542: fstore 5
    //   1544: fload 4
    //   1546: fstore 6
    //   1548: fload 7
    //   1550: fstore 4
    //   1552: goto -231 -> 1321
    //   1555: fload 6
    //   1557: fconst_0
    //   1558: fcmpg
    //   1559: ifge +28 -> 1587
    //   1562: aload_0
    //   1563: getfield 25	brjl:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1566: fload 5
    //   1568: fload 7
    //   1570: fadd
    //   1571: fconst_2
    //   1572: fdiv
    //   1573: invokestatic 301	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   1576: invokevirtual 304	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1579: pop
    //   1580: fload 5
    //   1582: fstore 4
    //   1584: goto -46 -> 1538
    //   1587: aload_0
    //   1588: getfield 25	brjl:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1591: fload 6
    //   1593: fload 5
    //   1595: fadd
    //   1596: fload 7
    //   1598: fadd
    //   1599: ldc_w 305
    //   1602: fdiv
    //   1603: invokestatic 301	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   1606: invokevirtual 304	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1609: pop
    //   1610: fload 5
    //   1612: fstore 4
    //   1614: goto -76 -> 1538
    //   1617: astore 18
    //   1619: aload_0
    //   1620: monitorexit
    //   1621: aload_1
    //   1622: astore 20
    //   1624: aload_1
    //   1625: astore_3
    //   1626: aload 18
    //   1628: athrow
    //   1629: astore_1
    //   1630: aload_3
    //   1631: invokevirtual 225	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   1634: pop
    //   1635: aload 24
    //   1637: invokevirtual 112	android/media/MediaExtractor:release	()V
    //   1640: aload 25
    //   1642: invokevirtual 237	android/media/MediaCodec:stop	()V
    //   1645: aload 25
    //   1647: invokevirtual 238	android/media/MediaCodec:release	()V
    //   1650: aload_1
    //   1651: athrow
    //   1652: aload_1
    //   1653: astore 20
    //   1655: aload_1
    //   1656: astore_3
    //   1657: iload 11
    //   1659: aload_0
    //   1660: getfield 20	brjl:b	I
    //   1663: if_icmple +317 -> 1980
    //   1666: aload_1
    //   1667: astore 20
    //   1669: aload_1
    //   1670: astore_3
    //   1671: iload 11
    //   1673: aload_0
    //   1674: getfield 20	brjl:b	I
    //   1677: isub
    //   1678: iconst_2
    //   1679: idiv
    //   1680: newarray short
    //   1682: astore 18
    //   1684: aload_1
    //   1685: astore 20
    //   1687: aload_1
    //   1688: astore_3
    //   1689: aload_1
    //   1690: aload_0
    //   1691: getfield 20	brjl:b	I
    //   1694: invokevirtual 262	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   1697: pop
    //   1698: aload_1
    //   1699: astore 20
    //   1701: aload_1
    //   1702: astore_3
    //   1703: aload_1
    //   1704: getstatic 274	java/nio/ByteOrder:LITTLE_ENDIAN	Ljava/nio/ByteOrder;
    //   1707: invokevirtual 278	java/nio/ByteBuffer:order	(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    //   1710: invokevirtual 282	java/nio/ByteBuffer:asShortBuffer	()Ljava/nio/ShortBuffer;
    //   1713: aload 18
    //   1715: invokevirtual 287	java/nio/ShortBuffer:get	([S)Ljava/nio/ShortBuffer;
    //   1718: pop
    //   1719: aload_1
    //   1720: astore 20
    //   1722: aload_1
    //   1723: astore_3
    //   1724: aload_1
    //   1725: iload 11
    //   1727: invokevirtual 262	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   1730: pop
    //   1731: aload_1
    //   1732: astore 20
    //   1734: aload_1
    //   1735: astore_3
    //   1736: aload_0
    //   1737: iload 11
    //   1739: putfield 20	brjl:b	I
    //   1742: iconst_m1
    //   1743: istore_2
    //   1744: iconst_0
    //   1745: istore 8
    //   1747: aload_1
    //   1748: astore 20
    //   1750: aload_1
    //   1751: astore_3
    //   1752: iload 8
    //   1754: aload 18
    //   1756: arraylength
    //   1757: iload 14
    //   1759: idiv
    //   1760: if_icmpge +73 -> 1833
    //   1763: iconst_0
    //   1764: istore 10
    //   1766: iconst_0
    //   1767: istore 9
    //   1769: iload 9
    //   1771: iload 14
    //   1773: if_icmpge +36 -> 1809
    //   1776: aload_1
    //   1777: astore 20
    //   1779: aload_1
    //   1780: astore_3
    //   1781: iload 10
    //   1783: aload 18
    //   1785: iload 8
    //   1787: iload 14
    //   1789: imul
    //   1790: iload 9
    //   1792: iadd
    //   1793: saload
    //   1794: invokestatic 292	java/lang/Math:abs	(I)I
    //   1797: iadd
    //   1798: istore 10
    //   1800: iload 9
    //   1802: iconst_1
    //   1803: iadd
    //   1804: istore 9
    //   1806: goto -37 -> 1769
    //   1809: aload_1
    //   1810: astore 20
    //   1812: aload_1
    //   1813: astore_3
    //   1814: iload 10
    //   1816: iload 14
    //   1818: idiv
    //   1819: istore 9
    //   1821: iload_2
    //   1822: iload 9
    //   1824: if_icmpge +283 -> 2107
    //   1827: iload 9
    //   1829: istore_2
    //   1830: goto +369 -> 2199
    //   1833: aload_1
    //   1834: astore 20
    //   1836: aload_1
    //   1837: astore_3
    //   1838: iload_2
    //   1839: i2d
    //   1840: invokestatic 296	java/lang/Math:sqrt	(D)D
    //   1843: d2f
    //   1844: fstore 4
    //   1846: aload_1
    //   1847: astore 20
    //   1849: aload_1
    //   1850: astore_3
    //   1851: aload_0
    //   1852: monitorenter
    //   1853: fload 5
    //   1855: fconst_0
    //   1856: fcmpg
    //   1857: ifge +21 -> 1878
    //   1860: aload_0
    //   1861: getfield 25	brjl:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1864: fload 4
    //   1866: invokestatic 301	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   1869: invokevirtual 304	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1872: pop
    //   1873: aload_0
    //   1874: monitorexit
    //   1875: goto -1198 -> 677
    //   1878: fload 6
    //   1880: fconst_0
    //   1881: fcmpg
    //   1882: ifge +54 -> 1936
    //   1885: aload_0
    //   1886: getfield 25	brjl:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1889: fload 5
    //   1891: fload 4
    //   1893: fadd
    //   1894: fconst_2
    //   1895: fdiv
    //   1896: invokestatic 301	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   1899: invokevirtual 304	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1902: pop
    //   1903: aload_0
    //   1904: getfield 25	brjl:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1907: fload 4
    //   1909: fload 5
    //   1911: fadd
    //   1912: fconst_2
    //   1913: fdiv
    //   1914: invokestatic 301	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   1917: invokevirtual 304	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1920: pop
    //   1921: goto -48 -> 1873
    //   1924: astore 18
    //   1926: aload_0
    //   1927: monitorexit
    //   1928: aload_1
    //   1929: astore 20
    //   1931: aload_1
    //   1932: astore_3
    //   1933: aload 18
    //   1935: athrow
    //   1936: aload_0
    //   1937: getfield 25	brjl:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1940: fload 6
    //   1942: fload 5
    //   1944: fadd
    //   1945: fload 4
    //   1947: fadd
    //   1948: ldc_w 305
    //   1951: fdiv
    //   1952: invokestatic 301	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   1955: invokevirtual 304	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1958: pop
    //   1959: aload_0
    //   1960: getfield 25	brjl:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1963: fload 4
    //   1965: fload 5
    //   1967: fadd
    //   1968: fconst_2
    //   1969: fdiv
    //   1970: invokestatic 301	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   1973: invokevirtual 304	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1976: pop
    //   1977: goto -104 -> 1873
    //   1980: aload_1
    //   1981: astore 20
    //   1983: aload_1
    //   1984: astore_3
    //   1985: aload_0
    //   1986: monitorenter
    //   1987: aload_0
    //   1988: getfield 25	brjl:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1991: fload 4
    //   1993: fload 5
    //   1995: fadd
    //   1996: fconst_2
    //   1997: fdiv
    //   1998: invokestatic 301	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   2001: invokevirtual 304	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2004: pop
    //   2005: aload_0
    //   2006: monitorexit
    //   2007: goto -1330 -> 677
    //   2010: astore 18
    //   2012: aload_0
    //   2013: monitorexit
    //   2014: aload_1
    //   2015: astore 20
    //   2017: aload_1
    //   2018: astore_3
    //   2019: aload 18
    //   2021: athrow
    //   2022: fload 6
    //   2024: fstore 7
    //   2026: aload 18
    //   2028: astore_3
    //   2029: aload 19
    //   2031: astore 20
    //   2033: iload 8
    //   2035: istore 10
    //   2037: aload 21
    //   2039: astore 18
    //   2041: iload 9
    //   2043: istore 8
    //   2045: iload 10
    //   2047: istore 9
    //   2049: fload 4
    //   2051: fstore 6
    //   2053: fload 7
    //   2055: fstore 4
    //   2057: aload_3
    //   2058: astore 19
    //   2060: aload 20
    //   2062: astore_3
    //   2063: goto -1654 -> 409
    //   2066: astore 18
    //   2068: aload_1
    //   2069: astore_3
    //   2070: aload 18
    //   2072: astore_1
    //   2073: goto -443 -> 1630
    //   2076: astore_3
    //   2077: aload_1
    //   2078: astore 20
    //   2080: aload_3
    //   2081: astore_1
    //   2082: goto -871 -> 1211
    //   2085: goto -1601 -> 484
    //   2088: iload 9
    //   2090: istore 10
    //   2092: aload 18
    //   2094: astore 21
    //   2096: iload 8
    //   2098: istore 9
    //   2100: iload 10
    //   2102: istore 8
    //   2104: goto -1602 -> 502
    //   2107: goto +92 -> 2199
    //   2110: goto +80 -> 2190
    //   2113: goto +39 -> 2152
    //   2116: fload 4
    //   2118: fstore 7
    //   2120: aload 19
    //   2122: astore 18
    //   2124: aload 22
    //   2126: astore 19
    //   2128: iload 10
    //   2130: istore_2
    //   2131: fload 6
    //   2133: fstore 4
    //   2135: fload 7
    //   2137: fstore 6
    //   2139: goto -863 -> 1276
    //   2142: goto -1277 -> 865
    //   2145: aload 18
    //   2147: astore 23
    //   2149: goto -2064 -> 85
    //   2152: iload 11
    //   2154: iconst_1
    //   2155: iadd
    //   2156: istore 11
    //   2158: goto -1152 -> 1006
    //   2161: iload 12
    //   2163: bipush 254
    //   2165: if_icmpne +3 -> 2168
    //   2168: aload 19
    //   2170: astore 18
    //   2172: fload 4
    //   2174: fstore 7
    //   2176: fload 6
    //   2178: fstore 4
    //   2180: fload 7
    //   2182: fstore 6
    //   2184: aload_3
    //   2185: astore 19
    //   2187: goto -911 -> 1276
    //   2190: iload 8
    //   2192: iconst_1
    //   2193: iadd
    //   2194: istore 8
    //   2196: goto -776 -> 1420
    //   2199: iload 8
    //   2201: iconst_1
    //   2202: iadd
    //   2203: istore 8
    //   2205: goto -458 -> 1747
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2208	0	this	brjl
    //   0	2208	1	paramFile	File
    //   0	2208	2	paramInt	int
    //   0	2208	3	paramMusicItemInfo	MusicItemInfo
    //   393	1786	4	f1	float
    //   389	1605	5	f2	float
    //   407	1776	6	f3	float
    //   1127	1054	7	f4	float
    //   36	2168	8	i	int
    //   30	2069	9	j	int
    //   417	1712	10	k	int
    //   440	1717	11	m	int
    //   512	1654	12	n	int
    //   597	481	13	i1	int
    //   169	1650	14	i2	int
    //   14	757	15	i3	int
    //   216	1092	16	i4	int
    //   905	68	17	i5	int
    //   33	638	18	localObject1	Object
    //   824	39	18	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   1198	10	18	localObject2	Object
    //   1259	1	18	arrayOfByteBuffer1	java.nio.ByteBuffer[]
    //   1617	10	18	localObject3	Object
    //   1682	102	18	arrayOfShort1	short[]
    //   1924	10	18	localObject4	Object
    //   2010	17	18	localObject5	Object
    //   2039	1	18	localObject6	Object
    //   2066	27	18	localObject7	Object
    //   2122	49	18	localObject8	Object
    //   332	1854	19	localObject9	Object
    //   849	1230	20	localObject10	Object
    //   488	1607	21	localObject11	Object
    //   528	1597	22	localObject12	Object
    //   83	2065	23	localObject13	Object
    //   7	1629	24	localMediaExtractor	android.media.MediaExtractor
    //   303	1343	25	localMediaCodec	android.media.MediaCodec
    //   325	107	26	arrayOfByteBuffer2	java.nio.ByteBuffer[]
    //   341	941	27	localBufferInfo	android.media.MediaCodec.BufferInfo
    //   380	1077	28	arrayOfShort2	short[]
    // Exception table:
    //   from	to	target	type
    //   16	25	119	java/io/IOException
    //   357	366	698	finally
    //   699	701	698	finally
    //   666	672	824	java/lang/OutOfMemoryError
    //   1123	1125	1198	finally
    //   1151	1169	1198	finally
    //   1172	1195	1198	finally
    //   1200	1202	1198	finally
    //   854	862	1210	android/media/MediaCodec$CryptoException
    //   870	883	1210	android/media/MediaCodec$CryptoException
    //   888	896	1210	android/media/MediaCodec$CryptoException
    //   901	907	1210	android/media/MediaCodec$CryptoException
    //   912	931	1210	android/media/MediaCodec$CryptoException
    //   936	945	1210	android/media/MediaCodec$CryptoException
    //   950	966	1210	android/media/MediaCodec$CryptoException
    //   971	978	1210	android/media/MediaCodec$CryptoException
    //   983	1001	1210	android/media/MediaCodec$CryptoException
    //   1011	1022	1210	android/media/MediaCodec$CryptoException
    //   1040	1059	1210	android/media/MediaCodec$CryptoException
    //   1073	1080	1210	android/media/MediaCodec$CryptoException
    //   1097	1105	1210	android/media/MediaCodec$CryptoException
    //   1110	1112	1210	android/media/MediaCodec$CryptoException
    //   1207	1210	1210	android/media/MediaCodec$CryptoException
    //   1281	1291	1210	android/media/MediaCodec$CryptoException
    //   1296	1310	1210	android/media/MediaCodec$CryptoException
    //   1315	1321	1210	android/media/MediaCodec$CryptoException
    //   1326	1345	1210	android/media/MediaCodec$CryptoException
    //   1350	1359	1210	android/media/MediaCodec$CryptoException
    //   1364	1380	1210	android/media/MediaCodec$CryptoException
    //   1385	1392	1210	android/media/MediaCodec$CryptoException
    //   1397	1415	1210	android/media/MediaCodec$CryptoException
    //   1425	1436	1210	android/media/MediaCodec$CryptoException
    //   1454	1473	1210	android/media/MediaCodec$CryptoException
    //   1487	1494	1210	android/media/MediaCodec$CryptoException
    //   1511	1520	1210	android/media/MediaCodec$CryptoException
    //   1525	1527	1210	android/media/MediaCodec$CryptoException
    //   1626	1629	1210	android/media/MediaCodec$CryptoException
    //   1657	1666	1210	android/media/MediaCodec$CryptoException
    //   1671	1684	1210	android/media/MediaCodec$CryptoException
    //   1689	1698	1210	android/media/MediaCodec$CryptoException
    //   1703	1719	1210	android/media/MediaCodec$CryptoException
    //   1724	1731	1210	android/media/MediaCodec$CryptoException
    //   1736	1742	1210	android/media/MediaCodec$CryptoException
    //   1752	1763	1210	android/media/MediaCodec$CryptoException
    //   1781	1800	1210	android/media/MediaCodec$CryptoException
    //   1814	1821	1210	android/media/MediaCodec$CryptoException
    //   1838	1846	1210	android/media/MediaCodec$CryptoException
    //   1851	1853	1210	android/media/MediaCodec$CryptoException
    //   1933	1936	1210	android/media/MediaCodec$CryptoException
    //   1985	1987	1210	android/media/MediaCodec$CryptoException
    //   2019	2022	1210	android/media/MediaCodec$CryptoException
    //   1538	1540	1617	finally
    //   1562	1580	1617	finally
    //   1587	1610	1617	finally
    //   1619	1621	1617	finally
    //   854	862	1629	finally
    //   870	883	1629	finally
    //   888	896	1629	finally
    //   901	907	1629	finally
    //   912	931	1629	finally
    //   936	945	1629	finally
    //   950	966	1629	finally
    //   971	978	1629	finally
    //   983	1001	1629	finally
    //   1011	1022	1629	finally
    //   1040	1059	1629	finally
    //   1073	1080	1629	finally
    //   1097	1105	1629	finally
    //   1110	1112	1629	finally
    //   1207	1210	1629	finally
    //   1214	1225	1629	finally
    //   1281	1291	1629	finally
    //   1296	1310	1629	finally
    //   1315	1321	1629	finally
    //   1326	1345	1629	finally
    //   1350	1359	1629	finally
    //   1364	1380	1629	finally
    //   1385	1392	1629	finally
    //   1397	1415	1629	finally
    //   1425	1436	1629	finally
    //   1454	1473	1629	finally
    //   1487	1494	1629	finally
    //   1511	1520	1629	finally
    //   1525	1527	1629	finally
    //   1626	1629	1629	finally
    //   1657	1666	1629	finally
    //   1671	1684	1629	finally
    //   1689	1698	1629	finally
    //   1703	1719	1629	finally
    //   1724	1731	1629	finally
    //   1736	1742	1629	finally
    //   1752	1763	1629	finally
    //   1781	1800	1629	finally
    //   1814	1821	1629	finally
    //   1838	1846	1629	finally
    //   1851	1853	1629	finally
    //   1933	1936	1629	finally
    //   1985	1987	1629	finally
    //   2019	2022	1629	finally
    //   1860	1873	1924	finally
    //   1873	1875	1924	finally
    //   1885	1921	1924	finally
    //   1926	1928	1924	finally
    //   1936	1977	1924	finally
    //   1987	2007	2010	finally
    //   2012	2014	2010	finally
    //   409	419	2066	finally
    //   429	465	2066	finally
    //   471	477	2066	finally
    //   484	490	2066	finally
    //   502	514	2066	finally
    //   519	527	2066	finally
    //   533	555	2066	finally
    //   555	619	2066	finally
    //   622	644	2066	finally
    //   666	672	2066	finally
    //   708	721	2066	finally
    //   727	749	2066	finally
    //   756	803	2066	finally
    //   835	847	2066	finally
    //   1254	1261	2066	finally
    //   409	419	2076	android/media/MediaCodec$CryptoException
    //   429	465	2076	android/media/MediaCodec$CryptoException
    //   471	477	2076	android/media/MediaCodec$CryptoException
    //   484	490	2076	android/media/MediaCodec$CryptoException
    //   502	514	2076	android/media/MediaCodec$CryptoException
    //   519	527	2076	android/media/MediaCodec$CryptoException
    //   533	555	2076	android/media/MediaCodec$CryptoException
    //   555	619	2076	android/media/MediaCodec$CryptoException
    //   622	644	2076	android/media/MediaCodec$CryptoException
    //   666	672	2076	android/media/MediaCodec$CryptoException
    //   708	721	2076	android/media/MediaCodec$CryptoException
    //   727	749	2076	android/media/MediaCodec$CryptoException
    //   756	803	2076	android/media/MediaCodec$CryptoException
    //   835	847	2076	android/media/MediaCodec$CryptoException
    //   1254	1261	2076	android/media/MediaCodec$CryptoException
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
  
  public boolean a(MusicItemInfo paramMusicItemInfo, brjm parambrjm, int paramInt)
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
    a(parambrjm);
    a(localFile, paramInt, paramMusicItemInfo);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     brjl
 * JD-Core Version:    0.7.0.1
 */