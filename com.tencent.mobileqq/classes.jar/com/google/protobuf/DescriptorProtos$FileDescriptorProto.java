package com.google.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

public final class DescriptorProtos$FileDescriptorProto
  extends GeneratedMessageV3
  implements DescriptorProtos.FileDescriptorProtoOrBuilder
{
  public static final int DEPENDENCY_FIELD_NUMBER = 3;
  public static final int ENUM_TYPE_FIELD_NUMBER = 5;
  public static final int EXTENSION_FIELD_NUMBER = 7;
  public static final int MESSAGE_TYPE_FIELD_NUMBER = 4;
  public static final int NAME_FIELD_NUMBER = 1;
  public static final int OPTIONS_FIELD_NUMBER = 8;
  public static final int PACKAGE_FIELD_NUMBER = 2;
  @Deprecated
  public static final Parser<FileDescriptorProto> PARSER = new DescriptorProtos.FileDescriptorProto.1();
  public static final int PUBLIC_DEPENDENCY_FIELD_NUMBER = 10;
  public static final int SERVICE_FIELD_NUMBER = 6;
  public static final int SOURCE_CODE_INFO_FIELD_NUMBER = 9;
  public static final int SYNTAX_FIELD_NUMBER = 12;
  public static final int WEAK_DEPENDENCY_FIELD_NUMBER = 11;
  private static final FileDescriptorProto a = new FileDescriptorProto();
  private static final long serialVersionUID = 0L;
  private int bitField0_;
  private LazyStringList dependency_;
  private List<DescriptorProtos.EnumDescriptorProto> enumType_;
  private List<DescriptorProtos.FieldDescriptorProto> extension_;
  private byte memoizedIsInitialized = -1;
  private List<DescriptorProtos.DescriptorProto> messageType_;
  private volatile Object name_;
  private DescriptorProtos.FileOptions options_;
  private volatile Object package_;
  private Internal.IntList publicDependency_;
  private List<DescriptorProtos.ServiceDescriptorProto> service_;
  private DescriptorProtos.SourceCodeInfo sourceCodeInfo_;
  private volatile Object syntax_;
  private Internal.IntList weakDependency_;
  
  private DescriptorProtos$FileDescriptorProto()
  {
    this.name_ = "";
    this.package_ = "";
    this.dependency_ = LazyStringArrayList.a;
    this.publicDependency_ = emptyIntList();
    this.weakDependency_ = emptyIntList();
    this.messageType_ = Collections.emptyList();
    this.enumType_ = Collections.emptyList();
    this.service_ = Collections.emptyList();
    this.extension_ = Collections.emptyList();
    this.syntax_ = "";
  }
  
  /* Error */
  private DescriptorProtos$FileDescriptorProto(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 71	com/google/protobuf/DescriptorProtos$FileDescriptorProto:<init>	()V
    //   4: aload_2
    //   5: ifnull +1717 -> 1722
    //   8: invokestatic 128	com/google/protobuf/UnknownFieldSet:a	()Lcom/google/protobuf/UnknownFieldSet$Builder;
    //   11: astore 13
    //   13: iconst_0
    //   14: istore 8
    //   16: iconst_0
    //   17: istore_3
    //   18: iload 8
    //   20: ifne +1563 -> 1583
    //   23: iload_3
    //   24: istore 4
    //   26: iload_3
    //   27: istore 5
    //   29: iload_3
    //   30: istore 6
    //   32: aload_1
    //   33: invokevirtual 133	com/google/protobuf/CodedInputStream:a	()I
    //   36: istore 7
    //   38: aconst_null
    //   39: astore 12
    //   41: aconst_null
    //   42: astore 11
    //   44: iload 7
    //   46: lookupswitch	default:+1692->1738, 0:+1343->1389, 10:+1291->1337, 18:+1239->1285, 26:+1161->1207, 34:+1089->1135, 42:+1017->1063, 50:+943->989, 58:+869->915, 66:+741->787, 74:+615->661, 80:+552->598, 82:+411->457, 88:+348->394, 90:+207->253, 98:+154->200
    //   177: istore 4
    //   179: iload_3
    //   180: istore 5
    //   182: iload_3
    //   183: istore 6
    //   185: aload_0
    //   186: aload_1
    //   187: aload 13
    //   189: aload_2
    //   190: iload 7
    //   192: invokevirtual 137	com/google/protobuf/DescriptorProtos$FileDescriptorProto:parseUnknownField	(Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/UnknownFieldSet$Builder;Lcom/google/protobuf/ExtensionRegistryLite;I)Z
    //   195: istore 10
    //   197: goto +1198 -> 1395
    //   200: iload_3
    //   201: istore 4
    //   203: iload_3
    //   204: istore 5
    //   206: iload_3
    //   207: istore 6
    //   209: aload_1
    //   210: invokevirtual 141	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   213: astore 11
    //   215: iload_3
    //   216: istore 4
    //   218: iload_3
    //   219: istore 5
    //   221: iload_3
    //   222: istore 6
    //   224: aload_0
    //   225: aload_0
    //   226: getfield 143	com/google/protobuf/DescriptorProtos$FileDescriptorProto:bitField0_	I
    //   229: bipush 16
    //   231: ior
    //   232: putfield 143	com/google/protobuf/DescriptorProtos$FileDescriptorProto:bitField0_	I
    //   235: iload_3
    //   236: istore 4
    //   238: iload_3
    //   239: istore 5
    //   241: iload_3
    //   242: istore 6
    //   244: aload_0
    //   245: aload 11
    //   247: putfield 118	com/google/protobuf/DescriptorProtos$FileDescriptorProto:syntax_	Ljava/lang/Object;
    //   250: goto -232 -> 18
    //   253: iload_3
    //   254: istore 4
    //   256: iload_3
    //   257: istore 5
    //   259: iload_3
    //   260: istore 6
    //   262: aload_1
    //   263: aload_1
    //   264: invokevirtual 146	com/google/protobuf/CodedInputStream:s	()I
    //   267: invokevirtual 150	com/google/protobuf/CodedInputStream:c	(I)I
    //   270: istore 9
    //   272: iload_3
    //   273: istore 7
    //   275: iload_3
    //   276: bipush 16
    //   278: iand
    //   279: ifne +44 -> 323
    //   282: iload_3
    //   283: istore 7
    //   285: iload_3
    //   286: istore 4
    //   288: iload_3
    //   289: istore 5
    //   291: iload_3
    //   292: istore 6
    //   294: aload_1
    //   295: invokevirtual 153	com/google/protobuf/CodedInputStream:x	()I
    //   298: ifle +25 -> 323
    //   301: iload_3
    //   302: istore 4
    //   304: iload_3
    //   305: istore 5
    //   307: iload_3
    //   308: istore 6
    //   310: aload_0
    //   311: invokestatic 156	com/google/protobuf/DescriptorProtos$FileDescriptorProto:newIntList	()Lcom/google/protobuf/Internal$IntList;
    //   314: putfield 102	com/google/protobuf/DescriptorProtos$FileDescriptorProto:weakDependency_	Lcom/google/protobuf/Internal$IntList;
    //   317: iload_3
    //   318: bipush 16
    //   320: ior
    //   321: istore 7
    //   323: iload 7
    //   325: istore 4
    //   327: iload 7
    //   329: istore 5
    //   331: iload 7
    //   333: istore 6
    //   335: aload_1
    //   336: invokevirtual 153	com/google/protobuf/CodedInputStream:x	()I
    //   339: ifle +31 -> 370
    //   342: iload 7
    //   344: istore 4
    //   346: iload 7
    //   348: istore 5
    //   350: iload 7
    //   352: istore 6
    //   354: aload_0
    //   355: getfield 102	com/google/protobuf/DescriptorProtos$FileDescriptorProto:weakDependency_	Lcom/google/protobuf/Internal$IntList;
    //   358: aload_1
    //   359: invokevirtual 159	com/google/protobuf/CodedInputStream:f	()I
    //   362: invokeinterface 165 2 0
    //   367: goto -44 -> 323
    //   370: iload 7
    //   372: istore 4
    //   374: iload 7
    //   376: istore 5
    //   378: iload 7
    //   380: istore 6
    //   382: aload_1
    //   383: iload 9
    //   385: invokevirtual 166	com/google/protobuf/CodedInputStream:d	(I)V
    //   388: iload 7
    //   390: istore_3
    //   391: goto -373 -> 18
    //   394: iload_3
    //   395: istore 7
    //   397: iload_3
    //   398: bipush 16
    //   400: iand
    //   401: ifne +25 -> 426
    //   404: iload_3
    //   405: istore 4
    //   407: iload_3
    //   408: istore 5
    //   410: iload_3
    //   411: istore 6
    //   413: aload_0
    //   414: invokestatic 156	com/google/protobuf/DescriptorProtos$FileDescriptorProto:newIntList	()Lcom/google/protobuf/Internal$IntList;
    //   417: putfield 102	com/google/protobuf/DescriptorProtos$FileDescriptorProto:weakDependency_	Lcom/google/protobuf/Internal$IntList;
    //   420: iload_3
    //   421: bipush 16
    //   423: ior
    //   424: istore 7
    //   426: iload 7
    //   428: istore 4
    //   430: iload 7
    //   432: istore 5
    //   434: iload 7
    //   436: istore 6
    //   438: aload_0
    //   439: getfield 102	com/google/protobuf/DescriptorProtos$FileDescriptorProto:weakDependency_	Lcom/google/protobuf/Internal$IntList;
    //   442: aload_1
    //   443: invokevirtual 159	com/google/protobuf/CodedInputStream:f	()I
    //   446: invokeinterface 165 2 0
    //   451: iload 7
    //   453: istore_3
    //   454: goto -436 -> 18
    //   457: iload_3
    //   458: istore 4
    //   460: iload_3
    //   461: istore 5
    //   463: iload_3
    //   464: istore 6
    //   466: aload_1
    //   467: aload_1
    //   468: invokevirtual 146	com/google/protobuf/CodedInputStream:s	()I
    //   471: invokevirtual 150	com/google/protobuf/CodedInputStream:c	(I)I
    //   474: istore 9
    //   476: iload_3
    //   477: istore 7
    //   479: iload_3
    //   480: bipush 8
    //   482: iand
    //   483: ifne +44 -> 527
    //   486: iload_3
    //   487: istore 7
    //   489: iload_3
    //   490: istore 4
    //   492: iload_3
    //   493: istore 5
    //   495: iload_3
    //   496: istore 6
    //   498: aload_1
    //   499: invokevirtual 153	com/google/protobuf/CodedInputStream:x	()I
    //   502: ifle +25 -> 527
    //   505: iload_3
    //   506: istore 4
    //   508: iload_3
    //   509: istore 5
    //   511: iload_3
    //   512: istore 6
    //   514: aload_0
    //   515: invokestatic 156	com/google/protobuf/DescriptorProtos$FileDescriptorProto:newIntList	()Lcom/google/protobuf/Internal$IntList;
    //   518: putfield 100	com/google/protobuf/DescriptorProtos$FileDescriptorProto:publicDependency_	Lcom/google/protobuf/Internal$IntList;
    //   521: iload_3
    //   522: bipush 8
    //   524: ior
    //   525: istore 7
    //   527: iload 7
    //   529: istore 4
    //   531: iload 7
    //   533: istore 5
    //   535: iload 7
    //   537: istore 6
    //   539: aload_1
    //   540: invokevirtual 153	com/google/protobuf/CodedInputStream:x	()I
    //   543: ifle +31 -> 574
    //   546: iload 7
    //   548: istore 4
    //   550: iload 7
    //   552: istore 5
    //   554: iload 7
    //   556: istore 6
    //   558: aload_0
    //   559: getfield 100	com/google/protobuf/DescriptorProtos$FileDescriptorProto:publicDependency_	Lcom/google/protobuf/Internal$IntList;
    //   562: aload_1
    //   563: invokevirtual 159	com/google/protobuf/CodedInputStream:f	()I
    //   566: invokeinterface 165 2 0
    //   571: goto -44 -> 527
    //   574: iload 7
    //   576: istore 4
    //   578: iload 7
    //   580: istore 5
    //   582: iload 7
    //   584: istore 6
    //   586: aload_1
    //   587: iload 9
    //   589: invokevirtual 166	com/google/protobuf/CodedInputStream:d	(I)V
    //   592: iload 7
    //   594: istore_3
    //   595: goto -577 -> 18
    //   598: iload_3
    //   599: istore 7
    //   601: iload_3
    //   602: bipush 8
    //   604: iand
    //   605: ifne +25 -> 630
    //   608: iload_3
    //   609: istore 4
    //   611: iload_3
    //   612: istore 5
    //   614: iload_3
    //   615: istore 6
    //   617: aload_0
    //   618: invokestatic 156	com/google/protobuf/DescriptorProtos$FileDescriptorProto:newIntList	()Lcom/google/protobuf/Internal$IntList;
    //   621: putfield 100	com/google/protobuf/DescriptorProtos$FileDescriptorProto:publicDependency_	Lcom/google/protobuf/Internal$IntList;
    //   624: iload_3
    //   625: bipush 8
    //   627: ior
    //   628: istore 7
    //   630: iload 7
    //   632: istore 4
    //   634: iload 7
    //   636: istore 5
    //   638: iload 7
    //   640: istore 6
    //   642: aload_0
    //   643: getfield 100	com/google/protobuf/DescriptorProtos$FileDescriptorProto:publicDependency_	Lcom/google/protobuf/Internal$IntList;
    //   646: aload_1
    //   647: invokevirtual 159	com/google/protobuf/CodedInputStream:f	()I
    //   650: invokeinterface 165 2 0
    //   655: iload 7
    //   657: istore_3
    //   658: goto -640 -> 18
    //   661: iload_3
    //   662: istore 4
    //   664: iload_3
    //   665: istore 5
    //   667: iload_3
    //   668: istore 6
    //   670: aload_0
    //   671: getfield 143	com/google/protobuf/DescriptorProtos$FileDescriptorProto:bitField0_	I
    //   674: bipush 8
    //   676: iand
    //   677: ifeq +21 -> 698
    //   680: iload_3
    //   681: istore 4
    //   683: iload_3
    //   684: istore 5
    //   686: iload_3
    //   687: istore 6
    //   689: aload_0
    //   690: getfield 168	com/google/protobuf/DescriptorProtos$FileDescriptorProto:sourceCodeInfo_	Lcom/google/protobuf/DescriptorProtos$SourceCodeInfo;
    //   693: invokevirtual 174	com/google/protobuf/DescriptorProtos$SourceCodeInfo:toBuilder	()Lcom/google/protobuf/DescriptorProtos$SourceCodeInfo$Builder;
    //   696: astore 11
    //   698: iload_3
    //   699: istore 4
    //   701: iload_3
    //   702: istore 5
    //   704: iload_3
    //   705: istore 6
    //   707: aload_0
    //   708: aload_1
    //   709: getstatic 175	com/google/protobuf/DescriptorProtos$SourceCodeInfo:PARSER	Lcom/google/protobuf/Parser;
    //   712: aload_2
    //   713: invokevirtual 178	com/google/protobuf/CodedInputStream:a	(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   716: checkcast 170	com/google/protobuf/DescriptorProtos$SourceCodeInfo
    //   719: putfield 168	com/google/protobuf/DescriptorProtos$FileDescriptorProto:sourceCodeInfo_	Lcom/google/protobuf/DescriptorProtos$SourceCodeInfo;
    //   722: aload 11
    //   724: ifnull +40 -> 764
    //   727: iload_3
    //   728: istore 4
    //   730: iload_3
    //   731: istore 5
    //   733: iload_3
    //   734: istore 6
    //   736: aload 11
    //   738: aload_0
    //   739: getfield 168	com/google/protobuf/DescriptorProtos$FileDescriptorProto:sourceCodeInfo_	Lcom/google/protobuf/DescriptorProtos$SourceCodeInfo;
    //   742: invokevirtual 183	com/google/protobuf/DescriptorProtos$SourceCodeInfo$Builder:a	(Lcom/google/protobuf/DescriptorProtos$SourceCodeInfo;)Lcom/google/protobuf/DescriptorProtos$SourceCodeInfo$Builder;
    //   745: pop
    //   746: iload_3
    //   747: istore 4
    //   749: iload_3
    //   750: istore 5
    //   752: iload_3
    //   753: istore 6
    //   755: aload_0
    //   756: aload 11
    //   758: invokevirtual 186	com/google/protobuf/DescriptorProtos$SourceCodeInfo$Builder:d	()Lcom/google/protobuf/DescriptorProtos$SourceCodeInfo;
    //   761: putfield 168	com/google/protobuf/DescriptorProtos$FileDescriptorProto:sourceCodeInfo_	Lcom/google/protobuf/DescriptorProtos$SourceCodeInfo;
    //   764: iload_3
    //   765: istore 4
    //   767: iload_3
    //   768: istore 5
    //   770: iload_3
    //   771: istore 6
    //   773: aload_0
    //   774: aload_0
    //   775: getfield 143	com/google/protobuf/DescriptorProtos$FileDescriptorProto:bitField0_	I
    //   778: bipush 8
    //   780: ior
    //   781: putfield 143	com/google/protobuf/DescriptorProtos$FileDescriptorProto:bitField0_	I
    //   784: goto -766 -> 18
    //   787: aload 12
    //   789: astore 11
    //   791: iload_3
    //   792: istore 4
    //   794: iload_3
    //   795: istore 5
    //   797: iload_3
    //   798: istore 6
    //   800: aload_0
    //   801: getfield 143	com/google/protobuf/DescriptorProtos$FileDescriptorProto:bitField0_	I
    //   804: iconst_4
    //   805: iand
    //   806: ifeq +21 -> 827
    //   809: iload_3
    //   810: istore 4
    //   812: iload_3
    //   813: istore 5
    //   815: iload_3
    //   816: istore 6
    //   818: aload_0
    //   819: getfield 188	com/google/protobuf/DescriptorProtos$FileDescriptorProto:options_	Lcom/google/protobuf/DescriptorProtos$FileOptions;
    //   822: invokevirtual 193	com/google/protobuf/DescriptorProtos$FileOptions:toBuilder	()Lcom/google/protobuf/DescriptorProtos$FileOptions$Builder;
    //   825: astore 11
    //   827: iload_3
    //   828: istore 4
    //   830: iload_3
    //   831: istore 5
    //   833: iload_3
    //   834: istore 6
    //   836: aload_0
    //   837: aload_1
    //   838: getstatic 194	com/google/protobuf/DescriptorProtos$FileOptions:PARSER	Lcom/google/protobuf/Parser;
    //   841: aload_2
    //   842: invokevirtual 178	com/google/protobuf/CodedInputStream:a	(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   845: checkcast 190	com/google/protobuf/DescriptorProtos$FileOptions
    //   848: putfield 188	com/google/protobuf/DescriptorProtos$FileDescriptorProto:options_	Lcom/google/protobuf/DescriptorProtos$FileOptions;
    //   851: aload 11
    //   853: ifnull +40 -> 893
    //   856: iload_3
    //   857: istore 4
    //   859: iload_3
    //   860: istore 5
    //   862: iload_3
    //   863: istore 6
    //   865: aload 11
    //   867: aload_0
    //   868: getfield 188	com/google/protobuf/DescriptorProtos$FileDescriptorProto:options_	Lcom/google/protobuf/DescriptorProtos$FileOptions;
    //   871: invokevirtual 199	com/google/protobuf/DescriptorProtos$FileOptions$Builder:a	(Lcom/google/protobuf/DescriptorProtos$FileOptions;)Lcom/google/protobuf/DescriptorProtos$FileOptions$Builder;
    //   874: pop
    //   875: iload_3
    //   876: istore 4
    //   878: iload_3
    //   879: istore 5
    //   881: iload_3
    //   882: istore 6
    //   884: aload_0
    //   885: aload 11
    //   887: invokevirtual 202	com/google/protobuf/DescriptorProtos$FileOptions$Builder:d	()Lcom/google/protobuf/DescriptorProtos$FileOptions;
    //   890: putfield 188	com/google/protobuf/DescriptorProtos$FileDescriptorProto:options_	Lcom/google/protobuf/DescriptorProtos$FileOptions;
    //   893: iload_3
    //   894: istore 4
    //   896: iload_3
    //   897: istore 5
    //   899: iload_3
    //   900: istore 6
    //   902: aload_0
    //   903: aload_0
    //   904: getfield 143	com/google/protobuf/DescriptorProtos$FileDescriptorProto:bitField0_	I
    //   907: iconst_4
    //   908: ior
    //   909: putfield 143	com/google/protobuf/DescriptorProtos$FileDescriptorProto:bitField0_	I
    //   912: goto -894 -> 18
    //   915: iload_3
    //   916: istore 7
    //   918: iload_3
    //   919: sipush 256
    //   922: iand
    //   923: ifne +30 -> 953
    //   926: iload_3
    //   927: istore 4
    //   929: iload_3
    //   930: istore 5
    //   932: iload_3
    //   933: istore 6
    //   935: aload_0
    //   936: new 204	java/util/ArrayList
    //   939: dup
    //   940: invokespecial 205	java/util/ArrayList:<init>	()V
    //   943: putfield 116	com/google/protobuf/DescriptorProtos$FileDescriptorProto:extension_	Ljava/util/List;
    //   946: iload_3
    //   947: sipush 256
    //   950: ior
    //   951: istore 7
    //   953: iload 7
    //   955: istore 4
    //   957: iload 7
    //   959: istore 5
    //   961: iload 7
    //   963: istore 6
    //   965: aload_0
    //   966: getfield 116	com/google/protobuf/DescriptorProtos$FileDescriptorProto:extension_	Ljava/util/List;
    //   969: aload_1
    //   970: getstatic 208	com/google/protobuf/DescriptorProtos$FieldDescriptorProto:PARSER	Lcom/google/protobuf/Parser;
    //   973: aload_2
    //   974: invokevirtual 178	com/google/protobuf/CodedInputStream:a	(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   977: invokeinterface 214 2 0
    //   982: pop
    //   983: iload 7
    //   985: istore_3
    //   986: goto -968 -> 18
    //   989: iload_3
    //   990: istore 7
    //   992: iload_3
    //   993: sipush 128
    //   996: iand
    //   997: ifne +30 -> 1027
    //   1000: iload_3
    //   1001: istore 4
    //   1003: iload_3
    //   1004: istore 5
    //   1006: iload_3
    //   1007: istore 6
    //   1009: aload_0
    //   1010: new 204	java/util/ArrayList
    //   1013: dup
    //   1014: invokespecial 205	java/util/ArrayList:<init>	()V
    //   1017: putfield 114	com/google/protobuf/DescriptorProtos$FileDescriptorProto:service_	Ljava/util/List;
    //   1020: iload_3
    //   1021: sipush 128
    //   1024: ior
    //   1025: istore 7
    //   1027: iload 7
    //   1029: istore 4
    //   1031: iload 7
    //   1033: istore 5
    //   1035: iload 7
    //   1037: istore 6
    //   1039: aload_0
    //   1040: getfield 114	com/google/protobuf/DescriptorProtos$FileDescriptorProto:service_	Ljava/util/List;
    //   1043: aload_1
    //   1044: getstatic 217	com/google/protobuf/DescriptorProtos$ServiceDescriptorProto:PARSER	Lcom/google/protobuf/Parser;
    //   1047: aload_2
    //   1048: invokevirtual 178	com/google/protobuf/CodedInputStream:a	(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   1051: invokeinterface 214 2 0
    //   1056: pop
    //   1057: iload 7
    //   1059: istore_3
    //   1060: goto -1042 -> 18
    //   1063: iload_3
    //   1064: istore 7
    //   1066: iload_3
    //   1067: bipush 64
    //   1069: iand
    //   1070: ifne +29 -> 1099
    //   1073: iload_3
    //   1074: istore 4
    //   1076: iload_3
    //   1077: istore 5
    //   1079: iload_3
    //   1080: istore 6
    //   1082: aload_0
    //   1083: new 204	java/util/ArrayList
    //   1086: dup
    //   1087: invokespecial 205	java/util/ArrayList:<init>	()V
    //   1090: putfield 112	com/google/protobuf/DescriptorProtos$FileDescriptorProto:enumType_	Ljava/util/List;
    //   1093: iload_3
    //   1094: bipush 64
    //   1096: ior
    //   1097: istore 7
    //   1099: iload 7
    //   1101: istore 4
    //   1103: iload 7
    //   1105: istore 5
    //   1107: iload 7
    //   1109: istore 6
    //   1111: aload_0
    //   1112: getfield 112	com/google/protobuf/DescriptorProtos$FileDescriptorProto:enumType_	Ljava/util/List;
    //   1115: aload_1
    //   1116: getstatic 220	com/google/protobuf/DescriptorProtos$EnumDescriptorProto:PARSER	Lcom/google/protobuf/Parser;
    //   1119: aload_2
    //   1120: invokevirtual 178	com/google/protobuf/CodedInputStream:a	(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   1123: invokeinterface 214 2 0
    //   1128: pop
    //   1129: iload 7
    //   1131: istore_3
    //   1132: goto -1114 -> 18
    //   1135: iload_3
    //   1136: istore 7
    //   1138: iload_3
    //   1139: bipush 32
    //   1141: iand
    //   1142: ifne +29 -> 1171
    //   1145: iload_3
    //   1146: istore 4
    //   1148: iload_3
    //   1149: istore 5
    //   1151: iload_3
    //   1152: istore 6
    //   1154: aload_0
    //   1155: new 204	java/util/ArrayList
    //   1158: dup
    //   1159: invokespecial 205	java/util/ArrayList:<init>	()V
    //   1162: putfield 110	com/google/protobuf/DescriptorProtos$FileDescriptorProto:messageType_	Ljava/util/List;
    //   1165: iload_3
    //   1166: bipush 32
    //   1168: ior
    //   1169: istore 7
    //   1171: iload 7
    //   1173: istore 4
    //   1175: iload 7
    //   1177: istore 5
    //   1179: iload 7
    //   1181: istore 6
    //   1183: aload_0
    //   1184: getfield 110	com/google/protobuf/DescriptorProtos$FileDescriptorProto:messageType_	Ljava/util/List;
    //   1187: aload_1
    //   1188: getstatic 223	com/google/protobuf/DescriptorProtos$DescriptorProto:PARSER	Lcom/google/protobuf/Parser;
    //   1191: aload_2
    //   1192: invokevirtual 178	com/google/protobuf/CodedInputStream:a	(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   1195: invokeinterface 214 2 0
    //   1200: pop
    //   1201: iload 7
    //   1203: istore_3
    //   1204: goto -1186 -> 18
    //   1207: iload_3
    //   1208: istore 4
    //   1210: iload_3
    //   1211: istore 5
    //   1213: iload_3
    //   1214: istore 6
    //   1216: aload_1
    //   1217: invokevirtual 141	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   1220: astore 11
    //   1222: iload_3
    //   1223: istore 7
    //   1225: iload_3
    //   1226: iconst_4
    //   1227: iand
    //   1228: ifne +28 -> 1256
    //   1231: iload_3
    //   1232: istore 4
    //   1234: iload_3
    //   1235: istore 5
    //   1237: iload_3
    //   1238: istore 6
    //   1240: aload_0
    //   1241: new 90	com/google/protobuf/LazyStringArrayList
    //   1244: dup
    //   1245: invokespecial 224	com/google/protobuf/LazyStringArrayList:<init>	()V
    //   1248: putfield 94	com/google/protobuf/DescriptorProtos$FileDescriptorProto:dependency_	Lcom/google/protobuf/LazyStringList;
    //   1251: iload_3
    //   1252: iconst_4
    //   1253: ior
    //   1254: istore 7
    //   1256: iload 7
    //   1258: istore 4
    //   1260: iload 7
    //   1262: istore 5
    //   1264: iload 7
    //   1266: istore 6
    //   1268: aload_0
    //   1269: getfield 94	com/google/protobuf/DescriptorProtos$FileDescriptorProto:dependency_	Lcom/google/protobuf/LazyStringList;
    //   1272: aload 11
    //   1274: invokeinterface 229 2 0
    //   1279: iload 7
    //   1281: istore_3
    //   1282: goto -1264 -> 18
    //   1285: iload_3
    //   1286: istore 4
    //   1288: iload_3
    //   1289: istore 5
    //   1291: iload_3
    //   1292: istore 6
    //   1294: aload_1
    //   1295: invokevirtual 141	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   1298: astore 11
    //   1300: iload_3
    //   1301: istore 4
    //   1303: iload_3
    //   1304: istore 5
    //   1306: iload_3
    //   1307: istore 6
    //   1309: aload_0
    //   1310: aload_0
    //   1311: getfield 143	com/google/protobuf/DescriptorProtos$FileDescriptorProto:bitField0_	I
    //   1314: iconst_2
    //   1315: ior
    //   1316: putfield 143	com/google/protobuf/DescriptorProtos$FileDescriptorProto:bitField0_	I
    //   1319: iload_3
    //   1320: istore 4
    //   1322: iload_3
    //   1323: istore 5
    //   1325: iload_3
    //   1326: istore 6
    //   1328: aload_0
    //   1329: aload 11
    //   1331: putfield 88	com/google/protobuf/DescriptorProtos$FileDescriptorProto:package_	Ljava/lang/Object;
    //   1334: goto -1316 -> 18
    //   1337: iload_3
    //   1338: istore 4
    //   1340: iload_3
    //   1341: istore 5
    //   1343: iload_3
    //   1344: istore 6
    //   1346: aload_1
    //   1347: invokevirtual 141	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   1350: astore 11
    //   1352: iload_3
    //   1353: istore 4
    //   1355: iload_3
    //   1356: istore 5
    //   1358: iload_3
    //   1359: istore 6
    //   1361: aload_0
    //   1362: aload_0
    //   1363: getfield 143	com/google/protobuf/DescriptorProtos$FileDescriptorProto:bitField0_	I
    //   1366: iconst_1
    //   1367: ior
    //   1368: putfield 143	com/google/protobuf/DescriptorProtos$FileDescriptorProto:bitField0_	I
    //   1371: iload_3
    //   1372: istore 4
    //   1374: iload_3
    //   1375: istore 5
    //   1377: iload_3
    //   1378: istore 6
    //   1380: aload_0
    //   1381: aload 11
    //   1383: putfield 86	com/google/protobuf/DescriptorProtos$FileDescriptorProto:name_	Ljava/lang/Object;
    //   1386: goto -1368 -> 18
    //   1389: iconst_1
    //   1390: istore 8
    //   1392: goto -1374 -> 18
    //   1395: iload 10
    //   1397: ifne -1379 -> 18
    //   1400: goto -11 -> 1389
    //   1403: astore_1
    //   1404: goto +32 -> 1436
    //   1407: astore_1
    //   1408: iload 5
    //   1410: istore 4
    //   1412: new 121	com/google/protobuf/InvalidProtocolBufferException
    //   1415: dup
    //   1416: aload_1
    //   1417: invokespecial 232	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/io/IOException;)V
    //   1420: aload_0
    //   1421: invokevirtual 236	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   1424: athrow
    //   1425: astore_1
    //   1426: iload 6
    //   1428: istore 4
    //   1430: aload_1
    //   1431: aload_0
    //   1432: invokevirtual 236	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   1435: athrow
    //   1436: iload 4
    //   1438: iconst_4
    //   1439: iand
    //   1440: ifeq +16 -> 1456
    //   1443: aload_0
    //   1444: aload_0
    //   1445: getfield 94	com/google/protobuf/DescriptorProtos$FileDescriptorProto:dependency_	Lcom/google/protobuf/LazyStringList;
    //   1448: invokeinterface 240 1 0
    //   1453: putfield 94	com/google/protobuf/DescriptorProtos$FileDescriptorProto:dependency_	Lcom/google/protobuf/LazyStringList;
    //   1456: iload 4
    //   1458: bipush 32
    //   1460: iand
    //   1461: ifeq +14 -> 1475
    //   1464: aload_0
    //   1465: aload_0
    //   1466: getfield 110	com/google/protobuf/DescriptorProtos$FileDescriptorProto:messageType_	Ljava/util/List;
    //   1469: invokestatic 244	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   1472: putfield 110	com/google/protobuf/DescriptorProtos$FileDescriptorProto:messageType_	Ljava/util/List;
    //   1475: iload 4
    //   1477: bipush 64
    //   1479: iand
    //   1480: ifeq +14 -> 1494
    //   1483: aload_0
    //   1484: aload_0
    //   1485: getfield 112	com/google/protobuf/DescriptorProtos$FileDescriptorProto:enumType_	Ljava/util/List;
    //   1488: invokestatic 244	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   1491: putfield 112	com/google/protobuf/DescriptorProtos$FileDescriptorProto:enumType_	Ljava/util/List;
    //   1494: iload 4
    //   1496: sipush 128
    //   1499: iand
    //   1500: ifeq +14 -> 1514
    //   1503: aload_0
    //   1504: aload_0
    //   1505: getfield 114	com/google/protobuf/DescriptorProtos$FileDescriptorProto:service_	Ljava/util/List;
    //   1508: invokestatic 244	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   1511: putfield 114	com/google/protobuf/DescriptorProtos$FileDescriptorProto:service_	Ljava/util/List;
    //   1514: iload 4
    //   1516: sipush 256
    //   1519: iand
    //   1520: ifeq +14 -> 1534
    //   1523: aload_0
    //   1524: aload_0
    //   1525: getfield 116	com/google/protobuf/DescriptorProtos$FileDescriptorProto:extension_	Ljava/util/List;
    //   1528: invokestatic 244	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   1531: putfield 116	com/google/protobuf/DescriptorProtos$FileDescriptorProto:extension_	Ljava/util/List;
    //   1534: iload 4
    //   1536: bipush 8
    //   1538: iand
    //   1539: ifeq +12 -> 1551
    //   1542: aload_0
    //   1543: getfield 100	com/google/protobuf/DescriptorProtos$FileDescriptorProto:publicDependency_	Lcom/google/protobuf/Internal$IntList;
    //   1546: invokeinterface 247 1 0
    //   1551: iload 4
    //   1553: bipush 16
    //   1555: iand
    //   1556: ifeq +12 -> 1568
    //   1559: aload_0
    //   1560: getfield 102	com/google/protobuf/DescriptorProtos$FileDescriptorProto:weakDependency_	Lcom/google/protobuf/Internal$IntList;
    //   1563: invokeinterface 247 1 0
    //   1568: aload_0
    //   1569: aload 13
    //   1571: invokevirtual 252	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   1574: putfield 256	com/google/protobuf/DescriptorProtos$FileDescriptorProto:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   1577: aload_0
    //   1578: invokevirtual 259	com/google/protobuf/DescriptorProtos$FileDescriptorProto:makeExtensionsImmutable	()V
    //   1581: aload_1
    //   1582: athrow
    //   1583: iload_3
    //   1584: iconst_4
    //   1585: iand
    //   1586: ifeq +16 -> 1602
    //   1589: aload_0
    //   1590: aload_0
    //   1591: getfield 94	com/google/protobuf/DescriptorProtos$FileDescriptorProto:dependency_	Lcom/google/protobuf/LazyStringList;
    //   1594: invokeinterface 240 1 0
    //   1599: putfield 94	com/google/protobuf/DescriptorProtos$FileDescriptorProto:dependency_	Lcom/google/protobuf/LazyStringList;
    //   1602: iload_3
    //   1603: bipush 32
    //   1605: iand
    //   1606: ifeq +14 -> 1620
    //   1609: aload_0
    //   1610: aload_0
    //   1611: getfield 110	com/google/protobuf/DescriptorProtos$FileDescriptorProto:messageType_	Ljava/util/List;
    //   1614: invokestatic 244	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   1617: putfield 110	com/google/protobuf/DescriptorProtos$FileDescriptorProto:messageType_	Ljava/util/List;
    //   1620: iload_3
    //   1621: bipush 64
    //   1623: iand
    //   1624: ifeq +14 -> 1638
    //   1627: aload_0
    //   1628: aload_0
    //   1629: getfield 112	com/google/protobuf/DescriptorProtos$FileDescriptorProto:enumType_	Ljava/util/List;
    //   1632: invokestatic 244	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   1635: putfield 112	com/google/protobuf/DescriptorProtos$FileDescriptorProto:enumType_	Ljava/util/List;
    //   1638: iload_3
    //   1639: sipush 128
    //   1642: iand
    //   1643: ifeq +14 -> 1657
    //   1646: aload_0
    //   1647: aload_0
    //   1648: getfield 114	com/google/protobuf/DescriptorProtos$FileDescriptorProto:service_	Ljava/util/List;
    //   1651: invokestatic 244	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   1654: putfield 114	com/google/protobuf/DescriptorProtos$FileDescriptorProto:service_	Ljava/util/List;
    //   1657: iload_3
    //   1658: sipush 256
    //   1661: iand
    //   1662: ifeq +14 -> 1676
    //   1665: aload_0
    //   1666: aload_0
    //   1667: getfield 116	com/google/protobuf/DescriptorProtos$FileDescriptorProto:extension_	Ljava/util/List;
    //   1670: invokestatic 244	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   1673: putfield 116	com/google/protobuf/DescriptorProtos$FileDescriptorProto:extension_	Ljava/util/List;
    //   1676: iload_3
    //   1677: bipush 8
    //   1679: iand
    //   1680: ifeq +12 -> 1692
    //   1683: aload_0
    //   1684: getfield 100	com/google/protobuf/DescriptorProtos$FileDescriptorProto:publicDependency_	Lcom/google/protobuf/Internal$IntList;
    //   1687: invokeinterface 247 1 0
    //   1692: iload_3
    //   1693: bipush 16
    //   1695: iand
    //   1696: ifeq +12 -> 1708
    //   1699: aload_0
    //   1700: getfield 102	com/google/protobuf/DescriptorProtos$FileDescriptorProto:weakDependency_	Lcom/google/protobuf/Internal$IntList;
    //   1703: invokeinterface 247 1 0
    //   1708: aload_0
    //   1709: aload 13
    //   1711: invokevirtual 252	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   1714: putfield 256	com/google/protobuf/DescriptorProtos$FileDescriptorProto:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   1717: aload_0
    //   1718: invokevirtual 259	com/google/protobuf/DescriptorProtos$FileDescriptorProto:makeExtensionsImmutable	()V
    //   1721: return
    //   1722: new 261	java/lang/NullPointerException
    //   1725: dup
    //   1726: invokespecial 262	java/lang/NullPointerException:<init>	()V
    //   1729: astore_1
    //   1730: goto +5 -> 1735
    //   1733: aload_1
    //   1734: athrow
    //   1735: goto -2 -> 1733
    //   1738: goto -1562 -> 176
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1741	0	this	FileDescriptorProto
    //   0	1741	1	paramCodedInputStream	CodedInputStream
    //   0	1741	2	paramExtensionRegistryLite	ExtensionRegistryLite
    //   17	1679	3	i	int
    //   24	1532	4	j	int
    //   27	1382	5	k	int
    //   30	1397	6	m	int
    //   36	1244	7	n	int
    //   14	1377	8	i1	int
    //   270	318	9	i2	int
    //   195	1201	10	bool	boolean
    //   42	1340	11	localObject1	Object
    //   39	749	12	localObject2	Object
    //   11	1699	13	localBuilder	UnknownFieldSet.Builder
    // Exception table:
    //   from	to	target	type
    //   32	38	1403	finally
    //   185	197	1403	finally
    //   209	215	1403	finally
    //   224	235	1403	finally
    //   244	250	1403	finally
    //   262	272	1403	finally
    //   294	301	1403	finally
    //   310	317	1403	finally
    //   335	342	1403	finally
    //   354	367	1403	finally
    //   382	388	1403	finally
    //   413	420	1403	finally
    //   438	451	1403	finally
    //   466	476	1403	finally
    //   498	505	1403	finally
    //   514	521	1403	finally
    //   539	546	1403	finally
    //   558	571	1403	finally
    //   586	592	1403	finally
    //   617	624	1403	finally
    //   642	655	1403	finally
    //   670	680	1403	finally
    //   689	698	1403	finally
    //   707	722	1403	finally
    //   736	746	1403	finally
    //   755	764	1403	finally
    //   773	784	1403	finally
    //   800	809	1403	finally
    //   818	827	1403	finally
    //   836	851	1403	finally
    //   865	875	1403	finally
    //   884	893	1403	finally
    //   902	912	1403	finally
    //   935	946	1403	finally
    //   965	983	1403	finally
    //   1009	1020	1403	finally
    //   1039	1057	1403	finally
    //   1082	1093	1403	finally
    //   1111	1129	1403	finally
    //   1154	1165	1403	finally
    //   1183	1201	1403	finally
    //   1216	1222	1403	finally
    //   1240	1251	1403	finally
    //   1268	1279	1403	finally
    //   1294	1300	1403	finally
    //   1309	1319	1403	finally
    //   1328	1334	1403	finally
    //   1346	1352	1403	finally
    //   1361	1371	1403	finally
    //   1380	1386	1403	finally
    //   1412	1425	1403	finally
    //   1430	1436	1403	finally
    //   32	38	1407	java/io/IOException
    //   185	197	1407	java/io/IOException
    //   209	215	1407	java/io/IOException
    //   224	235	1407	java/io/IOException
    //   244	250	1407	java/io/IOException
    //   262	272	1407	java/io/IOException
    //   294	301	1407	java/io/IOException
    //   310	317	1407	java/io/IOException
    //   335	342	1407	java/io/IOException
    //   354	367	1407	java/io/IOException
    //   382	388	1407	java/io/IOException
    //   413	420	1407	java/io/IOException
    //   438	451	1407	java/io/IOException
    //   466	476	1407	java/io/IOException
    //   498	505	1407	java/io/IOException
    //   514	521	1407	java/io/IOException
    //   539	546	1407	java/io/IOException
    //   558	571	1407	java/io/IOException
    //   586	592	1407	java/io/IOException
    //   617	624	1407	java/io/IOException
    //   642	655	1407	java/io/IOException
    //   670	680	1407	java/io/IOException
    //   689	698	1407	java/io/IOException
    //   707	722	1407	java/io/IOException
    //   736	746	1407	java/io/IOException
    //   755	764	1407	java/io/IOException
    //   773	784	1407	java/io/IOException
    //   800	809	1407	java/io/IOException
    //   818	827	1407	java/io/IOException
    //   836	851	1407	java/io/IOException
    //   865	875	1407	java/io/IOException
    //   884	893	1407	java/io/IOException
    //   902	912	1407	java/io/IOException
    //   935	946	1407	java/io/IOException
    //   965	983	1407	java/io/IOException
    //   1009	1020	1407	java/io/IOException
    //   1039	1057	1407	java/io/IOException
    //   1082	1093	1407	java/io/IOException
    //   1111	1129	1407	java/io/IOException
    //   1154	1165	1407	java/io/IOException
    //   1183	1201	1407	java/io/IOException
    //   1216	1222	1407	java/io/IOException
    //   1240	1251	1407	java/io/IOException
    //   1268	1279	1407	java/io/IOException
    //   1294	1300	1407	java/io/IOException
    //   1309	1319	1407	java/io/IOException
    //   1328	1334	1407	java/io/IOException
    //   1346	1352	1407	java/io/IOException
    //   1361	1371	1407	java/io/IOException
    //   1380	1386	1407	java/io/IOException
    //   32	38	1425	com/google/protobuf/InvalidProtocolBufferException
    //   185	197	1425	com/google/protobuf/InvalidProtocolBufferException
    //   209	215	1425	com/google/protobuf/InvalidProtocolBufferException
    //   224	235	1425	com/google/protobuf/InvalidProtocolBufferException
    //   244	250	1425	com/google/protobuf/InvalidProtocolBufferException
    //   262	272	1425	com/google/protobuf/InvalidProtocolBufferException
    //   294	301	1425	com/google/protobuf/InvalidProtocolBufferException
    //   310	317	1425	com/google/protobuf/InvalidProtocolBufferException
    //   335	342	1425	com/google/protobuf/InvalidProtocolBufferException
    //   354	367	1425	com/google/protobuf/InvalidProtocolBufferException
    //   382	388	1425	com/google/protobuf/InvalidProtocolBufferException
    //   413	420	1425	com/google/protobuf/InvalidProtocolBufferException
    //   438	451	1425	com/google/protobuf/InvalidProtocolBufferException
    //   466	476	1425	com/google/protobuf/InvalidProtocolBufferException
    //   498	505	1425	com/google/protobuf/InvalidProtocolBufferException
    //   514	521	1425	com/google/protobuf/InvalidProtocolBufferException
    //   539	546	1425	com/google/protobuf/InvalidProtocolBufferException
    //   558	571	1425	com/google/protobuf/InvalidProtocolBufferException
    //   586	592	1425	com/google/protobuf/InvalidProtocolBufferException
    //   617	624	1425	com/google/protobuf/InvalidProtocolBufferException
    //   642	655	1425	com/google/protobuf/InvalidProtocolBufferException
    //   670	680	1425	com/google/protobuf/InvalidProtocolBufferException
    //   689	698	1425	com/google/protobuf/InvalidProtocolBufferException
    //   707	722	1425	com/google/protobuf/InvalidProtocolBufferException
    //   736	746	1425	com/google/protobuf/InvalidProtocolBufferException
    //   755	764	1425	com/google/protobuf/InvalidProtocolBufferException
    //   773	784	1425	com/google/protobuf/InvalidProtocolBufferException
    //   800	809	1425	com/google/protobuf/InvalidProtocolBufferException
    //   818	827	1425	com/google/protobuf/InvalidProtocolBufferException
    //   836	851	1425	com/google/protobuf/InvalidProtocolBufferException
    //   865	875	1425	com/google/protobuf/InvalidProtocolBufferException
    //   884	893	1425	com/google/protobuf/InvalidProtocolBufferException
    //   902	912	1425	com/google/protobuf/InvalidProtocolBufferException
    //   935	946	1425	com/google/protobuf/InvalidProtocolBufferException
    //   965	983	1425	com/google/protobuf/InvalidProtocolBufferException
    //   1009	1020	1425	com/google/protobuf/InvalidProtocolBufferException
    //   1039	1057	1425	com/google/protobuf/InvalidProtocolBufferException
    //   1082	1093	1425	com/google/protobuf/InvalidProtocolBufferException
    //   1111	1129	1425	com/google/protobuf/InvalidProtocolBufferException
    //   1154	1165	1425	com/google/protobuf/InvalidProtocolBufferException
    //   1183	1201	1425	com/google/protobuf/InvalidProtocolBufferException
    //   1216	1222	1425	com/google/protobuf/InvalidProtocolBufferException
    //   1240	1251	1425	com/google/protobuf/InvalidProtocolBufferException
    //   1268	1279	1425	com/google/protobuf/InvalidProtocolBufferException
    //   1294	1300	1425	com/google/protobuf/InvalidProtocolBufferException
    //   1309	1319	1425	com/google/protobuf/InvalidProtocolBufferException
    //   1328	1334	1425	com/google/protobuf/InvalidProtocolBufferException
    //   1346	1352	1425	com/google/protobuf/InvalidProtocolBufferException
    //   1361	1371	1425	com/google/protobuf/InvalidProtocolBufferException
    //   1380	1386	1425	com/google/protobuf/InvalidProtocolBufferException
  }
  
  private DescriptorProtos$FileDescriptorProto(GeneratedMessageV3.Builder<?> paramBuilder)
  {
    super(paramBuilder);
  }
  
  public static FileDescriptorProto getDefaultInstance()
  {
    return a;
  }
  
  public static final Descriptors.Descriptor getDescriptor()
  {
    return DescriptorProtos.d();
  }
  
  public static DescriptorProtos.FileDescriptorProto.Builder newBuilder()
  {
    return a.toBuilder();
  }
  
  public static DescriptorProtos.FileDescriptorProto.Builder newBuilder(FileDescriptorProto paramFileDescriptorProto)
  {
    return a.toBuilder().a(paramFileDescriptorProto);
  }
  
  public static FileDescriptorProto parseDelimitedFrom(InputStream paramInputStream)
  {
    return (FileDescriptorProto)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream);
  }
  
  public static FileDescriptorProto parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (FileDescriptorProto)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static FileDescriptorProto parseFrom(ByteString paramByteString)
  {
    return (FileDescriptorProto)PARSER.parseFrom(paramByteString);
  }
  
  public static FileDescriptorProto parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (FileDescriptorProto)PARSER.parseFrom(paramByteString, paramExtensionRegistryLite);
  }
  
  public static FileDescriptorProto parseFrom(CodedInputStream paramCodedInputStream)
  {
    return (FileDescriptorProto)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream);
  }
  
  public static FileDescriptorProto parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (FileDescriptorProto)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static FileDescriptorProto parseFrom(InputStream paramInputStream)
  {
    return (FileDescriptorProto)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream);
  }
  
  public static FileDescriptorProto parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (FileDescriptorProto)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static FileDescriptorProto parseFrom(ByteBuffer paramByteBuffer)
  {
    return (FileDescriptorProto)PARSER.parseFrom(paramByteBuffer);
  }
  
  public static FileDescriptorProto parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (FileDescriptorProto)PARSER.parseFrom(paramByteBuffer, paramExtensionRegistryLite);
  }
  
  public static FileDescriptorProto parseFrom(byte[] paramArrayOfByte)
  {
    return (FileDescriptorProto)PARSER.parseFrom(paramArrayOfByte);
  }
  
  public static FileDescriptorProto parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (FileDescriptorProto)PARSER.parseFrom(paramArrayOfByte, paramExtensionRegistryLite);
  }
  
  public static Parser<FileDescriptorProto> parser()
  {
    return PARSER;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof FileDescriptorProto)) {
      return super.equals(paramObject);
    }
    paramObject = (FileDescriptorProto)paramObject;
    if (hasName() != paramObject.hasName()) {
      return false;
    }
    if ((hasName()) && (!getName().equals(paramObject.getName()))) {
      return false;
    }
    if (hasPackage() != paramObject.hasPackage()) {
      return false;
    }
    if ((hasPackage()) && (!getPackage().equals(paramObject.getPackage()))) {
      return false;
    }
    if (!getDependencyList().equals(paramObject.getDependencyList())) {
      return false;
    }
    if (!getPublicDependencyList().equals(paramObject.getPublicDependencyList())) {
      return false;
    }
    if (!getWeakDependencyList().equals(paramObject.getWeakDependencyList())) {
      return false;
    }
    if (!getMessageTypeList().equals(paramObject.getMessageTypeList())) {
      return false;
    }
    if (!getEnumTypeList().equals(paramObject.getEnumTypeList())) {
      return false;
    }
    if (!getServiceList().equals(paramObject.getServiceList())) {
      return false;
    }
    if (!getExtensionList().equals(paramObject.getExtensionList())) {
      return false;
    }
    if (hasOptions() != paramObject.hasOptions()) {
      return false;
    }
    if ((hasOptions()) && (!getOptions().equals(paramObject.getOptions()))) {
      return false;
    }
    if (hasSourceCodeInfo() != paramObject.hasSourceCodeInfo()) {
      return false;
    }
    if ((hasSourceCodeInfo()) && (!getSourceCodeInfo().equals(paramObject.getSourceCodeInfo()))) {
      return false;
    }
    if (hasSyntax() != paramObject.hasSyntax()) {
      return false;
    }
    if ((hasSyntax()) && (!getSyntax().equals(paramObject.getSyntax()))) {
      return false;
    }
    return this.unknownFields.equals(paramObject.unknownFields);
  }
  
  public FileDescriptorProto getDefaultInstanceForType()
  {
    return a;
  }
  
  public String getDependency(int paramInt)
  {
    return (String)this.dependency_.get(paramInt);
  }
  
  public ByteString getDependencyBytes(int paramInt)
  {
    return this.dependency_.f(paramInt);
  }
  
  public int getDependencyCount()
  {
    return this.dependency_.size();
  }
  
  public ProtocolStringList getDependencyList()
  {
    return this.dependency_;
  }
  
  public DescriptorProtos.EnumDescriptorProto getEnumType(int paramInt)
  {
    return (DescriptorProtos.EnumDescriptorProto)this.enumType_.get(paramInt);
  }
  
  public int getEnumTypeCount()
  {
    return this.enumType_.size();
  }
  
  public List<DescriptorProtos.EnumDescriptorProto> getEnumTypeList()
  {
    return this.enumType_;
  }
  
  public DescriptorProtos.EnumDescriptorProtoOrBuilder getEnumTypeOrBuilder(int paramInt)
  {
    return (DescriptorProtos.EnumDescriptorProtoOrBuilder)this.enumType_.get(paramInt);
  }
  
  public List<? extends DescriptorProtos.EnumDescriptorProtoOrBuilder> getEnumTypeOrBuilderList()
  {
    return this.enumType_;
  }
  
  public DescriptorProtos.FieldDescriptorProto getExtension(int paramInt)
  {
    return (DescriptorProtos.FieldDescriptorProto)this.extension_.get(paramInt);
  }
  
  public int getExtensionCount()
  {
    return this.extension_.size();
  }
  
  public List<DescriptorProtos.FieldDescriptorProto> getExtensionList()
  {
    return this.extension_;
  }
  
  public DescriptorProtos.FieldDescriptorProtoOrBuilder getExtensionOrBuilder(int paramInt)
  {
    return (DescriptorProtos.FieldDescriptorProtoOrBuilder)this.extension_.get(paramInt);
  }
  
  public List<? extends DescriptorProtos.FieldDescriptorProtoOrBuilder> getExtensionOrBuilderList()
  {
    return this.extension_;
  }
  
  public DescriptorProtos.DescriptorProto getMessageType(int paramInt)
  {
    return (DescriptorProtos.DescriptorProto)this.messageType_.get(paramInt);
  }
  
  public int getMessageTypeCount()
  {
    return this.messageType_.size();
  }
  
  public List<DescriptorProtos.DescriptorProto> getMessageTypeList()
  {
    return this.messageType_;
  }
  
  public DescriptorProtos.DescriptorProtoOrBuilder getMessageTypeOrBuilder(int paramInt)
  {
    return (DescriptorProtos.DescriptorProtoOrBuilder)this.messageType_.get(paramInt);
  }
  
  public List<? extends DescriptorProtos.DescriptorProtoOrBuilder> getMessageTypeOrBuilderList()
  {
    return this.messageType_;
  }
  
  public String getName()
  {
    Object localObject = this.name_;
    if ((localObject instanceof String)) {
      return (String)localObject;
    }
    localObject = (ByteString)localObject;
    String str = ((ByteString)localObject).toStringUtf8();
    if (((ByteString)localObject).isValidUtf8()) {
      this.name_ = str;
    }
    return str;
  }
  
  public ByteString getNameBytes()
  {
    Object localObject = this.name_;
    if ((localObject instanceof String))
    {
      localObject = ByteString.copyFromUtf8((String)localObject);
      this.name_ = localObject;
      return localObject;
    }
    return (ByteString)localObject;
  }
  
  public DescriptorProtos.FileOptions getOptions()
  {
    DescriptorProtos.FileOptions localFileOptions2 = this.options_;
    DescriptorProtos.FileOptions localFileOptions1 = localFileOptions2;
    if (localFileOptions2 == null) {
      localFileOptions1 = DescriptorProtos.FileOptions.getDefaultInstance();
    }
    return localFileOptions1;
  }
  
  public DescriptorProtos.FileOptionsOrBuilder getOptionsOrBuilder()
  {
    DescriptorProtos.FileOptions localFileOptions2 = this.options_;
    DescriptorProtos.FileOptions localFileOptions1 = localFileOptions2;
    if (localFileOptions2 == null) {
      localFileOptions1 = DescriptorProtos.FileOptions.getDefaultInstance();
    }
    return localFileOptions1;
  }
  
  public String getPackage()
  {
    Object localObject = this.package_;
    if ((localObject instanceof String)) {
      return (String)localObject;
    }
    localObject = (ByteString)localObject;
    String str = ((ByteString)localObject).toStringUtf8();
    if (((ByteString)localObject).isValidUtf8()) {
      this.package_ = str;
    }
    return str;
  }
  
  public ByteString getPackageBytes()
  {
    Object localObject = this.package_;
    if ((localObject instanceof String))
    {
      localObject = ByteString.copyFromUtf8((String)localObject);
      this.package_ = localObject;
      return localObject;
    }
    return (ByteString)localObject;
  }
  
  public Parser<FileDescriptorProto> getParserForType()
  {
    return PARSER;
  }
  
  public int getPublicDependency(int paramInt)
  {
    return this.publicDependency_.c(paramInt);
  }
  
  public int getPublicDependencyCount()
  {
    return this.publicDependency_.size();
  }
  
  public List<Integer> getPublicDependencyList()
  {
    return this.publicDependency_;
  }
  
  public int getSerializedSize()
  {
    int i = this.memoizedSize;
    if (i != -1) {
      return i;
    }
    i = this.bitField0_;
    int m = 0;
    if ((i & 0x1) != 0) {
      i = GeneratedMessageV3.computeStringSize(1, this.name_) + 0;
    } else {
      i = 0;
    }
    int j = i;
    if ((this.bitField0_ & 0x2) != 0) {
      j = i + GeneratedMessageV3.computeStringSize(2, this.package_);
    }
    i = 0;
    int k = 0;
    while (i < this.dependency_.size())
    {
      k += computeStringSizeNoTag(this.dependency_.d(i));
      i += 1;
    }
    i = j + k + getDependencyList().size() * 1;
    j = 0;
    while (j < this.messageType_.size())
    {
      i += CodedOutputStream.c(4, (MessageLite)this.messageType_.get(j));
      j += 1;
    }
    j = 0;
    while (j < this.enumType_.size())
    {
      i += CodedOutputStream.c(5, (MessageLite)this.enumType_.get(j));
      j += 1;
    }
    j = 0;
    while (j < this.service_.size())
    {
      i += CodedOutputStream.c(6, (MessageLite)this.service_.get(j));
      j += 1;
    }
    j = 0;
    while (j < this.extension_.size())
    {
      i += CodedOutputStream.c(7, (MessageLite)this.extension_.get(j));
      j += 1;
    }
    j = i;
    if ((this.bitField0_ & 0x4) != 0) {
      j = i + CodedOutputStream.c(8, getOptions());
    }
    i = j;
    if ((this.bitField0_ & 0x8) != 0) {
      i = j + CodedOutputStream.c(9, getSourceCodeInfo());
    }
    k = 0;
    j = 0;
    while (k < this.publicDependency_.size())
    {
      j += CodedOutputStream.i(this.publicDependency_.c(k));
      k += 1;
    }
    int i1 = getPublicDependencyList().size();
    int n = 0;
    k = m;
    m = n;
    while (k < this.weakDependency_.size())
    {
      m += CodedOutputStream.i(this.weakDependency_.c(k));
      k += 1;
    }
    j = i + j + i1 * 1 + m + getWeakDependencyList().size() * 1;
    i = j;
    if ((this.bitField0_ & 0x10) != 0) {
      i = j + GeneratedMessageV3.computeStringSize(12, this.syntax_);
    }
    i += this.unknownFields.getSerializedSize();
    this.memoizedSize = i;
    return i;
  }
  
  public DescriptorProtos.ServiceDescriptorProto getService(int paramInt)
  {
    return (DescriptorProtos.ServiceDescriptorProto)this.service_.get(paramInt);
  }
  
  public int getServiceCount()
  {
    return this.service_.size();
  }
  
  public List<DescriptorProtos.ServiceDescriptorProto> getServiceList()
  {
    return this.service_;
  }
  
  public DescriptorProtos.ServiceDescriptorProtoOrBuilder getServiceOrBuilder(int paramInt)
  {
    return (DescriptorProtos.ServiceDescriptorProtoOrBuilder)this.service_.get(paramInt);
  }
  
  public List<? extends DescriptorProtos.ServiceDescriptorProtoOrBuilder> getServiceOrBuilderList()
  {
    return this.service_;
  }
  
  public DescriptorProtos.SourceCodeInfo getSourceCodeInfo()
  {
    DescriptorProtos.SourceCodeInfo localSourceCodeInfo2 = this.sourceCodeInfo_;
    DescriptorProtos.SourceCodeInfo localSourceCodeInfo1 = localSourceCodeInfo2;
    if (localSourceCodeInfo2 == null) {
      localSourceCodeInfo1 = DescriptorProtos.SourceCodeInfo.getDefaultInstance();
    }
    return localSourceCodeInfo1;
  }
  
  public DescriptorProtos.SourceCodeInfoOrBuilder getSourceCodeInfoOrBuilder()
  {
    DescriptorProtos.SourceCodeInfo localSourceCodeInfo2 = this.sourceCodeInfo_;
    DescriptorProtos.SourceCodeInfo localSourceCodeInfo1 = localSourceCodeInfo2;
    if (localSourceCodeInfo2 == null) {
      localSourceCodeInfo1 = DescriptorProtos.SourceCodeInfo.getDefaultInstance();
    }
    return localSourceCodeInfo1;
  }
  
  public String getSyntax()
  {
    Object localObject = this.syntax_;
    if ((localObject instanceof String)) {
      return (String)localObject;
    }
    localObject = (ByteString)localObject;
    String str = ((ByteString)localObject).toStringUtf8();
    if (((ByteString)localObject).isValidUtf8()) {
      this.syntax_ = str;
    }
    return str;
  }
  
  public ByteString getSyntaxBytes()
  {
    Object localObject = this.syntax_;
    if ((localObject instanceof String))
    {
      localObject = ByteString.copyFromUtf8((String)localObject);
      this.syntax_ = localObject;
      return localObject;
    }
    return (ByteString)localObject;
  }
  
  public final UnknownFieldSet getUnknownFields()
  {
    return this.unknownFields;
  }
  
  public int getWeakDependency(int paramInt)
  {
    return this.weakDependency_.c(paramInt);
  }
  
  public int getWeakDependencyCount()
  {
    return this.weakDependency_.size();
  }
  
  public List<Integer> getWeakDependencyList()
  {
    return this.weakDependency_;
  }
  
  public boolean hasName()
  {
    return (this.bitField0_ & 0x1) != 0;
  }
  
  public boolean hasOptions()
  {
    return (this.bitField0_ & 0x4) != 0;
  }
  
  public boolean hasPackage()
  {
    return (this.bitField0_ & 0x2) != 0;
  }
  
  public boolean hasSourceCodeInfo()
  {
    return (this.bitField0_ & 0x8) != 0;
  }
  
  public boolean hasSyntax()
  {
    return (this.bitField0_ & 0x10) != 0;
  }
  
  public int hashCode()
  {
    if (this.memoizedHashCode != 0) {
      return this.memoizedHashCode;
    }
    int j = 779 + getDescriptor().hashCode();
    int i = j;
    if (hasName()) {
      i = (j * 37 + 1) * 53 + getName().hashCode();
    }
    j = i;
    if (hasPackage()) {
      j = (i * 37 + 2) * 53 + getPackage().hashCode();
    }
    i = j;
    if (getDependencyCount() > 0) {
      i = (j * 37 + 3) * 53 + getDependencyList().hashCode();
    }
    j = i;
    if (getPublicDependencyCount() > 0) {
      j = (i * 37 + 10) * 53 + getPublicDependencyList().hashCode();
    }
    i = j;
    if (getWeakDependencyCount() > 0) {
      i = (j * 37 + 11) * 53 + getWeakDependencyList().hashCode();
    }
    j = i;
    if (getMessageTypeCount() > 0) {
      j = (i * 37 + 4) * 53 + getMessageTypeList().hashCode();
    }
    i = j;
    if (getEnumTypeCount() > 0) {
      i = (j * 37 + 5) * 53 + getEnumTypeList().hashCode();
    }
    j = i;
    if (getServiceCount() > 0) {
      j = (i * 37 + 6) * 53 + getServiceList().hashCode();
    }
    i = j;
    if (getExtensionCount() > 0) {
      i = (j * 37 + 7) * 53 + getExtensionList().hashCode();
    }
    j = i;
    if (hasOptions()) {
      j = (i * 37 + 8) * 53 + getOptions().hashCode();
    }
    i = j;
    if (hasSourceCodeInfo()) {
      i = (j * 37 + 9) * 53 + getSourceCodeInfo().hashCode();
    }
    j = i;
    if (hasSyntax()) {
      j = (i * 37 + 12) * 53 + getSyntax().hashCode();
    }
    i = j * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    return i;
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return DescriptorProtos.e().a(FileDescriptorProto.class, DescriptorProtos.FileDescriptorProto.Builder.class);
  }
  
  public final boolean isInitialized()
  {
    int i = this.memoizedIsInitialized;
    if (i == 1) {
      return true;
    }
    if (i == 0) {
      return false;
    }
    i = 0;
    while (i < getMessageTypeCount())
    {
      if (!getMessageType(i).isInitialized())
      {
        this.memoizedIsInitialized = 0;
        return false;
      }
      i += 1;
    }
    i = 0;
    while (i < getEnumTypeCount())
    {
      if (!getEnumType(i).isInitialized())
      {
        this.memoizedIsInitialized = 0;
        return false;
      }
      i += 1;
    }
    i = 0;
    while (i < getServiceCount())
    {
      if (!getService(i).isInitialized())
      {
        this.memoizedIsInitialized = 0;
        return false;
      }
      i += 1;
    }
    i = 0;
    while (i < getExtensionCount())
    {
      if (!getExtension(i).isInitialized())
      {
        this.memoizedIsInitialized = 0;
        return false;
      }
      i += 1;
    }
    if ((hasOptions()) && (!getOptions().isInitialized()))
    {
      this.memoizedIsInitialized = 0;
      return false;
    }
    this.memoizedIsInitialized = 1;
    return true;
  }
  
  public DescriptorProtos.FileDescriptorProto.Builder newBuilderForType()
  {
    return newBuilder();
  }
  
  protected DescriptorProtos.FileDescriptorProto.Builder newBuilderForType(GeneratedMessageV3.BuilderParent paramBuilderParent)
  {
    return new DescriptorProtos.FileDescriptorProto.Builder(paramBuilderParent, null);
  }
  
  protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter paramUnusedPrivateParameter)
  {
    return new FileDescriptorProto();
  }
  
  public DescriptorProtos.FileDescriptorProto.Builder toBuilder()
  {
    if (this == a) {
      return new DescriptorProtos.FileDescriptorProto.Builder(null);
    }
    return new DescriptorProtos.FileDescriptorProto.Builder(null).a(this);
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
  {
    if ((this.bitField0_ & 0x1) != 0) {
      GeneratedMessageV3.writeString(paramCodedOutputStream, 1, this.name_);
    }
    if ((this.bitField0_ & 0x2) != 0) {
      GeneratedMessageV3.writeString(paramCodedOutputStream, 2, this.package_);
    }
    int k = 0;
    int i = 0;
    while (i < this.dependency_.size())
    {
      GeneratedMessageV3.writeString(paramCodedOutputStream, 3, this.dependency_.d(i));
      i += 1;
    }
    i = 0;
    while (i < this.messageType_.size())
    {
      paramCodedOutputStream.a(4, (MessageLite)this.messageType_.get(i));
      i += 1;
    }
    i = 0;
    while (i < this.enumType_.size())
    {
      paramCodedOutputStream.a(5, (MessageLite)this.enumType_.get(i));
      i += 1;
    }
    i = 0;
    while (i < this.service_.size())
    {
      paramCodedOutputStream.a(6, (MessageLite)this.service_.get(i));
      i += 1;
    }
    i = 0;
    while (i < this.extension_.size())
    {
      paramCodedOutputStream.a(7, (MessageLite)this.extension_.get(i));
      i += 1;
    }
    if ((this.bitField0_ & 0x4) != 0) {
      paramCodedOutputStream.a(8, getOptions());
    }
    if ((this.bitField0_ & 0x8) != 0) {
      paramCodedOutputStream.a(9, getSourceCodeInfo());
    }
    i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= this.publicDependency_.size()) {
        break;
      }
      paramCodedOutputStream.b(10, this.publicDependency_.c(i));
      i += 1;
    }
    while (j < this.weakDependency_.size())
    {
      paramCodedOutputStream.b(11, this.weakDependency_.c(j));
      j += 1;
    }
    if ((this.bitField0_ & 0x10) != 0) {
      GeneratedMessageV3.writeString(paramCodedOutputStream, 12, this.syntax_);
    }
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.DescriptorProtos.FileDescriptorProto
 * JD-Core Version:    0.7.0.1
 */