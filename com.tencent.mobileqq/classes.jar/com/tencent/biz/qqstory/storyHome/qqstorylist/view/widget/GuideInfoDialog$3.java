package com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class GuideInfoDialog$3
  implements View.OnClickListener
{
  GuideInfoDialog$3(GuideInfoDialog paramGuideInfoDialog) {}
  
  public void onClick(View paramView)
  {
    this.a.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.GuideInfoDialog.3
 * JD-Core Version:    0.7.0.1
 */