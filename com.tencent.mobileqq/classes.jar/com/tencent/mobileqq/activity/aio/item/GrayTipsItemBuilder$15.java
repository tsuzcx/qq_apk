package com.tencent.mobileqq.activity.aio.item;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.activity.ScoreQAVFragment;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class GrayTipsItemBuilder$15
  implements View.OnClickListener
{
  GrayTipsItemBuilder$15(GrayTipsItemBuilder paramGrayTipsItemBuilder, long paramLong) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("uinType", this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.a.a);
    localIntent.putExtra("uniseq", this.jdField_a_of_type_Long);
    localIntent.putExtra("public_fragment_window_feature", 1);
    PublicFragmentActivity.Launcher.a(paramView.getContext(), localIntent, PublicTransFragmentActivity.class, ScoreQAVFragment.class);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.GrayTipsItemBuilder.15
 * JD-Core Version:    0.7.0.1
 */