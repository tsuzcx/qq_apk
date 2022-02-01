package com.tencent.biz.pubaccount.readinjoyAd.ad.view;

import android.text.TextUtils;
import anvx;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.util.Pair;
import ueb;
import uhw;
import ulx;
import umb;

class GiftPackageDialog$4$1
  implements Runnable
{
  GiftPackageDialog$4$1(GiftPackageDialog.4 param4, Pair paramPair) {}
  
  public void run()
  {
    int j = 2;
    Object localObject = anvx.a(2131704746);
    if (!TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_ComTencentUtilPair.second)) {
      localObject = (String)this.jdField_a_of_type_ComTencentUtilPair.second;
    }
    if ((((Boolean)this.jdField_a_of_type_ComTencentUtilPair.first).booleanValue()) && (TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_ComTencentUtilPair.second))) {
      localObject = anvx.a(2131704747);
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
            uhw.a(((QQAppInterface)localObject).getAccount(), ulx.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewGiftPackageDialog$4.this$0));
            if (ulx.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewGiftPackageDialog$4.this$0) != null) {
              ulx.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewGiftPackageDialog$4.this$0).a(ulx.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewGiftPackageDialog$4.this$0));
            }
          }
          if (!ulx.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewGiftPackageDialog$4.this$0)) {
            uhw.a(11, ulx.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewGiftPackageDialog$4.this$0), ulx.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewGiftPackageDialog$4.this$0), 30103, 3010305, 301);
          }
        }
        if ((ulx.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewGiftPackageDialog$4.this$0)) && (ulx.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewGiftPackageDialog$4.this$0) != null)) {
          ueb.a(ulx.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewGiftPackageDialog$4.this$0), i, ulx.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewGiftPackageDialog$4.this$0));
        }
        return;
        j = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.GiftPackageDialog.4.1
 * JD-Core Version:    0.7.0.1
 */