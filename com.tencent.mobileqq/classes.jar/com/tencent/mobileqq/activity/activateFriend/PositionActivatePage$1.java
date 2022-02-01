package com.tencent.mobileqq.activity.activateFriend;

import android.widget.Button;

class PositionActivatePage$1
  implements ActivateFriendGrid.GridCallBack
{
  PositionActivatePage$1(PositionActivatePage paramPositionActivatePage) {}
  
  public void a(int paramInt)
  {
    if (paramInt > 0) {
      this.a.a.setEnabled(true);
    } else {
      this.a.a.setEnabled(false);
    }
    if (paramInt > 1)
    {
      this.a.a.setText(2131689557);
      return;
    }
    this.a.a.setText(2131689558);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.PositionActivatePage.1
 * JD-Core Version:    0.7.0.1
 */