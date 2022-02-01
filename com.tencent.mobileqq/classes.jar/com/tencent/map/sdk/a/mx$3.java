package com.tencent.map.sdk.a;

import android.view.View;
import android.view.ViewGroup;

final class mx$3
  implements Runnable
{
  mx$3(mx parammx) {}
  
  public final void run()
  {
    if (this.a.d.getParent() != null)
    {
      ((ViewGroup)this.a.d.getParent()).removeView(this.a.d);
      if ((this.a.d instanceof ViewGroup)) {
        ((ViewGroup)this.a.d).removeAllViews();
      }
    }
    this.a.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.a.mx.3
 * JD-Core Version:    0.7.0.1
 */