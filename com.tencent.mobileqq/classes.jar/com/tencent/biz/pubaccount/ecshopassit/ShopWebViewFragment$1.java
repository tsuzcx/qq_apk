package com.tencent.biz.pubaccount.ecshopassit;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ShopWebViewFragment$1
  implements View.OnClickListener
{
  ShopWebViewFragment$1(ShopWebViewFragment paramShopWebViewFragment) {}
  
  public void onClick(View paramView)
  {
    if (this.a.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcshopCacheTool != null) {
      this.a.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcshopCacheTool.b(this.a.getQBaseActivity(), this.a.jdField_a_of_type_ArrayOfJavaLangString[0]);
    }
    try
    {
      this.a.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcshopCacheTool.a.a(134248548, null, null, null, null, 0L, false);
      label57:
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    catch (Exception localException)
    {
      break label57;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.ShopWebViewFragment.1
 * JD-Core Version:    0.7.0.1
 */