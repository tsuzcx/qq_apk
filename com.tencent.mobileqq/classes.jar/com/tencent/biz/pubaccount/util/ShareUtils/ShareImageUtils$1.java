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
        QQToast.makeText(BaseApplicationImpl.getContext(), 2, 2131916544, 1).show();
        return;
      }
      QQToast.makeText(BaseApplicationImpl.getContext(), 2, 2131916563, 1).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.ShareUtils.ShareImageUtils.1
 * JD-Core Version:    0.7.0.1
 */