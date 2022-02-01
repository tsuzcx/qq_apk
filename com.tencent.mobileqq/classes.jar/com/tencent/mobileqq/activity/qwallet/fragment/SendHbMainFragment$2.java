package com.tencent.mobileqq.activity.qwallet.fragment;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.banner.TipsBar;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SendHbMainFragment$2
  implements View.OnClickListener
{
  SendHbMainFragment$2(SendHbMainFragment paramSendHbMainFragment, TipsBar paramTipsBar, SharedPreferences paramSharedPreferences, int paramInt) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqBannerTipsBar.setVisibility(8);
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("red_packet_bulletin", this.jdField_a_of_type_Int).apply();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.fragment.SendHbMainFragment.2
 * JD-Core Version:    0.7.0.1
 */