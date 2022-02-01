package com.tencent.mobileqq.activity.shortvideo;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmedia.ordersend.IOrderMediaMsgService;
import com.tencent.mobileqq.shortvideo.SVBusiUtil;
import com.tencent.mobileqq.shortvideo.ShortVideoBusiManager;
import com.tencent.mobileqq.shortvideo.ShortVideoReq;
import com.tencent.mobileqq.shortvideo.ShortVideoUploadInfo;
import com.tencent.mobileqq.shortvideo.api.IShortVideoFactory;
import com.tencent.mobileqq.shortvideo.api.IShortVideoOperator;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportProgressDialog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class SendVideoTask
  extends AsyncTask<Void, Void, Integer>
{
  WeakReference<BaseActivity> a;
  String b;
  public String c;
  ArrayList<String> d;
  long e;
  long f;
  String g;
  int h;
  String i;
  String j;
  String k;
  int l;
  int m;
  String n;
  int o;
  int p;
  Bitmap q;
  TextView r;
  ProgressDialog s;
  boolean t;
  boolean u;
  
  public SendVideoTask(BaseActivity paramBaseActivity, Intent paramIntent)
  {
    this.a = new WeakReference(paramBaseActivity);
    paramBaseActivity = paramBaseActivity.getIntent();
    if (paramIntent != null) {
      paramBaseActivity = paramIntent;
    }
    this.c = paramBaseActivity.getExtras().getString("file_send_path");
    this.d = paramBaseActivity.getStringArrayListExtra("PhotoConst.PHOTO_PATHS_BY_FILE");
    this.f = paramBaseActivity.getExtras().getLong("file_send_duration");
    this.e = paramBaseActivity.getExtras().getLong("file_send_size");
    this.g = paramBaseActivity.getExtras().getString("uin");
    this.h = paramBaseActivity.getIntExtra("uintype", -1);
    this.i = paramBaseActivity.getStringExtra("file_source");
    this.j = paramBaseActivity.getExtras().getString("file_shortvideo_md5");
    this.b = paramBaseActivity.getExtras().getString("activity_before_enter_send_video");
    this.t = paramBaseActivity.getExtras().getBoolean("send_in_background");
    boolean bool = false;
    if (paramBaseActivity.getIntExtra("PhotoConst.SEND_SIZE_SPEC", 0) == 2) {
      bool = true;
    }
    this.u = bool;
    if (QLog.isColorLevel())
    {
      paramBaseActivity = new StringBuilder();
      paramBaseActivity.append(" SendVideoTask(),  mVideoPath :");
      paramBaseActivity.append(this.c);
      paramBaseActivity.append(", mDuration:");
      paramBaseActivity.append(this.f);
      paramBaseActivity.append(", mFileSize:");
      paramBaseActivity.append(this.e);
      paramBaseActivity.append(",mUin");
      paramBaseActivity.append(this.g);
      paramBaseActivity.append(",mUinType:");
      paramBaseActivity.append(this.h);
      paramBaseActivity.append(",mFileSource:");
      paramBaseActivity.append(this.i);
      paramBaseActivity.append(",mSendBackground = ");
      paramBaseActivity.append(this.t);
      paramBaseActivity.append(", mSendRawVideo:");
      paramBaseActivity.append(this.u);
      QLog.d("SendVideoActivity", 2, paramBaseActivity.toString());
    }
  }
  
  public static void a(BaseActivity paramBaseActivity, int paramInt, boolean paramBoolean)
  {
    QQCustomDialog localQQCustomDialog = DialogUtil.a(paramBaseActivity, 232, null, paramBaseActivity.getString(paramInt), new SendVideoTask.1(paramBoolean, paramBaseActivity), null);
    if (!paramBaseActivity.isFinishing()) {
      localQQCustomDialog.show();
    }
  }
  
  /* Error */
  public int a()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 49	com/tencent/mobileqq/activity/shortvideo/SendVideoTask:a	Ljava/lang/ref/WeakReference;
    //   4: invokevirtual 213	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   7: checkcast 215	android/content/Context
    //   10: astore 13
    //   12: aload 13
    //   14: ifnonnull +5 -> 19
    //   17: iconst_5
    //   18: ireturn
    //   19: aload_0
    //   20: getfield 79	com/tencent/mobileqq/activity/shortvideo/SendVideoTask:d	Ljava/util/ArrayList;
    //   23: astore 7
    //   25: aload 7
    //   27: ifnull +60 -> 87
    //   30: aload 7
    //   32: invokevirtual 220	java/util/ArrayList:isEmpty	()Z
    //   35: ifne +52 -> 87
    //   38: aload_0
    //   39: getfield 49	com/tencent/mobileqq/activity/shortvideo/SendVideoTask:a	Ljava/lang/ref/WeakReference;
    //   42: invokevirtual 213	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   45: checkcast 51	com/tencent/mobileqq/app/BaseActivity
    //   48: getfield 224	com/tencent/mobileqq/app/BaseActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   51: aload_0
    //   52: getfield 79	com/tencent/mobileqq/activity/shortvideo/SendVideoTask:d	Ljava/util/ArrayList;
    //   55: aload_0
    //   56: getfield 95	com/tencent/mobileqq/activity/shortvideo/SendVideoTask:g	Ljava/lang/String;
    //   59: aload_0
    //   60: getfield 103	com/tencent/mobileqq/activity/shortvideo/SendVideoTask:h	I
    //   63: invokestatic 229	com/tencent/mobileqq/utils/SendByFile:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/util/List;Ljava/lang/String;I)V
    //   66: aload_0
    //   67: getfield 71	com/tencent/mobileqq/activity/shortvideo/SendVideoTask:c	Ljava/lang/String;
    //   70: astore 7
    //   72: aload 7
    //   74: ifnull +10 -> 84
    //   77: aload 7
    //   79: ldc 231
    //   81: if_acmpne +6 -> 87
    //   84: bipush 9
    //   86: ireturn
    //   87: sipush 1280
    //   90: istore_2
    //   91: aconst_null
    //   92: astore 11
    //   94: aconst_null
    //   95: astore 12
    //   97: aconst_null
    //   98: astore 9
    //   100: aconst_null
    //   101: astore 10
    //   103: invokestatic 237	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   106: invokevirtual 241	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   109: checkcast 243	com/tencent/mobileqq/app/QQAppInterface
    //   112: astore 7
    //   114: iload_2
    //   115: istore_1
    //   116: aload 7
    //   118: ifnull +148 -> 266
    //   121: aload 13
    //   123: aload 7
    //   125: invokevirtual 246	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   128: invokestatic 252	com/tencent/mobileqq/utils/SharedPreUtils:aP	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   131: astore 7
    //   133: iload_2
    //   134: istore_1
    //   135: aload 7
    //   137: ifnull +129 -> 266
    //   140: iload_2
    //   141: istore_1
    //   142: aload 7
    //   144: invokevirtual 257	java/lang/String:length	()I
    //   147: ifle +119 -> 266
    //   150: invokestatic 136	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   153: ifeq +40 -> 193
    //   156: new 138	java/lang/StringBuilder
    //   159: dup
    //   160: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   163: astore 8
    //   165: aload 8
    //   167: ldc_w 259
    //   170: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: pop
    //   174: aload 8
    //   176: aload 7
    //   178: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: pop
    //   182: ldc 170
    //   184: iconst_2
    //   185: aload 8
    //   187: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   190: invokestatic 177	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   193: aload 7
    //   195: ldc_w 261
    //   198: invokevirtual 265	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   201: astore 7
    //   203: iload_2
    //   204: istore_1
    //   205: aload 7
    //   207: ifnull +59 -> 266
    //   210: aload 7
    //   212: arraylength
    //   213: istore_3
    //   214: iload_2
    //   215: istore_1
    //   216: iload_3
    //   217: iconst_5
    //   218: if_icmplt +48 -> 266
    //   221: aload 7
    //   223: iconst_0
    //   224: aaload
    //   225: invokestatic 271	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   228: invokevirtual 274	java/lang/Integer:intValue	()I
    //   231: istore_3
    //   232: iload_2
    //   233: istore_1
    //   234: iload_3
    //   235: ifle +31 -> 266
    //   238: iload_3
    //   239: istore_1
    //   240: goto +26 -> 266
    //   243: astore 7
    //   245: iload_2
    //   246: istore_1
    //   247: invokestatic 136	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   250: ifeq +16 -> 266
    //   253: ldc 170
    //   255: iconst_2
    //   256: ldc_w 276
    //   259: aload 7
    //   261: invokestatic 279	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   264: iload_2
    //   265: istore_1
    //   266: invokestatic 136	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   269: ifeq +39 -> 308
    //   272: new 138	java/lang/StringBuilder
    //   275: dup
    //   276: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   279: astore 7
    //   281: aload 7
    //   283: ldc_w 281
    //   286: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: pop
    //   290: aload 7
    //   292: iload_1
    //   293: invokevirtual 159	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   296: pop
    //   297: ldc 170
    //   299: iconst_2
    //   300: aload 7
    //   302: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   305: invokestatic 177	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   308: aload 13
    //   310: aload_0
    //   311: getfield 71	com/tencent/mobileqq/activity/shortvideo/SendVideoTask:c	Ljava/lang/String;
    //   314: iload_1
    //   315: invokestatic 287	com/tencent/mobileqq/shortvideo/ShortVideoUtils:getVideoThumbnail	(Landroid/content/Context;Ljava/lang/String;I)Landroid/graphics/Bitmap;
    //   318: astore 7
    //   320: aload 7
    //   322: astore 8
    //   324: aload 7
    //   326: ifnonnull +34 -> 360
    //   329: invokestatic 136	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   332: ifeq +12 -> 344
    //   335: ldc 170
    //   337: iconst_2
    //   338: ldc_w 289
    //   341: invokestatic 291	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   344: aload_0
    //   345: getfield 293	com/tencent/mobileqq/activity/shortvideo/SendVideoTask:q	Landroid/graphics/Bitmap;
    //   348: ifnull +882 -> 1230
    //   351: aload_0
    //   352: getfield 293	com/tencent/mobileqq/activity/shortvideo/SendVideoTask:q	Landroid/graphics/Bitmap;
    //   355: astore 8
    //   357: goto +3 -> 360
    //   360: aload_0
    //   361: aload 8
    //   363: invokevirtual 298	android/graphics/Bitmap:getWidth	()I
    //   366: putfield 300	com/tencent/mobileqq/activity/shortvideo/SendVideoTask:l	I
    //   369: aload_0
    //   370: aload 8
    //   372: invokevirtual 303	android/graphics/Bitmap:getHeight	()I
    //   375: putfield 305	com/tencent/mobileqq/activity/shortvideo/SendVideoTask:m	I
    //   378: aload_0
    //   379: getfield 300	com/tencent/mobileqq/activity/shortvideo/SendVideoTask:l	I
    //   382: ifeq +517 -> 899
    //   385: aload_0
    //   386: getfield 305	com/tencent/mobileqq/activity/shortvideo/SendVideoTask:m	I
    //   389: ifne +6 -> 395
    //   392: goto +507 -> 899
    //   395: new 138	java/lang/StringBuilder
    //   398: dup
    //   399: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   402: astore 7
    //   404: aload 7
    //   406: ldc 231
    //   408: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   411: pop
    //   412: aload 7
    //   414: invokestatic 311	java/lang/System:currentTimeMillis	()J
    //   417: invokevirtual 150	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   420: pop
    //   421: aload 7
    //   423: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   426: ldc_w 313
    //   429: invokestatic 318	com/tencent/mobileqq/shortvideo/SVUtils:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   432: astore 14
    //   434: new 138	java/lang/StringBuilder
    //   437: dup
    //   438: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   441: astore 7
    //   443: aload 7
    //   445: invokestatic 320	com/tencent/mobileqq/shortvideo/SVUtils:b	()Ljava/lang/String;
    //   448: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   451: pop
    //   452: aload 7
    //   454: ldc_w 322
    //   457: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   460: pop
    //   461: aload 7
    //   463: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   466: invokestatic 328	com/tencent/mobileqq/utils/FileUtils:createFileIfNotExits	(Ljava/lang/String;)V
    //   469: new 330	java/io/File
    //   472: dup
    //   473: aload 14
    //   475: invokespecial 332	java/io/File:<init>	(Ljava/lang/String;)V
    //   478: astore 15
    //   480: new 330	java/io/File
    //   483: dup
    //   484: aload 15
    //   486: invokevirtual 335	java/io/File:getParent	()Ljava/lang/String;
    //   489: invokespecial 332	java/io/File:<init>	(Ljava/lang/String;)V
    //   492: astore 7
    //   494: aload 7
    //   496: invokevirtual 338	java/io/File:exists	()Z
    //   499: ifeq +11 -> 510
    //   502: aload 7
    //   504: invokevirtual 341	java/io/File:isDirectory	()Z
    //   507: ifne +9 -> 516
    //   510: aload 7
    //   512: invokevirtual 344	java/io/File:mkdirs	()Z
    //   515: pop
    //   516: aload 15
    //   518: invokevirtual 338	java/io/File:exists	()Z
    //   521: ifeq +11 -> 532
    //   524: aload 15
    //   526: invokevirtual 347	java/io/File:isFile	()Z
    //   529: ifne +9 -> 538
    //   532: aload 15
    //   534: invokevirtual 350	java/io/File:createNewFile	()Z
    //   537: pop
    //   538: new 352	java/io/BufferedOutputStream
    //   541: dup
    //   542: new 354	java/io/FileOutputStream
    //   545: dup
    //   546: aload 15
    //   548: invokespecial 357	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   551: invokespecial 360	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   554: astore 7
    //   556: aload 8
    //   558: getstatic 366	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   561: bipush 80
    //   563: aload 7
    //   565: invokevirtual 370	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   568: pop
    //   569: aload 7
    //   571: invokevirtual 373	java/io/BufferedOutputStream:flush	()V
    //   574: new 375	java/io/FileInputStream
    //   577: dup
    //   578: aload 15
    //   580: invokespecial 376	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   583: astore 8
    //   585: aload 15
    //   587: invokevirtual 378	java/io/File:length	()J
    //   590: lstore 4
    //   592: aload_0
    //   593: aload 8
    //   595: lload 4
    //   597: invokestatic 384	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   600: invokestatic 390	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   603: putfield 392	com/tencent/mobileqq/activity/shortvideo/SendVideoTask:n	Ljava/lang/String;
    //   606: aload_0
    //   607: getfield 392	com/tencent/mobileqq/activity/shortvideo/SendVideoTask:n	Ljava/lang/String;
    //   610: invokestatic 397	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   613: ifeq +60 -> 673
    //   616: invokestatic 136	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   619: ifeq +42 -> 661
    //   622: new 138	java/lang/StringBuilder
    //   625: dup
    //   626: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   629: astore 9
    //   631: aload 9
    //   633: ldc_w 399
    //   636: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   639: pop
    //   640: aload 9
    //   642: aload_0
    //   643: getfield 392	com/tencent/mobileqq/activity/shortvideo/SendVideoTask:n	Ljava/lang/String;
    //   646: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   649: pop
    //   650: ldc 170
    //   652: iconst_2
    //   653: aload 9
    //   655: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   658: invokestatic 291	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   661: aload 7
    //   663: invokevirtual 402	java/io/BufferedOutputStream:close	()V
    //   666: aload 8
    //   668: invokevirtual 403	java/io/FileInputStream:close	()V
    //   671: iconst_5
    //   672: ireturn
    //   673: aload_0
    //   674: aload_0
    //   675: getfield 392	com/tencent/mobileqq/activity/shortvideo/SendVideoTask:n	Ljava/lang/String;
    //   678: ldc_w 313
    //   681: invokestatic 318	com/tencent/mobileqq/shortvideo/SVUtils:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   684: putfield 405	com/tencent/mobileqq/activity/shortvideo/SendVideoTask:k	Ljava/lang/String;
    //   687: aload 14
    //   689: aload_0
    //   690: getfield 405	com/tencent/mobileqq/activity/shortvideo/SendVideoTask:k	Ljava/lang/String;
    //   693: invokestatic 409	com/tencent/mobileqq/utils/FileUtils:rename	(Ljava/lang/String;Ljava/lang/String;)Z
    //   696: istore 6
    //   698: iload 6
    //   700: ifne +15 -> 715
    //   703: aload 7
    //   705: invokevirtual 402	java/io/BufferedOutputStream:close	()V
    //   708: aload 8
    //   710: invokevirtual 403	java/io/FileInputStream:close	()V
    //   713: iconst_5
    //   714: ireturn
    //   715: aload 13
    //   717: lload 4
    //   719: invokestatic 415	android/text/format/Formatter:formatFileSize	(Landroid/content/Context;J)Ljava/lang/String;
    //   722: astore 9
    //   724: invokestatic 136	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   727: ifeq +40 -> 767
    //   730: new 138	java/lang/StringBuilder
    //   733: dup
    //   734: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   737: astore 10
    //   739: aload 10
    //   741: ldc_w 417
    //   744: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   747: pop
    //   748: aload 10
    //   750: aload 9
    //   752: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   755: pop
    //   756: ldc 170
    //   758: iconst_2
    //   759: aload 10
    //   761: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   764: invokestatic 291	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   767: aload_0
    //   768: getfield 87	com/tencent/mobileqq/activity/shortvideo/SendVideoTask:f	J
    //   771: lconst_0
    //   772: lcmp
    //   773: ifne +14 -> 787
    //   776: aload_0
    //   777: aload_0
    //   778: getfield 71	com/tencent/mobileqq/activity/shortvideo/SendVideoTask:c	Ljava/lang/String;
    //   781: invokestatic 420	com/tencent/mobileqq/shortvideo/ShortVideoUtils:getDuration	(Ljava/lang/String;)J
    //   784: putfield 87	com/tencent/mobileqq/activity/shortvideo/SendVideoTask:f	J
    //   787: aload 7
    //   789: invokevirtual 402	java/io/BufferedOutputStream:close	()V
    //   792: aload 8
    //   794: invokevirtual 403	java/io/FileInputStream:close	()V
    //   797: iconst_1
    //   798: ireturn
    //   799: astore 9
    //   801: goto +23 -> 824
    //   804: astore 9
    //   806: goto +38 -> 844
    //   809: astore 9
    //   811: goto +53 -> 864
    //   814: astore 9
    //   816: goto +68 -> 884
    //   819: astore 9
    //   821: aconst_null
    //   822: astore 8
    //   824: aload 7
    //   826: astore 10
    //   828: aload 9
    //   830: astore 7
    //   832: aload 10
    //   834: astore 9
    //   836: goto +303 -> 1139
    //   839: astore 9
    //   841: aconst_null
    //   842: astore 8
    //   844: aload 9
    //   846: astore 11
    //   848: aload 8
    //   850: astore 9
    //   852: aload 7
    //   854: astore 10
    //   856: goto +73 -> 929
    //   859: astore 9
    //   861: aconst_null
    //   862: astore 8
    //   864: aload 9
    //   866: astore 11
    //   868: aload 8
    //   870: astore 9
    //   872: aload 7
    //   874: astore 10
    //   876: goto +124 -> 1000
    //   879: astore 9
    //   881: aconst_null
    //   882: astore 8
    //   884: aload 9
    //   886: astore 11
    //   888: aload 8
    //   890: astore 9
    //   892: aload 7
    //   894: astore 10
    //   896: goto +171 -> 1067
    //   899: invokestatic 136	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   902: ifeq +12 -> 914
    //   905: ldc 170
    //   907: iconst_2
    //   908: ldc_w 422
    //   911: invokestatic 291	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   914: iconst_2
    //   915: ireturn
    //   916: astore 7
    //   918: aconst_null
    //   919: astore 8
    //   921: goto +218 -> 1139
    //   924: astore 11
    //   926: aconst_null
    //   927: astore 9
    //   929: aload 9
    //   931: astore 7
    //   933: aload 10
    //   935: astore 8
    //   937: invokestatic 136	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   940: ifeq +22 -> 962
    //   943: aload 9
    //   945: astore 7
    //   947: aload 10
    //   949: astore 8
    //   951: ldc 170
    //   953: iconst_2
    //   954: ldc_w 424
    //   957: aload 11
    //   959: invokestatic 279	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   962: aload 10
    //   964: ifnull +11 -> 975
    //   967: aload 10
    //   969: invokevirtual 402	java/io/BufferedOutputStream:close	()V
    //   972: goto +3 -> 975
    //   975: aload 9
    //   977: ifnull +8 -> 985
    //   980: aload 9
    //   982: invokevirtual 403	java/io/FileInputStream:close	()V
    //   985: iconst_4
    //   986: ireturn
    //   987: astore 7
    //   989: aconst_null
    //   990: astore 9
    //   992: aload 11
    //   994: astore 10
    //   996: aload 7
    //   998: astore 11
    //   1000: aload 9
    //   1002: astore 7
    //   1004: aload 10
    //   1006: astore 8
    //   1008: invokestatic 136	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1011: ifeq +22 -> 1033
    //   1014: aload 9
    //   1016: astore 7
    //   1018: aload 10
    //   1020: astore 8
    //   1022: ldc 170
    //   1024: iconst_2
    //   1025: ldc_w 426
    //   1028: aload 11
    //   1030: invokestatic 279	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1033: aload 10
    //   1035: ifnull +11 -> 1046
    //   1038: aload 10
    //   1040: invokevirtual 402	java/io/BufferedOutputStream:close	()V
    //   1043: goto +3 -> 1046
    //   1046: aload 9
    //   1048: ifnull +8 -> 1056
    //   1051: aload 9
    //   1053: invokevirtual 403	java/io/FileInputStream:close	()V
    //   1056: iconst_5
    //   1057: ireturn
    //   1058: astore 11
    //   1060: aconst_null
    //   1061: astore 9
    //   1063: aload 12
    //   1065: astore 10
    //   1067: aload 9
    //   1069: astore 7
    //   1071: aload 10
    //   1073: astore 8
    //   1075: invokestatic 136	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1078: ifeq +22 -> 1100
    //   1081: aload 9
    //   1083: astore 7
    //   1085: aload 10
    //   1087: astore 8
    //   1089: ldc 170
    //   1091: iconst_2
    //   1092: ldc_w 426
    //   1095: aload 11
    //   1097: invokestatic 279	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1100: aload 10
    //   1102: ifnull +11 -> 1113
    //   1105: aload 10
    //   1107: invokevirtual 402	java/io/BufferedOutputStream:close	()V
    //   1110: goto +3 -> 1113
    //   1113: aload 9
    //   1115: ifnull +8 -> 1123
    //   1118: aload 9
    //   1120: invokevirtual 403	java/io/FileInputStream:close	()V
    //   1123: iconst_3
    //   1124: ireturn
    //   1125: astore 10
    //   1127: aload 8
    //   1129: astore 9
    //   1131: aload 7
    //   1133: astore 8
    //   1135: aload 10
    //   1137: astore 7
    //   1139: aload 9
    //   1141: ifnull +11 -> 1152
    //   1144: aload 9
    //   1146: invokevirtual 402	java/io/BufferedOutputStream:close	()V
    //   1149: goto +3 -> 1152
    //   1152: aload 8
    //   1154: ifnull +8 -> 1162
    //   1157: aload 8
    //   1159: invokevirtual 403	java/io/FileInputStream:close	()V
    //   1162: aload 7
    //   1164: athrow
    //   1165: astore 7
    //   1167: goto -501 -> 666
    //   1170: astore 7
    //   1172: iconst_5
    //   1173: ireturn
    //   1174: astore 7
    //   1176: goto -468 -> 708
    //   1179: astore 7
    //   1181: iconst_5
    //   1182: ireturn
    //   1183: astore 7
    //   1185: goto -393 -> 792
    //   1188: astore 7
    //   1190: goto -393 -> 797
    //   1193: astore 7
    //   1195: goto -220 -> 975
    //   1198: astore 7
    //   1200: iconst_4
    //   1201: ireturn
    //   1202: astore 7
    //   1204: goto -158 -> 1046
    //   1207: astore 7
    //   1209: iconst_5
    //   1210: ireturn
    //   1211: astore 7
    //   1213: goto -100 -> 1113
    //   1216: astore 7
    //   1218: iconst_3
    //   1219: ireturn
    //   1220: astore 9
    //   1222: goto -70 -> 1152
    //   1225: astore 8
    //   1227: goto -65 -> 1162
    //   1230: iconst_2
    //   1231: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1232	0	this	SendVideoTask
    //   115	200	1	i1	int
    //   90	175	2	i2	int
    //   213	26	3	i3	int
    //   590	128	4	l1	long
    //   696	3	6	bool	boolean
    //   23	199	7	localObject1	Object
    //   243	17	7	localNumberFormatException	java.lang.NumberFormatException
    //   279	614	7	localObject2	Object
    //   916	1	7	localObject3	Object
    //   931	15	7	localObject4	Object
    //   987	10	7	localException1	Exception
    //   1002	161	7	localObject5	Object
    //   1165	1	7	localIOException1	java.io.IOException
    //   1170	1	7	localIOException2	java.io.IOException
    //   1174	1	7	localIOException3	java.io.IOException
    //   1179	1	7	localIOException4	java.io.IOException
    //   1183	1	7	localIOException5	java.io.IOException
    //   1188	1	7	localIOException6	java.io.IOException
    //   1193	1	7	localIOException7	java.io.IOException
    //   1198	1	7	localIOException8	java.io.IOException
    //   1202	1	7	localIOException9	java.io.IOException
    //   1207	1	7	localIOException10	java.io.IOException
    //   1211	1	7	localIOException11	java.io.IOException
    //   1216	1	7	localIOException12	java.io.IOException
    //   163	995	8	localObject6	Object
    //   1225	1	8	localIOException13	java.io.IOException
    //   98	653	9	localObject7	Object
    //   799	1	9	localObject8	Object
    //   804	1	9	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   809	1	9	localException2	Exception
    //   814	1	9	localIOException14	java.io.IOException
    //   819	10	9	localObject9	Object
    //   834	1	9	localObject10	Object
    //   839	6	9	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   850	1	9	localObject11	Object
    //   859	6	9	localException3	Exception
    //   870	1	9	localObject12	Object
    //   879	6	9	localIOException15	java.io.IOException
    //   890	255	9	localObject13	Object
    //   1220	1	9	localIOException16	java.io.IOException
    //   101	1005	10	localObject14	Object
    //   1125	11	10	localObject15	Object
    //   92	795	11	localObject16	Object
    //   924	69	11	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   998	31	11	localException4	Exception
    //   1058	38	11	localIOException17	java.io.IOException
    //   95	969	12	localObject17	Object
    //   10	706	13	localContext	Context
    //   432	256	14	str	String
    //   478	108	15	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   221	232	243	java/lang/NumberFormatException
    //   585	661	799	finally
    //   673	698	799	finally
    //   715	767	799	finally
    //   767	787	799	finally
    //   585	661	804	java/lang/OutOfMemoryError
    //   673	698	804	java/lang/OutOfMemoryError
    //   715	767	804	java/lang/OutOfMemoryError
    //   767	787	804	java/lang/OutOfMemoryError
    //   585	661	809	java/lang/Exception
    //   673	698	809	java/lang/Exception
    //   715	767	809	java/lang/Exception
    //   767	787	809	java/lang/Exception
    //   585	661	814	java/io/IOException
    //   673	698	814	java/io/IOException
    //   715	767	814	java/io/IOException
    //   767	787	814	java/io/IOException
    //   556	585	819	finally
    //   556	585	839	java/lang/OutOfMemoryError
    //   556	585	859	java/lang/Exception
    //   556	585	879	java/io/IOException
    //   103	114	916	finally
    //   121	133	916	finally
    //   142	193	916	finally
    //   193	203	916	finally
    //   210	214	916	finally
    //   221	232	916	finally
    //   247	264	916	finally
    //   266	308	916	finally
    //   308	320	916	finally
    //   329	344	916	finally
    //   344	357	916	finally
    //   360	392	916	finally
    //   395	510	916	finally
    //   510	516	916	finally
    //   516	532	916	finally
    //   532	538	916	finally
    //   538	556	916	finally
    //   899	914	916	finally
    //   103	114	924	java/lang/OutOfMemoryError
    //   121	133	924	java/lang/OutOfMemoryError
    //   142	193	924	java/lang/OutOfMemoryError
    //   193	203	924	java/lang/OutOfMemoryError
    //   210	214	924	java/lang/OutOfMemoryError
    //   221	232	924	java/lang/OutOfMemoryError
    //   247	264	924	java/lang/OutOfMemoryError
    //   266	308	924	java/lang/OutOfMemoryError
    //   308	320	924	java/lang/OutOfMemoryError
    //   329	344	924	java/lang/OutOfMemoryError
    //   344	357	924	java/lang/OutOfMemoryError
    //   360	392	924	java/lang/OutOfMemoryError
    //   395	510	924	java/lang/OutOfMemoryError
    //   510	516	924	java/lang/OutOfMemoryError
    //   516	532	924	java/lang/OutOfMemoryError
    //   532	538	924	java/lang/OutOfMemoryError
    //   538	556	924	java/lang/OutOfMemoryError
    //   899	914	924	java/lang/OutOfMemoryError
    //   103	114	987	java/lang/Exception
    //   121	133	987	java/lang/Exception
    //   142	193	987	java/lang/Exception
    //   193	203	987	java/lang/Exception
    //   210	214	987	java/lang/Exception
    //   221	232	987	java/lang/Exception
    //   247	264	987	java/lang/Exception
    //   266	308	987	java/lang/Exception
    //   308	320	987	java/lang/Exception
    //   329	344	987	java/lang/Exception
    //   344	357	987	java/lang/Exception
    //   360	392	987	java/lang/Exception
    //   395	510	987	java/lang/Exception
    //   510	516	987	java/lang/Exception
    //   516	532	987	java/lang/Exception
    //   532	538	987	java/lang/Exception
    //   538	556	987	java/lang/Exception
    //   899	914	987	java/lang/Exception
    //   103	114	1058	java/io/IOException
    //   121	133	1058	java/io/IOException
    //   142	193	1058	java/io/IOException
    //   193	203	1058	java/io/IOException
    //   210	214	1058	java/io/IOException
    //   221	232	1058	java/io/IOException
    //   247	264	1058	java/io/IOException
    //   266	308	1058	java/io/IOException
    //   308	320	1058	java/io/IOException
    //   329	344	1058	java/io/IOException
    //   344	357	1058	java/io/IOException
    //   360	392	1058	java/io/IOException
    //   395	510	1058	java/io/IOException
    //   510	516	1058	java/io/IOException
    //   516	532	1058	java/io/IOException
    //   532	538	1058	java/io/IOException
    //   538	556	1058	java/io/IOException
    //   899	914	1058	java/io/IOException
    //   937	943	1125	finally
    //   951	962	1125	finally
    //   1008	1014	1125	finally
    //   1022	1033	1125	finally
    //   1075	1081	1125	finally
    //   1089	1100	1125	finally
    //   661	666	1165	java/io/IOException
    //   666	671	1170	java/io/IOException
    //   703	708	1174	java/io/IOException
    //   708	713	1179	java/io/IOException
    //   787	792	1183	java/io/IOException
    //   792	797	1188	java/io/IOException
    //   967	972	1193	java/io/IOException
    //   980	985	1198	java/io/IOException
    //   1038	1043	1202	java/io/IOException
    //   1051	1056	1207	java/io/IOException
    //   1105	1110	1211	java/io/IOException
    //   1118	1123	1216	java/io/IOException
    //   1144	1149	1220	java/io/IOException
    //   1157	1162	1225	java/io/IOException
  }
  
  protected Integer a(Void... paramVarArgs)
  {
    return Integer.valueOf(a());
  }
  
  void a(Context paramContext, int paramInt)
  {
    if (this.t) {
      return;
    }
    try
    {
      if (this.s != null)
      {
        c();
      }
      else
      {
        this.s = new ReportProgressDialog(paramContext, 2131953338);
        this.s.setCancelable(true);
        this.s.show();
        this.s.setContentView(2131625585);
        this.r = ((TextView)this.s.findViewById(2131440191));
      }
      this.r.setText(paramInt);
      if (!this.s.isShowing())
      {
        this.s.show();
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
    c();
    int i1 = paramInteger.intValue();
    if (i1 != 9)
    {
      switch (i1)
      {
      default: 
        return;
      case 5: 
        a((BaseActivity)this.a.get(), 2131916645, this.t);
        return;
      case 4: 
        a((BaseActivity)this.a.get(), 2131916619, this.t);
        return;
      case 3: 
        a((BaseActivity)this.a.get(), 2131916648, this.t);
        return;
      case 2: 
      case 6: 
        a((BaseActivity)this.a.get(), 2131916653, this.t);
        return;
      }
      b();
      return;
    }
    ((BaseActivity)this.a.get()).finish();
  }
  
  public void b()
  {
    Intent localIntent = ((BaseActivity)this.a.get()).getIntent();
    localIntent.putExtra("uin", this.g);
    localIntent.putExtra("uintype", this.h);
    localIntent.putExtra("file_send_path", this.c);
    localIntent.putExtra("file_send_size", this.e);
    localIntent.putExtra("file_send_duration", (int)(this.f / 1000L));
    localIntent.putExtra("file_source", this.i);
    localIntent.putExtra("thumbfile_send_path", this.k);
    localIntent.putExtra("file_shortvideo_md5", this.j);
    localIntent.putExtra("thumbfile_send_width", this.l);
    localIntent.putExtra("thumbfile_send_height", this.m);
    localIntent.putExtra("thumbfile_md5", this.n);
    localIntent.putExtra("file_width", this.o);
    localIntent.putExtra("file_height", this.p);
    localIntent.putExtra("file_raw_size", this.u);
    Object localObject1 = this.b;
    Object localObject2;
    if ((localObject1 != null) && (((String)localObject1).equals(ShortVideoPreviewActivity.class.getName())))
    {
      localIntent.putExtra("file_send_business_type", 2);
      localObject1 = SVBusiUtil.a(0, 2);
      ((ShortVideoReq)localObject1).a(ShortVideoBusiManager.a(2, localIntent, (ShortVideoReq)localObject1));
      ShortVideoBusiManager.a((ShortVideoReq)localObject1, ((BaseActivity)this.a.get()).app);
    }
    else
    {
      localIntent.putExtra("file_send_business_type", 0);
      localObject2 = SVBusiUtil.a(0, 0);
      localObject1 = ShortVideoBusiManager.a(0, localIntent, (ShortVideoReq)localObject2);
      ((ShortVideoReq)localObject2).a((ShortVideoUploadInfo)localObject1);
      localObject2 = ((IShortVideoFactory)QRoute.api(IShortVideoFactory.class)).getAioShortVideoSendOperator(((BaseActivity)this.a.get()).app);
      localObject1 = ((IShortVideoOperator)localObject2).a((ShortVideoUploadInfo)localObject1);
      if (((BaseActivity)this.a.get()).app != null) {
        ((IOrderMediaMsgService)((BaseActivity)this.a.get()).app.getRuntimeService(IOrderMediaMsgService.class)).enqueueMediaMsgByUniseq(((MessageRecord)localObject1).frienduin, ((MessageRecord)localObject1).uniseq);
      }
      ((IShortVideoOperator)localObject2).a((MessageRecord)localObject1);
    }
    if (!this.t)
    {
      localObject2 = ((BaseActivity)this.a.get()).getIntent();
      if (((Intent)localObject2).getBooleanExtra("start_init_activity_after_sended", true))
      {
        localObject1 = ((Intent)localObject2).getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
        localIntent.setClassName(((Intent)localObject2).getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME"), (String)localObject1);
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("SendVideoTask onPostExecute() INIT_ACTIVITY_CLASS_NAME=");
          ((StringBuilder)localObject2).append((String)localObject1);
          QLog.d("SendVideoActivity", 2, ((StringBuilder)localObject2).toString());
        }
        localIntent.addFlags(603979776);
        ((BaseActivity)this.a.get()).startActivity(localIntent);
      }
      ((BaseActivity)this.a.get()).finish();
      ((BaseActivity)this.a.get()).overridePendingTransition(0, 2130771997);
    }
  }
  
  void c()
  {
    if (this.t) {
      return;
    }
    try
    {
      if (this.s != null) {
        this.s.cancel();
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
 * Qualified Name:     com.tencent.mobileqq.activity.shortvideo.SendVideoTask
 * JD-Core Version:    0.7.0.1
 */