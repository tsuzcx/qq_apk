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

public final class a$k
  extends GeneratedMessageV3
  implements l
{
  @Deprecated
  public static final Parser<k> a = new a.k.1();
  private static final k e = new k();
  private int b;
  private ByteString c;
  private byte d = -1;
  
  private a$k()
  {
    this.c = ByteString.EMPTY;
  }
  
  /* Error */
  private a$k(com.google.protobuf.CodedInputStream paramCodedInputStream, com.google.protobuf.ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 23	com/tencent/ilinkservice/a$k:<init>	()V
    //   4: aload_2
    //   5: ifnull +128 -> 133
    //   8: invokestatic 51	com/google/protobuf/UnknownFieldSet:a	()Lcom/google/protobuf/UnknownFieldSet$Builder;
    //   11: astore 5
    //   13: iconst_0
    //   14: istore_3
    //   15: iload_3
    //   16: ifne +103 -> 119
    //   19: aload_1
    //   20: invokevirtual 56	com/google/protobuf/CodedInputStream:a	()I
    //   23: istore 4
    //   25: iload 4
    //   27: ifeq +47 -> 74
    //   30: iload 4
    //   32: bipush 10
    //   34: if_icmpeq +19 -> 53
    //   37: aload_0
    //   38: aload_1
    //   39: aload 5
    //   41: aload_2
    //   42: iload 4
    //   44: invokevirtual 60	com/tencent/ilinkservice/a$k:parseUnknownField	(Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/UnknownFieldSet$Builder;Lcom/google/protobuf/ExtensionRegistryLite;I)Z
    //   47: ifne -32 -> 15
    //   50: goto +24 -> 74
    //   53: aload_0
    //   54: aload_0
    //   55: getfield 62	com/tencent/ilinkservice/a$k:b	I
    //   58: iconst_1
    //   59: ior
    //   60: putfield 62	com/tencent/ilinkservice/a$k:b	I
    //   63: aload_0
    //   64: aload_1
    //   65: invokevirtual 66	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   68: putfield 41	com/tencent/ilinkservice/a$k:c	Lcom/google/protobuf/ByteString;
    //   71: goto -56 -> 15
    //   74: iconst_1
    //   75: istore_3
    //   76: goto -61 -> 15
    //   79: astore_1
    //   80: goto +24 -> 104
    //   83: astore_1
    //   84: new 44	com/google/protobuf/InvalidProtocolBufferException
    //   87: dup
    //   88: aload_1
    //   89: invokespecial 69	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/io/IOException;)V
    //   92: aload_0
    //   93: invokevirtual 73	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   96: athrow
    //   97: astore_1
    //   98: aload_1
    //   99: aload_0
    //   100: invokevirtual 73	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   103: athrow
    //   104: aload_0
    //   105: aload 5
    //   107: invokevirtual 78	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   110: putfield 82	com/tencent/ilinkservice/a$k:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   113: aload_0
    //   114: invokevirtual 85	com/tencent/ilinkservice/a$k:makeExtensionsImmutable	()V
    //   117: aload_1
    //   118: athrow
    //   119: aload_0
    //   120: aload 5
    //   122: invokevirtual 78	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   125: putfield 82	com/tencent/ilinkservice/a$k:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   128: aload_0
    //   129: invokevirtual 85	com/tencent/ilinkservice/a$k:makeExtensionsImmutable	()V
    //   132: return
    //   133: new 87	java/lang/NullPointerException
    //   136: dup
    //   137: invokespecial 88	java/lang/NullPointerException:<init>	()V
    //   140: astore_1
    //   141: goto +5 -> 146
    //   144: aload_1
    //   145: athrow
    //   146: goto -2 -> 144
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	149	0	this	k
    //   0	149	1	paramCodedInputStream	com.google.protobuf.CodedInputStream
    //   0	149	2	paramExtensionRegistryLite	com.google.protobuf.ExtensionRegistryLite
    //   14	62	3	i	int
    //   23	20	4	j	int
    //   11	110	5	localBuilder	com.google.protobuf.UnknownFieldSet.Builder
    // Exception table:
    //   from	to	target	type
    //   19	25	79	finally
    //   37	50	79	finally
    //   53	71	79	finally
    //   84	97	79	finally
    //   98	104	79	finally
    //   19	25	83	java/io/IOException
    //   37	50	83	java/io/IOException
    //   53	71	83	java/io/IOException
    //   19	25	97	com/google/protobuf/InvalidProtocolBufferException
    //   37	50	97	com/google/protobuf/InvalidProtocolBufferException
    //   53	71	97	com/google/protobuf/InvalidProtocolBufferException
  }
  
  private a$k(GeneratedMessageV3.Builder<?> paramBuilder)
  {
    super(paramBuilder);
  }
  
  public static final Descriptors.Descriptor a()
  {
    return a.b();
  }
  
  public static k a(byte[] paramArrayOfByte)
  {
    return (k)a.parseFrom(paramArrayOfByte);
  }
  
  public static a.k.a e()
  {
    return e.f();
  }
  
  public static k g()
  {
    return e;
  }
  
  protected a.k.a a(GeneratedMessageV3.BuilderParent paramBuilderParent)
  {
    return new a.k.a(paramBuilderParent, null);
  }
  
  public boolean b()
  {
    return (this.b & 0x1) != 0;
  }
  
  public ByteString c()
  {
    return this.c;
  }
  
  public a.k.a d()
  {
    return e();
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
    if ((b()) && (!c().equals(paramObject.c()))) {
      return false;
    }
    return this.unknownFields.equals(paramObject.unknownFields);
  }
  
  public a.k.a f()
  {
    if (this == e) {
      return new a.k.a(null);
    }
    return new a.k.a(null).a(this);
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
    i = 0;
    if ((this.b & 0x1) != 0) {
      i = 0 + CodedOutputStream.c(1, this.c);
    }
    i += this.unknownFields.getSerializedSize();
    this.memoizedSize = i;
    return i;
  }
  
  public final UnknownFieldSet getUnknownFields()
  {
    return this.unknownFields;
  }
  
  public k h()
  {
    return e;
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
    i = i * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    return i;
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return a.c().a(k.class, a.k.a.class);
  }
  
  public final boolean isInitialized()
  {
    int i = this.d;
    if (i == 1) {
      return true;
    }
    if (i == 0) {
      return false;
    }
    this.d = 1;
    return true;
  }
  
  protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter paramUnusedPrivateParameter)
  {
    return new k();
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
  {
    if ((this.b & 0x1) != 0) {
      paramCodedOutputStream.a(1, this.c);
    }
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilinkservice.a.k
 * JD-Core Version:    0.7.0.1
 */