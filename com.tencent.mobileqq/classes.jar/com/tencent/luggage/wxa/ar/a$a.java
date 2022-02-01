package com.tencent.luggage.wxa.ar;

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

public final class a$a
  extends GeneratedMessageV3
  implements b
{
  @Deprecated
  public static final Parser<a> a = new a.a.1();
  private static final a s = new a();
  private int b;
  private long c;
  private volatile Object d;
  private volatile Object e;
  private int f;
  private volatile Object g;
  private volatile Object h;
  private volatile Object i;
  private int j;
  private volatile Object k;
  private volatile Object l;
  private volatile Object m;
  private volatile Object n;
  private volatile Object o;
  private int p;
  private int q;
  private byte r = -1;
  
  private a$a()
  {
    this.d = "";
    this.e = "";
    this.g = "";
    this.h = "";
    this.i = "";
    this.k = "";
    this.l = "";
    this.m = "";
    this.n = "";
    this.o = "";
  }
  
  /* Error */
  private a$a(com.google.protobuf.CodedInputStream paramCodedInputStream, com.google.protobuf.ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 38	com/tencent/luggage/wxa/ar/a$a:<init>	()V
    //   4: aload_2
    //   5: ifnull +616 -> 621
    //   8: invokestatic 81	com/google/protobuf/UnknownFieldSet:a	()Lcom/google/protobuf/UnknownFieldSet$Builder;
    //   11: astore 6
    //   13: iconst_0
    //   14: istore_3
    //   15: iload_3
    //   16: ifne +591 -> 607
    //   19: aload_1
    //   20: invokevirtual 86	com/google/protobuf/CodedInputStream:a	()I
    //   23: istore 4
    //   25: iload 4
    //   27: lookupswitch	default:+610->637, 0:+527->554, 8:+506->533, 18:+481->508, 26:+456->483, 32:+434->461, 42:+408->435, 50:+382->409, 58:+356->383, 64:+333->360, 74:+306->333, 82:+279->306, 90:+252->279, 98:+225->252, 106:+198->225, 112:+175->202, 120:+152->179
    //   165: aload_1
    //   166: aload 6
    //   168: aload_2
    //   169: iload 4
    //   171: invokevirtual 90	com/tencent/luggage/wxa/ar/a$a:parseUnknownField	(Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/UnknownFieldSet$Builder;Lcom/google/protobuf/ExtensionRegistryLite;I)Z
    //   174: istore 5
    //   176: goto +383 -> 559
    //   179: aload_0
    //   180: aload_0
    //   181: getfield 92	com/tencent/luggage/wxa/ar/a$a:b	I
    //   184: sipush 16384
    //   187: ior
    //   188: putfield 92	com/tencent/luggage/wxa/ar/a$a:b	I
    //   191: aload_0
    //   192: aload_1
    //   193: invokevirtual 94	com/google/protobuf/CodedInputStream:m	()I
    //   196: putfield 96	com/tencent/luggage/wxa/ar/a$a:q	I
    //   199: goto -184 -> 15
    //   202: aload_0
    //   203: aload_0
    //   204: getfield 92	com/tencent/luggage/wxa/ar/a$a:b	I
    //   207: sipush 8192
    //   210: ior
    //   211: putfield 92	com/tencent/luggage/wxa/ar/a$a:b	I
    //   214: aload_0
    //   215: aload_1
    //   216: invokevirtual 94	com/google/protobuf/CodedInputStream:m	()I
    //   219: putfield 98	com/tencent/luggage/wxa/ar/a$a:p	I
    //   222: goto -207 -> 15
    //   225: aload_1
    //   226: invokevirtual 101	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   229: astore 7
    //   231: aload_0
    //   232: aload_0
    //   233: getfield 92	com/tencent/luggage/wxa/ar/a$a:b	I
    //   236: sipush 4096
    //   239: ior
    //   240: putfield 92	com/tencent/luggage/wxa/ar/a$a:b	I
    //   243: aload_0
    //   244: aload 7
    //   246: putfield 71	com/tencent/luggage/wxa/ar/a$a:o	Ljava/lang/Object;
    //   249: goto -234 -> 15
    //   252: aload_1
    //   253: invokevirtual 101	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   256: astore 7
    //   258: aload_0
    //   259: aload_0
    //   260: getfield 92	com/tencent/luggage/wxa/ar/a$a:b	I
    //   263: sipush 2048
    //   266: ior
    //   267: putfield 92	com/tencent/luggage/wxa/ar/a$a:b	I
    //   270: aload_0
    //   271: aload 7
    //   273: putfield 69	com/tencent/luggage/wxa/ar/a$a:n	Ljava/lang/Object;
    //   276: goto -261 -> 15
    //   279: aload_1
    //   280: invokevirtual 101	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   283: astore 7
    //   285: aload_0
    //   286: aload_0
    //   287: getfield 92	com/tencent/luggage/wxa/ar/a$a:b	I
    //   290: sipush 1024
    //   293: ior
    //   294: putfield 92	com/tencent/luggage/wxa/ar/a$a:b	I
    //   297: aload_0
    //   298: aload 7
    //   300: putfield 67	com/tencent/luggage/wxa/ar/a$a:m	Ljava/lang/Object;
    //   303: goto -288 -> 15
    //   306: aload_1
    //   307: invokevirtual 101	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   310: astore 7
    //   312: aload_0
    //   313: aload_0
    //   314: getfield 92	com/tencent/luggage/wxa/ar/a$a:b	I
    //   317: sipush 512
    //   320: ior
    //   321: putfield 92	com/tencent/luggage/wxa/ar/a$a:b	I
    //   324: aload_0
    //   325: aload 7
    //   327: putfield 65	com/tencent/luggage/wxa/ar/a$a:l	Ljava/lang/Object;
    //   330: goto -315 -> 15
    //   333: aload_1
    //   334: invokevirtual 101	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   337: astore 7
    //   339: aload_0
    //   340: aload_0
    //   341: getfield 92	com/tencent/luggage/wxa/ar/a$a:b	I
    //   344: sipush 256
    //   347: ior
    //   348: putfield 92	com/tencent/luggage/wxa/ar/a$a:b	I
    //   351: aload_0
    //   352: aload 7
    //   354: putfield 63	com/tencent/luggage/wxa/ar/a$a:k	Ljava/lang/Object;
    //   357: goto -342 -> 15
    //   360: aload_0
    //   361: aload_0
    //   362: getfield 92	com/tencent/luggage/wxa/ar/a$a:b	I
    //   365: sipush 128
    //   368: ior
    //   369: putfield 92	com/tencent/luggage/wxa/ar/a$a:b	I
    //   372: aload_0
    //   373: aload_1
    //   374: invokevirtual 94	com/google/protobuf/CodedInputStream:m	()I
    //   377: putfield 103	com/tencent/luggage/wxa/ar/a$a:j	I
    //   380: goto -365 -> 15
    //   383: aload_1
    //   384: invokevirtual 101	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   387: astore 7
    //   389: aload_0
    //   390: aload_0
    //   391: getfield 92	com/tencent/luggage/wxa/ar/a$a:b	I
    //   394: bipush 64
    //   396: ior
    //   397: putfield 92	com/tencent/luggage/wxa/ar/a$a:b	I
    //   400: aload_0
    //   401: aload 7
    //   403: putfield 61	com/tencent/luggage/wxa/ar/a$a:i	Ljava/lang/Object;
    //   406: goto -391 -> 15
    //   409: aload_1
    //   410: invokevirtual 101	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   413: astore 7
    //   415: aload_0
    //   416: aload_0
    //   417: getfield 92	com/tencent/luggage/wxa/ar/a$a:b	I
    //   420: bipush 32
    //   422: ior
    //   423: putfield 92	com/tencent/luggage/wxa/ar/a$a:b	I
    //   426: aload_0
    //   427: aload 7
    //   429: putfield 59	com/tencent/luggage/wxa/ar/a$a:h	Ljava/lang/Object;
    //   432: goto -417 -> 15
    //   435: aload_1
    //   436: invokevirtual 101	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   439: astore 7
    //   441: aload_0
    //   442: aload_0
    //   443: getfield 92	com/tencent/luggage/wxa/ar/a$a:b	I
    //   446: bipush 16
    //   448: ior
    //   449: putfield 92	com/tencent/luggage/wxa/ar/a$a:b	I
    //   452: aload_0
    //   453: aload 7
    //   455: putfield 57	com/tencent/luggage/wxa/ar/a$a:g	Ljava/lang/Object;
    //   458: goto -443 -> 15
    //   461: aload_0
    //   462: aload_0
    //   463: getfield 92	com/tencent/luggage/wxa/ar/a$a:b	I
    //   466: bipush 8
    //   468: ior
    //   469: putfield 92	com/tencent/luggage/wxa/ar/a$a:b	I
    //   472: aload_0
    //   473: aload_1
    //   474: invokevirtual 94	com/google/protobuf/CodedInputStream:m	()I
    //   477: putfield 105	com/tencent/luggage/wxa/ar/a$a:f	I
    //   480: goto -465 -> 15
    //   483: aload_1
    //   484: invokevirtual 101	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   487: astore 7
    //   489: aload_0
    //   490: aload_0
    //   491: getfield 92	com/tencent/luggage/wxa/ar/a$a:b	I
    //   494: iconst_4
    //   495: ior
    //   496: putfield 92	com/tencent/luggage/wxa/ar/a$a:b	I
    //   499: aload_0
    //   500: aload 7
    //   502: putfield 55	com/tencent/luggage/wxa/ar/a$a:e	Ljava/lang/Object;
    //   505: goto -490 -> 15
    //   508: aload_1
    //   509: invokevirtual 101	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   512: astore 7
    //   514: aload_0
    //   515: aload_0
    //   516: getfield 92	com/tencent/luggage/wxa/ar/a$a:b	I
    //   519: iconst_2
    //   520: ior
    //   521: putfield 92	com/tencent/luggage/wxa/ar/a$a:b	I
    //   524: aload_0
    //   525: aload 7
    //   527: putfield 53	com/tencent/luggage/wxa/ar/a$a:d	Ljava/lang/Object;
    //   530: goto -515 -> 15
    //   533: aload_0
    //   534: aload_0
    //   535: getfield 92	com/tencent/luggage/wxa/ar/a$a:b	I
    //   538: iconst_1
    //   539: ior
    //   540: putfield 92	com/tencent/luggage/wxa/ar/a$a:b	I
    //   543: aload_0
    //   544: aload_1
    //   545: invokevirtual 108	com/google/protobuf/CodedInputStream:d	()J
    //   548: putfield 110	com/tencent/luggage/wxa/ar/a$a:c	J
    //   551: goto -536 -> 15
    //   554: iconst_1
    //   555: istore_3
    //   556: goto -541 -> 15
    //   559: iload 5
    //   561: ifne -546 -> 15
    //   564: goto -10 -> 554
    //   567: astore_1
    //   568: goto +24 -> 592
    //   571: astore_1
    //   572: new 74	com/google/protobuf/InvalidProtocolBufferException
    //   575: dup
    //   576: aload_1
    //   577: invokespecial 113	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/io/IOException;)V
    //   580: aload_0
    //   581: invokevirtual 117	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   584: athrow
    //   585: astore_1
    //   586: aload_1
    //   587: aload_0
    //   588: invokevirtual 117	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   591: athrow
    //   592: aload_0
    //   593: aload 6
    //   595: invokevirtual 122	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   598: putfield 126	com/tencent/luggage/wxa/ar/a$a:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   601: aload_0
    //   602: invokevirtual 129	com/tencent/luggage/wxa/ar/a$a:makeExtensionsImmutable	()V
    //   605: aload_1
    //   606: athrow
    //   607: aload_0
    //   608: aload 6
    //   610: invokevirtual 122	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   613: putfield 126	com/tencent/luggage/wxa/ar/a$a:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   616: aload_0
    //   617: invokevirtual 129	com/tencent/luggage/wxa/ar/a$a:makeExtensionsImmutable	()V
    //   620: return
    //   621: new 131	java/lang/NullPointerException
    //   624: dup
    //   625: invokespecial 132	java/lang/NullPointerException:<init>	()V
    //   628: astore_1
    //   629: goto +5 -> 634
    //   632: aload_1
    //   633: athrow
    //   634: goto -2 -> 632
    //   637: goto -473 -> 164
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	640	0	this	a
    //   0	640	1	paramCodedInputStream	com.google.protobuf.CodedInputStream
    //   0	640	2	paramExtensionRegistryLite	com.google.protobuf.ExtensionRegistryLite
    //   14	542	3	i1	int
    //   23	147	4	i2	int
    //   174	386	5	bool	boolean
    //   11	598	6	localBuilder	com.google.protobuf.UnknownFieldSet.Builder
    //   229	297	7	localByteString	ByteString
    // Exception table:
    //   from	to	target	type
    //   19	25	567	finally
    //   164	176	567	finally
    //   179	199	567	finally
    //   202	222	567	finally
    //   225	249	567	finally
    //   252	276	567	finally
    //   279	303	567	finally
    //   306	330	567	finally
    //   333	357	567	finally
    //   360	380	567	finally
    //   383	406	567	finally
    //   409	432	567	finally
    //   435	458	567	finally
    //   461	480	567	finally
    //   483	505	567	finally
    //   508	530	567	finally
    //   533	551	567	finally
    //   572	585	567	finally
    //   586	592	567	finally
    //   19	25	571	java/io/IOException
    //   164	176	571	java/io/IOException
    //   179	199	571	java/io/IOException
    //   202	222	571	java/io/IOException
    //   225	249	571	java/io/IOException
    //   252	276	571	java/io/IOException
    //   279	303	571	java/io/IOException
    //   306	330	571	java/io/IOException
    //   333	357	571	java/io/IOException
    //   360	380	571	java/io/IOException
    //   383	406	571	java/io/IOException
    //   409	432	571	java/io/IOException
    //   435	458	571	java/io/IOException
    //   461	480	571	java/io/IOException
    //   483	505	571	java/io/IOException
    //   508	530	571	java/io/IOException
    //   533	551	571	java/io/IOException
    //   19	25	585	com/google/protobuf/InvalidProtocolBufferException
    //   164	176	585	com/google/protobuf/InvalidProtocolBufferException
    //   179	199	585	com/google/protobuf/InvalidProtocolBufferException
    //   202	222	585	com/google/protobuf/InvalidProtocolBufferException
    //   225	249	585	com/google/protobuf/InvalidProtocolBufferException
    //   252	276	585	com/google/protobuf/InvalidProtocolBufferException
    //   279	303	585	com/google/protobuf/InvalidProtocolBufferException
    //   306	330	585	com/google/protobuf/InvalidProtocolBufferException
    //   333	357	585	com/google/protobuf/InvalidProtocolBufferException
    //   360	380	585	com/google/protobuf/InvalidProtocolBufferException
    //   383	406	585	com/google/protobuf/InvalidProtocolBufferException
    //   409	432	585	com/google/protobuf/InvalidProtocolBufferException
    //   435	458	585	com/google/protobuf/InvalidProtocolBufferException
    //   461	480	585	com/google/protobuf/InvalidProtocolBufferException
    //   483	505	585	com/google/protobuf/InvalidProtocolBufferException
    //   508	530	585	com/google/protobuf/InvalidProtocolBufferException
    //   533	551	585	com/google/protobuf/InvalidProtocolBufferException
  }
  
  private a$a(GeneratedMessageV3.Builder<?> paramBuilder)
  {
    super(paramBuilder);
  }
  
  public static a.a.a G()
  {
    return s.H();
  }
  
  public static a I()
  {
    return s;
  }
  
  public static final Descriptors.Descriptor a()
  {
    return a.b();
  }
  
  public static a a(byte[] paramArrayOfByte)
  {
    return (a)a.parseFrom(paramArrayOfByte);
  }
  
  public String A()
  {
    Object localObject = this.o;
    if ((localObject instanceof String)) {
      return (String)localObject;
    }
    localObject = (ByteString)localObject;
    String str = ((ByteString)localObject).toStringUtf8();
    if (((ByteString)localObject).isValidUtf8()) {
      this.o = str;
    }
    return str;
  }
  
  public boolean B()
  {
    return (this.b & 0x2000) != 0;
  }
  
  public int C()
  {
    return this.p;
  }
  
  public boolean D()
  {
    return (this.b & 0x4000) != 0;
  }
  
  public int E()
  {
    return this.q;
  }
  
  public a.a.a F()
  {
    return G();
  }
  
  public a.a.a H()
  {
    if (this == s) {
      return new a.a.a(null);
    }
    return new a.a.a(null).a(this);
  }
  
  public a J()
  {
    return s;
  }
  
  protected a.a.a a(GeneratedMessageV3.BuilderParent paramBuilderParent)
  {
    return new a.a.a(paramBuilderParent, null);
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
    if ((j()) && (!k().equals(paramObject.k()))) {
      return false;
    }
    if (l() != paramObject.l()) {
      return false;
    }
    if ((l()) && (!m().equals(paramObject.m()))) {
      return false;
    }
    if (n() != paramObject.n()) {
      return false;
    }
    if ((n()) && (!o().equals(paramObject.o()))) {
      return false;
    }
    if (p() != paramObject.p()) {
      return false;
    }
    if ((p()) && (q() != paramObject.q())) {
      return false;
    }
    if (r() != paramObject.r()) {
      return false;
    }
    if ((r()) && (!s().equals(paramObject.s()))) {
      return false;
    }
    if (t() != paramObject.t()) {
      return false;
    }
    if ((t()) && (!u().equals(paramObject.u()))) {
      return false;
    }
    if (v() != paramObject.v()) {
      return false;
    }
    if ((v()) && (!w().equals(paramObject.w()))) {
      return false;
    }
    if (x() != paramObject.x()) {
      return false;
    }
    if ((x()) && (!y().equals(paramObject.y()))) {
      return false;
    }
    if (z() != paramObject.z()) {
      return false;
    }
    if ((z()) && (!A().equals(paramObject.A()))) {
      return false;
    }
    if (B() != paramObject.B()) {
      return false;
    }
    if ((B()) && (C() != paramObject.C())) {
      return false;
    }
    if (D() != paramObject.D()) {
      return false;
    }
    if ((D()) && (E() != paramObject.E())) {
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
  
  public Parser<a> getParserForType()
  {
    return a;
  }
  
  public int getSerializedSize()
  {
    int i1 = this.memoizedSize;
    if (i1 != -1) {
      return i1;
    }
    int i2 = 0;
    if ((this.b & 0x1) != 0) {
      i2 = 0 + CodedOutputStream.g(1, this.c);
    }
    i1 = i2;
    if ((this.b & 0x2) != 0) {
      i1 = i2 + GeneratedMessageV3.computeStringSize(2, this.d);
    }
    i2 = i1;
    if ((this.b & 0x4) != 0) {
      i2 = i1 + GeneratedMessageV3.computeStringSize(3, this.e);
    }
    i1 = i2;
    if ((this.b & 0x8) != 0) {
      i1 = i2 + CodedOutputStream.i(4, this.f);
    }
    i2 = i1;
    if ((this.b & 0x10) != 0) {
      i2 = i1 + GeneratedMessageV3.computeStringSize(5, this.g);
    }
    i1 = i2;
    if ((this.b & 0x20) != 0) {
      i1 = i2 + GeneratedMessageV3.computeStringSize(6, this.h);
    }
    i2 = i1;
    if ((this.b & 0x40) != 0) {
      i2 = i1 + GeneratedMessageV3.computeStringSize(7, this.i);
    }
    i1 = i2;
    if ((this.b & 0x80) != 0) {
      i1 = i2 + CodedOutputStream.i(8, this.j);
    }
    i2 = i1;
    if ((this.b & 0x100) != 0) {
      i2 = i1 + GeneratedMessageV3.computeStringSize(9, this.k);
    }
    i1 = i2;
    if ((this.b & 0x200) != 0) {
      i1 = i2 + GeneratedMessageV3.computeStringSize(10, this.l);
    }
    i2 = i1;
    if ((this.b & 0x400) != 0) {
      i2 = i1 + GeneratedMessageV3.computeStringSize(11, this.m);
    }
    i1 = i2;
    if ((this.b & 0x800) != 0) {
      i1 = i2 + GeneratedMessageV3.computeStringSize(12, this.n);
    }
    i2 = i1;
    if ((this.b & 0x1000) != 0) {
      i2 = i1 + GeneratedMessageV3.computeStringSize(13, this.o);
    }
    i1 = i2;
    if ((this.b & 0x2000) != 0) {
      i1 = i2 + CodedOutputStream.i(14, this.p);
    }
    i2 = i1;
    if ((this.b & 0x4000) != 0) {
      i2 = i1 + CodedOutputStream.i(15, this.q);
    }
    i1 = i2 + this.unknownFields.getSerializedSize();
    this.memoizedSize = i1;
    return i1;
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
    int i2 = 779 + a().hashCode();
    int i1 = i2;
    if (b()) {
      i1 = (i2 * 37 + 1) * 53 + Internal.a(c());
    }
    i2 = i1;
    if (d()) {
      i2 = (i1 * 37 + 2) * 53 + e().hashCode();
    }
    i1 = i2;
    if (f()) {
      i1 = (i2 * 37 + 3) * 53 + g().hashCode();
    }
    i2 = i1;
    if (h()) {
      i2 = (i1 * 37 + 4) * 53 + i();
    }
    i1 = i2;
    if (j()) {
      i1 = (i2 * 37 + 5) * 53 + k().hashCode();
    }
    i2 = i1;
    if (l()) {
      i2 = (i1 * 37 + 6) * 53 + m().hashCode();
    }
    i1 = i2;
    if (n()) {
      i1 = (i2 * 37 + 7) * 53 + o().hashCode();
    }
    i2 = i1;
    if (p()) {
      i2 = (i1 * 37 + 8) * 53 + q();
    }
    i1 = i2;
    if (r()) {
      i1 = (i2 * 37 + 9) * 53 + s().hashCode();
    }
    i2 = i1;
    if (t()) {
      i2 = (i1 * 37 + 10) * 53 + u().hashCode();
    }
    i1 = i2;
    if (v()) {
      i1 = (i2 * 37 + 11) * 53 + w().hashCode();
    }
    i2 = i1;
    if (x()) {
      i2 = (i1 * 37 + 12) * 53 + y().hashCode();
    }
    i1 = i2;
    if (z()) {
      i1 = (i2 * 37 + 13) * 53 + A().hashCode();
    }
    i2 = i1;
    if (B()) {
      i2 = (i1 * 37 + 14) * 53 + C();
    }
    i1 = i2;
    if (D()) {
      i1 = (i2 * 37 + 15) * 53 + E();
    }
    i1 = i1 * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i1;
    return i1;
  }
  
  public int i()
  {
    return this.f;
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return a.c().a(a.class, a.a.a.class);
  }
  
  public final boolean isInitialized()
  {
    int i1 = this.r;
    if (i1 == 1) {
      return true;
    }
    if (i1 == 0) {
      return false;
    }
    if (!d())
    {
      this.r = 0;
      return false;
    }
    this.r = 1;
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
  
  public boolean l()
  {
    return (this.b & 0x20) != 0;
  }
  
  public String m()
  {
    Object localObject = this.h;
    if ((localObject instanceof String)) {
      return (String)localObject;
    }
    localObject = (ByteString)localObject;
    String str = ((ByteString)localObject).toStringUtf8();
    if (((ByteString)localObject).isValidUtf8()) {
      this.h = str;
    }
    return str;
  }
  
  public boolean n()
  {
    return (this.b & 0x40) != 0;
  }
  
  protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter paramUnusedPrivateParameter)
  {
    return new a();
  }
  
  public String o()
  {
    Object localObject = this.i;
    if ((localObject instanceof String)) {
      return (String)localObject;
    }
    localObject = (ByteString)localObject;
    String str = ((ByteString)localObject).toStringUtf8();
    if (((ByteString)localObject).isValidUtf8()) {
      this.i = str;
    }
    return str;
  }
  
  public boolean p()
  {
    return (this.b & 0x80) != 0;
  }
  
  public int q()
  {
    return this.j;
  }
  
  public boolean r()
  {
    return (this.b & 0x100) != 0;
  }
  
  public String s()
  {
    Object localObject = this.k;
    if ((localObject instanceof String)) {
      return (String)localObject;
    }
    localObject = (ByteString)localObject;
    String str = ((ByteString)localObject).toStringUtf8();
    if (((ByteString)localObject).isValidUtf8()) {
      this.k = str;
    }
    return str;
  }
  
  public boolean t()
  {
    return (this.b & 0x200) != 0;
  }
  
  public String u()
  {
    Object localObject = this.l;
    if ((localObject instanceof String)) {
      return (String)localObject;
    }
    localObject = (ByteString)localObject;
    String str = ((ByteString)localObject).toStringUtf8();
    if (((ByteString)localObject).isValidUtf8()) {
      this.l = str;
    }
    return str;
  }
  
  public boolean v()
  {
    return (this.b & 0x400) != 0;
  }
  
  public String w()
  {
    Object localObject = this.m;
    if ((localObject instanceof String)) {
      return (String)localObject;
    }
    localObject = (ByteString)localObject;
    String str = ((ByteString)localObject).toStringUtf8();
    if (((ByteString)localObject).isValidUtf8()) {
      this.m = str;
    }
    return str;
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
      GeneratedMessageV3.writeString(paramCodedOutputStream, 3, this.e);
    }
    if ((this.b & 0x8) != 0) {
      paramCodedOutputStream.c(4, this.f);
    }
    if ((this.b & 0x10) != 0) {
      GeneratedMessageV3.writeString(paramCodedOutputStream, 5, this.g);
    }
    if ((this.b & 0x20) != 0) {
      GeneratedMessageV3.writeString(paramCodedOutputStream, 6, this.h);
    }
    if ((this.b & 0x40) != 0) {
      GeneratedMessageV3.writeString(paramCodedOutputStream, 7, this.i);
    }
    if ((this.b & 0x80) != 0) {
      paramCodedOutputStream.c(8, this.j);
    }
    if ((this.b & 0x100) != 0) {
      GeneratedMessageV3.writeString(paramCodedOutputStream, 9, this.k);
    }
    if ((this.b & 0x200) != 0) {
      GeneratedMessageV3.writeString(paramCodedOutputStream, 10, this.l);
    }
    if ((this.b & 0x400) != 0) {
      GeneratedMessageV3.writeString(paramCodedOutputStream, 11, this.m);
    }
    if ((this.b & 0x800) != 0) {
      GeneratedMessageV3.writeString(paramCodedOutputStream, 12, this.n);
    }
    if ((this.b & 0x1000) != 0) {
      GeneratedMessageV3.writeString(paramCodedOutputStream, 13, this.o);
    }
    if ((this.b & 0x2000) != 0) {
      paramCodedOutputStream.c(14, this.p);
    }
    if ((this.b & 0x4000) != 0) {
      paramCodedOutputStream.c(15, this.q);
    }
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
  
  public boolean x()
  {
    return (this.b & 0x800) != 0;
  }
  
  public String y()
  {
    Object localObject = this.n;
    if ((localObject instanceof String)) {
      return (String)localObject;
    }
    localObject = (ByteString)localObject;
    String str = ((ByteString)localObject).toStringUtf8();
    if (((ByteString)localObject).isValidUtf8()) {
      this.n = str;
    }
    return str;
  }
  
  public boolean z()
  {
    return (this.b & 0x1000) != 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ar.a.a
 * JD-Core Version:    0.7.0.1
 */