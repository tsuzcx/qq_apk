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

public final class ag$b
  extends GeneratedMessageV3
  implements ai
{
  @Deprecated
  public static final Parser<b> a = new ag.b.1();
  private static final b j = new b();
  private int b;
  private int c;
  private int d;
  private ByteString e;
  private boolean f;
  private boolean g;
  private int h;
  private byte i = -1;
  
  private ag$b()
  {
    this.e = ByteString.EMPTY;
  }
  
  /* Error */
  private ag$b(com.google.protobuf.CodedInputStream paramCodedInputStream, com.google.protobuf.ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 29	com/tencent/ilinkservice/ag$b:<init>	()V
    //   4: aload_2
    //   5: ifnull +271 -> 276
    //   8: invokestatic 57	com/google/protobuf/UnknownFieldSet:a	()Lcom/google/protobuf/UnknownFieldSet$Builder;
    //   11: astore 5
    //   13: iconst_0
    //   14: istore_3
    //   15: iload_3
    //   16: ifne +246 -> 262
    //   19: aload_1
    //   20: invokevirtual 62	com/google/protobuf/CodedInputStream:a	()I
    //   23: istore 4
    //   25: iload 4
    //   27: ifeq +190 -> 217
    //   30: iload 4
    //   32: bipush 8
    //   34: if_icmpeq +162 -> 196
    //   37: iload 4
    //   39: bipush 16
    //   41: if_icmpeq +134 -> 175
    //   44: iload 4
    //   46: bipush 26
    //   48: if_icmpeq +106 -> 154
    //   51: iload 4
    //   53: bipush 32
    //   55: if_icmpeq +77 -> 132
    //   58: iload 4
    //   60: bipush 40
    //   62: if_icmpeq +48 -> 110
    //   65: iload 4
    //   67: bipush 48
    //   69: if_icmpeq +19 -> 88
    //   72: aload_0
    //   73: aload_1
    //   74: aload 5
    //   76: aload_2
    //   77: iload 4
    //   79: invokevirtual 66	com/tencent/ilinkservice/ag$b:parseUnknownField	(Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/UnknownFieldSet$Builder;Lcom/google/protobuf/ExtensionRegistryLite;I)Z
    //   82: ifne -67 -> 15
    //   85: goto +132 -> 217
    //   88: aload_0
    //   89: aload_0
    //   90: getfield 68	com/tencent/ilinkservice/ag$b:b	I
    //   93: bipush 32
    //   95: ior
    //   96: putfield 68	com/tencent/ilinkservice/ag$b:b	I
    //   99: aload_0
    //   100: aload_1
    //   101: invokevirtual 71	com/google/protobuf/CodedInputStream:m	()I
    //   104: putfield 73	com/tencent/ilinkservice/ag$b:h	I
    //   107: goto -92 -> 15
    //   110: aload_0
    //   111: aload_0
    //   112: getfield 68	com/tencent/ilinkservice/ag$b:b	I
    //   115: bipush 16
    //   117: ior
    //   118: putfield 68	com/tencent/ilinkservice/ag$b:b	I
    //   121: aload_0
    //   122: aload_1
    //   123: invokevirtual 76	com/google/protobuf/CodedInputStream:i	()Z
    //   126: putfield 78	com/tencent/ilinkservice/ag$b:g	Z
    //   129: goto -114 -> 15
    //   132: aload_0
    //   133: aload_0
    //   134: getfield 68	com/tencent/ilinkservice/ag$b:b	I
    //   137: bipush 8
    //   139: ior
    //   140: putfield 68	com/tencent/ilinkservice/ag$b:b	I
    //   143: aload_0
    //   144: aload_1
    //   145: invokevirtual 76	com/google/protobuf/CodedInputStream:i	()Z
    //   148: putfield 80	com/tencent/ilinkservice/ag$b:f	Z
    //   151: goto -136 -> 15
    //   154: aload_0
    //   155: aload_0
    //   156: getfield 68	com/tencent/ilinkservice/ag$b:b	I
    //   159: iconst_4
    //   160: ior
    //   161: putfield 68	com/tencent/ilinkservice/ag$b:b	I
    //   164: aload_0
    //   165: aload_1
    //   166: invokevirtual 84	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   169: putfield 47	com/tencent/ilinkservice/ag$b:e	Lcom/google/protobuf/ByteString;
    //   172: goto -157 -> 15
    //   175: aload_0
    //   176: aload_0
    //   177: getfield 68	com/tencent/ilinkservice/ag$b:b	I
    //   180: iconst_2
    //   181: ior
    //   182: putfield 68	com/tencent/ilinkservice/ag$b:b	I
    //   185: aload_0
    //   186: aload_1
    //   187: invokevirtual 71	com/google/protobuf/CodedInputStream:m	()I
    //   190: putfield 86	com/tencent/ilinkservice/ag$b:d	I
    //   193: goto -178 -> 15
    //   196: aload_0
    //   197: aload_0
    //   198: getfield 68	com/tencent/ilinkservice/ag$b:b	I
    //   201: iconst_1
    //   202: ior
    //   203: putfield 68	com/tencent/ilinkservice/ag$b:b	I
    //   206: aload_0
    //   207: aload_1
    //   208: invokevirtual 71	com/google/protobuf/CodedInputStream:m	()I
    //   211: putfield 88	com/tencent/ilinkservice/ag$b:c	I
    //   214: goto -199 -> 15
    //   217: iconst_1
    //   218: istore_3
    //   219: goto -204 -> 15
    //   222: astore_1
    //   223: goto +24 -> 247
    //   226: astore_1
    //   227: new 50	com/google/protobuf/InvalidProtocolBufferException
    //   230: dup
    //   231: aload_1
    //   232: invokespecial 91	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/io/IOException;)V
    //   235: aload_0
    //   236: invokevirtual 95	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   239: athrow
    //   240: astore_1
    //   241: aload_1
    //   242: aload_0
    //   243: invokevirtual 95	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   246: athrow
    //   247: aload_0
    //   248: aload 5
    //   250: invokevirtual 100	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   253: putfield 104	com/tencent/ilinkservice/ag$b:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   256: aload_0
    //   257: invokevirtual 107	com/tencent/ilinkservice/ag$b:makeExtensionsImmutable	()V
    //   260: aload_1
    //   261: athrow
    //   262: aload_0
    //   263: aload 5
    //   265: invokevirtual 100	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   268: putfield 104	com/tencent/ilinkservice/ag$b:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   271: aload_0
    //   272: invokevirtual 107	com/tencent/ilinkservice/ag$b:makeExtensionsImmutable	()V
    //   275: return
    //   276: new 109	java/lang/NullPointerException
    //   279: dup
    //   280: invokespecial 110	java/lang/NullPointerException:<init>	()V
    //   283: astore_1
    //   284: goto +5 -> 289
    //   287: aload_1
    //   288: athrow
    //   289: goto -2 -> 287
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	292	0	this	b
    //   0	292	1	paramCodedInputStream	com.google.protobuf.CodedInputStream
    //   0	292	2	paramExtensionRegistryLite	com.google.protobuf.ExtensionRegistryLite
    //   14	205	3	k	int
    //   23	55	4	m	int
    //   11	253	5	localBuilder	com.google.protobuf.UnknownFieldSet.Builder
    // Exception table:
    //   from	to	target	type
    //   19	25	222	finally
    //   72	85	222	finally
    //   88	107	222	finally
    //   110	129	222	finally
    //   132	151	222	finally
    //   154	172	222	finally
    //   175	193	222	finally
    //   196	214	222	finally
    //   227	240	222	finally
    //   241	247	222	finally
    //   19	25	226	java/io/IOException
    //   72	85	226	java/io/IOException
    //   88	107	226	java/io/IOException
    //   110	129	226	java/io/IOException
    //   132	151	226	java/io/IOException
    //   154	172	226	java/io/IOException
    //   175	193	226	java/io/IOException
    //   196	214	226	java/io/IOException
    //   19	25	240	com/google/protobuf/InvalidProtocolBufferException
    //   72	85	240	com/google/protobuf/InvalidProtocolBufferException
    //   88	107	240	com/google/protobuf/InvalidProtocolBufferException
    //   110	129	240	com/google/protobuf/InvalidProtocolBufferException
    //   132	151	240	com/google/protobuf/InvalidProtocolBufferException
    //   154	172	240	com/google/protobuf/InvalidProtocolBufferException
    //   175	193	240	com/google/protobuf/InvalidProtocolBufferException
    //   196	214	240	com/google/protobuf/InvalidProtocolBufferException
  }
  
  private ag$b(GeneratedMessageV3.Builder<?> paramBuilder)
  {
    super(paramBuilder);
  }
  
  public static final Descriptors.Descriptor a()
  {
    return ag.d();
  }
  
  public static ag.b.a o()
  {
    return j.p();
  }
  
  public static b q()
  {
    return j;
  }
  
  protected ag.b.a a(GeneratedMessageV3.BuilderParent paramBuilderParent)
  {
    return new ag.b.a(paramBuilderParent, null);
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
  
  public int e()
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
    if ((b()) && (c() != paramObject.c())) {
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
  
  public Parser<b> getParserForType()
  {
    return a;
  }
  
  public int getSerializedSize()
  {
    int k = this.memoizedSize;
    if (k != -1) {
      return k;
    }
    int m = 0;
    if ((this.b & 0x1) != 0) {
      m = 0 + CodedOutputStream.i(1, this.c);
    }
    k = m;
    if ((this.b & 0x2) != 0) {
      k = m + CodedOutputStream.i(2, this.d);
    }
    m = k;
    if ((this.b & 0x4) != 0) {
      m = k + CodedOutputStream.c(3, this.e);
    }
    k = m;
    if ((this.b & 0x8) != 0) {
      k = m + CodedOutputStream.b(4, this.f);
    }
    m = k;
    if ((this.b & 0x10) != 0) {
      m = k + CodedOutputStream.b(5, this.g);
    }
    k = m;
    if ((this.b & 0x20) != 0) {
      k = m + CodedOutputStream.i(6, this.h);
    }
    k += this.unknownFields.getSerializedSize();
    this.memoizedSize = k;
    return k;
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
    int m = 779 + a().hashCode();
    int k = m;
    if (b()) {
      k = (m * 37 + 1) * 53 + c();
    }
    m = k;
    if (d()) {
      m = (k * 37 + 2) * 53 + e();
    }
    k = m;
    if (f()) {
      k = (m * 37 + 3) * 53 + g().hashCode();
    }
    m = k;
    if (h()) {
      m = (k * 37 + 4) * 53 + Internal.a(i());
    }
    k = m;
    if (j()) {
      k = (m * 37 + 5) * 53 + Internal.a(k());
    }
    m = k;
    if (l()) {
      m = (k * 37 + 6) * 53 + m();
    }
    k = m * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = k;
    return k;
  }
  
  public boolean i()
  {
    return this.f;
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return ag.e().a(b.class, ag.b.a.class);
  }
  
  public final boolean isInitialized()
  {
    int k = this.i;
    if (k == 1) {
      return true;
    }
    if (k == 0) {
      return false;
    }
    this.i = 1;
    return true;
  }
  
  public boolean j()
  {
    return (this.b & 0x10) != 0;
  }
  
  public boolean k()
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
  
  public ag.b.a n()
  {
    return o();
  }
  
  protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter paramUnusedPrivateParameter)
  {
    return new b();
  }
  
  public ag.b.a p()
  {
    if (this == j) {
      return new ag.b.a(null);
    }
    return new ag.b.a(null).a(this);
  }
  
  public b r()
  {
    return j;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
  {
    if ((this.b & 0x1) != 0) {
      paramCodedOutputStream.c(1, this.c);
    }
    if ((this.b & 0x2) != 0) {
      paramCodedOutputStream.c(2, this.d);
    }
    if ((this.b & 0x4) != 0) {
      paramCodedOutputStream.a(3, this.e);
    }
    if ((this.b & 0x8) != 0) {
      paramCodedOutputStream.a(4, this.f);
    }
    if ((this.b & 0x10) != 0) {
      paramCodedOutputStream.a(5, this.g);
    }
    if ((this.b & 0x20) != 0) {
      paramCodedOutputStream.c(6, this.h);
    }
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilinkservice.ag.b
 * JD-Core Version:    0.7.0.1
 */