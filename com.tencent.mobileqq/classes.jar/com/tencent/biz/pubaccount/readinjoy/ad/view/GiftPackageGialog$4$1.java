package com.tencent.biz.pubaccount.readinjoy.ad.view;

import ajya;
import android.text.TextUtils;
import bcql;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.util.Pair;
import nmc;
import nyd;
import nzf;
import obd;
import obh;

class GiftPackageGialog$4$1
  implements Runnable
{
  GiftPackageGialog$4$1(GiftPackageGialog.4 param4, Pair paramPair) {}
  
  public void run()
  {
    Object localObject1 = ajya.a(2131705280);
    if (!TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_ComTencentUtilPair.second)) {
      localObject1 = (String)this.jdField_a_of_type_ComTencentUtilPair.second;
    }
    Object localObject2 = localObject1;
    if (((Boolean)this.jdField_a_of_type_ComTencentUtilPair.first).booleanValue())
    {
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_ComTencentUtilPair.second)) {
        localObject2 = ajya.a(2131705281);
      }
    }
    if (((Boolean)this.jdField_a_of_type_ComTencentUtilPair.first).booleanValue()) {}
    for (int i = 2;; i = 1)
    {
      bcql.a(BaseApplicationImpl.getApplication(), i, (CharSequence)localObject2, 0).a();
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewGiftPackageGialog$4.this$0.isShowing()) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewGiftPackageGialog$4.this$0.dismiss();
      }
      if (((Boolean)this.jdField_a_of_type_ComTencentUtilPair.first).booleanValue())
      {
        localObject1 = BaseApplicationImpl.getApplication().peekAppRuntime();
        if ((localObject1 != null) && ((localObject1 instanceof QQAppInterface)))
        {
          nzf.a(((QQAppInterface)localObject1).getAccount(), obd.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewGiftPackageGialog$4.this$0));
          if (obd.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewGiftPackageGialog$4.this$0) != null) {
            obd.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewGiftPackageGialog$4.this$0).a(obd.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewGiftPackageGialog$4.this$0));
          }
        }
        if ((!obd.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewGiftPackageGialog$4.this$0)) || (obd.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewGiftPackageGialog$4.this$0) == null)) {
          break;
        }
        nmc.a(new nyd().a(obd.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewGiftPackageGialog$4.this$0)).a(nmc.z).b(nmc.ad).c(nmc.ao).d(obd.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewGiftPackageGialog$4.this$0)).a(obd.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewGiftPackageGialog$4.this$0)).e(nzf.a(obd.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewGiftPackageGialog$4.this$0), nmc.H)).a());
      }
      return;
    }
    nzf.a(11, obd.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewGiftPackageGialog$4.this$0), obd.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewGiftPackageGialog$4.this$0), 30103, 3010305, 301);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ad.view.GiftPackageGialog.4.1
 * JD-Core Version:    0.7.0.1
 */