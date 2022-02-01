package com.tencent.luggage.wxa.fs;

import android.content.Context;
import com.tencent.luggage.ui.WxaSimpleWebViewActivity;
import com.tencent.luggage.ui.WxaSimpleWebViewActivity.a;
import com.tencent.luggage.wxa.fq.g.d;
import com.tencent.luggage.wxa.fq.l;
import com.tencent.luggage.wxa.ft.a;
import com.tencent.luggage.wxa.fu.d;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.t;
import com.tencent.luggage.wxa.qz.w;
import com.tencent.luggage.wxaapi.DebugApi;
import com.tencent.luggage.wxaapi.LaunchWxaAppResult;
import com.tencent.luggage.wxaapi.LaunchWxaAppResultListener;
import com.tencent.luggage.wxaapi.WxaApi;
import com.tencent.xweb.v;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/wxaapi/internal/debug/WxaDebugApiSnapshotIMPL;", "Lcom/tencent/luggage/wxaapi/DebugApi;", "wxaApi", "Lcom/tencent/luggage/wxaapi/WxaApi;", "(Lcom/tencent/luggage/wxaapi/WxaApi;)V", "URL_CHECK_UPDATE", "", "getURL_CHECK_UPDATE", "()Ljava/lang/String;", "URL_CLEAR_VERSION", "getURL_CLEAR_VERSION", "URL_DEBUG_XWEB", "getURL_DEBUG_XWEB", "URL_INSPECTOR", "getURL_INSPECTOR", "URL_SHOW_VERSION", "getURL_SHOW_VERSION", "URL_UPDATE_CONFIG", "getURL_UPDATE_CONFIG", "debugXWeb", "", "context", "Landroid/content/Context;", "type", "", "deleteLibFile", "getDebugIP", "getIsDebugIP", "", "isMultiTaskModeEnabledForWxaApp", "launchByQRRawData", "", "codeRawData", "listener", "Lcom/tencent/luggage/wxaapi/LaunchWxaAppResultListener;", "setDebugIP", "ip", "setIsDebugIP", "isDebugIP", "setMultiTaskModeEnabledForWxaApp", "enabled", "Companion", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public final class b
  implements DebugApi
{
  public static final b.a a = new b.a(null);
  @NotNull
  private final String b;
  @NotNull
  private final String c;
  @NotNull
  private final String d;
  @NotNull
  private final String e;
  @NotNull
  private final String f;
  @NotNull
  private final String g;
  private final WxaApi h;
  
  public b(@NotNull WxaApi paramWxaApi)
  {
    this.h = paramWxaApi;
    this.b = "http://debugxweb.qq.com/?show_webview_version";
    this.c = "http://debugxweb.qq.com/?check_xwalk_update";
    this.d = "http://debugxweb.qq.com/?inspector=true";
    this.e = "http://debugxweb.qq.com/?set_apkver=-1";
    this.f = "http://debugxweb.qq.com/?set_config_url=https://dldir1.qq.com/weixin/android/wxweb/updateconfig_wmpftest.xml&check_xwalk_update&";
    this.g = "http://debugxweb.qq.com/";
  }
  
  public void debugXWeb(@NotNull Context paramContext, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("debugXWeb type:");
    localStringBuilder.append(paramInt);
    o.d("Luggage.WxaDebugApiSnapshotIMPL", localStringBuilder.toString());
    switch (paramInt)
    {
    default: 
      return;
    case 7: 
      paramContext = v.a();
      Intrinsics.checkExpressionValueIsNotNull(paramContext, "WebDebugCfg.getInst()");
      paramContext.k(false);
      return;
    case 6: 
      WxaSimpleWebViewActivity.a.a(paramContext, this.g);
      return;
    case 5: 
      WxaSimpleWebViewActivity.a.a(paramContext, this.f);
      return;
    case 4: 
      WxaSimpleWebViewActivity.a.a(paramContext, this.e);
      return;
    case 3: 
      WxaSimpleWebViewActivity.a.a(paramContext, this.d);
      return;
    case 2: 
      WxaSimpleWebViewActivity.a.a(paramContext, this.c);
      return;
    case 1: 
      WxaSimpleWebViewActivity.a.a(paramContext, this.b);
      return;
    }
    paramContext = v.a();
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "WebDebugCfg.getInst()");
    paramContext.k(true);
  }
  
  public void deleteLibFile()
  {
    l.a.a();
  }
  
  @NotNull
  public String getDebugIP()
  {
    return a.c();
  }
  
  public boolean getIsDebugIP()
  {
    return a.b();
  }
  
  public boolean isMultiTaskModeEnabledForWxaApp()
  {
    return a.a().getBoolean("KEY_MULTI_TASK", false);
  }
  
  public long launchByQRRawData(@Nullable Context paramContext, @NotNull String paramString, @Nullable LaunchWxaAppResultListener paramLaunchWxaAppResultListener)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "codeRawData");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("launchByQRRawData codeRawData:");
    localStringBuilder.append(paramString);
    o.d("Luggage.WxaDebugApiSnapshotIMPL", localStringBuilder.toString());
    long l = g.d.a.a();
    if (!this.h.isDynamicPkgLoaded())
    {
      o.b("Luggage.WxaDebugApiSnapshotIMPL", "launchByQRRawData rejected, dynamic pkg not loaded");
      if (paramLaunchWxaAppResultListener != null) {
        paramLaunchWxaAppResultListener.onLaunchResult(null, -1, l, LaunchWxaAppResult.FailNotLoadDynamicPkg);
      }
      return l;
    }
    d.a.a((Function0)new b.b(paramContext, paramString, l));
    a.a(a.a, l, null, 0, paramLaunchWxaAppResultListener, 6, null);
    return l;
  }
  
  public void setDebugIP(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "ip");
    a.a(paramString);
  }
  
  public void setIsDebugIP(boolean paramBoolean)
  {
    a.a().putBoolean("KEY_IS_DEBUG_IP", paramBoolean);
    t.a((Runnable)new b.c(paramBoolean));
  }
  
  public void setMultiTaskModeEnabledForWxaApp(boolean paramBoolean)
  {
    a.a().putBoolean("KEY_MULTI_TASK", paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fs.b
 * JD-Core Version:    0.7.0.1
 */