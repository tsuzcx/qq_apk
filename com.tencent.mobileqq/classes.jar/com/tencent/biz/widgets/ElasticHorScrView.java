package com.tencent.biz.widgets;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.HorizontalScrollView;

public class ElasticHorScrView
  extends HorizontalScrollView
{
  protected View a;
  protected ViewGroup b;
  protected Rect c = new Rect();
  protected float d;
  protected boolean e = false;
  protected final int f = 300;
  protected final double g = 2.5D;
  protected int h = 0;
  protected boolean i = true;
  
  public ElasticHorScrView(Context paramContext)
  {
    super(paramContext);
  }
  
  public ElasticHorScrView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void a()
  {
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(this.a.getLeft(), this.c.left, 0.0F, 0.0F);
    localTranslateAnimation.setDuration(300L);
    this.a.setAnimation(localTranslateAnimation);
    this.a.layout(this.c.left, this.c.top, this.c.right, this.c.bottom);
    this.c.setEmpty();
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    int j = paramMotionEvent.getAction();
    if (j != 0)
    {
      if (j != 1)
      {
        if (j != 2) {
          return;
        }
        if (this.i)
        {
          this.d = paramMotionEvent.getX();
          this.i = false;
        }
        float f1 = this.d;
        float f2 = paramMotionEvent.getX();
        double d1 = f1 - f2;
        Double.isNaN(d1);
        j = (int)(d1 / 2.5D);
        this.d = f2;
        if (c())
        {
          if (this.c.isEmpty()) {
            this.c.set(this.a.getLeft(), this.a.getTop(), this.a.getRight(), this.a.getBottom());
          }
          int k = this.a.getMeasuredWidth();
          int m = getWidth();
          int n = getScrollX();
          paramMotionEvent = new StringBuilder();
          paramMotionEvent.append("inner.getLeft()");
          paramMotionEvent.append(this.a.getLeft());
          paramMotionEvent.append("distanceX");
          paramMotionEvent.append(j);
          paramMotionEvent.append("inner.getRight()");
          paramMotionEvent.append(this.a.getRight());
          Log.v("test", paramMotionEvent.toString());
          if (((n == 0) && (j < 0)) || ((k - m == n) && (j > 0)))
          {
            paramMotionEvent = this.a;
            paramMotionEvent.layout(paramMotionEvent.getLeft() - j, this.a.getTop(), this.a.getRight() - j, this.a.getBottom());
          }
        }
        else
        {
          scrollBy(j, 0);
        }
      }
      else
      {
        if (b()) {
          a();
        }
        this.i = true;
      }
    }
    else {
      this.d = paramMotionEvent.getX();
    }
  }
  
  private boolean b()
  {
    return this.c.isEmpty() ^ true;
  }
  
  private boolean c()
  {
    int j = this.a.getMeasuredWidth();
    int k = getWidth();
    int m = getScrollX();
    return (m == 0) || (j - k == m);
  }
  
  protected void onFinishInflate()
  {
    if ((getChildCount() > 0) && ((getChildAt(0) instanceof ViewGroup))) {
      this.b = ((ViewGroup)getChildAt(0));
    }
    if (this.b.getChildCount() > 0) {
      this.a = this.b.getChildAt(0);
    }
    super.onFinishInflate();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.e) {
      return false;
    }
    a(paramMotionEvent);
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setMove(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.widgets.ElasticHorScrView
 * JD-Core Version:    0.7.0.1
 */