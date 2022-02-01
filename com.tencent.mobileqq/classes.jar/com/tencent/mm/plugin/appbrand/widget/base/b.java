package com.tencent.mm.plugin.appbrand.widget.base;

import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;

final class b
  implements Iterator<View>
{
  private final ViewGroup a;
  private int b = 0;
  
  b(ViewGroup paramViewGroup)
  {
    this.a = paramViewGroup;
  }
  
  public View a()
  {
    ViewGroup localViewGroup = this.a;
    int i = this.b;
    this.b = (i + 1);
    return localViewGroup.getChildAt(i);
  }
  
  public boolean hasNext()
  {
    return this.b < this.a.getChildCount();
  }
  
  public void remove()
  {
    this.a.removeViewAt(this.b - 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.base.b
 * JD-Core Version:    0.7.0.1
 */