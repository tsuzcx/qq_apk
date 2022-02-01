package com.tencent.biz.pubaccount.weishi_new.config;

import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.mobileqq.config.QConfigManager;

public class WSConfigManager
{
  private WeSeeConfigBean a = (WeSeeConfigBean)QConfigManager.a().a(447);
  
  public static WSConfigManager a()
  {
    return WSConfigManager.SingleTonHolder.a();
  }
  
  public WeSeeConfigBean a()
  {
    WeSeeConfigBean localWeSeeConfigBean = this.a;
    if (localWeSeeConfigBean != null) {
      WSLog.e("WSConfigManager", localWeSeeConfigBean.toString());
    }
    return localWeSeeConfigBean;
  }
  
  public void a(WeSeeConfigBean paramWeSeeConfigBean)
  {
    if (paramWeSeeConfigBean != null) {
      WSLog.e("WSConfigManager", paramWeSeeConfigBean.toString());
    }
    this.a = paramWeSeeConfigBean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.config.WSConfigManager
 * JD-Core Version:    0.7.0.1
 */