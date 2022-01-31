package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import java.util.Iterator;
import java.util.List;
import vvr;

class StoryPlayerGroupHolder$1
  implements Runnable
{
  StoryPlayerGroupHolder$1(StoryPlayerGroupHolder paramStoryPlayerGroupHolder) {}
  
  public void run()
  {
    StoryPlayerGroupHolder.a(this.this$0).a(this.this$0.a.c());
    Iterator localIterator = this.this$0.a.a().iterator();
    while (localIterator.hasNext()) {
      ((vvr)localIterator.next()).a(this.this$0.a.c());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder.1
 * JD-Core Version:    0.7.0.1
 */