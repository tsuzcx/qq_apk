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
    if (SubscribeShareHelper.j(this.a) != null)
    {
      if (!SubscribeShareHelper.j(this.a).equals(paramBaseResp.transaction)) {
        return;
      }
      int i = paramBaseResp.errCode;
      if (i != -2)
      {
        if (i != 0)
        {
          QQToast.makeText(this.a.a, 1, HardCodeUtil.a(2131911955), 0).show();
          return;
        }
        QQToast.makeText(this.a.a, 2, HardCodeUtil.a(2131911957), 0).show();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.SubscribeShareHelper.6
 * JD-Core Version:    0.7.0.1
 */