package com.tencent.ilinkservice;

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

public final class ag$a
  extends GeneratedMessageV3
  implements ah
{
  @Deprecated
  public static final Parser<a> a = new ag.a.1();
  private static final a n = new a();
  private int b;
  private long c;
  private volatile Object d;
  private volatile Object e;
  private volatile Object f;
  private int g;
  private volatile Object h;
  private volatile Object i;
  private long j;
  private long k;
  private long l;
  private byte m = -1;
  
  private ag$a()
  {
    this.d = "";
    this.e = "";
    this.f = "";
    this.h = "";
    this.i = "";
  }
  
  /* Error */
  private ag$a(com.google.protobuf.CodedInputStream paramCodedInputStream, com.google.protobuf.ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 33	com/tencent/ilinkservice/ag$a:<init>	()V
    //   4: aload_2
    //   5: ifnull +441 -> 446
    //   8: invokestatic 66	com/google/protobuf/UnknownFieldSet:a	()Lcom/google/protobuf/UnknownFieldSet$Builder;
    //   11: astore 6
    //   13: iconst_0
    //   14: istore_3
    //   15: iload_3
    //   16: ifne +416 -> 432
    //   19: aload_1
    //   20: invokevirtual 71	com/google/protobuf/CodedInputStream:a	()I
    //   23: istore 4
    //   25: iload 4
    //   27: lookupswitch	default:+435->462, 0:+352->379, 8:+331->358, 18:+306->333, 26:+281->308, 34:+255->282, 40:+233->260, 50:+207->234, 58:+181->208, 64:+158->185, 72:+135->162, 80:+112->139
    //   125: aload_1
    //   126: aload 6
    //   128: aload_2
    //   129: iload 4
    //   131: invokevirtual 75	com/tencent/ilinkservice/ag$a:parseUnknownField	(Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/UnknownFieldSet$Builder;Lcom/google/protobuf/ExtensionRegistryLite;I)Z
    //   134: istore 5
    //   136: goto +248 -> 384
    //   139: aload_0
    //   140: aload_0
    //   141: getfield 77	com/tencent/ilinkservice/ag$a:b	I
    //   144: sipush 512
    //   147: ior
    //   148: putfield 77	com/tencent/ilinkservice/ag$a:b	I
    //   151: aload_0
    //   152: aload_1
    //   153: invokevirtual 80	com/google/protobuf/CodedInputStream:d	()J
    //   156: putfield 82	com/tencent/ilinkservice/ag$a:l	J
    //   159: goto -144 -> 15
    //   162: aload_0
    //   163: aload_0
    //   164: getfield 77	com/tencent/ilinkservice/ag$a:b	I
    //   167: sipush 256
    //   170: ior
    //   171: putfield 77	com/tencent/ilinkservice/ag$a:b	I
    //   174: aload_0
    //   175: aload_1
    //   176: invokevirtual 80	com/google/protobuf/CodedInputStream:d	()J
    //   179: putfield 84	com/tencent/ilinkservice/ag$a:k	J
    //   182: goto -167 -> 15
    //   185: aload_0
    //   186: aload_0
    //   187: getfield 77	com/tencent/ilinkservice/ag$a:b	I
    //   190: sipush 128
    //   193: ior
    //   194: putfield 77	com/tencent/ilinkservice/ag$a:b	I
    //   197: aload_0
    //   198: aload_1
    //   199: invokevirtual 80	com/google/protobuf/CodedInputStream:d	()J
    //   202: putfield 86	com/tencent/ilinkservice/ag$a:j	J
    //   205: goto -190 -> 15
    //   208: aload_1
    //   209: invokevirtual 89	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   212: astore 7
    //   214: aload_0
    //   215: aload_0
    //   216: getfield 77	com/tencent/ilinkservice/ag$a:b	I
    //   219: bipush 64
    //   221: ior
    //   222: putfield 77	com/tencent/ilinkservice/ag$a:b	I
    //   225: aload_0
    //   226: aload 7
    //   228: putfield 56	com/tencent/ilinkservice/ag$a:i	Ljava/lang/Object;
    //   231: goto -216 -> 15
    //   234: aload_1
    //   235: invokevirtual 89	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   238: astore 7
    //   240: aload_0
    //   241: aload_0
    //   242: getfield 77	com/tencent/ilinkservice/ag$a:b	I
    //   245: bipush 32
    //   247: ior
    //   248: putfield 77	com/tencent/ilinkservice/ag$a:b	I
    //   251: aload_0
    //   252: aload 7
    //   254: putfield 54	com/tencent/ilinkservice/ag$a:h	Ljava/lang/Object;
    //   257: goto -242 -> 15
    //   260: aload_0
    //   261: aload_0
    //   262: getfield 77	com/tencent/ilinkservice/ag$a:b	I
    //   265: bipush 16
    //   267: ior
    //   268: putfield 77	com/tencent/ilinkservice/ag$a:b	I
    //   271: aload_0
    //   272: aload_1
    //   273: invokevirtual 91	com/google/protobuf/CodedInputStream:m	()I
    //   276: putfield 93	com/tencent/ilinkservice/ag$a:g	I
    //   279: goto -264 -> 15
    //   282: aload_1
    //   283: invokevirtual 89	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   286: astore 7
    //   288: aload_0
    //   289: aload_0
    //   290: getfield 77	com/tencent/ilinkservice/ag$a:b	I
    //   293: bipush 8
    //   295: ior
    //   296: putfield 77	com/tencent/ilinkservice/ag$a:b	I
    //   299: aload_0
    //   300: aload 7
    //   302: putfield 52	com/tencent/ilinkservice/ag$a:f	Ljava/lang/Object;
    //   305: goto -290 -> 15
    //   308: aload_1
    //   309: invokevirtual 89	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   312: astore 7
    //   314: aload_0
    //   315: aload_0
    //   316: getfield 77	com/tencent/ilinkservice/ag$a:b	I
    //   319: iconst_4
    //   320: ior
    //   321: putfield 77	com/tencent/ilinkservice/ag$a:b	I
    //   324: aload_0
    //   325: aload 7
    //   327: putfield 50	com/tencent/ilinkservice/ag$a:e	Ljava/lang/Object;
    //   330: goto -315 -> 15
    //   333: aload_1
    //   334: invokevirtual 89	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   337: astore 7
    //   339: aload_0
    //   340: aload_0
    //   341: getfield 77	com/tencent/ilinkservice/ag$a:b	I
    //   344: iconst_2
    //   345: ior
    //   346: putfield 77	com/tencent/ilinkservice/ag$a:b	I
    //   349: aload_0
    //   350: aload 7
    //   352: putfield 48	com/tencent/ilinkservice/ag$a:d	Ljava/lang/Object;
    //   355: goto -340 -> 15
    //   358: aload_0
    //   359: aload_0
    //   360: getfield 77	com/tencent/ilinkservice/ag$a:b	I
    //   363: iconst_1
    //   364: ior
    //   365: putfield 77	com/tencent/ilinkservice/ag$a:b	I
    //   368: aload_0
    //   369: aload_1
    //   370: invokevirtual 80	com/google/protobuf/CodedInputStream:d	()J
    //   373: putfield 95	com/tencent/ilinkservice/ag$a:c	J
    //   376: goto -361 -> 15
    //   379: iconst_1
    //   380: istore_3
    //   381: goto -366 -> 15
    //   384: iload 5
    //   386: ifne -371 -> 15
    //   389: goto -10 -> 379
    //   392: astore_1
    //   393: goto +24 -> 417
    //   396: astore_1
    //   397: new 59	com/google/protobuf/InvalidProtocolBufferException
    //   400: dup
    //   401: aload_1
    //   402: invokespecial 98	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/io/IOException;)V
    //   405: aload_0
    //   406: invokevirtual 102	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   409: athrow
    //   410: astore_1
    //   411: aload_1
    //   412: aload_0
    //   413: invokevirtual 102	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   416: athrow
    //   417: aload_0
    //   418: aload 6
    //   420: invokevirtual 107	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   423: putfield 111	com/tencent/ilinkservice/ag$a:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   426: aload_0
    //   427: invokevirtual 114	com/tencent/ilinkservice/ag$a:makeExtensionsImmutable	()V
    //   430: aload_1
    //   431: athrow
    //   432: aload_0
    //   433: aload 6
    //   435: invokevirtual 107	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   438: putfield 111	com/tencent/ilinkservice/ag$a:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   441: aload_0
    //   442: invokevirtual 114	com/tencent/ilinkservice/ag$a:makeExtensionsImmutable	()V
    //   445: return
    //   446: new 116	java/lang/NullPointerException
    //   449: dup
    //   450: invokespecial 117	java/lang/NullPointerException:<init>	()V
    //   453: astore_1
    //   454: goto +5 -> 459
    //   457: aload_1
    //   458: athrow
    //   459: goto -2 -> 457
    //   462: goto -338 -> 124
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	465	0	this	a
    //   0	465	1	paramCodedInputStream	com.google.protobuf.CodedInputStream
    //   0	465	2	paramExtensionRegistryLite	com.google.protobuf.ExtensionRegistryLite
    //   14	367	3	i1	int
    //   23	107	4	i2	int
    //   134	251	5	bool	boolean
    //   11	423	6	localBuilder	com.google.protobuf.UnknownFieldSet.Builder
    //   212	139	7	localByteString	ByteString
    // Exception table:
    //   from	to	target	type
    //   19	25	392	finally
    //   124	136	392	finally
    //   139	159	392	finally
    //   162	182	392	finally
    //   185	205	392	finally
    //   208	231	392	finally
    //   234	257	392	finally
    //   260	279	392	finally
    //   282	305	392	finally
    //   308	330	392	finally
    //   333	355	392	finally
    //   358	376	392	finally
    //   397	410	392	finally
    //   411	417	392	finally
    //   19	25	396	java/io/IOException
    //   124	136	396	java/io/IOException
    //   139	159	396	java/io/IOException
    //   162	182	396	java/io/IOException
    //   185	205	396	java/io/IOException
    //   208	231	396	java/io/IOException
    //   234	257	396	java/io/IOException
    //   260	279	396	java/io/IOException
    //   282	305	396	java/io/IOException
    //   308	330	396	java/io/IOException
    //   333	355	396	java/io/IOException
    //   358	376	396	java/io/IOException
    //   19	25	410	com/google/protobuf/InvalidProtocolBufferException
    //   124	136	410	com/google/protobuf/InvalidProtocolBufferException
    //   139	159	410	com/google/protobuf/InvalidProtocolBufferException
    //   162	182	410	com/google/protobuf/InvalidProtocolBufferException
    //   185	205	410	com/google/protobuf/InvalidProtocolBufferException
    //   208	231	410	com/google/protobuf/InvalidProtocolBufferException
    //   234	257	410	com/google/protobuf/InvalidProtocolBufferException
    //   260	279	410	com/google/protobuf/InvalidProtocolBufferException
    //   282	305	410	com/google/protobuf/InvalidProtocolBufferException
    //   308	330	410	com/google/protobuf/InvalidProtocolBufferException
    //   333	355	410	com/google/protobuf/InvalidProtocolBufferException
    //   358	376	410	com/google/protobuf/InvalidProtocolBufferException
  }
  
  private ag$a(GeneratedMessageV3.Builder<?> paramBuilder)
  {
    super(paramBuilder);
  }
  
  public static final Descriptors.Descriptor a()
  {
    return ag.f();
  }
  
  public static a a(byte[] paramArrayOfByte)
  {
    return (a)a.parseFrom(paramArrayOfByte);
  }
  
  public static ag.a.a w()
  {
    return n.x();
  }
  
  public static a y()
  {
    return n;
  }
  
  protected ag.a.a a(GeneratedMessageV3.BuilderParent paramBuilderParent)
  {
    return new ag.a.a(paramBuilderParent, null);
  }
  
  public boolean b()
  {
    return (this.b & 0x1) != 0;
  }
  
  public long c()
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
    if (!(paramObject instanceof a)) {
      return super.equals(paramObject);
    }
    paramObject = (a)paramObject;
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
    if ((p()) && (q() != paramObject.q())) {
      return false;
    }
    if (r() != paramObject.r()) {
      return false;
    }
    if ((r()) && (s() != paramObject.s())) {
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
  
  public Parser<a> getParserForType()
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
      i2 = 0 + CodedOutputStream.g(1, this.c);
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
      i1 = i2 + GeneratedMessageV3.computeStringSize(6, this.h);
    }
    i2 = i1;
    if ((this.b & 0x40) != 0) {
      i2 = i1 + GeneratedMessageV3.computeStringSize(7, this.i);
    }
    i1 = i2;
    if ((this.b & 0x80) != 0) {
      i1 = i2 + CodedOutputStream.g(8, this.j);
    }
    i2 = i1;
    if ((this.b & 0x100) != 0) {
      i2 = i1 + CodedOutputStream.g(9, this.k);
    }
    i1 = i2;
    if ((this.b & 0x200) != 0) {
      i1 = i2 + CodedOutputStream.g(10, this.l);
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
      i1 = (i2 * 37 + 1) * 53 + Internal.a(c());
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
      i2 = (i1 * 37 + 6) * 53 + m().hashCode();
    }
    i1 = i2;
    if (n()) {
      i1 = (i2 * 37 + 7) * 53 + o().hashCode();
    }
    i2 = i1;
    if (p()) {
      i2 = (i1 * 37 + 8) * 53 + Internal.a(q());
    }
    i1 = i2;
    if (r()) {
      i1 = (i2 * 37 + 9) * 53 + Internal.a(s());
    }
    i2 = i1;
    if (t()) {
      i2 = (i1 * 37 + 10) * 53 + Internal.a(u());
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
    return ag.g().a(a.class, ag.a.a.class);
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
    return new a();
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
  
  public long q()
  {
    return this.j;
  }
  
  public boolean r()
  {
    return (this.b & 0x100) != 0;
  }
  
  public long s()
  {
    return this.k;
  }
  
  public boolean t()
  {
    return (this.b & 0x200) != 0;
  }
  
  public long u()
  {
    return this.l;
  }
  
  public ag.a.a v()
  {
    return w();
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
  {
    if ((this.b & 0x1) != 0) {
      paramCodedOutputStream.b(1, this.c);
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
      GeneratedMessageV3.writeString(paramCodedOutputStream, 6, this.h);
    }
    if ((this.b & 0x40) != 0) {
      GeneratedMessageV3.writeString(paramCodedOutputStream, 7, this.i);
    }
    if ((this.b & 0x80) != 0) {
      paramCodedOutputStream.b(8, this.j);
    }
    if ((this.b & 0x100) != 0) {
      paramCodedOutputStream.b(9, this.k);
    }
    if ((this.b & 0x200) != 0) {
      paramCodedOutputStream.b(10, this.l);
    }
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
  
  public ag.a.a x()
  {
    if (this == n) {
      return new ag.a.a(null);
    }
    return new ag.a.a(null).a(this);
  }
  
  public a z()
  {
    return n;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilinkservice.ag.a
 * JD-Core Version:    0.7.0.1
 */