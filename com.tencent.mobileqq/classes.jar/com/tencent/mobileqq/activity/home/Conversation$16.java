package com.tencent.mobileqq.activity.home;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.widget.imageview.CircleBoarderImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class Conversation$16
  implements View.OnClickListener
{
  Conversation$16(Conversation paramConversation) {}
  
  public void onClick(View paramView)
  {
    this.a.Y.ac.performClick();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.16
 * JD-Core Version:    0.7.0.1
 */