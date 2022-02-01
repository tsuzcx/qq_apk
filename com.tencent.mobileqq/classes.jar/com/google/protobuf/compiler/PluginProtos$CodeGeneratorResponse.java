package com.google.protobuf.compiler;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.GeneratedMessageV3.Builder;
import com.google.protobuf.GeneratedMessageV3.BuilderParent;
import com.google.protobuf.GeneratedMessageV3.FieldAccessorTable;
import com.google.protobuf.GeneratedMessageV3.UnusedPrivateParameter;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

public final class PluginProtos$CodeGeneratorResponse
  extends GeneratedMessageV3
  implements PluginProtos.CodeGeneratorResponseOrBuilder
{
  public static final int ERROR_FIELD_NUMBER = 1;
  public static final int FILE_FIELD_NUMBER = 15;
  @Deprecated
  public static final Parser<CodeGeneratorResponse> PARSER = new PluginProtos.CodeGeneratorResponse.1();
  private static final CodeGeneratorResponse a = new CodeGeneratorResponse();
  private static final long serialVersionUID = 0L;
  private int bitField0_;
  private volatile Object error_;
  private List<PluginProtos.CodeGeneratorResponse.File> file_;
  private byte memoizedIsInitialized = -1;
  
  private PluginProtos$CodeGeneratorResponse()
  {
    this.error_ = "";
    this.file_ = Collections.emptyList();
  }
  
  /* Error */
  private PluginProtos$CodeGeneratorResponse(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 34	com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse:<init>	()V
    //   4: aload_2
    //   5: ifnull +302 -> 307
    //   8: invokestatic 67	com/google/protobuf/UnknownFieldSet:a	()Lcom/google/protobuf/UnknownFieldSet$Builder;
    //   11: astore 9
    //   13: iconst_0
    //   14: istore 8
    //   16: iconst_0
    //   17: istore_3
    //   18: iload 8
    //   20: ifne +256 -> 276
    //   23: iload_3
    //   24: istore 5
    //   26: iload_3
    //   27: istore 6
    //   29: iload_3
    //   30: istore 7
    //   32: aload_1
    //   33: invokevirtual 72	com/google/protobuf/CodedInputStream:a	()I
    //   36: istore 4
    //   38: iload 4
    //   40: ifeq +164 -> 204
    //   43: iload 4
    //   45: bipush 10
    //   47: if_icmpeq +105 -> 152
    //   50: iload 4
    //   52: bipush 122
    //   54: if_icmpeq +28 -> 82
    //   57: iload_3
    //   58: istore 5
    //   60: iload_3
    //   61: istore 6
    //   63: iload_3
    //   64: istore 7
    //   66: aload_0
    //   67: aload_1
    //   68: aload 9
    //   70: aload_2
    //   71: iload 4
    //   73: invokevirtual 76	com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse:parseUnknownField	(Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/UnknownFieldSet$Builder;Lcom/google/protobuf/ExtensionRegistryLite;I)Z
    //   76: ifne -58 -> 18
    //   79: goto +125 -> 204
    //   82: iload_3
    //   83: istore 4
    //   85: iload_3
    //   86: iconst_2
    //   87: iand
    //   88: ifne +28 -> 116
    //   91: iload_3
    //   92: istore 5
    //   94: iload_3
    //   95: istore 6
    //   97: iload_3
    //   98: istore 7
    //   100: aload_0
    //   101: new 78	java/util/ArrayList
    //   104: dup
    //   105: invokespecial 79	java/util/ArrayList:<init>	()V
    //   108: putfield 57	com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse:file_	Ljava/util/List;
    //   111: iload_3
    //   112: iconst_2
    //   113: ior
    //   114: istore 4
    //   116: iload 4
    //   118: istore 5
    //   120: iload 4
    //   122: istore 6
    //   124: iload 4
    //   126: istore 7
    //   128: aload_0
    //   129: getfield 57	com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse:file_	Ljava/util/List;
    //   132: aload_1
    //   133: getstatic 82	com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File:PARSER	Lcom/google/protobuf/Parser;
    //   136: aload_2
    //   137: invokevirtual 85	com/google/protobuf/CodedInputStream:a	(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   140: invokeinterface 91 2 0
    //   145: pop
    //   146: iload 4
    //   148: istore_3
    //   149: goto -131 -> 18
    //   152: iload_3
    //   153: istore 5
    //   155: iload_3
    //   156: istore 6
    //   158: iload_3
    //   159: istore 7
    //   161: aload_1
    //   162: invokevirtual 95	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   165: astore 10
    //   167: iload_3
    //   168: istore 5
    //   170: iload_3
    //   171: istore 6
    //   173: iload_3
    //   174: istore 7
    //   176: aload_0
    //   177: iconst_1
    //   178: aload_0
    //   179: getfield 97	com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse:bitField0_	I
    //   182: ior
    //   183: putfield 97	com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse:bitField0_	I
    //   186: iload_3
    //   187: istore 5
    //   189: iload_3
    //   190: istore 6
    //   192: iload_3
    //   193: istore 7
    //   195: aload_0
    //   196: aload 10
    //   198: putfield 49	com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse:error_	Ljava/lang/Object;
    //   201: goto -183 -> 18
    //   204: iconst_1
    //   205: istore 8
    //   207: goto -189 -> 18
    //   210: astore_1
    //   211: goto +32 -> 243
    //   214: astore_1
    //   215: iload 6
    //   217: istore 5
    //   219: new 60	com/google/protobuf/InvalidProtocolBufferException
    //   222: dup
    //   223: aload_1
    //   224: invokespecial 100	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/io/IOException;)V
    //   227: aload_0
    //   228: invokevirtual 104	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   231: athrow
    //   232: astore_1
    //   233: iload 7
    //   235: istore 5
    //   237: aload_1
    //   238: aload_0
    //   239: invokevirtual 104	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   242: athrow
    //   243: iload 5
    //   245: iconst_2
    //   246: iand
    //   247: ifeq +14 -> 261
    //   250: aload_0
    //   251: aload_0
    //   252: getfield 57	com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse:file_	Ljava/util/List;
    //   255: invokestatic 108	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   258: putfield 57	com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse:file_	Ljava/util/List;
    //   261: aload_0
    //   262: aload 9
    //   264: invokevirtual 113	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   267: putfield 117	com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   270: aload_0
    //   271: invokevirtual 120	com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse:makeExtensionsImmutable	()V
    //   274: aload_1
    //   275: athrow
    //   276: iload_3
    //   277: iconst_2
    //   278: iand
    //   279: ifeq +14 -> 293
    //   282: aload_0
    //   283: aload_0
    //   284: getfield 57	com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse:file_	Ljava/util/List;
    //   287: invokestatic 108	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   290: putfield 57	com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse:file_	Ljava/util/List;
    //   293: aload_0
    //   294: aload 9
    //   296: invokevirtual 113	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   299: putfield 117	com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   302: aload_0
    //   303: invokevirtual 120	com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse:makeExtensionsImmutable	()V
    //   306: return
    //   307: new 122	java/lang/NullPointerException
    //   310: dup
    //   311: invokespecial 123	java/lang/NullPointerException:<init>	()V
    //   314: astore_1
    //   315: goto +5 -> 320
    //   318: aload_1
    //   319: athrow
    //   320: goto -2 -> 318
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	323	0	this	CodeGeneratorResponse
    //   0	323	1	paramCodedInputStream	CodedInputStream
    //   0	323	2	paramExtensionRegistryLite	ExtensionRegistryLite
    //   17	262	3	i	int
    //   36	111	4	j	int
    //   24	223	5	k	int
    //   27	189	6	m	int
    //   30	204	7	n	int
    //   14	192	8	i1	int
    //   11	284	9	localBuilder	com.google.protobuf.UnknownFieldSet.Builder
    //   165	32	10	localByteString	ByteString
    // Exception table:
    //   from	to	target	type
    //   32	38	210	finally
    //   66	79	210	finally
    //   100	111	210	finally
    //   128	146	210	finally
    //   161	167	210	finally
    //   176	186	210	finally
    //   195	201	210	finally
    //   219	232	210	finally
    //   237	243	210	finally
    //   32	38	214	java/io/IOException
    //   66	79	214	java/io/IOException
    //   100	111	214	java/io/IOException
    //   128	146	214	java/io/IOException
    //   161	167	214	java/io/IOException
    //   176	186	214	java/io/IOException
    //   195	201	214	java/io/IOException
    //   32	38	232	com/google/protobuf/InvalidProtocolBufferException
    //   66	79	232	com/google/protobuf/InvalidProtocolBufferException
    //   100	111	232	com/google/protobuf/InvalidProtocolBufferException
    //   128	146	232	com/google/protobuf/InvalidProtocolBufferException
    //   161	167	232	com/google/protobuf/InvalidProtocolBufferException
    //   176	186	232	com/google/protobuf/InvalidProtocolBufferException
    //   195	201	232	com/google/protobuf/InvalidProtocolBufferException
  }
  
  private PluginProtos$CodeGeneratorResponse(GeneratedMessageV3.Builder<?> paramBuilder)
  {
    super(paramBuilder);
  }
  
  public static CodeGeneratorResponse getDefaultInstance()
  {
    return a;
  }
  
  public static final Descriptors.Descriptor getDescriptor()
  {
    return PluginProtos.f();
  }
  
  public static PluginProtos.CodeGeneratorResponse.Builder newBuilder()
  {
    return a.toBuilder();
  }
  
  public static PluginProtos.CodeGeneratorResponse.Builder newBuilder(CodeGeneratorResponse paramCodeGeneratorResponse)
  {
    return a.toBuilder().a(paramCodeGeneratorResponse);
  }
  
  public static CodeGeneratorResponse parseDelimitedFrom(InputStream paramInputStream)
  {
    return (CodeGeneratorResponse)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream);
  }
  
  public static CodeGeneratorResponse parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (CodeGeneratorResponse)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static CodeGeneratorResponse parseFrom(ByteString paramByteString)
  {
    return (CodeGeneratorResponse)PARSER.parseFrom(paramByteString);
  }
  
  public static CodeGeneratorResponse parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (CodeGeneratorResponse)PARSER.parseFrom(paramByteString, paramExtensionRegistryLite);
  }
  
  public static CodeGeneratorResponse parseFrom(CodedInputStream paramCodedInputStream)
  {
    return (CodeGeneratorResponse)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream);
  }
  
  public static CodeGeneratorResponse parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (CodeGeneratorResponse)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static CodeGeneratorResponse parseFrom(InputStream paramInputStream)
  {
    return (CodeGeneratorResponse)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream);
  }
  
  public static CodeGeneratorResponse parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (CodeGeneratorResponse)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static CodeGeneratorResponse parseFrom(ByteBuffer paramByteBuffer)
  {
    return (CodeGeneratorResponse)PARSER.parseFrom(paramByteBuffer);
  }
  
  public static CodeGeneratorResponse parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (CodeGeneratorResponse)PARSER.parseFrom(paramByteBuffer, paramExtensionRegistryLite);
  }
  
  public static CodeGeneratorResponse parseFrom(byte[] paramArrayOfByte)
  {
    return (CodeGeneratorResponse)PARSER.parseFrom(paramArrayOfByte);
  }
  
  public static CodeGeneratorResponse parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (CodeGeneratorResponse)PARSER.parseFrom(paramArrayOfByte, paramExtensionRegistryLite);
  }
  
  public static Parser<CodeGeneratorResponse> parser()
  {
    return PARSER;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof CodeGeneratorResponse)) {
      return super.equals(paramObject);
    }
    paramObject = (CodeGeneratorResponse)paramObject;
    if (hasError() != paramObject.hasError()) {
      return false;
    }
    if ((hasError()) && (!getError().equals(paramObject.getError()))) {
      return false;
    }
    if (!getFileList().equals(paramObject.getFileList())) {
      return false;
    }
    return this.unknownFields.equals(paramObject.unknownFields);
  }
  
  public CodeGeneratorResponse getDefaultInstanceForType()
  {
    return a;
  }
  
  public String getError()
  {
    Object localObject = this.error_;
    if ((localObject instanceof String)) {
      return (String)localObject;
    }
    localObject = (ByteString)localObject;
    String str = ((ByteString)localObject).toStringUtf8();
    if (((ByteString)localObject).isValidUtf8()) {
      this.error_ = str;
    }
    return str;
  }
  
  public ByteString getErrorBytes()
  {
    Object localObject = this.error_;
    if ((localObject instanceof String))
    {
      localObject = ByteString.copyFromUtf8((String)localObject);
      this.error_ = localObject;
      return localObject;
    }
    return (ByteString)localObject;
  }
  
  public PluginProtos.CodeGeneratorResponse.File getFile(int paramInt)
  {
    return (PluginProtos.CodeGeneratorResponse.File)this.file_.get(paramInt);
  }
  
  public int getFileCount()
  {
    return this.file_.size();
  }
  
  public List<PluginProtos.CodeGeneratorResponse.File> getFileList()
  {
    return this.file_;
  }
  
  public PluginProtos.CodeGeneratorResponse.FileOrBuilder getFileOrBuilder(int paramInt)
  {
    return (PluginProtos.CodeGeneratorResponse.FileOrBuilder)this.file_.get(paramInt);
  }
  
  public List<? extends PluginProtos.CodeGeneratorResponse.FileOrBuilder> getFileOrBuilderList()
  {
    return this.file_;
  }
  
  public Parser<CodeGeneratorResponse> getParserForType()
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
      i = GeneratedMessageV3.computeStringSize(1, this.error_) + 0;
    } else {
      i = 0;
    }
    while (j < this.file_.size())
    {
      i += CodedOutputStream.c(15, (MessageLite)this.file_.get(j));
      j += 1;
    }
    i += this.unknownFields.getSerializedSize();
    this.memoizedSize = i;
    return i;
  }
  
  public final UnknownFieldSet getUnknownFields()
  {
    return this.unknownFields;
  }
  
  public boolean hasError()
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
    if (hasError()) {
      i = (j * 37 + 1) * 53 + getError().hashCode();
    }
    j = i;
    if (getFileCount() > 0) {
      j = (i * 37 + 15) * 53 + getFileList().hashCode();
    }
    i = j * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    return i;
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return PluginProtos.g().a(CodeGeneratorResponse.class, PluginProtos.CodeGeneratorResponse.Builder.class);
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
  
  public PluginProtos.CodeGeneratorResponse.Builder newBuilderForType()
  {
    return newBuilder();
  }
  
  protected PluginProtos.CodeGeneratorResponse.Builder newBuilderForType(GeneratedMessageV3.BuilderParent paramBuilderParent)
  {
    return new PluginProtos.CodeGeneratorResponse.Builder(paramBuilderParent, null);
  }
  
  protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter paramUnusedPrivateParameter)
  {
    return new CodeGeneratorResponse();
  }
  
  public PluginProtos.CodeGeneratorResponse.Builder toBuilder()
  {
    if (this == a) {
      return new PluginProtos.CodeGeneratorResponse.Builder(null);
    }
    return new PluginProtos.CodeGeneratorResponse.Builder(null).a(this);
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
  {
    if ((this.bitField0_ & 0x1) != 0) {
      GeneratedMessageV3.writeString(paramCodedOutputStream, 1, this.error_);
    }
    int i = 0;
    while (i < this.file_.size())
    {
      paramCodedOutputStream.a(15, (MessageLite)this.file_.get(i));
      i += 1;
    }
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse
 * JD-Core Version:    0.7.0.1
 */