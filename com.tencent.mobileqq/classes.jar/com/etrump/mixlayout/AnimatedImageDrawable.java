package com.etrump.mixlayout;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;

public class AnimatedImageDrawable
  extends AnimationDrawable
{
  private int a;
  private AnimatedImageDrawable.UpdateListener b;
  private View c;
  
  public void a()
  {
    this.a = ((this.a + 1) % getNumberOfFrames());
    AnimatedImageDrawable.UpdateListener localUpdateListener = this.b;
    if (localUpdateListener != null) {
      localUpdateListener.a(this.c);
    }
  }
  
  public int b()
  {
    return getDuration(this.a);
  }
  
  public Drawable c()
  {
    return getFrame(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.etrump.mixlayout.AnimatedImageDrawable
 * JD-Core Version:    0.7.0.1
 */