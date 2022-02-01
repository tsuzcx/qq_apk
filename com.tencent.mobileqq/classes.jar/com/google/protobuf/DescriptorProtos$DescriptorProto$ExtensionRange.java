package com.google.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;

public final class DescriptorProtos$DescriptorProto$ExtensionRange
  extends GeneratedMessageV3
  implements DescriptorProtos.DescriptorProto.ExtensionRangeOrBuilder
{
  public static final int END_FIELD_NUMBER = 2;
  public static final int OPTIONS_FIELD_NUMBER = 3;
  @Deprecated
  public static final Parser<ExtensionRange> PARSER = new DescriptorProtos.DescriptorProto.ExtensionRange.1();
  public static final int START_FIELD_NUMBER = 1;
  private static final ExtensionRange a = new ExtensionRange();
  private static final long serialVersionUID = 0L;
  private int bitField0_;
  private int end_;
  private byte memoizedIsInitialized = -1;
  private DescriptorProtos.ExtensionRangeOptions options_;
  private int start_;
  
  private DescriptorProtos$DescriptorProto$ExtensionRange() {}
  
  /* Error */
  private DescriptorProtos$DescriptorProto$ExtensionRange(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 35	com/google/protobuf/DescriptorProtos$DescriptorProto$ExtensionRange:<init>	()V
    //   4: aload_2
    //   5: ifnull +236 -> 241
    //   8: invokestatic 56	com/google/protobuf/UnknownFieldSet:a	()Lcom/google/protobuf/UnknownFieldSet$Builder;
    //   11: astore 6
    //   13: iconst_0
    //   14: istore_3
    //   15: iload_3
    //   16: ifne +211 -> 227
    //   19: aload_1
    //   20: invokevirtual 61	com/google/protobuf/CodedInputStream:a	()I
    //   23: istore 4
    //   25: iload 4
    //   27: ifeq +155 -> 182
    //   30: iload 4
    //   32: bipush 8
    //   34: if_icmpeq +127 -> 161
    //   37: iload 4
    //   39: bipush 16
    //   41: if_icmpeq +99 -> 140
    //   44: iload 4
    //   46: bipush 26
    //   48: if_icmpeq +19 -> 67
    //   51: aload_0
    //   52: aload_1
    //   53: aload 6
    //   55: aload_2
    //   56: iload 4
    //   58: invokevirtual 65	com/google/protobuf/DescriptorProtos$DescriptorProto$ExtensionRange:parseUnknownField	(Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/UnknownFieldSet$Builder;Lcom/google/protobuf/ExtensionRegistryLite;I)Z
    //   61: ifne -46 -> 15
    //   64: goto +118 -> 182
    //   67: aconst_null
    //   68: astore 5
    //   70: aload_0
    //   71: getfield 67	com/google/protobuf/DescriptorProtos$DescriptorProto$ExtensionRange:bitField0_	I
    //   74: iconst_4
    //   75: iand
    //   76: ifeq +12 -> 88
    //   79: aload_0
    //   80: getfield 69	com/google/protobuf/DescriptorProtos$DescriptorProto$ExtensionRange:options_	Lcom/google/protobuf/DescriptorProtos$ExtensionRangeOptions;
    //   83: invokevirtual 75	com/google/protobuf/DescriptorProtos$ExtensionRangeOptions:toBuilder	()Lcom/google/protobuf/DescriptorProtos$ExtensionRangeOptions$Builder;
    //   86: astore 5
    //   88: aload_0
    //   89: aload_1
    //   90: getstatic 76	com/google/protobuf/DescriptorProtos$ExtensionRangeOptions:PARSER	Lcom/google/protobuf/Parser;
    //   93: aload_2
    //   94: invokevirtual 79	com/google/protobuf/CodedInputStream:a	(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   97: checkcast 71	com/google/protobuf/DescriptorProtos$ExtensionRangeOptions
    //   100: putfield 69	com/google/protobuf/DescriptorProtos$DescriptorProto$ExtensionRange:options_	Lcom/google/protobuf/DescriptorProtos$ExtensionRangeOptions;
    //   103: aload 5
    //   105: ifnull +22 -> 127
    //   108: aload 5
    //   110: aload_0
    //   111: getfield 69	com/google/protobuf/DescriptorProtos$DescriptorProto$ExtensionRange:options_	Lcom/google/protobuf/DescriptorProtos$ExtensionRangeOptions;
    //   114: invokevirtual 84	com/google/protobuf/DescriptorProtos$ExtensionRangeOptions$Builder:a	(Lcom/google/protobuf/DescriptorProtos$ExtensionRangeOptions;)Lcom/google/protobuf/DescriptorProtos$ExtensionRangeOptions$Builder;
    //   117: pop
    //   118: aload_0
    //   119: aload 5
    //   121: invokevirtual 88	com/google/protobuf/DescriptorProtos$ExtensionRangeOptions$Builder:d	()Lcom/google/protobuf/DescriptorProtos$ExtensionRangeOptions;
    //   124: putfield 69	com/google/protobuf/DescriptorProtos$DescriptorProto$ExtensionRange:options_	Lcom/google/protobuf/DescriptorProtos$ExtensionRangeOptions;
    //   127: aload_0
    //   128: aload_0
    //   129: getfield 67	com/google/protobuf/DescriptorProtos$DescriptorProto$ExtensionRange:bitField0_	I
    //   132: iconst_4
    //   133: ior
    //   134: putfield 67	com/google/protobuf/DescriptorProtos$DescriptorProto$ExtensionRange:bitField0_	I
    //   137: goto -122 -> 15
    //   140: aload_0
    //   141: aload_0
    //   142: getfield 67	com/google/protobuf/DescriptorProtos$DescriptorProto$ExtensionRange:bitField0_	I
    //   145: iconst_2
    //   146: ior
    //   147: putfield 67	com/google/protobuf/DescriptorProtos$DescriptorProto$ExtensionRange:bitField0_	I
    //   150: aload_0
    //   151: aload_1
    //   152: invokevirtual 91	com/google/protobuf/CodedInputStream:f	()I
    //   155: putfield 93	com/google/protobuf/DescriptorProtos$DescriptorProto$ExtensionRange:end_	I
    //   158: goto -143 -> 15
    //   161: aload_0
    //   162: aload_0
    //   163: getfield 67	com/google/protobuf/DescriptorProtos$DescriptorProto$ExtensionRange:bitField0_	I
    //   166: iconst_1
    //   167: ior
    //   168: putfield 67	com/google/protobuf/DescriptorProtos$DescriptorProto$ExtensionRange:bitField0_	I
    //   171: aload_0
    //   172: aload_1
    //   173: invokevirtual 91	com/google/protobuf/CodedInputStream:f	()I
    //   176: putfield 95	com/google/protobuf/DescriptorProtos$DescriptorProto$ExtensionRange:start_	I
    //   179: goto -164 -> 15
    //   182: iconst_1
    //   183: istore_3
    //   184: goto -169 -> 15
    //   187: astore_1
    //   188: goto +24 -> 212
    //   191: astore_1
    //   192: new 49	com/google/protobuf/InvalidProtocolBufferException
    //   195: dup
    //   196: aload_1
    //   197: invokespecial 98	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/io/IOException;)V
    //   200: aload_0
    //   201: invokevirtual 102	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   204: athrow
    //   205: astore_1
    //   206: aload_1
    //   207: aload_0
    //   208: invokevirtual 102	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   211: athrow
    //   212: aload_0
    //   213: aload 6
    //   215: invokevirtual 107	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   218: putfield 111	com/google/protobuf/DescriptorProtos$DescriptorProto$ExtensionRange:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   221: aload_0
    //   222: invokevirtual 114	com/google/protobuf/DescriptorProtos$DescriptorProto$ExtensionRange:makeExtensionsImmutable	()V
    //   225: aload_1
    //   226: athrow
    //   227: aload_0
    //   228: aload 6
    //   230: invokevirtual 107	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   233: putfield 111	com/google/protobuf/DescriptorProtos$DescriptorProto$ExtensionRange:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   236: aload_0
    //   237: invokevirtual 114	com/google/protobuf/DescriptorProtos$DescriptorProto$ExtensionRange:makeExtensionsImmutable	()V
    //   240: return
    //   241: new 116	java/lang/NullPointerException
    //   244: dup
    //   245: invokespecial 117	java/lang/NullPointerException:<init>	()V
    //   248: astore_1
    //   249: goto +5 -> 254
    //   252: aload_1
    //   253: athrow
    //   254: goto -2 -> 252
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	257	0	this	ExtensionRange
    //   0	257	1	paramCodedInputStream	CodedInputStream
    //   0	257	2	paramExtensionRegistryLite	ExtensionRegistryLite
    //   14	170	3	i	int
    //   23	34	4	j	int
    //   68	52	5	localBuilder	DescriptorProtos.ExtensionRangeOptions.Builder
    //   11	218	6	localBuilder1	UnknownFieldSet.Builder
    // Exception table:
    //   from	to	target	type
    //   19	25	187	finally
    //   51	64	187	finally
    //   70	88	187	finally
    //   88	103	187	finally
    //   108	127	187	finally
    //   127	137	187	finally
    //   140	158	187	finally
    //   161	179	187	finally
    //   192	205	187	finally
    //   206	212	187	finally
    //   19	25	191	java/io/IOException
    //   51	64	191	java/io/IOException
    //   70	88	191	java/io/IOException
    //   88	103	191	java/io/IOException
    //   108	127	191	java/io/IOException
    //   127	137	191	java/io/IOException
    //   140	158	191	java/io/IOException
    //   161	179	191	java/io/IOException
    //   19	25	205	com/google/protobuf/InvalidProtocolBufferException
    //   51	64	205	com/google/protobuf/InvalidProtocolBufferException
    //   70	88	205	com/google/protobuf/InvalidProtocolBufferException
    //   88	103	205	com/google/protobuf/InvalidProtocolBufferException
    //   108	127	205	com/google/protobuf/InvalidProtocolBufferException
    //   127	137	205	com/google/protobuf/InvalidProtocolBufferException
    //   140	158	205	com/google/protobuf/InvalidProtocolBufferException
    //   161	179	205	com/google/protobuf/InvalidProtocolBufferException
  }
  
  private DescriptorProtos$DescriptorProto$ExtensionRange(GeneratedMessageV3.Builder<?> paramBuilder)
  {
    super(paramBuilder);
  }
  
  public static ExtensionRange getDefaultInstance()
  {
    return a;
  }
  
  public static final Descriptors.Descriptor getDescriptor()
  {
    return DescriptorProtos.h();
  }
  
  public static DescriptorProtos.DescriptorProto.ExtensionRange.Builder newBuilder()
  {
    return a.toBuilder();
  }
  
  public static DescriptorProtos.DescriptorProto.ExtensionRange.Builder newBuilder(ExtensionRange paramExtensionRange)
  {
    return a.toBuilder().a(paramExtensionRange);
  }
  
  public static ExtensionRange parseDelimitedFrom(InputStream paramInputStream)
  {
    return (ExtensionRange)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream);
  }
  
  public static ExtensionRange parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (ExtensionRange)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static ExtensionRange parseFrom(ByteString paramByteString)
  {
    return (ExtensionRange)PARSER.parseFrom(paramByteString);
  }
  
  public static ExtensionRange parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (ExtensionRange)PARSER.parseFrom(paramByteString, paramExtensionRegistryLite);
  }
  
  public static ExtensionRange parseFrom(CodedInputStream paramCodedInputStream)
  {
    return (ExtensionRange)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream);
  }
  
  public static ExtensionRange parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (ExtensionRange)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static ExtensionRange parseFrom(InputStream paramInputStream)
  {
    return (ExtensionRange)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream);
  }
  
  public static ExtensionRange parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (ExtensionRange)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static ExtensionRange parseFrom(ByteBuffer paramByteBuffer)
  {
    return (ExtensionRange)PARSER.parseFrom(paramByteBuffer);
  }
  
  public static ExtensionRange parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (ExtensionRange)PARSER.parseFrom(paramByteBuffer, paramExtensionRegistryLite);
  }
  
  public static ExtensionRange parseFrom(byte[] paramArrayOfByte)
  {
    return (ExtensionRange)PARSER.parseFrom(paramArrayOfByte);
  }
  
  public static ExtensionRange parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (ExtensionRange)PARSER.parseFrom(paramArrayOfByte, paramExtensionRegistryLite);
  }
  
  public static Parser<ExtensionRange> parser()
  {
    return PARSER;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof ExtensionRange)) {
      return super.equals(paramObject);
    }
    paramObject = (ExtensionRange)paramObject;
    if (hasStart() != paramObject.hasStart()) {
      return false;
    }
    if ((hasStart()) && (getStart() != paramObject.getStart())) {
      return false;
    }
    if (hasEnd() != paramObject.hasEnd()) {
      return false;
    }
    if ((hasEnd()) && (getEnd() != paramObject.getEnd())) {
      return false;
    }
    if (hasOptions() != paramObject.hasOptions()) {
      return false;
    }
    if ((hasOptions()) && (!getOptions().equals(paramObject.getOptions()))) {
      return false;
    }
    return this.unknownFields.equals(paramObject.unknownFields);
  }
  
  public ExtensionRange getDefaultInstanceForType()
  {
    return a;
  }
  
  public int getEnd()
  {
    return this.end_;
  }
  
  public DescriptorProtos.ExtensionRangeOptions getOptions()
  {
    DescriptorProtos.ExtensionRangeOptions localExtensionRangeOptions2 = this.options_;
    DescriptorProtos.ExtensionRangeOptions localExtensionRangeOptions1 = localExtensionRangeOptions2;
    if (localExtensionRangeOptions2 == null) {
      localExtensionRangeOptions1 = DescriptorProtos.ExtensionRangeOptions.getDefaultInstance();
    }
    return localExtensionRangeOptions1;
  }
  
  public DescriptorProtos.ExtensionRangeOptionsOrBuilder getOptionsOrBuilder()
  {
    DescriptorProtos.ExtensionRangeOptions localExtensionRangeOptions2 = this.options_;
    DescriptorProtos.ExtensionRangeOptions localExtensionRangeOptions1 = localExtensionRangeOptions2;
    if (localExtensionRangeOptions2 == null) {
      localExtensionRangeOptions1 = DescriptorProtos.ExtensionRangeOptions.getDefaultInstance();
    }
    return localExtensionRangeOptions1;
  }
  
  public Parser<ExtensionRange> getParserForType()
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
      j = 0 + CodedOutputStream.h(1, this.start_);
    }
    i = j;
    if ((this.bitField0_ & 0x2) != 0) {
      i = j + CodedOutputStream.h(2, this.end_);
    }
    j = i;
    if ((this.bitField0_ & 0x4) != 0) {
      j = i + CodedOutputStream.c(3, getOptions());
    }
    i = j + this.unknownFields.getSerializedSize();
    this.memoizedSize = i;
    return i;
  }
  
  public int getStart()
  {
    return this.start_;
  }
  
  public final UnknownFieldSet getUnknownFields()
  {
    return this.unknownFields;
  }
  
  public boolean hasEnd()
  {
    return (this.bitField0_ & 0x2) != 0;
  }
  
  public boolean hasOptions()
  {
    return (this.bitField0_ & 0x4) != 0;
  }
  
  public boolean hasStart()
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
    if (hasStart()) {
      i = (j * 37 + 1) * 53 + getStart();
    }
    j = i;
    if (hasEnd()) {
      j = (i * 37 + 2) * 53 + getEnd();
    }
    i = j;
    if (hasOptions()) {
      i = (j * 37 + 3) * 53 + getOptions().hashCode();
    }
    i = i * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    return i;
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return DescriptorProtos.i().a(ExtensionRange.class, DescriptorProtos.DescriptorProto.ExtensionRange.Builder.class);
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
  
  public DescriptorProtos.DescriptorProto.ExtensionRange.Builder newBuilderForType()
  {
    return newBuilder();
  }
  
  protected DescriptorProtos.DescriptorProto.ExtensionRange.Builder newBuilderForType(GeneratedMessageV3.BuilderParent paramBuilderParent)
  {
    return new DescriptorProtos.DescriptorProto.ExtensionRange.Builder(paramBuilderParent, null);
  }
  
  protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter paramUnusedPrivateParameter)
  {
    return new ExtensionRange();
  }
  
  public DescriptorProtos.DescriptorProto.ExtensionRange.Builder toBuilder()
  {
    if (this == a) {
      return new DescriptorProtos.DescriptorProto.ExtensionRange.Builder(null);
    }
    return new DescriptorProtos.DescriptorProto.ExtensionRange.Builder(null).a(this);
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
  {
    if ((this.bitField0_ & 0x1) != 0) {
      paramCodedOutputStream.b(1, this.start_);
    }
    if ((this.bitField0_ & 0x2) != 0) {
      paramCodedOutputStream.b(2, this.end_);
    }
    if ((this.bitField0_ & 0x4) != 0) {
      paramCodedOutputStream.a(3, getOptions());
    }
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.DescriptorProtos.DescriptorProto.ExtensionRange
 * JD-Core Version:    0.7.0.1
 */