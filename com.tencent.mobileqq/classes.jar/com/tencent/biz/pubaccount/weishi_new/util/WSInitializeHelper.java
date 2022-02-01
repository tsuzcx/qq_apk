package com.tencent.biz.pubaccount.weishi_new.util;

import com.tencent.biz.pubaccount.weishi_new.aiolist.WSAioListHelper;
import com.tencent.biz.pubaccount.weishi_new.cache.WSRedDotPreloadManager;
import com.tencent.biz.pubaccount.weishi_new.config.experiment.WSExpABTestManager;
import com.tencent.biz.pubaccount.weishi_new.push.WSRedDotPushMsg;
import com.tencent.biz.pubaccount.weishi_new.report.WSLaunchDeltaTimeCalculator;
import com.tencent.biz.pubaccount.weishi_new.report.WSReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.adv.api.IVasAdvApi;

public class WSInitializeHelper
{
  private WSLaunchDeltaTimeCalculator a;
  private int b;
  private String c;
  
  public static WSInitializeHelper a()
  {
    return WSInitializeHelper.SingletonHolder.a();
  }
  
  public void a(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void b()
  {
    WSReportUtils.a("QQ_official_account");
  }
  
  public void c()
  {
    WSReportUtils.a("weishi_share_trendstab");
    ((IVasAdvApi)QRoute.api(IVasAdvApi.class)).initTbsEnvironment();
  }
  
  public void d()
  {
    WSExpABTestManager.a().b();
    WSRedDotPreloadManager.a().b();
  }
  
  public void e()
  {
    WSRedDotPushMsg localWSRedDotPushMsg = WeishiUtils.g();
    if (localWSRedDotPushMsg != null) {
      this.c = localWSRedDotPushMsg.mPushId;
    }
    this.b = 0;
    WSAioListHelper.c();
  }
  
  public String f()
  {
    return this.c;
  }
  
  public int g()
  {
    return this.b;
  }
  
  public WSLaunchDeltaTimeCalculator h()
  {
    if (this.a == null) {
      this.a = new WSLaunchDeltaTimeCalculator();
    }
    return this.a;
  }
  
  public void i()
  {
    this.c = "";
    this.a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.util.WSInitializeHelper
 * JD-Core Version:    0.7.0.1
 */