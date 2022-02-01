package com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget;

import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.widget.HorizontalListView.OnItemScrollEventListener;

class StoryHomeHorizontalListView$1
  implements HorizontalListView.OnItemScrollEventListener
{
  StoryHomeHorizontalListView$1(StoryHomeHorizontalListView paramStoryHomeHorizontalListView) {}
  
  public void onItemScrollNonVisible(int paramInt, boolean paramBoolean)
  {
    if (StoryHomeHorizontalListView.a(this.a) != null) {
      StoryHomeHorizontalListView.a(this.a).onItemScrollNonVisible(paramInt, paramBoolean);
    }
    SLog.a("HorizontalListView", "on item scroll mHasMore=%b, mIsLoadingMore:%b", Boolean.valueOf(StoryHomeHorizontalListView.b(this.a)), Boolean.valueOf(StoryHomeHorizontalListView.c(this.a)));
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.StoryHomeHorizontalListView.1
 * JD-Core Version:    0.7.0.1
 */