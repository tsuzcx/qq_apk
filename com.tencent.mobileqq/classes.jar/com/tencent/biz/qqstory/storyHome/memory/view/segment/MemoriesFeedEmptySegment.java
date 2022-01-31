package com.tencent.biz.qqstory.storyHome.memory.view.segment;

import android.content.Context;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.PlaceholderSegment;
import com.tencent.biz.qqstory.view.segment.SegmentList;
import com.tencent.biz.qqstory.view.segment.SegmentView;

public class MemoriesFeedEmptySegment
  extends PlaceholderSegment
{
  public MemoriesFeedEmptySegment(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    super(paramContext, paramString1, paramString2, paramInt1, paramInt2);
  }
  
  protected void F_()
  {
    SegmentView localSegmentView = a().a("FeedSegment");
    if ((localSegmentView != null) && (localSegmentView.a() == 0))
    {
      this.a = true;
      return;
    }
    this.a = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.memory.view.segment.MemoriesFeedEmptySegment
 * JD-Core Version:    0.7.0.1
 */