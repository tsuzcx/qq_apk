package com.tencent.mm.ui;

import android.app.Activity;
import android.view.View;
import android.view.Window;

class c$1
  implements Runnable
{
  c$1(c paramc, Activity paramActivity) {}
  
  public void run()
  {
    this.a.getWindow().getDecorView().setOnApplyWindowInsetsListener(new c.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.c.1
 * JD-Core Version:    0.7.0.1
 */