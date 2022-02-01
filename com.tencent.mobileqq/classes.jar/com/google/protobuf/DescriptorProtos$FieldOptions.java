package com.google.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class DescriptorProtos$FieldOptions
  extends GeneratedMessageV3.ExtendableMessage<FieldOptions>
  implements DescriptorProtos.FieldOptionsOrBuilder
{
  public static final int CTYPE_FIELD_NUMBER = 1;
  public static final int DEPRECATED_FIELD_NUMBER = 3;
  public static final int JSTYPE_FIELD_NUMBER = 6;
  public static final int LAZY_FIELD_NUMBER = 5;
  public static final int PACKED_FIELD_NUMBER = 2;
  @Deprecated
  public static final Parser<FieldOptions> PARSER = new DescriptorProtos.FieldOptions.1();
  public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
  public static final int WEAK_FIELD_NUMBER = 10;
  private static final FieldOptions a = new FieldOptions();
  private static final long serialVersionUID = 0L;
  private int bitField0_;
  private int ctype_;
  private boolean deprecated_;
  private int jstype_;
  private boolean lazy_;
  private byte memoizedIsInitialized = -1;
  private boolean packed_;
  private List<DescriptorProtos.UninterpretedOption> uninterpretedOption_;
  private boolean weak_;
  
  private DescriptorProtos$FieldOptions()
  {
    this.ctype_ = 0;
    this.jstype_ = 0;
    this.uninterpretedOption_ = Collections.emptyList();
  }
  
  /* Error */
  private DescriptorProtos$FieldOptions(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 50	com/google/protobuf/DescriptorProtos$FieldOptions:<init>	()V
    //   4: aload_2
    //   5: ifnull +630 -> 635
    //   8: invokestatic 83	com/google/protobuf/UnknownFieldSet:a	()Lcom/google/protobuf/UnknownFieldSet$Builder;
    //   11: astore 9
    //   13: iconst_0
    //   14: istore 8
    //   16: iconst_0
    //   17: istore_3
    //   18: iload 8
    //   20: ifne +583 -> 603
    //   23: iload_3
    //   24: istore 5
    //   26: iload_3
    //   27: istore 6
    //   29: iload_3
    //   30: istore 7
    //   32: aload_1
    //   33: invokevirtual 88	com/google/protobuf/CodedInputStream:a	()I
    //   36: istore 4
    //   38: iload 4
    //   40: ifeq +490 -> 530
    //   43: iload 4
    //   45: bipush 8
    //   47: if_icmpeq +393 -> 440
    //   50: iload 4
    //   52: bipush 16
    //   54: if_icmpeq +347 -> 401
    //   57: iload 4
    //   59: bipush 24
    //   61: if_icmpeq +300 -> 361
    //   64: iload 4
    //   66: bipush 40
    //   68: if_icmpeq +253 -> 321
    //   71: iload 4
    //   73: bipush 48
    //   75: if_icmpeq +155 -> 230
    //   78: iload 4
    //   80: bipush 80
    //   82: if_icmpeq +108 -> 190
    //   85: iload 4
    //   87: sipush 7994
    //   90: if_icmpeq +28 -> 118
    //   93: iload_3
    //   94: istore 5
    //   96: iload_3
    //   97: istore 6
    //   99: iload_3
    //   100: istore 7
    //   102: aload_0
    //   103: aload_1
    //   104: aload 9
    //   106: aload_2
    //   107: iload 4
    //   109: invokevirtual 92	com/google/protobuf/DescriptorProtos$FieldOptions:parseUnknownField	(Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/UnknownFieldSet$Builder;Lcom/google/protobuf/ExtensionRegistryLite;I)Z
    //   112: ifne -94 -> 18
    //   115: goto +415 -> 530
    //   118: iload_3
    //   119: istore 4
    //   121: iload_3
    //   122: bipush 64
    //   124: iand
    //   125: ifne +29 -> 154
    //   128: iload_3
    //   129: istore 5
    //   131: iload_3
    //   132: istore 6
    //   134: iload_3
    //   135: istore 7
    //   137: aload_0
    //   138: new 94	java/util/ArrayList
    //   141: dup
    //   142: invokespecial 95	java/util/ArrayList:<init>	()V
    //   145: putfield 73	com/google/protobuf/DescriptorProtos$FieldOptions:uninterpretedOption_	Ljava/util/List;
    //   148: iload_3
    //   149: bipush 64
    //   151: ior
    //   152: istore 4
    //   154: iload 4
    //   156: istore 5
    //   158: iload 4
    //   160: istore 6
    //   162: iload 4
    //   164: istore 7
    //   166: aload_0
    //   167: getfield 73	com/google/protobuf/DescriptorProtos$FieldOptions:uninterpretedOption_	Ljava/util/List;
    //   170: aload_1
    //   171: getstatic 98	com/google/protobuf/DescriptorProtos$UninterpretedOption:PARSER	Lcom/google/protobuf/Parser;
    //   174: aload_2
    //   175: invokevirtual 101	com/google/protobuf/CodedInputStream:a	(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   178: invokeinterface 107 2 0
    //   183: pop
    //   184: iload 4
    //   186: istore_3
    //   187: goto -169 -> 18
    //   190: iload_3
    //   191: istore 5
    //   193: iload_3
    //   194: istore 6
    //   196: iload_3
    //   197: istore 7
    //   199: aload_0
    //   200: aload_0
    //   201: getfield 109	com/google/protobuf/DescriptorProtos$FieldOptions:bitField0_	I
    //   204: bipush 32
    //   206: ior
    //   207: putfield 109	com/google/protobuf/DescriptorProtos$FieldOptions:bitField0_	I
    //   210: iload_3
    //   211: istore 5
    //   213: iload_3
    //   214: istore 6
    //   216: iload_3
    //   217: istore 7
    //   219: aload_0
    //   220: aload_1
    //   221: invokevirtual 113	com/google/protobuf/CodedInputStream:i	()Z
    //   224: putfield 115	com/google/protobuf/DescriptorProtos$FieldOptions:weak_	Z
    //   227: goto -209 -> 18
    //   230: iload_3
    //   231: istore 5
    //   233: iload_3
    //   234: istore 6
    //   236: iload_3
    //   237: istore 7
    //   239: aload_1
    //   240: invokevirtual 118	com/google/protobuf/CodedInputStream:n	()I
    //   243: istore 4
    //   245: iload_3
    //   246: istore 5
    //   248: iload_3
    //   249: istore 6
    //   251: iload_3
    //   252: istore 7
    //   254: iload 4
    //   256: invokestatic 124	com/google/protobuf/DescriptorProtos$FieldOptions$JSType:valueOf	(I)Lcom/google/protobuf/DescriptorProtos$FieldOptions$JSType;
    //   259: ifnonnull +25 -> 284
    //   262: iload_3
    //   263: istore 5
    //   265: iload_3
    //   266: istore 6
    //   268: iload_3
    //   269: istore 7
    //   271: aload 9
    //   273: bipush 6
    //   275: iload 4
    //   277: invokevirtual 129	com/google/protobuf/UnknownFieldSet$Builder:a	(II)Lcom/google/protobuf/UnknownFieldSet$Builder;
    //   280: pop
    //   281: goto -263 -> 18
    //   284: iload_3
    //   285: istore 5
    //   287: iload_3
    //   288: istore 6
    //   290: iload_3
    //   291: istore 7
    //   293: aload_0
    //   294: aload_0
    //   295: getfield 109	com/google/protobuf/DescriptorProtos$FieldOptions:bitField0_	I
    //   298: iconst_4
    //   299: ior
    //   300: putfield 109	com/google/protobuf/DescriptorProtos$FieldOptions:bitField0_	I
    //   303: iload_3
    //   304: istore 5
    //   306: iload_3
    //   307: istore 6
    //   309: iload_3
    //   310: istore 7
    //   312: aload_0
    //   313: iload 4
    //   315: putfield 65	com/google/protobuf/DescriptorProtos$FieldOptions:jstype_	I
    //   318: goto -300 -> 18
    //   321: iload_3
    //   322: istore 5
    //   324: iload_3
    //   325: istore 6
    //   327: iload_3
    //   328: istore 7
    //   330: aload_0
    //   331: aload_0
    //   332: getfield 109	com/google/protobuf/DescriptorProtos$FieldOptions:bitField0_	I
    //   335: bipush 8
    //   337: ior
    //   338: putfield 109	com/google/protobuf/DescriptorProtos$FieldOptions:bitField0_	I
    //   341: iload_3
    //   342: istore 5
    //   344: iload_3
    //   345: istore 6
    //   347: iload_3
    //   348: istore 7
    //   350: aload_0
    //   351: aload_1
    //   352: invokevirtual 113	com/google/protobuf/CodedInputStream:i	()Z
    //   355: putfield 131	com/google/protobuf/DescriptorProtos$FieldOptions:lazy_	Z
    //   358: goto -340 -> 18
    //   361: iload_3
    //   362: istore 5
    //   364: iload_3
    //   365: istore 6
    //   367: iload_3
    //   368: istore 7
    //   370: aload_0
    //   371: aload_0
    //   372: getfield 109	com/google/protobuf/DescriptorProtos$FieldOptions:bitField0_	I
    //   375: bipush 16
    //   377: ior
    //   378: putfield 109	com/google/protobuf/DescriptorProtos$FieldOptions:bitField0_	I
    //   381: iload_3
    //   382: istore 5
    //   384: iload_3
    //   385: istore 6
    //   387: iload_3
    //   388: istore 7
    //   390: aload_0
    //   391: aload_1
    //   392: invokevirtual 113	com/google/protobuf/CodedInputStream:i	()Z
    //   395: putfield 133	com/google/protobuf/DescriptorProtos$FieldOptions:deprecated_	Z
    //   398: goto -380 -> 18
    //   401: iload_3
    //   402: istore 5
    //   404: iload_3
    //   405: istore 6
    //   407: iload_3
    //   408: istore 7
    //   410: aload_0
    //   411: aload_0
    //   412: getfield 109	com/google/protobuf/DescriptorProtos$FieldOptions:bitField0_	I
    //   415: iconst_2
    //   416: ior
    //   417: putfield 109	com/google/protobuf/DescriptorProtos$FieldOptions:bitField0_	I
    //   420: iload_3
    //   421: istore 5
    //   423: iload_3
    //   424: istore 6
    //   426: iload_3
    //   427: istore 7
    //   429: aload_0
    //   430: aload_1
    //   431: invokevirtual 113	com/google/protobuf/CodedInputStream:i	()Z
    //   434: putfield 135	com/google/protobuf/DescriptorProtos$FieldOptions:packed_	Z
    //   437: goto -419 -> 18
    //   440: iload_3
    //   441: istore 5
    //   443: iload_3
    //   444: istore 6
    //   446: iload_3
    //   447: istore 7
    //   449: aload_1
    //   450: invokevirtual 118	com/google/protobuf/CodedInputStream:n	()I
    //   453: istore 4
    //   455: iload_3
    //   456: istore 5
    //   458: iload_3
    //   459: istore 6
    //   461: iload_3
    //   462: istore 7
    //   464: iload 4
    //   466: invokestatic 140	com/google/protobuf/DescriptorProtos$FieldOptions$CType:valueOf	(I)Lcom/google/protobuf/DescriptorProtos$FieldOptions$CType;
    //   469: ifnonnull +24 -> 493
    //   472: iload_3
    //   473: istore 5
    //   475: iload_3
    //   476: istore 6
    //   478: iload_3
    //   479: istore 7
    //   481: aload 9
    //   483: iconst_1
    //   484: iload 4
    //   486: invokevirtual 129	com/google/protobuf/UnknownFieldSet$Builder:a	(II)Lcom/google/protobuf/UnknownFieldSet$Builder;
    //   489: pop
    //   490: goto -472 -> 18
    //   493: iload_3
    //   494: istore 5
    //   496: iload_3
    //   497: istore 6
    //   499: iload_3
    //   500: istore 7
    //   502: aload_0
    //   503: iconst_1
    //   504: aload_0
    //   505: getfield 109	com/google/protobuf/DescriptorProtos$FieldOptions:bitField0_	I
    //   508: ior
    //   509: putfield 109	com/google/protobuf/DescriptorProtos$FieldOptions:bitField0_	I
    //   512: iload_3
    //   513: istore 5
    //   515: iload_3
    //   516: istore 6
    //   518: iload_3
    //   519: istore 7
    //   521: aload_0
    //   522: iload 4
    //   524: putfield 63	com/google/protobuf/DescriptorProtos$FieldOptions:ctype_	I
    //   527: goto -509 -> 18
    //   530: iconst_1
    //   531: istore 8
    //   533: goto -515 -> 18
    //   536: astore_1
    //   537: goto +32 -> 569
    //   540: astore_1
    //   541: iload 6
    //   543: istore 5
    //   545: new 76	com/google/protobuf/InvalidProtocolBufferException
    //   548: dup
    //   549: aload_1
    //   550: invokespecial 143	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/io/IOException;)V
    //   553: aload_0
    //   554: invokevirtual 147	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   557: athrow
    //   558: astore_1
    //   559: iload 7
    //   561: istore 5
    //   563: aload_1
    //   564: aload_0
    //   565: invokevirtual 147	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   568: athrow
    //   569: iload 5
    //   571: bipush 64
    //   573: iand
    //   574: ifeq +14 -> 588
    //   577: aload_0
    //   578: aload_0
    //   579: getfield 73	com/google/protobuf/DescriptorProtos$FieldOptions:uninterpretedOption_	Ljava/util/List;
    //   582: invokestatic 151	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   585: putfield 73	com/google/protobuf/DescriptorProtos$FieldOptions:uninterpretedOption_	Ljava/util/List;
    //   588: aload_0
    //   589: aload 9
    //   591: invokevirtual 154	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   594: putfield 158	com/google/protobuf/DescriptorProtos$FieldOptions:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   597: aload_0
    //   598: invokevirtual 161	com/google/protobuf/DescriptorProtos$FieldOptions:makeExtensionsImmutable	()V
    //   601: aload_1
    //   602: athrow
    //   603: iload_3
    //   604: bipush 64
    //   606: iand
    //   607: ifeq +14 -> 621
    //   610: aload_0
    //   611: aload_0
    //   612: getfield 73	com/google/protobuf/DescriptorProtos$FieldOptions:uninterpretedOption_	Ljava/util/List;
    //   615: invokestatic 151	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   618: putfield 73	com/google/protobuf/DescriptorProtos$FieldOptions:uninterpretedOption_	Ljava/util/List;
    //   621: aload_0
    //   622: aload 9
    //   624: invokevirtual 154	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   627: putfield 158	com/google/protobuf/DescriptorProtos$FieldOptions:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   630: aload_0
    //   631: invokevirtual 161	com/google/protobuf/DescriptorProtos$FieldOptions:makeExtensionsImmutable	()V
    //   634: return
    //   635: new 163	java/lang/NullPointerException
    //   638: dup
    //   639: invokespecial 164	java/lang/NullPointerException:<init>	()V
    //   642: astore_1
    //   643: goto +5 -> 648
    //   646: aload_1
    //   647: athrow
    //   648: goto -2 -> 646
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	651	0	this	FieldOptions
    //   0	651	1	paramCodedInputStream	CodedInputStream
    //   0	651	2	paramExtensionRegistryLite	ExtensionRegistryLite
    //   17	590	3	i	int
    //   36	487	4	j	int
    //   24	550	5	k	int
    //   27	515	6	m	int
    //   30	530	7	n	int
    //   14	518	8	i1	int
    //   11	612	9	localBuilder	UnknownFieldSet.Builder
    // Exception table:
    //   from	to	target	type
    //   32	38	536	finally
    //   102	115	536	finally
    //   137	148	536	finally
    //   166	184	536	finally
    //   199	210	536	finally
    //   219	227	536	finally
    //   239	245	536	finally
    //   254	262	536	finally
    //   271	281	536	finally
    //   293	303	536	finally
    //   312	318	536	finally
    //   330	341	536	finally
    //   350	358	536	finally
    //   370	381	536	finally
    //   390	398	536	finally
    //   410	420	536	finally
    //   429	437	536	finally
    //   449	455	536	finally
    //   464	472	536	finally
    //   481	490	536	finally
    //   502	512	536	finally
    //   521	527	536	finally
    //   545	558	536	finally
    //   563	569	536	finally
    //   32	38	540	java/io/IOException
    //   102	115	540	java/io/IOException
    //   137	148	540	java/io/IOException
    //   166	184	540	java/io/IOException
    //   199	210	540	java/io/IOException
    //   219	227	540	java/io/IOException
    //   239	245	540	java/io/IOException
    //   254	262	540	java/io/IOException
    //   271	281	540	java/io/IOException
    //   293	303	540	java/io/IOException
    //   312	318	540	java/io/IOException
    //   330	341	540	java/io/IOException
    //   350	358	540	java/io/IOException
    //   370	381	540	java/io/IOException
    //   390	398	540	java/io/IOException
    //   410	420	540	java/io/IOException
    //   429	437	540	java/io/IOException
    //   449	455	540	java/io/IOException
    //   464	472	540	java/io/IOException
    //   481	490	540	java/io/IOException
    //   502	512	540	java/io/IOException
    //   521	527	540	java/io/IOException
    //   32	38	558	com/google/protobuf/InvalidProtocolBufferException
    //   102	115	558	com/google/protobuf/InvalidProtocolBufferException
    //   137	148	558	com/google/protobuf/InvalidProtocolBufferException
    //   166	184	558	com/google/protobuf/InvalidProtocolBufferException
    //   199	210	558	com/google/protobuf/InvalidProtocolBufferException
    //   219	227	558	com/google/protobuf/InvalidProtocolBufferException
    //   239	245	558	com/google/protobuf/InvalidProtocolBufferException
    //   254	262	558	com/google/protobuf/InvalidProtocolBufferException
    //   271	281	558	com/google/protobuf/InvalidProtocolBufferException
    //   293	303	558	com/google/protobuf/InvalidProtocolBufferException
    //   312	318	558	com/google/protobuf/InvalidProtocolBufferException
    //   330	341	558	com/google/protobuf/InvalidProtocolBufferException
    //   350	358	558	com/google/protobuf/InvalidProtocolBufferException
    //   370	381	558	com/google/protobuf/InvalidProtocolBufferException
    //   390	398	558	com/google/protobuf/InvalidProtocolBufferException
    //   410	420	558	com/google/protobuf/InvalidProtocolBufferException
    //   429	437	558	com/google/protobuf/InvalidProtocolBufferException
    //   449	455	558	com/google/protobuf/InvalidProtocolBufferException
    //   464	472	558	com/google/protobuf/InvalidProtocolBufferException
    //   481	490	558	com/google/protobuf/InvalidProtocolBufferException
    //   502	512	558	com/google/protobuf/InvalidProtocolBufferException
    //   521	527	558	com/google/protobuf/InvalidProtocolBufferException
  }
  
  private DescriptorProtos$FieldOptions(GeneratedMessageV3.ExtendableBuilder<FieldOptions, ?> paramExtendableBuilder)
  {
    super(paramExtendableBuilder);
  }
  
  public static FieldOptions getDefaultInstance()
  {
    return a;
  }
  
  public static final Descriptors.Descriptor getDescriptor()
  {
    return DescriptorProtos.F();
  }
  
  public static DescriptorProtos.FieldOptions.Builder newBuilder()
  {
    return a.toBuilder();
  }
  
  public static DescriptorProtos.FieldOptions.Builder newBuilder(FieldOptions paramFieldOptions)
  {
    return a.toBuilder().a(paramFieldOptions);
  }
  
  public static FieldOptions parseDelimitedFrom(InputStream paramInputStream)
  {
    return (FieldOptions)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream);
  }
  
  public static FieldOptions parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (FieldOptions)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static FieldOptions parseFrom(ByteString paramByteString)
  {
    return (FieldOptions)PARSER.parseFrom(paramByteString);
  }
  
  public static FieldOptions parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (FieldOptions)PARSER.parseFrom(paramByteString, paramExtensionRegistryLite);
  }
  
  public static FieldOptions parseFrom(CodedInputStream paramCodedInputStream)
  {
    return (FieldOptions)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream);
  }
  
  public static FieldOptions parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (FieldOptions)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static FieldOptions parseFrom(InputStream paramInputStream)
  {
    return (FieldOptions)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream);
  }
  
  public static FieldOptions parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (FieldOptions)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static FieldOptions parseFrom(ByteBuffer paramByteBuffer)
  {
    return (FieldOptions)PARSER.parseFrom(paramByteBuffer);
  }
  
  public static FieldOptions parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (FieldOptions)PARSER.parseFrom(paramByteBuffer, paramExtensionRegistryLite);
  }
  
  public static FieldOptions parseFrom(byte[] paramArrayOfByte)
  {
    return (FieldOptions)PARSER.parseFrom(paramArrayOfByte);
  }
  
  public static FieldOptions parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (FieldOptions)PARSER.parseFrom(paramArrayOfByte, paramExtensionRegistryLite);
  }
  
  public static Parser<FieldOptions> parser()
  {
    return PARSER;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof FieldOptions)) {
      return super.equals(paramObject);
    }
    paramObject = (FieldOptions)paramObject;
    if (hasCtype() != paramObject.hasCtype()) {
      return false;
    }
    if ((hasCtype()) && (this.ctype_ != paramObject.ctype_)) {
      return false;
    }
    if (hasPacked() != paramObject.hasPacked()) {
      return false;
    }
    if ((hasPacked()) && (getPacked() != paramObject.getPacked())) {
      return false;
    }
    if (hasJstype() != paramObject.hasJstype()) {
      return false;
    }
    if ((hasJstype()) && (this.jstype_ != paramObject.jstype_)) {
      return false;
    }
    if (hasLazy() != paramObject.hasLazy()) {
      return false;
    }
    if ((hasLazy()) && (getLazy() != paramObject.getLazy())) {
      return false;
    }
    if (hasDeprecated() != paramObject.hasDeprecated()) {
      return false;
    }
    if ((hasDeprecated()) && (getDeprecated() != paramObject.getDeprecated())) {
      return false;
    }
    if (hasWeak() != paramObject.hasWeak()) {
      return false;
    }
    if ((hasWeak()) && (getWeak() != paramObject.getWeak())) {
      return false;
    }
    if (!getUninterpretedOptionList().equals(paramObject.getUninterpretedOptionList())) {
      return false;
    }
    if (!this.unknownFields.equals(paramObject.unknownFields)) {
      return false;
    }
    return getExtensionFields().equals(paramObject.getExtensionFields());
  }
  
  public DescriptorProtos.FieldOptions.CType getCtype()
  {
    DescriptorProtos.FieldOptions.CType localCType2 = DescriptorProtos.FieldOptions.CType.valueOf(this.ctype_);
    DescriptorProtos.FieldOptions.CType localCType1 = localCType2;
    if (localCType2 == null) {
      localCType1 = DescriptorProtos.FieldOptions.CType.STRING;
    }
    return localCType1;
  }
  
  public FieldOptions getDefaultInstanceForType()
  {
    return a;
  }
  
  public boolean getDeprecated()
  {
    return this.deprecated_;
  }
  
  public DescriptorProtos.FieldOptions.JSType getJstype()
  {
    DescriptorProtos.FieldOptions.JSType localJSType2 = DescriptorProtos.FieldOptions.JSType.valueOf(this.jstype_);
    DescriptorProtos.FieldOptions.JSType localJSType1 = localJSType2;
    if (localJSType2 == null) {
      localJSType1 = DescriptorProtos.FieldOptions.JSType.JS_NORMAL;
    }
    return localJSType1;
  }
  
  public boolean getLazy()
  {
    return this.lazy_;
  }
  
  public boolean getPacked()
  {
    return this.packed_;
  }
  
  public Parser<FieldOptions> getParserForType()
  {
    return PARSER;
  }
  
  public int getSerializedSize()
  {
    int i = this.memoizedSize;
    if (i != -1) {
      return i;
    }
    i = this.bitField0_;
    int m = 0;
    if ((i & 0x1) != 0) {
      j = CodedOutputStream.m(1, this.ctype_) + 0;
    } else {
      j = 0;
    }
    i = j;
    if ((this.bitField0_ & 0x2) != 0) {
      i = j + CodedOutputStream.b(2, this.packed_);
    }
    int j = i;
    if ((this.bitField0_ & 0x10) != 0) {
      j = i + CodedOutputStream.b(3, this.deprecated_);
    }
    int k = j;
    if ((this.bitField0_ & 0x8) != 0) {
      k = j + CodedOutputStream.b(5, this.lazy_);
    }
    i = k;
    if ((this.bitField0_ & 0x4) != 0) {
      i = k + CodedOutputStream.m(6, this.jstype_);
    }
    j = i;
    k = m;
    if ((this.bitField0_ & 0x20) != 0)
    {
      j = i + CodedOutputStream.b(10, this.weak_);
      k = m;
    }
    while (k < this.uninterpretedOption_.size())
    {
      j += CodedOutputStream.c(999, (MessageLite)this.uninterpretedOption_.get(k));
      k += 1;
    }
    i = j + extensionsSerializedSize() + this.unknownFields.getSerializedSize();
    this.memoizedSize = i;
    return i;
  }
  
  public DescriptorProtos.UninterpretedOption getUninterpretedOption(int paramInt)
  {
    return (DescriptorProtos.UninterpretedOption)this.uninterpretedOption_.get(paramInt);
  }
  
  public int getUninterpretedOptionCount()
  {
    return this.uninterpretedOption_.size();
  }
  
  public List<DescriptorProtos.UninterpretedOption> getUninterpretedOptionList()
  {
    return this.uninterpretedOption_;
  }
  
  public DescriptorProtos.UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int paramInt)
  {
    return (DescriptorProtos.UninterpretedOptionOrBuilder)this.uninterpretedOption_.get(paramInt);
  }
  
  public List<? extends DescriptorProtos.UninterpretedOptionOrBuilder> getUninterpretedOptionOrBuilderList()
  {
    return this.uninterpretedOption_;
  }
  
  public final UnknownFieldSet getUnknownFields()
  {
    return this.unknownFields;
  }
  
  public boolean getWeak()
  {
    return this.weak_;
  }
  
  public boolean hasCtype()
  {
    return (this.bitField0_ & 0x1) != 0;
  }
  
  public boolean hasDeprecated()
  {
    return (this.bitField0_ & 0x10) != 0;
  }
  
  public boolean hasJstype()
  {
    return (this.bitField0_ & 0x4) != 0;
  }
  
  public boolean hasLazy()
  {
    return (this.bitField0_ & 0x8) != 0;
  }
  
  public boolean hasPacked()
  {
    return (this.bitField0_ & 0x2) != 0;
  }
  
  public boolean hasWeak()
  {
    return (this.bitField0_ & 0x20) != 0;
  }
  
  public int hashCode()
  {
    if (this.memoizedHashCode != 0) {
      return this.memoizedHashCode;
    }
    int j = 779 + getDescriptor().hashCode();
    int i = j;
    if (hasCtype()) {
      i = (j * 37 + 1) * 53 + this.ctype_;
    }
    j = i;
    if (hasPacked()) {
      j = (i * 37 + 2) * 53 + Internal.a(getPacked());
    }
    i = j;
    if (hasJstype()) {
      i = (j * 37 + 6) * 53 + this.jstype_;
    }
    j = i;
    if (hasLazy()) {
      j = (i * 37 + 5) * 53 + Internal.a(getLazy());
    }
    i = j;
    if (hasDeprecated()) {
      i = (j * 37 + 3) * 53 + Internal.a(getDeprecated());
    }
    j = i;
    if (hasWeak()) {
      j = (i * 37 + 10) * 53 + Internal.a(getWeak());
    }
    i = j;
    if (getUninterpretedOptionCount() > 0) {
      i = (j * 37 + 999) * 53 + getUninterpretedOptionList().hashCode();
    }
    i = hashFields(i, getExtensionFields()) * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    return i;
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return DescriptorProtos.G().a(FieldOptions.class, DescriptorProtos.FieldOptions.Builder.class);
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
    while (i < getUninterpretedOptionCount())
    {
      if (!getUninterpretedOption(i).isInitialized())
      {
        this.memoizedIsInitialized = 0;
        return false;
      }
      i += 1;
    }
    if (!extensionsAreInitialized())
    {
      this.memoizedIsInitialized = 0;
      return false;
    }
    this.memoizedIsInitialized = 1;
    return true;
  }
  
  public DescriptorProtos.FieldOptions.Builder newBuilderForType()
  {
    return newBuilder();
  }
  
  protected DescriptorProtos.FieldOptions.Builder newBuilderForType(GeneratedMessageV3.BuilderParent paramBuilderParent)
  {
    return new DescriptorProtos.FieldOptions.Builder(paramBuilderParent, null);
  }
  
  protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter paramUnusedPrivateParameter)
  {
    return new FieldOptions();
  }
  
  public DescriptorProtos.FieldOptions.Builder toBuilder()
  {
    if (this == a) {
      return new DescriptorProtos.FieldOptions.Builder(null);
    }
    return new DescriptorProtos.FieldOptions.Builder(null).a(this);
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
  {
    GeneratedMessageV3.ExtendableMessage.ExtensionWriter localExtensionWriter = newExtensionWriter();
    if ((this.bitField0_ & 0x1) != 0) {
      paramCodedOutputStream.g(1, this.ctype_);
    }
    if ((this.bitField0_ & 0x2) != 0) {
      paramCodedOutputStream.a(2, this.packed_);
    }
    if ((this.bitField0_ & 0x10) != 0) {
      paramCodedOutputStream.a(3, this.deprecated_);
    }
    if ((this.bitField0_ & 0x8) != 0) {
      paramCodedOutputStream.a(5, this.lazy_);
    }
    if ((this.bitField0_ & 0x4) != 0) {
      paramCodedOutputStream.g(6, this.jstype_);
    }
    if ((this.bitField0_ & 0x20) != 0) {
      paramCodedOutputStream.a(10, this.weak_);
    }
    int i = 0;
    while (i < this.uninterpretedOption_.size())
    {
      paramCodedOutputStream.a(999, (MessageLite)this.uninterpretedOption_.get(i));
      i += 1;
    }
    localExtensionWriter.a(536870912, paramCodedOutputStream);
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.DescriptorProtos.FieldOptions
 * JD-Core Version:    0.7.0.1
 */