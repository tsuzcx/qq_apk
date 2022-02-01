package com.tencent.mobileqq.activity.activateFriend;

import android.widget.EditText;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsObserver;
import com.tencent.widget.XPanelContainer;
import mqq.os.MqqHandler;

class SendBirthdayWishesActivity$2
  extends ActivateFriendsObserver
{
  SendBirthdayWishesActivity$2(SendBirthdayWishesActivity paramSendBirthdayWishesActivity) {}
  
  public void a(int paramInt)
  {
    this.a.b();
    SendBirthdayWishesActivity.a(this.a, paramInt);
    this.a.d.removeTextChangedListener(this.a);
    this.a.d.setText("");
    if (this.a.e.getCurrentPanel() != 0) {
      this.a.e.b();
    }
    if (paramInt != 2)
    {
      SendBirthdayWishesActivity.b(this.a).removeCallbacks(SendBirthdayWishesActivity.a(this.a));
      SendBirthdayWishesActivity.b(this.a).postDelayed(SendBirthdayWishesActivity.a(this.a), 600L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.SendBirthdayWishesActivity.2
 * JD-Core Version:    0.7.0.1
 */