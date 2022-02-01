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
    this.b.findViewById(2131435465).setOnClickListener(this);
    this.b.findViewById(2131447249).setOnClickListener(this);
  }
  
  protected View a(ViewGroup paramViewGroup)
  {
    return paramViewGroup;
  }
  
  public void a(int paramInt1, int paramInt2, @NonNull StoryPlayerVideoData paramStoryPlayerVideoData, StoryPlayerGroupHolder paramStoryPlayerGroupHolder)
  {
    super.a(paramInt1, paramInt2, paramStoryPlayerVideoData, paramStoryPlayerGroupHolder);
    if (LiuHaiUtils.b)
    {
      paramStoryPlayerGroupHolder = (RelativeLayout.LayoutParams)this.b.findViewById(2131435465).getLayoutParams();
      paramStoryPlayerGroupHolder.topMargin = (UIUtils.a(this.b.getContext(), 5.0F) + 114);
      this.b.findViewById(2131435465).setLayoutParams(paramStoryPlayerGroupHolder);
    }
    j().a(this, paramInt1, paramInt2, paramStoryPlayerVideoData);
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    j().a(this, paramBoolean);
  }
  
  protected void d()
  {
    super.d();
    j().a(this);
  }
  
  public void onClick(View paramView)
  {
    j().a(this, paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.SelectVideoVideoHolder
 * JD-Core Version:    0.7.0.1
 */