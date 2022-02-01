package com.tencent.mobileqq.app.utils;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.widget.VerticalGallery;

public class TimeWheelPanel
  extends LinearLayout
  implements NumberWheelView.ScrollStateListener
{
  private boolean A = false;
  public int a;
  public int b;
  public int c;
  private final int d = 30;
  private final int e = 24;
  private final int f = 60;
  private final int g = 60;
  private int h;
  private int i;
  private int j;
  private int k;
  private int l;
  private int m;
  private int n;
  private Context o;
  private LayoutInflater p;
  private NumberWheelView q;
  private NumberWheelView r;
  private NumberWheelView s;
  private TextView t;
  private TextView u;
  private TextView v;
  private TextView w;
  private TimeWheelPanel.ScrollStateListener x;
  private boolean y = false;
  private String z;
  
  public TimeWheelPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.o = paramContext;
  }
  
  private void a()
  {
    if ((this.p == null) || (this.q == null) || (this.r == null) || (this.s == null))
    {
      this.p = LayoutInflater.from(this.o);
      this.p.inflate(2131627326, this);
      this.q = ((NumberWheelView)findViewById(2131431636));
      this.r = ((NumberWheelView)findViewById(2131435193));
      this.s = ((NumberWheelView)findViewById(2131438757));
      this.t = ((TextView)findViewById(2131431637));
      this.u = ((TextView)findViewById(2131435194));
      this.v = ((TextView)findViewById(2131438758));
      this.w = ((TextView)findViewById(2131432553));
      this.q.setScrollStateListener(this);
      this.r.setScrollStateListener(this);
      this.s.setScrollStateListener(this);
      this.q.setmMaxRotationAngle(0);
      this.r.setmMaxRotationAngle(0);
      this.s.setmMaxRotationAngle(0);
      this.q.setRange(0, this.h - 1);
      this.r.setRange(0, 23);
      this.s.setRange(0, 59);
    }
    setValues(true);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramInt4 <= 0) {
      paramInt4 = 30;
    }
    this.h = paramInt4;
    if ((paramInt1 < 0) || (paramInt1 >= this.h)) {
      paramInt1 = 0;
    }
    this.i = paramInt1;
    if ((paramInt2 < 0) || (paramInt2 >= 24)) {
      paramInt2 = 0;
    }
    this.j = paramInt2;
    if ((paramInt3 < 0) || (paramInt3 >= 60)) {
      paramInt3 = 0;
    }
    this.k = paramInt3;
    this.a = this.i;
    this.b = this.j;
    this.c = this.k;
    this.l = 1;
    this.m = 1;
    this.n = 1;
    a();
  }
  
  public void a(NumberWheelView paramNumberWheelView, VerticalGallery paramVerticalGallery)
  {
    this.a = this.q.getCurrent();
    this.b = this.r.getCurrent();
    this.c = this.s.getCurrent();
    setValues(false);
    TimeWheelPanel.ScrollStateListener localScrollStateListener = this.x;
    if (localScrollStateListener != null) {
      localScrollStateListener.a(paramNumberWheelView, paramVerticalGallery);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.y = paramBoolean;
  }
  
  public int getCurrentSeconds()
  {
    return ((this.a * 24 + this.b) * 60 + this.c) * 60;
  }
  
  public void setEndTime(String paramString)
  {
    setEndTime(paramString, null);
  }
  
  public void setEndTime(String paramString1, String paramString2)
  {
    this.z = paramString2;
    if (paramString2 == null)
    {
      this.w.setText(paramString1);
      this.A = false;
      return;
    }
    if (this.A) {
      this.w.setText(paramString2);
    } else {
      this.w.setText(paramString1);
    }
    this.w.post(new TimeWheelPanel.1(this));
  }
  
  public void setScrollerStateListener(TimeWheelPanel.ScrollStateListener paramScrollStateListener)
  {
    this.x = paramScrollStateListener;
  }
  
  public void setValues(boolean paramBoolean)
  {
    if ((this.l == 1) && (this.m == 1))
    {
      if (this.n != 1) {
        return;
      }
      if ((this.a == 0) && (this.b == 0) && (this.c == 0) && (!this.y))
      {
        this.c = 1;
        this.s.setValue(this.c);
      }
      if (paramBoolean)
      {
        this.q.setValue(this.a);
        this.r.setValue(this.b);
        this.s.setValue(this.c);
      }
    }
  }
  
  public void setViewVisibility(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0)
    {
      findViewById(2131431632).setVisibility(paramInt2);
      return;
    }
    if (paramInt1 == 1)
    {
      findViewById(2131435189).setVisibility(paramInt2);
      return;
    }
    if (paramInt1 == 2)
    {
      findViewById(2131438754).setVisibility(paramInt2);
      return;
    }
    if (paramInt1 == 3) {
      this.w.setVisibility(paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.utils.TimeWheelPanel
 * JD-Core Version:    0.7.0.1
 */