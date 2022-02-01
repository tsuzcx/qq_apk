package com.tencent.ilink.tdi;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.GeneratedMessageV3.Builder;
import com.google.protobuf.GeneratedMessageV3.BuilderParent;
import com.google.protobuf.GeneratedMessageV3.FieldAccessorTable;
import com.google.protobuf.GeneratedMessageV3.UnusedPrivateParameter;
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;

public final class b$n
  extends GeneratedMessageV3
  implements n
{
  @Deprecated
  public static final Parser<n> a = new b.n.1();
  private static final n g = new n();
  private int b;
  private ByteString c;
  private ByteString d;
  private int e;
  private byte f = -1;
  
  private b$n()
  {
    this.c = ByteString.EMPTY;
    this.d = ByteString.EMPTY;
    this.e = 0;
  }
  
  /* Error */
  private b$n(com.google.protobuf.CodedInputStream paramCodedInputStream, com.google.protobuf.ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 25	com/tencent/ilink/tdi/b$n:<init>	()V
    //   4: aload_2
    //   5: ifnull +208 -> 213
    //   8: invokestatic 57	com/google/protobuf/UnknownFieldSet:a	()Lcom/google/protobuf/UnknownFieldSet$Builder;
    //   11: astore 5
    //   13: iconst_0
    //   14: istore_3
    //   15: iload_3
    //   16: ifne +183 -> 199
    //   19: aload_1
    //   20: invokevirtual 62	com/google/protobuf/CodedInputStream:a	()I
    //   23: istore 4
    //   25: iload 4
    //   27: ifeq +127 -> 154
    //   30: iload 4
    //   32: bipush 10
    //   34: if_icmpeq +99 -> 133
    //   37: iload 4
    //   39: bipush 18
    //   41: if_icmpeq +71 -> 112
    //   44: iload 4
    //   46: bipush 24
    //   48: if_icmpeq +19 -> 67
    //   51: aload_0
    //   52: aload_1
    //   53: aload 5
    //   55: aload_2
    //   56: iload 4
    //   58: invokevirtual 66	com/tencent/ilink/tdi/b$n:parseUnknownField	(Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/UnknownFieldSet$Builder;Lcom/google/protobuf/ExtensionRegistryLite;I)Z
    //   61: ifne -46 -> 15
    //   64: goto +90 -> 154
    //   67: aload_1
    //   68: invokevirtual 69	com/google/protobuf/CodedInputStream:n	()I
    //   71: istore 4
    //   73: iload 4
    //   75: invokestatic 74	com/tencent/ilink/tdi/a$d:a	(I)Lcom/tencent/ilink/tdi/a$d;
    //   78: ifnonnull +15 -> 93
    //   81: aload 5
    //   83: iconst_3
    //   84: iload 4
    //   86: invokevirtual 79	com/google/protobuf/UnknownFieldSet$Builder:a	(II)Lcom/google/protobuf/UnknownFieldSet$Builder;
    //   89: pop
    //   90: goto -75 -> 15
    //   93: aload_0
    //   94: aload_0
    //   95: getfield 81	com/tencent/ilink/tdi/b$n:b	I
    //   98: iconst_4
    //   99: ior
    //   100: putfield 81	com/tencent/ilink/tdi/b$n:b	I
    //   103: aload_0
    //   104: iload 4
    //   106: putfield 47	com/tencent/ilink/tdi/b$n:e	I
    //   109: goto -94 -> 15
    //   112: aload_0
    //   113: aload_0
    //   114: getfield 81	com/tencent/ilink/tdi/b$n:b	I
    //   117: iconst_2
    //   118: ior
    //   119: putfield 81	com/tencent/ilink/tdi/b$n:b	I
    //   122: aload_0
    //   123: aload_1
    //   124: invokevirtual 85	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   127: putfield 45	com/tencent/ilink/tdi/b$n:d	Lcom/google/protobuf/ByteString;
    //   130: goto -115 -> 15
    //   133: aload_0
    //   134: aload_0
    //   135: getfield 81	com/tencent/ilink/tdi/b$n:b	I
    //   138: iconst_1
    //   139: ior
    //   140: putfield 81	com/tencent/ilink/tdi/b$n:b	I
    //   143: aload_0
    //   144: aload_1
    //   145: invokevirtual 85	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   148: putfield 43	com/tencent/ilink/tdi/b$n:c	Lcom/google/protobuf/ByteString;
    //   151: goto -136 -> 15
    //   154: iconst_1
    //   155: istore_3
    //   156: goto -141 -> 15
    //   159: astore_1
    //   160: goto +24 -> 184
    //   163: astore_1
    //   164: new 50	com/google/protobuf/InvalidProtocolBufferException
    //   167: dup
    //   168: aload_1
    //   169: invokespecial 88	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/io/IOException;)V
    //   172: aload_0
    //   173: invokevirtual 92	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   176: athrow
    //   177: astore_1
    //   178: aload_1
    //   179: aload_0
    //   180: invokevirtual 92	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   183: athrow
    //   184: aload_0
    //   185: aload 5
    //   187: invokevirtual 95	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   190: putfield 99	com/tencent/ilink/tdi/b$n:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   193: aload_0
    //   194: invokevirtual 102	com/tencent/ilink/tdi/b$n:makeExtensionsImmutable	()V
    //   197: aload_1
    //   198: athrow
    //   199: aload_0
    //   200: aload 5
    //   202: invokevirtual 95	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   205: putfield 99	com/tencent/ilink/tdi/b$n:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   208: aload_0
    //   209: invokevirtual 102	com/tencent/ilink/tdi/b$n:makeExtensionsImmutable	()V
    //   212: return
    //   213: new 104	java/lang/NullPointerException
    //   216: dup
    //   217: invokespecial 105	java/lang/NullPointerException:<init>	()V
    //   220: astore_1
    //   221: goto +5 -> 226
    //   224: aload_1
    //   225: athrow
    //   226: goto -2 -> 224
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	229	0	this	n
    //   0	229	1	paramCodedInputStream	com.google.protobuf.CodedInputStream
    //   0	229	2	paramExtensionRegistryLite	com.google.protobuf.ExtensionRegistryLite
    //   14	142	3	i	int
    //   23	82	4	j	int
    //   11	190	5	localBuilder	com.google.protobuf.UnknownFieldSet.Builder
    // Exception table:
    //   from	to	target	type
    //   19	25	159	finally
    //   51	64	159	finally
    //   67	90	159	finally
    //   93	109	159	finally
    //   112	130	159	finally
    //   133	151	159	finally
    //   164	177	159	finally
    //   178	184	159	finally
    //   19	25	163	java/io/IOException
    //   51	64	163	java/io/IOException
    //   67	90	163	java/io/IOException
    //   93	109	163	java/io/IOException
    //   112	130	163	java/io/IOException
    //   133	151	163	java/io/IOException
    //   19	25	177	com/google/protobuf/InvalidProtocolBufferException
    //   51	64	177	com/google/protobuf/InvalidProtocolBufferException
    //   67	90	177	com/google/protobuf/InvalidProtocolBufferException
    //   93	109	177	com/google/protobuf/InvalidProtocolBufferException
    //   112	130	177	com/google/protobuf/InvalidProtocolBufferException
    //   133	151	177	com/google/protobuf/InvalidProtocolBufferException
  }
  
  private b$n(GeneratedMessageV3.Builder<?> paramBuilder)
  {
    super(paramBuilder);
  }
  
  public static final Descriptors.Descriptor a()
  {
    return b.l();
  }
  
  public static n a(byte[] paramArrayOfByte)
  {
    return (n)a.parseFrom(paramArrayOfByte);
  }
  
  public static b.n.a i()
  {
    return g.j();
  }
  
  public static n k()
  {
    return g;
  }
  
  protected b.n.a a(GeneratedMessageV3.BuilderParent paramBuilderParent)
  {
    return new b.n.a(paramBuilderParent, null);
  }
  
  public boolean b()
  {
    return (this.b & 0x1) != 0;
  }
  
  public ByteString c()
  {
    return this.c;
  }
  
  public boolean d()
  {
    return (this.b & 0x2) != 0;
  }
  
  public ByteString e()
  {
    return this.d;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof n)) {
      return super.equals(paramObject);
    }
    paramObject = (n)paramObject;
    if (b() != paramObject.b()) {
      return false;
    }
    if ((b()) && (!c().equals(paramObject.c()))) {
      return false;
    }
    if (d() != paramObject.d()) {
      return false;
    }
    if ((d()) && (!e().equals(paramObject.e()))) {
      return false;
    }
    if (f() != paramObject.f()) {
      return false;
    }
    if ((f()) && (this.e != paramObject.e)) {
      return false;
    }
    return this.unknownFields.equals(paramObject.unknownFields);
  }
  
  public boolean f()
  {
    return (this.b & 0x4) != 0;
  }
  
  public a.d g()
  {
    a.d locald2 = a.d.a(this.e);
    a.d locald1 = locald2;
    if (locald2 == null) {
      locald1 = a.d.a;
    }
    return locald1;
  }
  
  public Parser<n> getParserForType()
  {
    return a;
  }
  
  public int getSerializedSize()
  {
    int i = this.memoizedSize;
    if (i != -1) {
      return i;
    }
    int j = 0;
    if ((this.b & 0x1) != 0) {
      j = 0 + CodedOutputStream.c(1, this.c);
    }
    i = j;
    if ((this.b & 0x2) != 0) {
      i = j + CodedOutputStream.c(2, this.d);
    }
    j = i;
    if ((this.b & 0x4) != 0) {
      j = i + CodedOutputStream.m(3, this.e);
    }
    i = j + this.unknownFields.getSerializedSize();
    this.memoizedSize = i;
    return i;
  }
  
  public final UnknownFieldSet getUnknownFields()
  {
    return this.unknownFields;
  }
  
  public b.n.a h()
  {
    return i();
  }
  
  public int hashCode()
  {
    if (this.memoizedHashCode != 0) {
      return this.memoizedHashCode;
    }
    int j = 779 + a().hashCode();
    int i = j;
    if (b()) {
      i = (j * 37 + 1) * 53 + c().hashCode();
    }
    j = i;
    if (d()) {
      j = (i * 37 + 2) * 53 + e().hashCode();
    }
    i = j;
    if (f()) {
      i = (j * 37 + 3) * 53 + this.e;
    }
    i = i * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    return i;
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return b.m().a(n.class, b.n.a.class);
  }
  
  public final boolean isInitialized()
  {
    int i = this.f;
    if (i == 1) {
      return true;
    }
    if (i == 0) {
      return false;
    }
    this.f = 1;
    return true;
  }
  
  public b.n.a j()
  {
    if (this == g) {
      return new b.n.a(null);
    }
    return new b.n.a(null).a(this);
  }
  
  public n l()
  {
    return g;
  }
  
  protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter paramUnusedPrivateParameter)
  {
    return new n();
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
  {
    if ((this.b & 0x1) != 0) {
      paramCodedOutputStream.a(1, this.c);
    }
    if ((this.b & 0x2) != 0) {
      paramCodedOutputStream.a(2, this.d);
    }
    if ((this.b & 0x4) != 0) {
      paramCodedOutputStream.g(3, this.e);
    }
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilink.tdi.b.n
 * JD-Core Version:    0.7.0.1
 */