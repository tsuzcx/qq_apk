package com.google.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class DescriptorProtos$OneofOptions
  extends GeneratedMessageV3.ExtendableMessage<OneofOptions>
  implements DescriptorProtos.OneofOptionsOrBuilder
{
  @Deprecated
  public static final Parser<OneofOptions> PARSER = new DescriptorProtos.OneofOptions.1();
  public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
  private static final OneofOptions a = new OneofOptions();
  private static final long serialVersionUID = 0L;
  private byte memoizedIsInitialized = -1;
  private List<DescriptorProtos.UninterpretedOption> uninterpretedOption_;
  
  private DescriptorProtos$OneofOptions()
  {
    this.uninterpretedOption_ = Collections.emptyList();
  }
  
  /* Error */
  private DescriptorProtos$OneofOptions(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 30	com/google/protobuf/DescriptorProtos$OneofOptions:<init>	()V
    //   4: aload_2
    //   5: ifnull +244 -> 249
    //   8: invokestatic 59	com/google/protobuf/UnknownFieldSet:a	()Lcom/google/protobuf/UnknownFieldSet$Builder;
    //   11: astore 9
    //   13: iconst_0
    //   14: istore 8
    //   16: iconst_0
    //   17: istore_3
    //   18: iload 8
    //   20: ifne +198 -> 218
    //   23: iload_3
    //   24: istore 5
    //   26: iload_3
    //   27: istore 6
    //   29: iload_3
    //   30: istore 7
    //   32: aload_1
    //   33: invokevirtual 64	com/google/protobuf/CodedInputStream:a	()I
    //   36: istore 4
    //   38: iload 4
    //   40: ifeq +106 -> 146
    //   43: iload 4
    //   45: sipush 7994
    //   48: if_icmpeq +28 -> 76
    //   51: iload_3
    //   52: istore 5
    //   54: iload_3
    //   55: istore 6
    //   57: iload_3
    //   58: istore 7
    //   60: aload_0
    //   61: aload_1
    //   62: aload 9
    //   64: aload_2
    //   65: iload 4
    //   67: invokevirtual 68	com/google/protobuf/DescriptorProtos$OneofOptions:parseUnknownField	(Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/UnknownFieldSet$Builder;Lcom/google/protobuf/ExtensionRegistryLite;I)Z
    //   70: ifne -52 -> 18
    //   73: goto +73 -> 146
    //   76: iload_3
    //   77: istore 4
    //   79: iload_3
    //   80: iconst_1
    //   81: iand
    //   82: ifne +28 -> 110
    //   85: iload_3
    //   86: istore 5
    //   88: iload_3
    //   89: istore 6
    //   91: iload_3
    //   92: istore 7
    //   94: aload_0
    //   95: new 70	java/util/ArrayList
    //   98: dup
    //   99: invokespecial 71	java/util/ArrayList:<init>	()V
    //   102: putfield 49	com/google/protobuf/DescriptorProtos$OneofOptions:uninterpretedOption_	Ljava/util/List;
    //   105: iload_3
    //   106: iconst_1
    //   107: ior
    //   108: istore 4
    //   110: iload 4
    //   112: istore 5
    //   114: iload 4
    //   116: istore 6
    //   118: iload 4
    //   120: istore 7
    //   122: aload_0
    //   123: getfield 49	com/google/protobuf/DescriptorProtos$OneofOptions:uninterpretedOption_	Ljava/util/List;
    //   126: aload_1
    //   127: getstatic 74	com/google/protobuf/DescriptorProtos$UninterpretedOption:PARSER	Lcom/google/protobuf/Parser;
    //   130: aload_2
    //   131: invokevirtual 77	com/google/protobuf/CodedInputStream:a	(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   134: invokeinterface 83 2 0
    //   139: pop
    //   140: iload 4
    //   142: istore_3
    //   143: goto -125 -> 18
    //   146: iconst_1
    //   147: istore 8
    //   149: goto -131 -> 18
    //   152: astore_1
    //   153: goto +32 -> 185
    //   156: astore_1
    //   157: iload 6
    //   159: istore 5
    //   161: new 52	com/google/protobuf/InvalidProtocolBufferException
    //   164: dup
    //   165: aload_1
    //   166: invokespecial 86	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/io/IOException;)V
    //   169: aload_0
    //   170: invokevirtual 90	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   173: athrow
    //   174: astore_1
    //   175: iload 7
    //   177: istore 5
    //   179: aload_1
    //   180: aload_0
    //   181: invokevirtual 90	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   184: athrow
    //   185: iload 5
    //   187: iconst_1
    //   188: iand
    //   189: ifeq +14 -> 203
    //   192: aload_0
    //   193: aload_0
    //   194: getfield 49	com/google/protobuf/DescriptorProtos$OneofOptions:uninterpretedOption_	Ljava/util/List;
    //   197: invokestatic 94	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   200: putfield 49	com/google/protobuf/DescriptorProtos$OneofOptions:uninterpretedOption_	Ljava/util/List;
    //   203: aload_0
    //   204: aload 9
    //   206: invokevirtual 99	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   209: putfield 103	com/google/protobuf/DescriptorProtos$OneofOptions:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   212: aload_0
    //   213: invokevirtual 106	com/google/protobuf/DescriptorProtos$OneofOptions:makeExtensionsImmutable	()V
    //   216: aload_1
    //   217: athrow
    //   218: iload_3
    //   219: iconst_1
    //   220: iand
    //   221: ifeq +14 -> 235
    //   224: aload_0
    //   225: aload_0
    //   226: getfield 49	com/google/protobuf/DescriptorProtos$OneofOptions:uninterpretedOption_	Ljava/util/List;
    //   229: invokestatic 94	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   232: putfield 49	com/google/protobuf/DescriptorProtos$OneofOptions:uninterpretedOption_	Ljava/util/List;
    //   235: aload_0
    //   236: aload 9
    //   238: invokevirtual 99	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   241: putfield 103	com/google/protobuf/DescriptorProtos$OneofOptions:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   244: aload_0
    //   245: invokevirtual 106	com/google/protobuf/DescriptorProtos$OneofOptions:makeExtensionsImmutable	()V
    //   248: return
    //   249: new 108	java/lang/NullPointerException
    //   252: dup
    //   253: invokespecial 109	java/lang/NullPointerException:<init>	()V
    //   256: astore_1
    //   257: goto +5 -> 262
    //   260: aload_1
    //   261: athrow
    //   262: goto -2 -> 260
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	265	0	this	OneofOptions
    //   0	265	1	paramCodedInputStream	CodedInputStream
    //   0	265	2	paramExtensionRegistryLite	ExtensionRegistryLite
    //   17	204	3	i	int
    //   36	105	4	j	int
    //   24	165	5	k	int
    //   27	131	6	m	int
    //   30	146	7	n	int
    //   14	134	8	i1	int
    //   11	226	9	localBuilder	UnknownFieldSet.Builder
    // Exception table:
    //   from	to	target	type
    //   32	38	152	finally
    //   60	73	152	finally
    //   94	105	152	finally
    //   122	140	152	finally
    //   161	174	152	finally
    //   179	185	152	finally
    //   32	38	156	java/io/IOException
    //   60	73	156	java/io/IOException
    //   94	105	156	java/io/IOException
    //   122	140	156	java/io/IOException
    //   32	38	174	com/google/protobuf/InvalidProtocolBufferException
    //   60	73	174	com/google/protobuf/InvalidProtocolBufferException
    //   94	105	174	com/google/protobuf/InvalidProtocolBufferException
    //   122	140	174	com/google/protobuf/InvalidProtocolBufferException
  }
  
  private DescriptorProtos$OneofOptions(GeneratedMessageV3.ExtendableBuilder<OneofOptions, ?> paramExtendableBuilder)
  {
    super(paramExtendableBuilder);
  }
  
  public static OneofOptions getDefaultInstance()
  {
    return a;
  }
  
  public static final Descriptors.Descriptor getDescriptor()
  {
    return DescriptorProtos.H();
  }
  
  public static DescriptorProtos.OneofOptions.Builder newBuilder()
  {
    return a.toBuilder();
  }
  
  public static DescriptorProtos.OneofOptions.Builder newBuilder(OneofOptions paramOneofOptions)
  {
    return a.toBuilder().a(paramOneofOptions);
  }
  
  public static OneofOptions parseDelimitedFrom(InputStream paramInputStream)
  {
    return (OneofOptions)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream);
  }
  
  public static OneofOptions parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (OneofOptions)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static OneofOptions parseFrom(ByteString paramByteString)
  {
    return (OneofOptions)PARSER.parseFrom(paramByteString);
  }
  
  public static OneofOptions parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (OneofOptions)PARSER.parseFrom(paramByteString, paramExtensionRegistryLite);
  }
  
  public static OneofOptions parseFrom(CodedInputStream paramCodedInputStream)
  {
    return (OneofOptions)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream);
  }
  
  public static OneofOptions parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (OneofOptions)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static OneofOptions parseFrom(InputStream paramInputStream)
  {
    return (OneofOptions)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream);
  }
  
  public static OneofOptions parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (OneofOptions)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static OneofOptions parseFrom(ByteBuffer paramByteBuffer)
  {
    return (OneofOptions)PARSER.parseFrom(paramByteBuffer);
  }
  
  public static OneofOptions parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (OneofOptions)PARSER.parseFrom(paramByteBuffer, paramExtensionRegistryLite);
  }
  
  public static OneofOptions parseFrom(byte[] paramArrayOfByte)
  {
    return (OneofOptions)PARSER.parseFrom(paramArrayOfByte);
  }
  
  public static OneofOptions parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (OneofOptions)PARSER.parseFrom(paramArrayOfByte, paramExtensionRegistryLite);
  }
  
  public static Parser<OneofOptions> parser()
  {
    return PARSER;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof OneofOptions)) {
      return super.equals(paramObject);
    }
    paramObject = (OneofOptions)paramObject;
    if (!getUninterpretedOptionList().equals(paramObject.getUninterpretedOptionList())) {
      return false;
    }
    if (!this.unknownFields.equals(paramObject.unknownFields)) {
      return false;
    }
    return getExtensionFields().equals(paramObject.getExtensionFields());
  }
  
  public OneofOptions getDefaultInstanceForType()
  {
    return a;
  }
  
  public Parser<OneofOptions> getParserForType()
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
    int j = 0;
    while (i < this.uninterpretedOption_.size())
    {
      j += CodedOutputStream.c(999, (MessageLite)this.uninterpretedOption_.get(i));
      i += 1;
    }
    i = j + extensionsSerializedSize() + this.unknownFields.getSerializedSize();
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
  
  public int hashCode()
  {
    if (this.memoizedHashCode != 0) {
      return this.memoizedHashCode;
    }
    int j = 779 + getDescriptor().hashCode();
    int i = j;
    if (getUninterpretedOptionCount() > 0) {
      i = (j * 37 + 999) * 53 + getUninterpretedOptionList().hashCode();
    }
    i = hashFields(i, getExtensionFields()) * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    return i;
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return DescriptorProtos.I().a(OneofOptions.class, DescriptorProtos.OneofOptions.Builder.class);
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
  
  public DescriptorProtos.OneofOptions.Builder newBuilderForType()
  {
    return newBuilder();
  }
  
  protected DescriptorProtos.OneofOptions.Builder newBuilderForType(GeneratedMessageV3.BuilderParent paramBuilderParent)
  {
    return new DescriptorProtos.OneofOptions.Builder(paramBuilderParent, null);
  }
  
  protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter paramUnusedPrivateParameter)
  {
    return new OneofOptions();
  }
  
  public DescriptorProtos.OneofOptions.Builder toBuilder()
  {
    if (this == a) {
      return new DescriptorProtos.OneofOptions.Builder(null);
    }
    return new DescriptorProtos.OneofOptions.Builder(null).a(this);
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
  {
    GeneratedMessageV3.ExtendableMessage.ExtensionWriter localExtensionWriter = newExtensionWriter();
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
 * Qualified Name:     com.google.protobuf.DescriptorProtos.OneofOptions
 * JD-Core Version:    0.7.0.1
 */