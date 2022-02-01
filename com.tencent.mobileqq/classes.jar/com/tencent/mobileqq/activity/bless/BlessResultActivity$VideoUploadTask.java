package com.tencent.mobileqq.activity.bless;

import com.tencent.mobileqq.troop.data.TroopBarShortVideoUploadUtil.OnUploadVideoListener;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

class BlessResultActivity$VideoUploadTask
  implements Runnable
{
  private long jdField_a_of_type_Long = -1L;
  public BlessResultActivity.VideoInfo a;
  private TroopBarShortVideoUploadUtil.OnUploadVideoListener jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarShortVideoUploadUtil$OnUploadVideoListener;
  private String jdField_a_of_type_JavaLangString = null;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(true);
  private String b = null;
  private String c;
  private String d;
  
  public BlessResultActivity$VideoUploadTask(BlessResultActivity paramBlessResultActivity, String paramString1, String paramString2, BlessResultActivity.VideoInfo paramVideoInfo, TroopBarShortVideoUploadUtil.OnUploadVideoListener paramOnUploadVideoListener)
  {
    this.c = paramString1;
    this.d = paramString2;
    this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessResultActivity$VideoInfo = paramVideoInfo;
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarShortVideoUploadUtil$OnUploadVideoListener = paramOnUploadVideoListener;
    if (this.jdField_a_of_type_JavaLangString == null) {
      this.jdField_a_of_type_JavaLangString = paramBlessResultActivity.getString(2131695887);
    }
    if (this.b == null) {
      this.b = paramBlessResultActivity.getString(2131690689);
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BlessResultActivity", 2, "VideoUploadTask stop()");
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
  
  public boolean b()
  {
    boolean bool = a() ^ true;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("VideoUploadTask isRunning(),result = ");
      localStringBuilder.append(bool);
      QLog.d("BlessResultActivity", 2, localStringBuilder.toString());
    }
    return bool;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: invokestatic 104	java/lang/System:currentTimeMillis	()J
    //   3: lstore 12
    //   5: invokestatic 62	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8: ifeq +11 -> 19
    //   11: ldc 64
    //   13: iconst_2
    //   14: ldc 106
    //   16: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   19: aload_0
    //   20: getfield 35	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   23: iconst_0
    //   24: invokevirtual 72	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   27: aload_0
    //   28: getfield 47	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarShortVideoUploadUtil$OnUploadVideoListener	Lcom/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$OnUploadVideoListener;
    //   31: ifnonnull +26 -> 57
    //   34: aload_0
    //   35: getfield 35	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   38: iconst_1
    //   39: invokevirtual 72	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   42: invokestatic 62	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   45: ifeq +11 -> 56
    //   48: ldc 108
    //   50: iconst_2
    //   51: ldc 110
    //   53: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   56: return
    //   57: aload_0
    //   58: getfield 45	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:jdField_a_of_type_ComTencentMobileqqActivityBlessBlessResultActivity$VideoInfo	Lcom/tencent/mobileqq/activity/bless/BlessResultActivity$VideoInfo;
    //   61: ifnull +1475 -> 1536
    //   64: aload_0
    //   65: getfield 41	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:c	Ljava/lang/String;
    //   68: invokestatic 116	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   71: ifne +1465 -> 1536
    //   74: aload_0
    //   75: getfield 43	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:d	Ljava/lang/String;
    //   78: invokestatic 116	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   81: ifeq +6 -> 87
    //   84: goto +1452 -> 1536
    //   87: aload_0
    //   88: getfield 45	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:jdField_a_of_type_ComTencentMobileqqActivityBlessBlessResultActivity$VideoInfo	Lcom/tencent/mobileqq/activity/bless/BlessResultActivity$VideoInfo;
    //   91: getfield 119	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   94: astore 19
    //   96: new 121	java/io/File
    //   99: dup
    //   100: aload_0
    //   101: getfield 45	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:jdField_a_of_type_ComTencentMobileqqActivityBlessBlessResultActivity$VideoInfo	Lcom/tencent/mobileqq/activity/bless/BlessResultActivity$VideoInfo;
    //   104: getfield 119	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   107: invokespecial 124	java/io/File:<init>	(Ljava/lang/String;)V
    //   110: invokevirtual 127	java/io/File:getName	()Ljava/lang/String;
    //   113: astore 16
    //   115: new 129	android/os/Bundle
    //   118: dup
    //   119: invokespecial 130	android/os/Bundle:<init>	()V
    //   122: astore 17
    //   124: aload 17
    //   126: ldc 132
    //   128: aload_0
    //   129: getfield 26	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   132: invokevirtual 136	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   135: aload 17
    //   137: ldc 138
    //   139: aload 19
    //   141: invokevirtual 136	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   144: aload 17
    //   146: ldc 140
    //   148: aload_0
    //   149: getfield 28	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:b	Ljava/lang/String;
    //   152: invokevirtual 136	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   155: aload 17
    //   157: ldc 142
    //   159: aload 16
    //   161: invokevirtual 136	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   164: aload 17
    //   166: ldc 144
    //   168: aload_0
    //   169: getfield 45	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:jdField_a_of_type_ComTencentMobileqqActivityBlessBlessResultActivity$VideoInfo	Lcom/tencent/mobileqq/activity/bless/BlessResultActivity$VideoInfo;
    //   172: getfield 145	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoInfo:b	Ljava/lang/String;
    //   175: invokevirtual 136	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   178: invokestatic 151	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   181: invokestatic 157	com/tencent/biz/common/util/HttpUtil:isConnect	(Landroid/content/Context;)Z
    //   184: ifeq +34 -> 218
    //   187: aload_0
    //   188: getfield 35	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   191: invokevirtual 75	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   194: ifne +24 -> 218
    //   197: aload 17
    //   199: aload_0
    //   200: getfield 41	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:c	Ljava/lang/String;
    //   203: aload_0
    //   204: getfield 43	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:d	Ljava/lang/String;
    //   207: ldc 159
    //   209: iconst_0
    //   210: invokestatic 162	com/tencent/mobileqq/activity/bless/BlessResultActivity:a	(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Lcom/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$ApplyUploadRsp;
    //   213: astore 17
    //   215: goto +6 -> 221
    //   218: aconst_null
    //   219: astore 17
    //   221: aload 17
    //   223: ifnull +1114 -> 1337
    //   226: aload 19
    //   228: invokestatic 168	com/tencent/mobileqq/utils/FileUtils:getFileSizes	(Ljava/lang/String;)J
    //   231: lstore 6
    //   233: lload 6
    //   235: ldc2_w 169
    //   238: lcmp
    //   239: ifle +11 -> 250
    //   242: ldc2_w 169
    //   245: lstore 4
    //   247: goto +7 -> 254
    //   250: lload 6
    //   252: lstore 4
    //   254: invokestatic 62	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   257: ifeq +61 -> 318
    //   260: new 79	java/lang/StringBuilder
    //   263: dup
    //   264: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   267: astore 16
    //   269: aload 16
    //   271: ldc 172
    //   273: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: pop
    //   277: aload 16
    //   279: aload 17
    //   281: getfield 177	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$ApplyUploadRsp:h	Ljava/lang/String;
    //   284: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: pop
    //   288: aload 16
    //   290: ldc 179
    //   292: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: pop
    //   296: aload 16
    //   298: aload 17
    //   300: getfield 180	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$ApplyUploadRsp:d	Ljava/lang/String;
    //   303: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: pop
    //   307: ldc 64
    //   309: iconst_2
    //   310: aload 16
    //   312: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   315: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   318: ldc 182
    //   320: aload 17
    //   322: getfield 177	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$ApplyUploadRsp:h	Ljava/lang/String;
    //   325: invokevirtual 188	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   328: ifeq +128 -> 456
    //   331: aload_0
    //   332: getfield 47	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarShortVideoUploadUtil$OnUploadVideoListener	Lcom/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$OnUploadVideoListener;
    //   335: astore 16
    //   337: lload 4
    //   339: l2d
    //   340: dstore_1
    //   341: dload_1
    //   342: invokestatic 194	java/lang/Double:isNaN	(D)Z
    //   345: pop
    //   346: aload 16
    //   348: dload_1
    //   349: ldc2_w 195
    //   352: dmul
    //   353: d2l
    //   354: invokeinterface 201 3 0
    //   359: aload_0
    //   360: getfield 35	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   363: invokevirtual 75	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   366: ifne +68 -> 434
    //   369: aload 19
    //   371: aload_0
    //   372: getfield 21	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:this$0	Lcom/tencent/mobileqq/activity/bless/BlessResultActivity;
    //   375: getfield 202	com/tencent/mobileqq/activity/bless/BlessResultActivity:b	Ljava/lang/String;
    //   378: aload_0
    //   379: getfield 41	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:c	Ljava/lang/String;
    //   382: aload_0
    //   383: getfield 43	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:d	Ljava/lang/String;
    //   386: aload 17
    //   388: getfield 205	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$ApplyUploadRsp:f	Ljava/lang/String;
    //   391: aload 17
    //   393: getfield 208	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$ApplyUploadRsp:g	Ljava/lang/String;
    //   396: ldc 159
    //   398: invokestatic 211	com/tencent/mobileqq/activity/bless/BlessResultActivity:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    //   401: istore 15
    //   403: iload 15
    //   405: istore 14
    //   407: lload 4
    //   409: ldc2_w 36
    //   412: lcmp
    //   413: ifeq +24 -> 437
    //   416: aload_0
    //   417: getfield 47	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarShortVideoUploadUtil$OnUploadVideoListener	Lcom/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$OnUploadVideoListener;
    //   420: lload 4
    //   422: invokeinterface 201 3 0
    //   427: iload 15
    //   429: istore 14
    //   431: goto +6 -> 437
    //   434: iconst_1
    //   435: istore 14
    //   437: aload_0
    //   438: getfield 21	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:this$0	Lcom/tencent/mobileqq/activity/bless/BlessResultActivity;
    //   441: aload 17
    //   443: getfield 205	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$ApplyUploadRsp:f	Ljava/lang/String;
    //   446: putfield 212	com/tencent/mobileqq/activity/bless/BlessResultActivity:d	Ljava/lang/String;
    //   449: iload 14
    //   451: istore 15
    //   453: goto +887 -> 1340
    //   456: aload 17
    //   458: getfield 205	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$ApplyUploadRsp:f	Ljava/lang/String;
    //   461: ifnull +876 -> 1337
    //   464: aload 17
    //   466: getfield 213	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$ApplyUploadRsp:c	Ljava/lang/String;
    //   469: invokestatic 219	com/tencent/mobileqq/utils/HexUtil:hexStr2Bytes	(Ljava/lang/String;)[B
    //   472: astore 20
    //   474: aload 19
    //   476: invokestatic 223	com/tencent/mobileqq/filemanager/util/FileManagerUtil:a	(Ljava/lang/String;)[B
    //   479: astore 21
    //   481: new 79	java/lang/StringBuilder
    //   484: dup
    //   485: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   488: astore 16
    //   490: aload 16
    //   492: ldc 225
    //   494: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   497: pop
    //   498: aload 16
    //   500: aload 17
    //   502: getfield 226	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$ApplyUploadRsp:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   505: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   508: pop
    //   509: aload 16
    //   511: ldc 228
    //   513: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   516: pop
    //   517: aload 16
    //   519: aload 17
    //   521: getfield 229	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$ApplyUploadRsp:b	Ljava/lang/String;
    //   524: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   527: pop
    //   528: aload 16
    //   530: ldc 231
    //   532: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   535: pop
    //   536: aload 16
    //   538: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   541: astore 22
    //   543: invokestatic 62	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   546: ifeq +58 -> 604
    //   549: new 79	java/lang/StringBuilder
    //   552: dup
    //   553: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   556: astore 16
    //   558: aload 16
    //   560: ldc 233
    //   562: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   565: pop
    //   566: aload 16
    //   568: aload 22
    //   570: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   573: pop
    //   574: aload 16
    //   576: ldc 235
    //   578: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   581: pop
    //   582: aload 16
    //   584: aload 17
    //   586: getfield 205	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$ApplyUploadRsp:f	Ljava/lang/String;
    //   589: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   592: pop
    //   593: ldc 64
    //   595: iconst_2
    //   596: aload 16
    //   598: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   601: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   604: aload_0
    //   605: getfield 47	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarShortVideoUploadUtil$OnUploadVideoListener	Lcom/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$OnUploadVideoListener;
    //   608: invokeinterface 237 1 0
    //   613: new 239	java/io/RandomAccessFile
    //   616: dup
    //   617: aload 19
    //   619: ldc 241
    //   621: invokespecial 243	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   624: astore 16
    //   626: lconst_0
    //   627: lstore 8
    //   629: lload 4
    //   631: lload 8
    //   633: lsub
    //   634: l2i
    //   635: istore_3
    //   636: invokestatic 151	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   639: invokestatic 157	com/tencent/biz/common/util/HttpUtil:isConnect	(Landroid/content/Context;)Z
    //   642: istore 14
    //   644: iload 14
    //   646: ifeq +194 -> 840
    //   649: aload 16
    //   651: astore 18
    //   653: aload_0
    //   654: getfield 35	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   657: invokevirtual 75	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   660: ifne +180 -> 840
    //   663: aload 16
    //   665: astore 18
    //   667: aload 20
    //   669: aload 21
    //   671: aload 22
    //   673: lload 6
    //   675: aload 16
    //   677: lload 8
    //   679: iload_3
    //   680: invokestatic 248	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil:a	([B[BLjava/lang/String;JLjava/io/RandomAccessFile;JI)J
    //   683: lstore 8
    //   685: aload 16
    //   687: astore 18
    //   689: aload_0
    //   690: lload 8
    //   692: putfield 39	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:jdField_a_of_type_Long	J
    //   695: lload 8
    //   697: ldc2_w 36
    //   700: lcmp
    //   701: ifeq +57 -> 758
    //   704: aload 16
    //   706: astore 18
    //   708: aload_0
    //   709: invokevirtual 77	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:a	()Z
    //   712: ifne +935 -> 1647
    //   715: aload 16
    //   717: astore 18
    //   719: aload_0
    //   720: getfield 47	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarShortVideoUploadUtil$OnUploadVideoListener	Lcom/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$OnUploadVideoListener;
    //   723: astore 23
    //   725: lload 8
    //   727: l2d
    //   728: dstore_1
    //   729: dload_1
    //   730: invokestatic 194	java/lang/Double:isNaN	(D)Z
    //   733: pop
    //   734: dload_1
    //   735: ldc2_w 195
    //   738: dmul
    //   739: d2l
    //   740: lstore 4
    //   742: aload 16
    //   744: astore 18
    //   746: aload 23
    //   748: lload 4
    //   750: invokeinterface 201 3 0
    //   755: goto +892 -> 1647
    //   758: lload 8
    //   760: lstore 6
    //   762: aload 16
    //   764: astore 18
    //   766: invokestatic 62	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   769: ifeq +145 -> 914
    //   772: aload 16
    //   774: astore 18
    //   776: new 79	java/lang/StringBuilder
    //   779: dup
    //   780: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   783: astore 20
    //   785: aload 16
    //   787: astore 18
    //   789: aload 20
    //   791: ldc 250
    //   793: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   796: pop
    //   797: aload 16
    //   799: astore 18
    //   801: aload 20
    //   803: invokestatic 104	java/lang/System:currentTimeMillis	()J
    //   806: lload 12
    //   808: lsub
    //   809: invokevirtual 253	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   812: pop
    //   813: aload 16
    //   815: astore 18
    //   817: ldc 64
    //   819: iconst_2
    //   820: aload 20
    //   822: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   825: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   828: lload 8
    //   830: lstore 6
    //   832: goto +82 -> 914
    //   835: astore 17
    //   837: goto +346 -> 1183
    //   840: invokestatic 62	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   843: istore 14
    //   845: lload 4
    //   847: lstore 6
    //   849: iload 14
    //   851: ifeq +63 -> 914
    //   854: aload 16
    //   856: astore 18
    //   858: new 79	java/lang/StringBuilder
    //   861: dup
    //   862: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   865: astore 20
    //   867: aload 16
    //   869: astore 18
    //   871: aload 20
    //   873: ldc 255
    //   875: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   878: pop
    //   879: aload 16
    //   881: astore 18
    //   883: aload 20
    //   885: invokestatic 104	java/lang/System:currentTimeMillis	()J
    //   888: lload 12
    //   890: lsub
    //   891: invokevirtual 253	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   894: pop
    //   895: aload 16
    //   897: astore 18
    //   899: ldc 64
    //   901: iconst_2
    //   902: aload 20
    //   904: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   907: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   910: lload 4
    //   912: lstore 6
    //   914: iconst_1
    //   915: istore_3
    //   916: iload_3
    //   917: iconst_1
    //   918: ixor
    //   919: istore 14
    //   921: invokestatic 62	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   924: istore 15
    //   926: iload 15
    //   928: ifeq +56 -> 984
    //   931: aload 16
    //   933: astore 18
    //   935: new 79	java/lang/StringBuilder
    //   938: dup
    //   939: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   942: astore 20
    //   944: aload 16
    //   946: astore 18
    //   948: aload 20
    //   950: ldc_w 257
    //   953: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   956: pop
    //   957: aload 16
    //   959: astore 18
    //   961: aload 20
    //   963: iload 14
    //   965: invokevirtual 89	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   968: pop
    //   969: aload 16
    //   971: astore 18
    //   973: ldc 64
    //   975: iconst_2
    //   976: aload 20
    //   978: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   981: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   984: iload 14
    //   986: ifeq +705 -> 1691
    //   989: aload_0
    //   990: getfield 35	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   993: invokevirtual 75	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   996: ifne +695 -> 1691
    //   999: aload_0
    //   1000: getfield 21	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:this$0	Lcom/tencent/mobileqq/activity/bless/BlessResultActivity;
    //   1003: getfield 202	com/tencent/mobileqq/activity/bless/BlessResultActivity:b	Ljava/lang/String;
    //   1006: astore 18
    //   1008: aload_0
    //   1009: getfield 41	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:c	Ljava/lang/String;
    //   1012: astore 20
    //   1014: aload_0
    //   1015: getfield 43	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:d	Ljava/lang/String;
    //   1018: astore 21
    //   1020: aload 17
    //   1022: getfield 205	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$ApplyUploadRsp:f	Ljava/lang/String;
    //   1025: astore 22
    //   1027: aload 17
    //   1029: getfield 208	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$ApplyUploadRsp:g	Ljava/lang/String;
    //   1032: astore 23
    //   1034: aload 19
    //   1036: aload 18
    //   1038: aload 20
    //   1040: aload 21
    //   1042: aload 22
    //   1044: aload 23
    //   1046: ldc 159
    //   1048: invokestatic 211	com/tencent/mobileqq/activity/bless/BlessResultActivity:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    //   1051: istore 15
    //   1053: iload 15
    //   1055: istore 14
    //   1057: lload 6
    //   1059: ldc2_w 36
    //   1062: lcmp
    //   1063: ifeq +21 -> 1084
    //   1066: aload_0
    //   1067: getfield 47	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarShortVideoUploadUtil$OnUploadVideoListener	Lcom/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$OnUploadVideoListener;
    //   1070: lload 6
    //   1072: invokeinterface 201 3 0
    //   1077: iload 15
    //   1079: istore 14
    //   1081: goto +3 -> 1084
    //   1084: aload_0
    //   1085: getfield 21	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:this$0	Lcom/tencent/mobileqq/activity/bless/BlessResultActivity;
    //   1088: aload 17
    //   1090: getfield 205	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$ApplyUploadRsp:f	Ljava/lang/String;
    //   1093: putfield 212	com/tencent/mobileqq/activity/bless/BlessResultActivity:d	Ljava/lang/String;
    //   1096: aload 16
    //   1098: invokevirtual 260	java/io/RandomAccessFile:close	()V
    //   1101: iload 14
    //   1103: istore 15
    //   1105: goto +235 -> 1340
    //   1108: astore 16
    //   1110: iload 14
    //   1112: istore 15
    //   1114: invokestatic 62	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1117: ifeq +223 -> 1340
    //   1120: ldc 64
    //   1122: iconst_2
    //   1123: aload 16
    //   1125: invokestatic 264	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1128: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1131: iload 14
    //   1133: istore 15
    //   1135: goto +205 -> 1340
    //   1138: astore 17
    //   1140: aload 16
    //   1142: astore 18
    //   1144: aload 17
    //   1146: astore 16
    //   1148: aload 18
    //   1150: astore 17
    //   1152: goto +150 -> 1302
    //   1155: astore 17
    //   1157: goto +26 -> 1183
    //   1160: astore 17
    //   1162: goto +128 -> 1290
    //   1165: astore 17
    //   1167: goto +16 -> 1183
    //   1170: astore 16
    //   1172: aconst_null
    //   1173: astore 17
    //   1175: goto +127 -> 1302
    //   1178: astore 17
    //   1180: aconst_null
    //   1181: astore 16
    //   1183: aload 16
    //   1185: astore 18
    //   1187: invokestatic 62	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1190: ifeq +59 -> 1249
    //   1193: aload 16
    //   1195: astore 18
    //   1197: new 79	java/lang/StringBuilder
    //   1200: dup
    //   1201: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   1204: astore 19
    //   1206: aload 16
    //   1208: astore 18
    //   1210: aload 19
    //   1212: ldc_w 266
    //   1215: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1218: pop
    //   1219: aload 16
    //   1221: astore 18
    //   1223: aload 19
    //   1225: aload 17
    //   1227: invokestatic 264	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1230: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1233: pop
    //   1234: aload 16
    //   1236: astore 18
    //   1238: ldc 64
    //   1240: iconst_2
    //   1241: aload 19
    //   1243: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1246: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1249: aload 16
    //   1251: ifnull +86 -> 1337
    //   1254: aload 16
    //   1256: invokevirtual 260	java/io/RandomAccessFile:close	()V
    //   1259: goto +78 -> 1337
    //   1262: astore 16
    //   1264: invokestatic 62	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1267: ifeq +70 -> 1337
    //   1270: ldc 64
    //   1272: iconst_2
    //   1273: aload 16
    //   1275: invokestatic 264	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1278: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1281: goto +56 -> 1337
    //   1284: astore 17
    //   1286: aload 18
    //   1288: astore 16
    //   1290: aload 17
    //   1292: astore 18
    //   1294: aload 16
    //   1296: astore 17
    //   1298: aload 18
    //   1300: astore 16
    //   1302: aload 17
    //   1304: ifnull +30 -> 1334
    //   1307: aload 17
    //   1309: invokevirtual 260	java/io/RandomAccessFile:close	()V
    //   1312: goto +22 -> 1334
    //   1315: astore 17
    //   1317: invokestatic 62	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1320: ifeq +14 -> 1334
    //   1323: ldc 64
    //   1325: iconst_2
    //   1326: aload 17
    //   1328: invokestatic 264	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1331: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1334: aload 16
    //   1336: athrow
    //   1337: iconst_0
    //   1338: istore 15
    //   1340: aload_0
    //   1341: getfield 35	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   1344: iconst_0
    //   1345: iconst_1
    //   1346: invokevirtual 270	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
    //   1349: ifeq +126 -> 1475
    //   1352: iload 15
    //   1354: ifeq +60 -> 1414
    //   1357: aload_0
    //   1358: getfield 47	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarShortVideoUploadUtil$OnUploadVideoListener	Lcom/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$OnUploadVideoListener;
    //   1361: invokeinterface 272 1 0
    //   1366: invokestatic 62	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1369: ifeq +166 -> 1535
    //   1372: new 79	java/lang/StringBuilder
    //   1375: dup
    //   1376: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   1379: astore 16
    //   1381: aload 16
    //   1383: ldc_w 274
    //   1386: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1389: pop
    //   1390: aload 16
    //   1392: invokestatic 104	java/lang/System:currentTimeMillis	()J
    //   1395: lload 12
    //   1397: lsub
    //   1398: invokevirtual 253	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1401: pop
    //   1402: ldc 64
    //   1404: iconst_2
    //   1405: aload 16
    //   1407: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1410: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1413: return
    //   1414: aload_0
    //   1415: getfield 47	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarShortVideoUploadUtil$OnUploadVideoListener	Lcom/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$OnUploadVideoListener;
    //   1418: aload_0
    //   1419: getfield 39	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:jdField_a_of_type_Long	J
    //   1422: invokeinterface 276 3 0
    //   1427: invokestatic 62	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1430: ifeq +105 -> 1535
    //   1433: new 79	java/lang/StringBuilder
    //   1436: dup
    //   1437: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   1440: astore 16
    //   1442: aload 16
    //   1444: ldc_w 278
    //   1447: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1450: pop
    //   1451: aload 16
    //   1453: invokestatic 104	java/lang/System:currentTimeMillis	()J
    //   1456: lload 12
    //   1458: lsub
    //   1459: invokevirtual 253	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1462: pop
    //   1463: ldc 64
    //   1465: iconst_2
    //   1466: aload 16
    //   1468: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1471: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1474: return
    //   1475: aload_0
    //   1476: getfield 47	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarShortVideoUploadUtil$OnUploadVideoListener	Lcom/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$OnUploadVideoListener;
    //   1479: aload_0
    //   1480: getfield 39	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:jdField_a_of_type_Long	J
    //   1483: invokeinterface 280 3 0
    //   1488: invokestatic 62	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1491: ifeq +44 -> 1535
    //   1494: new 79	java/lang/StringBuilder
    //   1497: dup
    //   1498: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   1501: astore 16
    //   1503: aload 16
    //   1505: ldc_w 282
    //   1508: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1511: pop
    //   1512: aload 16
    //   1514: invokestatic 104	java/lang/System:currentTimeMillis	()J
    //   1517: lload 12
    //   1519: lsub
    //   1520: invokevirtual 253	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1523: pop
    //   1524: ldc 64
    //   1526: iconst_2
    //   1527: aload 16
    //   1529: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1532: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1535: return
    //   1536: aload_0
    //   1537: getfield 35	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   1540: iconst_1
    //   1541: invokevirtual 72	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   1544: aload_0
    //   1545: getfield 47	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarShortVideoUploadUtil$OnUploadVideoListener	Lcom/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$OnUploadVideoListener;
    //   1548: ldc2_w 36
    //   1551: invokeinterface 276 3 0
    //   1556: invokestatic 62	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1559: ifeq +87 -> 1646
    //   1562: aload_0
    //   1563: getfield 45	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:jdField_a_of_type_ComTencentMobileqqActivityBlessBlessResultActivity$VideoInfo	Lcom/tencent/mobileqq/activity/bless/BlessResultActivity$VideoInfo;
    //   1566: ifnonnull +11 -> 1577
    //   1569: ldc_w 284
    //   1572: astore 16
    //   1574: goto +26 -> 1600
    //   1577: aload_0
    //   1578: getfield 41	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:c	Ljava/lang/String;
    //   1581: invokestatic 116	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1584: ifeq +11 -> 1595
    //   1587: ldc_w 286
    //   1590: astore 16
    //   1592: goto +8 -> 1600
    //   1595: ldc_w 288
    //   1598: astore 16
    //   1600: new 79	java/lang/StringBuilder
    //   1603: dup
    //   1604: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   1607: astore 17
    //   1609: aload 17
    //   1611: ldc_w 290
    //   1614: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1617: pop
    //   1618: aload 17
    //   1620: aload 16
    //   1622: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1625: pop
    //   1626: aload 17
    //   1628: ldc_w 292
    //   1631: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1634: pop
    //   1635: ldc 108
    //   1637: iconst_2
    //   1638: aload 17
    //   1640: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1643: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1646: return
    //   1647: lload 8
    //   1649: ldc2_w 169
    //   1652: ladd
    //   1653: lstore 10
    //   1655: lload 10
    //   1657: lstore 4
    //   1659: lload 10
    //   1661: lload 6
    //   1663: lcmp
    //   1664: ifle +7 -> 1671
    //   1667: lload 6
    //   1669: lstore 4
    //   1671: lload 8
    //   1673: lload 6
    //   1675: lcmp
    //   1676: iflt +12 -> 1688
    //   1679: iconst_0
    //   1680: istore_3
    //   1681: lload 4
    //   1683: lstore 6
    //   1685: goto -769 -> 916
    //   1688: goto -1059 -> 629
    //   1691: goto -607 -> 1084
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1694	0	this	VideoUploadTask
    //   340	395	1	d1	double
    //   635	1046	3	i	int
    //   245	1437	4	l1	long
    //   231	1453	6	l2	long
    //   627	1045	8	l3	long
    //   1653	7	10	l4	long
    //   3	1515	12	l5	long
    //   405	727	14	bool1	boolean
    //   401	952	15	bool2	boolean
    //   113	984	16	localObject1	Object
    //   1108	33	16	localIOException1	java.io.IOException
    //   1146	1	16	localObject2	Object
    //   1170	1	16	localObject3	Object
    //   1181	74	16	localObject4	Object
    //   1262	12	16	localIOException2	java.io.IOException
    //   1288	333	16	localObject5	Object
    //   122	463	17	localObject6	Object
    //   835	254	17	localException1	java.lang.Exception
    //   1138	7	17	localObject7	Object
    //   1150	1	17	localObject8	Object
    //   1155	1	17	localException2	java.lang.Exception
    //   1160	1	17	localObject9	Object
    //   1165	1	17	localException3	java.lang.Exception
    //   1173	1	17	localObject10	Object
    //   1178	48	17	localException4	java.lang.Exception
    //   1284	7	17	localObject11	Object
    //   1296	12	17	localObject12	Object
    //   1315	12	17	localIOException3	java.io.IOException
    //   1607	32	17	localStringBuilder	StringBuilder
    //   651	648	18	localObject13	Object
    //   94	1148	19	localObject14	Object
    //   472	567	20	localObject15	Object
    //   479	562	21	localObject16	Object
    //   541	502	22	str	String
    //   723	322	23	localObject17	Object
    // Exception table:
    //   from	to	target	type
    //   653	663	835	java/lang/Exception
    //   667	685	835	java/lang/Exception
    //   689	695	835	java/lang/Exception
    //   708	715	835	java/lang/Exception
    //   719	725	835	java/lang/Exception
    //   746	755	835	java/lang/Exception
    //   766	772	835	java/lang/Exception
    //   776	785	835	java/lang/Exception
    //   789	797	835	java/lang/Exception
    //   801	813	835	java/lang/Exception
    //   817	828	835	java/lang/Exception
    //   858	867	835	java/lang/Exception
    //   871	879	835	java/lang/Exception
    //   883	895	835	java/lang/Exception
    //   899	910	835	java/lang/Exception
    //   935	944	835	java/lang/Exception
    //   948	957	835	java/lang/Exception
    //   961	969	835	java/lang/Exception
    //   973	984	835	java/lang/Exception
    //   1096	1101	1108	java/io/IOException
    //   1034	1053	1138	finally
    //   1066	1077	1138	finally
    //   1084	1096	1138	finally
    //   1034	1053	1155	java/lang/Exception
    //   1066	1077	1155	java/lang/Exception
    //   1084	1096	1155	java/lang/Exception
    //   636	644	1160	finally
    //   840	845	1160	finally
    //   921	926	1160	finally
    //   989	1034	1160	finally
    //   636	644	1165	java/lang/Exception
    //   840	845	1165	java/lang/Exception
    //   921	926	1165	java/lang/Exception
    //   989	1034	1165	java/lang/Exception
    //   604	626	1170	finally
    //   604	626	1178	java/lang/Exception
    //   1254	1259	1262	java/io/IOException
    //   653	663	1284	finally
    //   667	685	1284	finally
    //   689	695	1284	finally
    //   708	715	1284	finally
    //   719	725	1284	finally
    //   746	755	1284	finally
    //   766	772	1284	finally
    //   776	785	1284	finally
    //   789	797	1284	finally
    //   801	813	1284	finally
    //   817	828	1284	finally
    //   858	867	1284	finally
    //   871	879	1284	finally
    //   883	895	1284	finally
    //   899	910	1284	finally
    //   935	944	1284	finally
    //   948	957	1284	finally
    //   961	969	1284	finally
    //   973	984	1284	finally
    //   1187	1193	1284	finally
    //   1197	1206	1284	finally
    //   1210	1219	1284	finally
    //   1223	1234	1284	finally
    //   1238	1249	1284	finally
    //   1307	1312	1315	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.bless.BlessResultActivity.VideoUploadTask
 * JD-Core Version:    0.7.0.1
 */