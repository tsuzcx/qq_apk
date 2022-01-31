package com.tencent.mobileqq.activity;

import abdo;
import android.os.Message;
import bfnk;
import com.tencent.mobileqq.data.Card;

public class FriendProfileCardActivity$12$1
  implements Runnable
{
  public FriendProfileCardActivity$12$1(abdo paramabdo, Card paramCard) {}
  
  public void run()
  {
    boolean bool = this.jdField_a_of_type_Abdo.a.a((int)this.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId, (int)this.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentBgId, this.jdField_a_of_type_ComTencentMobileqqDataCard.backgroundUrl, (int)this.jdField_a_of_type_ComTencentMobileqqDataCard.backgroundColor, this.jdField_a_of_type_ComTencentMobileqqDataCard.templateRet, this.jdField_a_of_type_ComTencentMobileqqDataCard.diyComplicatedInfo, this.jdField_a_of_type_ComTencentMobileqqDataCard.cardId);
    Message localMessage = this.jdField_a_of_type_Abdo.a.b.obtainMessage(13, Boolean.valueOf(bool));
    this.jdField_a_of_type_Abdo.a.b.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileCardActivity.12.1
 * JD-Core Version:    0.7.0.1
 */