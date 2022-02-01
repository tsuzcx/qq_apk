package com.tencent.ilink.network;

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

public final class a$b
  extends GeneratedMessageV3
  implements b
{
  @Deprecated
  public static final Parser<b> a = new a.b.1();
  private static final b i = new b();
  private int b;
  private volatile Object c;
  private int d;
  private volatile Object e;
  private int f;
  private int g;
  private byte h = -1;
  
  private a$b()
  {
    this.c = "";
    this.e = "";
    this.g = 0;
  }
  
  /* Error */
  private a$b(com.google.protobuf.CodedInputStream paramCodedInputStream, com.google.protobuf.ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 27	com/tencent/ilink/network/a$b:<init>	()V
    //   4: aload_2
    //   5: ifnull +274 -> 279
    //   8: invokestatic 56	com/google/protobuf/UnknownFieldSet:a	()Lcom/google/protobuf/UnknownFieldSet$Builder;
    //   11: astore 5
    //   13: iconst_0
    //   14: istore_3
    //   15: iload_3
    //   16: ifne +249 -> 265
    //   19: aload_1
    //   20: invokevirtual 61	com/google/protobuf/CodedInputStream:a	()I
    //   23: istore 4
    //   25: iload 4
    //   27: ifeq +193 -> 220
    //   30: iload 4
    //   32: bipush 10
    //   34: if_icmpeq +161 -> 195
    //   37: iload 4
    //   39: bipush 16
    //   41: if_icmpeq +133 -> 174
    //   44: iload 4
    //   46: bipush 26
    //   48: if_icmpeq +101 -> 149
    //   51: iload 4
    //   53: bipush 32
    //   55: if_icmpeq +72 -> 127
    //   58: iload 4
    //   60: bipush 40
    //   62: if_icmpeq +19 -> 81
    //   65: aload_0
    //   66: aload_1
    //   67: aload 5
    //   69: aload_2
    //   70: iload 4
    //   72: invokevirtual 65	com/tencent/ilink/network/a$b:parseUnknownField	(Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/UnknownFieldSet$Builder;Lcom/google/protobuf/ExtensionRegistryLite;I)Z
    //   75: ifne -60 -> 15
    //   78: goto +142 -> 220
    //   81: aload_1
    //   82: invokevirtual 68	com/google/protobuf/CodedInputStream:n	()I
    //   85: istore 4
    //   87: iload 4
    //   89: invokestatic 73	com/tencent/ilink/network/a$a:a	(I)Lcom/tencent/ilink/network/a$a;
    //   92: ifnonnull +15 -> 107
    //   95: aload 5
    //   97: iconst_5
    //   98: iload 4
    //   100: invokevirtual 78	com/google/protobuf/UnknownFieldSet$Builder:a	(II)Lcom/google/protobuf/UnknownFieldSet$Builder;
    //   103: pop
    //   104: goto -89 -> 15
    //   107: aload_0
    //   108: aload_0
    //   109: getfield 80	com/tencent/ilink/network/a$b:b	I
    //   112: bipush 16
    //   114: ior
    //   115: putfield 80	com/tencent/ilink/network/a$b:b	I
    //   118: aload_0
    //   119: iload 4
    //   121: putfield 46	com/tencent/ilink/network/a$b:g	I
    //   124: goto -109 -> 15
    //   127: aload_0
    //   128: aload_0
    //   129: getfield 80	com/tencent/ilink/network/a$b:b	I
    //   132: bipush 8
    //   134: ior
    //   135: putfield 80	com/tencent/ilink/network/a$b:b	I
    //   138: aload_0
    //   139: aload_1
    //   140: invokevirtual 83	com/google/protobuf/CodedInputStream:m	()I
    //   143: putfield 85	com/tencent/ilink/network/a$b:f	I
    //   146: goto -131 -> 15
    //   149: aload_1
    //   150: invokevirtual 89	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   153: astore 6
    //   155: aload_0
    //   156: aload_0
    //   157: getfield 80	com/tencent/ilink/network/a$b:b	I
    //   160: iconst_4
    //   161: ior
    //   162: putfield 80	com/tencent/ilink/network/a$b:b	I
    //   165: aload_0
    //   166: aload 6
    //   168: putfield 44	com/tencent/ilink/network/a$b:e	Ljava/lang/Object;
    //   171: goto -156 -> 15
    //   174: aload_0
    //   175: aload_0
    //   176: getfield 80	com/tencent/ilink/network/a$b:b	I
    //   179: iconst_2
    //   180: ior
    //   181: putfield 80	com/tencent/ilink/network/a$b:b	I
    //   184: aload_0
    //   185: aload_1
    //   186: invokevirtual 83	com/google/protobuf/CodedInputStream:m	()I
    //   189: putfield 91	com/tencent/ilink/network/a$b:d	I
    //   192: goto -177 -> 15
    //   195: aload_1
    //   196: invokevirtual 89	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   199: astore 6
    //   201: aload_0
    //   202: iconst_1
    //   203: aload_0
    //   204: getfield 80	com/tencent/ilink/network/a$b:b	I
    //   207: ior
    //   208: putfield 80	com/tencent/ilink/network/a$b:b	I
    //   211: aload_0
    //   212: aload 6
    //   214: putfield 42	com/tencent/ilink/network/a$b:c	Ljava/lang/Object;
    //   217: goto -202 -> 15
    //   220: iconst_1
    //   221: istore_3
    //   222: goto -207 -> 15
    //   225: astore_1
    //   226: goto +24 -> 250
    //   229: astore_1
    //   230: new 49	com/google/protobuf/InvalidProtocolBufferException
    //   233: dup
    //   234: aload_1
    //   235: invokespecial 94	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/io/IOException;)V
    //   238: aload_0
    //   239: invokevirtual 98	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   242: athrow
    //   243: astore_1
    //   244: aload_1
    //   245: aload_0
    //   246: invokevirtual 98	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   249: athrow
    //   250: aload_0
    //   251: aload 5
    //   253: invokevirtual 101	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   256: putfield 105	com/tencent/ilink/network/a$b:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   259: aload_0
    //   260: invokevirtual 108	com/tencent/ilink/network/a$b:makeExtensionsImmutable	()V
    //   263: aload_1
    //   264: athrow
    //   265: aload_0
    //   266: aload 5
    //   268: invokevirtual 101	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   271: putfield 105	com/tencent/ilink/network/a$b:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   274: aload_0
    //   275: invokevirtual 108	com/tencent/ilink/network/a$b:makeExtensionsImmutable	()V
    //   278: return
    //   279: new 110	java/lang/NullPointerException
    //   282: dup
    //   283: invokespecial 111	java/lang/NullPointerException:<init>	()V
    //   286: astore_1
    //   287: goto +5 -> 292
    //   290: aload_1
    //   291: athrow
    //   292: goto -2 -> 290
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	295	0	this	b
    //   0	295	1	paramCodedInputStream	com.google.protobuf.CodedInputStream
    //   0	295	2	paramExtensionRegistryLite	com.google.protobuf.ExtensionRegistryLite
    //   14	208	3	j	int
    //   23	97	4	k	int
    //   11	256	5	localBuilder	com.google.protobuf.UnknownFieldSet.Builder
    //   153	60	6	localByteString	ByteString
    // Exception table:
    //   from	to	target	type
    //   19	25	225	finally
    //   65	78	225	finally
    //   81	104	225	finally
    //   107	124	225	finally
    //   127	146	225	finally
    //   149	171	225	finally
    //   174	192	225	finally
    //   195	217	225	finally
    //   230	243	225	finally
    //   244	250	225	finally
    //   19	25	229	java/io/IOException
    //   65	78	229	java/io/IOException
    //   81	104	229	java/io/IOException
    //   107	124	229	java/io/IOException
    //   127	146	229	java/io/IOException
    //   149	171	229	java/io/IOException
    //   174	192	229	java/io/IOException
    //   195	217	229	java/io/IOException
    //   19	25	243	com/google/protobuf/InvalidProtocolBufferException
    //   65	78	243	com/google/protobuf/InvalidProtocolBufferException
    //   81	104	243	com/google/protobuf/InvalidProtocolBufferException
    //   107	124	243	com/google/protobuf/InvalidProtocolBufferException
    //   127	146	243	com/google/protobuf/InvalidProtocolBufferException
    //   149	171	243	com/google/protobuf/InvalidProtocolBufferException
    //   174	192	243	com/google/protobuf/InvalidProtocolBufferException
    //   195	217	243	com/google/protobuf/InvalidProtocolBufferException
  }
  
  private a$b(GeneratedMessageV3.Builder<?> paramBuilder)
  {
    super(paramBuilder);
  }
  
  public static final Descriptors.Descriptor a()
  {
    return a.b();
  }
  
  public static a.b.a m()
  {
    return i.n();
  }
  
  public static b o()
  {
    return i;
  }
  
  protected a.b.a a(GeneratedMessageV3.BuilderParent paramBuilderParent)
  {
    return new a.b.a(paramBuilderParent, null);
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
    if (!(paramObject instanceof b)) {
      return super.equals(paramObject);
    }
    paramObject = (b)paramObject;
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
  
  public Parser<b> getParserForType()
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
      k = 0 + GeneratedMessageV3.computeStringSize(1, this.c);
    }
    j = k;
    if ((this.b & 0x2) != 0) {
      j = k + CodedOutputStream.i(2, this.d);
    }
    k = j;
    if ((this.b & 0x4) != 0) {
      k = j + GeneratedMessageV3.computeStringSize(3, this.e);
    }
    j = k;
    if ((this.b & 0x8) != 0) {
      j = k + CodedOutputStream.i(4, this.f);
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
      j = (k * 37 + 1) * 53 + c().hashCode();
    }
    k = j;
    if (d()) {
      k = (j * 37 + 2) * 53 + e();
    }
    j = k;
    if (f()) {
      j = (k * 37 + 3) * 53 + g().hashCode();
    }
    k = j;
    if (h()) {
      k = (j * 37 + 4) * 53 + i();
    }
    j = k;
    if (j()) {
      j = (k * 37 + 5) * 53 + this.g;
    }
    j = j * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = j;
    return j;
  }
  
  public int i()
  {
    return this.f;
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return a.c().a(b.class, a.b.a.class);
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
  
  public a.a k()
  {
    a.a locala2 = a.a.a(this.g);
    a.a locala1 = locala2;
    if (locala2 == null) {
      locala1 = a.a.a;
    }
    return locala1;
  }
  
  public a.b.a l()
  {
    return m();
  }
  
  public a.b.a n()
  {
    if (this == i) {
      return new a.b.a(null);
    }
    return new a.b.a(null).a(this);
  }
  
  protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter paramUnusedPrivateParameter)
  {
    return new b();
  }
  
  public b p()
  {
    return i;
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
    if ((this.b & 0x10) != 0) {
      paramCodedOutputStream.g(5, this.g);
    }
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilink.network.a.b
 * JD-Core Version:    0.7.0.1
 */