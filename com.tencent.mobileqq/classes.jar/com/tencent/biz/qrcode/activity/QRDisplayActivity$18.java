package com.tencent.biz.qrcode.activity;

import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;

class QRDisplayActivity$18
  implements WXShareHelper.WXShareListener
{
  QRDisplayActivity$18(QRDisplayActivity paramQRDisplayActivity) {}
  
  public void onWXShareResp(BaseResp paramBaseResp)
  {
    if (this.a.F != null)
    {
      if (!this.a.F.equals(paramBaseResp.transaction)) {
        return;
      }
      int i = paramBaseResp.errCode;
      if (i != -2)
      {
        if (i != 0)
        {
          QRUtils.a(1, 2131916544);
          return;
        }
        QRUtils.a(2, 2131916563);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRDisplayActivity.18
 * JD-Core Version:    0.7.0.1
 */