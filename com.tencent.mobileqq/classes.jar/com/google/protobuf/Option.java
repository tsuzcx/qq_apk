package com.google.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;

public final class Option
  extends GeneratedMessageV3
  implements OptionOrBuilder
{
  public static final int NAME_FIELD_NUMBER = 1;
  public static final int VALUE_FIELD_NUMBER = 2;
  private static final Option a = new Option();
  private static final Parser<Option> b = new Option.1();
  private static final long serialVersionUID = 0L;
  private byte memoizedIsInitialized = -1;
  private volatile Object name_;
  private Any value_;
  
  private Option()
  {
    this.name_ = "";
  }
  
  /* Error */
  private Option(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 31	com/google/protobuf/Option:<init>	()V
    //   4: aload_2
    //   5: ifnull +186 -> 191
    //   8: invokestatic 56	com/google/protobuf/UnknownFieldSet:a	()Lcom/google/protobuf/UnknownFieldSet$Builder;
    //   11: astore 6
    //   13: iconst_0
    //   14: istore_3
    //   15: iload_3
    //   16: ifne +161 -> 177
    //   19: aload_1
    //   20: invokevirtual 61	com/google/protobuf/CodedInputStream:a	()I
    //   23: istore 4
    //   25: iload 4
    //   27: ifeq +105 -> 132
    //   30: iload 4
    //   32: bipush 10
    //   34: if_icmpeq +87 -> 121
    //   37: iload 4
    //   39: bipush 18
    //   41: if_icmpeq +19 -> 60
    //   44: aload_0
    //   45: aload_1
    //   46: aload 6
    //   48: aload_2
    //   49: iload 4
    //   51: invokevirtual 65	com/google/protobuf/Option:parseUnknownField	(Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/UnknownFieldSet$Builder;Lcom/google/protobuf/ExtensionRegistryLite;I)Z
    //   54: ifne -39 -> 15
    //   57: goto +75 -> 132
    //   60: aconst_null
    //   61: astore 5
    //   63: aload_0
    //   64: getfield 67	com/google/protobuf/Option:value_	Lcom/google/protobuf/Any;
    //   67: ifnull +12 -> 79
    //   70: aload_0
    //   71: getfield 67	com/google/protobuf/Option:value_	Lcom/google/protobuf/Any;
    //   74: invokevirtual 73	com/google/protobuf/Any:toBuilder	()Lcom/google/protobuf/Any$Builder;
    //   77: astore 5
    //   79: aload_0
    //   80: aload_1
    //   81: invokestatic 77	com/google/protobuf/Any:parser	()Lcom/google/protobuf/Parser;
    //   84: aload_2
    //   85: invokevirtual 80	com/google/protobuf/CodedInputStream:a	(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   88: checkcast 69	com/google/protobuf/Any
    //   91: putfield 67	com/google/protobuf/Option:value_	Lcom/google/protobuf/Any;
    //   94: aload 5
    //   96: ifnull -81 -> 15
    //   99: aload 5
    //   101: aload_0
    //   102: getfield 67	com/google/protobuf/Option:value_	Lcom/google/protobuf/Any;
    //   105: invokevirtual 85	com/google/protobuf/Any$Builder:a	(Lcom/google/protobuf/Any;)Lcom/google/protobuf/Any$Builder;
    //   108: pop
    //   109: aload_0
    //   110: aload 5
    //   112: invokevirtual 89	com/google/protobuf/Any$Builder:d	()Lcom/google/protobuf/Any;
    //   115: putfield 67	com/google/protobuf/Option:value_	Lcom/google/protobuf/Any;
    //   118: goto -103 -> 15
    //   121: aload_0
    //   122: aload_1
    //   123: invokevirtual 93	com/google/protobuf/CodedInputStream:k	()Ljava/lang/String;
    //   126: putfield 46	com/google/protobuf/Option:name_	Ljava/lang/Object;
    //   129: goto -114 -> 15
    //   132: iconst_1
    //   133: istore_3
    //   134: goto -119 -> 15
    //   137: astore_1
    //   138: goto +24 -> 162
    //   141: astore_1
    //   142: new 49	com/google/protobuf/InvalidProtocolBufferException
    //   145: dup
    //   146: aload_1
    //   147: invokespecial 96	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/io/IOException;)V
    //   150: aload_0
    //   151: invokevirtual 100	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   154: athrow
    //   155: astore_1
    //   156: aload_1
    //   157: aload_0
    //   158: invokevirtual 100	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   161: athrow
    //   162: aload_0
    //   163: aload 6
    //   165: invokevirtual 105	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   168: putfield 109	com/google/protobuf/Option:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   171: aload_0
    //   172: invokevirtual 112	com/google/protobuf/Option:makeExtensionsImmutable	()V
    //   175: aload_1
    //   176: athrow
    //   177: aload_0
    //   178: aload 6
    //   180: invokevirtual 105	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   183: putfield 109	com/google/protobuf/Option:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   186: aload_0
    //   187: invokevirtual 112	com/google/protobuf/Option:makeExtensionsImmutable	()V
    //   190: return
    //   191: new 114	java/lang/NullPointerException
    //   194: dup
    //   195: invokespecial 115	java/lang/NullPointerException:<init>	()V
    //   198: astore_1
    //   199: goto +5 -> 204
    //   202: aload_1
    //   203: athrow
    //   204: goto -2 -> 202
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	207	0	this	Option
    //   0	207	1	paramCodedInputStream	CodedInputStream
    //   0	207	2	paramExtensionRegistryLite	ExtensionRegistryLite
    //   14	120	3	i	int
    //   23	27	4	j	int
    //   61	50	5	localBuilder	Any.Builder
    //   11	168	6	localBuilder1	UnknownFieldSet.Builder
    // Exception table:
    //   from	to	target	type
    //   19	25	137	finally
    //   44	57	137	finally
    //   63	79	137	finally
    //   79	94	137	finally
    //   99	118	137	finally
    //   121	129	137	finally
    //   142	155	137	finally
    //   156	162	137	finally
    //   19	25	141	java/io/IOException
    //   44	57	141	java/io/IOException
    //   63	79	141	java/io/IOException
    //   79	94	141	java/io/IOException
    //   99	118	141	java/io/IOException
    //   121	129	141	java/io/IOException
    //   19	25	155	com/google/protobuf/InvalidProtocolBufferException
    //   44	57	155	com/google/protobuf/InvalidProtocolBufferException
    //   63	79	155	com/google/protobuf/InvalidProtocolBufferException
    //   79	94	155	com/google/protobuf/InvalidProtocolBufferException
    //   99	118	155	com/google/protobuf/InvalidProtocolBufferException
    //   121	129	155	com/google/protobuf/InvalidProtocolBufferException
  }
  
  private Option(GeneratedMessageV3.Builder<?> paramBuilder)
  {
    super(paramBuilder);
  }
  
  public static Option getDefaultInstance()
  {
    return a;
  }
  
  public static final Descriptors.Descriptor getDescriptor()
  {
    return TypeProto.i;
  }
  
  public static Option.Builder newBuilder()
  {
    return a.toBuilder();
  }
  
  public static Option.Builder newBuilder(Option paramOption)
  {
    return a.toBuilder().a(paramOption);
  }
  
  public static Option parseDelimitedFrom(InputStream paramInputStream)
  {
    return (Option)GeneratedMessageV3.parseDelimitedWithIOException(b, paramInputStream);
  }
  
  public static Option parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (Option)GeneratedMessageV3.parseDelimitedWithIOException(b, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Option parseFrom(ByteString paramByteString)
  {
    return (Option)b.parseFrom(paramByteString);
  }
  
  public static Option parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (Option)b.parseFrom(paramByteString, paramExtensionRegistryLite);
  }
  
  public static Option parseFrom(CodedInputStream paramCodedInputStream)
  {
    return (Option)GeneratedMessageV3.parseWithIOException(b, paramCodedInputStream);
  }
  
  public static Option parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (Option)GeneratedMessageV3.parseWithIOException(b, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static Option parseFrom(InputStream paramInputStream)
  {
    return (Option)GeneratedMessageV3.parseWithIOException(b, paramInputStream);
  }
  
  public static Option parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (Option)GeneratedMessageV3.parseWithIOException(b, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Option parseFrom(ByteBuffer paramByteBuffer)
  {
    return (Option)b.parseFrom(paramByteBuffer);
  }
  
  public static Option parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (Option)b.parseFrom(paramByteBuffer, paramExtensionRegistryLite);
  }
  
  public static Option parseFrom(byte[] paramArrayOfByte)
  {
    return (Option)b.parseFrom(paramArrayOfByte);
  }
  
  public static Option parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (Option)b.parseFrom(paramArrayOfByte, paramExtensionRegistryLite);
  }
  
  public static Parser<Option> parser()
  {
    return b;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof Option)) {
      return super.equals(paramObject);
    }
    paramObject = (Option)paramObject;
    if (!getName().equals(paramObject.getName())) {
      return false;
    }
    if (hasValue() != paramObject.hasValue()) {
      return false;
    }
    if ((hasValue()) && (!getValue().equals(paramObject.getValue()))) {
      return false;
    }
    return this.unknownFields.equals(paramObject.unknownFields);
  }
  
  public Option getDefaultInstanceForType()
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
  
  public Parser<Option> getParserForType()
  {
    return b;
  }
  
  public int getSerializedSize()
  {
    int i = this.memoizedSize;
    if (i != -1) {
      return i;
    }
    i = 0;
    if (!getNameBytes().isEmpty()) {
      i = 0 + GeneratedMessageV3.computeStringSize(1, this.name_);
    }
    int j = i;
    if (this.value_ != null) {
      j = i + CodedOutputStream.c(2, getValue());
    }
    i = j + this.unknownFields.getSerializedSize();
    this.memoizedSize = i;
    return i;
  }
  
  public final UnknownFieldSet getUnknownFields()
  {
    return this.unknownFields;
  }
  
  public Any getValue()
  {
    Any localAny2 = this.value_;
    Any localAny1 = localAny2;
    if (localAny2 == null) {
      localAny1 = Any.getDefaultInstance();
    }
    return localAny1;
  }
  
  public AnyOrBuilder getValueOrBuilder()
  {
    return getValue();
  }
  
  public boolean hasValue()
  {
    return this.value_ != null;
  }
  
  public int hashCode()
  {
    if (this.memoizedHashCode != 0) {
      return this.memoizedHashCode;
    }
    int j = ((779 + getDescriptor().hashCode()) * 37 + 1) * 53 + getName().hashCode();
    int i = j;
    if (hasValue()) {
      i = (j * 37 + 2) * 53 + getValue().hashCode();
    }
    i = i * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    return i;
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return TypeProto.j.a(Option.class, Option.Builder.class);
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
  
  public Option.Builder newBuilderForType()
  {
    return newBuilder();
  }
  
  protected Option.Builder newBuilderForType(GeneratedMessageV3.BuilderParent paramBuilderParent)
  {
    return new Option.Builder(paramBuilderParent, null);
  }
  
  protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter paramUnusedPrivateParameter)
  {
    return new Option();
  }
  
  public Option.Builder toBuilder()
  {
    if (this == a) {
      return new Option.Builder(null);
    }
    return new Option.Builder(null).a(this);
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
  {
    if (!getNameBytes().isEmpty()) {
      GeneratedMessageV3.writeString(paramCodedOutputStream, 1, this.name_);
    }
    if (this.value_ != null) {
      paramCodedOutputStream.a(2, getValue());
    }
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.Option
 * JD-Core Version:    0.7.0.1
 */