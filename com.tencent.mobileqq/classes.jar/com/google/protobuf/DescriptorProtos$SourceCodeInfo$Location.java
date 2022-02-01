package com.google.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

public final class DescriptorProtos$SourceCodeInfo$Location
  extends GeneratedMessageV3
  implements DescriptorProtos.SourceCodeInfo.LocationOrBuilder
{
  public static final int LEADING_COMMENTS_FIELD_NUMBER = 3;
  public static final int LEADING_DETACHED_COMMENTS_FIELD_NUMBER = 6;
  @Deprecated
  public static final Parser<Location> PARSER = new DescriptorProtos.SourceCodeInfo.Location.1();
  public static final int PATH_FIELD_NUMBER = 1;
  public static final int SPAN_FIELD_NUMBER = 2;
  public static final int TRAILING_COMMENTS_FIELD_NUMBER = 4;
  private static final Location a = new Location();
  private static final long serialVersionUID = 0L;
  private int bitField0_;
  private volatile Object leadingComments_;
  private LazyStringList leadingDetachedComments_;
  private byte memoizedIsInitialized = -1;
  private int pathMemoizedSerializedSize = -1;
  private Internal.IntList path_;
  private int spanMemoizedSerializedSize = -1;
  private Internal.IntList span_;
  private volatile Object trailingComments_;
  
  private DescriptorProtos$SourceCodeInfo$Location()
  {
    this.path_ = emptyIntList();
    this.span_ = emptyIntList();
    this.leadingComments_ = "";
    this.trailingComments_ = "";
    this.leadingDetachedComments_ = LazyStringArrayList.a;
  }
  
  /* Error */
  private DescriptorProtos$SourceCodeInfo$Location(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 45	com/google/protobuf/DescriptorProtos$SourceCodeInfo$Location:<init>	()V
    //   4: aload_2
    //   5: ifnull +867 -> 872
    //   8: invokestatic 90	com/google/protobuf/UnknownFieldSet:a	()Lcom/google/protobuf/UnknownFieldSet$Builder;
    //   11: astore 10
    //   13: iconst_0
    //   14: istore 8
    //   16: iconst_0
    //   17: istore_3
    //   18: iload 8
    //   20: ifne +788 -> 808
    //   23: iload_3
    //   24: istore 4
    //   26: iload_3
    //   27: istore 5
    //   29: iload_3
    //   30: istore 6
    //   32: aload_1
    //   33: invokevirtual 95	com/google/protobuf/CodedInputStream:a	()I
    //   36: istore 7
    //   38: iload 7
    //   40: ifeq +661 -> 701
    //   43: iload 7
    //   45: bipush 8
    //   47: if_icmpeq +593 -> 640
    //   50: iload 7
    //   52: bipush 10
    //   54: if_icmpeq +447 -> 501
    //   57: iload 7
    //   59: bipush 16
    //   61: if_icmpeq +379 -> 440
    //   64: iload 7
    //   66: bipush 18
    //   68: if_icmpeq +233 -> 301
    //   71: iload 7
    //   73: bipush 26
    //   75: if_icmpeq +174 -> 249
    //   78: iload 7
    //   80: bipush 34
    //   82: if_icmpeq +115 -> 197
    //   85: iload 7
    //   87: bipush 50
    //   89: if_icmpeq +28 -> 117
    //   92: iload_3
    //   93: istore 4
    //   95: iload_3
    //   96: istore 5
    //   98: iload_3
    //   99: istore 6
    //   101: aload_0
    //   102: aload_1
    //   103: aload 10
    //   105: aload_2
    //   106: iload 7
    //   108: invokevirtual 99	com/google/protobuf/DescriptorProtos$SourceCodeInfo$Location:parseUnknownField	(Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/UnknownFieldSet$Builder;Lcom/google/protobuf/ExtensionRegistryLite;I)Z
    //   111: ifne -93 -> 18
    //   114: goto +587 -> 701
    //   117: iload_3
    //   118: istore 4
    //   120: iload_3
    //   121: istore 5
    //   123: iload_3
    //   124: istore 6
    //   126: aload_1
    //   127: invokevirtual 103	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   130: astore 11
    //   132: iload_3
    //   133: istore 7
    //   135: iload_3
    //   136: bipush 16
    //   138: iand
    //   139: ifne +29 -> 168
    //   142: iload_3
    //   143: istore 4
    //   145: iload_3
    //   146: istore 5
    //   148: iload_3
    //   149: istore 6
    //   151: aload_0
    //   152: new 76	com/google/protobuf/LazyStringArrayList
    //   155: dup
    //   156: invokespecial 104	com/google/protobuf/LazyStringArrayList:<init>	()V
    //   159: putfield 80	com/google/protobuf/DescriptorProtos$SourceCodeInfo$Location:leadingDetachedComments_	Lcom/google/protobuf/LazyStringList;
    //   162: iload_3
    //   163: bipush 16
    //   165: ior
    //   166: istore 7
    //   168: iload 7
    //   170: istore 4
    //   172: iload 7
    //   174: istore 5
    //   176: iload 7
    //   178: istore 6
    //   180: aload_0
    //   181: getfield 80	com/google/protobuf/DescriptorProtos$SourceCodeInfo$Location:leadingDetachedComments_	Lcom/google/protobuf/LazyStringList;
    //   184: aload 11
    //   186: invokeinterface 109 2 0
    //   191: iload 7
    //   193: istore_3
    //   194: goto -176 -> 18
    //   197: iload_3
    //   198: istore 4
    //   200: iload_3
    //   201: istore 5
    //   203: iload_3
    //   204: istore 6
    //   206: aload_1
    //   207: invokevirtual 103	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   210: astore 11
    //   212: iload_3
    //   213: istore 4
    //   215: iload_3
    //   216: istore 5
    //   218: iload_3
    //   219: istore 6
    //   221: aload_0
    //   222: aload_0
    //   223: getfield 111	com/google/protobuf/DescriptorProtos$SourceCodeInfo$Location:bitField0_	I
    //   226: iconst_2
    //   227: ior
    //   228: putfield 111	com/google/protobuf/DescriptorProtos$SourceCodeInfo$Location:bitField0_	I
    //   231: iload_3
    //   232: istore 4
    //   234: iload_3
    //   235: istore 5
    //   237: iload_3
    //   238: istore 6
    //   240: aload_0
    //   241: aload 11
    //   243: putfield 74	com/google/protobuf/DescriptorProtos$SourceCodeInfo$Location:trailingComments_	Ljava/lang/Object;
    //   246: goto -228 -> 18
    //   249: iload_3
    //   250: istore 4
    //   252: iload_3
    //   253: istore 5
    //   255: iload_3
    //   256: istore 6
    //   258: aload_1
    //   259: invokevirtual 103	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   262: astore 11
    //   264: iload_3
    //   265: istore 4
    //   267: iload_3
    //   268: istore 5
    //   270: iload_3
    //   271: istore 6
    //   273: aload_0
    //   274: iconst_1
    //   275: aload_0
    //   276: getfield 111	com/google/protobuf/DescriptorProtos$SourceCodeInfo$Location:bitField0_	I
    //   279: ior
    //   280: putfield 111	com/google/protobuf/DescriptorProtos$SourceCodeInfo$Location:bitField0_	I
    //   283: iload_3
    //   284: istore 4
    //   286: iload_3
    //   287: istore 5
    //   289: iload_3
    //   290: istore 6
    //   292: aload_0
    //   293: aload 11
    //   295: putfield 72	com/google/protobuf/DescriptorProtos$SourceCodeInfo$Location:leadingComments_	Ljava/lang/Object;
    //   298: goto -280 -> 18
    //   301: iload_3
    //   302: istore 4
    //   304: iload_3
    //   305: istore 5
    //   307: iload_3
    //   308: istore 6
    //   310: aload_1
    //   311: aload_1
    //   312: invokevirtual 114	com/google/protobuf/CodedInputStream:s	()I
    //   315: invokevirtual 118	com/google/protobuf/CodedInputStream:c	(I)I
    //   318: istore 9
    //   320: iload_3
    //   321: istore 7
    //   323: iload_3
    //   324: iconst_2
    //   325: iand
    //   326: ifne +43 -> 369
    //   329: iload_3
    //   330: istore 7
    //   332: iload_3
    //   333: istore 4
    //   335: iload_3
    //   336: istore 5
    //   338: iload_3
    //   339: istore 6
    //   341: aload_1
    //   342: invokevirtual 121	com/google/protobuf/CodedInputStream:x	()I
    //   345: ifle +24 -> 369
    //   348: iload_3
    //   349: istore 4
    //   351: iload_3
    //   352: istore 5
    //   354: iload_3
    //   355: istore 6
    //   357: aload_0
    //   358: invokestatic 124	com/google/protobuf/DescriptorProtos$SourceCodeInfo$Location:newIntList	()Lcom/google/protobuf/Internal$IntList;
    //   361: putfield 68	com/google/protobuf/DescriptorProtos$SourceCodeInfo$Location:span_	Lcom/google/protobuf/Internal$IntList;
    //   364: iload_3
    //   365: iconst_2
    //   366: ior
    //   367: istore 7
    //   369: iload 7
    //   371: istore 4
    //   373: iload 7
    //   375: istore 5
    //   377: iload 7
    //   379: istore 6
    //   381: aload_1
    //   382: invokevirtual 121	com/google/protobuf/CodedInputStream:x	()I
    //   385: ifle +31 -> 416
    //   388: iload 7
    //   390: istore 4
    //   392: iload 7
    //   394: istore 5
    //   396: iload 7
    //   398: istore 6
    //   400: aload_0
    //   401: getfield 68	com/google/protobuf/DescriptorProtos$SourceCodeInfo$Location:span_	Lcom/google/protobuf/Internal$IntList;
    //   404: aload_1
    //   405: invokevirtual 127	com/google/protobuf/CodedInputStream:f	()I
    //   408: invokeinterface 133 2 0
    //   413: goto -44 -> 369
    //   416: iload 7
    //   418: istore 4
    //   420: iload 7
    //   422: istore 5
    //   424: iload 7
    //   426: istore 6
    //   428: aload_1
    //   429: iload 9
    //   431: invokevirtual 134	com/google/protobuf/CodedInputStream:d	(I)V
    //   434: iload 7
    //   436: istore_3
    //   437: goto -419 -> 18
    //   440: iload_3
    //   441: istore 7
    //   443: iload_3
    //   444: iconst_2
    //   445: iand
    //   446: ifne +24 -> 470
    //   449: iload_3
    //   450: istore 4
    //   452: iload_3
    //   453: istore 5
    //   455: iload_3
    //   456: istore 6
    //   458: aload_0
    //   459: invokestatic 124	com/google/protobuf/DescriptorProtos$SourceCodeInfo$Location:newIntList	()Lcom/google/protobuf/Internal$IntList;
    //   462: putfield 68	com/google/protobuf/DescriptorProtos$SourceCodeInfo$Location:span_	Lcom/google/protobuf/Internal$IntList;
    //   465: iload_3
    //   466: iconst_2
    //   467: ior
    //   468: istore 7
    //   470: iload 7
    //   472: istore 4
    //   474: iload 7
    //   476: istore 5
    //   478: iload 7
    //   480: istore 6
    //   482: aload_0
    //   483: getfield 68	com/google/protobuf/DescriptorProtos$SourceCodeInfo$Location:span_	Lcom/google/protobuf/Internal$IntList;
    //   486: aload_1
    //   487: invokevirtual 127	com/google/protobuf/CodedInputStream:f	()I
    //   490: invokeinterface 133 2 0
    //   495: iload 7
    //   497: istore_3
    //   498: goto -480 -> 18
    //   501: iload_3
    //   502: istore 4
    //   504: iload_3
    //   505: istore 5
    //   507: iload_3
    //   508: istore 6
    //   510: aload_1
    //   511: aload_1
    //   512: invokevirtual 114	com/google/protobuf/CodedInputStream:s	()I
    //   515: invokevirtual 118	com/google/protobuf/CodedInputStream:c	(I)I
    //   518: istore 9
    //   520: iload_3
    //   521: istore 7
    //   523: iload_3
    //   524: iconst_1
    //   525: iand
    //   526: ifne +43 -> 569
    //   529: iload_3
    //   530: istore 7
    //   532: iload_3
    //   533: istore 4
    //   535: iload_3
    //   536: istore 5
    //   538: iload_3
    //   539: istore 6
    //   541: aload_1
    //   542: invokevirtual 121	com/google/protobuf/CodedInputStream:x	()I
    //   545: ifle +24 -> 569
    //   548: iload_3
    //   549: istore 4
    //   551: iload_3
    //   552: istore 5
    //   554: iload_3
    //   555: istore 6
    //   557: aload_0
    //   558: invokestatic 124	com/google/protobuf/DescriptorProtos$SourceCodeInfo$Location:newIntList	()Lcom/google/protobuf/Internal$IntList;
    //   561: putfield 66	com/google/protobuf/DescriptorProtos$SourceCodeInfo$Location:path_	Lcom/google/protobuf/Internal$IntList;
    //   564: iload_3
    //   565: iconst_1
    //   566: ior
    //   567: istore 7
    //   569: iload 7
    //   571: istore 4
    //   573: iload 7
    //   575: istore 5
    //   577: iload 7
    //   579: istore 6
    //   581: aload_1
    //   582: invokevirtual 121	com/google/protobuf/CodedInputStream:x	()I
    //   585: ifle +31 -> 616
    //   588: iload 7
    //   590: istore 4
    //   592: iload 7
    //   594: istore 5
    //   596: iload 7
    //   598: istore 6
    //   600: aload_0
    //   601: getfield 66	com/google/protobuf/DescriptorProtos$SourceCodeInfo$Location:path_	Lcom/google/protobuf/Internal$IntList;
    //   604: aload_1
    //   605: invokevirtual 127	com/google/protobuf/CodedInputStream:f	()I
    //   608: invokeinterface 133 2 0
    //   613: goto -44 -> 569
    //   616: iload 7
    //   618: istore 4
    //   620: iload 7
    //   622: istore 5
    //   624: iload 7
    //   626: istore 6
    //   628: aload_1
    //   629: iload 9
    //   631: invokevirtual 134	com/google/protobuf/CodedInputStream:d	(I)V
    //   634: iload 7
    //   636: istore_3
    //   637: goto -619 -> 18
    //   640: iload_3
    //   641: istore 7
    //   643: iload_3
    //   644: iconst_1
    //   645: iand
    //   646: ifne +24 -> 670
    //   649: iload_3
    //   650: istore 4
    //   652: iload_3
    //   653: istore 5
    //   655: iload_3
    //   656: istore 6
    //   658: aload_0
    //   659: invokestatic 124	com/google/protobuf/DescriptorProtos$SourceCodeInfo$Location:newIntList	()Lcom/google/protobuf/Internal$IntList;
    //   662: putfield 66	com/google/protobuf/DescriptorProtos$SourceCodeInfo$Location:path_	Lcom/google/protobuf/Internal$IntList;
    //   665: iload_3
    //   666: iconst_1
    //   667: ior
    //   668: istore 7
    //   670: iload 7
    //   672: istore 4
    //   674: iload 7
    //   676: istore 5
    //   678: iload 7
    //   680: istore 6
    //   682: aload_0
    //   683: getfield 66	com/google/protobuf/DescriptorProtos$SourceCodeInfo$Location:path_	Lcom/google/protobuf/Internal$IntList;
    //   686: aload_1
    //   687: invokevirtual 127	com/google/protobuf/CodedInputStream:f	()I
    //   690: invokeinterface 133 2 0
    //   695: iload 7
    //   697: istore_3
    //   698: goto -680 -> 18
    //   701: iconst_1
    //   702: istore 8
    //   704: goto -686 -> 18
    //   707: astore_1
    //   708: goto +32 -> 740
    //   711: astore_1
    //   712: iload 5
    //   714: istore 4
    //   716: new 83	com/google/protobuf/InvalidProtocolBufferException
    //   719: dup
    //   720: aload_1
    //   721: invokespecial 137	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/io/IOException;)V
    //   724: aload_0
    //   725: invokevirtual 141	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   728: athrow
    //   729: astore_1
    //   730: iload 6
    //   732: istore 4
    //   734: aload_1
    //   735: aload_0
    //   736: invokevirtual 141	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   739: athrow
    //   740: iload 4
    //   742: iconst_1
    //   743: iand
    //   744: ifeq +12 -> 756
    //   747: aload_0
    //   748: getfield 66	com/google/protobuf/DescriptorProtos$SourceCodeInfo$Location:path_	Lcom/google/protobuf/Internal$IntList;
    //   751: invokeinterface 144 1 0
    //   756: iload 4
    //   758: iconst_2
    //   759: iand
    //   760: ifeq +12 -> 772
    //   763: aload_0
    //   764: getfield 68	com/google/protobuf/DescriptorProtos$SourceCodeInfo$Location:span_	Lcom/google/protobuf/Internal$IntList;
    //   767: invokeinterface 144 1 0
    //   772: iload 4
    //   774: bipush 16
    //   776: iand
    //   777: ifeq +16 -> 793
    //   780: aload_0
    //   781: aload_0
    //   782: getfield 80	com/google/protobuf/DescriptorProtos$SourceCodeInfo$Location:leadingDetachedComments_	Lcom/google/protobuf/LazyStringList;
    //   785: invokeinterface 148 1 0
    //   790: putfield 80	com/google/protobuf/DescriptorProtos$SourceCodeInfo$Location:leadingDetachedComments_	Lcom/google/protobuf/LazyStringList;
    //   793: aload_0
    //   794: aload 10
    //   796: invokevirtual 153	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   799: putfield 157	com/google/protobuf/DescriptorProtos$SourceCodeInfo$Location:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   802: aload_0
    //   803: invokevirtual 160	com/google/protobuf/DescriptorProtos$SourceCodeInfo$Location:makeExtensionsImmutable	()V
    //   806: aload_1
    //   807: athrow
    //   808: iload_3
    //   809: iconst_1
    //   810: iand
    //   811: ifeq +12 -> 823
    //   814: aload_0
    //   815: getfield 66	com/google/protobuf/DescriptorProtos$SourceCodeInfo$Location:path_	Lcom/google/protobuf/Internal$IntList;
    //   818: invokeinterface 144 1 0
    //   823: iload_3
    //   824: iconst_2
    //   825: iand
    //   826: ifeq +12 -> 838
    //   829: aload_0
    //   830: getfield 68	com/google/protobuf/DescriptorProtos$SourceCodeInfo$Location:span_	Lcom/google/protobuf/Internal$IntList;
    //   833: invokeinterface 144 1 0
    //   838: iload_3
    //   839: bipush 16
    //   841: iand
    //   842: ifeq +16 -> 858
    //   845: aload_0
    //   846: aload_0
    //   847: getfield 80	com/google/protobuf/DescriptorProtos$SourceCodeInfo$Location:leadingDetachedComments_	Lcom/google/protobuf/LazyStringList;
    //   850: invokeinterface 148 1 0
    //   855: putfield 80	com/google/protobuf/DescriptorProtos$SourceCodeInfo$Location:leadingDetachedComments_	Lcom/google/protobuf/LazyStringList;
    //   858: aload_0
    //   859: aload 10
    //   861: invokevirtual 153	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   864: putfield 157	com/google/protobuf/DescriptorProtos$SourceCodeInfo$Location:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   867: aload_0
    //   868: invokevirtual 160	com/google/protobuf/DescriptorProtos$SourceCodeInfo$Location:makeExtensionsImmutable	()V
    //   871: return
    //   872: new 162	java/lang/NullPointerException
    //   875: dup
    //   876: invokespecial 163	java/lang/NullPointerException:<init>	()V
    //   879: astore_1
    //   880: goto +5 -> 885
    //   883: aload_1
    //   884: athrow
    //   885: goto -2 -> 883
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	888	0	this	Location
    //   0	888	1	paramCodedInputStream	CodedInputStream
    //   0	888	2	paramExtensionRegistryLite	ExtensionRegistryLite
    //   17	825	3	i	int
    //   24	753	4	j	int
    //   27	686	5	k	int
    //   30	701	6	m	int
    //   36	660	7	n	int
    //   14	689	8	i1	int
    //   318	312	9	i2	int
    //   11	849	10	localBuilder	UnknownFieldSet.Builder
    //   130	164	11	localByteString	ByteString
    // Exception table:
    //   from	to	target	type
    //   32	38	707	finally
    //   101	114	707	finally
    //   126	132	707	finally
    //   151	162	707	finally
    //   180	191	707	finally
    //   206	212	707	finally
    //   221	231	707	finally
    //   240	246	707	finally
    //   258	264	707	finally
    //   273	283	707	finally
    //   292	298	707	finally
    //   310	320	707	finally
    //   341	348	707	finally
    //   357	364	707	finally
    //   381	388	707	finally
    //   400	413	707	finally
    //   428	434	707	finally
    //   458	465	707	finally
    //   482	495	707	finally
    //   510	520	707	finally
    //   541	548	707	finally
    //   557	564	707	finally
    //   581	588	707	finally
    //   600	613	707	finally
    //   628	634	707	finally
    //   658	665	707	finally
    //   682	695	707	finally
    //   716	729	707	finally
    //   734	740	707	finally
    //   32	38	711	java/io/IOException
    //   101	114	711	java/io/IOException
    //   126	132	711	java/io/IOException
    //   151	162	711	java/io/IOException
    //   180	191	711	java/io/IOException
    //   206	212	711	java/io/IOException
    //   221	231	711	java/io/IOException
    //   240	246	711	java/io/IOException
    //   258	264	711	java/io/IOException
    //   273	283	711	java/io/IOException
    //   292	298	711	java/io/IOException
    //   310	320	711	java/io/IOException
    //   341	348	711	java/io/IOException
    //   357	364	711	java/io/IOException
    //   381	388	711	java/io/IOException
    //   400	413	711	java/io/IOException
    //   428	434	711	java/io/IOException
    //   458	465	711	java/io/IOException
    //   482	495	711	java/io/IOException
    //   510	520	711	java/io/IOException
    //   541	548	711	java/io/IOException
    //   557	564	711	java/io/IOException
    //   581	588	711	java/io/IOException
    //   600	613	711	java/io/IOException
    //   628	634	711	java/io/IOException
    //   658	665	711	java/io/IOException
    //   682	695	711	java/io/IOException
    //   32	38	729	com/google/protobuf/InvalidProtocolBufferException
    //   101	114	729	com/google/protobuf/InvalidProtocolBufferException
    //   126	132	729	com/google/protobuf/InvalidProtocolBufferException
    //   151	162	729	com/google/protobuf/InvalidProtocolBufferException
    //   180	191	729	com/google/protobuf/InvalidProtocolBufferException
    //   206	212	729	com/google/protobuf/InvalidProtocolBufferException
    //   221	231	729	com/google/protobuf/InvalidProtocolBufferException
    //   240	246	729	com/google/protobuf/InvalidProtocolBufferException
    //   258	264	729	com/google/protobuf/InvalidProtocolBufferException
    //   273	283	729	com/google/protobuf/InvalidProtocolBufferException
    //   292	298	729	com/google/protobuf/InvalidProtocolBufferException
    //   310	320	729	com/google/protobuf/InvalidProtocolBufferException
    //   341	348	729	com/google/protobuf/InvalidProtocolBufferException
    //   357	364	729	com/google/protobuf/InvalidProtocolBufferException
    //   381	388	729	com/google/protobuf/InvalidProtocolBufferException
    //   400	413	729	com/google/protobuf/InvalidProtocolBufferException
    //   428	434	729	com/google/protobuf/InvalidProtocolBufferException
    //   458	465	729	com/google/protobuf/InvalidProtocolBufferException
    //   482	495	729	com/google/protobuf/InvalidProtocolBufferException
    //   510	520	729	com/google/protobuf/InvalidProtocolBufferException
    //   541	548	729	com/google/protobuf/InvalidProtocolBufferException
    //   557	564	729	com/google/protobuf/InvalidProtocolBufferException
    //   581	588	729	com/google/protobuf/InvalidProtocolBufferException
    //   600	613	729	com/google/protobuf/InvalidProtocolBufferException
    //   628	634	729	com/google/protobuf/InvalidProtocolBufferException
    //   658	665	729	com/google/protobuf/InvalidProtocolBufferException
    //   682	695	729	com/google/protobuf/InvalidProtocolBufferException
  }
  
  private DescriptorProtos$SourceCodeInfo$Location(GeneratedMessageV3.Builder<?> paramBuilder)
  {
    super(paramBuilder);
  }
  
  public static Location getDefaultInstance()
  {
    return a;
  }
  
  public static final Descriptors.Descriptor getDescriptor()
  {
    return DescriptorProtos.X();
  }
  
  public static DescriptorProtos.SourceCodeInfo.Location.Builder newBuilder()
  {
    return a.toBuilder();
  }
  
  public static DescriptorProtos.SourceCodeInfo.Location.Builder newBuilder(Location paramLocation)
  {
    return a.toBuilder().a(paramLocation);
  }
  
  public static Location parseDelimitedFrom(InputStream paramInputStream)
  {
    return (Location)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream);
  }
  
  public static Location parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (Location)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Location parseFrom(ByteString paramByteString)
  {
    return (Location)PARSER.parseFrom(paramByteString);
  }
  
  public static Location parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (Location)PARSER.parseFrom(paramByteString, paramExtensionRegistryLite);
  }
  
  public static Location parseFrom(CodedInputStream paramCodedInputStream)
  {
    return (Location)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream);
  }
  
  public static Location parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (Location)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static Location parseFrom(InputStream paramInputStream)
  {
    return (Location)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream);
  }
  
  public static Location parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (Location)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Location parseFrom(ByteBuffer paramByteBuffer)
  {
    return (Location)PARSER.parseFrom(paramByteBuffer);
  }
  
  public static Location parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (Location)PARSER.parseFrom(paramByteBuffer, paramExtensionRegistryLite);
  }
  
  public static Location parseFrom(byte[] paramArrayOfByte)
  {
    return (Location)PARSER.parseFrom(paramArrayOfByte);
  }
  
  public static Location parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (Location)PARSER.parseFrom(paramArrayOfByte, paramExtensionRegistryLite);
  }
  
  public static Parser<Location> parser()
  {
    return PARSER;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof Location)) {
      return super.equals(paramObject);
    }
    paramObject = (Location)paramObject;
    if (!getPathList().equals(paramObject.getPathList())) {
      return false;
    }
    if (!getSpanList().equals(paramObject.getSpanList())) {
      return false;
    }
    if (hasLeadingComments() != paramObject.hasLeadingComments()) {
      return false;
    }
    if ((hasLeadingComments()) && (!getLeadingComments().equals(paramObject.getLeadingComments()))) {
      return false;
    }
    if (hasTrailingComments() != paramObject.hasTrailingComments()) {
      return false;
    }
    if ((hasTrailingComments()) && (!getTrailingComments().equals(paramObject.getTrailingComments()))) {
      return false;
    }
    if (!getLeadingDetachedCommentsList().equals(paramObject.getLeadingDetachedCommentsList())) {
      return false;
    }
    return this.unknownFields.equals(paramObject.unknownFields);
  }
  
  public Location getDefaultInstanceForType()
  {
    return a;
  }
  
  public String getLeadingComments()
  {
    Object localObject = this.leadingComments_;
    if ((localObject instanceof String)) {
      return (String)localObject;
    }
    localObject = (ByteString)localObject;
    String str = ((ByteString)localObject).toStringUtf8();
    if (((ByteString)localObject).isValidUtf8()) {
      this.leadingComments_ = str;
    }
    return str;
  }
  
  public ByteString getLeadingCommentsBytes()
  {
    Object localObject = this.leadingComments_;
    if ((localObject instanceof String))
    {
      localObject = ByteString.copyFromUtf8((String)localObject);
      this.leadingComments_ = localObject;
      return localObject;
    }
    return (ByteString)localObject;
  }
  
  public String getLeadingDetachedComments(int paramInt)
  {
    return (String)this.leadingDetachedComments_.get(paramInt);
  }
  
  public ByteString getLeadingDetachedCommentsBytes(int paramInt)
  {
    return this.leadingDetachedComments_.f(paramInt);
  }
  
  public int getLeadingDetachedCommentsCount()
  {
    return this.leadingDetachedComments_.size();
  }
  
  public ProtocolStringList getLeadingDetachedCommentsList()
  {
    return this.leadingDetachedComments_;
  }
  
  public Parser<Location> getParserForType()
  {
    return PARSER;
  }
  
  public int getPath(int paramInt)
  {
    return this.path_.c(paramInt);
  }
  
  public int getPathCount()
  {
    return this.path_.size();
  }
  
  public List<Integer> getPathList()
  {
    return this.path_;
  }
  
  public int getSerializedSize()
  {
    int i = this.memoizedSize;
    if (i != -1) {
      return i;
    }
    int m = 0;
    i = 0;
    int j = 0;
    while (i < this.path_.size())
    {
      j += CodedOutputStream.i(this.path_.c(i));
      i += 1;
    }
    int k = 0 + j;
    i = k;
    if (!getPathList().isEmpty()) {
      i = k + 1 + CodedOutputStream.i(j);
    }
    this.pathMemoizedSerializedSize = j;
    k = 0;
    j = 0;
    while (k < this.span_.size())
    {
      j += CodedOutputStream.i(this.span_.c(k));
      k += 1;
    }
    k = i + j;
    i = k;
    if (!getSpanList().isEmpty()) {
      i = k + 1 + CodedOutputStream.i(j);
    }
    this.spanMemoizedSerializedSize = j;
    j = i;
    if ((this.bitField0_ & 0x1) != 0) {
      j = i + GeneratedMessageV3.computeStringSize(3, this.leadingComments_);
    }
    i = j;
    if ((this.bitField0_ & 0x2) != 0) {
      i = j + GeneratedMessageV3.computeStringSize(4, this.trailingComments_);
    }
    k = 0;
    j = m;
    while (j < this.leadingDetachedComments_.size())
    {
      k += computeStringSizeNoTag(this.leadingDetachedComments_.d(j));
      j += 1;
    }
    i = i + k + getLeadingDetachedCommentsList().size() * 1 + this.unknownFields.getSerializedSize();
    this.memoizedSize = i;
    return i;
  }
  
  public int getSpan(int paramInt)
  {
    return this.span_.c(paramInt);
  }
  
  public int getSpanCount()
  {
    return this.span_.size();
  }
  
  public List<Integer> getSpanList()
  {
    return this.span_;
  }
  
  public String getTrailingComments()
  {
    Object localObject = this.trailingComments_;
    if ((localObject instanceof String)) {
      return (String)localObject;
    }
    localObject = (ByteString)localObject;
    String str = ((ByteString)localObject).toStringUtf8();
    if (((ByteString)localObject).isValidUtf8()) {
      this.trailingComments_ = str;
    }
    return str;
  }
  
  public ByteString getTrailingCommentsBytes()
  {
    Object localObject = this.trailingComments_;
    if ((localObject instanceof String))
    {
      localObject = ByteString.copyFromUtf8((String)localObject);
      this.trailingComments_ = localObject;
      return localObject;
    }
    return (ByteString)localObject;
  }
  
  public final UnknownFieldSet getUnknownFields()
  {
    return this.unknownFields;
  }
  
  public boolean hasLeadingComments()
  {
    return (this.bitField0_ & 0x1) != 0;
  }
  
  public boolean hasTrailingComments()
  {
    return (this.bitField0_ & 0x2) != 0;
  }
  
  public int hashCode()
  {
    if (this.memoizedHashCode != 0) {
      return this.memoizedHashCode;
    }
    int j = 779 + getDescriptor().hashCode();
    int i = j;
    if (getPathCount() > 0) {
      i = (j * 37 + 1) * 53 + getPathList().hashCode();
    }
    j = i;
    if (getSpanCount() > 0) {
      j = (i * 37 + 2) * 53 + getSpanList().hashCode();
    }
    i = j;
    if (hasLeadingComments()) {
      i = (j * 37 + 3) * 53 + getLeadingComments().hashCode();
    }
    j = i;
    if (hasTrailingComments()) {
      j = (i * 37 + 4) * 53 + getTrailingComments().hashCode();
    }
    i = j;
    if (getLeadingDetachedCommentsCount() > 0) {
      i = (j * 37 + 6) * 53 + getLeadingDetachedCommentsList().hashCode();
    }
    i = i * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    return i;
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return DescriptorProtos.Y().a(Location.class, DescriptorProtos.SourceCodeInfo.Location.Builder.class);
  }
  
  public final boolean isInitialized()
  {
    int i = this.memoizedIsInitialized;
    if (i == 1) {
      return true;
    }
    if (i == 0) {
      return false;
    }
    this.memoizedIsInitialized = 1;
    return true;
  }
  
  public DescriptorProtos.SourceCodeInfo.Location.Builder newBuilderForType()
  {
    return newBuilder();
  }
  
  protected DescriptorProtos.SourceCodeInfo.Location.Builder newBuilderForType(GeneratedMessageV3.BuilderParent paramBuilderParent)
  {
    return new DescriptorProtos.SourceCodeInfo.Location.Builder(paramBuilderParent, null);
  }
  
  protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter paramUnusedPrivateParameter)
  {
    return new Location();
  }
  
  public DescriptorProtos.SourceCodeInfo.Location.Builder toBuilder()
  {
    if (this == a) {
      return new DescriptorProtos.SourceCodeInfo.Location.Builder(null);
    }
    return new DescriptorProtos.SourceCodeInfo.Location.Builder(null).a(this);
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
  {
    getSerializedSize();
    if (getPathList().size() > 0)
    {
      paramCodedOutputStream.c(10);
      paramCodedOutputStream.c(this.pathMemoizedSerializedSize);
    }
    int j = 0;
    int i = 0;
    while (i < this.path_.size())
    {
      paramCodedOutputStream.b(this.path_.c(i));
      i += 1;
    }
    if (getSpanList().size() > 0)
    {
      paramCodedOutputStream.c(18);
      paramCodedOutputStream.c(this.spanMemoizedSerializedSize);
    }
    i = 0;
    while (i < this.span_.size())
    {
      paramCodedOutputStream.b(this.span_.c(i));
      i += 1;
    }
    if ((this.bitField0_ & 0x1) != 0) {
      GeneratedMessageV3.writeString(paramCodedOutputStream, 3, this.leadingComments_);
    }
    i = j;
    if ((this.bitField0_ & 0x2) != 0)
    {
      GeneratedMessageV3.writeString(paramCodedOutputStream, 4, this.trailingComments_);
      i = j;
    }
    while (i < this.leadingDetachedComments_.size())
    {
      GeneratedMessageV3.writeString(paramCodedOutputStream, 6, this.leadingDetachedComments_.d(i));
      i += 1;
    }
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.DescriptorProtos.SourceCodeInfo.Location
 * JD-Core Version:    0.7.0.1
 */