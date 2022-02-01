package com.tencent.mobileqq.activity.aio.doodle;

import android.graphics.Rect;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.scribble.ScribbleMsgConstants;
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
  private static final String jdField_b_of_type_JavaLangString;
  final int jdField_a_of_type_Int = 3;
  public String a;
  private WeakReference<LoadDataJob.LoadDataJobListener> jdField_a_of_type_JavaLangRefWeakReference;
  private int jdField_b_of_type_Int;
  private int c;
  private int d = 0;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(ScribbleMsgConstants.a());
    localStringBuilder.append("pclcache");
    localStringBuilder.append(File.separator);
    jdField_b_of_type_JavaLangString = localStringBuilder.toString();
  }
  
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
    //   0: aload_1
    //   1: invokestatic 72	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: istore 5
    //   6: aconst_null
    //   7: astore 15
    //   9: aconst_null
    //   10: astore 16
    //   12: aconst_null
    //   13: astore 7
    //   15: iload 5
    //   17: ifeq +5 -> 22
    //   20: aconst_null
    //   21: areturn
    //   22: iconst_1
    //   23: istore_3
    //   24: iconst_1
    //   25: istore 4
    //   27: iconst_1
    //   28: istore_2
    //   29: new 74	java/io/FileInputStream
    //   32: dup
    //   33: aload_1
    //   34: invokespecial 77	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   37: astore 6
    //   39: aload 6
    //   41: invokevirtual 81	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   44: lconst_0
    //   45: ldc2_w 82
    //   48: iconst_1
    //   49: invokevirtual 89	java/nio/channels/FileChannel:tryLock	(JJZ)Ljava/nio/channels/FileLock;
    //   52: astore 11
    //   54: aload 11
    //   56: ifnull +386 -> 442
    //   59: new 91	java/io/BufferedInputStream
    //   62: dup
    //   63: aload 6
    //   65: invokespecial 94	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   68: astore 8
    //   70: iconst_4
    //   71: newarray byte
    //   73: astore 9
    //   75: aload 8
    //   77: aload 9
    //   79: invokevirtual 100	java/io/InputStream:read	([B)I
    //   82: iconst_4
    //   83: if_icmpne +84 -> 167
    //   86: aload 9
    //   88: iconst_0
    //   89: invokestatic 105	com/tencent/mobileqq/activity/aio/doodle/DoodleMsgTranslator:a	([BI)I
    //   92: istore_2
    //   93: iload_2
    //   94: ifle +147 -> 241
    //   97: iload_2
    //   98: ldc 106
    //   100: if_icmplt +6 -> 106
    //   103: goto +138 -> 241
    //   106: iload_2
    //   107: newarray byte
    //   109: astore 9
    //   111: aload 8
    //   113: aload 9
    //   115: iconst_0
    //   116: iload_2
    //   117: invokevirtual 109	java/io/InputStream:read	([BII)I
    //   120: iload_2
    //   121: if_icmpeq +53 -> 174
    //   124: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   127: ifeq +38 -> 165
    //   130: new 18	java/lang/StringBuilder
    //   133: dup
    //   134: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   137: astore 9
    //   139: aload 9
    //   141: ldc 117
    //   143: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: pop
    //   147: aload 9
    //   149: iload_2
    //   150: invokevirtual 120	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   153: pop
    //   154: ldc 122
    //   156: iconst_2
    //   157: aload 9
    //   159: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   162: invokestatic 126	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   165: iconst_0
    //   166: istore_2
    //   167: aload 8
    //   169: astore 9
    //   171: goto +276 -> 447
    //   174: aload 6
    //   176: astore 14
    //   178: aload 11
    //   180: astore 13
    //   182: aload 8
    //   184: astore 12
    //   186: aload_0
    //   187: aload 9
    //   189: invokevirtual 129	com/tencent/mobileqq/activity/aio/doodle/LoadDataJob:a	([B)Lcom/tencent/mobileqq/activity/aio/doodle/MyParcel;
    //   192: astore 10
    //   194: iload_3
    //   195: istore_2
    //   196: aload 8
    //   198: astore 9
    //   200: aload 10
    //   202: ifnull +245 -> 447
    //   205: aload 6
    //   207: astore 14
    //   209: aload 11
    //   211: astore 13
    //   213: aload 8
    //   215: astore 12
    //   217: getstatic 134	com/tencent/mobileqq/activity/aio/doodle/DoodleParam:a	Lcom/tencent/mobileqq/activity/aio/doodle/MyParcelable$Creator;
    //   220: aload 10
    //   222: invokeinterface 139 2 0
    //   227: checkcast 131	com/tencent/mobileqq/activity/aio/doodle/DoodleParam
    //   230: astore 7
    //   232: iload_3
    //   233: istore_2
    //   234: aload 8
    //   236: astore 9
    //   238: goto +209 -> 447
    //   241: aload 6
    //   243: astore 14
    //   245: aload 11
    //   247: astore 13
    //   249: aload 8
    //   251: astore 12
    //   253: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   256: ifeq +86 -> 342
    //   259: aload 6
    //   261: astore 14
    //   263: aload 11
    //   265: astore 13
    //   267: aload 8
    //   269: astore 12
    //   271: new 18	java/lang/StringBuilder
    //   274: dup
    //   275: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   278: astore 9
    //   280: aload 6
    //   282: astore 14
    //   284: aload 11
    //   286: astore 13
    //   288: aload 8
    //   290: astore 12
    //   292: aload 9
    //   294: ldc 141
    //   296: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: pop
    //   300: aload 6
    //   302: astore 14
    //   304: aload 11
    //   306: astore 13
    //   308: aload 8
    //   310: astore 12
    //   312: aload 9
    //   314: iload_2
    //   315: invokevirtual 120	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   318: pop
    //   319: aload 6
    //   321: astore 14
    //   323: aload 11
    //   325: astore 13
    //   327: aload 8
    //   329: astore 12
    //   331: ldc 122
    //   333: iconst_2
    //   334: aload 9
    //   336: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   339: invokestatic 126	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   342: iconst_0
    //   343: istore_2
    //   344: aload 8
    //   346: astore 9
    //   348: goto +99 -> 447
    //   351: astore 10
    //   353: aload 6
    //   355: astore 7
    //   357: aload 11
    //   359: astore 9
    //   361: aload 8
    //   363: astore 6
    //   365: goto +365 -> 730
    //   368: astore 7
    //   370: aload 6
    //   372: astore 9
    //   374: aload 11
    //   376: astore 10
    //   378: aload 8
    //   380: astore 6
    //   382: goto +319 -> 701
    //   385: astore 10
    //   387: aload 6
    //   389: astore 7
    //   391: aload 11
    //   393: astore 9
    //   395: aload 8
    //   397: astore 6
    //   399: goto +331 -> 730
    //   402: astore 7
    //   404: aconst_null
    //   405: astore 8
    //   407: aload 6
    //   409: astore 9
    //   411: aload 11
    //   413: astore 10
    //   415: aload 8
    //   417: astore 6
    //   419: goto +282 -> 701
    //   422: astore 10
    //   424: aconst_null
    //   425: astore 8
    //   427: aload 6
    //   429: astore 7
    //   431: aload 11
    //   433: astore 9
    //   435: aload 8
    //   437: astore 6
    //   439: goto +291 -> 730
    //   442: aconst_null
    //   443: astore 9
    //   445: iload_3
    //   446: istore_2
    //   447: aload 11
    //   449: ifnull +60 -> 509
    //   452: aload 11
    //   454: invokevirtual 146	java/nio/channels/FileLock:release	()V
    //   457: goto +52 -> 509
    //   460: astore 8
    //   462: aload 8
    //   464: invokevirtual 149	java/lang/Exception:printStackTrace	()V
    //   467: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   470: ifeq +39 -> 509
    //   473: new 18	java/lang/StringBuilder
    //   476: dup
    //   477: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   480: astore 10
    //   482: aload 10
    //   484: ldc 151
    //   486: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   489: pop
    //   490: aload 10
    //   492: aload 8
    //   494: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   497: pop
    //   498: ldc 122
    //   500: iconst_2
    //   501: aload 10
    //   503: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   506: invokestatic 156	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   509: aload 6
    //   511: invokevirtual 159	java/io/FileInputStream:close	()V
    //   514: goto +52 -> 566
    //   517: astore 6
    //   519: aload 6
    //   521: invokevirtual 149	java/lang/Exception:printStackTrace	()V
    //   524: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   527: ifeq +39 -> 566
    //   530: new 18	java/lang/StringBuilder
    //   533: dup
    //   534: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   537: astore 8
    //   539: aload 8
    //   541: ldc 151
    //   543: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   546: pop
    //   547: aload 8
    //   549: aload 6
    //   551: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   554: pop
    //   555: ldc 122
    //   557: iconst_2
    //   558: aload 8
    //   560: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   563: invokestatic 156	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   566: aload 9
    //   568: ifnull +60 -> 628
    //   571: aload 9
    //   573: invokevirtual 160	java/io/InputStream:close	()V
    //   576: goto +52 -> 628
    //   579: astore 6
    //   581: aload 6
    //   583: invokevirtual 149	java/lang/Exception:printStackTrace	()V
    //   586: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   589: ifeq +39 -> 628
    //   592: new 18	java/lang/StringBuilder
    //   595: dup
    //   596: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   599: astore 8
    //   601: aload 8
    //   603: ldc 151
    //   605: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   608: pop
    //   609: aload 8
    //   611: aload 6
    //   613: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   616: pop
    //   617: ldc 122
    //   619: iconst_2
    //   620: aload 8
    //   622: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   625: invokestatic 156	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   628: iload_2
    //   629: ifne +363 -> 992
    //   632: aload 7
    //   634: astore 6
    //   636: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   639: ifeq +15 -> 654
    //   642: aload 7
    //   644: astore 6
    //   646: ldc 122
    //   648: iconst_2
    //   649: ldc 162
    //   651: invokestatic 126	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   654: aload_1
    //   655: invokestatic 168	com/tencent/mobileqq/utils/FileUtils:deleteFile	(Ljava/lang/String;)Z
    //   658: pop
    //   659: aload 6
    //   661: areturn
    //   662: astore 7
    //   664: aload 6
    //   666: astore 9
    //   668: goto +27 -> 695
    //   671: astore 10
    //   673: aload 6
    //   675: astore 7
    //   677: goto +47 -> 724
    //   680: astore 7
    //   682: goto +10 -> 692
    //   685: astore 10
    //   687: goto +34 -> 721
    //   690: astore 6
    //   692: aconst_null
    //   693: astore 9
    //   695: aconst_null
    //   696: astore 10
    //   698: aconst_null
    //   699: astore 6
    //   701: aload 7
    //   703: astore 8
    //   705: iload 4
    //   707: istore_2
    //   708: aload 9
    //   710: astore 7
    //   712: aload 10
    //   714: astore 9
    //   716: goto +303 -> 1019
    //   719: astore 6
    //   721: aconst_null
    //   722: astore 7
    //   724: aconst_null
    //   725: astore 9
    //   727: aconst_null
    //   728: astore 6
    //   730: aload 7
    //   732: astore 14
    //   734: aload 9
    //   736: astore 13
    //   738: aload 6
    //   740: astore 12
    //   742: aload 10
    //   744: invokevirtual 149	java/lang/Exception:printStackTrace	()V
    //   747: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   750: ifeq +39 -> 789
    //   753: new 18	java/lang/StringBuilder
    //   756: dup
    //   757: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   760: astore 8
    //   762: aload 8
    //   764: ldc 170
    //   766: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   769: pop
    //   770: aload 8
    //   772: aload 10
    //   774: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   777: pop
    //   778: ldc 122
    //   780: iconst_2
    //   781: aload 8
    //   783: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   786: invokestatic 156	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   789: aload 9
    //   791: ifnull +60 -> 851
    //   794: aload 9
    //   796: invokevirtual 146	java/nio/channels/FileLock:release	()V
    //   799: goto +52 -> 851
    //   802: astore 8
    //   804: aload 8
    //   806: invokevirtual 149	java/lang/Exception:printStackTrace	()V
    //   809: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   812: ifeq +39 -> 851
    //   815: new 18	java/lang/StringBuilder
    //   818: dup
    //   819: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   822: astore 9
    //   824: aload 9
    //   826: ldc 151
    //   828: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   831: pop
    //   832: aload 9
    //   834: aload 8
    //   836: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   839: pop
    //   840: ldc 122
    //   842: iconst_2
    //   843: aload 9
    //   845: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   848: invokestatic 156	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   851: aload 7
    //   853: ifnull +60 -> 913
    //   856: aload 7
    //   858: invokevirtual 159	java/io/FileInputStream:close	()V
    //   861: goto +52 -> 913
    //   864: astore 7
    //   866: aload 7
    //   868: invokevirtual 149	java/lang/Exception:printStackTrace	()V
    //   871: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   874: ifeq +39 -> 913
    //   877: new 18	java/lang/StringBuilder
    //   880: dup
    //   881: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   884: astore 8
    //   886: aload 8
    //   888: ldc 151
    //   890: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   893: pop
    //   894: aload 8
    //   896: aload 7
    //   898: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   901: pop
    //   902: ldc 122
    //   904: iconst_2
    //   905: aload 8
    //   907: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   910: invokestatic 156	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   913: aload 6
    //   915: ifnull +60 -> 975
    //   918: aload 6
    //   920: invokevirtual 160	java/io/InputStream:close	()V
    //   923: goto +52 -> 975
    //   926: astore 6
    //   928: aload 6
    //   930: invokevirtual 149	java/lang/Exception:printStackTrace	()V
    //   933: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   936: ifeq +39 -> 975
    //   939: new 18	java/lang/StringBuilder
    //   942: dup
    //   943: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   946: astore 7
    //   948: aload 7
    //   950: ldc 151
    //   952: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   955: pop
    //   956: aload 7
    //   958: aload 6
    //   960: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   963: pop
    //   964: ldc 122
    //   966: iconst_2
    //   967: aload 7
    //   969: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   972: invokestatic 156	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   975: aload 16
    //   977: astore 6
    //   979: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   982: ifeq -328 -> 654
    //   985: aload 15
    //   987: astore 6
    //   989: goto -343 -> 646
    //   992: aload 7
    //   994: areturn
    //   995: astore 8
    //   997: iconst_0
    //   998: istore_2
    //   999: goto +20 -> 1019
    //   1002: astore 7
    //   1004: aload 14
    //   1006: astore 9
    //   1008: aload 13
    //   1010: astore 10
    //   1012: aload 12
    //   1014: astore 6
    //   1016: goto -315 -> 701
    //   1019: aload 9
    //   1021: ifnull +60 -> 1081
    //   1024: aload 9
    //   1026: invokevirtual 146	java/nio/channels/FileLock:release	()V
    //   1029: goto +52 -> 1081
    //   1032: astore 9
    //   1034: aload 9
    //   1036: invokevirtual 149	java/lang/Exception:printStackTrace	()V
    //   1039: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1042: ifeq +39 -> 1081
    //   1045: new 18	java/lang/StringBuilder
    //   1048: dup
    //   1049: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   1052: astore 10
    //   1054: aload 10
    //   1056: ldc 151
    //   1058: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1061: pop
    //   1062: aload 10
    //   1064: aload 9
    //   1066: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1069: pop
    //   1070: ldc 122
    //   1072: iconst_2
    //   1073: aload 10
    //   1075: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1078: invokestatic 156	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1081: aload 7
    //   1083: ifnull +60 -> 1143
    //   1086: aload 7
    //   1088: invokevirtual 159	java/io/FileInputStream:close	()V
    //   1091: goto +52 -> 1143
    //   1094: astore 7
    //   1096: aload 7
    //   1098: invokevirtual 149	java/lang/Exception:printStackTrace	()V
    //   1101: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1104: ifeq +39 -> 1143
    //   1107: new 18	java/lang/StringBuilder
    //   1110: dup
    //   1111: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   1114: astore 9
    //   1116: aload 9
    //   1118: ldc 151
    //   1120: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1123: pop
    //   1124: aload 9
    //   1126: aload 7
    //   1128: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1131: pop
    //   1132: ldc 122
    //   1134: iconst_2
    //   1135: aload 9
    //   1137: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1140: invokestatic 156	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1143: aload 6
    //   1145: ifnull +60 -> 1205
    //   1148: aload 6
    //   1150: invokevirtual 160	java/io/InputStream:close	()V
    //   1153: goto +52 -> 1205
    //   1156: astore 6
    //   1158: aload 6
    //   1160: invokevirtual 149	java/lang/Exception:printStackTrace	()V
    //   1163: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1166: ifeq +39 -> 1205
    //   1169: new 18	java/lang/StringBuilder
    //   1172: dup
    //   1173: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   1176: astore 7
    //   1178: aload 7
    //   1180: ldc 151
    //   1182: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1185: pop
    //   1186: aload 7
    //   1188: aload 6
    //   1190: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1193: pop
    //   1194: ldc 122
    //   1196: iconst_2
    //   1197: aload 7
    //   1199: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1202: invokestatic 156	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1205: iload_2
    //   1206: ifne +22 -> 1228
    //   1209: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1212: ifeq +11 -> 1223
    //   1215: ldc 122
    //   1217: iconst_2
    //   1218: ldc 162
    //   1220: invokestatic 126	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1223: aload_1
    //   1224: invokestatic 168	com/tencent/mobileqq/utils/FileUtils:deleteFile	(Ljava/lang/String;)Z
    //   1227: pop
    //   1228: goto +6 -> 1234
    //   1231: aload 8
    //   1233: athrow
    //   1234: goto -3 -> 1231
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1237	0	this	LoadDataJob
    //   0	1237	1	paramString	String
    //   28	601	2	i	int
    //   23	423	3	j	int
    //   25	1	4	k	int
    //   4	12	5	bool	boolean
    //   37	473	6	localObject1	Object
    //   517	33	6	localException1	Exception
    //   579	33	6	localException2	Exception
    //   634	40	6	localObject2	Object
    //   13	343	7	localObject3	Object
    //   368	1	7	localObject4	Object
    //   389	1	7	localObject5	Object
    //   402	1	7	localObject6	Object
    //   429	214	7	localObject7	Object
    //   662	1	7	localObject8	Object
    //   675	1	7	localObject9	Object
    //   680	1	7	localObject10	Object
    //   68	368	8	localBufferedInputStream1	java.io.BufferedInputStream
    //   460	33	8	localException3	Exception
    //   537	84	8	localStringBuilder1	StringBuilder
    //   73	594	9	localObject11	Object
    //   192	29	10	localMyParcel	MyParcel
    //   351	1	10	localException4	Exception
    //   376	1	10	localFileLock1	java.nio.channels.FileLock
    //   385	1	10	localException5	Exception
    //   413	1	10	localFileLock2	java.nio.channels.FileLock
    //   422	1	10	localException6	Exception
    //   480	22	10	localStringBuilder2	StringBuilder
    //   671	1	10	localException7	Exception
    //   685	1	10	localException8	Exception
    //   52	401	11	localFileLock3	java.nio.channels.FileLock
    //   184	146	12	localBufferedInputStream2	java.io.BufferedInputStream
    //   180	146	13	localFileLock4	java.nio.channels.FileLock
    //   176	146	14	localObject12	Object
    //   7	1	15	localObject13	Object
    //   10	1	16	localObject14	Object
    // Exception table:
    //   from	to	target	type
    //   186	194	351	java/lang/Exception
    //   217	232	351	java/lang/Exception
    //   253	259	351	java/lang/Exception
    //   271	280	351	java/lang/Exception
    //   292	300	351	java/lang/Exception
    //   312	319	351	java/lang/Exception
    //   331	342	351	java/lang/Exception
    //   70	75	368	finally
    //   75	93	368	finally
    //   106	165	368	finally
    //   70	75	385	java/lang/Exception
    //   75	93	385	java/lang/Exception
    //   106	165	385	java/lang/Exception
    //   59	70	402	finally
    //   59	70	422	java/lang/Exception
    //   452	457	460	java/lang/Exception
    //   509	514	517	java/lang/Exception
    //   571	576	579	java/lang/Exception
    //   39	54	662	finally
    //   39	54	671	java/lang/Exception
    //   29	39	680	finally
    //   29	39	685	java/lang/Exception
    //   794	799	802	java/lang/Exception
    //   856	861	864	java/lang/Exception
    //   918	923	926	java/lang/Exception
    //   747	789	995	finally
    //   186	194	1002	finally
    //   217	232	1002	finally
    //   253	259	1002	finally
    //   271	280	1002	finally
    //   292	300	1002	finally
    //   312	319	1002	finally
    //   331	342	1002	finally
    //   742	747	1002	finally
    //   1024	1029	1032	java/lang/Exception
    //   1086	1091	1094	java/lang/Exception
    //   1148	1153	1156	java/lang/Exception
  }
  
  private String a(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(jdField_b_of_type_JavaLangString);
      localStringBuilder.append(paramString.substring(paramString.lastIndexOf(File.separator) + 1, paramString.lastIndexOf('_')));
      localStringBuilder.append("_dwr");
      paramString = localStringBuilder.toString();
      if (paramBoolean)
      {
        paramBoolean = FileUtils.fileExists(paramString);
        if (paramBoolean) {
          return paramString;
        }
        return null;
      }
      return paramString;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  /* Error */
  private List<PathDrawer> a(String paramString, LoadDataJob.LoadDataJobListener paramLoadDataJobListener)
  {
    // Byte code:
    //   0: new 197	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 198	java/util/ArrayList:<init>	()V
    //   7: astore 15
    //   9: aload_1
    //   10: invokestatic 72	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   13: ifeq +6 -> 19
    //   16: aload 15
    //   18: areturn
    //   19: new 200	java/util/HashMap
    //   22: dup
    //   23: invokespecial 201	java/util/HashMap:<init>	()V
    //   26: astore 12
    //   28: aload_0
    //   29: iconst_1
    //   30: putfield 47	com/tencent/mobileqq/activity/aio/doodle/LoadDataJob:d	I
    //   33: new 74	java/io/FileInputStream
    //   36: dup
    //   37: aload_1
    //   38: invokespecial 77	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   41: astore 10
    //   43: aload 10
    //   45: invokevirtual 81	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   48: lconst_0
    //   49: ldc2_w 82
    //   52: iconst_1
    //   53: invokevirtual 89	java/nio/channels/FileChannel:tryLock	(JJZ)Ljava/nio/channels/FileLock;
    //   56: astore 11
    //   58: aload 11
    //   60: ifnull +761 -> 821
    //   63: new 91	java/io/BufferedInputStream
    //   66: dup
    //   67: aload 10
    //   69: invokespecial 94	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   72: astore 9
    //   74: iconst_4
    //   75: newarray byte
    //   77: astore 13
    //   79: iconst_0
    //   80: istore_3
    //   81: iconst_1
    //   82: istore 7
    //   84: aload 9
    //   86: aload 13
    //   88: invokevirtual 100	java/io/InputStream:read	([B)I
    //   91: iconst_4
    //   92: if_icmpne +659 -> 751
    //   95: aload 13
    //   97: iconst_0
    //   98: invokestatic 105	com/tencent/mobileqq/activity/aio/doodle/DoodleMsgTranslator:a	([BI)I
    //   101: istore 4
    //   103: iload 4
    //   105: ifle +595 -> 700
    //   108: iload 4
    //   110: ldc 106
    //   112: if_icmplt +6 -> 118
    //   115: goto +585 -> 700
    //   118: iload 4
    //   120: newarray byte
    //   122: astore 14
    //   124: aload 9
    //   126: aload 14
    //   128: iconst_0
    //   129: iload 4
    //   131: invokevirtual 109	java/io/InputStream:read	([BII)I
    //   134: istore 5
    //   136: iload 5
    //   138: iload 4
    //   140: if_icmpeq +59 -> 199
    //   143: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   146: ifeq +593 -> 739
    //   149: new 18	java/lang/StringBuilder
    //   152: dup
    //   153: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   156: astore_2
    //   157: aload_2
    //   158: ldc 203
    //   160: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: pop
    //   164: aload_2
    //   165: iload 4
    //   167: invokevirtual 120	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   170: pop
    //   171: ldc 122
    //   173: iconst_2
    //   174: aload_2
    //   175: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   178: invokestatic 126	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   181: goto +558 -> 739
    //   184: astore 12
    //   186: aload 9
    //   188: astore_2
    //   189: iconst_0
    //   190: istore 6
    //   192: aload 12
    //   194: astore 9
    //   196: goto +1224 -> 1420
    //   199: new 205	com/tencent/mobileqq/activity/aio/doodle/LoadDataJob$UnmarshallJob
    //   202: dup
    //   203: aload_0
    //   204: iload_3
    //   205: aload 14
    //   207: new 207	com/tencent/mobileqq/activity/aio/doodle/LoadDataJob$2
    //   210: dup
    //   211: aload_0
    //   212: aload 12
    //   214: aload 15
    //   216: invokespecial 210	com/tencent/mobileqq/activity/aio/doodle/LoadDataJob$2:<init>	(Lcom/tencent/mobileqq/activity/aio/doodle/LoadDataJob;Ljava/util/Map;Ljava/util/List;)V
    //   219: invokespecial 213	com/tencent/mobileqq/activity/aio/doodle/LoadDataJob$UnmarshallJob:<init>	(Lcom/tencent/mobileqq/activity/aio/doodle/LoadDataJob;I[BLcom/tencent/mobileqq/activity/aio/doodle/LoadDataJob$UnmarshallJobListener;)V
    //   222: astore 14
    //   224: aload 12
    //   226: monitorenter
    //   227: aload 12
    //   229: invokeinterface 219 1 0
    //   234: istore 4
    //   236: iload 4
    //   238: iconst_3
    //   239: if_icmple +105 -> 344
    //   242: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   245: ifeq +44 -> 289
    //   248: new 18	java/lang/StringBuilder
    //   251: dup
    //   252: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   255: astore 16
    //   257: aload 16
    //   259: ldc 221
    //   261: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: pop
    //   265: aload 16
    //   267: aload 12
    //   269: invokeinterface 219 1 0
    //   274: invokevirtual 120	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   277: pop
    //   278: ldc 122
    //   280: iconst_2
    //   281: aload 16
    //   283: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   286: invokestatic 156	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   289: aload 12
    //   291: ldc2_w 222
    //   294: invokevirtual 227	java/lang/Object:wait	(J)V
    //   297: goto +47 -> 344
    //   300: astore 16
    //   302: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   305: ifeq +39 -> 344
    //   308: new 18	java/lang/StringBuilder
    //   311: dup
    //   312: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   315: astore 17
    //   317: aload 17
    //   319: ldc 229
    //   321: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   324: pop
    //   325: aload 17
    //   327: aload 16
    //   329: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   332: pop
    //   333: ldc 122
    //   335: iconst_2
    //   336: aload 17
    //   338: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   341: invokestatic 156	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   344: aload 12
    //   346: monitorexit
    //   347: aload_2
    //   348: aload_0
    //   349: getfield 51	com/tencent/mobileqq/activity/aio/doodle/LoadDataJob:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   352: invokeinterface 233 2 0
    //   357: ifne +231 -> 588
    //   360: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   363: ifeq +11 -> 374
    //   366: ldc 122
    //   368: iconst_2
    //   369: ldc 235
    //   371: invokestatic 156	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   374: aload 12
    //   376: monitorenter
    //   377: aload 12
    //   379: invokeinterface 239 1 0
    //   384: invokeinterface 245 1 0
    //   389: astore_2
    //   390: iconst_0
    //   391: istore_3
    //   392: aload_2
    //   393: invokeinterface 250 1 0
    //   398: ifeq +27 -> 425
    //   401: aload_2
    //   402: invokeinterface 254 1 0
    //   407: checkcast 205	com/tencent/mobileqq/activity/aio/doodle/LoadDataJob$UnmarshallJob
    //   410: bipush 16
    //   412: invokestatic 260	com/tencent/mobileqq/app/ThreadManager:removeJobFromThreadPool	(Ljava/lang/Runnable;I)Z
    //   415: ifeq -23 -> 392
    //   418: iload_3
    //   419: iconst_1
    //   420: iadd
    //   421: istore_3
    //   422: goto -30 -> 392
    //   425: aload 12
    //   427: invokeinterface 263 1 0
    //   432: aload 12
    //   434: monitorexit
    //   435: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   438: ifeq +35 -> 473
    //   441: new 18	java/lang/StringBuilder
    //   444: dup
    //   445: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   448: astore_2
    //   449: aload_2
    //   450: ldc_w 265
    //   453: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   456: pop
    //   457: aload_2
    //   458: iload_3
    //   459: invokevirtual 120	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   462: pop
    //   463: ldc 122
    //   465: iconst_2
    //   466: aload_2
    //   467: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   470: invokestatic 156	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   473: iload_3
    //   474: ifle +69 -> 543
    //   477: aload 15
    //   479: monitorenter
    //   480: aload_0
    //   481: aload_0
    //   482: getfield 47	com/tencent/mobileqq/activity/aio/doodle/LoadDataJob:d	I
    //   485: iload_3
    //   486: isub
    //   487: putfield 47	com/tencent/mobileqq/activity/aio/doodle/LoadDataJob:d	I
    //   490: aload 15
    //   492: monitorexit
    //   493: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   496: ifeq +47 -> 543
    //   499: new 18	java/lang/StringBuilder
    //   502: dup
    //   503: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   506: astore_2
    //   507: aload_2
    //   508: ldc_w 267
    //   511: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   514: pop
    //   515: aload_2
    //   516: aload_0
    //   517: getfield 47	com/tencent/mobileqq/activity/aio/doodle/LoadDataJob:d	I
    //   520: invokevirtual 120	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   523: pop
    //   524: ldc 122
    //   526: iconst_2
    //   527: aload_2
    //   528: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   531: invokestatic 156	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   534: goto +9 -> 543
    //   537: astore_2
    //   538: aload 15
    //   540: monitorexit
    //   541: aload_2
    //   542: athrow
    //   543: aload 9
    //   545: astore_2
    //   546: iconst_1
    //   547: istore 6
    //   549: goto +277 -> 826
    //   552: astore_2
    //   553: aload 12
    //   555: monitorexit
    //   556: aload_2
    //   557: athrow
    //   558: astore 12
    //   560: aload 9
    //   562: astore_2
    //   563: iconst_1
    //   564: istore 6
    //   566: aload 12
    //   568: astore 9
    //   570: goto +235 -> 805
    //   573: astore 12
    //   575: aload 9
    //   577: astore_2
    //   578: iconst_1
    //   579: istore 6
    //   581: aload 12
    //   583: astore 9
    //   585: goto +1162 -> 1747
    //   588: aload 12
    //   590: monitorenter
    //   591: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   594: ifeq +39 -> 633
    //   597: new 18	java/lang/StringBuilder
    //   600: dup
    //   601: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   604: astore 16
    //   606: aload 16
    //   608: ldc_w 269
    //   611: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   614: pop
    //   615: aload 16
    //   617: iload_3
    //   618: invokevirtual 120	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   621: pop
    //   622: ldc 122
    //   624: iconst_2
    //   625: aload 16
    //   627: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   630: invokestatic 156	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   633: aload 12
    //   635: iload_3
    //   636: invokestatic 275	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   639: aload 14
    //   641: invokeinterface 279 3 0
    //   646: pop
    //   647: iload_3
    //   648: iconst_1
    //   649: iadd
    //   650: istore_3
    //   651: aload 12
    //   653: monitorexit
    //   654: aload 15
    //   656: monitorenter
    //   657: aload_0
    //   658: aload_0
    //   659: getfield 47	com/tencent/mobileqq/activity/aio/doodle/LoadDataJob:d	I
    //   662: iconst_1
    //   663: iadd
    //   664: putfield 47	com/tencent/mobileqq/activity/aio/doodle/LoadDataJob:d	I
    //   667: aload 15
    //   669: monitorexit
    //   670: aload 14
    //   672: bipush 16
    //   674: aconst_null
    //   675: iconst_1
    //   676: invokestatic 283	com/tencent/mobileqq/app/ThreadManager:excute	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   679: goto -598 -> 81
    //   682: astore_2
    //   683: aload 15
    //   685: monitorexit
    //   686: aload_2
    //   687: athrow
    //   688: astore_2
    //   689: aload 12
    //   691: monitorexit
    //   692: aload_2
    //   693: athrow
    //   694: astore_2
    //   695: aload 12
    //   697: monitorexit
    //   698: aload_2
    //   699: athrow
    //   700: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   703: ifeq +36 -> 739
    //   706: new 18	java/lang/StringBuilder
    //   709: dup
    //   710: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   713: astore_2
    //   714: aload_2
    //   715: ldc_w 285
    //   718: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   721: pop
    //   722: aload_2
    //   723: iload 4
    //   725: invokevirtual 120	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   728: pop
    //   729: ldc 122
    //   731: iconst_2
    //   732: aload_2
    //   733: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   736: invokestatic 126	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   739: aload 9
    //   741: astore_2
    //   742: iconst_0
    //   743: istore 6
    //   745: iconst_0
    //   746: istore 7
    //   748: goto +81 -> 829
    //   751: aload 9
    //   753: astore_2
    //   754: iconst_0
    //   755: istore 6
    //   757: goto +69 -> 826
    //   760: astore_2
    //   761: goto +633 -> 1394
    //   764: astore 12
    //   766: aload 9
    //   768: astore_2
    //   769: iconst_0
    //   770: istore 6
    //   772: aload 12
    //   774: astore 9
    //   776: goto +29 -> 805
    //   779: astore 12
    //   781: aload 9
    //   783: astore_2
    //   784: iconst_0
    //   785: istore 6
    //   787: aload 12
    //   789: astore 9
    //   791: goto +956 -> 1747
    //   794: astore_2
    //   795: goto +596 -> 1391
    //   798: astore 9
    //   800: iconst_0
    //   801: istore 6
    //   803: aconst_null
    //   804: astore_2
    //   805: iconst_1
    //   806: istore 7
    //   808: goto +612 -> 1420
    //   811: astore 9
    //   813: iconst_0
    //   814: istore 6
    //   816: aconst_null
    //   817: astore_2
    //   818: goto +929 -> 1747
    //   821: iconst_0
    //   822: istore 6
    //   824: aconst_null
    //   825: astore_2
    //   826: iconst_1
    //   827: istore 7
    //   829: aload_2
    //   830: astore 14
    //   832: iload 7
    //   834: istore 8
    //   836: aload 10
    //   838: astore 13
    //   840: aload 11
    //   842: astore 12
    //   844: aload 15
    //   846: monitorenter
    //   847: aload_0
    //   848: aload_0
    //   849: getfield 47	com/tencent/mobileqq/activity/aio/doodle/LoadDataJob:d	I
    //   852: iconst_1
    //   853: isub
    //   854: putfield 47	com/tencent/mobileqq/activity/aio/doodle/LoadDataJob:d	I
    //   857: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   860: ifeq +98 -> 958
    //   863: new 18	java/lang/StringBuilder
    //   866: dup
    //   867: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   870: astore 9
    //   872: aload 9
    //   874: ldc_w 287
    //   877: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   880: pop
    //   881: aload 9
    //   883: aload_0
    //   884: getfield 47	com/tencent/mobileqq/activity/aio/doodle/LoadDataJob:d	I
    //   887: invokevirtual 120	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   890: pop
    //   891: aload 9
    //   893: ldc_w 289
    //   896: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   899: pop
    //   900: aload 9
    //   902: aload 15
    //   904: invokeinterface 292 1 0
    //   909: invokevirtual 120	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   912: pop
    //   913: aload 9
    //   915: ldc_w 294
    //   918: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   921: pop
    //   922: aload 9
    //   924: iload 7
    //   926: invokevirtual 297	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   929: pop
    //   930: aload 9
    //   932: ldc_w 299
    //   935: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   938: pop
    //   939: aload 9
    //   941: iload 6
    //   943: invokevirtual 297	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   946: pop
    //   947: ldc 122
    //   949: iconst_2
    //   950: aload 9
    //   952: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   955: invokestatic 156	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   958: aload_0
    //   959: getfield 47	com/tencent/mobileqq/activity/aio/doodle/LoadDataJob:d	I
    //   962: istore_3
    //   963: aload 15
    //   965: invokeinterface 292 1 0
    //   970: istore 4
    //   972: iload_3
    //   973: iload 4
    //   975: if_icmple +64 -> 1039
    //   978: iload 7
    //   980: ifeq +59 -> 1039
    //   983: aload 15
    //   985: ldc2_w 300
    //   988: invokevirtual 227	java/lang/Object:wait	(J)V
    //   991: goto +48 -> 1039
    //   994: astore 9
    //   996: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   999: ifeq +40 -> 1039
    //   1002: new 18	java/lang/StringBuilder
    //   1005: dup
    //   1006: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   1009: astore 12
    //   1011: aload 12
    //   1013: ldc_w 303
    //   1016: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1019: pop
    //   1020: aload 12
    //   1022: aload 9
    //   1024: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1027: pop
    //   1028: ldc 122
    //   1030: iconst_2
    //   1031: aload 12
    //   1033: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1036: invokestatic 156	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1039: aload 15
    //   1041: invokeinterface 292 1 0
    //   1046: ifle +16 -> 1062
    //   1049: aload 15
    //   1051: new 305	com/tencent/mobileqq/activity/aio/doodle/LoadDataJob$SortComparator
    //   1054: dup
    //   1055: aload_0
    //   1056: invokespecial 308	com/tencent/mobileqq/activity/aio/doodle/LoadDataJob$SortComparator:<init>	(Lcom/tencent/mobileqq/activity/aio/doodle/LoadDataJob;)V
    //   1059: invokestatic 314	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   1062: aload 15
    //   1064: monitorexit
    //   1065: aload_2
    //   1066: astore 14
    //   1068: iload 7
    //   1070: istore 8
    //   1072: aload 10
    //   1074: astore 13
    //   1076: aload 11
    //   1078: astore 12
    //   1080: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1083: ifeq +27 -> 1110
    //   1086: aload_2
    //   1087: astore 14
    //   1089: iload 7
    //   1091: istore 8
    //   1093: aload 10
    //   1095: astore 13
    //   1097: aload 11
    //   1099: astore 12
    //   1101: ldc 122
    //   1103: iconst_2
    //   1104: ldc_w 316
    //   1107: invokestatic 156	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1110: aload 11
    //   1112: ifnull +55 -> 1167
    //   1115: aload 11
    //   1117: invokevirtual 146	java/nio/channels/FileLock:release	()V
    //   1120: goto +47 -> 1167
    //   1123: astore 9
    //   1125: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1128: ifeq +39 -> 1167
    //   1131: new 18	java/lang/StringBuilder
    //   1134: dup
    //   1135: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   1138: astore 11
    //   1140: aload 11
    //   1142: ldc 151
    //   1144: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1147: pop
    //   1148: aload 11
    //   1150: aload 9
    //   1152: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1155: pop
    //   1156: ldc 122
    //   1158: iconst_2
    //   1159: aload 11
    //   1161: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1164: invokestatic 156	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1167: aload 10
    //   1169: invokevirtual 159	java/io/FileInputStream:close	()V
    //   1172: goto +47 -> 1219
    //   1175: astore 9
    //   1177: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1180: ifeq +39 -> 1219
    //   1183: new 18	java/lang/StringBuilder
    //   1186: dup
    //   1187: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   1190: astore 10
    //   1192: aload 10
    //   1194: ldc 151
    //   1196: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1199: pop
    //   1200: aload 10
    //   1202: aload 9
    //   1204: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1207: pop
    //   1208: ldc 122
    //   1210: iconst_2
    //   1211: aload 10
    //   1213: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1216: invokestatic 156	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1219: aload_2
    //   1220: ifnull +52 -> 1272
    //   1223: aload_2
    //   1224: invokevirtual 160	java/io/InputStream:close	()V
    //   1227: goto +45 -> 1272
    //   1230: astore_2
    //   1231: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1234: ifeq +38 -> 1272
    //   1237: new 18	java/lang/StringBuilder
    //   1240: dup
    //   1241: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   1244: astore 9
    //   1246: aload 9
    //   1248: ldc 151
    //   1250: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1253: pop
    //   1254: aload 9
    //   1256: aload_2
    //   1257: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1260: pop
    //   1261: ldc 122
    //   1263: iconst_2
    //   1264: aload 9
    //   1266: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1269: invokestatic 156	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1272: iload 6
    //   1274: istore 8
    //   1276: iload 7
    //   1278: ifne +750 -> 2028
    //   1281: iload 6
    //   1283: istore 7
    //   1285: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1288: ifeq +16 -> 1304
    //   1291: ldc 122
    //   1293: iconst_2
    //   1294: ldc_w 318
    //   1297: invokestatic 156	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1300: iload 6
    //   1302: istore 7
    //   1304: aload_1
    //   1305: invokestatic 168	com/tencent/mobileqq/utils/FileUtils:deleteFile	(Ljava/lang/String;)Z
    //   1308: pop
    //   1309: aload 15
    //   1311: invokeinterface 319 1 0
    //   1316: iload 7
    //   1318: istore 8
    //   1320: goto +708 -> 2028
    //   1323: astore 9
    //   1325: aload 15
    //   1327: monitorexit
    //   1328: aload_2
    //   1329: astore 14
    //   1331: iload 7
    //   1333: istore 8
    //   1335: aload 10
    //   1337: astore 13
    //   1339: aload 11
    //   1341: astore 12
    //   1343: aload 9
    //   1345: athrow
    //   1346: astore 9
    //   1348: goto +72 -> 1420
    //   1351: astore 9
    //   1353: goto +394 -> 1747
    //   1356: astore_2
    //   1357: goto +31 -> 1388
    //   1360: astore 9
    //   1362: goto +47 -> 1409
    //   1365: astore 9
    //   1367: goto +372 -> 1739
    //   1370: astore_2
    //   1371: goto +14 -> 1385
    //   1374: astore 9
    //   1376: goto +30 -> 1406
    //   1379: astore 9
    //   1381: goto +355 -> 1736
    //   1384: astore_2
    //   1385: aconst_null
    //   1386: astore 10
    //   1388: aconst_null
    //   1389: astore 11
    //   1391: aconst_null
    //   1392: astore 9
    //   1394: iconst_1
    //   1395: istore 6
    //   1397: aload 10
    //   1399: astore 13
    //   1401: goto +670 -> 2071
    //   1404: astore 9
    //   1406: aconst_null
    //   1407: astore 10
    //   1409: iconst_1
    //   1410: istore 7
    //   1412: aconst_null
    //   1413: astore_2
    //   1414: iconst_0
    //   1415: istore 6
    //   1417: aconst_null
    //   1418: astore 11
    //   1420: aload_2
    //   1421: astore 14
    //   1423: iload 7
    //   1425: istore 8
    //   1427: aload 10
    //   1429: astore 13
    //   1431: aload 11
    //   1433: astore 12
    //   1435: aload 9
    //   1437: invokevirtual 149	java/lang/Exception:printStackTrace	()V
    //   1440: aload_2
    //   1441: astore 14
    //   1443: aload 10
    //   1445: astore 12
    //   1447: aload 11
    //   1449: astore 13
    //   1451: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1454: ifeq +84 -> 1538
    //   1457: aload_2
    //   1458: astore 14
    //   1460: aload 10
    //   1462: astore 12
    //   1464: aload 11
    //   1466: astore 13
    //   1468: new 18	java/lang/StringBuilder
    //   1471: dup
    //   1472: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   1475: astore 16
    //   1477: aload_2
    //   1478: astore 14
    //   1480: aload 10
    //   1482: astore 12
    //   1484: aload 11
    //   1486: astore 13
    //   1488: aload 16
    //   1490: ldc_w 321
    //   1493: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1496: pop
    //   1497: aload_2
    //   1498: astore 14
    //   1500: aload 10
    //   1502: astore 12
    //   1504: aload 11
    //   1506: astore 13
    //   1508: aload 16
    //   1510: aload 9
    //   1512: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1515: pop
    //   1516: aload_2
    //   1517: astore 14
    //   1519: aload 10
    //   1521: astore 12
    //   1523: aload 11
    //   1525: astore 13
    //   1527: ldc 122
    //   1529: iconst_2
    //   1530: aload 16
    //   1532: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1535: invokestatic 156	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1538: aload 11
    //   1540: ifnull +55 -> 1595
    //   1543: aload 11
    //   1545: invokevirtual 146	java/nio/channels/FileLock:release	()V
    //   1548: goto +47 -> 1595
    //   1551: astore 9
    //   1553: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1556: ifeq +39 -> 1595
    //   1559: new 18	java/lang/StringBuilder
    //   1562: dup
    //   1563: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   1566: astore 11
    //   1568: aload 11
    //   1570: ldc 151
    //   1572: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1575: pop
    //   1576: aload 11
    //   1578: aload 9
    //   1580: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1583: pop
    //   1584: ldc 122
    //   1586: iconst_2
    //   1587: aload 11
    //   1589: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1592: invokestatic 156	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1595: aload 10
    //   1597: ifnull +55 -> 1652
    //   1600: aload 10
    //   1602: invokevirtual 159	java/io/FileInputStream:close	()V
    //   1605: goto +47 -> 1652
    //   1608: astore 9
    //   1610: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1613: ifeq +39 -> 1652
    //   1616: new 18	java/lang/StringBuilder
    //   1619: dup
    //   1620: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   1623: astore 10
    //   1625: aload 10
    //   1627: ldc 151
    //   1629: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1632: pop
    //   1633: aload 10
    //   1635: aload 9
    //   1637: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1640: pop
    //   1641: ldc 122
    //   1643: iconst_2
    //   1644: aload 10
    //   1646: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1649: invokestatic 156	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1652: aload_2
    //   1653: ifnull +52 -> 1705
    //   1656: aload_2
    //   1657: invokevirtual 160	java/io/InputStream:close	()V
    //   1660: goto +45 -> 1705
    //   1663: astore_2
    //   1664: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1667: ifeq +38 -> 1705
    //   1670: new 18	java/lang/StringBuilder
    //   1673: dup
    //   1674: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   1677: astore 9
    //   1679: aload 9
    //   1681: ldc 151
    //   1683: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1686: pop
    //   1687: aload 9
    //   1689: aload_2
    //   1690: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1693: pop
    //   1694: ldc 122
    //   1696: iconst_2
    //   1697: aload 9
    //   1699: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1702: invokestatic 156	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1705: iload 6
    //   1707: istore 7
    //   1709: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1712: ifeq -408 -> 1304
    //   1715: goto -424 -> 1291
    //   1718: astore_2
    //   1719: aload 14
    //   1721: astore 9
    //   1723: iload 8
    //   1725: istore 6
    //   1727: aload 12
    //   1729: astore 11
    //   1731: goto +340 -> 2071
    //   1734: astore 9
    //   1736: aconst_null
    //   1737: astore 10
    //   1739: aconst_null
    //   1740: astore_2
    //   1741: iconst_0
    //   1742: istore 6
    //   1744: aconst_null
    //   1745: astore 11
    //   1747: aload_2
    //   1748: astore 14
    //   1750: aload 10
    //   1752: astore 12
    //   1754: aload 11
    //   1756: astore 13
    //   1758: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1761: ifeq +87 -> 1848
    //   1764: aload_2
    //   1765: astore 14
    //   1767: aload 10
    //   1769: astore 12
    //   1771: aload 11
    //   1773: astore 13
    //   1775: new 18	java/lang/StringBuilder
    //   1778: dup
    //   1779: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   1782: astore 16
    //   1784: aload_2
    //   1785: astore 14
    //   1787: aload 10
    //   1789: astore 12
    //   1791: aload 11
    //   1793: astore 13
    //   1795: aload 16
    //   1797: ldc_w 323
    //   1800: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1803: pop
    //   1804: aload_2
    //   1805: astore 14
    //   1807: aload 10
    //   1809: astore 12
    //   1811: aload 11
    //   1813: astore 13
    //   1815: aload 16
    //   1817: aload 9
    //   1819: invokevirtual 324	java/lang/OutOfMemoryError:toString	()Ljava/lang/String;
    //   1822: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1825: pop
    //   1826: aload_2
    //   1827: astore 14
    //   1829: aload 10
    //   1831: astore 12
    //   1833: aload 11
    //   1835: astore 13
    //   1837: ldc 122
    //   1839: iconst_2
    //   1840: aload 16
    //   1842: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1845: invokestatic 156	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1848: aload 11
    //   1850: ifnull +55 -> 1905
    //   1853: aload 11
    //   1855: invokevirtual 146	java/nio/channels/FileLock:release	()V
    //   1858: goto +47 -> 1905
    //   1861: astore 9
    //   1863: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1866: ifeq +39 -> 1905
    //   1869: new 18	java/lang/StringBuilder
    //   1872: dup
    //   1873: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   1876: astore 11
    //   1878: aload 11
    //   1880: ldc 151
    //   1882: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1885: pop
    //   1886: aload 11
    //   1888: aload 9
    //   1890: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1893: pop
    //   1894: ldc 122
    //   1896: iconst_2
    //   1897: aload 11
    //   1899: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1902: invokestatic 156	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1905: aload 10
    //   1907: ifnull +55 -> 1962
    //   1910: aload 10
    //   1912: invokevirtual 159	java/io/FileInputStream:close	()V
    //   1915: goto +47 -> 1962
    //   1918: astore 9
    //   1920: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1923: ifeq +39 -> 1962
    //   1926: new 18	java/lang/StringBuilder
    //   1929: dup
    //   1930: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   1933: astore 10
    //   1935: aload 10
    //   1937: ldc 151
    //   1939: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1942: pop
    //   1943: aload 10
    //   1945: aload 9
    //   1947: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1950: pop
    //   1951: ldc 122
    //   1953: iconst_2
    //   1954: aload 10
    //   1956: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1959: invokestatic 156	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1962: aload_2
    //   1963: ifnull +52 -> 2015
    //   1966: aload_2
    //   1967: invokevirtual 160	java/io/InputStream:close	()V
    //   1970: goto +45 -> 2015
    //   1973: astore_2
    //   1974: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1977: ifeq +38 -> 2015
    //   1980: new 18	java/lang/StringBuilder
    //   1983: dup
    //   1984: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   1987: astore 9
    //   1989: aload 9
    //   1991: ldc 151
    //   1993: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1996: pop
    //   1997: aload 9
    //   1999: aload_2
    //   2000: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2003: pop
    //   2004: ldc 122
    //   2006: iconst_2
    //   2007: aload 9
    //   2009: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2012: invokestatic 156	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2015: iload 6
    //   2017: istore 7
    //   2019: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2022: ifeq -718 -> 1304
    //   2025: goto -734 -> 1291
    //   2028: aload 15
    //   2030: astore_1
    //   2031: iload 8
    //   2033: ifeq +20 -> 2053
    //   2036: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2039: ifeq +12 -> 2051
    //   2042: ldc 122
    //   2044: iconst_2
    //   2045: ldc_w 326
    //   2048: invokestatic 156	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2051: aconst_null
    //   2052: astore_1
    //   2053: aload_1
    //   2054: areturn
    //   2055: astore_2
    //   2056: aload 14
    //   2058: astore 9
    //   2060: iconst_0
    //   2061: istore 6
    //   2063: aload 13
    //   2065: astore 11
    //   2067: aload 12
    //   2069: astore 13
    //   2071: aload 11
    //   2073: ifnull +55 -> 2128
    //   2076: aload 11
    //   2078: invokevirtual 146	java/nio/channels/FileLock:release	()V
    //   2081: goto +47 -> 2128
    //   2084: astore 10
    //   2086: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2089: ifeq +39 -> 2128
    //   2092: new 18	java/lang/StringBuilder
    //   2095: dup
    //   2096: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   2099: astore 11
    //   2101: aload 11
    //   2103: ldc 151
    //   2105: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2108: pop
    //   2109: aload 11
    //   2111: aload 10
    //   2113: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2116: pop
    //   2117: ldc 122
    //   2119: iconst_2
    //   2120: aload 11
    //   2122: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2125: invokestatic 156	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2128: aload 13
    //   2130: ifnull +55 -> 2185
    //   2133: aload 13
    //   2135: invokevirtual 159	java/io/FileInputStream:close	()V
    //   2138: goto +47 -> 2185
    //   2141: astore 10
    //   2143: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2146: ifeq +39 -> 2185
    //   2149: new 18	java/lang/StringBuilder
    //   2152: dup
    //   2153: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   2156: astore 11
    //   2158: aload 11
    //   2160: ldc 151
    //   2162: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2165: pop
    //   2166: aload 11
    //   2168: aload 10
    //   2170: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2173: pop
    //   2174: ldc 122
    //   2176: iconst_2
    //   2177: aload 11
    //   2179: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2182: invokestatic 156	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2185: aload 9
    //   2187: ifnull +55 -> 2242
    //   2190: aload 9
    //   2192: invokevirtual 160	java/io/InputStream:close	()V
    //   2195: goto +47 -> 2242
    //   2198: astore 9
    //   2200: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2203: ifeq +39 -> 2242
    //   2206: new 18	java/lang/StringBuilder
    //   2209: dup
    //   2210: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   2213: astore 10
    //   2215: aload 10
    //   2217: ldc 151
    //   2219: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2222: pop
    //   2223: aload 10
    //   2225: aload 9
    //   2227: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2230: pop
    //   2231: ldc 122
    //   2233: iconst_2
    //   2234: aload 10
    //   2236: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2239: invokestatic 156	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2242: iload 6
    //   2244: ifne +30 -> 2274
    //   2247: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2250: ifeq +12 -> 2262
    //   2253: ldc 122
    //   2255: iconst_2
    //   2256: ldc_w 318
    //   2259: invokestatic 156	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2262: aload_1
    //   2263: invokestatic 168	com/tencent/mobileqq/utils/FileUtils:deleteFile	(Ljava/lang/String;)Z
    //   2266: pop
    //   2267: aload 15
    //   2269: invokeinterface 319 1 0
    //   2274: goto +5 -> 2279
    //   2277: aload_2
    //   2278: athrow
    //   2279: goto -2 -> 2277
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2282	0	this	LoadDataJob
    //   0	2282	1	paramString	String
    //   0	2282	2	paramLoadDataJobListener	LoadDataJob.LoadDataJobListener
    //   80	896	3	i	int
    //   101	875	4	j	int
    //   134	7	5	k	int
    //   190	2053	6	bool1	boolean
    //   82	1936	7	bool2	boolean
    //   834	1198	8	bool3	boolean
    //   72	718	9	localObject1	Object
    //   798	1	9	localException1	Exception
    //   811	1	9	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   870	81	9	localStringBuilder1	StringBuilder
    //   994	29	9	localException2	Exception
    //   1123	28	9	localException3	Exception
    //   1175	28	9	localException4	Exception
    //   1244	21	9	localStringBuilder2	StringBuilder
    //   1323	21	9	localObject2	Object
    //   1346	1	9	localException5	Exception
    //   1351	1	9	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   1360	1	9	localException6	Exception
    //   1365	1	9	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   1374	1	9	localException7	Exception
    //   1379	1	9	localOutOfMemoryError4	java.lang.OutOfMemoryError
    //   1392	1	9	localObject3	Object
    //   1404	107	9	localException8	Exception
    //   1551	28	9	localException9	Exception
    //   1608	28	9	localException10	Exception
    //   1677	45	9	localObject4	Object
    //   1734	84	9	localOutOfMemoryError5	java.lang.OutOfMemoryError
    //   1861	28	9	localException11	Exception
    //   1918	28	9	localException12	Exception
    //   1987	204	9	localObject5	Object
    //   2198	28	9	localException13	Exception
    //   41	1914	10	localObject6	Object
    //   2084	28	10	localException14	Exception
    //   2141	28	10	localException15	Exception
    //   2213	22	10	localStringBuilder3	StringBuilder
    //   56	2122	11	localObject7	Object
    //   26	1	12	localHashMap	HashMap
    //   184	370	12	localException16	Exception
    //   558	9	12	localException17	Exception
    //   573	123	12	localOutOfMemoryError6	java.lang.OutOfMemoryError
    //   764	9	12	localException18	Exception
    //   779	9	12	localOutOfMemoryError7	java.lang.OutOfMemoryError
    //   842	1226	12	localObject8	Object
    //   77	2057	13	localObject9	Object
    //   122	1935	14	localObject10	Object
    //   7	2261	15	localArrayList	ArrayList
    //   255	27	16	localStringBuilder4	StringBuilder
    //   300	28	16	localException19	Exception
    //   604	1237	16	localStringBuilder5	StringBuilder
    //   315	22	17	localStringBuilder6	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   143	181	184	java/lang/Exception
    //   242	289	300	java/lang/Exception
    //   289	297	300	java/lang/Exception
    //   480	493	537	finally
    //   538	541	537	finally
    //   377	390	552	finally
    //   392	418	552	finally
    //   425	435	552	finally
    //   553	556	552	finally
    //   374	377	558	java/lang/Exception
    //   435	473	558	java/lang/Exception
    //   477	480	558	java/lang/Exception
    //   493	534	558	java/lang/Exception
    //   541	543	558	java/lang/Exception
    //   556	558	558	java/lang/Exception
    //   374	377	573	java/lang/OutOfMemoryError
    //   435	473	573	java/lang/OutOfMemoryError
    //   477	480	573	java/lang/OutOfMemoryError
    //   493	534	573	java/lang/OutOfMemoryError
    //   541	543	573	java/lang/OutOfMemoryError
    //   556	558	573	java/lang/OutOfMemoryError
    //   657	670	682	finally
    //   683	686	682	finally
    //   591	633	688	finally
    //   633	647	688	finally
    //   651	654	688	finally
    //   689	692	688	finally
    //   227	236	694	finally
    //   242	289	694	finally
    //   289	297	694	finally
    //   302	344	694	finally
    //   344	347	694	finally
    //   695	698	694	finally
    //   74	79	760	finally
    //   84	103	760	finally
    //   118	136	760	finally
    //   143	181	760	finally
    //   199	227	760	finally
    //   347	374	760	finally
    //   374	377	760	finally
    //   435	473	760	finally
    //   477	480	760	finally
    //   493	534	760	finally
    //   541	543	760	finally
    //   556	558	760	finally
    //   588	591	760	finally
    //   654	657	760	finally
    //   670	679	760	finally
    //   686	688	760	finally
    //   692	694	760	finally
    //   698	700	760	finally
    //   700	739	760	finally
    //   74	79	764	java/lang/Exception
    //   84	103	764	java/lang/Exception
    //   118	136	764	java/lang/Exception
    //   199	227	764	java/lang/Exception
    //   347	374	764	java/lang/Exception
    //   588	591	764	java/lang/Exception
    //   654	657	764	java/lang/Exception
    //   670	679	764	java/lang/Exception
    //   686	688	764	java/lang/Exception
    //   692	694	764	java/lang/Exception
    //   698	700	764	java/lang/Exception
    //   700	739	764	java/lang/Exception
    //   74	79	779	java/lang/OutOfMemoryError
    //   84	103	779	java/lang/OutOfMemoryError
    //   118	136	779	java/lang/OutOfMemoryError
    //   143	181	779	java/lang/OutOfMemoryError
    //   199	227	779	java/lang/OutOfMemoryError
    //   347	374	779	java/lang/OutOfMemoryError
    //   588	591	779	java/lang/OutOfMemoryError
    //   654	657	779	java/lang/OutOfMemoryError
    //   670	679	779	java/lang/OutOfMemoryError
    //   686	688	779	java/lang/OutOfMemoryError
    //   692	694	779	java/lang/OutOfMemoryError
    //   698	700	779	java/lang/OutOfMemoryError
    //   700	739	779	java/lang/OutOfMemoryError
    //   63	74	794	finally
    //   63	74	798	java/lang/Exception
    //   63	74	811	java/lang/OutOfMemoryError
    //   983	991	994	java/lang/Exception
    //   1115	1120	1123	java/lang/Exception
    //   1167	1172	1175	java/lang/Exception
    //   1223	1227	1230	java/lang/Exception
    //   847	958	1323	finally
    //   958	972	1323	finally
    //   983	991	1323	finally
    //   996	1039	1323	finally
    //   1039	1062	1323	finally
    //   1062	1065	1323	finally
    //   1325	1328	1323	finally
    //   844	847	1346	java/lang/Exception
    //   1080	1086	1346	java/lang/Exception
    //   1101	1110	1346	java/lang/Exception
    //   1343	1346	1346	java/lang/Exception
    //   844	847	1351	java/lang/OutOfMemoryError
    //   1080	1086	1351	java/lang/OutOfMemoryError
    //   1101	1110	1351	java/lang/OutOfMemoryError
    //   1343	1346	1351	java/lang/OutOfMemoryError
    //   43	58	1356	finally
    //   43	58	1360	java/lang/Exception
    //   43	58	1365	java/lang/OutOfMemoryError
    //   33	43	1370	finally
    //   33	43	1374	java/lang/Exception
    //   33	43	1379	java/lang/OutOfMemoryError
    //   28	33	1384	finally
    //   28	33	1404	java/lang/Exception
    //   1543	1548	1551	java/lang/Exception
    //   1600	1605	1608	java/lang/Exception
    //   1656	1660	1663	java/lang/Exception
    //   844	847	1718	finally
    //   1080	1086	1718	finally
    //   1101	1110	1718	finally
    //   1343	1346	1718	finally
    //   1435	1440	1718	finally
    //   28	33	1734	java/lang/OutOfMemoryError
    //   1853	1858	1861	java/lang/Exception
    //   1910	1915	1918	java/lang/Exception
    //   1966	1970	1973	java/lang/Exception
    //   1451	1457	2055	finally
    //   1468	1477	2055	finally
    //   1488	1497	2055	finally
    //   1508	1516	2055	finally
    //   1527	1538	2055	finally
    //   1758	1764	2055	finally
    //   1775	1784	2055	finally
    //   1795	1804	2055	finally
    //   1815	1826	2055	finally
    //   1837	1848	2055	finally
    //   2076	2081	2084	java/lang/Exception
    //   2133	2138	2141	java/lang/Exception
    //   2190	2195	2198	java/lang/Exception
  }
  
  private List<PathDrawer> a(List<PathData> paramList, Rect paramRect)
  {
    Object localObject = paramList.iterator();
    long l = 0L;
    while (((Iterator)localObject).hasNext())
    {
      PathData localPathData = (PathData)((Iterator)localObject).next();
      if (localPathData.b() != null) {
        l += localPathData.b().a();
      }
    }
    int i;
    int j;
    if (l <= 3000L)
    {
      i = 10;
      j = 30;
    }
    else if (l <= 20000L)
    {
      i = 20;
      j = 37;
    }
    else
    {
      i = 50;
      j = 45;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setPathDatas params: totaltime:");
      ((StringBuilder)localObject).append(l);
      ((StringBuilder)localObject).append("  segmentLen:");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(" timeInterval:");
      ((StringBuilder)localObject).append(j);
      QLog.d("LoadDataJob", 2, ((StringBuilder)localObject).toString());
    }
    localObject = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      ((ArrayList)localObject).add(new PathDrawer((PathData)paramList.next(), paramRect.width(), paramRect.height(), this.jdField_b_of_type_Int, this.c, i, j, 1.0F));
    }
    Collections.sort((List)localObject, new LoadDataJob.SortComparator(this));
    return localObject;
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
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(jdField_b_of_type_JavaLangString);
      localStringBuilder.append(paramString.substring(paramString.lastIndexOf(File.separator) + 1, paramString.lastIndexOf('_')));
      localStringBuilder.append("_prm");
      paramString = localStringBuilder.toString();
      if (paramBoolean)
      {
        paramBoolean = FileUtils.fileExists(paramString);
        if (paramBoolean) {
          return paramString;
        }
        return null;
      }
      return paramString;
    }
    catch (Exception paramString) {}
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
    //   0: aload_1
    //   1: ifnull +819 -> 820
    //   4: aload_2
    //   5: invokestatic 72	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8: ifeq +4 -> 12
    //   11: return
    //   12: aload_2
    //   13: invokestatic 192	com/tencent/mobileqq/utils/FileUtils:fileExists	(Ljava/lang/String;)Z
    //   16: ifeq +4 -> 20
    //   19: return
    //   20: new 18	java/lang/StringBuilder
    //   23: dup
    //   24: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   27: astore_3
    //   28: aload_3
    //   29: aload_2
    //   30: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: pop
    //   34: aload_3
    //   35: ldc_w 410
    //   38: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: pop
    //   42: aload_3
    //   43: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   46: astore 10
    //   48: aconst_null
    //   49: astore 8
    //   51: aconst_null
    //   52: astore 6
    //   54: aconst_null
    //   55: astore 4
    //   57: aconst_null
    //   58: astore 7
    //   60: aconst_null
    //   61: astore 5
    //   63: aconst_null
    //   64: astore 9
    //   66: new 412	java/io/FileOutputStream
    //   69: dup
    //   70: aload 10
    //   72: invokespecial 413	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   75: astore_3
    //   76: aload 9
    //   78: astore 4
    //   80: aload 8
    //   82: astore 5
    //   84: aload_3
    //   85: invokevirtual 414	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   88: invokevirtual 417	java/nio/channels/FileChannel:tryLock	()Ljava/nio/channels/FileLock;
    //   91: astore 7
    //   93: aload 7
    //   95: ifnull +90 -> 185
    //   98: aload 7
    //   100: astore 4
    //   102: aload 7
    //   104: astore 5
    //   106: aload 7
    //   108: astore 6
    //   110: aload_3
    //   111: invokevirtual 414	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   114: lconst_0
    //   115: invokevirtual 421	java/nio/channels/FileChannel:position	(J)Ljava/nio/channels/FileChannel;
    //   118: pop
    //   119: aload 7
    //   121: astore 4
    //   123: aload 7
    //   125: astore 5
    //   127: aload 7
    //   129: astore 6
    //   131: aload_0
    //   132: aload_1
    //   133: invokevirtual 423	com/tencent/mobileqq/activity/aio/doodle/LoadDataJob:a	(Lcom/tencent/mobileqq/activity/aio/doodle/MyParcelable;)Lcom/tencent/mobileqq/activity/aio/doodle/MyParcel$DataElement;
    //   136: astore_1
    //   137: aload 7
    //   139: astore 4
    //   141: aload 7
    //   143: astore 5
    //   145: aload 7
    //   147: astore 6
    //   149: aload_3
    //   150: aload_1
    //   151: getfield 426	com/tencent/mobileqq/activity/aio/doodle/MyParcel$DataElement:jdField_a_of_type_Int	I
    //   154: invokestatic 429	com/tencent/mobileqq/activity/aio/doodle/DoodleMsgTranslator:a	(I)[B
    //   157: invokevirtual 433	java/io/FileOutputStream:write	([B)V
    //   160: aload 7
    //   162: astore 4
    //   164: aload 7
    //   166: astore 5
    //   168: aload 7
    //   170: astore 6
    //   172: aload_3
    //   173: aload_1
    //   174: getfield 436	com/tencent/mobileqq/activity/aio/doodle/MyParcel$DataElement:jdField_a_of_type_ArrayOfByte	[B
    //   177: iconst_0
    //   178: aload_1
    //   179: getfield 426	com/tencent/mobileqq/activity/aio/doodle/MyParcel$DataElement:jdField_a_of_type_Int	I
    //   182: invokevirtual 438	java/io/FileOutputStream:write	([BII)V
    //   185: aload 7
    //   187: ifnull +54 -> 241
    //   190: aload 7
    //   192: invokevirtual 146	java/nio/channels/FileLock:release	()V
    //   195: goto +46 -> 241
    //   198: astore_1
    //   199: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   202: ifeq +39 -> 241
    //   205: new 18	java/lang/StringBuilder
    //   208: dup
    //   209: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   212: astore 4
    //   214: aload 4
    //   216: ldc_w 440
    //   219: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: pop
    //   223: aload 4
    //   225: aload_1
    //   226: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   229: pop
    //   230: ldc 122
    //   232: iconst_2
    //   233: aload 4
    //   235: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   238: invokestatic 126	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   241: aload_3
    //   242: invokevirtual 441	java/io/FileOutputStream:close	()V
    //   245: goto +451 -> 696
    //   248: astore_3
    //   249: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   252: ifeq +444 -> 696
    //   255: new 18	java/lang/StringBuilder
    //   258: dup
    //   259: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   262: astore_1
    //   263: goto +409 -> 672
    //   266: astore 5
    //   268: aload_3
    //   269: astore_1
    //   270: aload 4
    //   272: astore_3
    //   273: aload 5
    //   275: astore 4
    //   277: goto +429 -> 706
    //   280: astore 6
    //   282: aload_3
    //   283: astore 4
    //   285: goto +32 -> 317
    //   288: astore_1
    //   289: aload 6
    //   291: astore 5
    //   293: aload_3
    //   294: astore 4
    //   296: aload_1
    //   297: astore 6
    //   299: goto +220 -> 519
    //   302: astore 4
    //   304: aconst_null
    //   305: astore_3
    //   306: aload 5
    //   308: astore_1
    //   309: goto +397 -> 706
    //   312: astore 6
    //   314: aconst_null
    //   315: astore 5
    //   317: aload 4
    //   319: astore_1
    //   320: aload 5
    //   322: astore_3
    //   323: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   326: ifeq +64 -> 390
    //   329: aload 4
    //   331: astore_1
    //   332: aload 5
    //   334: astore_3
    //   335: new 18	java/lang/StringBuilder
    //   338: dup
    //   339: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   342: astore 7
    //   344: aload 4
    //   346: astore_1
    //   347: aload 5
    //   349: astore_3
    //   350: aload 7
    //   352: ldc_w 443
    //   355: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   358: pop
    //   359: aload 4
    //   361: astore_1
    //   362: aload 5
    //   364: astore_3
    //   365: aload 7
    //   367: aload 6
    //   369: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   372: pop
    //   373: aload 4
    //   375: astore_1
    //   376: aload 5
    //   378: astore_3
    //   379: ldc 122
    //   381: iconst_2
    //   382: aload 7
    //   384: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   387: invokestatic 126	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   390: aload 5
    //   392: ifnull +50 -> 442
    //   395: aload 5
    //   397: invokevirtual 146	java/nio/channels/FileLock:release	()V
    //   400: goto +42 -> 442
    //   403: astore_1
    //   404: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   407: ifeq +35 -> 442
    //   410: new 18	java/lang/StringBuilder
    //   413: dup
    //   414: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   417: astore_2
    //   418: aload_2
    //   419: ldc_w 440
    //   422: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   425: pop
    //   426: aload_2
    //   427: aload_1
    //   428: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   431: pop
    //   432: ldc 122
    //   434: iconst_2
    //   435: aload_2
    //   436: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   439: invokestatic 126	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   442: aload 4
    //   444: ifnull +50 -> 494
    //   447: aload 4
    //   449: invokevirtual 441	java/io/FileOutputStream:close	()V
    //   452: goto +42 -> 494
    //   455: astore_1
    //   456: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   459: ifeq +35 -> 494
    //   462: new 18	java/lang/StringBuilder
    //   465: dup
    //   466: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   469: astore_2
    //   470: aload_2
    //   471: ldc_w 440
    //   474: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   477: pop
    //   478: aload_2
    //   479: aload_1
    //   480: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   483: pop
    //   484: ldc 122
    //   486: iconst_2
    //   487: aload_2
    //   488: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   491: invokestatic 126	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   494: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   497: ifeq +206 -> 703
    //   500: ldc 122
    //   502: iconst_2
    //   503: ldc_w 445
    //   506: invokestatic 126	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   509: return
    //   510: astore 6
    //   512: aconst_null
    //   513: astore 5
    //   515: aload 7
    //   517: astore 4
    //   519: aload 4
    //   521: astore_1
    //   522: aload 5
    //   524: astore_3
    //   525: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   528: ifeq +64 -> 592
    //   531: aload 4
    //   533: astore_1
    //   534: aload 5
    //   536: astore_3
    //   537: new 18	java/lang/StringBuilder
    //   540: dup
    //   541: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   544: astore 7
    //   546: aload 4
    //   548: astore_1
    //   549: aload 5
    //   551: astore_3
    //   552: aload 7
    //   554: ldc_w 447
    //   557: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   560: pop
    //   561: aload 4
    //   563: astore_1
    //   564: aload 5
    //   566: astore_3
    //   567: aload 7
    //   569: aload 6
    //   571: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   574: pop
    //   575: aload 4
    //   577: astore_1
    //   578: aload 5
    //   580: astore_3
    //   581: ldc 122
    //   583: iconst_2
    //   584: aload 7
    //   586: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   589: invokestatic 156	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   592: aload 5
    //   594: ifnull +50 -> 644
    //   597: aload 5
    //   599: invokevirtual 146	java/nio/channels/FileLock:release	()V
    //   602: goto +42 -> 644
    //   605: astore_1
    //   606: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   609: ifeq +35 -> 644
    //   612: new 18	java/lang/StringBuilder
    //   615: dup
    //   616: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   619: astore_3
    //   620: aload_3
    //   621: ldc_w 440
    //   624: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   627: pop
    //   628: aload_3
    //   629: aload_1
    //   630: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   633: pop
    //   634: ldc 122
    //   636: iconst_2
    //   637: aload_3
    //   638: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   641: invokestatic 126	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   644: aload 4
    //   646: ifnull +50 -> 696
    //   649: aload 4
    //   651: invokevirtual 441	java/io/FileOutputStream:close	()V
    //   654: goto +42 -> 696
    //   657: astore_3
    //   658: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   661: ifeq +35 -> 696
    //   664: new 18	java/lang/StringBuilder
    //   667: dup
    //   668: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   671: astore_1
    //   672: aload_1
    //   673: ldc_w 440
    //   676: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   679: pop
    //   680: aload_1
    //   681: aload_3
    //   682: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   685: pop
    //   686: ldc 122
    //   688: iconst_2
    //   689: aload_1
    //   690: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   693: invokestatic 126	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   696: aload 10
    //   698: aload_2
    //   699: invokestatic 451	com/tencent/mobileqq/utils/FileUtils:rename	(Ljava/lang/String;Ljava/lang/String;)Z
    //   702: pop
    //   703: return
    //   704: astore 4
    //   706: aload_3
    //   707: ifnull +53 -> 760
    //   710: aload_3
    //   711: invokevirtual 146	java/nio/channels/FileLock:release	()V
    //   714: goto +46 -> 760
    //   717: astore_3
    //   718: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   721: ifeq +39 -> 760
    //   724: new 18	java/lang/StringBuilder
    //   727: dup
    //   728: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   731: astore 5
    //   733: aload 5
    //   735: ldc_w 440
    //   738: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   741: pop
    //   742: aload 5
    //   744: aload_3
    //   745: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   748: pop
    //   749: ldc 122
    //   751: iconst_2
    //   752: aload 5
    //   754: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   757: invokestatic 126	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   760: aload_1
    //   761: ifnull +49 -> 810
    //   764: aload_1
    //   765: invokevirtual 441	java/io/FileOutputStream:close	()V
    //   768: goto +42 -> 810
    //   771: astore_1
    //   772: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   775: ifeq +35 -> 810
    //   778: new 18	java/lang/StringBuilder
    //   781: dup
    //   782: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   785: astore_3
    //   786: aload_3
    //   787: ldc_w 440
    //   790: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   793: pop
    //   794: aload_3
    //   795: aload_1
    //   796: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   799: pop
    //   800: ldc 122
    //   802: iconst_2
    //   803: aload_3
    //   804: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   807: invokestatic 126	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   810: aload 10
    //   812: aload_2
    //   813: invokestatic 451	com/tencent/mobileqq/utils/FileUtils:rename	(Ljava/lang/String;Ljava/lang/String;)Z
    //   816: pop
    //   817: aload 4
    //   819: athrow
    //   820: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	821	0	this	LoadDataJob
    //   0	821	1	paramDoodleParam	DoodleParam
    //   0	821	2	paramString	String
    //   27	215	3	localObject1	Object
    //   248	21	3	localException1	Exception
    //   272	366	3	localObject2	Object
    //   657	54	3	localException2	Exception
    //   717	28	3	localException3	Exception
    //   785	19	3	localStringBuilder	StringBuilder
    //   55	240	4	localObject3	Object
    //   302	146	4	localObject4	Object
    //   517	133	4	localObject5	Object
    //   704	114	4	localObject6	Object
    //   61	106	5	localObject7	Object
    //   266	8	5	localObject8	Object
    //   291	462	5	localObject9	Object
    //   52	119	6	localObject10	Object
    //   280	10	6	localException4	Exception
    //   297	1	6	localDoodleParam	DoodleParam
    //   312	56	6	localException5	Exception
    //   510	60	6	localOverlappingFileLockException	java.nio.channels.OverlappingFileLockException
    //   58	527	7	localObject11	Object
    //   49	32	8	localObject12	Object
    //   64	13	9	localObject13	Object
    //   46	765	10	str	String
    // Exception table:
    //   from	to	target	type
    //   190	195	198	java/lang/Exception
    //   241	245	248	java/lang/Exception
    //   84	93	266	finally
    //   110	119	266	finally
    //   131	137	266	finally
    //   149	160	266	finally
    //   172	185	266	finally
    //   84	93	280	java/lang/Exception
    //   110	119	280	java/lang/Exception
    //   131	137	280	java/lang/Exception
    //   149	160	280	java/lang/Exception
    //   172	185	280	java/lang/Exception
    //   84	93	288	java/nio/channels/OverlappingFileLockException
    //   110	119	288	java/nio/channels/OverlappingFileLockException
    //   131	137	288	java/nio/channels/OverlappingFileLockException
    //   149	160	288	java/nio/channels/OverlappingFileLockException
    //   172	185	288	java/nio/channels/OverlappingFileLockException
    //   66	76	302	finally
    //   66	76	312	java/lang/Exception
    //   395	400	403	java/lang/Exception
    //   447	452	455	java/lang/Exception
    //   66	76	510	java/nio/channels/OverlappingFileLockException
    //   597	602	605	java/lang/Exception
    //   649	654	657	java/lang/Exception
    //   323	329	704	finally
    //   335	344	704	finally
    //   350	359	704	finally
    //   365	373	704	finally
    //   379	390	704	finally
    //   525	531	704	finally
    //   537	546	704	finally
    //   552	561	704	finally
    //   567	575	704	finally
    //   581	592	704	finally
    //   710	714	717	java/lang/Exception
    //   764	768	771	java/lang/Exception
  }
  
  /* Error */
  public boolean a(List<PathDrawer> paramList, String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +938 -> 939
    //   4: aload_1
    //   5: invokeinterface 292 1 0
    //   10: ifeq +929 -> 939
    //   13: aload_2
    //   14: invokestatic 72	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   17: ifeq +5 -> 22
    //   20: iconst_0
    //   21: ireturn
    //   22: aload_2
    //   23: invokestatic 192	com/tencent/mobileqq/utils/FileUtils:fileExists	(Ljava/lang/String;)Z
    //   26: ifeq +5 -> 31
    //   29: iconst_0
    //   30: ireturn
    //   31: new 18	java/lang/StringBuilder
    //   34: dup
    //   35: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   38: astore_3
    //   39: aload_3
    //   40: aload_2
    //   41: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: pop
    //   45: aload_3
    //   46: ldc_w 410
    //   49: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: pop
    //   53: aload_3
    //   54: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: astore 10
    //   59: aconst_null
    //   60: astore 8
    //   62: aconst_null
    //   63: astore 9
    //   65: aconst_null
    //   66: astore 4
    //   68: aconst_null
    //   69: astore 5
    //   71: aconst_null
    //   72: astore 6
    //   74: aconst_null
    //   75: astore 7
    //   77: new 412	java/io/FileOutputStream
    //   80: dup
    //   81: aload 10
    //   83: iconst_0
    //   84: invokespecial 455	java/io/FileOutputStream:<init>	(Ljava/lang/String;Z)V
    //   87: astore_3
    //   88: aload 7
    //   90: astore 4
    //   92: aload 8
    //   94: astore 5
    //   96: aload 9
    //   98: astore 6
    //   100: aload_3
    //   101: invokevirtual 414	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   104: astore 11
    //   106: aload 7
    //   108: astore 4
    //   110: aload 8
    //   112: astore 5
    //   114: aload 9
    //   116: astore 6
    //   118: aload 11
    //   120: invokevirtual 417	java/nio/channels/FileChannel:tryLock	()Ljava/nio/channels/FileLock;
    //   123: astore 7
    //   125: aload 7
    //   127: ifnull +143 -> 270
    //   130: aload 7
    //   132: astore 4
    //   134: aload 7
    //   136: astore 5
    //   138: aload 7
    //   140: astore 6
    //   142: aload 11
    //   144: lconst_0
    //   145: invokevirtual 421	java/nio/channels/FileChannel:position	(J)Ljava/nio/channels/FileChannel;
    //   148: pop
    //   149: aload 7
    //   151: astore 4
    //   153: aload 7
    //   155: astore 5
    //   157: aload 7
    //   159: astore 6
    //   161: aload_1
    //   162: invokeinterface 330 1 0
    //   167: astore_1
    //   168: aload 7
    //   170: astore 4
    //   172: aload 7
    //   174: astore 5
    //   176: aload 7
    //   178: astore 6
    //   180: aload_1
    //   181: invokeinterface 250 1 0
    //   186: ifeq +84 -> 270
    //   189: aload 7
    //   191: astore 4
    //   193: aload 7
    //   195: astore 5
    //   197: aload 7
    //   199: astore 6
    //   201: aload_0
    //   202: aload_1
    //   203: invokeinterface 254 1 0
    //   208: checkcast 355	com/tencent/mobileqq/activity/aio/doodle/PathDrawer
    //   211: invokevirtual 423	com/tencent/mobileqq/activity/aio/doodle/LoadDataJob:a	(Lcom/tencent/mobileqq/activity/aio/doodle/MyParcelable;)Lcom/tencent/mobileqq/activity/aio/doodle/MyParcel$DataElement;
    //   214: astore 8
    //   216: aload 7
    //   218: astore 4
    //   220: aload 7
    //   222: astore 5
    //   224: aload 7
    //   226: astore 6
    //   228: aload_3
    //   229: aload 8
    //   231: getfield 426	com/tencent/mobileqq/activity/aio/doodle/MyParcel$DataElement:jdField_a_of_type_Int	I
    //   234: invokestatic 429	com/tencent/mobileqq/activity/aio/doodle/DoodleMsgTranslator:a	(I)[B
    //   237: invokevirtual 433	java/io/FileOutputStream:write	([B)V
    //   240: aload 7
    //   242: astore 4
    //   244: aload 7
    //   246: astore 5
    //   248: aload 7
    //   250: astore 6
    //   252: aload_3
    //   253: aload 8
    //   255: getfield 436	com/tencent/mobileqq/activity/aio/doodle/MyParcel$DataElement:jdField_a_of_type_ArrayOfByte	[B
    //   258: iconst_0
    //   259: aload 8
    //   261: getfield 426	com/tencent/mobileqq/activity/aio/doodle/MyParcel$DataElement:jdField_a_of_type_Int	I
    //   264: invokevirtual 438	java/io/FileOutputStream:write	([BII)V
    //   267: goto -99 -> 168
    //   270: aload 7
    //   272: ifnull +54 -> 326
    //   275: aload 7
    //   277: invokevirtual 146	java/nio/channels/FileLock:release	()V
    //   280: goto +46 -> 326
    //   283: astore_1
    //   284: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   287: ifeq +39 -> 326
    //   290: new 18	java/lang/StringBuilder
    //   293: dup
    //   294: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   297: astore 4
    //   299: aload 4
    //   301: ldc_w 457
    //   304: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: pop
    //   308: aload 4
    //   310: aload_1
    //   311: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   314: pop
    //   315: ldc 122
    //   317: iconst_2
    //   318: aload 4
    //   320: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   323: invokestatic 126	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   326: aload_3
    //   327: invokevirtual 441	java/io/FileOutputStream:close	()V
    //   330: goto +42 -> 372
    //   333: astore_1
    //   334: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   337: ifeq +35 -> 372
    //   340: new 18	java/lang/StringBuilder
    //   343: dup
    //   344: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   347: astore_3
    //   348: aload_3
    //   349: ldc_w 457
    //   352: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: pop
    //   356: aload_3
    //   357: aload_1
    //   358: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   361: pop
    //   362: ldc 122
    //   364: iconst_2
    //   365: aload_3
    //   366: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   369: invokestatic 126	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   372: aload 10
    //   374: aload_2
    //   375: invokestatic 451	com/tencent/mobileqq/utils/FileUtils:rename	(Ljava/lang/String;Ljava/lang/String;)Z
    //   378: pop
    //   379: iconst_1
    //   380: ireturn
    //   381: astore 5
    //   383: aload 4
    //   385: astore_1
    //   386: aload 5
    //   388: astore 4
    //   390: goto +435 -> 825
    //   393: astore 6
    //   395: aload_3
    //   396: astore 4
    //   398: goto +32 -> 430
    //   401: astore_1
    //   402: aload 6
    //   404: astore 5
    //   406: aload_3
    //   407: astore 4
    //   409: aload_1
    //   410: astore 6
    //   412: goto +223 -> 635
    //   415: astore 4
    //   417: aconst_null
    //   418: astore_1
    //   419: aload 6
    //   421: astore_3
    //   422: goto +403 -> 825
    //   425: astore 6
    //   427: aconst_null
    //   428: astore 5
    //   430: aload 5
    //   432: astore_1
    //   433: aload 4
    //   435: astore_3
    //   436: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   439: ifeq +64 -> 503
    //   442: aload 5
    //   444: astore_1
    //   445: aload 4
    //   447: astore_3
    //   448: new 18	java/lang/StringBuilder
    //   451: dup
    //   452: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   455: astore 7
    //   457: aload 5
    //   459: astore_1
    //   460: aload 4
    //   462: astore_3
    //   463: aload 7
    //   465: ldc_w 459
    //   468: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   471: pop
    //   472: aload 5
    //   474: astore_1
    //   475: aload 4
    //   477: astore_3
    //   478: aload 7
    //   480: aload 6
    //   482: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   485: pop
    //   486: aload 5
    //   488: astore_1
    //   489: aload 4
    //   491: astore_3
    //   492: ldc 122
    //   494: iconst_2
    //   495: aload 7
    //   497: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   500: invokestatic 126	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   503: aload 5
    //   505: ifnull +50 -> 555
    //   508: aload 5
    //   510: invokevirtual 146	java/nio/channels/FileLock:release	()V
    //   513: goto +42 -> 555
    //   516: astore_1
    //   517: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   520: ifeq +35 -> 555
    //   523: new 18	java/lang/StringBuilder
    //   526: dup
    //   527: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   530: astore_2
    //   531: aload_2
    //   532: ldc_w 457
    //   535: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   538: pop
    //   539: aload_2
    //   540: aload_1
    //   541: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   544: pop
    //   545: ldc 122
    //   547: iconst_2
    //   548: aload_2
    //   549: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   552: invokestatic 126	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   555: aload 4
    //   557: ifnull +50 -> 607
    //   560: aload 4
    //   562: invokevirtual 441	java/io/FileOutputStream:close	()V
    //   565: goto +42 -> 607
    //   568: astore_1
    //   569: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   572: ifeq +35 -> 607
    //   575: new 18	java/lang/StringBuilder
    //   578: dup
    //   579: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   582: astore_2
    //   583: aload_2
    //   584: ldc_w 457
    //   587: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   590: pop
    //   591: aload_2
    //   592: aload_1
    //   593: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   596: pop
    //   597: ldc 122
    //   599: iconst_2
    //   600: aload_2
    //   601: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   604: invokestatic 126	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   607: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   610: ifeq +211 -> 821
    //   613: ldc 122
    //   615: iconst_2
    //   616: ldc_w 461
    //   619: invokestatic 126	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   622: iconst_0
    //   623: ireturn
    //   624: astore 6
    //   626: aconst_null
    //   627: astore_1
    //   628: aload 5
    //   630: astore 4
    //   632: aload_1
    //   633: astore 5
    //   635: aload 5
    //   637: astore_1
    //   638: aload 4
    //   640: astore_3
    //   641: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   644: ifeq +64 -> 708
    //   647: aload 5
    //   649: astore_1
    //   650: aload 4
    //   652: astore_3
    //   653: new 18	java/lang/StringBuilder
    //   656: dup
    //   657: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   660: astore 7
    //   662: aload 5
    //   664: astore_1
    //   665: aload 4
    //   667: astore_3
    //   668: aload 7
    //   670: ldc_w 463
    //   673: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   676: pop
    //   677: aload 5
    //   679: astore_1
    //   680: aload 4
    //   682: astore_3
    //   683: aload 7
    //   685: aload 6
    //   687: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   690: pop
    //   691: aload 5
    //   693: astore_1
    //   694: aload 4
    //   696: astore_3
    //   697: ldc 122
    //   699: iconst_2
    //   700: aload 7
    //   702: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   705: invokestatic 156	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   708: aload 5
    //   710: ifnull +50 -> 760
    //   713: aload 5
    //   715: invokevirtual 146	java/nio/channels/FileLock:release	()V
    //   718: goto +42 -> 760
    //   721: astore_1
    //   722: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   725: ifeq +35 -> 760
    //   728: new 18	java/lang/StringBuilder
    //   731: dup
    //   732: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   735: astore_2
    //   736: aload_2
    //   737: ldc_w 457
    //   740: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   743: pop
    //   744: aload_2
    //   745: aload_1
    //   746: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   749: pop
    //   750: ldc 122
    //   752: iconst_2
    //   753: aload_2
    //   754: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   757: invokestatic 126	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   760: aload 4
    //   762: ifnull +50 -> 812
    //   765: aload 4
    //   767: invokevirtual 441	java/io/FileOutputStream:close	()V
    //   770: goto +42 -> 812
    //   773: astore_1
    //   774: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   777: ifeq +35 -> 812
    //   780: new 18	java/lang/StringBuilder
    //   783: dup
    //   784: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   787: astore_2
    //   788: aload_2
    //   789: ldc_w 457
    //   792: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   795: pop
    //   796: aload_2
    //   797: aload_1
    //   798: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   801: pop
    //   802: ldc 122
    //   804: iconst_2
    //   805: aload_2
    //   806: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   809: invokestatic 126	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   812: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   815: ifeq +6 -> 821
    //   818: goto -205 -> 613
    //   821: iconst_0
    //   822: ireturn
    //   823: astore 4
    //   825: aload_1
    //   826: ifnull +53 -> 879
    //   829: aload_1
    //   830: invokevirtual 146	java/nio/channels/FileLock:release	()V
    //   833: goto +46 -> 879
    //   836: astore_1
    //   837: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   840: ifeq +39 -> 879
    //   843: new 18	java/lang/StringBuilder
    //   846: dup
    //   847: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   850: astore 5
    //   852: aload 5
    //   854: ldc_w 457
    //   857: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   860: pop
    //   861: aload 5
    //   863: aload_1
    //   864: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   867: pop
    //   868: ldc 122
    //   870: iconst_2
    //   871: aload 5
    //   873: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   876: invokestatic 126	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   879: aload_3
    //   880: ifnull +49 -> 929
    //   883: aload_3
    //   884: invokevirtual 441	java/io/FileOutputStream:close	()V
    //   887: goto +42 -> 929
    //   890: astore_1
    //   891: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   894: ifeq +35 -> 929
    //   897: new 18	java/lang/StringBuilder
    //   900: dup
    //   901: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   904: astore_3
    //   905: aload_3
    //   906: ldc_w 457
    //   909: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   912: pop
    //   913: aload_3
    //   914: aload_1
    //   915: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   918: pop
    //   919: ldc 122
    //   921: iconst_2
    //   922: aload_3
    //   923: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   926: invokestatic 126	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   929: aload 10
    //   931: aload_2
    //   932: invokestatic 451	com/tencent/mobileqq/utils/FileUtils:rename	(Ljava/lang/String;Ljava/lang/String;)Z
    //   935: pop
    //   936: aload 4
    //   938: athrow
    //   939: iconst_0
    //   940: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	941	0	this	LoadDataJob
    //   0	941	1	paramList	List<PathDrawer>
    //   0	941	2	paramString	String
    //   38	885	3	localObject1	Object
    //   66	342	4	localObject2	Object
    //   415	146	4	localObject3	Object
    //   630	136	4	localObject4	Object
    //   823	114	4	localObject5	Object
    //   69	178	5	localObject6	Object
    //   381	6	5	localObject7	Object
    //   404	468	5	localObject8	Object
    //   72	179	6	localObject9	Object
    //   393	10	6	localException1	Exception
    //   410	10	6	localList	List<PathDrawer>
    //   425	56	6	localException2	Exception
    //   624	62	6	localOverlappingFileLockException	java.nio.channels.OverlappingFileLockException
    //   75	626	7	localObject10	Object
    //   60	200	8	localDataElement	MyParcel.DataElement
    //   63	52	9	localObject11	Object
    //   57	873	10	str	String
    //   104	39	11	localFileChannel	java.nio.channels.FileChannel
    // Exception table:
    //   from	to	target	type
    //   275	280	283	java/lang/Exception
    //   326	330	333	java/lang/Exception
    //   100	106	381	finally
    //   118	125	381	finally
    //   142	149	381	finally
    //   161	168	381	finally
    //   180	189	381	finally
    //   201	216	381	finally
    //   228	240	381	finally
    //   252	267	381	finally
    //   100	106	393	java/lang/Exception
    //   118	125	393	java/lang/Exception
    //   142	149	393	java/lang/Exception
    //   161	168	393	java/lang/Exception
    //   180	189	393	java/lang/Exception
    //   201	216	393	java/lang/Exception
    //   228	240	393	java/lang/Exception
    //   252	267	393	java/lang/Exception
    //   100	106	401	java/nio/channels/OverlappingFileLockException
    //   118	125	401	java/nio/channels/OverlappingFileLockException
    //   142	149	401	java/nio/channels/OverlappingFileLockException
    //   161	168	401	java/nio/channels/OverlappingFileLockException
    //   180	189	401	java/nio/channels/OverlappingFileLockException
    //   201	216	401	java/nio/channels/OverlappingFileLockException
    //   228	240	401	java/nio/channels/OverlappingFileLockException
    //   252	267	401	java/nio/channels/OverlappingFileLockException
    //   77	88	415	finally
    //   77	88	425	java/lang/Exception
    //   508	513	516	java/lang/Exception
    //   560	565	568	java/lang/Exception
    //   77	88	624	java/nio/channels/OverlappingFileLockException
    //   713	718	721	java/lang/Exception
    //   765	770	773	java/lang/Exception
    //   436	442	823	finally
    //   448	457	823	finally
    //   463	472	823	finally
    //   478	486	823	finally
    //   492	503	823	finally
    //   641	647	823	finally
    //   653	662	823	finally
    //   668	677	823	finally
    //   683	691	823	finally
    //   697	708	823	finally
    //   829	833	836	java/lang/Exception
    //   883	887	890	java/lang/Exception
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
    localObject1 = this.jdField_a_of_type_JavaLangRefWeakReference;
    LoadDataJob.LoadDataJobListener localLoadDataJobListener;
    if (localObject1 != null) {
      localLoadDataJobListener = (LoadDataJob.LoadDataJobListener)((WeakReference)localObject1).get();
    } else {
      localLoadDataJobListener = null;
    }
    if (localLoadDataJobListener == null)
    {
      QLog.d("LoadDataJob", 2, "mListener == null");
      return;
    }
    localObject1 = this.jdField_a_of_type_JavaLangString;
    if (localObject1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LoadDataJob", 2, "file == null");
      }
      localLoadDataJobListener.a(null, 4, null, null, null);
      return;
    }
    if (!localLoadDataJobListener.a((String)localObject1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("LoadDataJob", 2, "onCheck  false");
      }
      return;
    }
    Object localObject4 = a(this.jdField_a_of_type_JavaLangString, true);
    Object localObject3 = b(this.jdField_a_of_type_JavaLangString, true);
    if (!localLoadDataJobListener.a(this.jdField_a_of_type_JavaLangString)) {
      return;
    }
    Object localObject2;
    if ((!TextUtils.isEmpty((CharSequence)localObject4)) && (!TextUtils.isEmpty((CharSequence)localObject3)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("LoadDataJob", 2, "run  read parcel begin");
      }
      localObject2 = a((String)localObject4, localLoadDataJobListener);
      if (localLoadDataJobListener.a(this.jdField_a_of_type_JavaLangString))
      {
        if (localObject2 == null) {
          return;
        }
        localObject1 = localObject2;
        if (localObject2 != null)
        {
          Iterator localIterator = ((List)localObject2).iterator();
          for (;;)
          {
            localObject1 = localObject2;
            if (!localIterator.hasNext()) {
              break label335;
            }
            localObject1 = (PathDrawer)localIterator.next();
            if ((localObject1 == null) || (!((PathDrawer)localObject1).a())) {
              break;
            }
            ((PathDrawer)localObject1).a(0, 0, this.jdField_b_of_type_Int, this.c);
          }
          FileUtils.deleteFile((String)localObject4);
          localObject1 = null;
        }
        label335:
        localObject4 = a((String)localObject3);
        localObject3 = localObject4;
        localObject2 = localObject1;
        if (!QLog.isColorLevel()) {
          break label385;
        }
        QLog.d("LoadDataJob", 2, "run  read parcel end");
        localObject3 = localObject4;
        localObject2 = localObject1;
      }
    }
    else
    {
      localObject3 = null;
      localObject2 = localObject3;
    }
    label385:
    if (!localLoadDataJobListener.a(this.jdField_a_of_type_JavaLangString)) {
      return;
    }
    if ((localObject2 != null) && (localObject3 != null) && (((List)localObject2).size() != 0))
    {
      localObject1 = localObject3;
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
      }
      localObject1 = ((DoodleItem)localObject2).a();
      if (!localLoadDataJobListener.a(this.jdField_a_of_type_JavaLangString)) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("LoadDataJob", 2, "run setpathdata ");
      }
      localObject2 = a(((DoodleItem)localObject2).a(), ((DoodleItem)localObject2).a().a());
      long l2 = System.currentTimeMillis();
      if (!localLoadDataJobListener.a(this.jdField_a_of_type_JavaLangString)) {
        return;
      }
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("run load data time:");
        ((StringBuilder)localObject3).append(l2 - l1);
        QLog.d("LoadDataJob", 2, ((StringBuilder)localObject3).toString());
      }
      if (l2 - l1 > 100L)
      {
        if (QLog.isColorLevel()) {
          QLog.d("LoadDataJob", 2, "need cache:");
        }
        ThreadManager.post(new LoadDataJob.1(this, (DoodleParam)localObject1, (List)localObject2), 5, null, false);
      }
      if (QLog.isColorLevel()) {
        QLog.d("LoadDataJob", 2, "run load file end:");
      }
    }
    if (!localLoadDataJobListener.a(this.jdField_a_of_type_JavaLangString)) {
      return;
    }
    localObject3 = a((List)localObject2);
    localLoadDataJobListener.a(this.jdField_a_of_type_JavaLangString, 0, (DoodleParam)localObject1, (List)localObject2, (Map)localObject3);
    if (QLog.isColorLevel()) {
      QLog.d("LoadDataJob", 2, "run  end");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.LoadDataJob
 * JD-Core Version:    0.7.0.1
 */