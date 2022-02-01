package com.tencent.intervideo.nowproxy;

import android.os.Bundle;
import com.tencent.intervideo.nowproxy.CustomInterface.CustomizedPushSetting;
import com.tencent.intervideo.nowproxy.CustomInterface.ShareMenuList;
import com.tencent.intervideo.nowproxy.ability.ExtSdkBizAbilityImpl;
import com.tencent.intervideo.nowproxy.ability.SdkBaseAbilityImpl;
import com.tencent.intervideo.nowproxy.ability.SdkBizAbilityImpl;
import com.tencent.intervideo.nowproxy.baseability.DefaultLoading;
import com.tencent.intervideo.nowproxy.baseability.http.DefaultHttp;
import com.tencent.intervideo.nowproxy.baseability.log.DefaultLog;
import com.tencent.intervideo.nowproxy.baseability.report.DataReport;
import com.tencent.intervideo.nowproxy.baseability.toast.DefautToast;
import com.tencent.intervideo.nowproxy.customized_interface.CustomCgi;
import com.tencent.intervideo.nowproxy.customized_interface.CustomizedDns;
import com.tencent.intervideo.nowproxy.customized_interface.CustomizedDownloader;
import com.tencent.intervideo.nowproxy.customized_interface.CustomizedLoading;
import com.tencent.intervideo.nowproxy.customized_interface.CustomizedLog;
import com.tencent.intervideo.nowproxy.customized_interface.CustomizedReport;
import com.tencent.intervideo.nowproxy.customized_interface.CustomizedToast;
import com.tencent.intervideo.nowproxy.customized_interface.CustomizedWebView;
import com.tencent.intervideo.nowproxy.customized_interface.IShadow;
import com.tencent.intervideo.nowproxy.whitelist.WelfareTaskCallback;
import com.tencent.intervideo.shadow_updater.ShadowImpl;

public class CustomInterfaceLogic
{
  public static final String TAG = "SdkBaseAbilityImpl";
  public static CustomInterfaceLogic sInstance = new CustomInterfaceLogic();
  SdkBaseAbilityImpl baseImpl = SdkBaseAbilityImpl.getsInstance();
  SdkBizAbilityImpl bizImpl = SdkBizAbilityImpl.getInstance();
  CustomCgi customCgi;
  protected Bundle customiseByHost = new Bundle();
  protected Bundle customiseBySDK = new Bundle();
  CustomizedDownloader mCustomizedDownloader;
  CustomizedLoading mCustomizedLoading;
  CustomizedLog mCustomizedLog;
  CustomizedReport mDataReport;
  IShadow mShadow;
  
  public static CustomInterfaceLogic getsInstance()
  {
    return sInstance;
  }
  
  public Bundle getCustomiseData()
  {
    return this.customiseByHost;
  }
  
  public boolean getFreeFlow()
  {
    return this.customiseByHost.getBoolean("free_flow", false);
  }
  
  public void init(String paramString)
  {
    this.customiseBySDK.putBoolean("custom_webview", true);
    this.customiseBySDK.putBoolean("custom_report", true);
    this.customiseBySDK.putBoolean("custom_dns", true);
    this.customiseBySDK.putBoolean("custom_cgireq", true);
    this.customiseBySDK.putBoolean("custom_beacon_report", true);
    this.customiseByHost.putBoolean("welfare_task_callback", true);
    this.customiseByHost.putBoolean("core_action_callback", true);
    if (paramString.equals("2")) {}
    do
    {
      return;
      this.mDataReport = DataReport.getInstance(paramString, Global.getApplicationContext());
      setCustomizeReport(this.mDataReport);
      this.mShadow = new ShadowImpl();
      this.baseImpl.setShadowImpl(this.mShadow);
      this.mCustomizedLog = DefaultLog.getInstance();
      ((DefaultLog)this.mCustomizedLog).init(Global.getApplicationContext(), "now", false);
      setCustomizedLog(this.mCustomizedLog);
      this.customCgi = DefaultHttp.getsInstance();
      this.baseImpl.setCustomizedCgi(this.customCgi);
      this.mCustomizedLoading = new DefaultLoading();
      this.baseImpl.setCustomizedLoading(this.mCustomizedLoading);
      this.mCustomizedDownloader = new DefaultHttp();
      this.baseImpl.setCustomizedDownloader(this.mCustomizedDownloader);
      this.baseImpl.setCustomToast(new DefautToast());
    } while (!AppidConfig.isBrowserPlugin(Global.sAppid));
    ExtSdkBizAbilityImpl.getInstance().setCustomizedBeaconReport(new CustomInterfaceLogic.1(this));
  }
  
  public boolean isBeaconReportCustomizedBySdk()
  {
    return this.customiseBySDK.getBoolean("custom_beacon_report", false);
  }
  
  public boolean isCGIReqCustomizedBySdk()
  {
    return this.customiseBySDK.getBoolean("custom_cgireq", false);
  }
  
  public boolean isCustomCoverImg()
  {
    return this.customiseByHost.getBoolean("custom_cover_img", false);
  }
  
  public boolean isDNSCustomizedByHost()
  {
    return this.customiseByHost.getBoolean("custom_dns", false);
  }
  
  public boolean isDNSCustomizedBySDK()
  {
    return this.customiseBySDK.getBoolean("custom_dns", false);
  }
  
  public boolean isDownLoadCustomizedBySdk()
  {
    return this.customiseBySDK.getBoolean("custom_download", false);
  }
  
  public boolean isDownloadCustomizedByHost()
  {
    return this.customiseByHost.getBoolean("custom_download", false);
  }
  
  public boolean isLogCusomizedByHost()
  {
    return this.customiseByHost.getBoolean("custom_log", false);
  }
  
  public boolean isLogCusomizedBySdk()
  {
    return this.customiseBySDK.getBoolean("custom_log", false);
  }
  
  public boolean isReportCustomizedByHost()
  {
    return this.customiseByHost.getBoolean("custom_report", false);
  }
  
  public boolean isReportCustomizedBySDK()
  {
    return this.customiseBySDK.getBoolean("custom_report", false);
  }
  
  public boolean isToastCustomizedByHost()
  {
    return this.customiseByHost.getBoolean("custom_toast", false);
  }
  
  public boolean isToastCustomizedBySdk()
  {
    return this.customiseBySDK.getBoolean("custom_toast", false);
  }
  
  public boolean isWebviewCusomizedByHost()
  {
    return this.customiseByHost.getBoolean("custom_webview", false);
  }
  
  public boolean isWebviewCusomizedBySdk()
  {
    return this.customiseBySDK.getBoolean("custom_webview", false);
  }
  
  public void setCoreActionCallback(CoreActionCallback paramCoreActionCallback)
  {
    this.customiseByHost.putBoolean("core_action_callback", true);
    ExtSdkBizAbilityImpl.getInstance().setCoreActionCallback(paramCoreActionCallback);
  }
  
  public void setCustomCoverImg(CustomizedCoverImg paramCustomizedCoverImg)
  {
    this.customiseByHost.putBoolean("custom_cover_img", true);
    ExtSdkBizAbilityImpl.getInstance().setCustomizedCoverImg(paramCustomizedCoverImg);
  }
  
  public void setCustomDns(CustomizedDns paramCustomizedDns)
  {
    this.baseImpl.setCustomizedDns(paramCustomizedDns);
  }
  
  public void setCustomisedWebview(CustomizedWebView paramCustomizedWebView)
  {
    this.customiseByHost.putBoolean("custom_webview", true);
    this.customiseBySDK.putBoolean("custom_webview", true);
    if (Global.sAppid.equals("2"))
    {
      this.baseImpl.setCustomisedWebview(paramCustomizedWebView, null);
      return;
    }
    this.baseImpl.setCustomisedWebview(paramCustomizedWebView, new CustomInterfaceLogic.2(this));
  }
  
  public void setCustomizeReport(CustomizedReport paramCustomizedReport)
  {
    this.customiseByHost.putBoolean("custom_report", true);
    this.customiseBySDK.putBoolean("custom_report", true);
    this.baseImpl.setCustomizeReport(paramCustomizedReport);
  }
  
  public void setCustomizedDownloader(CustomizedDownloader paramCustomizedDownloader)
  {
    this.customiseByHost.putBoolean("custom_download", true);
    this.customiseBySDK.putBoolean("custom_download", true);
    this.baseImpl.setCustomizedDownloader(paramCustomizedDownloader);
  }
  
  public void setCustomizedLog(CustomizedLog paramCustomizedLog)
  {
    this.customiseByHost.putBoolean("custom_log", true);
    this.customiseBySDK.putBoolean("custom_log", true);
    this.baseImpl.setCustomizedLog(paramCustomizedLog);
  }
  
  public void setCustomizedOpenWxMiniProgram(CustomizedOpenWxMiniProgram paramCustomizedOpenWxMiniProgram)
  {
    ExtSdkBizAbilityImpl.getInstance().setCustomizedOpenWxMiniProgram(paramCustomizedOpenWxMiniProgram);
  }
  
  public void setCustomizedPay(CustomizedPayment paramCustomizedPayment)
  {
    this.customiseByHost.putBoolean("custom_pay", true);
    ExtSdkBizAbilityImpl.getInstance().setCustomizedPay(paramCustomizedPayment);
  }
  
  public void setCustomizedPushSetting(CustomizedPushSetting paramCustomizedPushSetting)
  {
    ExtSdkBizAbilityImpl.getInstance().setCustomizedPushSetting(paramCustomizedPushSetting);
  }
  
  public void setCustomizedShare(ShareMenuList paramShareMenuList, CustomizedShare paramCustomizedShare)
  {
    this.customiseByHost.putBoolean("custom_share", true);
    this.customiseByHost.putInt("custom_share_menu_flag", paramShareMenuList.getValue());
    ExtSdkBizAbilityImpl.getInstance().setCustomShare(paramCustomizedShare);
  }
  
  public void setCustomizedShare(CustomizedShare paramCustomizedShare)
  {
    this.customiseByHost.putBoolean("custom_share", true);
    this.customiseByHost.putInt("custom_share_menu_flag", 15);
    ExtSdkBizAbilityImpl.getInstance().setCustomShare(paramCustomizedShare);
  }
  
  public void setCustomizedToast(CustomizedToast paramCustomizedToast)
  {
    this.customiseByHost.putBoolean("custom_toast", true);
    this.customiseBySDK.putBoolean("custom_toast", true);
    this.baseImpl.setCustomToast(paramCustomizedToast);
  }
  
  public void setFreeFlow(boolean paramBoolean)
  {
    this.customiseByHost.putBoolean("free_flow", paramBoolean);
    Global.isQueenFreeFlow = paramBoolean;
  }
  
  public void setWelfareTaskCallback(WelfareTaskCallback paramWelfareTaskCallback)
  {
    this.customiseByHost.putBoolean("welfare_task_callback", true);
    ExtSdkBizAbilityImpl.getInstance().setWelfareTaskCallback(paramWelfareTaskCallback);
  }
  
  public void unInit() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.intervideo.nowproxy.CustomInterfaceLogic
 * JD-Core Version:    0.7.0.1
 */