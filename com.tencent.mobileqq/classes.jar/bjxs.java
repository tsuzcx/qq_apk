import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.microapp.ext.GameProxy;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.app.MiniAppStateManager;
import com.tencent.mobileqq.mini.launch.MiniSdkLauncher;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher.MiniAppLaunchListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.proxyimpl.NavigationJsPlugin.1;
import com.tencent.qqmini.proxyimpl.NavigationJsPlugin.4;
import com.tencent.qqmini.proxyimpl.NavigationJsPlugin.6;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.IProxyManager;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.WnsConfigProxy;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.model.EntryModel;
import common.config.service.QzoneConfig;
import org.json.JSONObject;

@JsPlugin
public class bjxs
  extends BaseJsPlugin
{
  private static final int jdField_a_of_type_Int = QzoneConfig.getInstance().getConfig("qqminiapp", "mini_app_navigate_back_by_appinfo", 1);
  private WnsConfigProxy jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyWnsConfigProxy = (WnsConfigProxy)AppLoaderFactory.g().getProxyManager().get(WnsConfigProxy.class);
  
  private void a(com.tencent.mobileqq.mini.apkg.MiniAppInfo paramMiniAppInfo)
  {
    ThreadManagerV2.excute(new NavigationJsPlugin.4(this, paramMiniAppInfo), 32, null, true);
  }
  
  private void a(com.tencent.mobileqq.mini.apkg.MiniAppInfo paramMiniAppInfo, String paramString1, String paramString2, MiniAppLauncher.MiniAppLaunchListener paramMiniAppLaunchListener)
  {
    com.tencent.mobileqq.mini.sdk.LaunchParam localLaunchParam = new com.tencent.mobileqq.mini.sdk.LaunchParam();
    localLaunchParam.miniAppId = paramMiniAppInfo.appId;
    localLaunchParam.scene = 1038;
    localLaunchParam.navigateExtData = paramString1;
    localLaunchParam.privateExtraData = paramString2;
    localLaunchParam.fromBackToMiniApp = 1;
    localLaunchParam.fromMiniAppId = this.mApkgInfo.appId;
    paramMiniAppInfo = new MiniAppConfig(paramMiniAppInfo);
    paramMiniAppInfo.launchParam = localLaunchParam;
    MiniAppController.startApp(this.mMiniAppContext.getAttachedActivity(), paramMiniAppInfo, new NavigationJsPlugin.6(this, new Handler(Looper.getMainLooper()), paramMiniAppLaunchListener));
  }
  
  private boolean a(String paramString1, String paramString2, String paramString3)
  {
    com.tencent.mobileqq.mini.sdk.LaunchParam localLaunchParam = new com.tencent.mobileqq.mini.sdk.LaunchParam();
    localLaunchParam.miniAppId = paramString1;
    localLaunchParam.scene = 1038;
    localLaunchParam.navigateExtData = paramString2;
    localLaunchParam.privateExtraData = paramString3;
    localLaunchParam.fromMiniAppId = this.mApkgInfo.appId;
    paramString2 = this.mMiniAppContext.getAttachedActivity();
    MiniAppController.navigateBackMiniApp(paramString2, paramString1, localLaunchParam, new bjxv(this, paramString2));
    return true;
  }
  
  @JsEvent({"exitMiniProgram"})
  public void exitMiniProgram(RequestEvent paramRequestEvent)
  {
    AppBrandTask.runTaskOnUiThread(new NavigationJsPlugin.1(this, this.mMiniAppContext.getAttachedActivity()));
    paramRequestEvent.ok();
  }
  
  @JsEvent({"navigateBackMiniProgram"})
  public void navigateBackMiniProgram(RequestEvent paramRequestEvent)
  {
    Object localObject1;
    String str;
    Object localObject2;
    try
    {
      localObject1 = new JSONObject(paramRequestEvent.jsonParams);
      if (jdField_a_of_type_Int == 0)
      {
        str = ((JSONObject)localObject1).optString("extraData");
        localObject1 = ((JSONObject)localObject1).optString("privateExtraData");
        localObject2 = this.mMiniAppInfo.launchParam.fromMiniAppId;
        if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (a((String)localObject2, str, (String)localObject1)))
        {
          paramRequestEvent.ok();
          return;
        }
        paramRequestEvent.fail();
        return;
      }
    }
    catch (Throwable paramRequestEvent)
    {
      QLog.e("NavigationJsPlugin", 1, "navigateBackMiniProgram error, ", paramRequestEvent);
      return;
    }
    if (jdField_a_of_type_Int == 1)
    {
      str = ((JSONObject)localObject1).optString("extraData");
      localObject1 = ((JSONObject)localObject1).optString("privateExtraData");
      localObject2 = MiniSdkLauncher.convert(this.mMiniAppInfo.launchParam.fromMiniAppInfo);
      if (localObject2 != null) {
        a((com.tencent.mobileqq.mini.apkg.MiniAppInfo)localObject2, str, (String)localObject1, new bjxt(this, paramRequestEvent));
      }
    }
  }
  
  @JsEvent({"navigateToMiniProgram"})
  public void navigateToMiniProgram(RequestEvent paramRequestEvent)
  {
    int j = 2001;
    try
    {
      localJSONObject = new JSONObject(paramRequestEvent.jsonParams);
      MiniAppStateManager.getInstance().notifyChange("hideInput");
      if (localJSONObject != null)
      {
        str2 = localJSONObject.optString("reportData");
        localObject4 = com.tencent.mobileqq.mini.apkg.MiniAppInfo.createMiniAppInfo(localJSONObject);
        localMiniAppInfo = this.mMiniAppContext.getMiniAppInfo();
        localEntryModel = localMiniAppInfo.launchParam.entryModel;
        if (localObject4 == null) {
          break label388;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        String str2;
        com.tencent.qqmini.sdk.launcher.model.MiniAppInfo localMiniAppInfo;
        EntryModel localEntryModel;
        Object localObject3;
        int i;
        Object localObject5;
        Object localObject1;
        try
        {
          JSONObject localJSONObject;
          localObject3 = this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyWnsConfigProxy.getConfig("qqminiapp", "miniappsearchappid");
          Object localObject2 = localObject3;
          if (bgsp.a((String)localObject3)) {
            localObject2 = "1109875297";
          }
          if ((this.mMiniAppContext.getMiniAppInfo() != null) && (((String)localObject2).equals(this.mMiniAppContext.getMiniAppInfo().appId)))
          {
            i = 2077;
            localObject2 = localJSONObject.optJSONObject("extraData");
            if (localObject2 == null) {
              break label726;
            }
            localObject2 = ((JSONObject)localObject2).toString();
            localObject3 = localJSONObject.optJSONObject("privateExtraData");
            if (localObject3 != null)
            {
              localObject3 = ((JSONObject)localObject3).toString();
              localObject5 = new com.tencent.mobileqq.mini.sdk.LaunchParam();
              ((com.tencent.mobileqq.mini.sdk.LaunchParam)localObject5).scene = i;
              ((com.tencent.mobileqq.mini.sdk.LaunchParam)localObject5).fromMiniAppId = localMiniAppInfo.launchParam.miniAppId;
              ((com.tencent.mobileqq.mini.sdk.LaunchParam)localObject5).navigateExtData = ((String)localObject2);
              ((com.tencent.mobileqq.mini.sdk.LaunchParam)localObject5).privateExtraData = ((String)localObject3);
              if (localEntryModel != null) {
                ((com.tencent.mobileqq.mini.sdk.LaunchParam)localObject5).entryModel = bjxn.a(localEntryModel);
              }
              localObject2 = com.tencent.mobileqq.mini.apkg.MiniAppInfo.createMiniAppInfo(localJSONObject);
              MiniAppController.launchMiniAppByAppInfo(this.mMiniAppContext.getAttachedActivity(), (com.tencent.mobileqq.mini.apkg.MiniAppInfo)localObject2, (com.tencent.mobileqq.mini.sdk.LaunchParam)localObject5);
              paramRequestEvent.ok();
              QLog.d("NavigationJsPlugin", 1, "navigateToMiniProgram, open miniApp from appInfo, appInfo: " + ((com.tencent.mobileqq.mini.apkg.MiniAppInfo)localObject4).toString());
              if (((com.tencent.mobileqq.mini.apkg.MiniAppInfo)localObject4).verType == 3) {
                a((com.tencent.mobileqq.mini.apkg.MiniAppInfo)localObject2);
              }
              return;
              localThrowable = localThrowable;
              QLog.e("NavigationJsPlugin", 1, localThrowable.getMessage(), localThrowable);
              localObject1 = null;
            }
          }
          else
          {
            if (!localMiniAppInfo.isAppStoreMiniApp()) {
              break label719;
            }
            i = 2001;
            break label716;
          }
          localObject3 = "";
          continue;
          i = ((JSONObject)localObject1).optInt("openType");
        }
        catch (Exception localException)
        {
          QLog.e("NavigationJsPlugin", 1, "navigateToMiniProgram, " + Log.getStackTraceString(localException));
        }
        label388:
        Object localObject4 = ((JSONObject)localObject1).optString("appId");
        if (i == 0)
        {
          localObject5 = ((JSONObject)localObject1).optString("path");
          str1 = ((JSONObject)localObject1).optString("envVersion");
          localObject3 = ((JSONObject)localObject1).optJSONObject("extraData");
          if (localObject3 != null)
          {
            localObject3 = ((JSONObject)localObject3).toString();
            if ((this.mMiniAppInfo == null) || (!"release".equals(this.mMiniAppInfo.getVerTypeStr()))) {
              break label713;
            }
            str1 = "release";
          }
        }
        label669:
        label713:
        for (;;)
        {
          com.tencent.mobileqq.mini.sdk.LaunchParam localLaunchParam = new com.tencent.mobileqq.mini.sdk.LaunchParam();
          if (localMiniAppInfo.isAppStoreMiniApp())
          {
            i = j;
            label499:
            localLaunchParam.scene = i;
            localLaunchParam.entryPath = ((String)localObject5);
            localLaunchParam.navigateExtData = ((String)localObject3);
            localLaunchParam.fromMiniAppId = localMiniAppInfo.launchParam.miniAppId;
            localLaunchParam.entryModel = bjxn.b(localEntryModel);
            localLaunchParam.envVersion = str1;
            localLaunchParam.reportData = str2;
            localObject1 = ((JSONObject)localObject1).optJSONObject("privateExtraData");
            if (localObject1 == null) {
              break label669;
            }
          }
          for (localObject1 = ((JSONObject)localObject1).toString();; localObject1 = "")
          {
            localLaunchParam.privateExtraData = ((String)localObject1);
            if ((!localMiniAppInfo.isSpecialMiniApp()) && (jdField_a_of_type_Int == 1))
            {
              localLaunchParam.fromEnvVersion = localMiniAppInfo.getVerTypeStr();
              localLaunchParam.fromMiniAppInfo = MiniSdkLauncher.convert(localMiniAppInfo);
            }
            MiniAppController.startAppByAppid(this.mMiniAppContext.getAttachedActivity(), (String)localObject4, (String)localObject5, str1, localLaunchParam, new bjxu(this, paramRequestEvent));
            paramRequestEvent.ok();
            return;
            localObject3 = "";
            break;
            i = 1037;
            break label499;
          }
          if (i != 1) {
            break;
          }
          if (GameProxy.startGameByMiniApp(this.mMiniAppContext.getAttachedActivity(), (String)localObject4, (JSONObject)localObject1))
          {
            paramRequestEvent.ok();
            return;
          }
          paramRequestEvent.fail();
          return;
        }
        for (;;)
        {
          label716:
          break;
          label719:
          i = 1037;
        }
        label726:
        String str1 = "";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjxs
 * JD-Core Version:    0.7.0.1
 */