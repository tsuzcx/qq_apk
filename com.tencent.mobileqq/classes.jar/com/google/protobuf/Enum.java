package com.google.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

public final class Enum
  extends GeneratedMessageV3
  implements EnumOrBuilder
{
  public static final int ENUMVALUE_FIELD_NUMBER = 2;
  public static final int NAME_FIELD_NUMBER = 1;
  public static final int OPTIONS_FIELD_NUMBER = 3;
  public static final int SOURCE_CONTEXT_FIELD_NUMBER = 4;
  public static final int SYNTAX_FIELD_NUMBER = 5;
  private static final Enum a = new Enum();
  private static final Parser<Enum> b = new Enum.1();
  private static final long serialVersionUID = 0L;
  private List<EnumValue> enumvalue_;
  private byte memoizedIsInitialized = -1;
  private volatile Object name_;
  private List<Option> options_;
  private SourceContext sourceContext_;
  private int syntax_;
  
  private Enum()
  {
    this.name_ = "";
    this.enumvalue_ = Collections.emptyList();
    this.options_ = Collections.emptyList();
    this.syntax_ = 0;
  }
  
  /* Error */
  private Enum(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 43	com/google/protobuf/Enum:<init>	()V
    //   4: aload_2
    //   5: ifnull +522 -> 527
    //   8: invokestatic 80	com/google/protobuf/UnknownFieldSet:a	()Lcom/google/protobuf/UnknownFieldSet$Builder;
    //   11: astore 10
    //   13: iconst_0
    //   14: istore 8
    //   16: iconst_0
    //   17: istore_3
    //   18: iload 8
    //   20: ifne +459 -> 479
    //   23: iload_3
    //   24: istore 4
    //   26: iload_3
    //   27: istore 6
    //   29: iload_3
    //   30: istore 7
    //   32: aload_1
    //   33: invokevirtual 85	com/google/protobuf/CodedInputStream:a	()I
    //   36: istore 5
    //   38: iload 5
    //   40: ifeq +349 -> 389
    //   43: iload 5
    //   45: bipush 10
    //   47: if_icmpeq +322 -> 369
    //   50: iload 5
    //   52: bipush 18
    //   54: if_icmpeq +245 -> 299
    //   57: iload 5
    //   59: bipush 26
    //   61: if_icmpeq +168 -> 229
    //   64: iload 5
    //   66: bipush 34
    //   68: if_icmpeq +55 -> 123
    //   71: iload 5
    //   73: bipush 40
    //   75: if_icmpeq +28 -> 103
    //   78: iload_3
    //   79: istore 4
    //   81: iload_3
    //   82: istore 6
    //   84: iload_3
    //   85: istore 7
    //   87: aload_0
    //   88: aload_1
    //   89: aload 10
    //   91: aload_2
    //   92: iload 5
    //   94: invokevirtual 89	com/google/protobuf/Enum:parseUnknownField	(Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/UnknownFieldSet$Builder;Lcom/google/protobuf/ExtensionRegistryLite;I)Z
    //   97: ifne -79 -> 18
    //   100: goto +289 -> 389
    //   103: iload_3
    //   104: istore 4
    //   106: iload_3
    //   107: istore 6
    //   109: iload_3
    //   110: istore 7
    //   112: aload_0
    //   113: aload_1
    //   114: invokevirtual 92	com/google/protobuf/CodedInputStream:n	()I
    //   117: putfield 70	com/google/protobuf/Enum:syntax_	I
    //   120: goto -102 -> 18
    //   123: aconst_null
    //   124: astore 9
    //   126: iload_3
    //   127: istore 4
    //   129: iload_3
    //   130: istore 6
    //   132: iload_3
    //   133: istore 7
    //   135: aload_0
    //   136: getfield 94	com/google/protobuf/Enum:sourceContext_	Lcom/google/protobuf/SourceContext;
    //   139: ifnull +21 -> 160
    //   142: iload_3
    //   143: istore 4
    //   145: iload_3
    //   146: istore 6
    //   148: iload_3
    //   149: istore 7
    //   151: aload_0
    //   152: getfield 94	com/google/protobuf/Enum:sourceContext_	Lcom/google/protobuf/SourceContext;
    //   155: invokevirtual 100	com/google/protobuf/SourceContext:toBuilder	()Lcom/google/protobuf/SourceContext$Builder;
    //   158: astore 9
    //   160: iload_3
    //   161: istore 4
    //   163: iload_3
    //   164: istore 6
    //   166: iload_3
    //   167: istore 7
    //   169: aload_0
    //   170: aload_1
    //   171: invokestatic 104	com/google/protobuf/SourceContext:parser	()Lcom/google/protobuf/Parser;
    //   174: aload_2
    //   175: invokevirtual 107	com/google/protobuf/CodedInputStream:a	(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   178: checkcast 96	com/google/protobuf/SourceContext
    //   181: putfield 94	com/google/protobuf/Enum:sourceContext_	Lcom/google/protobuf/SourceContext;
    //   184: aload 9
    //   186: ifnull -168 -> 18
    //   189: iload_3
    //   190: istore 4
    //   192: iload_3
    //   193: istore 6
    //   195: iload_3
    //   196: istore 7
    //   198: aload 9
    //   200: aload_0
    //   201: getfield 94	com/google/protobuf/Enum:sourceContext_	Lcom/google/protobuf/SourceContext;
    //   204: invokevirtual 112	com/google/protobuf/SourceContext$Builder:a	(Lcom/google/protobuf/SourceContext;)Lcom/google/protobuf/SourceContext$Builder;
    //   207: pop
    //   208: iload_3
    //   209: istore 4
    //   211: iload_3
    //   212: istore 6
    //   214: iload_3
    //   215: istore 7
    //   217: aload_0
    //   218: aload 9
    //   220: invokevirtual 116	com/google/protobuf/SourceContext$Builder:d	()Lcom/google/protobuf/SourceContext;
    //   223: putfield 94	com/google/protobuf/Enum:sourceContext_	Lcom/google/protobuf/SourceContext;
    //   226: goto -208 -> 18
    //   229: iload_3
    //   230: istore 5
    //   232: iload_3
    //   233: iconst_2
    //   234: iand
    //   235: ifne +28 -> 263
    //   238: iload_3
    //   239: istore 4
    //   241: iload_3
    //   242: istore 6
    //   244: iload_3
    //   245: istore 7
    //   247: aload_0
    //   248: new 118	java/util/ArrayList
    //   251: dup
    //   252: invokespecial 119	java/util/ArrayList:<init>	()V
    //   255: putfield 68	com/google/protobuf/Enum:options_	Ljava/util/List;
    //   258: iload_3
    //   259: iconst_2
    //   260: ior
    //   261: istore 5
    //   263: iload 5
    //   265: istore 4
    //   267: iload 5
    //   269: istore 6
    //   271: iload 5
    //   273: istore 7
    //   275: aload_0
    //   276: getfield 68	com/google/protobuf/Enum:options_	Ljava/util/List;
    //   279: aload_1
    //   280: invokestatic 122	com/google/protobuf/Option:parser	()Lcom/google/protobuf/Parser;
    //   283: aload_2
    //   284: invokevirtual 107	com/google/protobuf/CodedInputStream:a	(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   287: invokeinterface 128 2 0
    //   292: pop
    //   293: iload 5
    //   295: istore_3
    //   296: goto -278 -> 18
    //   299: iload_3
    //   300: istore 5
    //   302: iload_3
    //   303: iconst_1
    //   304: iand
    //   305: ifne +28 -> 333
    //   308: iload_3
    //   309: istore 4
    //   311: iload_3
    //   312: istore 6
    //   314: iload_3
    //   315: istore 7
    //   317: aload_0
    //   318: new 118	java/util/ArrayList
    //   321: dup
    //   322: invokespecial 119	java/util/ArrayList:<init>	()V
    //   325: putfield 66	com/google/protobuf/Enum:enumvalue_	Ljava/util/List;
    //   328: iload_3
    //   329: iconst_1
    //   330: ior
    //   331: istore 5
    //   333: iload 5
    //   335: istore 4
    //   337: iload 5
    //   339: istore 6
    //   341: iload 5
    //   343: istore 7
    //   345: aload_0
    //   346: getfield 66	com/google/protobuf/Enum:enumvalue_	Ljava/util/List;
    //   349: aload_1
    //   350: invokestatic 131	com/google/protobuf/EnumValue:parser	()Lcom/google/protobuf/Parser;
    //   353: aload_2
    //   354: invokevirtual 107	com/google/protobuf/CodedInputStream:a	(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   357: invokeinterface 128 2 0
    //   362: pop
    //   363: iload 5
    //   365: istore_3
    //   366: goto -348 -> 18
    //   369: iload_3
    //   370: istore 4
    //   372: iload_3
    //   373: istore 6
    //   375: iload_3
    //   376: istore 7
    //   378: aload_0
    //   379: aload_1
    //   380: invokevirtual 135	com/google/protobuf/CodedInputStream:k	()Ljava/lang/String;
    //   383: putfield 58	com/google/protobuf/Enum:name_	Ljava/lang/Object;
    //   386: goto -368 -> 18
    //   389: iconst_1
    //   390: istore 8
    //   392: goto -374 -> 18
    //   395: astore_1
    //   396: goto +32 -> 428
    //   399: astore_1
    //   400: iload 6
    //   402: istore 4
    //   404: new 73	com/google/protobuf/InvalidProtocolBufferException
    //   407: dup
    //   408: aload_1
    //   409: invokespecial 138	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/io/IOException;)V
    //   412: aload_0
    //   413: invokevirtual 142	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   416: athrow
    //   417: astore_1
    //   418: iload 7
    //   420: istore 4
    //   422: aload_1
    //   423: aload_0
    //   424: invokevirtual 142	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   427: athrow
    //   428: iload 4
    //   430: iconst_1
    //   431: iand
    //   432: ifeq +14 -> 446
    //   435: aload_0
    //   436: aload_0
    //   437: getfield 66	com/google/protobuf/Enum:enumvalue_	Ljava/util/List;
    //   440: invokestatic 146	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   443: putfield 66	com/google/protobuf/Enum:enumvalue_	Ljava/util/List;
    //   446: iload 4
    //   448: iconst_2
    //   449: iand
    //   450: ifeq +14 -> 464
    //   453: aload_0
    //   454: aload_0
    //   455: getfield 68	com/google/protobuf/Enum:options_	Ljava/util/List;
    //   458: invokestatic 146	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   461: putfield 68	com/google/protobuf/Enum:options_	Ljava/util/List;
    //   464: aload_0
    //   465: aload 10
    //   467: invokevirtual 151	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   470: putfield 155	com/google/protobuf/Enum:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   473: aload_0
    //   474: invokevirtual 158	com/google/protobuf/Enum:makeExtensionsImmutable	()V
    //   477: aload_1
    //   478: athrow
    //   479: iload_3
    //   480: iconst_1
    //   481: iand
    //   482: ifeq +14 -> 496
    //   485: aload_0
    //   486: aload_0
    //   487: getfield 66	com/google/protobuf/Enum:enumvalue_	Ljava/util/List;
    //   490: invokestatic 146	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   493: putfield 66	com/google/protobuf/Enum:enumvalue_	Ljava/util/List;
    //   496: iload_3
    //   497: iconst_2
    //   498: iand
    //   499: ifeq +14 -> 513
    //   502: aload_0
    //   503: aload_0
    //   504: getfield 68	com/google/protobuf/Enum:options_	Ljava/util/List;
    //   507: invokestatic 146	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   510: putfield 68	com/google/protobuf/Enum:options_	Ljava/util/List;
    //   513: aload_0
    //   514: aload 10
    //   516: invokevirtual 151	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   519: putfield 155	com/google/protobuf/Enum:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   522: aload_0
    //   523: invokevirtual 158	com/google/protobuf/Enum:makeExtensionsImmutable	()V
    //   526: return
    //   527: new 160	java/lang/NullPointerException
    //   530: dup
    //   531: invokespecial 161	java/lang/NullPointerException:<init>	()V
    //   534: astore_1
    //   535: goto +5 -> 540
    //   538: aload_1
    //   539: athrow
    //   540: goto -2 -> 538
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	543	0	this	Enum
    //   0	543	1	paramCodedInputStream	CodedInputStream
    //   0	543	2	paramExtensionRegistryLite	ExtensionRegistryLite
    //   17	482	3	i	int
    //   24	426	4	j	int
    //   36	328	5	k	int
    //   27	374	6	m	int
    //   30	389	7	n	int
    //   14	377	8	i1	int
    //   124	95	9	localBuilder	SourceContext.Builder
    //   11	504	10	localBuilder1	UnknownFieldSet.Builder
    // Exception table:
    //   from	to	target	type
    //   32	38	395	finally
    //   87	100	395	finally
    //   112	120	395	finally
    //   135	142	395	finally
    //   151	160	395	finally
    //   169	184	395	finally
    //   198	208	395	finally
    //   217	226	395	finally
    //   247	258	395	finally
    //   275	293	395	finally
    //   317	328	395	finally
    //   345	363	395	finally
    //   378	386	395	finally
    //   404	417	395	finally
    //   422	428	395	finally
    //   32	38	399	java/io/IOException
    //   87	100	399	java/io/IOException
    //   112	120	399	java/io/IOException
    //   135	142	399	java/io/IOException
    //   151	160	399	java/io/IOException
    //   169	184	399	java/io/IOException
    //   198	208	399	java/io/IOException
    //   217	226	399	java/io/IOException
    //   247	258	399	java/io/IOException
    //   275	293	399	java/io/IOException
    //   317	328	399	java/io/IOException
    //   345	363	399	java/io/IOException
    //   378	386	399	java/io/IOException
    //   32	38	417	com/google/protobuf/InvalidProtocolBufferException
    //   87	100	417	com/google/protobuf/InvalidProtocolBufferException
    //   112	120	417	com/google/protobuf/InvalidProtocolBufferException
    //   135	142	417	com/google/protobuf/InvalidProtocolBufferException
    //   151	160	417	com/google/protobuf/InvalidProtocolBufferException
    //   169	184	417	com/google/protobuf/InvalidProtocolBufferException
    //   198	208	417	com/google/protobuf/InvalidProtocolBufferException
    //   217	226	417	com/google/protobuf/InvalidProtocolBufferException
    //   247	258	417	com/google/protobuf/InvalidProtocolBufferException
    //   275	293	417	com/google/protobuf/InvalidProtocolBufferException
    //   317	328	417	com/google/protobuf/InvalidProtocolBufferException
    //   345	363	417	com/google/protobuf/InvalidProtocolBufferException
    //   378	386	417	com/google/protobuf/InvalidProtocolBufferException
  }
  
  private Enum(GeneratedMessageV3.Builder<?> paramBuilder)
  {
    super(paramBuilder);
  }
  
  public static Enum getDefaultInstance()
  {
    return a;
  }
  
  public static final Descriptors.Descriptor getDescriptor()
  {
    return TypeProto.e;
  }
  
  public static Enum.Builder newBuilder()
  {
    return a.toBuilder();
  }
  
  public static Enum.Builder newBuilder(Enum paramEnum)
  {
    return a.toBuilder().a(paramEnum);
  }
  
  public static Enum parseDelimitedFrom(InputStream paramInputStream)
  {
    return (Enum)GeneratedMessageV3.parseDelimitedWithIOException(b, paramInputStream);
  }
  
  public static Enum parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (Enum)GeneratedMessageV3.parseDelimitedWithIOException(b, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Enum parseFrom(ByteString paramByteString)
  {
    return (Enum)b.parseFrom(paramByteString);
  }
  
  public static Enum parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (Enum)b.parseFrom(paramByteString, paramExtensionRegistryLite);
  }
  
  public static Enum parseFrom(CodedInputStream paramCodedInputStream)
  {
    return (Enum)GeneratedMessageV3.parseWithIOException(b, paramCodedInputStream);
  }
  
  public static Enum parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (Enum)GeneratedMessageV3.parseWithIOException(b, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static Enum parseFrom(InputStream paramInputStream)
  {
    return (Enum)GeneratedMessageV3.parseWithIOException(b, paramInputStream);
  }
  
  public static Enum parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (Enum)GeneratedMessageV3.parseWithIOException(b, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Enum parseFrom(ByteBuffer paramByteBuffer)
  {
    return (Enum)b.parseFrom(paramByteBuffer);
  }
  
  public static Enum parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (Enum)b.parseFrom(paramByteBuffer, paramExtensionRegistryLite);
  }
  
  public static Enum parseFrom(byte[] paramArrayOfByte)
  {
    return (Enum)b.parseFrom(paramArrayOfByte);
  }
  
  public static Enum parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (Enum)b.parseFrom(paramArrayOfByte, paramExtensionRegistryLite);
  }
  
  public static Parser<Enum> parser()
  {
    return b;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof Enum)) {
      return super.equals(paramObject);
    }
    paramObject = (Enum)paramObject;
    if (!getName().equals(paramObject.getName())) {
      return false;
    }
    if (!getEnumvalueList().equals(paramObject.getEnumvalueList())) {
      return false;
    }
    if (!getOptionsList().equals(paramObject.getOptionsList())) {
      return false;
    }
    if (hasSourceContext() != paramObject.hasSourceContext()) {
      return false;
    }
    if ((hasSourceContext()) && (!getSourceContext().equals(paramObject.getSourceContext()))) {
      return false;
    }
    if (this.syntax_ != paramObject.syntax_) {
      return false;
    }
    return this.unknownFields.equals(paramObject.unknownFields);
  }
  
  public Enum getDefaultInstanceForType()
  {
    return a;
  }
  
  public EnumValue getEnumvalue(int paramInt)
  {
    return (EnumValue)this.enumvalue_.get(paramInt);
  }
  
  public int getEnumvalueCount()
  {
    return this.enumvalue_.size();
  }
  
  public List<EnumValue> getEnumvalueList()
  {
    return this.enumvalue_;
  }
  
  public EnumValueOrBuilder getEnumvalueOrBuilder(int paramInt)
  {
    return (EnumValueOrBuilder)this.enumvalue_.get(paramInt);
  }
  
  public List<? extends EnumValueOrBuilder> getEnumvalueOrBuilderList()
  {
    return this.enumvalue_;
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
  
  public Parser<Enum> getParserForType()
  {
    return b;
  }
  
  public int getSerializedSize()
  {
    int i = this.memoizedSize;
    if (i != -1) {
      return i;
    }
    boolean bool = getNameBytes().isEmpty();
    int n = 0;
    if (!bool) {
      i = GeneratedMessageV3.computeStringSize(1, this.name_) + 0;
    } else {
      i = 0;
    }
    int k = 0;
    int m;
    for (;;)
    {
      m = n;
      j = i;
      if (k >= this.enumvalue_.size()) {
        break;
      }
      i += CodedOutputStream.c(2, (MessageLite)this.enumvalue_.get(k));
      k += 1;
    }
    while (m < this.options_.size())
    {
      j += CodedOutputStream.c(3, (MessageLite)this.options_.get(m));
      m += 1;
    }
    i = j;
    if (this.sourceContext_ != null) {
      i = j + CodedOutputStream.c(4, getSourceContext());
    }
    int j = i;
    if (this.syntax_ != Syntax.SYNTAX_PROTO2.getNumber()) {
      j = i + CodedOutputStream.m(5, this.syntax_);
    }
    i = j + this.unknownFields.getSerializedSize();
    this.memoizedSize = i;
    return i;
  }
  
  public SourceContext getSourceContext()
  {
    SourceContext localSourceContext2 = this.sourceContext_;
    SourceContext localSourceContext1 = localSourceContext2;
    if (localSourceContext2 == null) {
      localSourceContext1 = SourceContext.getDefaultInstance();
    }
    return localSourceContext1;
  }
  
  public SourceContextOrBuilder getSourceContextOrBuilder()
  {
    return getSourceContext();
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
  
  public boolean hasSourceContext()
  {
    return this.sourceContext_ != null;
  }
  
  public int hashCode()
  {
    if (this.memoizedHashCode != 0) {
      return this.memoizedHashCode;
    }
    int j = ((779 + getDescriptor().hashCode()) * 37 + 1) * 53 + getName().hashCode();
    int i = j;
    if (getEnumvalueCount() > 0) {
      i = (j * 37 + 2) * 53 + getEnumvalueList().hashCode();
    }
    j = i;
    if (getOptionsCount() > 0) {
      j = (i * 37 + 3) * 53 + getOptionsList().hashCode();
    }
    i = j;
    if (hasSourceContext()) {
      i = (j * 37 + 4) * 53 + getSourceContext().hashCode();
    }
    i = ((i * 37 + 5) * 53 + this.syntax_) * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    return i;
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return TypeProto.f.a(Enum.class, Enum.Builder.class);
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
  
  public Enum.Builder newBuilderForType()
  {
    return newBuilder();
  }
  
  protected Enum.Builder newBuilderForType(GeneratedMessageV3.BuilderParent paramBuilderParent)
  {
    return new Enum.Builder(paramBuilderParent, null);
  }
  
  protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter paramUnusedPrivateParameter)
  {
    return new Enum();
  }
  
  public Enum.Builder toBuilder()
  {
    if (this == a) {
      return new Enum.Builder(null);
    }
    return new Enum.Builder(null).a(this);
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
  {
    if (!getNameBytes().isEmpty()) {
      GeneratedMessageV3.writeString(paramCodedOutputStream, 1, this.name_);
    }
    int k = 0;
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= this.enumvalue_.size()) {
        break;
      }
      paramCodedOutputStream.a(2, (MessageLite)this.enumvalue_.get(i));
      i += 1;
    }
    while (j < this.options_.size())
    {
      paramCodedOutputStream.a(3, (MessageLite)this.options_.get(j));
      j += 1;
    }
    if (this.sourceContext_ != null) {
      paramCodedOutputStream.a(4, getSourceContext());
    }
    if (this.syntax_ != Syntax.SYNTAX_PROTO2.getNumber()) {
      paramCodedOutputStream.g(5, this.syntax_);
    }
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.Enum
 * JD-Core Version:    0.7.0.1
 */