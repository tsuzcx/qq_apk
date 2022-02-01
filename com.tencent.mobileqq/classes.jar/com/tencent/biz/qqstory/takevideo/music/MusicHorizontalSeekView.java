package com.tencent.biz.qqstory.takevideo.music;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.qphone.base.util.QLog;

public class MusicHorizontalSeekView
  extends View
  implements View.OnTouchListener
{
  protected static final int[] a = { 6, 8, 10, 12, 12, 10, 8, 6 };
  protected static final int b = a.length;
  protected static int c = 0;
  protected static int[] d = new int[b];
  protected static int e = 0;
  protected int f;
  protected int g;
  protected int h;
  protected int i;
  protected int j;
  protected int k;
  protected int l;
  protected int m;
  protected int n;
  protected MusicHorizontalSeekView.SeekListener o;
  protected Rect p;
  protected int q;
  protected int r;
  protected boolean s;
  protected Paint t;
  protected Paint u;
  protected Paint v;
  float w;
  
  public MusicHorizontalSeekView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    int i1 = 0;
    this.f = 0;
    this.g = 0;
    this.h = 0;
    this.i = 0;
    this.j = 0;
    this.k = 0;
    this.l = 0;
    this.m = 0;
    this.n = 0;
    this.o = null;
    this.p = null;
    this.q = 0;
    this.r = 0;
    this.s = false;
    this.t = null;
    this.u = null;
    this.v = null;
    this.w = 0.0F;
    this.q = ((int)DisplayUtils.a(paramContext, 2.0F));
    this.r = ((int)DisplayUtils.a(paramContext, 1.0F));
    c = (int)DisplayUtils.a(paramContext, 10.0F);
    e = (int)DisplayUtils.a(paramContext, 21.0F);
    while (i1 < b)
    {
      d[i1] = ((int)DisplayUtils.a(paramContext, a[i1]));
      i1 += 1;
    }
    paramContext = paramContext.getResources();
    this.t = new Paint();
    this.t.setAntiAlias(true);
    this.t.setColor(paramContext.getColor(2131165875));
    this.u = new Paint();
    this.u.setAntiAlias(true);
    this.u.setColor(paramContext.getColor(2131167379));
    this.v = new Paint();
    this.v.setAntiAlias(true);
    this.v.setColor(paramContext.getColor(2131167381));
    this.v.setStrokeWidth(this.r);
    super.setOnTouchListener(this);
  }
  
  public static void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 >= 30) {
      c = paramInt2 / (paramInt1 + 16);
    }
  }
  
  public void a(int paramInt)
  {
    this.j = (paramInt * c / 1000);
    setPlayedPosition(-1);
  }
  
  protected void a(Canvas paramCanvas, int paramInt1, int paramInt2, int paramInt3, Paint paramPaint)
  {
    float f1 = paramInt1;
    paramCanvas.drawLine(f1, paramInt2, f1, paramInt3, paramPaint);
  }
  
  public void draw(Canvas paramCanvas)
  {
    System.currentTimeMillis();
    this.t.setStrokeWidth(this.r);
    this.u.setStrokeWidth(this.r);
    int i2 = 0;
    int i1 = -1;
    while (i2 < this.g)
    {
      int i3 = this.l;
      int i6 = this.j;
      int i4 = i2 + 1;
      int i5 = i3 - i6 + c * i4;
      if ((i5 > i3 + this.h) && (i6 == this.i)) {
        break;
      }
      if (i5 >= 0)
      {
        if (i5 > this.m) {
          break;
        }
        Paint localPaint2 = this.v;
        i3 = i1;
        Paint localPaint1 = localPaint2;
        if (!this.s)
        {
          i3 = i1;
          localPaint1 = localPaint2;
          if (i5 > this.p.left)
          {
            i3 = i1;
            localPaint1 = localPaint2;
            if (i5 < this.p.right)
            {
              i3 = i1;
              if (i1 == -1) {
                i3 = i2;
              }
              if ((i2 >= i3) && (i2 < this.k + i3)) {
                localPaint1 = this.u;
              } else {
                localPaint1 = this.t;
              }
            }
          }
        }
        i1 = d[(i2 % b)];
        i2 = (this.n - i1) / 2;
        a(paramCanvas, i5, i2, i2 + i1, localPaint1);
        i1 = i3;
      }
      i2 = i4;
    }
    if (!this.s)
    {
      i1 = this.k;
      if (i1 < this.f)
      {
        if (i1 == -1)
        {
          this.t.setStrokeWidth(this.q);
          a(paramCanvas, this.p.left, this.p.top, this.p.bottom, this.t);
          a(paramCanvas, this.p.right, this.p.top, this.p.bottom, this.t);
          break label519;
        }
        this.u.setStrokeWidth(this.q);
        a(paramCanvas, this.p.left, this.p.top, this.p.bottom, this.u);
        this.t.setStrokeWidth(this.q);
        a(paramCanvas, this.p.right, this.p.top, this.p.bottom, this.t);
        break label519;
      }
    }
    this.u.setStrokeWidth(this.q);
    a(paramCanvas, this.p.left, this.p.top, this.p.bottom, this.u);
    a(paramCanvas, this.p.right, this.p.top, this.p.bottom, this.u);
    label519:
    QLog.isColorLevel();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.m = super.getMeasuredWidth();
    this.n = (e + super.getPaddingTop() + super.getPaddingBottom());
    setMeasuredDimension(this.m, this.n);
    this.l = ((this.m - this.h) / 2);
    paramInt2 = this.n;
    paramInt1 = e;
    paramInt2 = (paramInt2 - paramInt1) / 2;
    int i1 = this.l;
    this.p = new Rect(i1, paramInt2, this.f * c + i1, paramInt1 + paramInt2);
    MusicHorizontalSeekView.SeekListener localSeekListener = this.o;
    if (localSeekListener != null) {
      localSeekListener.a(this.l, this.h);
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getAction();
    if (i1 != 0)
    {
      if (i1 != 1)
      {
        if (i1 != 2) {
          return false;
        }
        float f1 = paramMotionEvent.getX();
        if (Math.abs(f1 - this.w) < 2.0F) {
          return true;
        }
        this.s = true;
        float f2 = this.j;
        float f3 = this.w;
        this.j = ((int)(f2 + (f3 - f1) / 2.0F));
        if (f1 > f3)
        {
          if (this.j <= c)
          {
            this.j = 0;
            super.invalidate();
            paramView = this.o;
            if (paramView != null) {
              paramView.b(this.i, this.h, this.j);
            }
            this.w = f1;
            return false;
          }
        }
        else
        {
          i1 = this.j;
          int i2 = this.i;
          int i3 = this.h;
          if (i1 >= i2 - i3)
          {
            this.j = (i2 - i3);
            super.invalidate();
            paramView = this.o;
            if (paramView != null) {
              paramView.b(this.i, this.h, this.j);
            }
            this.w = f1;
            return false;
          }
        }
        super.invalidate();
        paramView = this.o;
        if (paramView != null) {
          paramView.b(this.i, this.h, this.j);
        }
        this.w = f1;
        return false;
      }
      this.s = false;
      super.invalidate();
      paramView = this.o;
      if (paramView != null)
      {
        paramView.c(this.i, this.h, this.j);
        return false;
      }
    }
    else
    {
      this.s = false;
      this.w = paramMotionEvent.getX();
      paramView = this.o;
      if (paramView != null) {
        paramView.a(this.i, this.h, this.j);
      }
    }
    return false;
  }
  
  public void setDurations(int paramInt1, int paramInt2)
  {
    this.f = paramInt1;
    this.g = paramInt2;
    paramInt1 = c;
    this.h = (this.f * paramInt1);
    this.i = (paramInt1 * this.g);
  }
  
  public void setOnSeekListener(MusicHorizontalSeekView.SeekListener paramSeekListener)
  {
    this.o = paramSeekListener;
  }
  
  public void setPlayedPosition(int paramInt)
  {
    this.k = paramInt;
    super.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.music.MusicHorizontalSeekView
 * JD-Core Version:    0.7.0.1
 */