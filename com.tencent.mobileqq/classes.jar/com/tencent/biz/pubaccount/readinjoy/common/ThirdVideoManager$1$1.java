package com.tencent.biz.pubaccount.readinjoy.common;

import android.os.Bundle;
import osg;

public class ThirdVideoManager$1$1
  implements Runnable
{
  public ThirdVideoManager$1$1(osg paramosg, boolean paramBoolean, Bundle paramBundle) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: invokestatic 31	java/lang/System:currentTimeMillis	()J
    //   3: aload_0
    //   4: getfield 14	com/tencent/biz/pubaccount/readinjoy/common/ThirdVideoManager$1$1:jdField_a_of_type_Osg	Losg;
    //   7: getfield 36	osg:jdField_a_of_type_Long	J
    //   10: lsub
    //   11: lstore_3
    //   12: invokestatic 42	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   15: ifeq +40 -> 55
    //   18: ldc 44
    //   20: iconst_2
    //   21: new 46	java/lang/StringBuilder
    //   24: dup
    //   25: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   28: ldc 49
    //   30: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: lload_3
    //   34: invokevirtual 56	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   37: ldc 58
    //   39: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: aload_0
    //   43: getfield 16	com/tencent/biz/pubaccount/readinjoy/common/ThirdVideoManager$1$1:jdField_a_of_type_Boolean	Z
    //   46: invokevirtual 61	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   49: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   55: iconst_m1
    //   56: istore_1
    //   57: ldc 71
    //   59: astore 8
    //   61: aload_0
    //   62: getfield 16	com/tencent/biz/pubaccount/readinjoy/common/ThirdVideoManager$1$1:jdField_a_of_type_Boolean	Z
    //   65: istore 5
    //   67: new 73	osl
    //   70: dup
    //   71: invokespecial 74	osl:<init>	()V
    //   74: astore 10
    //   76: aload 10
    //   78: aload_0
    //   79: getfield 14	com/tencent/biz/pubaccount/readinjoy/common/ThirdVideoManager$1$1:jdField_a_of_type_Osg	Losg;
    //   82: getfield 77	osg:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   85: putfield 80	osl:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   88: aload_0
    //   89: getfield 16	com/tencent/biz/pubaccount/readinjoy/common/ThirdVideoManager$1$1:jdField_a_of_type_Boolean	Z
    //   92: ifeq +1186 -> 1278
    //   95: aload_0
    //   96: getfield 18	com/tencent/biz/pubaccount/readinjoy/common/ThirdVideoManager$1$1:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   99: ldc 82
    //   101: invokevirtual 88	android/os/Bundle:getByteArray	(Ljava/lang/String;)[B
    //   104: astore 9
    //   106: aload 9
    //   108: ifnull +1164 -> 1272
    //   111: aload 9
    //   113: arraylength
    //   114: iflt +1158 -> 1272
    //   117: new 90	com/tencent/mobileqq/ac/ArticleCenter$GetUrlByVidResponse
    //   120: dup
    //   121: invokespecial 91	com/tencent/mobileqq/ac/ArticleCenter$GetUrlByVidResponse:<init>	()V
    //   124: astore 11
    //   126: aload 11
    //   128: aload 9
    //   130: invokevirtual 95	com/tencent/mobileqq/ac/ArticleCenter$GetUrlByVidResponse:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   133: pop
    //   134: aload 11
    //   136: getfield 99	com/tencent/mobileqq/ac/ArticleCenter$GetUrlByVidResponse:ret_info	Lcom/tencent/mobileqq/ac/ArticleCenter$RetInfo;
    //   139: getfield 105	com/tencent/mobileqq/ac/ArticleCenter$RetInfo:ret_code	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   142: invokevirtual 111	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   145: istore_2
    //   146: aload 11
    //   148: getfield 99	com/tencent/mobileqq/ac/ArticleCenter$GetUrlByVidResponse:ret_info	Lcom/tencent/mobileqq/ac/ArticleCenter$RetInfo;
    //   151: getfield 115	com/tencent/mobileqq/ac/ArticleCenter$RetInfo:err_info	Lcom/tencent/mobileqq/pb/PBStringField;
    //   154: invokevirtual 119	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   157: astore 9
    //   159: iload_2
    //   160: ifne +1096 -> 1256
    //   163: aload 11
    //   165: getfield 123	com/tencent/mobileqq/ac/ArticleCenter$GetUrlByVidResponse:url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   168: invokevirtual 128	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   171: astore 8
    //   173: aload 8
    //   175: ifnull +13 -> 188
    //   178: aload 10
    //   180: aload 8
    //   182: invokevirtual 133	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   185: putfield 134	osl:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   188: aload 10
    //   190: iload_2
    //   191: putfield 137	osl:jdField_d_of_type_Int	I
    //   194: aload 10
    //   196: aload 11
    //   198: getfield 140	com/tencent/mobileqq/ac/ArticleCenter$GetUrlByVidResponse:video_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   201: invokevirtual 111	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   204: putfield 142	osl:jdField_a_of_type_Int	I
    //   207: aload 11
    //   209: getfield 145	com/tencent/mobileqq/ac/ArticleCenter$GetUrlByVidResponse:encode_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   212: invokevirtual 111	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   215: iconst_1
    //   216: if_icmpne +751 -> 967
    //   219: iconst_1
    //   220: istore 6
    //   222: aload 10
    //   224: iload 6
    //   226: putfield 146	osl:jdField_a_of_type_Boolean	Z
    //   229: aload 10
    //   231: aload 11
    //   233: getfield 149	com/tencent/mobileqq/ac/ArticleCenter$GetUrlByVidResponse:width	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   236: invokevirtual 111	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   239: putfield 151	osl:jdField_b_of_type_Int	I
    //   242: aload 10
    //   244: aload 11
    //   246: getfield 154	com/tencent/mobileqq/ac/ArticleCenter$GetUrlByVidResponse:height	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   249: invokevirtual 111	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   252: putfield 157	osl:jdField_c_of_type_Int	I
    //   255: aload 10
    //   257: getfield 146	osl:jdField_a_of_type_Boolean	Z
    //   260: ifeq +20 -> 280
    //   263: aload 10
    //   265: aload_0
    //   266: getfield 14	com/tencent/biz/pubaccount/readinjoy/common/ThirdVideoManager$1$1:jdField_a_of_type_Osg	Losg;
    //   269: getfield 160	osg:jdField_a_of_type_Osf	Losf;
    //   272: aload 11
    //   274: invokestatic 165	osf:a	(Losf;Lcom/tencent/mobileqq/ac/ArticleCenter$GetUrlByVidResponse;)Ljava/lang/String;
    //   277: putfield 168	osl:f	Ljava/lang/String;
    //   280: aload 11
    //   282: getfield 171	com/tencent/mobileqq/ac/ArticleCenter$GetUrlByVidResponse:json_video_detail	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   285: invokevirtual 128	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   288: astore 8
    //   290: aload 8
    //   292: ifnull +1343 -> 1635
    //   295: aload 11
    //   297: getfield 171	com/tencent/mobileqq/ac/ArticleCenter$GetUrlByVidResponse:json_video_detail	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   300: invokevirtual 128	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   303: invokevirtual 133	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   306: astore 8
    //   308: new 173	org/json/JSONObject
    //   311: dup
    //   312: aload 8
    //   314: invokespecial 176	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   317: astore 12
    //   319: aload 10
    //   321: getfield 146	osl:jdField_a_of_type_Boolean	Z
    //   324: ifeq +16 -> 340
    //   327: aload 10
    //   329: aload 12
    //   331: ldc 178
    //   333: iconst_1
    //   334: invokevirtual 182	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   337: putfield 184	osl:jdField_b_of_type_Boolean	Z
    //   340: aload 10
    //   342: aload 12
    //   344: ldc 186
    //   346: ldc 71
    //   348: invokevirtual 190	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   351: putfield 192	osl:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   354: invokestatic 42	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   357: ifeq +29 -> 386
    //   360: ldc 44
    //   362: iconst_2
    //   363: new 46	java/lang/StringBuilder
    //   366: dup
    //   367: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   370: ldc 194
    //   372: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: aload 8
    //   377: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   380: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   383: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   386: iconst_0
    //   387: istore_1
    //   388: aload 11
    //   390: getfield 198	com/tencent/mobileqq/ac/ArticleCenter$GetUrlByVidResponse:video_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   393: invokevirtual 203	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   396: ifeq +591 -> 987
    //   399: aload 11
    //   401: getfield 198	com/tencent/mobileqq/ac/ArticleCenter$GetUrlByVidResponse:video_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   404: invokevirtual 206	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   407: ifnull +580 -> 987
    //   410: aload 11
    //   412: getfield 198	com/tencent/mobileqq/ac/ArticleCenter$GetUrlByVidResponse:video_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   415: invokevirtual 206	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   418: astore 8
    //   420: aload 8
    //   422: invokeinterface 211 1 0
    //   427: ifle +560 -> 987
    //   430: aload 8
    //   432: invokeinterface 215 1 0
    //   437: astore 12
    //   439: aload 12
    //   441: invokeinterface 220 1 0
    //   446: ifeq +541 -> 987
    //   449: aload 12
    //   451: invokeinterface 224 1 0
    //   456: checkcast 226	com/tencent/mobileqq/ac/ArticleCenter$VideoInfo
    //   459: astore 13
    //   461: new 73	osl
    //   464: dup
    //   465: invokespecial 74	osl:<init>	()V
    //   468: astore 14
    //   470: aload 14
    //   472: aload_0
    //   473: getfield 14	com/tencent/biz/pubaccount/readinjoy/common/ThirdVideoManager$1$1:jdField_a_of_type_Osg	Losg;
    //   476: getfield 77	osg:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   479: putfield 80	osl:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   482: aload 13
    //   484: getfield 227	com/tencent/mobileqq/ac/ArticleCenter$VideoInfo:url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   487: invokevirtual 128	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   490: ifnull +490 -> 980
    //   493: aload 13
    //   495: getfield 227	com/tencent/mobileqq/ac/ArticleCenter$VideoInfo:url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   498: invokevirtual 128	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   501: invokevirtual 133	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   504: astore 8
    //   506: aload 14
    //   508: aload 8
    //   510: putfield 134	osl:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   513: aload 13
    //   515: getfield 228	com/tencent/mobileqq/ac/ArticleCenter$VideoInfo:encode_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   518: invokevirtual 111	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   521: iconst_1
    //   522: if_icmpne +1118 -> 1640
    //   525: iconst_1
    //   526: istore 6
    //   528: aload 14
    //   530: iload 6
    //   532: putfield 146	osl:jdField_a_of_type_Boolean	Z
    //   535: aload 13
    //   537: getfield 231	com/tencent/mobileqq/ac/ArticleCenter$VideoInfo:rate	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   540: invokevirtual 128	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   543: ifnull +1103 -> 1646
    //   546: aload 13
    //   548: getfield 231	com/tencent/mobileqq/ac/ArticleCenter$VideoInfo:rate	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   551: invokevirtual 128	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   554: invokevirtual 133	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   557: astore 8
    //   559: aload 14
    //   561: aload 8
    //   563: putfield 233	osl:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   566: aload 14
    //   568: aload 13
    //   570: getfield 234	com/tencent/mobileqq/ac/ArticleCenter$VideoInfo:width	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   573: invokevirtual 111	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   576: putfield 151	osl:jdField_b_of_type_Int	I
    //   579: aload 14
    //   581: aload 13
    //   583: getfield 235	com/tencent/mobileqq/ac/ArticleCenter$VideoInfo:height	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   586: invokevirtual 111	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   589: putfield 157	osl:jdField_c_of_type_Int	I
    //   592: aload 10
    //   594: getfield 238	osl:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   597: aload 14
    //   599: invokevirtual 244	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   602: pop
    //   603: goto -164 -> 439
    //   606: astore 8
    //   608: bipush 254
    //   610: istore_1
    //   611: aload 8
    //   613: ifnonnull +649 -> 1262
    //   616: ldc 71
    //   618: astore 8
    //   620: iconst_0
    //   621: istore 5
    //   623: iload 5
    //   625: istore 7
    //   627: aload 8
    //   629: astore 9
    //   631: iload_1
    //   632: istore_2
    //   633: invokestatic 42	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   636: ifeq +113 -> 749
    //   639: ldc 44
    //   641: iconst_2
    //   642: new 46	java/lang/StringBuilder
    //   645: dup
    //   646: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   649: ldc 246
    //   651: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   654: aload 10
    //   656: getfield 142	osl:jdField_a_of_type_Int	I
    //   659: invokevirtual 249	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   662: ldc 251
    //   664: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   667: aload 10
    //   669: getfield 146	osl:jdField_a_of_type_Boolean	Z
    //   672: invokevirtual 61	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   675: ldc 253
    //   677: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   680: aload 10
    //   682: getfield 134	osl:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   685: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   688: ldc 255
    //   690: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   693: aload 10
    //   695: getfield 233	osl:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   698: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   701: ldc_w 257
    //   704: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   707: iload_1
    //   708: invokevirtual 249	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   711: ldc_w 259
    //   714: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   717: aload 8
    //   719: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   722: ldc_w 261
    //   725: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   728: iload 5
    //   730: invokevirtual 61	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   733: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   736: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   739: iload_1
    //   740: istore_2
    //   741: aload 8
    //   743: astore 9
    //   745: iload 5
    //   747: istore 7
    //   749: aload_0
    //   750: getfield 14	com/tencent/biz/pubaccount/readinjoy/common/ThirdVideoManager$1$1:jdField_a_of_type_Osg	Losg;
    //   753: getfield 264	osg:jdField_a_of_type_Osi	Losi;
    //   756: ifnull +765 -> 1521
    //   759: aload 10
    //   761: getfield 142	osl:jdField_a_of_type_Int	I
    //   764: ifne +538 -> 1302
    //   767: aload 10
    //   769: getfield 134	osl:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   772: invokestatic 270	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   775: ifne +854 -> 1629
    //   778: aload 10
    //   780: invokestatic 273	osf:a	(Losl;)V
    //   783: iconst_1
    //   784: istore 5
    //   786: iload 5
    //   788: ifeq +539 -> 1327
    //   791: aload_0
    //   792: getfield 14	com/tencent/biz/pubaccount/readinjoy/common/ThirdVideoManager$1$1:jdField_a_of_type_Osg	Losg;
    //   795: getfield 264	osg:jdField_a_of_type_Osi	Losi;
    //   798: aload 10
    //   800: invokeinterface 276 2 0
    //   805: aload_0
    //   806: getfield 14	com/tencent/biz/pubaccount/readinjoy/common/ThirdVideoManager$1$1:jdField_a_of_type_Osg	Losg;
    //   809: getfield 160	osg:jdField_a_of_type_Osf	Losf;
    //   812: invokestatic 279	osf:a	(Losf;)Ljava/lang/Object;
    //   815: astore 8
    //   817: aload 8
    //   819: monitorenter
    //   820: aload_0
    //   821: getfield 14	com/tencent/biz/pubaccount/readinjoy/common/ThirdVideoManager$1$1:jdField_a_of_type_Osg	Losg;
    //   824: getfield 160	osg:jdField_a_of_type_Osf	Losf;
    //   827: invokestatic 282	osf:a	(Losf;)Ljava/util/ArrayList;
    //   830: aload_0
    //   831: getfield 14	com/tencent/biz/pubaccount/readinjoy/common/ThirdVideoManager$1$1:jdField_a_of_type_Osg	Losg;
    //   834: getfield 77	osg:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   837: invokevirtual 285	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   840: istore 6
    //   842: iload 6
    //   844: ifeq +24 -> 868
    //   847: aload_0
    //   848: getfield 14	com/tencent/biz/pubaccount/readinjoy/common/ThirdVideoManager$1$1:jdField_a_of_type_Osg	Losg;
    //   851: getfield 160	osg:jdField_a_of_type_Osf	Losf;
    //   854: invokestatic 282	osf:a	(Losf;)Ljava/util/ArrayList;
    //   857: aload_0
    //   858: getfield 14	com/tencent/biz/pubaccount/readinjoy/common/ThirdVideoManager$1$1:jdField_a_of_type_Osg	Losg;
    //   861: getfield 77	osg:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   864: invokevirtual 288	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
    //   867: pop
    //   868: aload 8
    //   870: monitorexit
    //   871: iconst_0
    //   872: istore 6
    //   874: new 290	qnv
    //   877: dup
    //   878: invokespecial 291	qnv:<init>	()V
    //   881: astore 8
    //   883: aload 8
    //   885: iload 5
    //   887: putfield 292	qnv:jdField_a_of_type_Boolean	Z
    //   890: aload 8
    //   892: aload_0
    //   893: getfield 14	com/tencent/biz/pubaccount/readinjoy/common/ThirdVideoManager$1$1:jdField_a_of_type_Osg	Losg;
    //   896: getfield 77	osg:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   899: putfield 293	qnv:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   902: aload_0
    //   903: getfield 14	com/tencent/biz/pubaccount/readinjoy/common/ThirdVideoManager$1$1:jdField_a_of_type_Osg	Losg;
    //   906: getfield 160	osg:jdField_a_of_type_Osf	Losf;
    //   909: lload_3
    //   910: invokestatic 299	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   913: putfield 302	osf:a	Ljava/lang/Long;
    //   916: aload 8
    //   918: lload_3
    //   919: putfield 303	qnv:jdField_a_of_type_Long	J
    //   922: aload 8
    //   924: iload_2
    //   925: i2l
    //   926: putfield 305	qnv:jdField_b_of_type_Long	J
    //   929: aload 8
    //   931: aload 9
    //   933: putfield 306	qnv:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   936: aload 8
    //   938: iload 6
    //   940: putfield 307	qnv:jdField_b_of_type_Boolean	Z
    //   943: aload_0
    //   944: getfield 14	com/tencent/biz/pubaccount/readinjoy/common/ThirdVideoManager$1$1:jdField_a_of_type_Osg	Losg;
    //   947: getfield 310	osg:jdField_a_of_type_MqqAppAppRuntime	Lmqq/app/AppRuntime;
    //   950: invokevirtual 316	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   953: invokestatic 320	ors:a	()Ljava/lang/String;
    //   956: iload 7
    //   958: aload 8
    //   960: invokevirtual 323	qnv:a	()Ljava/util/HashMap;
    //   963: invokestatic 326	ors:c	(Landroid/content/Context;Ljava/lang/String;ZLjava/util/HashMap;)V
    //   966: return
    //   967: iconst_0
    //   968: istore 6
    //   970: goto -748 -> 222
    //   973: astore 8
    //   975: iconst_1
    //   976: istore_1
    //   977: goto -589 -> 388
    //   980: ldc 71
    //   982: astore 8
    //   984: goto -478 -> 506
    //   987: aload 10
    //   989: getfield 146	osl:jdField_a_of_type_Boolean	Z
    //   992: ifeq +74 -> 1066
    //   995: new 328	java/util/HashMap
    //   998: dup
    //   999: invokespecial 329	java/util/HashMap:<init>	()V
    //   1002: astore 12
    //   1004: iload_1
    //   1005: ifeq +657 -> 1662
    //   1008: ldc_w 331
    //   1011: astore 8
    //   1013: aload 12
    //   1015: ldc_w 333
    //   1018: aload 8
    //   1020: invokevirtual 337	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1023: pop
    //   1024: aload 11
    //   1026: getfield 171	com/tencent/mobileqq/ac/ArticleCenter$GetUrlByVidResponse:json_video_detail	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1029: invokevirtual 128	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1032: ifnull +210 -> 1242
    //   1035: aload 12
    //   1037: ldc_w 339
    //   1040: aload 11
    //   1042: getfield 171	com/tencent/mobileqq/ac/ArticleCenter$GetUrlByVidResponse:json_video_detail	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1045: invokevirtual 128	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1048: invokevirtual 133	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1051: invokevirtual 337	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1054: pop
    //   1055: invokestatic 345	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1058: invokestatic 320	ors:a	()Ljava/lang/String;
    //   1061: aload 12
    //   1063: invokestatic 348	ors:a	(Landroid/content/Context;Ljava/lang/String;Ljava/util/HashMap;)V
    //   1066: aconst_null
    //   1067: astore 8
    //   1069: aload 11
    //   1071: getfield 171	com/tencent/mobileqq/ac/ArticleCenter$GetUrlByVidResponse:json_video_detail	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1074: invokevirtual 128	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1077: ifnull +16 -> 1093
    //   1080: aload 11
    //   1082: getfield 171	com/tencent/mobileqq/ac/ArticleCenter$GetUrlByVidResponse:json_video_detail	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1085: invokevirtual 128	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1088: invokevirtual 133	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1091: astore 8
    //   1093: aconst_null
    //   1094: aconst_null
    //   1095: ldc_w 350
    //   1098: ldc_w 350
    //   1101: iconst_0
    //   1102: iconst_0
    //   1103: iconst_0
    //   1104: invokestatic 355	rae:a	(Z)Ljava/lang/String;
    //   1107: ldc_w 357
    //   1110: invokestatic 362	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1113: aload 10
    //   1115: getfield 192	osl:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   1118: aload 8
    //   1120: iconst_0
    //   1121: invokestatic 367	nrt:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   1124: new 173	org/json/JSONObject
    //   1127: dup
    //   1128: invokespecial 368	org/json/JSONObject:<init>	()V
    //   1131: astore 8
    //   1133: aload 8
    //   1135: ldc_w 370
    //   1138: aload 10
    //   1140: getfield 80	osl:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1143: invokevirtual 373	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1146: pop
    //   1147: aload 8
    //   1149: ldc_w 375
    //   1152: aload 10
    //   1154: getfield 146	osl:jdField_a_of_type_Boolean	Z
    //   1157: invokevirtual 378	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   1160: pop
    //   1161: aload 8
    //   1163: ldc_w 379
    //   1166: aload 10
    //   1168: getfield 134	osl:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1171: invokevirtual 373	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1174: pop
    //   1175: aload 8
    //   1177: ldc_w 381
    //   1180: aload 10
    //   1182: getfield 168	osl:f	Ljava/lang/String;
    //   1185: invokevirtual 373	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1188: pop
    //   1189: aconst_null
    //   1190: aconst_null
    //   1191: ldc_w 383
    //   1194: ldc_w 383
    //   1197: iconst_0
    //   1198: iconst_0
    //   1199: ldc 71
    //   1201: ldc 71
    //   1203: ldc 71
    //   1205: aload 8
    //   1207: invokevirtual 384	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1210: iconst_0
    //   1211: invokestatic 367	nrt:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   1214: aload 11
    //   1216: getfield 385	com/tencent/mobileqq/ac/ArticleCenter$GetUrlByVidResponse:rate	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1219: invokevirtual 128	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1222: astore 8
    //   1224: aload 8
    //   1226: ifnull +427 -> 1653
    //   1229: aload 10
    //   1231: aload 8
    //   1233: invokevirtual 133	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1236: putfield 233	osl:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   1239: goto +414 -> 1653
    //   1242: aload 12
    //   1244: ldc_w 339
    //   1247: ldc 71
    //   1249: invokevirtual 337	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1252: pop
    //   1253: goto -198 -> 1055
    //   1256: iconst_0
    //   1257: istore 5
    //   1259: goto +394 -> 1653
    //   1262: aload 8
    //   1264: invokevirtual 388	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1267: astore 8
    //   1269: goto -649 -> 620
    //   1272: iconst_0
    //   1273: istore 5
    //   1275: goto -652 -> 623
    //   1278: aload_0
    //   1279: getfield 18	com/tencent/biz/pubaccount/readinjoy/common/ThirdVideoManager$1$1:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   1282: ldc_w 390
    //   1285: bipush 253
    //   1287: invokevirtual 394	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   1290: istore_2
    //   1291: iload 5
    //   1293: istore 7
    //   1295: aload 8
    //   1297: astore 9
    //   1299: goto -550 -> 749
    //   1302: aload 10
    //   1304: getfield 134	osl:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1307: invokestatic 270	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1310: ifne +319 -> 1629
    //   1313: iconst_1
    //   1314: istore 5
    //   1316: goto -530 -> 786
    //   1319: astore 9
    //   1321: aload 8
    //   1323: monitorexit
    //   1324: aload 9
    //   1326: athrow
    //   1327: aload_0
    //   1328: getfield 14	com/tencent/biz/pubaccount/readinjoy/common/ThirdVideoManager$1$1:jdField_a_of_type_Osg	Losg;
    //   1331: getfield 160	osg:jdField_a_of_type_Osf	Losf;
    //   1334: invokestatic 279	osf:a	(Losf;)Ljava/lang/Object;
    //   1337: astore 8
    //   1339: aload 8
    //   1341: monitorenter
    //   1342: aload_0
    //   1343: getfield 14	com/tencent/biz/pubaccount/readinjoy/common/ThirdVideoManager$1$1:jdField_a_of_type_Osg	Losg;
    //   1346: getfield 160	osg:jdField_a_of_type_Osf	Losf;
    //   1349: invokestatic 282	osf:a	(Losf;)Ljava/util/ArrayList;
    //   1352: aload_0
    //   1353: getfield 14	com/tencent/biz/pubaccount/readinjoy/common/ThirdVideoManager$1$1:jdField_a_of_type_Osg	Losg;
    //   1356: getfield 77	osg:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1359: invokevirtual 285	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   1362: ifeq +63 -> 1425
    //   1365: aload_0
    //   1366: getfield 14	com/tencent/biz/pubaccount/readinjoy/common/ThirdVideoManager$1$1:jdField_a_of_type_Osg	Losg;
    //   1369: getfield 264	osg:jdField_a_of_type_Osi	Losi;
    //   1372: aload 10
    //   1374: invokeinterface 276 2 0
    //   1379: aload_0
    //   1380: getfield 14	com/tencent/biz/pubaccount/readinjoy/common/ThirdVideoManager$1$1:jdField_a_of_type_Osg	Losg;
    //   1383: getfield 160	osg:jdField_a_of_type_Osf	Losf;
    //   1386: invokestatic 282	osf:a	(Losf;)Ljava/util/ArrayList;
    //   1389: aload_0
    //   1390: getfield 14	com/tencent/biz/pubaccount/readinjoy/common/ThirdVideoManager$1$1:jdField_a_of_type_Osg	Losg;
    //   1393: getfield 77	osg:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1396: invokevirtual 288	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
    //   1399: pop
    //   1400: iconst_0
    //   1401: istore 6
    //   1403: aload 8
    //   1405: monitorexit
    //   1406: goto -532 -> 874
    //   1409: astore 9
    //   1411: aload 8
    //   1413: monitorexit
    //   1414: aload 9
    //   1416: athrow
    //   1417: astore 10
    //   1419: iconst_0
    //   1420: istore 6
    //   1422: goto -19 -> 1403
    //   1425: invokestatic 42	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1428: ifeq +35 -> 1463
    //   1431: ldc 44
    //   1433: iconst_2
    //   1434: new 46	java/lang/StringBuilder
    //   1437: dup
    //   1438: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   1441: ldc_w 396
    //   1444: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1447: aload_0
    //   1448: getfield 14	com/tencent/biz/pubaccount/readinjoy/common/ThirdVideoManager$1$1:jdField_a_of_type_Osg	Losg;
    //   1451: getfield 77	osg:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1454: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1457: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1460: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1463: aload_0
    //   1464: getfield 14	com/tencent/biz/pubaccount/readinjoy/common/ThirdVideoManager$1$1:jdField_a_of_type_Osg	Losg;
    //   1467: getfield 160	osg:jdField_a_of_type_Osf	Losf;
    //   1470: aload_0
    //   1471: getfield 14	com/tencent/biz/pubaccount/readinjoy/common/ThirdVideoManager$1$1:jdField_a_of_type_Osg	Losg;
    //   1474: getfield 77	osg:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1477: aload_0
    //   1478: getfield 14	com/tencent/biz/pubaccount/readinjoy/common/ThirdVideoManager$1$1:jdField_a_of_type_Osg	Losg;
    //   1481: getfield 397	osg:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1484: aload_0
    //   1485: getfield 14	com/tencent/biz/pubaccount/readinjoy/common/ThirdVideoManager$1$1:jdField_a_of_type_Osg	Losg;
    //   1488: getfield 264	osg:jdField_a_of_type_Osi	Losi;
    //   1491: invokevirtual 400	osf:a	(Ljava/lang/String;Ljava/lang/String;Losi;)V
    //   1494: aload_0
    //   1495: getfield 14	com/tencent/biz/pubaccount/readinjoy/common/ThirdVideoManager$1$1:jdField_a_of_type_Osg	Losg;
    //   1498: getfield 160	osg:jdField_a_of_type_Osf	Losf;
    //   1501: invokestatic 282	osf:a	(Losf;)Ljava/util/ArrayList;
    //   1504: aload_0
    //   1505: getfield 14	com/tencent/biz/pubaccount/readinjoy/common/ThirdVideoManager$1$1:jdField_a_of_type_Osg	Losg;
    //   1508: getfield 77	osg:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1511: invokevirtual 244	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1514: pop
    //   1515: iconst_1
    //   1516: istore 6
    //   1518: goto -115 -> 1403
    //   1521: invokestatic 42	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1524: ifeq +12 -> 1536
    //   1527: ldc 44
    //   1529: iconst_2
    //   1530: ldc_w 402
    //   1533: invokestatic 405	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1536: aload_0
    //   1537: getfield 14	com/tencent/biz/pubaccount/readinjoy/common/ThirdVideoManager$1$1:jdField_a_of_type_Osg	Losg;
    //   1540: getfield 160	osg:jdField_a_of_type_Osf	Losf;
    //   1543: invokestatic 279	osf:a	(Losf;)Ljava/lang/Object;
    //   1546: astore 8
    //   1548: aload 8
    //   1550: monitorenter
    //   1551: aload_0
    //   1552: getfield 14	com/tencent/biz/pubaccount/readinjoy/common/ThirdVideoManager$1$1:jdField_a_of_type_Osg	Losg;
    //   1555: getfield 160	osg:jdField_a_of_type_Osf	Losf;
    //   1558: invokestatic 282	osf:a	(Losf;)Ljava/util/ArrayList;
    //   1561: aload_0
    //   1562: getfield 14	com/tencent/biz/pubaccount/readinjoy/common/ThirdVideoManager$1$1:jdField_a_of_type_Osg	Losg;
    //   1565: getfield 77	osg:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1568: invokevirtual 285	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   1571: istore 5
    //   1573: iload 5
    //   1575: ifeq +24 -> 1599
    //   1578: aload_0
    //   1579: getfield 14	com/tencent/biz/pubaccount/readinjoy/common/ThirdVideoManager$1$1:jdField_a_of_type_Osg	Losg;
    //   1582: getfield 160	osg:jdField_a_of_type_Osf	Losf;
    //   1585: invokestatic 282	osf:a	(Losf;)Ljava/util/ArrayList;
    //   1588: aload_0
    //   1589: getfield 14	com/tencent/biz/pubaccount/readinjoy/common/ThirdVideoManager$1$1:jdField_a_of_type_Osg	Losg;
    //   1592: getfield 77	osg:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1595: invokevirtual 288	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
    //   1598: pop
    //   1599: aload 8
    //   1601: monitorexit
    //   1602: iconst_0
    //   1603: istore 6
    //   1605: iconst_0
    //   1606: istore 5
    //   1608: goto -734 -> 874
    //   1611: astore 9
    //   1613: aload 8
    //   1615: monitorexit
    //   1616: aload 9
    //   1618: athrow
    //   1619: astore 10
    //   1621: goto -22 -> 1599
    //   1624: astore 10
    //   1626: goto -758 -> 868
    //   1629: iconst_0
    //   1630: istore 5
    //   1632: goto -846 -> 786
    //   1635: iconst_0
    //   1636: istore_1
    //   1637: goto -1249 -> 388
    //   1640: iconst_0
    //   1641: istore 6
    //   1643: goto -1115 -> 528
    //   1646: ldc 71
    //   1648: astore 8
    //   1650: goto -1091 -> 559
    //   1653: aload 9
    //   1655: astore 8
    //   1657: iload_2
    //   1658: istore_1
    //   1659: goto -1036 -> 623
    //   1662: ldc_w 407
    //   1665: astore 8
    //   1667: goto -654 -> 1013
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1670	0	this	1
    //   56	1603	1	i	int
    //   145	1513	2	j	int
    //   11	908	3	l	long
    //   65	1566	5	bool1	boolean
    //   220	1422	6	bool2	boolean
    //   625	669	7	bool3	boolean
    //   59	503	8	localObject1	Object
    //   606	6	8	localException1	java.lang.Exception
    //   973	1	8	localException2	java.lang.Exception
    //   104	1194	9	localObject4	Object
    //   1319	6	9	localObject5	Object
    //   1409	6	9	localObject6	Object
    //   1611	43	9	localObject7	Object
    //   74	1299	10	localosl1	osl
    //   1417	1	10	localException3	java.lang.Exception
    //   1619	1	10	localException4	java.lang.Exception
    //   1624	1	10	localException5	java.lang.Exception
    //   124	1091	11	localGetUrlByVidResponse	com.tencent.mobileqq.ac.ArticleCenter.GetUrlByVidResponse
    //   317	926	12	localObject8	Object
    //   459	123	13	localVideoInfo	com.tencent.mobileqq.ac.ArticleCenter.VideoInfo
    //   468	130	14	localosl2	osl
    // Exception table:
    //   from	to	target	type
    //   117	159	606	java/lang/Exception
    //   163	173	606	java/lang/Exception
    //   178	188	606	java/lang/Exception
    //   188	219	606	java/lang/Exception
    //   222	280	606	java/lang/Exception
    //   280	290	606	java/lang/Exception
    //   388	439	606	java/lang/Exception
    //   439	506	606	java/lang/Exception
    //   506	525	606	java/lang/Exception
    //   528	559	606	java/lang/Exception
    //   559	603	606	java/lang/Exception
    //   987	1004	606	java/lang/Exception
    //   1013	1055	606	java/lang/Exception
    //   1055	1066	606	java/lang/Exception
    //   1069	1093	606	java/lang/Exception
    //   1093	1224	606	java/lang/Exception
    //   1229	1239	606	java/lang/Exception
    //   1242	1253	606	java/lang/Exception
    //   295	340	973	java/lang/Exception
    //   340	386	973	java/lang/Exception
    //   820	842	1319	finally
    //   847	868	1319	finally
    //   868	871	1319	finally
    //   1321	1324	1319	finally
    //   1342	1379	1409	finally
    //   1379	1400	1409	finally
    //   1403	1406	1409	finally
    //   1411	1414	1409	finally
    //   1425	1463	1409	finally
    //   1463	1515	1409	finally
    //   1379	1400	1417	java/lang/Exception
    //   1551	1573	1611	finally
    //   1578	1599	1611	finally
    //   1599	1602	1611	finally
    //   1613	1616	1611	finally
    //   1578	1599	1619	java/lang/Exception
    //   847	868	1624	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.ThirdVideoManager.1.1
 * JD-Core Version:    0.7.0.1
 */