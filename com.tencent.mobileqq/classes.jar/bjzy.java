import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;
import oicq.wlogin_sdk.tools.cryptor;

public class bjzy
{
  public static final String a;
  private static boolean a;
  
  static
  {
    jdField_a_of_type_JavaLangString = antf.ba + "qqconnect/";
  }
  
  private static String a()
  {
    return BaseApplication.getContext().getFilesDir() + File.separator + "qqconnect/";
  }
  
  public static String a(String paramString1, String paramString2)
  {
    String str = paramString1;
    if (paramString1 != null)
    {
      str = paramString1;
      if (paramString2 != null)
      {
        str = paramString1;
        if (paramString1.contains(paramString2)) {
          str = paramString1.replaceAll(paramString2, "*" + bjqq.a(paramString2));
        }
      }
    }
    return str;
  }
  
  /* Error */
  public static void a(String paramString1, bjzb parambjzb, String paramString2, bkaa parambkaa)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 77	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifne +7 -> 11
    //   7: aload_1
    //   8: ifnonnull +51 -> 59
    //   11: ldc 79
    //   13: iconst_1
    //   14: iconst_4
    //   15: anewarray 4	java/lang/Object
    //   18: dup
    //   19: iconst_0
    //   20: ldc 81
    //   22: aastore
    //   23: dup
    //   24: iconst_1
    //   25: aload_0
    //   26: aastore
    //   27: dup
    //   28: iconst_2
    //   29: ldc 83
    //   31: aastore
    //   32: dup
    //   33: iconst_3
    //   34: getstatic 85	bjzy:jdField_a_of_type_Boolean	Z
    //   37: invokestatic 91	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   40: aastore
    //   41: invokestatic 97	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   44: aload_3
    //   45: ifnull +13 -> 58
    //   48: aload_3
    //   49: iconst_0
    //   50: ldc 99
    //   52: iconst_m1
    //   53: ldc 101
    //   55: invokevirtual 106	bkaa:a	(ZLjava/lang/String;ILjava/lang/String;)V
    //   58: return
    //   59: ldc 108
    //   61: iconst_1
    //   62: anewarray 4	java/lang/Object
    //   65: dup
    //   66: iconst_0
    //   67: aload_0
    //   68: aastore
    //   69: invokestatic 112	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   72: astore 19
    //   74: getstatic 85	bjzy:jdField_a_of_type_Boolean	Z
    //   77: ifeq +18 -> 95
    //   80: ldc 114
    //   82: iconst_1
    //   83: anewarray 4	java/lang/Object
    //   86: dup
    //   87: iconst_0
    //   88: aload_0
    //   89: aastore
    //   90: invokestatic 112	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   93: astore 19
    //   95: ldc 79
    //   97: iconst_1
    //   98: bipush 8
    //   100: anewarray 4	java/lang/Object
    //   103: dup
    //   104: iconst_0
    //   105: ldc 116
    //   107: aastore
    //   108: dup
    //   109: iconst_1
    //   110: aload_0
    //   111: aastore
    //   112: dup
    //   113: iconst_2
    //   114: ldc 118
    //   116: aastore
    //   117: dup
    //   118: iconst_3
    //   119: aload_1
    //   120: getfield 121	bjzb:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   123: invokestatic 64	bjqq:a	(Ljava/lang/String;)Ljava/lang/String;
    //   126: aastore
    //   127: dup
    //   128: iconst_4
    //   129: ldc 123
    //   131: aastore
    //   132: dup
    //   133: iconst_5
    //   134: getstatic 85	bjzy:jdField_a_of_type_Boolean	Z
    //   137: invokestatic 91	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   140: aastore
    //   141: dup
    //   142: bipush 6
    //   144: ldc 125
    //   146: aastore
    //   147: dup
    //   148: bipush 7
    //   150: aload 19
    //   152: aastore
    //   153: invokestatic 97	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   156: iconst_0
    //   157: istore 11
    //   159: iconst_0
    //   160: istore 12
    //   162: iconst_0
    //   163: istore 10
    //   165: ldc 99
    //   167: astore 17
    //   169: ldc 99
    //   171: astore 18
    //   173: iconst_m1
    //   174: istore 6
    //   176: iload 6
    //   178: istore 7
    //   180: aload 18
    //   182: astore 16
    //   184: aload 17
    //   186: astore 14
    //   188: iload 10
    //   190: istore 4
    //   192: iload 6
    //   194: istore 8
    //   196: aload 18
    //   198: astore 15
    //   200: aload 17
    //   202: astore 13
    //   204: iload 12
    //   206: istore 5
    //   208: new 127	java/net/URL
    //   211: dup
    //   212: aload 19
    //   214: invokespecial 130	java/net/URL:<init>	(Ljava/lang/String;)V
    //   217: astore 20
    //   219: iload 6
    //   221: istore 7
    //   223: aload 18
    //   225: astore 16
    //   227: aload 17
    //   229: astore 14
    //   231: iload 10
    //   233: istore 4
    //   235: iload 6
    //   237: istore 8
    //   239: aload 18
    //   241: astore 15
    //   243: aload 17
    //   245: astore 13
    //   247: iload 12
    //   249: istore 5
    //   251: new 132	bjzz
    //   254: dup
    //   255: aload 20
    //   257: invokespecial 135	bjzz:<init>	(Ljava/net/URL;)V
    //   260: astore 19
    //   262: iload 6
    //   264: istore 7
    //   266: aload 18
    //   268: astore 16
    //   270: aload 17
    //   272: astore 14
    //   274: iload 10
    //   276: istore 4
    //   278: iload 6
    //   280: istore 8
    //   282: aload 18
    //   284: astore 15
    //   286: aload 17
    //   288: astore 13
    //   290: iload 12
    //   292: istore 5
    //   294: aload 20
    //   296: invokevirtual 139	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   299: checkcast 141	javax/net/ssl/HttpsURLConnection
    //   302: astore 20
    //   304: iload 6
    //   306: istore 7
    //   308: aload 18
    //   310: astore 16
    //   312: aload 17
    //   314: astore 14
    //   316: iload 10
    //   318: istore 4
    //   320: iload 6
    //   322: istore 8
    //   324: aload 18
    //   326: astore 15
    //   328: aload 17
    //   330: astore 13
    //   332: iload 12
    //   334: istore 5
    //   336: aload 20
    //   338: aload 19
    //   340: invokevirtual 145	javax/net/ssl/HttpsURLConnection:setHostnameVerifier	(Ljavax/net/ssl/HostnameVerifier;)V
    //   343: iload 6
    //   345: istore 7
    //   347: aload 18
    //   349: astore 16
    //   351: aload 17
    //   353: astore 14
    //   355: iload 10
    //   357: istore 4
    //   359: iload 6
    //   361: istore 8
    //   363: aload 18
    //   365: astore 15
    //   367: aload 17
    //   369: astore 13
    //   371: iload 12
    //   373: istore 5
    //   375: aload 20
    //   377: sipush 10000
    //   380: invokevirtual 149	javax/net/ssl/HttpsURLConnection:setConnectTimeout	(I)V
    //   383: iload 6
    //   385: istore 7
    //   387: aload 18
    //   389: astore 16
    //   391: aload 17
    //   393: astore 14
    //   395: iload 10
    //   397: istore 4
    //   399: iload 6
    //   401: istore 8
    //   403: aload 18
    //   405: astore 15
    //   407: aload 17
    //   409: astore 13
    //   411: iload 12
    //   413: istore 5
    //   415: aload 20
    //   417: sipush 30000
    //   420: invokevirtual 152	javax/net/ssl/HttpsURLConnection:setReadTimeout	(I)V
    //   423: iload 6
    //   425: istore 7
    //   427: aload 18
    //   429: astore 16
    //   431: aload 17
    //   433: astore 14
    //   435: iload 10
    //   437: istore 4
    //   439: iload 6
    //   441: istore 8
    //   443: aload 18
    //   445: astore 15
    //   447: aload 17
    //   449: astore 13
    //   451: iload 12
    //   453: istore 5
    //   455: aload 20
    //   457: iconst_1
    //   458: invokevirtual 156	javax/net/ssl/HttpsURLConnection:setDoOutput	(Z)V
    //   461: iload 6
    //   463: istore 7
    //   465: aload 18
    //   467: astore 16
    //   469: aload 17
    //   471: astore 14
    //   473: iload 10
    //   475: istore 4
    //   477: iload 6
    //   479: istore 8
    //   481: aload 18
    //   483: astore 15
    //   485: aload 17
    //   487: astore 13
    //   489: iload 12
    //   491: istore 5
    //   493: aload 20
    //   495: iconst_1
    //   496: invokevirtual 159	javax/net/ssl/HttpsURLConnection:setDoInput	(Z)V
    //   499: iload 6
    //   501: istore 7
    //   503: aload 18
    //   505: astore 16
    //   507: aload 17
    //   509: astore 14
    //   511: iload 10
    //   513: istore 4
    //   515: iload 6
    //   517: istore 8
    //   519: aload 18
    //   521: astore 15
    //   523: aload 17
    //   525: astore 13
    //   527: iload 12
    //   529: istore 5
    //   531: aload 20
    //   533: iconst_0
    //   534: invokevirtual 162	javax/net/ssl/HttpsURLConnection:setUseCaches	(Z)V
    //   537: iload 6
    //   539: istore 7
    //   541: aload 18
    //   543: astore 16
    //   545: aload 17
    //   547: astore 14
    //   549: iload 10
    //   551: istore 4
    //   553: iload 6
    //   555: istore 8
    //   557: aload 18
    //   559: astore 15
    //   561: aload 17
    //   563: astore 13
    //   565: iload 12
    //   567: istore 5
    //   569: aload 20
    //   571: ldc 164
    //   573: invokevirtual 167	javax/net/ssl/HttpsURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   576: iload 6
    //   578: istore 7
    //   580: aload 18
    //   582: astore 16
    //   584: aload 17
    //   586: astore 14
    //   588: iload 10
    //   590: istore 4
    //   592: iload 6
    //   594: istore 8
    //   596: aload 18
    //   598: astore 15
    //   600: aload 17
    //   602: astore 13
    //   604: iload 12
    //   606: istore 5
    //   608: aload 20
    //   610: ldc 169
    //   612: ldc 171
    //   614: invokevirtual 175	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   617: iload 6
    //   619: istore 7
    //   621: aload 18
    //   623: astore 16
    //   625: aload 17
    //   627: astore 14
    //   629: iload 10
    //   631: istore 4
    //   633: iload 6
    //   635: istore 8
    //   637: aload 18
    //   639: astore 15
    //   641: aload 17
    //   643: astore 13
    //   645: iload 12
    //   647: istore 5
    //   649: aload 20
    //   651: ldc 177
    //   653: new 11	java/lang/StringBuilder
    //   656: dup
    //   657: ldc 179
    //   659: invokespecial 180	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   662: ldc 182
    //   664: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   667: getstatic 187	android/os/Build$VERSION:SDK	Ljava/lang/String;
    //   670: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   673: ldc 182
    //   675: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   678: getstatic 192	android/os/Build:DEVICE	Ljava/lang/String;
    //   681: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   684: ldc 182
    //   686: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   689: getstatic 195	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   692: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   695: ldc 182
    //   697: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   700: ldc 197
    //   702: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   705: ldc 182
    //   707: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   710: ldc 199
    //   712: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   715: ldc 201
    //   717: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   720: invokevirtual 29	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   723: invokevirtual 175	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   726: iload 6
    //   728: istore 7
    //   730: aload 18
    //   732: astore 16
    //   734: aload 17
    //   736: astore 14
    //   738: iload 10
    //   740: istore 4
    //   742: iload 6
    //   744: istore 8
    //   746: aload 18
    //   748: astore 15
    //   750: aload 17
    //   752: astore 13
    //   754: iload 12
    //   756: istore 5
    //   758: aload 20
    //   760: ldc 203
    //   762: ldc 205
    //   764: invokevirtual 175	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   767: iload 6
    //   769: istore 7
    //   771: aload 18
    //   773: astore 16
    //   775: aload 17
    //   777: astore 14
    //   779: iload 10
    //   781: istore 4
    //   783: iload 6
    //   785: istore 8
    //   787: aload 18
    //   789: astore 15
    //   791: aload 17
    //   793: astore 13
    //   795: iload 12
    //   797: istore 5
    //   799: ldc 207
    //   801: aload_0
    //   802: invokevirtual 211	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   805: ifeq +837 -> 1642
    //   808: iload 6
    //   810: istore 7
    //   812: aload 18
    //   814: astore 16
    //   816: aload 17
    //   818: astore 14
    //   820: iload 10
    //   822: istore 4
    //   824: iload 6
    //   826: istore 8
    //   828: aload 18
    //   830: astore 15
    //   832: aload 17
    //   834: astore 13
    //   836: iload 12
    //   838: istore 5
    //   840: ldc 213
    //   842: iconst_1
    //   843: anewarray 4	java/lang/Object
    //   846: dup
    //   847: iconst_0
    //   848: invokestatic 219	java/lang/System:currentTimeMillis	()J
    //   851: invokestatic 224	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   854: aastore
    //   855: invokestatic 112	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   858: astore_0
    //   859: iload 6
    //   861: istore 7
    //   863: aload 18
    //   865: astore 16
    //   867: aload 17
    //   869: astore 14
    //   871: iload 10
    //   873: istore 4
    //   875: iload 6
    //   877: istore 8
    //   879: aload 18
    //   881: astore 15
    //   883: aload 17
    //   885: astore 13
    //   887: iload 12
    //   889: istore 5
    //   891: aload 20
    //   893: ldc 226
    //   895: new 11	java/lang/StringBuilder
    //   898: dup
    //   899: invokespecial 14	java/lang/StringBuilder:<init>	()V
    //   902: ldc 228
    //   904: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   907: aload_0
    //   908: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   911: invokevirtual 29	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   914: invokevirtual 175	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   917: iload 6
    //   919: istore 7
    //   921: aload 18
    //   923: astore 16
    //   925: aload 17
    //   927: astore 14
    //   929: iload 10
    //   931: istore 4
    //   933: iload 6
    //   935: istore 8
    //   937: aload 18
    //   939: astore 15
    //   941: aload 17
    //   943: astore 13
    //   945: iload 12
    //   947: istore 5
    //   949: new 11	java/lang/StringBuilder
    //   952: dup
    //   953: invokespecial 14	java/lang/StringBuilder:<init>	()V
    //   956: astore_0
    //   957: iload 6
    //   959: istore 7
    //   961: aload 18
    //   963: astore 16
    //   965: aload 17
    //   967: astore 14
    //   969: iload 10
    //   971: istore 4
    //   973: iload 6
    //   975: istore 8
    //   977: aload 18
    //   979: astore 15
    //   981: aload 17
    //   983: astore 13
    //   985: iload 12
    //   987: istore 5
    //   989: aload_0
    //   990: ldc 230
    //   992: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   995: new 11	java/lang/StringBuilder
    //   998: dup
    //   999: invokespecial 14	java/lang/StringBuilder:<init>	()V
    //   1002: ldc 232
    //   1004: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1007: aload_1
    //   1008: getfield 121	bjzb:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1011: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1014: invokevirtual 29	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1017: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1020: ldc 234
    //   1022: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1025: pop
    //   1026: iload 6
    //   1028: istore 7
    //   1030: aload 18
    //   1032: astore 16
    //   1034: aload 17
    //   1036: astore 14
    //   1038: iload 10
    //   1040: istore 4
    //   1042: iload 6
    //   1044: istore 8
    //   1046: aload 18
    //   1048: astore 15
    //   1050: aload 17
    //   1052: astore 13
    //   1054: iload 12
    //   1056: istore 5
    //   1058: aload_0
    //   1059: ldc 236
    //   1061: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1064: ldc 238
    //   1066: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1069: ldc 234
    //   1071: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1074: pop
    //   1075: iload 6
    //   1077: istore 7
    //   1079: aload 18
    //   1081: astore 16
    //   1083: aload 17
    //   1085: astore 14
    //   1087: iload 10
    //   1089: istore 4
    //   1091: iload 6
    //   1093: istore 8
    //   1095: aload 18
    //   1097: astore 15
    //   1099: aload 17
    //   1101: astore 13
    //   1103: iload 12
    //   1105: istore 5
    //   1107: aload_0
    //   1108: ldc 240
    //   1110: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1113: aload_1
    //   1114: getfield 243	bjzb:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1117: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1120: pop
    //   1121: iload 6
    //   1123: istore 7
    //   1125: aload 18
    //   1127: astore 16
    //   1129: aload 17
    //   1131: astore 14
    //   1133: iload 10
    //   1135: istore 4
    //   1137: iload 6
    //   1139: istore 8
    //   1141: aload 18
    //   1143: astore 15
    //   1145: aload 17
    //   1147: astore 13
    //   1149: iload 12
    //   1151: istore 5
    //   1153: aload 20
    //   1155: ldc 245
    //   1157: aload_0
    //   1158: invokevirtual 29	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1161: invokevirtual 175	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   1164: iload 6
    //   1166: istore 7
    //   1168: aload 18
    //   1170: astore 16
    //   1172: aload 17
    //   1174: astore 14
    //   1176: iload 10
    //   1178: istore 4
    //   1180: iload 6
    //   1182: istore 8
    //   1184: aload 18
    //   1186: astore 15
    //   1188: aload 17
    //   1190: astore 13
    //   1192: iload 12
    //   1194: istore 5
    //   1196: aload 20
    //   1198: invokevirtual 249	javax/net/ssl/HttpsURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   1201: astore_0
    //   1202: iload 6
    //   1204: istore 7
    //   1206: aload 18
    //   1208: astore 16
    //   1210: aload 17
    //   1212: astore 14
    //   1214: iload 10
    //   1216: istore 4
    //   1218: iload 6
    //   1220: istore 8
    //   1222: aload 18
    //   1224: astore 15
    //   1226: aload 17
    //   1228: astore 13
    //   1230: iload 12
    //   1232: istore 5
    //   1234: new 251	java/io/OutputStreamWriter
    //   1237: dup
    //   1238: aload_0
    //   1239: ldc 253
    //   1241: invokespecial 256	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   1244: astore 19
    //   1246: iload 6
    //   1248: istore 7
    //   1250: aload 18
    //   1252: astore 16
    //   1254: aload 17
    //   1256: astore 14
    //   1258: iload 10
    //   1260: istore 4
    //   1262: iload 6
    //   1264: istore 8
    //   1266: aload 18
    //   1268: astore 15
    //   1270: aload 17
    //   1272: astore 13
    //   1274: iload 12
    //   1276: istore 5
    //   1278: aload 19
    //   1280: aload_2
    //   1281: invokevirtual 259	java/io/OutputStreamWriter:write	(Ljava/lang/String;)V
    //   1284: iload 6
    //   1286: istore 7
    //   1288: aload 18
    //   1290: astore 16
    //   1292: aload 17
    //   1294: astore 14
    //   1296: iload 10
    //   1298: istore 4
    //   1300: iload 6
    //   1302: istore 8
    //   1304: aload 18
    //   1306: astore 15
    //   1308: aload 17
    //   1310: astore 13
    //   1312: iload 12
    //   1314: istore 5
    //   1316: aload 19
    //   1318: invokevirtual 262	java/io/OutputStreamWriter:flush	()V
    //   1321: iload 6
    //   1323: istore 7
    //   1325: aload 18
    //   1327: astore 16
    //   1329: aload 17
    //   1331: astore 14
    //   1333: iload 10
    //   1335: istore 4
    //   1337: iload 6
    //   1339: istore 8
    //   1341: aload 18
    //   1343: astore 15
    //   1345: aload 17
    //   1347: astore 13
    //   1349: iload 12
    //   1351: istore 5
    //   1353: aload 19
    //   1355: invokevirtual 265	java/io/OutputStreamWriter:close	()V
    //   1358: iload 6
    //   1360: istore 7
    //   1362: aload 18
    //   1364: astore 16
    //   1366: aload 17
    //   1368: astore 14
    //   1370: iload 10
    //   1372: istore 4
    //   1374: iload 6
    //   1376: istore 8
    //   1378: aload 18
    //   1380: astore 15
    //   1382: aload 17
    //   1384: astore 13
    //   1386: iload 12
    //   1388: istore 5
    //   1390: aload_0
    //   1391: invokevirtual 268	java/io/OutputStream:close	()V
    //   1394: iload 6
    //   1396: istore 7
    //   1398: aload 18
    //   1400: astore 16
    //   1402: aload 17
    //   1404: astore 14
    //   1406: iload 10
    //   1408: istore 4
    //   1410: iload 6
    //   1412: istore 8
    //   1414: aload 18
    //   1416: astore 15
    //   1418: aload 17
    //   1420: astore 13
    //   1422: iload 12
    //   1424: istore 5
    //   1426: aload 20
    //   1428: invokevirtual 271	javax/net/ssl/HttpsURLConnection:connect	()V
    //   1431: iload 6
    //   1433: istore 7
    //   1435: aload 18
    //   1437: astore 16
    //   1439: aload 17
    //   1441: astore 14
    //   1443: iload 10
    //   1445: istore 4
    //   1447: iload 6
    //   1449: istore 8
    //   1451: aload 18
    //   1453: astore 15
    //   1455: aload 17
    //   1457: astore 13
    //   1459: iload 12
    //   1461: istore 5
    //   1463: aload 20
    //   1465: invokevirtual 275	javax/net/ssl/HttpsURLConnection:getResponseCode	()I
    //   1468: istore 9
    //   1470: iload 9
    //   1472: istore 7
    //   1474: aload 18
    //   1476: astore 16
    //   1478: aload 17
    //   1480: astore 14
    //   1482: iload 10
    //   1484: istore 4
    //   1486: iload 9
    //   1488: istore 8
    //   1490: aload 18
    //   1492: astore 15
    //   1494: aload 17
    //   1496: astore 13
    //   1498: iload 12
    //   1500: istore 5
    //   1502: aload 20
    //   1504: invokevirtual 278	javax/net/ssl/HttpsURLConnection:getResponseMessage	()Ljava/lang/String;
    //   1507: astore 19
    //   1509: aload 18
    //   1511: astore_0
    //   1512: aload 19
    //   1514: astore_2
    //   1515: iload 11
    //   1517: istore 6
    //   1519: iload 9
    //   1521: sipush 200
    //   1524: if_icmpne +368 -> 1892
    //   1527: iload 9
    //   1529: istore 7
    //   1531: aload 18
    //   1533: astore 16
    //   1535: aload 19
    //   1537: astore 14
    //   1539: iload 10
    //   1541: istore 4
    //   1543: iload 9
    //   1545: istore 8
    //   1547: aload 18
    //   1549: astore 15
    //   1551: aload 19
    //   1553: astore 13
    //   1555: iload 12
    //   1557: istore 5
    //   1559: new 280	java/io/BufferedInputStream
    //   1562: dup
    //   1563: aload 20
    //   1565: invokevirtual 284	javax/net/ssl/HttpsURLConnection:getInputStream	()Ljava/io/InputStream;
    //   1568: invokespecial 287	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   1571: astore_0
    //   1572: iload 9
    //   1574: istore 7
    //   1576: aload 18
    //   1578: astore 16
    //   1580: aload 19
    //   1582: astore 14
    //   1584: iload 10
    //   1586: istore 4
    //   1588: iload 9
    //   1590: istore 8
    //   1592: aload 18
    //   1594: astore 15
    //   1596: aload 19
    //   1598: astore 13
    //   1600: iload 12
    //   1602: istore 5
    //   1604: new 289	java/io/ByteArrayOutputStream
    //   1607: dup
    //   1608: invokespecial 290	java/io/ByteArrayOutputStream:<init>	()V
    //   1611: astore 20
    //   1613: aload_0
    //   1614: invokevirtual 293	java/io/BufferedInputStream:read	()I
    //   1617: istore 4
    //   1619: iload 4
    //   1621: iconst_m1
    //   1622: if_icmpeq +152 -> 1774
    //   1625: aload 20
    //   1627: iload 4
    //   1629: i2b
    //   1630: invokevirtual 295	java/io/ByteArrayOutputStream:write	(I)V
    //   1633: aload_0
    //   1634: invokevirtual 293	java/io/BufferedInputStream:read	()I
    //   1637: istore 4
    //   1639: goto -20 -> 1619
    //   1642: iload 6
    //   1644: istore 7
    //   1646: aload 18
    //   1648: astore 16
    //   1650: aload 17
    //   1652: astore 14
    //   1654: iload 10
    //   1656: istore 4
    //   1658: iload 6
    //   1660: istore 8
    //   1662: aload 18
    //   1664: astore 15
    //   1666: aload 17
    //   1668: astore 13
    //   1670: iload 12
    //   1672: istore 5
    //   1674: aload 20
    //   1676: ldc 226
    //   1678: ldc_w 297
    //   1681: invokevirtual 175	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   1684: goto -767 -> 917
    //   1687: astore_0
    //   1688: iload 7
    //   1690: istore 8
    //   1692: aload 16
    //   1694: astore 15
    //   1696: aload 14
    //   1698: astore 13
    //   1700: iload 4
    //   1702: istore 5
    //   1704: ldc 79
    //   1706: iconst_1
    //   1707: ldc_w 299
    //   1710: aload_0
    //   1711: invokestatic 302	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1714: iload 7
    //   1716: istore 8
    //   1718: aload 16
    //   1720: astore 15
    //   1722: aload 14
    //   1724: astore 13
    //   1726: iload 4
    //   1728: istore 5
    //   1730: new 11	java/lang/StringBuilder
    //   1733: dup
    //   1734: invokespecial 14	java/lang/StringBuilder:<init>	()V
    //   1737: ldc_w 304
    //   1740: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1743: aload_0
    //   1744: invokevirtual 307	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1747: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1750: invokevirtual 29	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1753: astore_0
    //   1754: aload_3
    //   1755: ifnull -1697 -> 58
    //   1758: iload 4
    //   1760: ifeq +522 -> 2282
    //   1763: aload_3
    //   1764: iconst_1
    //   1765: aload 16
    //   1767: iload 7
    //   1769: aload_0
    //   1770: invokevirtual 106	bkaa:a	(ZLjava/lang/String;ILjava/lang/String;)V
    //   1773: return
    //   1774: aload 20
    //   1776: invokevirtual 308	java/io/ByteArrayOutputStream:toString	()Ljava/lang/String;
    //   1779: astore 17
    //   1781: iconst_1
    //   1782: istore 11
    //   1784: iconst_1
    //   1785: istore 12
    //   1787: iconst_1
    //   1788: istore 10
    //   1790: aload_0
    //   1791: ifnull +39 -> 1830
    //   1794: iload 9
    //   1796: istore 7
    //   1798: aload 17
    //   1800: astore 16
    //   1802: aload 19
    //   1804: astore 14
    //   1806: iload 10
    //   1808: istore 4
    //   1810: iload 9
    //   1812: istore 8
    //   1814: aload 17
    //   1816: astore 15
    //   1818: aload 19
    //   1820: astore 13
    //   1822: iload 12
    //   1824: istore 5
    //   1826: aload_0
    //   1827: invokevirtual 309	java/io/BufferedInputStream:close	()V
    //   1830: aload 17
    //   1832: astore_0
    //   1833: aload 19
    //   1835: astore_2
    //   1836: iload 11
    //   1838: istore 6
    //   1840: aload 20
    //   1842: ifnull +50 -> 1892
    //   1845: iload 9
    //   1847: istore 7
    //   1849: aload 17
    //   1851: astore 16
    //   1853: aload 19
    //   1855: astore 14
    //   1857: iload 10
    //   1859: istore 4
    //   1861: iload 9
    //   1863: istore 8
    //   1865: aload 17
    //   1867: astore 15
    //   1869: aload 19
    //   1871: astore 13
    //   1873: iload 12
    //   1875: istore 5
    //   1877: aload 20
    //   1879: invokevirtual 310	java/io/ByteArrayOutputStream:close	()V
    //   1882: iload 11
    //   1884: istore 6
    //   1886: aload 19
    //   1888: astore_2
    //   1889: aload 17
    //   1891: astore_0
    //   1892: iload 9
    //   1894: istore 7
    //   1896: aload_0
    //   1897: astore 16
    //   1899: aload_2
    //   1900: astore 14
    //   1902: iload 6
    //   1904: istore 4
    //   1906: iload 9
    //   1908: istore 8
    //   1910: aload_0
    //   1911: astore 15
    //   1913: aload_2
    //   1914: astore 13
    //   1916: iload 6
    //   1918: istore 5
    //   1920: ldc 79
    //   1922: iconst_1
    //   1923: bipush 6
    //   1925: anewarray 4	java/lang/Object
    //   1928: dup
    //   1929: iconst_0
    //   1930: ldc_w 312
    //   1933: aastore
    //   1934: dup
    //   1935: iconst_1
    //   1936: iload 9
    //   1938: invokestatic 317	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1941: aastore
    //   1942: dup
    //   1943: iconst_2
    //   1944: ldc_w 319
    //   1947: aastore
    //   1948: dup
    //   1949: iconst_3
    //   1950: aload_0
    //   1951: aload_1
    //   1952: getfield 121	bjzb:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1955: invokestatic 321	bjzy:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1958: aastore
    //   1959: dup
    //   1960: iconst_4
    //   1961: ldc_w 323
    //   1964: aastore
    //   1965: dup
    //   1966: iconst_5
    //   1967: aload_2
    //   1968: aastore
    //   1969: invokestatic 97	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   1972: aload_3
    //   1973: ifnull -1915 -> 58
    //   1976: iload 6
    //   1978: ifeq +294 -> 2272
    //   1981: aload_3
    //   1982: iconst_1
    //   1983: aload_0
    //   1984: iload 9
    //   1986: aload_2
    //   1987: invokevirtual 106	bkaa:a	(ZLjava/lang/String;ILjava/lang/String;)V
    //   1990: return
    //   1991: astore_2
    //   1992: ldc 79
    //   1994: iconst_1
    //   1995: ldc_w 325
    //   1998: aload_2
    //   1999: invokestatic 302	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2002: new 11	java/lang/StringBuilder
    //   2005: dup
    //   2006: invokespecial 14	java/lang/StringBuilder:<init>	()V
    //   2009: ldc_w 327
    //   2012: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2015: aload_2
    //   2016: invokevirtual 328	java/io/IOException:getMessage	()Ljava/lang/String;
    //   2019: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2022: invokevirtual 29	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2025: astore 17
    //   2027: aload_0
    //   2028: ifnull +39 -> 2067
    //   2031: iload 9
    //   2033: istore 7
    //   2035: aload 18
    //   2037: astore 16
    //   2039: aload 17
    //   2041: astore 14
    //   2043: iload 10
    //   2045: istore 4
    //   2047: iload 9
    //   2049: istore 8
    //   2051: aload 18
    //   2053: astore 15
    //   2055: aload 17
    //   2057: astore 13
    //   2059: iload 12
    //   2061: istore 5
    //   2063: aload_0
    //   2064: invokevirtual 309	java/io/BufferedInputStream:close	()V
    //   2067: aload 18
    //   2069: astore_0
    //   2070: aload 17
    //   2072: astore_2
    //   2073: iload 11
    //   2075: istore 6
    //   2077: aload 20
    //   2079: ifnull -187 -> 1892
    //   2082: iload 9
    //   2084: istore 7
    //   2086: aload 18
    //   2088: astore 16
    //   2090: aload 17
    //   2092: astore 14
    //   2094: iload 10
    //   2096: istore 4
    //   2098: iload 9
    //   2100: istore 8
    //   2102: aload 18
    //   2104: astore 15
    //   2106: aload 17
    //   2108: astore 13
    //   2110: iload 12
    //   2112: istore 5
    //   2114: aload 20
    //   2116: invokevirtual 310	java/io/ByteArrayOutputStream:close	()V
    //   2119: aload 18
    //   2121: astore_0
    //   2122: aload 17
    //   2124: astore_2
    //   2125: iload 11
    //   2127: istore 6
    //   2129: goto -237 -> 1892
    //   2132: astore_0
    //   2133: aload_3
    //   2134: ifnull +19 -> 2153
    //   2137: iload 5
    //   2139: ifeq +153 -> 2292
    //   2142: aload_3
    //   2143: iconst_1
    //   2144: aload 15
    //   2146: iload 8
    //   2148: aload 13
    //   2150: invokevirtual 106	bkaa:a	(ZLjava/lang/String;ILjava/lang/String;)V
    //   2153: aload_0
    //   2154: athrow
    //   2155: astore_1
    //   2156: aload_0
    //   2157: ifnull +39 -> 2196
    //   2160: iload 9
    //   2162: istore 7
    //   2164: aload 18
    //   2166: astore 16
    //   2168: aload 19
    //   2170: astore 14
    //   2172: iload 10
    //   2174: istore 4
    //   2176: iload 9
    //   2178: istore 8
    //   2180: aload 18
    //   2182: astore 15
    //   2184: aload 19
    //   2186: astore 13
    //   2188: iload 12
    //   2190: istore 5
    //   2192: aload_0
    //   2193: invokevirtual 309	java/io/BufferedInputStream:close	()V
    //   2196: aload 20
    //   2198: ifnull +40 -> 2238
    //   2201: iload 9
    //   2203: istore 7
    //   2205: aload 18
    //   2207: astore 16
    //   2209: aload 19
    //   2211: astore 14
    //   2213: iload 10
    //   2215: istore 4
    //   2217: iload 9
    //   2219: istore 8
    //   2221: aload 18
    //   2223: astore 15
    //   2225: aload 19
    //   2227: astore 13
    //   2229: iload 12
    //   2231: istore 5
    //   2233: aload 20
    //   2235: invokevirtual 310	java/io/ByteArrayOutputStream:close	()V
    //   2238: iload 9
    //   2240: istore 7
    //   2242: aload 18
    //   2244: astore 16
    //   2246: aload 19
    //   2248: astore 14
    //   2250: iload 10
    //   2252: istore 4
    //   2254: iload 9
    //   2256: istore 8
    //   2258: aload 18
    //   2260: astore 15
    //   2262: aload 19
    //   2264: astore 13
    //   2266: iload 12
    //   2268: istore 5
    //   2270: aload_1
    //   2271: athrow
    //   2272: aload_3
    //   2273: iconst_0
    //   2274: aconst_null
    //   2275: iload 9
    //   2277: aload_2
    //   2278: invokevirtual 106	bkaa:a	(ZLjava/lang/String;ILjava/lang/String;)V
    //   2281: return
    //   2282: aload_3
    //   2283: iconst_0
    //   2284: aconst_null
    //   2285: iload 7
    //   2287: aload_0
    //   2288: invokevirtual 106	bkaa:a	(ZLjava/lang/String;ILjava/lang/String;)V
    //   2291: return
    //   2292: aload_3
    //   2293: iconst_0
    //   2294: aconst_null
    //   2295: iload 8
    //   2297: aload 13
    //   2299: invokevirtual 106	bkaa:a	(ZLjava/lang/String;ILjava/lang/String;)V
    //   2302: goto -149 -> 2153
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2305	0	paramString1	String
    //   0	2305	1	parambjzb	bjzb
    //   0	2305	2	paramString2	String
    //   0	2305	3	parambkaa	bkaa
    //   190	2063	4	i	int
    //   206	2063	5	j	int
    //   174	1954	6	k	int
    //   178	2108	7	m	int
    //   194	2102	8	n	int
    //   1468	808	9	i1	int
    //   163	2088	10	i2	int
    //   157	1969	11	i3	int
    //   160	2107	12	i4	int
    //   202	2096	13	localObject1	Object
    //   186	2063	14	localObject2	Object
    //   198	2063	15	str1	String
    //   182	2063	16	str2	String
    //   167	1956	17	str3	String
    //   171	2088	18	str4	String
    //   72	2191	19	localObject3	Object
    //   217	2017	20	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   208	219	1687	java/lang/Exception
    //   251	262	1687	java/lang/Exception
    //   294	304	1687	java/lang/Exception
    //   336	343	1687	java/lang/Exception
    //   375	383	1687	java/lang/Exception
    //   415	423	1687	java/lang/Exception
    //   455	461	1687	java/lang/Exception
    //   493	499	1687	java/lang/Exception
    //   531	537	1687	java/lang/Exception
    //   569	576	1687	java/lang/Exception
    //   608	617	1687	java/lang/Exception
    //   649	726	1687	java/lang/Exception
    //   758	767	1687	java/lang/Exception
    //   799	808	1687	java/lang/Exception
    //   840	859	1687	java/lang/Exception
    //   891	917	1687	java/lang/Exception
    //   949	957	1687	java/lang/Exception
    //   989	1026	1687	java/lang/Exception
    //   1058	1075	1687	java/lang/Exception
    //   1107	1121	1687	java/lang/Exception
    //   1153	1164	1687	java/lang/Exception
    //   1196	1202	1687	java/lang/Exception
    //   1234	1246	1687	java/lang/Exception
    //   1278	1284	1687	java/lang/Exception
    //   1316	1321	1687	java/lang/Exception
    //   1353	1358	1687	java/lang/Exception
    //   1390	1394	1687	java/lang/Exception
    //   1426	1431	1687	java/lang/Exception
    //   1463	1470	1687	java/lang/Exception
    //   1502	1509	1687	java/lang/Exception
    //   1559	1572	1687	java/lang/Exception
    //   1604	1613	1687	java/lang/Exception
    //   1674	1684	1687	java/lang/Exception
    //   1826	1830	1687	java/lang/Exception
    //   1877	1882	1687	java/lang/Exception
    //   1920	1972	1687	java/lang/Exception
    //   2063	2067	1687	java/lang/Exception
    //   2114	2119	1687	java/lang/Exception
    //   2192	2196	1687	java/lang/Exception
    //   2233	2238	1687	java/lang/Exception
    //   2270	2272	1687	java/lang/Exception
    //   1613	1619	1991	java/io/IOException
    //   1625	1639	1991	java/io/IOException
    //   1774	1781	1991	java/io/IOException
    //   208	219	2132	finally
    //   251	262	2132	finally
    //   294	304	2132	finally
    //   336	343	2132	finally
    //   375	383	2132	finally
    //   415	423	2132	finally
    //   455	461	2132	finally
    //   493	499	2132	finally
    //   531	537	2132	finally
    //   569	576	2132	finally
    //   608	617	2132	finally
    //   649	726	2132	finally
    //   758	767	2132	finally
    //   799	808	2132	finally
    //   840	859	2132	finally
    //   891	917	2132	finally
    //   949	957	2132	finally
    //   989	1026	2132	finally
    //   1058	1075	2132	finally
    //   1107	1121	2132	finally
    //   1153	1164	2132	finally
    //   1196	1202	2132	finally
    //   1234	1246	2132	finally
    //   1278	1284	2132	finally
    //   1316	1321	2132	finally
    //   1353	1358	2132	finally
    //   1390	1394	2132	finally
    //   1426	1431	2132	finally
    //   1463	1470	2132	finally
    //   1502	1509	2132	finally
    //   1559	1572	2132	finally
    //   1604	1613	2132	finally
    //   1674	1684	2132	finally
    //   1704	1714	2132	finally
    //   1730	1754	2132	finally
    //   1826	1830	2132	finally
    //   1877	1882	2132	finally
    //   1920	1972	2132	finally
    //   2063	2067	2132	finally
    //   2114	2119	2132	finally
    //   2192	2196	2132	finally
    //   2233	2238	2132	finally
    //   2270	2272	2132	finally
    //   1613	1619	2155	finally
    //   1625	1639	2155	finally
    //   1774	1781	2155	finally
    //   1992	2027	2155	finally
  }
  
  /* Error */
  public static void a(String paramString1, String paramString2, long paramLong, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 9
    //   3: aconst_null
    //   4: astore 8
    //   6: aload 9
    //   8: astore 7
    //   10: new 47	java/io/File
    //   13: dup
    //   14: invokestatic 331	bjzy:a	()Ljava/lang/String;
    //   17: invokespecial 332	java/io/File:<init>	(Ljava/lang/String;)V
    //   20: astore 10
    //   22: aload 9
    //   24: astore 7
    //   26: aload 10
    //   28: invokevirtual 336	java/io/File:exists	()Z
    //   31: ifne +172 -> 203
    //   34: aload 9
    //   36: astore 7
    //   38: aload 10
    //   40: invokevirtual 339	java/io/File:mkdirs	()Z
    //   43: pop
    //   44: aload 9
    //   46: astore 7
    //   48: new 11	java/lang/StringBuilder
    //   51: dup
    //   52: invokespecial 14	java/lang/StringBuilder:<init>	()V
    //   55: aload_0
    //   56: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: ldc 182
    //   61: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: aload_1
    //   65: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: invokevirtual 29	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   71: invokestatic 343	bhml:b	(Ljava/lang/String;)Ljava/lang/String;
    //   74: astore_1
    //   75: aload 9
    //   77: astore 7
    //   79: new 47	java/io/File
    //   82: dup
    //   83: aload 10
    //   85: aload_1
    //   86: invokespecial 346	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   89: astore 10
    //   91: aload 9
    //   93: astore 7
    //   95: aload 10
    //   97: invokevirtual 336	java/io/File:exists	()Z
    //   100: ifeq +13 -> 113
    //   103: aload 9
    //   105: astore 7
    //   107: aload 10
    //   109: invokevirtual 349	java/io/File:delete	()Z
    //   112: pop
    //   113: aload 9
    //   115: astore 7
    //   117: invokestatic 219	java/lang/System:currentTimeMillis	()J
    //   120: ldc2_w 350
    //   123: ldiv
    //   124: lstore 5
    //   126: aload 9
    //   128: astore 7
    //   130: new 353	java/io/DataOutputStream
    //   133: dup
    //   134: new 355	java/io/FileOutputStream
    //   137: dup
    //   138: aload 10
    //   140: invokespecial 358	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   143: invokespecial 361	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   146: astore_0
    //   147: aload_0
    //   148: lload 5
    //   150: lload_2
    //   151: ladd
    //   152: invokevirtual 365	java/io/DataOutputStream:writeLong	(J)V
    //   155: aload_0
    //   156: aload 4
    //   158: aload_1
    //   159: ldc 253
    //   161: invokevirtual 369	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   164: invokestatic 374	blhj:a	([B[B)[B
    //   167: invokevirtual 377	java/io/DataOutputStream:write	([B)V
    //   170: ldc 79
    //   172: iconst_1
    //   173: iconst_2
    //   174: anewarray 4	java/lang/Object
    //   177: dup
    //   178: iconst_0
    //   179: ldc_w 379
    //   182: aastore
    //   183: dup
    //   184: iconst_1
    //   185: aload 10
    //   187: invokevirtual 382	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   190: aastore
    //   191: invokestatic 97	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   194: aload_0
    //   195: ifnull +7 -> 202
    //   198: aload_0
    //   199: invokevirtual 383	java/io/DataOutputStream:close	()V
    //   202: return
    //   203: aload 9
    //   205: astore 7
    //   207: aload 10
    //   209: invokevirtual 386	java/io/File:isFile	()Z
    //   212: ifeq -168 -> 44
    //   215: aload 9
    //   217: astore 7
    //   219: aload 10
    //   221: invokevirtual 349	java/io/File:delete	()Z
    //   224: pop
    //   225: aload 9
    //   227: astore 7
    //   229: aload 10
    //   231: invokevirtual 339	java/io/File:mkdirs	()Z
    //   234: pop
    //   235: goto -191 -> 44
    //   238: astore_1
    //   239: aload 8
    //   241: astore_0
    //   242: aload_0
    //   243: astore 7
    //   245: ldc 79
    //   247: iconst_1
    //   248: aload_1
    //   249: iconst_0
    //   250: anewarray 4	java/lang/Object
    //   253: invokestatic 390	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   256: aload_0
    //   257: ifnull -55 -> 202
    //   260: aload_0
    //   261: invokevirtual 383	java/io/DataOutputStream:close	()V
    //   264: return
    //   265: astore_0
    //   266: ldc 79
    //   268: iconst_1
    //   269: aload_0
    //   270: iconst_0
    //   271: anewarray 4	java/lang/Object
    //   274: invokestatic 392	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   277: return
    //   278: astore_0
    //   279: ldc 79
    //   281: iconst_1
    //   282: aload_0
    //   283: iconst_0
    //   284: anewarray 4	java/lang/Object
    //   287: invokestatic 392	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   290: return
    //   291: astore_0
    //   292: aload 7
    //   294: ifnull +8 -> 302
    //   297: aload 7
    //   299: invokevirtual 383	java/io/DataOutputStream:close	()V
    //   302: aload_0
    //   303: athrow
    //   304: astore_1
    //   305: ldc 79
    //   307: iconst_1
    //   308: aload_1
    //   309: iconst_0
    //   310: anewarray 4	java/lang/Object
    //   313: invokestatic 392	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   316: goto -14 -> 302
    //   319: astore_1
    //   320: aload_0
    //   321: astore 7
    //   323: aload_1
    //   324: astore_0
    //   325: goto -33 -> 292
    //   328: astore_1
    //   329: goto -87 -> 242
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	332	0	paramString1	String
    //   0	332	1	paramString2	String
    //   0	332	2	paramLong	long
    //   0	332	4	paramArrayOfByte	byte[]
    //   124	25	5	l	long
    //   8	314	7	localObject1	Object
    //   4	236	8	localObject2	Object
    //   1	225	9	localObject3	Object
    //   20	210	10	localFile	File
    // Exception table:
    //   from	to	target	type
    //   10	22	238	java/io/IOException
    //   26	34	238	java/io/IOException
    //   38	44	238	java/io/IOException
    //   48	75	238	java/io/IOException
    //   79	91	238	java/io/IOException
    //   95	103	238	java/io/IOException
    //   107	113	238	java/io/IOException
    //   117	126	238	java/io/IOException
    //   130	147	238	java/io/IOException
    //   207	215	238	java/io/IOException
    //   219	225	238	java/io/IOException
    //   229	235	238	java/io/IOException
    //   260	264	265	java/io/IOException
    //   198	202	278	java/io/IOException
    //   10	22	291	finally
    //   26	34	291	finally
    //   38	44	291	finally
    //   48	75	291	finally
    //   79	91	291	finally
    //   95	103	291	finally
    //   107	113	291	finally
    //   117	126	291	finally
    //   130	147	291	finally
    //   207	215	291	finally
    //   219	225	291	finally
    //   229	235	291	finally
    //   245	256	291	finally
    //   297	302	304	java/io/IOException
    //   147	194	319	finally
    //   147	194	328	java/io/IOException
  }
  
  /* Error */
  public static byte[] a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: new 11	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 14	java/lang/StringBuilder:<init>	()V
    //   10: aload_0
    //   11: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14: ldc 182
    //   16: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: aload_1
    //   20: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: invokevirtual 29	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   26: invokestatic 343	bhml:b	(Ljava/lang/String;)Ljava/lang/String;
    //   29: astore_3
    //   30: new 47	java/io/File
    //   33: dup
    //   34: new 11	java/lang/StringBuilder
    //   37: dup
    //   38: invokespecial 14	java/lang/StringBuilder:<init>	()V
    //   41: invokestatic 331	bjzy:a	()Ljava/lang/String;
    //   44: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: aload_3
    //   48: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: invokevirtual 29	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   54: invokespecial 332	java/io/File:<init>	(Ljava/lang/String;)V
    //   57: astore_1
    //   58: aload_1
    //   59: astore_0
    //   60: aload_1
    //   61: invokevirtual 336	java/io/File:exists	()Z
    //   64: ifne +54 -> 118
    //   67: ldc 79
    //   69: iconst_1
    //   70: iconst_2
    //   71: anewarray 4	java/lang/Object
    //   74: dup
    //   75: iconst_0
    //   76: ldc_w 395
    //   79: aastore
    //   80: dup
    //   81: iconst_1
    //   82: aload_1
    //   83: invokevirtual 382	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   86: aastore
    //   87: invokestatic 97	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   90: new 47	java/io/File
    //   93: dup
    //   94: new 11	java/lang/StringBuilder
    //   97: dup
    //   98: invokespecial 14	java/lang/StringBuilder:<init>	()V
    //   101: getstatic 31	bjzy:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   104: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: aload_3
    //   108: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: invokevirtual 29	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   114: invokespecial 332	java/io/File:<init>	(Ljava/lang/String;)V
    //   117: astore_0
    //   118: aload_0
    //   119: invokevirtual 336	java/io/File:exists	()Z
    //   122: ifne +57 -> 179
    //   125: ldc 79
    //   127: iconst_1
    //   128: iconst_2
    //   129: anewarray 4	java/lang/Object
    //   132: dup
    //   133: iconst_0
    //   134: ldc_w 397
    //   137: aastore
    //   138: dup
    //   139: iconst_1
    //   140: aload_0
    //   141: invokevirtual 382	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   144: aastore
    //   145: invokestatic 97	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   148: aload 4
    //   150: astore_3
    //   151: iconst_0
    //   152: ifeq +11 -> 163
    //   155: new 399	java/lang/NullPointerException
    //   158: dup
    //   159: invokespecial 400	java/lang/NullPointerException:<init>	()V
    //   162: athrow
    //   163: aload_3
    //   164: areturn
    //   165: astore_0
    //   166: ldc 79
    //   168: iconst_1
    //   169: aload_0
    //   170: iconst_0
    //   171: anewarray 4	java/lang/Object
    //   174: invokestatic 392	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   177: aconst_null
    //   178: areturn
    //   179: ldc 79
    //   181: iconst_1
    //   182: iconst_2
    //   183: anewarray 4	java/lang/Object
    //   186: dup
    //   187: iconst_0
    //   188: ldc_w 402
    //   191: aastore
    //   192: dup
    //   193: iconst_1
    //   194: aload_0
    //   195: invokevirtual 382	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   198: aastore
    //   199: invokestatic 97	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   202: new 404	java/io/DataInputStream
    //   205: dup
    //   206: new 406	java/io/FileInputStream
    //   209: dup
    //   210: aload_0
    //   211: invokespecial 407	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   214: invokespecial 408	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   217: astore_1
    //   218: aload_1
    //   219: astore_0
    //   220: aload_1
    //   221: invokevirtual 411	java/io/DataInputStream:readLong	()J
    //   224: invokestatic 219	java/lang/System:currentTimeMillis	()J
    //   227: ldc2_w 350
    //   230: ldiv
    //   231: lcmp
    //   232: ifle +78 -> 310
    //   235: aload_1
    //   236: astore_0
    //   237: aload_1
    //   238: invokevirtual 414	java/io/DataInputStream:available	()I
    //   241: istore_2
    //   242: iload_2
    //   243: ifle +67 -> 310
    //   246: aload_1
    //   247: astore_0
    //   248: iload_2
    //   249: newarray byte
    //   251: astore 5
    //   253: aload_1
    //   254: astore_0
    //   255: aload_1
    //   256: aload 5
    //   258: invokevirtual 417	java/io/DataInputStream:read	([B)I
    //   261: pop
    //   262: aload_1
    //   263: astore_0
    //   264: aload_1
    //   265: invokevirtual 418	java/io/DataInputStream:close	()V
    //   268: aload_1
    //   269: astore_0
    //   270: aload 5
    //   272: aload_3
    //   273: ldc 253
    //   275: invokevirtual 369	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   278: invokestatic 420	blhj:b	([B[B)[B
    //   281: astore_3
    //   282: aload_3
    //   283: astore_0
    //   284: aload_0
    //   285: astore_3
    //   286: aload_1
    //   287: ifnull -124 -> 163
    //   290: aload_1
    //   291: invokevirtual 418	java/io/DataInputStream:close	()V
    //   294: aload_0
    //   295: areturn
    //   296: astore_1
    //   297: ldc 79
    //   299: iconst_1
    //   300: aload_1
    //   301: iconst_0
    //   302: anewarray 4	java/lang/Object
    //   305: invokestatic 392	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   308: aload_0
    //   309: areturn
    //   310: aload 4
    //   312: astore_3
    //   313: aload_1
    //   314: ifnull -151 -> 163
    //   317: aload_1
    //   318: invokevirtual 418	java/io/DataInputStream:close	()V
    //   321: aconst_null
    //   322: areturn
    //   323: astore_0
    //   324: ldc 79
    //   326: iconst_1
    //   327: aload_0
    //   328: iconst_0
    //   329: anewarray 4	java/lang/Object
    //   332: invokestatic 392	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   335: aconst_null
    //   336: areturn
    //   337: astore_3
    //   338: aconst_null
    //   339: astore_1
    //   340: aload_1
    //   341: astore_0
    //   342: ldc 79
    //   344: iconst_1
    //   345: aload_3
    //   346: iconst_0
    //   347: anewarray 4	java/lang/Object
    //   350: invokestatic 392	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   353: aload 4
    //   355: astore_3
    //   356: aload_1
    //   357: ifnull -194 -> 163
    //   360: aload_1
    //   361: invokevirtual 418	java/io/DataInputStream:close	()V
    //   364: aconst_null
    //   365: areturn
    //   366: astore_0
    //   367: ldc 79
    //   369: iconst_1
    //   370: aload_0
    //   371: iconst_0
    //   372: anewarray 4	java/lang/Object
    //   375: invokestatic 392	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   378: aconst_null
    //   379: areturn
    //   380: astore_1
    //   381: aconst_null
    //   382: astore_0
    //   383: aload_0
    //   384: ifnull +7 -> 391
    //   387: aload_0
    //   388: invokevirtual 418	java/io/DataInputStream:close	()V
    //   391: aload_1
    //   392: athrow
    //   393: astore_0
    //   394: ldc 79
    //   396: iconst_1
    //   397: aload_0
    //   398: iconst_0
    //   399: anewarray 4	java/lang/Object
    //   402: invokestatic 392	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   405: goto -14 -> 391
    //   408: astore_1
    //   409: goto -26 -> 383
    //   412: astore_3
    //   413: goto -73 -> 340
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	416	0	paramString1	String
    //   0	416	1	paramString2	String
    //   241	8	2	i	int
    //   29	284	3	localObject1	Object
    //   337	9	3	localIOException1	java.io.IOException
    //   355	1	3	localObject2	Object
    //   412	1	3	localIOException2	java.io.IOException
    //   1	353	4	localObject3	Object
    //   251	20	5	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   155	163	165	java/lang/Exception
    //   290	294	296	java/lang/Exception
    //   317	321	323	java/lang/Exception
    //   3	58	337	java/io/IOException
    //   60	118	337	java/io/IOException
    //   118	148	337	java/io/IOException
    //   179	218	337	java/io/IOException
    //   360	364	366	java/lang/Exception
    //   3	58	380	finally
    //   60	118	380	finally
    //   118	148	380	finally
    //   179	218	380	finally
    //   387	391	393	java/lang/Exception
    //   220	235	408	finally
    //   237	242	408	finally
    //   248	253	408	finally
    //   255	262	408	finally
    //   264	268	408	finally
    //   270	282	408	finally
    //   342	353	408	finally
    //   220	235	412	java/io/IOException
    //   237	242	412	java/io/IOException
    //   248	253	412	java/io/IOException
    //   255	262	412	java/io/IOException
    //   264	268	412	java/io/IOException
    //   270	282	412	java/io/IOException
  }
  
  public static byte[] a(byte[] paramArrayOfByte, bjzb parambjzb)
  {
    byte[] arrayOfByte1 = parambjzb.jdField_a_of_type_ArrayOfByte;
    parambjzb = parambjzb.jdField_b_of_type_ArrayOfByte;
    paramArrayOfByte = cryptor.encrypt(paramArrayOfByte, 0, paramArrayOfByte.length, parambjzb);
    parambjzb = new byte[arrayOfByte1.length + 4 + paramArrayOfByte.length];
    byte[] arrayOfByte2 = new byte[4];
    arrayOfByte2[0] = ((byte)(arrayOfByte1.length >> 24));
    arrayOfByte2[1] = ((byte)(arrayOfByte1.length >> 16));
    arrayOfByte2[2] = ((byte)(arrayOfByte1.length >> 8));
    arrayOfByte2[3] = ((byte)(arrayOfByte1.length >> 0));
    System.arraycopy(arrayOfByte2, 0, parambjzb, 0, arrayOfByte2.length);
    System.arraycopy(arrayOfByte1, 0, parambjzb, arrayOfByte2.length, arrayOfByte1.length);
    int i = arrayOfByte2.length;
    System.arraycopy(paramArrayOfByte, 0, parambjzb, arrayOfByte1.length + i, paramArrayOfByte.length);
    return parambjzb;
  }
  
  /* Error */
  public static String[] a(android.app.Activity paramActivity, String paramString)
  {
    // Byte code:
    //   0: ldc 99
    //   2: astore_2
    //   3: new 11	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 14	java/lang/StringBuilder:<init>	()V
    //   10: invokestatic 219	java/lang/System:currentTimeMillis	()J
    //   13: ldc2_w 350
    //   16: ldiv
    //   17: invokevirtual 440	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   20: ldc 99
    //   22: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: invokevirtual 29	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: astore 4
    //   30: iconst_3
    //   31: anewarray 53	java/lang/String
    //   34: astore 5
    //   36: aload 5
    //   38: iconst_0
    //   39: ldc 99
    //   41: aastore
    //   42: aload 5
    //   44: iconst_1
    //   45: ldc 99
    //   47: aastore
    //   48: aload 5
    //   50: iconst_2
    //   51: ldc 99
    //   53: aastore
    //   54: aload_0
    //   55: invokevirtual 446	android/app/Activity:getPackageManager	()Landroid/content/pm/PackageManager;
    //   58: astore_3
    //   59: aload_2
    //   60: astore_0
    //   61: aload_3
    //   62: aload_1
    //   63: bipush 64
    //   65: invokevirtual 452	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   68: getfield 458	android/content/pm/PackageInfo:signatures	[Landroid/content/pm/Signature;
    //   71: astore 6
    //   73: aload_2
    //   74: astore_0
    //   75: ldc_w 460
    //   78: invokestatic 466	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   81: astore_3
    //   82: aload_2
    //   83: astore_0
    //   84: aload_3
    //   85: aload 6
    //   87: iconst_0
    //   88: aaload
    //   89: invokevirtual 472	android/content/pm/Signature:toByteArray	()[B
    //   92: invokevirtual 475	java/security/MessageDigest:update	([B)V
    //   95: aload_2
    //   96: astore_0
    //   97: aload_3
    //   98: invokevirtual 478	java/security/MessageDigest:digest	()[B
    //   101: invokestatic 481	bhml:a	([B)Ljava/lang/String;
    //   104: invokevirtual 484	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   107: astore_2
    //   108: aload_2
    //   109: astore_0
    //   110: aload_3
    //   111: invokevirtual 487	java/security/MessageDigest:reset	()V
    //   114: aload_2
    //   115: astore_0
    //   116: aload_3
    //   117: new 11	java/lang/StringBuilder
    //   120: dup
    //   121: invokespecial 14	java/lang/StringBuilder:<init>	()V
    //   124: aload_1
    //   125: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: ldc 182
    //   130: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: aload_2
    //   134: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: ldc 182
    //   139: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: aload 4
    //   144: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: ldc 99
    //   149: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: invokevirtual 29	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   155: invokevirtual 489	java/lang/String:getBytes	()[B
    //   158: invokevirtual 475	java/security/MessageDigest:update	([B)V
    //   161: aload_2
    //   162: astore_0
    //   163: aload_3
    //   164: invokevirtual 478	java/security/MessageDigest:digest	()[B
    //   167: invokestatic 481	bhml:a	([B)Ljava/lang/String;
    //   170: astore_1
    //   171: ldc 79
    //   173: iconst_1
    //   174: ldc_w 491
    //   177: invokestatic 494	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   180: aload_2
    //   181: astore_0
    //   182: aload 5
    //   184: iconst_0
    //   185: aload_0
    //   186: aastore
    //   187: aload 5
    //   189: iconst_1
    //   190: aload_1
    //   191: aastore
    //   192: aload 5
    //   194: iconst_2
    //   195: aload 4
    //   197: aastore
    //   198: aload 5
    //   200: areturn
    //   201: astore_2
    //   202: ldc 99
    //   204: astore_1
    //   205: ldc 79
    //   207: iconst_1
    //   208: iconst_2
    //   209: anewarray 4	java/lang/Object
    //   212: dup
    //   213: iconst_0
    //   214: ldc_w 496
    //   217: aastore
    //   218: dup
    //   219: iconst_1
    //   220: aload_2
    //   221: invokevirtual 497	java/lang/Exception:toString	()Ljava/lang/String;
    //   224: aastore
    //   225: invokestatic 97	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   228: goto -46 -> 182
    //   231: astore_3
    //   232: aload_2
    //   233: astore_0
    //   234: aload_3
    //   235: astore_2
    //   236: goto -31 -> 205
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	239	0	paramActivity	android.app.Activity
    //   0	239	1	paramString	String
    //   2	179	2	str1	String
    //   201	32	2	localException1	java.lang.Exception
    //   235	1	2	localObject1	Object
    //   58	106	3	localObject2	Object
    //   231	4	3	localException2	java.lang.Exception
    //   28	168	4	str2	String
    //   34	165	5	arrayOfString	String[]
    //   71	15	6	arrayOfSignature	android.content.pm.Signature[]
    // Exception table:
    //   from	to	target	type
    //   61	73	201	java/lang/Exception
    //   75	82	201	java/lang/Exception
    //   84	95	201	java/lang/Exception
    //   97	108	201	java/lang/Exception
    //   110	114	201	java/lang/Exception
    //   116	161	201	java/lang/Exception
    //   163	171	201	java/lang/Exception
    //   171	180	231	java/lang/Exception
  }
  
  public static byte[] b(byte[] paramArrayOfByte, bjzb parambjzb)
  {
    parambjzb = parambjzb.jdField_b_of_type_ArrayOfByte;
    return cryptor.decrypt(paramArrayOfByte, 0, paramArrayOfByte.length, parambjzb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjzy
 * JD-Core Version:    0.7.0.1
 */