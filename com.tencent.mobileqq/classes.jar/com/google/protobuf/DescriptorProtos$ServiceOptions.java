package com.google.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class DescriptorProtos$ServiceOptions
  extends GeneratedMessageV3.ExtendableMessage<ServiceOptions>
  implements DescriptorProtos.ServiceOptionsOrBuilder
{
  public static final int DEPRECATED_FIELD_NUMBER = 33;
  @Deprecated
  public static final Parser<ServiceOptions> PARSER = new DescriptorProtos.ServiceOptions.1();
  public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
  private static final ServiceOptions a = new ServiceOptions();
  private static final long serialVersionUID = 0L;
  private int bitField0_;
  private boolean deprecated_;
  private byte memoizedIsInitialized = -1;
  private List<DescriptorProtos.UninterpretedOption> uninterpretedOption_;
  
  private DescriptorProtos$ServiceOptions()
  {
    this.uninterpretedOption_ = Collections.emptyList();
  }
  
  /* Error */
  private DescriptorProtos$ServiceOptions(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 35	com/google/protobuf/DescriptorProtos$ServiceOptions:<init>	()V
    //   4: aload_2
    //   5: ifnull +291 -> 296
    //   8: invokestatic 64	com/google/protobuf/UnknownFieldSet:a	()Lcom/google/protobuf/UnknownFieldSet$Builder;
    //   11: astore 9
    //   13: iconst_0
    //   14: istore 8
    //   16: iconst_0
    //   17: istore_3
    //   18: iload 8
    //   20: ifne +245 -> 265
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
    //   40: ifeq +153 -> 193
    //   43: iload 4
    //   45: sipush 264
    //   48: if_icmpeq +106 -> 154
    //   51: iload 4
    //   53: sipush 7994
    //   56: if_icmpeq +28 -> 84
    //   59: iload_3
    //   60: istore 5
    //   62: iload_3
    //   63: istore 6
    //   65: iload_3
    //   66: istore 7
    //   68: aload_0
    //   69: aload_1
    //   70: aload 9
    //   72: aload_2
    //   73: iload 4
    //   75: invokevirtual 73	com/google/protobuf/DescriptorProtos$ServiceOptions:parseUnknownField	(Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/UnknownFieldSet$Builder;Lcom/google/protobuf/ExtensionRegistryLite;I)Z
    //   78: ifne -60 -> 18
    //   81: goto +112 -> 193
    //   84: iload_3
    //   85: istore 4
    //   87: iload_3
    //   88: iconst_2
    //   89: iand
    //   90: ifne +28 -> 118
    //   93: iload_3
    //   94: istore 5
    //   96: iload_3
    //   97: istore 6
    //   99: iload_3
    //   100: istore 7
    //   102: aload_0
    //   103: new 75	java/util/ArrayList
    //   106: dup
    //   107: invokespecial 76	java/util/ArrayList:<init>	()V
    //   110: putfield 54	com/google/protobuf/DescriptorProtos$ServiceOptions:uninterpretedOption_	Ljava/util/List;
    //   113: iload_3
    //   114: iconst_2
    //   115: ior
    //   116: istore 4
    //   118: iload 4
    //   120: istore 5
    //   122: iload 4
    //   124: istore 6
    //   126: iload 4
    //   128: istore 7
    //   130: aload_0
    //   131: getfield 54	com/google/protobuf/DescriptorProtos$ServiceOptions:uninterpretedOption_	Ljava/util/List;
    //   134: aload_1
    //   135: getstatic 79	com/google/protobuf/DescriptorProtos$UninterpretedOption:PARSER	Lcom/google/protobuf/Parser;
    //   138: aload_2
    //   139: invokevirtual 82	com/google/protobuf/CodedInputStream:a	(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   142: invokeinterface 88 2 0
    //   147: pop
    //   148: iload 4
    //   150: istore_3
    //   151: goto -133 -> 18
    //   154: iload_3
    //   155: istore 5
    //   157: iload_3
    //   158: istore 6
    //   160: iload_3
    //   161: istore 7
    //   163: aload_0
    //   164: aload_0
    //   165: getfield 90	com/google/protobuf/DescriptorProtos$ServiceOptions:bitField0_	I
    //   168: iconst_1
    //   169: ior
    //   170: putfield 90	com/google/protobuf/DescriptorProtos$ServiceOptions:bitField0_	I
    //   173: iload_3
    //   174: istore 5
    //   176: iload_3
    //   177: istore 6
    //   179: iload_3
    //   180: istore 7
    //   182: aload_0
    //   183: aload_1
    //   184: invokevirtual 94	com/google/protobuf/CodedInputStream:i	()Z
    //   187: putfield 96	com/google/protobuf/DescriptorProtos$ServiceOptions:deprecated_	Z
    //   190: goto -172 -> 18
    //   193: iconst_1
    //   194: istore 8
    //   196: goto -178 -> 18
    //   199: astore_1
    //   200: goto +32 -> 232
    //   203: astore_1
    //   204: iload 6
    //   206: istore 5
    //   208: new 57	com/google/protobuf/InvalidProtocolBufferException
    //   211: dup
    //   212: aload_1
    //   213: invokespecial 99	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/io/IOException;)V
    //   216: aload_0
    //   217: invokevirtual 103	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   220: athrow
    //   221: astore_1
    //   222: iload 7
    //   224: istore 5
    //   226: aload_1
    //   227: aload_0
    //   228: invokevirtual 103	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   231: athrow
    //   232: iload 5
    //   234: iconst_2
    //   235: iand
    //   236: ifeq +14 -> 250
    //   239: aload_0
    //   240: aload_0
    //   241: getfield 54	com/google/protobuf/DescriptorProtos$ServiceOptions:uninterpretedOption_	Ljava/util/List;
    //   244: invokestatic 107	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   247: putfield 54	com/google/protobuf/DescriptorProtos$ServiceOptions:uninterpretedOption_	Ljava/util/List;
    //   250: aload_0
    //   251: aload 9
    //   253: invokevirtual 112	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   256: putfield 116	com/google/protobuf/DescriptorProtos$ServiceOptions:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   259: aload_0
    //   260: invokevirtual 119	com/google/protobuf/DescriptorProtos$ServiceOptions:makeExtensionsImmutable	()V
    //   263: aload_1
    //   264: athrow
    //   265: iload_3
    //   266: iconst_2
    //   267: iand
    //   268: ifeq +14 -> 282
    //   271: aload_0
    //   272: aload_0
    //   273: getfield 54	com/google/protobuf/DescriptorProtos$ServiceOptions:uninterpretedOption_	Ljava/util/List;
    //   276: invokestatic 107	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   279: putfield 54	com/google/protobuf/DescriptorProtos$ServiceOptions:uninterpretedOption_	Ljava/util/List;
    //   282: aload_0
    //   283: aload 9
    //   285: invokevirtual 112	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   288: putfield 116	com/google/protobuf/DescriptorProtos$ServiceOptions:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   291: aload_0
    //   292: invokevirtual 119	com/google/protobuf/DescriptorProtos$ServiceOptions:makeExtensionsImmutable	()V
    //   295: return
    //   296: new 121	java/lang/NullPointerException
    //   299: dup
    //   300: invokespecial 122	java/lang/NullPointerException:<init>	()V
    //   303: astore_1
    //   304: goto +5 -> 309
    //   307: aload_1
    //   308: athrow
    //   309: goto -2 -> 307
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	312	0	this	ServiceOptions
    //   0	312	1	paramCodedInputStream	CodedInputStream
    //   0	312	2	paramExtensionRegistryLite	ExtensionRegistryLite
    //   17	251	3	i	int
    //   36	113	4	j	int
    //   24	212	5	k	int
    //   27	178	6	m	int
    //   30	193	7	n	int
    //   14	181	8	i1	int
    //   11	273	9	localBuilder	UnknownFieldSet.Builder
    // Exception table:
    //   from	to	target	type
    //   32	38	199	finally
    //   68	81	199	finally
    //   102	113	199	finally
    //   130	148	199	finally
    //   163	173	199	finally
    //   182	190	199	finally
    //   208	221	199	finally
    //   226	232	199	finally
    //   32	38	203	java/io/IOException
    //   68	81	203	java/io/IOException
    //   102	113	203	java/io/IOException
    //   130	148	203	java/io/IOException
    //   163	173	203	java/io/IOException
    //   182	190	203	java/io/IOException
    //   32	38	221	com/google/protobuf/InvalidProtocolBufferException
    //   68	81	221	com/google/protobuf/InvalidProtocolBufferException
    //   102	113	221	com/google/protobuf/InvalidProtocolBufferException
    //   130	148	221	com/google/protobuf/InvalidProtocolBufferException
    //   163	173	221	com/google/protobuf/InvalidProtocolBufferException
    //   182	190	221	com/google/protobuf/InvalidProtocolBufferException
  }
  
  private DescriptorProtos$ServiceOptions(GeneratedMessageV3.ExtendableBuilder<ServiceOptions, ?> paramExtendableBuilder)
  {
    super(paramExtendableBuilder);
  }
  
  public static ServiceOptions getDefaultInstance()
  {
    return a;
  }
  
  public static final Descriptors.Descriptor getDescriptor()
  {
    return DescriptorProtos.N();
  }
  
  public static DescriptorProtos.ServiceOptions.Builder newBuilder()
  {
    return a.toBuilder();
  }
  
  public static DescriptorProtos.ServiceOptions.Builder newBuilder(ServiceOptions paramServiceOptions)
  {
    return a.toBuilder().a(paramServiceOptions);
  }
  
  public static ServiceOptions parseDelimitedFrom(InputStream paramInputStream)
  {
    return (ServiceOptions)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream);
  }
  
  public static ServiceOptions parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (ServiceOptions)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static ServiceOptions parseFrom(ByteString paramByteString)
  {
    return (ServiceOptions)PARSER.parseFrom(paramByteString);
  }
  
  public static ServiceOptions parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (ServiceOptions)PARSER.parseFrom(paramByteString, paramExtensionRegistryLite);
  }
  
  public static ServiceOptions parseFrom(CodedInputStream paramCodedInputStream)
  {
    return (ServiceOptions)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream);
  }
  
  public static ServiceOptions parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (ServiceOptions)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static ServiceOptions parseFrom(InputStream paramInputStream)
  {
    return (ServiceOptions)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream);
  }
  
  public static ServiceOptions parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (ServiceOptions)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static ServiceOptions parseFrom(ByteBuffer paramByteBuffer)
  {
    return (ServiceOptions)PARSER.parseFrom(paramByteBuffer);
  }
  
  public static ServiceOptions parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (ServiceOptions)PARSER.parseFrom(paramByteBuffer, paramExtensionRegistryLite);
  }
  
  public static ServiceOptions parseFrom(byte[] paramArrayOfByte)
  {
    return (ServiceOptions)PARSER.parseFrom(paramArrayOfByte);
  }
  
  public static ServiceOptions parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (ServiceOptions)PARSER.parseFrom(paramArrayOfByte, paramExtensionRegistryLite);
  }
  
  public static Parser<ServiceOptions> parser()
  {
    return PARSER;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof ServiceOptions)) {
      return super.equals(paramObject);
    }
    paramObject = (ServiceOptions)paramObject;
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
  
  public ServiceOptions getDefaultInstanceForType()
  {
    return a;
  }
  
  public boolean getDeprecated()
  {
    return this.deprecated_;
  }
  
  public Parser<ServiceOptions> getParserForType()
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
      i = CodedOutputStream.b(33, this.deprecated_) + 0;
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
      i = (j * 37 + 33) * 53 + Internal.a(getDeprecated());
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
    return DescriptorProtos.O().a(ServiceOptions.class, DescriptorProtos.ServiceOptions.Builder.class);
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
  
  public DescriptorProtos.ServiceOptions.Builder newBuilderForType()
  {
    return newBuilder();
  }
  
  protected DescriptorProtos.ServiceOptions.Builder newBuilderForType(GeneratedMessageV3.BuilderParent paramBuilderParent)
  {
    return new DescriptorProtos.ServiceOptions.Builder(paramBuilderParent, null);
  }
  
  protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter paramUnusedPrivateParameter)
  {
    return new ServiceOptions();
  }
  
  public DescriptorProtos.ServiceOptions.Builder toBuilder()
  {
    if (this == a) {
      return new DescriptorProtos.ServiceOptions.Builder(null);
    }
    return new DescriptorProtos.ServiceOptions.Builder(null).a(this);
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
  {
    GeneratedMessageV3.ExtendableMessage.ExtensionWriter localExtensionWriter = newExtensionWriter();
    if ((this.bitField0_ & 0x1) != 0) {
      paramCodedOutputStream.a(33, this.deprecated_);
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
 * Qualified Name:     com.google.protobuf.DescriptorProtos.ServiceOptions
 * JD-Core Version:    0.7.0.1
 */