package com.bumptech.glide;

import android.support.annotation.Nullable;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import java.util.List;

public class ListPreloader<T>
  implements AbsListView.OnScrollListener
{
  private final int a;
  private final ListPreloader.PreloadTargetQueue b;
  private final RequestManager c;
  private final ListPreloader.PreloadModelProvider<T> d;
  private final ListPreloader.PreloadSizeProvider<T> e;
  private int f;
  private int g;
  private int h;
  private int i;
  private boolean j;
  
  private void a()
  {
    int k = 0;
    while (k < this.a)
    {
      this.c.a(this.b.a(0, 0));
      k += 1;
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 < paramInt2)
    {
      k = Math.max(this.f, paramInt1);
      m = paramInt2;
    }
    else
    {
      m = Math.min(this.g, paramInt1);
      k = paramInt2;
    }
    int m = Math.min(this.i, m);
    int k = Math.min(this.i, Math.max(0, k));
    if (paramInt1 < paramInt2)
    {
      paramInt1 = k;
      while (paramInt1 < m)
      {
        a(this.d.a(paramInt1), paramInt1, true);
        paramInt1 += 1;
      }
    }
    paramInt1 = m - 1;
    while (paramInt1 >= k)
    {
      a(this.d.a(paramInt1), paramInt1, false);
      paramInt1 -= 1;
    }
    this.g = k;
    this.f = m;
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    if (this.j != paramBoolean)
    {
      this.j = paramBoolean;
      a();
    }
    int k;
    if (paramBoolean) {
      k = this.a;
    } else {
      k = -this.a;
    }
    a(paramInt, k + paramInt);
  }
  
  private void a(@Nullable T paramT, int paramInt1, int paramInt2)
  {
    if (paramT == null) {
      return;
    }
    int[] arrayOfInt = this.e.a(paramT, paramInt1, paramInt2);
    if (arrayOfInt == null) {
      return;
    }
    paramT = this.d.a(paramT);
    if (paramT == null) {
      return;
    }
    paramT.a(this.b.a(arrayOfInt[0], arrayOfInt[1]));
  }
  
  private void a(List<T> paramList, int paramInt, boolean paramBoolean)
  {
    int m = paramList.size();
    if (paramBoolean)
    {
      k = 0;
      while (k < m)
      {
        a(paramList.get(k), paramInt, k);
        k += 1;
      }
    }
    int k = m - 1;
    while (k >= 0)
    {
      a(paramList.get(k), paramInt, k);
      k -= 1;
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.i = paramInt3;
    paramInt3 = this.h;
    if (paramInt1 > paramInt3) {
      a(paramInt2 + paramInt1, true);
    } else if (paramInt1 < paramInt3) {
      a(paramInt1, false);
    }
    this.h = paramInt1;
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.ListPreloader
 * JD-Core Version:    0.7.0.1
 */