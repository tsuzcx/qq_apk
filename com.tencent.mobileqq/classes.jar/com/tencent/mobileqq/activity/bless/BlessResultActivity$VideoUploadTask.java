package com.tencent.mobileqq.activity.bless;

import com.tencent.mobileqq.troop.data.TroopBarShortVideoUploadUtil.OnUploadVideoListener;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

class BlessResultActivity$VideoUploadTask
  implements Runnable
{
  public BlessResultActivity.VideoInfo a;
  private String b = null;
  private String c = null;
  private String d;
  private String e;
  private TroopBarShortVideoUploadUtil.OnUploadVideoListener f;
  private AtomicBoolean g = new AtomicBoolean(true);
  private long h = -1L;
  
  public BlessResultActivity$VideoUploadTask(BlessResultActivity paramBlessResultActivity, String paramString1, String paramString2, BlessResultActivity.VideoInfo paramVideoInfo, TroopBarShortVideoUploadUtil.OnUploadVideoListener paramOnUploadVideoListener)
  {
    this.d = paramString1;
    this.e = paramString2;
    this.a = paramVideoInfo;
    this.f = paramOnUploadVideoListener;
    if (this.b == null) {
      this.b = paramBlessResultActivity.getString(2131893647);
    }
    if (this.c == null) {
      this.c = paramBlessResultActivity.getString(2131887604);
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BlessResultActivity", 2, "VideoUploadTask stop()");
    }
    this.g.set(true);
  }
  
  public boolean b()
  {
    return this.g.get();
  }
  
  public boolean c()
  {
    boolean bool = b() ^ true;
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
    //   0: invokestatic 108	java/lang/System:currentTimeMillis	()J
    //   3: lstore 12
    //   5: invokestatic 66	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8: ifeq +11 -> 19
    //   11: ldc 68
    //   13: iconst_2
    //   14: ldc 110
    //   16: invokestatic 73	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   19: aload_0
    //   20: getfield 39	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:g	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   23: iconst_0
    //   24: invokevirtual 76	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   27: aload_0
    //   28: getfield 51	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:f	Lcom/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$OnUploadVideoListener;
    //   31: ifnonnull +26 -> 57
    //   34: aload_0
    //   35: getfield 39	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:g	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   38: iconst_1
    //   39: invokevirtual 76	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   42: invokestatic 66	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   45: ifeq +11 -> 56
    //   48: ldc 112
    //   50: iconst_2
    //   51: ldc 114
    //   53: invokestatic 73	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   56: return
    //   57: aload_0
    //   58: getfield 49	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:a	Lcom/tencent/mobileqq/activity/bless/BlessResultActivity$VideoInfo;
    //   61: ifnull +1476 -> 1537
    //   64: aload_0
    //   65: getfield 45	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:d	Ljava/lang/String;
    //   68: invokestatic 120	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   71: ifne +1466 -> 1537
    //   74: aload_0
    //   75: getfield 47	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:e	Ljava/lang/String;
    //   78: invokestatic 120	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   81: ifeq +6 -> 87
    //   84: goto +1453 -> 1537
    //   87: aload_0
    //   88: getfield 49	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:a	Lcom/tencent/mobileqq/activity/bless/BlessResultActivity$VideoInfo;
    //   91: getfield 124	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoInfo:a	Ljava/lang/String;
    //   94: astore 19
    //   96: new 126	java/io/File
    //   99: dup
    //   100: aload_0
    //   101: getfield 49	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:a	Lcom/tencent/mobileqq/activity/bless/BlessResultActivity$VideoInfo;
    //   104: getfield 124	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoInfo:a	Ljava/lang/String;
    //   107: invokespecial 129	java/io/File:<init>	(Ljava/lang/String;)V
    //   110: invokevirtual 132	java/io/File:getName	()Ljava/lang/String;
    //   113: astore 16
    //   115: new 134	android/os/Bundle
    //   118: dup
    //   119: invokespecial 135	android/os/Bundle:<init>	()V
    //   122: astore 17
    //   124: aload 17
    //   126: ldc 137
    //   128: aload_0
    //   129: getfield 30	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:b	Ljava/lang/String;
    //   132: invokevirtual 141	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   135: aload 17
    //   137: ldc 143
    //   139: aload 19
    //   141: invokevirtual 141	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   144: aload 17
    //   146: ldc 145
    //   148: aload_0
    //   149: getfield 32	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:c	Ljava/lang/String;
    //   152: invokevirtual 141	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   155: aload 17
    //   157: ldc 147
    //   159: aload 16
    //   161: invokevirtual 141	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   164: aload 17
    //   166: ldc 149
    //   168: aload_0
    //   169: getfield 49	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:a	Lcom/tencent/mobileqq/activity/bless/BlessResultActivity$VideoInfo;
    //   172: getfield 150	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoInfo:b	Ljava/lang/String;
    //   175: invokevirtual 141	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   178: invokestatic 156	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   181: invokestatic 162	com/tencent/biz/common/util/HttpUtil:isConnect	(Landroid/content/Context;)Z
    //   184: ifeq +34 -> 218
    //   187: aload_0
    //   188: getfield 39	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:g	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   191: invokevirtual 79	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   194: ifne +24 -> 218
    //   197: aload 17
    //   199: aload_0
    //   200: getfield 45	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:d	Ljava/lang/String;
    //   203: aload_0
    //   204: getfield 47	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:e	Ljava/lang/String;
    //   207: ldc 164
    //   209: iconst_0
    //   210: invokestatic 167	com/tencent/mobileqq/activity/bless/BlessResultActivity:a	(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Lcom/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$ApplyUploadRsp;
    //   213: astore 17
    //   215: goto +6 -> 221
    //   218: aconst_null
    //   219: astore 17
    //   221: aload 17
    //   223: ifnull +1115 -> 1338
    //   226: aload 19
    //   228: invokestatic 173	com/tencent/mobileqq/utils/FileUtils:getFileSizes	(Ljava/lang/String;)J
    //   231: lstore 6
    //   233: lload 6
    //   235: ldc2_w 174
    //   238: lcmp
    //   239: ifle +11 -> 250
    //   242: ldc2_w 174
    //   245: lstore 4
    //   247: goto +7 -> 254
    //   250: lload 6
    //   252: lstore 4
    //   254: invokestatic 66	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   257: ifeq +61 -> 318
    //   260: new 83	java/lang/StringBuilder
    //   263: dup
    //   264: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   267: astore 16
    //   269: aload 16
    //   271: ldc 177
    //   273: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: pop
    //   277: aload 16
    //   279: aload 17
    //   281: getfield 181	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$ApplyUploadRsp:h	Ljava/lang/String;
    //   284: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: pop
    //   288: aload 16
    //   290: ldc 183
    //   292: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: pop
    //   296: aload 16
    //   298: aload 17
    //   300: getfield 184	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$ApplyUploadRsp:d	Ljava/lang/String;
    //   303: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: pop
    //   307: ldc 68
    //   309: iconst_2
    //   310: aload 16
    //   312: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   315: invokestatic 73	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   318: ldc 186
    //   320: aload 17
    //   322: getfield 181	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$ApplyUploadRsp:h	Ljava/lang/String;
    //   325: invokevirtual 192	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   328: ifeq +128 -> 456
    //   331: aload_0
    //   332: getfield 51	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:f	Lcom/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$OnUploadVideoListener;
    //   335: astore 16
    //   337: lload 4
    //   339: l2d
    //   340: dstore_1
    //   341: dload_1
    //   342: invokestatic 198	java/lang/Double:isNaN	(D)Z
    //   345: pop
    //   346: aload 16
    //   348: dload_1
    //   349: ldc2_w 199
    //   352: dmul
    //   353: d2l
    //   354: invokeinterface 205 3 0
    //   359: aload_0
    //   360: getfield 39	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:g	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   363: invokevirtual 79	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   366: ifne +68 -> 434
    //   369: aload 19
    //   371: aload_0
    //   372: getfield 25	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:this$0	Lcom/tencent/mobileqq/activity/bless/BlessResultActivity;
    //   375: getfield 206	com/tencent/mobileqq/activity/bless/BlessResultActivity:c	Ljava/lang/String;
    //   378: aload_0
    //   379: getfield 45	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:d	Ljava/lang/String;
    //   382: aload_0
    //   383: getfield 47	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:e	Ljava/lang/String;
    //   386: aload 17
    //   388: getfield 208	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$ApplyUploadRsp:f	Ljava/lang/String;
    //   391: aload 17
    //   393: getfield 210	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$ApplyUploadRsp:g	Ljava/lang/String;
    //   396: ldc 164
    //   398: invokestatic 213	com/tencent/mobileqq/activity/bless/BlessResultActivity:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    //   401: istore 15
    //   403: iload 15
    //   405: istore 14
    //   407: lload 4
    //   409: ldc2_w 40
    //   412: lcmp
    //   413: ifeq +24 -> 437
    //   416: aload_0
    //   417: getfield 51	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:f	Lcom/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$OnUploadVideoListener;
    //   420: lload 4
    //   422: invokeinterface 205 3 0
    //   427: iload 15
    //   429: istore 14
    //   431: goto +6 -> 437
    //   434: iconst_1
    //   435: istore 14
    //   437: aload_0
    //   438: getfield 25	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:this$0	Lcom/tencent/mobileqq/activity/bless/BlessResultActivity;
    //   441: aload 17
    //   443: getfield 208	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$ApplyUploadRsp:f	Ljava/lang/String;
    //   446: putfield 214	com/tencent/mobileqq/activity/bless/BlessResultActivity:f	Ljava/lang/String;
    //   449: iload 14
    //   451: istore 15
    //   453: goto +888 -> 1341
    //   456: aload 17
    //   458: getfield 208	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$ApplyUploadRsp:f	Ljava/lang/String;
    //   461: ifnull +877 -> 1338
    //   464: aload 17
    //   466: getfield 215	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$ApplyUploadRsp:c	Ljava/lang/String;
    //   469: invokestatic 221	com/tencent/mobileqq/utils/HexUtil:hexStr2Bytes	(Ljava/lang/String;)[B
    //   472: astore 20
    //   474: aload 19
    //   476: invokestatic 225	com/tencent/mobileqq/filemanager/util/FileManagerUtil:d	(Ljava/lang/String;)[B
    //   479: astore 21
    //   481: new 83	java/lang/StringBuilder
    //   484: dup
    //   485: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   488: astore 16
    //   490: aload 16
    //   492: ldc 227
    //   494: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   497: pop
    //   498: aload 16
    //   500: aload 17
    //   502: getfield 228	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$ApplyUploadRsp:a	Ljava/lang/String;
    //   505: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   508: pop
    //   509: aload 16
    //   511: ldc 230
    //   513: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   516: pop
    //   517: aload 16
    //   519: aload 17
    //   521: getfield 231	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$ApplyUploadRsp:b	Ljava/lang/String;
    //   524: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   527: pop
    //   528: aload 16
    //   530: ldc 233
    //   532: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   535: pop
    //   536: aload 16
    //   538: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   541: astore 22
    //   543: invokestatic 66	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   546: ifeq +58 -> 604
    //   549: new 83	java/lang/StringBuilder
    //   552: dup
    //   553: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   556: astore 16
    //   558: aload 16
    //   560: ldc 235
    //   562: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   565: pop
    //   566: aload 16
    //   568: aload 22
    //   570: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   573: pop
    //   574: aload 16
    //   576: ldc 237
    //   578: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   581: pop
    //   582: aload 16
    //   584: aload 17
    //   586: getfield 208	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$ApplyUploadRsp:f	Ljava/lang/String;
    //   589: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   592: pop
    //   593: ldc 68
    //   595: iconst_2
    //   596: aload 16
    //   598: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   601: invokestatic 73	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   604: aload_0
    //   605: getfield 51	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:f	Lcom/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$OnUploadVideoListener;
    //   608: invokeinterface 239 1 0
    //   613: new 241	java/io/RandomAccessFile
    //   616: dup
    //   617: aload 19
    //   619: ldc 243
    //   621: invokespecial 245	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   624: astore 16
    //   626: lconst_0
    //   627: lstore 8
    //   629: lload 4
    //   631: lload 8
    //   633: lsub
    //   634: l2i
    //   635: istore_3
    //   636: invokestatic 156	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   639: invokestatic 162	com/tencent/biz/common/util/HttpUtil:isConnect	(Landroid/content/Context;)Z
    //   642: istore 14
    //   644: iload 14
    //   646: ifeq +194 -> 840
    //   649: aload 16
    //   651: astore 18
    //   653: aload_0
    //   654: getfield 39	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:g	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   657: invokevirtual 79	java/util/concurrent/atomic/AtomicBoolean:get	()Z
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
    //   680: invokestatic 250	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil:a	([B[BLjava/lang/String;JLjava/io/RandomAccessFile;JI)J
    //   683: lstore 8
    //   685: aload 16
    //   687: astore 18
    //   689: aload_0
    //   690: lload 8
    //   692: putfield 43	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:h	J
    //   695: lload 8
    //   697: ldc2_w 40
    //   700: lcmp
    //   701: ifeq +57 -> 758
    //   704: aload 16
    //   706: astore 18
    //   708: aload_0
    //   709: invokevirtual 81	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:b	()Z
    //   712: ifne +936 -> 1648
    //   715: aload 16
    //   717: astore 18
    //   719: aload_0
    //   720: getfield 51	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:f	Lcom/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$OnUploadVideoListener;
    //   723: astore 23
    //   725: lload 8
    //   727: l2d
    //   728: dstore_1
    //   729: dload_1
    //   730: invokestatic 198	java/lang/Double:isNaN	(D)Z
    //   733: pop
    //   734: dload_1
    //   735: ldc2_w 199
    //   738: dmul
    //   739: d2l
    //   740: lstore 4
    //   742: aload 16
    //   744: astore 18
    //   746: aload 23
    //   748: lload 4
    //   750: invokeinterface 205 3 0
    //   755: goto +893 -> 1648
    //   758: lload 8
    //   760: lstore 6
    //   762: aload 16
    //   764: astore 18
    //   766: invokestatic 66	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   769: ifeq +146 -> 915
    //   772: aload 16
    //   774: astore 18
    //   776: new 83	java/lang/StringBuilder
    //   779: dup
    //   780: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   783: astore 20
    //   785: aload 16
    //   787: astore 18
    //   789: aload 20
    //   791: ldc 252
    //   793: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   796: pop
    //   797: aload 16
    //   799: astore 18
    //   801: aload 20
    //   803: invokestatic 108	java/lang/System:currentTimeMillis	()J
    //   806: lload 12
    //   808: lsub
    //   809: invokevirtual 255	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   812: pop
    //   813: aload 16
    //   815: astore 18
    //   817: ldc 68
    //   819: iconst_2
    //   820: aload 20
    //   822: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   825: invokestatic 73	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   828: lload 8
    //   830: lstore 6
    //   832: goto +83 -> 915
    //   835: astore 17
    //   837: goto +347 -> 1184
    //   840: invokestatic 66	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   843: istore 14
    //   845: lload 4
    //   847: lstore 6
    //   849: iload 14
    //   851: ifeq +64 -> 915
    //   854: aload 16
    //   856: astore 18
    //   858: new 83	java/lang/StringBuilder
    //   861: dup
    //   862: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   865: astore 20
    //   867: aload 16
    //   869: astore 18
    //   871: aload 20
    //   873: ldc_w 257
    //   876: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   879: pop
    //   880: aload 16
    //   882: astore 18
    //   884: aload 20
    //   886: invokestatic 108	java/lang/System:currentTimeMillis	()J
    //   889: lload 12
    //   891: lsub
    //   892: invokevirtual 255	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   895: pop
    //   896: aload 16
    //   898: astore 18
    //   900: ldc 68
    //   902: iconst_2
    //   903: aload 20
    //   905: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   908: invokestatic 73	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   911: lload 4
    //   913: lstore 6
    //   915: iconst_1
    //   916: istore_3
    //   917: iload_3
    //   918: iconst_1
    //   919: ixor
    //   920: istore 14
    //   922: invokestatic 66	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   925: istore 15
    //   927: iload 15
    //   929: ifeq +56 -> 985
    //   932: aload 16
    //   934: astore 18
    //   936: new 83	java/lang/StringBuilder
    //   939: dup
    //   940: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   943: astore 20
    //   945: aload 16
    //   947: astore 18
    //   949: aload 20
    //   951: ldc_w 259
    //   954: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   957: pop
    //   958: aload 16
    //   960: astore 18
    //   962: aload 20
    //   964: iload 14
    //   966: invokevirtual 93	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   969: pop
    //   970: aload 16
    //   972: astore 18
    //   974: ldc 68
    //   976: iconst_2
    //   977: aload 20
    //   979: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   982: invokestatic 73	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   985: iload 14
    //   987: ifeq +705 -> 1692
    //   990: aload_0
    //   991: getfield 39	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:g	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   994: invokevirtual 79	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   997: ifne +695 -> 1692
    //   1000: aload_0
    //   1001: getfield 25	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:this$0	Lcom/tencent/mobileqq/activity/bless/BlessResultActivity;
    //   1004: getfield 206	com/tencent/mobileqq/activity/bless/BlessResultActivity:c	Ljava/lang/String;
    //   1007: astore 18
    //   1009: aload_0
    //   1010: getfield 45	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:d	Ljava/lang/String;
    //   1013: astore 20
    //   1015: aload_0
    //   1016: getfield 47	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:e	Ljava/lang/String;
    //   1019: astore 21
    //   1021: aload 17
    //   1023: getfield 208	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$ApplyUploadRsp:f	Ljava/lang/String;
    //   1026: astore 22
    //   1028: aload 17
    //   1030: getfield 210	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$ApplyUploadRsp:g	Ljava/lang/String;
    //   1033: astore 23
    //   1035: aload 19
    //   1037: aload 18
    //   1039: aload 20
    //   1041: aload 21
    //   1043: aload 22
    //   1045: aload 23
    //   1047: ldc 164
    //   1049: invokestatic 213	com/tencent/mobileqq/activity/bless/BlessResultActivity:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    //   1052: istore 15
    //   1054: iload 15
    //   1056: istore 14
    //   1058: lload 6
    //   1060: ldc2_w 40
    //   1063: lcmp
    //   1064: ifeq +21 -> 1085
    //   1067: aload_0
    //   1068: getfield 51	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:f	Lcom/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$OnUploadVideoListener;
    //   1071: lload 6
    //   1073: invokeinterface 205 3 0
    //   1078: iload 15
    //   1080: istore 14
    //   1082: goto +3 -> 1085
    //   1085: aload_0
    //   1086: getfield 25	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:this$0	Lcom/tencent/mobileqq/activity/bless/BlessResultActivity;
    //   1089: aload 17
    //   1091: getfield 208	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$ApplyUploadRsp:f	Ljava/lang/String;
    //   1094: putfield 214	com/tencent/mobileqq/activity/bless/BlessResultActivity:f	Ljava/lang/String;
    //   1097: aload 16
    //   1099: invokevirtual 262	java/io/RandomAccessFile:close	()V
    //   1102: iload 14
    //   1104: istore 15
    //   1106: goto +235 -> 1341
    //   1109: astore 16
    //   1111: iload 14
    //   1113: istore 15
    //   1115: invokestatic 66	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1118: ifeq +223 -> 1341
    //   1121: ldc 68
    //   1123: iconst_2
    //   1124: aload 16
    //   1126: invokestatic 266	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1129: invokestatic 73	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1132: iload 14
    //   1134: istore 15
    //   1136: goto +205 -> 1341
    //   1139: astore 17
    //   1141: aload 16
    //   1143: astore 18
    //   1145: aload 17
    //   1147: astore 16
    //   1149: aload 18
    //   1151: astore 17
    //   1153: goto +150 -> 1303
    //   1156: astore 17
    //   1158: goto +26 -> 1184
    //   1161: astore 17
    //   1163: goto +128 -> 1291
    //   1166: astore 17
    //   1168: goto +16 -> 1184
    //   1171: astore 16
    //   1173: aconst_null
    //   1174: astore 17
    //   1176: goto +127 -> 1303
    //   1179: astore 17
    //   1181: aconst_null
    //   1182: astore 16
    //   1184: aload 16
    //   1186: astore 18
    //   1188: invokestatic 66	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1191: ifeq +59 -> 1250
    //   1194: aload 16
    //   1196: astore 18
    //   1198: new 83	java/lang/StringBuilder
    //   1201: dup
    //   1202: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   1205: astore 19
    //   1207: aload 16
    //   1209: astore 18
    //   1211: aload 19
    //   1213: ldc_w 268
    //   1216: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1219: pop
    //   1220: aload 16
    //   1222: astore 18
    //   1224: aload 19
    //   1226: aload 17
    //   1228: invokestatic 266	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1231: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1234: pop
    //   1235: aload 16
    //   1237: astore 18
    //   1239: ldc 68
    //   1241: iconst_2
    //   1242: aload 19
    //   1244: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1247: invokestatic 73	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1250: aload 16
    //   1252: ifnull +86 -> 1338
    //   1255: aload 16
    //   1257: invokevirtual 262	java/io/RandomAccessFile:close	()V
    //   1260: goto +78 -> 1338
    //   1263: astore 16
    //   1265: invokestatic 66	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1268: ifeq +70 -> 1338
    //   1271: ldc 68
    //   1273: iconst_2
    //   1274: aload 16
    //   1276: invokestatic 266	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1279: invokestatic 73	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1282: goto +56 -> 1338
    //   1285: astore 17
    //   1287: aload 18
    //   1289: astore 16
    //   1291: aload 17
    //   1293: astore 18
    //   1295: aload 16
    //   1297: astore 17
    //   1299: aload 18
    //   1301: astore 16
    //   1303: aload 17
    //   1305: ifnull +30 -> 1335
    //   1308: aload 17
    //   1310: invokevirtual 262	java/io/RandomAccessFile:close	()V
    //   1313: goto +22 -> 1335
    //   1316: astore 17
    //   1318: invokestatic 66	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1321: ifeq +14 -> 1335
    //   1324: ldc 68
    //   1326: iconst_2
    //   1327: aload 17
    //   1329: invokestatic 266	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1332: invokestatic 73	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1335: aload 16
    //   1337: athrow
    //   1338: iconst_0
    //   1339: istore 15
    //   1341: aload_0
    //   1342: getfield 39	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:g	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   1345: iconst_0
    //   1346: iconst_1
    //   1347: invokevirtual 272	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
    //   1350: ifeq +126 -> 1476
    //   1353: iload 15
    //   1355: ifeq +60 -> 1415
    //   1358: aload_0
    //   1359: getfield 51	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:f	Lcom/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$OnUploadVideoListener;
    //   1362: invokeinterface 274 1 0
    //   1367: invokestatic 66	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1370: ifeq +166 -> 1536
    //   1373: new 83	java/lang/StringBuilder
    //   1376: dup
    //   1377: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   1380: astore 16
    //   1382: aload 16
    //   1384: ldc_w 276
    //   1387: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1390: pop
    //   1391: aload 16
    //   1393: invokestatic 108	java/lang/System:currentTimeMillis	()J
    //   1396: lload 12
    //   1398: lsub
    //   1399: invokevirtual 255	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1402: pop
    //   1403: ldc 68
    //   1405: iconst_2
    //   1406: aload 16
    //   1408: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1411: invokestatic 73	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1414: return
    //   1415: aload_0
    //   1416: getfield 51	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:f	Lcom/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$OnUploadVideoListener;
    //   1419: aload_0
    //   1420: getfield 43	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:h	J
    //   1423: invokeinterface 278 3 0
    //   1428: invokestatic 66	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1431: ifeq +105 -> 1536
    //   1434: new 83	java/lang/StringBuilder
    //   1437: dup
    //   1438: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   1441: astore 16
    //   1443: aload 16
    //   1445: ldc_w 280
    //   1448: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1451: pop
    //   1452: aload 16
    //   1454: invokestatic 108	java/lang/System:currentTimeMillis	()J
    //   1457: lload 12
    //   1459: lsub
    //   1460: invokevirtual 255	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1463: pop
    //   1464: ldc 68
    //   1466: iconst_2
    //   1467: aload 16
    //   1469: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1472: invokestatic 73	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1475: return
    //   1476: aload_0
    //   1477: getfield 51	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:f	Lcom/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$OnUploadVideoListener;
    //   1480: aload_0
    //   1481: getfield 43	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:h	J
    //   1484: invokeinterface 282 3 0
    //   1489: invokestatic 66	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1492: ifeq +44 -> 1536
    //   1495: new 83	java/lang/StringBuilder
    //   1498: dup
    //   1499: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   1502: astore 16
    //   1504: aload 16
    //   1506: ldc_w 284
    //   1509: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1512: pop
    //   1513: aload 16
    //   1515: invokestatic 108	java/lang/System:currentTimeMillis	()J
    //   1518: lload 12
    //   1520: lsub
    //   1521: invokevirtual 255	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1524: pop
    //   1525: ldc 68
    //   1527: iconst_2
    //   1528: aload 16
    //   1530: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1533: invokestatic 73	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1536: return
    //   1537: aload_0
    //   1538: getfield 39	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:g	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   1541: iconst_1
    //   1542: invokevirtual 76	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   1545: aload_0
    //   1546: getfield 51	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:f	Lcom/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$OnUploadVideoListener;
    //   1549: ldc2_w 40
    //   1552: invokeinterface 278 3 0
    //   1557: invokestatic 66	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1560: ifeq +87 -> 1647
    //   1563: aload_0
    //   1564: getfield 49	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:a	Lcom/tencent/mobileqq/activity/bless/BlessResultActivity$VideoInfo;
    //   1567: ifnonnull +11 -> 1578
    //   1570: ldc_w 286
    //   1573: astore 16
    //   1575: goto +26 -> 1601
    //   1578: aload_0
    //   1579: getfield 45	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:d	Ljava/lang/String;
    //   1582: invokestatic 120	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1585: ifeq +11 -> 1596
    //   1588: ldc_w 288
    //   1591: astore 16
    //   1593: goto +8 -> 1601
    //   1596: ldc_w 290
    //   1599: astore 16
    //   1601: new 83	java/lang/StringBuilder
    //   1604: dup
    //   1605: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   1608: astore 17
    //   1610: aload 17
    //   1612: ldc_w 292
    //   1615: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1618: pop
    //   1619: aload 17
    //   1621: aload 16
    //   1623: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1626: pop
    //   1627: aload 17
    //   1629: ldc_w 294
    //   1632: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1635: pop
    //   1636: ldc 112
    //   1638: iconst_2
    //   1639: aload 17
    //   1641: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1644: invokestatic 73	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1647: return
    //   1648: lload 8
    //   1650: ldc2_w 174
    //   1653: ladd
    //   1654: lstore 10
    //   1656: lload 10
    //   1658: lstore 4
    //   1660: lload 10
    //   1662: lload 6
    //   1664: lcmp
    //   1665: ifle +7 -> 1672
    //   1668: lload 6
    //   1670: lstore 4
    //   1672: lload 8
    //   1674: lload 6
    //   1676: lcmp
    //   1677: iflt +12 -> 1689
    //   1680: iconst_0
    //   1681: istore_3
    //   1682: lload 4
    //   1684: lstore 6
    //   1686: goto -769 -> 917
    //   1689: goto -1060 -> 629
    //   1692: goto -607 -> 1085
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1695	0	this	VideoUploadTask
    //   340	395	1	d1	double
    //   635	1047	3	i	int
    //   245	1438	4	l1	long
    //   231	1454	6	l2	long
    //   627	1046	8	l3	long
    //   1654	7	10	l4	long
    //   3	1516	12	l5	long
    //   405	728	14	bool1	boolean
    //   401	953	15	bool2	boolean
    //   113	985	16	localObject1	Object
    //   1109	33	16	localIOException1	java.io.IOException
    //   1147	1	16	localObject2	Object
    //   1171	1	16	localObject3	Object
    //   1182	74	16	localObject4	Object
    //   1263	12	16	localIOException2	java.io.IOException
    //   1289	333	16	localObject5	Object
    //   122	463	17	localObject6	Object
    //   835	255	17	localException1	java.lang.Exception
    //   1139	7	17	localObject7	Object
    //   1151	1	17	localObject8	Object
    //   1156	1	17	localException2	java.lang.Exception
    //   1161	1	17	localObject9	Object
    //   1166	1	17	localException3	java.lang.Exception
    //   1174	1	17	localObject10	Object
    //   1179	48	17	localException4	java.lang.Exception
    //   1285	7	17	localObject11	Object
    //   1297	12	17	localObject12	Object
    //   1316	12	17	localIOException3	java.io.IOException
    //   1608	32	17	localStringBuilder	StringBuilder
    //   651	649	18	localObject13	Object
    //   94	1149	19	localObject14	Object
    //   472	568	20	localObject15	Object
    //   479	563	21	localObject16	Object
    //   541	503	22	str	String
    //   723	323	23	localObject17	Object
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
    //   871	880	835	java/lang/Exception
    //   884	896	835	java/lang/Exception
    //   900	911	835	java/lang/Exception
    //   936	945	835	java/lang/Exception
    //   949	958	835	java/lang/Exception
    //   962	970	835	java/lang/Exception
    //   974	985	835	java/lang/Exception
    //   1097	1102	1109	java/io/IOException
    //   1035	1054	1139	finally
    //   1067	1078	1139	finally
    //   1085	1097	1139	finally
    //   1035	1054	1156	java/lang/Exception
    //   1067	1078	1156	java/lang/Exception
    //   1085	1097	1156	java/lang/Exception
    //   636	644	1161	finally
    //   840	845	1161	finally
    //   922	927	1161	finally
    //   990	1035	1161	finally
    //   636	644	1166	java/lang/Exception
    //   840	845	1166	java/lang/Exception
    //   922	927	1166	java/lang/Exception
    //   990	1035	1166	java/lang/Exception
    //   604	626	1171	finally
    //   604	626	1179	java/lang/Exception
    //   1255	1260	1263	java/io/IOException
    //   653	663	1285	finally
    //   667	685	1285	finally
    //   689	695	1285	finally
    //   708	715	1285	finally
    //   719	725	1285	finally
    //   746	755	1285	finally
    //   766	772	1285	finally
    //   776	785	1285	finally
    //   789	797	1285	finally
    //   801	813	1285	finally
    //   817	828	1285	finally
    //   858	867	1285	finally
    //   871	880	1285	finally
    //   884	896	1285	finally
    //   900	911	1285	finally
    //   936	945	1285	finally
    //   949	958	1285	finally
    //   962	970	1285	finally
    //   974	985	1285	finally
    //   1188	1194	1285	finally
    //   1198	1207	1285	finally
    //   1211	1220	1285	finally
    //   1224	1235	1285	finally
    //   1239	1250	1285	finally
    //   1308	1313	1316	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.bless.BlessResultActivity.VideoUploadTask
 * JD-Core Version:    0.7.0.1
 */