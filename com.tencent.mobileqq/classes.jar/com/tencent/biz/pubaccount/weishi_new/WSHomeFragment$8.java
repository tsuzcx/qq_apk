package com.tencent.biz.pubaccount.weishi_new;

import UserGrowth.stTabInfo;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.weishi_new.view.tabLayout.WSTabUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class WSHomeFragment$8
  implements View.OnClickListener
{
  WSHomeFragment$8(WSHomeFragment paramWSHomeFragment, stTabInfo paramstTabInfo) {}
  
  public void onClick(View paramView)
  {
    WSTabUtils.a(WSHomeFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSHomeFragment), this.jdField_a_of_type_UserGrowthStTabInfo, WSHomeFragment.a, WSHomeFragment.b(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSHomeFragment));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WSHomeFragment.8
 * JD-Core Version:    0.7.0.1
 */