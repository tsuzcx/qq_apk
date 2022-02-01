package com.google.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;

public final class DescriptorProtos$OneofDescriptorProto
  extends GeneratedMessageV3
  implements DescriptorProtos.OneofDescriptorProtoOrBuilder
{
  public static final int NAME_FIELD_NUMBER = 1;
  public static final int OPTIONS_FIELD_NUMBER = 2;
  @Deprecated
  public static final Parser<OneofDescriptorProto> PARSER = new DescriptorProtos.OneofDescriptorProto.1();
  private static final OneofDescriptorProto a = new OneofDescriptorProto();
  private static final long serialVersionUID = 0L;
  private int bitField0_;
  private byte memoizedIsInitialized = -1;
  private volatile Object name_;
  private DescriptorProtos.OneofOptions options_;
  
  private DescriptorProtos$OneofDescriptorProto()
  {
    this.name_ = "";
  }
  
  /* Error */
  private DescriptorProtos$OneofDescriptorProto(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 33	com/google/protobuf/DescriptorProtos$OneofDescriptorProto:<init>	()V
    //   4: aload_2
    //   5: ifnull +212 -> 217
    //   8: invokestatic 58	com/google/protobuf/UnknownFieldSet:a	()Lcom/google/protobuf/UnknownFieldSet$Builder;
    //   11: astore 6
    //   13: iconst_0
    //   14: istore_3
    //   15: iload_3
    //   16: ifne +187 -> 203
    //   19: aload_1
    //   20: invokevirtual 63	com/google/protobuf/CodedInputStream:a	()I
    //   23: istore 4
    //   25: iload 4
    //   27: ifeq +131 -> 158
    //   30: iload 4
    //   32: bipush 10
    //   34: if_icmpeq +99 -> 133
    //   37: iload 4
    //   39: bipush 18
    //   41: if_icmpeq +19 -> 60
    //   44: aload_0
    //   45: aload_1
    //   46: aload 6
    //   48: aload_2
    //   49: iload 4
    //   51: invokevirtual 67	com/google/protobuf/DescriptorProtos$OneofDescriptorProto:parseUnknownField	(Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/UnknownFieldSet$Builder;Lcom/google/protobuf/ExtensionRegistryLite;I)Z
    //   54: ifne -39 -> 15
    //   57: goto +101 -> 158
    //   60: aconst_null
    //   61: astore 5
    //   63: aload_0
    //   64: getfield 69	com/google/protobuf/DescriptorProtos$OneofDescriptorProto:bitField0_	I
    //   67: iconst_2
    //   68: iand
    //   69: ifeq +12 -> 81
    //   72: aload_0
    //   73: getfield 71	com/google/protobuf/DescriptorProtos$OneofDescriptorProto:options_	Lcom/google/protobuf/DescriptorProtos$OneofOptions;
    //   76: invokevirtual 77	com/google/protobuf/DescriptorProtos$OneofOptions:toBuilder	()Lcom/google/protobuf/DescriptorProtos$OneofOptions$Builder;
    //   79: astore 5
    //   81: aload_0
    //   82: aload_1
    //   83: getstatic 78	com/google/protobuf/DescriptorProtos$OneofOptions:PARSER	Lcom/google/protobuf/Parser;
    //   86: aload_2
    //   87: invokevirtual 81	com/google/protobuf/CodedInputStream:a	(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   90: checkcast 73	com/google/protobuf/DescriptorProtos$OneofOptions
    //   93: putfield 71	com/google/protobuf/DescriptorProtos$OneofDescriptorProto:options_	Lcom/google/protobuf/DescriptorProtos$OneofOptions;
    //   96: aload 5
    //   98: ifnull +22 -> 120
    //   101: aload 5
    //   103: aload_0
    //   104: getfield 71	com/google/protobuf/DescriptorProtos$OneofDescriptorProto:options_	Lcom/google/protobuf/DescriptorProtos$OneofOptions;
    //   107: invokevirtual 86	com/google/protobuf/DescriptorProtos$OneofOptions$Builder:a	(Lcom/google/protobuf/DescriptorProtos$OneofOptions;)Lcom/google/protobuf/DescriptorProtos$OneofOptions$Builder;
    //   110: pop
    //   111: aload_0
    //   112: aload 5
    //   114: invokevirtual 90	com/google/protobuf/DescriptorProtos$OneofOptions$Builder:d	()Lcom/google/protobuf/DescriptorProtos$OneofOptions;
    //   117: putfield 71	com/google/protobuf/DescriptorProtos$OneofDescriptorProto:options_	Lcom/google/protobuf/DescriptorProtos$OneofOptions;
    //   120: aload_0
    //   121: aload_0
    //   122: getfield 69	com/google/protobuf/DescriptorProtos$OneofDescriptorProto:bitField0_	I
    //   125: iconst_2
    //   126: ior
    //   127: putfield 69	com/google/protobuf/DescriptorProtos$OneofDescriptorProto:bitField0_	I
    //   130: goto -115 -> 15
    //   133: aload_1
    //   134: invokevirtual 94	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   137: astore 5
    //   139: aload_0
    //   140: iconst_1
    //   141: aload_0
    //   142: getfield 69	com/google/protobuf/DescriptorProtos$OneofDescriptorProto:bitField0_	I
    //   145: ior
    //   146: putfield 69	com/google/protobuf/DescriptorProtos$OneofDescriptorProto:bitField0_	I
    //   149: aload_0
    //   150: aload 5
    //   152: putfield 48	com/google/protobuf/DescriptorProtos$OneofDescriptorProto:name_	Ljava/lang/Object;
    //   155: goto -140 -> 15
    //   158: iconst_1
    //   159: istore_3
    //   160: goto -145 -> 15
    //   163: astore_1
    //   164: goto +24 -> 188
    //   167: astore_1
    //   168: new 51	com/google/protobuf/InvalidProtocolBufferException
    //   171: dup
    //   172: aload_1
    //   173: invokespecial 97	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/io/IOException;)V
    //   176: aload_0
    //   177: invokevirtual 101	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   180: athrow
    //   181: astore_1
    //   182: aload_1
    //   183: aload_0
    //   184: invokevirtual 101	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   187: athrow
    //   188: aload_0
    //   189: aload 6
    //   191: invokevirtual 106	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   194: putfield 110	com/google/protobuf/DescriptorProtos$OneofDescriptorProto:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   197: aload_0
    //   198: invokevirtual 113	com/google/protobuf/DescriptorProtos$OneofDescriptorProto:makeExtensionsImmutable	()V
    //   201: aload_1
    //   202: athrow
    //   203: aload_0
    //   204: aload 6
    //   206: invokevirtual 106	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   209: putfield 110	com/google/protobuf/DescriptorProtos$OneofDescriptorProto:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   212: aload_0
    //   213: invokevirtual 113	com/google/protobuf/DescriptorProtos$OneofDescriptorProto:makeExtensionsImmutable	()V
    //   216: return
    //   217: new 115	java/lang/NullPointerException
    //   220: dup
    //   221: invokespecial 116	java/lang/NullPointerException:<init>	()V
    //   224: astore_1
    //   225: goto +5 -> 230
    //   228: aload_1
    //   229: athrow
    //   230: goto -2 -> 228
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	233	0	this	OneofDescriptorProto
    //   0	233	1	paramCodedInputStream	CodedInputStream
    //   0	233	2	paramExtensionRegistryLite	ExtensionRegistryLite
    //   14	146	3	i	int
    //   23	27	4	j	int
    //   61	90	5	localObject	Object
    //   11	194	6	localBuilder	UnknownFieldSet.Builder
    // Exception table:
    //   from	to	target	type
    //   19	25	163	finally
    //   44	57	163	finally
    //   63	81	163	finally
    //   81	96	163	finally
    //   101	120	163	finally
    //   120	130	163	finally
    //   133	155	163	finally
    //   168	181	163	finally
    //   182	188	163	finally
    //   19	25	167	java/io/IOException
    //   44	57	167	java/io/IOException
    //   63	81	167	java/io/IOException
    //   81	96	167	java/io/IOException
    //   101	120	167	java/io/IOException
    //   120	130	167	java/io/IOException
    //   133	155	167	java/io/IOException
    //   19	25	181	com/google/protobuf/InvalidProtocolBufferException
    //   44	57	181	com/google/protobuf/InvalidProtocolBufferException
    //   63	81	181	com/google/protobuf/InvalidProtocolBufferException
    //   81	96	181	com/google/protobuf/InvalidProtocolBufferException
    //   101	120	181	com/google/protobuf/InvalidProtocolBufferException
    //   120	130	181	com/google/protobuf/InvalidProtocolBufferException
    //   133	155	181	com/google/protobuf/InvalidProtocolBufferException
  }
  
  private DescriptorProtos$OneofDescriptorProto(GeneratedMessageV3.Builder<?> paramBuilder)
  {
    super(paramBuilder);
  }
  
  public static OneofDescriptorProto getDefaultInstance()
  {
    return a;
  }
  
  public static final Descriptors.Descriptor getDescriptor()
  {
    return DescriptorProtos.p();
  }
  
  public static DescriptorProtos.OneofDescriptorProto.Builder newBuilder()
  {
    return a.toBuilder();
  }
  
  public static DescriptorProtos.OneofDescriptorProto.Builder newBuilder(OneofDescriptorProto paramOneofDescriptorProto)
  {
    return a.toBuilder().a(paramOneofDescriptorProto);
  }
  
  public static OneofDescriptorProto parseDelimitedFrom(InputStream paramInputStream)
  {
    return (OneofDescriptorProto)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream);
  }
  
  public static OneofDescriptorProto parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (OneofDescriptorProto)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static OneofDescriptorProto parseFrom(ByteString paramByteString)
  {
    return (OneofDescriptorProto)PARSER.parseFrom(paramByteString);
  }
  
  public static OneofDescriptorProto parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (OneofDescriptorProto)PARSER.parseFrom(paramByteString, paramExtensionRegistryLite);
  }
  
  public static OneofDescriptorProto parseFrom(CodedInputStream paramCodedInputStream)
  {
    return (OneofDescriptorProto)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream);
  }
  
  public static OneofDescriptorProto parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (OneofDescriptorProto)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static OneofDescriptorProto parseFrom(InputStream paramInputStream)
  {
    return (OneofDescriptorProto)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream);
  }
  
  public static OneofDescriptorProto parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (OneofDescriptorProto)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static OneofDescriptorProto parseFrom(ByteBuffer paramByteBuffer)
  {
    return (OneofDescriptorProto)PARSER.parseFrom(paramByteBuffer);
  }
  
  public static OneofDescriptorProto parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (OneofDescriptorProto)PARSER.parseFrom(paramByteBuffer, paramExtensionRegistryLite);
  }
  
  public static OneofDescriptorProto parseFrom(byte[] paramArrayOfByte)
  {
    return (OneofDescriptorProto)PARSER.parseFrom(paramArrayOfByte);
  }
  
  public static OneofDescriptorProto parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (OneofDescriptorProto)PARSER.parseFrom(paramArrayOfByte, paramExtensionRegistryLite);
  }
  
  public static Parser<OneofDescriptorProto> parser()
  {
    return PARSER;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof OneofDescriptorProto)) {
      return super.equals(paramObject);
    }
    paramObject = (OneofDescriptorProto)paramObject;
    if (hasName() != paramObject.hasName()) {
      return false;
    }
    if ((hasName()) && (!getName().equals(paramObject.getName()))) {
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
  
  public OneofDescriptorProto getDefaultInstanceForType()
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
  
  public DescriptorProtos.OneofOptions getOptions()
  {
    DescriptorProtos.OneofOptions localOneofOptions2 = this.options_;
    DescriptorProtos.OneofOptions localOneofOptions1 = localOneofOptions2;
    if (localOneofOptions2 == null) {
      localOneofOptions1 = DescriptorProtos.OneofOptions.getDefaultInstance();
    }
    return localOneofOptions1;
  }
  
  public DescriptorProtos.OneofOptionsOrBuilder getOptionsOrBuilder()
  {
    DescriptorProtos.OneofOptions localOneofOptions2 = this.options_;
    DescriptorProtos.OneofOptions localOneofOptions1 = localOneofOptions2;
    if (localOneofOptions2 == null) {
      localOneofOptions1 = DescriptorProtos.OneofOptions.getDefaultInstance();
    }
    return localOneofOptions1;
  }
  
  public Parser<OneofDescriptorProto> getParserForType()
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
      i = 0 + GeneratedMessageV3.computeStringSize(1, this.name_);
    }
    int j = i;
    if ((this.bitField0_ & 0x2) != 0) {
      j = i + CodedOutputStream.c(2, getOptions());
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
    if (hasOptions()) {
      j = (i * 37 + 2) * 53 + getOptions().hashCode();
    }
    i = j * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    return i;
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return DescriptorProtos.q().a(OneofDescriptorProto.class, DescriptorProtos.OneofDescriptorProto.Builder.class);
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
  
  public DescriptorProtos.OneofDescriptorProto.Builder newBuilderForType()
  {
    return newBuilder();
  }
  
  protected DescriptorProtos.OneofDescriptorProto.Builder newBuilderForType(GeneratedMessageV3.BuilderParent paramBuilderParent)
  {
    return new DescriptorProtos.OneofDescriptorProto.Builder(paramBuilderParent, null);
  }
  
  protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter paramUnusedPrivateParameter)
  {
    return new OneofDescriptorProto();
  }
  
  public DescriptorProtos.OneofDescriptorProto.Builder toBuilder()
  {
    if (this == a) {
      return new DescriptorProtos.OneofDescriptorProto.Builder(null);
    }
    return new DescriptorProtos.OneofDescriptorProto.Builder(null).a(this);
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
  {
    if ((this.bitField0_ & 0x1) != 0) {
      GeneratedMessageV3.writeString(paramCodedOutputStream, 1, this.name_);
    }
    if ((this.bitField0_ & 0x2) != 0) {
      paramCodedOutputStream.a(2, getOptions());
    }
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.DescriptorProtos.OneofDescriptorProto
 * JD-Core Version:    0.7.0.1
 */