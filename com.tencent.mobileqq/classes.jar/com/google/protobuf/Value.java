package com.google.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;

public final class Value
  extends GeneratedMessageV3
  implements ValueOrBuilder
{
  public static final int BOOL_VALUE_FIELD_NUMBER = 4;
  public static final int LIST_VALUE_FIELD_NUMBER = 6;
  public static final int NULL_VALUE_FIELD_NUMBER = 1;
  public static final int NUMBER_VALUE_FIELD_NUMBER = 2;
  public static final int STRING_VALUE_FIELD_NUMBER = 3;
  public static final int STRUCT_VALUE_FIELD_NUMBER = 5;
  private static final Value a = new Value();
  private static final Parser<Value> b = new Value.1();
  private static final long serialVersionUID = 0L;
  private int kindCase_ = 0;
  private Object kind_;
  private byte memoizedIsInitialized = -1;
  
  private Value() {}
  
  /* Error */
  private Value(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 38	com/google/protobuf/Value:<init>	()V
    //   4: aload_2
    //   5: ifnull +369 -> 374
    //   8: invokestatic 61	com/google/protobuf/UnknownFieldSet:a	()Lcom/google/protobuf/UnknownFieldSet$Builder;
    //   11: astore 7
    //   13: iconst_0
    //   14: istore_3
    //   15: iload_3
    //   16: ifne +344 -> 360
    //   19: aload_1
    //   20: invokevirtual 66	com/google/protobuf/CodedInputStream:a	()I
    //   23: istore 4
    //   25: iload 4
    //   27: ifeq +288 -> 315
    //   30: iload 4
    //   32: bipush 8
    //   34: if_icmpeq +258 -> 292
    //   37: iload 4
    //   39: bipush 17
    //   41: if_icmpeq +232 -> 273
    //   44: iload 4
    //   46: bipush 26
    //   48: if_icmpeq +205 -> 253
    //   51: iload 4
    //   53: bipush 32
    //   55: if_icmpeq +179 -> 234
    //   58: aconst_null
    //   59: astore 6
    //   61: aconst_null
    //   62: astore 5
    //   64: iload 4
    //   66: bipush 42
    //   68: if_icmpeq +95 -> 163
    //   71: iload 4
    //   73: bipush 50
    //   75: if_icmpeq +19 -> 94
    //   78: aload_0
    //   79: aload_1
    //   80: aload 7
    //   82: aload_2
    //   83: iload 4
    //   85: invokevirtual 70	com/google/protobuf/Value:parseUnknownField	(Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/UnknownFieldSet$Builder;Lcom/google/protobuf/ExtensionRegistryLite;I)Z
    //   88: ifne -73 -> 15
    //   91: goto +224 -> 315
    //   94: aload_0
    //   95: getfield 49	com/google/protobuf/Value:kindCase_	I
    //   98: bipush 6
    //   100: if_icmpne +15 -> 115
    //   103: aload_0
    //   104: getfield 72	com/google/protobuf/Value:kind_	Ljava/lang/Object;
    //   107: checkcast 74	com/google/protobuf/ListValue
    //   110: invokevirtual 78	com/google/protobuf/ListValue:toBuilder	()Lcom/google/protobuf/ListValue$Builder;
    //   113: astore 5
    //   115: aload_0
    //   116: aload_1
    //   117: invokestatic 82	com/google/protobuf/ListValue:parser	()Lcom/google/protobuf/Parser;
    //   120: aload_2
    //   121: invokevirtual 85	com/google/protobuf/CodedInputStream:a	(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   124: putfield 72	com/google/protobuf/Value:kind_	Ljava/lang/Object;
    //   127: aload 5
    //   129: ifnull +25 -> 154
    //   132: aload 5
    //   134: aload_0
    //   135: getfield 72	com/google/protobuf/Value:kind_	Ljava/lang/Object;
    //   138: checkcast 74	com/google/protobuf/ListValue
    //   141: invokevirtual 90	com/google/protobuf/ListValue$Builder:a	(Lcom/google/protobuf/ListValue;)Lcom/google/protobuf/ListValue$Builder;
    //   144: pop
    //   145: aload_0
    //   146: aload 5
    //   148: invokevirtual 94	com/google/protobuf/ListValue$Builder:d	()Lcom/google/protobuf/ListValue;
    //   151: putfield 72	com/google/protobuf/Value:kind_	Ljava/lang/Object;
    //   154: aload_0
    //   155: bipush 6
    //   157: putfield 49	com/google/protobuf/Value:kindCase_	I
    //   160: goto -145 -> 15
    //   163: aload 6
    //   165: astore 5
    //   167: aload_0
    //   168: getfield 49	com/google/protobuf/Value:kindCase_	I
    //   171: iconst_5
    //   172: if_icmpne +15 -> 187
    //   175: aload_0
    //   176: getfield 72	com/google/protobuf/Value:kind_	Ljava/lang/Object;
    //   179: checkcast 96	com/google/protobuf/Struct
    //   182: invokevirtual 99	com/google/protobuf/Struct:toBuilder	()Lcom/google/protobuf/Struct$Builder;
    //   185: astore 5
    //   187: aload_0
    //   188: aload_1
    //   189: invokestatic 100	com/google/protobuf/Struct:parser	()Lcom/google/protobuf/Parser;
    //   192: aload_2
    //   193: invokevirtual 85	com/google/protobuf/CodedInputStream:a	(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   196: putfield 72	com/google/protobuf/Value:kind_	Ljava/lang/Object;
    //   199: aload 5
    //   201: ifnull +25 -> 226
    //   204: aload 5
    //   206: aload_0
    //   207: getfield 72	com/google/protobuf/Value:kind_	Ljava/lang/Object;
    //   210: checkcast 96	com/google/protobuf/Struct
    //   213: invokevirtual 105	com/google/protobuf/Struct$Builder:a	(Lcom/google/protobuf/Struct;)Lcom/google/protobuf/Struct$Builder;
    //   216: pop
    //   217: aload_0
    //   218: aload 5
    //   220: invokevirtual 108	com/google/protobuf/Struct$Builder:d	()Lcom/google/protobuf/Struct;
    //   223: putfield 72	com/google/protobuf/Value:kind_	Ljava/lang/Object;
    //   226: aload_0
    //   227: iconst_5
    //   228: putfield 49	com/google/protobuf/Value:kindCase_	I
    //   231: goto -216 -> 15
    //   234: aload_0
    //   235: iconst_4
    //   236: putfield 49	com/google/protobuf/Value:kindCase_	I
    //   239: aload_0
    //   240: aload_1
    //   241: invokevirtual 112	com/google/protobuf/CodedInputStream:i	()Z
    //   244: invokestatic 118	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   247: putfield 72	com/google/protobuf/Value:kind_	Ljava/lang/Object;
    //   250: goto -235 -> 15
    //   253: aload_1
    //   254: invokevirtual 122	com/google/protobuf/CodedInputStream:k	()Ljava/lang/String;
    //   257: astore 5
    //   259: aload_0
    //   260: iconst_3
    //   261: putfield 49	com/google/protobuf/Value:kindCase_	I
    //   264: aload_0
    //   265: aload 5
    //   267: putfield 72	com/google/protobuf/Value:kind_	Ljava/lang/Object;
    //   270: goto -255 -> 15
    //   273: aload_0
    //   274: iconst_2
    //   275: putfield 49	com/google/protobuf/Value:kindCase_	I
    //   278: aload_0
    //   279: aload_1
    //   280: invokevirtual 125	com/google/protobuf/CodedInputStream:b	()D
    //   283: invokestatic 130	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   286: putfield 72	com/google/protobuf/Value:kind_	Ljava/lang/Object;
    //   289: goto -274 -> 15
    //   292: aload_1
    //   293: invokevirtual 133	com/google/protobuf/CodedInputStream:n	()I
    //   296: istore 4
    //   298: aload_0
    //   299: iconst_1
    //   300: putfield 49	com/google/protobuf/Value:kindCase_	I
    //   303: aload_0
    //   304: iload 4
    //   306: invokestatic 138	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   309: putfield 72	com/google/protobuf/Value:kind_	Ljava/lang/Object;
    //   312: goto -297 -> 15
    //   315: iconst_1
    //   316: istore_3
    //   317: goto -302 -> 15
    //   320: astore_1
    //   321: goto +24 -> 345
    //   324: astore_1
    //   325: new 54	com/google/protobuf/InvalidProtocolBufferException
    //   328: dup
    //   329: aload_1
    //   330: invokespecial 141	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/io/IOException;)V
    //   333: aload_0
    //   334: invokevirtual 145	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   337: athrow
    //   338: astore_1
    //   339: aload_1
    //   340: aload_0
    //   341: invokevirtual 145	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   344: athrow
    //   345: aload_0
    //   346: aload 7
    //   348: invokevirtual 150	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   351: putfield 154	com/google/protobuf/Value:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   354: aload_0
    //   355: invokevirtual 157	com/google/protobuf/Value:makeExtensionsImmutable	()V
    //   358: aload_1
    //   359: athrow
    //   360: aload_0
    //   361: aload 7
    //   363: invokevirtual 150	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   366: putfield 154	com/google/protobuf/Value:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   369: aload_0
    //   370: invokevirtual 157	com/google/protobuf/Value:makeExtensionsImmutable	()V
    //   373: return
    //   374: new 159	java/lang/NullPointerException
    //   377: dup
    //   378: invokespecial 160	java/lang/NullPointerException:<init>	()V
    //   381: astore_1
    //   382: goto +5 -> 387
    //   385: aload_1
    //   386: athrow
    //   387: goto -2 -> 385
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	390	0	this	Value
    //   0	390	1	paramCodedInputStream	CodedInputStream
    //   0	390	2	paramExtensionRegistryLite	ExtensionRegistryLite
    //   14	303	3	i	int
    //   23	282	4	j	int
    //   62	204	5	localObject1	Object
    //   59	105	6	localObject2	Object
    //   11	351	7	localBuilder	UnknownFieldSet.Builder
    // Exception table:
    //   from	to	target	type
    //   19	25	320	finally
    //   78	91	320	finally
    //   94	115	320	finally
    //   115	127	320	finally
    //   132	154	320	finally
    //   154	160	320	finally
    //   167	187	320	finally
    //   187	199	320	finally
    //   204	226	320	finally
    //   226	231	320	finally
    //   234	250	320	finally
    //   253	270	320	finally
    //   273	289	320	finally
    //   292	312	320	finally
    //   325	338	320	finally
    //   339	345	320	finally
    //   19	25	324	java/io/IOException
    //   78	91	324	java/io/IOException
    //   94	115	324	java/io/IOException
    //   115	127	324	java/io/IOException
    //   132	154	324	java/io/IOException
    //   154	160	324	java/io/IOException
    //   167	187	324	java/io/IOException
    //   187	199	324	java/io/IOException
    //   204	226	324	java/io/IOException
    //   226	231	324	java/io/IOException
    //   234	250	324	java/io/IOException
    //   253	270	324	java/io/IOException
    //   273	289	324	java/io/IOException
    //   292	312	324	java/io/IOException
    //   19	25	338	com/google/protobuf/InvalidProtocolBufferException
    //   78	91	338	com/google/protobuf/InvalidProtocolBufferException
    //   94	115	338	com/google/protobuf/InvalidProtocolBufferException
    //   115	127	338	com/google/protobuf/InvalidProtocolBufferException
    //   132	154	338	com/google/protobuf/InvalidProtocolBufferException
    //   154	160	338	com/google/protobuf/InvalidProtocolBufferException
    //   167	187	338	com/google/protobuf/InvalidProtocolBufferException
    //   187	199	338	com/google/protobuf/InvalidProtocolBufferException
    //   204	226	338	com/google/protobuf/InvalidProtocolBufferException
    //   226	231	338	com/google/protobuf/InvalidProtocolBufferException
    //   234	250	338	com/google/protobuf/InvalidProtocolBufferException
    //   253	270	338	com/google/protobuf/InvalidProtocolBufferException
    //   273	289	338	com/google/protobuf/InvalidProtocolBufferException
    //   292	312	338	com/google/protobuf/InvalidProtocolBufferException
  }
  
  private Value(GeneratedMessageV3.Builder<?> paramBuilder)
  {
    super(paramBuilder);
  }
  
  public static Value getDefaultInstance()
  {
    return a;
  }
  
  public static final Descriptors.Descriptor getDescriptor()
  {
    return StructProto.e;
  }
  
  public static Value.Builder newBuilder()
  {
    return a.toBuilder();
  }
  
  public static Value.Builder newBuilder(Value paramValue)
  {
    return a.toBuilder().a(paramValue);
  }
  
  public static Value parseDelimitedFrom(InputStream paramInputStream)
  {
    return (Value)GeneratedMessageV3.parseDelimitedWithIOException(b, paramInputStream);
  }
  
  public static Value parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (Value)GeneratedMessageV3.parseDelimitedWithIOException(b, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Value parseFrom(ByteString paramByteString)
  {
    return (Value)b.parseFrom(paramByteString);
  }
  
  public static Value parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (Value)b.parseFrom(paramByteString, paramExtensionRegistryLite);
  }
  
  public static Value parseFrom(CodedInputStream paramCodedInputStream)
  {
    return (Value)GeneratedMessageV3.parseWithIOException(b, paramCodedInputStream);
  }
  
  public static Value parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (Value)GeneratedMessageV3.parseWithIOException(b, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static Value parseFrom(InputStream paramInputStream)
  {
    return (Value)GeneratedMessageV3.parseWithIOException(b, paramInputStream);
  }
  
  public static Value parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (Value)GeneratedMessageV3.parseWithIOException(b, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Value parseFrom(ByteBuffer paramByteBuffer)
  {
    return (Value)b.parseFrom(paramByteBuffer);
  }
  
  public static Value parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (Value)b.parseFrom(paramByteBuffer, paramExtensionRegistryLite);
  }
  
  public static Value parseFrom(byte[] paramArrayOfByte)
  {
    return (Value)b.parseFrom(paramArrayOfByte);
  }
  
  public static Value parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (Value)b.parseFrom(paramArrayOfByte, paramExtensionRegistryLite);
  }
  
  public static Parser<Value> parser()
  {
    return b;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof Value)) {
      return super.equals(paramObject);
    }
    paramObject = (Value)paramObject;
    if (!getKindCase().equals(paramObject.getKindCase())) {
      return false;
    }
    switch (this.kindCase_)
    {
    default: 
      break;
    case 6: 
      if (!getListValue().equals(paramObject.getListValue())) {
        return false;
      }
      break;
    case 5: 
      if (!getStructValue().equals(paramObject.getStructValue())) {
        return false;
      }
      break;
    case 4: 
      if (getBoolValue() != paramObject.getBoolValue()) {
        return false;
      }
      break;
    case 3: 
      if (!getStringValue().equals(paramObject.getStringValue())) {
        return false;
      }
      break;
    case 2: 
      if (Double.doubleToLongBits(getNumberValue()) != Double.doubleToLongBits(paramObject.getNumberValue())) {
        return false;
      }
      break;
    case 1: 
      if (getNullValueValue() != paramObject.getNullValueValue()) {
        return false;
      }
      break;
    }
    return this.unknownFields.equals(paramObject.unknownFields);
  }
  
  public boolean getBoolValue()
  {
    if (this.kindCase_ == 4) {
      return ((Boolean)this.kind_).booleanValue();
    }
    return false;
  }
  
  public Value getDefaultInstanceForType()
  {
    return a;
  }
  
  public Value.KindCase getKindCase()
  {
    return Value.KindCase.forNumber(this.kindCase_);
  }
  
  public ListValue getListValue()
  {
    if (this.kindCase_ == 6) {
      return (ListValue)this.kind_;
    }
    return ListValue.getDefaultInstance();
  }
  
  public ListValueOrBuilder getListValueOrBuilder()
  {
    if (this.kindCase_ == 6) {
      return (ListValue)this.kind_;
    }
    return ListValue.getDefaultInstance();
  }
  
  public NullValue getNullValue()
  {
    if (this.kindCase_ == 1)
    {
      NullValue localNullValue2 = NullValue.valueOf(((Integer)this.kind_).intValue());
      NullValue localNullValue1 = localNullValue2;
      if (localNullValue2 == null) {
        localNullValue1 = NullValue.UNRECOGNIZED;
      }
      return localNullValue1;
    }
    return NullValue.NULL_VALUE;
  }
  
  public int getNullValueValue()
  {
    if (this.kindCase_ == 1) {
      return ((Integer)this.kind_).intValue();
    }
    return 0;
  }
  
  public double getNumberValue()
  {
    if (this.kindCase_ == 2) {
      return ((Double)this.kind_).doubleValue();
    }
    return 0.0D;
  }
  
  public Parser<Value> getParserForType()
  {
    return b;
  }
  
  public int getSerializedSize()
  {
    int i = this.memoizedSize;
    if (i != -1) {
      return i;
    }
    int j = 0;
    if (this.kindCase_ == 1) {
      j = 0 + CodedOutputStream.m(1, ((Integer)this.kind_).intValue());
    }
    i = j;
    if (this.kindCase_ == 2) {
      i = j + CodedOutputStream.b(2, ((Double)this.kind_).doubleValue());
    }
    j = i;
    if (this.kindCase_ == 3) {
      j = i + GeneratedMessageV3.computeStringSize(3, this.kind_);
    }
    i = j;
    if (this.kindCase_ == 4) {
      i = j + CodedOutputStream.b(4, ((Boolean)this.kind_).booleanValue());
    }
    j = i;
    if (this.kindCase_ == 5) {
      j = i + CodedOutputStream.c(5, (Struct)this.kind_);
    }
    i = j;
    if (this.kindCase_ == 6) {
      i = j + CodedOutputStream.c(6, (ListValue)this.kind_);
    }
    i += this.unknownFields.getSerializedSize();
    this.memoizedSize = i;
    return i;
  }
  
  public String getStringValue()
  {
    if (this.kindCase_ == 3) {
      localObject = this.kind_;
    } else {
      localObject = "";
    }
    if ((localObject instanceof String)) {
      return (String)localObject;
    }
    Object localObject = ((ByteString)localObject).toStringUtf8();
    if (this.kindCase_ == 3) {
      this.kind_ = localObject;
    }
    return localObject;
  }
  
  public ByteString getStringValueBytes()
  {
    Object localObject;
    if (this.kindCase_ == 3) {
      localObject = this.kind_;
    } else {
      localObject = "";
    }
    if ((localObject instanceof String))
    {
      localObject = ByteString.copyFromUtf8((String)localObject);
      if (this.kindCase_ == 3) {
        this.kind_ = localObject;
      }
      return localObject;
    }
    return (ByteString)localObject;
  }
  
  public Struct getStructValue()
  {
    if (this.kindCase_ == 5) {
      return (Struct)this.kind_;
    }
    return Struct.getDefaultInstance();
  }
  
  public StructOrBuilder getStructValueOrBuilder()
  {
    if (this.kindCase_ == 5) {
      return (Struct)this.kind_;
    }
    return Struct.getDefaultInstance();
  }
  
  public final UnknownFieldSet getUnknownFields()
  {
    return this.unknownFields;
  }
  
  public boolean hasListValue()
  {
    return this.kindCase_ == 6;
  }
  
  public boolean hasStructValue()
  {
    return this.kindCase_ == 5;
  }
  
  public int hashCode()
  {
    if (this.memoizedHashCode != 0) {
      return this.memoizedHashCode;
    }
    int i = 779 + getDescriptor().hashCode();
    int j;
    switch (this.kindCase_)
    {
    default: 
      break;
    case 6: 
      i = (i * 37 + 6) * 53;
      j = getListValue().hashCode();
      break;
    case 5: 
      i = (i * 37 + 5) * 53;
      j = getStructValue().hashCode();
      break;
    case 4: 
      i = (i * 37 + 4) * 53;
      j = Internal.a(getBoolValue());
      break;
    case 3: 
      i = (i * 37 + 3) * 53;
      j = getStringValue().hashCode();
      break;
    case 2: 
      i = (i * 37 + 2) * 53;
      j = Internal.a(Double.doubleToLongBits(getNumberValue()));
      break;
    case 1: 
      i = (i * 37 + 1) * 53;
      j = getNullValueValue();
    }
    i += j;
    i = i * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    return i;
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return StructProto.f.a(Value.class, Value.Builder.class);
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
  
  public Value.Builder newBuilderForType()
  {
    return newBuilder();
  }
  
  protected Value.Builder newBuilderForType(GeneratedMessageV3.BuilderParent paramBuilderParent)
  {
    return new Value.Builder(paramBuilderParent, null);
  }
  
  protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter paramUnusedPrivateParameter)
  {
    return new Value();
  }
  
  public Value.Builder toBuilder()
  {
    if (this == a) {
      return new Value.Builder(null);
    }
    return new Value.Builder(null).a(this);
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
  {
    if (this.kindCase_ == 1) {
      paramCodedOutputStream.g(1, ((Integer)this.kind_).intValue());
    }
    if (this.kindCase_ == 2) {
      paramCodedOutputStream.a(2, ((Double)this.kind_).doubleValue());
    }
    if (this.kindCase_ == 3) {
      GeneratedMessageV3.writeString(paramCodedOutputStream, 3, this.kind_);
    }
    if (this.kindCase_ == 4) {
      paramCodedOutputStream.a(4, ((Boolean)this.kind_).booleanValue());
    }
    if (this.kindCase_ == 5) {
      paramCodedOutputStream.a(5, (Struct)this.kind_);
    }
    if (this.kindCase_ == 6) {
      paramCodedOutputStream.a(6, (ListValue)this.kind_);
    }
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.Value
 * JD-Core Version:    0.7.0.1
 */