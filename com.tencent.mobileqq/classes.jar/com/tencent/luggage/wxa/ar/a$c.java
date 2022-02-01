package com.tencent.luggage.wxa.ar;

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

public final class a$c
  extends GeneratedMessageV3
  implements d
{
  @Deprecated
  public static final Parser<c> a = new a.c.1();
  private static final c n = new c();
  private int b;
  private volatile Object c;
  private volatile Object d;
  private volatile Object e;
  private volatile Object f;
  private int g;
  private int h;
  private int i;
  private volatile Object j;
  private volatile Object k;
  private volatile Object l;
  private byte m = -1;
  
  private a$c()
  {
    this.c = "";
    this.d = "";
    this.e = "";
    this.f = "";
    this.j = "";
    this.k = "";
    this.l = "";
  }
  
  /* Error */
  private a$c(com.google.protobuf.CodedInputStream paramCodedInputStream, com.google.protobuf.ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 32	com/tencent/luggage/wxa/ar/a$c:<init>	()V
    //   4: aload_2
    //   5: ifnull +449 -> 454
    //   8: invokestatic 69	com/google/protobuf/UnknownFieldSet:a	()Lcom/google/protobuf/UnknownFieldSet$Builder;
    //   11: astore 6
    //   13: iconst_0
    //   14: istore_3
    //   15: iload_3
    //   16: ifne +424 -> 440
    //   19: aload_1
    //   20: invokevirtual 74	com/google/protobuf/CodedInputStream:a	()I
    //   23: istore 4
    //   25: iload 4
    //   27: lookupswitch	default:+443->470, 0:+360->387, 10:+335->362, 18:+310->337, 26:+285->312, 34:+259->286, 40:+237->264, 48:+215->242, 56:+193->220, 66:+166->193, 74:+139->166, 82:+112->139
    //   125: aload_1
    //   126: aload 6
    //   128: aload_2
    //   129: iload 4
    //   131: invokevirtual 78	com/tencent/luggage/wxa/ar/a$c:parseUnknownField	(Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/UnknownFieldSet$Builder;Lcom/google/protobuf/ExtensionRegistryLite;I)Z
    //   134: istore 5
    //   136: goto +256 -> 392
    //   139: aload_1
    //   140: invokevirtual 81	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   143: astore 7
    //   145: aload_0
    //   146: aload_0
    //   147: getfield 83	com/tencent/luggage/wxa/ar/a$c:b	I
    //   150: sipush 512
    //   153: ior
    //   154: putfield 83	com/tencent/luggage/wxa/ar/a$c:b	I
    //   157: aload_0
    //   158: aload 7
    //   160: putfield 59	com/tencent/luggage/wxa/ar/a$c:l	Ljava/lang/Object;
    //   163: goto -148 -> 15
    //   166: aload_1
    //   167: invokevirtual 81	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   170: astore 7
    //   172: aload_0
    //   173: aload_0
    //   174: getfield 83	com/tencent/luggage/wxa/ar/a$c:b	I
    //   177: sipush 256
    //   180: ior
    //   181: putfield 83	com/tencent/luggage/wxa/ar/a$c:b	I
    //   184: aload_0
    //   185: aload 7
    //   187: putfield 57	com/tencent/luggage/wxa/ar/a$c:k	Ljava/lang/Object;
    //   190: goto -175 -> 15
    //   193: aload_1
    //   194: invokevirtual 81	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   197: astore 7
    //   199: aload_0
    //   200: aload_0
    //   201: getfield 83	com/tencent/luggage/wxa/ar/a$c:b	I
    //   204: sipush 128
    //   207: ior
    //   208: putfield 83	com/tencent/luggage/wxa/ar/a$c:b	I
    //   211: aload_0
    //   212: aload 7
    //   214: putfield 55	com/tencent/luggage/wxa/ar/a$c:j	Ljava/lang/Object;
    //   217: goto -202 -> 15
    //   220: aload_0
    //   221: aload_0
    //   222: getfield 83	com/tencent/luggage/wxa/ar/a$c:b	I
    //   225: bipush 64
    //   227: ior
    //   228: putfield 83	com/tencent/luggage/wxa/ar/a$c:b	I
    //   231: aload_0
    //   232: aload_1
    //   233: invokevirtual 85	com/google/protobuf/CodedInputStream:m	()I
    //   236: putfield 87	com/tencent/luggage/wxa/ar/a$c:i	I
    //   239: goto -224 -> 15
    //   242: aload_0
    //   243: aload_0
    //   244: getfield 83	com/tencent/luggage/wxa/ar/a$c:b	I
    //   247: bipush 32
    //   249: ior
    //   250: putfield 83	com/tencent/luggage/wxa/ar/a$c:b	I
    //   253: aload_0
    //   254: aload_1
    //   255: invokevirtual 85	com/google/protobuf/CodedInputStream:m	()I
    //   258: putfield 89	com/tencent/luggage/wxa/ar/a$c:h	I
    //   261: goto -246 -> 15
    //   264: aload_0
    //   265: aload_0
    //   266: getfield 83	com/tencent/luggage/wxa/ar/a$c:b	I
    //   269: bipush 16
    //   271: ior
    //   272: putfield 83	com/tencent/luggage/wxa/ar/a$c:b	I
    //   275: aload_0
    //   276: aload_1
    //   277: invokevirtual 85	com/google/protobuf/CodedInputStream:m	()I
    //   280: putfield 91	com/tencent/luggage/wxa/ar/a$c:g	I
    //   283: goto -268 -> 15
    //   286: aload_1
    //   287: invokevirtual 81	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   290: astore 7
    //   292: aload_0
    //   293: aload_0
    //   294: getfield 83	com/tencent/luggage/wxa/ar/a$c:b	I
    //   297: bipush 8
    //   299: ior
    //   300: putfield 83	com/tencent/luggage/wxa/ar/a$c:b	I
    //   303: aload_0
    //   304: aload 7
    //   306: putfield 53	com/tencent/luggage/wxa/ar/a$c:f	Ljava/lang/Object;
    //   309: goto -294 -> 15
    //   312: aload_1
    //   313: invokevirtual 81	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   316: astore 7
    //   318: aload_0
    //   319: aload_0
    //   320: getfield 83	com/tencent/luggage/wxa/ar/a$c:b	I
    //   323: iconst_4
    //   324: ior
    //   325: putfield 83	com/tencent/luggage/wxa/ar/a$c:b	I
    //   328: aload_0
    //   329: aload 7
    //   331: putfield 51	com/tencent/luggage/wxa/ar/a$c:e	Ljava/lang/Object;
    //   334: goto -319 -> 15
    //   337: aload_1
    //   338: invokevirtual 81	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   341: astore 7
    //   343: aload_0
    //   344: aload_0
    //   345: getfield 83	com/tencent/luggage/wxa/ar/a$c:b	I
    //   348: iconst_2
    //   349: ior
    //   350: putfield 83	com/tencent/luggage/wxa/ar/a$c:b	I
    //   353: aload_0
    //   354: aload 7
    //   356: putfield 49	com/tencent/luggage/wxa/ar/a$c:d	Ljava/lang/Object;
    //   359: goto -344 -> 15
    //   362: aload_1
    //   363: invokevirtual 81	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   366: astore 7
    //   368: aload_0
    //   369: iconst_1
    //   370: aload_0
    //   371: getfield 83	com/tencent/luggage/wxa/ar/a$c:b	I
    //   374: ior
    //   375: putfield 83	com/tencent/luggage/wxa/ar/a$c:b	I
    //   378: aload_0
    //   379: aload 7
    //   381: putfield 47	com/tencent/luggage/wxa/ar/a$c:c	Ljava/lang/Object;
    //   384: goto -369 -> 15
    //   387: iconst_1
    //   388: istore_3
    //   389: goto -374 -> 15
    //   392: iload 5
    //   394: ifne -379 -> 15
    //   397: goto -10 -> 387
    //   400: astore_1
    //   401: goto +24 -> 425
    //   404: astore_1
    //   405: new 62	com/google/protobuf/InvalidProtocolBufferException
    //   408: dup
    //   409: aload_1
    //   410: invokespecial 94	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/io/IOException;)V
    //   413: aload_0
    //   414: invokevirtual 98	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   417: athrow
    //   418: astore_1
    //   419: aload_1
    //   420: aload_0
    //   421: invokevirtual 98	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   424: athrow
    //   425: aload_0
    //   426: aload 6
    //   428: invokevirtual 103	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   431: putfield 107	com/tencent/luggage/wxa/ar/a$c:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   434: aload_0
    //   435: invokevirtual 110	com/tencent/luggage/wxa/ar/a$c:makeExtensionsImmutable	()V
    //   438: aload_1
    //   439: athrow
    //   440: aload_0
    //   441: aload 6
    //   443: invokevirtual 103	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   446: putfield 107	com/tencent/luggage/wxa/ar/a$c:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   449: aload_0
    //   450: invokevirtual 110	com/tencent/luggage/wxa/ar/a$c:makeExtensionsImmutable	()V
    //   453: return
    //   454: new 112	java/lang/NullPointerException
    //   457: dup
    //   458: invokespecial 113	java/lang/NullPointerException:<init>	()V
    //   461: astore_1
    //   462: goto +5 -> 467
    //   465: aload_1
    //   466: athrow
    //   467: goto -2 -> 465
    //   470: goto -346 -> 124
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	473	0	this	c
    //   0	473	1	paramCodedInputStream	com.google.protobuf.CodedInputStream
    //   0	473	2	paramExtensionRegistryLite	com.google.protobuf.ExtensionRegistryLite
    //   14	375	3	i1	int
    //   23	107	4	i2	int
    //   134	259	5	bool	boolean
    //   11	431	6	localBuilder	com.google.protobuf.UnknownFieldSet.Builder
    //   143	237	7	localByteString	ByteString
    // Exception table:
    //   from	to	target	type
    //   19	25	400	finally
    //   124	136	400	finally
    //   139	163	400	finally
    //   166	190	400	finally
    //   193	217	400	finally
    //   220	239	400	finally
    //   242	261	400	finally
    //   264	283	400	finally
    //   286	309	400	finally
    //   312	334	400	finally
    //   337	359	400	finally
    //   362	384	400	finally
    //   405	418	400	finally
    //   419	425	400	finally
    //   19	25	404	java/io/IOException
    //   124	136	404	java/io/IOException
    //   139	163	404	java/io/IOException
    //   166	190	404	java/io/IOException
    //   193	217	404	java/io/IOException
    //   220	239	404	java/io/IOException
    //   242	261	404	java/io/IOException
    //   264	283	404	java/io/IOException
    //   286	309	404	java/io/IOException
    //   312	334	404	java/io/IOException
    //   337	359	404	java/io/IOException
    //   362	384	404	java/io/IOException
    //   19	25	418	com/google/protobuf/InvalidProtocolBufferException
    //   124	136	418	com/google/protobuf/InvalidProtocolBufferException
    //   139	163	418	com/google/protobuf/InvalidProtocolBufferException
    //   166	190	418	com/google/protobuf/InvalidProtocolBufferException
    //   193	217	418	com/google/protobuf/InvalidProtocolBufferException
    //   220	239	418	com/google/protobuf/InvalidProtocolBufferException
    //   242	261	418	com/google/protobuf/InvalidProtocolBufferException
    //   264	283	418	com/google/protobuf/InvalidProtocolBufferException
    //   286	309	418	com/google/protobuf/InvalidProtocolBufferException
    //   312	334	418	com/google/protobuf/InvalidProtocolBufferException
    //   337	359	418	com/google/protobuf/InvalidProtocolBufferException
    //   362	384	418	com/google/protobuf/InvalidProtocolBufferException
  }
  
  private a$c(GeneratedMessageV3.Builder<?> paramBuilder)
  {
    super(paramBuilder);
  }
  
  public static final Descriptors.Descriptor a()
  {
    return a.d();
  }
  
  public static c a(byte[] paramArrayOfByte)
  {
    return (c)a.parseFrom(paramArrayOfByte);
  }
  
  public static a.c.a w()
  {
    return n.x();
  }
  
  public static c y()
  {
    return n;
  }
  
  protected a.c.a a(GeneratedMessageV3.BuilderParent paramBuilderParent)
  {
    return new a.c.a(paramBuilderParent, null);
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
  
  public String e()
  {
    Object localObject = this.d;
    if ((localObject instanceof String)) {
      return (String)localObject;
    }
    localObject = (ByteString)localObject;
    String str = ((ByteString)localObject).toStringUtf8();
    if (((ByteString)localObject).isValidUtf8()) {
      this.d = str;
    }
    return str;
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
    if ((j()) && (k() != paramObject.k())) {
      return false;
    }
    if (l() != paramObject.l()) {
      return false;
    }
    if ((l()) && (m() != paramObject.m())) {
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
    if ((p()) && (!q().equals(paramObject.q()))) {
      return false;
    }
    if (r() != paramObject.r()) {
      return false;
    }
    if ((r()) && (!s().equals(paramObject.s()))) {
      return false;
    }
    if (t() != paramObject.t()) {
      return false;
    }
    if ((t()) && (!u().equals(paramObject.u()))) {
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
  
  public Parser<c> getParserForType()
  {
    return a;
  }
  
  public int getSerializedSize()
  {
    int i1 = this.memoizedSize;
    if (i1 != -1) {
      return i1;
    }
    int i2 = 0;
    if ((this.b & 0x1) != 0) {
      i2 = 0 + GeneratedMessageV3.computeStringSize(1, this.c);
    }
    i1 = i2;
    if ((this.b & 0x2) != 0) {
      i1 = i2 + GeneratedMessageV3.computeStringSize(2, this.d);
    }
    i2 = i1;
    if ((this.b & 0x4) != 0) {
      i2 = i1 + GeneratedMessageV3.computeStringSize(3, this.e);
    }
    i1 = i2;
    if ((this.b & 0x8) != 0) {
      i1 = i2 + GeneratedMessageV3.computeStringSize(4, this.f);
    }
    i2 = i1;
    if ((this.b & 0x10) != 0) {
      i2 = i1 + CodedOutputStream.i(5, this.g);
    }
    i1 = i2;
    if ((this.b & 0x20) != 0) {
      i1 = i2 + CodedOutputStream.i(6, this.h);
    }
    i2 = i1;
    if ((this.b & 0x40) != 0) {
      i2 = i1 + CodedOutputStream.i(7, this.i);
    }
    i1 = i2;
    if ((this.b & 0x80) != 0) {
      i1 = i2 + GeneratedMessageV3.computeStringSize(8, this.j);
    }
    i2 = i1;
    if ((this.b & 0x100) != 0) {
      i2 = i1 + GeneratedMessageV3.computeStringSize(9, this.k);
    }
    i1 = i2;
    if ((this.b & 0x200) != 0) {
      i1 = i2 + GeneratedMessageV3.computeStringSize(10, this.l);
    }
    i1 += this.unknownFields.getSerializedSize();
    this.memoizedSize = i1;
    return i1;
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
    int i2 = 779 + a().hashCode();
    int i1 = i2;
    if (b()) {
      i1 = (i2 * 37 + 1) * 53 + c().hashCode();
    }
    i2 = i1;
    if (d()) {
      i2 = (i1 * 37 + 2) * 53 + e().hashCode();
    }
    i1 = i2;
    if (f()) {
      i1 = (i2 * 37 + 3) * 53 + g().hashCode();
    }
    i2 = i1;
    if (h()) {
      i2 = (i1 * 37 + 4) * 53 + i().hashCode();
    }
    i1 = i2;
    if (j()) {
      i1 = (i2 * 37 + 5) * 53 + k();
    }
    i2 = i1;
    if (l()) {
      i2 = (i1 * 37 + 6) * 53 + m();
    }
    i1 = i2;
    if (n()) {
      i1 = (i2 * 37 + 7) * 53 + o();
    }
    i2 = i1;
    if (p()) {
      i2 = (i1 * 37 + 8) * 53 + q().hashCode();
    }
    i1 = i2;
    if (r()) {
      i1 = (i2 * 37 + 9) * 53 + s().hashCode();
    }
    i2 = i1;
    if (t()) {
      i2 = (i1 * 37 + 10) * 53 + u().hashCode();
    }
    i1 = i2 * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i1;
    return i1;
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
    return a.e().a(c.class, a.c.a.class);
  }
  
  public final boolean isInitialized()
  {
    int i1 = this.m;
    if (i1 == 1) {
      return true;
    }
    if (i1 == 0) {
      return false;
    }
    if (!b())
    {
      this.m = 0;
      return false;
    }
    if (!d())
    {
      this.m = 0;
      return false;
    }
    this.m = 1;
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
  
  public int m()
  {
    return this.h;
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
  
  public boolean t()
  {
    return (this.b & 0x200) != 0;
  }
  
  public String u()
  {
    Object localObject = this.l;
    if ((localObject instanceof String)) {
      return (String)localObject;
    }
    localObject = (ByteString)localObject;
    String str = ((ByteString)localObject).toStringUtf8();
    if (((ByteString)localObject).isValidUtf8()) {
      this.l = str;
    }
    return str;
  }
  
  public a.c.a v()
  {
    return w();
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
  {
    if ((this.b & 0x1) != 0) {
      GeneratedMessageV3.writeString(paramCodedOutputStream, 1, this.c);
    }
    if ((this.b & 0x2) != 0) {
      GeneratedMessageV3.writeString(paramCodedOutputStream, 2, this.d);
    }
    if ((this.b & 0x4) != 0) {
      GeneratedMessageV3.writeString(paramCodedOutputStream, 3, this.e);
    }
    if ((this.b & 0x8) != 0) {
      GeneratedMessageV3.writeString(paramCodedOutputStream, 4, this.f);
    }
    if ((this.b & 0x10) != 0) {
      paramCodedOutputStream.c(5, this.g);
    }
    if ((this.b & 0x20) != 0) {
      paramCodedOutputStream.c(6, this.h);
    }
    if ((this.b & 0x40) != 0) {
      paramCodedOutputStream.c(7, this.i);
    }
    if ((this.b & 0x80) != 0) {
      GeneratedMessageV3.writeString(paramCodedOutputStream, 8, this.j);
    }
    if ((this.b & 0x100) != 0) {
      GeneratedMessageV3.writeString(paramCodedOutputStream, 9, this.k);
    }
    if ((this.b & 0x200) != 0) {
      GeneratedMessageV3.writeString(paramCodedOutputStream, 10, this.l);
    }
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
  
  public a.c.a x()
  {
    if (this == n) {
      return new a.c.a(null);
    }
    return new a.c.a(null).a(this);
  }
  
  public c z()
  {
    return n;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ar.a.c
 * JD-Core Version:    0.7.0.1
 */