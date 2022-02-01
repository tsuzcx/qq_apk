package com.google.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;

public final class SourceContext
  extends GeneratedMessageV3
  implements SourceContextOrBuilder
{
  public static final int FILE_NAME_FIELD_NUMBER = 1;
  private static final SourceContext a = new SourceContext();
  private static final Parser<SourceContext> b = new SourceContext.1();
  private static final long serialVersionUID = 0L;
  private volatile Object fileName_;
  private byte memoizedIsInitialized = -1;
  
  private SourceContext()
  {
    this.fileName_ = "";
  }
  
  /* Error */
  private SourceContext(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 27	com/google/protobuf/SourceContext:<init>	()V
    //   4: aload_2
    //   5: ifnull +118 -> 123
    //   8: invokestatic 52	com/google/protobuf/UnknownFieldSet:a	()Lcom/google/protobuf/UnknownFieldSet$Builder;
    //   11: astore 5
    //   13: iconst_0
    //   14: istore_3
    //   15: iload_3
    //   16: ifne +93 -> 109
    //   19: aload_1
    //   20: invokevirtual 57	com/google/protobuf/CodedInputStream:a	()I
    //   23: istore 4
    //   25: iload 4
    //   27: ifeq +37 -> 64
    //   30: iload 4
    //   32: bipush 10
    //   34: if_icmpeq +19 -> 53
    //   37: aload_0
    //   38: aload_1
    //   39: aload 5
    //   41: aload_2
    //   42: iload 4
    //   44: invokevirtual 61	com/google/protobuf/SourceContext:parseUnknownField	(Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/UnknownFieldSet$Builder;Lcom/google/protobuf/ExtensionRegistryLite;I)Z
    //   47: ifne -32 -> 15
    //   50: goto +14 -> 64
    //   53: aload_0
    //   54: aload_1
    //   55: invokevirtual 65	com/google/protobuf/CodedInputStream:k	()Ljava/lang/String;
    //   58: putfield 42	com/google/protobuf/SourceContext:fileName_	Ljava/lang/Object;
    //   61: goto -46 -> 15
    //   64: iconst_1
    //   65: istore_3
    //   66: goto -51 -> 15
    //   69: astore_1
    //   70: goto +24 -> 94
    //   73: astore_1
    //   74: new 45	com/google/protobuf/InvalidProtocolBufferException
    //   77: dup
    //   78: aload_1
    //   79: invokespecial 68	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/io/IOException;)V
    //   82: aload_0
    //   83: invokevirtual 72	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   86: athrow
    //   87: astore_1
    //   88: aload_1
    //   89: aload_0
    //   90: invokevirtual 72	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   93: athrow
    //   94: aload_0
    //   95: aload 5
    //   97: invokevirtual 77	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   100: putfield 81	com/google/protobuf/SourceContext:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   103: aload_0
    //   104: invokevirtual 84	com/google/protobuf/SourceContext:makeExtensionsImmutable	()V
    //   107: aload_1
    //   108: athrow
    //   109: aload_0
    //   110: aload 5
    //   112: invokevirtual 77	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   115: putfield 81	com/google/protobuf/SourceContext:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   118: aload_0
    //   119: invokevirtual 84	com/google/protobuf/SourceContext:makeExtensionsImmutable	()V
    //   122: return
    //   123: new 86	java/lang/NullPointerException
    //   126: dup
    //   127: invokespecial 87	java/lang/NullPointerException:<init>	()V
    //   130: astore_1
    //   131: goto +5 -> 136
    //   134: aload_1
    //   135: athrow
    //   136: goto -2 -> 134
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	139	0	this	SourceContext
    //   0	139	1	paramCodedInputStream	CodedInputStream
    //   0	139	2	paramExtensionRegistryLite	ExtensionRegistryLite
    //   14	52	3	i	int
    //   23	20	4	j	int
    //   11	100	5	localBuilder	UnknownFieldSet.Builder
    // Exception table:
    //   from	to	target	type
    //   19	25	69	finally
    //   37	50	69	finally
    //   53	61	69	finally
    //   74	87	69	finally
    //   88	94	69	finally
    //   19	25	73	java/io/IOException
    //   37	50	73	java/io/IOException
    //   53	61	73	java/io/IOException
    //   19	25	87	com/google/protobuf/InvalidProtocolBufferException
    //   37	50	87	com/google/protobuf/InvalidProtocolBufferException
    //   53	61	87	com/google/protobuf/InvalidProtocolBufferException
  }
  
  private SourceContext(GeneratedMessageV3.Builder<?> paramBuilder)
  {
    super(paramBuilder);
  }
  
  public static SourceContext getDefaultInstance()
  {
    return a;
  }
  
  public static final Descriptors.Descriptor getDescriptor()
  {
    return SourceContextProto.a;
  }
  
  public static SourceContext.Builder newBuilder()
  {
    return a.toBuilder();
  }
  
  public static SourceContext.Builder newBuilder(SourceContext paramSourceContext)
  {
    return a.toBuilder().a(paramSourceContext);
  }
  
  public static SourceContext parseDelimitedFrom(InputStream paramInputStream)
  {
    return (SourceContext)GeneratedMessageV3.parseDelimitedWithIOException(b, paramInputStream);
  }
  
  public static SourceContext parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (SourceContext)GeneratedMessageV3.parseDelimitedWithIOException(b, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static SourceContext parseFrom(ByteString paramByteString)
  {
    return (SourceContext)b.parseFrom(paramByteString);
  }
  
  public static SourceContext parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (SourceContext)b.parseFrom(paramByteString, paramExtensionRegistryLite);
  }
  
  public static SourceContext parseFrom(CodedInputStream paramCodedInputStream)
  {
    return (SourceContext)GeneratedMessageV3.parseWithIOException(b, paramCodedInputStream);
  }
  
  public static SourceContext parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (SourceContext)GeneratedMessageV3.parseWithIOException(b, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static SourceContext parseFrom(InputStream paramInputStream)
  {
    return (SourceContext)GeneratedMessageV3.parseWithIOException(b, paramInputStream);
  }
  
  public static SourceContext parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (SourceContext)GeneratedMessageV3.parseWithIOException(b, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static SourceContext parseFrom(ByteBuffer paramByteBuffer)
  {
    return (SourceContext)b.parseFrom(paramByteBuffer);
  }
  
  public static SourceContext parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (SourceContext)b.parseFrom(paramByteBuffer, paramExtensionRegistryLite);
  }
  
  public static SourceContext parseFrom(byte[] paramArrayOfByte)
  {
    return (SourceContext)b.parseFrom(paramArrayOfByte);
  }
  
  public static SourceContext parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (SourceContext)b.parseFrom(paramArrayOfByte, paramExtensionRegistryLite);
  }
  
  public static Parser<SourceContext> parser()
  {
    return b;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof SourceContext)) {
      return super.equals(paramObject);
    }
    paramObject = (SourceContext)paramObject;
    if (!getFileName().equals(paramObject.getFileName())) {
      return false;
    }
    return this.unknownFields.equals(paramObject.unknownFields);
  }
  
  public SourceContext getDefaultInstanceForType()
  {
    return a;
  }
  
  public String getFileName()
  {
    Object localObject = this.fileName_;
    if ((localObject instanceof String)) {
      return (String)localObject;
    }
    localObject = ((ByteString)localObject).toStringUtf8();
    this.fileName_ = localObject;
    return localObject;
  }
  
  public ByteString getFileNameBytes()
  {
    Object localObject = this.fileName_;
    if ((localObject instanceof String))
    {
      localObject = ByteString.copyFromUtf8((String)localObject);
      this.fileName_ = localObject;
      return localObject;
    }
    return (ByteString)localObject;
  }
  
  public Parser<SourceContext> getParserForType()
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
    if (!getFileNameBytes().isEmpty()) {
      i = 0 + GeneratedMessageV3.computeStringSize(1, this.fileName_);
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
    int i = (((779 + getDescriptor().hashCode()) * 37 + 1) * 53 + getFileName().hashCode()) * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    return i;
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return SourceContextProto.b.a(SourceContext.class, SourceContext.Builder.class);
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
  
  public SourceContext.Builder newBuilderForType()
  {
    return newBuilder();
  }
  
  protected SourceContext.Builder newBuilderForType(GeneratedMessageV3.BuilderParent paramBuilderParent)
  {
    return new SourceContext.Builder(paramBuilderParent, null);
  }
  
  protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter paramUnusedPrivateParameter)
  {
    return new SourceContext();
  }
  
  public SourceContext.Builder toBuilder()
  {
    if (this == a) {
      return new SourceContext.Builder(null);
    }
    return new SourceContext.Builder(null).a(this);
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
  {
    if (!getFileNameBytes().isEmpty()) {
      GeneratedMessageV3.writeString(paramCodedOutputStream, 1, this.fileName_);
    }
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.SourceContext
 * JD-Core Version:    0.7.0.1
 */