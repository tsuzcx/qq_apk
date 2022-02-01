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

public final class ag$d
  extends GeneratedMessageV3
  implements ak
{
  @Deprecated
  public static final Parser<d> a = new ag.d.1();
  private static final d i = new d();
  private int b;
  private volatile Object c;
  private volatile Object d;
  private volatile Object e;
  private volatile Object f;
  private volatile Object g;
  private byte h = -1;
  
  private ag$d()
  {
    this.c = "";
    this.d = "";
    this.e = "";
    this.f = "";
    this.g = "";
  }
  
  /* Error */
  private ag$d(com.google.protobuf.CodedInputStream paramCodedInputStream, com.google.protobuf.ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 27	com/tencent/ilinkservice/ag$d:<init>	()V
    //   4: aload_2
    //   5: ifnull +262 -> 267
    //   8: invokestatic 60	com/google/protobuf/UnknownFieldSet:a	()Lcom/google/protobuf/UnknownFieldSet$Builder;
    //   11: astore 5
    //   13: iconst_0
    //   14: istore_3
    //   15: iload_3
    //   16: ifne +237 -> 253
    //   19: aload_1
    //   20: invokevirtual 65	com/google/protobuf/CodedInputStream:a	()I
    //   23: istore 4
    //   25: iload 4
    //   27: ifeq +181 -> 208
    //   30: iload 4
    //   32: bipush 10
    //   34: if_icmpeq +149 -> 183
    //   37: iload 4
    //   39: bipush 18
    //   41: if_icmpeq +117 -> 158
    //   44: iload 4
    //   46: bipush 26
    //   48: if_icmpeq +85 -> 133
    //   51: iload 4
    //   53: bipush 34
    //   55: if_icmpeq +52 -> 107
    //   58: iload 4
    //   60: bipush 42
    //   62: if_icmpeq +19 -> 81
    //   65: aload_0
    //   66: aload_1
    //   67: aload 5
    //   69: aload_2
    //   70: iload 4
    //   72: invokevirtual 69	com/tencent/ilinkservice/ag$d:parseUnknownField	(Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/UnknownFieldSet$Builder;Lcom/google/protobuf/ExtensionRegistryLite;I)Z
    //   75: ifne -60 -> 15
    //   78: goto +130 -> 208
    //   81: aload_1
    //   82: invokevirtual 73	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   85: astore 6
    //   87: aload_0
    //   88: aload_0
    //   89: getfield 75	com/tencent/ilinkservice/ag$d:b	I
    //   92: bipush 16
    //   94: ior
    //   95: putfield 75	com/tencent/ilinkservice/ag$d:b	I
    //   98: aload_0
    //   99: aload 6
    //   101: putfield 50	com/tencent/ilinkservice/ag$d:g	Ljava/lang/Object;
    //   104: goto -89 -> 15
    //   107: aload_1
    //   108: invokevirtual 73	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   111: astore 6
    //   113: aload_0
    //   114: aload_0
    //   115: getfield 75	com/tencent/ilinkservice/ag$d:b	I
    //   118: bipush 8
    //   120: ior
    //   121: putfield 75	com/tencent/ilinkservice/ag$d:b	I
    //   124: aload_0
    //   125: aload 6
    //   127: putfield 48	com/tencent/ilinkservice/ag$d:f	Ljava/lang/Object;
    //   130: goto -115 -> 15
    //   133: aload_1
    //   134: invokevirtual 73	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   137: astore 6
    //   139: aload_0
    //   140: aload_0
    //   141: getfield 75	com/tencent/ilinkservice/ag$d:b	I
    //   144: iconst_4
    //   145: ior
    //   146: putfield 75	com/tencent/ilinkservice/ag$d:b	I
    //   149: aload_0
    //   150: aload 6
    //   152: putfield 46	com/tencent/ilinkservice/ag$d:e	Ljava/lang/Object;
    //   155: goto -140 -> 15
    //   158: aload_1
    //   159: invokevirtual 73	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   162: astore 6
    //   164: aload_0
    //   165: aload_0
    //   166: getfield 75	com/tencent/ilinkservice/ag$d:b	I
    //   169: iconst_2
    //   170: ior
    //   171: putfield 75	com/tencent/ilinkservice/ag$d:b	I
    //   174: aload_0
    //   175: aload 6
    //   177: putfield 44	com/tencent/ilinkservice/ag$d:d	Ljava/lang/Object;
    //   180: goto -165 -> 15
    //   183: aload_1
    //   184: invokevirtual 73	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   187: astore 6
    //   189: aload_0
    //   190: iconst_1
    //   191: aload_0
    //   192: getfield 75	com/tencent/ilinkservice/ag$d:b	I
    //   195: ior
    //   196: putfield 75	com/tencent/ilinkservice/ag$d:b	I
    //   199: aload_0
    //   200: aload 6
    //   202: putfield 42	com/tencent/ilinkservice/ag$d:c	Ljava/lang/Object;
    //   205: goto -190 -> 15
    //   208: iconst_1
    //   209: istore_3
    //   210: goto -195 -> 15
    //   213: astore_1
    //   214: goto +24 -> 238
    //   217: astore_1
    //   218: new 53	com/google/protobuf/InvalidProtocolBufferException
    //   221: dup
    //   222: aload_1
    //   223: invokespecial 78	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/io/IOException;)V
    //   226: aload_0
    //   227: invokevirtual 82	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   230: athrow
    //   231: astore_1
    //   232: aload_1
    //   233: aload_0
    //   234: invokevirtual 82	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   237: athrow
    //   238: aload_0
    //   239: aload 5
    //   241: invokevirtual 87	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   244: putfield 91	com/tencent/ilinkservice/ag$d:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   247: aload_0
    //   248: invokevirtual 94	com/tencent/ilinkservice/ag$d:makeExtensionsImmutable	()V
    //   251: aload_1
    //   252: athrow
    //   253: aload_0
    //   254: aload 5
    //   256: invokevirtual 87	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   259: putfield 91	com/tencent/ilinkservice/ag$d:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   262: aload_0
    //   263: invokevirtual 94	com/tencent/ilinkservice/ag$d:makeExtensionsImmutable	()V
    //   266: return
    //   267: new 96	java/lang/NullPointerException
    //   270: dup
    //   271: invokespecial 97	java/lang/NullPointerException:<init>	()V
    //   274: astore_1
    //   275: goto +5 -> 280
    //   278: aload_1
    //   279: athrow
    //   280: goto -2 -> 278
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	283	0	this	d
    //   0	283	1	paramCodedInputStream	com.google.protobuf.CodedInputStream
    //   0	283	2	paramExtensionRegistryLite	com.google.protobuf.ExtensionRegistryLite
    //   14	196	3	j	int
    //   23	48	4	k	int
    //   11	244	5	localBuilder	com.google.protobuf.UnknownFieldSet.Builder
    //   85	116	6	localByteString	ByteString
    // Exception table:
    //   from	to	target	type
    //   19	25	213	finally
    //   65	78	213	finally
    //   81	104	213	finally
    //   107	130	213	finally
    //   133	155	213	finally
    //   158	180	213	finally
    //   183	205	213	finally
    //   218	231	213	finally
    //   232	238	213	finally
    //   19	25	217	java/io/IOException
    //   65	78	217	java/io/IOException
    //   81	104	217	java/io/IOException
    //   107	130	217	java/io/IOException
    //   133	155	217	java/io/IOException
    //   158	180	217	java/io/IOException
    //   183	205	217	java/io/IOException
    //   19	25	231	com/google/protobuf/InvalidProtocolBufferException
    //   65	78	231	com/google/protobuf/InvalidProtocolBufferException
    //   81	104	231	com/google/protobuf/InvalidProtocolBufferException
    //   107	130	231	com/google/protobuf/InvalidProtocolBufferException
    //   133	155	231	com/google/protobuf/InvalidProtocolBufferException
    //   158	180	231	com/google/protobuf/InvalidProtocolBufferException
    //   183	205	231	com/google/protobuf/InvalidProtocolBufferException
  }
  
  private ag$d(GeneratedMessageV3.Builder<?> paramBuilder)
  {
    super(paramBuilder);
  }
  
  public static final Descriptors.Descriptor a()
  {
    return ag.h();
  }
  
  public static ag.d.a m()
  {
    return i.n();
  }
  
  public static d o()
  {
    return i;
  }
  
  protected ag.d.a a(GeneratedMessageV3.BuilderParent paramBuilderParent)
  {
    return new ag.d.a(paramBuilderParent, null);
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
    if (!(paramObject instanceof d)) {
      return super.equals(paramObject);
    }
    paramObject = (d)paramObject;
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
    if (f() != paramObject.f()) {
      return false;
    }
    if ((f()) && (!g().equals(paramObject.g()))) {
      return false;
    }
    if (h() != paramObject.h()) {
      return false;
    }
    if ((h()) && (!i().equals(paramObject.i()))) {
      return false;
    }
    if (j() != paramObject.j()) {
      return false;
    }
    if ((j()) && (!k().equals(paramObject.k()))) {
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
  
  public Parser<d> getParserForType()
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
      j = k + GeneratedMessageV3.computeStringSize(2, this.d);
    }
    k = j;
    if ((this.b & 0x4) != 0) {
      k = j + GeneratedMessageV3.computeStringSize(3, this.e);
    }
    j = k;
    if ((this.b & 0x8) != 0) {
      j = k + GeneratedMessageV3.computeStringSize(4, this.f);
    }
    k = j;
    if ((this.b & 0x10) != 0) {
      k = j + GeneratedMessageV3.computeStringSize(5, this.g);
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
      k = (j * 37 + 2) * 53 + e().hashCode();
    }
    j = k;
    if (f()) {
      j = (k * 37 + 3) * 53 + g().hashCode();
    }
    k = j;
    if (h()) {
      k = (j * 37 + 4) * 53 + i().hashCode();
    }
    j = k;
    if (j()) {
      j = (k * 37 + 5) * 53 + k().hashCode();
    }
    j = j * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = j;
    return j;
  }
  
  public String i()
  {
    Object localObject = this.f;
    if ((localObject instanceof String)) {
      return (String)localObject;
    }
    localObject = (ByteString)localObject;
    String str = ((ByteString)localObject).toStringUtf8();
    if (((ByteString)localObject).isValidUtf8()) {
      this.f = str;
    }
    return str;
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return ag.i().a(d.class, ag.d.a.class);
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
  
  public String k()
  {
    Object localObject = this.g;
    if ((localObject instanceof String)) {
      return (String)localObject;
    }
    localObject = (ByteString)localObject;
    String str = ((ByteString)localObject).toStringUtf8();
    if (((ByteString)localObject).isValidUtf8()) {
      this.g = str;
    }
    return str;
  }
  
  public ag.d.a l()
  {
    return m();
  }
  
  public ag.d.a n()
  {
    if (this == i) {
      return new ag.d.a(null);
    }
    return new ag.d.a(null).a(this);
  }
  
  protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter paramUnusedPrivateParameter)
  {
    return new d();
  }
  
  public d p()
  {
    return i;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
  {
    if ((this.b & 0x1) != 0) {
      GeneratedMessageV3.writeString(paramCodedOutputStream, 1, this.c);
    }
    if ((this.b & 0x2) != 0) {
      GeneratedMessageV3.writeString(paramCodedOutputStream, 2, this.d);
    }
    if ((this.b & 0x4) != 0) {
      GeneratedMessageV3.writeString(paramCodedOutputStream, 3, this.e);
    }
    if ((this.b & 0x8) != 0) {
      GeneratedMessageV3.writeString(paramCodedOutputStream, 4, this.f);
    }
    if ((this.b & 0x10) != 0) {
      GeneratedMessageV3.writeString(paramCodedOutputStream, 5, this.g);
    }
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilinkservice.ag.d
 * JD-Core Version:    0.7.0.1
 */