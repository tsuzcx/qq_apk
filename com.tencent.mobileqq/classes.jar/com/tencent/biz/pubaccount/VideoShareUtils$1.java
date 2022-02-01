package com.tencent.biz.pubaccount;

import com.tencent.biz.pubaccount.util.ReadInJoyShareHelperV2.ShareResultCallback;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;

final class VideoShareUtils$1
  implements WXShareHelper.WXShareListener
{
  VideoShareUtils$1(String paramString, ReadInJoyShareHelperV2.ShareResultCallback paramShareResultCallback) {}
  
  public void onWXShareResp(BaseResp paramBaseResp)
  {
    boolean bool = true;
    if ((this.jdField_a_of_type_JavaLangString == null) || (!this.jdField_a_of_type_JavaLangString.equals(paramBaseResp.transaction))) {
      return;
    }
    BaseApplicationImpl.getContext();
    switch (paramBaseResp.errCode)
    {
    case -1: 
    default: 
      QRUtils.b(1, 2131719291);
      bool = false;
    }
    for (;;)
    {
      WXShareHelper.a().b(this);
      if (this.jdField_a_of_type_ComTencentBizPubaccountUtilReadInJoyShareHelperV2$ShareResultCallback == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountUtilReadInJoyShareHelperV2$ShareResultCallback.a(bool);
      return;
      QRUtils.b(2, 2131719309);
      continue;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.VideoShareUtils.1
 * JD-Core Version:    0.7.0.1
 */