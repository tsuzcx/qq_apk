package com.tencent.mobileqq.apollo.web.jsmodule;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.apollo.ipc.ApolloIPCModule;
import com.tencent.mobileqq.apollo.store.ApolloFloatActivity;
import com.tencent.mobileqq.apollo.store.ApolloGuestsStateActivity;
import com.tencent.mobileqq.apollo.store.ApolloStoreViewController;
import com.tencent.mobileqq.apollo.store.IApolloActivityJsCallBack;
import com.tencent.mobileqq.apollo.utils.ApolloHardWareTester;
import com.tencent.mobileqq.apollo.utils.RequestRoute;
import com.tencent.mobileqq.apollo.web.CmshowWebReqParam;
import com.tencent.mobileqq.apollo.web.ipc.IStoreAvatar2D;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloEngine;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin;
import com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class StoreJsModule
  extends BaseJsModule
{
  public StoreJsModule(VasWebviewJsPlugin paramVasWebviewJsPlugin)
  {
    super(paramVasWebviewJsPlugin);
  }
  
  @RequestRoute(a="closeWebview")
  private void closeWebview(@NonNull CmshowWebReqParam paramCmshowWebReqParam)
  {
    String str = paramCmshowWebReqParam.b;
    paramCmshowWebReqParam = paramCmshowWebReqParam.c;
    paramCmshowWebReqParam.finish();
    if (!(paramCmshowWebReqParam instanceof IApolloActivityJsCallBack)) {
      paramCmshowWebReqParam.overridePendingTransition(0, 0);
    }
    b(str);
  }
  
  @RequestRoute(a="downloadTbs")
  private void downloadTbs(@NonNull CmshowWebReqParam paramCmshowWebReqParam)
  {
    paramCmshowWebReqParam = a().b();
    if ((paramCmshowWebReqParam instanceof BrowserAppInterface)) {
      ((BrowserAppInterface)paramCmshowWebReqParam).a(true);
    }
  }
  
  @RequestRoute(a="downloadImageOnFrame")
  private void handleJsApiDownloadImageOnFrame(String paramString, Activity paramActivity)
  {
    ThreadManager.getUIHandlerV2().post(new StoreJsModule.2(this, paramActivity, paramString));
  }
  
  @RequestRoute(a="openApolloShow")
  private void handleJsApiOpenApolloShow(String paramString, JSONObject paramJSONObject, Activity paramActivity)
  {
    String str = paramJSONObject.optString("nick");
    paramJSONObject = paramJSONObject.optString("uin");
    Intent localIntent = new Intent(paramActivity, ApolloGuestsStateActivity.class);
    localIntent.putExtra("extra_guest_nick", str);
    localIntent.putExtra("extra_guest_uin", paramJSONObject);
    paramActivity.startActivity(localIntent);
    paramActivity.overridePendingTransition(0, 0);
    b(paramString);
  }
  
  @RequestRoute(a="writeLocalData")
  private void handleJsApiWriteLocalData(String paramString, JSONObject paramJSONObject)
  {
    ((IStoreAvatar2D)ApolloIPCModule.a(IStoreAvatar2D.class)).a(paramJSONObject, new StoreJsModule.3(this, paramString));
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]StoreJsModule", 2, "apolloJsPlugin call writeLocalData");
    }
  }
  
  @RequestRoute(a="jumpToMsgTab")
  private void handleJumpToMsgTab(Activity paramActivity, String paramString)
  {
    Intent localIntent = new Intent(paramActivity, SplashActivity.class);
    localIntent.putExtra("fragment_id", 1);
    localIntent.putExtra("tab_index", FrameControllerUtil.a);
    localIntent.setFlags(67174400);
    paramActivity.startActivity(localIntent);
    b(paramString);
  }
  
  @RequestRoute(a="isApolloEngineReady")
  private void isApolloEngineReady(@NonNull CmshowWebReqParam paramCmshowWebReqParam)
  {
    JSONObject localJSONObject = paramCmshowWebReqParam.a;
    paramCmshowWebReqParam = paramCmshowWebReqParam.b;
    if (ApolloEngine.isEngineReady()) {
      b(paramCmshowWebReqParam);
    } else {
      a(paramCmshowWebReqParam, "ApolloEngine is not ready");
    }
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]StoreJsModule", 2, new Object[] { "isApolloEngineReady:", Boolean.valueOf(ApolloEngine.isEngineReady()) });
    }
  }
  
  @RequestRoute(a="isX86")
  private void isX86(@NonNull CmshowWebReqParam paramCmshowWebReqParam)
  {
    paramCmshowWebReqParam = paramCmshowWebReqParam.b;
    if (ApolloHardWareTester.b()) {
      a(paramCmshowWebReqParam, "");
    } else {
      b(paramCmshowWebReqParam);
    }
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]StoreJsModule", 2, new Object[] { "isX86:", Boolean.valueOf(ApolloHardWareTester.b()) });
    }
  }
  
  @RequestRoute(a="openApolloShareFloatView")
  private void openApolloShareFloatView(@NonNull CmshowWebReqParam paramCmshowWebReqParam)
  {
    Object localObject = paramCmshowWebReqParam.a;
    String str1 = paramCmshowWebReqParam.b;
    Activity localActivity = paramCmshowWebReqParam.c;
    String str2 = ((JSONObject)localObject).optString("backgroundImage");
    localObject = ((JSONObject)localObject).optString("nickName");
    if ((a().d() instanceof QBaseActivity)) {
      paramCmshowWebReqParam = (AppInterface)((QBaseActivity)a().d()).getAppRuntime();
    } else {
      paramCmshowWebReqParam = null;
    }
    if (c() != null)
    {
      c().a(localActivity, paramCmshowWebReqParam, str2, (String)localObject);
      b(str1);
      return;
    }
    if ((localActivity instanceof IApolloActivityJsCallBack))
    {
      ((IApolloActivityJsCallBack)localActivity).a(localActivity, str2, (String)localObject);
      b(str1);
      return;
    }
    a(str1, "ApolloViewController not inited or not ApolloStoreActivity");
  }
  
  @RequestRoute(a="openBox")
  private void openBox(@NonNull CmshowWebReqParam paramCmshowWebReqParam)
  {
    Object localObject = paramCmshowWebReqParam.a;
    String str = paramCmshowWebReqParam.b;
    paramCmshowWebReqParam = paramCmshowWebReqParam.c;
    localObject = ((JSONObject)localObject).optString("uin");
    if ((paramCmshowWebReqParam instanceof IApolloActivityJsCallBack))
    {
      if (((IApolloActivityJsCallBack)paramCmshowWebReqParam).c((String)localObject))
      {
        b(str);
        return;
      }
      a(str, "打开异常");
      return;
    }
    a(str, HardCodeUtil.a(2131898699));
  }
  
  @RequestRoute(a="openDiyActionFloatView")
  private void openDiyActionFloatView(@NonNull CmshowWebReqParam paramCmshowWebReqParam)
  {
    Object localObject = paramCmshowWebReqParam.a;
    String str = paramCmshowWebReqParam.b;
    paramCmshowWebReqParam = paramCmshowWebReqParam.c;
    localObject = ((JSONObject)localObject).optString("defaultText");
    if ((paramCmshowWebReqParam instanceof IApolloActivityJsCallBack))
    {
      ((IApolloActivityJsCallBack)paramCmshowWebReqParam).b((String)localObject);
      return;
    }
    a(str, HardCodeUtil.a(2131898693));
  }
  
  @RequestRoute(a="openFloatTransparentView")
  private void openFloatTransparentView(@NonNull CmshowWebReqParam paramCmshowWebReqParam)
  {
    Object localObject = paramCmshowWebReqParam.a;
    String str1 = paramCmshowWebReqParam.b;
    paramCmshowWebReqParam = paramCmshowWebReqParam.c;
    String str2 = ((JSONObject)localObject).optString("url");
    int i = ((JSONObject)localObject).optInt("closeBtn");
    int j = ((JSONObject)localObject).optInt("fullScreen");
    localObject = new Intent(paramCmshowWebReqParam, ApolloFloatActivity.class);
    ((Intent)localObject).putExtra("extra_key_click_time", System.currentTimeMillis());
    ((Intent)localObject).putExtra("extra_key_weburl", str2);
    boolean bool2 = false;
    if (i == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    ((Intent)localObject).putExtra("extra_key_close_btn", bool1);
    boolean bool1 = bool2;
    if (j == 1) {
      bool1 = true;
    }
    ((Intent)localObject).putExtra("extra_key_fullscreen", bool1);
    ((Intent)localObject).putExtra("big_brother_source_key", "biz_src_zf_lmx");
    paramCmshowWebReqParam.startActivity((Intent)localObject);
    b(str1);
  }
  
  @RequestRoute(a="setBackViewVisibility")
  private void setBackViewVisibility(@NonNull CmshowWebReqParam paramCmshowWebReqParam)
  {
    JSONObject localJSONObject = paramCmshowWebReqParam.a;
    String str = paramCmshowWebReqParam.b;
    paramCmshowWebReqParam = paramCmshowWebReqParam.c;
    int i = localJSONObject.optInt("visibility");
    if ((paramCmshowWebReqParam instanceof IApolloActivityJsCallBack))
    {
      ((IApolloActivityJsCallBack)paramCmshowWebReqParam).c(i);
      b(str);
      return;
    }
    a(str, "ApolloViewController not inited or not ApolloStoreActivity");
  }
  
  @RequestRoute(a="setCapsuleOpened")
  private void setCapsuleOpened(String paramString, JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.optString("uin");
    if (TextUtils.isEmpty(paramJSONObject))
    {
      a(paramString, "uin is empty");
      return;
    }
    ((IStoreAvatar2D)ApolloIPCModule.a(IStoreAvatar2D.class)).a(paramJSONObject, new StoreJsModule.1(this, paramString));
  }
  
  @RequestRoute(a="setLeftViewIcon")
  private void setLeftViewIcon(@NonNull CmshowWebReqParam paramCmshowWebReqParam)
  {
    Object localObject = paramCmshowWebReqParam.a;
    paramCmshowWebReqParam = paramCmshowWebReqParam.c;
    String str = ((JSONObject)localObject).optString("url");
    if (TextUtils.isEmpty(str)) {
      return;
    }
    localObject = (SwiftBrowserUIStyleHandler)a(2);
    if ((localObject != null) && (((SwiftBrowserUIStyleHandler)localObject).g != null))
    {
      if (((SwiftBrowserUIStyleHandler)localObject).g.d == null) {
        return;
      }
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = paramCmshowWebReqParam.getResources().getDrawable(2130853297);
      paramCmshowWebReqParam = URLDrawable.getDrawable(str, localURLDrawableOptions);
      paramCmshowWebReqParam.startDownload();
      ((SwiftBrowserUIStyleHandler)localObject).g.d.setBackgroundDrawable(paramCmshowWebReqParam);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.web.jsmodule.StoreJsModule
 * JD-Core Version:    0.7.0.1
 */