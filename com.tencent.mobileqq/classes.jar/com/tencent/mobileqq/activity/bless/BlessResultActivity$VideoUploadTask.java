package com.tencent.mobileqq.activity.bless;

import ahve;
import bdzq;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

class BlessResultActivity$VideoUploadTask
  implements Runnable
{
  private long jdField_a_of_type_Long = -1L;
  public ahve a;
  private bdzq jdField_a_of_type_Bdzq;
  private String jdField_a_of_type_JavaLangString;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(true);
  private String b;
  private String c;
  private String d;
  
  public BlessResultActivity$VideoUploadTask(BlessResultActivity paramBlessResultActivity, String paramString1, String paramString2, ahve paramahve, bdzq parambdzq)
  {
    this.c = paramString1;
    this.d = paramString2;
    this.jdField_a_of_type_Ahve = paramahve;
    this.jdField_a_of_type_Bdzq = parambdzq;
    if (this.jdField_a_of_type_JavaLangString == null) {
      this.jdField_a_of_type_JavaLangString = paramBlessResultActivity.getString(2131695415);
    }
    if (this.b == null) {
      this.b = paramBlessResultActivity.getString(2131690584);
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
    if (!a()) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BlessResultActivity", 2, "VideoUploadTask isRunning(),result = " + bool);
      }
      return bool;
    }
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: invokestatic 104	java/lang/System:currentTimeMillis	()J
    //   3: lstore 8
    //   5: invokestatic 62	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8: ifeq +11 -> 19
    //   11: ldc 64
    //   13: iconst_2
    //   14: ldc 106
    //   16: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   19: aload_0
    //   20: getfield 31	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   23: iconst_0
    //   24: invokevirtual 72	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   27: aload_0
    //   28: getfield 43	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:jdField_a_of_type_Bdzq	Lbdzq;
    //   31: ifnonnull +26 -> 57
    //   34: aload_0
    //   35: getfield 31	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
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
    //   58: getfield 41	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:jdField_a_of_type_Ahve	Lahve;
    //   61: ifnull +23 -> 84
    //   64: aload_0
    //   65: getfield 37	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:c	Ljava/lang/String;
    //   68: invokestatic 116	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   71: ifne +13 -> 84
    //   74: aload_0
    //   75: getfield 39	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:d	Ljava/lang/String;
    //   78: invokestatic 116	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   81: ifeq +96 -> 177
    //   84: aload_0
    //   85: getfield 31	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   88: iconst_1
    //   89: invokevirtual 72	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   92: aload_0
    //   93: getfield 43	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:jdField_a_of_type_Bdzq	Lbdzq;
    //   96: ldc2_w 32
    //   99: invokeinterface 121 3 0
    //   104: invokestatic 62	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   107: ifeq -51 -> 56
    //   110: aload_0
    //   111: getfield 41	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:jdField_a_of_type_Ahve	Lahve;
    //   114: ifnonnull +39 -> 153
    //   117: ldc 123
    //   119: astore 12
    //   121: ldc 108
    //   123: iconst_2
    //   124: new 79	java/lang/StringBuilder
    //   127: dup
    //   128: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   131: ldc 125
    //   133: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: aload 12
    //   138: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: ldc 127
    //   143: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   149: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   152: return
    //   153: aload_0
    //   154: getfield 37	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:c	Ljava/lang/String;
    //   157: invokestatic 116	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   160: ifeq +10 -> 170
    //   163: ldc 129
    //   165: astore 12
    //   167: goto -46 -> 121
    //   170: ldc 131
    //   172: astore 12
    //   174: goto -53 -> 121
    //   177: iconst_0
    //   178: istore 10
    //   180: aload_0
    //   181: getfield 41	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:jdField_a_of_type_Ahve	Lahve;
    //   184: getfield 134	ahve:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   187: astore 15
    //   189: new 136	java/io/File
    //   192: dup
    //   193: aload_0
    //   194: getfield 41	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:jdField_a_of_type_Ahve	Lahve;
    //   197: getfield 134	ahve:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   200: invokespecial 139	java/io/File:<init>	(Ljava/lang/String;)V
    //   203: invokevirtual 142	java/io/File:getName	()Ljava/lang/String;
    //   206: astore 12
    //   208: new 144	android/os/Bundle
    //   211: dup
    //   212: invokespecial 145	android/os/Bundle:<init>	()V
    //   215: astore 13
    //   217: aload 13
    //   219: ldc 147
    //   221: aload_0
    //   222: getfield 45	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   225: invokevirtual 151	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   228: aload 13
    //   230: ldc 153
    //   232: aload 15
    //   234: invokevirtual 151	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   237: aload 13
    //   239: ldc 155
    //   241: aload_0
    //   242: getfield 54	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:b	Ljava/lang/String;
    //   245: invokevirtual 151	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   248: aload 13
    //   250: ldc 157
    //   252: aload 12
    //   254: invokevirtual 151	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   257: aload 13
    //   259: ldc 159
    //   261: aload_0
    //   262: getfield 41	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:jdField_a_of_type_Ahve	Lahve;
    //   265: getfield 160	ahve:b	Ljava/lang/String;
    //   268: invokevirtual 151	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   271: invokestatic 166	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   274: invokestatic 172	com/tencent/biz/common/util/HttpUtil:isConnect	(Landroid/content/Context;)Z
    //   277: ifeq +1116 -> 1393
    //   280: aload_0
    //   281: getfield 31	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   284: invokevirtual 75	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   287: ifne +1106 -> 1393
    //   290: aload 13
    //   292: aload_0
    //   293: getfield 37	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:c	Ljava/lang/String;
    //   296: aload_0
    //   297: getfield 39	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:d	Ljava/lang/String;
    //   300: ldc 174
    //   302: iconst_0
    //   303: invokestatic 177	com/tencent/mobileqq/activity/bless/BlessResultActivity:a	(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Lbdzp;
    //   306: astore 14
    //   308: aload 14
    //   310: ifnull +1071 -> 1381
    //   313: aload 15
    //   315: invokestatic 183	com/tencent/mobileqq/utils/FileUtils:getFileSizes	(Ljava/lang/String;)J
    //   318: lstore 6
    //   320: lload 6
    //   322: ldc2_w 184
    //   325: lcmp
    //   326: ifle +229 -> 555
    //   329: ldc2_w 184
    //   332: lstore_2
    //   333: invokestatic 62	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   336: ifeq +45 -> 381
    //   339: ldc 64
    //   341: iconst_2
    //   342: new 79	java/lang/StringBuilder
    //   345: dup
    //   346: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   349: ldc 187
    //   351: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   354: aload 14
    //   356: getfield 192	bdzp:h	Ljava/lang/String;
    //   359: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   362: ldc 194
    //   364: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: aload 14
    //   369: getfield 195	bdzp:d	Ljava/lang/String;
    //   372: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   378: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   381: ldc 197
    //   383: aload 14
    //   385: getfield 192	bdzp:h	Ljava/lang/String;
    //   388: invokevirtual 203	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   391: ifeq +170 -> 561
    //   394: aload_0
    //   395: getfield 43	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:jdField_a_of_type_Bdzq	Lbdzq;
    //   398: lload_2
    //   399: l2d
    //   400: ldc2_w 204
    //   403: dmul
    //   404: d2l
    //   405: invokeinterface 207 3 0
    //   410: aload_0
    //   411: getfield 31	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   414: invokevirtual 75	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   417: ifne +970 -> 1387
    //   420: aload 15
    //   422: aload_0
    //   423: getfield 21	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:this$0	Lcom/tencent/mobileqq/activity/bless/BlessResultActivity;
    //   426: getfield 208	com/tencent/mobileqq/activity/bless/BlessResultActivity:b	Ljava/lang/String;
    //   429: aload_0
    //   430: getfield 37	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:c	Ljava/lang/String;
    //   433: aload_0
    //   434: getfield 39	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:d	Ljava/lang/String;
    //   437: aload 14
    //   439: getfield 211	bdzp:f	Ljava/lang/String;
    //   442: aload 14
    //   444: getfield 214	bdzp:g	Ljava/lang/String;
    //   447: ldc 174
    //   449: invokestatic 217	com/tencent/mobileqq/activity/bless/BlessResultActivity:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    //   452: istore 11
    //   454: iload 11
    //   456: istore 10
    //   458: lload_2
    //   459: ldc2_w 32
    //   462: lcmp
    //   463: ifeq +17 -> 480
    //   466: aload_0
    //   467: getfield 43	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:jdField_a_of_type_Bdzq	Lbdzq;
    //   470: lload_2
    //   471: invokeinterface 207 3 0
    //   476: iload 11
    //   478: istore 10
    //   480: aload_0
    //   481: getfield 21	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:this$0	Lcom/tencent/mobileqq/activity/bless/BlessResultActivity;
    //   484: aload 14
    //   486: getfield 211	bdzp:f	Ljava/lang/String;
    //   489: putfield 218	com/tencent/mobileqq/activity/bless/BlessResultActivity:d	Ljava/lang/String;
    //   492: aload_0
    //   493: getfield 31	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   496: iconst_0
    //   497: iconst_1
    //   498: invokevirtual 222	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
    //   501: ifeq +800 -> 1301
    //   504: iload 10
    //   506: ifeq +744 -> 1250
    //   509: aload_0
    //   510: getfield 43	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:jdField_a_of_type_Bdzq	Lbdzq;
    //   513: invokeinterface 224 1 0
    //   518: invokestatic 62	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   521: ifeq -465 -> 56
    //   524: ldc 64
    //   526: iconst_2
    //   527: new 79	java/lang/StringBuilder
    //   530: dup
    //   531: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   534: ldc 226
    //   536: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   539: invokestatic 104	java/lang/System:currentTimeMillis	()J
    //   542: lload 8
    //   544: lsub
    //   545: invokevirtual 229	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   548: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   551: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   554: return
    //   555: lload 6
    //   557: lstore_2
    //   558: goto -225 -> 333
    //   561: aload 14
    //   563: getfield 211	bdzp:f	Ljava/lang/String;
    //   566: ifnull +815 -> 1381
    //   569: aload 14
    //   571: getfield 230	bdzp:c	Ljava/lang/String;
    //   574: invokestatic 236	com/tencent/mobileqq/utils/HexUtil:hexStr2Bytes	(Ljava/lang/String;)[B
    //   577: astore 16
    //   579: aload 15
    //   581: invokestatic 240	aszt:a	(Ljava/lang/String;)[B
    //   584: astore 17
    //   586: new 79	java/lang/StringBuilder
    //   589: dup
    //   590: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   593: ldc 242
    //   595: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   598: aload 14
    //   600: getfield 243	bdzp:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   603: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   606: ldc 245
    //   608: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   611: aload 14
    //   613: getfield 246	bdzp:b	Ljava/lang/String;
    //   616: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   619: ldc 248
    //   621: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   624: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   627: astore 18
    //   629: invokestatic 62	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   632: ifeq +42 -> 674
    //   635: ldc 64
    //   637: iconst_2
    //   638: new 79	java/lang/StringBuilder
    //   641: dup
    //   642: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   645: ldc 250
    //   647: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   650: aload 18
    //   652: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   655: ldc 252
    //   657: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   660: aload 14
    //   662: getfield 211	bdzp:f	Ljava/lang/String;
    //   665: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   668: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   671: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   674: aload_0
    //   675: getfield 43	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:jdField_a_of_type_Bdzq	Lbdzq;
    //   678: invokeinterface 254 1 0
    //   683: new 256	java/io/RandomAccessFile
    //   686: dup
    //   687: aload 15
    //   689: ldc_w 258
    //   692: invokespecial 260	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   695: astore 13
    //   697: lconst_0
    //   698: lstore 4
    //   700: lload_2
    //   701: lload 4
    //   703: lsub
    //   704: l2i
    //   705: istore_1
    //   706: aload 13
    //   708: astore 12
    //   710: invokestatic 166	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   713: invokestatic 172	com/tencent/biz/common/util/HttpUtil:isConnect	(Landroid/content/Context;)Z
    //   716: ifeq +341 -> 1057
    //   719: aload 13
    //   721: astore 12
    //   723: aload_0
    //   724: getfield 31	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   727: invokevirtual 75	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   730: ifne +327 -> 1057
    //   733: aload 13
    //   735: astore 12
    //   737: aload 16
    //   739: aload 17
    //   741: aload 18
    //   743: lload 6
    //   745: aload 13
    //   747: lload 4
    //   749: iload_1
    //   750: invokestatic 265	bdzo:a	([B[BLjava/lang/String;JLjava/io/RandomAccessFile;JI)J
    //   753: lstore 4
    //   755: aload 13
    //   757: astore 12
    //   759: aload_0
    //   760: lload 4
    //   762: putfield 35	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:jdField_a_of_type_Long	J
    //   765: lload 4
    //   767: ldc2_w 32
    //   770: lcmp
    //   771: ifeq +233 -> 1004
    //   774: aload 13
    //   776: astore 12
    //   778: aload_0
    //   779: invokevirtual 77	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:a	()Z
    //   782: ifne +617 -> 1399
    //   785: aload 13
    //   787: astore 12
    //   789: aload_0
    //   790: getfield 43	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:jdField_a_of_type_Bdzq	Lbdzq;
    //   793: lload 4
    //   795: l2d
    //   796: ldc2_w 204
    //   799: dmul
    //   800: d2l
    //   801: invokeinterface 207 3 0
    //   806: goto +593 -> 1399
    //   809: aload 13
    //   811: astore 12
    //   813: invokestatic 62	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   816: ifeq +34 -> 850
    //   819: aload 13
    //   821: astore 12
    //   823: ldc 64
    //   825: iconst_2
    //   826: new 79	java/lang/StringBuilder
    //   829: dup
    //   830: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   833: ldc_w 267
    //   836: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   839: iload 10
    //   841: invokevirtual 89	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   844: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   847: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   850: iload 10
    //   852: ifeq +510 -> 1362
    //   855: aload 13
    //   857: astore 12
    //   859: aload_0
    //   860: getfield 31	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   863: invokevirtual 75	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   866: ifne +496 -> 1362
    //   869: aload 13
    //   871: astore 12
    //   873: aload 15
    //   875: aload_0
    //   876: getfield 21	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:this$0	Lcom/tencent/mobileqq/activity/bless/BlessResultActivity;
    //   879: getfield 208	com/tencent/mobileqq/activity/bless/BlessResultActivity:b	Ljava/lang/String;
    //   882: aload_0
    //   883: getfield 37	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:c	Ljava/lang/String;
    //   886: aload_0
    //   887: getfield 39	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:d	Ljava/lang/String;
    //   890: aload 14
    //   892: getfield 211	bdzp:f	Ljava/lang/String;
    //   895: aload 14
    //   897: getfield 214	bdzp:g	Ljava/lang/String;
    //   900: ldc 174
    //   902: invokestatic 217	com/tencent/mobileqq/activity/bless/BlessResultActivity:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    //   905: istore 10
    //   907: iload 10
    //   909: istore 11
    //   911: lload_2
    //   912: ldc2_w 32
    //   915: lcmp
    //   916: ifeq +21 -> 937
    //   919: aload 13
    //   921: astore 12
    //   923: aload_0
    //   924: getfield 43	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:jdField_a_of_type_Bdzq	Lbdzq;
    //   927: lload_2
    //   928: invokeinterface 207 3 0
    //   933: iload 10
    //   935: istore 11
    //   937: aload 13
    //   939: astore 12
    //   941: aload_0
    //   942: getfield 21	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:this$0	Lcom/tencent/mobileqq/activity/bless/BlessResultActivity;
    //   945: aload 14
    //   947: getfield 211	bdzp:f	Ljava/lang/String;
    //   950: putfield 218	com/tencent/mobileqq/activity/bless/BlessResultActivity:d	Ljava/lang/String;
    //   953: iload 11
    //   955: istore 10
    //   957: aload 13
    //   959: ifnull -467 -> 492
    //   962: aload 13
    //   964: invokevirtual 270	java/io/RandomAccessFile:close	()V
    //   967: iload 11
    //   969: istore 10
    //   971: goto -479 -> 492
    //   974: astore 12
    //   976: iload 11
    //   978: istore 10
    //   980: invokestatic 62	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   983: ifeq -491 -> 492
    //   986: ldc 64
    //   988: iconst_2
    //   989: aload 12
    //   991: invokestatic 274	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   994: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   997: iload 11
    //   999: istore 10
    //   1001: goto -509 -> 492
    //   1004: iconst_1
    //   1005: istore_1
    //   1006: aload 13
    //   1008: astore 12
    //   1010: invokestatic 62	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1013: ifeq +362 -> 1375
    //   1016: aload 13
    //   1018: astore 12
    //   1020: ldc 64
    //   1022: iconst_2
    //   1023: new 79	java/lang/StringBuilder
    //   1026: dup
    //   1027: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   1030: ldc_w 276
    //   1033: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1036: invokestatic 104	java/lang/System:currentTimeMillis	()J
    //   1039: lload 8
    //   1041: lsub
    //   1042: invokevirtual 229	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1045: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1048: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1051: lload 4
    //   1053: lstore_2
    //   1054: goto +370 -> 1424
    //   1057: iconst_1
    //   1058: istore_1
    //   1059: aload 13
    //   1061: astore 12
    //   1063: invokestatic 62	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1066: ifeq +306 -> 1372
    //   1069: aload 13
    //   1071: astore 12
    //   1073: ldc 64
    //   1075: iconst_2
    //   1076: new 79	java/lang/StringBuilder
    //   1079: dup
    //   1080: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   1083: ldc_w 278
    //   1086: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1089: invokestatic 104	java/lang/System:currentTimeMillis	()J
    //   1092: lload 8
    //   1094: lsub
    //   1095: invokevirtual 229	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1098: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1101: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1104: goto +320 -> 1424
    //   1107: astore 14
    //   1109: aconst_null
    //   1110: astore 13
    //   1112: iconst_0
    //   1113: istore 11
    //   1115: aload 13
    //   1117: astore 12
    //   1119: invokestatic 62	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1122: ifeq +37 -> 1159
    //   1125: aload 13
    //   1127: astore 12
    //   1129: ldc 64
    //   1131: iconst_2
    //   1132: new 79	java/lang/StringBuilder
    //   1135: dup
    //   1136: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   1139: ldc_w 280
    //   1142: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1145: aload 14
    //   1147: invokestatic 274	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1150: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1153: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1156: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1159: iload 11
    //   1161: istore 10
    //   1163: aload 13
    //   1165: ifnull -673 -> 492
    //   1168: aload 13
    //   1170: invokevirtual 270	java/io/RandomAccessFile:close	()V
    //   1173: iload 11
    //   1175: istore 10
    //   1177: goto -685 -> 492
    //   1180: astore 12
    //   1182: iload 11
    //   1184: istore 10
    //   1186: invokestatic 62	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1189: ifeq -697 -> 492
    //   1192: ldc 64
    //   1194: iconst_2
    //   1195: aload 12
    //   1197: invokestatic 274	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1200: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1203: iload 11
    //   1205: istore 10
    //   1207: goto -715 -> 492
    //   1210: astore 13
    //   1212: aconst_null
    //   1213: astore 12
    //   1215: aload 12
    //   1217: ifnull +8 -> 1225
    //   1220: aload 12
    //   1222: invokevirtual 270	java/io/RandomAccessFile:close	()V
    //   1225: aload 13
    //   1227: athrow
    //   1228: astore 12
    //   1230: invokestatic 62	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1233: ifeq -8 -> 1225
    //   1236: ldc 64
    //   1238: iconst_2
    //   1239: aload 12
    //   1241: invokestatic 274	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1244: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1247: goto -22 -> 1225
    //   1250: aload_0
    //   1251: getfield 43	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:jdField_a_of_type_Bdzq	Lbdzq;
    //   1254: aload_0
    //   1255: getfield 35	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:jdField_a_of_type_Long	J
    //   1258: invokeinterface 121 3 0
    //   1263: invokestatic 62	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1266: ifeq -1210 -> 56
    //   1269: ldc 64
    //   1271: iconst_2
    //   1272: new 79	java/lang/StringBuilder
    //   1275: dup
    //   1276: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   1279: ldc_w 282
    //   1282: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1285: invokestatic 104	java/lang/System:currentTimeMillis	()J
    //   1288: lload 8
    //   1290: lsub
    //   1291: invokevirtual 229	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1294: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1297: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1300: return
    //   1301: aload_0
    //   1302: getfield 43	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:jdField_a_of_type_Bdzq	Lbdzq;
    //   1305: aload_0
    //   1306: getfield 35	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoUploadTask:jdField_a_of_type_Long	J
    //   1309: invokeinterface 284 3 0
    //   1314: invokestatic 62	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1317: ifeq -1261 -> 56
    //   1320: ldc 64
    //   1322: iconst_2
    //   1323: new 79	java/lang/StringBuilder
    //   1326: dup
    //   1327: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   1330: ldc_w 286
    //   1333: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1336: invokestatic 104	java/lang/System:currentTimeMillis	()J
    //   1339: lload 8
    //   1341: lsub
    //   1342: invokevirtual 229	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1345: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1348: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1351: return
    //   1352: astore 13
    //   1354: goto -139 -> 1215
    //   1357: astore 14
    //   1359: goto -247 -> 1112
    //   1362: iload 10
    //   1364: istore 11
    //   1366: goto -429 -> 937
    //   1369: goto -669 -> 700
    //   1372: goto +52 -> 1424
    //   1375: lload 4
    //   1377: lstore_2
    //   1378: goto +46 -> 1424
    //   1381: iconst_0
    //   1382: istore 10
    //   1384: goto -892 -> 492
    //   1387: iconst_1
    //   1388: istore 10
    //   1390: goto -910 -> 480
    //   1393: aconst_null
    //   1394: astore 14
    //   1396: goto -1088 -> 308
    //   1399: ldc2_w 184
    //   1402: lload 4
    //   1404: ladd
    //   1405: lload 6
    //   1407: lcmp
    //   1408: ifle +26 -> 1434
    //   1411: lload 6
    //   1413: lstore_2
    //   1414: lload 4
    //   1416: lload 6
    //   1418: lcmp
    //   1419: iflt -50 -> 1369
    //   1422: iconst_0
    //   1423: istore_1
    //   1424: iload_1
    //   1425: ifne -616 -> 809
    //   1428: iconst_1
    //   1429: istore 10
    //   1431: goto -622 -> 809
    //   1434: ldc2_w 184
    //   1437: lload 4
    //   1439: ladd
    //   1440: lstore_2
    //   1441: goto -27 -> 1414
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1444	0	this	VideoUploadTask
    //   705	720	1	i	int
    //   332	1109	2	l1	long
    //   698	740	4	l2	long
    //   318	1099	6	l3	long
    //   3	1337	8	l4	long
    //   178	1252	10	bool1	boolean
    //   452	913	11	bool2	boolean
    //   119	821	12	localObject1	Object
    //   974	16	12	localIOException1	java.io.IOException
    //   1008	120	12	localObject2	Object
    //   1180	16	12	localIOException2	java.io.IOException
    //   1213	8	12	localObject3	Object
    //   1228	12	12	localIOException3	java.io.IOException
    //   215	954	13	localObject4	Object
    //   1210	16	13	localObject5	Object
    //   1352	1	13	localObject6	Object
    //   306	640	14	localbdzp	bdzp
    //   1107	39	14	localException1	java.lang.Exception
    //   1357	1	14	localException2	java.lang.Exception
    //   1394	1	14	localObject7	Object
    //   187	687	15	str1	String
    //   577	161	16	arrayOfByte1	byte[]
    //   584	156	17	arrayOfByte2	byte[]
    //   627	115	18	str2	String
    // Exception table:
    //   from	to	target	type
    //   962	967	974	java/io/IOException
    //   674	697	1107	java/lang/Exception
    //   1168	1173	1180	java/io/IOException
    //   674	697	1210	finally
    //   1220	1225	1228	java/io/IOException
    //   710	719	1352	finally
    //   723	733	1352	finally
    //   737	755	1352	finally
    //   759	765	1352	finally
    //   778	785	1352	finally
    //   789	806	1352	finally
    //   813	819	1352	finally
    //   823	850	1352	finally
    //   859	869	1352	finally
    //   873	907	1352	finally
    //   923	933	1352	finally
    //   941	953	1352	finally
    //   1010	1016	1352	finally
    //   1020	1051	1352	finally
    //   1063	1069	1352	finally
    //   1073	1104	1352	finally
    //   1119	1125	1352	finally
    //   1129	1159	1352	finally
    //   710	719	1357	java/lang/Exception
    //   723	733	1357	java/lang/Exception
    //   737	755	1357	java/lang/Exception
    //   759	765	1357	java/lang/Exception
    //   778	785	1357	java/lang/Exception
    //   789	806	1357	java/lang/Exception
    //   813	819	1357	java/lang/Exception
    //   823	850	1357	java/lang/Exception
    //   859	869	1357	java/lang/Exception
    //   873	907	1357	java/lang/Exception
    //   923	933	1357	java/lang/Exception
    //   941	953	1357	java/lang/Exception
    //   1010	1016	1357	java/lang/Exception
    //   1020	1051	1357	java/lang/Exception
    //   1063	1069	1357	java/lang/Exception
    //   1073	1104	1357	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.bless.BlessResultActivity.VideoUploadTask
 * JD-Core Version:    0.7.0.1
 */