package com.tencent.mobileqq.app;

import ajvw;
import bayr;
import com.tencent.mobileqq.nearby.NearbyAppInterface;

public class NearByFaceDownloader
  extends FaceDownloader
{
  ajvw jdField_a_of_type_Ajvw = null;
  bayr jdField_a_of_type_Bayr = null;
  NearbyAppInterface jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface = null;
  
  public NearByFaceDownloader(NearbyAppInterface paramNearbyAppInterface)
  {
    super(paramNearbyAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface = paramNearbyAppInterface;
    this.jdField_a_of_type_Ajvw = ((ajvw)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a(4));
    this.jdField_a_of_type_Bayr = ((bayr)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getManager(216));
  }
  
  /* Error */
  protected void b(com.tencent.mobileqq.util.FaceInfo paramFaceInfo)
  {
    // Byte code:
    //   0: invokestatic 45	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +28 -> 31
    //   6: ldc 47
    //   8: iconst_2
    //   9: new 49	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   16: ldc 54
    //   18: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: aload_1
    //   22: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   25: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   31: aload_1
    //   32: getstatic 75	com/tencent/mobileqq/util/FaceInfo:n	I
    //   35: invokevirtual 78	com/tencent/mobileqq/util/FaceInfo:a	(I)V
    //   38: aload_1
    //   39: getfield 81	com/tencent/mobileqq/util/FaceInfo:jdField_a_of_type_AvatarInfoQQHeadInfo	LAvatarInfo/QQHeadInfo;
    //   42: astore 32
    //   44: iconst_0
    //   45: istore 21
    //   47: iconst_0
    //   48: istore 7
    //   50: iconst_0
    //   51: istore 4
    //   53: iconst_0
    //   54: istore 12
    //   56: iconst_0
    //   57: istore 13
    //   59: iconst_0
    //   60: istore 14
    //   62: iconst_0
    //   63: istore 9
    //   65: aload 32
    //   67: getfield 87	AvatarInfo/QQHeadInfo:downLoadUrl	Ljava/lang/String;
    //   70: astore 29
    //   72: iconst_0
    //   73: istore_3
    //   74: iconst_0
    //   75: istore 11
    //   77: iconst_0
    //   78: istore 16
    //   80: iconst_0
    //   81: istore 10
    //   83: iconst_0
    //   84: istore 15
    //   86: iconst_0
    //   87: istore 18
    //   89: iconst_0
    //   90: istore 17
    //   92: iconst_0
    //   93: istore 19
    //   95: iconst_0
    //   96: istore_2
    //   97: iload 11
    //   99: istore 8
    //   101: iload 12
    //   103: istore 5
    //   105: aload 29
    //   107: astore 27
    //   109: iload 18
    //   111: istore 6
    //   113: aload 32
    //   115: getfield 87	AvatarInfo/QQHeadInfo:downLoadUrl	Ljava/lang/String;
    //   118: invokestatic 93	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   121: ifne +2264 -> 2385
    //   124: iload 11
    //   126: istore 8
    //   128: iload 12
    //   130: istore 5
    //   132: aload 29
    //   134: astore 27
    //   136: iload 18
    //   138: istore 6
    //   140: new 49	java/lang/StringBuilder
    //   143: dup
    //   144: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   147: ldc 95
    //   149: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: aload_1
    //   153: getfield 97	com/tencent/mobileqq/util/FaceInfo:b	I
    //   156: invokestatic 102	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   159: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: ldc 104
    //   164: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: aload_1
    //   168: getfield 106	com/tencent/mobileqq/util/FaceInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   171: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   177: astore 28
    //   179: iload 11
    //   181: istore 8
    //   183: iload 12
    //   185: istore 5
    //   187: aload 29
    //   189: astore 27
    //   191: iload 18
    //   193: istore 6
    //   195: aload_0
    //   196: getfield 15	com/tencent/mobileqq/app/NearByFaceDownloader:jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface	Lcom/tencent/mobileqq/nearby/NearbyAppInterface;
    //   199: sipush 216
    //   202: invokevirtual 30	com/tencent/mobileqq/nearby/NearbyAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   205: checkcast 32	bayr
    //   208: astore 26
    //   210: iload 11
    //   212: istore 8
    //   214: iload 12
    //   216: istore 5
    //   218: aload 29
    //   220: astore 27
    //   222: iload 18
    //   224: istore 6
    //   226: aload 26
    //   228: aload 28
    //   230: invokevirtual 109	bayr:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Setting;
    //   233: astore 31
    //   235: aload 31
    //   237: ifnonnull +2145 -> 2382
    //   240: iload 11
    //   242: istore 8
    //   244: iload 12
    //   246: istore 5
    //   248: aload 29
    //   250: astore 27
    //   252: iload 18
    //   254: istore 6
    //   256: new 111	com/tencent/mobileqq/data/Setting
    //   259: dup
    //   260: invokespecial 112	com/tencent/mobileqq/data/Setting:<init>	()V
    //   263: astore 31
    //   265: iload 11
    //   267: istore 8
    //   269: iload 12
    //   271: istore 5
    //   273: aload 29
    //   275: astore 27
    //   277: iload 18
    //   279: istore 6
    //   281: aload 31
    //   283: aload 28
    //   285: putfield 115	com/tencent/mobileqq/data/Setting:uin	Ljava/lang/String;
    //   288: iload 11
    //   290: istore 8
    //   292: iload 12
    //   294: istore 5
    //   296: aload 29
    //   298: astore 27
    //   300: iload 18
    //   302: istore 6
    //   304: aload 31
    //   306: aload 32
    //   308: getfield 119	AvatarInfo/QQHeadInfo:dwFaceFlgas	B
    //   311: putfield 122	com/tencent/mobileqq/data/Setting:bFaceFlags	B
    //   314: iload 11
    //   316: istore 8
    //   318: iload 12
    //   320: istore 5
    //   322: aload 29
    //   324: astore 27
    //   326: iload 18
    //   328: istore 6
    //   330: aload 31
    //   332: aload 32
    //   334: getfield 125	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   337: putfield 128	com/tencent/mobileqq/data/Setting:bUsrType	B
    //   340: iload 11
    //   342: istore 8
    //   344: iload 12
    //   346: istore 5
    //   348: aload 29
    //   350: astore 27
    //   352: iload 18
    //   354: istore 6
    //   356: aload 31
    //   358: aload 32
    //   360: getfield 87	AvatarInfo/QQHeadInfo:downLoadUrl	Ljava/lang/String;
    //   363: putfield 131	com/tencent/mobileqq/data/Setting:url	Ljava/lang/String;
    //   366: iload 11
    //   368: istore 8
    //   370: iload 12
    //   372: istore 5
    //   374: aload 29
    //   376: astore 27
    //   378: iload 18
    //   380: istore 6
    //   382: aload 31
    //   384: invokestatic 137	java/lang/System:currentTimeMillis	()J
    //   387: putfield 141	com/tencent/mobileqq/data/Setting:updateTimestamp	J
    //   390: iload 11
    //   392: istore 8
    //   394: iload 12
    //   396: istore 5
    //   398: aload 29
    //   400: astore 27
    //   402: iload 18
    //   404: istore 6
    //   406: aload 31
    //   408: aload 32
    //   410: getfield 144	AvatarInfo/QQHeadInfo:headLevel	B
    //   413: putfield 147	com/tencent/mobileqq/data/Setting:bSourceType	B
    //   416: iload 11
    //   418: istore 8
    //   420: iload 12
    //   422: istore 5
    //   424: aload 29
    //   426: astore 27
    //   428: iload 18
    //   430: istore 6
    //   432: aload 31
    //   434: aload 32
    //   436: getfield 150	AvatarInfo/QQHeadInfo:cHeadType	B
    //   439: putfield 153	com/tencent/mobileqq/data/Setting:bHeadType	B
    //   442: iload 11
    //   444: istore 8
    //   446: iload 12
    //   448: istore 5
    //   450: aload 29
    //   452: astore 27
    //   454: iload 18
    //   456: istore 6
    //   458: aload 31
    //   460: aload 32
    //   462: getfield 157	AvatarInfo/QQHeadInfo:systemHeadID	S
    //   465: putfield 158	com/tencent/mobileqq/data/Setting:systemHeadID	S
    //   468: iload 11
    //   470: istore 8
    //   472: iload 12
    //   474: istore 5
    //   476: aload 29
    //   478: astore 27
    //   480: iload 18
    //   482: istore 6
    //   484: aload 31
    //   486: aload 32
    //   488: getfield 161	AvatarInfo/QQHeadInfo:dwTimestamp	J
    //   491: putfield 164	com/tencent/mobileqq/data/Setting:headImgTimestamp	J
    //   494: iload 11
    //   496: istore 8
    //   498: iload 12
    //   500: istore 5
    //   502: aload 29
    //   504: astore 27
    //   506: iload 18
    //   508: istore 6
    //   510: aload 26
    //   512: aload_1
    //   513: invokevirtual 167	bayr:a	(Lcom/tencent/mobileqq/util/FaceInfo;)Ljava/lang/String;
    //   516: astore 26
    //   518: iload 11
    //   520: istore 8
    //   522: iload 12
    //   524: istore 5
    //   526: aload 29
    //   528: astore 27
    //   530: iload 18
    //   532: istore 6
    //   534: iload 21
    //   536: istore 20
    //   538: iload 14
    //   540: istore 7
    //   542: aload 29
    //   544: astore 28
    //   546: iload 19
    //   548: istore_3
    //   549: new 169	java/io/File
    //   552: dup
    //   553: aload 26
    //   555: iconst_0
    //   556: aload 26
    //   558: ldc 171
    //   560: invokevirtual 177	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   563: invokevirtual 181	java/lang/String:substring	(II)Ljava/lang/String;
    //   566: invokespecial 184	java/io/File:<init>	(Ljava/lang/String;)V
    //   569: astore 30
    //   571: aload 30
    //   573: ifnull +79 -> 652
    //   576: iload 11
    //   578: istore 8
    //   580: iload 12
    //   582: istore 5
    //   584: aload 29
    //   586: astore 27
    //   588: iload 18
    //   590: istore 6
    //   592: iload 21
    //   594: istore 20
    //   596: iload 14
    //   598: istore 7
    //   600: aload 29
    //   602: astore 28
    //   604: iload 19
    //   606: istore_3
    //   607: aload 30
    //   609: invokevirtual 187	java/io/File:exists	()Z
    //   612: ifne +40 -> 652
    //   615: iload 11
    //   617: istore 8
    //   619: iload 12
    //   621: istore 5
    //   623: aload 29
    //   625: astore 27
    //   627: iload 18
    //   629: istore 6
    //   631: iload 21
    //   633: istore 20
    //   635: iload 14
    //   637: istore 7
    //   639: aload 29
    //   641: astore 28
    //   643: iload 19
    //   645: istore_3
    //   646: aload 30
    //   648: invokevirtual 190	java/io/File:mkdirs	()Z
    //   651: pop
    //   652: iload 11
    //   654: istore 8
    //   656: iload 12
    //   658: istore 5
    //   660: aload 29
    //   662: astore 27
    //   664: iload 18
    //   666: istore 6
    //   668: iload 21
    //   670: istore 20
    //   672: iload 14
    //   674: istore 7
    //   676: aload 29
    //   678: astore 28
    //   680: iload 19
    //   682: istore_3
    //   683: new 169	java/io/File
    //   686: dup
    //   687: aload 26
    //   689: invokespecial 184	java/io/File:<init>	(Ljava/lang/String;)V
    //   692: astore 33
    //   694: iload 11
    //   696: istore 8
    //   698: iload 12
    //   700: istore 5
    //   702: aload 29
    //   704: astore 27
    //   706: iload 18
    //   708: istore 6
    //   710: iload 21
    //   712: istore 20
    //   714: iload 14
    //   716: istore 7
    //   718: aload 29
    //   720: astore 28
    //   722: iload 19
    //   724: istore_3
    //   725: aload_0
    //   726: aload 32
    //   728: getfield 87	AvatarInfo/QQHeadInfo:downLoadUrl	Ljava/lang/String;
    //   731: aload 32
    //   733: getfield 119	AvatarInfo/QQHeadInfo:dwFaceFlgas	B
    //   736: aload 32
    //   738: getfield 125	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   741: aload 32
    //   743: getfield 193	AvatarInfo/QQHeadInfo:originUsrType	I
    //   746: invokevirtual 196	com/tencent/mobileqq/app/NearByFaceDownloader:a	(Ljava/lang/String;BBI)Ljava/lang/String;
    //   749: astore 29
    //   751: iload 11
    //   753: istore 8
    //   755: iload 12
    //   757: istore 5
    //   759: aload 29
    //   761: astore 27
    //   763: iload 18
    //   765: istore 6
    //   767: iload 21
    //   769: istore 20
    //   771: iload 14
    //   773: istore 7
    //   775: aload 29
    //   777: astore 28
    //   779: iload 19
    //   781: istore_3
    //   782: ldc 198
    //   784: aload 29
    //   786: invokestatic 204	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:insertMtype	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   789: astore 29
    //   791: iload 11
    //   793: istore 8
    //   795: iload 12
    //   797: istore 5
    //   799: aload 29
    //   801: astore 27
    //   803: iload 18
    //   805: istore 6
    //   807: iload 21
    //   809: istore 20
    //   811: iload 14
    //   813: istore 7
    //   815: aload 29
    //   817: astore 28
    //   819: iload 19
    //   821: istore_3
    //   822: new 49	java/lang/StringBuilder
    //   825: dup
    //   826: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   829: aload 29
    //   831: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   834: ldc 206
    //   836: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   839: invokestatic 137	java/lang/System:currentTimeMillis	()J
    //   842: invokevirtual 209	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   845: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   848: astore 29
    //   850: aload_0
    //   851: aload 29
    //   853: aload 33
    //   855: aload_1
    //   856: iconst_1
    //   857: invokevirtual 212	com/tencent/mobileqq/app/NearByFaceDownloader:a	(Ljava/lang/String;Ljava/io/File;Lcom/tencent/mobileqq/util/FaceInfo;Z)I
    //   860: istore_2
    //   861: iload_2
    //   862: ifeq +1513 -> 2375
    //   865: iconst_1
    //   866: invokestatic 218	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getActiveNetIpFamily	(Z)I
    //   869: iconst_3
    //   870: if_icmpne +1505 -> 2375
    //   873: aload_0
    //   874: aload 32
    //   876: getfield 87	AvatarInfo/QQHeadInfo:downLoadUrl	Ljava/lang/String;
    //   879: aload 32
    //   881: getfield 119	AvatarInfo/QQHeadInfo:dwFaceFlgas	B
    //   884: aload 32
    //   886: getfield 125	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   889: aload 32
    //   891: getfield 193	AvatarInfo/QQHeadInfo:originUsrType	I
    //   894: iconst_1
    //   895: invokevirtual 221	com/tencent/mobileqq/app/NearByFaceDownloader:a	(Ljava/lang/String;BBIZ)Ljava/lang/String;
    //   898: astore 27
    //   900: aload 27
    //   902: astore 29
    //   904: aload 29
    //   906: astore 28
    //   908: aload 29
    //   910: astore 27
    //   912: ldc 198
    //   914: aload 29
    //   916: invokestatic 204	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:insertMtype	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   919: astore 29
    //   921: aload 29
    //   923: astore 28
    //   925: aload 29
    //   927: astore 27
    //   929: new 49	java/lang/StringBuilder
    //   932: dup
    //   933: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   936: aload 29
    //   938: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   941: ldc 206
    //   943: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   946: invokestatic 137	java/lang/System:currentTimeMillis	()J
    //   949: invokevirtual 209	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   952: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   955: astore 30
    //   957: aload 30
    //   959: astore 28
    //   961: aload 30
    //   963: astore 27
    //   965: aload_0
    //   966: aload 30
    //   968: aload 33
    //   970: aload_1
    //   971: iconst_1
    //   972: invokevirtual 212	com/tencent/mobileqq/app/NearByFaceDownloader:a	(Ljava/lang/String;Ljava/io/File;Lcom/tencent/mobileqq/util/FaceInfo;Z)I
    //   975: istore_3
    //   976: iload_3
    //   977: istore_2
    //   978: iload 11
    //   980: istore 8
    //   982: iload 12
    //   984: istore 5
    //   986: aload 30
    //   988: astore 27
    //   990: iload_2
    //   991: istore 6
    //   993: iload 21
    //   995: istore 20
    //   997: iload 14
    //   999: istore 7
    //   1001: aload 30
    //   1003: astore 28
    //   1005: iload_2
    //   1006: istore_3
    //   1007: ldc 47
    //   1009: iconst_1
    //   1010: new 49	java/lang/StringBuilder
    //   1013: dup
    //   1014: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   1017: ldc 223
    //   1019: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1022: aload 30
    //   1024: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1027: ldc 225
    //   1029: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1032: iload_2
    //   1033: invokevirtual 228	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1036: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1039: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1042: iload_2
    //   1043: ifne +602 -> 1645
    //   1046: iload 11
    //   1048: istore 8
    //   1050: iload 12
    //   1052: istore 5
    //   1054: aload 30
    //   1056: astore 27
    //   1058: iload_2
    //   1059: istore 6
    //   1061: iload 21
    //   1063: istore 20
    //   1065: iload 14
    //   1067: istore 7
    //   1069: aload 30
    //   1071: astore 28
    //   1073: iload_2
    //   1074: istore_3
    //   1075: aload 33
    //   1077: invokevirtual 231	java/io/File:length	()J
    //   1080: l2i
    //   1081: istore 4
    //   1083: iconst_1
    //   1084: istore 20
    //   1086: iload 11
    //   1088: istore 8
    //   1090: iload 4
    //   1092: istore 5
    //   1094: aload 30
    //   1096: astore 27
    //   1098: iload_2
    //   1099: istore 6
    //   1101: iload 4
    //   1103: istore 7
    //   1105: aload 30
    //   1107: astore 28
    //   1109: iload_2
    //   1110: istore_3
    //   1111: new 233	com/tencent/mobileqq/app/NearByFaceDownloader$UpdateSettingRunnable
    //   1114: dup
    //   1115: aload_0
    //   1116: aload 31
    //   1118: aload_1
    //   1119: invokespecial 236	com/tencent/mobileqq/app/NearByFaceDownloader$UpdateSettingRunnable:<init>	(Lcom/tencent/mobileqq/app/NearByFaceDownloader;Lcom/tencent/mobileqq/data/Setting;Lcom/tencent/mobileqq/util/FaceInfo;)V
    //   1122: aconst_null
    //   1123: iconst_0
    //   1124: invokestatic 242	com/tencent/mobileqq/app/ThreadManager:postImmediately	(Ljava/lang/Runnable;Lcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   1127: iconst_0
    //   1128: istore_3
    //   1129: iconst_1
    //   1130: istore 20
    //   1132: iload 4
    //   1134: istore 7
    //   1136: iload 10
    //   1138: istore 4
    //   1140: iload 20
    //   1142: ifeq +28 -> 1170
    //   1145: iload 4
    //   1147: istore 8
    //   1149: iload 7
    //   1151: istore 5
    //   1153: aload 30
    //   1155: astore 27
    //   1157: iload_2
    //   1158: istore 6
    //   1160: aload_0
    //   1161: getfield 17	com/tencent/mobileqq/app/NearByFaceDownloader:jdField_a_of_type_Ajvw	Lajvw;
    //   1164: iconst_0
    //   1165: iconst_1
    //   1166: aload_1
    //   1167: invokevirtual 246	ajvw:notifyUI	(IZLjava/lang/Object;)V
    //   1170: iload 4
    //   1172: istore 8
    //   1174: iload 7
    //   1176: istore 5
    //   1178: aload 30
    //   1180: astore 27
    //   1182: iload_2
    //   1183: istore 6
    //   1185: aload_0
    //   1186: getfield 17	com/tencent/mobileqq/app/NearByFaceDownloader:jdField_a_of_type_Ajvw	Lajvw;
    //   1189: iconst_1
    //   1190: iconst_1
    //   1191: aload_1
    //   1192: invokevirtual 246	ajvw:notifyUI	(IZLjava/lang/Object;)V
    //   1195: aload 30
    //   1197: astore 29
    //   1199: lconst_0
    //   1200: lstore 24
    //   1202: aload_1
    //   1203: getfield 249	com/tencent/mobileqq/util/FaceInfo:e	I
    //   1206: iconst_1
    //   1207: if_icmpne +566 -> 1773
    //   1210: lload 24
    //   1212: lstore 22
    //   1214: aload_1
    //   1215: getfield 252	com/tencent/mobileqq/util/FaceInfo:jdField_a_of_type_ArrayOfLong	[J
    //   1218: getstatic 255	com/tencent/mobileqq/util/FaceInfo:o	I
    //   1221: laload
    //   1222: lconst_0
    //   1223: lcmp
    //   1224: ifle +39 -> 1263
    //   1227: lload 24
    //   1229: lstore 22
    //   1231: aload_1
    //   1232: getfield 252	com/tencent/mobileqq/util/FaceInfo:jdField_a_of_type_ArrayOfLong	[J
    //   1235: getstatic 75	com/tencent/mobileqq/util/FaceInfo:n	I
    //   1238: laload
    //   1239: lconst_0
    //   1240: lcmp
    //   1241: ifle +22 -> 1263
    //   1244: aload_1
    //   1245: getfield 252	com/tencent/mobileqq/util/FaceInfo:jdField_a_of_type_ArrayOfLong	[J
    //   1248: getstatic 255	com/tencent/mobileqq/util/FaceInfo:o	I
    //   1251: laload
    //   1252: aload_1
    //   1253: getfield 252	com/tencent/mobileqq/util/FaceInfo:jdField_a_of_type_ArrayOfLong	[J
    //   1256: getstatic 75	com/tencent/mobileqq/util/FaceInfo:n	I
    //   1259: laload
    //   1260: lsub
    //   1261: lstore 22
    //   1263: new 257	com/tencent/mobileqq/app/NearByFaceDownloader$HeadCostStatRunnable
    //   1266: dup
    //   1267: aload_0
    //   1268: iload 4
    //   1270: aload_1
    //   1271: iconst_4
    //   1272: iload 7
    //   1274: aload 29
    //   1276: iload_2
    //   1277: lload 22
    //   1279: invokespecial 260	com/tencent/mobileqq/app/NearByFaceDownloader$HeadCostStatRunnable:<init>	(Lcom/tencent/mobileqq/app/NearByFaceDownloader;ILcom/tencent/mobileqq/util/FaceInfo;IILjava/lang/String;IJ)V
    //   1282: aconst_null
    //   1283: iconst_0
    //   1284: invokestatic 242	com/tencent/mobileqq/app/ThreadManager:postImmediately	(Ljava/lang/Runnable;Lcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   1287: aload 26
    //   1289: astore 28
    //   1291: iload_3
    //   1292: istore_2
    //   1293: aload 29
    //   1295: astore 26
    //   1297: invokestatic 45	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1300: ifne +8 -> 1308
    //   1303: iload 20
    //   1305: ifne +192 -> 1497
    //   1308: ldc 47
    //   1310: iconst_2
    //   1311: new 49	java/lang/StringBuilder
    //   1314: dup
    //   1315: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   1318: ldc_w 262
    //   1321: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1324: aload_1
    //   1325: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1328: ldc_w 264
    //   1331: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1334: iload 20
    //   1336: invokevirtual 267	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1339: ldc_w 269
    //   1342: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1345: iload 4
    //   1347: invokevirtual 228	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1350: ldc_w 271
    //   1353: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1356: aload 32
    //   1358: getfield 273	AvatarInfo/QQHeadInfo:uin	J
    //   1361: invokevirtual 209	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1364: ldc_w 275
    //   1367: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1370: aload 32
    //   1372: getfield 278	AvatarInfo/QQHeadInfo:phoneNum	Ljava/lang/String;
    //   1375: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1378: ldc_w 280
    //   1381: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1384: aload 32
    //   1386: getfield 150	AvatarInfo/QQHeadInfo:cHeadType	B
    //   1389: invokevirtual 228	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1392: ldc_w 282
    //   1395: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1398: aload 32
    //   1400: getfield 125	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   1403: invokevirtual 228	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1406: ldc_w 284
    //   1409: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1412: aload 32
    //   1414: getfield 157	AvatarInfo/QQHeadInfo:systemHeadID	S
    //   1417: invokevirtual 228	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1420: ldc_w 286
    //   1423: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1426: iload_2
    //   1427: invokevirtual 228	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1430: ldc_w 288
    //   1433: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1436: aload 32
    //   1438: getfield 161	AvatarInfo/QQHeadInfo:dwTimestamp	J
    //   1441: invokevirtual 209	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1444: ldc_w 290
    //   1447: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1450: aload 28
    //   1452: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1455: ldc_w 292
    //   1458: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1461: aload 26
    //   1463: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1466: ldc_w 294
    //   1469: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1472: aload 32
    //   1474: getfield 87	AvatarInfo/QQHeadInfo:downLoadUrl	Ljava/lang/String;
    //   1477: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1480: ldc_w 296
    //   1483: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1486: aload 32
    //   1488: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1491: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1494: invokestatic 299	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1497: return
    //   1498: astore 26
    //   1500: lconst_0
    //   1501: lstore 24
    //   1503: aload_1
    //   1504: getfield 249	com/tencent/mobileqq/util/FaceInfo:e	I
    //   1507: iconst_1
    //   1508: if_icmpne +81 -> 1589
    //   1511: lload 24
    //   1513: lstore 22
    //   1515: aload_1
    //   1516: getfield 252	com/tencent/mobileqq/util/FaceInfo:jdField_a_of_type_ArrayOfLong	[J
    //   1519: getstatic 255	com/tencent/mobileqq/util/FaceInfo:o	I
    //   1522: laload
    //   1523: lconst_0
    //   1524: lcmp
    //   1525: ifle +39 -> 1564
    //   1528: lload 24
    //   1530: lstore 22
    //   1532: aload_1
    //   1533: getfield 252	com/tencent/mobileqq/util/FaceInfo:jdField_a_of_type_ArrayOfLong	[J
    //   1536: getstatic 75	com/tencent/mobileqq/util/FaceInfo:n	I
    //   1539: laload
    //   1540: lconst_0
    //   1541: lcmp
    //   1542: ifle +22 -> 1564
    //   1545: aload_1
    //   1546: getfield 252	com/tencent/mobileqq/util/FaceInfo:jdField_a_of_type_ArrayOfLong	[J
    //   1549: getstatic 255	com/tencent/mobileqq/util/FaceInfo:o	I
    //   1552: laload
    //   1553: aload_1
    //   1554: getfield 252	com/tencent/mobileqq/util/FaceInfo:jdField_a_of_type_ArrayOfLong	[J
    //   1557: getstatic 75	com/tencent/mobileqq/util/FaceInfo:n	I
    //   1560: laload
    //   1561: lsub
    //   1562: lstore 22
    //   1564: new 257	com/tencent/mobileqq/app/NearByFaceDownloader$HeadCostStatRunnable
    //   1567: dup
    //   1568: aload_0
    //   1569: sipush 9202
    //   1572: aload_1
    //   1573: iconst_4
    //   1574: iconst_0
    //   1575: aload 29
    //   1577: iconst_0
    //   1578: lload 22
    //   1580: invokespecial 260	com/tencent/mobileqq/app/NearByFaceDownloader$HeadCostStatRunnable:<init>	(Lcom/tencent/mobileqq/app/NearByFaceDownloader;ILcom/tencent/mobileqq/util/FaceInfo;IILjava/lang/String;IJ)V
    //   1583: aconst_null
    //   1584: iconst_0
    //   1585: invokestatic 242	com/tencent/mobileqq/app/ThreadManager:postImmediately	(Ljava/lang/Runnable;Lcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   1588: return
    //   1589: lload 24
    //   1591: lstore 22
    //   1593: aload_1
    //   1594: getfield 252	com/tencent/mobileqq/util/FaceInfo:jdField_a_of_type_ArrayOfLong	[J
    //   1597: getstatic 255	com/tencent/mobileqq/util/FaceInfo:o	I
    //   1600: laload
    //   1601: lconst_0
    //   1602: lcmp
    //   1603: ifle -39 -> 1564
    //   1606: lload 24
    //   1608: lstore 22
    //   1610: aload_1
    //   1611: getfield 252	com/tencent/mobileqq/util/FaceInfo:jdField_a_of_type_ArrayOfLong	[J
    //   1614: getstatic 302	com/tencent/mobileqq/util/FaceInfo:l	I
    //   1617: laload
    //   1618: lconst_0
    //   1619: lcmp
    //   1620: ifle -56 -> 1564
    //   1623: aload_1
    //   1624: getfield 252	com/tencent/mobileqq/util/FaceInfo:jdField_a_of_type_ArrayOfLong	[J
    //   1627: getstatic 255	com/tencent/mobileqq/util/FaceInfo:o	I
    //   1630: laload
    //   1631: aload_1
    //   1632: getfield 252	com/tencent/mobileqq/util/FaceInfo:jdField_a_of_type_ArrayOfLong	[J
    //   1635: getstatic 302	com/tencent/mobileqq/util/FaceInfo:l	I
    //   1638: laload
    //   1639: lsub
    //   1640: lstore 22
    //   1642: goto -78 -> 1564
    //   1645: iload_2
    //   1646: lookupswitch	default:+42->1688, 1:+59->1705, 4:+76->1722, 5:+110->1756, 33:+93->1739
    //   1689: fload_1
    //   1690: <illegal opcode>
    //   1691: istore 4
    //   1693: iload_2
    //   1694: istore_3
    //   1695: iconst_0
    //   1696: istore 20
    //   1698: iload 9
    //   1700: istore 7
    //   1702: goto -562 -> 1140
    //   1705: sipush 9206
    //   1708: istore 4
    //   1710: iconst_0
    //   1711: istore_3
    //   1712: iconst_0
    //   1713: istore 20
    //   1715: iload 9
    //   1717: istore 7
    //   1719: goto -579 -> 1140
    //   1722: sipush 9202
    //   1725: istore 4
    //   1727: iconst_0
    //   1728: istore_3
    //   1729: iconst_0
    //   1730: istore 20
    //   1732: iload 9
    //   1734: istore 7
    //   1736: goto -596 -> 1140
    //   1739: sipush 9208
    //   1742: istore 4
    //   1744: iload_2
    //   1745: istore_3
    //   1746: iconst_0
    //   1747: istore 20
    //   1749: iload 9
    //   1751: istore 7
    //   1753: goto -613 -> 1140
    //   1756: sipush 9204
    //   1759: istore 4
    //   1761: iconst_0
    //   1762: istore_3
    //   1763: iconst_0
    //   1764: istore 20
    //   1766: iload 9
    //   1768: istore 7
    //   1770: goto -630 -> 1140
    //   1773: lload 24
    //   1775: lstore 22
    //   1777: aload_1
    //   1778: getfield 252	com/tencent/mobileqq/util/FaceInfo:jdField_a_of_type_ArrayOfLong	[J
    //   1781: getstatic 255	com/tencent/mobileqq/util/FaceInfo:o	I
    //   1784: laload
    //   1785: lconst_0
    //   1786: lcmp
    //   1787: ifle -524 -> 1263
    //   1790: lload 24
    //   1792: lstore 22
    //   1794: aload_1
    //   1795: getfield 252	com/tencent/mobileqq/util/FaceInfo:jdField_a_of_type_ArrayOfLong	[J
    //   1798: getstatic 302	com/tencent/mobileqq/util/FaceInfo:l	I
    //   1801: laload
    //   1802: lconst_0
    //   1803: lcmp
    //   1804: ifle -541 -> 1263
    //   1807: aload_1
    //   1808: getfield 252	com/tencent/mobileqq/util/FaceInfo:jdField_a_of_type_ArrayOfLong	[J
    //   1811: getstatic 255	com/tencent/mobileqq/util/FaceInfo:o	I
    //   1814: laload
    //   1815: aload_1
    //   1816: getfield 252	com/tencent/mobileqq/util/FaceInfo:jdField_a_of_type_ArrayOfLong	[J
    //   1819: getstatic 302	com/tencent/mobileqq/util/FaceInfo:l	I
    //   1822: laload
    //   1823: lsub
    //   1824: lstore 22
    //   1826: goto -563 -> 1263
    //   1829: astore 27
    //   1831: iconst_0
    //   1832: istore_2
    //   1833: iconst_0
    //   1834: istore 20
    //   1836: aconst_null
    //   1837: astore 28
    //   1839: iload 15
    //   1841: istore_3
    //   1842: aload 29
    //   1844: astore 26
    //   1846: iload 4
    //   1848: istore 7
    //   1850: aload 27
    //   1852: astore 29
    //   1854: sipush 9204
    //   1857: istore 4
    //   1859: iload 4
    //   1861: istore 8
    //   1863: iload 7
    //   1865: istore 5
    //   1867: aload 26
    //   1869: astore 27
    //   1871: iload_3
    //   1872: istore 6
    //   1874: aload 29
    //   1876: invokevirtual 305	java/lang/Throwable:printStackTrace	()V
    //   1879: lconst_0
    //   1880: lstore 24
    //   1882: aload_1
    //   1883: getfield 249	com/tencent/mobileqq/util/FaceInfo:e	I
    //   1886: iconst_1
    //   1887: if_icmpne +84 -> 1971
    //   1890: lload 24
    //   1892: lstore 22
    //   1894: aload_1
    //   1895: getfield 252	com/tencent/mobileqq/util/FaceInfo:jdField_a_of_type_ArrayOfLong	[J
    //   1898: getstatic 255	com/tencent/mobileqq/util/FaceInfo:o	I
    //   1901: laload
    //   1902: lconst_0
    //   1903: lcmp
    //   1904: ifle +39 -> 1943
    //   1907: lload 24
    //   1909: lstore 22
    //   1911: aload_1
    //   1912: getfield 252	com/tencent/mobileqq/util/FaceInfo:jdField_a_of_type_ArrayOfLong	[J
    //   1915: getstatic 75	com/tencent/mobileqq/util/FaceInfo:n	I
    //   1918: laload
    //   1919: lconst_0
    //   1920: lcmp
    //   1921: ifle +22 -> 1943
    //   1924: aload_1
    //   1925: getfield 252	com/tencent/mobileqq/util/FaceInfo:jdField_a_of_type_ArrayOfLong	[J
    //   1928: getstatic 255	com/tencent/mobileqq/util/FaceInfo:o	I
    //   1931: laload
    //   1932: aload_1
    //   1933: getfield 252	com/tencent/mobileqq/util/FaceInfo:jdField_a_of_type_ArrayOfLong	[J
    //   1936: getstatic 75	com/tencent/mobileqq/util/FaceInfo:n	I
    //   1939: laload
    //   1940: lsub
    //   1941: lstore 22
    //   1943: new 257	com/tencent/mobileqq/app/NearByFaceDownloader$HeadCostStatRunnable
    //   1946: dup
    //   1947: aload_0
    //   1948: sipush 9204
    //   1951: aload_1
    //   1952: iconst_4
    //   1953: iload 7
    //   1955: aload 26
    //   1957: iload_3
    //   1958: lload 22
    //   1960: invokespecial 260	com/tencent/mobileqq/app/NearByFaceDownloader$HeadCostStatRunnable:<init>	(Lcom/tencent/mobileqq/app/NearByFaceDownloader;ILcom/tencent/mobileqq/util/FaceInfo;IILjava/lang/String;IJ)V
    //   1963: aconst_null
    //   1964: iconst_0
    //   1965: invokestatic 242	com/tencent/mobileqq/app/ThreadManager:postImmediately	(Ljava/lang/Runnable;Lcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   1968: goto -671 -> 1297
    //   1971: lload 24
    //   1973: lstore 22
    //   1975: aload_1
    //   1976: getfield 252	com/tencent/mobileqq/util/FaceInfo:jdField_a_of_type_ArrayOfLong	[J
    //   1979: getstatic 255	com/tencent/mobileqq/util/FaceInfo:o	I
    //   1982: laload
    //   1983: lconst_0
    //   1984: lcmp
    //   1985: ifle -42 -> 1943
    //   1988: lload 24
    //   1990: lstore 22
    //   1992: aload_1
    //   1993: getfield 252	com/tencent/mobileqq/util/FaceInfo:jdField_a_of_type_ArrayOfLong	[J
    //   1996: getstatic 302	com/tencent/mobileqq/util/FaceInfo:l	I
    //   1999: laload
    //   2000: lconst_0
    //   2001: lcmp
    //   2002: ifle -59 -> 1943
    //   2005: aload_1
    //   2006: getfield 252	com/tencent/mobileqq/util/FaceInfo:jdField_a_of_type_ArrayOfLong	[J
    //   2009: getstatic 255	com/tencent/mobileqq/util/FaceInfo:o	I
    //   2012: laload
    //   2013: aload_1
    //   2014: getfield 252	com/tencent/mobileqq/util/FaceInfo:jdField_a_of_type_ArrayOfLong	[J
    //   2017: getstatic 302	com/tencent/mobileqq/util/FaceInfo:l	I
    //   2020: laload
    //   2021: lsub
    //   2022: lstore 22
    //   2024: goto -81 -> 1943
    //   2027: astore 26
    //   2029: lconst_0
    //   2030: lstore 24
    //   2032: aload_1
    //   2033: getfield 249	com/tencent/mobileqq/util/FaceInfo:e	I
    //   2036: iconst_1
    //   2037: if_icmpne +84 -> 2121
    //   2040: lload 24
    //   2042: lstore 22
    //   2044: aload_1
    //   2045: getfield 252	com/tencent/mobileqq/util/FaceInfo:jdField_a_of_type_ArrayOfLong	[J
    //   2048: getstatic 255	com/tencent/mobileqq/util/FaceInfo:o	I
    //   2051: laload
    //   2052: lconst_0
    //   2053: lcmp
    //   2054: ifle +39 -> 2093
    //   2057: lload 24
    //   2059: lstore 22
    //   2061: aload_1
    //   2062: getfield 252	com/tencent/mobileqq/util/FaceInfo:jdField_a_of_type_ArrayOfLong	[J
    //   2065: getstatic 75	com/tencent/mobileqq/util/FaceInfo:n	I
    //   2068: laload
    //   2069: lconst_0
    //   2070: lcmp
    //   2071: ifle +22 -> 2093
    //   2074: aload_1
    //   2075: getfield 252	com/tencent/mobileqq/util/FaceInfo:jdField_a_of_type_ArrayOfLong	[J
    //   2078: getstatic 255	com/tencent/mobileqq/util/FaceInfo:o	I
    //   2081: laload
    //   2082: aload_1
    //   2083: getfield 252	com/tencent/mobileqq/util/FaceInfo:jdField_a_of_type_ArrayOfLong	[J
    //   2086: getstatic 75	com/tencent/mobileqq/util/FaceInfo:n	I
    //   2089: laload
    //   2090: lsub
    //   2091: lstore 22
    //   2093: new 257	com/tencent/mobileqq/app/NearByFaceDownloader$HeadCostStatRunnable
    //   2096: dup
    //   2097: aload_0
    //   2098: iload 8
    //   2100: aload_1
    //   2101: iconst_4
    //   2102: iload 5
    //   2104: aload 27
    //   2106: iload 6
    //   2108: lload 22
    //   2110: invokespecial 260	com/tencent/mobileqq/app/NearByFaceDownloader$HeadCostStatRunnable:<init>	(Lcom/tencent/mobileqq/app/NearByFaceDownloader;ILcom/tencent/mobileqq/util/FaceInfo;IILjava/lang/String;IJ)V
    //   2113: aconst_null
    //   2114: iconst_0
    //   2115: invokestatic 242	com/tencent/mobileqq/app/ThreadManager:postImmediately	(Ljava/lang/Runnable;Lcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   2118: aload 26
    //   2120: athrow
    //   2121: lload 24
    //   2123: lstore 22
    //   2125: aload_1
    //   2126: getfield 252	com/tencent/mobileqq/util/FaceInfo:jdField_a_of_type_ArrayOfLong	[J
    //   2129: getstatic 255	com/tencent/mobileqq/util/FaceInfo:o	I
    //   2132: laload
    //   2133: lconst_0
    //   2134: lcmp
    //   2135: ifle -42 -> 2093
    //   2138: lload 24
    //   2140: lstore 22
    //   2142: aload_1
    //   2143: getfield 252	com/tencent/mobileqq/util/FaceInfo:jdField_a_of_type_ArrayOfLong	[J
    //   2146: getstatic 302	com/tencent/mobileqq/util/FaceInfo:l	I
    //   2149: laload
    //   2150: lconst_0
    //   2151: lcmp
    //   2152: ifle -59 -> 2093
    //   2155: aload_1
    //   2156: getfield 252	com/tencent/mobileqq/util/FaceInfo:jdField_a_of_type_ArrayOfLong	[J
    //   2159: getstatic 255	com/tencent/mobileqq/util/FaceInfo:o	I
    //   2162: laload
    //   2163: aload_1
    //   2164: getfield 252	com/tencent/mobileqq/util/FaceInfo:jdField_a_of_type_ArrayOfLong	[J
    //   2167: getstatic 302	com/tencent/mobileqq/util/FaceInfo:l	I
    //   2170: laload
    //   2171: lsub
    //   2172: lstore 22
    //   2174: goto -81 -> 2093
    //   2177: astore 26
    //   2179: aload 29
    //   2181: astore 27
    //   2183: iload 16
    //   2185: istore 8
    //   2187: iload 13
    //   2189: istore 5
    //   2191: iload 17
    //   2193: istore 6
    //   2195: goto -166 -> 2029
    //   2198: astore 26
    //   2200: aload 29
    //   2202: astore 27
    //   2204: iload 16
    //   2206: istore 8
    //   2208: iload 13
    //   2210: istore 5
    //   2212: iload_2
    //   2213: istore 6
    //   2215: goto -186 -> 2029
    //   2218: astore 26
    //   2220: iload 16
    //   2222: istore 8
    //   2224: iload 13
    //   2226: istore 5
    //   2228: aload 28
    //   2230: astore 27
    //   2232: iload_2
    //   2233: istore 6
    //   2235: goto -206 -> 2029
    //   2238: astore 29
    //   2240: iconst_0
    //   2241: istore_2
    //   2242: aload 26
    //   2244: astore 27
    //   2246: aload 28
    //   2248: astore 26
    //   2250: aload 27
    //   2252: astore 28
    //   2254: goto -400 -> 1854
    //   2257: astore 30
    //   2259: iconst_0
    //   2260: istore_2
    //   2261: aload 29
    //   2263: astore 27
    //   2265: iconst_0
    //   2266: istore 20
    //   2268: aload 26
    //   2270: astore 28
    //   2272: aload 30
    //   2274: astore 29
    //   2276: iload 4
    //   2278: istore 7
    //   2280: aload 27
    //   2282: astore 26
    //   2284: iload 15
    //   2286: istore_3
    //   2287: goto -433 -> 1854
    //   2290: astore 30
    //   2292: iconst_0
    //   2293: istore 5
    //   2295: aload 29
    //   2297: astore 27
    //   2299: iconst_0
    //   2300: istore 20
    //   2302: aload 26
    //   2304: astore 28
    //   2306: aload 30
    //   2308: astore 29
    //   2310: iload 4
    //   2312: istore 7
    //   2314: aload 27
    //   2316: astore 26
    //   2318: iload_2
    //   2319: istore_3
    //   2320: iload 5
    //   2322: istore_2
    //   2323: goto -469 -> 1854
    //   2326: astore 29
    //   2328: iconst_0
    //   2329: istore 5
    //   2331: iconst_0
    //   2332: istore 20
    //   2334: aload 26
    //   2336: astore 28
    //   2338: iload 4
    //   2340: istore 7
    //   2342: aload 27
    //   2344: astore 26
    //   2346: iload_2
    //   2347: istore_3
    //   2348: iload 5
    //   2350: istore_2
    //   2351: goto -497 -> 1854
    //   2354: astore 29
    //   2356: iload_3
    //   2357: istore 4
    //   2359: aload 26
    //   2361: astore 28
    //   2363: aload 30
    //   2365: astore 26
    //   2367: iload_2
    //   2368: istore_3
    //   2369: iload 4
    //   2371: istore_2
    //   2372: goto -518 -> 1854
    //   2375: aload 29
    //   2377: astore 30
    //   2379: goto -1337 -> 1042
    //   2382: goto -2094 -> 288
    //   2385: iconst_0
    //   2386: istore 5
    //   2388: iconst_0
    //   2389: istore 20
    //   2391: aconst_null
    //   2392: astore 26
    //   2394: iload_3
    //   2395: istore 4
    //   2397: iload 5
    //   2399: istore_3
    //   2400: goto -1201 -> 1199
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2403	0	this	NearByFaceDownloader
    //   0	2403	1	paramFaceInfo	com.tencent.mobileqq.util.FaceInfo
    //   96	2276	2	i	int
    //   73	2327	3	j	int
    //   51	2345	4	k	int
    //   103	2295	5	m	int
    //   111	2123	6	n	int
    //   48	2293	7	i1	int
    //   99	2124	8	i2	int
    //   63	1704	9	i3	int
    //   81	1056	10	i4	int
    //   75	1012	11	i5	int
    //   54	997	12	i6	int
    //   57	2168	13	i7	int
    //   60	1006	14	i8	int
    //   84	2201	15	i9	int
    //   78	2143	16	i10	int
    //   90	2102	17	i11	int
    //   87	717	18	i12	int
    //   93	727	19	i13	int
    //   536	1854	20	bool1	boolean
    //   45	1017	21	bool2	boolean
    //   1212	961	22	l1	long
    //   1200	939	24	l2	long
    //   208	1254	26	localObject1	java.lang.Object
    //   1498	1	26	localException	java.lang.Exception
    //   1844	112	26	localObject2	java.lang.Object
    //   2027	92	26	localObject3	java.lang.Object
    //   2177	1	26	localObject4	java.lang.Object
    //   2198	1	26	localObject5	java.lang.Object
    //   2218	25	26	localObject6	java.lang.Object
    //   2248	145	26	localObject7	java.lang.Object
    //   107	1074	27	localObject8	java.lang.Object
    //   1829	22	27	localThrowable1	java.lang.Throwable
    //   1869	474	27	localObject9	java.lang.Object
    //   177	2185	28	localObject10	java.lang.Object
    //   70	2131	29	localObject11	java.lang.Object
    //   2238	24	29	localThrowable2	java.lang.Throwable
    //   2274	35	29	localObject12	java.lang.Object
    //   2326	1	29	localThrowable3	java.lang.Throwable
    //   2354	22	29	localThrowable4	java.lang.Throwable
    //   569	627	30	localObject13	java.lang.Object
    //   2257	16	30	localThrowable5	java.lang.Throwable
    //   2290	74	30	localThrowable6	java.lang.Throwable
    //   2377	1	30	localThrowable7	java.lang.Throwable
    //   233	884	31	localSetting	com.tencent.mobileqq.data.Setting
    //   42	1445	32	localQQHeadInfo	AvatarInfo.QQHeadInfo
    //   692	384	33	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   510	518	1498	java/lang/Exception
    //   549	571	1498	java/lang/Exception
    //   607	615	1498	java/lang/Exception
    //   646	652	1498	java/lang/Exception
    //   683	694	1498	java/lang/Exception
    //   113	124	1829	java/lang/Throwable
    //   140	179	1829	java/lang/Throwable
    //   195	210	1829	java/lang/Throwable
    //   226	235	1829	java/lang/Throwable
    //   256	265	1829	java/lang/Throwable
    //   281	288	1829	java/lang/Throwable
    //   304	314	1829	java/lang/Throwable
    //   330	340	1829	java/lang/Throwable
    //   356	366	1829	java/lang/Throwable
    //   382	390	1829	java/lang/Throwable
    //   406	416	1829	java/lang/Throwable
    //   432	442	1829	java/lang/Throwable
    //   458	468	1829	java/lang/Throwable
    //   484	494	1829	java/lang/Throwable
    //   510	518	1829	java/lang/Throwable
    //   113	124	2027	finally
    //   140	179	2027	finally
    //   195	210	2027	finally
    //   226	235	2027	finally
    //   256	265	2027	finally
    //   281	288	2027	finally
    //   304	314	2027	finally
    //   330	340	2027	finally
    //   356	366	2027	finally
    //   382	390	2027	finally
    //   406	416	2027	finally
    //   432	442	2027	finally
    //   458	468	2027	finally
    //   484	494	2027	finally
    //   510	518	2027	finally
    //   549	571	2027	finally
    //   607	615	2027	finally
    //   646	652	2027	finally
    //   683	694	2027	finally
    //   725	751	2027	finally
    //   782	791	2027	finally
    //   822	850	2027	finally
    //   1007	1042	2027	finally
    //   1075	1083	2027	finally
    //   1111	1127	2027	finally
    //   1160	1170	2027	finally
    //   1185	1195	2027	finally
    //   1874	1879	2027	finally
    //   850	861	2177	finally
    //   865	900	2198	finally
    //   912	921	2218	finally
    //   929	957	2218	finally
    //   965	976	2218	finally
    //   549	571	2238	java/lang/Throwable
    //   607	615	2238	java/lang/Throwable
    //   646	652	2238	java/lang/Throwable
    //   683	694	2238	java/lang/Throwable
    //   725	751	2238	java/lang/Throwable
    //   782	791	2238	java/lang/Throwable
    //   822	850	2238	java/lang/Throwable
    //   1007	1042	2238	java/lang/Throwable
    //   1075	1083	2238	java/lang/Throwable
    //   1111	1127	2238	java/lang/Throwable
    //   850	861	2257	java/lang/Throwable
    //   865	900	2290	java/lang/Throwable
    //   912	921	2326	java/lang/Throwable
    //   929	957	2326	java/lang/Throwable
    //   965	976	2326	java/lang/Throwable
    //   1160	1170	2354	java/lang/Throwable
    //   1185	1195	2354	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.NearByFaceDownloader
 * JD-Core Version:    0.7.0.1
 */