package com.tencent.biz.pubaccount.util.ShareUtils;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;

final class ShareImageUtils$1
  implements WXShareHelper.WXShareListener
{
  public void onWXShareResp(BaseResp paramBaseResp)
  {
    switch (paramBaseResp.errCode)
    {
    case -1: 
    default: 
      QQToast.a(BaseApplicationImpl.getContext(), 2, 2131719291, 1).a();
    case -2: 
      return;
    }
    QQToast.a(BaseApplicationImpl.getContext(), 2, 2131719309, 1).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.ShareUtils.ShareImageUtils.1
 * JD-Core Version:    0.7.0.1
 */