package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.v4.util.MQLruCache;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.biz.qrcode.activity.ScannerUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gamecenter.common.util.GCCommon;
import com.tencent.mobileqq.apollo.api.handler.IApolloExtensionHandler;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.message.messageclean.FileCleanUtils;
import com.tencent.mobileqq.app.message.messageclean.IScanSpaceListener;
import com.tencent.mobileqq.app.message.messageclean.ScanSpaceManager;
import com.tencent.mobileqq.hotpic.HotPicDownLoader;
import com.tencent.mobileqq.hotpic.HotVideoPreviewDownloader;
import com.tencent.mobileqq.scribble.ScribbleMsgUtils;
import com.tencent.mobileqq.servlet.QZoneManagerImp;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.JumpQqPimSecureUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.VersionUtils;
import dov.com.qq.im.QIMShortVideoUtils;
import java.io.File;
import java.util.Vector;

public class QQSettingMsgHistoryActivity
  extends IphoneTitleBarActivity
  implements ViewTreeObserver.OnGlobalLayoutListener, IScanSpaceListener
{
  private static volatile ScanSpaceManager jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanScanSpaceManager;
  static final String jdField_a_of_type_JavaLangString = BaseApplication.getContext().getFilesDir() + File.separator + "ChatHistoryEventConfig.json";
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private View jdField_a_of_type_AndroidViewView;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private BounceScrollView jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView;
  QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  boolean jdField_a_of_type_Boolean = true;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long = 0L;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString = "";
  private int jdField_c_of_type_Int;
  private View jdField_c_of_type_AndroidViewView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private String jdField_c_of_type_JavaLangString;
  private int jdField_d_of_type_Int;
  private View jdField_d_of_type_AndroidViewView;
  private View e;
  private View f;
  private View g;
  private View h;
  private View i;
  
  public static void a()
  {
    if (jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanScanSpaceManager != null)
    {
      jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanScanSpaceManager.b();
      jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanScanSpaceManager = null;
    }
  }
  
  private void a(long paramLong)
  {
    this.jdField_a_of_type_Long -= paramLong;
    String str = FileCleanUtils.a(this.jdField_a_of_type_Long);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(str);
  }
  
  /* Error */
  public static void a(android.app.Activity paramActivity, QQAppInterface paramQQAppInterface)
  {
    // Byte code:
    //   0: new 101	android/content/Intent
    //   3: dup
    //   4: ldc 103
    //   6: invokespecial 106	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   9: astore_2
    //   10: aload_2
    //   11: ldc 108
    //   13: iconst_1
    //   14: invokevirtual 112	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   17: pop
    //   18: aload_1
    //   19: invokevirtual 118	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   22: invokevirtual 124	mqq/app/MobileQQ:getApplicationContext	()Landroid/content/Context;
    //   25: aload_2
    //   26: invokevirtual 130	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
    //   29: aload_1
    //   30: iconst_0
    //   31: invokestatic 136	cooperation/qzone/QZoneHelper:clearCache	(Lmqq/app/AppRuntime;Z)V
    //   34: aload_1
    //   35: invokestatic 139	com/tencent/mobileqq/activity/QQSettingMsgHistoryActivity:c	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   38: aload_1
    //   39: invokevirtual 142	com/tencent/mobileqq/app/QQAppInterface:getCurrentUin	()Ljava/lang/String;
    //   42: iconst_0
    //   43: invokestatic 145	com/tencent/mobileqq/activity/QQSettingMsgHistoryActivity:a	(Ljava/lang/String;Z)V
    //   46: aload_1
    //   47: invokestatic 147	com/tencent/mobileqq/activity/QQSettingMsgHistoryActivity:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   50: invokestatic 149	com/tencent/mobileqq/activity/QQSettingMsgHistoryActivity:c	()V
    //   53: aload_1
    //   54: invokestatic 151	com/tencent/mobileqq/activity/QQSettingMsgHistoryActivity:b	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   57: invokestatic 155	com/tencent/mobileqq/utils/MusicCacheManager:a	()V
    //   60: invokestatic 158	com/tencent/mobileqq/ark/ArkAppCenter:b	()V
    //   63: invokestatic 161	com/tencent/mobileqq/listentogether/predownload/ListenTogetherResDownloader:b	()V
    //   66: aload_0
    //   67: ifnull +12 -> 79
    //   70: aload_0
    //   71: aload_1
    //   72: invokevirtual 164	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   75: invokestatic 169	cooperation/qqfav/QfavHelper:a	(Landroid/app/Activity;Ljava/lang/String;)Z
    //   78: pop
    //   79: ldc 171
    //   81: invokestatic 177	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   84: checkcast 171	com/tencent/biz/pubaccount/api/IPublicAccountJavascriptInterface
    //   87: aload_1
    //   88: invokeinterface 181 2 0
    //   93: new 50	java/io/File
    //   96: dup
    //   97: new 31	java/lang/StringBuilder
    //   100: dup
    //   101: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   104: ldc 171
    //   106: invokestatic 177	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   109: checkcast 171	com/tencent/biz/pubaccount/api/IPublicAccountJavascriptInterface
    //   112: invokeinterface 184 1 0
    //   117: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: ldc 186
    //   122: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: aload_1
    //   126: invokevirtual 189	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   129: invokestatic 195	com/tencent/mobileqq/utils/HexUtil:String2HexString	(Ljava/lang/String;)Ljava/lang/String;
    //   132: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   138: invokespecial 196	java/io/File:<init>	(Ljava/lang/String;)V
    //   141: invokestatic 201	com/dataline/util/file/FileUtil:a	(Ljava/io/File;)V
    //   144: invokestatic 205	com/tencent/biz/common/offline/OfflineEnvHelper:b	()Ljava/lang/String;
    //   147: astore_0
    //   148: aload_0
    //   149: ifnull +14 -> 163
    //   152: new 50	java/io/File
    //   155: dup
    //   156: aload_0
    //   157: invokespecial 196	java/io/File:<init>	(Ljava/lang/String;)V
    //   160: invokestatic 201	com/dataline/util/file/FileUtil:a	(Ljava/io/File;)V
    //   163: invokestatic 207	com/tencent/biz/common/offline/OfflineEnvHelper:d	()Ljava/lang/String;
    //   166: astore_0
    //   167: aload_0
    //   168: ifnull +14 -> 182
    //   171: new 50	java/io/File
    //   174: dup
    //   175: aload_0
    //   176: invokespecial 196	java/io/File:<init>	(Ljava/lang/String;)V
    //   179: invokestatic 201	com/dataline/util/file/FileUtil:a	(Ljava/io/File;)V
    //   182: invokestatic 209	com/tencent/biz/common/offline/OfflineEnvHelper:a	()Ljava/lang/String;
    //   185: astore_0
    //   186: aload_0
    //   187: ifnull +14 -> 201
    //   190: new 50	java/io/File
    //   193: dup
    //   194: aload_0
    //   195: invokespecial 196	java/io/File:<init>	(Ljava/lang/String;)V
    //   198: invokestatic 201	com/dataline/util/file/FileUtil:a	(Ljava/io/File;)V
    //   201: invokestatic 211	com/tencent/biz/common/offline/OfflineEnvHelper:c	()Ljava/lang/String;
    //   204: astore_0
    //   205: aload_0
    //   206: ifnull +14 -> 220
    //   209: new 50	java/io/File
    //   212: dup
    //   213: aload_0
    //   214: invokespecial 196	java/io/File:<init>	(Ljava/lang/String;)V
    //   217: invokestatic 201	com/dataline/util/file/FileUtil:a	(Ljava/io/File;)V
    //   220: new 50	java/io/File
    //   223: dup
    //   224: new 31	java/lang/StringBuilder
    //   227: dup
    //   228: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   231: invokestatic 216	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   234: invokevirtual 219	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   237: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: ldc 221
    //   242: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   248: invokespecial 196	java/io/File:<init>	(Ljava/lang/String;)V
    //   251: invokestatic 201	com/dataline/util/file/FileUtil:a	(Ljava/io/File;)V
    //   254: new 50	java/io/File
    //   257: dup
    //   258: invokestatic 224	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   261: invokevirtual 44	com/tencent/qphone/base/util/BaseApplication:getFilesDir	()Ljava/io/File;
    //   264: ldc 226
    //   266: invokespecial 229	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   269: invokestatic 201	com/dataline/util/file/FileUtil:a	(Ljava/io/File;)V
    //   272: new 50	java/io/File
    //   275: dup
    //   276: invokestatic 224	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   279: invokevirtual 44	com/tencent/qphone/base/util/BaseApplication:getFilesDir	()Ljava/io/File;
    //   282: ldc 231
    //   284: invokespecial 229	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   287: invokestatic 201	com/dataline/util/file/FileUtil:a	(Ljava/io/File;)V
    //   290: aload_1
    //   291: invokevirtual 118	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   294: ldc 233
    //   296: iconst_4
    //   297: invokevirtual 237	mqq/app/MobileQQ:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   300: invokeinterface 243 1 0
    //   305: invokeinterface 248 1 0
    //   310: invokeinterface 252 1 0
    //   315: pop
    //   316: aload_1
    //   317: invokevirtual 118	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   320: ldc 254
    //   322: iconst_4
    //   323: invokevirtual 237	mqq/app/MobileQQ:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   326: invokeinterface 243 1 0
    //   331: invokeinterface 248 1 0
    //   336: invokeinterface 252 1 0
    //   341: pop
    //   342: new 50	java/io/File
    //   345: dup
    //   346: getstatic 259	com/tencent/mobileqq/app/AppConstants:SDCARD_GIFT_SAVE	Ljava/lang/String;
    //   349: invokespecial 196	java/io/File:<init>	(Ljava/lang/String;)V
    //   352: invokestatic 201	com/dataline/util/file/FileUtil:a	(Ljava/io/File;)V
    //   355: invokestatic 264	com/tencent/smtt/sdk/CacheManager:getCacheFileBaseDir	()Ljava/io/File;
    //   358: astore_0
    //   359: aload_0
    //   360: ifnull +7 -> 367
    //   363: aload_0
    //   364: invokestatic 201	com/dataline/util/file/FileUtil:a	(Ljava/io/File;)V
    //   367: invokestatic 269	com/tencent/mobileqq/shortvideo/ShortVideoUtils:deleteDownloadTempFile	()V
    //   370: new 50	java/io/File
    //   373: dup
    //   374: getstatic 272	com/tencent/mobileqq/app/AppConstants:SDCARD_NEARBY_FLOWER	Ljava/lang/String;
    //   377: invokespecial 196	java/io/File:<init>	(Ljava/lang/String;)V
    //   380: astore_0
    //   381: aload_0
    //   382: invokevirtual 275	java/io/File:exists	()Z
    //   385: ifeq +7 -> 392
    //   388: aload_0
    //   389: invokestatic 201	com/dataline/util/file/FileUtil:a	(Ljava/io/File;)V
    //   392: aload_0
    //   393: invokevirtual 275	java/io/File:exists	()Z
    //   396: ifne +8 -> 404
    //   399: aload_0
    //   400: invokevirtual 278	java/io/File:mkdirs	()Z
    //   403: pop
    //   404: new 50	java/io/File
    //   407: dup
    //   408: getstatic 281	com/tencent/mobileqq/app/AppConstants:SDCARD_HOMEWORK_ATTACH	Ljava/lang/String;
    //   411: invokespecial 196	java/io/File:<init>	(Ljava/lang/String;)V
    //   414: astore_0
    //   415: aload_0
    //   416: invokevirtual 275	java/io/File:exists	()Z
    //   419: ifeq +7 -> 426
    //   422: aload_0
    //   423: invokestatic 201	com/dataline/util/file/FileUtil:a	(Ljava/io/File;)V
    //   426: new 50	java/io/File
    //   429: dup
    //   430: getstatic 284	com/tencent/mobileqq/app/AppConstants:SDCARD_TROOP_REWARD	Ljava/lang/String;
    //   433: invokespecial 196	java/io/File:<init>	(Ljava/lang/String;)V
    //   436: astore_0
    //   437: aload_0
    //   438: invokevirtual 275	java/io/File:exists	()Z
    //   441: ifeq +7 -> 448
    //   444: aload_0
    //   445: invokestatic 201	com/dataline/util/file/FileUtil:a	(Ljava/io/File;)V
    //   448: new 50	java/io/File
    //   451: dup
    //   452: getstatic 287	com/tencent/mobileqq/app/AppConstants:SDCARD_PATH_PUBLIC_ACCOUNT_PRELOAD	Ljava/lang/String;
    //   455: invokespecial 196	java/io/File:<init>	(Ljava/lang/String;)V
    //   458: astore_0
    //   459: aload_0
    //   460: invokevirtual 275	java/io/File:exists	()Z
    //   463: ifeq +7 -> 470
    //   466: aload_0
    //   467: invokestatic 201	com/dataline/util/file/FileUtil:a	(Ljava/io/File;)V
    //   470: new 50	java/io/File
    //   473: dup
    //   474: getstatic 290	com/tencent/mobileqq/app/AppConstants:SDCARD_PATH_READINJOY_TEMPLATE_VIDEO_PATH	Ljava/lang/String;
    //   477: invokespecial 196	java/io/File:<init>	(Ljava/lang/String;)V
    //   480: astore_0
    //   481: aload_0
    //   482: invokevirtual 275	java/io/File:exists	()Z
    //   485: ifeq +7 -> 492
    //   488: aload_0
    //   489: invokestatic 201	com/dataline/util/file/FileUtil:a	(Ljava/io/File;)V
    //   492: new 50	java/io/File
    //   495: dup
    //   496: new 31	java/lang/StringBuilder
    //   499: dup
    //   500: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   503: getstatic 293	com/tencent/mobileqq/app/AppConstants:SDCARD_PATH	Ljava/lang/String;
    //   506: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   509: ldc_w 295
    //   512: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   515: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   518: invokespecial 196	java/io/File:<init>	(Ljava/lang/String;)V
    //   521: astore_0
    //   522: aload_0
    //   523: invokevirtual 275	java/io/File:exists	()Z
    //   526: ifeq +7 -> 533
    //   529: aload_0
    //   530: invokestatic 201	com/dataline/util/file/FileUtil:a	(Ljava/io/File;)V
    //   533: new 50	java/io/File
    //   536: dup
    //   537: getstatic 298	com/tencent/mobileqq/app/AppConstants:SDCARD_AR_IMG	Ljava/lang/String;
    //   540: invokespecial 196	java/io/File:<init>	(Ljava/lang/String;)V
    //   543: astore_0
    //   544: aload_0
    //   545: invokevirtual 275	java/io/File:exists	()Z
    //   548: ifeq +7 -> 555
    //   551: aload_0
    //   552: invokestatic 201	com/dataline/util/file/FileUtil:a	(Ljava/io/File;)V
    //   555: new 50	java/io/File
    //   558: dup
    //   559: getstatic 301	com/tencent/mobileqq/app/AppConstants:SDCARD_AR_FEATURE	Ljava/lang/String;
    //   562: invokespecial 196	java/io/File:<init>	(Ljava/lang/String;)V
    //   565: astore_0
    //   566: aload_0
    //   567: invokevirtual 275	java/io/File:exists	()Z
    //   570: ifeq +7 -> 577
    //   573: aload_0
    //   574: invokestatic 201	com/dataline/util/file/FileUtil:a	(Ljava/io/File;)V
    //   577: new 50	java/io/File
    //   580: dup
    //   581: getstatic 304	com/tencent/mobileqq/app/AppConstants:SDCARD_AR_CONFIG	Ljava/lang/String;
    //   584: invokespecial 196	java/io/File:<init>	(Ljava/lang/String;)V
    //   587: astore_0
    //   588: aload_0
    //   589: invokevirtual 275	java/io/File:exists	()Z
    //   592: ifeq +7 -> 599
    //   595: aload_0
    //   596: invokestatic 201	com/dataline/util/file/FileUtil:a	(Ljava/io/File;)V
    //   599: new 50	java/io/File
    //   602: dup
    //   603: getstatic 307	com/tencent/mobileqq/app/AppConstants:SDCARD_AR_MODEL	Ljava/lang/String;
    //   606: invokespecial 196	java/io/File:<init>	(Ljava/lang/String;)V
    //   609: astore_0
    //   610: aload_0
    //   611: invokevirtual 275	java/io/File:exists	()Z
    //   614: ifeq +7 -> 621
    //   617: aload_0
    //   618: invokestatic 201	com/dataline/util/file/FileUtil:a	(Ljava/io/File;)V
    //   621: new 50	java/io/File
    //   624: dup
    //   625: getstatic 310	com/tencent/mobileqq/app/AppConstants:SDCARD_AR_RELATIONSHIP	Ljava/lang/String;
    //   628: invokespecial 196	java/io/File:<init>	(Ljava/lang/String;)V
    //   631: astore_0
    //   632: aload_0
    //   633: invokevirtual 275	java/io/File:exists	()Z
    //   636: ifeq +7 -> 643
    //   639: aload_0
    //   640: invokestatic 201	com/dataline/util/file/FileUtil:a	(Ljava/io/File;)V
    //   643: new 50	java/io/File
    //   646: dup
    //   647: getstatic 313	com/tencent/mobileqq/app/AppConstants:SDCARD_AR_TRANSFER	Ljava/lang/String;
    //   650: invokespecial 196	java/io/File:<init>	(Ljava/lang/String;)V
    //   653: astore_0
    //   654: aload_0
    //   655: invokevirtual 275	java/io/File:exists	()Z
    //   658: ifeq +7 -> 665
    //   661: aload_0
    //   662: invokestatic 201	com/dataline/util/file/FileUtil:a	(Ljava/io/File;)V
    //   665: new 50	java/io/File
    //   668: dup
    //   669: getstatic 316	com/tencent/mobileqq/app/AppConstants:SDCARD_NEARBY_PROFILE_NOW_VIDEO_DIR	Ljava/lang/String;
    //   672: invokespecial 196	java/io/File:<init>	(Ljava/lang/String;)V
    //   675: astore_0
    //   676: aload_0
    //   677: invokevirtual 275	java/io/File:exists	()Z
    //   680: ifeq +7 -> 687
    //   683: aload_0
    //   684: invokestatic 201	com/dataline/util/file/FileUtil:a	(Ljava/io/File;)V
    //   687: aload_1
    //   688: ldc_w 318
    //   691: ldc 68
    //   693: invokevirtual 322	com/tencent/mobileqq/app/QQAppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   696: checkcast 318	com/tencent/mobileqq/vas/updatesystem/api/IVasQuickUpdateService
    //   699: invokeinterface 325 1 0
    //   704: invokestatic 328	dov/com/tencent/mobileqq/shortvideo/QQStoryFollowCaptureResManager:b	()V
    //   707: invokestatic 332	com/tencent/mobileqq/activity/aio/stickerrecommended/StickerRecManager:f	()V
    //   710: return
    //   711: astore_0
    //   712: invokestatic 337	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   715: ifeq -5 -> 710
    //   718: ldc_w 339
    //   721: iconst_2
    //   722: new 31	java/lang/StringBuilder
    //   725: dup
    //   726: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   729: ldc_w 341
    //   732: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   735: aload_0
    //   736: invokevirtual 344	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   739: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   742: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   745: invokestatic 347	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   748: return
    //   749: astore_0
    //   750: goto -478 -> 272
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	753	0	paramActivity	android.app.Activity
    //   0	753	1	paramQQAppInterface	QQAppInterface
    //   9	17	2	localIntent	Intent
    // Exception table:
    //   from	to	target	type
    //   0	66	711	java/lang/Exception
    //   70	79	711	java/lang/Exception
    //   79	148	711	java/lang/Exception
    //   152	163	711	java/lang/Exception
    //   163	167	711	java/lang/Exception
    //   171	182	711	java/lang/Exception
    //   182	186	711	java/lang/Exception
    //   190	201	711	java/lang/Exception
    //   201	205	711	java/lang/Exception
    //   209	220	711	java/lang/Exception
    //   272	359	711	java/lang/Exception
    //   363	367	711	java/lang/Exception
    //   367	392	711	java/lang/Exception
    //   392	404	711	java/lang/Exception
    //   404	426	711	java/lang/Exception
    //   426	448	711	java/lang/Exception
    //   448	470	711	java/lang/Exception
    //   470	492	711	java/lang/Exception
    //   492	533	711	java/lang/Exception
    //   533	555	711	java/lang/Exception
    //   555	577	711	java/lang/Exception
    //   577	599	711	java/lang/Exception
    //   599	621	711	java/lang/Exception
    //   621	643	711	java/lang/Exception
    //   643	665	711	java/lang/Exception
    //   665	687	711	java/lang/Exception
    //   687	710	711	java/lang/Exception
    //   220	272	749	java/lang/Exception
  }
  
  static void a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface.getApp() == null) {
      return;
    }
    BaseApplication.getContext().getPackageName();
    a(Utils.a(BaseApplication.getContext()) + "thumbnails/");
  }
  
  private static void a(String paramString)
  {
    paramString = new File(paramString);
    if (paramString != null)
    {
      paramString = paramString.listFiles();
      if (paramString != null)
      {
        int j = 0;
        while (j < paramString.length)
        {
          paramString[j].delete();
          j += 1;
        }
      }
    }
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    int j = 0;
    while (j < CardHandler.jdField_a_of_type_JavaUtilVector.size())
    {
      a(CardHandler.jdField_a_of_type_JavaLangString + ((Integer)CardHandler.jdField_a_of_type_JavaUtilVector.get(j)).intValue() + "/");
      j += 1;
    }
    a(CardHandler.jdField_a_of_type_JavaLangString + "background" + "/");
    a(AppConstants.SDCARD_PATH + "temp" + "/");
    a(CardHandler.jdField_a_of_type_JavaLangString + "temp" + "/");
    a(CardHandler.jdField_a_of_type_JavaLangString + "HDAvatar" + "/");
    a(AppConstants.PATH_CARD_QZONE);
    a(CardHandler.jdField_a_of_type_JavaLangString + "voice" + "/");
    a(GCCommon.a() + "/");
    a(AppConstants.SDCARD_PATH_PUBLIC_ACCOUNT_SCREENSHOTS);
    a(HotPicDownLoader.jdField_a_of_type_JavaLangString);
    a(HotVideoPreviewDownloader.jdField_a_of_type_JavaLangString);
    a(ScribbleMsgUtils.a());
  }
  
  private void b(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidWidgetProgressBar != null) {
      this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(paramInt);
    }
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(String.format(this.jdField_c_of_type_JavaLangString, new Object[] { paramInt + "%" }));
    }
  }
  
  private void b(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    Object localObject = (LinearLayout.LayoutParams)this.jdField_d_of_type_AndroidViewView.getLayoutParams();
    int j = Math.min(Math.max((int)(100L * paramLong1 / paramLong4), 2), 100) * this.jdField_d_of_type_Int / 100;
    ((LinearLayout.LayoutParams)localObject).width = j;
    this.jdField_d_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (LinearLayout.LayoutParams)this.e.getLayoutParams();
    int k = Math.min(Math.max((int)(100L * paramLong2 / paramLong4), 1), 100) * this.jdField_d_of_type_Int / 100;
    ((LinearLayout.LayoutParams)localObject).width = k;
    this.e.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (LinearLayout.LayoutParams)this.f.getLayoutParams();
    int m = Math.max(this.jdField_d_of_type_Int - j - k, 0);
    ((LinearLayout.LayoutParams)localObject).width = m;
    this.f.setLayoutParams((ViewGroup.LayoutParams)localObject);
    int n = (int)(100L * paramLong1 / paramLong4);
    if (n < 1) {}
    for (localObject = "<1%";; localObject = n + "%")
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(String.format(getString(2131698647), new Object[] { localObject }));
      localObject = FileCleanUtils.a(paramLong1);
      this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      this.jdField_a_of_type_Long = paramLong1;
      QLog.d("QQSettingMsgHistoryActivity", 1, "showSpaceInfo qqSpaceLength: " + j + " phoneSpaceLength: " + k + " avaliableSpaceLength: " + m);
      return;
    }
  }
  
  private static void b(QQAppInterface paramQQAppInterface)
  {
    if (URLDrawableHelper.diskCachePath != null)
    {
      a(URLDrawableHelper.diskCachePath.getAbsolutePath());
      if (((paramQQAppInterface.getApp() instanceof BaseApplicationImpl)) && (GlobalImageCache.a != null)) {
        GlobalImageCache.a.evictAll();
      }
    }
  }
  
  static void c()
  {
    a(AppConstants.SDCARD_PATH + "photo/");
  }
  
  private static void c(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = paramQQAppInterface.getManager(QQManagerFactory.QZONE_MANAGER);
    if (paramQQAppInterface == null) {}
    while (!(paramQQAppInterface instanceof QZoneManagerImp)) {
      return;
    }
    ((QZoneManagerImp)paramQQAppInterface).a = null;
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidViewView = findViewById(2131365497);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131371922);
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.jdField_a_of_type_AndroidViewView.findViewById(2131377480));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131365498));
    this.jdField_c_of_type_JavaLangString = getResources().getString(2131690788);
  }
  
  private void e()
  {
    if ((jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanScanSpaceManager != null) && (jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanScanSpaceManager.a()))
    {
      b(jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanScanSpaceManager.jdField_b_of_type_Long, jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanScanSpaceManager.a(), jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanScanSpaceManager.b(), jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanScanSpaceManager.c());
      QIMShortVideoUtils.a(this);
      if (VersionUtils.c()) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setOverScrollMode(0);
      }
      return;
    }
    if (jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanScanSpaceManager != null) {
      jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanScanSpaceManager.b();
    }
    jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanScanSpaceManager = new ScanSpaceManager();
    jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanScanSpaceManager.a(this);
    jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanScanSpaceManager.a();
  }
  
  private void f()
  {
    this.jdField_c_of_type_AndroidViewView = findViewById(2131364682);
    this.jdField_d_of_type_AndroidViewView = this.jdField_c_of_type_AndroidViewView.findViewById(2131374808);
    this.e = this.jdField_c_of_type_AndroidViewView.findViewById(2131372945);
    this.f = this.jdField_c_of_type_AndroidViewView.findViewById(2131372907);
    this.g = this.jdField_c_of_type_AndroidViewView.findViewById(2131374489);
    this.h = this.jdField_c_of_type_AndroidViewView.findViewById(2131372905);
    this.i = this.jdField_c_of_type_AndroidViewView.findViewById(2131372903);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131374807));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131365228));
    ((GradientDrawable)this.g.getBackground()).setColor(Color.parseColor("#00CAFC"));
    ((GradientDrawable)this.h.getBackground()).setColor(Color.parseColor("#FFCC00"));
    ((GradientDrawable)this.i.getBackground()).setColor(Color.parseColor("#EBEDF5"));
    this.jdField_a_of_type_Int = getResources().getDimensionPixelOffset(2131298532);
    this.jdField_b_of_type_Int = (this.jdField_a_of_type_Int / 8);
    this.jdField_c_of_type_Int = getResources().getDisplayMetrics().widthPixels;
    this.jdField_d_of_type_Int = (this.jdField_c_of_type_Int - this.jdField_a_of_type_Int * 2 - this.jdField_b_of_type_Int * 2);
  }
  
  private void g()
  {
    int k = 0;
    Intent localIntent = getIntent();
    int j = k;
    if (localIntent != null)
    {
      j = k;
      if (localIntent.hasExtra("set_display_type")) {
        j = localIntent.getIntExtra("set_display_type", 0);
      }
    }
    if (j == 2)
    {
      setTitle(2131719470);
      return;
    }
    setTitle(2131699134);
  }
  
  public void a(int paramInt)
  {
    b(paramInt);
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    b(100);
    b(paramLong1, paramLong2, paramLong3, paramLong4);
    QIMShortVideoUtils.a(this);
    if (VersionUtils.c()) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setOverScrollMode(0);
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidWidgetProgressBar != null) {
      this.jdField_a_of_type_AndroidWidgetProgressBar.setMax(100);
    }
    b(0);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    if (VersionUtils.c()) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setOverScrollMode(2);
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131561618);
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)findViewById(2131377554));
    setTitle(2131691554);
    d();
    f();
    e();
    this.jdField_b_of_type_JavaLangString = this.app.getCurrentAccountUin();
    setVolumeControlStream(3);
    if (JumpQqPimSecureUtil.a(this)) {
      VipUtils.a(this.app, "Safe_SpaceClean", "SpaceClean_", "enter_MsgHistory_had_installed_secure", 0, 0, null);
    }
    for (;;)
    {
      g();
      return true;
      VipUtils.a(this.app, "Safe_SpaceClean", "SpaceClean_", "enter_MsgHistory_had_not_intalled_secure", 0, 0, null);
    }
  }
  
  public void doOnDestroy()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      dismissDialog(1);
    }
    super.doOnDestroy();
    a();
    ScannerUtils.a(this);
  }
  
  public void doOnPostResume()
  {
    super.doOnPostResume();
    if (this.jdField_a_of_type_Boolean) {}
  }
  
  public void doOnResume()
  {
    super.doOnResume();
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    ((IApolloExtensionHandler)this.app.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER)).a(new String[] { this.app.getCurrentAccountUin() }, new int[] { 42255 });
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    long l;
    do
    {
      do
      {
        return;
      } while (paramIntent == null);
      l = paramIntent.getLongExtra("extra_delete_total_file_size", 0L);
    } while (l <= 0L);
    a(l);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onGlobalLayout()
  {
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  public String setLastActivityName()
  {
    return getString(2131690865);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQSettingMsgHistoryActivity
 * JD-Core Version:    0.7.0.1
 */