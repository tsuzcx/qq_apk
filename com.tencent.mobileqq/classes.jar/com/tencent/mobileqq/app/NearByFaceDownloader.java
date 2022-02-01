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
  protected void doDownloadFace(com.tencent.mobileqq.app.face.FaceInfo paramFaceInfo)
  {
    // Byte code:
    //   0: invokestatic 53	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +38 -> 41
    //   6: new 55	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   13: astore 15
    //   15: aload 15
    //   17: ldc 60
    //   19: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: pop
    //   23: aload 15
    //   25: aload_1
    //   26: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   29: pop
    //   30: ldc 69
    //   32: iconst_2
    //   33: aload 15
    //   35: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: invokestatic 77	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   41: aload_1
    //   42: getstatic 83	com/tencent/mobileqq/app/face/FaceInfo:n	I
    //   45: invokevirtual 86	com/tencent/mobileqq/app/face/FaceInfo:a	(I)V
    //   48: aload_1
    //   49: getfield 89	com/tencent/mobileqq/app/face/FaceInfo:jdField_a_of_type_AvatarInfoQQHeadInfo	LAvatarInfo/QQHeadInfo;
    //   52: astore 22
    //   54: aload 22
    //   56: getfield 94	AvatarInfo/QQHeadInfo:downLoadUrl	Ljava/lang/String;
    //   59: astore 15
    //   61: aload 22
    //   63: getfield 94	AvatarInfo/QQHeadInfo:downLoadUrl	Ljava/lang/String;
    //   66: invokestatic 100	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   69: istore 10
    //   71: iload 10
    //   73: ifne +1314 -> 1387
    //   76: new 55	java/lang/StringBuilder
    //   79: dup
    //   80: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   83: astore 16
    //   85: aload 16
    //   87: ldc 102
    //   89: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: pop
    //   93: aload 16
    //   95: aload_1
    //   96: getfield 105	com/tencent/mobileqq/app/face/FaceInfo:b	I
    //   99: invokestatic 110	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   102: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: pop
    //   106: aload 16
    //   108: ldc 112
    //   110: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: pop
    //   114: aload 16
    //   116: aload_1
    //   117: getfield 114	com/tencent/mobileqq/app/face/FaceInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   120: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: pop
    //   124: aload 16
    //   126: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   129: astore 17
    //   131: aload_0
    //   132: getfield 14	com/tencent/mobileqq/app/NearByFaceDownloader:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   135: ldc 34
    //   137: ldc 36
    //   139: invokevirtual 40	com/tencent/common/app/AppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   142: checkcast 34	com/tencent/mobileqq/avatar/api/IQQAvatarManagerService
    //   145: astore 18
    //   147: aload 18
    //   149: aload 17
    //   151: invokeinterface 118 2 0
    //   156: astore 16
    //   158: aload 16
    //   160: astore 21
    //   162: aload 16
    //   164: ifnonnull +41 -> 205
    //   167: new 120	com/tencent/mobileqq/data/Setting
    //   170: dup
    //   171: invokespecial 121	com/tencent/mobileqq/data/Setting:<init>	()V
    //   174: astore 21
    //   176: aload 21
    //   178: aload 17
    //   180: putfield 124	com/tencent/mobileqq/data/Setting:uin	Ljava/lang/String;
    //   183: goto +22 -> 205
    //   186: astore 16
    //   188: iconst_0
    //   189: istore 4
    //   191: iconst_0
    //   192: istore 5
    //   194: iconst_0
    //   195: istore 6
    //   197: goto +1167 -> 1364
    //   200: astore 17
    //   202: goto +1367 -> 1569
    //   205: aload 21
    //   207: aload 22
    //   209: getfield 128	AvatarInfo/QQHeadInfo:dwFaceFlgas	B
    //   212: putfield 131	com/tencent/mobileqq/data/Setting:bFaceFlags	B
    //   215: aload 21
    //   217: aload 22
    //   219: getfield 134	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   222: putfield 137	com/tencent/mobileqq/data/Setting:bUsrType	B
    //   225: aload 21
    //   227: aload 22
    //   229: getfield 94	AvatarInfo/QQHeadInfo:downLoadUrl	Ljava/lang/String;
    //   232: putfield 140	com/tencent/mobileqq/data/Setting:url	Ljava/lang/String;
    //   235: aload 21
    //   237: invokestatic 146	java/lang/System:currentTimeMillis	()J
    //   240: putfield 150	com/tencent/mobileqq/data/Setting:updateTimestamp	J
    //   243: aload 21
    //   245: aload 22
    //   247: getfield 153	AvatarInfo/QQHeadInfo:headLevel	B
    //   250: putfield 156	com/tencent/mobileqq/data/Setting:bSourceType	B
    //   253: aload 21
    //   255: aload 22
    //   257: getfield 159	AvatarInfo/QQHeadInfo:cHeadType	B
    //   260: putfield 162	com/tencent/mobileqq/data/Setting:bHeadType	B
    //   263: aload 21
    //   265: aload 22
    //   267: getfield 166	AvatarInfo/QQHeadInfo:systemHeadID	S
    //   270: putfield 167	com/tencent/mobileqq/data/Setting:systemHeadID	S
    //   273: aload 22
    //   275: getfield 170	AvatarInfo/QQHeadInfo:dwTimestamp	J
    //   278: lstore 11
    //   280: aload 21
    //   282: lload 11
    //   284: putfield 173	com/tencent/mobileqq/data/Setting:headImgTimestamp	J
    //   287: aload 18
    //   289: aload_1
    //   290: invokeinterface 177 2 0
    //   295: astore 16
    //   297: new 179	java/io/File
    //   300: dup
    //   301: aload 16
    //   303: iconst_0
    //   304: aload 16
    //   306: ldc 181
    //   308: invokevirtual 187	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   311: invokevirtual 191	java/lang/String:substring	(II)Ljava/lang/String;
    //   314: invokespecial 194	java/io/File:<init>	(Ljava/lang/String;)V
    //   317: astore 17
    //   319: aload 17
    //   321: invokevirtual 197	java/io/File:exists	()Z
    //   324: istore 10
    //   326: iload 10
    //   328: ifne +17 -> 345
    //   331: aload 17
    //   333: invokevirtual 200	java/io/File:mkdirs	()Z
    //   336: pop
    //   337: goto +8 -> 345
    //   340: astore 17
    //   342: goto +856 -> 1198
    //   345: new 179	java/io/File
    //   348: dup
    //   349: aload 16
    //   351: invokespecial 194	java/io/File:<init>	(Ljava/lang/String;)V
    //   354: astore 23
    //   356: aload 22
    //   358: getfield 94	AvatarInfo/QQHeadInfo:downLoadUrl	Ljava/lang/String;
    //   361: astore 17
    //   363: aload 22
    //   365: getfield 128	AvatarInfo/QQHeadInfo:dwFaceFlgas	B
    //   368: istore_2
    //   369: aload 22
    //   371: getfield 134	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   374: istore_3
    //   375: aload 17
    //   377: iload_2
    //   378: iload_3
    //   379: aload 22
    //   381: getfield 203	AvatarInfo/QQHeadInfo:originUsrType	I
    //   384: invokestatic 209	com/tencent/mobileqq/app/face/util/AvatarDownloadUtil:getQQAvatarDownLoadUrl	(Ljava/lang/String;BBI)Ljava/lang/String;
    //   387: astore 19
    //   389: aload 19
    //   391: astore 17
    //   393: aload 19
    //   395: astore 18
    //   397: ldc 211
    //   399: aload 19
    //   401: invokestatic 217	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:insertMtype	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   404: astore 15
    //   406: aload 15
    //   408: astore 17
    //   410: aload 15
    //   412: astore 18
    //   414: new 55	java/lang/StringBuilder
    //   417: dup
    //   418: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   421: astore 19
    //   423: aload 15
    //   425: astore 17
    //   427: aload 15
    //   429: astore 18
    //   431: aload 19
    //   433: aload 15
    //   435: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   438: pop
    //   439: aload 15
    //   441: astore 17
    //   443: aload 15
    //   445: astore 18
    //   447: aload 19
    //   449: ldc 219
    //   451: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   454: pop
    //   455: aload 16
    //   457: astore 20
    //   459: aload 15
    //   461: astore 17
    //   463: aload 19
    //   465: invokestatic 146	java/lang/System:currentTimeMillis	()J
    //   468: invokevirtual 222	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   471: pop
    //   472: aload 15
    //   474: astore 17
    //   476: aload 19
    //   478: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   481: astore 19
    //   483: aload_0
    //   484: aload 19
    //   486: aload 23
    //   488: aload_1
    //   489: iconst_1
    //   490: invokevirtual 226	com/tencent/mobileqq/app/NearByFaceDownloader:downloadData	(Ljava/lang/String;Ljava/io/File;Lcom/tencent/mobileqq/app/face/FaceInfo;Z)I
    //   493: istore 5
    //   495: aload 19
    //   497: astore 15
    //   499: iload 5
    //   501: istore 4
    //   503: iload 5
    //   505: ifeq +322 -> 827
    //   508: aload 19
    //   510: astore 15
    //   512: iload 5
    //   514: istore 4
    //   516: aload 19
    //   518: astore 18
    //   520: iload 5
    //   522: istore 6
    //   524: aload 19
    //   526: astore 17
    //   528: iload 5
    //   530: istore 7
    //   532: iconst_1
    //   533: invokestatic 232	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getActiveNetIpFamily	(Z)I
    //   536: iconst_3
    //   537: if_icmpne +290 -> 827
    //   540: aload 19
    //   542: astore 18
    //   544: iload 5
    //   546: istore 6
    //   548: aload 19
    //   550: astore 17
    //   552: iload 5
    //   554: istore 7
    //   556: aload 22
    //   558: getfield 94	AvatarInfo/QQHeadInfo:downLoadUrl	Ljava/lang/String;
    //   561: aload 22
    //   563: getfield 128	AvatarInfo/QQHeadInfo:dwFaceFlgas	B
    //   566: aload 22
    //   568: getfield 134	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   571: aload 22
    //   573: getfield 203	AvatarInfo/QQHeadInfo:originUsrType	I
    //   576: iconst_1
    //   577: invokestatic 235	com/tencent/mobileqq/app/face/util/AvatarDownloadUtil:getQQAvatarDownLoadUrl	(Ljava/lang/String;BBIZ)Ljava/lang/String;
    //   580: astore 15
    //   582: aload 15
    //   584: astore 18
    //   586: iload 5
    //   588: istore 6
    //   590: aload 15
    //   592: astore 17
    //   594: iload 5
    //   596: istore 7
    //   598: ldc 211
    //   600: aload 15
    //   602: invokestatic 217	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:insertMtype	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   605: astore 19
    //   607: new 55	java/lang/StringBuilder
    //   610: dup
    //   611: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   614: astore 15
    //   616: aload 15
    //   618: aload 19
    //   620: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   623: pop
    //   624: aload 15
    //   626: ldc 219
    //   628: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   631: pop
    //   632: aload 15
    //   634: invokestatic 146	java/lang/System:currentTimeMillis	()J
    //   637: invokevirtual 222	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   640: pop
    //   641: aload 15
    //   643: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   646: astore 15
    //   648: aload 15
    //   650: astore 18
    //   652: iload 5
    //   654: istore 6
    //   656: aload 15
    //   658: astore 17
    //   660: iload 5
    //   662: istore 7
    //   664: aload_0
    //   665: aload 15
    //   667: aload 23
    //   669: aload_1
    //   670: iconst_1
    //   671: invokevirtual 226	com/tencent/mobileqq/app/NearByFaceDownloader:downloadData	(Ljava/lang/String;Ljava/io/File;Lcom/tencent/mobileqq/app/face/FaceInfo;Z)I
    //   674: istore 4
    //   676: aload 15
    //   678: astore 18
    //   680: iload 4
    //   682: istore 6
    //   684: aload 15
    //   686: astore 17
    //   688: iload 4
    //   690: istore 7
    //   692: new 55	java/lang/StringBuilder
    //   695: dup
    //   696: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   699: astore 19
    //   701: aload 15
    //   703: astore 18
    //   705: iload 4
    //   707: istore 6
    //   709: aload 15
    //   711: astore 17
    //   713: iload 4
    //   715: istore 7
    //   717: aload 19
    //   719: ldc 237
    //   721: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   724: pop
    //   725: aload 15
    //   727: astore 18
    //   729: iload 4
    //   731: istore 6
    //   733: aload 15
    //   735: astore 17
    //   737: iload 4
    //   739: istore 7
    //   741: aload 19
    //   743: aload 15
    //   745: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   748: pop
    //   749: aload 15
    //   751: astore 18
    //   753: iload 4
    //   755: istore 6
    //   757: aload 15
    //   759: astore 17
    //   761: iload 4
    //   763: istore 7
    //   765: aload 19
    //   767: ldc 239
    //   769: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   772: pop
    //   773: aload 15
    //   775: astore 18
    //   777: iload 4
    //   779: istore 6
    //   781: aload 15
    //   783: astore 17
    //   785: iload 4
    //   787: istore 7
    //   789: aload 19
    //   791: iload 4
    //   793: invokevirtual 242	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   796: pop
    //   797: aload 15
    //   799: astore 18
    //   801: iload 4
    //   803: istore 6
    //   805: aload 15
    //   807: astore 17
    //   809: iload 4
    //   811: istore 7
    //   813: ldc 69
    //   815: iconst_1
    //   816: aload 19
    //   818: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   821: invokestatic 77	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   824: goto +3 -> 827
    //   827: iload 4
    //   829: ifne +92 -> 921
    //   832: aload 15
    //   834: astore 18
    //   836: iload 4
    //   838: istore 6
    //   840: aload 15
    //   842: astore 17
    //   844: iload 4
    //   846: istore 7
    //   848: aload 23
    //   850: invokevirtual 245	java/io/File:length	()J
    //   853: lstore 11
    //   855: lload 11
    //   857: l2i
    //   858: istore 5
    //   860: new 247	com/tencent/mobileqq/app/NearByFaceDownloader$UpdateSettingRunnable
    //   863: dup
    //   864: aload_0
    //   865: aload 21
    //   867: aload_1
    //   868: invokespecial 250	com/tencent/mobileqq/app/NearByFaceDownloader$UpdateSettingRunnable:<init>	(Lcom/tencent/mobileqq/app/NearByFaceDownloader;Lcom/tencent/mobileqq/data/Setting;Lcom/tencent/mobileqq/app/face/FaceInfo;)V
    //   871: aconst_null
    //   872: iconst_0
    //   873: invokestatic 256	com/tencent/mobileqq/app/ThreadManager:postImmediately	(Ljava/lang/Runnable;Lcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   876: iconst_1
    //   877: istore 10
    //   879: iconst_0
    //   880: istore 6
    //   882: iconst_0
    //   883: istore 7
    //   885: goto +118 -> 1003
    //   888: astore 16
    //   890: iload 4
    //   892: istore 6
    //   894: goto +467 -> 1361
    //   897: astore 17
    //   899: iload 4
    //   901: istore 6
    //   903: iconst_1
    //   904: istore 10
    //   906: aload 15
    //   908: astore 18
    //   910: iload 5
    //   912: istore 4
    //   914: iload 6
    //   916: istore 5
    //   918: goto +210 -> 1128
    //   921: iload 4
    //   923: iconst_1
    //   924: if_icmpeq +68 -> 992
    //   927: iload 4
    //   929: bipush 33
    //   931: if_icmpeq +49 -> 980
    //   934: iload 4
    //   936: iconst_4
    //   937: if_icmpeq +35 -> 972
    //   940: iload 4
    //   942: iconst_5
    //   943: if_icmpeq +21 -> 964
    //   946: iload 4
    //   948: istore 7
    //   950: sipush 9207
    //   953: istore 6
    //   955: iconst_0
    //   956: istore 10
    //   958: iconst_0
    //   959: istore 5
    //   961: goto +42 -> 1003
    //   964: sipush 9204
    //   967: istore 6
    //   969: goto +28 -> 997
    //   972: sipush 9202
    //   975: istore 6
    //   977: goto +20 -> 997
    //   980: iload 4
    //   982: istore 7
    //   984: sipush 9208
    //   987: istore 6
    //   989: goto -34 -> 955
    //   992: sipush 9206
    //   995: istore 6
    //   997: iconst_0
    //   998: istore 7
    //   1000: goto -45 -> 955
    //   1003: iload 10
    //   1005: ifeq +1277 -> 2282
    //   1008: aload_0
    //   1009: getfield 16	com/tencent/mobileqq/app/NearByFaceDownloader:jdField_a_of_type_ComTencentMobileqqAppFaceFaceHandler	Lcom/tencent/mobileqq/app/face/FaceHandler;
    //   1012: iconst_0
    //   1013: iconst_1
    //   1014: aload_1
    //   1015: invokevirtual 260	com/tencent/mobileqq/app/face/FaceHandler:notifyUI	(IZLjava/lang/Object;)V
    //   1018: goto +3 -> 1021
    //   1021: aload_0
    //   1022: getfield 16	com/tencent/mobileqq/app/NearByFaceDownloader:jdField_a_of_type_ComTencentMobileqqAppFaceFaceHandler	Lcom/tencent/mobileqq/app/face/FaceHandler;
    //   1025: iconst_1
    //   1026: iconst_1
    //   1027: aload_1
    //   1028: invokevirtual 260	com/tencent/mobileqq/app/face/FaceHandler:notifyUI	(IZLjava/lang/Object;)V
    //   1031: aload 15
    //   1033: astore 16
    //   1035: iload 5
    //   1037: istore 8
    //   1039: iload 4
    //   1041: istore 9
    //   1043: iload 6
    //   1045: istore 5
    //   1047: aload 20
    //   1049: astore 15
    //   1051: iload 7
    //   1053: istore 4
    //   1055: goto +354 -> 1409
    //   1058: astore 16
    //   1060: iload 4
    //   1062: istore 7
    //   1064: iload 6
    //   1066: istore 4
    //   1068: iload 7
    //   1070: istore 6
    //   1072: goto +292 -> 1364
    //   1075: astore 17
    //   1077: iload 7
    //   1079: istore 6
    //   1081: iload 4
    //   1083: istore 7
    //   1085: iload 5
    //   1087: istore 4
    //   1089: iload 7
    //   1091: istore 5
    //   1093: goto +42 -> 1135
    //   1096: astore 16
    //   1098: aload 19
    //   1100: astore 15
    //   1102: goto -914 -> 188
    //   1105: astore 15
    //   1107: iconst_0
    //   1108: istore 5
    //   1110: aload 19
    //   1112: astore 17
    //   1114: iconst_0
    //   1115: istore 4
    //   1117: iconst_0
    //   1118: istore 10
    //   1120: aload 17
    //   1122: astore 18
    //   1124: aload 15
    //   1126: astore 17
    //   1128: iconst_0
    //   1129: istore 6
    //   1131: aload 18
    //   1133: astore 15
    //   1135: goto +449 -> 1584
    //   1138: astore 17
    //   1140: goto +18 -> 1158
    //   1143: astore 16
    //   1145: aload 17
    //   1147: astore 15
    //   1149: goto -961 -> 188
    //   1152: astore 17
    //   1154: aload 18
    //   1156: astore 15
    //   1158: iconst_0
    //   1159: istore 4
    //   1161: iconst_0
    //   1162: istore 5
    //   1164: iconst_0
    //   1165: istore 10
    //   1167: iconst_0
    //   1168: istore 6
    //   1170: goto +414 -> 1584
    //   1173: astore 16
    //   1175: goto -987 -> 188
    //   1178: astore 17
    //   1180: goto +5 -> 1185
    //   1183: astore 17
    //   1185: goto +187 -> 1372
    //   1188: astore 16
    //   1190: goto -1002 -> 188
    //   1193: astore 17
    //   1195: aconst_null
    //   1196: astore 16
    //   1198: goto +374 -> 1572
    //   1201: aload_1
    //   1202: getfield 263	com/tencent/mobileqq/app/face/FaceInfo:e	I
    //   1205: iconst_1
    //   1206: if_icmpne +52 -> 1258
    //   1209: aload_1
    //   1210: getfield 266	com/tencent/mobileqq/app/face/FaceInfo:jdField_a_of_type_ArrayOfLong	[J
    //   1213: getstatic 269	com/tencent/mobileqq/app/face/FaceInfo:o	I
    //   1216: laload
    //   1217: lconst_0
    //   1218: lcmp
    //   1219: ifle +95 -> 1314
    //   1222: aload_1
    //   1223: getfield 266	com/tencent/mobileqq/app/face/FaceInfo:jdField_a_of_type_ArrayOfLong	[J
    //   1226: getstatic 83	com/tencent/mobileqq/app/face/FaceInfo:n	I
    //   1229: laload
    //   1230: lconst_0
    //   1231: lcmp
    //   1232: ifle +82 -> 1314
    //   1235: aload_1
    //   1236: getfield 266	com/tencent/mobileqq/app/face/FaceInfo:jdField_a_of_type_ArrayOfLong	[J
    //   1239: getstatic 269	com/tencent/mobileqq/app/face/FaceInfo:o	I
    //   1242: laload
    //   1243: lstore 11
    //   1245: aload_1
    //   1246: getfield 266	com/tencent/mobileqq/app/face/FaceInfo:jdField_a_of_type_ArrayOfLong	[J
    //   1249: getstatic 83	com/tencent/mobileqq/app/face/FaceInfo:n	I
    //   1252: laload
    //   1253: lstore 13
    //   1255: goto +49 -> 1304
    //   1258: aload_1
    //   1259: getfield 266	com/tencent/mobileqq/app/face/FaceInfo:jdField_a_of_type_ArrayOfLong	[J
    //   1262: getstatic 269	com/tencent/mobileqq/app/face/FaceInfo:o	I
    //   1265: laload
    //   1266: lconst_0
    //   1267: lcmp
    //   1268: ifle +46 -> 1314
    //   1271: aload_1
    //   1272: getfield 266	com/tencent/mobileqq/app/face/FaceInfo:jdField_a_of_type_ArrayOfLong	[J
    //   1275: getstatic 272	com/tencent/mobileqq/app/face/FaceInfo:l	I
    //   1278: laload
    //   1279: lconst_0
    //   1280: lcmp
    //   1281: ifle +33 -> 1314
    //   1284: aload_1
    //   1285: getfield 266	com/tencent/mobileqq/app/face/FaceInfo:jdField_a_of_type_ArrayOfLong	[J
    //   1288: getstatic 269	com/tencent/mobileqq/app/face/FaceInfo:o	I
    //   1291: laload
    //   1292: lstore 11
    //   1294: aload_1
    //   1295: getfield 266	com/tencent/mobileqq/app/face/FaceInfo:jdField_a_of_type_ArrayOfLong	[J
    //   1298: getstatic 272	com/tencent/mobileqq/app/face/FaceInfo:l	I
    //   1301: laload
    //   1302: lstore 13
    //   1304: lload 11
    //   1306: lload 13
    //   1308: lsub
    //   1309: lstore 11
    //   1311: goto +6 -> 1317
    //   1314: lconst_0
    //   1315: lstore 11
    //   1317: new 274	com/tencent/mobileqq/app/NearByFaceDownloader$HeadCostStatRunnable
    //   1320: dup
    //   1321: aload_0
    //   1322: sipush 9202
    //   1325: aload_1
    //   1326: iconst_4
    //   1327: iconst_0
    //   1328: aload 15
    //   1330: iconst_0
    //   1331: lload 11
    //   1333: invokespecial 277	com/tencent/mobileqq/app/NearByFaceDownloader$HeadCostStatRunnable:<init>	(Lcom/tencent/mobileqq/app/NearByFaceDownloader;ILcom/tencent/mobileqq/app/face/FaceInfo;IILjava/lang/String;IJ)V
    //   1336: aconst_null
    //   1337: iconst_0
    //   1338: invokestatic 256	com/tencent/mobileqq/app/ThreadManager:postImmediately	(Ljava/lang/Runnable;Lcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   1341: return
    //   1342: astore 16
    //   1344: iconst_0
    //   1345: istore 5
    //   1347: iconst_0
    //   1348: istore 6
    //   1350: goto +11 -> 1361
    //   1353: astore 16
    //   1355: iconst_0
    //   1356: istore 5
    //   1358: iconst_0
    //   1359: istore 6
    //   1361: iconst_0
    //   1362: istore 4
    //   1364: goto +697 -> 2061
    //   1367: astore 17
    //   1369: aconst_null
    //   1370: astore 16
    //   1372: iconst_0
    //   1373: istore 5
    //   1375: iconst_0
    //   1376: istore 4
    //   1378: iconst_0
    //   1379: istore 10
    //   1381: iconst_0
    //   1382: istore 6
    //   1384: goto +200 -> 1584
    //   1387: iconst_0
    //   1388: istore 8
    //   1390: iconst_0
    //   1391: istore 9
    //   1393: aload 15
    //   1395: astore 16
    //   1397: aconst_null
    //   1398: astore 15
    //   1400: iconst_0
    //   1401: istore 5
    //   1403: iconst_0
    //   1404: istore 10
    //   1406: iconst_0
    //   1407: istore 4
    //   1409: aload_1
    //   1410: getfield 263	com/tencent/mobileqq/app/face/FaceInfo:e	I
    //   1413: iconst_1
    //   1414: if_icmpne +52 -> 1466
    //   1417: aload_1
    //   1418: getfield 266	com/tencent/mobileqq/app/face/FaceInfo:jdField_a_of_type_ArrayOfLong	[J
    //   1421: getstatic 269	com/tencent/mobileqq/app/face/FaceInfo:o	I
    //   1424: laload
    //   1425: lconst_0
    //   1426: lcmp
    //   1427: ifle +95 -> 1522
    //   1430: aload_1
    //   1431: getfield 266	com/tencent/mobileqq/app/face/FaceInfo:jdField_a_of_type_ArrayOfLong	[J
    //   1434: getstatic 83	com/tencent/mobileqq/app/face/FaceInfo:n	I
    //   1437: laload
    //   1438: lconst_0
    //   1439: lcmp
    //   1440: ifle +82 -> 1522
    //   1443: aload_1
    //   1444: getfield 266	com/tencent/mobileqq/app/face/FaceInfo:jdField_a_of_type_ArrayOfLong	[J
    //   1447: getstatic 269	com/tencent/mobileqq/app/face/FaceInfo:o	I
    //   1450: laload
    //   1451: lstore 11
    //   1453: aload_1
    //   1454: getfield 266	com/tencent/mobileqq/app/face/FaceInfo:jdField_a_of_type_ArrayOfLong	[J
    //   1457: getstatic 83	com/tencent/mobileqq/app/face/FaceInfo:n	I
    //   1460: laload
    //   1461: lstore 13
    //   1463: goto +49 -> 1512
    //   1466: aload_1
    //   1467: getfield 266	com/tencent/mobileqq/app/face/FaceInfo:jdField_a_of_type_ArrayOfLong	[J
    //   1470: getstatic 269	com/tencent/mobileqq/app/face/FaceInfo:o	I
    //   1473: laload
    //   1474: lconst_0
    //   1475: lcmp
    //   1476: ifle +46 -> 1522
    //   1479: aload_1
    //   1480: getfield 266	com/tencent/mobileqq/app/face/FaceInfo:jdField_a_of_type_ArrayOfLong	[J
    //   1483: getstatic 272	com/tencent/mobileqq/app/face/FaceInfo:l	I
    //   1486: laload
    //   1487: lconst_0
    //   1488: lcmp
    //   1489: ifle +33 -> 1522
    //   1492: aload_1
    //   1493: getfield 266	com/tencent/mobileqq/app/face/FaceInfo:jdField_a_of_type_ArrayOfLong	[J
    //   1496: getstatic 269	com/tencent/mobileqq/app/face/FaceInfo:o	I
    //   1499: laload
    //   1500: lstore 11
    //   1502: aload_1
    //   1503: getfield 266	com/tencent/mobileqq/app/face/FaceInfo:jdField_a_of_type_ArrayOfLong	[J
    //   1506: getstatic 272	com/tencent/mobileqq/app/face/FaceInfo:l	I
    //   1509: laload
    //   1510: lstore 13
    //   1512: lload 11
    //   1514: lload 13
    //   1516: lsub
    //   1517: lstore 11
    //   1519: goto +6 -> 1525
    //   1522: lconst_0
    //   1523: lstore 11
    //   1525: new 274	com/tencent/mobileqq/app/NearByFaceDownloader$HeadCostStatRunnable
    //   1528: dup
    //   1529: aload_0
    //   1530: iload 5
    //   1532: aload_1
    //   1533: iconst_4
    //   1534: iload 8
    //   1536: aload 16
    //   1538: iload 9
    //   1540: lload 11
    //   1542: invokespecial 277	com/tencent/mobileqq/app/NearByFaceDownloader$HeadCostStatRunnable:<init>	(Lcom/tencent/mobileqq/app/NearByFaceDownloader;ILcom/tencent/mobileqq/app/face/FaceInfo;IILjava/lang/String;IJ)V
    //   1545: aconst_null
    //   1546: iconst_0
    //   1547: invokestatic 256	com/tencent/mobileqq/app/ThreadManager:postImmediately	(Ljava/lang/Runnable;Lcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   1550: goto +202 -> 1752
    //   1553: astore 16
    //   1555: iconst_0
    //   1556: istore 5
    //   1558: iconst_0
    //   1559: istore 6
    //   1561: iconst_0
    //   1562: istore 4
    //   1564: goto +497 -> 2061
    //   1567: astore 17
    //   1569: aconst_null
    //   1570: astore 16
    //   1572: iconst_0
    //   1573: istore 10
    //   1575: iconst_0
    //   1576: istore 5
    //   1578: iconst_0
    //   1579: istore 4
    //   1581: iconst_0
    //   1582: istore 6
    //   1584: aload 17
    //   1586: invokevirtual 280	java/lang/Throwable:printStackTrace	()V
    //   1589: aload_1
    //   1590: getfield 263	com/tencent/mobileqq/app/face/FaceInfo:e	I
    //   1593: iconst_1
    //   1594: if_icmpne +52 -> 1646
    //   1597: aload_1
    //   1598: getfield 266	com/tencent/mobileqq/app/face/FaceInfo:jdField_a_of_type_ArrayOfLong	[J
    //   1601: getstatic 269	com/tencent/mobileqq/app/face/FaceInfo:o	I
    //   1604: laload
    //   1605: lconst_0
    //   1606: lcmp
    //   1607: ifle +95 -> 1702
    //   1610: aload_1
    //   1611: getfield 266	com/tencent/mobileqq/app/face/FaceInfo:jdField_a_of_type_ArrayOfLong	[J
    //   1614: getstatic 83	com/tencent/mobileqq/app/face/FaceInfo:n	I
    //   1617: laload
    //   1618: lconst_0
    //   1619: lcmp
    //   1620: ifle +82 -> 1702
    //   1623: aload_1
    //   1624: getfield 266	com/tencent/mobileqq/app/face/FaceInfo:jdField_a_of_type_ArrayOfLong	[J
    //   1627: getstatic 269	com/tencent/mobileqq/app/face/FaceInfo:o	I
    //   1630: laload
    //   1631: lstore 11
    //   1633: aload_1
    //   1634: getfield 266	com/tencent/mobileqq/app/face/FaceInfo:jdField_a_of_type_ArrayOfLong	[J
    //   1637: getstatic 83	com/tencent/mobileqq/app/face/FaceInfo:n	I
    //   1640: laload
    //   1641: lstore 13
    //   1643: goto +49 -> 1692
    //   1646: aload_1
    //   1647: getfield 266	com/tencent/mobileqq/app/face/FaceInfo:jdField_a_of_type_ArrayOfLong	[J
    //   1650: getstatic 269	com/tencent/mobileqq/app/face/FaceInfo:o	I
    //   1653: laload
    //   1654: lconst_0
    //   1655: lcmp
    //   1656: ifle +46 -> 1702
    //   1659: aload_1
    //   1660: getfield 266	com/tencent/mobileqq/app/face/FaceInfo:jdField_a_of_type_ArrayOfLong	[J
    //   1663: getstatic 272	com/tencent/mobileqq/app/face/FaceInfo:l	I
    //   1666: laload
    //   1667: lconst_0
    //   1668: lcmp
    //   1669: ifle +33 -> 1702
    //   1672: aload_1
    //   1673: getfield 266	com/tencent/mobileqq/app/face/FaceInfo:jdField_a_of_type_ArrayOfLong	[J
    //   1676: getstatic 269	com/tencent/mobileqq/app/face/FaceInfo:o	I
    //   1679: laload
    //   1680: lstore 11
    //   1682: aload_1
    //   1683: getfield 266	com/tencent/mobileqq/app/face/FaceInfo:jdField_a_of_type_ArrayOfLong	[J
    //   1686: getstatic 272	com/tencent/mobileqq/app/face/FaceInfo:l	I
    //   1689: laload
    //   1690: lstore 13
    //   1692: lload 11
    //   1694: lload 13
    //   1696: lsub
    //   1697: lstore 11
    //   1699: goto +6 -> 1705
    //   1702: lconst_0
    //   1703: lstore 11
    //   1705: new 274	com/tencent/mobileqq/app/NearByFaceDownloader$HeadCostStatRunnable
    //   1708: dup
    //   1709: aload_0
    //   1710: sipush 9204
    //   1713: aload_1
    //   1714: iconst_4
    //   1715: iload 4
    //   1717: aload 15
    //   1719: iload 5
    //   1721: lload 11
    //   1723: invokespecial 277	com/tencent/mobileqq/app/NearByFaceDownloader$HeadCostStatRunnable:<init>	(Lcom/tencent/mobileqq/app/NearByFaceDownloader;ILcom/tencent/mobileqq/app/face/FaceInfo;IILjava/lang/String;IJ)V
    //   1726: aconst_null
    //   1727: iconst_0
    //   1728: invokestatic 256	com/tencent/mobileqq/app/ThreadManager:postImmediately	(Ljava/lang/Runnable;Lcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   1731: aload 16
    //   1733: astore 17
    //   1735: iload 6
    //   1737: istore 4
    //   1739: sipush 9204
    //   1742: istore 5
    //   1744: aload 15
    //   1746: astore 16
    //   1748: aload 17
    //   1750: astore 15
    //   1752: invokestatic 53	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1755: ifne +8 -> 1763
    //   1758: iload 10
    //   1760: ifne +281 -> 2041
    //   1763: new 55	java/lang/StringBuilder
    //   1766: dup
    //   1767: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   1770: astore 17
    //   1772: aload 17
    //   1774: ldc_w 282
    //   1777: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1780: pop
    //   1781: aload 17
    //   1783: aload_1
    //   1784: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1787: pop
    //   1788: aload 17
    //   1790: ldc_w 284
    //   1793: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1796: pop
    //   1797: aload 17
    //   1799: iload 10
    //   1801: invokevirtual 287	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1804: pop
    //   1805: aload 17
    //   1807: ldc_w 289
    //   1810: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1813: pop
    //   1814: aload 17
    //   1816: iload 5
    //   1818: invokevirtual 242	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1821: pop
    //   1822: aload 17
    //   1824: ldc_w 291
    //   1827: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1830: pop
    //   1831: aload 17
    //   1833: aload 22
    //   1835: getfield 293	AvatarInfo/QQHeadInfo:uin	J
    //   1838: invokevirtual 222	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1841: pop
    //   1842: aload 17
    //   1844: ldc_w 295
    //   1847: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1850: pop
    //   1851: aload 17
    //   1853: aload 22
    //   1855: getfield 298	AvatarInfo/QQHeadInfo:phoneNum	Ljava/lang/String;
    //   1858: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1861: pop
    //   1862: aload 17
    //   1864: ldc_w 300
    //   1867: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1870: pop
    //   1871: aload 17
    //   1873: aload 22
    //   1875: getfield 159	AvatarInfo/QQHeadInfo:cHeadType	B
    //   1878: invokevirtual 242	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1881: pop
    //   1882: aload 17
    //   1884: ldc_w 302
    //   1887: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1890: pop
    //   1891: aload 17
    //   1893: aload 22
    //   1895: getfield 134	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   1898: invokevirtual 242	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1901: pop
    //   1902: aload 17
    //   1904: ldc_w 304
    //   1907: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1910: pop
    //   1911: aload 17
    //   1913: aload 22
    //   1915: getfield 166	AvatarInfo/QQHeadInfo:systemHeadID	S
    //   1918: invokevirtual 242	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1921: pop
    //   1922: aload 17
    //   1924: ldc_w 306
    //   1927: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1930: pop
    //   1931: aload 17
    //   1933: iload 4
    //   1935: invokevirtual 242	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1938: pop
    //   1939: aload 17
    //   1941: ldc_w 308
    //   1944: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1947: pop
    //   1948: aload 17
    //   1950: aload 22
    //   1952: getfield 170	AvatarInfo/QQHeadInfo:dwTimestamp	J
    //   1955: invokevirtual 222	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1958: pop
    //   1959: aload 17
    //   1961: ldc_w 310
    //   1964: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1967: pop
    //   1968: aload 17
    //   1970: aload 15
    //   1972: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1975: pop
    //   1976: aload 17
    //   1978: ldc_w 312
    //   1981: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1984: pop
    //   1985: aload 17
    //   1987: aload 16
    //   1989: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1992: pop
    //   1993: aload 17
    //   1995: ldc_w 314
    //   1998: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2001: pop
    //   2002: aload 17
    //   2004: aload 22
    //   2006: getfield 94	AvatarInfo/QQHeadInfo:downLoadUrl	Ljava/lang/String;
    //   2009: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2012: pop
    //   2013: aload 17
    //   2015: ldc_w 316
    //   2018: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2021: pop
    //   2022: aload 17
    //   2024: aload 22
    //   2026: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2029: pop
    //   2030: ldc 69
    //   2032: iconst_2
    //   2033: aload 17
    //   2035: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2038: invokestatic 319	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2041: return
    //   2042: astore 16
    //   2044: sipush 9204
    //   2047: istore 7
    //   2049: iload 5
    //   2051: istore 6
    //   2053: iload 4
    //   2055: istore 5
    //   2057: iload 7
    //   2059: istore 4
    //   2061: aload_1
    //   2062: getfield 263	com/tencent/mobileqq/app/face/FaceInfo:e	I
    //   2065: iconst_1
    //   2066: if_icmpne +55 -> 2121
    //   2069: aload_1
    //   2070: getfield 266	com/tencent/mobileqq/app/face/FaceInfo:jdField_a_of_type_ArrayOfLong	[J
    //   2073: getstatic 269	com/tencent/mobileqq/app/face/FaceInfo:o	I
    //   2076: laload
    //   2077: lconst_0
    //   2078: lcmp
    //   2079: ifle +98 -> 2177
    //   2082: aload_1
    //   2083: getfield 266	com/tencent/mobileqq/app/face/FaceInfo:jdField_a_of_type_ArrayOfLong	[J
    //   2086: getstatic 83	com/tencent/mobileqq/app/face/FaceInfo:n	I
    //   2089: laload
    //   2090: lconst_0
    //   2091: lcmp
    //   2092: ifle +26 -> 2118
    //   2095: aload_1
    //   2096: getfield 266	com/tencent/mobileqq/app/face/FaceInfo:jdField_a_of_type_ArrayOfLong	[J
    //   2099: getstatic 269	com/tencent/mobileqq/app/face/FaceInfo:o	I
    //   2102: laload
    //   2103: lstore 11
    //   2105: aload_1
    //   2106: getfield 266	com/tencent/mobileqq/app/face/FaceInfo:jdField_a_of_type_ArrayOfLong	[J
    //   2109: getstatic 83	com/tencent/mobileqq/app/face/FaceInfo:n	I
    //   2112: laload
    //   2113: lstore 13
    //   2115: goto +52 -> 2167
    //   2118: goto +59 -> 2177
    //   2121: aload_1
    //   2122: getfield 266	com/tencent/mobileqq/app/face/FaceInfo:jdField_a_of_type_ArrayOfLong	[J
    //   2125: getstatic 269	com/tencent/mobileqq/app/face/FaceInfo:o	I
    //   2128: laload
    //   2129: lconst_0
    //   2130: lcmp
    //   2131: ifle +46 -> 2177
    //   2134: aload_1
    //   2135: getfield 266	com/tencent/mobileqq/app/face/FaceInfo:jdField_a_of_type_ArrayOfLong	[J
    //   2138: getstatic 272	com/tencent/mobileqq/app/face/FaceInfo:l	I
    //   2141: laload
    //   2142: lconst_0
    //   2143: lcmp
    //   2144: ifle +33 -> 2177
    //   2147: aload_1
    //   2148: getfield 266	com/tencent/mobileqq/app/face/FaceInfo:jdField_a_of_type_ArrayOfLong	[J
    //   2151: getstatic 269	com/tencent/mobileqq/app/face/FaceInfo:o	I
    //   2154: laload
    //   2155: lstore 11
    //   2157: aload_1
    //   2158: getfield 266	com/tencent/mobileqq/app/face/FaceInfo:jdField_a_of_type_ArrayOfLong	[J
    //   2161: getstatic 272	com/tencent/mobileqq/app/face/FaceInfo:l	I
    //   2164: laload
    //   2165: lstore 13
    //   2167: lload 11
    //   2169: lload 13
    //   2171: lsub
    //   2172: lstore 11
    //   2174: goto +6 -> 2180
    //   2177: lconst_0
    //   2178: lstore 11
    //   2180: new 274	com/tencent/mobileqq/app/NearByFaceDownloader$HeadCostStatRunnable
    //   2183: dup
    //   2184: aload_0
    //   2185: iload 4
    //   2187: aload_1
    //   2188: iconst_4
    //   2189: iload 5
    //   2191: aload 15
    //   2193: iload 6
    //   2195: lload 11
    //   2197: invokespecial 277	com/tencent/mobileqq/app/NearByFaceDownloader$HeadCostStatRunnable:<init>	(Lcom/tencent/mobileqq/app/NearByFaceDownloader;ILcom/tencent/mobileqq/app/face/FaceInfo;IILjava/lang/String;IJ)V
    //   2200: aconst_null
    //   2201: iconst_0
    //   2202: invokestatic 256	com/tencent/mobileqq/app/ThreadManager:postImmediately	(Ljava/lang/Runnable;Lcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   2205: goto +6 -> 2211
    //   2208: aload 16
    //   2210: athrow
    //   2211: goto -3 -> 2208
    //   2214: astore 16
    //   2216: goto -1015 -> 1201
    //   2219: astore 16
    //   2221: aload 19
    //   2223: astore 15
    //   2225: goto +35 -> 2260
    //   2228: astore 17
    //   2230: aload 20
    //   2232: astore 16
    //   2234: iconst_0
    //   2235: istore 4
    //   2237: iconst_0
    //   2238: istore 10
    //   2240: iconst_0
    //   2241: istore 6
    //   2243: aload 19
    //   2245: astore 15
    //   2247: goto -663 -> 1584
    //   2250: astore 16
    //   2252: aload 18
    //   2254: astore 15
    //   2256: iload 6
    //   2258: istore 5
    //   2260: iload 5
    //   2262: istore 6
    //   2264: iconst_0
    //   2265: istore 4
    //   2267: iconst_0
    //   2268: istore 5
    //   2270: goto -906 -> 1364
    //   2273: astore 15
    //   2275: iload 7
    //   2277: istore 5
    //   2279: goto -1165 -> 1114
    //   2282: goto -1261 -> 1021
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2285	0	this	NearByFaceDownloader
    //   0	2285	1	paramFaceInfo	com.tencent.mobileqq.app.face.FaceInfo
    //   368	10	2	b1	byte
    //   374	5	3	b2	byte
    //   189	2077	4	i	int
    //   192	2086	5	j	int
    //   195	2068	6	k	int
    //   530	1746	7	m	int
    //   1037	498	8	n	int
    //   1041	498	9	i1	int
    //   69	2170	10	bool	boolean
    //   278	1918	11	l1	long
    //   1253	917	13	l2	long
    //   13	1088	15	localObject1	java.lang.Object
    //   1105	20	15	localThrowable1	java.lang.Throwable
    //   1133	1122	15	localObject2	java.lang.Object
    //   2273	1	15	localThrowable2	java.lang.Throwable
    //   83	80	16	localObject3	java.lang.Object
    //   186	1	16	localObject4	java.lang.Object
    //   295	161	16	str1	String
    //   888	1	16	localObject5	java.lang.Object
    //   1033	1	16	localObject6	java.lang.Object
    //   1058	1	16	localObject7	java.lang.Object
    //   1096	1	16	localObject8	java.lang.Object
    //   1143	1	16	localObject9	java.lang.Object
    //   1173	1	16	localObject10	java.lang.Object
    //   1188	1	16	localObject11	java.lang.Object
    //   1196	1	16	localObject12	java.lang.Object
    //   1342	1	16	localObject13	java.lang.Object
    //   1353	1	16	localObject14	java.lang.Object
    //   1370	167	16	localObject15	java.lang.Object
    //   1553	1	16	localObject16	java.lang.Object
    //   1570	418	16	localObject17	java.lang.Object
    //   2042	167	16	localObject18	java.lang.Object
    //   2214	1	16	localException	java.lang.Exception
    //   2219	1	16	localObject19	java.lang.Object
    //   2232	1	16	localObject20	java.lang.Object
    //   2250	1	16	localObject21	java.lang.Object
    //   129	50	17	str2	String
    //   200	1	17	localThrowable3	java.lang.Throwable
    //   317	15	17	localFile1	java.io.File
    //   340	1	17	localThrowable4	java.lang.Throwable
    //   361	482	17	localObject22	java.lang.Object
    //   897	1	17	localThrowable5	java.lang.Throwable
    //   1075	1	17	localThrowable6	java.lang.Throwable
    //   1112	15	17	localObject23	java.lang.Object
    //   1138	8	17	localThrowable7	java.lang.Throwable
    //   1152	1	17	localThrowable8	java.lang.Throwable
    //   1178	1	17	localThrowable9	java.lang.Throwable
    //   1183	1	17	localThrowable10	java.lang.Throwable
    //   1193	1	17	localThrowable11	java.lang.Throwable
    //   1367	1	17	localThrowable12	java.lang.Throwable
    //   1567	18	17	localThrowable13	java.lang.Throwable
    //   1733	301	17	localObject24	java.lang.Object
    //   2228	1	17	localThrowable14	java.lang.Throwable
    //   145	2108	18	localObject25	java.lang.Object
    //   387	1857	19	localObject26	java.lang.Object
    //   457	1774	20	str3	String
    //   160	706	21	localObject27	java.lang.Object
    //   52	1973	22	localQQHeadInfo	AvatarInfo.QQHeadInfo
    //   354	495	23	localFile2	java.io.File
    // Exception table:
    //   from	to	target	type
    //   167	183	186	finally
    //   331	337	186	finally
    //   167	183	200	java/lang/Throwable
    //   331	337	340	java/lang/Throwable
    //   860	876	888	finally
    //   860	876	897	java/lang/Throwable
    //   1008	1018	1058	finally
    //   1021	1031	1058	finally
    //   1008	1018	1075	java/lang/Throwable
    //   1021	1031	1075	java/lang/Throwable
    //   483	495	1096	finally
    //   483	495	1105	java/lang/Throwable
    //   463	472	1138	java/lang/Throwable
    //   476	483	1138	java/lang/Throwable
    //   397	406	1143	finally
    //   414	423	1143	finally
    //   431	439	1143	finally
    //   447	455	1143	finally
    //   463	472	1143	finally
    //   476	483	1143	finally
    //   397	406	1152	java/lang/Throwable
    //   414	423	1152	java/lang/Throwable
    //   431	439	1152	java/lang/Throwable
    //   447	455	1152	java/lang/Throwable
    //   375	389	1173	finally
    //   375	389	1178	java/lang/Throwable
    //   297	326	1183	java/lang/Throwable
    //   345	356	1183	java/lang/Throwable
    //   356	375	1183	java/lang/Throwable
    //   287	297	1188	finally
    //   297	326	1188	finally
    //   345	356	1188	finally
    //   356	375	1188	finally
    //   287	297	1193	java/lang/Throwable
    //   280	287	1342	finally
    //   76	158	1353	finally
    //   205	280	1353	finally
    //   76	158	1367	java/lang/Throwable
    //   205	280	1367	java/lang/Throwable
    //   280	287	1367	java/lang/Throwable
    //   61	71	1553	finally
    //   61	71	1567	java/lang/Throwable
    //   1584	1589	2042	finally
    //   287	297	2214	java/lang/Exception
    //   297	326	2214	java/lang/Exception
    //   331	337	2214	java/lang/Exception
    //   345	356	2214	java/lang/Exception
    //   607	648	2219	finally
    //   607	648	2228	java/lang/Throwable
    //   532	540	2250	finally
    //   556	582	2250	finally
    //   598	607	2250	finally
    //   664	676	2250	finally
    //   692	701	2250	finally
    //   717	725	2250	finally
    //   741	749	2250	finally
    //   765	773	2250	finally
    //   789	797	2250	finally
    //   813	824	2250	finally
    //   848	855	2250	finally
    //   532	540	2273	java/lang/Throwable
    //   556	582	2273	java/lang/Throwable
    //   598	607	2273	java/lang/Throwable
    //   664	676	2273	java/lang/Throwable
    //   692	701	2273	java/lang/Throwable
    //   717	725	2273	java/lang/Throwable
    //   741	749	2273	java/lang/Throwable
    //   765	773	2273	java/lang/Throwable
    //   789	797	2273	java/lang/Throwable
    //   813	824	2273	java/lang/Throwable
    //   848	855	2273	java/lang/Throwable
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.NearByFaceDownloader
 * JD-Core Version:    0.7.0.1
 */