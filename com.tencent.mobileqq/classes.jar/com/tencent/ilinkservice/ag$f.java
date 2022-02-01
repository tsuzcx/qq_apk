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

public final class ag$f
  extends GeneratedMessageV3
  implements am
{
  @Deprecated
  public static final Parser<f> a = new ag.f.1();
  private static final f n = new f();
  private int b;
  private int c;
  private volatile Object d;
  private volatile Object e;
  private int f;
  private int g;
  private int h;
  private int i;
  private volatile Object j;
  private volatile Object k;
  private int l;
  private byte m = -1;
  
  private ag$f()
  {
    this.d = "";
    this.e = "";
    this.j = "";
    this.k = "";
  }
  
  /* Error */
  private ag$f(com.google.protobuf.CodedInputStream paramCodedInputStream, com.google.protobuf.ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 32	com/tencent/ilinkservice/ag$f:<init>	()V
    //   4: aload_2
    //   5: ifnull +437 -> 442
    //   8: invokestatic 63	com/google/protobuf/UnknownFieldSet:a	()Lcom/google/protobuf/UnknownFieldSet$Builder;
    //   11: astore 6
    //   13: iconst_0
    //   14: istore_3
    //   15: iload_3
    //   16: ifne +412 -> 428
    //   19: aload_1
    //   20: invokevirtual 68	com/google/protobuf/CodedInputStream:a	()I
    //   23: istore 4
    //   25: iload 4
    //   27: lookupswitch	default:+431->458, 0:+348->375, 8:+327->354, 18:+302->329, 26:+277->304, 32:+255->282, 40:+233->260, 48:+211->238, 56:+189->216, 66:+162->189, 74:+135->162, 80:+112->139
    //   125: aload_1
    //   126: aload 6
    //   128: aload_2
    //   129: iload 4
    //   131: invokevirtual 72	com/tencent/ilinkservice/ag$f:parseUnknownField	(Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/UnknownFieldSet$Builder;Lcom/google/protobuf/ExtensionRegistryLite;I)Z
    //   134: istore 5
    //   136: goto +244 -> 380
    //   139: aload_0
    //   140: aload_0
    //   141: getfield 74	com/tencent/ilinkservice/ag$f:b	I
    //   144: sipush 512
    //   147: ior
    //   148: putfield 74	com/tencent/ilinkservice/ag$f:b	I
    //   151: aload_0
    //   152: aload_1
    //   153: invokevirtual 76	com/google/protobuf/CodedInputStream:m	()I
    //   156: putfield 78	com/tencent/ilinkservice/ag$f:l	I
    //   159: goto -144 -> 15
    //   162: aload_1
    //   163: invokevirtual 81	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   166: astore 7
    //   168: aload_0
    //   169: aload_0
    //   170: getfield 74	com/tencent/ilinkservice/ag$f:b	I
    //   173: sipush 256
    //   176: ior
    //   177: putfield 74	com/tencent/ilinkservice/ag$f:b	I
    //   180: aload_0
    //   181: aload 7
    //   183: putfield 53	com/tencent/ilinkservice/ag$f:k	Ljava/lang/Object;
    //   186: goto -171 -> 15
    //   189: aload_1
    //   190: invokevirtual 81	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   193: astore 7
    //   195: aload_0
    //   196: aload_0
    //   197: getfield 74	com/tencent/ilinkservice/ag$f:b	I
    //   200: sipush 128
    //   203: ior
    //   204: putfield 74	com/tencent/ilinkservice/ag$f:b	I
    //   207: aload_0
    //   208: aload 7
    //   210: putfield 51	com/tencent/ilinkservice/ag$f:j	Ljava/lang/Object;
    //   213: goto -198 -> 15
    //   216: aload_0
    //   217: aload_0
    //   218: getfield 74	com/tencent/ilinkservice/ag$f:b	I
    //   221: bipush 64
    //   223: ior
    //   224: putfield 74	com/tencent/ilinkservice/ag$f:b	I
    //   227: aload_0
    //   228: aload_1
    //   229: invokevirtual 76	com/google/protobuf/CodedInputStream:m	()I
    //   232: putfield 83	com/tencent/ilinkservice/ag$f:i	I
    //   235: goto -220 -> 15
    //   238: aload_0
    //   239: aload_0
    //   240: getfield 74	com/tencent/ilinkservice/ag$f:b	I
    //   243: bipush 32
    //   245: ior
    //   246: putfield 74	com/tencent/ilinkservice/ag$f:b	I
    //   249: aload_0
    //   250: aload_1
    //   251: invokevirtual 76	com/google/protobuf/CodedInputStream:m	()I
    //   254: putfield 85	com/tencent/ilinkservice/ag$f:h	I
    //   257: goto -242 -> 15
    //   260: aload_0
    //   261: aload_0
    //   262: getfield 74	com/tencent/ilinkservice/ag$f:b	I
    //   265: bipush 16
    //   267: ior
    //   268: putfield 74	com/tencent/ilinkservice/ag$f:b	I
    //   271: aload_0
    //   272: aload_1
    //   273: invokevirtual 76	com/google/protobuf/CodedInputStream:m	()I
    //   276: putfield 87	com/tencent/ilinkservice/ag$f:g	I
    //   279: goto -264 -> 15
    //   282: aload_0
    //   283: aload_0
    //   284: getfield 74	com/tencent/ilinkservice/ag$f:b	I
    //   287: bipush 8
    //   289: ior
    //   290: putfield 74	com/tencent/ilinkservice/ag$f:b	I
    //   293: aload_0
    //   294: aload_1
    //   295: invokevirtual 76	com/google/protobuf/CodedInputStream:m	()I
    //   298: putfield 89	com/tencent/ilinkservice/ag$f:f	I
    //   301: goto -286 -> 15
    //   304: aload_1
    //   305: invokevirtual 81	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   308: astore 7
    //   310: aload_0
    //   311: aload_0
    //   312: getfield 74	com/tencent/ilinkservice/ag$f:b	I
    //   315: iconst_4
    //   316: ior
    //   317: putfield 74	com/tencent/ilinkservice/ag$f:b	I
    //   320: aload_0
    //   321: aload 7
    //   323: putfield 49	com/tencent/ilinkservice/ag$f:e	Ljava/lang/Object;
    //   326: goto -311 -> 15
    //   329: aload_1
    //   330: invokevirtual 81	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   333: astore 7
    //   335: aload_0
    //   336: aload_0
    //   337: getfield 74	com/tencent/ilinkservice/ag$f:b	I
    //   340: iconst_2
    //   341: ior
    //   342: putfield 74	com/tencent/ilinkservice/ag$f:b	I
    //   345: aload_0
    //   346: aload 7
    //   348: putfield 47	com/tencent/ilinkservice/ag$f:d	Ljava/lang/Object;
    //   351: goto -336 -> 15
    //   354: aload_0
    //   355: aload_0
    //   356: getfield 74	com/tencent/ilinkservice/ag$f:b	I
    //   359: iconst_1
    //   360: ior
    //   361: putfield 74	com/tencent/ilinkservice/ag$f:b	I
    //   364: aload_0
    //   365: aload_1
    //   366: invokevirtual 76	com/google/protobuf/CodedInputStream:m	()I
    //   369: putfield 91	com/tencent/ilinkservice/ag$f:c	I
    //   372: goto -357 -> 15
    //   375: iconst_1
    //   376: istore_3
    //   377: goto -362 -> 15
    //   380: iload 5
    //   382: ifne -367 -> 15
    //   385: goto -10 -> 375
    //   388: astore_1
    //   389: goto +24 -> 413
    //   392: astore_1
    //   393: new 56	com/google/protobuf/InvalidProtocolBufferException
    //   396: dup
    //   397: aload_1
    //   398: invokespecial 94	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/io/IOException;)V
    //   401: aload_0
    //   402: invokevirtual 98	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   405: athrow
    //   406: astore_1
    //   407: aload_1
    //   408: aload_0
    //   409: invokevirtual 98	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   412: athrow
    //   413: aload_0
    //   414: aload 6
    //   416: invokevirtual 103	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   419: putfield 107	com/tencent/ilinkservice/ag$f:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   422: aload_0
    //   423: invokevirtual 110	com/tencent/ilinkservice/ag$f:makeExtensionsImmutable	()V
    //   426: aload_1
    //   427: athrow
    //   428: aload_0
    //   429: aload 6
    //   431: invokevirtual 103	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   434: putfield 107	com/tencent/ilinkservice/ag$f:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   437: aload_0
    //   438: invokevirtual 110	com/tencent/ilinkservice/ag$f:makeExtensionsImmutable	()V
    //   441: return
    //   442: new 112	java/lang/NullPointerException
    //   445: dup
    //   446: invokespecial 113	java/lang/NullPointerException:<init>	()V
    //   449: astore_1
    //   450: goto +5 -> 455
    //   453: aload_1
    //   454: athrow
    //   455: goto -2 -> 453
    //   458: goto -334 -> 124
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	461	0	this	f
    //   0	461	1	paramCodedInputStream	com.google.protobuf.CodedInputStream
    //   0	461	2	paramExtensionRegistryLite	com.google.protobuf.ExtensionRegistryLite
    //   14	363	3	i1	int
    //   23	107	4	i2	int
    //   134	247	5	bool	boolean
    //   11	419	6	localBuilder	com.google.protobuf.UnknownFieldSet.Builder
    //   166	181	7	localByteString	ByteString
    // Exception table:
    //   from	to	target	type
    //   19	25	388	finally
    //   124	136	388	finally
    //   139	159	388	finally
    //   162	186	388	finally
    //   189	213	388	finally
    //   216	235	388	finally
    //   238	257	388	finally
    //   260	279	388	finally
    //   282	301	388	finally
    //   304	326	388	finally
    //   329	351	388	finally
    //   354	372	388	finally
    //   393	406	388	finally
    //   407	413	388	finally
    //   19	25	392	java/io/IOException
    //   124	136	392	java/io/IOException
    //   139	159	392	java/io/IOException
    //   162	186	392	java/io/IOException
    //   189	213	392	java/io/IOException
    //   216	235	392	java/io/IOException
    //   238	257	392	java/io/IOException
    //   260	279	392	java/io/IOException
    //   282	301	392	java/io/IOException
    //   304	326	392	java/io/IOException
    //   329	351	392	java/io/IOException
    //   354	372	392	java/io/IOException
    //   19	25	406	com/google/protobuf/InvalidProtocolBufferException
    //   124	136	406	com/google/protobuf/InvalidProtocolBufferException
    //   139	159	406	com/google/protobuf/InvalidProtocolBufferException
    //   162	186	406	com/google/protobuf/InvalidProtocolBufferException
    //   189	213	406	com/google/protobuf/InvalidProtocolBufferException
    //   216	235	406	com/google/protobuf/InvalidProtocolBufferException
    //   238	257	406	com/google/protobuf/InvalidProtocolBufferException
    //   260	279	406	com/google/protobuf/InvalidProtocolBufferException
    //   282	301	406	com/google/protobuf/InvalidProtocolBufferException
    //   304	326	406	com/google/protobuf/InvalidProtocolBufferException
    //   329	351	406	com/google/protobuf/InvalidProtocolBufferException
    //   354	372	406	com/google/protobuf/InvalidProtocolBufferException
  }
  
  private ag$f(GeneratedMessageV3.Builder<?> paramBuilder)
  {
    super(paramBuilder);
  }
  
  public static final Descriptors.Descriptor a()
  {
    return ag.b();
  }
  
  public static ag.f.a a(f paramf)
  {
    return n.x().a(paramf);
  }
  
  public static f a(byte[] paramArrayOfByte)
  {
    return (f)a.parseFrom(paramArrayOfByte);
  }
  
  public static ag.f.a w()
  {
    return n.x();
  }
  
  public static f y()
  {
    return n;
  }
  
  protected ag.f.a a(GeneratedMessageV3.BuilderParent paramBuilderParent)
  {
    return new ag.f.a(paramBuilderParent, null);
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
    if (!(paramObject instanceof f)) {
      return super.equals(paramObject);
    }
    paramObject = (f)paramObject;
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
    if ((t()) && (u() != paramObject.u())) {
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
  
  public Parser<f> getParserForType()
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
      i2 = 0 + CodedOutputStream.i(1, this.c);
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
      i1 = i2 + CodedOutputStream.i(4, this.f);
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
      i1 = i2 + CodedOutputStream.i(10, this.l);
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
      i1 = (i2 * 37 + 1) * 53 + c();
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
      i2 = (i1 * 37 + 4) * 53 + i();
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
      i2 = (i1 * 37 + 10) * 53 + u();
    }
    i1 = i2 * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i1;
    return i1;
  }
  
  public int i()
  {
    return this.f;
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return ag.c().a(f.class, ag.f.a.class);
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
    if (!f())
    {
      this.m = 0;
      return false;
    }
    if (!h())
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
    return new f();
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
  
  public int u()
  {
    return this.l;
  }
  
  public ag.f.a v()
  {
    return w();
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
  {
    if ((this.b & 0x1) != 0) {
      paramCodedOutputStream.c(1, this.c);
    }
    if ((this.b & 0x2) != 0) {
      GeneratedMessageV3.writeString(paramCodedOutputStream, 2, this.d);
    }
    if ((this.b & 0x4) != 0) {
      GeneratedMessageV3.writeString(paramCodedOutputStream, 3, this.e);
    }
    if ((this.b & 0x8) != 0) {
      paramCodedOutputStream.c(4, this.f);
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
      paramCodedOutputStream.c(10, this.l);
    }
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
  
  public ag.f.a x()
  {
    if (this == n) {
      return new ag.f.a(null);
    }
    return new ag.f.a(null).a(this);
  }
  
  public f z()
  {
    return n;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilinkservice.ag.f
 * JD-Core Version:    0.7.0.1
 */