package com.google.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;

public final class Timestamp
  extends GeneratedMessageV3
  implements TimestampOrBuilder
{
  public static final int NANOS_FIELD_NUMBER = 2;
  public static final int SECONDS_FIELD_NUMBER = 1;
  private static final Timestamp a = new Timestamp();
  private static final Parser<Timestamp> b = new Timestamp.1();
  private static final long serialVersionUID = 0L;
  private byte memoizedIsInitialized = -1;
  private int nanos_;
  private long seconds_;
  
  private Timestamp() {}
  
  /* Error */
  private Timestamp(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 29	com/google/protobuf/Timestamp:<init>	()V
    //   4: aload_2
    //   5: ifnull +136 -> 141
    //   8: invokestatic 50	com/google/protobuf/UnknownFieldSet:a	()Lcom/google/protobuf/UnknownFieldSet$Builder;
    //   11: astore 5
    //   13: iconst_0
    //   14: istore_3
    //   15: iload_3
    //   16: ifne +111 -> 127
    //   19: aload_1
    //   20: invokevirtual 55	com/google/protobuf/CodedInputStream:a	()I
    //   23: istore 4
    //   25: iload 4
    //   27: ifeq +55 -> 82
    //   30: iload 4
    //   32: bipush 8
    //   34: if_icmpeq +37 -> 71
    //   37: iload 4
    //   39: bipush 16
    //   41: if_icmpeq +19 -> 60
    //   44: aload_0
    //   45: aload_1
    //   46: aload 5
    //   48: aload_2
    //   49: iload 4
    //   51: invokevirtual 59	com/google/protobuf/Timestamp:parseUnknownField	(Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/UnknownFieldSet$Builder;Lcom/google/protobuf/ExtensionRegistryLite;I)Z
    //   54: ifne -39 -> 15
    //   57: goto +25 -> 82
    //   60: aload_0
    //   61: aload_1
    //   62: invokevirtual 62	com/google/protobuf/CodedInputStream:f	()I
    //   65: putfield 64	com/google/protobuf/Timestamp:nanos_	I
    //   68: goto -53 -> 15
    //   71: aload_0
    //   72: aload_1
    //   73: invokevirtual 68	com/google/protobuf/CodedInputStream:e	()J
    //   76: putfield 70	com/google/protobuf/Timestamp:seconds_	J
    //   79: goto -64 -> 15
    //   82: iconst_1
    //   83: istore_3
    //   84: goto -69 -> 15
    //   87: astore_1
    //   88: goto +24 -> 112
    //   91: astore_1
    //   92: new 43	com/google/protobuf/InvalidProtocolBufferException
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
    //   118: putfield 86	com/google/protobuf/Timestamp:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   121: aload_0
    //   122: invokevirtual 89	com/google/protobuf/Timestamp:makeExtensionsImmutable	()V
    //   125: aload_1
    //   126: athrow
    //   127: aload_0
    //   128: aload 5
    //   130: invokevirtual 82	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   133: putfield 86	com/google/protobuf/Timestamp:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   136: aload_0
    //   137: invokevirtual 89	com/google/protobuf/Timestamp:makeExtensionsImmutable	()V
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
    //   0	157	0	this	Timestamp
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
  
  private Timestamp(GeneratedMessageV3.Builder<?> paramBuilder)
  {
    super(paramBuilder);
  }
  
  public static Timestamp getDefaultInstance()
  {
    return a;
  }
  
  public static final Descriptors.Descriptor getDescriptor()
  {
    return TimestampProto.a;
  }
  
  public static Timestamp.Builder newBuilder()
  {
    return a.toBuilder();
  }
  
  public static Timestamp.Builder newBuilder(Timestamp paramTimestamp)
  {
    return a.toBuilder().a(paramTimestamp);
  }
  
  public static Timestamp parseDelimitedFrom(InputStream paramInputStream)
  {
    return (Timestamp)GeneratedMessageV3.parseDelimitedWithIOException(b, paramInputStream);
  }
  
  public static Timestamp parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (Timestamp)GeneratedMessageV3.parseDelimitedWithIOException(b, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Timestamp parseFrom(ByteString paramByteString)
  {
    return (Timestamp)b.parseFrom(paramByteString);
  }
  
  public static Timestamp parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (Timestamp)b.parseFrom(paramByteString, paramExtensionRegistryLite);
  }
  
  public static Timestamp parseFrom(CodedInputStream paramCodedInputStream)
  {
    return (Timestamp)GeneratedMessageV3.parseWithIOException(b, paramCodedInputStream);
  }
  
  public static Timestamp parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (Timestamp)GeneratedMessageV3.parseWithIOException(b, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static Timestamp parseFrom(InputStream paramInputStream)
  {
    return (Timestamp)GeneratedMessageV3.parseWithIOException(b, paramInputStream);
  }
  
  public static Timestamp parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (Timestamp)GeneratedMessageV3.parseWithIOException(b, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Timestamp parseFrom(ByteBuffer paramByteBuffer)
  {
    return (Timestamp)b.parseFrom(paramByteBuffer);
  }
  
  public static Timestamp parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (Timestamp)b.parseFrom(paramByteBuffer, paramExtensionRegistryLite);
  }
  
  public static Timestamp parseFrom(byte[] paramArrayOfByte)
  {
    return (Timestamp)b.parseFrom(paramArrayOfByte);
  }
  
  public static Timestamp parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (Timestamp)b.parseFrom(paramArrayOfByte, paramExtensionRegistryLite);
  }
  
  public static Parser<Timestamp> parser()
  {
    return b;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof Timestamp)) {
      return super.equals(paramObject);
    }
    paramObject = (Timestamp)paramObject;
    if (getSeconds() != paramObject.getSeconds()) {
      return false;
    }
    if (getNanos() != paramObject.getNanos()) {
      return false;
    }
    return this.unknownFields.equals(paramObject.unknownFields);
  }
  
  public Timestamp getDefaultInstanceForType()
  {
    return a;
  }
  
  public int getNanos()
  {
    return this.nanos_;
  }
  
  public Parser<Timestamp> getParserForType()
  {
    return b;
  }
  
  public long getSeconds()
  {
    return this.seconds_;
  }
  
  public int getSerializedSize()
  {
    int i = this.memoizedSize;
    if (i != -1) {
      return i;
    }
    i = 0;
    long l = this.seconds_;
    if (l != 0L) {
      i = 0 + CodedOutputStream.f(1, l);
    }
    int k = this.nanos_;
    int j = i;
    if (k != 0) {
      j = i + CodedOutputStream.h(2, k);
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
    int i = (((((779 + getDescriptor().hashCode()) * 37 + 1) * 53 + Internal.a(getSeconds())) * 37 + 2) * 53 + getNanos()) * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    return i;
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return TimestampProto.b.a(Timestamp.class, Timestamp.Builder.class);
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
  
  public Timestamp.Builder newBuilderForType()
  {
    return newBuilder();
  }
  
  protected Timestamp.Builder newBuilderForType(GeneratedMessageV3.BuilderParent paramBuilderParent)
  {
    return new Timestamp.Builder(paramBuilderParent, null);
  }
  
  protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter paramUnusedPrivateParameter)
  {
    return new Timestamp();
  }
  
  public Timestamp.Builder toBuilder()
  {
    if (this == a) {
      return new Timestamp.Builder(null);
    }
    return new Timestamp.Builder(null).a(this);
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
  {
    long l = this.seconds_;
    if (l != 0L) {
      paramCodedOutputStream.a(1, l);
    }
    int i = this.nanos_;
    if (i != 0) {
      paramCodedOutputStream.b(2, i);
    }
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.Timestamp
 * JD-Core Version:    0.7.0.1
 */