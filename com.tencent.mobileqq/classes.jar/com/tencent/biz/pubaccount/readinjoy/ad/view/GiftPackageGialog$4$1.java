package com.tencent.biz.pubaccount.readinjoy.ad.view;

import android.text.TextUtils;
import anni;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.util.Pair;
import oll;
import ooh;
import oro;
import ors;

class GiftPackageGialog$4$1
  implements Runnable
{
  GiftPackageGialog$4$1(GiftPackageGialog.4 param4, Pair paramPair) {}
  
  public void run()
  {
    int j = 2;
    Object localObject = anni.a(2131704059);
    if (!TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_ComTencentUtilPair.second)) {
      localObject = (String)this.jdField_a_of_type_ComTencentUtilPair.second;
    }
    if ((((Boolean)this.jdField_a_of_type_ComTencentUtilPair.first).booleanValue()) && (TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_ComTencentUtilPair.second))) {
      localObject = anni.a(2131704060);
    }
    for (int i = 0;; i = 2)
    {
      if (((Boolean)this.jdField_a_of_type_ComTencentUtilPair.first).booleanValue()) {}
      for (;;)
      {
        QQToast.a(BaseApplicationImpl.getApplication(), j, (CharSequence)localObject, 0).a();
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewGiftPackageGialog$4.this$0.isShowing()) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewGiftPackageGialog$4.this$0.dismiss();
        }
        if (((Boolean)this.jdField_a_of_type_ComTencentUtilPair.first).booleanValue())
        {
          localObject = BaseApplicationImpl.getApplication().peekAppRuntime();
          if ((localObject != null) && ((localObject instanceof QQAppInterface)))
          {
            ooh.a(((QQAppInterface)localObject).getAccount(), oro.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewGiftPackageGialog$4.this$0));
            if (oro.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewGiftPackageGialog$4.this$0) != null) {
              oro.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewGiftPackageGialog$4.this$0).a(oro.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewGiftPackageGialog$4.this$0));
            }
          }
          if (!oro.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewGiftPackageGialog$4.this$0)) {
            ooh.a(11, oro.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewGiftPackageGialog$4.this$0), oro.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewGiftPackageGialog$4.this$0), 30103, 3010305, 301);
          }
        }
        if ((oro.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewGiftPackageGialog$4.this$0)) && (oro.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewGiftPackageGialog$4.this$0) != null)) {
          oll.b(oro.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewGiftPackageGialog$4.this$0), i, oro.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewGiftPackageGialog$4.this$0));
        }
        return;
        j = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ad.view.GiftPackageGialog.4.1
 * JD-Core Version:    0.7.0.1
 */