package com.tencent.mobileqq.activity.aio.doodle;

import android.graphics.Rect;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.scribble.ScribbleMsgUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class LoadDataJob
  implements Runnable
{
  private static final String jdField_b_of_type_JavaLangString = ScribbleMsgUtils.a() + "pclcache" + File.separator;
  final int jdField_a_of_type_Int = 3;
  public String a;
  private WeakReference<LoadDataJob.LoadDataJobListener> jdField_a_of_type_JavaLangRefWeakReference;
  private int jdField_b_of_type_Int;
  private int c;
  private int d = 0;
  
  public LoadDataJob(String paramString, int paramInt1, int paramInt2, LoadDataJob.LoadDataJobListener paramLoadDataJobListener)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramLoadDataJobListener);
    this.jdField_b_of_type_Int = paramInt1;
    this.c = paramInt2;
  }
  
  /* Error */
  private DoodleParam a(String paramString)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aconst_null
    //   3: astore 6
    //   5: aload_1
    //   6: invokestatic 72	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9: ifeq +5 -> 14
    //   12: aconst_null
    //   13: areturn
    //   14: new 74	java/io/FileInputStream
    //   17: dup
    //   18: aload_1
    //   19: invokespecial 77	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   22: astore 7
    //   24: aload 7
    //   26: invokevirtual 81	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   29: lconst_0
    //   30: ldc2_w 82
    //   33: iconst_1
    //   34: invokevirtual 89	java/nio/channels/FileChannel:tryLock	(JJZ)Ljava/nio/channels/FileLock;
    //   37: astore 4
    //   39: aload 4
    //   41: astore 6
    //   43: aload 6
    //   45: ifnull +900 -> 945
    //   48: new 91	java/io/BufferedInputStream
    //   51: dup
    //   52: aload 7
    //   54: invokespecial 94	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   57: astore 5
    //   59: iconst_4
    //   60: newarray byte
    //   62: astore 4
    //   64: aload 5
    //   66: aload 4
    //   68: invokevirtual 100	java/io/InputStream:read	([B)I
    //   71: iconst_4
    //   72: if_icmpne +867 -> 939
    //   75: aload 4
    //   77: iconst_0
    //   78: invokestatic 105	com/tencent/mobileqq/activity/aio/doodle/DoodleMsgTranslator:a	([BI)I
    //   81: istore_3
    //   82: iload_3
    //   83: ifle +9 -> 92
    //   86: iload_3
    //   87: ldc 106
    //   89: if_icmplt +103 -> 192
    //   92: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   95: ifeq +28 -> 123
    //   98: ldc 114
    //   100: iconst_2
    //   101: new 18	java/lang/StringBuilder
    //   104: dup
    //   105: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   108: ldc 116
    //   110: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: iload_3
    //   114: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   117: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: invokestatic 123	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   123: iconst_0
    //   124: istore_2
    //   125: aconst_null
    //   126: astore 4
    //   128: aload 6
    //   130: ifnull +8 -> 138
    //   133: aload 6
    //   135: invokevirtual 128	java/nio/channels/FileLock:release	()V
    //   138: aload 7
    //   140: ifnull +8 -> 148
    //   143: aload 7
    //   145: invokevirtual 131	java/io/FileInputStream:close	()V
    //   148: aload 5
    //   150: ifnull +8 -> 158
    //   153: aload 5
    //   155: invokevirtual 132	java/io/InputStream:close	()V
    //   158: aload 4
    //   160: astore 5
    //   162: iload_2
    //   163: ifne +26 -> 189
    //   166: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   169: ifeq +11 -> 180
    //   172: ldc 114
    //   174: iconst_2
    //   175: ldc 134
    //   177: invokestatic 123	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   180: aload_1
    //   181: invokestatic 139	com/tencent/mobileqq/utils/FileUtils:e	(Ljava/lang/String;)Z
    //   184: pop
    //   185: aload 4
    //   187: astore 5
    //   189: aload 5
    //   191: areturn
    //   192: iload_3
    //   193: newarray byte
    //   195: astore 4
    //   197: aload 5
    //   199: aload 4
    //   201: iconst_0
    //   202: iload_3
    //   203: invokevirtual 142	java/io/InputStream:read	([BII)I
    //   206: iload_3
    //   207: if_icmpeq +37 -> 244
    //   210: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   213: ifeq +741 -> 954
    //   216: ldc 114
    //   218: iconst_2
    //   219: new 18	java/lang/StringBuilder
    //   222: dup
    //   223: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   226: ldc 144
    //   228: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: iload_3
    //   232: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   235: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   238: invokestatic 123	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   241: goto +713 -> 954
    //   244: aload_0
    //   245: aload 4
    //   247: invokevirtual 147	com/tencent/mobileqq/activity/aio/doodle/LoadDataJob:a	([B)Lcom/tencent/mobileqq/activity/aio/doodle/MyParcel;
    //   250: astore 4
    //   252: aload 4
    //   254: ifnull +685 -> 939
    //   257: getstatic 152	com/tencent/mobileqq/activity/aio/doodle/DoodleParam:a	Lcom/tencent/mobileqq/activity/aio/doodle/MyParcelable$Creator;
    //   260: aload 4
    //   262: invokeinterface 157 2 0
    //   267: checkcast 149	com/tencent/mobileqq/activity/aio/doodle/DoodleParam
    //   270: astore 4
    //   272: goto -144 -> 128
    //   275: astore 6
    //   277: aload 6
    //   279: invokevirtual 160	java/lang/Exception:printStackTrace	()V
    //   282: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   285: ifeq -147 -> 138
    //   288: ldc 114
    //   290: iconst_2
    //   291: new 18	java/lang/StringBuilder
    //   294: dup
    //   295: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   298: ldc 162
    //   300: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: aload 6
    //   305: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   308: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   311: invokestatic 167	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   314: goto -176 -> 138
    //   317: astore 6
    //   319: aload 6
    //   321: invokevirtual 160	java/lang/Exception:printStackTrace	()V
    //   324: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   327: ifeq -179 -> 148
    //   330: ldc 114
    //   332: iconst_2
    //   333: new 18	java/lang/StringBuilder
    //   336: dup
    //   337: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   340: ldc 162
    //   342: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   345: aload 6
    //   347: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   350: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   353: invokestatic 167	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   356: goto -208 -> 148
    //   359: astore 5
    //   361: aload 5
    //   363: invokevirtual 160	java/lang/Exception:printStackTrace	()V
    //   366: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   369: ifeq -211 -> 158
    //   372: ldc 114
    //   374: iconst_2
    //   375: new 18	java/lang/StringBuilder
    //   378: dup
    //   379: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   382: ldc 162
    //   384: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   387: aload 5
    //   389: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   392: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   395: invokestatic 167	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   398: goto -240 -> 158
    //   401: astore 7
    //   403: aconst_null
    //   404: astore 6
    //   406: aconst_null
    //   407: astore 5
    //   409: aconst_null
    //   410: astore 4
    //   412: aload 7
    //   414: invokevirtual 160	java/lang/Exception:printStackTrace	()V
    //   417: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   420: ifeq +29 -> 449
    //   423: ldc 114
    //   425: iconst_2
    //   426: new 18	java/lang/StringBuilder
    //   429: dup
    //   430: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   433: ldc 169
    //   435: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   438: aload 7
    //   440: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   443: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   446: invokestatic 167	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   449: aload 6
    //   451: ifnull +8 -> 459
    //   454: aload 6
    //   456: invokevirtual 128	java/nio/channels/FileLock:release	()V
    //   459: aload 5
    //   461: ifnull +8 -> 469
    //   464: aload 5
    //   466: invokevirtual 131	java/io/FileInputStream:close	()V
    //   469: aload 4
    //   471: ifnull +8 -> 479
    //   474: aload 4
    //   476: invokevirtual 132	java/io/InputStream:close	()V
    //   479: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   482: ifeq +11 -> 493
    //   485: ldc 114
    //   487: iconst_2
    //   488: ldc 134
    //   490: invokestatic 123	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   493: aload_1
    //   494: invokestatic 139	com/tencent/mobileqq/utils/FileUtils:e	(Ljava/lang/String;)Z
    //   497: pop
    //   498: aconst_null
    //   499: astore 5
    //   501: goto -312 -> 189
    //   504: astore 6
    //   506: aload 6
    //   508: invokevirtual 160	java/lang/Exception:printStackTrace	()V
    //   511: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   514: ifeq -55 -> 459
    //   517: ldc 114
    //   519: iconst_2
    //   520: new 18	java/lang/StringBuilder
    //   523: dup
    //   524: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   527: ldc 162
    //   529: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   532: aload 6
    //   534: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   537: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   540: invokestatic 167	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   543: goto -84 -> 459
    //   546: astore 5
    //   548: aload 5
    //   550: invokevirtual 160	java/lang/Exception:printStackTrace	()V
    //   553: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   556: ifeq -87 -> 469
    //   559: ldc 114
    //   561: iconst_2
    //   562: new 18	java/lang/StringBuilder
    //   565: dup
    //   566: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   569: ldc 162
    //   571: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   574: aload 5
    //   576: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   579: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   582: invokestatic 167	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   585: goto -116 -> 469
    //   588: astore 4
    //   590: aload 4
    //   592: invokevirtual 160	java/lang/Exception:printStackTrace	()V
    //   595: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   598: ifeq -119 -> 479
    //   601: ldc 114
    //   603: iconst_2
    //   604: new 18	java/lang/StringBuilder
    //   607: dup
    //   608: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   611: ldc 162
    //   613: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   616: aload 4
    //   618: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   621: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   624: invokestatic 167	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   627: goto -148 -> 479
    //   630: astore 4
    //   632: iconst_1
    //   633: istore_2
    //   634: aconst_null
    //   635: astore 7
    //   637: aconst_null
    //   638: astore 5
    //   640: aload 6
    //   642: ifnull +8 -> 650
    //   645: aload 6
    //   647: invokevirtual 128	java/nio/channels/FileLock:release	()V
    //   650: aload 7
    //   652: ifnull +8 -> 660
    //   655: aload 7
    //   657: invokevirtual 131	java/io/FileInputStream:close	()V
    //   660: aload 5
    //   662: ifnull +8 -> 670
    //   665: aload 5
    //   667: invokevirtual 132	java/io/InputStream:close	()V
    //   670: iload_2
    //   671: ifne +22 -> 693
    //   674: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   677: ifeq +11 -> 688
    //   680: ldc 114
    //   682: iconst_2
    //   683: ldc 134
    //   685: invokestatic 123	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   688: aload_1
    //   689: invokestatic 139	com/tencent/mobileqq/utils/FileUtils:e	(Ljava/lang/String;)Z
    //   692: pop
    //   693: aload 4
    //   695: athrow
    //   696: astore 6
    //   698: aload 6
    //   700: invokevirtual 160	java/lang/Exception:printStackTrace	()V
    //   703: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   706: ifeq -56 -> 650
    //   709: ldc 114
    //   711: iconst_2
    //   712: new 18	java/lang/StringBuilder
    //   715: dup
    //   716: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   719: ldc 162
    //   721: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   724: aload 6
    //   726: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   729: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   732: invokestatic 167	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   735: goto -85 -> 650
    //   738: astore 6
    //   740: aload 6
    //   742: invokevirtual 160	java/lang/Exception:printStackTrace	()V
    //   745: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   748: ifeq -88 -> 660
    //   751: ldc 114
    //   753: iconst_2
    //   754: new 18	java/lang/StringBuilder
    //   757: dup
    //   758: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   761: ldc 162
    //   763: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   766: aload 6
    //   768: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   771: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   774: invokestatic 167	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   777: goto -117 -> 660
    //   780: astore 5
    //   782: aload 5
    //   784: invokevirtual 160	java/lang/Exception:printStackTrace	()V
    //   787: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   790: ifeq -120 -> 670
    //   793: ldc 114
    //   795: iconst_2
    //   796: new 18	java/lang/StringBuilder
    //   799: dup
    //   800: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   803: ldc 162
    //   805: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   808: aload 5
    //   810: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   813: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   816: invokestatic 167	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   819: goto -149 -> 670
    //   822: astore 4
    //   824: iconst_1
    //   825: istore_2
    //   826: aconst_null
    //   827: astore 5
    //   829: goto -189 -> 640
    //   832: astore 4
    //   834: aconst_null
    //   835: astore 5
    //   837: iconst_1
    //   838: istore_2
    //   839: goto -199 -> 640
    //   842: astore 4
    //   844: iconst_1
    //   845: istore_2
    //   846: goto -206 -> 640
    //   849: astore 8
    //   851: aload 5
    //   853: astore 7
    //   855: iconst_1
    //   856: istore_2
    //   857: aload 4
    //   859: astore 5
    //   861: aload 8
    //   863: astore 4
    //   865: goto -225 -> 640
    //   868: astore 8
    //   870: aload 5
    //   872: astore 7
    //   874: iconst_0
    //   875: istore_2
    //   876: aload 4
    //   878: astore 5
    //   880: aload 8
    //   882: astore 4
    //   884: goto -244 -> 640
    //   887: astore 8
    //   889: aconst_null
    //   890: astore 6
    //   892: aload 7
    //   894: astore 5
    //   896: aconst_null
    //   897: astore 4
    //   899: aload 8
    //   901: astore 7
    //   903: goto -491 -> 412
    //   906: astore 8
    //   908: aload 7
    //   910: astore 5
    //   912: aconst_null
    //   913: astore 4
    //   915: aload 8
    //   917: astore 7
    //   919: goto -507 -> 412
    //   922: astore 8
    //   924: aload 5
    //   926: astore 4
    //   928: aload 7
    //   930: astore 5
    //   932: aload 8
    //   934: astore 7
    //   936: goto -524 -> 412
    //   939: aconst_null
    //   940: astore 4
    //   942: goto -814 -> 128
    //   945: aconst_null
    //   946: astore 5
    //   948: aconst_null
    //   949: astore 4
    //   951: goto -823 -> 128
    //   954: iconst_0
    //   955: istore_2
    //   956: aconst_null
    //   957: astore 4
    //   959: goto -831 -> 128
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	962	0	this	LoadDataJob
    //   0	962	1	paramString	String
    //   1	955	2	i	int
    //   81	151	3	j	int
    //   37	438	4	localObject1	Object
    //   588	29	4	localException1	Exception
    //   630	64	4	localObject2	Object
    //   822	1	4	localObject3	Object
    //   832	1	4	localObject4	Object
    //   842	16	4	localObject5	Object
    //   863	95	4	localObject6	Object
    //   57	141	5	localObject7	Object
    //   359	29	5	localException2	Exception
    //   407	93	5	localObject8	Object
    //   546	29	5	localException3	Exception
    //   638	28	5	localObject9	Object
    //   780	29	5	localException4	Exception
    //   827	120	5	localObject10	Object
    //   3	131	6	localObject11	Object
    //   275	29	6	localException5	Exception
    //   317	29	6	localException6	Exception
    //   404	51	6	localObject12	Object
    //   504	142	6	localException7	Exception
    //   696	29	6	localException8	Exception
    //   738	29	6	localException9	Exception
    //   890	1	6	localObject13	Object
    //   22	122	7	localFileInputStream	java.io.FileInputStream
    //   401	38	7	localException10	Exception
    //   635	300	7	localObject14	Object
    //   849	13	8	localObject15	Object
    //   868	13	8	localObject16	Object
    //   887	13	8	localException11	Exception
    //   906	10	8	localException12	Exception
    //   922	11	8	localException13	Exception
    // Exception table:
    //   from	to	target	type
    //   133	138	275	java/lang/Exception
    //   143	148	317	java/lang/Exception
    //   153	158	359	java/lang/Exception
    //   14	24	401	java/lang/Exception
    //   454	459	504	java/lang/Exception
    //   464	469	546	java/lang/Exception
    //   474	479	588	java/lang/Exception
    //   14	24	630	finally
    //   645	650	696	java/lang/Exception
    //   655	660	738	java/lang/Exception
    //   665	670	780	java/lang/Exception
    //   24	39	822	finally
    //   48	59	832	finally
    //   59	82	842	finally
    //   92	123	842	finally
    //   192	241	842	finally
    //   244	252	842	finally
    //   257	272	842	finally
    //   412	417	849	finally
    //   417	449	868	finally
    //   24	39	887	java/lang/Exception
    //   48	59	906	java/lang/Exception
    //   59	82	922	java/lang/Exception
    //   92	123	922	java/lang/Exception
    //   192	241	922	java/lang/Exception
    //   244	252	922	java/lang/Exception
    //   257	272	922	java/lang/Exception
  }
  
  private String a(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return null;
      try
      {
        paramString = jdField_b_of_type_JavaLangString + paramString.substring(paramString.lastIndexOf(File.separator) + 1, paramString.lastIndexOf('_')) + "_dwr";
        if (paramBoolean)
        {
          paramBoolean = FileUtils.a(paramString);
          if (paramBoolean) {
            return paramString;
          }
        }
        else
        {
          return paramString;
        }
      }
      catch (Exception paramString) {}
    }
    return null;
  }
  
  /* Error */
  private List<PathDrawer> a(String paramString, LoadDataJob.LoadDataJobListener paramLoadDataJobListener)
  {
    // Byte code:
    //   0: new 195	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 196	java/util/ArrayList:<init>	()V
    //   7: astore 14
    //   9: aload_1
    //   10: invokestatic 72	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   13: ifeq +6 -> 19
    //   16: aload 14
    //   18: areturn
    //   19: iconst_1
    //   20: istore 5
    //   22: iconst_1
    //   23: istore 7
    //   25: iconst_0
    //   26: istore 6
    //   28: new 198	java/util/HashMap
    //   31: dup
    //   32: invokespecial 199	java/util/HashMap:<init>	()V
    //   35: astore 15
    //   37: aload_0
    //   38: iconst_1
    //   39: putfield 47	com/tencent/mobileqq/activity/aio/doodle/LoadDataJob:d	I
    //   42: new 74	java/io/FileInputStream
    //   45: dup
    //   46: aload_1
    //   47: invokespecial 77	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   50: astore 8
    //   52: aload 8
    //   54: invokevirtual 81	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   57: lconst_0
    //   58: ldc2_w 82
    //   61: iconst_1
    //   62: invokevirtual 89	java/nio/channels/FileChannel:tryLock	(JJZ)Ljava/nio/channels/FileLock;
    //   65: astore 9
    //   67: aload 9
    //   69: ifnull +2321 -> 2390
    //   72: new 91	java/io/BufferedInputStream
    //   75: dup
    //   76: aload 8
    //   78: invokespecial 94	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   81: astore 10
    //   83: aload 9
    //   85: astore 11
    //   87: aload 10
    //   89: astore 12
    //   91: aload 8
    //   93: astore 13
    //   95: iload 7
    //   97: istore 5
    //   99: iconst_4
    //   100: newarray byte
    //   102: astore 16
    //   104: iconst_0
    //   105: istore_3
    //   106: aload 9
    //   108: astore 11
    //   110: aload 10
    //   112: astore 12
    //   114: aload 8
    //   116: astore 13
    //   118: iload 7
    //   120: istore 5
    //   122: aload 10
    //   124: aload 16
    //   126: invokevirtual 100	java/io/InputStream:read	([B)I
    //   129: iconst_4
    //   130: if_icmpne +2233 -> 2363
    //   133: aload 9
    //   135: astore 11
    //   137: aload 10
    //   139: astore 12
    //   141: aload 8
    //   143: astore 13
    //   145: iload 7
    //   147: istore 5
    //   149: aload 16
    //   151: iconst_0
    //   152: invokestatic 105	com/tencent/mobileqq/activity/aio/doodle/DoodleMsgTranslator:a	([BI)I
    //   155: istore 4
    //   157: iload 4
    //   159: ifle +10 -> 169
    //   162: iload 4
    //   164: ldc 106
    //   166: if_icmplt +319 -> 485
    //   169: aload 9
    //   171: astore 11
    //   173: aload 10
    //   175: astore 12
    //   177: aload 8
    //   179: astore 13
    //   181: iload 7
    //   183: istore 5
    //   185: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   188: ifeq +45 -> 233
    //   191: aload 9
    //   193: astore 11
    //   195: aload 10
    //   197: astore 12
    //   199: aload 8
    //   201: astore 13
    //   203: iload 7
    //   205: istore 5
    //   207: ldc 114
    //   209: iconst_2
    //   210: new 18	java/lang/StringBuilder
    //   213: dup
    //   214: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   217: ldc 201
    //   219: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: iload 4
    //   224: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   227: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   230: invokestatic 123	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   233: iconst_0
    //   234: istore 5
    //   236: aload 10
    //   238: astore_2
    //   239: iconst_0
    //   240: istore 6
    //   242: aload 14
    //   244: monitorenter
    //   245: aload_0
    //   246: aload_0
    //   247: getfield 47	com/tencent/mobileqq/activity/aio/doodle/LoadDataJob:d	I
    //   250: iconst_1
    //   251: isub
    //   252: putfield 47	com/tencent/mobileqq/activity/aio/doodle/LoadDataJob:d	I
    //   255: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   258: ifeq +66 -> 324
    //   261: ldc 114
    //   263: iconst_2
    //   264: new 18	java/lang/StringBuilder
    //   267: dup
    //   268: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   271: ldc 203
    //   273: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: aload_0
    //   277: getfield 47	com/tencent/mobileqq/activity/aio/doodle/LoadDataJob:d	I
    //   280: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   283: ldc 205
    //   285: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: aload 14
    //   290: invokeinterface 211 1 0
    //   295: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   298: ldc 213
    //   300: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: iload 6
    //   305: invokevirtual 216	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   308: ldc 218
    //   310: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: iload 5
    //   315: invokevirtual 216	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   318: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   321: invokestatic 167	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   324: aload_0
    //   325: getfield 47	com/tencent/mobileqq/activity/aio/doodle/LoadDataJob:d	I
    //   328: istore_3
    //   329: aload 14
    //   331: invokeinterface 211 1 0
    //   336: istore 4
    //   338: iload_3
    //   339: iload 4
    //   341: if_icmple +16 -> 357
    //   344: iload 6
    //   346: ifeq +11 -> 357
    //   349: aload 14
    //   351: ldc2_w 219
    //   354: invokevirtual 224	java/lang/Object:wait	(J)V
    //   357: aload 14
    //   359: invokeinterface 211 1 0
    //   364: ifle +16 -> 380
    //   367: aload 14
    //   369: new 226	com/tencent/mobileqq/activity/aio/doodle/LoadDataJob$SortComparator
    //   372: dup
    //   373: aload_0
    //   374: invokespecial 229	com/tencent/mobileqq/activity/aio/doodle/LoadDataJob$SortComparator:<init>	(Lcom/tencent/mobileqq/activity/aio/doodle/LoadDataJob;)V
    //   377: invokestatic 235	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   380: aload 14
    //   382: monitorexit
    //   383: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   386: ifeq +11 -> 397
    //   389: ldc 114
    //   391: iconst_2
    //   392: ldc 237
    //   394: invokestatic 167	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   397: aload 9
    //   399: ifnull +8 -> 407
    //   402: aload 9
    //   404: invokevirtual 128	java/nio/channels/FileLock:release	()V
    //   407: aload 8
    //   409: ifnull +8 -> 417
    //   412: aload 8
    //   414: invokevirtual 131	java/io/FileInputStream:close	()V
    //   417: aload_2
    //   418: ifnull +7 -> 425
    //   421: aload_2
    //   422: invokevirtual 132	java/io/InputStream:close	()V
    //   425: iload 5
    //   427: istore 7
    //   429: iload 6
    //   431: ifne +33 -> 464
    //   434: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   437: ifeq +11 -> 448
    //   440: ldc 114
    //   442: iconst_2
    //   443: ldc 239
    //   445: invokestatic 167	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   448: aload_1
    //   449: invokestatic 139	com/tencent/mobileqq/utils/FileUtils:e	(Ljava/lang/String;)Z
    //   452: pop
    //   453: aload 14
    //   455: invokeinterface 242 1 0
    //   460: iload 5
    //   462: istore 7
    //   464: iload 7
    //   466: ifeq +1721 -> 2187
    //   469: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   472: ifeq +11 -> 483
    //   475: ldc 114
    //   477: iconst_2
    //   478: ldc 244
    //   480: invokestatic 167	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   483: aconst_null
    //   484: areturn
    //   485: aload 9
    //   487: astore 11
    //   489: aload 10
    //   491: astore 12
    //   493: aload 8
    //   495: astore 13
    //   497: iload 7
    //   499: istore 5
    //   501: iload 4
    //   503: newarray byte
    //   505: astore 17
    //   507: aload 9
    //   509: astore 11
    //   511: aload 10
    //   513: astore 12
    //   515: aload 8
    //   517: astore 13
    //   519: iload 7
    //   521: istore 5
    //   523: aload 10
    //   525: aload 17
    //   527: iconst_0
    //   528: iload 4
    //   530: invokevirtual 142	java/io/InputStream:read	([BII)I
    //   533: iload 4
    //   535: if_icmpeq +70 -> 605
    //   538: aload 9
    //   540: astore 11
    //   542: aload 10
    //   544: astore 12
    //   546: aload 8
    //   548: astore 13
    //   550: iload 7
    //   552: istore 5
    //   554: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   557: ifeq +1844 -> 2401
    //   560: aload 9
    //   562: astore 11
    //   564: aload 10
    //   566: astore 12
    //   568: aload 8
    //   570: astore 13
    //   572: iload 7
    //   574: istore 5
    //   576: ldc 114
    //   578: iconst_2
    //   579: new 18	java/lang/StringBuilder
    //   582: dup
    //   583: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   586: ldc 246
    //   588: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   591: iload 4
    //   593: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   596: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   599: invokestatic 123	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   602: goto +1799 -> 2401
    //   605: aload 9
    //   607: astore 11
    //   609: aload 10
    //   611: astore 12
    //   613: aload 8
    //   615: astore 13
    //   617: iload 7
    //   619: istore 5
    //   621: new 248	com/tencent/mobileqq/activity/aio/doodle/LoadDataJob$UnmarshallJob
    //   624: dup
    //   625: aload_0
    //   626: iload_3
    //   627: aload 17
    //   629: new 250	com/tencent/mobileqq/activity/aio/doodle/LoadDataJob$2
    //   632: dup
    //   633: aload_0
    //   634: aload 15
    //   636: aload 14
    //   638: invokespecial 253	com/tencent/mobileqq/activity/aio/doodle/LoadDataJob$2:<init>	(Lcom/tencent/mobileqq/activity/aio/doodle/LoadDataJob;Ljava/util/Map;Ljava/util/List;)V
    //   641: invokespecial 256	com/tencent/mobileqq/activity/aio/doodle/LoadDataJob$UnmarshallJob:<init>	(Lcom/tencent/mobileqq/activity/aio/doodle/LoadDataJob;I[BLcom/tencent/mobileqq/activity/aio/doodle/LoadDataJob$UnmarshallJobListener;)V
    //   644: astore 17
    //   646: aload 9
    //   648: astore 11
    //   650: aload 10
    //   652: astore 12
    //   654: aload 8
    //   656: astore 13
    //   658: iload 7
    //   660: istore 5
    //   662: aload 15
    //   664: monitorenter
    //   665: aload 15
    //   667: invokeinterface 259 1 0
    //   672: istore 4
    //   674: iload 4
    //   676: iconst_3
    //   677: if_icmple +49 -> 726
    //   680: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   683: ifeq +35 -> 718
    //   686: ldc 114
    //   688: iconst_2
    //   689: new 18	java/lang/StringBuilder
    //   692: dup
    //   693: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   696: ldc_w 261
    //   699: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   702: aload 15
    //   704: invokeinterface 259 1 0
    //   709: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   712: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   715: invokestatic 167	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   718: aload 15
    //   720: ldc2_w 262
    //   723: invokevirtual 224	java/lang/Object:wait	(J)V
    //   726: aload 15
    //   728: monitorexit
    //   729: aload 9
    //   731: astore 11
    //   733: aload 10
    //   735: astore 12
    //   737: aload 8
    //   739: astore 13
    //   741: iload 7
    //   743: istore 5
    //   745: aload_2
    //   746: aload_0
    //   747: getfield 51	com/tencent/mobileqq/activity/aio/doodle/LoadDataJob:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   750: invokeinterface 266 2 0
    //   755: ifne +682 -> 1437
    //   758: aload 9
    //   760: astore 11
    //   762: aload 10
    //   764: astore 12
    //   766: aload 8
    //   768: astore 13
    //   770: iload 7
    //   772: istore 5
    //   774: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   777: ifeq +28 -> 805
    //   780: aload 9
    //   782: astore 11
    //   784: aload 10
    //   786: astore 12
    //   788: aload 8
    //   790: astore 13
    //   792: iload 7
    //   794: istore 5
    //   796: ldc 114
    //   798: iconst_2
    //   799: ldc_w 268
    //   802: invokestatic 167	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   805: iconst_0
    //   806: istore_3
    //   807: aload 9
    //   809: astore 11
    //   811: aload 10
    //   813: astore 12
    //   815: aload 8
    //   817: astore 13
    //   819: iload 7
    //   821: istore 5
    //   823: aload 15
    //   825: monitorenter
    //   826: aload 15
    //   828: invokeinterface 272 1 0
    //   833: invokeinterface 278 1 0
    //   838: astore_2
    //   839: aload_2
    //   840: invokeinterface 283 1 0
    //   845: ifeq +203 -> 1048
    //   848: aload_2
    //   849: invokeinterface 287 1 0
    //   854: checkcast 248	com/tencent/mobileqq/activity/aio/doodle/LoadDataJob$UnmarshallJob
    //   857: bipush 16
    //   859: invokestatic 293	com/tencent/mobileqq/app/ThreadManager:removeJobFromThreadPool	(Ljava/lang/Runnable;I)Z
    //   862: istore 5
    //   864: iload 5
    //   866: ifeq +1521 -> 2387
    //   869: iload_3
    //   870: iconst_1
    //   871: iadd
    //   872: istore_3
    //   873: goto -34 -> 839
    //   876: astore 11
    //   878: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   881: ifeq -155 -> 726
    //   884: ldc 114
    //   886: iconst_2
    //   887: new 18	java/lang/StringBuilder
    //   890: dup
    //   891: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   894: ldc_w 295
    //   897: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   900: aload 11
    //   902: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   905: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   908: invokestatic 167	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   911: goto -185 -> 726
    //   914: astore_2
    //   915: aload 15
    //   917: monitorexit
    //   918: aload 9
    //   920: astore 11
    //   922: aload 10
    //   924: astore 12
    //   926: aload 8
    //   928: astore 13
    //   930: iload 7
    //   932: istore 5
    //   934: aload_2
    //   935: athrow
    //   936: astore 11
    //   938: iconst_0
    //   939: istore 5
    //   941: aload 9
    //   943: astore_2
    //   944: aload 11
    //   946: astore 9
    //   948: iconst_0
    //   949: istore 6
    //   951: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   954: ifeq +33 -> 987
    //   957: ldc 114
    //   959: iconst_2
    //   960: new 18	java/lang/StringBuilder
    //   963: dup
    //   964: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   967: ldc_w 297
    //   970: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   973: aload 9
    //   975: invokevirtual 298	java/lang/OutOfMemoryError:toString	()Ljava/lang/String;
    //   978: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   981: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   984: invokestatic 167	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   987: aload_2
    //   988: ifnull +7 -> 995
    //   991: aload_2
    //   992: invokevirtual 128	java/nio/channels/FileLock:release	()V
    //   995: aload 8
    //   997: ifnull +8 -> 1005
    //   1000: aload 8
    //   1002: invokevirtual 131	java/io/FileInputStream:close	()V
    //   1005: aload 10
    //   1007: ifnull +8 -> 1015
    //   1010: aload 10
    //   1012: invokevirtual 132	java/io/InputStream:close	()V
    //   1015: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1018: ifeq +11 -> 1029
    //   1021: ldc 114
    //   1023: iconst_2
    //   1024: ldc 239
    //   1026: invokestatic 167	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1029: aload_1
    //   1030: invokestatic 139	com/tencent/mobileqq/utils/FileUtils:e	(Ljava/lang/String;)Z
    //   1033: pop
    //   1034: aload 14
    //   1036: invokeinterface 242 1 0
    //   1041: iload 5
    //   1043: istore 7
    //   1045: goto -581 -> 464
    //   1048: aload 15
    //   1050: invokeinterface 299 1 0
    //   1055: aload 15
    //   1057: monitorexit
    //   1058: aload 9
    //   1060: astore 11
    //   1062: aload 10
    //   1064: astore 12
    //   1066: aload 8
    //   1068: astore 13
    //   1070: iload 7
    //   1072: istore 5
    //   1074: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1077: ifeq +45 -> 1122
    //   1080: aload 9
    //   1082: astore 11
    //   1084: aload 10
    //   1086: astore 12
    //   1088: aload 8
    //   1090: astore 13
    //   1092: iload 7
    //   1094: istore 5
    //   1096: ldc 114
    //   1098: iconst_2
    //   1099: new 18	java/lang/StringBuilder
    //   1102: dup
    //   1103: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   1106: ldc_w 301
    //   1109: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1112: iload_3
    //   1113: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1116: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1119: invokestatic 167	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1122: iload_3
    //   1123: ifle +1252 -> 2375
    //   1126: aload 9
    //   1128: astore 11
    //   1130: aload 10
    //   1132: astore 12
    //   1134: aload 8
    //   1136: astore 13
    //   1138: iload 7
    //   1140: istore 5
    //   1142: aload 14
    //   1144: monitorenter
    //   1145: aload_0
    //   1146: aload_0
    //   1147: getfield 47	com/tencent/mobileqq/activity/aio/doodle/LoadDataJob:d	I
    //   1150: iload_3
    //   1151: isub
    //   1152: putfield 47	com/tencent/mobileqq/activity/aio/doodle/LoadDataJob:d	I
    //   1155: aload 14
    //   1157: monitorexit
    //   1158: aload 9
    //   1160: astore 11
    //   1162: aload 10
    //   1164: astore 12
    //   1166: aload 8
    //   1168: astore 13
    //   1170: iload 7
    //   1172: istore 5
    //   1174: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1177: ifeq +1198 -> 2375
    //   1180: aload 9
    //   1182: astore 11
    //   1184: aload 10
    //   1186: astore 12
    //   1188: aload 8
    //   1190: astore 13
    //   1192: iload 7
    //   1194: istore 5
    //   1196: ldc 114
    //   1198: iconst_2
    //   1199: new 18	java/lang/StringBuilder
    //   1202: dup
    //   1203: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   1206: ldc_w 303
    //   1209: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1212: aload_0
    //   1213: getfield 47	com/tencent/mobileqq/activity/aio/doodle/LoadDataJob:d	I
    //   1216: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1219: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1222: invokestatic 167	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1225: iconst_1
    //   1226: istore 5
    //   1228: aload 10
    //   1230: astore_2
    //   1231: iconst_1
    //   1232: istore 6
    //   1234: goto -992 -> 242
    //   1237: astore_2
    //   1238: aload 15
    //   1240: monitorexit
    //   1241: aload 9
    //   1243: astore 11
    //   1245: aload 10
    //   1247: astore 12
    //   1249: aload 8
    //   1251: astore 13
    //   1253: iload 7
    //   1255: istore 5
    //   1257: aload_2
    //   1258: athrow
    //   1259: astore 11
    //   1261: iconst_1
    //   1262: istore 5
    //   1264: aload 9
    //   1266: astore_2
    //   1267: aload 11
    //   1269: astore 9
    //   1271: goto -323 -> 948
    //   1274: astore_2
    //   1275: aload 14
    //   1277: monitorexit
    //   1278: aload 9
    //   1280: astore 11
    //   1282: aload 10
    //   1284: astore 12
    //   1286: aload 8
    //   1288: astore 13
    //   1290: iload 7
    //   1292: istore 5
    //   1294: aload_2
    //   1295: athrow
    //   1296: astore_2
    //   1297: iconst_1
    //   1298: istore 6
    //   1300: iconst_1
    //   1301: istore 5
    //   1303: aload_2
    //   1304: invokevirtual 160	java/lang/Exception:printStackTrace	()V
    //   1307: iconst_0
    //   1308: istore 7
    //   1310: aload 9
    //   1312: astore 11
    //   1314: aload 10
    //   1316: astore 12
    //   1318: aload 8
    //   1320: astore 13
    //   1322: iload 7
    //   1324: istore 5
    //   1326: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1329: ifeq +45 -> 1374
    //   1332: aload 9
    //   1334: astore 11
    //   1336: aload 10
    //   1338: astore 12
    //   1340: aload 8
    //   1342: astore 13
    //   1344: iload 7
    //   1346: istore 5
    //   1348: ldc 114
    //   1350: iconst_2
    //   1351: new 18	java/lang/StringBuilder
    //   1354: dup
    //   1355: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   1358: ldc_w 305
    //   1361: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1364: aload_2
    //   1365: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1368: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1371: invokestatic 167	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1374: aload 9
    //   1376: ifnull +8 -> 1384
    //   1379: aload 9
    //   1381: invokevirtual 128	java/nio/channels/FileLock:release	()V
    //   1384: aload 8
    //   1386: ifnull +8 -> 1394
    //   1389: aload 8
    //   1391: invokevirtual 131	java/io/FileInputStream:close	()V
    //   1394: aload 10
    //   1396: ifnull +8 -> 1404
    //   1399: aload 10
    //   1401: invokevirtual 132	java/io/InputStream:close	()V
    //   1404: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1407: ifeq +11 -> 1418
    //   1410: ldc 114
    //   1412: iconst_2
    //   1413: ldc 239
    //   1415: invokestatic 167	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1418: aload_1
    //   1419: invokestatic 139	com/tencent/mobileqq/utils/FileUtils:e	(Ljava/lang/String;)Z
    //   1422: pop
    //   1423: aload 14
    //   1425: invokeinterface 242 1 0
    //   1430: iload 6
    //   1432: istore 7
    //   1434: goto -970 -> 464
    //   1437: aload 9
    //   1439: astore 11
    //   1441: aload 10
    //   1443: astore 12
    //   1445: aload 8
    //   1447: astore 13
    //   1449: iload 7
    //   1451: istore 5
    //   1453: aload 15
    //   1455: monitorenter
    //   1456: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1459: ifeq +29 -> 1488
    //   1462: ldc 114
    //   1464: iconst_2
    //   1465: new 18	java/lang/StringBuilder
    //   1468: dup
    //   1469: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   1472: ldc_w 307
    //   1475: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1478: iload_3
    //   1479: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1482: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1485: invokestatic 167	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1488: aload 15
    //   1490: iload_3
    //   1491: invokestatic 313	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1494: aload 17
    //   1496: invokeinterface 317 3 0
    //   1501: pop
    //   1502: aload 15
    //   1504: monitorexit
    //   1505: aload 9
    //   1507: astore 11
    //   1509: aload 10
    //   1511: astore 12
    //   1513: aload 8
    //   1515: astore 13
    //   1517: iload 7
    //   1519: istore 5
    //   1521: aload 14
    //   1523: monitorenter
    //   1524: aload_0
    //   1525: aload_0
    //   1526: getfield 47	com/tencent/mobileqq/activity/aio/doodle/LoadDataJob:d	I
    //   1529: iconst_1
    //   1530: iadd
    //   1531: putfield 47	com/tencent/mobileqq/activity/aio/doodle/LoadDataJob:d	I
    //   1534: aload 14
    //   1536: monitorexit
    //   1537: aload 9
    //   1539: astore 11
    //   1541: aload 10
    //   1543: astore 12
    //   1545: aload 8
    //   1547: astore 13
    //   1549: iload 7
    //   1551: istore 5
    //   1553: aload 17
    //   1555: bipush 16
    //   1557: aconst_null
    //   1558: iconst_1
    //   1559: invokestatic 321	com/tencent/mobileqq/app/ThreadManager:excute	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   1562: iload_3
    //   1563: iconst_1
    //   1564: iadd
    //   1565: istore_3
    //   1566: goto -1460 -> 106
    //   1569: astore_2
    //   1570: aload 15
    //   1572: monitorexit
    //   1573: aload 9
    //   1575: astore 11
    //   1577: aload 10
    //   1579: astore 12
    //   1581: aload 8
    //   1583: astore 13
    //   1585: iload 7
    //   1587: istore 5
    //   1589: aload_2
    //   1590: athrow
    //   1591: astore_2
    //   1592: iconst_1
    //   1593: istore 5
    //   1595: goto -292 -> 1303
    //   1598: astore_2
    //   1599: aload 14
    //   1601: monitorexit
    //   1602: aload 9
    //   1604: astore 11
    //   1606: aload 10
    //   1608: astore 12
    //   1610: aload 8
    //   1612: astore 13
    //   1614: iload 7
    //   1616: istore 5
    //   1618: aload_2
    //   1619: athrow
    //   1620: astore_2
    //   1621: aload 13
    //   1623: astore 8
    //   1625: aload 12
    //   1627: astore 10
    //   1629: aload 11
    //   1631: astore 9
    //   1633: aload 9
    //   1635: ifnull +8 -> 1643
    //   1638: aload 9
    //   1640: invokevirtual 128	java/nio/channels/FileLock:release	()V
    //   1643: aload 8
    //   1645: ifnull +8 -> 1653
    //   1648: aload 8
    //   1650: invokevirtual 131	java/io/FileInputStream:close	()V
    //   1653: aload 10
    //   1655: ifnull +8 -> 1663
    //   1658: aload 10
    //   1660: invokevirtual 132	java/io/InputStream:close	()V
    //   1663: iload 5
    //   1665: ifne +29 -> 1694
    //   1668: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1671: ifeq +11 -> 1682
    //   1674: ldc 114
    //   1676: iconst_2
    //   1677: ldc 239
    //   1679: invokestatic 167	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1682: aload_1
    //   1683: invokestatic 139	com/tencent/mobileqq/utils/FileUtils:e	(Ljava/lang/String;)Z
    //   1686: pop
    //   1687: aload 14
    //   1689: invokeinterface 242 1 0
    //   1694: aload_2
    //   1695: athrow
    //   1696: astore 10
    //   1698: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1701: ifeq -1344 -> 357
    //   1704: ldc 114
    //   1706: iconst_2
    //   1707: new 18	java/lang/StringBuilder
    //   1710: dup
    //   1711: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   1714: ldc_w 323
    //   1717: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1720: aload 10
    //   1722: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1725: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1728: invokestatic 167	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1731: goto -1374 -> 357
    //   1734: astore 10
    //   1736: aload 14
    //   1738: monitorexit
    //   1739: aload 10
    //   1741: athrow
    //   1742: astore 11
    //   1744: aload_2
    //   1745: astore 10
    //   1747: aload 9
    //   1749: astore_2
    //   1750: aload 11
    //   1752: astore 9
    //   1754: goto -806 -> 948
    //   1757: astore 9
    //   1759: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1762: ifeq -1355 -> 407
    //   1765: ldc 114
    //   1767: iconst_2
    //   1768: new 18	java/lang/StringBuilder
    //   1771: dup
    //   1772: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   1775: ldc 162
    //   1777: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1780: aload 9
    //   1782: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1785: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1788: invokestatic 167	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1791: goto -1384 -> 407
    //   1794: astore 8
    //   1796: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1799: ifeq -1382 -> 417
    //   1802: ldc 114
    //   1804: iconst_2
    //   1805: new 18	java/lang/StringBuilder
    //   1808: dup
    //   1809: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   1812: ldc 162
    //   1814: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1817: aload 8
    //   1819: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1822: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1825: invokestatic 167	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1828: goto -1411 -> 417
    //   1831: astore_2
    //   1832: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1835: ifeq -1410 -> 425
    //   1838: ldc 114
    //   1840: iconst_2
    //   1841: new 18	java/lang/StringBuilder
    //   1844: dup
    //   1845: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   1848: ldc 162
    //   1850: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1853: aload_2
    //   1854: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1857: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1860: invokestatic 167	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1863: goto -1438 -> 425
    //   1866: astore_2
    //   1867: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1870: ifeq -875 -> 995
    //   1873: ldc 114
    //   1875: iconst_2
    //   1876: new 18	java/lang/StringBuilder
    //   1879: dup
    //   1880: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   1883: ldc 162
    //   1885: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1888: aload_2
    //   1889: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1892: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1895: invokestatic 167	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1898: goto -903 -> 995
    //   1901: astore_2
    //   1902: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1905: ifeq -900 -> 1005
    //   1908: ldc 114
    //   1910: iconst_2
    //   1911: new 18	java/lang/StringBuilder
    //   1914: dup
    //   1915: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   1918: ldc 162
    //   1920: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1923: aload_2
    //   1924: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1927: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1930: invokestatic 167	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1933: goto -928 -> 1005
    //   1936: astore_2
    //   1937: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1940: ifeq -925 -> 1015
    //   1943: ldc 114
    //   1945: iconst_2
    //   1946: new 18	java/lang/StringBuilder
    //   1949: dup
    //   1950: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   1953: ldc 162
    //   1955: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1958: aload_2
    //   1959: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1962: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1965: invokestatic 167	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1968: goto -953 -> 1015
    //   1971: astore_2
    //   1972: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1975: ifeq -591 -> 1384
    //   1978: ldc 114
    //   1980: iconst_2
    //   1981: new 18	java/lang/StringBuilder
    //   1984: dup
    //   1985: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   1988: ldc 162
    //   1990: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1993: aload_2
    //   1994: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1997: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2000: invokestatic 167	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2003: goto -619 -> 1384
    //   2006: astore_2
    //   2007: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2010: ifeq -616 -> 1394
    //   2013: ldc 114
    //   2015: iconst_2
    //   2016: new 18	java/lang/StringBuilder
    //   2019: dup
    //   2020: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   2023: ldc 162
    //   2025: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2028: aload_2
    //   2029: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2032: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2035: invokestatic 167	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2038: goto -644 -> 1394
    //   2041: astore_2
    //   2042: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2045: ifeq -641 -> 1404
    //   2048: ldc 114
    //   2050: iconst_2
    //   2051: new 18	java/lang/StringBuilder
    //   2054: dup
    //   2055: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   2058: ldc 162
    //   2060: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2063: aload_2
    //   2064: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2067: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2070: invokestatic 167	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2073: goto -669 -> 1404
    //   2076: astore 9
    //   2078: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2081: ifeq -438 -> 1643
    //   2084: ldc 114
    //   2086: iconst_2
    //   2087: new 18	java/lang/StringBuilder
    //   2090: dup
    //   2091: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   2094: ldc 162
    //   2096: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2099: aload 9
    //   2101: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2104: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2107: invokestatic 167	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2110: goto -467 -> 1643
    //   2113: astore 8
    //   2115: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2118: ifeq -465 -> 1653
    //   2121: ldc 114
    //   2123: iconst_2
    //   2124: new 18	java/lang/StringBuilder
    //   2127: dup
    //   2128: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   2131: ldc 162
    //   2133: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2136: aload 8
    //   2138: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2141: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2144: invokestatic 167	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2147: goto -494 -> 1653
    //   2150: astore 8
    //   2152: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2155: ifeq -492 -> 1663
    //   2158: ldc 114
    //   2160: iconst_2
    //   2161: new 18	java/lang/StringBuilder
    //   2164: dup
    //   2165: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   2168: ldc 162
    //   2170: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2173: aload 8
    //   2175: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2178: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2181: invokestatic 167	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2184: goto -521 -> 1663
    //   2187: aload 14
    //   2189: areturn
    //   2190: astore_2
    //   2191: aconst_null
    //   2192: astore 9
    //   2194: aconst_null
    //   2195: astore 8
    //   2197: aconst_null
    //   2198: astore 10
    //   2200: goto -567 -> 1633
    //   2203: astore_2
    //   2204: aconst_null
    //   2205: astore 9
    //   2207: aconst_null
    //   2208: astore 10
    //   2210: goto -577 -> 1633
    //   2213: astore_2
    //   2214: aconst_null
    //   2215: astore 10
    //   2217: goto -584 -> 1633
    //   2220: astore 11
    //   2222: iload 6
    //   2224: istore 5
    //   2226: aload_2
    //   2227: astore 10
    //   2229: aload 11
    //   2231: astore_2
    //   2232: goto -599 -> 1633
    //   2235: astore 11
    //   2237: aload_2
    //   2238: astore 9
    //   2240: aload 11
    //   2242: astore_2
    //   2243: iload 6
    //   2245: istore 5
    //   2247: goto -614 -> 1633
    //   2250: astore_2
    //   2251: goto -618 -> 1633
    //   2254: astore_2
    //   2255: aconst_null
    //   2256: astore 9
    //   2258: aconst_null
    //   2259: astore 8
    //   2261: aconst_null
    //   2262: astore 10
    //   2264: iconst_1
    //   2265: istore 5
    //   2267: goto -964 -> 1303
    //   2270: astore_2
    //   2271: iconst_1
    //   2272: istore 5
    //   2274: aconst_null
    //   2275: astore 9
    //   2277: aconst_null
    //   2278: astore 10
    //   2280: goto -977 -> 1303
    //   2283: astore_2
    //   2284: iconst_1
    //   2285: istore 5
    //   2287: aconst_null
    //   2288: astore 10
    //   2290: goto -987 -> 1303
    //   2293: astore 11
    //   2295: iload 5
    //   2297: istore 7
    //   2299: iload 6
    //   2301: istore 5
    //   2303: aload_2
    //   2304: astore 10
    //   2306: aload 11
    //   2308: astore_2
    //   2309: iload 7
    //   2311: istore 6
    //   2313: goto -1010 -> 1303
    //   2316: astore 9
    //   2318: aconst_null
    //   2319: astore_2
    //   2320: aconst_null
    //   2321: astore 8
    //   2323: aconst_null
    //   2324: astore 10
    //   2326: iconst_0
    //   2327: istore 5
    //   2329: goto -1381 -> 948
    //   2332: astore 9
    //   2334: iconst_0
    //   2335: istore 5
    //   2337: aconst_null
    //   2338: astore_2
    //   2339: aconst_null
    //   2340: astore 10
    //   2342: goto -1394 -> 948
    //   2345: astore 11
    //   2347: iconst_0
    //   2348: istore 5
    //   2350: aload 9
    //   2352: astore_2
    //   2353: aconst_null
    //   2354: astore 10
    //   2356: aload 11
    //   2358: astore 9
    //   2360: goto -1412 -> 948
    //   2363: iconst_0
    //   2364: istore 5
    //   2366: aload 10
    //   2368: astore_2
    //   2369: iconst_1
    //   2370: istore 6
    //   2372: goto -2130 -> 242
    //   2375: iconst_1
    //   2376: istore 5
    //   2378: aload 10
    //   2380: astore_2
    //   2381: iconst_1
    //   2382: istore 6
    //   2384: goto -2142 -> 242
    //   2387: goto -1514 -> 873
    //   2390: iconst_0
    //   2391: istore 5
    //   2393: iconst_1
    //   2394: istore 6
    //   2396: aconst_null
    //   2397: astore_2
    //   2398: goto -2156 -> 242
    //   2401: iconst_0
    //   2402: istore 5
    //   2404: aload 10
    //   2406: astore_2
    //   2407: iconst_0
    //   2408: istore 6
    //   2410: goto -2168 -> 242
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2413	0	this	LoadDataJob
    //   0	2413	1	paramString	String
    //   0	2413	2	paramLoadDataJobListener	LoadDataJob.LoadDataJobListener
    //   105	1461	3	i	int
    //   155	523	4	j	int
    //   20	2383	5	bool1	boolean
    //   26	2383	6	bool2	boolean
    //   23	2287	7	bool3	boolean
    //   50	1599	8	localObject1	Object
    //   1794	24	8	localException1	Exception
    //   2113	24	8	localException2	Exception
    //   2150	24	8	localException3	Exception
    //   2195	127	8	localObject2	Object
    //   65	1688	9	localObject3	Object
    //   1757	24	9	localException4	Exception
    //   2076	24	9	localException5	Exception
    //   2192	84	9	localLoadDataJobListener1	LoadDataJob.LoadDataJobListener
    //   2316	1	9	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   2332	19	9	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   2358	1	9	localObject4	Object
    //   81	1578	10	localObject5	Object
    //   1696	25	10	localException6	Exception
    //   1734	6	10	localObject6	Object
    //   1745	660	10	localLoadDataJobListener2	LoadDataJob.LoadDataJobListener
    //   85	725	11	localObject7	Object
    //   876	25	11	localException7	Exception
    //   920	1	11	localObject8	Object
    //   936	9	11	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   1060	184	11	localObject9	Object
    //   1259	9	11	localOutOfMemoryError4	java.lang.OutOfMemoryError
    //   1280	350	11	localObject10	Object
    //   1742	9	11	localOutOfMemoryError5	java.lang.OutOfMemoryError
    //   2220	10	11	localObject11	Object
    //   2235	6	11	localObject12	Object
    //   2293	14	11	localException8	Exception
    //   2345	12	11	localOutOfMemoryError6	java.lang.OutOfMemoryError
    //   89	1537	12	localObject13	Object
    //   93	1529	13	localObject14	Object
    //   7	2181	14	localArrayList	ArrayList
    //   35	1536	15	localHashMap	HashMap
    //   102	48	16	arrayOfByte	byte[]
    //   505	1049	17	localObject15	Object
    // Exception table:
    //   from	to	target	type
    //   680	718	876	java/lang/Exception
    //   718	726	876	java/lang/Exception
    //   665	674	914	finally
    //   680	718	914	finally
    //   718	726	914	finally
    //   726	729	914	finally
    //   878	911	914	finally
    //   915	918	914	finally
    //   99	104	936	java/lang/OutOfMemoryError
    //   122	133	936	java/lang/OutOfMemoryError
    //   149	157	936	java/lang/OutOfMemoryError
    //   185	191	936	java/lang/OutOfMemoryError
    //   207	233	936	java/lang/OutOfMemoryError
    //   501	507	936	java/lang/OutOfMemoryError
    //   523	538	936	java/lang/OutOfMemoryError
    //   554	560	936	java/lang/OutOfMemoryError
    //   576	602	936	java/lang/OutOfMemoryError
    //   621	646	936	java/lang/OutOfMemoryError
    //   662	665	936	java/lang/OutOfMemoryError
    //   745	758	936	java/lang/OutOfMemoryError
    //   774	780	936	java/lang/OutOfMemoryError
    //   796	805	936	java/lang/OutOfMemoryError
    //   934	936	936	java/lang/OutOfMemoryError
    //   1453	1456	936	java/lang/OutOfMemoryError
    //   1521	1524	936	java/lang/OutOfMemoryError
    //   1553	1562	936	java/lang/OutOfMemoryError
    //   1589	1591	936	java/lang/OutOfMemoryError
    //   1618	1620	936	java/lang/OutOfMemoryError
    //   826	839	1237	finally
    //   839	864	1237	finally
    //   1048	1058	1237	finally
    //   1238	1241	1237	finally
    //   823	826	1259	java/lang/OutOfMemoryError
    //   1074	1080	1259	java/lang/OutOfMemoryError
    //   1096	1122	1259	java/lang/OutOfMemoryError
    //   1142	1145	1259	java/lang/OutOfMemoryError
    //   1174	1180	1259	java/lang/OutOfMemoryError
    //   1196	1225	1259	java/lang/OutOfMemoryError
    //   1257	1259	1259	java/lang/OutOfMemoryError
    //   1294	1296	1259	java/lang/OutOfMemoryError
    //   1145	1158	1274	finally
    //   1275	1278	1274	finally
    //   823	826	1296	java/lang/Exception
    //   1074	1080	1296	java/lang/Exception
    //   1096	1122	1296	java/lang/Exception
    //   1142	1145	1296	java/lang/Exception
    //   1174	1180	1296	java/lang/Exception
    //   1196	1225	1296	java/lang/Exception
    //   1257	1259	1296	java/lang/Exception
    //   1294	1296	1296	java/lang/Exception
    //   1456	1488	1569	finally
    //   1488	1505	1569	finally
    //   1570	1573	1569	finally
    //   99	104	1591	java/lang/Exception
    //   122	133	1591	java/lang/Exception
    //   149	157	1591	java/lang/Exception
    //   185	191	1591	java/lang/Exception
    //   207	233	1591	java/lang/Exception
    //   501	507	1591	java/lang/Exception
    //   523	538	1591	java/lang/Exception
    //   554	560	1591	java/lang/Exception
    //   576	602	1591	java/lang/Exception
    //   621	646	1591	java/lang/Exception
    //   662	665	1591	java/lang/Exception
    //   745	758	1591	java/lang/Exception
    //   774	780	1591	java/lang/Exception
    //   796	805	1591	java/lang/Exception
    //   934	936	1591	java/lang/Exception
    //   1453	1456	1591	java/lang/Exception
    //   1521	1524	1591	java/lang/Exception
    //   1553	1562	1591	java/lang/Exception
    //   1589	1591	1591	java/lang/Exception
    //   1618	1620	1591	java/lang/Exception
    //   1524	1537	1598	finally
    //   1599	1602	1598	finally
    //   99	104	1620	finally
    //   122	133	1620	finally
    //   149	157	1620	finally
    //   185	191	1620	finally
    //   207	233	1620	finally
    //   501	507	1620	finally
    //   523	538	1620	finally
    //   554	560	1620	finally
    //   576	602	1620	finally
    //   621	646	1620	finally
    //   662	665	1620	finally
    //   745	758	1620	finally
    //   774	780	1620	finally
    //   796	805	1620	finally
    //   823	826	1620	finally
    //   934	936	1620	finally
    //   1074	1080	1620	finally
    //   1096	1122	1620	finally
    //   1142	1145	1620	finally
    //   1174	1180	1620	finally
    //   1196	1225	1620	finally
    //   1257	1259	1620	finally
    //   1294	1296	1620	finally
    //   1326	1332	1620	finally
    //   1348	1374	1620	finally
    //   1453	1456	1620	finally
    //   1521	1524	1620	finally
    //   1553	1562	1620	finally
    //   1589	1591	1620	finally
    //   1618	1620	1620	finally
    //   349	357	1696	java/lang/Exception
    //   245	324	1734	finally
    //   324	338	1734	finally
    //   349	357	1734	finally
    //   357	380	1734	finally
    //   380	383	1734	finally
    //   1698	1731	1734	finally
    //   1736	1739	1734	finally
    //   242	245	1742	java/lang/OutOfMemoryError
    //   383	397	1742	java/lang/OutOfMemoryError
    //   1739	1742	1742	java/lang/OutOfMemoryError
    //   402	407	1757	java/lang/Exception
    //   412	417	1794	java/lang/Exception
    //   421	425	1831	java/lang/Exception
    //   991	995	1866	java/lang/Exception
    //   1000	1005	1901	java/lang/Exception
    //   1010	1015	1936	java/lang/Exception
    //   1379	1384	1971	java/lang/Exception
    //   1389	1394	2006	java/lang/Exception
    //   1399	1404	2041	java/lang/Exception
    //   1638	1643	2076	java/lang/Exception
    //   1648	1653	2113	java/lang/Exception
    //   1658	1663	2150	java/lang/Exception
    //   37	52	2190	finally
    //   52	67	2203	finally
    //   72	83	2213	finally
    //   242	245	2220	finally
    //   383	397	2220	finally
    //   1739	1742	2220	finally
    //   951	987	2235	finally
    //   1303	1307	2250	finally
    //   37	52	2254	java/lang/Exception
    //   52	67	2270	java/lang/Exception
    //   72	83	2283	java/lang/Exception
    //   242	245	2293	java/lang/Exception
    //   383	397	2293	java/lang/Exception
    //   1739	1742	2293	java/lang/Exception
    //   37	52	2316	java/lang/OutOfMemoryError
    //   52	67	2332	java/lang/OutOfMemoryError
    //   72	83	2345	java/lang/OutOfMemoryError
  }
  
  private List<PathDrawer> a(List<PathData> paramList, Rect paramRect)
  {
    Object localObject1 = paramList.iterator();
    long l = 0L;
    Object localObject2;
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (PathData)((Iterator)localObject1).next();
      if (((PathData)localObject2).b() == null) {
        break label251;
      }
      l = ((PathData)localObject2).b().a() + l;
    }
    label251:
    for (;;)
    {
      break;
      int i;
      int j;
      if (l <= 3000L)
      {
        i = 10;
        j = 30;
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("LoadDataJob", 2, "setPathDatas params: totaltime:" + l + "  segmentLen:" + i + " timeInterval:" + j);
        }
        localObject1 = new ArrayList();
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          localObject2 = new PathDrawer((PathData)paramList.next(), paramRect.width(), paramRect.height(), this.jdField_b_of_type_Int, this.c, i, j, 1.0F);
          if (localObject2 != null) {
            ((ArrayList)localObject1).add(localObject2);
          }
        }
        if (l <= 20000L)
        {
          i = 20;
          j = 37;
        }
        else
        {
          i = 50;
          j = 45;
        }
      }
      Collections.sort((List)localObject1, new LoadDataJob.SortComparator(this));
      return localObject1;
    }
  }
  
  private Map<Integer, Integer> a(List<PathDrawer> paramList)
  {
    HashMap localHashMap = new HashMap();
    if (paramList == null) {
      return localHashMap;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      int i = ((PathDrawer)paramList.next()).a();
      if (i > 0) {
        if (!DoodleResHelper.a().b(0, i)) {
          localHashMap.put(Integer.valueOf(i), Integer.valueOf(4));
        } else {
          localHashMap.put(Integer.valueOf(i), Integer.valueOf(0));
        }
      }
    }
    return localHashMap;
  }
  
  private String b(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return null;
      try
      {
        paramString = jdField_b_of_type_JavaLangString + paramString.substring(paramString.lastIndexOf(File.separator) + 1, paramString.lastIndexOf('_')) + "_prm";
        if (paramBoolean)
        {
          paramBoolean = FileUtils.a(paramString);
          if (paramBoolean) {
            return paramString;
          }
        }
        else
        {
          return paramString;
        }
      }
      catch (Exception paramString) {}
    }
    return null;
  }
  
  public MyParcel.DataElement a(MyParcelable paramMyParcelable)
  {
    MyParcel localMyParcel = new MyParcel(102400);
    paramMyParcelable.a(localMyParcel, 0);
    return localMyParcel.a();
  }
  
  public MyParcel a(byte[] paramArrayOfByte)
  {
    MyParcel localMyParcel = new MyParcel(0);
    localMyParcel.a(paramArrayOfByte, 0, paramArrayOfByte.length);
    return localMyParcel;
  }
  
  /* Error */
  public void a(DoodleParam paramDoodleParam, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore_3
    //   5: aconst_null
    //   6: astore 4
    //   8: aconst_null
    //   9: astore 9
    //   11: aconst_null
    //   12: astore 8
    //   14: aconst_null
    //   15: astore 7
    //   17: aload_1
    //   18: ifnull +10 -> 28
    //   21: aload_2
    //   22: invokestatic 72	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   25: ifeq +4 -> 29
    //   28: return
    //   29: aload_2
    //   30: invokestatic 190	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;)Z
    //   33: ifne -5 -> 28
    //   36: new 18	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   43: aload_2
    //   44: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: ldc_w 407
    //   50: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: astore 10
    //   58: new 409	java/io/FileOutputStream
    //   61: dup
    //   62: aload 10
    //   64: invokespecial 410	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   67: astore 5
    //   69: aload 4
    //   71: astore_3
    //   72: aload 5
    //   74: astore 4
    //   76: aload 9
    //   78: astore 6
    //   80: aload 8
    //   82: astore 7
    //   84: aload 5
    //   86: invokevirtual 411	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   89: invokevirtual 414	java/nio/channels/FileChannel:tryLock	()Ljava/nio/channels/FileLock;
    //   92: astore 8
    //   94: aload 8
    //   96: ifnull +105 -> 201
    //   99: aload 8
    //   101: astore_3
    //   102: aload 5
    //   104: astore 4
    //   106: aload 8
    //   108: astore 6
    //   110: aload 8
    //   112: astore 7
    //   114: aload 5
    //   116: invokevirtual 411	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   119: lconst_0
    //   120: invokevirtual 418	java/nio/channels/FileChannel:position	(J)Ljava/nio/channels/FileChannel;
    //   123: pop
    //   124: aload 8
    //   126: astore_3
    //   127: aload 5
    //   129: astore 4
    //   131: aload 8
    //   133: astore 6
    //   135: aload 8
    //   137: astore 7
    //   139: aload_0
    //   140: aload_1
    //   141: invokevirtual 420	com/tencent/mobileqq/activity/aio/doodle/LoadDataJob:a	(Lcom/tencent/mobileqq/activity/aio/doodle/MyParcelable;)Lcom/tencent/mobileqq/activity/aio/doodle/MyParcel$DataElement;
    //   144: astore_1
    //   145: aload 8
    //   147: astore_3
    //   148: aload 5
    //   150: astore 4
    //   152: aload 8
    //   154: astore 6
    //   156: aload 8
    //   158: astore 7
    //   160: aload 5
    //   162: aload_1
    //   163: getfield 423	com/tencent/mobileqq/activity/aio/doodle/MyParcel$DataElement:jdField_a_of_type_Int	I
    //   166: invokestatic 426	com/tencent/mobileqq/activity/aio/doodle/DoodleMsgTranslator:a	(I)[B
    //   169: invokevirtual 430	java/io/FileOutputStream:write	([B)V
    //   172: aload 8
    //   174: astore_3
    //   175: aload 5
    //   177: astore 4
    //   179: aload 8
    //   181: astore 6
    //   183: aload 8
    //   185: astore 7
    //   187: aload 5
    //   189: aload_1
    //   190: getfield 433	com/tencent/mobileqq/activity/aio/doodle/MyParcel$DataElement:jdField_a_of_type_ArrayOfByte	[B
    //   193: iconst_0
    //   194: aload_1
    //   195: getfield 423	com/tencent/mobileqq/activity/aio/doodle/MyParcel$DataElement:jdField_a_of_type_Int	I
    //   198: invokevirtual 435	java/io/FileOutputStream:write	([BII)V
    //   201: aload 8
    //   203: ifnull +8 -> 211
    //   206: aload 8
    //   208: invokevirtual 128	java/nio/channels/FileLock:release	()V
    //   211: aload 5
    //   213: ifnull +8 -> 221
    //   216: aload 5
    //   218: invokevirtual 436	java/io/FileOutputStream:close	()V
    //   221: aload 10
    //   223: aload_2
    //   224: invokestatic 439	com/tencent/mobileqq/utils/FileUtils:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   227: pop
    //   228: return
    //   229: astore_1
    //   230: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   233: ifeq -22 -> 211
    //   236: ldc 114
    //   238: iconst_2
    //   239: new 18	java/lang/StringBuilder
    //   242: dup
    //   243: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   246: ldc_w 441
    //   249: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: aload_1
    //   253: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   256: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   259: invokestatic 123	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   262: goto -51 -> 211
    //   265: astore_1
    //   266: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   269: ifeq -48 -> 221
    //   272: ldc 114
    //   274: iconst_2
    //   275: new 18	java/lang/StringBuilder
    //   278: dup
    //   279: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   282: ldc_w 441
    //   285: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: aload_1
    //   289: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   292: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   295: invokestatic 123	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   298: goto -77 -> 221
    //   301: astore_1
    //   302: aconst_null
    //   303: astore 5
    //   305: aload 7
    //   307: astore_3
    //   308: aload 5
    //   310: astore 4
    //   312: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   315: ifeq +36 -> 351
    //   318: aload 7
    //   320: astore_3
    //   321: aload 5
    //   323: astore 4
    //   325: ldc 114
    //   327: iconst_2
    //   328: new 18	java/lang/StringBuilder
    //   331: dup
    //   332: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   335: ldc_w 443
    //   338: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: aload_1
    //   342: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   345: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   348: invokestatic 167	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   351: aload 7
    //   353: ifnull +8 -> 361
    //   356: aload 7
    //   358: invokevirtual 128	java/nio/channels/FileLock:release	()V
    //   361: aload 5
    //   363: ifnull +8 -> 371
    //   366: aload 5
    //   368: invokevirtual 436	java/io/FileOutputStream:close	()V
    //   371: aload 10
    //   373: aload_2
    //   374: invokestatic 439	com/tencent/mobileqq/utils/FileUtils:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   377: pop
    //   378: return
    //   379: astore_1
    //   380: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   383: ifeq -22 -> 361
    //   386: ldc 114
    //   388: iconst_2
    //   389: new 18	java/lang/StringBuilder
    //   392: dup
    //   393: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   396: ldc_w 441
    //   399: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   402: aload_1
    //   403: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   406: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   409: invokestatic 123	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   412: goto -51 -> 361
    //   415: astore_1
    //   416: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   419: ifeq -48 -> 371
    //   422: ldc 114
    //   424: iconst_2
    //   425: new 18	java/lang/StringBuilder
    //   428: dup
    //   429: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   432: ldc_w 441
    //   435: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   438: aload_1
    //   439: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   442: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   445: invokestatic 123	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   448: goto -77 -> 371
    //   451: astore_1
    //   452: aconst_null
    //   453: astore 5
    //   455: aload 6
    //   457: astore_3
    //   458: aload 5
    //   460: astore 4
    //   462: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   465: ifeq +36 -> 501
    //   468: aload 6
    //   470: astore_3
    //   471: aload 5
    //   473: astore 4
    //   475: ldc 114
    //   477: iconst_2
    //   478: new 18	java/lang/StringBuilder
    //   481: dup
    //   482: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   485: ldc_w 445
    //   488: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   491: aload_1
    //   492: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   495: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   498: invokestatic 123	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   501: aload 6
    //   503: ifnull +8 -> 511
    //   506: aload 6
    //   508: invokevirtual 128	java/nio/channels/FileLock:release	()V
    //   511: aload 5
    //   513: ifnull +8 -> 521
    //   516: aload 5
    //   518: invokevirtual 436	java/io/FileOutputStream:close	()V
    //   521: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   524: ifeq -496 -> 28
    //   527: ldc 114
    //   529: iconst_2
    //   530: ldc_w 447
    //   533: invokestatic 123	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   536: return
    //   537: astore_1
    //   538: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   541: ifeq -30 -> 511
    //   544: ldc 114
    //   546: iconst_2
    //   547: new 18	java/lang/StringBuilder
    //   550: dup
    //   551: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   554: ldc_w 441
    //   557: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   560: aload_1
    //   561: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   564: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   567: invokestatic 123	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   570: goto -59 -> 511
    //   573: astore_1
    //   574: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   577: ifeq -56 -> 521
    //   580: ldc 114
    //   582: iconst_2
    //   583: new 18	java/lang/StringBuilder
    //   586: dup
    //   587: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   590: ldc_w 441
    //   593: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   596: aload_1
    //   597: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   600: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   603: invokestatic 123	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   606: goto -85 -> 521
    //   609: astore_1
    //   610: aconst_null
    //   611: astore 4
    //   613: aload_3
    //   614: ifnull +7 -> 621
    //   617: aload_3
    //   618: invokevirtual 128	java/nio/channels/FileLock:release	()V
    //   621: aload 4
    //   623: ifnull +8 -> 631
    //   626: aload 4
    //   628: invokevirtual 436	java/io/FileOutputStream:close	()V
    //   631: aload 10
    //   633: aload_2
    //   634: invokestatic 439	com/tencent/mobileqq/utils/FileUtils:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   637: pop
    //   638: aload_1
    //   639: athrow
    //   640: astore_3
    //   641: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   644: ifeq -23 -> 621
    //   647: ldc 114
    //   649: iconst_2
    //   650: new 18	java/lang/StringBuilder
    //   653: dup
    //   654: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   657: ldc_w 441
    //   660: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   663: aload_3
    //   664: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   667: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   670: invokestatic 123	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   673: goto -52 -> 621
    //   676: astore_3
    //   677: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   680: ifeq -49 -> 631
    //   683: ldc 114
    //   685: iconst_2
    //   686: new 18	java/lang/StringBuilder
    //   689: dup
    //   690: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   693: ldc_w 441
    //   696: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   699: aload_3
    //   700: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   703: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   706: invokestatic 123	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   709: goto -78 -> 631
    //   712: astore_1
    //   713: goto -100 -> 613
    //   716: astore_1
    //   717: goto -262 -> 455
    //   720: astore_1
    //   721: goto -416 -> 305
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	724	0	this	LoadDataJob
    //   0	724	1	paramDoodleParam	DoodleParam
    //   0	724	2	paramString	String
    //   4	614	3	localObject1	Object
    //   640	24	3	localException1	Exception
    //   676	24	3	localException2	Exception
    //   6	621	4	localObject2	Object
    //   67	450	5	localFileOutputStream	java.io.FileOutputStream
    //   1	506	6	localObject3	Object
    //   15	342	7	localFileLock1	java.nio.channels.FileLock
    //   12	195	8	localFileLock2	java.nio.channels.FileLock
    //   9	68	9	localObject4	Object
    //   56	576	10	str	String
    // Exception table:
    //   from	to	target	type
    //   206	211	229	java/lang/Exception
    //   216	221	265	java/lang/Exception
    //   58	69	301	java/nio/channels/OverlappingFileLockException
    //   356	361	379	java/lang/Exception
    //   366	371	415	java/lang/Exception
    //   58	69	451	java/lang/Exception
    //   506	511	537	java/lang/Exception
    //   516	521	573	java/lang/Exception
    //   58	69	609	finally
    //   617	621	640	java/lang/Exception
    //   626	631	676	java/lang/Exception
    //   84	94	712	finally
    //   114	124	712	finally
    //   139	145	712	finally
    //   160	172	712	finally
    //   187	201	712	finally
    //   312	318	712	finally
    //   325	351	712	finally
    //   462	468	712	finally
    //   475	501	712	finally
    //   84	94	716	java/lang/Exception
    //   114	124	716	java/lang/Exception
    //   139	145	716	java/lang/Exception
    //   160	172	716	java/lang/Exception
    //   187	201	716	java/lang/Exception
    //   84	94	720	java/nio/channels/OverlappingFileLockException
    //   114	124	720	java/nio/channels/OverlappingFileLockException
    //   139	145	720	java/nio/channels/OverlappingFileLockException
    //   160	172	720	java/nio/channels/OverlappingFileLockException
    //   187	201	720	java/nio/channels/OverlappingFileLockException
  }
  
  /* Error */
  public boolean a(List<PathDrawer> paramList, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aconst_null
    //   4: astore 5
    //   6: aconst_null
    //   7: astore 9
    //   9: aconst_null
    //   10: astore 10
    //   12: aconst_null
    //   13: astore 6
    //   15: aload_1
    //   16: ifnull +19 -> 35
    //   19: aload_1
    //   20: invokeinterface 211 1 0
    //   25: ifeq +10 -> 35
    //   28: aload_2
    //   29: invokestatic 72	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   32: ifeq +5 -> 37
    //   35: iconst_0
    //   36: ireturn
    //   37: aload_2
    //   38: invokestatic 190	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;)Z
    //   41: ifne -6 -> 35
    //   44: new 18	java/lang/StringBuilder
    //   47: dup
    //   48: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   51: aload_2
    //   52: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: ldc_w 407
    //   58: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   64: astore 11
    //   66: new 409	java/io/FileOutputStream
    //   69: dup
    //   70: aload 11
    //   72: iconst_0
    //   73: invokespecial 451	java/io/FileOutputStream:<init>	(Ljava/lang/String;Z)V
    //   76: astore 4
    //   78: aload 9
    //   80: astore 5
    //   82: aload 4
    //   84: astore 7
    //   86: aload 10
    //   88: astore 8
    //   90: aload 4
    //   92: invokevirtual 411	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   95: astore 12
    //   97: aload 9
    //   99: astore 5
    //   101: aload 4
    //   103: astore 7
    //   105: aload 10
    //   107: astore 8
    //   109: aload 12
    //   111: invokevirtual 414	java/nio/channels/FileChannel:tryLock	()Ljava/nio/channels/FileLock;
    //   114: astore 6
    //   116: aload 6
    //   118: ifnull +220 -> 338
    //   121: aload 6
    //   123: astore 5
    //   125: aload 4
    //   127: astore 7
    //   129: aload 6
    //   131: astore 8
    //   133: aload 12
    //   135: lconst_0
    //   136: invokevirtual 418	java/nio/channels/FileChannel:position	(J)Ljava/nio/channels/FileChannel;
    //   139: pop
    //   140: aload 6
    //   142: astore 5
    //   144: aload 4
    //   146: astore 7
    //   148: aload 6
    //   150: astore 8
    //   152: aload_1
    //   153: invokeinterface 327 1 0
    //   158: astore_1
    //   159: aload 6
    //   161: astore 5
    //   163: aload 4
    //   165: astore 7
    //   167: aload 6
    //   169: astore 8
    //   171: aload_1
    //   172: invokeinterface 283 1 0
    //   177: ifeq +161 -> 338
    //   180: aload 6
    //   182: astore 5
    //   184: aload 4
    //   186: astore 7
    //   188: aload 6
    //   190: astore 8
    //   192: aload_0
    //   193: aload_1
    //   194: invokeinterface 287 1 0
    //   199: checkcast 350	com/tencent/mobileqq/activity/aio/doodle/PathDrawer
    //   202: invokevirtual 420	com/tencent/mobileqq/activity/aio/doodle/LoadDataJob:a	(Lcom/tencent/mobileqq/activity/aio/doodle/MyParcelable;)Lcom/tencent/mobileqq/activity/aio/doodle/MyParcel$DataElement;
    //   205: astore 9
    //   207: aload 6
    //   209: astore 5
    //   211: aload 4
    //   213: astore 7
    //   215: aload 6
    //   217: astore 8
    //   219: aload 4
    //   221: aload 9
    //   223: getfield 423	com/tencent/mobileqq/activity/aio/doodle/MyParcel$DataElement:jdField_a_of_type_Int	I
    //   226: invokestatic 426	com/tencent/mobileqq/activity/aio/doodle/DoodleMsgTranslator:a	(I)[B
    //   229: invokevirtual 430	java/io/FileOutputStream:write	([B)V
    //   232: aload 6
    //   234: astore 5
    //   236: aload 4
    //   238: astore 7
    //   240: aload 6
    //   242: astore 8
    //   244: aload 4
    //   246: aload 9
    //   248: getfield 433	com/tencent/mobileqq/activity/aio/doodle/MyParcel$DataElement:jdField_a_of_type_ArrayOfByte	[B
    //   251: iconst_0
    //   252: aload 9
    //   254: getfield 423	com/tencent/mobileqq/activity/aio/doodle/MyParcel$DataElement:jdField_a_of_type_Int	I
    //   257: invokevirtual 435	java/io/FileOutputStream:write	([BII)V
    //   260: goto -101 -> 159
    //   263: astore 5
    //   265: aload 6
    //   267: astore_1
    //   268: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   271: ifeq +30 -> 301
    //   274: ldc 114
    //   276: iconst_2
    //   277: new 18	java/lang/StringBuilder
    //   280: dup
    //   281: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   284: ldc_w 453
    //   287: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: aload 5
    //   292: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   295: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   298: invokestatic 167	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   301: aload_1
    //   302: ifnull +7 -> 309
    //   305: aload_1
    //   306: invokevirtual 128	java/nio/channels/FileLock:release	()V
    //   309: aload 4
    //   311: ifnull +8 -> 319
    //   314: aload 4
    //   316: invokevirtual 436	java/io/FileOutputStream:close	()V
    //   319: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   322: ifeq +506 -> 828
    //   325: ldc 114
    //   327: iconst_2
    //   328: ldc_w 455
    //   331: invokestatic 123	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   334: iconst_0
    //   335: istore_3
    //   336: iload_3
    //   337: ireturn
    //   338: aload 6
    //   340: ifnull +8 -> 348
    //   343: aload 6
    //   345: invokevirtual 128	java/nio/channels/FileLock:release	()V
    //   348: aload 4
    //   350: ifnull +8 -> 358
    //   353: aload 4
    //   355: invokevirtual 436	java/io/FileOutputStream:close	()V
    //   358: aload 11
    //   360: aload_2
    //   361: invokestatic 439	com/tencent/mobileqq/utils/FileUtils:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   364: pop
    //   365: iconst_1
    //   366: istore_3
    //   367: goto -31 -> 336
    //   370: astore_1
    //   371: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   374: ifeq -26 -> 348
    //   377: ldc 114
    //   379: iconst_2
    //   380: new 18	java/lang/StringBuilder
    //   383: dup
    //   384: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   387: ldc_w 457
    //   390: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   393: aload_1
    //   394: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   397: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   400: invokestatic 123	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   403: goto -55 -> 348
    //   406: astore_1
    //   407: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   410: ifeq -52 -> 358
    //   413: ldc 114
    //   415: iconst_2
    //   416: new 18	java/lang/StringBuilder
    //   419: dup
    //   420: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   423: ldc_w 457
    //   426: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   429: aload_1
    //   430: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   433: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   436: invokestatic 123	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   439: goto -81 -> 358
    //   442: astore_1
    //   443: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   446: ifeq -137 -> 309
    //   449: ldc 114
    //   451: iconst_2
    //   452: new 18	java/lang/StringBuilder
    //   455: dup
    //   456: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   459: ldc_w 457
    //   462: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   465: aload_1
    //   466: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   469: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   472: invokestatic 123	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   475: goto -166 -> 309
    //   478: astore_1
    //   479: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   482: ifeq -163 -> 319
    //   485: ldc 114
    //   487: iconst_2
    //   488: new 18	java/lang/StringBuilder
    //   491: dup
    //   492: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   495: ldc_w 457
    //   498: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   501: aload_1
    //   502: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   505: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   508: invokestatic 123	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   511: goto -192 -> 319
    //   514: astore_1
    //   515: aconst_null
    //   516: astore 4
    //   518: aload 8
    //   520: astore 5
    //   522: aload 4
    //   524: astore 7
    //   526: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   529: ifeq +37 -> 566
    //   532: aload 8
    //   534: astore 5
    //   536: aload 4
    //   538: astore 7
    //   540: ldc 114
    //   542: iconst_2
    //   543: new 18	java/lang/StringBuilder
    //   546: dup
    //   547: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   550: ldc_w 459
    //   553: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   556: aload_1
    //   557: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   560: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   563: invokestatic 123	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   566: aload 8
    //   568: ifnull +8 -> 576
    //   571: aload 8
    //   573: invokevirtual 128	java/nio/channels/FileLock:release	()V
    //   576: aload 4
    //   578: ifnull +8 -> 586
    //   581: aload 4
    //   583: invokevirtual 436	java/io/FileOutputStream:close	()V
    //   586: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   589: ifeq +239 -> 828
    //   592: ldc 114
    //   594: iconst_2
    //   595: ldc_w 455
    //   598: invokestatic 123	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   601: iconst_0
    //   602: istore_3
    //   603: goto -267 -> 336
    //   606: astore_1
    //   607: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   610: ifeq -34 -> 576
    //   613: ldc 114
    //   615: iconst_2
    //   616: new 18	java/lang/StringBuilder
    //   619: dup
    //   620: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   623: ldc_w 457
    //   626: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   629: aload_1
    //   630: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   633: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   636: invokestatic 123	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   639: goto -63 -> 576
    //   642: astore_1
    //   643: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   646: ifeq -60 -> 586
    //   649: ldc 114
    //   651: iconst_2
    //   652: new 18	java/lang/StringBuilder
    //   655: dup
    //   656: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   659: ldc_w 457
    //   662: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   665: aload_1
    //   666: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   669: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   672: invokestatic 123	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   675: goto -89 -> 586
    //   678: astore_1
    //   679: aconst_null
    //   680: astore 7
    //   682: aload 5
    //   684: ifnull +8 -> 692
    //   687: aload 5
    //   689: invokevirtual 128	java/nio/channels/FileLock:release	()V
    //   692: aload 7
    //   694: ifnull +8 -> 702
    //   697: aload 7
    //   699: invokevirtual 436	java/io/FileOutputStream:close	()V
    //   702: aload 11
    //   704: aload_2
    //   705: invokestatic 439	com/tencent/mobileqq/utils/FileUtils:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   708: pop
    //   709: aload_1
    //   710: athrow
    //   711: astore 4
    //   713: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   716: ifeq -24 -> 692
    //   719: ldc 114
    //   721: iconst_2
    //   722: new 18	java/lang/StringBuilder
    //   725: dup
    //   726: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   729: ldc_w 457
    //   732: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   735: aload 4
    //   737: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   740: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   743: invokestatic 123	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   746: goto -54 -> 692
    //   749: astore 4
    //   751: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   754: ifeq -52 -> 702
    //   757: ldc 114
    //   759: iconst_2
    //   760: new 18	java/lang/StringBuilder
    //   763: dup
    //   764: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   767: ldc_w 457
    //   770: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   773: aload 4
    //   775: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   778: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   781: invokestatic 123	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   784: goto -82 -> 702
    //   787: astore_1
    //   788: goto -106 -> 682
    //   791: astore 6
    //   793: aload_1
    //   794: astore 5
    //   796: aload 6
    //   798: astore_1
    //   799: aload 4
    //   801: astore 7
    //   803: goto -121 -> 682
    //   806: astore_1
    //   807: goto -289 -> 518
    //   810: astore 5
    //   812: aconst_null
    //   813: astore_1
    //   814: aload 6
    //   816: astore 4
    //   818: goto -550 -> 268
    //   821: astore 5
    //   823: aconst_null
    //   824: astore_1
    //   825: goto -557 -> 268
    //   828: iconst_0
    //   829: istore_3
    //   830: goto -494 -> 336
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	833	0	this	LoadDataJob
    //   0	833	1	paramList	List<PathDrawer>
    //   0	833	2	paramString	String
    //   335	495	3	bool	boolean
    //   76	506	4	localFileOutputStream	java.io.FileOutputStream
    //   711	25	4	localException1	Exception
    //   749	51	4	localException2	Exception
    //   816	1	4	localObject1	Object
    //   4	231	5	localObject2	Object
    //   263	28	5	localOverlappingFileLockException1	java.nio.channels.OverlappingFileLockException
    //   520	275	5	localObject3	Object
    //   810	1	5	localOverlappingFileLockException2	java.nio.channels.OverlappingFileLockException
    //   821	1	5	localOverlappingFileLockException3	java.nio.channels.OverlappingFileLockException
    //   13	331	6	localFileLock	java.nio.channels.FileLock
    //   791	24	6	localObject4	Object
    //   84	718	7	localObject5	Object
    //   1	571	8	localObject6	Object
    //   7	246	9	localDataElement	MyParcel.DataElement
    //   10	96	10	localObject7	Object
    //   64	639	11	str	String
    //   95	39	12	localFileChannel	java.nio.channels.FileChannel
    // Exception table:
    //   from	to	target	type
    //   133	140	263	java/nio/channels/OverlappingFileLockException
    //   152	159	263	java/nio/channels/OverlappingFileLockException
    //   171	180	263	java/nio/channels/OverlappingFileLockException
    //   192	207	263	java/nio/channels/OverlappingFileLockException
    //   219	232	263	java/nio/channels/OverlappingFileLockException
    //   244	260	263	java/nio/channels/OverlappingFileLockException
    //   343	348	370	java/lang/Exception
    //   353	358	406	java/lang/Exception
    //   305	309	442	java/lang/Exception
    //   314	319	478	java/lang/Exception
    //   66	78	514	java/lang/Exception
    //   571	576	606	java/lang/Exception
    //   581	586	642	java/lang/Exception
    //   66	78	678	finally
    //   687	692	711	java/lang/Exception
    //   697	702	749	java/lang/Exception
    //   90	97	787	finally
    //   109	116	787	finally
    //   133	140	787	finally
    //   152	159	787	finally
    //   171	180	787	finally
    //   192	207	787	finally
    //   219	232	787	finally
    //   244	260	787	finally
    //   526	532	787	finally
    //   540	566	787	finally
    //   268	301	791	finally
    //   90	97	806	java/lang/Exception
    //   109	116	806	java/lang/Exception
    //   133	140	806	java/lang/Exception
    //   152	159	806	java/lang/Exception
    //   171	180	806	java/lang/Exception
    //   192	207	806	java/lang/Exception
    //   219	232	806	java/lang/Exception
    //   244	260	806	java/lang/Exception
    //   66	78	810	java/nio/channels/OverlappingFileLockException
    //   90	97	821	java/nio/channels/OverlappingFileLockException
    //   109	116	821	java/nio/channels/OverlappingFileLockException
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoadDataJob", 2, "run  begin");
    }
    Object localObject1 = new File(jdField_b_of_type_JavaLangString);
    if (!((File)localObject1).exists()) {
      ((File)localObject1).mkdirs();
    }
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {}
    for (LoadDataJob.LoadDataJobListener localLoadDataJobListener = (LoadDataJob.LoadDataJobListener)this.jdField_a_of_type_JavaLangRefWeakReference.get();; localLoadDataJobListener = null)
    {
      if (localLoadDataJobListener == null) {
        QLog.d("LoadDataJob", 2, "mListener == null");
      }
      label669:
      for (;;)
      {
        return;
        if (this.jdField_a_of_type_JavaLangString == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("LoadDataJob", 2, "file == null");
          }
          localLoadDataJobListener.a(null, 4, null, null, null);
          return;
        }
        if (!localLoadDataJobListener.a(this.jdField_a_of_type_JavaLangString))
        {
          if (QLog.isColorLevel()) {
            QLog.d("LoadDataJob", 2, "onCheck  false");
          }
        }
        else
        {
          Object localObject3 = a(this.jdField_a_of_type_JavaLangString, true);
          Object localObject2 = b(this.jdField_a_of_type_JavaLangString, true);
          if (localLoadDataJobListener.a(this.jdField_a_of_type_JavaLangString))
          {
            Object localObject4;
            label250:
            PathDrawer localPathDrawer;
            if ((!TextUtils.isEmpty((CharSequence)localObject3)) && (!TextUtils.isEmpty((CharSequence)localObject2)))
            {
              if (QLog.isColorLevel()) {
                QLog.d("LoadDataJob", 2, "run  read parcel begin");
              }
              localObject1 = a((String)localObject3, localLoadDataJobListener);
              if ((!localLoadDataJobListener.a(this.jdField_a_of_type_JavaLangString)) || (localObject1 == null)) {
                continue;
              }
              if (localObject1 != null)
              {
                localObject4 = ((List)localObject1).iterator();
                if (((Iterator)localObject4).hasNext())
                {
                  localPathDrawer = (PathDrawer)((Iterator)localObject4).next();
                  if ((localPathDrawer == null) || (!localPathDrawer.a()))
                  {
                    FileUtils.e((String)localObject3);
                    localObject1 = null;
                    label294:
                    localObject2 = a((String)localObject2);
                    if (QLog.isColorLevel()) {
                      QLog.d("LoadDataJob", 2, "run  read parcel end");
                    }
                  }
                }
              }
            }
            for (;;)
            {
              if (!localLoadDataJobListener.a(this.jdField_a_of_type_JavaLangString)) {
                break label669;
              }
              if ((localObject1 != null) && (localObject2 != null))
              {
                localObject3 = localObject1;
                if (((List)localObject1).size() != 0) {}
              }
              else
              {
                if (QLog.isColorLevel()) {
                  QLog.d("LoadDataJob", 2, "run load file begin:");
                }
                long l1 = System.currentTimeMillis();
                localObject2 = DoodleMsgTranslator.a(this.jdField_a_of_type_JavaLangString);
                if (localObject2 == null)
                {
                  localLoadDataJobListener.a(this.jdField_a_of_type_JavaLangString, 4, null, null, null);
                  return;
                  localPathDrawer.a(0, 0, this.jdField_b_of_type_Int, this.c);
                  break label250;
                }
                localObject1 = ((DoodleItem)localObject2).a();
                if (!localLoadDataJobListener.a(this.jdField_a_of_type_JavaLangString)) {
                  break;
                }
                if (QLog.isColorLevel()) {
                  QLog.d("LoadDataJob", 2, "run setpathdata ");
                }
                localObject4 = a(((DoodleItem)localObject2).a(), ((DoodleItem)localObject2).a().a());
                long l2 = System.currentTimeMillis();
                if (!localLoadDataJobListener.a(this.jdField_a_of_type_JavaLangString)) {
                  break;
                }
                if (QLog.isColorLevel()) {
                  QLog.d("LoadDataJob", 2, "run load data time:" + (l2 - l1));
                }
                if (l2 - l1 > 100L)
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("LoadDataJob", 2, "need cache:");
                  }
                  ThreadManager.post(new LoadDataJob.1(this, (DoodleParam)localObject1, (List)localObject4), 5, null, false);
                }
                localObject2 = localObject1;
                localObject3 = localObject4;
                if (QLog.isColorLevel())
                {
                  QLog.d("LoadDataJob", 2, "run load file end:");
                  localObject3 = localObject4;
                  localObject2 = localObject1;
                }
              }
              if (!localLoadDataJobListener.a(this.jdField_a_of_type_JavaLangString)) {
                break;
              }
              localObject1 = a((List)localObject3);
              localLoadDataJobListener.a(this.jdField_a_of_type_JavaLangString, 0, (DoodleParam)localObject2, (List)localObject3, (Map)localObject1);
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("LoadDataJob", 2, "run  end");
              return;
              break label294;
              localObject2 = null;
              localObject1 = null;
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.LoadDataJob
 * JD-Core Version:    0.7.0.1
 */