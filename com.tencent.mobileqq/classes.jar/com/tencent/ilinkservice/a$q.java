package com.tencent.ilinkservice;

import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.GeneratedMessageV3.Builder;
import com.google.protobuf.GeneratedMessageV3.BuilderParent;
import com.google.protobuf.GeneratedMessageV3.FieldAccessorTable;
import com.google.protobuf.GeneratedMessageV3.UnusedPrivateParameter;
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;

public final class a$q
  extends GeneratedMessageV3
  implements r
{
  @Deprecated
  public static final Parser<q> a = new a.q.1();
  private static final q e = new q();
  private int b;
  private int c;
  private byte d = -1;
  
  private a$q() {}
  
  /* Error */
  private a$q(com.google.protobuf.CodedInputStream paramCodedInputStream, com.google.protobuf.ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 22	com/tencent/ilinkservice/a$q:<init>	()V
    //   4: aload_2
    //   5: ifnull +128 -> 133
    //   8: invokestatic 43	com/google/protobuf/UnknownFieldSet:a	()Lcom/google/protobuf/UnknownFieldSet$Builder;
    //   11: astore 5
    //   13: iconst_0
    //   14: istore_3
    //   15: iload_3
    //   16: ifne +103 -> 119
    //   19: aload_1
    //   20: invokevirtual 48	com/google/protobuf/CodedInputStream:a	()I
    //   23: istore 4
    //   25: iload 4
    //   27: ifeq +47 -> 74
    //   30: iload 4
    //   32: bipush 8
    //   34: if_icmpeq +19 -> 53
    //   37: aload_0
    //   38: aload_1
    //   39: aload 5
    //   41: aload_2
    //   42: iload 4
    //   44: invokevirtual 52	com/tencent/ilinkservice/a$q:parseUnknownField	(Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/UnknownFieldSet$Builder;Lcom/google/protobuf/ExtensionRegistryLite;I)Z
    //   47: ifne -32 -> 15
    //   50: goto +24 -> 74
    //   53: aload_0
    //   54: aload_0
    //   55: getfield 54	com/tencent/ilinkservice/a$q:b	I
    //   58: iconst_1
    //   59: ior
    //   60: putfield 54	com/tencent/ilinkservice/a$q:b	I
    //   63: aload_0
    //   64: aload_1
    //   65: invokevirtual 57	com/google/protobuf/CodedInputStream:m	()I
    //   68: putfield 59	com/tencent/ilinkservice/a$q:c	I
    //   71: goto -56 -> 15
    //   74: iconst_1
    //   75: istore_3
    //   76: goto -61 -> 15
    //   79: astore_1
    //   80: goto +24 -> 104
    //   83: astore_1
    //   84: new 36	com/google/protobuf/InvalidProtocolBufferException
    //   87: dup
    //   88: aload_1
    //   89: invokespecial 62	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/io/IOException;)V
    //   92: aload_0
    //   93: invokevirtual 66	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   96: athrow
    //   97: astore_1
    //   98: aload_1
    //   99: aload_0
    //   100: invokevirtual 66	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   103: athrow
    //   104: aload_0
    //   105: aload 5
    //   107: invokevirtual 71	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   110: putfield 75	com/tencent/ilinkservice/a$q:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   113: aload_0
    //   114: invokevirtual 78	com/tencent/ilinkservice/a$q:makeExtensionsImmutable	()V
    //   117: aload_1
    //   118: athrow
    //   119: aload_0
    //   120: aload 5
    //   122: invokevirtual 71	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   125: putfield 75	com/tencent/ilinkservice/a$q:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   128: aload_0
    //   129: invokevirtual 78	com/tencent/ilinkservice/a$q:makeExtensionsImmutable	()V
    //   132: return
    //   133: new 80	java/lang/NullPointerException
    //   136: dup
    //   137: invokespecial 81	java/lang/NullPointerException:<init>	()V
    //   140: astore_1
    //   141: goto +5 -> 146
    //   144: aload_1
    //   145: athrow
    //   146: goto -2 -> 144
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	149	0	this	q
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
  
  private a$q(GeneratedMessageV3.Builder<?> paramBuilder)
  {
    super(paramBuilder);
  }
  
  public static final Descriptors.Descriptor a()
  {
    return a.x();
  }
  
  public static q a(byte[] paramArrayOfByte)
  {
    return (q)a.parseFrom(paramArrayOfByte);
  }
  
  public static a.q.a e()
  {
    return e.f();
  }
  
  public static q g()
  {
    return e;
  }
  
  protected a.q.a a(GeneratedMessageV3.BuilderParent paramBuilderParent)
  {
    return new a.q.a(paramBuilderParent, null);
  }
  
  public boolean b()
  {
    return (this.b & 0x1) != 0;
  }
  
  public int c()
  {
    return this.c;
  }
  
  public a.q.a d()
  {
    return e();
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof q)) {
      return super.equals(paramObject);
    }
    paramObject = (q)paramObject;
    if (b() != paramObject.b()) {
      return false;
    }
    if ((b()) && (c() != paramObject.c())) {
      return false;
    }
    return this.unknownFields.equals(paramObject.unknownFields);
  }
  
  public a.q.a f()
  {
    if (this == e) {
      return new a.q.a(null);
    }
    return new a.q.a(null).a(this);
  }
  
  public Parser<q> getParserForType()
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
    i += this.unknownFields.getSerializedSize();
    this.memoizedSize = i;
    return i;
  }
  
  public final UnknownFieldSet getUnknownFields()
  {
    return this.unknownFields;
  }
  
  public q h()
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
      i = (j * 37 + 1) * 53 + c();
    }
    i = i * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    return i;
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return a.y().a(q.class, a.q.a.class);
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
    return new q();
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
  {
    if ((this.b & 0x1) != 0) {
      paramCodedOutputStream.c(1, this.c);
    }
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilinkservice.a.q
 * JD-Core Version:    0.7.0.1
 */