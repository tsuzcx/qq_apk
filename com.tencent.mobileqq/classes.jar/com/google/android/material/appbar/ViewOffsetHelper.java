package com.google.android.material.appbar;

import android.view.View;
import androidx.core.view.ViewCompat;

class ViewOffsetHelper
{
  private final View a;
  private int b;
  private int c;
  private int d;
  private int e;
  private boolean f = true;
  private boolean g = true;
  
  public ViewOffsetHelper(View paramView)
  {
    this.a = paramView;
  }
  
  void a()
  {
    this.b = this.a.getTop();
    this.c = this.a.getLeft();
  }
  
  public boolean a(int paramInt)
  {
    if ((this.f) && (this.d != paramInt))
    {
      this.d = paramInt;
      b();
      return true;
    }
    return false;
  }
  
  void b()
  {
    View localView = this.a;
    ViewCompat.offsetTopAndBottom(localView, this.d - (localView.getTop() - this.b));
    localView = this.a;
    ViewCompat.offsetLeftAndRight(localView, this.e - (localView.getLeft() - this.c));
  }
  
  public boolean b(int paramInt)
  {
    if ((this.g) && (this.e != paramInt))
    {
      this.e = paramInt;
      b();
      return true;
    }
    return false;
  }
  
  public int c()
  {
    return this.d;
  }
  
  public int d()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.appbar.ViewOffsetHelper
 * JD-Core Version:    0.7.0.1
 */