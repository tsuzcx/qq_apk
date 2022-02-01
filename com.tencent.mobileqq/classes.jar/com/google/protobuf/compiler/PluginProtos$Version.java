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

public final class PluginProtos$Version
  extends GeneratedMessageV3
  implements PluginProtos.VersionOrBuilder
{
  public static final int MAJOR_FIELD_NUMBER = 1;
  public static final int MINOR_FIELD_NUMBER = 2;
  @Deprecated
  public static final Parser<Version> PARSER = new PluginProtos.Version.1();
  public static final int PATCH_FIELD_NUMBER = 3;
  public static final int SUFFIX_FIELD_NUMBER = 4;
  private static final Version a = new Version();
  private static final long serialVersionUID = 0L;
  private int bitField0_;
  private int major_;
  private byte memoizedIsInitialized = -1;
  private int minor_;
  private int patch_;
  private volatile Object suffix_;
  
  private PluginProtos$Version()
  {
    this.suffix_ = "";
  }
  
  /* Error */
  private PluginProtos$Version(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 38	com/google/protobuf/compiler/PluginProtos$Version:<init>	()V
    //   4: aload_2
    //   5: ifnull +217 -> 222
    //   8: invokestatic 63	com/google/protobuf/UnknownFieldSet:a	()Lcom/google/protobuf/UnknownFieldSet$Builder;
    //   11: astore 5
    //   13: iconst_0
    //   14: istore_3
    //   15: iload_3
    //   16: ifne +192 -> 208
    //   19: aload_1
    //   20: invokevirtual 68	com/google/protobuf/CodedInputStream:a	()I
    //   23: istore 4
    //   25: iload 4
    //   27: ifeq +136 -> 163
    //   30: iload 4
    //   32: bipush 8
    //   34: if_icmpeq +108 -> 142
    //   37: iload 4
    //   39: bipush 16
    //   41: if_icmpeq +80 -> 121
    //   44: iload 4
    //   46: bipush 24
    //   48: if_icmpeq +52 -> 100
    //   51: iload 4
    //   53: bipush 34
    //   55: if_icmpeq +19 -> 74
    //   58: aload_0
    //   59: aload_1
    //   60: aload 5
    //   62: aload_2
    //   63: iload 4
    //   65: invokevirtual 72	com/google/protobuf/compiler/PluginProtos$Version:parseUnknownField	(Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/UnknownFieldSet$Builder;Lcom/google/protobuf/ExtensionRegistryLite;I)Z
    //   68: ifne -53 -> 15
    //   71: goto +92 -> 163
    //   74: aload_1
    //   75: invokevirtual 76	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   78: astore 6
    //   80: aload_0
    //   81: aload_0
    //   82: getfield 78	com/google/protobuf/compiler/PluginProtos$Version:bitField0_	I
    //   85: bipush 8
    //   87: ior
    //   88: putfield 78	com/google/protobuf/compiler/PluginProtos$Version:bitField0_	I
    //   91: aload_0
    //   92: aload 6
    //   94: putfield 53	com/google/protobuf/compiler/PluginProtos$Version:suffix_	Ljava/lang/Object;
    //   97: goto -82 -> 15
    //   100: aload_0
    //   101: aload_0
    //   102: getfield 78	com/google/protobuf/compiler/PluginProtos$Version:bitField0_	I
    //   105: iconst_4
    //   106: ior
    //   107: putfield 78	com/google/protobuf/compiler/PluginProtos$Version:bitField0_	I
    //   110: aload_0
    //   111: aload_1
    //   112: invokevirtual 81	com/google/protobuf/CodedInputStream:f	()I
    //   115: putfield 83	com/google/protobuf/compiler/PluginProtos$Version:patch_	I
    //   118: goto -103 -> 15
    //   121: aload_0
    //   122: aload_0
    //   123: getfield 78	com/google/protobuf/compiler/PluginProtos$Version:bitField0_	I
    //   126: iconst_2
    //   127: ior
    //   128: putfield 78	com/google/protobuf/compiler/PluginProtos$Version:bitField0_	I
    //   131: aload_0
    //   132: aload_1
    //   133: invokevirtual 81	com/google/protobuf/CodedInputStream:f	()I
    //   136: putfield 85	com/google/protobuf/compiler/PluginProtos$Version:minor_	I
    //   139: goto -124 -> 15
    //   142: aload_0
    //   143: aload_0
    //   144: getfield 78	com/google/protobuf/compiler/PluginProtos$Version:bitField0_	I
    //   147: iconst_1
    //   148: ior
    //   149: putfield 78	com/google/protobuf/compiler/PluginProtos$Version:bitField0_	I
    //   152: aload_0
    //   153: aload_1
    //   154: invokevirtual 81	com/google/protobuf/CodedInputStream:f	()I
    //   157: putfield 87	com/google/protobuf/compiler/PluginProtos$Version:major_	I
    //   160: goto -145 -> 15
    //   163: iconst_1
    //   164: istore_3
    //   165: goto -150 -> 15
    //   168: astore_1
    //   169: goto +24 -> 193
    //   172: astore_1
    //   173: new 56	com/google/protobuf/InvalidProtocolBufferException
    //   176: dup
    //   177: aload_1
    //   178: invokespecial 90	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/io/IOException;)V
    //   181: aload_0
    //   182: invokevirtual 94	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   185: athrow
    //   186: astore_1
    //   187: aload_1
    //   188: aload_0
    //   189: invokevirtual 94	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   192: athrow
    //   193: aload_0
    //   194: aload 5
    //   196: invokevirtual 99	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   199: putfield 103	com/google/protobuf/compiler/PluginProtos$Version:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   202: aload_0
    //   203: invokevirtual 106	com/google/protobuf/compiler/PluginProtos$Version:makeExtensionsImmutable	()V
    //   206: aload_1
    //   207: athrow
    //   208: aload_0
    //   209: aload 5
    //   211: invokevirtual 99	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   214: putfield 103	com/google/protobuf/compiler/PluginProtos$Version:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   217: aload_0
    //   218: invokevirtual 106	com/google/protobuf/compiler/PluginProtos$Version:makeExtensionsImmutable	()V
    //   221: return
    //   222: new 108	java/lang/NullPointerException
    //   225: dup
    //   226: invokespecial 109	java/lang/NullPointerException:<init>	()V
    //   229: astore_1
    //   230: goto +5 -> 235
    //   233: aload_1
    //   234: athrow
    //   235: goto -2 -> 233
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	238	0	this	Version
    //   0	238	1	paramCodedInputStream	CodedInputStream
    //   0	238	2	paramExtensionRegistryLite	ExtensionRegistryLite
    //   14	151	3	i	int
    //   23	41	4	j	int
    //   11	199	5	localBuilder	com.google.protobuf.UnknownFieldSet.Builder
    //   78	15	6	localByteString	ByteString
    // Exception table:
    //   from	to	target	type
    //   19	25	168	finally
    //   58	71	168	finally
    //   74	97	168	finally
    //   100	118	168	finally
    //   121	139	168	finally
    //   142	160	168	finally
    //   173	186	168	finally
    //   187	193	168	finally
    //   19	25	172	java/io/IOException
    //   58	71	172	java/io/IOException
    //   74	97	172	java/io/IOException
    //   100	118	172	java/io/IOException
    //   121	139	172	java/io/IOException
    //   142	160	172	java/io/IOException
    //   19	25	186	com/google/protobuf/InvalidProtocolBufferException
    //   58	71	186	com/google/protobuf/InvalidProtocolBufferException
    //   74	97	186	com/google/protobuf/InvalidProtocolBufferException
    //   100	118	186	com/google/protobuf/InvalidProtocolBufferException
    //   121	139	186	com/google/protobuf/InvalidProtocolBufferException
    //   142	160	186	com/google/protobuf/InvalidProtocolBufferException
  }
  
  private PluginProtos$Version(GeneratedMessageV3.Builder<?> paramBuilder)
  {
    super(paramBuilder);
  }
  
  public static Version getDefaultInstance()
  {
    return a;
  }
  
  public static final Descriptors.Descriptor getDescriptor()
  {
    return PluginProtos.b();
  }
  
  public static PluginProtos.Version.Builder newBuilder()
  {
    return a.toBuilder();
  }
  
  public static PluginProtos.Version.Builder newBuilder(Version paramVersion)
  {
    return a.toBuilder().a(paramVersion);
  }
  
  public static Version parseDelimitedFrom(InputStream paramInputStream)
  {
    return (Version)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream);
  }
  
  public static Version parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (Version)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Version parseFrom(ByteString paramByteString)
  {
    return (Version)PARSER.parseFrom(paramByteString);
  }
  
  public static Version parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (Version)PARSER.parseFrom(paramByteString, paramExtensionRegistryLite);
  }
  
  public static Version parseFrom(CodedInputStream paramCodedInputStream)
  {
    return (Version)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream);
  }
  
  public static Version parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (Version)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static Version parseFrom(InputStream paramInputStream)
  {
    return (Version)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream);
  }
  
  public static Version parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (Version)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Version parseFrom(ByteBuffer paramByteBuffer)
  {
    return (Version)PARSER.parseFrom(paramByteBuffer);
  }
  
  public static Version parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (Version)PARSER.parseFrom(paramByteBuffer, paramExtensionRegistryLite);
  }
  
  public static Version parseFrom(byte[] paramArrayOfByte)
  {
    return (Version)PARSER.parseFrom(paramArrayOfByte);
  }
  
  public static Version parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (Version)PARSER.parseFrom(paramArrayOfByte, paramExtensionRegistryLite);
  }
  
  public static Parser<Version> parser()
  {
    return PARSER;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof Version)) {
      return super.equals(paramObject);
    }
    paramObject = (Version)paramObject;
    if (hasMajor() != paramObject.hasMajor()) {
      return false;
    }
    if ((hasMajor()) && (getMajor() != paramObject.getMajor())) {
      return false;
    }
    if (hasMinor() != paramObject.hasMinor()) {
      return false;
    }
    if ((hasMinor()) && (getMinor() != paramObject.getMinor())) {
      return false;
    }
    if (hasPatch() != paramObject.hasPatch()) {
      return false;
    }
    if ((hasPatch()) && (getPatch() != paramObject.getPatch())) {
      return false;
    }
    if (hasSuffix() != paramObject.hasSuffix()) {
      return false;
    }
    if ((hasSuffix()) && (!getSuffix().equals(paramObject.getSuffix()))) {
      return false;
    }
    return this.unknownFields.equals(paramObject.unknownFields);
  }
  
  public Version getDefaultInstanceForType()
  {
    return a;
  }
  
  public int getMajor()
  {
    return this.major_;
  }
  
  public int getMinor()
  {
    return this.minor_;
  }
  
  public Parser<Version> getParserForType()
  {
    return PARSER;
  }
  
  public int getPatch()
  {
    return this.patch_;
  }
  
  public int getSerializedSize()
  {
    int i = this.memoizedSize;
    if (i != -1) {
      return i;
    }
    int j = 0;
    if ((this.bitField0_ & 0x1) != 0) {
      j = 0 + CodedOutputStream.h(1, this.major_);
    }
    i = j;
    if ((this.bitField0_ & 0x2) != 0) {
      i = j + CodedOutputStream.h(2, this.minor_);
    }
    j = i;
    if ((this.bitField0_ & 0x4) != 0) {
      j = i + CodedOutputStream.h(3, this.patch_);
    }
    i = j;
    if ((this.bitField0_ & 0x8) != 0) {
      i = j + GeneratedMessageV3.computeStringSize(4, this.suffix_);
    }
    i += this.unknownFields.getSerializedSize();
    this.memoizedSize = i;
    return i;
  }
  
  public String getSuffix()
  {
    Object localObject = this.suffix_;
    if ((localObject instanceof String)) {
      return (String)localObject;
    }
    localObject = (ByteString)localObject;
    String str = ((ByteString)localObject).toStringUtf8();
    if (((ByteString)localObject).isValidUtf8()) {
      this.suffix_ = str;
    }
    return str;
  }
  
  public ByteString getSuffixBytes()
  {
    Object localObject = this.suffix_;
    if ((localObject instanceof String))
    {
      localObject = ByteString.copyFromUtf8((String)localObject);
      this.suffix_ = localObject;
      return localObject;
    }
    return (ByteString)localObject;
  }
  
  public final UnknownFieldSet getUnknownFields()
  {
    return this.unknownFields;
  }
  
  public boolean hasMajor()
  {
    return (this.bitField0_ & 0x1) != 0;
  }
  
  public boolean hasMinor()
  {
    return (this.bitField0_ & 0x2) != 0;
  }
  
  public boolean hasPatch()
  {
    return (this.bitField0_ & 0x4) != 0;
  }
  
  public boolean hasSuffix()
  {
    return (this.bitField0_ & 0x8) != 0;
  }
  
  public int hashCode()
  {
    if (this.memoizedHashCode != 0) {
      return this.memoizedHashCode;
    }
    int j = 779 + getDescriptor().hashCode();
    int i = j;
    if (hasMajor()) {
      i = (j * 37 + 1) * 53 + getMajor();
    }
    j = i;
    if (hasMinor()) {
      j = (i * 37 + 2) * 53 + getMinor();
    }
    i = j;
    if (hasPatch()) {
      i = (j * 37 + 3) * 53 + getPatch();
    }
    j = i;
    if (hasSuffix()) {
      j = (i * 37 + 4) * 53 + getSuffix().hashCode();
    }
    i = j * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    return i;
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return PluginProtos.c().a(Version.class, PluginProtos.Version.Builder.class);
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
  
  public PluginProtos.Version.Builder newBuilderForType()
  {
    return newBuilder();
  }
  
  protected PluginProtos.Version.Builder newBuilderForType(GeneratedMessageV3.BuilderParent paramBuilderParent)
  {
    return new PluginProtos.Version.Builder(paramBuilderParent, null);
  }
  
  protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter paramUnusedPrivateParameter)
  {
    return new Version();
  }
  
  public PluginProtos.Version.Builder toBuilder()
  {
    if (this == a) {
      return new PluginProtos.Version.Builder(null);
    }
    return new PluginProtos.Version.Builder(null).a(this);
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
  {
    if ((this.bitField0_ & 0x1) != 0) {
      paramCodedOutputStream.b(1, this.major_);
    }
    if ((this.bitField0_ & 0x2) != 0) {
      paramCodedOutputStream.b(2, this.minor_);
    }
    if ((this.bitField0_ & 0x4) != 0) {
      paramCodedOutputStream.b(3, this.patch_);
    }
    if ((this.bitField0_ & 0x8) != 0) {
      GeneratedMessageV3.writeString(paramCodedOutputStream, 4, this.suffix_);
    }
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.compiler.PluginProtos.Version
 * JD-Core Version:    0.7.0.1
 */