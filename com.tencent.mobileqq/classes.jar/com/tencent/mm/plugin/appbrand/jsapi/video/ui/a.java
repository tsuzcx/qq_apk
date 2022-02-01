package com.tencent.mm.plugin.appbrand.jsapi.video.ui;

import android.content.Context;
import android.media.AudioManager;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.luggage.wxa.ma.k;

public class a
{
  private Context a;
  private View b;
  private a.a c = a.a.a;
  private GestureDetector d;
  private a.b e;
  private float f = 0.0F;
  private int g = 0;
  private float h = 0.0F;
  private int i = -1;
  private int j = 0;
  private Runnable k = new a.1(this);
  
  public a(Context paramContext, View paramView, a.b paramb)
  {
    this.a = paramContext;
    this.e = paramb;
    this.b = paramView;
    c();
    this.f = k.b(paramContext);
  }
  
  private boolean a(float paramFloat)
  {
    if (!this.e.g()) {
      return false;
    }
    paramFloat *= -1.0F;
    float f2 = paramFloat / this.b.getMeasuredHeight();
    AudioManager localAudioManager = (AudioManager)this.a.getSystemService("audio");
    int n = localAudioManager.getStreamMaxVolume(3);
    float f1 = n;
    f2 = f2 * f1 * 1.2F;
    int i1 = (int)f2;
    int m = i1;
    if (i1 == 0)
    {
      m = i1;
      if (Math.abs(f2) > 0.2F) {
        if (paramFloat > 0.0F)
        {
          m = 1;
        }
        else
        {
          m = i1;
          if (paramFloat < 0.0F) {
            m = -1;
          }
        }
      }
    }
    i1 = this.g + m;
    if (i1 < 0)
    {
      m = 0;
    }
    else
    {
      m = i1;
      if (i1 >= n) {
        m = n;
      }
    }
    com.tencent.luggage.wxa.hc.a.a(localAudioManager, 3, m, 0);
    paramFloat = m / f1;
    this.e.a(paramFloat);
    return true;
  }
  
  private boolean a(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (this.c == a.a.d) {
      return c(paramFloat1);
    }
    if (this.c == a.a.c) {
      return b(paramFloat2);
    }
    if (this.c == a.a.b) {
      return a(paramFloat2);
    }
    return true;
  }
  
  private void b()
  {
    this.c = a.a.a;
  }
  
  private boolean b(float paramFloat)
  {
    if (!this.e.f()) {
      return false;
    }
    paramFloat = paramFloat * -1.0F / this.b.getMeasuredHeight();
    paramFloat = this.f + paramFloat * 1.2F;
    float f1 = 1.0F;
    if (paramFloat < 0.0F) {
      paramFloat = 0.0F;
    } else if (paramFloat > 1.0F) {
      paramFloat = f1;
    }
    k.a(this.a, paramFloat);
    this.e.b(paramFloat);
    return true;
  }
  
  private void c()
  {
    this.d = new GestureDetector(this.a, new a.2(this));
  }
  
  private boolean c(float paramFloat)
  {
    if (!this.e.h()) {
      return false;
    }
    if (this.i == -1)
    {
      this.e.c();
      this.i = this.e.e();
    }
    this.j = this.e.a(this.i, paramFloat);
    return true;
  }
  
  private void d()
  {
    this.g = ((AudioManager)this.a.getSystemService("audio")).getStreamVolume(3);
    this.f = k.b(this.a);
  }
  
  public void a()
  {
    this.i = -1;
    this.j = 0;
    this.h = 0.0F;
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    if (!this.e.d())
    {
      b();
      return;
    }
    int m = paramMotionEvent.getActionMasked();
    if (m == 0)
    {
      this.h = paramMotionEvent.getRawX();
      d();
    }
    this.d.onTouchEvent(paramMotionEvent);
    if ((m == 1) || (m == 3))
    {
      if (this.c == a.a.d)
      {
        this.e.b(this.j, paramMotionEvent.getRawX() - this.h);
        this.i = -1;
        this.j = 0;
        this.h = 0.0F;
      }
      else if (this.c == a.a.b)
      {
        m = ((AudioManager)this.a.getSystemService("audio")).getStreamMaxVolume(3);
        this.e.c(this.g / m);
      }
      else if (this.c == a.a.c)
      {
        this.e.d(this.f);
      }
      b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.ui.a
 * JD-Core Version:    0.7.0.1
 */