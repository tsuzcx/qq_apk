package com.tencent.ilink.tdi;

import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.GeneratedMessageV3.Builder;
import com.google.protobuf.GeneratedMessageV3.BuilderParent;
import com.google.protobuf.GeneratedMessageV3.FieldAccessorTable;
import com.google.protobuf.GeneratedMessageV3.UnusedPrivateParameter;
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import com.google.protobuf.Parser;
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.UnknownFieldSet;

public final class b$e
  extends GeneratedMessageV3
  implements g
{
  @Deprecated
  public static final Parser<e> a = new b.e.1();
  private static final e d = new e();
  private LazyStringList b;
  private byte c = -1;
  
  private b$e()
  {
    this.b = LazyStringArrayList.a;
  }
  
  /* Error */
  private b$e(com.google.protobuf.CodedInputStream paramCodedInputStream, com.google.protobuf.ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 21	com/tencent/ilink/tdi/b$e:<init>	()V
    //   4: aload_2
    //   5: ifnull +255 -> 260
    //   8: invokestatic 48	com/google/protobuf/UnknownFieldSet:a	()Lcom/google/protobuf/UnknownFieldSet$Builder;
    //   11: astore 9
    //   13: iconst_0
    //   14: istore 8
    //   16: iconst_0
    //   17: istore_3
    //   18: iload 8
    //   20: ifne +207 -> 227
    //   23: iload_3
    //   24: istore 5
    //   26: iload_3
    //   27: istore 6
    //   29: iload_3
    //   30: istore 7
    //   32: aload_1
    //   33: invokevirtual 53	com/google/protobuf/CodedInputStream:a	()I
    //   36: istore 4
    //   38: iload 4
    //   40: ifeq +113 -> 153
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
    //   66: invokevirtual 57	com/tencent/ilink/tdi/b$e:parseUnknownField	(Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/UnknownFieldSet$Builder;Lcom/google/protobuf/ExtensionRegistryLite;I)Z
    //   69: ifne -51 -> 18
    //   72: goto +81 -> 153
    //   75: iload_3
    //   76: istore 5
    //   78: iload_3
    //   79: istore 6
    //   81: iload_3
    //   82: istore 7
    //   84: aload_1
    //   85: invokevirtual 61	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
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
    //   109: new 34	com/google/protobuf/LazyStringArrayList
    //   112: dup
    //   113: invokespecial 62	com/google/protobuf/LazyStringArrayList:<init>	()V
    //   116: putfield 38	com/tencent/ilink/tdi/b$e:b	Lcom/google/protobuf/LazyStringList;
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
    //   137: getfield 38	com/tencent/ilink/tdi/b$e:b	Lcom/google/protobuf/LazyStringList;
    //   140: aload 10
    //   142: invokeinterface 67 2 0
    //   147: iload 4
    //   149: istore_3
    //   150: goto -132 -> 18
    //   153: iconst_1
    //   154: istore 8
    //   156: goto -138 -> 18
    //   159: astore_1
    //   160: goto +32 -> 192
    //   163: astore_1
    //   164: iload 6
    //   166: istore 5
    //   168: new 41	com/google/protobuf/InvalidProtocolBufferException
    //   171: dup
    //   172: aload_1
    //   173: invokespecial 70	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/io/IOException;)V
    //   176: aload_0
    //   177: invokevirtual 74	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   180: athrow
    //   181: astore_1
    //   182: iload 7
    //   184: istore 5
    //   186: aload_1
    //   187: aload_0
    //   188: invokevirtual 74	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   191: athrow
    //   192: iload 5
    //   194: iconst_1
    //   195: iand
    //   196: ifeq +16 -> 212
    //   199: aload_0
    //   200: aload_0
    //   201: getfield 38	com/tencent/ilink/tdi/b$e:b	Lcom/google/protobuf/LazyStringList;
    //   204: invokeinterface 78 1 0
    //   209: putfield 38	com/tencent/ilink/tdi/b$e:b	Lcom/google/protobuf/LazyStringList;
    //   212: aload_0
    //   213: aload 9
    //   215: invokevirtual 83	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   218: putfield 87	com/tencent/ilink/tdi/b$e:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   221: aload_0
    //   222: invokevirtual 90	com/tencent/ilink/tdi/b$e:makeExtensionsImmutable	()V
    //   225: aload_1
    //   226: athrow
    //   227: iload_3
    //   228: iconst_1
    //   229: iand
    //   230: ifeq +16 -> 246
    //   233: aload_0
    //   234: aload_0
    //   235: getfield 38	com/tencent/ilink/tdi/b$e:b	Lcom/google/protobuf/LazyStringList;
    //   238: invokeinterface 78 1 0
    //   243: putfield 38	com/tencent/ilink/tdi/b$e:b	Lcom/google/protobuf/LazyStringList;
    //   246: aload_0
    //   247: aload 9
    //   249: invokevirtual 83	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   252: putfield 87	com/tencent/ilink/tdi/b$e:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   255: aload_0
    //   256: invokevirtual 90	com/tencent/ilink/tdi/b$e:makeExtensionsImmutable	()V
    //   259: return
    //   260: new 92	java/lang/NullPointerException
    //   263: dup
    //   264: invokespecial 93	java/lang/NullPointerException:<init>	()V
    //   267: astore_1
    //   268: goto +5 -> 273
    //   271: aload_1
    //   272: athrow
    //   273: goto -2 -> 271
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	276	0	this	e
    //   0	276	1	paramCodedInputStream	com.google.protobuf.CodedInputStream
    //   0	276	2	paramExtensionRegistryLite	com.google.protobuf.ExtensionRegistryLite
    //   17	213	3	i	int
    //   36	112	4	j	int
    //   24	172	5	k	int
    //   27	138	6	m	int
    //   30	153	7	n	int
    //   14	141	8	i1	int
    //   11	237	9	localBuilder	com.google.protobuf.UnknownFieldSet.Builder
    //   88	53	10	localByteString	com.google.protobuf.ByteString
    // Exception table:
    //   from	to	target	type
    //   32	38	159	finally
    //   59	72	159	finally
    //   84	90	159	finally
    //   108	119	159	finally
    //   136	147	159	finally
    //   168	181	159	finally
    //   186	192	159	finally
    //   32	38	163	java/io/IOException
    //   59	72	163	java/io/IOException
    //   84	90	163	java/io/IOException
    //   108	119	163	java/io/IOException
    //   136	147	163	java/io/IOException
    //   32	38	181	com/google/protobuf/InvalidProtocolBufferException
    //   59	72	181	com/google/protobuf/InvalidProtocolBufferException
    //   84	90	181	com/google/protobuf/InvalidProtocolBufferException
    //   108	119	181	com/google/protobuf/InvalidProtocolBufferException
    //   136	147	181	com/google/protobuf/InvalidProtocolBufferException
  }
  
  private b$e(GeneratedMessageV3.Builder<?> paramBuilder)
  {
    super(paramBuilder);
  }
  
  public static final Descriptors.Descriptor a()
  {
    return b.P();
  }
  
  public static e a(byte[] paramArrayOfByte)
  {
    return (e)a.parseFrom(paramArrayOfByte);
  }
  
  public static b.e.a e()
  {
    return d.f();
  }
  
  public static e g()
  {
    return d;
  }
  
  protected b.e.a a(GeneratedMessageV3.BuilderParent paramBuilderParent)
  {
    return new b.e.a(paramBuilderParent, null);
  }
  
  public ProtocolStringList b()
  {
    return this.b;
  }
  
  public int c()
  {
    return this.b.size();
  }
  
  public b.e.a d()
  {
    return e();
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof e)) {
      return super.equals(paramObject);
    }
    paramObject = (e)paramObject;
    if (!b().equals(paramObject.b())) {
      return false;
    }
    return this.unknownFields.equals(paramObject.unknownFields);
  }
  
  public b.e.a f()
  {
    if (this == d) {
      return new b.e.a(null);
    }
    return new b.e.a(null).a(this);
  }
  
  public Parser<e> getParserForType()
  {
    return a;
  }
  
  public int getSerializedSize()
  {
    int i = this.memoizedSize;
    if (i != -1) {
      return i;
    }
    i = 0;
    int j = 0;
    while (i < this.b.size())
    {
      j += computeStringSizeNoTag(this.b.d(i));
      i += 1;
    }
    i = 0 + j + b().size() * 1 + this.unknownFields.getSerializedSize();
    this.memoizedSize = i;
    return i;
  }
  
  public final UnknownFieldSet getUnknownFields()
  {
    return this.unknownFields;
  }
  
  public e h()
  {
    return d;
  }
  
  public int hashCode()
  {
    if (this.memoizedHashCode != 0) {
      return this.memoizedHashCode;
    }
    int j = 779 + a().hashCode();
    int i = j;
    if (c() > 0) {
      i = (j * 37 + 1) * 53 + b().hashCode();
    }
    i = i * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    return i;
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return b.Q().a(e.class, b.e.a.class);
  }
  
  public final boolean isInitialized()
  {
    int i = this.c;
    if (i == 1) {
      return true;
    }
    if (i == 0) {
      return false;
    }
    this.c = 1;
    return true;
  }
  
  protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter paramUnusedPrivateParameter)
  {
    return new e();
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
  {
    int i = 0;
    while (i < this.b.size())
    {
      GeneratedMessageV3.writeString(paramCodedOutputStream, 1, this.b.d(i));
      i += 1;
    }
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilink.tdi.b.e
 * JD-Core Version:    0.7.0.1
 */