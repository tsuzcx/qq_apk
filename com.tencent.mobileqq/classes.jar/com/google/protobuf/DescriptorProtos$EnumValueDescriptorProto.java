package com.google.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;

public final class DescriptorProtos$EnumValueDescriptorProto
  extends GeneratedMessageV3
  implements DescriptorProtos.EnumValueDescriptorProtoOrBuilder
{
  public static final int NAME_FIELD_NUMBER = 1;
  public static final int NUMBER_FIELD_NUMBER = 2;
  public static final int OPTIONS_FIELD_NUMBER = 3;
  @Deprecated
  public static final Parser<EnumValueDescriptorProto> PARSER = new DescriptorProtos.EnumValueDescriptorProto.1();
  private static final EnumValueDescriptorProto a = new EnumValueDescriptorProto();
  private static final long serialVersionUID = 0L;
  private int bitField0_;
  private byte memoizedIsInitialized = -1;
  private volatile Object name_;
  private int number_;
  private DescriptorProtos.EnumValueOptions options_;
  
  private DescriptorProtos$EnumValueDescriptorProto()
  {
    this.name_ = "";
  }
  
  /* Error */
  private DescriptorProtos$EnumValueDescriptorProto(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 36	com/google/protobuf/DescriptorProtos$EnumValueDescriptorProto:<init>	()V
    //   4: aload_2
    //   5: ifnull +240 -> 245
    //   8: invokestatic 61	com/google/protobuf/UnknownFieldSet:a	()Lcom/google/protobuf/UnknownFieldSet$Builder;
    //   11: astore 6
    //   13: iconst_0
    //   14: istore_3
    //   15: iload_3
    //   16: ifne +215 -> 231
    //   19: aload_1
    //   20: invokevirtual 66	com/google/protobuf/CodedInputStream:a	()I
    //   23: istore 4
    //   25: iload 4
    //   27: ifeq +159 -> 186
    //   30: iload 4
    //   32: bipush 10
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
    //   58: invokevirtual 70	com/google/protobuf/DescriptorProtos$EnumValueDescriptorProto:parseUnknownField	(Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/UnknownFieldSet$Builder;Lcom/google/protobuf/ExtensionRegistryLite;I)Z
    //   61: ifne -46 -> 15
    //   64: goto +122 -> 186
    //   67: aconst_null
    //   68: astore 5
    //   70: aload_0
    //   71: getfield 72	com/google/protobuf/DescriptorProtos$EnumValueDescriptorProto:bitField0_	I
    //   74: iconst_4
    //   75: iand
    //   76: ifeq +12 -> 88
    //   79: aload_0
    //   80: getfield 74	com/google/protobuf/DescriptorProtos$EnumValueDescriptorProto:options_	Lcom/google/protobuf/DescriptorProtos$EnumValueOptions;
    //   83: invokevirtual 80	com/google/protobuf/DescriptorProtos$EnumValueOptions:toBuilder	()Lcom/google/protobuf/DescriptorProtos$EnumValueOptions$Builder;
    //   86: astore 5
    //   88: aload_0
    //   89: aload_1
    //   90: getstatic 81	com/google/protobuf/DescriptorProtos$EnumValueOptions:PARSER	Lcom/google/protobuf/Parser;
    //   93: aload_2
    //   94: invokevirtual 84	com/google/protobuf/CodedInputStream:a	(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   97: checkcast 76	com/google/protobuf/DescriptorProtos$EnumValueOptions
    //   100: putfield 74	com/google/protobuf/DescriptorProtos$EnumValueDescriptorProto:options_	Lcom/google/protobuf/DescriptorProtos$EnumValueOptions;
    //   103: aload 5
    //   105: ifnull +22 -> 127
    //   108: aload 5
    //   110: aload_0
    //   111: getfield 74	com/google/protobuf/DescriptorProtos$EnumValueDescriptorProto:options_	Lcom/google/protobuf/DescriptorProtos$EnumValueOptions;
    //   114: invokevirtual 89	com/google/protobuf/DescriptorProtos$EnumValueOptions$Builder:a	(Lcom/google/protobuf/DescriptorProtos$EnumValueOptions;)Lcom/google/protobuf/DescriptorProtos$EnumValueOptions$Builder;
    //   117: pop
    //   118: aload_0
    //   119: aload 5
    //   121: invokevirtual 93	com/google/protobuf/DescriptorProtos$EnumValueOptions$Builder:d	()Lcom/google/protobuf/DescriptorProtos$EnumValueOptions;
    //   124: putfield 74	com/google/protobuf/DescriptorProtos$EnumValueDescriptorProto:options_	Lcom/google/protobuf/DescriptorProtos$EnumValueOptions;
    //   127: aload_0
    //   128: aload_0
    //   129: getfield 72	com/google/protobuf/DescriptorProtos$EnumValueDescriptorProto:bitField0_	I
    //   132: iconst_4
    //   133: ior
    //   134: putfield 72	com/google/protobuf/DescriptorProtos$EnumValueDescriptorProto:bitField0_	I
    //   137: goto -122 -> 15
    //   140: aload_0
    //   141: aload_0
    //   142: getfield 72	com/google/protobuf/DescriptorProtos$EnumValueDescriptorProto:bitField0_	I
    //   145: iconst_2
    //   146: ior
    //   147: putfield 72	com/google/protobuf/DescriptorProtos$EnumValueDescriptorProto:bitField0_	I
    //   150: aload_0
    //   151: aload_1
    //   152: invokevirtual 96	com/google/protobuf/CodedInputStream:f	()I
    //   155: putfield 98	com/google/protobuf/DescriptorProtos$EnumValueDescriptorProto:number_	I
    //   158: goto -143 -> 15
    //   161: aload_1
    //   162: invokevirtual 102	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   165: astore 5
    //   167: aload_0
    //   168: iconst_1
    //   169: aload_0
    //   170: getfield 72	com/google/protobuf/DescriptorProtos$EnumValueDescriptorProto:bitField0_	I
    //   173: ior
    //   174: putfield 72	com/google/protobuf/DescriptorProtos$EnumValueDescriptorProto:bitField0_	I
    //   177: aload_0
    //   178: aload 5
    //   180: putfield 51	com/google/protobuf/DescriptorProtos$EnumValueDescriptorProto:name_	Ljava/lang/Object;
    //   183: goto -168 -> 15
    //   186: iconst_1
    //   187: istore_3
    //   188: goto -173 -> 15
    //   191: astore_1
    //   192: goto +24 -> 216
    //   195: astore_1
    //   196: new 54	com/google/protobuf/InvalidProtocolBufferException
    //   199: dup
    //   200: aload_1
    //   201: invokespecial 105	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/io/IOException;)V
    //   204: aload_0
    //   205: invokevirtual 109	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   208: athrow
    //   209: astore_1
    //   210: aload_1
    //   211: aload_0
    //   212: invokevirtual 109	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   215: athrow
    //   216: aload_0
    //   217: aload 6
    //   219: invokevirtual 114	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   222: putfield 118	com/google/protobuf/DescriptorProtos$EnumValueDescriptorProto:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   225: aload_0
    //   226: invokevirtual 121	com/google/protobuf/DescriptorProtos$EnumValueDescriptorProto:makeExtensionsImmutable	()V
    //   229: aload_1
    //   230: athrow
    //   231: aload_0
    //   232: aload 6
    //   234: invokevirtual 114	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   237: putfield 118	com/google/protobuf/DescriptorProtos$EnumValueDescriptorProto:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   240: aload_0
    //   241: invokevirtual 121	com/google/protobuf/DescriptorProtos$EnumValueDescriptorProto:makeExtensionsImmutable	()V
    //   244: return
    //   245: new 123	java/lang/NullPointerException
    //   248: dup
    //   249: invokespecial 124	java/lang/NullPointerException:<init>	()V
    //   252: astore_1
    //   253: goto +5 -> 258
    //   256: aload_1
    //   257: athrow
    //   258: goto -2 -> 256
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	261	0	this	EnumValueDescriptorProto
    //   0	261	1	paramCodedInputStream	CodedInputStream
    //   0	261	2	paramExtensionRegistryLite	ExtensionRegistryLite
    //   14	174	3	i	int
    //   23	34	4	j	int
    //   68	111	5	localObject	Object
    //   11	222	6	localBuilder	UnknownFieldSet.Builder
    // Exception table:
    //   from	to	target	type
    //   19	25	191	finally
    //   51	64	191	finally
    //   70	88	191	finally
    //   88	103	191	finally
    //   108	127	191	finally
    //   127	137	191	finally
    //   140	158	191	finally
    //   161	183	191	finally
    //   196	209	191	finally
    //   210	216	191	finally
    //   19	25	195	java/io/IOException
    //   51	64	195	java/io/IOException
    //   70	88	195	java/io/IOException
    //   88	103	195	java/io/IOException
    //   108	127	195	java/io/IOException
    //   127	137	195	java/io/IOException
    //   140	158	195	java/io/IOException
    //   161	183	195	java/io/IOException
    //   19	25	209	com/google/protobuf/InvalidProtocolBufferException
    //   51	64	209	com/google/protobuf/InvalidProtocolBufferException
    //   70	88	209	com/google/protobuf/InvalidProtocolBufferException
    //   88	103	209	com/google/protobuf/InvalidProtocolBufferException
    //   108	127	209	com/google/protobuf/InvalidProtocolBufferException
    //   127	137	209	com/google/protobuf/InvalidProtocolBufferException
    //   140	158	209	com/google/protobuf/InvalidProtocolBufferException
    //   161	183	209	com/google/protobuf/InvalidProtocolBufferException
  }
  
  private DescriptorProtos$EnumValueDescriptorProto(GeneratedMessageV3.Builder<?> paramBuilder)
  {
    super(paramBuilder);
  }
  
  public static EnumValueDescriptorProto getDefaultInstance()
  {
    return a;
  }
  
  public static final Descriptors.Descriptor getDescriptor()
  {
    return DescriptorProtos.v();
  }
  
  public static DescriptorProtos.EnumValueDescriptorProto.Builder newBuilder()
  {
    return a.toBuilder();
  }
  
  public static DescriptorProtos.EnumValueDescriptorProto.Builder newBuilder(EnumValueDescriptorProto paramEnumValueDescriptorProto)
  {
    return a.toBuilder().a(paramEnumValueDescriptorProto);
  }
  
  public static EnumValueDescriptorProto parseDelimitedFrom(InputStream paramInputStream)
  {
    return (EnumValueDescriptorProto)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream);
  }
  
  public static EnumValueDescriptorProto parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (EnumValueDescriptorProto)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static EnumValueDescriptorProto parseFrom(ByteString paramByteString)
  {
    return (EnumValueDescriptorProto)PARSER.parseFrom(paramByteString);
  }
  
  public static EnumValueDescriptorProto parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (EnumValueDescriptorProto)PARSER.parseFrom(paramByteString, paramExtensionRegistryLite);
  }
  
  public static EnumValueDescriptorProto parseFrom(CodedInputStream paramCodedInputStream)
  {
    return (EnumValueDescriptorProto)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream);
  }
  
  public static EnumValueDescriptorProto parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (EnumValueDescriptorProto)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static EnumValueDescriptorProto parseFrom(InputStream paramInputStream)
  {
    return (EnumValueDescriptorProto)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream);
  }
  
  public static EnumValueDescriptorProto parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (EnumValueDescriptorProto)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static EnumValueDescriptorProto parseFrom(ByteBuffer paramByteBuffer)
  {
    return (EnumValueDescriptorProto)PARSER.parseFrom(paramByteBuffer);
  }
  
  public static EnumValueDescriptorProto parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (EnumValueDescriptorProto)PARSER.parseFrom(paramByteBuffer, paramExtensionRegistryLite);
  }
  
  public static EnumValueDescriptorProto parseFrom(byte[] paramArrayOfByte)
  {
    return (EnumValueDescriptorProto)PARSER.parseFrom(paramArrayOfByte);
  }
  
  public static EnumValueDescriptorProto parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (EnumValueDescriptorProto)PARSER.parseFrom(paramArrayOfByte, paramExtensionRegistryLite);
  }
  
  public static Parser<EnumValueDescriptorProto> parser()
  {
    return PARSER;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof EnumValueDescriptorProto)) {
      return super.equals(paramObject);
    }
    paramObject = (EnumValueDescriptorProto)paramObject;
    if (hasName() != paramObject.hasName()) {
      return false;
    }
    if ((hasName()) && (!getName().equals(paramObject.getName()))) {
      return false;
    }
    if (hasNumber() != paramObject.hasNumber()) {
      return false;
    }
    if ((hasNumber()) && (getNumber() != paramObject.getNumber())) {
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
  
  public EnumValueDescriptorProto getDefaultInstanceForType()
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
  
  public int getNumber()
  {
    return this.number_;
  }
  
  public DescriptorProtos.EnumValueOptions getOptions()
  {
    DescriptorProtos.EnumValueOptions localEnumValueOptions2 = this.options_;
    DescriptorProtos.EnumValueOptions localEnumValueOptions1 = localEnumValueOptions2;
    if (localEnumValueOptions2 == null) {
      localEnumValueOptions1 = DescriptorProtos.EnumValueOptions.getDefaultInstance();
    }
    return localEnumValueOptions1;
  }
  
  public DescriptorProtos.EnumValueOptionsOrBuilder getOptionsOrBuilder()
  {
    DescriptorProtos.EnumValueOptions localEnumValueOptions2 = this.options_;
    DescriptorProtos.EnumValueOptions localEnumValueOptions1 = localEnumValueOptions2;
    if (localEnumValueOptions2 == null) {
      localEnumValueOptions1 = DescriptorProtos.EnumValueOptions.getDefaultInstance();
    }
    return localEnumValueOptions1;
  }
  
  public Parser<EnumValueDescriptorProto> getParserForType()
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
      i = j + CodedOutputStream.h(2, this.number_);
    }
    j = i;
    if ((this.bitField0_ & 0x4) != 0) {
      j = i + CodedOutputStream.c(3, getOptions());
    }
    i = j + this.unknownFields.getSerializedSize();
    this.memoizedSize = i;
    return i;
  }
  
  public final UnknownFieldSet getUnknownFields()
  {
    return this.unknownFields;
  }
  
  public boolean hasName()
  {
    return (this.bitField0_ & 0x1) != 0;
  }
  
  public boolean hasNumber()
  {
    return (this.bitField0_ & 0x2) != 0;
  }
  
  public boolean hasOptions()
  {
    return (this.bitField0_ & 0x4) != 0;
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
    if (hasNumber()) {
      j = (i * 37 + 2) * 53 + getNumber();
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
    return DescriptorProtos.w().a(EnumValueDescriptorProto.class, DescriptorProtos.EnumValueDescriptorProto.Builder.class);
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
  
  public DescriptorProtos.EnumValueDescriptorProto.Builder newBuilderForType()
  {
    return newBuilder();
  }
  
  protected DescriptorProtos.EnumValueDescriptorProto.Builder newBuilderForType(GeneratedMessageV3.BuilderParent paramBuilderParent)
  {
    return new DescriptorProtos.EnumValueDescriptorProto.Builder(paramBuilderParent, null);
  }
  
  protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter paramUnusedPrivateParameter)
  {
    return new EnumValueDescriptorProto();
  }
  
  public DescriptorProtos.EnumValueDescriptorProto.Builder toBuilder()
  {
    if (this == a) {
      return new DescriptorProtos.EnumValueDescriptorProto.Builder(null);
    }
    return new DescriptorProtos.EnumValueDescriptorProto.Builder(null).a(this);
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
  {
    if ((this.bitField0_ & 0x1) != 0) {
      GeneratedMessageV3.writeString(paramCodedOutputStream, 1, this.name_);
    }
    if ((this.bitField0_ & 0x2) != 0) {
      paramCodedOutputStream.b(2, this.number_);
    }
    if ((this.bitField0_ & 0x4) != 0) {
      paramCodedOutputStream.a(3, getOptions());
    }
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.DescriptorProtos.EnumValueDescriptorProto
 * JD-Core Version:    0.7.0.1
 */