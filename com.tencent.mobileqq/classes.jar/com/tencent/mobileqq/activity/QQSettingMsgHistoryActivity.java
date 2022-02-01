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
import com.tencent.aelight.camera.util.api.IQIMShortVideoUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gamecenter.common.util.GCCommon;
import com.tencent.mobileqq.apollo.handler.IApolloExtensionHandler;
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
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.utils.QRUtils;
import com.tencent.mobileqq.scribble.ScribbleMsgConstants;
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
import java.io.File;
import java.util.Vector;

public class QQSettingMsgHistoryActivity
  extends IphoneTitleBarActivity
  implements ViewTreeObserver.OnGlobalLayoutListener, IScanSpaceListener
{
  private static volatile ScanSpaceManager jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanScanSpaceManager;
  static final String jdField_a_of_type_JavaLangString;
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
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(BaseApplication.getContext().getFilesDir());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("ChatHistoryEventConfig.json");
    jdField_a_of_type_JavaLangString = localStringBuilder.toString();
  }
  
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
    //   60: ldc 157
    //   62: invokestatic 163	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   65: checkcast 157	com/tencent/mobileqq/ark/api/IArkHelper
    //   68: invokeinterface 166 1 0
    //   73: invokestatic 169	com/tencent/mobileqq/listentogether/predownload/ListenTogetherResDownloader:b	()V
    //   76: aload_0
    //   77: ifnull +12 -> 89
    //   80: aload_0
    //   81: aload_1
    //   82: invokevirtual 172	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   85: invokestatic 177	cooperation/qqfav/QfavHelper:a	(Landroid/app/Activity;Ljava/lang/String;)Z
    //   88: pop
    //   89: ldc 179
    //   91: invokestatic 163	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   94: checkcast 179	com/tencent/biz/pubaccount/api/IPublicAccountJavascriptInterface
    //   97: aload_1
    //   98: invokeinterface 183 2 0
    //   103: new 31	java/lang/StringBuilder
    //   106: dup
    //   107: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   110: astore_0
    //   111: aload_0
    //   112: ldc 179
    //   114: invokestatic 163	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   117: checkcast 179	com/tencent/biz/pubaccount/api/IPublicAccountJavascriptInterface
    //   120: invokeinterface 186 1 0
    //   125: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: pop
    //   129: aload_0
    //   130: ldc 188
    //   132: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: pop
    //   136: aload_0
    //   137: aload_1
    //   138: invokevirtual 191	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   141: invokestatic 197	com/tencent/mobileqq/utils/HexUtil:String2HexString	(Ljava/lang/String;)Ljava/lang/String;
    //   144: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: pop
    //   148: new 50	java/io/File
    //   151: dup
    //   152: aload_0
    //   153: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   156: invokespecial 198	java/io/File:<init>	(Ljava/lang/String;)V
    //   159: invokestatic 203	com/dataline/util/file/FileUtil:a	(Ljava/io/File;)V
    //   162: invokestatic 207	com/tencent/biz/common/offline/OfflineEnvHelper:b	()Ljava/lang/String;
    //   165: astore_0
    //   166: aload_0
    //   167: ifnull +14 -> 181
    //   170: new 50	java/io/File
    //   173: dup
    //   174: aload_0
    //   175: invokespecial 198	java/io/File:<init>	(Ljava/lang/String;)V
    //   178: invokestatic 203	com/dataline/util/file/FileUtil:a	(Ljava/io/File;)V
    //   181: invokestatic 209	com/tencent/biz/common/offline/OfflineEnvHelper:d	()Ljava/lang/String;
    //   184: astore_0
    //   185: aload_0
    //   186: ifnull +14 -> 200
    //   189: new 50	java/io/File
    //   192: dup
    //   193: aload_0
    //   194: invokespecial 198	java/io/File:<init>	(Ljava/lang/String;)V
    //   197: invokestatic 203	com/dataline/util/file/FileUtil:a	(Ljava/io/File;)V
    //   200: invokestatic 211	com/tencent/biz/common/offline/OfflineEnvHelper:a	()Ljava/lang/String;
    //   203: astore_0
    //   204: aload_0
    //   205: ifnull +14 -> 219
    //   208: new 50	java/io/File
    //   211: dup
    //   212: aload_0
    //   213: invokespecial 198	java/io/File:<init>	(Ljava/lang/String;)V
    //   216: invokestatic 203	com/dataline/util/file/FileUtil:a	(Ljava/io/File;)V
    //   219: invokestatic 213	com/tencent/biz/common/offline/OfflineEnvHelper:c	()Ljava/lang/String;
    //   222: astore_0
    //   223: aload_0
    //   224: ifnull +14 -> 238
    //   227: new 50	java/io/File
    //   230: dup
    //   231: aload_0
    //   232: invokespecial 198	java/io/File:<init>	(Ljava/lang/String;)V
    //   235: invokestatic 203	com/dataline/util/file/FileUtil:a	(Ljava/io/File;)V
    //   238: new 31	java/lang/StringBuilder
    //   241: dup
    //   242: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   245: astore_0
    //   246: aload_0
    //   247: invokestatic 218	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   250: invokevirtual 221	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   253: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: pop
    //   257: aload_0
    //   258: ldc 223
    //   260: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: pop
    //   264: new 50	java/io/File
    //   267: dup
    //   268: aload_0
    //   269: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   272: invokespecial 198	java/io/File:<init>	(Ljava/lang/String;)V
    //   275: invokestatic 203	com/dataline/util/file/FileUtil:a	(Ljava/io/File;)V
    //   278: new 50	java/io/File
    //   281: dup
    //   282: invokestatic 226	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   285: invokevirtual 44	com/tencent/qphone/base/util/BaseApplication:getFilesDir	()Ljava/io/File;
    //   288: ldc 228
    //   290: invokespecial 231	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   293: invokestatic 203	com/dataline/util/file/FileUtil:a	(Ljava/io/File;)V
    //   296: new 50	java/io/File
    //   299: dup
    //   300: invokestatic 226	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   303: invokevirtual 44	com/tencent/qphone/base/util/BaseApplication:getFilesDir	()Ljava/io/File;
    //   306: ldc 233
    //   308: invokespecial 231	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   311: invokestatic 203	com/dataline/util/file/FileUtil:a	(Ljava/io/File;)V
    //   314: aload_1
    //   315: invokevirtual 118	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   318: ldc 235
    //   320: iconst_4
    //   321: invokevirtual 239	mqq/app/MobileQQ:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   324: invokeinterface 245 1 0
    //   329: invokeinterface 250 1 0
    //   334: invokeinterface 254 1 0
    //   339: pop
    //   340: aload_1
    //   341: invokevirtual 118	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   344: ldc_w 256
    //   347: iconst_4
    //   348: invokevirtual 239	mqq/app/MobileQQ:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   351: invokeinterface 245 1 0
    //   356: invokeinterface 250 1 0
    //   361: invokeinterface 254 1 0
    //   366: pop
    //   367: new 50	java/io/File
    //   370: dup
    //   371: getstatic 261	com/tencent/mobileqq/app/AppConstants:SDCARD_GIFT_SAVE	Ljava/lang/String;
    //   374: invokespecial 198	java/io/File:<init>	(Ljava/lang/String;)V
    //   377: invokestatic 203	com/dataline/util/file/FileUtil:a	(Ljava/io/File;)V
    //   380: invokestatic 266	com/tencent/smtt/sdk/CacheManager:getCacheFileBaseDir	()Ljava/io/File;
    //   383: astore_0
    //   384: aload_0
    //   385: ifnull +7 -> 392
    //   388: aload_0
    //   389: invokestatic 203	com/dataline/util/file/FileUtil:a	(Ljava/io/File;)V
    //   392: invokestatic 271	com/tencent/mobileqq/shortvideo/ShortVideoUtils:deleteDownloadTempFile	()V
    //   395: new 50	java/io/File
    //   398: dup
    //   399: getstatic 274	com/tencent/mobileqq/app/AppConstants:SDCARD_NEARBY_FLOWER	Ljava/lang/String;
    //   402: invokespecial 198	java/io/File:<init>	(Ljava/lang/String;)V
    //   405: astore_0
    //   406: aload_0
    //   407: invokevirtual 277	java/io/File:exists	()Z
    //   410: ifeq +7 -> 417
    //   413: aload_0
    //   414: invokestatic 203	com/dataline/util/file/FileUtil:a	(Ljava/io/File;)V
    //   417: aload_0
    //   418: invokevirtual 277	java/io/File:exists	()Z
    //   421: ifne +8 -> 429
    //   424: aload_0
    //   425: invokevirtual 280	java/io/File:mkdirs	()Z
    //   428: pop
    //   429: new 50	java/io/File
    //   432: dup
    //   433: getstatic 283	com/tencent/mobileqq/app/AppConstants:SDCARD_HOMEWORK_ATTACH	Ljava/lang/String;
    //   436: invokespecial 198	java/io/File:<init>	(Ljava/lang/String;)V
    //   439: astore_0
    //   440: aload_0
    //   441: invokevirtual 277	java/io/File:exists	()Z
    //   444: ifeq +7 -> 451
    //   447: aload_0
    //   448: invokestatic 203	com/dataline/util/file/FileUtil:a	(Ljava/io/File;)V
    //   451: new 50	java/io/File
    //   454: dup
    //   455: getstatic 286	com/tencent/mobileqq/app/AppConstants:SDCARD_TROOP_REWARD	Ljava/lang/String;
    //   458: invokespecial 198	java/io/File:<init>	(Ljava/lang/String;)V
    //   461: astore_0
    //   462: aload_0
    //   463: invokevirtual 277	java/io/File:exists	()Z
    //   466: ifeq +7 -> 473
    //   469: aload_0
    //   470: invokestatic 203	com/dataline/util/file/FileUtil:a	(Ljava/io/File;)V
    //   473: new 50	java/io/File
    //   476: dup
    //   477: getstatic 289	com/tencent/mobileqq/app/AppConstants:SDCARD_PATH_PUBLIC_ACCOUNT_PRELOAD	Ljava/lang/String;
    //   480: invokespecial 198	java/io/File:<init>	(Ljava/lang/String;)V
    //   483: astore_0
    //   484: aload_0
    //   485: invokevirtual 277	java/io/File:exists	()Z
    //   488: ifeq +7 -> 495
    //   491: aload_0
    //   492: invokestatic 203	com/dataline/util/file/FileUtil:a	(Ljava/io/File;)V
    //   495: new 50	java/io/File
    //   498: dup
    //   499: getstatic 292	com/tencent/mobileqq/app/AppConstants:SDCARD_PATH_READINJOY_TEMPLATE_VIDEO_PATH	Ljava/lang/String;
    //   502: invokespecial 198	java/io/File:<init>	(Ljava/lang/String;)V
    //   505: astore_0
    //   506: aload_0
    //   507: invokevirtual 277	java/io/File:exists	()Z
    //   510: ifeq +7 -> 517
    //   513: aload_0
    //   514: invokestatic 203	com/dataline/util/file/FileUtil:a	(Ljava/io/File;)V
    //   517: new 31	java/lang/StringBuilder
    //   520: dup
    //   521: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   524: astore_0
    //   525: aload_0
    //   526: getstatic 295	com/tencent/mobileqq/app/AppConstants:SDCARD_PATH	Ljava/lang/String;
    //   529: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   532: pop
    //   533: aload_0
    //   534: ldc_w 297
    //   537: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   540: pop
    //   541: new 50	java/io/File
    //   544: dup
    //   545: aload_0
    //   546: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   549: invokespecial 198	java/io/File:<init>	(Ljava/lang/String;)V
    //   552: astore_0
    //   553: aload_0
    //   554: invokevirtual 277	java/io/File:exists	()Z
    //   557: ifeq +7 -> 564
    //   560: aload_0
    //   561: invokestatic 203	com/dataline/util/file/FileUtil:a	(Ljava/io/File;)V
    //   564: new 50	java/io/File
    //   567: dup
    //   568: getstatic 300	com/tencent/mobileqq/app/AppConstants:SDCARD_AR_IMG	Ljava/lang/String;
    //   571: invokespecial 198	java/io/File:<init>	(Ljava/lang/String;)V
    //   574: astore_0
    //   575: aload_0
    //   576: invokevirtual 277	java/io/File:exists	()Z
    //   579: ifeq +7 -> 586
    //   582: aload_0
    //   583: invokestatic 203	com/dataline/util/file/FileUtil:a	(Ljava/io/File;)V
    //   586: new 50	java/io/File
    //   589: dup
    //   590: getstatic 303	com/tencent/mobileqq/app/AppConstants:SDCARD_AR_FEATURE	Ljava/lang/String;
    //   593: invokespecial 198	java/io/File:<init>	(Ljava/lang/String;)V
    //   596: astore_0
    //   597: aload_0
    //   598: invokevirtual 277	java/io/File:exists	()Z
    //   601: ifeq +7 -> 608
    //   604: aload_0
    //   605: invokestatic 203	com/dataline/util/file/FileUtil:a	(Ljava/io/File;)V
    //   608: new 50	java/io/File
    //   611: dup
    //   612: getstatic 306	com/tencent/mobileqq/app/AppConstants:SDCARD_AR_CONFIG	Ljava/lang/String;
    //   615: invokespecial 198	java/io/File:<init>	(Ljava/lang/String;)V
    //   618: astore_0
    //   619: aload_0
    //   620: invokevirtual 277	java/io/File:exists	()Z
    //   623: ifeq +7 -> 630
    //   626: aload_0
    //   627: invokestatic 203	com/dataline/util/file/FileUtil:a	(Ljava/io/File;)V
    //   630: new 50	java/io/File
    //   633: dup
    //   634: getstatic 309	com/tencent/mobileqq/app/AppConstants:SDCARD_AR_MODEL	Ljava/lang/String;
    //   637: invokespecial 198	java/io/File:<init>	(Ljava/lang/String;)V
    //   640: astore_0
    //   641: aload_0
    //   642: invokevirtual 277	java/io/File:exists	()Z
    //   645: ifeq +7 -> 652
    //   648: aload_0
    //   649: invokestatic 203	com/dataline/util/file/FileUtil:a	(Ljava/io/File;)V
    //   652: new 50	java/io/File
    //   655: dup
    //   656: getstatic 312	com/tencent/mobileqq/app/AppConstants:SDCARD_AR_RELATIONSHIP	Ljava/lang/String;
    //   659: invokespecial 198	java/io/File:<init>	(Ljava/lang/String;)V
    //   662: astore_0
    //   663: aload_0
    //   664: invokevirtual 277	java/io/File:exists	()Z
    //   667: ifeq +7 -> 674
    //   670: aload_0
    //   671: invokestatic 203	com/dataline/util/file/FileUtil:a	(Ljava/io/File;)V
    //   674: new 50	java/io/File
    //   677: dup
    //   678: getstatic 315	com/tencent/mobileqq/app/AppConstants:SDCARD_AR_TRANSFER	Ljava/lang/String;
    //   681: invokespecial 198	java/io/File:<init>	(Ljava/lang/String;)V
    //   684: astore_0
    //   685: aload_0
    //   686: invokevirtual 277	java/io/File:exists	()Z
    //   689: ifeq +7 -> 696
    //   692: aload_0
    //   693: invokestatic 203	com/dataline/util/file/FileUtil:a	(Ljava/io/File;)V
    //   696: new 50	java/io/File
    //   699: dup
    //   700: getstatic 318	com/tencent/mobileqq/app/AppConstants:SDCARD_AV	Ljava/lang/String;
    //   703: invokespecial 198	java/io/File:<init>	(Ljava/lang/String;)V
    //   706: astore_0
    //   707: aload_0
    //   708: invokevirtual 277	java/io/File:exists	()Z
    //   711: ifeq +7 -> 718
    //   714: aload_0
    //   715: invokestatic 203	com/dataline/util/file/FileUtil:a	(Ljava/io/File;)V
    //   718: new 50	java/io/File
    //   721: dup
    //   722: getstatic 321	com/tencent/mobileqq/app/AppConstants:SDCARD_NEARBY_PROFILE_NOW_VIDEO_DIR	Ljava/lang/String;
    //   725: invokespecial 198	java/io/File:<init>	(Ljava/lang/String;)V
    //   728: astore_0
    //   729: aload_0
    //   730: invokevirtual 277	java/io/File:exists	()Z
    //   733: ifeq +7 -> 740
    //   736: aload_0
    //   737: invokestatic 203	com/dataline/util/file/FileUtil:a	(Ljava/io/File;)V
    //   740: aload_1
    //   741: ldc_w 323
    //   744: ldc 68
    //   746: invokevirtual 327	com/tencent/mobileqq/app/QQAppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   749: checkcast 323	com/tencent/mobileqq/vas/updatesystem/api/IVasQuickUpdateService
    //   752: invokeinterface 330 1 0
    //   757: aload_1
    //   758: ldc_w 332
    //   761: invokevirtual 335	com/tencent/mobileqq/app/QQAppInterface:getRuntimeService	(Ljava/lang/Class;)Lmqq/app/api/IRuntimeService;
    //   764: checkcast 332	com/tencent/mobileqq/activity/aio/stickerrecommended/IStickerRecManager
    //   767: invokeinterface 338 1 0
    //   772: return
    //   773: astore_0
    //   774: invokestatic 343	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   777: ifeq +39 -> 816
    //   780: new 31	java/lang/StringBuilder
    //   783: dup
    //   784: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   787: astore_1
    //   788: aload_1
    //   789: ldc_w 345
    //   792: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   795: pop
    //   796: aload_1
    //   797: aload_0
    //   798: invokevirtual 348	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   801: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   804: pop
    //   805: ldc_w 350
    //   808: iconst_2
    //   809: aload_1
    //   810: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   813: invokestatic 353	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   816: return
    //   817: astore_0
    //   818: goto -522 -> 296
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	821	0	paramActivity	android.app.Activity
    //   0	821	1	paramQQAppInterface	QQAppInterface
    //   9	17	2	localIntent	Intent
    // Exception table:
    //   from	to	target	type
    //   0	76	773	java/lang/Exception
    //   80	89	773	java/lang/Exception
    //   89	166	773	java/lang/Exception
    //   170	181	773	java/lang/Exception
    //   181	185	773	java/lang/Exception
    //   189	200	773	java/lang/Exception
    //   200	204	773	java/lang/Exception
    //   208	219	773	java/lang/Exception
    //   219	223	773	java/lang/Exception
    //   227	238	773	java/lang/Exception
    //   296	384	773	java/lang/Exception
    //   388	392	773	java/lang/Exception
    //   392	417	773	java/lang/Exception
    //   417	429	773	java/lang/Exception
    //   429	451	773	java/lang/Exception
    //   451	473	773	java/lang/Exception
    //   473	495	773	java/lang/Exception
    //   495	517	773	java/lang/Exception
    //   517	564	773	java/lang/Exception
    //   564	586	773	java/lang/Exception
    //   586	608	773	java/lang/Exception
    //   608	630	773	java/lang/Exception
    //   630	652	773	java/lang/Exception
    //   652	674	773	java/lang/Exception
    //   674	696	773	java/lang/Exception
    //   696	718	773	java/lang/Exception
    //   718	740	773	java/lang/Exception
    //   740	772	773	java/lang/Exception
    //   238	296	817	java/lang/Exception
  }
  
  static void a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface.getApp() == null) {
      return;
    }
    BaseApplication.getContext().getPackageName();
    paramQQAppInterface = new StringBuilder();
    paramQQAppInterface.append(Utils.a(BaseApplication.getContext()));
    paramQQAppInterface.append("thumbnails/");
    a(paramQQAppInterface.toString());
  }
  
  private static void a(String paramString)
  {
    paramString = new File(paramString).listFiles();
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
  
  public static void a(String paramString, boolean paramBoolean)
  {
    int j = 0;
    while (j < CardHandler.jdField_a_of_type_JavaUtilVector.size())
    {
      paramString = new StringBuilder();
      paramString.append(CardHandler.jdField_a_of_type_JavaLangString);
      paramString.append(((Integer)CardHandler.jdField_a_of_type_JavaUtilVector.get(j)).intValue());
      paramString.append("/");
      a(paramString.toString());
      j += 1;
    }
    paramString = new StringBuilder();
    paramString.append(CardHandler.jdField_a_of_type_JavaLangString);
    paramString.append("background");
    paramString.append("/");
    a(paramString.toString());
    paramString = new StringBuilder();
    paramString.append(AppConstants.SDCARD_PATH);
    paramString.append("temp");
    paramString.append("/");
    a(paramString.toString());
    paramString = new StringBuilder();
    paramString.append(CardHandler.jdField_a_of_type_JavaLangString);
    paramString.append("temp");
    paramString.append("/");
    a(paramString.toString());
    paramString = new StringBuilder();
    paramString.append(CardHandler.jdField_a_of_type_JavaLangString);
    paramString.append("HDAvatar");
    paramString.append("/");
    a(paramString.toString());
    a(AppConstants.PATH_CARD_QZONE);
    paramString = new StringBuilder();
    paramString.append(CardHandler.jdField_a_of_type_JavaLangString);
    paramString.append("voice");
    paramString.append("/");
    a(paramString.toString());
    paramString = new StringBuilder();
    paramString.append(GCCommon.a());
    paramString.append("/");
    a(paramString.toString());
    a(AppConstants.SDCARD_PATH_PUBLIC_ACCOUNT_SCREENSHOTS);
    a(HotPicDownLoader.jdField_a_of_type_JavaLangString);
    a(HotVideoPreviewDownloader.jdField_a_of_type_JavaLangString);
    a(ScribbleMsgConstants.a());
  }
  
  private void b(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_AndroidWidgetProgressBar;
    if (localObject != null) {
      ((ProgressBar)localObject).setProgress(paramInt);
    }
    localObject = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localObject != null)
    {
      String str = this.jdField_c_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramInt);
      localStringBuilder.append("%");
      ((TextView)localObject).setText(String.format(str, new Object[] { localStringBuilder.toString() }));
    }
  }
  
  private void b(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    Object localObject = (LinearLayout.LayoutParams)this.jdField_d_of_type_AndroidViewView.getLayoutParams();
    int j = (int)(paramLong1 * 100L / paramLong4);
    int k = Math.min(Math.max(j, 2), 100);
    k = this.jdField_d_of_type_Int * k / 100;
    ((LinearLayout.LayoutParams)localObject).width = k;
    this.jdField_d_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (LinearLayout.LayoutParams)this.e.getLayoutParams();
    int m = Math.min(Math.max((int)(paramLong2 * 100L / paramLong4), 1), 100);
    m = this.jdField_d_of_type_Int * m / 100;
    ((LinearLayout.LayoutParams)localObject).width = m;
    this.e.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (LinearLayout.LayoutParams)this.f.getLayoutParams();
    int n = Math.max(this.jdField_d_of_type_Int - k - m, 0);
    ((LinearLayout.LayoutParams)localObject).width = n;
    this.f.setLayoutParams((ViewGroup.LayoutParams)localObject);
    if (j < 1)
    {
      localObject = "<1%";
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(j);
      ((StringBuilder)localObject).append("%");
      localObject = ((StringBuilder)localObject).toString();
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setText(String.format(getString(2131698713), new Object[] { localObject }));
    localObject = FileCleanUtils.a(paramLong1);
    this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    this.jdField_a_of_type_Long = paramLong1;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("showSpaceInfo qqSpaceLength: ");
    ((StringBuilder)localObject).append(k);
    ((StringBuilder)localObject).append(" phoneSpaceLength: ");
    ((StringBuilder)localObject).append(m);
    ((StringBuilder)localObject).append(" avaliableSpaceLength: ");
    ((StringBuilder)localObject).append(n);
    QLog.d("QQSettingMsgHistoryActivity", 1, ((StringBuilder)localObject).toString());
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_PATH);
    localStringBuilder.append("photo/");
    a(localStringBuilder.toString());
  }
  
  private static void c(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = paramQQAppInterface.getManager(QQManagerFactory.QZONE_MANAGER);
    if (paramQQAppInterface == null) {
      return;
    }
    if (!(paramQQAppInterface instanceof QZoneManagerImp)) {
      return;
    }
    ((QZoneManagerImp)paramQQAppInterface).a = null;
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidViewView = findViewById(2131365342);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131371539);
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.jdField_a_of_type_AndroidViewView.findViewById(2131376925));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131365343));
    this.jdField_c_of_type_JavaLangString = getResources().getString(2131690716);
  }
  
  private void e()
  {
    if ((jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanScanSpaceManager != null) && (jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanScanSpaceManager.a()))
    {
      b(jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanScanSpaceManager.jdField_b_of_type_Long, jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanScanSpaceManager.a(), jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanScanSpaceManager.b(), jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanScanSpaceManager.c());
      ((IQIMShortVideoUtil)QRoute.api(IQIMShortVideoUtil.class)).preLoadPeakProcess(this);
      if (VersionUtils.c()) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setOverScrollMode(0);
      }
    }
    else
    {
      if (jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanScanSpaceManager != null) {
        jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanScanSpaceManager.b();
      }
      jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanScanSpaceManager = new ScanSpaceManager();
      jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanScanSpaceManager.a(this);
      jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanScanSpaceManager.a();
    }
  }
  
  private void f()
  {
    this.jdField_c_of_type_AndroidViewView = findViewById(2131364569);
    this.jdField_d_of_type_AndroidViewView = this.jdField_c_of_type_AndroidViewView.findViewById(2131374353);
    this.e = this.jdField_c_of_type_AndroidViewView.findViewById(2131372532);
    this.f = this.jdField_c_of_type_AndroidViewView.findViewById(2131372494);
    this.g = this.jdField_c_of_type_AndroidViewView.findViewById(2131374027);
    this.h = this.jdField_c_of_type_AndroidViewView.findViewById(2131372492);
    this.i = this.jdField_c_of_type_AndroidViewView.findViewById(2131372490);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131374352));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131365105));
    ((GradientDrawable)this.g.getBackground()).setColor(Color.parseColor("#00CAFC"));
    ((GradientDrawable)this.h.getBackground()).setColor(Color.parseColor("#FFCC00"));
    ((GradientDrawable)this.i.getBackground()).setColor(Color.parseColor("#EBEDF5"));
    this.jdField_a_of_type_Int = getResources().getDimensionPixelOffset(2131298527);
    this.jdField_b_of_type_Int = (this.jdField_a_of_type_Int / 8);
    this.jdField_c_of_type_Int = getResources().getDisplayMetrics().widthPixels;
    this.jdField_d_of_type_Int = (this.jdField_c_of_type_Int - this.jdField_a_of_type_Int * 2 - this.jdField_b_of_type_Int * 2);
  }
  
  private void g()
  {
    Intent localIntent = getIntent();
    int k = 0;
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
      setTitle(2131719188);
      return;
    }
    setTitle(2131699238);
  }
  
  public void a(int paramInt)
  {
    b(paramInt);
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    b(100);
    b(paramLong1, paramLong2, paramLong3, paramLong4);
    ((IQIMShortVideoUtil)QRoute.api(IQIMShortVideoUtil.class)).preLoadPeakProcess(this);
    if (VersionUtils.c()) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setOverScrollMode(0);
    }
  }
  
  public void b()
  {
    ProgressBar localProgressBar = this.jdField_a_of_type_AndroidWidgetProgressBar;
    if (localProgressBar != null) {
      localProgressBar.setMax(100);
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
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131561460);
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)findViewById(2131376998));
    setTitle(2131691475);
    d();
    f();
    e();
    this.jdField_b_of_type_JavaLangString = this.app.getCurrentAccountUin();
    setVolumeControlStream(3);
    if (JumpQqPimSecureUtil.a(this)) {
      VipUtils.a(this.app, "Safe_SpaceClean", "SpaceClean_", "enter_MsgHistory_had_installed_secure", 0, 0, null);
    } else {
      VipUtils.a(this.app, "Safe_SpaceClean", "SpaceClean_", "enter_MsgHistory_had_not_intalled_secure", 0, 0, null);
    }
    g();
    return true;
  }
  
  protected void doOnDestroy()
  {
    QQProgressDialog localQQProgressDialog = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {
      dismissDialog(1);
    }
    super.doOnDestroy();
    a();
    QRUtils.a(this);
  }
  
  protected void doOnPostResume()
  {
    super.doOnPostResume();
    boolean bool = this.jdField_a_of_type_Boolean;
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    ((IApolloExtensionHandler)this.app.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER)).a(new String[] { this.app.getCurrentAccountUin() }, new int[] { 42255 });
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 != 1) {
      return;
    }
    if (paramIntent != null)
    {
      long l = paramIntent.getLongExtra("extra_delete_total_file_size", 0L);
      if (l > 0L) {
        a(l);
      }
    }
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
  
  protected String setLastActivityName()
  {
    return getString(2131690793);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQSettingMsgHistoryActivity
 * JD-Core Version:    0.7.0.1
 */