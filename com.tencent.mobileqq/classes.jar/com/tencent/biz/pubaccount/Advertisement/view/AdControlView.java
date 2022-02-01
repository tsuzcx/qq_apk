package com.tencent.biz.pubaccount.Advertisement.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.RelativeLayout;

public class AdControlView
  extends RelativeLayout
{
  public boolean a = false;
  public boolean b = false;
  public boolean c = false;
  private View d;
  private View e;
  private View f;
  private View g;
  private View h;
  private AdvertisementSplitedProgressBar i;
  private ValueAnimator j;
  private int k = 1;
  
  public AdControlView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AdControlView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AdControlView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
    e();
  }
  
  private void a(Context paramContext)
  {
    LayoutInflater.from(getContext()).inflate(2131625167, this);
    this.d = findViewById(2131449502);
    this.e = findViewById(2131449773);
    this.f = findViewById(2131427732);
    this.g = findViewById(2131427742);
    this.h = findViewById(2131438862);
    this.i = ((AdvertisementSplitedProgressBar)findViewById(2131449723));
    this.d.setContentDescription(getResources().getString(2131887625));
    this.e.setContentDescription(getResources().getString(2131886193));
    this.f.setContentDescription(getResources().getString(2131886192));
    this.g.setContentDescription(getResources().getString(2131895019));
    this.h.setContentDescription(getResources().getString(2131886192));
  }
  
  private void e()
  {
    this.j = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F, 1.0F }).setDuration(1000L);
    this.j.setInterpolator(new DecelerateInterpolator());
    this.j.setRepeatCount(3);
    this.j.addUpdateListener(new AdControlView.1(this));
    this.j.addListener(new AdControlView.2(this));
  }
  
  public void a()
  {
    this.b = true;
    this.e.setVisibility(0);
    this.e.setBackgroundResource(2130842578);
    this.j.start();
    this.a = true;
  }
  
  public void b()
  {
    if ((this.b) || (this.j.isRunning()))
    {
      this.j.cancel();
      this.e.setAlpha(1.0F);
    }
  }
  
  public boolean c()
  {
    return this.a;
  }
  
  public void d()
  {
    this.a = false;
  }
  
  public View getAdMoreBtn()
  {
    return this.f;
  }
  
  public View getAdShareBtn()
  {
    return this.g;
  }
  
  public View getMoreBtn()
  {
    return this.h;
  }
  
  public AdvertisementSplitedProgressBar getSplitedProgressBar()
  {
    return this.i;
  }
  
  public View getVideoCloseBtn()
  {
    return this.d;
  }
  
  public View getVideoVolumeBtn()
  {
    return this.e;
  }
  
  public void setMode(int paramInt)
  {
    this.k = paramInt;
  }
  
  public void setVisibility(int paramInt)
  {
    if (paramInt == 0)
    {
      if (this.k == 2)
      {
        this.d.setVisibility(0);
        this.f.setVisibility(4);
        this.g.setVisibility(4);
        this.e.setVisibility(4);
        this.i.setVisibility(4);
        this.h.setVisibility(0);
      }
      else
      {
        this.d.setVisibility(0);
        this.f.setVisibility(0);
        this.g.setVisibility(0);
        this.h.setVisibility(4);
        this.e.setVisibility(0);
        this.i.setVisibility(0);
        super.setVisibility(paramInt);
      }
    }
    else if (paramInt == 4)
    {
      if (this.k == 2)
      {
        this.d.setVisibility(0);
        this.f.setVisibility(4);
        this.g.setVisibility(4);
        this.e.setVisibility(4);
        this.i.setVisibility(4);
        this.h.setVisibility(0);
      }
      else if (this.c)
      {
        this.d.setVisibility(0);
        this.f.setVisibility(0);
        this.g.setVisibility(0);
        this.e.setVisibility(0);
        this.i.setVisibility(0);
        this.h.setVisibility(4);
      }
      else
      {
        this.d.setVisibility(4);
        this.f.setVisibility(4);
        this.g.setVisibility(4);
        this.e.setVisibility(4);
        this.i.setVisibility(4);
        this.h.setVisibility(4);
      }
    }
    else {
      super.setVisibility(paramInt);
    }
    if (this.b) {
      this.e.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.view.AdControlView
 * JD-Core Version:    0.7.0.1
 */