package com.tencent.mobileqq.activity.shortvideo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.ShortVideoBusiManager;
import com.tencent.mobileqq.shortvideo.ShortVideoReq;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.FileInputStream;

public class SendVideoActivity$SendVideoTaskV2
  extends AsyncTask<Void, Void, Integer>
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean;
  int jdField_b_of_type_Int;
  long jdField_b_of_type_Long;
  String jdField_b_of_type_JavaLangString;
  int jdField_c_of_type_Int;
  String jdField_c_of_type_JavaLangString;
  int jdField_d_of_type_Int;
  String jdField_d_of_type_JavaLangString;
  int jdField_e_of_type_Int;
  String jdField_e_of_type_JavaLangString;
  int jdField_f_of_type_Int;
  String jdField_f_of_type_JavaLangString;
  String g;
  
  public SendVideoActivity$SendVideoTaskV2(Intent paramIntent)
  {
    this.jdField_b_of_type_JavaLangString = paramIntent.getExtras().getString("file_send_path");
    this.jdField_b_of_type_Long = paramIntent.getExtras().getLong("file_send_duration");
    this.jdField_a_of_type_Long = paramIntent.getExtras().getLong("file_send_size");
    this.jdField_c_of_type_JavaLangString = paramIntent.getExtras().getString("uin");
    this.jdField_a_of_type_Int = paramIntent.getIntExtra("uintype", -1);
    this.jdField_d_of_type_JavaLangString = paramIntent.getStringExtra("file_source");
    this.jdField_a_of_type_JavaLangString = paramIntent.getExtras().getString("activity_before_enter_send_video");
    this.jdField_a_of_type_Boolean = paramIntent.getExtras().getBoolean("send_in_background");
    this.jdField_f_of_type_Int = paramIntent.getExtras().getInt("short_video_msg_tail_type");
    if (QLog.isColorLevel()) {
      QLog.d("SendVideoActivity", 2, " SendVideoTask(),  mVideoPath :" + this.jdField_b_of_type_JavaLangString + ", mDuration:" + this.jdField_b_of_type_Long + ", mFileSize:" + this.jdField_a_of_type_Long + ",mUin" + this.jdField_c_of_type_JavaLangString + ",mUinType:" + this.jdField_a_of_type_Int + ",mFileSource:" + this.jdField_d_of_type_JavaLangString + ",mSendBackground = " + this.jdField_a_of_type_Boolean + ",mMsgTailType=" + this.jdField_f_of_type_Int);
    }
  }
  
  /* Error */
  int a(android.content.Context paramContext)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +7 -> 8
    //   4: iconst_5
    //   5: istore_2
    //   6: iload_2
    //   7: ireturn
    //   8: ldc 148
    //   10: invokestatic 154	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   13: checkcast 148	com/tencent/mobileqq/dpc/api/IDPCApi
    //   16: getstatic 160	com/tencent/mobileqq/dpc/enumname/DPCNames:lvcc	Lcom/tencent/mobileqq/dpc/enumname/DPCNames;
    //   19: invokevirtual 163	com/tencent/mobileqq/dpc/enumname/DPCNames:name	()Ljava/lang/String;
    //   22: ldc 165
    //   24: invokeinterface 169 3 0
    //   29: astore 6
    //   31: aload 6
    //   33: ifnull +193 -> 226
    //   36: aload 6
    //   38: invokevirtual 175	java/lang/String:length	()I
    //   41: ifle +185 -> 226
    //   44: aload 6
    //   46: ldc 177
    //   48: invokevirtual 181	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   51: astore 6
    //   53: aload 6
    //   55: ifnull +171 -> 226
    //   58: aload 6
    //   60: arraylength
    //   61: istore_2
    //   62: iload_2
    //   63: ifle +163 -> 226
    //   66: aload 6
    //   68: iconst_0
    //   69: aaload
    //   70: invokestatic 187	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   73: invokevirtual 190	java/lang/Integer:intValue	()I
    //   76: istore_2
    //   77: aload_1
    //   78: aload_0
    //   79: getfield 38	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$SendVideoTaskV2:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   82: iload_2
    //   83: invokestatic 196	com/tencent/mobileqq/shortvideo/ShortVideoUtils:getVideoThumbnail	(Landroid/content/Context;Ljava/lang/String;I)Landroid/graphics/Bitmap;
    //   86: astore 6
    //   88: aload 6
    //   90: astore 7
    //   92: aload 6
    //   94: ifnonnull +30 -> 124
    //   97: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   100: ifeq +11 -> 111
    //   103: ldc 97
    //   105: iconst_2
    //   106: ldc 198
    //   108: invokestatic 200	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   111: aload_0
    //   112: getfield 202	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$SendVideoTaskV2:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   115: ifnull +116 -> 231
    //   118: aload_0
    //   119: getfield 202	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$SendVideoTaskV2:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   122: astore 7
    //   124: aload_0
    //   125: aload 7
    //   127: invokevirtual 207	android/graphics/Bitmap:getWidth	()I
    //   130: putfield 209	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$SendVideoTaskV2:jdField_b_of_type_Int	I
    //   133: aload_0
    //   134: aload 7
    //   136: invokevirtual 212	android/graphics/Bitmap:getHeight	()I
    //   139: putfield 214	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$SendVideoTaskV2:jdField_c_of_type_Int	I
    //   142: aload_0
    //   143: getfield 209	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$SendVideoTaskV2:jdField_b_of_type_Int	I
    //   146: ifeq +10 -> 156
    //   149: aload_0
    //   150: getfield 214	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$SendVideoTaskV2:jdField_c_of_type_Int	I
    //   153: ifne +116 -> 269
    //   156: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   159: ifeq +11 -> 170
    //   162: ldc 97
    //   164: iconst_2
    //   165: ldc 216
    //   167: invokestatic 200	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   170: iconst_0
    //   171: ifeq +11 -> 182
    //   174: new 218	java/lang/NullPointerException
    //   177: dup
    //   178: invokespecial 219	java/lang/NullPointerException:<init>	()V
    //   181: athrow
    //   182: iconst_0
    //   183: ifeq +11 -> 194
    //   186: new 218	java/lang/NullPointerException
    //   189: dup
    //   190: invokespecial 219	java/lang/NullPointerException:<init>	()V
    //   193: athrow
    //   194: iconst_0
    //   195: ifeq +11 -> 206
    //   198: new 218	java/lang/NullPointerException
    //   201: dup
    //   202: invokespecial 219	java/lang/NullPointerException:<init>	()V
    //   205: athrow
    //   206: iconst_2
    //   207: ireturn
    //   208: astore 6
    //   210: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   213: ifeq +13 -> 226
    //   216: ldc 97
    //   218: iconst_2
    //   219: ldc 221
    //   221: aload 6
    //   223: invokestatic 224	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   226: iconst_0
    //   227: istore_2
    //   228: goto -151 -> 77
    //   231: iconst_0
    //   232: ifeq +11 -> 243
    //   235: new 218	java/lang/NullPointerException
    //   238: dup
    //   239: invokespecial 219	java/lang/NullPointerException:<init>	()V
    //   242: athrow
    //   243: iconst_0
    //   244: ifeq +11 -> 255
    //   247: new 218	java/lang/NullPointerException
    //   250: dup
    //   251: invokespecial 219	java/lang/NullPointerException:<init>	()V
    //   254: athrow
    //   255: iconst_0
    //   256: ifeq +11 -> 267
    //   259: new 218	java/lang/NullPointerException
    //   262: dup
    //   263: invokespecial 219	java/lang/NullPointerException:<init>	()V
    //   266: athrow
    //   267: iconst_2
    //   268: ireturn
    //   269: new 99	java/lang/StringBuilder
    //   272: dup
    //   273: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   276: ldc 226
    //   278: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: invokestatic 232	java/lang/System:currentTimeMillis	()J
    //   284: invokevirtual 111	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   287: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   290: ldc 234
    //   292: invokestatic 237	com/tencent/mobileqq/shortvideo/ShortVideoUtils:getShortVideoThumbPicPath	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   295: astore 10
    //   297: new 99	java/lang/StringBuilder
    //   300: dup
    //   301: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   304: invokestatic 240	com/tencent/mobileqq/shortvideo/ShortVideoUtils:getShortVideoThumbPicDir	()Ljava/lang/String;
    //   307: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: ldc 242
    //   312: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   318: invokestatic 247	com/tencent/mobileqq/utils/FileUtils:c	(Ljava/lang/String;)V
    //   321: new 249	java/io/File
    //   324: dup
    //   325: aload 10
    //   327: invokespecial 251	java/io/File:<init>	(Ljava/lang/String;)V
    //   330: astore 11
    //   332: new 249	java/io/File
    //   335: dup
    //   336: aload 11
    //   338: invokevirtual 254	java/io/File:getParent	()Ljava/lang/String;
    //   341: invokespecial 251	java/io/File:<init>	(Ljava/lang/String;)V
    //   344: astore 6
    //   346: aload 6
    //   348: invokevirtual 257	java/io/File:exists	()Z
    //   351: ifeq +11 -> 362
    //   354: aload 6
    //   356: invokevirtual 260	java/io/File:isDirectory	()Z
    //   359: ifne +9 -> 368
    //   362: aload 6
    //   364: invokevirtual 263	java/io/File:mkdirs	()Z
    //   367: pop
    //   368: aload 11
    //   370: invokevirtual 257	java/io/File:exists	()Z
    //   373: ifeq +11 -> 384
    //   376: aload 11
    //   378: invokevirtual 266	java/io/File:isFile	()Z
    //   381: ifne +9 -> 390
    //   384: aload 11
    //   386: invokevirtual 269	java/io/File:createNewFile	()Z
    //   389: pop
    //   390: new 271	java/io/BufferedOutputStream
    //   393: dup
    //   394: new 273	java/io/FileOutputStream
    //   397: dup
    //   398: aload 11
    //   400: invokespecial 276	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   403: invokespecial 279	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   406: astore 6
    //   408: aload 7
    //   410: getstatic 285	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   413: bipush 80
    //   415: aload 6
    //   417: invokevirtual 289	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   420: pop
    //   421: aload 6
    //   423: invokevirtual 292	java/io/BufferedOutputStream:flush	()V
    //   426: new 294	java/io/FileInputStream
    //   429: dup
    //   430: aload 11
    //   432: invokespecial 295	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   435: astore 7
    //   437: aload 6
    //   439: astore 9
    //   441: aload 7
    //   443: astore 8
    //   445: aload 11
    //   447: invokevirtual 297	java/io/File:length	()J
    //   450: lstore 4
    //   452: aload 6
    //   454: astore 9
    //   456: aload 7
    //   458: astore 8
    //   460: aload_0
    //   461: aload 7
    //   463: lload 4
    //   465: invokestatic 303	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   468: invokestatic 309	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   471: putfield 311	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$SendVideoTaskV2:g	Ljava/lang/String;
    //   474: aload 6
    //   476: astore 9
    //   478: aload 7
    //   480: astore 8
    //   482: aload_0
    //   483: getfield 311	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$SendVideoTaskV2:g	Ljava/lang/String;
    //   486: invokestatic 317	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   489: ifeq +88 -> 577
    //   492: aload 6
    //   494: astore 9
    //   496: aload 7
    //   498: astore 8
    //   500: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   503: ifeq +40 -> 543
    //   506: aload 6
    //   508: astore 9
    //   510: aload 7
    //   512: astore 8
    //   514: ldc 97
    //   516: iconst_2
    //   517: new 99	java/lang/StringBuilder
    //   520: dup
    //   521: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   524: ldc_w 319
    //   527: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   530: aload_0
    //   531: getfield 311	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$SendVideoTaskV2:g	Ljava/lang/String;
    //   534: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   537: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   540: invokestatic 200	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   543: iconst_0
    //   544: ifeq +11 -> 555
    //   547: new 218	java/lang/NullPointerException
    //   550: dup
    //   551: invokespecial 219	java/lang/NullPointerException:<init>	()V
    //   554: athrow
    //   555: aload 6
    //   557: ifnull +8 -> 565
    //   560: aload 6
    //   562: invokevirtual 322	java/io/BufferedOutputStream:close	()V
    //   565: aload 7
    //   567: ifnull +8 -> 575
    //   570: aload 7
    //   572: invokevirtual 323	java/io/FileInputStream:close	()V
    //   575: iconst_5
    //   576: ireturn
    //   577: aload 6
    //   579: astore 9
    //   581: aload 7
    //   583: astore 8
    //   585: aload_0
    //   586: aload_0
    //   587: getfield 311	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$SendVideoTaskV2:g	Ljava/lang/String;
    //   590: ldc 234
    //   592: invokestatic 237	com/tencent/mobileqq/shortvideo/ShortVideoUtils:getShortVideoThumbPicPath	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   595: putfield 325	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$SendVideoTaskV2:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   598: aload 6
    //   600: astore 9
    //   602: aload 7
    //   604: astore 8
    //   606: aload 10
    //   608: aload_0
    //   609: getfield 325	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$SendVideoTaskV2:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   612: invokestatic 328	com/tencent/mobileqq/utils/FileUtils:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   615: istore_3
    //   616: iload_3
    //   617: ifne +37 -> 654
    //   620: iconst_0
    //   621: ifeq +11 -> 632
    //   624: new 218	java/lang/NullPointerException
    //   627: dup
    //   628: invokespecial 219	java/lang/NullPointerException:<init>	()V
    //   631: athrow
    //   632: aload 6
    //   634: ifnull +8 -> 642
    //   637: aload 6
    //   639: invokevirtual 322	java/io/BufferedOutputStream:close	()V
    //   642: aload 7
    //   644: ifnull +8 -> 652
    //   647: aload 7
    //   649: invokevirtual 323	java/io/FileInputStream:close	()V
    //   652: iconst_5
    //   653: ireturn
    //   654: aload 6
    //   656: astore 9
    //   658: aload 7
    //   660: astore 8
    //   662: aload_1
    //   663: lload 4
    //   665: invokestatic 334	android/text/format/Formatter:formatFileSize	(Landroid/content/Context;J)Ljava/lang/String;
    //   668: astore_1
    //   669: aload 6
    //   671: astore 9
    //   673: aload 7
    //   675: astore 8
    //   677: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   680: ifeq +37 -> 717
    //   683: aload 6
    //   685: astore 9
    //   687: aload 7
    //   689: astore 8
    //   691: ldc 97
    //   693: iconst_2
    //   694: new 99	java/lang/StringBuilder
    //   697: dup
    //   698: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   701: ldc_w 336
    //   704: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   707: aload_1
    //   708: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   711: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   714: invokestatic 200	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   717: aload 6
    //   719: astore 9
    //   721: aload 7
    //   723: astore 8
    //   725: aload_0
    //   726: getfield 46	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$SendVideoTaskV2:jdField_b_of_type_Long	J
    //   729: lconst_0
    //   730: lcmp
    //   731: ifne +22 -> 753
    //   734: aload 6
    //   736: astore 9
    //   738: aload 7
    //   740: astore 8
    //   742: aload_0
    //   743: aload_0
    //   744: getfield 38	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$SendVideoTaskV2:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   747: invokestatic 339	com/tencent/mobileqq/shortvideo/ShortVideoUtils:getDuration	(Ljava/lang/String;)J
    //   750: putfield 46	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$SendVideoTaskV2:jdField_b_of_type_Long	J
    //   753: iconst_0
    //   754: ifeq +11 -> 765
    //   757: new 218	java/lang/NullPointerException
    //   760: dup
    //   761: invokespecial 219	java/lang/NullPointerException:<init>	()V
    //   764: athrow
    //   765: aload 6
    //   767: ifnull +8 -> 775
    //   770: aload 6
    //   772: invokevirtual 322	java/io/BufferedOutputStream:close	()V
    //   775: aload 7
    //   777: ifnull +8 -> 785
    //   780: aload 7
    //   782: invokevirtual 323	java/io/FileInputStream:close	()V
    //   785: iconst_1
    //   786: ireturn
    //   787: astore 7
    //   789: aconst_null
    //   790: astore_1
    //   791: aconst_null
    //   792: astore 6
    //   794: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   797: ifeq +14 -> 811
    //   800: ldc 97
    //   802: iconst_2
    //   803: ldc_w 341
    //   806: aload 7
    //   808: invokestatic 224	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   811: iconst_3
    //   812: istore_2
    //   813: iconst_0
    //   814: ifeq +11 -> 825
    //   817: new 218	java/lang/NullPointerException
    //   820: dup
    //   821: invokespecial 219	java/lang/NullPointerException:<init>	()V
    //   824: athrow
    //   825: aload_1
    //   826: ifnull +7 -> 833
    //   829: aload_1
    //   830: invokevirtual 322	java/io/BufferedOutputStream:close	()V
    //   833: aload 6
    //   835: ifnull -829 -> 6
    //   838: aload 6
    //   840: invokevirtual 323	java/io/FileInputStream:close	()V
    //   843: iconst_3
    //   844: ireturn
    //   845: astore_1
    //   846: iconst_3
    //   847: ireturn
    //   848: astore_1
    //   849: aconst_null
    //   850: astore 6
    //   852: aconst_null
    //   853: astore 7
    //   855: aload 6
    //   857: astore 9
    //   859: aload 7
    //   861: astore 8
    //   863: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   866: ifeq +21 -> 887
    //   869: aload 6
    //   871: astore 9
    //   873: aload 7
    //   875: astore 8
    //   877: ldc 97
    //   879: iconst_2
    //   880: ldc_w 341
    //   883: aload_1
    //   884: invokestatic 224	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   887: iconst_0
    //   888: ifeq +11 -> 899
    //   891: new 218	java/lang/NullPointerException
    //   894: dup
    //   895: invokespecial 219	java/lang/NullPointerException:<init>	()V
    //   898: athrow
    //   899: aload 6
    //   901: ifnull +8 -> 909
    //   904: aload 6
    //   906: invokevirtual 322	java/io/BufferedOutputStream:close	()V
    //   909: aload 7
    //   911: ifnull +8 -> 919
    //   914: aload 7
    //   916: invokevirtual 323	java/io/FileInputStream:close	()V
    //   919: iconst_5
    //   920: ireturn
    //   921: astore_1
    //   922: aconst_null
    //   923: astore 6
    //   925: aconst_null
    //   926: astore 7
    //   928: aload 6
    //   930: astore 9
    //   932: aload 7
    //   934: astore 8
    //   936: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   939: ifeq +21 -> 960
    //   942: aload 6
    //   944: astore 9
    //   946: aload 7
    //   948: astore 8
    //   950: ldc 97
    //   952: iconst_2
    //   953: ldc_w 343
    //   956: aload_1
    //   957: invokestatic 224	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   960: iconst_4
    //   961: istore_2
    //   962: iconst_0
    //   963: ifeq +11 -> 974
    //   966: new 218	java/lang/NullPointerException
    //   969: dup
    //   970: invokespecial 219	java/lang/NullPointerException:<init>	()V
    //   973: athrow
    //   974: aload 6
    //   976: ifnull +8 -> 984
    //   979: aload 6
    //   981: invokevirtual 322	java/io/BufferedOutputStream:close	()V
    //   984: aload 7
    //   986: ifnull -980 -> 6
    //   989: aload 7
    //   991: invokevirtual 323	java/io/FileInputStream:close	()V
    //   994: iconst_4
    //   995: ireturn
    //   996: astore_1
    //   997: iconst_4
    //   998: ireturn
    //   999: astore_1
    //   1000: aconst_null
    //   1001: astore 6
    //   1003: aconst_null
    //   1004: astore 8
    //   1006: iconst_0
    //   1007: ifeq +11 -> 1018
    //   1010: new 218	java/lang/NullPointerException
    //   1013: dup
    //   1014: invokespecial 219	java/lang/NullPointerException:<init>	()V
    //   1017: athrow
    //   1018: aload 6
    //   1020: ifnull +8 -> 1028
    //   1023: aload 6
    //   1025: invokevirtual 322	java/io/BufferedOutputStream:close	()V
    //   1028: aload 8
    //   1030: ifnull +8 -> 1038
    //   1033: aload 8
    //   1035: invokevirtual 323	java/io/FileInputStream:close	()V
    //   1038: aload_1
    //   1039: athrow
    //   1040: astore_1
    //   1041: goto -798 -> 243
    //   1044: astore_1
    //   1045: goto -790 -> 255
    //   1048: astore_1
    //   1049: goto -782 -> 267
    //   1052: astore_1
    //   1053: goto -871 -> 182
    //   1056: astore_1
    //   1057: goto -863 -> 194
    //   1060: astore_1
    //   1061: goto -855 -> 206
    //   1064: astore_1
    //   1065: goto -510 -> 555
    //   1068: astore_1
    //   1069: goto -504 -> 565
    //   1072: astore_1
    //   1073: goto -498 -> 575
    //   1076: astore_1
    //   1077: goto -445 -> 632
    //   1080: astore_1
    //   1081: goto -439 -> 642
    //   1084: astore_1
    //   1085: goto -433 -> 652
    //   1088: astore_1
    //   1089: goto -324 -> 765
    //   1092: astore_1
    //   1093: goto -318 -> 775
    //   1096: astore_1
    //   1097: goto -312 -> 785
    //   1100: astore 7
    //   1102: goto -277 -> 825
    //   1105: astore_1
    //   1106: goto -273 -> 833
    //   1109: astore_1
    //   1110: goto -211 -> 899
    //   1113: astore_1
    //   1114: goto -205 -> 909
    //   1117: astore_1
    //   1118: goto -199 -> 919
    //   1121: astore_1
    //   1122: goto -148 -> 974
    //   1125: astore_1
    //   1126: goto -142 -> 984
    //   1129: astore 7
    //   1131: goto -113 -> 1018
    //   1134: astore 6
    //   1136: goto -108 -> 1028
    //   1139: astore 6
    //   1141: goto -103 -> 1038
    //   1144: astore_1
    //   1145: aconst_null
    //   1146: astore 8
    //   1148: goto -142 -> 1006
    //   1151: astore_1
    //   1152: aload 9
    //   1154: astore 6
    //   1156: goto -150 -> 1006
    //   1159: astore 7
    //   1161: aload 6
    //   1163: astore 8
    //   1165: aload_1
    //   1166: astore 6
    //   1168: aload 7
    //   1170: astore_1
    //   1171: goto -165 -> 1006
    //   1174: astore_1
    //   1175: aconst_null
    //   1176: astore 7
    //   1178: goto -250 -> 928
    //   1181: astore_1
    //   1182: goto -254 -> 928
    //   1185: astore_1
    //   1186: aconst_null
    //   1187: astore 7
    //   1189: goto -334 -> 855
    //   1192: astore_1
    //   1193: goto -338 -> 855
    //   1196: astore 7
    //   1198: aload 6
    //   1200: astore_1
    //   1201: aconst_null
    //   1202: astore 6
    //   1204: goto -410 -> 794
    //   1207: astore 8
    //   1209: aload 6
    //   1211: astore_1
    //   1212: aload 7
    //   1214: astore 6
    //   1216: aload 8
    //   1218: astore 7
    //   1220: goto -426 -> 794
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1223	0	this	SendVideoTaskV2
    //   0	1223	1	paramContext	android.content.Context
    //   5	957	2	i	int
    //   615	2	3	bool	boolean
    //   450	214	4	l	long
    //   29	64	6	localObject1	java.lang.Object
    //   208	14	6	localNumberFormatException	java.lang.NumberFormatException
    //   344	680	6	localObject2	java.lang.Object
    //   1134	1	6	localIOException1	java.io.IOException
    //   1139	1	6	localIOException2	java.io.IOException
    //   1154	61	6	localObject3	java.lang.Object
    //   90	691	7	localObject4	java.lang.Object
    //   787	20	7	localIOException3	java.io.IOException
    //   853	137	7	localObject5	java.lang.Object
    //   1100	1	7	localIOException4	java.io.IOException
    //   1129	1	7	localIOException5	java.io.IOException
    //   1159	10	7	localObject6	java.lang.Object
    //   1176	12	7	localObject7	java.lang.Object
    //   1196	17	7	localIOException6	java.io.IOException
    //   1218	1	7	localObject8	java.lang.Object
    //   443	721	8	localObject9	java.lang.Object
    //   1207	10	8	localIOException7	java.io.IOException
    //   439	714	9	localObject10	java.lang.Object
    //   295	312	10	str	String
    //   330	116	11	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   66	77	208	java/lang/NumberFormatException
    //   8	31	787	java/io/IOException
    //   36	53	787	java/io/IOException
    //   58	62	787	java/io/IOException
    //   66	77	787	java/io/IOException
    //   77	88	787	java/io/IOException
    //   97	111	787	java/io/IOException
    //   111	124	787	java/io/IOException
    //   124	156	787	java/io/IOException
    //   156	170	787	java/io/IOException
    //   210	226	787	java/io/IOException
    //   269	362	787	java/io/IOException
    //   362	368	787	java/io/IOException
    //   368	384	787	java/io/IOException
    //   384	390	787	java/io/IOException
    //   390	408	787	java/io/IOException
    //   838	843	845	java/io/IOException
    //   8	31	848	java/lang/Exception
    //   36	53	848	java/lang/Exception
    //   58	62	848	java/lang/Exception
    //   66	77	848	java/lang/Exception
    //   77	88	848	java/lang/Exception
    //   97	111	848	java/lang/Exception
    //   111	124	848	java/lang/Exception
    //   124	156	848	java/lang/Exception
    //   156	170	848	java/lang/Exception
    //   210	226	848	java/lang/Exception
    //   269	362	848	java/lang/Exception
    //   362	368	848	java/lang/Exception
    //   368	384	848	java/lang/Exception
    //   384	390	848	java/lang/Exception
    //   390	408	848	java/lang/Exception
    //   8	31	921	java/lang/OutOfMemoryError
    //   36	53	921	java/lang/OutOfMemoryError
    //   58	62	921	java/lang/OutOfMemoryError
    //   66	77	921	java/lang/OutOfMemoryError
    //   77	88	921	java/lang/OutOfMemoryError
    //   97	111	921	java/lang/OutOfMemoryError
    //   111	124	921	java/lang/OutOfMemoryError
    //   124	156	921	java/lang/OutOfMemoryError
    //   156	170	921	java/lang/OutOfMemoryError
    //   210	226	921	java/lang/OutOfMemoryError
    //   269	362	921	java/lang/OutOfMemoryError
    //   362	368	921	java/lang/OutOfMemoryError
    //   368	384	921	java/lang/OutOfMemoryError
    //   384	390	921	java/lang/OutOfMemoryError
    //   390	408	921	java/lang/OutOfMemoryError
    //   989	994	996	java/io/IOException
    //   8	31	999	finally
    //   36	53	999	finally
    //   58	62	999	finally
    //   66	77	999	finally
    //   77	88	999	finally
    //   97	111	999	finally
    //   111	124	999	finally
    //   124	156	999	finally
    //   156	170	999	finally
    //   210	226	999	finally
    //   269	362	999	finally
    //   362	368	999	finally
    //   368	384	999	finally
    //   384	390	999	finally
    //   390	408	999	finally
    //   235	243	1040	java/io/IOException
    //   247	255	1044	java/io/IOException
    //   259	267	1048	java/io/IOException
    //   174	182	1052	java/io/IOException
    //   186	194	1056	java/io/IOException
    //   198	206	1060	java/io/IOException
    //   547	555	1064	java/io/IOException
    //   560	565	1068	java/io/IOException
    //   570	575	1072	java/io/IOException
    //   624	632	1076	java/io/IOException
    //   637	642	1080	java/io/IOException
    //   647	652	1084	java/io/IOException
    //   757	765	1088	java/io/IOException
    //   770	775	1092	java/io/IOException
    //   780	785	1096	java/io/IOException
    //   817	825	1100	java/io/IOException
    //   829	833	1105	java/io/IOException
    //   891	899	1109	java/io/IOException
    //   904	909	1113	java/io/IOException
    //   914	919	1117	java/io/IOException
    //   966	974	1121	java/io/IOException
    //   979	984	1125	java/io/IOException
    //   1010	1018	1129	java/io/IOException
    //   1023	1028	1134	java/io/IOException
    //   1033	1038	1139	java/io/IOException
    //   408	437	1144	finally
    //   445	452	1151	finally
    //   460	474	1151	finally
    //   482	492	1151	finally
    //   500	506	1151	finally
    //   514	543	1151	finally
    //   585	598	1151	finally
    //   606	616	1151	finally
    //   662	669	1151	finally
    //   677	683	1151	finally
    //   691	717	1151	finally
    //   725	734	1151	finally
    //   742	753	1151	finally
    //   863	869	1151	finally
    //   877	887	1151	finally
    //   936	942	1151	finally
    //   950	960	1151	finally
    //   794	811	1159	finally
    //   408	437	1174	java/lang/OutOfMemoryError
    //   445	452	1181	java/lang/OutOfMemoryError
    //   460	474	1181	java/lang/OutOfMemoryError
    //   482	492	1181	java/lang/OutOfMemoryError
    //   500	506	1181	java/lang/OutOfMemoryError
    //   514	543	1181	java/lang/OutOfMemoryError
    //   585	598	1181	java/lang/OutOfMemoryError
    //   606	616	1181	java/lang/OutOfMemoryError
    //   662	669	1181	java/lang/OutOfMemoryError
    //   677	683	1181	java/lang/OutOfMemoryError
    //   691	717	1181	java/lang/OutOfMemoryError
    //   725	734	1181	java/lang/OutOfMemoryError
    //   742	753	1181	java/lang/OutOfMemoryError
    //   408	437	1185	java/lang/Exception
    //   445	452	1192	java/lang/Exception
    //   460	474	1192	java/lang/Exception
    //   482	492	1192	java/lang/Exception
    //   500	506	1192	java/lang/Exception
    //   514	543	1192	java/lang/Exception
    //   585	598	1192	java/lang/Exception
    //   606	616	1192	java/lang/Exception
    //   662	669	1192	java/lang/Exception
    //   677	683	1192	java/lang/Exception
    //   691	717	1192	java/lang/Exception
    //   725	734	1192	java/lang/Exception
    //   742	753	1192	java/lang/Exception
    //   408	437	1196	java/io/IOException
    //   445	452	1207	java/io/IOException
    //   460	474	1207	java/io/IOException
    //   482	492	1207	java/io/IOException
    //   500	506	1207	java/io/IOException
    //   514	543	1207	java/io/IOException
    //   585	598	1207	java/io/IOException
    //   606	616	1207	java/io/IOException
    //   662	669	1207	java/io/IOException
    //   677	683	1207	java/io/IOException
    //   691	717	1207	java/io/IOException
    //   725	734	1207	java/io/IOException
    //   742	753	1207	java/io/IOException
  }
  
  protected Integer a(Void... paramVarArgs)
  {
    return Integer.valueOf(a(BaseApplicationImpl.getApplication()));
  }
  
  protected void a(Integer paramInteger)
  {
    super.onPostExecute(paramInteger);
    switch (paramInteger.intValue())
    {
    case 2: 
    case 3: 
    case 4: 
    case 5: 
    case 6: 
    default: 
      return;
    }
    paramInteger = new Intent();
    try
    {
      this.jdField_e_of_type_JavaLangString = HexUtil.bytes2HexStr(MD5.toMD5Byte(new FileInputStream(this.jdField_b_of_type_JavaLangString), this.jdField_a_of_type_Long));
      paramInteger.putExtra("uin", this.jdField_c_of_type_JavaLangString);
      paramInteger.putExtra("uintype", this.jdField_a_of_type_Int);
      paramInteger.putExtra("file_send_path", this.jdField_b_of_type_JavaLangString);
      paramInteger.putExtra("file_send_size", this.jdField_a_of_type_Long);
      paramInteger.putExtra("file_send_duration", (int)(this.jdField_b_of_type_Long / 1000L));
      paramInteger.putExtra("file_source", this.jdField_d_of_type_JavaLangString);
      paramInteger.putExtra("thumbfile_send_path", this.jdField_f_of_type_JavaLangString);
      paramInteger.putExtra("file_shortvideo_md5", this.jdField_e_of_type_JavaLangString);
      paramInteger.putExtra("thumbfile_send_width", this.jdField_b_of_type_Int);
      paramInteger.putExtra("thumbfile_send_height", this.jdField_c_of_type_Int);
      paramInteger.putExtra("thumbfile_md5", this.g);
      paramInteger.putExtra("file_width", this.jdField_d_of_type_Int);
      paramInteger.putExtra("file_height", this.jdField_e_of_type_Int);
      paramInteger.putExtra("short_video_msg_tail_type", this.jdField_f_of_type_Int);
      paramInteger.putExtra("file_send_business_type", 0);
      ShortVideoReq localShortVideoReq = ShortVideoBusiManager.a(0, 0);
      localShortVideoReq.a(ShortVideoBusiManager.a(0, paramInteger, localShortVideoReq));
      ShortVideoBusiManager.a(localShortVideoReq, (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("SendVideoActivity", 2, "", localException);
        }
      }
    }
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.shortvideo.SendVideoActivity.SendVideoTaskV2
 * JD-Core Version:    0.7.0.1
 */