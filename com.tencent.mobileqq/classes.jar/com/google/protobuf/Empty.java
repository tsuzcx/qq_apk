package com.google.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;

public final class Empty
  extends GeneratedMessageV3
  implements EmptyOrBuilder
{
  private static final Empty a = new Empty();
  private static final Parser<Empty> b = new Empty.1();
  private static final long serialVersionUID = 0L;
  private byte memoizedIsInitialized = -1;
  
  private Empty() {}
  
  /* Error */
  private Empty(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 22	com/google/protobuf/Empty:<init>	()V
    //   4: aload_2
    //   5: ifnull +101 -> 106
    //   8: invokestatic 43	com/google/protobuf/UnknownFieldSet:a	()Lcom/google/protobuf/UnknownFieldSet$Builder;
    //   11: astore 6
    //   13: iconst_0
    //   14: istore_3
    //   15: iload_3
    //   16: ifne +76 -> 92
    //   19: aload_1
    //   20: invokevirtual 48	com/google/protobuf/CodedInputStream:a	()I
    //   23: istore 4
    //   25: iload 4
    //   27: ifeq +20 -> 47
    //   30: aload_0
    //   31: aload_1
    //   32: aload 6
    //   34: aload_2
    //   35: iload 4
    //   37: invokevirtual 52	com/google/protobuf/Empty:parseUnknownField	(Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/UnknownFieldSet$Builder;Lcom/google/protobuf/ExtensionRegistryLite;I)Z
    //   40: istore 5
    //   42: iload 5
    //   44: ifne -29 -> 15
    //   47: iconst_1
    //   48: istore_3
    //   49: goto -34 -> 15
    //   52: astore_1
    //   53: goto +24 -> 77
    //   56: astore_1
    //   57: new 36	com/google/protobuf/InvalidProtocolBufferException
    //   60: dup
    //   61: aload_1
    //   62: invokespecial 55	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/io/IOException;)V
    //   65: aload_0
    //   66: invokevirtual 59	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   69: athrow
    //   70: astore_1
    //   71: aload_1
    //   72: aload_0
    //   73: invokevirtual 59	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   76: athrow
    //   77: aload_0
    //   78: aload 6
    //   80: invokevirtual 64	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   83: putfield 68	com/google/protobuf/Empty:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   86: aload_0
    //   87: invokevirtual 71	com/google/protobuf/Empty:makeExtensionsImmutable	()V
    //   90: aload_1
    //   91: athrow
    //   92: aload_0
    //   93: aload 6
    //   95: invokevirtual 64	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   98: putfield 68	com/google/protobuf/Empty:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   101: aload_0
    //   102: invokevirtual 71	com/google/protobuf/Empty:makeExtensionsImmutable	()V
    //   105: return
    //   106: new 73	java/lang/NullPointerException
    //   109: dup
    //   110: invokespecial 74	java/lang/NullPointerException:<init>	()V
    //   113: astore_1
    //   114: goto +5 -> 119
    //   117: aload_1
    //   118: athrow
    //   119: goto -2 -> 117
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	122	0	this	Empty
    //   0	122	1	paramCodedInputStream	CodedInputStream
    //   0	122	2	paramExtensionRegistryLite	ExtensionRegistryLite
    //   14	35	3	i	int
    //   23	13	4	j	int
    //   40	3	5	bool	boolean
    //   11	83	6	localBuilder	UnknownFieldSet.Builder
    // Exception table:
    //   from	to	target	type
    //   19	25	52	finally
    //   30	42	52	finally
    //   57	70	52	finally
    //   71	77	52	finally
    //   19	25	56	java/io/IOException
    //   30	42	56	java/io/IOException
    //   19	25	70	com/google/protobuf/InvalidProtocolBufferException
    //   30	42	70	com/google/protobuf/InvalidProtocolBufferException
  }
  
  private Empty(GeneratedMessageV3.Builder<?> paramBuilder)
  {
    super(paramBuilder);
  }
  
  public static Empty getDefaultInstance()
  {
    return a;
  }
  
  public static final Descriptors.Descriptor getDescriptor()
  {
    return EmptyProto.a;
  }
  
  public static Empty.Builder newBuilder()
  {
    return a.toBuilder();
  }
  
  public static Empty.Builder newBuilder(Empty paramEmpty)
  {
    return a.toBuilder().a(paramEmpty);
  }
  
  public static Empty parseDelimitedFrom(InputStream paramInputStream)
  {
    return (Empty)GeneratedMessageV3.parseDelimitedWithIOException(b, paramInputStream);
  }
  
  public static Empty parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (Empty)GeneratedMessageV3.parseDelimitedWithIOException(b, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Empty parseFrom(ByteString paramByteString)
  {
    return (Empty)b.parseFrom(paramByteString);
  }
  
  public static Empty parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (Empty)b.parseFrom(paramByteString, paramExtensionRegistryLite);
  }
  
  public static Empty parseFrom(CodedInputStream paramCodedInputStream)
  {
    return (Empty)GeneratedMessageV3.parseWithIOException(b, paramCodedInputStream);
  }
  
  public static Empty parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (Empty)GeneratedMessageV3.parseWithIOException(b, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static Empty parseFrom(InputStream paramInputStream)
  {
    return (Empty)GeneratedMessageV3.parseWithIOException(b, paramInputStream);
  }
  
  public static Empty parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (Empty)GeneratedMessageV3.parseWithIOException(b, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Empty parseFrom(ByteBuffer paramByteBuffer)
  {
    return (Empty)b.parseFrom(paramByteBuffer);
  }
  
  public static Empty parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (Empty)b.parseFrom(paramByteBuffer, paramExtensionRegistryLite);
  }
  
  public static Empty parseFrom(byte[] paramArrayOfByte)
  {
    return (Empty)b.parseFrom(paramArrayOfByte);
  }
  
  public static Empty parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (Empty)b.parseFrom(paramArrayOfByte, paramExtensionRegistryLite);
  }
  
  public static Parser<Empty> parser()
  {
    return b;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof Empty)) {
      return super.equals(paramObject);
    }
    paramObject = (Empty)paramObject;
    return this.unknownFields.equals(paramObject.unknownFields);
  }
  
  public Empty getDefaultInstanceForType()
  {
    return a;
  }
  
  public Parser<Empty> getParserForType()
  {
    return b;
  }
  
  public int getSerializedSize()
  {
    int i = this.memoizedSize;
    if (i != -1) {
      return i;
    }
    i = this.unknownFields.getSerializedSize() + 0;
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
    int i = (779 + getDescriptor().hashCode()) * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    return i;
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return EmptyProto.b.a(Empty.class, Empty.Builder.class);
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
  
  public Empty.Builder newBuilderForType()
  {
    return newBuilder();
  }
  
  protected Empty.Builder newBuilderForType(GeneratedMessageV3.BuilderParent paramBuilderParent)
  {
    return new Empty.Builder(paramBuilderParent, null);
  }
  
  protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter paramUnusedPrivateParameter)
  {
    return new Empty();
  }
  
  public Empty.Builder toBuilder()
  {
    if (this == a) {
      return new Empty.Builder(null);
    }
    return new Empty.Builder(null).a(this);
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
  {
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.Empty
 * JD-Core Version:    0.7.0.1
 */