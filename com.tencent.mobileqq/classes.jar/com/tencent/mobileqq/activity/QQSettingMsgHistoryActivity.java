package com.tencent.mobileqq.activity;

import android.app.Application;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gamecenter.common.util.GCCommon;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.MessageRoamManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.hotpic.HotPicDownLoader;
import com.tencent.mobileqq.hotpic.HotVideoPreviewDownloader;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.scribble.ScribbleMsgUtils;
import com.tencent.mobileqq.servlet.QZoneManagerImp;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.JumpQqPimSecureUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.GuideViewBuilder;
import com.tencent.mobileqq.widget.GuideViewBuilder.GuideLayoutParams;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.io.File;
import java.util.Vector;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import tjt;
import tju;
import tjw;
import tjx;
import tjy;
import tjz;
import tka;
import tkb;
import tkc;
import tke;
import tkg;

public class QQSettingMsgHistoryActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, ViewTreeObserver.OnGlobalLayoutListener, CompoundButton.OnCheckedChangeListener
{
  public static final String c;
  private long jdField_a_of_type_Long;
  public Handler a;
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new tjw(this);
  public RedTouch a;
  public DownloadListener a;
  public FormSimpleItem a;
  private FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  public QQProgressDialog a;
  public String a;
  boolean jdField_a_of_type_Boolean = true;
  private View jdField_b_of_type_AndroidViewView;
  private FormSimpleItem jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private QQProgressDialog jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  public String b;
  private View c;
  private String d = "";
  
  static
  {
    jdField_c_of_type_JavaLangString = BaseApplication.getContext().getFilesDir() + File.separator + "ChatHistoryEventConfig.json";
  }
  
  public QQSettingMsgHistoryActivity()
  {
    this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener = new tka(this);
    this.jdField_a_of_type_AndroidOsHandler = new tkc(this);
  }
  
  /* Error */
  public static void a(android.app.Activity paramActivity, QQAppInterface paramQQAppInterface)
  {
    // Byte code:
    //   0: new 96	android/content/Intent
    //   3: dup
    //   4: ldc 98
    //   6: invokespecial 101	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   9: astore_2
    //   10: aload_2
    //   11: ldc 103
    //   13: iconst_1
    //   14: invokevirtual 107	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   17: pop
    //   18: aload_1
    //   19: invokevirtual 113	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   22: invokevirtual 119	mqq/app/MobileQQ:getApplicationContext	()Landroid/content/Context;
    //   25: aload_2
    //   26: invokevirtual 125	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
    //   29: aload_1
    //   30: iconst_0
    //   31: invokestatic 130	cooperation/qzone/QZoneHelper:a	(Lmqq/app/AppRuntime;Z)V
    //   34: aload_1
    //   35: invokestatic 133	com/tencent/mobileqq/activity/QQSettingMsgHistoryActivity:c	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   38: aload_1
    //   39: invokevirtual 135	com/tencent/mobileqq/app/QQAppInterface:c	()Ljava/lang/String;
    //   42: iconst_0
    //   43: invokestatic 138	com/tencent/mobileqq/activity/QQSettingMsgHistoryActivity:a	(Ljava/lang/String;Z)V
    //   46: aload_1
    //   47: invokestatic 140	com/tencent/mobileqq/activity/QQSettingMsgHistoryActivity:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   50: invokestatic 142	com/tencent/mobileqq/activity/QQSettingMsgHistoryActivity:c	()V
    //   53: aload_1
    //   54: invokestatic 144	com/tencent/mobileqq/activity/QQSettingMsgHistoryActivity:b	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   57: invokestatic 148	com/tencent/mobileqq/utils/MusicCacheManager:a	()V
    //   60: aload_0
    //   61: ifnull +12 -> 73
    //   64: aload_0
    //   65: aload_1
    //   66: invokevirtual 151	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   69: invokestatic 156	cooperation/qqfav/QfavHelper:a	(Landroid/app/Activity;Ljava/lang/String;)Z
    //   72: pop
    //   73: invokestatic 160	com/tencent/mobileqq/ark/ArkAppCenter:b	()V
    //   76: aload_1
    //   77: invokestatic 166	com/tencent/biz/pubaccount/PublicAccountJavascriptInterface:deleteAllH5Data	(Lcom/tencent/common/app/AppInterface;)V
    //   80: new 49	java/io/File
    //   83: dup
    //   84: new 30	java/lang/StringBuilder
    //   87: dup
    //   88: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   91: getstatic 168	com/tencent/biz/pubaccount/PublicAccountJavascriptInterface:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   94: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: ldc 170
    //   99: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: aload_1
    //   103: invokevirtual 173	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   106: invokestatic 178	com/tencent/mobileqq/utils/HexUtil:b	(Ljava/lang/String;)Ljava/lang/String;
    //   109: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   115: invokespecial 179	java/io/File:<init>	(Ljava/lang/String;)V
    //   118: invokestatic 184	com/dataline/util/file/FileUtil:a	(Ljava/io/File;)V
    //   121: invokestatic 188	com/tencent/biz/common/offline/OfflineEnvHelper:b	()Ljava/lang/String;
    //   124: astore_0
    //   125: aload_0
    //   126: ifnull +14 -> 140
    //   129: new 49	java/io/File
    //   132: dup
    //   133: aload_0
    //   134: invokespecial 179	java/io/File:<init>	(Ljava/lang/String;)V
    //   137: invokestatic 184	com/dataline/util/file/FileUtil:a	(Ljava/io/File;)V
    //   140: invokestatic 190	com/tencent/biz/common/offline/OfflineEnvHelper:d	()Ljava/lang/String;
    //   143: astore_0
    //   144: aload_0
    //   145: ifnull +14 -> 159
    //   148: new 49	java/io/File
    //   151: dup
    //   152: aload_0
    //   153: invokespecial 179	java/io/File:<init>	(Ljava/lang/String;)V
    //   156: invokestatic 184	com/dataline/util/file/FileUtil:a	(Ljava/io/File;)V
    //   159: invokestatic 192	com/tencent/biz/common/offline/OfflineEnvHelper:a	()Ljava/lang/String;
    //   162: astore_0
    //   163: aload_0
    //   164: ifnull +14 -> 178
    //   167: new 49	java/io/File
    //   170: dup
    //   171: aload_0
    //   172: invokespecial 179	java/io/File:<init>	(Ljava/lang/String;)V
    //   175: invokestatic 184	com/dataline/util/file/FileUtil:a	(Ljava/io/File;)V
    //   178: invokestatic 193	com/tencent/biz/common/offline/OfflineEnvHelper:c	()Ljava/lang/String;
    //   181: astore_0
    //   182: aload_0
    //   183: ifnull +14 -> 197
    //   186: new 49	java/io/File
    //   189: dup
    //   190: aload_0
    //   191: invokespecial 179	java/io/File:<init>	(Ljava/lang/String;)V
    //   194: invokestatic 184	com/dataline/util/file/FileUtil:a	(Ljava/io/File;)V
    //   197: new 49	java/io/File
    //   200: dup
    //   201: new 30	java/lang/StringBuilder
    //   204: dup
    //   205: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   208: invokestatic 198	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   211: invokevirtual 201	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   214: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: ldc 203
    //   219: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   225: invokespecial 179	java/io/File:<init>	(Ljava/lang/String;)V
    //   228: invokestatic 184	com/dataline/util/file/FileUtil:a	(Ljava/io/File;)V
    //   231: new 49	java/io/File
    //   234: dup
    //   235: invokestatic 206	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   238: invokevirtual 43	com/tencent/qphone/base/util/BaseApplication:getFilesDir	()Ljava/io/File;
    //   241: ldc 208
    //   243: invokespecial 211	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   246: invokestatic 184	com/dataline/util/file/FileUtil:a	(Ljava/io/File;)V
    //   249: new 49	java/io/File
    //   252: dup
    //   253: invokestatic 206	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   256: invokevirtual 43	com/tencent/qphone/base/util/BaseApplication:getFilesDir	()Ljava/io/File;
    //   259: ldc 213
    //   261: invokespecial 211	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   264: invokestatic 184	com/dataline/util/file/FileUtil:a	(Ljava/io/File;)V
    //   267: aload_1
    //   268: invokevirtual 113	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   271: ldc 215
    //   273: iconst_4
    //   274: invokevirtual 219	mqq/app/MobileQQ:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   277: invokeinterface 225 1 0
    //   282: invokeinterface 230 1 0
    //   287: invokeinterface 234 1 0
    //   292: pop
    //   293: aload_1
    //   294: invokevirtual 113	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   297: ldc 236
    //   299: iconst_4
    //   300: invokevirtual 219	mqq/app/MobileQQ:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   303: invokeinterface 225 1 0
    //   308: invokeinterface 230 1 0
    //   313: invokeinterface 234 1 0
    //   318: pop
    //   319: new 49	java/io/File
    //   322: dup
    //   323: getstatic 241	com/tencent/mobileqq/app/AppConstants:cc	Ljava/lang/String;
    //   326: invokespecial 179	java/io/File:<init>	(Ljava/lang/String;)V
    //   329: invokestatic 184	com/dataline/util/file/FileUtil:a	(Ljava/io/File;)V
    //   332: invokestatic 246	com/tencent/smtt/sdk/CacheManager:getCacheFileBaseDir	()Ljava/io/File;
    //   335: astore_0
    //   336: aload_0
    //   337: ifnull +7 -> 344
    //   340: aload_0
    //   341: invokestatic 184	com/dataline/util/file/FileUtil:a	(Ljava/io/File;)V
    //   344: invokestatic 249	com/tencent/mobileqq/shortvideo/ShortVideoUtils:a	()V
    //   347: new 49	java/io/File
    //   350: dup
    //   351: getstatic 252	com/tencent/mobileqq/app/AppConstants:cf	Ljava/lang/String;
    //   354: invokespecial 179	java/io/File:<init>	(Ljava/lang/String;)V
    //   357: astore_0
    //   358: aload_0
    //   359: invokevirtual 255	java/io/File:exists	()Z
    //   362: ifeq +7 -> 369
    //   365: aload_0
    //   366: invokestatic 184	com/dataline/util/file/FileUtil:a	(Ljava/io/File;)V
    //   369: aload_0
    //   370: invokevirtual 255	java/io/File:exists	()Z
    //   373: ifne +8 -> 381
    //   376: aload_0
    //   377: invokevirtual 258	java/io/File:mkdirs	()Z
    //   380: pop
    //   381: new 49	java/io/File
    //   384: dup
    //   385: getstatic 261	com/tencent/mobileqq/app/AppConstants:bf	Ljava/lang/String;
    //   388: invokespecial 179	java/io/File:<init>	(Ljava/lang/String;)V
    //   391: astore_0
    //   392: aload_0
    //   393: invokevirtual 255	java/io/File:exists	()Z
    //   396: ifeq +7 -> 403
    //   399: aload_0
    //   400: invokestatic 184	com/dataline/util/file/FileUtil:a	(Ljava/io/File;)V
    //   403: new 49	java/io/File
    //   406: dup
    //   407: getstatic 264	com/tencent/mobileqq/app/AppConstants:bg	Ljava/lang/String;
    //   410: invokespecial 179	java/io/File:<init>	(Ljava/lang/String;)V
    //   413: astore_0
    //   414: aload_0
    //   415: invokevirtual 255	java/io/File:exists	()Z
    //   418: ifeq +7 -> 425
    //   421: aload_0
    //   422: invokestatic 184	com/dataline/util/file/FileUtil:a	(Ljava/io/File;)V
    //   425: new 49	java/io/File
    //   428: dup
    //   429: getstatic 267	com/tencent/mobileqq/app/AppConstants:cn	Ljava/lang/String;
    //   432: invokespecial 179	java/io/File:<init>	(Ljava/lang/String;)V
    //   435: astore_0
    //   436: aload_0
    //   437: invokevirtual 255	java/io/File:exists	()Z
    //   440: ifeq +7 -> 447
    //   443: aload_0
    //   444: invokestatic 184	com/dataline/util/file/FileUtil:a	(Ljava/io/File;)V
    //   447: new 49	java/io/File
    //   450: dup
    //   451: getstatic 270	com/tencent/mobileqq/app/AppConstants:ck	Ljava/lang/String;
    //   454: invokespecial 179	java/io/File:<init>	(Ljava/lang/String;)V
    //   457: astore_0
    //   458: aload_0
    //   459: invokevirtual 255	java/io/File:exists	()Z
    //   462: ifeq +7 -> 469
    //   465: aload_0
    //   466: invokestatic 184	com/dataline/util/file/FileUtil:a	(Ljava/io/File;)V
    //   469: new 49	java/io/File
    //   472: dup
    //   473: new 30	java/lang/StringBuilder
    //   476: dup
    //   477: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   480: getstatic 273	com/tencent/mobileqq/app/AppConstants:aJ	Ljava/lang/String;
    //   483: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   486: ldc_w 275
    //   489: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   492: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   495: invokespecial 179	java/io/File:<init>	(Ljava/lang/String;)V
    //   498: astore_0
    //   499: aload_0
    //   500: invokevirtual 255	java/io/File:exists	()Z
    //   503: ifeq +7 -> 510
    //   506: aload_0
    //   507: invokestatic 184	com/dataline/util/file/FileUtil:a	(Ljava/io/File;)V
    //   510: new 49	java/io/File
    //   513: dup
    //   514: getstatic 278	com/tencent/mobileqq/app/AppConstants:bh	Ljava/lang/String;
    //   517: invokespecial 179	java/io/File:<init>	(Ljava/lang/String;)V
    //   520: astore_0
    //   521: aload_0
    //   522: invokevirtual 255	java/io/File:exists	()Z
    //   525: ifeq +7 -> 532
    //   528: aload_0
    //   529: invokestatic 184	com/dataline/util/file/FileUtil:a	(Ljava/io/File;)V
    //   532: new 49	java/io/File
    //   535: dup
    //   536: getstatic 281	com/tencent/mobileqq/app/AppConstants:bi	Ljava/lang/String;
    //   539: invokespecial 179	java/io/File:<init>	(Ljava/lang/String;)V
    //   542: astore_0
    //   543: aload_0
    //   544: invokevirtual 255	java/io/File:exists	()Z
    //   547: ifeq +7 -> 554
    //   550: aload_0
    //   551: invokestatic 184	com/dataline/util/file/FileUtil:a	(Ljava/io/File;)V
    //   554: new 49	java/io/File
    //   557: dup
    //   558: getstatic 284	com/tencent/mobileqq/app/AppConstants:bj	Ljava/lang/String;
    //   561: invokespecial 179	java/io/File:<init>	(Ljava/lang/String;)V
    //   564: astore_0
    //   565: aload_0
    //   566: invokevirtual 255	java/io/File:exists	()Z
    //   569: ifeq +7 -> 576
    //   572: aload_0
    //   573: invokestatic 184	com/dataline/util/file/FileUtil:a	(Ljava/io/File;)V
    //   576: new 49	java/io/File
    //   579: dup
    //   580: getstatic 287	com/tencent/mobileqq/app/AppConstants:bk	Ljava/lang/String;
    //   583: invokespecial 179	java/io/File:<init>	(Ljava/lang/String;)V
    //   586: astore_0
    //   587: aload_0
    //   588: invokevirtual 255	java/io/File:exists	()Z
    //   591: ifeq +7 -> 598
    //   594: aload_0
    //   595: invokestatic 184	com/dataline/util/file/FileUtil:a	(Ljava/io/File;)V
    //   598: new 49	java/io/File
    //   601: dup
    //   602: getstatic 290	com/tencent/mobileqq/app/AppConstants:bl	Ljava/lang/String;
    //   605: invokespecial 179	java/io/File:<init>	(Ljava/lang/String;)V
    //   608: astore_0
    //   609: aload_0
    //   610: invokevirtual 255	java/io/File:exists	()Z
    //   613: ifeq +7 -> 620
    //   616: aload_0
    //   617: invokestatic 184	com/dataline/util/file/FileUtil:a	(Ljava/io/File;)V
    //   620: new 49	java/io/File
    //   623: dup
    //   624: getstatic 293	com/tencent/mobileqq/app/AppConstants:cx	Ljava/lang/String;
    //   627: invokespecial 179	java/io/File:<init>	(Ljava/lang/String;)V
    //   630: astore_0
    //   631: aload_0
    //   632: invokevirtual 255	java/io/File:exists	()Z
    //   635: ifeq +7 -> 642
    //   638: aload_0
    //   639: invokestatic 184	com/dataline/util/file/FileUtil:a	(Ljava/io/File;)V
    //   642: invokestatic 296	com/tencent/mobileqq/vas/VasQuickUpdateManager:b	()V
    //   645: return
    //   646: astore_0
    //   647: invokestatic 301	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   650: ifeq -5 -> 645
    //   653: ldc_w 303
    //   656: iconst_2
    //   657: new 30	java/lang/StringBuilder
    //   660: dup
    //   661: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   664: ldc_w 305
    //   667: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   670: aload_0
    //   671: invokevirtual 308	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   674: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   677: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   680: invokestatic 311	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   683: return
    //   684: astore_0
    //   685: goto -436 -> 249
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	688	0	paramActivity	android.app.Activity
    //   0	688	1	paramQQAppInterface	QQAppInterface
    //   9	17	2	localIntent	Intent
    // Exception table:
    //   from	to	target	type
    //   0	60	646	java/lang/Exception
    //   64	73	646	java/lang/Exception
    //   73	125	646	java/lang/Exception
    //   129	140	646	java/lang/Exception
    //   140	144	646	java/lang/Exception
    //   148	159	646	java/lang/Exception
    //   159	163	646	java/lang/Exception
    //   167	178	646	java/lang/Exception
    //   178	182	646	java/lang/Exception
    //   186	197	646	java/lang/Exception
    //   249	336	646	java/lang/Exception
    //   340	344	646	java/lang/Exception
    //   344	369	646	java/lang/Exception
    //   369	381	646	java/lang/Exception
    //   381	403	646	java/lang/Exception
    //   403	425	646	java/lang/Exception
    //   425	447	646	java/lang/Exception
    //   447	469	646	java/lang/Exception
    //   469	510	646	java/lang/Exception
    //   510	532	646	java/lang/Exception
    //   532	554	646	java/lang/Exception
    //   554	576	646	java/lang/Exception
    //   576	598	646	java/lang/Exception
    //   598	620	646	java/lang/Exception
    //   620	642	646	java/lang/Exception
    //   642	645	646	java/lang/Exception
    //   197	249	684	java/lang/Exception
  }
  
  static void a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface.getApp() == null) {
      return;
    }
    BaseApplication.getContext().getPackageName();
    c(Utils.a(BaseApplication.getContext()) + "thumbnails/");
  }
  
  private void a(DownloadTask paramDownloadTask)
  {
    if ((paramDownloadTask.a == 0) && (this.app != null))
    {
      this.app.getPreferences().edit().putLong("chatHistoryEventJsonLastModified", paramDownloadTask.i).commit();
      if ((200 == paramDownloadTask.e) || (304 == paramDownloadTask.e)) {
        ThreadManager.getFileThreadHandler().post(new tkb(this));
      }
    }
    if (QLog.isColorLevel())
    {
      File localFile = new File(jdField_c_of_type_JavaLangString);
      long l = 0L;
      if (localFile.exists()) {
        l = localFile.lastModified();
      }
      QLog.d("IphoneTitleBarActivity", 2, "onDone status=" + paramDownloadTask.a() + ",errCode=" + paramDownloadTask.a + ",httpCode=" + paramDownloadTask.e + ",local lastModify=" + l + ",server lastModify=" + paramDownloadTask.i);
    }
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {
      c(AppConstants.aJ + paramString + "/" + "photo/");
    }
    int i = 0;
    while (i < CardHandler.jdField_a_of_type_JavaUtilVector.size())
    {
      c(CardHandler.jdField_a_of_type_JavaLangString + ((Integer)CardHandler.jdField_a_of_type_JavaUtilVector.get(i)).intValue() + "/");
      i += 1;
    }
    c(CardHandler.jdField_a_of_type_JavaLangString + "background" + "/");
    c(AppConstants.aJ + "temp" + "/");
    c(CardHandler.jdField_a_of_type_JavaLangString + "temp" + "/");
    c(CardHandler.jdField_a_of_type_JavaLangString + "HDAvatar" + "/");
    c(AppConstants.bV);
    c(CardHandler.jdField_a_of_type_JavaLangString + "voice" + "/");
    c(GCCommon.a() + "/");
    c(AppConstants.ch);
    c(HotPicDownLoader.jdField_a_of_type_JavaLangString);
    c(HotVideoPreviewDownloader.jdField_a_of_type_JavaLangString);
    c(ScribbleMsgUtils.jdField_a_of_type_JavaLangString);
  }
  
  private static void b(QQAppInterface paramQQAppInterface)
  {
    if (URLDrawableHelper.a != null)
    {
      c(URLDrawableHelper.a.getAbsolutePath());
      if ((paramQQAppInterface.getApp() instanceof BaseApplicationImpl))
      {
        BaseApplicationImpl.getApplication();
        if (BaseApplicationImpl.sImageCache != null)
        {
          BaseApplicationImpl.getApplication();
          BaseApplicationImpl.sImageCache.evictAll();
        }
      }
    }
  }
  
  static void c()
  {
    c(AppConstants.aJ + "photo/");
  }
  
  private static void c(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = paramQQAppInterface.getManager(9);
    if (paramQQAppInterface == null) {}
    while (!(paramQQAppInterface instanceof QZoneManagerImp)) {
      return;
    }
    ((QZoneManagerImp)paramQQAppInterface).a = null;
  }
  
  private static void c(String paramString)
  {
    paramString = new File(paramString);
    if (paramString != null)
    {
      paramString = paramString.listFiles();
      if (paramString != null)
      {
        int i = 0;
        while (i < paramString.length)
        {
          paramString[i].delete();
          i += 1;
        }
      }
    }
  }
  
  private void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131371206));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
    ThreadManager.getSubThreadHandler().post(new tjz(this));
  }
  
  private void g()
  {
    int i = this.app.getApplication().getSharedPreferences("vip_message_roam_banner_file", 0).getInt("message_roam_flag" + this.app.getCurrentAccountUin(), 0);
    Object localObject = null;
    switch (i)
    {
    default: 
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText((CharSequence)localObject);
      }
      break;
    }
    while (!QLog.isColorLevel())
    {
      return;
      localObject = getResources().getString(2131433852);
      break;
      localObject = getResources().getString(2131433851);
      break;
      localObject = getResources().getString(2131433850);
      break;
      localObject = getResources().getString(2131433849);
      break;
    }
    QLog.d("QQSettingMsgHistoryActivity", 2, "messge roam flag is error ,is : " + i);
  }
  
  private void h()
  {
    c(AppConstants.aJ + this.d + "/" + "ptt/");
  }
  
  private void i()
  {
    try
    {
      this.app.a().f();
      this.app.a().h();
      this.app.a().i();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  private void j()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem == null) || (this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.getVisibility() == 8)) {}
    RedTouchManager localRedTouchManager;
    BusinessInfoCheckUpdate.AppInfo localAppInfo;
    do
    {
      return;
      localRedTouchManager = (RedTouchManager)this.app.getManager(35);
      localAppInfo = localRedTouchManager.a("100190.100194.100195");
    } while (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch == null);
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.a(localAppInfo);
    localRedTouchManager.a(localAppInfo);
  }
  
  private void k()
  {
    Intent localIntent = getIntent();
    if ((localIntent != null) && (localIntent.hasExtra("set_display_type"))) {}
    for (int i = localIntent.getIntExtra("set_display_type", 0);; i = 0)
    {
      if (i == 2)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        setTitle(2131435403);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      setTitle(2131436806);
      return;
    }
  }
  
  public void a()
  {
    this.app.a().h();
    a(this.d, true);
    h();
    c();
    i();
    b(this.app);
    b();
    MqqHandler localMqqHandler = this.app.getHandler(Conversation.class);
    if (localMqqHandler != null) {
      localMqqHandler.sendEmptyMessage(1009);
    }
  }
  
  void a(String paramString)
  {
    if (this.app.getPreferences().getBoolean("chatHistoryEventEntryFirstShow", true))
    {
      ThreadManager.getSubThreadHandler().post(new tjt(this));
      GuideViewBuilder localGuideViewBuilder = new GuideViewBuilder(this);
      localGuideViewBuilder.a(this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem, 0);
      localGuideViewBuilder.a(0, new tjx(this));
      DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
      View localView = new View(this);
      localView.setBackgroundResource(2130842770);
      GuideViewBuilder.GuideLayoutParams localGuideLayoutParams1 = new GuideViewBuilder.GuideLayoutParams((int)(17.0F * localDisplayMetrics.density), (int)(31.0F * localDisplayMetrics.density), 48);
      localGuideLayoutParams1.a = 100;
      localGuideLayoutParams1.b = (this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.getMeasuredHeight() + 18);
      TextView localTextView = new TextView(this);
      GuideViewBuilder.GuideLayoutParams localGuideLayoutParams2 = new GuideViewBuilder.GuideLayoutParams(-2, -2, 48);
      localTextView.setText(paramString);
      localTextView.setTextColor(-1);
      localTextView.setTextSize(2, 16.0F);
      localTextView.setGravity(17);
      localTextView.setMaxWidth((int)(localDisplayMetrics.density * 240.0F));
      localGuideLayoutParams2.a = 50;
      localGuideLayoutParams2.b = (localGuideLayoutParams1.b + localGuideLayoutParams1.height + 18);
      localGuideViewBuilder.a(0, localView, localGuideLayoutParams1);
      localGuideViewBuilder.a(0, localTextView, localGuideLayoutParams2);
      localGuideViewBuilder.a(new tjy(this));
    }
  }
  
  void b()
  {
    MessageRoamManager localMessageRoamManager = (MessageRoamManager)this.app.getManager(91);
    localMessageRoamManager.i();
    localMessageRoamManager.b();
  }
  
  void b(String paramString)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
    }
    this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCancelable(true);
    this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(paramString);
    this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
  
  public void d()
  {
    ((RedTouchManager)this.app.getManager(35)).b("100190.100194.100195");
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      Intent localIntent = new Intent(this, QQBrowserActivity.class);
      localIntent.putExtra("url", this.jdField_a_of_type_JavaLangString);
      startActivity(localIntent);
      VipUtils.a(this.app, "chat_history", "Setting_tab", "Clk_ChatHistoryRed", 0, 0, null);
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2130970569);
    this.d = this.app.getCurrentAccountUin();
    setVolumeControlStream(3);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131371207));
    paramBundle = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
    boolean bool;
    if (this.app.e() == 1)
    {
      bool = true;
      paramBundle.setChecked(bool);
      this.jdField_a_of_type_AndroidViewView = findViewById(2131371211);
      this.jdField_b_of_type_AndroidViewView = findViewById(2131371212);
      this.jdField_c_of_type_AndroidViewView = findViewById(2131371213);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131371208));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131371209));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
      findViewById(2131371210).setOnClickListener(this);
      this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
      this.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      if (!JumpQqPimSecureUtil.a(this)) {
        break label268;
      }
      VipUtils.a(this.app, "Safe_SpaceClean", "SpaceClean_", "enter_MsgHistory_had_installed_secure", 0, 0, null);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewView.setContentDescription(getString(2131435388));
      this.jdField_b_of_type_AndroidViewView.setContentDescription(getString(2131435390));
      this.jdField_c_of_type_AndroidViewView.setContentDescription(getString(2131435391));
      k();
      return true;
      bool = false;
      break;
      label268:
      VipUtils.a(this.app, "Safe_SpaceClean", "SpaceClean_", "enter_MsgHistory_had_not_intalled_secure", 0, 0, null);
    }
  }
  
  protected void doOnDestroy()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      dismissDialog(1);
    }
    super.doOnDestroy();
    this.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
  }
  
  protected void doOnPostResume()
  {
    super.doOnPostResume();
    if (this.jdField_a_of_type_Boolean) {
      f();
    }
  }
  
  protected void doOnResume()
  {
    j();
    super.doOnResume();
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    g();
  }
  
  public void e()
  {
    try
    {
      if (this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog != null)
      {
        this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
        this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.cancel();
        this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    boolean bool = false;
    int j = 1;
    if (!NetworkUtil.d(this.app.getApplication().getApplicationContext()))
    {
      QQToast.a(getApplicationContext(), 2131434794, 1).a();
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(null);
      paramCompoundButton = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
      paramBoolean = bool;
      if (this.app.e() == 1) {
        paramBoolean = true;
      }
      paramCompoundButton.setChecked(paramBoolean);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
      return;
    }
    paramCompoundButton = this.app;
    if (paramBoolean)
    {
      i = 1;
      ReportController.b(paramCompoundButton, "CliOper", "", "", "Setting_tab", "Latest_chatlog_syn", 0, i, "0", "0", "", "");
      b(getApplication().getResources().getString(2131436208));
      if (!paramBoolean) {
        break label158;
      }
    }
    label158:
    for (int i = j;; i = 0)
    {
      this.app.g(i);
      return;
      i = 0;
      break;
    }
  }
  
  public void onClick(View paramView)
  {
    Intent localIntent = null;
    int j = 0;
    if (paramView.getId() == 2131371208)
    {
      localIntent = new Intent(this, QQBrowserActivity.class);
      paramView = IndividuationUrlHelper.a("vipRoamChatCell");
      if (TextUtils.isEmpty(paramView)) {
        QLog.e("IphoneTitleBarActivity", 1, "gotoRoamMessageSettingUrl ! url empty");
      }
    }
    long l1;
    long l2;
    do
    {
      return;
      if (paramView.contains("?")) {}
      for (paramView = paramView + "&ADTAG=msgRoam";; paramView = paramView + "?ADTAG=msgRoam")
      {
        localIntent.putExtra("url", paramView);
        startActivity(localIntent);
        VipUtils.a(this.app, "chat_history", "ChatHistory", "Clk_RoamMsgSetting", 2, 0, new String[] { "0", "0", "msgRoam" });
        return;
      }
      if (paramView.getId() == 2131371206)
      {
        d();
        return;
      }
      if (paramView.getId() == 2131371210)
      {
        paramView = new Intent(getApplicationContext(), FMActivity.class);
        paramView.putExtra("selectMode", true);
        paramView.putExtra("targetUin", AppConstants.y);
        paramView.putExtra("tab_tab_type", 8);
        paramView.putExtra("only_show_local_tab", true);
        paramView.putExtra("max_select_count", 999999);
        startActivity(paramView);
        overridePendingTransition(2131034123, 2131034124);
        FileManagerReporter.a("0x80087C4");
        return;
      }
      l1 = System.currentTimeMillis();
      l2 = this.jdField_a_of_type_Long;
    } while ((isFinishing()) || (l1 - l2 < 500L));
    this.jdField_a_of_type_Long = l1;
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
    int i;
    switch (paramView.getId())
    {
    default: 
      i = 0;
      paramView = localIntent;
    }
    for (;;)
    {
      localActionSheet.a(i, 3);
      localActionSheet.d(getString(2131432998));
      localActionSheet.a(paramView);
      localActionSheet.a(j);
      localActionSheet.show();
      return;
      i = 2131435388;
      j = 2131435419;
      paramView = new tke(this, localActionSheet);
      continue;
      i = 2131435390;
      j = 2131435418;
      paramView = new tkg(this, localActionSheet);
      continue;
      i = 2131435389;
      j = 2131436808;
      paramView = new tju(this, localActionSheet);
    }
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return super.onCreateDialog(paramInt);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(getString(2131434028));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(true);
    return this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  }
  
  public void onGlobalLayout()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      a(this.jdField_b_of_type_JavaLangString);
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  protected String setLastActivityName()
  {
    return getString(2131433632);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQSettingMsgHistoryActivity
 * JD-Core Version:    0.7.0.1
 */