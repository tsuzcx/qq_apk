package com.tencent.biz.ui;

import android.content.res.Resources;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;

class CustomMenuBar$1
  implements PopupWindow.OnDismissListener
{
  CustomMenuBar$1(CustomMenuBar paramCustomMenuBar, ImageView paramImageView, TextView paramTextView) {}
  
  public void onDismiss()
  {
    this.a.setImageResource(2130844348);
    if (CustomMenuBar.a()) {
      this.b.setTextColor(this.c.getResources().getColor(2131166823));
    } else {
      this.b.setTextColor(this.c.getResources().getColor(2131166822));
    }
    CustomMenuBar localCustomMenuBar = this.c;
    localCustomMenuBar.f = false;
    localCustomMenuBar.g = true;
    localCustomMenuBar.j.removeCallbacks(this.c.k);
    this.c.j.postDelayed(this.c.k, 50L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.ui.CustomMenuBar.1
 * JD-Core Version:    0.7.0.1
 */