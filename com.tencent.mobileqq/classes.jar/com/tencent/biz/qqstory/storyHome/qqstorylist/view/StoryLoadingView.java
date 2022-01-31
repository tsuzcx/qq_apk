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
    this.a.addFrame(getResources().getDrawable(2130845662), 50);
    this.a.addFrame(getResources().getDrawable(2130845663), 50);
    this.a.addFrame(getResources().getDrawable(2130845664), 50);
    this.a.addFrame(getResources().getDrawable(2130845665), 50);
    this.a.addFrame(getResources().getDrawable(2130845666), 50);
    this.a.addFrame(getResources().getDrawable(2130845667), 50);
    this.a.addFrame(getResources().getDrawable(2130845668), 50);
    this.a.addFrame(getResources().getDrawable(2130845669), 50);
    this.a.addFrame(getResources().getDrawable(2130845670), 50);
    this.a.addFrame(getResources().getDrawable(2130845671), 50);
    this.a.addFrame(getResources().getDrawable(2130845672), 50);
    this.a.addFrame(getResources().getDrawable(2130845673), 50);
    this.a.addFrame(getResources().getDrawable(2130845674), 50);
    this.a.addFrame(getResources().getDrawable(2130845675), 50);
    this.a.addFrame(getResources().getDrawable(2130845676), 50);
    this.a.addFrame(getResources().getDrawable(2130845677), 50);
    this.a.addFrame(getResources().getDrawable(2130845678), 50);
    this.a.addFrame(getResources().getDrawable(2130845679), 50);
    this.a.addFrame(getResources().getDrawable(2130845680), 50);
    this.a.addFrame(getResources().getDrawable(2130845681), 50);
    this.a.addFrame(getResources().getDrawable(2130845682), 50);
    this.a.addFrame(getResources().getDrawable(2130845683), 50);
    this.a.addFrame(getResources().getDrawable(2130845684), 50);
    this.a.addFrame(getResources().getDrawable(2130845685), 50);
    this.a.addFrame(getResources().getDrawable(2130845686), 50);
    this.a.addFrame(getResources().getDrawable(2130845687), 50);
    this.a.addFrame(getResources().getDrawable(2130845688), 50);
    this.a.addFrame(getResources().getDrawable(2130845689), 50);
    this.a.addFrame(getResources().getDrawable(2130845690), 50);
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