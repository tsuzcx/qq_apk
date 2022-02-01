package com.google.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

public final class Type
  extends GeneratedMessageV3
  implements TypeOrBuilder
{
  public static final int FIELDS_FIELD_NUMBER = 2;
  public static final int NAME_FIELD_NUMBER = 1;
  public static final int ONEOFS_FIELD_NUMBER = 3;
  public static final int OPTIONS_FIELD_NUMBER = 4;
  public static final int SOURCE_CONTEXT_FIELD_NUMBER = 5;
  public static final int SYNTAX_FIELD_NUMBER = 6;
  private static final Type a = new Type();
  private static final Parser<Type> b = new Type.1();
  private static final long serialVersionUID = 0L;
  private List<Field> fields_;
  private byte memoizedIsInitialized = -1;
  private volatile Object name_;
  private LazyStringList oneofs_;
  private List<Option> options_;
  private SourceContext sourceContext_;
  private int syntax_;
  
  private Type()
  {
    this.name_ = "";
    this.fields_ = Collections.emptyList();
    this.oneofs_ = LazyStringArrayList.a;
    this.options_ = Collections.emptyList();
    this.syntax_ = 0;
  }
  
  /* Error */
  private Type(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 47	com/google/protobuf/Type:<init>	()V
    //   4: aload_2
    //   5: ifnull +647 -> 652
    //   8: invokestatic 90	com/google/protobuf/UnknownFieldSet:a	()Lcom/google/protobuf/UnknownFieldSet$Builder;
    //   11: astore 10
    //   13: iconst_0
    //   14: istore 8
    //   16: iconst_0
    //   17: istore_3
    //   18: iload 8
    //   20: ifne +565 -> 585
    //   23: iload_3
    //   24: istore 4
    //   26: iload_3
    //   27: istore 5
    //   29: iload_3
    //   30: istore 6
    //   32: aload_1
    //   33: invokevirtual 95	com/google/protobuf/CodedInputStream:a	()I
    //   36: istore 7
    //   38: iload 7
    //   40: ifeq +435 -> 475
    //   43: iload 7
    //   45: bipush 10
    //   47: if_icmpeq +408 -> 455
    //   50: iload 7
    //   52: bipush 18
    //   54: if_icmpeq +331 -> 385
    //   57: iload 7
    //   59: bipush 26
    //   61: if_icmpeq +245 -> 306
    //   64: iload 7
    //   66: bipush 34
    //   68: if_icmpeq +168 -> 236
    //   71: iload 7
    //   73: bipush 42
    //   75: if_icmpeq +55 -> 130
    //   78: iload 7
    //   80: bipush 48
    //   82: if_icmpeq +28 -> 110
    //   85: iload_3
    //   86: istore 4
    //   88: iload_3
    //   89: istore 5
    //   91: iload_3
    //   92: istore 6
    //   94: aload_0
    //   95: aload_1
    //   96: aload 10
    //   98: aload_2
    //   99: iload 7
    //   101: invokevirtual 99	com/google/protobuf/Type:parseUnknownField	(Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/UnknownFieldSet$Builder;Lcom/google/protobuf/ExtensionRegistryLite;I)Z
    //   104: ifne -86 -> 18
    //   107: goto +368 -> 475
    //   110: iload_3
    //   111: istore 4
    //   113: iload_3
    //   114: istore 5
    //   116: iload_3
    //   117: istore 6
    //   119: aload_0
    //   120: aload_1
    //   121: invokevirtual 102	com/google/protobuf/CodedInputStream:n	()I
    //   124: putfield 80	com/google/protobuf/Type:syntax_	I
    //   127: goto -109 -> 18
    //   130: aconst_null
    //   131: astore 9
    //   133: iload_3
    //   134: istore 4
    //   136: iload_3
    //   137: istore 5
    //   139: iload_3
    //   140: istore 6
    //   142: aload_0
    //   143: getfield 104	com/google/protobuf/Type:sourceContext_	Lcom/google/protobuf/SourceContext;
    //   146: ifnull +21 -> 167
    //   149: iload_3
    //   150: istore 4
    //   152: iload_3
    //   153: istore 5
    //   155: iload_3
    //   156: istore 6
    //   158: aload_0
    //   159: getfield 104	com/google/protobuf/Type:sourceContext_	Lcom/google/protobuf/SourceContext;
    //   162: invokevirtual 110	com/google/protobuf/SourceContext:toBuilder	()Lcom/google/protobuf/SourceContext$Builder;
    //   165: astore 9
    //   167: iload_3
    //   168: istore 4
    //   170: iload_3
    //   171: istore 5
    //   173: iload_3
    //   174: istore 6
    //   176: aload_0
    //   177: aload_1
    //   178: invokestatic 114	com/google/protobuf/SourceContext:parser	()Lcom/google/protobuf/Parser;
    //   181: aload_2
    //   182: invokevirtual 117	com/google/protobuf/CodedInputStream:a	(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   185: checkcast 106	com/google/protobuf/SourceContext
    //   188: putfield 104	com/google/protobuf/Type:sourceContext_	Lcom/google/protobuf/SourceContext;
    //   191: aload 9
    //   193: ifnull -175 -> 18
    //   196: iload_3
    //   197: istore 4
    //   199: iload_3
    //   200: istore 5
    //   202: iload_3
    //   203: istore 6
    //   205: aload 9
    //   207: aload_0
    //   208: getfield 104	com/google/protobuf/Type:sourceContext_	Lcom/google/protobuf/SourceContext;
    //   211: invokevirtual 122	com/google/protobuf/SourceContext$Builder:a	(Lcom/google/protobuf/SourceContext;)Lcom/google/protobuf/SourceContext$Builder;
    //   214: pop
    //   215: iload_3
    //   216: istore 4
    //   218: iload_3
    //   219: istore 5
    //   221: iload_3
    //   222: istore 6
    //   224: aload_0
    //   225: aload 9
    //   227: invokevirtual 126	com/google/protobuf/SourceContext$Builder:d	()Lcom/google/protobuf/SourceContext;
    //   230: putfield 104	com/google/protobuf/Type:sourceContext_	Lcom/google/protobuf/SourceContext;
    //   233: goto -215 -> 18
    //   236: iload_3
    //   237: istore 7
    //   239: iload_3
    //   240: iconst_4
    //   241: iand
    //   242: ifne +28 -> 270
    //   245: iload_3
    //   246: istore 4
    //   248: iload_3
    //   249: istore 5
    //   251: iload_3
    //   252: istore 6
    //   254: aload_0
    //   255: new 128	java/util/ArrayList
    //   258: dup
    //   259: invokespecial 129	java/util/ArrayList:<init>	()V
    //   262: putfield 78	com/google/protobuf/Type:options_	Ljava/util/List;
    //   265: iload_3
    //   266: iconst_4
    //   267: ior
    //   268: istore 7
    //   270: iload 7
    //   272: istore 4
    //   274: iload 7
    //   276: istore 5
    //   278: iload 7
    //   280: istore 6
    //   282: aload_0
    //   283: getfield 78	com/google/protobuf/Type:options_	Ljava/util/List;
    //   286: aload_1
    //   287: invokestatic 132	com/google/protobuf/Option:parser	()Lcom/google/protobuf/Parser;
    //   290: aload_2
    //   291: invokevirtual 117	com/google/protobuf/CodedInputStream:a	(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   294: invokeinterface 138 2 0
    //   299: pop
    //   300: iload 7
    //   302: istore_3
    //   303: goto -285 -> 18
    //   306: iload_3
    //   307: istore 4
    //   309: iload_3
    //   310: istore 5
    //   312: iload_3
    //   313: istore 6
    //   315: aload_1
    //   316: invokevirtual 142	com/google/protobuf/CodedInputStream:k	()Ljava/lang/String;
    //   319: astore 9
    //   321: iload_3
    //   322: istore 7
    //   324: iload_3
    //   325: iconst_2
    //   326: iand
    //   327: ifne +28 -> 355
    //   330: iload_3
    //   331: istore 4
    //   333: iload_3
    //   334: istore 5
    //   336: iload_3
    //   337: istore 6
    //   339: aload_0
    //   340: new 72	com/google/protobuf/LazyStringArrayList
    //   343: dup
    //   344: invokespecial 143	com/google/protobuf/LazyStringArrayList:<init>	()V
    //   347: putfield 76	com/google/protobuf/Type:oneofs_	Lcom/google/protobuf/LazyStringList;
    //   350: iload_3
    //   351: iconst_2
    //   352: ior
    //   353: istore 7
    //   355: iload 7
    //   357: istore 4
    //   359: iload 7
    //   361: istore 5
    //   363: iload 7
    //   365: istore 6
    //   367: aload_0
    //   368: getfield 76	com/google/protobuf/Type:oneofs_	Lcom/google/protobuf/LazyStringList;
    //   371: aload 9
    //   373: invokeinterface 146 2 0
    //   378: pop
    //   379: iload 7
    //   381: istore_3
    //   382: goto -364 -> 18
    //   385: iload_3
    //   386: istore 7
    //   388: iload_3
    //   389: iconst_1
    //   390: iand
    //   391: ifne +28 -> 419
    //   394: iload_3
    //   395: istore 4
    //   397: iload_3
    //   398: istore 5
    //   400: iload_3
    //   401: istore 6
    //   403: aload_0
    //   404: new 128	java/util/ArrayList
    //   407: dup
    //   408: invokespecial 129	java/util/ArrayList:<init>	()V
    //   411: putfield 70	com/google/protobuf/Type:fields_	Ljava/util/List;
    //   414: iload_3
    //   415: iconst_1
    //   416: ior
    //   417: istore 7
    //   419: iload 7
    //   421: istore 4
    //   423: iload 7
    //   425: istore 5
    //   427: iload 7
    //   429: istore 6
    //   431: aload_0
    //   432: getfield 70	com/google/protobuf/Type:fields_	Ljava/util/List;
    //   435: aload_1
    //   436: invokestatic 149	com/google/protobuf/Field:parser	()Lcom/google/protobuf/Parser;
    //   439: aload_2
    //   440: invokevirtual 117	com/google/protobuf/CodedInputStream:a	(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   443: invokeinterface 138 2 0
    //   448: pop
    //   449: iload 7
    //   451: istore_3
    //   452: goto -434 -> 18
    //   455: iload_3
    //   456: istore 4
    //   458: iload_3
    //   459: istore 5
    //   461: iload_3
    //   462: istore 6
    //   464: aload_0
    //   465: aload_1
    //   466: invokevirtual 142	com/google/protobuf/CodedInputStream:k	()Ljava/lang/String;
    //   469: putfield 62	com/google/protobuf/Type:name_	Ljava/lang/Object;
    //   472: goto -454 -> 18
    //   475: iconst_1
    //   476: istore 8
    //   478: goto -460 -> 18
    //   481: astore_1
    //   482: goto +32 -> 514
    //   485: astore_1
    //   486: iload 5
    //   488: istore 4
    //   490: new 83	com/google/protobuf/InvalidProtocolBufferException
    //   493: dup
    //   494: aload_1
    //   495: invokespecial 152	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/io/IOException;)V
    //   498: aload_0
    //   499: invokevirtual 156	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   502: athrow
    //   503: astore_1
    //   504: iload 6
    //   506: istore 4
    //   508: aload_1
    //   509: aload_0
    //   510: invokevirtual 156	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   513: athrow
    //   514: iload 4
    //   516: iconst_1
    //   517: iand
    //   518: ifeq +14 -> 532
    //   521: aload_0
    //   522: aload_0
    //   523: getfield 70	com/google/protobuf/Type:fields_	Ljava/util/List;
    //   526: invokestatic 160	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   529: putfield 70	com/google/protobuf/Type:fields_	Ljava/util/List;
    //   532: iload 4
    //   534: iconst_2
    //   535: iand
    //   536: ifeq +16 -> 552
    //   539: aload_0
    //   540: aload_0
    //   541: getfield 76	com/google/protobuf/Type:oneofs_	Lcom/google/protobuf/LazyStringList;
    //   544: invokeinterface 164 1 0
    //   549: putfield 76	com/google/protobuf/Type:oneofs_	Lcom/google/protobuf/LazyStringList;
    //   552: iload 4
    //   554: iconst_4
    //   555: iand
    //   556: ifeq +14 -> 570
    //   559: aload_0
    //   560: aload_0
    //   561: getfield 78	com/google/protobuf/Type:options_	Ljava/util/List;
    //   564: invokestatic 160	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   567: putfield 78	com/google/protobuf/Type:options_	Ljava/util/List;
    //   570: aload_0
    //   571: aload 10
    //   573: invokevirtual 169	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   576: putfield 173	com/google/protobuf/Type:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   579: aload_0
    //   580: invokevirtual 176	com/google/protobuf/Type:makeExtensionsImmutable	()V
    //   583: aload_1
    //   584: athrow
    //   585: iload_3
    //   586: iconst_1
    //   587: iand
    //   588: ifeq +14 -> 602
    //   591: aload_0
    //   592: aload_0
    //   593: getfield 70	com/google/protobuf/Type:fields_	Ljava/util/List;
    //   596: invokestatic 160	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   599: putfield 70	com/google/protobuf/Type:fields_	Ljava/util/List;
    //   602: iload_3
    //   603: iconst_2
    //   604: iand
    //   605: ifeq +16 -> 621
    //   608: aload_0
    //   609: aload_0
    //   610: getfield 76	com/google/protobuf/Type:oneofs_	Lcom/google/protobuf/LazyStringList;
    //   613: invokeinterface 164 1 0
    //   618: putfield 76	com/google/protobuf/Type:oneofs_	Lcom/google/protobuf/LazyStringList;
    //   621: iload_3
    //   622: iconst_4
    //   623: iand
    //   624: ifeq +14 -> 638
    //   627: aload_0
    //   628: aload_0
    //   629: getfield 78	com/google/protobuf/Type:options_	Ljava/util/List;
    //   632: invokestatic 160	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   635: putfield 78	com/google/protobuf/Type:options_	Ljava/util/List;
    //   638: aload_0
    //   639: aload 10
    //   641: invokevirtual 169	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   644: putfield 173	com/google/protobuf/Type:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   647: aload_0
    //   648: invokevirtual 176	com/google/protobuf/Type:makeExtensionsImmutable	()V
    //   651: return
    //   652: new 178	java/lang/NullPointerException
    //   655: dup
    //   656: invokespecial 179	java/lang/NullPointerException:<init>	()V
    //   659: astore_1
    //   660: goto +5 -> 665
    //   663: aload_1
    //   664: athrow
    //   665: goto -2 -> 663
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	668	0	this	Type
    //   0	668	1	paramCodedInputStream	CodedInputStream
    //   0	668	2	paramExtensionRegistryLite	ExtensionRegistryLite
    //   17	607	3	i	int
    //   24	532	4	j	int
    //   27	460	5	k	int
    //   30	475	6	m	int
    //   36	414	7	n	int
    //   14	463	8	i1	int
    //   131	241	9	localObject	Object
    //   11	629	10	localBuilder	UnknownFieldSet.Builder
    // Exception table:
    //   from	to	target	type
    //   32	38	481	finally
    //   94	107	481	finally
    //   119	127	481	finally
    //   142	149	481	finally
    //   158	167	481	finally
    //   176	191	481	finally
    //   205	215	481	finally
    //   224	233	481	finally
    //   254	265	481	finally
    //   282	300	481	finally
    //   315	321	481	finally
    //   339	350	481	finally
    //   367	379	481	finally
    //   403	414	481	finally
    //   431	449	481	finally
    //   464	472	481	finally
    //   490	503	481	finally
    //   508	514	481	finally
    //   32	38	485	java/io/IOException
    //   94	107	485	java/io/IOException
    //   119	127	485	java/io/IOException
    //   142	149	485	java/io/IOException
    //   158	167	485	java/io/IOException
    //   176	191	485	java/io/IOException
    //   205	215	485	java/io/IOException
    //   224	233	485	java/io/IOException
    //   254	265	485	java/io/IOException
    //   282	300	485	java/io/IOException
    //   315	321	485	java/io/IOException
    //   339	350	485	java/io/IOException
    //   367	379	485	java/io/IOException
    //   403	414	485	java/io/IOException
    //   431	449	485	java/io/IOException
    //   464	472	485	java/io/IOException
    //   32	38	503	com/google/protobuf/InvalidProtocolBufferException
    //   94	107	503	com/google/protobuf/InvalidProtocolBufferException
    //   119	127	503	com/google/protobuf/InvalidProtocolBufferException
    //   142	149	503	com/google/protobuf/InvalidProtocolBufferException
    //   158	167	503	com/google/protobuf/InvalidProtocolBufferException
    //   176	191	503	com/google/protobuf/InvalidProtocolBufferException
    //   205	215	503	com/google/protobuf/InvalidProtocolBufferException
    //   224	233	503	com/google/protobuf/InvalidProtocolBufferException
    //   254	265	503	com/google/protobuf/InvalidProtocolBufferException
    //   282	300	503	com/google/protobuf/InvalidProtocolBufferException
    //   315	321	503	com/google/protobuf/InvalidProtocolBufferException
    //   339	350	503	com/google/protobuf/InvalidProtocolBufferException
    //   367	379	503	com/google/protobuf/InvalidProtocolBufferException
    //   403	414	503	com/google/protobuf/InvalidProtocolBufferException
    //   431	449	503	com/google/protobuf/InvalidProtocolBufferException
    //   464	472	503	com/google/protobuf/InvalidProtocolBufferException
  }
  
  private Type(GeneratedMessageV3.Builder<?> paramBuilder)
  {
    super(paramBuilder);
  }
  
  public static Type getDefaultInstance()
  {
    return a;
  }
  
  public static final Descriptors.Descriptor getDescriptor()
  {
    return TypeProto.a;
  }
  
  public static Type.Builder newBuilder()
  {
    return a.toBuilder();
  }
  
  public static Type.Builder newBuilder(Type paramType)
  {
    return a.toBuilder().a(paramType);
  }
  
  public static Type parseDelimitedFrom(InputStream paramInputStream)
  {
    return (Type)GeneratedMessageV3.parseDelimitedWithIOException(b, paramInputStream);
  }
  
  public static Type parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (Type)GeneratedMessageV3.parseDelimitedWithIOException(b, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Type parseFrom(ByteString paramByteString)
  {
    return (Type)b.parseFrom(paramByteString);
  }
  
  public static Type parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (Type)b.parseFrom(paramByteString, paramExtensionRegistryLite);
  }
  
  public static Type parseFrom(CodedInputStream paramCodedInputStream)
  {
    return (Type)GeneratedMessageV3.parseWithIOException(b, paramCodedInputStream);
  }
  
  public static Type parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (Type)GeneratedMessageV3.parseWithIOException(b, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static Type parseFrom(InputStream paramInputStream)
  {
    return (Type)GeneratedMessageV3.parseWithIOException(b, paramInputStream);
  }
  
  public static Type parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (Type)GeneratedMessageV3.parseWithIOException(b, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Type parseFrom(ByteBuffer paramByteBuffer)
  {
    return (Type)b.parseFrom(paramByteBuffer);
  }
  
  public static Type parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (Type)b.parseFrom(paramByteBuffer, paramExtensionRegistryLite);
  }
  
  public static Type parseFrom(byte[] paramArrayOfByte)
  {
    return (Type)b.parseFrom(paramArrayOfByte);
  }
  
  public static Type parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (Type)b.parseFrom(paramArrayOfByte, paramExtensionRegistryLite);
  }
  
  public static Parser<Type> parser()
  {
    return b;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof Type)) {
      return super.equals(paramObject);
    }
    paramObject = (Type)paramObject;
    if (!getName().equals(paramObject.getName())) {
      return false;
    }
    if (!getFieldsList().equals(paramObject.getFieldsList())) {
      return false;
    }
    if (!getOneofsList().equals(paramObject.getOneofsList())) {
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
  
  public Type getDefaultInstanceForType()
  {
    return a;
  }
  
  public Field getFields(int paramInt)
  {
    return (Field)this.fields_.get(paramInt);
  }
  
  public int getFieldsCount()
  {
    return this.fields_.size();
  }
  
  public List<Field> getFieldsList()
  {
    return this.fields_;
  }
  
  public FieldOrBuilder getFieldsOrBuilder(int paramInt)
  {
    return (FieldOrBuilder)this.fields_.get(paramInt);
  }
  
  public List<? extends FieldOrBuilder> getFieldsOrBuilderList()
  {
    return this.fields_;
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
  
  public String getOneofs(int paramInt)
  {
    return (String)this.oneofs_.get(paramInt);
  }
  
  public ByteString getOneofsBytes(int paramInt)
  {
    return this.oneofs_.f(paramInt);
  }
  
  public int getOneofsCount()
  {
    return this.oneofs_.size();
  }
  
  public ProtocolStringList getOneofsList()
  {
    return this.oneofs_;
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
  
  public Parser<Type> getParserForType()
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
    while (j < this.fields_.size())
    {
      i += CodedOutputStream.c(2, (MessageLite)this.fields_.get(j));
      j += 1;
    }
    j = 0;
    int k = 0;
    while (j < this.oneofs_.size())
    {
      k += computeStringSizeNoTag(this.oneofs_.d(j));
      j += 1;
    }
    i = i + k + getOneofsList().size() * 1;
    j = m;
    while (j < this.options_.size())
    {
      i += CodedOutputStream.c(4, (MessageLite)this.options_.get(j));
      j += 1;
    }
    j = i;
    if (this.sourceContext_ != null) {
      j = i + CodedOutputStream.c(5, getSourceContext());
    }
    i = j;
    if (this.syntax_ != Syntax.SYNTAX_PROTO2.getNumber()) {
      i = j + CodedOutputStream.m(6, this.syntax_);
    }
    i += this.unknownFields.getSerializedSize();
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
    if (getFieldsCount() > 0) {
      i = (j * 37 + 2) * 53 + getFieldsList().hashCode();
    }
    j = i;
    if (getOneofsCount() > 0) {
      j = (i * 37 + 3) * 53 + getOneofsList().hashCode();
    }
    i = j;
    if (getOptionsCount() > 0) {
      i = (j * 37 + 4) * 53 + getOptionsList().hashCode();
    }
    j = i;
    if (hasSourceContext()) {
      j = (i * 37 + 5) * 53 + getSourceContext().hashCode();
    }
    i = ((j * 37 + 6) * 53 + this.syntax_) * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    return i;
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return TypeProto.b.a(Type.class, Type.Builder.class);
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
  
  public Type.Builder newBuilderForType()
  {
    return newBuilder();
  }
  
  protected Type.Builder newBuilderForType(GeneratedMessageV3.BuilderParent paramBuilderParent)
  {
    return new Type.Builder(paramBuilderParent, null);
  }
  
  protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter paramUnusedPrivateParameter)
  {
    return new Type();
  }
  
  public Type.Builder toBuilder()
  {
    if (this == a) {
      return new Type.Builder(null);
    }
    return new Type.Builder(null).a(this);
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
  {
    if (!getNameBytes().isEmpty()) {
      GeneratedMessageV3.writeString(paramCodedOutputStream, 1, this.name_);
    }
    int k = 0;
    int i = 0;
    while (i < this.fields_.size())
    {
      paramCodedOutputStream.a(2, (MessageLite)this.fields_.get(i));
      i += 1;
    }
    i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= this.oneofs_.size()) {
        break;
      }
      GeneratedMessageV3.writeString(paramCodedOutputStream, 3, this.oneofs_.d(i));
      i += 1;
    }
    while (j < this.options_.size())
    {
      paramCodedOutputStream.a(4, (MessageLite)this.options_.get(j));
      j += 1;
    }
    if (this.sourceContext_ != null) {
      paramCodedOutputStream.a(5, getSourceContext());
    }
    if (this.syntax_ != Syntax.SYNTAX_PROTO2.getNumber()) {
      paramCodedOutputStream.g(6, this.syntax_);
    }
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.Type
 * JD-Core Version:    0.7.0.1
 */