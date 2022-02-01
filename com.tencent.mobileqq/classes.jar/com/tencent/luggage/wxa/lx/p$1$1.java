package com.tencent.luggage.wxa.lx;

import android.app.Activity;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.tencent.luggage.wxa.iu.c.c;
import com.tencent.luggage.wxa.iu.c.d;

class p$1$1
  extends c.c
{
  p$1$1(p.1 param1, WindowManager.LayoutParams paramLayoutParams, Activity paramActivity) {}
  
  public void a(c.d paramd)
  {
    this.a.screenBrightness = p.b(this.c.d);
    paramd = this.b;
    if ((paramd != null) && (!paramd.isFinishing()) && (this.b.getWindow() != null)) {
      this.b.getWindow().setAttributes(this.a);
    }
  }
  
  public void b()
  {
    this.a.screenBrightness = p.a(this.c.d);
    Activity localActivity = this.b;
    if ((localActivity != null) && (!localActivity.isFinishing()) && (this.b.getWindow() != null)) {
      this.b.getWindow().setAttributes(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lx.p.1.1
 * JD-Core Version:    0.7.0.1
 */