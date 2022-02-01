package com.tencent.biz.qqstory.takevideo;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.TextView;
import anvx;
import anyz;
import bkyc;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.transfile.ShortVideoUploadProcessor;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import ykz;
import yla;

public class DanceMachineUploadVideoFragment
  extends PublicBaseFragment
  implements Handler.Callback
{
  private static bkyc jdField_a_of_type_Bkyc;
  private int jdField_a_of_type_Int = -1;
  private long jdField_a_of_type_Long = -1L;
  protected Dialog a;
  private anyz jdField_a_of_type_Anyz = new ykz(this);
  public BaseActivity a;
  public QQAppInterface a;
  private MessageForShortVideo jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean = true;
  
  /* Error */
  private int a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 54	com/tencent/biz/qqstory/takevideo/DanceMachineUploadVideoFragment:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4: ifnull +36 -> 40
    //   7: aload_0
    //   8: getfield 54	com/tencent/biz/qqstory/takevideo/DanceMachineUploadVideoFragment:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   11: invokevirtual 60	com/tencent/mobileqq/app/QQAppInterface:getHwEngine	()Lcom/tencent/mobileqq/highway/HwEngine;
    //   14: invokevirtual 65	com/tencent/mobileqq/highway/HwEngine:preConnect	()V
    //   17: aload_1
    //   18: invokestatic 71	com/tencent/mobileqq/utils/FileUtils:fileExistsAndNotEmpty	(Ljava/lang/String;)Z
    //   21: ifne +21 -> 42
    //   24: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   27: ifeq +11 -> 38
    //   30: ldc 79
    //   32: iconst_2
    //   33: ldc 81
    //   35: invokestatic 85	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   38: iconst_m1
    //   39: ireturn
    //   40: iconst_m1
    //   41: ireturn
    //   42: new 87	java/io/File
    //   45: dup
    //   46: aload_1
    //   47: invokespecial 90	java/io/File:<init>	(Ljava/lang/String;)V
    //   50: astore 8
    //   52: aload 8
    //   54: invokevirtual 94	java/io/File:length	()J
    //   57: lstore 5
    //   59: lload 5
    //   61: lconst_0
    //   62: lcmp
    //   63: ifne +19 -> 82
    //   66: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   69: ifeq +11 -> 80
    //   72: ldc 79
    //   74: iconst_2
    //   75: ldc 96
    //   77: invokestatic 85	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   80: iconst_m1
    //   81: ireturn
    //   82: aconst_null
    //   83: astore 7
    //   85: new 98	java/io/FileInputStream
    //   88: dup
    //   89: aload 8
    //   91: invokespecial 101	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   94: astore 8
    //   96: aload 8
    //   98: lload 5
    //   100: invokestatic 107	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   103: invokestatic 113	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   106: astore 9
    //   108: aload 9
    //   110: invokestatic 119	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   113: ifeq +55 -> 168
    //   116: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   119: ifeq +29 -> 148
    //   122: ldc 79
    //   124: iconst_2
    //   125: new 121	java/lang/StringBuilder
    //   128: dup
    //   129: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   132: ldc 124
    //   134: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: aload 9
    //   139: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   145: invokestatic 85	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   148: aload 8
    //   150: ifnull +8 -> 158
    //   153: aload 8
    //   155: invokevirtual 135	java/io/FileInputStream:close	()V
    //   158: iconst_m1
    //   159: ireturn
    //   160: astore_1
    //   161: aload_1
    //   162: invokevirtual 138	java/io/IOException:printStackTrace	()V
    //   165: goto -7 -> 158
    //   168: aload 8
    //   170: astore 7
    //   172: aload 9
    //   174: astore 10
    //   176: aload 8
    //   178: ifnull +16 -> 194
    //   181: aload 8
    //   183: invokevirtual 135	java/io/FileInputStream:close	()V
    //   186: aload 9
    //   188: astore 10
    //   190: aload 8
    //   192: astore 7
    //   194: new 140	android/media/MediaMetadataRetriever
    //   197: dup
    //   198: invokespecial 141	android/media/MediaMetadataRetriever:<init>	()V
    //   201: astore 8
    //   203: aload 8
    //   205: aload_1
    //   206: invokevirtual 144	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   209: lconst_0
    //   210: lstore_3
    //   211: aload 8
    //   213: bipush 9
    //   215: invokevirtual 148	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   218: astore 9
    //   220: aload 9
    //   222: ifnull +12 -> 234
    //   225: aload 9
    //   227: invokestatic 154	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   230: invokevirtual 157	java/lang/Long:longValue	()J
    //   233: lstore_3
    //   234: lload_3
    //   235: ldc2_w 158
    //   238: lcmp
    //   239: ifle +248 -> 487
    //   242: ldc2_w 158
    //   245: lstore_3
    //   246: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   249: ifeq +38 -> 287
    //   252: ldc 79
    //   254: iconst_2
    //   255: new 121	java/lang/StringBuilder
    //   258: dup
    //   259: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   262: ldc 161
    //   264: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: aload 9
    //   269: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: ldc 163
    //   274: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: lload_3
    //   278: invokevirtual 166	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   281: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   284: invokestatic 169	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   287: aload 8
    //   289: lload_3
    //   290: ldc2_w 170
    //   293: lmul
    //   294: invokevirtual 175	android/media/MediaMetadataRetriever:getFrameAtTime	(J)Landroid/graphics/Bitmap;
    //   297: astore 11
    //   299: aload 8
    //   301: invokevirtual 178	android/media/MediaMetadataRetriever:release	()V
    //   304: aload 11
    //   306: ifnonnull +223 -> 529
    //   309: iconst_m1
    //   310: ireturn
    //   311: astore 7
    //   313: aload 7
    //   315: invokevirtual 138	java/io/IOException:printStackTrace	()V
    //   318: aload 8
    //   320: astore 7
    //   322: aload 9
    //   324: astore 10
    //   326: goto -132 -> 194
    //   329: astore 10
    //   331: aconst_null
    //   332: astore 8
    //   334: aconst_null
    //   335: astore 7
    //   337: aload 10
    //   339: invokevirtual 179	java/io/FileNotFoundException:printStackTrace	()V
    //   342: aconst_null
    //   343: astore 9
    //   345: aload 9
    //   347: astore 7
    //   349: aload 8
    //   351: astore 10
    //   353: iconst_0
    //   354: ifeq -160 -> 194
    //   357: new 181	java/lang/NullPointerException
    //   360: dup
    //   361: invokespecial 182	java/lang/NullPointerException:<init>	()V
    //   364: athrow
    //   365: astore 7
    //   367: aload 7
    //   369: invokevirtual 138	java/io/IOException:printStackTrace	()V
    //   372: aload 9
    //   374: astore 7
    //   376: aload 8
    //   378: astore 10
    //   380: goto -186 -> 194
    //   383: astore_1
    //   384: aload 7
    //   386: ifnull +8 -> 394
    //   389: aload 7
    //   391: invokevirtual 135	java/io/FileInputStream:close	()V
    //   394: aload_1
    //   395: athrow
    //   396: astore 7
    //   398: aload 7
    //   400: invokevirtual 138	java/io/IOException:printStackTrace	()V
    //   403: goto -9 -> 394
    //   406: astore 7
    //   408: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   411: ifeq +28 -> 439
    //   414: ldc 79
    //   416: iconst_2
    //   417: new 121	java/lang/StringBuilder
    //   420: dup
    //   421: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   424: ldc 184
    //   426: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   429: aload_1
    //   430: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   433: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   436: invokestatic 85	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   439: aload 8
    //   441: invokevirtual 178	android/media/MediaMetadataRetriever:release	()V
    //   444: iconst_m1
    //   445: ireturn
    //   446: astore 11
    //   448: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   451: ifeq +31 -> 482
    //   454: ldc 79
    //   456: iconst_2
    //   457: new 121	java/lang/StringBuilder
    //   460: dup
    //   461: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   464: ldc 186
    //   466: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   469: aload 9
    //   471: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   474: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   477: aload 11
    //   479: invokestatic 189	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   482: lconst_0
    //   483: lstore_3
    //   484: goto -250 -> 234
    //   487: lconst_0
    //   488: lstore_3
    //   489: goto -243 -> 246
    //   492: astore 9
    //   494: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   497: ifeq +13 -> 510
    //   500: ldc 79
    //   502: iconst_2
    //   503: ldc 191
    //   505: aload 9
    //   507: invokestatic 189	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   510: aload 8
    //   512: invokevirtual 178	android/media/MediaMetadataRetriever:release	()V
    //   515: aconst_null
    //   516: astore 11
    //   518: goto -214 -> 304
    //   521: astore_1
    //   522: aload 8
    //   524: invokevirtual 178	android/media/MediaMetadataRetriever:release	()V
    //   527: aload_1
    //   528: athrow
    //   529: iconst_2
    //   530: iconst_2
    //   531: invokestatic 195	yyq:a	(I)Ljava/lang/String;
    //   534: ldc 197
    //   536: invokestatic 200	yyq:a	(ILjava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   539: astore 13
    //   541: aload 11
    //   543: getstatic 206	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   546: bipush 100
    //   548: aload 13
    //   550: invokestatic 211	zdr:a	(Landroid/graphics/Bitmap;Landroid/graphics/Bitmap$CompressFormat;ILjava/lang/String;)Z
    //   553: istore_2
    //   554: aload 11
    //   556: invokevirtual 216	android/graphics/Bitmap:recycle	()V
    //   559: iload_2
    //   560: ifne +19 -> 579
    //   563: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   566: ifeq +11 -> 577
    //   569: ldc 79
    //   571: iconst_2
    //   572: ldc 218
    //   574: invokestatic 221	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   577: iconst_m1
    //   578: ireturn
    //   579: new 87	java/io/File
    //   582: dup
    //   583: aload 13
    //   585: invokespecial 90	java/io/File:<init>	(Ljava/lang/String;)V
    //   588: astore 8
    //   590: aload 8
    //   592: invokevirtual 224	java/io/File:exists	()Z
    //   595: ifeq +135 -> 730
    //   598: aload 8
    //   600: invokevirtual 227	java/io/File:isFile	()Z
    //   603: ifeq +127 -> 730
    //   606: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   609: ifeq +29 -> 638
    //   612: ldc 79
    //   614: iconst_2
    //   615: new 121	java/lang/StringBuilder
    //   618: dup
    //   619: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   622: ldc 229
    //   624: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   627: aload 13
    //   629: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   632: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   635: invokestatic 221	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   638: new 98	java/io/FileInputStream
    //   641: dup
    //   642: aload 13
    //   644: invokespecial 230	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   647: astore 8
    //   649: aload 8
    //   651: new 87	java/io/File
    //   654: dup
    //   655: aload 13
    //   657: invokespecial 90	java/io/File:<init>	(Ljava/lang/String;)V
    //   660: invokevirtual 94	java/io/File:length	()J
    //   663: invokestatic 107	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   666: invokestatic 113	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   669: astore 7
    //   671: aload 7
    //   673: invokestatic 119	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   676: ifeq +70 -> 746
    //   679: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   682: ifeq +29 -> 711
    //   685: ldc 79
    //   687: iconst_2
    //   688: new 121	java/lang/StringBuilder
    //   691: dup
    //   692: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   695: ldc 232
    //   697: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   700: aload 7
    //   702: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   705: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   708: invokestatic 85	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   711: aload 8
    //   713: ifnull -675 -> 38
    //   716: aload 8
    //   718: invokevirtual 135	java/io/FileInputStream:close	()V
    //   721: iconst_m1
    //   722: ireturn
    //   723: astore_1
    //   724: aload_1
    //   725: invokevirtual 138	java/io/IOException:printStackTrace	()V
    //   728: iconst_m1
    //   729: ireturn
    //   730: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   733: ifeq +11 -> 744
    //   736: ldc 79
    //   738: iconst_2
    //   739: ldc 234
    //   741: invokestatic 221	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   744: iconst_m1
    //   745: ireturn
    //   746: aload 7
    //   748: astore 9
    //   750: aload 8
    //   752: ifnull +12 -> 764
    //   755: aload 8
    //   757: invokevirtual 135	java/io/FileInputStream:close	()V
    //   760: aload 7
    //   762: astore 9
    //   764: iconst_0
    //   765: iconst_2
    //   766: invokestatic 239	bcwz:a	(II)Lbcxr;
    //   769: astore 7
    //   771: new 241	android/content/Intent
    //   774: dup
    //   775: invokespecial 242	android/content/Intent:<init>	()V
    //   778: astore 8
    //   780: aload 8
    //   782: ldc 244
    //   784: ldc 246
    //   786: invokevirtual 250	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   789: pop
    //   790: aload 8
    //   792: ldc 252
    //   794: iconst_0
    //   795: invokevirtual 255	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   798: pop
    //   799: aload 8
    //   801: ldc_w 257
    //   804: aload_1
    //   805: invokevirtual 250	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   808: pop
    //   809: aload 8
    //   811: ldc_w 259
    //   814: lload 5
    //   816: invokevirtual 262	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   819: pop
    //   820: aload 8
    //   822: ldc_w 264
    //   825: aload 10
    //   827: invokevirtual 250	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   830: pop
    //   831: aload 8
    //   833: ldc_w 266
    //   836: aload 11
    //   838: invokevirtual 270	android/graphics/Bitmap:getWidth	()I
    //   841: invokevirtual 255	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   844: pop
    //   845: aload 8
    //   847: ldc_w 272
    //   850: aload 11
    //   852: invokevirtual 275	android/graphics/Bitmap:getHeight	()I
    //   855: invokevirtual 255	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   858: pop
    //   859: aload 8
    //   861: ldc_w 277
    //   864: aload 13
    //   866: invokevirtual 250	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   869: pop
    //   870: aload 8
    //   872: ldc_w 279
    //   875: aload 9
    //   877: invokevirtual 250	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   880: pop
    //   881: aload 8
    //   883: ldc_w 281
    //   886: iconst_2
    //   887: invokevirtual 255	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   890: pop
    //   891: aload 8
    //   893: aload 7
    //   895: invokestatic 284	bcwz:a	(Ljava/lang/Object;Lbcxr;)Lbcyj;
    //   898: astore_1
    //   899: aload_1
    //   900: iconst_0
    //   901: putfield 287	bcyj:jdField_a_of_type_Boolean	Z
    //   904: aload_1
    //   905: iconst_1
    //   906: putfield 290	bcyj:f	Z
    //   909: aload_0
    //   910: new 292	bcwi
    //   913: dup
    //   914: aload_0
    //   915: getfield 54	com/tencent/biz/qqstory/takevideo/DanceMachineUploadVideoFragment:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   918: invokespecial 295	bcwi:<init>	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   921: aload_1
    //   922: invokevirtual 298	bcwi:a	(Lbcyj;)Lcom/tencent/mobileqq/data/MessageRecord;
    //   925: checkcast 300	com/tencent/mobileqq/data/MessageForShortVideo
    //   928: putfield 302	com/tencent/biz/qqstory/takevideo/DanceMachineUploadVideoFragment:jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo	Lcom/tencent/mobileqq/data/MessageForShortVideo;
    //   931: aload_1
    //   932: aload_0
    //   933: getfield 302	com/tencent/biz/qqstory/takevideo/DanceMachineUploadVideoFragment:jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo	Lcom/tencent/mobileqq/data/MessageForShortVideo;
    //   936: putfield 305	bcyj:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   939: aload 7
    //   941: aload_1
    //   942: invokevirtual 310	bcxr:a	(Lbcyj;)V
    //   945: aload 7
    //   947: aload_0
    //   948: getfield 54	com/tencent/biz/qqstory/takevideo/DanceMachineUploadVideoFragment:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   951: invokestatic 313	bcwz:a	(Lbcxr;Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   954: iconst_0
    //   955: ireturn
    //   956: astore 8
    //   958: aload 8
    //   960: invokevirtual 138	java/io/IOException:printStackTrace	()V
    //   963: aload 7
    //   965: astore 9
    //   967: goto -203 -> 764
    //   970: astore 9
    //   972: aconst_null
    //   973: astore 12
    //   975: aload 7
    //   977: astore 8
    //   979: aload 12
    //   981: astore 7
    //   983: aload 9
    //   985: invokevirtual 138	java/io/IOException:printStackTrace	()V
    //   988: aload 7
    //   990: astore 9
    //   992: iconst_0
    //   993: ifeq -229 -> 764
    //   996: new 181	java/lang/NullPointerException
    //   999: dup
    //   1000: invokespecial 182	java/lang/NullPointerException:<init>	()V
    //   1003: athrow
    //   1004: astore 8
    //   1006: aload 8
    //   1008: invokevirtual 138	java/io/IOException:printStackTrace	()V
    //   1011: aload 7
    //   1013: astore 9
    //   1015: goto -251 -> 764
    //   1018: astore_1
    //   1019: aload 7
    //   1021: astore 8
    //   1023: aload 8
    //   1025: ifnull +8 -> 1033
    //   1028: aload 8
    //   1030: invokevirtual 135	java/io/FileInputStream:close	()V
    //   1033: aload_1
    //   1034: athrow
    //   1035: astore 7
    //   1037: aload 7
    //   1039: invokevirtual 138	java/io/IOException:printStackTrace	()V
    //   1042: goto -9 -> 1033
    //   1045: astore_1
    //   1046: goto -23 -> 1023
    //   1049: astore_1
    //   1050: goto -27 -> 1023
    //   1053: astore 9
    //   1055: aconst_null
    //   1056: astore 7
    //   1058: goto -75 -> 983
    //   1061: astore 9
    //   1063: goto -80 -> 983
    //   1066: astore_1
    //   1067: aload 8
    //   1069: astore 7
    //   1071: goto -687 -> 384
    //   1074: astore_1
    //   1075: goto -691 -> 384
    //   1078: astore 10
    //   1080: aconst_null
    //   1081: astore 9
    //   1083: aload 8
    //   1085: astore 7
    //   1087: aload 9
    //   1089: astore 8
    //   1091: goto -754 -> 337
    //   1094: astore 10
    //   1096: aload 8
    //   1098: astore 7
    //   1100: aload 9
    //   1102: astore 8
    //   1104: goto -767 -> 337
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1107	0	this	DanceMachineUploadVideoFragment
    //   0	1107	1	paramString	String
    //   553	7	2	bool	boolean
    //   210	279	3	l1	long
    //   57	758	5	l2	long
    //   83	110	7	localObject1	Object
    //   311	3	7	localIOException1	java.io.IOException
    //   320	28	7	localObject2	Object
    //   365	3	7	localIOException2	java.io.IOException
    //   374	16	7	localObject3	Object
    //   396	3	7	localIOException3	java.io.IOException
    //   406	1	7	localIllegalArgumentException	java.lang.IllegalArgumentException
    //   669	351	7	localObject4	Object
    //   1035	3	7	localIOException4	java.io.IOException
    //   1056	43	7	localObject5	Object
    //   50	842	8	localObject6	Object
    //   956	3	8	localIOException5	java.io.IOException
    //   977	1	8	localObject7	Object
    //   1004	3	8	localIOException6	java.io.IOException
    //   1021	82	8	localObject8	Object
    //   106	364	9	str1	String
    //   492	14	9	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   748	218	9	localObject9	Object
    //   970	14	9	localIOException7	java.io.IOException
    //   990	24	9	localObject10	Object
    //   1053	1	9	localIOException8	java.io.IOException
    //   1061	1	9	localIOException9	java.io.IOException
    //   1081	20	9	localObject11	Object
    //   174	151	10	str2	String
    //   329	9	10	localFileNotFoundException1	java.io.FileNotFoundException
    //   351	475	10	localObject12	Object
    //   1078	1	10	localFileNotFoundException2	java.io.FileNotFoundException
    //   1094	1	10	localFileNotFoundException3	java.io.FileNotFoundException
    //   297	8	11	localBitmap1	android.graphics.Bitmap
    //   446	32	11	localNumberFormatException	java.lang.NumberFormatException
    //   516	335	11	localBitmap2	android.graphics.Bitmap
    //   973	7	12	localObject13	Object
    //   539	326	13	str3	String
    // Exception table:
    //   from	to	target	type
    //   153	158	160	java/io/IOException
    //   181	186	311	java/io/IOException
    //   85	96	329	java/io/FileNotFoundException
    //   357	365	365	java/io/IOException
    //   85	96	383	finally
    //   389	394	396	java/io/IOException
    //   203	209	406	java/lang/IllegalArgumentException
    //   225	234	446	java/lang/NumberFormatException
    //   287	299	492	java/lang/OutOfMemoryError
    //   287	299	521	finally
    //   494	510	521	finally
    //   716	721	723	java/io/IOException
    //   755	760	956	java/io/IOException
    //   638	649	970	java/io/IOException
    //   996	1004	1004	java/io/IOException
    //   638	649	1018	finally
    //   1028	1033	1035	java/io/IOException
    //   649	671	1045	finally
    //   671	711	1045	finally
    //   983	988	1049	finally
    //   649	671	1053	java/io/IOException
    //   671	711	1061	java/io/IOException
    //   96	108	1066	finally
    //   108	148	1066	finally
    //   337	342	1074	finally
    //   96	108	1078	java/io/FileNotFoundException
    //   108	148	1094	java/io/FileNotFoundException
  }
  
  public void a()
  {
    try
    {
      if (this.jdField_a_of_type_AndroidAppDialog != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("UploadDanceMachineVideo", 2, "cancelProgressDialog");
        }
        this.jdField_a_of_type_AndroidAppDialog.dismiss();
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("UploadDanceMachineVideo", 2, "cancelProgressDialog excep!", localException);
    }
  }
  
  protected void a(String paramString)
  {
    if (this.jdField_a_of_type_AndroidAppDialog == null)
    {
      this.jdField_a_of_type_AndroidAppDialog = new ReportDialog(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131755829);
      this.jdField_a_of_type_AndroidAppDialog.setContentView(2131559068);
      this.jdField_a_of_type_AndroidAppDialog.setOnKeyListener(new yla(this));
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindowManager().getDefaultDisplay();
      WindowManager.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidAppDialog.getWindow().getAttributes();
      localLayoutParams.width = ((Display)localObject).getWidth();
      localLayoutParams.height = ((Display)localObject).getHeight();
      this.jdField_a_of_type_AndroidAppDialog.getWindow().setAttributes(localLayoutParams);
      this.jdField_a_of_type_AndroidAppDialog.show();
    }
    Object localObject = (TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131372740);
    if (TextUtils.isEmpty(paramString)) {
      ((TextView)localObject).setText(2131718526);
    }
    for (;;)
    {
      if (!this.jdField_a_of_type_AndroidAppDialog.isShowing())
      {
        if (QLog.isColorLevel()) {
          QLog.d("UploadDanceMachineVideo", 2, "showProgressDialog");
        }
        this.jdField_a_of_type_AndroidAppDialog.show();
      }
      return;
      ((TextView)localObject).setText(paramString);
    }
  }
  
  public boolean a()
  {
    boolean bool1;
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null) {
      bool1 = false;
    }
    boolean bool2;
    do
    {
      do
      {
        int i;
        do
        {
          return bool1;
          IHttpCommunicatorListener localIHttpCommunicatorListener = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTransFileController().findProcessor(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
          if ((localIHttpCommunicatorListener == null) || (!(localIHttpCommunicatorListener instanceof ShortVideoUploadProcessor))) {
            return false;
          }
          bool2 = ((ShortVideoUploadProcessor)localIHttpCommunicatorListener).isPause();
          i = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileStatus;
          bool1 = true;
        } while ((!bool2) && (i != 1002) && (i != 1001));
        bool2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTransFileController().stopSendingShortVideo(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
        bool1 = bool2;
      } while (bool2);
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.d("UploadDanceMachineVideo", 2, "stop upload task error");
    return bool2;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    case -2: 
      a(anvx.a(2131702207));
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("UploadDanceMachineVideo", 2, "upload time out");
    }
    this.jdField_a_of_type_Long = -1L;
    a();
    a();
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.setResult(2);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.finish();
    this.jdField_a_of_type_Boolean = false;
    return false;
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    jdField_a_of_type_Bkyc = new bkyc(this);
    paramBundle = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent();
    this.jdField_a_of_type_JavaLangString = paramBundle.getExtras().getString("upload_video_path");
    this.jdField_a_of_type_Int = paramBundle.getExtras().getInt("share_method", -1);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.addObserver(this.jdField_a_of_type_Anyz);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      ThreadManager.executeOnSubThread(new DanceMachineUploadVideoFragment.2(this));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("UploadDanceMachineVideo", 2, "upload param invalid : mVideoPath is null");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.setResult(2);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.finish();
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = getActivity();
    if ((getActivity().getAppInterface() instanceof QQAppInterface))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)getActivity().getAppInterface());
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.setTheme(16973841);
      return;
    }
    throw new IllegalStateException("Only allowed in main progress");
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.removeObserver(this.jdField_a_of_type_Anyz);
    if (jdField_a_of_type_Bkyc != null) {
      jdField_a_of_type_Bkyc.removeCallbacksAndMessages(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.DanceMachineUploadVideoFragment
 * JD-Core Version:    0.7.0.1
 */