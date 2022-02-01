package com.tencent.biz.qqstory.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class StoryImageDialog$3
  implements View.OnClickListener
{
  StoryImageDialog$3(StoryImageDialog paramStoryImageDialog) {}
  
  public void onClick(View paramView)
  {
    this.a.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.StoryImageDialog.3
 * JD-Core Version:    0.7.0.1
 */