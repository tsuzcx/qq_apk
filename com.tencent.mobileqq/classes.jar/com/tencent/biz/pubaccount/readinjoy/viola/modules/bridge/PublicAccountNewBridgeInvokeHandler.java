package com.tencent.biz.pubaccount.readinjoy.viola.modules.bridge;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule.RefreshUserInfoCallBack;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule.CallCommentJs;
import com.tencent.biz.pubaccount.util.ReadinjoyReportUtils;
import com.tencent.biz.pubaccount.util.api.IPublicAccountH5AbilityPlugin;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/viola/modules/bridge/PublicAccountNewBridgeInvokeHandler;", "Lcom/tencent/biz/pubaccount/readinjoy/viola/modules/bridge/AbsBridgeInvokeHandler;", "module", "Lcom/tencent/biz/pubaccount/readinjoy/viola/modules/BridgeModule;", "(Lcom/tencent/biz/pubaccount/readinjoy/viola/modules/BridgeModule;)V", "getRIJAppType", "", "param", "Lorg/json/JSONObject;", "callbackId", "", "getUserInfo", "nameSpace", "register", "showReadInJoyNativeCommentView", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class PublicAccountNewBridgeInvokeHandler
  extends AbsBridgeInvokeHandler
{
  public static final PublicAccountNewBridgeInvokeHandler.Companion a = new PublicAccountNewBridgeInvokeHandler.Companion(null);
  
  public PublicAccountNewBridgeInvokeHandler(@NotNull BridgeModule paramBridgeModule)
  {
    super(paramBridgeModule);
  }
  
  private final void a(JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject != null) {
      if (!TextUtils.isEmpty((CharSequence)paramJSONObject.optString("callback"))) {
        break label49;
      }
    }
    label49:
    for (String str = paramString;; str = paramJSONObject.optString("callback"))
    {
      ((IPublicAccountH5AbilityPlugin)QRoute.api(IPublicAccountH5AbilityPlugin.class)).showReadInJoyNativeCommentView(paramJSONObject, str, (BridgeModule.CallCommentJs)new PublicAccountNewBridgeInvokeHandler.showReadInJoyNativeCommentView..inlined.also.lambda.1(this, paramString));
      return;
    }
  }
  
  private final void b(JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject != null)
    {
      QLog.d("PublicAccountNewBridgeInvokeHandler", 1, "call getRIJAppType");
      if (!TextUtils.isEmpty((CharSequence)paramJSONObject.optString("callback"))) {
        break label93;
      }
    }
    try
    {
      for (;;)
      {
        paramJSONObject = new JSONObject().put("app_type", ReadinjoyReportUtils.c()).toString();
        Intrinsics.checkExpressionValueIsNotNull(paramJSONObject, "JSONObject().put(\"app_ty…portAppType()).toString()");
        QLog.d("PublicAccountNewBridgeInvokeHandler", 1, "callback: " + paramString + "result: " + paramJSONObject);
        a(paramString, paramJSONObject);
        return;
        label93:
        paramString = paramJSONObject.optString("callback");
      }
    }
    catch (JSONException paramJSONObject)
    {
      for (;;)
      {
        QLog.e("PublicAccountNewBridgeInvokeHandler", 1, paramJSONObject.getMessage());
      }
    }
  }
  
  private final void c(JSONObject paramJSONObject, String paramString)
  {
    String str;
    if (paramJSONObject != null)
    {
      QLog.d("PublicAccountNewBridgeInvokeHandler", 1, "call getUserInfo");
      if (!TextUtils.isEmpty((CharSequence)paramJSONObject.optString("callback"))) {
        break label59;
      }
      str = paramString;
    }
    try
    {
      for (;;)
      {
        ReadInJoyUserInfoModule.a(Long.parseLong(paramJSONObject.opt("uin").toString()), (ReadInJoyUserInfoModule.RefreshUserInfoCallBack)new PublicAccountNewBridgeInvokeHandler.getUserInfo..inlined.also.lambda.1(str, this, paramString));
        return;
        label59:
        str = paramJSONObject.optString("callback");
      }
    }
    catch (Exception paramJSONObject)
    {
      for (;;)
      {
        QLog.e("PublicAccountNewBridgeInvokeHandler", 1, paramJSONObject.getMessage());
        a(str, ((IPublicAccountH5AbilityPlugin)QRoute.api(IPublicAccountH5AbilityPlugin.class)).getUserInfoFailStr(paramJSONObject.getMessage()));
      }
    }
  }
  
  @NotNull
  public String a()
  {
    return "publicAccountNew";
  }
  
  public void a()
  {
    a("showReadInJoyNativeCommentView", (Function2)new PublicAccountNewBridgeInvokeHandler.register.1((PublicAccountNewBridgeInvokeHandler)this));
    a("getRIJAppType", (Function2)new PublicAccountNewBridgeInvokeHandler.register.2((PublicAccountNewBridgeInvokeHandler)this));
    a("getUserInfo", (Function2)new PublicAccountNewBridgeInvokeHandler.register.3((PublicAccountNewBridgeInvokeHandler)this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.modules.bridge.PublicAccountNewBridgeInvokeHandler
 * JD-Core Version:    0.7.0.1
 */