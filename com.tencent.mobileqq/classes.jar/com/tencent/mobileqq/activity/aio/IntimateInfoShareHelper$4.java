package com.tencent.mobileqq.activity.aio;

import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;

class IntimateInfoShareHelper$4
  implements WXShareHelper.WXShareListener
{
  IntimateInfoShareHelper$4(IntimateInfoShareHelper paramIntimateInfoShareHelper) {}
  
  public void onWXShareResp(BaseResp paramBaseResp)
  {
    if (paramBaseResp.errCode != 0) {
      IntimateInfoShareHelper.a(this.a, 1, 2131891007);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.IntimateInfoShareHelper.4
 * JD-Core Version:    0.7.0.1
 */