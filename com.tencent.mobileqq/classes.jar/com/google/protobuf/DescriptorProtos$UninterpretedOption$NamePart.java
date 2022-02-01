package com.google.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;

public final class DescriptorProtos$UninterpretedOption$NamePart
  extends GeneratedMessageV3
  implements DescriptorProtos.UninterpretedOption.NamePartOrBuilder
{
  public static final int IS_EXTENSION_FIELD_NUMBER = 2;
  public static final int NAME_PART_FIELD_NUMBER = 1;
  @Deprecated
  public static final Parser<NamePart> PARSER = new DescriptorProtos.UninterpretedOption.NamePart.1();
  private static final NamePart a = new NamePart();
  private static final long serialVersionUID = 0L;
  private int bitField0_;
  private boolean isExtension_;
  private byte memoizedIsInitialized = -1;
  private volatile Object namePart_;
  
  private DescriptorProtos$UninterpretedOption$NamePart()
  {
    this.namePart_ = "";
  }
  
  /* Error */
  private DescriptorProtos$UninterpretedOption$NamePart(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 33	com/google/protobuf/DescriptorProtos$UninterpretedOption$NamePart:<init>	()V
    //   4: aload_2
    //   5: ifnull +160 -> 165
    //   8: invokestatic 58	com/google/protobuf/UnknownFieldSet:a	()Lcom/google/protobuf/UnknownFieldSet$Builder;
    //   11: astore 5
    //   13: iconst_0
    //   14: istore_3
    //   15: iload_3
    //   16: ifne +135 -> 151
    //   19: aload_1
    //   20: invokevirtual 63	com/google/protobuf/CodedInputStream:a	()I
    //   23: istore 4
    //   25: iload 4
    //   27: ifeq +79 -> 106
    //   30: iload 4
    //   32: bipush 10
    //   34: if_icmpeq +47 -> 81
    //   37: iload 4
    //   39: bipush 16
    //   41: if_icmpeq +19 -> 60
    //   44: aload_0
    //   45: aload_1
    //   46: aload 5
    //   48: aload_2
    //   49: iload 4
    //   51: invokevirtual 67	com/google/protobuf/DescriptorProtos$UninterpretedOption$NamePart:parseUnknownField	(Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/UnknownFieldSet$Builder;Lcom/google/protobuf/ExtensionRegistryLite;I)Z
    //   54: ifne -39 -> 15
    //   57: goto +49 -> 106
    //   60: aload_0
    //   61: aload_0
    //   62: getfield 69	com/google/protobuf/DescriptorProtos$UninterpretedOption$NamePart:bitField0_	I
    //   65: iconst_2
    //   66: ior
    //   67: putfield 69	com/google/protobuf/DescriptorProtos$UninterpretedOption$NamePart:bitField0_	I
    //   70: aload_0
    //   71: aload_1
    //   72: invokevirtual 73	com/google/protobuf/CodedInputStream:i	()Z
    //   75: putfield 75	com/google/protobuf/DescriptorProtos$UninterpretedOption$NamePart:isExtension_	Z
    //   78: goto -63 -> 15
    //   81: aload_1
    //   82: invokevirtual 79	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   85: astore 6
    //   87: aload_0
    //   88: iconst_1
    //   89: aload_0
    //   90: getfield 69	com/google/protobuf/DescriptorProtos$UninterpretedOption$NamePart:bitField0_	I
    //   93: ior
    //   94: putfield 69	com/google/protobuf/DescriptorProtos$UninterpretedOption$NamePart:bitField0_	I
    //   97: aload_0
    //   98: aload 6
    //   100: putfield 48	com/google/protobuf/DescriptorProtos$UninterpretedOption$NamePart:namePart_	Ljava/lang/Object;
    //   103: goto -88 -> 15
    //   106: iconst_1
    //   107: istore_3
    //   108: goto -93 -> 15
    //   111: astore_1
    //   112: goto +24 -> 136
    //   115: astore_1
    //   116: new 51	com/google/protobuf/InvalidProtocolBufferException
    //   119: dup
    //   120: aload_1
    //   121: invokespecial 82	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/io/IOException;)V
    //   124: aload_0
    //   125: invokevirtual 86	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   128: athrow
    //   129: astore_1
    //   130: aload_1
    //   131: aload_0
    //   132: invokevirtual 86	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   135: athrow
    //   136: aload_0
    //   137: aload 5
    //   139: invokevirtual 91	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   142: putfield 95	com/google/protobuf/DescriptorProtos$UninterpretedOption$NamePart:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   145: aload_0
    //   146: invokevirtual 98	com/google/protobuf/DescriptorProtos$UninterpretedOption$NamePart:makeExtensionsImmutable	()V
    //   149: aload_1
    //   150: athrow
    //   151: aload_0
    //   152: aload 5
    //   154: invokevirtual 91	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   157: putfield 95	com/google/protobuf/DescriptorProtos$UninterpretedOption$NamePart:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   160: aload_0
    //   161: invokevirtual 98	com/google/protobuf/DescriptorProtos$UninterpretedOption$NamePart:makeExtensionsImmutable	()V
    //   164: return
    //   165: new 100	java/lang/NullPointerException
    //   168: dup
    //   169: invokespecial 101	java/lang/NullPointerException:<init>	()V
    //   172: astore_1
    //   173: goto +5 -> 178
    //   176: aload_1
    //   177: athrow
    //   178: goto -2 -> 176
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	181	0	this	NamePart
    //   0	181	1	paramCodedInputStream	CodedInputStream
    //   0	181	2	paramExtensionRegistryLite	ExtensionRegistryLite
    //   14	94	3	i	int
    //   23	27	4	j	int
    //   11	142	5	localBuilder	UnknownFieldSet.Builder
    //   85	14	6	localByteString	ByteString
    // Exception table:
    //   from	to	target	type
    //   19	25	111	finally
    //   44	57	111	finally
    //   60	78	111	finally
    //   81	103	111	finally
    //   116	129	111	finally
    //   130	136	111	finally
    //   19	25	115	java/io/IOException
    //   44	57	115	java/io/IOException
    //   60	78	115	java/io/IOException
    //   81	103	115	java/io/IOException
    //   19	25	129	com/google/protobuf/InvalidProtocolBufferException
    //   44	57	129	com/google/protobuf/InvalidProtocolBufferException
    //   60	78	129	com/google/protobuf/InvalidProtocolBufferException
    //   81	103	129	com/google/protobuf/InvalidProtocolBufferException
  }
  
  private DescriptorProtos$UninterpretedOption$NamePart(GeneratedMessageV3.Builder<?> paramBuilder)
  {
    super(paramBuilder);
  }
  
  public static NamePart getDefaultInstance()
  {
    return a;
  }
  
  public static final Descriptors.Descriptor getDescriptor()
  {
    return DescriptorProtos.T();
  }
  
  public static DescriptorProtos.UninterpretedOption.NamePart.Builder newBuilder()
  {
    return a.toBuilder();
  }
  
  public static DescriptorProtos.UninterpretedOption.NamePart.Builder newBuilder(NamePart paramNamePart)
  {
    return a.toBuilder().a(paramNamePart);
  }
  
  public static NamePart parseDelimitedFrom(InputStream paramInputStream)
  {
    return (NamePart)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream);
  }
  
  public static NamePart parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (NamePart)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static NamePart parseFrom(ByteString paramByteString)
  {
    return (NamePart)PARSER.parseFrom(paramByteString);
  }
  
  public static NamePart parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (NamePart)PARSER.parseFrom(paramByteString, paramExtensionRegistryLite);
  }
  
  public static NamePart parseFrom(CodedInputStream paramCodedInputStream)
  {
    return (NamePart)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream);
  }
  
  public static NamePart parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (NamePart)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static NamePart parseFrom(InputStream paramInputStream)
  {
    return (NamePart)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream);
  }
  
  public static NamePart parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (NamePart)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static NamePart parseFrom(ByteBuffer paramByteBuffer)
  {
    return (NamePart)PARSER.parseFrom(paramByteBuffer);
  }
  
  public static NamePart parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (NamePart)PARSER.parseFrom(paramByteBuffer, paramExtensionRegistryLite);
  }
  
  public static NamePart parseFrom(byte[] paramArrayOfByte)
  {
    return (NamePart)PARSER.parseFrom(paramArrayOfByte);
  }
  
  public static NamePart parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (NamePart)PARSER.parseFrom(paramArrayOfByte, paramExtensionRegistryLite);
  }
  
  public static Parser<NamePart> parser()
  {
    return PARSER;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof NamePart)) {
      return super.equals(paramObject);
    }
    paramObject = (NamePart)paramObject;
    if (hasNamePart() != paramObject.hasNamePart()) {
      return false;
    }
    if ((hasNamePart()) && (!getNamePart().equals(paramObject.getNamePart()))) {
      return false;
    }
    if (hasIsExtension() != paramObject.hasIsExtension()) {
      return false;
    }
    if ((hasIsExtension()) && (getIsExtension() != paramObject.getIsExtension())) {
      return false;
    }
    return this.unknownFields.equals(paramObject.unknownFields);
  }
  
  public NamePart getDefaultInstanceForType()
  {
    return a;
  }
  
  public boolean getIsExtension()
  {
    return this.isExtension_;
  }
  
  public String getNamePart()
  {
    Object localObject = this.namePart_;
    if ((localObject instanceof String)) {
      return (String)localObject;
    }
    localObject = (ByteString)localObject;
    String str = ((ByteString)localObject).toStringUtf8();
    if (((ByteString)localObject).isValidUtf8()) {
      this.namePart_ = str;
    }
    return str;
  }
  
  public ByteString getNamePartBytes()
  {
    Object localObject = this.namePart_;
    if ((localObject instanceof String))
    {
      localObject = ByteString.copyFromUtf8((String)localObject);
      this.namePart_ = localObject;
      return localObject;
    }
    return (ByteString)localObject;
  }
  
  public Parser<NamePart> getParserForType()
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
      i = 0 + GeneratedMessageV3.computeStringSize(1, this.namePart_);
    }
    int j = i;
    if ((this.bitField0_ & 0x2) != 0) {
      j = i + CodedOutputStream.b(2, this.isExtension_);
    }
    i = j + this.unknownFields.getSerializedSize();
    this.memoizedSize = i;
    return i;
  }
  
  public final UnknownFieldSet getUnknownFields()
  {
    return this.unknownFields;
  }
  
  public boolean hasIsExtension()
  {
    return (this.bitField0_ & 0x2) != 0;
  }
  
  public boolean hasNamePart()
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
    if (hasNamePart()) {
      i = (j * 37 + 1) * 53 + getNamePart().hashCode();
    }
    j = i;
    if (hasIsExtension()) {
      j = (i * 37 + 2) * 53 + Internal.a(getIsExtension());
    }
    i = j * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    return i;
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return DescriptorProtos.U().a(NamePart.class, DescriptorProtos.UninterpretedOption.NamePart.Builder.class);
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
    if (!hasNamePart())
    {
      this.memoizedIsInitialized = 0;
      return false;
    }
    if (!hasIsExtension())
    {
      this.memoizedIsInitialized = 0;
      return false;
    }
    this.memoizedIsInitialized = 1;
    return true;
  }
  
  public DescriptorProtos.UninterpretedOption.NamePart.Builder newBuilderForType()
  {
    return newBuilder();
  }
  
  protected DescriptorProtos.UninterpretedOption.NamePart.Builder newBuilderForType(GeneratedMessageV3.BuilderParent paramBuilderParent)
  {
    return new DescriptorProtos.UninterpretedOption.NamePart.Builder(paramBuilderParent, null);
  }
  
  protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter paramUnusedPrivateParameter)
  {
    return new NamePart();
  }
  
  public DescriptorProtos.UninterpretedOption.NamePart.Builder toBuilder()
  {
    if (this == a) {
      return new DescriptorProtos.UninterpretedOption.NamePart.Builder(null);
    }
    return new DescriptorProtos.UninterpretedOption.NamePart.Builder(null).a(this);
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
  {
    if ((this.bitField0_ & 0x1) != 0) {
      GeneratedMessageV3.writeString(paramCodedOutputStream, 1, this.namePart_);
    }
    if ((this.bitField0_ & 0x2) != 0) {
      paramCodedOutputStream.a(2, this.isExtension_);
    }
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.DescriptorProtos.UninterpretedOption.NamePart
 * JD-Core Version:    0.7.0.1
 */