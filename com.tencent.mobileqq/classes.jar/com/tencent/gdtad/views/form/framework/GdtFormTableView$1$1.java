package com.tencent.gdtad.views.form.framework;

import acwz;
import android.view.ViewTreeObserver;

public class GdtFormTableView$1$1
  implements Runnable
{
  public GdtFormTableView$1$1(acwz paramacwz) {}
  
  public void run()
  {
    if ((GdtFormTableView.a(this.a.a) != null) && (this.a.a.getViewTreeObserver() != null))
    {
      this.a.a.getViewTreeObserver().removeOnGlobalLayoutListener(GdtFormTableView.a(this.a.a));
      GdtFormTableView.a(this.a.a, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.gdtad.views.form.framework.GdtFormTableView.1.1
 * JD-Core Version:    0.7.0.1
 */