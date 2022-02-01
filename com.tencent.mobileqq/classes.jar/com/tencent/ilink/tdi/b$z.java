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

public final class b$z
  extends GeneratedMessageV3
  implements w
{
  @Deprecated
  public static final Parser<z> a = new b.z.1();
  private static final z i = new z();
  private int b;
  private int c;
  private int d;
  private long e;
  private volatile Object f;
  private int g;
  private byte h = -1;
  
  private b$z()
  {
    this.c = -1;
    this.f = "";
    this.g = 0;
  }
  
  /* Error */
  private b$z(com.google.protobuf.CodedInputStream paramCodedInputStream, com.google.protobuf.ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 28	com/tencent/ilink/tdi/b$z:<init>	()V
    //   4: aload_2
    //   5: ifnull +294 -> 299
    //   8: invokestatic 57	com/google/protobuf/UnknownFieldSet:a	()Lcom/google/protobuf/UnknownFieldSet$Builder;
    //   11: astore 5
    //   13: iconst_0
    //   14: istore_3
    //   15: iload_3
    //   16: ifne +269 -> 285
    //   19: aload_1
    //   20: invokevirtual 62	com/google/protobuf/CodedInputStream:a	()I
    //   23: istore 4
    //   25: iload 4
    //   27: ifeq +213 -> 240
    //   30: iload 4
    //   32: bipush 8
    //   34: if_icmpeq +161 -> 195
    //   37: iload 4
    //   39: bipush 16
    //   41: if_icmpeq +133 -> 174
    //   44: iload 4
    //   46: bipush 24
    //   48: if_icmpeq +105 -> 153
    //   51: iload 4
    //   53: bipush 34
    //   55: if_icmpeq +72 -> 127
    //   58: iload 4
    //   60: bipush 40
    //   62: if_icmpeq +19 -> 81
    //   65: aload_0
    //   66: aload_1
    //   67: aload 5
    //   69: aload_2
    //   70: iload 4
    //   72: invokevirtual 66	com/tencent/ilink/tdi/b$z:parseUnknownField	(Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/UnknownFieldSet$Builder;Lcom/google/protobuf/ExtensionRegistryLite;I)Z
    //   75: ifne -60 -> 15
    //   78: goto +162 -> 240
    //   81: aload_1
    //   82: invokevirtual 69	com/google/protobuf/CodedInputStream:n	()I
    //   85: istore 4
    //   87: iload 4
    //   89: invokestatic 74	com/tencent/ilink/tdi/b$w:a	(I)Lcom/tencent/ilink/tdi/b$w;
    //   92: ifnonnull +15 -> 107
    //   95: aload 5
    //   97: iconst_5
    //   98: iload 4
    //   100: invokevirtual 79	com/google/protobuf/UnknownFieldSet$Builder:a	(II)Lcom/google/protobuf/UnknownFieldSet$Builder;
    //   103: pop
    //   104: goto -89 -> 15
    //   107: aload_0
    //   108: aload_0
    //   109: getfield 81	com/tencent/ilink/tdi/b$z:b	I
    //   112: bipush 16
    //   114: ior
    //   115: putfield 81	com/tencent/ilink/tdi/b$z:b	I
    //   118: aload_0
    //   119: iload 4
    //   121: putfield 47	com/tencent/ilink/tdi/b$z:g	I
    //   124: goto -109 -> 15
    //   127: aload_1
    //   128: invokevirtual 85	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   131: astore 6
    //   133: aload_0
    //   134: aload_0
    //   135: getfield 81	com/tencent/ilink/tdi/b$z:b	I
    //   138: bipush 8
    //   140: ior
    //   141: putfield 81	com/tencent/ilink/tdi/b$z:b	I
    //   144: aload_0
    //   145: aload 6
    //   147: putfield 45	com/tencent/ilink/tdi/b$z:f	Ljava/lang/Object;
    //   150: goto -135 -> 15
    //   153: aload_0
    //   154: aload_0
    //   155: getfield 81	com/tencent/ilink/tdi/b$z:b	I
    //   158: iconst_4
    //   159: ior
    //   160: putfield 81	com/tencent/ilink/tdi/b$z:b	I
    //   163: aload_0
    //   164: aload_1
    //   165: invokevirtual 88	com/google/protobuf/CodedInputStream:d	()J
    //   168: putfield 90	com/tencent/ilink/tdi/b$z:e	J
    //   171: goto -156 -> 15
    //   174: aload_0
    //   175: aload_0
    //   176: getfield 81	com/tencent/ilink/tdi/b$z:b	I
    //   179: iconst_2
    //   180: ior
    //   181: putfield 81	com/tencent/ilink/tdi/b$z:b	I
    //   184: aload_0
    //   185: aload_1
    //   186: invokevirtual 93	com/google/protobuf/CodedInputStream:m	()I
    //   189: putfield 95	com/tencent/ilink/tdi/b$z:d	I
    //   192: goto -177 -> 15
    //   195: aload_1
    //   196: invokevirtual 69	com/google/protobuf/CodedInputStream:n	()I
    //   199: istore 4
    //   201: iload 4
    //   203: invokestatic 100	com/tencent/ilink/tdi/b$x:a	(I)Lcom/tencent/ilink/tdi/b$x;
    //   206: ifnonnull +15 -> 221
    //   209: aload 5
    //   211: iconst_1
    //   212: iload 4
    //   214: invokevirtual 79	com/google/protobuf/UnknownFieldSet$Builder:a	(II)Lcom/google/protobuf/UnknownFieldSet$Builder;
    //   217: pop
    //   218: goto -203 -> 15
    //   221: aload_0
    //   222: iconst_1
    //   223: aload_0
    //   224: getfield 81	com/tencent/ilink/tdi/b$z:b	I
    //   227: ior
    //   228: putfield 81	com/tencent/ilink/tdi/b$z:b	I
    //   231: aload_0
    //   232: iload 4
    //   234: putfield 41	com/tencent/ilink/tdi/b$z:c	I
    //   237: goto -222 -> 15
    //   240: iconst_1
    //   241: istore_3
    //   242: goto -227 -> 15
    //   245: astore_1
    //   246: goto +24 -> 270
    //   249: astore_1
    //   250: new 50	com/google/protobuf/InvalidProtocolBufferException
    //   253: dup
    //   254: aload_1
    //   255: invokespecial 103	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/io/IOException;)V
    //   258: aload_0
    //   259: invokevirtual 107	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   262: athrow
    //   263: astore_1
    //   264: aload_1
    //   265: aload_0
    //   266: invokevirtual 107	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   269: athrow
    //   270: aload_0
    //   271: aload 5
    //   273: invokevirtual 110	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   276: putfield 114	com/tencent/ilink/tdi/b$z:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   279: aload_0
    //   280: invokevirtual 117	com/tencent/ilink/tdi/b$z:makeExtensionsImmutable	()V
    //   283: aload_1
    //   284: athrow
    //   285: aload_0
    //   286: aload 5
    //   288: invokevirtual 110	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   291: putfield 114	com/tencent/ilink/tdi/b$z:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   294: aload_0
    //   295: invokevirtual 117	com/tencent/ilink/tdi/b$z:makeExtensionsImmutable	()V
    //   298: return
    //   299: new 119	java/lang/NullPointerException
    //   302: dup
    //   303: invokespecial 120	java/lang/NullPointerException:<init>	()V
    //   306: astore_1
    //   307: goto +5 -> 312
    //   310: aload_1
    //   311: athrow
    //   312: goto -2 -> 310
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	315	0	this	z
    //   0	315	1	paramCodedInputStream	com.google.protobuf.CodedInputStream
    //   0	315	2	paramExtensionRegistryLite	com.google.protobuf.ExtensionRegistryLite
    //   14	228	3	j	int
    //   23	210	4	k	int
    //   11	276	5	localBuilder	com.google.protobuf.UnknownFieldSet.Builder
    //   131	15	6	localByteString	ByteString
    // Exception table:
    //   from	to	target	type
    //   19	25	245	finally
    //   65	78	245	finally
    //   81	104	245	finally
    //   107	124	245	finally
    //   127	150	245	finally
    //   153	171	245	finally
    //   174	192	245	finally
    //   195	218	245	finally
    //   221	237	245	finally
    //   250	263	245	finally
    //   264	270	245	finally
    //   19	25	249	java/io/IOException
    //   65	78	249	java/io/IOException
    //   81	104	249	java/io/IOException
    //   107	124	249	java/io/IOException
    //   127	150	249	java/io/IOException
    //   153	171	249	java/io/IOException
    //   174	192	249	java/io/IOException
    //   195	218	249	java/io/IOException
    //   221	237	249	java/io/IOException
    //   19	25	263	com/google/protobuf/InvalidProtocolBufferException
    //   65	78	263	com/google/protobuf/InvalidProtocolBufferException
    //   81	104	263	com/google/protobuf/InvalidProtocolBufferException
    //   107	124	263	com/google/protobuf/InvalidProtocolBufferException
    //   127	150	263	com/google/protobuf/InvalidProtocolBufferException
    //   153	171	263	com/google/protobuf/InvalidProtocolBufferException
    //   174	192	263	com/google/protobuf/InvalidProtocolBufferException
    //   195	218	263	com/google/protobuf/InvalidProtocolBufferException
    //   221	237	263	com/google/protobuf/InvalidProtocolBufferException
  }
  
  private b$z(GeneratedMessageV3.Builder<?> paramBuilder)
  {
    super(paramBuilder);
  }
  
  public static final Descriptors.Descriptor a()
  {
    return b.B();
  }
  
  public static z a(byte[] paramArrayOfByte)
  {
    return (z)a.parseFrom(paramArrayOfByte);
  }
  
  public static b.z.a m()
  {
    return i.n();
  }
  
  public static z o()
  {
    return i;
  }
  
  protected b.z.a a(GeneratedMessageV3.BuilderParent paramBuilderParent)
  {
    return new b.z.a(paramBuilderParent, null);
  }
  
  public boolean b()
  {
    return (this.b & 0x1) != 0;
  }
  
  public b.x c()
  {
    b.x localx2 = b.x.a(this.c);
    b.x localx1 = localx2;
    if (localx2 == null) {
      localx1 = b.x.a;
    }
    return localx1;
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
    if (!(paramObject instanceof z)) {
      return super.equals(paramObject);
    }
    paramObject = (z)paramObject;
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
    if ((j()) && (this.g != paramObject.g)) {
      return false;
    }
    return this.unknownFields.equals(paramObject.unknownFields);
  }
  
  public boolean f()
  {
    return (this.b & 0x4) != 0;
  }
  
  public long g()
  {
    return this.e;
  }
  
  public Parser<z> getParserForType()
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
      j = k + CodedOutputStream.i(2, this.d);
    }
    k = j;
    if ((this.b & 0x4) != 0) {
      k = j + CodedOutputStream.g(3, this.e);
    }
    j = k;
    if ((this.b & 0x8) != 0) {
      j = k + GeneratedMessageV3.computeStringSize(4, this.f);
    }
    k = j;
    if ((this.b & 0x10) != 0) {
      k = j + CodedOutputStream.m(5, this.g);
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
      k = (j * 37 + 2) * 53 + e();
    }
    j = k;
    if (f()) {
      j = (k * 37 + 3) * 53 + Internal.a(g());
    }
    k = j;
    if (h()) {
      k = (j * 37 + 4) * 53 + i().hashCode();
    }
    j = k;
    if (j()) {
      j = (k * 37 + 5) * 53 + this.g;
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
    return b.C().a(z.class, b.z.a.class);
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
  
  public b.w k()
  {
    b.w localw2 = b.w.a(this.g);
    b.w localw1 = localw2;
    if (localw2 == null) {
      localw1 = b.w.a;
    }
    return localw1;
  }
  
  public b.z.a l()
  {
    return m();
  }
  
  public b.z.a n()
  {
    if (this == i) {
      return new b.z.a(null);
    }
    return new b.z.a(null).a(this);
  }
  
  protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter paramUnusedPrivateParameter)
  {
    return new z();
  }
  
  public z p()
  {
    return i;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
  {
    if ((this.b & 0x1) != 0) {
      paramCodedOutputStream.g(1, this.c);
    }
    if ((this.b & 0x2) != 0) {
      paramCodedOutputStream.c(2, this.d);
    }
    if ((this.b & 0x4) != 0) {
      paramCodedOutputStream.b(3, this.e);
    }
    if ((this.b & 0x8) != 0) {
      GeneratedMessageV3.writeString(paramCodedOutputStream, 4, this.f);
    }
    if ((this.b & 0x10) != 0) {
      paramCodedOutputStream.g(5, this.g);
    }
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilink.tdi.b.z
 * JD-Core Version:    0.7.0.1
 */