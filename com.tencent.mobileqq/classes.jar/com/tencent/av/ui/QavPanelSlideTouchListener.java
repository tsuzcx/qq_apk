package com.tencent.av.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.widget.ImageView;
import com.tencent.av.widget.shimmer.ShimmerTextView;

public class QavPanelSlideTouchListener
  implements View.OnTouchListener
{
  public QavPanel.SlideAcceptListener a = null;
  boolean b = false;
  final int c;
  int d = -1;
  Rect e = new Rect();
  Rect f = new Rect();
  Rect g = new Rect();
  ImageView h = null;
  ImageView i = null;
  ShimmerTextView j = null;
  ImageView k = null;
  int l = 0;
  
  public QavPanelSlideTouchListener(Context paramContext, ImageView paramImageView1, ImageView paramImageView2, ShimmerTextView paramShimmerTextView, ImageView paramImageView3)
  {
    this.h = paramImageView1;
    this.i = paramImageView2;
    this.j = paramShimmerTextView;
    this.k = paramImageView3;
    this.l = paramContext.getResources().getDimensionPixelSize(2131298524);
    this.c = ViewConfiguration.get(paramContext).getScaledTouchSlop();
  }
  
  private void a(int paramInt)
  {
    this.e.left = (this.f.left + paramInt - this.d);
    this.e.right = (this.f.right + paramInt - this.d);
    paramInt = this.e.right;
    int m = this.l;
    Rect localRect;
    if (paramInt >= m)
    {
      localRect = this.e;
      localRect.right = m;
      localRect.left = (localRect.right - this.h.getWidth());
    }
    if (this.e.left <= 0)
    {
      localRect = this.e;
      localRect.left = 0;
      localRect.right = (localRect.left + this.h.getWidth());
    }
    this.h.layout(this.e.left, this.f.top, this.e.right, this.f.bottom);
    this.k.layout(this.e.left, this.g.top, this.g.right, this.g.bottom);
  }
  
  void a()
  {
    this.f.top = this.h.getTop();
    this.f.bottom = this.h.getBottom();
    this.f.left = this.h.getLeft();
    this.f.right = this.h.getRight();
    this.e.left = this.h.getLeft();
    this.e.right = this.h.getRight();
    this.g.top = this.k.getTop();
    this.g.bottom = this.k.getBottom();
    this.g.left = this.k.getLeft();
    this.g.right = this.k.getRight();
    this.b = false;
  }
  
  public void a(QavPanel.SlideAcceptListener paramSlideAcceptListener)
  {
    this.a = paramSlideAcceptListener;
  }
  
  public void b()
  {
    a(this.d);
    this.j.setVisibility(0);
    this.i.setVisibility(0);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int m = (int)paramMotionEvent.getRawX();
    int n = paramMotionEvent.getAction();
    if (n != 0)
    {
      if (n != 1)
      {
        if (n != 2) {
          return true;
        }
        if (this.b)
        {
          a(m);
          return true;
        }
        if (Math.abs(m - this.d) > this.c)
        {
          this.b = true;
          this.j.setVisibility(4);
          this.i.setVisibility(4);
          return true;
        }
      }
      else if (this.e.right == this.l)
      {
        paramView = this.a;
        if (paramView != null)
        {
          paramView.a(true);
          return true;
        }
      }
      else if (this.e.right < this.l)
      {
        this.h.layout(this.f.left, this.f.top, this.f.right, this.f.bottom);
        this.k.layout(this.g.left, this.g.top, this.g.right, this.g.bottom);
        this.j.setVisibility(0);
        this.i.setVisibility(0);
        paramView = this.a;
        if (paramView != null)
        {
          paramView.a(false);
          return true;
        }
      }
    }
    else
    {
      this.d = m;
      a();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.QavPanelSlideTouchListener
 * JD-Core Version:    0.7.0.1
 */