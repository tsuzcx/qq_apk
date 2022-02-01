package com.tencent.biz.pubaccount.readinjoy.viola.modules.bridge;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule.CallCommentJs;
import com.tencent.biz.pubaccount.util.api.IPublicAccountH5AbilityPlugin;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.jsp.UiApiPlugin;
import com.tencent.mobileqq.qroute.QRoute;
import cooperation.liveroom.LiveRoomProxyActivity;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/viola/modules/bridge/UIBridgeInvokeHandler;", "Lcom/tencent/biz/pubaccount/readinjoy/viola/modules/bridge/AbsBridgeInvokeHandler;", "module", "Lcom/tencent/biz/pubaccount/readinjoy/viola/modules/BridgeModule;", "(Lcom/tencent/biz/pubaccount/readinjoy/viola/modules/BridgeModule;)V", "arouseReadInJoyNativeCommentView", "", "params", "Lorg/json/JSONObject;", "callbackId", "", "biuCommentAladdinConfig", "callBackId", "nameSpace", "openPluginView", "register", "showCommentEditor", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class UIBridgeInvokeHandler
  extends AbsBridgeInvokeHandler
{
  public static final UIBridgeInvokeHandler.Companion a = new UIBridgeInvokeHandler.Companion(null);
  
  public UIBridgeInvokeHandler(@NotNull BridgeModule paramBridgeModule)
  {
    super(paramBridgeModule);
  }
  
  private final void a(JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject != null)
    {
      paramJSONObject = paramJSONObject.optString("url");
      paramString = (Activity)BaseActivity.sTopActivity;
      if ((paramString != null) && (paramJSONObject != null)) {
        if (((CharSequence)paramJSONObject).length() <= 0) {
          break label57;
        }
      }
    }
    label57:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        LiveRoomProxyActivity.open(paramString, paramJSONObject, "Readinjoy feeds");
      }
      return;
      paramJSONObject = null;
      break;
    }
  }
  
  private final void b(JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject != null)
    {
      if (paramJSONObject.optBoolean("isAlbum", true)) {
        a().arouseReadInJoyNativeCommentView(paramJSONObject, paramString);
      }
    }
    else {
      return;
    }
    if (TextUtils.isEmpty((CharSequence)paramJSONObject.optString("callback"))) {}
    for (String str = paramString;; str = paramJSONObject.optString("callback"))
    {
      ((IPublicAccountH5AbilityPlugin)QRoute.api(IPublicAccountH5AbilityPlugin.class)).showReadInJoyNativeCommentView(paramJSONObject, str, (BridgeModule.CallCommentJs)new UIBridgeInvokeHandler.arouseReadInJoyNativeCommentView..inlined.also.lambda.1(this, paramString));
      break;
    }
  }
  
  private final void c(JSONObject paramJSONObject, String paramString)
  {
    UiApiPlugin.a(true, paramString, (BridgeModule.CallCommentJs)new UIBridgeInvokeHandler.biuCommentAladdinConfig.1(this));
  }
  
  private final void d(JSONObject paramJSONObject, String paramString)
  {
    UiApiPlugin.a(paramJSONObject, paramString, a());
  }
  
  @NotNull
  public String a()
  {
    return "ui";
  }
  
  public void a()
  {
    a("openPluginView", (Function2)new UIBridgeInvokeHandler.register.1((UIBridgeInvokeHandler)this));
    a("arouseReadInJoyNativeCommentView", (Function2)new UIBridgeInvokeHandler.register.2((UIBridgeInvokeHandler)this));
    a("biuCommentAladdinConfig", (Function2)new UIBridgeInvokeHandler.register.3((UIBridgeInvokeHandler)this));
    a("showCommentEditor", (Function2)new UIBridgeInvokeHandler.register.4((UIBridgeInvokeHandler)this));
    a("showTips", (Function2)new UIBridgeInvokeHandler.register.5(this));
    a("openPage", (Function2)new UIBridgeInvokeHandler.register.6(this));
    a("openUrl", (Function2)new UIBridgeInvokeHandler.register.7(this));
    a("setTitle", (Function2)new UIBridgeInvokeHandler.register.8(this));
    a("pageVisibility", (Function2)new UIBridgeInvokeHandler.register.9(this));
    a("popBack", (Function2)new UIBridgeInvokeHandler.register.10(this));
    a("suspensionPopBack", (Function2)new UIBridgeInvokeHandler.register.11(this));
    a("setNavBtn", (Function2)new UIBridgeInvokeHandler.register.12(this));
    a("showDialog", (Function2)new UIBridgeInvokeHandler.register.13(this));
    a("showShareMenu", (Function2)new UIBridgeInvokeHandler.register.14(this));
    a("canOpenPage", (Function2)new UIBridgeInvokeHandler.register.15(this));
    a("setNavBar", (Function2)new UIBridgeInvokeHandler.register.16(this));
    a("setRightDragToGoBackParams", (Function2)new UIBridgeInvokeHandler.register.17(this));
    a("showActionSheet", (Function2)new UIBridgeInvokeHandler.register.18(this));
    a("violaTitleBarClick", (Function2)new UIBridgeInvokeHandler.register.19(this));
    a("sharePicMessage", (Function2)new UIBridgeInvokeHandler.register.20(this));
    a("isNightMode", (Function2)new UIBridgeInvokeHandler.register.21(this));
    a("addViolaPageByUrl", (Function2)new UIBridgeInvokeHandler.register.22(this));
    a("disableSwitcher", (Function2)new UIBridgeInvokeHandler.register.23(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.modules.bridge.UIBridgeInvokeHandler
 * JD-Core Version:    0.7.0.1
 */