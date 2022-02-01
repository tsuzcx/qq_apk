package com.tencent.biz.qqstory.comment;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class StoryInputBarView$4
  implements View.OnClickListener
{
  StoryInputBarView$4(EditText paramEditText) {}
  
  public void onClick(View paramView)
  {
    this.a.append("@");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.comment.StoryInputBarView.4
 * JD-Core Version:    0.7.0.1
 */