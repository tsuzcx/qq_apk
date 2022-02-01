import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.AppTask;
import android.app.ActivityManager.RecentTaskInfo;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.os.ResultReceiver;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.biz.qrcode.activity.ScannerActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.contact.troop.TroopActivity;
import com.tencent.mobileqq.activity.miniaio.MiniChatActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.appbrand.ui.AppBrandLaunchUI;
import com.tencent.mobileqq.mini.appbrand.ui.MiniAppWebviewFragment;
import com.tencent.mobileqq.mini.mainpage.MainPageFragment;
import com.tencent.mobileqq.mini.out.activity.MapActivity;
import com.tencent.mobileqq.mini.report.InnerAppReportDc4239;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.mini.utils.TroopApplicationListUtil;
import com.tencent.mobileqq.minigame.manager.GameCloseManager;
import com.tencent.mobileqq.minigame.ui.GameActivity1;
import com.tencent.mobileqq.minigame.utils.PathUtil;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.downloadnew.DownloadListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.proxyimpl.MiniAppProxyImpl.1;
import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.action.ActionBridge.GetShareStateActionBridge;
import com.tencent.qqmini.sdk.launcher.action.ActionBridge.PageActionBridge;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.IProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy.IChoosePhotoListner;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy.IDrawableLoadedCallBack;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy.SenderListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.PageGestureProxy;
import com.tencent.qqmini.sdk.launcher.model.AppMode;
import com.tencent.qqmini.sdk.launcher.model.EntryModel;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.ShareState;
import com.tencent.qqmini.sdk.launcher.shell.IActivityResultManager;
import com.tencent.qqmini.sdk.launcher.shell.IAppBrandProxy;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppEnv;
import com.tencent.qqmini.sdk.launcher.ui.MoreItem;
import com.tencent.qqmini.sdk.launcher.ui.MoreItemList.Builder;
import com.tencent.qqmini.sdk.launcher.ui.OnAppCloseAction;
import com.tencent.qqmini.sdk.launcher.ui.OnMoreItemSelectedListener;
import com.tencent.qqmini.sdk.utils.DebugUtil;
import com.tencent.smtt.sdk.QbSdk;
import common.config.service.QzoneConfig;
import java.io.Closeable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.Constants.PropertiesKey;
import mqq.manager.TicketManager;
import oicq.wlogin_sdk.request.Ticket;

@ProxyService(proxy=MiniAppProxy.class)
@RequiresApi(api=3)
public class bjww
  extends MiniAppProxy
{
  private static boolean jdField_b_of_type_Boolean;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), new bjxb(this));
  private MiniAppConfig jdField_a_of_type_ComTencentMobileqqMiniApkgMiniAppConfig;
  private DownloadListener jdField_a_of_type_ComTencentOpenDownloadnewDownloadListener = new bjxa(this);
  private IMiniAppContext jdField_a_of_type_ComTencentQqminiSdkLauncherCoreIMiniAppContext;
  private MiniAppInfo jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<Integer> jdField_a_of_type_JavaUtilArrayList = new MiniAppProxyImpl.1(this);
  private boolean jdField_a_of_type_Boolean;
  private String jdField_b_of_type_JavaLangString;
  private String c;
  
  private int a(aqcb paramaqcb)
  {
    int i = 0;
    if (paramaqcb.a())
    {
      if (paramaqcb.c()) {
        i = 2;
      }
    }
    else {
      return i;
    }
    return 1;
  }
  
  private void a(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.jdField_a_of_type_JavaLangString = paramString4;
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.c = paramString2;
    Bundle localBundle = new Bundle();
    localBundle.putString(bivp.jdField_b_of_type_JavaLangString, paramString1);
    localBundle.putString(bivp.j, paramString4);
    localBundle.putString(bivp.f, paramString2);
    localBundle.putInt(bivp.k, 2);
    localBundle.putString(bivp.i, "MiniApp");
    localBundle.putString(bivp.l, paramString3);
    localBundle.putInt(bivp.H, 1);
    bivl.a(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadListener);
    bivl.a(paramActivity, localBundle, "biz_src_miniapp", null, 0);
    QQToast.a(paramActivity, "开始下载", 1).a();
    InnerAppReportDc4239.innerAppReport(this.jdField_a_of_type_ComTencentMobileqqMiniApkgMiniAppConfig, null, "launchapp", "downloadapp", "qqdownload");
  }
  
  private void a(Context paramContext, String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (paramContext == null)) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("packageName", paramString2);
    localBundle.putString("appId", paramString1);
    localBundle.putString("big_brother_source_key", "biz_src_miniapp");
    if ((paramContext instanceof BasePluginActivity))
    {
      biqa.b(((BasePluginActivity)paramContext).getOutActivity(), localBundle);
      InnerAppReportDc4239.innerAppReport(this.jdField_a_of_type_ComTencentMobileqqMiniApkgMiniAppConfig, null, "launchapp", "downloadapp", "yybdownload");
      return;
    }
    if ((paramContext instanceof Activity))
    {
      biqa.b((Activity)paramContext, localBundle);
      InnerAppReportDc4239.innerAppReport(this.jdField_a_of_type_ComTencentMobileqqMiniApkgMiniAppConfig, null, "launchapp", "downloadapp", "yybdownload");
      return;
    }
    QLog.e("MiniAppProxyImpl", 2, "onOpenThridApp mContext 必现是一个Activity");
  }
  
  private void a(aqcb paramaqcb)
  {
    if (paramaqcb != null)
    {
      if (paramaqcb.c()) {
        break label28;
      }
      if (!paramaqcb.b()) {
        break label23;
      }
      paramaqcb.e();
    }
    label23:
    label28:
    while (!paramaqcb.c())
    {
      return;
      paramaqcb.i();
      return;
    }
    paramaqcb.f();
  }
  
  public static void a(IMiniAppContext paramIMiniAppContext)
  {
    AppLoaderFactory.g().getAppBrandProxy().onAppDestroy((Bundle)null);
    a(paramIMiniAppContext.getAttachedActivity());
    Process.killProcess(Process.myPid());
  }
  
  private void a(IMiniAppContext paramIMiniAppContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    MiniAppConfig localMiniAppConfig = bjxn.a(paramIMiniAppContext.getMiniAppInfo());
    MiniProgramLpReportDC04239.reportUserClick(localMiniAppConfig, MiniProgramLpReportDC04239.getAppType(localMiniAppConfig), ActionBridge.PageActionBridge.getPageUrl(paramIMiniAppContext), "user_click", "more_button", paramString);
  }
  
  private void a(MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("MiniAppProxyImpl", 1, "sendSetUserAppTopRequest, miniAppInfo = " + paramMiniAppInfo);
      }
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("appid", paramMiniAppInfo.appId);
    localBundle.putInt("topType", paramMiniAppInfo.topType);
    localBundle.putInt("verType", paramMiniAppInfo.verType);
    QIPCClientHelper.getInstance().callServer("MiniAppTransferModule", "sync_mini_app_data", localBundle, new bjxd(this, paramMiniAppInfo));
  }
  
  private static boolean a(Activity paramActivity)
  {
    if (Build.VERSION.SDK_INT < 21) {
      return false;
    }
    try
    {
      Object localObject = (ActivityManager)paramActivity.getSystemService("activity");
      if (localObject == null) {
        return false;
      }
      localObject = ((ActivityManager)localObject).getAppTasks();
      if (localObject == null) {
        return false;
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ActivityManager.AppTask localAppTask = (ActivityManager.AppTask)((Iterator)localObject).next();
        if ((localAppTask != null) && (localAppTask.getTaskInfo() != null) && (localAppTask.getTaskInfo().baseIntent != null) && (localAppTask.getTaskInfo().baseIntent.getComponent() != null))
        {
          QLog.e("miniapp", 1, "will finish and remove task: id=" + localAppTask.getTaskInfo().id);
          if ((localAppTask.getTaskInfo().baseIntent.getComponent().getClassName().equals(paramActivity.getClass().getName())) || (localAppTask.getTaskInfo().baseIntent.getComponent().getClassName().equals(paramActivity.getClass().getName()))) {
            localAppTask.finishAndRemoveTask();
          }
        }
      }
      return true;
    }
    catch (Throwable paramActivity)
    {
      QLog.e("miniapp", 1, "finishAndRemoveAllTasks exception.");
    }
    return false;
  }
  
  private boolean a(MiniAppInfo paramMiniAppInfo)
  {
    boolean bool = true;
    if (!AppNetConnInfo.isMobileConn())
    {
      QLog.i("MiniAppProxyImpl", 1, "shouldShowKingCardTip network type is wifi + " + AppNetConnInfo.isWifiConn());
      return false;
    }
    if ((paramMiniAppInfo != null) && (paramMiniAppInfo.appMode != null) && (paramMiniAppInfo.appMode.isWangKa)) {}
    for (int i = 1; i == 0; i = 0)
    {
      QLog.i("MiniAppProxyImpl", 1, "shouldShowKingCardTip， not wangka app");
      return false;
    }
    i = bhhb.a();
    QLog.i("MiniAppProxyImpl", 1, "shouldShowKingCardTip， king card status = " + i);
    if (i == 1) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  private void b(MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo == null)
    {
      QLog.e("MiniAppProxyImpl", 1, "setMiniAppTop, miniAppInfo = null.");
      return;
    }
    MiniAppCmdUtil.getInstance().setUserAppTop(paramMiniAppInfo.appId, paramMiniAppInfo.topType, paramMiniAppInfo.verType, null, new bjxe(this, paramMiniAppInfo));
  }
  
  private boolean b(MiniAppInfo paramMiniAppInfo)
  {
    if (d(paramMiniAppInfo)) {
      return paramMiniAppInfo.launchParam.entryModel.isAdmin;
    }
    return false;
  }
  
  private void c(IMiniAppContext paramIMiniAppContext)
  {
    if ((paramIMiniAppContext == null) || (paramIMiniAppContext.getAttachedActivity() == null))
    {
      QLog.e("MiniAppProxyImpl", 1, "setMiniAppToTroopApplicationList, miniAppContext is null.");
      return;
    }
    QLog.d("MiniAppProxyImpl", 1, "setMiniAppToTroopApplicationList");
    Object localObject = AppLoaderFactory.g().getMiniAppEnv().getActivityResultManager();
    ((IActivityResultManager)localObject).addActivityResultListener(new bjxc(this, (IActivityResultManager)localObject, paramIMiniAppContext));
    localObject = new Intent(paramIMiniAppContext.getAttachedActivity(), TroopActivity.class);
    ((Intent)localObject).putExtra("onlyOneSegement", true);
    ((Intent)localObject).putExtra("_key_mode", 0);
    ((Intent)localObject).putExtra("key_tab_mode", 0);
    ((Intent)localObject).putExtra("is_select_troop", true);
    ((Intent)localObject).putExtra("key_from", 3);
    paramIMiniAppContext.getAttachedActivity().startActivityForResult((Intent)localObject, 1002);
  }
  
  private boolean c(MiniAppInfo paramMiniAppInfo)
  {
    return !d(paramMiniAppInfo);
  }
  
  private void d(IMiniAppContext paramIMiniAppContext)
  {
    QLog.d("MiniAppProxyImpl", 1, "addToCurrentTroop");
    try
    {
      paramIMiniAppContext = paramIMiniAppContext.getMiniAppInfo();
      TroopApplicationListUtil.addMiniAppToTroopApplicationList(String.valueOf(paramIMiniAppContext.launchParam.entryModel.uin), paramIMiniAppContext.appId, null);
      return;
    }
    catch (Exception paramIMiniAppContext)
    {
      QLog.e("MiniAppProxyImpl", 1, "addToCurrentTroop exception: " + Log.getStackTraceString(paramIMiniAppContext));
    }
  }
  
  private boolean d(MiniAppInfo paramMiniAppInfo)
  {
    return (paramMiniAppInfo != null) && (paramMiniAppInfo.launchParam != null) && (paramMiniAppInfo.launchParam.entryModel != null);
  }
  
  private void e(IMiniAppContext paramIMiniAppContext)
  {
    MiniAppInfo localMiniAppInfo = paramIMiniAppContext.getMiniAppInfo();
    Activity localActivity = paramIMiniAppContext.getAttachedActivity();
    if ((localMiniAppInfo != null) && (localActivity != null)) {
      paramIMiniAppContext = "";
    }
    try
    {
      localObject = URLEncoder.encode("https://support.qq.com/data/1368/2018/0927/5e6c84b68d1f3ad390e7beeb6c2f83b0.jpeg", "UTF-8");
      paramIMiniAppContext = (IMiniAppContext)localObject;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        Object localObject;
        QLog.e("MiniAppProxyImpl", 1, "startComplainAndCallback, url = " + "");
        localUnsupportedEncodingException.printStackTrace();
      }
    }
    localObject = "https://tucao.qq.com/qq_miniprogram/tucao?appid=" + localMiniAppInfo.appId + "&openid=" + MainPageFragment.getUin() + "&avatar=" + paramIMiniAppContext + anni.a(2131700157);
    paramIMiniAppContext = new Intent(localActivity, QQBrowserActivity.class);
    paramIMiniAppContext.putExtra("url", (String)localObject);
    localObject = new Bundle();
    ((Bundle)localObject).putBoolean("hide_more_button", true);
    paramIMiniAppContext.putExtras((Bundle)localObject);
    localActivity.startActivity(paramIMiniAppContext);
    paramIMiniAppContext = bjxn.a(localMiniAppInfo);
    MiniProgramLpReportDC04239.reportUserClick(paramIMiniAppContext, MiniProgramLpReportDC04239.getAppType(paramIMiniAppContext), null, "user_click", "more_button", "report");
  }
  
  public boolean VerifyFile(int paramInt, String paramString)
  {
    return false;
  }
  
  public void a()
  {
    boolean bool2 = false;
    if (this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreIMiniAppContext == null) {}
    Activity localActivity;
    boolean bool3;
    do
    {
      return;
      localActivity = this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreIMiniAppContext.getAttachedActivity();
      bool3 = localActivity instanceof GameActivity1;
    } while (this.jdField_a_of_type_Boolean);
    Object localObject1 = this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreIMiniAppContext.getMiniAppInfo();
    ShareState localShareState = (ShareState)this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreIMiniAppContext.performAction(ActionBridge.GetShareStateActionBridge.obtain());
    boolean bool4 = ((MiniAppInfo)localObject1).isLimitedAccessApp();
    boolean bool1;
    Object localObject2;
    int i;
    if (((MiniAppInfo)localObject1).isEngineTypeMiniGame()) {
      if ((localShareState.showRestart) && (QzoneConfig.getInstance().getConfig("qqminiapp", "mini_game_capsule_show_restart_btn", 1) == 1))
      {
        bool1 = true;
        if (!bool3) {
          break label621;
        }
        localObject2 = ((GameActivity1)localActivity).getColorNoteController();
        if ((bool4) || (localObject2 == null)) {
          break label678;
        }
        i = a((aqcb)localObject2);
      }
    }
    for (;;)
    {
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("miniAppID", ((MiniAppInfo)localObject1).appId);
      ((Intent)localObject2).putExtra("miniAppName", ((MiniAppInfo)localObject1).name);
      ((Intent)localObject2).putExtra("isOpenMonitorPanel", jdField_b_of_type_Boolean);
      ((Intent)localObject2).putExtra("debugEnable", DebugUtil.getDebugEnabled((MiniAppInfo)localObject1));
      ((Intent)localObject2).putExtra("showDebug", localShareState.showDebug);
      ((Intent)localObject2).putExtra("showMonitor", localShareState.showMonitor);
      ((Intent)localObject2).putExtra("menuStyle", AppLoaderFactory.g().getMiniAppEnv().getMenuStyle());
      ((Intent)localObject2).putExtra("showShareQQ", localShareState.withShareQQ);
      ((Intent)localObject2).putExtra("showShareQzone", localShareState.withShareQzone);
      ((Intent)localObject2).putExtra("showShareWeChatFriends", localShareState.withShareWeChatFriend);
      ((Intent)localObject2).putExtra("showShareWeChatMoment", localShareState.withShareWeChatMoment);
      ((Intent)localObject2).putExtra("topType", ((MiniAppInfo)localObject1).topType);
      ((Intent)localObject2).putExtra("showDetail", true);
      ((Intent)localObject2).putExtra("showSetting", true);
      ((Intent)localObject2).putExtra("showComplaint", true);
      if (Build.VERSION.SDK_INT >= 21) {
        bool2 = true;
      }
      ((Intent)localObject2).putExtra("addShortcut", bool2);
      ((Intent)localObject2).putExtra("showBackHome", -1);
      ((Intent)localObject2).putExtra("isLandscape", localShareState.isOrientationLandscape);
      ((Intent)localObject2).putExtra("isSpecialMiniApp", ((MiniAppInfo)localObject1).isSpecialMiniApp());
      ((Intent)localObject2).putExtra("showKingcardTip", a((MiniAppInfo)localObject1));
      ((Intent)localObject2).putExtra("key_mini_msgtab_type", 1);
      ((Intent)localObject2).putExtra("key_mini_msgtab_need_action_sheet", true);
      ((Intent)localObject2).putExtra("key_mini_app_config", bjxn.a((MiniAppInfo)localObject1));
      ((Intent)localObject2).putExtra("key_color_note", i);
      ((Intent)localObject2).putExtra("key_mini_app_is_game", bool3);
      ((Intent)localObject2).putExtra("key_mini_app_version_type", ((MiniAppInfo)localObject1).verType);
      ((Intent)localObject2).putExtra("is_limited_access_app", bool4);
      ((Intent)localObject2).putExtra("showRestartMiniApp", bool1);
      ((Intent)localObject2).putExtra("setToTroop", c((MiniAppInfo)localObject1));
      ((Intent)localObject2).putExtra("addToCurrentTroop", b((MiniAppInfo)localObject1));
      localObject1 = AppLoaderFactory.g().getMiniAppEnv().getActivityResultManager();
      ((IActivityResultManager)localObject1).addActivityResultListener(new bjxh(this, (IActivityResultManager)localObject1));
      MiniChatActivity.a(localActivity, (Intent)localObject2, 9527);
      QLog.d("MiniAppProxyImpl", 1, "set isMiniMsgTabShow true");
      this.jdField_a_of_type_Boolean = true;
      a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreIMiniAppContext, "open");
      return;
      bool1 = false;
      break;
      bool1 = localShareState.showRestart;
      break;
      label621:
      localObject2 = (PageGestureProxy)AppLoaderFactory.g().getProxyManager().get(PageGestureProxy.class);
      if ((localObject2 instanceof bjyg))
      {
        localObject2 = ((bjyg)localObject2).a();
        if ((!bool4) && (localObject2 != null))
        {
          i = a((aqcb)localObject2);
          continue;
        }
      }
      label678:
      i = 0;
    }
  }
  
  public boolean addShortcut(Context paramContext, MiniAppInfo paramMiniAppInfo, AsyncResult paramAsyncResult)
  {
    bjyw.a((Activity)paramContext, paramMiniAppInfo, new bjwx(this, paramAsyncResult));
    return true;
  }
  
  public void b(IMiniAppContext paramIMiniAppContext)
  {
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1000, 500L);
    MiniAppInfo localMiniAppInfo = paramIMiniAppContext.getMiniAppInfo();
    int i = 3;
    paramIMiniAppContext = null;
    if (localMiniAppInfo != null)
    {
      i = localMiniAppInfo.verType;
      paramIMiniAppContext = localMiniAppInfo.appId;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("appid", paramIMiniAppContext);
    localBundle.putInt("verType", i);
    QIPCClientHelper.getInstance().callServer("MiniAppTransferModule", "query_mini_app_data", localBundle, new bjxg(this, localMiniAppInfo));
  }
  
  public boolean chooseLocation(Context paramContext, AsyncResult paramAsyncResult)
  {
    IActivityResultManager localIActivityResultManager = AppLoaderFactory.g().getMiniAppEnv().getActivityResultManager();
    localIActivityResultManager.addActivityResultListener(new bjwz(this, paramAsyncResult, localIActivityResultManager));
    paramAsyncResult = new Intent(paramContext, MapActivity.class);
    paramAsyncResult.putExtra("key_type", 2);
    ((BaseActivity)paramContext).startActivityForResult(paramAsyncResult, 3);
    return true;
  }
  
  public boolean downloadApp(Context paramContext, MiniAppInfo paramMiniAppInfo, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo = paramMiniAppInfo;
    this.jdField_a_of_type_ComTencentMobileqqMiniApkgMiniAppConfig = bjxn.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo);
    if (!TextUtils.isEmpty(paramString4))
    {
      QLog.d("MiniAppProxyImpl", 1, "手Q下载");
      a((Activity)paramContext, paramString1, paramString2, paramString3, paramString4);
      return true;
    }
    QLog.d("MiniAppProxyImpl", 1, "应用宝微下载");
    a(paramContext, paramString1, paramString2);
    return true;
  }
  
  public boolean enterQRCode(Context paramContext, boolean paramBoolean, AsyncResult paramAsyncResult)
  {
    BaseActivity localBaseActivity = (BaseActivity)paramContext;
    if (!alcp.a(localBaseActivity))
    {
      paramAsyncResult.onReceiveResult(false, null);
      return true;
    }
    paramContext = new Intent((BaseActivity)paramContext, ScannerActivity.class);
    paramContext.putExtra("leftViewText", localBaseActivity.getString(2131690563));
    paramContext.putExtra("selfSet_leftViewText", localBaseActivity.getString(2131690563));
    paramContext.putExtra("start_time", System.currentTimeMillis());
    paramContext.putExtra("from", "mini_app");
    if (paramBoolean) {
      paramContext.putExtra("hide_album", true);
    }
    paramContext.setFlags(67108864);
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null) {}
    try
    {
      localBaseActivity.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = new bjxi(this, paramAsyncResult);
      paramAsyncResult = new IntentFilter("com.tencent.mobileqq.mini.out.plugins.scanResultAction");
      localBaseActivity.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramAsyncResult, "com.tencent.msg.permission.pushnotify", null);
      localBaseActivity.startActivity(paramContext);
      return true;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("MiniAppProxyImpl", 1, "unregisterReceiver error." + localException);
      }
    }
  }
  
  public String getA2()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (localAppRuntime == null) {
      return "";
    }
    TicketManager localTicketManager = (TicketManager)localAppRuntime.getManager(2);
    if (localTicketManager != null) {
      return localTicketManager.getA2(localAppRuntime.getAccount());
    }
    return "";
  }
  
  public String getAccount()
  {
    return BaseApplicationImpl.getApplication().getRuntime().getAccount();
  }
  
  public String getAmsAppId()
  {
    return null;
  }
  
  public String getAppId()
  {
    return null;
  }
  
  public String getAppName()
  {
    return "qq";
  }
  
  public String getAppVersion()
  {
    return "8.4.1.4680";
  }
  
  public Drawable getDrawable(Context paramContext, String paramString, int paramInt1, int paramInt2, Drawable paramDrawable)
  {
    paramContext = URLDrawable.URLDrawableOptions.obtain();
    paramContext.mPlayGifImage = true;
    paramContext.mKeyAddWHSuffix = false;
    paramContext.mRequestWidth = paramInt1;
    paramContext.mRequestHeight = paramInt2;
    paramContext.mFailedDrawable = paramDrawable;
    paramContext.mLoadingDrawable = paramDrawable;
    if (PathUtil.isNetworkUrl(paramString)) {
      return URLDrawable.getDrawable(paramString, paramContext);
    }
    return URLDrawable.getFileDrawable(paramString, paramContext);
  }
  
  public String getImei()
  {
    return biuf.c();
  }
  
  public boolean getLocation(Context paramContext, String paramString, boolean paramBoolean, AsyncResult paramAsyncResult)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramString.equals("wgs84"))) {}
    for (boolean bool = true;; bool = false)
    {
      SosoInterface.a(new bjwy(this, 0, true, true, 5000L, false, false, "miniApp", bool, paramBoolean, paramAsyncResult));
      return true;
    }
  }
  
  public byte[] getLoginSig()
  {
    return new byte[0];
  }
  
  public int getLoginType()
  {
    return 0;
  }
  
  public OnMoreItemSelectedListener getMoreItemSelectedListener()
  {
    return null;
  }
  
  public ArrayList<MoreItem> getMoreItems(MoreItemList.Builder paramBuilder)
  {
    return null;
  }
  
  public String getNickName()
  {
    return BaseApplicationImpl.getApplication().getProperty(Constants.PropertiesKey.nickName.toString() + BaseApplicationImpl.getApplication().getRuntime().getAccount());
  }
  
  public String getPayAccessToken()
  {
    return null;
  }
  
  public String getPayOpenId()
  {
    return BaseApplicationImpl.getApplication().getRuntime().getAccount();
  }
  
  public String getPayOpenKey()
  {
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    if (localObject1 == null) {
      localObject1 = "";
    }
    Object localObject2;
    do
    {
      return localObject1;
      localObject2 = (TicketManager)((AppRuntime)localObject1).getManager(2);
      if (localObject2 == null) {
        break;
      }
      localObject1 = ((TicketManager)localObject2).GetSkey(((AppRuntime)localObject1).getAccount(), 16L, null);
      if ((localObject1 == null) || (((Ticket)localObject1)._sig == null)) {
        break;
      }
      localObject2 = new String(((Ticket)localObject1)._sig);
      localObject1 = localObject2;
    } while (!QLog.isColorLevel());
    QLog.i("MiniAppProxyImpl", 2, "get skey sucess.: " + (String)localObject2);
    return localObject2;
    return "";
  }
  
  public String getPlatformId()
  {
    return "10000";
  }
  
  public String getPlatformQUA()
  {
    return blru.a();
  }
  
  public String getSoPath()
  {
    return null;
  }
  
  public int getTbsVersion()
  {
    return QbSdk.getTbsVersion(BaseApplicationImpl.getApplication());
  }
  
  public boolean isDebugVersion()
  {
    return false;
  }
  
  public void muteAudioFocus(Context paramContext, boolean paramBoolean)
  {
    bgkl.a(paramContext, paramBoolean);
  }
  
  public void notifyMiniAppInfo(int paramInt, MiniAppInfo paramMiniAppInfo) {}
  
  public OnAppCloseAction onAppClose(MiniAppInfo paramMiniAppInfo, Closeable paramCloseable)
  {
    return null;
  }
  
  public void onAppStateChange(MiniAppInfo paramMiniAppInfo, int paramInt) {}
  
  public boolean onCapsuleButtonCloseClick(IMiniAppContext paramIMiniAppContext, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramIMiniAppContext == null) {}
    Activity localActivity;
    String str;
    do
    {
      do
      {
        return false;
        localActivity = paramIMiniAppContext.getAttachedActivity();
        paramIMiniAppContext = paramIMiniAppContext.getMiniAppInfo();
      } while ((localActivity == null) || (paramIMiniAppContext == null));
      str = getAppName();
    } while ((!"qq".equalsIgnoreCase(str)) && (!"qi".equalsIgnoreCase(str)) && (!"ssq".equalsIgnoreCase(str)));
    return GameCloseManager.showRetainGuideDialog(localActivity, paramIMiniAppContext.appId, paramIMiniAppContext.launchParam.scene, paramIMiniAppContext.via, paramOnClickListener);
  }
  
  public boolean onCapsuleButtonMoreClick(IMiniAppContext paramIMiniAppContext)
  {
    QLog.d("MiniAppProxyImpl", 1, "onCapsuleButtonMoreClick");
    if (paramIMiniAppContext == null)
    {
      QLog.w("MiniAppProxyImpl", 1, "miniRuntime is null, no need to response more button");
      return false;
    }
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreIMiniAppContext = paramIMiniAppContext;
    Object localObject = paramIMiniAppContext.getAttachedActivity();
    if ((localObject == null) || (((Activity)localObject).isFinishing()))
    {
      QLog.w("MiniAppProxyImpl", 1, "Activity is not exiting, no need to response more button");
      return false;
    }
    localObject = paramIMiniAppContext.getMiniAppInfo();
    if (localObject == null)
    {
      QLog.w("MiniAppProxyImpl", 1, "MiniAppInfo is null, no need to response more button");
      return false;
    }
    ShareState localShareState = (ShareState)paramIMiniAppContext.performAction(ActionBridge.GetShareStateActionBridge.obtain());
    if (((MiniAppInfo)localObject).verType != 3)
    {
      localShareState.showDebug = true;
      localShareState.showMonitor = true;
    }
    if (QzoneConfig.getInstance().getConfig("qqminiapp", "mini_app_share_to_wx_switcher", 1) != 1)
    {
      localShareState.withShareWeChatFriend = false;
      localShareState.withShareWeChatMoment = false;
    }
    b(paramIMiniAppContext);
    return true;
  }
  
  public boolean openChoosePhotoActivity(Context paramContext, int paramInt, MiniAppProxy.IChoosePhotoListner paramIChoosePhotoListner)
  {
    paramIChoosePhotoListner = new Intent(paramContext, NewPhotoListActivity.class);
    paramIChoosePhotoListner.putExtra("enter_from", 4);
    paramIChoosePhotoListner.putExtra("PhotoConst.MAXUM_SELECTED_NUM", paramInt);
    paramIChoosePhotoListner.putExtra("PhotoConst.IS_SINGLE_MODE", false);
    paramIChoosePhotoListner.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 6);
    paramIChoosePhotoListner.putExtra("PhotoConst.DEST_BROADCAST_ACTION_NAME", "micro_api_choose_image");
    paramIChoosePhotoListner.putExtra("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", true);
    paramContext.startActivity(paramIChoosePhotoListner);
    bgkc.anim((Activity)paramContext, false, true);
    return true;
  }
  
  public boolean openImagePreview(Context paramContext, int paramInt, List<String> paramList)
  {
    Intent localIntent = new Intent(paramContext, TroopAvatarWallPreviewActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putInt("index", paramInt);
    localBundle.putStringArrayList("seqNum", (ArrayList)paramList);
    localBundle.putBoolean("needBottomBar", false);
    localBundle.putBoolean("is_show_action", true);
    localBundle.putBoolean("is_not_show_index", true);
    localBundle.putBoolean("is_need_to_aio", false);
    localBundle.putBoolean("is_from_plugin", true);
    localIntent.putExtras(localBundle);
    localIntent.addFlags(603979776);
    paramContext.startActivity(localIntent);
    return true;
  }
  
  public boolean openLocation(Context paramContext, double paramDouble1, double paramDouble2, int paramInt, String paramString1, String paramString2)
  {
    Intent localIntent = new Intent(paramContext, MapActivity.class);
    localIntent.putExtra("key_type", 1);
    localIntent.putExtra("latitude", paramDouble1);
    localIntent.putExtra("longitude", paramDouble2);
    localIntent.putExtra("scale", paramInt);
    localIntent.putExtra("name", paramString1);
    localIntent.putExtra("address", paramString2);
    paramContext.startActivity(localIntent);
    return true;
  }
  
  public boolean openSchema(Context paramContext, String paramString, int paramInt, ResultReceiver paramResultReceiver)
  {
    if ((MiniAppLauncher.isMiniAppScheme(paramString)) && (paramInt != -1)) {
      MiniAppLauncher.startMiniApp(paramContext, paramString, paramInt, null);
    }
    while (paramContext == null) {
      return true;
    }
    Intent localIntent = new Intent(paramContext, AppBrandLaunchUI.class);
    localIntent.putExtra("from", "SchemeJsPlugin");
    localIntent.putExtra("scheme", paramString);
    localIntent.putExtra("result_receiver", paramResultReceiver);
    paramContext.startActivity(localIntent);
    return true;
  }
  
  public void sendData(byte[] paramArrayOfByte, MiniAppProxy.SenderListener paramSenderListener) {}
  
  public void setDrawableCallback(Drawable paramDrawable, MiniAppProxy.IDrawableLoadedCallBack paramIDrawableLoadedCallBack)
  {
    if ((paramDrawable != null) && ((paramDrawable instanceof URLDrawable))) {
      ((URLDrawable)paramDrawable).setURLDrawableListener(new bjxf(this, paramIDrawableLoadedCallBack));
    }
  }
  
  public boolean startBrowserActivity(Context paramContext, Intent paramIntent)
  {
    paramIntent.setComponent(new ComponentName(paramContext, QQBrowserActivity.class));
    paramIntent.putExtra("fragmentClass", MiniAppWebviewFragment.class);
    paramContext.startActivity(paramIntent);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjww
 * JD-Core Version:    0.7.0.1
 */