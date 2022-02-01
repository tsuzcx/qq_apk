package com.tencent.ilive.litepages.room.webmodule;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.View;
import com.tencent.falco.utils.NetworkUtil;
import com.tencent.ilive.litepages.room.webmodule.jsmodule.JsBizAdapter;
import com.tencent.okweb.framework.core.manager.OkWebManager;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebSettings.PluginState;
import com.tencent.smtt.sdk.WebView;
import java.io.File;

public class LiteWebView
  extends WebView
{
  private Context mContext;
  private JsBizAdapter mJsBizAdapter;
  private View mRootView;
  
  public LiteWebView(Context paramContext, View paramView, JsBizAdapter paramJsBizAdapter)
  {
    super(paramContext);
    this.mContext = paramContext;
    this.mJsBizAdapter = paramJsBizAdapter;
    this.mRootView = paramView;
    initWebViewClient();
    initWebSettings();
  }
  
  private void initWebViewClient()
  {
    LiteWebViewClient localLiteWebViewClient = new LiteWebViewClient(this, this.mRootView, this.mContext, this.mJsBizAdapter);
    setWebChromeClient(null);
    setWebViewClient(localLiteWebViewClient);
  }
  
  protected void initWebSettings()
  {
    WebSettings localWebSettings = getSettings();
    if (localWebSettings == null) {
      return;
    }
    if (Build.VERSION.SDK_INT >= 8) {
      localWebSettings.setPluginState(WebSettings.PluginState.ON);
    }
    getView().setScrollBarStyle(0);
    getView().setVerticalScrollBarEnabled(false);
    getSettings().setLoadsImagesAutomatically(true);
    getSettings().setBlockNetworkImage(false);
    localWebSettings.setSaveFormData(false);
    localWebSettings.setSavePassword(false);
    localWebSettings.setDisplayZoomControls(false);
    localWebSettings.setBuiltInZoomControls(true);
    localWebSettings.setJavaScriptEnabled(true);
    localWebSettings.setAllowContentAccess(true);
    localWebSettings.setJavaScriptCanOpenWindowsAutomatically(true);
    localWebSettings.setAllowFileAccess(false);
    localWebSettings.setAllowFileAccessFromFileURLs(false);
    localWebSettings.setAllowUniversalAccessFromFileURLs(false);
    localWebSettings.setGeolocationEnabled(false);
    localWebSettings.setAppCacheEnabled(true);
    localWebSettings.setAppCacheMaxSize(8388608L);
    localWebSettings.setAppCachePath(getContext().getDir("cache", 0).getPath());
    localWebSettings.setDomStorageEnabled(true);
    localWebSettings.setCacheMode(-1);
    String str1 = localWebSettings.getUserAgentString();
    OkWebManager.getInstance().getSdkVersionName();
    int i = OkWebManager.getInstance().getSdkVersionCode();
    if (!str1.contains("NowSDK/"))
    {
      String str2 = Build.VERSION.RELEASE;
      int j = NetworkUtil.getNetworkType(this.mContext);
      localWebSettings.setUserAgentString(str1 + " NowLive/" + i + "_" + str2 + " NetType/" + j + " NowSDK/18_10.20");
    }
    localWebSettings.setMixedContentMode(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.litepages.room.webmodule.LiteWebView
 * JD-Core Version:    0.7.0.1
 */