package com.tencent.mobileqq.activity.contact.troop;

import alud;
import android.widget.TextView;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.TroopMemberCard;

class ShowExternalTroopListActivity$3$1
  implements Runnable
{
  ShowExternalTroopListActivity$3$1(ShowExternalTroopListActivity.3 param3, String paramString, Card paramCard) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopShowExternalTroopListActivity$3.a.setText(this.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopShowExternalTroopListActivity$3.this$0.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopShowExternalTroopListActivity$3.b.setText(alud.a(2131714490));
    }
    do
    {
      TroopMemberCard localTroopMemberCard;
      do
      {
        return;
        this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopShowExternalTroopListActivity$3.b.setText(alud.a(2131714489));
        if (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopShowExternalTroopListActivity$3.this$0.b == null) {
          break;
        }
        localTroopMemberCard = this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopShowExternalTroopListActivity$3.this$0.jdField_a_of_type_ComTencentMobileqqAppTroopManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopShowExternalTroopListActivity$3.this$0.b, this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopShowExternalTroopListActivity$3.this$0.jdField_a_of_type_JavaLangString);
      } while (localTroopMemberCard == null);
      if (localTroopMemberCard.sex == 1) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopShowExternalTroopListActivity$3.b.setText(alud.a(2131714491));
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopShowExternalTroopListActivity$3.a.setText(localTroopMemberCard.nick);
      return;
    } while ((this.jdField_a_of_type_ComTencentMobileqqDataCard == null) || (this.jdField_a_of_type_ComTencentMobileqqDataCard.shGender != 1));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopShowExternalTroopListActivity$3.b.setText(alud.a(2131714492));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.ShowExternalTroopListActivity.3.1
 * JD-Core Version:    0.7.0.1
 */