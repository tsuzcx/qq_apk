import oicq.wlogin_sdk.tools.cryptor;

public class bdoo
{
  public static final String a;
  private static boolean a;
  
  static
  {
    jdField_a_of_type_JavaLangString = ajsd.aW + "qqconnect/";
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
          str = paramString1.replaceAll(paramString2, "*" + bdfb.a(paramString2));
        }
      }
    }
    return str;
  }
  
  /* Error */
  public static void a(String paramString1, bdnp parambdnp, String paramString2, bdoq parambdoq)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 59	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifne +7 -> 11
    //   7: aload_1
    //   8: ifnonnull +51 -> 59
    //   11: ldc 61
    //   13: iconst_1
    //   14: iconst_4
    //   15: anewarray 4	java/lang/Object
    //   18: dup
    //   19: iconst_0
    //   20: ldc 63
    //   22: aastore
    //   23: dup
    //   24: iconst_1
    //   25: aload_0
    //   26: aastore
    //   27: dup
    //   28: iconst_2
    //   29: ldc 65
    //   31: aastore
    //   32: dup
    //   33: iconst_3
    //   34: getstatic 67	bdoo:jdField_a_of_type_Boolean	Z
    //   37: invokestatic 73	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   40: aastore
    //   41: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   44: aload_3
    //   45: ifnull +13 -> 58
    //   48: aload_3
    //   49: iconst_0
    //   50: ldc 81
    //   52: iconst_m1
    //   53: ldc 83
    //   55: invokevirtual 88	bdoq:a	(ZLjava/lang/String;ILjava/lang/String;)V
    //   58: return
    //   59: ldc 90
    //   61: iconst_1
    //   62: anewarray 4	java/lang/Object
    //   65: dup
    //   66: iconst_0
    //   67: aload_0
    //   68: aastore
    //   69: invokestatic 94	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   72: astore 19
    //   74: getstatic 67	bdoo:jdField_a_of_type_Boolean	Z
    //   77: ifeq +18 -> 95
    //   80: ldc 96
    //   82: iconst_1
    //   83: anewarray 4	java/lang/Object
    //   86: dup
    //   87: iconst_0
    //   88: aload_0
    //   89: aastore
    //   90: invokestatic 94	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   93: astore 19
    //   95: ldc 61
    //   97: iconst_1
    //   98: bipush 8
    //   100: anewarray 4	java/lang/Object
    //   103: dup
    //   104: iconst_0
    //   105: ldc 98
    //   107: aastore
    //   108: dup
    //   109: iconst_1
    //   110: aload_0
    //   111: aastore
    //   112: dup
    //   113: iconst_2
    //   114: ldc 100
    //   116: aastore
    //   117: dup
    //   118: iconst_3
    //   119: aload_1
    //   120: getfield 103	bdnp:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   123: invokestatic 46	bdfb:a	(Ljava/lang/String;)Ljava/lang/String;
    //   126: aastore
    //   127: dup
    //   128: iconst_4
    //   129: ldc 105
    //   131: aastore
    //   132: dup
    //   133: iconst_5
    //   134: getstatic 67	bdoo:jdField_a_of_type_Boolean	Z
    //   137: invokestatic 73	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   140: aastore
    //   141: dup
    //   142: bipush 6
    //   144: ldc 107
    //   146: aastore
    //   147: dup
    //   148: bipush 7
    //   150: aload 19
    //   152: aastore
    //   153: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   156: iconst_0
    //   157: istore 11
    //   159: iconst_0
    //   160: istore 12
    //   162: iconst_0
    //   163: istore 10
    //   165: ldc 81
    //   167: astore 17
    //   169: ldc 81
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
    //   208: new 109	java/net/URL
    //   211: dup
    //   212: aload 19
    //   214: invokespecial 112	java/net/URL:<init>	(Ljava/lang/String;)V
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
    //   251: new 114	bdop
    //   254: dup
    //   255: aload 20
    //   257: invokespecial 117	bdop:<init>	(Ljava/net/URL;)V
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
    //   296: invokevirtual 121	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   299: checkcast 123	javax/net/ssl/HttpsURLConnection
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
    //   340: invokevirtual 127	javax/net/ssl/HttpsURLConnection:setHostnameVerifier	(Ljavax/net/ssl/HostnameVerifier;)V
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
    //   380: invokevirtual 131	javax/net/ssl/HttpsURLConnection:setConnectTimeout	(I)V
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
    //   420: invokevirtual 134	javax/net/ssl/HttpsURLConnection:setReadTimeout	(I)V
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
    //   458: invokevirtual 138	javax/net/ssl/HttpsURLConnection:setDoOutput	(Z)V
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
    //   496: invokevirtual 141	javax/net/ssl/HttpsURLConnection:setDoInput	(Z)V
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
    //   534: invokevirtual 144	javax/net/ssl/HttpsURLConnection:setUseCaches	(Z)V
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
    //   571: ldc 146
    //   573: invokevirtual 149	javax/net/ssl/HttpsURLConnection:setRequestMethod	(Ljava/lang/String;)V
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
    //   610: ldc 151
    //   612: ldc 153
    //   614: invokevirtual 157	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   651: ldc 159
    //   653: new 11	java/lang/StringBuilder
    //   656: dup
    //   657: ldc 161
    //   659: invokespecial 162	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   662: ldc 164
    //   664: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   667: getstatic 169	android/os/Build$VERSION:SDK	Ljava/lang/String;
    //   670: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   673: ldc 164
    //   675: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   678: getstatic 174	android/os/Build:DEVICE	Ljava/lang/String;
    //   681: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   684: ldc 164
    //   686: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   689: getstatic 177	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   692: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   695: ldc 164
    //   697: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   700: ldc 179
    //   702: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   705: ldc 164
    //   707: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   710: ldc 181
    //   712: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   715: ldc 183
    //   717: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   720: invokevirtual 29	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   723: invokevirtual 157	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   760: ldc 185
    //   762: ldc 187
    //   764: invokevirtual 157	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   799: ldc 189
    //   801: aload_0
    //   802: invokevirtual 193	java/lang/String:equals	(Ljava/lang/Object;)Z
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
    //   840: ldc 195
    //   842: iconst_1
    //   843: anewarray 4	java/lang/Object
    //   846: dup
    //   847: iconst_0
    //   848: invokestatic 201	java/lang/System:currentTimeMillis	()J
    //   851: invokestatic 206	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   854: aastore
    //   855: invokestatic 94	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
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
    //   893: ldc 208
    //   895: new 11	java/lang/StringBuilder
    //   898: dup
    //   899: invokespecial 14	java/lang/StringBuilder:<init>	()V
    //   902: ldc 210
    //   904: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   907: aload_0
    //   908: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   911: invokevirtual 29	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   914: invokevirtual 157	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   990: ldc 212
    //   992: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   995: new 11	java/lang/StringBuilder
    //   998: dup
    //   999: invokespecial 14	java/lang/StringBuilder:<init>	()V
    //   1002: ldc 214
    //   1004: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1007: aload_1
    //   1008: getfield 103	bdnp:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1011: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1014: invokevirtual 29	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1017: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1020: ldc 216
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
    //   1059: ldc 218
    //   1061: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1064: ldc 220
    //   1066: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1069: ldc 216
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
    //   1108: ldc 222
    //   1110: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1113: aload_1
    //   1114: getfield 225	bdnp:jdField_b_of_type_JavaLangString	Ljava/lang/String;
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
    //   1155: ldc 227
    //   1157: aload_0
    //   1158: invokevirtual 29	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1161: invokevirtual 157	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   1198: invokevirtual 231	javax/net/ssl/HttpsURLConnection:getOutputStream	()Ljava/io/OutputStream;
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
    //   1234: new 233	java/io/OutputStreamWriter
    //   1237: dup
    //   1238: aload_0
    //   1239: ldc 235
    //   1241: invokespecial 238	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;Ljava/lang/String;)V
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
    //   1281: invokevirtual 241	java/io/OutputStreamWriter:write	(Ljava/lang/String;)V
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
    //   1318: invokevirtual 244	java/io/OutputStreamWriter:flush	()V
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
    //   1355: invokevirtual 247	java/io/OutputStreamWriter:close	()V
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
    //   1391: invokevirtual 250	java/io/OutputStream:close	()V
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
    //   1428: invokevirtual 253	javax/net/ssl/HttpsURLConnection:connect	()V
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
    //   1465: invokevirtual 257	javax/net/ssl/HttpsURLConnection:getResponseCode	()I
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
    //   1504: invokevirtual 260	javax/net/ssl/HttpsURLConnection:getResponseMessage	()Ljava/lang/String;
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
    //   1559: new 262	java/io/BufferedInputStream
    //   1562: dup
    //   1563: aload 20
    //   1565: invokevirtual 266	javax/net/ssl/HttpsURLConnection:getInputStream	()Ljava/io/InputStream;
    //   1568: invokespecial 269	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
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
    //   1604: new 271	java/io/ByteArrayOutputStream
    //   1607: dup
    //   1608: invokespecial 272	java/io/ByteArrayOutputStream:<init>	()V
    //   1611: astore 20
    //   1613: aload_0
    //   1614: invokevirtual 275	java/io/BufferedInputStream:read	()I
    //   1617: istore 4
    //   1619: iload 4
    //   1621: iconst_m1
    //   1622: if_icmpeq +152 -> 1774
    //   1625: aload 20
    //   1627: iload 4
    //   1629: i2b
    //   1630: invokevirtual 277	java/io/ByteArrayOutputStream:write	(I)V
    //   1633: aload_0
    //   1634: invokevirtual 275	java/io/BufferedInputStream:read	()I
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
    //   1676: ldc 208
    //   1678: ldc_w 279
    //   1681: invokevirtual 157	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   1704: ldc 61
    //   1706: iconst_1
    //   1707: ldc_w 281
    //   1710: aload_0
    //   1711: invokestatic 284	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
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
    //   1737: ldc_w 286
    //   1740: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1743: aload_0
    //   1744: invokevirtual 289	java/lang/Exception:getMessage	()Ljava/lang/String;
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
    //   1770: invokevirtual 88	bdoq:a	(ZLjava/lang/String;ILjava/lang/String;)V
    //   1773: return
    //   1774: aload 20
    //   1776: invokevirtual 290	java/io/ByteArrayOutputStream:toString	()Ljava/lang/String;
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
    //   1827: invokevirtual 291	java/io/BufferedInputStream:close	()V
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
    //   1879: invokevirtual 292	java/io/ByteArrayOutputStream:close	()V
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
    //   1920: ldc 61
    //   1922: iconst_1
    //   1923: bipush 6
    //   1925: anewarray 4	java/lang/Object
    //   1928: dup
    //   1929: iconst_0
    //   1930: ldc_w 294
    //   1933: aastore
    //   1934: dup
    //   1935: iconst_1
    //   1936: iload 9
    //   1938: invokestatic 299	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1941: aastore
    //   1942: dup
    //   1943: iconst_2
    //   1944: ldc_w 301
    //   1947: aastore
    //   1948: dup
    //   1949: iconst_3
    //   1950: aload_0
    //   1951: aload_1
    //   1952: getfield 103	bdnp:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1955: invokestatic 303	bdoo:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1958: aastore
    //   1959: dup
    //   1960: iconst_4
    //   1961: ldc_w 305
    //   1964: aastore
    //   1965: dup
    //   1966: iconst_5
    //   1967: aload_2
    //   1968: aastore
    //   1969: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   1972: aload_3
    //   1973: ifnull -1915 -> 58
    //   1976: iload 6
    //   1978: ifeq +294 -> 2272
    //   1981: aload_3
    //   1982: iconst_1
    //   1983: aload_0
    //   1984: iload 9
    //   1986: aload_2
    //   1987: invokevirtual 88	bdoq:a	(ZLjava/lang/String;ILjava/lang/String;)V
    //   1990: return
    //   1991: astore_2
    //   1992: ldc 61
    //   1994: iconst_1
    //   1995: ldc_w 307
    //   1998: aload_2
    //   1999: invokestatic 284	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2002: new 11	java/lang/StringBuilder
    //   2005: dup
    //   2006: invokespecial 14	java/lang/StringBuilder:<init>	()V
    //   2009: ldc_w 309
    //   2012: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2015: aload_2
    //   2016: invokevirtual 310	java/io/IOException:getMessage	()Ljava/lang/String;
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
    //   2064: invokevirtual 291	java/io/BufferedInputStream:close	()V
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
    //   2116: invokevirtual 292	java/io/ByteArrayOutputStream:close	()V
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
    //   2150: invokevirtual 88	bdoq:a	(ZLjava/lang/String;ILjava/lang/String;)V
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
    //   2193: invokevirtual 291	java/io/BufferedInputStream:close	()V
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
    //   2235: invokevirtual 292	java/io/ByteArrayOutputStream:close	()V
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
    //   2278: invokevirtual 88	bdoq:a	(ZLjava/lang/String;ILjava/lang/String;)V
    //   2281: return
    //   2282: aload_3
    //   2283: iconst_0
    //   2284: aconst_null
    //   2285: iload 7
    //   2287: aload_0
    //   2288: invokevirtual 88	bdoq:a	(ZLjava/lang/String;ILjava/lang/String;)V
    //   2291: return
    //   2292: aload_3
    //   2293: iconst_0
    //   2294: aconst_null
    //   2295: iload 8
    //   2297: aload 13
    //   2299: invokevirtual 88	bdoq:a	(ZLjava/lang/String;ILjava/lang/String;)V
    //   2302: goto -149 -> 2153
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2305	0	paramString1	String
    //   0	2305	1	parambdnp	bdnp
    //   0	2305	2	paramString2	String
    //   0	2305	3	parambdoq	bdoq
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
    //   10: new 313	java/io/File
    //   13: dup
    //   14: getstatic 31	bdoo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   17: invokespecial 314	java/io/File:<init>	(Ljava/lang/String;)V
    //   20: astore 10
    //   22: aload 9
    //   24: astore 7
    //   26: aload 10
    //   28: invokevirtual 318	java/io/File:exists	()Z
    //   31: ifne +144 -> 175
    //   34: aload 9
    //   36: astore 7
    //   38: aload 10
    //   40: invokevirtual 321	java/io/File:mkdirs	()Z
    //   43: pop
    //   44: aload 9
    //   46: astore 7
    //   48: new 11	java/lang/StringBuilder
    //   51: dup
    //   52: invokespecial 14	java/lang/StringBuilder:<init>	()V
    //   55: aload_0
    //   56: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: ldc 164
    //   61: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: aload_1
    //   65: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: invokevirtual 29	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   71: invokestatic 325	bbea:b	(Ljava/lang/String;)Ljava/lang/String;
    //   74: astore_1
    //   75: aload 9
    //   77: astore 7
    //   79: new 313	java/io/File
    //   82: dup
    //   83: aload 10
    //   85: aload_1
    //   86: invokespecial 328	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   89: astore_0
    //   90: aload 9
    //   92: astore 7
    //   94: aload_0
    //   95: invokevirtual 318	java/io/File:exists	()Z
    //   98: ifeq +12 -> 110
    //   101: aload 9
    //   103: astore 7
    //   105: aload_0
    //   106: invokevirtual 331	java/io/File:delete	()Z
    //   109: pop
    //   110: aload 9
    //   112: astore 7
    //   114: invokestatic 201	java/lang/System:currentTimeMillis	()J
    //   117: ldc2_w 332
    //   120: ldiv
    //   121: lstore 5
    //   123: aload 9
    //   125: astore 7
    //   127: new 335	java/io/DataOutputStream
    //   130: dup
    //   131: new 337	java/io/FileOutputStream
    //   134: dup
    //   135: aload_0
    //   136: invokespecial 340	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   139: invokespecial 343	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   142: astore_0
    //   143: aload_0
    //   144: lload 5
    //   146: lload_2
    //   147: ladd
    //   148: invokevirtual 347	java/io/DataOutputStream:writeLong	(J)V
    //   151: aload_0
    //   152: aload 4
    //   154: aload_1
    //   155: ldc 235
    //   157: invokevirtual 351	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   160: invokestatic 356	bfnt:a	([B[B)[B
    //   163: invokevirtual 359	java/io/DataOutputStream:write	([B)V
    //   166: aload_0
    //   167: ifnull +7 -> 174
    //   170: aload_0
    //   171: invokevirtual 360	java/io/DataOutputStream:close	()V
    //   174: return
    //   175: aload 9
    //   177: astore 7
    //   179: aload 10
    //   181: invokevirtual 363	java/io/File:isFile	()Z
    //   184: ifeq -140 -> 44
    //   187: aload 9
    //   189: astore 7
    //   191: aload 10
    //   193: invokevirtual 331	java/io/File:delete	()Z
    //   196: pop
    //   197: aload 9
    //   199: astore 7
    //   201: aload 10
    //   203: invokevirtual 321	java/io/File:mkdirs	()Z
    //   206: pop
    //   207: goto -163 -> 44
    //   210: astore_1
    //   211: aload 8
    //   213: astore_0
    //   214: aload_0
    //   215: astore 7
    //   217: ldc 61
    //   219: iconst_1
    //   220: aload_1
    //   221: iconst_0
    //   222: anewarray 4	java/lang/Object
    //   225: invokestatic 366	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   228: aload_0
    //   229: ifnull -55 -> 174
    //   232: aload_0
    //   233: invokevirtual 360	java/io/DataOutputStream:close	()V
    //   236: return
    //   237: astore_0
    //   238: ldc 61
    //   240: iconst_1
    //   241: aload_0
    //   242: iconst_0
    //   243: anewarray 4	java/lang/Object
    //   246: invokestatic 366	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   249: return
    //   250: astore_0
    //   251: ldc 61
    //   253: iconst_1
    //   254: aload_0
    //   255: iconst_0
    //   256: anewarray 4	java/lang/Object
    //   259: invokestatic 366	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   262: return
    //   263: astore_0
    //   264: aload 7
    //   266: ifnull +8 -> 274
    //   269: aload 7
    //   271: invokevirtual 360	java/io/DataOutputStream:close	()V
    //   274: aload_0
    //   275: athrow
    //   276: astore_1
    //   277: ldc 61
    //   279: iconst_1
    //   280: aload_1
    //   281: iconst_0
    //   282: anewarray 4	java/lang/Object
    //   285: invokestatic 366	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   288: goto -14 -> 274
    //   291: astore_1
    //   292: aload_0
    //   293: astore 7
    //   295: aload_1
    //   296: astore_0
    //   297: goto -33 -> 264
    //   300: astore_1
    //   301: goto -87 -> 214
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	304	0	paramString1	String
    //   0	304	1	paramString2	String
    //   0	304	2	paramLong	long
    //   0	304	4	paramArrayOfByte	byte[]
    //   121	24	5	l	long
    //   8	286	7	localObject1	Object
    //   4	208	8	localObject2	Object
    //   1	197	9	localObject3	Object
    //   20	182	10	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   10	22	210	java/io/IOException
    //   26	34	210	java/io/IOException
    //   38	44	210	java/io/IOException
    //   48	75	210	java/io/IOException
    //   79	90	210	java/io/IOException
    //   94	101	210	java/io/IOException
    //   105	110	210	java/io/IOException
    //   114	123	210	java/io/IOException
    //   127	143	210	java/io/IOException
    //   179	187	210	java/io/IOException
    //   191	197	210	java/io/IOException
    //   201	207	210	java/io/IOException
    //   232	236	237	java/io/IOException
    //   170	174	250	java/io/IOException
    //   10	22	263	finally
    //   26	34	263	finally
    //   38	44	263	finally
    //   48	75	263	finally
    //   79	90	263	finally
    //   94	101	263	finally
    //   105	110	263	finally
    //   114	123	263	finally
    //   127	143	263	finally
    //   179	187	263	finally
    //   191	197	263	finally
    //   201	207	263	finally
    //   217	228	263	finally
    //   269	274	276	java/io/IOException
    //   143	166	291	finally
    //   143	166	300	java/io/IOException
  }
  
  /* Error */
  public static byte[] a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: new 11	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 14	java/lang/StringBuilder:<init>	()V
    //   10: aload_0
    //   11: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14: ldc 164
    //   16: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: aload_1
    //   20: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: invokevirtual 29	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   26: invokestatic 325	bbea:b	(Ljava/lang/String;)Ljava/lang/String;
    //   29: astore 4
    //   31: new 313	java/io/File
    //   34: dup
    //   35: new 11	java/lang/StringBuilder
    //   38: dup
    //   39: invokespecial 14	java/lang/StringBuilder:<init>	()V
    //   42: getstatic 31	bdoo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   45: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: aload 4
    //   50: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: invokevirtual 29	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: invokespecial 314	java/io/File:<init>	(Ljava/lang/String;)V
    //   59: astore_0
    //   60: aload_0
    //   61: invokevirtual 318	java/io/File:exists	()Z
    //   64: istore_3
    //   65: iload_3
    //   66: ifne +36 -> 102
    //   69: aload 5
    //   71: astore 4
    //   73: iconst_0
    //   74: ifeq +11 -> 85
    //   77: new 369	java/lang/NullPointerException
    //   80: dup
    //   81: invokespecial 370	java/lang/NullPointerException:<init>	()V
    //   84: athrow
    //   85: aload 4
    //   87: areturn
    //   88: astore_0
    //   89: ldc 61
    //   91: iconst_1
    //   92: aload_0
    //   93: iconst_0
    //   94: anewarray 4	java/lang/Object
    //   97: invokestatic 366	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   100: aconst_null
    //   101: areturn
    //   102: new 372	java/io/DataInputStream
    //   105: dup
    //   106: new 374	java/io/FileInputStream
    //   109: dup
    //   110: aload_0
    //   111: invokespecial 375	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   114: invokespecial 376	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   117: astore_1
    //   118: aload_1
    //   119: astore_0
    //   120: aload_1
    //   121: invokevirtual 379	java/io/DataInputStream:readLong	()J
    //   124: invokestatic 201	java/lang/System:currentTimeMillis	()J
    //   127: ldc2_w 332
    //   130: ldiv
    //   131: lcmp
    //   132: ifle +82 -> 214
    //   135: aload_1
    //   136: astore_0
    //   137: aload_1
    //   138: invokevirtual 382	java/io/DataInputStream:available	()I
    //   141: istore_2
    //   142: iload_2
    //   143: ifle +71 -> 214
    //   146: aload_1
    //   147: astore_0
    //   148: iload_2
    //   149: newarray byte
    //   151: astore 6
    //   153: aload_1
    //   154: astore_0
    //   155: aload_1
    //   156: aload 6
    //   158: invokevirtual 385	java/io/DataInputStream:read	([B)I
    //   161: pop
    //   162: aload_1
    //   163: astore_0
    //   164: aload_1
    //   165: invokevirtual 386	java/io/DataInputStream:close	()V
    //   168: aload_1
    //   169: astore_0
    //   170: aload 6
    //   172: aload 4
    //   174: ldc 235
    //   176: invokevirtual 351	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   179: invokestatic 388	bfnt:b	([B[B)[B
    //   182: astore 4
    //   184: aload 4
    //   186: astore_0
    //   187: aload_0
    //   188: astore 4
    //   190: aload_1
    //   191: ifnull -106 -> 85
    //   194: aload_1
    //   195: invokevirtual 386	java/io/DataInputStream:close	()V
    //   198: aload_0
    //   199: areturn
    //   200: astore_1
    //   201: ldc 61
    //   203: iconst_1
    //   204: aload_1
    //   205: iconst_0
    //   206: anewarray 4	java/lang/Object
    //   209: invokestatic 366	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   212: aload_0
    //   213: areturn
    //   214: aload 5
    //   216: astore 4
    //   218: aload_1
    //   219: ifnull -134 -> 85
    //   222: aload_1
    //   223: invokevirtual 386	java/io/DataInputStream:close	()V
    //   226: aconst_null
    //   227: areturn
    //   228: astore_0
    //   229: ldc 61
    //   231: iconst_1
    //   232: aload_0
    //   233: iconst_0
    //   234: anewarray 4	java/lang/Object
    //   237: invokestatic 366	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   240: aconst_null
    //   241: areturn
    //   242: astore 4
    //   244: aconst_null
    //   245: astore_1
    //   246: aload_1
    //   247: astore_0
    //   248: ldc 61
    //   250: iconst_1
    //   251: aload 4
    //   253: iconst_0
    //   254: anewarray 4	java/lang/Object
    //   257: invokestatic 366	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   260: aload 5
    //   262: astore 4
    //   264: aload_1
    //   265: ifnull -180 -> 85
    //   268: aload_1
    //   269: invokevirtual 386	java/io/DataInputStream:close	()V
    //   272: aconst_null
    //   273: areturn
    //   274: astore_0
    //   275: ldc 61
    //   277: iconst_1
    //   278: aload_0
    //   279: iconst_0
    //   280: anewarray 4	java/lang/Object
    //   283: invokestatic 366	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   286: aconst_null
    //   287: areturn
    //   288: astore_1
    //   289: aconst_null
    //   290: astore_0
    //   291: aload_0
    //   292: ifnull +7 -> 299
    //   295: aload_0
    //   296: invokevirtual 386	java/io/DataInputStream:close	()V
    //   299: aload_1
    //   300: athrow
    //   301: astore_0
    //   302: ldc 61
    //   304: iconst_1
    //   305: aload_0
    //   306: iconst_0
    //   307: anewarray 4	java/lang/Object
    //   310: invokestatic 366	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   313: goto -14 -> 299
    //   316: astore_1
    //   317: goto -26 -> 291
    //   320: astore 4
    //   322: goto -76 -> 246
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	325	0	paramString1	String
    //   0	325	1	paramString2	String
    //   141	8	2	i	int
    //   64	2	3	bool	boolean
    //   29	188	4	localObject1	Object
    //   242	10	4	localIOException1	java.io.IOException
    //   262	1	4	localObject2	Object
    //   320	1	4	localIOException2	java.io.IOException
    //   1	260	5	localObject3	Object
    //   151	20	6	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   77	85	88	java/lang/Exception
    //   194	198	200	java/lang/Exception
    //   222	226	228	java/lang/Exception
    //   3	65	242	java/io/IOException
    //   102	118	242	java/io/IOException
    //   268	272	274	java/lang/Exception
    //   3	65	288	finally
    //   102	118	288	finally
    //   295	299	301	java/lang/Exception
    //   120	135	316	finally
    //   137	142	316	finally
    //   148	153	316	finally
    //   155	162	316	finally
    //   164	168	316	finally
    //   170	184	316	finally
    //   248	260	316	finally
    //   120	135	320	java/io/IOException
    //   137	142	320	java/io/IOException
    //   148	153	320	java/io/IOException
    //   155	162	320	java/io/IOException
    //   164	168	320	java/io/IOException
    //   170	184	320	java/io/IOException
  }
  
  public static byte[] a(byte[] paramArrayOfByte, bdnp parambdnp)
  {
    byte[] arrayOfByte1 = parambdnp.jdField_a_of_type_ArrayOfByte;
    parambdnp = parambdnp.jdField_b_of_type_ArrayOfByte;
    paramArrayOfByte = cryptor.encrypt(paramArrayOfByte, 0, paramArrayOfByte.length, parambdnp);
    parambdnp = new byte[arrayOfByte1.length + 4 + paramArrayOfByte.length];
    byte[] arrayOfByte2 = new byte[4];
    arrayOfByte2[0] = ((byte)(arrayOfByte1.length >> 24));
    arrayOfByte2[1] = ((byte)(arrayOfByte1.length >> 16));
    arrayOfByte2[2] = ((byte)(arrayOfByte1.length >> 8));
    arrayOfByte2[3] = ((byte)(arrayOfByte1.length >> 0));
    System.arraycopy(arrayOfByte2, 0, parambdnp, 0, arrayOfByte2.length);
    System.arraycopy(arrayOfByte1, 0, parambdnp, arrayOfByte2.length, arrayOfByte1.length);
    int i = arrayOfByte2.length;
    System.arraycopy(paramArrayOfByte, 0, parambdnp, arrayOfByte1.length + i, paramArrayOfByte.length);
    return parambdnp;
  }
  
  /* Error */
  public static String[] a(android.app.Activity paramActivity, String paramString)
  {
    // Byte code:
    //   0: ldc 81
    //   2: astore_2
    //   3: new 11	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 14	java/lang/StringBuilder:<init>	()V
    //   10: invokestatic 201	java/lang/System:currentTimeMillis	()J
    //   13: ldc2_w 332
    //   16: ldiv
    //   17: invokevirtual 408	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   20: ldc 81
    //   22: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: invokevirtual 29	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: astore 4
    //   30: iconst_3
    //   31: anewarray 35	java/lang/String
    //   34: astore 5
    //   36: aload 5
    //   38: iconst_0
    //   39: ldc 81
    //   41: aastore
    //   42: aload 5
    //   44: iconst_1
    //   45: ldc 81
    //   47: aastore
    //   48: aload 5
    //   50: iconst_2
    //   51: ldc 81
    //   53: aastore
    //   54: aload_0
    //   55: invokevirtual 414	android/app/Activity:getPackageManager	()Landroid/content/pm/PackageManager;
    //   58: astore_3
    //   59: aload_2
    //   60: astore_0
    //   61: aload_3
    //   62: aload_1
    //   63: bipush 64
    //   65: invokevirtual 420	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   68: getfield 426	android/content/pm/PackageInfo:signatures	[Landroid/content/pm/Signature;
    //   71: astore 6
    //   73: aload_2
    //   74: astore_0
    //   75: ldc_w 428
    //   78: invokestatic 434	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   81: astore_3
    //   82: aload_2
    //   83: astore_0
    //   84: aload_3
    //   85: aload 6
    //   87: iconst_0
    //   88: aaload
    //   89: invokevirtual 440	android/content/pm/Signature:toByteArray	()[B
    //   92: invokevirtual 443	java/security/MessageDigest:update	([B)V
    //   95: aload_2
    //   96: astore_0
    //   97: aload_3
    //   98: invokevirtual 446	java/security/MessageDigest:digest	()[B
    //   101: invokestatic 449	bbea:a	([B)Ljava/lang/String;
    //   104: invokevirtual 452	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   107: astore_2
    //   108: aload_2
    //   109: astore_0
    //   110: aload_3
    //   111: invokevirtual 455	java/security/MessageDigest:reset	()V
    //   114: aload_2
    //   115: astore_0
    //   116: aload_3
    //   117: new 11	java/lang/StringBuilder
    //   120: dup
    //   121: invokespecial 14	java/lang/StringBuilder:<init>	()V
    //   124: aload_1
    //   125: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: ldc 164
    //   130: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: aload_2
    //   134: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: ldc 164
    //   139: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: aload 4
    //   144: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: ldc 81
    //   149: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: invokevirtual 29	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   155: invokevirtual 457	java/lang/String:getBytes	()[B
    //   158: invokevirtual 443	java/security/MessageDigest:update	([B)V
    //   161: aload_2
    //   162: astore_0
    //   163: aload_3
    //   164: invokevirtual 446	java/security/MessageDigest:digest	()[B
    //   167: invokestatic 449	bbea:a	([B)Ljava/lang/String;
    //   170: astore_1
    //   171: ldc 61
    //   173: iconst_1
    //   174: ldc_w 459
    //   177: invokestatic 462	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
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
    //   202: ldc 81
    //   204: astore_1
    //   205: ldc 61
    //   207: iconst_1
    //   208: iconst_2
    //   209: anewarray 4	java/lang/Object
    //   212: dup
    //   213: iconst_0
    //   214: ldc_w 464
    //   217: aastore
    //   218: dup
    //   219: iconst_1
    //   220: aload_2
    //   221: invokevirtual 465	java/lang/Exception:toString	()Ljava/lang/String;
    //   224: aastore
    //   225: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
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
  
  public static byte[] b(byte[] paramArrayOfByte, bdnp parambdnp)
  {
    parambdnp = parambdnp.jdField_b_of_type_ArrayOfByte;
    return cryptor.decrypt(paramArrayOfByte, 0, paramArrayOfByte.length, parambdnp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bdoo
 * JD-Core Version:    0.7.0.1
 */