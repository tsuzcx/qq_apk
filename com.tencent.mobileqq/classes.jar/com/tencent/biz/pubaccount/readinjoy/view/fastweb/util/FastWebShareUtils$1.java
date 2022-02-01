package com.tencent.biz.pubaccount.readinjoy.view.fastweb.util;

import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;
import mqq.app.MobileQQ;

class FastWebShareUtils$1
  implements WXShareHelper.WXShareListener
{
  FastWebShareUtils$1(FastWebShareUtils paramFastWebShareUtils, ArticleInfo paramArticleInfo, int paramInt) {}
  
  public void onWXShareResp(BaseResp paramBaseResp)
  {
    boolean bool = true;
    if ((FastWebShareUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebShareUtils) == null) || (!FastWebShareUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebShareUtils).equals(paramBaseResp.transaction))) {
      return;
    }
    switch (paramBaseResp.errCode)
    {
    case -1: 
    default: 
      QRUtils.b(1, 2131719291);
      bool = false;
    }
    for (;;)
    {
      paramBaseResp = (AppInterface)ReadInJoyUtils.a();
      ReportUtil.b(paramBaseResp.getApplication().getApplicationContext(), paramBaseResp, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_Int, -1, false, bool);
      return;
      QRUtils.b(2, 2131719309);
      continue;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebShareUtils.1
 * JD-Core Version:    0.7.0.1
 */