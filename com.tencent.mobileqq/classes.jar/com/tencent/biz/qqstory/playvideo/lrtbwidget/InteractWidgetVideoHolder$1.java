package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tribe.async.dispatch.Dispatcher;

class InteractWidgetVideoHolder$1
  extends SimpleActivityLifeCycle
{
  InteractWidgetVideoHolder$1(InteractWidgetVideoHolder paramInteractWidgetVideoHolder) {}
  
  public void g()
  {
    super.g();
    InteractWidgetVideoHolder.a(this.a, false);
    StoryDispatcher.a().unRegisterSubscriber(InteractWidgetVideoHolder.a(this.a));
    StoryDispatcher.a().unRegisterSubscriber(InteractWidgetVideoHolder.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.InteractWidgetVideoHolder.1
 * JD-Core Version:    0.7.0.1
 */