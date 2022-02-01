package com.tencent.biz.pubaccount.readinjoyAd.ad.view;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.report_action.GameComponentReport;
import com.tencent.biz.pubaccount.readinjoyAd.ad.manager.GiftPackageManager;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.util.Pair;

class GiftPackageDialog$4$1
  implements Runnable
{
  GiftPackageDialog$4$1(GiftPackageDialog.4 param4, Pair paramPair) {}
  
  public void run()
  {
    int j = 2;
    Object localObject = HardCodeUtil.a(2131705289);
    if (!TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_ComTencentUtilPair.second)) {
      localObject = (String)this.jdField_a_of_type_ComTencentUtilPair.second;
    }
    if ((((Boolean)this.jdField_a_of_type_ComTencentUtilPair.first).booleanValue()) && (TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_ComTencentUtilPair.second))) {
      localObject = HardCodeUtil.a(2131705290);
    }
    for (int i = 0;; i = 2)
    {
      if (((Boolean)this.jdField_a_of_type_ComTencentUtilPair.first).booleanValue()) {}
      for (;;)
      {
        QQToast.a(BaseApplicationImpl.getApplication(), j, (CharSequence)localObject, 0).a();
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewGiftPackageDialog$4.this$0.isShowing()) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewGiftPackageDialog$4.this$0.dismiss();
        }
        if (((Boolean)this.jdField_a_of_type_ComTencentUtilPair.first).booleanValue())
        {
          localObject = BaseApplicationImpl.getApplication().peekAppRuntime();
          if ((localObject != null) && ((localObject instanceof QQAppInterface)))
          {
            GiftPackageManager.a(((QQAppInterface)localObject).getAccount(), GiftPackageDialog.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewGiftPackageDialog$4.this$0));
            if (GiftPackageDialog.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewGiftPackageDialog$4.this$0) != null) {
              GiftPackageDialog.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewGiftPackageDialog$4.this$0).a(GiftPackageDialog.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewGiftPackageDialog$4.this$0));
            }
          }
          if (!GiftPackageDialog.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewGiftPackageDialog$4.this$0)) {
            GiftPackageManager.a(11, GiftPackageDialog.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewGiftPackageDialog$4.this$0), GiftPackageDialog.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewGiftPackageDialog$4.this$0), 30103, 3010305, 301);
          }
        }
        if ((GiftPackageDialog.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewGiftPackageDialog$4.this$0)) && (GiftPackageDialog.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewGiftPackageDialog$4.this$0) != null)) {
          GameComponentReport.a(GiftPackageDialog.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewGiftPackageDialog$4.this$0), i, GiftPackageDialog.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewGiftPackageDialog$4.this$0));
        }
        return;
        j = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.GiftPackageDialog.4.1
 * JD-Core Version:    0.7.0.1
 */