package com.google.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

public final class EnumValue
  extends GeneratedMessageV3
  implements EnumValueOrBuilder
{
  public static final int NAME_FIELD_NUMBER = 1;
  public static final int NUMBER_FIELD_NUMBER = 2;
  public static final int OPTIONS_FIELD_NUMBER = 3;
  private static final EnumValue a = new EnumValue();
  private static final Parser<EnumValue> b = new EnumValue.1();
  private static final long serialVersionUID = 0L;
  private byte memoizedIsInitialized = -1;
  private volatile Object name_;
  private int number_;
  private List<Option> options_;
  
  private EnumValue()
  {
    this.name_ = "";
    this.options_ = Collections.emptyList();
  }
  
  /* Error */
  private EnumValue(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 35	com/google/protobuf/EnumValue:<init>	()V
    //   4: aload_2
    //   5: ifnull +297 -> 302
    //   8: invokestatic 68	com/google/protobuf/UnknownFieldSet:a	()Lcom/google/protobuf/UnknownFieldSet$Builder;
    //   11: astore 9
    //   13: iconst_0
    //   14: istore 8
    //   16: iconst_0
    //   17: istore_3
    //   18: iload 8
    //   20: ifne +251 -> 271
    //   23: iload_3
    //   24: istore 5
    //   26: iload_3
    //   27: istore 6
    //   29: iload_3
    //   30: istore 7
    //   32: aload_1
    //   33: invokevirtual 73	com/google/protobuf/CodedInputStream:a	()I
    //   36: istore 4
    //   38: iload 4
    //   40: ifeq +159 -> 199
    //   43: iload 4
    //   45: bipush 10
    //   47: if_icmpeq +132 -> 179
    //   50: iload 4
    //   52: bipush 16
    //   54: if_icmpeq +105 -> 159
    //   57: iload 4
    //   59: bipush 26
    //   61: if_icmpeq +28 -> 89
    //   64: iload_3
    //   65: istore 5
    //   67: iload_3
    //   68: istore 6
    //   70: iload_3
    //   71: istore 7
    //   73: aload_0
    //   74: aload_1
    //   75: aload 9
    //   77: aload_2
    //   78: iload 4
    //   80: invokevirtual 77	com/google/protobuf/EnumValue:parseUnknownField	(Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/UnknownFieldSet$Builder;Lcom/google/protobuf/ExtensionRegistryLite;I)Z
    //   83: ifne -65 -> 18
    //   86: goto +113 -> 199
    //   89: iload_3
    //   90: istore 4
    //   92: iload_3
    //   93: iconst_1
    //   94: iand
    //   95: ifne +28 -> 123
    //   98: iload_3
    //   99: istore 5
    //   101: iload_3
    //   102: istore 6
    //   104: iload_3
    //   105: istore 7
    //   107: aload_0
    //   108: new 79	java/util/ArrayList
    //   111: dup
    //   112: invokespecial 80	java/util/ArrayList:<init>	()V
    //   115: putfield 58	com/google/protobuf/EnumValue:options_	Ljava/util/List;
    //   118: iload_3
    //   119: iconst_1
    //   120: ior
    //   121: istore 4
    //   123: iload 4
    //   125: istore 5
    //   127: iload 4
    //   129: istore 6
    //   131: iload 4
    //   133: istore 7
    //   135: aload_0
    //   136: getfield 58	com/google/protobuf/EnumValue:options_	Ljava/util/List;
    //   139: aload_1
    //   140: invokestatic 86	com/google/protobuf/Option:parser	()Lcom/google/protobuf/Parser;
    //   143: aload_2
    //   144: invokevirtual 89	com/google/protobuf/CodedInputStream:a	(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   147: invokeinterface 95 2 0
    //   152: pop
    //   153: iload 4
    //   155: istore_3
    //   156: goto -138 -> 18
    //   159: iload_3
    //   160: istore 5
    //   162: iload_3
    //   163: istore 6
    //   165: iload_3
    //   166: istore 7
    //   168: aload_0
    //   169: aload_1
    //   170: invokevirtual 98	com/google/protobuf/CodedInputStream:f	()I
    //   173: putfield 100	com/google/protobuf/EnumValue:number_	I
    //   176: goto -158 -> 18
    //   179: iload_3
    //   180: istore 5
    //   182: iload_3
    //   183: istore 6
    //   185: iload_3
    //   186: istore 7
    //   188: aload_0
    //   189: aload_1
    //   190: invokevirtual 104	com/google/protobuf/CodedInputStream:k	()Ljava/lang/String;
    //   193: putfield 50	com/google/protobuf/EnumValue:name_	Ljava/lang/Object;
    //   196: goto -178 -> 18
    //   199: iconst_1
    //   200: istore 8
    //   202: goto -184 -> 18
    //   205: astore_1
    //   206: goto +32 -> 238
    //   209: astore_1
    //   210: iload 6
    //   212: istore 5
    //   214: new 61	com/google/protobuf/InvalidProtocolBufferException
    //   217: dup
    //   218: aload_1
    //   219: invokespecial 107	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/io/IOException;)V
    //   222: aload_0
    //   223: invokevirtual 111	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   226: athrow
    //   227: astore_1
    //   228: iload 7
    //   230: istore 5
    //   232: aload_1
    //   233: aload_0
    //   234: invokevirtual 111	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   237: athrow
    //   238: iload 5
    //   240: iconst_1
    //   241: iand
    //   242: ifeq +14 -> 256
    //   245: aload_0
    //   246: aload_0
    //   247: getfield 58	com/google/protobuf/EnumValue:options_	Ljava/util/List;
    //   250: invokestatic 115	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   253: putfield 58	com/google/protobuf/EnumValue:options_	Ljava/util/List;
    //   256: aload_0
    //   257: aload 9
    //   259: invokevirtual 120	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   262: putfield 124	com/google/protobuf/EnumValue:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   265: aload_0
    //   266: invokevirtual 127	com/google/protobuf/EnumValue:makeExtensionsImmutable	()V
    //   269: aload_1
    //   270: athrow
    //   271: iload_3
    //   272: iconst_1
    //   273: iand
    //   274: ifeq +14 -> 288
    //   277: aload_0
    //   278: aload_0
    //   279: getfield 58	com/google/protobuf/EnumValue:options_	Ljava/util/List;
    //   282: invokestatic 115	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   285: putfield 58	com/google/protobuf/EnumValue:options_	Ljava/util/List;
    //   288: aload_0
    //   289: aload 9
    //   291: invokevirtual 120	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   294: putfield 124	com/google/protobuf/EnumValue:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   297: aload_0
    //   298: invokevirtual 127	com/google/protobuf/EnumValue:makeExtensionsImmutable	()V
    //   301: return
    //   302: new 129	java/lang/NullPointerException
    //   305: dup
    //   306: invokespecial 130	java/lang/NullPointerException:<init>	()V
    //   309: astore_1
    //   310: goto +5 -> 315
    //   313: aload_1
    //   314: athrow
    //   315: goto -2 -> 313
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	318	0	this	EnumValue
    //   0	318	1	paramCodedInputStream	CodedInputStream
    //   0	318	2	paramExtensionRegistryLite	ExtensionRegistryLite
    //   17	257	3	i	int
    //   36	118	4	j	int
    //   24	218	5	k	int
    //   27	184	6	m	int
    //   30	199	7	n	int
    //   14	187	8	i1	int
    //   11	279	9	localBuilder	UnknownFieldSet.Builder
    // Exception table:
    //   from	to	target	type
    //   32	38	205	finally
    //   73	86	205	finally
    //   107	118	205	finally
    //   135	153	205	finally
    //   168	176	205	finally
    //   188	196	205	finally
    //   214	227	205	finally
    //   232	238	205	finally
    //   32	38	209	java/io/IOException
    //   73	86	209	java/io/IOException
    //   107	118	209	java/io/IOException
    //   135	153	209	java/io/IOException
    //   168	176	209	java/io/IOException
    //   188	196	209	java/io/IOException
    //   32	38	227	com/google/protobuf/InvalidProtocolBufferException
    //   73	86	227	com/google/protobuf/InvalidProtocolBufferException
    //   107	118	227	com/google/protobuf/InvalidProtocolBufferException
    //   135	153	227	com/google/protobuf/InvalidProtocolBufferException
    //   168	176	227	com/google/protobuf/InvalidProtocolBufferException
    //   188	196	227	com/google/protobuf/InvalidProtocolBufferException
  }
  
  private EnumValue(GeneratedMessageV3.Builder<?> paramBuilder)
  {
    super(paramBuilder);
  }
  
  public static EnumValue getDefaultInstance()
  {
    return a;
  }
  
  public static final Descriptors.Descriptor getDescriptor()
  {
    return TypeProto.g;
  }
  
  public static EnumValue.Builder newBuilder()
  {
    return a.toBuilder();
  }
  
  public static EnumValue.Builder newBuilder(EnumValue paramEnumValue)
  {
    return a.toBuilder().a(paramEnumValue);
  }
  
  public static EnumValue parseDelimitedFrom(InputStream paramInputStream)
  {
    return (EnumValue)GeneratedMessageV3.parseDelimitedWithIOException(b, paramInputStream);
  }
  
  public static EnumValue parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (EnumValue)GeneratedMessageV3.parseDelimitedWithIOException(b, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static EnumValue parseFrom(ByteString paramByteString)
  {
    return (EnumValue)b.parseFrom(paramByteString);
  }
  
  public static EnumValue parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (EnumValue)b.parseFrom(paramByteString, paramExtensionRegistryLite);
  }
  
  public static EnumValue parseFrom(CodedInputStream paramCodedInputStream)
  {
    return (EnumValue)GeneratedMessageV3.parseWithIOException(b, paramCodedInputStream);
  }
  
  public static EnumValue parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (EnumValue)GeneratedMessageV3.parseWithIOException(b, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static EnumValue parseFrom(InputStream paramInputStream)
  {
    return (EnumValue)GeneratedMessageV3.parseWithIOException(b, paramInputStream);
  }
  
  public static EnumValue parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (EnumValue)GeneratedMessageV3.parseWithIOException(b, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static EnumValue parseFrom(ByteBuffer paramByteBuffer)
  {
    return (EnumValue)b.parseFrom(paramByteBuffer);
  }
  
  public static EnumValue parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (EnumValue)b.parseFrom(paramByteBuffer, paramExtensionRegistryLite);
  }
  
  public static EnumValue parseFrom(byte[] paramArrayOfByte)
  {
    return (EnumValue)b.parseFrom(paramArrayOfByte);
  }
  
  public static EnumValue parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (EnumValue)b.parseFrom(paramArrayOfByte, paramExtensionRegistryLite);
  }
  
  public static Parser<EnumValue> parser()
  {
    return b;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof EnumValue)) {
      return super.equals(paramObject);
    }
    paramObject = (EnumValue)paramObject;
    if (!getName().equals(paramObject.getName())) {
      return false;
    }
    if (getNumber() != paramObject.getNumber()) {
      return false;
    }
    if (!getOptionsList().equals(paramObject.getOptionsList())) {
      return false;
    }
    return this.unknownFields.equals(paramObject.unknownFields);
  }
  
  public EnumValue getDefaultInstanceForType()
  {
    return a;
  }
  
  public String getName()
  {
    Object localObject = this.name_;
    if ((localObject instanceof String)) {
      return (String)localObject;
    }
    localObject = ((ByteString)localObject).toStringUtf8();
    this.name_ = localObject;
    return localObject;
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
  
  public Option getOptions(int paramInt)
  {
    return (Option)this.options_.get(paramInt);
  }
  
  public int getOptionsCount()
  {
    return this.options_.size();
  }
  
  public List<Option> getOptionsList()
  {
    return this.options_;
  }
  
  public OptionOrBuilder getOptionsOrBuilder(int paramInt)
  {
    return (OptionOrBuilder)this.options_.get(paramInt);
  }
  
  public List<? extends OptionOrBuilder> getOptionsOrBuilderList()
  {
    return this.options_;
  }
  
  public Parser<EnumValue> getParserForType()
  {
    return b;
  }
  
  public int getSerializedSize()
  {
    int i = this.memoizedSize;
    if (i != -1) {
      return i;
    }
    boolean bool = getNameBytes().isEmpty();
    int m = 0;
    int j;
    if (!bool) {
      j = GeneratedMessageV3.computeStringSize(1, this.name_) + 0;
    } else {
      j = 0;
    }
    int n = this.number_;
    i = j;
    int k = m;
    if (n != 0)
    {
      i = j + CodedOutputStream.h(2, n);
      k = m;
    }
    while (k < this.options_.size())
    {
      i += CodedOutputStream.c(3, (MessageLite)this.options_.get(k));
      k += 1;
    }
    i += this.unknownFields.getSerializedSize();
    this.memoizedSize = i;
    return i;
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
    int j = ((((779 + getDescriptor().hashCode()) * 37 + 1) * 53 + getName().hashCode()) * 37 + 2) * 53 + getNumber();
    int i = j;
    if (getOptionsCount() > 0) {
      i = (j * 37 + 3) * 53 + getOptionsList().hashCode();
    }
    i = i * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    return i;
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return TypeProto.h.a(EnumValue.class, EnumValue.Builder.class);
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
  
  public EnumValue.Builder newBuilderForType()
  {
    return newBuilder();
  }
  
  protected EnumValue.Builder newBuilderForType(GeneratedMessageV3.BuilderParent paramBuilderParent)
  {
    return new EnumValue.Builder(paramBuilderParent, null);
  }
  
  protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter paramUnusedPrivateParameter)
  {
    return new EnumValue();
  }
  
  public EnumValue.Builder toBuilder()
  {
    if (this == a) {
      return new EnumValue.Builder(null);
    }
    return new EnumValue.Builder(null).a(this);
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
  {
    if (!getNameBytes().isEmpty()) {
      GeneratedMessageV3.writeString(paramCodedOutputStream, 1, this.name_);
    }
    int i = this.number_;
    if (i != 0) {
      paramCodedOutputStream.b(2, i);
    }
    i = 0;
    while (i < this.options_.size())
    {
      paramCodedOutputStream.a(3, (MessageLite)this.options_.get(i));
      i += 1;
    }
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.EnumValue
 * JD-Core Version:    0.7.0.1
 */