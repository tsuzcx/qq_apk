package com.tencent.biz.pubaccount.readinjoy.viola.modules.bridge;

import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/viola/modules/bridge/RIJBridgeInvokeHandler;", "Lcom/tencent/biz/pubaccount/readinjoy/viola/modules/bridge/AbsBridgeInvokeHandler;", "module", "Lcom/tencent/biz/pubaccount/readinjoy/viola/modules/BridgeModule;", "(Lcom/tencent/biz/pubaccount/readinjoy/viola/modules/BridgeModule;)V", "directSocialShare", "", "param", "Lorg/json/JSONObject;", "callback", "", "nameSpace", "register", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class RIJBridgeInvokeHandler
  extends AbsBridgeInvokeHandler
{
  public static final RIJBridgeInvokeHandler.Companion a = new RIJBridgeInvokeHandler.Companion(null);
  
  public RIJBridgeInvokeHandler(@NotNull BridgeModule paramBridgeModule)
  {
    super(paramBridgeModule);
  }
  
  private final void a(JSONObject paramJSONObject, String paramString)
  {
    int i;
    if (paramJSONObject != null)
    {
      paramString = paramJSONObject.optString("shareType", "");
      if (!paramString.equals("friend")) {
        break label30;
      }
      i = 2;
    }
    for (;;)
    {
      if (i == -1)
      {
        return;
        label30:
        if (paramString.equals("qzone"))
        {
          i = 3;
          continue;
        }
        if (paramString.equals("wechat"))
        {
          i = 9;
          continue;
        }
        if (paramString.equals("wechatcircle"))
        {
          i = 10;
          continue;
        }
        if (paramString.equals("weibo")) {
          i = 12;
        }
      }
      else
      {
        paramJSONObject = paramJSONObject.optJSONObject("shareInfo");
        if (paramJSONObject != null) {
          a().directSocialShare(paramJSONObject, i);
        }
        return;
      }
      i = -1;
    }
  }
  
  @NotNull
  public String a()
  {
    return "readinjoy";
  }
  
  public void a()
  {
    a("openPrivateLetter", (Function2)new RIJBridgeInvokeHandler.register.1(this));
    a("openVideo", (Function2)new RIJBridgeInvokeHandler.register.2(this));
    a("QReport", (Function2)new RIJBridgeInvokeHandler.register.3(this));
    a("showUGCEditPage", (Function2)new RIJBridgeInvokeHandler.register.4(this));
    a("showMultiBiuEditPage", (Function2)new RIJBridgeInvokeHandler.register.5(this));
    a("selectAndInviteFriend", (Function2)new RIJBridgeInvokeHandler.register.6(this));
    a("selectAndUploadAvatar", (Function2)new RIJBridgeInvokeHandler.register.7(this));
    a("uploadTopicPic", (Function2)new RIJBridgeInvokeHandler.register.8(this));
    a("showPicture", (Function2)new RIJBridgeInvokeHandler.register.9(this));
    a("openAccountPageMore", (Function2)new RIJBridgeInvokeHandler.register.10(this));
    a("socialize_feeds_update", (Function2)new RIJBridgeInvokeHandler.register.11(this));
    a("updateAccountCardFollowInfo", (Function2)new RIJBridgeInvokeHandler.register.12(this));
    a("updateTopicCardFollowInfo", (Function2)new RIJBridgeInvokeHandler.register.13(this));
    a("showVisibleUserList", (Function2)new RIJBridgeInvokeHandler.register.14(this));
    a("getBiuTriggerType", (Function2)new RIJBridgeInvokeHandler.register.15(this));
    a("showShareReadInJoyMenu", (Function2)new RIJBridgeInvokeHandler.register.16(this));
    a("showUGCVideoRecordPage", (Function2)new RIJBridgeInvokeHandler.register.17(this));
    a("showCommentEditor", (Function2)new RIJBridgeInvokeHandler.register.18(this));
    a("showCommentEditorNative", (Function2)new RIJBridgeInvokeHandler.register.19(this));
    a("feeds_refresh_message", (Function2)new RIJBridgeInvokeHandler.register.20(this));
    a("isInKanDianTab", (Function2)new RIJBridgeInvokeHandler.register.21(this));
    a("hasRedPacketSharePermission", (Function2)new RIJBridgeInvokeHandler.register.22(this));
    a("updateRedPacketShareTime", (Function2)new RIJBridgeInvokeHandler.register.23(this));
    a("requestRedPacketContentShareToast", (Function2)new RIJBridgeInvokeHandler.register.24(this));
    a("clearMessageBoxData", (Function2)new RIJBridgeInvokeHandler.register.25(this));
    a("showFollowAlertView", (Function2)new RIJBridgeInvokeHandler.register.26(this));
    a("hideFollowAlertView", (Function2)new RIJBridgeInvokeHandler.register.27(this));
    a("getALDConfigParams", (Function2)new RIJBridgeInvokeHandler.register.28(this));
    a("showLevelDialog", (Function2)new RIJBridgeInvokeHandler.register.29(this));
    a("directSocialShare", (Function2)new RIJBridgeInvokeHandler.register.30((RIJBridgeInvokeHandler)this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.modules.bridge.RIJBridgeInvokeHandler
 * JD-Core Version:    0.7.0.1
 */