package com.google.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

public final class DescriptorProtos$DescriptorProto
  extends GeneratedMessageV3
  implements DescriptorProtos.DescriptorProtoOrBuilder
{
  public static final int ENUM_TYPE_FIELD_NUMBER = 4;
  public static final int EXTENSION_FIELD_NUMBER = 6;
  public static final int EXTENSION_RANGE_FIELD_NUMBER = 5;
  public static final int FIELD_FIELD_NUMBER = 2;
  public static final int NAME_FIELD_NUMBER = 1;
  public static final int NESTED_TYPE_FIELD_NUMBER = 3;
  public static final int ONEOF_DECL_FIELD_NUMBER = 8;
  public static final int OPTIONS_FIELD_NUMBER = 7;
  @Deprecated
  public static final Parser<DescriptorProto> PARSER = new DescriptorProtos.DescriptorProto.1();
  public static final int RESERVED_NAME_FIELD_NUMBER = 10;
  public static final int RESERVED_RANGE_FIELD_NUMBER = 9;
  private static final DescriptorProto a = new DescriptorProto();
  private static final long serialVersionUID = 0L;
  private int bitField0_;
  private List<DescriptorProtos.EnumDescriptorProto> enumType_;
  private List<DescriptorProtos.DescriptorProto.ExtensionRange> extensionRange_;
  private List<DescriptorProtos.FieldDescriptorProto> extension_;
  private List<DescriptorProtos.FieldDescriptorProto> field_;
  private byte memoizedIsInitialized = -1;
  private volatile Object name_;
  private List<DescriptorProto> nestedType_;
  private List<DescriptorProtos.OneofDescriptorProto> oneofDecl_;
  private DescriptorProtos.MessageOptions options_;
  private LazyStringList reservedName_;
  private List<DescriptorProtos.DescriptorProto.ReservedRange> reservedRange_;
  
  private DescriptorProtos$DescriptorProto()
  {
    this.name_ = "";
    this.field_ = Collections.emptyList();
    this.extension_ = Collections.emptyList();
    this.nestedType_ = Collections.emptyList();
    this.enumType_ = Collections.emptyList();
    this.extensionRange_ = Collections.emptyList();
    this.oneofDecl_ = Collections.emptyList();
    this.reservedRange_ = Collections.emptyList();
    this.reservedName_ = LazyStringArrayList.a;
  }
  
  /* Error */
  private DescriptorProtos$DescriptorProto(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 65	com/google/protobuf/DescriptorProtos$DescriptorProto:<init>	()V
    //   4: aload_2
    //   5: ifnull +1298 -> 1303
    //   8: invokestatic 116	com/google/protobuf/UnknownFieldSet:a	()Lcom/google/protobuf/UnknownFieldSet$Builder;
    //   11: astore 11
    //   13: iconst_0
    //   14: istore 8
    //   16: iconst_0
    //   17: istore_3
    //   18: iload 8
    //   20: ifne +1123 -> 1143
    //   23: iload_3
    //   24: istore 4
    //   26: iload_3
    //   27: istore 5
    //   29: iload_3
    //   30: istore 6
    //   32: aload_1
    //   33: invokevirtual 121	com/google/protobuf/CodedInputStream:a	()I
    //   36: istore 7
    //   38: iload 7
    //   40: lookupswitch	default:+1279->1319, 0:+887->927, 10:+835->875, 18:+765->805, 26:+693->733, 34:+621->661, 42:+549->589, 50:+479->519, 58:+352->392, 66:+280->320, 74:+206->246, 82:+124->164
    //   141: istore 4
    //   143: iload_3
    //   144: istore 5
    //   146: iload_3
    //   147: istore 6
    //   149: aload_0
    //   150: aload_1
    //   151: aload 11
    //   153: aload_2
    //   154: iload 7
    //   156: invokevirtual 125	com/google/protobuf/DescriptorProtos$DescriptorProto:parseUnknownField	(Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/UnknownFieldSet$Builder;Lcom/google/protobuf/ExtensionRegistryLite;I)Z
    //   159: istore 9
    //   161: goto +772 -> 933
    //   164: iload_3
    //   165: istore 4
    //   167: iload_3
    //   168: istore 5
    //   170: iload_3
    //   171: istore 6
    //   173: aload_1
    //   174: invokevirtual 129	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   177: astore 10
    //   179: iload_3
    //   180: istore 7
    //   182: iload_3
    //   183: sipush 512
    //   186: iand
    //   187: ifne +30 -> 217
    //   190: iload_3
    //   191: istore 4
    //   193: iload_3
    //   194: istore 5
    //   196: iload_3
    //   197: istore 6
    //   199: aload_0
    //   200: new 102	com/google/protobuf/LazyStringArrayList
    //   203: dup
    //   204: invokespecial 130	com/google/protobuf/LazyStringArrayList:<init>	()V
    //   207: putfield 106	com/google/protobuf/DescriptorProtos$DescriptorProto:reservedName_	Lcom/google/protobuf/LazyStringList;
    //   210: iload_3
    //   211: sipush 512
    //   214: ior
    //   215: istore 7
    //   217: iload 7
    //   219: istore 4
    //   221: iload 7
    //   223: istore 5
    //   225: iload 7
    //   227: istore 6
    //   229: aload_0
    //   230: getfield 106	com/google/protobuf/DescriptorProtos$DescriptorProto:reservedName_	Lcom/google/protobuf/LazyStringList;
    //   233: aload 10
    //   235: invokeinterface 135 2 0
    //   240: iload 7
    //   242: istore_3
    //   243: goto -225 -> 18
    //   246: iload_3
    //   247: istore 7
    //   249: iload_3
    //   250: sipush 256
    //   253: iand
    //   254: ifne +30 -> 284
    //   257: iload_3
    //   258: istore 4
    //   260: iload_3
    //   261: istore 5
    //   263: iload_3
    //   264: istore 6
    //   266: aload_0
    //   267: new 137	java/util/ArrayList
    //   270: dup
    //   271: invokespecial 138	java/util/ArrayList:<init>	()V
    //   274: putfield 100	com/google/protobuf/DescriptorProtos$DescriptorProto:reservedRange_	Ljava/util/List;
    //   277: iload_3
    //   278: sipush 256
    //   281: ior
    //   282: istore 7
    //   284: iload 7
    //   286: istore 4
    //   288: iload 7
    //   290: istore 5
    //   292: iload 7
    //   294: istore 6
    //   296: aload_0
    //   297: getfield 100	com/google/protobuf/DescriptorProtos$DescriptorProto:reservedRange_	Ljava/util/List;
    //   300: aload_1
    //   301: getstatic 141	com/google/protobuf/DescriptorProtos$DescriptorProto$ReservedRange:PARSER	Lcom/google/protobuf/Parser;
    //   304: aload_2
    //   305: invokevirtual 144	com/google/protobuf/CodedInputStream:a	(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   308: invokeinterface 150 2 0
    //   313: pop
    //   314: iload 7
    //   316: istore_3
    //   317: goto -299 -> 18
    //   320: iload_3
    //   321: istore 7
    //   323: iload_3
    //   324: bipush 64
    //   326: iand
    //   327: ifne +29 -> 356
    //   330: iload_3
    //   331: istore 4
    //   333: iload_3
    //   334: istore 5
    //   336: iload_3
    //   337: istore 6
    //   339: aload_0
    //   340: new 137	java/util/ArrayList
    //   343: dup
    //   344: invokespecial 138	java/util/ArrayList:<init>	()V
    //   347: putfield 98	com/google/protobuf/DescriptorProtos$DescriptorProto:oneofDecl_	Ljava/util/List;
    //   350: iload_3
    //   351: bipush 64
    //   353: ior
    //   354: istore 7
    //   356: iload 7
    //   358: istore 4
    //   360: iload 7
    //   362: istore 5
    //   364: iload 7
    //   366: istore 6
    //   368: aload_0
    //   369: getfield 98	com/google/protobuf/DescriptorProtos$DescriptorProto:oneofDecl_	Ljava/util/List;
    //   372: aload_1
    //   373: getstatic 153	com/google/protobuf/DescriptorProtos$OneofDescriptorProto:PARSER	Lcom/google/protobuf/Parser;
    //   376: aload_2
    //   377: invokevirtual 144	com/google/protobuf/CodedInputStream:a	(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   380: invokeinterface 150 2 0
    //   385: pop
    //   386: iload 7
    //   388: istore_3
    //   389: goto -371 -> 18
    //   392: aconst_null
    //   393: astore 10
    //   395: iload_3
    //   396: istore 4
    //   398: iload_3
    //   399: istore 5
    //   401: iload_3
    //   402: istore 6
    //   404: aload_0
    //   405: getfield 155	com/google/protobuf/DescriptorProtos$DescriptorProto:bitField0_	I
    //   408: iconst_2
    //   409: iand
    //   410: ifeq +21 -> 431
    //   413: iload_3
    //   414: istore 4
    //   416: iload_3
    //   417: istore 5
    //   419: iload_3
    //   420: istore 6
    //   422: aload_0
    //   423: getfield 157	com/google/protobuf/DescriptorProtos$DescriptorProto:options_	Lcom/google/protobuf/DescriptorProtos$MessageOptions;
    //   426: invokevirtual 163	com/google/protobuf/DescriptorProtos$MessageOptions:toBuilder	()Lcom/google/protobuf/DescriptorProtos$MessageOptions$Builder;
    //   429: astore 10
    //   431: iload_3
    //   432: istore 4
    //   434: iload_3
    //   435: istore 5
    //   437: iload_3
    //   438: istore 6
    //   440: aload_0
    //   441: aload_1
    //   442: getstatic 164	com/google/protobuf/DescriptorProtos$MessageOptions:PARSER	Lcom/google/protobuf/Parser;
    //   445: aload_2
    //   446: invokevirtual 144	com/google/protobuf/CodedInputStream:a	(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   449: checkcast 159	com/google/protobuf/DescriptorProtos$MessageOptions
    //   452: putfield 157	com/google/protobuf/DescriptorProtos$DescriptorProto:options_	Lcom/google/protobuf/DescriptorProtos$MessageOptions;
    //   455: aload 10
    //   457: ifnull +40 -> 497
    //   460: iload_3
    //   461: istore 4
    //   463: iload_3
    //   464: istore 5
    //   466: iload_3
    //   467: istore 6
    //   469: aload 10
    //   471: aload_0
    //   472: getfield 157	com/google/protobuf/DescriptorProtos$DescriptorProto:options_	Lcom/google/protobuf/DescriptorProtos$MessageOptions;
    //   475: invokevirtual 169	com/google/protobuf/DescriptorProtos$MessageOptions$Builder:a	(Lcom/google/protobuf/DescriptorProtos$MessageOptions;)Lcom/google/protobuf/DescriptorProtos$MessageOptions$Builder;
    //   478: pop
    //   479: iload_3
    //   480: istore 4
    //   482: iload_3
    //   483: istore 5
    //   485: iload_3
    //   486: istore 6
    //   488: aload_0
    //   489: aload 10
    //   491: invokevirtual 173	com/google/protobuf/DescriptorProtos$MessageOptions$Builder:d	()Lcom/google/protobuf/DescriptorProtos$MessageOptions;
    //   494: putfield 157	com/google/protobuf/DescriptorProtos$DescriptorProto:options_	Lcom/google/protobuf/DescriptorProtos$MessageOptions;
    //   497: iload_3
    //   498: istore 4
    //   500: iload_3
    //   501: istore 5
    //   503: iload_3
    //   504: istore 6
    //   506: aload_0
    //   507: aload_0
    //   508: getfield 155	com/google/protobuf/DescriptorProtos$DescriptorProto:bitField0_	I
    //   511: iconst_2
    //   512: ior
    //   513: putfield 155	com/google/protobuf/DescriptorProtos$DescriptorProto:bitField0_	I
    //   516: goto -498 -> 18
    //   519: iload_3
    //   520: istore 7
    //   522: iload_3
    //   523: iconst_4
    //   524: iand
    //   525: ifne +28 -> 553
    //   528: iload_3
    //   529: istore 4
    //   531: iload_3
    //   532: istore 5
    //   534: iload_3
    //   535: istore 6
    //   537: aload_0
    //   538: new 137	java/util/ArrayList
    //   541: dup
    //   542: invokespecial 138	java/util/ArrayList:<init>	()V
    //   545: putfield 90	com/google/protobuf/DescriptorProtos$DescriptorProto:extension_	Ljava/util/List;
    //   548: iload_3
    //   549: iconst_4
    //   550: ior
    //   551: istore 7
    //   553: iload 7
    //   555: istore 4
    //   557: iload 7
    //   559: istore 5
    //   561: iload 7
    //   563: istore 6
    //   565: aload_0
    //   566: getfield 90	com/google/protobuf/DescriptorProtos$DescriptorProto:extension_	Ljava/util/List;
    //   569: aload_1
    //   570: getstatic 176	com/google/protobuf/DescriptorProtos$FieldDescriptorProto:PARSER	Lcom/google/protobuf/Parser;
    //   573: aload_2
    //   574: invokevirtual 144	com/google/protobuf/CodedInputStream:a	(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   577: invokeinterface 150 2 0
    //   582: pop
    //   583: iload 7
    //   585: istore_3
    //   586: goto -568 -> 18
    //   589: iload_3
    //   590: istore 7
    //   592: iload_3
    //   593: bipush 32
    //   595: iand
    //   596: ifne +29 -> 625
    //   599: iload_3
    //   600: istore 4
    //   602: iload_3
    //   603: istore 5
    //   605: iload_3
    //   606: istore 6
    //   608: aload_0
    //   609: new 137	java/util/ArrayList
    //   612: dup
    //   613: invokespecial 138	java/util/ArrayList:<init>	()V
    //   616: putfield 96	com/google/protobuf/DescriptorProtos$DescriptorProto:extensionRange_	Ljava/util/List;
    //   619: iload_3
    //   620: bipush 32
    //   622: ior
    //   623: istore 7
    //   625: iload 7
    //   627: istore 4
    //   629: iload 7
    //   631: istore 5
    //   633: iload 7
    //   635: istore 6
    //   637: aload_0
    //   638: getfield 96	com/google/protobuf/DescriptorProtos$DescriptorProto:extensionRange_	Ljava/util/List;
    //   641: aload_1
    //   642: getstatic 179	com/google/protobuf/DescriptorProtos$DescriptorProto$ExtensionRange:PARSER	Lcom/google/protobuf/Parser;
    //   645: aload_2
    //   646: invokevirtual 144	com/google/protobuf/CodedInputStream:a	(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   649: invokeinterface 150 2 0
    //   654: pop
    //   655: iload 7
    //   657: istore_3
    //   658: goto -640 -> 18
    //   661: iload_3
    //   662: istore 7
    //   664: iload_3
    //   665: bipush 16
    //   667: iand
    //   668: ifne +29 -> 697
    //   671: iload_3
    //   672: istore 4
    //   674: iload_3
    //   675: istore 5
    //   677: iload_3
    //   678: istore 6
    //   680: aload_0
    //   681: new 137	java/util/ArrayList
    //   684: dup
    //   685: invokespecial 138	java/util/ArrayList:<init>	()V
    //   688: putfield 94	com/google/protobuf/DescriptorProtos$DescriptorProto:enumType_	Ljava/util/List;
    //   691: iload_3
    //   692: bipush 16
    //   694: ior
    //   695: istore 7
    //   697: iload 7
    //   699: istore 4
    //   701: iload 7
    //   703: istore 5
    //   705: iload 7
    //   707: istore 6
    //   709: aload_0
    //   710: getfield 94	com/google/protobuf/DescriptorProtos$DescriptorProto:enumType_	Ljava/util/List;
    //   713: aload_1
    //   714: getstatic 182	com/google/protobuf/DescriptorProtos$EnumDescriptorProto:PARSER	Lcom/google/protobuf/Parser;
    //   717: aload_2
    //   718: invokevirtual 144	com/google/protobuf/CodedInputStream:a	(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   721: invokeinterface 150 2 0
    //   726: pop
    //   727: iload 7
    //   729: istore_3
    //   730: goto -712 -> 18
    //   733: iload_3
    //   734: istore 7
    //   736: iload_3
    //   737: bipush 8
    //   739: iand
    //   740: ifne +29 -> 769
    //   743: iload_3
    //   744: istore 4
    //   746: iload_3
    //   747: istore 5
    //   749: iload_3
    //   750: istore 6
    //   752: aload_0
    //   753: new 137	java/util/ArrayList
    //   756: dup
    //   757: invokespecial 138	java/util/ArrayList:<init>	()V
    //   760: putfield 92	com/google/protobuf/DescriptorProtos$DescriptorProto:nestedType_	Ljava/util/List;
    //   763: iload_3
    //   764: bipush 8
    //   766: ior
    //   767: istore 7
    //   769: iload 7
    //   771: istore 4
    //   773: iload 7
    //   775: istore 5
    //   777: iload 7
    //   779: istore 6
    //   781: aload_0
    //   782: getfield 92	com/google/protobuf/DescriptorProtos$DescriptorProto:nestedType_	Ljava/util/List;
    //   785: aload_1
    //   786: getstatic 72	com/google/protobuf/DescriptorProtos$DescriptorProto:PARSER	Lcom/google/protobuf/Parser;
    //   789: aload_2
    //   790: invokevirtual 144	com/google/protobuf/CodedInputStream:a	(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   793: invokeinterface 150 2 0
    //   798: pop
    //   799: iload 7
    //   801: istore_3
    //   802: goto -784 -> 18
    //   805: iload_3
    //   806: istore 7
    //   808: iload_3
    //   809: iconst_2
    //   810: iand
    //   811: ifne +28 -> 839
    //   814: iload_3
    //   815: istore 4
    //   817: iload_3
    //   818: istore 5
    //   820: iload_3
    //   821: istore 6
    //   823: aload_0
    //   824: new 137	java/util/ArrayList
    //   827: dup
    //   828: invokespecial 138	java/util/ArrayList:<init>	()V
    //   831: putfield 88	com/google/protobuf/DescriptorProtos$DescriptorProto:field_	Ljava/util/List;
    //   834: iload_3
    //   835: iconst_2
    //   836: ior
    //   837: istore 7
    //   839: iload 7
    //   841: istore 4
    //   843: iload 7
    //   845: istore 5
    //   847: iload 7
    //   849: istore 6
    //   851: aload_0
    //   852: getfield 88	com/google/protobuf/DescriptorProtos$DescriptorProto:field_	Ljava/util/List;
    //   855: aload_1
    //   856: getstatic 176	com/google/protobuf/DescriptorProtos$FieldDescriptorProto:PARSER	Lcom/google/protobuf/Parser;
    //   859: aload_2
    //   860: invokevirtual 144	com/google/protobuf/CodedInputStream:a	(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   863: invokeinterface 150 2 0
    //   868: pop
    //   869: iload 7
    //   871: istore_3
    //   872: goto -854 -> 18
    //   875: iload_3
    //   876: istore 4
    //   878: iload_3
    //   879: istore 5
    //   881: iload_3
    //   882: istore 6
    //   884: aload_1
    //   885: invokevirtual 129	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   888: astore 10
    //   890: iload_3
    //   891: istore 4
    //   893: iload_3
    //   894: istore 5
    //   896: iload_3
    //   897: istore 6
    //   899: aload_0
    //   900: iconst_1
    //   901: aload_0
    //   902: getfield 155	com/google/protobuf/DescriptorProtos$DescriptorProto:bitField0_	I
    //   905: ior
    //   906: putfield 155	com/google/protobuf/DescriptorProtos$DescriptorProto:bitField0_	I
    //   909: iload_3
    //   910: istore 4
    //   912: iload_3
    //   913: istore 5
    //   915: iload_3
    //   916: istore 6
    //   918: aload_0
    //   919: aload 10
    //   921: putfield 80	com/google/protobuf/DescriptorProtos$DescriptorProto:name_	Ljava/lang/Object;
    //   924: goto -906 -> 18
    //   927: iconst_1
    //   928: istore 8
    //   930: goto -912 -> 18
    //   933: iload 9
    //   935: ifne -917 -> 18
    //   938: goto -11 -> 927
    //   941: astore_1
    //   942: goto +32 -> 974
    //   945: astore_1
    //   946: iload 5
    //   948: istore 4
    //   950: new 109	com/google/protobuf/InvalidProtocolBufferException
    //   953: dup
    //   954: aload_1
    //   955: invokespecial 185	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/io/IOException;)V
    //   958: aload_0
    //   959: invokevirtual 189	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   962: athrow
    //   963: astore_1
    //   964: iload 6
    //   966: istore 4
    //   968: aload_1
    //   969: aload_0
    //   970: invokevirtual 189	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   973: athrow
    //   974: iload 4
    //   976: iconst_2
    //   977: iand
    //   978: ifeq +14 -> 992
    //   981: aload_0
    //   982: aload_0
    //   983: getfield 88	com/google/protobuf/DescriptorProtos$DescriptorProto:field_	Ljava/util/List;
    //   986: invokestatic 193	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   989: putfield 88	com/google/protobuf/DescriptorProtos$DescriptorProto:field_	Ljava/util/List;
    //   992: iload 4
    //   994: bipush 8
    //   996: iand
    //   997: ifeq +14 -> 1011
    //   1000: aload_0
    //   1001: aload_0
    //   1002: getfield 92	com/google/protobuf/DescriptorProtos$DescriptorProto:nestedType_	Ljava/util/List;
    //   1005: invokestatic 193	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   1008: putfield 92	com/google/protobuf/DescriptorProtos$DescriptorProto:nestedType_	Ljava/util/List;
    //   1011: iload 4
    //   1013: bipush 16
    //   1015: iand
    //   1016: ifeq +14 -> 1030
    //   1019: aload_0
    //   1020: aload_0
    //   1021: getfield 94	com/google/protobuf/DescriptorProtos$DescriptorProto:enumType_	Ljava/util/List;
    //   1024: invokestatic 193	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   1027: putfield 94	com/google/protobuf/DescriptorProtos$DescriptorProto:enumType_	Ljava/util/List;
    //   1030: iload 4
    //   1032: bipush 32
    //   1034: iand
    //   1035: ifeq +14 -> 1049
    //   1038: aload_0
    //   1039: aload_0
    //   1040: getfield 96	com/google/protobuf/DescriptorProtos$DescriptorProto:extensionRange_	Ljava/util/List;
    //   1043: invokestatic 193	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   1046: putfield 96	com/google/protobuf/DescriptorProtos$DescriptorProto:extensionRange_	Ljava/util/List;
    //   1049: iload 4
    //   1051: iconst_4
    //   1052: iand
    //   1053: ifeq +14 -> 1067
    //   1056: aload_0
    //   1057: aload_0
    //   1058: getfield 90	com/google/protobuf/DescriptorProtos$DescriptorProto:extension_	Ljava/util/List;
    //   1061: invokestatic 193	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   1064: putfield 90	com/google/protobuf/DescriptorProtos$DescriptorProto:extension_	Ljava/util/List;
    //   1067: iload 4
    //   1069: bipush 64
    //   1071: iand
    //   1072: ifeq +14 -> 1086
    //   1075: aload_0
    //   1076: aload_0
    //   1077: getfield 98	com/google/protobuf/DescriptorProtos$DescriptorProto:oneofDecl_	Ljava/util/List;
    //   1080: invokestatic 193	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   1083: putfield 98	com/google/protobuf/DescriptorProtos$DescriptorProto:oneofDecl_	Ljava/util/List;
    //   1086: iload 4
    //   1088: sipush 256
    //   1091: iand
    //   1092: ifeq +14 -> 1106
    //   1095: aload_0
    //   1096: aload_0
    //   1097: getfield 100	com/google/protobuf/DescriptorProtos$DescriptorProto:reservedRange_	Ljava/util/List;
    //   1100: invokestatic 193	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   1103: putfield 100	com/google/protobuf/DescriptorProtos$DescriptorProto:reservedRange_	Ljava/util/List;
    //   1106: iload 4
    //   1108: sipush 512
    //   1111: iand
    //   1112: ifeq +16 -> 1128
    //   1115: aload_0
    //   1116: aload_0
    //   1117: getfield 106	com/google/protobuf/DescriptorProtos$DescriptorProto:reservedName_	Lcom/google/protobuf/LazyStringList;
    //   1120: invokeinterface 197 1 0
    //   1125: putfield 106	com/google/protobuf/DescriptorProtos$DescriptorProto:reservedName_	Lcom/google/protobuf/LazyStringList;
    //   1128: aload_0
    //   1129: aload 11
    //   1131: invokevirtual 202	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   1134: putfield 206	com/google/protobuf/DescriptorProtos$DescriptorProto:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   1137: aload_0
    //   1138: invokevirtual 209	com/google/protobuf/DescriptorProtos$DescriptorProto:makeExtensionsImmutable	()V
    //   1141: aload_1
    //   1142: athrow
    //   1143: iload_3
    //   1144: iconst_2
    //   1145: iand
    //   1146: ifeq +14 -> 1160
    //   1149: aload_0
    //   1150: aload_0
    //   1151: getfield 88	com/google/protobuf/DescriptorProtos$DescriptorProto:field_	Ljava/util/List;
    //   1154: invokestatic 193	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   1157: putfield 88	com/google/protobuf/DescriptorProtos$DescriptorProto:field_	Ljava/util/List;
    //   1160: iload_3
    //   1161: bipush 8
    //   1163: iand
    //   1164: ifeq +14 -> 1178
    //   1167: aload_0
    //   1168: aload_0
    //   1169: getfield 92	com/google/protobuf/DescriptorProtos$DescriptorProto:nestedType_	Ljava/util/List;
    //   1172: invokestatic 193	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   1175: putfield 92	com/google/protobuf/DescriptorProtos$DescriptorProto:nestedType_	Ljava/util/List;
    //   1178: iload_3
    //   1179: bipush 16
    //   1181: iand
    //   1182: ifeq +14 -> 1196
    //   1185: aload_0
    //   1186: aload_0
    //   1187: getfield 94	com/google/protobuf/DescriptorProtos$DescriptorProto:enumType_	Ljava/util/List;
    //   1190: invokestatic 193	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   1193: putfield 94	com/google/protobuf/DescriptorProtos$DescriptorProto:enumType_	Ljava/util/List;
    //   1196: iload_3
    //   1197: bipush 32
    //   1199: iand
    //   1200: ifeq +14 -> 1214
    //   1203: aload_0
    //   1204: aload_0
    //   1205: getfield 96	com/google/protobuf/DescriptorProtos$DescriptorProto:extensionRange_	Ljava/util/List;
    //   1208: invokestatic 193	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   1211: putfield 96	com/google/protobuf/DescriptorProtos$DescriptorProto:extensionRange_	Ljava/util/List;
    //   1214: iload_3
    //   1215: iconst_4
    //   1216: iand
    //   1217: ifeq +14 -> 1231
    //   1220: aload_0
    //   1221: aload_0
    //   1222: getfield 90	com/google/protobuf/DescriptorProtos$DescriptorProto:extension_	Ljava/util/List;
    //   1225: invokestatic 193	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   1228: putfield 90	com/google/protobuf/DescriptorProtos$DescriptorProto:extension_	Ljava/util/List;
    //   1231: iload_3
    //   1232: bipush 64
    //   1234: iand
    //   1235: ifeq +14 -> 1249
    //   1238: aload_0
    //   1239: aload_0
    //   1240: getfield 98	com/google/protobuf/DescriptorProtos$DescriptorProto:oneofDecl_	Ljava/util/List;
    //   1243: invokestatic 193	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   1246: putfield 98	com/google/protobuf/DescriptorProtos$DescriptorProto:oneofDecl_	Ljava/util/List;
    //   1249: iload_3
    //   1250: sipush 256
    //   1253: iand
    //   1254: ifeq +14 -> 1268
    //   1257: aload_0
    //   1258: aload_0
    //   1259: getfield 100	com/google/protobuf/DescriptorProtos$DescriptorProto:reservedRange_	Ljava/util/List;
    //   1262: invokestatic 193	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   1265: putfield 100	com/google/protobuf/DescriptorProtos$DescriptorProto:reservedRange_	Ljava/util/List;
    //   1268: iload_3
    //   1269: sipush 512
    //   1272: iand
    //   1273: ifeq +16 -> 1289
    //   1276: aload_0
    //   1277: aload_0
    //   1278: getfield 106	com/google/protobuf/DescriptorProtos$DescriptorProto:reservedName_	Lcom/google/protobuf/LazyStringList;
    //   1281: invokeinterface 197 1 0
    //   1286: putfield 106	com/google/protobuf/DescriptorProtos$DescriptorProto:reservedName_	Lcom/google/protobuf/LazyStringList;
    //   1289: aload_0
    //   1290: aload 11
    //   1292: invokevirtual 202	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   1295: putfield 206	com/google/protobuf/DescriptorProtos$DescriptorProto:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   1298: aload_0
    //   1299: invokevirtual 209	com/google/protobuf/DescriptorProtos$DescriptorProto:makeExtensionsImmutable	()V
    //   1302: return
    //   1303: new 211	java/lang/NullPointerException
    //   1306: dup
    //   1307: invokespecial 212	java/lang/NullPointerException:<init>	()V
    //   1310: astore_1
    //   1311: goto +5 -> 1316
    //   1314: aload_1
    //   1315: athrow
    //   1316: goto -2 -> 1314
    //   1319: goto -1179 -> 140
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1322	0	this	DescriptorProto
    //   0	1322	1	paramCodedInputStream	CodedInputStream
    //   0	1322	2	paramExtensionRegistryLite	ExtensionRegistryLite
    //   17	1256	3	i	int
    //   24	1088	4	j	int
    //   27	920	5	k	int
    //   30	935	6	m	int
    //   36	834	7	n	int
    //   14	915	8	i1	int
    //   159	775	9	bool	boolean
    //   177	743	10	localObject	Object
    //   11	1280	11	localBuilder	UnknownFieldSet.Builder
    // Exception table:
    //   from	to	target	type
    //   32	38	941	finally
    //   149	161	941	finally
    //   173	179	941	finally
    //   199	210	941	finally
    //   229	240	941	finally
    //   266	277	941	finally
    //   296	314	941	finally
    //   339	350	941	finally
    //   368	386	941	finally
    //   404	413	941	finally
    //   422	431	941	finally
    //   440	455	941	finally
    //   469	479	941	finally
    //   488	497	941	finally
    //   506	516	941	finally
    //   537	548	941	finally
    //   565	583	941	finally
    //   608	619	941	finally
    //   637	655	941	finally
    //   680	691	941	finally
    //   709	727	941	finally
    //   752	763	941	finally
    //   781	799	941	finally
    //   823	834	941	finally
    //   851	869	941	finally
    //   884	890	941	finally
    //   899	909	941	finally
    //   918	924	941	finally
    //   950	963	941	finally
    //   968	974	941	finally
    //   32	38	945	java/io/IOException
    //   149	161	945	java/io/IOException
    //   173	179	945	java/io/IOException
    //   199	210	945	java/io/IOException
    //   229	240	945	java/io/IOException
    //   266	277	945	java/io/IOException
    //   296	314	945	java/io/IOException
    //   339	350	945	java/io/IOException
    //   368	386	945	java/io/IOException
    //   404	413	945	java/io/IOException
    //   422	431	945	java/io/IOException
    //   440	455	945	java/io/IOException
    //   469	479	945	java/io/IOException
    //   488	497	945	java/io/IOException
    //   506	516	945	java/io/IOException
    //   537	548	945	java/io/IOException
    //   565	583	945	java/io/IOException
    //   608	619	945	java/io/IOException
    //   637	655	945	java/io/IOException
    //   680	691	945	java/io/IOException
    //   709	727	945	java/io/IOException
    //   752	763	945	java/io/IOException
    //   781	799	945	java/io/IOException
    //   823	834	945	java/io/IOException
    //   851	869	945	java/io/IOException
    //   884	890	945	java/io/IOException
    //   899	909	945	java/io/IOException
    //   918	924	945	java/io/IOException
    //   32	38	963	com/google/protobuf/InvalidProtocolBufferException
    //   149	161	963	com/google/protobuf/InvalidProtocolBufferException
    //   173	179	963	com/google/protobuf/InvalidProtocolBufferException
    //   199	210	963	com/google/protobuf/InvalidProtocolBufferException
    //   229	240	963	com/google/protobuf/InvalidProtocolBufferException
    //   266	277	963	com/google/protobuf/InvalidProtocolBufferException
    //   296	314	963	com/google/protobuf/InvalidProtocolBufferException
    //   339	350	963	com/google/protobuf/InvalidProtocolBufferException
    //   368	386	963	com/google/protobuf/InvalidProtocolBufferException
    //   404	413	963	com/google/protobuf/InvalidProtocolBufferException
    //   422	431	963	com/google/protobuf/InvalidProtocolBufferException
    //   440	455	963	com/google/protobuf/InvalidProtocolBufferException
    //   469	479	963	com/google/protobuf/InvalidProtocolBufferException
    //   488	497	963	com/google/protobuf/InvalidProtocolBufferException
    //   506	516	963	com/google/protobuf/InvalidProtocolBufferException
    //   537	548	963	com/google/protobuf/InvalidProtocolBufferException
    //   565	583	963	com/google/protobuf/InvalidProtocolBufferException
    //   608	619	963	com/google/protobuf/InvalidProtocolBufferException
    //   637	655	963	com/google/protobuf/InvalidProtocolBufferException
    //   680	691	963	com/google/protobuf/InvalidProtocolBufferException
    //   709	727	963	com/google/protobuf/InvalidProtocolBufferException
    //   752	763	963	com/google/protobuf/InvalidProtocolBufferException
    //   781	799	963	com/google/protobuf/InvalidProtocolBufferException
    //   823	834	963	com/google/protobuf/InvalidProtocolBufferException
    //   851	869	963	com/google/protobuf/InvalidProtocolBufferException
    //   884	890	963	com/google/protobuf/InvalidProtocolBufferException
    //   899	909	963	com/google/protobuf/InvalidProtocolBufferException
    //   918	924	963	com/google/protobuf/InvalidProtocolBufferException
  }
  
  private DescriptorProtos$DescriptorProto(GeneratedMessageV3.Builder<?> paramBuilder)
  {
    super(paramBuilder);
  }
  
  public static DescriptorProto getDefaultInstance()
  {
    return a;
  }
  
  public static final Descriptors.Descriptor getDescriptor()
  {
    return DescriptorProtos.f();
  }
  
  public static DescriptorProtos.DescriptorProto.Builder newBuilder()
  {
    return a.toBuilder();
  }
  
  public static DescriptorProtos.DescriptorProto.Builder newBuilder(DescriptorProto paramDescriptorProto)
  {
    return a.toBuilder().a(paramDescriptorProto);
  }
  
  public static DescriptorProto parseDelimitedFrom(InputStream paramInputStream)
  {
    return (DescriptorProto)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream);
  }
  
  public static DescriptorProto parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (DescriptorProto)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static DescriptorProto parseFrom(ByteString paramByteString)
  {
    return (DescriptorProto)PARSER.parseFrom(paramByteString);
  }
  
  public static DescriptorProto parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (DescriptorProto)PARSER.parseFrom(paramByteString, paramExtensionRegistryLite);
  }
  
  public static DescriptorProto parseFrom(CodedInputStream paramCodedInputStream)
  {
    return (DescriptorProto)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream);
  }
  
  public static DescriptorProto parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (DescriptorProto)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static DescriptorProto parseFrom(InputStream paramInputStream)
  {
    return (DescriptorProto)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream);
  }
  
  public static DescriptorProto parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (DescriptorProto)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static DescriptorProto parseFrom(ByteBuffer paramByteBuffer)
  {
    return (DescriptorProto)PARSER.parseFrom(paramByteBuffer);
  }
  
  public static DescriptorProto parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (DescriptorProto)PARSER.parseFrom(paramByteBuffer, paramExtensionRegistryLite);
  }
  
  public static DescriptorProto parseFrom(byte[] paramArrayOfByte)
  {
    return (DescriptorProto)PARSER.parseFrom(paramArrayOfByte);
  }
  
  public static DescriptorProto parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (DescriptorProto)PARSER.parseFrom(paramArrayOfByte, paramExtensionRegistryLite);
  }
  
  public static Parser<DescriptorProto> parser()
  {
    return PARSER;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof DescriptorProto)) {
      return super.equals(paramObject);
    }
    paramObject = (DescriptorProto)paramObject;
    if (hasName() != paramObject.hasName()) {
      return false;
    }
    if ((hasName()) && (!getName().equals(paramObject.getName()))) {
      return false;
    }
    if (!getFieldList().equals(paramObject.getFieldList())) {
      return false;
    }
    if (!getExtensionList().equals(paramObject.getExtensionList())) {
      return false;
    }
    if (!getNestedTypeList().equals(paramObject.getNestedTypeList())) {
      return false;
    }
    if (!getEnumTypeList().equals(paramObject.getEnumTypeList())) {
      return false;
    }
    if (!getExtensionRangeList().equals(paramObject.getExtensionRangeList())) {
      return false;
    }
    if (!getOneofDeclList().equals(paramObject.getOneofDeclList())) {
      return false;
    }
    if (hasOptions() != paramObject.hasOptions()) {
      return false;
    }
    if ((hasOptions()) && (!getOptions().equals(paramObject.getOptions()))) {
      return false;
    }
    if (!getReservedRangeList().equals(paramObject.getReservedRangeList())) {
      return false;
    }
    if (!getReservedNameList().equals(paramObject.getReservedNameList())) {
      return false;
    }
    return this.unknownFields.equals(paramObject.unknownFields);
  }
  
  public DescriptorProto getDefaultInstanceForType()
  {
    return a;
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
  
  public DescriptorProtos.DescriptorProto.ExtensionRange getExtensionRange(int paramInt)
  {
    return (DescriptorProtos.DescriptorProto.ExtensionRange)this.extensionRange_.get(paramInt);
  }
  
  public int getExtensionRangeCount()
  {
    return this.extensionRange_.size();
  }
  
  public List<DescriptorProtos.DescriptorProto.ExtensionRange> getExtensionRangeList()
  {
    return this.extensionRange_;
  }
  
  public DescriptorProtos.DescriptorProto.ExtensionRangeOrBuilder getExtensionRangeOrBuilder(int paramInt)
  {
    return (DescriptorProtos.DescriptorProto.ExtensionRangeOrBuilder)this.extensionRange_.get(paramInt);
  }
  
  public List<? extends DescriptorProtos.DescriptorProto.ExtensionRangeOrBuilder> getExtensionRangeOrBuilderList()
  {
    return this.extensionRange_;
  }
  
  public DescriptorProtos.FieldDescriptorProto getField(int paramInt)
  {
    return (DescriptorProtos.FieldDescriptorProto)this.field_.get(paramInt);
  }
  
  public int getFieldCount()
  {
    return this.field_.size();
  }
  
  public List<DescriptorProtos.FieldDescriptorProto> getFieldList()
  {
    return this.field_;
  }
  
  public DescriptorProtos.FieldDescriptorProtoOrBuilder getFieldOrBuilder(int paramInt)
  {
    return (DescriptorProtos.FieldDescriptorProtoOrBuilder)this.field_.get(paramInt);
  }
  
  public List<? extends DescriptorProtos.FieldDescriptorProtoOrBuilder> getFieldOrBuilderList()
  {
    return this.field_;
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
  
  public DescriptorProto getNestedType(int paramInt)
  {
    return (DescriptorProto)this.nestedType_.get(paramInt);
  }
  
  public int getNestedTypeCount()
  {
    return this.nestedType_.size();
  }
  
  public List<DescriptorProto> getNestedTypeList()
  {
    return this.nestedType_;
  }
  
  public DescriptorProtos.DescriptorProtoOrBuilder getNestedTypeOrBuilder(int paramInt)
  {
    return (DescriptorProtos.DescriptorProtoOrBuilder)this.nestedType_.get(paramInt);
  }
  
  public List<? extends DescriptorProtos.DescriptorProtoOrBuilder> getNestedTypeOrBuilderList()
  {
    return this.nestedType_;
  }
  
  public DescriptorProtos.OneofDescriptorProto getOneofDecl(int paramInt)
  {
    return (DescriptorProtos.OneofDescriptorProto)this.oneofDecl_.get(paramInt);
  }
  
  public int getOneofDeclCount()
  {
    return this.oneofDecl_.size();
  }
  
  public List<DescriptorProtos.OneofDescriptorProto> getOneofDeclList()
  {
    return this.oneofDecl_;
  }
  
  public DescriptorProtos.OneofDescriptorProtoOrBuilder getOneofDeclOrBuilder(int paramInt)
  {
    return (DescriptorProtos.OneofDescriptorProtoOrBuilder)this.oneofDecl_.get(paramInt);
  }
  
  public List<? extends DescriptorProtos.OneofDescriptorProtoOrBuilder> getOneofDeclOrBuilderList()
  {
    return this.oneofDecl_;
  }
  
  public DescriptorProtos.MessageOptions getOptions()
  {
    DescriptorProtos.MessageOptions localMessageOptions2 = this.options_;
    DescriptorProtos.MessageOptions localMessageOptions1 = localMessageOptions2;
    if (localMessageOptions2 == null) {
      localMessageOptions1 = DescriptorProtos.MessageOptions.getDefaultInstance();
    }
    return localMessageOptions1;
  }
  
  public DescriptorProtos.MessageOptionsOrBuilder getOptionsOrBuilder()
  {
    DescriptorProtos.MessageOptions localMessageOptions2 = this.options_;
    DescriptorProtos.MessageOptions localMessageOptions1 = localMessageOptions2;
    if (localMessageOptions2 == null) {
      localMessageOptions1 = DescriptorProtos.MessageOptions.getDefaultInstance();
    }
    return localMessageOptions1;
  }
  
  public Parser<DescriptorProto> getParserForType()
  {
    return PARSER;
  }
  
  public String getReservedName(int paramInt)
  {
    return (String)this.reservedName_.get(paramInt);
  }
  
  public ByteString getReservedNameBytes(int paramInt)
  {
    return this.reservedName_.f(paramInt);
  }
  
  public int getReservedNameCount()
  {
    return this.reservedName_.size();
  }
  
  public ProtocolStringList getReservedNameList()
  {
    return this.reservedName_;
  }
  
  public DescriptorProtos.DescriptorProto.ReservedRange getReservedRange(int paramInt)
  {
    return (DescriptorProtos.DescriptorProto.ReservedRange)this.reservedRange_.get(paramInt);
  }
  
  public int getReservedRangeCount()
  {
    return this.reservedRange_.size();
  }
  
  public List<DescriptorProtos.DescriptorProto.ReservedRange> getReservedRangeList()
  {
    return this.reservedRange_;
  }
  
  public DescriptorProtos.DescriptorProto.ReservedRangeOrBuilder getReservedRangeOrBuilder(int paramInt)
  {
    return (DescriptorProtos.DescriptorProto.ReservedRangeOrBuilder)this.reservedRange_.get(paramInt);
  }
  
  public List<? extends DescriptorProtos.DescriptorProto.ReservedRangeOrBuilder> getReservedRangeOrBuilderList()
  {
    return this.reservedRange_;
  }
  
  public int getSerializedSize()
  {
    int i = this.memoizedSize;
    if (i != -1) {
      return i;
    }
    i = this.bitField0_;
    int k = 0;
    if ((i & 0x1) != 0) {
      i = GeneratedMessageV3.computeStringSize(1, this.name_) + 0;
    } else {
      i = 0;
    }
    int j = 0;
    while (j < this.field_.size())
    {
      i += CodedOutputStream.c(2, (MessageLite)this.field_.get(j));
      j += 1;
    }
    j = 0;
    while (j < this.nestedType_.size())
    {
      i += CodedOutputStream.c(3, (MessageLite)this.nestedType_.get(j));
      j += 1;
    }
    j = 0;
    while (j < this.enumType_.size())
    {
      i += CodedOutputStream.c(4, (MessageLite)this.enumType_.get(j));
      j += 1;
    }
    j = 0;
    while (j < this.extensionRange_.size())
    {
      i += CodedOutputStream.c(5, (MessageLite)this.extensionRange_.get(j));
      j += 1;
    }
    j = 0;
    while (j < this.extension_.size())
    {
      i += CodedOutputStream.c(6, (MessageLite)this.extension_.get(j));
      j += 1;
    }
    j = i;
    if ((this.bitField0_ & 0x2) != 0) {
      j = i + CodedOutputStream.c(7, getOptions());
    }
    int m = 0;
    i = j;
    j = m;
    while (j < this.oneofDecl_.size())
    {
      i += CodedOutputStream.c(8, (MessageLite)this.oneofDecl_.get(j));
      j += 1;
    }
    j = 0;
    while (j < this.reservedRange_.size())
    {
      i += CodedOutputStream.c(9, (MessageLite)this.reservedRange_.get(j));
      j += 1;
    }
    m = 0;
    j = k;
    k = m;
    while (j < this.reservedName_.size())
    {
      k += computeStringSizeNoTag(this.reservedName_.d(j));
      j += 1;
    }
    i = i + k + getReservedNameList().size() * 1 + this.unknownFields.getSerializedSize();
    this.memoizedSize = i;
    return i;
  }
  
  public final UnknownFieldSet getUnknownFields()
  {
    return this.unknownFields;
  }
  
  public boolean hasName()
  {
    return (this.bitField0_ & 0x1) != 0;
  }
  
  public boolean hasOptions()
  {
    return (this.bitField0_ & 0x2) != 0;
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
    if (getFieldCount() > 0) {
      j = (i * 37 + 2) * 53 + getFieldList().hashCode();
    }
    i = j;
    if (getExtensionCount() > 0) {
      i = (j * 37 + 6) * 53 + getExtensionList().hashCode();
    }
    j = i;
    if (getNestedTypeCount() > 0) {
      j = (i * 37 + 3) * 53 + getNestedTypeList().hashCode();
    }
    i = j;
    if (getEnumTypeCount() > 0) {
      i = (j * 37 + 4) * 53 + getEnumTypeList().hashCode();
    }
    j = i;
    if (getExtensionRangeCount() > 0) {
      j = (i * 37 + 5) * 53 + getExtensionRangeList().hashCode();
    }
    i = j;
    if (getOneofDeclCount() > 0) {
      i = (j * 37 + 8) * 53 + getOneofDeclList().hashCode();
    }
    j = i;
    if (hasOptions()) {
      j = (i * 37 + 7) * 53 + getOptions().hashCode();
    }
    i = j;
    if (getReservedRangeCount() > 0) {
      i = (j * 37 + 9) * 53 + getReservedRangeList().hashCode();
    }
    j = i;
    if (getReservedNameCount() > 0) {
      j = (i * 37 + 10) * 53 + getReservedNameList().hashCode();
    }
    i = j * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    return i;
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return DescriptorProtos.g().a(DescriptorProto.class, DescriptorProtos.DescriptorProto.Builder.class);
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
    while (i < getFieldCount())
    {
      if (!getField(i).isInitialized())
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
    i = 0;
    while (i < getNestedTypeCount())
    {
      if (!getNestedType(i).isInitialized())
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
    while (i < getExtensionRangeCount())
    {
      if (!getExtensionRange(i).isInitialized())
      {
        this.memoizedIsInitialized = 0;
        return false;
      }
      i += 1;
    }
    i = 0;
    while (i < getOneofDeclCount())
    {
      if (!getOneofDecl(i).isInitialized())
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
  
  public DescriptorProtos.DescriptorProto.Builder newBuilderForType()
  {
    return newBuilder();
  }
  
  protected DescriptorProtos.DescriptorProto.Builder newBuilderForType(GeneratedMessageV3.BuilderParent paramBuilderParent)
  {
    return new DescriptorProtos.DescriptorProto.Builder(paramBuilderParent, null);
  }
  
  protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter paramUnusedPrivateParameter)
  {
    return new DescriptorProto();
  }
  
  public DescriptorProtos.DescriptorProto.Builder toBuilder()
  {
    if (this == a) {
      return new DescriptorProtos.DescriptorProto.Builder(null);
    }
    return new DescriptorProtos.DescriptorProto.Builder(null).a(this);
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
  {
    if ((this.bitField0_ & 0x1) != 0) {
      GeneratedMessageV3.writeString(paramCodedOutputStream, 1, this.name_);
    }
    int k = 0;
    int i = 0;
    while (i < this.field_.size())
    {
      paramCodedOutputStream.a(2, (MessageLite)this.field_.get(i));
      i += 1;
    }
    i = 0;
    while (i < this.nestedType_.size())
    {
      paramCodedOutputStream.a(3, (MessageLite)this.nestedType_.get(i));
      i += 1;
    }
    i = 0;
    while (i < this.enumType_.size())
    {
      paramCodedOutputStream.a(4, (MessageLite)this.enumType_.get(i));
      i += 1;
    }
    i = 0;
    while (i < this.extensionRange_.size())
    {
      paramCodedOutputStream.a(5, (MessageLite)this.extensionRange_.get(i));
      i += 1;
    }
    i = 0;
    while (i < this.extension_.size())
    {
      paramCodedOutputStream.a(6, (MessageLite)this.extension_.get(i));
      i += 1;
    }
    if ((this.bitField0_ & 0x2) != 0) {
      paramCodedOutputStream.a(7, getOptions());
    }
    i = 0;
    while (i < this.oneofDecl_.size())
    {
      paramCodedOutputStream.a(8, (MessageLite)this.oneofDecl_.get(i));
      i += 1;
    }
    i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= this.reservedRange_.size()) {
        break;
      }
      paramCodedOutputStream.a(9, (MessageLite)this.reservedRange_.get(i));
      i += 1;
    }
    while (j < this.reservedName_.size())
    {
      GeneratedMessageV3.writeString(paramCodedOutputStream, 10, this.reservedName_.d(j));
      j += 1;
    }
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.DescriptorProtos.DescriptorProto
 * JD-Core Version:    0.7.0.1
 */