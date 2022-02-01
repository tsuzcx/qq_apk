package com.tencent.luggage.wxa.ji;

import android.view.View;
import android.view.ViewParent;

class d$1
  implements Runnable
{
  d$1(d paramd) {}
  
  public void run()
  {
    Object localObject = this.a.getParent();
    ViewParent localViewParent;
    do
    {
      ((View)localObject).forceLayout();
      localViewParent = ((ViewParent)localObject).getParent();
      localObject = localViewParent;
    } while ((localViewParent instanceof View));
    if (localViewParent != null)
    {
      localViewParent.requestLayout();
      this.a.invalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ji.d.1
 * JD-Core Version:    0.7.0.1
 */