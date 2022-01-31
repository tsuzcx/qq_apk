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
    this.a.addFrame(getResources().getDrawable(2130846120), 50);
    this.a.addFrame(getResources().getDrawable(2130846121), 50);
    this.a.addFrame(getResources().getDrawable(2130846122), 50);
    this.a.addFrame(getResources().getDrawable(2130846123), 50);
    this.a.addFrame(getResources().getDrawable(2130846124), 50);
    this.a.addFrame(getResources().getDrawable(2130846125), 50);
    this.a.addFrame(getResources().getDrawable(2130846126), 50);
    this.a.addFrame(getResources().getDrawable(2130846127), 50);
    this.a.addFrame(getResources().getDrawable(2130846128), 50);
    this.a.addFrame(getResources().getDrawable(2130846129), 50);
    this.a.addFrame(getResources().getDrawable(2130846130), 50);
    this.a.addFrame(getResources().getDrawable(2130846131), 50);
    this.a.addFrame(getResources().getDrawable(2130846132), 50);
    this.a.addFrame(getResources().getDrawable(2130846133), 50);
    this.a.addFrame(getResources().getDrawable(2130846134), 50);
    this.a.addFrame(getResources().getDrawable(2130846135), 50);
    this.a.addFrame(getResources().getDrawable(2130846136), 50);
    this.a.addFrame(getResources().getDrawable(2130846137), 50);
    this.a.addFrame(getResources().getDrawable(2130846138), 50);
    this.a.addFrame(getResources().getDrawable(2130846139), 50);
    this.a.addFrame(getResources().getDrawable(2130846140), 50);
    this.a.addFrame(getResources().getDrawable(2130846141), 50);
    this.a.addFrame(getResources().getDrawable(2130846142), 50);
    this.a.addFrame(getResources().getDrawable(2130846143), 50);
    this.a.addFrame(getResources().getDrawable(2130846144), 50);
    this.a.addFrame(getResources().getDrawable(2130846145), 50);
    this.a.addFrame(getResources().getDrawable(2130846146), 50);
    this.a.addFrame(getResources().getDrawable(2130846147), 50);
    this.a.addFrame(getResources().getDrawable(2130846148), 50);
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