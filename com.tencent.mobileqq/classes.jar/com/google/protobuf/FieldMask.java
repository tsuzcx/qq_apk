package com.google.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;

public final class FieldMask
  extends GeneratedMessageV3
  implements FieldMaskOrBuilder
{
  public static final int PATHS_FIELD_NUMBER = 1;
  private static final FieldMask a = new FieldMask();
  private static final Parser<FieldMask> b = new FieldMask.1();
  private static final long serialVersionUID = 0L;
  private byte memoizedIsInitialized = -1;
  private LazyStringList paths_;
  
  private FieldMask()
  {
    this.paths_ = LazyStringArrayList.a;
  }
  
  /* Error */
  private FieldMask(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 27	com/google/protobuf/FieldMask:<init>	()V
    //   4: aload_2
    //   5: ifnull +256 -> 261
    //   8: invokestatic 54	com/google/protobuf/UnknownFieldSet:a	()Lcom/google/protobuf/UnknownFieldSet$Builder;
    //   11: astore 9
    //   13: iconst_0
    //   14: istore 8
    //   16: iconst_0
    //   17: istore_3
    //   18: iload 8
    //   20: ifne +208 -> 228
    //   23: iload_3
    //   24: istore 5
    //   26: iload_3
    //   27: istore 6
    //   29: iload_3
    //   30: istore 7
    //   32: aload_1
    //   33: invokevirtual 59	com/google/protobuf/CodedInputStream:a	()I
    //   36: istore 4
    //   38: iload 4
    //   40: ifeq +114 -> 154
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
    //   66: invokevirtual 63	com/google/protobuf/FieldMask:parseUnknownField	(Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/UnknownFieldSet$Builder;Lcom/google/protobuf/ExtensionRegistryLite;I)Z
    //   69: ifne -51 -> 18
    //   72: goto +82 -> 154
    //   75: iload_3
    //   76: istore 5
    //   78: iload_3
    //   79: istore 6
    //   81: iload_3
    //   82: istore 7
    //   84: aload_1
    //   85: invokevirtual 67	com/google/protobuf/CodedInputStream:k	()Ljava/lang/String;
    //   88: astore 10
    //   90: iload_3
    //   91: istore 4
    //   93: iload_3
    //   94: iconst_1
    //   95: iand
    //   96: ifne +28 -> 124
    //   99: iload_3
    //   100: istore 5
    //   102: iload_3
    //   103: istore 6
    //   105: iload_3
    //   106: istore 7
    //   108: aload_0
    //   109: new 40	com/google/protobuf/LazyStringArrayList
    //   112: dup
    //   113: invokespecial 68	com/google/protobuf/LazyStringArrayList:<init>	()V
    //   116: putfield 44	com/google/protobuf/FieldMask:paths_	Lcom/google/protobuf/LazyStringList;
    //   119: iload_3
    //   120: iconst_1
    //   121: ior
    //   122: istore 4
    //   124: iload 4
    //   126: istore 5
    //   128: iload 4
    //   130: istore 6
    //   132: iload 4
    //   134: istore 7
    //   136: aload_0
    //   137: getfield 44	com/google/protobuf/FieldMask:paths_	Lcom/google/protobuf/LazyStringList;
    //   140: aload 10
    //   142: invokeinterface 74 2 0
    //   147: pop
    //   148: iload 4
    //   150: istore_3
    //   151: goto -133 -> 18
    //   154: iconst_1
    //   155: istore 8
    //   157: goto -139 -> 18
    //   160: astore_1
    //   161: goto +32 -> 193
    //   164: astore_1
    //   165: iload 6
    //   167: istore 5
    //   169: new 47	com/google/protobuf/InvalidProtocolBufferException
    //   172: dup
    //   173: aload_1
    //   174: invokespecial 77	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/io/IOException;)V
    //   177: aload_0
    //   178: invokevirtual 81	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   181: athrow
    //   182: astore_1
    //   183: iload 7
    //   185: istore 5
    //   187: aload_1
    //   188: aload_0
    //   189: invokevirtual 81	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   192: athrow
    //   193: iload 5
    //   195: iconst_1
    //   196: iand
    //   197: ifeq +16 -> 213
    //   200: aload_0
    //   201: aload_0
    //   202: getfield 44	com/google/protobuf/FieldMask:paths_	Lcom/google/protobuf/LazyStringList;
    //   205: invokeinterface 85 1 0
    //   210: putfield 44	com/google/protobuf/FieldMask:paths_	Lcom/google/protobuf/LazyStringList;
    //   213: aload_0
    //   214: aload 9
    //   216: invokevirtual 90	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   219: putfield 94	com/google/protobuf/FieldMask:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   222: aload_0
    //   223: invokevirtual 97	com/google/protobuf/FieldMask:makeExtensionsImmutable	()V
    //   226: aload_1
    //   227: athrow
    //   228: iload_3
    //   229: iconst_1
    //   230: iand
    //   231: ifeq +16 -> 247
    //   234: aload_0
    //   235: aload_0
    //   236: getfield 44	com/google/protobuf/FieldMask:paths_	Lcom/google/protobuf/LazyStringList;
    //   239: invokeinterface 85 1 0
    //   244: putfield 44	com/google/protobuf/FieldMask:paths_	Lcom/google/protobuf/LazyStringList;
    //   247: aload_0
    //   248: aload 9
    //   250: invokevirtual 90	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   253: putfield 94	com/google/protobuf/FieldMask:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   256: aload_0
    //   257: invokevirtual 97	com/google/protobuf/FieldMask:makeExtensionsImmutable	()V
    //   260: return
    //   261: new 99	java/lang/NullPointerException
    //   264: dup
    //   265: invokespecial 100	java/lang/NullPointerException:<init>	()V
    //   268: astore_1
    //   269: goto +5 -> 274
    //   272: aload_1
    //   273: athrow
    //   274: goto -2 -> 272
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	277	0	this	FieldMask
    //   0	277	1	paramCodedInputStream	CodedInputStream
    //   0	277	2	paramExtensionRegistryLite	ExtensionRegistryLite
    //   17	214	3	i	int
    //   36	113	4	j	int
    //   24	173	5	k	int
    //   27	139	6	m	int
    //   30	154	7	n	int
    //   14	142	8	i1	int
    //   11	238	9	localBuilder	UnknownFieldSet.Builder
    //   88	53	10	str	String
    // Exception table:
    //   from	to	target	type
    //   32	38	160	finally
    //   59	72	160	finally
    //   84	90	160	finally
    //   108	119	160	finally
    //   136	148	160	finally
    //   169	182	160	finally
    //   187	193	160	finally
    //   32	38	164	java/io/IOException
    //   59	72	164	java/io/IOException
    //   84	90	164	java/io/IOException
    //   108	119	164	java/io/IOException
    //   136	148	164	java/io/IOException
    //   32	38	182	com/google/protobuf/InvalidProtocolBufferException
    //   59	72	182	com/google/protobuf/InvalidProtocolBufferException
    //   84	90	182	com/google/protobuf/InvalidProtocolBufferException
    //   108	119	182	com/google/protobuf/InvalidProtocolBufferException
    //   136	148	182	com/google/protobuf/InvalidProtocolBufferException
  }
  
  private FieldMask(GeneratedMessageV3.Builder<?> paramBuilder)
  {
    super(paramBuilder);
  }
  
  public static FieldMask getDefaultInstance()
  {
    return a;
  }
  
  public static final Descriptors.Descriptor getDescriptor()
  {
    return FieldMaskProto.a;
  }
  
  public static FieldMask.Builder newBuilder()
  {
    return a.toBuilder();
  }
  
  public static FieldMask.Builder newBuilder(FieldMask paramFieldMask)
  {
    return a.toBuilder().a(paramFieldMask);
  }
  
  public static FieldMask parseDelimitedFrom(InputStream paramInputStream)
  {
    return (FieldMask)GeneratedMessageV3.parseDelimitedWithIOException(b, paramInputStream);
  }
  
  public static FieldMask parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (FieldMask)GeneratedMessageV3.parseDelimitedWithIOException(b, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static FieldMask parseFrom(ByteString paramByteString)
  {
    return (FieldMask)b.parseFrom(paramByteString);
  }
  
  public static FieldMask parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (FieldMask)b.parseFrom(paramByteString, paramExtensionRegistryLite);
  }
  
  public static FieldMask parseFrom(CodedInputStream paramCodedInputStream)
  {
    return (FieldMask)GeneratedMessageV3.parseWithIOException(b, paramCodedInputStream);
  }
  
  public static FieldMask parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (FieldMask)GeneratedMessageV3.parseWithIOException(b, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static FieldMask parseFrom(InputStream paramInputStream)
  {
    return (FieldMask)GeneratedMessageV3.parseWithIOException(b, paramInputStream);
  }
  
  public static FieldMask parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (FieldMask)GeneratedMessageV3.parseWithIOException(b, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static FieldMask parseFrom(ByteBuffer paramByteBuffer)
  {
    return (FieldMask)b.parseFrom(paramByteBuffer);
  }
  
  public static FieldMask parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (FieldMask)b.parseFrom(paramByteBuffer, paramExtensionRegistryLite);
  }
  
  public static FieldMask parseFrom(byte[] paramArrayOfByte)
  {
    return (FieldMask)b.parseFrom(paramArrayOfByte);
  }
  
  public static FieldMask parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (FieldMask)b.parseFrom(paramArrayOfByte, paramExtensionRegistryLite);
  }
  
  public static Parser<FieldMask> parser()
  {
    return b;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof FieldMask)) {
      return super.equals(paramObject);
    }
    paramObject = (FieldMask)paramObject;
    if (!getPathsList().equals(paramObject.getPathsList())) {
      return false;
    }
    return this.unknownFields.equals(paramObject.unknownFields);
  }
  
  public FieldMask getDefaultInstanceForType()
  {
    return a;
  }
  
  public Parser<FieldMask> getParserForType()
  {
    return b;
  }
  
  public String getPaths(int paramInt)
  {
    return (String)this.paths_.get(paramInt);
  }
  
  public ByteString getPathsBytes(int paramInt)
  {
    return this.paths_.f(paramInt);
  }
  
  public int getPathsCount()
  {
    return this.paths_.size();
  }
  
  public ProtocolStringList getPathsList()
  {
    return this.paths_;
  }
  
  public int getSerializedSize()
  {
    int i = this.memoizedSize;
    if (i != -1) {
      return i;
    }
    i = 0;
    int j = 0;
    while (i < this.paths_.size())
    {
      j += computeStringSizeNoTag(this.paths_.d(i));
      i += 1;
    }
    i = 0 + j + getPathsList().size() * 1 + this.unknownFields.getSerializedSize();
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
    if (getPathsCount() > 0) {
      i = (j * 37 + 1) * 53 + getPathsList().hashCode();
    }
    i = i * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    return i;
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return FieldMaskProto.b.a(FieldMask.class, FieldMask.Builder.class);
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
  
  public FieldMask.Builder newBuilderForType()
  {
    return newBuilder();
  }
  
  protected FieldMask.Builder newBuilderForType(GeneratedMessageV3.BuilderParent paramBuilderParent)
  {
    return new FieldMask.Builder(paramBuilderParent, null);
  }
  
  protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter paramUnusedPrivateParameter)
  {
    return new FieldMask();
  }
  
  public FieldMask.Builder toBuilder()
  {
    if (this == a) {
      return new FieldMask.Builder(null);
    }
    return new FieldMask.Builder(null).a(this);
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
  {
    int i = 0;
    while (i < this.paths_.size())
    {
      GeneratedMessageV3.writeString(paramCodedOutputStream, 1, this.paths_.d(i));
      i += 1;
    }
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.FieldMask
 * JD-Core Version:    0.7.0.1
 */