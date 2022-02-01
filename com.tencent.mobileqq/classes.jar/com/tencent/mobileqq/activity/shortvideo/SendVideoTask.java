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
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  ProgressDialog jdField_a_of_type_AndroidAppProgressDialog;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  String jdField_a_of_type_JavaLangString;
  WeakReference<BaseActivity> jdField_a_of_type_JavaLangRefWeakReference;
  ArrayList<String> jdField_a_of_type_JavaUtilArrayList;
  boolean jdField_a_of_type_Boolean;
  int jdField_b_of_type_Int;
  long jdField_b_of_type_Long;
  public String b;
  boolean jdField_b_of_type_Boolean;
  int jdField_c_of_type_Int;
  String jdField_c_of_type_JavaLangString;
  int jdField_d_of_type_Int;
  String jdField_d_of_type_JavaLangString;
  int jdField_e_of_type_Int;
  String jdField_e_of_type_JavaLangString;
  String f;
  String g;
  
  public SendVideoTask(BaseActivity paramBaseActivity, Intent paramIntent)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramBaseActivity);
    paramBaseActivity = paramBaseActivity.getIntent();
    if (paramIntent != null) {
      paramBaseActivity = paramIntent;
    }
    this.jdField_b_of_type_JavaLangString = paramBaseActivity.getExtras().getString("file_send_path");
    this.jdField_a_of_type_JavaUtilArrayList = paramBaseActivity.getStringArrayListExtra("PhotoConst.PHOTO_PATHS_BY_FILE");
    this.jdField_b_of_type_Long = paramBaseActivity.getExtras().getLong("file_send_duration");
    this.jdField_a_of_type_Long = paramBaseActivity.getExtras().getLong("file_send_size");
    this.jdField_c_of_type_JavaLangString = paramBaseActivity.getExtras().getString("uin");
    this.jdField_a_of_type_Int = paramBaseActivity.getIntExtra("uintype", -1);
    this.jdField_d_of_type_JavaLangString = paramBaseActivity.getStringExtra("file_source");
    this.jdField_e_of_type_JavaLangString = paramBaseActivity.getExtras().getString("file_shortvideo_md5");
    this.jdField_a_of_type_JavaLangString = paramBaseActivity.getExtras().getString("activity_before_enter_send_video");
    this.jdField_a_of_type_Boolean = paramBaseActivity.getExtras().getBoolean("send_in_background");
    boolean bool = false;
    if (paramBaseActivity.getIntExtra("PhotoConst.SEND_SIZE_SPEC", 0) == 2) {
      bool = true;
    }
    this.jdField_b_of_type_Boolean = bool;
    if (QLog.isColorLevel())
    {
      paramBaseActivity = new StringBuilder();
      paramBaseActivity.append(" SendVideoTask(),  mVideoPath :");
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
      paramBaseActivity.append(this.jdField_d_of_type_JavaLangString);
      paramBaseActivity.append(",mSendBackground = ");
      paramBaseActivity.append(this.jdField_a_of_type_Boolean);
      paramBaseActivity.append(", mSendRawVideo:");
      paramBaseActivity.append(this.jdField_b_of_type_Boolean);
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
    //   1: getfield 35	com/tencent/mobileqq/activity/shortvideo/SendVideoTask:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   4: invokevirtual 199	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   7: checkcast 201	android/content/Context
    //   10: astore 13
    //   12: aload 13
    //   14: ifnonnull +5 -> 19
    //   17: iconst_5
    //   18: ireturn
    //   19: aload_0
    //   20: getfield 65	com/tencent/mobileqq/activity/shortvideo/SendVideoTask:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   23: astore 7
    //   25: aload 7
    //   27: ifnull +60 -> 87
    //   30: aload 7
    //   32: invokevirtual 206	java/util/ArrayList:isEmpty	()Z
    //   35: ifne +52 -> 87
    //   38: aload_0
    //   39: getfield 35	com/tencent/mobileqq/activity/shortvideo/SendVideoTask:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   42: invokevirtual 199	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   45: checkcast 37	com/tencent/mobileqq/app/BaseActivity
    //   48: getfield 210	com/tencent/mobileqq/app/BaseActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   51: aload_0
    //   52: getfield 65	com/tencent/mobileqq/activity/shortvideo/SendVideoTask:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   55: aload_0
    //   56: getfield 81	com/tencent/mobileqq/activity/shortvideo/SendVideoTask:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   59: aload_0
    //   60: getfield 89	com/tencent/mobileqq/activity/shortvideo/SendVideoTask:jdField_a_of_type_Int	I
    //   63: invokestatic 215	com/tencent/mobileqq/utils/SendByFile:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/util/List;Ljava/lang/String;I)V
    //   66: aload_0
    //   67: getfield 57	com/tencent/mobileqq/activity/shortvideo/SendVideoTask:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   70: astore 7
    //   72: aload 7
    //   74: ifnull +10 -> 84
    //   77: aload 7
    //   79: ldc 217
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
    //   103: invokestatic 223	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   106: invokevirtual 227	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   109: checkcast 229	com/tencent/mobileqq/app/QQAppInterface
    //   112: astore 7
    //   114: iload_2
    //   115: istore_1
    //   116: aload 7
    //   118: ifnull +146 -> 264
    //   121: aload 13
    //   123: aload 7
    //   125: invokevirtual 232	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   128: invokestatic 238	com/tencent/mobileqq/utils/SharedPreUtils:l	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   131: astore 7
    //   133: iload_2
    //   134: istore_1
    //   135: aload 7
    //   137: ifnull +127 -> 264
    //   140: iload_2
    //   141: istore_1
    //   142: aload 7
    //   144: invokevirtual 243	java/lang/String:length	()I
    //   147: ifle +117 -> 264
    //   150: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   153: ifeq +39 -> 192
    //   156: new 124	java/lang/StringBuilder
    //   159: dup
    //   160: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   163: astore 8
    //   165: aload 8
    //   167: ldc 245
    //   169: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: pop
    //   173: aload 8
    //   175: aload 7
    //   177: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: pop
    //   181: ldc 156
    //   183: iconst_2
    //   184: aload 8
    //   186: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   189: invokestatic 163	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   192: aload 7
    //   194: ldc 247
    //   196: invokevirtual 251	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   199: astore 7
    //   201: iload_2
    //   202: istore_1
    //   203: aload 7
    //   205: ifnull +59 -> 264
    //   208: aload 7
    //   210: arraylength
    //   211: istore_3
    //   212: iload_2
    //   213: istore_1
    //   214: iload_3
    //   215: iconst_5
    //   216: if_icmplt +48 -> 264
    //   219: aload 7
    //   221: iconst_0
    //   222: aaload
    //   223: invokestatic 257	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   226: invokevirtual 260	java/lang/Integer:intValue	()I
    //   229: istore_3
    //   230: iload_2
    //   231: istore_1
    //   232: iload_3
    //   233: ifle +31 -> 264
    //   236: iload_3
    //   237: istore_1
    //   238: goto +26 -> 264
    //   241: astore 7
    //   243: iload_2
    //   244: istore_1
    //   245: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   248: ifeq +16 -> 264
    //   251: ldc 156
    //   253: iconst_2
    //   254: ldc_w 262
    //   257: aload 7
    //   259: invokestatic 265	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   262: iload_2
    //   263: istore_1
    //   264: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   267: ifeq +39 -> 306
    //   270: new 124	java/lang/StringBuilder
    //   273: dup
    //   274: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   277: astore 7
    //   279: aload 7
    //   281: ldc_w 267
    //   284: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: pop
    //   288: aload 7
    //   290: iload_1
    //   291: invokevirtual 145	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   294: pop
    //   295: ldc 156
    //   297: iconst_2
    //   298: aload 7
    //   300: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   303: invokestatic 163	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   306: aload 13
    //   308: aload_0
    //   309: getfield 57	com/tencent/mobileqq/activity/shortvideo/SendVideoTask:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   312: iload_1
    //   313: invokestatic 273	com/tencent/mobileqq/shortvideo/ShortVideoUtils:getVideoThumbnail	(Landroid/content/Context;Ljava/lang/String;I)Landroid/graphics/Bitmap;
    //   316: astore 7
    //   318: aload 7
    //   320: astore 8
    //   322: aload 7
    //   324: ifnonnull +34 -> 358
    //   327: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   330: ifeq +12 -> 342
    //   333: ldc 156
    //   335: iconst_2
    //   336: ldc_w 275
    //   339: invokestatic 277	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   342: aload_0
    //   343: getfield 279	com/tencent/mobileqq/activity/shortvideo/SendVideoTask:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   346: ifnull +882 -> 1228
    //   349: aload_0
    //   350: getfield 279	com/tencent/mobileqq/activity/shortvideo/SendVideoTask:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   353: astore 8
    //   355: goto +3 -> 358
    //   358: aload_0
    //   359: aload 8
    //   361: invokevirtual 284	android/graphics/Bitmap:getWidth	()I
    //   364: putfield 286	com/tencent/mobileqq/activity/shortvideo/SendVideoTask:jdField_b_of_type_Int	I
    //   367: aload_0
    //   368: aload 8
    //   370: invokevirtual 289	android/graphics/Bitmap:getHeight	()I
    //   373: putfield 291	com/tencent/mobileqq/activity/shortvideo/SendVideoTask:jdField_c_of_type_Int	I
    //   376: aload_0
    //   377: getfield 286	com/tencent/mobileqq/activity/shortvideo/SendVideoTask:jdField_b_of_type_Int	I
    //   380: ifeq +517 -> 897
    //   383: aload_0
    //   384: getfield 291	com/tencent/mobileqq/activity/shortvideo/SendVideoTask:jdField_c_of_type_Int	I
    //   387: ifne +6 -> 393
    //   390: goto +507 -> 897
    //   393: new 124	java/lang/StringBuilder
    //   396: dup
    //   397: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   400: astore 7
    //   402: aload 7
    //   404: ldc 217
    //   406: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   409: pop
    //   410: aload 7
    //   412: invokestatic 297	java/lang/System:currentTimeMillis	()J
    //   415: invokevirtual 136	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   418: pop
    //   419: aload 7
    //   421: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   424: ldc_w 299
    //   427: invokestatic 304	com/tencent/mobileqq/shortvideo/SVUtils:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   430: astore 14
    //   432: new 124	java/lang/StringBuilder
    //   435: dup
    //   436: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   439: astore 7
    //   441: aload 7
    //   443: invokestatic 306	com/tencent/mobileqq/shortvideo/SVUtils:b	()Ljava/lang/String;
    //   446: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   449: pop
    //   450: aload 7
    //   452: ldc_w 308
    //   455: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   458: pop
    //   459: aload 7
    //   461: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   464: invokestatic 314	com/tencent/mobileqq/utils/FileUtils:createFileIfNotExits	(Ljava/lang/String;)V
    //   467: new 316	java/io/File
    //   470: dup
    //   471: aload 14
    //   473: invokespecial 318	java/io/File:<init>	(Ljava/lang/String;)V
    //   476: astore 15
    //   478: new 316	java/io/File
    //   481: dup
    //   482: aload 15
    //   484: invokevirtual 321	java/io/File:getParent	()Ljava/lang/String;
    //   487: invokespecial 318	java/io/File:<init>	(Ljava/lang/String;)V
    //   490: astore 7
    //   492: aload 7
    //   494: invokevirtual 324	java/io/File:exists	()Z
    //   497: ifeq +11 -> 508
    //   500: aload 7
    //   502: invokevirtual 327	java/io/File:isDirectory	()Z
    //   505: ifne +9 -> 514
    //   508: aload 7
    //   510: invokevirtual 330	java/io/File:mkdirs	()Z
    //   513: pop
    //   514: aload 15
    //   516: invokevirtual 324	java/io/File:exists	()Z
    //   519: ifeq +11 -> 530
    //   522: aload 15
    //   524: invokevirtual 333	java/io/File:isFile	()Z
    //   527: ifne +9 -> 536
    //   530: aload 15
    //   532: invokevirtual 336	java/io/File:createNewFile	()Z
    //   535: pop
    //   536: new 338	java/io/BufferedOutputStream
    //   539: dup
    //   540: new 340	java/io/FileOutputStream
    //   543: dup
    //   544: aload 15
    //   546: invokespecial 343	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   549: invokespecial 346	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   552: astore 7
    //   554: aload 8
    //   556: getstatic 352	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   559: bipush 80
    //   561: aload 7
    //   563: invokevirtual 356	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   566: pop
    //   567: aload 7
    //   569: invokevirtual 359	java/io/BufferedOutputStream:flush	()V
    //   572: new 361	java/io/FileInputStream
    //   575: dup
    //   576: aload 15
    //   578: invokespecial 362	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   581: astore 8
    //   583: aload 15
    //   585: invokevirtual 364	java/io/File:length	()J
    //   588: lstore 4
    //   590: aload_0
    //   591: aload 8
    //   593: lload 4
    //   595: invokestatic 370	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   598: invokestatic 376	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   601: putfield 378	com/tencent/mobileqq/activity/shortvideo/SendVideoTask:g	Ljava/lang/String;
    //   604: aload_0
    //   605: getfield 378	com/tencent/mobileqq/activity/shortvideo/SendVideoTask:g	Ljava/lang/String;
    //   608: invokestatic 383	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   611: ifeq +60 -> 671
    //   614: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   617: ifeq +42 -> 659
    //   620: new 124	java/lang/StringBuilder
    //   623: dup
    //   624: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   627: astore 9
    //   629: aload 9
    //   631: ldc_w 385
    //   634: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   637: pop
    //   638: aload 9
    //   640: aload_0
    //   641: getfield 378	com/tencent/mobileqq/activity/shortvideo/SendVideoTask:g	Ljava/lang/String;
    //   644: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   647: pop
    //   648: ldc 156
    //   650: iconst_2
    //   651: aload 9
    //   653: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   656: invokestatic 277	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   659: aload 7
    //   661: invokevirtual 388	java/io/BufferedOutputStream:close	()V
    //   664: aload 8
    //   666: invokevirtual 389	java/io/FileInputStream:close	()V
    //   669: iconst_5
    //   670: ireturn
    //   671: aload_0
    //   672: aload_0
    //   673: getfield 378	com/tencent/mobileqq/activity/shortvideo/SendVideoTask:g	Ljava/lang/String;
    //   676: ldc_w 299
    //   679: invokestatic 304	com/tencent/mobileqq/shortvideo/SVUtils:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   682: putfield 391	com/tencent/mobileqq/activity/shortvideo/SendVideoTask:f	Ljava/lang/String;
    //   685: aload 14
    //   687: aload_0
    //   688: getfield 391	com/tencent/mobileqq/activity/shortvideo/SendVideoTask:f	Ljava/lang/String;
    //   691: invokestatic 395	com/tencent/mobileqq/utils/FileUtils:rename	(Ljava/lang/String;Ljava/lang/String;)Z
    //   694: istore 6
    //   696: iload 6
    //   698: ifne +15 -> 713
    //   701: aload 7
    //   703: invokevirtual 388	java/io/BufferedOutputStream:close	()V
    //   706: aload 8
    //   708: invokevirtual 389	java/io/FileInputStream:close	()V
    //   711: iconst_5
    //   712: ireturn
    //   713: aload 13
    //   715: lload 4
    //   717: invokestatic 401	android/text/format/Formatter:formatFileSize	(Landroid/content/Context;J)Ljava/lang/String;
    //   720: astore 9
    //   722: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   725: ifeq +40 -> 765
    //   728: new 124	java/lang/StringBuilder
    //   731: dup
    //   732: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   735: astore 10
    //   737: aload 10
    //   739: ldc_w 403
    //   742: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   745: pop
    //   746: aload 10
    //   748: aload 9
    //   750: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   753: pop
    //   754: ldc 156
    //   756: iconst_2
    //   757: aload 10
    //   759: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   762: invokestatic 277	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   765: aload_0
    //   766: getfield 73	com/tencent/mobileqq/activity/shortvideo/SendVideoTask:jdField_b_of_type_Long	J
    //   769: lconst_0
    //   770: lcmp
    //   771: ifne +14 -> 785
    //   774: aload_0
    //   775: aload_0
    //   776: getfield 57	com/tencent/mobileqq/activity/shortvideo/SendVideoTask:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   779: invokestatic 406	com/tencent/mobileqq/shortvideo/ShortVideoUtils:getDuration	(Ljava/lang/String;)J
    //   782: putfield 73	com/tencent/mobileqq/activity/shortvideo/SendVideoTask:jdField_b_of_type_Long	J
    //   785: aload 7
    //   787: invokevirtual 388	java/io/BufferedOutputStream:close	()V
    //   790: aload 8
    //   792: invokevirtual 389	java/io/FileInputStream:close	()V
    //   795: iconst_1
    //   796: ireturn
    //   797: astore 9
    //   799: goto +23 -> 822
    //   802: astore 9
    //   804: goto +38 -> 842
    //   807: astore 9
    //   809: goto +53 -> 862
    //   812: astore 9
    //   814: goto +68 -> 882
    //   817: astore 9
    //   819: aconst_null
    //   820: astore 8
    //   822: aload 7
    //   824: astore 10
    //   826: aload 9
    //   828: astore 7
    //   830: aload 10
    //   832: astore 9
    //   834: goto +303 -> 1137
    //   837: astore 9
    //   839: aconst_null
    //   840: astore 8
    //   842: aload 9
    //   844: astore 11
    //   846: aload 8
    //   848: astore 9
    //   850: aload 7
    //   852: astore 10
    //   854: goto +73 -> 927
    //   857: astore 9
    //   859: aconst_null
    //   860: astore 8
    //   862: aload 9
    //   864: astore 11
    //   866: aload 8
    //   868: astore 9
    //   870: aload 7
    //   872: astore 10
    //   874: goto +124 -> 998
    //   877: astore 9
    //   879: aconst_null
    //   880: astore 8
    //   882: aload 9
    //   884: astore 11
    //   886: aload 8
    //   888: astore 9
    //   890: aload 7
    //   892: astore 10
    //   894: goto +171 -> 1065
    //   897: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   900: ifeq +12 -> 912
    //   903: ldc 156
    //   905: iconst_2
    //   906: ldc_w 408
    //   909: invokestatic 277	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   912: iconst_2
    //   913: ireturn
    //   914: astore 7
    //   916: aconst_null
    //   917: astore 8
    //   919: goto +218 -> 1137
    //   922: astore 11
    //   924: aconst_null
    //   925: astore 9
    //   927: aload 9
    //   929: astore 7
    //   931: aload 10
    //   933: astore 8
    //   935: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   938: ifeq +22 -> 960
    //   941: aload 9
    //   943: astore 7
    //   945: aload 10
    //   947: astore 8
    //   949: ldc 156
    //   951: iconst_2
    //   952: ldc_w 410
    //   955: aload 11
    //   957: invokestatic 265	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   960: aload 10
    //   962: ifnull +11 -> 973
    //   965: aload 10
    //   967: invokevirtual 388	java/io/BufferedOutputStream:close	()V
    //   970: goto +3 -> 973
    //   973: aload 9
    //   975: ifnull +8 -> 983
    //   978: aload 9
    //   980: invokevirtual 389	java/io/FileInputStream:close	()V
    //   983: iconst_4
    //   984: ireturn
    //   985: astore 7
    //   987: aconst_null
    //   988: astore 9
    //   990: aload 11
    //   992: astore 10
    //   994: aload 7
    //   996: astore 11
    //   998: aload 9
    //   1000: astore 7
    //   1002: aload 10
    //   1004: astore 8
    //   1006: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1009: ifeq +22 -> 1031
    //   1012: aload 9
    //   1014: astore 7
    //   1016: aload 10
    //   1018: astore 8
    //   1020: ldc 156
    //   1022: iconst_2
    //   1023: ldc_w 412
    //   1026: aload 11
    //   1028: invokestatic 265	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1031: aload 10
    //   1033: ifnull +11 -> 1044
    //   1036: aload 10
    //   1038: invokevirtual 388	java/io/BufferedOutputStream:close	()V
    //   1041: goto +3 -> 1044
    //   1044: aload 9
    //   1046: ifnull +8 -> 1054
    //   1049: aload 9
    //   1051: invokevirtual 389	java/io/FileInputStream:close	()V
    //   1054: iconst_5
    //   1055: ireturn
    //   1056: astore 11
    //   1058: aconst_null
    //   1059: astore 9
    //   1061: aload 12
    //   1063: astore 10
    //   1065: aload 9
    //   1067: astore 7
    //   1069: aload 10
    //   1071: astore 8
    //   1073: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1076: ifeq +22 -> 1098
    //   1079: aload 9
    //   1081: astore 7
    //   1083: aload 10
    //   1085: astore 8
    //   1087: ldc 156
    //   1089: iconst_2
    //   1090: ldc_w 412
    //   1093: aload 11
    //   1095: invokestatic 265	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1098: aload 10
    //   1100: ifnull +11 -> 1111
    //   1103: aload 10
    //   1105: invokevirtual 388	java/io/BufferedOutputStream:close	()V
    //   1108: goto +3 -> 1111
    //   1111: aload 9
    //   1113: ifnull +8 -> 1121
    //   1116: aload 9
    //   1118: invokevirtual 389	java/io/FileInputStream:close	()V
    //   1121: iconst_3
    //   1122: ireturn
    //   1123: astore 10
    //   1125: aload 8
    //   1127: astore 9
    //   1129: aload 7
    //   1131: astore 8
    //   1133: aload 10
    //   1135: astore 7
    //   1137: aload 9
    //   1139: ifnull +11 -> 1150
    //   1142: aload 9
    //   1144: invokevirtual 388	java/io/BufferedOutputStream:close	()V
    //   1147: goto +3 -> 1150
    //   1150: aload 8
    //   1152: ifnull +8 -> 1160
    //   1155: aload 8
    //   1157: invokevirtual 389	java/io/FileInputStream:close	()V
    //   1160: aload 7
    //   1162: athrow
    //   1163: astore 7
    //   1165: goto -501 -> 664
    //   1168: astore 7
    //   1170: iconst_5
    //   1171: ireturn
    //   1172: astore 7
    //   1174: goto -468 -> 706
    //   1177: astore 7
    //   1179: iconst_5
    //   1180: ireturn
    //   1181: astore 7
    //   1183: goto -393 -> 790
    //   1186: astore 7
    //   1188: goto -393 -> 795
    //   1191: astore 7
    //   1193: goto -220 -> 973
    //   1196: astore 7
    //   1198: iconst_4
    //   1199: ireturn
    //   1200: astore 7
    //   1202: goto -158 -> 1044
    //   1205: astore 7
    //   1207: iconst_5
    //   1208: ireturn
    //   1209: astore 7
    //   1211: goto -100 -> 1111
    //   1214: astore 7
    //   1216: iconst_3
    //   1217: ireturn
    //   1218: astore 9
    //   1220: goto -70 -> 1150
    //   1223: astore 8
    //   1225: goto -65 -> 1160
    //   1228: iconst_2
    //   1229: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1230	0	this	SendVideoTask
    //   115	198	1	i	int
    //   90	173	2	j	int
    //   211	26	3	k	int
    //   588	128	4	l	long
    //   694	3	6	bool	boolean
    //   23	197	7	localObject1	Object
    //   241	17	7	localNumberFormatException	java.lang.NumberFormatException
    //   277	614	7	localObject2	Object
    //   914	1	7	localObject3	Object
    //   929	15	7	localObject4	Object
    //   985	10	7	localException1	Exception
    //   1000	161	7	localObject5	Object
    //   1163	1	7	localIOException1	java.io.IOException
    //   1168	1	7	localIOException2	java.io.IOException
    //   1172	1	7	localIOException3	java.io.IOException
    //   1177	1	7	localIOException4	java.io.IOException
    //   1181	1	7	localIOException5	java.io.IOException
    //   1186	1	7	localIOException6	java.io.IOException
    //   1191	1	7	localIOException7	java.io.IOException
    //   1196	1	7	localIOException8	java.io.IOException
    //   1200	1	7	localIOException9	java.io.IOException
    //   1205	1	7	localIOException10	java.io.IOException
    //   1209	1	7	localIOException11	java.io.IOException
    //   1214	1	7	localIOException12	java.io.IOException
    //   163	993	8	localObject6	Object
    //   1223	1	8	localIOException13	java.io.IOException
    //   98	651	9	localObject7	Object
    //   797	1	9	localObject8	Object
    //   802	1	9	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   807	1	9	localException2	Exception
    //   812	1	9	localIOException14	java.io.IOException
    //   817	10	9	localObject9	Object
    //   832	1	9	localObject10	Object
    //   837	6	9	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   848	1	9	localObject11	Object
    //   857	6	9	localException3	Exception
    //   868	1	9	localObject12	Object
    //   877	6	9	localIOException15	java.io.IOException
    //   888	255	9	localObject13	Object
    //   1218	1	9	localIOException16	java.io.IOException
    //   101	1003	10	localObject14	Object
    //   1123	11	10	localObject15	Object
    //   92	793	11	localObject16	Object
    //   922	69	11	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   996	31	11	localException4	Exception
    //   1056	38	11	localIOException17	java.io.IOException
    //   95	967	12	localObject17	Object
    //   10	704	13	localContext	Context
    //   430	256	14	str	String
    //   476	108	15	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   219	230	241	java/lang/NumberFormatException
    //   583	659	797	finally
    //   671	696	797	finally
    //   713	765	797	finally
    //   765	785	797	finally
    //   583	659	802	java/lang/OutOfMemoryError
    //   671	696	802	java/lang/OutOfMemoryError
    //   713	765	802	java/lang/OutOfMemoryError
    //   765	785	802	java/lang/OutOfMemoryError
    //   583	659	807	java/lang/Exception
    //   671	696	807	java/lang/Exception
    //   713	765	807	java/lang/Exception
    //   765	785	807	java/lang/Exception
    //   583	659	812	java/io/IOException
    //   671	696	812	java/io/IOException
    //   713	765	812	java/io/IOException
    //   765	785	812	java/io/IOException
    //   554	583	817	finally
    //   554	583	837	java/lang/OutOfMemoryError
    //   554	583	857	java/lang/Exception
    //   554	583	877	java/io/IOException
    //   103	114	914	finally
    //   121	133	914	finally
    //   142	192	914	finally
    //   192	201	914	finally
    //   208	212	914	finally
    //   219	230	914	finally
    //   245	262	914	finally
    //   264	306	914	finally
    //   306	318	914	finally
    //   327	342	914	finally
    //   342	355	914	finally
    //   358	390	914	finally
    //   393	508	914	finally
    //   508	514	914	finally
    //   514	530	914	finally
    //   530	536	914	finally
    //   536	554	914	finally
    //   897	912	914	finally
    //   103	114	922	java/lang/OutOfMemoryError
    //   121	133	922	java/lang/OutOfMemoryError
    //   142	192	922	java/lang/OutOfMemoryError
    //   192	201	922	java/lang/OutOfMemoryError
    //   208	212	922	java/lang/OutOfMemoryError
    //   219	230	922	java/lang/OutOfMemoryError
    //   245	262	922	java/lang/OutOfMemoryError
    //   264	306	922	java/lang/OutOfMemoryError
    //   306	318	922	java/lang/OutOfMemoryError
    //   327	342	922	java/lang/OutOfMemoryError
    //   342	355	922	java/lang/OutOfMemoryError
    //   358	390	922	java/lang/OutOfMemoryError
    //   393	508	922	java/lang/OutOfMemoryError
    //   508	514	922	java/lang/OutOfMemoryError
    //   514	530	922	java/lang/OutOfMemoryError
    //   530	536	922	java/lang/OutOfMemoryError
    //   536	554	922	java/lang/OutOfMemoryError
    //   897	912	922	java/lang/OutOfMemoryError
    //   103	114	985	java/lang/Exception
    //   121	133	985	java/lang/Exception
    //   142	192	985	java/lang/Exception
    //   192	201	985	java/lang/Exception
    //   208	212	985	java/lang/Exception
    //   219	230	985	java/lang/Exception
    //   245	262	985	java/lang/Exception
    //   264	306	985	java/lang/Exception
    //   306	318	985	java/lang/Exception
    //   327	342	985	java/lang/Exception
    //   342	355	985	java/lang/Exception
    //   358	390	985	java/lang/Exception
    //   393	508	985	java/lang/Exception
    //   508	514	985	java/lang/Exception
    //   514	530	985	java/lang/Exception
    //   530	536	985	java/lang/Exception
    //   536	554	985	java/lang/Exception
    //   897	912	985	java/lang/Exception
    //   103	114	1056	java/io/IOException
    //   121	133	1056	java/io/IOException
    //   142	192	1056	java/io/IOException
    //   192	201	1056	java/io/IOException
    //   208	212	1056	java/io/IOException
    //   219	230	1056	java/io/IOException
    //   245	262	1056	java/io/IOException
    //   264	306	1056	java/io/IOException
    //   306	318	1056	java/io/IOException
    //   327	342	1056	java/io/IOException
    //   342	355	1056	java/io/IOException
    //   358	390	1056	java/io/IOException
    //   393	508	1056	java/io/IOException
    //   508	514	1056	java/io/IOException
    //   514	530	1056	java/io/IOException
    //   530	536	1056	java/io/IOException
    //   536	554	1056	java/io/IOException
    //   897	912	1056	java/io/IOException
    //   935	941	1123	finally
    //   949	960	1123	finally
    //   1006	1012	1123	finally
    //   1020	1031	1123	finally
    //   1073	1079	1123	finally
    //   1087	1098	1123	finally
    //   659	664	1163	java/io/IOException
    //   664	669	1168	java/io/IOException
    //   701	706	1172	java/io/IOException
    //   706	711	1177	java/io/IOException
    //   785	790	1181	java/io/IOException
    //   790	795	1186	java/io/IOException
    //   965	970	1191	java/io/IOException
    //   978	983	1196	java/io/IOException
    //   1036	1041	1200	java/io/IOException
    //   1049	1054	1205	java/io/IOException
    //   1103	1108	1209	java/io/IOException
    //   1116	1121	1214	java/io/IOException
    //   1142	1147	1218	java/io/IOException
    //   1155	1160	1223	java/io/IOException
  }
  
  protected Integer a(Void... paramVarArgs)
  {
    return Integer.valueOf(a());
  }
  
  public void a()
  {
    Intent localIntent = ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getIntent();
    localIntent.putExtra("uin", this.jdField_c_of_type_JavaLangString);
    localIntent.putExtra("uintype", this.jdField_a_of_type_Int);
    localIntent.putExtra("file_send_path", this.jdField_b_of_type_JavaLangString);
    localIntent.putExtra("file_send_size", this.jdField_a_of_type_Long);
    localIntent.putExtra("file_send_duration", (int)(this.jdField_b_of_type_Long / 1000L));
    localIntent.putExtra("file_source", this.jdField_d_of_type_JavaLangString);
    localIntent.putExtra("thumbfile_send_path", this.f);
    localIntent.putExtra("file_shortvideo_md5", this.jdField_e_of_type_JavaLangString);
    localIntent.putExtra("thumbfile_send_width", this.jdField_b_of_type_Int);
    localIntent.putExtra("thumbfile_send_height", this.jdField_c_of_type_Int);
    localIntent.putExtra("thumbfile_md5", this.g);
    localIntent.putExtra("file_width", this.jdField_d_of_type_Int);
    localIntent.putExtra("file_height", this.jdField_e_of_type_Int);
    localIntent.putExtra("file_raw_size", this.jdField_b_of_type_Boolean);
    Object localObject1 = this.jdField_a_of_type_JavaLangString;
    Object localObject2;
    if ((localObject1 != null) && (((String)localObject1).equals(ShortVideoPreviewActivity.class.getName())))
    {
      localIntent.putExtra("file_send_business_type", 2);
      localObject1 = SVBusiUtil.a(0, 2);
      ((ShortVideoReq)localObject1).a(ShortVideoBusiManager.a(2, localIntent, (ShortVideoReq)localObject1));
      ShortVideoBusiManager.a((ShortVideoReq)localObject1, ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).app);
    }
    else
    {
      localIntent.putExtra("file_send_business_type", 0);
      localObject2 = SVBusiUtil.a(0, 0);
      localObject1 = ShortVideoBusiManager.a(0, localIntent, (ShortVideoReq)localObject2);
      ((ShortVideoReq)localObject2).a((ShortVideoUploadInfo)localObject1);
      localObject2 = ((IShortVideoFactory)QRoute.api(IShortVideoFactory.class)).getAioShortVideoSendOperator(((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).app);
      localObject1 = ((IShortVideoOperator)localObject2).a((ShortVideoUploadInfo)localObject1);
      if (((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).app != null) {
        ((IOrderMediaMsgService)((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).app.getRuntimeService(IOrderMediaMsgService.class)).enqueueMediaMsgByUniseq(((MessageRecord)localObject1).frienduin, ((MessageRecord)localObject1).uniseq);
      }
      ((IShortVideoOperator)localObject2).a((MessageRecord)localObject1);
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      localObject2 = ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getIntent();
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
        ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).startActivity(localIntent);
      }
      ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).finish();
      ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).overridePendingTransition(0, 2130771994);
    }
  }
  
  void a(Context paramContext, int paramInt)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    try
    {
      if (this.jdField_a_of_type_AndroidAppProgressDialog != null)
      {
        b();
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
    b();
    int i = paramInteger.intValue();
    if (i != 9)
    {
      switch (i)
      {
      default: 
        return;
      case 5: 
        a((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 2131719109, this.jdField_a_of_type_Boolean);
        return;
      case 4: 
        a((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 2131719083, this.jdField_a_of_type_Boolean);
        return;
      case 3: 
        a((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 2131719112, this.jdField_a_of_type_Boolean);
        return;
      case 2: 
      case 6: 
        a((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 2131719117, this.jdField_a_of_type_Boolean);
        return;
      }
      a();
      return;
    }
    ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).finish();
  }
  
  void b()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    try
    {
      if (this.jdField_a_of_type_AndroidAppProgressDialog != null) {
        this.jdField_a_of_type_AndroidAppProgressDialog.cancel();
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
    a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 2131694878);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.shortvideo.SendVideoTask
 * JD-Core Version:    0.7.0.1
 */