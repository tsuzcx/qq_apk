package com.tencent.biz.qqstory.storyHome.memory.view;

import com.tencent.biz.qqstory.storyHome.memory.view.adapter.MemoriesInnerListAdapter;
import com.tencent.widget.HorizontalListView.OnScrollStateChangedListener;

class MemoriesInnerListView$1
  implements HorizontalListView.OnScrollStateChangedListener
{
  MemoriesInnerListView$1(MemoriesInnerListView paramMemoriesInnerListView) {}
  
  public void onScrollStateChanged(int paramInt)
  {
    if ((paramInt == 4097) && (this.a.a != null)) {
      this.a.a.a(MemoriesInnerListView.a(this.a).a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.memory.view.MemoriesInnerListView.1
 * JD-Core Version:    0.7.0.1
 */