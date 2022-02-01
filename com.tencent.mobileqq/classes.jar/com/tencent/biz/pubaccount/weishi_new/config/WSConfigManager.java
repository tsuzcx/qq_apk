package com.tencent.biz.pubaccount.weishi_new.config;

import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.mobileqq.config.QConfigManager;

public class WSConfigManager
{
  private WeSeeConfigBean a = (WeSeeConfigBean)QConfigManager.b().b(447);
  
  public static WSConfigManager a()
  {
    return WSConfigManager.SingleTonHolder.a();
  }
  
  public void a(WeSeeConfigBean paramWeSeeConfigBean)
  {
    if (paramWeSeeConfigBean != null) {
      WSLog.e("WSConfigManager", paramWeSeeConfigBean.toString());
    }
    this.a = paramWeSeeConfigBean;
  }
  
  public WeSeeConfigBean b()
  {
    WeSeeConfigBean localWeSeeConfigBean = this.a;
    if (localWeSeeConfigBean != null) {
      WSLog.e("WSConfigManager", localWeSeeConfigBean.toString());
    }
    return localWeSeeConfigBean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.config.WSConfigManager
 * JD-Core Version:    0.7.0.1
 */