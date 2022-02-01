package com.tencent.luggage.wxa.dl;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;

public class d
  extends FrameLayout
{
  private ValueAnimator a;
  private ImageView b;
  private c c;
  private Rect d;
  private int e;
  private int f;
  
  public d(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  private void a()
  {
    this.e = getContext().getResources().getDimensionPixelSize(2131299673);
    this.f = getContext().getResources().getDimensionPixelSize(2131299672);
    this.c = new c(getContext());
    addView(this.c, new FrameLayout.LayoutParams(-1, -1));
    b();
    setWillNotDraw(false);
    this.b = new ImageView(getContext());
    addView(this.b, new FrameLayout.LayoutParams(this.e, -2));
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.b.getLayoutParams();
    localLayoutParams.gravity = 1;
    this.b.setLayoutParams(localLayoutParams);
    this.b.setBackgroundResource(2130848824);
    this.b.setVisibility(8);
    this.a = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F }).setDuration(2600L);
    this.a.setInterpolator(new AccelerateDecelerateInterpolator());
    this.a.addListener(new d.1(this));
    this.a.addUpdateListener(new d.2(this));
    this.a.setRepeatMode(1);
    this.a.setRepeatCount(-1);
  }
  
  private void b()
  {
    Point localPoint = new Point();
    ((Activity)getContext()).getWindowManager().getDefaultDisplay().getSize(localPoint);
    int i = localPoint.x / 2 - this.e / 2;
    int k = localPoint.y / 2;
    int j = this.f;
    k -= j / 2;
    this.d = new Rect(i, k, this.e + i, j + k);
    this.c.setRect(this.d);
  }
  
  public Rect getDecorRect()
  {
    return this.d;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    ValueAnimator localValueAnimator = this.a;
    if (localValueAnimator != null) {
      localValueAnimator.cancel();
    }
  }
  
  public void setDecorRect(Rect paramRect)
  {
    if (paramRect != null)
    {
      this.e = paramRect.width();
      this.f = paramRect.height();
      this.d = new Rect(paramRect);
    }
    this.c.setRect(this.d);
    this.c.postInvalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.dl.d
 * JD-Core Version:    0.7.0.1
 */