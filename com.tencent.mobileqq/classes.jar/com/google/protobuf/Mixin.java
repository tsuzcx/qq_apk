package com.google.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;

public final class Mixin
  extends GeneratedMessageV3
  implements MixinOrBuilder
{
  public static final int NAME_FIELD_NUMBER = 1;
  public static final int ROOT_FIELD_NUMBER = 2;
  private static final Mixin a = new Mixin();
  private static final Parser<Mixin> b = new Mixin.1();
  private static final long serialVersionUID = 0L;
  private byte memoizedIsInitialized = -1;
  private volatile Object name_;
  private volatile Object root_;
  
  private Mixin()
  {
    this.name_ = "";
    this.root_ = "";
  }
  
  /* Error */
  private Mixin(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 30	com/google/protobuf/Mixin:<init>	()V
    //   4: aload_2
    //   5: ifnull +136 -> 141
    //   8: invokestatic 57	com/google/protobuf/UnknownFieldSet:a	()Lcom/google/protobuf/UnknownFieldSet$Builder;
    //   11: astore 5
    //   13: iconst_0
    //   14: istore_3
    //   15: iload_3
    //   16: ifne +111 -> 127
    //   19: aload_1
    //   20: invokevirtual 62	com/google/protobuf/CodedInputStream:a	()I
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
    //   51: invokevirtual 66	com/google/protobuf/Mixin:parseUnknownField	(Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/UnknownFieldSet$Builder;Lcom/google/protobuf/ExtensionRegistryLite;I)Z
    //   54: ifne -39 -> 15
    //   57: goto +25 -> 82
    //   60: aload_0
    //   61: aload_1
    //   62: invokevirtual 70	com/google/protobuf/CodedInputStream:k	()Ljava/lang/String;
    //   65: putfield 47	com/google/protobuf/Mixin:root_	Ljava/lang/Object;
    //   68: goto -53 -> 15
    //   71: aload_0
    //   72: aload_1
    //   73: invokevirtual 70	com/google/protobuf/CodedInputStream:k	()Ljava/lang/String;
    //   76: putfield 45	com/google/protobuf/Mixin:name_	Ljava/lang/Object;
    //   79: goto -64 -> 15
    //   82: iconst_1
    //   83: istore_3
    //   84: goto -69 -> 15
    //   87: astore_1
    //   88: goto +24 -> 112
    //   91: astore_1
    //   92: new 50	com/google/protobuf/InvalidProtocolBufferException
    //   95: dup
    //   96: aload_1
    //   97: invokespecial 73	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/io/IOException;)V
    //   100: aload_0
    //   101: invokevirtual 77	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   104: athrow
    //   105: astore_1
    //   106: aload_1
    //   107: aload_0
    //   108: invokevirtual 77	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   111: athrow
    //   112: aload_0
    //   113: aload 5
    //   115: invokevirtual 82	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   118: putfield 86	com/google/protobuf/Mixin:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   121: aload_0
    //   122: invokevirtual 89	com/google/protobuf/Mixin:makeExtensionsImmutable	()V
    //   125: aload_1
    //   126: athrow
    //   127: aload_0
    //   128: aload 5
    //   130: invokevirtual 82	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   133: putfield 86	com/google/protobuf/Mixin:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   136: aload_0
    //   137: invokevirtual 89	com/google/protobuf/Mixin:makeExtensionsImmutable	()V
    //   140: return
    //   141: new 91	java/lang/NullPointerException
    //   144: dup
    //   145: invokespecial 92	java/lang/NullPointerException:<init>	()V
    //   148: astore_1
    //   149: goto +5 -> 154
    //   152: aload_1
    //   153: athrow
    //   154: goto -2 -> 152
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	157	0	this	Mixin
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
  
  private Mixin(GeneratedMessageV3.Builder<?> paramBuilder)
  {
    super(paramBuilder);
  }
  
  public static Mixin getDefaultInstance()
  {
    return a;
  }
  
  public static final Descriptors.Descriptor getDescriptor()
  {
    return ApiProto.e;
  }
  
  public static Mixin.Builder newBuilder()
  {
    return a.toBuilder();
  }
  
  public static Mixin.Builder newBuilder(Mixin paramMixin)
  {
    return a.toBuilder().a(paramMixin);
  }
  
  public static Mixin parseDelimitedFrom(InputStream paramInputStream)
  {
    return (Mixin)GeneratedMessageV3.parseDelimitedWithIOException(b, paramInputStream);
  }
  
  public static Mixin parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (Mixin)GeneratedMessageV3.parseDelimitedWithIOException(b, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Mixin parseFrom(ByteString paramByteString)
  {
    return (Mixin)b.parseFrom(paramByteString);
  }
  
  public static Mixin parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (Mixin)b.parseFrom(paramByteString, paramExtensionRegistryLite);
  }
  
  public static Mixin parseFrom(CodedInputStream paramCodedInputStream)
  {
    return (Mixin)GeneratedMessageV3.parseWithIOException(b, paramCodedInputStream);
  }
  
  public static Mixin parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (Mixin)GeneratedMessageV3.parseWithIOException(b, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static Mixin parseFrom(InputStream paramInputStream)
  {
    return (Mixin)GeneratedMessageV3.parseWithIOException(b, paramInputStream);
  }
  
  public static Mixin parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (Mixin)GeneratedMessageV3.parseWithIOException(b, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Mixin parseFrom(ByteBuffer paramByteBuffer)
  {
    return (Mixin)b.parseFrom(paramByteBuffer);
  }
  
  public static Mixin parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (Mixin)b.parseFrom(paramByteBuffer, paramExtensionRegistryLite);
  }
  
  public static Mixin parseFrom(byte[] paramArrayOfByte)
  {
    return (Mixin)b.parseFrom(paramArrayOfByte);
  }
  
  public static Mixin parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (Mixin)b.parseFrom(paramArrayOfByte, paramExtensionRegistryLite);
  }
  
  public static Parser<Mixin> parser()
  {
    return b;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof Mixin)) {
      return super.equals(paramObject);
    }
    paramObject = (Mixin)paramObject;
    if (!getName().equals(paramObject.getName())) {
      return false;
    }
    if (!getRoot().equals(paramObject.getRoot())) {
      return false;
    }
    return this.unknownFields.equals(paramObject.unknownFields);
  }
  
  public Mixin getDefaultInstanceForType()
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
  
  public Parser<Mixin> getParserForType()
  {
    return b;
  }
  
  public String getRoot()
  {
    Object localObject = this.root_;
    if ((localObject instanceof String)) {
      return (String)localObject;
    }
    localObject = ((ByteString)localObject).toStringUtf8();
    this.root_ = localObject;
    return localObject;
  }
  
  public ByteString getRootBytes()
  {
    Object localObject = this.root_;
    if ((localObject instanceof String))
    {
      localObject = ByteString.copyFromUtf8((String)localObject);
      this.root_ = localObject;
      return localObject;
    }
    return (ByteString)localObject;
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
    if (!getRootBytes().isEmpty()) {
      j = i + GeneratedMessageV3.computeStringSize(2, this.root_);
    }
    i = j + this.unknownFields.getSerializedSize();
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
    int i = (((((779 + getDescriptor().hashCode()) * 37 + 1) * 53 + getName().hashCode()) * 37 + 2) * 53 + getRoot().hashCode()) * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    return i;
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return ApiProto.f.a(Mixin.class, Mixin.Builder.class);
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
  
  public Mixin.Builder newBuilderForType()
  {
    return newBuilder();
  }
  
  protected Mixin.Builder newBuilderForType(GeneratedMessageV3.BuilderParent paramBuilderParent)
  {
    return new Mixin.Builder(paramBuilderParent, null);
  }
  
  protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter paramUnusedPrivateParameter)
  {
    return new Mixin();
  }
  
  public Mixin.Builder toBuilder()
  {
    if (this == a) {
      return new Mixin.Builder(null);
    }
    return new Mixin.Builder(null).a(this);
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
  {
    if (!getNameBytes().isEmpty()) {
      GeneratedMessageV3.writeString(paramCodedOutputStream, 1, this.name_);
    }
    if (!getRootBytes().isEmpty()) {
      GeneratedMessageV3.writeString(paramCodedOutputStream, 2, this.root_);
    }
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.Mixin
 * JD-Core Version:    0.7.0.1
 */