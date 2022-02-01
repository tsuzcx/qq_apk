package com.tencent.aelight.camera.aeeditor.view.timebar.scale;

import android.view.View;
import com.tencent.aelight.camera.aeeditor.view.timebar.scale.size.FrameSizeParam;
import com.tencent.aelight.camera.aeeditor.view.timebar.scale.size.SecSizeParam;
import com.tencent.aelight.camera.aeeditor.view.timebar.scale.size.SizeParam;
import java.util.ArrayList;
import java.util.List;

public class ScaleAdapter
{
  private final List<Scaler> a = new ArrayList();
  private ArrayList<SizeParam> b = new ArrayList();
  private long c;
  private long d;
  private SizeParam e;
  private int f = 30;
  private int g = 15;
  private float h = 30.0F;
  private Course i = new Course();
  private View j;
  
  public ScaleAdapter()
  {
    j();
  }
  
  private void a(SizeParam paramSizeParam)
  {
    this.e = paramSizeParam;
    h();
  }
  
  private int d(float paramFloat)
  {
    int k = this.b.indexOf(this.e);
    int m = (int)(this.h * paramFloat);
    if (paramFloat > 1.0F)
    {
      if (m >= this.f)
      {
        k -= 1;
        if ((k >= 0) && (!this.b.isEmpty()))
        {
          a((SizeParam)this.b.get(k));
          return 0;
        }
        return 1;
      }
      return 2;
    }
    if (paramFloat < 1.0F)
    {
      if (m <= this.g)
      {
        k += 1;
        if (k < this.b.size())
        {
          a((SizeParam)this.b.get(k));
          return 0;
        }
        return 1;
      }
      return 2;
    }
    return 1;
  }
  
  private void e(float paramFloat)
  {
    this.h *= paramFloat;
  }
  
  private void h()
  {
    this.a.clear();
    Object localObject = this.e;
    if (localObject != null)
    {
      int n = (int)((SizeParam)localObject).a(c() - b());
      int k = 0;
      while (k < n + 1)
      {
        localObject = new Scaler();
        int m;
        if (k % 2 == 0) {
          m = 0;
        } else {
          m = 1;
        }
        ((Scaler)localObject).b(m);
        ((Scaler)localObject).a(k);
        this.a.add(localObject);
        k += 1;
      }
    }
  }
  
  private int i()
  {
    return this.g;
  }
  
  private void j()
  {
    Object localObject = new FrameSizeParam(1.0F);
    this.b.add(localObject);
    localObject = new FrameSizeParam(1.5F);
    this.b.add(localObject);
    localObject = new FrameSizeParam(2.5F);
    this.b.add(localObject);
    localObject = new FrameSizeParam(5.0F);
    this.b.add(localObject);
    localObject = new FrameSizeParam(7.5F);
    this.b.add(localObject);
    localObject = new SecSizeParam(0.5F);
    this.b.add(localObject);
    localObject = new SecSizeParam(1.0F);
    this.b.add(localObject);
    localObject = new SecSizeParam(1.5F);
    this.b.add(localObject);
    localObject = new SecSizeParam(2.5F);
    this.b.add(localObject);
    localObject = new SecSizeParam(5.0F);
    this.b.add(localObject);
    this.e = ((SizeParam)this.b.get(6));
  }
  
  public String a(Scaler paramScaler)
  {
    if (paramScaler == null) {
      return null;
    }
    try
    {
      long l1 = b();
      long l2 = this.e.a(paramScaler.a());
      paramScaler = this.e.b(l1 + l2);
      return paramScaler;
    }
    catch (IllegalArgumentException paramScaler)
    {
      paramScaler.printStackTrace();
    }
    return null;
  }
  
  public List<Scaler> a()
  {
    return this.a;
  }
  
  public void a(float paramFloat)
  {
    long l = d();
    int k = d(paramFloat);
    if (k != 1)
    {
      if (k == 0)
      {
        if (paramFloat > 1.0F) {
          this.h = i();
        } else {
          this.h = e();
        }
      }
      else {
        e(paramFloat);
      }
      this.j.invalidate();
      k = c(l);
      this.j.scrollTo(k, 0);
    }
  }
  
  public void a(int paramInt)
  {
    this.f = paramInt;
    this.h = paramInt;
  }
  
  public void a(long paramLong)
  {
    if (this.e != null) {
      this.d = paramLong;
    }
    h();
  }
  
  public void a(View paramView)
  {
    this.j = paramView;
  }
  
  public float b(long paramLong)
  {
    SizeParam localSizeParam = this.e;
    if (localSizeParam != null) {
      return localSizeParam.a(paramLong);
    }
    return 0.0F;
  }
  
  public long b()
  {
    return this.c;
  }
  
  public long b(float paramFloat)
  {
    paramFloat /= this.h;
    return b() + this.e.a(paramFloat);
  }
  
  public long b(Scaler paramScaler)
  {
    if (paramScaler == null) {
      return -1L;
    }
    try
    {
      long l1 = b();
      long l2 = this.e.a(paramScaler.a());
      return l2 + l1;
    }
    catch (IllegalArgumentException paramScaler)
    {
      paramScaler.printStackTrace();
    }
    return -1L;
  }
  
  public void b(int paramInt)
  {
    this.g = paramInt;
  }
  
  public int c(long paramLong)
  {
    return (int)(this.h * this.e.a(paramLong));
  }
  
  public long c()
  {
    return this.d;
  }
  
  public long c(float paramFloat)
  {
    if ((int)(f() * b(c())) <= paramFloat) {
      return c();
    }
    paramFloat /= this.h;
    return b() + this.e.a(paramFloat);
  }
  
  public void c(int paramInt)
  {
    if (paramInt > this.b.size() - 1) {
      return;
    }
    this.e = ((SizeParam)this.b.get(paramInt));
  }
  
  public long d()
  {
    return b() + this.e.a(this.i.a());
  }
  
  public int e()
  {
    return this.f;
  }
  
  public float f()
  {
    return this.h;
  }
  
  public void g()
  {
    View localView = this.j;
    if (localView != null)
    {
      Course localCourse = this.i;
      float f2 = this.h;
      float f1 = 0.0F;
      if (f2 > 0.0F) {
        f1 = localView.getScrollX() / this.h;
      }
      localCourse.a(f1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.view.timebar.scale.ScaleAdapter
 * JD-Core Version:    0.7.0.1
 */