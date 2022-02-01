package com.google.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;

public final class Any
  extends GeneratedMessageV3
  implements AnyOrBuilder
{
  public static final int TYPE_URL_FIELD_NUMBER = 1;
  public static final int VALUE_FIELD_NUMBER = 2;
  private static final Any a = new Any();
  private static final Parser<Any> b = new Any.1();
  private static final long serialVersionUID = 0L;
  private volatile Message cachedUnpackValue;
  private byte memoizedIsInitialized = -1;
  private volatile Object typeUrl_;
  private ByteString value_;
  
  private Any()
  {
    this.typeUrl_ = "";
    this.value_ = ByteString.EMPTY;
  }
  
  /* Error */
  private Any(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 33	com/google/protobuf/Any:<init>	()V
    //   4: aload_2
    //   5: ifnull +136 -> 141
    //   8: invokestatic 65	com/google/protobuf/UnknownFieldSet:a	()Lcom/google/protobuf/UnknownFieldSet$Builder;
    //   11: astore 5
    //   13: iconst_0
    //   14: istore_3
    //   15: iload_3
    //   16: ifne +111 -> 127
    //   19: aload_1
    //   20: invokevirtual 70	com/google/protobuf/CodedInputStream:a	()I
    //   23: istore 4
    //   25: iload 4
    //   27: ifeq +55 -> 82
    //   30: iload 4
    //   32: bipush 10
    //   34: if_icmpeq +37 -> 71
    //   37: iload 4
    //   39: bipush 18
    //   41: if_icmpeq +19 -> 60
    //   44: aload_0
    //   45: aload_1
    //   46: aload 5
    //   48: aload_2
    //   49: iload 4
    //   51: invokevirtual 74	com/google/protobuf/Any:parseUnknownField	(Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/UnknownFieldSet$Builder;Lcom/google/protobuf/ExtensionRegistryLite;I)Z
    //   54: ifne -39 -> 15
    //   57: goto +25 -> 82
    //   60: aload_0
    //   61: aload_1
    //   62: invokevirtual 78	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   65: putfield 55	com/google/protobuf/Any:value_	Lcom/google/protobuf/ByteString;
    //   68: goto -53 -> 15
    //   71: aload_0
    //   72: aload_1
    //   73: invokevirtual 82	com/google/protobuf/CodedInputStream:k	()Ljava/lang/String;
    //   76: putfield 48	com/google/protobuf/Any:typeUrl_	Ljava/lang/Object;
    //   79: goto -64 -> 15
    //   82: iconst_1
    //   83: istore_3
    //   84: goto -69 -> 15
    //   87: astore_1
    //   88: goto +24 -> 112
    //   91: astore_1
    //   92: new 58	com/google/protobuf/InvalidProtocolBufferException
    //   95: dup
    //   96: aload_1
    //   97: invokespecial 85	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/io/IOException;)V
    //   100: aload_0
    //   101: invokevirtual 89	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   104: athrow
    //   105: astore_1
    //   106: aload_1
    //   107: aload_0
    //   108: invokevirtual 89	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   111: athrow
    //   112: aload_0
    //   113: aload 5
    //   115: invokevirtual 94	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   118: putfield 98	com/google/protobuf/Any:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   121: aload_0
    //   122: invokevirtual 101	com/google/protobuf/Any:makeExtensionsImmutable	()V
    //   125: aload_1
    //   126: athrow
    //   127: aload_0
    //   128: aload 5
    //   130: invokevirtual 94	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   133: putfield 98	com/google/protobuf/Any:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   136: aload_0
    //   137: invokevirtual 101	com/google/protobuf/Any:makeExtensionsImmutable	()V
    //   140: return
    //   141: new 103	java/lang/NullPointerException
    //   144: dup
    //   145: invokespecial 104	java/lang/NullPointerException:<init>	()V
    //   148: astore_1
    //   149: goto +5 -> 154
    //   152: aload_1
    //   153: athrow
    //   154: goto -2 -> 152
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	157	0	this	Any
    //   0	157	1	paramCodedInputStream	CodedInputStream
    //   0	157	2	paramExtensionRegistryLite	ExtensionRegistryLite
    //   14	70	3	i	int
    //   23	27	4	j	int
    //   11	118	5	localBuilder	UnknownFieldSet.Builder
    // Exception table:
    //   from	to	target	type
    //   19	25	87	finally
    //   44	57	87	finally
    //   60	68	87	finally
    //   71	79	87	finally
    //   92	105	87	finally
    //   106	112	87	finally
    //   19	25	91	java/io/IOException
    //   44	57	91	java/io/IOException
    //   60	68	91	java/io/IOException
    //   71	79	91	java/io/IOException
    //   19	25	105	com/google/protobuf/InvalidProtocolBufferException
    //   44	57	105	com/google/protobuf/InvalidProtocolBufferException
    //   60	68	105	com/google/protobuf/InvalidProtocolBufferException
    //   71	79	105	com/google/protobuf/InvalidProtocolBufferException
  }
  
  private Any(GeneratedMessageV3.Builder<?> paramBuilder)
  {
    super(paramBuilder);
  }
  
  private static String a(String paramString)
  {
    int i = paramString.lastIndexOf('/');
    if (i == -1) {
      return "";
    }
    return paramString.substring(i + 1);
  }
  
  private static String a(String paramString, Descriptors.Descriptor paramDescriptor)
  {
    if (paramString.endsWith("/"))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(paramDescriptor.c());
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("/");
    localStringBuilder.append(paramDescriptor.c());
    return localStringBuilder.toString();
  }
  
  public static Any getDefaultInstance()
  {
    return a;
  }
  
  public static final Descriptors.Descriptor getDescriptor()
  {
    return AnyProto.a;
  }
  
  public static Any.Builder newBuilder()
  {
    return a.toBuilder();
  }
  
  public static Any.Builder newBuilder(Any paramAny)
  {
    return a.toBuilder().a(paramAny);
  }
  
  public static <T extends Message> Any pack(T paramT)
  {
    return newBuilder().a(a("type.googleapis.com", paramT.getDescriptorForType())).a(paramT.toByteString()).c();
  }
  
  public static <T extends Message> Any pack(T paramT, String paramString)
  {
    return newBuilder().a(a(paramString, paramT.getDescriptorForType())).a(paramT.toByteString()).c();
  }
  
  public static Any parseDelimitedFrom(InputStream paramInputStream)
  {
    return (Any)GeneratedMessageV3.parseDelimitedWithIOException(b, paramInputStream);
  }
  
  public static Any parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (Any)GeneratedMessageV3.parseDelimitedWithIOException(b, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Any parseFrom(ByteString paramByteString)
  {
    return (Any)b.parseFrom(paramByteString);
  }
  
  public static Any parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (Any)b.parseFrom(paramByteString, paramExtensionRegistryLite);
  }
  
  public static Any parseFrom(CodedInputStream paramCodedInputStream)
  {
    return (Any)GeneratedMessageV3.parseWithIOException(b, paramCodedInputStream);
  }
  
  public static Any parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (Any)GeneratedMessageV3.parseWithIOException(b, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static Any parseFrom(InputStream paramInputStream)
  {
    return (Any)GeneratedMessageV3.parseWithIOException(b, paramInputStream);
  }
  
  public static Any parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (Any)GeneratedMessageV3.parseWithIOException(b, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Any parseFrom(ByteBuffer paramByteBuffer)
  {
    return (Any)b.parseFrom(paramByteBuffer);
  }
  
  public static Any parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (Any)b.parseFrom(paramByteBuffer, paramExtensionRegistryLite);
  }
  
  public static Any parseFrom(byte[] paramArrayOfByte)
  {
    return (Any)b.parseFrom(paramArrayOfByte);
  }
  
  public static Any parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (Any)b.parseFrom(paramArrayOfByte, paramExtensionRegistryLite);
  }
  
  public static Parser<Any> parser()
  {
    return b;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof Any)) {
      return super.equals(paramObject);
    }
    paramObject = (Any)paramObject;
    if (!getTypeUrl().equals(paramObject.getTypeUrl())) {
      return false;
    }
    if (!getValue().equals(paramObject.getValue())) {
      return false;
    }
    return this.unknownFields.equals(paramObject.unknownFields);
  }
  
  public Any getDefaultInstanceForType()
  {
    return a;
  }
  
  public Parser<Any> getParserForType()
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
    if (!getTypeUrlBytes().isEmpty()) {
      i = 0 + GeneratedMessageV3.computeStringSize(1, this.typeUrl_);
    }
    int j = i;
    if (!this.value_.isEmpty()) {
      j = i + CodedOutputStream.c(2, this.value_);
    }
    i = j + this.unknownFields.getSerializedSize();
    this.memoizedSize = i;
    return i;
  }
  
  public String getTypeUrl()
  {
    Object localObject = this.typeUrl_;
    if ((localObject instanceof String)) {
      return (String)localObject;
    }
    localObject = ((ByteString)localObject).toStringUtf8();
    this.typeUrl_ = localObject;
    return localObject;
  }
  
  public ByteString getTypeUrlBytes()
  {
    Object localObject = this.typeUrl_;
    if ((localObject instanceof String))
    {
      localObject = ByteString.copyFromUtf8((String)localObject);
      this.typeUrl_ = localObject;
      return localObject;
    }
    return (ByteString)localObject;
  }
  
  public final UnknownFieldSet getUnknownFields()
  {
    return this.unknownFields;
  }
  
  public ByteString getValue()
  {
    return this.value_;
  }
  
  public int hashCode()
  {
    if (this.memoizedHashCode != 0) {
      return this.memoizedHashCode;
    }
    int i = (((((779 + getDescriptor().hashCode()) * 37 + 1) * 53 + getTypeUrl().hashCode()) * 37 + 2) * 53 + getValue().hashCode()) * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    return i;
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return AnyProto.b.a(Any.class, Any.Builder.class);
  }
  
  public <T extends Message> boolean is(Class<T> paramClass)
  {
    paramClass = (Message)Internal.a(paramClass);
    return a(getTypeUrl()).equals(paramClass.getDescriptorForType().c());
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
  
  public Any.Builder newBuilderForType()
  {
    return newBuilder();
  }
  
  protected Any.Builder newBuilderForType(GeneratedMessageV3.BuilderParent paramBuilderParent)
  {
    return new Any.Builder(paramBuilderParent, null);
  }
  
  protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter paramUnusedPrivateParameter)
  {
    return new Any();
  }
  
  public Any.Builder toBuilder()
  {
    if (this == a) {
      return new Any.Builder(null);
    }
    return new Any.Builder(null).a(this);
  }
  
  public <T extends Message> T unpack(Class<T> paramClass)
  {
    int i;
    if (this.cachedUnpackValue != null)
    {
      if (this.cachedUnpackValue.getClass() == paramClass) {
        return this.cachedUnpackValue;
      }
      i = 1;
    }
    else
    {
      i = 0;
    }
    if ((i == 0) && (is(paramClass)))
    {
      paramClass = (Message)((Message)Internal.a(paramClass)).getParserForType().parseFrom(getValue());
      this.cachedUnpackValue = paramClass;
      return paramClass;
    }
    throw new InvalidProtocolBufferException("Type of the Any message does not match the given class.");
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
  {
    if (!getTypeUrlBytes().isEmpty()) {
      GeneratedMessageV3.writeString(paramCodedOutputStream, 1, this.typeUrl_);
    }
    if (!this.value_.isEmpty()) {
      paramCodedOutputStream.a(2, this.value_);
    }
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.Any
 * JD-Core Version:    0.7.0.1
 */