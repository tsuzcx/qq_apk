package com.google.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

public final class DescriptorProtos$ServiceDescriptorProto
  extends GeneratedMessageV3
  implements DescriptorProtos.ServiceDescriptorProtoOrBuilder
{
  public static final int METHOD_FIELD_NUMBER = 2;
  public static final int NAME_FIELD_NUMBER = 1;
  public static final int OPTIONS_FIELD_NUMBER = 3;
  @Deprecated
  public static final Parser<ServiceDescriptorProto> PARSER = new DescriptorProtos.ServiceDescriptorProto.1();
  private static final ServiceDescriptorProto a = new ServiceDescriptorProto();
  private static final long serialVersionUID = 0L;
  private int bitField0_;
  private byte memoizedIsInitialized = -1;
  private List<DescriptorProtos.MethodDescriptorProto> method_;
  private volatile Object name_;
  private DescriptorProtos.ServiceOptions options_;
  
  private DescriptorProtos$ServiceDescriptorProto()
  {
    this.name_ = "";
    this.method_ = Collections.emptyList();
  }
  
  /* Error */
  private DescriptorProtos$ServiceDescriptorProto(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 38	com/google/protobuf/DescriptorProtos$ServiceDescriptorProto:<init>	()V
    //   4: aload_2
    //   5: ifnull +436 -> 441
    //   8: invokestatic 71	com/google/protobuf/UnknownFieldSet:a	()Lcom/google/protobuf/UnknownFieldSet$Builder;
    //   11: astore 10
    //   13: iconst_0
    //   14: istore 8
    //   16: iconst_0
    //   17: istore_3
    //   18: iload 8
    //   20: ifne +390 -> 410
    //   23: iload_3
    //   24: istore 5
    //   26: iload_3
    //   27: istore 6
    //   29: iload_3
    //   30: istore 7
    //   32: aload_1
    //   33: invokevirtual 76	com/google/protobuf/CodedInputStream:a	()I
    //   36: istore 4
    //   38: iload 4
    //   40: ifeq +298 -> 338
    //   43: iload 4
    //   45: bipush 10
    //   47: if_icmpeq +239 -> 286
    //   50: iload 4
    //   52: bipush 18
    //   54: if_icmpeq +162 -> 216
    //   57: iload 4
    //   59: bipush 26
    //   61: if_icmpeq +28 -> 89
    //   64: iload_3
    //   65: istore 5
    //   67: iload_3
    //   68: istore 6
    //   70: iload_3
    //   71: istore 7
    //   73: aload_0
    //   74: aload_1
    //   75: aload 10
    //   77: aload_2
    //   78: iload 4
    //   80: invokevirtual 80	com/google/protobuf/DescriptorProtos$ServiceDescriptorProto:parseUnknownField	(Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/UnknownFieldSet$Builder;Lcom/google/protobuf/ExtensionRegistryLite;I)Z
    //   83: ifne -65 -> 18
    //   86: goto +252 -> 338
    //   89: aconst_null
    //   90: astore 9
    //   92: iload_3
    //   93: istore 5
    //   95: iload_3
    //   96: istore 6
    //   98: iload_3
    //   99: istore 7
    //   101: aload_0
    //   102: getfield 82	com/google/protobuf/DescriptorProtos$ServiceDescriptorProto:bitField0_	I
    //   105: iconst_2
    //   106: iand
    //   107: ifeq +21 -> 128
    //   110: iload_3
    //   111: istore 5
    //   113: iload_3
    //   114: istore 6
    //   116: iload_3
    //   117: istore 7
    //   119: aload_0
    //   120: getfield 84	com/google/protobuf/DescriptorProtos$ServiceDescriptorProto:options_	Lcom/google/protobuf/DescriptorProtos$ServiceOptions;
    //   123: invokevirtual 90	com/google/protobuf/DescriptorProtos$ServiceOptions:toBuilder	()Lcom/google/protobuf/DescriptorProtos$ServiceOptions$Builder;
    //   126: astore 9
    //   128: iload_3
    //   129: istore 5
    //   131: iload_3
    //   132: istore 6
    //   134: iload_3
    //   135: istore 7
    //   137: aload_0
    //   138: aload_1
    //   139: getstatic 91	com/google/protobuf/DescriptorProtos$ServiceOptions:PARSER	Lcom/google/protobuf/Parser;
    //   142: aload_2
    //   143: invokevirtual 94	com/google/protobuf/CodedInputStream:a	(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   146: checkcast 86	com/google/protobuf/DescriptorProtos$ServiceOptions
    //   149: putfield 84	com/google/protobuf/DescriptorProtos$ServiceDescriptorProto:options_	Lcom/google/protobuf/DescriptorProtos$ServiceOptions;
    //   152: aload 9
    //   154: ifnull +40 -> 194
    //   157: iload_3
    //   158: istore 5
    //   160: iload_3
    //   161: istore 6
    //   163: iload_3
    //   164: istore 7
    //   166: aload 9
    //   168: aload_0
    //   169: getfield 84	com/google/protobuf/DescriptorProtos$ServiceDescriptorProto:options_	Lcom/google/protobuf/DescriptorProtos$ServiceOptions;
    //   172: invokevirtual 99	com/google/protobuf/DescriptorProtos$ServiceOptions$Builder:a	(Lcom/google/protobuf/DescriptorProtos$ServiceOptions;)Lcom/google/protobuf/DescriptorProtos$ServiceOptions$Builder;
    //   175: pop
    //   176: iload_3
    //   177: istore 5
    //   179: iload_3
    //   180: istore 6
    //   182: iload_3
    //   183: istore 7
    //   185: aload_0
    //   186: aload 9
    //   188: invokevirtual 103	com/google/protobuf/DescriptorProtos$ServiceOptions$Builder:d	()Lcom/google/protobuf/DescriptorProtos$ServiceOptions;
    //   191: putfield 84	com/google/protobuf/DescriptorProtos$ServiceDescriptorProto:options_	Lcom/google/protobuf/DescriptorProtos$ServiceOptions;
    //   194: iload_3
    //   195: istore 5
    //   197: iload_3
    //   198: istore 6
    //   200: iload_3
    //   201: istore 7
    //   203: aload_0
    //   204: aload_0
    //   205: getfield 82	com/google/protobuf/DescriptorProtos$ServiceDescriptorProto:bitField0_	I
    //   208: iconst_2
    //   209: ior
    //   210: putfield 82	com/google/protobuf/DescriptorProtos$ServiceDescriptorProto:bitField0_	I
    //   213: goto -195 -> 18
    //   216: iload_3
    //   217: istore 4
    //   219: iload_3
    //   220: iconst_2
    //   221: iand
    //   222: ifne +28 -> 250
    //   225: iload_3
    //   226: istore 5
    //   228: iload_3
    //   229: istore 6
    //   231: iload_3
    //   232: istore 7
    //   234: aload_0
    //   235: new 105	java/util/ArrayList
    //   238: dup
    //   239: invokespecial 106	java/util/ArrayList:<init>	()V
    //   242: putfield 61	com/google/protobuf/DescriptorProtos$ServiceDescriptorProto:method_	Ljava/util/List;
    //   245: iload_3
    //   246: iconst_2
    //   247: ior
    //   248: istore 4
    //   250: iload 4
    //   252: istore 5
    //   254: iload 4
    //   256: istore 6
    //   258: iload 4
    //   260: istore 7
    //   262: aload_0
    //   263: getfield 61	com/google/protobuf/DescriptorProtos$ServiceDescriptorProto:method_	Ljava/util/List;
    //   266: aload_1
    //   267: getstatic 109	com/google/protobuf/DescriptorProtos$MethodDescriptorProto:PARSER	Lcom/google/protobuf/Parser;
    //   270: aload_2
    //   271: invokevirtual 94	com/google/protobuf/CodedInputStream:a	(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   274: invokeinterface 115 2 0
    //   279: pop
    //   280: iload 4
    //   282: istore_3
    //   283: goto -265 -> 18
    //   286: iload_3
    //   287: istore 5
    //   289: iload_3
    //   290: istore 6
    //   292: iload_3
    //   293: istore 7
    //   295: aload_1
    //   296: invokevirtual 119	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   299: astore 9
    //   301: iload_3
    //   302: istore 5
    //   304: iload_3
    //   305: istore 6
    //   307: iload_3
    //   308: istore 7
    //   310: aload_0
    //   311: iconst_1
    //   312: aload_0
    //   313: getfield 82	com/google/protobuf/DescriptorProtos$ServiceDescriptorProto:bitField0_	I
    //   316: ior
    //   317: putfield 82	com/google/protobuf/DescriptorProtos$ServiceDescriptorProto:bitField0_	I
    //   320: iload_3
    //   321: istore 5
    //   323: iload_3
    //   324: istore 6
    //   326: iload_3
    //   327: istore 7
    //   329: aload_0
    //   330: aload 9
    //   332: putfield 53	com/google/protobuf/DescriptorProtos$ServiceDescriptorProto:name_	Ljava/lang/Object;
    //   335: goto -317 -> 18
    //   338: iconst_1
    //   339: istore 8
    //   341: goto -323 -> 18
    //   344: astore_1
    //   345: goto +32 -> 377
    //   348: astore_1
    //   349: iload 6
    //   351: istore 5
    //   353: new 64	com/google/protobuf/InvalidProtocolBufferException
    //   356: dup
    //   357: aload_1
    //   358: invokespecial 122	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/io/IOException;)V
    //   361: aload_0
    //   362: invokevirtual 126	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   365: athrow
    //   366: astore_1
    //   367: iload 7
    //   369: istore 5
    //   371: aload_1
    //   372: aload_0
    //   373: invokevirtual 126	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   376: athrow
    //   377: iload 5
    //   379: iconst_2
    //   380: iand
    //   381: ifeq +14 -> 395
    //   384: aload_0
    //   385: aload_0
    //   386: getfield 61	com/google/protobuf/DescriptorProtos$ServiceDescriptorProto:method_	Ljava/util/List;
    //   389: invokestatic 130	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   392: putfield 61	com/google/protobuf/DescriptorProtos$ServiceDescriptorProto:method_	Ljava/util/List;
    //   395: aload_0
    //   396: aload 10
    //   398: invokevirtual 135	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   401: putfield 139	com/google/protobuf/DescriptorProtos$ServiceDescriptorProto:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   404: aload_0
    //   405: invokevirtual 142	com/google/protobuf/DescriptorProtos$ServiceDescriptorProto:makeExtensionsImmutable	()V
    //   408: aload_1
    //   409: athrow
    //   410: iload_3
    //   411: iconst_2
    //   412: iand
    //   413: ifeq +14 -> 427
    //   416: aload_0
    //   417: aload_0
    //   418: getfield 61	com/google/protobuf/DescriptorProtos$ServiceDescriptorProto:method_	Ljava/util/List;
    //   421: invokestatic 130	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   424: putfield 61	com/google/protobuf/DescriptorProtos$ServiceDescriptorProto:method_	Ljava/util/List;
    //   427: aload_0
    //   428: aload 10
    //   430: invokevirtual 135	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   433: putfield 139	com/google/protobuf/DescriptorProtos$ServiceDescriptorProto:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   436: aload_0
    //   437: invokevirtual 142	com/google/protobuf/DescriptorProtos$ServiceDescriptorProto:makeExtensionsImmutable	()V
    //   440: return
    //   441: new 144	java/lang/NullPointerException
    //   444: dup
    //   445: invokespecial 145	java/lang/NullPointerException:<init>	()V
    //   448: astore_1
    //   449: goto +5 -> 454
    //   452: aload_1
    //   453: athrow
    //   454: goto -2 -> 452
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	457	0	this	ServiceDescriptorProto
    //   0	457	1	paramCodedInputStream	CodedInputStream
    //   0	457	2	paramExtensionRegistryLite	ExtensionRegistryLite
    //   17	396	3	i	int
    //   36	245	4	j	int
    //   24	357	5	k	int
    //   27	323	6	m	int
    //   30	338	7	n	int
    //   14	326	8	i1	int
    //   90	241	9	localObject	Object
    //   11	418	10	localBuilder	UnknownFieldSet.Builder
    // Exception table:
    //   from	to	target	type
    //   32	38	344	finally
    //   73	86	344	finally
    //   101	110	344	finally
    //   119	128	344	finally
    //   137	152	344	finally
    //   166	176	344	finally
    //   185	194	344	finally
    //   203	213	344	finally
    //   234	245	344	finally
    //   262	280	344	finally
    //   295	301	344	finally
    //   310	320	344	finally
    //   329	335	344	finally
    //   353	366	344	finally
    //   371	377	344	finally
    //   32	38	348	java/io/IOException
    //   73	86	348	java/io/IOException
    //   101	110	348	java/io/IOException
    //   119	128	348	java/io/IOException
    //   137	152	348	java/io/IOException
    //   166	176	348	java/io/IOException
    //   185	194	348	java/io/IOException
    //   203	213	348	java/io/IOException
    //   234	245	348	java/io/IOException
    //   262	280	348	java/io/IOException
    //   295	301	348	java/io/IOException
    //   310	320	348	java/io/IOException
    //   329	335	348	java/io/IOException
    //   32	38	366	com/google/protobuf/InvalidProtocolBufferException
    //   73	86	366	com/google/protobuf/InvalidProtocolBufferException
    //   101	110	366	com/google/protobuf/InvalidProtocolBufferException
    //   119	128	366	com/google/protobuf/InvalidProtocolBufferException
    //   137	152	366	com/google/protobuf/InvalidProtocolBufferException
    //   166	176	366	com/google/protobuf/InvalidProtocolBufferException
    //   185	194	366	com/google/protobuf/InvalidProtocolBufferException
    //   203	213	366	com/google/protobuf/InvalidProtocolBufferException
    //   234	245	366	com/google/protobuf/InvalidProtocolBufferException
    //   262	280	366	com/google/protobuf/InvalidProtocolBufferException
    //   295	301	366	com/google/protobuf/InvalidProtocolBufferException
    //   310	320	366	com/google/protobuf/InvalidProtocolBufferException
    //   329	335	366	com/google/protobuf/InvalidProtocolBufferException
  }
  
  private DescriptorProtos$ServiceDescriptorProto(GeneratedMessageV3.Builder<?> paramBuilder)
  {
    super(paramBuilder);
  }
  
  public static ServiceDescriptorProto getDefaultInstance()
  {
    return a;
  }
  
  public static final Descriptors.Descriptor getDescriptor()
  {
    return DescriptorProtos.x();
  }
  
  public static DescriptorProtos.ServiceDescriptorProto.Builder newBuilder()
  {
    return a.toBuilder();
  }
  
  public static DescriptorProtos.ServiceDescriptorProto.Builder newBuilder(ServiceDescriptorProto paramServiceDescriptorProto)
  {
    return a.toBuilder().a(paramServiceDescriptorProto);
  }
  
  public static ServiceDescriptorProto parseDelimitedFrom(InputStream paramInputStream)
  {
    return (ServiceDescriptorProto)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream);
  }
  
  public static ServiceDescriptorProto parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (ServiceDescriptorProto)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static ServiceDescriptorProto parseFrom(ByteString paramByteString)
  {
    return (ServiceDescriptorProto)PARSER.parseFrom(paramByteString);
  }
  
  public static ServiceDescriptorProto parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (ServiceDescriptorProto)PARSER.parseFrom(paramByteString, paramExtensionRegistryLite);
  }
  
  public static ServiceDescriptorProto parseFrom(CodedInputStream paramCodedInputStream)
  {
    return (ServiceDescriptorProto)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream);
  }
  
  public static ServiceDescriptorProto parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (ServiceDescriptorProto)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static ServiceDescriptorProto parseFrom(InputStream paramInputStream)
  {
    return (ServiceDescriptorProto)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream);
  }
  
  public static ServiceDescriptorProto parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (ServiceDescriptorProto)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static ServiceDescriptorProto parseFrom(ByteBuffer paramByteBuffer)
  {
    return (ServiceDescriptorProto)PARSER.parseFrom(paramByteBuffer);
  }
  
  public static ServiceDescriptorProto parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (ServiceDescriptorProto)PARSER.parseFrom(paramByteBuffer, paramExtensionRegistryLite);
  }
  
  public static ServiceDescriptorProto parseFrom(byte[] paramArrayOfByte)
  {
    return (ServiceDescriptorProto)PARSER.parseFrom(paramArrayOfByte);
  }
  
  public static ServiceDescriptorProto parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (ServiceDescriptorProto)PARSER.parseFrom(paramArrayOfByte, paramExtensionRegistryLite);
  }
  
  public static Parser<ServiceDescriptorProto> parser()
  {
    return PARSER;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof ServiceDescriptorProto)) {
      return super.equals(paramObject);
    }
    paramObject = (ServiceDescriptorProto)paramObject;
    if (hasName() != paramObject.hasName()) {
      return false;
    }
    if ((hasName()) && (!getName().equals(paramObject.getName()))) {
      return false;
    }
    if (!getMethodList().equals(paramObject.getMethodList())) {
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
  
  public ServiceDescriptorProto getDefaultInstanceForType()
  {
    return a;
  }
  
  public DescriptorProtos.MethodDescriptorProto getMethod(int paramInt)
  {
    return (DescriptorProtos.MethodDescriptorProto)this.method_.get(paramInt);
  }
  
  public int getMethodCount()
  {
    return this.method_.size();
  }
  
  public List<DescriptorProtos.MethodDescriptorProto> getMethodList()
  {
    return this.method_;
  }
  
  public DescriptorProtos.MethodDescriptorProtoOrBuilder getMethodOrBuilder(int paramInt)
  {
    return (DescriptorProtos.MethodDescriptorProtoOrBuilder)this.method_.get(paramInt);
  }
  
  public List<? extends DescriptorProtos.MethodDescriptorProtoOrBuilder> getMethodOrBuilderList()
  {
    return this.method_;
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
  
  public DescriptorProtos.ServiceOptions getOptions()
  {
    DescriptorProtos.ServiceOptions localServiceOptions2 = this.options_;
    DescriptorProtos.ServiceOptions localServiceOptions1 = localServiceOptions2;
    if (localServiceOptions2 == null) {
      localServiceOptions1 = DescriptorProtos.ServiceOptions.getDefaultInstance();
    }
    return localServiceOptions1;
  }
  
  public DescriptorProtos.ServiceOptionsOrBuilder getOptionsOrBuilder()
  {
    DescriptorProtos.ServiceOptions localServiceOptions2 = this.options_;
    DescriptorProtos.ServiceOptions localServiceOptions1 = localServiceOptions2;
    if (localServiceOptions2 == null) {
      localServiceOptions1 = DescriptorProtos.ServiceOptions.getDefaultInstance();
    }
    return localServiceOptions1;
  }
  
  public Parser<ServiceDescriptorProto> getParserForType()
  {
    return PARSER;
  }
  
  public int getSerializedSize()
  {
    int i = this.memoizedSize;
    if (i != -1) {
      return i;
    }
    i = this.bitField0_;
    int j = 0;
    if ((i & 0x1) != 0) {
      i = GeneratedMessageV3.computeStringSize(1, this.name_) + 0;
    } else {
      i = 0;
    }
    while (j < this.method_.size())
    {
      i += CodedOutputStream.c(2, (MessageLite)this.method_.get(j));
      j += 1;
    }
    j = i;
    if ((this.bitField0_ & 0x2) != 0) {
      j = i + CodedOutputStream.c(3, getOptions());
    }
    i = j + this.unknownFields.getSerializedSize();
    this.memoizedSize = i;
    return i;
  }
  
  public final UnknownFieldSet getUnknownFields()
  {
    return this.unknownFields;
  }
  
  public boolean hasName()
  {
    return (this.bitField0_ & 0x1) != 0;
  }
  
  public boolean hasOptions()
  {
    return (this.bitField0_ & 0x2) != 0;
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
    if (getMethodCount() > 0) {
      j = (i * 37 + 2) * 53 + getMethodList().hashCode();
    }
    i = j;
    if (hasOptions()) {
      i = (j * 37 + 3) * 53 + getOptions().hashCode();
    }
    i = i * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    return i;
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return DescriptorProtos.y().a(ServiceDescriptorProto.class, DescriptorProtos.ServiceDescriptorProto.Builder.class);
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
    i = 0;
    while (i < getMethodCount())
    {
      if (!getMethod(i).isInitialized())
      {
        this.memoizedIsInitialized = 0;
        return false;
      }
      i += 1;
    }
    if ((hasOptions()) && (!getOptions().isInitialized()))
    {
      this.memoizedIsInitialized = 0;
      return false;
    }
    this.memoizedIsInitialized = 1;
    return true;
  }
  
  public DescriptorProtos.ServiceDescriptorProto.Builder newBuilderForType()
  {
    return newBuilder();
  }
  
  protected DescriptorProtos.ServiceDescriptorProto.Builder newBuilderForType(GeneratedMessageV3.BuilderParent paramBuilderParent)
  {
    return new DescriptorProtos.ServiceDescriptorProto.Builder(paramBuilderParent, null);
  }
  
  protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter paramUnusedPrivateParameter)
  {
    return new ServiceDescriptorProto();
  }
  
  public DescriptorProtos.ServiceDescriptorProto.Builder toBuilder()
  {
    if (this == a) {
      return new DescriptorProtos.ServiceDescriptorProto.Builder(null);
    }
    return new DescriptorProtos.ServiceDescriptorProto.Builder(null).a(this);
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
  {
    if ((this.bitField0_ & 0x1) != 0) {
      GeneratedMessageV3.writeString(paramCodedOutputStream, 1, this.name_);
    }
    int i = 0;
    while (i < this.method_.size())
    {
      paramCodedOutputStream.a(2, (MessageLite)this.method_.get(i));
      i += 1;
    }
    if ((this.bitField0_ & 0x2) != 0) {
      paramCodedOutputStream.a(3, getOptions());
    }
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.DescriptorProtos.ServiceDescriptorProto
 * JD-Core Version:    0.7.0.1
 */