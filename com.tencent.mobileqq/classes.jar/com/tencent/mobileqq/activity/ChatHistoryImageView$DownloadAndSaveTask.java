package com.tencent.mobileqq.activity;

import aeja;
import bfnk;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class ChatHistoryImageView$DownloadAndSaveTask
  implements Runnable
{
  volatile int jdField_a_of_type_Int = 0;
  aeja jdField_a_of_type_Aeja;
  final Object jdField_a_of_type_JavaLangObject = new Object();
  ArrayList<aeja> jdField_a_of_type_JavaUtilArrayList;
  boolean jdField_a_of_type_Boolean;
  public boolean b;
  volatile boolean c = true;
  volatile boolean d = false;
  volatile boolean e = false;
  
  public ChatHistoryImageView$DownloadAndSaveTask(ArrayList<aeja> paramArrayList, boolean paramBoolean1, boolean paramBoolean2)
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
        this.this$0.jdField_a_of_type_Bfnk.sendEmptyMessageDelayed(102, (this.jdField_a_of_type_JavaUtilArrayList.size() - this.jdField_a_of_type_Int) * 60000L);
        return;
      }
      this.this$0.jdField_a_of_type_Bfnk.removeMessages(102);
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
    //   16: getfield 86	com/tencent/mobileqq/activity/ChatHistoryImageView:jdField_a_of_type_Bfnk	Lbfnk;
    //   19: bipush 102
    //   21: aload_0
    //   22: getfield 43	com/tencent/mobileqq/activity/ChatHistoryImageView$DownloadAndSaveTask:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   25: invokevirtual 90	java/util/ArrayList:size	()I
    //   28: i2l
    //   29: ldc2_w 91
    //   32: lmul
    //   33: invokevirtual 98	bfnk:sendEmptyMessageDelayed	(IJ)Z
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
    //   61: getfield 86	com/tencent/mobileqq/activity/ChatHistoryImageView:jdField_a_of_type_Bfnk	Lbfnk;
    //   64: bipush 101
    //   66: invokevirtual 109	bfnk:sendEmptyMessage	(I)Z
    //   69: pop
    //   70: return
    //   71: aload_0
    //   72: getfield 43	com/tencent/mobileqq/activity/ChatHistoryImageView$DownloadAndSaveTask:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   75: iload_1
    //   76: invokevirtual 113	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   79: checkcast 115	aeja
    //   82: astore 9
    //   84: ldc 117
    //   86: aload 9
    //   88: getfield 120	aeja:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData	Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaData;
    //   91: invokevirtual 126	java/lang/Class:isInstance	(Ljava/lang/Object;)Z
    //   94: ifeq +167 -> 261
    //   97: aload 9
    //   99: getfield 120	aeja:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData	Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaData;
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
    //   142: putfield 146	com/tencent/mobileqq/activity/ChatHistoryImageView$DownloadAndSaveTask:jdField_a_of_type_Aeja	Laeja;
    //   145: aload 9
    //   147: iconst_1
    //   148: putfield 147	aeja:jdField_a_of_type_Boolean	Z
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
    //   173: getfield 146	com/tencent/mobileqq/activity/ChatHistoryImageView$DownloadAndSaveTask:jdField_a_of_type_Aeja	Laeja;
    //   176: astore 9
    //   178: aload 9
    //   180: monitorenter
    //   181: aload_0
    //   182: getfield 146	com/tencent/mobileqq/activity/ChatHistoryImageView$DownloadAndSaveTask:jdField_a_of_type_Aeja	Laeja;
    //   185: getfield 147	aeja:jdField_a_of_type_Boolean	Z
    //   188: istore 6
    //   190: iload 6
    //   192: ifeq +10 -> 202
    //   195: aload_0
    //   196: getfield 146	com/tencent/mobileqq/activity/ChatHistoryImageView$DownloadAndSaveTask:jdField_a_of_type_Aeja	Laeja;
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
    //   275: getfield 86	com/tencent/mobileqq/activity/ChatHistoryImageView:jdField_a_of_type_Bfnk	Lbfnk;
    //   278: bipush 100
    //   280: invokevirtual 171	bfnk:obtainMessage	(I)Landroid/os/Message;
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
    //   316: getfield 86	com/tencent/mobileqq/activity/ChatHistoryImageView:jdField_a_of_type_Bfnk	Lbfnk;
    //   319: aload 9
    //   321: invokevirtual 183	bfnk:sendMessage	(Landroid/os/Message;)Z
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
    //   344: getfield 86	com/tencent/mobileqq/activity/ChatHistoryImageView:jdField_a_of_type_Bfnk	Lbfnk;
    //   347: bipush 102
    //   349: invokevirtual 102	bfnk:removeMessages	(I)V
    //   352: aload_0
    //   353: iconst_0
    //   354: putfield 30	com/tencent/mobileqq/activity/ChatHistoryImageView$DownloadAndSaveTask:d	Z
    //   357: aload_0
    //   358: getfield 28	com/tencent/mobileqq/activity/ChatHistoryImageView$DownloadAndSaveTask:c	Z
    //   361: ifne +17 -> 378
    //   364: aload_0
    //   365: getfield 23	com/tencent/mobileqq/activity/ChatHistoryImageView$DownloadAndSaveTask:this$0	Lcom/tencent/mobileqq/activity/ChatHistoryImageView;
    //   368: getfield 86	com/tencent/mobileqq/activity/ChatHistoryImageView:jdField_a_of_type_Bfnk	Lbfnk;
    //   371: bipush 101
    //   373: invokevirtual 109	bfnk:sendEmptyMessage	(I)Z
    //   376: pop
    //   377: return
    //   378: new 138	java/io/File
    //   381: dup
    //   382: getstatic 188	ajsf:bc	Ljava/lang/String;
    //   385: invokespecial 141	java/io/File:<init>	(Ljava/lang/String;)V
    //   388: astore 11
    //   390: aload 11
    //   392: invokevirtual 144	java/io/File:exists	()Z
    //   395: ifne +9 -> 404
    //   398: aload 11
    //   400: invokevirtual 191	java/io/File:mkdirs	()Z
    //   403: pop
    //   404: iconst_0
    //   405: istore_1
    //   406: iconst_0
    //   407: istore_3
    //   408: iconst_0
    //   409: istore_2
    //   410: iload_2
    //   411: aload_0
    //   412: getfield 43	com/tencent/mobileqq/activity/ChatHistoryImageView$DownloadAndSaveTask:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   415: invokevirtual 90	java/util/ArrayList:size	()I
    //   418: if_icmpge +525 -> 943
    //   421: aload_0
    //   422: getfield 23	com/tencent/mobileqq/activity/ChatHistoryImageView$DownloadAndSaveTask:this$0	Lcom/tencent/mobileqq/activity/ChatHistoryImageView;
    //   425: getfield 86	com/tencent/mobileqq/activity/ChatHistoryImageView:jdField_a_of_type_Bfnk	Lbfnk;
    //   428: bipush 100
    //   430: invokevirtual 171	bfnk:obtainMessage	(I)Landroid/os/Message;
    //   433: astore 9
    //   435: aload 9
    //   437: iconst_2
    //   438: putfield 176	android/os/Message:arg1	I
    //   441: aload_0
    //   442: getfield 45	com/tencent/mobileqq/activity/ChatHistoryImageView$DownloadAndSaveTask:jdField_a_of_type_Boolean	Z
    //   445: ifeq +64 -> 509
    //   448: aload 9
    //   450: aload_0
    //   451: getfield 43	com/tencent/mobileqq/activity/ChatHistoryImageView$DownloadAndSaveTask:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   454: invokevirtual 90	java/util/ArrayList:size	()I
    //   457: iload_2
    //   458: iadd
    //   459: bipush 100
    //   461: imul
    //   462: aload_0
    //   463: getfield 43	com/tencent/mobileqq/activity/ChatHistoryImageView$DownloadAndSaveTask:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   466: invokevirtual 90	java/util/ArrayList:size	()I
    //   469: idiv
    //   470: iconst_2
    //   471: idiv
    //   472: putfield 179	android/os/Message:arg2	I
    //   475: aload_0
    //   476: getfield 23	com/tencent/mobileqq/activity/ChatHistoryImageView$DownloadAndSaveTask:this$0	Lcom/tencent/mobileqq/activity/ChatHistoryImageView;
    //   479: getfield 86	com/tencent/mobileqq/activity/ChatHistoryImageView:jdField_a_of_type_Bfnk	Lbfnk;
    //   482: aload 9
    //   484: invokevirtual 183	bfnk:sendMessage	(Landroid/os/Message;)Z
    //   487: pop
    //   488: aload_0
    //   489: getfield 28	com/tencent/mobileqq/activity/ChatHistoryImageView$DownloadAndSaveTask:c	Z
    //   492: ifne +37 -> 529
    //   495: aload_0
    //   496: getfield 23	com/tencent/mobileqq/activity/ChatHistoryImageView$DownloadAndSaveTask:this$0	Lcom/tencent/mobileqq/activity/ChatHistoryImageView;
    //   499: getfield 86	com/tencent/mobileqq/activity/ChatHistoryImageView:jdField_a_of_type_Bfnk	Lbfnk;
    //   502: bipush 101
    //   504: invokevirtual 109	bfnk:sendEmptyMessage	(I)Z
    //   507: pop
    //   508: return
    //   509: aload 9
    //   511: iload_2
    //   512: bipush 100
    //   514: imul
    //   515: aload_0
    //   516: getfield 43	com/tencent/mobileqq/activity/ChatHistoryImageView$DownloadAndSaveTask:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   519: invokevirtual 90	java/util/ArrayList:size	()I
    //   522: idiv
    //   523: putfield 179	android/os/Message:arg2	I
    //   526: goto -51 -> 475
    //   529: aload_0
    //   530: getfield 43	com/tencent/mobileqq/activity/ChatHistoryImageView$DownloadAndSaveTask:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   533: iload_2
    //   534: invokevirtual 113	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   537: checkcast 115	aeja
    //   540: astore 9
    //   542: ldc 117
    //   544: aload 9
    //   546: getfield 120	aeja:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData	Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaData;
    //   549: invokevirtual 126	java/lang/Class:isInstance	(Ljava/lang/Object;)Z
    //   552: ifeq +65 -> 617
    //   555: aload 9
    //   557: getfield 120	aeja:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData	Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaData;
    //   560: checkcast 117	com/tencent/mobileqq/activity/aio/photo/AIOImageData
    //   563: iconst_2
    //   564: invokevirtual 194	com/tencent/mobileqq/activity/aio/photo/AIOImageData:a	(I)Ljava/io/File;
    //   567: astore 10
    //   569: aload 10
    //   571: astore 9
    //   573: aload 10
    //   575: ifnonnull +144 -> 719
    //   578: iload_3
    //   579: istore 4
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
    //   601: iload_3
    //   602: istore 4
    //   604: iload_2
    //   605: iconst_1
    //   606: iadd
    //   607: istore_2
    //   608: iload 4
    //   610: istore_3
    //   611: iload 5
    //   613: istore_1
    //   614: goto -204 -> 410
    //   617: ldc 200
    //   619: aload 9
    //   621: getfield 120	aeja:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData	Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaData;
    //   624: invokevirtual 126	java/lang/Class:isInstance	(Ljava/lang/Object;)Z
    //   627: ifeq +477 -> 1104
    //   630: aload 9
    //   632: getfield 120	aeja:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData	Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaData;
    //   635: checkcast 200	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData
    //   638: astore 12
    //   640: aload 12
    //   642: bipush 20
    //   644: invokevirtual 201	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:a	(I)Ljava/io/File;
    //   647: astore 10
    //   649: aload 10
    //   651: astore 9
    //   653: aload 10
    //   655: ifnonnull +64 -> 719
    //   658: aload 12
    //   660: bipush 18
    //   662: invokevirtual 201	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:a	(I)Ljava/io/File;
    //   665: astore 10
    //   667: aload 10
    //   669: astore 9
    //   671: aload 10
    //   673: ifnonnull +46 -> 719
    //   676: aload 12
    //   678: bipush 16
    //   680: invokevirtual 201	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:a	(I)Ljava/io/File;
    //   683: astore 10
    //   685: aload 10
    //   687: astore 9
    //   689: aload 10
    //   691: ifnonnull +28 -> 719
    //   694: invokestatic 57	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   697: ifeq +11 -> 708
    //   700: ldc 59
    //   702: iconst_2
    //   703: ldc 203
    //   705: invokestatic 198	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   708: iload_1
    //   709: iconst_1
    //   710: iadd
    //   711: istore 5
    //   713: iload_3
    //   714: istore 4
    //   716: goto -112 -> 604
    //   719: iload_3
    //   720: istore 4
    //   722: iload_1
    //   723: istore 5
    //   725: aload 9
    //   727: ifnull -123 -> 604
    //   730: invokestatic 209	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   733: invokestatic 215	com/tencent/image/Utils:getUsableSpace	(Ljava/io/File;)J
    //   736: lstore 7
    //   738: aload 9
    //   740: invokevirtual 219	java/io/File:length	()J
    //   743: lload 7
    //   745: lcmp
    //   746: ifle +44 -> 790
    //   749: invokestatic 57	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   752: ifeq +11 -> 763
    //   755: ldc 59
    //   757: iconst_2
    //   758: ldc 221
    //   760: invokestatic 78	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   763: ldc 222
    //   765: invokestatic 227	ajyc:a	(I)Ljava/lang/String;
    //   768: invokestatic 231	aptv:a	(Ljava/lang/String;)V
    //   771: aload_0
    //   772: iconst_0
    //   773: putfield 28	com/tencent/mobileqq/activity/ChatHistoryImageView$DownloadAndSaveTask:c	Z
    //   776: aload_0
    //   777: getfield 23	com/tencent/mobileqq/activity/ChatHistoryImageView$DownloadAndSaveTask:this$0	Lcom/tencent/mobileqq/activity/ChatHistoryImageView;
    //   780: getfield 86	com/tencent/mobileqq/activity/ChatHistoryImageView:jdField_a_of_type_Bfnk	Lbfnk;
    //   783: bipush 101
    //   785: invokevirtual 109	bfnk:sendEmptyMessage	(I)Z
    //   788: pop
    //   789: return
    //   790: new 138	java/io/File
    //   793: dup
    //   794: aload 11
    //   796: new 61	java/lang/StringBuilder
    //   799: dup
    //   800: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   803: aload 9
    //   805: invokevirtual 234	java/io/File:getName	()Ljava/lang/String;
    //   808: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   811: ldc 236
    //   813: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   816: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   819: invokespecial 239	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   822: astore 10
    //   824: aload 9
    //   826: aload 10
    //   828: invokestatic 244	gp:a	(Ljava/io/File;Ljava/io/File;)Z
    //   831: ifne +86 -> 917
    //   834: invokestatic 247	android/os/Environment:getExternalStorageState	()Ljava/lang/String;
    //   837: ldc 249
    //   839: invokevirtual 253	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   842: ifne +45 -> 887
    //   845: invokestatic 57	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   848: ifeq +11 -> 859
    //   851: ldc 59
    //   853: iconst_2
    //   854: ldc 255
    //   856: invokestatic 78	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   859: ldc_w 256
    //   862: invokestatic 227	ajyc:a	(I)Ljava/lang/String;
    //   865: invokestatic 231	aptv:a	(Ljava/lang/String;)V
    //   868: aload_0
    //   869: iconst_0
    //   870: putfield 28	com/tencent/mobileqq/activity/ChatHistoryImageView$DownloadAndSaveTask:c	Z
    //   873: aload_0
    //   874: getfield 23	com/tencent/mobileqq/activity/ChatHistoryImageView$DownloadAndSaveTask:this$0	Lcom/tencent/mobileqq/activity/ChatHistoryImageView;
    //   877: getfield 86	com/tencent/mobileqq/activity/ChatHistoryImageView:jdField_a_of_type_Bfnk	Lbfnk;
    //   880: bipush 101
    //   882: invokevirtual 109	bfnk:sendEmptyMessage	(I)Z
    //   885: pop
    //   886: return
    //   887: iload_3
    //   888: istore 4
    //   890: iload_1
    //   891: istore 5
    //   893: invokestatic 57	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   896: ifeq -292 -> 604
    //   899: ldc 59
    //   901: iconst_2
    //   902: ldc_w 258
    //   905: invokestatic 78	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   908: iload_3
    //   909: istore 4
    //   911: iload_1
    //   912: istore 5
    //   914: goto -310 -> 604
    //   917: iload_3
    //   918: iconst_1
    //   919: iadd
    //   920: istore 4
    //   922: aload_0
    //   923: getfield 23	com/tencent/mobileqq/activity/ChatHistoryImageView$DownloadAndSaveTask:this$0	Lcom/tencent/mobileqq/activity/ChatHistoryImageView;
    //   926: getfield 261	com/tencent/mobileqq/activity/ChatHistoryImageView:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   929: aload 10
    //   931: invokevirtual 264	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   934: invokestatic 269	bbdr:a	(Landroid/content/Context;Ljava/lang/String;)V
    //   937: iload_1
    //   938: istore 5
    //   940: goto -336 -> 604
    //   943: iload_3
    //   944: aload_0
    //   945: getfield 43	com/tencent/mobileqq/activity/ChatHistoryImageView$DownloadAndSaveTask:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   948: invokevirtual 90	java/util/ArrayList:size	()I
    //   951: iload_1
    //   952: isub
    //   953: if_icmpne +60 -> 1013
    //   956: new 61	java/lang/StringBuilder
    //   959: dup
    //   960: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   963: aload_0
    //   964: getfield 23	com/tencent/mobileqq/activity/ChatHistoryImageView$DownloadAndSaveTask:this$0	Lcom/tencent/mobileqq/activity/ChatHistoryImageView;
    //   967: getfield 261	com/tencent/mobileqq/activity/ChatHistoryImageView:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   970: invokevirtual 275	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   973: ldc_w 276
    //   976: invokevirtual 281	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   979: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   982: getstatic 188	ajsf:bc	Ljava/lang/String;
    //   985: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   988: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   991: invokestatic 283	aptv:b	(Ljava/lang/String;)V
    //   994: aload_0
    //   995: iconst_0
    //   996: putfield 28	com/tencent/mobileqq/activity/ChatHistoryImageView$DownloadAndSaveTask:c	Z
    //   999: aload_0
    //   1000: getfield 23	com/tencent/mobileqq/activity/ChatHistoryImageView$DownloadAndSaveTask:this$0	Lcom/tencent/mobileqq/activity/ChatHistoryImageView;
    //   1003: getfield 86	com/tencent/mobileqq/activity/ChatHistoryImageView:jdField_a_of_type_Bfnk	Lbfnk;
    //   1006: bipush 101
    //   1008: invokevirtual 109	bfnk:sendEmptyMessage	(I)Z
    //   1011: pop
    //   1012: return
    //   1013: iload_3
    //   1014: ifle +78 -> 1092
    //   1017: new 61	java/lang/StringBuilder
    //   1020: dup
    //   1021: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   1024: getstatic 289	java/util/Locale:CHINA	Ljava/util/Locale;
    //   1027: aload_0
    //   1028: getfield 23	com/tencent/mobileqq/activity/ChatHistoryImageView$DownloadAndSaveTask:this$0	Lcom/tencent/mobileqq/activity/ChatHistoryImageView;
    //   1031: getfield 261	com/tencent/mobileqq/activity/ChatHistoryImageView:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   1034: invokevirtual 275	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   1037: ldc_w 290
    //   1040: invokevirtual 281	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   1043: iconst_2
    //   1044: anewarray 4	java/lang/Object
    //   1047: dup
    //   1048: iconst_0
    //   1049: iload_3
    //   1050: invokestatic 296	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1053: aastore
    //   1054: dup
    //   1055: iconst_1
    //   1056: aload_0
    //   1057: getfield 43	com/tencent/mobileqq/activity/ChatHistoryImageView$DownloadAndSaveTask:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1060: invokevirtual 90	java/util/ArrayList:size	()I
    //   1063: iload_1
    //   1064: isub
    //   1065: iload_3
    //   1066: isub
    //   1067: invokestatic 296	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1070: aastore
    //   1071: invokestatic 300	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1074: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1077: getstatic 188	ajsf:bc	Ljava/lang/String;
    //   1080: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1083: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1086: invokestatic 283	aptv:b	(Ljava/lang/String;)V
    //   1089: goto -95 -> 994
    //   1092: ldc_w 301
    //   1095: invokestatic 227	ajyc:a	(I)Ljava/lang/String;
    //   1098: invokestatic 231	aptv:a	(Ljava/lang/String;)V
    //   1101: goto -107 -> 994
    //   1104: aconst_null
    //   1105: astore 9
    //   1107: goto -388 -> 719
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1110	0	this	DownloadAndSaveTask
    //   38	1027	1	i	int
    //   409	199	2	j	int
    //   407	660	3	k	int
    //   579	342	4	m	int
    //   582	357	5	n	int
    //   188	33	6	bool	boolean
    //   736	8	7	l	long
    //   105	59	10	localAIOImageData	com.tencent.mobileqq.activity.aio.photo.AIOImageData
    //   235	1	10	localInterruptedException1	java.lang.InterruptedException
    //   240	3	10	localInterruptedException2	java.lang.InterruptedException
    //   250	6	10	localObject2	Object
    //   332	6	10	localObject3	Object
    //   567	363	10	localFile	java.io.File
    //   112	683	11	localObject4	Object
    //   638	39	12	localAIOFilePicData	com.tencent.mobileqq.activity.aio.photo.AIOFilePicData
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistoryImageView.DownloadAndSaveTask
 * JD-Core Version:    0.7.0.1
 */