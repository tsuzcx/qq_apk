package com.tencent.mobileqq.activity.contact.troop;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;

class TroopActivity$3
  implements Runnable
{
  TroopActivity$3(TroopActivity paramTroopActivity, View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void run()
  {
    Object localObject = new Rect();
    this.a.setEnabled(true);
    this.a.getHitRect((Rect)localObject);
    ((Rect)localObject).top -= this.b;
    ((Rect)localObject).bottom += this.c;
    ((Rect)localObject).left -= this.d;
    ((Rect)localObject).right += this.e;
    localObject = new TouchDelegate((Rect)localObject, this.a);
    if (View.class.isInstance(this.a.getParent())) {
      ((View)this.a.getParent()).setTouchDelegate((TouchDelegate)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopActivity.3
 * JD-Core Version:    0.7.0.1
 */