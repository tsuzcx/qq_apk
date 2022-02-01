package com.tencent.mobileqq.activity.contact.addcontact.findtroop;

import android.os.Build.VERSION;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

class TroopView$6
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  TroopView$6(TroopView paramTroopView) {}
  
  public void onGlobalLayout()
  {
    if (Build.VERSION.SDK_INT < 16) {
      this.a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    }
    for (;;)
    {
      TroopView.a(this.a);
      return;
      this.a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.findtroop.TroopView.6
 * JD-Core Version:    0.7.0.1
 */