package com.tencent.biz.pubaccount.weishi_new.util;

import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;
import com.tencent.open.base.ToastUtil;

final class WeishiShareUtil$2
  implements WXShareHelper.WXShareListener
{
  public void onWXShareResp(BaseResp paramBaseResp)
  {
    switch (paramBaseResp.errCode)
    {
    case -1: 
    default: 
      ToastUtil.a().a(2131719291);
    }
    WXShareHelper.a().b(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.util.WeishiShareUtil.2
 * JD-Core Version:    0.7.0.1
 */