package com.tencent.aelight.camera.aioeditor;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

public class SmartMusicAdapter$SmartMusicVH
  extends RecyclerView.ViewHolder
{
  private final View b;
  private ImageView c;
  private View d;
  private boolean e;
  
  public SmartMusicAdapter$SmartMusicVH(SmartMusicAdapter paramSmartMusicAdapter, View paramView)
  {
    super(paramView);
    this.c = ((ImageView)paramView.findViewById(2063991211));
    this.d = paramView.findViewById(2063991095);
    this.b = paramView.findViewById(2063991273);
  }
  
  private RotateAnimation e()
  {
    RotateAnimation localRotateAnimation = new RotateAnimation(0.0F, 360.0F, 1, 0.5F, 1, 0.5F);
    localRotateAnimation.setDuration(3000L);
    localRotateAnimation.setInterpolator(new LinearInterpolator());
    localRotateAnimation.setRepeatCount(-1);
    return localRotateAnimation;
  }
  
  public void a()
  {
    a(true);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.c.getVisibility() == 8) {
        this.c.setVisibility(0);
      }
      if (this.d.getVisibility() == 8) {
        this.d.setVisibility(0);
      }
    }
    else if (this.d.getVisibility() == 0)
    {
      this.d.setVisibility(8);
    }
  }
  
  public void b()
  {
    this.c.clearAnimation();
    this.e = false;
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.b.getVisibility() == 8) {
        this.b.setVisibility(0);
      }
    }
    else if (this.b.getVisibility() == 0) {
      this.b.setVisibility(8);
    }
  }
  
  public void c()
  {
    b(true);
  }
  
  public void d()
  {
    if (!this.e)
    {
      this.c.startAnimation(e());
      this.e = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.SmartMusicAdapter.SmartMusicVH
 * JD-Core Version:    0.7.0.1
 */