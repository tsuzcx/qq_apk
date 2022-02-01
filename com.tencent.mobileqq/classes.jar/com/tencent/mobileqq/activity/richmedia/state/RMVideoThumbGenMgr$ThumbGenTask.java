package com.tencent.mobileqq.activity.richmedia.state;

import android.os.AsyncTask;

class RMVideoThumbGenMgr$ThumbGenTask
  extends AsyncTask<Void, Void, Integer>
{
  RMVideoThumbGenMgr.ThumbGenItem jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr$ThumbGenItem;
  
  /* Error */
  protected Integer a(Void... paramVarArgs)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 19	com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenTask:jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr	Lcom/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr;
    //   4: invokevirtual 24	com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr:a	()V
    //   7: new 26	java/lang/StringBuilder
    //   10: dup
    //   11: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   14: astore_1
    //   15: aload_1
    //   16: getstatic 34	com/tencent/mobileqq/shortvideo/common/GloableValue:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   19: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: pop
    //   23: aload_1
    //   24: getstatic 43	java/io/File:separator	Ljava/lang/String;
    //   27: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: pop
    //   31: aload_1
    //   32: ldc 45
    //   34: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: pop
    //   38: new 40	java/io/File
    //   41: dup
    //   42: aload_1
    //   43: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   46: invokespecial 52	java/io/File:<init>	(Ljava/lang/String;)V
    //   49: astore_1
    //   50: aload_1
    //   51: invokevirtual 56	java/io/File:exists	()Z
    //   54: ifne +11 -> 65
    //   57: aload_1
    //   58: invokevirtual 59	java/io/File:createNewFile	()Z
    //   61: pop
    //   62: goto +3 -> 65
    //   65: aload_0
    //   66: getfield 61	com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenTask:jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr$ThumbGenItem	Lcom/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem;
    //   69: getfield 66	com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   72: iconst_2
    //   73: invokevirtual 72	java/util/concurrent/atomic/AtomicInteger:getAndSet	(I)I
    //   76: pop
    //   77: aload_0
    //   78: getfield 61	com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenTask:jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr$ThumbGenItem	Lcom/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem;
    //   81: getfield 75	com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem:jdField_a_of_type_Boolean	Z
    //   84: ifeq +29 -> 113
    //   87: aload_0
    //   88: getfield 61	com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenTask:jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr$ThumbGenItem	Lcom/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem;
    //   91: getfield 66	com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   94: iconst_4
    //   95: invokevirtual 72	java/util/concurrent/atomic/AtomicInteger:getAndSet	(I)I
    //   98: pop
    //   99: aload_0
    //   100: getfield 61	com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenTask:jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr$ThumbGenItem	Lcom/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem;
    //   103: getfield 66	com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   106: invokevirtual 79	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   109: invokestatic 85	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   112: areturn
    //   113: aload_0
    //   114: getfield 61	com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenTask:jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr$ThumbGenItem	Lcom/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem;
    //   117: getfield 86	com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   120: aload_0
    //   121: getfield 61	com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenTask:jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr$ThumbGenItem	Lcom/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem;
    //   124: getfield 89	com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem:jdField_a_of_type_Int	I
    //   127: aload_0
    //   128: getfield 61	com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenTask:jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr$ThumbGenItem	Lcom/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem;
    //   131: getfield 92	com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem:jdField_b_of_type_Int	I
    //   134: aload_0
    //   135: getfield 61	com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenTask:jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr$ThumbGenItem	Lcom/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem;
    //   138: getfield 95	com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem:jdField_c_of_type_Int	I
    //   141: getstatic 101	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   144: invokestatic 106	com/tencent/mobileqq/shortvideo/cover/RecordThumbnailUtils:a	(Ljava/lang/String;IIILandroid/graphics/Bitmap$Config;)Ljava/lang/String;
    //   147: astore 4
    //   149: goto +11 -> 160
    //   152: astore_1
    //   153: aload_1
    //   154: invokevirtual 109	java/lang/OutOfMemoryError:printStackTrace	()V
    //   157: aconst_null
    //   158: astore 4
    //   160: aload 4
    //   162: ifnonnull +29 -> 191
    //   165: aload_0
    //   166: getfield 61	com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenTask:jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr$ThumbGenItem	Lcom/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem;
    //   169: getfield 66	com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   172: iconst_5
    //   173: invokevirtual 72	java/util/concurrent/atomic/AtomicInteger:getAndSet	(I)I
    //   176: pop
    //   177: aload_0
    //   178: getfield 61	com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenTask:jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr$ThumbGenItem	Lcom/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem;
    //   181: getfield 66	com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   184: invokevirtual 79	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   187: invokestatic 85	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   190: areturn
    //   191: new 40	java/io/File
    //   194: dup
    //   195: aload 4
    //   197: invokespecial 52	java/io/File:<init>	(Ljava/lang/String;)V
    //   200: astore 5
    //   202: aload 5
    //   204: invokevirtual 56	java/io/File:exists	()Z
    //   207: ifne +29 -> 236
    //   210: aload_0
    //   211: getfield 61	com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenTask:jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr$ThumbGenItem	Lcom/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem;
    //   214: getfield 66	com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   217: iconst_5
    //   218: invokevirtual 72	java/util/concurrent/atomic/AtomicInteger:getAndSet	(I)I
    //   221: pop
    //   222: aload_0
    //   223: getfield 61	com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenTask:jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr$ThumbGenItem	Lcom/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem;
    //   226: getfield 66	com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   229: invokevirtual 79	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   232: invokestatic 85	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   235: areturn
    //   236: aload_0
    //   237: getfield 61	com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenTask:jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr$ThumbGenItem	Lcom/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem;
    //   240: getfield 75	com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem:jdField_a_of_type_Boolean	Z
    //   243: ifeq +35 -> 278
    //   246: aload_0
    //   247: getfield 61	com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenTask:jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr$ThumbGenItem	Lcom/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem;
    //   250: getfield 66	com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   253: iconst_4
    //   254: invokevirtual 72	java/util/concurrent/atomic/AtomicInteger:getAndSet	(I)I
    //   257: pop
    //   258: aload 4
    //   260: invokestatic 115	com/tencent/mobileqq/utils/FileUtils:deleteFile	(Ljava/lang/String;)Z
    //   263: pop
    //   264: aload_0
    //   265: getfield 61	com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenTask:jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr$ThumbGenItem	Lcom/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem;
    //   268: getfield 66	com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   271: invokevirtual 79	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   274: invokestatic 85	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   277: areturn
    //   278: new 117	java/io/FileInputStream
    //   281: dup
    //   282: aload 4
    //   284: invokespecial 118	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   287: astore_3
    //   288: aload_3
    //   289: astore_1
    //   290: aload_3
    //   291: aload 5
    //   293: invokevirtual 122	java/io/File:length	()J
    //   296: invokestatic 128	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   299: astore 5
    //   301: aload_3
    //   302: astore_1
    //   303: aload_0
    //   304: getfield 61	com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenTask:jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr$ThumbGenItem	Lcom/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem;
    //   307: aload 5
    //   309: invokestatic 134	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   312: putfield 137	com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem:d	Ljava/lang/String;
    //   315: aload_3
    //   316: invokevirtual 140	java/io/FileInputStream:close	()V
    //   319: goto +8 -> 327
    //   322: astore_1
    //   323: aload_1
    //   324: invokevirtual 141	java/io/IOException:printStackTrace	()V
    //   327: aload_0
    //   328: getfield 61	com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenTask:jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr$ThumbGenItem	Lcom/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem;
    //   331: astore_1
    //   332: aload_1
    //   333: aload 4
    //   335: putfield 143	com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   338: aload_1
    //   339: getfield 137	com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem:d	Ljava/lang/String;
    //   342: invokestatic 149	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   345: ifeq +21 -> 366
    //   348: aload_0
    //   349: getfield 61	com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenTask:jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr$ThumbGenItem	Lcom/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem;
    //   352: getfield 66	com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   355: bipush 6
    //   357: invokevirtual 72	java/util/concurrent/atomic/AtomicInteger:getAndSet	(I)I
    //   360: pop
    //   361: aconst_null
    //   362: astore_1
    //   363: goto +60 -> 423
    //   366: aload_0
    //   367: getfield 61	com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenTask:jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr$ThumbGenItem	Lcom/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem;
    //   370: getfield 137	com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem:d	Ljava/lang/String;
    //   373: ldc 151
    //   375: invokestatic 156	com/tencent/mobileqq/shortvideo/SVUtils:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   378: astore_1
    //   379: aload 4
    //   381: aload_1
    //   382: invokestatic 160	com/tencent/mobileqq/utils/FileUtils:rename	(Ljava/lang/String;Ljava/lang/String;)Z
    //   385: ifeq +25 -> 410
    //   388: aload_0
    //   389: getfield 61	com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenTask:jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr$ThumbGenItem	Lcom/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem;
    //   392: astore_3
    //   393: aload_3
    //   394: aload_1
    //   395: putfield 162	com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   398: aload_3
    //   399: getfield 66	com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   402: iconst_3
    //   403: invokevirtual 72	java/util/concurrent/atomic/AtomicInteger:getAndSet	(I)I
    //   406: pop
    //   407: goto +16 -> 423
    //   410: aload_0
    //   411: getfield 61	com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenTask:jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr$ThumbGenItem	Lcom/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem;
    //   414: getfield 66	com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   417: bipush 6
    //   419: invokevirtual 72	java/util/concurrent/atomic/AtomicInteger:getAndSet	(I)I
    //   422: pop
    //   423: aload_0
    //   424: getfield 61	com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenTask:jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr$ThumbGenItem	Lcom/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem;
    //   427: getfield 75	com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem:jdField_a_of_type_Boolean	Z
    //   430: ifeq +428 -> 858
    //   433: aload_0
    //   434: getfield 61	com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenTask:jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr$ThumbGenItem	Lcom/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem;
    //   437: getfield 66	com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   440: iconst_4
    //   441: invokevirtual 72	java/util/concurrent/atomic/AtomicInteger:getAndSet	(I)I
    //   444: istore_2
    //   445: aload_0
    //   446: getfield 61	com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenTask:jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr$ThumbGenItem	Lcom/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem;
    //   449: astore_3
    //   450: aload_3
    //   451: aconst_null
    //   452: putfield 162	com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   455: aload_3
    //   456: aconst_null
    //   457: putfield 143	com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   460: iload_2
    //   461: iconst_3
    //   462: if_icmpne +11 -> 473
    //   465: aload_1
    //   466: invokestatic 115	com/tencent/mobileqq/utils/FileUtils:deleteFile	(Ljava/lang/String;)Z
    //   469: pop
    //   470: goto +388 -> 858
    //   473: iload_2
    //   474: bipush 6
    //   476: if_icmpne +382 -> 858
    //   479: aload 4
    //   481: invokestatic 115	com/tencent/mobileqq/utils/FileUtils:deleteFile	(Ljava/lang/String;)Z
    //   484: pop
    //   485: goto +373 -> 858
    //   488: astore 5
    //   490: goto +18 -> 508
    //   493: astore 5
    //   495: goto +190 -> 685
    //   498: astore_1
    //   499: aconst_null
    //   500: astore_3
    //   501: goto +378 -> 879
    //   504: astore 5
    //   506: aconst_null
    //   507: astore_3
    //   508: aload_3
    //   509: astore_1
    //   510: aload 5
    //   512: invokevirtual 163	java/lang/UnsatisfiedLinkError:printStackTrace	()V
    //   515: aload_3
    //   516: ifnull +15 -> 531
    //   519: aload_3
    //   520: invokevirtual 140	java/io/FileInputStream:close	()V
    //   523: goto +8 -> 531
    //   526: astore_1
    //   527: aload_1
    //   528: invokevirtual 141	java/io/IOException:printStackTrace	()V
    //   531: aload_0
    //   532: getfield 61	com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenTask:jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr$ThumbGenItem	Lcom/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem;
    //   535: astore_1
    //   536: aload_1
    //   537: aload 4
    //   539: putfield 143	com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   542: aload_1
    //   543: getfield 137	com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem:d	Ljava/lang/String;
    //   546: invokestatic 149	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   549: ifeq +21 -> 570
    //   552: aload_0
    //   553: getfield 61	com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenTask:jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr$ThumbGenItem	Lcom/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem;
    //   556: getfield 66	com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   559: bipush 6
    //   561: invokevirtual 72	java/util/concurrent/atomic/AtomicInteger:getAndSet	(I)I
    //   564: pop
    //   565: aconst_null
    //   566: astore_1
    //   567: goto +60 -> 627
    //   570: aload_0
    //   571: getfield 61	com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenTask:jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr$ThumbGenItem	Lcom/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem;
    //   574: getfield 137	com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem:d	Ljava/lang/String;
    //   577: ldc 151
    //   579: invokestatic 156	com/tencent/mobileqq/shortvideo/SVUtils:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   582: astore_1
    //   583: aload 4
    //   585: aload_1
    //   586: invokestatic 160	com/tencent/mobileqq/utils/FileUtils:rename	(Ljava/lang/String;Ljava/lang/String;)Z
    //   589: ifeq +25 -> 614
    //   592: aload_0
    //   593: getfield 61	com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenTask:jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr$ThumbGenItem	Lcom/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem;
    //   596: astore_3
    //   597: aload_3
    //   598: aload_1
    //   599: putfield 162	com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   602: aload_3
    //   603: getfield 66	com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   606: iconst_3
    //   607: invokevirtual 72	java/util/concurrent/atomic/AtomicInteger:getAndSet	(I)I
    //   610: pop
    //   611: goto +16 -> 627
    //   614: aload_0
    //   615: getfield 61	com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenTask:jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr$ThumbGenItem	Lcom/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem;
    //   618: getfield 66	com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   621: bipush 6
    //   623: invokevirtual 72	java/util/concurrent/atomic/AtomicInteger:getAndSet	(I)I
    //   626: pop
    //   627: aload_0
    //   628: getfield 61	com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenTask:jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr$ThumbGenItem	Lcom/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem;
    //   631: getfield 75	com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem:jdField_a_of_type_Boolean	Z
    //   634: ifeq +224 -> 858
    //   637: aload_0
    //   638: getfield 61	com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenTask:jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr$ThumbGenItem	Lcom/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem;
    //   641: getfield 66	com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   644: iconst_4
    //   645: invokevirtual 72	java/util/concurrent/atomic/AtomicInteger:getAndSet	(I)I
    //   648: istore_2
    //   649: aload_0
    //   650: getfield 61	com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenTask:jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr$ThumbGenItem	Lcom/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem;
    //   653: astore_3
    //   654: aload_3
    //   655: aconst_null
    //   656: putfield 162	com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   659: aload_3
    //   660: aconst_null
    //   661: putfield 143	com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   664: iload_2
    //   665: iconst_3
    //   666: if_icmpne +6 -> 672
    //   669: goto -204 -> 465
    //   672: iload_2
    //   673: bipush 6
    //   675: if_icmpne +183 -> 858
    //   678: goto -199 -> 479
    //   681: astore 5
    //   683: aconst_null
    //   684: astore_3
    //   685: aload_3
    //   686: astore_1
    //   687: aload 5
    //   689: invokevirtual 164	java/io/FileNotFoundException:printStackTrace	()V
    //   692: aload_3
    //   693: ifnull +15 -> 708
    //   696: aload_3
    //   697: invokevirtual 140	java/io/FileInputStream:close	()V
    //   700: goto +8 -> 708
    //   703: astore_1
    //   704: aload_1
    //   705: invokevirtual 141	java/io/IOException:printStackTrace	()V
    //   708: aload_0
    //   709: getfield 61	com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenTask:jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr$ThumbGenItem	Lcom/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem;
    //   712: astore_1
    //   713: aload_1
    //   714: aload 4
    //   716: putfield 143	com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   719: aload_1
    //   720: getfield 137	com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem:d	Ljava/lang/String;
    //   723: invokestatic 149	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   726: ifeq +21 -> 747
    //   729: aload_0
    //   730: getfield 61	com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenTask:jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr$ThumbGenItem	Lcom/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem;
    //   733: getfield 66	com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   736: bipush 6
    //   738: invokevirtual 72	java/util/concurrent/atomic/AtomicInteger:getAndSet	(I)I
    //   741: pop
    //   742: aconst_null
    //   743: astore_1
    //   744: goto +60 -> 804
    //   747: aload_0
    //   748: getfield 61	com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenTask:jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr$ThumbGenItem	Lcom/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem;
    //   751: getfield 137	com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem:d	Ljava/lang/String;
    //   754: ldc 151
    //   756: invokestatic 156	com/tencent/mobileqq/shortvideo/SVUtils:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   759: astore_1
    //   760: aload 4
    //   762: aload_1
    //   763: invokestatic 160	com/tencent/mobileqq/utils/FileUtils:rename	(Ljava/lang/String;Ljava/lang/String;)Z
    //   766: ifeq +25 -> 791
    //   769: aload_0
    //   770: getfield 61	com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenTask:jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr$ThumbGenItem	Lcom/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem;
    //   773: astore_3
    //   774: aload_3
    //   775: aload_1
    //   776: putfield 162	com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   779: aload_3
    //   780: getfield 66	com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   783: iconst_3
    //   784: invokevirtual 72	java/util/concurrent/atomic/AtomicInteger:getAndSet	(I)I
    //   787: pop
    //   788: goto +16 -> 804
    //   791: aload_0
    //   792: getfield 61	com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenTask:jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr$ThumbGenItem	Lcom/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem;
    //   795: getfield 66	com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   798: bipush 6
    //   800: invokevirtual 72	java/util/concurrent/atomic/AtomicInteger:getAndSet	(I)I
    //   803: pop
    //   804: aload_0
    //   805: getfield 61	com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenTask:jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr$ThumbGenItem	Lcom/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem;
    //   808: getfield 75	com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem:jdField_a_of_type_Boolean	Z
    //   811: ifeq +47 -> 858
    //   814: aload_0
    //   815: getfield 61	com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenTask:jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr$ThumbGenItem	Lcom/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem;
    //   818: getfield 66	com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   821: iconst_4
    //   822: invokevirtual 72	java/util/concurrent/atomic/AtomicInteger:getAndSet	(I)I
    //   825: istore_2
    //   826: aload_0
    //   827: getfield 61	com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenTask:jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr$ThumbGenItem	Lcom/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem;
    //   830: astore_3
    //   831: aload_3
    //   832: aconst_null
    //   833: putfield 162	com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   836: aload_3
    //   837: aconst_null
    //   838: putfield 143	com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   841: iload_2
    //   842: iconst_3
    //   843: if_icmpne +6 -> 849
    //   846: goto -381 -> 465
    //   849: iload_2
    //   850: bipush 6
    //   852: if_icmpne +6 -> 858
    //   855: goto -376 -> 479
    //   858: aload_0
    //   859: getfield 61	com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenTask:jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr$ThumbGenItem	Lcom/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem;
    //   862: getfield 66	com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   865: invokevirtual 79	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   868: invokestatic 85	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   871: areturn
    //   872: astore 5
    //   874: aload_1
    //   875: astore_3
    //   876: aload 5
    //   878: astore_1
    //   879: aload_3
    //   880: ifnull +15 -> 895
    //   883: aload_3
    //   884: invokevirtual 140	java/io/FileInputStream:close	()V
    //   887: goto +8 -> 895
    //   890: astore_3
    //   891: aload_3
    //   892: invokevirtual 141	java/io/IOException:printStackTrace	()V
    //   895: aload_0
    //   896: getfield 61	com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenTask:jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr$ThumbGenItem	Lcom/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem;
    //   899: astore_3
    //   900: aload_3
    //   901: aload 4
    //   903: putfield 143	com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   906: aload_3
    //   907: getfield 137	com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem:d	Ljava/lang/String;
    //   910: invokestatic 149	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   913: ifeq +21 -> 934
    //   916: aload_0
    //   917: getfield 61	com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenTask:jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr$ThumbGenItem	Lcom/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem;
    //   920: getfield 66	com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   923: bipush 6
    //   925: invokevirtual 72	java/util/concurrent/atomic/AtomicInteger:getAndSet	(I)I
    //   928: pop
    //   929: aconst_null
    //   930: astore_3
    //   931: goto +63 -> 994
    //   934: aload_0
    //   935: getfield 61	com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenTask:jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr$ThumbGenItem	Lcom/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem;
    //   938: getfield 137	com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem:d	Ljava/lang/String;
    //   941: ldc 151
    //   943: invokestatic 156	com/tencent/mobileqq/shortvideo/SVUtils:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   946: astore_3
    //   947: aload 4
    //   949: aload_3
    //   950: invokestatic 160	com/tencent/mobileqq/utils/FileUtils:rename	(Ljava/lang/String;Ljava/lang/String;)Z
    //   953: ifeq +28 -> 981
    //   956: aload_0
    //   957: getfield 61	com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenTask:jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr$ThumbGenItem	Lcom/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem;
    //   960: astore 5
    //   962: aload 5
    //   964: aload_3
    //   965: putfield 162	com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   968: aload 5
    //   970: getfield 66	com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   973: iconst_3
    //   974: invokevirtual 72	java/util/concurrent/atomic/AtomicInteger:getAndSet	(I)I
    //   977: pop
    //   978: goto +16 -> 994
    //   981: aload_0
    //   982: getfield 61	com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenTask:jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr$ThumbGenItem	Lcom/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem;
    //   985: getfield 66	com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   988: bipush 6
    //   990: invokevirtual 72	java/util/concurrent/atomic/AtomicInteger:getAndSet	(I)I
    //   993: pop
    //   994: aload_0
    //   995: getfield 61	com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenTask:jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr$ThumbGenItem	Lcom/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem;
    //   998: getfield 75	com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem:jdField_a_of_type_Boolean	Z
    //   1001: ifeq +58 -> 1059
    //   1004: aload_0
    //   1005: getfield 61	com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenTask:jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr$ThumbGenItem	Lcom/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem;
    //   1008: getfield 66	com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   1011: iconst_4
    //   1012: invokevirtual 72	java/util/concurrent/atomic/AtomicInteger:getAndSet	(I)I
    //   1015: istore_2
    //   1016: aload_0
    //   1017: getfield 61	com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenTask:jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr$ThumbGenItem	Lcom/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem;
    //   1020: astore 5
    //   1022: aload 5
    //   1024: aconst_null
    //   1025: putfield 162	com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   1028: aload 5
    //   1030: aconst_null
    //   1031: putfield 143	com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1034: iload_2
    //   1035: iconst_3
    //   1036: if_icmpeq +18 -> 1054
    //   1039: iload_2
    //   1040: bipush 6
    //   1042: if_icmpne +17 -> 1059
    //   1045: aload 4
    //   1047: invokestatic 115	com/tencent/mobileqq/utils/FileUtils:deleteFile	(Ljava/lang/String;)Z
    //   1050: pop
    //   1051: goto +8 -> 1059
    //   1054: aload_3
    //   1055: invokestatic 115	com/tencent/mobileqq/utils/FileUtils:deleteFile	(Ljava/lang/String;)Z
    //   1058: pop
    //   1059: goto +5 -> 1064
    //   1062: aload_1
    //   1063: athrow
    //   1064: goto -2 -> 1062
    //   1067: astore_1
    //   1068: goto -1003 -> 65
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1071	0	this	ThumbGenTask
    //   0	1071	1	paramVarArgs	Void[]
    //   444	599	2	i	int
    //   287	597	3	localObject1	java.lang.Object
    //   890	2	3	localIOException	java.io.IOException
    //   899	156	3	localObject2	java.lang.Object
    //   147	899	4	str	java.lang.String
    //   200	108	5	localObject3	java.lang.Object
    //   488	1	5	localUnsatisfiedLinkError1	java.lang.UnsatisfiedLinkError
    //   493	1	5	localFileNotFoundException1	java.io.FileNotFoundException
    //   504	7	5	localUnsatisfiedLinkError2	java.lang.UnsatisfiedLinkError
    //   681	7	5	localFileNotFoundException2	java.io.FileNotFoundException
    //   872	5	5	localObject4	java.lang.Object
    //   960	69	5	localThumbGenItem	RMVideoThumbGenMgr.ThumbGenItem
    // Exception table:
    //   from	to	target	type
    //   113	149	152	java/lang/OutOfMemoryError
    //   315	319	322	java/io/IOException
    //   290	301	488	java/lang/UnsatisfiedLinkError
    //   303	315	488	java/lang/UnsatisfiedLinkError
    //   290	301	493	java/io/FileNotFoundException
    //   303	315	493	java/io/FileNotFoundException
    //   278	288	498	finally
    //   278	288	504	java/lang/UnsatisfiedLinkError
    //   519	523	526	java/io/IOException
    //   278	288	681	java/io/FileNotFoundException
    //   696	700	703	java/io/IOException
    //   290	301	872	finally
    //   303	315	872	finally
    //   510	515	872	finally
    //   687	692	872	finally
    //   883	887	890	java/io/IOException
    //   57	62	1067	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.state.RMVideoThumbGenMgr.ThumbGenTask
 * JD-Core Version:    0.7.0.1
 */