package com.google.android.material.floatingactionbutton;

import android.view.ViewGroup.LayoutParams;

class ExtendedFloatingActionButton$1
  implements ExtendedFloatingActionButton.Size
{
  ExtendedFloatingActionButton$1(ExtendedFloatingActionButton paramExtendedFloatingActionButton) {}
  
  public int a()
  {
    return this.a.getMeasuredWidth() - this.a.d() * 2 + ExtendedFloatingActionButton.a(this.a) + ExtendedFloatingActionButton.b(this.a);
  }
  
  public ViewGroup.LayoutParams a()
  {
    return new ViewGroup.LayoutParams(-2, -2);
  }
  
  public int b()
  {
    return this.a.getMeasuredHeight();
  }
  
  public int c()
  {
    return ExtendedFloatingActionButton.a(this.a);
  }
  
  public int d()
  {
    return ExtendedFloatingActionButton.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.1
 * JD-Core Version:    0.7.0.1
 */