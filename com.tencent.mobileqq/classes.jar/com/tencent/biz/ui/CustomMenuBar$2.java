package com.tencent.biz.ui;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;

class CustomMenuBar$2
  implements View.OnTouchListener
{
  CustomMenuBar$2(CustomMenuBar paramCustomMenuBar, ImageView paramImageView) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() == 0) && (this.b.g))
    {
      this.b.j.removeCallbacks(this.b.k);
      this.b.h.setVisibility(4);
      this.a.setImageResource(2130844348);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.ui.CustomMenuBar.2
 * JD-Core Version:    0.7.0.1
 */