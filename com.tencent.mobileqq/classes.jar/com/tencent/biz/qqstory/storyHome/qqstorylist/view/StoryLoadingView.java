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
    this.a.addFrame(getResources().getDrawable(2130846047), 50);
    this.a.addFrame(getResources().getDrawable(2130846048), 50);
    this.a.addFrame(getResources().getDrawable(2130846049), 50);
    this.a.addFrame(getResources().getDrawable(2130846050), 50);
    this.a.addFrame(getResources().getDrawable(2130846051), 50);
    this.a.addFrame(getResources().getDrawable(2130846052), 50);
    this.a.addFrame(getResources().getDrawable(2130846053), 50);
    this.a.addFrame(getResources().getDrawable(2130846054), 50);
    this.a.addFrame(getResources().getDrawable(2130846055), 50);
    this.a.addFrame(getResources().getDrawable(2130846056), 50);
    this.a.addFrame(getResources().getDrawable(2130846057), 50);
    this.a.addFrame(getResources().getDrawable(2130846058), 50);
    this.a.addFrame(getResources().getDrawable(2130846059), 50);
    this.a.addFrame(getResources().getDrawable(2130846060), 50);
    this.a.addFrame(getResources().getDrawable(2130846061), 50);
    this.a.addFrame(getResources().getDrawable(2130846062), 50);
    this.a.addFrame(getResources().getDrawable(2130846063), 50);
    this.a.addFrame(getResources().getDrawable(2130846064), 50);
    this.a.addFrame(getResources().getDrawable(2130846065), 50);
    this.a.addFrame(getResources().getDrawable(2130846066), 50);
    this.a.addFrame(getResources().getDrawable(2130846067), 50);
    this.a.addFrame(getResources().getDrawable(2130846068), 50);
    this.a.addFrame(getResources().getDrawable(2130846069), 50);
    this.a.addFrame(getResources().getDrawable(2130846070), 50);
    this.a.addFrame(getResources().getDrawable(2130846071), 50);
    this.a.addFrame(getResources().getDrawable(2130846072), 50);
    this.a.addFrame(getResources().getDrawable(2130846073), 50);
    this.a.addFrame(getResources().getDrawable(2130846074), 50);
    this.a.addFrame(getResources().getDrawable(2130846075), 50);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.StoryLoadingView
 * JD-Core Version:    0.7.0.1
 */