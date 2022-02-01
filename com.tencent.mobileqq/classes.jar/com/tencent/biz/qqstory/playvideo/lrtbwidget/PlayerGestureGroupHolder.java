package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.BetterGestureDetector;

public class PlayerGestureGroupHolder
  extends GroupHolderBase
{
  public ImageView i;
  private PlayerGestureGroupHolder.OnViewPagerGestureListener j;
  private BetterGestureDetector k;
  private boolean l = false;
  
  public PlayerGestureGroupHolder(@NonNull ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
  }
  
  protected View a(ViewGroup paramViewGroup)
  {
    return paramViewGroup;
  }
  
  public void a(int paramInt)
  {
    SLog.b(this.a, "setVisibility ignore");
  }
  
  protected void e()
  {
    super.e();
    this.i = ((ImageView)this.b.findViewById(2131449661));
    ((StoryPlayerGroupHolder)d()).j.setOnTouchListener(new PlayerGestureGroupHolder.ViewPagerTouchListener(this, null));
    this.j = new PlayerGestureGroupHolder.OnViewPagerGestureListener(this, null);
    this.k = new BetterGestureDetector(a(), this.j);
    this.k.a(50);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.PlayerGestureGroupHolder
 * JD-Core Version:    0.7.0.1
 */