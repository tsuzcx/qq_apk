package com.tencent.biz.qqstory.storyHome.qqstorylist.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.biz.qqstory.view.widget.LoadMoreLayout;

public class StoryListLoadMoreView
  extends LoadMoreLayout
{
  public StoryListLoadMoreView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public StoryListLoadMoreView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public StoryListLoadMoreView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    if (this.d != null) {
      this.d.setTextColor(getResources().getColor(2131167993));
    }
  }
  
  public int getState()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.StoryListLoadMoreView
 * JD-Core Version:    0.7.0.1
 */