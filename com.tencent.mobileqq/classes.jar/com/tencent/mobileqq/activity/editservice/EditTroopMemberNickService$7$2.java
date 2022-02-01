package com.tencent.mobileqq.activity.editservice;

import android.content.Intent;
import com.tencent.mobileqq.data.troop.TroopMemberCard;
import com.tencent.mobileqq.troop.activity.editinfo.IEditInfoActivity;

class EditTroopMemberNickService$7$2
  implements Runnable
{
  EditTroopMemberNickService$7$2(EditTroopMemberNickService.7 param7, TroopMemberCard paramTroopMemberCard) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberCard != null)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("result", this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberCard.colorCard);
      localIntent.putExtra("edit_action", this.jdField_a_of_type_ComTencentMobileqqActivityEditserviceEditTroopMemberNickService$7.a.d);
      EditTroopMemberNickService.a(this.jdField_a_of_type_ComTencentMobileqqActivityEditserviceEditTroopMemberNickService$7.a).onFinishForResult(-1, localIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.editservice.EditTroopMemberNickService.7.2
 * JD-Core Version:    0.7.0.1
 */