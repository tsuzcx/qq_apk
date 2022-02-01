package com.tencent.gdtad.jsbridge;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtAppReceiver;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.util.GdtManager;
import com.tencent.gdtad.util.GdtManager.Params;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class GdtAdWebPlugin
  extends VasWebviewJsPlugin
{
  private GdtAppReceiver a;
  
  public GdtAdWebPlugin()
  {
    this.mPluginNameSpace = "qq_gdt_ad";
    Object localObject;
    if (a() != null) {
      localObject = a();
    } else {
      localObject = BaseApplicationImpl.getApplication();
    }
    GdtManager.a().a((Context)localObject, new GdtManager.Params());
  }
  
  private void d()
  {
    if (this.a == null)
    {
      if (this.mRuntime == null) {
        return;
      }
      GdtLog.b("GdtAdWebPlugin", "registerReceiverForApp");
      this.a = new GdtAppReceiver();
      this.a.register(a());
    }
  }
  
  private void e()
  {
    if (this.a != null)
    {
      if (this.mRuntime == null) {
        return;
      }
      GdtLog.b("GdtAdWebPlugin", "unregisterReceiverForApp");
      this.a.unregister(a());
      this.a = null;
    }
  }
  
  public Activity a()
  {
    Activity localActivity1;
    if (this.mRuntime != null) {
      localActivity1 = this.mRuntime.d();
    } else {
      localActivity1 = null;
    }
    Activity localActivity2 = localActivity1;
    if ((localActivity1 instanceof BasePluginActivity)) {
      localActivity2 = ((BasePluginActivity)BasePluginActivity.class.cast(localActivity1)).getOutActivity();
    }
    return localActivity2;
  }
  
  public String b()
  {
    Activity localActivity = a();
    if ((localActivity == null) || (!(localActivity instanceof QQBrowserActivity))) {
      return null;
    }
    return ((QQBrowserActivity)QQBrowserActivity.class.cast(localActivity)).getCurrentUrl();
  }
  
  public GdtAppReceiver c()
  {
    return this.a;
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel())
    {
      paramJsBridgeListener = new StringBuilder();
      paramJsBridgeListener.append("method:");
      paramJsBridgeListener.append(paramString3);
      QLog.i("GdtAdWebPlugin", 2, paramJsBridgeListener.toString());
    }
    paramJsBridgeListener = null;
    try
    {
      paramString1 = new JSONObject(paramVarArgs[0]).optString("callback");
    }
    catch (Exception paramString1)
    {
      GdtLog.d("GdtAdWebPlugin", "GdtAdWebPlugin handleJsCallRequest error ", paramString1);
      paramString1 = null;
    }
    if ("loadAdDemo".equals(paramString3))
    {
      paramJsBridgeListener = GdtAdPluginFactory.a().a(5);
    }
    else if ("getLocation".equals(paramString3))
    {
      paramJsBridgeListener = GdtAdPluginFactory.a().a(4);
    }
    else if ("getDeviceId".equals(paramString3))
    {
      paramJsBridgeListener = GdtAdPluginFactory.a().a(7);
    }
    else if ("getCarrier".equals(paramString3))
    {
      paramJsBridgeListener = GdtAdPluginFactory.a().a(9);
    }
    else if ("getNetType".equals(paramString3))
    {
      paramJsBridgeListener = GdtAdPluginFactory.a().a(10);
    }
    else if ("getOSVersion".equals(paramString3))
    {
      paramJsBridgeListener = GdtAdPluginFactory.a().a(11);
    }
    else if ("handleClick".equals(paramString3))
    {
      d();
      paramJsBridgeListener = GdtAdPluginFactory.a().a(12);
    }
    else if ("showBanner".equals(paramString3))
    {
      paramJsBridgeListener = GdtAdPluginFactory.a().a(13);
    }
    else if ("showInterstitial".equals(paramString3))
    {
      paramJsBridgeListener = GdtAdPluginFactory.a().a(19);
    }
    else if ("showInterstitialForJS".equals(paramString3))
    {
      paramJsBridgeListener = GdtAdPluginFactory.a().a(20);
    }
    else if ("getDeviceInfo".equals(paramString3))
    {
      paramJsBridgeListener = GdtAdPluginFactory.a().a(14);
    }
    else if ("c2sReport".equals(paramString3))
    {
      paramJsBridgeListener = GdtAdPluginFactory.a().a(15);
    }
    else if ("openMotiveVideoAd".equals(paramString3))
    {
      paramJsBridgeListener = GdtAdPluginFactory.a().a(16);
    }
    else if ("getUserInfo".equals(paramString3))
    {
      paramJsBridgeListener = GdtAdPluginFactory.a().a(17);
    }
    else if ("preLoadAfterAdLoaded".equals(paramString3))
    {
      paramJsBridgeListener = GdtAdPluginFactory.a().a(18);
    }
    else if ("getCanvasJson".equals(paramString3))
    {
      paramJsBridgeListener = GdtAdPluginFactory.a().a(21);
    }
    else if ("getAdInfo".equals(paramString3))
    {
      paramJsBridgeListener = GdtAdPluginFactory.a().a(22);
    }
    else if ("handleRewardVideoClick".equals(paramString3))
    {
      paramJsBridgeListener = GdtAdPluginFactory.a().a(23);
    }
    else if ("launchAppWithDeeplink".equals(paramString3))
    {
      paramJsBridgeListener = GdtAdPluginFactory.a().a(24);
    }
    else if ("onVideoClose".equals(paramString3))
    {
      paramJsBridgeListener = GdtAdPluginFactory.a().a(25);
    }
    else if ("onVideoMute".equals(paramString3))
    {
      paramJsBridgeListener = GdtAdPluginFactory.a().a(26);
    }
    else if ("reportServerAnti".equals(paramString3))
    {
      paramJsBridgeListener = GdtAdPluginFactory.a().a(27);
    }
    else if ("showDeviceDemo".equals(paramString3))
    {
      paramJsBridgeListener = GdtAdPluginFactory.a().a(28);
    }
    else if ("showReminderDemo".equals(paramString3))
    {
      paramJsBridgeListener = GdtAdPluginFactory.a().a(29);
    }
    else if ("reportFlyingStreaming".equals(paramString3))
    {
      paramJsBridgeListener = GdtAdPluginFactory.a().a(30);
    }
    else if ("showHippyDemo".equals(paramString3))
    {
      paramJsBridgeListener = GdtAdPluginFactory.a().a(31);
    }
    else if ("showFeedback".equals(paramString3))
    {
      paramJsBridgeListener = GdtAdPluginFactory.a().a(32);
    }
    else if ("showMotiveVideoDemo".equals(paramString3))
    {
      paramJsBridgeListener = GdtAdPluginFactory.a().a(33);
    }
    if (paramJsBridgeListener != null) {
      paramJsBridgeListener.a(this, paramString1, paramVarArgs);
    }
    return true;
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    super.onActivityResult(paramIntent, paramByte, paramInt);
    GdtLog.b("GdtAdWebPlugin", String.format("onActivityResult requestCode:%d resultCode:%d", new Object[] { Byte.valueOf(paramByte), Integer.valueOf(paramInt) }));
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.jsbridge.GdtAdWebPlugin
 * JD-Core Version:    0.7.0.1
 */