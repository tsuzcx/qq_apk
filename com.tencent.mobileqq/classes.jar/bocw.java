import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class bocw
{
  private int jdField_a_of_type_Int;
  private bocx jdField_a_of_type_Bocx;
  private ArrayList<Float> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public boolean a;
  private int b = 0;
  private int c = 1024;
  
  private int a(int paramInt)
  {
    return (int)(paramInt * 1.0D * this.jdField_a_of_type_Int / (1000.0D * a()) + 0.5D);
  }
  
  private void a(bocx parambocx)
  {
    this.jdField_a_of_type_Bocx = parambocx;
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
    //   42: if_icmpge +2114 -> 2156
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
    //   138: ifnonnull +5 -> 143
    //   141: iconst_0
    //   142: ireturn
    //   143: aload_3
    //   144: getfield 117	com/tencent/mobileqq/richmedia/capture/data/MusicItemInfo:musicStart	I
    //   147: iload_2
    //   148: iadd
    //   149: istore 8
    //   151: iload 8
    //   153: ifle +16 -> 169
    //   156: aload 24
    //   158: iload 8
    //   160: i2l
    //   161: ldc2_w 118
    //   164: lmul
    //   165: iconst_2
    //   166: invokevirtual 123	android/media/MediaExtractor:seekTo	(JI)V
    //   169: aload 23
    //   171: ldc 125
    //   173: invokevirtual 129	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   176: istore 14
    //   178: aload_0
    //   179: aload 23
    //   181: ldc 131
    //   183: invokevirtual 129	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   186: putfield 29	bocw:jdField_a_of_type_Int	I
    //   189: aload_3
    //   190: invokevirtual 135	com/tencent/mobileqq/richmedia/capture/data/MusicItemInfo:isMyMusicInfo	()Z
    //   193: ifeq +81 -> 274
    //   196: aload_3
    //   197: getfield 138	com/tencent/mobileqq/richmedia/capture/data/MusicItemInfo:musicEnd	I
    //   200: aload_3
    //   201: getfield 117	com/tencent/mobileqq/richmedia/capture/data/MusicItemInfo:musicStart	I
    //   204: iload_2
    //   205: iadd
    //   206: isub
    //   207: istore_2
    //   208: iload_2
    //   209: i2f
    //   210: ldc 139
    //   212: fdiv
    //   213: aload_0
    //   214: getfield 29	bocw:jdField_a_of_type_Int	I
    //   217: i2f
    //   218: fmul
    //   219: ldc 140
    //   221: fadd
    //   222: f2i
    //   223: istore 16
    //   225: aload_0
    //   226: sipush 1024
    //   229: putfield 18	bocw:c	I
    //   232: fconst_1
    //   233: aload_0
    //   234: getfield 29	bocw:jdField_a_of_type_Int	I
    //   237: i2f
    //   238: fmul
    //   239: aload_0
    //   240: getfield 18	bocw:c	I
    //   243: i2f
    //   244: fdiv
    //   245: ldc 141
    //   247: fcmpg
    //   248: ifge +52 -> 300
    //   251: aload_0
    //   252: getfield 18	bocw:c	I
    //   255: sipush 128
    //   258: if_icmple +42 -> 300
    //   261: aload_0
    //   262: aload_0
    //   263: getfield 18	bocw:c	I
    //   266: iconst_2
    //   267: idiv
    //   268: putfield 18	bocw:c	I
    //   271: goto -39 -> 232
    //   274: aload 23
    //   276: ldc 143
    //   278: invokevirtual 147	android/media/MediaFormat:getLong	(Ljava/lang/String;)J
    //   281: l2f
    //   282: ldc 139
    //   284: fdiv
    //   285: ldc 140
    //   287: fadd
    //   288: f2i
    //   289: aload_3
    //   290: getfield 117	com/tencent/mobileqq/richmedia/capture/data/MusicItemInfo:musicStart	I
    //   293: iload_2
    //   294: iadd
    //   295: isub
    //   296: istore_2
    //   297: goto -89 -> 208
    //   300: aload 23
    //   302: ldc 72
    //   304: invokevirtual 78	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   307: invokestatic 153	android/media/MediaCodec:createDecoderByType	(Ljava/lang/String;)Landroid/media/MediaCodec;
    //   310: astore 25
    //   312: aload 25
    //   314: aload 23
    //   316: aconst_null
    //   317: aconst_null
    //   318: iconst_0
    //   319: invokevirtual 157	android/media/MediaCodec:configure	(Landroid/media/MediaFormat;Landroid/view/Surface;Landroid/media/MediaCrypto;I)V
    //   322: aload 25
    //   324: invokevirtual 160	android/media/MediaCodec:start	()V
    //   327: aload 25
    //   329: invokevirtual 164	android/media/MediaCodec:getInputBuffers	()[Ljava/nio/ByteBuffer;
    //   332: astore 26
    //   334: aload 25
    //   336: invokevirtual 167	android/media/MediaCodec:getOutputBuffers	()[Ljava/nio/ByteBuffer;
    //   339: astore 19
    //   341: new 169	android/media/MediaCodec$BufferInfo
    //   344: dup
    //   345: invokespecial 170	android/media/MediaCodec$BufferInfo:<init>	()V
    //   348: astore 27
    //   350: iconst_0
    //   351: istore 9
    //   353: iconst_0
    //   354: istore 8
    //   356: ldc 171
    //   358: invokestatic 177	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   361: astore_1
    //   362: aload_0
    //   363: monitorenter
    //   364: aload_0
    //   365: getfield 25	bocw:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   368: invokevirtual 180	java/util/ArrayList:clear	()V
    //   371: aload_0
    //   372: monitorexit
    //   373: aload_0
    //   374: iconst_0
    //   375: putfield 20	bocw:b	I
    //   378: aload_0
    //   379: invokevirtual 34	bocw:a	()I
    //   382: iload 14
    //   384: imul
    //   385: newarray short
    //   387: astore 28
    //   389: aload_0
    //   390: iconst_1
    //   391: putfield 182	bocw:jdField_a_of_type_Boolean	Z
    //   394: ldc 183
    //   396: fstore 5
    //   398: ldc 183
    //   400: fstore 4
    //   402: aconst_null
    //   403: astore_3
    //   404: iconst_0
    //   405: istore_2
    //   406: iconst_1
    //   407: invokestatic 189	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   410: astore 18
    //   412: ldc 183
    //   414: fstore 6
    //   416: aload 25
    //   418: ldc2_w 190
    //   421: invokevirtual 195	android/media/MediaCodec:dequeueInputBuffer	(J)I
    //   424: istore 10
    //   426: iload 8
    //   428: ifne +1671 -> 2099
    //   431: iload 10
    //   433: iflt +1666 -> 2099
    //   436: aload 24
    //   438: aload 26
    //   440: iload 10
    //   442: aaload
    //   443: iconst_0
    //   444: invokevirtual 199	android/media/MediaExtractor:readSampleData	(Ljava/nio/ByteBuffer;I)I
    //   447: istore 11
    //   449: aload 18
    //   451: invokevirtual 202	java/lang/Boolean:booleanValue	()Z
    //   454: ifeq +257 -> 711
    //   457: aload 23
    //   459: ldc 72
    //   461: invokevirtual 78	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   464: ldc 204
    //   466: invokevirtual 208	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   469: ifeq +242 -> 711
    //   472: iload 11
    //   474: iconst_2
    //   475: if_icmpne +236 -> 711
    //   478: aload 24
    //   480: invokevirtual 211	android/media/MediaExtractor:advance	()Z
    //   483: pop
    //   484: iload 11
    //   486: iload 9
    //   488: iadd
    //   489: istore 9
    //   491: iconst_0
    //   492: invokestatic 189	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   495: astore 21
    //   497: iload 8
    //   499: istore 10
    //   501: iload 9
    //   503: istore 8
    //   505: iload 10
    //   507: istore 9
    //   509: aload 25
    //   511: aload 27
    //   513: ldc2_w 190
    //   516: invokevirtual 215	android/media/MediaCodec:dequeueOutputBuffer	(Landroid/media/MediaCodec$BufferInfo;J)I
    //   519: istore 12
    //   521: iload 12
    //   523: iflt +735 -> 1258
    //   526: aload 27
    //   528: getfield 218	android/media/MediaCodec$BufferInfo:size	I
    //   531: ifle +727 -> 1258
    //   534: aload_3
    //   535: astore 22
    //   537: iload_2
    //   538: istore 10
    //   540: iload_2
    //   541: aload 27
    //   543: getfield 218	android/media/MediaCodec$BufferInfo:size	I
    //   546: if_icmpge +16 -> 562
    //   549: aload 27
    //   551: getfield 218	android/media/MediaCodec$BufferInfo:size	I
    //   554: istore 10
    //   556: iload 10
    //   558: newarray byte
    //   560: astore 22
    //   562: aload 19
    //   564: iload 12
    //   566: aaload
    //   567: aload 22
    //   569: iconst_0
    //   570: aload 27
    //   572: getfield 218	android/media/MediaCodec$BufferInfo:size	I
    //   575: invokevirtual 222	java/nio/ByteBuffer:get	([BII)Ljava/nio/ByteBuffer;
    //   578: pop
    //   579: aload 19
    //   581: iload 12
    //   583: aaload
    //   584: invokevirtual 225	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   587: pop
    //   588: aload_1
    //   589: invokevirtual 228	java/nio/ByteBuffer:remaining	()I
    //   592: aload 27
    //   594: getfield 218	android/media/MediaCodec$BufferInfo:size	I
    //   597: if_icmpge +1556 -> 2153
    //   600: aload_1
    //   601: invokevirtual 231	java/nio/ByteBuffer:position	()I
    //   604: istore 13
    //   606: iload 13
    //   608: i2d
    //   609: dconst_1
    //   610: iload 15
    //   612: i2d
    //   613: dmul
    //   614: iload 8
    //   616: i2d
    //   617: ddiv
    //   618: dmul
    //   619: ldc2_w 232
    //   622: dmul
    //   623: d2i
    //   624: istore 11
    //   626: iload 11
    //   628: istore_2
    //   629: iload 11
    //   631: iload 13
    //   633: isub
    //   634: aload 27
    //   636: getfield 218	android/media/MediaCodec$BufferInfo:size	I
    //   639: ldc 234
    //   641: iadd
    //   642: if_icmpge +17 -> 659
    //   645: aload 27
    //   647: getfield 218	android/media/MediaCodec$BufferInfo:size	I
    //   650: istore_2
    //   651: iload_2
    //   652: iload 13
    //   654: iadd
    //   655: ldc 234
    //   657: iadd
    //   658: istore_2
    //   659: aconst_null
    //   660: astore_3
    //   661: bipush 10
    //   663: istore 11
    //   665: aload_3
    //   666: astore 18
    //   668: iload 11
    //   670: ifle +9 -> 679
    //   673: iload_2
    //   674: invokestatic 177	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   677: astore 18
    //   679: iload 11
    //   681: ifne +163 -> 844
    //   684: aload_1
    //   685: invokevirtual 225	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   688: pop
    //   689: aload 24
    //   691: invokevirtual 112	android/media/MediaExtractor:release	()V
    //   694: aload 25
    //   696: invokevirtual 237	android/media/MediaCodec:stop	()V
    //   699: aload 25
    //   701: invokevirtual 238	android/media/MediaCodec:release	()V
    //   704: iconst_1
    //   705: ireturn
    //   706: astore_1
    //   707: aload_0
    //   708: monitorexit
    //   709: aload_1
    //   710: athrow
    //   711: iload 11
    //   713: ifge +22 -> 735
    //   716: aload 25
    //   718: iload 10
    //   720: iconst_0
    //   721: iconst_0
    //   722: ldc2_w 239
    //   725: iconst_4
    //   726: invokevirtual 244	android/media/MediaCodec:queueInputBuffer	(IIIJI)V
    //   729: iconst_1
    //   730: istore 8
    //   732: goto -241 -> 491
    //   735: aload 25
    //   737: iload 10
    //   739: iconst_0
    //   740: iload 11
    //   742: aload 24
    //   744: invokevirtual 247	android/media/MediaExtractor:getSampleTime	()J
    //   747: iconst_0
    //   748: invokevirtual 244	android/media/MediaCodec:queueInputBuffer	(IIIJI)V
    //   751: aload 24
    //   753: invokevirtual 211	android/media/MediaExtractor:advance	()Z
    //   756: pop
    //   757: iload 11
    //   759: iload 9
    //   761: iadd
    //   762: istore 9
    //   764: aload_0
    //   765: getfield 39	bocw:jdField_a_of_type_Bocx	Lbocx;
    //   768: ifnull +1328 -> 2096
    //   771: aload_0
    //   772: getfield 39	bocw:jdField_a_of_type_Bocx	Lbocx;
    //   775: iload 9
    //   777: i2f
    //   778: iload 15
    //   780: i2f
    //   781: fdiv
    //   782: f2d
    //   783: invokeinterface 252 3 0
    //   788: ifne +1308 -> 2096
    //   791: aload_1
    //   792: invokevirtual 225	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   795: pop
    //   796: aload 24
    //   798: invokevirtual 112	android/media/MediaExtractor:release	()V
    //   801: aload 25
    //   803: invokevirtual 237	android/media/MediaCodec:stop	()V
    //   806: aload 25
    //   808: invokevirtual 238	android/media/MediaCodec:release	()V
    //   811: aload_1
    //   812: invokevirtual 225	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   815: pop
    //   816: aload 24
    //   818: invokevirtual 112	android/media/MediaExtractor:release	()V
    //   821: aload 25
    //   823: invokevirtual 237	android/media/MediaCodec:stop	()V
    //   826: aload 25
    //   828: invokevirtual 238	android/media/MediaCodec:release	()V
    //   831: iconst_1
    //   832: ireturn
    //   833: astore 18
    //   835: iload 11
    //   837: iconst_1
    //   838: isub
    //   839: istore 11
    //   841: goto -176 -> 665
    //   844: aload_1
    //   845: invokevirtual 255	java/nio/ByteBuffer:rewind	()Ljava/nio/Buffer;
    //   848: pop
    //   849: aload 18
    //   851: aload_1
    //   852: invokevirtual 259	java/nio/ByteBuffer:put	(Ljava/nio/ByteBuffer;)Ljava/nio/ByteBuffer;
    //   855: pop
    //   856: aload 18
    //   858: astore 20
    //   860: aload 18
    //   862: astore_3
    //   863: aload 18
    //   865: iload 13
    //   867: invokevirtual 262	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   870: pop
    //   871: aload 18
    //   873: astore_1
    //   874: aload_1
    //   875: astore 20
    //   877: aload_1
    //   878: astore_3
    //   879: aload_1
    //   880: aload 22
    //   882: iconst_0
    //   883: aload 27
    //   885: getfield 218	android/media/MediaCodec$BufferInfo:size	I
    //   888: invokevirtual 264	java/nio/ByteBuffer:put	([BII)Ljava/nio/ByteBuffer;
    //   891: pop
    //   892: aload_1
    //   893: astore 20
    //   895: aload_1
    //   896: astore_3
    //   897: aload 25
    //   899: iload 12
    //   901: iconst_0
    //   902: invokevirtual 268	android/media/MediaCodec:releaseOutputBuffer	(IZ)V
    //   905: aload_1
    //   906: astore 20
    //   908: aload_1
    //   909: astore_3
    //   910: aload_1
    //   911: invokevirtual 231	java/nio/ByteBuffer:position	()I
    //   914: istore 17
    //   916: aload_1
    //   917: astore 20
    //   919: aload_1
    //   920: astore_3
    //   921: iload 17
    //   923: aload_0
    //   924: getfield 20	bocw:b	I
    //   927: isub
    //   928: aload_0
    //   929: invokevirtual 34	bocw:a	()I
    //   932: iconst_2
    //   933: imul
    //   934: iload 14
    //   936: imul
    //   937: if_icmple +1190 -> 2127
    //   940: aload_1
    //   941: astore 20
    //   943: aload_1
    //   944: astore_3
    //   945: aload_1
    //   946: aload_0
    //   947: getfield 20	bocw:b	I
    //   950: invokevirtual 262	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   953: pop
    //   954: aload_1
    //   955: astore 20
    //   957: aload_1
    //   958: astore_3
    //   959: aload_1
    //   960: getstatic 274	java/nio/ByteOrder:LITTLE_ENDIAN	Ljava/nio/ByteOrder;
    //   963: invokevirtual 278	java/nio/ByteBuffer:order	(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    //   966: invokevirtual 282	java/nio/ByteBuffer:asShortBuffer	()Ljava/nio/ShortBuffer;
    //   969: aload 28
    //   971: invokevirtual 287	java/nio/ShortBuffer:get	([S)Ljava/nio/ShortBuffer;
    //   974: pop
    //   975: aload_1
    //   976: astore 20
    //   978: aload_1
    //   979: astore_3
    //   980: aload_1
    //   981: iload 17
    //   983: invokevirtual 262	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   986: pop
    //   987: aload_1
    //   988: astore 20
    //   990: aload_1
    //   991: astore_3
    //   992: aload_0
    //   993: aload_0
    //   994: getfield 20	bocw:b	I
    //   997: aload_0
    //   998: invokevirtual 34	bocw:a	()I
    //   1001: iconst_2
    //   1002: imul
    //   1003: iload 14
    //   1005: imul
    //   1006: iadd
    //   1007: putfield 20	bocw:b	I
    //   1010: iconst_m1
    //   1011: istore_2
    //   1012: iconst_0
    //   1013: istore 11
    //   1015: aload_1
    //   1016: astore 20
    //   1018: aload_1
    //   1019: astore_3
    //   1020: iload 11
    //   1022: aload 28
    //   1024: arraylength
    //   1025: iload 14
    //   1027: idiv
    //   1028: if_icmpge +73 -> 1101
    //   1031: iconst_0
    //   1032: istore 13
    //   1034: iconst_0
    //   1035: istore 12
    //   1037: iload 12
    //   1039: iload 14
    //   1041: if_icmpge +36 -> 1077
    //   1044: aload_1
    //   1045: astore 20
    //   1047: aload_1
    //   1048: astore_3
    //   1049: iload 13
    //   1051: aload 28
    //   1053: iload 11
    //   1055: iload 14
    //   1057: imul
    //   1058: iload 12
    //   1060: iadd
    //   1061: saload
    //   1062: invokestatic 292	java/lang/Math:abs	(I)I
    //   1065: iadd
    //   1066: istore 13
    //   1068: iload 12
    //   1070: iconst_1
    //   1071: iadd
    //   1072: istore 12
    //   1074: goto -37 -> 1037
    //   1077: aload_1
    //   1078: astore 20
    //   1080: aload_1
    //   1081: astore_3
    //   1082: iload 13
    //   1084: iload 14
    //   1086: idiv
    //   1087: istore 12
    //   1089: iload_2
    //   1090: iload 12
    //   1092: if_icmpge +1032 -> 2124
    //   1095: iload 12
    //   1097: istore_2
    //   1098: goto +1065 -> 2163
    //   1101: aload_1
    //   1102: astore 20
    //   1104: aload_1
    //   1105: astore_3
    //   1106: iload_2
    //   1107: i2d
    //   1108: invokestatic 296	java/lang/Math:sqrt	(D)D
    //   1111: d2f
    //   1112: fstore 6
    //   1114: aload_1
    //   1115: astore 20
    //   1117: aload_1
    //   1118: astore_3
    //   1119: aload_0
    //   1120: monitorenter
    //   1121: fload 5
    //   1123: fconst_0
    //   1124: fcmpg
    //   1125: ifge +28 -> 1153
    //   1128: fload 4
    //   1130: fstore 5
    //   1132: aload_0
    //   1133: monitorexit
    //   1134: fload 6
    //   1136: fstore 7
    //   1138: fload 5
    //   1140: fstore 4
    //   1142: fload 6
    //   1144: fstore 5
    //   1146: fload 7
    //   1148: fstore 6
    //   1150: goto -234 -> 916
    //   1153: fload 4
    //   1155: fconst_0
    //   1156: fcmpg
    //   1157: ifge +24 -> 1181
    //   1160: aload_0
    //   1161: getfield 25	bocw:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1164: fload 5
    //   1166: fload 6
    //   1168: fadd
    //   1169: fconst_2
    //   1170: fdiv
    //   1171: invokestatic 301	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   1174: invokevirtual 304	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1177: pop
    //   1178: goto -46 -> 1132
    //   1181: aload_0
    //   1182: getfield 25	bocw:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1185: fload 4
    //   1187: fload 5
    //   1189: fadd
    //   1190: fload 6
    //   1192: fadd
    //   1193: ldc_w 305
    //   1196: fdiv
    //   1197: invokestatic 301	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   1200: invokevirtual 304	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1203: pop
    //   1204: goto -72 -> 1132
    //   1207: astore 18
    //   1209: aload_0
    //   1210: monitorexit
    //   1211: aload_1
    //   1212: astore 20
    //   1214: aload_1
    //   1215: astore_3
    //   1216: aload 18
    //   1218: athrow
    //   1219: astore_1
    //   1220: aload 20
    //   1222: astore_3
    //   1223: ldc_w 307
    //   1226: iconst_1
    //   1227: ldc_w 309
    //   1230: aload_1
    //   1231: invokestatic 315	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1234: aload 20
    //   1236: invokevirtual 225	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   1239: pop
    //   1240: aload 24
    //   1242: invokevirtual 112	android/media/MediaExtractor:release	()V
    //   1245: aload 25
    //   1247: invokevirtual 237	android/media/MediaCodec:stop	()V
    //   1250: aload 25
    //   1252: invokevirtual 238	android/media/MediaCodec:release	()V
    //   1255: goto -551 -> 704
    //   1258: iload 12
    //   1260: bipush 253
    //   1262: if_icmpne +910 -> 2172
    //   1265: aload 25
    //   1267: invokevirtual 167	android/media/MediaCodec:getOutputBuffers	()[Ljava/nio/ByteBuffer;
    //   1270: astore 18
    //   1272: fload 6
    //   1274: fstore 7
    //   1276: aload_3
    //   1277: astore 19
    //   1279: fload 4
    //   1281: fstore 6
    //   1283: fload 7
    //   1285: fstore 4
    //   1287: aload_1
    //   1288: astore 20
    //   1290: aload_1
    //   1291: astore_3
    //   1292: aload 27
    //   1294: getfield 318	android/media/MediaCodec$BufferInfo:flags	I
    //   1297: iconst_4
    //   1298: iand
    //   1299: ifne +22 -> 1321
    //   1302: aload_1
    //   1303: astore 20
    //   1305: aload_1
    //   1306: astore_3
    //   1307: aload_1
    //   1308: invokevirtual 231	java/nio/ByteBuffer:position	()I
    //   1311: iload 14
    //   1313: iconst_2
    //   1314: imul
    //   1315: idiv
    //   1316: iload 16
    //   1318: if_icmplt +715 -> 2033
    //   1321: aload_1
    //   1322: astore 20
    //   1324: aload_1
    //   1325: astore_3
    //   1326: aload_1
    //   1327: invokevirtual 231	java/nio/ByteBuffer:position	()I
    //   1330: istore 11
    //   1332: aload_1
    //   1333: astore 20
    //   1335: aload_1
    //   1336: astore_3
    //   1337: iload 11
    //   1339: aload_0
    //   1340: getfield 20	bocw:b	I
    //   1343: isub
    //   1344: aload_0
    //   1345: invokevirtual 34	bocw:a	()I
    //   1348: iconst_2
    //   1349: imul
    //   1350: iload 14
    //   1352: imul
    //   1353: if_icmple +310 -> 1663
    //   1356: aload_1
    //   1357: astore 20
    //   1359: aload_1
    //   1360: astore_3
    //   1361: aload_1
    //   1362: aload_0
    //   1363: getfield 20	bocw:b	I
    //   1366: invokevirtual 262	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   1369: pop
    //   1370: aload_1
    //   1371: astore 20
    //   1373: aload_1
    //   1374: astore_3
    //   1375: aload_1
    //   1376: getstatic 274	java/nio/ByteOrder:LITTLE_ENDIAN	Ljava/nio/ByteOrder;
    //   1379: invokevirtual 278	java/nio/ByteBuffer:order	(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    //   1382: invokevirtual 282	java/nio/ByteBuffer:asShortBuffer	()Ljava/nio/ShortBuffer;
    //   1385: aload 28
    //   1387: invokevirtual 287	java/nio/ShortBuffer:get	([S)Ljava/nio/ShortBuffer;
    //   1390: pop
    //   1391: aload_1
    //   1392: astore 20
    //   1394: aload_1
    //   1395: astore_3
    //   1396: aload_1
    //   1397: iload 11
    //   1399: invokevirtual 262	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   1402: pop
    //   1403: aload_1
    //   1404: astore 20
    //   1406: aload_1
    //   1407: astore_3
    //   1408: aload_0
    //   1409: aload_0
    //   1410: getfield 20	bocw:b	I
    //   1413: aload_0
    //   1414: invokevirtual 34	bocw:a	()I
    //   1417: iconst_2
    //   1418: imul
    //   1419: iload 14
    //   1421: imul
    //   1422: iadd
    //   1423: putfield 20	bocw:b	I
    //   1426: iconst_m1
    //   1427: istore_2
    //   1428: iconst_0
    //   1429: istore 8
    //   1431: aload_1
    //   1432: astore 20
    //   1434: aload_1
    //   1435: astore_3
    //   1436: iload 8
    //   1438: aload 28
    //   1440: arraylength
    //   1441: iload 14
    //   1443: idiv
    //   1444: if_icmpge +73 -> 1517
    //   1447: iconst_0
    //   1448: istore 10
    //   1450: iconst_0
    //   1451: istore 9
    //   1453: iload 9
    //   1455: iload 14
    //   1457: if_icmpge +36 -> 1493
    //   1460: aload_1
    //   1461: astore 20
    //   1463: aload_1
    //   1464: astore_3
    //   1465: iload 10
    //   1467: aload 28
    //   1469: iload 8
    //   1471: iload 14
    //   1473: imul
    //   1474: iload 9
    //   1476: iadd
    //   1477: saload
    //   1478: invokestatic 292	java/lang/Math:abs	(I)I
    //   1481: iadd
    //   1482: istore 10
    //   1484: iload 9
    //   1486: iconst_1
    //   1487: iadd
    //   1488: istore 9
    //   1490: goto -37 -> 1453
    //   1493: aload_1
    //   1494: astore 20
    //   1496: aload_1
    //   1497: astore_3
    //   1498: iload 10
    //   1500: iload 14
    //   1502: idiv
    //   1503: istore 9
    //   1505: iload_2
    //   1506: iload 9
    //   1508: if_icmpge +613 -> 2121
    //   1511: iload 9
    //   1513: istore_2
    //   1514: goto +687 -> 2201
    //   1517: aload_1
    //   1518: astore 20
    //   1520: aload_1
    //   1521: astore_3
    //   1522: iload_2
    //   1523: i2d
    //   1524: invokestatic 296	java/lang/Math:sqrt	(D)D
    //   1527: d2i
    //   1528: i2f
    //   1529: fstore 7
    //   1531: aload_1
    //   1532: astore 20
    //   1534: aload_1
    //   1535: astore_3
    //   1536: aload_0
    //   1537: monitorenter
    //   1538: fload 5
    //   1540: fconst_0
    //   1541: fcmpg
    //   1542: ifge +24 -> 1566
    //   1545: fload 6
    //   1547: fstore 4
    //   1549: aload_0
    //   1550: monitorexit
    //   1551: fload 7
    //   1553: fstore 5
    //   1555: fload 4
    //   1557: fstore 6
    //   1559: fload 7
    //   1561: fstore 4
    //   1563: goto -231 -> 1332
    //   1566: fload 6
    //   1568: fconst_0
    //   1569: fcmpg
    //   1570: ifge +28 -> 1598
    //   1573: aload_0
    //   1574: getfield 25	bocw:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1577: fload 5
    //   1579: fload 7
    //   1581: fadd
    //   1582: fconst_2
    //   1583: fdiv
    //   1584: invokestatic 301	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   1587: invokevirtual 304	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1590: pop
    //   1591: fload 5
    //   1593: fstore 4
    //   1595: goto -46 -> 1549
    //   1598: aload_0
    //   1599: getfield 25	bocw:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1602: fload 6
    //   1604: fload 5
    //   1606: fadd
    //   1607: fload 7
    //   1609: fadd
    //   1610: ldc_w 305
    //   1613: fdiv
    //   1614: invokestatic 301	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   1617: invokevirtual 304	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1620: pop
    //   1621: fload 5
    //   1623: fstore 4
    //   1625: goto -76 -> 1549
    //   1628: astore 18
    //   1630: aload_0
    //   1631: monitorexit
    //   1632: aload_1
    //   1633: astore 20
    //   1635: aload_1
    //   1636: astore_3
    //   1637: aload 18
    //   1639: athrow
    //   1640: astore_1
    //   1641: aload_3
    //   1642: invokevirtual 225	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   1645: pop
    //   1646: aload 24
    //   1648: invokevirtual 112	android/media/MediaExtractor:release	()V
    //   1651: aload 25
    //   1653: invokevirtual 237	android/media/MediaCodec:stop	()V
    //   1656: aload 25
    //   1658: invokevirtual 238	android/media/MediaCodec:release	()V
    //   1661: aload_1
    //   1662: athrow
    //   1663: aload_1
    //   1664: astore 20
    //   1666: aload_1
    //   1667: astore_3
    //   1668: iload 11
    //   1670: aload_0
    //   1671: getfield 20	bocw:b	I
    //   1674: if_icmple +317 -> 1991
    //   1677: aload_1
    //   1678: astore 20
    //   1680: aload_1
    //   1681: astore_3
    //   1682: iload 11
    //   1684: aload_0
    //   1685: getfield 20	bocw:b	I
    //   1688: isub
    //   1689: iconst_2
    //   1690: idiv
    //   1691: newarray short
    //   1693: astore 18
    //   1695: aload_1
    //   1696: astore 20
    //   1698: aload_1
    //   1699: astore_3
    //   1700: aload_1
    //   1701: aload_0
    //   1702: getfield 20	bocw:b	I
    //   1705: invokevirtual 262	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   1708: pop
    //   1709: aload_1
    //   1710: astore 20
    //   1712: aload_1
    //   1713: astore_3
    //   1714: aload_1
    //   1715: getstatic 274	java/nio/ByteOrder:LITTLE_ENDIAN	Ljava/nio/ByteOrder;
    //   1718: invokevirtual 278	java/nio/ByteBuffer:order	(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    //   1721: invokevirtual 282	java/nio/ByteBuffer:asShortBuffer	()Ljava/nio/ShortBuffer;
    //   1724: aload 18
    //   1726: invokevirtual 287	java/nio/ShortBuffer:get	([S)Ljava/nio/ShortBuffer;
    //   1729: pop
    //   1730: aload_1
    //   1731: astore 20
    //   1733: aload_1
    //   1734: astore_3
    //   1735: aload_1
    //   1736: iload 11
    //   1738: invokevirtual 262	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   1741: pop
    //   1742: aload_1
    //   1743: astore 20
    //   1745: aload_1
    //   1746: astore_3
    //   1747: aload_0
    //   1748: iload 11
    //   1750: putfield 20	bocw:b	I
    //   1753: iconst_m1
    //   1754: istore_2
    //   1755: iconst_0
    //   1756: istore 8
    //   1758: aload_1
    //   1759: astore 20
    //   1761: aload_1
    //   1762: astore_3
    //   1763: iload 8
    //   1765: aload 18
    //   1767: arraylength
    //   1768: iload 14
    //   1770: idiv
    //   1771: if_icmpge +73 -> 1844
    //   1774: iconst_0
    //   1775: istore 10
    //   1777: iconst_0
    //   1778: istore 9
    //   1780: iload 9
    //   1782: iload 14
    //   1784: if_icmpge +36 -> 1820
    //   1787: aload_1
    //   1788: astore 20
    //   1790: aload_1
    //   1791: astore_3
    //   1792: iload 10
    //   1794: aload 18
    //   1796: iload 8
    //   1798: iload 14
    //   1800: imul
    //   1801: iload 9
    //   1803: iadd
    //   1804: saload
    //   1805: invokestatic 292	java/lang/Math:abs	(I)I
    //   1808: iadd
    //   1809: istore 10
    //   1811: iload 9
    //   1813: iconst_1
    //   1814: iadd
    //   1815: istore 9
    //   1817: goto -37 -> 1780
    //   1820: aload_1
    //   1821: astore 20
    //   1823: aload_1
    //   1824: astore_3
    //   1825: iload 10
    //   1827: iload 14
    //   1829: idiv
    //   1830: istore 9
    //   1832: iload_2
    //   1833: iload 9
    //   1835: if_icmpge +283 -> 2118
    //   1838: iload 9
    //   1840: istore_2
    //   1841: goto +369 -> 2210
    //   1844: aload_1
    //   1845: astore 20
    //   1847: aload_1
    //   1848: astore_3
    //   1849: iload_2
    //   1850: i2d
    //   1851: invokestatic 296	java/lang/Math:sqrt	(D)D
    //   1854: d2f
    //   1855: fstore 4
    //   1857: aload_1
    //   1858: astore 20
    //   1860: aload_1
    //   1861: astore_3
    //   1862: aload_0
    //   1863: monitorenter
    //   1864: fload 5
    //   1866: fconst_0
    //   1867: fcmpg
    //   1868: ifge +21 -> 1889
    //   1871: aload_0
    //   1872: getfield 25	bocw:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1875: fload 4
    //   1877: invokestatic 301	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   1880: invokevirtual 304	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1883: pop
    //   1884: aload_0
    //   1885: monitorexit
    //   1886: goto -1202 -> 684
    //   1889: fload 6
    //   1891: fconst_0
    //   1892: fcmpg
    //   1893: ifge +54 -> 1947
    //   1896: aload_0
    //   1897: getfield 25	bocw:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1900: fload 5
    //   1902: fload 4
    //   1904: fadd
    //   1905: fconst_2
    //   1906: fdiv
    //   1907: invokestatic 301	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   1910: invokevirtual 304	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1913: pop
    //   1914: aload_0
    //   1915: getfield 25	bocw:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1918: fload 4
    //   1920: fload 5
    //   1922: fadd
    //   1923: fconst_2
    //   1924: fdiv
    //   1925: invokestatic 301	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   1928: invokevirtual 304	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1931: pop
    //   1932: goto -48 -> 1884
    //   1935: astore 18
    //   1937: aload_0
    //   1938: monitorexit
    //   1939: aload_1
    //   1940: astore 20
    //   1942: aload_1
    //   1943: astore_3
    //   1944: aload 18
    //   1946: athrow
    //   1947: aload_0
    //   1948: getfield 25	bocw:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1951: fload 6
    //   1953: fload 5
    //   1955: fadd
    //   1956: fload 4
    //   1958: fadd
    //   1959: ldc_w 305
    //   1962: fdiv
    //   1963: invokestatic 301	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   1966: invokevirtual 304	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1969: pop
    //   1970: aload_0
    //   1971: getfield 25	bocw:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1974: fload 4
    //   1976: fload 5
    //   1978: fadd
    //   1979: fconst_2
    //   1980: fdiv
    //   1981: invokestatic 301	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   1984: invokevirtual 304	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1987: pop
    //   1988: goto -104 -> 1884
    //   1991: aload_1
    //   1992: astore 20
    //   1994: aload_1
    //   1995: astore_3
    //   1996: aload_0
    //   1997: monitorenter
    //   1998: aload_0
    //   1999: getfield 25	bocw:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   2002: fload 4
    //   2004: fload 5
    //   2006: fadd
    //   2007: fconst_2
    //   2008: fdiv
    //   2009: invokestatic 301	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   2012: invokevirtual 304	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2015: pop
    //   2016: aload_0
    //   2017: monitorexit
    //   2018: goto -1334 -> 684
    //   2021: astore 18
    //   2023: aload_0
    //   2024: monitorexit
    //   2025: aload_1
    //   2026: astore 20
    //   2028: aload_1
    //   2029: astore_3
    //   2030: aload 18
    //   2032: athrow
    //   2033: fload 6
    //   2035: fstore 7
    //   2037: aload 18
    //   2039: astore_3
    //   2040: aload 19
    //   2042: astore 20
    //   2044: iload 8
    //   2046: istore 10
    //   2048: aload 21
    //   2050: astore 18
    //   2052: iload 9
    //   2054: istore 8
    //   2056: iload 10
    //   2058: istore 9
    //   2060: fload 4
    //   2062: fstore 6
    //   2064: fload 7
    //   2066: fstore 4
    //   2068: aload_3
    //   2069: astore 19
    //   2071: aload 20
    //   2073: astore_3
    //   2074: goto -1658 -> 416
    //   2077: astore 18
    //   2079: aload_1
    //   2080: astore_3
    //   2081: aload 18
    //   2083: astore_1
    //   2084: goto -443 -> 1641
    //   2087: astore_3
    //   2088: aload_1
    //   2089: astore 20
    //   2091: aload_3
    //   2092: astore_1
    //   2093: goto -873 -> 1220
    //   2096: goto -1605 -> 491
    //   2099: iload 9
    //   2101: istore 10
    //   2103: aload 18
    //   2105: astore 21
    //   2107: iload 8
    //   2109: istore 9
    //   2111: iload 10
    //   2113: istore 8
    //   2115: goto -1606 -> 509
    //   2118: goto +92 -> 2210
    //   2121: goto +80 -> 2201
    //   2124: goto +39 -> 2163
    //   2127: fload 4
    //   2129: fstore 7
    //   2131: aload 19
    //   2133: astore 18
    //   2135: aload 22
    //   2137: astore 19
    //   2139: iload 10
    //   2141: istore_2
    //   2142: fload 6
    //   2144: fstore 4
    //   2146: fload 7
    //   2148: fstore 6
    //   2150: goto -863 -> 1287
    //   2153: goto -1279 -> 874
    //   2156: aload 18
    //   2158: astore 23
    //   2160: goto -2075 -> 85
    //   2163: iload 11
    //   2165: iconst_1
    //   2166: iadd
    //   2167: istore 11
    //   2169: goto -1154 -> 1015
    //   2172: iload 12
    //   2174: bipush 254
    //   2176: if_icmpne +3 -> 2179
    //   2179: aload 19
    //   2181: astore 18
    //   2183: fload 4
    //   2185: fstore 7
    //   2187: fload 6
    //   2189: fstore 4
    //   2191: fload 7
    //   2193: fstore 6
    //   2195: aload_3
    //   2196: astore 19
    //   2198: goto -911 -> 1287
    //   2201: iload 8
    //   2203: iconst_1
    //   2204: iadd
    //   2205: istore 8
    //   2207: goto -776 -> 1431
    //   2210: iload 8
    //   2212: iconst_1
    //   2213: iadd
    //   2214: istore 8
    //   2216: goto -458 -> 1758
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2219	0	this	bocw
    //   0	2219	1	paramFile	File
    //   0	2219	2	paramInt	int
    //   0	2219	3	paramMusicItemInfo	MusicItemInfo
    //   400	1790	4	f1	float
    //   396	1609	5	f2	float
    //   414	1780	6	f3	float
    //   1136	1056	7	f4	float
    //   36	2179	8	i	int
    //   30	2080	9	j	int
    //   424	1716	10	k	int
    //   447	1721	11	m	int
    //   519	1658	12	n	int
    //   604	483	13	i1	int
    //   176	1654	14	i2	int
    //   14	765	15	i3	int
    //   223	1096	16	i4	int
    //   914	68	17	i5	int
    //   33	645	18	localObject1	Object
    //   833	39	18	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   1207	10	18	localObject2	Object
    //   1270	1	18	arrayOfByteBuffer1	java.nio.ByteBuffer[]
    //   1628	10	18	localObject3	Object
    //   1693	102	18	arrayOfShort1	short[]
    //   1935	10	18	localObject4	Object
    //   2021	17	18	localObject5	Object
    //   2050	1	18	localObject6	Object
    //   2077	27	18	localObject7	Object
    //   2133	49	18	localObject8	Object
    //   339	1858	19	localObject9	Object
    //   858	1232	20	localObject10	Object
    //   495	1611	21	localObject11	Object
    //   535	1601	22	localObject12	Object
    //   83	2076	23	localObject13	Object
    //   7	1640	24	localMediaExtractor	android.media.MediaExtractor
    //   310	1347	25	localMediaCodec	android.media.MediaCodec
    //   332	107	26	arrayOfByteBuffer2	java.nio.ByteBuffer[]
    //   348	945	27	localBufferInfo	android.media.MediaCodec.BufferInfo
    //   387	1081	28	arrayOfShort2	short[]
    // Exception table:
    //   from	to	target	type
    //   16	25	119	java/io/IOException
    //   364	373	706	finally
    //   707	709	706	finally
    //   673	679	833	java/lang/OutOfMemoryError
    //   1132	1134	1207	finally
    //   1160	1178	1207	finally
    //   1181	1204	1207	finally
    //   1209	1211	1207	finally
    //   863	871	1219	android/media/MediaCodec$CryptoException
    //   879	892	1219	android/media/MediaCodec$CryptoException
    //   897	905	1219	android/media/MediaCodec$CryptoException
    //   910	916	1219	android/media/MediaCodec$CryptoException
    //   921	940	1219	android/media/MediaCodec$CryptoException
    //   945	954	1219	android/media/MediaCodec$CryptoException
    //   959	975	1219	android/media/MediaCodec$CryptoException
    //   980	987	1219	android/media/MediaCodec$CryptoException
    //   992	1010	1219	android/media/MediaCodec$CryptoException
    //   1020	1031	1219	android/media/MediaCodec$CryptoException
    //   1049	1068	1219	android/media/MediaCodec$CryptoException
    //   1082	1089	1219	android/media/MediaCodec$CryptoException
    //   1106	1114	1219	android/media/MediaCodec$CryptoException
    //   1119	1121	1219	android/media/MediaCodec$CryptoException
    //   1216	1219	1219	android/media/MediaCodec$CryptoException
    //   1292	1302	1219	android/media/MediaCodec$CryptoException
    //   1307	1321	1219	android/media/MediaCodec$CryptoException
    //   1326	1332	1219	android/media/MediaCodec$CryptoException
    //   1337	1356	1219	android/media/MediaCodec$CryptoException
    //   1361	1370	1219	android/media/MediaCodec$CryptoException
    //   1375	1391	1219	android/media/MediaCodec$CryptoException
    //   1396	1403	1219	android/media/MediaCodec$CryptoException
    //   1408	1426	1219	android/media/MediaCodec$CryptoException
    //   1436	1447	1219	android/media/MediaCodec$CryptoException
    //   1465	1484	1219	android/media/MediaCodec$CryptoException
    //   1498	1505	1219	android/media/MediaCodec$CryptoException
    //   1522	1531	1219	android/media/MediaCodec$CryptoException
    //   1536	1538	1219	android/media/MediaCodec$CryptoException
    //   1637	1640	1219	android/media/MediaCodec$CryptoException
    //   1668	1677	1219	android/media/MediaCodec$CryptoException
    //   1682	1695	1219	android/media/MediaCodec$CryptoException
    //   1700	1709	1219	android/media/MediaCodec$CryptoException
    //   1714	1730	1219	android/media/MediaCodec$CryptoException
    //   1735	1742	1219	android/media/MediaCodec$CryptoException
    //   1747	1753	1219	android/media/MediaCodec$CryptoException
    //   1763	1774	1219	android/media/MediaCodec$CryptoException
    //   1792	1811	1219	android/media/MediaCodec$CryptoException
    //   1825	1832	1219	android/media/MediaCodec$CryptoException
    //   1849	1857	1219	android/media/MediaCodec$CryptoException
    //   1862	1864	1219	android/media/MediaCodec$CryptoException
    //   1944	1947	1219	android/media/MediaCodec$CryptoException
    //   1996	1998	1219	android/media/MediaCodec$CryptoException
    //   2030	2033	1219	android/media/MediaCodec$CryptoException
    //   1549	1551	1628	finally
    //   1573	1591	1628	finally
    //   1598	1621	1628	finally
    //   1630	1632	1628	finally
    //   863	871	1640	finally
    //   879	892	1640	finally
    //   897	905	1640	finally
    //   910	916	1640	finally
    //   921	940	1640	finally
    //   945	954	1640	finally
    //   959	975	1640	finally
    //   980	987	1640	finally
    //   992	1010	1640	finally
    //   1020	1031	1640	finally
    //   1049	1068	1640	finally
    //   1082	1089	1640	finally
    //   1106	1114	1640	finally
    //   1119	1121	1640	finally
    //   1216	1219	1640	finally
    //   1223	1234	1640	finally
    //   1292	1302	1640	finally
    //   1307	1321	1640	finally
    //   1326	1332	1640	finally
    //   1337	1356	1640	finally
    //   1361	1370	1640	finally
    //   1375	1391	1640	finally
    //   1396	1403	1640	finally
    //   1408	1426	1640	finally
    //   1436	1447	1640	finally
    //   1465	1484	1640	finally
    //   1498	1505	1640	finally
    //   1522	1531	1640	finally
    //   1536	1538	1640	finally
    //   1637	1640	1640	finally
    //   1668	1677	1640	finally
    //   1682	1695	1640	finally
    //   1700	1709	1640	finally
    //   1714	1730	1640	finally
    //   1735	1742	1640	finally
    //   1747	1753	1640	finally
    //   1763	1774	1640	finally
    //   1792	1811	1640	finally
    //   1825	1832	1640	finally
    //   1849	1857	1640	finally
    //   1862	1864	1640	finally
    //   1944	1947	1640	finally
    //   1996	1998	1640	finally
    //   2030	2033	1640	finally
    //   1871	1884	1935	finally
    //   1884	1886	1935	finally
    //   1896	1932	1935	finally
    //   1937	1939	1935	finally
    //   1947	1988	1935	finally
    //   1998	2018	2021	finally
    //   2023	2025	2021	finally
    //   416	426	2077	finally
    //   436	472	2077	finally
    //   478	484	2077	finally
    //   491	497	2077	finally
    //   509	521	2077	finally
    //   526	534	2077	finally
    //   540	562	2077	finally
    //   562	626	2077	finally
    //   629	651	2077	finally
    //   673	679	2077	finally
    //   716	729	2077	finally
    //   735	757	2077	finally
    //   764	811	2077	finally
    //   844	856	2077	finally
    //   1265	1272	2077	finally
    //   416	426	2087	android/media/MediaCodec$CryptoException
    //   436	472	2087	android/media/MediaCodec$CryptoException
    //   478	484	2087	android/media/MediaCodec$CryptoException
    //   491	497	2087	android/media/MediaCodec$CryptoException
    //   509	521	2087	android/media/MediaCodec$CryptoException
    //   526	534	2087	android/media/MediaCodec$CryptoException
    //   540	562	2087	android/media/MediaCodec$CryptoException
    //   562	626	2087	android/media/MediaCodec$CryptoException
    //   629	651	2087	android/media/MediaCodec$CryptoException
    //   673	679	2087	android/media/MediaCodec$CryptoException
    //   716	729	2087	android/media/MediaCodec$CryptoException
    //   735	757	2087	android/media/MediaCodec$CryptoException
    //   764	811	2087	android/media/MediaCodec$CryptoException
    //   844	856	2087	android/media/MediaCodec$CryptoException
    //   1265	1272	2087	android/media/MediaCodec$CryptoException
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
  
  public boolean a(MusicItemInfo paramMusicItemInfo, bocx parambocx, int paramInt)
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
    a(parambocx);
    return a(localFile, paramInt, paramMusicItemInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bocw
 * JD-Core Version:    0.7.0.1
 */