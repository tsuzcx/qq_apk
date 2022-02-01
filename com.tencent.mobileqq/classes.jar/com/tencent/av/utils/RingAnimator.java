package com.tencent.av.utils;

import android.content.Context;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;

public class RingAnimator
{
  ImageView a;
  ImageView b;
  ImageView c;
  Animation d;
  Animation e;
  Animation f;
  Animation.AnimationListener g;
  Animation.AnimationListener h;
  Handler i;
  Context j;
  public boolean k;
  
  public void a()
  {
    c();
    e();
    this.a = null;
    this.b = null;
    this.c = null;
    this.d = null;
    this.e = null;
    this.f = null;
    this.g = null;
    this.h = null;
    this.i = null;
    this.j = null;
  }
  
  public void b()
  {
    ImageView localImageView = this.a;
    if (localImageView != null) {
      localImageView.startAnimation(this.d);
    }
  }
  
  public void c()
  {
    ImageView localImageView = this.a;
    if (localImageView != null)
    {
      localImageView.setVisibility(8);
      this.a.clearAnimation();
    }
  }
  
  public void d()
  {
    this.k = true;
    if ((this.b != null) && (this.c != null)) {
      this.i.sendEmptyMessage(9);
    }
  }
  
  public void e()
  {
    this.k = false;
    this.i.sendEmptyMessage(10);
    ImageView localImageView = this.b;
    if ((localImageView != null) && (this.c != null))
    {
      localImageView.clearAnimation();
      this.c.clearAnimation();
      this.b.setVisibility(8);
      this.c.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.RingAnimator
 * JD-Core Version:    0.7.0.1
 */