package com.tencent.mobileqq.activity;

import acyz;
import android.os.Message;
import bhtd;
import com.tencent.mobileqq.data.Card;

public class FriendProfileCardActivity$13$1
  implements Runnable
{
  public FriendProfileCardActivity$13$1(acyz paramacyz, Card paramCard) {}
  
  public void run()
  {
    boolean bool = this.jdField_a_of_type_Acyz.a.a((int)this.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId, (int)this.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentBgId, this.jdField_a_of_type_ComTencentMobileqqDataCard.backgroundUrl, (int)this.jdField_a_of_type_ComTencentMobileqqDataCard.backgroundColor, this.jdField_a_of_type_ComTencentMobileqqDataCard.templateRet, this.jdField_a_of_type_ComTencentMobileqqDataCard.diyComplicatedInfo, this.jdField_a_of_type_ComTencentMobileqqDataCard.cardId);
    Message localMessage = this.jdField_a_of_type_Acyz.a.b.obtainMessage(13, Boolean.valueOf(bool));
    this.jdField_a_of_type_Acyz.a.b.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileCardActivity.13.1
 * JD-Core Version:    0.7.0.1
 */