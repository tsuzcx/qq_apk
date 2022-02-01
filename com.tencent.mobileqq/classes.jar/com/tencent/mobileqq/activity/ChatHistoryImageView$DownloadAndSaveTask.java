package com.tencent.mobileqq.activity;

import aham;
import bjng;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class ChatHistoryImageView$DownloadAndSaveTask
  implements Runnable
{
  volatile int jdField_a_of_type_Int = 0;
  aham jdField_a_of_type_Aham;
  final Object jdField_a_of_type_JavaLangObject = new Object();
  ArrayList<aham> jdField_a_of_type_JavaUtilArrayList;
  boolean jdField_a_of_type_Boolean;
  public boolean b;
  volatile boolean c = true;
  volatile boolean d = false;
  volatile boolean e = false;
  
  public ChatHistoryImageView$DownloadAndSaveTask(ArrayList<aham> paramArrayList, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(paramBoolean1);
    this.jdField_a_of_type_Boolean = paramBoolean2;
    boolean bool;
    this.b = bool;
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatHistoryImageView", 2, "[setDownloadState] " + paramBoolean);
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.e = paramBoolean;
      if (!this.e)
      {
        this.jdField_a_of_type_JavaLangObject.notifyAll();
        this.this$0.jdField_a_of_type_Bjng.sendEmptyMessageDelayed(102, (this.jdField_a_of_type_JavaUtilArrayList.size() - this.jdField_a_of_type_Int) * 60000L);
        return;
      }
      this.this$0.jdField_a_of_type_Bjng.removeMessages(102);
    }
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 45	com/tencent/mobileqq/activity/ChatHistoryImageView$DownloadAndSaveTask:jdField_a_of_type_Boolean	Z
    //   4: ifeq +353 -> 357
    //   7: aload_0
    //   8: iconst_1
    //   9: putfield 30	com/tencent/mobileqq/activity/ChatHistoryImageView$DownloadAndSaveTask:d	Z
    //   12: aload_0
    //   13: getfield 23	com/tencent/mobileqq/activity/ChatHistoryImageView$DownloadAndSaveTask:this$0	Lcom/tencent/mobileqq/activity/ChatHistoryImageView;
    //   16: getfield 86	com/tencent/mobileqq/activity/ChatHistoryImageView:jdField_a_of_type_Bjng	Lbjng;
    //   19: bipush 102
    //   21: aload_0
    //   22: getfield 43	com/tencent/mobileqq/activity/ChatHistoryImageView$DownloadAndSaveTask:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   25: invokevirtual 90	java/util/ArrayList:size	()I
    //   28: i2l
    //   29: ldc2_w 91
    //   32: lmul
    //   33: invokevirtual 98	bjng:sendEmptyMessageDelayed	(IJ)Z
    //   36: pop
    //   37: iconst_0
    //   38: istore_1
    //   39: iload_1
    //   40: aload_0
    //   41: getfield 43	com/tencent/mobileqq/activity/ChatHistoryImageView$DownloadAndSaveTask:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   44: invokevirtual 90	java/util/ArrayList:size	()I
    //   47: if_icmpge +293 -> 340
    //   50: aload_0
    //   51: getfield 28	com/tencent/mobileqq/activity/ChatHistoryImageView$DownloadAndSaveTask:c	Z
    //   54: ifne +17 -> 71
    //   57: aload_0
    //   58: getfield 23	com/tencent/mobileqq/activity/ChatHistoryImageView$DownloadAndSaveTask:this$0	Lcom/tencent/mobileqq/activity/ChatHistoryImageView;
    //   61: getfield 86	com/tencent/mobileqq/activity/ChatHistoryImageView:jdField_a_of_type_Bjng	Lbjng;
    //   64: bipush 101
    //   66: invokevirtual 109	bjng:sendEmptyMessage	(I)Z
    //   69: pop
    //   70: return
    //   71: aload_0
    //   72: getfield 43	com/tencent/mobileqq/activity/ChatHistoryImageView$DownloadAndSaveTask:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   75: iload_1
    //   76: invokevirtual 113	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   79: checkcast 115	aham
    //   82: astore 9
    //   84: ldc 117
    //   86: aload 9
    //   88: getfield 120	aham:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData	Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaData;
    //   91: invokevirtual 126	java/lang/Class:isInstance	(Ljava/lang/Object;)Z
    //   94: ifeq +167 -> 261
    //   97: aload 9
    //   99: getfield 120	aham:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData	Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaData;
    //   102: checkcast 117	com/tencent/mobileqq/activity/aio/photo/AIOImageData
    //   105: astore 10
    //   107: aload 10
    //   109: getfield 129	com/tencent/mobileqq/activity/aio/photo/AIOImageData:b	Ljava/lang/String;
    //   112: astore 11
    //   114: ldc 131
    //   116: aload 11
    //   118: invokevirtual 136	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   121: ifne +84 -> 205
    //   124: new 138	java/io/File
    //   127: dup
    //   128: aload 11
    //   130: invokespecial 141	java/io/File:<init>	(Ljava/lang/String;)V
    //   133: invokevirtual 144	java/io/File:exists	()Z
    //   136: ifne +69 -> 205
    //   139: aload_0
    //   140: aload 9
    //   142: putfield 146	com/tencent/mobileqq/activity/ChatHistoryImageView$DownloadAndSaveTask:jdField_a_of_type_Aham	Laham;
    //   145: aload 9
    //   147: iconst_1
    //   148: putfield 147	aham:jdField_a_of_type_Boolean	Z
    //   151: aload_0
    //   152: getfield 23	com/tencent/mobileqq/activity/ChatHistoryImageView$DownloadAndSaveTask:this$0	Lcom/tencent/mobileqq/activity/ChatHistoryImageView;
    //   155: getfield 150	com/tencent/mobileqq/activity/ChatHistoryImageView:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService	Lcom/tencent/mobileqq/activity/aio/photo/AIOImageProviderService;
    //   158: aload 10
    //   160: getfield 154	com/tencent/mobileqq/activity/aio/photo/AIOImageData:jdField_f_of_type_Long	J
    //   163: aload 10
    //   165: getfield 156	com/tencent/mobileqq/activity/aio/photo/AIOImageData:jdField_f_of_type_Int	I
    //   168: iconst_2
    //   169: invokevirtual 161	com/tencent/mobileqq/activity/aio/photo/AIOImageProviderService:a	(JII)V
    //   172: aload_0
    //   173: getfield 146	com/tencent/mobileqq/activity/ChatHistoryImageView$DownloadAndSaveTask:jdField_a_of_type_Aham	Laham;
    //   176: astore 9
    //   178: aload 9
    //   180: monitorenter
    //   181: aload_0
    //   182: getfield 146	com/tencent/mobileqq/activity/ChatHistoryImageView$DownloadAndSaveTask:jdField_a_of_type_Aham	Laham;
    //   185: getfield 147	aham:jdField_a_of_type_Boolean	Z
    //   188: istore 6
    //   190: iload 6
    //   192: ifeq +10 -> 202
    //   195: aload_0
    //   196: getfield 146	com/tencent/mobileqq/activity/ChatHistoryImageView$DownloadAndSaveTask:jdField_a_of_type_Aham	Laham;
    //   199: invokevirtual 164	java/lang/Object:wait	()V
    //   202: aload 9
    //   204: monitorexit
    //   205: aload_0
    //   206: getfield 36	com/tencent/mobileqq/activity/ChatHistoryImageView$DownloadAndSaveTask:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   209: astore 9
    //   211: aload 9
    //   213: monitorenter
    //   214: aload_0
    //   215: getfield 32	com/tencent/mobileqq/activity/ChatHistoryImageView$DownloadAndSaveTask:e	Z
    //   218: istore 6
    //   220: iload 6
    //   222: ifeq +36 -> 258
    //   225: aload_0
    //   226: getfield 36	com/tencent/mobileqq/activity/ChatHistoryImageView$DownloadAndSaveTask:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   229: invokevirtual 164	java/lang/Object:wait	()V
    //   232: goto -18 -> 214
    //   235: astore 10
    //   237: goto -23 -> 214
    //   240: astore 10
    //   242: aload 10
    //   244: invokevirtual 167	java/lang/InterruptedException:printStackTrace	()V
    //   247: goto -45 -> 202
    //   250: astore 10
    //   252: aload 9
    //   254: monitorexit
    //   255: aload 10
    //   257: athrow
    //   258: aload 9
    //   260: monitorexit
    //   261: aload_0
    //   262: aload_0
    //   263: getfield 34	com/tencent/mobileqq/activity/ChatHistoryImageView$DownloadAndSaveTask:jdField_a_of_type_Int	I
    //   266: iconst_1
    //   267: iadd
    //   268: putfield 34	com/tencent/mobileqq/activity/ChatHistoryImageView$DownloadAndSaveTask:jdField_a_of_type_Int	I
    //   271: aload_0
    //   272: getfield 23	com/tencent/mobileqq/activity/ChatHistoryImageView$DownloadAndSaveTask:this$0	Lcom/tencent/mobileqq/activity/ChatHistoryImageView;
    //   275: getfield 86	com/tencent/mobileqq/activity/ChatHistoryImageView:jdField_a_of_type_Bjng	Lbjng;
    //   278: bipush 100
    //   280: invokevirtual 171	bjng:obtainMessage	(I)Landroid/os/Message;
    //   283: astore 9
    //   285: aload 9
    //   287: iconst_1
    //   288: putfield 176	android/os/Message:arg1	I
    //   291: aload 9
    //   293: iload_1
    //   294: iconst_1
    //   295: iadd
    //   296: bipush 100
    //   298: imul
    //   299: aload_0
    //   300: getfield 43	com/tencent/mobileqq/activity/ChatHistoryImageView$DownloadAndSaveTask:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   303: invokevirtual 90	java/util/ArrayList:size	()I
    //   306: idiv
    //   307: iconst_2
    //   308: idiv
    //   309: putfield 179	android/os/Message:arg2	I
    //   312: aload_0
    //   313: getfield 23	com/tencent/mobileqq/activity/ChatHistoryImageView$DownloadAndSaveTask:this$0	Lcom/tencent/mobileqq/activity/ChatHistoryImageView;
    //   316: getfield 86	com/tencent/mobileqq/activity/ChatHistoryImageView:jdField_a_of_type_Bjng	Lbjng;
    //   319: aload 9
    //   321: invokevirtual 183	bjng:sendMessage	(Landroid/os/Message;)Z
    //   324: pop
    //   325: iload_1
    //   326: iconst_1
    //   327: iadd
    //   328: istore_1
    //   329: goto -290 -> 39
    //   332: astore 10
    //   334: aload 9
    //   336: monitorexit
    //   337: aload 10
    //   339: athrow
    //   340: aload_0
    //   341: getfield 23	com/tencent/mobileqq/activity/ChatHistoryImageView$DownloadAndSaveTask:this$0	Lcom/tencent/mobileqq/activity/ChatHistoryImageView;
    //   344: getfield 86	com/tencent/mobileqq/activity/ChatHistoryImageView:jdField_a_of_type_Bjng	Lbjng;
    //   347: bipush 102
    //   349: invokevirtual 102	bjng:removeMessages	(I)V
    //   352: aload_0
    //   353: iconst_0
    //   354: putfield 30	com/tencent/mobileqq/activity/ChatHistoryImageView$DownloadAndSaveTask:d	Z
    //   357: aload_0
    //   358: getfield 28	com/tencent/mobileqq/activity/ChatHistoryImageView$DownloadAndSaveTask:c	Z
    //   361: ifne +17 -> 378
    //   364: aload_0
    //   365: getfield 23	com/tencent/mobileqq/activity/ChatHistoryImageView$DownloadAndSaveTask:this$0	Lcom/tencent/mobileqq/activity/ChatHistoryImageView;
    //   368: getfield 86	com/tencent/mobileqq/activity/ChatHistoryImageView:jdField_a_of_type_Bjng	Lbjng;
    //   371: bipush 101
    //   373: invokevirtual 109	bjng:sendEmptyMessage	(I)Z
    //   376: pop
    //   377: return
    //   378: new 138	java/io/File
    //   381: dup
    //   382: getstatic 188	com/tencent/mobileqq/app/AppConstants:SDCARD_IMG_SAVE	Ljava/lang/String;
    //   385: invokespecial 141	java/io/File:<init>	(Ljava/lang/String;)V
    //   388: astore 12
    //   390: aload 12
    //   392: invokevirtual 144	java/io/File:exists	()Z
    //   395: ifne +9 -> 404
    //   398: aload 12
    //   400: invokevirtual 191	java/io/File:mkdirs	()Z
    //   403: pop
    //   404: iconst_0
    //   405: istore_1
    //   406: iconst_0
    //   407: istore 4
    //   409: iconst_0
    //   410: istore_3
    //   411: iload_3
    //   412: aload_0
    //   413: getfield 43	com/tencent/mobileqq/activity/ChatHistoryImageView$DownloadAndSaveTask:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   416: invokevirtual 90	java/util/ArrayList:size	()I
    //   419: if_icmpge +653 -> 1072
    //   422: aload_0
    //   423: getfield 23	com/tencent/mobileqq/activity/ChatHistoryImageView$DownloadAndSaveTask:this$0	Lcom/tencent/mobileqq/activity/ChatHistoryImageView;
    //   426: getfield 86	com/tencent/mobileqq/activity/ChatHistoryImageView:jdField_a_of_type_Bjng	Lbjng;
    //   429: bipush 100
    //   431: invokevirtual 171	bjng:obtainMessage	(I)Landroid/os/Message;
    //   434: astore 9
    //   436: aload 9
    //   438: iconst_2
    //   439: putfield 176	android/os/Message:arg1	I
    //   442: aload_0
    //   443: getfield 45	com/tencent/mobileqq/activity/ChatHistoryImageView$DownloadAndSaveTask:jdField_a_of_type_Boolean	Z
    //   446: ifeq +64 -> 510
    //   449: aload 9
    //   451: aload_0
    //   452: getfield 43	com/tencent/mobileqq/activity/ChatHistoryImageView$DownloadAndSaveTask:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   455: invokevirtual 90	java/util/ArrayList:size	()I
    //   458: iload_3
    //   459: iadd
    //   460: bipush 100
    //   462: imul
    //   463: aload_0
    //   464: getfield 43	com/tencent/mobileqq/activity/ChatHistoryImageView$DownloadAndSaveTask:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   467: invokevirtual 90	java/util/ArrayList:size	()I
    //   470: idiv
    //   471: iconst_2
    //   472: idiv
    //   473: putfield 179	android/os/Message:arg2	I
    //   476: aload_0
    //   477: getfield 23	com/tencent/mobileqq/activity/ChatHistoryImageView$DownloadAndSaveTask:this$0	Lcom/tencent/mobileqq/activity/ChatHistoryImageView;
    //   480: getfield 86	com/tencent/mobileqq/activity/ChatHistoryImageView:jdField_a_of_type_Bjng	Lbjng;
    //   483: aload 9
    //   485: invokevirtual 183	bjng:sendMessage	(Landroid/os/Message;)Z
    //   488: pop
    //   489: aload_0
    //   490: getfield 28	com/tencent/mobileqq/activity/ChatHistoryImageView$DownloadAndSaveTask:c	Z
    //   493: ifne +37 -> 530
    //   496: aload_0
    //   497: getfield 23	com/tencent/mobileqq/activity/ChatHistoryImageView$DownloadAndSaveTask:this$0	Lcom/tencent/mobileqq/activity/ChatHistoryImageView;
    //   500: getfield 86	com/tencent/mobileqq/activity/ChatHistoryImageView:jdField_a_of_type_Bjng	Lbjng;
    //   503: bipush 101
    //   505: invokevirtual 109	bjng:sendEmptyMessage	(I)Z
    //   508: pop
    //   509: return
    //   510: aload 9
    //   512: iload_3
    //   513: bipush 100
    //   515: imul
    //   516: aload_0
    //   517: getfield 43	com/tencent/mobileqq/activity/ChatHistoryImageView$DownloadAndSaveTask:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   520: invokevirtual 90	java/util/ArrayList:size	()I
    //   523: idiv
    //   524: putfield 179	android/os/Message:arg2	I
    //   527: goto -51 -> 476
    //   530: aload_0
    //   531: getfield 43	com/tencent/mobileqq/activity/ChatHistoryImageView$DownloadAndSaveTask:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   534: iload_3
    //   535: invokevirtual 113	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   538: checkcast 115	aham
    //   541: astore 10
    //   543: aconst_null
    //   544: astore 9
    //   546: ldc 117
    //   548: aload 10
    //   550: getfield 120	aham:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData	Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaData;
    //   553: invokevirtual 126	java/lang/Class:isInstance	(Ljava/lang/Object;)Z
    //   556: ifeq +132 -> 688
    //   559: aload 10
    //   561: getfield 120	aham:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData	Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaData;
    //   564: checkcast 117	com/tencent/mobileqq/activity/aio/photo/AIOImageData
    //   567: iconst_2
    //   568: invokevirtual 194	com/tencent/mobileqq/activity/aio/photo/AIOImageData:a	(I)Ljava/io/File;
    //   571: astore 9
    //   573: aload 9
    //   575: ifnonnull +42 -> 617
    //   578: iload 4
    //   580: istore_2
    //   581: iload_1
    //   582: istore 5
    //   584: invokestatic 57	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   587: ifeq +17 -> 604
    //   590: ldc 59
    //   592: iconst_2
    //   593: ldc 196
    //   595: invokestatic 198	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   598: iload_1
    //   599: istore 5
    //   601: iload 4
    //   603: istore_2
    //   604: iload_3
    //   605: iconst_1
    //   606: iadd
    //   607: istore_3
    //   608: iload_2
    //   609: istore 4
    //   611: iload 5
    //   613: istore_1
    //   614: goto -203 -> 411
    //   617: iload 4
    //   619: istore_2
    //   620: iload_1
    //   621: istore 5
    //   623: aload 9
    //   625: ifnull -21 -> 604
    //   628: invokestatic 204	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   631: invokestatic 210	com/tencent/image/Utils:getUsableSpace	(Ljava/io/File;)J
    //   634: lstore 7
    //   636: aload 9
    //   638: invokevirtual 214	java/io/File:length	()J
    //   641: lload 7
    //   643: lcmp
    //   644: ifle +142 -> 786
    //   647: invokestatic 57	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   650: ifeq +11 -> 661
    //   653: ldc 59
    //   655: iconst_2
    //   656: ldc 216
    //   658: invokestatic 78	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   661: ldc 217
    //   663: invokestatic 222	amtj:a	(I)Ljava/lang/String;
    //   666: invokestatic 226	aszk:a	(Ljava/lang/String;)V
    //   669: aload_0
    //   670: iconst_0
    //   671: putfield 28	com/tencent/mobileqq/activity/ChatHistoryImageView$DownloadAndSaveTask:c	Z
    //   674: aload_0
    //   675: getfield 23	com/tencent/mobileqq/activity/ChatHistoryImageView$DownloadAndSaveTask:this$0	Lcom/tencent/mobileqq/activity/ChatHistoryImageView;
    //   678: getfield 86	com/tencent/mobileqq/activity/ChatHistoryImageView:jdField_a_of_type_Bjng	Lbjng;
    //   681: bipush 101
    //   683: invokevirtual 109	bjng:sendEmptyMessage	(I)Z
    //   686: pop
    //   687: return
    //   688: ldc 228
    //   690: aload 10
    //   692: getfield 120	aham:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData	Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaData;
    //   695: invokevirtual 126	java/lang/Class:isInstance	(Ljava/lang/Object;)Z
    //   698: ifeq -81 -> 617
    //   701: aload 10
    //   703: getfield 120	aham:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData	Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaData;
    //   706: checkcast 228	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData
    //   709: astore 11
    //   711: aload 11
    //   713: bipush 20
    //   715: invokevirtual 229	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:a	(I)Ljava/io/File;
    //   718: astore 10
    //   720: aload 10
    //   722: astore 9
    //   724: aload 10
    //   726: ifnonnull -109 -> 617
    //   729: aload 11
    //   731: bipush 18
    //   733: invokevirtual 229	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:a	(I)Ljava/io/File;
    //   736: astore 10
    //   738: aload 10
    //   740: astore 9
    //   742: aload 10
    //   744: ifnonnull -127 -> 617
    //   747: aload 11
    //   749: bipush 16
    //   751: invokevirtual 229	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:a	(I)Ljava/io/File;
    //   754: astore 9
    //   756: aload 9
    //   758: ifnonnull +479 -> 1237
    //   761: invokestatic 57	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   764: ifeq +11 -> 775
    //   767: ldc 59
    //   769: iconst_2
    //   770: ldc 231
    //   772: invokestatic 198	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   775: iload_1
    //   776: iconst_1
    //   777: iadd
    //   778: istore 5
    //   780: iload 4
    //   782: istore_2
    //   783: goto -179 -> 604
    //   786: new 138	java/io/File
    //   789: dup
    //   790: aload 12
    //   792: new 61	java/lang/StringBuilder
    //   795: dup
    //   796: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   799: aload 9
    //   801: invokevirtual 234	java/io/File:getName	()Ljava/lang/String;
    //   804: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   807: ldc 236
    //   809: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   812: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   815: invokespecial 239	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   818: astore 11
    //   820: aload 11
    //   822: astore 10
    //   824: aload 11
    //   826: invokevirtual 144	java/io/File:exists	()Z
    //   829: ifeq +70 -> 899
    //   832: new 138	java/io/File
    //   835: dup
    //   836: aload 12
    //   838: new 61	java/lang/StringBuilder
    //   841: dup
    //   842: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   845: aload 9
    //   847: invokevirtual 234	java/io/File:getName	()Ljava/lang/String;
    //   850: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   853: ldc 241
    //   855: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   858: invokestatic 246	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getServerTimeMillis	()J
    //   861: invokevirtual 249	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   864: ldc 236
    //   866: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   869: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   872: invokespecial 239	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   875: astore 11
    //   877: aload 11
    //   879: astore 10
    //   881: invokestatic 57	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   884: ifeq +15 -> 899
    //   887: ldc 59
    //   889: iconst_2
    //   890: ldc 251
    //   892: invokestatic 78	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   895: aload 11
    //   897: astore 10
    //   899: aload 10
    //   901: invokevirtual 144	java/io/File:exists	()Z
    //   904: istore 6
    //   906: iload 6
    //   908: ifne +98 -> 1006
    //   911: aload 9
    //   913: aload 10
    //   915: invokestatic 256	fd:a	(Ljava/io/File;Ljava/io/File;)Z
    //   918: ifne +88 -> 1006
    //   921: invokestatic 259	android/os/Environment:getExternalStorageState	()Ljava/lang/String;
    //   924: ldc_w 261
    //   927: invokevirtual 265	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   930: ifne +46 -> 976
    //   933: invokestatic 57	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   936: ifeq +12 -> 948
    //   939: ldc 59
    //   941: iconst_2
    //   942: ldc_w 267
    //   945: invokestatic 78	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   948: ldc_w 268
    //   951: invokestatic 222	amtj:a	(I)Ljava/lang/String;
    //   954: invokestatic 226	aszk:a	(Ljava/lang/String;)V
    //   957: aload_0
    //   958: iconst_0
    //   959: putfield 28	com/tencent/mobileqq/activity/ChatHistoryImageView$DownloadAndSaveTask:c	Z
    //   962: aload_0
    //   963: getfield 23	com/tencent/mobileqq/activity/ChatHistoryImageView$DownloadAndSaveTask:this$0	Lcom/tencent/mobileqq/activity/ChatHistoryImageView;
    //   966: getfield 86	com/tencent/mobileqq/activity/ChatHistoryImageView:jdField_a_of_type_Bjng	Lbjng;
    //   969: bipush 101
    //   971: invokevirtual 109	bjng:sendEmptyMessage	(I)Z
    //   974: pop
    //   975: return
    //   976: iload 4
    //   978: istore_2
    //   979: iload_1
    //   980: istore 5
    //   982: invokestatic 57	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   985: ifeq -381 -> 604
    //   988: ldc 59
    //   990: iconst_2
    //   991: ldc_w 270
    //   994: invokestatic 78	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   997: iload 4
    //   999: istore_2
    //   1000: iload_1
    //   1001: istore 5
    //   1003: goto -399 -> 604
    //   1006: iload 4
    //   1008: iconst_1
    //   1009: iadd
    //   1010: istore 4
    //   1012: aload_0
    //   1013: getfield 23	com/tencent/mobileqq/activity/ChatHistoryImageView$DownloadAndSaveTask:this$0	Lcom/tencent/mobileqq/activity/ChatHistoryImageView;
    //   1016: getfield 273	com/tencent/mobileqq/activity/ChatHistoryImageView:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   1019: aload 10
    //   1021: invokevirtual 276	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1024: invokestatic 281	bfvo:a	(Landroid/content/Context;Ljava/lang/String;)V
    //   1027: iload 4
    //   1029: istore_2
    //   1030: iload_1
    //   1031: istore 5
    //   1033: invokestatic 57	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1036: ifeq -432 -> 604
    //   1039: ldc 59
    //   1041: iconst_2
    //   1042: iconst_2
    //   1043: anewarray 4	java/lang/Object
    //   1046: dup
    //   1047: iconst_0
    //   1048: ldc_w 283
    //   1051: aastore
    //   1052: dup
    //   1053: iconst_1
    //   1054: iload 6
    //   1056: invokestatic 289	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1059: aastore
    //   1060: invokestatic 292	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   1063: iload 4
    //   1065: istore_2
    //   1066: iload_1
    //   1067: istore 5
    //   1069: goto -465 -> 604
    //   1072: iload 4
    //   1074: aload_0
    //   1075: getfield 43	com/tencent/mobileqq/activity/ChatHistoryImageView$DownloadAndSaveTask:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1078: invokevirtual 90	java/util/ArrayList:size	()I
    //   1081: iload_1
    //   1082: isub
    //   1083: if_icmpne +60 -> 1143
    //   1086: new 61	java/lang/StringBuilder
    //   1089: dup
    //   1090: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   1093: aload_0
    //   1094: getfield 23	com/tencent/mobileqq/activity/ChatHistoryImageView$DownloadAndSaveTask:this$0	Lcom/tencent/mobileqq/activity/ChatHistoryImageView;
    //   1097: getfield 273	com/tencent/mobileqq/activity/ChatHistoryImageView:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   1100: invokevirtual 298	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   1103: ldc_w 299
    //   1106: invokevirtual 304	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   1109: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1112: getstatic 188	com/tencent/mobileqq/app/AppConstants:SDCARD_IMG_SAVE	Ljava/lang/String;
    //   1115: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1118: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1121: invokestatic 306	aszk:b	(Ljava/lang/String;)V
    //   1124: aload_0
    //   1125: iconst_0
    //   1126: putfield 28	com/tencent/mobileqq/activity/ChatHistoryImageView$DownloadAndSaveTask:c	Z
    //   1129: aload_0
    //   1130: getfield 23	com/tencent/mobileqq/activity/ChatHistoryImageView$DownloadAndSaveTask:this$0	Lcom/tencent/mobileqq/activity/ChatHistoryImageView;
    //   1133: getfield 86	com/tencent/mobileqq/activity/ChatHistoryImageView:jdField_a_of_type_Bjng	Lbjng;
    //   1136: bipush 101
    //   1138: invokevirtual 109	bjng:sendEmptyMessage	(I)Z
    //   1141: pop
    //   1142: return
    //   1143: iload 4
    //   1145: ifle +80 -> 1225
    //   1148: new 61	java/lang/StringBuilder
    //   1151: dup
    //   1152: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   1155: getstatic 312	java/util/Locale:CHINA	Ljava/util/Locale;
    //   1158: aload_0
    //   1159: getfield 23	com/tencent/mobileqq/activity/ChatHistoryImageView$DownloadAndSaveTask:this$0	Lcom/tencent/mobileqq/activity/ChatHistoryImageView;
    //   1162: getfield 273	com/tencent/mobileqq/activity/ChatHistoryImageView:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   1165: invokevirtual 298	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   1168: ldc_w 313
    //   1171: invokevirtual 304	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   1174: iconst_2
    //   1175: anewarray 4	java/lang/Object
    //   1178: dup
    //   1179: iconst_0
    //   1180: iload 4
    //   1182: invokestatic 318	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1185: aastore
    //   1186: dup
    //   1187: iconst_1
    //   1188: aload_0
    //   1189: getfield 43	com/tencent/mobileqq/activity/ChatHistoryImageView$DownloadAndSaveTask:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1192: invokevirtual 90	java/util/ArrayList:size	()I
    //   1195: iload_1
    //   1196: isub
    //   1197: iload 4
    //   1199: isub
    //   1200: invokestatic 318	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1203: aastore
    //   1204: invokestatic 322	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1207: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1210: getstatic 188	com/tencent/mobileqq/app/AppConstants:SDCARD_IMG_SAVE	Ljava/lang/String;
    //   1213: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1216: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1219: invokestatic 306	aszk:b	(Ljava/lang/String;)V
    //   1222: goto -98 -> 1124
    //   1225: ldc_w 323
    //   1228: invokestatic 222	amtj:a	(I)Ljava/lang/String;
    //   1231: invokestatic 226	aszk:a	(Ljava/lang/String;)V
    //   1234: goto -110 -> 1124
    //   1237: goto -620 -> 617
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1240	0	this	DownloadAndSaveTask
    //   38	1159	1	i	int
    //   580	486	2	j	int
    //   410	198	3	k	int
    //   407	793	4	m	int
    //   582	486	5	n	int
    //   188	867	6	bool	boolean
    //   634	8	7	l	long
    //   105	59	10	localAIOImageData	com.tencent.mobileqq.activity.aio.photo.AIOImageData
    //   235	1	10	localInterruptedException1	java.lang.InterruptedException
    //   240	3	10	localInterruptedException2	java.lang.InterruptedException
    //   250	6	10	localObject2	Object
    //   332	6	10	localObject3	Object
    //   541	479	10	localObject4	Object
    //   112	784	11	localObject5	Object
    //   388	449	12	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   225	232	235	java/lang/InterruptedException
    //   195	202	240	java/lang/InterruptedException
    //   181	190	250	finally
    //   195	202	250	finally
    //   202	205	250	finally
    //   242	247	250	finally
    //   252	255	250	finally
    //   214	220	332	finally
    //   225	232	332	finally
    //   258	261	332	finally
    //   334	337	332	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistoryImageView.DownloadAndSaveTask
 * JD-Core Version:    0.7.0.1
 */