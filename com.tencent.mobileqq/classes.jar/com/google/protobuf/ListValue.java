package com.google.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

public final class ListValue
  extends GeneratedMessageV3
  implements ListValueOrBuilder
{
  public static final int VALUES_FIELD_NUMBER = 1;
  private static final ListValue a = new ListValue();
  private static final Parser<ListValue> b = new ListValue.1();
  private static final long serialVersionUID = 0L;
  private byte memoizedIsInitialized = -1;
  private List<Value> values_;
  
  private ListValue()
  {
    this.values_ = Collections.emptyList();
  }
  
  /* Error */
  private ListValue(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 28	com/google/protobuf/ListValue:<init>	()V
    //   4: aload_2
    //   5: ifnull +243 -> 248
    //   8: invokestatic 57	com/google/protobuf/UnknownFieldSet:a	()Lcom/google/protobuf/UnknownFieldSet$Builder;
    //   11: astore 9
    //   13: iconst_0
    //   14: istore 8
    //   16: iconst_0
    //   17: istore_3
    //   18: iload 8
    //   20: ifne +197 -> 217
    //   23: iload_3
    //   24: istore 5
    //   26: iload_3
    //   27: istore 6
    //   29: iload_3
    //   30: istore 7
    //   32: aload_1
    //   33: invokevirtual 62	com/google/protobuf/CodedInputStream:a	()I
    //   36: istore 4
    //   38: iload 4
    //   40: ifeq +105 -> 145
    //   43: iload 4
    //   45: bipush 10
    //   47: if_icmpeq +28 -> 75
    //   50: iload_3
    //   51: istore 5
    //   53: iload_3
    //   54: istore 6
    //   56: iload_3
    //   57: istore 7
    //   59: aload_0
    //   60: aload_1
    //   61: aload 9
    //   63: aload_2
    //   64: iload 4
    //   66: invokevirtual 66	com/google/protobuf/ListValue:parseUnknownField	(Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/UnknownFieldSet$Builder;Lcom/google/protobuf/ExtensionRegistryLite;I)Z
    //   69: ifne -51 -> 18
    //   72: goto +73 -> 145
    //   75: iload_3
    //   76: istore 4
    //   78: iload_3
    //   79: iconst_1
    //   80: iand
    //   81: ifne +28 -> 109
    //   84: iload_3
    //   85: istore 5
    //   87: iload_3
    //   88: istore 6
    //   90: iload_3
    //   91: istore 7
    //   93: aload_0
    //   94: new 68	java/util/ArrayList
    //   97: dup
    //   98: invokespecial 69	java/util/ArrayList:<init>	()V
    //   101: putfield 47	com/google/protobuf/ListValue:values_	Ljava/util/List;
    //   104: iload_3
    //   105: iconst_1
    //   106: ior
    //   107: istore 4
    //   109: iload 4
    //   111: istore 5
    //   113: iload 4
    //   115: istore 6
    //   117: iload 4
    //   119: istore 7
    //   121: aload_0
    //   122: getfield 47	com/google/protobuf/ListValue:values_	Ljava/util/List;
    //   125: aload_1
    //   126: invokestatic 75	com/google/protobuf/Value:parser	()Lcom/google/protobuf/Parser;
    //   129: aload_2
    //   130: invokevirtual 78	com/google/protobuf/CodedInputStream:a	(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   133: invokeinterface 84 2 0
    //   138: pop
    //   139: iload 4
    //   141: istore_3
    //   142: goto -124 -> 18
    //   145: iconst_1
    //   146: istore 8
    //   148: goto -130 -> 18
    //   151: astore_1
    //   152: goto +32 -> 184
    //   155: astore_1
    //   156: iload 6
    //   158: istore 5
    //   160: new 50	com/google/protobuf/InvalidProtocolBufferException
    //   163: dup
    //   164: aload_1
    //   165: invokespecial 87	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/io/IOException;)V
    //   168: aload_0
    //   169: invokevirtual 91	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   172: athrow
    //   173: astore_1
    //   174: iload 7
    //   176: istore 5
    //   178: aload_1
    //   179: aload_0
    //   180: invokevirtual 91	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   183: athrow
    //   184: iload 5
    //   186: iconst_1
    //   187: iand
    //   188: ifeq +14 -> 202
    //   191: aload_0
    //   192: aload_0
    //   193: getfield 47	com/google/protobuf/ListValue:values_	Ljava/util/List;
    //   196: invokestatic 95	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   199: putfield 47	com/google/protobuf/ListValue:values_	Ljava/util/List;
    //   202: aload_0
    //   203: aload 9
    //   205: invokevirtual 100	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   208: putfield 104	com/google/protobuf/ListValue:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   211: aload_0
    //   212: invokevirtual 107	com/google/protobuf/ListValue:makeExtensionsImmutable	()V
    //   215: aload_1
    //   216: athrow
    //   217: iload_3
    //   218: iconst_1
    //   219: iand
    //   220: ifeq +14 -> 234
    //   223: aload_0
    //   224: aload_0
    //   225: getfield 47	com/google/protobuf/ListValue:values_	Ljava/util/List;
    //   228: invokestatic 95	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   231: putfield 47	com/google/protobuf/ListValue:values_	Ljava/util/List;
    //   234: aload_0
    //   235: aload 9
    //   237: invokevirtual 100	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   240: putfield 104	com/google/protobuf/ListValue:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   243: aload_0
    //   244: invokevirtual 107	com/google/protobuf/ListValue:makeExtensionsImmutable	()V
    //   247: return
    //   248: new 109	java/lang/NullPointerException
    //   251: dup
    //   252: invokespecial 110	java/lang/NullPointerException:<init>	()V
    //   255: astore_1
    //   256: goto +5 -> 261
    //   259: aload_1
    //   260: athrow
    //   261: goto -2 -> 259
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	264	0	this	ListValue
    //   0	264	1	paramCodedInputStream	CodedInputStream
    //   0	264	2	paramExtensionRegistryLite	ExtensionRegistryLite
    //   17	203	3	i	int
    //   36	104	4	j	int
    //   24	164	5	k	int
    //   27	130	6	m	int
    //   30	145	7	n	int
    //   14	133	8	i1	int
    //   11	225	9	localBuilder	UnknownFieldSet.Builder
    // Exception table:
    //   from	to	target	type
    //   32	38	151	finally
    //   59	72	151	finally
    //   93	104	151	finally
    //   121	139	151	finally
    //   160	173	151	finally
    //   178	184	151	finally
    //   32	38	155	java/io/IOException
    //   59	72	155	java/io/IOException
    //   93	104	155	java/io/IOException
    //   121	139	155	java/io/IOException
    //   32	38	173	com/google/protobuf/InvalidProtocolBufferException
    //   59	72	173	com/google/protobuf/InvalidProtocolBufferException
    //   93	104	173	com/google/protobuf/InvalidProtocolBufferException
    //   121	139	173	com/google/protobuf/InvalidProtocolBufferException
  }
  
  private ListValue(GeneratedMessageV3.Builder<?> paramBuilder)
  {
    super(paramBuilder);
  }
  
  public static ListValue getDefaultInstance()
  {
    return a;
  }
  
  public static final Descriptors.Descriptor getDescriptor()
  {
    return StructProto.g;
  }
  
  public static ListValue.Builder newBuilder()
  {
    return a.toBuilder();
  }
  
  public static ListValue.Builder newBuilder(ListValue paramListValue)
  {
    return a.toBuilder().a(paramListValue);
  }
  
  public static ListValue parseDelimitedFrom(InputStream paramInputStream)
  {
    return (ListValue)GeneratedMessageV3.parseDelimitedWithIOException(b, paramInputStream);
  }
  
  public static ListValue parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (ListValue)GeneratedMessageV3.parseDelimitedWithIOException(b, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static ListValue parseFrom(ByteString paramByteString)
  {
    return (ListValue)b.parseFrom(paramByteString);
  }
  
  public static ListValue parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (ListValue)b.parseFrom(paramByteString, paramExtensionRegistryLite);
  }
  
  public static ListValue parseFrom(CodedInputStream paramCodedInputStream)
  {
    return (ListValue)GeneratedMessageV3.parseWithIOException(b, paramCodedInputStream);
  }
  
  public static ListValue parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (ListValue)GeneratedMessageV3.parseWithIOException(b, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static ListValue parseFrom(InputStream paramInputStream)
  {
    return (ListValue)GeneratedMessageV3.parseWithIOException(b, paramInputStream);
  }
  
  public static ListValue parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (ListValue)GeneratedMessageV3.parseWithIOException(b, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static ListValue parseFrom(ByteBuffer paramByteBuffer)
  {
    return (ListValue)b.parseFrom(paramByteBuffer);
  }
  
  public static ListValue parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (ListValue)b.parseFrom(paramByteBuffer, paramExtensionRegistryLite);
  }
  
  public static ListValue parseFrom(byte[] paramArrayOfByte)
  {
    return (ListValue)b.parseFrom(paramArrayOfByte);
  }
  
  public static ListValue parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (ListValue)b.parseFrom(paramArrayOfByte, paramExtensionRegistryLite);
  }
  
  public static Parser<ListValue> parser()
  {
    return b;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof ListValue)) {
      return super.equals(paramObject);
    }
    paramObject = (ListValue)paramObject;
    if (!getValuesList().equals(paramObject.getValuesList())) {
      return false;
    }
    return this.unknownFields.equals(paramObject.unknownFields);
  }
  
  public ListValue getDefaultInstanceForType()
  {
    return a;
  }
  
  public Parser<ListValue> getParserForType()
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
    int j = 0;
    while (i < this.values_.size())
    {
      j += CodedOutputStream.c(1, (MessageLite)this.values_.get(i));
      i += 1;
    }
    i = j + this.unknownFields.getSerializedSize();
    this.memoizedSize = i;
    return i;
  }
  
  public final UnknownFieldSet getUnknownFields()
  {
    return this.unknownFields;
  }
  
  public Value getValues(int paramInt)
  {
    return (Value)this.values_.get(paramInt);
  }
  
  public int getValuesCount()
  {
    return this.values_.size();
  }
  
  public List<Value> getValuesList()
  {
    return this.values_;
  }
  
  public ValueOrBuilder getValuesOrBuilder(int paramInt)
  {
    return (ValueOrBuilder)this.values_.get(paramInt);
  }
  
  public List<? extends ValueOrBuilder> getValuesOrBuilderList()
  {
    return this.values_;
  }
  
  public int hashCode()
  {
    if (this.memoizedHashCode != 0) {
      return this.memoizedHashCode;
    }
    int j = 779 + getDescriptor().hashCode();
    int i = j;
    if (getValuesCount() > 0) {
      i = (j * 37 + 1) * 53 + getValuesList().hashCode();
    }
    i = i * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    return i;
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return StructProto.h.a(ListValue.class, ListValue.Builder.class);
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
  
  public ListValue.Builder newBuilderForType()
  {
    return newBuilder();
  }
  
  protected ListValue.Builder newBuilderForType(GeneratedMessageV3.BuilderParent paramBuilderParent)
  {
    return new ListValue.Builder(paramBuilderParent, null);
  }
  
  protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter paramUnusedPrivateParameter)
  {
    return new ListValue();
  }
  
  public ListValue.Builder toBuilder()
  {
    if (this == a) {
      return new ListValue.Builder(null);
    }
    return new ListValue.Builder(null).a(this);
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
  {
    int i = 0;
    while (i < this.values_.size())
    {
      paramCodedOutputStream.a(1, (MessageLite)this.values_.get(i));
      i += 1;
    }
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.ListValue
 * JD-Core Version:    0.7.0.1
 */