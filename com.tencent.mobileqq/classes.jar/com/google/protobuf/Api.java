package com.google.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

public final class Api
  extends GeneratedMessageV3
  implements ApiOrBuilder
{
  public static final int METHODS_FIELD_NUMBER = 2;
  public static final int MIXINS_FIELD_NUMBER = 6;
  public static final int NAME_FIELD_NUMBER = 1;
  public static final int OPTIONS_FIELD_NUMBER = 3;
  public static final int SOURCE_CONTEXT_FIELD_NUMBER = 5;
  public static final int SYNTAX_FIELD_NUMBER = 7;
  public static final int VERSION_FIELD_NUMBER = 4;
  private static final Api a = new Api();
  private static final Parser<Api> b = new Api.1();
  private static final long serialVersionUID = 0L;
  private byte memoizedIsInitialized = -1;
  private List<Method> methods_;
  private List<Mixin> mixins_;
  private volatile Object name_;
  private List<Option> options_;
  private SourceContext sourceContext_;
  private int syntax_;
  private volatile Object version_;
  
  private Api()
  {
    this.name_ = "";
    this.methods_ = Collections.emptyList();
    this.options_ = Collections.emptyList();
    this.version_ = "";
    this.mixins_ = Collections.emptyList();
    this.syntax_ = 0;
  }
  
  /* Error */
  private Api(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 50	com/google/protobuf/Api:<init>	()V
    //   4: aload_2
    //   5: ifnull +661 -> 666
    //   8: invokestatic 91	com/google/protobuf/UnknownFieldSet:a	()Lcom/google/protobuf/UnknownFieldSet$Builder;
    //   11: astore 10
    //   13: iconst_0
    //   14: istore 8
    //   16: iconst_0
    //   17: istore_3
    //   18: iload 8
    //   20: ifne +581 -> 601
    //   23: iload_3
    //   24: istore 4
    //   26: iload_3
    //   27: istore 5
    //   29: iload_3
    //   30: istore 6
    //   32: aload_1
    //   33: invokevirtual 96	com/google/protobuf/CodedInputStream:a	()I
    //   36: istore 7
    //   38: iload 7
    //   40: ifeq +453 -> 493
    //   43: iload 7
    //   45: bipush 10
    //   47: if_icmpeq +426 -> 473
    //   50: iload 7
    //   52: bipush 18
    //   54: if_icmpeq +349 -> 403
    //   57: iload 7
    //   59: bipush 26
    //   61: if_icmpeq +272 -> 333
    //   64: iload 7
    //   66: bipush 34
    //   68: if_icmpeq +245 -> 313
    //   71: iload 7
    //   73: bipush 42
    //   75: if_icmpeq +132 -> 207
    //   78: iload 7
    //   80: bipush 50
    //   82: if_icmpeq +55 -> 137
    //   85: iload 7
    //   87: bipush 56
    //   89: if_icmpeq +28 -> 117
    //   92: iload_3
    //   93: istore 4
    //   95: iload_3
    //   96: istore 5
    //   98: iload_3
    //   99: istore 6
    //   101: aload_0
    //   102: aload_1
    //   103: aload 10
    //   105: aload_2
    //   106: iload 7
    //   108: invokevirtual 100	com/google/protobuf/Api:parseUnknownField	(Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/UnknownFieldSet$Builder;Lcom/google/protobuf/ExtensionRegistryLite;I)Z
    //   111: ifne -93 -> 18
    //   114: goto +379 -> 493
    //   117: iload_3
    //   118: istore 4
    //   120: iload_3
    //   121: istore 5
    //   123: iload_3
    //   124: istore 6
    //   126: aload_0
    //   127: aload_1
    //   128: invokevirtual 103	com/google/protobuf/CodedInputStream:n	()I
    //   131: putfield 81	com/google/protobuf/Api:syntax_	I
    //   134: goto -116 -> 18
    //   137: iload_3
    //   138: istore 7
    //   140: iload_3
    //   141: iconst_4
    //   142: iand
    //   143: ifne +28 -> 171
    //   146: iload_3
    //   147: istore 4
    //   149: iload_3
    //   150: istore 5
    //   152: iload_3
    //   153: istore 6
    //   155: aload_0
    //   156: new 105	java/util/ArrayList
    //   159: dup
    //   160: invokespecial 106	java/util/ArrayList:<init>	()V
    //   163: putfield 79	com/google/protobuf/Api:mixins_	Ljava/util/List;
    //   166: iload_3
    //   167: iconst_4
    //   168: ior
    //   169: istore 7
    //   171: iload 7
    //   173: istore 4
    //   175: iload 7
    //   177: istore 5
    //   179: iload 7
    //   181: istore 6
    //   183: aload_0
    //   184: getfield 79	com/google/protobuf/Api:mixins_	Ljava/util/List;
    //   187: aload_1
    //   188: invokestatic 112	com/google/protobuf/Mixin:parser	()Lcom/google/protobuf/Parser;
    //   191: aload_2
    //   192: invokevirtual 115	com/google/protobuf/CodedInputStream:a	(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   195: invokeinterface 121 2 0
    //   200: pop
    //   201: iload 7
    //   203: istore_3
    //   204: goto -186 -> 18
    //   207: aconst_null
    //   208: astore 9
    //   210: iload_3
    //   211: istore 4
    //   213: iload_3
    //   214: istore 5
    //   216: iload_3
    //   217: istore 6
    //   219: aload_0
    //   220: getfield 123	com/google/protobuf/Api:sourceContext_	Lcom/google/protobuf/SourceContext;
    //   223: ifnull +21 -> 244
    //   226: iload_3
    //   227: istore 4
    //   229: iload_3
    //   230: istore 5
    //   232: iload_3
    //   233: istore 6
    //   235: aload_0
    //   236: getfield 123	com/google/protobuf/Api:sourceContext_	Lcom/google/protobuf/SourceContext;
    //   239: invokevirtual 129	com/google/protobuf/SourceContext:toBuilder	()Lcom/google/protobuf/SourceContext$Builder;
    //   242: astore 9
    //   244: iload_3
    //   245: istore 4
    //   247: iload_3
    //   248: istore 5
    //   250: iload_3
    //   251: istore 6
    //   253: aload_0
    //   254: aload_1
    //   255: invokestatic 130	com/google/protobuf/SourceContext:parser	()Lcom/google/protobuf/Parser;
    //   258: aload_2
    //   259: invokevirtual 115	com/google/protobuf/CodedInputStream:a	(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   262: checkcast 125	com/google/protobuf/SourceContext
    //   265: putfield 123	com/google/protobuf/Api:sourceContext_	Lcom/google/protobuf/SourceContext;
    //   268: aload 9
    //   270: ifnull -252 -> 18
    //   273: iload_3
    //   274: istore 4
    //   276: iload_3
    //   277: istore 5
    //   279: iload_3
    //   280: istore 6
    //   282: aload 9
    //   284: aload_0
    //   285: getfield 123	com/google/protobuf/Api:sourceContext_	Lcom/google/protobuf/SourceContext;
    //   288: invokevirtual 135	com/google/protobuf/SourceContext$Builder:a	(Lcom/google/protobuf/SourceContext;)Lcom/google/protobuf/SourceContext$Builder;
    //   291: pop
    //   292: iload_3
    //   293: istore 4
    //   295: iload_3
    //   296: istore 5
    //   298: iload_3
    //   299: istore 6
    //   301: aload_0
    //   302: aload 9
    //   304: invokevirtual 139	com/google/protobuf/SourceContext$Builder:d	()Lcom/google/protobuf/SourceContext;
    //   307: putfield 123	com/google/protobuf/Api:sourceContext_	Lcom/google/protobuf/SourceContext;
    //   310: goto -292 -> 18
    //   313: iload_3
    //   314: istore 4
    //   316: iload_3
    //   317: istore 5
    //   319: iload_3
    //   320: istore 6
    //   322: aload_0
    //   323: aload_1
    //   324: invokevirtual 143	com/google/protobuf/CodedInputStream:k	()Ljava/lang/String;
    //   327: putfield 77	com/google/protobuf/Api:version_	Ljava/lang/Object;
    //   330: goto -312 -> 18
    //   333: iload_3
    //   334: istore 7
    //   336: iload_3
    //   337: iconst_2
    //   338: iand
    //   339: ifne +28 -> 367
    //   342: iload_3
    //   343: istore 4
    //   345: iload_3
    //   346: istore 5
    //   348: iload_3
    //   349: istore 6
    //   351: aload_0
    //   352: new 105	java/util/ArrayList
    //   355: dup
    //   356: invokespecial 106	java/util/ArrayList:<init>	()V
    //   359: putfield 75	com/google/protobuf/Api:options_	Ljava/util/List;
    //   362: iload_3
    //   363: iconst_2
    //   364: ior
    //   365: istore 7
    //   367: iload 7
    //   369: istore 4
    //   371: iload 7
    //   373: istore 5
    //   375: iload 7
    //   377: istore 6
    //   379: aload_0
    //   380: getfield 75	com/google/protobuf/Api:options_	Ljava/util/List;
    //   383: aload_1
    //   384: invokestatic 146	com/google/protobuf/Option:parser	()Lcom/google/protobuf/Parser;
    //   387: aload_2
    //   388: invokevirtual 115	com/google/protobuf/CodedInputStream:a	(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   391: invokeinterface 121 2 0
    //   396: pop
    //   397: iload 7
    //   399: istore_3
    //   400: goto -382 -> 18
    //   403: iload_3
    //   404: istore 7
    //   406: iload_3
    //   407: iconst_1
    //   408: iand
    //   409: ifne +28 -> 437
    //   412: iload_3
    //   413: istore 4
    //   415: iload_3
    //   416: istore 5
    //   418: iload_3
    //   419: istore 6
    //   421: aload_0
    //   422: new 105	java/util/ArrayList
    //   425: dup
    //   426: invokespecial 106	java/util/ArrayList:<init>	()V
    //   429: putfield 73	com/google/protobuf/Api:methods_	Ljava/util/List;
    //   432: iload_3
    //   433: iconst_1
    //   434: ior
    //   435: istore 7
    //   437: iload 7
    //   439: istore 4
    //   441: iload 7
    //   443: istore 5
    //   445: iload 7
    //   447: istore 6
    //   449: aload_0
    //   450: getfield 73	com/google/protobuf/Api:methods_	Ljava/util/List;
    //   453: aload_1
    //   454: invokestatic 149	com/google/protobuf/Method:parser	()Lcom/google/protobuf/Parser;
    //   457: aload_2
    //   458: invokevirtual 115	com/google/protobuf/CodedInputStream:a	(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   461: invokeinterface 121 2 0
    //   466: pop
    //   467: iload 7
    //   469: istore_3
    //   470: goto -452 -> 18
    //   473: iload_3
    //   474: istore 4
    //   476: iload_3
    //   477: istore 5
    //   479: iload_3
    //   480: istore 6
    //   482: aload_0
    //   483: aload_1
    //   484: invokevirtual 143	com/google/protobuf/CodedInputStream:k	()Ljava/lang/String;
    //   487: putfield 65	com/google/protobuf/Api:name_	Ljava/lang/Object;
    //   490: goto -472 -> 18
    //   493: iconst_1
    //   494: istore 8
    //   496: goto -478 -> 18
    //   499: astore_1
    //   500: goto +32 -> 532
    //   503: astore_1
    //   504: iload 5
    //   506: istore 4
    //   508: new 84	com/google/protobuf/InvalidProtocolBufferException
    //   511: dup
    //   512: aload_1
    //   513: invokespecial 152	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/io/IOException;)V
    //   516: aload_0
    //   517: invokevirtual 156	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   520: athrow
    //   521: astore_1
    //   522: iload 6
    //   524: istore 4
    //   526: aload_1
    //   527: aload_0
    //   528: invokevirtual 156	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   531: athrow
    //   532: iload 4
    //   534: iconst_1
    //   535: iand
    //   536: ifeq +14 -> 550
    //   539: aload_0
    //   540: aload_0
    //   541: getfield 73	com/google/protobuf/Api:methods_	Ljava/util/List;
    //   544: invokestatic 160	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   547: putfield 73	com/google/protobuf/Api:methods_	Ljava/util/List;
    //   550: iload 4
    //   552: iconst_2
    //   553: iand
    //   554: ifeq +14 -> 568
    //   557: aload_0
    //   558: aload_0
    //   559: getfield 75	com/google/protobuf/Api:options_	Ljava/util/List;
    //   562: invokestatic 160	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   565: putfield 75	com/google/protobuf/Api:options_	Ljava/util/List;
    //   568: iload 4
    //   570: iconst_4
    //   571: iand
    //   572: ifeq +14 -> 586
    //   575: aload_0
    //   576: aload_0
    //   577: getfield 79	com/google/protobuf/Api:mixins_	Ljava/util/List;
    //   580: invokestatic 160	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   583: putfield 79	com/google/protobuf/Api:mixins_	Ljava/util/List;
    //   586: aload_0
    //   587: aload 10
    //   589: invokevirtual 165	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   592: putfield 169	com/google/protobuf/Api:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   595: aload_0
    //   596: invokevirtual 172	com/google/protobuf/Api:makeExtensionsImmutable	()V
    //   599: aload_1
    //   600: athrow
    //   601: iload_3
    //   602: iconst_1
    //   603: iand
    //   604: ifeq +14 -> 618
    //   607: aload_0
    //   608: aload_0
    //   609: getfield 73	com/google/protobuf/Api:methods_	Ljava/util/List;
    //   612: invokestatic 160	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   615: putfield 73	com/google/protobuf/Api:methods_	Ljava/util/List;
    //   618: iload_3
    //   619: iconst_2
    //   620: iand
    //   621: ifeq +14 -> 635
    //   624: aload_0
    //   625: aload_0
    //   626: getfield 75	com/google/protobuf/Api:options_	Ljava/util/List;
    //   629: invokestatic 160	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   632: putfield 75	com/google/protobuf/Api:options_	Ljava/util/List;
    //   635: iload_3
    //   636: iconst_4
    //   637: iand
    //   638: ifeq +14 -> 652
    //   641: aload_0
    //   642: aload_0
    //   643: getfield 79	com/google/protobuf/Api:mixins_	Ljava/util/List;
    //   646: invokestatic 160	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   649: putfield 79	com/google/protobuf/Api:mixins_	Ljava/util/List;
    //   652: aload_0
    //   653: aload 10
    //   655: invokevirtual 165	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   658: putfield 169	com/google/protobuf/Api:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   661: aload_0
    //   662: invokevirtual 172	com/google/protobuf/Api:makeExtensionsImmutable	()V
    //   665: return
    //   666: new 174	java/lang/NullPointerException
    //   669: dup
    //   670: invokespecial 175	java/lang/NullPointerException:<init>	()V
    //   673: astore_1
    //   674: goto +5 -> 679
    //   677: aload_1
    //   678: athrow
    //   679: goto -2 -> 677
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	682	0	this	Api
    //   0	682	1	paramCodedInputStream	CodedInputStream
    //   0	682	2	paramExtensionRegistryLite	ExtensionRegistryLite
    //   17	621	3	i	int
    //   24	548	4	j	int
    //   27	478	5	k	int
    //   30	493	6	m	int
    //   36	432	7	n	int
    //   14	481	8	i1	int
    //   208	95	9	localBuilder	SourceContext.Builder
    //   11	643	10	localBuilder1	UnknownFieldSet.Builder
    // Exception table:
    //   from	to	target	type
    //   32	38	499	finally
    //   101	114	499	finally
    //   126	134	499	finally
    //   155	166	499	finally
    //   183	201	499	finally
    //   219	226	499	finally
    //   235	244	499	finally
    //   253	268	499	finally
    //   282	292	499	finally
    //   301	310	499	finally
    //   322	330	499	finally
    //   351	362	499	finally
    //   379	397	499	finally
    //   421	432	499	finally
    //   449	467	499	finally
    //   482	490	499	finally
    //   508	521	499	finally
    //   526	532	499	finally
    //   32	38	503	java/io/IOException
    //   101	114	503	java/io/IOException
    //   126	134	503	java/io/IOException
    //   155	166	503	java/io/IOException
    //   183	201	503	java/io/IOException
    //   219	226	503	java/io/IOException
    //   235	244	503	java/io/IOException
    //   253	268	503	java/io/IOException
    //   282	292	503	java/io/IOException
    //   301	310	503	java/io/IOException
    //   322	330	503	java/io/IOException
    //   351	362	503	java/io/IOException
    //   379	397	503	java/io/IOException
    //   421	432	503	java/io/IOException
    //   449	467	503	java/io/IOException
    //   482	490	503	java/io/IOException
    //   32	38	521	com/google/protobuf/InvalidProtocolBufferException
    //   101	114	521	com/google/protobuf/InvalidProtocolBufferException
    //   126	134	521	com/google/protobuf/InvalidProtocolBufferException
    //   155	166	521	com/google/protobuf/InvalidProtocolBufferException
    //   183	201	521	com/google/protobuf/InvalidProtocolBufferException
    //   219	226	521	com/google/protobuf/InvalidProtocolBufferException
    //   235	244	521	com/google/protobuf/InvalidProtocolBufferException
    //   253	268	521	com/google/protobuf/InvalidProtocolBufferException
    //   282	292	521	com/google/protobuf/InvalidProtocolBufferException
    //   301	310	521	com/google/protobuf/InvalidProtocolBufferException
    //   322	330	521	com/google/protobuf/InvalidProtocolBufferException
    //   351	362	521	com/google/protobuf/InvalidProtocolBufferException
    //   379	397	521	com/google/protobuf/InvalidProtocolBufferException
    //   421	432	521	com/google/protobuf/InvalidProtocolBufferException
    //   449	467	521	com/google/protobuf/InvalidProtocolBufferException
    //   482	490	521	com/google/protobuf/InvalidProtocolBufferException
  }
  
  private Api(GeneratedMessageV3.Builder<?> paramBuilder)
  {
    super(paramBuilder);
  }
  
  public static Api getDefaultInstance()
  {
    return a;
  }
  
  public static final Descriptors.Descriptor getDescriptor()
  {
    return ApiProto.a;
  }
  
  public static Api.Builder newBuilder()
  {
    return a.toBuilder();
  }
  
  public static Api.Builder newBuilder(Api paramApi)
  {
    return a.toBuilder().a(paramApi);
  }
  
  public static Api parseDelimitedFrom(InputStream paramInputStream)
  {
    return (Api)GeneratedMessageV3.parseDelimitedWithIOException(b, paramInputStream);
  }
  
  public static Api parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (Api)GeneratedMessageV3.parseDelimitedWithIOException(b, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Api parseFrom(ByteString paramByteString)
  {
    return (Api)b.parseFrom(paramByteString);
  }
  
  public static Api parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (Api)b.parseFrom(paramByteString, paramExtensionRegistryLite);
  }
  
  public static Api parseFrom(CodedInputStream paramCodedInputStream)
  {
    return (Api)GeneratedMessageV3.parseWithIOException(b, paramCodedInputStream);
  }
  
  public static Api parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (Api)GeneratedMessageV3.parseWithIOException(b, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static Api parseFrom(InputStream paramInputStream)
  {
    return (Api)GeneratedMessageV3.parseWithIOException(b, paramInputStream);
  }
  
  public static Api parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (Api)GeneratedMessageV3.parseWithIOException(b, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Api parseFrom(ByteBuffer paramByteBuffer)
  {
    return (Api)b.parseFrom(paramByteBuffer);
  }
  
  public static Api parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (Api)b.parseFrom(paramByteBuffer, paramExtensionRegistryLite);
  }
  
  public static Api parseFrom(byte[] paramArrayOfByte)
  {
    return (Api)b.parseFrom(paramArrayOfByte);
  }
  
  public static Api parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (Api)b.parseFrom(paramArrayOfByte, paramExtensionRegistryLite);
  }
  
  public static Parser<Api> parser()
  {
    return b;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof Api)) {
      return super.equals(paramObject);
    }
    paramObject = (Api)paramObject;
    if (!getName().equals(paramObject.getName())) {
      return false;
    }
    if (!getMethodsList().equals(paramObject.getMethodsList())) {
      return false;
    }
    if (!getOptionsList().equals(paramObject.getOptionsList())) {
      return false;
    }
    if (!getVersion().equals(paramObject.getVersion())) {
      return false;
    }
    if (hasSourceContext() != paramObject.hasSourceContext()) {
      return false;
    }
    if ((hasSourceContext()) && (!getSourceContext().equals(paramObject.getSourceContext()))) {
      return false;
    }
    if (!getMixinsList().equals(paramObject.getMixinsList())) {
      return false;
    }
    if (this.syntax_ != paramObject.syntax_) {
      return false;
    }
    return this.unknownFields.equals(paramObject.unknownFields);
  }
  
  public Api getDefaultInstanceForType()
  {
    return a;
  }
  
  public Method getMethods(int paramInt)
  {
    return (Method)this.methods_.get(paramInt);
  }
  
  public int getMethodsCount()
  {
    return this.methods_.size();
  }
  
  public List<Method> getMethodsList()
  {
    return this.methods_;
  }
  
  public MethodOrBuilder getMethodsOrBuilder(int paramInt)
  {
    return (MethodOrBuilder)this.methods_.get(paramInt);
  }
  
  public List<? extends MethodOrBuilder> getMethodsOrBuilderList()
  {
    return this.methods_;
  }
  
  public Mixin getMixins(int paramInt)
  {
    return (Mixin)this.mixins_.get(paramInt);
  }
  
  public int getMixinsCount()
  {
    return this.mixins_.size();
  }
  
  public List<Mixin> getMixinsList()
  {
    return this.mixins_;
  }
  
  public MixinOrBuilder getMixinsOrBuilder(int paramInt)
  {
    return (MixinOrBuilder)this.mixins_.get(paramInt);
  }
  
  public List<? extends MixinOrBuilder> getMixinsOrBuilderList()
  {
    return this.mixins_;
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
  
  public Parser<Api> getParserForType()
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
    int m = 0;
    if (!bool) {
      i = GeneratedMessageV3.computeStringSize(1, this.name_) + 0;
    } else {
      i = 0;
    }
    int j = 0;
    while (j < this.methods_.size())
    {
      i += CodedOutputStream.c(2, (MessageLite)this.methods_.get(j));
      j += 1;
    }
    j = 0;
    while (j < this.options_.size())
    {
      i += CodedOutputStream.c(3, (MessageLite)this.options_.get(j));
      j += 1;
    }
    j = i;
    if (!getVersionBytes().isEmpty()) {
      j = i + GeneratedMessageV3.computeStringSize(4, this.version_);
    }
    int k = m;
    i = j;
    if (this.sourceContext_ != null)
    {
      i = j + CodedOutputStream.c(5, getSourceContext());
      k = m;
    }
    while (k < this.mixins_.size())
    {
      i += CodedOutputStream.c(6, (MessageLite)this.mixins_.get(k));
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
  
  public String getVersion()
  {
    Object localObject = this.version_;
    if ((localObject instanceof String)) {
      return (String)localObject;
    }
    localObject = ((ByteString)localObject).toStringUtf8();
    this.version_ = localObject;
    return localObject;
  }
  
  public ByteString getVersionBytes()
  {
    Object localObject = this.version_;
    if ((localObject instanceof String))
    {
      localObject = ByteString.copyFromUtf8((String)localObject);
      this.version_ = localObject;
      return localObject;
    }
    return (ByteString)localObject;
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
    if (getMethodsCount() > 0) {
      i = (j * 37 + 2) * 53 + getMethodsList().hashCode();
    }
    j = i;
    if (getOptionsCount() > 0) {
      j = (i * 37 + 3) * 53 + getOptionsList().hashCode();
    }
    j = (j * 37 + 4) * 53 + getVersion().hashCode();
    i = j;
    if (hasSourceContext()) {
      i = (j * 37 + 5) * 53 + getSourceContext().hashCode();
    }
    j = i;
    if (getMixinsCount() > 0) {
      j = (i * 37 + 6) * 53 + getMixinsList().hashCode();
    }
    i = ((j * 37 + 7) * 53 + this.syntax_) * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    return i;
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return ApiProto.b.a(Api.class, Api.Builder.class);
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
  
  public Api.Builder newBuilderForType()
  {
    return newBuilder();
  }
  
  protected Api.Builder newBuilderForType(GeneratedMessageV3.BuilderParent paramBuilderParent)
  {
    return new Api.Builder(paramBuilderParent, null);
  }
  
  protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter paramUnusedPrivateParameter)
  {
    return new Api();
  }
  
  public Api.Builder toBuilder()
  {
    if (this == a) {
      return new Api.Builder(null);
    }
    return new Api.Builder(null).a(this);
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
  {
    if (!getNameBytes().isEmpty()) {
      GeneratedMessageV3.writeString(paramCodedOutputStream, 1, this.name_);
    }
    int j = 0;
    int i = 0;
    while (i < this.methods_.size())
    {
      paramCodedOutputStream.a(2, (MessageLite)this.methods_.get(i));
      i += 1;
    }
    i = 0;
    while (i < this.options_.size())
    {
      paramCodedOutputStream.a(3, (MessageLite)this.options_.get(i));
      i += 1;
    }
    if (!getVersionBytes().isEmpty()) {
      GeneratedMessageV3.writeString(paramCodedOutputStream, 4, this.version_);
    }
    i = j;
    if (this.sourceContext_ != null)
    {
      paramCodedOutputStream.a(5, getSourceContext());
      i = j;
    }
    while (i < this.mixins_.size())
    {
      paramCodedOutputStream.a(6, (MessageLite)this.mixins_.get(i));
      i += 1;
    }
    if (this.syntax_ != Syntax.SYNTAX_PROTO2.getNumber()) {
      paramCodedOutputStream.g(7, this.syntax_);
    }
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.Api
 * JD-Core Version:    0.7.0.1
 */