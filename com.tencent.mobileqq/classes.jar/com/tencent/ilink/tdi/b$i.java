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

public final class b$i
  extends GeneratedMessageV3
  implements i
{
  @Deprecated
  public static final Parser<i> a = new b.i.1();
  private static final i i = new i();
  private int b;
  private int c;
  private int d;
  private int e;
  private ByteString f;
  private int g;
  private byte h = -1;
  
  private b$i()
  {
    this.d = 1;
    this.e = -1;
    this.f = ByteString.EMPTY;
  }
  
  /* Error */
  private b$i(com.google.protobuf.CodedInputStream paramCodedInputStream, com.google.protobuf.ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 27	com/tencent/ilink/tdi/b$i:<init>	()V
    //   4: aload_2
    //   5: ifnull +290 -> 295
    //   8: invokestatic 59	com/google/protobuf/UnknownFieldSet:a	()Lcom/google/protobuf/UnknownFieldSet$Builder;
    //   11: astore 5
    //   13: iconst_0
    //   14: istore_3
    //   15: iload_3
    //   16: ifne +265 -> 281
    //   19: aload_1
    //   20: invokevirtual 64	com/google/protobuf/CodedInputStream:a	()I
    //   23: istore 4
    //   25: iload 4
    //   27: ifeq +209 -> 236
    //   30: iload 4
    //   32: bipush 8
    //   34: if_icmpeq +181 -> 215
    //   37: iload 4
    //   39: bipush 16
    //   41: if_icmpeq +129 -> 170
    //   44: iload 4
    //   46: bipush 24
    //   48: if_icmpeq +77 -> 125
    //   51: iload 4
    //   53: bipush 34
    //   55: if_icmpeq +48 -> 103
    //   58: iload 4
    //   60: bipush 40
    //   62: if_icmpeq +19 -> 81
    //   65: aload_0
    //   66: aload_1
    //   67: aload 5
    //   69: aload_2
    //   70: iload 4
    //   72: invokevirtual 68	com/tencent/ilink/tdi/b$i:parseUnknownField	(Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/UnknownFieldSet$Builder;Lcom/google/protobuf/ExtensionRegistryLite;I)Z
    //   75: ifne -60 -> 15
    //   78: goto +158 -> 236
    //   81: aload_0
    //   82: aload_0
    //   83: getfield 70	com/tencent/ilink/tdi/b$i:b	I
    //   86: bipush 16
    //   88: ior
    //   89: putfield 70	com/tencent/ilink/tdi/b$i:b	I
    //   92: aload_0
    //   93: aload_1
    //   94: invokevirtual 72	com/google/protobuf/CodedInputStream:f	()I
    //   97: putfield 74	com/tencent/ilink/tdi/b$i:g	I
    //   100: goto -85 -> 15
    //   103: aload_0
    //   104: aload_0
    //   105: getfield 70	com/tencent/ilink/tdi/b$i:b	I
    //   108: bipush 8
    //   110: ior
    //   111: putfield 70	com/tencent/ilink/tdi/b$i:b	I
    //   114: aload_0
    //   115: aload_1
    //   116: invokevirtual 78	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   119: putfield 49	com/tencent/ilink/tdi/b$i:f	Lcom/google/protobuf/ByteString;
    //   122: goto -107 -> 15
    //   125: aload_1
    //   126: invokevirtual 81	com/google/protobuf/CodedInputStream:n	()I
    //   129: istore 4
    //   131: iload 4
    //   133: invokestatic 86	com/tencent/ilink/tdi/a$a:a	(I)Lcom/tencent/ilink/tdi/a$a;
    //   136: ifnonnull +15 -> 151
    //   139: aload 5
    //   141: iconst_3
    //   142: iload 4
    //   144: invokevirtual 91	com/google/protobuf/UnknownFieldSet$Builder:a	(II)Lcom/google/protobuf/UnknownFieldSet$Builder;
    //   147: pop
    //   148: goto -133 -> 15
    //   151: aload_0
    //   152: aload_0
    //   153: getfield 70	com/tencent/ilink/tdi/b$i:b	I
    //   156: iconst_4
    //   157: ior
    //   158: putfield 70	com/tencent/ilink/tdi/b$i:b	I
    //   161: aload_0
    //   162: iload 4
    //   164: putfield 42	com/tencent/ilink/tdi/b$i:e	I
    //   167: goto -152 -> 15
    //   170: aload_1
    //   171: invokevirtual 81	com/google/protobuf/CodedInputStream:n	()I
    //   174: istore 4
    //   176: iload 4
    //   178: invokestatic 96	com/tencent/ilink/tdi/a$c:a	(I)Lcom/tencent/ilink/tdi/a$c;
    //   181: ifnonnull +15 -> 196
    //   184: aload 5
    //   186: iconst_2
    //   187: iload 4
    //   189: invokevirtual 91	com/google/protobuf/UnknownFieldSet$Builder:a	(II)Lcom/google/protobuf/UnknownFieldSet$Builder;
    //   192: pop
    //   193: goto -178 -> 15
    //   196: aload_0
    //   197: aload_0
    //   198: getfield 70	com/tencent/ilink/tdi/b$i:b	I
    //   201: iconst_2
    //   202: ior
    //   203: putfield 70	com/tencent/ilink/tdi/b$i:b	I
    //   206: aload_0
    //   207: iload 4
    //   209: putfield 40	com/tencent/ilink/tdi/b$i:d	I
    //   212: goto -197 -> 15
    //   215: aload_0
    //   216: aload_0
    //   217: getfield 70	com/tencent/ilink/tdi/b$i:b	I
    //   220: iconst_1
    //   221: ior
    //   222: putfield 70	com/tencent/ilink/tdi/b$i:b	I
    //   225: aload_0
    //   226: aload_1
    //   227: invokevirtual 99	com/google/protobuf/CodedInputStream:m	()I
    //   230: putfield 101	com/tencent/ilink/tdi/b$i:c	I
    //   233: goto -218 -> 15
    //   236: iconst_1
    //   237: istore_3
    //   238: goto -223 -> 15
    //   241: astore_1
    //   242: goto +24 -> 266
    //   245: astore_1
    //   246: new 52	com/google/protobuf/InvalidProtocolBufferException
    //   249: dup
    //   250: aload_1
    //   251: invokespecial 104	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/io/IOException;)V
    //   254: aload_0
    //   255: invokevirtual 108	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   258: athrow
    //   259: astore_1
    //   260: aload_1
    //   261: aload_0
    //   262: invokevirtual 108	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   265: athrow
    //   266: aload_0
    //   267: aload 5
    //   269: invokevirtual 111	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   272: putfield 115	com/tencent/ilink/tdi/b$i:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   275: aload_0
    //   276: invokevirtual 118	com/tencent/ilink/tdi/b$i:makeExtensionsImmutable	()V
    //   279: aload_1
    //   280: athrow
    //   281: aload_0
    //   282: aload 5
    //   284: invokevirtual 111	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   287: putfield 115	com/tencent/ilink/tdi/b$i:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   290: aload_0
    //   291: invokevirtual 118	com/tencent/ilink/tdi/b$i:makeExtensionsImmutable	()V
    //   294: return
    //   295: new 120	java/lang/NullPointerException
    //   298: dup
    //   299: invokespecial 121	java/lang/NullPointerException:<init>	()V
    //   302: astore_1
    //   303: goto +5 -> 308
    //   306: aload_1
    //   307: athrow
    //   308: goto -2 -> 306
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	311	0	this	i
    //   0	311	1	paramCodedInputStream	com.google.protobuf.CodedInputStream
    //   0	311	2	paramExtensionRegistryLite	com.google.protobuf.ExtensionRegistryLite
    //   14	224	3	j	int
    //   23	185	4	k	int
    //   11	272	5	localBuilder	com.google.protobuf.UnknownFieldSet.Builder
    // Exception table:
    //   from	to	target	type
    //   19	25	241	finally
    //   65	78	241	finally
    //   81	100	241	finally
    //   103	122	241	finally
    //   125	148	241	finally
    //   151	167	241	finally
    //   170	193	241	finally
    //   196	212	241	finally
    //   215	233	241	finally
    //   246	259	241	finally
    //   260	266	241	finally
    //   19	25	245	java/io/IOException
    //   65	78	245	java/io/IOException
    //   81	100	245	java/io/IOException
    //   103	122	245	java/io/IOException
    //   125	148	245	java/io/IOException
    //   151	167	245	java/io/IOException
    //   170	193	245	java/io/IOException
    //   196	212	245	java/io/IOException
    //   215	233	245	java/io/IOException
    //   19	25	259	com/google/protobuf/InvalidProtocolBufferException
    //   65	78	259	com/google/protobuf/InvalidProtocolBufferException
    //   81	100	259	com/google/protobuf/InvalidProtocolBufferException
    //   103	122	259	com/google/protobuf/InvalidProtocolBufferException
    //   125	148	259	com/google/protobuf/InvalidProtocolBufferException
    //   151	167	259	com/google/protobuf/InvalidProtocolBufferException
    //   170	193	259	com/google/protobuf/InvalidProtocolBufferException
    //   196	212	259	com/google/protobuf/InvalidProtocolBufferException
    //   215	233	259	com/google/protobuf/InvalidProtocolBufferException
  }
  
  private b$i(GeneratedMessageV3.Builder<?> paramBuilder)
  {
    super(paramBuilder);
  }
  
  public static final Descriptors.Descriptor a()
  {
    return b.n();
  }
  
  public static i a(byte[] paramArrayOfByte)
  {
    return (i)a.parseFrom(paramArrayOfByte);
  }
  
  public static b.i.a m()
  {
    return i.n();
  }
  
  public static i o()
  {
    return i;
  }
  
  protected b.i.a a(GeneratedMessageV3.BuilderParent paramBuilderParent)
  {
    return new b.i.a(paramBuilderParent, null);
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
  
  public a.c e()
  {
    a.c localc2 = a.c.a(this.d);
    a.c localc1 = localc2;
    if (localc2 == null) {
      localc1 = a.c.b;
    }
    return localc1;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof i)) {
      return super.equals(paramObject);
    }
    paramObject = (i)paramObject;
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
    if ((j()) && (k() != paramObject.k())) {
      return false;
    }
    return this.unknownFields.equals(paramObject.unknownFields);
  }
  
  public boolean f()
  {
    return (this.b & 0x4) != 0;
  }
  
  public a.a g()
  {
    a.a locala2 = a.a.a(this.e);
    a.a locala1 = locala2;
    if (locala2 == null) {
      locala1 = a.a.a;
    }
    return locala1;
  }
  
  public Parser<i> getParserForType()
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
      k = 0 + CodedOutputStream.i(1, this.c);
    }
    j = k;
    if ((this.b & 0x2) != 0) {
      j = k + CodedOutputStream.m(2, this.d);
    }
    k = j;
    if ((this.b & 0x4) != 0) {
      k = j + CodedOutputStream.m(3, this.e);
    }
    j = k;
    if ((this.b & 0x8) != 0) {
      j = k + CodedOutputStream.c(4, this.f);
    }
    k = j;
    if ((this.b & 0x10) != 0) {
      k = j + CodedOutputStream.h(5, this.g);
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
      j = (k * 37 + 1) * 53 + c();
    }
    k = j;
    if (d()) {
      k = (j * 37 + 2) * 53 + this.d;
    }
    j = k;
    if (f()) {
      j = (k * 37 + 3) * 53 + this.e;
    }
    k = j;
    if (h()) {
      k = (j * 37 + 4) * 53 + i().hashCode();
    }
    j = k;
    if (j()) {
      j = (k * 37 + 5) * 53 + k();
    }
    j = j * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = j;
    return j;
  }
  
  public ByteString i()
  {
    return this.f;
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return b.o().a(i.class, b.i.a.class);
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
  
  public int k()
  {
    return this.g;
  }
  
  public b.i.a l()
  {
    return m();
  }
  
  public b.i.a n()
  {
    if (this == i) {
      return new b.i.a(null);
    }
    return new b.i.a(null).a(this);
  }
  
  protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter paramUnusedPrivateParameter)
  {
    return new i();
  }
  
  public i p()
  {
    return i;
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
      paramCodedOutputStream.b(5, this.g);
    }
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilink.tdi.b.i
 * JD-Core Version:    0.7.0.1
 */