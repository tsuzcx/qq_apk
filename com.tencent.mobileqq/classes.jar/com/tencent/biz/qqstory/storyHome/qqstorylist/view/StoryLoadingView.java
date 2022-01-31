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
    this.a.addFrame(getResources().getDrawable(2130843517), 50);
    this.a.addFrame(getResources().getDrawable(2130843518), 50);
    this.a.addFrame(getResources().getDrawable(2130843519), 50);
    this.a.addFrame(getResources().getDrawable(2130843520), 50);
    this.a.addFrame(getResources().getDrawable(2130843521), 50);
    this.a.addFrame(getResources().getDrawable(2130843522), 50);
    this.a.addFrame(getResources().getDrawable(2130843523), 50);
    this.a.addFrame(getResources().getDrawable(2130843524), 50);
    this.a.addFrame(getResources().getDrawable(2130843525), 50);
    this.a.addFrame(getResources().getDrawable(2130843526), 50);
    this.a.addFrame(getResources().getDrawable(2130843527), 50);
    this.a.addFrame(getResources().getDrawable(2130843528), 50);
    this.a.addFrame(getResources().getDrawable(2130843529), 50);
    this.a.addFrame(getResources().getDrawable(2130843530), 50);
    this.a.addFrame(getResources().getDrawable(2130843531), 50);
    this.a.addFrame(getResources().getDrawable(2130843532), 50);
    this.a.addFrame(getResources().getDrawable(2130843533), 50);
    this.a.addFrame(getResources().getDrawable(2130843534), 50);
    this.a.addFrame(getResources().getDrawable(2130843535), 50);
    this.a.addFrame(getResources().getDrawable(2130843536), 50);
    this.a.addFrame(getResources().getDrawable(2130843537), 50);
    this.a.addFrame(getResources().getDrawable(2130843538), 50);
    this.a.addFrame(getResources().getDrawable(2130843539), 50);
    this.a.addFrame(getResources().getDrawable(2130843540), 50);
    this.a.addFrame(getResources().getDrawable(2130843541), 50);
    this.a.addFrame(getResources().getDrawable(2130843542), 50);
    this.a.addFrame(getResources().getDrawable(2130843543), 50);
    this.a.addFrame(getResources().getDrawable(2130843544), 50);
    this.a.addFrame(getResources().getDrawable(2130843545), 50);
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