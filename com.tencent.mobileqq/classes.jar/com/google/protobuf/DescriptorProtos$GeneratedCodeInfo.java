package com.google.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

public final class DescriptorProtos$GeneratedCodeInfo
  extends GeneratedMessageV3
  implements DescriptorProtos.GeneratedCodeInfoOrBuilder
{
  public static final int ANNOTATION_FIELD_NUMBER = 1;
  @Deprecated
  public static final Parser<GeneratedCodeInfo> PARSER = new DescriptorProtos.GeneratedCodeInfo.1();
  private static final GeneratedCodeInfo a = new GeneratedCodeInfo();
  private static final long serialVersionUID = 0L;
  private List<DescriptorProtos.GeneratedCodeInfo.Annotation> annotation_;
  private byte memoizedIsInitialized = -1;
  
  private DescriptorProtos$GeneratedCodeInfo()
  {
    this.annotation_ = Collections.emptyList();
  }
  
  /* Error */
  private DescriptorProtos$GeneratedCodeInfo(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 29	com/google/protobuf/DescriptorProtos$GeneratedCodeInfo:<init>	()V
    //   4: aload_2
    //   5: ifnull +243 -> 248
    //   8: invokestatic 58	com/google/protobuf/UnknownFieldSet:a	()Lcom/google/protobuf/UnknownFieldSet$Builder;
    //   11: astore 9
    //   13: iconst_0
    //   14: istore 8
    //   16: iconst_0
    //   17: istore_3
    //   18: iload 8
    //   20: ifne +197 -> 217
    //   23: iload_3
    //   24: istore 5
    //   26: iload_3
    //   27: istore 6
    //   29: iload_3
    //   30: istore 7
    //   32: aload_1
    //   33: invokevirtual 63	com/google/protobuf/CodedInputStream:a	()I
    //   36: istore 4
    //   38: iload 4
    //   40: ifeq +105 -> 145
    //   43: iload 4
    //   45: bipush 10
    //   47: if_icmpeq +28 -> 75
    //   50: iload_3
    //   51: istore 5
    //   53: iload_3
    //   54: istore 6
    //   56: iload_3
    //   57: istore 7
    //   59: aload_0
    //   60: aload_1
    //   61: aload 9
    //   63: aload_2
    //   64: iload 4
    //   66: invokevirtual 67	com/google/protobuf/DescriptorProtos$GeneratedCodeInfo:parseUnknownField	(Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/UnknownFieldSet$Builder;Lcom/google/protobuf/ExtensionRegistryLite;I)Z
    //   69: ifne -51 -> 18
    //   72: goto +73 -> 145
    //   75: iload_3
    //   76: istore 4
    //   78: iload_3
    //   79: iconst_1
    //   80: iand
    //   81: ifne +28 -> 109
    //   84: iload_3
    //   85: istore 5
    //   87: iload_3
    //   88: istore 6
    //   90: iload_3
    //   91: istore 7
    //   93: aload_0
    //   94: new 69	java/util/ArrayList
    //   97: dup
    //   98: invokespecial 70	java/util/ArrayList:<init>	()V
    //   101: putfield 48	com/google/protobuf/DescriptorProtos$GeneratedCodeInfo:annotation_	Ljava/util/List;
    //   104: iload_3
    //   105: iconst_1
    //   106: ior
    //   107: istore 4
    //   109: iload 4
    //   111: istore 5
    //   113: iload 4
    //   115: istore 6
    //   117: iload 4
    //   119: istore 7
    //   121: aload_0
    //   122: getfield 48	com/google/protobuf/DescriptorProtos$GeneratedCodeInfo:annotation_	Ljava/util/List;
    //   125: aload_1
    //   126: getstatic 73	com/google/protobuf/DescriptorProtos$GeneratedCodeInfo$Annotation:PARSER	Lcom/google/protobuf/Parser;
    //   129: aload_2
    //   130: invokevirtual 76	com/google/protobuf/CodedInputStream:a	(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   133: invokeinterface 82 2 0
    //   138: pop
    //   139: iload 4
    //   141: istore_3
    //   142: goto -124 -> 18
    //   145: iconst_1
    //   146: istore 8
    //   148: goto -130 -> 18
    //   151: astore_1
    //   152: goto +32 -> 184
    //   155: astore_1
    //   156: iload 6
    //   158: istore 5
    //   160: new 51	com/google/protobuf/InvalidProtocolBufferException
    //   163: dup
    //   164: aload_1
    //   165: invokespecial 85	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/io/IOException;)V
    //   168: aload_0
    //   169: invokevirtual 89	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   172: athrow
    //   173: astore_1
    //   174: iload 7
    //   176: istore 5
    //   178: aload_1
    //   179: aload_0
    //   180: invokevirtual 89	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   183: athrow
    //   184: iload 5
    //   186: iconst_1
    //   187: iand
    //   188: ifeq +14 -> 202
    //   191: aload_0
    //   192: aload_0
    //   193: getfield 48	com/google/protobuf/DescriptorProtos$GeneratedCodeInfo:annotation_	Ljava/util/List;
    //   196: invokestatic 93	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   199: putfield 48	com/google/protobuf/DescriptorProtos$GeneratedCodeInfo:annotation_	Ljava/util/List;
    //   202: aload_0
    //   203: aload 9
    //   205: invokevirtual 98	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   208: putfield 102	com/google/protobuf/DescriptorProtos$GeneratedCodeInfo:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   211: aload_0
    //   212: invokevirtual 105	com/google/protobuf/DescriptorProtos$GeneratedCodeInfo:makeExtensionsImmutable	()V
    //   215: aload_1
    //   216: athrow
    //   217: iload_3
    //   218: iconst_1
    //   219: iand
    //   220: ifeq +14 -> 234
    //   223: aload_0
    //   224: aload_0
    //   225: getfield 48	com/google/protobuf/DescriptorProtos$GeneratedCodeInfo:annotation_	Ljava/util/List;
    //   228: invokestatic 93	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   231: putfield 48	com/google/protobuf/DescriptorProtos$GeneratedCodeInfo:annotation_	Ljava/util/List;
    //   234: aload_0
    //   235: aload 9
    //   237: invokevirtual 98	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   240: putfield 102	com/google/protobuf/DescriptorProtos$GeneratedCodeInfo:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   243: aload_0
    //   244: invokevirtual 105	com/google/protobuf/DescriptorProtos$GeneratedCodeInfo:makeExtensionsImmutable	()V
    //   247: return
    //   248: new 107	java/lang/NullPointerException
    //   251: dup
    //   252: invokespecial 108	java/lang/NullPointerException:<init>	()V
    //   255: astore_1
    //   256: goto +5 -> 261
    //   259: aload_1
    //   260: athrow
    //   261: goto -2 -> 259
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	264	0	this	GeneratedCodeInfo
    //   0	264	1	paramCodedInputStream	CodedInputStream
    //   0	264	2	paramExtensionRegistryLite	ExtensionRegistryLite
    //   17	203	3	i	int
    //   36	104	4	j	int
    //   24	164	5	k	int
    //   27	130	6	m	int
    //   30	145	7	n	int
    //   14	133	8	i1	int
    //   11	225	9	localBuilder	UnknownFieldSet.Builder
    // Exception table:
    //   from	to	target	type
    //   32	38	151	finally
    //   59	72	151	finally
    //   93	104	151	finally
    //   121	139	151	finally
    //   160	173	151	finally
    //   178	184	151	finally
    //   32	38	155	java/io/IOException
    //   59	72	155	java/io/IOException
    //   93	104	155	java/io/IOException
    //   121	139	155	java/io/IOException
    //   32	38	173	com/google/protobuf/InvalidProtocolBufferException
    //   59	72	173	com/google/protobuf/InvalidProtocolBufferException
    //   93	104	173	com/google/protobuf/InvalidProtocolBufferException
    //   121	139	173	com/google/protobuf/InvalidProtocolBufferException
  }
  
  private DescriptorProtos$GeneratedCodeInfo(GeneratedMessageV3.Builder<?> paramBuilder)
  {
    super(paramBuilder);
  }
  
  public static GeneratedCodeInfo getDefaultInstance()
  {
    return a;
  }
  
  public static final Descriptors.Descriptor getDescriptor()
  {
    return DescriptorProtos.Z();
  }
  
  public static DescriptorProtos.GeneratedCodeInfo.Builder newBuilder()
  {
    return a.toBuilder();
  }
  
  public static DescriptorProtos.GeneratedCodeInfo.Builder newBuilder(GeneratedCodeInfo paramGeneratedCodeInfo)
  {
    return a.toBuilder().a(paramGeneratedCodeInfo);
  }
  
  public static GeneratedCodeInfo parseDelimitedFrom(InputStream paramInputStream)
  {
    return (GeneratedCodeInfo)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream);
  }
  
  public static GeneratedCodeInfo parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (GeneratedCodeInfo)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static GeneratedCodeInfo parseFrom(ByteString paramByteString)
  {
    return (GeneratedCodeInfo)PARSER.parseFrom(paramByteString);
  }
  
  public static GeneratedCodeInfo parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (GeneratedCodeInfo)PARSER.parseFrom(paramByteString, paramExtensionRegistryLite);
  }
  
  public static GeneratedCodeInfo parseFrom(CodedInputStream paramCodedInputStream)
  {
    return (GeneratedCodeInfo)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream);
  }
  
  public static GeneratedCodeInfo parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (GeneratedCodeInfo)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static GeneratedCodeInfo parseFrom(InputStream paramInputStream)
  {
    return (GeneratedCodeInfo)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream);
  }
  
  public static GeneratedCodeInfo parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (GeneratedCodeInfo)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static GeneratedCodeInfo parseFrom(ByteBuffer paramByteBuffer)
  {
    return (GeneratedCodeInfo)PARSER.parseFrom(paramByteBuffer);
  }
  
  public static GeneratedCodeInfo parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (GeneratedCodeInfo)PARSER.parseFrom(paramByteBuffer, paramExtensionRegistryLite);
  }
  
  public static GeneratedCodeInfo parseFrom(byte[] paramArrayOfByte)
  {
    return (GeneratedCodeInfo)PARSER.parseFrom(paramArrayOfByte);
  }
  
  public static GeneratedCodeInfo parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (GeneratedCodeInfo)PARSER.parseFrom(paramArrayOfByte, paramExtensionRegistryLite);
  }
  
  public static Parser<GeneratedCodeInfo> parser()
  {
    return PARSER;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof GeneratedCodeInfo)) {
      return super.equals(paramObject);
    }
    paramObject = (GeneratedCodeInfo)paramObject;
    if (!getAnnotationList().equals(paramObject.getAnnotationList())) {
      return false;
    }
    return this.unknownFields.equals(paramObject.unknownFields);
  }
  
  public DescriptorProtos.GeneratedCodeInfo.Annotation getAnnotation(int paramInt)
  {
    return (DescriptorProtos.GeneratedCodeInfo.Annotation)this.annotation_.get(paramInt);
  }
  
  public int getAnnotationCount()
  {
    return this.annotation_.size();
  }
  
  public List<DescriptorProtos.GeneratedCodeInfo.Annotation> getAnnotationList()
  {
    return this.annotation_;
  }
  
  public DescriptorProtos.GeneratedCodeInfo.AnnotationOrBuilder getAnnotationOrBuilder(int paramInt)
  {
    return (DescriptorProtos.GeneratedCodeInfo.AnnotationOrBuilder)this.annotation_.get(paramInt);
  }
  
  public List<? extends DescriptorProtos.GeneratedCodeInfo.AnnotationOrBuilder> getAnnotationOrBuilderList()
  {
    return this.annotation_;
  }
  
  public GeneratedCodeInfo getDefaultInstanceForType()
  {
    return a;
  }
  
  public Parser<GeneratedCodeInfo> getParserForType()
  {
    return PARSER;
  }
  
  public int getSerializedSize()
  {
    int i = this.memoizedSize;
    if (i != -1) {
      return i;
    }
    i = 0;
    int j = 0;
    while (i < this.annotation_.size())
    {
      j += CodedOutputStream.c(1, (MessageLite)this.annotation_.get(i));
      i += 1;
    }
    i = j + this.unknownFields.getSerializedSize();
    this.memoizedSize = i;
    return i;
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
    int j = 779 + getDescriptor().hashCode();
    int i = j;
    if (getAnnotationCount() > 0) {
      i = (j * 37 + 1) * 53 + getAnnotationList().hashCode();
    }
    i = i * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    return i;
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return DescriptorProtos.aa().a(GeneratedCodeInfo.class, DescriptorProtos.GeneratedCodeInfo.Builder.class);
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
  
  public DescriptorProtos.GeneratedCodeInfo.Builder newBuilderForType()
  {
    return newBuilder();
  }
  
  protected DescriptorProtos.GeneratedCodeInfo.Builder newBuilderForType(GeneratedMessageV3.BuilderParent paramBuilderParent)
  {
    return new DescriptorProtos.GeneratedCodeInfo.Builder(paramBuilderParent, null);
  }
  
  protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter paramUnusedPrivateParameter)
  {
    return new GeneratedCodeInfo();
  }
  
  public DescriptorProtos.GeneratedCodeInfo.Builder toBuilder()
  {
    if (this == a) {
      return new DescriptorProtos.GeneratedCodeInfo.Builder(null);
    }
    return new DescriptorProtos.GeneratedCodeInfo.Builder(null).a(this);
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
  {
    int i = 0;
    while (i < this.annotation_.size())
    {
      paramCodedOutputStream.a(1, (MessageLite)this.annotation_.get(i));
      i += 1;
    }
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.DescriptorProtos.GeneratedCodeInfo
 * JD-Core Version:    0.7.0.1
 */