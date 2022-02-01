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

public final class b$m
  extends GeneratedMessageV3
  implements m
{
  @Deprecated
  public static final Parser<m> a = new b.m.1();
  private static final m k = new m();
  private int b;
  private int c;
  private int d;
  private int e;
  private ByteString f;
  private ByteString g;
  private ByteString h;
  private int i;
  private byte j = -1;
  
  private b$m()
  {
    this.d = 1;
    this.e = 1;
    this.f = ByteString.EMPTY;
    this.g = ByteString.EMPTY;
    this.h = ByteString.EMPTY;
  }
  
  /* Error */
  private b$m(com.google.protobuf.CodedInputStream paramCodedInputStream, com.google.protobuf.ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 29	com/tencent/ilink/tdi/b$m:<init>	()V
    //   4: aload_2
    //   5: ifnull +348 -> 353
    //   8: invokestatic 65	com/google/protobuf/UnknownFieldSet:a	()Lcom/google/protobuf/UnknownFieldSet$Builder;
    //   11: astore 5
    //   13: iconst_0
    //   14: istore_3
    //   15: iload_3
    //   16: ifne +323 -> 339
    //   19: aload_1
    //   20: invokevirtual 70	com/google/protobuf/CodedInputStream:a	()I
    //   23: istore 4
    //   25: iload 4
    //   27: ifeq +267 -> 294
    //   30: iload 4
    //   32: bipush 8
    //   34: if_icmpeq +239 -> 273
    //   37: iload 4
    //   39: bipush 16
    //   41: if_icmpeq +187 -> 228
    //   44: iload 4
    //   46: bipush 24
    //   48: if_icmpeq +135 -> 183
    //   51: iload 4
    //   53: bipush 34
    //   55: if_icmpeq +106 -> 161
    //   58: iload 4
    //   60: bipush 42
    //   62: if_icmpeq +77 -> 139
    //   65: iload 4
    //   67: bipush 50
    //   69: if_icmpeq +48 -> 117
    //   72: iload 4
    //   74: bipush 56
    //   76: if_icmpeq +19 -> 95
    //   79: aload_0
    //   80: aload_1
    //   81: aload 5
    //   83: aload_2
    //   84: iload 4
    //   86: invokevirtual 74	com/tencent/ilink/tdi/b$m:parseUnknownField	(Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/UnknownFieldSet$Builder;Lcom/google/protobuf/ExtensionRegistryLite;I)Z
    //   89: ifne -74 -> 15
    //   92: goto +202 -> 294
    //   95: aload_0
    //   96: aload_0
    //   97: getfield 76	com/tencent/ilink/tdi/b$m:b	I
    //   100: bipush 64
    //   102: ior
    //   103: putfield 76	com/tencent/ilink/tdi/b$m:b	I
    //   106: aload_0
    //   107: aload_1
    //   108: invokevirtual 78	com/google/protobuf/CodedInputStream:f	()I
    //   111: putfield 80	com/tencent/ilink/tdi/b$m:i	I
    //   114: goto -99 -> 15
    //   117: aload_0
    //   118: aload_0
    //   119: getfield 76	com/tencent/ilink/tdi/b$m:b	I
    //   122: bipush 32
    //   124: ior
    //   125: putfield 76	com/tencent/ilink/tdi/b$m:b	I
    //   128: aload_0
    //   129: aload_1
    //   130: invokevirtual 84	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   133: putfield 55	com/tencent/ilink/tdi/b$m:h	Lcom/google/protobuf/ByteString;
    //   136: goto -121 -> 15
    //   139: aload_0
    //   140: aload_0
    //   141: getfield 76	com/tencent/ilink/tdi/b$m:b	I
    //   144: bipush 16
    //   146: ior
    //   147: putfield 76	com/tencent/ilink/tdi/b$m:b	I
    //   150: aload_0
    //   151: aload_1
    //   152: invokevirtual 84	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   155: putfield 53	com/tencent/ilink/tdi/b$m:g	Lcom/google/protobuf/ByteString;
    //   158: goto -143 -> 15
    //   161: aload_0
    //   162: aload_0
    //   163: getfield 76	com/tencent/ilink/tdi/b$m:b	I
    //   166: bipush 8
    //   168: ior
    //   169: putfield 76	com/tencent/ilink/tdi/b$m:b	I
    //   172: aload_0
    //   173: aload_1
    //   174: invokevirtual 84	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   177: putfield 51	com/tencent/ilink/tdi/b$m:f	Lcom/google/protobuf/ByteString;
    //   180: goto -165 -> 15
    //   183: aload_1
    //   184: invokevirtual 87	com/google/protobuf/CodedInputStream:n	()I
    //   187: istore 4
    //   189: iload 4
    //   191: invokestatic 92	com/tencent/ilink/tdi/a$b:a	(I)Lcom/tencent/ilink/tdi/a$b;
    //   194: ifnonnull +15 -> 209
    //   197: aload 5
    //   199: iconst_3
    //   200: iload 4
    //   202: invokevirtual 97	com/google/protobuf/UnknownFieldSet$Builder:a	(II)Lcom/google/protobuf/UnknownFieldSet$Builder;
    //   205: pop
    //   206: goto -191 -> 15
    //   209: aload_0
    //   210: aload_0
    //   211: getfield 76	com/tencent/ilink/tdi/b$m:b	I
    //   214: iconst_4
    //   215: ior
    //   216: putfield 76	com/tencent/ilink/tdi/b$m:b	I
    //   219: aload_0
    //   220: iload 4
    //   222: putfield 44	com/tencent/ilink/tdi/b$m:e	I
    //   225: goto -210 -> 15
    //   228: aload_1
    //   229: invokevirtual 87	com/google/protobuf/CodedInputStream:n	()I
    //   232: istore 4
    //   234: iload 4
    //   236: invokestatic 102	com/tencent/ilink/tdi/a$e:a	(I)Lcom/tencent/ilink/tdi/a$e;
    //   239: ifnonnull +15 -> 254
    //   242: aload 5
    //   244: iconst_2
    //   245: iload 4
    //   247: invokevirtual 97	com/google/protobuf/UnknownFieldSet$Builder:a	(II)Lcom/google/protobuf/UnknownFieldSet$Builder;
    //   250: pop
    //   251: goto -236 -> 15
    //   254: aload_0
    //   255: aload_0
    //   256: getfield 76	com/tencent/ilink/tdi/b$m:b	I
    //   259: iconst_2
    //   260: ior
    //   261: putfield 76	com/tencent/ilink/tdi/b$m:b	I
    //   264: aload_0
    //   265: iload 4
    //   267: putfield 42	com/tencent/ilink/tdi/b$m:d	I
    //   270: goto -255 -> 15
    //   273: aload_0
    //   274: aload_0
    //   275: getfield 76	com/tencent/ilink/tdi/b$m:b	I
    //   278: iconst_1
    //   279: ior
    //   280: putfield 76	com/tencent/ilink/tdi/b$m:b	I
    //   283: aload_0
    //   284: aload_1
    //   285: invokevirtual 105	com/google/protobuf/CodedInputStream:m	()I
    //   288: putfield 107	com/tencent/ilink/tdi/b$m:c	I
    //   291: goto -276 -> 15
    //   294: iconst_1
    //   295: istore_3
    //   296: goto -281 -> 15
    //   299: astore_1
    //   300: goto +24 -> 324
    //   303: astore_1
    //   304: new 58	com/google/protobuf/InvalidProtocolBufferException
    //   307: dup
    //   308: aload_1
    //   309: invokespecial 110	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/io/IOException;)V
    //   312: aload_0
    //   313: invokevirtual 114	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   316: athrow
    //   317: astore_1
    //   318: aload_1
    //   319: aload_0
    //   320: invokevirtual 114	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   323: athrow
    //   324: aload_0
    //   325: aload 5
    //   327: invokevirtual 117	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   330: putfield 121	com/tencent/ilink/tdi/b$m:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   333: aload_0
    //   334: invokevirtual 124	com/tencent/ilink/tdi/b$m:makeExtensionsImmutable	()V
    //   337: aload_1
    //   338: athrow
    //   339: aload_0
    //   340: aload 5
    //   342: invokevirtual 117	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   345: putfield 121	com/tencent/ilink/tdi/b$m:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   348: aload_0
    //   349: invokevirtual 124	com/tencent/ilink/tdi/b$m:makeExtensionsImmutable	()V
    //   352: return
    //   353: new 126	java/lang/NullPointerException
    //   356: dup
    //   357: invokespecial 127	java/lang/NullPointerException:<init>	()V
    //   360: astore_1
    //   361: goto +5 -> 366
    //   364: aload_1
    //   365: athrow
    //   366: goto -2 -> 364
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	369	0	this	m
    //   0	369	1	paramCodedInputStream	com.google.protobuf.CodedInputStream
    //   0	369	2	paramExtensionRegistryLite	com.google.protobuf.ExtensionRegistryLite
    //   14	282	3	m	int
    //   23	243	4	n	int
    //   11	330	5	localBuilder	com.google.protobuf.UnknownFieldSet.Builder
    // Exception table:
    //   from	to	target	type
    //   19	25	299	finally
    //   79	92	299	finally
    //   95	114	299	finally
    //   117	136	299	finally
    //   139	158	299	finally
    //   161	180	299	finally
    //   183	206	299	finally
    //   209	225	299	finally
    //   228	251	299	finally
    //   254	270	299	finally
    //   273	291	299	finally
    //   304	317	299	finally
    //   318	324	299	finally
    //   19	25	303	java/io/IOException
    //   79	92	303	java/io/IOException
    //   95	114	303	java/io/IOException
    //   117	136	303	java/io/IOException
    //   139	158	303	java/io/IOException
    //   161	180	303	java/io/IOException
    //   183	206	303	java/io/IOException
    //   209	225	303	java/io/IOException
    //   228	251	303	java/io/IOException
    //   254	270	303	java/io/IOException
    //   273	291	303	java/io/IOException
    //   19	25	317	com/google/protobuf/InvalidProtocolBufferException
    //   79	92	317	com/google/protobuf/InvalidProtocolBufferException
    //   95	114	317	com/google/protobuf/InvalidProtocolBufferException
    //   117	136	317	com/google/protobuf/InvalidProtocolBufferException
    //   139	158	317	com/google/protobuf/InvalidProtocolBufferException
    //   161	180	317	com/google/protobuf/InvalidProtocolBufferException
    //   183	206	317	com/google/protobuf/InvalidProtocolBufferException
    //   209	225	317	com/google/protobuf/InvalidProtocolBufferException
    //   228	251	317	com/google/protobuf/InvalidProtocolBufferException
    //   254	270	317	com/google/protobuf/InvalidProtocolBufferException
    //   273	291	317	com/google/protobuf/InvalidProtocolBufferException
  }
  
  private b$m(GeneratedMessageV3.Builder<?> paramBuilder)
  {
    super(paramBuilder);
  }
  
  public static final Descriptors.Descriptor a()
  {
    return b.j();
  }
  
  public static m a(byte[] paramArrayOfByte)
  {
    return (m)a.parseFrom(paramArrayOfByte);
  }
  
  public static b.m.a q()
  {
    return k.r();
  }
  
  public static m s()
  {
    return k;
  }
  
  protected b.m.a a(GeneratedMessageV3.BuilderParent paramBuilderParent)
  {
    return new b.m.a(paramBuilderParent, null);
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
  
  public a.e e()
  {
    a.e locale2 = a.e.a(this.d);
    a.e locale1 = locale2;
    if (locale2 == null) {
      locale1 = a.e.a;
    }
    return locale1;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof m)) {
      return super.equals(paramObject);
    }
    paramObject = (m)paramObject;
    if (b() != paramObject.b()) {
      return false;
    }
    if ((b()) && (c() != paramObject.c())) {
      return false;
    }
    if (d() != paramObject.d()) {
      return false;
    }
    if ((d()) && (this.d != paramObject.d)) {
      return false;
    }
    if (f() != paramObject.f()) {
      return false;
    }
    if ((f()) && (this.e != paramObject.e)) {
      return false;
    }
    if (h() != paramObject.h()) {
      return false;
    }
    if ((h()) && (!i().equals(paramObject.i()))) {
      return false;
    }
    if (j() != paramObject.j()) {
      return false;
    }
    if ((j()) && (!k().equals(paramObject.k()))) {
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
    if ((n()) && (o() != paramObject.o())) {
      return false;
    }
    return this.unknownFields.equals(paramObject.unknownFields);
  }
  
  public boolean f()
  {
    return (this.b & 0x4) != 0;
  }
  
  public a.b g()
  {
    a.b localb2 = a.b.a(this.e);
    a.b localb1 = localb2;
    if (localb2 == null) {
      localb1 = a.b.a;
    }
    return localb1;
  }
  
  public Parser<m> getParserForType()
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
      m = n + CodedOutputStream.m(2, this.d);
    }
    n = m;
    if ((this.b & 0x4) != 0) {
      n = m + CodedOutputStream.m(3, this.e);
    }
    m = n;
    if ((this.b & 0x8) != 0) {
      m = n + CodedOutputStream.c(4, this.f);
    }
    n = m;
    if ((this.b & 0x10) != 0) {
      n = m + CodedOutputStream.c(5, this.g);
    }
    m = n;
    if ((this.b & 0x20) != 0) {
      m = n + CodedOutputStream.c(6, this.h);
    }
    n = m;
    if ((this.b & 0x40) != 0) {
      n = m + CodedOutputStream.h(7, this.i);
    }
    m = n + this.unknownFields.getSerializedSize();
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
      n = (m * 37 + 2) * 53 + this.d;
    }
    m = n;
    if (f()) {
      m = (n * 37 + 3) * 53 + this.e;
    }
    n = m;
    if (h()) {
      n = (m * 37 + 4) * 53 + i().hashCode();
    }
    m = n;
    if (j()) {
      m = (n * 37 + 5) * 53 + k().hashCode();
    }
    n = m;
    if (l()) {
      n = (m * 37 + 6) * 53 + m().hashCode();
    }
    m = n;
    if (n()) {
      m = (n * 37 + 7) * 53 + o();
    }
    m = m * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = m;
    return m;
  }
  
  public ByteString i()
  {
    return this.f;
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return b.k().a(m.class, b.m.a.class);
  }
  
  public final boolean isInitialized()
  {
    int m = this.j;
    if (m == 1) {
      return true;
    }
    if (m == 0) {
      return false;
    }
    this.j = 1;
    return true;
  }
  
  public boolean j()
  {
    return (this.b & 0x10) != 0;
  }
  
  public ByteString k()
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
    return new m();
  }
  
  public int o()
  {
    return this.i;
  }
  
  public b.m.a p()
  {
    return q();
  }
  
  public b.m.a r()
  {
    if (this == k) {
      return new b.m.a(null);
    }
    return new b.m.a(null).a(this);
  }
  
  public m t()
  {
    return k;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
  {
    if ((this.b & 0x1) != 0) {
      paramCodedOutputStream.c(1, this.c);
    }
    if ((this.b & 0x2) != 0) {
      paramCodedOutputStream.g(2, this.d);
    }
    if ((this.b & 0x4) != 0) {
      paramCodedOutputStream.g(3, this.e);
    }
    if ((this.b & 0x8) != 0) {
      paramCodedOutputStream.a(4, this.f);
    }
    if ((this.b & 0x10) != 0) {
      paramCodedOutputStream.a(5, this.g);
    }
    if ((this.b & 0x20) != 0) {
      paramCodedOutputStream.a(6, this.h);
    }
    if ((this.b & 0x40) != 0) {
      paramCodedOutputStream.b(7, this.i);
    }
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilink.tdi.b.m
 * JD-Core Version:    0.7.0.1
 */