package com.tencent.biz.pubaccount.readinjoyAd.ad.view;

import com.tencent.biz.pubaccount.readinjoyAd.ad.data.GiftServiceBean;
import java.util.List;

class GiftPkgSelectDialog$1$1
  implements Runnable
{
  GiftPkgSelectDialog$1$1(GiftPkgSelectDialog.1 param1, int paramInt) {}
  
  public void run()
  {
    try
    {
      GiftServiceBean localGiftServiceBean = (GiftServiceBean)GiftPkgSelectDialog.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewGiftPkgSelectDialog$1.a).get(this.jdField_a_of_type_Int);
      if (GiftPkgSelectDialog.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewGiftPkgSelectDialog$1.a) != null) {
        GiftPkgSelectDialog.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewGiftPkgSelectDialog$1.a).a(localGiftServiceBean);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewGiftPkgSelectDialog$1.a.dismiss();
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.GiftPkgSelectDialog.1.1
 * JD-Core Version:    0.7.0.1
 */