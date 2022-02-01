package com.google.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

public final class Method
  extends GeneratedMessageV3
  implements MethodOrBuilder
{
  public static final int NAME_FIELD_NUMBER = 1;
  public static final int OPTIONS_FIELD_NUMBER = 6;
  public static final int REQUEST_STREAMING_FIELD_NUMBER = 3;
  public static final int REQUEST_TYPE_URL_FIELD_NUMBER = 2;
  public static final int RESPONSE_STREAMING_FIELD_NUMBER = 5;
  public static final int RESPONSE_TYPE_URL_FIELD_NUMBER = 4;
  public static final int SYNTAX_FIELD_NUMBER = 7;
  private static final Method a = new Method();
  private static final Parser<Method> b = new Method.1();
  private static final long serialVersionUID = 0L;
  private byte memoizedIsInitialized = -1;
  private volatile Object name_;
  private List<Option> options_;
  private boolean requestStreaming_;
  private volatile Object requestTypeUrl_;
  private boolean responseStreaming_;
  private volatile Object responseTypeUrl_;
  private int syntax_;
  
  private Method()
  {
    this.name_ = "";
    this.requestTypeUrl_ = "";
    this.responseTypeUrl_ = "";
    this.options_ = Collections.emptyList();
    this.syntax_ = 0;
  }
  
  /* Error */
  private Method(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 48	com/google/protobuf/Method:<init>	()V
    //   4: aload_2
    //   5: ifnull +405 -> 410
    //   8: invokestatic 87	com/google/protobuf/UnknownFieldSet:a	()Lcom/google/protobuf/UnknownFieldSet$Builder;
    //   11: astore 9
    //   13: iconst_0
    //   14: istore 8
    //   16: iconst_0
    //   17: istore_3
    //   18: iload 8
    //   20: ifne +359 -> 379
    //   23: iload_3
    //   24: istore 5
    //   26: iload_3
    //   27: istore 6
    //   29: iload_3
    //   30: istore 7
    //   32: aload_1
    //   33: invokevirtual 92	com/google/protobuf/CodedInputStream:a	()I
    //   36: istore 4
    //   38: iload 4
    //   40: ifeq +267 -> 307
    //   43: iload 4
    //   45: bipush 10
    //   47: if_icmpeq +240 -> 287
    //   50: iload 4
    //   52: bipush 18
    //   54: if_icmpeq +213 -> 267
    //   57: iload 4
    //   59: bipush 24
    //   61: if_icmpeq +186 -> 247
    //   64: iload 4
    //   66: bipush 34
    //   68: if_icmpeq +159 -> 227
    //   71: iload 4
    //   73: bipush 40
    //   75: if_icmpeq +132 -> 207
    //   78: iload 4
    //   80: bipush 50
    //   82: if_icmpeq +55 -> 137
    //   85: iload 4
    //   87: bipush 56
    //   89: if_icmpeq +28 -> 117
    //   92: iload_3
    //   93: istore 5
    //   95: iload_3
    //   96: istore 6
    //   98: iload_3
    //   99: istore 7
    //   101: aload_0
    //   102: aload_1
    //   103: aload 9
    //   105: aload_2
    //   106: iload 4
    //   108: invokevirtual 96	com/google/protobuf/Method:parseUnknownField	(Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/UnknownFieldSet$Builder;Lcom/google/protobuf/ExtensionRegistryLite;I)Z
    //   111: ifne -93 -> 18
    //   114: goto +193 -> 307
    //   117: iload_3
    //   118: istore 5
    //   120: iload_3
    //   121: istore 6
    //   123: iload_3
    //   124: istore 7
    //   126: aload_0
    //   127: aload_1
    //   128: invokevirtual 99	com/google/protobuf/CodedInputStream:n	()I
    //   131: putfield 77	com/google/protobuf/Method:syntax_	I
    //   134: goto -116 -> 18
    //   137: iload_3
    //   138: istore 4
    //   140: iload_3
    //   141: iconst_1
    //   142: iand
    //   143: ifne +28 -> 171
    //   146: iload_3
    //   147: istore 5
    //   149: iload_3
    //   150: istore 6
    //   152: iload_3
    //   153: istore 7
    //   155: aload_0
    //   156: new 101	java/util/ArrayList
    //   159: dup
    //   160: invokespecial 102	java/util/ArrayList:<init>	()V
    //   163: putfield 75	com/google/protobuf/Method:options_	Ljava/util/List;
    //   166: iload_3
    //   167: iconst_1
    //   168: ior
    //   169: istore 4
    //   171: iload 4
    //   173: istore 5
    //   175: iload 4
    //   177: istore 6
    //   179: iload 4
    //   181: istore 7
    //   183: aload_0
    //   184: getfield 75	com/google/protobuf/Method:options_	Ljava/util/List;
    //   187: aload_1
    //   188: invokestatic 108	com/google/protobuf/Option:parser	()Lcom/google/protobuf/Parser;
    //   191: aload_2
    //   192: invokevirtual 111	com/google/protobuf/CodedInputStream:a	(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   195: invokeinterface 117 2 0
    //   200: pop
    //   201: iload 4
    //   203: istore_3
    //   204: goto -186 -> 18
    //   207: iload_3
    //   208: istore 5
    //   210: iload_3
    //   211: istore 6
    //   213: iload_3
    //   214: istore 7
    //   216: aload_0
    //   217: aload_1
    //   218: invokevirtual 121	com/google/protobuf/CodedInputStream:i	()Z
    //   221: putfield 123	com/google/protobuf/Method:responseStreaming_	Z
    //   224: goto -206 -> 18
    //   227: iload_3
    //   228: istore 5
    //   230: iload_3
    //   231: istore 6
    //   233: iload_3
    //   234: istore 7
    //   236: aload_0
    //   237: aload_1
    //   238: invokevirtual 127	com/google/protobuf/CodedInputStream:k	()Ljava/lang/String;
    //   241: putfield 67	com/google/protobuf/Method:responseTypeUrl_	Ljava/lang/Object;
    //   244: goto -226 -> 18
    //   247: iload_3
    //   248: istore 5
    //   250: iload_3
    //   251: istore 6
    //   253: iload_3
    //   254: istore 7
    //   256: aload_0
    //   257: aload_1
    //   258: invokevirtual 121	com/google/protobuf/CodedInputStream:i	()Z
    //   261: putfield 129	com/google/protobuf/Method:requestStreaming_	Z
    //   264: goto -246 -> 18
    //   267: iload_3
    //   268: istore 5
    //   270: iload_3
    //   271: istore 6
    //   273: iload_3
    //   274: istore 7
    //   276: aload_0
    //   277: aload_1
    //   278: invokevirtual 127	com/google/protobuf/CodedInputStream:k	()Ljava/lang/String;
    //   281: putfield 65	com/google/protobuf/Method:requestTypeUrl_	Ljava/lang/Object;
    //   284: goto -266 -> 18
    //   287: iload_3
    //   288: istore 5
    //   290: iload_3
    //   291: istore 6
    //   293: iload_3
    //   294: istore 7
    //   296: aload_0
    //   297: aload_1
    //   298: invokevirtual 127	com/google/protobuf/CodedInputStream:k	()Ljava/lang/String;
    //   301: putfield 63	com/google/protobuf/Method:name_	Ljava/lang/Object;
    //   304: goto -286 -> 18
    //   307: iconst_1
    //   308: istore 8
    //   310: goto -292 -> 18
    //   313: astore_1
    //   314: goto +32 -> 346
    //   317: astore_1
    //   318: iload 6
    //   320: istore 5
    //   322: new 80	com/google/protobuf/InvalidProtocolBufferException
    //   325: dup
    //   326: aload_1
    //   327: invokespecial 132	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/io/IOException;)V
    //   330: aload_0
    //   331: invokevirtual 136	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   334: athrow
    //   335: astore_1
    //   336: iload 7
    //   338: istore 5
    //   340: aload_1
    //   341: aload_0
    //   342: invokevirtual 136	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   345: athrow
    //   346: iload 5
    //   348: iconst_1
    //   349: iand
    //   350: ifeq +14 -> 364
    //   353: aload_0
    //   354: aload_0
    //   355: getfield 75	com/google/protobuf/Method:options_	Ljava/util/List;
    //   358: invokestatic 140	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   361: putfield 75	com/google/protobuf/Method:options_	Ljava/util/List;
    //   364: aload_0
    //   365: aload 9
    //   367: invokevirtual 145	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   370: putfield 149	com/google/protobuf/Method:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   373: aload_0
    //   374: invokevirtual 152	com/google/protobuf/Method:makeExtensionsImmutable	()V
    //   377: aload_1
    //   378: athrow
    //   379: iload_3
    //   380: iconst_1
    //   381: iand
    //   382: ifeq +14 -> 396
    //   385: aload_0
    //   386: aload_0
    //   387: getfield 75	com/google/protobuf/Method:options_	Ljava/util/List;
    //   390: invokestatic 140	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   393: putfield 75	com/google/protobuf/Method:options_	Ljava/util/List;
    //   396: aload_0
    //   397: aload 9
    //   399: invokevirtual 145	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   402: putfield 149	com/google/protobuf/Method:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   405: aload_0
    //   406: invokevirtual 152	com/google/protobuf/Method:makeExtensionsImmutable	()V
    //   409: return
    //   410: new 154	java/lang/NullPointerException
    //   413: dup
    //   414: invokespecial 155	java/lang/NullPointerException:<init>	()V
    //   417: astore_1
    //   418: goto +5 -> 423
    //   421: aload_1
    //   422: athrow
    //   423: goto -2 -> 421
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	426	0	this	Method
    //   0	426	1	paramCodedInputStream	CodedInputStream
    //   0	426	2	paramExtensionRegistryLite	ExtensionRegistryLite
    //   17	365	3	i	int
    //   36	166	4	j	int
    //   24	326	5	k	int
    //   27	292	6	m	int
    //   30	307	7	n	int
    //   14	295	8	i1	int
    //   11	387	9	localBuilder	UnknownFieldSet.Builder
    // Exception table:
    //   from	to	target	type
    //   32	38	313	finally
    //   101	114	313	finally
    //   126	134	313	finally
    //   155	166	313	finally
    //   183	201	313	finally
    //   216	224	313	finally
    //   236	244	313	finally
    //   256	264	313	finally
    //   276	284	313	finally
    //   296	304	313	finally
    //   322	335	313	finally
    //   340	346	313	finally
    //   32	38	317	java/io/IOException
    //   101	114	317	java/io/IOException
    //   126	134	317	java/io/IOException
    //   155	166	317	java/io/IOException
    //   183	201	317	java/io/IOException
    //   216	224	317	java/io/IOException
    //   236	244	317	java/io/IOException
    //   256	264	317	java/io/IOException
    //   276	284	317	java/io/IOException
    //   296	304	317	java/io/IOException
    //   32	38	335	com/google/protobuf/InvalidProtocolBufferException
    //   101	114	335	com/google/protobuf/InvalidProtocolBufferException
    //   126	134	335	com/google/protobuf/InvalidProtocolBufferException
    //   155	166	335	com/google/protobuf/InvalidProtocolBufferException
    //   183	201	335	com/google/protobuf/InvalidProtocolBufferException
    //   216	224	335	com/google/protobuf/InvalidProtocolBufferException
    //   236	244	335	com/google/protobuf/InvalidProtocolBufferException
    //   256	264	335	com/google/protobuf/InvalidProtocolBufferException
    //   276	284	335	com/google/protobuf/InvalidProtocolBufferException
    //   296	304	335	com/google/protobuf/InvalidProtocolBufferException
  }
  
  private Method(GeneratedMessageV3.Builder<?> paramBuilder)
  {
    super(paramBuilder);
  }
  
  public static Method getDefaultInstance()
  {
    return a;
  }
  
  public static final Descriptors.Descriptor getDescriptor()
  {
    return ApiProto.c;
  }
  
  public static Method.Builder newBuilder()
  {
    return a.toBuilder();
  }
  
  public static Method.Builder newBuilder(Method paramMethod)
  {
    return a.toBuilder().a(paramMethod);
  }
  
  public static Method parseDelimitedFrom(InputStream paramInputStream)
  {
    return (Method)GeneratedMessageV3.parseDelimitedWithIOException(b, paramInputStream);
  }
  
  public static Method parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (Method)GeneratedMessageV3.parseDelimitedWithIOException(b, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Method parseFrom(ByteString paramByteString)
  {
    return (Method)b.parseFrom(paramByteString);
  }
  
  public static Method parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (Method)b.parseFrom(paramByteString, paramExtensionRegistryLite);
  }
  
  public static Method parseFrom(CodedInputStream paramCodedInputStream)
  {
    return (Method)GeneratedMessageV3.parseWithIOException(b, paramCodedInputStream);
  }
  
  public static Method parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (Method)GeneratedMessageV3.parseWithIOException(b, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static Method parseFrom(InputStream paramInputStream)
  {
    return (Method)GeneratedMessageV3.parseWithIOException(b, paramInputStream);
  }
  
  public static Method parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (Method)GeneratedMessageV3.parseWithIOException(b, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Method parseFrom(ByteBuffer paramByteBuffer)
  {
    return (Method)b.parseFrom(paramByteBuffer);
  }
  
  public static Method parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (Method)b.parseFrom(paramByteBuffer, paramExtensionRegistryLite);
  }
  
  public static Method parseFrom(byte[] paramArrayOfByte)
  {
    return (Method)b.parseFrom(paramArrayOfByte);
  }
  
  public static Method parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (Method)b.parseFrom(paramArrayOfByte, paramExtensionRegistryLite);
  }
  
  public static Parser<Method> parser()
  {
    return b;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof Method)) {
      return super.equals(paramObject);
    }
    paramObject = (Method)paramObject;
    if (!getName().equals(paramObject.getName())) {
      return false;
    }
    if (!getRequestTypeUrl().equals(paramObject.getRequestTypeUrl())) {
      return false;
    }
    if (getRequestStreaming() != paramObject.getRequestStreaming()) {
      return false;
    }
    if (!getResponseTypeUrl().equals(paramObject.getResponseTypeUrl())) {
      return false;
    }
    if (getResponseStreaming() != paramObject.getResponseStreaming()) {
      return false;
    }
    if (!getOptionsList().equals(paramObject.getOptionsList())) {
      return false;
    }
    if (this.syntax_ != paramObject.syntax_) {
      return false;
    }
    return this.unknownFields.equals(paramObject.unknownFields);
  }
  
  public Method getDefaultInstanceForType()
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
  
  public Parser<Method> getParserForType()
  {
    return b;
  }
  
  public boolean getRequestStreaming()
  {
    return this.requestStreaming_;
  }
  
  public String getRequestTypeUrl()
  {
    Object localObject = this.requestTypeUrl_;
    if ((localObject instanceof String)) {
      return (String)localObject;
    }
    localObject = ((ByteString)localObject).toStringUtf8();
    this.requestTypeUrl_ = localObject;
    return localObject;
  }
  
  public ByteString getRequestTypeUrlBytes()
  {
    Object localObject = this.requestTypeUrl_;
    if ((localObject instanceof String))
    {
      localObject = ByteString.copyFromUtf8((String)localObject);
      this.requestTypeUrl_ = localObject;
      return localObject;
    }
    return (ByteString)localObject;
  }
  
  public boolean getResponseStreaming()
  {
    return this.responseStreaming_;
  }
  
  public String getResponseTypeUrl()
  {
    Object localObject = this.responseTypeUrl_;
    if ((localObject instanceof String)) {
      return (String)localObject;
    }
    localObject = ((ByteString)localObject).toStringUtf8();
    this.responseTypeUrl_ = localObject;
    return localObject;
  }
  
  public ByteString getResponseTypeUrlBytes()
  {
    Object localObject = this.responseTypeUrl_;
    if ((localObject instanceof String))
    {
      localObject = ByteString.copyFromUtf8((String)localObject);
      this.responseTypeUrl_ = localObject;
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
    boolean bool = getNameBytes().isEmpty();
    int m = 0;
    if (!bool) {
      j = GeneratedMessageV3.computeStringSize(1, this.name_) + 0;
    } else {
      j = 0;
    }
    i = j;
    if (!getRequestTypeUrlBytes().isEmpty()) {
      i = j + GeneratedMessageV3.computeStringSize(2, this.requestTypeUrl_);
    }
    bool = this.requestStreaming_;
    int k = i;
    if (bool) {
      k = i + CodedOutputStream.b(3, bool);
    }
    int j = k;
    if (!getResponseTypeUrlBytes().isEmpty()) {
      j = k + GeneratedMessageV3.computeStringSize(4, this.responseTypeUrl_);
    }
    bool = this.responseStreaming_;
    i = j;
    k = m;
    if (bool)
    {
      i = j + CodedOutputStream.b(5, bool);
      k = m;
    }
    while (k < this.options_.size())
    {
      i += CodedOutputStream.c(6, (MessageLite)this.options_.get(k));
      k += 1;
    }
    j = i;
    if (this.syntax_ != Syntax.SYNTAX_PROTO2.getNumber()) {
      j = i + CodedOutputStream.m(7, this.syntax_);
    }
    i = j + this.unknownFields.getSerializedSize();
    this.memoizedSize = i;
    return i;
  }
  
  public Syntax getSyntax()
  {
    Syntax localSyntax2 = Syntax.valueOf(this.syntax_);
    Syntax localSyntax1 = localSyntax2;
    if (localSyntax2 == null) {
      localSyntax1 = Syntax.UNRECOGNIZED;
    }
    return localSyntax1;
  }
  
  public int getSyntaxValue()
  {
    return this.syntax_;
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
    int j = ((((((((((779 + getDescriptor().hashCode()) * 37 + 1) * 53 + getName().hashCode()) * 37 + 2) * 53 + getRequestTypeUrl().hashCode()) * 37 + 3) * 53 + Internal.a(getRequestStreaming())) * 37 + 4) * 53 + getResponseTypeUrl().hashCode()) * 37 + 5) * 53 + Internal.a(getResponseStreaming());
    int i = j;
    if (getOptionsCount() > 0) {
      i = (j * 37 + 6) * 53 + getOptionsList().hashCode();
    }
    i = ((i * 37 + 7) * 53 + this.syntax_) * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    return i;
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return ApiProto.d.a(Method.class, Method.Builder.class);
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
  
  public Method.Builder newBuilderForType()
  {
    return newBuilder();
  }
  
  protected Method.Builder newBuilderForType(GeneratedMessageV3.BuilderParent paramBuilderParent)
  {
    return new Method.Builder(paramBuilderParent, null);
  }
  
  protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter paramUnusedPrivateParameter)
  {
    return new Method();
  }
  
  public Method.Builder toBuilder()
  {
    if (this == a) {
      return new Method.Builder(null);
    }
    return new Method.Builder(null).a(this);
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
  {
    if (!getNameBytes().isEmpty()) {
      GeneratedMessageV3.writeString(paramCodedOutputStream, 1, this.name_);
    }
    if (!getRequestTypeUrlBytes().isEmpty()) {
      GeneratedMessageV3.writeString(paramCodedOutputStream, 2, this.requestTypeUrl_);
    }
    boolean bool = this.requestStreaming_;
    if (bool) {
      paramCodedOutputStream.a(3, bool);
    }
    if (!getResponseTypeUrlBytes().isEmpty()) {
      GeneratedMessageV3.writeString(paramCodedOutputStream, 4, this.responseTypeUrl_);
    }
    bool = this.responseStreaming_;
    if (bool) {
      paramCodedOutputStream.a(5, bool);
    }
    int i = 0;
    while (i < this.options_.size())
    {
      paramCodedOutputStream.a(6, (MessageLite)this.options_.get(i));
      i += 1;
    }
    if (this.syntax_ != Syntax.SYNTAX_PROTO2.getNumber()) {
      paramCodedOutputStream.g(7, this.syntax_);
    }
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.Method
 * JD-Core Version:    0.7.0.1
 */