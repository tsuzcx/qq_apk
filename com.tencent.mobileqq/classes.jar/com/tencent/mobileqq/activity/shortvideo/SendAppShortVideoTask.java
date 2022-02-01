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
  WeakReference<BaseActivity> a;
  String b;
  String c;
  long d;
  long e;
  String f;
  int g;
  String h;
  String i;
  String j;
  int k;
  int l;
  String m;
  TextView n;
  ProgressDialog o;
  
  public SendAppShortVideoTask(BaseActivity paramBaseActivity)
  {
    this.a = new WeakReference(paramBaseActivity);
    paramBaseActivity = paramBaseActivity.getIntent();
    this.c = paramBaseActivity.getExtras().getString("file_send_path");
    this.e = paramBaseActivity.getExtras().getLong("file_send_duration");
    this.d = paramBaseActivity.getExtras().getLong("file_send_size");
    this.f = paramBaseActivity.getExtras().getString("uin");
    this.g = paramBaseActivity.getIntExtra("uintype", -1);
    this.h = paramBaseActivity.getStringExtra("file_source");
    this.i = paramBaseActivity.getExtras().getString("file_shortvideo_md5");
    this.b = paramBaseActivity.getExtras().getString("activity_before_enter_send_video");
    this.m = paramBaseActivity.getExtras().getString("thumbfile_md5");
    if (QLog.isColorLevel())
    {
      paramBaseActivity = new StringBuilder();
      paramBaseActivity.append(" SendAppShortVideoTask(),  mVideoPath :");
      paramBaseActivity.append(this.c);
      paramBaseActivity.append(", mDuration:");
      paramBaseActivity.append(this.e);
      paramBaseActivity.append(", mFileSize:");
      paramBaseActivity.append(this.d);
      paramBaseActivity.append(",mUin");
      paramBaseActivity.append(this.f);
      paramBaseActivity.append(",mUinType:");
      paramBaseActivity.append(this.g);
      paramBaseActivity.append(",mFileSource:");
      paramBaseActivity.append(this.h);
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
    //   1: getfield 61	com/tencent/mobileqq/activity/shortvideo/SendAppShortVideoTask:c	Ljava/lang/String;
    //   4: astore_3
    //   5: iconst_1
    //   6: istore_1
    //   7: aload_3
    //   8: iconst_1
    //   9: invokestatic 177	android/media/ThumbnailUtils:createVideoThumbnail	(Ljava/lang/String;I)Landroid/graphics/Bitmap;
    //   12: astore 10
    //   14: new 112	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   21: astore_3
    //   22: aload_3
    //   23: ldc 179
    //   25: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: pop
    //   29: aload_3
    //   30: invokestatic 185	java/lang/System:currentTimeMillis	()J
    //   33: invokevirtual 124	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   36: pop
    //   37: aload_3
    //   38: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: ldc 187
    //   43: invokestatic 192	com/tencent/mobileqq/shortvideo/SVUtils:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   46: astore 6
    //   48: new 112	java/lang/StringBuilder
    //   51: dup
    //   52: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   55: astore_3
    //   56: aload_3
    //   57: invokestatic 194	com/tencent/mobileqq/shortvideo/SVUtils:b	()Ljava/lang/String;
    //   60: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: pop
    //   64: aload_3
    //   65: ldc 196
    //   67: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: pop
    //   71: aload_3
    //   72: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: invokestatic 202	com/tencent/mobileqq/utils/FileUtils:createFileIfNotExits	(Ljava/lang/String;)V
    //   78: new 204	java/io/File
    //   81: dup
    //   82: aload 6
    //   84: invokespecial 206	java/io/File:<init>	(Ljava/lang/String;)V
    //   87: astore 8
    //   89: new 204	java/io/File
    //   92: dup
    //   93: aload 8
    //   95: invokevirtual 209	java/io/File:getParent	()Ljava/lang/String;
    //   98: invokespecial 206	java/io/File:<init>	(Ljava/lang/String;)V
    //   101: astore_3
    //   102: aload_3
    //   103: invokevirtual 212	java/io/File:exists	()Z
    //   106: ifeq +10 -> 116
    //   109: aload_3
    //   110: invokevirtual 215	java/io/File:isDirectory	()Z
    //   113: ifne +8 -> 121
    //   116: aload_3
    //   117: invokevirtual 218	java/io/File:mkdirs	()Z
    //   120: pop
    //   121: aload 8
    //   123: invokevirtual 212	java/io/File:exists	()Z
    //   126: ifeq +11 -> 137
    //   129: aload 8
    //   131: invokevirtual 221	java/io/File:isFile	()Z
    //   134: ifne +17 -> 151
    //   137: aload 8
    //   139: invokevirtual 224	java/io/File:createNewFile	()Z
    //   142: pop
    //   143: goto +8 -> 151
    //   146: astore_3
    //   147: aload_3
    //   148: invokevirtual 227	java/io/IOException:printStackTrace	()V
    //   151: aconst_null
    //   152: astore 7
    //   154: new 229	java/io/BufferedOutputStream
    //   157: dup
    //   158: new 231	java/io/FileOutputStream
    //   161: dup
    //   162: aload 8
    //   164: invokespecial 234	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   167: invokespecial 237	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   170: astore 4
    //   172: aload 10
    //   174: ifnull +40 -> 214
    //   177: aload 4
    //   179: astore_3
    //   180: aload 10
    //   182: getstatic 243	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   185: bipush 80
    //   187: aload 4
    //   189: invokevirtual 249	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   192: pop
    //   193: aload 4
    //   195: astore_3
    //   196: aload 4
    //   198: invokevirtual 252	java/io/BufferedOutputStream:flush	()V
    //   201: goto +15 -> 216
    //   204: astore 5
    //   206: goto +33 -> 239
    //   209: astore 5
    //   211: goto +115 -> 326
    //   214: iconst_2
    //   215: istore_1
    //   216: aload 4
    //   218: invokevirtual 255	java/io/BufferedOutputStream:close	()V
    //   221: goto +201 -> 422
    //   224: goto +198 -> 422
    //   227: astore_3
    //   228: aconst_null
    //   229: astore 4
    //   231: goto +937 -> 1168
    //   234: astore 5
    //   236: aconst_null
    //   237: astore 4
    //   239: aload 4
    //   241: astore_3
    //   242: invokestatic 110	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   245: ifeq +954 -> 1199
    //   248: aload 4
    //   250: astore_3
    //   251: new 112	java/lang/StringBuilder
    //   254: dup
    //   255: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   258: astore 9
    //   260: aload 4
    //   262: astore_3
    //   263: aload 9
    //   265: ldc_w 257
    //   268: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: pop
    //   272: aload 4
    //   274: astore_3
    //   275: aload 9
    //   277: aload 6
    //   279: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: pop
    //   283: aload 4
    //   285: astore_3
    //   286: aload 9
    //   288: ldc_w 259
    //   291: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   294: pop
    //   295: aload 4
    //   297: astore_3
    //   298: aload 9
    //   300: aload 5
    //   302: invokevirtual 262	java/io/IOException:getMessage	()Ljava/lang/String;
    //   305: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: pop
    //   309: aload 4
    //   311: astore_3
    //   312: ldc 137
    //   314: iconst_2
    //   315: aload 9
    //   317: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   320: invokestatic 264	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   323: goto +876 -> 1199
    //   326: aload 4
    //   328: astore_3
    //   329: invokestatic 110	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   332: ifeq +78 -> 410
    //   335: aload 4
    //   337: astore_3
    //   338: new 112	java/lang/StringBuilder
    //   341: dup
    //   342: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   345: astore 9
    //   347: aload 4
    //   349: astore_3
    //   350: aload 9
    //   352: ldc_w 257
    //   355: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   358: pop
    //   359: aload 4
    //   361: astore_3
    //   362: aload 9
    //   364: aload 6
    //   366: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   369: pop
    //   370: aload 4
    //   372: astore_3
    //   373: aload 9
    //   375: ldc_w 266
    //   378: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   381: pop
    //   382: aload 4
    //   384: astore_3
    //   385: aload 9
    //   387: aload 5
    //   389: invokevirtual 267	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   392: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   395: pop
    //   396: aload 4
    //   398: astore_3
    //   399: ldc 137
    //   401: iconst_2
    //   402: aload 9
    //   404: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   407: invokestatic 264	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   410: aload 4
    //   412: ifnull +8 -> 420
    //   415: aload 4
    //   417: invokevirtual 255	java/io/BufferedOutputStream:close	()V
    //   420: iconst_2
    //   421: istore_1
    //   422: aload 8
    //   424: invokevirtual 212	java/io/File:exists	()Z
    //   427: ifeq +716 -> 1143
    //   430: new 269	java/io/FileInputStream
    //   433: dup
    //   434: aload 6
    //   436: invokespecial 270	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   439: astore_3
    //   440: aload_3
    //   441: astore 4
    //   443: aload_3
    //   444: aload 8
    //   446: invokevirtual 273	java/io/File:length	()J
    //   449: invokestatic 279	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   452: invokestatic 285	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   455: astore 8
    //   457: aload_3
    //   458: invokevirtual 286	java/io/FileInputStream:close	()V
    //   461: goto +68 -> 529
    //   464: astore 4
    //   466: invokestatic 110	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   469: ifeq +60 -> 529
    //   472: new 112	java/lang/StringBuilder
    //   475: dup
    //   476: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   479: astore 5
    //   481: aload 5
    //   483: ldc_w 288
    //   486: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   489: pop
    //   490: aload 5
    //   492: aload 6
    //   494: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   497: pop
    //   498: aload 5
    //   500: ldc_w 259
    //   503: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   506: pop
    //   507: aload 5
    //   509: aload 4
    //   511: invokevirtual 262	java/io/IOException:getMessage	()Ljava/lang/String;
    //   514: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   517: pop
    //   518: ldc 137
    //   520: iconst_2
    //   521: aload 5
    //   523: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   526: invokestatic 264	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   529: aload 8
    //   531: invokestatic 294	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   534: ifeq +75 -> 609
    //   537: aload_3
    //   538: astore 4
    //   540: iload_1
    //   541: istore_2
    //   542: aload 6
    //   544: astore 5
    //   546: aload 8
    //   548: astore 7
    //   550: invokestatic 110	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   553: ifeq +298 -> 851
    //   556: new 112	java/lang/StringBuilder
    //   559: dup
    //   560: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   563: astore 4
    //   565: aload 4
    //   567: ldc_w 296
    //   570: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   573: pop
    //   574: aload 4
    //   576: aload 8
    //   578: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   581: pop
    //   582: ldc 137
    //   584: iconst_2
    //   585: aload 4
    //   587: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   590: invokestatic 264	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   593: aload_3
    //   594: astore 4
    //   596: iload_1
    //   597: istore_2
    //   598: aload 6
    //   600: astore 5
    //   602: aload 8
    //   604: astore 7
    //   606: goto +245 -> 851
    //   609: aload 8
    //   611: ldc 187
    //   613: invokestatic 192	com/tencent/mobileqq/shortvideo/SVUtils:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   616: astore 9
    //   618: aload_3
    //   619: astore 4
    //   621: iload_1
    //   622: istore_2
    //   623: aload 6
    //   625: astore 5
    //   627: aload 8
    //   629: astore 7
    //   631: aload 6
    //   633: aload 9
    //   635: invokestatic 300	com/tencent/mobileqq/utils/FileUtils:rename	(Ljava/lang/String;Ljava/lang/String;)Z
    //   638: ifeq +213 -> 851
    //   641: aload 9
    //   643: astore 5
    //   645: aload_3
    //   646: astore 4
    //   648: iload_1
    //   649: istore_2
    //   650: aload 8
    //   652: astore 7
    //   654: goto +197 -> 851
    //   657: astore 5
    //   659: goto +14 -> 673
    //   662: astore_3
    //   663: aconst_null
    //   664: astore 4
    //   666: goto +333 -> 999
    //   669: astore 5
    //   671: aconst_null
    //   672: astore_3
    //   673: aload_3
    //   674: astore 4
    //   676: aload 5
    //   678: invokevirtual 301	java/io/FileNotFoundException:printStackTrace	()V
    //   681: aload_3
    //   682: ifnull +75 -> 757
    //   685: aload_3
    //   686: invokevirtual 286	java/io/FileInputStream:close	()V
    //   689: goto +68 -> 757
    //   692: astore 4
    //   694: invokestatic 110	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   697: ifeq +60 -> 757
    //   700: new 112	java/lang/StringBuilder
    //   703: dup
    //   704: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   707: astore 5
    //   709: aload 5
    //   711: ldc_w 288
    //   714: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   717: pop
    //   718: aload 5
    //   720: aload 6
    //   722: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   725: pop
    //   726: aload 5
    //   728: ldc_w 259
    //   731: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   734: pop
    //   735: aload 5
    //   737: aload 4
    //   739: invokevirtual 262	java/io/IOException:getMessage	()Ljava/lang/String;
    //   742: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   745: pop
    //   746: ldc 137
    //   748: iconst_2
    //   749: aload 5
    //   751: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   754: invokestatic 264	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   757: aconst_null
    //   758: invokestatic 294	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   761: ifeq +61 -> 822
    //   764: aload 6
    //   766: astore 5
    //   768: invokestatic 110	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   771: ifeq +43 -> 814
    //   774: new 112	java/lang/StringBuilder
    //   777: dup
    //   778: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   781: astore 4
    //   783: aload 4
    //   785: ldc_w 296
    //   788: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   791: pop
    //   792: aload 4
    //   794: aconst_null
    //   795: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   798: pop
    //   799: ldc 137
    //   801: iconst_2
    //   802: aload 4
    //   804: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   807: invokestatic 264	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   810: aload 6
    //   812: astore 5
    //   814: iconst_2
    //   815: istore_2
    //   816: aload_3
    //   817: astore 4
    //   819: goto +32 -> 851
    //   822: aconst_null
    //   823: ldc 187
    //   825: invokestatic 192	com/tencent/mobileqq/shortvideo/SVUtils:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   828: astore 4
    //   830: aload 6
    //   832: astore 5
    //   834: aload 6
    //   836: aload 4
    //   838: invokestatic 300	com/tencent/mobileqq/utils/FileUtils:rename	(Ljava/lang/String;Ljava/lang/String;)Z
    //   841: ifeq -27 -> 814
    //   844: aload 4
    //   846: astore 5
    //   848: goto -34 -> 814
    //   851: aload_0
    //   852: aload 7
    //   854: putfield 104	com/tencent/mobileqq/activity/shortvideo/SendAppShortVideoTask:m	Ljava/lang/String;
    //   857: aload_0
    //   858: aload 5
    //   860: putfield 303	com/tencent/mobileqq/activity/shortvideo/SendAppShortVideoTask:j	Ljava/lang/String;
    //   863: aload 10
    //   865: ifnull +21 -> 886
    //   868: aload_0
    //   869: aload 10
    //   871: invokevirtual 306	android/graphics/Bitmap:getWidth	()I
    //   874: putfield 308	com/tencent/mobileqq/activity/shortvideo/SendAppShortVideoTask:k	I
    //   877: aload_0
    //   878: aload 10
    //   880: invokevirtual 311	android/graphics/Bitmap:getHeight	()I
    //   883: putfield 313	com/tencent/mobileqq/activity/shortvideo/SendAppShortVideoTask:l	I
    //   886: new 269	java/io/FileInputStream
    //   889: dup
    //   890: aload_0
    //   891: getfield 61	com/tencent/mobileqq/activity/shortvideo/SendAppShortVideoTask:c	Ljava/lang/String;
    //   894: invokespecial 270	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   897: astore_3
    //   898: goto +73 -> 971
    //   901: astore_3
    //   902: invokestatic 110	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   905: ifeq +61 -> 966
    //   908: new 112	java/lang/StringBuilder
    //   911: dup
    //   912: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   915: astore 5
    //   917: aload 5
    //   919: ldc_w 315
    //   922: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   925: pop
    //   926: aload 5
    //   928: aload_0
    //   929: getfield 61	com/tencent/mobileqq/activity/shortvideo/SendAppShortVideoTask:c	Ljava/lang/String;
    //   932: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   935: pop
    //   936: aload 5
    //   938: ldc_w 317
    //   941: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   944: pop
    //   945: aload 5
    //   947: aload_3
    //   948: invokevirtual 267	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   951: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   954: pop
    //   955: ldc 137
    //   957: iconst_2
    //   958: aload 5
    //   960: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   963: invokestatic 264	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   966: iconst_5
    //   967: istore_2
    //   968: aload 4
    //   970: astore_3
    //   971: aload_0
    //   972: aload_3
    //   973: new 204	java/io/File
    //   976: dup
    //   977: aload_0
    //   978: getfield 61	com/tencent/mobileqq/activity/shortvideo/SendAppShortVideoTask:c	Ljava/lang/String;
    //   981: invokespecial 206	java/io/File:<init>	(Ljava/lang/String;)V
    //   984: invokevirtual 273	java/io/File:length	()J
    //   987: invokestatic 279	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   990: invokestatic 285	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   993: putfield 96	com/tencent/mobileqq/activity/shortvideo/SendAppShortVideoTask:i	Ljava/lang/String;
    //   996: iload_2
    //   997: ireturn
    //   998: astore_3
    //   999: aload 4
    //   1001: ifnull +76 -> 1077
    //   1004: aload 4
    //   1006: invokevirtual 286	java/io/FileInputStream:close	()V
    //   1009: goto +68 -> 1077
    //   1012: astore 4
    //   1014: invokestatic 110	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1017: ifeq +60 -> 1077
    //   1020: new 112	java/lang/StringBuilder
    //   1023: dup
    //   1024: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   1027: astore 5
    //   1029: aload 5
    //   1031: ldc_w 288
    //   1034: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1037: pop
    //   1038: aload 5
    //   1040: aload 6
    //   1042: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1045: pop
    //   1046: aload 5
    //   1048: ldc_w 259
    //   1051: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1054: pop
    //   1055: aload 5
    //   1057: aload 4
    //   1059: invokevirtual 262	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1062: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1065: pop
    //   1066: ldc 137
    //   1068: iconst_2
    //   1069: aload 5
    //   1071: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1074: invokestatic 264	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1077: aconst_null
    //   1078: invokestatic 294	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1081: ifeq +48 -> 1129
    //   1084: invokestatic 110	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1087: ifeq +54 -> 1141
    //   1090: new 112	java/lang/StringBuilder
    //   1093: dup
    //   1094: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   1097: astore 4
    //   1099: aload 4
    //   1101: ldc_w 296
    //   1104: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1107: pop
    //   1108: aload 4
    //   1110: aconst_null
    //   1111: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1114: pop
    //   1115: ldc 137
    //   1117: iconst_2
    //   1118: aload 4
    //   1120: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1123: invokestatic 264	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1126: goto +15 -> 1141
    //   1129: aload 6
    //   1131: aconst_null
    //   1132: ldc 187
    //   1134: invokestatic 192	com/tencent/mobileqq/shortvideo/SVUtils:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1137: invokestatic 300	com/tencent/mobileqq/utils/FileUtils:rename	(Ljava/lang/String;Ljava/lang/String;)Z
    //   1140: pop
    //   1141: aload_3
    //   1142: athrow
    //   1143: invokestatic 110	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1146: ifeq +12 -> 1158
    //   1149: ldc 137
    //   1151: iconst_2
    //   1152: ldc_w 319
    //   1155: invokestatic 264	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1158: iconst_2
    //   1159: ireturn
    //   1160: astore 5
    //   1162: aload_3
    //   1163: astore 4
    //   1165: aload 5
    //   1167: astore_3
    //   1168: aload 4
    //   1170: ifnull +8 -> 1178
    //   1173: aload 4
    //   1175: invokevirtual 255	java/io/BufferedOutputStream:close	()V
    //   1178: goto +5 -> 1183
    //   1181: aload_3
    //   1182: athrow
    //   1183: goto -2 -> 1181
    //   1186: astore_3
    //   1187: goto -963 -> 224
    //   1190: astore_3
    //   1191: goto -771 -> 420
    //   1194: astore 4
    //   1196: goto -18 -> 1178
    //   1199: aload 4
    //   1201: ifnull -781 -> 420
    //   1204: goto -789 -> 415
    //   1207: astore 5
    //   1209: aconst_null
    //   1210: astore 4
    //   1212: goto -886 -> 326
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1215	0	this	SendAppShortVideoTask
    //   6	643	1	i1	int
    //   541	456	2	i2	int
    //   4	113	3	localObject1	Object
    //   146	2	3	localIOException1	java.io.IOException
    //   179	17	3	localObject2	Object
    //   227	1	3	localObject3	Object
    //   241	405	3	localObject4	Object
    //   662	1	3	localObject5	Object
    //   672	226	3	localFileInputStream	java.io.FileInputStream
    //   901	47	3	localFileNotFoundException1	java.io.FileNotFoundException
    //   970	3	3	localObject6	Object
    //   998	165	3	localObject7	Object
    //   1167	15	3	localObject8	Object
    //   1186	1	3	localIOException2	java.io.IOException
    //   1190	1	3	localIOException3	java.io.IOException
    //   170	272	4	localObject9	Object
    //   464	46	4	localIOException4	java.io.IOException
    //   538	137	4	localObject10	Object
    //   692	46	4	localIOException5	java.io.IOException
    //   781	224	4	localObject11	Object
    //   1012	46	4	localIOException6	java.io.IOException
    //   1097	77	4	localObject12	Object
    //   1194	6	4	localIOException7	java.io.IOException
    //   1210	1	4	localObject13	Object
    //   204	1	5	localIOException8	java.io.IOException
    //   209	1	5	localFileNotFoundException2	java.io.FileNotFoundException
    //   234	154	5	localIOException9	java.io.IOException
    //   479	165	5	localObject14	Object
    //   657	1	5	localFileNotFoundException3	java.io.FileNotFoundException
    //   669	8	5	localFileNotFoundException4	java.io.FileNotFoundException
    //   707	363	5	localObject15	Object
    //   1160	6	5	localObject16	Object
    //   1207	1	5	localFileNotFoundException5	java.io.FileNotFoundException
    //   46	1084	6	str	String
    //   152	701	7	localObject17	Object
    //   87	564	8	localObject18	Object
    //   258	384	9	localObject19	Object
    //   12	867	10	localBitmap	android.graphics.Bitmap
    // Exception table:
    //   from	to	target	type
    //   137	143	146	java/io/IOException
    //   180	193	204	java/io/IOException
    //   196	201	204	java/io/IOException
    //   180	193	209	java/io/FileNotFoundException
    //   196	201	209	java/io/FileNotFoundException
    //   154	172	227	finally
    //   154	172	234	java/io/IOException
    //   457	461	464	java/io/IOException
    //   443	457	657	java/io/FileNotFoundException
    //   430	440	662	finally
    //   430	440	669	java/io/FileNotFoundException
    //   685	689	692	java/io/IOException
    //   886	898	901	java/io/FileNotFoundException
    //   443	457	998	finally
    //   676	681	998	finally
    //   1004	1009	1012	java/io/IOException
    //   180	193	1160	finally
    //   196	201	1160	finally
    //   242	248	1160	finally
    //   251	260	1160	finally
    //   263	272	1160	finally
    //   275	283	1160	finally
    //   286	295	1160	finally
    //   298	309	1160	finally
    //   312	323	1160	finally
    //   329	335	1160	finally
    //   338	347	1160	finally
    //   350	359	1160	finally
    //   362	370	1160	finally
    //   373	382	1160	finally
    //   385	396	1160	finally
    //   399	410	1160	finally
    //   216	221	1186	java/io/IOException
    //   415	420	1190	java/io/IOException
    //   1173	1178	1194	java/io/IOException
    //   154	172	1207	java/io/FileNotFoundException
  }
  
  protected Integer a(Void... paramVarArgs)
  {
    return Integer.valueOf(a());
  }
  
  void a(Context paramContext, int paramInt)
  {
    try
    {
      if (this.o != null)
      {
        b();
      }
      else
      {
        this.o = new ReportProgressDialog(paramContext, 2131953338);
        this.o.setCancelable(true);
        this.o.show();
        this.o.setContentView(2131625585);
        this.n = ((TextView)this.o.findViewById(2131440191));
      }
      this.n.setText(paramInt);
      if (!this.o.isShowing())
      {
        this.o.show();
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
    if (this.a.get() == null) {
      return;
    }
    b();
    switch (paramInteger.intValue())
    {
    default: 
      return;
    case 5: 
      b((Context)this.a.get(), 2131916645);
      return;
    case 4: 
      b((Context)this.a.get(), 2131916619);
      return;
    case 3: 
      b((Context)this.a.get(), 2131916648);
      return;
    case 2: 
    case 6: 
      b((Context)this.a.get(), 2131916653);
      return;
    }
    paramInteger = ((BaseActivity)this.a.get()).getIntent();
    paramInteger.putExtra("uin", this.f);
    paramInteger.putExtra("uintype", this.g);
    paramInteger.putExtra("file_send_path", this.c);
    paramInteger.putExtra("file_send_size", this.d);
    paramInteger.putExtra("file_send_duration", (int)(this.e / 1000L));
    paramInteger.putExtra("file_source", this.h);
    paramInteger.putExtra("thumbfile_send_path", this.j);
    paramInteger.putExtra("file_shortvideo_md5", this.i);
    paramInteger.putExtra("thumbfile_send_width", this.k);
    paramInteger.putExtra("thumbfile_send_height", this.l);
    paramInteger.putExtra("thumbfile_md5", this.m);
    paramInteger.putExtra("file_send_business_type", 2);
    Object localObject2 = SVBusiUtil.a(0, 2);
    Object localObject1 = ShortVideoBusiManager.a(2, paramInteger, (ShortVideoReq)localObject2);
    ((ShortVideoReq)localObject2).a((ShortVideoUploadInfo)localObject1);
    localObject2 = ((IShortVideoFactory)QRoute.api(IShortVideoFactory.class)).getAioShortVideoSendOperator(((BaseActivity)this.a.get()).app);
    localObject1 = ((IShortVideoOperator)localObject2).a((ShortVideoUploadInfo)localObject1);
    ((IShortVideoOperator)localObject2).a((MessageRecord)localObject1);
    localObject2 = (MessageForShortVideo)localObject1;
    localObject2 = ShortVideoUtils.realGetShortVideoSavePath(((MessageForShortVideo)localObject2).md5, ((MessageForShortVideo)localObject2).frienduin, ((MessageForShortVideo)localObject2).uniseq, "mp4");
    FileUtils.copyFile(this.c, (String)localObject2);
    localObject2 = SVBusiUtil.a(0, 2);
    localObject1 = ShortVideoBusiManager.a(localObject1, (ShortVideoReq)localObject2);
    ((ShortVideoUploadInfo)localObject1).w = false;
    ((ShortVideoReq)localObject2).a((ShortVideoUploadInfo)localObject1);
    ShortVideoBusiManager.a((ShortVideoReq)localObject2, ((BaseActivity)this.a.get()).app);
    localObject2 = ((BaseActivity)this.a.get()).getIntent();
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
      ((BaseActivity)this.a.get()).startActivity(paramInteger);
    }
    ((BaseActivity)this.a.get()).finish();
    ((BaseActivity)this.a.get()).overridePendingTransition(0, 2130771997);
  }
  
  void b()
  {
    try
    {
      if (this.o != null) {
        this.o.cancel();
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
    a((Context)this.a.get(), 2131892581);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.shortvideo.SendAppShortVideoTask
 * JD-Core Version:    0.7.0.1
 */