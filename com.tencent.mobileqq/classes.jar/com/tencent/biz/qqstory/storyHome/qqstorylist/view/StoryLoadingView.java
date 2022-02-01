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
    this.a.addFrame(getResources().getDrawable(2130846580), 50);
    this.a.addFrame(getResources().getDrawable(2130846581), 50);
    this.a.addFrame(getResources().getDrawable(2130846582), 50);
    this.a.addFrame(getResources().getDrawable(2130846583), 50);
    this.a.addFrame(getResources().getDrawable(2130846584), 50);
    this.a.addFrame(getResources().getDrawable(2130846585), 50);
    this.a.addFrame(getResources().getDrawable(2130846586), 50);
    this.a.addFrame(getResources().getDrawable(2130846587), 50);
    this.a.addFrame(getResources().getDrawable(2130846588), 50);
    this.a.addFrame(getResources().getDrawable(2130846589), 50);
    this.a.addFrame(getResources().getDrawable(2130846590), 50);
    this.a.addFrame(getResources().getDrawable(2130846591), 50);
    this.a.addFrame(getResources().getDrawable(2130846592), 50);
    this.a.addFrame(getResources().getDrawable(2130846593), 50);
    this.a.addFrame(getResources().getDrawable(2130846594), 50);
    this.a.addFrame(getResources().getDrawable(2130846595), 50);
    this.a.addFrame(getResources().getDrawable(2130846596), 50);
    this.a.addFrame(getResources().getDrawable(2130846597), 50);
    this.a.addFrame(getResources().getDrawable(2130846598), 50);
    this.a.addFrame(getResources().getDrawable(2130846599), 50);
    this.a.addFrame(getResources().getDrawable(2130846600), 50);
    this.a.addFrame(getResources().getDrawable(2130846601), 50);
    this.a.addFrame(getResources().getDrawable(2130846602), 50);
    this.a.addFrame(getResources().getDrawable(2130846603), 50);
    this.a.addFrame(getResources().getDrawable(2130846604), 50);
    this.a.addFrame(getResources().getDrawable(2130846605), 50);
    this.a.addFrame(getResources().getDrawable(2130846606), 50);
    this.a.addFrame(getResources().getDrawable(2130846607), 50);
    this.a.addFrame(getResources().getDrawable(2130846608), 50);
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