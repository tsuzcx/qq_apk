package com.tencent.biz.pubaccount.readinjoy.ad.view;

import ajjy;
import android.text.TextUtils;
import bbmy;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.util.Pair;
import nbe;
import nmv;
import nnx;
import npv;
import npz;

class GiftPackageGialog$4$1
  implements Runnable
{
  GiftPackageGialog$4$1(GiftPackageGialog.4 param4, Pair paramPair) {}
  
  public void run()
  {
    Object localObject1 = ajjy.a(2131639484);
    if (!TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_ComTencentUtilPair.second)) {
      localObject1 = (String)this.jdField_a_of_type_ComTencentUtilPair.second;
    }
    Object localObject2 = localObject1;
    if (((Boolean)this.jdField_a_of_type_ComTencentUtilPair.first).booleanValue())
    {
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_ComTencentUtilPair.second)) {
        localObject2 = ajjy.a(2131639485);
      }
    }
    if (((Boolean)this.jdField_a_of_type_ComTencentUtilPair.first).booleanValue()) {}
    for (int i = 2;; i = 1)
    {
      bbmy.a(BaseApplicationImpl.getApplication(), i, (CharSequence)localObject2, 0).a();
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewGiftPackageGialog$4.this$0.isShowing()) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewGiftPackageGialog$4.this$0.dismiss();
      }
      if (((Boolean)this.jdField_a_of_type_ComTencentUtilPair.first).booleanValue())
      {
        localObject1 = BaseApplicationImpl.getApplication().peekAppRuntime();
        if ((localObject1 != null) && ((localObject1 instanceof QQAppInterface)))
        {
          nnx.a(((QQAppInterface)localObject1).getAccount(), npv.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewGiftPackageGialog$4.this$0));
          if (npv.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewGiftPackageGialog$4.this$0) != null) {
            npv.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewGiftPackageGialog$4.this$0).a(npv.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewGiftPackageGialog$4.this$0));
          }
        }
        if ((!npv.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewGiftPackageGialog$4.this$0)) || (npv.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewGiftPackageGialog$4.this$0) == null)) {
          break;
        }
        nbe.a(new nmv().a(npv.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewGiftPackageGialog$4.this$0)).a(nbe.z).b(nbe.ad).c(nbe.ao).d(npv.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewGiftPackageGialog$4.this$0)).a(npv.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewGiftPackageGialog$4.this$0)).e(nnx.a(npv.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewGiftPackageGialog$4.this$0), nbe.H)).a());
      }
      return;
    }
    nnx.a(11, npv.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewGiftPackageGialog$4.this$0), npv.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewGiftPackageGialog$4.this$0), 30103, 3010305, 301);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ad.view.GiftPackageGialog.4.1
 * JD-Core Version:    0.7.0.1
 */