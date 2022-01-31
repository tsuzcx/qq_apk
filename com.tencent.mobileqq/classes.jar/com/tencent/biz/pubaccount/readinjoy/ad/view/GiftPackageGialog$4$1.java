package com.tencent.biz.pubaccount.readinjoy.ad.view;

import alpo;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.util.Pair;
import noy;
import obk;
import ocp;
import oev;
import oez;

class GiftPackageGialog$4$1
  implements Runnable
{
  GiftPackageGialog$4$1(GiftPackageGialog.4 param4, Pair paramPair) {}
  
  public void run()
  {
    Object localObject1 = alpo.a(2131705652);
    if (!TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_ComTencentUtilPair.second)) {
      localObject1 = (String)this.jdField_a_of_type_ComTencentUtilPair.second;
    }
    Object localObject2 = localObject1;
    if (((Boolean)this.jdField_a_of_type_ComTencentUtilPair.first).booleanValue())
    {
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_ComTencentUtilPair.second)) {
        localObject2 = alpo.a(2131705653);
      }
    }
    if (((Boolean)this.jdField_a_of_type_ComTencentUtilPair.first).booleanValue()) {}
    for (int i = 2;; i = 1)
    {
      QQToast.a(BaseApplicationImpl.getApplication(), i, (CharSequence)localObject2, 0).a();
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewGiftPackageGialog$4.this$0.isShowing()) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewGiftPackageGialog$4.this$0.dismiss();
      }
      if (((Boolean)this.jdField_a_of_type_ComTencentUtilPair.first).booleanValue())
      {
        localObject1 = BaseApplicationImpl.getApplication().peekAppRuntime();
        if ((localObject1 != null) && ((localObject1 instanceof QQAppInterface)))
        {
          ocp.a(((QQAppInterface)localObject1).getAccount(), oev.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewGiftPackageGialog$4.this$0));
          if (oev.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewGiftPackageGialog$4.this$0) != null) {
            oev.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewGiftPackageGialog$4.this$0).a(oev.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewGiftPackageGialog$4.this$0));
          }
        }
        if ((!oev.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewGiftPackageGialog$4.this$0)) || (oev.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewGiftPackageGialog$4.this$0) == null)) {
          break;
        }
        noy.a(new obk().a(oev.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewGiftPackageGialog$4.this$0)).a(noy.z).b(noy.ad).c(noy.ao).d(oev.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewGiftPackageGialog$4.this$0)).a(oev.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewGiftPackageGialog$4.this$0)).e(ocp.a(oev.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewGiftPackageGialog$4.this$0), noy.H)).a());
      }
      return;
    }
    ocp.a(11, oev.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewGiftPackageGialog$4.this$0), oev.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewGiftPackageGialog$4.this$0), 30103, 3010305, 301);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ad.view.GiftPackageGialog.4.1
 * JD-Core Version:    0.7.0.1
 */