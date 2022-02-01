package com.tencent.mobileqq.activity;

import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;

class DiscussionInfoCardActivity$13
  implements WXShareHelper.WXShareListener
{
  DiscussionInfoCardActivity$13(DiscussionInfoCardActivity paramDiscussionInfoCardActivity) {}
  
  public void onWXShareResp(BaseResp paramBaseResp)
  {
    if (this.a.a != null)
    {
      if (!this.a.a.equals(paramBaseResp.transaction)) {
        return;
      }
      int i = paramBaseResp.errCode;
      if (i != -2)
      {
        if (i != 0)
        {
          QRUtils.a(1, 2131719009);
          return;
        }
        QRUtils.a(2, 2131719027);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.DiscussionInfoCardActivity.13
 * JD-Core Version:    0.7.0.1
 */