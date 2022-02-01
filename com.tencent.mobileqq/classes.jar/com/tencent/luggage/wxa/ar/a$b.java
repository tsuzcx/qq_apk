package com.tencent.luggage.wxa.ar;

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

public final class a$b
  extends GeneratedMessageV3
  implements c
{
  @Deprecated
  public static final Parser<b> a = new a.b.1();
  private static final b m = new b();
  private int b;
  private volatile Object c;
  private long d;
  private volatile Object e;
  private volatile Object f;
  private volatile Object g;
  private volatile Object h;
  private volatile Object i;
  private volatile Object j;
  private volatile Object k;
  private byte l = -1;
  
  private a$b()
  {
    this.c = "";
    this.e = "";
    this.f = "";
    this.g = "";
    this.h = "";
    this.i = "";
    this.j = "";
    this.k = "";
  }
  
  /* Error */
  private a$b(com.google.protobuf.CodedInputStream paramCodedInputStream, com.google.protobuf.ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 32	com/tencent/luggage/wxa/ar/a$b:<init>	()V
    //   4: aload_2
    //   5: ifnull +392 -> 397
    //   8: invokestatic 71	com/google/protobuf/UnknownFieldSet:a	()Lcom/google/protobuf/UnknownFieldSet$Builder;
    //   11: astore 5
    //   13: iconst_0
    //   14: istore_3
    //   15: iload_3
    //   16: ifne +367 -> 383
    //   19: aload_1
    //   20: invokevirtual 76	com/google/protobuf/CodedInputStream:a	()I
    //   23: istore 4
    //   25: iload 4
    //   27: ifeq +311 -> 338
    //   30: iload 4
    //   32: bipush 10
    //   34: if_icmpeq +279 -> 313
    //   37: iload 4
    //   39: bipush 16
    //   41: if_icmpeq +251 -> 292
    //   44: iload 4
    //   46: bipush 26
    //   48: if_icmpeq +219 -> 267
    //   51: iload 4
    //   53: bipush 34
    //   55: if_icmpeq +186 -> 241
    //   58: iload 4
    //   60: bipush 42
    //   62: if_icmpeq +153 -> 215
    //   65: iload 4
    //   67: bipush 50
    //   69: if_icmpeq +120 -> 189
    //   72: iload 4
    //   74: bipush 58
    //   76: if_icmpeq +87 -> 163
    //   79: iload 4
    //   81: bipush 66
    //   83: if_icmpeq +53 -> 136
    //   86: iload 4
    //   88: bipush 74
    //   90: if_icmpeq +19 -> 109
    //   93: aload_0
    //   94: aload_1
    //   95: aload 5
    //   97: aload_2
    //   98: iload 4
    //   100: invokevirtual 80	com/tencent/luggage/wxa/ar/a$b:parseUnknownField	(Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/UnknownFieldSet$Builder;Lcom/google/protobuf/ExtensionRegistryLite;I)Z
    //   103: ifne -88 -> 15
    //   106: goto +232 -> 338
    //   109: aload_1
    //   110: invokevirtual 83	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   113: astore 6
    //   115: aload_0
    //   116: aload_0
    //   117: getfield 85	com/tencent/luggage/wxa/ar/a$b:b	I
    //   120: sipush 256
    //   123: ior
    //   124: putfield 85	com/tencent/luggage/wxa/ar/a$b:b	I
    //   127: aload_0
    //   128: aload 6
    //   130: putfield 61	com/tencent/luggage/wxa/ar/a$b:k	Ljava/lang/Object;
    //   133: goto -118 -> 15
    //   136: aload_1
    //   137: invokevirtual 83	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   140: astore 6
    //   142: aload_0
    //   143: aload_0
    //   144: getfield 85	com/tencent/luggage/wxa/ar/a$b:b	I
    //   147: sipush 128
    //   150: ior
    //   151: putfield 85	com/tencent/luggage/wxa/ar/a$b:b	I
    //   154: aload_0
    //   155: aload 6
    //   157: putfield 59	com/tencent/luggage/wxa/ar/a$b:j	Ljava/lang/Object;
    //   160: goto -145 -> 15
    //   163: aload_1
    //   164: invokevirtual 83	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   167: astore 6
    //   169: aload_0
    //   170: aload_0
    //   171: getfield 85	com/tencent/luggage/wxa/ar/a$b:b	I
    //   174: bipush 64
    //   176: ior
    //   177: putfield 85	com/tencent/luggage/wxa/ar/a$b:b	I
    //   180: aload_0
    //   181: aload 6
    //   183: putfield 57	com/tencent/luggage/wxa/ar/a$b:i	Ljava/lang/Object;
    //   186: goto -171 -> 15
    //   189: aload_1
    //   190: invokevirtual 83	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   193: astore 6
    //   195: aload_0
    //   196: aload_0
    //   197: getfield 85	com/tencent/luggage/wxa/ar/a$b:b	I
    //   200: bipush 32
    //   202: ior
    //   203: putfield 85	com/tencent/luggage/wxa/ar/a$b:b	I
    //   206: aload_0
    //   207: aload 6
    //   209: putfield 55	com/tencent/luggage/wxa/ar/a$b:h	Ljava/lang/Object;
    //   212: goto -197 -> 15
    //   215: aload_1
    //   216: invokevirtual 83	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   219: astore 6
    //   221: aload_0
    //   222: aload_0
    //   223: getfield 85	com/tencent/luggage/wxa/ar/a$b:b	I
    //   226: bipush 16
    //   228: ior
    //   229: putfield 85	com/tencent/luggage/wxa/ar/a$b:b	I
    //   232: aload_0
    //   233: aload 6
    //   235: putfield 53	com/tencent/luggage/wxa/ar/a$b:g	Ljava/lang/Object;
    //   238: goto -223 -> 15
    //   241: aload_1
    //   242: invokevirtual 83	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   245: astore 6
    //   247: aload_0
    //   248: aload_0
    //   249: getfield 85	com/tencent/luggage/wxa/ar/a$b:b	I
    //   252: bipush 8
    //   254: ior
    //   255: putfield 85	com/tencent/luggage/wxa/ar/a$b:b	I
    //   258: aload_0
    //   259: aload 6
    //   261: putfield 51	com/tencent/luggage/wxa/ar/a$b:f	Ljava/lang/Object;
    //   264: goto -249 -> 15
    //   267: aload_1
    //   268: invokevirtual 83	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   271: astore 6
    //   273: aload_0
    //   274: aload_0
    //   275: getfield 85	com/tencent/luggage/wxa/ar/a$b:b	I
    //   278: iconst_4
    //   279: ior
    //   280: putfield 85	com/tencent/luggage/wxa/ar/a$b:b	I
    //   283: aload_0
    //   284: aload 6
    //   286: putfield 49	com/tencent/luggage/wxa/ar/a$b:e	Ljava/lang/Object;
    //   289: goto -274 -> 15
    //   292: aload_0
    //   293: aload_0
    //   294: getfield 85	com/tencent/luggage/wxa/ar/a$b:b	I
    //   297: iconst_2
    //   298: ior
    //   299: putfield 85	com/tencent/luggage/wxa/ar/a$b:b	I
    //   302: aload_0
    //   303: aload_1
    //   304: invokevirtual 88	com/google/protobuf/CodedInputStream:d	()J
    //   307: putfield 90	com/tencent/luggage/wxa/ar/a$b:d	J
    //   310: goto -295 -> 15
    //   313: aload_1
    //   314: invokevirtual 83	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   317: astore 6
    //   319: aload_0
    //   320: iconst_1
    //   321: aload_0
    //   322: getfield 85	com/tencent/luggage/wxa/ar/a$b:b	I
    //   325: ior
    //   326: putfield 85	com/tencent/luggage/wxa/ar/a$b:b	I
    //   329: aload_0
    //   330: aload 6
    //   332: putfield 47	com/tencent/luggage/wxa/ar/a$b:c	Ljava/lang/Object;
    //   335: goto -320 -> 15
    //   338: iconst_1
    //   339: istore_3
    //   340: goto -325 -> 15
    //   343: astore_1
    //   344: goto +24 -> 368
    //   347: astore_1
    //   348: new 64	com/google/protobuf/InvalidProtocolBufferException
    //   351: dup
    //   352: aload_1
    //   353: invokespecial 93	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/io/IOException;)V
    //   356: aload_0
    //   357: invokevirtual 97	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   360: athrow
    //   361: astore_1
    //   362: aload_1
    //   363: aload_0
    //   364: invokevirtual 97	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   367: athrow
    //   368: aload_0
    //   369: aload 5
    //   371: invokevirtual 102	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   374: putfield 106	com/tencent/luggage/wxa/ar/a$b:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   377: aload_0
    //   378: invokevirtual 109	com/tencent/luggage/wxa/ar/a$b:makeExtensionsImmutable	()V
    //   381: aload_1
    //   382: athrow
    //   383: aload_0
    //   384: aload 5
    //   386: invokevirtual 102	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   389: putfield 106	com/tencent/luggage/wxa/ar/a$b:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   392: aload_0
    //   393: invokevirtual 109	com/tencent/luggage/wxa/ar/a$b:makeExtensionsImmutable	()V
    //   396: return
    //   397: new 111	java/lang/NullPointerException
    //   400: dup
    //   401: invokespecial 112	java/lang/NullPointerException:<init>	()V
    //   404: astore_1
    //   405: goto +5 -> 410
    //   408: aload_1
    //   409: athrow
    //   410: goto -2 -> 408
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	413	0	this	b
    //   0	413	1	paramCodedInputStream	com.google.protobuf.CodedInputStream
    //   0	413	2	paramExtensionRegistryLite	com.google.protobuf.ExtensionRegistryLite
    //   14	326	3	n	int
    //   23	76	4	i1	int
    //   11	374	5	localBuilder	com.google.protobuf.UnknownFieldSet.Builder
    //   113	218	6	localByteString	ByteString
    // Exception table:
    //   from	to	target	type
    //   19	25	343	finally
    //   93	106	343	finally
    //   109	133	343	finally
    //   136	160	343	finally
    //   163	186	343	finally
    //   189	212	343	finally
    //   215	238	343	finally
    //   241	264	343	finally
    //   267	289	343	finally
    //   292	310	343	finally
    //   313	335	343	finally
    //   348	361	343	finally
    //   362	368	343	finally
    //   19	25	347	java/io/IOException
    //   93	106	347	java/io/IOException
    //   109	133	347	java/io/IOException
    //   136	160	347	java/io/IOException
    //   163	186	347	java/io/IOException
    //   189	212	347	java/io/IOException
    //   215	238	347	java/io/IOException
    //   241	264	347	java/io/IOException
    //   267	289	347	java/io/IOException
    //   292	310	347	java/io/IOException
    //   313	335	347	java/io/IOException
    //   19	25	361	com/google/protobuf/InvalidProtocolBufferException
    //   93	106	361	com/google/protobuf/InvalidProtocolBufferException
    //   109	133	361	com/google/protobuf/InvalidProtocolBufferException
    //   136	160	361	com/google/protobuf/InvalidProtocolBufferException
    //   163	186	361	com/google/protobuf/InvalidProtocolBufferException
    //   189	212	361	com/google/protobuf/InvalidProtocolBufferException
    //   215	238	361	com/google/protobuf/InvalidProtocolBufferException
    //   241	264	361	com/google/protobuf/InvalidProtocolBufferException
    //   267	289	361	com/google/protobuf/InvalidProtocolBufferException
    //   292	310	361	com/google/protobuf/InvalidProtocolBufferException
    //   313	335	361	com/google/protobuf/InvalidProtocolBufferException
  }
  
  private a$b(GeneratedMessageV3.Builder<?> paramBuilder)
  {
    super(paramBuilder);
  }
  
  public static final Descriptors.Descriptor a()
  {
    return a.f();
  }
  
  public static b a(byte[] paramArrayOfByte)
  {
    return (b)a.parseFrom(paramArrayOfByte);
  }
  
  public static a.b.a u()
  {
    return m.v();
  }
  
  public static b w()
  {
    return m;
  }
  
  protected a.b.a a(GeneratedMessageV3.BuilderParent paramBuilderParent)
  {
    return new a.b.a(paramBuilderParent, null);
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
  
  public long e()
  {
    return this.d;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof b)) {
      return super.equals(paramObject);
    }
    paramObject = (b)paramObject;
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
    if ((f()) && (!g().equals(paramObject.g()))) {
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
    if ((n()) && (!o().equals(paramObject.o()))) {
      return false;
    }
    if (p() != paramObject.p()) {
      return false;
    }
    if ((p()) && (!q().equals(paramObject.q()))) {
      return false;
    }
    if (r() != paramObject.r()) {
      return false;
    }
    if ((r()) && (!s().equals(paramObject.s()))) {
      return false;
    }
    return this.unknownFields.equals(paramObject.unknownFields);
  }
  
  public boolean f()
  {
    return (this.b & 0x4) != 0;
  }
  
  public String g()
  {
    Object localObject = this.e;
    if ((localObject instanceof String)) {
      return (String)localObject;
    }
    localObject = (ByteString)localObject;
    String str = ((ByteString)localObject).toStringUtf8();
    if (((ByteString)localObject).isValidUtf8()) {
      this.e = str;
    }
    return str;
  }
  
  public Parser<b> getParserForType()
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
      i1 = 0 + GeneratedMessageV3.computeStringSize(1, this.c);
    }
    n = i1;
    if ((this.b & 0x2) != 0) {
      n = i1 + CodedOutputStream.g(2, this.d);
    }
    i1 = n;
    if ((this.b & 0x4) != 0) {
      i1 = n + GeneratedMessageV3.computeStringSize(3, this.e);
    }
    n = i1;
    if ((this.b & 0x8) != 0) {
      n = i1 + GeneratedMessageV3.computeStringSize(4, this.f);
    }
    i1 = n;
    if ((this.b & 0x10) != 0) {
      i1 = n + GeneratedMessageV3.computeStringSize(5, this.g);
    }
    n = i1;
    if ((this.b & 0x20) != 0) {
      n = i1 + GeneratedMessageV3.computeStringSize(6, this.h);
    }
    i1 = n;
    if ((this.b & 0x40) != 0) {
      i1 = n + GeneratedMessageV3.computeStringSize(7, this.i);
    }
    n = i1;
    if ((this.b & 0x80) != 0) {
      n = i1 + GeneratedMessageV3.computeStringSize(8, this.j);
    }
    i1 = n;
    if ((this.b & 0x100) != 0) {
      i1 = n + GeneratedMessageV3.computeStringSize(9, this.k);
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
      n = (i1 * 37 + 1) * 53 + c().hashCode();
    }
    i1 = n;
    if (d()) {
      i1 = (n * 37 + 2) * 53 + Internal.a(e());
    }
    n = i1;
    if (f()) {
      n = (i1 * 37 + 3) * 53 + g().hashCode();
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
      i1 = (n * 37 + 6) * 53 + m().hashCode();
    }
    n = i1;
    if (n()) {
      n = (i1 * 37 + 7) * 53 + o().hashCode();
    }
    i1 = n;
    if (p()) {
      i1 = (n * 37 + 8) * 53 + q().hashCode();
    }
    n = i1;
    if (r()) {
      n = (i1 * 37 + 9) * 53 + s().hashCode();
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
    return a.g().a(b.class, a.b.a.class);
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
  
  public String k()
  {
    Object localObject = this.g;
    if ((localObject instanceof String)) {
      return (String)localObject;
    }
    localObject = (ByteString)localObject;
    String str = ((ByteString)localObject).toStringUtf8();
    if (((ByteString)localObject).isValidUtf8()) {
      this.g = str;
    }
    return str;
  }
  
  public boolean l()
  {
    return (this.b & 0x20) != 0;
  }
  
  public String m()
  {
    Object localObject = this.h;
    if ((localObject instanceof String)) {
      return (String)localObject;
    }
    localObject = (ByteString)localObject;
    String str = ((ByteString)localObject).toStringUtf8();
    if (((ByteString)localObject).isValidUtf8()) {
      this.h = str;
    }
    return str;
  }
  
  public boolean n()
  {
    return (this.b & 0x40) != 0;
  }
  
  protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter paramUnusedPrivateParameter)
  {
    return new b();
  }
  
  public String o()
  {
    Object localObject = this.i;
    if ((localObject instanceof String)) {
      return (String)localObject;
    }
    localObject = (ByteString)localObject;
    String str = ((ByteString)localObject).toStringUtf8();
    if (((ByteString)localObject).isValidUtf8()) {
      this.i = str;
    }
    return str;
  }
  
  public boolean p()
  {
    return (this.b & 0x80) != 0;
  }
  
  public String q()
  {
    Object localObject = this.j;
    if ((localObject instanceof String)) {
      return (String)localObject;
    }
    localObject = (ByteString)localObject;
    String str = ((ByteString)localObject).toStringUtf8();
    if (((ByteString)localObject).isValidUtf8()) {
      this.j = str;
    }
    return str;
  }
  
  public boolean r()
  {
    return (this.b & 0x100) != 0;
  }
  
  public String s()
  {
    Object localObject = this.k;
    if ((localObject instanceof String)) {
      return (String)localObject;
    }
    localObject = (ByteString)localObject;
    String str = ((ByteString)localObject).toStringUtf8();
    if (((ByteString)localObject).isValidUtf8()) {
      this.k = str;
    }
    return str;
  }
  
  public a.b.a t()
  {
    return u();
  }
  
  public a.b.a v()
  {
    if (this == m) {
      return new a.b.a(null);
    }
    return new a.b.a(null).a(this);
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
  {
    if ((this.b & 0x1) != 0) {
      GeneratedMessageV3.writeString(paramCodedOutputStream, 1, this.c);
    }
    if ((this.b & 0x2) != 0) {
      paramCodedOutputStream.b(2, this.d);
    }
    if ((this.b & 0x4) != 0) {
      GeneratedMessageV3.writeString(paramCodedOutputStream, 3, this.e);
    }
    if ((this.b & 0x8) != 0) {
      GeneratedMessageV3.writeString(paramCodedOutputStream, 4, this.f);
    }
    if ((this.b & 0x10) != 0) {
      GeneratedMessageV3.writeString(paramCodedOutputStream, 5, this.g);
    }
    if ((this.b & 0x20) != 0) {
      GeneratedMessageV3.writeString(paramCodedOutputStream, 6, this.h);
    }
    if ((this.b & 0x40) != 0) {
      GeneratedMessageV3.writeString(paramCodedOutputStream, 7, this.i);
    }
    if ((this.b & 0x80) != 0) {
      GeneratedMessageV3.writeString(paramCodedOutputStream, 8, this.j);
    }
    if ((this.b & 0x100) != 0) {
      GeneratedMessageV3.writeString(paramCodedOutputStream, 9, this.k);
    }
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
  
  public b x()
  {
    return m;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ar.a.b
 * JD-Core Version:    0.7.0.1
 */