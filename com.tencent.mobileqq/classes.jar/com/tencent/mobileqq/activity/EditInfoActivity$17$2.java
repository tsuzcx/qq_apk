package com.tencent.mobileqq.activity;

import adwk;
import android.content.Intent;
import com.tencent.mobileqq.data.TroopMemberCard;

public class EditInfoActivity$17$2
  implements Runnable
{
  public EditInfoActivity$17$2(adwk paramadwk, TroopMemberCard paramTroopMemberCard) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard != null)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("nick", this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.colorCard);
      localIntent.putExtra("edit_action", this.jdField_a_of_type_Adwk.a.h);
      this.jdField_a_of_type_Adwk.a.setResult(-1, localIntent);
      EditInfoActivity.e(this.jdField_a_of_type_Adwk.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.EditInfoActivity.17.2
 * JD-Core Version:    0.7.0.1
 */