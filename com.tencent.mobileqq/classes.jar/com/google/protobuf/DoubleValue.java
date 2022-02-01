package com.google.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;

public final class DoubleValue
  extends GeneratedMessageV3
  implements DoubleValueOrBuilder
{
  public static final int VALUE_FIELD_NUMBER = 1;
  private static final DoubleValue a = new DoubleValue();
  private static final Parser<DoubleValue> b = new DoubleValue.1();
  private static final long serialVersionUID = 0L;
  private byte memoizedIsInitialized = -1;
  private double value_;
  
  private DoubleValue() {}
  
  /* Error */
  private DoubleValue(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 27	com/google/protobuf/DoubleValue:<init>	()V
    //   4: aload_2
    //   5: ifnull +118 -> 123
    //   8: invokestatic 48	com/google/protobuf/UnknownFieldSet:a	()Lcom/google/protobuf/UnknownFieldSet$Builder;
    //   11: astore 5
    //   13: iconst_0
    //   14: istore_3
    //   15: iload_3
    //   16: ifne +93 -> 109
    //   19: aload_1
    //   20: invokevirtual 53	com/google/protobuf/CodedInputStream:a	()I
    //   23: istore 4
    //   25: iload 4
    //   27: ifeq +37 -> 64
    //   30: iload 4
    //   32: bipush 9
    //   34: if_icmpeq +19 -> 53
    //   37: aload_0
    //   38: aload_1
    //   39: aload 5
    //   41: aload_2
    //   42: iload 4
    //   44: invokevirtual 57	com/google/protobuf/DoubleValue:parseUnknownField	(Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/UnknownFieldSet$Builder;Lcom/google/protobuf/ExtensionRegistryLite;I)Z
    //   47: ifne -32 -> 15
    //   50: goto +14 -> 64
    //   53: aload_0
    //   54: aload_1
    //   55: invokevirtual 60	com/google/protobuf/CodedInputStream:b	()D
    //   58: putfield 62	com/google/protobuf/DoubleValue:value_	D
    //   61: goto -46 -> 15
    //   64: iconst_1
    //   65: istore_3
    //   66: goto -51 -> 15
    //   69: astore_1
    //   70: goto +24 -> 94
    //   73: astore_1
    //   74: new 41	com/google/protobuf/InvalidProtocolBufferException
    //   77: dup
    //   78: aload_1
    //   79: invokespecial 65	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/io/IOException;)V
    //   82: aload_0
    //   83: invokevirtual 69	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   86: athrow
    //   87: astore_1
    //   88: aload_1
    //   89: aload_0
    //   90: invokevirtual 69	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   93: athrow
    //   94: aload_0
    //   95: aload 5
    //   97: invokevirtual 74	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   100: putfield 78	com/google/protobuf/DoubleValue:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   103: aload_0
    //   104: invokevirtual 81	com/google/protobuf/DoubleValue:makeExtensionsImmutable	()V
    //   107: aload_1
    //   108: athrow
    //   109: aload_0
    //   110: aload 5
    //   112: invokevirtual 74	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   115: putfield 78	com/google/protobuf/DoubleValue:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   118: aload_0
    //   119: invokevirtual 81	com/google/protobuf/DoubleValue:makeExtensionsImmutable	()V
    //   122: return
    //   123: new 83	java/lang/NullPointerException
    //   126: dup
    //   127: invokespecial 84	java/lang/NullPointerException:<init>	()V
    //   130: astore_1
    //   131: goto +5 -> 136
    //   134: aload_1
    //   135: athrow
    //   136: goto -2 -> 134
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	139	0	this	DoubleValue
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
  
  private DoubleValue(GeneratedMessageV3.Builder<?> paramBuilder)
  {
    super(paramBuilder);
  }
  
  public static DoubleValue getDefaultInstance()
  {
    return a;
  }
  
  public static final Descriptors.Descriptor getDescriptor()
  {
    return WrappersProto.a;
  }
  
  public static DoubleValue.Builder newBuilder()
  {
    return a.toBuilder();
  }
  
  public static DoubleValue.Builder newBuilder(DoubleValue paramDoubleValue)
  {
    return a.toBuilder().a(paramDoubleValue);
  }
  
  public static DoubleValue of(double paramDouble)
  {
    return newBuilder().a(paramDouble).c();
  }
  
  public static DoubleValue parseDelimitedFrom(InputStream paramInputStream)
  {
    return (DoubleValue)GeneratedMessageV3.parseDelimitedWithIOException(b, paramInputStream);
  }
  
  public static DoubleValue parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (DoubleValue)GeneratedMessageV3.parseDelimitedWithIOException(b, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static DoubleValue parseFrom(ByteString paramByteString)
  {
    return (DoubleValue)b.parseFrom(paramByteString);
  }
  
  public static DoubleValue parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (DoubleValue)b.parseFrom(paramByteString, paramExtensionRegistryLite);
  }
  
  public static DoubleValue parseFrom(CodedInputStream paramCodedInputStream)
  {
    return (DoubleValue)GeneratedMessageV3.parseWithIOException(b, paramCodedInputStream);
  }
  
  public static DoubleValue parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (DoubleValue)GeneratedMessageV3.parseWithIOException(b, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static DoubleValue parseFrom(InputStream paramInputStream)
  {
    return (DoubleValue)GeneratedMessageV3.parseWithIOException(b, paramInputStream);
  }
  
  public static DoubleValue parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (DoubleValue)GeneratedMessageV3.parseWithIOException(b, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static DoubleValue parseFrom(ByteBuffer paramByteBuffer)
  {
    return (DoubleValue)b.parseFrom(paramByteBuffer);
  }
  
  public static DoubleValue parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (DoubleValue)b.parseFrom(paramByteBuffer, paramExtensionRegistryLite);
  }
  
  public static DoubleValue parseFrom(byte[] paramArrayOfByte)
  {
    return (DoubleValue)b.parseFrom(paramArrayOfByte);
  }
  
  public static DoubleValue parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (DoubleValue)b.parseFrom(paramArrayOfByte, paramExtensionRegistryLite);
  }
  
  public static Parser<DoubleValue> parser()
  {
    return b;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof DoubleValue)) {
      return super.equals(paramObject);
    }
    paramObject = (DoubleValue)paramObject;
    if (Double.doubleToLongBits(getValue()) != Double.doubleToLongBits(paramObject.getValue())) {
      return false;
    }
    return this.unknownFields.equals(paramObject.unknownFields);
  }
  
  public DoubleValue getDefaultInstanceForType()
  {
    return a;
  }
  
  public Parser<DoubleValue> getParserForType()
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
    double d = this.value_;
    if (d != 0.0D) {
      i = 0 + CodedOutputStream.b(1, d);
    }
    i += this.unknownFields.getSerializedSize();
    this.memoizedSize = i;
    return i;
  }
  
  public final UnknownFieldSet getUnknownFields()
  {
    return this.unknownFields;
  }
  
  public double getValue()
  {
    return this.value_;
  }
  
  public int hashCode()
  {
    if (this.memoizedHashCode != 0) {
      return this.memoizedHashCode;
    }
    int i = (((779 + getDescriptor().hashCode()) * 37 + 1) * 53 + Internal.a(Double.doubleToLongBits(getValue()))) * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    return i;
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return WrappersProto.b.a(DoubleValue.class, DoubleValue.Builder.class);
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
  
  public DoubleValue.Builder newBuilderForType()
  {
    return newBuilder();
  }
  
  protected DoubleValue.Builder newBuilderForType(GeneratedMessageV3.BuilderParent paramBuilderParent)
  {
    return new DoubleValue.Builder(paramBuilderParent, null);
  }
  
  protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter paramUnusedPrivateParameter)
  {
    return new DoubleValue();
  }
  
  public DoubleValue.Builder toBuilder()
  {
    if (this == a) {
      return new DoubleValue.Builder(null);
    }
    return new DoubleValue.Builder(null).a(this);
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
  {
    double d = this.value_;
    if (d != 0.0D) {
      paramCodedOutputStream.a(1, d);
    }
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.DoubleValue
 * JD-Core Version:    0.7.0.1
 */