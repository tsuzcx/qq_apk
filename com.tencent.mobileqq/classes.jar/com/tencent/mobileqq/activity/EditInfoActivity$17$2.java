package com.tencent.mobileqq.activity;

import android.content.Intent;
import com.tencent.mobileqq.data.troop.TroopMemberCard;

class EditInfoActivity$17$2
  implements Runnable
{
  EditInfoActivity$17$2(EditInfoActivity.17 param17, TroopMemberCard paramTroopMemberCard) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberCard != null)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("nick", this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberCard.colorCard);
      localIntent.putExtra("edit_action", this.jdField_a_of_type_ComTencentMobileqqActivityEditInfoActivity$17.a.h);
      this.jdField_a_of_type_ComTencentMobileqqActivityEditInfoActivity$17.a.setResult(-1, localIntent);
      EditInfoActivity.e(this.jdField_a_of_type_ComTencentMobileqqActivityEditInfoActivity$17.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.EditInfoActivity.17.2
 * JD-Core Version:    0.7.0.1
 */