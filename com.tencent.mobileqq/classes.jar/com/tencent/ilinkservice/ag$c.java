package com.tencent.ilinkservice;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.GeneratedMessageV3.Builder;
import com.google.protobuf.GeneratedMessageV3.BuilderParent;
import com.google.protobuf.GeneratedMessageV3.FieldAccessorTable;
import com.google.protobuf.GeneratedMessageV3.UnusedPrivateParameter;
import com.google.protobuf.Internal;
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import com.google.protobuf.Parser;
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.UnknownFieldSet;

public final class ag$c
  extends GeneratedMessageV3
  implements aj
{
  @Deprecated
  public static final Parser<c> a = new ag.c.1();
  private static final c m = new c();
  private int b;
  private int c;
  private int d;
  private volatile Object e;
  private int f;
  private LazyStringList g;
  private boolean h;
  private volatile Object i;
  private volatile Object j;
  private LazyStringList k;
  private byte l = -1;
  
  private ag$c()
  {
    this.e = "";
    this.g = LazyStringArrayList.a;
    this.i = "";
    this.j = "";
    this.k = LazyStringArrayList.a;
  }
  
  /* Error */
  private ag$c(com.google.protobuf.CodedInputStream paramCodedInputStream, com.google.protobuf.ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 33	com/tencent/ilinkservice/ag$c:<init>	()V
    //   4: aload_2
    //   5: ifnull +756 -> 761
    //   8: invokestatic 70	com/google/protobuf/UnknownFieldSet:a	()Lcom/google/protobuf/UnknownFieldSet$Builder;
    //   11: astore 9
    //   13: iconst_0
    //   14: istore 8
    //   16: iconst_0
    //   17: istore_3
    //   18: iload 8
    //   20: ifne +686 -> 706
    //   23: iload_3
    //   24: istore 4
    //   26: iload_3
    //   27: istore 6
    //   29: iload_3
    //   30: istore 7
    //   32: aload_1
    //   33: invokevirtual 75	com/google/protobuf/CodedInputStream:a	()I
    //   36: istore 5
    //   38: iload 5
    //   40: ifeq +569 -> 609
    //   43: iload 5
    //   45: bipush 8
    //   47: if_icmpeq +523 -> 570
    //   50: iload 5
    //   52: bipush 16
    //   54: if_icmpeq +477 -> 531
    //   57: iload 5
    //   59: bipush 26
    //   61: if_icmpeq +418 -> 479
    //   64: iload 5
    //   66: bipush 32
    //   68: if_icmpeq +371 -> 439
    //   71: iload 5
    //   73: bipush 42
    //   75: if_icmpeq +284 -> 359
    //   78: iload 5
    //   80: bipush 48
    //   82: if_icmpeq +237 -> 319
    //   85: iload 5
    //   87: bipush 58
    //   89: if_icmpeq +177 -> 266
    //   92: iload 5
    //   94: bipush 66
    //   96: if_icmpeq +117 -> 213
    //   99: iload 5
    //   101: bipush 74
    //   103: if_icmpeq +28 -> 131
    //   106: iload_3
    //   107: istore 4
    //   109: iload_3
    //   110: istore 6
    //   112: iload_3
    //   113: istore 7
    //   115: aload_0
    //   116: aload_1
    //   117: aload 9
    //   119: aload_2
    //   120: iload 5
    //   122: invokevirtual 79	com/tencent/ilinkservice/ag$c:parseUnknownField	(Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/UnknownFieldSet$Builder;Lcom/google/protobuf/ExtensionRegistryLite;I)Z
    //   125: ifne -107 -> 18
    //   128: goto +481 -> 609
    //   131: iload_3
    //   132: istore 4
    //   134: iload_3
    //   135: istore 6
    //   137: iload_3
    //   138: istore 7
    //   140: aload_1
    //   141: invokevirtual 82	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   144: astore 10
    //   146: iload_3
    //   147: istore 5
    //   149: iload_3
    //   150: sipush 256
    //   153: iand
    //   154: ifne +30 -> 184
    //   157: iload_3
    //   158: istore 4
    //   160: iload_3
    //   161: istore 6
    //   163: iload_3
    //   164: istore 7
    //   166: aload_0
    //   167: new 50	com/google/protobuf/LazyStringArrayList
    //   170: dup
    //   171: invokespecial 83	com/google/protobuf/LazyStringArrayList:<init>	()V
    //   174: putfield 60	com/tencent/ilinkservice/ag$c:k	Lcom/google/protobuf/LazyStringList;
    //   177: iload_3
    //   178: sipush 256
    //   181: ior
    //   182: istore 5
    //   184: iload 5
    //   186: istore 4
    //   188: iload 5
    //   190: istore 6
    //   192: iload 5
    //   194: istore 7
    //   196: aload_0
    //   197: getfield 60	com/tencent/ilinkservice/ag$c:k	Lcom/google/protobuf/LazyStringList;
    //   200: aload 10
    //   202: invokeinterface 88 2 0
    //   207: iload 5
    //   209: istore_3
    //   210: goto -192 -> 18
    //   213: iload_3
    //   214: istore 4
    //   216: iload_3
    //   217: istore 6
    //   219: iload_3
    //   220: istore 7
    //   222: aload_1
    //   223: invokevirtual 82	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   226: astore 10
    //   228: iload_3
    //   229: istore 4
    //   231: iload_3
    //   232: istore 6
    //   234: iload_3
    //   235: istore 7
    //   237: aload_0
    //   238: aload_0
    //   239: getfield 90	com/tencent/ilinkservice/ag$c:b	I
    //   242: bipush 64
    //   244: ior
    //   245: putfield 90	com/tencent/ilinkservice/ag$c:b	I
    //   248: iload_3
    //   249: istore 4
    //   251: iload_3
    //   252: istore 6
    //   254: iload_3
    //   255: istore 7
    //   257: aload_0
    //   258: aload 10
    //   260: putfield 58	com/tencent/ilinkservice/ag$c:j	Ljava/lang/Object;
    //   263: goto -245 -> 18
    //   266: iload_3
    //   267: istore 4
    //   269: iload_3
    //   270: istore 6
    //   272: iload_3
    //   273: istore 7
    //   275: aload_1
    //   276: invokevirtual 82	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   279: astore 10
    //   281: iload_3
    //   282: istore 4
    //   284: iload_3
    //   285: istore 6
    //   287: iload_3
    //   288: istore 7
    //   290: aload_0
    //   291: aload_0
    //   292: getfield 90	com/tencent/ilinkservice/ag$c:b	I
    //   295: bipush 32
    //   297: ior
    //   298: putfield 90	com/tencent/ilinkservice/ag$c:b	I
    //   301: iload_3
    //   302: istore 4
    //   304: iload_3
    //   305: istore 6
    //   307: iload_3
    //   308: istore 7
    //   310: aload_0
    //   311: aload 10
    //   313: putfield 56	com/tencent/ilinkservice/ag$c:i	Ljava/lang/Object;
    //   316: goto -298 -> 18
    //   319: iload_3
    //   320: istore 4
    //   322: iload_3
    //   323: istore 6
    //   325: iload_3
    //   326: istore 7
    //   328: aload_0
    //   329: aload_0
    //   330: getfield 90	com/tencent/ilinkservice/ag$c:b	I
    //   333: bipush 16
    //   335: ior
    //   336: putfield 90	com/tencent/ilinkservice/ag$c:b	I
    //   339: iload_3
    //   340: istore 4
    //   342: iload_3
    //   343: istore 6
    //   345: iload_3
    //   346: istore 7
    //   348: aload_0
    //   349: aload_1
    //   350: invokevirtual 93	com/google/protobuf/CodedInputStream:i	()Z
    //   353: putfield 95	com/tencent/ilinkservice/ag$c:h	Z
    //   356: goto -338 -> 18
    //   359: iload_3
    //   360: istore 4
    //   362: iload_3
    //   363: istore 6
    //   365: iload_3
    //   366: istore 7
    //   368: aload_1
    //   369: invokevirtual 82	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   372: astore 10
    //   374: iload_3
    //   375: istore 5
    //   377: iload_3
    //   378: bipush 16
    //   380: iand
    //   381: ifne +29 -> 410
    //   384: iload_3
    //   385: istore 4
    //   387: iload_3
    //   388: istore 6
    //   390: iload_3
    //   391: istore 7
    //   393: aload_0
    //   394: new 50	com/google/protobuf/LazyStringArrayList
    //   397: dup
    //   398: invokespecial 83	com/google/protobuf/LazyStringArrayList:<init>	()V
    //   401: putfield 54	com/tencent/ilinkservice/ag$c:g	Lcom/google/protobuf/LazyStringList;
    //   404: iload_3
    //   405: bipush 16
    //   407: ior
    //   408: istore 5
    //   410: iload 5
    //   412: istore 4
    //   414: iload 5
    //   416: istore 6
    //   418: iload 5
    //   420: istore 7
    //   422: aload_0
    //   423: getfield 54	com/tencent/ilinkservice/ag$c:g	Lcom/google/protobuf/LazyStringList;
    //   426: aload 10
    //   428: invokeinterface 88 2 0
    //   433: iload 5
    //   435: istore_3
    //   436: goto -418 -> 18
    //   439: iload_3
    //   440: istore 4
    //   442: iload_3
    //   443: istore 6
    //   445: iload_3
    //   446: istore 7
    //   448: aload_0
    //   449: aload_0
    //   450: getfield 90	com/tencent/ilinkservice/ag$c:b	I
    //   453: bipush 8
    //   455: ior
    //   456: putfield 90	com/tencent/ilinkservice/ag$c:b	I
    //   459: iload_3
    //   460: istore 4
    //   462: iload_3
    //   463: istore 6
    //   465: iload_3
    //   466: istore 7
    //   468: aload_0
    //   469: aload_1
    //   470: invokevirtual 97	com/google/protobuf/CodedInputStream:m	()I
    //   473: putfield 99	com/tencent/ilinkservice/ag$c:f	I
    //   476: goto -458 -> 18
    //   479: iload_3
    //   480: istore 4
    //   482: iload_3
    //   483: istore 6
    //   485: iload_3
    //   486: istore 7
    //   488: aload_1
    //   489: invokevirtual 82	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   492: astore 10
    //   494: iload_3
    //   495: istore 4
    //   497: iload_3
    //   498: istore 6
    //   500: iload_3
    //   501: istore 7
    //   503: aload_0
    //   504: aload_0
    //   505: getfield 90	com/tencent/ilinkservice/ag$c:b	I
    //   508: iconst_4
    //   509: ior
    //   510: putfield 90	com/tencent/ilinkservice/ag$c:b	I
    //   513: iload_3
    //   514: istore 4
    //   516: iload_3
    //   517: istore 6
    //   519: iload_3
    //   520: istore 7
    //   522: aload_0
    //   523: aload 10
    //   525: putfield 48	com/tencent/ilinkservice/ag$c:e	Ljava/lang/Object;
    //   528: goto -510 -> 18
    //   531: iload_3
    //   532: istore 4
    //   534: iload_3
    //   535: istore 6
    //   537: iload_3
    //   538: istore 7
    //   540: aload_0
    //   541: aload_0
    //   542: getfield 90	com/tencent/ilinkservice/ag$c:b	I
    //   545: iconst_2
    //   546: ior
    //   547: putfield 90	com/tencent/ilinkservice/ag$c:b	I
    //   550: iload_3
    //   551: istore 4
    //   553: iload_3
    //   554: istore 6
    //   556: iload_3
    //   557: istore 7
    //   559: aload_0
    //   560: aload_1
    //   561: invokevirtual 97	com/google/protobuf/CodedInputStream:m	()I
    //   564: putfield 101	com/tencent/ilinkservice/ag$c:d	I
    //   567: goto -549 -> 18
    //   570: iload_3
    //   571: istore 4
    //   573: iload_3
    //   574: istore 6
    //   576: iload_3
    //   577: istore 7
    //   579: aload_0
    //   580: aload_0
    //   581: getfield 90	com/tencent/ilinkservice/ag$c:b	I
    //   584: iconst_1
    //   585: ior
    //   586: putfield 90	com/tencent/ilinkservice/ag$c:b	I
    //   589: iload_3
    //   590: istore 4
    //   592: iload_3
    //   593: istore 6
    //   595: iload_3
    //   596: istore 7
    //   598: aload_0
    //   599: aload_1
    //   600: invokevirtual 97	com/google/protobuf/CodedInputStream:m	()I
    //   603: putfield 103	com/tencent/ilinkservice/ag$c:c	I
    //   606: goto -588 -> 18
    //   609: iconst_1
    //   610: istore 8
    //   612: goto -594 -> 18
    //   615: astore_1
    //   616: goto +32 -> 648
    //   619: astore_1
    //   620: iload 6
    //   622: istore 4
    //   624: new 63	com/google/protobuf/InvalidProtocolBufferException
    //   627: dup
    //   628: aload_1
    //   629: invokespecial 106	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/io/IOException;)V
    //   632: aload_0
    //   633: invokevirtual 110	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   636: athrow
    //   637: astore_1
    //   638: iload 7
    //   640: istore 4
    //   642: aload_1
    //   643: aload_0
    //   644: invokevirtual 110	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   647: athrow
    //   648: iload 4
    //   650: bipush 16
    //   652: iand
    //   653: ifeq +16 -> 669
    //   656: aload_0
    //   657: aload_0
    //   658: getfield 54	com/tencent/ilinkservice/ag$c:g	Lcom/google/protobuf/LazyStringList;
    //   661: invokeinterface 113 1 0
    //   666: putfield 54	com/tencent/ilinkservice/ag$c:g	Lcom/google/protobuf/LazyStringList;
    //   669: iload 4
    //   671: sipush 256
    //   674: iand
    //   675: ifeq +16 -> 691
    //   678: aload_0
    //   679: aload_0
    //   680: getfield 60	com/tencent/ilinkservice/ag$c:k	Lcom/google/protobuf/LazyStringList;
    //   683: invokeinterface 113 1 0
    //   688: putfield 60	com/tencent/ilinkservice/ag$c:k	Lcom/google/protobuf/LazyStringList;
    //   691: aload_0
    //   692: aload 9
    //   694: invokevirtual 118	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   697: putfield 122	com/tencent/ilinkservice/ag$c:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   700: aload_0
    //   701: invokevirtual 125	com/tencent/ilinkservice/ag$c:makeExtensionsImmutable	()V
    //   704: aload_1
    //   705: athrow
    //   706: iload_3
    //   707: bipush 16
    //   709: iand
    //   710: ifeq +16 -> 726
    //   713: aload_0
    //   714: aload_0
    //   715: getfield 54	com/tencent/ilinkservice/ag$c:g	Lcom/google/protobuf/LazyStringList;
    //   718: invokeinterface 113 1 0
    //   723: putfield 54	com/tencent/ilinkservice/ag$c:g	Lcom/google/protobuf/LazyStringList;
    //   726: iload_3
    //   727: sipush 256
    //   730: iand
    //   731: ifeq +16 -> 747
    //   734: aload_0
    //   735: aload_0
    //   736: getfield 60	com/tencent/ilinkservice/ag$c:k	Lcom/google/protobuf/LazyStringList;
    //   739: invokeinterface 113 1 0
    //   744: putfield 60	com/tencent/ilinkservice/ag$c:k	Lcom/google/protobuf/LazyStringList;
    //   747: aload_0
    //   748: aload 9
    //   750: invokevirtual 118	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   753: putfield 122	com/tencent/ilinkservice/ag$c:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   756: aload_0
    //   757: invokevirtual 125	com/tencent/ilinkservice/ag$c:makeExtensionsImmutable	()V
    //   760: return
    //   761: new 127	java/lang/NullPointerException
    //   764: dup
    //   765: invokespecial 128	java/lang/NullPointerException:<init>	()V
    //   768: astore_1
    //   769: goto +5 -> 774
    //   772: aload_1
    //   773: athrow
    //   774: goto -2 -> 772
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	777	0	this	c
    //   0	777	1	paramCodedInputStream	com.google.protobuf.CodedInputStream
    //   0	777	2	paramExtensionRegistryLite	com.google.protobuf.ExtensionRegistryLite
    //   17	714	3	n	int
    //   24	651	4	i1	int
    //   36	398	5	i2	int
    //   27	594	6	i3	int
    //   30	609	7	i4	int
    //   14	597	8	i5	int
    //   11	738	9	localBuilder	com.google.protobuf.UnknownFieldSet.Builder
    //   144	380	10	localByteString	ByteString
    // Exception table:
    //   from	to	target	type
    //   32	38	615	finally
    //   115	128	615	finally
    //   140	146	615	finally
    //   166	177	615	finally
    //   196	207	615	finally
    //   222	228	615	finally
    //   237	248	615	finally
    //   257	263	615	finally
    //   275	281	615	finally
    //   290	301	615	finally
    //   310	316	615	finally
    //   328	339	615	finally
    //   348	356	615	finally
    //   368	374	615	finally
    //   393	404	615	finally
    //   422	433	615	finally
    //   448	459	615	finally
    //   468	476	615	finally
    //   488	494	615	finally
    //   503	513	615	finally
    //   522	528	615	finally
    //   540	550	615	finally
    //   559	567	615	finally
    //   579	589	615	finally
    //   598	606	615	finally
    //   624	637	615	finally
    //   642	648	615	finally
    //   32	38	619	java/io/IOException
    //   115	128	619	java/io/IOException
    //   140	146	619	java/io/IOException
    //   166	177	619	java/io/IOException
    //   196	207	619	java/io/IOException
    //   222	228	619	java/io/IOException
    //   237	248	619	java/io/IOException
    //   257	263	619	java/io/IOException
    //   275	281	619	java/io/IOException
    //   290	301	619	java/io/IOException
    //   310	316	619	java/io/IOException
    //   328	339	619	java/io/IOException
    //   348	356	619	java/io/IOException
    //   368	374	619	java/io/IOException
    //   393	404	619	java/io/IOException
    //   422	433	619	java/io/IOException
    //   448	459	619	java/io/IOException
    //   468	476	619	java/io/IOException
    //   488	494	619	java/io/IOException
    //   503	513	619	java/io/IOException
    //   522	528	619	java/io/IOException
    //   540	550	619	java/io/IOException
    //   559	567	619	java/io/IOException
    //   579	589	619	java/io/IOException
    //   598	606	619	java/io/IOException
    //   32	38	637	com/google/protobuf/InvalidProtocolBufferException
    //   115	128	637	com/google/protobuf/InvalidProtocolBufferException
    //   140	146	637	com/google/protobuf/InvalidProtocolBufferException
    //   166	177	637	com/google/protobuf/InvalidProtocolBufferException
    //   196	207	637	com/google/protobuf/InvalidProtocolBufferException
    //   222	228	637	com/google/protobuf/InvalidProtocolBufferException
    //   237	248	637	com/google/protobuf/InvalidProtocolBufferException
    //   257	263	637	com/google/protobuf/InvalidProtocolBufferException
    //   275	281	637	com/google/protobuf/InvalidProtocolBufferException
    //   290	301	637	com/google/protobuf/InvalidProtocolBufferException
    //   310	316	637	com/google/protobuf/InvalidProtocolBufferException
    //   328	339	637	com/google/protobuf/InvalidProtocolBufferException
    //   348	356	637	com/google/protobuf/InvalidProtocolBufferException
    //   368	374	637	com/google/protobuf/InvalidProtocolBufferException
    //   393	404	637	com/google/protobuf/InvalidProtocolBufferException
    //   422	433	637	com/google/protobuf/InvalidProtocolBufferException
    //   448	459	637	com/google/protobuf/InvalidProtocolBufferException
    //   468	476	637	com/google/protobuf/InvalidProtocolBufferException
    //   488	494	637	com/google/protobuf/InvalidProtocolBufferException
    //   503	513	637	com/google/protobuf/InvalidProtocolBufferException
    //   522	528	637	com/google/protobuf/InvalidProtocolBufferException
    //   540	550	637	com/google/protobuf/InvalidProtocolBufferException
    //   559	567	637	com/google/protobuf/InvalidProtocolBufferException
    //   579	589	637	com/google/protobuf/InvalidProtocolBufferException
    //   598	606	637	com/google/protobuf/InvalidProtocolBufferException
  }
  
  private ag$c(GeneratedMessageV3.Builder<?> paramBuilder)
  {
    super(paramBuilder);
  }
  
  public static final Descriptors.Descriptor a()
  {
    return ag.j();
  }
  
  public static c a(byte[] paramArrayOfByte)
  {
    return (c)a.parseFrom(paramArrayOfByte);
  }
  
  public static ag.c.a u()
  {
    return m.v();
  }
  
  public static c w()
  {
    return m;
  }
  
  protected ag.c.a a(GeneratedMessageV3.BuilderParent paramBuilderParent)
  {
    return new ag.c.a(paramBuilderParent, null);
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
  
  public int e()
  {
    return this.d;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof c)) {
      return super.equals(paramObject);
    }
    paramObject = (c)paramObject;
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
    if (h() != paramObject.h()) {
      return false;
    }
    if ((h()) && (i() != paramObject.i())) {
      return false;
    }
    if (!j().equals(paramObject.j())) {
      return false;
    }
    if (l() != paramObject.l()) {
      return false;
    }
    if ((l()) && (m() != paramObject.m())) {
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
    if ((p()) && (!q().equals(paramObject.q()))) {
      return false;
    }
    if (!r().equals(paramObject.r())) {
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
  
  public Parser<c> getParserForType()
  {
    return a;
  }
  
  public int getSerializedSize()
  {
    int n = this.memoizedSize;
    if (n != -1) {
      return n;
    }
    n = this.b;
    int i3 = 0;
    if ((n & 0x1) != 0) {
      i1 = CodedOutputStream.i(1, this.c) + 0;
    } else {
      i1 = 0;
    }
    n = i1;
    if ((this.b & 0x2) != 0) {
      n = i1 + CodedOutputStream.i(2, this.d);
    }
    int i1 = n;
    if ((this.b & 0x4) != 0) {
      i1 = n + GeneratedMessageV3.computeStringSize(3, this.e);
    }
    n = i1;
    if ((this.b & 0x8) != 0) {
      n = i1 + CodedOutputStream.i(4, this.f);
    }
    i1 = 0;
    int i2 = 0;
    while (i1 < this.g.size())
    {
      i2 += computeStringSizeNoTag(this.g.d(i1));
      i1 += 1;
    }
    i1 = n + i2 + j().size() * 1;
    n = i1;
    if ((this.b & 0x10) != 0) {
      n = i1 + CodedOutputStream.b(6, this.h);
    }
    i1 = n;
    if ((this.b & 0x20) != 0) {
      i1 = n + GeneratedMessageV3.computeStringSize(7, this.i);
    }
    n = i1;
    if ((this.b & 0x40) != 0) {
      n = i1 + GeneratedMessageV3.computeStringSize(8, this.j);
    }
    i2 = 0;
    i1 = i3;
    while (i1 < this.k.size())
    {
      i2 += computeStringSizeNoTag(this.k.d(i1));
      i1 += 1;
    }
    n = n + i2 + r().size() * 1 + this.unknownFields.getSerializedSize();
    this.memoizedSize = n;
    return n;
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
    int i1 = 779 + a().hashCode();
    int n = i1;
    if (b()) {
      n = (i1 * 37 + 1) * 53 + c();
    }
    i1 = n;
    if (d()) {
      i1 = (n * 37 + 2) * 53 + e();
    }
    n = i1;
    if (f()) {
      n = (i1 * 37 + 3) * 53 + g().hashCode();
    }
    i1 = n;
    if (h()) {
      i1 = (n * 37 + 4) * 53 + i();
    }
    n = i1;
    if (k() > 0) {
      n = (i1 * 37 + 5) * 53 + j().hashCode();
    }
    i1 = n;
    if (l()) {
      i1 = (n * 37 + 6) * 53 + Internal.a(m());
    }
    n = i1;
    if (n()) {
      n = (i1 * 37 + 7) * 53 + o().hashCode();
    }
    i1 = n;
    if (p()) {
      i1 = (n * 37 + 8) * 53 + q().hashCode();
    }
    n = i1;
    if (s() > 0) {
      n = (i1 * 37 + 9) * 53 + r().hashCode();
    }
    n = n * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = n;
    return n;
  }
  
  public int i()
  {
    return this.f;
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return ag.k().a(c.class, ag.c.a.class);
  }
  
  public final boolean isInitialized()
  {
    int n = this.l;
    if (n == 1) {
      return true;
    }
    if (n == 0) {
      return false;
    }
    this.l = 1;
    return true;
  }
  
  public ProtocolStringList j()
  {
    return this.g;
  }
  
  public int k()
  {
    return this.g.size();
  }
  
  public boolean l()
  {
    return (this.b & 0x10) != 0;
  }
  
  public boolean m()
  {
    return this.h;
  }
  
  public boolean n()
  {
    return (this.b & 0x20) != 0;
  }
  
  protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter paramUnusedPrivateParameter)
  {
    return new c();
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
    return (this.b & 0x40) != 0;
  }
  
  public String q()
  {
    Object localObject = this.j;
    if ((localObject instanceof String)) {
      return (String)localObject;
    }
    localObject = (ByteString)localObject;
    String str = ((ByteString)localObject).toStringUtf8();
    if (((ByteString)localObject).isValidUtf8()) {
      this.j = str;
    }
    return str;
  }
  
  public ProtocolStringList r()
  {
    return this.k;
  }
  
  public int s()
  {
    return this.k.size();
  }
  
  public ag.c.a t()
  {
    return u();
  }
  
  public ag.c.a v()
  {
    if (this == m) {
      return new ag.c.a(null);
    }
    return new ag.c.a(null).a(this);
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
  {
    if ((this.b & 0x1) != 0) {
      paramCodedOutputStream.c(1, this.c);
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
    int i1 = 0;
    int n = 0;
    while (n < this.g.size())
    {
      GeneratedMessageV3.writeString(paramCodedOutputStream, 5, this.g.d(n));
      n += 1;
    }
    if ((this.b & 0x10) != 0) {
      paramCodedOutputStream.a(6, this.h);
    }
    if ((this.b & 0x20) != 0) {
      GeneratedMessageV3.writeString(paramCodedOutputStream, 7, this.i);
    }
    n = i1;
    if ((this.b & 0x40) != 0)
    {
      GeneratedMessageV3.writeString(paramCodedOutputStream, 8, this.j);
      n = i1;
    }
    while (n < this.k.size())
    {
      GeneratedMessageV3.writeString(paramCodedOutputStream, 9, this.k.d(n));
      n += 1;
    }
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
  
  public c x()
  {
    return m;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilinkservice.ag.c
 * JD-Core Version:    0.7.0.1
 */