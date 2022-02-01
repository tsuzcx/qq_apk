package com.tencent.biz.pubaccount.readinjoy.common;

import com.tencent.biz.pubaccount.util.ReadInJoyShareHelperV2.ShareReport;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;

class WxShareHelperFromReadInjoy$3
  implements WXShareHelper.WXShareListener
{
  WxShareHelperFromReadInjoy$3(WxShareHelperFromReadInjoy paramWxShareHelperFromReadInjoy) {}
  
  public void onWXShareResp(BaseResp paramBaseResp)
  {
    if (paramBaseResp.errCode == 0) {}
    for (boolean bool = true;; bool = false)
    {
      WXShareHelper.a().b(this);
      ReadInJoyShareHelperV2.ShareReport.a.a(bool);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.WxShareHelperFromReadInjoy.3
 * JD-Core Version:    0.7.0.1
 */