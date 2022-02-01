package com.tencent.mm.plugin.appbrand.widget.actionbar;

import android.graphics.drawable.ColorDrawable;

final class d$a
  extends ColorDrawable
{
  d$a(d paramd, int paramInt)
  {
    super(paramInt);
  }
  
  private void a()
  {
    this.a.setStatusBarColor(getColor());
  }
  
  public void setAlpha(int paramInt)
  {
    super.setAlpha(paramInt);
    a();
  }
  
  public void setColor(int paramInt)
  {
    super.setColor(paramInt);
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.actionbar.d.a
 * JD-Core Version:    0.7.0.1
 */