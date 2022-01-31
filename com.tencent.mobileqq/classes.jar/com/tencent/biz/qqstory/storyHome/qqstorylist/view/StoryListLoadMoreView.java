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
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131101260));
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.StoryListLoadMoreView
 * JD-Core Version:    0.7.0.1
 */