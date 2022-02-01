package com.tencent.mobileqq.activity.aio.rebuild;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class PublicAccountChatPie$51
  implements View.OnClickListener
{
  PublicAccountChatPie$51(PublicAccountChatPie paramPublicAccountChatPie, RelativeLayout paramRelativeLayout, LinearLayout paramLinearLayout) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.51
 * JD-Core Version:    0.7.0.1
 */