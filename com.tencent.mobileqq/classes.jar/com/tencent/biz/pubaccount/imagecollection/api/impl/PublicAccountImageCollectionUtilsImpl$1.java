package com.tencent.biz.pubaccount.imagecollection.api.impl;

import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;

final class PublicAccountImageCollectionUtilsImpl$1
  implements WXShareHelper.WXShareListener
{
  PublicAccountImageCollectionUtilsImpl$1(String paramString) {}
  
  public void onWXShareResp(BaseResp paramBaseResp)
  {
    String str = this.a;
    if (str != null)
    {
      if (!str.equals(paramBaseResp.transaction)) {
        return;
      }
      BaseApplicationImpl.getContext();
      int i = paramBaseResp.errCode;
      if (i != -2) {
        if (i != 0) {
          QRUtils.a(1, 2131719009);
        } else {
          QRUtils.a(2, 2131719027);
        }
      }
      WXShareHelper.a().b(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.imagecollection.api.impl.PublicAccountImageCollectionUtilsImpl.1
 * JD-Core Version:    0.7.0.1
 */