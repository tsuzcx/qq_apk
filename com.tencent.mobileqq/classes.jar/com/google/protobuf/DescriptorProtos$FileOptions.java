package com.google.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class DescriptorProtos$FileOptions
  extends GeneratedMessageV3.ExtendableMessage<FileOptions>
  implements DescriptorProtos.FileOptionsOrBuilder
{
  public static final int CC_ENABLE_ARENAS_FIELD_NUMBER = 31;
  public static final int CC_GENERIC_SERVICES_FIELD_NUMBER = 16;
  public static final int CSHARP_NAMESPACE_FIELD_NUMBER = 37;
  public static final int DEPRECATED_FIELD_NUMBER = 23;
  public static final int GO_PACKAGE_FIELD_NUMBER = 11;
  public static final int JAVA_GENERATE_EQUALS_AND_HASH_FIELD_NUMBER = 20;
  public static final int JAVA_GENERIC_SERVICES_FIELD_NUMBER = 17;
  public static final int JAVA_MULTIPLE_FILES_FIELD_NUMBER = 10;
  public static final int JAVA_OUTER_CLASSNAME_FIELD_NUMBER = 8;
  public static final int JAVA_PACKAGE_FIELD_NUMBER = 1;
  public static final int JAVA_STRING_CHECK_UTF8_FIELD_NUMBER = 27;
  public static final int OBJC_CLASS_PREFIX_FIELD_NUMBER = 36;
  public static final int OPTIMIZE_FOR_FIELD_NUMBER = 9;
  @Deprecated
  public static final Parser<FileOptions> PARSER = new DescriptorProtos.FileOptions.1();
  public static final int PHP_CLASS_PREFIX_FIELD_NUMBER = 40;
  public static final int PHP_GENERIC_SERVICES_FIELD_NUMBER = 42;
  public static final int PHP_METADATA_NAMESPACE_FIELD_NUMBER = 44;
  public static final int PHP_NAMESPACE_FIELD_NUMBER = 41;
  public static final int PY_GENERIC_SERVICES_FIELD_NUMBER = 18;
  public static final int RUBY_PACKAGE_FIELD_NUMBER = 45;
  public static final int SWIFT_PREFIX_FIELD_NUMBER = 39;
  public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
  private static final FileOptions a = new FileOptions();
  private static final long serialVersionUID = 0L;
  private int bitField0_;
  private boolean ccEnableArenas_;
  private boolean ccGenericServices_;
  private volatile Object csharpNamespace_;
  private boolean deprecated_;
  private volatile Object goPackage_;
  private boolean javaGenerateEqualsAndHash_;
  private boolean javaGenericServices_;
  private boolean javaMultipleFiles_;
  private volatile Object javaOuterClassname_;
  private volatile Object javaPackage_;
  private boolean javaStringCheckUtf8_;
  private byte memoizedIsInitialized = -1;
  private volatile Object objcClassPrefix_;
  private int optimizeFor_;
  private volatile Object phpClassPrefix_;
  private boolean phpGenericServices_;
  private volatile Object phpMetadataNamespace_;
  private volatile Object phpNamespace_;
  private boolean pyGenericServices_;
  private volatile Object rubyPackage_;
  private volatile Object swiftPrefix_;
  private List<DescriptorProtos.UninterpretedOption> uninterpretedOption_;
  
  private DescriptorProtos$FileOptions()
  {
    this.javaPackage_ = "";
    this.javaOuterClassname_ = "";
    this.optimizeFor_ = 1;
    this.goPackage_ = "";
    this.objcClassPrefix_ = "";
    this.csharpNamespace_ = "";
    this.swiftPrefix_ = "";
    this.phpClassPrefix_ = "";
    this.phpNamespace_ = "";
    this.phpMetadataNamespace_ = "";
    this.rubyPackage_ = "";
    this.uninterpretedOption_ = Collections.emptyList();
  }
  
  /* Error */
  private DescriptorProtos$FileOptions(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 93	com/google/protobuf/DescriptorProtos$FileOptions:<init>	()V
    //   4: aload_2
    //   5: ifnull +1419 -> 1424
    //   8: invokestatic 146	com/google/protobuf/UnknownFieldSet:a	()Lcom/google/protobuf/UnknownFieldSet$Builder;
    //   11: astore 10
    //   13: iconst_0
    //   14: istore 8
    //   16: iconst_0
    //   17: istore_3
    //   18: iload 8
    //   20: ifne +1372 -> 1392
    //   23: iload_3
    //   24: istore 5
    //   26: iload_3
    //   27: istore 6
    //   29: iload_3
    //   30: istore 7
    //   32: aload_1
    //   33: invokevirtual 151	com/google/protobuf/CodedInputStream:a	()I
    //   36: istore 4
    //   38: iload 4
    //   40: lookupswitch	default:+1400->1440, 0:+1271->1311, 10:+1219->1259, 66:+1167->1207, 72:+1075->1115, 80:+1036->1076, 90:+983->1023, 128:+942->982, 136:+901->941, 144:+860->900, 160:+820->860, 184:+779->819, 216:+739->779, 248:+698->738, 290:+644->684, 298:+590->630, 314:+537->577, 322:+484->524, 330:+431->471, 336:+390->430, 354:+337->377, 362:+284->324, 7994:+212->252
    //   229: istore 5
    //   231: iload_3
    //   232: istore 6
    //   234: iload_3
    //   235: istore 7
    //   237: aload_0
    //   238: aload_1
    //   239: aload 10
    //   241: aload_2
    //   242: iload 4
    //   244: invokevirtual 155	com/google/protobuf/DescriptorProtos$FileOptions:parseUnknownField	(Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/UnknownFieldSet$Builder;Lcom/google/protobuf/ExtensionRegistryLite;I)Z
    //   247: istore 9
    //   249: goto +1068 -> 1317
    //   252: iload_3
    //   253: istore 4
    //   255: iload_3
    //   256: ldc 156
    //   258: iand
    //   259: ifne +29 -> 288
    //   262: iload_3
    //   263: istore 5
    //   265: iload_3
    //   266: istore 6
    //   268: iload_3
    //   269: istore 7
    //   271: aload_0
    //   272: new 158	java/util/ArrayList
    //   275: dup
    //   276: invokespecial 159	java/util/ArrayList:<init>	()V
    //   279: putfield 136	com/google/protobuf/DescriptorProtos$FileOptions:uninterpretedOption_	Ljava/util/List;
    //   282: iload_3
    //   283: ldc 156
    //   285: ior
    //   286: istore 4
    //   288: iload 4
    //   290: istore 5
    //   292: iload 4
    //   294: istore 6
    //   296: iload 4
    //   298: istore 7
    //   300: aload_0
    //   301: getfield 136	com/google/protobuf/DescriptorProtos$FileOptions:uninterpretedOption_	Ljava/util/List;
    //   304: aload_1
    //   305: getstatic 162	com/google/protobuf/DescriptorProtos$UninterpretedOption:PARSER	Lcom/google/protobuf/Parser;
    //   308: aload_2
    //   309: invokevirtual 165	com/google/protobuf/CodedInputStream:a	(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   312: invokeinterface 171 2 0
    //   317: pop
    //   318: iload 4
    //   320: istore_3
    //   321: goto -303 -> 18
    //   324: iload_3
    //   325: istore 5
    //   327: iload_3
    //   328: istore 6
    //   330: iload_3
    //   331: istore 7
    //   333: aload_1
    //   334: invokevirtual 175	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   337: astore 11
    //   339: iload_3
    //   340: istore 5
    //   342: iload_3
    //   343: istore 6
    //   345: iload_3
    //   346: istore 7
    //   348: aload_0
    //   349: aload_0
    //   350: getfield 177	com/google/protobuf/DescriptorProtos$FileOptions:bitField0_	I
    //   353: ldc 178
    //   355: ior
    //   356: putfield 177	com/google/protobuf/DescriptorProtos$FileOptions:bitField0_	I
    //   359: iload_3
    //   360: istore 5
    //   362: iload_3
    //   363: istore 6
    //   365: iload_3
    //   366: istore 7
    //   368: aload_0
    //   369: aload 11
    //   371: putfield 128	com/google/protobuf/DescriptorProtos$FileOptions:rubyPackage_	Ljava/lang/Object;
    //   374: goto -356 -> 18
    //   377: iload_3
    //   378: istore 5
    //   380: iload_3
    //   381: istore 6
    //   383: iload_3
    //   384: istore 7
    //   386: aload_1
    //   387: invokevirtual 175	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   390: astore 11
    //   392: iload_3
    //   393: istore 5
    //   395: iload_3
    //   396: istore 6
    //   398: iload_3
    //   399: istore 7
    //   401: aload_0
    //   402: aload_0
    //   403: getfield 177	com/google/protobuf/DescriptorProtos$FileOptions:bitField0_	I
    //   406: ldc 179
    //   408: ior
    //   409: putfield 177	com/google/protobuf/DescriptorProtos$FileOptions:bitField0_	I
    //   412: iload_3
    //   413: istore 5
    //   415: iload_3
    //   416: istore 6
    //   418: iload_3
    //   419: istore 7
    //   421: aload_0
    //   422: aload 11
    //   424: putfield 126	com/google/protobuf/DescriptorProtos$FileOptions:phpMetadataNamespace_	Ljava/lang/Object;
    //   427: goto -409 -> 18
    //   430: iload_3
    //   431: istore 5
    //   433: iload_3
    //   434: istore 6
    //   436: iload_3
    //   437: istore 7
    //   439: aload_0
    //   440: aload_0
    //   441: getfield 177	com/google/protobuf/DescriptorProtos$FileOptions:bitField0_	I
    //   444: sipush 1024
    //   447: ior
    //   448: putfield 177	com/google/protobuf/DescriptorProtos$FileOptions:bitField0_	I
    //   451: iload_3
    //   452: istore 5
    //   454: iload_3
    //   455: istore 6
    //   457: iload_3
    //   458: istore 7
    //   460: aload_0
    //   461: aload_1
    //   462: invokevirtual 183	com/google/protobuf/CodedInputStream:i	()Z
    //   465: putfield 185	com/google/protobuf/DescriptorProtos$FileOptions:phpGenericServices_	Z
    //   468: goto -450 -> 18
    //   471: iload_3
    //   472: istore 5
    //   474: iload_3
    //   475: istore 6
    //   477: iload_3
    //   478: istore 7
    //   480: aload_1
    //   481: invokevirtual 175	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   484: astore 11
    //   486: iload_3
    //   487: istore 5
    //   489: iload_3
    //   490: istore 6
    //   492: iload_3
    //   493: istore 7
    //   495: aload_0
    //   496: aload_0
    //   497: getfield 177	com/google/protobuf/DescriptorProtos$FileOptions:bitField0_	I
    //   500: ldc 186
    //   502: ior
    //   503: putfield 177	com/google/protobuf/DescriptorProtos$FileOptions:bitField0_	I
    //   506: iload_3
    //   507: istore 5
    //   509: iload_3
    //   510: istore 6
    //   512: iload_3
    //   513: istore 7
    //   515: aload_0
    //   516: aload 11
    //   518: putfield 124	com/google/protobuf/DescriptorProtos$FileOptions:phpNamespace_	Ljava/lang/Object;
    //   521: goto -503 -> 18
    //   524: iload_3
    //   525: istore 5
    //   527: iload_3
    //   528: istore 6
    //   530: iload_3
    //   531: istore 7
    //   533: aload_1
    //   534: invokevirtual 175	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   537: astore 11
    //   539: iload_3
    //   540: istore 5
    //   542: iload_3
    //   543: istore 6
    //   545: iload_3
    //   546: istore 7
    //   548: aload_0
    //   549: aload_0
    //   550: getfield 177	com/google/protobuf/DescriptorProtos$FileOptions:bitField0_	I
    //   553: ldc 187
    //   555: ior
    //   556: putfield 177	com/google/protobuf/DescriptorProtos$FileOptions:bitField0_	I
    //   559: iload_3
    //   560: istore 5
    //   562: iload_3
    //   563: istore 6
    //   565: iload_3
    //   566: istore 7
    //   568: aload_0
    //   569: aload 11
    //   571: putfield 122	com/google/protobuf/DescriptorProtos$FileOptions:phpClassPrefix_	Ljava/lang/Object;
    //   574: goto -556 -> 18
    //   577: iload_3
    //   578: istore 5
    //   580: iload_3
    //   581: istore 6
    //   583: iload_3
    //   584: istore 7
    //   586: aload_1
    //   587: invokevirtual 175	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   590: astore 11
    //   592: iload_3
    //   593: istore 5
    //   595: iload_3
    //   596: istore 6
    //   598: iload_3
    //   599: istore 7
    //   601: aload_0
    //   602: aload_0
    //   603: getfield 177	com/google/protobuf/DescriptorProtos$FileOptions:bitField0_	I
    //   606: ldc 188
    //   608: ior
    //   609: putfield 177	com/google/protobuf/DescriptorProtos$FileOptions:bitField0_	I
    //   612: iload_3
    //   613: istore 5
    //   615: iload_3
    //   616: istore 6
    //   618: iload_3
    //   619: istore 7
    //   621: aload_0
    //   622: aload 11
    //   624: putfield 120	com/google/protobuf/DescriptorProtos$FileOptions:swiftPrefix_	Ljava/lang/Object;
    //   627: goto -609 -> 18
    //   630: iload_3
    //   631: istore 5
    //   633: iload_3
    //   634: istore 6
    //   636: iload_3
    //   637: istore 7
    //   639: aload_1
    //   640: invokevirtual 175	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   643: astore 11
    //   645: iload_3
    //   646: istore 5
    //   648: iload_3
    //   649: istore 6
    //   651: iload_3
    //   652: istore 7
    //   654: aload_0
    //   655: aload_0
    //   656: getfield 177	com/google/protobuf/DescriptorProtos$FileOptions:bitField0_	I
    //   659: sipush 16384
    //   662: ior
    //   663: putfield 177	com/google/protobuf/DescriptorProtos$FileOptions:bitField0_	I
    //   666: iload_3
    //   667: istore 5
    //   669: iload_3
    //   670: istore 6
    //   672: iload_3
    //   673: istore 7
    //   675: aload_0
    //   676: aload 11
    //   678: putfield 118	com/google/protobuf/DescriptorProtos$FileOptions:csharpNamespace_	Ljava/lang/Object;
    //   681: goto -663 -> 18
    //   684: iload_3
    //   685: istore 5
    //   687: iload_3
    //   688: istore 6
    //   690: iload_3
    //   691: istore 7
    //   693: aload_1
    //   694: invokevirtual 175	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   697: astore 11
    //   699: iload_3
    //   700: istore 5
    //   702: iload_3
    //   703: istore 6
    //   705: iload_3
    //   706: istore 7
    //   708: aload_0
    //   709: aload_0
    //   710: getfield 177	com/google/protobuf/DescriptorProtos$FileOptions:bitField0_	I
    //   713: sipush 8192
    //   716: ior
    //   717: putfield 177	com/google/protobuf/DescriptorProtos$FileOptions:bitField0_	I
    //   720: iload_3
    //   721: istore 5
    //   723: iload_3
    //   724: istore 6
    //   726: iload_3
    //   727: istore 7
    //   729: aload_0
    //   730: aload 11
    //   732: putfield 116	com/google/protobuf/DescriptorProtos$FileOptions:objcClassPrefix_	Ljava/lang/Object;
    //   735: goto -717 -> 18
    //   738: iload_3
    //   739: istore 5
    //   741: iload_3
    //   742: istore 6
    //   744: iload_3
    //   745: istore 7
    //   747: aload_0
    //   748: aload_0
    //   749: getfield 177	com/google/protobuf/DescriptorProtos$FileOptions:bitField0_	I
    //   752: sipush 4096
    //   755: ior
    //   756: putfield 177	com/google/protobuf/DescriptorProtos$FileOptions:bitField0_	I
    //   759: iload_3
    //   760: istore 5
    //   762: iload_3
    //   763: istore 6
    //   765: iload_3
    //   766: istore 7
    //   768: aload_0
    //   769: aload_1
    //   770: invokevirtual 183	com/google/protobuf/CodedInputStream:i	()Z
    //   773: putfield 190	com/google/protobuf/DescriptorProtos$FileOptions:ccEnableArenas_	Z
    //   776: goto -758 -> 18
    //   779: iload_3
    //   780: istore 5
    //   782: iload_3
    //   783: istore 6
    //   785: iload_3
    //   786: istore 7
    //   788: aload_0
    //   789: aload_0
    //   790: getfield 177	com/google/protobuf/DescriptorProtos$FileOptions:bitField0_	I
    //   793: bipush 16
    //   795: ior
    //   796: putfield 177	com/google/protobuf/DescriptorProtos$FileOptions:bitField0_	I
    //   799: iload_3
    //   800: istore 5
    //   802: iload_3
    //   803: istore 6
    //   805: iload_3
    //   806: istore 7
    //   808: aload_0
    //   809: aload_1
    //   810: invokevirtual 183	com/google/protobuf/CodedInputStream:i	()Z
    //   813: putfield 192	com/google/protobuf/DescriptorProtos$FileOptions:javaStringCheckUtf8_	Z
    //   816: goto -798 -> 18
    //   819: iload_3
    //   820: istore 5
    //   822: iload_3
    //   823: istore 6
    //   825: iload_3
    //   826: istore 7
    //   828: aload_0
    //   829: aload_0
    //   830: getfield 177	com/google/protobuf/DescriptorProtos$FileOptions:bitField0_	I
    //   833: sipush 2048
    //   836: ior
    //   837: putfield 177	com/google/protobuf/DescriptorProtos$FileOptions:bitField0_	I
    //   840: iload_3
    //   841: istore 5
    //   843: iload_3
    //   844: istore 6
    //   846: iload_3
    //   847: istore 7
    //   849: aload_0
    //   850: aload_1
    //   851: invokevirtual 183	com/google/protobuf/CodedInputStream:i	()Z
    //   854: putfield 194	com/google/protobuf/DescriptorProtos$FileOptions:deprecated_	Z
    //   857: goto -839 -> 18
    //   860: iload_3
    //   861: istore 5
    //   863: iload_3
    //   864: istore 6
    //   866: iload_3
    //   867: istore 7
    //   869: aload_0
    //   870: aload_0
    //   871: getfield 177	com/google/protobuf/DescriptorProtos$FileOptions:bitField0_	I
    //   874: bipush 8
    //   876: ior
    //   877: putfield 177	com/google/protobuf/DescriptorProtos$FileOptions:bitField0_	I
    //   880: iload_3
    //   881: istore 5
    //   883: iload_3
    //   884: istore 6
    //   886: iload_3
    //   887: istore 7
    //   889: aload_0
    //   890: aload_1
    //   891: invokevirtual 183	com/google/protobuf/CodedInputStream:i	()Z
    //   894: putfield 196	com/google/protobuf/DescriptorProtos$FileOptions:javaGenerateEqualsAndHash_	Z
    //   897: goto -879 -> 18
    //   900: iload_3
    //   901: istore 5
    //   903: iload_3
    //   904: istore 6
    //   906: iload_3
    //   907: istore 7
    //   909: aload_0
    //   910: aload_0
    //   911: getfield 177	com/google/protobuf/DescriptorProtos$FileOptions:bitField0_	I
    //   914: sipush 512
    //   917: ior
    //   918: putfield 177	com/google/protobuf/DescriptorProtos$FileOptions:bitField0_	I
    //   921: iload_3
    //   922: istore 5
    //   924: iload_3
    //   925: istore 6
    //   927: iload_3
    //   928: istore 7
    //   930: aload_0
    //   931: aload_1
    //   932: invokevirtual 183	com/google/protobuf/CodedInputStream:i	()Z
    //   935: putfield 198	com/google/protobuf/DescriptorProtos$FileOptions:pyGenericServices_	Z
    //   938: goto -920 -> 18
    //   941: iload_3
    //   942: istore 5
    //   944: iload_3
    //   945: istore 6
    //   947: iload_3
    //   948: istore 7
    //   950: aload_0
    //   951: aload_0
    //   952: getfield 177	com/google/protobuf/DescriptorProtos$FileOptions:bitField0_	I
    //   955: sipush 256
    //   958: ior
    //   959: putfield 177	com/google/protobuf/DescriptorProtos$FileOptions:bitField0_	I
    //   962: iload_3
    //   963: istore 5
    //   965: iload_3
    //   966: istore 6
    //   968: iload_3
    //   969: istore 7
    //   971: aload_0
    //   972: aload_1
    //   973: invokevirtual 183	com/google/protobuf/CodedInputStream:i	()Z
    //   976: putfield 200	com/google/protobuf/DescriptorProtos$FileOptions:javaGenericServices_	Z
    //   979: goto -961 -> 18
    //   982: iload_3
    //   983: istore 5
    //   985: iload_3
    //   986: istore 6
    //   988: iload_3
    //   989: istore 7
    //   991: aload_0
    //   992: aload_0
    //   993: getfield 177	com/google/protobuf/DescriptorProtos$FileOptions:bitField0_	I
    //   996: sipush 128
    //   999: ior
    //   1000: putfield 177	com/google/protobuf/DescriptorProtos$FileOptions:bitField0_	I
    //   1003: iload_3
    //   1004: istore 5
    //   1006: iload_3
    //   1007: istore 6
    //   1009: iload_3
    //   1010: istore 7
    //   1012: aload_0
    //   1013: aload_1
    //   1014: invokevirtual 183	com/google/protobuf/CodedInputStream:i	()Z
    //   1017: putfield 202	com/google/protobuf/DescriptorProtos$FileOptions:ccGenericServices_	Z
    //   1020: goto -1002 -> 18
    //   1023: iload_3
    //   1024: istore 5
    //   1026: iload_3
    //   1027: istore 6
    //   1029: iload_3
    //   1030: istore 7
    //   1032: aload_1
    //   1033: invokevirtual 175	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   1036: astore 11
    //   1038: iload_3
    //   1039: istore 5
    //   1041: iload_3
    //   1042: istore 6
    //   1044: iload_3
    //   1045: istore 7
    //   1047: aload_0
    //   1048: aload_0
    //   1049: getfield 177	com/google/protobuf/DescriptorProtos$FileOptions:bitField0_	I
    //   1052: bipush 64
    //   1054: ior
    //   1055: putfield 177	com/google/protobuf/DescriptorProtos$FileOptions:bitField0_	I
    //   1058: iload_3
    //   1059: istore 5
    //   1061: iload_3
    //   1062: istore 6
    //   1064: iload_3
    //   1065: istore 7
    //   1067: aload_0
    //   1068: aload 11
    //   1070: putfield 114	com/google/protobuf/DescriptorProtos$FileOptions:goPackage_	Ljava/lang/Object;
    //   1073: goto -1055 -> 18
    //   1076: iload_3
    //   1077: istore 5
    //   1079: iload_3
    //   1080: istore 6
    //   1082: iload_3
    //   1083: istore 7
    //   1085: aload_0
    //   1086: aload_0
    //   1087: getfield 177	com/google/protobuf/DescriptorProtos$FileOptions:bitField0_	I
    //   1090: iconst_4
    //   1091: ior
    //   1092: putfield 177	com/google/protobuf/DescriptorProtos$FileOptions:bitField0_	I
    //   1095: iload_3
    //   1096: istore 5
    //   1098: iload_3
    //   1099: istore 6
    //   1101: iload_3
    //   1102: istore 7
    //   1104: aload_0
    //   1105: aload_1
    //   1106: invokevirtual 183	com/google/protobuf/CodedInputStream:i	()Z
    //   1109: putfield 204	com/google/protobuf/DescriptorProtos$FileOptions:javaMultipleFiles_	Z
    //   1112: goto -1094 -> 18
    //   1115: iload_3
    //   1116: istore 5
    //   1118: iload_3
    //   1119: istore 6
    //   1121: iload_3
    //   1122: istore 7
    //   1124: aload_1
    //   1125: invokevirtual 207	com/google/protobuf/CodedInputStream:n	()I
    //   1128: istore 4
    //   1130: iload_3
    //   1131: istore 5
    //   1133: iload_3
    //   1134: istore 6
    //   1136: iload_3
    //   1137: istore 7
    //   1139: iload 4
    //   1141: invokestatic 213	com/google/protobuf/DescriptorProtos$FileOptions$OptimizeMode:valueOf	(I)Lcom/google/protobuf/DescriptorProtos$FileOptions$OptimizeMode;
    //   1144: ifnonnull +25 -> 1169
    //   1147: iload_3
    //   1148: istore 5
    //   1150: iload_3
    //   1151: istore 6
    //   1153: iload_3
    //   1154: istore 7
    //   1156: aload 10
    //   1158: bipush 9
    //   1160: iload 4
    //   1162: invokevirtual 218	com/google/protobuf/UnknownFieldSet$Builder:a	(II)Lcom/google/protobuf/UnknownFieldSet$Builder;
    //   1165: pop
    //   1166: goto -1148 -> 18
    //   1169: iload_3
    //   1170: istore 5
    //   1172: iload_3
    //   1173: istore 6
    //   1175: iload_3
    //   1176: istore 7
    //   1178: aload_0
    //   1179: aload_0
    //   1180: getfield 177	com/google/protobuf/DescriptorProtos$FileOptions:bitField0_	I
    //   1183: bipush 32
    //   1185: ior
    //   1186: putfield 177	com/google/protobuf/DescriptorProtos$FileOptions:bitField0_	I
    //   1189: iload_3
    //   1190: istore 5
    //   1192: iload_3
    //   1193: istore 6
    //   1195: iload_3
    //   1196: istore 7
    //   1198: aload_0
    //   1199: iload 4
    //   1201: putfield 112	com/google/protobuf/DescriptorProtos$FileOptions:optimizeFor_	I
    //   1204: goto -1186 -> 18
    //   1207: iload_3
    //   1208: istore 5
    //   1210: iload_3
    //   1211: istore 6
    //   1213: iload_3
    //   1214: istore 7
    //   1216: aload_1
    //   1217: invokevirtual 175	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   1220: astore 11
    //   1222: iload_3
    //   1223: istore 5
    //   1225: iload_3
    //   1226: istore 6
    //   1228: iload_3
    //   1229: istore 7
    //   1231: aload_0
    //   1232: aload_0
    //   1233: getfield 177	com/google/protobuf/DescriptorProtos$FileOptions:bitField0_	I
    //   1236: iconst_2
    //   1237: ior
    //   1238: putfield 177	com/google/protobuf/DescriptorProtos$FileOptions:bitField0_	I
    //   1241: iload_3
    //   1242: istore 5
    //   1244: iload_3
    //   1245: istore 6
    //   1247: iload_3
    //   1248: istore 7
    //   1250: aload_0
    //   1251: aload 11
    //   1253: putfield 110	com/google/protobuf/DescriptorProtos$FileOptions:javaOuterClassname_	Ljava/lang/Object;
    //   1256: goto -1238 -> 18
    //   1259: iload_3
    //   1260: istore 5
    //   1262: iload_3
    //   1263: istore 6
    //   1265: iload_3
    //   1266: istore 7
    //   1268: aload_1
    //   1269: invokevirtual 175	com/google/protobuf/CodedInputStream:l	()Lcom/google/protobuf/ByteString;
    //   1272: astore 11
    //   1274: iload_3
    //   1275: istore 5
    //   1277: iload_3
    //   1278: istore 6
    //   1280: iload_3
    //   1281: istore 7
    //   1283: aload_0
    //   1284: iconst_1
    //   1285: aload_0
    //   1286: getfield 177	com/google/protobuf/DescriptorProtos$FileOptions:bitField0_	I
    //   1289: ior
    //   1290: putfield 177	com/google/protobuf/DescriptorProtos$FileOptions:bitField0_	I
    //   1293: iload_3
    //   1294: istore 5
    //   1296: iload_3
    //   1297: istore 6
    //   1299: iload_3
    //   1300: istore 7
    //   1302: aload_0
    //   1303: aload 11
    //   1305: putfield 108	com/google/protobuf/DescriptorProtos$FileOptions:javaPackage_	Ljava/lang/Object;
    //   1308: goto -1290 -> 18
    //   1311: iconst_1
    //   1312: istore 8
    //   1314: goto -1296 -> 18
    //   1317: iload 9
    //   1319: ifne -1301 -> 18
    //   1322: goto -11 -> 1311
    //   1325: astore_1
    //   1326: goto +32 -> 1358
    //   1329: astore_1
    //   1330: iload 6
    //   1332: istore 5
    //   1334: new 139	com/google/protobuf/InvalidProtocolBufferException
    //   1337: dup
    //   1338: aload_1
    //   1339: invokespecial 221	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/io/IOException;)V
    //   1342: aload_0
    //   1343: invokevirtual 225	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   1346: athrow
    //   1347: astore_1
    //   1348: iload 7
    //   1350: istore 5
    //   1352: aload_1
    //   1353: aload_0
    //   1354: invokevirtual 225	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   1357: athrow
    //   1358: iload 5
    //   1360: ldc 156
    //   1362: iand
    //   1363: ifeq +14 -> 1377
    //   1366: aload_0
    //   1367: aload_0
    //   1368: getfield 136	com/google/protobuf/DescriptorProtos$FileOptions:uninterpretedOption_	Ljava/util/List;
    //   1371: invokestatic 229	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   1374: putfield 136	com/google/protobuf/DescriptorProtos$FileOptions:uninterpretedOption_	Ljava/util/List;
    //   1377: aload_0
    //   1378: aload 10
    //   1380: invokevirtual 232	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   1383: putfield 236	com/google/protobuf/DescriptorProtos$FileOptions:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   1386: aload_0
    //   1387: invokevirtual 239	com/google/protobuf/DescriptorProtos$FileOptions:makeExtensionsImmutable	()V
    //   1390: aload_1
    //   1391: athrow
    //   1392: iload_3
    //   1393: ldc 156
    //   1395: iand
    //   1396: ifeq +14 -> 1410
    //   1399: aload_0
    //   1400: aload_0
    //   1401: getfield 136	com/google/protobuf/DescriptorProtos$FileOptions:uninterpretedOption_	Ljava/util/List;
    //   1404: invokestatic 229	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   1407: putfield 136	com/google/protobuf/DescriptorProtos$FileOptions:uninterpretedOption_	Ljava/util/List;
    //   1410: aload_0
    //   1411: aload 10
    //   1413: invokevirtual 232	com/google/protobuf/UnknownFieldSet$Builder:a	()Lcom/google/protobuf/UnknownFieldSet;
    //   1416: putfield 236	com/google/protobuf/DescriptorProtos$FileOptions:unknownFields	Lcom/google/protobuf/UnknownFieldSet;
    //   1419: aload_0
    //   1420: invokevirtual 239	com/google/protobuf/DescriptorProtos$FileOptions:makeExtensionsImmutable	()V
    //   1423: return
    //   1424: new 241	java/lang/NullPointerException
    //   1427: dup
    //   1428: invokespecial 242	java/lang/NullPointerException:<init>	()V
    //   1431: astore_1
    //   1432: goto +5 -> 1437
    //   1435: aload_1
    //   1436: athrow
    //   1437: goto -2 -> 1435
    //   1440: goto -1212 -> 228
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1443	0	this	FileOptions
    //   0	1443	1	paramCodedInputStream	CodedInputStream
    //   0	1443	2	paramExtensionRegistryLite	ExtensionRegistryLite
    //   17	1379	3	i	int
    //   36	1164	4	j	int
    //   24	1339	5	k	int
    //   27	1304	6	m	int
    //   30	1319	7	n	int
    //   14	1299	8	i1	int
    //   247	1071	9	bool	boolean
    //   11	1401	10	localBuilder	UnknownFieldSet.Builder
    //   337	967	11	localByteString	ByteString
    // Exception table:
    //   from	to	target	type
    //   32	38	1325	finally
    //   237	249	1325	finally
    //   271	282	1325	finally
    //   300	318	1325	finally
    //   333	339	1325	finally
    //   348	359	1325	finally
    //   368	374	1325	finally
    //   386	392	1325	finally
    //   401	412	1325	finally
    //   421	427	1325	finally
    //   439	451	1325	finally
    //   460	468	1325	finally
    //   480	486	1325	finally
    //   495	506	1325	finally
    //   515	521	1325	finally
    //   533	539	1325	finally
    //   548	559	1325	finally
    //   568	574	1325	finally
    //   586	592	1325	finally
    //   601	612	1325	finally
    //   621	627	1325	finally
    //   639	645	1325	finally
    //   654	666	1325	finally
    //   675	681	1325	finally
    //   693	699	1325	finally
    //   708	720	1325	finally
    //   729	735	1325	finally
    //   747	759	1325	finally
    //   768	776	1325	finally
    //   788	799	1325	finally
    //   808	816	1325	finally
    //   828	840	1325	finally
    //   849	857	1325	finally
    //   869	880	1325	finally
    //   889	897	1325	finally
    //   909	921	1325	finally
    //   930	938	1325	finally
    //   950	962	1325	finally
    //   971	979	1325	finally
    //   991	1003	1325	finally
    //   1012	1020	1325	finally
    //   1032	1038	1325	finally
    //   1047	1058	1325	finally
    //   1067	1073	1325	finally
    //   1085	1095	1325	finally
    //   1104	1112	1325	finally
    //   1124	1130	1325	finally
    //   1139	1147	1325	finally
    //   1156	1166	1325	finally
    //   1178	1189	1325	finally
    //   1198	1204	1325	finally
    //   1216	1222	1325	finally
    //   1231	1241	1325	finally
    //   1250	1256	1325	finally
    //   1268	1274	1325	finally
    //   1283	1293	1325	finally
    //   1302	1308	1325	finally
    //   1334	1347	1325	finally
    //   1352	1358	1325	finally
    //   32	38	1329	java/io/IOException
    //   237	249	1329	java/io/IOException
    //   271	282	1329	java/io/IOException
    //   300	318	1329	java/io/IOException
    //   333	339	1329	java/io/IOException
    //   348	359	1329	java/io/IOException
    //   368	374	1329	java/io/IOException
    //   386	392	1329	java/io/IOException
    //   401	412	1329	java/io/IOException
    //   421	427	1329	java/io/IOException
    //   439	451	1329	java/io/IOException
    //   460	468	1329	java/io/IOException
    //   480	486	1329	java/io/IOException
    //   495	506	1329	java/io/IOException
    //   515	521	1329	java/io/IOException
    //   533	539	1329	java/io/IOException
    //   548	559	1329	java/io/IOException
    //   568	574	1329	java/io/IOException
    //   586	592	1329	java/io/IOException
    //   601	612	1329	java/io/IOException
    //   621	627	1329	java/io/IOException
    //   639	645	1329	java/io/IOException
    //   654	666	1329	java/io/IOException
    //   675	681	1329	java/io/IOException
    //   693	699	1329	java/io/IOException
    //   708	720	1329	java/io/IOException
    //   729	735	1329	java/io/IOException
    //   747	759	1329	java/io/IOException
    //   768	776	1329	java/io/IOException
    //   788	799	1329	java/io/IOException
    //   808	816	1329	java/io/IOException
    //   828	840	1329	java/io/IOException
    //   849	857	1329	java/io/IOException
    //   869	880	1329	java/io/IOException
    //   889	897	1329	java/io/IOException
    //   909	921	1329	java/io/IOException
    //   930	938	1329	java/io/IOException
    //   950	962	1329	java/io/IOException
    //   971	979	1329	java/io/IOException
    //   991	1003	1329	java/io/IOException
    //   1012	1020	1329	java/io/IOException
    //   1032	1038	1329	java/io/IOException
    //   1047	1058	1329	java/io/IOException
    //   1067	1073	1329	java/io/IOException
    //   1085	1095	1329	java/io/IOException
    //   1104	1112	1329	java/io/IOException
    //   1124	1130	1329	java/io/IOException
    //   1139	1147	1329	java/io/IOException
    //   1156	1166	1329	java/io/IOException
    //   1178	1189	1329	java/io/IOException
    //   1198	1204	1329	java/io/IOException
    //   1216	1222	1329	java/io/IOException
    //   1231	1241	1329	java/io/IOException
    //   1250	1256	1329	java/io/IOException
    //   1268	1274	1329	java/io/IOException
    //   1283	1293	1329	java/io/IOException
    //   1302	1308	1329	java/io/IOException
    //   32	38	1347	com/google/protobuf/InvalidProtocolBufferException
    //   237	249	1347	com/google/protobuf/InvalidProtocolBufferException
    //   271	282	1347	com/google/protobuf/InvalidProtocolBufferException
    //   300	318	1347	com/google/protobuf/InvalidProtocolBufferException
    //   333	339	1347	com/google/protobuf/InvalidProtocolBufferException
    //   348	359	1347	com/google/protobuf/InvalidProtocolBufferException
    //   368	374	1347	com/google/protobuf/InvalidProtocolBufferException
    //   386	392	1347	com/google/protobuf/InvalidProtocolBufferException
    //   401	412	1347	com/google/protobuf/InvalidProtocolBufferException
    //   421	427	1347	com/google/protobuf/InvalidProtocolBufferException
    //   439	451	1347	com/google/protobuf/InvalidProtocolBufferException
    //   460	468	1347	com/google/protobuf/InvalidProtocolBufferException
    //   480	486	1347	com/google/protobuf/InvalidProtocolBufferException
    //   495	506	1347	com/google/protobuf/InvalidProtocolBufferException
    //   515	521	1347	com/google/protobuf/InvalidProtocolBufferException
    //   533	539	1347	com/google/protobuf/InvalidProtocolBufferException
    //   548	559	1347	com/google/protobuf/InvalidProtocolBufferException
    //   568	574	1347	com/google/protobuf/InvalidProtocolBufferException
    //   586	592	1347	com/google/protobuf/InvalidProtocolBufferException
    //   601	612	1347	com/google/protobuf/InvalidProtocolBufferException
    //   621	627	1347	com/google/protobuf/InvalidProtocolBufferException
    //   639	645	1347	com/google/protobuf/InvalidProtocolBufferException
    //   654	666	1347	com/google/protobuf/InvalidProtocolBufferException
    //   675	681	1347	com/google/protobuf/InvalidProtocolBufferException
    //   693	699	1347	com/google/protobuf/InvalidProtocolBufferException
    //   708	720	1347	com/google/protobuf/InvalidProtocolBufferException
    //   729	735	1347	com/google/protobuf/InvalidProtocolBufferException
    //   747	759	1347	com/google/protobuf/InvalidProtocolBufferException
    //   768	776	1347	com/google/protobuf/InvalidProtocolBufferException
    //   788	799	1347	com/google/protobuf/InvalidProtocolBufferException
    //   808	816	1347	com/google/protobuf/InvalidProtocolBufferException
    //   828	840	1347	com/google/protobuf/InvalidProtocolBufferException
    //   849	857	1347	com/google/protobuf/InvalidProtocolBufferException
    //   869	880	1347	com/google/protobuf/InvalidProtocolBufferException
    //   889	897	1347	com/google/protobuf/InvalidProtocolBufferException
    //   909	921	1347	com/google/protobuf/InvalidProtocolBufferException
    //   930	938	1347	com/google/protobuf/InvalidProtocolBufferException
    //   950	962	1347	com/google/protobuf/InvalidProtocolBufferException
    //   971	979	1347	com/google/protobuf/InvalidProtocolBufferException
    //   991	1003	1347	com/google/protobuf/InvalidProtocolBufferException
    //   1012	1020	1347	com/google/protobuf/InvalidProtocolBufferException
    //   1032	1038	1347	com/google/protobuf/InvalidProtocolBufferException
    //   1047	1058	1347	com/google/protobuf/InvalidProtocolBufferException
    //   1067	1073	1347	com/google/protobuf/InvalidProtocolBufferException
    //   1085	1095	1347	com/google/protobuf/InvalidProtocolBufferException
    //   1104	1112	1347	com/google/protobuf/InvalidProtocolBufferException
    //   1124	1130	1347	com/google/protobuf/InvalidProtocolBufferException
    //   1139	1147	1347	com/google/protobuf/InvalidProtocolBufferException
    //   1156	1166	1347	com/google/protobuf/InvalidProtocolBufferException
    //   1178	1189	1347	com/google/protobuf/InvalidProtocolBufferException
    //   1198	1204	1347	com/google/protobuf/InvalidProtocolBufferException
    //   1216	1222	1347	com/google/protobuf/InvalidProtocolBufferException
    //   1231	1241	1347	com/google/protobuf/InvalidProtocolBufferException
    //   1250	1256	1347	com/google/protobuf/InvalidProtocolBufferException
    //   1268	1274	1347	com/google/protobuf/InvalidProtocolBufferException
    //   1283	1293	1347	com/google/protobuf/InvalidProtocolBufferException
    //   1302	1308	1347	com/google/protobuf/InvalidProtocolBufferException
  }
  
  private DescriptorProtos$FileOptions(GeneratedMessageV3.ExtendableBuilder<FileOptions, ?> paramExtendableBuilder)
  {
    super(paramExtendableBuilder);
  }
  
  public static FileOptions getDefaultInstance()
  {
    return a;
  }
  
  public static final Descriptors.Descriptor getDescriptor()
  {
    return DescriptorProtos.B();
  }
  
  public static DescriptorProtos.FileOptions.Builder newBuilder()
  {
    return a.toBuilder();
  }
  
  public static DescriptorProtos.FileOptions.Builder newBuilder(FileOptions paramFileOptions)
  {
    return a.toBuilder().a(paramFileOptions);
  }
  
  public static FileOptions parseDelimitedFrom(InputStream paramInputStream)
  {
    return (FileOptions)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream);
  }
  
  public static FileOptions parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (FileOptions)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static FileOptions parseFrom(ByteString paramByteString)
  {
    return (FileOptions)PARSER.parseFrom(paramByteString);
  }
  
  public static FileOptions parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (FileOptions)PARSER.parseFrom(paramByteString, paramExtensionRegistryLite);
  }
  
  public static FileOptions parseFrom(CodedInputStream paramCodedInputStream)
  {
    return (FileOptions)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream);
  }
  
  public static FileOptions parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (FileOptions)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static FileOptions parseFrom(InputStream paramInputStream)
  {
    return (FileOptions)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream);
  }
  
  public static FileOptions parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (FileOptions)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static FileOptions parseFrom(ByteBuffer paramByteBuffer)
  {
    return (FileOptions)PARSER.parseFrom(paramByteBuffer);
  }
  
  public static FileOptions parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (FileOptions)PARSER.parseFrom(paramByteBuffer, paramExtensionRegistryLite);
  }
  
  public static FileOptions parseFrom(byte[] paramArrayOfByte)
  {
    return (FileOptions)PARSER.parseFrom(paramArrayOfByte);
  }
  
  public static FileOptions parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (FileOptions)PARSER.parseFrom(paramArrayOfByte, paramExtensionRegistryLite);
  }
  
  public static Parser<FileOptions> parser()
  {
    return PARSER;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof FileOptions)) {
      return super.equals(paramObject);
    }
    paramObject = (FileOptions)paramObject;
    if (hasJavaPackage() != paramObject.hasJavaPackage()) {
      return false;
    }
    if ((hasJavaPackage()) && (!getJavaPackage().equals(paramObject.getJavaPackage()))) {
      return false;
    }
    if (hasJavaOuterClassname() != paramObject.hasJavaOuterClassname()) {
      return false;
    }
    if ((hasJavaOuterClassname()) && (!getJavaOuterClassname().equals(paramObject.getJavaOuterClassname()))) {
      return false;
    }
    if (hasJavaMultipleFiles() != paramObject.hasJavaMultipleFiles()) {
      return false;
    }
    if ((hasJavaMultipleFiles()) && (getJavaMultipleFiles() != paramObject.getJavaMultipleFiles())) {
      return false;
    }
    if (hasJavaGenerateEqualsAndHash() != paramObject.hasJavaGenerateEqualsAndHash()) {
      return false;
    }
    if ((hasJavaGenerateEqualsAndHash()) && (getJavaGenerateEqualsAndHash() != paramObject.getJavaGenerateEqualsAndHash())) {
      return false;
    }
    if (hasJavaStringCheckUtf8() != paramObject.hasJavaStringCheckUtf8()) {
      return false;
    }
    if ((hasJavaStringCheckUtf8()) && (getJavaStringCheckUtf8() != paramObject.getJavaStringCheckUtf8())) {
      return false;
    }
    if (hasOptimizeFor() != paramObject.hasOptimizeFor()) {
      return false;
    }
    if ((hasOptimizeFor()) && (this.optimizeFor_ != paramObject.optimizeFor_)) {
      return false;
    }
    if (hasGoPackage() != paramObject.hasGoPackage()) {
      return false;
    }
    if ((hasGoPackage()) && (!getGoPackage().equals(paramObject.getGoPackage()))) {
      return false;
    }
    if (hasCcGenericServices() != paramObject.hasCcGenericServices()) {
      return false;
    }
    if ((hasCcGenericServices()) && (getCcGenericServices() != paramObject.getCcGenericServices())) {
      return false;
    }
    if (hasJavaGenericServices() != paramObject.hasJavaGenericServices()) {
      return false;
    }
    if ((hasJavaGenericServices()) && (getJavaGenericServices() != paramObject.getJavaGenericServices())) {
      return false;
    }
    if (hasPyGenericServices() != paramObject.hasPyGenericServices()) {
      return false;
    }
    if ((hasPyGenericServices()) && (getPyGenericServices() != paramObject.getPyGenericServices())) {
      return false;
    }
    if (hasPhpGenericServices() != paramObject.hasPhpGenericServices()) {
      return false;
    }
    if ((hasPhpGenericServices()) && (getPhpGenericServices() != paramObject.getPhpGenericServices())) {
      return false;
    }
    if (hasDeprecated() != paramObject.hasDeprecated()) {
      return false;
    }
    if ((hasDeprecated()) && (getDeprecated() != paramObject.getDeprecated())) {
      return false;
    }
    if (hasCcEnableArenas() != paramObject.hasCcEnableArenas()) {
      return false;
    }
    if ((hasCcEnableArenas()) && (getCcEnableArenas() != paramObject.getCcEnableArenas())) {
      return false;
    }
    if (hasObjcClassPrefix() != paramObject.hasObjcClassPrefix()) {
      return false;
    }
    if ((hasObjcClassPrefix()) && (!getObjcClassPrefix().equals(paramObject.getObjcClassPrefix()))) {
      return false;
    }
    if (hasCsharpNamespace() != paramObject.hasCsharpNamespace()) {
      return false;
    }
    if ((hasCsharpNamespace()) && (!getCsharpNamespace().equals(paramObject.getCsharpNamespace()))) {
      return false;
    }
    if (hasSwiftPrefix() != paramObject.hasSwiftPrefix()) {
      return false;
    }
    if ((hasSwiftPrefix()) && (!getSwiftPrefix().equals(paramObject.getSwiftPrefix()))) {
      return false;
    }
    if (hasPhpClassPrefix() != paramObject.hasPhpClassPrefix()) {
      return false;
    }
    if ((hasPhpClassPrefix()) && (!getPhpClassPrefix().equals(paramObject.getPhpClassPrefix()))) {
      return false;
    }
    if (hasPhpNamespace() != paramObject.hasPhpNamespace()) {
      return false;
    }
    if ((hasPhpNamespace()) && (!getPhpNamespace().equals(paramObject.getPhpNamespace()))) {
      return false;
    }
    if (hasPhpMetadataNamespace() != paramObject.hasPhpMetadataNamespace()) {
      return false;
    }
    if ((hasPhpMetadataNamespace()) && (!getPhpMetadataNamespace().equals(paramObject.getPhpMetadataNamespace()))) {
      return false;
    }
    if (hasRubyPackage() != paramObject.hasRubyPackage()) {
      return false;
    }
    if ((hasRubyPackage()) && (!getRubyPackage().equals(paramObject.getRubyPackage()))) {
      return false;
    }
    if (!getUninterpretedOptionList().equals(paramObject.getUninterpretedOptionList())) {
      return false;
    }
    if (!this.unknownFields.equals(paramObject.unknownFields)) {
      return false;
    }
    return getExtensionFields().equals(paramObject.getExtensionFields());
  }
  
  public boolean getCcEnableArenas()
  {
    return this.ccEnableArenas_;
  }
  
  public boolean getCcGenericServices()
  {
    return this.ccGenericServices_;
  }
  
  public String getCsharpNamespace()
  {
    Object localObject = this.csharpNamespace_;
    if ((localObject instanceof String)) {
      return (String)localObject;
    }
    localObject = (ByteString)localObject;
    String str = ((ByteString)localObject).toStringUtf8();
    if (((ByteString)localObject).isValidUtf8()) {
      this.csharpNamespace_ = str;
    }
    return str;
  }
  
  public ByteString getCsharpNamespaceBytes()
  {
    Object localObject = this.csharpNamespace_;
    if ((localObject instanceof String))
    {
      localObject = ByteString.copyFromUtf8((String)localObject);
      this.csharpNamespace_ = localObject;
      return localObject;
    }
    return (ByteString)localObject;
  }
  
  public FileOptions getDefaultInstanceForType()
  {
    return a;
  }
  
  public boolean getDeprecated()
  {
    return this.deprecated_;
  }
  
  public String getGoPackage()
  {
    Object localObject = this.goPackage_;
    if ((localObject instanceof String)) {
      return (String)localObject;
    }
    localObject = (ByteString)localObject;
    String str = ((ByteString)localObject).toStringUtf8();
    if (((ByteString)localObject).isValidUtf8()) {
      this.goPackage_ = str;
    }
    return str;
  }
  
  public ByteString getGoPackageBytes()
  {
    Object localObject = this.goPackage_;
    if ((localObject instanceof String))
    {
      localObject = ByteString.copyFromUtf8((String)localObject);
      this.goPackage_ = localObject;
      return localObject;
    }
    return (ByteString)localObject;
  }
  
  @Deprecated
  public boolean getJavaGenerateEqualsAndHash()
  {
    return this.javaGenerateEqualsAndHash_;
  }
  
  public boolean getJavaGenericServices()
  {
    return this.javaGenericServices_;
  }
  
  public boolean getJavaMultipleFiles()
  {
    return this.javaMultipleFiles_;
  }
  
  public String getJavaOuterClassname()
  {
    Object localObject = this.javaOuterClassname_;
    if ((localObject instanceof String)) {
      return (String)localObject;
    }
    localObject = (ByteString)localObject;
    String str = ((ByteString)localObject).toStringUtf8();
    if (((ByteString)localObject).isValidUtf8()) {
      this.javaOuterClassname_ = str;
    }
    return str;
  }
  
  public ByteString getJavaOuterClassnameBytes()
  {
    Object localObject = this.javaOuterClassname_;
    if ((localObject instanceof String))
    {
      localObject = ByteString.copyFromUtf8((String)localObject);
      this.javaOuterClassname_ = localObject;
      return localObject;
    }
    return (ByteString)localObject;
  }
  
  public String getJavaPackage()
  {
    Object localObject = this.javaPackage_;
    if ((localObject instanceof String)) {
      return (String)localObject;
    }
    localObject = (ByteString)localObject;
    String str = ((ByteString)localObject).toStringUtf8();
    if (((ByteString)localObject).isValidUtf8()) {
      this.javaPackage_ = str;
    }
    return str;
  }
  
  public ByteString getJavaPackageBytes()
  {
    Object localObject = this.javaPackage_;
    if ((localObject instanceof String))
    {
      localObject = ByteString.copyFromUtf8((String)localObject);
      this.javaPackage_ = localObject;
      return localObject;
    }
    return (ByteString)localObject;
  }
  
  public boolean getJavaStringCheckUtf8()
  {
    return this.javaStringCheckUtf8_;
  }
  
  public String getObjcClassPrefix()
  {
    Object localObject = this.objcClassPrefix_;
    if ((localObject instanceof String)) {
      return (String)localObject;
    }
    localObject = (ByteString)localObject;
    String str = ((ByteString)localObject).toStringUtf8();
    if (((ByteString)localObject).isValidUtf8()) {
      this.objcClassPrefix_ = str;
    }
    return str;
  }
  
  public ByteString getObjcClassPrefixBytes()
  {
    Object localObject = this.objcClassPrefix_;
    if ((localObject instanceof String))
    {
      localObject = ByteString.copyFromUtf8((String)localObject);
      this.objcClassPrefix_ = localObject;
      return localObject;
    }
    return (ByteString)localObject;
  }
  
  public DescriptorProtos.FileOptions.OptimizeMode getOptimizeFor()
  {
    DescriptorProtos.FileOptions.OptimizeMode localOptimizeMode2 = DescriptorProtos.FileOptions.OptimizeMode.valueOf(this.optimizeFor_);
    DescriptorProtos.FileOptions.OptimizeMode localOptimizeMode1 = localOptimizeMode2;
    if (localOptimizeMode2 == null) {
      localOptimizeMode1 = DescriptorProtos.FileOptions.OptimizeMode.SPEED;
    }
    return localOptimizeMode1;
  }
  
  public Parser<FileOptions> getParserForType()
  {
    return PARSER;
  }
  
  public String getPhpClassPrefix()
  {
    Object localObject = this.phpClassPrefix_;
    if ((localObject instanceof String)) {
      return (String)localObject;
    }
    localObject = (ByteString)localObject;
    String str = ((ByteString)localObject).toStringUtf8();
    if (((ByteString)localObject).isValidUtf8()) {
      this.phpClassPrefix_ = str;
    }
    return str;
  }
  
  public ByteString getPhpClassPrefixBytes()
  {
    Object localObject = this.phpClassPrefix_;
    if ((localObject instanceof String))
    {
      localObject = ByteString.copyFromUtf8((String)localObject);
      this.phpClassPrefix_ = localObject;
      return localObject;
    }
    return (ByteString)localObject;
  }
  
  public boolean getPhpGenericServices()
  {
    return this.phpGenericServices_;
  }
  
  public String getPhpMetadataNamespace()
  {
    Object localObject = this.phpMetadataNamespace_;
    if ((localObject instanceof String)) {
      return (String)localObject;
    }
    localObject = (ByteString)localObject;
    String str = ((ByteString)localObject).toStringUtf8();
    if (((ByteString)localObject).isValidUtf8()) {
      this.phpMetadataNamespace_ = str;
    }
    return str;
  }
  
  public ByteString getPhpMetadataNamespaceBytes()
  {
    Object localObject = this.phpMetadataNamespace_;
    if ((localObject instanceof String))
    {
      localObject = ByteString.copyFromUtf8((String)localObject);
      this.phpMetadataNamespace_ = localObject;
      return localObject;
    }
    return (ByteString)localObject;
  }
  
  public String getPhpNamespace()
  {
    Object localObject = this.phpNamespace_;
    if ((localObject instanceof String)) {
      return (String)localObject;
    }
    localObject = (ByteString)localObject;
    String str = ((ByteString)localObject).toStringUtf8();
    if (((ByteString)localObject).isValidUtf8()) {
      this.phpNamespace_ = str;
    }
    return str;
  }
  
  public ByteString getPhpNamespaceBytes()
  {
    Object localObject = this.phpNamespace_;
    if ((localObject instanceof String))
    {
      localObject = ByteString.copyFromUtf8((String)localObject);
      this.phpNamespace_ = localObject;
      return localObject;
    }
    return (ByteString)localObject;
  }
  
  public boolean getPyGenericServices()
  {
    return this.pyGenericServices_;
  }
  
  public String getRubyPackage()
  {
    Object localObject = this.rubyPackage_;
    if ((localObject instanceof String)) {
      return (String)localObject;
    }
    localObject = (ByteString)localObject;
    String str = ((ByteString)localObject).toStringUtf8();
    if (((ByteString)localObject).isValidUtf8()) {
      this.rubyPackage_ = str;
    }
    return str;
  }
  
  public ByteString getRubyPackageBytes()
  {
    Object localObject = this.rubyPackage_;
    if ((localObject instanceof String))
    {
      localObject = ByteString.copyFromUtf8((String)localObject);
      this.rubyPackage_ = localObject;
      return localObject;
    }
    return (ByteString)localObject;
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
      j = GeneratedMessageV3.computeStringSize(1, this.javaPackage_) + 0;
    } else {
      j = 0;
    }
    i = j;
    if ((this.bitField0_ & 0x2) != 0) {
      i = j + GeneratedMessageV3.computeStringSize(8, this.javaOuterClassname_);
    }
    int j = i;
    if ((this.bitField0_ & 0x20) != 0) {
      j = i + CodedOutputStream.m(9, this.optimizeFor_);
    }
    i = j;
    if ((this.bitField0_ & 0x4) != 0) {
      i = j + CodedOutputStream.b(10, this.javaMultipleFiles_);
    }
    j = i;
    if ((this.bitField0_ & 0x40) != 0) {
      j = i + GeneratedMessageV3.computeStringSize(11, this.goPackage_);
    }
    i = j;
    if ((this.bitField0_ & 0x80) != 0) {
      i = j + CodedOutputStream.b(16, this.ccGenericServices_);
    }
    j = i;
    if ((this.bitField0_ & 0x100) != 0) {
      j = i + CodedOutputStream.b(17, this.javaGenericServices_);
    }
    i = j;
    if ((this.bitField0_ & 0x200) != 0) {
      i = j + CodedOutputStream.b(18, this.pyGenericServices_);
    }
    j = i;
    if ((this.bitField0_ & 0x8) != 0) {
      j = i + CodedOutputStream.b(20, this.javaGenerateEqualsAndHash_);
    }
    i = j;
    if ((this.bitField0_ & 0x800) != 0) {
      i = j + CodedOutputStream.b(23, this.deprecated_);
    }
    j = i;
    if ((this.bitField0_ & 0x10) != 0) {
      j = i + CodedOutputStream.b(27, this.javaStringCheckUtf8_);
    }
    i = j;
    if ((this.bitField0_ & 0x1000) != 0) {
      i = j + CodedOutputStream.b(31, this.ccEnableArenas_);
    }
    j = i;
    if ((this.bitField0_ & 0x2000) != 0) {
      j = i + GeneratedMessageV3.computeStringSize(36, this.objcClassPrefix_);
    }
    i = j;
    if ((this.bitField0_ & 0x4000) != 0) {
      i = j + GeneratedMessageV3.computeStringSize(37, this.csharpNamespace_);
    }
    j = i;
    if ((this.bitField0_ & 0x8000) != 0) {
      j = i + GeneratedMessageV3.computeStringSize(39, this.swiftPrefix_);
    }
    i = j;
    if ((this.bitField0_ & 0x10000) != 0) {
      i = j + GeneratedMessageV3.computeStringSize(40, this.phpClassPrefix_);
    }
    j = i;
    if ((this.bitField0_ & 0x20000) != 0) {
      j = i + GeneratedMessageV3.computeStringSize(41, this.phpNamespace_);
    }
    int k = j;
    if ((this.bitField0_ & 0x400) != 0) {
      k = j + CodedOutputStream.b(42, this.phpGenericServices_);
    }
    i = k;
    if ((this.bitField0_ & 0x40000) != 0) {
      i = k + GeneratedMessageV3.computeStringSize(44, this.phpMetadataNamespace_);
    }
    j = i;
    k = m;
    if ((this.bitField0_ & 0x80000) != 0)
    {
      j = i + GeneratedMessageV3.computeStringSize(45, this.rubyPackage_);
      k = m;
    }
    while (k < this.uninterpretedOption_.size())
    {
      j += CodedOutputStream.c(999, (MessageLite)this.uninterpretedOption_.get(k));
      k += 1;
    }
    i = j + extensionsSerializedSize() + this.unknownFields.getSerializedSize();
    this.memoizedSize = i;
    return i;
  }
  
  public String getSwiftPrefix()
  {
    Object localObject = this.swiftPrefix_;
    if ((localObject instanceof String)) {
      return (String)localObject;
    }
    localObject = (ByteString)localObject;
    String str = ((ByteString)localObject).toStringUtf8();
    if (((ByteString)localObject).isValidUtf8()) {
      this.swiftPrefix_ = str;
    }
    return str;
  }
  
  public ByteString getSwiftPrefixBytes()
  {
    Object localObject = this.swiftPrefix_;
    if ((localObject instanceof String))
    {
      localObject = ByteString.copyFromUtf8((String)localObject);
      this.swiftPrefix_ = localObject;
      return localObject;
    }
    return (ByteString)localObject;
  }
  
  public DescriptorProtos.UninterpretedOption getUninterpretedOption(int paramInt)
  {
    return (DescriptorProtos.UninterpretedOption)this.uninterpretedOption_.get(paramInt);
  }
  
  public int getUninterpretedOptionCount()
  {
    return this.uninterpretedOption_.size();
  }
  
  public List<DescriptorProtos.UninterpretedOption> getUninterpretedOptionList()
  {
    return this.uninterpretedOption_;
  }
  
  public DescriptorProtos.UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int paramInt)
  {
    return (DescriptorProtos.UninterpretedOptionOrBuilder)this.uninterpretedOption_.get(paramInt);
  }
  
  public List<? extends DescriptorProtos.UninterpretedOptionOrBuilder> getUninterpretedOptionOrBuilderList()
  {
    return this.uninterpretedOption_;
  }
  
  public final UnknownFieldSet getUnknownFields()
  {
    return this.unknownFields;
  }
  
  public boolean hasCcEnableArenas()
  {
    return (this.bitField0_ & 0x1000) != 0;
  }
  
  public boolean hasCcGenericServices()
  {
    return (this.bitField0_ & 0x80) != 0;
  }
  
  public boolean hasCsharpNamespace()
  {
    return (this.bitField0_ & 0x4000) != 0;
  }
  
  public boolean hasDeprecated()
  {
    return (this.bitField0_ & 0x800) != 0;
  }
  
  public boolean hasGoPackage()
  {
    return (this.bitField0_ & 0x40) != 0;
  }
  
  @Deprecated
  public boolean hasJavaGenerateEqualsAndHash()
  {
    return (this.bitField0_ & 0x8) != 0;
  }
  
  public boolean hasJavaGenericServices()
  {
    return (this.bitField0_ & 0x100) != 0;
  }
  
  public boolean hasJavaMultipleFiles()
  {
    return (this.bitField0_ & 0x4) != 0;
  }
  
  public boolean hasJavaOuterClassname()
  {
    return (this.bitField0_ & 0x2) != 0;
  }
  
  public boolean hasJavaPackage()
  {
    return (this.bitField0_ & 0x1) != 0;
  }
  
  public boolean hasJavaStringCheckUtf8()
  {
    return (this.bitField0_ & 0x10) != 0;
  }
  
  public boolean hasObjcClassPrefix()
  {
    return (this.bitField0_ & 0x2000) != 0;
  }
  
  public boolean hasOptimizeFor()
  {
    return (this.bitField0_ & 0x20) != 0;
  }
  
  public boolean hasPhpClassPrefix()
  {
    return (this.bitField0_ & 0x10000) != 0;
  }
  
  public boolean hasPhpGenericServices()
  {
    return (this.bitField0_ & 0x400) != 0;
  }
  
  public boolean hasPhpMetadataNamespace()
  {
    return (this.bitField0_ & 0x40000) != 0;
  }
  
  public boolean hasPhpNamespace()
  {
    return (this.bitField0_ & 0x20000) != 0;
  }
  
  public boolean hasPyGenericServices()
  {
    return (this.bitField0_ & 0x200) != 0;
  }
  
  public boolean hasRubyPackage()
  {
    return (this.bitField0_ & 0x80000) != 0;
  }
  
  public boolean hasSwiftPrefix()
  {
    return (this.bitField0_ & 0x8000) != 0;
  }
  
  public int hashCode()
  {
    if (this.memoizedHashCode != 0) {
      return this.memoizedHashCode;
    }
    int j = 779 + getDescriptor().hashCode();
    int i = j;
    if (hasJavaPackage()) {
      i = (j * 37 + 1) * 53 + getJavaPackage().hashCode();
    }
    j = i;
    if (hasJavaOuterClassname()) {
      j = (i * 37 + 8) * 53 + getJavaOuterClassname().hashCode();
    }
    i = j;
    if (hasJavaMultipleFiles()) {
      i = (j * 37 + 10) * 53 + Internal.a(getJavaMultipleFiles());
    }
    j = i;
    if (hasJavaGenerateEqualsAndHash()) {
      j = (i * 37 + 20) * 53 + Internal.a(getJavaGenerateEqualsAndHash());
    }
    i = j;
    if (hasJavaStringCheckUtf8()) {
      i = (j * 37 + 27) * 53 + Internal.a(getJavaStringCheckUtf8());
    }
    j = i;
    if (hasOptimizeFor()) {
      j = (i * 37 + 9) * 53 + this.optimizeFor_;
    }
    i = j;
    if (hasGoPackage()) {
      i = (j * 37 + 11) * 53 + getGoPackage().hashCode();
    }
    j = i;
    if (hasCcGenericServices()) {
      j = (i * 37 + 16) * 53 + Internal.a(getCcGenericServices());
    }
    i = j;
    if (hasJavaGenericServices()) {
      i = (j * 37 + 17) * 53 + Internal.a(getJavaGenericServices());
    }
    j = i;
    if (hasPyGenericServices()) {
      j = (i * 37 + 18) * 53 + Internal.a(getPyGenericServices());
    }
    i = j;
    if (hasPhpGenericServices()) {
      i = (j * 37 + 42) * 53 + Internal.a(getPhpGenericServices());
    }
    j = i;
    if (hasDeprecated()) {
      j = (i * 37 + 23) * 53 + Internal.a(getDeprecated());
    }
    i = j;
    if (hasCcEnableArenas()) {
      i = (j * 37 + 31) * 53 + Internal.a(getCcEnableArenas());
    }
    j = i;
    if (hasObjcClassPrefix()) {
      j = (i * 37 + 36) * 53 + getObjcClassPrefix().hashCode();
    }
    i = j;
    if (hasCsharpNamespace()) {
      i = (j * 37 + 37) * 53 + getCsharpNamespace().hashCode();
    }
    j = i;
    if (hasSwiftPrefix()) {
      j = (i * 37 + 39) * 53 + getSwiftPrefix().hashCode();
    }
    i = j;
    if (hasPhpClassPrefix()) {
      i = (j * 37 + 40) * 53 + getPhpClassPrefix().hashCode();
    }
    j = i;
    if (hasPhpNamespace()) {
      j = (i * 37 + 41) * 53 + getPhpNamespace().hashCode();
    }
    i = j;
    if (hasPhpMetadataNamespace()) {
      i = (j * 37 + 44) * 53 + getPhpMetadataNamespace().hashCode();
    }
    j = i;
    if (hasRubyPackage()) {
      j = (i * 37 + 45) * 53 + getRubyPackage().hashCode();
    }
    i = j;
    if (getUninterpretedOptionCount() > 0) {
      i = (j * 37 + 999) * 53 + getUninterpretedOptionList().hashCode();
    }
    i = hashFields(i, getExtensionFields()) * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    return i;
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return DescriptorProtos.C().a(FileOptions.class, DescriptorProtos.FileOptions.Builder.class);
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
    while (i < getUninterpretedOptionCount())
    {
      if (!getUninterpretedOption(i).isInitialized())
      {
        this.memoizedIsInitialized = 0;
        return false;
      }
      i += 1;
    }
    if (!extensionsAreInitialized())
    {
      this.memoizedIsInitialized = 0;
      return false;
    }
    this.memoizedIsInitialized = 1;
    return true;
  }
  
  public DescriptorProtos.FileOptions.Builder newBuilderForType()
  {
    return newBuilder();
  }
  
  protected DescriptorProtos.FileOptions.Builder newBuilderForType(GeneratedMessageV3.BuilderParent paramBuilderParent)
  {
    return new DescriptorProtos.FileOptions.Builder(paramBuilderParent, null);
  }
  
  protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter paramUnusedPrivateParameter)
  {
    return new FileOptions();
  }
  
  public DescriptorProtos.FileOptions.Builder toBuilder()
  {
    if (this == a) {
      return new DescriptorProtos.FileOptions.Builder(null);
    }
    return new DescriptorProtos.FileOptions.Builder(null).a(this);
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
  {
    GeneratedMessageV3.ExtendableMessage.ExtensionWriter localExtensionWriter = newExtensionWriter();
    if ((this.bitField0_ & 0x1) != 0) {
      GeneratedMessageV3.writeString(paramCodedOutputStream, 1, this.javaPackage_);
    }
    if ((this.bitField0_ & 0x2) != 0) {
      GeneratedMessageV3.writeString(paramCodedOutputStream, 8, this.javaOuterClassname_);
    }
    if ((this.bitField0_ & 0x20) != 0) {
      paramCodedOutputStream.g(9, this.optimizeFor_);
    }
    if ((this.bitField0_ & 0x4) != 0) {
      paramCodedOutputStream.a(10, this.javaMultipleFiles_);
    }
    if ((this.bitField0_ & 0x40) != 0) {
      GeneratedMessageV3.writeString(paramCodedOutputStream, 11, this.goPackage_);
    }
    if ((this.bitField0_ & 0x80) != 0) {
      paramCodedOutputStream.a(16, this.ccGenericServices_);
    }
    if ((this.bitField0_ & 0x100) != 0) {
      paramCodedOutputStream.a(17, this.javaGenericServices_);
    }
    if ((this.bitField0_ & 0x200) != 0) {
      paramCodedOutputStream.a(18, this.pyGenericServices_);
    }
    if ((this.bitField0_ & 0x8) != 0) {
      paramCodedOutputStream.a(20, this.javaGenerateEqualsAndHash_);
    }
    if ((this.bitField0_ & 0x800) != 0) {
      paramCodedOutputStream.a(23, this.deprecated_);
    }
    if ((this.bitField0_ & 0x10) != 0) {
      paramCodedOutputStream.a(27, this.javaStringCheckUtf8_);
    }
    if ((this.bitField0_ & 0x1000) != 0) {
      paramCodedOutputStream.a(31, this.ccEnableArenas_);
    }
    if ((this.bitField0_ & 0x2000) != 0) {
      GeneratedMessageV3.writeString(paramCodedOutputStream, 36, this.objcClassPrefix_);
    }
    if ((this.bitField0_ & 0x4000) != 0) {
      GeneratedMessageV3.writeString(paramCodedOutputStream, 37, this.csharpNamespace_);
    }
    if ((this.bitField0_ & 0x8000) != 0) {
      GeneratedMessageV3.writeString(paramCodedOutputStream, 39, this.swiftPrefix_);
    }
    if ((this.bitField0_ & 0x10000) != 0) {
      GeneratedMessageV3.writeString(paramCodedOutputStream, 40, this.phpClassPrefix_);
    }
    if ((this.bitField0_ & 0x20000) != 0) {
      GeneratedMessageV3.writeString(paramCodedOutputStream, 41, this.phpNamespace_);
    }
    if ((this.bitField0_ & 0x400) != 0) {
      paramCodedOutputStream.a(42, this.phpGenericServices_);
    }
    if ((this.bitField0_ & 0x40000) != 0) {
      GeneratedMessageV3.writeString(paramCodedOutputStream, 44, this.phpMetadataNamespace_);
    }
    if ((this.bitField0_ & 0x80000) != 0) {
      GeneratedMessageV3.writeString(paramCodedOutputStream, 45, this.rubyPackage_);
    }
    int i = 0;
    while (i < this.uninterpretedOption_.size())
    {
      paramCodedOutputStream.a(999, (MessageLite)this.uninterpretedOption_.get(i));
      i += 1;
    }
    localExtensionWriter.a(536870912, paramCodedOutputStream);
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.DescriptorProtos.FileOptions
 * JD-Core Version:    0.7.0.1
 */