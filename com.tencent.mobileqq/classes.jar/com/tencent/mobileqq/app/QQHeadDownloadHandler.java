package com.tencent.mobileqq.app;

import amph;
import mqq.os.MqqHandler;

public class QQHeadDownloadHandler
  extends FaceDownloader
{
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  private static final int[] jdField_a_of_type_ArrayOfInt = { 2130840212, 2130849565, 2130849566, 2130849567 };
  private FriendListHandler jdField_a_of_type_ComTencentMobileqqAppFriendListHandler;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private MqqHandler b = new MqqHandler(ThreadManager.getSubThreadLooper());
  
  public QQHeadDownloadHandler(QQAppInterface paramQQAppInterface, FriendListHandler paramFriendListHandler)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler = paramFriendListHandler;
  }
  
  /* Error */
  private void a(int paramInt, java.io.File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 4
    //   6: iload_1
    //   7: iflt +13 -> 20
    //   10: iload_1
    //   11: istore_3
    //   12: iload_1
    //   13: getstatic 19	com/tencent/mobileqq/app/QQHeadDownloadHandler:jdField_a_of_type_ArrayOfInt	[I
    //   16: arraylength
    //   17: if_icmplt +5 -> 22
    //   20: iconst_0
    //   21: istore_3
    //   22: aload_0
    //   23: getfield 46	com/tencent/mobileqq/app/QQHeadDownloadHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   26: invokevirtual 59	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   29: invokevirtual 65	mqq/app/MobileQQ:getResources	()Landroid/content/res/Resources;
    //   32: getstatic 19	com/tencent/mobileqq/app/QQHeadDownloadHandler:jdField_a_of_type_ArrayOfInt	[I
    //   35: iload_3
    //   36: iaload
    //   37: invokevirtual 71	android/content/res/Resources:openRawResource	(I)Ljava/io/InputStream;
    //   40: astore 6
    //   42: aload 6
    //   44: astore 4
    //   46: sipush 512
    //   49: newarray byte
    //   51: astore 6
    //   53: new 73	java/io/FileOutputStream
    //   56: dup
    //   57: aload_2
    //   58: invokespecial 76	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   61: astore_2
    //   62: aload 4
    //   64: aload 6
    //   66: invokevirtual 82	java/io/InputStream:read	([B)I
    //   69: istore_1
    //   70: iload_1
    //   71: ifle +51 -> 122
    //   74: aload_2
    //   75: aload 6
    //   77: iconst_0
    //   78: iload_1
    //   79: invokevirtual 86	java/io/FileOutputStream:write	([BII)V
    //   82: goto -20 -> 62
    //   85: astore 5
    //   87: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   90: ifeq +13 -> 103
    //   93: ldc 94
    //   95: iconst_2
    //   96: ldc 96
    //   98: aload 5
    //   100: invokestatic 100	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   103: aload_2
    //   104: ifnull +7 -> 111
    //   107: aload_2
    //   108: invokevirtual 103	java/io/FileOutputStream:close	()V
    //   111: aload 4
    //   113: ifnull +8 -> 121
    //   116: aload 4
    //   118: invokevirtual 104	java/io/InputStream:close	()V
    //   121: return
    //   122: aload_2
    //   123: ifnull +7 -> 130
    //   126: aload_2
    //   127: invokevirtual 103	java/io/FileOutputStream:close	()V
    //   130: aload 4
    //   132: ifnull -11 -> 121
    //   135: aload 4
    //   137: invokevirtual 104	java/io/InputStream:close	()V
    //   140: return
    //   141: astore_2
    //   142: aconst_null
    //   143: astore 4
    //   145: aload 5
    //   147: ifnull +8 -> 155
    //   150: aload 5
    //   152: invokevirtual 103	java/io/FileOutputStream:close	()V
    //   155: aload 4
    //   157: ifnull +8 -> 165
    //   160: aload 4
    //   162: invokevirtual 104	java/io/InputStream:close	()V
    //   165: aload_2
    //   166: athrow
    //   167: astore_2
    //   168: goto -23 -> 145
    //   171: astore 6
    //   173: aload_2
    //   174: astore 5
    //   176: aload 6
    //   178: astore_2
    //   179: goto -34 -> 145
    //   182: astore 6
    //   184: aload_2
    //   185: astore 5
    //   187: aload 6
    //   189: astore_2
    //   190: goto -45 -> 145
    //   193: astore 5
    //   195: aconst_null
    //   196: astore_2
    //   197: goto -110 -> 87
    //   200: astore 5
    //   202: aconst_null
    //   203: astore_2
    //   204: goto -117 -> 87
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	207	0	this	QQHeadDownloadHandler
    //   0	207	1	paramInt	int
    //   0	207	2	paramFile	java.io.File
    //   11	25	3	i	int
    //   4	157	4	localObject1	Object
    //   1	1	5	localObject2	Object
    //   85	66	5	localException1	java.lang.Exception
    //   174	12	5	localFile	java.io.File
    //   193	1	5	localException2	java.lang.Exception
    //   200	1	5	localException3	java.lang.Exception
    //   40	36	6	localObject3	Object
    //   171	6	6	localObject4	Object
    //   182	6	6	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   62	70	85	java/lang/Exception
    //   74	82	85	java/lang/Exception
    //   22	42	141	finally
    //   46	62	167	finally
    //   62	70	171	finally
    //   74	82	171	finally
    //   87	103	182	finally
    //   22	42	193	java/lang/Exception
    //   46	62	200	java/lang/Exception
  }
  
  public static void b() {}
  
  public String a()
  {
    return amph.a(0);
  }
  
  public String b()
  {
    return amph.a(1);
  }
  
  /* Error */
  protected void b(com.tencent.mobileqq.util.FaceInfo paramFaceInfo)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 118	com/tencent/mobileqq/util/FaceInfo:a	LAvatarInfo/QQHeadInfo;
    //   4: astore 47
    //   6: aload_0
    //   7: getfield 48	com/tencent/mobileqq/app/QQHeadDownloadHandler:jdField_a_of_type_ComTencentMobileqqAppFriendListHandler	Lcom/tencent/mobileqq/app/FriendListHandler;
    //   10: aload 47
    //   12: getfield 124	AvatarInfo/QQHeadInfo:uin	J
    //   15: aload 47
    //   17: getfield 128	AvatarInfo/QQHeadInfo:phoneNum	Ljava/lang/String;
    //   20: invokevirtual 133	com/tencent/mobileqq/app/FriendListHandler:a	(JLjava/lang/String;)Ljava/lang/String;
    //   23: astore 46
    //   25: aload_0
    //   26: getfield 48	com/tencent/mobileqq/app/QQHeadDownloadHandler:jdField_a_of_type_ComTencentMobileqqAppFriendListHandler	Lcom/tencent/mobileqq/app/FriendListHandler;
    //   29: iconst_0
    //   30: aload 46
    //   32: aload 47
    //   34: getfield 137	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   37: iconst_3
    //   38: invokevirtual 140	com/tencent/mobileqq/app/FriendListHandler:a	(ILjava/lang/String;II)V
    //   41: aload_1
    //   42: getstatic 144	com/tencent/mobileqq/util/FaceInfo:n	I
    //   45: invokevirtual 147	com/tencent/mobileqq/util/FaceInfo:a	(I)V
    //   48: iconst_0
    //   49: istore 28
    //   51: iconst_0
    //   52: istore 27
    //   54: iconst_0
    //   55: istore 34
    //   57: iconst_0
    //   58: istore 35
    //   60: iconst_0
    //   61: istore 36
    //   63: iconst_0
    //   64: istore 33
    //   66: iconst_0
    //   67: istore 7
    //   69: iconst_0
    //   70: istore_3
    //   71: iconst_0
    //   72: istore 15
    //   74: iconst_0
    //   75: istore 16
    //   77: iconst_0
    //   78: istore 22
    //   80: iconst_0
    //   81: istore 17
    //   83: iconst_0
    //   84: istore 11
    //   86: aload 47
    //   88: getfield 150	AvatarInfo/QQHeadInfo:downLoadUrl	Ljava/lang/String;
    //   91: astore 44
    //   93: iconst_0
    //   94: istore 14
    //   96: iconst_0
    //   97: istore 10
    //   99: iconst_0
    //   100: istore 20
    //   102: iconst_0
    //   103: istore 23
    //   105: iconst_0
    //   106: istore 9
    //   108: iconst_0
    //   109: istore 24
    //   111: iconst_0
    //   112: istore 12
    //   114: iconst_0
    //   115: istore 8
    //   117: iconst_0
    //   118: istore 5
    //   120: iconst_0
    //   121: istore 18
    //   123: iconst_0
    //   124: istore 25
    //   126: iconst_0
    //   127: istore 21
    //   129: iconst_0
    //   130: istore_2
    //   131: iconst_0
    //   132: istore 26
    //   134: iconst_0
    //   135: istore 19
    //   137: iload 28
    //   139: istore 29
    //   141: iload 10
    //   143: istore 13
    //   145: iload 34
    //   147: istore 30
    //   149: iload 15
    //   151: istore 6
    //   153: aload 44
    //   155: astore 42
    //   157: iload 25
    //   159: istore 4
    //   161: aload 47
    //   163: getfield 150	AvatarInfo/QQHeadInfo:downLoadUrl	Ljava/lang/String;
    //   166: invokestatic 156	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   169: ifne +4904 -> 5073
    //   172: iload 28
    //   174: istore 29
    //   176: iload 10
    //   178: istore 13
    //   180: iload 34
    //   182: istore 30
    //   184: iload 15
    //   186: istore 6
    //   188: aload 44
    //   190: astore 42
    //   192: iload 25
    //   194: istore 4
    //   196: aload 47
    //   198: getfield 137	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   201: iconst_4
    //   202: if_icmpne +2170 -> 2372
    //   205: iload 28
    //   207: istore 29
    //   209: iload 10
    //   211: istore 13
    //   213: iload 34
    //   215: istore 30
    //   217: iload 15
    //   219: istore 6
    //   221: aload 44
    //   223: astore 42
    //   225: iload 25
    //   227: istore 4
    //   229: new 158	java/lang/StringBuilder
    //   232: dup
    //   233: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   236: ldc 161
    //   238: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: aload 46
    //   243: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   249: astore 41
    //   251: iload 28
    //   253: istore 29
    //   255: iload 10
    //   257: istore 13
    //   259: iload 34
    //   261: istore 30
    //   263: iload 15
    //   265: istore 6
    //   267: aload 44
    //   269: astore 42
    //   271: iload 25
    //   273: istore 4
    //   275: aload_0
    //   276: getfield 46	com/tencent/mobileqq/app/QQHeadDownloadHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   279: aload 41
    //   281: invokevirtual 172	com/tencent/mobileqq/app/QQAppInterface:c	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Setting;
    //   284: astore 45
    //   286: aload 45
    //   288: ifnonnull +4775 -> 5063
    //   291: iload 28
    //   293: istore 29
    //   295: iload 10
    //   297: istore 13
    //   299: iload 34
    //   301: istore 30
    //   303: iload 15
    //   305: istore 6
    //   307: aload 44
    //   309: astore 42
    //   311: iload 25
    //   313: istore 4
    //   315: new 174	com/tencent/mobileqq/data/Setting
    //   318: dup
    //   319: invokespecial 175	com/tencent/mobileqq/data/Setting:<init>	()V
    //   322: astore 45
    //   324: iload 28
    //   326: istore 29
    //   328: iload 10
    //   330: istore 13
    //   332: iload 34
    //   334: istore 30
    //   336: iload 15
    //   338: istore 6
    //   340: aload 44
    //   342: astore 42
    //   344: iload 25
    //   346: istore 4
    //   348: aload 45
    //   350: aload 41
    //   352: putfield 177	com/tencent/mobileqq/data/Setting:uin	Ljava/lang/String;
    //   355: iconst_1
    //   356: istore 27
    //   358: iload 27
    //   360: istore 29
    //   362: iload 10
    //   364: istore 13
    //   366: iload 34
    //   368: istore 30
    //   370: iload 15
    //   372: istore 6
    //   374: aload 44
    //   376: astore 42
    //   378: iload 25
    //   380: istore 4
    //   382: aload 45
    //   384: aload 47
    //   386: getfield 180	AvatarInfo/QQHeadInfo:dwFaceFlgas	B
    //   389: putfield 183	com/tencent/mobileqq/data/Setting:bFaceFlags	B
    //   392: iload 27
    //   394: istore 29
    //   396: iload 10
    //   398: istore 13
    //   400: iload 34
    //   402: istore 30
    //   404: iload 15
    //   406: istore 6
    //   408: aload 44
    //   410: astore 42
    //   412: iload 25
    //   414: istore 4
    //   416: aload 45
    //   418: aload 47
    //   420: getfield 137	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   423: putfield 186	com/tencent/mobileqq/data/Setting:bUsrType	B
    //   426: iload 27
    //   428: istore 29
    //   430: iload 10
    //   432: istore 13
    //   434: iload 34
    //   436: istore 30
    //   438: iload 15
    //   440: istore 6
    //   442: aload 44
    //   444: astore 42
    //   446: iload 25
    //   448: istore 4
    //   450: aload 45
    //   452: aload 47
    //   454: getfield 150	AvatarInfo/QQHeadInfo:downLoadUrl	Ljava/lang/String;
    //   457: putfield 189	com/tencent/mobileqq/data/Setting:url	Ljava/lang/String;
    //   460: iload 27
    //   462: istore 29
    //   464: iload 10
    //   466: istore 13
    //   468: iload 34
    //   470: istore 30
    //   472: iload 15
    //   474: istore 6
    //   476: aload 44
    //   478: astore 42
    //   480: iload 25
    //   482: istore 4
    //   484: aload 45
    //   486: invokestatic 195	java/lang/System:currentTimeMillis	()J
    //   489: putfield 198	com/tencent/mobileqq/data/Setting:updateTimestamp	J
    //   492: iload 27
    //   494: istore 29
    //   496: iload 10
    //   498: istore 13
    //   500: iload 34
    //   502: istore 30
    //   504: iload 15
    //   506: istore 6
    //   508: aload 44
    //   510: astore 42
    //   512: iload 25
    //   514: istore 4
    //   516: aload 47
    //   518: getfield 201	AvatarInfo/QQHeadInfo:cHeadType	B
    //   521: ifne +2053 -> 2574
    //   524: iload 27
    //   526: istore 29
    //   528: iload 10
    //   530: istore 13
    //   532: iload 34
    //   534: istore 30
    //   536: iload 15
    //   538: istore 6
    //   540: aload 44
    //   542: astore 42
    //   544: iload 25
    //   546: istore 4
    //   548: aload 45
    //   550: iconst_0
    //   551: putfield 204	com/tencent/mobileqq/data/Setting:bSourceType	B
    //   554: iload 27
    //   556: istore 28
    //   558: iload 27
    //   560: ifne +294 -> 854
    //   563: iload 27
    //   565: istore 29
    //   567: iload 10
    //   569: istore 13
    //   571: iload 34
    //   573: istore 30
    //   575: iload 15
    //   577: istore 6
    //   579: aload 44
    //   581: astore 42
    //   583: iload 25
    //   585: istore 4
    //   587: aload 45
    //   589: getfield 207	com/tencent/mobileqq/data/Setting:bHeadType	B
    //   592: aload 47
    //   594: getfield 201	AvatarInfo/QQHeadInfo:cHeadType	B
    //   597: if_icmpeq +2213 -> 2810
    //   600: iconst_1
    //   601: istore 27
    //   603: iload 27
    //   605: istore 28
    //   607: iload 27
    //   609: istore 29
    //   611: iload 10
    //   613: istore 13
    //   615: iload 34
    //   617: istore 30
    //   619: iload 15
    //   621: istore 6
    //   623: aload 44
    //   625: astore 42
    //   627: iload 25
    //   629: istore 4
    //   631: aload 47
    //   633: getfield 137	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   636: bipush 32
    //   638: if_icmpeq +216 -> 854
    //   641: iload 27
    //   643: istore 28
    //   645: iload 27
    //   647: ifeq +207 -> 854
    //   650: iload 27
    //   652: istore 28
    //   654: iload 27
    //   656: istore 29
    //   658: iload 10
    //   660: istore 13
    //   662: iload 34
    //   664: istore 30
    //   666: iload 15
    //   668: istore 6
    //   670: aload 44
    //   672: astore 42
    //   674: iload 25
    //   676: istore 4
    //   678: aload 45
    //   680: getfield 207	com/tencent/mobileqq/data/Setting:bHeadType	B
    //   683: iconst_1
    //   684: if_icmpne +170 -> 854
    //   687: iload 27
    //   689: istore 28
    //   691: iload 27
    //   693: istore 29
    //   695: iload 10
    //   697: istore 13
    //   699: iload 34
    //   701: istore 30
    //   703: iload 15
    //   705: istore 6
    //   707: aload 44
    //   709: astore 42
    //   711: iload 25
    //   713: istore 4
    //   715: aload 47
    //   717: getfield 201	AvatarInfo/QQHeadInfo:cHeadType	B
    //   720: ifne +134 -> 854
    //   723: iload 27
    //   725: istore 29
    //   727: iload 10
    //   729: istore 13
    //   731: iload 34
    //   733: istore 30
    //   735: iload 15
    //   737: istore 6
    //   739: aload 44
    //   741: astore 42
    //   743: iload 25
    //   745: istore 4
    //   747: new 209	java/io/File
    //   750: dup
    //   751: aload_0
    //   752: getfield 46	com/tencent/mobileqq/app/QQHeadDownloadHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   755: aload 45
    //   757: getfield 186	com/tencent/mobileqq/data/Setting:bUsrType	B
    //   760: aload 46
    //   762: aload 47
    //   764: getfield 212	AvatarInfo/QQHeadInfo:idType	I
    //   767: invokevirtual 215	com/tencent/mobileqq/app/QQAppInterface:a	(ILjava/lang/String;I)Ljava/lang/String;
    //   770: invokespecial 218	java/io/File:<init>	(Ljava/lang/String;)V
    //   773: astore 41
    //   775: iload 27
    //   777: istore 28
    //   779: aload 41
    //   781: ifnull +73 -> 854
    //   784: iload 27
    //   786: istore 28
    //   788: iload 27
    //   790: istore 29
    //   792: iload 10
    //   794: istore 13
    //   796: iload 34
    //   798: istore 30
    //   800: iload 15
    //   802: istore 6
    //   804: aload 44
    //   806: astore 42
    //   808: iload 25
    //   810: istore 4
    //   812: aload 41
    //   814: invokevirtual 221	java/io/File:exists	()Z
    //   817: ifeq +37 -> 854
    //   820: iload 27
    //   822: istore 29
    //   824: iload 10
    //   826: istore 13
    //   828: iload 34
    //   830: istore 30
    //   832: iload 15
    //   834: istore 6
    //   836: aload 44
    //   838: astore 42
    //   840: iload 25
    //   842: istore 4
    //   844: aload 41
    //   846: invokevirtual 224	java/io/File:delete	()Z
    //   849: pop
    //   850: iload 27
    //   852: istore 28
    //   854: iload 28
    //   856: istore 29
    //   858: iload 10
    //   860: istore 13
    //   862: iload 34
    //   864: istore 30
    //   866: iload 15
    //   868: istore 6
    //   870: aload 44
    //   872: astore 42
    //   874: iload 25
    //   876: istore 4
    //   878: aload 45
    //   880: aload 47
    //   882: getfield 201	AvatarInfo/QQHeadInfo:cHeadType	B
    //   885: putfield 207	com/tencent/mobileqq/data/Setting:bHeadType	B
    //   888: iload 28
    //   890: istore 29
    //   892: iload 10
    //   894: istore 13
    //   896: iload 34
    //   898: istore 30
    //   900: iload 15
    //   902: istore 6
    //   904: aload 44
    //   906: astore 42
    //   908: iload 25
    //   910: istore 4
    //   912: aload 45
    //   914: aload 47
    //   916: getfield 228	AvatarInfo/QQHeadInfo:systemHeadID	S
    //   919: putfield 229	com/tencent/mobileqq/data/Setting:systemHeadID	S
    //   922: iload 28
    //   924: istore 29
    //   926: iload 10
    //   928: istore 13
    //   930: iload 34
    //   932: istore 30
    //   934: iload 15
    //   936: istore 6
    //   938: aload 44
    //   940: astore 42
    //   942: iload 25
    //   944: istore 4
    //   946: aload 45
    //   948: aload 47
    //   950: getfield 232	AvatarInfo/QQHeadInfo:dwTimestamp	J
    //   953: putfield 235	com/tencent/mobileqq/data/Setting:headImgTimestamp	J
    //   956: iload 28
    //   958: istore 29
    //   960: iload 10
    //   962: istore 13
    //   964: iload 34
    //   966: istore 30
    //   968: iload 15
    //   970: istore 6
    //   972: aload 44
    //   974: astore 42
    //   976: iload 25
    //   978: istore 4
    //   980: aload_0
    //   981: getfield 46	com/tencent/mobileqq/app/QQHeadDownloadHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   984: invokevirtual 239	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   987: invokevirtual 245	com/tencent/qphone/base/util/BaseApplication:getApplicationContext	()Landroid/content/Context;
    //   990: invokestatic 250	bbck:a	(Landroid/content/Context;)Z
    //   993: ifeq +143 -> 1136
    //   996: iload 28
    //   998: istore 29
    //   1000: iload 10
    //   1002: istore 13
    //   1004: iload 34
    //   1006: istore 30
    //   1008: iload 15
    //   1010: istore 6
    //   1012: aload 44
    //   1014: astore 42
    //   1016: iload 25
    //   1018: istore 4
    //   1020: invokestatic 254	bbay:a	()Z
    //   1023: ifeq +113 -> 1136
    //   1026: iload 28
    //   1028: istore 29
    //   1030: iload 10
    //   1032: istore 13
    //   1034: iload 34
    //   1036: istore 30
    //   1038: iload 15
    //   1040: istore 6
    //   1042: aload 44
    //   1044: astore 42
    //   1046: iload 25
    //   1048: istore 4
    //   1050: getstatic 26	com/tencent/mobileqq/app/QQHeadDownloadHandler:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   1053: astore 41
    //   1055: iload 28
    //   1057: istore 29
    //   1059: iload 10
    //   1061: istore 13
    //   1063: iload 34
    //   1065: istore 30
    //   1067: iload 15
    //   1069: istore 6
    //   1071: aload 44
    //   1073: astore 42
    //   1075: iload 25
    //   1077: istore 4
    //   1079: aload 41
    //   1081: monitorenter
    //   1082: aload_0
    //   1083: getfield 46	com/tencent/mobileqq/app/QQHeadDownloadHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1086: invokevirtual 239	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1089: invokevirtual 245	com/tencent/qphone/base/util/BaseApplication:getApplicationContext	()Landroid/content/Context;
    //   1092: invokestatic 250	bbck:a	(Landroid/content/Context;)Z
    //   1095: ifeq +24 -> 1119
    //   1098: invokestatic 254	bbay:a	()Z
    //   1101: istore 27
    //   1103: iload 27
    //   1105: ifeq +14 -> 1119
    //   1108: ldc_w 256
    //   1111: getstatic 261	ajsf:bH	Ljava/lang/String;
    //   1114: iconst_1
    //   1115: invokestatic 266	bbdj:a	(Ljava/lang/String;Ljava/lang/String;Z)I
    //   1118: pop
    //   1119: aload_0
    //   1120: getfield 46	com/tencent/mobileqq/app/QQHeadDownloadHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1123: invokevirtual 239	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1126: invokevirtual 245	com/tencent/qphone/base/util/BaseApplication:getApplicationContext	()Landroid/content/Context;
    //   1129: iconst_0
    //   1130: invokestatic 269	bbck:a	(Landroid/content/Context;Z)V
    //   1133: aload 41
    //   1135: monitorexit
    //   1136: iload 28
    //   1138: istore 29
    //   1140: iload 10
    //   1142: istore 13
    //   1144: iload 34
    //   1146: istore 30
    //   1148: iload 15
    //   1150: istore 6
    //   1152: aload 44
    //   1154: astore 42
    //   1156: iload 25
    //   1158: istore 4
    //   1160: aload_0
    //   1161: getfield 46	com/tencent/mobileqq/app/QQHeadDownloadHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1164: aload 45
    //   1166: aload 47
    //   1168: getfield 212	AvatarInfo/QQHeadInfo:idType	I
    //   1171: invokevirtual 272	com/tencent/mobileqq/app/QQAppInterface:a	(Lcom/tencent/mobileqq/data/Setting;I)Ljava/lang/String;
    //   1174: astore 41
    //   1176: iload 10
    //   1178: istore 13
    //   1180: iload 34
    //   1182: istore 30
    //   1184: iload 15
    //   1186: istore 6
    //   1188: aload 44
    //   1190: astore 42
    //   1192: iload 25
    //   1194: istore 4
    //   1196: iload 28
    //   1198: istore 32
    //   1200: iload 12
    //   1202: istore 14
    //   1204: iload 36
    //   1206: istore 31
    //   1208: iload 17
    //   1210: istore 7
    //   1212: aload 44
    //   1214: astore 43
    //   1216: iload 26
    //   1218: istore 5
    //   1220: new 209	java/io/File
    //   1223: dup
    //   1224: aload 41
    //   1226: iconst_0
    //   1227: aload 41
    //   1229: ldc_w 274
    //   1232: invokevirtual 280	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   1235: invokevirtual 284	java/lang/String:substring	(II)Ljava/lang/String;
    //   1238: invokespecial 218	java/io/File:<init>	(Ljava/lang/String;)V
    //   1241: astore 48
    //   1243: aload 48
    //   1245: ifnull +105 -> 1350
    //   1248: iload 10
    //   1250: istore 13
    //   1252: iload 34
    //   1254: istore 30
    //   1256: iload 15
    //   1258: istore 6
    //   1260: aload 44
    //   1262: astore 42
    //   1264: iload 25
    //   1266: istore 4
    //   1268: iload 28
    //   1270: istore 32
    //   1272: iload 12
    //   1274: istore 14
    //   1276: iload 36
    //   1278: istore 31
    //   1280: iload 17
    //   1282: istore 7
    //   1284: aload 44
    //   1286: astore 43
    //   1288: iload 26
    //   1290: istore 5
    //   1292: aload 48
    //   1294: invokevirtual 221	java/io/File:exists	()Z
    //   1297: ifne +53 -> 1350
    //   1300: iload 10
    //   1302: istore 13
    //   1304: iload 34
    //   1306: istore 30
    //   1308: iload 15
    //   1310: istore 6
    //   1312: aload 44
    //   1314: astore 42
    //   1316: iload 25
    //   1318: istore 4
    //   1320: iload 28
    //   1322: istore 32
    //   1324: iload 12
    //   1326: istore 14
    //   1328: iload 36
    //   1330: istore 31
    //   1332: iload 17
    //   1334: istore 7
    //   1336: aload 44
    //   1338: astore 43
    //   1340: iload 26
    //   1342: istore 5
    //   1344: aload 48
    //   1346: invokevirtual 287	java/io/File:mkdirs	()Z
    //   1349: pop
    //   1350: iload 10
    //   1352: istore 13
    //   1354: iload 34
    //   1356: istore 30
    //   1358: iload 15
    //   1360: istore 6
    //   1362: aload 44
    //   1364: astore 42
    //   1366: iload 25
    //   1368: istore 4
    //   1370: iload 28
    //   1372: istore 32
    //   1374: iload 12
    //   1376: istore 14
    //   1378: iload 36
    //   1380: istore 31
    //   1382: iload 17
    //   1384: istore 7
    //   1386: aload 44
    //   1388: astore 43
    //   1390: iload 26
    //   1392: istore 5
    //   1394: new 209	java/io/File
    //   1397: dup
    //   1398: aload 41
    //   1400: invokespecial 218	java/io/File:<init>	(Ljava/lang/String;)V
    //   1403: astore 48
    //   1405: iload 28
    //   1407: istore 27
    //   1409: iload 28
    //   1411: ifne +62 -> 1473
    //   1414: iload 10
    //   1416: istore 13
    //   1418: iload 34
    //   1420: istore 30
    //   1422: iload 15
    //   1424: istore 6
    //   1426: aload 44
    //   1428: astore 42
    //   1430: iload 25
    //   1432: istore 4
    //   1434: iload 28
    //   1436: istore 32
    //   1438: iload 12
    //   1440: istore 14
    //   1442: iload 36
    //   1444: istore 31
    //   1446: iload 17
    //   1448: istore 7
    //   1450: aload 44
    //   1452: astore 43
    //   1454: iload 26
    //   1456: istore 5
    //   1458: aload 48
    //   1460: invokevirtual 221	java/io/File:exists	()Z
    //   1463: istore 27
    //   1465: iload 27
    //   1467: ifne +1630 -> 3097
    //   1470: iconst_1
    //   1471: istore 27
    //   1473: iload 27
    //   1475: ifeq +2464 -> 3939
    //   1478: iload 10
    //   1480: istore 13
    //   1482: iload 34
    //   1484: istore 30
    //   1486: iload 15
    //   1488: istore 6
    //   1490: aload 44
    //   1492: astore 42
    //   1494: iload 25
    //   1496: istore 4
    //   1498: iload 27
    //   1500: istore 32
    //   1502: iload 12
    //   1504: istore 14
    //   1506: iload 36
    //   1508: istore 31
    //   1510: iload 17
    //   1512: istore 7
    //   1514: aload 44
    //   1516: astore 43
    //   1518: iload 26
    //   1520: istore 5
    //   1522: aload_0
    //   1523: aload 47
    //   1525: getfield 150	AvatarInfo/QQHeadInfo:downLoadUrl	Ljava/lang/String;
    //   1528: aload 47
    //   1530: getfield 180	AvatarInfo/QQHeadInfo:dwFaceFlgas	B
    //   1533: aload 47
    //   1535: getfield 137	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   1538: aload 47
    //   1540: getfield 290	AvatarInfo/QQHeadInfo:originUsrType	I
    //   1543: invokevirtual 293	com/tencent/mobileqq/app/QQHeadDownloadHandler:a	(Ljava/lang/String;BBI)Ljava/lang/String;
    //   1546: astore 44
    //   1548: iload 10
    //   1550: istore 13
    //   1552: iload 34
    //   1554: istore 30
    //   1556: iload 15
    //   1558: istore 6
    //   1560: aload 44
    //   1562: astore 42
    //   1564: iload 25
    //   1566: istore 4
    //   1568: iload 27
    //   1570: istore 32
    //   1572: iload 12
    //   1574: istore 14
    //   1576: iload 36
    //   1578: istore 31
    //   1580: iload 17
    //   1582: istore 7
    //   1584: aload 44
    //   1586: astore 43
    //   1588: iload 26
    //   1590: istore 5
    //   1592: ldc_w 295
    //   1595: aload 44
    //   1597: invokestatic 301	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:insertMtype	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1600: astore 44
    //   1602: iload 10
    //   1604: istore 13
    //   1606: iload 34
    //   1608: istore 30
    //   1610: iload 15
    //   1612: istore 6
    //   1614: aload 44
    //   1616: astore 42
    //   1618: iload 25
    //   1620: istore 4
    //   1622: iload 27
    //   1624: istore 32
    //   1626: iload 12
    //   1628: istore 14
    //   1630: iload 36
    //   1632: istore 31
    //   1634: iload 17
    //   1636: istore 7
    //   1638: aload 44
    //   1640: astore 43
    //   1642: iload 26
    //   1644: istore 5
    //   1646: new 158	java/lang/StringBuilder
    //   1649: dup
    //   1650: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   1653: aload 44
    //   1655: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1658: ldc_w 303
    //   1661: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1664: invokestatic 195	java/lang/System:currentTimeMillis	()J
    //   1667: invokevirtual 306	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1670: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1673: astore 44
    //   1675: aload 47
    //   1677: getfield 201	AvatarInfo/QQHeadInfo:cHeadType	B
    //   1680: ifne +1517 -> 3197
    //   1683: aload 47
    //   1685: getfield 137	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   1688: istore_2
    //   1689: iload_2
    //   1690: iconst_4
    //   1691: if_icmpne +1506 -> 3197
    //   1694: aload 48
    //   1696: invokevirtual 221	java/io/File:exists	()Z
    //   1699: ifne +14 -> 1713
    //   1702: aload_0
    //   1703: aload 47
    //   1705: getfield 228	AvatarInfo/QQHeadInfo:systemHeadID	S
    //   1708: aload 48
    //   1710: invokespecial 308	com/tencent/mobileqq/app/QQHeadDownloadHandler:a	(ILjava/io/File;)V
    //   1713: iconst_1
    //   1714: istore 29
    //   1716: aload 44
    //   1718: astore_1
    //   1719: iload 19
    //   1721: istore 12
    //   1723: iload 9
    //   1725: istore_2
    //   1726: iload 8
    //   1728: istore_3
    //   1729: iload_2
    //   1730: istore 15
    //   1732: iload 29
    //   1734: istore 28
    //   1736: iload 11
    //   1738: istore 9
    //   1740: aload_1
    //   1741: astore 44
    //   1743: iload 12
    //   1745: istore 10
    //   1747: iload 29
    //   1749: ifeq +3349 -> 5098
    //   1752: iload_2
    //   1753: istore 13
    //   1755: iload 29
    //   1757: istore 30
    //   1759: iload 11
    //   1761: istore 6
    //   1763: aload_1
    //   1764: astore 42
    //   1766: iload 12
    //   1768: istore 4
    //   1770: iload 27
    //   1772: istore 32
    //   1774: iload 8
    //   1776: istore 14
    //   1778: iload 29
    //   1780: istore 31
    //   1782: iload 11
    //   1784: istore 7
    //   1786: aload_1
    //   1787: astore 43
    //   1789: iload 12
    //   1791: istore 5
    //   1793: aload 47
    //   1795: getfield 137	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   1798: iconst_4
    //   1799: if_icmpne +1796 -> 3595
    //   1802: iload_2
    //   1803: istore 13
    //   1805: iload 29
    //   1807: istore 30
    //   1809: iload 11
    //   1811: istore 6
    //   1813: aload_1
    //   1814: astore 42
    //   1816: iload 12
    //   1818: istore 4
    //   1820: iload 27
    //   1822: istore 32
    //   1824: iload 8
    //   1826: istore 14
    //   1828: iload 29
    //   1830: istore 31
    //   1832: iload 11
    //   1834: istore 7
    //   1836: aload_1
    //   1837: astore 43
    //   1839: iload 12
    //   1841: istore 5
    //   1843: aload_0
    //   1844: getfield 46	com/tencent/mobileqq/app/QQHeadDownloadHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1847: iconst_4
    //   1848: aload 46
    //   1850: aload 47
    //   1852: getfield 212	AvatarInfo/QQHeadInfo:idType	I
    //   1855: invokevirtual 311	com/tencent/mobileqq/app/QQAppInterface:a	(ILjava/lang/String;I)V
    //   1858: iload 8
    //   1860: istore_3
    //   1861: iload_2
    //   1862: istore 15
    //   1864: iload 29
    //   1866: istore 28
    //   1868: iload 11
    //   1870: istore 9
    //   1872: aload_1
    //   1873: astore 44
    //   1875: iload 12
    //   1877: istore 10
    //   1879: goto +3219 -> 5098
    //   1882: iload 15
    //   1884: istore 13
    //   1886: iload 28
    //   1888: istore 30
    //   1890: iload 9
    //   1892: istore 6
    //   1894: aload 44
    //   1896: astore 42
    //   1898: iload 10
    //   1900: istore 4
    //   1902: iload 27
    //   1904: istore 32
    //   1906: iload_3
    //   1907: istore 14
    //   1909: iload 28
    //   1911: istore 31
    //   1913: iload 9
    //   1915: istore 7
    //   1917: aload 44
    //   1919: astore 43
    //   1921: iload 10
    //   1923: istore 5
    //   1925: aload 47
    //   1927: getfield 137	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   1930: bipush 11
    //   1932: if_icmpne +2144 -> 4076
    //   1935: iload 15
    //   1937: istore 13
    //   1939: iload 28
    //   1941: istore 30
    //   1943: iload 9
    //   1945: istore 6
    //   1947: aload 44
    //   1949: astore 42
    //   1951: iload 10
    //   1953: istore 4
    //   1955: iload 27
    //   1957: istore 32
    //   1959: iload_3
    //   1960: istore 14
    //   1962: iload 28
    //   1964: istore 31
    //   1966: iload 9
    //   1968: istore 7
    //   1970: aload 44
    //   1972: astore 43
    //   1974: iload 10
    //   1976: istore 5
    //   1978: aload_0
    //   1979: getfield 48	com/tencent/mobileqq/app/QQHeadDownloadHandler:jdField_a_of_type_ComTencentMobileqqAppFriendListHandler	Lcom/tencent/mobileqq/app/FriendListHandler;
    //   1982: bipush 39
    //   1984: iconst_1
    //   1985: iconst_1
    //   1986: anewarray 21	java/lang/Object
    //   1989: dup
    //   1990: iconst_0
    //   1991: aload 46
    //   1993: aastore
    //   1994: invokevirtual 315	com/tencent/mobileqq/app/FriendListHandler:notifyUI	(IZLjava/lang/Object;)V
    //   1997: iload_3
    //   1998: istore_2
    //   1999: iload 28
    //   2001: istore 29
    //   2003: aload 41
    //   2005: astore_1
    //   2006: iload 27
    //   2008: istore 28
    //   2010: iload 29
    //   2012: istore 27
    //   2014: new 317	com/tencent/mobileqq/app/QQHeadDownloadHandler$HeadCostStatRunnable
    //   2017: dup
    //   2018: aload_0
    //   2019: iload 15
    //   2021: aload 46
    //   2023: aload 47
    //   2025: getfield 212	AvatarInfo/QQHeadInfo:idType	I
    //   2028: aload 47
    //   2030: getfield 137	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   2033: iconst_4
    //   2034: iload 9
    //   2036: aload 44
    //   2038: iload 10
    //   2040: invokestatic 195	java/lang/System:currentTimeMillis	()J
    //   2043: invokespecial 320	com/tencent/mobileqq/app/QQHeadDownloadHandler$HeadCostStatRunnable:<init>	(Lcom/tencent/mobileqq/app/QQHeadDownloadHandler;ILjava/lang/String;IIIILjava/lang/String;IJ)V
    //   2046: aconst_null
    //   2047: iconst_0
    //   2048: invokestatic 324	com/tencent/mobileqq/app/ThreadManager:postImmediately	(Ljava/lang/Runnable;Lcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   2051: iload 15
    //   2053: istore_3
    //   2054: aload 44
    //   2056: astore 41
    //   2058: iload_2
    //   2059: istore 4
    //   2061: iload 27
    //   2063: istore 29
    //   2065: iload 28
    //   2067: istore 30
    //   2069: aload_1
    //   2070: astore 42
    //   2072: iload 27
    //   2074: ifne +107 -> 2181
    //   2077: aload_0
    //   2078: getfield 46	com/tencent/mobileqq/app/QQHeadDownloadHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2081: sipush 199
    //   2084: invokevirtual 328	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   2087: checkcast 330	akvr
    //   2090: astore 43
    //   2092: iload 15
    //   2094: istore_3
    //   2095: aload 44
    //   2097: astore 41
    //   2099: iload_2
    //   2100: istore 4
    //   2102: iload 27
    //   2104: istore 29
    //   2106: iload 28
    //   2108: istore 30
    //   2110: aload_1
    //   2111: astore 42
    //   2113: aload 43
    //   2115: ifnull +66 -> 2181
    //   2118: iload 15
    //   2120: istore_3
    //   2121: aload 44
    //   2123: astore 41
    //   2125: iload_2
    //   2126: istore 4
    //   2128: iload 27
    //   2130: istore 29
    //   2132: iload 28
    //   2134: istore 30
    //   2136: aload_1
    //   2137: astore 42
    //   2139: aload 43
    //   2141: invokevirtual 331	akvr:a	()Z
    //   2144: ifeq +37 -> 2181
    //   2147: aload 43
    //   2149: aload 47
    //   2151: getfield 124	AvatarInfo/QQHeadInfo:uin	J
    //   2154: invokestatic 335	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   2157: invokevirtual 337	akvr:a	(Ljava/lang/String;)V
    //   2160: aload_1
    //   2161: astore 42
    //   2163: iload 28
    //   2165: istore 30
    //   2167: iload 27
    //   2169: istore 29
    //   2171: iload_2
    //   2172: istore 4
    //   2174: aload 44
    //   2176: astore 41
    //   2178: iload 15
    //   2180: istore_3
    //   2181: ldc 94
    //   2183: iconst_2
    //   2184: new 158	java/lang/StringBuilder
    //   2187: dup
    //   2188: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   2191: ldc_w 339
    //   2194: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2197: iload 29
    //   2199: invokevirtual 342	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2202: ldc_w 344
    //   2205: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2208: iload_3
    //   2209: invokevirtual 347	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2212: ldc_w 349
    //   2215: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2218: aload 47
    //   2220: getfield 124	AvatarInfo/QQHeadInfo:uin	J
    //   2223: invokevirtual 306	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2226: ldc_w 351
    //   2229: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2232: iload 30
    //   2234: invokevirtual 342	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2237: ldc_w 353
    //   2240: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2243: aload 47
    //   2245: getfield 128	AvatarInfo/QQHeadInfo:phoneNum	Ljava/lang/String;
    //   2248: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2251: ldc_w 355
    //   2254: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2257: aload 47
    //   2259: getfield 201	AvatarInfo/QQHeadInfo:cHeadType	B
    //   2262: invokevirtual 347	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2265: ldc_w 357
    //   2268: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2271: aload 47
    //   2273: getfield 137	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   2276: invokevirtual 347	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2279: ldc_w 359
    //   2282: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2285: aload 47
    //   2287: getfield 228	AvatarInfo/QQHeadInfo:systemHeadID	S
    //   2290: invokevirtual 347	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2293: ldc_w 361
    //   2296: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2299: iload 4
    //   2301: invokevirtual 347	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2304: ldc_w 363
    //   2307: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2310: aload 47
    //   2312: getfield 232	AvatarInfo/QQHeadInfo:dwTimestamp	J
    //   2315: invokevirtual 306	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2318: ldc_w 365
    //   2321: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2324: aload 42
    //   2326: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2329: ldc_w 367
    //   2332: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2335: aload 41
    //   2337: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2340: ldc_w 369
    //   2343: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2346: aload 47
    //   2348: getfield 150	AvatarInfo/QQHeadInfo:downLoadUrl	Ljava/lang/String;
    //   2351: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2354: ldc_w 371
    //   2357: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2360: aload 47
    //   2362: invokevirtual 374	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2365: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2368: invokestatic 378	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2371: return
    //   2372: iload 28
    //   2374: istore 29
    //   2376: iload 10
    //   2378: istore 13
    //   2380: iload 34
    //   2382: istore 30
    //   2384: iload 15
    //   2386: istore 6
    //   2388: aload 44
    //   2390: astore 42
    //   2392: iload 25
    //   2394: istore 4
    //   2396: aload 47
    //   2398: getfield 137	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   2401: bipush 32
    //   2403: if_icmpne +70 -> 2473
    //   2406: iload 28
    //   2408: istore 29
    //   2410: iload 10
    //   2412: istore 13
    //   2414: iload 34
    //   2416: istore 30
    //   2418: iload 15
    //   2420: istore 6
    //   2422: aload 44
    //   2424: astore 42
    //   2426: iload 25
    //   2428: istore 4
    //   2430: new 158	java/lang/StringBuilder
    //   2433: dup
    //   2434: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   2437: ldc_w 380
    //   2440: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2443: aload 47
    //   2445: getfield 212	AvatarInfo/QQHeadInfo:idType	I
    //   2448: invokestatic 384	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   2451: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2454: ldc_w 386
    //   2457: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2460: aload 46
    //   2462: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2465: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2468: astore 41
    //   2470: goto -2219 -> 251
    //   2473: iload 28
    //   2475: istore 29
    //   2477: iload 10
    //   2479: istore 13
    //   2481: iload 34
    //   2483: istore 30
    //   2485: iload 15
    //   2487: istore 6
    //   2489: aload 44
    //   2491: astore 42
    //   2493: iload 25
    //   2495: istore 4
    //   2497: aload 47
    //   2499: getfield 137	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   2502: bipush 16
    //   2504: if_icmpne +2562 -> 5066
    //   2507: iload 28
    //   2509: istore 29
    //   2511: iload 10
    //   2513: istore 13
    //   2515: iload 34
    //   2517: istore 30
    //   2519: iload 15
    //   2521: istore 6
    //   2523: aload 44
    //   2525: astore 42
    //   2527: iload 25
    //   2529: istore 4
    //   2531: new 158	java/lang/StringBuilder
    //   2534: dup
    //   2535: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   2538: ldc_w 388
    //   2541: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2544: aload 47
    //   2546: getfield 212	AvatarInfo/QQHeadInfo:idType	I
    //   2549: invokestatic 384	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   2552: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2555: ldc_w 386
    //   2558: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2561: aload 46
    //   2563: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2566: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2569: astore 41
    //   2571: goto -2320 -> 251
    //   2574: iload 27
    //   2576: istore 29
    //   2578: iload 10
    //   2580: istore 13
    //   2582: iload 34
    //   2584: istore 30
    //   2586: iload 15
    //   2588: istore 6
    //   2590: aload 44
    //   2592: astore 42
    //   2594: iload 25
    //   2596: istore 4
    //   2598: aload 45
    //   2600: aload 47
    //   2602: getfield 391	AvatarInfo/QQHeadInfo:headLevel	B
    //   2605: putfield 204	com/tencent/mobileqq/data/Setting:bSourceType	B
    //   2608: goto -2054 -> 554
    //   2611: astore_1
    //   2612: iconst_0
    //   2613: istore_2
    //   2614: iconst_0
    //   2615: istore 27
    //   2617: iload 29
    //   2619: istore 28
    //   2621: aconst_null
    //   2622: astore_1
    //   2623: iload 18
    //   2625: istore 5
    //   2627: aload 44
    //   2629: astore 43
    //   2631: iload_3
    //   2632: istore 7
    //   2634: sipush 9204
    //   2637: istore 6
    //   2639: new 317	com/tencent/mobileqq/app/QQHeadDownloadHandler$HeadCostStatRunnable
    //   2642: dup
    //   2643: aload_0
    //   2644: sipush 9204
    //   2647: aload 46
    //   2649: aload 47
    //   2651: getfield 212	AvatarInfo/QQHeadInfo:idType	I
    //   2654: aload 47
    //   2656: getfield 137	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   2659: iconst_4
    //   2660: iload 7
    //   2662: aload 43
    //   2664: iload 5
    //   2666: invokestatic 195	java/lang/System:currentTimeMillis	()J
    //   2669: invokespecial 320	com/tencent/mobileqq/app/QQHeadDownloadHandler$HeadCostStatRunnable:<init>	(Lcom/tencent/mobileqq/app/QQHeadDownloadHandler;ILjava/lang/String;IIIILjava/lang/String;IJ)V
    //   2672: aconst_null
    //   2673: iconst_0
    //   2674: invokestatic 324	com/tencent/mobileqq/app/ThreadManager:postImmediately	(Ljava/lang/Runnable;Lcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   2677: iload 6
    //   2679: istore_3
    //   2680: aload 43
    //   2682: astore 41
    //   2684: iload_2
    //   2685: istore 4
    //   2687: iload 27
    //   2689: istore 29
    //   2691: iload 28
    //   2693: istore 30
    //   2695: aload_1
    //   2696: astore 42
    //   2698: iload 27
    //   2700: ifne -519 -> 2181
    //   2703: aload_0
    //   2704: getfield 46	com/tencent/mobileqq/app/QQHeadDownloadHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2707: sipush 199
    //   2710: invokevirtual 328	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   2713: checkcast 330	akvr
    //   2716: astore 44
    //   2718: iload 6
    //   2720: istore_3
    //   2721: aload 43
    //   2723: astore 41
    //   2725: iload_2
    //   2726: istore 4
    //   2728: iload 27
    //   2730: istore 29
    //   2732: iload 28
    //   2734: istore 30
    //   2736: aload_1
    //   2737: astore 42
    //   2739: aload 44
    //   2741: ifnull -560 -> 2181
    //   2744: iload 6
    //   2746: istore_3
    //   2747: aload 43
    //   2749: astore 41
    //   2751: iload_2
    //   2752: istore 4
    //   2754: iload 27
    //   2756: istore 29
    //   2758: iload 28
    //   2760: istore 30
    //   2762: aload_1
    //   2763: astore 42
    //   2765: aload 44
    //   2767: invokevirtual 331	akvr:a	()Z
    //   2770: ifeq -589 -> 2181
    //   2773: aload 44
    //   2775: aload 47
    //   2777: getfield 124	AvatarInfo/QQHeadInfo:uin	J
    //   2780: invokestatic 335	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   2783: invokevirtual 337	akvr:a	(Ljava/lang/String;)V
    //   2786: iload 6
    //   2788: istore_3
    //   2789: aload 43
    //   2791: astore 41
    //   2793: iload_2
    //   2794: istore 4
    //   2796: iload 27
    //   2798: istore 29
    //   2800: iload 28
    //   2802: istore 30
    //   2804: aload_1
    //   2805: astore 42
    //   2807: goto -626 -> 2181
    //   2810: iload 27
    //   2812: istore 29
    //   2814: iload 10
    //   2816: istore 13
    //   2818: iload 34
    //   2820: istore 30
    //   2822: iload 15
    //   2824: istore 6
    //   2826: aload 44
    //   2828: astore 42
    //   2830: iload 25
    //   2832: istore 4
    //   2834: aload 47
    //   2836: getfield 201	AvatarInfo/QQHeadInfo:cHeadType	B
    //   2839: ifne +46 -> 2885
    //   2842: iload 27
    //   2844: istore 29
    //   2846: iload 10
    //   2848: istore 13
    //   2850: iload 34
    //   2852: istore 30
    //   2854: iload 15
    //   2856: istore 6
    //   2858: aload 44
    //   2860: astore 42
    //   2862: iload 25
    //   2864: istore 4
    //   2866: aload 45
    //   2868: getfield 229	com/tencent/mobileqq/data/Setting:systemHeadID	S
    //   2871: aload 47
    //   2873: getfield 228	AvatarInfo/QQHeadInfo:systemHeadID	S
    //   2876: if_icmpeq +2235 -> 5111
    //   2879: iconst_1
    //   2880: istore 27
    //   2882: goto -2279 -> 603
    //   2885: iload 27
    //   2887: istore 29
    //   2889: iload 10
    //   2891: istore 13
    //   2893: iload 34
    //   2895: istore 30
    //   2897: iload 15
    //   2899: istore 6
    //   2901: aload 44
    //   2903: astore 42
    //   2905: iload 25
    //   2907: istore 4
    //   2909: aload 45
    //   2911: getfield 235	com/tencent/mobileqq/data/Setting:headImgTimestamp	J
    //   2914: lstore 37
    //   2916: iload 27
    //   2918: istore 29
    //   2920: iload 10
    //   2922: istore 13
    //   2924: iload 34
    //   2926: istore 30
    //   2928: iload 15
    //   2930: istore 6
    //   2932: aload 44
    //   2934: astore 42
    //   2936: iload 25
    //   2938: istore 4
    //   2940: aload 47
    //   2942: getfield 232	AvatarInfo/QQHeadInfo:dwTimestamp	J
    //   2945: lstore 39
    //   2947: lload 37
    //   2949: lload 39
    //   2951: lcmp
    //   2952: ifeq +9 -> 2961
    //   2955: iconst_1
    //   2956: istore 27
    //   2958: goto -2355 -> 603
    //   2961: iconst_0
    //   2962: istore 27
    //   2964: goto -2361 -> 603
    //   2967: astore 42
    //   2969: aload 42
    //   2971: invokevirtual 394	java/lang/Exception:printStackTrace	()V
    //   2974: goto -1855 -> 1119
    //   2977: astore_1
    //   2978: aload 41
    //   2980: monitorexit
    //   2981: iload 28
    //   2983: istore 29
    //   2985: iload 10
    //   2987: istore 13
    //   2989: iload 34
    //   2991: istore 30
    //   2993: iload 15
    //   2995: istore 6
    //   2997: aload 44
    //   2999: astore 42
    //   3001: iload 25
    //   3003: istore 4
    //   3005: aload_1
    //   3006: athrow
    //   3007: astore_1
    //   3008: iload 30
    //   3010: istore 27
    //   3012: new 317	com/tencent/mobileqq/app/QQHeadDownloadHandler$HeadCostStatRunnable
    //   3015: dup
    //   3016: aload_0
    //   3017: iload 13
    //   3019: aload 46
    //   3021: aload 47
    //   3023: getfield 212	AvatarInfo/QQHeadInfo:idType	I
    //   3026: aload 47
    //   3028: getfield 137	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   3031: iconst_4
    //   3032: iload 6
    //   3034: aload 42
    //   3036: iload 4
    //   3038: invokestatic 195	java/lang/System:currentTimeMillis	()J
    //   3041: invokespecial 320	com/tencent/mobileqq/app/QQHeadDownloadHandler$HeadCostStatRunnable:<init>	(Lcom/tencent/mobileqq/app/QQHeadDownloadHandler;ILjava/lang/String;IIIILjava/lang/String;IJ)V
    //   3044: aconst_null
    //   3045: iconst_0
    //   3046: invokestatic 324	com/tencent/mobileqq/app/ThreadManager:postImmediately	(Ljava/lang/Runnable;Lcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   3049: iload 27
    //   3051: ifne +44 -> 3095
    //   3054: aload_0
    //   3055: getfield 46	com/tencent/mobileqq/app/QQHeadDownloadHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3058: sipush 199
    //   3061: invokevirtual 328	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   3064: checkcast 330	akvr
    //   3067: astore 41
    //   3069: aload 41
    //   3071: ifnull +24 -> 3095
    //   3074: aload 41
    //   3076: invokevirtual 331	akvr:a	()Z
    //   3079: ifeq +16 -> 3095
    //   3082: aload 41
    //   3084: aload 47
    //   3086: getfield 124	AvatarInfo/QQHeadInfo:uin	J
    //   3089: invokestatic 335	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   3092: invokevirtual 337	akvr:a	(Ljava/lang/String;)V
    //   3095: aload_1
    //   3096: athrow
    //   3097: iconst_0
    //   3098: istore 27
    //   3100: goto -1627 -> 1473
    //   3103: astore_1
    //   3104: new 317	com/tencent/mobileqq/app/QQHeadDownloadHandler$HeadCostStatRunnable
    //   3107: dup
    //   3108: aload_0
    //   3109: sipush 9202
    //   3112: aload 46
    //   3114: aload 47
    //   3116: getfield 212	AvatarInfo/QQHeadInfo:idType	I
    //   3119: aload 47
    //   3121: getfield 137	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   3124: iconst_4
    //   3125: iconst_0
    //   3126: aload 44
    //   3128: iconst_0
    //   3129: invokestatic 195	java/lang/System:currentTimeMillis	()J
    //   3132: invokespecial 320	com/tencent/mobileqq/app/QQHeadDownloadHandler$HeadCostStatRunnable:<init>	(Lcom/tencent/mobileqq/app/QQHeadDownloadHandler;ILjava/lang/String;IIIILjava/lang/String;IJ)V
    //   3135: aconst_null
    //   3136: iconst_0
    //   3137: invokestatic 324	com/tencent/mobileqq/app/ThreadManager:postImmediately	(Ljava/lang/Runnable;Lcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   3140: aload_0
    //   3141: getfield 46	com/tencent/mobileqq/app/QQHeadDownloadHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3144: sipush 199
    //   3147: invokevirtual 328	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   3150: checkcast 330	akvr
    //   3153: astore_1
    //   3154: aload_1
    //   3155: ifnull -784 -> 2371
    //   3158: aload_1
    //   3159: invokevirtual 331	akvr:a	()Z
    //   3162: ifeq -791 -> 2371
    //   3165: aload_1
    //   3166: aload 47
    //   3168: getfield 124	AvatarInfo/QQHeadInfo:uin	J
    //   3171: invokestatic 335	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   3174: invokevirtual 337	akvr:a	(Ljava/lang/String;)V
    //   3177: return
    //   3178: astore_1
    //   3179: sipush 9202
    //   3182: istore_2
    //   3183: aload 44
    //   3185: astore_1
    //   3186: iload 33
    //   3188: istore 29
    //   3190: iload 19
    //   3192: istore 12
    //   3194: goto -1468 -> 1726
    //   3197: aload_0
    //   3198: aload 44
    //   3200: aload 48
    //   3202: aload_1
    //   3203: iconst_0
    //   3204: invokevirtual 397	com/tencent/mobileqq/app/QQHeadDownloadHandler:a	(Ljava/lang/String;Ljava/io/File;Lcom/tencent/mobileqq/util/FaceInfo;Z)I
    //   3207: istore_2
    //   3208: iload_2
    //   3209: ifeq +1849 -> 5058
    //   3212: iconst_1
    //   3213: invokestatic 403	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getActiveNetIpFamily	(Z)I
    //   3216: iconst_3
    //   3217: if_icmpne +1841 -> 5058
    //   3220: aload_0
    //   3221: aload 47
    //   3223: getfield 150	AvatarInfo/QQHeadInfo:downLoadUrl	Ljava/lang/String;
    //   3226: aload 47
    //   3228: getfield 180	AvatarInfo/QQHeadInfo:dwFaceFlgas	B
    //   3231: aload 47
    //   3233: getfield 137	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   3236: aload 47
    //   3238: getfield 290	AvatarInfo/QQHeadInfo:originUsrType	I
    //   3241: iconst_1
    //   3242: invokevirtual 406	com/tencent/mobileqq/app/QQHeadDownloadHandler:a	(Ljava/lang/String;BBIZ)Ljava/lang/String;
    //   3245: astore 42
    //   3247: aload 42
    //   3249: astore 44
    //   3251: aload 44
    //   3253: astore 42
    //   3255: aload 44
    //   3257: astore 43
    //   3259: ldc_w 295
    //   3262: aload 44
    //   3264: invokestatic 301	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:insertMtype	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   3267: astore 44
    //   3269: aload 44
    //   3271: astore 42
    //   3273: aload 44
    //   3275: astore 43
    //   3277: new 158	java/lang/StringBuilder
    //   3280: dup
    //   3281: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   3284: aload 44
    //   3286: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3289: ldc_w 303
    //   3292: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3295: invokestatic 195	java/lang/System:currentTimeMillis	()J
    //   3298: invokevirtual 306	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3301: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3304: astore 44
    //   3306: aload 44
    //   3308: astore 42
    //   3310: aload 44
    //   3312: astore 43
    //   3314: aload_0
    //   3315: aload 44
    //   3317: aload 48
    //   3319: aload_1
    //   3320: iconst_0
    //   3321: invokevirtual 397	com/tencent/mobileqq/app/QQHeadDownloadHandler:a	(Ljava/lang/String;Ljava/io/File;Lcom/tencent/mobileqq/util/FaceInfo;Z)I
    //   3324: istore 4
    //   3326: iload 4
    //   3328: istore_3
    //   3329: iload 10
    //   3331: istore 13
    //   3333: iload 34
    //   3335: istore 30
    //   3337: iload 15
    //   3339: istore 6
    //   3341: aload 44
    //   3343: astore 42
    //   3345: iload_3
    //   3346: istore 4
    //   3348: iload 27
    //   3350: istore 32
    //   3352: iload 12
    //   3354: istore 14
    //   3356: iload 36
    //   3358: istore 31
    //   3360: iload 17
    //   3362: istore 7
    //   3364: aload 44
    //   3366: astore 43
    //   3368: iload_3
    //   3369: istore 5
    //   3371: ldc 94
    //   3373: iconst_1
    //   3374: new 158	java/lang/StringBuilder
    //   3377: dup
    //   3378: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   3381: ldc_w 408
    //   3384: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3387: aload 44
    //   3389: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3392: ldc_w 410
    //   3395: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3398: iload_3
    //   3399: invokevirtual 347	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3402: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3405: invokestatic 378	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3408: iload_3
    //   3409: ifne +1726 -> 5135
    //   3412: iload 10
    //   3414: istore 13
    //   3416: iload 34
    //   3418: istore 30
    //   3420: iload 15
    //   3422: istore 6
    //   3424: aload 44
    //   3426: astore 42
    //   3428: iload_3
    //   3429: istore 4
    //   3431: iload 27
    //   3433: istore 32
    //   3435: iload 12
    //   3437: istore 14
    //   3439: iload 36
    //   3441: istore 31
    //   3443: iload 17
    //   3445: istore 7
    //   3447: aload 44
    //   3449: astore 43
    //   3451: iload_3
    //   3452: istore 5
    //   3454: aload 48
    //   3456: invokevirtual 413	java/io/File:length	()J
    //   3459: l2i
    //   3460: istore 11
    //   3462: iconst_1
    //   3463: istore 28
    //   3465: iconst_1
    //   3466: istore 33
    //   3468: iconst_1
    //   3469: istore 29
    //   3471: iload 10
    //   3473: istore 13
    //   3475: iload 28
    //   3477: istore 30
    //   3479: iload 11
    //   3481: istore 6
    //   3483: aload 44
    //   3485: astore 42
    //   3487: iload_3
    //   3488: istore 4
    //   3490: iload 27
    //   3492: istore 32
    //   3494: iload 12
    //   3496: istore 14
    //   3498: iload 33
    //   3500: istore 31
    //   3502: iload 11
    //   3504: istore 7
    //   3506: aload 44
    //   3508: astore 43
    //   3510: iload_3
    //   3511: istore 5
    //   3513: aload_0
    //   3514: getfield 46	com/tencent/mobileqq/app/QQHeadDownloadHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3517: aload 45
    //   3519: invokevirtual 416	com/tencent/mobileqq/app/QQAppInterface:a	(Lcom/tencent/mobileqq/data/Setting;)V
    //   3522: iload 10
    //   3524: istore 13
    //   3526: iload 28
    //   3528: istore 30
    //   3530: iload 11
    //   3532: istore 6
    //   3534: aload 44
    //   3536: astore 42
    //   3538: iload_3
    //   3539: istore 4
    //   3541: iload 27
    //   3543: istore 32
    //   3545: iload 12
    //   3547: istore 14
    //   3549: iload 33
    //   3551: istore 31
    //   3553: iload 11
    //   3555: istore 7
    //   3557: aload 44
    //   3559: astore 43
    //   3561: iload_3
    //   3562: istore 5
    //   3564: aload_0
    //   3565: getfield 44	com/tencent/mobileqq/app/QQHeadDownloadHandler:b	Lmqq/os/MqqHandler;
    //   3568: new 418	com/tencent/mobileqq/app/QQHeadDownloadHandler$UpdateSettingRunnable
    //   3571: dup
    //   3572: aload_0
    //   3573: aload 45
    //   3575: aload_1
    //   3576: invokespecial 421	com/tencent/mobileqq/app/QQHeadDownloadHandler$UpdateSettingRunnable:<init>	(Lcom/tencent/mobileqq/app/QQHeadDownloadHandler;Lcom/tencent/mobileqq/data/Setting;Lcom/tencent/mobileqq/util/FaceInfo;)V
    //   3579: invokevirtual 425	mqq/os/MqqHandler:postAtFrontOfQueue	(Ljava/lang/Runnable;)Z
    //   3582: pop
    //   3583: iload 9
    //   3585: istore_2
    //   3586: aload 44
    //   3588: astore_1
    //   3589: iload_3
    //   3590: istore 12
    //   3592: goto -1866 -> 1726
    //   3595: iload_2
    //   3596: istore 13
    //   3598: iload 29
    //   3600: istore 30
    //   3602: iload 11
    //   3604: istore 6
    //   3606: aload_1
    //   3607: astore 42
    //   3609: iload 12
    //   3611: istore 4
    //   3613: iload 27
    //   3615: istore 32
    //   3617: iload 8
    //   3619: istore 14
    //   3621: iload 29
    //   3623: istore 31
    //   3625: iload 11
    //   3627: istore 7
    //   3629: aload_1
    //   3630: astore 43
    //   3632: iload 12
    //   3634: istore 5
    //   3636: aload 47
    //   3638: getfield 137	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   3641: bipush 32
    //   3643: if_icmpne +84 -> 3727
    //   3646: iload_2
    //   3647: istore 13
    //   3649: iload 29
    //   3651: istore 30
    //   3653: iload 11
    //   3655: istore 6
    //   3657: aload_1
    //   3658: astore 42
    //   3660: iload 12
    //   3662: istore 4
    //   3664: iload 27
    //   3666: istore 32
    //   3668: iload 8
    //   3670: istore 14
    //   3672: iload 29
    //   3674: istore 31
    //   3676: iload 11
    //   3678: istore 7
    //   3680: aload_1
    //   3681: astore 43
    //   3683: iload 12
    //   3685: istore 5
    //   3687: aload_0
    //   3688: getfield 46	com/tencent/mobileqq/app/QQHeadDownloadHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3691: bipush 32
    //   3693: aload 46
    //   3695: aload 47
    //   3697: getfield 212	AvatarInfo/QQHeadInfo:idType	I
    //   3700: invokevirtual 311	com/tencent/mobileqq/app/QQAppInterface:a	(ILjava/lang/String;I)V
    //   3703: iload 8
    //   3705: istore_3
    //   3706: iload_2
    //   3707: istore 15
    //   3709: iload 29
    //   3711: istore 28
    //   3713: iload 11
    //   3715: istore 9
    //   3717: aload_1
    //   3718: astore 44
    //   3720: iload 12
    //   3722: istore 10
    //   3724: goto +1374 -> 5098
    //   3727: iload_2
    //   3728: istore 13
    //   3730: iload 29
    //   3732: istore 30
    //   3734: iload 11
    //   3736: istore 6
    //   3738: aload_1
    //   3739: astore 42
    //   3741: iload 12
    //   3743: istore 4
    //   3745: iload 27
    //   3747: istore 32
    //   3749: iload 8
    //   3751: istore 14
    //   3753: iload 29
    //   3755: istore 31
    //   3757: iload 11
    //   3759: istore 7
    //   3761: aload_1
    //   3762: astore 43
    //   3764: iload 12
    //   3766: istore 5
    //   3768: aload 47
    //   3770: getfield 137	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   3773: bipush 16
    //   3775: if_icmpne +84 -> 3859
    //   3778: iload_2
    //   3779: istore 13
    //   3781: iload 29
    //   3783: istore 30
    //   3785: iload 11
    //   3787: istore 6
    //   3789: aload_1
    //   3790: astore 42
    //   3792: iload 12
    //   3794: istore 4
    //   3796: iload 27
    //   3798: istore 32
    //   3800: iload 8
    //   3802: istore 14
    //   3804: iload 29
    //   3806: istore 31
    //   3808: iload 11
    //   3810: istore 7
    //   3812: aload_1
    //   3813: astore 43
    //   3815: iload 12
    //   3817: istore 5
    //   3819: aload_0
    //   3820: getfield 46	com/tencent/mobileqq/app/QQHeadDownloadHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3823: bipush 16
    //   3825: aload 46
    //   3827: aload 47
    //   3829: getfield 212	AvatarInfo/QQHeadInfo:idType	I
    //   3832: invokevirtual 311	com/tencent/mobileqq/app/QQAppInterface:a	(ILjava/lang/String;I)V
    //   3835: iload 8
    //   3837: istore_3
    //   3838: iload_2
    //   3839: istore 15
    //   3841: iload 29
    //   3843: istore 28
    //   3845: iload 11
    //   3847: istore 9
    //   3849: aload_1
    //   3850: astore 44
    //   3852: iload 12
    //   3854: istore 10
    //   3856: goto +1242 -> 5098
    //   3859: iload_2
    //   3860: istore 13
    //   3862: iload 29
    //   3864: istore 30
    //   3866: iload 11
    //   3868: istore 6
    //   3870: aload_1
    //   3871: astore 42
    //   3873: iload 12
    //   3875: istore 4
    //   3877: iload 27
    //   3879: istore 32
    //   3881: iload 8
    //   3883: istore 14
    //   3885: iload 29
    //   3887: istore 31
    //   3889: iload 11
    //   3891: istore 7
    //   3893: aload_1
    //   3894: astore 43
    //   3896: iload 12
    //   3898: istore 5
    //   3900: aload_0
    //   3901: getfield 46	com/tencent/mobileqq/app/QQHeadDownloadHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3904: iconst_1
    //   3905: aload 46
    //   3907: aload 47
    //   3909: getfield 212	AvatarInfo/QQHeadInfo:idType	I
    //   3912: invokevirtual 311	com/tencent/mobileqq/app/QQAppInterface:a	(ILjava/lang/String;I)V
    //   3915: iload 8
    //   3917: istore_3
    //   3918: iload_2
    //   3919: istore 15
    //   3921: iload 29
    //   3923: istore 28
    //   3925: iload 11
    //   3927: istore 9
    //   3929: aload_1
    //   3930: astore 44
    //   3932: iload 12
    //   3934: istore 10
    //   3936: goto +1162 -> 5098
    //   3939: iload 10
    //   3941: istore 13
    //   3943: iload 34
    //   3945: istore 30
    //   3947: iload 15
    //   3949: istore 6
    //   3951: aload 44
    //   3953: astore 42
    //   3955: iload 25
    //   3957: istore 4
    //   3959: iload 27
    //   3961: istore 32
    //   3963: iload 12
    //   3965: istore 14
    //   3967: iload 36
    //   3969: istore 31
    //   3971: iload 17
    //   3973: istore 7
    //   3975: aload 44
    //   3977: astore 43
    //   3979: iload 26
    //   3981: istore 5
    //   3983: aload_0
    //   3984: getfield 46	com/tencent/mobileqq/app/QQHeadDownloadHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3987: aload 45
    //   3989: invokevirtual 416	com/tencent/mobileqq/app/QQAppInterface:a	(Lcom/tencent/mobileqq/data/Setting;)V
    //   3992: iload 10
    //   3994: istore 13
    //   3996: iload 34
    //   3998: istore 30
    //   4000: iload 15
    //   4002: istore 6
    //   4004: aload 44
    //   4006: astore 42
    //   4008: iload 25
    //   4010: istore 4
    //   4012: iload 27
    //   4014: istore 32
    //   4016: iload 12
    //   4018: istore 14
    //   4020: iload 36
    //   4022: istore 31
    //   4024: iload 17
    //   4026: istore 7
    //   4028: aload 44
    //   4030: astore 43
    //   4032: iload 26
    //   4034: istore 5
    //   4036: aload_0
    //   4037: getfield 44	com/tencent/mobileqq/app/QQHeadDownloadHandler:b	Lmqq/os/MqqHandler;
    //   4040: new 418	com/tencent/mobileqq/app/QQHeadDownloadHandler$UpdateSettingRunnable
    //   4043: dup
    //   4044: aload_0
    //   4045: aload 45
    //   4047: aload_1
    //   4048: invokespecial 421	com/tencent/mobileqq/app/QQHeadDownloadHandler$UpdateSettingRunnable:<init>	(Lcom/tencent/mobileqq/app/QQHeadDownloadHandler;Lcom/tencent/mobileqq/data/Setting;Lcom/tencent/mobileqq/util/FaceInfo;)V
    //   4051: invokevirtual 425	mqq/os/MqqHandler:postAtFrontOfQueue	(Ljava/lang/Runnable;)Z
    //   4054: pop
    //   4055: iload 24
    //   4057: istore_3
    //   4058: iload 23
    //   4060: istore 15
    //   4062: iload 35
    //   4064: istore 28
    //   4066: iload 22
    //   4068: istore 9
    //   4070: iload_2
    //   4071: istore 10
    //   4073: goto +1025 -> 5098
    //   4076: iload 15
    //   4078: istore 13
    //   4080: iload 28
    //   4082: istore 30
    //   4084: iload 9
    //   4086: istore 6
    //   4088: aload 44
    //   4090: astore 42
    //   4092: iload 10
    //   4094: istore 4
    //   4096: iload 27
    //   4098: istore 32
    //   4100: iload_3
    //   4101: istore 14
    //   4103: iload 28
    //   4105: istore 31
    //   4107: iload 9
    //   4109: istore 7
    //   4111: aload 44
    //   4113: astore 43
    //   4115: iload 10
    //   4117: istore 5
    //   4119: aload 47
    //   4121: getfield 137	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   4124: iconst_4
    //   4125: if_icmpne +141 -> 4266
    //   4128: iload 15
    //   4130: istore 13
    //   4132: iload 28
    //   4134: istore 30
    //   4136: iload 9
    //   4138: istore 6
    //   4140: aload 44
    //   4142: astore 42
    //   4144: iload 10
    //   4146: istore 4
    //   4148: iload 27
    //   4150: istore 32
    //   4152: iload_3
    //   4153: istore 14
    //   4155: iload 28
    //   4157: istore 31
    //   4159: iload 9
    //   4161: istore 7
    //   4163: aload 44
    //   4165: astore 43
    //   4167: iload 10
    //   4169: istore 5
    //   4171: aload_0
    //   4172: getfield 48	com/tencent/mobileqq/app/QQHeadDownloadHandler:jdField_a_of_type_ComTencentMobileqqAppFriendListHandler	Lcom/tencent/mobileqq/app/FriendListHandler;
    //   4175: bipush 30
    //   4177: iconst_1
    //   4178: iconst_1
    //   4179: anewarray 21	java/lang/Object
    //   4182: dup
    //   4183: iconst_0
    //   4184: aload 46
    //   4186: aastore
    //   4187: invokevirtual 315	com/tencent/mobileqq/app/FriendListHandler:notifyUI	(IZLjava/lang/Object;)V
    //   4190: iload 15
    //   4192: istore 13
    //   4194: iload 28
    //   4196: istore 30
    //   4198: iload 9
    //   4200: istore 6
    //   4202: aload 44
    //   4204: astore 42
    //   4206: iload 10
    //   4208: istore 4
    //   4210: iload 27
    //   4212: istore 32
    //   4214: iload_3
    //   4215: istore 14
    //   4217: iload 28
    //   4219: istore 31
    //   4221: iload 9
    //   4223: istore 7
    //   4225: aload 44
    //   4227: astore 43
    //   4229: iload 10
    //   4231: istore 5
    //   4233: aload_0
    //   4234: getfield 46	com/tencent/mobileqq/app/QQHeadDownloadHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4237: iconst_4
    //   4238: aload 46
    //   4240: iconst_0
    //   4241: aload 41
    //   4243: invokevirtual 428	com/tencent/mobileqq/app/QQAppInterface:a	(ILjava/lang/String;ILjava/lang/String;)V
    //   4246: iload_3
    //   4247: istore_2
    //   4248: iload 27
    //   4250: istore 29
    //   4252: aload 41
    //   4254: astore_1
    //   4255: iload 28
    //   4257: istore 27
    //   4259: iload 29
    //   4261: istore 28
    //   4263: goto -2249 -> 2014
    //   4266: iload 15
    //   4268: istore 13
    //   4270: iload 28
    //   4272: istore 30
    //   4274: iload 9
    //   4276: istore 6
    //   4278: aload 44
    //   4280: astore 42
    //   4282: iload 10
    //   4284: istore 4
    //   4286: iload 27
    //   4288: istore 32
    //   4290: iload_3
    //   4291: istore 14
    //   4293: iload 28
    //   4295: istore 31
    //   4297: iload 9
    //   4299: istore 7
    //   4301: aload 44
    //   4303: astore 43
    //   4305: iload 10
    //   4307: istore 5
    //   4309: aload 47
    //   4311: getfield 137	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   4314: bipush 32
    //   4316: if_icmpne +180 -> 4496
    //   4319: iload 15
    //   4321: istore 13
    //   4323: iload 28
    //   4325: istore 30
    //   4327: iload 9
    //   4329: istore 6
    //   4331: aload 44
    //   4333: astore 42
    //   4335: iload 10
    //   4337: istore 4
    //   4339: iload 27
    //   4341: istore 32
    //   4343: iload_3
    //   4344: istore 14
    //   4346: iload 28
    //   4348: istore 31
    //   4350: iload 9
    //   4352: istore 7
    //   4354: aload 44
    //   4356: astore 43
    //   4358: iload 10
    //   4360: istore 5
    //   4362: aload_0
    //   4363: getfield 48	com/tencent/mobileqq/app/QQHeadDownloadHandler:jdField_a_of_type_ComTencentMobileqqAppFriendListHandler	Lcom/tencent/mobileqq/app/FriendListHandler;
    //   4366: iconst_5
    //   4367: iconst_1
    //   4368: iconst_3
    //   4369: anewarray 21	java/lang/Object
    //   4372: dup
    //   4373: iconst_0
    //   4374: aload 46
    //   4376: aastore
    //   4377: dup
    //   4378: iconst_1
    //   4379: aload 47
    //   4381: getfield 212	AvatarInfo/QQHeadInfo:idType	I
    //   4384: invokestatic 431	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   4387: aastore
    //   4388: dup
    //   4389: iconst_2
    //   4390: iconst_1
    //   4391: invokestatic 436	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   4394: aastore
    //   4395: invokevirtual 315	com/tencent/mobileqq/app/FriendListHandler:notifyUI	(IZLjava/lang/Object;)V
    //   4398: iload 15
    //   4400: istore 13
    //   4402: iload 28
    //   4404: istore 30
    //   4406: iload 9
    //   4408: istore 6
    //   4410: aload 44
    //   4412: astore 42
    //   4414: iload 10
    //   4416: istore 4
    //   4418: iload 27
    //   4420: istore 32
    //   4422: iload_3
    //   4423: istore 14
    //   4425: iload 28
    //   4427: istore 31
    //   4429: iload 9
    //   4431: istore 7
    //   4433: aload 44
    //   4435: astore 43
    //   4437: iload 10
    //   4439: istore 5
    //   4441: aload_0
    //   4442: getfield 48	com/tencent/mobileqq/app/QQHeadDownloadHandler:jdField_a_of_type_ComTencentMobileqqAppFriendListHandler	Lcom/tencent/mobileqq/app/FriendListHandler;
    //   4445: bipush 104
    //   4447: iconst_1
    //   4448: iconst_3
    //   4449: anewarray 21	java/lang/Object
    //   4452: dup
    //   4453: iconst_0
    //   4454: aload 46
    //   4456: aastore
    //   4457: dup
    //   4458: iconst_1
    //   4459: aload 47
    //   4461: getfield 212	AvatarInfo/QQHeadInfo:idType	I
    //   4464: invokestatic 431	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   4467: aastore
    //   4468: dup
    //   4469: iconst_2
    //   4470: aload 44
    //   4472: aastore
    //   4473: invokevirtual 315	com/tencent/mobileqq/app/FriendListHandler:notifyUI	(IZLjava/lang/Object;)V
    //   4476: iload_3
    //   4477: istore_2
    //   4478: iload 27
    //   4480: istore 29
    //   4482: aload 41
    //   4484: astore_1
    //   4485: iload 28
    //   4487: istore 27
    //   4489: iload 29
    //   4491: istore 28
    //   4493: goto -2479 -> 2014
    //   4496: iload 15
    //   4498: istore 13
    //   4500: iload 28
    //   4502: istore 30
    //   4504: iload 9
    //   4506: istore 6
    //   4508: aload 44
    //   4510: astore 42
    //   4512: iload 10
    //   4514: istore 4
    //   4516: iload 27
    //   4518: istore 32
    //   4520: iload_3
    //   4521: istore 14
    //   4523: iload 28
    //   4525: istore 31
    //   4527: iload 9
    //   4529: istore 7
    //   4531: aload 44
    //   4533: astore 43
    //   4535: iload 10
    //   4537: istore 5
    //   4539: aload 47
    //   4541: getfield 137	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   4544: bipush 16
    //   4546: if_icmpne +103 -> 4649
    //   4549: iload 15
    //   4551: istore 13
    //   4553: iload 28
    //   4555: istore 30
    //   4557: iload 9
    //   4559: istore 6
    //   4561: aload 44
    //   4563: astore 42
    //   4565: iload 10
    //   4567: istore 4
    //   4569: iload 27
    //   4571: istore 32
    //   4573: iload_3
    //   4574: istore 14
    //   4576: iload 28
    //   4578: istore 31
    //   4580: iload 9
    //   4582: istore 7
    //   4584: aload 44
    //   4586: astore 43
    //   4588: iload 10
    //   4590: istore 5
    //   4592: aload_0
    //   4593: getfield 48	com/tencent/mobileqq/app/QQHeadDownloadHandler:jdField_a_of_type_ComTencentMobileqqAppFriendListHandler	Lcom/tencent/mobileqq/app/FriendListHandler;
    //   4596: bipush 6
    //   4598: iconst_1
    //   4599: iconst_3
    //   4600: anewarray 21	java/lang/Object
    //   4603: dup
    //   4604: iconst_0
    //   4605: aload 46
    //   4607: aastore
    //   4608: dup
    //   4609: iconst_1
    //   4610: aload 47
    //   4612: getfield 212	AvatarInfo/QQHeadInfo:idType	I
    //   4615: invokestatic 431	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   4618: aastore
    //   4619: dup
    //   4620: iconst_2
    //   4621: iconst_1
    //   4622: invokestatic 436	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   4625: aastore
    //   4626: invokevirtual 315	com/tencent/mobileqq/app/FriendListHandler:notifyUI	(IZLjava/lang/Object;)V
    //   4629: iload_3
    //   4630: istore_2
    //   4631: iload 27
    //   4633: istore 29
    //   4635: aload 41
    //   4637: astore_1
    //   4638: iload 28
    //   4640: istore 27
    //   4642: iload 29
    //   4644: istore 28
    //   4646: goto -2632 -> 2014
    //   4649: iload 15
    //   4651: istore 13
    //   4653: iload 28
    //   4655: istore 30
    //   4657: iload 9
    //   4659: istore 6
    //   4661: aload 44
    //   4663: astore 42
    //   4665: iload 10
    //   4667: istore 4
    //   4669: iload 27
    //   4671: istore 32
    //   4673: iload_3
    //   4674: istore 14
    //   4676: iload 28
    //   4678: istore 31
    //   4680: iload 9
    //   4682: istore 7
    //   4684: aload 44
    //   4686: astore 43
    //   4688: iload 10
    //   4690: istore 5
    //   4692: aload_0
    //   4693: getfield 46	com/tencent/mobileqq/app/QQHeadDownloadHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4696: iconst_1
    //   4697: aload 46
    //   4699: iconst_0
    //   4700: aload 41
    //   4702: invokevirtual 428	com/tencent/mobileqq/app/QQAppInterface:a	(ILjava/lang/String;ILjava/lang/String;)V
    //   4705: iload 15
    //   4707: istore 13
    //   4709: iload 28
    //   4711: istore 30
    //   4713: iload 9
    //   4715: istore 6
    //   4717: aload 44
    //   4719: astore 42
    //   4721: iload 10
    //   4723: istore 4
    //   4725: iload 27
    //   4727: istore 32
    //   4729: iload_3
    //   4730: istore 14
    //   4732: iload 28
    //   4734: istore 31
    //   4736: iload 9
    //   4738: istore 7
    //   4740: aload 44
    //   4742: astore 43
    //   4744: iload 10
    //   4746: istore 5
    //   4748: aload 46
    //   4750: aload_0
    //   4751: getfield 46	com/tencent/mobileqq/app/QQHeadDownloadHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4754: invokevirtual 439	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   4757: invokevirtual 443	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4760: ifeq +59 -> 4819
    //   4763: iload 15
    //   4765: istore 13
    //   4767: iload 28
    //   4769: istore 30
    //   4771: iload 9
    //   4773: istore 6
    //   4775: aload 44
    //   4777: astore 42
    //   4779: iload 10
    //   4781: istore 4
    //   4783: iload 27
    //   4785: istore 32
    //   4787: iload_3
    //   4788: istore 14
    //   4790: iload 28
    //   4792: istore 31
    //   4794: iload 9
    //   4796: istore 7
    //   4798: aload 44
    //   4800: astore 43
    //   4802: iload 10
    //   4804: istore 5
    //   4806: aload_0
    //   4807: getfield 46	com/tencent/mobileqq/app/QQHeadDownloadHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4810: iconst_1
    //   4811: aload 46
    //   4813: iconst_0
    //   4814: aload 41
    //   4816: invokevirtual 445	com/tencent/mobileqq/app/QQAppInterface:b	(ILjava/lang/String;ILjava/lang/String;)V
    //   4819: iload 15
    //   4821: istore 13
    //   4823: iload 28
    //   4825: istore 30
    //   4827: iload 9
    //   4829: istore 6
    //   4831: aload 44
    //   4833: astore 42
    //   4835: iload 10
    //   4837: istore 4
    //   4839: iload 27
    //   4841: istore 32
    //   4843: iload_3
    //   4844: istore 14
    //   4846: iload 28
    //   4848: istore 31
    //   4850: iload 9
    //   4852: istore 7
    //   4854: aload 44
    //   4856: astore 43
    //   4858: iload 10
    //   4860: istore 5
    //   4862: aload_0
    //   4863: getfield 48	com/tencent/mobileqq/app/QQHeadDownloadHandler:jdField_a_of_type_ComTencentMobileqqAppFriendListHandler	Lcom/tencent/mobileqq/app/FriendListHandler;
    //   4866: iconst_4
    //   4867: iconst_1
    //   4868: iconst_1
    //   4869: anewarray 21	java/lang/Object
    //   4872: dup
    //   4873: iconst_0
    //   4874: aload 46
    //   4876: aastore
    //   4877: invokevirtual 315	com/tencent/mobileqq/app/FriendListHandler:notifyUI	(IZLjava/lang/Object;)V
    //   4880: iload_3
    //   4881: istore_2
    //   4882: iload 27
    //   4884: istore 29
    //   4886: aload 41
    //   4888: astore_1
    //   4889: iload 28
    //   4891: istore 27
    //   4893: iload 29
    //   4895: istore 28
    //   4897: goto -2883 -> 2014
    //   4900: astore_1
    //   4901: aload 44
    //   4903: astore 42
    //   4905: iconst_0
    //   4906: istore 27
    //   4908: iload 20
    //   4910: istore 13
    //   4912: iload 16
    //   4914: istore 6
    //   4916: iload 21
    //   4918: istore 4
    //   4920: goto -1908 -> 3012
    //   4923: astore_1
    //   4924: aload 44
    //   4926: astore 42
    //   4928: iconst_0
    //   4929: istore 27
    //   4931: iload 20
    //   4933: istore 13
    //   4935: iload 16
    //   4937: istore 6
    //   4939: iload_2
    //   4940: istore 4
    //   4942: goto -1930 -> 3012
    //   4945: astore_1
    //   4946: iconst_0
    //   4947: istore 27
    //   4949: iload 20
    //   4951: istore 13
    //   4953: iload 16
    //   4955: istore 6
    //   4957: iload_2
    //   4958: istore 4
    //   4960: goto -1948 -> 3012
    //   4963: astore_1
    //   4964: iconst_0
    //   4965: istore_2
    //   4966: aload 44
    //   4968: astore 43
    //   4970: iconst_0
    //   4971: istore 29
    //   4973: aload 41
    //   4975: astore_1
    //   4976: iload 27
    //   4978: istore 28
    //   4980: iload_3
    //   4981: istore 7
    //   4983: iload 18
    //   4985: istore 5
    //   4987: iload 29
    //   4989: istore 27
    //   4991: goto -2357 -> 2634
    //   4994: astore_1
    //   4995: iconst_0
    //   4996: istore 4
    //   4998: aload 44
    //   5000: astore 43
    //   5002: iconst_0
    //   5003: istore 29
    //   5005: aload 41
    //   5007: astore_1
    //   5008: iload 27
    //   5010: istore 28
    //   5012: iload_3
    //   5013: istore 7
    //   5015: iload_2
    //   5016: istore 5
    //   5018: iload 4
    //   5020: istore_2
    //   5021: iload 29
    //   5023: istore 27
    //   5025: goto -2391 -> 2634
    //   5028: astore_1
    //   5029: iconst_0
    //   5030: istore 4
    //   5032: iconst_0
    //   5033: istore 29
    //   5035: iload 27
    //   5037: istore 28
    //   5039: aload 41
    //   5041: astore_1
    //   5042: iload_3
    //   5043: istore 7
    //   5045: iload_2
    //   5046: istore 5
    //   5048: iload 4
    //   5050: istore_2
    //   5051: iload 29
    //   5053: istore 27
    //   5055: goto -2421 -> 2634
    //   5058: iload_2
    //   5059: istore_3
    //   5060: goto -1652 -> 3408
    //   5063: goto -4705 -> 358
    //   5066: aload 46
    //   5068: astore 41
    //   5070: goto -4819 -> 251
    //   5073: iconst_0
    //   5074: istore_2
    //   5075: iconst_0
    //   5076: istore 27
    //   5078: iconst_0
    //   5079: istore 28
    //   5081: aconst_null
    //   5082: astore_1
    //   5083: iload 14
    //   5085: istore 15
    //   5087: iload 7
    //   5089: istore 9
    //   5091: iload 5
    //   5093: istore 10
    //   5095: goto -3081 -> 2014
    //   5098: iload 28
    //   5100: ifne -3218 -> 1882
    //   5103: iload 27
    //   5105: ifne -225 -> 4880
    //   5108: goto -3226 -> 1882
    //   5111: iconst_0
    //   5112: istore 27
    //   5114: goto -4511 -> 603
    //   5117: astore_1
    //   5118: iload 14
    //   5120: istore_2
    //   5121: iload 31
    //   5123: istore 27
    //   5125: iload 32
    //   5127: istore 28
    //   5129: aload 41
    //   5131: astore_1
    //   5132: goto -2498 -> 2634
    //   5135: iload_3
    //   5136: lookupswitch	default:+44->5180, 1:+64->5200, 4:+81->5217, 5:+118->5254, 33:+98->5234
    //   5181: fload_1
    //   5182: <illegal opcode>
    //   5183: istore_2
    //   5184: iload_3
    //   5185: istore 8
    //   5187: iload 33
    //   5189: istore 29
    //   5191: aload 44
    //   5193: astore_1
    //   5194: iload_3
    //   5195: istore 12
    //   5197: goto -3471 -> 1726
    //   5200: sipush 9206
    //   5203: istore_2
    //   5204: iload 33
    //   5206: istore 29
    //   5208: aload 44
    //   5210: astore_1
    //   5211: iload_3
    //   5212: istore 12
    //   5214: goto -3488 -> 1726
    //   5217: sipush 9202
    //   5220: istore_2
    //   5221: iload 33
    //   5223: istore 29
    //   5225: aload 44
    //   5227: astore_1
    //   5228: iload_3
    //   5229: istore 12
    //   5231: goto -3505 -> 1726
    //   5234: sipush 9208
    //   5237: istore_2
    //   5238: iload_3
    //   5239: istore 8
    //   5241: iload 33
    //   5243: istore 29
    //   5245: aload 44
    //   5247: astore_1
    //   5248: iload_3
    //   5249: istore 12
    //   5251: goto -3525 -> 1726
    //   5254: sipush 9204
    //   5257: istore_2
    //   5258: iload 33
    //   5260: istore 29
    //   5262: aload 44
    //   5264: astore_1
    //   5265: iload_3
    //   5266: istore 12
    //   5268: goto -3542 -> 1726
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	5271	0	this	QQHeadDownloadHandler
    //   0	5271	1	paramFaceInfo	com.tencent.mobileqq.util.FaceInfo
    //   130	5128	2	i	int
    //   70	5196	3	j	int
    //   159	4890	4	k	int
    //   118	4974	5	m	int
    //   151	4805	6	n	int
    //   67	5021	7	i1	int
    //   115	5125	8	i2	int
    //   106	4984	9	i3	int
    //   97	4997	10	i4	int
    //   84	3842	11	i5	int
    //   112	5155	12	i6	int
    //   143	4809	13	i7	int
    //   94	5025	14	i8	int
    //   72	5014	15	i9	int
    //   75	4879	16	i10	int
    //   81	3944	17	i11	int
    //   121	4863	18	i12	int
    //   135	3056	19	i13	int
    //   100	4850	20	i14	int
    //   127	4790	21	i15	int
    //   78	3989	22	i16	int
    //   103	3956	23	i17	int
    //   109	3947	24	i18	int
    //   124	3885	25	i19	int
    //   132	3901	26	i20	int
    //   52	5072	27	bool1	boolean
    //   49	5079	28	bool2	boolean
    //   139	5122	29	bool3	boolean
    //   147	4679	30	bool4	boolean
    //   1206	3916	31	bool5	boolean
    //   1198	3928	32	bool6	boolean
    //   64	5195	33	bool7	boolean
    //   55	3942	34	bool8	boolean
    //   58	4005	35	bool9	boolean
    //   61	3960	36	bool10	boolean
    //   2914	34	37	l1	long
    //   2945	5	39	l2	long
    //   249	4881	41	localObject1	Object
    //   155	2780	42	localObject2	Object
    //   2967	3	42	localException	java.lang.Exception
    //   2999	1928	42	localObject3	Object
    //   1214	3787	43	localObject4	Object
    //   91	5172	44	localObject5	Object
    //   284	3762	45	localSetting	com.tencent.mobileqq.data.Setting
    //   23	5044	46	str	String
    //   4	4607	47	localQQHeadInfo	AvatarInfo.QQHeadInfo
    //   1241	2214	48	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   161	172	2611	java/lang/Throwable
    //   196	205	2611	java/lang/Throwable
    //   229	251	2611	java/lang/Throwable
    //   275	286	2611	java/lang/Throwable
    //   315	324	2611	java/lang/Throwable
    //   348	355	2611	java/lang/Throwable
    //   382	392	2611	java/lang/Throwable
    //   416	426	2611	java/lang/Throwable
    //   450	460	2611	java/lang/Throwable
    //   484	492	2611	java/lang/Throwable
    //   516	524	2611	java/lang/Throwable
    //   548	554	2611	java/lang/Throwable
    //   587	600	2611	java/lang/Throwable
    //   631	641	2611	java/lang/Throwable
    //   678	687	2611	java/lang/Throwable
    //   715	723	2611	java/lang/Throwable
    //   747	775	2611	java/lang/Throwable
    //   812	820	2611	java/lang/Throwable
    //   844	850	2611	java/lang/Throwable
    //   878	888	2611	java/lang/Throwable
    //   912	922	2611	java/lang/Throwable
    //   946	956	2611	java/lang/Throwable
    //   980	996	2611	java/lang/Throwable
    //   1020	1026	2611	java/lang/Throwable
    //   1050	1055	2611	java/lang/Throwable
    //   1079	1082	2611	java/lang/Throwable
    //   1160	1176	2611	java/lang/Throwable
    //   2396	2406	2611	java/lang/Throwable
    //   2430	2470	2611	java/lang/Throwable
    //   2497	2507	2611	java/lang/Throwable
    //   2531	2571	2611	java/lang/Throwable
    //   2598	2608	2611	java/lang/Throwable
    //   2834	2842	2611	java/lang/Throwable
    //   2866	2879	2611	java/lang/Throwable
    //   2909	2916	2611	java/lang/Throwable
    //   2940	2947	2611	java/lang/Throwable
    //   3005	3007	2611	java/lang/Throwable
    //   1108	1119	2967	java/lang/Exception
    //   1082	1103	2977	finally
    //   1108	1119	2977	finally
    //   1119	1136	2977	finally
    //   2969	2974	2977	finally
    //   2978	2981	2977	finally
    //   161	172	3007	finally
    //   196	205	3007	finally
    //   229	251	3007	finally
    //   275	286	3007	finally
    //   315	324	3007	finally
    //   348	355	3007	finally
    //   382	392	3007	finally
    //   416	426	3007	finally
    //   450	460	3007	finally
    //   484	492	3007	finally
    //   516	524	3007	finally
    //   548	554	3007	finally
    //   587	600	3007	finally
    //   631	641	3007	finally
    //   678	687	3007	finally
    //   715	723	3007	finally
    //   747	775	3007	finally
    //   812	820	3007	finally
    //   844	850	3007	finally
    //   878	888	3007	finally
    //   912	922	3007	finally
    //   946	956	3007	finally
    //   980	996	3007	finally
    //   1020	1026	3007	finally
    //   1050	1055	3007	finally
    //   1079	1082	3007	finally
    //   1160	1176	3007	finally
    //   1220	1243	3007	finally
    //   1292	1300	3007	finally
    //   1344	1350	3007	finally
    //   1394	1405	3007	finally
    //   1458	1465	3007	finally
    //   1522	1548	3007	finally
    //   1592	1602	3007	finally
    //   1646	1675	3007	finally
    //   1793	1802	3007	finally
    //   1843	1858	3007	finally
    //   1925	1935	3007	finally
    //   1978	1997	3007	finally
    //   2396	2406	3007	finally
    //   2430	2470	3007	finally
    //   2497	2507	3007	finally
    //   2531	2571	3007	finally
    //   2598	2608	3007	finally
    //   2834	2842	3007	finally
    //   2866	2879	3007	finally
    //   2909	2916	3007	finally
    //   2940	2947	3007	finally
    //   3005	3007	3007	finally
    //   3371	3408	3007	finally
    //   3454	3462	3007	finally
    //   3513	3522	3007	finally
    //   3564	3583	3007	finally
    //   3636	3646	3007	finally
    //   3687	3703	3007	finally
    //   3768	3778	3007	finally
    //   3819	3835	3007	finally
    //   3900	3915	3007	finally
    //   3983	3992	3007	finally
    //   4036	4055	3007	finally
    //   4119	4128	3007	finally
    //   4171	4190	3007	finally
    //   4233	4246	3007	finally
    //   4309	4319	3007	finally
    //   4362	4398	3007	finally
    //   4441	4476	3007	finally
    //   4539	4549	3007	finally
    //   4592	4629	3007	finally
    //   4692	4705	3007	finally
    //   4748	4763	3007	finally
    //   4806	4819	3007	finally
    //   4862	4880	3007	finally
    //   1160	1176	3103	java/lang/Exception
    //   1220	1243	3103	java/lang/Exception
    //   1292	1300	3103	java/lang/Exception
    //   1344	1350	3103	java/lang/Exception
    //   1394	1405	3103	java/lang/Exception
    //   1458	1465	3103	java/lang/Exception
    //   1694	1713	3178	java/lang/Exception
    //   1675	1689	4900	finally
    //   1694	1713	4900	finally
    //   3197	3208	4900	finally
    //   3212	3247	4923	finally
    //   3259	3269	4945	finally
    //   3277	3306	4945	finally
    //   3314	3326	4945	finally
    //   1675	1689	4963	java/lang/Throwable
    //   1694	1713	4963	java/lang/Throwable
    //   3197	3208	4963	java/lang/Throwable
    //   3212	3247	4994	java/lang/Throwable
    //   3259	3269	5028	java/lang/Throwable
    //   3277	3306	5028	java/lang/Throwable
    //   3314	3326	5028	java/lang/Throwable
    //   1220	1243	5117	java/lang/Throwable
    //   1292	1300	5117	java/lang/Throwable
    //   1344	1350	5117	java/lang/Throwable
    //   1394	1405	5117	java/lang/Throwable
    //   1458	1465	5117	java/lang/Throwable
    //   1522	1548	5117	java/lang/Throwable
    //   1592	1602	5117	java/lang/Throwable
    //   1646	1675	5117	java/lang/Throwable
    //   1793	1802	5117	java/lang/Throwable
    //   1843	1858	5117	java/lang/Throwable
    //   1925	1935	5117	java/lang/Throwable
    //   1978	1997	5117	java/lang/Throwable
    //   3371	3408	5117	java/lang/Throwable
    //   3454	3462	5117	java/lang/Throwable
    //   3513	3522	5117	java/lang/Throwable
    //   3564	3583	5117	java/lang/Throwable
    //   3636	3646	5117	java/lang/Throwable
    //   3687	3703	5117	java/lang/Throwable
    //   3768	3778	5117	java/lang/Throwable
    //   3819	3835	5117	java/lang/Throwable
    //   3900	3915	5117	java/lang/Throwable
    //   3983	3992	5117	java/lang/Throwable
    //   4036	4055	5117	java/lang/Throwable
    //   4119	4128	5117	java/lang/Throwable
    //   4171	4190	5117	java/lang/Throwable
    //   4233	4246	5117	java/lang/Throwable
    //   4309	4319	5117	java/lang/Throwable
    //   4362	4398	5117	java/lang/Throwable
    //   4441	4476	5117	java/lang/Throwable
    //   4539	4549	5117	java/lang/Throwable
    //   4592	4629	5117	java/lang/Throwable
    //   4692	4705	5117	java/lang/Throwable
    //   4748	4763	5117	java/lang/Throwable
    //   4806	4819	5117	java/lang/Throwable
    //   4862	4880	5117	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.QQHeadDownloadHandler
 * JD-Core Version:    0.7.0.1
 */