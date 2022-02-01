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

public final class b$o
  extends GeneratedMessageV3
  implements o
{
  @Deprecated
  public static final Parser<o> a = new b.o.1();
  private static final o f = new o();
  private int b;
  private int c;
  private ByteString d;
  private byte e = -1;
  
  private b$o()
  {
    this.d = ByteString.EMPTY;
  }
  
  /* Error */
  private b$o(com.google.protobuf.CodedInputStream paramCodedInputStream, com.google.protobuf.ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 24	com/tencent/ilink/tdi/b$o:<init>	()V
    //   4: aload_2
    //   5: ifnull +156 -> 161
    //   8: invokestatic 52	com/google/protobuf/UnknownFieldSet:a	()Lcom/google/protobuf/UnknownFieldSet$Builder;
    //   11: astore 5
    //   13: iconst_0
    //   14: istore_3
    //   15: iload_3
    //   16: ifne +131 -> 147
    //   19: aload_1
    //   20: invokevirtual 57	com/google/protobuf/CodedInputStream:a	()I
    //   23: istore 4
    //   25: iload 4
    //   27: ifeq +75 -> 102
    //   30: iload 4
    //   32: bipush 8
    //   34: if_icmpeq +47 -> 81
    //   37: iload 4
    //   39: bipush 18
    //   41: if_icmpeq +19 -> 60
    //   44: aload_0
    //   45: aload_1
    //   46: aload 5
    //   48: aload_2
    //   49: iload 4
    //   51: invokevirtual 61	com/tencent/ilink/tdi/b$o:parseUnknownField	(Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/UnknownFieldSet$Builder;Lcom/google/protobuf/ExtensionRegistryLite;I)Z
    //   54: ifne -39 -> 15
    //   57: goto +45 -> 102
    //   60: aload_0
    //   61: aload_0
    //   62: getfield 63	com/tencent/ilink/tdi/b$o:b	I
    //   65: iconst_2
    //   66: ior
    //   67: putfield 63	com/tencent/ilink/tdi/b$o:b	I
    //   70: aload_0
    //   71: aload_1
    //   72: invokevirtual 67	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   75: putfield 42	com/tencent/ilink/tdi/b$o:d	Lcom/google/protobuf/ByteString;
    //   78: goto -63 -> 15
    //   81: aload_0
    //   82: aload_0
    //   83: getfield 63	com/tencent/ilink/tdi/b$o:b	I
    //   86: iconst_1
    //   87: ior
    //   88: putfield 63	com/tencent/ilink/tdi/b$o:b	I
    //   91: aload_0
    //   92: aload_1
    //   93: invokevirtual 70	com/google/protobuf/CodedInputStream:m	()I
    //   96: putfield 72	com/tencent/ilink/tdi/b$o:c	I
    //   99: goto -84 -> 15
    //   102: iconst_1
    //   103: istore_3
    //   104: goto -89 -> 15
    //   107: astore_1
    //   108: goto +24 -> 132
    //   111: astore_1
    //   112: new 45	com/google/protobuf/InvalidProtocolBufferException
    //   115: dup
    //   116: aload_1
    //   117: invokespecial 75	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/io/IOException;)V
    //   120: aload_0
    //   121: invokevirtual 79	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   124: athrow
    //   125: astore_1
    //   126: aload_1
    //   127: aload_0
    //   128: invokevirtual 79	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   131: athrow
    //   132: aload_0
    //   133: aload 5
    //   135: invokevirtual 84	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   138: putfield 88	com/tencent/ilink/tdi/b$o:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   141: aload_0
    //   142: invokevirtual 91	com/tencent/ilink/tdi/b$o:makeExtensionsImmutable	()V
    //   145: aload_1
    //   146: athrow
    //   147: aload_0
    //   148: aload 5
    //   150: invokevirtual 84	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   153: putfield 88	com/tencent/ilink/tdi/b$o:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   156: aload_0
    //   157: invokevirtual 91	com/tencent/ilink/tdi/b$o:makeExtensionsImmutable	()V
    //   160: return
    //   161: new 93	java/lang/NullPointerException
    //   164: dup
    //   165: invokespecial 94	java/lang/NullPointerException:<init>	()V
    //   168: astore_1
    //   169: goto +5 -> 174
    //   172: aload_1
    //   173: athrow
    //   174: goto -2 -> 172
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	177	0	this	o
    //   0	177	1	paramCodedInputStream	com.google.protobuf.CodedInputStream
    //   0	177	2	paramExtensionRegistryLite	com.google.protobuf.ExtensionRegistryLite
    //   14	90	3	i	int
    //   23	27	4	j	int
    //   11	138	5	localBuilder	com.google.protobuf.UnknownFieldSet.Builder
    // Exception table:
    //   from	to	target	type
    //   19	25	107	finally
    //   44	57	107	finally
    //   60	78	107	finally
    //   81	99	107	finally
    //   112	125	107	finally
    //   126	132	107	finally
    //   19	25	111	java/io/IOException
    //   44	57	111	java/io/IOException
    //   60	78	111	java/io/IOException
    //   81	99	111	java/io/IOException
    //   19	25	125	com/google/protobuf/InvalidProtocolBufferException
    //   44	57	125	com/google/protobuf/InvalidProtocolBufferException
    //   60	78	125	com/google/protobuf/InvalidProtocolBufferException
    //   81	99	125	com/google/protobuf/InvalidProtocolBufferException
  }
  
  private b$o(GeneratedMessageV3.Builder<?> paramBuilder)
  {
    super(paramBuilder);
  }
  
  public static final Descriptors.Descriptor a()
  {
    return b.v();
  }
  
  public static o a(byte[] paramArrayOfByte)
  {
    return (o)a.parseFrom(paramArrayOfByte);
  }
  
  public static b.o.a g()
  {
    return f.h();
  }
  
  public static o i()
  {
    return f;
  }
  
  protected b.o.a a(GeneratedMessageV3.BuilderParent paramBuilderParent)
  {
    return new b.o.a(paramBuilderParent, null);
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
  
  public ByteString e()
  {
    return this.d;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof o)) {
      return super.equals(paramObject);
    }
    paramObject = (o)paramObject;
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
    return this.unknownFields.equals(paramObject.unknownFields);
  }
  
  public b.o.a f()
  {
    return g();
  }
  
  public Parser<o> getParserForType()
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
      i = 0 + CodedOutputStream.i(1, this.c);
    }
    int j = i;
    if ((this.b & 0x2) != 0) {
      j = i + CodedOutputStream.c(2, this.d);
    }
    i = j + this.unknownFields.getSerializedSize();
    this.memoizedSize = i;
    return i;
  }
  
  public final UnknownFieldSet getUnknownFields()
  {
    return this.unknownFields;
  }
  
  public b.o.a h()
  {
    if (this == f) {
      return new b.o.a(null);
    }
    return new b.o.a(null).a(this);
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
    i = j * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    return i;
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return b.w().a(o.class, b.o.a.class);
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
  
  public o j()
  {
    return f;
  }
  
  protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter paramUnusedPrivateParameter)
  {
    return new o();
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
  {
    if ((this.b & 0x1) != 0) {
      paramCodedOutputStream.c(1, this.c);
    }
    if ((this.b & 0x2) != 0) {
      paramCodedOutputStream.a(2, this.d);
    }
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilink.tdi.b.o
 * JD-Core Version:    0.7.0.1
 */