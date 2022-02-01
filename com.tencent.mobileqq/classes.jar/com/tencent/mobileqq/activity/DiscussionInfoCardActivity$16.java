package com.tencent.mobileqq.activity;

import android.app.Activity;
import bhht;
import com.tencent.mobileqq.app.QQAppInterface;

final class DiscussionInfoCardActivity$16
  implements Runnable
{
  DiscussionInfoCardActivity$16(long paramLong, QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, Activity paramActivity, int paramInt, bhht parambhht) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: iconst_0
    //   4: istore_2
    //   5: lconst_1
    //   6: aload_0
    //   7: getfield 20	com/tencent/mobileqq/activity/DiscussionInfoCardActivity$16:jdField_a_of_type_Long	J
    //   10: lcmp
    //   11: ifne +622 -> 633
    //   14: invokestatic 49	com/tencent/mobileqq/util/SystemUtil:isExistSDCard	()Z
    //   17: ifeq +386 -> 403
    //   20: getstatic 54	com/tencent/mobileqq/app/AppConstants:PATH_HEAD_HD	Ljava/lang/String;
    //   23: astore 4
    //   25: new 56	java/lang/StringBuilder
    //   28: dup
    //   29: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   32: aload 4
    //   34: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: ldc 63
    //   39: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: astore 4
    //   47: new 69	java/io/File
    //   50: dup
    //   51: aload 4
    //   53: invokespecial 72	java/io/File:<init>	(Ljava/lang/String;)V
    //   56: astore 5
    //   58: aload 5
    //   60: invokevirtual 75	java/io/File:exists	()Z
    //   63: ifeq +347 -> 410
    //   66: iconst_1
    //   67: istore_1
    //   68: iload_1
    //   69: ifne +787 -> 856
    //   72: ldc 77
    //   74: astore 5
    //   76: new 79	bcgt
    //   79: dup
    //   80: ldc 81
    //   82: invokespecial 84	bcgt:<init>	(Ljava/lang/Class;)V
    //   85: bipush 15
    //   87: invokevirtual 87	bcgt:c	(I)Lbcgt;
    //   90: new 56	java/lang/StringBuilder
    //   93: dup
    //   94: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   97: ldc 88
    //   99: invokestatic 93	amtj:a	(I)Ljava/lang/String;
    //   102: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: aload_0
    //   106: getfield 28	com/tencent/mobileqq/activity/DiscussionInfoCardActivity$16:c	Ljava/lang/String;
    //   109: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   115: invokevirtual 96	bcgt:a	(Ljava/lang/String;)Lbcgt;
    //   118: aload_0
    //   119: getfield 30	com/tencent/mobileqq/activity/DiscussionInfoCardActivity$16:d	Ljava/lang/String;
    //   122: invokevirtual 99	bcgt:e	(Ljava/lang/String;)Lbcgt;
    //   125: invokevirtual 102	bcgt:a	()Lcom/tencent/mobileqq/structmsg/AbsShareMsg;
    //   128: astore 8
    //   130: aload_0
    //   131: getfield 22	com/tencent/mobileqq/activity/DiscussionInfoCardActivity$16:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   134: bipush 51
    //   136: invokevirtual 108	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   139: checkcast 110	amsw
    //   142: astore 9
    //   144: aload_0
    //   145: getfield 22	com/tencent/mobileqq/activity/DiscussionInfoCardActivity$16:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   148: bipush 53
    //   150: invokevirtual 108	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   153: checkcast 112	amrb
    //   156: astore 10
    //   158: aload 7
    //   160: astore 4
    //   162: aload 9
    //   164: ifnull +55 -> 219
    //   167: aload 10
    //   169: aload_0
    //   170: getfield 24	com/tencent/mobileqq/activity/DiscussionInfoCardActivity$16:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   173: invokevirtual 115	amrb:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/DiscussionInfo;
    //   176: astore 6
    //   178: aload 7
    //   180: astore 4
    //   182: aload 6
    //   184: ifnull +35 -> 219
    //   187: aload 10
    //   189: aload_0
    //   190: getfield 24	com/tencent/mobileqq/activity/DiscussionInfoCardActivity$16:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   193: aload 6
    //   195: getfield 120	com/tencent/mobileqq/data/DiscussionInfo:ownerUin	Ljava/lang/String;
    //   198: invokevirtual 123	amrb:a	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mobileqq/data/DiscussionMemberInfo;
    //   201: astore 4
    //   203: aload 4
    //   205: ifnull +553 -> 758
    //   208: aload 4
    //   210: aload_0
    //   211: getfield 22	com/tencent/mobileqq/activity/DiscussionInfoCardActivity$16:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   214: invokestatic 129	com/tencent/mobileqq/utils/ContactUtils:getDiscussionMemberName	(Lcom/tencent/mobileqq/data/DiscussionMemberInfo;Lcom/tencent/mobileqq/app/QQAppInterface;)Ljava/lang/String;
    //   217: astore 4
    //   219: aload 4
    //   221: astore 6
    //   223: aload 4
    //   225: invokestatic 135	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   228: ifeq +10 -> 238
    //   231: ldc 136
    //   233: invokestatic 93	amtj:a	(I)Ljava/lang/String;
    //   236: astore 6
    //   238: new 138	bcla
    //   241: dup
    //   242: invokespecial 139	bcla:<init>	()V
    //   245: astore 4
    //   247: aload 4
    //   249: iconst_1
    //   250: invokevirtual 144	bcgx:b	(I)V
    //   253: aload 4
    //   255: aload_0
    //   256: getfield 32	com/tencent/mobileqq/activity/DiscussionInfoCardActivity$16:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   259: ldc 145
    //   261: invokevirtual 150	android/app/Activity:getString	(I)Ljava/lang/String;
    //   264: invokevirtual 152	bcgx:a	(Ljava/lang/String;)V
    //   267: iconst_2
    //   268: invokestatic 157	bchg:a	(I)Lbcgx;
    //   271: astore 7
    //   273: aload 7
    //   275: aload 5
    //   277: aload_0
    //   278: getfield 22	com/tencent/mobileqq/activity/DiscussionInfoCardActivity$16:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   281: aload_0
    //   282: getfield 28	com/tencent/mobileqq/activity/DiscussionInfoCardActivity$16:c	Ljava/lang/String;
    //   285: aload_0
    //   286: getfield 24	com/tencent/mobileqq/activity/DiscussionInfoCardActivity$16:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   289: invokestatic 163	com/tencent/mobileqq/activity/aio/ForwardUtils:handleFordwardDiscName	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   292: new 56	java/lang/StringBuilder
    //   295: dup
    //   296: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   299: ldc 164
    //   301: invokestatic 93	amtj:a	(I)Ljava/lang/String;
    //   304: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: aload 6
    //   309: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   312: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   315: iconst_1
    //   316: invokevirtual 167	bcgx:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
    //   319: aload 8
    //   321: aload 4
    //   323: invokevirtual 173	com/tencent/mobileqq/structmsg/AbsShareMsg:addItem	(Lbcgw;)V
    //   326: aload 8
    //   328: aload 7
    //   330: invokevirtual 173	com/tencent/mobileqq/structmsg/AbsShareMsg:addItem	(Lbcgw;)V
    //   333: new 175	android/content/Intent
    //   336: dup
    //   337: invokespecial 176	android/content/Intent:<init>	()V
    //   340: astore 4
    //   342: aload 4
    //   344: ldc 178
    //   346: bipush 253
    //   348: invokevirtual 182	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   351: pop
    //   352: aload 4
    //   354: ldc 184
    //   356: aload 8
    //   358: invokevirtual 188	com/tencent/mobileqq/structmsg/AbsShareMsg:getBytes	()[B
    //   361: invokevirtual 191	android/content/Intent:putExtra	(Ljava/lang/String;[B)Landroid/content/Intent;
    //   364: pop
    //   365: aload_0
    //   366: getfield 32	com/tencent/mobileqq/activity/DiscussionInfoCardActivity$16:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   369: aload 4
    //   371: aload_0
    //   372: getfield 34	com/tencent/mobileqq/activity/DiscussionInfoCardActivity$16:jdField_a_of_type_Int	I
    //   375: invokestatic 196	atky:a	(Landroid/app/Activity;Landroid/content/Intent;I)V
    //   378: aload_0
    //   379: getfield 36	com/tencent/mobileqq/activity/DiscussionInfoCardActivity$16:jdField_a_of_type_Bhht	Lbhht;
    //   382: ifnull +20 -> 402
    //   385: aload_0
    //   386: getfield 36	com/tencent/mobileqq/activity/DiscussionInfoCardActivity$16:jdField_a_of_type_Bhht	Lbhht;
    //   389: invokevirtual 201	bhht:isShowing	()Z
    //   392: ifeq +10 -> 402
    //   395: aload_0
    //   396: getfield 36	com/tencent/mobileqq/activity/DiscussionInfoCardActivity$16:jdField_a_of_type_Bhht	Lbhht;
    //   399: invokevirtual 204	bhht:dismiss	()V
    //   402: return
    //   403: ldc 206
    //   405: astore 4
    //   407: goto -382 -> 25
    //   410: aload 5
    //   412: invokevirtual 209	java/io/File:createNewFile	()Z
    //   415: pop
    //   416: new 211	java/io/BufferedOutputStream
    //   419: dup
    //   420: new 213	java/io/FileOutputStream
    //   423: dup
    //   424: aload 5
    //   426: invokespecial 216	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   429: sipush 8192
    //   432: invokespecial 219	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   435: astore 6
    //   437: invokestatic 224	bfvo:e	()Landroid/graphics/drawable/Drawable;
    //   440: checkcast 226	android/graphics/drawable/BitmapDrawable
    //   443: invokevirtual 230	android/graphics/drawable/BitmapDrawable:getBitmap	()Landroid/graphics/Bitmap;
    //   446: getstatic 236	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   449: bipush 100
    //   451: aload 6
    //   453: invokevirtual 242	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   456: istore_3
    //   457: iload_3
    //   458: ifeq +421 -> 879
    //   461: iconst_1
    //   462: istore_2
    //   463: aload 4
    //   465: astore 5
    //   467: aload 5
    //   469: astore 4
    //   471: iload_2
    //   472: istore_1
    //   473: aload 6
    //   475: ifnull -407 -> 68
    //   478: aload 6
    //   480: invokevirtual 247	java/io/OutputStream:close	()V
    //   483: aload 5
    //   485: astore 4
    //   487: iload_2
    //   488: istore_1
    //   489: goto -421 -> 68
    //   492: astore 6
    //   494: aload 5
    //   496: astore 4
    //   498: iload_2
    //   499: istore_1
    //   500: invokestatic 252	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   503: ifeq -435 -> 68
    //   506: ldc 254
    //   508: iconst_2
    //   509: aload 6
    //   511: invokevirtual 257	java/io/IOException:getMessage	()Ljava/lang/String;
    //   514: aload 6
    //   516: invokestatic 260	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   519: aload 5
    //   521: astore 4
    //   523: iload_2
    //   524: istore_1
    //   525: goto -457 -> 68
    //   528: astore 5
    //   530: aconst_null
    //   531: astore 4
    //   533: invokestatic 252	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   536: ifeq +8 -> 544
    //   539: aload 5
    //   541: invokevirtual 263	java/io/IOException:printStackTrace	()V
    //   544: aload 4
    //   546: ifnull +325 -> 871
    //   549: aload 4
    //   551: invokevirtual 247	java/io/OutputStream:close	()V
    //   554: aconst_null
    //   555: astore 4
    //   557: iconst_0
    //   558: istore_1
    //   559: goto -491 -> 68
    //   562: astore 4
    //   564: invokestatic 252	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   567: ifeq +16 -> 583
    //   570: ldc 254
    //   572: iconst_2
    //   573: aload 4
    //   575: invokevirtual 257	java/io/IOException:getMessage	()Ljava/lang/String;
    //   578: aload 4
    //   580: invokestatic 260	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   583: aconst_null
    //   584: astore 4
    //   586: iconst_0
    //   587: istore_1
    //   588: goto -520 -> 68
    //   591: astore 4
    //   593: aconst_null
    //   594: astore 5
    //   596: aload 5
    //   598: ifnull +8 -> 606
    //   601: aload 5
    //   603: invokevirtual 247	java/io/OutputStream:close	()V
    //   606: aload 4
    //   608: athrow
    //   609: astore 5
    //   611: invokestatic 252	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   614: ifeq -8 -> 606
    //   617: ldc 254
    //   619: iconst_2
    //   620: aload 5
    //   622: invokevirtual 257	java/io/IOException:getMessage	()Ljava/lang/String;
    //   625: aload 5
    //   627: invokestatic 260	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   630: goto -24 -> 606
    //   633: new 265	java/util/ArrayList
    //   636: dup
    //   637: invokespecial 266	java/util/ArrayList:<init>	()V
    //   640: astore 4
    //   642: aload 4
    //   644: aload_0
    //   645: getfield 22	com/tencent/mobileqq/activity/DiscussionInfoCardActivity$16:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   648: bipush 101
    //   650: aload_0
    //   651: getfield 24	com/tencent/mobileqq/activity/DiscussionInfoCardActivity$16:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   654: iconst_0
    //   655: invokevirtual 270	com/tencent/mobileqq/app/QQAppInterface:getCustomFaceFilePath	(ILjava/lang/String;I)Ljava/lang/String;
    //   658: invokevirtual 274	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   661: pop
    //   662: aload 4
    //   664: aload_0
    //   665: getfield 22	com/tencent/mobileqq/activity/DiscussionInfoCardActivity$16:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   668: invokevirtual 277	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   671: aload_0
    //   672: getfield 26	com/tencent/mobileqq/activity/DiscussionInfoCardActivity$16:b	Ljava/lang/String;
    //   675: ldc_w 279
    //   678: invokestatic 285	cooperation/qzone/QZoneShareManager:batchUploadImages	(Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/ArrayList;
    //   681: astore 4
    //   683: aload 4
    //   685: ifnull +178 -> 863
    //   688: aload 4
    //   690: invokevirtual 289	java/util/ArrayList:size	()I
    //   693: ifle +170 -> 863
    //   696: aload 4
    //   698: iconst_0
    //   699: invokevirtual 293	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   702: checkcast 295	java/lang/String
    //   705: astore 5
    //   707: aload 5
    //   709: astore 4
    //   711: iload_2
    //   712: istore_1
    //   713: aload 5
    //   715: invokestatic 135	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   718: ifne -650 -> 68
    //   721: aload 5
    //   723: ldc_w 297
    //   726: invokevirtual 301	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   729: ifne +20 -> 749
    //   732: aload 5
    //   734: astore 4
    //   736: iload_2
    //   737: istore_1
    //   738: aload 5
    //   740: ldc_w 303
    //   743: invokevirtual 301	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   746: ifeq -678 -> 68
    //   749: iconst_1
    //   750: istore_1
    //   751: aload 5
    //   753: astore 4
    //   755: goto -687 -> 68
    //   758: aload 9
    //   760: aload 6
    //   762: getfield 120	com/tencent/mobileqq/data/DiscussionInfo:ownerUin	Ljava/lang/String;
    //   765: invokevirtual 305	amsw:b	(Ljava/lang/String;)Z
    //   768: ifeq +20 -> 788
    //   771: aload_0
    //   772: getfield 22	com/tencent/mobileqq/activity/DiscussionInfoCardActivity$16:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   775: aload 6
    //   777: getfield 120	com/tencent/mobileqq/data/DiscussionInfo:ownerUin	Ljava/lang/String;
    //   780: invokestatic 309	com/tencent/mobileqq/utils/ContactUtils:getFriendDisplayName	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)Ljava/lang/String;
    //   783: astore 4
    //   785: goto -566 -> 219
    //   788: aload 9
    //   790: aload 6
    //   792: getfield 120	com/tencent/mobileqq/data/DiscussionInfo:ownerUin	Ljava/lang/String;
    //   795: invokevirtual 312	amsw:e	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Friends;
    //   798: astore 4
    //   800: aload 4
    //   802: ifnull +13 -> 815
    //   805: aload 4
    //   807: getfield 317	com/tencent/mobileqq/data/Friends:name	Ljava/lang/String;
    //   810: astore 4
    //   812: goto -593 -> 219
    //   815: aload 6
    //   817: getfield 120	com/tencent/mobileqq/data/DiscussionInfo:ownerUin	Ljava/lang/String;
    //   820: astore 4
    //   822: goto -603 -> 219
    //   825: astore 4
    //   827: aload 6
    //   829: astore 5
    //   831: goto -235 -> 596
    //   834: astore 6
    //   836: aload 4
    //   838: astore 5
    //   840: aload 6
    //   842: astore 4
    //   844: goto -248 -> 596
    //   847: astore 5
    //   849: aload 6
    //   851: astore 4
    //   853: goto -320 -> 533
    //   856: aload 4
    //   858: astore 5
    //   860: goto -784 -> 76
    //   863: aconst_null
    //   864: astore 4
    //   866: iload_2
    //   867: istore_1
    //   868: goto -800 -> 68
    //   871: aconst_null
    //   872: astore 4
    //   874: iconst_0
    //   875: istore_1
    //   876: goto -808 -> 68
    //   879: aconst_null
    //   880: astore 5
    //   882: iconst_0
    //   883: istore_2
    //   884: goto -417 -> 467
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	887	0	this	16
    //   67	809	1	i	int
    //   4	880	2	j	int
    //   456	2	3	bool	boolean
    //   23	533	4	localObject1	Object
    //   562	17	4	localIOException1	java.io.IOException
    //   584	1	4	localObject2	Object
    //   591	16	4	localObject3	Object
    //   640	181	4	localObject4	Object
    //   825	12	4	localObject5	Object
    //   842	31	4	localObject6	Object
    //   56	464	5	localObject7	Object
    //   528	12	5	localIOException2	java.io.IOException
    //   594	8	5	localObject8	Object
    //   609	17	5	localIOException3	java.io.IOException
    //   705	134	5	localObject9	Object
    //   847	1	5	localIOException4	java.io.IOException
    //   858	23	5	localObject10	Object
    //   176	303	6	localObject11	Object
    //   492	336	6	localIOException5	java.io.IOException
    //   834	16	6	localObject12	Object
    //   1	328	7	localbcgx	bcgx
    //   128	229	8	localAbsShareMsg	com.tencent.mobileqq.structmsg.AbsShareMsg
    //   142	647	9	localamsw	amsw
    //   156	32	10	localamrb	amrb
    // Exception table:
    //   from	to	target	type
    //   478	483	492	java/io/IOException
    //   410	437	528	java/io/IOException
    //   549	554	562	java/io/IOException
    //   410	437	591	finally
    //   601	606	609	java/io/IOException
    //   437	457	825	finally
    //   533	544	834	finally
    //   437	457	847	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.DiscussionInfoCardActivity.16
 * JD-Core Version:    0.7.0.1
 */