package com.tencent.biz.pubaccount.readinjoyAd.ad.view;

import amtj;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.util.Pair;
import tqj;
import ttp;
import txz;
import tyd;

class GiftPackageGialog$4$1
  implements Runnable
{
  GiftPackageGialog$4$1(GiftPackageGialog.4 param4, Pair paramPair) {}
  
  public void run()
  {
    int j = 2;
    Object localObject = amtj.a(2131704395);
    if (!TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_ComTencentUtilPair.second)) {
      localObject = (String)this.jdField_a_of_type_ComTencentUtilPair.second;
    }
    if ((((Boolean)this.jdField_a_of_type_ComTencentUtilPair.first).booleanValue()) && (TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_ComTencentUtilPair.second))) {
      localObject = amtj.a(2131704396);
    }
    for (int i = 0;; i = 2)
    {
      if (((Boolean)this.jdField_a_of_type_ComTencentUtilPair.first).booleanValue()) {}
      for (;;)
      {
        QQToast.a(BaseApplicationImpl.getApplication(), j, (CharSequence)localObject, 0).a();
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewGiftPackageGialog$4.this$0.isShowing()) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewGiftPackageGialog$4.this$0.dismiss();
        }
        if (((Boolean)this.jdField_a_of_type_ComTencentUtilPair.first).booleanValue())
        {
          localObject = BaseApplicationImpl.getApplication().peekAppRuntime();
          if ((localObject != null) && ((localObject instanceof QQAppInterface)))
          {
            ttp.a(((QQAppInterface)localObject).getAccount(), txz.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewGiftPackageGialog$4.this$0));
            if (txz.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewGiftPackageGialog$4.this$0) != null) {
              txz.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewGiftPackageGialog$4.this$0).a(txz.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewGiftPackageGialog$4.this$0));
            }
          }
          if (!txz.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewGiftPackageGialog$4.this$0)) {
            ttp.a(11, txz.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewGiftPackageGialog$4.this$0), txz.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewGiftPackageGialog$4.this$0), 30103, 3010305, 301);
          }
        }
        if ((txz.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewGiftPackageGialog$4.this$0)) && (txz.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewGiftPackageGialog$4.this$0) != null)) {
          tqj.b(txz.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewGiftPackageGialog$4.this$0), i, txz.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewGiftPackageGialog$4.this$0));
        }
        return;
        j = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.GiftPackageGialog.4.1
 * JD-Core Version:    0.7.0.1
 */