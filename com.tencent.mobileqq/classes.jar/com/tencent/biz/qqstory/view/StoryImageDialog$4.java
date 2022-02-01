package com.tencent.biz.qqstory.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class StoryImageDialog$4
  implements View.OnClickListener
{
  StoryImageDialog$4(StoryImageDialog paramStoryImageDialog) {}
  
  public void onClick(View paramView)
  {
    StoryReportor.a("home_page", "guide_close", 0, 0, new String[0]);
    this.a.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.StoryImageDialog.4
 * JD-Core Version:    0.7.0.1
 */