package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import java.util.Iterator;
import java.util.List;

class StoryPlayerGroupHolder$1
  implements Runnable
{
  StoryPlayerGroupHolder$1(StoryPlayerGroupHolder paramStoryPlayerGroupHolder) {}
  
  public void run()
  {
    StoryPlayerGroupHolder.a(this.this$0).a(this.this$0.j.getCurrentItem());
    Iterator localIterator = this.this$0.j.getOnPageChangeListeners().iterator();
    while (localIterator.hasNext()) {
      ((XViewPager.OnPageChangeListener)localIterator.next()).a(this.this$0.j.getCurrentItem());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder.1
 * JD-Core Version:    0.7.0.1
 */