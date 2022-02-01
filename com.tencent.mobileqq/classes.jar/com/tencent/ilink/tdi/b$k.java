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

public final class b$k
  extends GeneratedMessageV3
  implements k
{
  @Deprecated
  public static final Parser<k> a = new b.k.1();
  private static final k h = new k();
  private int b;
  private int c;
  private int d;
  private ByteString e;
  private int f;
  private byte g = -1;
  
  private b$k()
  {
    this.d = 1;
    this.e = ByteString.EMPTY;
  }
  
  /* Error */
  private b$k(com.google.protobuf.CodedInputStream paramCodedInputStream, com.google.protobuf.ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 26	com/tencent/ilink/tdi/b$k:<init>	()V
    //   4: aload_2
    //   5: ifnull +237 -> 242
    //   8: invokestatic 56	com/google/protobuf/UnknownFieldSet:a	()Lcom/google/protobuf/UnknownFieldSet$Builder;
    //   11: astore 5
    //   13: iconst_0
    //   14: istore_3
    //   15: iload_3
    //   16: ifne +212 -> 228
    //   19: aload_1
    //   20: invokevirtual 61	com/google/protobuf/CodedInputStream:a	()I
    //   23: istore 4
    //   25: iload 4
    //   27: ifeq +156 -> 183
    //   30: iload 4
    //   32: bipush 8
    //   34: if_icmpeq +128 -> 162
    //   37: iload 4
    //   39: bipush 16
    //   41: if_icmpeq +76 -> 117
    //   44: iload 4
    //   46: bipush 26
    //   48: if_icmpeq +48 -> 96
    //   51: iload 4
    //   53: bipush 32
    //   55: if_icmpeq +19 -> 74
    //   58: aload_0
    //   59: aload_1
    //   60: aload 5
    //   62: aload_2
    //   63: iload 4
    //   65: invokevirtual 65	com/tencent/ilink/tdi/b$k:parseUnknownField	(Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/UnknownFieldSet$Builder;Lcom/google/protobuf/ExtensionRegistryLite;I)Z
    //   68: ifne -53 -> 15
    //   71: goto +112 -> 183
    //   74: aload_0
    //   75: aload_0
    //   76: getfield 67	com/tencent/ilink/tdi/b$k:b	I
    //   79: bipush 8
    //   81: ior
    //   82: putfield 67	com/tencent/ilink/tdi/b$k:b	I
    //   85: aload_0
    //   86: aload_1
    //   87: invokevirtual 69	com/google/protobuf/CodedInputStream:f	()I
    //   90: putfield 71	com/tencent/ilink/tdi/b$k:f	I
    //   93: goto -78 -> 15
    //   96: aload_0
    //   97: aload_0
    //   98: getfield 67	com/tencent/ilink/tdi/b$k:b	I
    //   101: iconst_4
    //   102: ior
    //   103: putfield 67	com/tencent/ilink/tdi/b$k:b	I
    //   106: aload_0
    //   107: aload_1
    //   108: invokevirtual 75	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   111: putfield 46	com/tencent/ilink/tdi/b$k:e	Lcom/google/protobuf/ByteString;
    //   114: goto -99 -> 15
    //   117: aload_1
    //   118: invokevirtual 78	com/google/protobuf/CodedInputStream:n	()I
    //   121: istore 4
    //   123: iload 4
    //   125: invokestatic 83	com/tencent/ilink/tdi/a$e:a	(I)Lcom/tencent/ilink/tdi/a$e;
    //   128: ifnonnull +15 -> 143
    //   131: aload 5
    //   133: iconst_2
    //   134: iload 4
    //   136: invokevirtual 88	com/google/protobuf/UnknownFieldSet$Builder:a	(II)Lcom/google/protobuf/UnknownFieldSet$Builder;
    //   139: pop
    //   140: goto -125 -> 15
    //   143: aload_0
    //   144: aload_0
    //   145: getfield 67	com/tencent/ilink/tdi/b$k:b	I
    //   148: iconst_2
    //   149: ior
    //   150: putfield 67	com/tencent/ilink/tdi/b$k:b	I
    //   153: aload_0
    //   154: iload 4
    //   156: putfield 39	com/tencent/ilink/tdi/b$k:d	I
    //   159: goto -144 -> 15
    //   162: aload_0
    //   163: aload_0
    //   164: getfield 67	com/tencent/ilink/tdi/b$k:b	I
    //   167: iconst_1
    //   168: ior
    //   169: putfield 67	com/tencent/ilink/tdi/b$k:b	I
    //   172: aload_0
    //   173: aload_1
    //   174: invokevirtual 91	com/google/protobuf/CodedInputStream:m	()I
    //   177: putfield 93	com/tencent/ilink/tdi/b$k:c	I
    //   180: goto -165 -> 15
    //   183: iconst_1
    //   184: istore_3
    //   185: goto -170 -> 15
    //   188: astore_1
    //   189: goto +24 -> 213
    //   192: astore_1
    //   193: new 49	com/google/protobuf/InvalidProtocolBufferException
    //   196: dup
    //   197: aload_1
    //   198: invokespecial 96	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/io/IOException;)V
    //   201: aload_0
    //   202: invokevirtual 100	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   205: athrow
    //   206: astore_1
    //   207: aload_1
    //   208: aload_0
    //   209: invokevirtual 100	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   212: athrow
    //   213: aload_0
    //   214: aload 5
    //   216: invokevirtual 103	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   219: putfield 107	com/tencent/ilink/tdi/b$k:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   222: aload_0
    //   223: invokevirtual 110	com/tencent/ilink/tdi/b$k:makeExtensionsImmutable	()V
    //   226: aload_1
    //   227: athrow
    //   228: aload_0
    //   229: aload 5
    //   231: invokevirtual 103	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   234: putfield 107	com/tencent/ilink/tdi/b$k:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   237: aload_0
    //   238: invokevirtual 110	com/tencent/ilink/tdi/b$k:makeExtensionsImmutable	()V
    //   241: return
    //   242: new 112	java/lang/NullPointerException
    //   245: dup
    //   246: invokespecial 113	java/lang/NullPointerException:<init>	()V
    //   249: astore_1
    //   250: goto +5 -> 255
    //   253: aload_1
    //   254: athrow
    //   255: goto -2 -> 253
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	258	0	this	k
    //   0	258	1	paramCodedInputStream	com.google.protobuf.CodedInputStream
    //   0	258	2	paramExtensionRegistryLite	com.google.protobuf.ExtensionRegistryLite
    //   14	171	3	i	int
    //   23	132	4	j	int
    //   11	219	5	localBuilder	com.google.protobuf.UnknownFieldSet.Builder
    // Exception table:
    //   from	to	target	type
    //   19	25	188	finally
    //   58	71	188	finally
    //   74	93	188	finally
    //   96	114	188	finally
    //   117	140	188	finally
    //   143	159	188	finally
    //   162	180	188	finally
    //   193	206	188	finally
    //   207	213	188	finally
    //   19	25	192	java/io/IOException
    //   58	71	192	java/io/IOException
    //   74	93	192	java/io/IOException
    //   96	114	192	java/io/IOException
    //   117	140	192	java/io/IOException
    //   143	159	192	java/io/IOException
    //   162	180	192	java/io/IOException
    //   19	25	206	com/google/protobuf/InvalidProtocolBufferException
    //   58	71	206	com/google/protobuf/InvalidProtocolBufferException
    //   74	93	206	com/google/protobuf/InvalidProtocolBufferException
    //   96	114	206	com/google/protobuf/InvalidProtocolBufferException
    //   117	140	206	com/google/protobuf/InvalidProtocolBufferException
    //   143	159	206	com/google/protobuf/InvalidProtocolBufferException
    //   162	180	206	com/google/protobuf/InvalidProtocolBufferException
  }
  
  private b$k(GeneratedMessageV3.Builder<?> paramBuilder)
  {
    super(paramBuilder);
  }
  
  public static final Descriptors.Descriptor a()
  {
    return b.f();
  }
  
  public static k a(byte[] paramArrayOfByte)
  {
    return (k)a.parseFrom(paramArrayOfByte);
  }
  
  public static b.k.a k()
  {
    return h.l();
  }
  
  public static k m()
  {
    return h;
  }
  
  protected b.k.a a(GeneratedMessageV3.BuilderParent paramBuilderParent)
  {
    return new b.k.a(paramBuilderParent, null);
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
  
  public a.e e()
  {
    a.e locale2 = a.e.a(this.d);
    a.e locale1 = locale2;
    if (locale2 == null) {
      locale1 = a.e.a;
    }
    return locale1;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof k)) {
      return super.equals(paramObject);
    }
    paramObject = (k)paramObject;
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
    if ((f()) && (!g().equals(paramObject.g()))) {
      return false;
    }
    if (h() != paramObject.h()) {
      return false;
    }
    if ((h()) && (i() != paramObject.i())) {
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
  
  public Parser<k> getParserForType()
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
      j = 0 + CodedOutputStream.i(1, this.c);
    }
    i = j;
    if ((this.b & 0x2) != 0) {
      i = j + CodedOutputStream.m(2, this.d);
    }
    j = i;
    if ((this.b & 0x4) != 0) {
      j = i + CodedOutputStream.c(3, this.e);
    }
    i = j;
    if ((this.b & 0x8) != 0) {
      i = j + CodedOutputStream.h(4, this.f);
    }
    i += this.unknownFields.getSerializedSize();
    this.memoizedSize = i;
    return i;
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
    int j = 779 + a().hashCode();
    int i = j;
    if (b()) {
      i = (j * 37 + 1) * 53 + c();
    }
    j = i;
    if (d()) {
      j = (i * 37 + 2) * 53 + this.d;
    }
    i = j;
    if (f()) {
      i = (j * 37 + 3) * 53 + g().hashCode();
    }
    j = i;
    if (h()) {
      j = (i * 37 + 4) * 53 + i();
    }
    i = j * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    return i;
  }
  
  public int i()
  {
    return this.f;
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return b.g().a(k.class, b.k.a.class);
  }
  
  public final boolean isInitialized()
  {
    int i = this.g;
    if (i == 1) {
      return true;
    }
    if (i == 0) {
      return false;
    }
    this.g = 1;
    return true;
  }
  
  public b.k.a j()
  {
    return k();
  }
  
  public b.k.a l()
  {
    if (this == h) {
      return new b.k.a(null);
    }
    return new b.k.a(null).a(this);
  }
  
  public k n()
  {
    return h;
  }
  
  protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter paramUnusedPrivateParameter)
  {
    return new k();
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
      paramCodedOutputStream.a(3, this.e);
    }
    if ((this.b & 0x8) != 0) {
      paramCodedOutputStream.b(4, this.f);
    }
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilink.tdi.b.k
 * JD-Core Version:    0.7.0.1
 */