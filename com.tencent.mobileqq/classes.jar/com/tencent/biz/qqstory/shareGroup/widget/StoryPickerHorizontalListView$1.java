package com.tencent.biz.qqstory.shareGroup.widget;

import com.tencent.widget.HorizontalListView.OnScrollStateChangedListener;

class StoryPickerHorizontalListView$1
  implements HorizontalListView.OnScrollStateChangedListener
{
  StoryPickerHorizontalListView$1(StoryPickerHorizontalListView paramStoryPickerHorizontalListView) {}
  
  public void onScrollStateChanged(int paramInt)
  {
    if ((paramInt == 4097) && (this.a.b != null)) {
      this.a.b.a(this.a.a.d);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.widget.StoryPickerHorizontalListView.1
 * JD-Core Version:    0.7.0.1
 */