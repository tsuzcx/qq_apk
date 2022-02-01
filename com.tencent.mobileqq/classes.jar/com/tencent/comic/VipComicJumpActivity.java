package com.tencent.comic;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.widget.TextView;
import com.tencent.comic.api.IQQComicConfigApi;
import com.tencent.comic.api.IQQComicRedTouchService;
import com.tencent.comic.api.IQQComicUtil;
import com.tencent.comic.api.IQQDcReporter;
import com.tencent.comic.api.IQQPluginPreloadService;
import com.tencent.comic.api.impl.QQPluginPreloadServiceImpl;
import com.tencent.comic.config.QQComicConfBean;
import com.tencent.comic.data.BoodoHippyConfig;
import com.tencent.comic.data.VipComicDataHelper;
import com.tencent.comic.emoticon.VipComicEmoticonUploadRemoteCmd;
import com.tencent.comic.hippy.BoodoHippyBirdge;
import com.tencent.comic.hippy.VipComicMainHippyFragment;
import com.tencent.comic.utils.AppHelper;
import com.tencent.comic.utils.QQComicPluginBridge;
import com.tencent.comic.utils.VipComicUrlHelper;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.hippy.qq.api.IHippyAccessHelper;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.hippy.qq.utils.SerializableMap;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QIphoneTitleBarActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.emosm.api.IEmoticonBusinessProxyApi;
import com.tencent.mobileqq.emosm.vipcomic.IVipComicMqqHandler;
import com.tencent.mobileqq.hitrate.PreloadProcHitPluginSession;
import com.tencent.mobileqq.leba.ILebaHelperService;
import com.tencent.mobileqq.leba.entity.LebaPluginInfo;
import com.tencent.mobileqq.leba.entity.LebaViewItem;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.module.IQRoutePlugin;
import com.tencent.mobileqq.qroute.module.QRoutePluginInfo;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.redtouch.RedAppInfo;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.vas.api.IIndividuationUrlApi;
import com.tencent.mobileqq.vas.api.IVasSingedApi;
import com.tencent.mobileqq.vip.IVipStatusManager;
import com.tencent.mobileqq.webview.api.IWebProcessManagerService;
import com.tencent.mobileqq.webview.swift.WebViewTabBarData;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.StringBuilderUtils;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.immersive.ImmersiveUtils;
import eipc.EIPCClient;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@RoutePage(desc="动漫插件", path="/base/vipcomic")
public class VipComicJumpActivity
  extends QIphoneTitleBarActivity
  implements Handler.Callback
{
  public static final String CATEGORY_TAB_TAG = "category";
  public static final String FAV_TAB_TAG = "fav";
  public static final int FROM_BANNER_BAR = 20;
  public static final int FROM_LEBA = 1006002;
  public static final int FROM_LEBA_MGR = 1006003;
  public static final int FROM_PA = 5;
  public static final int FROM_TIPS_BAR = 19;
  public static final String GROUP_TAB_TAG = "group";
  public static final String HIPPY_FRAGMENT = "com.tencent.hippy.qq.fragment.CommonHippyFragment";
  public static final String HOME_TAB_TAG = "index";
  static final String INTENT_KEY_FLAG_FROM_BANNER = "banner_fromBanner";
  private static final int KEY_COMIC_CLOSE = 1;
  private static final int KEY_COMIC_CONFIG = 0;
  private static final String KEY_COMIC_HIPPY_PRELOAD_SWITCH = "keyComicHippyPreloadSwitch";
  private static final String KEY_COMIC_HIPPY_SWITCH = "keyComicHippySwitch";
  private static final int KEY_COMIC_OPEN = 2;
  private static final String KEY_COMIC_READER_SWITCH = "keyComicReaderSwitch";
  private static String KEY_ENV_SWITCH = "envSwitch";
  public static final int LAUNCH_ACTIVITY = 1000;
  static final String MAIN_ACTIVITY = "com.qqcomic.activity.VipComicMainTabActivity";
  static final String MEDIA_ACTIVITY = "com.qqcomic.activity.media.VipComicMediaPlayActivity";
  public static final String MORE_TAB_TAG = "more";
  public static final int MSG_CODE_HIPPY_START_TIMEOUT = 1002;
  public static final int MSG_COMIC_BAR_HIDE = 1134040;
  public static final String NAME = "com.tencent.comic.VipComicJumpActivity";
  public static final String PROCESS_NAME = "com.tencent.mobileqq:tool";
  static final String READER_ACTIVITY = "com.qqcomic.activity.reader.VipComicPortraitReadingActivity";
  static final String READER_ACTIVITY_2 = "com.qqcomic.reader.VipComicReadingActivityV2";
  static final String TAG = "VipComicJumpActivity";
  public static final int UPDATE_PROGRESS = 1001;
  static final String WEB_ACTIVITY = "com.qqcomic.activity.VipComicTabBrowserActivity";
  long downloadTime = 0L;
  long installTime = 0L;
  volatile boolean isPrePluginProcess = false;
  boolean isPrePluginTimeOut = false;
  long launchTime = 0L;
  TextView loadingMsg;
  TextView loadingProgress;
  private boolean mDestroy;
  public WeakReferenceHandler mHandler;
  boolean mIsQQComicRunning = false;
  private boolean mLuanchHippyFlag;
  VipComicJumpActivity.ComicParam mParam = null;
  BroadcastReceiver mReceiver = null;
  
  public static String buildUrl(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    StringBuilder localStringBuilder = StringBuilderUtils.a();
    if (!TextUtils.isEmpty(paramString7)) {
      localStringBuilder.append(paramString7);
    }
    if ((!TextUtils.isEmpty(paramString2)) && (!paramString1.contains("_wv=")))
    {
      localStringBuilder.append("&_wv=");
      localStringBuilder.append(paramString2);
    }
    if ((!TextUtils.isEmpty(paramString3)) && (!paramString1.contains("_wwv=")))
    {
      localStringBuilder.append("&_wwv=");
      localStringBuilder.append(paramString3);
    }
    if ((!TextUtils.isEmpty(paramString4)) && (!paramString1.contains("_cwv=")))
    {
      localStringBuilder.append("&_cwv=");
      localStringBuilder.append(paramString4);
    }
    if ((!TextUtils.isEmpty(paramString5)) && (!paramString1.contains("_sonic_id=")) && (!paramString1.contains("_bid=")))
    {
      localStringBuilder.append("&_bid=");
      localStringBuilder.append(paramString5);
    }
    if ((!TextUtils.isEmpty(paramString6)) && (!paramString1.contains("channel=")))
    {
      localStringBuilder.append("&channel=");
      localStringBuilder.append(paramString6);
    }
    if ((localStringBuilder.length() > 0) && (localStringBuilder.charAt(0) == '&')) {
      localStringBuilder.deleteCharAt(0);
    }
    return VipComicUrlHelper.a(paramString1, localStringBuilder.toString());
  }
  
  private static void checkBoodoPlugin(AppRuntime paramAppRuntime, Activity paramActivity, VipComicJumpActivity.ComicParam paramComicParam)
  {
    VipComicJumpActivity.LoadingCondition localLoadingCondition = new VipComicJumpActivity.LoadingCondition();
    BoodoHippyBirdge.checkPluginInstall(paramActivity, new VipComicJumpActivity.3(localLoadingCondition, paramActivity, paramComicParam));
    if (!isToolProcessExist())
    {
      showHippyLoading(paramActivity, localLoadingCondition);
      paramAppRuntime = (IWebProcessManagerService)paramAppRuntime.getRuntimeService(IWebProcessManagerService.class, "multi");
      if (paramAppRuntime != null) {
        paramAppRuntime.startWebProcess(-1, null);
      }
    }
    else
    {
      try
      {
        try
        {
          localLoadingCondition.wait(300L);
        }
        finally {}
        if (!QLog.isColorLevel()) {
          return;
        }
      }
      catch (InterruptedException paramAppRuntime)
      {
        QLog.e("VipComicJumpActivity", 1, paramAppRuntime, new Object[0]);
        showHippyLoading(paramActivity, localLoadingCondition);
      }
    }
    QLog.d("VipComicJumpActivity", 1, new Object[] { "checkBoodoPlugin showLoadingDialog loadingCondition.mNeedLaunch:", Boolean.valueOf(localLoadingCondition.jdField_a_of_type_Boolean) });
  }
  
  private static boolean checkJumpFromLaunch(AppRuntime paramAppRuntime, Activity paramActivity, VipComicJumpActivity.ComicParam paramComicParam, boolean paramBoolean)
  {
    if ((paramComicParam.jdField_a_of_type_Int == 12) && (paramBoolean))
    {
      if (checkJumpHippy(paramAppRuntime, paramActivity, paramComicParam)) {
        return true;
      }
      if (checkRestoreActivity(paramActivity)) {
        return true;
      }
    }
    return false;
  }
  
  private static boolean checkJumpHippy(AppRuntime paramAppRuntime, Activity paramActivity, VipComicJumpActivity.ComicParam paramComicParam)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("QQComicConfBean.getHippyConfig().mHippyStatus:");
    ((StringBuilder)localObject).append(QQComicConfBean.a().mHippyStatus);
    QLog.i("VipComicJumpActivity", 1, ((StringBuilder)localObject).toString());
    localObject = getHippyConfig();
    if ((localObject != null) && (((BoodoHippyConfig)localObject).mHippyStatus == 0)) {
      return false;
    }
    ThreadManagerV2.excute(new VipComicJumpActivity.1(paramAppRuntime, paramActivity, paramComicParam), 16, null, false);
    return true;
  }
  
  private static boolean checkJumpMainActivity(AppRuntime paramAppRuntime, Activity paramActivity, VipComicJumpActivity.ComicParam paramComicParam)
  {
    updateRedAppInfo(paramAppRuntime, paramComicParam);
    if (checkJumpHippy(paramAppRuntime, paramActivity, paramComicParam)) {
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQComicDebug", 2, "handle param parse red touch end");
    }
    if (paramComicParam.jdField_i_of_type_Boolean)
    {
      paramAppRuntime = VipComicUrlHelper.a(paramComicParam.n, "returnIndex=true");
      Intent localIntent = new Intent();
      localIntent.putExtra("url", paramAppRuntime);
      localIntent.putExtra("reportSourceFrom", paramComicParam.jdField_a_of_type_Int);
      localIntent.putExtra("startOpenPageTime", paramComicParam.jdField_a_of_type_Long);
      VipComicHelper.a(paramActivity, localIntent, -1);
      if (QLog.isColorLevel())
      {
        paramActivity = new StringBuilder();
        paramActivity.append("jump to comic activity page directly, url=");
        paramActivity.append(paramAppRuntime);
        QLog.d("VipComicJumpActivity", 2, paramActivity.toString());
      }
      return true;
    }
    luanchMainTabActivity(paramActivity, paramComicParam);
    ((IQQComicUtil)QRoute.api(IQQComicUtil.class)).reportClickEventTo644(null, "VIPCOMIC", "0X8005FC8", "0X8005FC8", paramComicParam.jdField_a_of_type_Int, 0, new String[] { String.valueOf(System.currentTimeMillis() - paramComicParam.jdField_b_of_type_Long) });
    if (QLog.isColorLevel()) {
      QLog.d("QQComicDebug", 2, "handle param open main tab end");
    }
    return true;
  }
  
  private static void checkMod(HashMap<String, String> paramHashMap, VipComicJumpActivity.ComicParam paramComicParam)
  {
    if (!TextUtils.isEmpty(paramComicParam.jdField_a_of_type_JavaLangString))
    {
      paramComicParam = paramComicParam.jdField_a_of_type_JavaLangString;
    }
    else if (!TextUtils.isEmpty(paramComicParam.l))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("veb_red_");
      localStringBuilder.append(paramComicParam.l);
      paramComicParam = localStringBuilder.toString();
    }
    else if (paramComicParam.jdField_a_of_type_Int != 1006002)
    {
      paramComicParam = paramComicParam.jdField_b_of_type_JavaLangString;
    }
    else
    {
      paramComicParam = "";
    }
    paramHashMap.put("mod", paramComicParam);
  }
  
  private static boolean checkRestoreActivity(Activity paramActivity)
  {
    Object localObject = paramActivity.getSharedPreferences("vip_comic_file", 4);
    if (((SharedPreferences)localObject).getBoolean("restore_flag", false))
    {
      String str1 = ((SharedPreferences)localObject).getString("base_package", "");
      String str2 = ((SharedPreferences)localObject).getString("base_activity", "");
      int i = ((SharedPreferences)localObject).getInt("activity_task_id", -1);
      localObject = ((ActivityManager)paramActivity.getApplication().getApplicationContext().getSystemService("activity")).getRunningTasks(100);
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          ActivityManager.RunningTaskInfo localRunningTaskInfo = (ActivityManager.RunningTaskInfo)((Iterator)localObject).next();
          if ((localRunningTaskInfo.baseActivity.getClassName().equals(str2)) && (i == localRunningTaskInfo.id))
          {
            i = 1;
            break label164;
          }
        }
        i = 0;
        label164:
        if (i != 0)
        {
          localObject = new Intent();
          ((Intent)localObject).setComponent(new ComponentName(str1, str2));
          ((Intent)localObject).addFlags(269500416);
          ((Intent)localObject).putExtra("big_brother_source_key", "biz_src_zz_bodong");
          try
          {
            paramActivity.startActivity((Intent)localObject);
            if (QLog.isColorLevel()) {
              QLog.d("QQComicDebug", 2, "handle param restore stack end");
            }
            return true;
          }
          catch (Exception paramActivity)
          {
            paramActivity.printStackTrace();
          }
        }
      }
    }
    return false;
  }
  
  private static String contactReddotIds(List<String> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramList.size())
    {
      if (i != 0) {
        localStringBuilder.append("_");
      }
      localStringBuilder.append((String)paramList.get(i));
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  private static String getAdId(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(paramString.optInt("ad_id"));
      paramString = localStringBuilder.toString();
      return paramString;
    }
    catch (Exception paramString)
    {
      QLog.e("VipComicJumpActivity", 1, "getAdId error", paramString);
    }
    return "";
  }
  
  public static Intent getBackgroundQQComicIntent(AppRuntime paramAppRuntime, VipComicJumpActivity.ComicParam paramComicParam)
  {
    if ((paramAppRuntime != null) && (paramComicParam != null))
    {
      updateRedAppInfo(paramAppRuntime, paramComicParam);
      if (QLog.isColorLevel()) {
        QLog.d("QQComicDebug", 2, "[getBackgroundQQComicIntent] handle param parse red touch end");
      }
      paramAppRuntime = new ArrayList();
      Object localObject1 = new WebViewTabBarData();
      Object localObject2 = HardCodeUtil.a(1996881929);
      ((WebViewTabBarData)localObject1).tag = ((String)localObject2);
      ((WebViewTabBarData)localObject1).tabName = ((String)localObject2);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("_cfrom=");
      ((StringBuilder)localObject2).append(paramComicParam.jdField_a_of_type_Int);
      ((StringBuilder)localObject2).append("&hasRedDot=");
      ((StringBuilder)localObject2).append(paramComicParam.a("index"));
      ((WebViewTabBarData)localObject1).url = getUrl("comicIndex", null, "64", "5", "354", null, ((StringBuilder)localObject2).toString());
      localObject2 = new WebViewTabBarData();
      Object localObject3 = HardCodeUtil.a(1996881932);
      ((WebViewTabBarData)localObject2).tag = ((String)localObject3);
      ((WebViewTabBarData)localObject2).tabName = ((String)localObject3);
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("_cfrom=");
      ((StringBuilder)localObject3).append(paramComicParam.jdField_a_of_type_Int);
      ((StringBuilder)localObject3).append("&hasRedDot=");
      ((StringBuilder)localObject3).append(paramComicParam.a("fav"));
      ((WebViewTabBarData)localObject2).url = getUrl("comicFav", null, null, "1", "354", "%7B%22tabNum%22%3A2%2C%22subTextArray%22%3A%5B%22%E6%94%B6%E8%97%8F%22%2C%22%E4%B8%8B%E8%BD%BD%22%5D%7D", ((StringBuilder)localObject3).toString());
      localObject3 = new WebViewTabBarData();
      Object localObject4 = HardCodeUtil.a(1996881927);
      ((WebViewTabBarData)localObject3).tag = ((String)localObject4);
      ((WebViewTabBarData)localObject3).tabName = ((String)localObject4);
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("_cfrom=");
      ((StringBuilder)localObject4).append(paramComicParam.jdField_a_of_type_Int);
      ((StringBuilder)localObject4).append("&hasRedDot=");
      ((StringBuilder)localObject4).append(paramComicParam.a("category"));
      ((WebViewTabBarData)localObject3).url = getUrl("comicCategory", null, null, "1", "354", null, ((StringBuilder)localObject4).toString());
      localObject4 = new WebViewTabBarData();
      Object localObject5 = HardCodeUtil.a(1996881931);
      ((WebViewTabBarData)localObject4).tag = ((String)localObject5);
      ((WebViewTabBarData)localObject4).tabName = ((String)localObject5);
      localObject5 = new StringBuilder();
      ((StringBuilder)localObject5).append("_cfrom=");
      ((StringBuilder)localObject5).append(paramComicParam.jdField_a_of_type_Int);
      ((StringBuilder)localObject5).append("&hasRedDot=");
      ((StringBuilder)localObject5).append(paramComicParam.a("more"));
      ((WebViewTabBarData)localObject4).url = getUrl("comicMore", null, null, "1", "354", null, ((StringBuilder)localObject5).toString());
      localObject5 = new WebViewTabBarData();
      Object localObject6 = HardCodeUtil.a(1996881930);
      ((WebViewTabBarData)localObject5).tag = ((String)localObject6);
      ((WebViewTabBarData)localObject5).tabName = ((String)localObject6);
      localObject6 = new StringBuilder();
      ((StringBuilder)localObject6).append("_cfrom=");
      ((StringBuilder)localObject6).append(paramComicParam.jdField_a_of_type_Int);
      ((StringBuilder)localObject6).append("&hasRedDot=");
      ((StringBuilder)localObject6).append(paramComicParam.a("group"));
      ((WebViewTabBarData)localObject5).url = getUrl("comicGroup", null, null, "1", "354", null, ((StringBuilder)localObject6).toString());
      paramAppRuntime.add(localObject1);
      paramAppRuntime.add(localObject2);
      paramAppRuntime.add(localObject3);
      paramAppRuntime.add(localObject4);
      paramAppRuntime.add(localObject5);
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("tabConfigData", paramAppRuntime);
      ((Intent)localObject1).putExtra("reportSourceFrom", paramComicParam.jdField_a_of_type_Int);
      ((Intent)localObject1).putExtra("startOpenPageTime", paramComicParam.jdField_a_of_type_Long);
      ((Intent)localObject1).setFlags(((Intent)localObject1).getFlags() | 0x4000000 | 0x10000000);
      ((Intent)localObject1).putExtra("fragmentStyle", 1);
      ((Intent)localObject1).putExtra("tabBarStyle", 1);
      ((Intent)localObject1).putExtra("titleBarStyle", 1);
      ((Intent)localObject1).putExtra("hide_operation_bar", true);
      ((Intent)localObject1).putExtra("hide_more_button", true);
      ((Intent)localObject1).putExtra("isScreenOrientationPortrait", true);
      if (QLog.isColorLevel()) {
        QLog.d("QQComicDebug", 2, "[getBackgroundQQComicIntent] finish");
      }
      return localObject1;
    }
    return null;
  }
  
  private static BoodoHippyConfig getHippyConfig()
  {
    if (MobileQQ.sProcessId == 1) {
      return QQComicConfBean.a();
    }
    return VipComicDataHelper.a;
  }
  
  public static int getIndexByTag(String paramString, List<WebViewTabBarData> paramList)
  {
    int i = 0;
    while (i < paramList.size())
    {
      if (((WebViewTabBarData)paramList.get(i)).tag.equals(paramString)) {
        return i;
      }
      i += 1;
    }
    return 0;
  }
  
  @Nullable
  private PreloadProcHitPluginSession getPreloadProcHitPluginSession(VipComicJumpActivity.ComicParam paramComicParam, Intent paramIntent)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private static String getRedPointMsg(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).optString("msg");
      return paramString;
    }
    catch (Exception paramString)
    {
      QLog.e("VipComicJumpActivity", 1, "getRedPointMsg error", paramString);
    }
    return "";
  }
  
  private static String getShowMissionId(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).optString("_show_mission");
      return paramString;
    }
    catch (Exception paramString)
    {
      QLog.e("VipComicJumpActivity", 1, "getShowMissionId error", paramString);
    }
    return "";
  }
  
  public static String getUrl(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    String str2 = (String)((IIndividuationUrlApi)QRoute.api(IIndividuationUrlApi.class)).getUrlMap().get(paramString1);
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = VipComicUrlHelper.a(paramString1);
    }
    return buildUrl(str1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7);
  }
  
  private void handleFromRemoteReceive(Intent paramIntent)
  {
    if (paramIntent.getBooleanExtra("from_launch_hippy", false))
    {
      finish();
      return;
    }
    if (!this.isPrePluginProcess)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQComicDebug", 2, "do handle launch activity in receiver.");
      }
      this.mHandler.removeMessages(1000);
      this.isPrePluginProcess = true;
      this.isPrePluginTimeOut = false;
      launch(this.mParam);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQComicDebug", 2, "skip handle launch activity in receiver.");
    }
  }
  
  private static void handleJsonParam(VipComicJumpActivity.ComicParam paramComicParam, JSONObject paramJSONObject)
  {
    paramComicParam.jdField_e_of_type_JavaLangString = paramJSONObject.optString("jumpto", "com.qqcomic.activity.VipComicMainTabActivity");
    boolean bool = false;
    paramComicParam.jdField_a_of_type_Int = paramJSONObject.optInt("from", 0);
    paramComicParam.jdField_b_of_type_JavaLangString = paramJSONObject.optString("from");
    paramComicParam.jdField_a_of_type_JavaLangString = paramJSONObject.optString("mod");
    paramComicParam.jdField_d_of_type_JavaLangString = paramJSONObject.optString("referer");
    paramComicParam.jdField_e_of_type_Boolean = (paramJSONObject.optBoolean("newInstance") ^ true);
    if (paramJSONObject.has("url")) {
      paramComicParam.jdField_f_of_type_JavaLangString = paramJSONObject.optString("url");
    }
    try
    {
      paramComicParam.jdField_f_of_type_JavaLangString = URLDecoder.decode(paramComicParam.jdField_f_of_type_JavaLangString);
    }
    catch (Exception localException)
    {
      label108:
      break label108;
    }
    if (VipComicHelper.a(paramComicParam.jdField_f_of_type_JavaLangString, paramComicParam.jdField_a_of_type_AndroidContentIntent)) {
      paramComicParam.jdField_e_of_type_JavaLangString = "com.qqcomic.activity.media.VipComicMediaPlayActivity";
    }
    if (paramJSONObject.has("comic")) {}
    try
    {
      JSONObject localJSONObject = new JSONObject(paramJSONObject.optString("comic"));
      paramComicParam.jdField_a_of_type_ComTencentComicVipComicJumpActivity$ComicInfo = new VipComicJumpActivity.ComicInfo();
      paramComicParam.jdField_a_of_type_ComTencentComicVipComicJumpActivity$ComicInfo.jdField_a_of_type_JavaLangString = localJSONObject.optString("comicID");
      paramComicParam.jdField_a_of_type_ComTencentComicVipComicJumpActivity$ComicInfo.jdField_b_of_type_JavaLangString = localJSONObject.optString("comicSectionID");
      paramComicParam.jdField_a_of_type_ComTencentComicVipComicJumpActivity$ComicInfo.jdField_c_of_type_JavaLangString = localJSONObject.optString("comicPageID");
      paramComicParam.jdField_a_of_type_ComTencentComicVipComicJumpActivity$ComicInfo.jdField_a_of_type_Int = localJSONObject.optInt("comicPageOffset");
      paramComicParam.jdField_a_of_type_ComTencentComicVipComicJumpActivity$ComicInfo.jdField_b_of_type_Int = localJSONObject.optInt("type");
      paramComicParam.jdField_a_of_type_Boolean = localJSONObject.optBoolean("returnToDetail");
      paramComicParam.jdField_a_of_type_ComTencentComicVipComicJumpActivity$ComicInfo.jdField_c_of_type_Int = localJSONObject.optInt("player", 2);
      paramComicParam.jdField_a_of_type_ComTencentComicVipComicJumpActivity$ComicInfo.jdField_e_of_type_JavaLangString = localJSONObject.optString("cloudUrl", "");
      paramComicParam.jdField_a_of_type_ComTencentComicVipComicJumpActivity$ComicInfo.jdField_d_of_type_JavaLangString = localJSONObject.optString("url", "");
      if (localJSONObject.optInt("returnToHome") == 1) {
        bool = true;
      }
      paramComicParam.jdField_b_of_type_Boolean = bool;
    }
    catch (JSONException localJSONException)
    {
      label315:
      break label315;
    }
    if (paramJSONObject.has("maintab")) {
      paramComicParam.jdField_g_of_type_JavaLangString = paramJSONObject.optString("maintab");
    }
    if (paramJSONObject.has("subtab")) {
      paramComicParam.jdField_h_of_type_JavaLangString = paramJSONObject.optString("subtab");
    }
    if (paramJSONObject.has("leftViewText")) {
      paramComicParam.jdField_i_of_type_JavaLangString = paramJSONObject.optString("leftViewText");
    }
  }
  
  public static boolean handleParam(AppRuntime paramAppRuntime, Activity paramActivity, VipComicJumpActivity.ComicParam paramComicParam)
  {
    if ((paramAppRuntime != null) && (paramActivity != null))
    {
      if (paramComicParam == null) {
        return false;
      }
      QLog.d("QQComicDebug", 2, "handle param start");
      boolean bool;
      if (("com.qqcomic.activity.VipComicMainTabActivity".equals(paramComicParam.jdField_e_of_type_JavaLangString)) && (paramComicParam.jdField_g_of_type_JavaLangString == null)) {
        bool = true;
      } else {
        bool = false;
      }
      if (checkJumpFromLaunch(paramAppRuntime, paramActivity, paramComicParam, bool)) {
        return true;
      }
      if ("com.qqcomic.activity.VipComicMainTabActivity".equals(paramComicParam.jdField_e_of_type_JavaLangString)) {
        return checkJumpMainActivity(paramAppRuntime, paramActivity, paramComicParam);
      }
      if ("com.qqcomic.activity.VipComicTabBrowserActivity".equals(paramComicParam.jdField_e_of_type_JavaLangString))
      {
        Intent localIntent = new Intent();
        localIntent.putExtra("url", paramComicParam.jdField_f_of_type_JavaLangString);
        localIntent.putExtra("reportSourceFrom", paramComicParam.jdField_a_of_type_Int);
        localIntent.putExtra("startOpenPageTime", paramComicParam.jdField_a_of_type_Long);
        if (TextUtils.isEmpty(paramComicParam.jdField_i_of_type_JavaLangString)) {
          paramAppRuntime = paramActivity.getString(2131690706);
        } else {
          paramAppRuntime = paramComicParam.jdField_i_of_type_JavaLangString;
        }
        localIntent.putExtra("selfSet_leftViewText", paramAppRuntime);
        VipComicHelper.a(paramActivity, localIntent, -1);
        ((IQQComicUtil)QRoute.api(IQQComicUtil.class)).reportClickEventTo644(null, "VIPCOMIC", "0X8005FC8", "0X8005FC8", paramComicParam.jdField_a_of_type_Int, 0, new String[] { String.valueOf(System.currentTimeMillis() - paramComicParam.jdField_b_of_type_Long) });
        QLog.d("QQComicDebug", 2, "handle param open web end");
        return true;
      }
      paramComicParam.jdField_g_of_type_Boolean = true;
      QLog.d("QQComicDebug", 2, "handle param end");
    }
    return false;
  }
  
  @Nullable
  private static JSONObject initParam(Intent paramIntent, VipComicJumpActivity.ComicParam paramComicParam)
  {
    paramComicParam.jdField_a_of_type_AndroidOsBundle = paramIntent.getBundleExtra("hippy_bundle");
    paramComicParam.jdField_a_of_type_Long = paramIntent.getLongExtra("click_start_time", 0L);
    paramComicParam.jdField_b_of_type_Long = System.currentTimeMillis();
    if (paramComicParam.jdField_a_of_type_Long <= 0L) {
      paramComicParam.jdField_a_of_type_Long = paramComicParam.jdField_b_of_type_Long;
    }
    paramComicParam.jdField_h_of_type_Boolean = paramIntent.getBooleanExtra("has_red_dot", false);
    String str1 = paramIntent.getStringExtra("from_leba");
    String str2 = paramIntent.getStringExtra("from_leba_mgr");
    String str3 = paramIntent.getStringExtra("cfrom");
    StringBuilder localStringBuilder = null;
    if ((str1 != null) && (str1.equalsIgnoreCase("fromleba")))
    {
      paramComicParam.jdField_a_of_type_Int = 1006002;
      paramIntent = localStringBuilder;
    }
    else if ((str2 != null) && (str2.equalsIgnoreCase("fromlebamgr")))
    {
      paramComicParam.jdField_a_of_type_Int = 1006003;
      paramIntent = localStringBuilder;
    }
    else if (!TextUtils.isEmpty(str3))
    {
      paramComicParam.jdField_a_of_type_Int = Integer.valueOf(str3).intValue();
      paramIntent = localStringBuilder;
    }
    else
    {
      paramIntent = parasOptions(paramIntent, paramComicParam);
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getFromInfoFromIntent sourceFrom = ");
      localStringBuilder.append(paramComicParam.jdField_a_of_type_Int);
      localStringBuilder.append(", extUrlParam = ");
      localStringBuilder.append(paramComicParam.jdField_c_of_type_JavaLangString);
      QLog.d("VipComicJumpActivity", 2, localStringBuilder.toString());
    }
    if (paramComicParam.jdField_a_of_type_Int == 1006002)
    {
      paramComicParam.jdField_i_of_type_JavaLangString = FrameControllerUtil.jdField_d_of_type_JavaLangString;
      return paramIntent;
    }
    if (paramComicParam.jdField_a_of_type_Int == 1006003) {
      paramComicParam.jdField_i_of_type_JavaLangString = HardCodeUtil.a(1996881933);
    }
    return paramIntent;
  }
  
  public static void initPluginBeforeEnter(AppInterface paramAppInterface, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQComicDebug", 2, "init plugin before enter start");
    }
    if ((paramAppInterface instanceof BaseQQAppInterface))
    {
      ThreadManager.getUIHandlerV2().postDelayed(new VipComicJumpActivity.5(), 1000L);
      VipComicRemoteCommand.a();
      VipComicEmoticonUploadRemoteCmd.a();
      if (paramBoolean) {
        ThreadManager.postImmediately(new VipComicJumpActivity.6(paramAppInterface), null, true);
      }
      paramAppInterface = (IVipComicMqqHandler)paramAppInterface.getBusinessHandler(((IEmoticonBusinessProxyApi)QRoute.api(IEmoticonBusinessProxyApi.class)).getVipComicMqqHandlerImplClassName());
      if (paramAppInterface != null) {
        paramAppInterface.b();
      }
    }
    else
    {
      paramAppInterface = new Bundle();
      paramAppInterface.putBoolean("doLoadModule", paramBoolean);
      QIPCClientHelper.getInstance().getClient().callServer("QQComicIPCModule", "initPluginBeforeEnter", paramAppInterface);
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQComicDebug", 2, "init plugin before enter end");
    }
  }
  
  private static boolean isToolProcessExist()
  {
    Object localObject = ((ActivityManager)AppHelper.a().getSystemService("activity")).getRunningAppProcesses().iterator();
    while (((Iterator)localObject).hasNext()) {
      if (((ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next()).processName.equals("com.tencent.mobileqq:tool"))
      {
        bool = true;
        break label57;
      }
    }
    boolean bool = false;
    label57:
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isToolProcessExist: ");
      ((StringBuilder)localObject).append(bool);
      QLog.d("VipComicJumpActivity", 2, ((StringBuilder)localObject).toString());
    }
    return bool;
  }
  
  public static void launchHippyPage(Activity paramActivity, VipComicJumpActivity.ComicParam paramComicParam)
  {
    Object localObject2 = new Bundle();
    ((Bundle)localObject2).putBoolean("isAnimated", true);
    ((Bundle)localObject2).putBoolean("isStatusBarDarkFont", true);
    ((Bundle)localObject2).putString("processName", "tool");
    boolean bool;
    if ((paramComicParam.jdField_c_of_type_JavaLangString != null) && (paramComicParam.jdField_c_of_type_JavaLangString.contains("hippyurl"))) {
      bool = false;
    } else {
      bool = true;
    }
    ((Bundle)localObject2).putBoolean("isTransparent", bool);
    ((Bundle)localObject2).putString("bundleName", "QQBoodoComic");
    BoodoHippyConfig localBoodoHippyConfig = getHippyConfig();
    if ((localBoodoHippyConfig != null) && (localBoodoHippyConfig.mPreloadModules.contains("QQBoodoComic"))) {
      ((Bundle)localObject2).putBoolean("isPreloadWhenClosed", true);
    }
    SerializableMap localSerializableMap = new SerializableMap();
    HashMap localHashMap = new HashMap();
    if (paramComicParam.jdField_h_of_type_Boolean) {
      localObject1 = "1";
    } else {
      localObject1 = "0";
    }
    localHashMap.put("hasRedDot", localObject1);
    localHashMap.put("extUrlParam", paramComicParam.jdField_c_of_type_JavaLangString);
    localHashMap.put("from", String.valueOf(paramComicParam.jdField_a_of_type_Int));
    localHashMap.put("redId", paramComicParam.k);
    localHashMap.put("redpointmsg", paramComicParam.m);
    if (paramComicParam.jdField_a_of_type_ComTencentComicVipComicJumpActivity$PageOpenTraceInfo != null)
    {
      localHashMap.put("lastPageKey", paramComicParam.jdField_a_of_type_ComTencentComicVipComicJumpActivity$PageOpenTraceInfo.jdField_a_of_type_JavaLangString);
      localHashMap.put("moduleId", paramComicParam.jdField_a_of_type_ComTencentComicVipComicJumpActivity$PageOpenTraceInfo.jdField_c_of_type_JavaLangString);
      localHashMap.put("contentId", paramComicParam.jdField_a_of_type_ComTencentComicVipComicJumpActivity$PageOpenTraceInfo.jdField_d_of_type_JavaLangString);
    }
    checkMod(localHashMap, paramComicParam);
    localSerializableMap.wrapMap(localHashMap);
    ((Bundle)localObject2).putSerializable("js_param_map", localSerializableMap);
    if ((localBoodoHippyConfig != null) && (!TextUtils.isEmpty(localBoodoHippyConfig.mPsKeyHost))) {
      ((Bundle)localObject2).putString("domain", localBoodoHippyConfig.mPsKeyHost);
    }
    Object localObject1 = new OpenHippyInfo((Bundle)localObject2);
    ((OpenHippyInfo)localObject1).fragmentClass = VipComicMainHippyFragment.class;
    localObject2 = (IHippyAccessHelper)QRoute.api(IHippyAccessHelper.class);
    paramComicParam = paramActivity;
    if (paramActivity == null) {
      paramComicParam = AppHelper.a();
    }
    ((IHippyAccessHelper)localObject2).openHippyPage(paramComicParam, (OpenHippyInfo)localObject1);
  }
  
  private void loadComicRuntime(VipComicJumpActivity.ComicParam paramComicParam, boolean paramBoolean)
  {
    if (paramComicParam.jdField_g_of_type_Boolean) {
      this.mHandler.sendEmptyMessage(1000);
    }
    this.mIsQQComicRunning = QIPCServerHelper.getInstance().isModuleRunning("comic_plugin.apk");
    if (!this.mIsQQComicRunning)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQComicDebug", 2, "plugin is not running...");
      }
      if (!paramBoolean) {
        SystemClock.sleep(500L);
      }
      QQComicPluginBridge.a(this, null);
      ((IQQComicUtil)QRoute.api(IQQComicUtil.class)).reportClickEventTo644(null, "VIPCOMIC", "0X8005FCE", "0X8005FCE", paramComicParam.jdField_a_of_type_Int, 0, new String[] { String.valueOf(System.currentTimeMillis() - paramComicParam.jdField_b_of_type_Long), "1" });
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQComicDebug", 2, "plugin is running...");
    }
  }
  
  private static void luanchMainTabActivity(Activity paramActivity, VipComicJumpActivity.ComicParam paramComicParam)
  {
    ArrayList localArrayList = new ArrayList();
    int j = paramActivity.getResources().getDimensionPixelSize(2131299168);
    int i = j;
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      i = j + ImmersiveUtils.getStatusBarHeight(paramActivity);
    }
    i = (int)((i - 0.5F) / paramActivity.getResources().getDisplayMetrics().density);
    Object localObject1 = VipComicNavConfigHelper.a();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("&redId=");
    ((StringBuilder)localObject2).append(paramComicParam.k);
    localObject2 = ((StringBuilder)localObject2).toString();
    Object localObject3;
    if ((localObject1 != null) && (!((List)localObject1).isEmpty())) {
      localObject3 = ((List)localObject1).iterator();
    }
    while (((Iterator)localObject3).hasNext())
    {
      Object localObject4 = (VipComicNavConfigHelper.TabItemData)((Iterator)localObject3).next();
      Object localObject5 = new WebViewTabBarData();
      ((WebViewTabBarData)localObject5).tag = ((VipComicNavConfigHelper.TabItemData)localObject4).jdField_a_of_type_JavaLangString;
      ((WebViewTabBarData)localObject5).tabName = ((VipComicNavConfigHelper.TabItemData)localObject4).jdField_b_of_type_JavaLangString;
      if (TextUtils.equals(((VipComicNavConfigHelper.TabItemData)localObject4).jdField_a_of_type_JavaLangString, "index"))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("&redDotIds=");
        ((StringBuilder)localObject1).append(paramComicParam.j);
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      else
      {
        localObject1 = "";
      }
      Object localObject6 = ((VipComicNavConfigHelper.TabItemData)localObject4).jdField_c_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("_cfrom=");
      localStringBuilder.append(paramComicParam.jdField_a_of_type_Int);
      localStringBuilder.append("&hasRedDot=");
      localStringBuilder.append(paramComicParam.a(((VipComicNavConfigHelper.TabItemData)localObject4).jdField_a_of_type_JavaLangString));
      localStringBuilder.append("&_titleBarHeight=");
      localStringBuilder.append(i);
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append((String)localObject2);
      ((WebViewTabBarData)localObject5).url = VipComicUrlHelper.a((String)localObject6, localStringBuilder.toString());
      ((WebViewTabBarData)localObject5).tabIcon = VipComicNavConfigHelper.a(((VipComicNavConfigHelper.TabItemData)localObject4).jdField_d_of_type_JavaLangString);
      localArrayList.add(localObject5);
      continue;
      localObject1 = new WebViewTabBarData();
      ((WebViewTabBarData)localObject1).tag = "index";
      ((WebViewTabBarData)localObject1).tabName = HardCodeUtil.a(1996881925);
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("_cfrom=");
      ((StringBuilder)localObject3).append(paramComicParam.jdField_a_of_type_Int);
      ((StringBuilder)localObject3).append("&hasRedDot=");
      ((StringBuilder)localObject3).append(paramComicParam.a("index"));
      ((StringBuilder)localObject3).append("&_titleBarHeight=");
      ((StringBuilder)localObject3).append(i);
      ((StringBuilder)localObject3).append("&redDotIds=");
      ((StringBuilder)localObject3).append(paramComicParam.j);
      ((StringBuilder)localObject3).append((String)localObject2);
      ((WebViewTabBarData)localObject1).url = getUrl("comicIndex", null, "64", "5", "", null, ((StringBuilder)localObject3).toString());
      localObject3 = new WebViewTabBarData();
      ((WebViewTabBarData)localObject3).tag = "fav";
      ((WebViewTabBarData)localObject3).tabName = HardCodeUtil.a(1996881923);
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("_cfrom=");
      ((StringBuilder)localObject4).append(paramComicParam.jdField_a_of_type_Int);
      ((StringBuilder)localObject4).append("&hasRedDot=");
      ((StringBuilder)localObject4).append(paramComicParam.a("fav"));
      ((StringBuilder)localObject4).append("&_titleBarHeight=");
      ((StringBuilder)localObject4).append(i);
      ((StringBuilder)localObject4).append((String)localObject2);
      ((WebViewTabBarData)localObject3).url = getUrl("comicFav", null, "", "1", "354", "%7B%22tabNum%22%3A2%2C%22subTextArray%22%3A%5B%22%E6%94%B6%E8%97%8F%22%2C%22%E4%B8%8B%E8%BD%BD%22%5D%7D", ((StringBuilder)localObject4).toString());
      localObject4 = new WebViewTabBarData();
      ((WebViewTabBarData)localObject4).tag = "category";
      ((WebViewTabBarData)localObject4).tabName = HardCodeUtil.a(1996881924);
      localObject5 = new StringBuilder();
      ((StringBuilder)localObject5).append("_cfrom=");
      ((StringBuilder)localObject5).append(paramComicParam.jdField_a_of_type_Int);
      ((StringBuilder)localObject5).append("&hasRedDot=");
      ((StringBuilder)localObject5).append(paramComicParam.a("category"));
      ((StringBuilder)localObject5).append("&_titleBarHeight=");
      ((StringBuilder)localObject5).append(i);
      ((StringBuilder)localObject5).append((String)localObject2);
      ((WebViewTabBarData)localObject4).url = getUrl("comicCategory", null, null, "1", "354", null, ((StringBuilder)localObject5).toString());
      localObject5 = new WebViewTabBarData();
      ((WebViewTabBarData)localObject5).tag = "more";
      ((WebViewTabBarData)localObject5).tabName = HardCodeUtil.a(1996881928);
      localObject6 = new StringBuilder();
      ((StringBuilder)localObject6).append("_cfrom=");
      ((StringBuilder)localObject6).append(paramComicParam.jdField_a_of_type_Int);
      ((StringBuilder)localObject6).append("&hasRedDot=");
      ((StringBuilder)localObject6).append(paramComicParam.a("more"));
      ((StringBuilder)localObject6).append("&_titleBarHeight=");
      ((StringBuilder)localObject6).append(i);
      ((StringBuilder)localObject6).append((String)localObject2);
      ((WebViewTabBarData)localObject5).url = getUrl("comicMore", null, null, "1", "354", null, ((StringBuilder)localObject6).toString());
      localObject6 = new WebViewTabBarData();
      ((WebViewTabBarData)localObject6).tag = "group";
      ((WebViewTabBarData)localObject6).tabName = HardCodeUtil.a(1996881926);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("_cfrom=");
      localStringBuilder.append(paramComicParam.jdField_a_of_type_Int);
      localStringBuilder.append("&hasRedDot=");
      localStringBuilder.append(paramComicParam.a("group"));
      localStringBuilder.append("&_titleBarHeight=");
      localStringBuilder.append(i);
      localStringBuilder.append((String)localObject2);
      ((WebViewTabBarData)localObject6).url = getUrl("comicGroup", null, null, "1", "354", null, localStringBuilder.toString());
      localArrayList.add(localObject1);
      localArrayList.add(localObject3);
      localArrayList.add(localObject4);
      localArrayList.add(localObject5);
      localArrayList.add(localObject6);
    }
    if (QLog.isColorLevel())
    {
      localObject1 = localArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (WebViewTabBarData)((Iterator)localObject1).next();
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("tabBar:tabKey=");
        ((StringBuilder)localObject3).append(((WebViewTabBarData)localObject2).tag);
        ((StringBuilder)localObject3).append(", tabName=");
        ((StringBuilder)localObject3).append(((WebViewTabBarData)localObject2).tabName);
        ((StringBuilder)localObject3).append(", tabUrl=");
        ((StringBuilder)localObject3).append(((WebViewTabBarData)localObject2).url);
        QLog.d("VipComicJumpActivity", 2, ((StringBuilder)localObject3).toString());
      }
    }
    openComicBrowserActivity(paramActivity, paramComicParam, localArrayList);
  }
  
  private static void onCheckPluginResult(int paramInt, VipComicJumpActivity.LoadingCondition paramLoadingCondition, Activity paramActivity, VipComicJumpActivity.ComicParam paramComicParam)
  {
    if (paramInt != 0)
    {
      showToastSafety("启动波洞动漫失败");
      if (paramLoadingCondition.jdField_a_of_type_ComTencentComicBoodoPluginLoadingDialog != null) {
        paramLoadingCondition.jdField_a_of_type_ComTencentComicBoodoPluginLoadingDialog.dismiss();
      }
    }
    else if ((paramLoadingCondition.jdField_a_of_type_ComTencentComicBoodoPluginLoadingDialog == null) || ((paramLoadingCondition.jdField_a_of_type_ComTencentComicBoodoPluginLoadingDialog != null) && (!paramLoadingCondition.jdField_b_of_type_Boolean)))
    {
      launchHippyPage(paramActivity, paramComicParam);
      QLog.i("VipComicJumpActivity", 1, "checkBoodoPlugin launchHippyPage ");
    }
    paramLoadingCondition.jdField_a_of_type_Boolean = false;
    try
    {
      paramLoadingCondition.notifyAll();
      return;
    }
    finally {}
  }
  
  private static void openComicBrowserActivity(Activity paramActivity, VipComicJumpActivity.ComicParam paramComicParam, ArrayList<WebViewTabBarData> paramArrayList)
  {
    int i;
    if (paramComicParam.jdField_g_of_type_JavaLangString != null) {
      i = getIndexByTag(paramComicParam.jdField_g_of_type_JavaLangString, paramArrayList);
    } else {
      i = 0;
    }
    WebViewTabBarData localWebViewTabBarData = (WebViewTabBarData)paramArrayList.get(i);
    localWebViewTabBarData.url = VipComicUrlHelper.a(localWebViewTabBarData.url, "isDefaultTab=1");
    if (paramComicParam.jdField_h_of_type_JavaLangString != null) {
      i = safeParseInt(paramComicParam.jdField_h_of_type_JavaLangString);
    }
    if ((!TextUtils.isEmpty(paramComicParam.jdField_c_of_type_JavaLangString)) && (i >= 0) && (i < paramArrayList.size()))
    {
      localWebViewTabBarData = (WebViewTabBarData)paramArrayList.get(i);
      String str = localWebViewTabBarData.url;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("extUrlParam=");
      localStringBuilder.append(URLEncoder.encode(paramComicParam.jdField_c_of_type_JavaLangString));
      localWebViewTabBarData.url = VipComicUrlHelper.a(str, localStringBuilder.toString());
    }
    openComicBrowserActvity(paramActivity, paramComicParam, paramArrayList, i, 0);
  }
  
  private static void openComicBrowserActvity(Activity paramActivity, VipComicJumpActivity.ComicParam paramComicParam, ArrayList<WebViewTabBarData> paramArrayList, int paramInt1, int paramInt2)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("tabConfigData", paramArrayList);
    localIntent.putExtra("reportSourceFrom", paramComicParam.jdField_a_of_type_Int);
    localIntent.putExtra("startOpenPageTime", paramComicParam.jdField_a_of_type_Long);
    localIntent.putExtra("key_maintab", paramInt1);
    localIntent.putExtra("tabDefaultIndex", paramInt1);
    localIntent.putExtra("key_subtab", paramInt2);
    if (TextUtils.isEmpty(paramComicParam.jdField_i_of_type_JavaLangString)) {
      paramArrayList = paramActivity.getString(2131690706);
    } else {
      paramArrayList = paramComicParam.jdField_i_of_type_JavaLangString;
    }
    localIntent.putExtra("selfSet_leftViewText", paramArrayList);
    if ((paramComicParam.jdField_a_of_type_Int == 1006002) || (paramComicParam.jdField_a_of_type_Int == 1006003))
    {
      if (paramComicParam.jdField_a_of_type_Int == 1006002) {
        paramInt1 = 40400;
      } else {
        paramInt1 = 40401;
      }
      localIntent.putExtra("individuation_url_type", paramInt1);
    }
    if (paramComicParam.jdField_e_of_type_Boolean) {
      localIntent.setFlags(localIntent.getFlags() | 0x4000000 | 0x10000000);
    }
    VipComicHelper.a(paramActivity, localIntent, -1);
  }
  
  private static JSONObject parasOptions(Intent paramIntent, VipComicJumpActivity.ComicParam paramComicParam)
  {
    Object localObject = null;
    JSONObject localJSONObject = null;
    try
    {
      String str = paramIntent.getStringExtra("options");
      paramIntent = localObject;
      if (!TextUtils.isEmpty(str))
      {
        paramIntent = new JSONObject(str);
        try
        {
          paramComicParam.jdField_a_of_type_Int = paramIntent.optInt("from");
          paramComicParam.jdField_b_of_type_JavaLangString = paramIntent.optString("from");
          paramComicParam.jdField_a_of_type_JavaLangString = paramIntent.optString("mod");
          paramComicParam.jdField_c_of_type_JavaLangString = paramIntent.optString("extUrlParam");
          paramComicParam.jdField_d_of_type_JavaLangString = paramIntent.optString("referer");
          if (TextUtils.isEmpty(paramComicParam.jdField_c_of_type_JavaLangString))
          {
            localJSONObject = paramIntent.optJSONObject("comic");
            if (localJSONObject != null) {
              paramComicParam.jdField_c_of_type_JavaLangString = localJSONObject.optString("extUrlParam");
            }
          }
          paramComicParam.jdField_a_of_type_ComTencentComicVipComicJumpActivity$PageOpenTraceInfo = new VipComicJumpActivity.PageOpenTraceInfo(paramIntent.optString("lastPageKey"), paramIntent.optString("pageId"), paramIntent.optString("moduleId", "0"), paramIntent.optString("contentId", "0"));
          return paramIntent;
        }
        catch (Exception paramComicParam) {}
        paramComicParam.printStackTrace();
      }
    }
    catch (Exception paramComicParam)
    {
      paramIntent = localJSONObject;
    }
    return paramIntent;
  }
  
  private static void parseBack2Reader(VipComicJumpActivity.ComicParam paramComicParam, Bundle paramBundle)
  {
    int i = paramBundle.getInt("type", -1);
    if ((i >= 100) && (i <= 300)) {
      paramComicParam.jdField_e_of_type_JavaLangString = "com.qqcomic.activity.media.VipComicMediaPlayActivity";
    } else if (((IQQComicConfigApi)QRoute.api(IQQComicConfigApi.class)).isEnableNewReader()) {
      paramComicParam.jdField_e_of_type_JavaLangString = "com.qqcomic.reader.VipComicReadingActivityV2";
    } else {
      paramComicParam.jdField_e_of_type_JavaLangString = "com.qqcomic.activity.reader.VipComicPortraitReadingActivity";
    }
    paramComicParam.jdField_a_of_type_ComTencentComicVipComicJumpActivity$ComicInfo = new VipComicJumpActivity.ComicInfo();
    paramComicParam.jdField_a_of_type_ComTencentComicVipComicJumpActivity$ComicInfo.jdField_a_of_type_JavaLangString = paramBundle.getString("comicId");
    paramComicParam.jdField_a_of_type_ComTencentComicVipComicJumpActivity$ComicInfo.jdField_b_of_type_JavaLangString = paramBundle.getString("sectionId");
    paramComicParam.jdField_a_of_type_ComTencentComicVipComicJumpActivity$ComicInfo.jdField_c_of_type_JavaLangString = paramBundle.getString("pictureId");
    paramComicParam.jdField_a_of_type_ComTencentComicVipComicJumpActivity$ComicInfo.jdField_a_of_type_Int = paramBundle.getInt("offset", -1);
    paramComicParam.jdField_a_of_type_ComTencentComicVipComicJumpActivity$ComicInfo.jdField_b_of_type_Int = paramBundle.getInt("type", -1);
    paramComicParam.jdField_a_of_type_ComTencentComicVipComicJumpActivity$ComicInfo.jdField_c_of_type_Int = paramBundle.getInt("player", 2);
    Object localObject2 = paramComicParam.jdField_a_of_type_ComTencentComicVipComicJumpActivity$ComicInfo;
    Object localObject1 = "";
    ((VipComicJumpActivity.ComicInfo)localObject2).jdField_e_of_type_JavaLangString = paramBundle.getString("cloudUrl", "");
    if ("com.qqcomic.activity.media.VipComicMediaPlayActivity".equals(paramComicParam.jdField_e_of_type_JavaLangString))
    {
      paramComicParam.jdField_a_of_type_Boolean = false;
      paramComicParam.jdField_d_of_type_Boolean = paramBundle.getBoolean("isPlayerLocked", false);
      paramComicParam.jdField_f_of_type_Boolean = (paramBundle.getBoolean("supportMiniPlayer", false) ^ true);
      if (paramComicParam.jdField_f_of_type_Boolean) {
        paramBundle = (Bundle)localObject1;
      } else {
        paramBundle = "init_player=1&";
      }
      localObject1 = paramComicParam.jdField_a_of_type_ComTencentComicVipComicJumpActivity$ComicInfo;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramBundle);
      ((StringBuilder)localObject2).append("ADTAG=comic.plugin.fav&id=");
      ((StringBuilder)localObject2).append(paramComicParam.jdField_a_of_type_ComTencentComicVipComicJumpActivity$ComicInfo.jdField_a_of_type_JavaLangString);
      ((VipComicJumpActivity.ComicInfo)localObject1).jdField_d_of_type_JavaLangString = getUrl("comicDetailVideo", null, null, "1", "354", null, ((StringBuilder)localObject2).toString());
      return;
    }
    paramComicParam.jdField_b_of_type_Boolean = paramBundle.getBoolean("key_return_to_home");
    paramComicParam.jdField_a_of_type_Boolean = true;
  }
  
  public static VipComicJumpActivity.ComicParam parseParam(Intent paramIntent)
  {
    if (paramIntent == null) {
      return null;
    }
    VipComicJumpActivity.ComicParam localComicParam = new VipComicJumpActivity.ComicParam();
    JSONObject localJSONObject = initParam(paramIntent, localComicParam);
    Bundle localBundle = VipComicRemoteCommand.a(null);
    int i;
    if ((localBundle != null) && ((localComicParam.jdField_a_of_type_Int == 1006002) || (localComicParam.jdField_a_of_type_Int == 19) || (localComicParam.jdField_a_of_type_Int == 20))) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      parseBack2Reader(localComicParam, localBundle);
    } else if (localJSONObject != null) {
      handleJsonParam(localComicParam, localJSONObject);
    }
    if (TextUtils.isEmpty(localComicParam.jdField_g_of_type_JavaLangString)) {
      localComicParam.jdField_g_of_type_JavaLangString = VipComicHelper.a();
    }
    reportFromBanner(paramIntent, localComicParam);
    return localComicParam;
  }
  
  public static void preloadQQBoodoComic(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = (ILebaHelperService)paramAppRuntime.getRuntimeService(ILebaHelperService.class, "");
    if (paramAppRuntime == null)
    {
      QLog.d("VipComicJumpActivity", 1, "preloadQQBoodoComic lebaHelperService == null");
      return;
    }
    if (!paramAppRuntime.isPluginOpen(1113L))
    {
      QLog.e("VipComicJumpActivity", 1, "preloadQQBoodoComic not open");
      return;
    }
    paramAppRuntime = getHippyConfig();
    if ((paramAppRuntime != null) && (paramAppRuntime.mPreloadModules.contains("QQBoodoComic")))
    {
      Object localObject = QRoute.plugin("comic_plugin.apk");
      if (localObject == null)
      {
        QLog.e("VipComicJumpActivity", 1, "preloadQQBoodoComic pluginManager == null");
        return;
      }
      if (!((IQRoutePlugin)localObject).isInstalled())
      {
        QLog.e("VipComicJumpActivity", 1, "preloadQQBoodoComic plugin not ready");
        return;
      }
      QLog.i("VipComicJumpActivity", 1, "preloadBoodoComic");
      localObject = new OpenHippyInfo();
      ((OpenHippyInfo)localObject).bundleName = "QQBoodoComic";
      ((OpenHippyInfo)localObject).isPreload = true;
      ((OpenHippyInfo)localObject).processName = "tool";
      if ((paramAppRuntime != null) && (!TextUtils.isEmpty(paramAppRuntime.mPsKeyHost))) {
        ((OpenHippyInfo)localObject).domain = paramAppRuntime.mPsKeyHost;
      }
      ((IHippyAccessHelper)QRoute.api(IHippyAccessHelper.class)).checkAndPreloadHippyPage((OpenHippyInfo)localObject);
      return;
    }
    QLog.e("VipComicJumpActivity", 1, "preloadQQBoodoComic config not pass");
  }
  
  private static void reportFromBanner(Intent paramIntent, VipComicJumpActivity.ComicParam paramComicParam)
  {
    if ((paramIntent.hasExtra("banner_fromBanner")) && (paramIntent.getBooleanExtra("banner_fromBanner", false)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VipComicJumpActivity", 2, "come from AIO Banner!");
      }
      if ((paramComicParam.jdField_a_of_type_ComTencentComicVipComicJumpActivity$ComicInfo != null) && (!TextUtils.isEmpty(paramComicParam.jdField_a_of_type_ComTencentComicVipComicJumpActivity$ComicInfo.jdField_a_of_type_JavaLangString))) {
        ((IQQDcReporter)QRoute.api(IQQDcReporter.class)).reportDC00145(null, "100007", "2", "40040", paramComicParam.jdField_a_of_type_ComTencentComicVipComicJumpActivity$ComicInfo.jdField_a_of_type_JavaLangString, new String[0]);
      }
    }
  }
  
  private static int safeParseInt(String paramString)
  {
    try
    {
      int i = Integer.parseInt(paramString);
      return i;
    }
    catch (Exception paramString)
    {
      QLog.e("VipComicJumpActivity", 1, paramString, new Object[0]);
    }
    return 0;
  }
  
  private static void showHippyLoading(Activity paramActivity, VipComicJumpActivity.LoadingCondition paramLoadingCondition)
  {
    if (paramLoadingCondition == null) {
      return;
    }
    if (paramLoadingCondition.jdField_a_of_type_Boolean)
    {
      paramActivity = new VipComicJumpActivity.4(paramActivity, paramLoadingCondition);
      if (Looper.getMainLooper() == Looper.myLooper())
      {
        paramActivity.run();
        return;
      }
      ThreadManagerV2.getUIHandlerV2().post(paramActivity);
    }
  }
  
  private static void showToastSafety(String paramString)
  {
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      QQToast.a(AppHelper.a(), paramString, 0).a();
      return;
    }
    ThreadManager.getUIHandler().post(new VipComicJumpActivity.2(paramString));
  }
  
  static void updateRedAppInfo(AppRuntime paramAppRuntime, VipComicJumpActivity.ComicParam paramComicParam)
  {
    if (paramAppRuntime != null)
    {
      if (paramComicParam == null) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("VipComicJumpActivity", 2, "updateRedAppInfo start");
      }
      boolean bool2 = paramAppRuntime instanceof BaseQQAppInterface;
      Object localObject2 = null;
      Object localObject1;
      Object localObject3;
      boolean bool1;
      if (bool2)
      {
        localObject1 = (ILebaHelperService)paramAppRuntime.getRuntimeService(ILebaHelperService.class, "multi");
        if (localObject1 != null)
        {
          localObject1 = ((ILebaHelperService)localObject1).getLebaMgrList();
        }
        else
        {
          QLog.d("VipComicJumpActivity", 1, "updateRedAppInfo lebaHelperService == null");
          localObject1 = null;
        }
        int j = -1;
        int i = j;
        if (localObject1 != null)
        {
          localObject1 = ((List)localObject1).iterator();
          do
          {
            i = j;
            if (!((Iterator)localObject1).hasNext()) {
              break;
            }
            localObject3 = (LebaViewItem)((Iterator)localObject1).next();
          } while ((localObject3 == null) || (((LebaViewItem)localObject3).jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo == null) || (((LebaViewItem)localObject3).jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.uiResId != 1113L));
          i = ((LebaViewItem)localObject3).jdField_a_of_type_Byte;
        }
        if (i == 0)
        {
          bool1 = true;
          localObject1 = localObject2;
        }
        else
        {
          bool1 = false;
          localObject1 = localObject2;
        }
      }
      else
      {
        localObject1 = (IQQComicRedTouchService)paramAppRuntime.getRuntimeService(IQQComicRedTouchService.class, "all");
        if (localObject1 == null) {
          return;
        }
        bool1 = ((IQQComicRedTouchService)localObject1).isLebaItemOpen(1113);
      }
      String str;
      Object localObject6;
      Object localObject5;
      Object localObject4;
      if (bool1)
      {
        str = String.valueOf(1113);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("1113.");
        ((StringBuilder)localObject2).append(100800);
        localObject6 = ((StringBuilder)localObject2).toString();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("1113.");
        ((StringBuilder)localObject2).append(100802);
        localObject5 = ((StringBuilder)localObject2).toString();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("1113.");
        ((StringBuilder)localObject2).append(100803);
        localObject4 = ((StringBuilder)localObject2).toString();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("1113.");
        ((StringBuilder)localObject2).append(100804);
        localObject3 = ((StringBuilder)localObject2).toString();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("1113.");
        ((StringBuilder)localObject2).append(100801);
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      else
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("100600.100001113.");
        ((StringBuilder)localObject2).append(100100800);
        localObject6 = ((StringBuilder)localObject2).toString();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("100600.100001113.");
        ((StringBuilder)localObject2).append(100100802);
        localObject5 = ((StringBuilder)localObject2).toString();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("100600.100001113.");
        ((StringBuilder)localObject2).append(100100803);
        localObject4 = ((StringBuilder)localObject2).toString();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("100600.100001113.");
        ((StringBuilder)localObject2).append(100100804);
        localObject3 = ((StringBuilder)localObject2).toString();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("100600.100001113.");
        ((StringBuilder)localObject2).append(100100801);
        localObject2 = ((StringBuilder)localObject2).toString();
        str = "100600.100001113";
      }
      if (bool2)
      {
        paramAppRuntime = (IRedTouchManager)paramAppRuntime.getRuntimeService(IRedTouchManager.class, "");
        if (paramAppRuntime == null) {
          return;
        }
        localObject1 = paramAppRuntime.getAppInfoByPath(str);
        localObject6 = paramAppRuntime.getAppInfoByPath((String)localObject6);
        localObject5 = paramAppRuntime.getAppInfoByPath((String)localObject5);
        localObject4 = paramAppRuntime.getAppInfoByPath((String)localObject4);
        localObject3 = paramAppRuntime.getAppInfoByPath((String)localObject3);
        paramAppRuntime = paramAppRuntime.getAppInfoByPath((String)localObject2);
        if ((localObject6 != null) && (((BusinessInfoCheckUpdate.AppInfo)localObject6).iNewFlag.get() != 0)) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        paramComicParam.a("index", bool1);
        if ((paramAppRuntime != null) && (paramAppRuntime.iNewFlag.get() != 0)) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        paramComicParam.a("fav", bool1);
        if ((localObject3 != null) && (((BusinessInfoCheckUpdate.AppInfo)localObject3).iNewFlag.get() != 0)) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        paramComicParam.a("category", bool1);
        if ((localObject5 != null) && (((BusinessInfoCheckUpdate.AppInfo)localObject5).iNewFlag.get() != 0)) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        paramComicParam.a("more", bool1);
        if ((localObject4 != null) && (((BusinessInfoCheckUpdate.AppInfo)localObject4).iNewFlag.get() != 0)) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        paramComicParam.a("group", bool1);
        if ((localObject1 != null) && (paramComicParam.jdField_h_of_type_Boolean))
        {
          updateRedirectRedInfo(((BusinessInfoCheckUpdate.AppInfo)localObject1).buffer.get(), ((BusinessInfoCheckUpdate.AppInfo)localObject1).missions.get(), paramComicParam);
          paramComicParam.j = contactReddotIds(((BusinessInfoCheckUpdate.AppInfo)localObject1).missions.get());
          paramComicParam.k = getShowMissionId(((BusinessInfoCheckUpdate.AppInfo)localObject1).buffer.get());
          paramComicParam.l = getAdId(((BusinessInfoCheckUpdate.AppInfo)localObject1).buffer.get());
          paramComicParam.m = getRedPointMsg(((BusinessInfoCheckUpdate.AppInfo)localObject1).buffer.get());
        }
      }
      else
      {
        paramAppRuntime = new ArrayList();
        paramAppRuntime.add(str);
        paramAppRuntime.add(localObject6);
        paramAppRuntime.add(localObject2);
        paramAppRuntime.add(localObject3);
        paramAppRuntime.add(localObject5);
        paramAppRuntime.add(localObject4);
        paramAppRuntime = ((IQQComicRedTouchService)localObject1).getRedAppInfo(paramAppRuntime);
        if (paramAppRuntime == null) {
          return;
        }
        localObject1 = (RedAppInfo)paramAppRuntime.get(str);
        localObject6 = (RedAppInfo)paramAppRuntime.get(localObject6);
        localObject5 = (RedAppInfo)paramAppRuntime.get(localObject5);
        localObject4 = (RedAppInfo)paramAppRuntime.get(localObject4);
        localObject3 = (RedAppInfo)paramAppRuntime.get(localObject3);
        paramAppRuntime = (RedAppInfo)paramAppRuntime.get(localObject2);
        if ((localObject6 != null) && (((RedAppInfo)localObject6).b() != 0)) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        paramComicParam.a("index", bool1);
        if ((paramAppRuntime != null) && (paramAppRuntime.b() != 0)) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        paramComicParam.a("fav", bool1);
        if ((localObject3 != null) && (((RedAppInfo)localObject3).b() != 0)) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        paramComicParam.a("category", bool1);
        if ((localObject5 != null) && (((RedAppInfo)localObject5).b() != 0)) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        paramComicParam.a("more", bool1);
        if ((localObject4 != null) && (((RedAppInfo)localObject4).b() != 0)) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        paramComicParam.a("group", bool1);
        if ((localObject1 != null) && (paramComicParam.jdField_h_of_type_Boolean))
        {
          updateRedirectRedInfo(((RedAppInfo)localObject1).a(), ((RedAppInfo)localObject1).a(), paramComicParam);
          paramComicParam.j = contactReddotIds(((RedAppInfo)localObject1).a());
          paramComicParam.k = getShowMissionId(((RedAppInfo)localObject1).a());
          paramComicParam.l = getAdId(((RedAppInfo)localObject1).a());
          paramComicParam.m = getRedPointMsg(((RedAppInfo)localObject1).a());
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("VipComicJumpActivity", 2, "updateRedAppInfo end");
      }
    }
  }
  
  static boolean updateRedirectRedInfo(String paramString, List<String> paramList, VipComicJumpActivity.ComicParam paramComicParam)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramList != null) && (!paramList.isEmpty()))
    {
      Object localObject = null;
      try
      {
        paramString = new JSONObject(paramString).optJSONObject("msg");
      }
      catch (Exception paramString)
      {
        QLog.e("VipComicJumpActivity", 1, "parse red failed", paramString);
        paramString = (String)localObject;
      }
      if (paramString != null)
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          localObject = (String)paramList.next();
          try
          {
            localObject = paramString.optJSONObject((String)localObject);
            if (localObject != null)
            {
              localObject = ((JSONObject)localObject).optString("content");
              if (!TextUtils.isEmpty((CharSequence)localObject))
              {
                localObject = new JSONObject((String)localObject);
                paramComicParam.jdField_i_of_type_Boolean = "redirect".equals(((JSONObject)localObject).optString("type"));
                if (paramComicParam.jdField_i_of_type_Boolean)
                {
                  localObject = ((JSONObject)localObject).optString("link");
                  if (TextUtils.isEmpty((CharSequence)localObject))
                  {
                    paramComicParam.jdField_i_of_type_Boolean = false;
                  }
                  else
                  {
                    paramComicParam.n = ((String)localObject);
                    return true;
                  }
                }
              }
            }
          }
          catch (Exception localException)
          {
            QLog.e("VipComicJumpActivity", 1, "parse red mission failed", localException);
          }
        }
      }
    }
    return false;
  }
  
  void directStartPlugin(Activity paramActivity, VipComicJumpActivity.ComicParam paramComicParam)
  {
    if (paramActivity != null)
    {
      if (paramComicParam == null) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQComicDebug", 2, "call start plugin activity start.");
      }
      if ("com.tencent.hippy.qq.fragment.CommonHippyFragment".equals(paramComicParam.jdField_e_of_type_JavaLangString))
      {
        paramActivity = new StringBuilder();
        paramActivity.append("directStartPlugin openHippyPage param:");
        paramActivity.append(paramComicParam);
        QLog.i("VipComicJumpActivity", 1, paramActivity.toString());
        return;
      }
      Intent localIntent = paramComicParam.jdField_a_of_type_AndroidContentIntent;
      localIntent.putExtra("begin_to_load_comic_plugin", System.currentTimeMillis());
      localIntent.putExtra("startOpenPageTime", paramComicParam.jdField_a_of_type_Long);
      localIntent.putExtra("pluginFinished", this.downloadTime);
      if (!TextUtils.isEmpty(paramComicParam.jdField_f_of_type_JavaLangString)) {
        localIntent.putExtra("url", paramComicParam.jdField_f_of_type_JavaLangString);
      }
      boolean bool = ((IQQComicConfigApi)QRoute.api(IQQComicConfigApi.class)).isEnableNewReader();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[directStartPlugin] param.jumpConponentName = ");
      ((StringBuilder)localObject).append(paramComicParam.jdField_e_of_type_JavaLangString);
      ((StringBuilder)localObject).append(", use comic version is ");
      ((StringBuilder)localObject).append(bool);
      QLog.i("VipComicJumpActivity", 2, ((StringBuilder)localObject).toString());
      if (paramComicParam.jdField_a_of_type_ComTencentComicVipComicJumpActivity$ComicInfo != null)
      {
        int i;
        if ((!paramComicParam.jdField_e_of_type_JavaLangString.equals("com.qqcomic.reader.VipComicReadingActivityV2")) && (!paramComicParam.jdField_e_of_type_JavaLangString.equals("com.qqcomic.activity.reader.VipComicPortraitReadingActivity"))) {
          i = 0;
        } else {
          i = 1;
        }
        int j;
        if ((!bool) && (!paramComicParam.jdField_e_of_type_JavaLangString.equals("com.qqcomic.reader.VipComicReadingActivityV2"))) {
          j = 0;
        } else {
          j = 1;
        }
        if ((i != 0) && (j != 0))
        {
          paramComicParam.jdField_e_of_type_JavaLangString = "com.qqcomic.reader.VipComicReadingActivityV2";
          localIntent.putExtra("req_comicId", paramComicParam.jdField_a_of_type_ComTencentComicVipComicJumpActivity$ComicInfo.jdField_a_of_type_JavaLangString);
          localIntent.putExtra("req_sectionId", paramComicParam.jdField_a_of_type_ComTencentComicVipComicJumpActivity$ComicInfo.jdField_b_of_type_JavaLangString);
          localIntent.putExtra("req_picId", paramComicParam.jdField_a_of_type_ComTencentComicVipComicJumpActivity$ComicInfo.jdField_c_of_type_JavaLangString);
        }
        else
        {
          localIntent.putExtra("key_comic_id", paramComicParam.jdField_a_of_type_ComTencentComicVipComicJumpActivity$ComicInfo.jdField_a_of_type_JavaLangString);
          localIntent.putExtra("key_section_id", paramComicParam.jdField_a_of_type_ComTencentComicVipComicJumpActivity$ComicInfo.jdField_b_of_type_JavaLangString);
          localIntent.putExtra("key_pic_id", paramComicParam.jdField_a_of_type_ComTencentComicVipComicJumpActivity$ComicInfo.jdField_c_of_type_JavaLangString);
          localIntent.putExtra("key_pic_offset_ratio", paramComicParam.jdField_a_of_type_ComTencentComicVipComicJumpActivity$ComicInfo.jdField_a_of_type_Int);
          localIntent.putExtra("key_type", paramComicParam.jdField_a_of_type_ComTencentComicVipComicJumpActivity$ComicInfo.jdField_b_of_type_Int);
          localIntent.putExtra("key_jump_from_out_plugin", true);
          localIntent.putExtra("key_return_to_detail", paramComicParam.jdField_a_of_type_Boolean);
          localIntent.putExtra("key_return_to_home", paramComicParam.jdField_b_of_type_Boolean);
          localIntent.putExtra("key_is_player_locked", paramComicParam.jdField_d_of_type_Boolean);
          localIntent.putExtra("key_return_to_home_from_detail", paramComicParam.jdField_c_of_type_Boolean);
          localIntent.putExtra("key_is_fullscreen", paramComicParam.jdField_f_of_type_Boolean);
          localIntent.putExtra("key_video_player_type", paramComicParam.jdField_a_of_type_ComTencentComicVipComicJumpActivity$ComicInfo.jdField_c_of_type_Int);
          localIntent.putExtra("key_cloud_url", paramComicParam.jdField_a_of_type_ComTencentComicVipComicJumpActivity$ComicInfo.jdField_e_of_type_JavaLangString);
          if (!TextUtils.isEmpty(paramComicParam.jdField_a_of_type_ComTencentComicVipComicJumpActivity$ComicInfo.jdField_d_of_type_JavaLangString)) {
            localIntent.putExtra("url", paramComicParam.jdField_a_of_type_ComTencentComicVipComicJumpActivity$ComicInfo.jdField_d_of_type_JavaLangString);
          }
        }
      }
      localIntent.putExtra("key_from_out_entry", true);
      localIntent.putExtra("key_extUrlParam", paramComicParam.jdField_c_of_type_JavaLangString);
      QLog.d("VipComicJumpActivity", 1, new Object[] { "directStartPlugin key_extUrlParam mExtUrlParam:", paramComicParam.jdField_c_of_type_JavaLangString });
      localIntent.putExtra("key_source_from", paramComicParam.jdField_a_of_type_Int);
      localIntent.putExtra("key_referer", paramComicParam.jdField_d_of_type_JavaLangString);
      if (paramComicParam.jdField_a_of_type_Int != 6)
      {
        String str = paramComicParam.jdField_a_of_type_JavaLangString;
        localObject = str;
        if (TextUtils.isEmpty(str)) {
          localObject = paramComicParam.jdField_b_of_type_JavaLangString;
        }
        localIntent.putExtra("key_mod", (String)localObject);
      }
      if (TextUtils.isEmpty(paramComicParam.jdField_i_of_type_JavaLangString)) {
        localIntent.putExtra("selfSet_leftViewText", getString(2131690706));
      } else {
        localIntent.putExtra("selfSet_leftViewText", paramComicParam.jdField_i_of_type_JavaLangString);
      }
      if (paramComicParam.jdField_e_of_type_Boolean) {
        localIntent.addFlags(67108864);
      }
      localObject = getPreloadProcHitPluginSession(paramComicParam, localIntent);
      QQComicPluginBridge.a(paramActivity, localIntent, paramComicParam.jdField_e_of_type_JavaLangString, (PreloadProcHitPluginSession)localObject);
      QLog.d("QQComicDebug", 2, "call start plugin activity end.");
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    paramBundle = parseParam(getIntent());
    this.mParam = paramBundle;
    if (handleParam(getAppRuntime(), this, paramBundle))
    {
      finish();
      return true;
    }
    Object localObject = new IntentFilter();
    ((IntentFilter)localObject).addAction("com.tencent.mobileqq.ACTION_PLUGIN_STARTUP_FAILED");
    ((IntentFilter)localObject).addAction("com.tencent.mobileqq.PreLoadComicProcess");
    this.mReceiver = new VipComicJumpActivity.LaunchCompletedObserver(this);
    getApplicationContext().registerReceiver(this.mReceiver, (IntentFilter)localObject);
    if (QLog.isColorLevel()) {
      QLog.i("VipComicJumpActivity", 2, "VipComicJumpActivity.doOnCreate registerReceiver");
    }
    setContentView(1996816387);
    setTitle(1996881934);
    this.loadingMsg = ((TextView)findViewById(1996750879));
    this.loadingProgress = ((TextView)findViewById(1996750880));
    this.mHandler = new WeakReferenceHandler(this);
    ((IQQComicUtil)QRoute.api(IQQComicUtil.class)).reportClickEventTo644(null, "VIPCOMIC", "0X8005FC7", "0X8005FC7", paramBundle.jdField_a_of_type_Int, 0, new String[] { String.valueOf(System.currentTimeMillis() - paramBundle.jdField_b_of_type_Long) });
    localObject = ((QQPluginPreloadServiceImpl)getAppRuntime().getRuntimeService(IQQPluginPreloadService.class, "")).manager;
    if (localObject != null)
    {
      ((QQComicPreloadManager)localObject).a(System.currentTimeMillis());
      ((QQComicPreloadManager)localObject).c();
    }
    initPlugin(paramBundle);
    return true;
  }
  
  void enterComicReport644(VipComicJumpActivity.ComicParam paramComicParam, int paramInt)
  {
    if (paramComicParam == null) {
      return;
    }
    this.launchTime = System.currentTimeMillis();
    Object localObject1 = "1";
    Object localObject4;
    Object localObject3;
    try
    {
      localObject4 = getAppRuntime();
      Object localObject2 = localObject1;
      if ((localObject4 instanceof AppInterface))
      {
        int i = ((IVasSingedApi)((AppRuntime)localObject4).getRuntimeService(IVasSingedApi.class, "all")).getVipStatus().getPrivilegeFlags(null);
        if ((i & 0x4) != 0)
        {
          localObject1 = "3";
        }
        else
        {
          localObject2 = localObject1;
          if ((i & 0x2) != 0) {
            localObject1 = "2";
          }
        }
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      localObject3 = localObject1;
    }
    for (;;)
    {
      boolean bool = this.mIsQQComicRunning;
      Object localObject7 = "0";
      if (bool)
      {
        localObject1 = "-1";
      }
      else
      {
        if (paramComicParam.jdField_b_of_type_Long != 0L)
        {
          l1 = this.downloadTime;
          if ((l1 != 0L) && (l1 > paramComicParam.jdField_b_of_type_Long))
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(this.downloadTime - paramComicParam.jdField_b_of_type_Long);
            ((StringBuilder)localObject1).append("");
            localObject1 = ((StringBuilder)localObject1).toString();
            break label208;
          }
        }
        localObject1 = "0";
      }
      label208:
      long l1 = this.installTime;
      long l2;
      if (l1 != 0L)
      {
        l2 = this.downloadTime;
        if ((l2 != 0L) && (l1 > l2))
        {
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append(this.installTime - this.downloadTime);
          ((StringBuilder)localObject4).append("");
          localObject4 = ((StringBuilder)localObject4).toString();
          break label290;
        }
      }
      localObject4 = "0";
      label290:
      l1 = this.installTime;
      if (l1 != 0L)
      {
        l2 = this.launchTime;
        if ((l2 != 0L) && (l2 > l1))
        {
          localObject5 = new StringBuilder();
          ((StringBuilder)localObject5).append(this.launchTime - this.installTime);
          ((StringBuilder)localObject5).append("");
          localObject5 = ((StringBuilder)localObject5).toString();
          break label372;
        }
      }
      Object localObject5 = "0";
      label372:
      Object localObject6 = localObject7;
      if (paramComicParam.jdField_b_of_type_Long != 0L)
      {
        l1 = this.launchTime;
        localObject6 = localObject7;
        if (l1 != 0L)
        {
          localObject6 = localObject7;
          if (l1 > paramComicParam.jdField_b_of_type_Long)
          {
            localObject6 = new StringBuilder();
            ((StringBuilder)localObject6).append(this.launchTime - paramComicParam.jdField_b_of_type_Long);
            ((StringBuilder)localObject6).append("");
            localObject6 = ((StringBuilder)localObject6).toString();
          }
        }
      }
      if (QLog.isColorLevel())
      {
        localObject7 = new StringBuilder();
        ((StringBuilder)localObject7).append("downloadCost:");
        ((StringBuilder)localObject7).append((String)localObject1);
        ((StringBuilder)localObject7).append(", installCost:");
        ((StringBuilder)localObject7).append((String)localObject4);
        ((StringBuilder)localObject7).append(", launchCost:");
        ((StringBuilder)localObject7).append((String)localObject5);
        ((StringBuilder)localObject7).append(", allCost:");
        ((StringBuilder)localObject7).append((String)localObject6);
        ((StringBuilder)localObject7).append(",[startTime-launchTime]=[");
        ((StringBuilder)localObject7).append(paramComicParam.jdField_b_of_type_Long);
        ((StringBuilder)localObject7).append("-");
        ((StringBuilder)localObject7).append(this.launchTime);
        ((StringBuilder)localObject7).append("]");
        QLog.d("VipComicJumpActivity", 2, ((StringBuilder)localObject7).toString());
      }
      ((IQQComicUtil)QRoute.api(IQQComicUtil.class)).reportClickEventTo644(null, "VIPCOMIC", "0X80052CA", "0X80052CA", paramComicParam.jdField_a_of_type_Int, paramInt, new String[] { localObject3 });
      ((IQQComicUtil)QRoute.api(IQQComicUtil.class)).reportClickEventTo644(null, "VIPCOMIC", "0X8005359", "0X8005359", paramComicParam.jdField_a_of_type_Int, paramInt, new String[] { localObject1, localObject4, localObject5, localObject6 });
      return;
      localObject3 = localObject1;
    }
  }
  
  public void finish()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VipComicJumpActivity", 2, "finish.");
    }
    super.finish();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return true;
    case 1002: 
      finish();
      return true;
    case 1001: 
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramMessage.arg1);
      ((StringBuilder)localObject).append("%");
      localObject = ((StringBuilder)localObject).toString();
      paramMessage = String.valueOf(paramMessage.obj);
      this.loadingProgress.setText((CharSequence)localObject);
      this.loadingMsg.setText(paramMessage);
      return true;
    }
    if (this.mParam == null) {
      return false;
    }
    if (!this.isPrePluginProcess)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQComicDebug", 2, "do handle launch activity.");
      }
      this.isPrePluginProcess = true;
      this.isPrePluginTimeOut = true;
      launch(this.mParam);
      ((IQQComicUtil)QRoute.api(IQQComicUtil.class)).reportClickEventTo644(null, "VIPCOMIC", "0X8005FCE", "0X8005FCE", this.mParam.jdField_a_of_type_Int, 0, new String[] { String.valueOf(System.currentTimeMillis() - this.mParam.jdField_b_of_type_Long), "2" });
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQComicDebug", 2, "skip handle launch activity.");
    }
    return true;
  }
  
  public void initPlugin(VipComicJumpActivity.ComicParam paramComicParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQComicDebug", 2, "init plugin start");
    }
    initPluginBeforeEnter((AppInterface)getAppRuntime(), false);
    ThreadManager.postImmediately(new VipComicJumpActivity.7(this, getAppRuntime(), paramComicParam), null, true);
    if (QLog.isColorLevel()) {
      QLog.d("QQComicDebug", 2, "init plugin end");
    }
  }
  
  public void launch(VipComicJumpActivity.ComicParam paramComicParam)
  {
    if (paramComicParam == null) {
      return;
    }
    if (!paramComicParam.jdField_g_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQComicDebug", 2, "skip launch activity.");
      }
      finish();
      return;
    }
    directStartPlugin(this, paramComicParam);
    ((IQQComicUtil)QRoute.api(IQQComicUtil.class)).reportClickEventTo644(null, "VIPCOMIC", "0X8005FC8", "0X8005FC8", paramComicParam.jdField_a_of_type_Int, 0, new String[] { String.valueOf(System.currentTimeMillis() - paramComicParam.jdField_b_of_type_Long) });
  }
  
  protected boolean onBackEvent()
  {
    QRoutePluginInfo localQRoutePluginInfo = QRoute.plugin("comic_plugin.apk").queryPluginInfo();
    Object localObject = getIntent();
    int i = 0;
    boolean bool = ((Intent)localObject).getBooleanExtra("has_red_dot", false);
    if (this.mParam != null)
    {
      localObject = "1";
      IQQComicUtil localIQQComicUtil;
      int j;
      long l1;
      long l2;
      if (localQRoutePluginInfo == null)
      {
        localIQQComicUtil = (IQQComicUtil)QRoute.api(IQQComicUtil.class);
        j = this.mParam.jdField_a_of_type_Int;
        l1 = System.currentTimeMillis();
        l2 = this.mParam.jdField_b_of_type_Long;
        if (this.mIsQQComicRunning) {
          i = 0;
        } else if (this.isPrePluginProcess)
        {
          if (this.isPrePluginTimeOut) {
            i = 2;
          } else {
            i = 3;
          }
        }
        else {
          i = 4;
        }
        if (!bool) {
          localObject = "0";
        }
        localIQQComicUtil.reportClickEventTo644(null, "VIPCOMIC", "0X8005FCD", "0X8005FCD", j, 0, new String[] { String.valueOf(l1 - l2), "-9999", String.valueOf(i), localObject });
      }
      else
      {
        localIQQComicUtil = (IQQComicUtil)QRoute.api(IQQComicUtil.class);
        j = this.mParam.jdField_a_of_type_Int;
        l1 = System.currentTimeMillis();
        l2 = this.mParam.jdField_b_of_type_Long;
        int k = localQRoutePluginInfo.getState();
        if (!this.mIsQQComicRunning) {
          if (this.isPrePluginProcess)
          {
            if (this.isPrePluginTimeOut) {
              i = 2;
            } else {
              i = 3;
            }
          }
          else {
            i = 4;
          }
        }
        if (!bool) {
          localObject = "0";
        }
        localIQQComicUtil.reportClickEventTo644(null, "VIPCOMIC", "0X8005FCD", "0X8005FCD", j, 0, new String[] { String.valueOf(l1 - l2), String.valueOf(k), String.valueOf(i), localObject });
      }
    }
    return super.onBackEvent();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    WeakReferenceHandler localWeakReferenceHandler = this.mHandler;
    if (localWeakReferenceHandler != null)
    {
      localWeakReferenceHandler.removeMessages(1000);
      this.mHandler.removeMessages(1001);
    }
    this.mDestroy = true;
    if (this.mReceiver != null)
    {
      try
      {
        getApplicationContext().unregisterReceiver(this.mReceiver);
        if (QLog.isColorLevel()) {
          QLog.i("VipComicJumpActivity", 2, "VipComicJumpActivity.doOnCreate unregisterReceiver");
        }
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        localIllegalArgumentException.printStackTrace();
      }
      this.mReceiver = null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("VipComicJumpActivity", 2, "VipComicJumpActivity onDestroy");
    }
  }
  
  void openComicPlugin(VipComicJumpActivity.ComicParam paramComicParam)
  {
    if (paramComicParam == null) {
      return;
    }
    Object localObject = ((ActivityManager)getApplication().getSystemService("activity")).getRunningAppProcesses();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        if ("com.tencent.mobileqq:tool".equals(((ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next()).processName))
        {
          bool = true;
          break label69;
        }
      }
    }
    boolean bool = false;
    label69:
    if ("com.tencent.hippy.qq.fragment.CommonHippyFragment".equals(paramComicParam.jdField_e_of_type_JavaLangString))
    {
      QQComicPluginBridge.a(this, paramComicParam.jdField_a_of_type_AndroidOsBundle);
      this.mHandler.removeMessages(1002);
      this.mHandler.sendEmptyMessageDelayed(1002, 10000L);
      ((IQQComicUtil)QRoute.api(IQQComicUtil.class)).reportClickEventTo644(null, "VIPCOMIC", "0X8005FCE", "0X8005FCE", paramComicParam.jdField_a_of_type_Int, 0, new String[] { String.valueOf(System.currentTimeMillis() - paramComicParam.jdField_b_of_type_Long), "1" });
      return;
    }
    loadComicRuntime(paramComicParam, bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.comic.VipComicJumpActivity
 * JD-Core Version:    0.7.0.1
 */