package com.tencent.mobileqq.activity;

import adff;
import android.content.Intent;
import com.tencent.mobileqq.data.TroopMemberCard;

public class EditInfoActivity$14$2
  implements Runnable
{
  public EditInfoActivity$14$2(adff paramadff, TroopMemberCard paramTroopMemberCard) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard != null)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("nick", this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.colorCard);
      localIntent.putExtra("edit_action", this.jdField_a_of_type_Adff.a.g);
      this.jdField_a_of_type_Adff.a.setResult(-1, localIntent);
      EditInfoActivity.e(this.jdField_a_of_type_Adff.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.EditInfoActivity.14.2
 * JD-Core Version:    0.7.0.1
 */