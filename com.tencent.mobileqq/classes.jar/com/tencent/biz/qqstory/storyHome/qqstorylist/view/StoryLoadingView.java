package com.tencent.biz.qqstory.storyHome.qqstorylist.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;

public class StoryLoadingView
  extends ImageView
{
  protected AnimationDrawable a;
  
  public StoryLoadingView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public StoryLoadingView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public StoryLoadingView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    this.a = new AnimationDrawable();
    this.a.addFrame(getResources().getDrawable(2130843550), 50);
    this.a.addFrame(getResources().getDrawable(2130843551), 50);
    this.a.addFrame(getResources().getDrawable(2130843552), 50);
    this.a.addFrame(getResources().getDrawable(2130843553), 50);
    this.a.addFrame(getResources().getDrawable(2130843554), 50);
    this.a.addFrame(getResources().getDrawable(2130843555), 50);
    this.a.addFrame(getResources().getDrawable(2130843556), 50);
    this.a.addFrame(getResources().getDrawable(2130843557), 50);
    this.a.addFrame(getResources().getDrawable(2130843558), 50);
    this.a.addFrame(getResources().getDrawable(2130843559), 50);
    this.a.addFrame(getResources().getDrawable(2130843560), 50);
    this.a.addFrame(getResources().getDrawable(2130843561), 50);
    this.a.addFrame(getResources().getDrawable(2130843562), 50);
    this.a.addFrame(getResources().getDrawable(2130843563), 50);
    this.a.addFrame(getResources().getDrawable(2130843564), 50);
    this.a.addFrame(getResources().getDrawable(2130843565), 50);
    this.a.addFrame(getResources().getDrawable(2130843566), 50);
    this.a.addFrame(getResources().getDrawable(2130843567), 50);
    this.a.addFrame(getResources().getDrawable(2130843568), 50);
    this.a.addFrame(getResources().getDrawable(2130843569), 50);
    this.a.addFrame(getResources().getDrawable(2130843570), 50);
    this.a.addFrame(getResources().getDrawable(2130843571), 50);
    this.a.addFrame(getResources().getDrawable(2130843572), 50);
    this.a.addFrame(getResources().getDrawable(2130843573), 50);
    this.a.addFrame(getResources().getDrawable(2130843574), 50);
    this.a.addFrame(getResources().getDrawable(2130843575), 50);
    this.a.addFrame(getResources().getDrawable(2130843576), 50);
    this.a.addFrame(getResources().getDrawable(2130843577), 50);
    this.a.addFrame(getResources().getDrawable(2130843578), 50);
    this.a.setOneShot(false);
    super.setImageDrawable(this.a);
    if ((this.a != null) && (!this.a.isRunning())) {
      this.a.start();
    }
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    if ((paramInt == 0) && (!this.a.isRunning())) {
      this.a.start();
    }
    while (!this.a.isRunning()) {
      return;
    }
    this.a.stop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.StoryLoadingView
 * JD-Core Version:    0.7.0.1
 */