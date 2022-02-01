package com.google.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class DescriptorProtos$EnumOptions
  extends GeneratedMessageV3.ExtendableMessage<EnumOptions>
  implements DescriptorProtos.EnumOptionsOrBuilder
{
  public static final int ALLOW_ALIAS_FIELD_NUMBER = 2;
  public static final int DEPRECATED_FIELD_NUMBER = 3;
  @Deprecated
  public static final Parser<EnumOptions> PARSER = new DescriptorProtos.EnumOptions.1();
  public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
  private static final EnumOptions a = new EnumOptions();
  private static final long serialVersionUID = 0L;
  private boolean allowAlias_;
  private int bitField0_;
  private boolean deprecated_;
  private byte memoizedIsInitialized = -1;
  private List<DescriptorProtos.UninterpretedOption> uninterpretedOption_;
  
  private DescriptorProtos$EnumOptions()
  {
    this.uninterpretedOption_ = Collections.emptyList();
  }
  
  /* Error */
  private DescriptorProtos$EnumOptions(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 38	com/google/protobuf/DescriptorProtos$EnumOptions:<init>	()V
    //   4: aload_2
    //   5: ifnull +336 -> 341
    //   8: invokestatic 67	com/google/protobuf/UnknownFieldSet:a	()Lcom/google/protobuf/UnknownFieldSet$Builder;
    //   11: astore 9
    //   13: iconst_0
    //   14: istore 8
    //   16: iconst_0
    //   17: istore_3
    //   18: iload 8
    //   20: ifne +290 -> 310
    //   23: iload_3
    //   24: istore 5
    //   26: iload_3
    //   27: istore 6
    //   29: iload_3
    //   30: istore 7
    //   32: aload_1
    //   33: invokevirtual 72	com/google/protobuf/CodedInputStream:a	()I
    //   36: istore 4
    //   38: iload 4
    //   40: ifeq +198 -> 238
    //   43: iload 4
    //   45: bipush 16
    //   47: if_icmpeq +152 -> 199
    //   50: iload 4
    //   52: bipush 24
    //   54: if_icmpeq +106 -> 160
    //   57: iload 4
    //   59: sipush 7994
    //   62: if_icmpeq +28 -> 90
    //   65: iload_3
    //   66: istore 5
    //   68: iload_3
    //   69: istore 6
    //   71: iload_3
    //   72: istore 7
    //   74: aload_0
    //   75: aload_1
    //   76: aload 9
    //   78: aload_2
    //   79: iload 4
    //   81: invokevirtual 76	com/google/protobuf/DescriptorProtos$EnumOptions:parseUnknownField	(Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/UnknownFieldSet$Builder;Lcom/google/protobuf/ExtensionRegistryLite;I)Z
    //   84: ifne -66 -> 18
    //   87: goto +151 -> 238
    //   90: iload_3
    //   91: istore 4
    //   93: iload_3
    //   94: iconst_4
    //   95: iand
    //   96: ifne +28 -> 124
    //   99: iload_3
    //   100: istore 5
    //   102: iload_3
    //   103: istore 6
    //   105: iload_3
    //   106: istore 7
    //   108: aload_0
    //   109: new 78	java/util/ArrayList
    //   112: dup
    //   113: invokespecial 79	java/util/ArrayList:<init>	()V
    //   116: putfield 57	com/google/protobuf/DescriptorProtos$EnumOptions:uninterpretedOption_	Ljava/util/List;
    //   119: iload_3
    //   120: iconst_4
    //   121: ior
    //   122: istore 4
    //   124: iload 4
    //   126: istore 5
    //   128: iload 4
    //   130: istore 6
    //   132: iload 4
    //   134: istore 7
    //   136: aload_0
    //   137: getfield 57	com/google/protobuf/DescriptorProtos$EnumOptions:uninterpretedOption_	Ljava/util/List;
    //   140: aload_1
    //   141: getstatic 82	com/google/protobuf/DescriptorProtos$UninterpretedOption:PARSER	Lcom/google/protobuf/Parser;
    //   144: aload_2
    //   145: invokevirtual 85	com/google/protobuf/CodedInputStream:a	(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   148: invokeinterface 91 2 0
    //   153: pop
    //   154: iload 4
    //   156: istore_3
    //   157: goto -139 -> 18
    //   160: iload_3
    //   161: istore 5
    //   163: iload_3
    //   164: istore 6
    //   166: iload_3
    //   167: istore 7
    //   169: aload_0
    //   170: aload_0
    //   171: getfield 93	com/google/protobuf/DescriptorProtos$EnumOptions:bitField0_	I
    //   174: iconst_2
    //   175: ior
    //   176: putfield 93	com/google/protobuf/DescriptorProtos$EnumOptions:bitField0_	I
    //   179: iload_3
    //   180: istore 5
    //   182: iload_3
    //   183: istore 6
    //   185: iload_3
    //   186: istore 7
    //   188: aload_0
    //   189: aload_1
    //   190: invokevirtual 97	com/google/protobuf/CodedInputStream:i	()Z
    //   193: putfield 99	com/google/protobuf/DescriptorProtos$EnumOptions:deprecated_	Z
    //   196: goto -178 -> 18
    //   199: iload_3
    //   200: istore 5
    //   202: iload_3
    //   203: istore 6
    //   205: iload_3
    //   206: istore 7
    //   208: aload_0
    //   209: aload_0
    //   210: getfield 93	com/google/protobuf/DescriptorProtos$EnumOptions:bitField0_	I
    //   213: iconst_1
    //   214: ior
    //   215: putfield 93	com/google/protobuf/DescriptorProtos$EnumOptions:bitField0_	I
    //   218: iload_3
    //   219: istore 5
    //   221: iload_3
    //   222: istore 6
    //   224: iload_3
    //   225: istore 7
    //   227: aload_0
    //   228: aload_1
    //   229: invokevirtual 97	com/google/protobuf/CodedInputStream:i	()Z
    //   232: putfield 101	com/google/protobuf/DescriptorProtos$EnumOptions:allowAlias_	Z
    //   235: goto -217 -> 18
    //   238: iconst_1
    //   239: istore 8
    //   241: goto -223 -> 18
    //   244: astore_1
    //   245: goto +32 -> 277
    //   248: astore_1
    //   249: iload 6
    //   251: istore 5
    //   253: new 60	com/google/protobuf/InvalidProtocolBufferException
    //   256: dup
    //   257: aload_1
    //   258: invokespecial 104	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/io/IOException;)V
    //   261: aload_0
    //   262: invokevirtual 108	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   265: athrow
    //   266: astore_1
    //   267: iload 7
    //   269: istore 5
    //   271: aload_1
    //   272: aload_0
    //   273: invokevirtual 108	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   276: athrow
    //   277: iload 5
    //   279: iconst_4
    //   280: iand
    //   281: ifeq +14 -> 295
    //   284: aload_0
    //   285: aload_0
    //   286: getfield 57	com/google/protobuf/DescriptorProtos$EnumOptions:uninterpretedOption_	Ljava/util/List;
    //   289: invokestatic 112	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   292: putfield 57	com/google/protobuf/DescriptorProtos$EnumOptions:uninterpretedOption_	Ljava/util/List;
    //   295: aload_0
    //   296: aload 9
    //   298: invokevirtual 117	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   301: putfield 121	com/google/protobuf/DescriptorProtos$EnumOptions:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   304: aload_0
    //   305: invokevirtual 124	com/google/protobuf/DescriptorProtos$EnumOptions:makeExtensionsImmutable	()V
    //   308: aload_1
    //   309: athrow
    //   310: iload_3
    //   311: iconst_4
    //   312: iand
    //   313: ifeq +14 -> 327
    //   316: aload_0
    //   317: aload_0
    //   318: getfield 57	com/google/protobuf/DescriptorProtos$EnumOptions:uninterpretedOption_	Ljava/util/List;
    //   321: invokestatic 112	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   324: putfield 57	com/google/protobuf/DescriptorProtos$EnumOptions:uninterpretedOption_	Ljava/util/List;
    //   327: aload_0
    //   328: aload 9
    //   330: invokevirtual 117	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   333: putfield 121	com/google/protobuf/DescriptorProtos$EnumOptions:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   336: aload_0
    //   337: invokevirtual 124	com/google/protobuf/DescriptorProtos$EnumOptions:makeExtensionsImmutable	()V
    //   340: return
    //   341: new 126	java/lang/NullPointerException
    //   344: dup
    //   345: invokespecial 127	java/lang/NullPointerException:<init>	()V
    //   348: astore_1
    //   349: goto +5 -> 354
    //   352: aload_1
    //   353: athrow
    //   354: goto -2 -> 352
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	357	0	this	EnumOptions
    //   0	357	1	paramCodedInputStream	CodedInputStream
    //   0	357	2	paramExtensionRegistryLite	ExtensionRegistryLite
    //   17	296	3	i	int
    //   36	119	4	j	int
    //   24	257	5	k	int
    //   27	223	6	m	int
    //   30	238	7	n	int
    //   14	226	8	i1	int
    //   11	318	9	localBuilder	UnknownFieldSet.Builder
    // Exception table:
    //   from	to	target	type
    //   32	38	244	finally
    //   74	87	244	finally
    //   108	119	244	finally
    //   136	154	244	finally
    //   169	179	244	finally
    //   188	196	244	finally
    //   208	218	244	finally
    //   227	235	244	finally
    //   253	266	244	finally
    //   271	277	244	finally
    //   32	38	248	java/io/IOException
    //   74	87	248	java/io/IOException
    //   108	119	248	java/io/IOException
    //   136	154	248	java/io/IOException
    //   169	179	248	java/io/IOException
    //   188	196	248	java/io/IOException
    //   208	218	248	java/io/IOException
    //   227	235	248	java/io/IOException
    //   32	38	266	com/google/protobuf/InvalidProtocolBufferException
    //   74	87	266	com/google/protobuf/InvalidProtocolBufferException
    //   108	119	266	com/google/protobuf/InvalidProtocolBufferException
    //   136	154	266	com/google/protobuf/InvalidProtocolBufferException
    //   169	179	266	com/google/protobuf/InvalidProtocolBufferException
    //   188	196	266	com/google/protobuf/InvalidProtocolBufferException
    //   208	218	266	com/google/protobuf/InvalidProtocolBufferException
    //   227	235	266	com/google/protobuf/InvalidProtocolBufferException
  }
  
  private DescriptorProtos$EnumOptions(GeneratedMessageV3.ExtendableBuilder<EnumOptions, ?> paramExtendableBuilder)
  {
    super(paramExtendableBuilder);
  }
  
  public static EnumOptions getDefaultInstance()
  {
    return a;
  }
  
  public static final Descriptors.Descriptor getDescriptor()
  {
    return DescriptorProtos.J();
  }
  
  public static DescriptorProtos.EnumOptions.Builder newBuilder()
  {
    return a.toBuilder();
  }
  
  public static DescriptorProtos.EnumOptions.Builder newBuilder(EnumOptions paramEnumOptions)
  {
    return a.toBuilder().a(paramEnumOptions);
  }
  
  public static EnumOptions parseDelimitedFrom(InputStream paramInputStream)
  {
    return (EnumOptions)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream);
  }
  
  public static EnumOptions parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (EnumOptions)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static EnumOptions parseFrom(ByteString paramByteString)
  {
    return (EnumOptions)PARSER.parseFrom(paramByteString);
  }
  
  public static EnumOptions parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (EnumOptions)PARSER.parseFrom(paramByteString, paramExtensionRegistryLite);
  }
  
  public static EnumOptions parseFrom(CodedInputStream paramCodedInputStream)
  {
    return (EnumOptions)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream);
  }
  
  public static EnumOptions parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (EnumOptions)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static EnumOptions parseFrom(InputStream paramInputStream)
  {
    return (EnumOptions)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream);
  }
  
  public static EnumOptions parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (EnumOptions)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static EnumOptions parseFrom(ByteBuffer paramByteBuffer)
  {
    return (EnumOptions)PARSER.parseFrom(paramByteBuffer);
  }
  
  public static EnumOptions parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (EnumOptions)PARSER.parseFrom(paramByteBuffer, paramExtensionRegistryLite);
  }
  
  public static EnumOptions parseFrom(byte[] paramArrayOfByte)
  {
    return (EnumOptions)PARSER.parseFrom(paramArrayOfByte);
  }
  
  public static EnumOptions parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (EnumOptions)PARSER.parseFrom(paramArrayOfByte, paramExtensionRegistryLite);
  }
  
  public static Parser<EnumOptions> parser()
  {
    return PARSER;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof EnumOptions)) {
      return super.equals(paramObject);
    }
    paramObject = (EnumOptions)paramObject;
    if (hasAllowAlias() != paramObject.hasAllowAlias()) {
      return false;
    }
    if ((hasAllowAlias()) && (getAllowAlias() != paramObject.getAllowAlias())) {
      return false;
    }
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
  
  public boolean getAllowAlias()
  {
    return this.allowAlias_;
  }
  
  public EnumOptions getDefaultInstanceForType()
  {
    return a;
  }
  
  public boolean getDeprecated()
  {
    return this.deprecated_;
  }
  
  public Parser<EnumOptions> getParserForType()
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
    int j;
    if ((i & 0x1) != 0) {
      j = CodedOutputStream.b(2, this.allowAlias_) + 0;
    } else {
      j = 0;
    }
    i = j;
    int k = m;
    if ((0x2 & this.bitField0_) != 0)
    {
      i = j + CodedOutputStream.b(3, this.deprecated_);
      k = m;
    }
    while (k < this.uninterpretedOption_.size())
    {
      i += CodedOutputStream.c(999, (MessageLite)this.uninterpretedOption_.get(k));
      k += 1;
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
  
  public boolean hasAllowAlias()
  {
    return (this.bitField0_ & 0x1) != 0;
  }
  
  public boolean hasDeprecated()
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
    if (hasAllowAlias()) {
      i = (j * 37 + 2) * 53 + Internal.a(getAllowAlias());
    }
    j = i;
    if (hasDeprecated()) {
      j = (i * 37 + 3) * 53 + Internal.a(getDeprecated());
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
    return DescriptorProtos.K().a(EnumOptions.class, DescriptorProtos.EnumOptions.Builder.class);
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
  
  public DescriptorProtos.EnumOptions.Builder newBuilderForType()
  {
    return newBuilder();
  }
  
  protected DescriptorProtos.EnumOptions.Builder newBuilderForType(GeneratedMessageV3.BuilderParent paramBuilderParent)
  {
    return new DescriptorProtos.EnumOptions.Builder(paramBuilderParent, null);
  }
  
  protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter paramUnusedPrivateParameter)
  {
    return new EnumOptions();
  }
  
  public DescriptorProtos.EnumOptions.Builder toBuilder()
  {
    if (this == a) {
      return new DescriptorProtos.EnumOptions.Builder(null);
    }
    return new DescriptorProtos.EnumOptions.Builder(null).a(this);
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
  {
    GeneratedMessageV3.ExtendableMessage.ExtensionWriter localExtensionWriter = newExtensionWriter();
    if ((this.bitField0_ & 0x1) != 0) {
      paramCodedOutputStream.a(2, this.allowAlias_);
    }
    if ((this.bitField0_ & 0x2) != 0) {
      paramCodedOutputStream.a(3, this.deprecated_);
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
 * Qualified Name:     com.google.protobuf.DescriptorProtos.EnumOptions
 * JD-Core Version:    0.7.0.1
 */