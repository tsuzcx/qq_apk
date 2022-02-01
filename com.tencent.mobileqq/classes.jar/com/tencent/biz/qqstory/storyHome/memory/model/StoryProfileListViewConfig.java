package com.tencent.biz.qqstory.storyHome.memory.model;

import android.app.Activity;
import android.content.res.Resources;
import com.tencent.biz.qqstory.storyHome.memory.view.segment.MemoriesFeedEmptySegment;
import com.tencent.biz.qqstory.storyHome.memory.view.segment.MemoriesFeedSegment;
import com.tencent.biz.qqstory.storyHome.memory.view.segment.MemoriesProfileSegment;
import com.tencent.biz.qqstory.storyHome.memory.view.segment.MemoriesVideoListEmptySegment;
import com.tencent.biz.qqstory.storyHome.memory.view.segment.MemoriesVideoListSegment;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.IMyStoryListView;
import com.tencent.biz.qqstory.view.segment.SegmentView;
import java.util.ArrayList;
import java.util.List;

public class StoryProfileListViewConfig
{
  public static int a = 1;
  public static int b = 2;
  public int c;
  public Activity d;
  public int e;
  public String f;
  public IMyStoryListView g;
  private List<SegmentView> h = new ArrayList();
  
  public StoryProfileListViewConfig(Activity paramActivity, int paramInt1, String paramString, int paramInt2, IMyStoryListView paramIMyStoryListView)
  {
    this.d = paramActivity;
    this.e = paramInt1;
    this.f = paramString;
    this.c = paramInt2;
    this.g = paramIMyStoryListView;
    if (paramInt2 == a)
    {
      b();
      return;
    }
    if (paramInt2 == b)
    {
      c();
      return;
    }
    throw new IllegalStateException("setup profile list error because unknown list type.");
  }
  
  private void b()
  {
    this.h.add(new MemoriesProfileSegment(this.d, this.e, this.f));
    this.h.add(new MemoriesFeedSegment(this.d.getApplicationContext(), this.d, 12, this.g, false));
    List localList = this.h;
    Activity localActivity = this.d;
    localList.add(new MemoriesFeedEmptySegment(localActivity, "FeedSegment", localActivity.getResources().getString(2131897965), 2130848389, 2130848390));
  }
  
  private void c()
  {
    this.h.add(new MemoriesProfileSegment(this.d, this.e, this.f));
    this.h.add(new MemoriesVideoListSegment(this.d, this.e, this.f));
    this.h.add(new MemoriesVideoListEmptySegment(this.d, this.e, this.f));
  }
  
  public List<SegmentView> a()
  {
    return this.h;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.memory.model.StoryProfileListViewConfig
 * JD-Core Version:    0.7.0.1
 */