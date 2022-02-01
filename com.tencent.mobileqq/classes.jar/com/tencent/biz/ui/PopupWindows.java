package com.tencent.biz.ui;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;

public class PopupWindows
{
  protected Context b;
  protected PopupWindow c;
  protected View d;
  protected Drawable e = null;
  protected WindowManager f;
  
  public PopupWindows(Context paramContext)
  {
    this.b = paramContext;
    this.c = new PopupWindow(paramContext);
    this.c.setTouchInterceptor(new PopupWindows.1(this));
    this.f = ((WindowManager)paramContext.getSystemService("window"));
  }
  
  protected void a()
  {
    if (this.d != null)
    {
      Drawable localDrawable = this.e;
      if (localDrawable == null) {
        this.c.setBackgroundDrawable(new BitmapDrawable());
      } else {
        this.c.setBackgroundDrawable(localDrawable);
      }
      this.c.setWidth(-2);
      this.c.setHeight(-2);
      this.c.setTouchable(true);
      this.c.setFocusable(false);
      this.c.setOutsideTouchable(true);
      this.c.setContentView(this.d);
      return;
    }
    throw new IllegalStateException("setContentView was not called with a view to display.");
  }
  
  public void a(PopupWindow.OnDismissListener paramOnDismissListener)
  {
    this.c.setOnDismissListener(paramOnDismissListener);
  }
  
  public void b()
  {
    this.c.dismiss();
  }
  
  public void b(View paramView)
  {
    this.d = paramView;
    this.c.setContentView(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.ui.PopupWindows
 * JD-Core Version:    0.7.0.1
 */