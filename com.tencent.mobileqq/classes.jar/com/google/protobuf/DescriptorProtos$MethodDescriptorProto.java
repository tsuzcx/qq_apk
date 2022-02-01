package com.google.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;

public final class DescriptorProtos$MethodDescriptorProto
  extends GeneratedMessageV3
  implements DescriptorProtos.MethodDescriptorProtoOrBuilder
{
  public static final int CLIENT_STREAMING_FIELD_NUMBER = 5;
  public static final int INPUT_TYPE_FIELD_NUMBER = 2;
  public static final int NAME_FIELD_NUMBER = 1;
  public static final int OPTIONS_FIELD_NUMBER = 4;
  public static final int OUTPUT_TYPE_FIELD_NUMBER = 3;
  @Deprecated
  public static final Parser<MethodDescriptorProto> PARSER = new DescriptorProtos.MethodDescriptorProto.1();
  public static final int SERVER_STREAMING_FIELD_NUMBER = 6;
  private static final MethodDescriptorProto a = new MethodDescriptorProto();
  private static final long serialVersionUID = 0L;
  private int bitField0_;
  private boolean clientStreaming_;
  private volatile Object inputType_;
  private byte memoizedIsInitialized = -1;
  private volatile Object name_;
  private DescriptorProtos.MethodOptions options_;
  private volatile Object outputType_;
  private boolean serverStreaming_;
  
  private DescriptorProtos$MethodDescriptorProto()
  {
    this.name_ = "";
    this.inputType_ = "";
    this.outputType_ = "";
  }
  
  /* Error */
  private DescriptorProtos$MethodDescriptorProto(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 46	com/google/protobuf/DescriptorProtos$MethodDescriptorProto:<init>	()V
    //   4: aload_2
    //   5: ifnull +336 -> 341
    //   8: invokestatic 75	com/google/protobuf/UnknownFieldSet:a	()Lcom/google/protobuf/UnknownFieldSet$Builder;
    //   11: astore 6
    //   13: iconst_0
    //   14: istore_3
    //   15: iload_3
    //   16: ifne +311 -> 327
    //   19: aload_1
    //   20: invokevirtual 80	com/google/protobuf/CodedInputStream:a	()I
    //   23: istore 4
    //   25: iload 4
    //   27: ifeq +255 -> 282
    //   30: iload 4
    //   32: bipush 10
    //   34: if_icmpeq +223 -> 257
    //   37: iload 4
    //   39: bipush 18
    //   41: if_icmpeq +191 -> 232
    //   44: iload 4
    //   46: bipush 26
    //   48: if_icmpeq +159 -> 207
    //   51: iload 4
    //   53: bipush 34
    //   55: if_icmpeq +77 -> 132
    //   58: iload 4
    //   60: bipush 40
    //   62: if_icmpeq +48 -> 110
    //   65: iload 4
    //   67: bipush 48
    //   69: if_icmpeq +19 -> 88
    //   72: aload_0
    //   73: aload_1
    //   74: aload 6
    //   76: aload_2
    //   77: iload 4
    //   79: invokevirtual 84	com/google/protobuf/DescriptorProtos$MethodDescriptorProto:parseUnknownField	(Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/UnknownFieldSet$Builder;Lcom/google/protobuf/ExtensionRegistryLite;I)Z
    //   82: ifne -67 -> 15
    //   85: goto +197 -> 282
    //   88: aload_0
    //   89: aload_0
    //   90: getfield 86	com/google/protobuf/DescriptorProtos$MethodDescriptorProto:bitField0_	I
    //   93: bipush 32
    //   95: ior
    //   96: putfield 86	com/google/protobuf/DescriptorProtos$MethodDescriptorProto:bitField0_	I
    //   99: aload_0
    //   100: aload_1
    //   101: invokevirtual 90	com/google/protobuf/CodedInputStream:i	()Z
    //   104: putfield 92	com/google/protobuf/DescriptorProtos$MethodDescriptorProto:serverStreaming_	Z
    //   107: goto -92 -> 15
    //   110: aload_0
    //   111: aload_0
    //   112: getfield 86	com/google/protobuf/DescriptorProtos$MethodDescriptorProto:bitField0_	I
    //   115: bipush 16
    //   117: ior
    //   118: putfield 86	com/google/protobuf/DescriptorProtos$MethodDescriptorProto:bitField0_	I
    //   121: aload_0
    //   122: aload_1
    //   123: invokevirtual 90	com/google/protobuf/CodedInputStream:i	()Z
    //   126: putfield 94	com/google/protobuf/DescriptorProtos$MethodDescriptorProto:clientStreaming_	Z
    //   129: goto -114 -> 15
    //   132: aconst_null
    //   133: astore 5
    //   135: aload_0
    //   136: getfield 86	com/google/protobuf/DescriptorProtos$MethodDescriptorProto:bitField0_	I
    //   139: bipush 8
    //   141: iand
    //   142: ifeq +12 -> 154
    //   145: aload_0
    //   146: getfield 96	com/google/protobuf/DescriptorProtos$MethodDescriptorProto:options_	Lcom/google/protobuf/DescriptorProtos$MethodOptions;
    //   149: invokevirtual 102	com/google/protobuf/DescriptorProtos$MethodOptions:toBuilder	()Lcom/google/protobuf/DescriptorProtos$MethodOptions$Builder;
    //   152: astore 5
    //   154: aload_0
    //   155: aload_1
    //   156: getstatic 103	com/google/protobuf/DescriptorProtos$MethodOptions:PARSER	Lcom/google/protobuf/Parser;
    //   159: aload_2
    //   160: invokevirtual 106	com/google/protobuf/CodedInputStream:a	(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   163: checkcast 98	com/google/protobuf/DescriptorProtos$MethodOptions
    //   166: putfield 96	com/google/protobuf/DescriptorProtos$MethodDescriptorProto:options_	Lcom/google/protobuf/DescriptorProtos$MethodOptions;
    //   169: aload 5
    //   171: ifnull +22 -> 193
    //   174: aload 5
    //   176: aload_0
    //   177: getfield 96	com/google/protobuf/DescriptorProtos$MethodDescriptorProto:options_	Lcom/google/protobuf/DescriptorProtos$MethodOptions;
    //   180: invokevirtual 111	com/google/protobuf/DescriptorProtos$MethodOptions$Builder:a	(Lcom/google/protobuf/DescriptorProtos$MethodOptions;)Lcom/google/protobuf/DescriptorProtos$MethodOptions$Builder;
    //   183: pop
    //   184: aload_0
    //   185: aload 5
    //   187: invokevirtual 115	com/google/protobuf/DescriptorProtos$MethodOptions$Builder:d	()Lcom/google/protobuf/DescriptorProtos$MethodOptions;
    //   190: putfield 96	com/google/protobuf/DescriptorProtos$MethodDescriptorProto:options_	Lcom/google/protobuf/DescriptorProtos$MethodOptions;
    //   193: aload_0
    //   194: aload_0
    //   195: getfield 86	com/google/protobuf/DescriptorProtos$MethodDescriptorProto:bitField0_	I
    //   198: bipush 8
    //   200: ior
    //   201: putfield 86	com/google/protobuf/DescriptorProtos$MethodDescriptorProto:bitField0_	I
    //   204: goto -189 -> 15
    //   207: aload_1
    //   208: invokevirtual 119	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   211: astore 5
    //   213: aload_0
    //   214: aload_0
    //   215: getfield 86	com/google/protobuf/DescriptorProtos$MethodDescriptorProto:bitField0_	I
    //   218: iconst_4
    //   219: ior
    //   220: putfield 86	com/google/protobuf/DescriptorProtos$MethodDescriptorProto:bitField0_	I
    //   223: aload_0
    //   224: aload 5
    //   226: putfield 65	com/google/protobuf/DescriptorProtos$MethodDescriptorProto:outputType_	Ljava/lang/Object;
    //   229: goto -214 -> 15
    //   232: aload_1
    //   233: invokevirtual 119	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   236: astore 5
    //   238: aload_0
    //   239: aload_0
    //   240: getfield 86	com/google/protobuf/DescriptorProtos$MethodDescriptorProto:bitField0_	I
    //   243: iconst_2
    //   244: ior
    //   245: putfield 86	com/google/protobuf/DescriptorProtos$MethodDescriptorProto:bitField0_	I
    //   248: aload_0
    //   249: aload 5
    //   251: putfield 63	com/google/protobuf/DescriptorProtos$MethodDescriptorProto:inputType_	Ljava/lang/Object;
    //   254: goto -239 -> 15
    //   257: aload_1
    //   258: invokevirtual 119	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   261: astore 5
    //   263: aload_0
    //   264: iconst_1
    //   265: aload_0
    //   266: getfield 86	com/google/protobuf/DescriptorProtos$MethodDescriptorProto:bitField0_	I
    //   269: ior
    //   270: putfield 86	com/google/protobuf/DescriptorProtos$MethodDescriptorProto:bitField0_	I
    //   273: aload_0
    //   274: aload 5
    //   276: putfield 61	com/google/protobuf/DescriptorProtos$MethodDescriptorProto:name_	Ljava/lang/Object;
    //   279: goto -264 -> 15
    //   282: iconst_1
    //   283: istore_3
    //   284: goto -269 -> 15
    //   287: astore_1
    //   288: goto +24 -> 312
    //   291: astore_1
    //   292: new 68	com/google/protobuf/InvalidProtocolBufferException
    //   295: dup
    //   296: aload_1
    //   297: invokespecial 122	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/io/IOException;)V
    //   300: aload_0
    //   301: invokevirtual 126	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   304: athrow
    //   305: astore_1
    //   306: aload_1
    //   307: aload_0
    //   308: invokevirtual 126	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   311: athrow
    //   312: aload_0
    //   313: aload 6
    //   315: invokevirtual 131	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   318: putfield 135	com/google/protobuf/DescriptorProtos$MethodDescriptorProto:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   321: aload_0
    //   322: invokevirtual 138	com/google/protobuf/DescriptorProtos$MethodDescriptorProto:makeExtensionsImmutable	()V
    //   325: aload_1
    //   326: athrow
    //   327: aload_0
    //   328: aload 6
    //   330: invokevirtual 131	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   333: putfield 135	com/google/protobuf/DescriptorProtos$MethodDescriptorProto:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   336: aload_0
    //   337: invokevirtual 138	com/google/protobuf/DescriptorProtos$MethodDescriptorProto:makeExtensionsImmutable	()V
    //   340: return
    //   341: new 140	java/lang/NullPointerException
    //   344: dup
    //   345: invokespecial 141	java/lang/NullPointerException:<init>	()V
    //   348: astore_1
    //   349: goto +5 -> 354
    //   352: aload_1
    //   353: athrow
    //   354: goto -2 -> 352
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	357	0	this	MethodDescriptorProto
    //   0	357	1	paramCodedInputStream	CodedInputStream
    //   0	357	2	paramExtensionRegistryLite	ExtensionRegistryLite
    //   14	270	3	i	int
    //   23	55	4	j	int
    //   133	142	5	localObject	Object
    //   11	318	6	localBuilder	UnknownFieldSet.Builder
    // Exception table:
    //   from	to	target	type
    //   19	25	287	finally
    //   72	85	287	finally
    //   88	107	287	finally
    //   110	129	287	finally
    //   135	154	287	finally
    //   154	169	287	finally
    //   174	193	287	finally
    //   193	204	287	finally
    //   207	229	287	finally
    //   232	254	287	finally
    //   257	279	287	finally
    //   292	305	287	finally
    //   306	312	287	finally
    //   19	25	291	java/io/IOException
    //   72	85	291	java/io/IOException
    //   88	107	291	java/io/IOException
    //   110	129	291	java/io/IOException
    //   135	154	291	java/io/IOException
    //   154	169	291	java/io/IOException
    //   174	193	291	java/io/IOException
    //   193	204	291	java/io/IOException
    //   207	229	291	java/io/IOException
    //   232	254	291	java/io/IOException
    //   257	279	291	java/io/IOException
    //   19	25	305	com/google/protobuf/InvalidProtocolBufferException
    //   72	85	305	com/google/protobuf/InvalidProtocolBufferException
    //   88	107	305	com/google/protobuf/InvalidProtocolBufferException
    //   110	129	305	com/google/protobuf/InvalidProtocolBufferException
    //   135	154	305	com/google/protobuf/InvalidProtocolBufferException
    //   154	169	305	com/google/protobuf/InvalidProtocolBufferException
    //   174	193	305	com/google/protobuf/InvalidProtocolBufferException
    //   193	204	305	com/google/protobuf/InvalidProtocolBufferException
    //   207	229	305	com/google/protobuf/InvalidProtocolBufferException
    //   232	254	305	com/google/protobuf/InvalidProtocolBufferException
    //   257	279	305	com/google/protobuf/InvalidProtocolBufferException
  }
  
  private DescriptorProtos$MethodDescriptorProto(GeneratedMessageV3.Builder<?> paramBuilder)
  {
    super(paramBuilder);
  }
  
  public static MethodDescriptorProto getDefaultInstance()
  {
    return a;
  }
  
  public static final Descriptors.Descriptor getDescriptor()
  {
    return DescriptorProtos.z();
  }
  
  public static DescriptorProtos.MethodDescriptorProto.Builder newBuilder()
  {
    return a.toBuilder();
  }
  
  public static DescriptorProtos.MethodDescriptorProto.Builder newBuilder(MethodDescriptorProto paramMethodDescriptorProto)
  {
    return a.toBuilder().a(paramMethodDescriptorProto);
  }
  
  public static MethodDescriptorProto parseDelimitedFrom(InputStream paramInputStream)
  {
    return (MethodDescriptorProto)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream);
  }
  
  public static MethodDescriptorProto parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (MethodDescriptorProto)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static MethodDescriptorProto parseFrom(ByteString paramByteString)
  {
    return (MethodDescriptorProto)PARSER.parseFrom(paramByteString);
  }
  
  public static MethodDescriptorProto parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (MethodDescriptorProto)PARSER.parseFrom(paramByteString, paramExtensionRegistryLite);
  }
  
  public static MethodDescriptorProto parseFrom(CodedInputStream paramCodedInputStream)
  {
    return (MethodDescriptorProto)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream);
  }
  
  public static MethodDescriptorProto parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (MethodDescriptorProto)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static MethodDescriptorProto parseFrom(InputStream paramInputStream)
  {
    return (MethodDescriptorProto)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream);
  }
  
  public static MethodDescriptorProto parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (MethodDescriptorProto)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static MethodDescriptorProto parseFrom(ByteBuffer paramByteBuffer)
  {
    return (MethodDescriptorProto)PARSER.parseFrom(paramByteBuffer);
  }
  
  public static MethodDescriptorProto parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (MethodDescriptorProto)PARSER.parseFrom(paramByteBuffer, paramExtensionRegistryLite);
  }
  
  public static MethodDescriptorProto parseFrom(byte[] paramArrayOfByte)
  {
    return (MethodDescriptorProto)PARSER.parseFrom(paramArrayOfByte);
  }
  
  public static MethodDescriptorProto parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (MethodDescriptorProto)PARSER.parseFrom(paramArrayOfByte, paramExtensionRegistryLite);
  }
  
  public static Parser<MethodDescriptorProto> parser()
  {
    return PARSER;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof MethodDescriptorProto)) {
      return super.equals(paramObject);
    }
    paramObject = (MethodDescriptorProto)paramObject;
    if (hasName() != paramObject.hasName()) {
      return false;
    }
    if ((hasName()) && (!getName().equals(paramObject.getName()))) {
      return false;
    }
    if (hasInputType() != paramObject.hasInputType()) {
      return false;
    }
    if ((hasInputType()) && (!getInputType().equals(paramObject.getInputType()))) {
      return false;
    }
    if (hasOutputType() != paramObject.hasOutputType()) {
      return false;
    }
    if ((hasOutputType()) && (!getOutputType().equals(paramObject.getOutputType()))) {
      return false;
    }
    if (hasOptions() != paramObject.hasOptions()) {
      return false;
    }
    if ((hasOptions()) && (!getOptions().equals(paramObject.getOptions()))) {
      return false;
    }
    if (hasClientStreaming() != paramObject.hasClientStreaming()) {
      return false;
    }
    if ((hasClientStreaming()) && (getClientStreaming() != paramObject.getClientStreaming())) {
      return false;
    }
    if (hasServerStreaming() != paramObject.hasServerStreaming()) {
      return false;
    }
    if ((hasServerStreaming()) && (getServerStreaming() != paramObject.getServerStreaming())) {
      return false;
    }
    return this.unknownFields.equals(paramObject.unknownFields);
  }
  
  public boolean getClientStreaming()
  {
    return this.clientStreaming_;
  }
  
  public MethodDescriptorProto getDefaultInstanceForType()
  {
    return a;
  }
  
  public String getInputType()
  {
    Object localObject = this.inputType_;
    if ((localObject instanceof String)) {
      return (String)localObject;
    }
    localObject = (ByteString)localObject;
    String str = ((ByteString)localObject).toStringUtf8();
    if (((ByteString)localObject).isValidUtf8()) {
      this.inputType_ = str;
    }
    return str;
  }
  
  public ByteString getInputTypeBytes()
  {
    Object localObject = this.inputType_;
    if ((localObject instanceof String))
    {
      localObject = ByteString.copyFromUtf8((String)localObject);
      this.inputType_ = localObject;
      return localObject;
    }
    return (ByteString)localObject;
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
  
  public DescriptorProtos.MethodOptions getOptions()
  {
    DescriptorProtos.MethodOptions localMethodOptions2 = this.options_;
    DescriptorProtos.MethodOptions localMethodOptions1 = localMethodOptions2;
    if (localMethodOptions2 == null) {
      localMethodOptions1 = DescriptorProtos.MethodOptions.getDefaultInstance();
    }
    return localMethodOptions1;
  }
  
  public DescriptorProtos.MethodOptionsOrBuilder getOptionsOrBuilder()
  {
    DescriptorProtos.MethodOptions localMethodOptions2 = this.options_;
    DescriptorProtos.MethodOptions localMethodOptions1 = localMethodOptions2;
    if (localMethodOptions2 == null) {
      localMethodOptions1 = DescriptorProtos.MethodOptions.getDefaultInstance();
    }
    return localMethodOptions1;
  }
  
  public String getOutputType()
  {
    Object localObject = this.outputType_;
    if ((localObject instanceof String)) {
      return (String)localObject;
    }
    localObject = (ByteString)localObject;
    String str = ((ByteString)localObject).toStringUtf8();
    if (((ByteString)localObject).isValidUtf8()) {
      this.outputType_ = str;
    }
    return str;
  }
  
  public ByteString getOutputTypeBytes()
  {
    Object localObject = this.outputType_;
    if ((localObject instanceof String))
    {
      localObject = ByteString.copyFromUtf8((String)localObject);
      this.outputType_ = localObject;
      return localObject;
    }
    return (ByteString)localObject;
  }
  
  public Parser<MethodDescriptorProto> getParserForType()
  {
    return PARSER;
  }
  
  public int getSerializedSize()
  {
    int i = this.memoizedSize;
    if (i != -1) {
      return i;
    }
    int j = 0;
    if ((this.bitField0_ & 0x1) != 0) {
      j = 0 + GeneratedMessageV3.computeStringSize(1, this.name_);
    }
    i = j;
    if ((this.bitField0_ & 0x2) != 0) {
      i = j + GeneratedMessageV3.computeStringSize(2, this.inputType_);
    }
    j = i;
    if ((this.bitField0_ & 0x4) != 0) {
      j = i + GeneratedMessageV3.computeStringSize(3, this.outputType_);
    }
    i = j;
    if ((this.bitField0_ & 0x8) != 0) {
      i = j + CodedOutputStream.c(4, getOptions());
    }
    j = i;
    if ((this.bitField0_ & 0x10) != 0) {
      j = i + CodedOutputStream.b(5, this.clientStreaming_);
    }
    i = j;
    if ((this.bitField0_ & 0x20) != 0) {
      i = j + CodedOutputStream.b(6, this.serverStreaming_);
    }
    i += this.unknownFields.getSerializedSize();
    this.memoizedSize = i;
    return i;
  }
  
  public boolean getServerStreaming()
  {
    return this.serverStreaming_;
  }
  
  public final UnknownFieldSet getUnknownFields()
  {
    return this.unknownFields;
  }
  
  public boolean hasClientStreaming()
  {
    return (this.bitField0_ & 0x10) != 0;
  }
  
  public boolean hasInputType()
  {
    return (this.bitField0_ & 0x2) != 0;
  }
  
  public boolean hasName()
  {
    return (this.bitField0_ & 0x1) != 0;
  }
  
  public boolean hasOptions()
  {
    return (this.bitField0_ & 0x8) != 0;
  }
  
  public boolean hasOutputType()
  {
    return (this.bitField0_ & 0x4) != 0;
  }
  
  public boolean hasServerStreaming()
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
    if (hasName()) {
      i = (j * 37 + 1) * 53 + getName().hashCode();
    }
    j = i;
    if (hasInputType()) {
      j = (i * 37 + 2) * 53 + getInputType().hashCode();
    }
    i = j;
    if (hasOutputType()) {
      i = (j * 37 + 3) * 53 + getOutputType().hashCode();
    }
    j = i;
    if (hasOptions()) {
      j = (i * 37 + 4) * 53 + getOptions().hashCode();
    }
    i = j;
    if (hasClientStreaming()) {
      i = (j * 37 + 5) * 53 + Internal.a(getClientStreaming());
    }
    j = i;
    if (hasServerStreaming()) {
      j = (i * 37 + 6) * 53 + Internal.a(getServerStreaming());
    }
    i = j * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    return i;
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return DescriptorProtos.A().a(MethodDescriptorProto.class, DescriptorProtos.MethodDescriptorProto.Builder.class);
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
    if ((hasOptions()) && (!getOptions().isInitialized()))
    {
      this.memoizedIsInitialized = 0;
      return false;
    }
    this.memoizedIsInitialized = 1;
    return true;
  }
  
  public DescriptorProtos.MethodDescriptorProto.Builder newBuilderForType()
  {
    return newBuilder();
  }
  
  protected DescriptorProtos.MethodDescriptorProto.Builder newBuilderForType(GeneratedMessageV3.BuilderParent paramBuilderParent)
  {
    return new DescriptorProtos.MethodDescriptorProto.Builder(paramBuilderParent, null);
  }
  
  protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter paramUnusedPrivateParameter)
  {
    return new MethodDescriptorProto();
  }
  
  public DescriptorProtos.MethodDescriptorProto.Builder toBuilder()
  {
    if (this == a) {
      return new DescriptorProtos.MethodDescriptorProto.Builder(null);
    }
    return new DescriptorProtos.MethodDescriptorProto.Builder(null).a(this);
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
  {
    if ((this.bitField0_ & 0x1) != 0) {
      GeneratedMessageV3.writeString(paramCodedOutputStream, 1, this.name_);
    }
    if ((this.bitField0_ & 0x2) != 0) {
      GeneratedMessageV3.writeString(paramCodedOutputStream, 2, this.inputType_);
    }
    if ((this.bitField0_ & 0x4) != 0) {
      GeneratedMessageV3.writeString(paramCodedOutputStream, 3, this.outputType_);
    }
    if ((this.bitField0_ & 0x8) != 0) {
      paramCodedOutputStream.a(4, getOptions());
    }
    if ((this.bitField0_ & 0x10) != 0) {
      paramCodedOutputStream.a(5, this.clientStreaming_);
    }
    if ((this.bitField0_ & 0x20) != 0) {
      paramCodedOutputStream.a(6, this.serverStreaming_);
    }
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.DescriptorProtos.MethodDescriptorProto
 * JD-Core Version:    0.7.0.1
 */