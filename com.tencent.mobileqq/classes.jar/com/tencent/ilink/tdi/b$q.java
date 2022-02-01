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

public final class b$q
  extends GeneratedMessageV3
  implements q
{
  @Deprecated
  public static final Parser<q> a = new b.q.1();
  private static final q e = new q();
  private int b;
  private volatile Object c;
  private byte d = -1;
  
  private b$q()
  {
    this.c = "";
  }
  
  /* Error */
  private b$q(com.google.protobuf.CodedInputStream paramCodedInputStream, com.google.protobuf.ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 23	com/tencent/ilink/tdi/b$q:<init>	()V
    //   4: aload_2
    //   5: ifnull +132 -> 137
    //   8: invokestatic 48	com/google/protobuf/UnknownFieldSet:a	()Lcom/google/protobuf/UnknownFieldSet$Builder;
    //   11: astore 5
    //   13: iconst_0
    //   14: istore_3
    //   15: iload_3
    //   16: ifne +107 -> 123
    //   19: aload_1
    //   20: invokevirtual 53	com/google/protobuf/CodedInputStream:a	()I
    //   23: istore 4
    //   25: iload 4
    //   27: ifeq +51 -> 78
    //   30: iload 4
    //   32: bipush 10
    //   34: if_icmpeq +19 -> 53
    //   37: aload_0
    //   38: aload_1
    //   39: aload 5
    //   41: aload_2
    //   42: iload 4
    //   44: invokevirtual 57	com/tencent/ilink/tdi/b$q:parseUnknownField	(Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/UnknownFieldSet$Builder;Lcom/google/protobuf/ExtensionRegistryLite;I)Z
    //   47: ifne -32 -> 15
    //   50: goto +28 -> 78
    //   53: aload_1
    //   54: invokevirtual 61	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   57: astore 6
    //   59: aload_0
    //   60: iconst_1
    //   61: aload_0
    //   62: getfield 63	com/tencent/ilink/tdi/b$q:b	I
    //   65: ior
    //   66: putfield 63	com/tencent/ilink/tdi/b$q:b	I
    //   69: aload_0
    //   70: aload 6
    //   72: putfield 38	com/tencent/ilink/tdi/b$q:c	Ljava/lang/Object;
    //   75: goto -60 -> 15
    //   78: iconst_1
    //   79: istore_3
    //   80: goto -65 -> 15
    //   83: astore_1
    //   84: goto +24 -> 108
    //   87: astore_1
    //   88: new 41	com/google/protobuf/InvalidProtocolBufferException
    //   91: dup
    //   92: aload_1
    //   93: invokespecial 66	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/io/IOException;)V
    //   96: aload_0
    //   97: invokevirtual 70	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   100: athrow
    //   101: astore_1
    //   102: aload_1
    //   103: aload_0
    //   104: invokevirtual 70	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   107: athrow
    //   108: aload_0
    //   109: aload 5
    //   111: invokevirtual 75	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   114: putfield 79	com/tencent/ilink/tdi/b$q:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   117: aload_0
    //   118: invokevirtual 82	com/tencent/ilink/tdi/b$q:makeExtensionsImmutable	()V
    //   121: aload_1
    //   122: athrow
    //   123: aload_0
    //   124: aload 5
    //   126: invokevirtual 75	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   129: putfield 79	com/tencent/ilink/tdi/b$q:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   132: aload_0
    //   133: invokevirtual 82	com/tencent/ilink/tdi/b$q:makeExtensionsImmutable	()V
    //   136: return
    //   137: new 84	java/lang/NullPointerException
    //   140: dup
    //   141: invokespecial 85	java/lang/NullPointerException:<init>	()V
    //   144: astore_1
    //   145: goto +5 -> 150
    //   148: aload_1
    //   149: athrow
    //   150: goto -2 -> 148
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	153	0	this	q
    //   0	153	1	paramCodedInputStream	com.google.protobuf.CodedInputStream
    //   0	153	2	paramExtensionRegistryLite	com.google.protobuf.ExtensionRegistryLite
    //   14	66	3	i	int
    //   23	20	4	j	int
    //   11	114	5	localBuilder	com.google.protobuf.UnknownFieldSet.Builder
    //   57	14	6	localByteString	ByteString
    // Exception table:
    //   from	to	target	type
    //   19	25	83	finally
    //   37	50	83	finally
    //   53	75	83	finally
    //   88	101	83	finally
    //   102	108	83	finally
    //   19	25	87	java/io/IOException
    //   37	50	87	java/io/IOException
    //   53	75	87	java/io/IOException
    //   19	25	101	com/google/protobuf/InvalidProtocolBufferException
    //   37	50	101	com/google/protobuf/InvalidProtocolBufferException
    //   53	75	101	com/google/protobuf/InvalidProtocolBufferException
  }
  
  private b$q(GeneratedMessageV3.Builder<?> paramBuilder)
  {
    super(paramBuilder);
  }
  
  public static final Descriptors.Descriptor a()
  {
    return b.L();
  }
  
  public static q a(byte[] paramArrayOfByte)
  {
    return (q)a.parseFrom(paramArrayOfByte);
  }
  
  public static b.q.a e()
  {
    return e.f();
  }
  
  public static q g()
  {
    return e;
  }
  
  protected b.q.a a(GeneratedMessageV3.BuilderParent paramBuilderParent)
  {
    return new b.q.a(paramBuilderParent, null);
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
  
  public b.q.a d()
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
    if ((b()) && (!c().equals(paramObject.c()))) {
      return false;
    }
    return this.unknownFields.equals(paramObject.unknownFields);
  }
  
  public b.q.a f()
  {
    if (this == e) {
      return new b.q.a(null);
    }
    return new b.q.a(null).a(this);
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
      i = 0 + GeneratedMessageV3.computeStringSize(1, this.c);
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
      i = (j * 37 + 1) * 53 + c().hashCode();
    }
    i = i * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    return i;
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return b.M().a(q.class, b.q.a.class);
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
      GeneratedMessageV3.writeString(paramCodedOutputStream, 1, this.c);
    }
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilink.tdi.b.q
 * JD-Core Version:    0.7.0.1
 */