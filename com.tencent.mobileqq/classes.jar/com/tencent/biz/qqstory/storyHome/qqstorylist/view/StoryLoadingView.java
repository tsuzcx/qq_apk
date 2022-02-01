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
    this.a.addFrame(getResources().getDrawable(2130846559), 50);
    this.a.addFrame(getResources().getDrawable(2130846560), 50);
    this.a.addFrame(getResources().getDrawable(2130846561), 50);
    this.a.addFrame(getResources().getDrawable(2130846562), 50);
    this.a.addFrame(getResources().getDrawable(2130846563), 50);
    this.a.addFrame(getResources().getDrawable(2130846564), 50);
    this.a.addFrame(getResources().getDrawable(2130846565), 50);
    this.a.addFrame(getResources().getDrawable(2130846566), 50);
    this.a.addFrame(getResources().getDrawable(2130846567), 50);
    this.a.addFrame(getResources().getDrawable(2130846568), 50);
    this.a.addFrame(getResources().getDrawable(2130846569), 50);
    this.a.addFrame(getResources().getDrawable(2130846570), 50);
    this.a.addFrame(getResources().getDrawable(2130846571), 50);
    this.a.addFrame(getResources().getDrawable(2130846572), 50);
    this.a.addFrame(getResources().getDrawable(2130846573), 50);
    this.a.addFrame(getResources().getDrawable(2130846574), 50);
    this.a.addFrame(getResources().getDrawable(2130846575), 50);
    this.a.addFrame(getResources().getDrawable(2130846576), 50);
    this.a.addFrame(getResources().getDrawable(2130846577), 50);
    this.a.addFrame(getResources().getDrawable(2130846578), 50);
    this.a.addFrame(getResources().getDrawable(2130846579), 50);
    this.a.addFrame(getResources().getDrawable(2130846580), 50);
    this.a.addFrame(getResources().getDrawable(2130846581), 50);
    this.a.addFrame(getResources().getDrawable(2130846582), 50);
    this.a.addFrame(getResources().getDrawable(2130846583), 50);
    this.a.addFrame(getResources().getDrawable(2130846584), 50);
    this.a.addFrame(getResources().getDrawable(2130846585), 50);
    this.a.addFrame(getResources().getDrawable(2130846586), 50);
    this.a.addFrame(getResources().getDrawable(2130846587), 50);
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