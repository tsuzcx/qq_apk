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
    } else {
      this.a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }
    TroopView.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.findtroop.TroopView.6
 * JD-Core Version:    0.7.0.1
 */