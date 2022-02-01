package com.tencent.mm.plugin.appbrand.jsapi.video.progressbar;

import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;

class a$2
  implements Runnable
{
  a$2(a parama) {}
  
  public void run()
  {
    int i = (this.a.getBarPointWidth() - this.a.e.getPaddingLeft() - this.a.e.getPaddingRight()) / 2;
    int j = ((FrameLayout.LayoutParams)this.a.d.getLayoutParams()).leftMargin;
    int k = this.a.e.getPaddingLeft();
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.a.e.getLayoutParams();
    localLayoutParams.leftMargin = (j - k - i);
    this.a.e.setLayoutParams(localLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.progressbar.a.2
 * JD-Core Version:    0.7.0.1
 */