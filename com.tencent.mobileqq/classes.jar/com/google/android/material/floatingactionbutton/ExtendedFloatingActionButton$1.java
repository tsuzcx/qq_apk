package com.google.android.material.floatingactionbutton;

import android.view.ViewGroup.LayoutParams;

class ExtendedFloatingActionButton$1
  implements ExtendedFloatingActionButton.Size
{
  ExtendedFloatingActionButton$1(ExtendedFloatingActionButton paramExtendedFloatingActionButton) {}
  
  public int a()
  {
    return this.a.getMeasuredWidth() - this.a.getCollapsedPadding() * 2 + ExtendedFloatingActionButton.a(this.a) + ExtendedFloatingActionButton.b(this.a);
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
  
  public ViewGroup.LayoutParams e()
  {
    return new ViewGroup.LayoutParams(-2, -2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.1
 * JD-Core Version:    0.7.0.1
 */