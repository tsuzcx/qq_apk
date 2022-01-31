package com.tencent.mobileqq.activity;

import acyw;
import alto;
import awqt;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;

public class FriendProfileCardActivity$12$1
  implements Runnable
{
  public FriendProfileCardActivity$12$1(acyw paramacyw) {}
  
  public void run()
  {
    Card localCard = ((alto)this.a.a.app.getManager(51)).b(this.a.a.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a);
    this.a.a.a.jdField_a_of_type_ComTencentMobileqqDataCard = localCard;
    if (localCard != null) {
      this.a.a.runOnUiThread(new FriendProfileCardActivity.12.1.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileCardActivity.12.1
 * JD-Core Version:    0.7.0.1
 */