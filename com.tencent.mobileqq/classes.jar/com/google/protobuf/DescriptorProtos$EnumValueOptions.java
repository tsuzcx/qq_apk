package com.google.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class DescriptorProtos$EnumValueOptions
  extends GeneratedMessageV3.ExtendableMessage<EnumValueOptions>
  implements DescriptorProtos.EnumValueOptionsOrBuilder
{
  public static final int DEPRECATED_FIELD_NUMBER = 1;
  @Deprecated
  public static final Parser<EnumValueOptions> PARSER = new DescriptorProtos.EnumValueOptions.1();
  public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
  private static final EnumValueOptions a = new EnumValueOptions();
  private static final long serialVersionUID = 0L;
  private int bitField0_;
  private boolean deprecated_;
  private byte memoizedIsInitialized = -1;
  private List<DescriptorProtos.UninterpretedOption> uninterpretedOption_;
  
  private DescriptorProtos$EnumValueOptions()
  {
    this.uninterpretedOption_ = Collections.emptyList();
  }
  
  /* Error */
  private DescriptorProtos$EnumValueOptions(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 35	com/google/protobuf/DescriptorProtos$EnumValueOptions:<init>	()V
    //   4: aload_2
    //   5: ifnull +290 -> 295
    //   8: invokestatic 64	com/google/protobuf/UnknownFieldSet:a	()Lcom/google/protobuf/UnknownFieldSet$Builder;
    //   11: astore 9
    //   13: iconst_0
    //   14: istore 8
    //   16: iconst_0
    //   17: istore_3
    //   18: iload 8
    //   20: ifne +244 -> 264
    //   23: iload_3
    //   24: istore 5
    //   26: iload_3
    //   27: istore 6
    //   29: iload_3
    //   30: istore 7
    //   32: aload_1
    //   33: invokevirtual 69	com/google/protobuf/CodedInputStream:a	()I
    //   36: istore 4
    //   38: iload 4
    //   40: ifeq +152 -> 192
    //   43: iload 4
    //   45: bipush 8
    //   47: if_icmpeq +106 -> 153
    //   50: iload 4
    //   52: sipush 7994
    //   55: if_icmpeq +28 -> 83
    //   58: iload_3
    //   59: istore 5
    //   61: iload_3
    //   62: istore 6
    //   64: iload_3
    //   65: istore 7
    //   67: aload_0
    //   68: aload_1
    //   69: aload 9
    //   71: aload_2
    //   72: iload 4
    //   74: invokevirtual 73	com/google/protobuf/DescriptorProtos$EnumValueOptions:parseUnknownField	(Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/UnknownFieldSet$Builder;Lcom/google/protobuf/ExtensionRegistryLite;I)Z
    //   77: ifne -59 -> 18
    //   80: goto +112 -> 192
    //   83: iload_3
    //   84: istore 4
    //   86: iload_3
    //   87: iconst_2
    //   88: iand
    //   89: ifne +28 -> 117
    //   92: iload_3
    //   93: istore 5
    //   95: iload_3
    //   96: istore 6
    //   98: iload_3
    //   99: istore 7
    //   101: aload_0
    //   102: new 75	java/util/ArrayList
    //   105: dup
    //   106: invokespecial 76	java/util/ArrayList:<init>	()V
    //   109: putfield 54	com/google/protobuf/DescriptorProtos$EnumValueOptions:uninterpretedOption_	Ljava/util/List;
    //   112: iload_3
    //   113: iconst_2
    //   114: ior
    //   115: istore 4
    //   117: iload 4
    //   119: istore 5
    //   121: iload 4
    //   123: istore 6
    //   125: iload 4
    //   127: istore 7
    //   129: aload_0
    //   130: getfield 54	com/google/protobuf/DescriptorProtos$EnumValueOptions:uninterpretedOption_	Ljava/util/List;
    //   133: aload_1
    //   134: getstatic 79	com/google/protobuf/DescriptorProtos$UninterpretedOption:PARSER	Lcom/google/protobuf/Parser;
    //   137: aload_2
    //   138: invokevirtual 82	com/google/protobuf/CodedInputStream:a	(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   141: invokeinterface 88 2 0
    //   146: pop
    //   147: iload 4
    //   149: istore_3
    //   150: goto -132 -> 18
    //   153: iload_3
    //   154: istore 5
    //   156: iload_3
    //   157: istore 6
    //   159: iload_3
    //   160: istore 7
    //   162: aload_0
    //   163: aload_0
    //   164: getfield 90	com/google/protobuf/DescriptorProtos$EnumValueOptions:bitField0_	I
    //   167: iconst_1
    //   168: ior
    //   169: putfield 90	com/google/protobuf/DescriptorProtos$EnumValueOptions:bitField0_	I
    //   172: iload_3
    //   173: istore 5
    //   175: iload_3
    //   176: istore 6
    //   178: iload_3
    //   179: istore 7
    //   181: aload_0
    //   182: aload_1
    //   183: invokevirtual 94	com/google/protobuf/CodedInputStream:i	()Z
    //   186: putfield 96	com/google/protobuf/DescriptorProtos$EnumValueOptions:deprecated_	Z
    //   189: goto -171 -> 18
    //   192: iconst_1
    //   193: istore 8
    //   195: goto -177 -> 18
    //   198: astore_1
    //   199: goto +32 -> 231
    //   202: astore_1
    //   203: iload 6
    //   205: istore 5
    //   207: new 57	com/google/protobuf/InvalidProtocolBufferException
    //   210: dup
    //   211: aload_1
    //   212: invokespecial 99	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/io/IOException;)V
    //   215: aload_0
    //   216: invokevirtual 103	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   219: athrow
    //   220: astore_1
    //   221: iload 7
    //   223: istore 5
    //   225: aload_1
    //   226: aload_0
    //   227: invokevirtual 103	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   230: athrow
    //   231: iload 5
    //   233: iconst_2
    //   234: iand
    //   235: ifeq +14 -> 249
    //   238: aload_0
    //   239: aload_0
    //   240: getfield 54	com/google/protobuf/DescriptorProtos$EnumValueOptions:uninterpretedOption_	Ljava/util/List;
    //   243: invokestatic 107	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   246: putfield 54	com/google/protobuf/DescriptorProtos$EnumValueOptions:uninterpretedOption_	Ljava/util/List;
    //   249: aload_0
    //   250: aload 9
    //   252: invokevirtual 112	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   255: putfield 116	com/google/protobuf/DescriptorProtos$EnumValueOptions:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   258: aload_0
    //   259: invokevirtual 119	com/google/protobuf/DescriptorProtos$EnumValueOptions:makeExtensionsImmutable	()V
    //   262: aload_1
    //   263: athrow
    //   264: iload_3
    //   265: iconst_2
    //   266: iand
    //   267: ifeq +14 -> 281
    //   270: aload_0
    //   271: aload_0
    //   272: getfield 54	com/google/protobuf/DescriptorProtos$EnumValueOptions:uninterpretedOption_	Ljava/util/List;
    //   275: invokestatic 107	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   278: putfield 54	com/google/protobuf/DescriptorProtos$EnumValueOptions:uninterpretedOption_	Ljava/util/List;
    //   281: aload_0
    //   282: aload 9
    //   284: invokevirtual 112	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   287: putfield 116	com/google/protobuf/DescriptorProtos$EnumValueOptions:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   290: aload_0
    //   291: invokevirtual 119	com/google/protobuf/DescriptorProtos$EnumValueOptions:makeExtensionsImmutable	()V
    //   294: return
    //   295: new 121	java/lang/NullPointerException
    //   298: dup
    //   299: invokespecial 122	java/lang/NullPointerException:<init>	()V
    //   302: astore_1
    //   303: goto +5 -> 308
    //   306: aload_1
    //   307: athrow
    //   308: goto -2 -> 306
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	311	0	this	EnumValueOptions
    //   0	311	1	paramCodedInputStream	CodedInputStream
    //   0	311	2	paramExtensionRegistryLite	ExtensionRegistryLite
    //   17	250	3	i	int
    //   36	112	4	j	int
    //   24	211	5	k	int
    //   27	177	6	m	int
    //   30	192	7	n	int
    //   14	180	8	i1	int
    //   11	272	9	localBuilder	UnknownFieldSet.Builder
    // Exception table:
    //   from	to	target	type
    //   32	38	198	finally
    //   67	80	198	finally
    //   101	112	198	finally
    //   129	147	198	finally
    //   162	172	198	finally
    //   181	189	198	finally
    //   207	220	198	finally
    //   225	231	198	finally
    //   32	38	202	java/io/IOException
    //   67	80	202	java/io/IOException
    //   101	112	202	java/io/IOException
    //   129	147	202	java/io/IOException
    //   162	172	202	java/io/IOException
    //   181	189	202	java/io/IOException
    //   32	38	220	com/google/protobuf/InvalidProtocolBufferException
    //   67	80	220	com/google/protobuf/InvalidProtocolBufferException
    //   101	112	220	com/google/protobuf/InvalidProtocolBufferException
    //   129	147	220	com/google/protobuf/InvalidProtocolBufferException
    //   162	172	220	com/google/protobuf/InvalidProtocolBufferException
    //   181	189	220	com/google/protobuf/InvalidProtocolBufferException
  }
  
  private DescriptorProtos$EnumValueOptions(GeneratedMessageV3.ExtendableBuilder<EnumValueOptions, ?> paramExtendableBuilder)
  {
    super(paramExtendableBuilder);
  }
  
  public static EnumValueOptions getDefaultInstance()
  {
    return a;
  }
  
  public static final Descriptors.Descriptor getDescriptor()
  {
    return DescriptorProtos.L();
  }
  
  public static DescriptorProtos.EnumValueOptions.Builder newBuilder()
  {
    return a.toBuilder();
  }
  
  public static DescriptorProtos.EnumValueOptions.Builder newBuilder(EnumValueOptions paramEnumValueOptions)
  {
    return a.toBuilder().a(paramEnumValueOptions);
  }
  
  public static EnumValueOptions parseDelimitedFrom(InputStream paramInputStream)
  {
    return (EnumValueOptions)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream);
  }
  
  public static EnumValueOptions parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (EnumValueOptions)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static EnumValueOptions parseFrom(ByteString paramByteString)
  {
    return (EnumValueOptions)PARSER.parseFrom(paramByteString);
  }
  
  public static EnumValueOptions parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (EnumValueOptions)PARSER.parseFrom(paramByteString, paramExtensionRegistryLite);
  }
  
  public static EnumValueOptions parseFrom(CodedInputStream paramCodedInputStream)
  {
    return (EnumValueOptions)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream);
  }
  
  public static EnumValueOptions parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (EnumValueOptions)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static EnumValueOptions parseFrom(InputStream paramInputStream)
  {
    return (EnumValueOptions)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream);
  }
  
  public static EnumValueOptions parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (EnumValueOptions)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static EnumValueOptions parseFrom(ByteBuffer paramByteBuffer)
  {
    return (EnumValueOptions)PARSER.parseFrom(paramByteBuffer);
  }
  
  public static EnumValueOptions parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (EnumValueOptions)PARSER.parseFrom(paramByteBuffer, paramExtensionRegistryLite);
  }
  
  public static EnumValueOptions parseFrom(byte[] paramArrayOfByte)
  {
    return (EnumValueOptions)PARSER.parseFrom(paramArrayOfByte);
  }
  
  public static EnumValueOptions parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (EnumValueOptions)PARSER.parseFrom(paramArrayOfByte, paramExtensionRegistryLite);
  }
  
  public static Parser<EnumValueOptions> parser()
  {
    return PARSER;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof EnumValueOptions)) {
      return super.equals(paramObject);
    }
    paramObject = (EnumValueOptions)paramObject;
    if (hasDeprecated() != paramObject.hasDeprecated()) {
      return false;
    }
    if ((hasDeprecated()) && (getDeprecated() != paramObject.getDeprecated())) {
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
  
  public EnumValueOptions getDefaultInstanceForType()
  {
    return a;
  }
  
  public boolean getDeprecated()
  {
    return this.deprecated_;
  }
  
  public Parser<EnumValueOptions> getParserForType()
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
    int j = 0;
    if ((i & 0x1) != 0) {
      i = CodedOutputStream.b(1, this.deprecated_) + 0;
    } else {
      i = 0;
    }
    while (j < this.uninterpretedOption_.size())
    {
      i += CodedOutputStream.c(999, (MessageLite)this.uninterpretedOption_.get(j));
      j += 1;
    }
    i = i + extensionsSerializedSize() + this.unknownFields.getSerializedSize();
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
  
  public boolean hasDeprecated()
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
    if (hasDeprecated()) {
      i = (j * 37 + 1) * 53 + Internal.a(getDeprecated());
    }
    j = i;
    if (getUninterpretedOptionCount() > 0) {
      j = (i * 37 + 999) * 53 + getUninterpretedOptionList().hashCode();
    }
    i = hashFields(j, getExtensionFields()) * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    return i;
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return DescriptorProtos.M().a(EnumValueOptions.class, DescriptorProtos.EnumValueOptions.Builder.class);
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
  
  public DescriptorProtos.EnumValueOptions.Builder newBuilderForType()
  {
    return newBuilder();
  }
  
  protected DescriptorProtos.EnumValueOptions.Builder newBuilderForType(GeneratedMessageV3.BuilderParent paramBuilderParent)
  {
    return new DescriptorProtos.EnumValueOptions.Builder(paramBuilderParent, null);
  }
  
  protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter paramUnusedPrivateParameter)
  {
    return new EnumValueOptions();
  }
  
  public DescriptorProtos.EnumValueOptions.Builder toBuilder()
  {
    if (this == a) {
      return new DescriptorProtos.EnumValueOptions.Builder(null);
    }
    return new DescriptorProtos.EnumValueOptions.Builder(null).a(this);
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
  {
    GeneratedMessageV3.ExtendableMessage.ExtensionWriter localExtensionWriter = newExtensionWriter();
    if ((this.bitField0_ & 0x1) != 0) {
      paramCodedOutputStream.a(1, this.deprecated_);
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
 * Qualified Name:     com.google.protobuf.DescriptorProtos.EnumValueOptions
 * JD-Core Version:    0.7.0.1
 */