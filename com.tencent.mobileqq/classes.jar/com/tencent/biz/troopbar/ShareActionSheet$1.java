package com.tencent.biz.troopbar;

import android.text.TextUtils;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;

final class ShareActionSheet$1
  implements WXShareHelper.WXShareListener
{
  ShareActionSheet$1(String paramString) {}
  
  public void onWXShareResp(BaseResp paramBaseResp)
  {
    if (!TextUtils.equals(this.a, paramBaseResp.transaction)) {
      return;
    }
    switch (paramBaseResp.errCode)
    {
    default: 
      QRUtils.a(1, 2131719291);
    }
    for (;;)
    {
      WXShareHelper.a().b(this);
      return;
      QRUtils.a(2, 2131719309);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.troopbar.ShareActionSheet.1
 * JD-Core Version:    0.7.0.1
 */