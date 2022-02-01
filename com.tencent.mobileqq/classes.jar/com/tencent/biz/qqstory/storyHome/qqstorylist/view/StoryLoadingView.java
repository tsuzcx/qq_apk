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
    this.a.addFrame(getResources().getDrawable(2130848353), 50);
    this.a.addFrame(getResources().getDrawable(2130848354), 50);
    this.a.addFrame(getResources().getDrawable(2130848355), 50);
    this.a.addFrame(getResources().getDrawable(2130848356), 50);
    this.a.addFrame(getResources().getDrawable(2130848357), 50);
    this.a.addFrame(getResources().getDrawable(2130848358), 50);
    this.a.addFrame(getResources().getDrawable(2130848359), 50);
    this.a.addFrame(getResources().getDrawable(2130848360), 50);
    this.a.addFrame(getResources().getDrawable(2130848361), 50);
    this.a.addFrame(getResources().getDrawable(2130848362), 50);
    this.a.addFrame(getResources().getDrawable(2130848363), 50);
    this.a.addFrame(getResources().getDrawable(2130848364), 50);
    this.a.addFrame(getResources().getDrawable(2130848365), 50);
    this.a.addFrame(getResources().getDrawable(2130848366), 50);
    this.a.addFrame(getResources().getDrawable(2130848367), 50);
    this.a.addFrame(getResources().getDrawable(2130848368), 50);
    this.a.addFrame(getResources().getDrawable(2130848369), 50);
    this.a.addFrame(getResources().getDrawable(2130848370), 50);
    this.a.addFrame(getResources().getDrawable(2130848371), 50);
    this.a.addFrame(getResources().getDrawable(2130848372), 50);
    this.a.addFrame(getResources().getDrawable(2130848373), 50);
    this.a.addFrame(getResources().getDrawable(2130848374), 50);
    this.a.addFrame(getResources().getDrawable(2130848375), 50);
    this.a.addFrame(getResources().getDrawable(2130848376), 50);
    this.a.addFrame(getResources().getDrawable(2130848377), 50);
    this.a.addFrame(getResources().getDrawable(2130848378), 50);
    this.a.addFrame(getResources().getDrawable(2130848379), 50);
    this.a.addFrame(getResources().getDrawable(2130848380), 50);
    this.a.addFrame(getResources().getDrawable(2130848381), 50);
    this.a.setOneShot(false);
    super.setImageDrawable(this.a);
    AnimationDrawable localAnimationDrawable = this.a;
    if ((localAnimationDrawable != null) && (!localAnimationDrawable.isRunning())) {
      this.a.start();
    }
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    if ((paramInt == 0) && (!this.a.isRunning()))
    {
      this.a.start();
      return;
    }
    if (this.a.isRunning()) {
      this.a.stop();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.StoryLoadingView
 * JD-Core Version:    0.7.0.1
 */