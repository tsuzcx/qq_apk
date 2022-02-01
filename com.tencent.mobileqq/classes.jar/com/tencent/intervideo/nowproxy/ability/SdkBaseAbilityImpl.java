package com.tencent.intervideo.nowproxy.ability;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.tencent.intervideo.nowproxy.Global;
import com.tencent.intervideo.nowproxy.NowEntryData;
import com.tencent.intervideo.nowproxy.WebCallHandler;
import com.tencent.intervideo.nowproxy.common.login.LoginData;
import com.tencent.intervideo.nowproxy.customized_interface.CustomCgi;
import com.tencent.intervideo.nowproxy.customized_interface.CustomizedChannel;
import com.tencent.intervideo.nowproxy.customized_interface.CustomizedDns;
import com.tencent.intervideo.nowproxy.customized_interface.CustomizedDownloader;
import com.tencent.intervideo.nowproxy.customized_interface.CustomizedLoader;
import com.tencent.intervideo.nowproxy.customized_interface.CustomizedLoading;
import com.tencent.intervideo.nowproxy.customized_interface.CustomizedLog;
import com.tencent.intervideo.nowproxy.customized_interface.CustomizedReport;
import com.tencent.intervideo.nowproxy.customized_interface.CustomizedTicket;
import com.tencent.intervideo.nowproxy.customized_interface.CustomizedToast;
import com.tencent.intervideo.nowproxy.customized_interface.CustomizedWebView;
import com.tencent.intervideo.nowproxy.customized_interface.DownloadCallback;
import com.tencent.intervideo.nowproxy.customized_interface.IShadow;
import com.tencent.qqinterface.CommonCallback;
import java.util.concurrent.Future;

public class SdkBaseAbilityImpl
{
  public static final String TAG = "SdkBaseAbilityImpl";
  public static SdkBaseAbilityImpl sInstance = new SdkBaseAbilityImpl();
  CustomizedLoader customizedLoader;
  CustomCgi mCustomCgi;
  CustomizedChannel mCustomChannle;
  CustomizedDns mCustomDns;
  CustomizedDownloader mCustomizedDownloader;
  CustomizedLoading mCustomizedLoading;
  CustomizedLog mCustomizedLog;
  CustomizedReport mCustomizedReport;
  CustomizedTicket mCustomizedTiket;
  CustomizedToast mCustomizedToast;
  CustomizedWebView mCustomizedWebView;
  IShadow mShadowImpl;
  WebCallHandler mWebcallHandler;
  
  public static SdkBaseAbilityImpl getsInstance()
  {
    return sInstance;
  }
  
  public void doCgiReq(Bundle paramBundle, CommonCallback<Bundle> paramCommonCallback)
  {
    if (this.mCustomCgi != null) {
      this.mCustomCgi.doCgiReq(paramBundle, paramCommonCallback);
    }
  }
  
  public void download(boolean paramBoolean, String paramString1, String paramString2, Bundle paramBundle, DownloadCallback paramDownloadCallback)
  {
    if (this.mCustomizedDownloader != null) {
      this.mCustomizedDownloader.onDownload(paramBoolean, paramString1, paramString2, paramBundle, paramDownloadCallback);
    }
  }
  
  public Future<Bundle> getA1(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (this.mCustomizedTiket != null) {
      return this.mCustomizedTiket.getA1(paramString1, paramString2, paramString3, paramString4);
    }
    return null;
  }
  
  public Future<Bundle> getAccessToken(String paramString1, String paramString2)
  {
    if (this.mCustomizedTiket != null) {
      return this.mCustomizedTiket.getAccessToken(paramString1, paramString2);
    }
    return null;
  }
  
  public IShadow getShadowImpl()
  {
    return this.mShadowImpl;
  }
  
  public Bundle getTickets()
  {
    if (Global.sLoginData != null) {
      return LoginData.getLoginBundle(Global.sLoginData);
    }
    return null;
  }
  
  public void hasPluginLoaded()
  {
    if (this.customizedLoader != null) {
      this.customizedLoader.onPluginLoaded();
    }
  }
  
  public boolean isMobileNet()
  {
    return true;
  }
  
  public void jumpAction(String paramString) {}
  
  public void onFlushLog()
  {
    if (this.mCustomizedLog != null) {
      this.mCustomizedLog.onFlushLogs();
    }
  }
  
  public void onUploadLog()
  {
    if (this.mCustomizedLog != null) {
      this.mCustomizedLog.onUploadLogs();
    }
  }
  
  public void openWebView(Bundle paramBundle, WebCallHandler paramWebCallHandler)
  {
    paramWebCallHandler = paramBundle.getString("url");
    if (this.mCustomizedWebView != null)
    {
      if (this.mWebcallHandler != null) {
        this.mWebcallHandler.getCookieInfo(new SdkBaseAbilityImpl.1(this, paramBundle, paramWebCallHandler));
      }
    }
    else {
      return;
    }
    this.mCustomizedWebView.onJumpWeb(paramWebCallHandler, paramBundle, this.mWebcallHandler);
  }
  
  public void printLog(int paramInt, String paramString1, String paramString2)
  {
    if (this.mCustomizedLog != null) {
      this.mCustomizedLog.onLog(2, paramString1, paramString2);
    }
  }
  
  public void printQLog(Bundle paramBundle)
  {
    String str = paramBundle.getString("tag", "nowplugin_dynamic");
    paramBundle = paramBundle.getString("msg", "");
    if (this.mCustomizedLog != null) {
      this.mCustomizedLog.onLog(2, str, paramBundle);
    }
  }
  
  public void reportData(Bundle paramBundle)
  {
    if (this.mCustomizedReport != null) {
      this.mCustomizedReport.onReport(paramBundle);
    }
  }
  
  public void reportNowEntry(NowEntryData paramNowEntryData)
  {
    if (this.mCustomizedReport != null) {
      this.mCustomizedReport.onNowEntry(null, paramNowEntryData);
    }
  }
  
  public String reqDns(String paramString)
  {
    try
    {
      paramString = this.mCustomDns.getip(paramString);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
  
  public void sendSSOTask(Bundle paramBundle, CommonCallback<Bundle> paramCommonCallback)
  {
    if (this.mCustomChannle != null) {
      this.mCustomChannle.onSendTask(paramBundle, paramCommonCallback);
    }
  }
  
  public void setCustomDns(CustomizedDns paramCustomizedDns)
  {
    this.mCustomDns = paramCustomizedDns;
  }
  
  public void setCustomToast(CustomizedToast paramCustomizedToast)
  {
    this.mCustomizedToast = paramCustomizedToast;
  }
  
  public void setCustomisedWebview(CustomizedWebView paramCustomizedWebView, WebCallHandler paramWebCallHandler)
  {
    this.mCustomizedWebView = paramCustomizedWebView;
    this.mWebcallHandler = paramWebCallHandler;
  }
  
  public void setCustomizeReport(CustomizedReport paramCustomizedReport)
  {
    this.mCustomizedReport = paramCustomizedReport;
  }
  
  public void setCustomizedCgi(CustomCgi paramCustomCgi)
  {
    this.mCustomCgi = paramCustomCgi;
  }
  
  public void setCustomizedChannel(CustomizedChannel paramCustomizedChannel)
  {
    this.mCustomChannle = paramCustomizedChannel;
  }
  
  public void setCustomizedDns(CustomizedDns paramCustomizedDns)
  {
    this.mCustomDns = paramCustomizedDns;
  }
  
  public void setCustomizedDownloader(CustomizedDownloader paramCustomizedDownloader)
  {
    this.mCustomizedDownloader = paramCustomizedDownloader;
  }
  
  public void setCustomizedLoader(CustomizedLoader paramCustomizedLoader)
  {
    this.customizedLoader = paramCustomizedLoader;
  }
  
  public void setCustomizedLoading(CustomizedLoading paramCustomizedLoading)
  {
    this.mCustomizedLoading = paramCustomizedLoading;
  }
  
  public void setCustomizedLog(CustomizedLog paramCustomizedLog)
  {
    this.mCustomizedLog = paramCustomizedLog;
  }
  
  public void setShadowImpl(IShadow paramIShadow)
  {
    this.mShadowImpl = paramIShadow;
  }
  
  public void setmCustomizedTiket(CustomizedTicket paramCustomizedTicket)
  {
    this.mCustomizedTiket = paramCustomizedTicket;
  }
  
  public void showLoadingUI(Context paramContext, Bundle paramBundle, View paramView)
  {
    if (this.mCustomizedLoading != null) {
      this.mCustomizedLoading.onShowLoading(paramContext, paramBundle, paramView);
    }
  }
  
  public void showToast(Context paramContext, CharSequence paramCharSequence, int paramInt)
  {
    if (this.mCustomizedToast != null) {
      this.mCustomizedToast.onShowToast(paramContext, paramCharSequence, paramInt);
    }
  }
  
  public void unInit() {}
  
  public boolean useIpDirectConnect()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.intervideo.nowproxy.ability.SdkBaseAbilityImpl
 * JD-Core Version:    0.7.0.1
 */