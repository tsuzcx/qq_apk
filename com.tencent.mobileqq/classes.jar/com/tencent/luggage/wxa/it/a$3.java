package com.tencent.luggage.wxa.it;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;

class a$3
  implements View.OnKeyListener
{
  a$3(a parama) {}
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (paramKeyEvent.getAction() == 0) && (this.a.d()))
    {
      this.a.e();
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.it.a.3
 * JD-Core Version:    0.7.0.1
 */