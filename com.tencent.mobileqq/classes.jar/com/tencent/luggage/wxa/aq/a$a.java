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

public final class a$a
  extends GeneratedMessageV3
  implements b
{
  @Deprecated
  public static final Parser<a> a = new a.a.1();
  private static final a g = new a();
  private int b;
  private int c;
  private volatile Object d;
  private int e;
  private byte f = -1;
  
  private a$a()
  {
    this.d = "";
  }
  
  /* Error */
  private a$a(com.google.protobuf.CodedInputStream paramCodedInputStream, com.google.protobuf.ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 25	com/tencent/luggage/wxa/aq/a$a:<init>	()V
    //   4: aload_2
    //   5: ifnull +188 -> 193
    //   8: invokestatic 50	com/google/protobuf/UnknownFieldSet:a	()Lcom/google/protobuf/UnknownFieldSet$Builder;
    //   11: astore 5
    //   13: iconst_0
    //   14: istore_3
    //   15: iload_3
    //   16: ifne +163 -> 179
    //   19: aload_1
    //   20: invokevirtual 55	com/google/protobuf/CodedInputStream:a	()I
    //   23: istore 4
    //   25: iload 4
    //   27: ifeq +107 -> 134
    //   30: iload 4
    //   32: bipush 8
    //   34: if_icmpeq +79 -> 113
    //   37: iload 4
    //   39: bipush 18
    //   41: if_icmpeq +47 -> 88
    //   44: iload 4
    //   46: bipush 24
    //   48: if_icmpeq +19 -> 67
    //   51: aload_0
    //   52: aload_1
    //   53: aload 5
    //   55: aload_2
    //   56: iload 4
    //   58: invokevirtual 59	com/tencent/luggage/wxa/aq/a$a:parseUnknownField	(Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/UnknownFieldSet$Builder;Lcom/google/protobuf/ExtensionRegistryLite;I)Z
    //   61: ifne -46 -> 15
    //   64: goto +70 -> 134
    //   67: aload_0
    //   68: aload_0
    //   69: getfield 61	com/tencent/luggage/wxa/aq/a$a:b	I
    //   72: iconst_4
    //   73: ior
    //   74: putfield 61	com/tencent/luggage/wxa/aq/a$a:b	I
    //   77: aload_0
    //   78: aload_1
    //   79: invokevirtual 64	com/google/protobuf/CodedInputStream:m	()I
    //   82: putfield 66	com/tencent/luggage/wxa/aq/a$a:e	I
    //   85: goto -70 -> 15
    //   88: aload_1
    //   89: invokevirtual 70	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   92: astore 6
    //   94: aload_0
    //   95: aload_0
    //   96: getfield 61	com/tencent/luggage/wxa/aq/a$a:b	I
    //   99: iconst_2
    //   100: ior
    //   101: putfield 61	com/tencent/luggage/wxa/aq/a$a:b	I
    //   104: aload_0
    //   105: aload 6
    //   107: putfield 40	com/tencent/luggage/wxa/aq/a$a:d	Ljava/lang/Object;
    //   110: goto -95 -> 15
    //   113: aload_0
    //   114: aload_0
    //   115: getfield 61	com/tencent/luggage/wxa/aq/a$a:b	I
    //   118: iconst_1
    //   119: ior
    //   120: putfield 61	com/tencent/luggage/wxa/aq/a$a:b	I
    //   123: aload_0
    //   124: aload_1
    //   125: invokevirtual 72	com/google/protobuf/CodedInputStream:f	()I
    //   128: putfield 74	com/tencent/luggage/wxa/aq/a$a:c	I
    //   131: goto -116 -> 15
    //   134: iconst_1
    //   135: istore_3
    //   136: goto -121 -> 15
    //   139: astore_1
    //   140: goto +24 -> 164
    //   143: astore_1
    //   144: new 43	com/google/protobuf/InvalidProtocolBufferException
    //   147: dup
    //   148: aload_1
    //   149: invokespecial 77	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/io/IOException;)V
    //   152: aload_0
    //   153: invokevirtual 81	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   156: athrow
    //   157: astore_1
    //   158: aload_1
    //   159: aload_0
    //   160: invokevirtual 81	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   163: athrow
    //   164: aload_0
    //   165: aload 5
    //   167: invokevirtual 86	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   170: putfield 90	com/tencent/luggage/wxa/aq/a$a:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   173: aload_0
    //   174: invokevirtual 93	com/tencent/luggage/wxa/aq/a$a:makeExtensionsImmutable	()V
    //   177: aload_1
    //   178: athrow
    //   179: aload_0
    //   180: aload 5
    //   182: invokevirtual 86	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   185: putfield 90	com/tencent/luggage/wxa/aq/a$a:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   188: aload_0
    //   189: invokevirtual 93	com/tencent/luggage/wxa/aq/a$a:makeExtensionsImmutable	()V
    //   192: return
    //   193: new 95	java/lang/NullPointerException
    //   196: dup
    //   197: invokespecial 96	java/lang/NullPointerException:<init>	()V
    //   200: astore_1
    //   201: goto +5 -> 206
    //   204: aload_1
    //   205: athrow
    //   206: goto -2 -> 204
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	209	0	this	a
    //   0	209	1	paramCodedInputStream	com.google.protobuf.CodedInputStream
    //   0	209	2	paramExtensionRegistryLite	com.google.protobuf.ExtensionRegistryLite
    //   14	122	3	i	int
    //   23	34	4	j	int
    //   11	170	5	localBuilder	com.google.protobuf.UnknownFieldSet.Builder
    //   92	14	6	localByteString	ByteString
    // Exception table:
    //   from	to	target	type
    //   19	25	139	finally
    //   51	64	139	finally
    //   67	85	139	finally
    //   88	110	139	finally
    //   113	131	139	finally
    //   144	157	139	finally
    //   158	164	139	finally
    //   19	25	143	java/io/IOException
    //   51	64	143	java/io/IOException
    //   67	85	143	java/io/IOException
    //   88	110	143	java/io/IOException
    //   113	131	143	java/io/IOException
    //   19	25	157	com/google/protobuf/InvalidProtocolBufferException
    //   51	64	157	com/google/protobuf/InvalidProtocolBufferException
    //   67	85	157	com/google/protobuf/InvalidProtocolBufferException
    //   88	110	157	com/google/protobuf/InvalidProtocolBufferException
    //   113	131	157	com/google/protobuf/InvalidProtocolBufferException
  }
  
  private a$a(GeneratedMessageV3.Builder<?> paramBuilder)
  {
    super(paramBuilder);
  }
  
  public static final Descriptors.Descriptor a()
  {
    return a.d();
  }
  
  public static a a(byte[] paramArrayOfByte)
  {
    return (a)a.parseFrom(paramArrayOfByte);
  }
  
  public static a.a.a i()
  {
    return g.j();
  }
  
  public static a k()
  {
    return g;
  }
  
  protected a.a.a a(GeneratedMessageV3.BuilderParent paramBuilderParent)
  {
    return new a.a.a(paramBuilderParent, null);
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
    if ((f()) && (g() != paramObject.g())) {
      return false;
    }
    return this.unknownFields.equals(paramObject.unknownFields);
  }
  
  public boolean f()
  {
    return (this.b & 0x4) != 0;
  }
  
  public int g()
  {
    return this.e;
  }
  
  public Parser<a> getParserForType()
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
      j = 0 + CodedOutputStream.h(1, this.c);
    }
    i = j;
    if ((this.b & 0x2) != 0) {
      i = j + GeneratedMessageV3.computeStringSize(2, this.d);
    }
    j = i;
    if ((this.b & 0x4) != 0) {
      j = i + CodedOutputStream.i(3, this.e);
    }
    i = j + this.unknownFields.getSerializedSize();
    this.memoizedSize = i;
    return i;
  }
  
  public final UnknownFieldSet getUnknownFields()
  {
    return this.unknownFields;
  }
  
  public a.a.a h()
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
      i = (j * 37 + 1) * 53 + c();
    }
    j = i;
    if (d()) {
      j = (i * 37 + 2) * 53 + e().hashCode();
    }
    i = j;
    if (f()) {
      i = (j * 37 + 3) * 53 + g();
    }
    i = i * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    return i;
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return a.e().a(a.class, a.a.a.class);
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
  
  public a.a.a j()
  {
    if (this == g) {
      return new a.a.a(null);
    }
    return new a.a.a(null).a(this);
  }
  
  public a l()
  {
    return g;
  }
  
  protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter paramUnusedPrivateParameter)
  {
    return new a();
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
      paramCodedOutputStream.c(3, this.e);
    }
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.aq.a.a
 * JD-Core Version:    0.7.0.1
 */