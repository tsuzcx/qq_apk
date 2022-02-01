package com.tencent.biz.pubaccount.readinjoyAd.ad.view;

import android.text.TextUtils;
import anzj;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.util.Pair;
import tkt;
import tns;
import trg;
import trk;

class GiftPackageGialog$4$1
  implements Runnable
{
  GiftPackageGialog$4$1(GiftPackageGialog.4 param4, Pair paramPair) {}
  
  public void run()
  {
    int j = 2;
    Object localObject = anzj.a(2131704166);
    if (!TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_ComTencentUtilPair.second)) {
      localObject = (String)this.jdField_a_of_type_ComTencentUtilPair.second;
    }
    if ((((Boolean)this.jdField_a_of_type_ComTencentUtilPair.first).booleanValue()) && (TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_ComTencentUtilPair.second))) {
      localObject = anzj.a(2131704167);
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
            tns.a(((QQAppInterface)localObject).getAccount(), trg.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewGiftPackageGialog$4.this$0));
            if (trg.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewGiftPackageGialog$4.this$0) != null) {
              trg.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewGiftPackageGialog$4.this$0).a(trg.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewGiftPackageGialog$4.this$0));
            }
          }
          if (!trg.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewGiftPackageGialog$4.this$0)) {
            tns.a(11, trg.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewGiftPackageGialog$4.this$0), trg.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewGiftPackageGialog$4.this$0), 30103, 3010305, 301);
          }
        }
        if ((trg.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewGiftPackageGialog$4.this$0)) && (trg.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewGiftPackageGialog$4.this$0) != null)) {
          tkt.b(trg.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewGiftPackageGialog$4.this$0), i, trg.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewGiftPackageGialog$4.this$0));
        }
        return;
        j = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.GiftPackageGialog.4.1
 * JD-Core Version:    0.7.0.1
 */