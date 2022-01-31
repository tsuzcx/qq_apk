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
    this.a.addFrame(getResources().getDrawable(2130843397), 50);
    this.a.addFrame(getResources().getDrawable(2130843398), 50);
    this.a.addFrame(getResources().getDrawable(2130843399), 50);
    this.a.addFrame(getResources().getDrawable(2130843400), 50);
    this.a.addFrame(getResources().getDrawable(2130843401), 50);
    this.a.addFrame(getResources().getDrawable(2130843402), 50);
    this.a.addFrame(getResources().getDrawable(2130843403), 50);
    this.a.addFrame(getResources().getDrawable(2130843404), 50);
    this.a.addFrame(getResources().getDrawable(2130843405), 50);
    this.a.addFrame(getResources().getDrawable(2130843406), 50);
    this.a.addFrame(getResources().getDrawable(2130843407), 50);
    this.a.addFrame(getResources().getDrawable(2130843408), 50);
    this.a.addFrame(getResources().getDrawable(2130843409), 50);
    this.a.addFrame(getResources().getDrawable(2130843410), 50);
    this.a.addFrame(getResources().getDrawable(2130843411), 50);
    this.a.addFrame(getResources().getDrawable(2130843412), 50);
    this.a.addFrame(getResources().getDrawable(2130843413), 50);
    this.a.addFrame(getResources().getDrawable(2130843414), 50);
    this.a.addFrame(getResources().getDrawable(2130843415), 50);
    this.a.addFrame(getResources().getDrawable(2130843416), 50);
    this.a.addFrame(getResources().getDrawable(2130843417), 50);
    this.a.addFrame(getResources().getDrawable(2130843418), 50);
    this.a.addFrame(getResources().getDrawable(2130843419), 50);
    this.a.addFrame(getResources().getDrawable(2130843420), 50);
    this.a.addFrame(getResources().getDrawable(2130843421), 50);
    this.a.addFrame(getResources().getDrawable(2130843422), 50);
    this.a.addFrame(getResources().getDrawable(2130843423), 50);
    this.a.addFrame(getResources().getDrawable(2130843424), 50);
    this.a.addFrame(getResources().getDrawable(2130843425), 50);
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