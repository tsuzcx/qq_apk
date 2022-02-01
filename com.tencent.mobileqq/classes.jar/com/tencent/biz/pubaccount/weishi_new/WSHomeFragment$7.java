package com.tencent.biz.pubaccount.weishi_new;

import UserGrowth.stPublisherRsp;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class WSHomeFragment$7
  implements View.OnClickListener
{
  WSHomeFragment$7(WSHomeFragment paramWSHomeFragment, stPublisherRsp paramstPublisherRsp) {}
  
  public void onClick(View paramView)
  {
    WSHomeFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSHomeFragment, this.jdField_a_of_type_UserGrowthStPublisherRsp);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WSHomeFragment.7
 * JD-Core Version:    0.7.0.1
 */