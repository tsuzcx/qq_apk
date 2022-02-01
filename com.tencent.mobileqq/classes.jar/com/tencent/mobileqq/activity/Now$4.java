package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.MystoryListView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class Now$4
  implements View.OnClickListener
{
  Now$4(Now paramNow) {}
  
  public void onClick(View paramView)
  {
    if (Now.a(this.a) != null) {
      Now.a(this.a).m();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Now.4
 * JD-Core Version:    0.7.0.1
 */