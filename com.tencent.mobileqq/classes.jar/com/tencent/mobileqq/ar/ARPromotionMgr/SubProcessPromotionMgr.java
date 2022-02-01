package com.tencent.mobileqq.ar.ARPromotionMgr;

import android.content.IntentFilter;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.BusinessCommonConfig;
import com.tencent.mobileqq.utils.QQAudioHelper;
import com.tencent.mobileqq.utils.configsp.ARPromotionConfigSP;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class SubProcessPromotionMgr
  extends PromotionMgr
{
  static PromotionConfigInfo g;
  final String f;
  
  public SubProcessPromotionMgr(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SubProcessPromotionMgr_");
    localStringBuilder.append(QQAudioHelper.d());
    this.f = localStringBuilder.toString();
    d(paramAppInterface);
    paramAppInterface = this.f;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("SubProcessPromotionMgr, sProcessId[");
    localStringBuilder.append(BaseApplicationImpl.sProcessId);
    localStringBuilder.append("], processName[");
    localStringBuilder.append(BaseApplicationImpl.processName);
    localStringBuilder.append("]");
    QLog.w(paramAppInterface, 1, localStringBuilder.toString());
  }
  
  public void a(AppInterface paramAppInterface, PromotionMgr.GetConfigListen paramGetConfigListen)
  {
    if (a("snycGetConfig", paramAppInterface, paramGetConfigListen)) {
      return;
    }
    paramGetConfigListen.a(a());
  }
  
  public void a(AppInterface paramAppInterface, String paramString)
  {
    BusinessCommonConfig.notifyQQDownload(2, paramString, 0);
  }
  
  void a(PromotionConfigInfo paramPromotionConfigInfo)
  {
    super.a(paramPromotionConfigInfo);
    try
    {
      g = paramPromotionConfigInfo;
      return;
    }
    finally {}
  }
  
  void b(AppInterface paramAppInterface) {}
  
  void b(String paramString)
  {
    try
    {
      paramString = ARPromotionConfigSP.b(this.b, paramString);
      a(paramString);
      String str = this.f;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("reloadConfigInfo, Uin[");
      localStringBuilder.append(this.b);
      localStringBuilder.append("] configInfo[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
      return;
    }
    finally {}
  }
  
  boolean d(AppInterface paramAppInterface)
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("tencent.businessnotify.qq.to.subprocess");
    return paramAppInterface.getApp().registerReceiver(new SubProcessPromotionMgr.1(this), localIntentFilter) != null;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    g = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARPromotionMgr.SubProcessPromotionMgr
 * JD-Core Version:    0.7.0.1
 */