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
    this.a.jdField_a_of_type_AndroidWidgetEditText.removeTextChangedListener(this.a);
    this.a.jdField_a_of_type_AndroidWidgetEditText.setText("");
    if (this.a.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() != 0) {
      this.a.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
    }
    if (paramInt != 2)
    {
      SendBirthdayWishesActivity.a(this.a).removeCallbacks(SendBirthdayWishesActivity.a(this.a));
      SendBirthdayWishesActivity.a(this.a).postDelayed(SendBirthdayWishesActivity.a(this.a), 600L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.SendBirthdayWishesActivity.2
 * JD-Core Version:    0.7.0.1
 */