package com.tencent.biz.qqstory.storyHome.memory.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public class MemoriesRelativeLayout
  extends RelativeLayout
{
  public MemoriesRelativeLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public MemoriesRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public MemoriesRelativeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected boolean fitSystemWindows(Rect paramRect)
  {
    paramRect.top = 0;
    return super.fitSystemWindows(paramRect);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.memory.view.MemoriesRelativeLayout
 * JD-Core Version:    0.7.0.1
 */