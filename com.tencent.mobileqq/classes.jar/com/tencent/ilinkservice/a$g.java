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

public final class a$g
  extends GeneratedMessageV3
  implements h
{
  @Deprecated
  public static final Parser<g> a = new a.g.1();
  private static final g f = new g();
  private int b;
  private volatile Object c;
  private int d;
  private byte e = -1;
  
  private a$g()
  {
    this.c = "";
  }
  
  /* Error */
  private a$g(com.google.protobuf.CodedInputStream paramCodedInputStream, com.google.protobuf.ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 24	com/tencent/ilinkservice/a$g:<init>	()V
    //   4: aload_2
    //   5: ifnull +160 -> 165
    //   8: invokestatic 49	com/google/protobuf/UnknownFieldSet:a	()Lcom/google/protobuf/UnknownFieldSet$Builder;
    //   11: astore 5
    //   13: iconst_0
    //   14: istore_3
    //   15: iload_3
    //   16: ifne +135 -> 151
    //   19: aload_1
    //   20: invokevirtual 54	com/google/protobuf/CodedInputStream:a	()I
    //   23: istore 4
    //   25: iload 4
    //   27: ifeq +79 -> 106
    //   30: iload 4
    //   32: bipush 10
    //   34: if_icmpeq +47 -> 81
    //   37: iload 4
    //   39: bipush 16
    //   41: if_icmpeq +19 -> 60
    //   44: aload_0
    //   45: aload_1
    //   46: aload 5
    //   48: aload_2
    //   49: iload 4
    //   51: invokevirtual 58	com/tencent/ilinkservice/a$g:parseUnknownField	(Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/UnknownFieldSet$Builder;Lcom/google/protobuf/ExtensionRegistryLite;I)Z
    //   54: ifne -39 -> 15
    //   57: goto +49 -> 106
    //   60: aload_0
    //   61: aload_0
    //   62: getfield 60	com/tencent/ilinkservice/a$g:b	I
    //   65: iconst_2
    //   66: ior
    //   67: putfield 60	com/tencent/ilinkservice/a$g:b	I
    //   70: aload_0
    //   71: aload_1
    //   72: invokevirtual 62	com/google/protobuf/CodedInputStream:f	()I
    //   75: putfield 64	com/tencent/ilinkservice/a$g:d	I
    //   78: goto -63 -> 15
    //   81: aload_1
    //   82: invokevirtual 68	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   85: astore 6
    //   87: aload_0
    //   88: iconst_1
    //   89: aload_0
    //   90: getfield 60	com/tencent/ilinkservice/a$g:b	I
    //   93: ior
    //   94: putfield 60	com/tencent/ilinkservice/a$g:b	I
    //   97: aload_0
    //   98: aload 6
    //   100: putfield 39	com/tencent/ilinkservice/a$g:c	Ljava/lang/Object;
    //   103: goto -88 -> 15
    //   106: iconst_1
    //   107: istore_3
    //   108: goto -93 -> 15
    //   111: astore_1
    //   112: goto +24 -> 136
    //   115: astore_1
    //   116: new 42	com/google/protobuf/InvalidProtocolBufferException
    //   119: dup
    //   120: aload_1
    //   121: invokespecial 71	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/io/IOException;)V
    //   124: aload_0
    //   125: invokevirtual 75	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   128: athrow
    //   129: astore_1
    //   130: aload_1
    //   131: aload_0
    //   132: invokevirtual 75	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   135: athrow
    //   136: aload_0
    //   137: aload 5
    //   139: invokevirtual 80	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   142: putfield 84	com/tencent/ilinkservice/a$g:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   145: aload_0
    //   146: invokevirtual 87	com/tencent/ilinkservice/a$g:makeExtensionsImmutable	()V
    //   149: aload_1
    //   150: athrow
    //   151: aload_0
    //   152: aload 5
    //   154: invokevirtual 80	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   157: putfield 84	com/tencent/ilinkservice/a$g:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   160: aload_0
    //   161: invokevirtual 87	com/tencent/ilinkservice/a$g:makeExtensionsImmutable	()V
    //   164: return
    //   165: new 89	java/lang/NullPointerException
    //   168: dup
    //   169: invokespecial 90	java/lang/NullPointerException:<init>	()V
    //   172: astore_1
    //   173: goto +5 -> 178
    //   176: aload_1
    //   177: athrow
    //   178: goto -2 -> 176
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	181	0	this	g
    //   0	181	1	paramCodedInputStream	com.google.protobuf.CodedInputStream
    //   0	181	2	paramExtensionRegistryLite	com.google.protobuf.ExtensionRegistryLite
    //   14	94	3	i	int
    //   23	27	4	j	int
    //   11	142	5	localBuilder	com.google.protobuf.UnknownFieldSet.Builder
    //   85	14	6	localByteString	ByteString
    // Exception table:
    //   from	to	target	type
    //   19	25	111	finally
    //   44	57	111	finally
    //   60	78	111	finally
    //   81	103	111	finally
    //   116	129	111	finally
    //   130	136	111	finally
    //   19	25	115	java/io/IOException
    //   44	57	115	java/io/IOException
    //   60	78	115	java/io/IOException
    //   81	103	115	java/io/IOException
    //   19	25	129	com/google/protobuf/InvalidProtocolBufferException
    //   44	57	129	com/google/protobuf/InvalidProtocolBufferException
    //   60	78	129	com/google/protobuf/InvalidProtocolBufferException
    //   81	103	129	com/google/protobuf/InvalidProtocolBufferException
  }
  
  private a$g(GeneratedMessageV3.Builder<?> paramBuilder)
  {
    super(paramBuilder);
  }
  
  public static final Descriptors.Descriptor a()
  {
    return a.p();
  }
  
  public static g a(byte[] paramArrayOfByte)
  {
    return (g)a.parseFrom(paramArrayOfByte);
  }
  
  public static a.g.a g()
  {
    return f.h();
  }
  
  public static g i()
  {
    return f;
  }
  
  protected a.g.a a(GeneratedMessageV3.BuilderParent paramBuilderParent)
  {
    return new a.g.a(paramBuilderParent, null);
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
    if (!(paramObject instanceof g)) {
      return super.equals(paramObject);
    }
    paramObject = (g)paramObject;
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
    return this.unknownFields.equals(paramObject.unknownFields);
  }
  
  public a.g.a f()
  {
    return g();
  }
  
  public Parser<g> getParserForType()
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
      j = i + CodedOutputStream.h(2, this.d);
    }
    i = j + this.unknownFields.getSerializedSize();
    this.memoizedSize = i;
    return i;
  }
  
  public final UnknownFieldSet getUnknownFields()
  {
    return this.unknownFields;
  }
  
  public a.g.a h()
  {
    if (this == f) {
      return new a.g.a(null);
    }
    return new a.g.a(null).a(this);
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
    i = j * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    return i;
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return a.q().a(g.class, a.g.a.class);
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
  
  public g j()
  {
    return f;
  }
  
  protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter paramUnusedPrivateParameter)
  {
    return new g();
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
  {
    if ((this.b & 0x1) != 0) {
      GeneratedMessageV3.writeString(paramCodedOutputStream, 1, this.c);
    }
    if ((this.b & 0x2) != 0) {
      paramCodedOutputStream.b(2, this.d);
    }
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilinkservice.a.g
 * JD-Core Version:    0.7.0.1
 */