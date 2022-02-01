package com.tencent.mobileqq.Doraemon.manifest;

import com.tencent.mobileqq.Doraemon.DoraemonAPIModule;
import com.tencent.mobileqq.Doraemon.impl.commonModule.RankingModule;
import com.tencent.mobileqq.Doraemon.impl.commonModule.SensorModule;
import com.tencent.mobileqq.Doraemon.impl.commonModule.ShareModule;
import com.tencent.mobileqq.Doraemon.impl.commonModule.UserInfoModule;
import com.tencent.mobileqq.Doraemon.impl.commonModule.WidgetModule;
import com.tencent.mobileqq.Doraemon.impl.internalModule.EventAPIModule;
import com.tencent.mobileqq.Doraemon.impl.internalModule.InternalAPIModule;
import com.tencent.mobileqq.Doraemon.impl.internalModule.NavigateModule;
import com.tencent.mobileqq.Doraemon.impl.internalModule.SdkApiModule;
import com.tencent.mobileqq.Doraemon.impl.webviewModule.WVAuthModule;
import com.tencent.mobileqq.Doraemon.impl.webviewModule.WVUIModule;
import com.tencent.mobileqq.ark.browser.ArkWebModule;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import java.util.HashMap;

public final class D
{
  @ConfigInject(configPath="Business/doraemon-api/src/main/resources/doraemon_module_inject.yml")
  public static HashMap<String, Class<? extends DoraemonAPIModule>> a = new HashMap();
  
  static
  {
    a.put("lightappDisableWebViewLongPress", ArkWebModule.class);
    a.put("lightappDisableLongPress", ArkWebModule.class);
    a.put("lightappOpenApp", ArkWebModule.class);
    a.put("lightappShareMessage", ArkWebModule.class);
    a.put("lightappShareCallback", ArkWebModule.class);
    a.put("lightappGetSDKVersion", ArkWebModule.class);
    a.put("setShareListener", WVUIModule.class);
    a.put("refreshTitle", WVUIModule.class);
    a.put("closeWebview", WVUIModule.class);
    a.put("setShareInfo", WVUIModule.class);
    a.put("config", WVAuthModule.class);
    a.put("sdk_avatar_edit", SdkApiModule.class);
    a.put("sdk_face_collection", SdkApiModule.class);
    a.put("sdk_dynamic_avatar_edit", SdkApiModule.class);
    a.put("dispatchEvent", EventAPIModule.class);
    a.put("removeEventListener", EventAPIModule.class);
    a.put("addEventListener", EventAPIModule.class);
    a.put("openNativeView", NavigateModule.class);
    a.put("openPlatoView", NavigateModule.class);
    a.put("openWebView", NavigateModule.class);
    a.put("getSkey", InternalAPIModule.class);
    a.put("showDialog", WidgetModule.class);
    a.put("showActionSheet", WidgetModule.class);
    a.put("shareMessage", ShareModule.class);
    a.put("showShareMenu", ShareModule.class);
    a.put("reportScore", RankingModule.class);
    a.put("getRankingList", RankingModule.class);
    a.put("getAppFriends", UserInfoModule.class);
    a.put("getUserInfo", UserInfoModule.class);
    a.put("loginSilent", UserInfoModule.class);
    a.put("login", UserInfoModule.class);
    a.put("getCity", SensorModule.class);
    a.put("getLocation", SensorModule.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.manifest.D
 * JD-Core Version:    0.7.0.1
 */