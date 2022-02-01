package com.google.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class DescriptorProtos$MethodOptions
  extends GeneratedMessageV3.ExtendableMessage<MethodOptions>
  implements DescriptorProtos.MethodOptionsOrBuilder
{
  public static final int DEPRECATED_FIELD_NUMBER = 33;
  public static final int IDEMPOTENCY_LEVEL_FIELD_NUMBER = 34;
  @Deprecated
  public static final Parser<MethodOptions> PARSER = new DescriptorProtos.MethodOptions.1();
  public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
  private static final MethodOptions a = new MethodOptions();
  private static final long serialVersionUID = 0L;
  private int bitField0_;
  private boolean deprecated_;
  private int idempotencyLevel_;
  private byte memoizedIsInitialized = -1;
  private List<DescriptorProtos.UninterpretedOption> uninterpretedOption_;
  
  private DescriptorProtos$MethodOptions()
  {
    this.idempotencyLevel_ = 0;
    this.uninterpretedOption_ = Collections.emptyList();
  }
  
  /* Error */
  private DescriptorProtos$MethodOptions(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 38	com/google/protobuf/DescriptorProtos$MethodOptions:<init>	()V
    //   4: aload_2
    //   5: ifnull +390 -> 395
    //   8: invokestatic 69	com/google/protobuf/UnknownFieldSet:a	()Lcom/google/protobuf/UnknownFieldSet$Builder;
    //   11: astore 9
    //   13: iconst_0
    //   14: istore 8
    //   16: iconst_0
    //   17: istore_3
    //   18: iload 8
    //   20: ifne +344 -> 364
    //   23: iload_3
    //   24: istore 5
    //   26: iload_3
    //   27: istore 6
    //   29: iload_3
    //   30: istore 7
    //   32: aload_1
    //   33: invokevirtual 74	com/google/protobuf/CodedInputStream:a	()I
    //   36: istore 4
    //   38: iload 4
    //   40: ifeq +252 -> 292
    //   43: iload 4
    //   45: sipush 264
    //   48: if_icmpeq +205 -> 253
    //   51: iload 4
    //   53: sipush 272
    //   56: if_icmpeq +106 -> 162
    //   59: iload 4
    //   61: sipush 7994
    //   64: if_icmpeq +28 -> 92
    //   67: iload_3
    //   68: istore 5
    //   70: iload_3
    //   71: istore 6
    //   73: iload_3
    //   74: istore 7
    //   76: aload_0
    //   77: aload_1
    //   78: aload 9
    //   80: aload_2
    //   81: iload 4
    //   83: invokevirtual 78	com/google/protobuf/DescriptorProtos$MethodOptions:parseUnknownField	(Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/UnknownFieldSet$Builder;Lcom/google/protobuf/ExtensionRegistryLite;I)Z
    //   86: ifne -68 -> 18
    //   89: goto +203 -> 292
    //   92: iload_3
    //   93: istore 4
    //   95: iload_3
    //   96: iconst_4
    //   97: iand
    //   98: ifne +28 -> 126
    //   101: iload_3
    //   102: istore 5
    //   104: iload_3
    //   105: istore 6
    //   107: iload_3
    //   108: istore 7
    //   110: aload_0
    //   111: new 80	java/util/ArrayList
    //   114: dup
    //   115: invokespecial 81	java/util/ArrayList:<init>	()V
    //   118: putfield 59	com/google/protobuf/DescriptorProtos$MethodOptions:uninterpretedOption_	Ljava/util/List;
    //   121: iload_3
    //   122: iconst_4
    //   123: ior
    //   124: istore 4
    //   126: iload 4
    //   128: istore 5
    //   130: iload 4
    //   132: istore 6
    //   134: iload 4
    //   136: istore 7
    //   138: aload_0
    //   139: getfield 59	com/google/protobuf/DescriptorProtos$MethodOptions:uninterpretedOption_	Ljava/util/List;
    //   142: aload_1
    //   143: getstatic 84	com/google/protobuf/DescriptorProtos$UninterpretedOption:PARSER	Lcom/google/protobuf/Parser;
    //   146: aload_2
    //   147: invokevirtual 87	com/google/protobuf/CodedInputStream:a	(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   150: invokeinterface 93 2 0
    //   155: pop
    //   156: iload 4
    //   158: istore_3
    //   159: goto -141 -> 18
    //   162: iload_3
    //   163: istore 5
    //   165: iload_3
    //   166: istore 6
    //   168: iload_3
    //   169: istore 7
    //   171: aload_1
    //   172: invokevirtual 96	com/google/protobuf/CodedInputStream:n	()I
    //   175: istore 4
    //   177: iload_3
    //   178: istore 5
    //   180: iload_3
    //   181: istore 6
    //   183: iload_3
    //   184: istore 7
    //   186: iload 4
    //   188: invokestatic 102	com/google/protobuf/DescriptorProtos$MethodOptions$IdempotencyLevel:valueOf	(I)Lcom/google/protobuf/DescriptorProtos$MethodOptions$IdempotencyLevel;
    //   191: ifnonnull +25 -> 216
    //   194: iload_3
    //   195: istore 5
    //   197: iload_3
    //   198: istore 6
    //   200: iload_3
    //   201: istore 7
    //   203: aload 9
    //   205: bipush 34
    //   207: iload 4
    //   209: invokevirtual 107	com/google/protobuf/UnknownFieldSet$Builder:a	(II)Lcom/google/protobuf/UnknownFieldSet$Builder;
    //   212: pop
    //   213: goto -195 -> 18
    //   216: iload_3
    //   217: istore 5
    //   219: iload_3
    //   220: istore 6
    //   222: iload_3
    //   223: istore 7
    //   225: aload_0
    //   226: aload_0
    //   227: getfield 109	com/google/protobuf/DescriptorProtos$MethodOptions:bitField0_	I
    //   230: iconst_2
    //   231: ior
    //   232: putfield 109	com/google/protobuf/DescriptorProtos$MethodOptions:bitField0_	I
    //   235: iload_3
    //   236: istore 5
    //   238: iload_3
    //   239: istore 6
    //   241: iload_3
    //   242: istore 7
    //   244: aload_0
    //   245: iload 4
    //   247: putfield 51	com/google/protobuf/DescriptorProtos$MethodOptions:idempotencyLevel_	I
    //   250: goto -232 -> 18
    //   253: iload_3
    //   254: istore 5
    //   256: iload_3
    //   257: istore 6
    //   259: iload_3
    //   260: istore 7
    //   262: aload_0
    //   263: aload_0
    //   264: getfield 109	com/google/protobuf/DescriptorProtos$MethodOptions:bitField0_	I
    //   267: iconst_1
    //   268: ior
    //   269: putfield 109	com/google/protobuf/DescriptorProtos$MethodOptions:bitField0_	I
    //   272: iload_3
    //   273: istore 5
    //   275: iload_3
    //   276: istore 6
    //   278: iload_3
    //   279: istore 7
    //   281: aload_0
    //   282: aload_1
    //   283: invokevirtual 113	com/google/protobuf/CodedInputStream:i	()Z
    //   286: putfield 115	com/google/protobuf/DescriptorProtos$MethodOptions:deprecated_	Z
    //   289: goto -271 -> 18
    //   292: iconst_1
    //   293: istore 8
    //   295: goto -277 -> 18
    //   298: astore_1
    //   299: goto +32 -> 331
    //   302: astore_1
    //   303: iload 6
    //   305: istore 5
    //   307: new 62	com/google/protobuf/InvalidProtocolBufferException
    //   310: dup
    //   311: aload_1
    //   312: invokespecial 118	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/io/IOException;)V
    //   315: aload_0
    //   316: invokevirtual 122	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   319: athrow
    //   320: astore_1
    //   321: iload 7
    //   323: istore 5
    //   325: aload_1
    //   326: aload_0
    //   327: invokevirtual 122	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   330: athrow
    //   331: iload 5
    //   333: iconst_4
    //   334: iand
    //   335: ifeq +14 -> 349
    //   338: aload_0
    //   339: aload_0
    //   340: getfield 59	com/google/protobuf/DescriptorProtos$MethodOptions:uninterpretedOption_	Ljava/util/List;
    //   343: invokestatic 126	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   346: putfield 59	com/google/protobuf/DescriptorProtos$MethodOptions:uninterpretedOption_	Ljava/util/List;
    //   349: aload_0
    //   350: aload 9
    //   352: invokevirtual 129	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   355: putfield 133	com/google/protobuf/DescriptorProtos$MethodOptions:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   358: aload_0
    //   359: invokevirtual 136	com/google/protobuf/DescriptorProtos$MethodOptions:makeExtensionsImmutable	()V
    //   362: aload_1
    //   363: athrow
    //   364: iload_3
    //   365: iconst_4
    //   366: iand
    //   367: ifeq +14 -> 381
    //   370: aload_0
    //   371: aload_0
    //   372: getfield 59	com/google/protobuf/DescriptorProtos$MethodOptions:uninterpretedOption_	Ljava/util/List;
    //   375: invokestatic 126	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   378: putfield 59	com/google/protobuf/DescriptorProtos$MethodOptions:uninterpretedOption_	Ljava/util/List;
    //   381: aload_0
    //   382: aload 9
    //   384: invokevirtual 129	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   387: putfield 133	com/google/protobuf/DescriptorProtos$MethodOptions:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   390: aload_0
    //   391: invokevirtual 136	com/google/protobuf/DescriptorProtos$MethodOptions:makeExtensionsImmutable	()V
    //   394: return
    //   395: new 138	java/lang/NullPointerException
    //   398: dup
    //   399: invokespecial 139	java/lang/NullPointerException:<init>	()V
    //   402: astore_1
    //   403: goto +5 -> 408
    //   406: aload_1
    //   407: athrow
    //   408: goto -2 -> 406
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	411	0	this	MethodOptions
    //   0	411	1	paramCodedInputStream	CodedInputStream
    //   0	411	2	paramExtensionRegistryLite	ExtensionRegistryLite
    //   17	350	3	i	int
    //   36	210	4	j	int
    //   24	311	5	k	int
    //   27	277	6	m	int
    //   30	292	7	n	int
    //   14	280	8	i1	int
    //   11	372	9	localBuilder	UnknownFieldSet.Builder
    // Exception table:
    //   from	to	target	type
    //   32	38	298	finally
    //   76	89	298	finally
    //   110	121	298	finally
    //   138	156	298	finally
    //   171	177	298	finally
    //   186	194	298	finally
    //   203	213	298	finally
    //   225	235	298	finally
    //   244	250	298	finally
    //   262	272	298	finally
    //   281	289	298	finally
    //   307	320	298	finally
    //   325	331	298	finally
    //   32	38	302	java/io/IOException
    //   76	89	302	java/io/IOException
    //   110	121	302	java/io/IOException
    //   138	156	302	java/io/IOException
    //   171	177	302	java/io/IOException
    //   186	194	302	java/io/IOException
    //   203	213	302	java/io/IOException
    //   225	235	302	java/io/IOException
    //   244	250	302	java/io/IOException
    //   262	272	302	java/io/IOException
    //   281	289	302	java/io/IOException
    //   32	38	320	com/google/protobuf/InvalidProtocolBufferException
    //   76	89	320	com/google/protobuf/InvalidProtocolBufferException
    //   110	121	320	com/google/protobuf/InvalidProtocolBufferException
    //   138	156	320	com/google/protobuf/InvalidProtocolBufferException
    //   171	177	320	com/google/protobuf/InvalidProtocolBufferException
    //   186	194	320	com/google/protobuf/InvalidProtocolBufferException
    //   203	213	320	com/google/protobuf/InvalidProtocolBufferException
    //   225	235	320	com/google/protobuf/InvalidProtocolBufferException
    //   244	250	320	com/google/protobuf/InvalidProtocolBufferException
    //   262	272	320	com/google/protobuf/InvalidProtocolBufferException
    //   281	289	320	com/google/protobuf/InvalidProtocolBufferException
  }
  
  private DescriptorProtos$MethodOptions(GeneratedMessageV3.ExtendableBuilder<MethodOptions, ?> paramExtendableBuilder)
  {
    super(paramExtendableBuilder);
  }
  
  public static MethodOptions getDefaultInstance()
  {
    return a;
  }
  
  public static final Descriptors.Descriptor getDescriptor()
  {
    return DescriptorProtos.P();
  }
  
  public static DescriptorProtos.MethodOptions.Builder newBuilder()
  {
    return a.toBuilder();
  }
  
  public static DescriptorProtos.MethodOptions.Builder newBuilder(MethodOptions paramMethodOptions)
  {
    return a.toBuilder().a(paramMethodOptions);
  }
  
  public static MethodOptions parseDelimitedFrom(InputStream paramInputStream)
  {
    return (MethodOptions)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream);
  }
  
  public static MethodOptions parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (MethodOptions)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static MethodOptions parseFrom(ByteString paramByteString)
  {
    return (MethodOptions)PARSER.parseFrom(paramByteString);
  }
  
  public static MethodOptions parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (MethodOptions)PARSER.parseFrom(paramByteString, paramExtensionRegistryLite);
  }
  
  public static MethodOptions parseFrom(CodedInputStream paramCodedInputStream)
  {
    return (MethodOptions)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream);
  }
  
  public static MethodOptions parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (MethodOptions)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static MethodOptions parseFrom(InputStream paramInputStream)
  {
    return (MethodOptions)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream);
  }
  
  public static MethodOptions parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (MethodOptions)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static MethodOptions parseFrom(ByteBuffer paramByteBuffer)
  {
    return (MethodOptions)PARSER.parseFrom(paramByteBuffer);
  }
  
  public static MethodOptions parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (MethodOptions)PARSER.parseFrom(paramByteBuffer, paramExtensionRegistryLite);
  }
  
  public static MethodOptions parseFrom(byte[] paramArrayOfByte)
  {
    return (MethodOptions)PARSER.parseFrom(paramArrayOfByte);
  }
  
  public static MethodOptions parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (MethodOptions)PARSER.parseFrom(paramArrayOfByte, paramExtensionRegistryLite);
  }
  
  public static Parser<MethodOptions> parser()
  {
    return PARSER;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof MethodOptions)) {
      return super.equals(paramObject);
    }
    paramObject = (MethodOptions)paramObject;
    if (hasDeprecated() != paramObject.hasDeprecated()) {
      return false;
    }
    if ((hasDeprecated()) && (getDeprecated() != paramObject.getDeprecated())) {
      return false;
    }
    if (hasIdempotencyLevel() != paramObject.hasIdempotencyLevel()) {
      return false;
    }
    if ((hasIdempotencyLevel()) && (this.idempotencyLevel_ != paramObject.idempotencyLevel_)) {
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
  
  public MethodOptions getDefaultInstanceForType()
  {
    return a;
  }
  
  public boolean getDeprecated()
  {
    return this.deprecated_;
  }
  
  public DescriptorProtos.MethodOptions.IdempotencyLevel getIdempotencyLevel()
  {
    DescriptorProtos.MethodOptions.IdempotencyLevel localIdempotencyLevel2 = DescriptorProtos.MethodOptions.IdempotencyLevel.valueOf(this.idempotencyLevel_);
    DescriptorProtos.MethodOptions.IdempotencyLevel localIdempotencyLevel1 = localIdempotencyLevel2;
    if (localIdempotencyLevel2 == null) {
      localIdempotencyLevel1 = DescriptorProtos.MethodOptions.IdempotencyLevel.IDEMPOTENCY_UNKNOWN;
    }
    return localIdempotencyLevel1;
  }
  
  public Parser<MethodOptions> getParserForType()
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
      j = CodedOutputStream.b(33, this.deprecated_) + 0;
    } else {
      j = 0;
    }
    i = j;
    int k = m;
    if ((this.bitField0_ & 0x2) != 0)
    {
      i = j + CodedOutputStream.m(34, this.idempotencyLevel_);
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
  
  public boolean hasDeprecated()
  {
    return (this.bitField0_ & 0x1) != 0;
  }
  
  public boolean hasIdempotencyLevel()
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
    if (hasDeprecated()) {
      i = (j * 37 + 33) * 53 + Internal.a(getDeprecated());
    }
    j = i;
    if (hasIdempotencyLevel()) {
      j = (i * 37 + 34) * 53 + this.idempotencyLevel_;
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
    return DescriptorProtos.Q().a(MethodOptions.class, DescriptorProtos.MethodOptions.Builder.class);
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
  
  public DescriptorProtos.MethodOptions.Builder newBuilderForType()
  {
    return newBuilder();
  }
  
  protected DescriptorProtos.MethodOptions.Builder newBuilderForType(GeneratedMessageV3.BuilderParent paramBuilderParent)
  {
    return new DescriptorProtos.MethodOptions.Builder(paramBuilderParent, null);
  }
  
  protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter paramUnusedPrivateParameter)
  {
    return new MethodOptions();
  }
  
  public DescriptorProtos.MethodOptions.Builder toBuilder()
  {
    if (this == a) {
      return new DescriptorProtos.MethodOptions.Builder(null);
    }
    return new DescriptorProtos.MethodOptions.Builder(null).a(this);
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
  {
    GeneratedMessageV3.ExtendableMessage.ExtensionWriter localExtensionWriter = newExtensionWriter();
    if ((this.bitField0_ & 0x1) != 0) {
      paramCodedOutputStream.a(33, this.deprecated_);
    }
    if ((this.bitField0_ & 0x2) != 0) {
      paramCodedOutputStream.g(34, this.idempotencyLevel_);
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
 * Qualified Name:     com.google.protobuf.DescriptorProtos.MethodOptions
 * JD-Core Version:    0.7.0.1
 */