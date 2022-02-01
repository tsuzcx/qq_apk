package com.tencent.mobileqq.activity.aio.anim;

import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.AnimateUtils;
import com.tencent.widget.ListView;

public class MoveToBottomScroller
  implements Runnable
{
  public static int b = 50;
  private boolean A;
  public int a;
  ListView c;
  AIOFooterViewDetector d;
  int e;
  int f;
  int g;
  int h;
  float i;
  int j;
  int k;
  int l;
  int m;
  int n;
  MoveToBottomScroller.OnScrollerListener o;
  private float p;
  private float q;
  private float r;
  private long s;
  private int t;
  private int u;
  private int v;
  private int w;
  private int x;
  private boolean y;
  private boolean z;
  
  public MoveToBottomScroller(ListView paramListView, AIOFooterViewDetector paramAIOFooterViewDetector)
  {
    boolean bool = false;
    this.t = 0;
    this.y = false;
    this.a = 0;
    this.z = true;
    this.f = 0;
    this.g = 0;
    this.h = 0;
    this.i = 1.0F;
    this.j = 0;
    this.k = 0;
    this.l = 0;
    this.m = 0;
    this.n = 0;
    this.c = paramListView;
    this.d = paramAIOFooterViewDetector;
    this.e = ViewConfiguration.get(this.c.getContext()).getScaledMinimumFlingVelocity();
    if (DeviceInfoUtil.a() / 1048576L > 512L) {
      bool = true;
    }
    this.z = bool;
    this.i = this.c.getResources().getDisplayMetrics().density;
  }
  
  private int a(int paramInt)
  {
    int i1 = paramInt;
    if (this.c.getChildCount() > 0)
    {
      ListView localListView = this.c;
      i1 = localListView.getChildAt(localListView.getChildCount() - 1).getBottom();
      int i2 = this.n;
      if ((i2 != 0) && (i2 >= i1))
      {
        double d1 = i2 - i1;
        int i3 = this.m;
        double d2 = i3;
        Double.isNaN(d2);
        if (d1 <= d2 * 0.75D) {
          this.l += i3 - (i2 - i1);
        }
      }
      this.n = i1;
      i2 = this.l;
      i1 = paramInt + i2 / 5;
      this.l = (i2 * 4 / 5);
      this.m = i1;
    }
    return i1;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MoveToBottomScroller", 2, "MoveToBottomScroller start");
    }
    if (this.A)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MoveToBottomScroller", 2, "start() mRunning, ignore request");
      }
      return;
    }
    this.A = true;
    this.a = 0;
    this.m = 0;
    this.l = 0;
    this.n = 0;
    if (!this.z)
    {
      localObject = this.c;
      ((ListView)localObject).setSelection(((ListView)localObject).getCount() - 1);
      b();
      return;
    }
    Object localObject = this.c;
    if (localObject == null)
    {
      this.A = false;
      return;
    }
    this.k = ((ListView)localObject).getResources().getDisplayMetrics().heightPixels;
    this.g = this.c.mFirstPosition;
    this.h = (this.g + this.c.getChildCount() - 1);
    this.f = (this.c.getCount() - this.h - 1);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("MoveToBottomScroller start scrollCount: ");
      ((StringBuilder)localObject).append(this.f);
      QLog.d("MoveToBottomScroller", 2, ((StringBuilder)localObject).toString());
    }
    if (this.f == 0)
    {
      if (this.c.getChildCount() < 1)
      {
        localObject = this.c;
        ((ListView)localObject).setSelection(((ListView)localObject).getCount() - 1);
        this.A = false;
        return;
      }
      localObject = this.c;
      this.x = ((ListView)localObject).getChildAt(((ListView)localObject).getChildCount() - 1).getBottom();
      if (this.x == 0)
      {
        b();
        return;
      }
      this.w = 800;
      this.s = AnimationUtils.currentAnimationTimeMillis();
      this.t = 0;
      this.u = 3;
      this.c.removeCallbacks(this);
      if (Build.VERSION.SDK_INT >= 16) {
        this.c.postOnAnimation(this);
      } else {
        this.c.post(this);
      }
    }
    else
    {
      int i1 = this.c.getChildCount();
      if (this.c.getChildCount() == 0) {
        i1 = 1;
      }
      if ((this.c.getFooterViewsCount() > 0) && (this.d.a >= 0))
      {
        int i2 = this.f;
        if (i2 > 1) {
          i2 -= 1;
        } else {
          i2 = 0;
        }
        this.f = i2;
        this.x = this.d.a;
      }
      else
      {
        this.x = 0;
      }
      this.x += this.f * this.c.getHeight() / i1;
      this.r = (this.x / 600.0F);
      this.p = (this.r / 200.0F);
      this.q = 0.0F;
      this.s = AnimationUtils.currentAnimationTimeMillis();
      this.u = 0;
      this.t = 0;
      this.v = (this.c.getCount() - 1);
      boolean bool;
      if (this.f == 1) {
        bool = true;
      } else {
        bool = false;
      }
      this.y = bool;
      this.c.removeCallbacks(this);
      if (Build.VERSION.SDK_INT >= 16) {
        this.c.postOnAnimation(this);
      } else {
        this.c.post(this);
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("MoveToBottomScroller start end with mDistance: ");
      ((StringBuilder)localObject).append(this.x);
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" scrollCount: ");
      localStringBuilder.append(this.f);
      QLog.d("MoveToBottomScroller", 2, new Object[] { localObject, localStringBuilder.toString() });
    }
  }
  
  public void a(MoveToBottomScroller.OnScrollerListener paramOnScrollerListener)
  {
    this.o = paramOnScrollerListener;
  }
  
  public void b()
  {
    this.A = false;
    MoveToBottomScroller.OnScrollerListener localOnScrollerListener = this.o;
    if (localOnScrollerListener != null) {
      localOnScrollerListener.a();
    }
    this.c.removeCallbacks(this);
  }
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("MoveToBottomScroller run with mDistance: ");
      ((StringBuilder)localObject).append(this.x);
      QLog.d("MoveToBottomScroller", 2, ((StringBuilder)localObject).toString());
    }
    this.a += 1;
    if (this.a >= b)
    {
      localObject = this.c;
      ((ListView)localObject).setSelectionFromBottom(((ListView)localObject).getCount() - 1, 0);
      b();
      return;
    }
    int i3 = (int)(AnimationUtils.currentAnimationTimeMillis() - this.s);
    int i1 = this.u;
    float f1;
    float f2;
    if (i1 != 0)
    {
      if (i1 != 1)
      {
        if (i1 != 2)
        {
          if (i1 != 3)
          {
            if (i1 != 4)
            {
              i1 = 0;
              break label337;
            }
            f1 = i3 / this.w;
            i1 = this.x;
          }
          else
          {
            f1 = AnimateUtils.a(i3 / this.w);
            i1 = this.x;
          }
          f1 *= i1;
        }
        else
        {
          f1 = this.r;
        }
      }
      else {
        for (f1 = i3 * f1 - f1 * 800.0F / 8.0F;; f1 = this.x - this.q * (i1 - i3) / 2.0F)
        {
          i1 = (int)f1;
          break;
          i1 = this.w;
          if (i3 > i1)
          {
            i1 = this.x;
            i1 = this.t;
            localObject = this.c;
            ((ListView)localObject).setSelectionFromBottom(((ListView)localObject).getCount() - 1, 0);
            b();
            return;
          }
          this.q -= this.p * i3;
        }
      }
    }
    else
    {
      f1 = this.p;
      f2 = i3;
      this.q = (f1 * f2);
      f1 = this.q * f2 / 2.0F;
    }
    i1 = (int)f1;
    label337:
    int i2 = i1 - this.t;
    this.t = i1;
    i1 = i2;
    if (i2 < 0) {
      i1 = 0;
    }
    if (this.c.getChildCount() - 1 > 0)
    {
      localObject = this.c;
      this.j = ((ListView)localObject).getChildAt(((ListView)localObject).getChildCount() - 1).getHeight();
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("run  delta=");
    ((StringBuilder)localObject).append(i1);
    QLog.d("MoveToBottomScroller", 2, ((StringBuilder)localObject).toString());
    i2 = i1;
    if (this.f < 2)
    {
      double d1;
      if (this.j <= this.k)
      {
        f1 = i1;
        f2 = this.i;
        i2 = i1;
        if (f1 >= f2 * 2.0F) {
          break label544;
        }
        d1 = f2 * 2.0F;
        Double.isNaN(d1);
      }
      else
      {
        f1 = i1;
        f2 = this.i;
        i2 = i1;
        if (f1 <= f2 * 10.0F) {
          break label544;
        }
        d1 = f2 * 10.0F;
        Double.isNaN(d1);
      }
      i2 = (int)(d1 + 0.5D);
    }
    label544:
    i1 = a(i2);
    boolean bool;
    try
    {
      localObject = this.c;
      i2 = -i1;
      bool = ((ListView)localObject).trackMotionScroll(i2, i2);
      try
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("move delta=");
        ((StringBuilder)localObject).append(i1);
        QLog.d("MoveToBottomScroller", 2, ((StringBuilder)localObject).toString());
      }
      catch (Exception localException1) {}
      QLog.d("MoveToBottomScroller", 2, localException2, new Object[0]);
    }
    catch (Exception localException2)
    {
      bool = true;
    }
    if (!bool)
    {
      i1 = this.c.getChildCount();
      i2 = this.c.mFirstPosition;
      int i4 = this.u;
      if ((i4 != 3) && (i4 != 1) && (i2 + i1 - 1 >= this.v))
      {
        if (i1 >= 2) {
          this.x = (this.c.getChildAt(i1 - 1).getBottom() - this.c.getChildAt(i1 - 2).getBottom());
        } else if (i1 == 1) {
          this.x = this.c.getChildAt(i1 - 1).getBottom();
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("at position mDistance=");
        localStringBuilder.append(this.x);
        QLog.d("MoveToBottomScroller", 2, localStringBuilder.toString());
        this.w = (800 - i3);
        if (this.w < 100) {
          this.w = 100;
        }
        if (this.w > 400) {
          this.w = 400;
        }
        this.s = AnimationUtils.currentAnimationTimeMillis();
        this.t = 0;
        if ((this.q * 1000.0F > this.e) && (!this.y))
        {
          this.u = 1;
          f1 = this.x;
          i1 = this.w;
          this.q = (f1 * 2.0F / i1);
          this.p = (this.q / i1);
        }
        else
        {
          this.u = 3;
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("at position mCurrVelocity=");
        localStringBuilder.append(this.q);
        localStringBuilder.append("mCurrVelocity=");
        localStringBuilder.append(this.q);
        localStringBuilder.append("mDuration=");
        localStringBuilder.append(this.w);
        QLog.d("MoveToBottomScroller", 2, localStringBuilder.toString());
      }
      this.c.removeCallbacks(this);
      if (Build.VERSION.SDK_INT >= 16)
      {
        this.c.postOnAnimation(this);
        return;
      }
      this.c.post(this);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MoveToBottomScroller", 2, "atEdge");
    }
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.MoveToBottomScroller
 * JD-Core Version:    0.7.0.1
 */