package com.tencent.mobileqq.activity.home;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class Conversation$15
  implements View.OnClickListener
{
  Conversation$15(Conversation paramConversation) {}
  
  public void onClick(View paramView)
  {
    this.a.a.b.performClick();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.15
 * JD-Core Version:    0.7.0.1
 */