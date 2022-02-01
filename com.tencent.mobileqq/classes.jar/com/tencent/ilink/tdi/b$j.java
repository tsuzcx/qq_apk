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

public final class b$j
  extends GeneratedMessageV3
  implements j
{
  @Deprecated
  public static final Parser<j> a = new b.j.1();
  private static final j g = new j();
  private int b;
  private int c;
  private int d;
  private ByteString e;
  private byte f = -1;
  
  private b$j()
  {
    this.c = 1;
    this.d = 0;
    this.e = ByteString.EMPTY;
  }
  
  /* Error */
  private b$j(com.google.protobuf.CodedInputStream paramCodedInputStream, com.google.protobuf.ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 25	com/tencent/ilink/tdi/b$j:<init>	()V
    //   4: aload_2
    //   5: ifnull +232 -> 237
    //   8: invokestatic 57	com/google/protobuf/UnknownFieldSet:a	()Lcom/google/protobuf/UnknownFieldSet$Builder;
    //   11: astore 5
    //   13: iconst_0
    //   14: istore_3
    //   15: iload_3
    //   16: ifne +207 -> 223
    //   19: aload_1
    //   20: invokevirtual 62	com/google/protobuf/CodedInputStream:a	()I
    //   23: istore 4
    //   25: iload 4
    //   27: ifeq +151 -> 178
    //   30: iload 4
    //   32: bipush 8
    //   34: if_icmpeq +99 -> 133
    //   37: iload 4
    //   39: bipush 16
    //   41: if_icmpeq +47 -> 88
    //   44: iload 4
    //   46: bipush 26
    //   48: if_icmpeq +19 -> 67
    //   51: aload_0
    //   52: aload_1
    //   53: aload 5
    //   55: aload_2
    //   56: iload 4
    //   58: invokevirtual 66	com/tencent/ilink/tdi/b$j:parseUnknownField	(Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/UnknownFieldSet$Builder;Lcom/google/protobuf/ExtensionRegistryLite;I)Z
    //   61: ifne -46 -> 15
    //   64: goto +114 -> 178
    //   67: aload_0
    //   68: aload_0
    //   69: getfield 68	com/tencent/ilink/tdi/b$j:b	I
    //   72: iconst_4
    //   73: ior
    //   74: putfield 68	com/tencent/ilink/tdi/b$j:b	I
    //   77: aload_0
    //   78: aload_1
    //   79: invokevirtual 72	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   82: putfield 47	com/tencent/ilink/tdi/b$j:e	Lcom/google/protobuf/ByteString;
    //   85: goto -70 -> 15
    //   88: aload_1
    //   89: invokevirtual 75	com/google/protobuf/CodedInputStream:n	()I
    //   92: istore 4
    //   94: iload 4
    //   96: invokestatic 80	com/tencent/ilink/tdi/a$d:a	(I)Lcom/tencent/ilink/tdi/a$d;
    //   99: ifnonnull +15 -> 114
    //   102: aload 5
    //   104: iconst_2
    //   105: iload 4
    //   107: invokevirtual 85	com/google/protobuf/UnknownFieldSet$Builder:a	(II)Lcom/google/protobuf/UnknownFieldSet$Builder;
    //   110: pop
    //   111: goto -96 -> 15
    //   114: aload_0
    //   115: aload_0
    //   116: getfield 68	com/tencent/ilink/tdi/b$j:b	I
    //   119: iconst_2
    //   120: ior
    //   121: putfield 68	com/tencent/ilink/tdi/b$j:b	I
    //   124: aload_0
    //   125: iload 4
    //   127: putfield 40	com/tencent/ilink/tdi/b$j:d	I
    //   130: goto -115 -> 15
    //   133: aload_1
    //   134: invokevirtual 75	com/google/protobuf/CodedInputStream:n	()I
    //   137: istore 4
    //   139: iload 4
    //   141: invokestatic 90	com/tencent/ilink/tdi/a$c:a	(I)Lcom/tencent/ilink/tdi/a$c;
    //   144: ifnonnull +15 -> 159
    //   147: aload 5
    //   149: iconst_1
    //   150: iload 4
    //   152: invokevirtual 85	com/google/protobuf/UnknownFieldSet$Builder:a	(II)Lcom/google/protobuf/UnknownFieldSet$Builder;
    //   155: pop
    //   156: goto -141 -> 15
    //   159: aload_0
    //   160: iconst_1
    //   161: aload_0
    //   162: getfield 68	com/tencent/ilink/tdi/b$j:b	I
    //   165: ior
    //   166: putfield 68	com/tencent/ilink/tdi/b$j:b	I
    //   169: aload_0
    //   170: iload 4
    //   172: putfield 38	com/tencent/ilink/tdi/b$j:c	I
    //   175: goto -160 -> 15
    //   178: iconst_1
    //   179: istore_3
    //   180: goto -165 -> 15
    //   183: astore_1
    //   184: goto +24 -> 208
    //   187: astore_1
    //   188: new 50	com/google/protobuf/InvalidProtocolBufferException
    //   191: dup
    //   192: aload_1
    //   193: invokespecial 93	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/io/IOException;)V
    //   196: aload_0
    //   197: invokevirtual 97	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   200: athrow
    //   201: astore_1
    //   202: aload_1
    //   203: aload_0
    //   204: invokevirtual 97	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   207: athrow
    //   208: aload_0
    //   209: aload 5
    //   211: invokevirtual 100	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   214: putfield 104	com/tencent/ilink/tdi/b$j:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   217: aload_0
    //   218: invokevirtual 107	com/tencent/ilink/tdi/b$j:makeExtensionsImmutable	()V
    //   221: aload_1
    //   222: athrow
    //   223: aload_0
    //   224: aload 5
    //   226: invokevirtual 100	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   229: putfield 104	com/tencent/ilink/tdi/b$j:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   232: aload_0
    //   233: invokevirtual 107	com/tencent/ilink/tdi/b$j:makeExtensionsImmutable	()V
    //   236: return
    //   237: new 109	java/lang/NullPointerException
    //   240: dup
    //   241: invokespecial 110	java/lang/NullPointerException:<init>	()V
    //   244: astore_1
    //   245: goto +5 -> 250
    //   248: aload_1
    //   249: athrow
    //   250: goto -2 -> 248
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	253	0	this	j
    //   0	253	1	paramCodedInputStream	com.google.protobuf.CodedInputStream
    //   0	253	2	paramExtensionRegistryLite	com.google.protobuf.ExtensionRegistryLite
    //   14	166	3	i	int
    //   23	148	4	j	int
    //   11	214	5	localBuilder	com.google.protobuf.UnknownFieldSet.Builder
    // Exception table:
    //   from	to	target	type
    //   19	25	183	finally
    //   51	64	183	finally
    //   67	85	183	finally
    //   88	111	183	finally
    //   114	130	183	finally
    //   133	156	183	finally
    //   159	175	183	finally
    //   188	201	183	finally
    //   202	208	183	finally
    //   19	25	187	java/io/IOException
    //   51	64	187	java/io/IOException
    //   67	85	187	java/io/IOException
    //   88	111	187	java/io/IOException
    //   114	130	187	java/io/IOException
    //   133	156	187	java/io/IOException
    //   159	175	187	java/io/IOException
    //   19	25	201	com/google/protobuf/InvalidProtocolBufferException
    //   51	64	201	com/google/protobuf/InvalidProtocolBufferException
    //   67	85	201	com/google/protobuf/InvalidProtocolBufferException
    //   88	111	201	com/google/protobuf/InvalidProtocolBufferException
    //   114	130	201	com/google/protobuf/InvalidProtocolBufferException
    //   133	156	201	com/google/protobuf/InvalidProtocolBufferException
    //   159	175	201	com/google/protobuf/InvalidProtocolBufferException
  }
  
  private b$j(GeneratedMessageV3.Builder<?> paramBuilder)
  {
    super(paramBuilder);
  }
  
  public static final Descriptors.Descriptor a()
  {
    return b.p();
  }
  
  public static j a(byte[] paramArrayOfByte)
  {
    return (j)a.parseFrom(paramArrayOfByte);
  }
  
  public static b.j.a i()
  {
    return g.j();
  }
  
  public static j k()
  {
    return g;
  }
  
  protected b.j.a a(GeneratedMessageV3.BuilderParent paramBuilderParent)
  {
    return new b.j.a(paramBuilderParent, null);
  }
  
  public boolean b()
  {
    return (this.b & 0x1) != 0;
  }
  
  public a.c c()
  {
    a.c localc2 = a.c.a(this.c);
    a.c localc1 = localc2;
    if (localc2 == null) {
      localc1 = a.c.b;
    }
    return localc1;
  }
  
  public boolean d()
  {
    return (this.b & 0x2) != 0;
  }
  
  public a.d e()
  {
    a.d locald2 = a.d.a(this.d);
    a.d locald1 = locald2;
    if (locald2 == null) {
      locald1 = a.d.a;
    }
    return locald1;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof j)) {
      return super.equals(paramObject);
    }
    paramObject = (j)paramObject;
    if (b() != paramObject.b()) {
      return false;
    }
    if ((b()) && (this.c != paramObject.c)) {
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
    if ((f()) && (!g().equals(paramObject.g()))) {
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
  
  public Parser<j> getParserForType()
  {
    return a;
  }
  
  public int getSerializedSize()
  {
    int i = this.memoizedSize;
    if (i != -1) {
      return i;
    }
    int j = 0;
    if ((this.b & 0x1) != 0) {
      j = 0 + CodedOutputStream.m(1, this.c);
    }
    i = j;
    if ((this.b & 0x2) != 0) {
      i = j + CodedOutputStream.m(2, this.d);
    }
    j = i;
    if ((this.b & 0x4) != 0) {
      j = i + CodedOutputStream.c(3, this.e);
    }
    i = j + this.unknownFields.getSerializedSize();
    this.memoizedSize = i;
    return i;
  }
  
  public final UnknownFieldSet getUnknownFields()
  {
    return this.unknownFields;
  }
  
  public b.j.a h()
  {
    return i();
  }
  
  public int hashCode()
  {
    if (this.memoizedHashCode != 0) {
      return this.memoizedHashCode;
    }
    int j = 779 + a().hashCode();
    int i = j;
    if (b()) {
      i = (j * 37 + 1) * 53 + this.c;
    }
    j = i;
    if (d()) {
      j = (i * 37 + 2) * 53 + this.d;
    }
    i = j;
    if (f()) {
      i = (j * 37 + 3) * 53 + g().hashCode();
    }
    i = i * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    return i;
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return b.q().a(j.class, b.j.a.class);
  }
  
  public final boolean isInitialized()
  {
    int i = this.f;
    if (i == 1) {
      return true;
    }
    if (i == 0) {
      return false;
    }
    this.f = 1;
    return true;
  }
  
  public b.j.a j()
  {
    if (this == g) {
      return new b.j.a(null);
    }
    return new b.j.a(null).a(this);
  }
  
  public j l()
  {
    return g;
  }
  
  protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter paramUnusedPrivateParameter)
  {
    return new j();
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
  {
    if ((this.b & 0x1) != 0) {
      paramCodedOutputStream.g(1, this.c);
    }
    if ((this.b & 0x2) != 0) {
      paramCodedOutputStream.g(2, this.d);
    }
    if ((this.b & 0x4) != 0) {
      paramCodedOutputStream.a(3, this.e);
    }
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilink.tdi.b.j
 * JD-Core Version:    0.7.0.1
 */