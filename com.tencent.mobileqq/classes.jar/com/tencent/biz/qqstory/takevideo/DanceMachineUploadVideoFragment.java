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
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.transfile.ShortVideoUploadProcessor;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;
import oaw;
import oax;
import oay;

public class DanceMachineUploadVideoFragment
  extends PublicBaseFragment
  implements Handler.Callback
{
  private static MqqWeakReferenceHandler jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler;
  private int jdField_a_of_type_Int = -1;
  private long jdField_a_of_type_Long = -1L;
  protected Dialog a;
  public BaseActivity a;
  private MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new oaw(this);
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
    //   18: invokestatic 71	com/tencent/mobileqq/utils/FileUtils:b	(Ljava/lang/String;)Z
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
    //   57: lstore 4
    //   59: lload 4
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
    //   98: lload 4
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
    //   210: lstore_2
    //   211: aload 8
    //   213: bipush 9
    //   215: invokevirtual 148	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   218: astore 11
    //   220: aload 11
    //   222: ifnull +12 -> 234
    //   225: aload 11
    //   227: invokestatic 154	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   230: invokevirtual 157	java/lang/Long:longValue	()J
    //   233: lstore_2
    //   234: lload_2
    //   235: ldc2_w 158
    //   238: lcmp
    //   239: ifle +248 -> 487
    //   242: ldc2_w 158
    //   245: lstore_2
    //   246: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   249: ifeq +38 -> 287
    //   252: ldc 79
    //   254: iconst_2
    //   255: new 121	java/lang/StringBuilder
    //   258: dup
    //   259: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   262: ldc 161
    //   264: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: aload 11
    //   269: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: ldc 163
    //   274: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: lload_2
    //   278: invokevirtual 166	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   281: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   284: invokestatic 169	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   287: aload 8
    //   289: lload_2
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
    //   446: astore 9
    //   448: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   451: ifeq +31 -> 482
    //   454: ldc 79
    //   456: iconst_2
    //   457: new 121	java/lang/StringBuilder
    //   460: dup
    //   461: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   464: ldc 186
    //   466: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   469: aload 11
    //   471: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   474: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   477: aload 9
    //   479: invokestatic 189	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   482: lconst_0
    //   483: lstore_2
    //   484: goto -250 -> 234
    //   487: lconst_0
    //   488: lstore_2
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
    //   531: invokestatic 195	com/tencent/biz/qqstory/takevideo/publish/PublishFileManager:a	(I)Ljava/lang/String;
    //   534: ldc 197
    //   536: invokestatic 200	com/tencent/biz/qqstory/takevideo/publish/PublishFileManager:a	(ILjava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   539: astore 13
    //   541: aload 11
    //   543: getstatic 206	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   546: bipush 100
    //   548: aload 13
    //   550: invokestatic 211	com/tencent/biz/qqstory/utils/BitmapUtils:a	(Landroid/graphics/Bitmap;Landroid/graphics/Bitmap$CompressFormat;ILjava/lang/String;)Z
    //   553: istore 6
    //   555: aload 11
    //   557: invokevirtual 216	android/graphics/Bitmap:recycle	()V
    //   560: iload 6
    //   562: ifne +19 -> 581
    //   565: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   568: ifeq +11 -> 579
    //   571: ldc 79
    //   573: iconst_2
    //   574: ldc 218
    //   576: invokestatic 221	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   579: iconst_m1
    //   580: ireturn
    //   581: new 87	java/io/File
    //   584: dup
    //   585: aload 13
    //   587: invokespecial 90	java/io/File:<init>	(Ljava/lang/String;)V
    //   590: astore 8
    //   592: aload 8
    //   594: invokevirtual 224	java/io/File:exists	()Z
    //   597: ifeq +135 -> 732
    //   600: aload 8
    //   602: invokevirtual 227	java/io/File:isFile	()Z
    //   605: ifeq +127 -> 732
    //   608: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   611: ifeq +29 -> 640
    //   614: ldc 79
    //   616: iconst_2
    //   617: new 121	java/lang/StringBuilder
    //   620: dup
    //   621: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   624: ldc 229
    //   626: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   629: aload 13
    //   631: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   634: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   637: invokestatic 221	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   640: new 98	java/io/FileInputStream
    //   643: dup
    //   644: aload 13
    //   646: invokespecial 230	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   649: astore 8
    //   651: aload 8
    //   653: new 87	java/io/File
    //   656: dup
    //   657: aload 13
    //   659: invokespecial 90	java/io/File:<init>	(Ljava/lang/String;)V
    //   662: invokevirtual 94	java/io/File:length	()J
    //   665: invokestatic 107	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   668: invokestatic 113	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   671: astore 7
    //   673: aload 7
    //   675: invokestatic 119	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   678: ifeq +70 -> 748
    //   681: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   684: ifeq +29 -> 713
    //   687: ldc 79
    //   689: iconst_2
    //   690: new 121	java/lang/StringBuilder
    //   693: dup
    //   694: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   697: ldc 232
    //   699: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   702: aload 7
    //   704: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   707: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   710: invokestatic 85	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   713: aload 8
    //   715: ifnull -677 -> 38
    //   718: aload 8
    //   720: invokevirtual 135	java/io/FileInputStream:close	()V
    //   723: iconst_m1
    //   724: ireturn
    //   725: astore_1
    //   726: aload_1
    //   727: invokevirtual 138	java/io/IOException:printStackTrace	()V
    //   730: iconst_m1
    //   731: ireturn
    //   732: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   735: ifeq +11 -> 746
    //   738: ldc 79
    //   740: iconst_2
    //   741: ldc 234
    //   743: invokestatic 221	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   746: iconst_m1
    //   747: ireturn
    //   748: aload 7
    //   750: astore 9
    //   752: aload 8
    //   754: ifnull +12 -> 766
    //   757: aload 8
    //   759: invokevirtual 135	java/io/FileInputStream:close	()V
    //   762: aload 7
    //   764: astore 9
    //   766: iconst_0
    //   767: iconst_2
    //   768: invokestatic 239	com/tencent/mobileqq/shortvideo/ShortVideoBusiManager:a	(II)Lcom/tencent/mobileqq/shortvideo/ShortVideoReq;
    //   771: astore 7
    //   773: new 241	android/content/Intent
    //   776: dup
    //   777: invokespecial 242	android/content/Intent:<init>	()V
    //   780: astore 8
    //   782: aload 8
    //   784: ldc 244
    //   786: ldc 246
    //   788: invokevirtual 250	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   791: pop
    //   792: aload 8
    //   794: ldc 252
    //   796: iconst_0
    //   797: invokevirtual 255	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   800: pop
    //   801: aload 8
    //   803: ldc_w 257
    //   806: aload_1
    //   807: invokevirtual 250	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   810: pop
    //   811: aload 8
    //   813: ldc_w 259
    //   816: lload 4
    //   818: invokevirtual 262	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   821: pop
    //   822: aload 8
    //   824: ldc_w 264
    //   827: aload 10
    //   829: invokevirtual 250	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   832: pop
    //   833: aload 8
    //   835: ldc_w 266
    //   838: aload 11
    //   840: invokevirtual 270	android/graphics/Bitmap:getWidth	()I
    //   843: invokevirtual 255	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   846: pop
    //   847: aload 8
    //   849: ldc_w 272
    //   852: aload 11
    //   854: invokevirtual 275	android/graphics/Bitmap:getHeight	()I
    //   857: invokevirtual 255	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   860: pop
    //   861: aload 8
    //   863: ldc_w 277
    //   866: aload 13
    //   868: invokevirtual 250	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   871: pop
    //   872: aload 8
    //   874: ldc_w 279
    //   877: aload 9
    //   879: invokevirtual 250	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   882: pop
    //   883: aload 8
    //   885: ldc_w 281
    //   888: iconst_2
    //   889: invokevirtual 255	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   892: pop
    //   893: aload 8
    //   895: aload 7
    //   897: invokestatic 284	com/tencent/mobileqq/shortvideo/ShortVideoBusiManager:a	(Ljava/lang/Object;Lcom/tencent/mobileqq/shortvideo/ShortVideoReq;)Lcom/tencent/mobileqq/shortvideo/ShortVideoUploadInfo;
    //   900: astore_1
    //   901: aload_1
    //   902: iconst_0
    //   903: putfield 287	com/tencent/mobileqq/shortvideo/ShortVideoUploadInfo:jdField_a_of_type_Boolean	Z
    //   906: aload_1
    //   907: iconst_1
    //   908: putfield 290	com/tencent/mobileqq/shortvideo/ShortVideoUploadInfo:f	Z
    //   911: aload_0
    //   912: new 292	com/tencent/mobileqq/shortvideo/AioShortVideoOperator
    //   915: dup
    //   916: aload_0
    //   917: getfield 54	com/tencent/biz/qqstory/takevideo/DanceMachineUploadVideoFragment:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   920: invokespecial 295	com/tencent/mobileqq/shortvideo/AioShortVideoOperator:<init>	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   923: aload_1
    //   924: invokevirtual 298	com/tencent/mobileqq/shortvideo/AioShortVideoOperator:a	(Lcom/tencent/mobileqq/shortvideo/ShortVideoUploadInfo;)Lcom/tencent/mobileqq/data/MessageRecord;
    //   927: checkcast 300	com/tencent/mobileqq/data/MessageForShortVideo
    //   930: putfield 302	com/tencent/biz/qqstory/takevideo/DanceMachineUploadVideoFragment:jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo	Lcom/tencent/mobileqq/data/MessageForShortVideo;
    //   933: aload_1
    //   934: aload_0
    //   935: getfield 302	com/tencent/biz/qqstory/takevideo/DanceMachineUploadVideoFragment:jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo	Lcom/tencent/mobileqq/data/MessageForShortVideo;
    //   938: putfield 305	com/tencent/mobileqq/shortvideo/ShortVideoUploadInfo:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   941: aload 7
    //   943: aload_1
    //   944: invokevirtual 310	com/tencent/mobileqq/shortvideo/ShortVideoReq:a	(Lcom/tencent/mobileqq/shortvideo/ShortVideoUploadInfo;)V
    //   947: aload 7
    //   949: aload_0
    //   950: getfield 54	com/tencent/biz/qqstory/takevideo/DanceMachineUploadVideoFragment:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   953: invokestatic 313	com/tencent/mobileqq/shortvideo/ShortVideoBusiManager:a	(Lcom/tencent/mobileqq/shortvideo/ShortVideoReq;Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   956: iconst_0
    //   957: ireturn
    //   958: astore 8
    //   960: aload 8
    //   962: invokevirtual 138	java/io/IOException:printStackTrace	()V
    //   965: aload 7
    //   967: astore 9
    //   969: goto -203 -> 766
    //   972: astore 9
    //   974: aconst_null
    //   975: astore 12
    //   977: aload 7
    //   979: astore 8
    //   981: aload 12
    //   983: astore 7
    //   985: aload 9
    //   987: invokevirtual 138	java/io/IOException:printStackTrace	()V
    //   990: aload 7
    //   992: astore 9
    //   994: iconst_0
    //   995: ifeq -229 -> 766
    //   998: new 181	java/lang/NullPointerException
    //   1001: dup
    //   1002: invokespecial 182	java/lang/NullPointerException:<init>	()V
    //   1005: athrow
    //   1006: astore 8
    //   1008: aload 8
    //   1010: invokevirtual 138	java/io/IOException:printStackTrace	()V
    //   1013: aload 7
    //   1015: astore 9
    //   1017: goto -251 -> 766
    //   1020: astore_1
    //   1021: aload 7
    //   1023: astore 8
    //   1025: aload 8
    //   1027: ifnull +8 -> 1035
    //   1030: aload 8
    //   1032: invokevirtual 135	java/io/FileInputStream:close	()V
    //   1035: aload_1
    //   1036: athrow
    //   1037: astore 7
    //   1039: aload 7
    //   1041: invokevirtual 138	java/io/IOException:printStackTrace	()V
    //   1044: goto -9 -> 1035
    //   1047: astore_1
    //   1048: goto -23 -> 1025
    //   1051: astore_1
    //   1052: goto -27 -> 1025
    //   1055: astore 9
    //   1057: aconst_null
    //   1058: astore 7
    //   1060: goto -75 -> 985
    //   1063: astore 9
    //   1065: goto -80 -> 985
    //   1068: astore_1
    //   1069: aload 8
    //   1071: astore 7
    //   1073: goto -689 -> 384
    //   1076: astore_1
    //   1077: goto -693 -> 384
    //   1080: astore 10
    //   1082: aconst_null
    //   1083: astore 9
    //   1085: aload 8
    //   1087: astore 7
    //   1089: aload 9
    //   1091: astore 8
    //   1093: goto -756 -> 337
    //   1096: astore 10
    //   1098: aload 8
    //   1100: astore 7
    //   1102: aload 9
    //   1104: astore 8
    //   1106: goto -769 -> 337
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1109	0	this	DanceMachineUploadVideoFragment
    //   0	1109	1	paramString	String
    //   210	279	2	l1	long
    //   57	760	4	l2	long
    //   553	8	6	bool	boolean
    //   83	110	7	localObject1	Object
    //   311	3	7	localIOException1	java.io.IOException
    //   320	28	7	localObject2	Object
    //   365	3	7	localIOException2	java.io.IOException
    //   374	16	7	localObject3	Object
    //   396	3	7	localIOException3	java.io.IOException
    //   406	1	7	localIllegalArgumentException	java.lang.IllegalArgumentException
    //   671	351	7	localObject4	Object
    //   1037	3	7	localIOException4	java.io.IOException
    //   1058	43	7	localObject5	Object
    //   50	844	8	localObject6	Object
    //   958	3	8	localIOException5	java.io.IOException
    //   979	1	8	localObject7	Object
    //   1006	3	8	localIOException6	java.io.IOException
    //   1023	82	8	localObject8	Object
    //   106	267	9	str1	String
    //   446	32	9	localNumberFormatException	java.lang.NumberFormatException
    //   492	14	9	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   750	218	9	localObject9	Object
    //   972	14	9	localIOException7	java.io.IOException
    //   992	24	9	localObject10	Object
    //   1055	1	9	localIOException8	java.io.IOException
    //   1063	1	9	localIOException9	java.io.IOException
    //   1083	20	9	localObject11	Object
    //   174	151	10	str2	String
    //   329	9	10	localFileNotFoundException1	java.io.FileNotFoundException
    //   351	477	10	localObject12	Object
    //   1080	1	10	localFileNotFoundException2	java.io.FileNotFoundException
    //   1096	1	10	localFileNotFoundException3	java.io.FileNotFoundException
    //   218	635	11	localObject13	Object
    //   975	7	12	localObject14	Object
    //   539	328	13	str3	String
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
    //   718	723	725	java/io/IOException
    //   757	762	958	java/io/IOException
    //   640	651	972	java/io/IOException
    //   998	1006	1006	java/io/IOException
    //   640	651	1020	finally
    //   1030	1035	1037	java/io/IOException
    //   651	673	1047	finally
    //   673	713	1047	finally
    //   985	990	1051	finally
    //   651	673	1055	java/io/IOException
    //   673	713	1063	java/io/IOException
    //   96	108	1068	finally
    //   108	148	1068	finally
    //   337	342	1076	finally
    //   96	108	1080	java/io/FileNotFoundException
    //   108	148	1096	java/io/FileNotFoundException
  }
  
  protected void a(String paramString)
  {
    if (this.jdField_a_of_type_AndroidAppDialog == null)
    {
      this.jdField_a_of_type_AndroidAppDialog = new Dialog(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131624515);
      this.jdField_a_of_type_AndroidAppDialog.setContentView(2130968870);
      this.jdField_a_of_type_AndroidAppDialog.setOnKeyListener(new oay(this));
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindowManager().getDefaultDisplay();
      WindowManager.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidAppDialog.getWindow().getAttributes();
      localLayoutParams.width = ((Display)localObject).getWidth();
      localLayoutParams.height = ((Display)localObject).getHeight();
      this.jdField_a_of_type_AndroidAppDialog.getWindow().setAttributes(localLayoutParams);
      this.jdField_a_of_type_AndroidAppDialog.show();
    }
    Object localObject = (TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131363381);
    if (TextUtils.isEmpty(paramString)) {
      ((TextView)localObject).setText(2131434559);
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
  
  public void b()
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
  
  public boolean b()
  {
    return false;
  }
  
  public boolean e()
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
          IHttpCommunicatorListener localIHttpCommunicatorListener = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
          if ((localIHttpCommunicatorListener == null) || (!(localIHttpCommunicatorListener instanceof ShortVideoUploadProcessor))) {
            return false;
          }
          bool2 = ((ShortVideoUploadProcessor)localIHttpCommunicatorListener).b();
          i = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileStatus;
          bool1 = true;
        } while ((!bool2) && (i != 1002) && (i != 1001));
        bool2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
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
      a("正在上传");
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("UploadDanceMachineVideo", 2, "upload time out");
    }
    this.jdField_a_of_type_Long = -1L;
    b();
    e();
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.setResult(2);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.finish();
    this.jdField_a_of_type_Boolean = false;
    return false;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler = new MqqWeakReferenceHandler(this);
    paramBundle = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent();
    this.jdField_a_of_type_JavaLangString = paramBundle.getExtras().getString("upload_video_path");
    this.jdField_a_of_type_Int = paramBundle.getExtras().getInt("share_method", -1);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      ThreadManager.executeOnSubThread(new oax(this));
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
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    if (jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler != null) {
      jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.removeCallbacksAndMessages(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.DanceMachineUploadVideoFragment
 * JD-Core Version:    0.7.0.1
 */