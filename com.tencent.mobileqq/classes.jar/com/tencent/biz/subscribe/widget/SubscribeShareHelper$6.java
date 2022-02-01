package com.tencent.biz.subscribe.widget;

import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;

class SubscribeShareHelper$6
  implements WXShareHelper.WXShareListener
{
  SubscribeShareHelper$6(SubscribeShareHelper paramSubscribeShareHelper) {}
  
  public void onWXShareResp(BaseResp paramBaseResp)
  {
    if (SubscribeShareHelper.a(this.a) != null)
    {
      if (!SubscribeShareHelper.a(this.a).equals(paramBaseResp.transaction)) {
        return;
      }
      int i = paramBaseResp.errCode;
      if (i != -2)
      {
        if (i != 0)
        {
          QQToast.a(this.a.a, 1, HardCodeUtil.a(2131714445), 0).a();
          return;
        }
        QQToast.a(this.a.a, 2, HardCodeUtil.a(2131714447), 0).a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.SubscribeShareHelper.6
 * JD-Core Version:    0.7.0.1
 */