package com.tencent.mobileqq.app;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.face.FaceConstant.Nearby;
import com.tencent.mobileqq.app.face.FaceDownloader;
import com.tencent.mobileqq.app.face.FaceHandler;
import com.tencent.mobileqq.avatar.api.IQQAvatarManagerService;
import mqq.app.AppRuntime;

public class NearByFaceDownloader
  extends FaceDownloader
{
  AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface = null;
  FaceHandler jdField_a_of_type_ComTencentMobileqqAppFaceFaceHandler = null;
  IQQAvatarManagerService jdField_a_of_type_ComTencentMobileqqAvatarApiIQQAvatarManagerService = null;
  
  public NearByFaceDownloader(AppRuntime paramAppRuntime)
  {
    super(paramAppRuntime);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = ((AppInterface)paramAppRuntime);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceHandler = ((FaceHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(FaceConstant.Nearby.NEAR_BY_FACE_HANDLER));
    this.jdField_a_of_type_ComTencentMobileqqAvatarApiIQQAvatarManagerService = ((IQQAvatarManagerService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IQQAvatarManagerService.class, "nearby"));
  }
  
  /* Error */
  public void doDownloadFace(com.tencent.mobileqq.app.face.FaceInfo paramFaceInfo)
  {
    // Byte code:
    //   0: invokestatic 53	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +28 -> 31
    //   6: ldc 55
    //   8: iconst_2
    //   9: new 57	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   16: ldc 62
    //   18: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: aload_1
    //   22: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   25: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: invokestatic 77	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   31: aload_1
    //   32: getstatic 83	com/tencent/mobileqq/app/face/FaceInfo:n	I
    //   35: invokevirtual 86	com/tencent/mobileqq/app/face/FaceInfo:a	(I)V
    //   38: aload_1
    //   39: getfield 89	com/tencent/mobileqq/app/face/FaceInfo:jdField_a_of_type_AvatarInfoQQHeadInfo	LAvatarInfo/QQHeadInfo;
    //   42: astore 29
    //   44: iconst_0
    //   45: istore 18
    //   47: iconst_0
    //   48: istore_3
    //   49: iconst_0
    //   50: istore 6
    //   52: iconst_0
    //   53: istore 12
    //   55: iconst_0
    //   56: istore 13
    //   58: iconst_0
    //   59: istore 9
    //   61: aload 29
    //   63: getfield 94	AvatarInfo/QQHeadInfo:downLoadUrl	Ljava/lang/String;
    //   66: astore 25
    //   68: iconst_0
    //   69: istore 16
    //   71: iconst_0
    //   72: istore 11
    //   74: iconst_0
    //   75: istore 10
    //   77: iconst_0
    //   78: istore 4
    //   80: iconst_0
    //   81: istore 14
    //   83: iconst_0
    //   84: istore 15
    //   86: iconst_0
    //   87: istore_2
    //   88: iload 11
    //   90: istore 8
    //   92: iload 12
    //   94: istore 7
    //   96: aload 25
    //   98: astore 23
    //   100: iload 14
    //   102: istore 5
    //   104: aload 29
    //   106: getfield 94	AvatarInfo/QQHeadInfo:downLoadUrl	Ljava/lang/String;
    //   109: invokestatic 100	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   112: ifne +2247 -> 2359
    //   115: iload 11
    //   117: istore 8
    //   119: iload 12
    //   121: istore 7
    //   123: aload 25
    //   125: astore 23
    //   127: iload 14
    //   129: istore 5
    //   131: new 57	java/lang/StringBuilder
    //   134: dup
    //   135: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   138: ldc 102
    //   140: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: aload_1
    //   144: getfield 105	com/tencent/mobileqq/app/face/FaceInfo:b	I
    //   147: invokestatic 110	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   150: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: ldc 112
    //   155: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: aload_1
    //   159: getfield 114	com/tencent/mobileqq/app/face/FaceInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   162: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   168: astore 26
    //   170: iload 11
    //   172: istore 8
    //   174: iload 12
    //   176: istore 7
    //   178: aload 25
    //   180: astore 23
    //   182: iload 14
    //   184: istore 5
    //   186: aload_0
    //   187: getfield 14	com/tencent/mobileqq/app/NearByFaceDownloader:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   190: ldc 34
    //   192: ldc 36
    //   194: invokevirtual 40	com/tencent/common/app/AppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   197: checkcast 34	com/tencent/mobileqq/avatar/api/IQQAvatarManagerService
    //   200: astore 27
    //   202: iload 11
    //   204: istore 8
    //   206: iload 12
    //   208: istore 7
    //   210: aload 25
    //   212: astore 23
    //   214: iload 14
    //   216: istore 5
    //   218: aload 27
    //   220: aload 26
    //   222: invokeinterface 118 2 0
    //   227: astore 24
    //   229: aload 24
    //   231: astore 28
    //   233: aload 24
    //   235: ifnonnull +51 -> 286
    //   238: iload 11
    //   240: istore 8
    //   242: iload 12
    //   244: istore 7
    //   246: aload 25
    //   248: astore 23
    //   250: iload 14
    //   252: istore 5
    //   254: new 120	com/tencent/mobileqq/data/Setting
    //   257: dup
    //   258: invokespecial 121	com/tencent/mobileqq/data/Setting:<init>	()V
    //   261: astore 28
    //   263: iload 11
    //   265: istore 8
    //   267: iload 12
    //   269: istore 7
    //   271: aload 25
    //   273: astore 23
    //   275: iload 14
    //   277: istore 5
    //   279: aload 28
    //   281: aload 26
    //   283: putfield 124	com/tencent/mobileqq/data/Setting:uin	Ljava/lang/String;
    //   286: iload 11
    //   288: istore 8
    //   290: iload 12
    //   292: istore 7
    //   294: aload 25
    //   296: astore 23
    //   298: iload 14
    //   300: istore 5
    //   302: aload 28
    //   304: aload 29
    //   306: getfield 128	AvatarInfo/QQHeadInfo:dwFaceFlgas	B
    //   309: putfield 131	com/tencent/mobileqq/data/Setting:bFaceFlags	B
    //   312: iload 11
    //   314: istore 8
    //   316: iload 12
    //   318: istore 7
    //   320: aload 25
    //   322: astore 23
    //   324: iload 14
    //   326: istore 5
    //   328: aload 28
    //   330: aload 29
    //   332: getfield 134	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   335: putfield 137	com/tencent/mobileqq/data/Setting:bUsrType	B
    //   338: iload 11
    //   340: istore 8
    //   342: iload 12
    //   344: istore 7
    //   346: aload 25
    //   348: astore 23
    //   350: iload 14
    //   352: istore 5
    //   354: aload 28
    //   356: aload 29
    //   358: getfield 94	AvatarInfo/QQHeadInfo:downLoadUrl	Ljava/lang/String;
    //   361: putfield 140	com/tencent/mobileqq/data/Setting:url	Ljava/lang/String;
    //   364: iload 11
    //   366: istore 8
    //   368: iload 12
    //   370: istore 7
    //   372: aload 25
    //   374: astore 23
    //   376: iload 14
    //   378: istore 5
    //   380: aload 28
    //   382: invokestatic 146	java/lang/System:currentTimeMillis	()J
    //   385: putfield 150	com/tencent/mobileqq/data/Setting:updateTimestamp	J
    //   388: iload 11
    //   390: istore 8
    //   392: iload 12
    //   394: istore 7
    //   396: aload 25
    //   398: astore 23
    //   400: iload 14
    //   402: istore 5
    //   404: aload 28
    //   406: aload 29
    //   408: getfield 153	AvatarInfo/QQHeadInfo:headLevel	B
    //   411: putfield 156	com/tencent/mobileqq/data/Setting:bSourceType	B
    //   414: iload 11
    //   416: istore 8
    //   418: iload 12
    //   420: istore 7
    //   422: aload 25
    //   424: astore 23
    //   426: iload 14
    //   428: istore 5
    //   430: aload 28
    //   432: aload 29
    //   434: getfield 159	AvatarInfo/QQHeadInfo:cHeadType	B
    //   437: putfield 162	com/tencent/mobileqq/data/Setting:bHeadType	B
    //   440: iload 11
    //   442: istore 8
    //   444: iload 12
    //   446: istore 7
    //   448: aload 25
    //   450: astore 23
    //   452: iload 14
    //   454: istore 5
    //   456: aload 28
    //   458: aload 29
    //   460: getfield 166	AvatarInfo/QQHeadInfo:systemHeadID	S
    //   463: putfield 167	com/tencent/mobileqq/data/Setting:systemHeadID	S
    //   466: iload 11
    //   468: istore 8
    //   470: iload 12
    //   472: istore 7
    //   474: aload 25
    //   476: astore 23
    //   478: iload 14
    //   480: istore 5
    //   482: aload 28
    //   484: aload 29
    //   486: getfield 170	AvatarInfo/QQHeadInfo:dwTimestamp	J
    //   489: putfield 173	com/tencent/mobileqq/data/Setting:headImgTimestamp	J
    //   492: iload 11
    //   494: istore 8
    //   496: iload 12
    //   498: istore 7
    //   500: aload 25
    //   502: astore 23
    //   504: iload 14
    //   506: istore 5
    //   508: aload 27
    //   510: aload_1
    //   511: invokeinterface 177 2 0
    //   516: astore 26
    //   518: iload 11
    //   520: istore 8
    //   522: iload 12
    //   524: istore 7
    //   526: aload 25
    //   528: astore 23
    //   530: iload 14
    //   532: istore 5
    //   534: iload 18
    //   536: istore 17
    //   538: iload 13
    //   540: istore 6
    //   542: aload 25
    //   544: astore 24
    //   546: iload 15
    //   548: istore_3
    //   549: new 179	java/io/File
    //   552: dup
    //   553: aload 26
    //   555: iconst_0
    //   556: aload 26
    //   558: ldc 181
    //   560: invokevirtual 187	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   563: invokevirtual 191	java/lang/String:substring	(II)Ljava/lang/String;
    //   566: invokespecial 194	java/io/File:<init>	(Ljava/lang/String;)V
    //   569: astore 27
    //   571: aload 27
    //   573: ifnull +79 -> 652
    //   576: iload 11
    //   578: istore 8
    //   580: iload 12
    //   582: istore 7
    //   584: aload 25
    //   586: astore 23
    //   588: iload 14
    //   590: istore 5
    //   592: iload 18
    //   594: istore 17
    //   596: iload 13
    //   598: istore 6
    //   600: aload 25
    //   602: astore 24
    //   604: iload 15
    //   606: istore_3
    //   607: aload 27
    //   609: invokevirtual 197	java/io/File:exists	()Z
    //   612: ifne +40 -> 652
    //   615: iload 11
    //   617: istore 8
    //   619: iload 12
    //   621: istore 7
    //   623: aload 25
    //   625: astore 23
    //   627: iload 14
    //   629: istore 5
    //   631: iload 18
    //   633: istore 17
    //   635: iload 13
    //   637: istore 6
    //   639: aload 25
    //   641: astore 24
    //   643: iload 15
    //   645: istore_3
    //   646: aload 27
    //   648: invokevirtual 200	java/io/File:mkdirs	()Z
    //   651: pop
    //   652: iload 11
    //   654: istore 8
    //   656: iload 12
    //   658: istore 7
    //   660: aload 25
    //   662: astore 23
    //   664: iload 14
    //   666: istore 5
    //   668: iload 18
    //   670: istore 17
    //   672: iload 13
    //   674: istore 6
    //   676: aload 25
    //   678: astore 24
    //   680: iload 15
    //   682: istore_3
    //   683: new 179	java/io/File
    //   686: dup
    //   687: aload 26
    //   689: invokespecial 194	java/io/File:<init>	(Ljava/lang/String;)V
    //   692: astore 30
    //   694: iload 11
    //   696: istore 8
    //   698: iload 12
    //   700: istore 7
    //   702: aload 25
    //   704: astore 23
    //   706: iload 14
    //   708: istore 5
    //   710: iload 18
    //   712: istore 17
    //   714: iload 13
    //   716: istore 6
    //   718: aload 25
    //   720: astore 24
    //   722: iload 15
    //   724: istore_3
    //   725: aload 29
    //   727: getfield 94	AvatarInfo/QQHeadInfo:downLoadUrl	Ljava/lang/String;
    //   730: aload 29
    //   732: getfield 128	AvatarInfo/QQHeadInfo:dwFaceFlgas	B
    //   735: aload 29
    //   737: getfield 134	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   740: aload 29
    //   742: getfield 203	AvatarInfo/QQHeadInfo:originUsrType	I
    //   745: invokestatic 209	com/tencent/mobileqq/app/face/util/AvatarDownloadUtil:getQQAvatarDownLoadUrl	(Ljava/lang/String;BBI)Ljava/lang/String;
    //   748: astore 25
    //   750: iload 11
    //   752: istore 8
    //   754: iload 12
    //   756: istore 7
    //   758: aload 25
    //   760: astore 23
    //   762: iload 14
    //   764: istore 5
    //   766: iload 18
    //   768: istore 17
    //   770: iload 13
    //   772: istore 6
    //   774: aload 25
    //   776: astore 24
    //   778: iload 15
    //   780: istore_3
    //   781: ldc 211
    //   783: aload 25
    //   785: invokestatic 217	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:insertMtype	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   788: astore 25
    //   790: iload 11
    //   792: istore 8
    //   794: iload 12
    //   796: istore 7
    //   798: aload 25
    //   800: astore 23
    //   802: iload 14
    //   804: istore 5
    //   806: iload 18
    //   808: istore 17
    //   810: iload 13
    //   812: istore 6
    //   814: aload 25
    //   816: astore 24
    //   818: iload 15
    //   820: istore_3
    //   821: new 57	java/lang/StringBuilder
    //   824: dup
    //   825: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   828: aload 25
    //   830: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   833: ldc 219
    //   835: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   838: invokestatic 146	java/lang/System:currentTimeMillis	()J
    //   841: invokevirtual 222	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   844: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   847: astore 27
    //   849: iload 11
    //   851: istore 8
    //   853: iload 12
    //   855: istore 7
    //   857: aload 27
    //   859: astore 23
    //   861: iload 14
    //   863: istore 5
    //   865: iload 18
    //   867: istore 17
    //   869: iload 13
    //   871: istore 6
    //   873: aload 27
    //   875: astore 24
    //   877: iload 15
    //   879: istore_3
    //   880: aload_0
    //   881: aload 27
    //   883: aload 30
    //   885: aload_1
    //   886: iconst_1
    //   887: invokevirtual 226	com/tencent/mobileqq/app/NearByFaceDownloader:downloadData	(Ljava/lang/String;Ljava/io/File;Lcom/tencent/mobileqq/app/face/FaceInfo;Z)I
    //   890: istore 4
    //   892: aload 27
    //   894: astore 25
    //   896: iload 4
    //   898: istore_2
    //   899: iload 4
    //   901: ifeq +311 -> 1212
    //   904: aload 27
    //   906: astore 25
    //   908: iload 4
    //   910: istore_2
    //   911: iload 11
    //   913: istore 8
    //   915: iload 12
    //   917: istore 7
    //   919: aload 27
    //   921: astore 23
    //   923: iload 4
    //   925: istore 5
    //   927: iload 18
    //   929: istore 17
    //   931: iload 13
    //   933: istore 6
    //   935: aload 27
    //   937: astore 24
    //   939: iload 4
    //   941: istore_3
    //   942: iconst_1
    //   943: invokestatic 232	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getActiveNetIpFamily	(Z)I
    //   946: iconst_3
    //   947: if_icmpne +265 -> 1212
    //   950: iload 11
    //   952: istore 8
    //   954: iload 12
    //   956: istore 7
    //   958: aload 27
    //   960: astore 23
    //   962: iload 4
    //   964: istore 5
    //   966: iload 18
    //   968: istore 17
    //   970: iload 13
    //   972: istore 6
    //   974: aload 27
    //   976: astore 24
    //   978: iload 4
    //   980: istore_3
    //   981: aload 29
    //   983: getfield 94	AvatarInfo/QQHeadInfo:downLoadUrl	Ljava/lang/String;
    //   986: aload 29
    //   988: getfield 128	AvatarInfo/QQHeadInfo:dwFaceFlgas	B
    //   991: aload 29
    //   993: getfield 134	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   996: aload 29
    //   998: getfield 203	AvatarInfo/QQHeadInfo:originUsrType	I
    //   1001: iconst_1
    //   1002: invokestatic 235	com/tencent/mobileqq/app/face/util/AvatarDownloadUtil:getQQAvatarDownLoadUrl	(Ljava/lang/String;BBIZ)Ljava/lang/String;
    //   1005: astore 25
    //   1007: iload 11
    //   1009: istore 8
    //   1011: iload 12
    //   1013: istore 7
    //   1015: aload 25
    //   1017: astore 23
    //   1019: iload 4
    //   1021: istore 5
    //   1023: iload 18
    //   1025: istore 17
    //   1027: iload 13
    //   1029: istore 6
    //   1031: aload 25
    //   1033: astore 24
    //   1035: iload 4
    //   1037: istore_3
    //   1038: ldc 211
    //   1040: aload 25
    //   1042: invokestatic 217	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:insertMtype	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1045: astore 25
    //   1047: iload 11
    //   1049: istore 8
    //   1051: iload 12
    //   1053: istore 7
    //   1055: aload 25
    //   1057: astore 23
    //   1059: iload 4
    //   1061: istore 5
    //   1063: iload 18
    //   1065: istore 17
    //   1067: iload 13
    //   1069: istore 6
    //   1071: aload 25
    //   1073: astore 24
    //   1075: iload 4
    //   1077: istore_3
    //   1078: new 57	java/lang/StringBuilder
    //   1081: dup
    //   1082: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   1085: aload 25
    //   1087: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1090: ldc 219
    //   1092: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1095: invokestatic 146	java/lang/System:currentTimeMillis	()J
    //   1098: invokevirtual 222	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1101: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1104: astore 25
    //   1106: iload 11
    //   1108: istore 8
    //   1110: iload 12
    //   1112: istore 7
    //   1114: aload 25
    //   1116: astore 23
    //   1118: iload 4
    //   1120: istore 5
    //   1122: iload 18
    //   1124: istore 17
    //   1126: iload 13
    //   1128: istore 6
    //   1130: aload 25
    //   1132: astore 24
    //   1134: iload 4
    //   1136: istore_3
    //   1137: aload_0
    //   1138: aload 25
    //   1140: aload 30
    //   1142: aload_1
    //   1143: iconst_1
    //   1144: invokevirtual 226	com/tencent/mobileqq/app/NearByFaceDownloader:downloadData	(Ljava/lang/String;Ljava/io/File;Lcom/tencent/mobileqq/app/face/FaceInfo;Z)I
    //   1147: istore_2
    //   1148: iload 11
    //   1150: istore 8
    //   1152: iload 12
    //   1154: istore 7
    //   1156: aload 25
    //   1158: astore 23
    //   1160: iload_2
    //   1161: istore 5
    //   1163: iload 18
    //   1165: istore 17
    //   1167: iload 13
    //   1169: istore 6
    //   1171: aload 25
    //   1173: astore 24
    //   1175: iload_2
    //   1176: istore_3
    //   1177: ldc 55
    //   1179: iconst_1
    //   1180: new 57	java/lang/StringBuilder
    //   1183: dup
    //   1184: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   1187: ldc 237
    //   1189: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1192: aload 25
    //   1194: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1197: ldc 239
    //   1199: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1202: iload_2
    //   1203: invokevirtual 242	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1206: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1209: invokestatic 77	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1212: iload_2
    //   1213: ifne +596 -> 1809
    //   1216: iload 11
    //   1218: istore 8
    //   1220: iload 12
    //   1222: istore 7
    //   1224: aload 25
    //   1226: astore 23
    //   1228: iload_2
    //   1229: istore 5
    //   1231: iload 18
    //   1233: istore 17
    //   1235: iload 13
    //   1237: istore 6
    //   1239: aload 25
    //   1241: astore 24
    //   1243: iload_2
    //   1244: istore_3
    //   1245: aload 30
    //   1247: invokevirtual 245	java/io/File:length	()J
    //   1250: l2i
    //   1251: istore 4
    //   1253: iconst_1
    //   1254: istore 17
    //   1256: iload 11
    //   1258: istore 8
    //   1260: iload 4
    //   1262: istore 7
    //   1264: aload 25
    //   1266: astore 23
    //   1268: iload_2
    //   1269: istore 5
    //   1271: iload 4
    //   1273: istore 6
    //   1275: aload 25
    //   1277: astore 24
    //   1279: iload_2
    //   1280: istore_3
    //   1281: new 247	com/tencent/mobileqq/app/NearByFaceDownloader$UpdateSettingRunnable
    //   1284: dup
    //   1285: aload_0
    //   1286: aload 28
    //   1288: aload_1
    //   1289: invokespecial 250	com/tencent/mobileqq/app/NearByFaceDownloader$UpdateSettingRunnable:<init>	(Lcom/tencent/mobileqq/app/NearByFaceDownloader;Lcom/tencent/mobileqq/data/Setting;Lcom/tencent/mobileqq/app/face/FaceInfo;)V
    //   1292: aconst_null
    //   1293: iconst_0
    //   1294: invokestatic 256	com/tencent/mobileqq/app/ThreadManager:postImmediately	(Ljava/lang/Runnable;Lcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   1297: iconst_0
    //   1298: istore_3
    //   1299: iconst_1
    //   1300: istore 17
    //   1302: iload 4
    //   1304: istore 6
    //   1306: iload 10
    //   1308: istore 4
    //   1310: iload 17
    //   1312: ifeq +28 -> 1340
    //   1315: iload 4
    //   1317: istore 8
    //   1319: iload 6
    //   1321: istore 7
    //   1323: aload 25
    //   1325: astore 23
    //   1327: iload_2
    //   1328: istore 5
    //   1330: aload_0
    //   1331: getfield 16	com/tencent/mobileqq/app/NearByFaceDownloader:jdField_a_of_type_ComTencentMobileqqAppFaceFaceHandler	Lcom/tencent/mobileqq/app/face/FaceHandler;
    //   1334: iconst_0
    //   1335: iconst_1
    //   1336: aload_1
    //   1337: invokevirtual 260	com/tencent/mobileqq/app/face/FaceHandler:notifyUI	(IZLjava/lang/Object;)V
    //   1340: iload 4
    //   1342: istore 8
    //   1344: iload 6
    //   1346: istore 7
    //   1348: aload 25
    //   1350: astore 23
    //   1352: iload_2
    //   1353: istore 5
    //   1355: aload_0
    //   1356: getfield 16	com/tencent/mobileqq/app/NearByFaceDownloader:jdField_a_of_type_ComTencentMobileqqAppFaceFaceHandler	Lcom/tencent/mobileqq/app/face/FaceHandler;
    //   1359: iconst_1
    //   1360: iconst_1
    //   1361: aload_1
    //   1362: invokevirtual 260	com/tencent/mobileqq/app/face/FaceHandler:notifyUI	(IZLjava/lang/Object;)V
    //   1365: aload 26
    //   1367: astore 23
    //   1369: lconst_0
    //   1370: lstore 21
    //   1372: aload_1
    //   1373: getfield 263	com/tencent/mobileqq/app/face/FaceInfo:e	I
    //   1376: iconst_1
    //   1377: if_icmpne +560 -> 1937
    //   1380: lload 21
    //   1382: lstore 19
    //   1384: aload_1
    //   1385: getfield 266	com/tencent/mobileqq/app/face/FaceInfo:jdField_a_of_type_ArrayOfLong	[J
    //   1388: getstatic 269	com/tencent/mobileqq/app/face/FaceInfo:o	I
    //   1391: laload
    //   1392: lconst_0
    //   1393: lcmp
    //   1394: ifle +39 -> 1433
    //   1397: lload 21
    //   1399: lstore 19
    //   1401: aload_1
    //   1402: getfield 266	com/tencent/mobileqq/app/face/FaceInfo:jdField_a_of_type_ArrayOfLong	[J
    //   1405: getstatic 83	com/tencent/mobileqq/app/face/FaceInfo:n	I
    //   1408: laload
    //   1409: lconst_0
    //   1410: lcmp
    //   1411: ifle +22 -> 1433
    //   1414: aload_1
    //   1415: getfield 266	com/tencent/mobileqq/app/face/FaceInfo:jdField_a_of_type_ArrayOfLong	[J
    //   1418: getstatic 269	com/tencent/mobileqq/app/face/FaceInfo:o	I
    //   1421: laload
    //   1422: aload_1
    //   1423: getfield 266	com/tencent/mobileqq/app/face/FaceInfo:jdField_a_of_type_ArrayOfLong	[J
    //   1426: getstatic 83	com/tencent/mobileqq/app/face/FaceInfo:n	I
    //   1429: laload
    //   1430: lsub
    //   1431: lstore 19
    //   1433: new 271	com/tencent/mobileqq/app/NearByFaceDownloader$HeadCostStatRunnable
    //   1436: dup
    //   1437: aload_0
    //   1438: iload 4
    //   1440: aload_1
    //   1441: iconst_4
    //   1442: iload 6
    //   1444: aload 25
    //   1446: iload_2
    //   1447: lload 19
    //   1449: invokespecial 274	com/tencent/mobileqq/app/NearByFaceDownloader$HeadCostStatRunnable:<init>	(Lcom/tencent/mobileqq/app/NearByFaceDownloader;ILcom/tencent/mobileqq/app/face/FaceInfo;IILjava/lang/String;IJ)V
    //   1452: aconst_null
    //   1453: iconst_0
    //   1454: invokestatic 256	com/tencent/mobileqq/app/ThreadManager:postImmediately	(Ljava/lang/Runnable;Lcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   1457: aload 25
    //   1459: astore 24
    //   1461: invokestatic 53	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1464: ifne +8 -> 1472
    //   1467: iload 17
    //   1469: ifne +192 -> 1661
    //   1472: ldc 55
    //   1474: iconst_2
    //   1475: new 57	java/lang/StringBuilder
    //   1478: dup
    //   1479: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   1482: ldc_w 276
    //   1485: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1488: aload_1
    //   1489: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1492: ldc_w 278
    //   1495: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1498: iload 17
    //   1500: invokevirtual 281	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1503: ldc_w 283
    //   1506: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1509: iload 4
    //   1511: invokevirtual 242	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1514: ldc_w 285
    //   1517: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1520: aload 29
    //   1522: getfield 287	AvatarInfo/QQHeadInfo:uin	J
    //   1525: invokevirtual 222	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1528: ldc_w 289
    //   1531: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1534: aload 29
    //   1536: getfield 292	AvatarInfo/QQHeadInfo:phoneNum	Ljava/lang/String;
    //   1539: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1542: ldc_w 294
    //   1545: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1548: aload 29
    //   1550: getfield 159	AvatarInfo/QQHeadInfo:cHeadType	B
    //   1553: invokevirtual 242	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1556: ldc_w 296
    //   1559: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1562: aload 29
    //   1564: getfield 134	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   1567: invokevirtual 242	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1570: ldc_w 298
    //   1573: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1576: aload 29
    //   1578: getfield 166	AvatarInfo/QQHeadInfo:systemHeadID	S
    //   1581: invokevirtual 242	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1584: ldc_w 300
    //   1587: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1590: iload_3
    //   1591: invokevirtual 242	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1594: ldc_w 302
    //   1597: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1600: aload 29
    //   1602: getfield 170	AvatarInfo/QQHeadInfo:dwTimestamp	J
    //   1605: invokevirtual 222	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1608: ldc_w 304
    //   1611: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1614: aload 23
    //   1616: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1619: ldc_w 306
    //   1622: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1625: aload 24
    //   1627: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1630: ldc_w 308
    //   1633: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1636: aload 29
    //   1638: getfield 94	AvatarInfo/QQHeadInfo:downLoadUrl	Ljava/lang/String;
    //   1641: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1644: ldc_w 310
    //   1647: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1650: aload 29
    //   1652: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1655: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1658: invokestatic 313	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1661: return
    //   1662: astore 23
    //   1664: lconst_0
    //   1665: lstore 21
    //   1667: aload_1
    //   1668: getfield 263	com/tencent/mobileqq/app/face/FaceInfo:e	I
    //   1671: iconst_1
    //   1672: if_icmpne +81 -> 1753
    //   1675: lload 21
    //   1677: lstore 19
    //   1679: aload_1
    //   1680: getfield 266	com/tencent/mobileqq/app/face/FaceInfo:jdField_a_of_type_ArrayOfLong	[J
    //   1683: getstatic 269	com/tencent/mobileqq/app/face/FaceInfo:o	I
    //   1686: laload
    //   1687: lconst_0
    //   1688: lcmp
    //   1689: ifle +39 -> 1728
    //   1692: lload 21
    //   1694: lstore 19
    //   1696: aload_1
    //   1697: getfield 266	com/tencent/mobileqq/app/face/FaceInfo:jdField_a_of_type_ArrayOfLong	[J
    //   1700: getstatic 83	com/tencent/mobileqq/app/face/FaceInfo:n	I
    //   1703: laload
    //   1704: lconst_0
    //   1705: lcmp
    //   1706: ifle +22 -> 1728
    //   1709: aload_1
    //   1710: getfield 266	com/tencent/mobileqq/app/face/FaceInfo:jdField_a_of_type_ArrayOfLong	[J
    //   1713: getstatic 269	com/tencent/mobileqq/app/face/FaceInfo:o	I
    //   1716: laload
    //   1717: aload_1
    //   1718: getfield 266	com/tencent/mobileqq/app/face/FaceInfo:jdField_a_of_type_ArrayOfLong	[J
    //   1721: getstatic 83	com/tencent/mobileqq/app/face/FaceInfo:n	I
    //   1724: laload
    //   1725: lsub
    //   1726: lstore 19
    //   1728: new 271	com/tencent/mobileqq/app/NearByFaceDownloader$HeadCostStatRunnable
    //   1731: dup
    //   1732: aload_0
    //   1733: sipush 9202
    //   1736: aload_1
    //   1737: iconst_4
    //   1738: iconst_0
    //   1739: aload 25
    //   1741: iconst_0
    //   1742: lload 19
    //   1744: invokespecial 274	com/tencent/mobileqq/app/NearByFaceDownloader$HeadCostStatRunnable:<init>	(Lcom/tencent/mobileqq/app/NearByFaceDownloader;ILcom/tencent/mobileqq/app/face/FaceInfo;IILjava/lang/String;IJ)V
    //   1747: aconst_null
    //   1748: iconst_0
    //   1749: invokestatic 256	com/tencent/mobileqq/app/ThreadManager:postImmediately	(Ljava/lang/Runnable;Lcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   1752: return
    //   1753: lload 21
    //   1755: lstore 19
    //   1757: aload_1
    //   1758: getfield 266	com/tencent/mobileqq/app/face/FaceInfo:jdField_a_of_type_ArrayOfLong	[J
    //   1761: getstatic 269	com/tencent/mobileqq/app/face/FaceInfo:o	I
    //   1764: laload
    //   1765: lconst_0
    //   1766: lcmp
    //   1767: ifle -39 -> 1728
    //   1770: lload 21
    //   1772: lstore 19
    //   1774: aload_1
    //   1775: getfield 266	com/tencent/mobileqq/app/face/FaceInfo:jdField_a_of_type_ArrayOfLong	[J
    //   1778: getstatic 316	com/tencent/mobileqq/app/face/FaceInfo:l	I
    //   1781: laload
    //   1782: lconst_0
    //   1783: lcmp
    //   1784: ifle -56 -> 1728
    //   1787: aload_1
    //   1788: getfield 266	com/tencent/mobileqq/app/face/FaceInfo:jdField_a_of_type_ArrayOfLong	[J
    //   1791: getstatic 269	com/tencent/mobileqq/app/face/FaceInfo:o	I
    //   1794: laload
    //   1795: aload_1
    //   1796: getfield 266	com/tencent/mobileqq/app/face/FaceInfo:jdField_a_of_type_ArrayOfLong	[J
    //   1799: getstatic 316	com/tencent/mobileqq/app/face/FaceInfo:l	I
    //   1802: laload
    //   1803: lsub
    //   1804: lstore 19
    //   1806: goto -78 -> 1728
    //   1809: iload_2
    //   1810: lookupswitch	default:+42->1852, 1:+59->1869, 4:+76->1886, 5:+110->1920, 33:+93->1903
    //   1853: fload_1
    //   1854: <illegal opcode>
    //   1855: istore 4
    //   1857: iload_2
    //   1858: istore_3
    //   1859: iconst_0
    //   1860: istore 17
    //   1862: iload 9
    //   1864: istore 6
    //   1866: goto -556 -> 1310
    //   1869: sipush 9206
    //   1872: istore 4
    //   1874: iconst_0
    //   1875: istore_3
    //   1876: iconst_0
    //   1877: istore 17
    //   1879: iload 9
    //   1881: istore 6
    //   1883: goto -573 -> 1310
    //   1886: sipush 9202
    //   1889: istore 4
    //   1891: iconst_0
    //   1892: istore_3
    //   1893: iconst_0
    //   1894: istore 17
    //   1896: iload 9
    //   1898: istore 6
    //   1900: goto -590 -> 1310
    //   1903: sipush 9208
    //   1906: istore 4
    //   1908: iload_2
    //   1909: istore_3
    //   1910: iconst_0
    //   1911: istore 17
    //   1913: iload 9
    //   1915: istore 6
    //   1917: goto -607 -> 1310
    //   1920: sipush 9204
    //   1923: istore 4
    //   1925: iconst_0
    //   1926: istore_3
    //   1927: iconst_0
    //   1928: istore 17
    //   1930: iload 9
    //   1932: istore 6
    //   1934: goto -624 -> 1310
    //   1937: lload 21
    //   1939: lstore 19
    //   1941: aload_1
    //   1942: getfield 266	com/tencent/mobileqq/app/face/FaceInfo:jdField_a_of_type_ArrayOfLong	[J
    //   1945: getstatic 269	com/tencent/mobileqq/app/face/FaceInfo:o	I
    //   1948: laload
    //   1949: lconst_0
    //   1950: lcmp
    //   1951: ifle -518 -> 1433
    //   1954: lload 21
    //   1956: lstore 19
    //   1958: aload_1
    //   1959: getfield 266	com/tencent/mobileqq/app/face/FaceInfo:jdField_a_of_type_ArrayOfLong	[J
    //   1962: getstatic 316	com/tencent/mobileqq/app/face/FaceInfo:l	I
    //   1965: laload
    //   1966: lconst_0
    //   1967: lcmp
    //   1968: ifle -535 -> 1433
    //   1971: aload_1
    //   1972: getfield 266	com/tencent/mobileqq/app/face/FaceInfo:jdField_a_of_type_ArrayOfLong	[J
    //   1975: getstatic 269	com/tencent/mobileqq/app/face/FaceInfo:o	I
    //   1978: laload
    //   1979: aload_1
    //   1980: getfield 266	com/tencent/mobileqq/app/face/FaceInfo:jdField_a_of_type_ArrayOfLong	[J
    //   1983: getstatic 316	com/tencent/mobileqq/app/face/FaceInfo:l	I
    //   1986: laload
    //   1987: lsub
    //   1988: lstore 19
    //   1990: goto -557 -> 1433
    //   1993: astore 27
    //   1995: iconst_0
    //   1996: istore_3
    //   1997: iconst_0
    //   1998: istore 17
    //   2000: aconst_null
    //   2001: astore 26
    //   2003: iload 4
    //   2005: istore_2
    //   2006: aload 25
    //   2008: astore 24
    //   2010: sipush 9204
    //   2013: istore 4
    //   2015: iload 4
    //   2017: istore 8
    //   2019: iload 6
    //   2021: istore 7
    //   2023: aload 24
    //   2025: astore 23
    //   2027: iload_2
    //   2028: istore 5
    //   2030: aload 27
    //   2032: invokevirtual 319	java/lang/Throwable:printStackTrace	()V
    //   2035: lconst_0
    //   2036: lstore 21
    //   2038: aload_1
    //   2039: getfield 263	com/tencent/mobileqq/app/face/FaceInfo:e	I
    //   2042: iconst_1
    //   2043: if_icmpne +88 -> 2131
    //   2046: lload 21
    //   2048: lstore 19
    //   2050: aload_1
    //   2051: getfield 266	com/tencent/mobileqq/app/face/FaceInfo:jdField_a_of_type_ArrayOfLong	[J
    //   2054: getstatic 269	com/tencent/mobileqq/app/face/FaceInfo:o	I
    //   2057: laload
    //   2058: lconst_0
    //   2059: lcmp
    //   2060: ifle +39 -> 2099
    //   2063: lload 21
    //   2065: lstore 19
    //   2067: aload_1
    //   2068: getfield 266	com/tencent/mobileqq/app/face/FaceInfo:jdField_a_of_type_ArrayOfLong	[J
    //   2071: getstatic 83	com/tencent/mobileqq/app/face/FaceInfo:n	I
    //   2074: laload
    //   2075: lconst_0
    //   2076: lcmp
    //   2077: ifle +22 -> 2099
    //   2080: aload_1
    //   2081: getfield 266	com/tencent/mobileqq/app/face/FaceInfo:jdField_a_of_type_ArrayOfLong	[J
    //   2084: getstatic 269	com/tencent/mobileqq/app/face/FaceInfo:o	I
    //   2087: laload
    //   2088: aload_1
    //   2089: getfield 266	com/tencent/mobileqq/app/face/FaceInfo:jdField_a_of_type_ArrayOfLong	[J
    //   2092: getstatic 83	com/tencent/mobileqq/app/face/FaceInfo:n	I
    //   2095: laload
    //   2096: lsub
    //   2097: lstore 19
    //   2099: new 271	com/tencent/mobileqq/app/NearByFaceDownloader$HeadCostStatRunnable
    //   2102: dup
    //   2103: aload_0
    //   2104: sipush 9204
    //   2107: aload_1
    //   2108: iconst_4
    //   2109: iload 6
    //   2111: aload 24
    //   2113: iload_2
    //   2114: lload 19
    //   2116: invokespecial 274	com/tencent/mobileqq/app/NearByFaceDownloader$HeadCostStatRunnable:<init>	(Lcom/tencent/mobileqq/app/NearByFaceDownloader;ILcom/tencent/mobileqq/app/face/FaceInfo;IILjava/lang/String;IJ)V
    //   2119: aconst_null
    //   2120: iconst_0
    //   2121: invokestatic 256	com/tencent/mobileqq/app/ThreadManager:postImmediately	(Ljava/lang/Runnable;Lcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   2124: aload 26
    //   2126: astore 23
    //   2128: goto -667 -> 1461
    //   2131: lload 21
    //   2133: lstore 19
    //   2135: aload_1
    //   2136: getfield 266	com/tencent/mobileqq/app/face/FaceInfo:jdField_a_of_type_ArrayOfLong	[J
    //   2139: getstatic 269	com/tencent/mobileqq/app/face/FaceInfo:o	I
    //   2142: laload
    //   2143: lconst_0
    //   2144: lcmp
    //   2145: ifle -46 -> 2099
    //   2148: lload 21
    //   2150: lstore 19
    //   2152: aload_1
    //   2153: getfield 266	com/tencent/mobileqq/app/face/FaceInfo:jdField_a_of_type_ArrayOfLong	[J
    //   2156: getstatic 316	com/tencent/mobileqq/app/face/FaceInfo:l	I
    //   2159: laload
    //   2160: lconst_0
    //   2161: lcmp
    //   2162: ifle -63 -> 2099
    //   2165: aload_1
    //   2166: getfield 266	com/tencent/mobileqq/app/face/FaceInfo:jdField_a_of_type_ArrayOfLong	[J
    //   2169: getstatic 269	com/tencent/mobileqq/app/face/FaceInfo:o	I
    //   2172: laload
    //   2173: aload_1
    //   2174: getfield 266	com/tencent/mobileqq/app/face/FaceInfo:jdField_a_of_type_ArrayOfLong	[J
    //   2177: getstatic 316	com/tencent/mobileqq/app/face/FaceInfo:l	I
    //   2180: laload
    //   2181: lsub
    //   2182: lstore 19
    //   2184: goto -85 -> 2099
    //   2187: astore 24
    //   2189: lconst_0
    //   2190: lstore 21
    //   2192: aload_1
    //   2193: getfield 263	com/tencent/mobileqq/app/face/FaceInfo:e	I
    //   2196: iconst_1
    //   2197: if_icmpne +84 -> 2281
    //   2200: lload 21
    //   2202: lstore 19
    //   2204: aload_1
    //   2205: getfield 266	com/tencent/mobileqq/app/face/FaceInfo:jdField_a_of_type_ArrayOfLong	[J
    //   2208: getstatic 269	com/tencent/mobileqq/app/face/FaceInfo:o	I
    //   2211: laload
    //   2212: lconst_0
    //   2213: lcmp
    //   2214: ifle +39 -> 2253
    //   2217: lload 21
    //   2219: lstore 19
    //   2221: aload_1
    //   2222: getfield 266	com/tencent/mobileqq/app/face/FaceInfo:jdField_a_of_type_ArrayOfLong	[J
    //   2225: getstatic 83	com/tencent/mobileqq/app/face/FaceInfo:n	I
    //   2228: laload
    //   2229: lconst_0
    //   2230: lcmp
    //   2231: ifle +22 -> 2253
    //   2234: aload_1
    //   2235: getfield 266	com/tencent/mobileqq/app/face/FaceInfo:jdField_a_of_type_ArrayOfLong	[J
    //   2238: getstatic 269	com/tencent/mobileqq/app/face/FaceInfo:o	I
    //   2241: laload
    //   2242: aload_1
    //   2243: getfield 266	com/tencent/mobileqq/app/face/FaceInfo:jdField_a_of_type_ArrayOfLong	[J
    //   2246: getstatic 83	com/tencent/mobileqq/app/face/FaceInfo:n	I
    //   2249: laload
    //   2250: lsub
    //   2251: lstore 19
    //   2253: new 271	com/tencent/mobileqq/app/NearByFaceDownloader$HeadCostStatRunnable
    //   2256: dup
    //   2257: aload_0
    //   2258: iload 8
    //   2260: aload_1
    //   2261: iconst_4
    //   2262: iload 7
    //   2264: aload 23
    //   2266: iload 5
    //   2268: lload 19
    //   2270: invokespecial 274	com/tencent/mobileqq/app/NearByFaceDownloader$HeadCostStatRunnable:<init>	(Lcom/tencent/mobileqq/app/NearByFaceDownloader;ILcom/tencent/mobileqq/app/face/FaceInfo;IILjava/lang/String;IJ)V
    //   2273: aconst_null
    //   2274: iconst_0
    //   2275: invokestatic 256	com/tencent/mobileqq/app/ThreadManager:postImmediately	(Ljava/lang/Runnable;Lcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   2278: aload 24
    //   2280: athrow
    //   2281: lload 21
    //   2283: lstore 19
    //   2285: aload_1
    //   2286: getfield 266	com/tencent/mobileqq/app/face/FaceInfo:jdField_a_of_type_ArrayOfLong	[J
    //   2289: getstatic 269	com/tencent/mobileqq/app/face/FaceInfo:o	I
    //   2292: laload
    //   2293: lconst_0
    //   2294: lcmp
    //   2295: ifle -42 -> 2253
    //   2298: lload 21
    //   2300: lstore 19
    //   2302: aload_1
    //   2303: getfield 266	com/tencent/mobileqq/app/face/FaceInfo:jdField_a_of_type_ArrayOfLong	[J
    //   2306: getstatic 316	com/tencent/mobileqq/app/face/FaceInfo:l	I
    //   2309: laload
    //   2310: lconst_0
    //   2311: lcmp
    //   2312: ifle -59 -> 2253
    //   2315: aload_1
    //   2316: getfield 266	com/tencent/mobileqq/app/face/FaceInfo:jdField_a_of_type_ArrayOfLong	[J
    //   2319: getstatic 269	com/tencent/mobileqq/app/face/FaceInfo:o	I
    //   2322: laload
    //   2323: aload_1
    //   2324: getfield 266	com/tencent/mobileqq/app/face/FaceInfo:jdField_a_of_type_ArrayOfLong	[J
    //   2327: getstatic 316	com/tencent/mobileqq/app/face/FaceInfo:l	I
    //   2330: laload
    //   2331: lsub
    //   2332: lstore 19
    //   2334: goto -81 -> 2253
    //   2337: astore 27
    //   2339: iconst_0
    //   2340: istore 4
    //   2342: iload_3
    //   2343: istore_2
    //   2344: iload 4
    //   2346: istore_3
    //   2347: goto -337 -> 2010
    //   2350: astore 27
    //   2352: aload 25
    //   2354: astore 24
    //   2356: goto -346 -> 2010
    //   2359: iconst_0
    //   2360: istore 5
    //   2362: iconst_0
    //   2363: istore 17
    //   2365: aconst_null
    //   2366: astore 23
    //   2368: iload 16
    //   2370: istore 4
    //   2372: iload_3
    //   2373: istore 6
    //   2375: iload 5
    //   2377: istore_3
    //   2378: goto -1009 -> 1369
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2381	0	this	NearByFaceDownloader
    //   0	2381	1	paramFaceInfo	com.tencent.mobileqq.app.face.FaceInfo
    //   87	2257	2	i	int
    //   48	2330	3	j	int
    //   78	2293	4	k	int
    //   102	2274	5	m	int
    //   50	2324	6	n	int
    //   94	2169	7	i1	int
    //   90	2169	8	i2	int
    //   59	1872	9	i3	int
    //   75	1232	10	i4	int
    //   72	1185	11	i5	int
    //   53	1168	12	i6	int
    //   56	1180	13	i7	int
    //   81	781	14	i8	int
    //   84	794	15	i9	int
    //   69	2300	16	i10	int
    //   536	1828	17	bool1	boolean
    //   45	1187	18	bool2	boolean
    //   1382	951	19	l1	long
    //   1370	929	21	l2	long
    //   98	1517	23	localObject1	java.lang.Object
    //   1662	1	23	localException	java.lang.Exception
    //   2025	342	23	localObject2	java.lang.Object
    //   227	1885	24	localObject3	java.lang.Object
    //   2187	92	24	localObject4	java.lang.Object
    //   2354	1	24	localObject5	java.lang.Object
    //   66	2287	25	localObject6	java.lang.Object
    //   168	1957	26	str	String
    //   200	775	27	localObject7	java.lang.Object
    //   1993	38	27	localThrowable1	java.lang.Throwable
    //   2337	1	27	localThrowable2	java.lang.Throwable
    //   2350	1	27	localThrowable3	java.lang.Throwable
    //   231	1056	28	localObject8	java.lang.Object
    //   42	1609	29	localQQHeadInfo	AvatarInfo.QQHeadInfo
    //   692	554	30	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   508	518	1662	java/lang/Exception
    //   549	571	1662	java/lang/Exception
    //   607	615	1662	java/lang/Exception
    //   646	652	1662	java/lang/Exception
    //   683	694	1662	java/lang/Exception
    //   104	115	1993	java/lang/Throwable
    //   131	170	1993	java/lang/Throwable
    //   186	202	1993	java/lang/Throwable
    //   218	229	1993	java/lang/Throwable
    //   254	263	1993	java/lang/Throwable
    //   279	286	1993	java/lang/Throwable
    //   302	312	1993	java/lang/Throwable
    //   328	338	1993	java/lang/Throwable
    //   354	364	1993	java/lang/Throwable
    //   380	388	1993	java/lang/Throwable
    //   404	414	1993	java/lang/Throwable
    //   430	440	1993	java/lang/Throwable
    //   456	466	1993	java/lang/Throwable
    //   482	492	1993	java/lang/Throwable
    //   508	518	1993	java/lang/Throwable
    //   104	115	2187	finally
    //   131	170	2187	finally
    //   186	202	2187	finally
    //   218	229	2187	finally
    //   254	263	2187	finally
    //   279	286	2187	finally
    //   302	312	2187	finally
    //   328	338	2187	finally
    //   354	364	2187	finally
    //   380	388	2187	finally
    //   404	414	2187	finally
    //   430	440	2187	finally
    //   456	466	2187	finally
    //   482	492	2187	finally
    //   508	518	2187	finally
    //   549	571	2187	finally
    //   607	615	2187	finally
    //   646	652	2187	finally
    //   683	694	2187	finally
    //   725	750	2187	finally
    //   781	790	2187	finally
    //   821	849	2187	finally
    //   880	892	2187	finally
    //   942	950	2187	finally
    //   981	1007	2187	finally
    //   1038	1047	2187	finally
    //   1078	1106	2187	finally
    //   1137	1148	2187	finally
    //   1177	1212	2187	finally
    //   1245	1253	2187	finally
    //   1281	1297	2187	finally
    //   1330	1340	2187	finally
    //   1355	1365	2187	finally
    //   2030	2035	2187	finally
    //   549	571	2337	java/lang/Throwable
    //   607	615	2337	java/lang/Throwable
    //   646	652	2337	java/lang/Throwable
    //   683	694	2337	java/lang/Throwable
    //   725	750	2337	java/lang/Throwable
    //   781	790	2337	java/lang/Throwable
    //   821	849	2337	java/lang/Throwable
    //   880	892	2337	java/lang/Throwable
    //   942	950	2337	java/lang/Throwable
    //   981	1007	2337	java/lang/Throwable
    //   1038	1047	2337	java/lang/Throwable
    //   1078	1106	2337	java/lang/Throwable
    //   1137	1148	2337	java/lang/Throwable
    //   1177	1212	2337	java/lang/Throwable
    //   1245	1253	2337	java/lang/Throwable
    //   1281	1297	2337	java/lang/Throwable
    //   1330	1340	2350	java/lang/Throwable
    //   1355	1365	2350	java/lang/Throwable
  }
  
  public String getChoosedIP()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAvatarApiIQQAvatarManagerService.getChoosedIP();
  }
  
  public String getChoosedStrangerGroupIp()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAvatarApiIQQAvatarManagerService.getChooseStrangerGroupIP();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.NearByFaceDownloader
 * JD-Core Version:    0.7.0.1
 */