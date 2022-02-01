package com.google.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class DescriptorProtos$MessageOptions
  extends GeneratedMessageV3.ExtendableMessage<MessageOptions>
  implements DescriptorProtos.MessageOptionsOrBuilder
{
  public static final int DEPRECATED_FIELD_NUMBER = 3;
  public static final int MAP_ENTRY_FIELD_NUMBER = 7;
  public static final int MESSAGE_SET_WIRE_FORMAT_FIELD_NUMBER = 1;
  public static final int NO_STANDARD_DESCRIPTOR_ACCESSOR_FIELD_NUMBER = 2;
  @Deprecated
  public static final Parser<MessageOptions> PARSER = new DescriptorProtos.MessageOptions.1();
  public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
  private static final MessageOptions a = new MessageOptions();
  private static final long serialVersionUID = 0L;
  private int bitField0_;
  private boolean deprecated_;
  private boolean mapEntry_;
  private byte memoizedIsInitialized = -1;
  private boolean messageSetWireFormat_;
  private boolean noStandardDescriptorAccessor_;
  private List<DescriptorProtos.UninterpretedOption> uninterpretedOption_;
  
  private DescriptorProtos$MessageOptions()
  {
    this.uninterpretedOption_ = Collections.emptyList();
  }
  
  /* Error */
  private DescriptorProtos$MessageOptions(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 44	com/google/protobuf/DescriptorProtos$MessageOptions:<init>	()V
    //   4: aload_2
    //   5: ifnull +433 -> 438
    //   8: invokestatic 73	com/google/protobuf/UnknownFieldSet:a	()Lcom/google/protobuf/UnknownFieldSet$Builder;
    //   11: astore 9
    //   13: iconst_0
    //   14: istore 8
    //   16: iconst_0
    //   17: istore_3
    //   18: iload 8
    //   20: ifne +386 -> 406
    //   23: iload_3
    //   24: istore 5
    //   26: iload_3
    //   27: istore 6
    //   29: iload_3
    //   30: istore 7
    //   32: aload_1
    //   33: invokevirtual 78	com/google/protobuf/CodedInputStream:a	()I
    //   36: istore 4
    //   38: iload 4
    //   40: ifeq +293 -> 333
    //   43: iload 4
    //   45: bipush 8
    //   47: if_icmpeq +247 -> 294
    //   50: iload 4
    //   52: bipush 16
    //   54: if_icmpeq +201 -> 255
    //   57: iload 4
    //   59: bipush 24
    //   61: if_icmpeq +155 -> 216
    //   64: iload 4
    //   66: bipush 56
    //   68: if_icmpeq +108 -> 176
    //   71: iload 4
    //   73: sipush 7994
    //   76: if_icmpeq +28 -> 104
    //   79: iload_3
    //   80: istore 5
    //   82: iload_3
    //   83: istore 6
    //   85: iload_3
    //   86: istore 7
    //   88: aload_0
    //   89: aload_1
    //   90: aload 9
    //   92: aload_2
    //   93: iload 4
    //   95: invokevirtual 82	com/google/protobuf/DescriptorProtos$MessageOptions:parseUnknownField	(Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/UnknownFieldSet$Builder;Lcom/google/protobuf/ExtensionRegistryLite;I)Z
    //   98: ifne -80 -> 18
    //   101: goto +232 -> 333
    //   104: iload_3
    //   105: istore 4
    //   107: iload_3
    //   108: bipush 16
    //   110: iand
    //   111: ifne +29 -> 140
    //   114: iload_3
    //   115: istore 5
    //   117: iload_3
    //   118: istore 6
    //   120: iload_3
    //   121: istore 7
    //   123: aload_0
    //   124: new 84	java/util/ArrayList
    //   127: dup
    //   128: invokespecial 85	java/util/ArrayList:<init>	()V
    //   131: putfield 63	com/google/protobuf/DescriptorProtos$MessageOptions:uninterpretedOption_	Ljava/util/List;
    //   134: iload_3
    //   135: bipush 16
    //   137: ior
    //   138: istore 4
    //   140: iload 4
    //   142: istore 5
    //   144: iload 4
    //   146: istore 6
    //   148: iload 4
    //   150: istore 7
    //   152: aload_0
    //   153: getfield 63	com/google/protobuf/DescriptorProtos$MessageOptions:uninterpretedOption_	Ljava/util/List;
    //   156: aload_1
    //   157: getstatic 88	com/google/protobuf/DescriptorProtos$UninterpretedOption:PARSER	Lcom/google/protobuf/Parser;
    //   160: aload_2
    //   161: invokevirtual 91	com/google/protobuf/CodedInputStream:a	(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   164: invokeinterface 97 2 0
    //   169: pop
    //   170: iload 4
    //   172: istore_3
    //   173: goto -155 -> 18
    //   176: iload_3
    //   177: istore 5
    //   179: iload_3
    //   180: istore 6
    //   182: iload_3
    //   183: istore 7
    //   185: aload_0
    //   186: aload_0
    //   187: getfield 99	com/google/protobuf/DescriptorProtos$MessageOptions:bitField0_	I
    //   190: bipush 8
    //   192: ior
    //   193: putfield 99	com/google/protobuf/DescriptorProtos$MessageOptions:bitField0_	I
    //   196: iload_3
    //   197: istore 5
    //   199: iload_3
    //   200: istore 6
    //   202: iload_3
    //   203: istore 7
    //   205: aload_0
    //   206: aload_1
    //   207: invokevirtual 103	com/google/protobuf/CodedInputStream:i	()Z
    //   210: putfield 105	com/google/protobuf/DescriptorProtos$MessageOptions:mapEntry_	Z
    //   213: goto -195 -> 18
    //   216: iload_3
    //   217: istore 5
    //   219: iload_3
    //   220: istore 6
    //   222: iload_3
    //   223: istore 7
    //   225: aload_0
    //   226: aload_0
    //   227: getfield 99	com/google/protobuf/DescriptorProtos$MessageOptions:bitField0_	I
    //   230: iconst_4
    //   231: ior
    //   232: putfield 99	com/google/protobuf/DescriptorProtos$MessageOptions:bitField0_	I
    //   235: iload_3
    //   236: istore 5
    //   238: iload_3
    //   239: istore 6
    //   241: iload_3
    //   242: istore 7
    //   244: aload_0
    //   245: aload_1
    //   246: invokevirtual 103	com/google/protobuf/CodedInputStream:i	()Z
    //   249: putfield 107	com/google/protobuf/DescriptorProtos$MessageOptions:deprecated_	Z
    //   252: goto -234 -> 18
    //   255: iload_3
    //   256: istore 5
    //   258: iload_3
    //   259: istore 6
    //   261: iload_3
    //   262: istore 7
    //   264: aload_0
    //   265: aload_0
    //   266: getfield 99	com/google/protobuf/DescriptorProtos$MessageOptions:bitField0_	I
    //   269: iconst_2
    //   270: ior
    //   271: putfield 99	com/google/protobuf/DescriptorProtos$MessageOptions:bitField0_	I
    //   274: iload_3
    //   275: istore 5
    //   277: iload_3
    //   278: istore 6
    //   280: iload_3
    //   281: istore 7
    //   283: aload_0
    //   284: aload_1
    //   285: invokevirtual 103	com/google/protobuf/CodedInputStream:i	()Z
    //   288: putfield 109	com/google/protobuf/DescriptorProtos$MessageOptions:noStandardDescriptorAccessor_	Z
    //   291: goto -273 -> 18
    //   294: iload_3
    //   295: istore 5
    //   297: iload_3
    //   298: istore 6
    //   300: iload_3
    //   301: istore 7
    //   303: aload_0
    //   304: aload_0
    //   305: getfield 99	com/google/protobuf/DescriptorProtos$MessageOptions:bitField0_	I
    //   308: iconst_1
    //   309: ior
    //   310: putfield 99	com/google/protobuf/DescriptorProtos$MessageOptions:bitField0_	I
    //   313: iload_3
    //   314: istore 5
    //   316: iload_3
    //   317: istore 6
    //   319: iload_3
    //   320: istore 7
    //   322: aload_0
    //   323: aload_1
    //   324: invokevirtual 103	com/google/protobuf/CodedInputStream:i	()Z
    //   327: putfield 111	com/google/protobuf/DescriptorProtos$MessageOptions:messageSetWireFormat_	Z
    //   330: goto -312 -> 18
    //   333: iconst_1
    //   334: istore 8
    //   336: goto -318 -> 18
    //   339: astore_1
    //   340: goto +32 -> 372
    //   343: astore_1
    //   344: iload 6
    //   346: istore 5
    //   348: new 66	com/google/protobuf/InvalidProtocolBufferException
    //   351: dup
    //   352: aload_1
    //   353: invokespecial 114	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/io/IOException;)V
    //   356: aload_0
    //   357: invokevirtual 118	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   360: athrow
    //   361: astore_1
    //   362: iload 7
    //   364: istore 5
    //   366: aload_1
    //   367: aload_0
    //   368: invokevirtual 118	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   371: athrow
    //   372: iload 5
    //   374: bipush 16
    //   376: iand
    //   377: ifeq +14 -> 391
    //   380: aload_0
    //   381: aload_0
    //   382: getfield 63	com/google/protobuf/DescriptorProtos$MessageOptions:uninterpretedOption_	Ljava/util/List;
    //   385: invokestatic 122	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   388: putfield 63	com/google/protobuf/DescriptorProtos$MessageOptions:uninterpretedOption_	Ljava/util/List;
    //   391: aload_0
    //   392: aload 9
    //   394: invokevirtual 127	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   397: putfield 131	com/google/protobuf/DescriptorProtos$MessageOptions:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   400: aload_0
    //   401: invokevirtual 134	com/google/protobuf/DescriptorProtos$MessageOptions:makeExtensionsImmutable	()V
    //   404: aload_1
    //   405: athrow
    //   406: iload_3
    //   407: bipush 16
    //   409: iand
    //   410: ifeq +14 -> 424
    //   413: aload_0
    //   414: aload_0
    //   415: getfield 63	com/google/protobuf/DescriptorProtos$MessageOptions:uninterpretedOption_	Ljava/util/List;
    //   418: invokestatic 122	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   421: putfield 63	com/google/protobuf/DescriptorProtos$MessageOptions:uninterpretedOption_	Ljava/util/List;
    //   424: aload_0
    //   425: aload 9
    //   427: invokevirtual 127	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   430: putfield 131	com/google/protobuf/DescriptorProtos$MessageOptions:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   433: aload_0
    //   434: invokevirtual 134	com/google/protobuf/DescriptorProtos$MessageOptions:makeExtensionsImmutable	()V
    //   437: return
    //   438: new 136	java/lang/NullPointerException
    //   441: dup
    //   442: invokespecial 137	java/lang/NullPointerException:<init>	()V
    //   445: astore_1
    //   446: goto +5 -> 451
    //   449: aload_1
    //   450: athrow
    //   451: goto -2 -> 449
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	454	0	this	MessageOptions
    //   0	454	1	paramCodedInputStream	CodedInputStream
    //   0	454	2	paramExtensionRegistryLite	ExtensionRegistryLite
    //   17	393	3	i	int
    //   36	135	4	j	int
    //   24	353	5	k	int
    //   27	318	6	m	int
    //   30	333	7	n	int
    //   14	321	8	i1	int
    //   11	415	9	localBuilder	UnknownFieldSet.Builder
    // Exception table:
    //   from	to	target	type
    //   32	38	339	finally
    //   88	101	339	finally
    //   123	134	339	finally
    //   152	170	339	finally
    //   185	196	339	finally
    //   205	213	339	finally
    //   225	235	339	finally
    //   244	252	339	finally
    //   264	274	339	finally
    //   283	291	339	finally
    //   303	313	339	finally
    //   322	330	339	finally
    //   348	361	339	finally
    //   366	372	339	finally
    //   32	38	343	java/io/IOException
    //   88	101	343	java/io/IOException
    //   123	134	343	java/io/IOException
    //   152	170	343	java/io/IOException
    //   185	196	343	java/io/IOException
    //   205	213	343	java/io/IOException
    //   225	235	343	java/io/IOException
    //   244	252	343	java/io/IOException
    //   264	274	343	java/io/IOException
    //   283	291	343	java/io/IOException
    //   303	313	343	java/io/IOException
    //   322	330	343	java/io/IOException
    //   32	38	361	com/google/protobuf/InvalidProtocolBufferException
    //   88	101	361	com/google/protobuf/InvalidProtocolBufferException
    //   123	134	361	com/google/protobuf/InvalidProtocolBufferException
    //   152	170	361	com/google/protobuf/InvalidProtocolBufferException
    //   185	196	361	com/google/protobuf/InvalidProtocolBufferException
    //   205	213	361	com/google/protobuf/InvalidProtocolBufferException
    //   225	235	361	com/google/protobuf/InvalidProtocolBufferException
    //   244	252	361	com/google/protobuf/InvalidProtocolBufferException
    //   264	274	361	com/google/protobuf/InvalidProtocolBufferException
    //   283	291	361	com/google/protobuf/InvalidProtocolBufferException
    //   303	313	361	com/google/protobuf/InvalidProtocolBufferException
    //   322	330	361	com/google/protobuf/InvalidProtocolBufferException
  }
  
  private DescriptorProtos$MessageOptions(GeneratedMessageV3.ExtendableBuilder<MessageOptions, ?> paramExtendableBuilder)
  {
    super(paramExtendableBuilder);
  }
  
  public static MessageOptions getDefaultInstance()
  {
    return a;
  }
  
  public static final Descriptors.Descriptor getDescriptor()
  {
    return DescriptorProtos.D();
  }
  
  public static DescriptorProtos.MessageOptions.Builder newBuilder()
  {
    return a.toBuilder();
  }
  
  public static DescriptorProtos.MessageOptions.Builder newBuilder(MessageOptions paramMessageOptions)
  {
    return a.toBuilder().a(paramMessageOptions);
  }
  
  public static MessageOptions parseDelimitedFrom(InputStream paramInputStream)
  {
    return (MessageOptions)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream);
  }
  
  public static MessageOptions parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (MessageOptions)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static MessageOptions parseFrom(ByteString paramByteString)
  {
    return (MessageOptions)PARSER.parseFrom(paramByteString);
  }
  
  public static MessageOptions parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (MessageOptions)PARSER.parseFrom(paramByteString, paramExtensionRegistryLite);
  }
  
  public static MessageOptions parseFrom(CodedInputStream paramCodedInputStream)
  {
    return (MessageOptions)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream);
  }
  
  public static MessageOptions parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (MessageOptions)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static MessageOptions parseFrom(InputStream paramInputStream)
  {
    return (MessageOptions)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream);
  }
  
  public static MessageOptions parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (MessageOptions)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static MessageOptions parseFrom(ByteBuffer paramByteBuffer)
  {
    return (MessageOptions)PARSER.parseFrom(paramByteBuffer);
  }
  
  public static MessageOptions parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (MessageOptions)PARSER.parseFrom(paramByteBuffer, paramExtensionRegistryLite);
  }
  
  public static MessageOptions parseFrom(byte[] paramArrayOfByte)
  {
    return (MessageOptions)PARSER.parseFrom(paramArrayOfByte);
  }
  
  public static MessageOptions parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (MessageOptions)PARSER.parseFrom(paramArrayOfByte, paramExtensionRegistryLite);
  }
  
  public static Parser<MessageOptions> parser()
  {
    return PARSER;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof MessageOptions)) {
      return super.equals(paramObject);
    }
    paramObject = (MessageOptions)paramObject;
    if (hasMessageSetWireFormat() != paramObject.hasMessageSetWireFormat()) {
      return false;
    }
    if ((hasMessageSetWireFormat()) && (getMessageSetWireFormat() != paramObject.getMessageSetWireFormat())) {
      return false;
    }
    if (hasNoStandardDescriptorAccessor() != paramObject.hasNoStandardDescriptorAccessor()) {
      return false;
    }
    if ((hasNoStandardDescriptorAccessor()) && (getNoStandardDescriptorAccessor() != paramObject.getNoStandardDescriptorAccessor())) {
      return false;
    }
    if (hasDeprecated() != paramObject.hasDeprecated()) {
      return false;
    }
    if ((hasDeprecated()) && (getDeprecated() != paramObject.getDeprecated())) {
      return false;
    }
    if (hasMapEntry() != paramObject.hasMapEntry()) {
      return false;
    }
    if ((hasMapEntry()) && (getMapEntry() != paramObject.getMapEntry())) {
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
  
  public MessageOptions getDefaultInstanceForType()
  {
    return a;
  }
  
  public boolean getDeprecated()
  {
    return this.deprecated_;
  }
  
  public boolean getMapEntry()
  {
    return this.mapEntry_;
  }
  
  public boolean getMessageSetWireFormat()
  {
    return this.messageSetWireFormat_;
  }
  
  public boolean getNoStandardDescriptorAccessor()
  {
    return this.noStandardDescriptorAccessor_;
  }
  
  public Parser<MessageOptions> getParserForType()
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
    if ((i & 0x1) != 0) {
      i = CodedOutputStream.b(1, this.messageSetWireFormat_) + 0;
    } else {
      i = 0;
    }
    int j = i;
    if ((this.bitField0_ & 0x2) != 0) {
      j = i + CodedOutputStream.b(2, this.noStandardDescriptorAccessor_);
    }
    i = j;
    if ((this.bitField0_ & 0x4) != 0) {
      i = j + CodedOutputStream.b(3, this.deprecated_);
    }
    j = i;
    int k = m;
    if ((this.bitField0_ & 0x8) != 0)
    {
      j = i + CodedOutputStream.b(7, this.mapEntry_);
      k = m;
    }
    while (k < this.uninterpretedOption_.size())
    {
      j += CodedOutputStream.c(999, (MessageLite)this.uninterpretedOption_.get(k));
      k += 1;
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
  
  public boolean hasDeprecated()
  {
    return (this.bitField0_ & 0x4) != 0;
  }
  
  public boolean hasMapEntry()
  {
    return (this.bitField0_ & 0x8) != 0;
  }
  
  public boolean hasMessageSetWireFormat()
  {
    return (this.bitField0_ & 0x1) != 0;
  }
  
  public boolean hasNoStandardDescriptorAccessor()
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
    if (hasMessageSetWireFormat()) {
      i = (j * 37 + 1) * 53 + Internal.a(getMessageSetWireFormat());
    }
    j = i;
    if (hasNoStandardDescriptorAccessor()) {
      j = (i * 37 + 2) * 53 + Internal.a(getNoStandardDescriptorAccessor());
    }
    i = j;
    if (hasDeprecated()) {
      i = (j * 37 + 3) * 53 + Internal.a(getDeprecated());
    }
    j = i;
    if (hasMapEntry()) {
      j = (i * 37 + 7) * 53 + Internal.a(getMapEntry());
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
    return DescriptorProtos.E().a(MessageOptions.class, DescriptorProtos.MessageOptions.Builder.class);
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
  
  public DescriptorProtos.MessageOptions.Builder newBuilderForType()
  {
    return newBuilder();
  }
  
  protected DescriptorProtos.MessageOptions.Builder newBuilderForType(GeneratedMessageV3.BuilderParent paramBuilderParent)
  {
    return new DescriptorProtos.MessageOptions.Builder(paramBuilderParent, null);
  }
  
  protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter paramUnusedPrivateParameter)
  {
    return new MessageOptions();
  }
  
  public DescriptorProtos.MessageOptions.Builder toBuilder()
  {
    if (this == a) {
      return new DescriptorProtos.MessageOptions.Builder(null);
    }
    return new DescriptorProtos.MessageOptions.Builder(null).a(this);
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
  {
    GeneratedMessageV3.ExtendableMessage.ExtensionWriter localExtensionWriter = newExtensionWriter();
    if ((this.bitField0_ & 0x1) != 0) {
      paramCodedOutputStream.a(1, this.messageSetWireFormat_);
    }
    if ((this.bitField0_ & 0x2) != 0) {
      paramCodedOutputStream.a(2, this.noStandardDescriptorAccessor_);
    }
    if ((this.bitField0_ & 0x4) != 0) {
      paramCodedOutputStream.a(3, this.deprecated_);
    }
    if ((this.bitField0_ & 0x8) != 0) {
      paramCodedOutputStream.a(7, this.mapEntry_);
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
 * Qualified Name:     com.google.protobuf.DescriptorProtos.MessageOptions
 * JD-Core Version:    0.7.0.1
 */