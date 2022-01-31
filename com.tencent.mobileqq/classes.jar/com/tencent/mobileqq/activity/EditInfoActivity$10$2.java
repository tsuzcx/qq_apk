package com.tencent.mobileqq.activity;

import acqw;
import android.content.Intent;
import com.tencent.mobileqq.data.TroopMemberCard;

public class EditInfoActivity$10$2
  implements Runnable
{
  public EditInfoActivity$10$2(acqw paramacqw, TroopMemberCard paramTroopMemberCard) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard != null)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("nick", this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.colorCard);
      localIntent.putExtra("edit_action", this.jdField_a_of_type_Acqw.a.g);
      this.jdField_a_of_type_Acqw.a.setResult(-1, localIntent);
      EditInfoActivity.d(this.jdField_a_of_type_Acqw.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.EditInfoActivity.10.2
 * JD-Core Version:    0.7.0.1
 */