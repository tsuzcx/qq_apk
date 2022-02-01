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

public final class b$g
  extends GeneratedMessageV3
  implements h
{
  @Deprecated
  public static final Parser<g> a = new b.g.1();
  private static final g i = new g();
  private int b;
  private int c;
  private long d;
  private volatile Object e;
  private volatile Object f;
  private ByteString g;
  private byte h = -1;
  
  private b$g()
  {
    this.c = 0;
    this.e = "";
    this.f = "";
    this.g = ByteString.EMPTY;
  }
  
  /* Error */
  private b$g(com.google.protobuf.CodedInputStream paramCodedInputStream, com.google.protobuf.ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 29	com/tencent/ilink/tdi/b$g:<init>	()V
    //   4: aload_2
    //   5: ifnull +274 -> 279
    //   8: invokestatic 65	com/google/protobuf/UnknownFieldSet:a	()Lcom/google/protobuf/UnknownFieldSet$Builder;
    //   11: astore 5
    //   13: iconst_0
    //   14: istore_3
    //   15: iload_3
    //   16: ifne +249 -> 265
    //   19: aload_1
    //   20: invokevirtual 70	com/google/protobuf/CodedInputStream:a	()I
    //   23: istore 4
    //   25: iload 4
    //   27: ifeq +193 -> 220
    //   30: iload 4
    //   32: bipush 8
    //   34: if_icmpeq +141 -> 175
    //   37: iload 4
    //   39: bipush 16
    //   41: if_icmpeq +113 -> 154
    //   44: iload 4
    //   46: bipush 26
    //   48: if_icmpeq +81 -> 129
    //   51: iload 4
    //   53: bipush 34
    //   55: if_icmpeq +48 -> 103
    //   58: iload 4
    //   60: bipush 42
    //   62: if_icmpeq +19 -> 81
    //   65: aload_0
    //   66: aload_1
    //   67: aload 5
    //   69: aload_2
    //   70: iload 4
    //   72: invokevirtual 74	com/tencent/ilink/tdi/b$g:parseUnknownField	(Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/UnknownFieldSet$Builder;Lcom/google/protobuf/ExtensionRegistryLite;I)Z
    //   75: ifne -60 -> 15
    //   78: goto +142 -> 220
    //   81: aload_0
    //   82: aload_0
    //   83: getfield 76	com/tencent/ilink/tdi/b$g:b	I
    //   86: bipush 16
    //   88: ior
    //   89: putfield 76	com/tencent/ilink/tdi/b$g:b	I
    //   92: aload_0
    //   93: aload_1
    //   94: invokevirtual 80	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   97: putfield 55	com/tencent/ilink/tdi/b$g:g	Lcom/google/protobuf/ByteString;
    //   100: goto -85 -> 15
    //   103: aload_1
    //   104: invokevirtual 80	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   107: astore 6
    //   109: aload_0
    //   110: aload_0
    //   111: getfield 76	com/tencent/ilink/tdi/b$g:b	I
    //   114: bipush 8
    //   116: ior
    //   117: putfield 76	com/tencent/ilink/tdi/b$g:b	I
    //   120: aload_0
    //   121: aload 6
    //   123: putfield 48	com/tencent/ilink/tdi/b$g:f	Ljava/lang/Object;
    //   126: goto -111 -> 15
    //   129: aload_1
    //   130: invokevirtual 80	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   133: astore 6
    //   135: aload_0
    //   136: aload_0
    //   137: getfield 76	com/tencent/ilink/tdi/b$g:b	I
    //   140: iconst_4
    //   141: ior
    //   142: putfield 76	com/tencent/ilink/tdi/b$g:b	I
    //   145: aload_0
    //   146: aload 6
    //   148: putfield 46	com/tencent/ilink/tdi/b$g:e	Ljava/lang/Object;
    //   151: goto -136 -> 15
    //   154: aload_0
    //   155: aload_0
    //   156: getfield 76	com/tencent/ilink/tdi/b$g:b	I
    //   159: iconst_2
    //   160: ior
    //   161: putfield 76	com/tencent/ilink/tdi/b$g:b	I
    //   164: aload_0
    //   165: aload_1
    //   166: invokevirtual 83	com/google/protobuf/CodedInputStream:d	()J
    //   169: putfield 85	com/tencent/ilink/tdi/b$g:d	J
    //   172: goto -157 -> 15
    //   175: aload_1
    //   176: invokevirtual 88	com/google/protobuf/CodedInputStream:n	()I
    //   179: istore 4
    //   181: iload 4
    //   183: invokestatic 93	com/tencent/ilink/tdi/a$f:a	(I)Lcom/tencent/ilink/tdi/a$f;
    //   186: ifnonnull +15 -> 201
    //   189: aload 5
    //   191: iconst_1
    //   192: iload 4
    //   194: invokevirtual 98	com/google/protobuf/UnknownFieldSet$Builder:a	(II)Lcom/google/protobuf/UnknownFieldSet$Builder;
    //   197: pop
    //   198: goto -183 -> 15
    //   201: aload_0
    //   202: iconst_1
    //   203: aload_0
    //   204: getfield 76	com/tencent/ilink/tdi/b$g:b	I
    //   207: ior
    //   208: putfield 76	com/tencent/ilink/tdi/b$g:b	I
    //   211: aload_0
    //   212: iload 4
    //   214: putfield 42	com/tencent/ilink/tdi/b$g:c	I
    //   217: goto -202 -> 15
    //   220: iconst_1
    //   221: istore_3
    //   222: goto -207 -> 15
    //   225: astore_1
    //   226: goto +24 -> 250
    //   229: astore_1
    //   230: new 58	com/google/protobuf/InvalidProtocolBufferException
    //   233: dup
    //   234: aload_1
    //   235: invokespecial 101	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/io/IOException;)V
    //   238: aload_0
    //   239: invokevirtual 105	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   242: athrow
    //   243: astore_1
    //   244: aload_1
    //   245: aload_0
    //   246: invokevirtual 105	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   249: athrow
    //   250: aload_0
    //   251: aload 5
    //   253: invokevirtual 108	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   256: putfield 112	com/tencent/ilink/tdi/b$g:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   259: aload_0
    //   260: invokevirtual 115	com/tencent/ilink/tdi/b$g:makeExtensionsImmutable	()V
    //   263: aload_1
    //   264: athrow
    //   265: aload_0
    //   266: aload 5
    //   268: invokevirtual 108	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   271: putfield 112	com/tencent/ilink/tdi/b$g:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   274: aload_0
    //   275: invokevirtual 115	com/tencent/ilink/tdi/b$g:makeExtensionsImmutable	()V
    //   278: return
    //   279: new 117	java/lang/NullPointerException
    //   282: dup
    //   283: invokespecial 118	java/lang/NullPointerException:<init>	()V
    //   286: astore_1
    //   287: goto +5 -> 292
    //   290: aload_1
    //   291: athrow
    //   292: goto -2 -> 290
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	295	0	this	g
    //   0	295	1	paramCodedInputStream	com.google.protobuf.CodedInputStream
    //   0	295	2	paramExtensionRegistryLite	com.google.protobuf.ExtensionRegistryLite
    //   14	208	3	j	int
    //   23	190	4	k	int
    //   11	256	5	localBuilder	com.google.protobuf.UnknownFieldSet.Builder
    //   107	40	6	localByteString	ByteString
    // Exception table:
    //   from	to	target	type
    //   19	25	225	finally
    //   65	78	225	finally
    //   81	100	225	finally
    //   103	126	225	finally
    //   129	151	225	finally
    //   154	172	225	finally
    //   175	198	225	finally
    //   201	217	225	finally
    //   230	243	225	finally
    //   244	250	225	finally
    //   19	25	229	java/io/IOException
    //   65	78	229	java/io/IOException
    //   81	100	229	java/io/IOException
    //   103	126	229	java/io/IOException
    //   129	151	229	java/io/IOException
    //   154	172	229	java/io/IOException
    //   175	198	229	java/io/IOException
    //   201	217	229	java/io/IOException
    //   19	25	243	com/google/protobuf/InvalidProtocolBufferException
    //   65	78	243	com/google/protobuf/InvalidProtocolBufferException
    //   81	100	243	com/google/protobuf/InvalidProtocolBufferException
    //   103	126	243	com/google/protobuf/InvalidProtocolBufferException
    //   129	151	243	com/google/protobuf/InvalidProtocolBufferException
    //   154	172	243	com/google/protobuf/InvalidProtocolBufferException
    //   175	198	243	com/google/protobuf/InvalidProtocolBufferException
    //   201	217	243	com/google/protobuf/InvalidProtocolBufferException
  }
  
  private b$g(GeneratedMessageV3.Builder<?> paramBuilder)
  {
    super(paramBuilder);
  }
  
  public static final Descriptors.Descriptor a()
  {
    return b.z();
  }
  
  public static g a(byte[] paramArrayOfByte)
  {
    return (g)a.parseFrom(paramArrayOfByte);
  }
  
  public static b.g.a m()
  {
    return i.n();
  }
  
  public static g o()
  {
    return i;
  }
  
  protected b.g.a a(GeneratedMessageV3.BuilderParent paramBuilderParent)
  {
    return new b.g.a(paramBuilderParent, null);
  }
  
  public boolean b()
  {
    return (this.b & 0x1) != 0;
  }
  
  public a.f c()
  {
    a.f localf2 = a.f.a(this.c);
    a.f localf1 = localf2;
    if (localf2 == null) {
      localf1 = a.f.a;
    }
    return localf1;
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
    if (!(paramObject instanceof g)) {
      return super.equals(paramObject);
    }
    paramObject = (g)paramObject;
    if (b() != paramObject.b()) {
      return false;
    }
    if ((b()) && (this.c != paramObject.c)) {
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
  
  public Parser<g> getParserForType()
  {
    return a;
  }
  
  public int getSerializedSize()
  {
    int j = this.memoizedSize;
    if (j != -1) {
      return j;
    }
    int k = 0;
    if ((this.b & 0x1) != 0) {
      k = 0 + CodedOutputStream.m(1, this.c);
    }
    j = k;
    if ((this.b & 0x2) != 0) {
      j = k + CodedOutputStream.g(2, this.d);
    }
    k = j;
    if ((this.b & 0x4) != 0) {
      k = j + GeneratedMessageV3.computeStringSize(3, this.e);
    }
    j = k;
    if ((this.b & 0x8) != 0) {
      j = k + GeneratedMessageV3.computeStringSize(4, this.f);
    }
    k = j;
    if ((this.b & 0x10) != 0) {
      k = j + CodedOutputStream.c(5, this.g);
    }
    j = k + this.unknownFields.getSerializedSize();
    this.memoizedSize = j;
    return j;
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
    int k = 779 + a().hashCode();
    int j = k;
    if (b()) {
      j = (k * 37 + 1) * 53 + this.c;
    }
    k = j;
    if (d()) {
      k = (j * 37 + 2) * 53 + Internal.a(e());
    }
    j = k;
    if (f()) {
      j = (k * 37 + 3) * 53 + g().hashCode();
    }
    k = j;
    if (h()) {
      k = (j * 37 + 4) * 53 + i().hashCode();
    }
    j = k;
    if (j()) {
      j = (k * 37 + 5) * 53 + k().hashCode();
    }
    j = j * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = j;
    return j;
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
    return b.A().a(g.class, b.g.a.class);
  }
  
  public final boolean isInitialized()
  {
    int j = this.h;
    if (j == 1) {
      return true;
    }
    if (j == 0) {
      return false;
    }
    this.h = 1;
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
  
  public b.g.a l()
  {
    return m();
  }
  
  public b.g.a n()
  {
    if (this == i) {
      return new b.g.a(null);
    }
    return new b.g.a(null).a(this);
  }
  
  protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter paramUnusedPrivateParameter)
  {
    return new g();
  }
  
  public g p()
  {
    return i;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
  {
    if ((this.b & 0x1) != 0) {
      paramCodedOutputStream.g(1, this.c);
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
      paramCodedOutputStream.a(5, this.g);
    }
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilink.tdi.b.g
 * JD-Core Version:    0.7.0.1
 */