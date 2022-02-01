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
    this.a.addFrame(getResources().getDrawable(2130846484), 50);
    this.a.addFrame(getResources().getDrawable(2130846485), 50);
    this.a.addFrame(getResources().getDrawable(2130846486), 50);
    this.a.addFrame(getResources().getDrawable(2130846487), 50);
    this.a.addFrame(getResources().getDrawable(2130846488), 50);
    this.a.addFrame(getResources().getDrawable(2130846489), 50);
    this.a.addFrame(getResources().getDrawable(2130846490), 50);
    this.a.addFrame(getResources().getDrawable(2130846491), 50);
    this.a.addFrame(getResources().getDrawable(2130846492), 50);
    this.a.addFrame(getResources().getDrawable(2130846493), 50);
    this.a.addFrame(getResources().getDrawable(2130846494), 50);
    this.a.addFrame(getResources().getDrawable(2130846495), 50);
    this.a.addFrame(getResources().getDrawable(2130846496), 50);
    this.a.addFrame(getResources().getDrawable(2130846497), 50);
    this.a.addFrame(getResources().getDrawable(2130846498), 50);
    this.a.addFrame(getResources().getDrawable(2130846499), 50);
    this.a.addFrame(getResources().getDrawable(2130846500), 50);
    this.a.addFrame(getResources().getDrawable(2130846501), 50);
    this.a.addFrame(getResources().getDrawable(2130846502), 50);
    this.a.addFrame(getResources().getDrawable(2130846503), 50);
    this.a.addFrame(getResources().getDrawable(2130846504), 50);
    this.a.addFrame(getResources().getDrawable(2130846505), 50);
    this.a.addFrame(getResources().getDrawable(2130846506), 50);
    this.a.addFrame(getResources().getDrawable(2130846507), 50);
    this.a.addFrame(getResources().getDrawable(2130846508), 50);
    this.a.addFrame(getResources().getDrawable(2130846509), 50);
    this.a.addFrame(getResources().getDrawable(2130846510), 50);
    this.a.addFrame(getResources().getDrawable(2130846511), 50);
    this.a.addFrame(getResources().getDrawable(2130846512), 50);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.StoryLoadingView
 * JD-Core Version:    0.7.0.1
 */