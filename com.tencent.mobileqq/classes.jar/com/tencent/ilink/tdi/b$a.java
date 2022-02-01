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

public final class b$a
  extends GeneratedMessageV3
  implements c
{
  @Deprecated
  public static final Parser<a> a = new b.a.1();
  private static final a g = new a();
  private int b;
  private long c;
  private long d;
  private ByteString e;
  private byte f = -1;
  
  private b$a()
  {
    this.e = ByteString.EMPTY;
  }
  
  /* Error */
  private b$a(com.google.protobuf.CodedInputStream paramCodedInputStream, com.google.protobuf.ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 26	com/tencent/ilink/tdi/b$a:<init>	()V
    //   4: aload_2
    //   5: ifnull +184 -> 189
    //   8: invokestatic 54	com/google/protobuf/UnknownFieldSet:a	()Lcom/google/protobuf/UnknownFieldSet$Builder;
    //   11: astore 5
    //   13: iconst_0
    //   14: istore_3
    //   15: iload_3
    //   16: ifne +159 -> 175
    //   19: aload_1
    //   20: invokevirtual 59	com/google/protobuf/CodedInputStream:a	()I
    //   23: istore 4
    //   25: iload 4
    //   27: ifeq +103 -> 130
    //   30: iload 4
    //   32: bipush 8
    //   34: if_icmpeq +75 -> 109
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
    //   58: invokevirtual 63	com/tencent/ilink/tdi/b$a:parseUnknownField	(Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/UnknownFieldSet$Builder;Lcom/google/protobuf/ExtensionRegistryLite;I)Z
    //   61: ifne -46 -> 15
    //   64: goto +66 -> 130
    //   67: aload_0
    //   68: aload_0
    //   69: getfield 65	com/tencent/ilink/tdi/b$a:b	I
    //   72: iconst_4
    //   73: ior
    //   74: putfield 65	com/tencent/ilink/tdi/b$a:b	I
    //   77: aload_0
    //   78: aload_1
    //   79: invokevirtual 69	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   82: putfield 44	com/tencent/ilink/tdi/b$a:e	Lcom/google/protobuf/ByteString;
    //   85: goto -70 -> 15
    //   88: aload_0
    //   89: aload_0
    //   90: getfield 65	com/tencent/ilink/tdi/b$a:b	I
    //   93: iconst_2
    //   94: ior
    //   95: putfield 65	com/tencent/ilink/tdi/b$a:b	I
    //   98: aload_0
    //   99: aload_1
    //   100: invokevirtual 72	com/google/protobuf/CodedInputStream:d	()J
    //   103: putfield 74	com/tencent/ilink/tdi/b$a:d	J
    //   106: goto -91 -> 15
    //   109: aload_0
    //   110: aload_0
    //   111: getfield 65	com/tencent/ilink/tdi/b$a:b	I
    //   114: iconst_1
    //   115: ior
    //   116: putfield 65	com/tencent/ilink/tdi/b$a:b	I
    //   119: aload_0
    //   120: aload_1
    //   121: invokevirtual 72	com/google/protobuf/CodedInputStream:d	()J
    //   124: putfield 76	com/tencent/ilink/tdi/b$a:c	J
    //   127: goto -112 -> 15
    //   130: iconst_1
    //   131: istore_3
    //   132: goto -117 -> 15
    //   135: astore_1
    //   136: goto +24 -> 160
    //   139: astore_1
    //   140: new 47	com/google/protobuf/InvalidProtocolBufferException
    //   143: dup
    //   144: aload_1
    //   145: invokespecial 79	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/io/IOException;)V
    //   148: aload_0
    //   149: invokevirtual 83	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   152: athrow
    //   153: astore_1
    //   154: aload_1
    //   155: aload_0
    //   156: invokevirtual 83	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   159: athrow
    //   160: aload_0
    //   161: aload 5
    //   163: invokevirtual 88	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   166: putfield 92	com/tencent/ilink/tdi/b$a:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   169: aload_0
    //   170: invokevirtual 95	com/tencent/ilink/tdi/b$a:makeExtensionsImmutable	()V
    //   173: aload_1
    //   174: athrow
    //   175: aload_0
    //   176: aload 5
    //   178: invokevirtual 88	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   181: putfield 92	com/tencent/ilink/tdi/b$a:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   184: aload_0
    //   185: invokevirtual 95	com/tencent/ilink/tdi/b$a:makeExtensionsImmutable	()V
    //   188: return
    //   189: new 97	java/lang/NullPointerException
    //   192: dup
    //   193: invokespecial 98	java/lang/NullPointerException:<init>	()V
    //   196: astore_1
    //   197: goto +5 -> 202
    //   200: aload_1
    //   201: athrow
    //   202: goto -2 -> 200
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	205	0	this	a
    //   0	205	1	paramCodedInputStream	com.google.protobuf.CodedInputStream
    //   0	205	2	paramExtensionRegistryLite	com.google.protobuf.ExtensionRegistryLite
    //   14	118	3	i	int
    //   23	34	4	j	int
    //   11	166	5	localBuilder	com.google.protobuf.UnknownFieldSet.Builder
    // Exception table:
    //   from	to	target	type
    //   19	25	135	finally
    //   51	64	135	finally
    //   67	85	135	finally
    //   88	106	135	finally
    //   109	127	135	finally
    //   140	153	135	finally
    //   154	160	135	finally
    //   19	25	139	java/io/IOException
    //   51	64	139	java/io/IOException
    //   67	85	139	java/io/IOException
    //   88	106	139	java/io/IOException
    //   109	127	139	java/io/IOException
    //   19	25	153	com/google/protobuf/InvalidProtocolBufferException
    //   51	64	153	com/google/protobuf/InvalidProtocolBufferException
    //   67	85	153	com/google/protobuf/InvalidProtocolBufferException
    //   88	106	153	com/google/protobuf/InvalidProtocolBufferException
    //   109	127	153	com/google/protobuf/InvalidProtocolBufferException
  }
  
  private b$a(GeneratedMessageV3.Builder<?> paramBuilder)
  {
    super(paramBuilder);
  }
  
  public static final Descriptors.Descriptor a()
  {
    return b.H();
  }
  
  public static a a(byte[] paramArrayOfByte)
  {
    return (a)a.parseFrom(paramArrayOfByte);
  }
  
  public static b.a.a i()
  {
    return g.j();
  }
  
  public static a k()
  {
    return g;
  }
  
  protected b.a.a a(GeneratedMessageV3.BuilderParent paramBuilderParent)
  {
    return new b.a.a(paramBuilderParent, null);
  }
  
  public boolean b()
  {
    return (this.b & 0x1) != 0;
  }
  
  public long c()
  {
    return this.c;
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
    if ((d()) && (e() != paramObject.e())) {
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
      j = 0 + CodedOutputStream.g(1, this.c);
    }
    i = j;
    if ((this.b & 0x2) != 0) {
      i = j + CodedOutputStream.g(2, this.d);
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
  
  public b.a.a h()
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
      i = (j * 37 + 1) * 53 + Internal.a(c());
    }
    j = i;
    if (d()) {
      j = (i * 37 + 2) * 53 + Internal.a(e());
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
    return b.I().a(a.class, b.a.a.class);
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
  
  public b.a.a j()
  {
    if (this == g) {
      return new b.a.a(null);
    }
    return new b.a.a(null).a(this);
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
      paramCodedOutputStream.b(2, this.d);
    }
    if ((this.b & 0x4) != 0) {
      paramCodedOutputStream.a(3, this.e);
    }
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilink.tdi.b.a
 * JD-Core Version:    0.7.0.1
 */