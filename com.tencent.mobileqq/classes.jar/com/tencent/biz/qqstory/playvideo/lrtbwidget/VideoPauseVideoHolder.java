package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import android.view.View;
import android.view.ViewGroup;

public class VideoPauseVideoHolder
  extends VideoHolderBase
{
  public final View b;
  
  public VideoPauseVideoHolder(View paramView)
  {
    super((ViewGroup)paramView.getParent());
    this.b = paramView;
  }
  
  protected View a(ViewGroup paramViewGroup)
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoPauseVideoHolder
 * JD-Core Version:    0.7.0.1
 */