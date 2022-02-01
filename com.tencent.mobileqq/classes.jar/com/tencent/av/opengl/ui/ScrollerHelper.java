package com.tencent.av.opengl.ui;

import android.content.Context;
import android.view.ViewConfiguration;
import com.tencent.av.opengl.utils.Utils;

public class ScrollerHelper
{
  private OverScroller a;
  private int b;
  private boolean c;
  
  public ScrollerHelper(Context paramContext)
  {
    this.a = new OverScroller(paramContext);
    this.b = ViewConfiguration.get(paramContext).getScaledOverflingDistance();
  }
  
  public void a(int paramInt)
  {
    this.b = Math.max(paramInt, this.b);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    int j = c();
    OverScroller localOverScroller = this.a;
    int i;
    if (this.c) {
      i = this.b;
    } else {
      i = 0;
    }
    localOverScroller.a(j, 0, paramInt1, 0, paramInt2, paramInt3, 0, 0, i, 0);
  }
  
  public void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public boolean a()
  {
    return this.a.a();
  }
  
  public boolean a(long paramLong)
  {
    return this.a.d();
  }
  
  public int b(int paramInt1, int paramInt2, int paramInt3)
  {
    int j = this.a.b();
    int i;
    if (this.a.a()) {
      i = j;
    } else {
      i = this.a.c();
    }
    paramInt1 = i + paramInt1;
    paramInt2 = Utils.a(paramInt1, paramInt2, paramInt3);
    if (paramInt2 != j) {
      this.a.a(j, 0, paramInt2 - j, 0, 0);
    }
    return paramInt1 - paramInt2;
  }
  
  public void b()
  {
    this.a.a(true);
  }
  
  public void b(int paramInt)
  {
    this.a.a(paramInt, 0, 0, 0, 0);
    this.a.e();
  }
  
  public int c()
  {
    return this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.opengl.ui.ScrollerHelper
 * JD-Core Version:    0.7.0.1
 */