package com.tencent.mobileqq.activity.activateFriend;

import android.widget.Button;

class PositionActivatePage$1
  implements ActivateFriendGrid.GridCallBack
{
  PositionActivatePage$1(PositionActivatePage paramPositionActivatePage) {}
  
  public void a(int paramInt)
  {
    if (paramInt > 0) {
      this.a.f.setEnabled(true);
    } else {
      this.a.f.setEnabled(false);
    }
    if (paramInt > 1)
    {
      this.a.f.setText(2131886167);
      return;
    }
    this.a.f.setText(2131886168);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.PositionActivatePage.1
 * JD-Core Version:    0.7.0.1
 */