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

public final class b$u
  extends GeneratedMessageV3
  implements u
{
  @Deprecated
  public static final Parser<u> a = new b.u.1();
  private static final u l = new u();
  private int b;
  private int c;
  private ByteString d;
  private ByteString e;
  private int f;
  private int g;
  private ByteString h;
  private ByteString i;
  private ByteString j;
  private byte k = -1;
  
  private b$u()
  {
    this.d = ByteString.EMPTY;
    this.e = ByteString.EMPTY;
    this.h = ByteString.EMPTY;
    this.i = ByteString.EMPTY;
    this.j = ByteString.EMPTY;
  }
  
  /* Error */
  private b$u(com.google.protobuf.CodedInputStream paramCodedInputStream, com.google.protobuf.ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 30	com/tencent/ilink/tdi/b$u:<init>	()V
    //   4: aload_2
    //   5: ifnull +330 -> 335
    //   8: invokestatic 66	com/google/protobuf/UnknownFieldSet:a	()Lcom/google/protobuf/UnknownFieldSet$Builder;
    //   11: astore 5
    //   13: iconst_0
    //   14: istore_3
    //   15: iload_3
    //   16: ifne +305 -> 321
    //   19: aload_1
    //   20: invokevirtual 71	com/google/protobuf/CodedInputStream:a	()I
    //   23: istore 4
    //   25: iload 4
    //   27: ifeq +249 -> 276
    //   30: iload 4
    //   32: bipush 8
    //   34: if_icmpeq +221 -> 255
    //   37: iload 4
    //   39: bipush 18
    //   41: if_icmpeq +193 -> 234
    //   44: iload 4
    //   46: bipush 26
    //   48: if_icmpeq +165 -> 213
    //   51: iload 4
    //   53: bipush 32
    //   55: if_icmpeq +136 -> 191
    //   58: iload 4
    //   60: bipush 40
    //   62: if_icmpeq +107 -> 169
    //   65: iload 4
    //   67: bipush 50
    //   69: if_icmpeq +78 -> 147
    //   72: iload 4
    //   74: bipush 58
    //   76: if_icmpeq +49 -> 125
    //   79: iload 4
    //   81: bipush 66
    //   83: if_icmpeq +19 -> 102
    //   86: aload_0
    //   87: aload_1
    //   88: aload 5
    //   90: aload_2
    //   91: iload 4
    //   93: invokevirtual 75	com/tencent/ilink/tdi/b$u:parseUnknownField	(Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/UnknownFieldSet$Builder;Lcom/google/protobuf/ExtensionRegistryLite;I)Z
    //   96: ifne -81 -> 15
    //   99: goto +177 -> 276
    //   102: aload_0
    //   103: aload_0
    //   104: getfield 77	com/tencent/ilink/tdi/b$u:b	I
    //   107: sipush 128
    //   110: ior
    //   111: putfield 77	com/tencent/ilink/tdi/b$u:b	I
    //   114: aload_0
    //   115: aload_1
    //   116: invokevirtual 80	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   119: putfield 56	com/tencent/ilink/tdi/b$u:j	Lcom/google/protobuf/ByteString;
    //   122: goto -107 -> 15
    //   125: aload_0
    //   126: aload_0
    //   127: getfield 77	com/tencent/ilink/tdi/b$u:b	I
    //   130: bipush 64
    //   132: ior
    //   133: putfield 77	com/tencent/ilink/tdi/b$u:b	I
    //   136: aload_0
    //   137: aload_1
    //   138: invokevirtual 80	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   141: putfield 54	com/tencent/ilink/tdi/b$u:i	Lcom/google/protobuf/ByteString;
    //   144: goto -129 -> 15
    //   147: aload_0
    //   148: aload_0
    //   149: getfield 77	com/tencent/ilink/tdi/b$u:b	I
    //   152: bipush 32
    //   154: ior
    //   155: putfield 77	com/tencent/ilink/tdi/b$u:b	I
    //   158: aload_0
    //   159: aload_1
    //   160: invokevirtual 80	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   163: putfield 52	com/tencent/ilink/tdi/b$u:h	Lcom/google/protobuf/ByteString;
    //   166: goto -151 -> 15
    //   169: aload_0
    //   170: aload_0
    //   171: getfield 77	com/tencent/ilink/tdi/b$u:b	I
    //   174: bipush 16
    //   176: ior
    //   177: putfield 77	com/tencent/ilink/tdi/b$u:b	I
    //   180: aload_0
    //   181: aload_1
    //   182: invokevirtual 83	com/google/protobuf/CodedInputStream:m	()I
    //   185: putfield 85	com/tencent/ilink/tdi/b$u:g	I
    //   188: goto -173 -> 15
    //   191: aload_0
    //   192: aload_0
    //   193: getfield 77	com/tencent/ilink/tdi/b$u:b	I
    //   196: bipush 8
    //   198: ior
    //   199: putfield 77	com/tencent/ilink/tdi/b$u:b	I
    //   202: aload_0
    //   203: aload_1
    //   204: invokevirtual 87	com/google/protobuf/CodedInputStream:f	()I
    //   207: putfield 89	com/tencent/ilink/tdi/b$u:f	I
    //   210: goto -195 -> 15
    //   213: aload_0
    //   214: aload_0
    //   215: getfield 77	com/tencent/ilink/tdi/b$u:b	I
    //   218: iconst_4
    //   219: ior
    //   220: putfield 77	com/tencent/ilink/tdi/b$u:b	I
    //   223: aload_0
    //   224: aload_1
    //   225: invokevirtual 80	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   228: putfield 50	com/tencent/ilink/tdi/b$u:e	Lcom/google/protobuf/ByteString;
    //   231: goto -216 -> 15
    //   234: aload_0
    //   235: aload_0
    //   236: getfield 77	com/tencent/ilink/tdi/b$u:b	I
    //   239: iconst_2
    //   240: ior
    //   241: putfield 77	com/tencent/ilink/tdi/b$u:b	I
    //   244: aload_0
    //   245: aload_1
    //   246: invokevirtual 80	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   249: putfield 48	com/tencent/ilink/tdi/b$u:d	Lcom/google/protobuf/ByteString;
    //   252: goto -237 -> 15
    //   255: aload_0
    //   256: aload_0
    //   257: getfield 77	com/tencent/ilink/tdi/b$u:b	I
    //   260: iconst_1
    //   261: ior
    //   262: putfield 77	com/tencent/ilink/tdi/b$u:b	I
    //   265: aload_0
    //   266: aload_1
    //   267: invokevirtual 83	com/google/protobuf/CodedInputStream:m	()I
    //   270: putfield 91	com/tencent/ilink/tdi/b$u:c	I
    //   273: goto -258 -> 15
    //   276: iconst_1
    //   277: istore_3
    //   278: goto -263 -> 15
    //   281: astore_1
    //   282: goto +24 -> 306
    //   285: astore_1
    //   286: new 59	com/google/protobuf/InvalidProtocolBufferException
    //   289: dup
    //   290: aload_1
    //   291: invokespecial 94	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/io/IOException;)V
    //   294: aload_0
    //   295: invokevirtual 98	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   298: athrow
    //   299: astore_1
    //   300: aload_1
    //   301: aload_0
    //   302: invokevirtual 98	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   305: athrow
    //   306: aload_0
    //   307: aload 5
    //   309: invokevirtual 103	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   312: putfield 107	com/tencent/ilink/tdi/b$u:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   315: aload_0
    //   316: invokevirtual 110	com/tencent/ilink/tdi/b$u:makeExtensionsImmutable	()V
    //   319: aload_1
    //   320: athrow
    //   321: aload_0
    //   322: aload 5
    //   324: invokevirtual 103	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   327: putfield 107	com/tencent/ilink/tdi/b$u:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   330: aload_0
    //   331: invokevirtual 110	com/tencent/ilink/tdi/b$u:makeExtensionsImmutable	()V
    //   334: return
    //   335: new 112	java/lang/NullPointerException
    //   338: dup
    //   339: invokespecial 113	java/lang/NullPointerException:<init>	()V
    //   342: astore_1
    //   343: goto +5 -> 348
    //   346: aload_1
    //   347: athrow
    //   348: goto -2 -> 346
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	351	0	this	u
    //   0	351	1	paramCodedInputStream	com.google.protobuf.CodedInputStream
    //   0	351	2	paramExtensionRegistryLite	com.google.protobuf.ExtensionRegistryLite
    //   14	264	3	m	int
    //   23	69	4	n	int
    //   11	312	5	localBuilder	com.google.protobuf.UnknownFieldSet.Builder
    // Exception table:
    //   from	to	target	type
    //   19	25	281	finally
    //   86	99	281	finally
    //   102	122	281	finally
    //   125	144	281	finally
    //   147	166	281	finally
    //   169	188	281	finally
    //   191	210	281	finally
    //   213	231	281	finally
    //   234	252	281	finally
    //   255	273	281	finally
    //   286	299	281	finally
    //   300	306	281	finally
    //   19	25	285	java/io/IOException
    //   86	99	285	java/io/IOException
    //   102	122	285	java/io/IOException
    //   125	144	285	java/io/IOException
    //   147	166	285	java/io/IOException
    //   169	188	285	java/io/IOException
    //   191	210	285	java/io/IOException
    //   213	231	285	java/io/IOException
    //   234	252	285	java/io/IOException
    //   255	273	285	java/io/IOException
    //   19	25	299	com/google/protobuf/InvalidProtocolBufferException
    //   86	99	299	com/google/protobuf/InvalidProtocolBufferException
    //   102	122	299	com/google/protobuf/InvalidProtocolBufferException
    //   125	144	299	com/google/protobuf/InvalidProtocolBufferException
    //   147	166	299	com/google/protobuf/InvalidProtocolBufferException
    //   169	188	299	com/google/protobuf/InvalidProtocolBufferException
    //   191	210	299	com/google/protobuf/InvalidProtocolBufferException
    //   213	231	299	com/google/protobuf/InvalidProtocolBufferException
    //   234	252	299	com/google/protobuf/InvalidProtocolBufferException
    //   255	273	299	com/google/protobuf/InvalidProtocolBufferException
  }
  
  private b$u(GeneratedMessageV3.Builder<?> paramBuilder)
  {
    super(paramBuilder);
  }
  
  public static final Descriptors.Descriptor a()
  {
    return b.r();
  }
  
  public static u a(ByteString paramByteString)
  {
    return (u)a.parseFrom(paramByteString);
  }
  
  public static u a(byte[] paramArrayOfByte)
  {
    return (u)a.parseFrom(paramArrayOfByte);
  }
  
  public static b.u.a s()
  {
    return l.t();
  }
  
  public static u u()
  {
    return l;
  }
  
  protected b.u.a a(GeneratedMessageV3.BuilderParent paramBuilderParent)
  {
    return new b.u.a(paramBuilderParent, null);
  }
  
  public boolean b()
  {
    return (this.b & 0x1) != 0;
  }
  
  public int c()
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
    if (!(paramObject instanceof u)) {
      return super.equals(paramObject);
    }
    paramObject = (u)paramObject;
    if (b() != paramObject.b()) {
      return false;
    }
    if ((b()) && (c() != paramObject.c())) {
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
    if ((f()) && (!g().equals(paramObject.g()))) {
      return false;
    }
    if (h() != paramObject.h()) {
      return false;
    }
    if ((h()) && (i() != paramObject.i())) {
      return false;
    }
    if (j() != paramObject.j()) {
      return false;
    }
    if ((j()) && (k() != paramObject.k())) {
      return false;
    }
    if (l() != paramObject.l()) {
      return false;
    }
    if ((l()) && (!m().equals(paramObject.m()))) {
      return false;
    }
    if (n() != paramObject.n()) {
      return false;
    }
    if ((n()) && (!o().equals(paramObject.o()))) {
      return false;
    }
    if (p() != paramObject.p()) {
      return false;
    }
    if ((p()) && (!q().equals(paramObject.q()))) {
      return false;
    }
    return this.unknownFields.equals(paramObject.unknownFields);
  }
  
  public boolean f()
  {
    return (this.b & 0x4) != 0;
  }
  
  public ByteString g()
  {
    return this.e;
  }
  
  public Parser<u> getParserForType()
  {
    return a;
  }
  
  public int getSerializedSize()
  {
    int m = this.memoizedSize;
    if (m != -1) {
      return m;
    }
    int n = 0;
    if ((this.b & 0x1) != 0) {
      n = 0 + CodedOutputStream.i(1, this.c);
    }
    m = n;
    if ((this.b & 0x2) != 0) {
      m = n + CodedOutputStream.c(2, this.d);
    }
    n = m;
    if ((this.b & 0x4) != 0) {
      n = m + CodedOutputStream.c(3, this.e);
    }
    m = n;
    if ((this.b & 0x8) != 0) {
      m = n + CodedOutputStream.h(4, this.f);
    }
    n = m;
    if ((this.b & 0x10) != 0) {
      n = m + CodedOutputStream.i(5, this.g);
    }
    m = n;
    if ((this.b & 0x20) != 0) {
      m = n + CodedOutputStream.c(6, this.h);
    }
    n = m;
    if ((this.b & 0x40) != 0) {
      n = m + CodedOutputStream.c(7, this.i);
    }
    m = n;
    if ((this.b & 0x80) != 0) {
      m = n + CodedOutputStream.c(8, this.j);
    }
    m += this.unknownFields.getSerializedSize();
    this.memoizedSize = m;
    return m;
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
    int n = 779 + a().hashCode();
    int m = n;
    if (b()) {
      m = (n * 37 + 1) * 53 + c();
    }
    n = m;
    if (d()) {
      n = (m * 37 + 2) * 53 + e().hashCode();
    }
    m = n;
    if (f()) {
      m = (n * 37 + 3) * 53 + g().hashCode();
    }
    n = m;
    if (h()) {
      n = (m * 37 + 4) * 53 + i();
    }
    m = n;
    if (j()) {
      m = (n * 37 + 5) * 53 + k();
    }
    n = m;
    if (l()) {
      n = (m * 37 + 6) * 53 + m().hashCode();
    }
    m = n;
    if (n()) {
      m = (n * 37 + 7) * 53 + o().hashCode();
    }
    n = m;
    if (p()) {
      n = (m * 37 + 8) * 53 + q().hashCode();
    }
    m = n * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = m;
    return m;
  }
  
  public int i()
  {
    return this.f;
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return b.s().a(u.class, b.u.a.class);
  }
  
  public final boolean isInitialized()
  {
    int m = this.k;
    if (m == 1) {
      return true;
    }
    if (m == 0) {
      return false;
    }
    this.k = 1;
    return true;
  }
  
  public boolean j()
  {
    return (this.b & 0x10) != 0;
  }
  
  public int k()
  {
    return this.g;
  }
  
  public boolean l()
  {
    return (this.b & 0x20) != 0;
  }
  
  public ByteString m()
  {
    return this.h;
  }
  
  public boolean n()
  {
    return (this.b & 0x40) != 0;
  }
  
  protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter paramUnusedPrivateParameter)
  {
    return new u();
  }
  
  public ByteString o()
  {
    return this.i;
  }
  
  public boolean p()
  {
    return (this.b & 0x80) != 0;
  }
  
  public ByteString q()
  {
    return this.j;
  }
  
  public b.u.a r()
  {
    return s();
  }
  
  public b.u.a t()
  {
    if (this == l) {
      return new b.u.a(null);
    }
    return new b.u.a(null).a(this);
  }
  
  public u v()
  {
    return l;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
  {
    if ((this.b & 0x1) != 0) {
      paramCodedOutputStream.c(1, this.c);
    }
    if ((this.b & 0x2) != 0) {
      paramCodedOutputStream.a(2, this.d);
    }
    if ((this.b & 0x4) != 0) {
      paramCodedOutputStream.a(3, this.e);
    }
    if ((this.b & 0x8) != 0) {
      paramCodedOutputStream.b(4, this.f);
    }
    if ((this.b & 0x10) != 0) {
      paramCodedOutputStream.c(5, this.g);
    }
    if ((this.b & 0x20) != 0) {
      paramCodedOutputStream.a(6, this.h);
    }
    if ((this.b & 0x40) != 0) {
      paramCodedOutputStream.a(7, this.i);
    }
    if ((this.b & 0x80) != 0) {
      paramCodedOutputStream.a(8, this.j);
    }
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilink.tdi.b.u
 * JD-Core Version:    0.7.0.1
 */