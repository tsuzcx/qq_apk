package com.google.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;

public final class Int32Value
  extends GeneratedMessageV3
  implements Int32ValueOrBuilder
{
  public static final int VALUE_FIELD_NUMBER = 1;
  private static final Int32Value a = new Int32Value();
  private static final Parser<Int32Value> b = new Int32Value.1();
  private static final long serialVersionUID = 0L;
  private byte memoizedIsInitialized = -1;
  private int value_;
  
  private Int32Value() {}
  
  /* Error */
  private Int32Value(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 26	com/google/protobuf/Int32Value:<init>	()V
    //   4: aload_2
    //   5: ifnull +118 -> 123
    //   8: invokestatic 47	com/google/protobuf/UnknownFieldSet:a	()Lcom/google/protobuf/UnknownFieldSet$Builder;
    //   11: astore 5
    //   13: iconst_0
    //   14: istore_3
    //   15: iload_3
    //   16: ifne +93 -> 109
    //   19: aload_1
    //   20: invokevirtual 52	com/google/protobuf/CodedInputStream:a	()I
    //   23: istore 4
    //   25: iload 4
    //   27: ifeq +37 -> 64
    //   30: iload 4
    //   32: bipush 8
    //   34: if_icmpeq +19 -> 53
    //   37: aload_0
    //   38: aload_1
    //   39: aload 5
    //   41: aload_2
    //   42: iload 4
    //   44: invokevirtual 56	com/google/protobuf/Int32Value:parseUnknownField	(Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/UnknownFieldSet$Builder;Lcom/google/protobuf/ExtensionRegistryLite;I)Z
    //   47: ifne -32 -> 15
    //   50: goto +14 -> 64
    //   53: aload_0
    //   54: aload_1
    //   55: invokevirtual 59	com/google/protobuf/CodedInputStream:f	()I
    //   58: putfield 61	com/google/protobuf/Int32Value:value_	I
    //   61: goto -46 -> 15
    //   64: iconst_1
    //   65: istore_3
    //   66: goto -51 -> 15
    //   69: astore_1
    //   70: goto +24 -> 94
    //   73: astore_1
    //   74: new 40	com/google/protobuf/InvalidProtocolBufferException
    //   77: dup
    //   78: aload_1
    //   79: invokespecial 64	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/io/IOException;)V
    //   82: aload_0
    //   83: invokevirtual 68	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   86: athrow
    //   87: astore_1
    //   88: aload_1
    //   89: aload_0
    //   90: invokevirtual 68	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   93: athrow
    //   94: aload_0
    //   95: aload 5
    //   97: invokevirtual 73	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   100: putfield 77	com/google/protobuf/Int32Value:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   103: aload_0
    //   104: invokevirtual 80	com/google/protobuf/Int32Value:makeExtensionsImmutable	()V
    //   107: aload_1
    //   108: athrow
    //   109: aload_0
    //   110: aload 5
    //   112: invokevirtual 73	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   115: putfield 77	com/google/protobuf/Int32Value:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   118: aload_0
    //   119: invokevirtual 80	com/google/protobuf/Int32Value:makeExtensionsImmutable	()V
    //   122: return
    //   123: new 82	java/lang/NullPointerException
    //   126: dup
    //   127: invokespecial 83	java/lang/NullPointerException:<init>	()V
    //   130: astore_1
    //   131: goto +5 -> 136
    //   134: aload_1
    //   135: athrow
    //   136: goto -2 -> 134
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	139	0	this	Int32Value
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
  
  private Int32Value(GeneratedMessageV3.Builder<?> paramBuilder)
  {
    super(paramBuilder);
  }
  
  public static Int32Value getDefaultInstance()
  {
    return a;
  }
  
  public static final Descriptors.Descriptor getDescriptor()
  {
    return WrappersProto.i;
  }
  
  public static Int32Value.Builder newBuilder()
  {
    return a.toBuilder();
  }
  
  public static Int32Value.Builder newBuilder(Int32Value paramInt32Value)
  {
    return a.toBuilder().a(paramInt32Value);
  }
  
  public static Int32Value of(int paramInt)
  {
    return newBuilder().a(paramInt).c();
  }
  
  public static Int32Value parseDelimitedFrom(InputStream paramInputStream)
  {
    return (Int32Value)GeneratedMessageV3.parseDelimitedWithIOException(b, paramInputStream);
  }
  
  public static Int32Value parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (Int32Value)GeneratedMessageV3.parseDelimitedWithIOException(b, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Int32Value parseFrom(ByteString paramByteString)
  {
    return (Int32Value)b.parseFrom(paramByteString);
  }
  
  public static Int32Value parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (Int32Value)b.parseFrom(paramByteString, paramExtensionRegistryLite);
  }
  
  public static Int32Value parseFrom(CodedInputStream paramCodedInputStream)
  {
    return (Int32Value)GeneratedMessageV3.parseWithIOException(b, paramCodedInputStream);
  }
  
  public static Int32Value parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (Int32Value)GeneratedMessageV3.parseWithIOException(b, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static Int32Value parseFrom(InputStream paramInputStream)
  {
    return (Int32Value)GeneratedMessageV3.parseWithIOException(b, paramInputStream);
  }
  
  public static Int32Value parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (Int32Value)GeneratedMessageV3.parseWithIOException(b, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Int32Value parseFrom(ByteBuffer paramByteBuffer)
  {
    return (Int32Value)b.parseFrom(paramByteBuffer);
  }
  
  public static Int32Value parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (Int32Value)b.parseFrom(paramByteBuffer, paramExtensionRegistryLite);
  }
  
  public static Int32Value parseFrom(byte[] paramArrayOfByte)
  {
    return (Int32Value)b.parseFrom(paramArrayOfByte);
  }
  
  public static Int32Value parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (Int32Value)b.parseFrom(paramArrayOfByte, paramExtensionRegistryLite);
  }
  
  public static Parser<Int32Value> parser()
  {
    return b;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof Int32Value)) {
      return super.equals(paramObject);
    }
    paramObject = (Int32Value)paramObject;
    if (getValue() != paramObject.getValue()) {
      return false;
    }
    return this.unknownFields.equals(paramObject.unknownFields);
  }
  
  public Int32Value getDefaultInstanceForType()
  {
    return a;
  }
  
  public Parser<Int32Value> getParserForType()
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
    int j = this.value_;
    if (j != 0) {
      i = 0 + CodedOutputStream.h(1, j);
    }
    i += this.unknownFields.getSerializedSize();
    this.memoizedSize = i;
    return i;
  }
  
  public final UnknownFieldSet getUnknownFields()
  {
    return this.unknownFields;
  }
  
  public int getValue()
  {
    return this.value_;
  }
  
  public int hashCode()
  {
    if (this.memoizedHashCode != 0) {
      return this.memoizedHashCode;
    }
    int i = (((779 + getDescriptor().hashCode()) * 37 + 1) * 53 + getValue()) * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    return i;
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return WrappersProto.j.a(Int32Value.class, Int32Value.Builder.class);
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
  
  public Int32Value.Builder newBuilderForType()
  {
    return newBuilder();
  }
  
  protected Int32Value.Builder newBuilderForType(GeneratedMessageV3.BuilderParent paramBuilderParent)
  {
    return new Int32Value.Builder(paramBuilderParent, null);
  }
  
  protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter paramUnusedPrivateParameter)
  {
    return new Int32Value();
  }
  
  public Int32Value.Builder toBuilder()
  {
    if (this == a) {
      return new Int32Value.Builder(null);
    }
    return new Int32Value.Builder(null).a(this);
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
  {
    int i = this.value_;
    if (i != 0) {
      paramCodedOutputStream.b(1, i);
    }
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.Int32Value
 * JD-Core Version:    0.7.0.1
 */