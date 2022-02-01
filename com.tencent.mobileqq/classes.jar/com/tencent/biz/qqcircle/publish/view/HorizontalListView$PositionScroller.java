package com.tencent.biz.qqcircle.publish.view;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.view.View;
import android.widget.ListAdapter;

class HorizontalListView$PositionScroller
  implements Runnable
{
  private int a;
  private int b;
  private int c;
  private int d;
  private int e;
  
  void a()
  {
    this.this$0.removeCallbacks(this);
  }
  
  void a(int paramInt1, int paramInt2)
  {
    a(paramInt1, paramInt2, 2000);
  }
  
  void a(int paramInt1, int paramInt2, int paramInt3)
  {
    a();
    if (this.this$0.g)
    {
      this.this$0.u = new HorizontalListView.PositionScroller.1(this, paramInt1, paramInt2);
      return;
    }
    int j = this.this$0.getChildCount();
    if (j == 0) {
      return;
    }
    int i;
    if (!this.this$0.t) {
      i = this.this$0.m;
    } else {
      i = this.this$0.n;
    }
    j = j + i - 1;
    int k = Math.max(0, Math.min(this.this$0.f.getCount() - 1, paramInt1));
    if (k < i) {}
    for (paramInt1 = i - k;; paramInt1 = k - j)
    {
      paramInt1 += 1;
      break;
      if (k <= j) {
        break label192;
      }
    }
    if (paramInt1 > 0) {
      this.d = (paramInt3 * (paramInt1 / (j - i)));
    } else {
      this.d = paramInt3;
    }
    this.b = k;
    c(this.b, paramInt2, this.d);
    return;
    label192:
    b(k, paramInt3);
  }
  
  @TargetApi(16)
  void a(Runnable paramRunnable)
  {
    try
    {
      if (Build.VERSION.SDK_INT >= 16)
      {
        this.this$0.postOnAnimation(paramRunnable);
        return;
      }
      this.this$0.post(this);
      return;
    }
    catch (Exception paramRunnable)
    {
      paramRunnable.printStackTrace();
    }
  }
  
  void b(int paramInt1, int paramInt2)
  {
    c(paramInt1, 0, paramInt2);
  }
  
  void b(int paramInt1, int paramInt2, int paramInt3)
  {
    a();
    if (this.this$0.g)
    {
      this.this$0.u = new HorizontalListView.PositionScroller.2(this, paramInt1, paramInt2, paramInt3);
      return;
    }
    int j = this.this$0.getChildCount();
    if (j == 0) {
      return;
    }
    if (!this.this$0.t) {
      i = this.this$0.getPaddingLeft();
    } else {
      i = this.this$0.getPaddingRight();
    }
    paramInt2 += i;
    this.b = Math.max(0, Math.min(this.this$0.f.getCount() - 1, paramInt1));
    this.e = paramInt2;
    this.c = -1;
    this.a = 5;
    if (!this.this$0.t) {
      paramInt1 = this.this$0.m;
    } else {
      paramInt1 = this.this$0.n;
    }
    int i = paramInt1 + j - 1;
    int k = this.b;
    if (k < paramInt1)
    {
      paramInt1 -= k;
    }
    else
    {
      if (k <= i) {
        break label236;
      }
      paramInt1 = k - i;
    }
    float f = paramInt1 / j;
    if (f >= 1.0F) {
      paramInt3 = (int)(paramInt3 / f);
    }
    this.d = paramInt3;
    this.c = -1;
    a(this);
    return;
    label236:
    View localView = this.this$0.getChildAt(k - paramInt1);
    if (!this.this$0.t) {
      paramInt1 = -localView.getLeft();
    } else {
      paramInt1 = this.this$0.getWidth() - localView.getRight();
    }
    this.this$0.d(paramInt1 - paramInt2, paramInt3);
  }
  
  void c(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = this.this$0.m;
    int j = this.this$0.getChildCount();
    View localView = this.this$0.getChildAt(0);
    if ((paramInt1 >= i) && (paramInt1 <= j + i - 1)) {
      paramInt1 = this.this$0.getChildAt(paramInt1 - i).getLeft() - Math.abs(localView.getLeft());
    } else {
      paramInt1 = (paramInt1 - i) * (this.this$0.getChildAt(1).getLeft() - localView.getLeft()) + localView.getLeft();
    }
    if (paramInt1 == 0) {
      return;
    }
    this.this$0.d(-(paramInt1 + paramInt2), paramInt3);
  }
  
  public void run()
  {
    if (!this.this$0.t) {
      j = this.this$0.m;
    } else {
      j = this.this$0.n;
    }
    if (this.a != 5) {
      return;
    }
    if (this.c == j)
    {
      a(this);
      return;
    }
    this.c = j;
    int i1 = this.this$0.getChildCount();
    int m = this.b;
    int k = 1;
    int n = j + i1 - 1;
    int i = 0;
    if (m < j) {
      i = j - m + 1;
    } else if (m > n) {
      i = m - n;
    }
    float f = Math.min(Math.abs(i / i1), 1.0F);
    if (!this.this$0.t) {
      i = k;
    } else {
      i = -1;
    }
    f *= i;
    if (m < j)
    {
      i = (int)(this.this$0.getWidth() * f);
      j = (int)(this.d * Math.abs(f));
      this.this$0.d(i, j);
      a(this);
      return;
    }
    if (m > n)
    {
      i = (int)(-this.this$0.getWidth() * f);
      j = (int)(this.d * Math.abs(f));
      this.this$0.d(i, j);
      a(this);
      return;
    }
    View localView = this.this$0.getChildAt(m - j);
    if (!this.this$0.t) {
      i = -localView.getLeft();
    } else {
      i = this.this$0.getWidth() - localView.getRight();
    }
    i -= this.e;
    int j = (int)(this.d * (Math.abs(i) / this.this$0.getWidth()));
    this.this$0.d(i, j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.view.HorizontalListView.PositionScroller
 * JD-Core Version:    0.7.0.1
 */