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

public final class b$s
  extends GeneratedMessageV3
  implements s
{
  @Deprecated
  public static final Parser<s> a = new b.s.1();
  private static final s k = new s();
  private int b;
  private volatile Object c;
  private int d;
  private volatile Object e;
  private volatile Object f;
  private volatile Object g;
  private b.t h;
  private volatile Object i;
  private byte j = -1;
  
  private b$s()
  {
    this.c = "";
    this.e = "";
    this.f = "";
    this.g = "";
    this.i = "";
  }
  
  /* Error */
  private b$s(com.google.protobuf.CodedInputStream paramCodedInputStream, com.google.protobuf.ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 30	com/tencent/ilink/tdi/b$s:<init>	()V
    //   4: aload_2
    //   5: ifnull +373 -> 378
    //   8: invokestatic 63	com/google/protobuf/UnknownFieldSet:a	()Lcom/google/protobuf/UnknownFieldSet$Builder;
    //   11: astore 6
    //   13: iconst_0
    //   14: istore_3
    //   15: iload_3
    //   16: ifne +348 -> 364
    //   19: aload_1
    //   20: invokevirtual 68	com/google/protobuf/CodedInputStream:a	()I
    //   23: istore 4
    //   25: iload 4
    //   27: ifeq +292 -> 319
    //   30: iload 4
    //   32: bipush 10
    //   34: if_icmpeq +260 -> 294
    //   37: iload 4
    //   39: bipush 16
    //   41: if_icmpeq +232 -> 273
    //   44: iload 4
    //   46: bipush 26
    //   48: if_icmpeq +200 -> 248
    //   51: iload 4
    //   53: bipush 34
    //   55: if_icmpeq +167 -> 222
    //   58: iload 4
    //   60: bipush 42
    //   62: if_icmpeq +134 -> 196
    //   65: iload 4
    //   67: bipush 50
    //   69: if_icmpeq +52 -> 121
    //   72: iload 4
    //   74: bipush 58
    //   76: if_icmpeq +19 -> 95
    //   79: aload_0
    //   80: aload_1
    //   81: aload 6
    //   83: aload_2
    //   84: iload 4
    //   86: invokevirtual 72	com/tencent/ilink/tdi/b$s:parseUnknownField	(Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/UnknownFieldSet$Builder;Lcom/google/protobuf/ExtensionRegistryLite;I)Z
    //   89: ifne -74 -> 15
    //   92: goto +227 -> 319
    //   95: aload_1
    //   96: invokevirtual 76	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   99: astore 5
    //   101: aload_0
    //   102: aload_0
    //   103: getfield 78	com/tencent/ilink/tdi/b$s:b	I
    //   106: bipush 64
    //   108: ior
    //   109: putfield 78	com/tencent/ilink/tdi/b$s:b	I
    //   112: aload_0
    //   113: aload 5
    //   115: putfield 53	com/tencent/ilink/tdi/b$s:i	Ljava/lang/Object;
    //   118: goto -103 -> 15
    //   121: aconst_null
    //   122: astore 5
    //   124: aload_0
    //   125: getfield 78	com/tencent/ilink/tdi/b$s:b	I
    //   128: bipush 32
    //   130: iand
    //   131: ifeq +12 -> 143
    //   134: aload_0
    //   135: getfield 80	com/tencent/ilink/tdi/b$s:h	Lcom/tencent/ilink/tdi/b$t;
    //   138: invokevirtual 85	com/tencent/ilink/tdi/b$t:j	()Lcom/tencent/ilink/tdi/b$t$a;
    //   141: astore 5
    //   143: aload_0
    //   144: aload_1
    //   145: getstatic 86	com/tencent/ilink/tdi/b$t:a	Lcom/google/protobuf/Parser;
    //   148: aload_2
    //   149: invokevirtual 89	com/google/protobuf/CodedInputStream:a	(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   152: checkcast 82	com/tencent/ilink/tdi/b$t
    //   155: putfield 80	com/tencent/ilink/tdi/b$s:h	Lcom/tencent/ilink/tdi/b$t;
    //   158: aload 5
    //   160: ifnull +22 -> 182
    //   163: aload 5
    //   165: aload_0
    //   166: getfield 80	com/tencent/ilink/tdi/b$s:h	Lcom/tencent/ilink/tdi/b$t;
    //   169: invokevirtual 94	com/tencent/ilink/tdi/b$t$a:a	(Lcom/tencent/ilink/tdi/b$t;)Lcom/tencent/ilink/tdi/b$t$a;
    //   172: pop
    //   173: aload_0
    //   174: aload 5
    //   176: invokevirtual 97	com/tencent/ilink/tdi/b$t$a:d	()Lcom/tencent/ilink/tdi/b$t;
    //   179: putfield 80	com/tencent/ilink/tdi/b$s:h	Lcom/tencent/ilink/tdi/b$t;
    //   182: aload_0
    //   183: aload_0
    //   184: getfield 78	com/tencent/ilink/tdi/b$s:b	I
    //   187: bipush 32
    //   189: ior
    //   190: putfield 78	com/tencent/ilink/tdi/b$s:b	I
    //   193: goto -178 -> 15
    //   196: aload_1
    //   197: invokevirtual 76	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   200: astore 5
    //   202: aload_0
    //   203: aload_0
    //   204: getfield 78	com/tencent/ilink/tdi/b$s:b	I
    //   207: bipush 16
    //   209: ior
    //   210: putfield 78	com/tencent/ilink/tdi/b$s:b	I
    //   213: aload_0
    //   214: aload 5
    //   216: putfield 51	com/tencent/ilink/tdi/b$s:g	Ljava/lang/Object;
    //   219: goto -204 -> 15
    //   222: aload_1
    //   223: invokevirtual 76	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   226: astore 5
    //   228: aload_0
    //   229: aload_0
    //   230: getfield 78	com/tencent/ilink/tdi/b$s:b	I
    //   233: bipush 8
    //   235: ior
    //   236: putfield 78	com/tencent/ilink/tdi/b$s:b	I
    //   239: aload_0
    //   240: aload 5
    //   242: putfield 49	com/tencent/ilink/tdi/b$s:f	Ljava/lang/Object;
    //   245: goto -230 -> 15
    //   248: aload_1
    //   249: invokevirtual 76	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   252: astore 5
    //   254: aload_0
    //   255: aload_0
    //   256: getfield 78	com/tencent/ilink/tdi/b$s:b	I
    //   259: iconst_4
    //   260: ior
    //   261: putfield 78	com/tencent/ilink/tdi/b$s:b	I
    //   264: aload_0
    //   265: aload 5
    //   267: putfield 47	com/tencent/ilink/tdi/b$s:e	Ljava/lang/Object;
    //   270: goto -255 -> 15
    //   273: aload_0
    //   274: aload_0
    //   275: getfield 78	com/tencent/ilink/tdi/b$s:b	I
    //   278: iconst_2
    //   279: ior
    //   280: putfield 78	com/tencent/ilink/tdi/b$s:b	I
    //   283: aload_0
    //   284: aload_1
    //   285: invokevirtual 99	com/google/protobuf/CodedInputStream:f	()I
    //   288: putfield 101	com/tencent/ilink/tdi/b$s:d	I
    //   291: goto -276 -> 15
    //   294: aload_1
    //   295: invokevirtual 76	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   298: astore 5
    //   300: aload_0
    //   301: iconst_1
    //   302: aload_0
    //   303: getfield 78	com/tencent/ilink/tdi/b$s:b	I
    //   306: ior
    //   307: putfield 78	com/tencent/ilink/tdi/b$s:b	I
    //   310: aload_0
    //   311: aload 5
    //   313: putfield 45	com/tencent/ilink/tdi/b$s:c	Ljava/lang/Object;
    //   316: goto -301 -> 15
    //   319: iconst_1
    //   320: istore_3
    //   321: goto -306 -> 15
    //   324: astore_1
    //   325: goto +24 -> 349
    //   328: astore_1
    //   329: new 56	com/google/protobuf/InvalidProtocolBufferException
    //   332: dup
    //   333: aload_1
    //   334: invokespecial 104	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/io/IOException;)V
    //   337: aload_0
    //   338: invokevirtual 108	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   341: athrow
    //   342: astore_1
    //   343: aload_1
    //   344: aload_0
    //   345: invokevirtual 108	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   348: athrow
    //   349: aload_0
    //   350: aload 6
    //   352: invokevirtual 113	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   355: putfield 117	com/tencent/ilink/tdi/b$s:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   358: aload_0
    //   359: invokevirtual 120	com/tencent/ilink/tdi/b$s:makeExtensionsImmutable	()V
    //   362: aload_1
    //   363: athrow
    //   364: aload_0
    //   365: aload 6
    //   367: invokevirtual 113	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   370: putfield 117	com/tencent/ilink/tdi/b$s:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   373: aload_0
    //   374: invokevirtual 120	com/tencent/ilink/tdi/b$s:makeExtensionsImmutable	()V
    //   377: return
    //   378: new 122	java/lang/NullPointerException
    //   381: dup
    //   382: invokespecial 123	java/lang/NullPointerException:<init>	()V
    //   385: astore_1
    //   386: goto +5 -> 391
    //   389: aload_1
    //   390: athrow
    //   391: goto -2 -> 389
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	394	0	this	s
    //   0	394	1	paramCodedInputStream	com.google.protobuf.CodedInputStream
    //   0	394	2	paramExtensionRegistryLite	com.google.protobuf.ExtensionRegistryLite
    //   14	307	3	m	int
    //   23	62	4	n	int
    //   99	213	5	localObject	Object
    //   11	355	6	localBuilder	com.google.protobuf.UnknownFieldSet.Builder
    // Exception table:
    //   from	to	target	type
    //   19	25	324	finally
    //   79	92	324	finally
    //   95	118	324	finally
    //   124	143	324	finally
    //   143	158	324	finally
    //   163	182	324	finally
    //   182	193	324	finally
    //   196	219	324	finally
    //   222	245	324	finally
    //   248	270	324	finally
    //   273	291	324	finally
    //   294	316	324	finally
    //   329	342	324	finally
    //   343	349	324	finally
    //   19	25	328	java/io/IOException
    //   79	92	328	java/io/IOException
    //   95	118	328	java/io/IOException
    //   124	143	328	java/io/IOException
    //   143	158	328	java/io/IOException
    //   163	182	328	java/io/IOException
    //   182	193	328	java/io/IOException
    //   196	219	328	java/io/IOException
    //   222	245	328	java/io/IOException
    //   248	270	328	java/io/IOException
    //   273	291	328	java/io/IOException
    //   294	316	328	java/io/IOException
    //   19	25	342	com/google/protobuf/InvalidProtocolBufferException
    //   79	92	342	com/google/protobuf/InvalidProtocolBufferException
    //   95	118	342	com/google/protobuf/InvalidProtocolBufferException
    //   124	143	342	com/google/protobuf/InvalidProtocolBufferException
    //   143	158	342	com/google/protobuf/InvalidProtocolBufferException
    //   163	182	342	com/google/protobuf/InvalidProtocolBufferException
    //   182	193	342	com/google/protobuf/InvalidProtocolBufferException
    //   196	219	342	com/google/protobuf/InvalidProtocolBufferException
    //   222	245	342	com/google/protobuf/InvalidProtocolBufferException
    //   248	270	342	com/google/protobuf/InvalidProtocolBufferException
    //   273	291	342	com/google/protobuf/InvalidProtocolBufferException
    //   294	316	342	com/google/protobuf/InvalidProtocolBufferException
  }
  
  private b$s(GeneratedMessageV3.Builder<?> paramBuilder)
  {
    super(paramBuilder);
  }
  
  public static final Descriptors.Descriptor a()
  {
    return b.d();
  }
  
  public static b.s.a q()
  {
    return k.r();
  }
  
  public static s s()
  {
    return k;
  }
  
  protected b.s.a a(GeneratedMessageV3.BuilderParent paramBuilderParent)
  {
    return new b.s.a(paramBuilderParent, null);
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
    if (!(paramObject instanceof s)) {
      return super.equals(paramObject);
    }
    paramObject = (s)paramObject;
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
  
  public Parser<s> getParserForType()
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
      n = 0 + GeneratedMessageV3.computeStringSize(1, this.c);
    }
    m = n;
    if ((this.b & 0x2) != 0) {
      m = n + CodedOutputStream.h(2, this.d);
    }
    n = m;
    if ((this.b & 0x4) != 0) {
      n = m + GeneratedMessageV3.computeStringSize(3, this.e);
    }
    m = n;
    if ((this.b & 0x8) != 0) {
      m = n + GeneratedMessageV3.computeStringSize(4, this.f);
    }
    n = m;
    if ((this.b & 0x10) != 0) {
      n = m + GeneratedMessageV3.computeStringSize(5, this.g);
    }
    m = n;
    if ((this.b & 0x20) != 0) {
      m = n + CodedOutputStream.c(6, m());
    }
    n = m;
    if ((this.b & 0x40) != 0) {
      n = m + GeneratedMessageV3.computeStringSize(7, this.i);
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
      m = (n * 37 + 1) * 53 + c().hashCode();
    }
    n = m;
    if (d()) {
      n = (m * 37 + 2) * 53 + e();
    }
    m = n;
    if (f()) {
      m = (n * 37 + 3) * 53 + g().hashCode();
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
      m = (n * 37 + 7) * 53 + o().hashCode();
    }
    m = m * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = m;
    return m;
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
    return b.e().a(s.class, b.s.a.class);
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
  
  public b.t m()
  {
    b.t localt2 = this.h;
    b.t localt1 = localt2;
    if (localt2 == null) {
      localt1 = b.t.k();
    }
    return localt1;
  }
  
  public boolean n()
  {
    return (this.b & 0x40) != 0;
  }
  
  protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter paramUnusedPrivateParameter)
  {
    return new s();
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
  
  public b.s.a p()
  {
    return q();
  }
  
  public b.s.a r()
  {
    if (this == k) {
      return new b.s.a(null);
    }
    return new b.s.a(null).a(this);
  }
  
  public s t()
  {
    return k;
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
      paramCodedOutputStream.a(6, m());
    }
    if ((this.b & 0x40) != 0) {
      GeneratedMessageV3.writeString(paramCodedOutputStream, 7, this.i);
    }
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilink.tdi.b.s
 * JD-Core Version:    0.7.0.1
 */