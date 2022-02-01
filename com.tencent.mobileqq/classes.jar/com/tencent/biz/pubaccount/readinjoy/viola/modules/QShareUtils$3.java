package com.tencent.biz.pubaccount.readinjoy.viola.modules;

import com.tencent.biz.pubaccount.util.ReadInJoyShareHelperV2.ShareReport;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;

class QShareUtils$3
  implements WXShareHelper.WXShareListener
{
  QShareUtils$3(QShareUtils paramQShareUtils) {}
  
  public void onWXShareResp(BaseResp paramBaseResp)
  {
    boolean bool = true;
    if ((QShareUtils.a(this.a) == null) || (!QShareUtils.a(this.a).equals(paramBaseResp.transaction))) {
      return;
    }
    switch (paramBaseResp.errCode)
    {
    case -1: 
    default: 
      QRUtils.a(1, 2131719291);
      bool = false;
    }
    for (;;)
    {
      ReadInJoyShareHelperV2.ShareReport.a.a(bool);
      return;
      QRUtils.a(2, 2131719309);
      continue;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.modules.QShareUtils.3
 * JD-Core Version:    0.7.0.1
 */