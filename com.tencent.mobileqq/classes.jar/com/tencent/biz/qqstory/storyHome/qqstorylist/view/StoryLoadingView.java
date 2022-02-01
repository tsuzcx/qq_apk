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
    this.a.addFrame(getResources().getDrawable(2130846923), 50);
    this.a.addFrame(getResources().getDrawable(2130846924), 50);
    this.a.addFrame(getResources().getDrawable(2130846925), 50);
    this.a.addFrame(getResources().getDrawable(2130846926), 50);
    this.a.addFrame(getResources().getDrawable(2130846927), 50);
    this.a.addFrame(getResources().getDrawable(2130846928), 50);
    this.a.addFrame(getResources().getDrawable(2130846929), 50);
    this.a.addFrame(getResources().getDrawable(2130846930), 50);
    this.a.addFrame(getResources().getDrawable(2130846931), 50);
    this.a.addFrame(getResources().getDrawable(2130846932), 50);
    this.a.addFrame(getResources().getDrawable(2130846933), 50);
    this.a.addFrame(getResources().getDrawable(2130846934), 50);
    this.a.addFrame(getResources().getDrawable(2130846935), 50);
    this.a.addFrame(getResources().getDrawable(2130846936), 50);
    this.a.addFrame(getResources().getDrawable(2130846937), 50);
    this.a.addFrame(getResources().getDrawable(2130846938), 50);
    this.a.addFrame(getResources().getDrawable(2130846939), 50);
    this.a.addFrame(getResources().getDrawable(2130846940), 50);
    this.a.addFrame(getResources().getDrawable(2130846941), 50);
    this.a.addFrame(getResources().getDrawable(2130846942), 50);
    this.a.addFrame(getResources().getDrawable(2130846943), 50);
    this.a.addFrame(getResources().getDrawable(2130846944), 50);
    this.a.addFrame(getResources().getDrawable(2130846945), 50);
    this.a.addFrame(getResources().getDrawable(2130846946), 50);
    this.a.addFrame(getResources().getDrawable(2130846947), 50);
    this.a.addFrame(getResources().getDrawable(2130846948), 50);
    this.a.addFrame(getResources().getDrawable(2130846949), 50);
    this.a.addFrame(getResources().getDrawable(2130846950), 50);
    this.a.addFrame(getResources().getDrawable(2130846951), 50);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.StoryLoadingView
 * JD-Core Version:    0.7.0.1
 */