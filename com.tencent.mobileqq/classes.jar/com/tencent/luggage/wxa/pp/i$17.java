package com.tencent.luggage.wxa.pp;

import android.view.KeyEvent;

class i$17
  implements ac.b
{
  i$17(i parami) {}
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 67)
    {
      if (ak.b(i.d(this.a).getText())) {
        return false;
      }
      paramKeyEvent = this.a;
      paramKeyEvent.a(i.d(paramKeyEvent).getText().toString());
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pp.i.17
 * JD-Core Version:    0.7.0.1
 */