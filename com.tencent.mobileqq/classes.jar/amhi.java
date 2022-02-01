import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportProgressDialog;
import java.lang.ref.WeakReference;

public class amhi
  extends AsyncTask<Void, Void, Integer>
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  ProgressDialog jdField_a_of_type_AndroidAppProgressDialog;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  String jdField_a_of_type_JavaLangString;
  WeakReference<BaseActivity> jdField_a_of_type_JavaLangRefWeakReference;
  int jdField_b_of_type_Int;
  long jdField_b_of_type_Long;
  String jdField_b_of_type_JavaLangString;
  int jdField_c_of_type_Int;
  String jdField_c_of_type_JavaLangString;
  String d;
  String e;
  String f;
  String g;
  
  public amhi(BaseActivity paramBaseActivity)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramBaseActivity);
    paramBaseActivity = paramBaseActivity.getIntent();
    this.jdField_b_of_type_JavaLangString = paramBaseActivity.getExtras().getString("file_send_path");
    this.jdField_b_of_type_Long = paramBaseActivity.getExtras().getLong("file_send_duration");
    this.jdField_a_of_type_Long = paramBaseActivity.getExtras().getLong("file_send_size");
    this.jdField_c_of_type_JavaLangString = paramBaseActivity.getExtras().getString("uin");
    this.jdField_a_of_type_Int = paramBaseActivity.getIntExtra("uintype", -1);
    this.d = paramBaseActivity.getStringExtra("file_source");
    this.e = paramBaseActivity.getExtras().getString("file_shortvideo_md5");
    this.jdField_a_of_type_JavaLangString = paramBaseActivity.getExtras().getString("activity_before_enter_send_video");
    this.g = paramBaseActivity.getExtras().getString("thumbfile_md5");
    if (QLog.isColorLevel()) {
      QLog.d("SendVideoActivity", 2, " SendAppShortVideoTask(),  mVideoPath :" + this.jdField_b_of_type_JavaLangString + ", mDuration:" + this.jdField_b_of_type_Long + ", mFileSize:" + this.jdField_a_of_type_Long + ",mUin" + this.jdField_c_of_type_JavaLangString + ",mUinType:" + this.jdField_a_of_type_Int + ",mFileSource:" + this.d);
    }
  }
  
  public static void b(Context paramContext, int paramInt)
  {
    bhlq.a(paramContext, 232, null, paramContext.getString(paramInt), new amhj(paramContext), null).show();
  }
  
  /* Error */
  protected int a()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: iconst_2
    //   3: istore_3
    //   4: aload_0
    //   5: getfield 53	amhi:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   8: iconst_1
    //   9: invokestatic 169	android/media/ThumbnailUtils:createVideoThumbnail	(Ljava/lang/String;I)Landroid/graphics/Bitmap;
    //   12: astore 8
    //   14: new 106	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   21: ldc 171
    //   23: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: invokestatic 177	java/lang/System:currentTimeMillis	()J
    //   29: invokevirtual 118	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   32: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   35: ldc 179
    //   37: invokestatic 184	com/tencent/mobileqq/shortvideo/ShortVideoUtils:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   40: astore 6
    //   42: new 106	java/lang/StringBuilder
    //   45: dup
    //   46: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   49: invokestatic 186	com/tencent/mobileqq/shortvideo/ShortVideoUtils:a	()Ljava/lang/String;
    //   52: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: ldc 188
    //   57: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: invokestatic 193	bhmi:c	(Ljava/lang/String;)V
    //   66: new 195	java/io/File
    //   69: dup
    //   70: aload 6
    //   72: invokespecial 197	java/io/File:<init>	(Ljava/lang/String;)V
    //   75: astore 9
    //   77: new 195	java/io/File
    //   80: dup
    //   81: aload 9
    //   83: invokevirtual 200	java/io/File:getParent	()Ljava/lang/String;
    //   86: invokespecial 197	java/io/File:<init>	(Ljava/lang/String;)V
    //   89: astore 4
    //   91: aload 4
    //   93: invokevirtual 203	java/io/File:exists	()Z
    //   96: ifeq +11 -> 107
    //   99: aload 4
    //   101: invokevirtual 206	java/io/File:isDirectory	()Z
    //   104: ifne +9 -> 113
    //   107: aload 4
    //   109: invokevirtual 209	java/io/File:mkdirs	()Z
    //   112: pop
    //   113: aload 9
    //   115: invokevirtual 203	java/io/File:exists	()Z
    //   118: ifeq +11 -> 129
    //   121: aload 9
    //   123: invokevirtual 212	java/io/File:isFile	()Z
    //   126: ifne +9 -> 135
    //   129: aload 9
    //   131: invokevirtual 215	java/io/File:createNewFile	()Z
    //   134: pop
    //   135: new 217	java/io/BufferedOutputStream
    //   138: dup
    //   139: new 219	java/io/FileOutputStream
    //   142: dup
    //   143: aload 9
    //   145: invokespecial 222	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   148: invokespecial 225	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   151: astore 5
    //   153: aload 8
    //   155: ifnull +214 -> 369
    //   158: aload 5
    //   160: astore 4
    //   162: aload 8
    //   164: getstatic 231	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   167: bipush 80
    //   169: aload 5
    //   171: invokevirtual 237	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   174: pop
    //   175: aload 5
    //   177: astore 4
    //   179: aload 5
    //   181: invokevirtual 240	java/io/BufferedOutputStream:flush	()V
    //   184: iload_2
    //   185: istore_1
    //   186: aload 5
    //   188: ifnull +10 -> 198
    //   191: aload 5
    //   193: invokevirtual 243	java/io/BufferedOutputStream:close	()V
    //   196: iload_2
    //   197: istore_1
    //   198: aload 9
    //   200: invokevirtual 203	java/io/File:exists	()Z
    //   203: ifeq +782 -> 985
    //   206: new 245	java/io/FileInputStream
    //   209: dup
    //   210: aload 6
    //   212: invokespecial 246	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   215: astore 4
    //   217: aload 4
    //   219: aload 9
    //   221: invokevirtual 249	java/io/File:length	()J
    //   224: invokestatic 255	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   227: invokestatic 261	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   230: astore 5
    //   232: aload 4
    //   234: ifnull +8 -> 242
    //   237: aload 4
    //   239: invokevirtual 262	java/io/FileInputStream:close	()V
    //   242: aload 5
    //   244: invokestatic 268	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   247: ifeq +361 -> 608
    //   250: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   253: ifeq +804 -> 1057
    //   256: ldc 104
    //   258: iconst_2
    //   259: new 106	java/lang/StringBuilder
    //   262: dup
    //   263: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   266: ldc_w 270
    //   269: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: aload 5
    //   274: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   280: invokestatic 272	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   283: aload_0
    //   284: aload 5
    //   286: putfield 96	amhi:g	Ljava/lang/String;
    //   289: aload_0
    //   290: aload 6
    //   292: putfield 274	amhi:f	Ljava/lang/String;
    //   295: aload 8
    //   297: ifnull +21 -> 318
    //   300: aload_0
    //   301: aload 8
    //   303: invokevirtual 277	android/graphics/Bitmap:getWidth	()I
    //   306: putfield 279	amhi:jdField_b_of_type_Int	I
    //   309: aload_0
    //   310: aload 8
    //   312: invokevirtual 282	android/graphics/Bitmap:getHeight	()I
    //   315: putfield 284	amhi:jdField_c_of_type_Int	I
    //   318: new 245	java/io/FileInputStream
    //   321: dup
    //   322: aload_0
    //   323: getfield 53	amhi:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   326: invokespecial 246	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   329: astore 5
    //   331: aload_0
    //   332: aload 5
    //   334: new 195	java/io/File
    //   337: dup
    //   338: aload_0
    //   339: getfield 53	amhi:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   342: invokespecial 197	java/io/File:<init>	(Ljava/lang/String;)V
    //   345: invokevirtual 249	java/io/File:length	()J
    //   348: invokestatic 255	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   351: invokestatic 261	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   354: putfield 88	amhi:e	Ljava/lang/String;
    //   357: iload_1
    //   358: ireturn
    //   359: astore 4
    //   361: aload 4
    //   363: invokevirtual 287	java/io/IOException:printStackTrace	()V
    //   366: goto -231 -> 135
    //   369: iconst_2
    //   370: istore_2
    //   371: goto -187 -> 184
    //   374: astore 7
    //   376: aconst_null
    //   377: astore 5
    //   379: aload 5
    //   381: astore 4
    //   383: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   386: ifeq +48 -> 434
    //   389: aload 5
    //   391: astore 4
    //   393: ldc 104
    //   395: iconst_2
    //   396: new 106	java/lang/StringBuilder
    //   399: dup
    //   400: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   403: ldc_w 289
    //   406: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   409: aload 6
    //   411: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   414: ldc_w 291
    //   417: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   420: aload 7
    //   422: invokevirtual 294	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   425: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   428: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   431: invokestatic 272	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   434: aload 5
    //   436: ifnull +8 -> 444
    //   439: aload 5
    //   441: invokevirtual 243	java/io/BufferedOutputStream:close	()V
    //   444: iconst_2
    //   445: istore_1
    //   446: goto -248 -> 198
    //   449: astore 4
    //   451: iconst_2
    //   452: istore_1
    //   453: goto -255 -> 198
    //   456: astore 7
    //   458: aconst_null
    //   459: astore 5
    //   461: aload 5
    //   463: astore 4
    //   465: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   468: ifeq +48 -> 516
    //   471: aload 5
    //   473: astore 4
    //   475: ldc 104
    //   477: iconst_2
    //   478: new 106	java/lang/StringBuilder
    //   481: dup
    //   482: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   485: ldc_w 289
    //   488: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   491: aload 6
    //   493: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   496: ldc_w 296
    //   499: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   502: aload 7
    //   504: invokevirtual 297	java/io/IOException:getMessage	()Ljava/lang/String;
    //   507: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   510: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   513: invokestatic 272	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   516: aload 5
    //   518: ifnull +8 -> 526
    //   521: aload 5
    //   523: invokevirtual 243	java/io/BufferedOutputStream:close	()V
    //   526: iconst_2
    //   527: istore_1
    //   528: goto -330 -> 198
    //   531: astore 4
    //   533: iconst_2
    //   534: istore_1
    //   535: goto -337 -> 198
    //   538: astore 5
    //   540: aconst_null
    //   541: astore 4
    //   543: aload 4
    //   545: ifnull +8 -> 553
    //   548: aload 4
    //   550: invokevirtual 243	java/io/BufferedOutputStream:close	()V
    //   553: aload 5
    //   555: athrow
    //   556: astore 7
    //   558: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   561: ifeq -319 -> 242
    //   564: ldc 104
    //   566: iconst_2
    //   567: new 106	java/lang/StringBuilder
    //   570: dup
    //   571: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   574: ldc_w 299
    //   577: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   580: aload 6
    //   582: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   585: ldc_w 296
    //   588: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   591: aload 7
    //   593: invokevirtual 297	java/io/IOException:getMessage	()Ljava/lang/String;
    //   596: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   599: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   602: invokestatic 272	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   605: goto -363 -> 242
    //   608: aload 5
    //   610: ldc 179
    //   612: invokestatic 184	com/tencent/mobileqq/shortvideo/ShortVideoUtils:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   615: astore 7
    //   617: aload 6
    //   619: aload 7
    //   621: invokestatic 302	bhmi:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   624: ifeq +430 -> 1054
    //   627: aload 7
    //   629: astore 6
    //   631: goto -348 -> 283
    //   634: astore 5
    //   636: aconst_null
    //   637: astore 4
    //   639: aload 5
    //   641: invokevirtual 303	java/io/FileNotFoundException:printStackTrace	()V
    //   644: aload 4
    //   646: ifnull +8 -> 654
    //   649: aload 4
    //   651: invokevirtual 262	java/io/FileInputStream:close	()V
    //   654: aconst_null
    //   655: invokestatic 268	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   658: ifeq +95 -> 753
    //   661: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   664: ifeq +382 -> 1046
    //   667: ldc 104
    //   669: iconst_2
    //   670: new 106	java/lang/StringBuilder
    //   673: dup
    //   674: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   677: ldc_w 270
    //   680: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   683: aconst_null
    //   684: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   687: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   690: invokestatic 272	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   693: iconst_2
    //   694: istore_1
    //   695: aconst_null
    //   696: astore 5
    //   698: goto -415 -> 283
    //   701: astore 5
    //   703: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   706: ifeq -52 -> 654
    //   709: ldc 104
    //   711: iconst_2
    //   712: new 106	java/lang/StringBuilder
    //   715: dup
    //   716: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   719: ldc_w 299
    //   722: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   725: aload 6
    //   727: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   730: ldc_w 296
    //   733: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   736: aload 5
    //   738: invokevirtual 297	java/io/IOException:getMessage	()Ljava/lang/String;
    //   741: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   744: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   747: invokestatic 272	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   750: goto -96 -> 654
    //   753: aconst_null
    //   754: ldc 179
    //   756: invokestatic 184	com/tencent/mobileqq/shortvideo/ShortVideoUtils:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   759: astore 5
    //   761: aload 6
    //   763: astore 7
    //   765: aload 6
    //   767: aload 5
    //   769: invokestatic 302	bhmi:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   772: ifeq +7 -> 779
    //   775: aload 5
    //   777: astore 7
    //   779: iconst_2
    //   780: istore_1
    //   781: aconst_null
    //   782: astore 5
    //   784: aload 7
    //   786: astore 6
    //   788: goto -505 -> 283
    //   791: astore 5
    //   793: aconst_null
    //   794: astore 4
    //   796: aload 4
    //   798: ifnull +8 -> 806
    //   801: aload 4
    //   803: invokevirtual 262	java/io/FileInputStream:close	()V
    //   806: aconst_null
    //   807: invokestatic 268	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   810: ifeq +90 -> 900
    //   813: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   816: ifeq +29 -> 845
    //   819: ldc 104
    //   821: iconst_2
    //   822: new 106	java/lang/StringBuilder
    //   825: dup
    //   826: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   829: ldc_w 270
    //   832: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   835: aconst_null
    //   836: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   839: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   842: invokestatic 272	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   845: aload 5
    //   847: athrow
    //   848: astore 4
    //   850: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   853: ifeq -47 -> 806
    //   856: ldc 104
    //   858: iconst_2
    //   859: new 106	java/lang/StringBuilder
    //   862: dup
    //   863: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   866: ldc_w 299
    //   869: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   872: aload 6
    //   874: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   877: ldc_w 296
    //   880: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   883: aload 4
    //   885: invokevirtual 297	java/io/IOException:getMessage	()Ljava/lang/String;
    //   888: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   891: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   894: invokestatic 272	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   897: goto -91 -> 806
    //   900: aload 6
    //   902: aconst_null
    //   903: ldc 179
    //   905: invokestatic 184	com/tencent/mobileqq/shortvideo/ShortVideoUtils:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   908: invokestatic 302	bhmi:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   911: ifeq -66 -> 845
    //   914: goto -69 -> 845
    //   917: astore 6
    //   919: iconst_5
    //   920: istore_2
    //   921: aload 4
    //   923: astore 5
    //   925: iload_2
    //   926: istore_1
    //   927: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   930: ifeq -599 -> 331
    //   933: ldc 104
    //   935: iconst_2
    //   936: new 106	java/lang/StringBuilder
    //   939: dup
    //   940: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   943: ldc_w 305
    //   946: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   949: aload_0
    //   950: getfield 53	amhi:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   953: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   956: ldc_w 307
    //   959: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   962: aload 6
    //   964: invokevirtual 294	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   967: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   970: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   973: invokestatic 272	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   976: aload 4
    //   978: astore 5
    //   980: iload_2
    //   981: istore_1
    //   982: goto -651 -> 331
    //   985: iload_3
    //   986: istore_1
    //   987: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   990: ifeq -633 -> 357
    //   993: ldc 104
    //   995: iconst_2
    //   996: ldc_w 309
    //   999: invokestatic 272	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1002: iconst_2
    //   1003: ireturn
    //   1004: astore 4
    //   1006: iload_2
    //   1007: istore_1
    //   1008: goto -810 -> 198
    //   1011: astore 4
    //   1013: goto -460 -> 553
    //   1016: astore 5
    //   1018: goto -222 -> 796
    //   1021: astore 5
    //   1023: goto -227 -> 796
    //   1026: astore 5
    //   1028: goto -389 -> 639
    //   1031: astore 5
    //   1033: goto -490 -> 543
    //   1036: astore 7
    //   1038: goto -577 -> 461
    //   1041: astore 7
    //   1043: goto -664 -> 379
    //   1046: iconst_2
    //   1047: istore_1
    //   1048: aconst_null
    //   1049: astore 5
    //   1051: goto -768 -> 283
    //   1054: goto -423 -> 631
    //   1057: goto -774 -> 283
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1060	0	this	amhi
    //   185	863	1	i	int
    //   1	1006	2	j	int
    //   3	983	3	k	int
    //   89	149	4	localObject1	Object
    //   359	3	4	localIOException1	java.io.IOException
    //   381	11	4	localObject2	Object
    //   449	1	4	localIOException2	java.io.IOException
    //   463	11	4	localObject3	Object
    //   531	1	4	localIOException3	java.io.IOException
    //   541	261	4	localObject4	Object
    //   848	129	4	localIOException4	java.io.IOException
    //   1004	1	4	localIOException5	java.io.IOException
    //   1011	1	4	localIOException6	java.io.IOException
    //   151	371	5	localObject5	Object
    //   538	71	5	str1	String
    //   634	6	5	localFileNotFoundException1	java.io.FileNotFoundException
    //   696	1	5	localObject6	Object
    //   701	36	5	localIOException7	java.io.IOException
    //   759	24	5	str2	String
    //   791	55	5	localObject7	Object
    //   923	56	5	localIOException8	java.io.IOException
    //   1016	1	5	localObject8	Object
    //   1021	1	5	localObject9	Object
    //   1026	1	5	localFileNotFoundException2	java.io.FileNotFoundException
    //   1031	1	5	localObject10	Object
    //   1049	1	5	localObject11	Object
    //   40	861	6	localObject12	Object
    //   917	46	6	localFileNotFoundException3	java.io.FileNotFoundException
    //   374	47	7	localFileNotFoundException4	java.io.FileNotFoundException
    //   456	47	7	localIOException9	java.io.IOException
    //   556	36	7	localIOException10	java.io.IOException
    //   615	170	7	localObject13	Object
    //   1036	1	7	localIOException11	java.io.IOException
    //   1041	1	7	localFileNotFoundException5	java.io.FileNotFoundException
    //   12	299	8	localBitmap	android.graphics.Bitmap
    //   75	145	9	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   129	135	359	java/io/IOException
    //   135	153	374	java/io/FileNotFoundException
    //   439	444	449	java/io/IOException
    //   135	153	456	java/io/IOException
    //   521	526	531	java/io/IOException
    //   135	153	538	finally
    //   237	242	556	java/io/IOException
    //   206	217	634	java/io/FileNotFoundException
    //   649	654	701	java/io/IOException
    //   206	217	791	finally
    //   801	806	848	java/io/IOException
    //   318	331	917	java/io/FileNotFoundException
    //   191	196	1004	java/io/IOException
    //   548	553	1011	java/io/IOException
    //   217	232	1016	finally
    //   639	644	1021	finally
    //   217	232	1026	java/io/FileNotFoundException
    //   162	175	1031	finally
    //   179	184	1031	finally
    //   383	389	1031	finally
    //   393	434	1031	finally
    //   465	471	1031	finally
    //   475	516	1031	finally
    //   162	175	1036	java/io/IOException
    //   179	184	1036	java/io/IOException
    //   162	175	1041	java/io/FileNotFoundException
    //   179	184	1041	java/io/FileNotFoundException
  }
  
  protected Integer a(Void... paramVarArgs)
  {
    return Integer.valueOf(a());
  }
  
  void a()
  {
    try
    {
      if (this.jdField_a_of_type_AndroidAppProgressDialog != null) {
        this.jdField_a_of_type_AndroidAppProgressDialog.cancel();
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  void a(Context paramContext, int paramInt)
  {
    try
    {
      if (this.jdField_a_of_type_AndroidAppProgressDialog != null) {
        a();
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramInt);
        if (this.jdField_a_of_type_AndroidAppProgressDialog.isShowing()) {
          break;
        }
        this.jdField_a_of_type_AndroidAppProgressDialog.show();
        return;
        this.jdField_a_of_type_AndroidAppProgressDialog = new ReportProgressDialog(paramContext, 2131755824);
        this.jdField_a_of_type_AndroidAppProgressDialog.setCancelable(true);
        this.jdField_a_of_type_AndroidAppProgressDialog.show();
        this.jdField_a_of_type_AndroidAppProgressDialog.setContentView(2131559572);
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidAppProgressDialog.findViewById(2131372578));
      }
      return;
    }
    catch (Throwable paramContext)
    {
      if (QLog.isColorLevel()) {
        QLog.e("SendVideoActivity", 2, "showProgressDialog", paramContext);
      }
    }
  }
  
  protected void a(Integer paramInteger)
  {
    super.onPostExecute(paramInteger);
    if (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null) {
      return;
    }
    a();
    switch (paramInteger.intValue())
    {
    default: 
      return;
    case 1: 
      paramInteger = ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getIntent();
      paramInteger.putExtra("uin", this.jdField_c_of_type_JavaLangString);
      paramInteger.putExtra("uintype", this.jdField_a_of_type_Int);
      paramInteger.putExtra("file_send_path", this.jdField_b_of_type_JavaLangString);
      paramInteger.putExtra("file_send_size", this.jdField_a_of_type_Long);
      paramInteger.putExtra("file_send_duration", (int)(this.jdField_b_of_type_Long / 1000L));
      paramInteger.putExtra("file_source", this.d);
      paramInteger.putExtra("thumbfile_send_path", this.f);
      paramInteger.putExtra("file_shortvideo_md5", this.e);
      paramInteger.putExtra("thumbfile_send_width", this.jdField_b_of_type_Int);
      paramInteger.putExtra("thumbfile_send_height", this.jdField_c_of_type_Int);
      paramInteger.putExtra("thumbfile_md5", this.g);
      paramInteger.putExtra("file_send_business_type", 2);
      Object localObject2 = bcwu.a(0, 2);
      Object localObject1 = bcwu.a(2, paramInteger, (bcxn)localObject2);
      ((bcxn)localObject2).a((bcyf)localObject1);
      localObject2 = new bcwe(((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).app);
      localObject1 = ((bcwe)localObject2).a((bcyf)localObject1);
      ((bcwe)localObject2).a((MessageRecord)localObject1);
      localObject2 = (MessageForShortVideo)localObject1;
      localObject2 = ShortVideoUtils.a(((MessageForShortVideo)localObject2).md5, ((MessageForShortVideo)localObject2).frienduin, ((MessageForShortVideo)localObject2).uniseq, "mp4");
      bhmi.d(this.jdField_b_of_type_JavaLangString, (String)localObject2);
      localObject2 = bcwu.a(0, 2);
      localObject1 = bcwu.a(localObject1, (bcxn)localObject2);
      ((bcyf)localObject1).a = false;
      ((bcxn)localObject2).a((bcyf)localObject1);
      bcwu.a((bcxn)localObject2, ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).app);
      localObject1 = ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getIntent();
      if (((Intent)localObject1).getBooleanExtra("start_init_activity_after_sended", true))
      {
        localObject2 = ((Intent)localObject1).getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
        paramInteger.setClassName(((Intent)localObject1).getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME"), (String)localObject2);
        if (QLog.isColorLevel()) {
          QLog.d("SendVideoActivity", 2, "SendAppShortVideoTask onPostExecute() INIT_ACTIVITY_CLASS_NAME=" + (String)localObject2);
        }
        paramInteger.addFlags(603979776);
        ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).startActivity(paramInteger);
      }
      ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).finish();
      ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).overridePendingTransition(0, 2130771980);
      return;
    case 2: 
    case 6: 
      b((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 2131718247);
      return;
    case 3: 
      b((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 2131718242);
      return;
    case 4: 
      b((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 2131718213);
      return;
    }
    b((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 2131718239);
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
    a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 2131694337);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amhi
 * JD-Core Version:    0.7.0.1
 */