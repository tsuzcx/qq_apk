package com.tencent.biz.pubaccount.readinjoyAd.ad.view;

import android.text.TextUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.util.Pair;
import mqq.app.AppRuntime;

class GiftPackageDialog$4$1
  implements Runnable
{
  GiftPackageDialog$4$1(GiftPackageDialog.4 param4, Pair paramPair) {}
  
  public void run()
  {
    String str = HardCodeUtil.a(2131705363);
    if (!TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_ComTencentUtilPair.second)) {
      str = (String)this.jdField_a_of_type_ComTencentUtilPair.second;
    }
    boolean bool = ((Boolean)this.jdField_a_of_type_ComTencentUtilPair.first).booleanValue();
    int j = 2;
    int i;
    if ((bool) && (TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_ComTencentUtilPair.second)))
    {
      str = HardCodeUtil.a(2131705364);
      i = 0;
    }
    else
    {
      i = 2;
    }
    if (!((Boolean)this.jdField_a_of_type_ComTencentUtilPair.first).booleanValue()) {
      j = 1;
    }
    QQToast.a(((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).getApplication(), j, str, 0).a();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewGiftPackageDialog$4.this$0.isShowing()) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewGiftPackageDialog$4.this$0.dismiss();
    }
    if (((Boolean)this.jdField_a_of_type_ComTencentUtilPair.first).booleanValue())
    {
      str = ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAppRuntime().getAccount();
      if (!TextUtils.isEmpty(str))
      {
        ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).addGameGift(str, GiftPackageDialog.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewGiftPackageDialog$4.this$0));
        if (GiftPackageDialog.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewGiftPackageDialog$4.this$0) != null) {
          GiftPackageDialog.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewGiftPackageDialog$4.this$0).a(GiftPackageDialog.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewGiftPackageDialog$4.this$0));
        }
      }
      if (!GiftPackageDialog.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewGiftPackageDialog$4.this$0)) {
        ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).reportGetPackage(11, GiftPackageDialog.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewGiftPackageDialog$4.this$0), GiftPackageDialog.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewGiftPackageDialog$4.this$0), 30103, 3010305, 301);
      }
    }
    if ((GiftPackageDialog.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewGiftPackageDialog$4.this$0)) && (GiftPackageDialog.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewGiftPackageDialog$4.this$0) != null)) {
      ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).reportGameGiftClick(GiftPackageDialog.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewGiftPackageDialog$4.this$0), i, GiftPackageDialog.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewGiftPackageDialog$4.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.GiftPackageDialog.4.1
 * JD-Core Version:    0.7.0.1
 */