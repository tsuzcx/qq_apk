package com.google.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

public final class DescriptorProtos$GeneratedCodeInfo$Annotation
  extends GeneratedMessageV3
  implements DescriptorProtos.GeneratedCodeInfo.AnnotationOrBuilder
{
  public static final int BEGIN_FIELD_NUMBER = 3;
  public static final int END_FIELD_NUMBER = 4;
  @Deprecated
  public static final Parser<Annotation> PARSER = new DescriptorProtos.GeneratedCodeInfo.Annotation.1();
  public static final int PATH_FIELD_NUMBER = 1;
  public static final int SOURCE_FILE_FIELD_NUMBER = 2;
  private static final Annotation a = new Annotation();
  private static final long serialVersionUID = 0L;
  private int begin_;
  private int bitField0_;
  private int end_;
  private byte memoizedIsInitialized = -1;
  private int pathMemoizedSerializedSize = -1;
  private Internal.IntList path_;
  private volatile Object sourceFile_;
  
  private DescriptorProtos$GeneratedCodeInfo$Annotation()
  {
    this.path_ = emptyIntList();
    this.sourceFile_ = "";
  }
  
  /* Error */
  private DescriptorProtos$GeneratedCodeInfo$Annotation(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 40	com/google/protobuf/DescriptorProtos$GeneratedCodeInfo$Annotation:<init>	()V
    //   4: aload_2
    //   5: ifnull +527 -> 532
    //   8: invokestatic 73	com/google/protobuf/UnknownFieldSet:a	()Lcom/google/protobuf/UnknownFieldSet$Builder;
    //   11: astore 10
    //   13: iconst_0
    //   14: istore 8
    //   16: iconst_0
    //   17: istore_3
    //   18: iload 8
    //   20: ifne +483 -> 503
    //   23: iload_3
    //   24: istore 4
    //   26: iload_3
    //   27: istore 6
    //   29: iload_3
    //   30: istore 7
    //   32: aload_1
    //   33: invokevirtual 78	com/google/protobuf/CodedInputStream:a	()I
    //   36: istore 5
    //   38: iload 5
    //   40: ifeq +393 -> 433
    //   43: iload 5
    //   45: bipush 8
    //   47: if_icmpeq +325 -> 372
    //   50: iload 5
    //   52: bipush 10
    //   54: if_icmpeq +179 -> 233
    //   57: iload 5
    //   59: bipush 18
    //   61: if_icmpeq +120 -> 181
    //   64: iload 5
    //   66: bipush 24
    //   68: if_icmpeq +74 -> 142
    //   71: iload 5
    //   73: bipush 32
    //   75: if_icmpeq +28 -> 103
    //   78: iload_3
    //   79: istore 4
    //   81: iload_3
    //   82: istore 6
    //   84: iload_3
    //   85: istore 7
    //   87: aload_0
    //   88: aload_1
    //   89: aload 10
    //   91: aload_2
    //   92: iload 5
    //   94: invokevirtual 82	com/google/protobuf/DescriptorProtos$GeneratedCodeInfo$Annotation:parseUnknownField	(Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/UnknownFieldSet$Builder;Lcom/google/protobuf/ExtensionRegistryLite;I)Z
    //   97: ifne -79 -> 18
    //   100: goto +333 -> 433
    //   103: iload_3
    //   104: istore 4
    //   106: iload_3
    //   107: istore 6
    //   109: iload_3
    //   110: istore 7
    //   112: aload_0
    //   113: aload_0
    //   114: getfield 84	com/google/protobuf/DescriptorProtos$GeneratedCodeInfo$Annotation:bitField0_	I
    //   117: iconst_4
    //   118: ior
    //   119: putfield 84	com/google/protobuf/DescriptorProtos$GeneratedCodeInfo$Annotation:bitField0_	I
    //   122: iload_3
    //   123: istore 4
    //   125: iload_3
    //   126: istore 6
    //   128: iload_3
    //   129: istore 7
    //   131: aload_0
    //   132: aload_1
    //   133: invokevirtual 87	com/google/protobuf/CodedInputStream:f	()I
    //   136: putfield 89	com/google/protobuf/DescriptorProtos$GeneratedCodeInfo$Annotation:end_	I
    //   139: goto -121 -> 18
    //   142: iload_3
    //   143: istore 4
    //   145: iload_3
    //   146: istore 6
    //   148: iload_3
    //   149: istore 7
    //   151: aload_0
    //   152: aload_0
    //   153: getfield 84	com/google/protobuf/DescriptorProtos$GeneratedCodeInfo$Annotation:bitField0_	I
    //   156: iconst_2
    //   157: ior
    //   158: putfield 84	com/google/protobuf/DescriptorProtos$GeneratedCodeInfo$Annotation:bitField0_	I
    //   161: iload_3
    //   162: istore 4
    //   164: iload_3
    //   165: istore 6
    //   167: iload_3
    //   168: istore 7
    //   170: aload_0
    //   171: aload_1
    //   172: invokevirtual 87	com/google/protobuf/CodedInputStream:f	()I
    //   175: putfield 91	com/google/protobuf/DescriptorProtos$GeneratedCodeInfo$Annotation:begin_	I
    //   178: goto -160 -> 18
    //   181: iload_3
    //   182: istore 4
    //   184: iload_3
    //   185: istore 6
    //   187: iload_3
    //   188: istore 7
    //   190: aload_1
    //   191: invokevirtual 95	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   194: astore 11
    //   196: iload_3
    //   197: istore 4
    //   199: iload_3
    //   200: istore 6
    //   202: iload_3
    //   203: istore 7
    //   205: aload_0
    //   206: aload_0
    //   207: getfield 84	com/google/protobuf/DescriptorProtos$GeneratedCodeInfo$Annotation:bitField0_	I
    //   210: iconst_1
    //   211: ior
    //   212: putfield 84	com/google/protobuf/DescriptorProtos$GeneratedCodeInfo$Annotation:bitField0_	I
    //   215: iload_3
    //   216: istore 4
    //   218: iload_3
    //   219: istore 6
    //   221: iload_3
    //   222: istore 7
    //   224: aload_0
    //   225: aload 11
    //   227: putfield 63	com/google/protobuf/DescriptorProtos$GeneratedCodeInfo$Annotation:sourceFile_	Ljava/lang/Object;
    //   230: goto -212 -> 18
    //   233: iload_3
    //   234: istore 4
    //   236: iload_3
    //   237: istore 6
    //   239: iload_3
    //   240: istore 7
    //   242: aload_1
    //   243: aload_1
    //   244: invokevirtual 98	com/google/protobuf/CodedInputStream:s	()I
    //   247: invokevirtual 102	com/google/protobuf/CodedInputStream:c	(I)I
    //   250: istore 9
    //   252: iload_3
    //   253: istore 5
    //   255: iload_3
    //   256: iconst_1
    //   257: iand
    //   258: ifne +43 -> 301
    //   261: iload_3
    //   262: istore 5
    //   264: iload_3
    //   265: istore 4
    //   267: iload_3
    //   268: istore 6
    //   270: iload_3
    //   271: istore 7
    //   273: aload_1
    //   274: invokevirtual 105	com/google/protobuf/CodedInputStream:x	()I
    //   277: ifle +24 -> 301
    //   280: iload_3
    //   281: istore 4
    //   283: iload_3
    //   284: istore 6
    //   286: iload_3
    //   287: istore 7
    //   289: aload_0
    //   290: invokestatic 108	com/google/protobuf/DescriptorProtos$GeneratedCodeInfo$Annotation:newIntList	()Lcom/google/protobuf/Internal$IntList;
    //   293: putfield 59	com/google/protobuf/DescriptorProtos$GeneratedCodeInfo$Annotation:path_	Lcom/google/protobuf/Internal$IntList;
    //   296: iload_3
    //   297: iconst_1
    //   298: ior
    //   299: istore 5
    //   301: iload 5
    //   303: istore 4
    //   305: iload 5
    //   307: istore 6
    //   309: iload 5
    //   311: istore 7
    //   313: aload_1
    //   314: invokevirtual 105	com/google/protobuf/CodedInputStream:x	()I
    //   317: ifle +31 -> 348
    //   320: iload 5
    //   322: istore 4
    //   324: iload 5
    //   326: istore 6
    //   328: iload 5
    //   330: istore 7
    //   332: aload_0
    //   333: getfield 59	com/google/protobuf/DescriptorProtos$GeneratedCodeInfo$Annotation:path_	Lcom/google/protobuf/Internal$IntList;
    //   336: aload_1
    //   337: invokevirtual 87	com/google/protobuf/CodedInputStream:f	()I
    //   340: invokeinterface 114 2 0
    //   345: goto -44 -> 301
    //   348: iload 5
    //   350: istore 4
    //   352: iload 5
    //   354: istore 6
    //   356: iload 5
    //   358: istore 7
    //   360: aload_1
    //   361: iload 9
    //   363: invokevirtual 115	com/google/protobuf/CodedInputStream:d	(I)V
    //   366: iload 5
    //   368: istore_3
    //   369: goto -351 -> 18
    //   372: iload_3
    //   373: istore 5
    //   375: iload_3
    //   376: iconst_1
    //   377: iand
    //   378: ifne +24 -> 402
    //   381: iload_3
    //   382: istore 4
    //   384: iload_3
    //   385: istore 6
    //   387: iload_3
    //   388: istore 7
    //   390: aload_0
    //   391: invokestatic 108	com/google/protobuf/DescriptorProtos$GeneratedCodeInfo$Annotation:newIntList	()Lcom/google/protobuf/Internal$IntList;
    //   394: putfield 59	com/google/protobuf/DescriptorProtos$GeneratedCodeInfo$Annotation:path_	Lcom/google/protobuf/Internal$IntList;
    //   397: iload_3
    //   398: iconst_1
    //   399: ior
    //   400: istore 5
    //   402: iload 5
    //   404: istore 4
    //   406: iload 5
    //   408: istore 6
    //   410: iload 5
    //   412: istore 7
    //   414: aload_0
    //   415: getfield 59	com/google/protobuf/DescriptorProtos$GeneratedCodeInfo$Annotation:path_	Lcom/google/protobuf/Internal$IntList;
    //   418: aload_1
    //   419: invokevirtual 87	com/google/protobuf/CodedInputStream:f	()I
    //   422: invokeinterface 114 2 0
    //   427: iload 5
    //   429: istore_3
    //   430: goto -412 -> 18
    //   433: iconst_1
    //   434: istore 8
    //   436: goto -418 -> 18
    //   439: astore_1
    //   440: goto +32 -> 472
    //   443: astore_1
    //   444: iload 6
    //   446: istore 4
    //   448: new 66	com/google/protobuf/InvalidProtocolBufferException
    //   451: dup
    //   452: aload_1
    //   453: invokespecial 118	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/io/IOException;)V
    //   456: aload_0
    //   457: invokevirtual 122	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   460: athrow
    //   461: astore_1
    //   462: iload 7
    //   464: istore 4
    //   466: aload_1
    //   467: aload_0
    //   468: invokevirtual 122	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   471: athrow
    //   472: iload 4
    //   474: iconst_1
    //   475: iand
    //   476: ifeq +12 -> 488
    //   479: aload_0
    //   480: getfield 59	com/google/protobuf/DescriptorProtos$GeneratedCodeInfo$Annotation:path_	Lcom/google/protobuf/Internal$IntList;
    //   483: invokeinterface 125 1 0
    //   488: aload_0
    //   489: aload 10
    //   491: invokevirtual 130	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   494: putfield 134	com/google/protobuf/DescriptorProtos$GeneratedCodeInfo$Annotation:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   497: aload_0
    //   498: invokevirtual 137	com/google/protobuf/DescriptorProtos$GeneratedCodeInfo$Annotation:makeExtensionsImmutable	()V
    //   501: aload_1
    //   502: athrow
    //   503: iload_3
    //   504: iconst_1
    //   505: iand
    //   506: ifeq +12 -> 518
    //   509: aload_0
    //   510: getfield 59	com/google/protobuf/DescriptorProtos$GeneratedCodeInfo$Annotation:path_	Lcom/google/protobuf/Internal$IntList;
    //   513: invokeinterface 125 1 0
    //   518: aload_0
    //   519: aload 10
    //   521: invokevirtual 130	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   524: putfield 134	com/google/protobuf/DescriptorProtos$GeneratedCodeInfo$Annotation:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   527: aload_0
    //   528: invokevirtual 137	com/google/protobuf/DescriptorProtos$GeneratedCodeInfo$Annotation:makeExtensionsImmutable	()V
    //   531: return
    //   532: new 139	java/lang/NullPointerException
    //   535: dup
    //   536: invokespecial 140	java/lang/NullPointerException:<init>	()V
    //   539: astore_1
    //   540: goto +5 -> 545
    //   543: aload_1
    //   544: athrow
    //   545: goto -2 -> 543
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	548	0	this	Annotation
    //   0	548	1	paramCodedInputStream	CodedInputStream
    //   0	548	2	paramExtensionRegistryLite	ExtensionRegistryLite
    //   17	489	3	i	int
    //   24	452	4	j	int
    //   36	392	5	k	int
    //   27	418	6	m	int
    //   30	433	7	n	int
    //   14	421	8	i1	int
    //   250	112	9	i2	int
    //   11	509	10	localBuilder	UnknownFieldSet.Builder
    //   194	32	11	localByteString	ByteString
    // Exception table:
    //   from	to	target	type
    //   32	38	439	finally
    //   87	100	439	finally
    //   112	122	439	finally
    //   131	139	439	finally
    //   151	161	439	finally
    //   170	178	439	finally
    //   190	196	439	finally
    //   205	215	439	finally
    //   224	230	439	finally
    //   242	252	439	finally
    //   273	280	439	finally
    //   289	296	439	finally
    //   313	320	439	finally
    //   332	345	439	finally
    //   360	366	439	finally
    //   390	397	439	finally
    //   414	427	439	finally
    //   448	461	439	finally
    //   466	472	439	finally
    //   32	38	443	java/io/IOException
    //   87	100	443	java/io/IOException
    //   112	122	443	java/io/IOException
    //   131	139	443	java/io/IOException
    //   151	161	443	java/io/IOException
    //   170	178	443	java/io/IOException
    //   190	196	443	java/io/IOException
    //   205	215	443	java/io/IOException
    //   224	230	443	java/io/IOException
    //   242	252	443	java/io/IOException
    //   273	280	443	java/io/IOException
    //   289	296	443	java/io/IOException
    //   313	320	443	java/io/IOException
    //   332	345	443	java/io/IOException
    //   360	366	443	java/io/IOException
    //   390	397	443	java/io/IOException
    //   414	427	443	java/io/IOException
    //   32	38	461	com/google/protobuf/InvalidProtocolBufferException
    //   87	100	461	com/google/protobuf/InvalidProtocolBufferException
    //   112	122	461	com/google/protobuf/InvalidProtocolBufferException
    //   131	139	461	com/google/protobuf/InvalidProtocolBufferException
    //   151	161	461	com/google/protobuf/InvalidProtocolBufferException
    //   170	178	461	com/google/protobuf/InvalidProtocolBufferException
    //   190	196	461	com/google/protobuf/InvalidProtocolBufferException
    //   205	215	461	com/google/protobuf/InvalidProtocolBufferException
    //   224	230	461	com/google/protobuf/InvalidProtocolBufferException
    //   242	252	461	com/google/protobuf/InvalidProtocolBufferException
    //   273	280	461	com/google/protobuf/InvalidProtocolBufferException
    //   289	296	461	com/google/protobuf/InvalidProtocolBufferException
    //   313	320	461	com/google/protobuf/InvalidProtocolBufferException
    //   332	345	461	com/google/protobuf/InvalidProtocolBufferException
    //   360	366	461	com/google/protobuf/InvalidProtocolBufferException
    //   390	397	461	com/google/protobuf/InvalidProtocolBufferException
    //   414	427	461	com/google/protobuf/InvalidProtocolBufferException
  }
  
  private DescriptorProtos$GeneratedCodeInfo$Annotation(GeneratedMessageV3.Builder<?> paramBuilder)
  {
    super(paramBuilder);
  }
  
  public static Annotation getDefaultInstance()
  {
    return a;
  }
  
  public static final Descriptors.Descriptor getDescriptor()
  {
    return DescriptorProtos.ab();
  }
  
  public static DescriptorProtos.GeneratedCodeInfo.Annotation.Builder newBuilder()
  {
    return a.toBuilder();
  }
  
  public static DescriptorProtos.GeneratedCodeInfo.Annotation.Builder newBuilder(Annotation paramAnnotation)
  {
    return a.toBuilder().a(paramAnnotation);
  }
  
  public static Annotation parseDelimitedFrom(InputStream paramInputStream)
  {
    return (Annotation)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream);
  }
  
  public static Annotation parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (Annotation)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Annotation parseFrom(ByteString paramByteString)
  {
    return (Annotation)PARSER.parseFrom(paramByteString);
  }
  
  public static Annotation parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (Annotation)PARSER.parseFrom(paramByteString, paramExtensionRegistryLite);
  }
  
  public static Annotation parseFrom(CodedInputStream paramCodedInputStream)
  {
    return (Annotation)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream);
  }
  
  public static Annotation parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (Annotation)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static Annotation parseFrom(InputStream paramInputStream)
  {
    return (Annotation)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream);
  }
  
  public static Annotation parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (Annotation)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Annotation parseFrom(ByteBuffer paramByteBuffer)
  {
    return (Annotation)PARSER.parseFrom(paramByteBuffer);
  }
  
  public static Annotation parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (Annotation)PARSER.parseFrom(paramByteBuffer, paramExtensionRegistryLite);
  }
  
  public static Annotation parseFrom(byte[] paramArrayOfByte)
  {
    return (Annotation)PARSER.parseFrom(paramArrayOfByte);
  }
  
  public static Annotation parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (Annotation)PARSER.parseFrom(paramArrayOfByte, paramExtensionRegistryLite);
  }
  
  public static Parser<Annotation> parser()
  {
    return PARSER;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof Annotation)) {
      return super.equals(paramObject);
    }
    paramObject = (Annotation)paramObject;
    if (!getPathList().equals(paramObject.getPathList())) {
      return false;
    }
    if (hasSourceFile() != paramObject.hasSourceFile()) {
      return false;
    }
    if ((hasSourceFile()) && (!getSourceFile().equals(paramObject.getSourceFile()))) {
      return false;
    }
    if (hasBegin() != paramObject.hasBegin()) {
      return false;
    }
    if ((hasBegin()) && (getBegin() != paramObject.getBegin())) {
      return false;
    }
    if (hasEnd() != paramObject.hasEnd()) {
      return false;
    }
    if ((hasEnd()) && (getEnd() != paramObject.getEnd())) {
      return false;
    }
    return this.unknownFields.equals(paramObject.unknownFields);
  }
  
  public int getBegin()
  {
    return this.begin_;
  }
  
  public Annotation getDefaultInstanceForType()
  {
    return a;
  }
  
  public int getEnd()
  {
    return this.end_;
  }
  
  public Parser<Annotation> getParserForType()
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
    j = i;
    if ((this.bitField0_ & 0x1) != 0) {
      j = i + GeneratedMessageV3.computeStringSize(2, this.sourceFile_);
    }
    i = j;
    if ((this.bitField0_ & 0x2) != 0) {
      i = j + CodedOutputStream.h(3, this.begin_);
    }
    j = i;
    if ((this.bitField0_ & 0x4) != 0) {
      j = i + CodedOutputStream.h(4, this.end_);
    }
    i = j + this.unknownFields.getSerializedSize();
    this.memoizedSize = i;
    return i;
  }
  
  public String getSourceFile()
  {
    Object localObject = this.sourceFile_;
    if ((localObject instanceof String)) {
      return (String)localObject;
    }
    localObject = (ByteString)localObject;
    String str = ((ByteString)localObject).toStringUtf8();
    if (((ByteString)localObject).isValidUtf8()) {
      this.sourceFile_ = str;
    }
    return str;
  }
  
  public ByteString getSourceFileBytes()
  {
    Object localObject = this.sourceFile_;
    if ((localObject instanceof String))
    {
      localObject = ByteString.copyFromUtf8((String)localObject);
      this.sourceFile_ = localObject;
      return localObject;
    }
    return (ByteString)localObject;
  }
  
  public final UnknownFieldSet getUnknownFields()
  {
    return this.unknownFields;
  }
  
  public boolean hasBegin()
  {
    return (this.bitField0_ & 0x2) != 0;
  }
  
  public boolean hasEnd()
  {
    return (this.bitField0_ & 0x4) != 0;
  }
  
  public boolean hasSourceFile()
  {
    return (this.bitField0_ & 0x1) != 0;
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
    if (hasSourceFile()) {
      j = (i * 37 + 2) * 53 + getSourceFile().hashCode();
    }
    i = j;
    if (hasBegin()) {
      i = (j * 37 + 3) * 53 + getBegin();
    }
    j = i;
    if (hasEnd()) {
      j = (i * 37 + 4) * 53 + getEnd();
    }
    i = j * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    return i;
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return DescriptorProtos.ac().a(Annotation.class, DescriptorProtos.GeneratedCodeInfo.Annotation.Builder.class);
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
  
  public DescriptorProtos.GeneratedCodeInfo.Annotation.Builder newBuilderForType()
  {
    return newBuilder();
  }
  
  protected DescriptorProtos.GeneratedCodeInfo.Annotation.Builder newBuilderForType(GeneratedMessageV3.BuilderParent paramBuilderParent)
  {
    return new DescriptorProtos.GeneratedCodeInfo.Annotation.Builder(paramBuilderParent, null);
  }
  
  protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter paramUnusedPrivateParameter)
  {
    return new Annotation();
  }
  
  public DescriptorProtos.GeneratedCodeInfo.Annotation.Builder toBuilder()
  {
    if (this == a) {
      return new DescriptorProtos.GeneratedCodeInfo.Annotation.Builder(null);
    }
    return new DescriptorProtos.GeneratedCodeInfo.Annotation.Builder(null).a(this);
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
  {
    getSerializedSize();
    if (getPathList().size() > 0)
    {
      paramCodedOutputStream.c(10);
      paramCodedOutputStream.c(this.pathMemoizedSerializedSize);
    }
    int i = 0;
    while (i < this.path_.size())
    {
      paramCodedOutputStream.b(this.path_.c(i));
      i += 1;
    }
    if ((this.bitField0_ & 0x1) != 0) {
      GeneratedMessageV3.writeString(paramCodedOutputStream, 2, this.sourceFile_);
    }
    if ((this.bitField0_ & 0x2) != 0) {
      paramCodedOutputStream.b(3, this.begin_);
    }
    if ((this.bitField0_ & 0x4) != 0) {
      paramCodedOutputStream.b(4, this.end_);
    }
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.DescriptorProtos.GeneratedCodeInfo.Annotation
 * JD-Core Version:    0.7.0.1
 */