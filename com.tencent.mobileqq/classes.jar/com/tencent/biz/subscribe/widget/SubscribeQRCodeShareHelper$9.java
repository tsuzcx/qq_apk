package com.tencent.biz.subscribe.widget;

import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;

class SubscribeQRCodeShareHelper$9
  implements WXShareHelper.WXShareListener
{
  SubscribeQRCodeShareHelper$9(SubscribeQRCodeShareHelper paramSubscribeQRCodeShareHelper) {}
  
  public void onWXShareResp(BaseResp paramBaseResp)
  {
    if ((SubscribeQRCodeShareHelper.c(this.a) == null) || (!SubscribeQRCodeShareHelper.c(this.a).equals(paramBaseResp.transaction))) {
      return;
    }
    switch (paramBaseResp.errCode)
    {
    case -2: 
    case -1: 
    default: 
      QQToast.a(SubscribeQRCodeShareHelper.a(this.a), 1, "分享失败", 0).a();
      return;
    }
    QQToast.a(SubscribeQRCodeShareHelper.a(this.a), 2, "分享成功", 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.SubscribeQRCodeShareHelper.9
 * JD-Core Version:    0.7.0.1
 */