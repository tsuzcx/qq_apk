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
import com.tencent.mobileqq.shortvideo.AioShortVideoOperator;
import com.tencent.mobileqq.shortvideo.ShortVideoBusiManager;
import com.tencent.mobileqq.shortvideo.ShortVideoReq;
import com.tencent.mobileqq.shortvideo.ShortVideoUploadInfo;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import yjj;

public class SendVideoActivity$SendVideoTask
  extends AsyncTask
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  ProgressDialog jdField_a_of_type_AndroidAppProgressDialog;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  String jdField_a_of_type_JavaLangString;
  WeakReference jdField_a_of_type_JavaLangRefWeakReference;
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
      this.jdField_b_of_type_Long = paramIntent.getExtras().getLong("file_send_duration");
      this.jdField_a_of_type_Long = paramIntent.getExtras().getLong("file_send_size");
      this.jdField_c_of_type_JavaLangString = paramIntent.getExtras().getString("uin");
      this.jdField_a_of_type_Int = paramIntent.getIntExtra("uintype", -1);
      this.jdField_d_of_type_JavaLangString = paramIntent.getStringExtra("file_source");
      this.jdField_e_of_type_JavaLangString = paramIntent.getExtras().getString("file_shortvideo_md5");
      this.jdField_a_of_type_JavaLangString = paramIntent.getExtras().getString("activity_before_enter_send_video");
      this.jdField_a_of_type_Boolean = paramIntent.getExtras().getBoolean("send_in_background");
      if (QLog.isColorLevel()) {
        QLog.d("SendVideoActivity", 2, " SendVideoTask(),  mVideoPath :" + this.jdField_b_of_type_JavaLangString + ", mDuration:" + this.jdField_b_of_type_Long + ", mFileSize:" + this.jdField_a_of_type_Long + ",mUin" + this.jdField_c_of_type_JavaLangString + ",mUinType:" + this.jdField_a_of_type_Int + ",mFileSource:" + this.jdField_d_of_type_JavaLangString + ",mSendBackground = " + this.jdField_a_of_type_Boolean);
      }
      return;
      paramIntent = paramBaseActivity;
    }
  }
  
  public static void a(BaseActivity paramBaseActivity, int paramInt, boolean paramBoolean)
  {
    QQCustomDialog localQQCustomDialog = DialogUtil.a(paramBaseActivity, 232, null, paramBaseActivity.getString(paramInt), new yjj(paramBoolean, paramBaseActivity), null);
    if (!paramBaseActivity.isFinishing()) {
      localQQCustomDialog.show();
    }
  }
  
  /* Error */
  int a(Context paramContext)
  {
    // Byte code:
    //   0: iconst_5
    //   1: istore_3
    //   2: aload_1
    //   3: ifnonnull +7 -> 10
    //   6: iload_3
    //   7: istore_2
    //   8: iload_2
    //   9: ireturn
    //   10: invokestatic 182	com/tencent/mobileqq/app/DeviceProfileManager:a	()Lcom/tencent/mobileqq/app/DeviceProfileManager;
    //   13: getstatic 188	com/tencent/mobileqq/app/DeviceProfileManager$DpcNames:lvcc	Lcom/tencent/mobileqq/app/DeviceProfileManager$DpcNames;
    //   16: invokevirtual 191	com/tencent/mobileqq/app/DeviceProfileManager$DpcNames:name	()Ljava/lang/String;
    //   19: ldc 193
    //   21: invokevirtual 196	com/tencent/mobileqq/app/DeviceProfileManager:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   24: astore 7
    //   26: aload 7
    //   28: ifnull +193 -> 221
    //   31: aload 7
    //   33: invokevirtual 202	java/lang/String:length	()I
    //   36: ifle +185 -> 221
    //   39: aload 7
    //   41: ldc 204
    //   43: invokevirtual 208	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   46: astore 7
    //   48: aload 7
    //   50: ifnull +171 -> 221
    //   53: aload 7
    //   55: arraylength
    //   56: istore_2
    //   57: iload_2
    //   58: ifle +163 -> 221
    //   61: aload 7
    //   63: iconst_0
    //   64: aaload
    //   65: invokestatic 214	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   68: invokevirtual 217	java/lang/Integer:intValue	()I
    //   71: istore_2
    //   72: aload_1
    //   73: aload_0
    //   74: getfield 53	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$SendVideoTask:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   77: iload_2
    //   78: invokestatic 222	com/tencent/mobileqq/shortvideo/ShortVideoUtils:a	(Landroid/content/Context;Ljava/lang/String;I)Landroid/graphics/Bitmap;
    //   81: astore 7
    //   83: aload 7
    //   85: astore 8
    //   87: aload 7
    //   89: ifnonnull +30 -> 119
    //   92: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   95: ifeq +11 -> 106
    //   98: ldc 108
    //   100: iconst_2
    //   101: ldc 224
    //   103: invokestatic 226	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   106: aload_0
    //   107: getfield 228	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$SendVideoTask:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   110: ifnull +116 -> 226
    //   113: aload_0
    //   114: getfield 228	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$SendVideoTask:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   117: astore 8
    //   119: aload_0
    //   120: aload 8
    //   122: invokevirtual 233	android/graphics/Bitmap:getWidth	()I
    //   125: putfield 235	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$SendVideoTask:jdField_b_of_type_Int	I
    //   128: aload_0
    //   129: aload 8
    //   131: invokevirtual 238	android/graphics/Bitmap:getHeight	()I
    //   134: putfield 240	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$SendVideoTask:jdField_c_of_type_Int	I
    //   137: aload_0
    //   138: getfield 235	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$SendVideoTask:jdField_b_of_type_Int	I
    //   141: ifeq +10 -> 151
    //   144: aload_0
    //   145: getfield 240	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$SendVideoTask:jdField_c_of_type_Int	I
    //   148: ifne +116 -> 264
    //   151: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   154: ifeq +11 -> 165
    //   157: ldc 108
    //   159: iconst_2
    //   160: ldc 242
    //   162: invokestatic 226	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   165: iconst_0
    //   166: ifeq +11 -> 177
    //   169: new 244	java/lang/NullPointerException
    //   172: dup
    //   173: invokespecial 245	java/lang/NullPointerException:<init>	()V
    //   176: athrow
    //   177: iconst_0
    //   178: ifeq +11 -> 189
    //   181: new 244	java/lang/NullPointerException
    //   184: dup
    //   185: invokespecial 245	java/lang/NullPointerException:<init>	()V
    //   188: athrow
    //   189: iconst_0
    //   190: ifeq +11 -> 201
    //   193: new 244	java/lang/NullPointerException
    //   196: dup
    //   197: invokespecial 245	java/lang/NullPointerException:<init>	()V
    //   200: athrow
    //   201: iconst_2
    //   202: ireturn
    //   203: astore 7
    //   205: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   208: ifeq +13 -> 221
    //   211: ldc 108
    //   213: iconst_2
    //   214: ldc 247
    //   216: aload 7
    //   218: invokestatic 250	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   221: iconst_0
    //   222: istore_2
    //   223: goto -151 -> 72
    //   226: iconst_0
    //   227: ifeq +11 -> 238
    //   230: new 244	java/lang/NullPointerException
    //   233: dup
    //   234: invokespecial 245	java/lang/NullPointerException:<init>	()V
    //   237: athrow
    //   238: iconst_0
    //   239: ifeq +11 -> 250
    //   242: new 244	java/lang/NullPointerException
    //   245: dup
    //   246: invokespecial 245	java/lang/NullPointerException:<init>	()V
    //   249: athrow
    //   250: iconst_0
    //   251: ifeq +11 -> 262
    //   254: new 244	java/lang/NullPointerException
    //   257: dup
    //   258: invokespecial 245	java/lang/NullPointerException:<init>	()V
    //   261: athrow
    //   262: iconst_2
    //   263: ireturn
    //   264: new 110	java/lang/StringBuilder
    //   267: dup
    //   268: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   271: ldc 252
    //   273: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: invokestatic 258	java/lang/System:currentTimeMillis	()J
    //   279: invokevirtual 122	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   282: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   285: ldc_w 260
    //   288: invokestatic 261	com/tencent/mobileqq/shortvideo/ShortVideoUtils:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   291: astore 11
    //   293: new 110	java/lang/StringBuilder
    //   296: dup
    //   297: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   300: invokestatic 263	com/tencent/mobileqq/shortvideo/ShortVideoUtils:a	()Ljava/lang/String;
    //   303: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: ldc_w 265
    //   309: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   312: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   315: invokestatic 270	com/tencent/mobileqq/utils/FileUtils:c	(Ljava/lang/String;)V
    //   318: new 272	java/io/File
    //   321: dup
    //   322: aload 11
    //   324: invokespecial 274	java/io/File:<init>	(Ljava/lang/String;)V
    //   327: astore 12
    //   329: new 272	java/io/File
    //   332: dup
    //   333: aload 12
    //   335: invokevirtual 277	java/io/File:getParent	()Ljava/lang/String;
    //   338: invokespecial 274	java/io/File:<init>	(Ljava/lang/String;)V
    //   341: astore 7
    //   343: aload 7
    //   345: invokevirtual 280	java/io/File:exists	()Z
    //   348: ifeq +11 -> 359
    //   351: aload 7
    //   353: invokevirtual 283	java/io/File:isDirectory	()Z
    //   356: ifne +9 -> 365
    //   359: aload 7
    //   361: invokevirtual 286	java/io/File:mkdirs	()Z
    //   364: pop
    //   365: aload 12
    //   367: invokevirtual 280	java/io/File:exists	()Z
    //   370: ifeq +11 -> 381
    //   373: aload 12
    //   375: invokevirtual 289	java/io/File:isFile	()Z
    //   378: ifne +9 -> 387
    //   381: aload 12
    //   383: invokevirtual 292	java/io/File:createNewFile	()Z
    //   386: pop
    //   387: new 294	java/io/BufferedOutputStream
    //   390: dup
    //   391: new 296	java/io/FileOutputStream
    //   394: dup
    //   395: aload 12
    //   397: invokespecial 299	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   400: invokespecial 302	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   403: astore 7
    //   405: aload 8
    //   407: getstatic 308	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   410: bipush 60
    //   412: aload 7
    //   414: invokevirtual 312	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   417: pop
    //   418: aload 7
    //   420: invokevirtual 315	java/io/BufferedOutputStream:flush	()V
    //   423: new 317	java/io/FileInputStream
    //   426: dup
    //   427: aload 12
    //   429: invokespecial 318	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   432: astore 8
    //   434: aload 7
    //   436: astore 10
    //   438: aload 8
    //   440: astore 9
    //   442: aload 12
    //   444: invokevirtual 320	java/io/File:length	()J
    //   447: lstore 5
    //   449: aload 7
    //   451: astore 10
    //   453: aload 8
    //   455: astore 9
    //   457: aload_0
    //   458: aload 8
    //   460: lload 5
    //   462: invokestatic 326	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   465: invokestatic 332	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   468: putfield 334	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$SendVideoTask:g	Ljava/lang/String;
    //   471: aload 7
    //   473: astore 10
    //   475: aload 8
    //   477: astore 9
    //   479: aload_0
    //   480: getfield 334	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$SendVideoTask:g	Ljava/lang/String;
    //   483: invokestatic 340	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   486: ifeq +93 -> 579
    //   489: aload 7
    //   491: astore 10
    //   493: aload 8
    //   495: astore 9
    //   497: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   500: ifeq +40 -> 540
    //   503: aload 7
    //   505: astore 10
    //   507: aload 8
    //   509: astore 9
    //   511: ldc 108
    //   513: iconst_2
    //   514: new 110	java/lang/StringBuilder
    //   517: dup
    //   518: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   521: ldc_w 342
    //   524: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   527: aload_0
    //   528: getfield 334	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$SendVideoTask:g	Ljava/lang/String;
    //   531: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   534: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   537: invokestatic 226	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   540: iconst_0
    //   541: ifeq +11 -> 552
    //   544: new 244	java/lang/NullPointerException
    //   547: dup
    //   548: invokespecial 245	java/lang/NullPointerException:<init>	()V
    //   551: athrow
    //   552: aload 7
    //   554: ifnull +8 -> 562
    //   557: aload 7
    //   559: invokevirtual 345	java/io/BufferedOutputStream:close	()V
    //   562: iload_3
    //   563: istore_2
    //   564: aload 8
    //   566: ifnull -558 -> 8
    //   569: aload 8
    //   571: invokevirtual 346	java/io/FileInputStream:close	()V
    //   574: iconst_5
    //   575: ireturn
    //   576: astore_1
    //   577: iconst_5
    //   578: ireturn
    //   579: aload 7
    //   581: astore 10
    //   583: aload 8
    //   585: astore 9
    //   587: aload_0
    //   588: aload_0
    //   589: getfield 334	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$SendVideoTask:g	Ljava/lang/String;
    //   592: ldc_w 260
    //   595: invokestatic 261	com/tencent/mobileqq/shortvideo/ShortVideoUtils:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   598: putfield 348	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$SendVideoTask:f	Ljava/lang/String;
    //   601: aload 7
    //   603: astore 10
    //   605: aload 8
    //   607: astore 9
    //   609: aload 11
    //   611: aload_0
    //   612: getfield 348	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$SendVideoTask:f	Ljava/lang/String;
    //   615: invokestatic 351	com/tencent/mobileqq/utils/FileUtils:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   618: istore 4
    //   620: iload 4
    //   622: ifne +42 -> 664
    //   625: iconst_0
    //   626: ifeq +11 -> 637
    //   629: new 244	java/lang/NullPointerException
    //   632: dup
    //   633: invokespecial 245	java/lang/NullPointerException:<init>	()V
    //   636: athrow
    //   637: aload 7
    //   639: ifnull +8 -> 647
    //   642: aload 7
    //   644: invokevirtual 345	java/io/BufferedOutputStream:close	()V
    //   647: iload_3
    //   648: istore_2
    //   649: aload 8
    //   651: ifnull -643 -> 8
    //   654: aload 8
    //   656: invokevirtual 346	java/io/FileInputStream:close	()V
    //   659: iconst_5
    //   660: ireturn
    //   661: astore_1
    //   662: iconst_5
    //   663: ireturn
    //   664: aload 7
    //   666: astore 10
    //   668: aload 8
    //   670: astore 9
    //   672: aload_1
    //   673: lload 5
    //   675: invokestatic 357	android/text/format/Formatter:formatFileSize	(Landroid/content/Context;J)Ljava/lang/String;
    //   678: astore_1
    //   679: aload 7
    //   681: astore 10
    //   683: aload 8
    //   685: astore 9
    //   687: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   690: ifeq +37 -> 727
    //   693: aload 7
    //   695: astore 10
    //   697: aload 8
    //   699: astore 9
    //   701: ldc 108
    //   703: iconst_2
    //   704: new 110	java/lang/StringBuilder
    //   707: dup
    //   708: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   711: ldc_w 359
    //   714: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   717: aload_1
    //   718: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   721: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   724: invokestatic 226	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   727: aload 7
    //   729: astore 10
    //   731: aload 8
    //   733: astore 9
    //   735: aload_0
    //   736: getfield 61	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$SendVideoTask:jdField_b_of_type_Long	J
    //   739: lconst_0
    //   740: lcmp
    //   741: ifne +22 -> 763
    //   744: aload 7
    //   746: astore 10
    //   748: aload 8
    //   750: astore 9
    //   752: aload_0
    //   753: aload_0
    //   754: getfield 53	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$SendVideoTask:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   757: invokestatic 361	com/tencent/mobileqq/shortvideo/ShortVideoUtils:a	(Ljava/lang/String;)J
    //   760: putfield 61	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$SendVideoTask:jdField_b_of_type_Long	J
    //   763: iconst_0
    //   764: ifeq +11 -> 775
    //   767: new 244	java/lang/NullPointerException
    //   770: dup
    //   771: invokespecial 245	java/lang/NullPointerException:<init>	()V
    //   774: athrow
    //   775: aload 7
    //   777: ifnull +8 -> 785
    //   780: aload 7
    //   782: invokevirtual 345	java/io/BufferedOutputStream:close	()V
    //   785: aload 8
    //   787: ifnull +8 -> 795
    //   790: aload 8
    //   792: invokevirtual 346	java/io/FileInputStream:close	()V
    //   795: iconst_1
    //   796: ireturn
    //   797: astore_1
    //   798: aconst_null
    //   799: astore 7
    //   801: aconst_null
    //   802: astore 8
    //   804: aload 7
    //   806: astore 10
    //   808: aload 8
    //   810: astore 9
    //   812: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   815: ifeq +21 -> 836
    //   818: aload 7
    //   820: astore 10
    //   822: aload 8
    //   824: astore 9
    //   826: ldc 108
    //   828: iconst_2
    //   829: ldc_w 363
    //   832: aload_1
    //   833: invokestatic 250	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   836: iconst_3
    //   837: istore_2
    //   838: iconst_0
    //   839: ifeq +11 -> 850
    //   842: new 244	java/lang/NullPointerException
    //   845: dup
    //   846: invokespecial 245	java/lang/NullPointerException:<init>	()V
    //   849: athrow
    //   850: aload 7
    //   852: ifnull +8 -> 860
    //   855: aload 7
    //   857: invokevirtual 345	java/io/BufferedOutputStream:close	()V
    //   860: aload 8
    //   862: ifnull -854 -> 8
    //   865: aload 8
    //   867: invokevirtual 346	java/io/FileInputStream:close	()V
    //   870: iconst_3
    //   871: ireturn
    //   872: astore_1
    //   873: iconst_3
    //   874: ireturn
    //   875: astore 8
    //   877: aconst_null
    //   878: astore 7
    //   880: aconst_null
    //   881: astore_1
    //   882: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   885: ifeq +14 -> 899
    //   888: ldc 108
    //   890: iconst_2
    //   891: ldc_w 363
    //   894: aload 8
    //   896: invokestatic 250	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   899: iconst_0
    //   900: ifeq +11 -> 911
    //   903: new 244	java/lang/NullPointerException
    //   906: dup
    //   907: invokespecial 245	java/lang/NullPointerException:<init>	()V
    //   910: athrow
    //   911: aload 7
    //   913: ifnull +8 -> 921
    //   916: aload 7
    //   918: invokevirtual 345	java/io/BufferedOutputStream:close	()V
    //   921: iload_3
    //   922: istore_2
    //   923: aload_1
    //   924: ifnull -916 -> 8
    //   927: aload_1
    //   928: invokevirtual 346	java/io/FileInputStream:close	()V
    //   931: iconst_5
    //   932: ireturn
    //   933: astore_1
    //   934: iconst_5
    //   935: ireturn
    //   936: astore_1
    //   937: aconst_null
    //   938: astore 7
    //   940: aconst_null
    //   941: astore 8
    //   943: aload 7
    //   945: astore 10
    //   947: aload 8
    //   949: astore 9
    //   951: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   954: ifeq +21 -> 975
    //   957: aload 7
    //   959: astore 10
    //   961: aload 8
    //   963: astore 9
    //   965: ldc 108
    //   967: iconst_2
    //   968: ldc_w 365
    //   971: aload_1
    //   972: invokestatic 250	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   975: iconst_4
    //   976: istore_2
    //   977: iconst_0
    //   978: ifeq +11 -> 989
    //   981: new 244	java/lang/NullPointerException
    //   984: dup
    //   985: invokespecial 245	java/lang/NullPointerException:<init>	()V
    //   988: athrow
    //   989: aload 7
    //   991: ifnull +8 -> 999
    //   994: aload 7
    //   996: invokevirtual 345	java/io/BufferedOutputStream:close	()V
    //   999: aload 8
    //   1001: ifnull -993 -> 8
    //   1004: aload 8
    //   1006: invokevirtual 346	java/io/FileInputStream:close	()V
    //   1009: iconst_4
    //   1010: ireturn
    //   1011: astore_1
    //   1012: iconst_4
    //   1013: ireturn
    //   1014: astore_1
    //   1015: aconst_null
    //   1016: astore 7
    //   1018: aconst_null
    //   1019: astore 9
    //   1021: iconst_0
    //   1022: ifeq +11 -> 1033
    //   1025: new 244	java/lang/NullPointerException
    //   1028: dup
    //   1029: invokespecial 245	java/lang/NullPointerException:<init>	()V
    //   1032: athrow
    //   1033: aload 7
    //   1035: ifnull +8 -> 1043
    //   1038: aload 7
    //   1040: invokevirtual 345	java/io/BufferedOutputStream:close	()V
    //   1043: aload 9
    //   1045: ifnull +8 -> 1053
    //   1048: aload 9
    //   1050: invokevirtual 346	java/io/FileInputStream:close	()V
    //   1053: aload_1
    //   1054: athrow
    //   1055: astore_1
    //   1056: goto -818 -> 238
    //   1059: astore_1
    //   1060: goto -810 -> 250
    //   1063: astore_1
    //   1064: goto -802 -> 262
    //   1067: astore_1
    //   1068: goto -891 -> 177
    //   1071: astore_1
    //   1072: goto -883 -> 189
    //   1075: astore_1
    //   1076: goto -875 -> 201
    //   1079: astore_1
    //   1080: goto -528 -> 552
    //   1083: astore_1
    //   1084: goto -522 -> 562
    //   1087: astore_1
    //   1088: goto -451 -> 637
    //   1091: astore_1
    //   1092: goto -445 -> 647
    //   1095: astore_1
    //   1096: goto -321 -> 775
    //   1099: astore_1
    //   1100: goto -315 -> 785
    //   1103: astore_1
    //   1104: goto -309 -> 795
    //   1107: astore_1
    //   1108: goto -258 -> 850
    //   1111: astore_1
    //   1112: goto -252 -> 860
    //   1115: astore 8
    //   1117: goto -206 -> 911
    //   1120: astore 7
    //   1122: goto -201 -> 921
    //   1125: astore_1
    //   1126: goto -137 -> 989
    //   1129: astore_1
    //   1130: goto -131 -> 999
    //   1133: astore 8
    //   1135: goto -102 -> 1033
    //   1138: astore 7
    //   1140: goto -97 -> 1043
    //   1143: astore 7
    //   1145: goto -92 -> 1053
    //   1148: astore_1
    //   1149: aconst_null
    //   1150: astore 9
    //   1152: goto -131 -> 1021
    //   1155: astore_1
    //   1156: aload 10
    //   1158: astore 7
    //   1160: goto -139 -> 1021
    //   1163: astore 8
    //   1165: aload_1
    //   1166: astore 9
    //   1168: aload 8
    //   1170: astore_1
    //   1171: goto -150 -> 1021
    //   1174: astore_1
    //   1175: aconst_null
    //   1176: astore 8
    //   1178: goto -235 -> 943
    //   1181: astore_1
    //   1182: goto -239 -> 943
    //   1185: astore 8
    //   1187: aconst_null
    //   1188: astore_1
    //   1189: goto -307 -> 882
    //   1192: astore 9
    //   1194: aload 8
    //   1196: astore_1
    //   1197: aload 9
    //   1199: astore 8
    //   1201: goto -319 -> 882
    //   1204: astore_1
    //   1205: aconst_null
    //   1206: astore 8
    //   1208: goto -404 -> 804
    //   1211: astore_1
    //   1212: goto -408 -> 804
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1215	0	this	SendVideoTask
    //   0	1215	1	paramContext	Context
    //   7	970	2	i	int
    //   1	921	3	j	int
    //   618	3	4	bool	boolean
    //   447	227	5	l	long
    //   24	64	7	localObject1	Object
    //   203	14	7	localNumberFormatException	java.lang.NumberFormatException
    //   341	698	7	localObject2	Object
    //   1120	1	7	localIOException1	java.io.IOException
    //   1138	1	7	localIOException2	java.io.IOException
    //   1143	1	7	localIOException3	java.io.IOException
    //   1158	1	7	localObject3	Object
    //   85	781	8	localObject4	Object
    //   875	20	8	localException1	Exception
    //   941	64	8	localObject5	Object
    //   1115	1	8	localIOException4	java.io.IOException
    //   1133	1	8	localIOException5	java.io.IOException
    //   1163	6	8	localObject6	Object
    //   1176	1	8	localObject7	Object
    //   1185	10	8	localException2	Exception
    //   1199	8	8	localObject8	Object
    //   440	727	9	localObject9	Object
    //   1192	6	9	localException3	Exception
    //   436	721	10	localObject10	Object
    //   291	319	11	str	String
    //   327	116	12	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   61	72	203	java/lang/NumberFormatException
    //   569	574	576	java/io/IOException
    //   654	659	661	java/io/IOException
    //   10	26	797	java/io/IOException
    //   31	48	797	java/io/IOException
    //   53	57	797	java/io/IOException
    //   61	72	797	java/io/IOException
    //   72	83	797	java/io/IOException
    //   92	106	797	java/io/IOException
    //   106	119	797	java/io/IOException
    //   119	151	797	java/io/IOException
    //   151	165	797	java/io/IOException
    //   205	221	797	java/io/IOException
    //   264	359	797	java/io/IOException
    //   359	365	797	java/io/IOException
    //   365	381	797	java/io/IOException
    //   381	387	797	java/io/IOException
    //   387	405	797	java/io/IOException
    //   865	870	872	java/io/IOException
    //   10	26	875	java/lang/Exception
    //   31	48	875	java/lang/Exception
    //   53	57	875	java/lang/Exception
    //   61	72	875	java/lang/Exception
    //   72	83	875	java/lang/Exception
    //   92	106	875	java/lang/Exception
    //   106	119	875	java/lang/Exception
    //   119	151	875	java/lang/Exception
    //   151	165	875	java/lang/Exception
    //   205	221	875	java/lang/Exception
    //   264	359	875	java/lang/Exception
    //   359	365	875	java/lang/Exception
    //   365	381	875	java/lang/Exception
    //   381	387	875	java/lang/Exception
    //   387	405	875	java/lang/Exception
    //   927	931	933	java/io/IOException
    //   10	26	936	java/lang/OutOfMemoryError
    //   31	48	936	java/lang/OutOfMemoryError
    //   53	57	936	java/lang/OutOfMemoryError
    //   61	72	936	java/lang/OutOfMemoryError
    //   72	83	936	java/lang/OutOfMemoryError
    //   92	106	936	java/lang/OutOfMemoryError
    //   106	119	936	java/lang/OutOfMemoryError
    //   119	151	936	java/lang/OutOfMemoryError
    //   151	165	936	java/lang/OutOfMemoryError
    //   205	221	936	java/lang/OutOfMemoryError
    //   264	359	936	java/lang/OutOfMemoryError
    //   359	365	936	java/lang/OutOfMemoryError
    //   365	381	936	java/lang/OutOfMemoryError
    //   381	387	936	java/lang/OutOfMemoryError
    //   387	405	936	java/lang/OutOfMemoryError
    //   1004	1009	1011	java/io/IOException
    //   10	26	1014	finally
    //   31	48	1014	finally
    //   53	57	1014	finally
    //   61	72	1014	finally
    //   72	83	1014	finally
    //   92	106	1014	finally
    //   106	119	1014	finally
    //   119	151	1014	finally
    //   151	165	1014	finally
    //   205	221	1014	finally
    //   264	359	1014	finally
    //   359	365	1014	finally
    //   365	381	1014	finally
    //   381	387	1014	finally
    //   387	405	1014	finally
    //   230	238	1055	java/io/IOException
    //   242	250	1059	java/io/IOException
    //   254	262	1063	java/io/IOException
    //   169	177	1067	java/io/IOException
    //   181	189	1071	java/io/IOException
    //   193	201	1075	java/io/IOException
    //   544	552	1079	java/io/IOException
    //   557	562	1083	java/io/IOException
    //   629	637	1087	java/io/IOException
    //   642	647	1091	java/io/IOException
    //   767	775	1095	java/io/IOException
    //   780	785	1099	java/io/IOException
    //   790	795	1103	java/io/IOException
    //   842	850	1107	java/io/IOException
    //   855	860	1111	java/io/IOException
    //   903	911	1115	java/io/IOException
    //   916	921	1120	java/io/IOException
    //   981	989	1125	java/io/IOException
    //   994	999	1129	java/io/IOException
    //   1025	1033	1133	java/io/IOException
    //   1038	1043	1138	java/io/IOException
    //   1048	1053	1143	java/io/IOException
    //   405	434	1148	finally
    //   442	449	1155	finally
    //   457	471	1155	finally
    //   479	489	1155	finally
    //   497	503	1155	finally
    //   511	540	1155	finally
    //   587	601	1155	finally
    //   609	620	1155	finally
    //   672	679	1155	finally
    //   687	693	1155	finally
    //   701	727	1155	finally
    //   735	744	1155	finally
    //   752	763	1155	finally
    //   812	818	1155	finally
    //   826	836	1155	finally
    //   951	957	1155	finally
    //   965	975	1155	finally
    //   882	899	1163	finally
    //   405	434	1174	java/lang/OutOfMemoryError
    //   442	449	1181	java/lang/OutOfMemoryError
    //   457	471	1181	java/lang/OutOfMemoryError
    //   479	489	1181	java/lang/OutOfMemoryError
    //   497	503	1181	java/lang/OutOfMemoryError
    //   511	540	1181	java/lang/OutOfMemoryError
    //   587	601	1181	java/lang/OutOfMemoryError
    //   609	620	1181	java/lang/OutOfMemoryError
    //   672	679	1181	java/lang/OutOfMemoryError
    //   687	693	1181	java/lang/OutOfMemoryError
    //   701	727	1181	java/lang/OutOfMemoryError
    //   735	744	1181	java/lang/OutOfMemoryError
    //   752	763	1181	java/lang/OutOfMemoryError
    //   405	434	1185	java/lang/Exception
    //   442	449	1192	java/lang/Exception
    //   457	471	1192	java/lang/Exception
    //   479	489	1192	java/lang/Exception
    //   497	503	1192	java/lang/Exception
    //   511	540	1192	java/lang/Exception
    //   587	601	1192	java/lang/Exception
    //   609	620	1192	java/lang/Exception
    //   672	679	1192	java/lang/Exception
    //   687	693	1192	java/lang/Exception
    //   701	727	1192	java/lang/Exception
    //   735	744	1192	java/lang/Exception
    //   752	763	1192	java/lang/Exception
    //   405	434	1204	java/io/IOException
    //   442	449	1211	java/io/IOException
    //   457	471	1211	java/io/IOException
    //   479	489	1211	java/io/IOException
    //   497	503	1211	java/io/IOException
    //   511	540	1211	java/io/IOException
    //   587	601	1211	java/io/IOException
    //   609	620	1211	java/io/IOException
    //   672	679	1211	java/io/IOException
    //   687	693	1211	java/io/IOException
    //   701	727	1211	java/io/IOException
    //   735	744	1211	java/io/IOException
    //   752	763	1211	java/io/IOException
  }
  
  protected Integer a(Void... paramVarArgs)
  {
    return Integer.valueOf(a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()));
  }
  
  void a()
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
        a();
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
      this.jdField_a_of_type_AndroidAppProgressDialog = new ProgressDialog(paramContext, 2131624516);
      this.jdField_a_of_type_AndroidAppProgressDialog.setCancelable(true);
      this.jdField_a_of_type_AndroidAppProgressDialog.show();
      this.jdField_a_of_type_AndroidAppProgressDialog.setContentView(2130969178);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidAppProgressDialog.findViewById(2131363418));
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
      paramInteger.putExtra("file_source", this.jdField_d_of_type_JavaLangString);
      paramInteger.putExtra("thumbfile_send_path", this.f);
      paramInteger.putExtra("file_shortvideo_md5", this.jdField_e_of_type_JavaLangString);
      paramInteger.putExtra("thumbfile_send_width", this.jdField_b_of_type_Int);
      paramInteger.putExtra("thumbfile_send_height", this.jdField_c_of_type_Int);
      paramInteger.putExtra("thumbfile_md5", this.g);
      paramInteger.putExtra("file_width", this.jdField_d_of_type_Int);
      paramInteger.putExtra("file_height", this.jdField_e_of_type_Int);
      Object localObject1;
      if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.equals(ShortVideoPreviewActivity.class.getName())))
      {
        paramInteger.putExtra("file_send_business_type", 2);
        localObject1 = ShortVideoBusiManager.a(0, 2);
        ((ShortVideoReq)localObject1).a(ShortVideoBusiManager.a(2, paramInteger, (ShortVideoReq)localObject1));
        ShortVideoBusiManager.a((ShortVideoReq)localObject1, ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).app);
      }
      while (!this.jdField_a_of_type_Boolean)
      {
        localObject1 = ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getIntent();
        if (((Intent)localObject1).getBooleanExtra("start_init_activity_after_sended", true))
        {
          localObject2 = ((Intent)localObject1).getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
          paramInteger.setClassName(((Intent)localObject1).getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME"), (String)localObject2);
          if (QLog.isColorLevel()) {
            QLog.d("SendVideoActivity", 2, "SendVideoTask onPostExecute() INIT_ACTIVITY_CLASS_NAME=" + (String)localObject2);
          }
          paramInteger.addFlags(603979776);
          ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).startActivity(paramInteger);
        }
        ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).finish();
        ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).overridePendingTransition(0, 2131034124);
        return;
        paramInteger.putExtra("file_send_business_type", 0);
        Object localObject2 = ShortVideoBusiManager.a(0, 0);
        localObject1 = ShortVideoBusiManager.a(0, paramInteger, (ShortVideoReq)localObject2);
        ((ShortVideoReq)localObject2).a((ShortVideoUploadInfo)localObject1);
        localObject2 = new AioShortVideoOperator(((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).app);
        ((AioShortVideoOperator)localObject2).a(((AioShortVideoOperator)localObject2).a((ShortVideoUploadInfo)localObject1));
      }
    case 2: 
    case 6: 
      a((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 2131437386, this.jdField_a_of_type_Boolean);
      return;
    case 3: 
      a((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 2131437393, this.jdField_a_of_type_Boolean);
      return;
    case 4: 
      a((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 2131437391, this.jdField_a_of_type_Boolean);
      return;
    }
    a((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 2131437394, this.jdField_a_of_type_Boolean);
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
    a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 2131436163);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.shortvideo.SendVideoActivity.SendVideoTask
 * JD-Core Version:    0.7.0.1
 */