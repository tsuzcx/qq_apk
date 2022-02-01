package com.tencent.mobileqq.activity.aio.item;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

class ArkAppRootLayout$1
  extends GestureDetector.SimpleOnGestureListener
{
  ArkAppRootLayout$1(ArkAppRootLayout paramArkAppRootLayout) {}
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    if (ArkAppRootLayout.a(this.a) != null) {
      ArkAppRootLayout.a(this.a).a();
    }
    return super.onSingleTapUp(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ArkAppRootLayout.1
 * JD-Core Version:    0.7.0.1
 */