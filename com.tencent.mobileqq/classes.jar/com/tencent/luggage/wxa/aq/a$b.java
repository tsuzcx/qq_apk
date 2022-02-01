package com.tencent.luggage.wxa.aq;

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

public final class a$b
  extends GeneratedMessageV3
  implements c
{
  @Deprecated
  public static final Parser<b> a = new a.b.1();
  private static final b n = new b();
  private int b;
  private volatile Object c;
  private LazyStringList d;
  private boolean e;
  private volatile Object f;
  private volatile Object g;
  private long h;
  private volatile Object i;
  private volatile Object j;
  private int k;
  private int l;
  private byte m = -1;
  
  private a$b()
  {
    this.c = "";
    this.d = LazyStringArrayList.a;
    this.f = "";
    this.g = "";
    this.i = "";
    this.j = "";
  }
  
  /* Error */
  private a$b(com.google.protobuf.CodedInputStream paramCodedInputStream, com.google.protobuf.ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 35	com/tencent/luggage/wxa/aq/a$b:<init>	()V
    //   4: aload_2
    //   5: ifnull +776 -> 781
    //   8: invokestatic 74	com/google/protobuf/UnknownFieldSet:a	()Lcom/google/protobuf/UnknownFieldSet$Builder;
    //   11: astore 10
    //   13: iconst_0
    //   14: istore 8
    //   16: iconst_0
    //   17: istore_3
    //   18: iload 8
    //   20: ifne +728 -> 748
    //   23: iload_3
    //   24: istore 5
    //   26: iload_3
    //   27: istore 6
    //   29: iload_3
    //   30: istore 7
    //   32: aload_1
    //   33: invokevirtual 79	com/google/protobuf/CodedInputStream:a	()I
    //   36: istore 4
    //   38: iload 4
    //   40: lookupswitch	default:+757->797, 0:+626->666, 10:+574->614, 18:+496->536, 24:+457->497, 34:+405->445, 42:+352->392, 48:+312->352, 58:+259->299, 66:+206->246, 72:+165->205, 80:+124->164
    //   141: istore 5
    //   143: iload_3
    //   144: istore 6
    //   146: iload_3
    //   147: istore 7
    //   149: aload_0
    //   150: aload_1
    //   151: aload 10
    //   153: aload_2
    //   154: iload 4
    //   156: invokevirtual 83	com/tencent/luggage/wxa/aq/a$b:parseUnknownField	(Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/UnknownFieldSet$Builder;Lcom/google/protobuf/ExtensionRegistryLite;I)Z
    //   159: istore 9
    //   161: goto +511 -> 672
    //   164: iload_3
    //   165: istore 5
    //   167: iload_3
    //   168: istore 6
    //   170: iload_3
    //   171: istore 7
    //   173: aload_0
    //   174: aload_0
    //   175: getfield 85	com/tencent/luggage/wxa/aq/a$b:b	I
    //   178: sipush 256
    //   181: ior
    //   182: putfield 85	com/tencent/luggage/wxa/aq/a$b:b	I
    //   185: iload_3
    //   186: istore 5
    //   188: iload_3
    //   189: istore 6
    //   191: iload_3
    //   192: istore 7
    //   194: aload_0
    //   195: aload_1
    //   196: invokevirtual 87	com/google/protobuf/CodedInputStream:m	()I
    //   199: putfield 89	com/tencent/luggage/wxa/aq/a$b:l	I
    //   202: goto -184 -> 18
    //   205: iload_3
    //   206: istore 5
    //   208: iload_3
    //   209: istore 6
    //   211: iload_3
    //   212: istore 7
    //   214: aload_0
    //   215: aload_0
    //   216: getfield 85	com/tencent/luggage/wxa/aq/a$b:b	I
    //   219: sipush 128
    //   222: ior
    //   223: putfield 85	com/tencent/luggage/wxa/aq/a$b:b	I
    //   226: iload_3
    //   227: istore 5
    //   229: iload_3
    //   230: istore 6
    //   232: iload_3
    //   233: istore 7
    //   235: aload_0
    //   236: aload_1
    //   237: invokevirtual 87	com/google/protobuf/CodedInputStream:m	()I
    //   240: putfield 91	com/tencent/luggage/wxa/aq/a$b:k	I
    //   243: goto -225 -> 18
    //   246: iload_3
    //   247: istore 5
    //   249: iload_3
    //   250: istore 6
    //   252: iload_3
    //   253: istore 7
    //   255: aload_1
    //   256: invokevirtual 94	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   259: astore 11
    //   261: iload_3
    //   262: istore 5
    //   264: iload_3
    //   265: istore 6
    //   267: iload_3
    //   268: istore 7
    //   270: aload_0
    //   271: aload_0
    //   272: getfield 85	com/tencent/luggage/wxa/aq/a$b:b	I
    //   275: bipush 64
    //   277: ior
    //   278: putfield 85	com/tencent/luggage/wxa/aq/a$b:b	I
    //   281: iload_3
    //   282: istore 5
    //   284: iload_3
    //   285: istore 6
    //   287: iload_3
    //   288: istore 7
    //   290: aload_0
    //   291: aload 11
    //   293: putfield 64	com/tencent/luggage/wxa/aq/a$b:j	Ljava/lang/Object;
    //   296: goto -278 -> 18
    //   299: iload_3
    //   300: istore 5
    //   302: iload_3
    //   303: istore 6
    //   305: iload_3
    //   306: istore 7
    //   308: aload_1
    //   309: invokevirtual 94	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   312: astore 11
    //   314: iload_3
    //   315: istore 5
    //   317: iload_3
    //   318: istore 6
    //   320: iload_3
    //   321: istore 7
    //   323: aload_0
    //   324: aload_0
    //   325: getfield 85	com/tencent/luggage/wxa/aq/a$b:b	I
    //   328: bipush 32
    //   330: ior
    //   331: putfield 85	com/tencent/luggage/wxa/aq/a$b:b	I
    //   334: iload_3
    //   335: istore 5
    //   337: iload_3
    //   338: istore 6
    //   340: iload_3
    //   341: istore 7
    //   343: aload_0
    //   344: aload 11
    //   346: putfield 62	com/tencent/luggage/wxa/aq/a$b:i	Ljava/lang/Object;
    //   349: goto -331 -> 18
    //   352: iload_3
    //   353: istore 5
    //   355: iload_3
    //   356: istore 6
    //   358: iload_3
    //   359: istore 7
    //   361: aload_0
    //   362: aload_0
    //   363: getfield 85	com/tencent/luggage/wxa/aq/a$b:b	I
    //   366: bipush 16
    //   368: ior
    //   369: putfield 85	com/tencent/luggage/wxa/aq/a$b:b	I
    //   372: iload_3
    //   373: istore 5
    //   375: iload_3
    //   376: istore 6
    //   378: iload_3
    //   379: istore 7
    //   381: aload_0
    //   382: aload_1
    //   383: invokevirtual 97	com/google/protobuf/CodedInputStream:d	()J
    //   386: putfield 99	com/tencent/luggage/wxa/aq/a$b:h	J
    //   389: goto -371 -> 18
    //   392: iload_3
    //   393: istore 5
    //   395: iload_3
    //   396: istore 6
    //   398: iload_3
    //   399: istore 7
    //   401: aload_1
    //   402: invokevirtual 94	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   405: astore 11
    //   407: iload_3
    //   408: istore 5
    //   410: iload_3
    //   411: istore 6
    //   413: iload_3
    //   414: istore 7
    //   416: aload_0
    //   417: aload_0
    //   418: getfield 85	com/tencent/luggage/wxa/aq/a$b:b	I
    //   421: bipush 8
    //   423: ior
    //   424: putfield 85	com/tencent/luggage/wxa/aq/a$b:b	I
    //   427: iload_3
    //   428: istore 5
    //   430: iload_3
    //   431: istore 6
    //   433: iload_3
    //   434: istore 7
    //   436: aload_0
    //   437: aload 11
    //   439: putfield 60	com/tencent/luggage/wxa/aq/a$b:g	Ljava/lang/Object;
    //   442: goto -424 -> 18
    //   445: iload_3
    //   446: istore 5
    //   448: iload_3
    //   449: istore 6
    //   451: iload_3
    //   452: istore 7
    //   454: aload_1
    //   455: invokevirtual 94	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   458: astore 11
    //   460: iload_3
    //   461: istore 5
    //   463: iload_3
    //   464: istore 6
    //   466: iload_3
    //   467: istore 7
    //   469: aload_0
    //   470: aload_0
    //   471: getfield 85	com/tencent/luggage/wxa/aq/a$b:b	I
    //   474: iconst_4
    //   475: ior
    //   476: putfield 85	com/tencent/luggage/wxa/aq/a$b:b	I
    //   479: iload_3
    //   480: istore 5
    //   482: iload_3
    //   483: istore 6
    //   485: iload_3
    //   486: istore 7
    //   488: aload_0
    //   489: aload 11
    //   491: putfield 58	com/tencent/luggage/wxa/aq/a$b:f	Ljava/lang/Object;
    //   494: goto -476 -> 18
    //   497: iload_3
    //   498: istore 5
    //   500: iload_3
    //   501: istore 6
    //   503: iload_3
    //   504: istore 7
    //   506: aload_0
    //   507: aload_0
    //   508: getfield 85	com/tencent/luggage/wxa/aq/a$b:b	I
    //   511: iconst_2
    //   512: ior
    //   513: putfield 85	com/tencent/luggage/wxa/aq/a$b:b	I
    //   516: iload_3
    //   517: istore 5
    //   519: iload_3
    //   520: istore 6
    //   522: iload_3
    //   523: istore 7
    //   525: aload_0
    //   526: aload_1
    //   527: invokevirtual 102	com/google/protobuf/CodedInputStream:i	()Z
    //   530: putfield 104	com/tencent/luggage/wxa/aq/a$b:e	Z
    //   533: goto -515 -> 18
    //   536: iload_3
    //   537: istore 5
    //   539: iload_3
    //   540: istore 6
    //   542: iload_3
    //   543: istore 7
    //   545: aload_1
    //   546: invokevirtual 94	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   549: astore 11
    //   551: iload_3
    //   552: istore 4
    //   554: iload_3
    //   555: iconst_2
    //   556: iand
    //   557: ifne +28 -> 585
    //   560: iload_3
    //   561: istore 5
    //   563: iload_3
    //   564: istore 6
    //   566: iload_3
    //   567: istore 7
    //   569: aload_0
    //   570: new 52	com/google/protobuf/LazyStringArrayList
    //   573: dup
    //   574: invokespecial 105	com/google/protobuf/LazyStringArrayList:<init>	()V
    //   577: putfield 56	com/tencent/luggage/wxa/aq/a$b:d	Lcom/google/protobuf/LazyStringList;
    //   580: iload_3
    //   581: iconst_2
    //   582: ior
    //   583: istore 4
    //   585: iload 4
    //   587: istore 5
    //   589: iload 4
    //   591: istore 6
    //   593: iload 4
    //   595: istore 7
    //   597: aload_0
    //   598: getfield 56	com/tencent/luggage/wxa/aq/a$b:d	Lcom/google/protobuf/LazyStringList;
    //   601: aload 11
    //   603: invokeinterface 110 2 0
    //   608: iload 4
    //   610: istore_3
    //   611: goto -593 -> 18
    //   614: iload_3
    //   615: istore 5
    //   617: iload_3
    //   618: istore 6
    //   620: iload_3
    //   621: istore 7
    //   623: aload_1
    //   624: invokevirtual 94	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   627: astore 11
    //   629: iload_3
    //   630: istore 5
    //   632: iload_3
    //   633: istore 6
    //   635: iload_3
    //   636: istore 7
    //   638: aload_0
    //   639: iconst_1
    //   640: aload_0
    //   641: getfield 85	com/tencent/luggage/wxa/aq/a$b:b	I
    //   644: ior
    //   645: putfield 85	com/tencent/luggage/wxa/aq/a$b:b	I
    //   648: iload_3
    //   649: istore 5
    //   651: iload_3
    //   652: istore 6
    //   654: iload_3
    //   655: istore 7
    //   657: aload_0
    //   658: aload 11
    //   660: putfield 50	com/tencent/luggage/wxa/aq/a$b:c	Ljava/lang/Object;
    //   663: goto -645 -> 18
    //   666: iconst_1
    //   667: istore 8
    //   669: goto -651 -> 18
    //   672: iload 9
    //   674: ifne -656 -> 18
    //   677: goto -11 -> 666
    //   680: astore_1
    //   681: goto +32 -> 713
    //   684: astore_1
    //   685: iload 6
    //   687: istore 5
    //   689: new 67	com/google/protobuf/InvalidProtocolBufferException
    //   692: dup
    //   693: aload_1
    //   694: invokespecial 113	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/io/IOException;)V
    //   697: aload_0
    //   698: invokevirtual 117	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   701: athrow
    //   702: astore_1
    //   703: iload 7
    //   705: istore 5
    //   707: aload_1
    //   708: aload_0
    //   709: invokevirtual 117	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   712: athrow
    //   713: iload 5
    //   715: iconst_2
    //   716: iand
    //   717: ifeq +16 -> 733
    //   720: aload_0
    //   721: aload_0
    //   722: getfield 56	com/tencent/luggage/wxa/aq/a$b:d	Lcom/google/protobuf/LazyStringList;
    //   725: invokeinterface 120 1 0
    //   730: putfield 56	com/tencent/luggage/wxa/aq/a$b:d	Lcom/google/protobuf/LazyStringList;
    //   733: aload_0
    //   734: aload 10
    //   736: invokevirtual 125	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   739: putfield 129	com/tencent/luggage/wxa/aq/a$b:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   742: aload_0
    //   743: invokevirtual 132	com/tencent/luggage/wxa/aq/a$b:makeExtensionsImmutable	()V
    //   746: aload_1
    //   747: athrow
    //   748: iload_3
    //   749: iconst_2
    //   750: iand
    //   751: ifeq +16 -> 767
    //   754: aload_0
    //   755: aload_0
    //   756: getfield 56	com/tencent/luggage/wxa/aq/a$b:d	Lcom/google/protobuf/LazyStringList;
    //   759: invokeinterface 120 1 0
    //   764: putfield 56	com/tencent/luggage/wxa/aq/a$b:d	Lcom/google/protobuf/LazyStringList;
    //   767: aload_0
    //   768: aload 10
    //   770: invokevirtual 125	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   773: putfield 129	com/tencent/luggage/wxa/aq/a$b:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   776: aload_0
    //   777: invokevirtual 132	com/tencent/luggage/wxa/aq/a$b:makeExtensionsImmutable	()V
    //   780: return
    //   781: new 134	java/lang/NullPointerException
    //   784: dup
    //   785: invokespecial 135	java/lang/NullPointerException:<init>	()V
    //   788: astore_1
    //   789: goto +5 -> 794
    //   792: aload_1
    //   793: athrow
    //   794: goto -2 -> 792
    //   797: goto -657 -> 140
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	800	0	this	b
    //   0	800	1	paramCodedInputStream	com.google.protobuf.CodedInputStream
    //   0	800	2	paramExtensionRegistryLite	com.google.protobuf.ExtensionRegistryLite
    //   17	734	3	i1	int
    //   36	573	4	i2	int
    //   24	693	5	i3	int
    //   27	659	6	i4	int
    //   30	674	7	i5	int
    //   14	654	8	i6	int
    //   159	514	9	bool	boolean
    //   11	758	10	localBuilder	com.google.protobuf.UnknownFieldSet.Builder
    //   259	400	11	localByteString	ByteString
    // Exception table:
    //   from	to	target	type
    //   32	38	680	finally
    //   149	161	680	finally
    //   173	185	680	finally
    //   194	202	680	finally
    //   214	226	680	finally
    //   235	243	680	finally
    //   255	261	680	finally
    //   270	281	680	finally
    //   290	296	680	finally
    //   308	314	680	finally
    //   323	334	680	finally
    //   343	349	680	finally
    //   361	372	680	finally
    //   381	389	680	finally
    //   401	407	680	finally
    //   416	427	680	finally
    //   436	442	680	finally
    //   454	460	680	finally
    //   469	479	680	finally
    //   488	494	680	finally
    //   506	516	680	finally
    //   525	533	680	finally
    //   545	551	680	finally
    //   569	580	680	finally
    //   597	608	680	finally
    //   623	629	680	finally
    //   638	648	680	finally
    //   657	663	680	finally
    //   689	702	680	finally
    //   707	713	680	finally
    //   32	38	684	java/io/IOException
    //   149	161	684	java/io/IOException
    //   173	185	684	java/io/IOException
    //   194	202	684	java/io/IOException
    //   214	226	684	java/io/IOException
    //   235	243	684	java/io/IOException
    //   255	261	684	java/io/IOException
    //   270	281	684	java/io/IOException
    //   290	296	684	java/io/IOException
    //   308	314	684	java/io/IOException
    //   323	334	684	java/io/IOException
    //   343	349	684	java/io/IOException
    //   361	372	684	java/io/IOException
    //   381	389	684	java/io/IOException
    //   401	407	684	java/io/IOException
    //   416	427	684	java/io/IOException
    //   436	442	684	java/io/IOException
    //   454	460	684	java/io/IOException
    //   469	479	684	java/io/IOException
    //   488	494	684	java/io/IOException
    //   506	516	684	java/io/IOException
    //   525	533	684	java/io/IOException
    //   545	551	684	java/io/IOException
    //   569	580	684	java/io/IOException
    //   597	608	684	java/io/IOException
    //   623	629	684	java/io/IOException
    //   638	648	684	java/io/IOException
    //   657	663	684	java/io/IOException
    //   32	38	702	com/google/protobuf/InvalidProtocolBufferException
    //   149	161	702	com/google/protobuf/InvalidProtocolBufferException
    //   173	185	702	com/google/protobuf/InvalidProtocolBufferException
    //   194	202	702	com/google/protobuf/InvalidProtocolBufferException
    //   214	226	702	com/google/protobuf/InvalidProtocolBufferException
    //   235	243	702	com/google/protobuf/InvalidProtocolBufferException
    //   255	261	702	com/google/protobuf/InvalidProtocolBufferException
    //   270	281	702	com/google/protobuf/InvalidProtocolBufferException
    //   290	296	702	com/google/protobuf/InvalidProtocolBufferException
    //   308	314	702	com/google/protobuf/InvalidProtocolBufferException
    //   323	334	702	com/google/protobuf/InvalidProtocolBufferException
    //   343	349	702	com/google/protobuf/InvalidProtocolBufferException
    //   361	372	702	com/google/protobuf/InvalidProtocolBufferException
    //   381	389	702	com/google/protobuf/InvalidProtocolBufferException
    //   401	407	702	com/google/protobuf/InvalidProtocolBufferException
    //   416	427	702	com/google/protobuf/InvalidProtocolBufferException
    //   436	442	702	com/google/protobuf/InvalidProtocolBufferException
    //   454	460	702	com/google/protobuf/InvalidProtocolBufferException
    //   469	479	702	com/google/protobuf/InvalidProtocolBufferException
    //   488	494	702	com/google/protobuf/InvalidProtocolBufferException
    //   506	516	702	com/google/protobuf/InvalidProtocolBufferException
    //   525	533	702	com/google/protobuf/InvalidProtocolBufferException
    //   545	551	702	com/google/protobuf/InvalidProtocolBufferException
    //   569	580	702	com/google/protobuf/InvalidProtocolBufferException
    //   597	608	702	com/google/protobuf/InvalidProtocolBufferException
    //   623	629	702	com/google/protobuf/InvalidProtocolBufferException
    //   638	648	702	com/google/protobuf/InvalidProtocolBufferException
    //   657	663	702	com/google/protobuf/InvalidProtocolBufferException
  }
  
  private a$b(GeneratedMessageV3.Builder<?> paramBuilder)
  {
    super(paramBuilder);
  }
  
  public static final Descriptors.Descriptor a()
  {
    return a.f();
  }
  
  public static a.b.a w()
  {
    return n.x();
  }
  
  public static b y()
  {
    return n;
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
  
  public ProtocolStringList d()
  {
    return this.d;
  }
  
  public int e()
  {
    return this.d.size();
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
    if (!d().equals(paramObject.d())) {
      return false;
    }
    if (f() != paramObject.f()) {
      return false;
    }
    if ((f()) && (g() != paramObject.g())) {
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
    if (r() != paramObject.r()) {
      return false;
    }
    if ((r()) && (s() != paramObject.s())) {
      return false;
    }
    if (t() != paramObject.t()) {
      return false;
    }
    if ((t()) && (u() != paramObject.u())) {
      return false;
    }
    return this.unknownFields.equals(paramObject.unknownFields);
  }
  
  public boolean f()
  {
    return (this.b & 0x2) != 0;
  }
  
  public boolean g()
  {
    return this.e;
  }
  
  public Parser<b> getParserForType()
  {
    return a;
  }
  
  public int getSerializedSize()
  {
    int i1 = this.memoizedSize;
    if (i1 != -1) {
      return i1;
    }
    i1 = this.b;
    int i2 = 0;
    if ((i1 & 0x1) != 0) {
      i1 = GeneratedMessageV3.computeStringSize(1, this.c) + 0;
    } else {
      i1 = 0;
    }
    int i3 = 0;
    while (i2 < this.d.size())
    {
      i3 += computeStringSizeNoTag(this.d.d(i2));
      i2 += 1;
    }
    i2 = i1 + i3 + d().size() * 1;
    i1 = i2;
    if ((this.b & 0x2) != 0) {
      i1 = i2 + CodedOutputStream.b(3, this.e);
    }
    i2 = i1;
    if ((this.b & 0x4) != 0) {
      i2 = i1 + GeneratedMessageV3.computeStringSize(4, this.f);
    }
    i1 = i2;
    if ((this.b & 0x8) != 0) {
      i1 = i2 + GeneratedMessageV3.computeStringSize(5, this.g);
    }
    i2 = i1;
    if ((this.b & 0x10) != 0) {
      i2 = i1 + CodedOutputStream.g(6, this.h);
    }
    i1 = i2;
    if ((this.b & 0x20) != 0) {
      i1 = i2 + GeneratedMessageV3.computeStringSize(7, this.i);
    }
    i2 = i1;
    if ((this.b & 0x40) != 0) {
      i2 = i1 + GeneratedMessageV3.computeStringSize(8, this.j);
    }
    i1 = i2;
    if ((this.b & 0x80) != 0) {
      i1 = i2 + CodedOutputStream.i(9, this.k);
    }
    i2 = i1;
    if ((this.b & 0x100) != 0) {
      i2 = i1 + CodedOutputStream.i(10, this.l);
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
    return (this.b & 0x4) != 0;
  }
  
  public int hashCode()
  {
    if (this.memoizedHashCode != 0) {
      return this.memoizedHashCode;
    }
    int i2 = 779 + a().hashCode();
    int i1 = i2;
    if (b()) {
      i1 = (i2 * 37 + 1) * 53 + c().hashCode();
    }
    i2 = i1;
    if (e() > 0) {
      i2 = (i1 * 37 + 2) * 53 + d().hashCode();
    }
    i1 = i2;
    if (f()) {
      i1 = (i2 * 37 + 3) * 53 + Internal.a(g());
    }
    i2 = i1;
    if (h()) {
      i2 = (i1 * 37 + 4) * 53 + i().hashCode();
    }
    i1 = i2;
    if (j()) {
      i1 = (i2 * 37 + 5) * 53 + k().hashCode();
    }
    i2 = i1;
    if (l()) {
      i2 = (i1 * 37 + 6) * 53 + Internal.a(m());
    }
    i1 = i2;
    if (n()) {
      i1 = (i2 * 37 + 7) * 53 + o().hashCode();
    }
    i2 = i1;
    if (p()) {
      i2 = (i1 * 37 + 8) * 53 + q().hashCode();
    }
    i1 = i2;
    if (r()) {
      i1 = (i2 * 37 + 9) * 53 + s();
    }
    i2 = i1;
    if (t()) {
      i2 = (i1 * 37 + 10) * 53 + u();
    }
    i1 = i2 * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i1;
    return i1;
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
    return a.g().a(b.class, a.b.a.class);
  }
  
  public final boolean isInitialized()
  {
    int i1 = this.m;
    if (i1 == 1) {
      return true;
    }
    if (i1 == 0) {
      return false;
    }
    this.m = 1;
    return true;
  }
  
  public boolean j()
  {
    return (this.b & 0x8) != 0;
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
    return (this.b & 0x10) != 0;
  }
  
  public long m()
  {
    return this.h;
  }
  
  public boolean n()
  {
    return (this.b & 0x20) != 0;
  }
  
  protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter paramUnusedPrivateParameter)
  {
    return new b();
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
  
  public boolean r()
  {
    return (this.b & 0x80) != 0;
  }
  
  public int s()
  {
    return this.k;
  }
  
  public boolean t()
  {
    return (this.b & 0x100) != 0;
  }
  
  public int u()
  {
    return this.l;
  }
  
  public a.b.a v()
  {
    return w();
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
  {
    if ((this.b & 0x1) != 0) {
      GeneratedMessageV3.writeString(paramCodedOutputStream, 1, this.c);
    }
    int i1 = 0;
    while (i1 < this.d.size())
    {
      GeneratedMessageV3.writeString(paramCodedOutputStream, 2, this.d.d(i1));
      i1 += 1;
    }
    if ((this.b & 0x2) != 0) {
      paramCodedOutputStream.a(3, this.e);
    }
    if ((this.b & 0x4) != 0) {
      GeneratedMessageV3.writeString(paramCodedOutputStream, 4, this.f);
    }
    if ((this.b & 0x8) != 0) {
      GeneratedMessageV3.writeString(paramCodedOutputStream, 5, this.g);
    }
    if ((this.b & 0x10) != 0) {
      paramCodedOutputStream.b(6, this.h);
    }
    if ((this.b & 0x20) != 0) {
      GeneratedMessageV3.writeString(paramCodedOutputStream, 7, this.i);
    }
    if ((this.b & 0x40) != 0) {
      GeneratedMessageV3.writeString(paramCodedOutputStream, 8, this.j);
    }
    if ((this.b & 0x80) != 0) {
      paramCodedOutputStream.c(9, this.k);
    }
    if ((this.b & 0x100) != 0) {
      paramCodedOutputStream.c(10, this.l);
    }
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
  
  public a.b.a x()
  {
    if (this == n) {
      return new a.b.a(null);
    }
    return new a.b.a(null).a(this);
  }
  
  public b z()
  {
    return n;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.aq.a.b
 * JD-Core Version:    0.7.0.1
 */