package com.google.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

public final class Field
  extends GeneratedMessageV3
  implements FieldOrBuilder
{
  public static final int CARDINALITY_FIELD_NUMBER = 2;
  public static final int DEFAULT_VALUE_FIELD_NUMBER = 11;
  public static final int JSON_NAME_FIELD_NUMBER = 10;
  public static final int KIND_FIELD_NUMBER = 1;
  public static final int NAME_FIELD_NUMBER = 4;
  public static final int NUMBER_FIELD_NUMBER = 3;
  public static final int ONEOF_INDEX_FIELD_NUMBER = 7;
  public static final int OPTIONS_FIELD_NUMBER = 9;
  public static final int PACKED_FIELD_NUMBER = 8;
  public static final int TYPE_URL_FIELD_NUMBER = 6;
  private static final Field a = new Field();
  private static final Parser<Field> b = new Field.1();
  private static final long serialVersionUID = 0L;
  private int cardinality_;
  private volatile Object defaultValue_;
  private volatile Object jsonName_;
  private int kind_;
  private byte memoizedIsInitialized = -1;
  private volatile Object name_;
  private int number_;
  private int oneofIndex_;
  private List<Option> options_;
  private boolean packed_;
  private volatile Object typeUrl_;
  
  private Field()
  {
    this.kind_ = 0;
    this.cardinality_ = 0;
    this.name_ = "";
    this.typeUrl_ = "";
    this.options_ = Collections.emptyList();
    this.jsonName_ = "";
    this.defaultValue_ = "";
  }
  
  /* Error */
  private Field(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 57	com/google/protobuf/Field:<init>	()V
    //   4: aload_2
    //   5: ifnull +520 -> 525
    //   8: invokestatic 100	com/google/protobuf/UnknownFieldSet:a	()Lcom/google/protobuf/UnknownFieldSet$Builder;
    //   11: astore 10
    //   13: iconst_0
    //   14: istore 8
    //   16: iconst_0
    //   17: istore_3
    //   18: iload 8
    //   20: ifne +474 -> 494
    //   23: iload_3
    //   24: istore 5
    //   26: iload_3
    //   27: istore 6
    //   29: iload_3
    //   30: istore 7
    //   32: aload_1
    //   33: invokevirtual 105	com/google/protobuf/CodedInputStream:a	()I
    //   36: istore 4
    //   38: iload 4
    //   40: lookupswitch	default:+501->541, 0:+374->414, 8:+354->394, 16:+334->374, 24:+314->354, 34:+294->334, 50:+274->314, 56:+254->294, 64:+234->274, 74:+164->204, 82:+144->184, 90:+124->164
    //   141: istore 5
    //   143: iload_3
    //   144: istore 6
    //   146: iload_3
    //   147: istore 7
    //   149: aload_0
    //   150: aload_1
    //   151: aload 10
    //   153: aload_2
    //   154: iload 4
    //   156: invokevirtual 109	com/google/protobuf/Field:parseUnknownField	(Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/UnknownFieldSet$Builder;Lcom/google/protobuf/ExtensionRegistryLite;I)Z
    //   159: istore 9
    //   161: goto +259 -> 420
    //   164: iload_3
    //   165: istore 5
    //   167: iload_3
    //   168: istore 6
    //   170: iload_3
    //   171: istore 7
    //   173: aload_0
    //   174: aload_1
    //   175: invokevirtual 113	com/google/protobuf/CodedInputStream:k	()Ljava/lang/String;
    //   178: putfield 90	com/google/protobuf/Field:defaultValue_	Ljava/lang/Object;
    //   181: goto -163 -> 18
    //   184: iload_3
    //   185: istore 5
    //   187: iload_3
    //   188: istore 6
    //   190: iload_3
    //   191: istore 7
    //   193: aload_0
    //   194: aload_1
    //   195: invokevirtual 113	com/google/protobuf/CodedInputStream:k	()Ljava/lang/String;
    //   198: putfield 88	com/google/protobuf/Field:jsonName_	Ljava/lang/Object;
    //   201: goto -183 -> 18
    //   204: iload_3
    //   205: istore 4
    //   207: iload_3
    //   208: iconst_1
    //   209: iand
    //   210: ifne +28 -> 238
    //   213: iload_3
    //   214: istore 5
    //   216: iload_3
    //   217: istore 6
    //   219: iload_3
    //   220: istore 7
    //   222: aload_0
    //   223: new 115	java/util/ArrayList
    //   226: dup
    //   227: invokespecial 116	java/util/ArrayList:<init>	()V
    //   230: putfield 86	com/google/protobuf/Field:options_	Ljava/util/List;
    //   233: iload_3
    //   234: iconst_1
    //   235: ior
    //   236: istore 4
    //   238: iload 4
    //   240: istore 5
    //   242: iload 4
    //   244: istore 6
    //   246: iload 4
    //   248: istore 7
    //   250: aload_0
    //   251: getfield 86	com/google/protobuf/Field:options_	Ljava/util/List;
    //   254: aload_1
    //   255: invokestatic 122	com/google/protobuf/Option:parser	()Lcom/google/protobuf/Parser;
    //   258: aload_2
    //   259: invokevirtual 125	com/google/protobuf/CodedInputStream:a	(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   262: invokeinterface 131 2 0
    //   267: pop
    //   268: iload 4
    //   270: istore_3
    //   271: goto -253 -> 18
    //   274: iload_3
    //   275: istore 5
    //   277: iload_3
    //   278: istore 6
    //   280: iload_3
    //   281: istore 7
    //   283: aload_0
    //   284: aload_1
    //   285: invokevirtual 135	com/google/protobuf/CodedInputStream:i	()Z
    //   288: putfield 137	com/google/protobuf/Field:packed_	Z
    //   291: goto -273 -> 18
    //   294: iload_3
    //   295: istore 5
    //   297: iload_3
    //   298: istore 6
    //   300: iload_3
    //   301: istore 7
    //   303: aload_0
    //   304: aload_1
    //   305: invokevirtual 140	com/google/protobuf/CodedInputStream:f	()I
    //   308: putfield 142	com/google/protobuf/Field:oneofIndex_	I
    //   311: goto -293 -> 18
    //   314: iload_3
    //   315: istore 5
    //   317: iload_3
    //   318: istore 6
    //   320: iload_3
    //   321: istore 7
    //   323: aload_0
    //   324: aload_1
    //   325: invokevirtual 113	com/google/protobuf/CodedInputStream:k	()Ljava/lang/String;
    //   328: putfield 78	com/google/protobuf/Field:typeUrl_	Ljava/lang/Object;
    //   331: goto -313 -> 18
    //   334: iload_3
    //   335: istore 5
    //   337: iload_3
    //   338: istore 6
    //   340: iload_3
    //   341: istore 7
    //   343: aload_0
    //   344: aload_1
    //   345: invokevirtual 113	com/google/protobuf/CodedInputStream:k	()Ljava/lang/String;
    //   348: putfield 76	com/google/protobuf/Field:name_	Ljava/lang/Object;
    //   351: goto -333 -> 18
    //   354: iload_3
    //   355: istore 5
    //   357: iload_3
    //   358: istore 6
    //   360: iload_3
    //   361: istore 7
    //   363: aload_0
    //   364: aload_1
    //   365: invokevirtual 140	com/google/protobuf/CodedInputStream:f	()I
    //   368: putfield 144	com/google/protobuf/Field:number_	I
    //   371: goto -353 -> 18
    //   374: iload_3
    //   375: istore 5
    //   377: iload_3
    //   378: istore 6
    //   380: iload_3
    //   381: istore 7
    //   383: aload_0
    //   384: aload_1
    //   385: invokevirtual 147	com/google/protobuf/CodedInputStream:n	()I
    //   388: putfield 72	com/google/protobuf/Field:cardinality_	I
    //   391: goto -373 -> 18
    //   394: iload_3
    //   395: istore 5
    //   397: iload_3
    //   398: istore 6
    //   400: iload_3
    //   401: istore 7
    //   403: aload_0
    //   404: aload_1
    //   405: invokevirtual 147	com/google/protobuf/CodedInputStream:n	()I
    //   408: putfield 70	com/google/protobuf/Field:kind_	I
    //   411: goto -393 -> 18
    //   414: iconst_1
    //   415: istore 8
    //   417: goto -399 -> 18
    //   420: iload 9
    //   422: ifne -404 -> 18
    //   425: goto -11 -> 414
    //   428: astore_1
    //   429: goto +32 -> 461
    //   432: astore_1
    //   433: iload 6
    //   435: istore 5
    //   437: new 93	com/google/protobuf/InvalidProtocolBufferException
    //   440: dup
    //   441: aload_1
    //   442: invokespecial 150	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/io/IOException;)V
    //   445: aload_0
    //   446: invokevirtual 154	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   449: athrow
    //   450: astore_1
    //   451: iload 7
    //   453: istore 5
    //   455: aload_1
    //   456: aload_0
    //   457: invokevirtual 154	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   460: athrow
    //   461: iload 5
    //   463: iconst_1
    //   464: iand
    //   465: ifeq +14 -> 479
    //   468: aload_0
    //   469: aload_0
    //   470: getfield 86	com/google/protobuf/Field:options_	Ljava/util/List;
    //   473: invokestatic 158	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   476: putfield 86	com/google/protobuf/Field:options_	Ljava/util/List;
    //   479: aload_0
    //   480: aload 10
    //   482: invokevirtual 163	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   485: putfield 167	com/google/protobuf/Field:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   488: aload_0
    //   489: invokevirtual 170	com/google/protobuf/Field:makeExtensionsImmutable	()V
    //   492: aload_1
    //   493: athrow
    //   494: iload_3
    //   495: iconst_1
    //   496: iand
    //   497: ifeq +14 -> 511
    //   500: aload_0
    //   501: aload_0
    //   502: getfield 86	com/google/protobuf/Field:options_	Ljava/util/List;
    //   505: invokestatic 158	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   508: putfield 86	com/google/protobuf/Field:options_	Ljava/util/List;
    //   511: aload_0
    //   512: aload 10
    //   514: invokevirtual 163	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   517: putfield 167	com/google/protobuf/Field:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   520: aload_0
    //   521: invokevirtual 170	com/google/protobuf/Field:makeExtensionsImmutable	()V
    //   524: return
    //   525: new 172	java/lang/NullPointerException
    //   528: dup
    //   529: invokespecial 173	java/lang/NullPointerException:<init>	()V
    //   532: astore_1
    //   533: goto +5 -> 538
    //   536: aload_1
    //   537: athrow
    //   538: goto -2 -> 536
    //   541: goto -401 -> 140
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	544	0	this	Field
    //   0	544	1	paramCodedInputStream	CodedInputStream
    //   0	544	2	paramExtensionRegistryLite	ExtensionRegistryLite
    //   17	480	3	i	int
    //   36	233	4	j	int
    //   24	441	5	k	int
    //   27	407	6	m	int
    //   30	422	7	n	int
    //   14	402	8	i1	int
    //   159	262	9	bool	boolean
    //   11	502	10	localBuilder	UnknownFieldSet.Builder
    // Exception table:
    //   from	to	target	type
    //   32	38	428	finally
    //   149	161	428	finally
    //   173	181	428	finally
    //   193	201	428	finally
    //   222	233	428	finally
    //   250	268	428	finally
    //   283	291	428	finally
    //   303	311	428	finally
    //   323	331	428	finally
    //   343	351	428	finally
    //   363	371	428	finally
    //   383	391	428	finally
    //   403	411	428	finally
    //   437	450	428	finally
    //   455	461	428	finally
    //   32	38	432	java/io/IOException
    //   149	161	432	java/io/IOException
    //   173	181	432	java/io/IOException
    //   193	201	432	java/io/IOException
    //   222	233	432	java/io/IOException
    //   250	268	432	java/io/IOException
    //   283	291	432	java/io/IOException
    //   303	311	432	java/io/IOException
    //   323	331	432	java/io/IOException
    //   343	351	432	java/io/IOException
    //   363	371	432	java/io/IOException
    //   383	391	432	java/io/IOException
    //   403	411	432	java/io/IOException
    //   32	38	450	com/google/protobuf/InvalidProtocolBufferException
    //   149	161	450	com/google/protobuf/InvalidProtocolBufferException
    //   173	181	450	com/google/protobuf/InvalidProtocolBufferException
    //   193	201	450	com/google/protobuf/InvalidProtocolBufferException
    //   222	233	450	com/google/protobuf/InvalidProtocolBufferException
    //   250	268	450	com/google/protobuf/InvalidProtocolBufferException
    //   283	291	450	com/google/protobuf/InvalidProtocolBufferException
    //   303	311	450	com/google/protobuf/InvalidProtocolBufferException
    //   323	331	450	com/google/protobuf/InvalidProtocolBufferException
    //   343	351	450	com/google/protobuf/InvalidProtocolBufferException
    //   363	371	450	com/google/protobuf/InvalidProtocolBufferException
    //   383	391	450	com/google/protobuf/InvalidProtocolBufferException
    //   403	411	450	com/google/protobuf/InvalidProtocolBufferException
  }
  
  private Field(GeneratedMessageV3.Builder<?> paramBuilder)
  {
    super(paramBuilder);
  }
  
  public static Field getDefaultInstance()
  {
    return a;
  }
  
  public static final Descriptors.Descriptor getDescriptor()
  {
    return TypeProto.c;
  }
  
  public static Field.Builder newBuilder()
  {
    return a.toBuilder();
  }
  
  public static Field.Builder newBuilder(Field paramField)
  {
    return a.toBuilder().a(paramField);
  }
  
  public static Field parseDelimitedFrom(InputStream paramInputStream)
  {
    return (Field)GeneratedMessageV3.parseDelimitedWithIOException(b, paramInputStream);
  }
  
  public static Field parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (Field)GeneratedMessageV3.parseDelimitedWithIOException(b, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Field parseFrom(ByteString paramByteString)
  {
    return (Field)b.parseFrom(paramByteString);
  }
  
  public static Field parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (Field)b.parseFrom(paramByteString, paramExtensionRegistryLite);
  }
  
  public static Field parseFrom(CodedInputStream paramCodedInputStream)
  {
    return (Field)GeneratedMessageV3.parseWithIOException(b, paramCodedInputStream);
  }
  
  public static Field parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (Field)GeneratedMessageV3.parseWithIOException(b, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static Field parseFrom(InputStream paramInputStream)
  {
    return (Field)GeneratedMessageV3.parseWithIOException(b, paramInputStream);
  }
  
  public static Field parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (Field)GeneratedMessageV3.parseWithIOException(b, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Field parseFrom(ByteBuffer paramByteBuffer)
  {
    return (Field)b.parseFrom(paramByteBuffer);
  }
  
  public static Field parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (Field)b.parseFrom(paramByteBuffer, paramExtensionRegistryLite);
  }
  
  public static Field parseFrom(byte[] paramArrayOfByte)
  {
    return (Field)b.parseFrom(paramArrayOfByte);
  }
  
  public static Field parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (Field)b.parseFrom(paramArrayOfByte, paramExtensionRegistryLite);
  }
  
  public static Parser<Field> parser()
  {
    return b;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof Field)) {
      return super.equals(paramObject);
    }
    paramObject = (Field)paramObject;
    if (this.kind_ != paramObject.kind_) {
      return false;
    }
    if (this.cardinality_ != paramObject.cardinality_) {
      return false;
    }
    if (getNumber() != paramObject.getNumber()) {
      return false;
    }
    if (!getName().equals(paramObject.getName())) {
      return false;
    }
    if (!getTypeUrl().equals(paramObject.getTypeUrl())) {
      return false;
    }
    if (getOneofIndex() != paramObject.getOneofIndex()) {
      return false;
    }
    if (getPacked() != paramObject.getPacked()) {
      return false;
    }
    if (!getOptionsList().equals(paramObject.getOptionsList())) {
      return false;
    }
    if (!getJsonName().equals(paramObject.getJsonName())) {
      return false;
    }
    if (!getDefaultValue().equals(paramObject.getDefaultValue())) {
      return false;
    }
    return this.unknownFields.equals(paramObject.unknownFields);
  }
  
  public Field.Cardinality getCardinality()
  {
    Field.Cardinality localCardinality2 = Field.Cardinality.valueOf(this.cardinality_);
    Field.Cardinality localCardinality1 = localCardinality2;
    if (localCardinality2 == null) {
      localCardinality1 = Field.Cardinality.UNRECOGNIZED;
    }
    return localCardinality1;
  }
  
  public int getCardinalityValue()
  {
    return this.cardinality_;
  }
  
  public Field getDefaultInstanceForType()
  {
    return a;
  }
  
  public String getDefaultValue()
  {
    Object localObject = this.defaultValue_;
    if ((localObject instanceof String)) {
      return (String)localObject;
    }
    localObject = ((ByteString)localObject).toStringUtf8();
    this.defaultValue_ = localObject;
    return localObject;
  }
  
  public ByteString getDefaultValueBytes()
  {
    Object localObject = this.defaultValue_;
    if ((localObject instanceof String))
    {
      localObject = ByteString.copyFromUtf8((String)localObject);
      this.defaultValue_ = localObject;
      return localObject;
    }
    return (ByteString)localObject;
  }
  
  public String getJsonName()
  {
    Object localObject = this.jsonName_;
    if ((localObject instanceof String)) {
      return (String)localObject;
    }
    localObject = ((ByteString)localObject).toStringUtf8();
    this.jsonName_ = localObject;
    return localObject;
  }
  
  public ByteString getJsonNameBytes()
  {
    Object localObject = this.jsonName_;
    if ((localObject instanceof String))
    {
      localObject = ByteString.copyFromUtf8((String)localObject);
      this.jsonName_ = localObject;
      return localObject;
    }
    return (ByteString)localObject;
  }
  
  public Field.Kind getKind()
  {
    Field.Kind localKind2 = Field.Kind.valueOf(this.kind_);
    Field.Kind localKind1 = localKind2;
    if (localKind2 == null) {
      localKind1 = Field.Kind.UNRECOGNIZED;
    }
    return localKind1;
  }
  
  public int getKindValue()
  {
    return this.kind_;
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
  
  public int getNumber()
  {
    return this.number_;
  }
  
  public int getOneofIndex()
  {
    return this.oneofIndex_;
  }
  
  public Option getOptions(int paramInt)
  {
    return (Option)this.options_.get(paramInt);
  }
  
  public int getOptionsCount()
  {
    return this.options_.size();
  }
  
  public List<Option> getOptionsList()
  {
    return this.options_;
  }
  
  public OptionOrBuilder getOptionsOrBuilder(int paramInt)
  {
    return (OptionOrBuilder)this.options_.get(paramInt);
  }
  
  public List<? extends OptionOrBuilder> getOptionsOrBuilderList()
  {
    return this.options_;
  }
  
  public boolean getPacked()
  {
    return this.packed_;
  }
  
  public Parser<Field> getParserForType()
  {
    return b;
  }
  
  public int getSerializedSize()
  {
    int i = this.memoizedSize;
    if (i != -1) {
      return i;
    }
    i = this.kind_;
    int j = Field.Kind.TYPE_UNKNOWN.getNumber();
    int m = 0;
    if (i != j) {
      j = CodedOutputStream.m(1, this.kind_) + 0;
    } else {
      j = 0;
    }
    i = j;
    if (this.cardinality_ != Field.Cardinality.CARDINALITY_UNKNOWN.getNumber()) {
      i = j + CodedOutputStream.m(2, this.cardinality_);
    }
    int k = this.number_;
    j = i;
    if (k != 0) {
      j = i + CodedOutputStream.h(3, k);
    }
    k = j;
    if (!getNameBytes().isEmpty()) {
      k = j + GeneratedMessageV3.computeStringSize(4, this.name_);
    }
    i = k;
    if (!getTypeUrlBytes().isEmpty()) {
      i = k + GeneratedMessageV3.computeStringSize(6, this.typeUrl_);
    }
    k = this.oneofIndex_;
    j = i;
    if (k != 0) {
      j = i + CodedOutputStream.h(7, k);
    }
    boolean bool = this.packed_;
    i = j;
    k = m;
    if (bool)
    {
      i = j + CodedOutputStream.b(8, bool);
      k = m;
    }
    while (k < this.options_.size())
    {
      i += CodedOutputStream.c(9, (MessageLite)this.options_.get(k));
      k += 1;
    }
    j = i;
    if (!getJsonNameBytes().isEmpty()) {
      j = i + GeneratedMessageV3.computeStringSize(10, this.jsonName_);
    }
    i = j;
    if (!getDefaultValueBytes().isEmpty()) {
      i = j + GeneratedMessageV3.computeStringSize(11, this.defaultValue_);
    }
    i += this.unknownFields.getSerializedSize();
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
  
  public int hashCode()
  {
    if (this.memoizedHashCode != 0) {
      return this.memoizedHashCode;
    }
    int j = ((((((((((((((779 + getDescriptor().hashCode()) * 37 + 1) * 53 + this.kind_) * 37 + 2) * 53 + this.cardinality_) * 37 + 3) * 53 + getNumber()) * 37 + 4) * 53 + getName().hashCode()) * 37 + 6) * 53 + getTypeUrl().hashCode()) * 37 + 7) * 53 + getOneofIndex()) * 37 + 8) * 53 + Internal.a(getPacked());
    int i = j;
    if (getOptionsCount() > 0) {
      i = (j * 37 + 9) * 53 + getOptionsList().hashCode();
    }
    i = ((((i * 37 + 10) * 53 + getJsonName().hashCode()) * 37 + 11) * 53 + getDefaultValue().hashCode()) * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    return i;
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return TypeProto.d.a(Field.class, Field.Builder.class);
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
  
  public Field.Builder newBuilderForType()
  {
    return newBuilder();
  }
  
  protected Field.Builder newBuilderForType(GeneratedMessageV3.BuilderParent paramBuilderParent)
  {
    return new Field.Builder(paramBuilderParent, null);
  }
  
  protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter paramUnusedPrivateParameter)
  {
    return new Field();
  }
  
  public Field.Builder toBuilder()
  {
    if (this == a) {
      return new Field.Builder(null);
    }
    return new Field.Builder(null).a(this);
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
  {
    if (this.kind_ != Field.Kind.TYPE_UNKNOWN.getNumber()) {
      paramCodedOutputStream.g(1, this.kind_);
    }
    if (this.cardinality_ != Field.Cardinality.CARDINALITY_UNKNOWN.getNumber()) {
      paramCodedOutputStream.g(2, this.cardinality_);
    }
    int i = this.number_;
    if (i != 0) {
      paramCodedOutputStream.b(3, i);
    }
    if (!getNameBytes().isEmpty()) {
      GeneratedMessageV3.writeString(paramCodedOutputStream, 4, this.name_);
    }
    if (!getTypeUrlBytes().isEmpty()) {
      GeneratedMessageV3.writeString(paramCodedOutputStream, 6, this.typeUrl_);
    }
    i = this.oneofIndex_;
    if (i != 0) {
      paramCodedOutputStream.b(7, i);
    }
    boolean bool = this.packed_;
    if (bool) {
      paramCodedOutputStream.a(8, bool);
    }
    i = 0;
    while (i < this.options_.size())
    {
      paramCodedOutputStream.a(9, (MessageLite)this.options_.get(i));
      i += 1;
    }
    if (!getJsonNameBytes().isEmpty()) {
      GeneratedMessageV3.writeString(paramCodedOutputStream, 10, this.jsonName_);
    }
    if (!getDefaultValueBytes().isEmpty()) {
      GeneratedMessageV3.writeString(paramCodedOutputStream, 11, this.defaultValue_);
    }
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.Field
 * JD-Core Version:    0.7.0.1
 */