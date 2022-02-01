package com.tencent.mobileqq.activity.aio.rebuild;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class PublicAccountChatPie$31
  implements View.OnClickListener
{
  PublicAccountChatPie$31(PublicAccountChatPie paramPublicAccountChatPie) {}
  
  public void onClick(View paramView)
  {
    paramView.setVisibility(8);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.31
 * JD-Core Version:    0.7.0.1
 */