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
    this.a.addFrame(getResources().getDrawable(2130845479), 50);
    this.a.addFrame(getResources().getDrawable(2130845480), 50);
    this.a.addFrame(getResources().getDrawable(2130845481), 50);
    this.a.addFrame(getResources().getDrawable(2130845482), 50);
    this.a.addFrame(getResources().getDrawable(2130845483), 50);
    this.a.addFrame(getResources().getDrawable(2130845484), 50);
    this.a.addFrame(getResources().getDrawable(2130845485), 50);
    this.a.addFrame(getResources().getDrawable(2130845486), 50);
    this.a.addFrame(getResources().getDrawable(2130845487), 50);
    this.a.addFrame(getResources().getDrawable(2130845488), 50);
    this.a.addFrame(getResources().getDrawable(2130845489), 50);
    this.a.addFrame(getResources().getDrawable(2130845490), 50);
    this.a.addFrame(getResources().getDrawable(2130845491), 50);
    this.a.addFrame(getResources().getDrawable(2130845492), 50);
    this.a.addFrame(getResources().getDrawable(2130845493), 50);
    this.a.addFrame(getResources().getDrawable(2130845494), 50);
    this.a.addFrame(getResources().getDrawable(2130845495), 50);
    this.a.addFrame(getResources().getDrawable(2130845496), 50);
    this.a.addFrame(getResources().getDrawable(2130845497), 50);
    this.a.addFrame(getResources().getDrawable(2130845498), 50);
    this.a.addFrame(getResources().getDrawable(2130845499), 50);
    this.a.addFrame(getResources().getDrawable(2130845500), 50);
    this.a.addFrame(getResources().getDrawable(2130845501), 50);
    this.a.addFrame(getResources().getDrawable(2130845502), 50);
    this.a.addFrame(getResources().getDrawable(2130845503), 50);
    this.a.addFrame(getResources().getDrawable(2130845504), 50);
    this.a.addFrame(getResources().getDrawable(2130845505), 50);
    this.a.addFrame(getResources().getDrawable(2130845506), 50);
    this.a.addFrame(getResources().getDrawable(2130845507), 50);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.StoryLoadingView
 * JD-Core Version:    0.7.0.1
 */