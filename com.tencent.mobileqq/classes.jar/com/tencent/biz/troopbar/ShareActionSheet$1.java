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
    if (paramBaseResp.errCode != 0) {
      QRUtils.a(1, 2131719009);
    } else {
      QRUtils.a(2, 2131719027);
    }
    WXShareHelper.a().b(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.troopbar.ShareActionSheet.1
 * JD-Core Version:    0.7.0.1
 */