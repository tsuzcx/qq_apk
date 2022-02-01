package com.google.protobuf.compiler;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.DescriptorProtos.FileDescriptorProto;
import com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.GeneratedMessageV3.Builder;
import com.google.protobuf.GeneratedMessageV3.BuilderParent;
import com.google.protobuf.GeneratedMessageV3.FieldAccessorTable;
import com.google.protobuf.GeneratedMessageV3.UnusedPrivateParameter;
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.UnknownFieldSet;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

public final class PluginProtos$CodeGeneratorRequest
  extends GeneratedMessageV3
  implements PluginProtos.CodeGeneratorRequestOrBuilder
{
  public static final int COMPILER_VERSION_FIELD_NUMBER = 3;
  public static final int FILE_TO_GENERATE_FIELD_NUMBER = 1;
  public static final int PARAMETER_FIELD_NUMBER = 2;
  @Deprecated
  public static final Parser<CodeGeneratorRequest> PARSER = new PluginProtos.CodeGeneratorRequest.1();
  public static final int PROTO_FILE_FIELD_NUMBER = 15;
  private static final CodeGeneratorRequest a = new CodeGeneratorRequest();
  private static final long serialVersionUID = 0L;
  private int bitField0_;
  private PluginProtos.Version compilerVersion_;
  private LazyStringList fileToGenerate_;
  private byte memoizedIsInitialized = -1;
  private volatile Object parameter_;
  private List<DescriptorProtos.FileDescriptorProto> protoFile_;
  
  private PluginProtos$CodeGeneratorRequest()
  {
    this.fileToGenerate_ = LazyStringArrayList.a;
    this.parameter_ = "";
    this.protoFile_ = Collections.emptyList();
  }
  
  /* Error */
  private PluginProtos$CodeGeneratorRequest(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 42	com/google/protobuf/compiler/PluginProtos$CodeGeneratorRequest:<init>	()V
    //   4: aload_2
    //   5: ifnull +560 -> 565
    //   8: invokestatic 81	com/google/protobuf/UnknownFieldSet:a	()Lcom/google/protobuf/UnknownFieldSet$Builder;
    //   11: astore 10
    //   13: iconst_0
    //   14: istore 8
    //   16: iconst_0
    //   17: istore_3
    //   18: iload 8
    //   20: ifne +495 -> 515
    //   23: iload_3
    //   24: istore 4
    //   26: iload_3
    //   27: istore 6
    //   29: iload_3
    //   30: istore 7
    //   32: aload_1
    //   33: invokevirtual 86	com/google/protobuf/CodedInputStream:a	()I
    //   36: istore 5
    //   38: iload 5
    //   40: ifeq +383 -> 423
    //   43: iload 5
    //   45: bipush 10
    //   47: if_icmpeq +298 -> 345
    //   50: iload 5
    //   52: bipush 18
    //   54: if_icmpeq +239 -> 293
    //   57: iload 5
    //   59: bipush 26
    //   61: if_icmpeq +105 -> 166
    //   64: iload 5
    //   66: bipush 122
    //   68: if_icmpeq +28 -> 96
    //   71: iload_3
    //   72: istore 4
    //   74: iload_3
    //   75: istore 6
    //   77: iload_3
    //   78: istore 7
    //   80: aload_0
    //   81: aload_1
    //   82: aload 10
    //   84: aload_2
    //   85: iload 5
    //   87: invokevirtual 90	com/google/protobuf/compiler/PluginProtos$CodeGeneratorRequest:parseUnknownField	(Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/UnknownFieldSet$Builder;Lcom/google/protobuf/ExtensionRegistryLite;I)Z
    //   90: ifne -72 -> 18
    //   93: goto +330 -> 423
    //   96: iload_3
    //   97: istore 5
    //   99: iload_3
    //   100: iconst_4
    //   101: iand
    //   102: ifne +28 -> 130
    //   105: iload_3
    //   106: istore 4
    //   108: iload_3
    //   109: istore 6
    //   111: iload_3
    //   112: istore 7
    //   114: aload_0
    //   115: new 92	java/util/ArrayList
    //   118: dup
    //   119: invokespecial 93	java/util/ArrayList:<init>	()V
    //   122: putfield 71	com/google/protobuf/compiler/PluginProtos$CodeGeneratorRequest:protoFile_	Ljava/util/List;
    //   125: iload_3
    //   126: iconst_4
    //   127: ior
    //   128: istore 5
    //   130: iload 5
    //   132: istore 4
    //   134: iload 5
    //   136: istore 6
    //   138: iload 5
    //   140: istore 7
    //   142: aload_0
    //   143: getfield 71	com/google/protobuf/compiler/PluginProtos$CodeGeneratorRequest:protoFile_	Ljava/util/List;
    //   146: aload_1
    //   147: getstatic 96	com/google/protobuf/DescriptorProtos$FileDescriptorProto:PARSER	Lcom/google/protobuf/Parser;
    //   150: aload_2
    //   151: invokevirtual 99	com/google/protobuf/CodedInputStream:a	(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   154: invokeinterface 105 2 0
    //   159: pop
    //   160: iload 5
    //   162: istore_3
    //   163: goto -145 -> 18
    //   166: aconst_null
    //   167: astore 9
    //   169: iload_3
    //   170: istore 4
    //   172: iload_3
    //   173: istore 6
    //   175: iload_3
    //   176: istore 7
    //   178: aload_0
    //   179: getfield 107	com/google/protobuf/compiler/PluginProtos$CodeGeneratorRequest:bitField0_	I
    //   182: iconst_2
    //   183: iand
    //   184: ifeq +21 -> 205
    //   187: iload_3
    //   188: istore 4
    //   190: iload_3
    //   191: istore 6
    //   193: iload_3
    //   194: istore 7
    //   196: aload_0
    //   197: getfield 109	com/google/protobuf/compiler/PluginProtos$CodeGeneratorRequest:compilerVersion_	Lcom/google/protobuf/compiler/PluginProtos$Version;
    //   200: invokevirtual 115	com/google/protobuf/compiler/PluginProtos$Version:toBuilder	()Lcom/google/protobuf/compiler/PluginProtos$Version$Builder;
    //   203: astore 9
    //   205: iload_3
    //   206: istore 4
    //   208: iload_3
    //   209: istore 6
    //   211: iload_3
    //   212: istore 7
    //   214: aload_0
    //   215: aload_1
    //   216: getstatic 116	com/google/protobuf/compiler/PluginProtos$Version:PARSER	Lcom/google/protobuf/Parser;
    //   219: aload_2
    //   220: invokevirtual 99	com/google/protobuf/CodedInputStream:a	(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   223: checkcast 111	com/google/protobuf/compiler/PluginProtos$Version
    //   226: putfield 109	com/google/protobuf/compiler/PluginProtos$CodeGeneratorRequest:compilerVersion_	Lcom/google/protobuf/compiler/PluginProtos$Version;
    //   229: aload 9
    //   231: ifnull +40 -> 271
    //   234: iload_3
    //   235: istore 4
    //   237: iload_3
    //   238: istore 6
    //   240: iload_3
    //   241: istore 7
    //   243: aload 9
    //   245: aload_0
    //   246: getfield 109	com/google/protobuf/compiler/PluginProtos$CodeGeneratorRequest:compilerVersion_	Lcom/google/protobuf/compiler/PluginProtos$Version;
    //   249: invokevirtual 121	com/google/protobuf/compiler/PluginProtos$Version$Builder:a	(Lcom/google/protobuf/compiler/PluginProtos$Version;)Lcom/google/protobuf/compiler/PluginProtos$Version$Builder;
    //   252: pop
    //   253: iload_3
    //   254: istore 4
    //   256: iload_3
    //   257: istore 6
    //   259: iload_3
    //   260: istore 7
    //   262: aload_0
    //   263: aload 9
    //   265: invokevirtual 125	com/google/protobuf/compiler/PluginProtos$Version$Builder:d	()Lcom/google/protobuf/compiler/PluginProtos$Version;
    //   268: putfield 109	com/google/protobuf/compiler/PluginProtos$CodeGeneratorRequest:compilerVersion_	Lcom/google/protobuf/compiler/PluginProtos$Version;
    //   271: iload_3
    //   272: istore 4
    //   274: iload_3
    //   275: istore 6
    //   277: iload_3
    //   278: istore 7
    //   280: aload_0
    //   281: aload_0
    //   282: getfield 107	com/google/protobuf/compiler/PluginProtos$CodeGeneratorRequest:bitField0_	I
    //   285: iconst_2
    //   286: ior
    //   287: putfield 107	com/google/protobuf/compiler/PluginProtos$CodeGeneratorRequest:bitField0_	I
    //   290: goto -272 -> 18
    //   293: iload_3
    //   294: istore 4
    //   296: iload_3
    //   297: istore 6
    //   299: iload_3
    //   300: istore 7
    //   302: aload_1
    //   303: invokevirtual 129	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   306: astore 9
    //   308: iload_3
    //   309: istore 4
    //   311: iload_3
    //   312: istore 6
    //   314: iload_3
    //   315: istore 7
    //   317: aload_0
    //   318: iconst_1
    //   319: aload_0
    //   320: getfield 107	com/google/protobuf/compiler/PluginProtos$CodeGeneratorRequest:bitField0_	I
    //   323: ior
    //   324: putfield 107	com/google/protobuf/compiler/PluginProtos$CodeGeneratorRequest:bitField0_	I
    //   327: iload_3
    //   328: istore 4
    //   330: iload_3
    //   331: istore 6
    //   333: iload_3
    //   334: istore 7
    //   336: aload_0
    //   337: aload 9
    //   339: putfield 63	com/google/protobuf/compiler/PluginProtos$CodeGeneratorRequest:parameter_	Ljava/lang/Object;
    //   342: goto -324 -> 18
    //   345: iload_3
    //   346: istore 4
    //   348: iload_3
    //   349: istore 6
    //   351: iload_3
    //   352: istore 7
    //   354: aload_1
    //   355: invokevirtual 129	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   358: astore 9
    //   360: iload_3
    //   361: istore 5
    //   363: iload_3
    //   364: iconst_1
    //   365: iand
    //   366: ifne +28 -> 394
    //   369: iload_3
    //   370: istore 4
    //   372: iload_3
    //   373: istore 6
    //   375: iload_3
    //   376: istore 7
    //   378: aload_0
    //   379: new 55	com/google/protobuf/LazyStringArrayList
    //   382: dup
    //   383: invokespecial 130	com/google/protobuf/LazyStringArrayList:<init>	()V
    //   386: putfield 59	com/google/protobuf/compiler/PluginProtos$CodeGeneratorRequest:fileToGenerate_	Lcom/google/protobuf/LazyStringList;
    //   389: iload_3
    //   390: iconst_1
    //   391: ior
    //   392: istore 5
    //   394: iload 5
    //   396: istore 4
    //   398: iload 5
    //   400: istore 6
    //   402: iload 5
    //   404: istore 7
    //   406: aload_0
    //   407: getfield 59	com/google/protobuf/compiler/PluginProtos$CodeGeneratorRequest:fileToGenerate_	Lcom/google/protobuf/LazyStringList;
    //   410: aload 9
    //   412: invokeinterface 135 2 0
    //   417: iload 5
    //   419: istore_3
    //   420: goto -402 -> 18
    //   423: iconst_1
    //   424: istore 8
    //   426: goto -408 -> 18
    //   429: astore_1
    //   430: goto +32 -> 462
    //   433: astore_1
    //   434: iload 6
    //   436: istore 4
    //   438: new 74	com/google/protobuf/InvalidProtocolBufferException
    //   441: dup
    //   442: aload_1
    //   443: invokespecial 138	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/io/IOException;)V
    //   446: aload_0
    //   447: invokevirtual 142	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   450: athrow
    //   451: astore_1
    //   452: iload 7
    //   454: istore 4
    //   456: aload_1
    //   457: aload_0
    //   458: invokevirtual 142	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   461: athrow
    //   462: iload 4
    //   464: iconst_1
    //   465: iand
    //   466: ifeq +16 -> 482
    //   469: aload_0
    //   470: aload_0
    //   471: getfield 59	com/google/protobuf/compiler/PluginProtos$CodeGeneratorRequest:fileToGenerate_	Lcom/google/protobuf/LazyStringList;
    //   474: invokeinterface 146 1 0
    //   479: putfield 59	com/google/protobuf/compiler/PluginProtos$CodeGeneratorRequest:fileToGenerate_	Lcom/google/protobuf/LazyStringList;
    //   482: iload 4
    //   484: iconst_4
    //   485: iand
    //   486: ifeq +14 -> 500
    //   489: aload_0
    //   490: aload_0
    //   491: getfield 71	com/google/protobuf/compiler/PluginProtos$CodeGeneratorRequest:protoFile_	Ljava/util/List;
    //   494: invokestatic 150	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   497: putfield 71	com/google/protobuf/compiler/PluginProtos$CodeGeneratorRequest:protoFile_	Ljava/util/List;
    //   500: aload_0
    //   501: aload 10
    //   503: invokevirtual 155	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   506: putfield 159	com/google/protobuf/compiler/PluginProtos$CodeGeneratorRequest:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   509: aload_0
    //   510: invokevirtual 162	com/google/protobuf/compiler/PluginProtos$CodeGeneratorRequest:makeExtensionsImmutable	()V
    //   513: aload_1
    //   514: athrow
    //   515: iload_3
    //   516: iconst_1
    //   517: iand
    //   518: ifeq +16 -> 534
    //   521: aload_0
    //   522: aload_0
    //   523: getfield 59	com/google/protobuf/compiler/PluginProtos$CodeGeneratorRequest:fileToGenerate_	Lcom/google/protobuf/LazyStringList;
    //   526: invokeinterface 146 1 0
    //   531: putfield 59	com/google/protobuf/compiler/PluginProtos$CodeGeneratorRequest:fileToGenerate_	Lcom/google/protobuf/LazyStringList;
    //   534: iload_3
    //   535: iconst_4
    //   536: iand
    //   537: ifeq +14 -> 551
    //   540: aload_0
    //   541: aload_0
    //   542: getfield 71	com/google/protobuf/compiler/PluginProtos$CodeGeneratorRequest:protoFile_	Ljava/util/List;
    //   545: invokestatic 150	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   548: putfield 71	com/google/protobuf/compiler/PluginProtos$CodeGeneratorRequest:protoFile_	Ljava/util/List;
    //   551: aload_0
    //   552: aload 10
    //   554: invokevirtual 155	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   557: putfield 159	com/google/protobuf/compiler/PluginProtos$CodeGeneratorRequest:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   560: aload_0
    //   561: invokevirtual 162	com/google/protobuf/compiler/PluginProtos$CodeGeneratorRequest:makeExtensionsImmutable	()V
    //   564: return
    //   565: new 164	java/lang/NullPointerException
    //   568: dup
    //   569: invokespecial 165	java/lang/NullPointerException:<init>	()V
    //   572: astore_1
    //   573: goto +5 -> 578
    //   576: aload_1
    //   577: athrow
    //   578: goto -2 -> 576
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	581	0	this	CodeGeneratorRequest
    //   0	581	1	paramCodedInputStream	CodedInputStream
    //   0	581	2	paramExtensionRegistryLite	ExtensionRegistryLite
    //   17	520	3	i	int
    //   24	462	4	j	int
    //   36	382	5	k	int
    //   27	408	6	m	int
    //   30	423	7	n	int
    //   14	411	8	i1	int
    //   167	244	9	localObject	Object
    //   11	542	10	localBuilder	com.google.protobuf.UnknownFieldSet.Builder
    // Exception table:
    //   from	to	target	type
    //   32	38	429	finally
    //   80	93	429	finally
    //   114	125	429	finally
    //   142	160	429	finally
    //   178	187	429	finally
    //   196	205	429	finally
    //   214	229	429	finally
    //   243	253	429	finally
    //   262	271	429	finally
    //   280	290	429	finally
    //   302	308	429	finally
    //   317	327	429	finally
    //   336	342	429	finally
    //   354	360	429	finally
    //   378	389	429	finally
    //   406	417	429	finally
    //   438	451	429	finally
    //   456	462	429	finally
    //   32	38	433	java/io/IOException
    //   80	93	433	java/io/IOException
    //   114	125	433	java/io/IOException
    //   142	160	433	java/io/IOException
    //   178	187	433	java/io/IOException
    //   196	205	433	java/io/IOException
    //   214	229	433	java/io/IOException
    //   243	253	433	java/io/IOException
    //   262	271	433	java/io/IOException
    //   280	290	433	java/io/IOException
    //   302	308	433	java/io/IOException
    //   317	327	433	java/io/IOException
    //   336	342	433	java/io/IOException
    //   354	360	433	java/io/IOException
    //   378	389	433	java/io/IOException
    //   406	417	433	java/io/IOException
    //   32	38	451	com/google/protobuf/InvalidProtocolBufferException
    //   80	93	451	com/google/protobuf/InvalidProtocolBufferException
    //   114	125	451	com/google/protobuf/InvalidProtocolBufferException
    //   142	160	451	com/google/protobuf/InvalidProtocolBufferException
    //   178	187	451	com/google/protobuf/InvalidProtocolBufferException
    //   196	205	451	com/google/protobuf/InvalidProtocolBufferException
    //   214	229	451	com/google/protobuf/InvalidProtocolBufferException
    //   243	253	451	com/google/protobuf/InvalidProtocolBufferException
    //   262	271	451	com/google/protobuf/InvalidProtocolBufferException
    //   280	290	451	com/google/protobuf/InvalidProtocolBufferException
    //   302	308	451	com/google/protobuf/InvalidProtocolBufferException
    //   317	327	451	com/google/protobuf/InvalidProtocolBufferException
    //   336	342	451	com/google/protobuf/InvalidProtocolBufferException
    //   354	360	451	com/google/protobuf/InvalidProtocolBufferException
    //   378	389	451	com/google/protobuf/InvalidProtocolBufferException
    //   406	417	451	com/google/protobuf/InvalidProtocolBufferException
  }
  
  private PluginProtos$CodeGeneratorRequest(GeneratedMessageV3.Builder<?> paramBuilder)
  {
    super(paramBuilder);
  }
  
  public static CodeGeneratorRequest getDefaultInstance()
  {
    return a;
  }
  
  public static final Descriptors.Descriptor getDescriptor()
  {
    return PluginProtos.d();
  }
  
  public static PluginProtos.CodeGeneratorRequest.Builder newBuilder()
  {
    return a.toBuilder();
  }
  
  public static PluginProtos.CodeGeneratorRequest.Builder newBuilder(CodeGeneratorRequest paramCodeGeneratorRequest)
  {
    return a.toBuilder().a(paramCodeGeneratorRequest);
  }
  
  public static CodeGeneratorRequest parseDelimitedFrom(InputStream paramInputStream)
  {
    return (CodeGeneratorRequest)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream);
  }
  
  public static CodeGeneratorRequest parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (CodeGeneratorRequest)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static CodeGeneratorRequest parseFrom(ByteString paramByteString)
  {
    return (CodeGeneratorRequest)PARSER.parseFrom(paramByteString);
  }
  
  public static CodeGeneratorRequest parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (CodeGeneratorRequest)PARSER.parseFrom(paramByteString, paramExtensionRegistryLite);
  }
  
  public static CodeGeneratorRequest parseFrom(CodedInputStream paramCodedInputStream)
  {
    return (CodeGeneratorRequest)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream);
  }
  
  public static CodeGeneratorRequest parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (CodeGeneratorRequest)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static CodeGeneratorRequest parseFrom(InputStream paramInputStream)
  {
    return (CodeGeneratorRequest)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream);
  }
  
  public static CodeGeneratorRequest parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (CodeGeneratorRequest)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static CodeGeneratorRequest parseFrom(ByteBuffer paramByteBuffer)
  {
    return (CodeGeneratorRequest)PARSER.parseFrom(paramByteBuffer);
  }
  
  public static CodeGeneratorRequest parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (CodeGeneratorRequest)PARSER.parseFrom(paramByteBuffer, paramExtensionRegistryLite);
  }
  
  public static CodeGeneratorRequest parseFrom(byte[] paramArrayOfByte)
  {
    return (CodeGeneratorRequest)PARSER.parseFrom(paramArrayOfByte);
  }
  
  public static CodeGeneratorRequest parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (CodeGeneratorRequest)PARSER.parseFrom(paramArrayOfByte, paramExtensionRegistryLite);
  }
  
  public static Parser<CodeGeneratorRequest> parser()
  {
    return PARSER;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof CodeGeneratorRequest)) {
      return super.equals(paramObject);
    }
    paramObject = (CodeGeneratorRequest)paramObject;
    if (!getFileToGenerateList().equals(paramObject.getFileToGenerateList())) {
      return false;
    }
    if (hasParameter() != paramObject.hasParameter()) {
      return false;
    }
    if ((hasParameter()) && (!getParameter().equals(paramObject.getParameter()))) {
      return false;
    }
    if (!getProtoFileList().equals(paramObject.getProtoFileList())) {
      return false;
    }
    if (hasCompilerVersion() != paramObject.hasCompilerVersion()) {
      return false;
    }
    if ((hasCompilerVersion()) && (!getCompilerVersion().equals(paramObject.getCompilerVersion()))) {
      return false;
    }
    return this.unknownFields.equals(paramObject.unknownFields);
  }
  
  public PluginProtos.Version getCompilerVersion()
  {
    PluginProtos.Version localVersion2 = this.compilerVersion_;
    PluginProtos.Version localVersion1 = localVersion2;
    if (localVersion2 == null) {
      localVersion1 = PluginProtos.Version.getDefaultInstance();
    }
    return localVersion1;
  }
  
  public PluginProtos.VersionOrBuilder getCompilerVersionOrBuilder()
  {
    PluginProtos.Version localVersion2 = this.compilerVersion_;
    PluginProtos.Version localVersion1 = localVersion2;
    if (localVersion2 == null) {
      localVersion1 = PluginProtos.Version.getDefaultInstance();
    }
    return localVersion1;
  }
  
  public CodeGeneratorRequest getDefaultInstanceForType()
  {
    return a;
  }
  
  public String getFileToGenerate(int paramInt)
  {
    return (String)this.fileToGenerate_.get(paramInt);
  }
  
  public ByteString getFileToGenerateBytes(int paramInt)
  {
    return this.fileToGenerate_.f(paramInt);
  }
  
  public int getFileToGenerateCount()
  {
    return this.fileToGenerate_.size();
  }
  
  public ProtocolStringList getFileToGenerateList()
  {
    return this.fileToGenerate_;
  }
  
  public String getParameter()
  {
    Object localObject = this.parameter_;
    if ((localObject instanceof String)) {
      return (String)localObject;
    }
    localObject = (ByteString)localObject;
    String str = ((ByteString)localObject).toStringUtf8();
    if (((ByteString)localObject).isValidUtf8()) {
      this.parameter_ = str;
    }
    return str;
  }
  
  public ByteString getParameterBytes()
  {
    Object localObject = this.parameter_;
    if ((localObject instanceof String))
    {
      localObject = ByteString.copyFromUtf8((String)localObject);
      this.parameter_ = localObject;
      return localObject;
    }
    return (ByteString)localObject;
  }
  
  public Parser<CodeGeneratorRequest> getParserForType()
  {
    return PARSER;
  }
  
  public DescriptorProtos.FileDescriptorProto getProtoFile(int paramInt)
  {
    return (DescriptorProtos.FileDescriptorProto)this.protoFile_.get(paramInt);
  }
  
  public int getProtoFileCount()
  {
    return this.protoFile_.size();
  }
  
  public List<DescriptorProtos.FileDescriptorProto> getProtoFileList()
  {
    return this.protoFile_;
  }
  
  public DescriptorProtos.FileDescriptorProtoOrBuilder getProtoFileOrBuilder(int paramInt)
  {
    return (DescriptorProtos.FileDescriptorProtoOrBuilder)this.protoFile_.get(paramInt);
  }
  
  public List<? extends DescriptorProtos.FileDescriptorProtoOrBuilder> getProtoFileOrBuilderList()
  {
    return this.protoFile_;
  }
  
  public int getSerializedSize()
  {
    int i = this.memoizedSize;
    if (i != -1) {
      return i;
    }
    int m = 0;
    i = 0;
    int j = 0;
    while (i < this.fileToGenerate_.size())
    {
      j += computeStringSizeNoTag(this.fileToGenerate_.d(i));
      i += 1;
    }
    j = j + 0 + getFileToGenerateList().size() * 1;
    i = j;
    if ((this.bitField0_ & 0x1) != 0) {
      i = j + GeneratedMessageV3.computeStringSize(2, this.parameter_);
    }
    int k = m;
    j = i;
    if ((this.bitField0_ & 0x2) != 0)
    {
      j = i + CodedOutputStream.c(3, getCompilerVersion());
      k = m;
    }
    while (k < this.protoFile_.size())
    {
      j += CodedOutputStream.c(15, (MessageLite)this.protoFile_.get(k));
      k += 1;
    }
    i = j + this.unknownFields.getSerializedSize();
    this.memoizedSize = i;
    return i;
  }
  
  public final UnknownFieldSet getUnknownFields()
  {
    return this.unknownFields;
  }
  
  public boolean hasCompilerVersion()
  {
    return (this.bitField0_ & 0x2) != 0;
  }
  
  public boolean hasParameter()
  {
    return (this.bitField0_ & 0x1) != 0;
  }
  
  public int hashCode()
  {
    if (this.memoizedHashCode != 0) {
      return this.memoizedHashCode;
    }
    int j = 779 + getDescriptor().hashCode();
    int i = j;
    if (getFileToGenerateCount() > 0) {
      i = (j * 37 + 1) * 53 + getFileToGenerateList().hashCode();
    }
    j = i;
    if (hasParameter()) {
      j = (i * 37 + 2) * 53 + getParameter().hashCode();
    }
    i = j;
    if (getProtoFileCount() > 0) {
      i = (j * 37 + 15) * 53 + getProtoFileList().hashCode();
    }
    j = i;
    if (hasCompilerVersion()) {
      j = (i * 37 + 3) * 53 + getCompilerVersion().hashCode();
    }
    i = j * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    return i;
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return PluginProtos.e().a(CodeGeneratorRequest.class, PluginProtos.CodeGeneratorRequest.Builder.class);
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
    while (i < getProtoFileCount())
    {
      if (!getProtoFile(i).isInitialized())
      {
        this.memoizedIsInitialized = 0;
        return false;
      }
      i += 1;
    }
    this.memoizedIsInitialized = 1;
    return true;
  }
  
  public PluginProtos.CodeGeneratorRequest.Builder newBuilderForType()
  {
    return newBuilder();
  }
  
  protected PluginProtos.CodeGeneratorRequest.Builder newBuilderForType(GeneratedMessageV3.BuilderParent paramBuilderParent)
  {
    return new PluginProtos.CodeGeneratorRequest.Builder(paramBuilderParent, null);
  }
  
  protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter paramUnusedPrivateParameter)
  {
    return new CodeGeneratorRequest();
  }
  
  public PluginProtos.CodeGeneratorRequest.Builder toBuilder()
  {
    if (this == a) {
      return new PluginProtos.CodeGeneratorRequest.Builder(null);
    }
    return new PluginProtos.CodeGeneratorRequest.Builder(null).a(this);
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
  {
    int j = 0;
    int i = 0;
    while (i < this.fileToGenerate_.size())
    {
      GeneratedMessageV3.writeString(paramCodedOutputStream, 1, this.fileToGenerate_.d(i));
      i += 1;
    }
    if ((this.bitField0_ & 0x1) != 0) {
      GeneratedMessageV3.writeString(paramCodedOutputStream, 2, this.parameter_);
    }
    i = j;
    if ((this.bitField0_ & 0x2) != 0)
    {
      paramCodedOutputStream.a(3, getCompilerVersion());
      i = j;
    }
    while (i < this.protoFile_.size())
    {
      paramCodedOutputStream.a(15, (MessageLite)this.protoFile_.get(i));
      i += 1;
    }
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequest
 * JD-Core Version:    0.7.0.1
 */