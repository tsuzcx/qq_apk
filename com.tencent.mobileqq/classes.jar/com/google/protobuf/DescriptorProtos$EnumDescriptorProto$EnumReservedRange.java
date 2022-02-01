package com.google.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;

public final class DescriptorProtos$EnumDescriptorProto$EnumReservedRange
  extends GeneratedMessageV3
  implements DescriptorProtos.EnumDescriptorProto.EnumReservedRangeOrBuilder
{
  public static final int END_FIELD_NUMBER = 2;
  @Deprecated
  public static final Parser<EnumReservedRange> PARSER = new DescriptorProtos.EnumDescriptorProto.EnumReservedRange.1();
  public static final int START_FIELD_NUMBER = 1;
  private static final EnumReservedRange a = new EnumReservedRange();
  private static final long serialVersionUID = 0L;
  private int bitField0_;
  private int end_;
  private byte memoizedIsInitialized = -1;
  private int start_;
  
  private DescriptorProtos$EnumDescriptorProto$EnumReservedRange() {}
  
  /* Error */
  private DescriptorProtos$EnumDescriptorProto$EnumReservedRange(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 31	com/google/protobuf/DescriptorProtos$EnumDescriptorProto$EnumReservedRange:<init>	()V
    //   4: aload_2
    //   5: ifnull +156 -> 161
    //   8: invokestatic 52	com/google/protobuf/UnknownFieldSet:a	()Lcom/google/protobuf/UnknownFieldSet$Builder;
    //   11: astore 5
    //   13: iconst_0
    //   14: istore_3
    //   15: iload_3
    //   16: ifne +131 -> 147
    //   19: aload_1
    //   20: invokevirtual 57	com/google/protobuf/CodedInputStream:a	()I
    //   23: istore 4
    //   25: iload 4
    //   27: ifeq +75 -> 102
    //   30: iload 4
    //   32: bipush 8
    //   34: if_icmpeq +47 -> 81
    //   37: iload 4
    //   39: bipush 16
    //   41: if_icmpeq +19 -> 60
    //   44: aload_0
    //   45: aload_1
    //   46: aload 5
    //   48: aload_2
    //   49: iload 4
    //   51: invokevirtual 61	com/google/protobuf/DescriptorProtos$EnumDescriptorProto$EnumReservedRange:parseUnknownField	(Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/UnknownFieldSet$Builder;Lcom/google/protobuf/ExtensionRegistryLite;I)Z
    //   54: ifne -39 -> 15
    //   57: goto +45 -> 102
    //   60: aload_0
    //   61: aload_0
    //   62: getfield 63	com/google/protobuf/DescriptorProtos$EnumDescriptorProto$EnumReservedRange:bitField0_	I
    //   65: iconst_2
    //   66: ior
    //   67: putfield 63	com/google/protobuf/DescriptorProtos$EnumDescriptorProto$EnumReservedRange:bitField0_	I
    //   70: aload_0
    //   71: aload_1
    //   72: invokevirtual 66	com/google/protobuf/CodedInputStream:f	()I
    //   75: putfield 68	com/google/protobuf/DescriptorProtos$EnumDescriptorProto$EnumReservedRange:end_	I
    //   78: goto -63 -> 15
    //   81: aload_0
    //   82: aload_0
    //   83: getfield 63	com/google/protobuf/DescriptorProtos$EnumDescriptorProto$EnumReservedRange:bitField0_	I
    //   86: iconst_1
    //   87: ior
    //   88: putfield 63	com/google/protobuf/DescriptorProtos$EnumDescriptorProto$EnumReservedRange:bitField0_	I
    //   91: aload_0
    //   92: aload_1
    //   93: invokevirtual 66	com/google/protobuf/CodedInputStream:f	()I
    //   96: putfield 70	com/google/protobuf/DescriptorProtos$EnumDescriptorProto$EnumReservedRange:start_	I
    //   99: goto -84 -> 15
    //   102: iconst_1
    //   103: istore_3
    //   104: goto -89 -> 15
    //   107: astore_1
    //   108: goto +24 -> 132
    //   111: astore_1
    //   112: new 45	com/google/protobuf/InvalidProtocolBufferException
    //   115: dup
    //   116: aload_1
    //   117: invokespecial 73	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/io/IOException;)V
    //   120: aload_0
    //   121: invokevirtual 77	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   124: athrow
    //   125: astore_1
    //   126: aload_1
    //   127: aload_0
    //   128: invokevirtual 77	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   131: athrow
    //   132: aload_0
    //   133: aload 5
    //   135: invokevirtual 82	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   138: putfield 86	com/google/protobuf/DescriptorProtos$EnumDescriptorProto$EnumReservedRange:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   141: aload_0
    //   142: invokevirtual 89	com/google/protobuf/DescriptorProtos$EnumDescriptorProto$EnumReservedRange:makeExtensionsImmutable	()V
    //   145: aload_1
    //   146: athrow
    //   147: aload_0
    //   148: aload 5
    //   150: invokevirtual 82	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   153: putfield 86	com/google/protobuf/DescriptorProtos$EnumDescriptorProto$EnumReservedRange:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   156: aload_0
    //   157: invokevirtual 89	com/google/protobuf/DescriptorProtos$EnumDescriptorProto$EnumReservedRange:makeExtensionsImmutable	()V
    //   160: return
    //   161: new 91	java/lang/NullPointerException
    //   164: dup
    //   165: invokespecial 92	java/lang/NullPointerException:<init>	()V
    //   168: astore_1
    //   169: goto +5 -> 174
    //   172: aload_1
    //   173: athrow
    //   174: goto -2 -> 172
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	177	0	this	EnumReservedRange
    //   0	177	1	paramCodedInputStream	CodedInputStream
    //   0	177	2	paramExtensionRegistryLite	ExtensionRegistryLite
    //   14	90	3	i	int
    //   23	27	4	j	int
    //   11	138	5	localBuilder	UnknownFieldSet.Builder
    // Exception table:
    //   from	to	target	type
    //   19	25	107	finally
    //   44	57	107	finally
    //   60	78	107	finally
    //   81	99	107	finally
    //   112	125	107	finally
    //   126	132	107	finally
    //   19	25	111	java/io/IOException
    //   44	57	111	java/io/IOException
    //   60	78	111	java/io/IOException
    //   81	99	111	java/io/IOException
    //   19	25	125	com/google/protobuf/InvalidProtocolBufferException
    //   44	57	125	com/google/protobuf/InvalidProtocolBufferException
    //   60	78	125	com/google/protobuf/InvalidProtocolBufferException
    //   81	99	125	com/google/protobuf/InvalidProtocolBufferException
  }
  
  private DescriptorProtos$EnumDescriptorProto$EnumReservedRange(GeneratedMessageV3.Builder<?> paramBuilder)
  {
    super(paramBuilder);
  }
  
  public static EnumReservedRange getDefaultInstance()
  {
    return a;
  }
  
  public static final Descriptors.Descriptor getDescriptor()
  {
    return DescriptorProtos.t();
  }
  
  public static DescriptorProtos.EnumDescriptorProto.EnumReservedRange.Builder newBuilder()
  {
    return a.toBuilder();
  }
  
  public static DescriptorProtos.EnumDescriptorProto.EnumReservedRange.Builder newBuilder(EnumReservedRange paramEnumReservedRange)
  {
    return a.toBuilder().a(paramEnumReservedRange);
  }
  
  public static EnumReservedRange parseDelimitedFrom(InputStream paramInputStream)
  {
    return (EnumReservedRange)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream);
  }
  
  public static EnumReservedRange parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (EnumReservedRange)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static EnumReservedRange parseFrom(ByteString paramByteString)
  {
    return (EnumReservedRange)PARSER.parseFrom(paramByteString);
  }
  
  public static EnumReservedRange parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (EnumReservedRange)PARSER.parseFrom(paramByteString, paramExtensionRegistryLite);
  }
  
  public static EnumReservedRange parseFrom(CodedInputStream paramCodedInputStream)
  {
    return (EnumReservedRange)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream);
  }
  
  public static EnumReservedRange parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (EnumReservedRange)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static EnumReservedRange parseFrom(InputStream paramInputStream)
  {
    return (EnumReservedRange)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream);
  }
  
  public static EnumReservedRange parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (EnumReservedRange)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static EnumReservedRange parseFrom(ByteBuffer paramByteBuffer)
  {
    return (EnumReservedRange)PARSER.parseFrom(paramByteBuffer);
  }
  
  public static EnumReservedRange parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (EnumReservedRange)PARSER.parseFrom(paramByteBuffer, paramExtensionRegistryLite);
  }
  
  public static EnumReservedRange parseFrom(byte[] paramArrayOfByte)
  {
    return (EnumReservedRange)PARSER.parseFrom(paramArrayOfByte);
  }
  
  public static EnumReservedRange parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (EnumReservedRange)PARSER.parseFrom(paramArrayOfByte, paramExtensionRegistryLite);
  }
  
  public static Parser<EnumReservedRange> parser()
  {
    return PARSER;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof EnumReservedRange)) {
      return super.equals(paramObject);
    }
    paramObject = (EnumReservedRange)paramObject;
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
    return this.unknownFields.equals(paramObject.unknownFields);
  }
  
  public EnumReservedRange getDefaultInstanceForType()
  {
    return a;
  }
  
  public int getEnd()
  {
    return this.end_;
  }
  
  public Parser<EnumReservedRange> getParserForType()
  {
    return PARSER;
  }
  
  public int getSerializedSize()
  {
    int i = this.memoizedSize;
    if (i != -1) {
      return i;
    }
    i = 0;
    if ((this.bitField0_ & 0x1) != 0) {
      i = 0 + CodedOutputStream.h(1, this.start_);
    }
    int j = i;
    if ((this.bitField0_ & 0x2) != 0) {
      j = i + CodedOutputStream.h(2, this.end_);
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
    i = j * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    return i;
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return DescriptorProtos.u().a(EnumReservedRange.class, DescriptorProtos.EnumDescriptorProto.EnumReservedRange.Builder.class);
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
  
  public DescriptorProtos.EnumDescriptorProto.EnumReservedRange.Builder newBuilderForType()
  {
    return newBuilder();
  }
  
  protected DescriptorProtos.EnumDescriptorProto.EnumReservedRange.Builder newBuilderForType(GeneratedMessageV3.BuilderParent paramBuilderParent)
  {
    return new DescriptorProtos.EnumDescriptorProto.EnumReservedRange.Builder(paramBuilderParent, null);
  }
  
  protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter paramUnusedPrivateParameter)
  {
    return new EnumReservedRange();
  }
  
  public DescriptorProtos.EnumDescriptorProto.EnumReservedRange.Builder toBuilder()
  {
    if (this == a) {
      return new DescriptorProtos.EnumDescriptorProto.EnumReservedRange.Builder(null);
    }
    return new DescriptorProtos.EnumDescriptorProto.EnumReservedRange.Builder(null).a(this);
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
  {
    if ((this.bitField0_ & 0x1) != 0) {
      paramCodedOutputStream.b(1, this.start_);
    }
    if ((this.bitField0_ & 0x2) != 0) {
      paramCodedOutputStream.b(2, this.end_);
    }
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.DescriptorProtos.EnumDescriptorProto.EnumReservedRange
 * JD-Core Version:    0.7.0.1
 */