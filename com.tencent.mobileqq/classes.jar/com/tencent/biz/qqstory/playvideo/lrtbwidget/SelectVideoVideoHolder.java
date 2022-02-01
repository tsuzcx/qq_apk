package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import android.support.annotation.NonNull;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.LiuHaiUtils;

public class SelectVideoVideoHolder
  extends VideoHolderBase
  implements View.OnClickListener
{
  public SelectVideoVideoHolder(@NonNull ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
    this.a.findViewById(2131368559).setOnClickListener(this);
    this.a.findViewById(2131378618).setOnClickListener(this);
  }
  
  protected View a(ViewGroup paramViewGroup)
  {
    return paramViewGroup;
  }
  
  public void a(int paramInt1, int paramInt2, @NonNull StoryPlayerVideoData paramStoryPlayerVideoData, StoryPlayerGroupHolder paramStoryPlayerGroupHolder)
  {
    super.a(paramInt1, paramInt2, paramStoryPlayerVideoData, paramStoryPlayerGroupHolder);
    if (LiuHaiUtils.a)
    {
      paramStoryPlayerGroupHolder = (RelativeLayout.LayoutParams)this.a.findViewById(2131368559).getLayoutParams();
      paramStoryPlayerGroupHolder.topMargin = (UIUtils.a(this.a.getContext(), 5.0F) + 114);
      this.a.findViewById(2131368559).setLayoutParams(paramStoryPlayerGroupHolder);
    }
    a().a(this, paramInt1, paramInt2, paramStoryPlayerVideoData);
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    a().a(this, paramBoolean);
  }
  
  protected void b()
  {
    super.b();
    a().a(this);
  }
  
  public void onClick(View paramView)
  {
    a().a(this, paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.SelectVideoVideoHolder
 * JD-Core Version:    0.7.0.1
 */