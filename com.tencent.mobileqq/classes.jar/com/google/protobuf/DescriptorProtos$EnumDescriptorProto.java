package com.google.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

public final class DescriptorProtos$EnumDescriptorProto
  extends GeneratedMessageV3
  implements DescriptorProtos.EnumDescriptorProtoOrBuilder
{
  public static final int NAME_FIELD_NUMBER = 1;
  public static final int OPTIONS_FIELD_NUMBER = 3;
  @Deprecated
  public static final Parser<EnumDescriptorProto> PARSER = new DescriptorProtos.EnumDescriptorProto.1();
  public static final int RESERVED_NAME_FIELD_NUMBER = 5;
  public static final int RESERVED_RANGE_FIELD_NUMBER = 4;
  public static final int VALUE_FIELD_NUMBER = 2;
  private static final EnumDescriptorProto a = new EnumDescriptorProto();
  private static final long serialVersionUID = 0L;
  private int bitField0_;
  private byte memoizedIsInitialized = -1;
  private volatile Object name_;
  private DescriptorProtos.EnumOptions options_;
  private LazyStringList reservedName_;
  private List<DescriptorProtos.EnumDescriptorProto.EnumReservedRange> reservedRange_;
  private List<DescriptorProtos.EnumValueDescriptorProto> value_;
  
  private DescriptorProtos$EnumDescriptorProto()
  {
    this.name_ = "";
    this.value_ = Collections.emptyList();
    this.reservedRange_ = Collections.emptyList();
    this.reservedName_ = LazyStringArrayList.a;
  }
  
  /* Error */
  private DescriptorProtos$EnumDescriptorProto(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 46	com/google/protobuf/DescriptorProtos$EnumDescriptorProto:<init>	()V
    //   4: aload_2
    //   5: ifnull +680 -> 685
    //   8: invokestatic 87	com/google/protobuf/UnknownFieldSet:a	()Lcom/google/protobuf/UnknownFieldSet$Builder;
    //   11: astore 10
    //   13: iconst_0
    //   14: istore 8
    //   16: iconst_0
    //   17: istore_3
    //   18: iload 8
    //   20: ifne +596 -> 616
    //   23: iload_3
    //   24: istore 4
    //   26: iload_3
    //   27: istore 5
    //   29: iload_3
    //   30: istore 6
    //   32: aload_1
    //   33: invokevirtual 92	com/google/protobuf/CodedInputStream:a	()I
    //   36: istore 7
    //   38: iload 7
    //   40: ifeq +464 -> 504
    //   43: iload 7
    //   45: bipush 10
    //   47: if_icmpeq +405 -> 452
    //   50: iload 7
    //   52: bipush 18
    //   54: if_icmpeq +328 -> 382
    //   57: iload 7
    //   59: bipush 26
    //   61: if_icmpeq +194 -> 255
    //   64: iload 7
    //   66: bipush 34
    //   68: if_icmpeq +115 -> 183
    //   71: iload 7
    //   73: bipush 42
    //   75: if_icmpeq +28 -> 103
    //   78: iload_3
    //   79: istore 4
    //   81: iload_3
    //   82: istore 5
    //   84: iload_3
    //   85: istore 6
    //   87: aload_0
    //   88: aload_1
    //   89: aload 10
    //   91: aload_2
    //   92: iload 7
    //   94: invokevirtual 96	com/google/protobuf/DescriptorProtos$EnumDescriptorProto:parseUnknownField	(Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/UnknownFieldSet$Builder;Lcom/google/protobuf/ExtensionRegistryLite;I)Z
    //   97: ifne -79 -> 18
    //   100: goto +404 -> 504
    //   103: iload_3
    //   104: istore 4
    //   106: iload_3
    //   107: istore 5
    //   109: iload_3
    //   110: istore 6
    //   112: aload_1
    //   113: invokevirtual 100	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   116: astore 9
    //   118: iload_3
    //   119: istore 7
    //   121: iload_3
    //   122: bipush 16
    //   124: iand
    //   125: ifne +29 -> 154
    //   128: iload_3
    //   129: istore 4
    //   131: iload_3
    //   132: istore 5
    //   134: iload_3
    //   135: istore 6
    //   137: aload_0
    //   138: new 73	com/google/protobuf/LazyStringArrayList
    //   141: dup
    //   142: invokespecial 101	com/google/protobuf/LazyStringArrayList:<init>	()V
    //   145: putfield 77	com/google/protobuf/DescriptorProtos$EnumDescriptorProto:reservedName_	Lcom/google/protobuf/LazyStringList;
    //   148: iload_3
    //   149: bipush 16
    //   151: ior
    //   152: istore 7
    //   154: iload 7
    //   156: istore 4
    //   158: iload 7
    //   160: istore 5
    //   162: iload 7
    //   164: istore 6
    //   166: aload_0
    //   167: getfield 77	com/google/protobuf/DescriptorProtos$EnumDescriptorProto:reservedName_	Lcom/google/protobuf/LazyStringList;
    //   170: aload 9
    //   172: invokeinterface 106 2 0
    //   177: iload 7
    //   179: istore_3
    //   180: goto -162 -> 18
    //   183: iload_3
    //   184: istore 7
    //   186: iload_3
    //   187: bipush 8
    //   189: iand
    //   190: ifne +29 -> 219
    //   193: iload_3
    //   194: istore 4
    //   196: iload_3
    //   197: istore 5
    //   199: iload_3
    //   200: istore 6
    //   202: aload_0
    //   203: new 108	java/util/ArrayList
    //   206: dup
    //   207: invokespecial 109	java/util/ArrayList:<init>	()V
    //   210: putfield 71	com/google/protobuf/DescriptorProtos$EnumDescriptorProto:reservedRange_	Ljava/util/List;
    //   213: iload_3
    //   214: bipush 8
    //   216: ior
    //   217: istore 7
    //   219: iload 7
    //   221: istore 4
    //   223: iload 7
    //   225: istore 5
    //   227: iload 7
    //   229: istore 6
    //   231: aload_0
    //   232: getfield 71	com/google/protobuf/DescriptorProtos$EnumDescriptorProto:reservedRange_	Ljava/util/List;
    //   235: aload_1
    //   236: getstatic 112	com/google/protobuf/DescriptorProtos$EnumDescriptorProto$EnumReservedRange:PARSER	Lcom/google/protobuf/Parser;
    //   239: aload_2
    //   240: invokevirtual 115	com/google/protobuf/CodedInputStream:a	(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   243: invokeinterface 121 2 0
    //   248: pop
    //   249: iload 7
    //   251: istore_3
    //   252: goto -234 -> 18
    //   255: aconst_null
    //   256: astore 9
    //   258: iload_3
    //   259: istore 4
    //   261: iload_3
    //   262: istore 5
    //   264: iload_3
    //   265: istore 6
    //   267: aload_0
    //   268: getfield 123	com/google/protobuf/DescriptorProtos$EnumDescriptorProto:bitField0_	I
    //   271: iconst_2
    //   272: iand
    //   273: ifeq +21 -> 294
    //   276: iload_3
    //   277: istore 4
    //   279: iload_3
    //   280: istore 5
    //   282: iload_3
    //   283: istore 6
    //   285: aload_0
    //   286: getfield 125	com/google/protobuf/DescriptorProtos$EnumDescriptorProto:options_	Lcom/google/protobuf/DescriptorProtos$EnumOptions;
    //   289: invokevirtual 131	com/google/protobuf/DescriptorProtos$EnumOptions:toBuilder	()Lcom/google/protobuf/DescriptorProtos$EnumOptions$Builder;
    //   292: astore 9
    //   294: iload_3
    //   295: istore 4
    //   297: iload_3
    //   298: istore 5
    //   300: iload_3
    //   301: istore 6
    //   303: aload_0
    //   304: aload_1
    //   305: getstatic 132	com/google/protobuf/DescriptorProtos$EnumOptions:PARSER	Lcom/google/protobuf/Parser;
    //   308: aload_2
    //   309: invokevirtual 115	com/google/protobuf/CodedInputStream:a	(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   312: checkcast 127	com/google/protobuf/DescriptorProtos$EnumOptions
    //   315: putfield 125	com/google/protobuf/DescriptorProtos$EnumDescriptorProto:options_	Lcom/google/protobuf/DescriptorProtos$EnumOptions;
    //   318: aload 9
    //   320: ifnull +40 -> 360
    //   323: iload_3
    //   324: istore 4
    //   326: iload_3
    //   327: istore 5
    //   329: iload_3
    //   330: istore 6
    //   332: aload 9
    //   334: aload_0
    //   335: getfield 125	com/google/protobuf/DescriptorProtos$EnumDescriptorProto:options_	Lcom/google/protobuf/DescriptorProtos$EnumOptions;
    //   338: invokevirtual 137	com/google/protobuf/DescriptorProtos$EnumOptions$Builder:a	(Lcom/google/protobuf/DescriptorProtos$EnumOptions;)Lcom/google/protobuf/DescriptorProtos$EnumOptions$Builder;
    //   341: pop
    //   342: iload_3
    //   343: istore 4
    //   345: iload_3
    //   346: istore 5
    //   348: iload_3
    //   349: istore 6
    //   351: aload_0
    //   352: aload 9
    //   354: invokevirtual 141	com/google/protobuf/DescriptorProtos$EnumOptions$Builder:d	()Lcom/google/protobuf/DescriptorProtos$EnumOptions;
    //   357: putfield 125	com/google/protobuf/DescriptorProtos$EnumDescriptorProto:options_	Lcom/google/protobuf/DescriptorProtos$EnumOptions;
    //   360: iload_3
    //   361: istore 4
    //   363: iload_3
    //   364: istore 5
    //   366: iload_3
    //   367: istore 6
    //   369: aload_0
    //   370: aload_0
    //   371: getfield 123	com/google/protobuf/DescriptorProtos$EnumDescriptorProto:bitField0_	I
    //   374: iconst_2
    //   375: ior
    //   376: putfield 123	com/google/protobuf/DescriptorProtos$EnumDescriptorProto:bitField0_	I
    //   379: goto -361 -> 18
    //   382: iload_3
    //   383: istore 7
    //   385: iload_3
    //   386: iconst_2
    //   387: iand
    //   388: ifne +28 -> 416
    //   391: iload_3
    //   392: istore 4
    //   394: iload_3
    //   395: istore 5
    //   397: iload_3
    //   398: istore 6
    //   400: aload_0
    //   401: new 108	java/util/ArrayList
    //   404: dup
    //   405: invokespecial 109	java/util/ArrayList:<init>	()V
    //   408: putfield 69	com/google/protobuf/DescriptorProtos$EnumDescriptorProto:value_	Ljava/util/List;
    //   411: iload_3
    //   412: iconst_2
    //   413: ior
    //   414: istore 7
    //   416: iload 7
    //   418: istore 4
    //   420: iload 7
    //   422: istore 5
    //   424: iload 7
    //   426: istore 6
    //   428: aload_0
    //   429: getfield 69	com/google/protobuf/DescriptorProtos$EnumDescriptorProto:value_	Ljava/util/List;
    //   432: aload_1
    //   433: getstatic 144	com/google/protobuf/DescriptorProtos$EnumValueDescriptorProto:PARSER	Lcom/google/protobuf/Parser;
    //   436: aload_2
    //   437: invokevirtual 115	com/google/protobuf/CodedInputStream:a	(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   440: invokeinterface 121 2 0
    //   445: pop
    //   446: iload 7
    //   448: istore_3
    //   449: goto -431 -> 18
    //   452: iload_3
    //   453: istore 4
    //   455: iload_3
    //   456: istore 5
    //   458: iload_3
    //   459: istore 6
    //   461: aload_1
    //   462: invokevirtual 100	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   465: astore 9
    //   467: iload_3
    //   468: istore 4
    //   470: iload_3
    //   471: istore 5
    //   473: iload_3
    //   474: istore 6
    //   476: aload_0
    //   477: iconst_1
    //   478: aload_0
    //   479: getfield 123	com/google/protobuf/DescriptorProtos$EnumDescriptorProto:bitField0_	I
    //   482: ior
    //   483: putfield 123	com/google/protobuf/DescriptorProtos$EnumDescriptorProto:bitField0_	I
    //   486: iload_3
    //   487: istore 4
    //   489: iload_3
    //   490: istore 5
    //   492: iload_3
    //   493: istore 6
    //   495: aload_0
    //   496: aload 9
    //   498: putfield 61	com/google/protobuf/DescriptorProtos$EnumDescriptorProto:name_	Ljava/lang/Object;
    //   501: goto -483 -> 18
    //   504: iconst_1
    //   505: istore 8
    //   507: goto -489 -> 18
    //   510: astore_1
    //   511: goto +32 -> 543
    //   514: astore_1
    //   515: iload 5
    //   517: istore 4
    //   519: new 80	com/google/protobuf/InvalidProtocolBufferException
    //   522: dup
    //   523: aload_1
    //   524: invokespecial 147	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/io/IOException;)V
    //   527: aload_0
    //   528: invokevirtual 151	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   531: athrow
    //   532: astore_1
    //   533: iload 6
    //   535: istore 4
    //   537: aload_1
    //   538: aload_0
    //   539: invokevirtual 151	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   542: athrow
    //   543: iload 4
    //   545: iconst_2
    //   546: iand
    //   547: ifeq +14 -> 561
    //   550: aload_0
    //   551: aload_0
    //   552: getfield 69	com/google/protobuf/DescriptorProtos$EnumDescriptorProto:value_	Ljava/util/List;
    //   555: invokestatic 155	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   558: putfield 69	com/google/protobuf/DescriptorProtos$EnumDescriptorProto:value_	Ljava/util/List;
    //   561: iload 4
    //   563: bipush 8
    //   565: iand
    //   566: ifeq +14 -> 580
    //   569: aload_0
    //   570: aload_0
    //   571: getfield 71	com/google/protobuf/DescriptorProtos$EnumDescriptorProto:reservedRange_	Ljava/util/List;
    //   574: invokestatic 155	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   577: putfield 71	com/google/protobuf/DescriptorProtos$EnumDescriptorProto:reservedRange_	Ljava/util/List;
    //   580: iload 4
    //   582: bipush 16
    //   584: iand
    //   585: ifeq +16 -> 601
    //   588: aload_0
    //   589: aload_0
    //   590: getfield 77	com/google/protobuf/DescriptorProtos$EnumDescriptorProto:reservedName_	Lcom/google/protobuf/LazyStringList;
    //   593: invokeinterface 159 1 0
    //   598: putfield 77	com/google/protobuf/DescriptorProtos$EnumDescriptorProto:reservedName_	Lcom/google/protobuf/LazyStringList;
    //   601: aload_0
    //   602: aload 10
    //   604: invokevirtual 164	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   607: putfield 168	com/google/protobuf/DescriptorProtos$EnumDescriptorProto:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   610: aload_0
    //   611: invokevirtual 171	com/google/protobuf/DescriptorProtos$EnumDescriptorProto:makeExtensionsImmutable	()V
    //   614: aload_1
    //   615: athrow
    //   616: iload_3
    //   617: iconst_2
    //   618: iand
    //   619: ifeq +14 -> 633
    //   622: aload_0
    //   623: aload_0
    //   624: getfield 69	com/google/protobuf/DescriptorProtos$EnumDescriptorProto:value_	Ljava/util/List;
    //   627: invokestatic 155	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   630: putfield 69	com/google/protobuf/DescriptorProtos$EnumDescriptorProto:value_	Ljava/util/List;
    //   633: iload_3
    //   634: bipush 8
    //   636: iand
    //   637: ifeq +14 -> 651
    //   640: aload_0
    //   641: aload_0
    //   642: getfield 71	com/google/protobuf/DescriptorProtos$EnumDescriptorProto:reservedRange_	Ljava/util/List;
    //   645: invokestatic 155	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   648: putfield 71	com/google/protobuf/DescriptorProtos$EnumDescriptorProto:reservedRange_	Ljava/util/List;
    //   651: iload_3
    //   652: bipush 16
    //   654: iand
    //   655: ifeq +16 -> 671
    //   658: aload_0
    //   659: aload_0
    //   660: getfield 77	com/google/protobuf/DescriptorProtos$EnumDescriptorProto:reservedName_	Lcom/google/protobuf/LazyStringList;
    //   663: invokeinterface 159 1 0
    //   668: putfield 77	com/google/protobuf/DescriptorProtos$EnumDescriptorProto:reservedName_	Lcom/google/protobuf/LazyStringList;
    //   671: aload_0
    //   672: aload 10
    //   674: invokevirtual 164	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   677: putfield 168	com/google/protobuf/DescriptorProtos$EnumDescriptorProto:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   680: aload_0
    //   681: invokevirtual 171	com/google/protobuf/DescriptorProtos$EnumDescriptorProto:makeExtensionsImmutable	()V
    //   684: return
    //   685: new 173	java/lang/NullPointerException
    //   688: dup
    //   689: invokespecial 174	java/lang/NullPointerException:<init>	()V
    //   692: astore_1
    //   693: goto +5 -> 698
    //   696: aload_1
    //   697: athrow
    //   698: goto -2 -> 696
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	701	0	this	EnumDescriptorProto
    //   0	701	1	paramCodedInputStream	CodedInputStream
    //   0	701	2	paramExtensionRegistryLite	ExtensionRegistryLite
    //   17	638	3	i	int
    //   24	561	4	j	int
    //   27	489	5	k	int
    //   30	504	6	m	int
    //   36	411	7	n	int
    //   14	492	8	i1	int
    //   116	381	9	localObject	Object
    //   11	662	10	localBuilder	UnknownFieldSet.Builder
    // Exception table:
    //   from	to	target	type
    //   32	38	510	finally
    //   87	100	510	finally
    //   112	118	510	finally
    //   137	148	510	finally
    //   166	177	510	finally
    //   202	213	510	finally
    //   231	249	510	finally
    //   267	276	510	finally
    //   285	294	510	finally
    //   303	318	510	finally
    //   332	342	510	finally
    //   351	360	510	finally
    //   369	379	510	finally
    //   400	411	510	finally
    //   428	446	510	finally
    //   461	467	510	finally
    //   476	486	510	finally
    //   495	501	510	finally
    //   519	532	510	finally
    //   537	543	510	finally
    //   32	38	514	java/io/IOException
    //   87	100	514	java/io/IOException
    //   112	118	514	java/io/IOException
    //   137	148	514	java/io/IOException
    //   166	177	514	java/io/IOException
    //   202	213	514	java/io/IOException
    //   231	249	514	java/io/IOException
    //   267	276	514	java/io/IOException
    //   285	294	514	java/io/IOException
    //   303	318	514	java/io/IOException
    //   332	342	514	java/io/IOException
    //   351	360	514	java/io/IOException
    //   369	379	514	java/io/IOException
    //   400	411	514	java/io/IOException
    //   428	446	514	java/io/IOException
    //   461	467	514	java/io/IOException
    //   476	486	514	java/io/IOException
    //   495	501	514	java/io/IOException
    //   32	38	532	com/google/protobuf/InvalidProtocolBufferException
    //   87	100	532	com/google/protobuf/InvalidProtocolBufferException
    //   112	118	532	com/google/protobuf/InvalidProtocolBufferException
    //   137	148	532	com/google/protobuf/InvalidProtocolBufferException
    //   166	177	532	com/google/protobuf/InvalidProtocolBufferException
    //   202	213	532	com/google/protobuf/InvalidProtocolBufferException
    //   231	249	532	com/google/protobuf/InvalidProtocolBufferException
    //   267	276	532	com/google/protobuf/InvalidProtocolBufferException
    //   285	294	532	com/google/protobuf/InvalidProtocolBufferException
    //   303	318	532	com/google/protobuf/InvalidProtocolBufferException
    //   332	342	532	com/google/protobuf/InvalidProtocolBufferException
    //   351	360	532	com/google/protobuf/InvalidProtocolBufferException
    //   369	379	532	com/google/protobuf/InvalidProtocolBufferException
    //   400	411	532	com/google/protobuf/InvalidProtocolBufferException
    //   428	446	532	com/google/protobuf/InvalidProtocolBufferException
    //   461	467	532	com/google/protobuf/InvalidProtocolBufferException
    //   476	486	532	com/google/protobuf/InvalidProtocolBufferException
    //   495	501	532	com/google/protobuf/InvalidProtocolBufferException
  }
  
  private DescriptorProtos$EnumDescriptorProto(GeneratedMessageV3.Builder<?> paramBuilder)
  {
    super(paramBuilder);
  }
  
  public static EnumDescriptorProto getDefaultInstance()
  {
    return a;
  }
  
  public static final Descriptors.Descriptor getDescriptor()
  {
    return DescriptorProtos.r();
  }
  
  public static DescriptorProtos.EnumDescriptorProto.Builder newBuilder()
  {
    return a.toBuilder();
  }
  
  public static DescriptorProtos.EnumDescriptorProto.Builder newBuilder(EnumDescriptorProto paramEnumDescriptorProto)
  {
    return a.toBuilder().a(paramEnumDescriptorProto);
  }
  
  public static EnumDescriptorProto parseDelimitedFrom(InputStream paramInputStream)
  {
    return (EnumDescriptorProto)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream);
  }
  
  public static EnumDescriptorProto parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (EnumDescriptorProto)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static EnumDescriptorProto parseFrom(ByteString paramByteString)
  {
    return (EnumDescriptorProto)PARSER.parseFrom(paramByteString);
  }
  
  public static EnumDescriptorProto parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (EnumDescriptorProto)PARSER.parseFrom(paramByteString, paramExtensionRegistryLite);
  }
  
  public static EnumDescriptorProto parseFrom(CodedInputStream paramCodedInputStream)
  {
    return (EnumDescriptorProto)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream);
  }
  
  public static EnumDescriptorProto parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (EnumDescriptorProto)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static EnumDescriptorProto parseFrom(InputStream paramInputStream)
  {
    return (EnumDescriptorProto)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream);
  }
  
  public static EnumDescriptorProto parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (EnumDescriptorProto)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static EnumDescriptorProto parseFrom(ByteBuffer paramByteBuffer)
  {
    return (EnumDescriptorProto)PARSER.parseFrom(paramByteBuffer);
  }
  
  public static EnumDescriptorProto parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (EnumDescriptorProto)PARSER.parseFrom(paramByteBuffer, paramExtensionRegistryLite);
  }
  
  public static EnumDescriptorProto parseFrom(byte[] paramArrayOfByte)
  {
    return (EnumDescriptorProto)PARSER.parseFrom(paramArrayOfByte);
  }
  
  public static EnumDescriptorProto parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (EnumDescriptorProto)PARSER.parseFrom(paramArrayOfByte, paramExtensionRegistryLite);
  }
  
  public static Parser<EnumDescriptorProto> parser()
  {
    return PARSER;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof EnumDescriptorProto)) {
      return super.equals(paramObject);
    }
    paramObject = (EnumDescriptorProto)paramObject;
    if (hasName() != paramObject.hasName()) {
      return false;
    }
    if ((hasName()) && (!getName().equals(paramObject.getName()))) {
      return false;
    }
    if (!getValueList().equals(paramObject.getValueList())) {
      return false;
    }
    if (hasOptions() != paramObject.hasOptions()) {
      return false;
    }
    if ((hasOptions()) && (!getOptions().equals(paramObject.getOptions()))) {
      return false;
    }
    if (!getReservedRangeList().equals(paramObject.getReservedRangeList())) {
      return false;
    }
    if (!getReservedNameList().equals(paramObject.getReservedNameList())) {
      return false;
    }
    return this.unknownFields.equals(paramObject.unknownFields);
  }
  
  public EnumDescriptorProto getDefaultInstanceForType()
  {
    return a;
  }
  
  public String getName()
  {
    Object localObject = this.name_;
    if ((localObject instanceof String)) {
      return (String)localObject;
    }
    localObject = (ByteString)localObject;
    String str = ((ByteString)localObject).toStringUtf8();
    if (((ByteString)localObject).isValidUtf8()) {
      this.name_ = str;
    }
    return str;
  }
  
  public ByteString getNameBytes()
  {
    Object localObject = this.name_;
    if ((localObject instanceof String))
    {
      localObject = ByteString.copyFromUtf8((String)localObject);
      this.name_ = localObject;
      return localObject;
    }
    return (ByteString)localObject;
  }
  
  public DescriptorProtos.EnumOptions getOptions()
  {
    DescriptorProtos.EnumOptions localEnumOptions2 = this.options_;
    DescriptorProtos.EnumOptions localEnumOptions1 = localEnumOptions2;
    if (localEnumOptions2 == null) {
      localEnumOptions1 = DescriptorProtos.EnumOptions.getDefaultInstance();
    }
    return localEnumOptions1;
  }
  
  public DescriptorProtos.EnumOptionsOrBuilder getOptionsOrBuilder()
  {
    DescriptorProtos.EnumOptions localEnumOptions2 = this.options_;
    DescriptorProtos.EnumOptions localEnumOptions1 = localEnumOptions2;
    if (localEnumOptions2 == null) {
      localEnumOptions1 = DescriptorProtos.EnumOptions.getDefaultInstance();
    }
    return localEnumOptions1;
  }
  
  public Parser<EnumDescriptorProto> getParserForType()
  {
    return PARSER;
  }
  
  public String getReservedName(int paramInt)
  {
    return (String)this.reservedName_.get(paramInt);
  }
  
  public ByteString getReservedNameBytes(int paramInt)
  {
    return this.reservedName_.f(paramInt);
  }
  
  public int getReservedNameCount()
  {
    return this.reservedName_.size();
  }
  
  public ProtocolStringList getReservedNameList()
  {
    return this.reservedName_;
  }
  
  public DescriptorProtos.EnumDescriptorProto.EnumReservedRange getReservedRange(int paramInt)
  {
    return (DescriptorProtos.EnumDescriptorProto.EnumReservedRange)this.reservedRange_.get(paramInt);
  }
  
  public int getReservedRangeCount()
  {
    return this.reservedRange_.size();
  }
  
  public List<DescriptorProtos.EnumDescriptorProto.EnumReservedRange> getReservedRangeList()
  {
    return this.reservedRange_;
  }
  
  public DescriptorProtos.EnumDescriptorProto.EnumReservedRangeOrBuilder getReservedRangeOrBuilder(int paramInt)
  {
    return (DescriptorProtos.EnumDescriptorProto.EnumReservedRangeOrBuilder)this.reservedRange_.get(paramInt);
  }
  
  public List<? extends DescriptorProtos.EnumDescriptorProto.EnumReservedRangeOrBuilder> getReservedRangeOrBuilderList()
  {
    return this.reservedRange_;
  }
  
  public int getSerializedSize()
  {
    int i = this.memoizedSize;
    if (i != -1) {
      return i;
    }
    i = this.bitField0_;
    int k = 0;
    if ((i & 0x1) != 0) {
      i = GeneratedMessageV3.computeStringSize(1, this.name_) + 0;
    } else {
      i = 0;
    }
    int j = 0;
    while (j < this.value_.size())
    {
      i += CodedOutputStream.c(2, (MessageLite)this.value_.get(j));
      j += 1;
    }
    j = i;
    if ((this.bitField0_ & 0x2) != 0) {
      j = i + CodedOutputStream.c(3, getOptions());
    }
    i = 0;
    while (i < this.reservedRange_.size())
    {
      j += CodedOutputStream.c(4, (MessageLite)this.reservedRange_.get(i));
      i += 1;
    }
    int m = 0;
    i = k;
    k = m;
    while (i < this.reservedName_.size())
    {
      k += computeStringSizeNoTag(this.reservedName_.d(i));
      i += 1;
    }
    i = j + k + getReservedNameList().size() * 1 + this.unknownFields.getSerializedSize();
    this.memoizedSize = i;
    return i;
  }
  
  public final UnknownFieldSet getUnknownFields()
  {
    return this.unknownFields;
  }
  
  public DescriptorProtos.EnumValueDescriptorProto getValue(int paramInt)
  {
    return (DescriptorProtos.EnumValueDescriptorProto)this.value_.get(paramInt);
  }
  
  public int getValueCount()
  {
    return this.value_.size();
  }
  
  public List<DescriptorProtos.EnumValueDescriptorProto> getValueList()
  {
    return this.value_;
  }
  
  public DescriptorProtos.EnumValueDescriptorProtoOrBuilder getValueOrBuilder(int paramInt)
  {
    return (DescriptorProtos.EnumValueDescriptorProtoOrBuilder)this.value_.get(paramInt);
  }
  
  public List<? extends DescriptorProtos.EnumValueDescriptorProtoOrBuilder> getValueOrBuilderList()
  {
    return this.value_;
  }
  
  public boolean hasName()
  {
    return (this.bitField0_ & 0x1) != 0;
  }
  
  public boolean hasOptions()
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
    if (hasName()) {
      i = (j * 37 + 1) * 53 + getName().hashCode();
    }
    j = i;
    if (getValueCount() > 0) {
      j = (i * 37 + 2) * 53 + getValueList().hashCode();
    }
    i = j;
    if (hasOptions()) {
      i = (j * 37 + 3) * 53 + getOptions().hashCode();
    }
    j = i;
    if (getReservedRangeCount() > 0) {
      j = (i * 37 + 4) * 53 + getReservedRangeList().hashCode();
    }
    i = j;
    if (getReservedNameCount() > 0) {
      i = (j * 37 + 5) * 53 + getReservedNameList().hashCode();
    }
    i = i * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    return i;
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return DescriptorProtos.s().a(EnumDescriptorProto.class, DescriptorProtos.EnumDescriptorProto.Builder.class);
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
    i = 0;
    while (i < getValueCount())
    {
      if (!getValue(i).isInitialized())
      {
        this.memoizedIsInitialized = 0;
        return false;
      }
      i += 1;
    }
    if ((hasOptions()) && (!getOptions().isInitialized()))
    {
      this.memoizedIsInitialized = 0;
      return false;
    }
    this.memoizedIsInitialized = 1;
    return true;
  }
  
  public DescriptorProtos.EnumDescriptorProto.Builder newBuilderForType()
  {
    return newBuilder();
  }
  
  protected DescriptorProtos.EnumDescriptorProto.Builder newBuilderForType(GeneratedMessageV3.BuilderParent paramBuilderParent)
  {
    return new DescriptorProtos.EnumDescriptorProto.Builder(paramBuilderParent, null);
  }
  
  protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter paramUnusedPrivateParameter)
  {
    return new EnumDescriptorProto();
  }
  
  public DescriptorProtos.EnumDescriptorProto.Builder toBuilder()
  {
    if (this == a) {
      return new DescriptorProtos.EnumDescriptorProto.Builder(null);
    }
    return new DescriptorProtos.EnumDescriptorProto.Builder(null).a(this);
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
  {
    if ((this.bitField0_ & 0x1) != 0) {
      GeneratedMessageV3.writeString(paramCodedOutputStream, 1, this.name_);
    }
    int k = 0;
    int i = 0;
    while (i < this.value_.size())
    {
      paramCodedOutputStream.a(2, (MessageLite)this.value_.get(i));
      i += 1;
    }
    if ((this.bitField0_ & 0x2) != 0) {
      paramCodedOutputStream.a(3, getOptions());
    }
    i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= this.reservedRange_.size()) {
        break;
      }
      paramCodedOutputStream.a(4, (MessageLite)this.reservedRange_.get(i));
      i += 1;
    }
    while (j < this.reservedName_.size())
    {
      GeneratedMessageV3.writeString(paramCodedOutputStream, 5, this.reservedName_.d(j));
      j += 1;
    }
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.DescriptorProtos.EnumDescriptorProto
 * JD-Core Version:    0.7.0.1
 */