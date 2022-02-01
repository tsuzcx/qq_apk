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
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class PluginProtos$CodeGeneratorResponse$File
  extends GeneratedMessageV3
  implements PluginProtos.CodeGeneratorResponse.FileOrBuilder
{
  public static final int CONTENT_FIELD_NUMBER = 15;
  public static final int INSERTION_POINT_FIELD_NUMBER = 2;
  public static final int NAME_FIELD_NUMBER = 1;
  @Deprecated
  public static final Parser<File> PARSER = new PluginProtos.CodeGeneratorResponse.File.1();
  private static final File a = new File();
  private static final long serialVersionUID = 0L;
  private int bitField0_;
  private volatile Object content_;
  private volatile Object insertionPoint_;
  private byte memoizedIsInitialized = -1;
  private volatile Object name_;
  
  private PluginProtos$CodeGeneratorResponse$File()
  {
    this.name_ = "";
    this.insertionPoint_ = "";
    this.content_ = "";
  }
  
  /* Error */
  private PluginProtos$CodeGeneratorResponse$File(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 35	com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File:<init>	()V
    //   4: aload_2
    //   5: ifnull +196 -> 201
    //   8: invokestatic 64	com/google/protobuf/UnknownFieldSet:a	()Lcom/google/protobuf/UnknownFieldSet$Builder;
    //   11: astore 5
    //   13: iconst_0
    //   14: istore_3
    //   15: iload_3
    //   16: ifne +171 -> 187
    //   19: aload_1
    //   20: invokevirtual 69	com/google/protobuf/CodedInputStream:a	()I
    //   23: istore 4
    //   25: iload 4
    //   27: ifeq +115 -> 142
    //   30: iload 4
    //   32: bipush 10
    //   34: if_icmpeq +83 -> 117
    //   37: iload 4
    //   39: bipush 18
    //   41: if_icmpeq +51 -> 92
    //   44: iload 4
    //   46: bipush 122
    //   48: if_icmpeq +19 -> 67
    //   51: aload_0
    //   52: aload_1
    //   53: aload 5
    //   55: aload_2
    //   56: iload 4
    //   58: invokevirtual 73	com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File:parseUnknownField	(Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/UnknownFieldSet$Builder;Lcom/google/protobuf/ExtensionRegistryLite;I)Z
    //   61: ifne -46 -> 15
    //   64: goto +78 -> 142
    //   67: aload_1
    //   68: invokevirtual 77	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   71: astore 6
    //   73: aload_0
    //   74: aload_0
    //   75: getfield 79	com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File:bitField0_	I
    //   78: iconst_4
    //   79: ior
    //   80: putfield 79	com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File:bitField0_	I
    //   83: aload_0
    //   84: aload 6
    //   86: putfield 54	com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File:content_	Ljava/lang/Object;
    //   89: goto -74 -> 15
    //   92: aload_1
    //   93: invokevirtual 77	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   96: astore 6
    //   98: aload_0
    //   99: aload_0
    //   100: getfield 79	com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File:bitField0_	I
    //   103: iconst_2
    //   104: ior
    //   105: putfield 79	com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File:bitField0_	I
    //   108: aload_0
    //   109: aload 6
    //   111: putfield 52	com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File:insertionPoint_	Ljava/lang/Object;
    //   114: goto -99 -> 15
    //   117: aload_1
    //   118: invokevirtual 77	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   121: astore 6
    //   123: aload_0
    //   124: iconst_1
    //   125: aload_0
    //   126: getfield 79	com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File:bitField0_	I
    //   129: ior
    //   130: putfield 79	com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File:bitField0_	I
    //   133: aload_0
    //   134: aload 6
    //   136: putfield 50	com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File:name_	Ljava/lang/Object;
    //   139: goto -124 -> 15
    //   142: iconst_1
    //   143: istore_3
    //   144: goto -129 -> 15
    //   147: astore_1
    //   148: goto +24 -> 172
    //   151: astore_1
    //   152: new 57	com/google/protobuf/InvalidProtocolBufferException
    //   155: dup
    //   156: aload_1
    //   157: invokespecial 82	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/io/IOException;)V
    //   160: aload_0
    //   161: invokevirtual 86	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   164: athrow
    //   165: astore_1
    //   166: aload_1
    //   167: aload_0
    //   168: invokevirtual 86	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   171: athrow
    //   172: aload_0
    //   173: aload 5
    //   175: invokevirtual 91	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   178: putfield 95	com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   181: aload_0
    //   182: invokevirtual 98	com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File:makeExtensionsImmutable	()V
    //   185: aload_1
    //   186: athrow
    //   187: aload_0
    //   188: aload 5
    //   190: invokevirtual 91	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   193: putfield 95	com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   196: aload_0
    //   197: invokevirtual 98	com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File:makeExtensionsImmutable	()V
    //   200: return
    //   201: new 100	java/lang/NullPointerException
    //   204: dup
    //   205: invokespecial 101	java/lang/NullPointerException:<init>	()V
    //   208: astore_1
    //   209: goto +5 -> 214
    //   212: aload_1
    //   213: athrow
    //   214: goto -2 -> 212
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	217	0	this	File
    //   0	217	1	paramCodedInputStream	CodedInputStream
    //   0	217	2	paramExtensionRegistryLite	ExtensionRegistryLite
    //   14	130	3	i	int
    //   23	34	4	j	int
    //   11	178	5	localBuilder	com.google.protobuf.UnknownFieldSet.Builder
    //   71	64	6	localByteString	ByteString
    // Exception table:
    //   from	to	target	type
    //   19	25	147	finally
    //   51	64	147	finally
    //   67	89	147	finally
    //   92	114	147	finally
    //   117	139	147	finally
    //   152	165	147	finally
    //   166	172	147	finally
    //   19	25	151	java/io/IOException
    //   51	64	151	java/io/IOException
    //   67	89	151	java/io/IOException
    //   92	114	151	java/io/IOException
    //   117	139	151	java/io/IOException
    //   19	25	165	com/google/protobuf/InvalidProtocolBufferException
    //   51	64	165	com/google/protobuf/InvalidProtocolBufferException
    //   67	89	165	com/google/protobuf/InvalidProtocolBufferException
    //   92	114	165	com/google/protobuf/InvalidProtocolBufferException
    //   117	139	165	com/google/protobuf/InvalidProtocolBufferException
  }
  
  private PluginProtos$CodeGeneratorResponse$File(GeneratedMessageV3.Builder<?> paramBuilder)
  {
    super(paramBuilder);
  }
  
  public static File getDefaultInstance()
  {
    return a;
  }
  
  public static final Descriptors.Descriptor getDescriptor()
  {
    return PluginProtos.h();
  }
  
  public static PluginProtos.CodeGeneratorResponse.File.Builder newBuilder()
  {
    return a.toBuilder();
  }
  
  public static PluginProtos.CodeGeneratorResponse.File.Builder newBuilder(File paramFile)
  {
    return a.toBuilder().a(paramFile);
  }
  
  public static File parseDelimitedFrom(InputStream paramInputStream)
  {
    return (File)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream);
  }
  
  public static File parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (File)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static File parseFrom(ByteString paramByteString)
  {
    return (File)PARSER.parseFrom(paramByteString);
  }
  
  public static File parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (File)PARSER.parseFrom(paramByteString, paramExtensionRegistryLite);
  }
  
  public static File parseFrom(CodedInputStream paramCodedInputStream)
  {
    return (File)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream);
  }
  
  public static File parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (File)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static File parseFrom(InputStream paramInputStream)
  {
    return (File)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream);
  }
  
  public static File parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (File)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static File parseFrom(ByteBuffer paramByteBuffer)
  {
    return (File)PARSER.parseFrom(paramByteBuffer);
  }
  
  public static File parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (File)PARSER.parseFrom(paramByteBuffer, paramExtensionRegistryLite);
  }
  
  public static File parseFrom(byte[] paramArrayOfByte)
  {
    return (File)PARSER.parseFrom(paramArrayOfByte);
  }
  
  public static File parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (File)PARSER.parseFrom(paramArrayOfByte, paramExtensionRegistryLite);
  }
  
  public static Parser<File> parser()
  {
    return PARSER;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof File)) {
      return super.equals(paramObject);
    }
    paramObject = (File)paramObject;
    if (hasName() != paramObject.hasName()) {
      return false;
    }
    if ((hasName()) && (!getName().equals(paramObject.getName()))) {
      return false;
    }
    if (hasInsertionPoint() != paramObject.hasInsertionPoint()) {
      return false;
    }
    if ((hasInsertionPoint()) && (!getInsertionPoint().equals(paramObject.getInsertionPoint()))) {
      return false;
    }
    if (hasContent() != paramObject.hasContent()) {
      return false;
    }
    if ((hasContent()) && (!getContent().equals(paramObject.getContent()))) {
      return false;
    }
    return this.unknownFields.equals(paramObject.unknownFields);
  }
  
  public String getContent()
  {
    Object localObject = this.content_;
    if ((localObject instanceof String)) {
      return (String)localObject;
    }
    localObject = (ByteString)localObject;
    String str = ((ByteString)localObject).toStringUtf8();
    if (((ByteString)localObject).isValidUtf8()) {
      this.content_ = str;
    }
    return str;
  }
  
  public ByteString getContentBytes()
  {
    Object localObject = this.content_;
    if ((localObject instanceof String))
    {
      localObject = ByteString.copyFromUtf8((String)localObject);
      this.content_ = localObject;
      return localObject;
    }
    return (ByteString)localObject;
  }
  
  public File getDefaultInstanceForType()
  {
    return a;
  }
  
  public String getInsertionPoint()
  {
    Object localObject = this.insertionPoint_;
    if ((localObject instanceof String)) {
      return (String)localObject;
    }
    localObject = (ByteString)localObject;
    String str = ((ByteString)localObject).toStringUtf8();
    if (((ByteString)localObject).isValidUtf8()) {
      this.insertionPoint_ = str;
    }
    return str;
  }
  
  public ByteString getInsertionPointBytes()
  {
    Object localObject = this.insertionPoint_;
    if ((localObject instanceof String))
    {
      localObject = ByteString.copyFromUtf8((String)localObject);
      this.insertionPoint_ = localObject;
      return localObject;
    }
    return (ByteString)localObject;
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
  
  public Parser<File> getParserForType()
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
    if ((this.bitField0_ & 0x2) != 0) {
      i = j + GeneratedMessageV3.computeStringSize(2, this.insertionPoint_);
    }
    j = i;
    if ((this.bitField0_ & 0x4) != 0) {
      j = i + GeneratedMessageV3.computeStringSize(15, this.content_);
    }
    i = j + this.unknownFields.getSerializedSize();
    this.memoizedSize = i;
    return i;
  }
  
  public final UnknownFieldSet getUnknownFields()
  {
    return this.unknownFields;
  }
  
  public boolean hasContent()
  {
    return (this.bitField0_ & 0x4) != 0;
  }
  
  public boolean hasInsertionPoint()
  {
    return (this.bitField0_ & 0x2) != 0;
  }
  
  public boolean hasName()
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
    if (hasName()) {
      i = (j * 37 + 1) * 53 + getName().hashCode();
    }
    j = i;
    if (hasInsertionPoint()) {
      j = (i * 37 + 2) * 53 + getInsertionPoint().hashCode();
    }
    i = j;
    if (hasContent()) {
      i = (j * 37 + 15) * 53 + getContent().hashCode();
    }
    i = i * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    return i;
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return PluginProtos.i().a(File.class, PluginProtos.CodeGeneratorResponse.File.Builder.class);
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
  
  public PluginProtos.CodeGeneratorResponse.File.Builder newBuilderForType()
  {
    return newBuilder();
  }
  
  protected PluginProtos.CodeGeneratorResponse.File.Builder newBuilderForType(GeneratedMessageV3.BuilderParent paramBuilderParent)
  {
    return new PluginProtos.CodeGeneratorResponse.File.Builder(paramBuilderParent, null);
  }
  
  protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter paramUnusedPrivateParameter)
  {
    return new File();
  }
  
  public PluginProtos.CodeGeneratorResponse.File.Builder toBuilder()
  {
    if (this == a) {
      return new PluginProtos.CodeGeneratorResponse.File.Builder(null);
    }
    return new PluginProtos.CodeGeneratorResponse.File.Builder(null).a(this);
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
  {
    if ((this.bitField0_ & 0x1) != 0) {
      GeneratedMessageV3.writeString(paramCodedOutputStream, 1, this.name_);
    }
    if ((this.bitField0_ & 0x2) != 0) {
      GeneratedMessageV3.writeString(paramCodedOutputStream, 2, this.insertionPoint_);
    }
    if ((this.bitField0_ & 0x4) != 0) {
      GeneratedMessageV3.writeString(paramCodedOutputStream, 15, this.content_);
    }
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File
 * JD-Core Version:    0.7.0.1
 */