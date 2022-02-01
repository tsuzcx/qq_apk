package com.tencent.mobileqq.activity.shortvideo;

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
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.SVBusiUtil;
import com.tencent.mobileqq.shortvideo.ShortVideoBusiManager;
import com.tencent.mobileqq.shortvideo.ShortVideoReq;
import com.tencent.mobileqq.shortvideo.ShortVideoUploadInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.api.IShortVideoFactory;
import com.tencent.mobileqq.shortvideo.api.IShortVideoOperator;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportProgressDialog;
import java.lang.ref.WeakReference;

public class SendAppShortVideoTask
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
  
  public SendAppShortVideoTask(BaseActivity paramBaseActivity)
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
    if (QLog.isColorLevel())
    {
      paramBaseActivity = new StringBuilder();
      paramBaseActivity.append(" SendAppShortVideoTask(),  mVideoPath :");
      paramBaseActivity.append(this.jdField_b_of_type_JavaLangString);
      paramBaseActivity.append(", mDuration:");
      paramBaseActivity.append(this.jdField_b_of_type_Long);
      paramBaseActivity.append(", mFileSize:");
      paramBaseActivity.append(this.jdField_a_of_type_Long);
      paramBaseActivity.append(",mUin");
      paramBaseActivity.append(this.jdField_c_of_type_JavaLangString);
      paramBaseActivity.append(",mUinType:");
      paramBaseActivity.append(this.jdField_a_of_type_Int);
      paramBaseActivity.append(",mFileSource:");
      paramBaseActivity.append(this.d);
      QLog.d("SendVideoActivity", 2, paramBaseActivity.toString());
    }
  }
  
  public static void b(Context paramContext, int paramInt)
  {
    DialogUtil.a(paramContext, 232, null, paramContext.getString(paramInt), new SendAppShortVideoTask.1(paramContext), null).show();
  }
  
  /* Error */
  protected int a()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 53	com/tencent/mobileqq/activity/shortvideo/SendAppShortVideoTask:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   4: astore_3
    //   5: iconst_1
    //   6: istore_1
    //   7: aload_3
    //   8: iconst_1
    //   9: invokestatic 169	android/media/ThumbnailUtils:createVideoThumbnail	(Ljava/lang/String;I)Landroid/graphics/Bitmap;
    //   12: astore 10
    //   14: new 104	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   21: astore_3
    //   22: aload_3
    //   23: ldc 171
    //   25: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: pop
    //   29: aload_3
    //   30: invokestatic 177	java/lang/System:currentTimeMillis	()J
    //   33: invokevirtual 116	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   36: pop
    //   37: aload_3
    //   38: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: ldc 179
    //   43: invokestatic 184	com/tencent/mobileqq/shortvideo/SVUtils:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   46: astore 6
    //   48: new 104	java/lang/StringBuilder
    //   51: dup
    //   52: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   55: astore_3
    //   56: aload_3
    //   57: invokestatic 186	com/tencent/mobileqq/shortvideo/SVUtils:b	()Ljava/lang/String;
    //   60: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: pop
    //   64: aload_3
    //   65: ldc 188
    //   67: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: pop
    //   71: aload_3
    //   72: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: invokestatic 194	com/tencent/mobileqq/utils/FileUtils:createFileIfNotExits	(Ljava/lang/String;)V
    //   78: new 196	java/io/File
    //   81: dup
    //   82: aload 6
    //   84: invokespecial 198	java/io/File:<init>	(Ljava/lang/String;)V
    //   87: astore 8
    //   89: new 196	java/io/File
    //   92: dup
    //   93: aload 8
    //   95: invokevirtual 201	java/io/File:getParent	()Ljava/lang/String;
    //   98: invokespecial 198	java/io/File:<init>	(Ljava/lang/String;)V
    //   101: astore_3
    //   102: aload_3
    //   103: invokevirtual 204	java/io/File:exists	()Z
    //   106: ifeq +10 -> 116
    //   109: aload_3
    //   110: invokevirtual 207	java/io/File:isDirectory	()Z
    //   113: ifne +8 -> 121
    //   116: aload_3
    //   117: invokevirtual 210	java/io/File:mkdirs	()Z
    //   120: pop
    //   121: aload 8
    //   123: invokevirtual 204	java/io/File:exists	()Z
    //   126: ifeq +11 -> 137
    //   129: aload 8
    //   131: invokevirtual 213	java/io/File:isFile	()Z
    //   134: ifne +17 -> 151
    //   137: aload 8
    //   139: invokevirtual 216	java/io/File:createNewFile	()Z
    //   142: pop
    //   143: goto +8 -> 151
    //   146: astore_3
    //   147: aload_3
    //   148: invokevirtual 219	java/io/IOException:printStackTrace	()V
    //   151: aconst_null
    //   152: astore 7
    //   154: new 221	java/io/BufferedOutputStream
    //   157: dup
    //   158: new 223	java/io/FileOutputStream
    //   161: dup
    //   162: aload 8
    //   164: invokespecial 226	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   167: invokespecial 229	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   170: astore 4
    //   172: aload 10
    //   174: ifnull +40 -> 214
    //   177: aload 4
    //   179: astore_3
    //   180: aload 10
    //   182: getstatic 235	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   185: bipush 80
    //   187: aload 4
    //   189: invokevirtual 241	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   192: pop
    //   193: aload 4
    //   195: astore_3
    //   196: aload 4
    //   198: invokevirtual 244	java/io/BufferedOutputStream:flush	()V
    //   201: goto +15 -> 216
    //   204: astore 5
    //   206: goto +33 -> 239
    //   209: astore 5
    //   211: goto +113 -> 324
    //   214: iconst_2
    //   215: istore_1
    //   216: aload 4
    //   218: invokevirtual 247	java/io/BufferedOutputStream:close	()V
    //   221: goto +198 -> 419
    //   224: goto +195 -> 419
    //   227: astore_3
    //   228: aconst_null
    //   229: astore 4
    //   231: goto +931 -> 1162
    //   234: astore 5
    //   236: aconst_null
    //   237: astore 4
    //   239: aload 4
    //   241: astore_3
    //   242: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   245: ifeq +948 -> 1193
    //   248: aload 4
    //   250: astore_3
    //   251: new 104	java/lang/StringBuilder
    //   254: dup
    //   255: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   258: astore 9
    //   260: aload 4
    //   262: astore_3
    //   263: aload 9
    //   265: ldc 249
    //   267: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: pop
    //   271: aload 4
    //   273: astore_3
    //   274: aload 9
    //   276: aload 6
    //   278: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: pop
    //   282: aload 4
    //   284: astore_3
    //   285: aload 9
    //   287: ldc 251
    //   289: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: pop
    //   293: aload 4
    //   295: astore_3
    //   296: aload 9
    //   298: aload 5
    //   300: invokevirtual 254	java/io/IOException:getMessage	()Ljava/lang/String;
    //   303: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: pop
    //   307: aload 4
    //   309: astore_3
    //   310: ldc 129
    //   312: iconst_2
    //   313: aload 9
    //   315: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   318: invokestatic 256	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   321: goto +872 -> 1193
    //   324: aload 4
    //   326: astore_3
    //   327: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   330: ifeq +77 -> 407
    //   333: aload 4
    //   335: astore_3
    //   336: new 104	java/lang/StringBuilder
    //   339: dup
    //   340: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   343: astore 9
    //   345: aload 4
    //   347: astore_3
    //   348: aload 9
    //   350: ldc 249
    //   352: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: pop
    //   356: aload 4
    //   358: astore_3
    //   359: aload 9
    //   361: aload 6
    //   363: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   366: pop
    //   367: aload 4
    //   369: astore_3
    //   370: aload 9
    //   372: ldc_w 258
    //   375: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   378: pop
    //   379: aload 4
    //   381: astore_3
    //   382: aload 9
    //   384: aload 5
    //   386: invokevirtual 259	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   389: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   392: pop
    //   393: aload 4
    //   395: astore_3
    //   396: ldc 129
    //   398: iconst_2
    //   399: aload 9
    //   401: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   404: invokestatic 256	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   407: aload 4
    //   409: ifnull +8 -> 417
    //   412: aload 4
    //   414: invokevirtual 247	java/io/BufferedOutputStream:close	()V
    //   417: iconst_2
    //   418: istore_1
    //   419: aload 8
    //   421: invokevirtual 204	java/io/File:exists	()Z
    //   424: ifeq +713 -> 1137
    //   427: new 261	java/io/FileInputStream
    //   430: dup
    //   431: aload 6
    //   433: invokespecial 262	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   436: astore_3
    //   437: aload_3
    //   438: astore 4
    //   440: aload_3
    //   441: aload 8
    //   443: invokevirtual 265	java/io/File:length	()J
    //   446: invokestatic 271	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   449: invokestatic 277	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   452: astore 8
    //   454: aload_3
    //   455: invokevirtual 278	java/io/FileInputStream:close	()V
    //   458: goto +67 -> 525
    //   461: astore 4
    //   463: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   466: ifeq +59 -> 525
    //   469: new 104	java/lang/StringBuilder
    //   472: dup
    //   473: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   476: astore 5
    //   478: aload 5
    //   480: ldc_w 280
    //   483: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   486: pop
    //   487: aload 5
    //   489: aload 6
    //   491: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   494: pop
    //   495: aload 5
    //   497: ldc 251
    //   499: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   502: pop
    //   503: aload 5
    //   505: aload 4
    //   507: invokevirtual 254	java/io/IOException:getMessage	()Ljava/lang/String;
    //   510: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   513: pop
    //   514: ldc 129
    //   516: iconst_2
    //   517: aload 5
    //   519: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   522: invokestatic 256	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   525: aload 8
    //   527: invokestatic 286	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   530: ifeq +75 -> 605
    //   533: aload_3
    //   534: astore 4
    //   536: iload_1
    //   537: istore_2
    //   538: aload 6
    //   540: astore 5
    //   542: aload 8
    //   544: astore 7
    //   546: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   549: ifeq +297 -> 846
    //   552: new 104	java/lang/StringBuilder
    //   555: dup
    //   556: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   559: astore 4
    //   561: aload 4
    //   563: ldc_w 288
    //   566: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   569: pop
    //   570: aload 4
    //   572: aload 8
    //   574: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   577: pop
    //   578: ldc 129
    //   580: iconst_2
    //   581: aload 4
    //   583: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   586: invokestatic 256	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   589: aload_3
    //   590: astore 4
    //   592: iload_1
    //   593: istore_2
    //   594: aload 6
    //   596: astore 5
    //   598: aload 8
    //   600: astore 7
    //   602: goto +244 -> 846
    //   605: aload 8
    //   607: ldc 179
    //   609: invokestatic 184	com/tencent/mobileqq/shortvideo/SVUtils:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   612: astore 9
    //   614: aload_3
    //   615: astore 4
    //   617: iload_1
    //   618: istore_2
    //   619: aload 6
    //   621: astore 5
    //   623: aload 8
    //   625: astore 7
    //   627: aload 6
    //   629: aload 9
    //   631: invokestatic 292	com/tencent/mobileqq/utils/FileUtils:rename	(Ljava/lang/String;Ljava/lang/String;)Z
    //   634: ifeq +212 -> 846
    //   637: aload 9
    //   639: astore 5
    //   641: aload_3
    //   642: astore 4
    //   644: iload_1
    //   645: istore_2
    //   646: aload 8
    //   648: astore 7
    //   650: goto +196 -> 846
    //   653: astore 5
    //   655: goto +14 -> 669
    //   658: astore_3
    //   659: aconst_null
    //   660: astore 4
    //   662: goto +332 -> 994
    //   665: astore 5
    //   667: aconst_null
    //   668: astore_3
    //   669: aload_3
    //   670: astore 4
    //   672: aload 5
    //   674: invokevirtual 293	java/io/FileNotFoundException:printStackTrace	()V
    //   677: aload_3
    //   678: ifnull +74 -> 752
    //   681: aload_3
    //   682: invokevirtual 278	java/io/FileInputStream:close	()V
    //   685: goto +67 -> 752
    //   688: astore 4
    //   690: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   693: ifeq +59 -> 752
    //   696: new 104	java/lang/StringBuilder
    //   699: dup
    //   700: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   703: astore 5
    //   705: aload 5
    //   707: ldc_w 280
    //   710: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   713: pop
    //   714: aload 5
    //   716: aload 6
    //   718: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   721: pop
    //   722: aload 5
    //   724: ldc 251
    //   726: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   729: pop
    //   730: aload 5
    //   732: aload 4
    //   734: invokevirtual 254	java/io/IOException:getMessage	()Ljava/lang/String;
    //   737: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   740: pop
    //   741: ldc 129
    //   743: iconst_2
    //   744: aload 5
    //   746: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   749: invokestatic 256	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   752: aconst_null
    //   753: invokestatic 286	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   756: ifeq +61 -> 817
    //   759: aload 6
    //   761: astore 5
    //   763: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   766: ifeq +43 -> 809
    //   769: new 104	java/lang/StringBuilder
    //   772: dup
    //   773: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   776: astore 4
    //   778: aload 4
    //   780: ldc_w 288
    //   783: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   786: pop
    //   787: aload 4
    //   789: aconst_null
    //   790: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   793: pop
    //   794: ldc 129
    //   796: iconst_2
    //   797: aload 4
    //   799: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   802: invokestatic 256	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   805: aload 6
    //   807: astore 5
    //   809: iconst_2
    //   810: istore_2
    //   811: aload_3
    //   812: astore 4
    //   814: goto +32 -> 846
    //   817: aconst_null
    //   818: ldc 179
    //   820: invokestatic 184	com/tencent/mobileqq/shortvideo/SVUtils:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   823: astore 4
    //   825: aload 6
    //   827: astore 5
    //   829: aload 6
    //   831: aload 4
    //   833: invokestatic 292	com/tencent/mobileqq/utils/FileUtils:rename	(Ljava/lang/String;Ljava/lang/String;)Z
    //   836: ifeq -27 -> 809
    //   839: aload 4
    //   841: astore 5
    //   843: goto -34 -> 809
    //   846: aload_0
    //   847: aload 7
    //   849: putfield 96	com/tencent/mobileqq/activity/shortvideo/SendAppShortVideoTask:g	Ljava/lang/String;
    //   852: aload_0
    //   853: aload 5
    //   855: putfield 295	com/tencent/mobileqq/activity/shortvideo/SendAppShortVideoTask:f	Ljava/lang/String;
    //   858: aload 10
    //   860: ifnull +21 -> 881
    //   863: aload_0
    //   864: aload 10
    //   866: invokevirtual 298	android/graphics/Bitmap:getWidth	()I
    //   869: putfield 300	com/tencent/mobileqq/activity/shortvideo/SendAppShortVideoTask:jdField_b_of_type_Int	I
    //   872: aload_0
    //   873: aload 10
    //   875: invokevirtual 303	android/graphics/Bitmap:getHeight	()I
    //   878: putfield 305	com/tencent/mobileqq/activity/shortvideo/SendAppShortVideoTask:jdField_c_of_type_Int	I
    //   881: new 261	java/io/FileInputStream
    //   884: dup
    //   885: aload_0
    //   886: getfield 53	com/tencent/mobileqq/activity/shortvideo/SendAppShortVideoTask:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   889: invokespecial 262	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   892: astore_3
    //   893: goto +73 -> 966
    //   896: astore_3
    //   897: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   900: ifeq +61 -> 961
    //   903: new 104	java/lang/StringBuilder
    //   906: dup
    //   907: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   910: astore 5
    //   912: aload 5
    //   914: ldc_w 307
    //   917: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   920: pop
    //   921: aload 5
    //   923: aload_0
    //   924: getfield 53	com/tencent/mobileqq/activity/shortvideo/SendAppShortVideoTask:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   927: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   930: pop
    //   931: aload 5
    //   933: ldc_w 309
    //   936: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   939: pop
    //   940: aload 5
    //   942: aload_3
    //   943: invokevirtual 259	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   946: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   949: pop
    //   950: ldc 129
    //   952: iconst_2
    //   953: aload 5
    //   955: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   958: invokestatic 256	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   961: iconst_5
    //   962: istore_2
    //   963: aload 4
    //   965: astore_3
    //   966: aload_0
    //   967: aload_3
    //   968: new 196	java/io/File
    //   971: dup
    //   972: aload_0
    //   973: getfield 53	com/tencent/mobileqq/activity/shortvideo/SendAppShortVideoTask:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   976: invokespecial 198	java/io/File:<init>	(Ljava/lang/String;)V
    //   979: invokevirtual 265	java/io/File:length	()J
    //   982: invokestatic 271	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   985: invokestatic 277	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   988: putfield 88	com/tencent/mobileqq/activity/shortvideo/SendAppShortVideoTask:e	Ljava/lang/String;
    //   991: iload_2
    //   992: ireturn
    //   993: astore_3
    //   994: aload 4
    //   996: ifnull +75 -> 1071
    //   999: aload 4
    //   1001: invokevirtual 278	java/io/FileInputStream:close	()V
    //   1004: goto +67 -> 1071
    //   1007: astore 4
    //   1009: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1012: ifeq +59 -> 1071
    //   1015: new 104	java/lang/StringBuilder
    //   1018: dup
    //   1019: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   1022: astore 5
    //   1024: aload 5
    //   1026: ldc_w 280
    //   1029: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1032: pop
    //   1033: aload 5
    //   1035: aload 6
    //   1037: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1040: pop
    //   1041: aload 5
    //   1043: ldc 251
    //   1045: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1048: pop
    //   1049: aload 5
    //   1051: aload 4
    //   1053: invokevirtual 254	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1056: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1059: pop
    //   1060: ldc 129
    //   1062: iconst_2
    //   1063: aload 5
    //   1065: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1068: invokestatic 256	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1071: aconst_null
    //   1072: invokestatic 286	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1075: ifeq +48 -> 1123
    //   1078: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1081: ifeq +54 -> 1135
    //   1084: new 104	java/lang/StringBuilder
    //   1087: dup
    //   1088: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   1091: astore 4
    //   1093: aload 4
    //   1095: ldc_w 288
    //   1098: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1101: pop
    //   1102: aload 4
    //   1104: aconst_null
    //   1105: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1108: pop
    //   1109: ldc 129
    //   1111: iconst_2
    //   1112: aload 4
    //   1114: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1117: invokestatic 256	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1120: goto +15 -> 1135
    //   1123: aload 6
    //   1125: aconst_null
    //   1126: ldc 179
    //   1128: invokestatic 184	com/tencent/mobileqq/shortvideo/SVUtils:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1131: invokestatic 292	com/tencent/mobileqq/utils/FileUtils:rename	(Ljava/lang/String;Ljava/lang/String;)Z
    //   1134: pop
    //   1135: aload_3
    //   1136: athrow
    //   1137: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1140: ifeq +12 -> 1152
    //   1143: ldc 129
    //   1145: iconst_2
    //   1146: ldc_w 311
    //   1149: invokestatic 256	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1152: iconst_2
    //   1153: ireturn
    //   1154: astore 5
    //   1156: aload_3
    //   1157: astore 4
    //   1159: aload 5
    //   1161: astore_3
    //   1162: aload 4
    //   1164: ifnull +8 -> 1172
    //   1167: aload 4
    //   1169: invokevirtual 247	java/io/BufferedOutputStream:close	()V
    //   1172: goto +5 -> 1177
    //   1175: aload_3
    //   1176: athrow
    //   1177: goto -2 -> 1175
    //   1180: astore_3
    //   1181: goto -957 -> 224
    //   1184: astore_3
    //   1185: goto -768 -> 417
    //   1188: astore 4
    //   1190: goto -18 -> 1172
    //   1193: aload 4
    //   1195: ifnull -778 -> 417
    //   1198: goto -786 -> 412
    //   1201: astore 5
    //   1203: aconst_null
    //   1204: astore 4
    //   1206: goto -882 -> 324
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1209	0	this	SendAppShortVideoTask
    //   6	639	1	i	int
    //   537	455	2	j	int
    //   4	113	3	localObject1	Object
    //   146	2	3	localIOException1	java.io.IOException
    //   179	17	3	localObject2	Object
    //   227	1	3	localObject3	Object
    //   241	401	3	localObject4	Object
    //   658	1	3	localObject5	Object
    //   668	225	3	localFileInputStream	java.io.FileInputStream
    //   896	47	3	localFileNotFoundException1	java.io.FileNotFoundException
    //   965	3	3	localObject6	Object
    //   993	164	3	localObject7	Object
    //   1161	15	3	localObject8	Object
    //   1180	1	3	localIOException2	java.io.IOException
    //   1184	1	3	localIOException3	java.io.IOException
    //   170	269	4	localObject9	Object
    //   461	45	4	localIOException4	java.io.IOException
    //   534	137	4	localObject10	Object
    //   688	45	4	localIOException5	java.io.IOException
    //   776	224	4	localObject11	Object
    //   1007	45	4	localIOException6	java.io.IOException
    //   1091	77	4	localObject12	Object
    //   1188	6	4	localIOException7	java.io.IOException
    //   1204	1	4	localObject13	Object
    //   204	1	5	localIOException8	java.io.IOException
    //   209	1	5	localFileNotFoundException2	java.io.FileNotFoundException
    //   234	151	5	localIOException9	java.io.IOException
    //   476	164	5	localObject14	Object
    //   653	1	5	localFileNotFoundException3	java.io.FileNotFoundException
    //   665	8	5	localFileNotFoundException4	java.io.FileNotFoundException
    //   703	361	5	localObject15	Object
    //   1154	6	5	localObject16	Object
    //   1201	1	5	localFileNotFoundException5	java.io.FileNotFoundException
    //   46	1078	6	str	String
    //   152	696	7	localObject17	Object
    //   87	560	8	localObject18	Object
    //   258	380	9	localObject19	Object
    //   12	862	10	localBitmap	android.graphics.Bitmap
    // Exception table:
    //   from	to	target	type
    //   137	143	146	java/io/IOException
    //   180	193	204	java/io/IOException
    //   196	201	204	java/io/IOException
    //   180	193	209	java/io/FileNotFoundException
    //   196	201	209	java/io/FileNotFoundException
    //   154	172	227	finally
    //   154	172	234	java/io/IOException
    //   454	458	461	java/io/IOException
    //   440	454	653	java/io/FileNotFoundException
    //   427	437	658	finally
    //   427	437	665	java/io/FileNotFoundException
    //   681	685	688	java/io/IOException
    //   881	893	896	java/io/FileNotFoundException
    //   440	454	993	finally
    //   672	677	993	finally
    //   999	1004	1007	java/io/IOException
    //   180	193	1154	finally
    //   196	201	1154	finally
    //   242	248	1154	finally
    //   251	260	1154	finally
    //   263	271	1154	finally
    //   274	282	1154	finally
    //   285	293	1154	finally
    //   296	307	1154	finally
    //   310	321	1154	finally
    //   327	333	1154	finally
    //   336	345	1154	finally
    //   348	356	1154	finally
    //   359	367	1154	finally
    //   370	379	1154	finally
    //   382	393	1154	finally
    //   396	407	1154	finally
    //   216	221	1180	java/io/IOException
    //   412	417	1184	java/io/IOException
    //   1167	1172	1188	java/io/IOException
    //   154	172	1201	java/io/FileNotFoundException
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
      if (this.jdField_a_of_type_AndroidAppProgressDialog != null)
      {
        a();
      }
      else
      {
        this.jdField_a_of_type_AndroidAppProgressDialog = new ReportProgressDialog(paramContext, 2131756189);
        this.jdField_a_of_type_AndroidAppProgressDialog.setCancelable(true);
        this.jdField_a_of_type_AndroidAppProgressDialog.show();
        this.jdField_a_of_type_AndroidAppProgressDialog.setContentView(2131559561);
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidAppProgressDialog.findViewById(2131372646));
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramInt);
      if (!this.jdField_a_of_type_AndroidAppProgressDialog.isShowing())
      {
        this.jdField_a_of_type_AndroidAppProgressDialog.show();
        return;
      }
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
    case 5: 
      b((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 2131719109);
      return;
    case 4: 
      b((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 2131719083);
      return;
    case 3: 
      b((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 2131719112);
      return;
    case 2: 
    case 6: 
      b((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 2131719117);
      return;
    }
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
    Object localObject2 = SVBusiUtil.a(0, 2);
    Object localObject1 = ShortVideoBusiManager.a(2, paramInteger, (ShortVideoReq)localObject2);
    ((ShortVideoReq)localObject2).a((ShortVideoUploadInfo)localObject1);
    localObject2 = ((IShortVideoFactory)QRoute.api(IShortVideoFactory.class)).getAioShortVideoSendOperator(((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).app);
    localObject1 = ((IShortVideoOperator)localObject2).a((ShortVideoUploadInfo)localObject1);
    ((IShortVideoOperator)localObject2).a((MessageRecord)localObject1);
    localObject2 = (MessageForShortVideo)localObject1;
    localObject2 = ShortVideoUtils.realGetShortVideoSavePath(((MessageForShortVideo)localObject2).md5, ((MessageForShortVideo)localObject2).frienduin, ((MessageForShortVideo)localObject2).uniseq, "mp4");
    FileUtils.copyFile(this.jdField_b_of_type_JavaLangString, (String)localObject2);
    localObject2 = SVBusiUtil.a(0, 2);
    localObject1 = ShortVideoBusiManager.a(localObject1, (ShortVideoReq)localObject2);
    ((ShortVideoUploadInfo)localObject1).b = false;
    ((ShortVideoReq)localObject2).a((ShortVideoUploadInfo)localObject1);
    ShortVideoBusiManager.a((ShortVideoReq)localObject2, ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).app);
    localObject2 = ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getIntent();
    if (((Intent)localObject2).getBooleanExtra("start_init_activity_after_sended", true))
    {
      localObject1 = ((Intent)localObject2).getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
      paramInteger.setClassName(((Intent)localObject2).getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME"), (String)localObject1);
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("SendAppShortVideoTask onPostExecute() INIT_ACTIVITY_CLASS_NAME=");
        ((StringBuilder)localObject2).append((String)localObject1);
        QLog.d("SendVideoActivity", 2, ((StringBuilder)localObject2).toString());
      }
      paramInteger.addFlags(603979776);
      ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).startActivity(paramInteger);
    }
    ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).finish();
    ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).overridePendingTransition(0, 2130771994);
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
    a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 2131694878);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.shortvideo.SendAppShortVideoTask
 * JD-Core Version:    0.7.0.1
 */