package com.tencent.ilinkservice;

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

public final class a$h
  extends GeneratedMessageV3
  implements i
{
  @Deprecated
  public static final Parser<h> a = new a.h.1();
  private static final h h = new h();
  private int b;
  private volatile Object c;
  private int d;
  private int e;
  private ByteString f;
  private byte g = -1;
  
  private a$h()
  {
    this.c = "";
    this.f = ByteString.EMPTY;
  }
  
  /* Error */
  private a$h(com.google.protobuf.CodedInputStream paramCodedInputStream, com.google.protobuf.ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 27	com/tencent/ilinkservice/a$h:<init>	()V
    //   4: aload_2
    //   5: ifnull +217 -> 222
    //   8: invokestatic 59	com/google/protobuf/UnknownFieldSet:a	()Lcom/google/protobuf/UnknownFieldSet$Builder;
    //   11: astore 5
    //   13: iconst_0
    //   14: istore_3
    //   15: iload_3
    //   16: ifne +192 -> 208
    //   19: aload_1
    //   20: invokevirtual 64	com/google/protobuf/CodedInputStream:a	()I
    //   23: istore 4
    //   25: iload 4
    //   27: ifeq +136 -> 163
    //   30: iload 4
    //   32: bipush 10
    //   34: if_icmpeq +104 -> 138
    //   37: iload 4
    //   39: bipush 16
    //   41: if_icmpeq +76 -> 117
    //   44: iload 4
    //   46: bipush 24
    //   48: if_icmpeq +48 -> 96
    //   51: iload 4
    //   53: bipush 34
    //   55: if_icmpeq +19 -> 74
    //   58: aload_0
    //   59: aload_1
    //   60: aload 5
    //   62: aload_2
    //   63: iload 4
    //   65: invokevirtual 68	com/tencent/ilinkservice/a$h:parseUnknownField	(Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/UnknownFieldSet$Builder;Lcom/google/protobuf/ExtensionRegistryLite;I)Z
    //   68: ifne -53 -> 15
    //   71: goto +92 -> 163
    //   74: aload_0
    //   75: aload_0
    //   76: getfield 70	com/tencent/ilinkservice/a$h:b	I
    //   79: bipush 8
    //   81: ior
    //   82: putfield 70	com/tencent/ilinkservice/a$h:b	I
    //   85: aload_0
    //   86: aload_1
    //   87: invokevirtual 74	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   90: putfield 49	com/tencent/ilinkservice/a$h:f	Lcom/google/protobuf/ByteString;
    //   93: goto -78 -> 15
    //   96: aload_0
    //   97: aload_0
    //   98: getfield 70	com/tencent/ilinkservice/a$h:b	I
    //   101: iconst_4
    //   102: ior
    //   103: putfield 70	com/tencent/ilinkservice/a$h:b	I
    //   106: aload_0
    //   107: aload_1
    //   108: invokevirtual 77	com/google/protobuf/CodedInputStream:m	()I
    //   111: putfield 79	com/tencent/ilinkservice/a$h:e	I
    //   114: goto -99 -> 15
    //   117: aload_0
    //   118: aload_0
    //   119: getfield 70	com/tencent/ilinkservice/a$h:b	I
    //   122: iconst_2
    //   123: ior
    //   124: putfield 70	com/tencent/ilinkservice/a$h:b	I
    //   127: aload_0
    //   128: aload_1
    //   129: invokevirtual 77	com/google/protobuf/CodedInputStream:m	()I
    //   132: putfield 81	com/tencent/ilinkservice/a$h:d	I
    //   135: goto -120 -> 15
    //   138: aload_1
    //   139: invokevirtual 74	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   142: astore 6
    //   144: aload_0
    //   145: iconst_1
    //   146: aload_0
    //   147: getfield 70	com/tencent/ilinkservice/a$h:b	I
    //   150: ior
    //   151: putfield 70	com/tencent/ilinkservice/a$h:b	I
    //   154: aload_0
    //   155: aload 6
    //   157: putfield 42	com/tencent/ilinkservice/a$h:c	Ljava/lang/Object;
    //   160: goto -145 -> 15
    //   163: iconst_1
    //   164: istore_3
    //   165: goto -150 -> 15
    //   168: astore_1
    //   169: goto +24 -> 193
    //   172: astore_1
    //   173: new 52	com/google/protobuf/InvalidProtocolBufferException
    //   176: dup
    //   177: aload_1
    //   178: invokespecial 84	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/io/IOException;)V
    //   181: aload_0
    //   182: invokevirtual 88	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   185: athrow
    //   186: astore_1
    //   187: aload_1
    //   188: aload_0
    //   189: invokevirtual 88	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   192: athrow
    //   193: aload_0
    //   194: aload 5
    //   196: invokevirtual 93	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   199: putfield 97	com/tencent/ilinkservice/a$h:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   202: aload_0
    //   203: invokevirtual 100	com/tencent/ilinkservice/a$h:makeExtensionsImmutable	()V
    //   206: aload_1
    //   207: athrow
    //   208: aload_0
    //   209: aload 5
    //   211: invokevirtual 93	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   214: putfield 97	com/tencent/ilinkservice/a$h:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   217: aload_0
    //   218: invokevirtual 100	com/tencent/ilinkservice/a$h:makeExtensionsImmutable	()V
    //   221: return
    //   222: new 102	java/lang/NullPointerException
    //   225: dup
    //   226: invokespecial 103	java/lang/NullPointerException:<init>	()V
    //   229: astore_1
    //   230: goto +5 -> 235
    //   233: aload_1
    //   234: athrow
    //   235: goto -2 -> 233
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	238	0	this	h
    //   0	238	1	paramCodedInputStream	com.google.protobuf.CodedInputStream
    //   0	238	2	paramExtensionRegistryLite	com.google.protobuf.ExtensionRegistryLite
    //   14	151	3	i	int
    //   23	41	4	j	int
    //   11	199	5	localBuilder	com.google.protobuf.UnknownFieldSet.Builder
    //   142	14	6	localByteString	ByteString
    // Exception table:
    //   from	to	target	type
    //   19	25	168	finally
    //   58	71	168	finally
    //   74	93	168	finally
    //   96	114	168	finally
    //   117	135	168	finally
    //   138	160	168	finally
    //   173	186	168	finally
    //   187	193	168	finally
    //   19	25	172	java/io/IOException
    //   58	71	172	java/io/IOException
    //   74	93	172	java/io/IOException
    //   96	114	172	java/io/IOException
    //   117	135	172	java/io/IOException
    //   138	160	172	java/io/IOException
    //   19	25	186	com/google/protobuf/InvalidProtocolBufferException
    //   58	71	186	com/google/protobuf/InvalidProtocolBufferException
    //   74	93	186	com/google/protobuf/InvalidProtocolBufferException
    //   96	114	186	com/google/protobuf/InvalidProtocolBufferException
    //   117	135	186	com/google/protobuf/InvalidProtocolBufferException
    //   138	160	186	com/google/protobuf/InvalidProtocolBufferException
  }
  
  private a$h(GeneratedMessageV3.Builder<?> paramBuilder)
  {
    super(paramBuilder);
  }
  
  public static final Descriptors.Descriptor a()
  {
    return a.B();
  }
  
  public static h a(byte[] paramArrayOfByte)
  {
    return (h)a.parseFrom(paramArrayOfByte);
  }
  
  public static a.h.a k()
  {
    return h.l();
  }
  
  public static h m()
  {
    return h;
  }
  
  protected a.h.a a(GeneratedMessageV3.BuilderParent paramBuilderParent)
  {
    return new a.h.a(paramBuilderParent, null);
  }
  
  public boolean b()
  {
    return (this.b & 0x1) != 0;
  }
  
  public String c()
  {
    Object localObject = this.c;
    if ((localObject instanceof String)) {
      return (String)localObject;
    }
    localObject = (ByteString)localObject;
    String str = ((ByteString)localObject).toStringUtf8();
    if (((ByteString)localObject).isValidUtf8()) {
      this.c = str;
    }
    return str;
  }
  
  public boolean d()
  {
    return (this.b & 0x2) != 0;
  }
  
  public int e()
  {
    return this.d;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof h)) {
      return super.equals(paramObject);
    }
    paramObject = (h)paramObject;
    if (b() != paramObject.b()) {
      return false;
    }
    if ((b()) && (!c().equals(paramObject.c()))) {
      return false;
    }
    if (d() != paramObject.d()) {
      return false;
    }
    if ((d()) && (e() != paramObject.e())) {
      return false;
    }
    if (f() != paramObject.f()) {
      return false;
    }
    if ((f()) && (g() != paramObject.g())) {
      return false;
    }
    if (h() != paramObject.h()) {
      return false;
    }
    if ((h()) && (!i().equals(paramObject.i()))) {
      return false;
    }
    return this.unknownFields.equals(paramObject.unknownFields);
  }
  
  public boolean f()
  {
    return (this.b & 0x4) != 0;
  }
  
  public int g()
  {
    return this.e;
  }
  
  public Parser<h> getParserForType()
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
      j = 0 + GeneratedMessageV3.computeStringSize(1, this.c);
    }
    i = j;
    if ((this.b & 0x2) != 0) {
      i = j + CodedOutputStream.i(2, this.d);
    }
    j = i;
    if ((this.b & 0x4) != 0) {
      j = i + CodedOutputStream.i(3, this.e);
    }
    i = j;
    if ((this.b & 0x8) != 0) {
      i = j + CodedOutputStream.c(4, this.f);
    }
    i += this.unknownFields.getSerializedSize();
    this.memoizedSize = i;
    return i;
  }
  
  public final UnknownFieldSet getUnknownFields()
  {
    return this.unknownFields;
  }
  
  public boolean h()
  {
    return (this.b & 0x8) != 0;
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
      j = (i * 37 + 2) * 53 + e();
    }
    i = j;
    if (f()) {
      i = (j * 37 + 3) * 53 + g();
    }
    j = i;
    if (h()) {
      j = (i * 37 + 4) * 53 + i().hashCode();
    }
    i = j * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    return i;
  }
  
  public ByteString i()
  {
    return this.f;
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return a.C().a(h.class, a.h.a.class);
  }
  
  public final boolean isInitialized()
  {
    int i = this.g;
    if (i == 1) {
      return true;
    }
    if (i == 0) {
      return false;
    }
    this.g = 1;
    return true;
  }
  
  public a.h.a j()
  {
    return k();
  }
  
  public a.h.a l()
  {
    if (this == h) {
      return new a.h.a(null);
    }
    return new a.h.a(null).a(this);
  }
  
  public h n()
  {
    return h;
  }
  
  protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter paramUnusedPrivateParameter)
  {
    return new h();
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
  {
    if ((this.b & 0x1) != 0) {
      GeneratedMessageV3.writeString(paramCodedOutputStream, 1, this.c);
    }
    if ((this.b & 0x2) != 0) {
      paramCodedOutputStream.c(2, this.d);
    }
    if ((this.b & 0x4) != 0) {
      paramCodedOutputStream.c(3, this.e);
    }
    if ((this.b & 0x8) != 0) {
      paramCodedOutputStream.a(4, this.f);
    }
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilinkservice.a.h
 * JD-Core Version:    0.7.0.1
 */