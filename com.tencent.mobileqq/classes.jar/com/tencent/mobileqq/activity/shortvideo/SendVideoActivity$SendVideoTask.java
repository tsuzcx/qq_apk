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
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.richmedia.ordersend.OrderMediaMsgManager;
import com.tencent.mobileqq.shortvideo.AioShortVideoOperator;
import com.tencent.mobileqq.shortvideo.ShortVideoBusiManager;
import com.tencent.mobileqq.shortvideo.ShortVideoReq;
import com.tencent.mobileqq.shortvideo.ShortVideoUploadInfo;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportProgressDialog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class SendVideoActivity$SendVideoTask
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
  
  public SendVideoActivity$SendVideoTask(BaseActivity paramBaseActivity, Intent paramIntent)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramBaseActivity);
    paramBaseActivity = paramBaseActivity.getIntent();
    if (paramIntent != null) {}
    for (;;)
    {
      this.jdField_b_of_type_JavaLangString = paramIntent.getExtras().getString("file_send_path");
      this.jdField_a_of_type_JavaUtilArrayList = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS_BY_FILE");
      this.jdField_b_of_type_Long = paramIntent.getExtras().getLong("file_send_duration");
      this.jdField_a_of_type_Long = paramIntent.getExtras().getLong("file_send_size");
      this.jdField_c_of_type_JavaLangString = paramIntent.getExtras().getString("uin");
      this.jdField_a_of_type_Int = paramIntent.getIntExtra("uintype", -1);
      this.jdField_d_of_type_JavaLangString = paramIntent.getStringExtra("file_source");
      this.jdField_e_of_type_JavaLangString = paramIntent.getExtras().getString("file_shortvideo_md5");
      this.jdField_a_of_type_JavaLangString = paramIntent.getExtras().getString("activity_before_enter_send_video");
      this.jdField_a_of_type_Boolean = paramIntent.getExtras().getBoolean("send_in_background");
      if (paramIntent.getIntExtra("PhotoConst.SEND_SIZE_SPEC", 0) == 2) {}
      for (boolean bool = true;; bool = false)
      {
        this.jdField_b_of_type_Boolean = bool;
        if (QLog.isColorLevel()) {
          QLog.d("SendVideoActivity", 2, " SendVideoTask(),  mVideoPath :" + this.jdField_b_of_type_JavaLangString + ", mDuration:" + this.jdField_b_of_type_Long + ", mFileSize:" + this.jdField_a_of_type_Long + ",mUin" + this.jdField_c_of_type_JavaLangString + ",mUinType:" + this.jdField_a_of_type_Int + ",mFileSource:" + this.jdField_d_of_type_JavaLangString + ",mSendBackground = " + this.jdField_a_of_type_Boolean + ", mSendRawVideo:" + this.jdField_b_of_type_Boolean);
        }
        return;
      }
      paramIntent = paramBaseActivity;
    }
  }
  
  public static void a(BaseActivity paramBaseActivity, int paramInt, boolean paramBoolean)
  {
    QQCustomDialog localQQCustomDialog = DialogUtil.a(paramBaseActivity, 232, null, paramBaseActivity.getString(paramInt), new SendVideoActivity.SendVideoTask.1(paramBoolean, paramBaseActivity), null);
    if (!paramBaseActivity.isFinishing()) {
      localQQCustomDialog.show();
    }
  }
  
  /* Error */
  public int a()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 35	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$SendVideoTask:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   4: invokevirtual 199	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   7: checkcast 201	android/content/Context
    //   10: astore 11
    //   12: aload 11
    //   14: ifnonnull +7 -> 21
    //   17: iconst_5
    //   18: istore_1
    //   19: iload_1
    //   20: ireturn
    //   21: aload_0
    //   22: getfield 65	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$SendVideoTask:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   25: ifnull +60 -> 85
    //   28: aload_0
    //   29: getfield 65	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$SendVideoTask:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   32: invokevirtual 206	java/util/ArrayList:isEmpty	()Z
    //   35: ifne +50 -> 85
    //   38: aload_0
    //   39: getfield 35	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$SendVideoTask:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   42: invokevirtual 199	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   45: checkcast 37	com/tencent/mobileqq/app/BaseActivity
    //   48: getfield 210	com/tencent/mobileqq/app/BaseActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   51: aload_0
    //   52: getfield 65	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$SendVideoTask:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   55: aload_0
    //   56: getfield 81	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$SendVideoTask:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   59: aload_0
    //   60: getfield 89	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$SendVideoTask:jdField_a_of_type_Int	I
    //   63: invokestatic 215	com/tencent/mobileqq/utils/SendByFile:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/util/List;Ljava/lang/String;I)V
    //   66: aload_0
    //   67: getfield 57	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$SendVideoTask:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   70: ifnull +12 -> 82
    //   73: aload_0
    //   74: getfield 57	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$SendVideoTask:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   77: ldc 217
    //   79: if_acmpne +6 -> 85
    //   82: bipush 9
    //   84: ireturn
    //   85: sipush 1280
    //   88: istore_2
    //   89: invokestatic 223	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   92: invokevirtual 227	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   95: checkcast 229	com/tencent/mobileqq/app/QQAppInterface
    //   98: astore 7
    //   100: iload_2
    //   101: istore_1
    //   102: aload 7
    //   104: ifnull +106 -> 210
    //   107: aload 11
    //   109: aload 7
    //   111: invokevirtual 232	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   114: invokestatic 238	com/tencent/mobileqq/utils/SharedPreUtils:p	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   117: astore 7
    //   119: iload_2
    //   120: istore_1
    //   121: aload 7
    //   123: ifnull +87 -> 210
    //   126: iload_2
    //   127: istore_1
    //   128: aload 7
    //   130: invokevirtual 243	java/lang/String:length	()I
    //   133: ifle +77 -> 210
    //   136: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   139: ifeq +29 -> 168
    //   142: ldc 124
    //   144: iconst_2
    //   145: new 126	java/lang/StringBuilder
    //   148: dup
    //   149: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   152: ldc 245
    //   154: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: aload 7
    //   159: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   165: invokestatic 163	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   168: aload 7
    //   170: ldc 247
    //   172: invokevirtual 251	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   175: astore 7
    //   177: iload_2
    //   178: istore_1
    //   179: aload 7
    //   181: ifnull +29 -> 210
    //   184: aload 7
    //   186: arraylength
    //   187: istore_3
    //   188: iload_2
    //   189: istore_1
    //   190: iload_3
    //   191: iconst_5
    //   192: if_icmplt +18 -> 210
    //   195: aload 7
    //   197: iconst_0
    //   198: aaload
    //   199: invokestatic 257	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   202: invokevirtual 260	java/lang/Integer:intValue	()I
    //   205: istore_1
    //   206: iload_1
    //   207: ifle +1219 -> 1426
    //   210: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   213: ifeq +29 -> 242
    //   216: ldc 124
    //   218: iconst_2
    //   219: new 126	java/lang/StringBuilder
    //   222: dup
    //   223: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   226: ldc_w 262
    //   229: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: iload_1
    //   233: invokevirtual 147	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   236: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   239: invokestatic 163	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   242: aload 11
    //   244: aload_0
    //   245: getfield 57	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$SendVideoTask:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   248: iload_1
    //   249: invokestatic 268	com/tencent/mobileqq/shortvideo/ShortVideoUtils:getVideoThumbnail	(Landroid/content/Context;Ljava/lang/String;I)Landroid/graphics/Bitmap;
    //   252: astore 8
    //   254: aload 8
    //   256: ifnonnull +1167 -> 1423
    //   259: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   262: ifeq +12 -> 274
    //   265: ldc 124
    //   267: iconst_2
    //   268: ldc_w 270
    //   271: invokestatic 272	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   274: aload_0
    //   275: getfield 274	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$SendVideoTask:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   278: ifnull +201 -> 479
    //   281: aload_0
    //   282: getfield 274	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$SendVideoTask:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   285: astore 8
    //   287: aload_0
    //   288: aload 8
    //   290: invokevirtual 279	android/graphics/Bitmap:getWidth	()I
    //   293: putfield 281	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$SendVideoTask:jdField_b_of_type_Int	I
    //   296: aload_0
    //   297: aload 8
    //   299: invokevirtual 284	android/graphics/Bitmap:getHeight	()I
    //   302: putfield 286	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$SendVideoTask:jdField_c_of_type_Int	I
    //   305: aload_0
    //   306: getfield 281	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$SendVideoTask:jdField_b_of_type_Int	I
    //   309: ifeq +10 -> 319
    //   312: aload_0
    //   313: getfield 286	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$SendVideoTask:jdField_c_of_type_Int	I
    //   316: ifne +201 -> 517
    //   319: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   322: ifeq +12 -> 334
    //   325: ldc 124
    //   327: iconst_2
    //   328: ldc_w 288
    //   331: invokestatic 272	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   334: iconst_0
    //   335: ifeq +11 -> 346
    //   338: new 290	java/lang/NullPointerException
    //   341: dup
    //   342: invokespecial 291	java/lang/NullPointerException:<init>	()V
    //   345: athrow
    //   346: iconst_0
    //   347: ifeq +11 -> 358
    //   350: new 290	java/lang/NullPointerException
    //   353: dup
    //   354: invokespecial 291	java/lang/NullPointerException:<init>	()V
    //   357: athrow
    //   358: iconst_0
    //   359: ifeq +11 -> 370
    //   362: new 290	java/lang/NullPointerException
    //   365: dup
    //   366: invokespecial 291	java/lang/NullPointerException:<init>	()V
    //   369: athrow
    //   370: iconst_2
    //   371: ireturn
    //   372: astore 7
    //   374: iload_2
    //   375: istore_1
    //   376: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   379: ifeq -169 -> 210
    //   382: ldc 124
    //   384: iconst_2
    //   385: ldc_w 293
    //   388: aload 7
    //   390: invokestatic 296	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   393: iload_2
    //   394: istore_1
    //   395: goto -185 -> 210
    //   398: astore 11
    //   400: aconst_null
    //   401: astore 7
    //   403: aconst_null
    //   404: astore 10
    //   406: aload 7
    //   408: astore 9
    //   410: aload 10
    //   412: astore 8
    //   414: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   417: ifeq +22 -> 439
    //   420: aload 7
    //   422: astore 9
    //   424: aload 10
    //   426: astore 8
    //   428: ldc 124
    //   430: iconst_2
    //   431: ldc_w 298
    //   434: aload 11
    //   436: invokestatic 296	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   439: iconst_3
    //   440: istore_1
    //   441: iconst_0
    //   442: ifeq +11 -> 453
    //   445: new 290	java/lang/NullPointerException
    //   448: dup
    //   449: invokespecial 291	java/lang/NullPointerException:<init>	()V
    //   452: athrow
    //   453: aload 7
    //   455: ifnull +8 -> 463
    //   458: aload 7
    //   460: invokevirtual 303	java/io/BufferedOutputStream:close	()V
    //   463: aload 10
    //   465: ifnull -446 -> 19
    //   468: aload 10
    //   470: invokevirtual 306	java/io/FileInputStream:close	()V
    //   473: iconst_3
    //   474: ireturn
    //   475: astore 7
    //   477: iconst_3
    //   478: ireturn
    //   479: iconst_0
    //   480: ifeq +11 -> 491
    //   483: new 290	java/lang/NullPointerException
    //   486: dup
    //   487: invokespecial 291	java/lang/NullPointerException:<init>	()V
    //   490: athrow
    //   491: iconst_0
    //   492: ifeq +11 -> 503
    //   495: new 290	java/lang/NullPointerException
    //   498: dup
    //   499: invokespecial 291	java/lang/NullPointerException:<init>	()V
    //   502: athrow
    //   503: iconst_0
    //   504: ifeq +11 -> 515
    //   507: new 290	java/lang/NullPointerException
    //   510: dup
    //   511: invokespecial 291	java/lang/NullPointerException:<init>	()V
    //   514: athrow
    //   515: iconst_2
    //   516: ireturn
    //   517: new 126	java/lang/StringBuilder
    //   520: dup
    //   521: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   524: ldc 217
    //   526: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   529: invokestatic 312	java/lang/System:currentTimeMillis	()J
    //   532: invokevirtual 138	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   535: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   538: ldc_w 314
    //   541: invokestatic 318	com/tencent/mobileqq/shortvideo/ShortVideoUtils:getShortVideoThumbPicPath	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   544: astore 12
    //   546: new 126	java/lang/StringBuilder
    //   549: dup
    //   550: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   553: invokestatic 321	com/tencent/mobileqq/shortvideo/ShortVideoUtils:getShortVideoThumbPicDir	()Ljava/lang/String;
    //   556: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   559: ldc_w 323
    //   562: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   565: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   568: invokestatic 328	com/tencent/mobileqq/utils/FileUtils:c	(Ljava/lang/String;)V
    //   571: new 330	java/io/File
    //   574: dup
    //   575: aload 12
    //   577: invokespecial 332	java/io/File:<init>	(Ljava/lang/String;)V
    //   580: astore 13
    //   582: new 330	java/io/File
    //   585: dup
    //   586: aload 13
    //   588: invokevirtual 335	java/io/File:getParent	()Ljava/lang/String;
    //   591: invokespecial 332	java/io/File:<init>	(Ljava/lang/String;)V
    //   594: astore 7
    //   596: aload 7
    //   598: invokevirtual 338	java/io/File:exists	()Z
    //   601: ifeq +11 -> 612
    //   604: aload 7
    //   606: invokevirtual 341	java/io/File:isDirectory	()Z
    //   609: ifne +9 -> 618
    //   612: aload 7
    //   614: invokevirtual 344	java/io/File:mkdirs	()Z
    //   617: pop
    //   618: aload 13
    //   620: invokevirtual 338	java/io/File:exists	()Z
    //   623: ifeq +11 -> 634
    //   626: aload 13
    //   628: invokevirtual 347	java/io/File:isFile	()Z
    //   631: ifne +9 -> 640
    //   634: aload 13
    //   636: invokevirtual 350	java/io/File:createNewFile	()Z
    //   639: pop
    //   640: new 300	java/io/BufferedOutputStream
    //   643: dup
    //   644: new 352	java/io/FileOutputStream
    //   647: dup
    //   648: aload 13
    //   650: invokespecial 355	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   653: invokespecial 358	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   656: astore 7
    //   658: aload 8
    //   660: getstatic 364	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   663: bipush 80
    //   665: aload 7
    //   667: invokevirtual 368	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   670: pop
    //   671: aload 7
    //   673: invokevirtual 371	java/io/BufferedOutputStream:flush	()V
    //   676: new 305	java/io/FileInputStream
    //   679: dup
    //   680: aload 13
    //   682: invokespecial 372	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   685: astore 10
    //   687: aload 7
    //   689: astore 9
    //   691: aload 10
    //   693: astore 8
    //   695: aload 13
    //   697: invokevirtual 374	java/io/File:length	()J
    //   700: lstore 4
    //   702: aload 7
    //   704: astore 9
    //   706: aload 10
    //   708: astore 8
    //   710: aload_0
    //   711: aload 10
    //   713: lload 4
    //   715: invokestatic 380	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   718: invokestatic 386	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   721: putfield 388	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$SendVideoTask:g	Ljava/lang/String;
    //   724: aload 7
    //   726: astore 9
    //   728: aload 10
    //   730: astore 8
    //   732: aload_0
    //   733: getfield 388	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$SendVideoTask:g	Ljava/lang/String;
    //   736: invokestatic 393	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   739: ifeq +88 -> 827
    //   742: aload 7
    //   744: astore 9
    //   746: aload 10
    //   748: astore 8
    //   750: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   753: ifeq +40 -> 793
    //   756: aload 7
    //   758: astore 9
    //   760: aload 10
    //   762: astore 8
    //   764: ldc 124
    //   766: iconst_2
    //   767: new 126	java/lang/StringBuilder
    //   770: dup
    //   771: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   774: ldc_w 395
    //   777: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   780: aload_0
    //   781: getfield 388	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$SendVideoTask:g	Ljava/lang/String;
    //   784: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   787: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   790: invokestatic 272	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   793: iconst_0
    //   794: ifeq +11 -> 805
    //   797: new 290	java/lang/NullPointerException
    //   800: dup
    //   801: invokespecial 291	java/lang/NullPointerException:<init>	()V
    //   804: athrow
    //   805: aload 7
    //   807: ifnull +8 -> 815
    //   810: aload 7
    //   812: invokevirtual 303	java/io/BufferedOutputStream:close	()V
    //   815: aload 10
    //   817: ifnull +8 -> 825
    //   820: aload 10
    //   822: invokevirtual 306	java/io/FileInputStream:close	()V
    //   825: iconst_5
    //   826: ireturn
    //   827: aload 7
    //   829: astore 9
    //   831: aload 10
    //   833: astore 8
    //   835: aload_0
    //   836: aload_0
    //   837: getfield 388	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$SendVideoTask:g	Ljava/lang/String;
    //   840: ldc_w 314
    //   843: invokestatic 318	com/tencent/mobileqq/shortvideo/ShortVideoUtils:getShortVideoThumbPicPath	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   846: putfield 397	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$SendVideoTask:f	Ljava/lang/String;
    //   849: aload 7
    //   851: astore 9
    //   853: aload 10
    //   855: astore 8
    //   857: aload 12
    //   859: aload_0
    //   860: getfield 397	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$SendVideoTask:f	Ljava/lang/String;
    //   863: invokestatic 400	com/tencent/mobileqq/utils/FileUtils:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   866: istore 6
    //   868: iload 6
    //   870: ifne +37 -> 907
    //   873: iconst_0
    //   874: ifeq +11 -> 885
    //   877: new 290	java/lang/NullPointerException
    //   880: dup
    //   881: invokespecial 291	java/lang/NullPointerException:<init>	()V
    //   884: athrow
    //   885: aload 7
    //   887: ifnull +8 -> 895
    //   890: aload 7
    //   892: invokevirtual 303	java/io/BufferedOutputStream:close	()V
    //   895: aload 10
    //   897: ifnull +8 -> 905
    //   900: aload 10
    //   902: invokevirtual 306	java/io/FileInputStream:close	()V
    //   905: iconst_5
    //   906: ireturn
    //   907: aload 7
    //   909: astore 9
    //   911: aload 10
    //   913: astore 8
    //   915: aload 11
    //   917: lload 4
    //   919: invokestatic 406	android/text/format/Formatter:formatFileSize	(Landroid/content/Context;J)Ljava/lang/String;
    //   922: astore 11
    //   924: aload 7
    //   926: astore 9
    //   928: aload 10
    //   930: astore 8
    //   932: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   935: ifeq +38 -> 973
    //   938: aload 7
    //   940: astore 9
    //   942: aload 10
    //   944: astore 8
    //   946: ldc 124
    //   948: iconst_2
    //   949: new 126	java/lang/StringBuilder
    //   952: dup
    //   953: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   956: ldc_w 408
    //   959: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   962: aload 11
    //   964: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   967: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   970: invokestatic 272	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   973: aload 7
    //   975: astore 9
    //   977: aload 10
    //   979: astore 8
    //   981: aload_0
    //   982: getfield 73	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$SendVideoTask:jdField_b_of_type_Long	J
    //   985: lconst_0
    //   986: lcmp
    //   987: ifne +22 -> 1009
    //   990: aload 7
    //   992: astore 9
    //   994: aload 10
    //   996: astore 8
    //   998: aload_0
    //   999: aload_0
    //   1000: getfield 57	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$SendVideoTask:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1003: invokestatic 411	com/tencent/mobileqq/shortvideo/ShortVideoUtils:getDuration	(Ljava/lang/String;)J
    //   1006: putfield 73	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$SendVideoTask:jdField_b_of_type_Long	J
    //   1009: iconst_0
    //   1010: ifeq +11 -> 1021
    //   1013: new 290	java/lang/NullPointerException
    //   1016: dup
    //   1017: invokespecial 291	java/lang/NullPointerException:<init>	()V
    //   1020: athrow
    //   1021: aload 7
    //   1023: ifnull +8 -> 1031
    //   1026: aload 7
    //   1028: invokevirtual 303	java/io/BufferedOutputStream:close	()V
    //   1031: aload 10
    //   1033: ifnull +8 -> 1041
    //   1036: aload 10
    //   1038: invokevirtual 306	java/io/FileInputStream:close	()V
    //   1041: iconst_1
    //   1042: ireturn
    //   1043: astore 11
    //   1045: aconst_null
    //   1046: astore 7
    //   1048: aconst_null
    //   1049: astore 10
    //   1051: aload 7
    //   1053: astore 9
    //   1055: aload 10
    //   1057: astore 8
    //   1059: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1062: ifeq +22 -> 1084
    //   1065: aload 7
    //   1067: astore 9
    //   1069: aload 10
    //   1071: astore 8
    //   1073: ldc 124
    //   1075: iconst_2
    //   1076: ldc_w 298
    //   1079: aload 11
    //   1081: invokestatic 296	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1084: iconst_0
    //   1085: ifeq +11 -> 1096
    //   1088: new 290	java/lang/NullPointerException
    //   1091: dup
    //   1092: invokespecial 291	java/lang/NullPointerException:<init>	()V
    //   1095: athrow
    //   1096: aload 7
    //   1098: ifnull +8 -> 1106
    //   1101: aload 7
    //   1103: invokevirtual 303	java/io/BufferedOutputStream:close	()V
    //   1106: aload 10
    //   1108: ifnull +8 -> 1116
    //   1111: aload 10
    //   1113: invokevirtual 306	java/io/FileInputStream:close	()V
    //   1116: iconst_5
    //   1117: ireturn
    //   1118: astore 11
    //   1120: aconst_null
    //   1121: astore 7
    //   1123: aconst_null
    //   1124: astore 10
    //   1126: aload 7
    //   1128: astore 9
    //   1130: aload 10
    //   1132: astore 8
    //   1134: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1137: ifeq +22 -> 1159
    //   1140: aload 7
    //   1142: astore 9
    //   1144: aload 10
    //   1146: astore 8
    //   1148: ldc 124
    //   1150: iconst_2
    //   1151: ldc_w 413
    //   1154: aload 11
    //   1156: invokestatic 296	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1159: iconst_4
    //   1160: istore_1
    //   1161: iconst_0
    //   1162: ifeq +11 -> 1173
    //   1165: new 290	java/lang/NullPointerException
    //   1168: dup
    //   1169: invokespecial 291	java/lang/NullPointerException:<init>	()V
    //   1172: athrow
    //   1173: aload 7
    //   1175: ifnull +8 -> 1183
    //   1178: aload 7
    //   1180: invokevirtual 303	java/io/BufferedOutputStream:close	()V
    //   1183: aload 10
    //   1185: ifnull -1166 -> 19
    //   1188: aload 10
    //   1190: invokevirtual 306	java/io/FileInputStream:close	()V
    //   1193: iconst_4
    //   1194: ireturn
    //   1195: astore 7
    //   1197: iconst_4
    //   1198: ireturn
    //   1199: astore 10
    //   1201: aconst_null
    //   1202: astore 7
    //   1204: aconst_null
    //   1205: astore 8
    //   1207: iconst_0
    //   1208: ifeq +11 -> 1219
    //   1211: new 290	java/lang/NullPointerException
    //   1214: dup
    //   1215: invokespecial 291	java/lang/NullPointerException:<init>	()V
    //   1218: athrow
    //   1219: aload 7
    //   1221: ifnull +8 -> 1229
    //   1224: aload 7
    //   1226: invokevirtual 303	java/io/BufferedOutputStream:close	()V
    //   1229: aload 8
    //   1231: ifnull +8 -> 1239
    //   1234: aload 8
    //   1236: invokevirtual 306	java/io/FileInputStream:close	()V
    //   1239: aload 10
    //   1241: athrow
    //   1242: astore 7
    //   1244: goto -753 -> 491
    //   1247: astore 7
    //   1249: goto -746 -> 503
    //   1252: astore 7
    //   1254: goto -739 -> 515
    //   1257: astore 7
    //   1259: goto -913 -> 346
    //   1262: astore 7
    //   1264: goto -906 -> 358
    //   1267: astore 7
    //   1269: goto -899 -> 370
    //   1272: astore 8
    //   1274: goto -469 -> 805
    //   1277: astore 7
    //   1279: goto -464 -> 815
    //   1282: astore 7
    //   1284: goto -459 -> 825
    //   1287: astore 8
    //   1289: goto -404 -> 885
    //   1292: astore 7
    //   1294: goto -399 -> 895
    //   1297: astore 7
    //   1299: goto -394 -> 905
    //   1302: astore 8
    //   1304: goto -283 -> 1021
    //   1307: astore 7
    //   1309: goto -278 -> 1031
    //   1312: astore 7
    //   1314: goto -273 -> 1041
    //   1317: astore 8
    //   1319: goto -866 -> 453
    //   1322: astore 7
    //   1324: goto -861 -> 463
    //   1327: astore 8
    //   1329: goto -233 -> 1096
    //   1332: astore 7
    //   1334: goto -228 -> 1106
    //   1337: astore 7
    //   1339: goto -223 -> 1116
    //   1342: astore 8
    //   1344: goto -171 -> 1173
    //   1347: astore 7
    //   1349: goto -166 -> 1183
    //   1352: astore 9
    //   1354: goto -135 -> 1219
    //   1357: astore 7
    //   1359: goto -130 -> 1229
    //   1362: astore 7
    //   1364: goto -125 -> 1239
    //   1367: astore 10
    //   1369: aconst_null
    //   1370: astore 8
    //   1372: goto -165 -> 1207
    //   1375: astore 10
    //   1377: aload 9
    //   1379: astore 7
    //   1381: goto -174 -> 1207
    //   1384: astore 11
    //   1386: aconst_null
    //   1387: astore 10
    //   1389: goto -263 -> 1126
    //   1392: astore 11
    //   1394: goto -268 -> 1126
    //   1397: astore 11
    //   1399: aconst_null
    //   1400: astore 10
    //   1402: goto -351 -> 1051
    //   1405: astore 11
    //   1407: goto -356 -> 1051
    //   1410: astore 11
    //   1412: aconst_null
    //   1413: astore 10
    //   1415: goto -1009 -> 406
    //   1418: astore 11
    //   1420: goto -1014 -> 406
    //   1423: goto -1136 -> 287
    //   1426: sipush 1280
    //   1429: istore_1
    //   1430: goto -1220 -> 210
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1433	0	this	SendVideoTask
    //   18	1412	1	i	int
    //   88	306	2	j	int
    //   187	6	3	k	int
    //   700	218	4	l	long
    //   866	3	6	bool	boolean
    //   98	98	7	localObject1	Object
    //   372	17	7	localNumberFormatException	java.lang.NumberFormatException
    //   401	58	7	localObject2	Object
    //   475	1	7	localIOException1	java.io.IOException
    //   594	585	7	localObject3	Object
    //   1195	1	7	localIOException2	java.io.IOException
    //   1202	23	7	localObject4	Object
    //   1242	1	7	localIOException3	java.io.IOException
    //   1247	1	7	localIOException4	java.io.IOException
    //   1252	1	7	localIOException5	java.io.IOException
    //   1257	1	7	localIOException6	java.io.IOException
    //   1262	1	7	localIOException7	java.io.IOException
    //   1267	1	7	localIOException8	java.io.IOException
    //   1277	1	7	localIOException9	java.io.IOException
    //   1282	1	7	localIOException10	java.io.IOException
    //   1292	1	7	localIOException11	java.io.IOException
    //   1297	1	7	localIOException12	java.io.IOException
    //   1307	1	7	localIOException13	java.io.IOException
    //   1312	1	7	localIOException14	java.io.IOException
    //   1322	1	7	localIOException15	java.io.IOException
    //   1332	1	7	localIOException16	java.io.IOException
    //   1337	1	7	localIOException17	java.io.IOException
    //   1347	1	7	localIOException18	java.io.IOException
    //   1357	1	7	localIOException19	java.io.IOException
    //   1362	1	7	localIOException20	java.io.IOException
    //   1379	1	7	localObject5	Object
    //   252	983	8	localObject6	Object
    //   1272	1	8	localIOException21	java.io.IOException
    //   1287	1	8	localIOException22	java.io.IOException
    //   1302	1	8	localIOException23	java.io.IOException
    //   1317	1	8	localIOException24	java.io.IOException
    //   1327	1	8	localIOException25	java.io.IOException
    //   1342	1	8	localIOException26	java.io.IOException
    //   1370	1	8	localObject7	Object
    //   408	735	9	localObject8	Object
    //   1352	26	9	localIOException27	java.io.IOException
    //   404	785	10	localFileInputStream	java.io.FileInputStream
    //   1199	41	10	localObject9	Object
    //   1367	1	10	localObject10	Object
    //   1375	1	10	localObject11	Object
    //   1387	27	10	localObject12	Object
    //   10	233	11	localContext	Context
    //   398	518	11	localIOException28	java.io.IOException
    //   922	41	11	str1	String
    //   1043	37	11	localException1	Exception
    //   1118	37	11	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   1384	1	11	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   1392	1	11	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   1397	1	11	localException2	Exception
    //   1405	1	11	localException3	Exception
    //   1410	1	11	localIOException29	java.io.IOException
    //   1418	1	11	localIOException30	java.io.IOException
    //   544	314	12	str2	String
    //   580	116	13	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   195	206	372	java/lang/NumberFormatException
    //   89	100	398	java/io/IOException
    //   107	119	398	java/io/IOException
    //   128	168	398	java/io/IOException
    //   168	177	398	java/io/IOException
    //   184	188	398	java/io/IOException
    //   195	206	398	java/io/IOException
    //   210	242	398	java/io/IOException
    //   242	254	398	java/io/IOException
    //   259	274	398	java/io/IOException
    //   274	287	398	java/io/IOException
    //   287	319	398	java/io/IOException
    //   319	334	398	java/io/IOException
    //   376	393	398	java/io/IOException
    //   517	612	398	java/io/IOException
    //   612	618	398	java/io/IOException
    //   618	634	398	java/io/IOException
    //   634	640	398	java/io/IOException
    //   640	658	398	java/io/IOException
    //   468	473	475	java/io/IOException
    //   89	100	1043	java/lang/Exception
    //   107	119	1043	java/lang/Exception
    //   128	168	1043	java/lang/Exception
    //   168	177	1043	java/lang/Exception
    //   184	188	1043	java/lang/Exception
    //   195	206	1043	java/lang/Exception
    //   210	242	1043	java/lang/Exception
    //   242	254	1043	java/lang/Exception
    //   259	274	1043	java/lang/Exception
    //   274	287	1043	java/lang/Exception
    //   287	319	1043	java/lang/Exception
    //   319	334	1043	java/lang/Exception
    //   376	393	1043	java/lang/Exception
    //   517	612	1043	java/lang/Exception
    //   612	618	1043	java/lang/Exception
    //   618	634	1043	java/lang/Exception
    //   634	640	1043	java/lang/Exception
    //   640	658	1043	java/lang/Exception
    //   89	100	1118	java/lang/OutOfMemoryError
    //   107	119	1118	java/lang/OutOfMemoryError
    //   128	168	1118	java/lang/OutOfMemoryError
    //   168	177	1118	java/lang/OutOfMemoryError
    //   184	188	1118	java/lang/OutOfMemoryError
    //   195	206	1118	java/lang/OutOfMemoryError
    //   210	242	1118	java/lang/OutOfMemoryError
    //   242	254	1118	java/lang/OutOfMemoryError
    //   259	274	1118	java/lang/OutOfMemoryError
    //   274	287	1118	java/lang/OutOfMemoryError
    //   287	319	1118	java/lang/OutOfMemoryError
    //   319	334	1118	java/lang/OutOfMemoryError
    //   376	393	1118	java/lang/OutOfMemoryError
    //   517	612	1118	java/lang/OutOfMemoryError
    //   612	618	1118	java/lang/OutOfMemoryError
    //   618	634	1118	java/lang/OutOfMemoryError
    //   634	640	1118	java/lang/OutOfMemoryError
    //   640	658	1118	java/lang/OutOfMemoryError
    //   1188	1193	1195	java/io/IOException
    //   89	100	1199	finally
    //   107	119	1199	finally
    //   128	168	1199	finally
    //   168	177	1199	finally
    //   184	188	1199	finally
    //   195	206	1199	finally
    //   210	242	1199	finally
    //   242	254	1199	finally
    //   259	274	1199	finally
    //   274	287	1199	finally
    //   287	319	1199	finally
    //   319	334	1199	finally
    //   376	393	1199	finally
    //   517	612	1199	finally
    //   612	618	1199	finally
    //   618	634	1199	finally
    //   634	640	1199	finally
    //   640	658	1199	finally
    //   483	491	1242	java/io/IOException
    //   495	503	1247	java/io/IOException
    //   507	515	1252	java/io/IOException
    //   338	346	1257	java/io/IOException
    //   350	358	1262	java/io/IOException
    //   362	370	1267	java/io/IOException
    //   797	805	1272	java/io/IOException
    //   810	815	1277	java/io/IOException
    //   820	825	1282	java/io/IOException
    //   877	885	1287	java/io/IOException
    //   890	895	1292	java/io/IOException
    //   900	905	1297	java/io/IOException
    //   1013	1021	1302	java/io/IOException
    //   1026	1031	1307	java/io/IOException
    //   1036	1041	1312	java/io/IOException
    //   445	453	1317	java/io/IOException
    //   458	463	1322	java/io/IOException
    //   1088	1096	1327	java/io/IOException
    //   1101	1106	1332	java/io/IOException
    //   1111	1116	1337	java/io/IOException
    //   1165	1173	1342	java/io/IOException
    //   1178	1183	1347	java/io/IOException
    //   1211	1219	1352	java/io/IOException
    //   1224	1229	1357	java/io/IOException
    //   1234	1239	1362	java/io/IOException
    //   658	687	1367	finally
    //   414	420	1375	finally
    //   428	439	1375	finally
    //   695	702	1375	finally
    //   710	724	1375	finally
    //   732	742	1375	finally
    //   750	756	1375	finally
    //   764	793	1375	finally
    //   835	849	1375	finally
    //   857	868	1375	finally
    //   915	924	1375	finally
    //   932	938	1375	finally
    //   946	973	1375	finally
    //   981	990	1375	finally
    //   998	1009	1375	finally
    //   1059	1065	1375	finally
    //   1073	1084	1375	finally
    //   1134	1140	1375	finally
    //   1148	1159	1375	finally
    //   658	687	1384	java/lang/OutOfMemoryError
    //   695	702	1392	java/lang/OutOfMemoryError
    //   710	724	1392	java/lang/OutOfMemoryError
    //   732	742	1392	java/lang/OutOfMemoryError
    //   750	756	1392	java/lang/OutOfMemoryError
    //   764	793	1392	java/lang/OutOfMemoryError
    //   835	849	1392	java/lang/OutOfMemoryError
    //   857	868	1392	java/lang/OutOfMemoryError
    //   915	924	1392	java/lang/OutOfMemoryError
    //   932	938	1392	java/lang/OutOfMemoryError
    //   946	973	1392	java/lang/OutOfMemoryError
    //   981	990	1392	java/lang/OutOfMemoryError
    //   998	1009	1392	java/lang/OutOfMemoryError
    //   658	687	1397	java/lang/Exception
    //   695	702	1405	java/lang/Exception
    //   710	724	1405	java/lang/Exception
    //   732	742	1405	java/lang/Exception
    //   750	756	1405	java/lang/Exception
    //   764	793	1405	java/lang/Exception
    //   835	849	1405	java/lang/Exception
    //   857	868	1405	java/lang/Exception
    //   915	924	1405	java/lang/Exception
    //   932	938	1405	java/lang/Exception
    //   946	973	1405	java/lang/Exception
    //   981	990	1405	java/lang/Exception
    //   998	1009	1405	java/lang/Exception
    //   658	687	1410	java/io/IOException
    //   695	702	1418	java/io/IOException
    //   710	724	1418	java/io/IOException
    //   732	742	1418	java/io/IOException
    //   750	756	1418	java/io/IOException
    //   764	793	1418	java/io/IOException
    //   835	849	1418	java/io/IOException
    //   857	868	1418	java/io/IOException
    //   915	924	1418	java/io/IOException
    //   932	938	1418	java/io/IOException
    //   946	973	1418	java/io/IOException
    //   981	990	1418	java/io/IOException
    //   998	1009	1418	java/io/IOException
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
    Object localObject1;
    if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.equals(ShortVideoPreviewActivity.class.getName())))
    {
      localIntent.putExtra("file_send_business_type", 2);
      localObject1 = ShortVideoBusiManager.a(0, 2);
      ((ShortVideoReq)localObject1).a(ShortVideoBusiManager.a(2, localIntent, (ShortVideoReq)localObject1));
      ShortVideoBusiManager.a((ShortVideoReq)localObject1, ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).app);
    }
    for (;;)
    {
      if (!this.jdField_a_of_type_Boolean)
      {
        localObject1 = ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getIntent();
        if (((Intent)localObject1).getBooleanExtra("start_init_activity_after_sended", true))
        {
          localObject2 = ((Intent)localObject1).getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
          localIntent.setClassName(((Intent)localObject1).getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME"), (String)localObject2);
          if (QLog.isColorLevel()) {
            QLog.d("SendVideoActivity", 2, "SendVideoTask onPostExecute() INIT_ACTIVITY_CLASS_NAME=" + (String)localObject2);
          }
          localIntent.addFlags(603979776);
          ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).startActivity(localIntent);
        }
        ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).finish();
        ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).overridePendingTransition(0, 2130771982);
      }
      return;
      localIntent.putExtra("file_send_business_type", 0);
      Object localObject2 = ShortVideoBusiManager.a(0, 0);
      localObject1 = ShortVideoBusiManager.a(0, localIntent, (ShortVideoReq)localObject2);
      ((ShortVideoReq)localObject2).a((ShortVideoUploadInfo)localObject1);
      localObject2 = new AioShortVideoOperator(((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).app);
      localObject1 = ((AioShortVideoOperator)localObject2).a((ShortVideoUploadInfo)localObject1);
      if (((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).app != null) {
        ((OrderMediaMsgManager)((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).app.getManager(QQManagerFactory.MEDIA_MSG_ORDER_SEND_MANAGER)).a(((MessageRecord)localObject1).frienduin, ((MessageRecord)localObject1).uniseq);
      }
      ((AioShortVideoOperator)localObject2).a((MessageRecord)localObject1);
    }
  }
  
  void a(Context paramContext, int paramInt)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_AndroidAppProgressDialog == null) {
          break label63;
        }
        b();
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramInt);
        if (this.jdField_a_of_type_AndroidAppProgressDialog.isShowing()) {
          break;
        }
        this.jdField_a_of_type_AndroidAppProgressDialog.show();
        return;
      }
      catch (Throwable paramContext) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("SendVideoActivity", 2, "showProgressDialog", paramContext);
      return;
      label63:
      this.jdField_a_of_type_AndroidAppProgressDialog = new ReportProgressDialog(paramContext, 2131755842);
      this.jdField_a_of_type_AndroidAppProgressDialog.setCancelable(true);
      this.jdField_a_of_type_AndroidAppProgressDialog.show();
      this.jdField_a_of_type_AndroidAppProgressDialog.setContentView(2131559683);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidAppProgressDialog.findViewById(2131373066));
    }
  }
  
  protected void a(Integer paramInteger)
  {
    super.onPostExecute(paramInteger);
    if (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null) {
      return;
    }
    b();
    switch (paramInteger.intValue())
    {
    case 7: 
    case 8: 
    default: 
      return;
    case 1: 
      a();
      return;
    case 2: 
    case 6: 
      a((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 2131719399, this.jdField_a_of_type_Boolean);
      return;
    case 3: 
      a((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 2131719394, this.jdField_a_of_type_Boolean);
      return;
    case 4: 
      a((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 2131719365, this.jdField_a_of_type_Boolean);
      return;
    case 5: 
      a((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 2131719391, this.jdField_a_of_type_Boolean);
      return;
    }
    ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).finish();
  }
  
  void b()
  {
    if (this.jdField_a_of_type_Boolean) {}
    for (;;)
    {
      return;
      try
      {
        if (this.jdField_a_of_type_AndroidAppProgressDialog != null)
        {
          this.jdField_a_of_type_AndroidAppProgressDialog.cancel();
          return;
        }
      }
      catch (Exception localException) {}
    }
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
    a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 2131694889);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.shortvideo.SendVideoActivity.SendVideoTask
 * JD-Core Version:    0.7.0.1
 */