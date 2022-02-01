package com.tencent.ilink.tdi;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.GeneratedMessageV3.Builder;
import com.google.protobuf.GeneratedMessageV3.BuilderParent;
import com.google.protobuf.GeneratedMessageV3.FieldAccessorTable;
import com.google.protobuf.GeneratedMessageV3.UnusedPrivateParameter;
import com.google.protobuf.Internal;
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;

public final class b$c
  extends GeneratedMessageV3
  implements e
{
  @Deprecated
  public static final Parser<c> a = new b.c.1();
  private static final c m = new c();
  private int b;
  private int c;
  private int d;
  private int e;
  private volatile Object f;
  private ByteString g;
  private int h;
  private int i;
  private boolean j;
  private boolean k;
  private byte l = -1;
  
  private b$c()
  {
    this.d = 1;
    this.f = "";
    this.g = ByteString.EMPTY;
    this.h = 1;
  }
  
  /* Error */
  private b$c(com.google.protobuf.CodedInputStream paramCodedInputStream, com.google.protobuf.ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 33	com/tencent/ilink/tdi/b$c:<init>	()V
    //   4: aload_2
    //   5: ifnull +413 -> 418
    //   8: invokestatic 69	com/google/protobuf/UnknownFieldSet:a	()Lcom/google/protobuf/UnknownFieldSet$Builder;
    //   11: astore 5
    //   13: iconst_0
    //   14: istore_3
    //   15: iload_3
    //   16: ifne +388 -> 404
    //   19: aload_1
    //   20: invokevirtual 74	com/google/protobuf/CodedInputStream:a	()I
    //   23: istore 4
    //   25: iload 4
    //   27: ifeq +332 -> 359
    //   30: iload 4
    //   32: bipush 8
    //   34: if_icmpeq +304 -> 338
    //   37: iload 4
    //   39: bipush 16
    //   41: if_icmpeq +252 -> 293
    //   44: iload 4
    //   46: bipush 24
    //   48: if_icmpeq +224 -> 272
    //   51: iload 4
    //   53: bipush 34
    //   55: if_icmpeq +191 -> 246
    //   58: iload 4
    //   60: bipush 42
    //   62: if_icmpeq +162 -> 224
    //   65: iload 4
    //   67: bipush 48
    //   69: if_icmpeq +108 -> 177
    //   72: iload 4
    //   74: bipush 56
    //   76: if_icmpeq +79 -> 155
    //   79: iload 4
    //   81: bipush 64
    //   83: if_icmpeq +49 -> 132
    //   86: iload 4
    //   88: bipush 72
    //   90: if_icmpeq +19 -> 109
    //   93: aload_0
    //   94: aload_1
    //   95: aload 5
    //   97: aload_2
    //   98: iload 4
    //   100: invokevirtual 78	com/tencent/ilink/tdi/b$c:parseUnknownField	(Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/UnknownFieldSet$Builder;Lcom/google/protobuf/ExtensionRegistryLite;I)Z
    //   103: ifne -88 -> 15
    //   106: goto +253 -> 359
    //   109: aload_0
    //   110: aload_0
    //   111: getfield 80	com/tencent/ilink/tdi/b$c:b	I
    //   114: sipush 256
    //   117: ior
    //   118: putfield 80	com/tencent/ilink/tdi/b$c:b	I
    //   121: aload_0
    //   122: aload_1
    //   123: invokevirtual 83	com/google/protobuf/CodedInputStream:i	()Z
    //   126: putfield 85	com/tencent/ilink/tdi/b$c:k	Z
    //   129: goto -114 -> 15
    //   132: aload_0
    //   133: aload_0
    //   134: getfield 80	com/tencent/ilink/tdi/b$c:b	I
    //   137: sipush 128
    //   140: ior
    //   141: putfield 80	com/tencent/ilink/tdi/b$c:b	I
    //   144: aload_0
    //   145: aload_1
    //   146: invokevirtual 83	com/google/protobuf/CodedInputStream:i	()Z
    //   149: putfield 87	com/tencent/ilink/tdi/b$c:j	Z
    //   152: goto -137 -> 15
    //   155: aload_0
    //   156: aload_0
    //   157: getfield 80	com/tencent/ilink/tdi/b$c:b	I
    //   160: bipush 64
    //   162: ior
    //   163: putfield 80	com/tencent/ilink/tdi/b$c:b	I
    //   166: aload_0
    //   167: aload_1
    //   168: invokevirtual 89	com/google/protobuf/CodedInputStream:m	()I
    //   171: putfield 91	com/tencent/ilink/tdi/b$c:i	I
    //   174: goto -159 -> 15
    //   177: aload_1
    //   178: invokevirtual 94	com/google/protobuf/CodedInputStream:n	()I
    //   181: istore 4
    //   183: iload 4
    //   185: invokestatic 99	com/tencent/ilink/tdi/b$y:a	(I)Lcom/tencent/ilink/tdi/b$y;
    //   188: ifnonnull +16 -> 204
    //   191: aload 5
    //   193: bipush 6
    //   195: iload 4
    //   197: invokevirtual 104	com/google/protobuf/UnknownFieldSet$Builder:a	(II)Lcom/google/protobuf/UnknownFieldSet$Builder;
    //   200: pop
    //   201: goto -186 -> 15
    //   204: aload_0
    //   205: aload_0
    //   206: getfield 80	com/tencent/ilink/tdi/b$c:b	I
    //   209: bipush 32
    //   211: ior
    //   212: putfield 80	com/tencent/ilink/tdi/b$c:b	I
    //   215: aload_0
    //   216: iload 4
    //   218: putfield 59	com/tencent/ilink/tdi/b$c:h	I
    //   221: goto -206 -> 15
    //   224: aload_0
    //   225: aload_0
    //   226: getfield 80	com/tencent/ilink/tdi/b$c:b	I
    //   229: bipush 16
    //   231: ior
    //   232: putfield 80	com/tencent/ilink/tdi/b$c:b	I
    //   235: aload_0
    //   236: aload_1
    //   237: invokevirtual 107	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   240: putfield 57	com/tencent/ilink/tdi/b$c:g	Lcom/google/protobuf/ByteString;
    //   243: goto -228 -> 15
    //   246: aload_1
    //   247: invokevirtual 107	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   250: astore 6
    //   252: aload_0
    //   253: aload_0
    //   254: getfield 80	com/tencent/ilink/tdi/b$c:b	I
    //   257: bipush 8
    //   259: ior
    //   260: putfield 80	com/tencent/ilink/tdi/b$c:b	I
    //   263: aload_0
    //   264: aload 6
    //   266: putfield 50	com/tencent/ilink/tdi/b$c:f	Ljava/lang/Object;
    //   269: goto -254 -> 15
    //   272: aload_0
    //   273: aload_0
    //   274: getfield 80	com/tencent/ilink/tdi/b$c:b	I
    //   277: iconst_4
    //   278: ior
    //   279: putfield 80	com/tencent/ilink/tdi/b$c:b	I
    //   282: aload_0
    //   283: aload_1
    //   284: invokevirtual 89	com/google/protobuf/CodedInputStream:m	()I
    //   287: putfield 109	com/tencent/ilink/tdi/b$c:e	I
    //   290: goto -275 -> 15
    //   293: aload_1
    //   294: invokevirtual 94	com/google/protobuf/CodedInputStream:n	()I
    //   297: istore 4
    //   299: iload 4
    //   301: invokestatic 114	com/tencent/ilink/tdi/b$h:a	(I)Lcom/tencent/ilink/tdi/b$h;
    //   304: ifnonnull +15 -> 319
    //   307: aload 5
    //   309: iconst_2
    //   310: iload 4
    //   312: invokevirtual 104	com/google/protobuf/UnknownFieldSet$Builder:a	(II)Lcom/google/protobuf/UnknownFieldSet$Builder;
    //   315: pop
    //   316: goto -301 -> 15
    //   319: aload_0
    //   320: aload_0
    //   321: getfield 80	com/tencent/ilink/tdi/b$c:b	I
    //   324: iconst_2
    //   325: ior
    //   326: putfield 80	com/tencent/ilink/tdi/b$c:b	I
    //   329: aload_0
    //   330: iload 4
    //   332: putfield 46	com/tencent/ilink/tdi/b$c:d	I
    //   335: goto -320 -> 15
    //   338: aload_0
    //   339: aload_0
    //   340: getfield 80	com/tencent/ilink/tdi/b$c:b	I
    //   343: iconst_1
    //   344: ior
    //   345: putfield 80	com/tencent/ilink/tdi/b$c:b	I
    //   348: aload_0
    //   349: aload_1
    //   350: invokevirtual 89	com/google/protobuf/CodedInputStream:m	()I
    //   353: putfield 116	com/tencent/ilink/tdi/b$c:c	I
    //   356: goto -341 -> 15
    //   359: iconst_1
    //   360: istore_3
    //   361: goto -346 -> 15
    //   364: astore_1
    //   365: goto +24 -> 389
    //   368: astore_1
    //   369: new 62	com/google/protobuf/InvalidProtocolBufferException
    //   372: dup
    //   373: aload_1
    //   374: invokespecial 119	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/io/IOException;)V
    //   377: aload_0
    //   378: invokevirtual 123	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   381: athrow
    //   382: astore_1
    //   383: aload_1
    //   384: aload_0
    //   385: invokevirtual 123	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   388: athrow
    //   389: aload_0
    //   390: aload 5
    //   392: invokevirtual 126	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   395: putfield 130	com/tencent/ilink/tdi/b$c:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   398: aload_0
    //   399: invokevirtual 133	com/tencent/ilink/tdi/b$c:makeExtensionsImmutable	()V
    //   402: aload_1
    //   403: athrow
    //   404: aload_0
    //   405: aload 5
    //   407: invokevirtual 126	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   410: putfield 130	com/tencent/ilink/tdi/b$c:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   413: aload_0
    //   414: invokevirtual 133	com/tencent/ilink/tdi/b$c:makeExtensionsImmutable	()V
    //   417: return
    //   418: new 135	java/lang/NullPointerException
    //   421: dup
    //   422: invokespecial 136	java/lang/NullPointerException:<init>	()V
    //   425: astore_1
    //   426: goto +5 -> 431
    //   429: aload_1
    //   430: athrow
    //   431: goto -2 -> 429
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	434	0	this	c
    //   0	434	1	paramCodedInputStream	com.google.protobuf.CodedInputStream
    //   0	434	2	paramExtensionRegistryLite	com.google.protobuf.ExtensionRegistryLite
    //   14	347	3	n	int
    //   23	308	4	i1	int
    //   11	395	5	localBuilder	com.google.protobuf.UnknownFieldSet.Builder
    //   250	15	6	localByteString	ByteString
    // Exception table:
    //   from	to	target	type
    //   19	25	364	finally
    //   93	106	364	finally
    //   109	129	364	finally
    //   132	152	364	finally
    //   155	174	364	finally
    //   177	201	364	finally
    //   204	221	364	finally
    //   224	243	364	finally
    //   246	269	364	finally
    //   272	290	364	finally
    //   293	316	364	finally
    //   319	335	364	finally
    //   338	356	364	finally
    //   369	382	364	finally
    //   383	389	364	finally
    //   19	25	368	java/io/IOException
    //   93	106	368	java/io/IOException
    //   109	129	368	java/io/IOException
    //   132	152	368	java/io/IOException
    //   155	174	368	java/io/IOException
    //   177	201	368	java/io/IOException
    //   204	221	368	java/io/IOException
    //   224	243	368	java/io/IOException
    //   246	269	368	java/io/IOException
    //   272	290	368	java/io/IOException
    //   293	316	368	java/io/IOException
    //   319	335	368	java/io/IOException
    //   338	356	368	java/io/IOException
    //   19	25	382	com/google/protobuf/InvalidProtocolBufferException
    //   93	106	382	com/google/protobuf/InvalidProtocolBufferException
    //   109	129	382	com/google/protobuf/InvalidProtocolBufferException
    //   132	152	382	com/google/protobuf/InvalidProtocolBufferException
    //   155	174	382	com/google/protobuf/InvalidProtocolBufferException
    //   177	201	382	com/google/protobuf/InvalidProtocolBufferException
    //   204	221	382	com/google/protobuf/InvalidProtocolBufferException
    //   224	243	382	com/google/protobuf/InvalidProtocolBufferException
    //   246	269	382	com/google/protobuf/InvalidProtocolBufferException
    //   272	290	382	com/google/protobuf/InvalidProtocolBufferException
    //   293	316	382	com/google/protobuf/InvalidProtocolBufferException
    //   319	335	382	com/google/protobuf/InvalidProtocolBufferException
    //   338	356	382	com/google/protobuf/InvalidProtocolBufferException
  }
  
  private b$c(GeneratedMessageV3.Builder<?> paramBuilder)
  {
    super(paramBuilder);
  }
  
  public static final Descriptors.Descriptor a()
  {
    return b.D();
  }
  
  public static c a(byte[] paramArrayOfByte)
  {
    return (c)a.parseFrom(paramArrayOfByte);
  }
  
  public static b.c.a u()
  {
    return m.v();
  }
  
  public static c w()
  {
    return m;
  }
  
  protected b.c.a a(GeneratedMessageV3.BuilderParent paramBuilderParent)
  {
    return new b.c.a(paramBuilderParent, null);
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
  
  public b.h e()
  {
    b.h localh2 = b.h.a(this.d);
    b.h localh1 = localh2;
    if (localh2 == null) {
      localh1 = b.h.b;
    }
    return localh1;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof c)) {
      return super.equals(paramObject);
    }
    paramObject = (c)paramObject;
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
    if ((f()) && (g() != paramObject.g())) {
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
    if ((l()) && (this.h != paramObject.h)) {
      return false;
    }
    if (n() != paramObject.n()) {
      return false;
    }
    if ((n()) && (o() != paramObject.o())) {
      return false;
    }
    if (p() != paramObject.p()) {
      return false;
    }
    if ((p()) && (q() != paramObject.q())) {
      return false;
    }
    if (r() != paramObject.r()) {
      return false;
    }
    if ((r()) && (s() != paramObject.s())) {
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
  
  public Parser<c> getParserForType()
  {
    return a;
  }
  
  public int getSerializedSize()
  {
    int n = this.memoizedSize;
    if (n != -1) {
      return n;
    }
    int i1 = 0;
    if ((this.b & 0x1) != 0) {
      i1 = 0 + CodedOutputStream.i(1, this.c);
    }
    n = i1;
    if ((this.b & 0x2) != 0) {
      n = i1 + CodedOutputStream.m(2, this.d);
    }
    i1 = n;
    if ((this.b & 0x4) != 0) {
      i1 = n + CodedOutputStream.i(3, this.e);
    }
    n = i1;
    if ((this.b & 0x8) != 0) {
      n = i1 + GeneratedMessageV3.computeStringSize(4, this.f);
    }
    i1 = n;
    if ((this.b & 0x10) != 0) {
      i1 = n + CodedOutputStream.c(5, this.g);
    }
    n = i1;
    if ((this.b & 0x20) != 0) {
      n = i1 + CodedOutputStream.m(6, this.h);
    }
    i1 = n;
    if ((this.b & 0x40) != 0) {
      i1 = n + CodedOutputStream.i(7, this.i);
    }
    n = i1;
    if ((this.b & 0x80) != 0) {
      n = i1 + CodedOutputStream.b(8, this.j);
    }
    i1 = n;
    if ((this.b & 0x100) != 0) {
      i1 = n + CodedOutputStream.b(9, this.k);
    }
    n = i1 + this.unknownFields.getSerializedSize();
    this.memoizedSize = n;
    return n;
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
    int i1 = 779 + a().hashCode();
    int n = i1;
    if (b()) {
      n = (i1 * 37 + 1) * 53 + c();
    }
    i1 = n;
    if (d()) {
      i1 = (n * 37 + 2) * 53 + this.d;
    }
    n = i1;
    if (f()) {
      n = (i1 * 37 + 3) * 53 + g();
    }
    i1 = n;
    if (h()) {
      i1 = (n * 37 + 4) * 53 + i().hashCode();
    }
    n = i1;
    if (j()) {
      n = (i1 * 37 + 5) * 53 + k().hashCode();
    }
    i1 = n;
    if (l()) {
      i1 = (n * 37 + 6) * 53 + this.h;
    }
    n = i1;
    if (n()) {
      n = (i1 * 37 + 7) * 53 + o();
    }
    i1 = n;
    if (p()) {
      i1 = (n * 37 + 8) * 53 + Internal.a(q());
    }
    n = i1;
    if (r()) {
      n = (i1 * 37 + 9) * 53 + Internal.a(s());
    }
    n = n * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = n;
    return n;
  }
  
  public String i()
  {
    Object localObject = this.f;
    if ((localObject instanceof String)) {
      return (String)localObject;
    }
    localObject = (ByteString)localObject;
    String str = ((ByteString)localObject).toStringUtf8();
    if (((ByteString)localObject).isValidUtf8()) {
      this.f = str;
    }
    return str;
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return b.E().a(c.class, b.c.a.class);
  }
  
  public final boolean isInitialized()
  {
    int n = this.l;
    if (n == 1) {
      return true;
    }
    if (n == 0) {
      return false;
    }
    this.l = 1;
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
  
  public b.y m()
  {
    b.y localy2 = b.y.a(this.h);
    b.y localy1 = localy2;
    if (localy2 == null) {
      localy1 = b.y.b;
    }
    return localy1;
  }
  
  public boolean n()
  {
    return (this.b & 0x40) != 0;
  }
  
  protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter paramUnusedPrivateParameter)
  {
    return new c();
  }
  
  public int o()
  {
    return this.i;
  }
  
  public boolean p()
  {
    return (this.b & 0x80) != 0;
  }
  
  public boolean q()
  {
    return this.j;
  }
  
  public boolean r()
  {
    return (this.b & 0x100) != 0;
  }
  
  public boolean s()
  {
    return this.k;
  }
  
  public b.c.a t()
  {
    return u();
  }
  
  public b.c.a v()
  {
    if (this == m) {
      return new b.c.a(null);
    }
    return new b.c.a(null).a(this);
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
      paramCodedOutputStream.c(3, this.e);
    }
    if ((this.b & 0x8) != 0) {
      GeneratedMessageV3.writeString(paramCodedOutputStream, 4, this.f);
    }
    if ((this.b & 0x10) != 0) {
      paramCodedOutputStream.a(5, this.g);
    }
    if ((this.b & 0x20) != 0) {
      paramCodedOutputStream.g(6, this.h);
    }
    if ((this.b & 0x40) != 0) {
      paramCodedOutputStream.c(7, this.i);
    }
    if ((this.b & 0x80) != 0) {
      paramCodedOutputStream.a(8, this.j);
    }
    if ((this.b & 0x100) != 0) {
      paramCodedOutputStream.a(9, this.k);
    }
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
  
  public c x()
  {
    return m;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilink.tdi.b.c
 * JD-Core Version:    0.7.0.1
 */