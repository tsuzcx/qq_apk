package com.tencent.biz.pubaccount.readinjoy.ad.view;

import ajyc;
import android.text.TextUtils;
import bcpw;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.util.Pair;
import nmf;
import nyg;
import nzi;
import obg;
import obk;

class GiftPackageGialog$4$1
  implements Runnable
{
  GiftPackageGialog$4$1(GiftPackageGialog.4 param4, Pair paramPair) {}
  
  public void run()
  {
    Object localObject1 = ajyc.a(2131705269);
    if (!TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_ComTencentUtilPair.second)) {
      localObject1 = (String)this.jdField_a_of_type_ComTencentUtilPair.second;
    }
    Object localObject2 = localObject1;
    if (((Boolean)this.jdField_a_of_type_ComTencentUtilPair.first).booleanValue())
    {
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_ComTencentUtilPair.second)) {
        localObject2 = ajyc.a(2131705270);
      }
    }
    if (((Boolean)this.jdField_a_of_type_ComTencentUtilPair.first).booleanValue()) {}
    for (int i = 2;; i = 1)
    {
      bcpw.a(BaseApplicationImpl.getApplication(), i, (CharSequence)localObject2, 0).a();
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewGiftPackageGialog$4.this$0.isShowing()) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewGiftPackageGialog$4.this$0.dismiss();
      }
      if (((Boolean)this.jdField_a_of_type_ComTencentUtilPair.first).booleanValue())
      {
        localObject1 = BaseApplicationImpl.getApplication().peekAppRuntime();
        if ((localObject1 != null) && ((localObject1 instanceof QQAppInterface)))
        {
          nzi.a(((QQAppInterface)localObject1).getAccount(), obg.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewGiftPackageGialog$4.this$0));
          if (obg.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewGiftPackageGialog$4.this$0) != null) {
            obg.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewGiftPackageGialog$4.this$0).a(obg.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewGiftPackageGialog$4.this$0));
          }
        }
        if ((!obg.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewGiftPackageGialog$4.this$0)) || (obg.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewGiftPackageGialog$4.this$0) == null)) {
          break;
        }
        nmf.a(new nyg().a(obg.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewGiftPackageGialog$4.this$0)).a(nmf.z).b(nmf.ad).c(nmf.ao).d(obg.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewGiftPackageGialog$4.this$0)).a(obg.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewGiftPackageGialog$4.this$0)).e(nzi.a(obg.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewGiftPackageGialog$4.this$0), nmf.H)).a());
      }
      return;
    }
    nzi.a(11, obg.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewGiftPackageGialog$4.this$0), obg.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewGiftPackageGialog$4.this$0), 30103, 3010305, 301);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ad.view.GiftPackageGialog.4.1
 * JD-Core Version:    0.7.0.1
 */