package com.tencent.ilinkservice;

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

public final class a$r
  extends GeneratedMessageV3
  implements s
{
  @Deprecated
  public static final Parser<r> a = new a.r.1();
  private static final r f = new r();
  private int b;
  private volatile Object c;
  private volatile Object d;
  private byte e = -1;
  
  private a$r()
  {
    this.c = "";
    this.d = "";
  }
  
  /* Error */
  private a$r(com.google.protobuf.CodedInputStream paramCodedInputStream, com.google.protobuf.ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 24	com/tencent/ilinkservice/a$r:<init>	()V
    //   4: aload_2
    //   5: ifnull +164 -> 169
    //   8: invokestatic 51	com/google/protobuf/UnknownFieldSet:a	()Lcom/google/protobuf/UnknownFieldSet$Builder;
    //   11: astore 5
    //   13: iconst_0
    //   14: istore_3
    //   15: iload_3
    //   16: ifne +139 -> 155
    //   19: aload_1
    //   20: invokevirtual 56	com/google/protobuf/CodedInputStream:a	()I
    //   23: istore 4
    //   25: iload 4
    //   27: ifeq +83 -> 110
    //   30: iload 4
    //   32: bipush 10
    //   34: if_icmpeq +51 -> 85
    //   37: iload 4
    //   39: bipush 18
    //   41: if_icmpeq +19 -> 60
    //   44: aload_0
    //   45: aload_1
    //   46: aload 5
    //   48: aload_2
    //   49: iload 4
    //   51: invokevirtual 60	com/tencent/ilinkservice/a$r:parseUnknownField	(Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/UnknownFieldSet$Builder;Lcom/google/protobuf/ExtensionRegistryLite;I)Z
    //   54: ifne -39 -> 15
    //   57: goto +53 -> 110
    //   60: aload_1
    //   61: invokevirtual 64	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   64: astore 6
    //   66: aload_0
    //   67: aload_0
    //   68: getfield 66	com/tencent/ilinkservice/a$r:b	I
    //   71: iconst_2
    //   72: ior
    //   73: putfield 66	com/tencent/ilinkservice/a$r:b	I
    //   76: aload_0
    //   77: aload 6
    //   79: putfield 41	com/tencent/ilinkservice/a$r:d	Ljava/lang/Object;
    //   82: goto -67 -> 15
    //   85: aload_1
    //   86: invokevirtual 64	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   89: astore 6
    //   91: aload_0
    //   92: iconst_1
    //   93: aload_0
    //   94: getfield 66	com/tencent/ilinkservice/a$r:b	I
    //   97: ior
    //   98: putfield 66	com/tencent/ilinkservice/a$r:b	I
    //   101: aload_0
    //   102: aload 6
    //   104: putfield 39	com/tencent/ilinkservice/a$r:c	Ljava/lang/Object;
    //   107: goto -92 -> 15
    //   110: iconst_1
    //   111: istore_3
    //   112: goto -97 -> 15
    //   115: astore_1
    //   116: goto +24 -> 140
    //   119: astore_1
    //   120: new 44	com/google/protobuf/InvalidProtocolBufferException
    //   123: dup
    //   124: aload_1
    //   125: invokespecial 69	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/io/IOException;)V
    //   128: aload_0
    //   129: invokevirtual 73	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   132: athrow
    //   133: astore_1
    //   134: aload_1
    //   135: aload_0
    //   136: invokevirtual 73	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   139: athrow
    //   140: aload_0
    //   141: aload 5
    //   143: invokevirtual 78	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   146: putfield 82	com/tencent/ilinkservice/a$r:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   149: aload_0
    //   150: invokevirtual 85	com/tencent/ilinkservice/a$r:makeExtensionsImmutable	()V
    //   153: aload_1
    //   154: athrow
    //   155: aload_0
    //   156: aload 5
    //   158: invokevirtual 78	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   161: putfield 82	com/tencent/ilinkservice/a$r:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   164: aload_0
    //   165: invokevirtual 85	com/tencent/ilinkservice/a$r:makeExtensionsImmutable	()V
    //   168: return
    //   169: new 87	java/lang/NullPointerException
    //   172: dup
    //   173: invokespecial 88	java/lang/NullPointerException:<init>	()V
    //   176: astore_1
    //   177: goto +5 -> 182
    //   180: aload_1
    //   181: athrow
    //   182: goto -2 -> 180
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	185	0	this	r
    //   0	185	1	paramCodedInputStream	com.google.protobuf.CodedInputStream
    //   0	185	2	paramExtensionRegistryLite	com.google.protobuf.ExtensionRegistryLite
    //   14	98	3	i	int
    //   23	27	4	j	int
    //   11	146	5	localBuilder	com.google.protobuf.UnknownFieldSet.Builder
    //   64	39	6	localByteString	ByteString
    // Exception table:
    //   from	to	target	type
    //   19	25	115	finally
    //   44	57	115	finally
    //   60	82	115	finally
    //   85	107	115	finally
    //   120	133	115	finally
    //   134	140	115	finally
    //   19	25	119	java/io/IOException
    //   44	57	119	java/io/IOException
    //   60	82	119	java/io/IOException
    //   85	107	119	java/io/IOException
    //   19	25	133	com/google/protobuf/InvalidProtocolBufferException
    //   44	57	133	com/google/protobuf/InvalidProtocolBufferException
    //   60	82	133	com/google/protobuf/InvalidProtocolBufferException
    //   85	107	133	com/google/protobuf/InvalidProtocolBufferException
  }
  
  private a$r(GeneratedMessageV3.Builder<?> paramBuilder)
  {
    super(paramBuilder);
  }
  
  public static final Descriptors.Descriptor a()
  {
    return a.F();
  }
  
  public static r a(byte[] paramArrayOfByte)
  {
    return (r)a.parseFrom(paramArrayOfByte);
  }
  
  public static a.r.a g()
  {
    return f.h();
  }
  
  public static r i()
  {
    return f;
  }
  
  protected a.r.a a(GeneratedMessageV3.BuilderParent paramBuilderParent)
  {
    return new a.r.a(paramBuilderParent, null);
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
    if (!(paramObject instanceof r)) {
      return super.equals(paramObject);
    }
    paramObject = (r)paramObject;
    if (b() != paramObject.b()) {
      return false;
    }
    if ((b()) && (!c().equals(paramObject.c()))) {
      return false;
    }
    if (d() != paramObject.d()) {
      return false;
    }
    if ((d()) && (!e().equals(paramObject.e()))) {
      return false;
    }
    return this.unknownFields.equals(paramObject.unknownFields);
  }
  
  public a.r.a f()
  {
    return g();
  }
  
  public Parser<r> getParserForType()
  {
    return a;
  }
  
  public int getSerializedSize()
  {
    int i = this.memoizedSize;
    if (i != -1) {
      return i;
    }
    i = 0;
    if ((this.b & 0x1) != 0) {
      i = 0 + GeneratedMessageV3.computeStringSize(1, this.c);
    }
    int j = i;
    if ((this.b & 0x2) != 0) {
      j = i + GeneratedMessageV3.computeStringSize(2, this.d);
    }
    i = j + this.unknownFields.getSerializedSize();
    this.memoizedSize = i;
    return i;
  }
  
  public final UnknownFieldSet getUnknownFields()
  {
    return this.unknownFields;
  }
  
  public a.r.a h()
  {
    if (this == f) {
      return new a.r.a(null);
    }
    return new a.r.a(null).a(this);
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
      j = (i * 37 + 2) * 53 + e().hashCode();
    }
    i = j * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    return i;
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return a.G().a(r.class, a.r.a.class);
  }
  
  public final boolean isInitialized()
  {
    int i = this.e;
    if (i == 1) {
      return true;
    }
    if (i == 0) {
      return false;
    }
    this.e = 1;
    return true;
  }
  
  public r j()
  {
    return f;
  }
  
  protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter paramUnusedPrivateParameter)
  {
    return new r();
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
  {
    if ((this.b & 0x1) != 0) {
      GeneratedMessageV3.writeString(paramCodedOutputStream, 1, this.c);
    }
    if ((this.b & 0x2) != 0) {
      GeneratedMessageV3.writeString(paramCodedOutputStream, 2, this.d);
    }
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilinkservice.a.r
 * JD-Core Version:    0.7.0.1
 */