package com.tencent.mobileqq.adapter;

import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

class AvatarPendantAdapter$2$1
  implements Runnable
{
  AvatarPendantAdapter$2$1(AvatarPendantAdapter.2 param2, TextView paramTextView, int paramInt) {}
  
  public void run()
  {
    int i = this.a.getWidth();
    int j = this.b;
    this.a.setLayoutParams(new LinearLayout.LayoutParams(i - j, -2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.AvatarPendantAdapter.2.1
 * JD-Core Version:    0.7.0.1
 */