package com.google.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;

public final class DescriptorProtos$FieldDescriptorProto
  extends GeneratedMessageV3
  implements DescriptorProtos.FieldDescriptorProtoOrBuilder
{
  public static final int DEFAULT_VALUE_FIELD_NUMBER = 7;
  public static final int EXTENDEE_FIELD_NUMBER = 2;
  public static final int JSON_NAME_FIELD_NUMBER = 10;
  public static final int LABEL_FIELD_NUMBER = 4;
  public static final int NAME_FIELD_NUMBER = 1;
  public static final int NUMBER_FIELD_NUMBER = 3;
  public static final int ONEOF_INDEX_FIELD_NUMBER = 9;
  public static final int OPTIONS_FIELD_NUMBER = 8;
  @Deprecated
  public static final Parser<FieldDescriptorProto> PARSER = new DescriptorProtos.FieldDescriptorProto.1();
  public static final int TYPE_FIELD_NUMBER = 5;
  public static final int TYPE_NAME_FIELD_NUMBER = 6;
  private static final FieldDescriptorProto a = new FieldDescriptorProto();
  private static final long serialVersionUID = 0L;
  private int bitField0_;
  private volatile Object defaultValue_;
  private volatile Object extendee_;
  private volatile Object jsonName_;
  private int label_;
  private byte memoizedIsInitialized = -1;
  private volatile Object name_;
  private int number_;
  private int oneofIndex_;
  private DescriptorProtos.FieldOptions options_;
  private volatile Object typeName_;
  private int type_;
  
  private DescriptorProtos$FieldDescriptorProto()
  {
    this.name_ = "";
    this.label_ = 1;
    this.type_ = 1;
    this.typeName_ = "";
    this.extendee_ = "";
    this.defaultValue_ = "";
    this.jsonName_ = "";
  }
  
  /* Error */
  private DescriptorProtos$FieldDescriptorProto(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 57	com/google/protobuf/DescriptorProtos$FieldDescriptorProto:<init>	()V
    //   4: aload_2
    //   5: ifnull +543 -> 548
    //   8: invokestatic 94	com/google/protobuf/UnknownFieldSet:a	()Lcom/google/protobuf/UnknownFieldSet$Builder;
    //   11: astore 7
    //   13: iconst_0
    //   14: istore_3
    //   15: iload_3
    //   16: ifne +518 -> 534
    //   19: aload_1
    //   20: invokevirtual 99	com/google/protobuf/CodedInputStream:a	()I
    //   23: istore 4
    //   25: iload 4
    //   27: lookupswitch	default:+537->564, 0:+454->481, 10:+429->456, 18:+403->430, 24:+382->409, 32:+337->364, 40:+291->318, 50:+265->292, 58:+239->266, 66:+162->189, 72:+139->166, 82:+112->139
    //   125: aload_1
    //   126: aload 7
    //   128: aload_2
    //   129: iload 4
    //   131: invokevirtual 103	com/google/protobuf/DescriptorProtos$FieldDescriptorProto:parseUnknownField	(Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/UnknownFieldSet$Builder;Lcom/google/protobuf/ExtensionRegistryLite;I)Z
    //   134: istore 5
    //   136: goto +350 -> 486
    //   139: aload_1
    //   140: invokevirtual 107	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   143: astore 6
    //   145: aload_0
    //   146: aload_0
    //   147: getfield 109	com/google/protobuf/DescriptorProtos$FieldDescriptorProto:bitField0_	I
    //   150: sipush 256
    //   153: ior
    //   154: putfield 109	com/google/protobuf/DescriptorProtos$FieldDescriptorProto:bitField0_	I
    //   157: aload_0
    //   158: aload 6
    //   160: putfield 84	com/google/protobuf/DescriptorProtos$FieldDescriptorProto:jsonName_	Ljava/lang/Object;
    //   163: goto -148 -> 15
    //   166: aload_0
    //   167: aload_0
    //   168: getfield 109	com/google/protobuf/DescriptorProtos$FieldDescriptorProto:bitField0_	I
    //   171: sipush 128
    //   174: ior
    //   175: putfield 109	com/google/protobuf/DescriptorProtos$FieldDescriptorProto:bitField0_	I
    //   178: aload_0
    //   179: aload_1
    //   180: invokevirtual 112	com/google/protobuf/CodedInputStream:f	()I
    //   183: putfield 114	com/google/protobuf/DescriptorProtos$FieldDescriptorProto:oneofIndex_	I
    //   186: goto -171 -> 15
    //   189: aconst_null
    //   190: astore 6
    //   192: aload_0
    //   193: getfield 109	com/google/protobuf/DescriptorProtos$FieldDescriptorProto:bitField0_	I
    //   196: sipush 512
    //   199: iand
    //   200: ifeq +12 -> 212
    //   203: aload_0
    //   204: getfield 116	com/google/protobuf/DescriptorProtos$FieldDescriptorProto:options_	Lcom/google/protobuf/DescriptorProtos$FieldOptions;
    //   207: invokevirtual 122	com/google/protobuf/DescriptorProtos$FieldOptions:toBuilder	()Lcom/google/protobuf/DescriptorProtos$FieldOptions$Builder;
    //   210: astore 6
    //   212: aload_0
    //   213: aload_1
    //   214: getstatic 123	com/google/protobuf/DescriptorProtos$FieldOptions:PARSER	Lcom/google/protobuf/Parser;
    //   217: aload_2
    //   218: invokevirtual 126	com/google/protobuf/CodedInputStream:a	(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   221: checkcast 118	com/google/protobuf/DescriptorProtos$FieldOptions
    //   224: putfield 116	com/google/protobuf/DescriptorProtos$FieldDescriptorProto:options_	Lcom/google/protobuf/DescriptorProtos$FieldOptions;
    //   227: aload 6
    //   229: ifnull +22 -> 251
    //   232: aload 6
    //   234: aload_0
    //   235: getfield 116	com/google/protobuf/DescriptorProtos$FieldDescriptorProto:options_	Lcom/google/protobuf/DescriptorProtos$FieldOptions;
    //   238: invokevirtual 131	com/google/protobuf/DescriptorProtos$FieldOptions$Builder:a	(Lcom/google/protobuf/DescriptorProtos$FieldOptions;)Lcom/google/protobuf/DescriptorProtos$FieldOptions$Builder;
    //   241: pop
    //   242: aload_0
    //   243: aload 6
    //   245: invokevirtual 135	com/google/protobuf/DescriptorProtos$FieldOptions$Builder:d	()Lcom/google/protobuf/DescriptorProtos$FieldOptions;
    //   248: putfield 116	com/google/protobuf/DescriptorProtos$FieldDescriptorProto:options_	Lcom/google/protobuf/DescriptorProtos$FieldOptions;
    //   251: aload_0
    //   252: aload_0
    //   253: getfield 109	com/google/protobuf/DescriptorProtos$FieldDescriptorProto:bitField0_	I
    //   256: sipush 512
    //   259: ior
    //   260: putfield 109	com/google/protobuf/DescriptorProtos$FieldDescriptorProto:bitField0_	I
    //   263: goto -248 -> 15
    //   266: aload_1
    //   267: invokevirtual 107	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   270: astore 6
    //   272: aload_0
    //   273: aload_0
    //   274: getfield 109	com/google/protobuf/DescriptorProtos$FieldDescriptorProto:bitField0_	I
    //   277: bipush 64
    //   279: ior
    //   280: putfield 109	com/google/protobuf/DescriptorProtos$FieldDescriptorProto:bitField0_	I
    //   283: aload_0
    //   284: aload 6
    //   286: putfield 82	com/google/protobuf/DescriptorProtos$FieldDescriptorProto:defaultValue_	Ljava/lang/Object;
    //   289: goto -274 -> 15
    //   292: aload_1
    //   293: invokevirtual 107	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   296: astore 6
    //   298: aload_0
    //   299: aload_0
    //   300: getfield 109	com/google/protobuf/DescriptorProtos$FieldDescriptorProto:bitField0_	I
    //   303: bipush 16
    //   305: ior
    //   306: putfield 109	com/google/protobuf/DescriptorProtos$FieldDescriptorProto:bitField0_	I
    //   309: aload_0
    //   310: aload 6
    //   312: putfield 78	com/google/protobuf/DescriptorProtos$FieldDescriptorProto:typeName_	Ljava/lang/Object;
    //   315: goto -300 -> 15
    //   318: aload_1
    //   319: invokevirtual 138	com/google/protobuf/CodedInputStream:n	()I
    //   322: istore 4
    //   324: iload 4
    //   326: invokestatic 144	com/google/protobuf/DescriptorProtos$FieldDescriptorProto$Type:valueOf	(I)Lcom/google/protobuf/DescriptorProtos$FieldDescriptorProto$Type;
    //   329: ifnonnull +15 -> 344
    //   332: aload 7
    //   334: iconst_5
    //   335: iload 4
    //   337: invokevirtual 149	com/google/protobuf/UnknownFieldSet$Builder:a	(II)Lcom/google/protobuf/UnknownFieldSet$Builder;
    //   340: pop
    //   341: goto -326 -> 15
    //   344: aload_0
    //   345: aload_0
    //   346: getfield 109	com/google/protobuf/DescriptorProtos$FieldDescriptorProto:bitField0_	I
    //   349: bipush 8
    //   351: ior
    //   352: putfield 109	com/google/protobuf/DescriptorProtos$FieldDescriptorProto:bitField0_	I
    //   355: aload_0
    //   356: iload 4
    //   358: putfield 76	com/google/protobuf/DescriptorProtos$FieldDescriptorProto:type_	I
    //   361: goto -346 -> 15
    //   364: aload_1
    //   365: invokevirtual 138	com/google/protobuf/CodedInputStream:n	()I
    //   368: istore 4
    //   370: iload 4
    //   372: invokestatic 154	com/google/protobuf/DescriptorProtos$FieldDescriptorProto$Label:valueOf	(I)Lcom/google/protobuf/DescriptorProtos$FieldDescriptorProto$Label;
    //   375: ifnonnull +15 -> 390
    //   378: aload 7
    //   380: iconst_4
    //   381: iload 4
    //   383: invokevirtual 149	com/google/protobuf/UnknownFieldSet$Builder:a	(II)Lcom/google/protobuf/UnknownFieldSet$Builder;
    //   386: pop
    //   387: goto -372 -> 15
    //   390: aload_0
    //   391: aload_0
    //   392: getfield 109	com/google/protobuf/DescriptorProtos$FieldDescriptorProto:bitField0_	I
    //   395: iconst_4
    //   396: ior
    //   397: putfield 109	com/google/protobuf/DescriptorProtos$FieldDescriptorProto:bitField0_	I
    //   400: aload_0
    //   401: iload 4
    //   403: putfield 74	com/google/protobuf/DescriptorProtos$FieldDescriptorProto:label_	I
    //   406: goto -391 -> 15
    //   409: aload_0
    //   410: aload_0
    //   411: getfield 109	com/google/protobuf/DescriptorProtos$FieldDescriptorProto:bitField0_	I
    //   414: iconst_2
    //   415: ior
    //   416: putfield 109	com/google/protobuf/DescriptorProtos$FieldDescriptorProto:bitField0_	I
    //   419: aload_0
    //   420: aload_1
    //   421: invokevirtual 112	com/google/protobuf/CodedInputStream:f	()I
    //   424: putfield 156	com/google/protobuf/DescriptorProtos$FieldDescriptorProto:number_	I
    //   427: goto -412 -> 15
    //   430: aload_1
    //   431: invokevirtual 107	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   434: astore 6
    //   436: aload_0
    //   437: aload_0
    //   438: getfield 109	com/google/protobuf/DescriptorProtos$FieldDescriptorProto:bitField0_	I
    //   441: bipush 32
    //   443: ior
    //   444: putfield 109	com/google/protobuf/DescriptorProtos$FieldDescriptorProto:bitField0_	I
    //   447: aload_0
    //   448: aload 6
    //   450: putfield 80	com/google/protobuf/DescriptorProtos$FieldDescriptorProto:extendee_	Ljava/lang/Object;
    //   453: goto -438 -> 15
    //   456: aload_1
    //   457: invokevirtual 107	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   460: astore 6
    //   462: aload_0
    //   463: iconst_1
    //   464: aload_0
    //   465: getfield 109	com/google/protobuf/DescriptorProtos$FieldDescriptorProto:bitField0_	I
    //   468: ior
    //   469: putfield 109	com/google/protobuf/DescriptorProtos$FieldDescriptorProto:bitField0_	I
    //   472: aload_0
    //   473: aload 6
    //   475: putfield 72	com/google/protobuf/DescriptorProtos$FieldDescriptorProto:name_	Ljava/lang/Object;
    //   478: goto -463 -> 15
    //   481: iconst_1
    //   482: istore_3
    //   483: goto -468 -> 15
    //   486: iload 5
    //   488: ifne -473 -> 15
    //   491: goto -10 -> 481
    //   494: astore_1
    //   495: goto +24 -> 519
    //   498: astore_1
    //   499: new 87	com/google/protobuf/InvalidProtocolBufferException
    //   502: dup
    //   503: aload_1
    //   504: invokespecial 159	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/io/IOException;)V
    //   507: aload_0
    //   508: invokevirtual 163	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   511: athrow
    //   512: astore_1
    //   513: aload_1
    //   514: aload_0
    //   515: invokevirtual 163	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   518: athrow
    //   519: aload_0
    //   520: aload 7
    //   522: invokevirtual 166	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   525: putfield 170	com/google/protobuf/DescriptorProtos$FieldDescriptorProto:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   528: aload_0
    //   529: invokevirtual 173	com/google/protobuf/DescriptorProtos$FieldDescriptorProto:makeExtensionsImmutable	()V
    //   532: aload_1
    //   533: athrow
    //   534: aload_0
    //   535: aload 7
    //   537: invokevirtual 166	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   540: putfield 170	com/google/protobuf/DescriptorProtos$FieldDescriptorProto:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   543: aload_0
    //   544: invokevirtual 173	com/google/protobuf/DescriptorProtos$FieldDescriptorProto:makeExtensionsImmutable	()V
    //   547: return
    //   548: new 175	java/lang/NullPointerException
    //   551: dup
    //   552: invokespecial 176	java/lang/NullPointerException:<init>	()V
    //   555: astore_1
    //   556: goto +5 -> 561
    //   559: aload_1
    //   560: athrow
    //   561: goto -2 -> 559
    //   564: goto -440 -> 124
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	567	0	this	FieldDescriptorProto
    //   0	567	1	paramCodedInputStream	CodedInputStream
    //   0	567	2	paramExtensionRegistryLite	ExtensionRegistryLite
    //   14	469	3	i	int
    //   23	379	4	j	int
    //   134	353	5	bool	boolean
    //   143	331	6	localObject	Object
    //   11	525	7	localBuilder	UnknownFieldSet.Builder
    // Exception table:
    //   from	to	target	type
    //   19	25	494	finally
    //   124	136	494	finally
    //   139	163	494	finally
    //   166	186	494	finally
    //   192	212	494	finally
    //   212	227	494	finally
    //   232	251	494	finally
    //   251	263	494	finally
    //   266	289	494	finally
    //   292	315	494	finally
    //   318	341	494	finally
    //   344	361	494	finally
    //   364	387	494	finally
    //   390	406	494	finally
    //   409	427	494	finally
    //   430	453	494	finally
    //   456	478	494	finally
    //   499	512	494	finally
    //   513	519	494	finally
    //   19	25	498	java/io/IOException
    //   124	136	498	java/io/IOException
    //   139	163	498	java/io/IOException
    //   166	186	498	java/io/IOException
    //   192	212	498	java/io/IOException
    //   212	227	498	java/io/IOException
    //   232	251	498	java/io/IOException
    //   251	263	498	java/io/IOException
    //   266	289	498	java/io/IOException
    //   292	315	498	java/io/IOException
    //   318	341	498	java/io/IOException
    //   344	361	498	java/io/IOException
    //   364	387	498	java/io/IOException
    //   390	406	498	java/io/IOException
    //   409	427	498	java/io/IOException
    //   430	453	498	java/io/IOException
    //   456	478	498	java/io/IOException
    //   19	25	512	com/google/protobuf/InvalidProtocolBufferException
    //   124	136	512	com/google/protobuf/InvalidProtocolBufferException
    //   139	163	512	com/google/protobuf/InvalidProtocolBufferException
    //   166	186	512	com/google/protobuf/InvalidProtocolBufferException
    //   192	212	512	com/google/protobuf/InvalidProtocolBufferException
    //   212	227	512	com/google/protobuf/InvalidProtocolBufferException
    //   232	251	512	com/google/protobuf/InvalidProtocolBufferException
    //   251	263	512	com/google/protobuf/InvalidProtocolBufferException
    //   266	289	512	com/google/protobuf/InvalidProtocolBufferException
    //   292	315	512	com/google/protobuf/InvalidProtocolBufferException
    //   318	341	512	com/google/protobuf/InvalidProtocolBufferException
    //   344	361	512	com/google/protobuf/InvalidProtocolBufferException
    //   364	387	512	com/google/protobuf/InvalidProtocolBufferException
    //   390	406	512	com/google/protobuf/InvalidProtocolBufferException
    //   409	427	512	com/google/protobuf/InvalidProtocolBufferException
    //   430	453	512	com/google/protobuf/InvalidProtocolBufferException
    //   456	478	512	com/google/protobuf/InvalidProtocolBufferException
  }
  
  private DescriptorProtos$FieldDescriptorProto(GeneratedMessageV3.Builder<?> paramBuilder)
  {
    super(paramBuilder);
  }
  
  public static FieldDescriptorProto getDefaultInstance()
  {
    return a;
  }
  
  public static final Descriptors.Descriptor getDescriptor()
  {
    return DescriptorProtos.n();
  }
  
  public static DescriptorProtos.FieldDescriptorProto.Builder newBuilder()
  {
    return a.toBuilder();
  }
  
  public static DescriptorProtos.FieldDescriptorProto.Builder newBuilder(FieldDescriptorProto paramFieldDescriptorProto)
  {
    return a.toBuilder().a(paramFieldDescriptorProto);
  }
  
  public static FieldDescriptorProto parseDelimitedFrom(InputStream paramInputStream)
  {
    return (FieldDescriptorProto)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream);
  }
  
  public static FieldDescriptorProto parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (FieldDescriptorProto)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static FieldDescriptorProto parseFrom(ByteString paramByteString)
  {
    return (FieldDescriptorProto)PARSER.parseFrom(paramByteString);
  }
  
  public static FieldDescriptorProto parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (FieldDescriptorProto)PARSER.parseFrom(paramByteString, paramExtensionRegistryLite);
  }
  
  public static FieldDescriptorProto parseFrom(CodedInputStream paramCodedInputStream)
  {
    return (FieldDescriptorProto)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream);
  }
  
  public static FieldDescriptorProto parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (FieldDescriptorProto)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static FieldDescriptorProto parseFrom(InputStream paramInputStream)
  {
    return (FieldDescriptorProto)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream);
  }
  
  public static FieldDescriptorProto parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (FieldDescriptorProto)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static FieldDescriptorProto parseFrom(ByteBuffer paramByteBuffer)
  {
    return (FieldDescriptorProto)PARSER.parseFrom(paramByteBuffer);
  }
  
  public static FieldDescriptorProto parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (FieldDescriptorProto)PARSER.parseFrom(paramByteBuffer, paramExtensionRegistryLite);
  }
  
  public static FieldDescriptorProto parseFrom(byte[] paramArrayOfByte)
  {
    return (FieldDescriptorProto)PARSER.parseFrom(paramArrayOfByte);
  }
  
  public static FieldDescriptorProto parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (FieldDescriptorProto)PARSER.parseFrom(paramArrayOfByte, paramExtensionRegistryLite);
  }
  
  public static Parser<FieldDescriptorProto> parser()
  {
    return PARSER;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof FieldDescriptorProto)) {
      return super.equals(paramObject);
    }
    paramObject = (FieldDescriptorProto)paramObject;
    if (hasName() != paramObject.hasName()) {
      return false;
    }
    if ((hasName()) && (!getName().equals(paramObject.getName()))) {
      return false;
    }
    if (hasNumber() != paramObject.hasNumber()) {
      return false;
    }
    if ((hasNumber()) && (getNumber() != paramObject.getNumber())) {
      return false;
    }
    if (hasLabel() != paramObject.hasLabel()) {
      return false;
    }
    if ((hasLabel()) && (this.label_ != paramObject.label_)) {
      return false;
    }
    if (hasType() != paramObject.hasType()) {
      return false;
    }
    if ((hasType()) && (this.type_ != paramObject.type_)) {
      return false;
    }
    if (hasTypeName() != paramObject.hasTypeName()) {
      return false;
    }
    if ((hasTypeName()) && (!getTypeName().equals(paramObject.getTypeName()))) {
      return false;
    }
    if (hasExtendee() != paramObject.hasExtendee()) {
      return false;
    }
    if ((hasExtendee()) && (!getExtendee().equals(paramObject.getExtendee()))) {
      return false;
    }
    if (hasDefaultValue() != paramObject.hasDefaultValue()) {
      return false;
    }
    if ((hasDefaultValue()) && (!getDefaultValue().equals(paramObject.getDefaultValue()))) {
      return false;
    }
    if (hasOneofIndex() != paramObject.hasOneofIndex()) {
      return false;
    }
    if ((hasOneofIndex()) && (getOneofIndex() != paramObject.getOneofIndex())) {
      return false;
    }
    if (hasJsonName() != paramObject.hasJsonName()) {
      return false;
    }
    if ((hasJsonName()) && (!getJsonName().equals(paramObject.getJsonName()))) {
      return false;
    }
    if (hasOptions() != paramObject.hasOptions()) {
      return false;
    }
    if ((hasOptions()) && (!getOptions().equals(paramObject.getOptions()))) {
      return false;
    }
    return this.unknownFields.equals(paramObject.unknownFields);
  }
  
  public FieldDescriptorProto getDefaultInstanceForType()
  {
    return a;
  }
  
  public String getDefaultValue()
  {
    Object localObject = this.defaultValue_;
    if ((localObject instanceof String)) {
      return (String)localObject;
    }
    localObject = (ByteString)localObject;
    String str = ((ByteString)localObject).toStringUtf8();
    if (((ByteString)localObject).isValidUtf8()) {
      this.defaultValue_ = str;
    }
    return str;
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
  
  public String getExtendee()
  {
    Object localObject = this.extendee_;
    if ((localObject instanceof String)) {
      return (String)localObject;
    }
    localObject = (ByteString)localObject;
    String str = ((ByteString)localObject).toStringUtf8();
    if (((ByteString)localObject).isValidUtf8()) {
      this.extendee_ = str;
    }
    return str;
  }
  
  public ByteString getExtendeeBytes()
  {
    Object localObject = this.extendee_;
    if ((localObject instanceof String))
    {
      localObject = ByteString.copyFromUtf8((String)localObject);
      this.extendee_ = localObject;
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
    localObject = (ByteString)localObject;
    String str = ((ByteString)localObject).toStringUtf8();
    if (((ByteString)localObject).isValidUtf8()) {
      this.jsonName_ = str;
    }
    return str;
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
  
  public DescriptorProtos.FieldDescriptorProto.Label getLabel()
  {
    DescriptorProtos.FieldDescriptorProto.Label localLabel2 = DescriptorProtos.FieldDescriptorProto.Label.valueOf(this.label_);
    DescriptorProtos.FieldDescriptorProto.Label localLabel1 = localLabel2;
    if (localLabel2 == null) {
      localLabel1 = DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL;
    }
    return localLabel1;
  }
  
  public String getName()
  {
    Object localObject = this.name_;
    if ((localObject instanceof String)) {
      return (String)localObject;
    }
    localObject = (ByteString)localObject;
    String str = ((ByteString)localObject).toStringUtf8();
    if (((ByteString)localObject).isValidUtf8()) {
      this.name_ = str;
    }
    return str;
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
  
  public DescriptorProtos.FieldOptions getOptions()
  {
    DescriptorProtos.FieldOptions localFieldOptions2 = this.options_;
    DescriptorProtos.FieldOptions localFieldOptions1 = localFieldOptions2;
    if (localFieldOptions2 == null) {
      localFieldOptions1 = DescriptorProtos.FieldOptions.getDefaultInstance();
    }
    return localFieldOptions1;
  }
  
  public DescriptorProtos.FieldOptionsOrBuilder getOptionsOrBuilder()
  {
    DescriptorProtos.FieldOptions localFieldOptions2 = this.options_;
    DescriptorProtos.FieldOptions localFieldOptions1 = localFieldOptions2;
    if (localFieldOptions2 == null) {
      localFieldOptions1 = DescriptorProtos.FieldOptions.getDefaultInstance();
    }
    return localFieldOptions1;
  }
  
  public Parser<FieldDescriptorProto> getParserForType()
  {
    return PARSER;
  }
  
  public int getSerializedSize()
  {
    int i = this.memoizedSize;
    if (i != -1) {
      return i;
    }
    int j = 0;
    if ((this.bitField0_ & 0x1) != 0) {
      j = 0 + GeneratedMessageV3.computeStringSize(1, this.name_);
    }
    i = j;
    if ((this.bitField0_ & 0x20) != 0) {
      i = j + GeneratedMessageV3.computeStringSize(2, this.extendee_);
    }
    j = i;
    if ((this.bitField0_ & 0x2) != 0) {
      j = i + CodedOutputStream.h(3, this.number_);
    }
    i = j;
    if ((this.bitField0_ & 0x4) != 0) {
      i = j + CodedOutputStream.m(4, this.label_);
    }
    j = i;
    if ((this.bitField0_ & 0x8) != 0) {
      j = i + CodedOutputStream.m(5, this.type_);
    }
    i = j;
    if ((this.bitField0_ & 0x10) != 0) {
      i = j + GeneratedMessageV3.computeStringSize(6, this.typeName_);
    }
    j = i;
    if ((this.bitField0_ & 0x40) != 0) {
      j = i + GeneratedMessageV3.computeStringSize(7, this.defaultValue_);
    }
    i = j;
    if ((this.bitField0_ & 0x200) != 0) {
      i = j + CodedOutputStream.c(8, getOptions());
    }
    j = i;
    if ((this.bitField0_ & 0x80) != 0) {
      j = i + CodedOutputStream.h(9, this.oneofIndex_);
    }
    i = j;
    if ((this.bitField0_ & 0x100) != 0) {
      i = j + GeneratedMessageV3.computeStringSize(10, this.jsonName_);
    }
    i += this.unknownFields.getSerializedSize();
    this.memoizedSize = i;
    return i;
  }
  
  public DescriptorProtos.FieldDescriptorProto.Type getType()
  {
    DescriptorProtos.FieldDescriptorProto.Type localType2 = DescriptorProtos.FieldDescriptorProto.Type.valueOf(this.type_);
    DescriptorProtos.FieldDescriptorProto.Type localType1 = localType2;
    if (localType2 == null) {
      localType1 = DescriptorProtos.FieldDescriptorProto.Type.TYPE_DOUBLE;
    }
    return localType1;
  }
  
  public String getTypeName()
  {
    Object localObject = this.typeName_;
    if ((localObject instanceof String)) {
      return (String)localObject;
    }
    localObject = (ByteString)localObject;
    String str = ((ByteString)localObject).toStringUtf8();
    if (((ByteString)localObject).isValidUtf8()) {
      this.typeName_ = str;
    }
    return str;
  }
  
  public ByteString getTypeNameBytes()
  {
    Object localObject = this.typeName_;
    if ((localObject instanceof String))
    {
      localObject = ByteString.copyFromUtf8((String)localObject);
      this.typeName_ = localObject;
      return localObject;
    }
    return (ByteString)localObject;
  }
  
  public final UnknownFieldSet getUnknownFields()
  {
    return this.unknownFields;
  }
  
  public boolean hasDefaultValue()
  {
    return (this.bitField0_ & 0x40) != 0;
  }
  
  public boolean hasExtendee()
  {
    return (this.bitField0_ & 0x20) != 0;
  }
  
  public boolean hasJsonName()
  {
    return (this.bitField0_ & 0x100) != 0;
  }
  
  public boolean hasLabel()
  {
    return (this.bitField0_ & 0x4) != 0;
  }
  
  public boolean hasName()
  {
    return (this.bitField0_ & 0x1) != 0;
  }
  
  public boolean hasNumber()
  {
    return (this.bitField0_ & 0x2) != 0;
  }
  
  public boolean hasOneofIndex()
  {
    return (this.bitField0_ & 0x80) != 0;
  }
  
  public boolean hasOptions()
  {
    return (this.bitField0_ & 0x200) != 0;
  }
  
  public boolean hasType()
  {
    return (this.bitField0_ & 0x8) != 0;
  }
  
  public boolean hasTypeName()
  {
    return (this.bitField0_ & 0x10) != 0;
  }
  
  public int hashCode()
  {
    if (this.memoizedHashCode != 0) {
      return this.memoizedHashCode;
    }
    int j = 779 + getDescriptor().hashCode();
    int i = j;
    if (hasName()) {
      i = (j * 37 + 1) * 53 + getName().hashCode();
    }
    j = i;
    if (hasNumber()) {
      j = (i * 37 + 3) * 53 + getNumber();
    }
    i = j;
    if (hasLabel()) {
      i = (j * 37 + 4) * 53 + this.label_;
    }
    j = i;
    if (hasType()) {
      j = (i * 37 + 5) * 53 + this.type_;
    }
    i = j;
    if (hasTypeName()) {
      i = (j * 37 + 6) * 53 + getTypeName().hashCode();
    }
    j = i;
    if (hasExtendee()) {
      j = (i * 37 + 2) * 53 + getExtendee().hashCode();
    }
    i = j;
    if (hasDefaultValue()) {
      i = (j * 37 + 7) * 53 + getDefaultValue().hashCode();
    }
    j = i;
    if (hasOneofIndex()) {
      j = (i * 37 + 9) * 53 + getOneofIndex();
    }
    i = j;
    if (hasJsonName()) {
      i = (j * 37 + 10) * 53 + getJsonName().hashCode();
    }
    j = i;
    if (hasOptions()) {
      j = (i * 37 + 8) * 53 + getOptions().hashCode();
    }
    i = j * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    return i;
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return DescriptorProtos.o().a(FieldDescriptorProto.class, DescriptorProtos.FieldDescriptorProto.Builder.class);
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
    if ((hasOptions()) && (!getOptions().isInitialized()))
    {
      this.memoizedIsInitialized = 0;
      return false;
    }
    this.memoizedIsInitialized = 1;
    return true;
  }
  
  public DescriptorProtos.FieldDescriptorProto.Builder newBuilderForType()
  {
    return newBuilder();
  }
  
  protected DescriptorProtos.FieldDescriptorProto.Builder newBuilderForType(GeneratedMessageV3.BuilderParent paramBuilderParent)
  {
    return new DescriptorProtos.FieldDescriptorProto.Builder(paramBuilderParent, null);
  }
  
  protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter paramUnusedPrivateParameter)
  {
    return new FieldDescriptorProto();
  }
  
  public DescriptorProtos.FieldDescriptorProto.Builder toBuilder()
  {
    if (this == a) {
      return new DescriptorProtos.FieldDescriptorProto.Builder(null);
    }
    return new DescriptorProtos.FieldDescriptorProto.Builder(null).a(this);
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
  {
    if ((this.bitField0_ & 0x1) != 0) {
      GeneratedMessageV3.writeString(paramCodedOutputStream, 1, this.name_);
    }
    if ((this.bitField0_ & 0x20) != 0) {
      GeneratedMessageV3.writeString(paramCodedOutputStream, 2, this.extendee_);
    }
    if ((this.bitField0_ & 0x2) != 0) {
      paramCodedOutputStream.b(3, this.number_);
    }
    if ((this.bitField0_ & 0x4) != 0) {
      paramCodedOutputStream.g(4, this.label_);
    }
    if ((this.bitField0_ & 0x8) != 0) {
      paramCodedOutputStream.g(5, this.type_);
    }
    if ((this.bitField0_ & 0x10) != 0) {
      GeneratedMessageV3.writeString(paramCodedOutputStream, 6, this.typeName_);
    }
    if ((this.bitField0_ & 0x40) != 0) {
      GeneratedMessageV3.writeString(paramCodedOutputStream, 7, this.defaultValue_);
    }
    if ((this.bitField0_ & 0x200) != 0) {
      paramCodedOutputStream.a(8, getOptions());
    }
    if ((this.bitField0_ & 0x80) != 0) {
      paramCodedOutputStream.b(9, this.oneofIndex_);
    }
    if ((this.bitField0_ & 0x100) != 0) {
      GeneratedMessageV3.writeString(paramCodedOutputStream, 10, this.jsonName_);
    }
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.DescriptorProtos.FieldDescriptorProto
 * JD-Core Version:    0.7.0.1
 */