package com.tencent.mobileqq.activity.shortvideo;

import ajxv;
import com.tencent.biz.qqstory.database.PublishVideoEntry;

public class EncodeVideoTask$2$1
  implements Runnable
{
  public EncodeVideoTask$2$1(ajxv paramajxv, String paramString, PublishVideoEntry paramPublishVideoEntry) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 9
    //   3: iconst_0
    //   4: istore_3
    //   5: iconst_0
    //   6: istore_1
    //   7: bipush 249
    //   9: istore_2
    //   10: aload_0
    //   11: getfield 16	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   14: iconst_0
    //   15: iconst_1
    //   16: invokestatic 34	bhnu:a	(Ljava/lang/String;ZZ)V
    //   19: aload_0
    //   20: getfield 14	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_Ajxv	Lajxv;
    //   23: getfield 39	ajxv:a	Lajxt;
    //   26: invokestatic 44	ajxt:a	(Lajxt;)Ljava/lang/String;
    //   29: invokestatic 50	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   32: ifeq +21 -> 53
    //   35: aload_0
    //   36: getfield 14	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_Ajxv	Lajxv;
    //   39: getfield 39	ajxv:a	Lajxt;
    //   42: aload_0
    //   43: getfield 18	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry	Lcom/tencent/biz/qqstory/database/PublishVideoEntry;
    //   46: getfield 55	com/tencent/biz/qqstory/database/PublishVideoEntry:thumbPath	Ljava/lang/String;
    //   49: invokestatic 58	ajxt:a	(Lajxt;Ljava/lang/String;)Ljava/lang/String;
    //   52: pop
    //   53: aload_0
    //   54: getfield 14	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_Ajxv	Lajxv;
    //   57: getfield 39	ajxv:a	Lajxt;
    //   60: invokestatic 61	ajxt:a	(Lajxt;)Lajxz;
    //   63: ifnull +327 -> 390
    //   66: aload_0
    //   67: getfield 14	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_Ajxv	Lajxv;
    //   70: getfield 39	ajxv:a	Lajxt;
    //   73: aload_0
    //   74: getfield 14	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_Ajxv	Lajxv;
    //   77: getfield 39	ajxv:a	Lajxt;
    //   80: invokestatic 61	ajxt:a	(Lajxt;)Lajxz;
    //   83: getfield 66	ajxz:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   86: invokestatic 68	ajxt:b	(Lajxt;Ljava/lang/String;)Ljava/lang/String;
    //   89: pop
    //   90: aload_0
    //   91: getfield 14	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_Ajxv	Lajxv;
    //   94: getfield 39	ajxv:a	Lajxt;
    //   97: astore 7
    //   99: aload_0
    //   100: getfield 14	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_Ajxv	Lajxv;
    //   103: getfield 39	ajxv:a	Lajxt;
    //   106: invokestatic 61	ajxt:a	(Lajxt;)Lajxz;
    //   109: getfield 71	ajxz:jdField_a_of_type_ArrayOfByte	[B
    //   112: ifnonnull +260 -> 372
    //   115: aload_0
    //   116: getfield 14	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_Ajxv	Lajxv;
    //   119: getfield 39	ajxv:a	Lajxt;
    //   122: invokestatic 73	ajxt:b	(Lajxt;)Ljava/lang/String;
    //   125: invokestatic 79	com/qq/taf/jce/HexUtil:hexStr2Bytes	(Ljava/lang/String;)[B
    //   128: astore 6
    //   130: aload 7
    //   132: aload 6
    //   134: invokestatic 82	ajxt:a	(Lajxt;[B)[B
    //   137: pop
    //   138: aload_0
    //   139: getfield 14	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_Ajxv	Lajxv;
    //   142: getfield 39	ajxv:a	Lajxt;
    //   145: aload_0
    //   146: getfield 14	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_Ajxv	Lajxv;
    //   149: getfield 39	ajxv:a	Lajxt;
    //   152: invokestatic 61	ajxt:a	(Lajxt;)Lajxz;
    //   155: getfield 85	ajxz:jdField_a_of_type_Int	I
    //   158: invokestatic 88	ajxt:a	(Lajxt;I)I
    //   161: pop
    //   162: aload_0
    //   163: getfield 14	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_Ajxv	Lajxv;
    //   166: getfield 39	ajxv:a	Lajxt;
    //   169: aload_0
    //   170: getfield 14	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_Ajxv	Lajxv;
    //   173: getfield 39	ajxv:a	Lajxt;
    //   176: invokestatic 61	ajxt:a	(Lajxt;)Lajxz;
    //   179: getfield 90	ajxz:jdField_b_of_type_Int	I
    //   182: invokestatic 92	ajxt:b	(Lajxt;I)I
    //   185: pop
    //   186: aload_0
    //   187: getfield 14	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_Ajxv	Lajxv;
    //   190: getfield 39	ajxv:a	Lajxt;
    //   193: aload_0
    //   194: getfield 16	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   197: invokestatic 95	ajxt:c	(Lajxt;Ljava/lang/String;)Ljava/lang/String;
    //   200: pop
    //   201: aload_0
    //   202: getfield 14	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_Ajxv	Lajxv;
    //   205: getfield 39	ajxv:a	Lajxt;
    //   208: invokestatic 97	ajxt:c	(Lajxt;)Ljava/lang/String;
    //   211: invokestatic 50	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   214: ifne +981 -> 1195
    //   217: new 99	java/io/File
    //   220: dup
    //   221: aload_0
    //   222: getfield 14	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_Ajxv	Lajxv;
    //   225: getfield 39	ajxv:a	Lajxt;
    //   228: invokestatic 97	ajxt:c	(Lajxt;)Ljava/lang/String;
    //   231: invokespecial 102	java/io/File:<init>	(Ljava/lang/String;)V
    //   234: astore 6
    //   236: iload_1
    //   237: istore_2
    //   238: aload 6
    //   240: invokevirtual 106	java/io/File:exists	()Z
    //   243: ifeq +85 -> 328
    //   246: new 108	java/io/FileInputStream
    //   249: dup
    //   250: aload_0
    //   251: getfield 14	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_Ajxv	Lajxv;
    //   254: getfield 39	ajxv:a	Lajxt;
    //   257: invokestatic 97	ajxt:c	(Lajxt;)Ljava/lang/String;
    //   260: invokespecial 109	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   263: astore 7
    //   265: aload 6
    //   267: invokevirtual 113	java/io/File:length	()J
    //   270: lstore 4
    //   272: aload_0
    //   273: getfield 14	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_Ajxv	Lajxv;
    //   276: getfield 39	ajxv:a	Lajxt;
    //   279: aload 7
    //   281: lload 4
    //   283: invokestatic 119	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   286: invokestatic 121	ajxt:b	(Lajxt;[B)[B
    //   289: pop
    //   290: aload_0
    //   291: getfield 14	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_Ajxv	Lajxv;
    //   294: getfield 39	ajxv:a	Lajxt;
    //   297: aload_0
    //   298: getfield 14	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_Ajxv	Lajxv;
    //   301: getfield 39	ajxv:a	Lajxt;
    //   304: invokestatic 124	ajxt:b	(Lajxt;)[B
    //   307: invokestatic 128	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   310: invokestatic 131	ajxt:d	(Lajxt;Ljava/lang/String;)Ljava/lang/String;
    //   313: pop
    //   314: iload_1
    //   315: istore_2
    //   316: aload 7
    //   318: ifnull +10 -> 328
    //   321: aload 7
    //   323: invokevirtual 134	java/io/FileInputStream:close	()V
    //   326: iload_1
    //   327: istore_2
    //   328: iload_2
    //   329: ifeq +872 -> 1201
    //   332: invokestatic 139	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   335: ifeq +28 -> 363
    //   338: ldc 141
    //   340: iconst_2
    //   341: new 143	java/lang/StringBuilder
    //   344: dup
    //   345: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   348: ldc 146
    //   350: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   353: iload_2
    //   354: invokevirtual 153	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   357: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   360: invokestatic 161	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   363: aload_0
    //   364: getfield 14	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_Ajxv	Lajxv;
    //   367: iload_2
    //   368: invokevirtual 164	ajxv:a	(I)V
    //   371: return
    //   372: aload_0
    //   373: getfield 14	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_Ajxv	Lajxv;
    //   376: getfield 39	ajxv:a	Lajxt;
    //   379: invokestatic 61	ajxt:a	(Lajxt;)Lajxz;
    //   382: getfield 71	ajxz:jdField_a_of_type_ArrayOfByte	[B
    //   385: astore 6
    //   387: goto -257 -> 130
    //   390: aload_0
    //   391: getfield 14	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_Ajxv	Lajxv;
    //   394: getfield 39	ajxv:a	Lajxt;
    //   397: aload_0
    //   398: getfield 18	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry	Lcom/tencent/biz/qqstory/database/PublishVideoEntry;
    //   401: getfield 167	com/tencent/biz/qqstory/database/PublishVideoEntry:videoWidth	I
    //   404: invokestatic 88	ajxt:a	(Lajxt;I)I
    //   407: pop
    //   408: aload_0
    //   409: getfield 14	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_Ajxv	Lajxv;
    //   412: getfield 39	ajxv:a	Lajxt;
    //   415: aload_0
    //   416: getfield 18	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry	Lcom/tencent/biz/qqstory/database/PublishVideoEntry;
    //   419: getfield 170	com/tencent/biz/qqstory/database/PublishVideoEntry:videoHeight	I
    //   422: invokestatic 92	ajxt:b	(Lajxt;I)I
    //   425: pop
    //   426: new 99	java/io/File
    //   429: dup
    //   430: aload_0
    //   431: getfield 14	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_Ajxv	Lajxv;
    //   434: getfield 39	ajxv:a	Lajxt;
    //   437: invokestatic 44	ajxt:a	(Lajxt;)Ljava/lang/String;
    //   440: invokespecial 102	java/io/File:<init>	(Ljava/lang/String;)V
    //   443: astore 8
    //   445: aload 8
    //   447: invokevirtual 106	java/io/File:exists	()Z
    //   450: ifeq +616 -> 1066
    //   453: new 108	java/io/FileInputStream
    //   456: dup
    //   457: aload_0
    //   458: getfield 14	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_Ajxv	Lajxv;
    //   461: getfield 39	ajxv:a	Lajxt;
    //   464: invokestatic 44	ajxt:a	(Lajxt;)Ljava/lang/String;
    //   467: invokespecial 109	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   470: astore 7
    //   472: aload 7
    //   474: astore 6
    //   476: aload 8
    //   478: invokevirtual 113	java/io/File:length	()J
    //   481: lstore 4
    //   483: aload 7
    //   485: astore 6
    //   487: aload_0
    //   488: getfield 14	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_Ajxv	Lajxv;
    //   491: getfield 39	ajxv:a	Lajxt;
    //   494: aload 7
    //   496: lload 4
    //   498: invokestatic 119	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   501: invokestatic 82	ajxt:a	(Lajxt;[B)[B
    //   504: pop
    //   505: aload 7
    //   507: astore 6
    //   509: aload_0
    //   510: getfield 14	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_Ajxv	Lajxv;
    //   513: getfield 39	ajxv:a	Lajxt;
    //   516: aload_0
    //   517: getfield 14	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_Ajxv	Lajxv;
    //   520: getfield 39	ajxv:a	Lajxt;
    //   523: invokestatic 172	ajxt:a	(Lajxt;)[B
    //   526: invokestatic 128	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   529: invokestatic 68	ajxt:b	(Lajxt;Ljava/lang/String;)Ljava/lang/String;
    //   532: pop
    //   533: aload 7
    //   535: ifnull +8 -> 543
    //   538: aload 7
    //   540: invokevirtual 134	java/io/FileInputStream:close	()V
    //   543: aload_0
    //   544: getfield 14	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_Ajxv	Lajxv;
    //   547: getfield 39	ajxv:a	Lajxt;
    //   550: invokestatic 73	ajxt:b	(Lajxt;)Ljava/lang/String;
    //   553: invokestatic 50	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   556: ifeq +33 -> 589
    //   559: invokestatic 139	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   562: ifeq +11 -> 573
    //   565: ldc 141
    //   567: iconst_2
    //   568: ldc 174
    //   570: invokestatic 177	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   573: bipush 250
    //   575: istore_1
    //   576: goto -390 -> 186
    //   579: astore 6
    //   581: aload 6
    //   583: invokevirtual 180	java/io/IOException:printStackTrace	()V
    //   586: goto -43 -> 543
    //   589: aload_0
    //   590: getfield 14	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_Ajxv	Lajxv;
    //   593: getfield 39	ajxv:a	Lajxt;
    //   596: invokestatic 73	ajxt:b	(Lajxt;)Ljava/lang/String;
    //   599: ldc 182
    //   601: invokestatic 187	com/tencent/mobileqq/shortvideo/ShortVideoUtils:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   604: astore 6
    //   606: aload_0
    //   607: getfield 14	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_Ajxv	Lajxv;
    //   610: getfield 39	ajxv:a	Lajxt;
    //   613: invokestatic 44	ajxt:a	(Lajxt;)Ljava/lang/String;
    //   616: aload 6
    //   618: invokestatic 192	bdcs:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   621: ifeq +21 -> 642
    //   624: aload_0
    //   625: getfield 14	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_Ajxv	Lajxv;
    //   628: getfield 39	ajxv:a	Lajxt;
    //   631: aload 6
    //   633: invokestatic 58	ajxt:a	(Lajxt;Ljava/lang/String;)Ljava/lang/String;
    //   636: pop
    //   637: iconst_0
    //   638: istore_1
    //   639: goto -63 -> 576
    //   642: aload 6
    //   644: invokestatic 195	bdcs:b	(Ljava/lang/String;)Z
    //   647: ifne +951 -> 1598
    //   650: iload_2
    //   651: istore_1
    //   652: invokestatic 139	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   655: ifeq -79 -> 576
    //   658: ldc 141
    //   660: iconst_2
    //   661: new 143	java/lang/StringBuilder
    //   664: dup
    //   665: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   668: ldc 197
    //   670: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   673: aload_0
    //   674: getfield 14	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_Ajxv	Lajxv;
    //   677: getfield 39	ajxv:a	Lajxt;
    //   680: invokestatic 44	ajxt:a	(Lajxt;)Ljava/lang/String;
    //   683: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   686: ldc 199
    //   688: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   691: aload 6
    //   693: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   696: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   699: invokestatic 177	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   702: iload_2
    //   703: istore_1
    //   704: goto -128 -> 576
    //   707: astore 8
    //   709: aconst_null
    //   710: astore 7
    //   712: aload 7
    //   714: astore 6
    //   716: aload 8
    //   718: invokevirtual 200	java/io/FileNotFoundException:printStackTrace	()V
    //   721: aload 7
    //   723: ifnull +8 -> 731
    //   726: aload 7
    //   728: invokevirtual 134	java/io/FileInputStream:close	()V
    //   731: aload_0
    //   732: getfield 14	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_Ajxv	Lajxv;
    //   735: getfield 39	ajxv:a	Lajxt;
    //   738: invokestatic 73	ajxt:b	(Lajxt;)Ljava/lang/String;
    //   741: invokestatic 50	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   744: ifeq +33 -> 777
    //   747: invokestatic 139	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   750: ifeq +11 -> 761
    //   753: ldc 141
    //   755: iconst_2
    //   756: ldc 174
    //   758: invokestatic 177	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   761: bipush 250
    //   763: istore_1
    //   764: goto -188 -> 576
    //   767: astore 6
    //   769: aload 6
    //   771: invokevirtual 180	java/io/IOException:printStackTrace	()V
    //   774: goto -43 -> 731
    //   777: aload_0
    //   778: getfield 14	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_Ajxv	Lajxv;
    //   781: getfield 39	ajxv:a	Lajxt;
    //   784: invokestatic 73	ajxt:b	(Lajxt;)Ljava/lang/String;
    //   787: ldc 182
    //   789: invokestatic 187	com/tencent/mobileqq/shortvideo/ShortVideoUtils:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   792: astore 6
    //   794: aload_0
    //   795: getfield 14	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_Ajxv	Lajxv;
    //   798: getfield 39	ajxv:a	Lajxt;
    //   801: invokestatic 44	ajxt:a	(Lajxt;)Ljava/lang/String;
    //   804: aload 6
    //   806: invokestatic 192	bdcs:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   809: ifeq +21 -> 830
    //   812: aload_0
    //   813: getfield 14	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_Ajxv	Lajxv;
    //   816: getfield 39	ajxv:a	Lajxt;
    //   819: aload 6
    //   821: invokestatic 58	ajxt:a	(Lajxt;Ljava/lang/String;)Ljava/lang/String;
    //   824: pop
    //   825: iload_3
    //   826: istore_1
    //   827: goto -251 -> 576
    //   830: iload_3
    //   831: istore_1
    //   832: aload 6
    //   834: invokestatic 195	bdcs:b	(Ljava/lang/String;)Z
    //   837: ifne -10 -> 827
    //   840: invokestatic 139	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   843: ifeq +47 -> 890
    //   846: ldc 141
    //   848: iconst_2
    //   849: new 143	java/lang/StringBuilder
    //   852: dup
    //   853: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   856: ldc 197
    //   858: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   861: aload_0
    //   862: getfield 14	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_Ajxv	Lajxv;
    //   865: getfield 39	ajxv:a	Lajxt;
    //   868: invokestatic 44	ajxt:a	(Lajxt;)Ljava/lang/String;
    //   871: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   874: ldc 199
    //   876: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   879: aload 6
    //   881: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   884: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   887: invokestatic 177	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   890: bipush 249
    //   892: istore_1
    //   893: goto -66 -> 827
    //   896: astore 7
    //   898: aconst_null
    //   899: astore 6
    //   901: aload 6
    //   903: ifnull +8 -> 911
    //   906: aload 6
    //   908: invokevirtual 134	java/io/FileInputStream:close	()V
    //   911: aload_0
    //   912: getfield 14	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_Ajxv	Lajxv;
    //   915: getfield 39	ajxv:a	Lajxt;
    //   918: invokestatic 73	ajxt:b	(Lajxt;)Ljava/lang/String;
    //   921: invokestatic 50	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   924: ifeq +30 -> 954
    //   927: invokestatic 139	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   930: ifeq +11 -> 941
    //   933: ldc 141
    //   935: iconst_2
    //   936: ldc 174
    //   938: invokestatic 177	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   941: aload 7
    //   943: athrow
    //   944: astore 6
    //   946: aload 6
    //   948: invokevirtual 180	java/io/IOException:printStackTrace	()V
    //   951: goto -40 -> 911
    //   954: aload_0
    //   955: getfield 14	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_Ajxv	Lajxv;
    //   958: getfield 39	ajxv:a	Lajxt;
    //   961: invokestatic 73	ajxt:b	(Lajxt;)Ljava/lang/String;
    //   964: ldc 182
    //   966: invokestatic 187	com/tencent/mobileqq/shortvideo/ShortVideoUtils:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   969: astore 6
    //   971: aload_0
    //   972: getfield 14	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_Ajxv	Lajxv;
    //   975: getfield 39	ajxv:a	Lajxt;
    //   978: invokestatic 44	ajxt:a	(Lajxt;)Ljava/lang/String;
    //   981: aload 6
    //   983: invokestatic 192	bdcs:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   986: ifeq +19 -> 1005
    //   989: aload_0
    //   990: getfield 14	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_Ajxv	Lajxv;
    //   993: getfield 39	ajxv:a	Lajxt;
    //   996: aload 6
    //   998: invokestatic 58	ajxt:a	(Lajxt;Ljava/lang/String;)Ljava/lang/String;
    //   1001: pop
    //   1002: goto -61 -> 941
    //   1005: aload 6
    //   1007: invokestatic 195	bdcs:b	(Ljava/lang/String;)Z
    //   1010: ifne -69 -> 941
    //   1013: invokestatic 139	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1016: ifeq -75 -> 941
    //   1019: ldc 141
    //   1021: iconst_2
    //   1022: new 143	java/lang/StringBuilder
    //   1025: dup
    //   1026: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   1029: ldc 197
    //   1031: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1034: aload_0
    //   1035: getfield 14	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_Ajxv	Lajxv;
    //   1038: getfield 39	ajxv:a	Lajxt;
    //   1041: invokestatic 44	ajxt:a	(Lajxt;)Ljava/lang/String;
    //   1044: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1047: ldc 199
    //   1049: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1052: aload 6
    //   1054: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1057: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1060: invokestatic 177	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1063: goto -122 -> 941
    //   1066: invokestatic 139	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1069: ifeq +37 -> 1106
    //   1072: ldc 141
    //   1074: iconst_2
    //   1075: new 143	java/lang/StringBuilder
    //   1078: dup
    //   1079: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   1082: ldc 202
    //   1084: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1087: aload_0
    //   1088: getfield 14	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_Ajxv	Lajxv;
    //   1091: getfield 39	ajxv:a	Lajxt;
    //   1094: invokestatic 44	ajxt:a	(Lajxt;)Ljava/lang/String;
    //   1097: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1100: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1103: invokestatic 177	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1106: bipush 248
    //   1108: istore_1
    //   1109: goto -923 -> 186
    //   1112: astore 6
    //   1114: aload 6
    //   1116: invokevirtual 180	java/io/IOException:printStackTrace	()V
    //   1119: iload_1
    //   1120: istore_2
    //   1121: goto -793 -> 328
    //   1124: astore 7
    //   1126: aload 9
    //   1128: astore 6
    //   1130: aload 7
    //   1132: invokevirtual 200	java/io/FileNotFoundException:printStackTrace	()V
    //   1135: bipush 246
    //   1137: istore_1
    //   1138: iload_1
    //   1139: istore_2
    //   1140: aload 6
    //   1142: ifnull -814 -> 328
    //   1145: aload 6
    //   1147: invokevirtual 134	java/io/FileInputStream:close	()V
    //   1150: iload_1
    //   1151: istore_2
    //   1152: goto -824 -> 328
    //   1155: astore 6
    //   1157: aload 6
    //   1159: invokevirtual 180	java/io/IOException:printStackTrace	()V
    //   1162: iload_1
    //   1163: istore_2
    //   1164: goto -836 -> 328
    //   1167: astore 6
    //   1169: aconst_null
    //   1170: astore 7
    //   1172: aload 7
    //   1174: ifnull +8 -> 1182
    //   1177: aload 7
    //   1179: invokevirtual 134	java/io/FileInputStream:close	()V
    //   1182: aload 6
    //   1184: athrow
    //   1185: astore 7
    //   1187: aload 7
    //   1189: invokevirtual 180	java/io/IOException:printStackTrace	()V
    //   1192: goto -10 -> 1182
    //   1195: bipush 247
    //   1197: istore_2
    //   1198: goto -870 -> 328
    //   1201: aload_0
    //   1202: getfield 14	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_Ajxv	Lajxv;
    //   1205: getfield 39	ajxv:a	Lajxt;
    //   1208: invokestatic 205	ajxt:c	(Lajxt;)Z
    //   1211: ifeq +57 -> 1268
    //   1214: aload_0
    //   1215: getfield 18	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry	Lcom/tencent/biz/qqstory/database/PublishVideoEntry;
    //   1218: getfield 208	com/tencent/biz/qqstory/database/PublishVideoEntry:mLocalRawVideoDir	Ljava/lang/String;
    //   1221: astore 6
    //   1223: aload_0
    //   1224: getfield 14	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_Ajxv	Lajxv;
    //   1227: getfield 39	ajxv:a	Lajxt;
    //   1230: invokestatic 210	ajxt:b	(Lajxt;)Z
    //   1233: ifeq +25 -> 1258
    //   1236: new 99	java/io/File
    //   1239: dup
    //   1240: aload_0
    //   1241: getfield 18	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry	Lcom/tencent/biz/qqstory/database/PublishVideoEntry;
    //   1244: getfield 208	com/tencent/biz/qqstory/database/PublishVideoEntry:mLocalRawVideoDir	Ljava/lang/String;
    //   1247: invokespecial 102	java/io/File:<init>	(Ljava/lang/String;)V
    //   1250: invokevirtual 214	java/io/File:getParentFile	()Ljava/io/File;
    //   1253: invokevirtual 217	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1256: astore 6
    //   1258: aload 6
    //   1260: invokestatic 221	com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:c	(Ljava/lang/String;)V
    //   1263: aload 6
    //   1265: invokestatic 223	bdcs:a	(Ljava/lang/String;)V
    //   1268: invokestatic 139	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1271: ifeq +179 -> 1450
    //   1274: ldc 141
    //   1276: iconst_2
    //   1277: new 143	java/lang/StringBuilder
    //   1280: dup
    //   1281: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   1284: ldc 225
    //   1286: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1289: aload_0
    //   1290: getfield 14	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_Ajxv	Lajxv;
    //   1293: getfield 39	ajxv:a	Lajxt;
    //   1296: invokestatic 44	ajxt:a	(Lajxt;)Ljava/lang/String;
    //   1299: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1302: ldc 227
    //   1304: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1307: aload_0
    //   1308: getfield 14	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_Ajxv	Lajxv;
    //   1311: getfield 39	ajxv:a	Lajxt;
    //   1314: invokestatic 172	ajxt:a	(Lajxt;)[B
    //   1317: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1320: ldc 232
    //   1322: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1325: aload_0
    //   1326: getfield 14	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_Ajxv	Lajxv;
    //   1329: getfield 39	ajxv:a	Lajxt;
    //   1332: invokestatic 73	ajxt:b	(Lajxt;)Ljava/lang/String;
    //   1335: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1338: ldc 234
    //   1340: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1343: aload_0
    //   1344: getfield 14	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_Ajxv	Lajxv;
    //   1347: getfield 39	ajxv:a	Lajxt;
    //   1350: invokestatic 237	ajxt:a	(Lajxt;)I
    //   1353: invokevirtual 153	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1356: ldc 239
    //   1358: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1361: aload_0
    //   1362: getfield 14	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_Ajxv	Lajxv;
    //   1365: getfield 39	ajxv:a	Lajxt;
    //   1368: invokestatic 241	ajxt:b	(Lajxt;)I
    //   1371: invokevirtual 153	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1374: ldc 243
    //   1376: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1379: aload_0
    //   1380: getfield 14	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_Ajxv	Lajxv;
    //   1383: getfield 39	ajxv:a	Lajxt;
    //   1386: invokestatic 97	ajxt:c	(Lajxt;)Ljava/lang/String;
    //   1389: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1392: ldc 245
    //   1394: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1397: aload_0
    //   1398: getfield 18	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry	Lcom/tencent/biz/qqstory/database/PublishVideoEntry;
    //   1401: getfield 249	com/tencent/biz/qqstory/database/PublishVideoEntry:recordTime	D
    //   1404: d2i
    //   1405: invokevirtual 153	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1408: ldc 251
    //   1410: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1413: aload_0
    //   1414: getfield 14	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_Ajxv	Lajxv;
    //   1417: getfield 39	ajxv:a	Lajxt;
    //   1420: invokestatic 124	ajxt:b	(Lajxt;)[B
    //   1423: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1426: ldc 253
    //   1428: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1431: aload_0
    //   1432: getfield 14	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_Ajxv	Lajxv;
    //   1435: getfield 39	ajxv:a	Lajxt;
    //   1438: invokestatic 255	ajxt:d	(Lajxt;)Ljava/lang/String;
    //   1441: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1444: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1447: invokestatic 161	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1450: aload_0
    //   1451: getfield 14	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_Ajxv	Lajxv;
    //   1454: getfield 39	ajxv:a	Lajxt;
    //   1457: invokestatic 258	ajxt:a	(Lajxt;)Lajxy;
    //   1460: ifnull -1089 -> 371
    //   1463: aload_0
    //   1464: getfield 14	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_Ajxv	Lajxv;
    //   1467: getfield 39	ajxv:a	Lajxt;
    //   1470: invokestatic 258	ajxt:a	(Lajxt;)Lajxy;
    //   1473: aload_0
    //   1474: getfield 14	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_Ajxv	Lajxv;
    //   1477: getfield 39	ajxv:a	Lajxt;
    //   1480: invokestatic 97	ajxt:c	(Lajxt;)Ljava/lang/String;
    //   1483: aload_0
    //   1484: getfield 14	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_Ajxv	Lajxv;
    //   1487: getfield 39	ajxv:a	Lajxt;
    //   1490: invokestatic 124	ajxt:b	(Lajxt;)[B
    //   1493: aload_0
    //   1494: getfield 14	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_Ajxv	Lajxv;
    //   1497: getfield 39	ajxv:a	Lajxt;
    //   1500: invokestatic 44	ajxt:a	(Lajxt;)Ljava/lang/String;
    //   1503: aload_0
    //   1504: getfield 14	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_Ajxv	Lajxv;
    //   1507: getfield 39	ajxv:a	Lajxt;
    //   1510: invokestatic 237	ajxt:a	(Lajxt;)I
    //   1513: aload_0
    //   1514: getfield 14	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_Ajxv	Lajxv;
    //   1517: getfield 39	ajxv:a	Lajxt;
    //   1520: invokestatic 241	ajxt:b	(Lajxt;)I
    //   1523: aload_0
    //   1524: getfield 14	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_Ajxv	Lajxv;
    //   1527: getfield 39	ajxv:a	Lajxt;
    //   1530: invokestatic 172	ajxt:a	(Lajxt;)[B
    //   1533: aload_0
    //   1534: getfield 18	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry	Lcom/tencent/biz/qqstory/database/PublishVideoEntry;
    //   1537: getfield 249	com/tencent/biz/qqstory/database/PublishVideoEntry:recordTime	D
    //   1540: d2i
    //   1541: invokeinterface 263 8 0
    //   1546: return
    //   1547: astore 6
    //   1549: aload 6
    //   1551: invokevirtual 264	java/lang/Exception:printStackTrace	()V
    //   1554: goto -286 -> 1268
    //   1557: astore 6
    //   1559: goto -387 -> 1172
    //   1562: astore 8
    //   1564: aload 6
    //   1566: astore 7
    //   1568: aload 8
    //   1570: astore 6
    //   1572: goto -400 -> 1172
    //   1575: astore 8
    //   1577: aload 7
    //   1579: astore 6
    //   1581: aload 8
    //   1583: astore 7
    //   1585: goto -455 -> 1130
    //   1588: astore 7
    //   1590: goto -689 -> 901
    //   1593: astore 8
    //   1595: goto -883 -> 712
    //   1598: iconst_0
    //   1599: istore_1
    //   1600: goto -1024 -> 576
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1603	0	this	1
    //   6	1594	1	i	int
    //   9	1189	2	j	int
    //   4	827	3	k	int
    //   270	227	4	l	long
    //   128	380	6	localObject1	Object
    //   579	3	6	localIOException1	java.io.IOException
    //   604	111	6	localObject2	Object
    //   767	3	6	localIOException2	java.io.IOException
    //   792	115	6	str1	String
    //   944	3	6	localIOException3	java.io.IOException
    //   969	84	6	str2	String
    //   1112	3	6	localIOException4	java.io.IOException
    //   1128	18	6	localObject3	Object
    //   1155	3	6	localIOException5	java.io.IOException
    //   1167	16	6	localObject4	Object
    //   1221	43	6	str3	String
    //   1547	3	6	localException	java.lang.Exception
    //   1557	8	6	localObject5	Object
    //   1570	10	6	localObject6	Object
    //   97	630	7	localObject7	Object
    //   896	46	7	localObject8	Object
    //   1124	7	7	localFileNotFoundException1	java.io.FileNotFoundException
    //   1170	8	7	localObject9	Object
    //   1185	3	7	localIOException6	java.io.IOException
    //   1566	18	7	localObject10	Object
    //   1588	1	7	localObject11	Object
    //   443	34	8	localFile	java.io.File
    //   707	10	8	localFileNotFoundException2	java.io.FileNotFoundException
    //   1562	7	8	localObject12	Object
    //   1575	7	8	localFileNotFoundException3	java.io.FileNotFoundException
    //   1593	1	8	localFileNotFoundException4	java.io.FileNotFoundException
    //   1	1126	9	localObject13	Object
    // Exception table:
    //   from	to	target	type
    //   538	543	579	java/io/IOException
    //   453	472	707	java/io/FileNotFoundException
    //   726	731	767	java/io/IOException
    //   453	472	896	finally
    //   906	911	944	java/io/IOException
    //   321	326	1112	java/io/IOException
    //   246	265	1124	java/io/FileNotFoundException
    //   1145	1150	1155	java/io/IOException
    //   246	265	1167	finally
    //   1177	1182	1185	java/io/IOException
    //   1201	1223	1547	java/lang/Exception
    //   1223	1258	1547	java/lang/Exception
    //   1258	1268	1547	java/lang/Exception
    //   265	314	1557	finally
    //   1130	1135	1562	finally
    //   265	314	1575	java/io/FileNotFoundException
    //   476	483	1588	finally
    //   487	505	1588	finally
    //   509	533	1588	finally
    //   716	721	1588	finally
    //   476	483	1593	java/io/FileNotFoundException
    //   487	505	1593	java/io/FileNotFoundException
    //   509	533	1593	java/io/FileNotFoundException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.shortvideo.EncodeVideoTask.2.1
 * JD-Core Version:    0.7.0.1
 */