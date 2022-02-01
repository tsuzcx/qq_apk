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
    int i = paramBaseResp.errCode;
    if (i != -2)
    {
      if (i != 0)
      {
        QQToast.a(BaseApplicationImpl.getContext(), 2, 2131719009, 1).a();
        return;
      }
      QQToast.a(BaseApplicationImpl.getContext(), 2, 2131719027, 1).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.ShareUtils.ShareImageUtils.1
 * JD-Core Version:    0.7.0.1
 */