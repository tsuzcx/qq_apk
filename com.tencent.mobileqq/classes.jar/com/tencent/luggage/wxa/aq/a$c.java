package com.tencent.luggage.wxa.aq;

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
  private static final c h = new c();
  private int b;
  private volatile Object c;
  private int d;
  private volatile Object e;
  private int f;
  private byte g = -1;
  
  private a$c()
  {
    this.c = "";
    this.e = "";
  }
  
  /* Error */
  private a$c(com.google.protobuf.CodedInputStream paramCodedInputStream, com.google.protobuf.ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 26	com/tencent/luggage/wxa/aq/a$c:<init>	()V
    //   4: aload_2
    //   5: ifnull +221 -> 226
    //   8: invokestatic 53	com/google/protobuf/UnknownFieldSet:a	()Lcom/google/protobuf/UnknownFieldSet$Builder;
    //   11: astore 5
    //   13: iconst_0
    //   14: istore_3
    //   15: iload_3
    //   16: ifne +196 -> 212
    //   19: aload_1
    //   20: invokevirtual 58	com/google/protobuf/CodedInputStream:a	()I
    //   23: istore 4
    //   25: iload 4
    //   27: ifeq +140 -> 167
    //   30: iload 4
    //   32: bipush 10
    //   34: if_icmpeq +108 -> 142
    //   37: iload 4
    //   39: bipush 16
    //   41: if_icmpeq +80 -> 121
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
    //   65: invokevirtual 62	com/tencent/luggage/wxa/aq/a$c:parseUnknownField	(Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/UnknownFieldSet$Builder;Lcom/google/protobuf/ExtensionRegistryLite;I)Z
    //   68: ifne -53 -> 15
    //   71: goto +96 -> 167
    //   74: aload_0
    //   75: aload_0
    //   76: getfield 64	com/tencent/luggage/wxa/aq/a$c:b	I
    //   79: bipush 8
    //   81: ior
    //   82: putfield 64	com/tencent/luggage/wxa/aq/a$c:b	I
    //   85: aload_0
    //   86: aload_1
    //   87: invokevirtual 67	com/google/protobuf/CodedInputStream:m	()I
    //   90: putfield 69	com/tencent/luggage/wxa/aq/a$c:f	I
    //   93: goto -78 -> 15
    //   96: aload_1
    //   97: invokevirtual 73	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   100: astore 6
    //   102: aload_0
    //   103: aload_0
    //   104: getfield 64	com/tencent/luggage/wxa/aq/a$c:b	I
    //   107: iconst_4
    //   108: ior
    //   109: putfield 64	com/tencent/luggage/wxa/aq/a$c:b	I
    //   112: aload_0
    //   113: aload 6
    //   115: putfield 43	com/tencent/luggage/wxa/aq/a$c:e	Ljava/lang/Object;
    //   118: goto -103 -> 15
    //   121: aload_0
    //   122: aload_0
    //   123: getfield 64	com/tencent/luggage/wxa/aq/a$c:b	I
    //   126: iconst_2
    //   127: ior
    //   128: putfield 64	com/tencent/luggage/wxa/aq/a$c:b	I
    //   131: aload_0
    //   132: aload_1
    //   133: invokevirtual 67	com/google/protobuf/CodedInputStream:m	()I
    //   136: putfield 75	com/tencent/luggage/wxa/aq/a$c:d	I
    //   139: goto -124 -> 15
    //   142: aload_1
    //   143: invokevirtual 73	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   146: astore 6
    //   148: aload_0
    //   149: iconst_1
    //   150: aload_0
    //   151: getfield 64	com/tencent/luggage/wxa/aq/a$c:b	I
    //   154: ior
    //   155: putfield 64	com/tencent/luggage/wxa/aq/a$c:b	I
    //   158: aload_0
    //   159: aload 6
    //   161: putfield 41	com/tencent/luggage/wxa/aq/a$c:c	Ljava/lang/Object;
    //   164: goto -149 -> 15
    //   167: iconst_1
    //   168: istore_3
    //   169: goto -154 -> 15
    //   172: astore_1
    //   173: goto +24 -> 197
    //   176: astore_1
    //   177: new 46	com/google/protobuf/InvalidProtocolBufferException
    //   180: dup
    //   181: aload_1
    //   182: invokespecial 78	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/io/IOException;)V
    //   185: aload_0
    //   186: invokevirtual 82	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   189: athrow
    //   190: astore_1
    //   191: aload_1
    //   192: aload_0
    //   193: invokevirtual 82	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   196: athrow
    //   197: aload_0
    //   198: aload 5
    //   200: invokevirtual 87	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   203: putfield 91	com/tencent/luggage/wxa/aq/a$c:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   206: aload_0
    //   207: invokevirtual 94	com/tencent/luggage/wxa/aq/a$c:makeExtensionsImmutable	()V
    //   210: aload_1
    //   211: athrow
    //   212: aload_0
    //   213: aload 5
    //   215: invokevirtual 87	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   218: putfield 91	com/tencent/luggage/wxa/aq/a$c:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   221: aload_0
    //   222: invokevirtual 94	com/tencent/luggage/wxa/aq/a$c:makeExtensionsImmutable	()V
    //   225: return
    //   226: new 96	java/lang/NullPointerException
    //   229: dup
    //   230: invokespecial 97	java/lang/NullPointerException:<init>	()V
    //   233: astore_1
    //   234: goto +5 -> 239
    //   237: aload_1
    //   238: athrow
    //   239: goto -2 -> 237
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	242	0	this	c
    //   0	242	1	paramCodedInputStream	com.google.protobuf.CodedInputStream
    //   0	242	2	paramExtensionRegistryLite	com.google.protobuf.ExtensionRegistryLite
    //   14	155	3	i	int
    //   23	41	4	j	int
    //   11	203	5	localBuilder	com.google.protobuf.UnknownFieldSet.Builder
    //   100	60	6	localByteString	ByteString
    // Exception table:
    //   from	to	target	type
    //   19	25	172	finally
    //   58	71	172	finally
    //   74	93	172	finally
    //   96	118	172	finally
    //   121	139	172	finally
    //   142	164	172	finally
    //   177	190	172	finally
    //   191	197	172	finally
    //   19	25	176	java/io/IOException
    //   58	71	176	java/io/IOException
    //   74	93	176	java/io/IOException
    //   96	118	176	java/io/IOException
    //   121	139	176	java/io/IOException
    //   142	164	176	java/io/IOException
    //   19	25	190	com/google/protobuf/InvalidProtocolBufferException
    //   58	71	190	com/google/protobuf/InvalidProtocolBufferException
    //   74	93	190	com/google/protobuf/InvalidProtocolBufferException
    //   96	118	190	com/google/protobuf/InvalidProtocolBufferException
    //   121	139	190	com/google/protobuf/InvalidProtocolBufferException
    //   142	164	190	com/google/protobuf/InvalidProtocolBufferException
  }
  
  private a$c(GeneratedMessageV3.Builder<?> paramBuilder)
  {
    super(paramBuilder);
  }
  
  public static final Descriptors.Descriptor a()
  {
    return a.b();
  }
  
  public static a.c.a k()
  {
    return h.l();
  }
  
  public static c m()
  {
    return h;
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
  
  public int e()
  {
    return this.d;
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
    int i = this.memoizedSize;
    if (i != -1) {
      return i;
    }
    int j = 0;
    if ((this.b & 0x1) != 0) {
      j = 0 + GeneratedMessageV3.computeStringSize(1, this.c);
    }
    i = j;
    if ((this.b & 0x2) != 0) {
      i = j + CodedOutputStream.i(2, this.d);
    }
    j = i;
    if ((this.b & 0x4) != 0) {
      j = i + GeneratedMessageV3.computeStringSize(3, this.e);
    }
    i = j;
    if ((this.b & 0x8) != 0) {
      i = j + CodedOutputStream.i(4, this.f);
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
      i = (j * 37 + 1) * 53 + c().hashCode();
    }
    j = i;
    if (d()) {
      j = (i * 37 + 2) * 53 + e();
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
    return a.c().a(c.class, a.c.a.class);
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
  
  public a.c.a j()
  {
    return k();
  }
  
  public a.c.a l()
  {
    if (this == h) {
      return new a.c.a(null);
    }
    return new a.c.a(null).a(this);
  }
  
  public c n()
  {
    return h;
  }
  
  protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter paramUnusedPrivateParameter)
  {
    return new c();
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
  {
    if ((this.b & 0x1) != 0) {
      GeneratedMessageV3.writeString(paramCodedOutputStream, 1, this.c);
    }
    if ((this.b & 0x2) != 0) {
      paramCodedOutputStream.c(2, this.d);
    }
    if ((this.b & 0x4) != 0) {
      GeneratedMessageV3.writeString(paramCodedOutputStream, 3, this.e);
    }
    if ((this.b & 0x8) != 0) {
      paramCodedOutputStream.c(4, this.f);
    }
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.aq.a.c
 * JD-Core Version:    0.7.0.1
 */