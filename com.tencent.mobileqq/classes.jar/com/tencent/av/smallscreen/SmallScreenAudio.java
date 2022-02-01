package com.tencent.av.smallscreen;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

public class SmallScreenAudio
  extends SmallScreenItemBase
{
  protected TextView a = null;
  protected ImageView b = null;
  protected View c = null;
  protected int d;
  protected int e;
  protected int f;
  protected int g;
  protected int h;
  protected int i;
  protected int j;
  protected int k;
  
  public SmallScreenAudio(Context paramContext)
  {
    this.l = "SmallScreenAudio";
    paramContext = paramContext.getResources();
    this.o = 2013396993;
    this.p = paramContext.getDimensionPixelSize(2131298631);
    this.q = paramContext.getDimensionPixelSize(2131298625);
    this.d = paramContext.getDimensionPixelSize(2131298632);
    this.e = paramContext.getDimensionPixelSize(2131298626);
    this.f = paramContext.getDimensionPixelSize(2131298627);
    this.g = paramContext.getDimensionPixelSize(2131298629);
    this.h = paramContext.getDimensionPixelSize(2131298628);
    this.i = paramContext.getDimensionPixelSize(2131298630);
    this.j = paramContext.getDimensionPixelSize(2131298623);
    this.k = paramContext.getDimensionPixelSize(2131298624);
  }
  
  public void a(Context paramContext, LayoutInflater paramLayoutInflater, SmallScreenRelativeLayout.FloatListener paramFloatListener)
  {
    super.a(paramContext, paramLayoutInflater, paramFloatListener);
    paramContext = paramContext.getResources();
    this.m.setTitleHeight(paramContext.getDimensionPixelSize(2131299920) * 5 / 2);
    this.a = ((TextView)this.m.findViewById(2013331469));
    this.b = ((ImageView)this.m.findViewById(2013331464));
    this.b.setImageResource(2130843285);
    paramContext = this.b.getDrawable();
    if ((paramContext instanceof AnimationDrawable)) {
      ((AnimationDrawable)paramContext).start();
    }
    this.c = this.m.findViewById(2013331462);
  }
  
  public void a(BaseSmallScreenService paramBaseSmallScreenService)
  {
    RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)this.b.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)this.c.getLayoutParams();
    if (paramBaseSmallScreenService.f)
    {
      this.m.setSize(this.p, this.q);
      this.m.setBackgroundResource(2130843279);
      this.a.setVisibility(0);
      localLayoutParams1.leftMargin = this.f;
      localLayoutParams1.topMargin = this.g;
      localLayoutParams2.bottomMargin = this.j;
    }
    else
    {
      this.m.setSize(this.d, this.e);
      this.m.setBackgroundResource(2130843281);
      this.a.setVisibility(8);
      localLayoutParams1.leftMargin = this.h;
      localLayoutParams1.topMargin = this.i;
      localLayoutParams2.bottomMargin = this.k;
    }
    this.b.setLayoutParams(localLayoutParams1);
    this.c.setLayoutParams(localLayoutParams2);
    this.m.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenAudio
 * JD-Core Version:    0.7.0.1
 */