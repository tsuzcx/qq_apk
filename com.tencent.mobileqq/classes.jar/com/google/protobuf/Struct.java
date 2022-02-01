package com.google.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class Struct
  extends GeneratedMessageV3
  implements StructOrBuilder
{
  public static final int FIELDS_FIELD_NUMBER = 1;
  private static final Struct a = new Struct();
  private static final Parser<Struct> b = new Struct.1();
  private static final long serialVersionUID = 0L;
  private MapField<String, Value> fields_;
  private byte memoizedIsInitialized = -1;
  
  private Struct() {}
  
  /* Error */
  private Struct(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 28	com/google/protobuf/Struct:<init>	()V
    //   4: aload_2
    //   5: ifnull +181 -> 186
    //   8: invokestatic 49	com/google/protobuf/UnknownFieldSet:a	()Lcom/google/protobuf/UnknownFieldSet$Builder;
    //   11: astore 6
    //   13: iconst_0
    //   14: istore 4
    //   16: iconst_0
    //   17: istore_3
    //   18: iload 4
    //   20: ifne +152 -> 172
    //   23: aload_1
    //   24: invokevirtual 54	com/google/protobuf/CodedInputStream:a	()I
    //   27: istore 5
    //   29: iload 5
    //   31: ifeq +95 -> 126
    //   34: iload 5
    //   36: bipush 10
    //   38: if_icmpeq +19 -> 57
    //   41: aload_0
    //   42: aload_1
    //   43: aload 6
    //   45: aload_2
    //   46: iload 5
    //   48: invokevirtual 58	com/google/protobuf/Struct:parseUnknownField	(Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/UnknownFieldSet$Builder;Lcom/google/protobuf/ExtensionRegistryLite;I)Z
    //   51: ifne -33 -> 18
    //   54: goto +72 -> 126
    //   57: iload_3
    //   58: istore 5
    //   60: iload_3
    //   61: iconst_1
    //   62: iand
    //   63: ifne +18 -> 81
    //   66: aload_0
    //   67: getstatic 63	com/google/protobuf/Struct$FieldsDefaultEntryHolder:a	Lcom/google/protobuf/MapEntry;
    //   70: invokestatic 68	com/google/protobuf/MapField:b	(Lcom/google/protobuf/MapEntry;)Lcom/google/protobuf/MapField;
    //   73: putfield 70	com/google/protobuf/Struct:fields_	Lcom/google/protobuf/MapField;
    //   76: iload_3
    //   77: iconst_1
    //   78: ior
    //   79: istore 5
    //   81: aload_1
    //   82: getstatic 63	com/google/protobuf/Struct$FieldsDefaultEntryHolder:a	Lcom/google/protobuf/MapEntry;
    //   85: invokevirtual 76	com/google/protobuf/MapEntry:getParserForType	()Lcom/google/protobuf/Parser;
    //   88: aload_2
    //   89: invokevirtual 79	com/google/protobuf/CodedInputStream:a	(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   92: checkcast 72	com/google/protobuf/MapEntry
    //   95: astore 7
    //   97: aload_0
    //   98: getfield 70	com/google/protobuf/Struct:fields_	Lcom/google/protobuf/MapField;
    //   101: invokevirtual 82	com/google/protobuf/MapField:b	()Ljava/util/Map;
    //   104: aload 7
    //   106: invokevirtual 85	com/google/protobuf/MapEntry:a	()Ljava/lang/Object;
    //   109: aload 7
    //   111: invokevirtual 87	com/google/protobuf/MapEntry:b	()Ljava/lang/Object;
    //   114: invokeinterface 93 3 0
    //   119: pop
    //   120: iload 5
    //   122: istore_3
    //   123: goto -105 -> 18
    //   126: iconst_1
    //   127: istore 4
    //   129: goto -111 -> 18
    //   132: astore_1
    //   133: goto +24 -> 157
    //   136: astore_1
    //   137: new 42	com/google/protobuf/InvalidProtocolBufferException
    //   140: dup
    //   141: aload_1
    //   142: invokespecial 96	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/io/IOException;)V
    //   145: aload_0
    //   146: invokevirtual 100	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   149: athrow
    //   150: astore_1
    //   151: aload_1
    //   152: aload_0
    //   153: invokevirtual 100	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   156: athrow
    //   157: aload_0
    //   158: aload 6
    //   160: invokevirtual 105	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   163: putfield 109	com/google/protobuf/Struct:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   166: aload_0
    //   167: invokevirtual 112	com/google/protobuf/Struct:makeExtensionsImmutable	()V
    //   170: aload_1
    //   171: athrow
    //   172: aload_0
    //   173: aload 6
    //   175: invokevirtual 105	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   178: putfield 109	com/google/protobuf/Struct:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   181: aload_0
    //   182: invokevirtual 112	com/google/protobuf/Struct:makeExtensionsImmutable	()V
    //   185: return
    //   186: new 114	java/lang/NullPointerException
    //   189: dup
    //   190: invokespecial 115	java/lang/NullPointerException:<init>	()V
    //   193: astore_1
    //   194: goto +5 -> 199
    //   197: aload_1
    //   198: athrow
    //   199: goto -2 -> 197
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	202	0	this	Struct
    //   0	202	1	paramCodedInputStream	CodedInputStream
    //   0	202	2	paramExtensionRegistryLite	ExtensionRegistryLite
    //   17	106	3	i	int
    //   14	114	4	j	int
    //   27	94	5	k	int
    //   11	163	6	localBuilder	UnknownFieldSet.Builder
    //   95	15	7	localMapEntry	MapEntry
    // Exception table:
    //   from	to	target	type
    //   23	29	132	finally
    //   41	54	132	finally
    //   66	76	132	finally
    //   81	120	132	finally
    //   137	150	132	finally
    //   151	157	132	finally
    //   23	29	136	java/io/IOException
    //   41	54	136	java/io/IOException
    //   66	76	136	java/io/IOException
    //   81	120	136	java/io/IOException
    //   23	29	150	com/google/protobuf/InvalidProtocolBufferException
    //   41	54	150	com/google/protobuf/InvalidProtocolBufferException
    //   66	76	150	com/google/protobuf/InvalidProtocolBufferException
    //   81	120	150	com/google/protobuf/InvalidProtocolBufferException
  }
  
  private Struct(GeneratedMessageV3.Builder<?> paramBuilder)
  {
    super(paramBuilder);
  }
  
  private MapField<String, Value> a()
  {
    MapField localMapField2 = this.fields_;
    MapField localMapField1 = localMapField2;
    if (localMapField2 == null) {
      localMapField1 = MapField.a(Struct.FieldsDefaultEntryHolder.a);
    }
    return localMapField1;
  }
  
  public static Struct getDefaultInstance()
  {
    return a;
  }
  
  public static final Descriptors.Descriptor getDescriptor()
  {
    return StructProto.a;
  }
  
  public static Struct.Builder newBuilder()
  {
    return a.toBuilder();
  }
  
  public static Struct.Builder newBuilder(Struct paramStruct)
  {
    return a.toBuilder().a(paramStruct);
  }
  
  public static Struct parseDelimitedFrom(InputStream paramInputStream)
  {
    return (Struct)GeneratedMessageV3.parseDelimitedWithIOException(b, paramInputStream);
  }
  
  public static Struct parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (Struct)GeneratedMessageV3.parseDelimitedWithIOException(b, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Struct parseFrom(ByteString paramByteString)
  {
    return (Struct)b.parseFrom(paramByteString);
  }
  
  public static Struct parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (Struct)b.parseFrom(paramByteString, paramExtensionRegistryLite);
  }
  
  public static Struct parseFrom(CodedInputStream paramCodedInputStream)
  {
    return (Struct)GeneratedMessageV3.parseWithIOException(b, paramCodedInputStream);
  }
  
  public static Struct parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (Struct)GeneratedMessageV3.parseWithIOException(b, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static Struct parseFrom(InputStream paramInputStream)
  {
    return (Struct)GeneratedMessageV3.parseWithIOException(b, paramInputStream);
  }
  
  public static Struct parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (Struct)GeneratedMessageV3.parseWithIOException(b, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Struct parseFrom(ByteBuffer paramByteBuffer)
  {
    return (Struct)b.parseFrom(paramByteBuffer);
  }
  
  public static Struct parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (Struct)b.parseFrom(paramByteBuffer, paramExtensionRegistryLite);
  }
  
  public static Struct parseFrom(byte[] paramArrayOfByte)
  {
    return (Struct)b.parseFrom(paramArrayOfByte);
  }
  
  public static Struct parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (Struct)b.parseFrom(paramArrayOfByte, paramExtensionRegistryLite);
  }
  
  public static Parser<Struct> parser()
  {
    return b;
  }
  
  public boolean containsFields(String paramString)
  {
    if (paramString != null) {
      return a().a().containsKey(paramString);
    }
    throw new NullPointerException();
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof Struct)) {
      return super.equals(paramObject);
    }
    paramObject = (Struct)paramObject;
    if (!a().equals(paramObject.a())) {
      return false;
    }
    return this.unknownFields.equals(paramObject.unknownFields);
  }
  
  public Struct getDefaultInstanceForType()
  {
    return a;
  }
  
  @Deprecated
  public Map<String, Value> getFields()
  {
    return getFieldsMap();
  }
  
  public int getFieldsCount()
  {
    return a().a().size();
  }
  
  public Map<String, Value> getFieldsMap()
  {
    return a().a();
  }
  
  public Value getFieldsOrDefault(String paramString, Value paramValue)
  {
    if (paramString != null)
    {
      Map localMap = a().a();
      if (localMap.containsKey(paramString)) {
        paramValue = (Value)localMap.get(paramString);
      }
      return paramValue;
    }
    throw new NullPointerException();
  }
  
  public Value getFieldsOrThrow(String paramString)
  {
    if (paramString != null)
    {
      Map localMap = a().a();
      if (localMap.containsKey(paramString)) {
        return (Value)localMap.get(paramString);
      }
      throw new IllegalArgumentException();
    }
    throw new NullPointerException();
  }
  
  public Parser<Struct> getParserForType()
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
    Iterator localIterator = a().a().entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      i += CodedOutputStream.c(1, Struct.FieldsDefaultEntryHolder.a.c().a(localEntry.getKey()).b(localEntry.getValue()).e());
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
    int j = 779 + getDescriptor().hashCode();
    int i = j;
    if (!a().a().isEmpty()) {
      i = (j * 37 + 1) * 53 + a().hashCode();
    }
    i = i * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    return i;
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return StructProto.b.a(Struct.class, Struct.Builder.class);
  }
  
  protected MapField internalGetMapField(int paramInt)
  {
    if (paramInt == 1) {
      return a();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Invalid map field number: ");
    localStringBuilder.append(paramInt);
    throw new RuntimeException(localStringBuilder.toString());
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
  
  public Struct.Builder newBuilderForType()
  {
    return newBuilder();
  }
  
  protected Struct.Builder newBuilderForType(GeneratedMessageV3.BuilderParent paramBuilderParent)
  {
    return new Struct.Builder(paramBuilderParent, null);
  }
  
  protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter paramUnusedPrivateParameter)
  {
    return new Struct();
  }
  
  public Struct.Builder toBuilder()
  {
    if (this == a) {
      return new Struct.Builder(null);
    }
    return new Struct.Builder(null).a(this);
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
  {
    GeneratedMessageV3.serializeStringMapTo(paramCodedOutputStream, a(), Struct.FieldsDefaultEntryHolder.a, 1);
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.Struct
 * JD-Core Version:    0.7.0.1
 */