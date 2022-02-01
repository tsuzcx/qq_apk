package com.tencent.mobileqq.activity.shortvideo;

import com.tencent.mobileqq.editor.database.PublishVideoEntry;

class EncodeVideoTask$2$1
  implements Runnable
{
  EncodeVideoTask$2$1(EncodeVideoTask.2 param2, String paramString, PublishVideoEntry paramPublishVideoEntry) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 16	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4: astore 5
    //   6: iconst_0
    //   7: istore_1
    //   8: aload 5
    //   10: iconst_0
    //   11: iconst_1
    //   12: invokestatic 34	com/tencent/util/AutoSaveUtils:a	(Ljava/lang/String;ZZ)V
    //   15: aload_0
    //   16: getfield 14	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_ComTencentMobileqqActivityShortvideoEncodeVideoTask$2	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2;
    //   19: getfield 39	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2:a	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   22: invokestatic 44	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:a	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)Ljava/lang/String;
    //   25: invokestatic 50	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   28: ifeq +21 -> 49
    //   31: aload_0
    //   32: getfield 14	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_ComTencentMobileqqActivityShortvideoEncodeVideoTask$2	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2;
    //   35: getfield 39	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2:a	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   38: aload_0
    //   39: getfield 18	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry	Lcom/tencent/mobileqq/editor/database/PublishVideoEntry;
    //   42: getfield 55	com/tencent/mobileqq/editor/database/PublishVideoEntry:thumbPath	Ljava/lang/String;
    //   45: invokestatic 58	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:a	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;Ljava/lang/String;)Ljava/lang/String;
    //   48: pop
    //   49: aload_0
    //   50: getfield 14	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_ComTencentMobileqqActivityShortvideoEncodeVideoTask$2	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2;
    //   53: getfield 39	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2:a	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   56: invokestatic 61	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:a	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$ThumbInfo;
    //   59: astore 5
    //   61: aconst_null
    //   62: astore 8
    //   64: aconst_null
    //   65: astore 9
    //   67: aload 5
    //   69: ifnull +144 -> 213
    //   72: aload_0
    //   73: getfield 14	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_ComTencentMobileqqActivityShortvideoEncodeVideoTask$2	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2;
    //   76: getfield 39	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2:a	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   79: aload_0
    //   80: getfield 14	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_ComTencentMobileqqActivityShortvideoEncodeVideoTask$2	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2;
    //   83: getfield 39	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2:a	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   86: invokestatic 61	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:a	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$ThumbInfo;
    //   89: getfield 66	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$ThumbInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   92: invokestatic 68	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:b	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;Ljava/lang/String;)Ljava/lang/String;
    //   95: pop
    //   96: aload_0
    //   97: getfield 14	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_ComTencentMobileqqActivityShortvideoEncodeVideoTask$2	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2;
    //   100: getfield 39	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2:a	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   103: astore 6
    //   105: aload_0
    //   106: getfield 14	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_ComTencentMobileqqActivityShortvideoEncodeVideoTask$2	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2;
    //   109: getfield 39	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2:a	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   112: invokestatic 61	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:a	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$ThumbInfo;
    //   115: getfield 71	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$ThumbInfo:jdField_a_of_type_ArrayOfByte	[B
    //   118: ifnonnull +21 -> 139
    //   121: aload_0
    //   122: getfield 14	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_ComTencentMobileqqActivityShortvideoEncodeVideoTask$2	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2;
    //   125: getfield 39	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2:a	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   128: invokestatic 73	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:b	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)Ljava/lang/String;
    //   131: invokestatic 79	com/qq/taf/jce/HexUtil:hexStr2Bytes	(Ljava/lang/String;)[B
    //   134: astore 5
    //   136: goto +18 -> 154
    //   139: aload_0
    //   140: getfield 14	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_ComTencentMobileqqActivityShortvideoEncodeVideoTask$2	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2;
    //   143: getfield 39	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2:a	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   146: invokestatic 61	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:a	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$ThumbInfo;
    //   149: getfield 71	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$ThumbInfo:jdField_a_of_type_ArrayOfByte	[B
    //   152: astore 5
    //   154: aload 6
    //   156: aload 5
    //   158: invokestatic 82	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:a	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;[B)[B
    //   161: pop
    //   162: aload_0
    //   163: getfield 14	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_ComTencentMobileqqActivityShortvideoEncodeVideoTask$2	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2;
    //   166: getfield 39	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2:a	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   169: aload_0
    //   170: getfield 14	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_ComTencentMobileqqActivityShortvideoEncodeVideoTask$2	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2;
    //   173: getfield 39	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2:a	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   176: invokestatic 61	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:a	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$ThumbInfo;
    //   179: getfield 85	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$ThumbInfo:jdField_a_of_type_Int	I
    //   182: invokestatic 88	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:a	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;I)I
    //   185: pop
    //   186: aload_0
    //   187: getfield 14	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_ComTencentMobileqqActivityShortvideoEncodeVideoTask$2	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2;
    //   190: getfield 39	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2:a	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   193: aload_0
    //   194: getfield 14	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_ComTencentMobileqqActivityShortvideoEncodeVideoTask$2	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2;
    //   197: getfield 39	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2:a	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   200: invokestatic 61	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:a	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$ThumbInfo;
    //   203: getfield 90	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$ThumbInfo:jdField_b_of_type_Int	I
    //   206: invokestatic 92	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:b	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;I)I
    //   209: pop
    //   210: goto +706 -> 916
    //   213: aload_0
    //   214: getfield 14	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_ComTencentMobileqqActivityShortvideoEncodeVideoTask$2	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2;
    //   217: getfield 39	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2:a	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   220: aload_0
    //   221: getfield 18	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry	Lcom/tencent/mobileqq/editor/database/PublishVideoEntry;
    //   224: getfield 95	com/tencent/mobileqq/editor/database/PublishVideoEntry:videoWidth	I
    //   227: invokestatic 88	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:a	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;I)I
    //   230: pop
    //   231: aload_0
    //   232: getfield 14	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_ComTencentMobileqqActivityShortvideoEncodeVideoTask$2	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2;
    //   235: getfield 39	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2:a	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   238: aload_0
    //   239: getfield 18	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry	Lcom/tencent/mobileqq/editor/database/PublishVideoEntry;
    //   242: getfield 98	com/tencent/mobileqq/editor/database/PublishVideoEntry:videoHeight	I
    //   245: invokestatic 92	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:b	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;I)I
    //   248: pop
    //   249: new 100	java/io/File
    //   252: dup
    //   253: aload_0
    //   254: getfield 14	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_ComTencentMobileqqActivityShortvideoEncodeVideoTask$2	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2;
    //   257: getfield 39	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2:a	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   260: invokestatic 44	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:a	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)Ljava/lang/String;
    //   263: invokespecial 103	java/io/File:<init>	(Ljava/lang/String;)V
    //   266: astore 7
    //   268: aload 7
    //   270: invokevirtual 107	java/io/File:exists	()Z
    //   273: ifeq +590 -> 863
    //   276: new 109	java/io/FileInputStream
    //   279: dup
    //   280: aload_0
    //   281: getfield 14	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_ComTencentMobileqqActivityShortvideoEncodeVideoTask$2	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2;
    //   284: getfield 39	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2:a	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   287: invokestatic 44	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:a	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)Ljava/lang/String;
    //   290: invokespecial 110	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   293: astore 6
    //   295: aload 6
    //   297: astore 5
    //   299: aload 7
    //   301: invokevirtual 114	java/io/File:length	()J
    //   304: lstore_3
    //   305: aload 6
    //   307: astore 5
    //   309: aload_0
    //   310: getfield 14	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_ComTencentMobileqqActivityShortvideoEncodeVideoTask$2	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2;
    //   313: getfield 39	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2:a	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   316: aload 6
    //   318: lload_3
    //   319: invokestatic 120	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   322: invokestatic 82	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:a	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;[B)[B
    //   325: pop
    //   326: aload 6
    //   328: astore 5
    //   330: aload_0
    //   331: getfield 14	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_ComTencentMobileqqActivityShortvideoEncodeVideoTask$2	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2;
    //   334: getfield 39	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2:a	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   337: aload_0
    //   338: getfield 14	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_ComTencentMobileqqActivityShortvideoEncodeVideoTask$2	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2;
    //   341: getfield 39	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2:a	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   344: invokestatic 123	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:a	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)[B
    //   347: invokestatic 127	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   350: invokestatic 68	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:b	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;Ljava/lang/String;)Ljava/lang/String;
    //   353: pop
    //   354: aload 6
    //   356: invokevirtual 130	java/io/FileInputStream:close	()V
    //   359: goto +10 -> 369
    //   362: astore 5
    //   364: aload 5
    //   366: invokevirtual 133	java/io/IOException:printStackTrace	()V
    //   369: aload_0
    //   370: getfield 14	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_ComTencentMobileqqActivityShortvideoEncodeVideoTask$2	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2;
    //   373: getfield 39	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2:a	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   376: invokestatic 73	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:b	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)Ljava/lang/String;
    //   379: invokestatic 50	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   382: ifeq +12 -> 394
    //   385: invokestatic 138	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   388: ifeq +214 -> 602
    //   391: goto +203 -> 594
    //   394: aload_0
    //   395: getfield 14	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_ComTencentMobileqqActivityShortvideoEncodeVideoTask$2	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2;
    //   398: getfield 39	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2:a	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   401: invokestatic 73	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:b	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)Ljava/lang/String;
    //   404: ldc 140
    //   406: invokestatic 145	com/tencent/mobileqq/shortvideo/SVUtils:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   409: astore 5
    //   411: aload_0
    //   412: getfield 14	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_ComTencentMobileqqActivityShortvideoEncodeVideoTask$2	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2;
    //   415: getfield 39	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2:a	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   418: invokestatic 44	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:a	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)Ljava/lang/String;
    //   421: aload 5
    //   423: invokestatic 151	com/tencent/mobileqq/utils/FileUtils:rename	(Ljava/lang/String;Ljava/lang/String;)Z
    //   426: ifeq +19 -> 445
    //   429: aload_0
    //   430: getfield 14	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_ComTencentMobileqqActivityShortvideoEncodeVideoTask$2	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2;
    //   433: getfield 39	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2:a	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   436: aload 5
    //   438: invokestatic 58	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:a	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;Ljava/lang/String;)Ljava/lang/String;
    //   441: pop
    //   442: goto +474 -> 916
    //   445: aload 5
    //   447: invokestatic 155	com/tencent/mobileqq/utils/FileUtils:fileExistsAndNotEmpty	(Ljava/lang/String;)Z
    //   450: ifne +466 -> 916
    //   453: invokestatic 138	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   456: ifeq +63 -> 519
    //   459: new 157	java/lang/StringBuilder
    //   462: dup
    //   463: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   466: astore 6
    //   468: aload 6
    //   470: ldc 160
    //   472: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   475: pop
    //   476: aload 6
    //   478: aload_0
    //   479: getfield 14	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_ComTencentMobileqqActivityShortvideoEncodeVideoTask$2	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2;
    //   482: getfield 39	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2:a	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   485: invokestatic 44	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:a	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)Ljava/lang/String;
    //   488: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   491: pop
    //   492: aload 6
    //   494: ldc 166
    //   496: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   499: pop
    //   500: aload 6
    //   502: aload 5
    //   504: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   507: pop
    //   508: ldc 168
    //   510: iconst_2
    //   511: aload 6
    //   513: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   516: invokestatic 176	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   519: bipush 249
    //   521: istore_1
    //   522: goto +394 -> 916
    //   525: astore 7
    //   527: goto +16 -> 543
    //   530: astore 5
    //   532: aconst_null
    //   533: astore 6
    //   535: goto +147 -> 682
    //   538: astore 7
    //   540: aconst_null
    //   541: astore 6
    //   543: aload 6
    //   545: astore 5
    //   547: aload 7
    //   549: invokevirtual 177	java/io/FileNotFoundException:printStackTrace	()V
    //   552: aload 6
    //   554: ifnull +18 -> 572
    //   557: aload 6
    //   559: invokevirtual 130	java/io/FileInputStream:close	()V
    //   562: goto +10 -> 572
    //   565: astore 5
    //   567: aload 5
    //   569: invokevirtual 133	java/io/IOException:printStackTrace	()V
    //   572: aload_0
    //   573: getfield 14	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_ComTencentMobileqqActivityShortvideoEncodeVideoTask$2	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2;
    //   576: getfield 39	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2:a	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   579: invokestatic 73	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:b	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)Ljava/lang/String;
    //   582: invokestatic 50	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   585: ifeq +23 -> 608
    //   588: invokestatic 138	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   591: ifeq +11 -> 602
    //   594: ldc 168
    //   596: iconst_2
    //   597: ldc 179
    //   599: invokestatic 176	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   602: bipush 250
    //   604: istore_1
    //   605: goto +311 -> 916
    //   608: aload_0
    //   609: getfield 14	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_ComTencentMobileqqActivityShortvideoEncodeVideoTask$2	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2;
    //   612: getfield 39	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2:a	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   615: invokestatic 73	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:b	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)Ljava/lang/String;
    //   618: ldc 140
    //   620: invokestatic 145	com/tencent/mobileqq/shortvideo/SVUtils:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   623: astore 5
    //   625: aload_0
    //   626: getfield 14	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_ComTencentMobileqqActivityShortvideoEncodeVideoTask$2	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2;
    //   629: getfield 39	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2:a	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   632: invokestatic 44	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:a	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)Ljava/lang/String;
    //   635: aload 5
    //   637: invokestatic 151	com/tencent/mobileqq/utils/FileUtils:rename	(Ljava/lang/String;Ljava/lang/String;)Z
    //   640: ifeq +6 -> 646
    //   643: goto -214 -> 429
    //   646: aload 5
    //   648: invokestatic 155	com/tencent/mobileqq/utils/FileUtils:fileExistsAndNotEmpty	(Ljava/lang/String;)Z
    //   651: ifne +265 -> 916
    //   654: invokestatic 138	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   657: ifeq -138 -> 519
    //   660: new 157	java/lang/StringBuilder
    //   663: dup
    //   664: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   667: astore 6
    //   669: goto -201 -> 468
    //   672: astore 7
    //   674: aload 5
    //   676: astore 6
    //   678: aload 7
    //   680: astore 5
    //   682: aload 6
    //   684: ifnull +18 -> 702
    //   687: aload 6
    //   689: invokevirtual 130	java/io/FileInputStream:close	()V
    //   692: goto +10 -> 702
    //   695: astore 6
    //   697: aload 6
    //   699: invokevirtual 133	java/io/IOException:printStackTrace	()V
    //   702: aload_0
    //   703: getfield 14	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_ComTencentMobileqqActivityShortvideoEncodeVideoTask$2	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2;
    //   706: getfield 39	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2:a	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   709: invokestatic 73	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:b	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)Ljava/lang/String;
    //   712: invokestatic 50	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   715: ifeq +20 -> 735
    //   718: invokestatic 138	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   721: ifeq +139 -> 860
    //   724: ldc 168
    //   726: iconst_2
    //   727: ldc 179
    //   729: invokestatic 176	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   732: goto +128 -> 860
    //   735: aload_0
    //   736: getfield 14	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_ComTencentMobileqqActivityShortvideoEncodeVideoTask$2	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2;
    //   739: getfield 39	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2:a	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   742: invokestatic 73	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:b	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)Ljava/lang/String;
    //   745: ldc 140
    //   747: invokestatic 145	com/tencent/mobileqq/shortvideo/SVUtils:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   750: astore 6
    //   752: aload_0
    //   753: getfield 14	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_ComTencentMobileqqActivityShortvideoEncodeVideoTask$2	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2;
    //   756: getfield 39	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2:a	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   759: invokestatic 44	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:a	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)Ljava/lang/String;
    //   762: aload 6
    //   764: invokestatic 151	com/tencent/mobileqq/utils/FileUtils:rename	(Ljava/lang/String;Ljava/lang/String;)Z
    //   767: ifne +80 -> 847
    //   770: aload 6
    //   772: invokestatic 155	com/tencent/mobileqq/utils/FileUtils:fileExistsAndNotEmpty	(Ljava/lang/String;)Z
    //   775: ifne +85 -> 860
    //   778: invokestatic 138	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   781: ifeq +79 -> 860
    //   784: new 157	java/lang/StringBuilder
    //   787: dup
    //   788: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   791: astore 7
    //   793: aload 7
    //   795: ldc 160
    //   797: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   800: pop
    //   801: aload 7
    //   803: aload_0
    //   804: getfield 14	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_ComTencentMobileqqActivityShortvideoEncodeVideoTask$2	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2;
    //   807: getfield 39	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2:a	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   810: invokestatic 44	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:a	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)Ljava/lang/String;
    //   813: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   816: pop
    //   817: aload 7
    //   819: ldc 166
    //   821: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   824: pop
    //   825: aload 7
    //   827: aload 6
    //   829: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   832: pop
    //   833: ldc 168
    //   835: iconst_2
    //   836: aload 7
    //   838: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   841: invokestatic 176	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   844: goto +16 -> 860
    //   847: aload_0
    //   848: getfield 14	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_ComTencentMobileqqActivityShortvideoEncodeVideoTask$2	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2;
    //   851: getfield 39	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2:a	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   854: aload 6
    //   856: invokestatic 58	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:a	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;Ljava/lang/String;)Ljava/lang/String;
    //   859: pop
    //   860: aload 5
    //   862: athrow
    //   863: invokestatic 138	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   866: ifeq +47 -> 913
    //   869: new 157	java/lang/StringBuilder
    //   872: dup
    //   873: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   876: astore 5
    //   878: aload 5
    //   880: ldc 181
    //   882: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   885: pop
    //   886: aload 5
    //   888: aload_0
    //   889: getfield 14	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_ComTencentMobileqqActivityShortvideoEncodeVideoTask$2	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2;
    //   892: getfield 39	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2:a	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   895: invokestatic 44	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:a	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)Ljava/lang/String;
    //   898: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   901: pop
    //   902: ldc 168
    //   904: iconst_2
    //   905: aload 5
    //   907: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   910: invokestatic 176	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   913: bipush 248
    //   915: istore_1
    //   916: aload_0
    //   917: getfield 14	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_ComTencentMobileqqActivityShortvideoEncodeVideoTask$2	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2;
    //   920: getfield 39	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2:a	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   923: aload_0
    //   924: getfield 16	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   927: invokestatic 184	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:c	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;Ljava/lang/String;)Ljava/lang/String;
    //   930: pop
    //   931: aload_0
    //   932: getfield 14	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_ComTencentMobileqqActivityShortvideoEncodeVideoTask$2	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2;
    //   935: getfield 39	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2:a	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   938: invokestatic 186	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:c	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)Ljava/lang/String;
    //   941: invokestatic 50	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   944: ifne +207 -> 1151
    //   947: new 100	java/io/File
    //   950: dup
    //   951: aload_0
    //   952: getfield 14	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_ComTencentMobileqqActivityShortvideoEncodeVideoTask$2	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2;
    //   955: getfield 39	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2:a	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   958: invokestatic 186	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:c	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)Ljava/lang/String;
    //   961: invokespecial 103	java/io/File:<init>	(Ljava/lang/String;)V
    //   964: astore 7
    //   966: iload_1
    //   967: istore_2
    //   968: aload 7
    //   970: invokevirtual 107	java/io/File:exists	()Z
    //   973: ifeq +181 -> 1154
    //   976: aload 9
    //   978: astore 5
    //   980: new 109	java/io/FileInputStream
    //   983: dup
    //   984: aload_0
    //   985: getfield 14	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_ComTencentMobileqqActivityShortvideoEncodeVideoTask$2	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2;
    //   988: getfield 39	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2:a	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   991: invokestatic 186	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:c	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)Ljava/lang/String;
    //   994: invokespecial 110	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   997: astore 6
    //   999: aload 7
    //   1001: invokevirtual 114	java/io/File:length	()J
    //   1004: lstore_3
    //   1005: aload_0
    //   1006: getfield 14	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_ComTencentMobileqqActivityShortvideoEncodeVideoTask$2	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2;
    //   1009: getfield 39	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2:a	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   1012: aload 6
    //   1014: lload_3
    //   1015: invokestatic 120	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   1018: invokestatic 188	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:b	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;[B)[B
    //   1021: pop
    //   1022: aload_0
    //   1023: getfield 14	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_ComTencentMobileqqActivityShortvideoEncodeVideoTask$2	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2;
    //   1026: getfield 39	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2:a	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   1029: aload_0
    //   1030: getfield 14	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_ComTencentMobileqqActivityShortvideoEncodeVideoTask$2	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2;
    //   1033: getfield 39	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2:a	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   1036: invokestatic 190	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:b	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)[B
    //   1039: invokestatic 127	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   1042: invokestatic 193	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:d	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;Ljava/lang/String;)Ljava/lang/String;
    //   1045: pop
    //   1046: iload_1
    //   1047: istore_2
    //   1048: aload 6
    //   1050: invokevirtual 130	java/io/FileInputStream:close	()V
    //   1053: iload_1
    //   1054: istore_2
    //   1055: goto +99 -> 1154
    //   1058: astore 5
    //   1060: goto +68 -> 1128
    //   1063: astore 7
    //   1065: goto +22 -> 1087
    //   1068: astore 7
    //   1070: aload 5
    //   1072: astore 6
    //   1074: aload 7
    //   1076: astore 5
    //   1078: goto +50 -> 1128
    //   1081: astore 7
    //   1083: aload 8
    //   1085: astore 6
    //   1087: aload 6
    //   1089: astore 5
    //   1091: aload 7
    //   1093: invokevirtual 177	java/io/FileNotFoundException:printStackTrace	()V
    //   1096: bipush 246
    //   1098: istore_1
    //   1099: iload_1
    //   1100: istore_2
    //   1101: aload 6
    //   1103: ifnull +51 -> 1154
    //   1106: iload_1
    //   1107: istore_2
    //   1108: aload 6
    //   1110: invokevirtual 130	java/io/FileInputStream:close	()V
    //   1113: iload_1
    //   1114: istore_2
    //   1115: goto +39 -> 1154
    //   1118: astore 5
    //   1120: aload 5
    //   1122: invokevirtual 133	java/io/IOException:printStackTrace	()V
    //   1125: goto +29 -> 1154
    //   1128: aload 6
    //   1130: ifnull +18 -> 1148
    //   1133: aload 6
    //   1135: invokevirtual 130	java/io/FileInputStream:close	()V
    //   1138: goto +10 -> 1148
    //   1141: astore 6
    //   1143: aload 6
    //   1145: invokevirtual 133	java/io/IOException:printStackTrace	()V
    //   1148: aload 5
    //   1150: athrow
    //   1151: bipush 247
    //   1153: istore_2
    //   1154: iload_2
    //   1155: ifeq +53 -> 1208
    //   1158: invokestatic 138	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1161: ifeq +38 -> 1199
    //   1164: new 157	java/lang/StringBuilder
    //   1167: dup
    //   1168: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   1171: astore 5
    //   1173: aload 5
    //   1175: ldc 195
    //   1177: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1180: pop
    //   1181: aload 5
    //   1183: iload_2
    //   1184: invokevirtual 198	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1187: pop
    //   1188: ldc 168
    //   1190: iconst_2
    //   1191: aload 5
    //   1193: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1196: invokestatic 201	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1199: aload_0
    //   1200: getfield 14	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_ComTencentMobileqqActivityShortvideoEncodeVideoTask$2	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2;
    //   1203: iload_2
    //   1204: invokevirtual 204	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2:a	(I)V
    //   1207: return
    //   1208: aload_0
    //   1209: getfield 14	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_ComTencentMobileqqActivityShortvideoEncodeVideoTask$2	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2;
    //   1212: getfield 39	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2:a	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   1215: invokestatic 207	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:c	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)Z
    //   1218: ifeq +67 -> 1285
    //   1221: aload_0
    //   1222: getfield 18	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry	Lcom/tencent/mobileqq/editor/database/PublishVideoEntry;
    //   1225: getfield 210	com/tencent/mobileqq/editor/database/PublishVideoEntry:mLocalRawVideoDir	Ljava/lang/String;
    //   1228: astore 5
    //   1230: aload_0
    //   1231: getfield 14	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_ComTencentMobileqqActivityShortvideoEncodeVideoTask$2	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2;
    //   1234: getfield 39	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2:a	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   1237: invokestatic 212	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:b	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)Z
    //   1240: ifeq +25 -> 1265
    //   1243: new 100	java/io/File
    //   1246: dup
    //   1247: aload_0
    //   1248: getfield 18	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry	Lcom/tencent/mobileqq/editor/database/PublishVideoEntry;
    //   1251: getfield 210	com/tencent/mobileqq/editor/database/PublishVideoEntry:mLocalRawVideoDir	Ljava/lang/String;
    //   1254: invokespecial 103	java/io/File:<init>	(Ljava/lang/String;)V
    //   1257: invokevirtual 216	java/io/File:getParentFile	()Ljava/io/File;
    //   1260: invokevirtual 219	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1263: astore 5
    //   1265: aload 5
    //   1267: invokestatic 223	com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:c	(Ljava/lang/String;)V
    //   1270: aload 5
    //   1272: invokestatic 226	com/tencent/mobileqq/utils/FileUtils:deleteDirectory	(Ljava/lang/String;)V
    //   1275: goto +10 -> 1285
    //   1278: astore 5
    //   1280: aload 5
    //   1282: invokevirtual 227	java/lang/Exception:printStackTrace	()V
    //   1285: invokestatic 138	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1288: ifeq +238 -> 1526
    //   1291: new 157	java/lang/StringBuilder
    //   1294: dup
    //   1295: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   1298: astore 5
    //   1300: aload 5
    //   1302: ldc 229
    //   1304: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1307: pop
    //   1308: aload 5
    //   1310: aload_0
    //   1311: getfield 14	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_ComTencentMobileqqActivityShortvideoEncodeVideoTask$2	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2;
    //   1314: getfield 39	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2:a	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   1317: invokestatic 44	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:a	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)Ljava/lang/String;
    //   1320: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1323: pop
    //   1324: aload 5
    //   1326: ldc 231
    //   1328: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1331: pop
    //   1332: aload 5
    //   1334: aload_0
    //   1335: getfield 14	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_ComTencentMobileqqActivityShortvideoEncodeVideoTask$2	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2;
    //   1338: getfield 39	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2:a	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   1341: invokestatic 123	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:a	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)[B
    //   1344: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1347: pop
    //   1348: aload 5
    //   1350: ldc 236
    //   1352: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1355: pop
    //   1356: aload 5
    //   1358: aload_0
    //   1359: getfield 14	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_ComTencentMobileqqActivityShortvideoEncodeVideoTask$2	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2;
    //   1362: getfield 39	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2:a	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   1365: invokestatic 73	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:b	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)Ljava/lang/String;
    //   1368: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1371: pop
    //   1372: aload 5
    //   1374: ldc 238
    //   1376: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1379: pop
    //   1380: aload 5
    //   1382: aload_0
    //   1383: getfield 14	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_ComTencentMobileqqActivityShortvideoEncodeVideoTask$2	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2;
    //   1386: getfield 39	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2:a	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   1389: invokestatic 241	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:a	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)I
    //   1392: invokevirtual 198	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1395: pop
    //   1396: aload 5
    //   1398: ldc 243
    //   1400: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1403: pop
    //   1404: aload 5
    //   1406: aload_0
    //   1407: getfield 14	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_ComTencentMobileqqActivityShortvideoEncodeVideoTask$2	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2;
    //   1410: getfield 39	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2:a	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   1413: invokestatic 245	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:b	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)I
    //   1416: invokevirtual 198	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1419: pop
    //   1420: aload 5
    //   1422: ldc 247
    //   1424: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1427: pop
    //   1428: aload 5
    //   1430: aload_0
    //   1431: getfield 14	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_ComTencentMobileqqActivityShortvideoEncodeVideoTask$2	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2;
    //   1434: getfield 39	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2:a	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   1437: invokestatic 186	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:c	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)Ljava/lang/String;
    //   1440: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1443: pop
    //   1444: aload 5
    //   1446: ldc 249
    //   1448: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1451: pop
    //   1452: aload 5
    //   1454: aload_0
    //   1455: getfield 18	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry	Lcom/tencent/mobileqq/editor/database/PublishVideoEntry;
    //   1458: getfield 253	com/tencent/mobileqq/editor/database/PublishVideoEntry:recordTime	D
    //   1461: d2i
    //   1462: invokevirtual 198	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1465: pop
    //   1466: aload 5
    //   1468: ldc 255
    //   1470: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1473: pop
    //   1474: aload 5
    //   1476: aload_0
    //   1477: getfield 14	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_ComTencentMobileqqActivityShortvideoEncodeVideoTask$2	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2;
    //   1480: getfield 39	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2:a	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   1483: invokestatic 190	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:b	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)[B
    //   1486: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1489: pop
    //   1490: aload 5
    //   1492: ldc_w 257
    //   1495: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1498: pop
    //   1499: aload 5
    //   1501: aload_0
    //   1502: getfield 14	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_ComTencentMobileqqActivityShortvideoEncodeVideoTask$2	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2;
    //   1505: getfield 39	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2:a	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   1508: invokestatic 259	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:d	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)Ljava/lang/String;
    //   1511: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1514: pop
    //   1515: ldc 168
    //   1517: iconst_2
    //   1518: aload 5
    //   1520: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1523: invokestatic 201	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1526: aload_0
    //   1527: getfield 14	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_ComTencentMobileqqActivityShortvideoEncodeVideoTask$2	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2;
    //   1530: getfield 39	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2:a	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   1533: invokestatic 262	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:a	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)Lcom/tencent/mobileqq/shortvideo/ResultListener;
    //   1536: ifnull +86 -> 1622
    //   1539: aload_0
    //   1540: getfield 14	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_ComTencentMobileqqActivityShortvideoEncodeVideoTask$2	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2;
    //   1543: getfield 39	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2:a	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   1546: invokestatic 262	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:a	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)Lcom/tencent/mobileqq/shortvideo/ResultListener;
    //   1549: aload_0
    //   1550: getfield 14	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_ComTencentMobileqqActivityShortvideoEncodeVideoTask$2	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2;
    //   1553: getfield 39	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2:a	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   1556: invokestatic 186	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:c	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)Ljava/lang/String;
    //   1559: aload_0
    //   1560: getfield 14	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_ComTencentMobileqqActivityShortvideoEncodeVideoTask$2	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2;
    //   1563: getfield 39	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2:a	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   1566: invokestatic 190	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:b	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)[B
    //   1569: aload_0
    //   1570: getfield 14	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_ComTencentMobileqqActivityShortvideoEncodeVideoTask$2	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2;
    //   1573: getfield 39	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2:a	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   1576: invokestatic 44	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:a	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)Ljava/lang/String;
    //   1579: aload_0
    //   1580: getfield 14	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_ComTencentMobileqqActivityShortvideoEncodeVideoTask$2	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2;
    //   1583: getfield 39	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2:a	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   1586: invokestatic 241	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:a	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)I
    //   1589: aload_0
    //   1590: getfield 14	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_ComTencentMobileqqActivityShortvideoEncodeVideoTask$2	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2;
    //   1593: getfield 39	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2:a	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   1596: invokestatic 245	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:b	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)I
    //   1599: aload_0
    //   1600: getfield 14	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_ComTencentMobileqqActivityShortvideoEncodeVideoTask$2	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2;
    //   1603: getfield 39	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2:a	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   1606: invokestatic 123	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:a	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)[B
    //   1609: aload_0
    //   1610: getfield 18	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry	Lcom/tencent/mobileqq/editor/database/PublishVideoEntry;
    //   1613: getfield 253	com/tencent/mobileqq/editor/database/PublishVideoEntry:recordTime	D
    //   1616: d2i
    //   1617: invokeinterface 267 8 0
    //   1622: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1623	0	this	1
    //   7	1107	1	i	int
    //   967	237	2	j	int
    //   304	711	3	l	long
    //   4	325	5	localObject1	Object
    //   362	3	5	localIOException1	java.io.IOException
    //   409	94	5	str	String
    //   530	1	5	localObject2	Object
    //   545	1	5	localObject3	Object
    //   565	3	5	localIOException2	java.io.IOException
    //   623	356	5	localObject4	Object
    //   1058	13	5	localObject5	Object
    //   1076	14	5	localObject6	Object
    //   1118	31	5	localIOException3	java.io.IOException
    //   1171	100	5	localObject7	Object
    //   1278	3	5	localException	java.lang.Exception
    //   1298	221	5	localStringBuilder	java.lang.StringBuilder
    //   103	585	6	localObject8	Object
    //   695	3	6	localIOException4	java.io.IOException
    //   750	384	6	localObject9	Object
    //   1141	3	6	localIOException5	java.io.IOException
    //   266	34	7	localFile	java.io.File
    //   525	1	7	localFileNotFoundException1	java.io.FileNotFoundException
    //   538	10	7	localFileNotFoundException2	java.io.FileNotFoundException
    //   672	7	7	localObject10	Object
    //   791	209	7	localObject11	Object
    //   1063	1	7	localFileNotFoundException3	java.io.FileNotFoundException
    //   1068	7	7	localObject12	Object
    //   1081	11	7	localFileNotFoundException4	java.io.FileNotFoundException
    //   62	1022	8	localObject13	Object
    //   65	912	9	localObject14	Object
    // Exception table:
    //   from	to	target	type
    //   354	359	362	java/io/IOException
    //   299	305	525	java/io/FileNotFoundException
    //   309	326	525	java/io/FileNotFoundException
    //   330	354	525	java/io/FileNotFoundException
    //   276	295	530	finally
    //   276	295	538	java/io/FileNotFoundException
    //   557	562	565	java/io/IOException
    //   299	305	672	finally
    //   309	326	672	finally
    //   330	354	672	finally
    //   547	552	672	finally
    //   687	692	695	java/io/IOException
    //   999	1046	1058	finally
    //   999	1046	1063	java/io/FileNotFoundException
    //   980	999	1068	finally
    //   1091	1096	1068	finally
    //   980	999	1081	java/io/FileNotFoundException
    //   1048	1053	1118	java/io/IOException
    //   1108	1113	1118	java/io/IOException
    //   1133	1138	1141	java/io/IOException
    //   1208	1230	1278	java/lang/Exception
    //   1230	1265	1278	java/lang/Exception
    //   1265	1275	1278	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.shortvideo.EncodeVideoTask.2.1
 * JD-Core Version:    0.7.0.1
 */