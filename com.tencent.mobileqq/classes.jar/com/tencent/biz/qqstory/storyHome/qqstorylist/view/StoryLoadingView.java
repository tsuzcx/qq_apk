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
    this.a.addFrame(getResources().getDrawable(2130846801), 50);
    this.a.addFrame(getResources().getDrawable(2130846802), 50);
    this.a.addFrame(getResources().getDrawable(2130846803), 50);
    this.a.addFrame(getResources().getDrawable(2130846804), 50);
    this.a.addFrame(getResources().getDrawable(2130846805), 50);
    this.a.addFrame(getResources().getDrawable(2130846806), 50);
    this.a.addFrame(getResources().getDrawable(2130846807), 50);
    this.a.addFrame(getResources().getDrawable(2130846808), 50);
    this.a.addFrame(getResources().getDrawable(2130846809), 50);
    this.a.addFrame(getResources().getDrawable(2130846810), 50);
    this.a.addFrame(getResources().getDrawable(2130846811), 50);
    this.a.addFrame(getResources().getDrawable(2130846812), 50);
    this.a.addFrame(getResources().getDrawable(2130846813), 50);
    this.a.addFrame(getResources().getDrawable(2130846814), 50);
    this.a.addFrame(getResources().getDrawable(2130846815), 50);
    this.a.addFrame(getResources().getDrawable(2130846816), 50);
    this.a.addFrame(getResources().getDrawable(2130846817), 50);
    this.a.addFrame(getResources().getDrawable(2130846818), 50);
    this.a.addFrame(getResources().getDrawable(2130846819), 50);
    this.a.addFrame(getResources().getDrawable(2130846820), 50);
    this.a.addFrame(getResources().getDrawable(2130846821), 50);
    this.a.addFrame(getResources().getDrawable(2130846822), 50);
    this.a.addFrame(getResources().getDrawable(2130846823), 50);
    this.a.addFrame(getResources().getDrawable(2130846824), 50);
    this.a.addFrame(getResources().getDrawable(2130846825), 50);
    this.a.addFrame(getResources().getDrawable(2130846826), 50);
    this.a.addFrame(getResources().getDrawable(2130846827), 50);
    this.a.addFrame(getResources().getDrawable(2130846828), 50);
    this.a.addFrame(getResources().getDrawable(2130846829), 50);
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