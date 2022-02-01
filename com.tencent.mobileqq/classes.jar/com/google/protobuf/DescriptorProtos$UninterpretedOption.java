package com.google.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

public final class DescriptorProtos$UninterpretedOption
  extends GeneratedMessageV3
  implements DescriptorProtos.UninterpretedOptionOrBuilder
{
  public static final int AGGREGATE_VALUE_FIELD_NUMBER = 8;
  public static final int DOUBLE_VALUE_FIELD_NUMBER = 6;
  public static final int IDENTIFIER_VALUE_FIELD_NUMBER = 3;
  public static final int NAME_FIELD_NUMBER = 2;
  public static final int NEGATIVE_INT_VALUE_FIELD_NUMBER = 5;
  @Deprecated
  public static final Parser<UninterpretedOption> PARSER = new DescriptorProtos.UninterpretedOption.1();
  public static final int POSITIVE_INT_VALUE_FIELD_NUMBER = 4;
  public static final int STRING_VALUE_FIELD_NUMBER = 7;
  private static final UninterpretedOption a = new UninterpretedOption();
  private static final long serialVersionUID = 0L;
  private volatile Object aggregateValue_;
  private int bitField0_;
  private double doubleValue_;
  private volatile Object identifierValue_;
  private byte memoizedIsInitialized = -1;
  private List<DescriptorProtos.UninterpretedOption.NamePart> name_;
  private long negativeIntValue_;
  private long positiveIntValue_;
  private ByteString stringValue_;
  
  private DescriptorProtos$UninterpretedOption()
  {
    this.name_ = Collections.emptyList();
    this.identifierValue_ = "";
    this.stringValue_ = ByteString.EMPTY;
    this.aggregateValue_ = "";
  }
  
  /* Error */
  private DescriptorProtos$UninterpretedOption(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 51	com/google/protobuf/DescriptorProtos$UninterpretedOption:<init>	()V
    //   4: aload_2
    //   5: ifnull +548 -> 553
    //   8: invokestatic 93	com/google/protobuf/UnknownFieldSet:a	()Lcom/google/protobuf/UnknownFieldSet$Builder;
    //   11: astore 9
    //   13: iconst_0
    //   14: istore 8
    //   16: iconst_0
    //   17: istore_3
    //   18: iload 8
    //   20: ifne +502 -> 522
    //   23: iload_3
    //   24: istore 5
    //   26: iload_3
    //   27: istore 6
    //   29: iload_3
    //   30: istore 7
    //   32: aload_1
    //   33: invokevirtual 98	com/google/protobuf/CodedInputStream:a	()I
    //   36: istore 4
    //   38: iload 4
    //   40: ifeq +410 -> 450
    //   43: iload 4
    //   45: bipush 18
    //   47: if_icmpeq +333 -> 380
    //   50: iload 4
    //   52: bipush 26
    //   54: if_icmpeq +274 -> 328
    //   57: iload 4
    //   59: bipush 32
    //   61: if_icmpeq +228 -> 289
    //   64: iload 4
    //   66: bipush 40
    //   68: if_icmpeq +182 -> 250
    //   71: iload 4
    //   73: bipush 49
    //   75: if_icmpeq +135 -> 210
    //   78: iload 4
    //   80: bipush 58
    //   82: if_icmpeq +88 -> 170
    //   85: iload 4
    //   87: bipush 66
    //   89: if_icmpeq +28 -> 117
    //   92: iload_3
    //   93: istore 5
    //   95: iload_3
    //   96: istore 6
    //   98: iload_3
    //   99: istore 7
    //   101: aload_0
    //   102: aload_1
    //   103: aload 9
    //   105: aload_2
    //   106: iload 4
    //   108: invokevirtual 102	com/google/protobuf/DescriptorProtos$UninterpretedOption:parseUnknownField	(Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/UnknownFieldSet$Builder;Lcom/google/protobuf/ExtensionRegistryLite;I)Z
    //   111: ifne -93 -> 18
    //   114: goto +336 -> 450
    //   117: iload_3
    //   118: istore 5
    //   120: iload_3
    //   121: istore 6
    //   123: iload_3
    //   124: istore 7
    //   126: aload_1
    //   127: invokevirtual 106	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   130: astore 10
    //   132: iload_3
    //   133: istore 5
    //   135: iload_3
    //   136: istore 6
    //   138: iload_3
    //   139: istore 7
    //   141: aload_0
    //   142: bipush 32
    //   144: aload_0
    //   145: getfield 108	com/google/protobuf/DescriptorProtos$UninterpretedOption:bitField0_	I
    //   148: ior
    //   149: putfield 108	com/google/protobuf/DescriptorProtos$UninterpretedOption:bitField0_	I
    //   152: iload_3
    //   153: istore 5
    //   155: iload_3
    //   156: istore 6
    //   158: iload_3
    //   159: istore 7
    //   161: aload_0
    //   162: aload 10
    //   164: putfield 83	com/google/protobuf/DescriptorProtos$UninterpretedOption:aggregateValue_	Ljava/lang/Object;
    //   167: goto -149 -> 18
    //   170: iload_3
    //   171: istore 5
    //   173: iload_3
    //   174: istore 6
    //   176: iload_3
    //   177: istore 7
    //   179: aload_0
    //   180: aload_0
    //   181: getfield 108	com/google/protobuf/DescriptorProtos$UninterpretedOption:bitField0_	I
    //   184: bipush 16
    //   186: ior
    //   187: putfield 108	com/google/protobuf/DescriptorProtos$UninterpretedOption:bitField0_	I
    //   190: iload_3
    //   191: istore 5
    //   193: iload_3
    //   194: istore 6
    //   196: iload_3
    //   197: istore 7
    //   199: aload_0
    //   200: aload_1
    //   201: invokevirtual 106	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   204: putfield 81	com/google/protobuf/DescriptorProtos$UninterpretedOption:stringValue_	Lcom/google/protobuf/ByteString;
    //   207: goto -189 -> 18
    //   210: iload_3
    //   211: istore 5
    //   213: iload_3
    //   214: istore 6
    //   216: iload_3
    //   217: istore 7
    //   219: aload_0
    //   220: aload_0
    //   221: getfield 108	com/google/protobuf/DescriptorProtos$UninterpretedOption:bitField0_	I
    //   224: bipush 8
    //   226: ior
    //   227: putfield 108	com/google/protobuf/DescriptorProtos$UninterpretedOption:bitField0_	I
    //   230: iload_3
    //   231: istore 5
    //   233: iload_3
    //   234: istore 6
    //   236: iload_3
    //   237: istore 7
    //   239: aload_0
    //   240: aload_1
    //   241: invokevirtual 112	com/google/protobuf/CodedInputStream:b	()D
    //   244: putfield 114	com/google/protobuf/DescriptorProtos$UninterpretedOption:doubleValue_	D
    //   247: goto -229 -> 18
    //   250: iload_3
    //   251: istore 5
    //   253: iload_3
    //   254: istore 6
    //   256: iload_3
    //   257: istore 7
    //   259: aload_0
    //   260: aload_0
    //   261: getfield 108	com/google/protobuf/DescriptorProtos$UninterpretedOption:bitField0_	I
    //   264: iconst_4
    //   265: ior
    //   266: putfield 108	com/google/protobuf/DescriptorProtos$UninterpretedOption:bitField0_	I
    //   269: iload_3
    //   270: istore 5
    //   272: iload_3
    //   273: istore 6
    //   275: iload_3
    //   276: istore 7
    //   278: aload_0
    //   279: aload_1
    //   280: invokevirtual 118	com/google/protobuf/CodedInputStream:e	()J
    //   283: putfield 120	com/google/protobuf/DescriptorProtos$UninterpretedOption:negativeIntValue_	J
    //   286: goto -268 -> 18
    //   289: iload_3
    //   290: istore 5
    //   292: iload_3
    //   293: istore 6
    //   295: iload_3
    //   296: istore 7
    //   298: aload_0
    //   299: aload_0
    //   300: getfield 108	com/google/protobuf/DescriptorProtos$UninterpretedOption:bitField0_	I
    //   303: iconst_2
    //   304: ior
    //   305: putfield 108	com/google/protobuf/DescriptorProtos$UninterpretedOption:bitField0_	I
    //   308: iload_3
    //   309: istore 5
    //   311: iload_3
    //   312: istore 6
    //   314: iload_3
    //   315: istore 7
    //   317: aload_0
    //   318: aload_1
    //   319: invokevirtual 123	com/google/protobuf/CodedInputStream:d	()J
    //   322: putfield 125	com/google/protobuf/DescriptorProtos$UninterpretedOption:positiveIntValue_	J
    //   325: goto -307 -> 18
    //   328: iload_3
    //   329: istore 5
    //   331: iload_3
    //   332: istore 6
    //   334: iload_3
    //   335: istore 7
    //   337: aload_1
    //   338: invokevirtual 106	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   341: astore 10
    //   343: iload_3
    //   344: istore 5
    //   346: iload_3
    //   347: istore 6
    //   349: iload_3
    //   350: istore 7
    //   352: aload_0
    //   353: aload_0
    //   354: getfield 108	com/google/protobuf/DescriptorProtos$UninterpretedOption:bitField0_	I
    //   357: iconst_1
    //   358: ior
    //   359: putfield 108	com/google/protobuf/DescriptorProtos$UninterpretedOption:bitField0_	I
    //   362: iload_3
    //   363: istore 5
    //   365: iload_3
    //   366: istore 6
    //   368: iload_3
    //   369: istore 7
    //   371: aload_0
    //   372: aload 10
    //   374: putfield 74	com/google/protobuf/DescriptorProtos$UninterpretedOption:identifierValue_	Ljava/lang/Object;
    //   377: goto -359 -> 18
    //   380: iload_3
    //   381: istore 4
    //   383: iload_3
    //   384: iconst_1
    //   385: iand
    //   386: ifne +28 -> 414
    //   389: iload_3
    //   390: istore 5
    //   392: iload_3
    //   393: istore 6
    //   395: iload_3
    //   396: istore 7
    //   398: aload_0
    //   399: new 127	java/util/ArrayList
    //   402: dup
    //   403: invokespecial 128	java/util/ArrayList:<init>	()V
    //   406: putfield 70	com/google/protobuf/DescriptorProtos$UninterpretedOption:name_	Ljava/util/List;
    //   409: iload_3
    //   410: iconst_1
    //   411: ior
    //   412: istore 4
    //   414: iload 4
    //   416: istore 5
    //   418: iload 4
    //   420: istore 6
    //   422: iload 4
    //   424: istore 7
    //   426: aload_0
    //   427: getfield 70	com/google/protobuf/DescriptorProtos$UninterpretedOption:name_	Ljava/util/List;
    //   430: aload_1
    //   431: getstatic 131	com/google/protobuf/DescriptorProtos$UninterpretedOption$NamePart:PARSER	Lcom/google/protobuf/Parser;
    //   434: aload_2
    //   435: invokevirtual 134	com/google/protobuf/CodedInputStream:a	(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   438: invokeinterface 140 2 0
    //   443: pop
    //   444: iload 4
    //   446: istore_3
    //   447: goto -429 -> 18
    //   450: iconst_1
    //   451: istore 8
    //   453: goto -435 -> 18
    //   456: astore_1
    //   457: goto +32 -> 489
    //   460: astore_1
    //   461: iload 6
    //   463: istore 5
    //   465: new 86	com/google/protobuf/InvalidProtocolBufferException
    //   468: dup
    //   469: aload_1
    //   470: invokespecial 143	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/io/IOException;)V
    //   473: aload_0
    //   474: invokevirtual 147	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   477: athrow
    //   478: astore_1
    //   479: iload 7
    //   481: istore 5
    //   483: aload_1
    //   484: aload_0
    //   485: invokevirtual 147	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   488: athrow
    //   489: iload 5
    //   491: iconst_1
    //   492: iand
    //   493: ifeq +14 -> 507
    //   496: aload_0
    //   497: aload_0
    //   498: getfield 70	com/google/protobuf/DescriptorProtos$UninterpretedOption:name_	Ljava/util/List;
    //   501: invokestatic 151	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   504: putfield 70	com/google/protobuf/DescriptorProtos$UninterpretedOption:name_	Ljava/util/List;
    //   507: aload_0
    //   508: aload 9
    //   510: invokevirtual 156	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   513: putfield 160	com/google/protobuf/DescriptorProtos$UninterpretedOption:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   516: aload_0
    //   517: invokevirtual 163	com/google/protobuf/DescriptorProtos$UninterpretedOption:makeExtensionsImmutable	()V
    //   520: aload_1
    //   521: athrow
    //   522: iload_3
    //   523: iconst_1
    //   524: iand
    //   525: ifeq +14 -> 539
    //   528: aload_0
    //   529: aload_0
    //   530: getfield 70	com/google/protobuf/DescriptorProtos$UninterpretedOption:name_	Ljava/util/List;
    //   533: invokestatic 151	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   536: putfield 70	com/google/protobuf/DescriptorProtos$UninterpretedOption:name_	Ljava/util/List;
    //   539: aload_0
    //   540: aload 9
    //   542: invokevirtual 156	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   545: putfield 160	com/google/protobuf/DescriptorProtos$UninterpretedOption:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   548: aload_0
    //   549: invokevirtual 163	com/google/protobuf/DescriptorProtos$UninterpretedOption:makeExtensionsImmutable	()V
    //   552: return
    //   553: new 165	java/lang/NullPointerException
    //   556: dup
    //   557: invokespecial 166	java/lang/NullPointerException:<init>	()V
    //   560: astore_1
    //   561: goto +5 -> 566
    //   564: aload_1
    //   565: athrow
    //   566: goto -2 -> 564
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	569	0	this	UninterpretedOption
    //   0	569	1	paramCodedInputStream	CodedInputStream
    //   0	569	2	paramExtensionRegistryLite	ExtensionRegistryLite
    //   17	508	3	i	int
    //   36	409	4	j	int
    //   24	469	5	k	int
    //   27	435	6	m	int
    //   30	450	7	n	int
    //   14	438	8	i1	int
    //   11	530	9	localBuilder	UnknownFieldSet.Builder
    //   130	243	10	localByteString	ByteString
    // Exception table:
    //   from	to	target	type
    //   32	38	456	finally
    //   101	114	456	finally
    //   126	132	456	finally
    //   141	152	456	finally
    //   161	167	456	finally
    //   179	190	456	finally
    //   199	207	456	finally
    //   219	230	456	finally
    //   239	247	456	finally
    //   259	269	456	finally
    //   278	286	456	finally
    //   298	308	456	finally
    //   317	325	456	finally
    //   337	343	456	finally
    //   352	362	456	finally
    //   371	377	456	finally
    //   398	409	456	finally
    //   426	444	456	finally
    //   465	478	456	finally
    //   483	489	456	finally
    //   32	38	460	java/io/IOException
    //   101	114	460	java/io/IOException
    //   126	132	460	java/io/IOException
    //   141	152	460	java/io/IOException
    //   161	167	460	java/io/IOException
    //   179	190	460	java/io/IOException
    //   199	207	460	java/io/IOException
    //   219	230	460	java/io/IOException
    //   239	247	460	java/io/IOException
    //   259	269	460	java/io/IOException
    //   278	286	460	java/io/IOException
    //   298	308	460	java/io/IOException
    //   317	325	460	java/io/IOException
    //   337	343	460	java/io/IOException
    //   352	362	460	java/io/IOException
    //   371	377	460	java/io/IOException
    //   398	409	460	java/io/IOException
    //   426	444	460	java/io/IOException
    //   32	38	478	com/google/protobuf/InvalidProtocolBufferException
    //   101	114	478	com/google/protobuf/InvalidProtocolBufferException
    //   126	132	478	com/google/protobuf/InvalidProtocolBufferException
    //   141	152	478	com/google/protobuf/InvalidProtocolBufferException
    //   161	167	478	com/google/protobuf/InvalidProtocolBufferException
    //   179	190	478	com/google/protobuf/InvalidProtocolBufferException
    //   199	207	478	com/google/protobuf/InvalidProtocolBufferException
    //   219	230	478	com/google/protobuf/InvalidProtocolBufferException
    //   239	247	478	com/google/protobuf/InvalidProtocolBufferException
    //   259	269	478	com/google/protobuf/InvalidProtocolBufferException
    //   278	286	478	com/google/protobuf/InvalidProtocolBufferException
    //   298	308	478	com/google/protobuf/InvalidProtocolBufferException
    //   317	325	478	com/google/protobuf/InvalidProtocolBufferException
    //   337	343	478	com/google/protobuf/InvalidProtocolBufferException
    //   352	362	478	com/google/protobuf/InvalidProtocolBufferException
    //   371	377	478	com/google/protobuf/InvalidProtocolBufferException
    //   398	409	478	com/google/protobuf/InvalidProtocolBufferException
    //   426	444	478	com/google/protobuf/InvalidProtocolBufferException
  }
  
  private DescriptorProtos$UninterpretedOption(GeneratedMessageV3.Builder<?> paramBuilder)
  {
    super(paramBuilder);
  }
  
  public static UninterpretedOption getDefaultInstance()
  {
    return a;
  }
  
  public static final Descriptors.Descriptor getDescriptor()
  {
    return DescriptorProtos.R();
  }
  
  public static DescriptorProtos.UninterpretedOption.Builder newBuilder()
  {
    return a.toBuilder();
  }
  
  public static DescriptorProtos.UninterpretedOption.Builder newBuilder(UninterpretedOption paramUninterpretedOption)
  {
    return a.toBuilder().a(paramUninterpretedOption);
  }
  
  public static UninterpretedOption parseDelimitedFrom(InputStream paramInputStream)
  {
    return (UninterpretedOption)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream);
  }
  
  public static UninterpretedOption parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (UninterpretedOption)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static UninterpretedOption parseFrom(ByteString paramByteString)
  {
    return (UninterpretedOption)PARSER.parseFrom(paramByteString);
  }
  
  public static UninterpretedOption parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (UninterpretedOption)PARSER.parseFrom(paramByteString, paramExtensionRegistryLite);
  }
  
  public static UninterpretedOption parseFrom(CodedInputStream paramCodedInputStream)
  {
    return (UninterpretedOption)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream);
  }
  
  public static UninterpretedOption parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (UninterpretedOption)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static UninterpretedOption parseFrom(InputStream paramInputStream)
  {
    return (UninterpretedOption)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream);
  }
  
  public static UninterpretedOption parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (UninterpretedOption)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static UninterpretedOption parseFrom(ByteBuffer paramByteBuffer)
  {
    return (UninterpretedOption)PARSER.parseFrom(paramByteBuffer);
  }
  
  public static UninterpretedOption parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (UninterpretedOption)PARSER.parseFrom(paramByteBuffer, paramExtensionRegistryLite);
  }
  
  public static UninterpretedOption parseFrom(byte[] paramArrayOfByte)
  {
    return (UninterpretedOption)PARSER.parseFrom(paramArrayOfByte);
  }
  
  public static UninterpretedOption parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (UninterpretedOption)PARSER.parseFrom(paramArrayOfByte, paramExtensionRegistryLite);
  }
  
  public static Parser<UninterpretedOption> parser()
  {
    return PARSER;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof UninterpretedOption)) {
      return super.equals(paramObject);
    }
    paramObject = (UninterpretedOption)paramObject;
    if (!getNameList().equals(paramObject.getNameList())) {
      return false;
    }
    if (hasIdentifierValue() != paramObject.hasIdentifierValue()) {
      return false;
    }
    if ((hasIdentifierValue()) && (!getIdentifierValue().equals(paramObject.getIdentifierValue()))) {
      return false;
    }
    if (hasPositiveIntValue() != paramObject.hasPositiveIntValue()) {
      return false;
    }
    if ((hasPositiveIntValue()) && (getPositiveIntValue() != paramObject.getPositiveIntValue())) {
      return false;
    }
    if (hasNegativeIntValue() != paramObject.hasNegativeIntValue()) {
      return false;
    }
    if ((hasNegativeIntValue()) && (getNegativeIntValue() != paramObject.getNegativeIntValue())) {
      return false;
    }
    if (hasDoubleValue() != paramObject.hasDoubleValue()) {
      return false;
    }
    if ((hasDoubleValue()) && (Double.doubleToLongBits(getDoubleValue()) != Double.doubleToLongBits(paramObject.getDoubleValue()))) {
      return false;
    }
    if (hasStringValue() != paramObject.hasStringValue()) {
      return false;
    }
    if ((hasStringValue()) && (!getStringValue().equals(paramObject.getStringValue()))) {
      return false;
    }
    if (hasAggregateValue() != paramObject.hasAggregateValue()) {
      return false;
    }
    if ((hasAggregateValue()) && (!getAggregateValue().equals(paramObject.getAggregateValue()))) {
      return false;
    }
    return this.unknownFields.equals(paramObject.unknownFields);
  }
  
  public String getAggregateValue()
  {
    Object localObject = this.aggregateValue_;
    if ((localObject instanceof String)) {
      return (String)localObject;
    }
    localObject = (ByteString)localObject;
    String str = ((ByteString)localObject).toStringUtf8();
    if (((ByteString)localObject).isValidUtf8()) {
      this.aggregateValue_ = str;
    }
    return str;
  }
  
  public ByteString getAggregateValueBytes()
  {
    Object localObject = this.aggregateValue_;
    if ((localObject instanceof String))
    {
      localObject = ByteString.copyFromUtf8((String)localObject);
      this.aggregateValue_ = localObject;
      return localObject;
    }
    return (ByteString)localObject;
  }
  
  public UninterpretedOption getDefaultInstanceForType()
  {
    return a;
  }
  
  public double getDoubleValue()
  {
    return this.doubleValue_;
  }
  
  public String getIdentifierValue()
  {
    Object localObject = this.identifierValue_;
    if ((localObject instanceof String)) {
      return (String)localObject;
    }
    localObject = (ByteString)localObject;
    String str = ((ByteString)localObject).toStringUtf8();
    if (((ByteString)localObject).isValidUtf8()) {
      this.identifierValue_ = str;
    }
    return str;
  }
  
  public ByteString getIdentifierValueBytes()
  {
    Object localObject = this.identifierValue_;
    if ((localObject instanceof String))
    {
      localObject = ByteString.copyFromUtf8((String)localObject);
      this.identifierValue_ = localObject;
      return localObject;
    }
    return (ByteString)localObject;
  }
  
  public DescriptorProtos.UninterpretedOption.NamePart getName(int paramInt)
  {
    return (DescriptorProtos.UninterpretedOption.NamePart)this.name_.get(paramInt);
  }
  
  public int getNameCount()
  {
    return this.name_.size();
  }
  
  public List<DescriptorProtos.UninterpretedOption.NamePart> getNameList()
  {
    return this.name_;
  }
  
  public DescriptorProtos.UninterpretedOption.NamePartOrBuilder getNameOrBuilder(int paramInt)
  {
    return (DescriptorProtos.UninterpretedOption.NamePartOrBuilder)this.name_.get(paramInt);
  }
  
  public List<? extends DescriptorProtos.UninterpretedOption.NamePartOrBuilder> getNameOrBuilderList()
  {
    return this.name_;
  }
  
  public long getNegativeIntValue()
  {
    return this.negativeIntValue_;
  }
  
  public Parser<UninterpretedOption> getParserForType()
  {
    return PARSER;
  }
  
  public long getPositiveIntValue()
  {
    return this.positiveIntValue_;
  }
  
  public int getSerializedSize()
  {
    int i = this.memoizedSize;
    if (i != -1) {
      return i;
    }
    int j = 0;
    i = 0;
    while (j < this.name_.size())
    {
      i += CodedOutputStream.c(2, (MessageLite)this.name_.get(j));
      j += 1;
    }
    j = i;
    if ((this.bitField0_ & 0x1) != 0) {
      j = i + GeneratedMessageV3.computeStringSize(3, this.identifierValue_);
    }
    i = j;
    if ((this.bitField0_ & 0x2) != 0) {
      i = j + CodedOutputStream.g(4, this.positiveIntValue_);
    }
    j = i;
    if ((this.bitField0_ & 0x4) != 0) {
      j = i + CodedOutputStream.f(5, this.negativeIntValue_);
    }
    i = j;
    if ((this.bitField0_ & 0x8) != 0) {
      i = j + CodedOutputStream.b(6, this.doubleValue_);
    }
    j = i;
    if ((this.bitField0_ & 0x10) != 0) {
      j = i + CodedOutputStream.c(7, this.stringValue_);
    }
    i = j;
    if ((this.bitField0_ & 0x20) != 0) {
      i = j + GeneratedMessageV3.computeStringSize(8, this.aggregateValue_);
    }
    i += this.unknownFields.getSerializedSize();
    this.memoizedSize = i;
    return i;
  }
  
  public ByteString getStringValue()
  {
    return this.stringValue_;
  }
  
  public final UnknownFieldSet getUnknownFields()
  {
    return this.unknownFields;
  }
  
  public boolean hasAggregateValue()
  {
    return (this.bitField0_ & 0x20) != 0;
  }
  
  public boolean hasDoubleValue()
  {
    return (this.bitField0_ & 0x8) != 0;
  }
  
  public boolean hasIdentifierValue()
  {
    return (this.bitField0_ & 0x1) != 0;
  }
  
  public boolean hasNegativeIntValue()
  {
    return (this.bitField0_ & 0x4) != 0;
  }
  
  public boolean hasPositiveIntValue()
  {
    return (this.bitField0_ & 0x2) != 0;
  }
  
  public boolean hasStringValue()
  {
    return (this.bitField0_ & 0x10) != 0;
  }
  
  public int hashCode()
  {
    if (this.memoizedHashCode != 0) {
      return this.memoizedHashCode;
    }
    int j = 779 + getDescriptor().hashCode();
    int i = j;
    if (getNameCount() > 0) {
      i = (j * 37 + 2) * 53 + getNameList().hashCode();
    }
    j = i;
    if (hasIdentifierValue()) {
      j = (i * 37 + 3) * 53 + getIdentifierValue().hashCode();
    }
    i = j;
    if (hasPositiveIntValue()) {
      i = (j * 37 + 4) * 53 + Internal.a(getPositiveIntValue());
    }
    j = i;
    if (hasNegativeIntValue()) {
      j = (i * 37 + 5) * 53 + Internal.a(getNegativeIntValue());
    }
    i = j;
    if (hasDoubleValue()) {
      i = (j * 37 + 6) * 53 + Internal.a(Double.doubleToLongBits(getDoubleValue()));
    }
    j = i;
    if (hasStringValue()) {
      j = (i * 37 + 7) * 53 + getStringValue().hashCode();
    }
    i = j;
    if (hasAggregateValue()) {
      i = (j * 37 + 8) * 53 + getAggregateValue().hashCode();
    }
    i = i * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    return i;
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return DescriptorProtos.S().a(UninterpretedOption.class, DescriptorProtos.UninterpretedOption.Builder.class);
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
    while (i < getNameCount())
    {
      if (!getName(i).isInitialized())
      {
        this.memoizedIsInitialized = 0;
        return false;
      }
      i += 1;
    }
    this.memoizedIsInitialized = 1;
    return true;
  }
  
  public DescriptorProtos.UninterpretedOption.Builder newBuilderForType()
  {
    return newBuilder();
  }
  
  protected DescriptorProtos.UninterpretedOption.Builder newBuilderForType(GeneratedMessageV3.BuilderParent paramBuilderParent)
  {
    return new DescriptorProtos.UninterpretedOption.Builder(paramBuilderParent, null);
  }
  
  protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter paramUnusedPrivateParameter)
  {
    return new UninterpretedOption();
  }
  
  public DescriptorProtos.UninterpretedOption.Builder toBuilder()
  {
    if (this == a) {
      return new DescriptorProtos.UninterpretedOption.Builder(null);
    }
    return new DescriptorProtos.UninterpretedOption.Builder(null).a(this);
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
  {
    int i = 0;
    while (i < this.name_.size())
    {
      paramCodedOutputStream.a(2, (MessageLite)this.name_.get(i));
      i += 1;
    }
    if ((this.bitField0_ & 0x1) != 0) {
      GeneratedMessageV3.writeString(paramCodedOutputStream, 3, this.identifierValue_);
    }
    if ((this.bitField0_ & 0x2) != 0) {
      paramCodedOutputStream.b(4, this.positiveIntValue_);
    }
    if ((this.bitField0_ & 0x4) != 0) {
      paramCodedOutputStream.a(5, this.negativeIntValue_);
    }
    if ((this.bitField0_ & 0x8) != 0) {
      paramCodedOutputStream.a(6, this.doubleValue_);
    }
    if ((this.bitField0_ & 0x10) != 0) {
      paramCodedOutputStream.a(7, this.stringValue_);
    }
    if ((this.bitField0_ & 0x20) != 0) {
      GeneratedMessageV3.writeString(paramCodedOutputStream, 8, this.aggregateValue_);
    }
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.DescriptorProtos.UninterpretedOption
 * JD-Core Version:    0.7.0.1
 */