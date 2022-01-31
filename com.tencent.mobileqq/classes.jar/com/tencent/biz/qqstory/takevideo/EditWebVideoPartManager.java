package com.tencent.biz.qqstory.takevideo;

import android.app.Activity;
import com.tencent.biz.qqstory.takevideo.publish.GenerateContext;
import com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import com.tencent.mobileqq.activity.shortvideo.EncodeVideoTask.ResultListener;
import com.tencent.mobileqq.activity.shortvideo.EncodeVideoTask.ThumbInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tribe.async.reactive.SimpleObserver;
import olo;
import olp;

public class EditWebVideoPartManager
  extends EditVideoPartManager
{
  private double jdField_a_of_type_Double;
  public int a;
  private EncodeVideoTask.ResultListener jdField_a_of_type_ComTencentMobileqqActivityShortvideoEncodeVideoTask$ResultListener;
  private EncodeVideoTask.ThumbInfo jdField_a_of_type_ComTencentMobileqqActivityShortvideoEncodeVideoTask$ThumbInfo;
  private double b;
  
  /* Error */
  private int a(PublishParam paramPublishParam)
  {
    // Byte code:
    //   0: new 28	com/tencent/mobileqq/shortvideo/util/MediaMetadataUtils$MetaData
    //   3: dup
    //   4: invokespecial 29	com/tencent/mobileqq/shortvideo/util/MediaMetadataUtils$MetaData:<init>	()V
    //   7: astore 11
    //   9: new 31	java/io/File
    //   12: dup
    //   13: aload_1
    //   14: getfield 37	com/tencent/biz/qqstory/takevideo/publish/PublishParam:j	Ljava/lang/String;
    //   17: invokespecial 40	java/io/File:<init>	(Ljava/lang/String;)V
    //   20: invokevirtual 44	java/io/File:getParentFile	()Ljava/io/File;
    //   23: invokevirtual 48	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   26: astore 16
    //   28: aload_1
    //   29: getfield 51	com/tencent/biz/qqstory/takevideo/publish/PublishParam:c	Ljava/lang/String;
    //   32: astore 14
    //   34: aload_1
    //   35: getfield 37	com/tencent/biz/qqstory/takevideo/publish/PublishParam:j	Ljava/lang/String;
    //   38: astore 15
    //   40: invokestatic 57	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   43: ifeq +29 -> 72
    //   46: ldc 59
    //   48: iconst_2
    //   49: new 61	java/lang/StringBuilder
    //   52: dup
    //   53: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   56: ldc 64
    //   58: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: aload 16
    //   63: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   69: invokestatic 75	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   72: invokestatic 81	java/lang/System:currentTimeMillis	()J
    //   75: lstore 7
    //   77: aload_0
    //   78: new 83	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$ThumbInfo
    //   81: dup
    //   82: invokespecial 84	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$ThumbInfo:<init>	()V
    //   85: putfield 86	com/tencent/biz/qqstory/takevideo/EditWebVideoPartManager:jdField_a_of_type_ComTencentMobileqqActivityShortvideoEncodeVideoTask$ThumbInfo	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$ThumbInfo;
    //   88: aload 15
    //   90: invokestatic 91	com/tencent/mobileqq/utils/FileUtils:b	(Ljava/lang/String;)Z
    //   93: ifne +23 -> 116
    //   96: invokestatic 57	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   99: ifeq +11 -> 110
    //   102: ldc 59
    //   104: iconst_2
    //   105: ldc 93
    //   107: invokestatic 75	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   110: sipush -300
    //   113: istore_2
    //   114: iload_2
    //   115: ireturn
    //   116: aload 14
    //   118: invokestatic 91	com/tencent/mobileqq/utils/FileUtils:b	(Ljava/lang/String;)Z
    //   121: ifne +21 -> 142
    //   124: invokestatic 57	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   127: ifeq +11 -> 138
    //   130: ldc 59
    //   132: iconst_2
    //   133: ldc 95
    //   135: invokestatic 75	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   138: sipush -301
    //   141: ireturn
    //   142: aload 15
    //   144: aload 11
    //   146: invokestatic 100	com/tencent/mobileqq/shortvideo/util/MediaMetadataUtils:a	(Ljava/lang/String;Lcom/tencent/mobileqq/shortvideo/util/MediaMetadataUtils$MetaData;)I
    //   149: istore_3
    //   150: iload_3
    //   151: ifeq +38 -> 189
    //   154: iload_3
    //   155: istore_2
    //   156: invokestatic 57	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   159: ifeq -45 -> 114
    //   162: ldc 59
    //   164: iconst_2
    //   165: new 61	java/lang/StringBuilder
    //   168: dup
    //   169: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   172: ldc 102
    //   174: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: iload_3
    //   178: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   181: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   184: invokestatic 75	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   187: iload_3
    //   188: ireturn
    //   189: aload 11
    //   191: getfield 108	com/tencent/mobileqq/shortvideo/util/MediaMetadataUtils$MetaData:a	[I
    //   194: iconst_3
    //   195: iaload
    //   196: sipush 500
    //   199: iadd
    //   200: sipush 1000
    //   203: idiv
    //   204: istore 5
    //   206: aload 11
    //   208: getfield 108	com/tencent/mobileqq/shortvideo/util/MediaMetadataUtils$MetaData:a	[I
    //   211: iconst_2
    //   212: iaload
    //   213: istore 6
    //   215: aload 11
    //   217: getfield 108	com/tencent/mobileqq/shortvideo/util/MediaMetadataUtils$MetaData:a	[I
    //   220: iconst_0
    //   221: iaload
    //   222: istore_3
    //   223: aload 11
    //   225: getfield 108	com/tencent/mobileqq/shortvideo/util/MediaMetadataUtils$MetaData:a	[I
    //   228: iconst_1
    //   229: iaload
    //   230: istore 4
    //   232: iload 6
    //   234: bipush 90
    //   236: if_icmpeq +14 -> 250
    //   239: iload 4
    //   241: istore_2
    //   242: iload 6
    //   244: sipush 270
    //   247: if_icmpne +14 -> 261
    //   250: aload 11
    //   252: getfield 108	com/tencent/mobileqq/shortvideo/util/MediaMetadataUtils$MetaData:a	[I
    //   255: iconst_0
    //   256: iaload
    //   257: istore_2
    //   258: iload 4
    //   260: istore_3
    //   261: aload 14
    //   263: aload_0
    //   264: getfield 18	com/tencent/biz/qqstory/takevideo/EditWebVideoPartManager:jdField_a_of_type_Double	D
    //   267: aload_0
    //   268: getfield 110	com/tencent/biz/qqstory/takevideo/EditWebVideoPartManager:b	D
    //   271: invokestatic 115	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;DD)Z
    //   274: pop
    //   275: new 31	java/io/File
    //   278: dup
    //   279: aload 14
    //   281: invokespecial 40	java/io/File:<init>	(Ljava/lang/String;)V
    //   284: astore 11
    //   286: new 117	java/io/FileInputStream
    //   289: dup
    //   290: aload 14
    //   292: invokespecial 118	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   295: astore 12
    //   297: aload 12
    //   299: aload 11
    //   301: invokevirtual 121	java/io/File:length	()J
    //   304: invokestatic 127	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   307: astore 11
    //   309: aload 11
    //   311: invokestatic 133	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   314: astore 13
    //   316: aload 12
    //   318: ifnull +8 -> 326
    //   321: aload 12
    //   323: invokevirtual 136	java/io/FileInputStream:close	()V
    //   326: aload 13
    //   328: invokestatic 142	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   331: ifeq +45 -> 376
    //   334: invokestatic 57	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   337: ifeq +11 -> 348
    //   340: ldc 59
    //   342: iconst_2
    //   343: ldc 144
    //   345: invokestatic 75	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   348: sipush -302
    //   351: ireturn
    //   352: astore 11
    //   354: aconst_null
    //   355: astore 12
    //   357: aconst_null
    //   358: astore 11
    //   360: aconst_null
    //   361: astore 13
    //   363: goto -47 -> 316
    //   366: astore 12
    //   368: aload 12
    //   370: invokevirtual 147	java/io/IOException:printStackTrace	()V
    //   373: goto -47 -> 326
    //   376: aload 13
    //   378: ldc 149
    //   380: invokestatic 154	com/tencent/mobileqq/shortvideo/ShortVideoUtils:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   383: astore 12
    //   385: aload 14
    //   387: aload 12
    //   389: invokestatic 157	com/tencent/mobileqq/utils/FileUtils:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   392: ifeq +293 -> 685
    //   395: aload_1
    //   396: getfield 160	com/tencent/biz/qqstory/takevideo/publish/PublishParam:f	I
    //   399: iconst_5
    //   400: if_icmpgt +339 -> 739
    //   403: aload_1
    //   404: getfield 160	com/tencent/biz/qqstory/takevideo/publish/PublishParam:f	I
    //   407: istore 4
    //   409: new 61	java/lang/StringBuilder
    //   412: dup
    //   413: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   416: aload 16
    //   418: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   421: getstatic 163	java/io/File:separator	Ljava/lang/String;
    //   424: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   427: ldc 165
    //   429: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   432: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   435: astore 13
    //   437: aconst_null
    //   438: aconst_null
    //   439: iload 4
    //   441: invokestatic 170	com/tencent/mobileqq/shortvideo/util/AudioEncoder:a	(Ljava/lang/String;Ljava/lang/String;I)Lcom/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData;
    //   444: astore 14
    //   446: aload 14
    //   448: aload 13
    //   450: putfield 174	com/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData:b	Ljava/lang/String;
    //   453: aload 14
    //   455: aload_1
    //   456: getfield 177	com/tencent/biz/qqstory/takevideo/publish/PublishParam:k	Ljava/lang/String;
    //   459: putfield 179	com/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   462: aload_1
    //   463: getfield 177	com/tencent/biz/qqstory/takevideo/publish/PublishParam:k	Ljava/lang/String;
    //   466: invokestatic 182	com/tencent/mobileqq/shortvideo/util/AudioEncoder:a	(Ljava/lang/String;)I
    //   469: istore 4
    //   471: iload 4
    //   473: ifeq +272 -> 745
    //   476: invokestatic 57	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   479: ifeq +29 -> 508
    //   482: ldc 59
    //   484: iconst_2
    //   485: new 61	java/lang/StringBuilder
    //   488: dup
    //   489: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   492: ldc 184
    //   494: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   497: iload 4
    //   499: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   502: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   505: invokestatic 75	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   508: new 31	java/io/File
    //   511: dup
    //   512: aload_1
    //   513: getfield 177	com/tencent/biz/qqstory/takevideo/publish/PublishParam:k	Ljava/lang/String;
    //   516: invokespecial 40	java/io/File:<init>	(Ljava/lang/String;)V
    //   519: astore 13
    //   521: aload 13
    //   523: invokevirtual 187	java/io/File:exists	()Z
    //   526: ifeq +9 -> 535
    //   529: aload 13
    //   531: invokevirtual 190	java/io/File:delete	()Z
    //   534: pop
    //   535: new 61	java/lang/StringBuilder
    //   538: dup
    //   539: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   542: aload 16
    //   544: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   547: getstatic 163	java/io/File:separator	Ljava/lang/String;
    //   550: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   553: ldc 192
    //   555: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   558: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   561: astore 13
    //   563: new 31	java/io/File
    //   566: dup
    //   567: aload 13
    //   569: invokespecial 40	java/io/File:<init>	(Ljava/lang/String;)V
    //   572: astore 14
    //   574: aload 14
    //   576: invokevirtual 187	java/io/File:exists	()Z
    //   579: ifeq +41 -> 620
    //   582: aload 14
    //   584: invokevirtual 190	java/io/File:delete	()Z
    //   587: pop
    //   588: invokestatic 57	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   591: ifeq +29 -> 620
    //   594: ldc 59
    //   596: iconst_2
    //   597: new 61	java/lang/StringBuilder
    //   600: dup
    //   601: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   604: ldc 194
    //   606: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   609: aload 13
    //   611: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   614: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   617: invokestatic 75	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   620: new 31	java/io/File
    //   623: dup
    //   624: aload 15
    //   626: invokespecial 40	java/io/File:<init>	(Ljava/lang/String;)V
    //   629: aload 14
    //   631: invokevirtual 198	java/io/File:renameTo	(Ljava/io/File;)Z
    //   634: ifne +204 -> 838
    //   637: invokestatic 57	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   640: ifeq +41 -> 681
    //   643: ldc 59
    //   645: iconst_2
    //   646: new 61	java/lang/StringBuilder
    //   649: dup
    //   650: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   653: ldc 200
    //   655: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   658: aload 13
    //   660: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   663: ldc 202
    //   665: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   668: aload_1
    //   669: getfield 37	com/tencent/biz/qqstory/takevideo/publish/PublishParam:j	Ljava/lang/String;
    //   672: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   675: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   678: invokestatic 75	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   681: sipush -303
    //   684: ireturn
    //   685: aload 12
    //   687: invokestatic 91	com/tencent/mobileqq/utils/FileUtils:b	(Ljava/lang/String;)Z
    //   690: ifne +244 -> 934
    //   693: invokestatic 57	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   696: ifeq +39 -> 735
    //   699: ldc 59
    //   701: iconst_2
    //   702: new 61	java/lang/StringBuilder
    //   705: dup
    //   706: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   709: ldc 204
    //   711: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   714: aload 14
    //   716: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   719: ldc 206
    //   721: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   724: aload 12
    //   726: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   729: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   732: invokestatic 75	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   735: sipush -301
    //   738: ireturn
    //   739: iconst_0
    //   740: istore 4
    //   742: goto -333 -> 409
    //   745: invokestatic 81	java/lang/System:currentTimeMillis	()J
    //   748: lstore 9
    //   750: aload 14
    //   752: invokestatic 209	com/tencent/mobileqq/shortvideo/util/AudioEncoder:a	(Lcom/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData;)I
    //   755: istore 4
    //   757: invokestatic 57	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   760: ifeq +38 -> 798
    //   763: ldc 59
    //   765: iconst_2
    //   766: new 61	java/lang/StringBuilder
    //   769: dup
    //   770: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   773: ldc 211
    //   775: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   778: invokestatic 81	java/lang/System:currentTimeMillis	()J
    //   781: lload 9
    //   783: lsub
    //   784: l2d
    //   785: ldc2_w 212
    //   788: ddiv
    //   789: invokevirtual 216	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   792: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   795: invokestatic 75	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   798: iload 4
    //   800: ifeq -292 -> 508
    //   803: invokestatic 57	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   806: ifeq +29 -> 835
    //   809: ldc 59
    //   811: iconst_2
    //   812: new 61	java/lang/StringBuilder
    //   815: dup
    //   816: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   819: ldc 218
    //   821: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   824: iload 4
    //   826: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   829: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   832: invokestatic 75	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   835: iload 4
    //   837: ireturn
    //   838: invokestatic 57	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   841: ifeq +38 -> 879
    //   844: ldc 59
    //   846: iconst_2
    //   847: new 61	java/lang/StringBuilder
    //   850: dup
    //   851: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   854: ldc 220
    //   856: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   859: invokestatic 81	java/lang/System:currentTimeMillis	()J
    //   862: lload 7
    //   864: lsub
    //   865: l2d
    //   866: ldc2_w 212
    //   869: ddiv
    //   870: invokevirtual 216	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   873: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   876: invokestatic 75	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   879: aload_0
    //   880: getfield 86	com/tencent/biz/qqstory/takevideo/EditWebVideoPartManager:jdField_a_of_type_ComTencentMobileqqActivityShortvideoEncodeVideoTask$ThumbInfo	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$ThumbInfo;
    //   883: aload 12
    //   885: putfield 221	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$ThumbInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   888: aload_0
    //   889: getfield 86	com/tencent/biz/qqstory/takevideo/EditWebVideoPartManager:jdField_a_of_type_ComTencentMobileqqActivityShortvideoEncodeVideoTask$ThumbInfo	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$ThumbInfo;
    //   892: aload 11
    //   894: putfield 224	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$ThumbInfo:jdField_a_of_type_ArrayOfByte	[B
    //   897: aload_0
    //   898: getfield 86	com/tencent/biz/qqstory/takevideo/EditWebVideoPartManager:jdField_a_of_type_ComTencentMobileqqActivityShortvideoEncodeVideoTask$ThumbInfo	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$ThumbInfo;
    //   901: iload_3
    //   902: putfield 226	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$ThumbInfo:jdField_a_of_type_Int	I
    //   905: aload_0
    //   906: getfield 86	com/tencent/biz/qqstory/takevideo/EditWebVideoPartManager:jdField_a_of_type_ComTencentMobileqqActivityShortvideoEncodeVideoTask$ThumbInfo	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$ThumbInfo;
    //   909: iload_2
    //   910: putfield 228	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$ThumbInfo:b	I
    //   913: aload_0
    //   914: iload 5
    //   916: putfield 229	com/tencent/biz/qqstory/takevideo/EditWebVideoPartManager:jdField_a_of_type_Int	I
    //   919: iconst_0
    //   920: ireturn
    //   921: astore 11
    //   923: aconst_null
    //   924: astore 11
    //   926: goto -566 -> 360
    //   929: astore 13
    //   931: goto -571 -> 360
    //   934: aload 14
    //   936: astore 12
    //   938: goto -543 -> 395
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	941	0	this	EditWebVideoPartManager
    //   0	941	1	paramPublishParam	PublishParam
    //   113	797	2	i	int
    //   149	753	3	j	int
    //   230	606	4	k	int
    //   204	711	5	m	int
    //   213	35	6	n	int
    //   75	788	7	l1	long
    //   748	34	9	l2	long
    //   7	303	11	localObject1	java.lang.Object
    //   352	1	11	localFileNotFoundException1	java.io.FileNotFoundException
    //   358	535	11	localObject2	java.lang.Object
    //   921	1	11	localFileNotFoundException2	java.io.FileNotFoundException
    //   924	1	11	localObject3	java.lang.Object
    //   295	61	12	localFileInputStream	java.io.FileInputStream
    //   366	3	12	localIOException	java.io.IOException
    //   383	554	12	localObject4	java.lang.Object
    //   314	345	13	localObject5	java.lang.Object
    //   929	1	13	localFileNotFoundException3	java.io.FileNotFoundException
    //   32	903	14	localObject6	java.lang.Object
    //   38	587	15	str1	java.lang.String
    //   26	517	16	str2	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   286	297	352	java/io/FileNotFoundException
    //   321	326	366	java/io/IOException
    //   297	309	921	java/io/FileNotFoundException
    //   309	316	929	java/io/FileNotFoundException
  }
  
  private void a(Activity paramActivity, EditVideoParams.EditSource paramEditSource, PublishParam paramPublishParam)
  {
    ThreadManager.post(new olp(this, paramEditSource, paramPublishParam, paramActivity), 5, null, true);
  }
  
  /* Error */
  private void b()
  {
    // Byte code:
    //   0: invokestatic 261	com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:a	()Lcom/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr;
    //   3: astore 10
    //   5: invokestatic 266	com/tencent/mobileqq/shortvideo/VideoEnvironment:d	()Z
    //   8: ifeq +236 -> 244
    //   11: ldc_w 268
    //   14: iconst_0
    //   15: invokestatic 274	cooperation/qzone/thread/QzoneHandlerThreadFactory:getHandlerThread	(Ljava/lang/String;Z)Lcooperation/qzone/thread/QzoneBaseThread;
    //   18: new 276	olq
    //   21: dup
    //   22: aload_0
    //   23: aload 10
    //   25: invokespecial 279	olq:<init>	(Lcom/tencent/biz/qqstory/takevideo/EditWebVideoPartManager;Lcom/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr;)V
    //   28: invokevirtual 284	cooperation/qzone/thread/QzoneBaseThread:post	(Ljava/lang/Runnable;)V
    //   31: invokestatic 266	com/tencent/mobileqq/shortvideo/VideoEnvironment:d	()Z
    //   34: ifeq +209 -> 243
    //   37: lconst_0
    //   38: lstore 6
    //   40: aload 10
    //   42: getfield 287	com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:a	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   45: astore 9
    //   47: aload 9
    //   49: monitorenter
    //   50: aload 10
    //   52: getfield 287	com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:a	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   55: invokevirtual 292	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   58: istore 8
    //   60: lload 6
    //   62: lstore 4
    //   64: iload 8
    //   66: ifne +104 -> 170
    //   69: lload 6
    //   71: lstore_2
    //   72: invokestatic 57	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   75: ifeq +15 -> 90
    //   78: lload 6
    //   80: lstore_2
    //   81: ldc 59
    //   83: iconst_2
    //   84: ldc_w 294
    //   87: invokestatic 296	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   90: lload 6
    //   92: lstore_2
    //   93: invokestatic 301	android/os/SystemClock:elapsedRealtime	()J
    //   96: lstore 4
    //   98: lload 6
    //   100: lstore_2
    //   101: aload 10
    //   103: getfield 287	com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:a	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   106: ldc2_w 302
    //   109: invokevirtual 309	java/lang/Object:wait	(J)V
    //   112: lload 6
    //   114: lstore_2
    //   115: invokestatic 301	android/os/SystemClock:elapsedRealtime	()J
    //   118: lload 4
    //   120: lsub
    //   121: lstore 6
    //   123: lload 6
    //   125: lstore 4
    //   127: lload 6
    //   129: lstore_2
    //   130: invokestatic 57	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   133: ifeq +37 -> 170
    //   136: lload 6
    //   138: lstore_2
    //   139: ldc 59
    //   141: iconst_2
    //   142: new 61	java/lang/StringBuilder
    //   145: dup
    //   146: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   149: ldc_w 311
    //   152: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: lload 6
    //   157: invokevirtual 314	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   160: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: invokestatic 296	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   166: lload 6
    //   168: lstore 4
    //   170: aload 9
    //   172: monitorexit
    //   173: invokestatic 57	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   176: ifeq +12 -> 188
    //   179: ldc 59
    //   181: iconst_2
    //   182: ldc_w 316
    //   185: invokestatic 296	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   188: lload 4
    //   190: ldc2_w 317
    //   193: lcmp
    //   194: ifge +49 -> 243
    //   197: bipush 30
    //   199: lload 4
    //   201: l2i
    //   202: isub
    //   203: istore_1
    //   204: invokestatic 57	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   207: ifeq +29 -> 236
    //   210: ldc 59
    //   212: iconst_2
    //   213: new 61	java/lang/StringBuilder
    //   216: dup
    //   217: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   220: ldc_w 320
    //   223: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: iload_1
    //   227: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   230: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   233: invokestatic 296	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   236: iload_1
    //   237: i2l
    //   238: lstore_2
    //   239: lload_2
    //   240: invokestatic 325	java/lang/Thread:sleep	(J)V
    //   243: return
    //   244: invokestatic 330	com/tencent/mobileqq/shortvideo/mediadevice/RecordManager:a	()Lcom/tencent/mobileqq/shortvideo/mediadevice/RecordManager;
    //   247: invokevirtual 333	com/tencent/mobileqq/shortvideo/mediadevice/RecordManager:a	()Lcom/tencent/maxvideo/mediadevice/AVCodec;
    //   250: invokevirtual 339	com/tencent/maxvideo/mediadevice/AVCodec:recordSubmit	()I
    //   253: pop
    //   254: invokestatic 57	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   257: ifeq -226 -> 31
    //   260: ldc 59
    //   262: iconst_2
    //   263: ldc_w 341
    //   266: invokestatic 296	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   269: goto -238 -> 31
    //   272: astore 9
    //   274: invokestatic 57	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   277: ifeq +12 -> 289
    //   280: ldc 59
    //   282: iconst_2
    //   283: ldc_w 343
    //   286: invokestatic 296	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   289: aload 9
    //   291: invokevirtual 344	java/lang/UnsatisfiedLinkError:printStackTrace	()V
    //   294: goto -263 -> 31
    //   297: astore 10
    //   299: lload_2
    //   300: lstore 4
    //   302: invokestatic 57	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   305: ifeq -135 -> 170
    //   308: ldc 59
    //   310: iconst_2
    //   311: ldc_w 346
    //   314: aload 10
    //   316: invokestatic 350	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   319: lload_2
    //   320: lstore 4
    //   322: goto -152 -> 170
    //   325: astore 10
    //   327: aload 9
    //   329: monitorexit
    //   330: aload 10
    //   332: athrow
    //   333: astore 9
    //   335: invokestatic 57	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   338: ifeq -95 -> 243
    //   341: ldc 59
    //   343: iconst_2
    //   344: ldc_w 352
    //   347: aload 9
    //   349: invokestatic 350	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   352: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	353	0	this	EditWebVideoPartManager
    //   203	34	1	i	int
    //   71	249	2	l1	long
    //   62	259	4	l2	long
    //   38	129	6	l3	long
    //   58	7	8	bool	boolean
    //   45	126	9	localAtomicBoolean	java.util.concurrent.atomic.AtomicBoolean
    //   272	56	9	localUnsatisfiedLinkError	java.lang.UnsatisfiedLinkError
    //   333	15	9	localInterruptedException1	java.lang.InterruptedException
    //   3	99	10	localRMVideoStateMgr	com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr
    //   297	18	10	localInterruptedException2	java.lang.InterruptedException
    //   325	6	10	localObject	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   244	269	272	java/lang/UnsatisfiedLinkError
    //   72	78	297	java/lang/InterruptedException
    //   81	90	297	java/lang/InterruptedException
    //   93	98	297	java/lang/InterruptedException
    //   101	112	297	java/lang/InterruptedException
    //   115	123	297	java/lang/InterruptedException
    //   130	136	297	java/lang/InterruptedException
    //   139	166	297	java/lang/InterruptedException
    //   50	60	325	finally
    //   72	78	325	finally
    //   81	90	325	finally
    //   93	98	325	finally
    //   101	112	325	finally
    //   115	123	325	finally
    //   130	136	325	finally
    //   139	166	325	finally
    //   170	173	325	finally
    //   302	319	325	finally
    //   327	330	325	finally
    //   239	243	333	java/lang/InterruptedException
  }
  
  protected SimpleObserver a(GenerateContext paramGenerateContext)
  {
    return new olo(this, paramGenerateContext);
  }
  
  public void a()
  {
    super.a();
  }
  
  public void a(EncodeVideoTask.ResultListener paramResultListener)
  {
    if (paramResultListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoEncodeVideoTask$ResultListener = paramResultListener;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditWebVideoPartManager
 * JD-Core Version:    0.7.0.1
 */