package com.tencent.biz.pubaccount;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.ui.MenuItem;
import com.tencent.mobileqq.mp.mobileqq_mp.ButtonInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class PublicAccountMenuBar$1
  implements View.OnClickListener
{
  PublicAccountMenuBar$1(PublicAccountMenuBar paramPublicAccountMenuBar, boolean paramBoolean, mobileqq_mp.ButtonInfo paramButtonInfo, MenuItem paramMenuItem) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Boolean) {
      PublicAccountMenuBar.a(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountMenuBar, this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$ButtonInfo);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      PublicAccountMenuBar.a(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountMenuBar, this.jdField_a_of_type_ComTencentBizUiMenuItem);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.PublicAccountMenuBar.1
 * JD-Core Version:    0.7.0.1
 */