package com.tencent.biz.qqstory.storyHome.memory.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import com.tencent.biz.qqstory.view.segment.SegmentList;
import xmc;

public class StoryMemoriesReloadListView
  extends SegmentList
{
  private Activity a;
  
  public StoryMemoriesReloadListView(Context paramContext)
  {
    super(paramContext);
  }
  
  public StoryMemoriesReloadListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public StoryMemoriesReloadListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a()
  {
    a(new xmc(this.a));
    super.setDivider(null);
    super.setVerticalScrollBarEnabled(false);
    super.setHorizontalScrollBarEnabled(false);
    super.setBackgroundColor(-1);
  }
  
  public void a(Activity paramActivity)
  {
    this.a = paramActivity;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.memory.view.StoryMemoriesReloadListView
 * JD-Core Version:    0.7.0.1
 */