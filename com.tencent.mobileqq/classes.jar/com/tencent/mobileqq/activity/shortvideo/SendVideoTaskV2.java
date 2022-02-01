package com.tencent.mobileqq.activity.shortvideo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.SVBusiUtil;
import com.tencent.mobileqq.shortvideo.ShortVideoBusiManager;
import com.tencent.mobileqq.shortvideo.ShortVideoReq;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.FileInputStream;

public class SendVideoTaskV2
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
  
  public SendVideoTaskV2(Intent paramIntent)
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
    if (QLog.isColorLevel())
    {
      paramIntent = new StringBuilder();
      paramIntent.append(" SendVideoTask(),  mVideoPath :");
      paramIntent.append(this.jdField_b_of_type_JavaLangString);
      paramIntent.append(", mDuration:");
      paramIntent.append(this.jdField_b_of_type_Long);
      paramIntent.append(", mFileSize:");
      paramIntent.append(this.jdField_a_of_type_Long);
      paramIntent.append(",mUin");
      paramIntent.append(this.jdField_c_of_type_JavaLangString);
      paramIntent.append(",mUinType:");
      paramIntent.append(this.jdField_a_of_type_Int);
      paramIntent.append(",mFileSource:");
      paramIntent.append(this.jdField_d_of_type_JavaLangString);
      paramIntent.append(",mSendBackground = ");
      paramIntent.append(this.jdField_a_of_type_Boolean);
      paramIntent.append(",mMsgTailType=");
      paramIntent.append(this.jdField_f_of_type_Int);
      QLog.d("SendVideoActivity", 2, paramIntent.toString());
    }
  }
  
  /* Error */
  int a(android.content.Context paramContext)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +5 -> 6
    //   4: iconst_5
    //   5: ireturn
    //   6: aconst_null
    //   7: astore 12
    //   9: aconst_null
    //   10: astore 13
    //   12: aconst_null
    //   13: astore 11
    //   15: aconst_null
    //   16: astore 10
    //   18: ldc 148
    //   20: invokestatic 154	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   23: checkcast 148	com/tencent/mobileqq/dpc/api/IDPCApi
    //   26: getstatic 160	com/tencent/mobileqq/dpc/enumname/DPCNames:lvcc	Lcom/tencent/mobileqq/dpc/enumname/DPCNames;
    //   29: invokevirtual 163	com/tencent/mobileqq/dpc/enumname/DPCNames:name	()Ljava/lang/String;
    //   32: ldc 165
    //   34: invokeinterface 169 3 0
    //   39: astore 8
    //   41: iconst_0
    //   42: istore_3
    //   43: iload_3
    //   44: istore_2
    //   45: aload 8
    //   47: ifnull +77 -> 124
    //   50: iload_3
    //   51: istore_2
    //   52: aload 8
    //   54: invokevirtual 175	java/lang/String:length	()I
    //   57: ifle +67 -> 124
    //   60: aload 8
    //   62: ldc 177
    //   64: invokevirtual 181	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   67: astore 8
    //   69: iload_3
    //   70: istore_2
    //   71: aload 8
    //   73: ifnull +51 -> 124
    //   76: aload 8
    //   78: arraylength
    //   79: istore 4
    //   81: iload_3
    //   82: istore_2
    //   83: iload 4
    //   85: ifle +39 -> 124
    //   88: aload 8
    //   90: iconst_0
    //   91: aaload
    //   92: invokestatic 187	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   95: invokevirtual 190	java/lang/Integer:intValue	()I
    //   98: istore_2
    //   99: goto +25 -> 124
    //   102: astore 8
    //   104: iload_3
    //   105: istore_2
    //   106: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   109: ifeq +15 -> 124
    //   112: ldc 129
    //   114: iconst_2
    //   115: ldc 192
    //   117: aload 8
    //   119: invokestatic 195	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   122: iload_3
    //   123: istore_2
    //   124: aload_1
    //   125: aload_0
    //   126: getfield 38	com/tencent/mobileqq/activity/shortvideo/SendVideoTaskV2:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   129: iload_2
    //   130: invokestatic 201	com/tencent/mobileqq/shortvideo/ShortVideoUtils:getVideoThumbnail	(Landroid/content/Context;Ljava/lang/String;I)Landroid/graphics/Bitmap;
    //   133: astore 8
    //   135: aload 8
    //   137: astore 9
    //   139: aload 8
    //   141: ifnonnull +33 -> 174
    //   144: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   147: ifeq +11 -> 158
    //   150: ldc 129
    //   152: iconst_2
    //   153: ldc 203
    //   155: invokestatic 205	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   158: aload_0
    //   159: getfield 207	com/tencent/mobileqq/activity/shortvideo/SendVideoTaskV2:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   162: ifnull +815 -> 977
    //   165: aload_0
    //   166: getfield 207	com/tencent/mobileqq/activity/shortvideo/SendVideoTaskV2:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   169: astore 9
    //   171: goto +3 -> 174
    //   174: aload_0
    //   175: aload 9
    //   177: invokevirtual 212	android/graphics/Bitmap:getWidth	()I
    //   180: putfield 214	com/tencent/mobileqq/activity/shortvideo/SendVideoTaskV2:jdField_b_of_type_Int	I
    //   183: aload_0
    //   184: aload 9
    //   186: invokevirtual 217	android/graphics/Bitmap:getHeight	()I
    //   189: putfield 219	com/tencent/mobileqq/activity/shortvideo/SendVideoTaskV2:jdField_c_of_type_Int	I
    //   192: aload_0
    //   193: getfield 214	com/tencent/mobileqq/activity/shortvideo/SendVideoTaskV2:jdField_b_of_type_Int	I
    //   196: ifeq +475 -> 671
    //   199: aload_0
    //   200: getfield 219	com/tencent/mobileqq/activity/shortvideo/SendVideoTaskV2:jdField_c_of_type_Int	I
    //   203: ifne +6 -> 209
    //   206: goto +465 -> 671
    //   209: new 97	java/lang/StringBuilder
    //   212: dup
    //   213: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   216: astore 8
    //   218: aload 8
    //   220: ldc 221
    //   222: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: pop
    //   226: aload 8
    //   228: invokestatic 227	java/lang/System:currentTimeMillis	()J
    //   231: invokevirtual 109	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   234: pop
    //   235: aload 8
    //   237: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   240: ldc 229
    //   242: invokestatic 233	com/tencent/mobileqq/shortvideo/SVUtils:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   245: astore 14
    //   247: new 97	java/lang/StringBuilder
    //   250: dup
    //   251: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   254: astore 8
    //   256: aload 8
    //   258: invokestatic 235	com/tencent/mobileqq/shortvideo/SVUtils:b	()Ljava/lang/String;
    //   261: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: pop
    //   265: aload 8
    //   267: ldc 237
    //   269: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: pop
    //   273: aload 8
    //   275: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   278: invokestatic 243	com/tencent/mobileqq/utils/FileUtils:createFileIfNotExits	(Ljava/lang/String;)V
    //   281: new 245	java/io/File
    //   284: dup
    //   285: aload 14
    //   287: invokespecial 247	java/io/File:<init>	(Ljava/lang/String;)V
    //   290: astore 15
    //   292: new 245	java/io/File
    //   295: dup
    //   296: aload 15
    //   298: invokevirtual 250	java/io/File:getParent	()Ljava/lang/String;
    //   301: invokespecial 247	java/io/File:<init>	(Ljava/lang/String;)V
    //   304: astore 8
    //   306: aload 8
    //   308: invokevirtual 253	java/io/File:exists	()Z
    //   311: ifeq +11 -> 322
    //   314: aload 8
    //   316: invokevirtual 256	java/io/File:isDirectory	()Z
    //   319: ifne +9 -> 328
    //   322: aload 8
    //   324: invokevirtual 259	java/io/File:mkdirs	()Z
    //   327: pop
    //   328: aload 15
    //   330: invokevirtual 253	java/io/File:exists	()Z
    //   333: ifeq +11 -> 344
    //   336: aload 15
    //   338: invokevirtual 262	java/io/File:isFile	()Z
    //   341: ifne +9 -> 350
    //   344: aload 15
    //   346: invokevirtual 265	java/io/File:createNewFile	()Z
    //   349: pop
    //   350: new 267	java/io/BufferedOutputStream
    //   353: dup
    //   354: new 269	java/io/FileOutputStream
    //   357: dup
    //   358: aload 15
    //   360: invokespecial 272	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   363: invokespecial 275	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   366: astore 8
    //   368: aload 9
    //   370: getstatic 281	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   373: bipush 80
    //   375: aload 8
    //   377: invokevirtual 285	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   380: pop
    //   381: aload 8
    //   383: invokevirtual 288	java/io/BufferedOutputStream:flush	()V
    //   386: new 290	java/io/FileInputStream
    //   389: dup
    //   390: aload 15
    //   392: invokespecial 291	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   395: astore 9
    //   397: aload 15
    //   399: invokevirtual 293	java/io/File:length	()J
    //   402: lstore 5
    //   404: aload_0
    //   405: aload 9
    //   407: lload 5
    //   409: invokestatic 299	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   412: invokestatic 305	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   415: putfield 307	com/tencent/mobileqq/activity/shortvideo/SendVideoTaskV2:g	Ljava/lang/String;
    //   418: aload_0
    //   419: getfield 307	com/tencent/mobileqq/activity/shortvideo/SendVideoTaskV2:g	Ljava/lang/String;
    //   422: invokestatic 313	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   425: ifeq +56 -> 481
    //   428: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   431: ifeq +38 -> 469
    //   434: new 97	java/lang/StringBuilder
    //   437: dup
    //   438: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   441: astore_1
    //   442: aload_1
    //   443: ldc_w 315
    //   446: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   449: pop
    //   450: aload_1
    //   451: aload_0
    //   452: getfield 307	com/tencent/mobileqq/activity/shortvideo/SendVideoTaskV2:g	Ljava/lang/String;
    //   455: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   458: pop
    //   459: ldc 129
    //   461: iconst_2
    //   462: aload_1
    //   463: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   466: invokestatic 205	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   469: aload 8
    //   471: invokevirtual 318	java/io/BufferedOutputStream:close	()V
    //   474: aload 9
    //   476: invokevirtual 319	java/io/FileInputStream:close	()V
    //   479: iconst_5
    //   480: ireturn
    //   481: aload_0
    //   482: aload_0
    //   483: getfield 307	com/tencent/mobileqq/activity/shortvideo/SendVideoTaskV2:g	Ljava/lang/String;
    //   486: ldc 229
    //   488: invokestatic 233	com/tencent/mobileqq/shortvideo/SVUtils:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   491: putfield 321	com/tencent/mobileqq/activity/shortvideo/SendVideoTaskV2:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   494: aload 14
    //   496: aload_0
    //   497: getfield 321	com/tencent/mobileqq/activity/shortvideo/SendVideoTaskV2:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   500: invokestatic 325	com/tencent/mobileqq/utils/FileUtils:rename	(Ljava/lang/String;Ljava/lang/String;)Z
    //   503: istore 7
    //   505: iload 7
    //   507: ifne +15 -> 522
    //   510: aload 8
    //   512: invokevirtual 318	java/io/BufferedOutputStream:close	()V
    //   515: aload 9
    //   517: invokevirtual 319	java/io/FileInputStream:close	()V
    //   520: iconst_5
    //   521: ireturn
    //   522: aload_1
    //   523: lload 5
    //   525: invokestatic 331	android/text/format/Formatter:formatFileSize	(Landroid/content/Context;J)Ljava/lang/String;
    //   528: astore_1
    //   529: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   532: ifeq +39 -> 571
    //   535: new 97	java/lang/StringBuilder
    //   538: dup
    //   539: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   542: astore 10
    //   544: aload 10
    //   546: ldc_w 333
    //   549: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   552: pop
    //   553: aload 10
    //   555: aload_1
    //   556: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   559: pop
    //   560: ldc 129
    //   562: iconst_2
    //   563: aload 10
    //   565: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   568: invokestatic 205	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   571: aload_0
    //   572: getfield 46	com/tencent/mobileqq/activity/shortvideo/SendVideoTaskV2:jdField_b_of_type_Long	J
    //   575: lconst_0
    //   576: lcmp
    //   577: ifne +14 -> 591
    //   580: aload_0
    //   581: aload_0
    //   582: getfield 38	com/tencent/mobileqq/activity/shortvideo/SendVideoTaskV2:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   585: invokestatic 336	com/tencent/mobileqq/shortvideo/ShortVideoUtils:getDuration	(Ljava/lang/String;)J
    //   588: putfield 46	com/tencent/mobileqq/activity/shortvideo/SendVideoTaskV2:jdField_b_of_type_Long	J
    //   591: aload 8
    //   593: invokevirtual 318	java/io/BufferedOutputStream:close	()V
    //   596: aload 9
    //   598: invokevirtual 319	java/io/FileInputStream:close	()V
    //   601: iconst_1
    //   602: ireturn
    //   603: astore_1
    //   604: goto +19 -> 623
    //   607: astore_1
    //   608: goto +25 -> 633
    //   611: astore_1
    //   612: goto +35 -> 647
    //   615: astore_1
    //   616: goto +45 -> 661
    //   619: astore_1
    //   620: aconst_null
    //   621: astore 9
    //   623: aload_1
    //   624: astore 10
    //   626: goto +274 -> 900
    //   629: astore_1
    //   630: aconst_null
    //   631: astore 9
    //   633: aload 8
    //   635: astore 10
    //   637: aload_1
    //   638: astore 11
    //   640: goto +65 -> 705
    //   643: astore_1
    //   644: aconst_null
    //   645: astore 9
    //   647: aload 8
    //   649: astore 10
    //   651: aload_1
    //   652: astore 11
    //   654: goto +116 -> 770
    //   657: astore_1
    //   658: aconst_null
    //   659: astore 9
    //   661: aload 8
    //   663: astore 10
    //   665: aload_1
    //   666: astore 11
    //   668: goto +167 -> 835
    //   671: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   674: ifeq +12 -> 686
    //   677: ldc 129
    //   679: iconst_2
    //   680: ldc_w 338
    //   683: invokestatic 205	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   686: iconst_2
    //   687: ireturn
    //   688: astore 10
    //   690: aconst_null
    //   691: astore 9
    //   693: aload 11
    //   695: astore 8
    //   697: goto +203 -> 900
    //   700: astore 11
    //   702: aconst_null
    //   703: astore 9
    //   705: aload 10
    //   707: astore_1
    //   708: aload 9
    //   710: astore 8
    //   712: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   715: ifeq +21 -> 736
    //   718: aload 10
    //   720: astore_1
    //   721: aload 9
    //   723: astore 8
    //   725: ldc 129
    //   727: iconst_2
    //   728: ldc_w 340
    //   731: aload 11
    //   733: invokestatic 195	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   736: aload 10
    //   738: ifnull +11 -> 749
    //   741: aload 10
    //   743: invokevirtual 318	java/io/BufferedOutputStream:close	()V
    //   746: goto +3 -> 749
    //   749: aload 9
    //   751: ifnull +8 -> 759
    //   754: aload 9
    //   756: invokevirtual 319	java/io/FileInputStream:close	()V
    //   759: iconst_4
    //   760: ireturn
    //   761: astore 11
    //   763: aconst_null
    //   764: astore 9
    //   766: aload 12
    //   768: astore 10
    //   770: aload 10
    //   772: astore_1
    //   773: aload 9
    //   775: astore 8
    //   777: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   780: ifeq +21 -> 801
    //   783: aload 10
    //   785: astore_1
    //   786: aload 9
    //   788: astore 8
    //   790: ldc 129
    //   792: iconst_2
    //   793: ldc_w 342
    //   796: aload 11
    //   798: invokestatic 195	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   801: aload 10
    //   803: ifnull +11 -> 814
    //   806: aload 10
    //   808: invokevirtual 318	java/io/BufferedOutputStream:close	()V
    //   811: goto +3 -> 814
    //   814: aload 9
    //   816: ifnull +8 -> 824
    //   819: aload 9
    //   821: invokevirtual 319	java/io/FileInputStream:close	()V
    //   824: iconst_5
    //   825: ireturn
    //   826: astore 11
    //   828: aconst_null
    //   829: astore 9
    //   831: aload 13
    //   833: astore 10
    //   835: aload 10
    //   837: astore_1
    //   838: aload 9
    //   840: astore 8
    //   842: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   845: ifeq +21 -> 866
    //   848: aload 10
    //   850: astore_1
    //   851: aload 9
    //   853: astore 8
    //   855: ldc 129
    //   857: iconst_2
    //   858: ldc_w 342
    //   861: aload 11
    //   863: invokestatic 195	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   866: aload 10
    //   868: ifnull +11 -> 879
    //   871: aload 10
    //   873: invokevirtual 318	java/io/BufferedOutputStream:close	()V
    //   876: goto +3 -> 879
    //   879: aload 9
    //   881: ifnull +8 -> 889
    //   884: aload 9
    //   886: invokevirtual 319	java/io/FileInputStream:close	()V
    //   889: iconst_3
    //   890: ireturn
    //   891: astore 10
    //   893: aload 8
    //   895: astore 9
    //   897: aload_1
    //   898: astore 8
    //   900: aload 8
    //   902: ifnull +11 -> 913
    //   905: aload 8
    //   907: invokevirtual 318	java/io/BufferedOutputStream:close	()V
    //   910: goto +3 -> 913
    //   913: aload 9
    //   915: ifnull +8 -> 923
    //   918: aload 9
    //   920: invokevirtual 319	java/io/FileInputStream:close	()V
    //   923: aload 10
    //   925: athrow
    //   926: astore_1
    //   927: goto -453 -> 474
    //   930: astore_1
    //   931: iconst_5
    //   932: ireturn
    //   933: astore_1
    //   934: goto -419 -> 515
    //   937: astore_1
    //   938: iconst_5
    //   939: ireturn
    //   940: astore_1
    //   941: goto -345 -> 596
    //   944: astore_1
    //   945: goto -344 -> 601
    //   948: astore_1
    //   949: goto -200 -> 749
    //   952: astore_1
    //   953: iconst_4
    //   954: ireturn
    //   955: astore_1
    //   956: goto -142 -> 814
    //   959: astore_1
    //   960: iconst_5
    //   961: ireturn
    //   962: astore_1
    //   963: goto -84 -> 879
    //   966: astore_1
    //   967: iconst_3
    //   968: ireturn
    //   969: astore_1
    //   970: goto -57 -> 913
    //   973: astore_1
    //   974: goto -51 -> 923
    //   977: iconst_2
    //   978: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	979	0	this	SendVideoTaskV2
    //   0	979	1	paramContext	android.content.Context
    //   44	86	2	i	int
    //   42	81	3	j	int
    //   79	5	4	k	int
    //   402	122	5	l	long
    //   503	3	7	bool	boolean
    //   39	50	8	localObject1	java.lang.Object
    //   102	16	8	localNumberFormatException	java.lang.NumberFormatException
    //   133	773	8	localObject2	java.lang.Object
    //   137	782	9	localObject3	java.lang.Object
    //   16	648	10	localObject4	java.lang.Object
    //   688	54	10	localObject5	java.lang.Object
    //   768	104	10	localObject6	java.lang.Object
    //   891	33	10	localObject7	java.lang.Object
    //   13	681	11	localContext	android.content.Context
    //   700	32	11	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   761	36	11	localException	Exception
    //   826	36	11	localIOException	java.io.IOException
    //   7	760	12	localObject8	java.lang.Object
    //   10	822	13	localObject9	java.lang.Object
    //   245	250	14	str	String
    //   290	108	15	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   88	99	102	java/lang/NumberFormatException
    //   397	469	603	finally
    //   481	505	603	finally
    //   522	571	603	finally
    //   571	591	603	finally
    //   397	469	607	java/lang/OutOfMemoryError
    //   481	505	607	java/lang/OutOfMemoryError
    //   522	571	607	java/lang/OutOfMemoryError
    //   571	591	607	java/lang/OutOfMemoryError
    //   397	469	611	java/lang/Exception
    //   481	505	611	java/lang/Exception
    //   522	571	611	java/lang/Exception
    //   571	591	611	java/lang/Exception
    //   397	469	615	java/io/IOException
    //   481	505	615	java/io/IOException
    //   522	571	615	java/io/IOException
    //   571	591	615	java/io/IOException
    //   368	397	619	finally
    //   368	397	629	java/lang/OutOfMemoryError
    //   368	397	643	java/lang/Exception
    //   368	397	657	java/io/IOException
    //   18	41	688	finally
    //   52	69	688	finally
    //   76	81	688	finally
    //   88	99	688	finally
    //   106	122	688	finally
    //   124	135	688	finally
    //   144	158	688	finally
    //   158	171	688	finally
    //   174	206	688	finally
    //   209	322	688	finally
    //   322	328	688	finally
    //   328	344	688	finally
    //   344	350	688	finally
    //   350	368	688	finally
    //   671	686	688	finally
    //   18	41	700	java/lang/OutOfMemoryError
    //   52	69	700	java/lang/OutOfMemoryError
    //   76	81	700	java/lang/OutOfMemoryError
    //   88	99	700	java/lang/OutOfMemoryError
    //   106	122	700	java/lang/OutOfMemoryError
    //   124	135	700	java/lang/OutOfMemoryError
    //   144	158	700	java/lang/OutOfMemoryError
    //   158	171	700	java/lang/OutOfMemoryError
    //   174	206	700	java/lang/OutOfMemoryError
    //   209	322	700	java/lang/OutOfMemoryError
    //   322	328	700	java/lang/OutOfMemoryError
    //   328	344	700	java/lang/OutOfMemoryError
    //   344	350	700	java/lang/OutOfMemoryError
    //   350	368	700	java/lang/OutOfMemoryError
    //   671	686	700	java/lang/OutOfMemoryError
    //   18	41	761	java/lang/Exception
    //   52	69	761	java/lang/Exception
    //   76	81	761	java/lang/Exception
    //   88	99	761	java/lang/Exception
    //   106	122	761	java/lang/Exception
    //   124	135	761	java/lang/Exception
    //   144	158	761	java/lang/Exception
    //   158	171	761	java/lang/Exception
    //   174	206	761	java/lang/Exception
    //   209	322	761	java/lang/Exception
    //   322	328	761	java/lang/Exception
    //   328	344	761	java/lang/Exception
    //   344	350	761	java/lang/Exception
    //   350	368	761	java/lang/Exception
    //   671	686	761	java/lang/Exception
    //   18	41	826	java/io/IOException
    //   52	69	826	java/io/IOException
    //   76	81	826	java/io/IOException
    //   88	99	826	java/io/IOException
    //   106	122	826	java/io/IOException
    //   124	135	826	java/io/IOException
    //   144	158	826	java/io/IOException
    //   158	171	826	java/io/IOException
    //   174	206	826	java/io/IOException
    //   209	322	826	java/io/IOException
    //   322	328	826	java/io/IOException
    //   328	344	826	java/io/IOException
    //   344	350	826	java/io/IOException
    //   350	368	826	java/io/IOException
    //   671	686	826	java/io/IOException
    //   712	718	891	finally
    //   725	736	891	finally
    //   777	783	891	finally
    //   790	801	891	finally
    //   842	848	891	finally
    //   855	866	891	finally
    //   469	474	926	java/io/IOException
    //   474	479	930	java/io/IOException
    //   510	515	933	java/io/IOException
    //   515	520	937	java/io/IOException
    //   591	596	940	java/io/IOException
    //   596	601	944	java/io/IOException
    //   741	746	948	java/io/IOException
    //   754	759	952	java/io/IOException
    //   806	811	955	java/io/IOException
    //   819	824	959	java/io/IOException
    //   871	876	962	java/io/IOException
    //   884	889	966	java/io/IOException
    //   905	910	969	java/io/IOException
    //   918	923	973	java/io/IOException
  }
  
  protected Integer a(Void... paramVarArgs)
  {
    return Integer.valueOf(a(BaseApplicationImpl.getApplication()));
  }
  
  protected void a(Integer paramInteger)
  {
    super.onPostExecute(paramInteger);
    int i = paramInteger.intValue();
    if (i != 1)
    {
      if ((i == 2) || (i == 3) || (i == 4)) {}
    }
    else
    {
      paramInteger = new Intent();
      try
      {
        this.jdField_e_of_type_JavaLangString = HexUtil.bytes2HexStr(MD5.toMD5Byte(new FileInputStream(this.jdField_b_of_type_JavaLangString), this.jdField_a_of_type_Long));
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("SendVideoActivity", 2, "", localException);
        }
      }
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
      ShortVideoReq localShortVideoReq = SVBusiUtil.a(0, 0);
      localShortVideoReq.a(ShortVideoBusiManager.a(0, paramInteger, localShortVideoReq));
      ShortVideoBusiManager.a(localShortVideoReq, (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
    }
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.shortvideo.SendVideoTaskV2
 * JD-Core Version:    0.7.0.1
 */