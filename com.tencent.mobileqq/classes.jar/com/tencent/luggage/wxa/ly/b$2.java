package com.tencent.luggage.wxa.ly;

import android.view.View;
import android.view.View.OnSystemUiVisibilityChangeListener;
import android.view.Window;

class b$2
  implements View.OnSystemUiVisibilityChangeListener
{
  b$2(b paramb, Window paramWindow, int paramInt) {}
  
  public void onSystemUiVisibilityChange(int paramInt)
  {
    if ((paramInt & 0x4) == 0) {
      this.a.getDecorView().setSystemUiVisibility(this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ly.b.2
 * JD-Core Version:    0.7.0.1
 */