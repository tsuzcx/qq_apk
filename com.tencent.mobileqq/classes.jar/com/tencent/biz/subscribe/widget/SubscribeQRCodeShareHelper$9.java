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
    if (SubscribeQRCodeShareHelper.o(this.a) != null)
    {
      if (!SubscribeQRCodeShareHelper.o(this.a).equals(paramBaseResp.transaction)) {
        return;
      }
      int i = paramBaseResp.errCode;
      if (i != -2)
      {
        if (i != 0)
        {
          QQToast.makeText(SubscribeQRCodeShareHelper.c(this.a), 1, "分享失败", 0).show();
          return;
        }
        QQToast.makeText(SubscribeQRCodeShareHelper.c(this.a), 2, "分享成功", 0).show();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.SubscribeQRCodeShareHelper.9
 * JD-Core Version:    0.7.0.1
 */