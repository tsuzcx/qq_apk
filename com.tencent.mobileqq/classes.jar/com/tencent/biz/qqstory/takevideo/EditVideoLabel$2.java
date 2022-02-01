package com.tencent.biz.qqstory.takevideo;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class EditVideoLabel$2
  implements View.OnClickListener
{
  EditVideoLabel$2(EditVideoLabel paramEditVideoLabel) {}
  
  public void onClick(View paramView)
  {
    this.a.a.a(0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditVideoLabel.2
 * JD-Core Version:    0.7.0.1
 */