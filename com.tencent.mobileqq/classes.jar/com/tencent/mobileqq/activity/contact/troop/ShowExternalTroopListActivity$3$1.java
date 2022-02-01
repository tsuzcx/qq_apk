package com.tencent.mobileqq.activity.contact.troop;

import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.troop.TroopMemberCard;
import com.tencent.mobileqq.troop.api.IBizTroopMemberInfoService;

class ShowExternalTroopListActivity$3$1
  implements Runnable
{
  ShowExternalTroopListActivity$3$1(ShowExternalTroopListActivity.3 param3, String paramString, Card paramCard) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopShowExternalTroopListActivity$3.a.setText(this.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopShowExternalTroopListActivity$3.this$0.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopShowExternalTroopListActivity$3.b.setText(HardCodeUtil.a(2131713975));
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopShowExternalTroopListActivity$3.b.setText(HardCodeUtil.a(2131713974));
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopShowExternalTroopListActivity$3.this$0.b != null)
    {
      localObject = ((IBizTroopMemberInfoService)this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopShowExternalTroopListActivity$3.this$0.app.getRuntimeService(IBizTroopMemberInfoService.class, "")).getTroopMemberCard(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopShowExternalTroopListActivity$3.this$0.b, this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopShowExternalTroopListActivity$3.this$0.jdField_a_of_type_JavaLangString);
      if (localObject != null)
      {
        if (((TroopMemberCard)localObject).sex == 1) {
          this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopShowExternalTroopListActivity$3.b.setText(HardCodeUtil.a(2131713976));
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopShowExternalTroopListActivity$3.a.setText(((TroopMemberCard)localObject).nick);
      }
    }
    else
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqDataCard;
      if ((localObject != null) && (((Card)localObject).shGender == 1)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopShowExternalTroopListActivity$3.b.setText(HardCodeUtil.a(2131713977));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.ShowExternalTroopListActivity.3.1
 * JD-Core Version:    0.7.0.1
 */